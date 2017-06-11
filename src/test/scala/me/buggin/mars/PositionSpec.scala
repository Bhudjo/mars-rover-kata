package me.buggin.mars

import org.scalatest._

/**
  * Created by abuggin on 11/06/17.
  */
class PositionSpec extends WordSpec {

  "A Rover" when {
    "receives an empty instruction array" should {
      "give back default position" in {
        assert(Rover.receivePosition(EmptyPosition) == Rover.defaultPosition)
      }
    }
  }
}