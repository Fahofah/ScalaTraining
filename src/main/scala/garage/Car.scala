package garage

case class Car(ownerID: Int, make: String,  model: String, motorType: String, transmission: String, numSeats: Int, checkIn: String,checkOut: String = "", fixed: Boolean =  false) extends Vehicle(ownerID,make,model,checkIn,checkOut,fixed) {

  override def toString: String = s"\nVehicle Type: Car \nMake: $make \nModel: $model\nMotor Type: $motorType\nTransmission: $transmission\nNumber of Seats: $numSeats\nCheck-in Date: $checkIn\nServiced/Fixed: $fixed \nCheck-out Date: $checkOut"


}
