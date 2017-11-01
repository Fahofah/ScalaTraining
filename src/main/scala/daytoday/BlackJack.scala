package daytoday

object BlackJack extends App {

  def compareHands(hand1: Int, hand2: Int): Int = {
    if (hand1 > 21 && hand2 > 21) 0
    else if (hand1 > 21) hand2
    else if (hand2 > 21) hand1
    else {
      if (hand1 > hand2) hand1
      else if (hand2 > hand1) hand2
      else -1
    }
  }

  def printResult(result: Int): String = {
    result match {
      case 0 => "Both hands busted!"
      case -1 => "It's a draw!"
      case _ => s"$result wins!"
    }
  }
}

