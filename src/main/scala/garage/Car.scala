package garage
import java.time.Instant

case class Car(ownerID: Int, make: String,  model: String, motorType: String, transmission: String, numSeats: Int, checkIn: String,checkOut: String = "", var fixed: Boolean =  false) extends Vehicle(ownerID,make,model,checkIn,checkOut,fixed) {

  var partsList = scala.collection.mutable.MutableList[Part]()
  var attendedEmployeeId = -1
  var repairCost = -1
  var serviceStart = 0L
  var serviceEnd = 0L

  def addParts: Unit= {
    val partNames = List("tyre","indicator","breakLight","headLight","engine","gearbox","window","electronics","exhaust","battery")
    val states = List("broken","functioning")
    var r = new scala.util.Random()
    for (i<-partNames) {
      var part =  new Part(i,states(r.nextInt(2)))
      partsList += part
    }
  }

  override def toString: String = s"\nVehicle Type: Car \nMake: $make \nModel: $model\nMotor Type: $motorType\nTransmission: $transmission\nNumber of Seats: $numSeats\nCheck-in Date: $checkIn\nServiced/Fixed: $fixed \nCheck-out Date: $checkOut"

  def createReport: Unit = {
  val serviceDuration = ((serviceEnd - serviceStart)/ 1000.0 / 60.0 / 60.0).toFloat
    println(f"\nVehicle id#$ownerID $make $model" +
      f"\nService start: ${Instant.ofEpochMilli(serviceStart)}" +
      f"\nService end: ${Instant.ofEpochMilli(serviceEnd)}" +
      f"\nService duration: ${serviceDuration%2.2f} hours" +
      f"\nRepair cost: £$repairCost" +
      f"\nServiced by employee #id: $attendedEmployeeId")
  }

}
