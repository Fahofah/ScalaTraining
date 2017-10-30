package garage

object Console extends App {


  val myGarage = new Garage
  myGarage.addCustomer
  myGarage.addCustomer
  println(myGarage.customerList)

//  myGarage.addEmployee
//  println(myGarage.employeeList)

  myGarage.addCar
//  myGarage.addBike
//  myGarage.addBike
  myGarage.addCar

//  println(myGarage.carList)
//  myGarage.fixVehicle(1,"bike")

//  myGarage.bikeList.foreach(println)
  myGarage.carList.foreach(println)

  myGarage.removeVehicle(2,"car")

  myGarage.carList.foreach(println)
}
