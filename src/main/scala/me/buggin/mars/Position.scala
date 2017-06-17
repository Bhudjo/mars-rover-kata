package me.buggin.mars

/**
  * Created by abuggin on 12/06/17.
  */
case class Position(x: Int, y: Int) {
  def increaseX = Position(x + 1, y)

  def decreaseX = Position(x - 1, y)

  def increaseY = Position(x, y + 1)

  def decreaseY = Position(x, y - 1)
}