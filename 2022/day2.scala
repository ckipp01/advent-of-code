package aoc

import scala.io.Source

@main def day2Part1() =
  import day2.*

  // A - Rock      X
  // B - Paper     Y
  // C - Scissors  Z
  def determine(opponent: String, you: String) =
    (opponent, you) match
      case ("A", "X") => draw + rockValue
      case ("A", "Y") => win + paperValue
      case ("A", "Z") => loss + scissorValue

      case ("B", "X") => loss + rockValue
      case ("B", "Y") => draw + paperValue
      case ("B", "Z") => win + scissorValue

      case ("C", "X") => win + rockValue
      case ("C", "Y") => loss + paperValue
      case ("C", "Z") => draw + scissorValue
      case _ =>
        throw new Exception("found something I shouldn't have")

  val results =
    lines
      .map(_.splitAt(1))
      .map((a, b) => determine(a.trim(), b.trim()))
      .sum

  println(results)

@main def day2Part2() =
  import day2.*

  // X lose
  // Y draw
  // Z win
  def determine(opponent: String, you: String) =
    (opponent, you) match
      case ("A", "X") => loss + scissorValue
      case ("A", "Y") => draw + rockValue
      case ("A", "Z") => win + paperValue

      case ("B", "X") => loss + rockValue
      case ("B", "Y") => draw + paperValue
      case ("B", "Z") => win + scissorValue

      case ("C", "X") => loss + paperValue
      case ("C", "Y") => draw + scissorValue
      case ("C", "Z") => win + rockValue
      case _ =>
        throw new Exception("found something I shouldn't have")

  val results =
    lines
      .map(_.splitAt(1))
      .map((a, b) => determine(a.trim(), b.trim()))
      .sum

  println(results)

object day2:
  private val input = Source.fromResource("2.txt")
  val lines = input.getLines().toVector

  val loss = 0
  val draw = 3
  val win = 6

  val rockValue = 1
  val paperValue = 2
  val scissorValue = 3
