import daytoday.DayClasses_forTests._
import daytoday.helpers._

class Day3_tests extends TestBaseClass with MockOutput{

  val Day3functions = new Day3functions

  "This function" should "take in a list of numbers and output true if the set is a Fibonacci sequence and false if its not" in {
    val set = List(1, 2, 3, 4, 5, 7)
    assert(Day3functions.isFibo(set) == false)
  }

    it should "also take an unsorted list and do the same " in {
      val set = List(3,21,13,5,8,1,2)
      assert(Day3functions.isFibo(set) == true)
    }
  "This function" should "take in two integers and give back their highest comman divisor" in {
    assert(Day3functions.hcd(250,120) == 10)
  }
  "This function" should "take in an integer and return its factorial product" in {
    assert(Day3functions.tailFactorial(5) == 120)
  }
  "This function" should "check if the second string argument contains the first string argumnet" in {
    val check = new Day3functions with MockOutput
    check.checkContain("aba","alibaba")
    check.messages shouldBe List("alibaba contains aba")
  }
  "This function" should "take in a double, apply discount if above 50 and add vat at the end" in {
    assert(Day3functions.finalPrice(60) == 72)
  }
  it should "not apply discount but add vat if under 50" in {
    assert(Day3functions.finalPrice(60) == 72)
  }

}
