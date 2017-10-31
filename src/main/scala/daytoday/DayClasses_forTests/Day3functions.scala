package daytoday.DayClasses_forTests

import daytoday.helpers._

class Day3functions extends Output {

  val fiboSet = List(1,3,2,5,8,13,34,21)
  def isFibo (set: List[Int]): Boolean = {
    var fibo = false
    val sortSet = set.sorted
    for(i<-2 until  set.length) {
      if (sortSet(i - 2) + sortSet(i - 1) == sortSet(i)) fibo = true
      else fibo = false
    }
    fibo
  }


  def hcd(num1: Int, num2: Int): Int = {
    if (num2 ==0) num1
    else hcd(num2, num1 % num2)
  }


  def tailFactorial(num: Int, multp: Int = 1, prod: Int =1): Int = {
    if (multp > num) prod
    else {
      val product = prod * multp
      tailFactorial(num, multp+1,product)
    }
  }


  def checkContain(string1: String, string2: String): Unit ={
    if (string2 contains string2) print(s"$string2 contains $string1")
    else print(s"$string2 does not contain $string1")
  }


  def finalPrice(price: Double): Double = {
    if (price >= 50) {
      price * .9
    }
    price * 1.2
  }


  def totalPrice(amount: Int )(price: Double)(func: Double => Double) = {
    val totPrice = amount * price
    println(totPrice)
    func(totPrice)
  }
}
