package daytoday.ExtraExercises

object ChatBot extends App {

  val BotName = "Matilda"
  var yell = 0
  var play = true

  def greet: String = s"Hi I am $BotName, I am here to help. Ask me anything!"

  def pickAns: Int = {
    scala.util.Random.nextInt(2)
  }
  def printToScreen(string :String): Unit = println(string)

  def question: String = readLine()

  def script(question: String): String ={
    val randomAns = Array("I don’t know, let me google it up for you","I don’t know and I’m too lazy to look it up...")
    val answer = question match {
        case "q" =>
          play = false
          "Thank you and byebye!"
        case BotName => "Yes?"
        case x if x.toUpperCase == x && x != "" =>
          if( yell < 2 ) {
            yell += 1
            "Whoa,\nrelax a bit will ya"
          }
          else randomAns(pickAns).toUpperCase()
        case _ =>
          if (yell == 2) yell = 0
          randomAns(pickAns)
      }
    answer
  }
  def session(): Unit= {
    printToScreen(greet)
    while (play) printToScreen(script(question))
  }
session()
}
