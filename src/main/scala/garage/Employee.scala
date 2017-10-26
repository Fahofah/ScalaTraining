package garage

case class Employee(ID: Int,fullName: String, role: String, isAvailable: Boolean= true) extends Person(ID,fullName){

  override def toString: String = s"\nID: $ID\nName: $fullName\nRole: $role\n Available for Service: $isAvailable"
}
