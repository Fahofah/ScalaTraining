import daytoday.DayClasses_forTests._
import daytoday.helpers._

class Day3and4_tests extends TestBaseClass with MockOutput{

  val Day3functions = new Day3functions
  val Day4functions = new Day4functions

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
  "This function" should "check and tell when the second string argument contains the first string argumnet" in {
    val check = new Day3functions with MockOutput
    check.checkContain("aba","alibaba")
    check.messages shouldBe List("alibaba contains aba")
  }
  it should "inform in a formatted way if it is not contained within the other string" in {
    val check2 = new Day3functions with MockOutput
    check2.checkContain("bird","alibaba")
    check2.messages shouldBe List("alibaba does not contain bird")
  }
  "This function" should "take in a double, apply discount if above 50 and add vat at the end" in {
    assert(Day3functions.finalPrice(60) == 72)
  }
  it should "not apply discount but add vat if under 50" in {
    assert(Day3functions.finalPrice(30) == 36)
  }
  "This function" should "give back the total price by using the former function" in {
    assert(Day3functions.totalPrice(2)(10)(Day3functions.finalPrice) == 24)
  }
  //Day4 from here after
  "This function" should "add up all three numbers if they are all unique and return their result" in{
    assert(Day4functions.uniqueSum(1,2,3)== 6)
  }
  it should "return the sum ignoring the identical number if any two numbers are equal" in {
    assert(Day4functions.uniqueSum(1,1,2) == 3)
    assert(Day4functions.uniqueSum(1,2,1) == 3)
    assert(Day4functions.uniqueSum(2,1,1) == 3)
  }
  it should "return 0 if all numbers are equal" in {
    assert(Day4functions.uniqueSum(1,1,1) == 0)
  }
  "This function" should "check if the given number is within 60 and 90 and return false if it is and true if it not when second argument is false" in {
    assert(Day4functions.isTooHot(67,false) == false)
    assert(Day4functions.isTooHot(96,false) == true)
  }
  it should "change the upper limit to 100 for checking the input value when second field is true" in {
    assert(Day4functions.isTooHot(97,true) == false)
    assert(Day4functions.isTooHot(120,true) == true)
  }
}
