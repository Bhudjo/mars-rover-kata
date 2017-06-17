package me.buggin.mars

import org.scalatest._

/**
  * Created by abuggin on 11/06/17.
  */
class RoverSpec extends WordSpec {
  val validRover = RoverFactory.createARover((0, 0), 'W')

  "Init: A Rover" when {
    "receives an empty instruction string" should {
      "still be in the initial position" in {
        val boredRover = validRover
        assert(boredRover.receiveDirective("") == boredRover)
      }
    }
    "is created with an illegal direction" should {
      "fail to instantiate" in {
        assertThrows[IllegalStateException] {
          val aimlessRover = RoverFactory.createARover((0, 0), 'c')
        }
      }
    }
    "receives an illegal command" should {
      "throw an error" in {
        assertThrows[IllegalArgumentException] {
          val watRover = validRover receiveDirective "qwerty"
        }
      }
    }
  }
  "Moving: A Rover" when {
    "receives a forward command" should {
      "move forward in its direction" in {
        val stillValidRover = validRover receiveDirective "f"
        assert(stillValidRover == RoverFactory.createARover((0, -1), 'W'))
      }
      "still have the same direction" in {
        val stillValidRover = validRover receiveDirective "f"
        assert(stillValidRover.direction == validRover.direction)
      }
    }
    "receives a backward command" should {
      "move backward in its direction" in {
        val stillValidRover = validRover receiveDirective "b"
        assert(stillValidRover == RoverFactory.createARover((0, 1), 'W'))
      }
    }
    "receives two forward commands" should {
      "move two steps forward" in {
        val babyStepsRover = validRover receiveDirective "ff"
        assert(babyStepsRover == RoverFactory.createARover((0,-2),'W'))
      }
    }
  }
}