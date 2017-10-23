import scala.util.Random

object Matrix {
  def matrix() : Unit = {
    var alphanum = Random.alphanumeric
    println(alphanum.nextInt())
  }
}
