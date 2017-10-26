import scala.util.Random
// Ex 1
println("Ex1")
println("Hello World!")

// Ex 2
println("Ex2")
var hi = "Hello World!"
println(hi)

// Ex 3
println("Ex3")
hi = "Hello to Everyone in the World!"
println(hi)

// Ex 4
println("Ex4")
def printThis(string : String = "No String was passed" ) : Unit = println(s"$string")
printThis("Alabama")
printThis()

// Ex 5
println("Ex5")
def multiString( multiplier : Int = 1, string : String) : Unit = {
  for(i<- 1 to  multiplier){
    println(string)
  }
}
multiString(3,"hello")
multiString(multiplier = 3, string = "wadada")

// Ex 6
println("Ex6")
def getString(string: String = "Hello World"): String = string
println(getString())

// Ex 7
println("Ex7")
def outputThis (a : Any) : Unit = println(a)
outputThis(5)
outputThis("check")
outputThis(2.123)
outputThis(true)

// Ex 8
println("Ex8")
def cutWord (string : String, place : Int): Unit = {
  println(string.substring(string.length-place,string.length))
}
cutWord("Bandabulia",5)

// Ex 9
println("Ex9")
def stickNreplaceWord (firstHalf: String, secondHalf : String, char1 : Char, char2 : Char) : Unit = {
   println(firstHalf.concat(secondHalf).replace(char1,char2))
}
stickNreplaceWord("Hal","lo",'a','e')

// Ex 10
println("Ex10")
def nameNaddress (name : String, address : String) : Unit = {
  var nameCap = name.capitalize
  var lowAddr = address.toLowerCase
  println(s"My name is $nameCap and I live in $lowAddr")
}
nameNaddress("Fahri", "71 Portland Road, Salford, Manchester")

// Ex 11
println("Ex11")
def printDouble (num : Double) : Unit = println(f"$num%.3f")
printDouble(232.314325)

// Ex 12
println("Ex12")
def reverseWord ( word : String) : Unit = println(word.reverse)
reverseWord("hello")

// Ex 13, Ex 15 and Ex 16
println("Ex13, Ex15 and Ex16")
def addUp ( num1 : Int, num2 : Int, multiply : Boolean) : Int = {
  if (num1 == 0) num2
  else if(num2 == 0) num1
  else if (num1 == 0 && num2 ==0) 0
  else {
    if (!multiply) num1 + num2
    else num1*num2
  }
}
addUp(0,0,true)

// Ex 14
println("Ex14")
def ageInSecs (age : Int): Unit = {
  println(s"You are ${age*365*24*60*60} seconds old!")
}
ageInSecs(25)

// Ex 17
println("Ex17")
multiString(3,"Hi") //same as Ex5

// Ex 19 - Iteration 3
println("Ex19")
def rectangularize(word: String, dim : Int): Unit = {
  for(i<- 1 to dim;j<- 1 to dim){
    print(word + "\t")
    if(j==dim) println()
  }
}
rectangularize("H",8)

// Ex 20
println("Ex 20 - FizzBuzz")
def fizzbBuzz(phrase1 : String, phrase2 : String, topRange : Int): Unit = {
  for(i<-1 to topRange){
    if (i%15 == 0) print(phrase1+phrase2)
    else if (i%3 == 0) print(phrase1)
    else if(i%5 == 0) print(phrase2)
    else print(i)
    print(",")
  }
}
fizzbBuzz("fizz","buzz",50)



