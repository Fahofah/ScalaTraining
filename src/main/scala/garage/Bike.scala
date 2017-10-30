package garage

case class Bike(ownerID: Int, make: String,  model: String,  motorType: String, breakType: String,checkIn: String,checkOut: String = "", fixed: Boolean =  false) extends Vehicle(ownerID,make,model,checkIn,checkOut,fixed) {

  override def toString: String = {
    s"\nVehicle Type: Bike \nMake: $make \nModel: $model\nServiced/Fixed: $fixed\nMotor Type: $motorType\nMotor Type: $motorType\nBreak Type: $breakType\n Check-in Date: $checkIn \nCheck-out Date: $checkOut"
  }
}
