import scala.io.Source

val filename = "C:/Users/Administrator/IdeaProjects/Training/enable1.txt"
val bufferedSource = io.Source.fromFile(filename)
val list_fromFile = (for (line <- bufferedSource.getLines()) yield line).toList
bufferedSource.close

val search_list = Array("vybu","edcf","bknik")

def find_longest(search_word: String) {
  var count = 0
  var word_length = 0
  var found_word = ""

  for (word <- list_fromFile) {
    if (word.sorted.distinct.diff(search_word.sorted) == "") {
      if (word.length > word_length) {
        word_length = word.length
        found_word = word
      }
    }
  }
  println(search_word + " = " + found_word)
}

for(words<-search_list) find_longest(words)


