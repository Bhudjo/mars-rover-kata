package mars

/**
  * Created by abuggin on 11/06/17.
  */

case class Rover(initialPosition: (Int, Int), direction: Char) {
  require(Direction.withName(direction.toString) != null)

  def receiveDirective(EmptyPosition: String) = initialPosition
}