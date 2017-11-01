package daytoday.DayClasses_forTests

class Day4functions {

  def uniqueSum(num1: Int, num2: Int, num3: Int): Int = {
    if (num1 == num2 && num2 == num3) 0
    else if (num1 == num2) num3 + num1
    else if (num2 == num3) num1 + num2
    else if (num1 == num3) num1 + num2
    else num1 + num2 + num3
  }

  def isTooHot(temp: Int, isSummer: Boolean): Boolean = {
    var upLimit = 90
    if(isSummer) upLimit = 100
    if(temp >= 60 && temp <= upLimit) false
    else true
  }
}
