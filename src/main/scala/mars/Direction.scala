package mars

/**
  * Created by abuggin on 11/06/17.
  */
object Direction extends Enumeration {
  type Direction = Value
  val N, S, W, E = Value

  def isValid(direction: String): Boolean = {
    Direction.values
      .find(_.toString == direction)
      .map(_ => true)
      .getOrElse(throw new IllegalStateException("Direction should be one of [N,S,W,E]"))
  }

}
