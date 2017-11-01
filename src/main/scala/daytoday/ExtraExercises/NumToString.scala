package daytoday.ExtraExercises

object NumToString {

  private val numbers = (0 to 9).map(_.toString)
  private val secondNums = Map('2' -> "twenty", '3' -> "thirty", '4' -> "fourty", '5' -> "fifty", '6' -> "sixty", '7' -> "seventy", '8' -> "eighty", '9' -> "ninety")
  private val firstNums = Map('1' -> "one", '2' -> "two", '3' -> "three", '4' -> "four", '5' -> "five", '6' -> "six", '7' -> "seven", '8' -> "eight", '9' -> "nine")
  private var shortNumString = ""
  private var longNumString = ""

  def isProperNumber(number: String): Boolean = number.distinct.length == numbers.map(number contains _).count(_ == true)

  def mainExec(num: String): String = {
    shortNumString = ""
    longNumString = ""
    if (isProperNumber(num)) {
      convertNum(num)
      s"Short scale: $shortNumString\nLong scale: $longNumString"
    }
    else "Please write a proper number"
  }

  def convertNum(num: String): Unit = {
    val (firstThree, rest) = num.length % 3 match {
      case 0 => num.splitAt(3)
      case 1 => num.splitAt(1)
      case 2 => num.splitAt(2)
    }
    val (shortProfix, longProfix) = rest.length match {
      case 0 => ("", "")
      case 3 => (" thousand and ", " thousand and ")
      case 6 => (" million, ", " million, ")
      case 9 => (" billion, ", " milliard, ")
      case 12 => (" trillion, ", " billion, ")
      case 15 => (" quadrillion, ", " billiard, ")
      case 18 => (" quintillion, ", " trillion, ")
      case 21 => (" sextillion, ", " trilliard, ")
    }


    shortNumString += firstThree.filterNot(_ == '0') + shortProfix
    longNumString += firstThree.filterNot(_ == '0') + longProfix

    if (!rest.isEmpty) convertNum(rest)

  }

}

//  //were made for 1st version not used in latest version
//  def verbaSecondPlace(num : String): String = secondNums(num.reverse.apply(1))
//  def verbaFirstPlace(num: String): String = firstNums(num.reverse.apply(0))
//  def verbaThirdPlace(num: String): String = firstNums(num.apply(0))+ "hundred"
//  //was made for 1st version not used in latest version
//  def makeThreeDigitString(num: String): String = {
//    var ShortNumString = ""
//    num.length match {
//      case 3 => ShortNumString += verbaThirdPlace(num) + verbaSecondPlace(num) + verbaFirstPlace(num)
//      case 2 => ShortNumString += verbaSecondPlace(num) + verbaFirstPlace(num)
//      case 1 => ShortNumString += verbaFirstPlace(num)
//    }
//    ShortNumString
//  }
