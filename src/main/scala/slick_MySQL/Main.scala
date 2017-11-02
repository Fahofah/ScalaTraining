package slick_MySQL

import slick.dbio.Effect
import slick.jdbc.MySQLProfile

import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.MySQLProfile.api._
import slick.sql.FixedSqlAction

import scala.util._
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object Main extends App {

  val db = Database.forConfig("mysqlDB")
  val peopleTable = TableQuery[People]
  val dropPeopleCmd = DBIO.seq(peopleTable.schema.drop)
  val initPeopleCmd = DBIO.seq(peopleTable.schema.create)

  //do a drop followed by initialisePeople
  def dropDB(): Unit = {
    val dropFuture = Future {
      db.run(dropPeopleCmd)
    }
    //Attempt to drop the table, Await does not block here
    Await.result(dropFuture, Duration.Inf).andThen {
      case Success(_) =>
        initialisePeople
      case Failure(error) =>
        println("Dropping the table failed due to: " + error.getMessage)
        initialisePeople
    }
  }

  def initialisePeople(): Unit = {
    val setupFuture = Future {
      db.run(initPeopleCmd)
    }
    Await.result(setupFuture,Duration.Inf).andThen {
      case Success(_) => runQuery
      case Failure(error) =>
        println("Initialising the table failed due to: " + error.getMessage)
    }
  }

  def runQuery(): Unit = {
    val insertPeople = Future {
      val query = peopleTable ++= Seq(
        (10, "Jack", "Wood", 36),
        (20, "Tim", "Brown", 24),
        (12,"Tom","Marcus", 42),
        (12,"Richard","Wood", 23),
        (12,"Mary","Marcus", 41),
        (12,"Evan","Maxis", 72)
      )
      // insert into `PEOPLE` (`PER_FNAME`,`PER_LNAME`,`PER_AGE`)  values (?,?,?)
      println(query.statements.head)
      // would print out the query one line up
      db.run(query)
    }
    Await.result(insertPeople, Duration.Inf).andThen {
      case Success(_) => listPeople
      case Failure(error) => println("Welp! Something went wrong! " + error.getMessage)
    }
  }

  def listPeople(): Unit = {
    val queryFuture = Future {
      db.run(peopleTable.result).map(_.foreach{
        case (id, fName, lName, age) => println(s" $id $fName $lName $age ")
      })
    }
    Await.result(queryFuture, Duration.Inf).andThen( {
      case Success(_) => db.close()
      case Failure(error) =>
        println("Listing people failed due to: " + error.getMessage)
    })
  }

  def updatePeople: Unit = {
    val queryUp = Future {
      db.run(peopleTable.filter(_.fName === "Jack").map(_.age).update(52))

    }
    Await.result(queryUp,Duration.Inf).andThen( {
      case Success(_) => listPeople()
      case Failure(error) =>
        println("Update failed due to: " + error.getMessage)
    })
  }

  def deletePeople: Unit = {
    val query = peopleTable.filter(_.lName === "Brown")
    val action = query.delete
    val affectedRowsCount : Future[Int] = db.run(action)
    val sql = action.statements.head
    println(sql)
  }

  def searhPeople: Unit = {
    db.run((peopleTable.filter(_.age > 40)).result.map(_.foreach{
      case (id, fName, lName, age) => println(s"$fName $lName $age ")
    }))
  }

  def countPeople(): FixedSqlAction[Int, MySQLProfile.api.NoStream, Effect.Read] = {
    val peopleCount = peopleTable.length.result
    peopleCount
  }

  println(countPeople())
}


