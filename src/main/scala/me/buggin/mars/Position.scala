package me.buggin.mars

/**
  * Created by abuggin on 12/06/17.
  */
case class Position(x: Int, y: Int) {
  //TODO later: validation/wraps: latitude 90,-90 longitude 0-360
  def plusOneX = Position(x + 1, y)

  def minusOneX = Position(x - 1, y)

  def plusOneY = Position(x, y + 1)

  def minusOneY = Position(x, y - 1)
}