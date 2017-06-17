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
        assert(stillValidRover == RoverFactory.createARover((-1, 0), 'W'))
      }
      "still have the same direction" in {
        val stillValidRover = validRover receiveDirective "f"
        assert(stillValidRover.direction == validRover.direction)
      }
    }
    "receives a backward command" should {
      "move backward in its direction" in {
        val stillValidRover = validRover receiveDirective "b"
        assert(stillValidRover == RoverFactory.createARover((1, 0), 'W'))
      }
    }
    "receives two forward commands" should {
      "move two steps forward" in {
        val babyStepsRover = validRover receiveDirective "ff"
        assert(babyStepsRover == RoverFactory.createARover((-2, 0), 'W'))
      }
    }
    "receives three forward commands" should {
      "move three steps forward" in {
        val babyStepsRover = validRover receiveDirective "fff"
        assert(babyStepsRover == RoverFactory.createARover((-3, 0), 'W'))
      }
    }
    "receives a mix of forward and backward commands" should {
      "move three steps forward" in {
        val babyStepsRover = validRover receiveDirective "fffbbb"
        assert(babyStepsRover == RoverFactory.createARover((0, 0), 'W'))
      }
    }
  }
  "Turning: A Rover" when {
    "is facing West and receives a left command" should {
      "turn up to face South" in {
        val turningRover = validRover receiveDirective "l"
        assert(turningRover.direction == Direction.S)
      }
    }
    "is facing West and receives three left command" should {
      "turn up to face North" in {
        val turningRover = validRover receiveDirective "lll"
        assert(turningRover.direction == Direction.N)
      }
    }
    "is facing West and receives four right command" should {
      "is still facing West" in {
        val turningRover = validRover receiveDirective "rrrr"
        assert(turningRover.direction == Direction.W)
      }
    }
  }
  "Cruising: A Rover" when {
    "receives a mix of move and turn commands" should {
      "move accordingly" in {
        val cruisingRover = validRover receiveDirective "fffrfff"
        assert(cruisingRover == RoverFactory.createARover((-3, 3), 'N'))
        val comingBackRover = cruisingRover receiveDirective "rfffrfffr"
        assert(comingBackRover == validRover)
      }
    }
  }
}