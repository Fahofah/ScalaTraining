import daytoday.ExtraExercises._

class ChatBot_tests extends TestBaseClass {

  "This function" should "return a greeting with thee bots name" in {
    assert(ChatBot.greet == s"Hi I am ${ChatBot.BotName}, I am here to help. Ask me anything!")
  }
  "This function" should "return randomly 0 or 1" in {
    assert(Array(1,0) contains ChatBot.pickAns )
  }
  "This function" should "return a goodby string when q is inputted" in {
    assert(ChatBot.script("q") == "Thank you and byebye!")
  }
  it should "output 'Yes?' if it's a name is inputted" in {
    assert(ChatBot.script(ChatBot.BotName) == "Yes?")
  }
  it should "print one of the random numbers if any otherr string is inputted" in {
    assert(ChatBot.script("what") == "I don’t know, let me google it up for you" | ChatBot.script("hey") == "I don’t know and I’m too lazy to look it up...")
  }
  it should "print out a warning massage if all capital string is passed" in {
    assert(ChatBot.script("TELL ME") == "Whoa,\nrelax a bit will ya")
  }
  it should "print out one of the random answers in capital if more than two consecutive capital strings are inputted" in {
    ChatBot.script("WHAT")
    ChatBot.script("WHY")
    assert(Array("I DON’T KNOW, LET ME GOOGLE IT UP FOR YOU","I DON’T KNOW AND I’M TOO LAZY TO LOOK IT UP...") contains ChatBot.script("HEY") )
  }

}
