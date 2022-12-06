package aoc

import scala.collection.mutable.Queue

@main def day6Part1() =
  import day6.*
  println(getMarker(4))

@main def day6Part2() =
  import day6.*
  println(getMarker(14))

object day6:
  val input = iterator("6.txt")

  // For some reason my head just went to using a queue and even though
  // I knew you could probably do this easily functional I couldn't shake
  // the queue out of my head so I just ran with it.

  def getMarker(distinctCount: Int) =
    val q = Queue[Char]()
    var count = 0

    def shouldContinue(): Boolean =
      if input.isEmpty then false
      else if q.isEmpty then true
      else if (q.toSet.size == q.size && q.size == distinctCount)
      then false
      else if q.size == distinctCount
      then
        q.dequeue()
        true
      else true

    while shouldContinue() do
      count = count + 1
      val next = input.next()
      q.enqueue(next)

    count
  end getMarker
