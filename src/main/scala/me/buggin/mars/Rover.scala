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
    command.foldLeft(this)((rover, step)=> rover.singleStep(step.toString))
  }

  private def singleStep(query: String): Rover = {
    require(Command.isValid(query))
    val command = Command.withName(query)

    def moveForward = {
      val newPosition = direction match {
        case Direction.N => position.plusOneX
        case Direction.S => position.minusOneX
        case Direction.E => position.plusOneY
        case Direction.W => position.minusOneY
      }
      Rover(newPosition, direction)
    }

    def moveBackwards = {
      val pos = direction match {
        case Direction.N => position.minusOneX
        case Direction.S => position.plusOneX
        case Direction.E => position.minusOneY
        case Direction.W => position.plusOneY
      }
      Rover(pos, direction)
    }

    def turnLeft = {
      val newDirection = direction match {
        case Direction.N => Direction.W
        case Direction.S => Direction.E
        case Direction.E => Direction.N
        case Direction.W => Direction.S
      }
      Rover(position, newDirection)
    }

    def turnRight = {
      val newDirection = direction match {
        case Direction.N => Direction.E
        case Direction.S => Direction.W
        case Direction.E => Direction.S
        case Direction.W => Direction.N
      }
      Rover(position, newDirection)
    }

    command match {
      case Command.f =>
        moveForward
      case Command.b =>
        moveBackwards
      case Command.l =>
        turnLeft
      case Command.r =>
        turnRight
    }
  }
}