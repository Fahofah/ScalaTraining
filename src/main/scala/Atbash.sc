
def atbashIt (word: String) = {
  val alphabet = "abcdefghijklmnopqrstuvwxyz"
  var atbashWord = ""

  for (letter <- word) {
    if (alphabet contains letter) {
      if (letter == ' ') atbashWord += " "

      else {
        val currentIndex = alphabet.indexOf(letter)
        val atbashIndex = 25 - currentIndex
        atbashWord += alphabet(atbashIndex)
      }
    }
    else atbashWord += letter
  }
  println(atbashWord)
}
atbashIt("gsrh rh zm vcznkov l%u gsv zgyzhs xrksvi")
