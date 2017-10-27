import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener

val english = ('a' to 'z')
val morse = List(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
val morseSentence = ".... .. /-- -.-- /-. .- -- . /.. ... /..-. .- .... .-. .."


val words = morseSentence.split("\\s/")
for(word <- words){
  word.split("\\s").foreach(letter => translate(letter))
}



def translate (letter: String): Unit ={
  println(english(morse.indexOf(letter)))
}

