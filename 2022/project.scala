//> using scala "3.2.1"
//> using resourceDir "./resources"

package aoc

import scala.io.Source

def getLines(fileName: String): Vector[String] =
  val input = Source.fromResource(fileName)
  input.getLines().toVector
