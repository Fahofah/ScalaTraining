import scala.util.Random

object Matrix extends App {

  val alphanum = "abcdefghijklmnopqrstuvwxyz1234567890"
  var i = 0
  val randomLine =(70 to 110).toArray

  def randomPick(): Char = {
    alphanum(scala.util.Random.nextInt(alphanum.length))
  }

  def randomChange(): Int = {
    randomLine(scala.util.Random.nextInt(randomLine.length))
  }

    val stop = false
    var change = randomChange()

  def matrix() : Unit = {
    while(!stop) {
      print(randomPick())
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
