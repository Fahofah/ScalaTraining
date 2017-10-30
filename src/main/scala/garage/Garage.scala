package garage

import java.util.Calendar

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class Garage {

  val customerList = scala.collection.mutable.MutableList[Customer]()
  val employeeList = scala.collection.mutable.MutableList[Employee]()
  var carList = scala.collection.mutable.MutableList[Car]()
  var bikeList = scala.collection.mutable.MutableList[Bike]()
  var bills = scala.collection.mutable.Map[Int, Int]()
//    val vehicleList = scala.collection.mutable.MutableList[Vehicle]() CANT ACCESS ATTRIBUTES IF LIST TYPE PARENT!!!
  val basePriceCar = 100
  val basePriceBike = 50

  def addCustomer: Unit ={
    println("Please enter the full name of the new Customer:\n")
    val newCustomer = Customer(readLine())
    customerList += newCustomer
    println(s"New customer added with ID #${newCustomer.ID}")
  }

  def addEmployee: Unit = {

    println("New Employee Full Name:\n ")
    val empName = readLine()
    println(s"$empName's new role:\n")
    val empRole = readLine()
    employeeList += Employee(empName,empRole)

  }

  def addCar: Unit ={

    println("Enter owner name or ID")
    val ownerID = getCustomerID(readLine())
    if(ownerID == -1) println("Customer not in database")
    else {
      val details = getDetails("Car")
      val newCar = new Car(ownerID,details{0},details{1},details{2},details{3},details{4}.toInt,Calendar.getInstance().getTime.toString)
      carList += newCar
      newCar.addParts
    }
  }

  def addBike: Unit ={
    println("Enter owner name or ID")
    val ownerID = getCustomerID(readLine())
    if(ownerID == -1) println("Customer not in database")
    else {
      val details = getDetails("Bike")
      bikeList += new Bike(ownerID,details{0},details{1},details{2},details{3},Calendar.getInstance().getTime.toString)
    }
  }


  def fixVehicle(id: Int, vehType: String,model : Option[String] = None): Unit = {
    vehType match {
      case "car" =>  var theCar = carList.filter(_.ownerID == id)
        if(theCar.size >1) theCar = theCar.filter(_.model == model)
        val brokenParts = theCar.head.partsList.filter(_.state == "broken") //.head.state = "functioning"
        var totalPrice: Int = brokenParts.foldLeft(0){(totalPrice,part ) => calBroken(totalPrice,part.name) }
        theCar.head.fixed = true
        println(totalPrice)
      case "bike" =>
        var theBike = bikeList.filter(_.ownerID == id)
        if(theBike.size >1) theBike = theBike.filter(_.model == model)
        theBike.head.fixed = true
    }
  }
  def getCustomerID(owner: String): Int = {
    try
      owner forall Character.isDigit match {
        case true => customerList.filter(_.ID == owner.toInt).map(_.ID).head
        case false => customerList.filter(_.fullName == owner.toString).map(_.ID).head
      }

    catch {
      case e: Exception => println("exception caught: " + e)
        -1
    }
  }

  def removeVehicle(id: Int, vehType: String, model: Option[String] = None): Unit = {
    vehType match {
      case "car" =>
        var dropCar = carList.filter(_.ownerID == id)
        if(dropCar.size >1) dropCar = dropCar.filter(_.model == model)
        carList = carList diff dropCar
      case "bike" =>
        var dropBike = bikeList.filter(_.ownerID == id).drop(1)
        if(dropBike.size > 1) dropBike = dropBike.filter(_.model == model).drop(1)
        bikeList = bikeList diff dropBike
    }
  }

  def calBroken(totalPrice: Int, partName: String): Int = {
    partName match {
      case "tyre" => totalPrice + 20
      case "indicator" => totalPrice + 25
      case "breakLight" => totalPrice +15
      case "headLight" => totalPrice + 30
      case "engine" => totalPrice + 300
      case "gearbox" => totalPrice + 200
      case "window" => totalPrice + 80
      case "electronics" => totalPrice + 70
      case "exhaust" => totalPrice + 60
      case "battery" => totalPrice + 120
    }
  }
  def calBills(id: Int, vehType: String): Unit = {
    var cost = vehType match {
      case "car" => 100 * carList.filter(_.ownerID == id).head.numSeats
      case "bike" => bikeList.filter(_.ownerID == id).head.motorType match {
        case x if x contains "man" => 100
        case x if x contains "auto" => 50
      }
    }
    bills += (id -> cost)
  }

  def getCarPartList(id:Int): Unit ={
    carList.filter(_.ownerID == id).head.partsList.foreach(println)
  }



  def getDetails(vehType:String): ArrayBuffer[String] = {
    val details = ArrayBuffer[String]()
    println(s"Enter $vehType Details:\nMake:")
    details += readLine()
    println("Model:\n")
    details += readLine()
    println("Motor Type:\n")
    details += readLine()
    vehType match {
      case "Car" => {
        println("Transmission:\n")
        details += readLine()
        println("Number of Seats:\n")
        details += readLine()
      }
      case "Bike" => {
        println("Break Type:\n")
        details += readLine()
      }
    }
    details
  }
}

