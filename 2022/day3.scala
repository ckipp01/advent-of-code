package aoc

import scala.collection.View.Unfold

@main def day3Part1() =
  import day3.*
  val totals =
    lines.map { line =>
      val (firstCompartment, secondCompartment) = line.splitAt(line.length / 2)
      val containedInBoth = secondCompartment.toSet.collect {
        case item if firstCompartment.contains(item) =>
          points(item)
      }
      containedInBoth.sum
    }

  println(totals.sum)

@main def day3Part2() =
  import day3.*

  val badges = Vector.unfold(lines) { left =>
    val (toCheck, carryOn) = left.splitAt(3)
    val collected = toCheck
      .map(_.toSet)
      .flatten
      .groupBy(identity)
      .collectFirst {
        case (key, group) if group.size == 3 => key
      }

    collected.map((_, carryOn))
  }

  val total = badges.map(points(_)).sum
  println(total)

object day3:
  val lines = getLines("3.txt")

  val points: Map[Char, Int] = Map(
    'a' -> 1,
    'b' -> 2,
    'c' -> 3,
    'd' -> 4,
    'e' -> 5,
    'f' -> 6,
    'g' -> 7,
    'h' -> 8,
    'i' -> 9,
    'j' -> 10,
    'k' -> 11,
    'l' -> 12,
    'm' -> 13,
    'n' -> 14,
    'o' -> 15,
    'p' -> 16,
    'q' -> 17,
    'r' -> 18,
    's' -> 19,
    't' -> 20,
    'u' -> 21,
    'v' -> 22,
    'w' -> 23,
    'x' -> 24,
    'y' -> 25,
    'z' -> 26,
    'A' -> 27,
    'B' -> 28,
    'C' -> 29,
    'D' -> 30,
    'E' -> 31,
    'F' -> 32,
    'G' -> 33,
    'H' -> 34,
    'I' -> 35,
    'J' -> 36,
    'K' -> 37,
    'L' -> 38,
    'M' -> 39,
    'N' -> 40,
    'O' -> 41,
    'P' -> 42,
    'Q' -> 43,
    'R' -> 44,
    'S' -> 45,
    'T' -> 46,
    'U' -> 47,
    'V' -> 48,
    'W' -> 49,
    'X' -> 50,
    'Y' -> 51,
    'Z' -> 52
  )
