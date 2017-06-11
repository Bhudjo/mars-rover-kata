package me.buggin.mars

import mars.Rover
import org.scalatest._

/**
  * Created by abuggin on 11/06/17.
  */
class PositionSpec extends WordSpec {

  val EmptyPosition: Any = ""

  "A Rover" when {
    "receives an empty instruction array" should {
      "give back default position" in {
        assert(Rover.receivePosition(EmptyPosition) == Rover.defaultPosition)
      }
    }
  }
}