// Ex 29
println("Ex29")
val theList = List(1,2,3,4,6,7,8,4,2)
theList.foreach(println)

//Ex 30
println("Ex30")
val fruitList = List("Apple", "Raspberry", "Lemon", "Kiwi", "Strawberry")
var longest = ""
fruitList.foreach(word => if (word.length > longest.length) longest = word )
longest

// Ex 31 - Functional
println("Ex31")


val test = java.util.TimeZone.getAvailableIDs.map(word=> word.split("/")).filter(slot=> slot.length > 1).foreach(countryCity=> countryCity(1))
test