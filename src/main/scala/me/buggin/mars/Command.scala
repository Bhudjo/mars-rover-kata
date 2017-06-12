package me.buggin.mars

/**
  * Created by abuggin on 11/06/17.
  */
object Command extends Enumeration {
  type Command = Value
  val f, b, l, r = Value

  def isValid(command: String): Boolean = {
    Command.values
      .find(_.toString == command || command == "")
      .map(_ => true)
      .getOrElse(throw new IllegalArgumentException("Command should be one of [f,b,l,r]"))
  }
}
