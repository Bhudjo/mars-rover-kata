package me.buggin.mars

import me.buggin.mars.Direction.Direction

/**
  * Created by abuggin on 11/06/17.
  */

case class Rover(position: Position, direction: Direction) {
  require(Direction.isValid(direction.toString))

  def receiveDirective(query: String): Rover = {
    require(Command.isValid(query))
    val command = Command.withName(query)
    command match {
      case Command.f =>
        val newPosition = direction match {
          case Direction.N => position.plusOneX
          case Direction.S => position.minusOneX
          case Direction.E => position.plusOneY
          case Direction.W => position.minusOneY
        }
        Rover(newPosition, direction)
      case Command.b =>
        val pos = direction match {
          case Direction.N => position.minusOneX
          case Direction.S => position.plusOneX
          case Direction.E => position.minusOneY
          case Direction.W => position.plusOneY
        }
        Rover(pos, direction)
      case Command.l =>
        val newDirection = direction match {
          case Direction.N => Direction.W
          case Direction.S => Direction.E
          case Direction.E => Direction.N
          case Direction.W => Direction.S
        }
        Rover(position, newDirection)
      case Command.r =>
        val newDirection = direction match {
          case Direction.N => Direction.E
          case Direction.S => Direction.W
          case Direction.E => Direction.S
          case Direction.W => Direction.N
        }
        Rover(position, newDirection)
    }
  }
}