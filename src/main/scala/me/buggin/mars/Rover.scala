package me.buggin.mars

import me.buggin.mars.Direction.Direction

/**
  * Created by abuggin on 11/06/17.
  */

object RoverFactory {
  def createARover(p: (Int, Int), c: Char): Rover =
    Rover(Position(p._1, p._2), Direction.getDirectionFromChar(c))
}

case class Rover(position: Position, direction: Direction) {
  def receiveDirective(command: String): Rover = {
    command.foldLeft(this)((rover, step) => rover.singleStep(step.toString))
  }

  private def singleStep(command: String): Rover = {
    require(Command.isValid(command))
    if (command == "") this
    else if (command == "b") Rover(Position(position.x, position.y + 1), direction)
    else if (command == "f") Rover(Position(position.x, position.y - 1), direction)
    else if (command == "r") Rover(position, Direction.turnRight(direction))
    else Rover(position, Direction.turnLeft(direction))
  }
}