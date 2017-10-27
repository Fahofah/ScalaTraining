package garage

object Console extends App {

  val emp1 = Employee("Mathew Clark", "Welder")
  val cust1 = Customer("Marie Sandlers")
  val emp2 = Employee("Mathew Clark", "Welder")
  val cust2 = Customer("Marie Sandlers")
  val car1 = new Car(2,"BMW", "i3","Electric","Automatic",5,"12/10/17")
  val bike1 = new Bike(3, "Carrera","on the Go","Pedal","Disk","20/10/17")

  println(emp1.toString)
  println(cust1.toString)
  println(emp2.toString)
  println(cust2.toString)
  println(car1.toString)
  println(bike1.toString)

}
