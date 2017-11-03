package garage

import java.util.Calendar

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import java.time.Instant

class Garage {

  val customerList = scala.collection.mutable.MutableList[Customer]()
  val employeeList = scala.collection.mutable.MutableList[Employee]()
  var carList = scala.collection.mutable.MutableList[Car]()
  var bikeList = scala.collection.mutable.MutableList[Bike]()
  val invoicedList = List[Double]()
  var bills = scala.collection.mutable.Map[Int, Int]()
  val basePriceCar = 100
  val basePriceBike = 50

  def startSimulation: Unit = {
    println("started")
    for(i<- 1 to 20){
      val car = new Car(i,s"Make$i",s"model$i",s"motorType$i",s"trans$i",5,Calendar.getInstance().toString)
      car.addParts
      carList += car
    }
    carList.foreach(println)
    for(i<- 1 to 20){
      val employee = new Employee(i,s"name$i",s"role$i")
      employeeList += employee
    }
    println()
    employeeList.foreach(println)
    println()
    carList.foreach(car => fixVehicle(car.ownerID,"car"))
    printCarReports
  }

  def addCustomer: Unit ={
    println("Please enter this full name of this new Customer:\n")
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

  def hourToMilli(hour: Double): Long = (hour * 60 * 60 * 1000).toLong

  def serviceTime(car: Car, brokenNum: Int): Unit = {
    val now = System.currentTimeMillis()
    car.serviceStart = now
    car.serviceEnd = now + hourToMilli(brokenNum * 0.78)
  }

  def fixVehicle(id: Int, vehType: String,model : Option[String] = None): Unit = {
    val availableEmps = employeeList.filter(_.isAvailable == true)
    if(availableEmps.nonEmpty) {
      availableEmps.head.isAvailable = false
      vehType match {
        case "car" => var thisCar = carList.filter(_.ownerID == id)
          if (thisCar.size > 1) thisCar = thisCar.filter(_.model == model)

          val brokenParts = thisCar.head.partsList.filter(_.state == "broken") //.head.state = "functioning"
          serviceTime(thisCar.head,brokenParts.length)

          var totalPrice: Int = brokenParts.foldLeft(0) { (totalPrice, part) => calBroken(totalPrice, part.name) }
          thisCar.head.repairCost = totalPrice

          invoicedList :+ totalPrice

          thisCar.head.fixed = true

          thisCar.head.attendedEmployeeId = availableEmps.head.ID

        case "bike" =>
          var thisBike = bikeList.filter(_.ownerID == id)
          if (thisBike.size > 1) thisBike = thisBike.filter(_.model == model)
          thisBike.head.fixed = true
      }
    }
      else println("no available employee")
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

  def listCarPartList(id:Int): Unit ={
    carList.foreach(car => car.partsList.foreach(println))
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

  def printCarReports: Unit = {
    carList.foreach(car => car.createReport)
  }
}

