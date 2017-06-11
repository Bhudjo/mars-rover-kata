package me.buggin.mars

import mars.Rover
import org.scalatest._

/**
  * Created by abuggin on 11/06/17.
  */
class PositionSpec extends WordSpec {

  val emptyCommand: String = ""

  "A Rover" when {
    "receives an empty instruction string" should {
      "still be in the initial position" in {
        val boredRover = Rover(0, 0)
        assert(boredRover.receiveDirective(emptyCommand) == boredRover.initialPosition)
      }
    }
  }
}