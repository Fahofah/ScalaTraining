import daytoday.DayClasses_forTests.Day1functions
import daytoday.helpers._

class Day1_tests extends TestBaseClass with MockOutput {

  val Day1functions = new Day1functions

  "This function" should "print out the string that is passed to it as an argument" in {
    assert(Day1functions.getString("hello") == "hello")
  }
  it should "give back 'Hello World' when no sting is passed ( executed empty )" in {
    assert(Day1functions.getString() == "Hello World")
  }

  "This (cutWord) function" should "cut a word from nth character from the end of a string and return the result back" in {
    assert(Day1functions.cutWord("macaroni", 4) == "roni")
  }

  "This StickNReplace function" should " combine two passed string end to end and replace all occurances of passed firs character with second character" in {
    assert(Day1functions.stickNreplaceWord("Miami", "Beach", 'a', 'o') == "MiomiBeoch")
  }

  "This (nameNAddress)function" should "take a name and a address and output a formatted string with name capitalized and adress lower cased" in {
    assert(Day1functions.nameNaddress("Thomas", "123 Avenue") == "My name is Thomas and I live in 123 avenue")
  }

  "This (printDouble function" should "take in a number of type double and give back its string version with 3 decimal points" in {
    assert(Day1functions.printDouble(2.34676432) == "2.347")
  }

  "This reverseWord function" should "takein a string and give it back in reverse order" in {
    assert(Day1functions.reverseWord("contaminate") == "etanimatnoc")
  }

  "This AddUp function" should "take in two integers and mutiply them if the third argument is true and add them if false returning the result" in {
    assert(Day1functions.addUp(2, 3, true) == 6)
    assert(Day1functions.addUp(2, 3, false) == 5)
  }

  "This ageInSecs function" should "take in your age in years and give it out in seconds in a descriptive string" in {
    assert(Day1functions.ageInSecs(25) == "You are 788400000 seconds old!")
  }

  // test println
  "This function" should "print out a rectangularized form of the giving string with given dimensions" in {

    val unitTest = new Day1functions with MockOutput
    unitTest.rectangularize("H", 4)
    unitTest.messages should contain("H\t")
  }

  //fixbuzz with mockOutput
  "This function" should "print out a string for the numbers given in the range (starting from 0) replacing numbers divisble by 3 as fizz, 5 with buzz and bothf as fizzbuzz" in {

    val fizzbuzzUnit = new Day1functions with MockOutput
    fizzbuzzUnit.fizzbBuzz("fizz", "buzz", 20)
    fizzbuzzUnit.messages should contain("fizzbuzz")
  }

  "This multiString function" should "print out the given string by the amount provided in arguments"  in {
    val multiString = new Day1functions with MockOutput
    multiString.multiString("hello", 3)
    multiString.messages shouldBe List("hello", "hello","hello")
  }

  it should "print the string once if no amount is specified in the arguments" in {
      val multiString = new Day1functions with MockOutput
      multiString.multiString("hello")
      multiString.messages shouldBe List("hello")
  }
}
