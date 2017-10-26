// Ex 29
println("Ex29")
val theList = List(1,2,3,4,6,7,8,4,2)
theList.foreach(println)

//Ex 30
println("Ex30")
val fruitList = List("Apple", "Raspberry", "Lemon", "Kiwi", "Strawberry")
var longest = ""
fruitList.foreach(word => if (word.length > longest.length) longest = word )
longest

// Ex 31 - Functional
println("Ex31")

val test = java.util.TimeZone.getAvailableIDs.map(word=> word.split("/").last ).filter(slot=> slot.length > 1).grouped(10)
test.foreach(value => value.foreach(println))

// Ex 32 - Fibonacci
println("Ex32")
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
isFibo(fiboSet)

// Ex 33
println("Ex33")
def hcd(num1: Int, num2: Int): Int = {
  if (num2 ==0) num1
  else hcd(num2, num1 % num2)
}
hcd(6,12)


//Ex 34
println("Ex34")
def tailFactorial(num: Int, multp: Int = 1, prod: Int =1): Int = {
  if (multp > num) prod
  else {
    val product = prod * multp
    tailFactorial(num, multp+1,product)
  }
}
tailFactorial(7)

//Ex 35
println("Ex35")
def checkContain(string1: String, string2: String): Unit ={
  if (string2 contains string2) println(s"$string2 contains $string1")
  else println(s"$string2 does not contain $string1")
}
checkContain("liver","liverpool")

// Ex 36
println("Ex36")
def doesContain(function: (String,String) => Unit, string1: String, string2: String): Unit = {
  function(string1,string2)
}
doesContain(checkContain,"liver","liverpool")

// Ex 37
println("Ex37")
doesContain((string1:String, string2: String ) => {  if (string2 contains string2) println(s"$string2 contains $string1")
else println(s"$string2 does not contain $string1")}, "liver", "liverpool")

// Ex 38
println("Ex38")
def finalPrice(price: Double): Double = {
  var thePrice = price
  if (price >= 50) {
    thePrice = price * .9
  }
  thePrice * 1.2
}
finalPrice(78)

// Ex 39
println("Ex39")
def totalPrice(amount: Int )(price: Double)(func: Double => Double) = {
  val totPrice = amount * price
  println(totPrice)
  func(totPrice)
}
val fiveItems = totalPrice(5) _
fiveItems(34)(finalPrice)
totalPrice(4)(60)(finalPrice)

