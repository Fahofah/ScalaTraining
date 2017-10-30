




def execRPN(stack: List[Double],x: String): List[Double]= {

  val numbers = (0 to 9).map(_.toString)

  val operators = "+ - * /"

  def isNumber(text: String): Boolean = numbers.exists(text contains _)

  def isOperator(text: String): Boolean = operators contains text

//  x match {
//    case r if (isNumber(x)) =>     val newStack = x.toDouble +: stack
//      newStack
//    case y if (isOperator(x)) =>   val num2 = stack.head
//      val num1 = stack.tail.head
//      val result = applyOperator(num1, num2, operator = x)
//      val newStack = result +: stack.drop(1).drop(1)
//      newStack
//  }
  if (isNumber(x)) {
    val newStack = x.toDouble +: stack
    newStack
  }
  else {

    val num2 = stack.head
    val num1 = stack.tail.head
    val result = applyOperator(num1, num2, operator = x)
    val newStack = result +: stack.drop(1).drop(1)
    newStack

  }
  
//else {
//  stack
//}

  def applyOperator(num1: Double, num2: Double, operator: String): Double = {
    val result = operator match {
      case "+" => num1 + num2
      case "-" => num1 - num2
      case "/" => num1 / num2
      case "*" => num1 * num2
    }
    result
  }

}


val X = "1 2 +"
X.split(" ").foldLeft(List[Double]()){(stack, x) => execRPN(stack,x)}