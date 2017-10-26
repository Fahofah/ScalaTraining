package garage

object Console extends App {

  val emp1 = new Employee(1,"Mathew Clark", "Welder")
  val cust1 = new Customer(2,"Marie Sandlers")
  val car1 = new Car(2,"BMW", "i3","Electric","Automatic",5,"12/10/17")
  val bike1 = new Bike(3, "Carrera","on the Go","Pedal","Disk","20/10/17")

  println(emp1.toString)
  println(cust1.toString)
  println(car1.toString)
  println(bike1.toString)

}
