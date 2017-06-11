package mars

/**
  * Created by abuggin on 11/06/17.
  */

case class Rover(position: (Int, Int), direction: Char) {
  require(Direction.isValid(direction.toString))

  def receiveDirective(command: String): Rover = {
    require(Command.isValid(command))
    this
  }
}