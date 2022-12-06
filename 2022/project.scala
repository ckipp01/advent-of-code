//> using scala "3.2.1"
//> using resourceDir "./resources"
//> using lib "com.lihaoyi::pprint:0.8.1"

package aoc

import scala.io.Source

def getLines(fileName: String): Vector[String] =
  val input = Source.fromResource(fileName)
  input.getLines().toVector

def iterator(fileName: String): Iterator[Char] =
  Source.fromResource(fileName).iterator
