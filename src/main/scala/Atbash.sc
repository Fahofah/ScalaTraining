
def atbashIt (word: String) = {
  val alphabet = "abcdefghijklmnopqrstuvwxyz"
  var atbashWord = ""

  for (letter <- word) {

    if (letter == ' ') atbashWord += " "

    else {
      val currentIndex = alphabet.indexOf(letter)
      val atbashIndex = 25 - currentIndex
      atbashWord += alphabet(atbashIndex)
    }
  }
  println(atbashWord)
}
atbashIt("gsrh rh zm vcznkov lu gsv zgyzhs xrksvi")
