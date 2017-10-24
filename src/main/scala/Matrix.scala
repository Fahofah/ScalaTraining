import scala.util.Random

object Matrix extends App {

  val alphanum = "abcdefghijklmnopqrstuvwxyz1234567890"
  var i = 0
  val randomLine =(70 to 110).toArray

  def randomPick(): Char = {
    val r = new scala.util.Random
    val r1 = r.nextInt(alphanum.length)
    alphanum(r1)
  }

  def randomChange(): Int = {
    val r = new scala.util.Random
    val r1 = r.nextInt(randomLine.length)
    randomLine(r1)
  }

    var stop = false
    var change = randomChange()

  def matrix() : Unit = {
    while(!stop) {
      print(randomPick())
      //if (readLine() == "q") stop = true
      i += 1
      if (i==change) {
        println()
        change = randomChange()
        i = 0
      }
    }

  }

  matrix()
}
