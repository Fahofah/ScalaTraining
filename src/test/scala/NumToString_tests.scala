import daytoday.ExtraExercises.NumToString

class NumToString_tests extends TestBaseClass  {

  "This function" should "take in a string and return true if it is a proper number made by just numerics" in {
    assert(NumToString.isProperNumber("123123123") == true)
  }

  it should "return false if theri is any other symbol or letter in any part of the number incl. commas" in {
    assert(NumToString.isProperNumber("1a2314,4121") == false)
  }

  "this function" should "take in a number in string format and return in shortscale and long scale formats" in {
    assert(NumToString.mainExec("111111111111234567891111") == "Short scale: 111 sextillion, 111 quintillion, 111 quadrillion, 111 trillion, 234 billion, 567 million, 891 thousand and 111\nLong scale: 111 trilliard, 111 trillion, 111 billiard, 111 billion, 234 milliard, 567 million, 891 thousand and 111")
  }
  it should "work for less than 6 digit numbers too" in {
    assert(NumToString.mainExec("1") == "Short scale: 1\nLong scale: 1")
    assert(NumToString.mainExec("1021") == "Short scale: 1 thousand and 21\nLong scale: 1 thousand and 21")
  }
  it should "omit 0s  if they dont effect profixes" in {
    assert(NumToString.mainExec("21001") == "Short scale: 21 thousand and 1\nLong scale: 21 thousand and 1")
  }
  it should "print out error when invalid number is written" in {
    assert(NumToString.mainExec("as123") == "Please write a proper number")
  }

}
