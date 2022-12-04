package aoc

@main def day4Part1() =
  import day4.*

  def checkContains(section1: Range, section2: Range): Boolean =
    (section1.contains(section2.start) && section1.contains(
      section2.end
    )) || (section2.contains(section1.start) && section2.contains(section1.end))

  val count = lines
    .map(_.split(","))
    .count(parts => checkContains(toRange(parts(0)), toRange(parts(1))))

  println(count)

@main def day4Part2() =
  import day4.*

  def overlaps(section1: Range, section2: Range): Boolean =
    section1.intersect(section2).size > 0

  val count = lines
    .map(_.split(","))
    .count(parts => overlaps(toRange(parts(0)), toRange(parts(1))))

  println(count)

object day4:
  val lines = getLines("4.txt")

  def toRange(range: String) =
    val Array(part1, part2) = range.split("-")
    Range(part1.toInt, part2.toInt).inclusive
