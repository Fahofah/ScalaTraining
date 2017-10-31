package daytoday.DayClasses_forTests
import daytoday.helpers._

class Day2functions extends Output {

  def rect_recur(word: String, width : Int, height : Int,endString : String = ""): String = {
    var newString = endString
    if (height > 0) {
      newString +=  ((word + "\t") * width ) + "\n"
      rect_recur(word, width, height -1,newString)
    }
    else newString
  }

  def recur_fizz(phrase1 : String, phrase2 : String, botRange :Int, topRange : Int): Unit = {
    val i = botRange
    if(i<=topRange) {
      if (i % 15 == 0) print(phrase1 + phrase2)
      else if (i % 3 == 0) print(phrase1)
      else if (i % 5 == 0) print(phrase2)
      else print(i.toString)
      if (i != topRange) print(",")
      recur_fizz(phrase1,phrase2,botRange+1,topRange)
    }
  }


  def match_addUp ( num1 : Int, num2 : Int, multiply : Boolean) : Unit = {
    if (num1 == 0 && num2 == 0) print(0)
    else if (num1==0) print(num2)
    else if (num2==0) print(num1)
    else {
      multiply match {
        case true => print(num1 * num2)
        case false => print(num1+num2)
      }
    }
  }


  def swap (list : Any): Any = {
    list match {
      case x: Seq[Any] =>
        val (take,leave) = x.splitAt(2)
        take.reverse
      case x: Array[Int] => Array[Int](x(1),x(0))
      case (x,y) => (y,x)
    }
  }

//  val list = List(1,20,33,41,53,6)
//  println(list map (value => if (value >20) value * 10 else value))
//
//  val wordList = List("aba","helloman","manaby","papatya","my","ratatuille")
//  println(wordList map (word => if (word.length >4) word))
//
//  val listofLists = List(List(List(1,2,3,4,5), List(6,7,8,9,10)), List(List(11,12,13,14,15), List(16,17,18,19,20)))
//  println(listofLists flatMap( _ flatMap(_.toList)))

}
