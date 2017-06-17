package me.buggin.mars

import me.buggin.mars.Direction.Direction

/**
  * Created by abuggin on 11/06/17.
  */

object RoverFactory {
  def buildRover(position: (Int, Int), direction: Char): Rover =
    Rover(Position(position._1, position._2), Direction.getDirectionFromChar(direction))
}

case class Rover(position: Position, direction: Direction) {
  def receiveDirective(command: String): Rover = {
    command.foldLeft(this)((rover, step) => rover.singleStep(step.toString))
  }

  private def singleStep(command: String): Rover = {
    require(Command.isValid(command))
    if (command == "") this
    else {
      Command.withName(command) match {
        case Command.f => moveForward
        case Command.b => moveBackward
        case Command.l => turnLeft
        case Command.r => turnRight
      }
    }
  }

  private def moveForward: Rover = {
    val newPosition = direction match {
      case Direction.N => position.increaseY
      case Direction.S => position.decreaseY
      case Direction.E => position.increaseX
      case Direction.W => position.decreaseX
    }
    Rover(newPosition, direction)
  }

  private def moveBackward: Rover = {
    val newPosition = direction match {
      case Direction.N => position.decreaseY
      case Direction.S => position.increaseY
      case Direction.E => position.decreaseX
      case Direction.W => position.increaseX
    }
    Rover(newPosition, direction)
  }

  private def turnRight = {
    Rover(position, Direction.turnRight(direction))
  }

  private def turnLeft = {
    Rover(position, Direction.turnLeft(direction))
  }
}