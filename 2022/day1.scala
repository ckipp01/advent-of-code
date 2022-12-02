package aoc

import scala.annotation.tailrec

@main def day1Part1() =
  import day1.*
  println(totals.head)

@main def day1Part2() =
  import day1.*
  println(totals.take(3).sum)

object day1:
  private val lines = getLines("1.txt")

  @tailrec()
  private def recurse(
      grouped: Vector[Vector[Int]],
      remaining: Vector[String]
  ): Vector[Vector[Int]] =
    remaining match
      case r if r.isEmpty => grouped
      case _ =>
        val newGroup = remaining
          .takeWhile(_ != "")
          .map(_.toInt)
        recurse(
          grouped :+ newGroup,
          remaining.drop(newGroup.size + 1)
        )

  val totals = recurse(Vector.empty, lines).map(_.sum).sorted.reverse
