package garage

case class Customer(ID: Int,fullName: String) extends Person(ID,fullName){

  var invoiceReady = false
  var invoicePrice = 0

  override def toString:String = {
    var status = s"is served and has pending invoice of £$invoicePrice"
    if (!invoiceReady) status = "is waiting service"
    s"\nCustomer $fullName, #$ID $status"
  }
}
