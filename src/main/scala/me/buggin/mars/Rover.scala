package me.buggin.mars

/**
  * Created by abuggin on 11/06/17.
  */

case class Rover(position: Position, direction: Char) {
  require(Direction.isValid(direction.toString))

  def receiveDirective(command: String): Rover = {
    require(Command.isValid(command))
    if (command == "") this
    else if (command == "b") Rover(Position(0, 1), direction)
    else Rover(Position(0, -1), direction)
  }
}