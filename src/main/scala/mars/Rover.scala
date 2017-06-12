package mars

/**
  * Created by abuggin on 11/06/17.
  */

case class Rover(position: (Int, Int), direction: Char) {
  require(Direction.isValid(direction.toString))

  def receiveDirective(command: String): Rover = {
    require(Command.isValid(command))
    if (command == "") this
    else if (command == "b") Rover((0, 1), direction)
    else Rover((0, -1), direction)
  }
}