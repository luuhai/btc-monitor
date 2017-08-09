package btc.monitor.actor

import akka.actor.{Actor, Props}

object Starter{
  case object GiveMeControl
}

class Starter extends Actor {
  import Starter._

  val representor = context.actorOf(Props(Representor()), "Representor")
  val controls = context.actorOf(
    Props(new Controller(representor)), "Controller")

  def receive = {
    case GiveMeControl =>
      sender ! controls
  }
}
