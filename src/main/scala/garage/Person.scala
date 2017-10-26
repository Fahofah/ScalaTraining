package garage

abstract class Person(ID: Int,fullName: String) {

  private var EmployeeId_itr= 0
  private var CustomerId_itr= 0
  def apply(ID: Int, fullName: String): Person = {
    Person.this match {
      case p: Employee => this.ID = EmployeeId_itr + 1
      case p: Customer => this.ID = CustomerId_itr + 1
    }
    EmployeeId_itr +=1
    CustomerId_itr += 1
  }
}
