package daytoday.DayClasses_forTests

import daytoday.helpers.Output

class Day1functions extends Output {

  def printThis(string : String = "No String was passed" ) : Unit = println(s"$string")

  def multiString( string : String, multiplier : Int = 1) : Unit = {
    for(i<- 1 to  multiplier){
      print(string)
    }
  }

  def getString(string: String = "Hello World"): String = string


  def outputThis (a : Any) : Unit = println(a)


  def cutWord (string : String, place : Int): String = {
    string.substring(string.length-place,string.length)
  }


  def stickNreplaceWord (firstHalf: String, secondHalf : String, char1 : Char, char2 : Char) : String = {
    firstHalf.concat(secondHalf).replace(char1,char2)
  }


  def nameNaddress (name : String, address : String) : String = {
    var nameCap = name.capitalize
    var lowAddr = address.toLowerCase
    s"My name is $nameCap and I live in $lowAddr"
  }


  def printDouble (num : Double) : String = f"$num%.3f"


  def reverseWord ( word : String) : String = word.reverse


  def addUp ( num1 : Int, num2 : Int, multiply : Boolean) : Int = {
    if (num1 == 0) num2
    else if(num2 == 0) num1
    else if (num1 == 0 && num2 ==0) 0
    else {
      if (!multiply) num1 + num2
      else num1*num2
    }
  }


  def ageInSecs (age : Int): String = {
   s"You are ${age*365*24*60*60} seconds old!"
  }


  def rectangularize(word: String, dim : Int): Unit = {
    for(i<- 1 to dim;j<- 1 to dim){
      print(word + "\t")
      if(j==dim) print("\n")
    }
  }


  def fizzbBuzz(phrase1 : String, phrase2 : String, topRange : Int): Unit = {
    for(i<-1 to topRange){
      if (i%15 == 0) print(phrase1+phrase2)
      else if (i%3 == 0) print(phrase1)
      else if(i%5 == 0) print(phrase2)
      else print(i.toString)
      print(",")
    }
  }

}
