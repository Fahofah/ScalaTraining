import daytoday.DayClasses_forTests._
import daytoday.helpers._

class Day2_tests extends TestBaseClass with MockOutput {

  val Day2functions = new Day2functions

  "This recursive function" should "give back a rectangularized string of the giving string with given dimensions" in {
    assert(Day2functions.rect_recur("h",2,2) == "h\th\t\nh\th\t\n")
}

  "This recursive function" should "print out a string for the numbers given in the range (starting from 0) replacing numbers divisble by 3 as first string argument , 5 with second string argument and both as combination of two. It puts commas in between results" in {
    val recFizz = new Day2functions with MockOutput
    recFizz.recur_fizz("hey","how", 1, 15)
    recFizz.messages shouldBe List("1", ",", "2", ",", "hey", ",", "4", ",", "how", ",", "hey", ",", "7", ",", "8", ",", "hey", ",", "how", ",", "11", ",", "hey", ",", "13", ",", "14", ",", "heyhow")
  }

  "This function, taking in two integers and a boolean" should "mutiply them if the third argument is true and prints answer" in {
    val addOrMult = new Day2functions with MockOutput
    addOrMult.match_addUp(2,3,true)
    addOrMult.messages shouldBe List(6) //
  }
  it should "add the numbers if the third (boolean) argument is false" in {
    val addOrMult = new Day2functions with MockOutput
    addOrMult.match_addUp(2,3,false)
    addOrMult.messages shouldBe List(5)
  }
  it should "return the first number whenever second number is 0, regardless of boolean" in {
    val addOrMult = new Day2functions with MockOutput
    addOrMult.match_addUp(2,0,true)
    addOrMult.messages shouldBe List(2)
  }
  it should "return the second number whenever first number is 0, regardless of boolean" in {
    val addOrMult = new Day2functions with MockOutput
    addOrMult.match_addUp(0, 3, false)
    addOrMult.messages shouldBe List(3)
  }
  it should "return 0 if both numbers are 0, reagardless of boolean" in {
    val addOrMult = new Day2functions with MockOutput
    addOrMult.match_addUp(0, 0, true)
    addOrMult.messages shouldBe List(0)
  }

  "This function" should "take in a list and return the first 2 elemnts swapped" in {

    assert(Day2functions.swap(List(1,2,3,4)) == List(2,1))
  }
  it should "take in an array and do the same" in {
    Day2functions.swap(Array(8,9,5,6)) shouldEqual Array(9, 8)
  }
  it should "take in a TUPPLE and do the same" in {
    assert(Day2functions.swap((2, 3)) == (3, 2))
  }


}