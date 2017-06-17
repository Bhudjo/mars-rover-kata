package me.buggin.mars

import me.buggin.mars.Direction.Direction

/**
  * Created by abuggin on 11/06/17.
  */

object RoverFactory {
  def createARover(p: (Int, Int), direction: Char): Rover =
    Rover(Position(p._1, p._2), Direction.getDirection(direction))
}

case class Rover(position: Position, direction: Direction) {
  def receiveDirective(command: String): Rover = {
    require(Command.isValid(command))
    if (command == "") this
    else if (command == "b") Rover(Position(0, 1), direction)
    else Rover(Position(0, -1), direction)
  }
}