package garage

object Console extends App {


  val myGarage = new Garage
  myGarage.addCustomer
  myGarage.addCustomer
  println(myGarage.customerList)

//  myGarage.addEmployee
//  println(myGarage.employeeList)

  myGarage.addCar
  myGarage.addBike

  println(myGarage.carList)
  myGarage.fixVehicle(1,"car")

  println(myGarage.carList)

}
