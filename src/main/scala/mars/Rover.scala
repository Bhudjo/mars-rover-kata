package mars

/**
  * Created by abuggin on 11/06/17.
  */

case class Rover(initialPosition: (Int, Int)) {
  def receiveDirective(EmptyPosition: String) = initialPosition
}