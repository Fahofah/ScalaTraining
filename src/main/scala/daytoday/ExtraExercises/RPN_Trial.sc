def execRPN(stack: Array[Double],x: String): Array[Double]= {

  val numbers = (0 to 9).map(_.toString)

  val operators = "+ - * /"


  def isNumber(number: String): Boolean = numbers.exists(number contains _)

  def isOperator(symbol: String): Boolean = operators contains symbol

  if (isNumber(x)) {
    x.toDouble +: stack
  }
  else if (isOperator(x)) {

    val num2 = stack.head
    val num1 = stack.tail.head
    val result = x match {
      case "-" => num1 - num2
      case "/" => num1 / num2
      case "*" => num1 * num2
      case "+" => num1 + num2
    }
    result +: stack.drop(2)
  }
  else {
    println("else")
    stack
  }
}

val X = "90 34 12 33 55 66 + * - + -"
val results: Array[Double] = X.split(" ").foldLeft(Array[Double]())((results,f) => execRPN(results,f))
