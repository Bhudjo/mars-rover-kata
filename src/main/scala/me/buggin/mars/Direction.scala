package me.buggin.mars

/**
  * Created by abuggin on 11/06/17.
  */
object Direction extends Enumeration {
  def getDirection(direction: Char): Direction = {
    Direction
      .values
      .find(_.toString == direction.toString)
      .getOrElse(throw new IllegalStateException("Direction should be one of [N,S,W,E]"))
  }

  type Direction = Value
  val N, S, W, E = Value

  def turnLeft(direction: Direction): Direction = direction match {
    case N => W
    case W => S
    case S => E
    case E => N
  }

  def turnRight(direction: Direction): Direction = direction match {
    case N => E
    case E => S
    case S => W
    case W => N
  }
}
