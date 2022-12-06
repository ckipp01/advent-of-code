package aoc

import scala.collection.mutable.Queue

@main def day6Part1() =
  import day6.*
  val one = getMarker(4)
  println(one)
  val two = getMarker2(4)
  assert(one == two)
  println(two)

@main def day6Part2() =
  import day6.*
  val one = getMarker(14)
  println(one)
  val two = getMarker2(14)
  assert(one == two)
  println(two)

object day6:
  val input = iterator("6.txt")

  // For some reason my head just went to using a queue and then
  // I couldn't shake it! So I did it with a queue and then actually
  // with sliding down below.

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

  def getMarker2(distinctCount: Int) =
    getLines("6.txt").head
      .sliding(distinctCount)
      .indexWhere(_.toSet.size == distinctCount) + distinctCount
