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

    def goBackward: _root_.me.buggin.mars.Rover = {
      val newPosition = direction match {
        case Direction.N => Position(position.x, position.y-1)
        case Direction.S => Position(position.x, position.y +1)
        case Direction.E => Position(position.x-1, position.y)
        case Direction.W => Position(position.x+1, position.y)
      }
      Rover(newPosition, direction)
    }

    def moveForward: Rover = {
      val newPosition = direction match {
        case Direction.N => Position(position.x, position.y +1)//increaseY
        case Direction.S => Position(position.x, position.y -1)//decreaseY
        case Direction.E => Position(position.x+1, position.y)//increaseX
        case Direction.W => Position(position.x-1, position.y)//decreaseX
      }
      Rover(newPosition, direction)
    }

    if (command == "") this
    else if (command == "b") goBackward
    else if (command == "f") moveForward
    else if (command == "r") Rover(position, Direction.turnRight(direction))
    else Rover(position, Direction.turnLeft(direction))
  }
}