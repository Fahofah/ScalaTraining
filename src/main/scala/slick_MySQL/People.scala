package slick_MySQL

import slick.jdbc.MySQLProfile.api._

class People(tag: Tag) extends Table[(Int, String, String, Int, String)](tag, "PEOPLE"){
  def id = column[Int]("PER_ID", O.PrimaryKey, O.AutoInc)
  def fName = column[String]("PER_FNAME")
  def lName = column[String]("PER_LNAME")
  def age = column[Int]("PER_AGE")
  def city = column[String]("PER_CITY")
  def * = (id, fName, lName, age, city)
}

