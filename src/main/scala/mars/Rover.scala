package mars

/**
  * Created by abuggin on 11/06/17.
  */

case class Rover(initialPosition: (Int, Int), direction: Char) {
  def receiveDirective(EmptyPosition: String) = initialPosition
}