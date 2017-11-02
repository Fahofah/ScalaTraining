package daytoday.DayClasses_forTests
import daytoday.helpers._

class Day2functions extends Output {

  def rect_recur(word: String, width: Int, height: Int, endString: String = ""): String = {
    var newString = endString
    if (height > 0) {
      newString += ((word + "\t") * width) + "\n"
      rect_recur(word, width, height - 1, newString)
    }
    else newString
  }

  def recur_fizz(phrase1: String, phrase2: String, botRange: Int, topRange: Int): Unit = {
    val i = botRange
    if (i <= topRange) {
      if (i % 15 == 0) print(phrase1 + phrase2)
      else if (i % 3 == 0) print(phrase1)
      else if (i % 5 == 0) print(phrase2)
      else print(i.toString)
      if (i != topRange) print(",")
      recur_fizz(phrase1, phrase2, botRange + 1, topRange)
    }
  }


  def match_addUp(num1: Int, num2: Int, multiply: Boolean): Unit = {
    if (num1 == 0 && num2 == 0) print(0)
    else if (num1 == 0) print(num2)
    else if (num2 == 0) print(num1)
    else {
      multiply match {
        case true => print(num1 * num2)
        case false => print(num1 + num2)
      }
    }
  }


  def swap(list: Any): Any = {
    list match {
      case x: Seq[Any] =>
        val (take, leave) = x.splitAt(2)
        take.reverse
      case x: Array[Int] => Array[Int](x(1), x(0))
      case (x, y) => (y, x)
    }
  }
}
