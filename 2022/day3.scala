package aoc

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

  // GAHHH looking over at this now and looking at other solutions there are
  // a couple things I did silly. I should have just used grouped(3) here
  // and I totally forgot about `intersect` lol and instead made my own...
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

  def points(c: Char): Int = c match
    case lc if lc.isLower => c - 'a' + 1
    case uc               => uc - 'A' + 27
