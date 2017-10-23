object ChatBot extends App {

  val botName = "Matilda"
  val randomAns = Array("I don’t know, let me google it up for you","I don’t know and I’m too lazy to look it up...")
  var yell = 0
var quit = true

  println(s"Hi I am $botName, I am here to help. Ask me anything!")

  def pickAns(): Int = {
    val r = new scala.util.Random
    val r1 = r.nextInt(2)
    r1
  }

    while(quit) {
      var question = readLine()
      if (question=="q") quit = false
      else if (question == botName) println("Yes?")

      else if (question.toUpperCase == question && question != "") {
        if (yell < 2) println("Whoa,\nrelax a bit will ya")
        else println(randomAns(pickAns()).toUpperCase())
        yell += 1
      }
      else println(randomAns(pickAns()))

    }



}