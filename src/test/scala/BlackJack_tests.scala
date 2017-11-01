import daytoday.BlackJack
import daytoday.helpers._

class BlackJack_tests extends TestBaseClass {

  "this function" should "get two integer values representing two hands in the blackjack game and evaluate outcome"

  it should "return 0 if both hands are above 21" in {
    assert(BlackJack.compareHands(23,24) == 0)
  }
  it should "return the other number if one number is above 21" in {
    assert(BlackJack.compareHands(14,24) == 14)
    assert(BlackJack.compareHands(23,5) == 5)
  }
  it should "return the number closer to 21 if both numbers below 21" in {
    assert(BlackJack.compareHands(14,20) == 20)
    assert(BlackJack.compareHands(14,7) == 14)
  }
  it should "return -1 if both hands below 21 and equal" in {
    assert(BlackJack.compareHands(13,13) == -1)
  }
  "this function" should "ouput the winning hand of session in a string format" in {
    assert(BlackJack.printResult(14) == "14 wins!")
  }
  it should "give out a draw string if both hands below 21 and equal (-1)" in {
    assert(BlackJack.printResult(-1) == "It's a draw!")
  }
  it should "give out a string informing both hands were busted if both numbers above 21 (0)" in {
    assert(BlackJack.printResult(0) == "Both hands busted!")
  }
}
