package me.buggin.mars

import mars.Rover
import org.scalatest._

/**
  * Created by abuggin on 11/06/17.
  */
class RoverSpec extends WordSpec {

  val emptyCommand: String = ""

  "A Rover" when {
    "receives an empty instruction string" should {
      "still be in the initial position" in {
        val boredRover = Rover((0, 0), 'W')
        assert(boredRover.receiveDirective(emptyCommand) == boredRover.initialPosition)
      }
    }
    "receives an illegal direction" should {
      "fail to instantiate" in {
        assertThrows[IllegalStateException] {
          val aimlessRover = Rover((0, 0), 'c')
        }
      }
    }
  }
}