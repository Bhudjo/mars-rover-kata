package me.buggin.mars

/**
  * Created by abuggin on 11/06/17.
  */
object Direction extends Enumeration {
  type Direction = Value
  val N, S, W, E = Value

  def getDirectionFromChar(c: Char): Direction = {
    Direction
      .values
      .find(_.toString == c.toString)
      .getOrElse(throw new IllegalStateException("Direction should be one of [N,S,W,E]"))
  }

  def turnLeft(d: Direction): Direction = d match {
    case N => W
    case W => S
    case S => E
    case E => N
  }

  def turnRight(d: Direction): Direction = d match {
    case N => E
    case E => S
    case S => W
    case W => N
  }
}
