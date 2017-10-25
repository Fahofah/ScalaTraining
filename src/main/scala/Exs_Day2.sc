// Ex 22 - Recursion
println("Ex22")
def rect_recur(word: String, width : Int, height : Int): Unit = {
  if (height >= 0) {
    println((word + "\t") * width )
    rect_recur(word, width, height -1)
  }
}
rect_recur("H",8, 8)

// Ex 23
println("Ex 23 - RecursiveFizz")
def recur_fizz(phrase1 : String, phrase2 : String, botRange :Int, topRange : Int): Unit = {
  val i = botRange
  if(i<=topRange) {
    if (i % 15 == 0) print(phrase1 + phrase2)
    else if (i % 3 == 0) print(phrase1)
    else if (i % 5 == 0) print(phrase2)
    else print(i)
    print(",")
    recur_fizz(phrase1,phrase2,botRange+1,topRange)
  }


}
recur_fizz("fizz","buzz",1,50)

// Ex 24 - Pattern Match
println("Ex124")
def match_addUp ( num1 : Int, num2 : Int, multiply : Boolean) : Unit = {
  if (num1 == 0 && num2 == 0) println(0)
  else if (num1==0) println(num2)
  else if (num2==0) println(num1)
  else {
    multiply match {
      case true => println(num1 * num2)
      case false => println(num1+num2)
    }

  }
}

match_addUp(3,0,true)

//Ex25 - Pattern Match 2
println("Ex25")
val numArray = Array(1,2,3,4,5,6)
val numList = List(1,3,4,5,6)
def swap (list : Any): Any = {

  list match {
    case list: Array[Int] => {
      list.splitAt(2) match {
        case (Array(x, y), z) => println("Out: " + Array(y, x).deep.mkString(","))
        case _ => list
      }
    }
    case list: List[Int] => {
      list.splitAt(2) match {
        case (List(x, y), z) => println(list.grouped(2).toList)
        case _ => list
      }
    }
  }
}
swap(numList)

// Ex 26 -Map
println("Ex 26")
val list = List(1,20,33,41,53,6)
println(list map (value => if (value >20) value * 10 else value))

// Ex 26 -Map
println("Ex 27")
val wordList = List("aba","helloman","manaby","papatya","my","ratatuille")
println(wordList map (word => if (word.length >4) word))


// Ex 27
println("Ex 27")
val listofLists = List(List(List(1,2,3,4,5), List(6,7,8,9,10)), List(List(11,12,13,14,15), List(16,17,18,19,20)))
println(listofLists flatMap( _ flatMap(_.toList)))