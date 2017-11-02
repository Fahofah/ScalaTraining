package daytoday.helpers

trait MockOutput extends Output {
  var messages: Seq[Any] = Seq()

  override def print(s: Any) = messages = messages :+ s
}