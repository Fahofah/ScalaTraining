//Factorial Extra Exercise
def isFactorial(num: Int): Unit = {
  var product = 1
  var multiplier = 1
  while (product<num){
    product = multiplier * (product)
    multiplier += 1

  }
  if(product == num) println(multiplier-1+"!")
  else println("NONE")
}
isFactorial(45)