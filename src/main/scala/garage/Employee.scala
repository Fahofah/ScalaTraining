package garage

case class Employee(ID: Int,fullName: String, role: String) extends Person{


  var isAvailable = true
  override def toString: String = s"\nID: $ID\nName: $fullName\nRole: $role\nAvailable for Service: $isAvailable"
}

object Employee {
  var id = 0
  private var id_itr = 0

  def apply(fullName: String,role: String): Employee = new Employee (getNextId, fullName, role)

  def getNextId: Int = {
    id = id_itr + 1
    id_itr += 1
    id
  }
}