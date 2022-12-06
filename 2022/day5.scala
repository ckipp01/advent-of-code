package aoc

@main def day5Part1() =
  import day5.*

  val result = restack(instructions, stacks, retain = false).toList.sorted.map {
    case (key, stacks) =>
      stacks.last
  }.mkString

  println(result)

@main def day5Part2() =
  import day5.*

  val result = restack(instructions, stacks, retain = true).toList.sorted.map {
    case (key, stacks) =>
      stacks.last
  }.mkString

  println(result)

object day5:
  val lines = getLines("5.txt")

  val diagram = lines.takeWhile(_.nonEmpty)
  val cols = diagram.last.split(' ').flatMap(_.toIntOption).toVector

  val rawStacks = diagram
    .map { line =>
      line
        .grouped(4)
        .map(_.mkString)
        .collect {
          case s"[$c]"  => Option(c.head)
          case s"[$c] " => Option(c.head)
          case _        => None
        }
        .toVector
    }

  val stacks = cols.zip(rawStacks.transpose.map(_.flatten.reverse)).toMap

  final case class Move(count: Int, from: Int, to: Int)

  val instructions = lines
    .dropWhile(!_.startsWith("move"))
    .collect { case s"move $count from $moveFrom to $moveTo" =>
      Move(count.toInt, moveFrom.toInt, moveTo.toInt)
    }

  def restack(
      instructions: Vector[Move],
      stacks: Map[Int, Vector[Char]],
      retain: Boolean
  ): Map[Int, Vector[Char]] =
    instructions.foldLeft(stacks) { case (state, move) =>
      val toMove =
        if retain then state(move.from).takeRight(move.count)
        else state(move.from).takeRight(move.count).reverse

      state
        .updated(move.from, state(move.from).dropRight(move.count))
        .updated(move.to, state(move.to) ++ toMove)
    }
