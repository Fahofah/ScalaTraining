package garage

case class Customer(ID: Int,fullName: String) extends Person{

  var invoiceReady = false
  var invoicePrice = 0

  override def toString:String = {
    var status = s"is served and has pending invoice of £$invoicePrice"
    if (!invoiceReady) status = "is waiting service"
    s"\nCustomer $fullName, #$ID $status"
  }
}

object Customer {
  var id = 0
  private var id_itr = 0

  def apply(fullName: String): Customer = new Customer(getNextId, fullName)

  def getNextId: Int = {
    id = id_itr + 1
    id_itr += 1
    id
  }
}