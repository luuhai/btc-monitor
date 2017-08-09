package btc.monitor

import btc.monitor.actor._

import akka.util.Timeout
import akka.pattern.ask
import akka.actor.{ActorRef, ActorSystem, Props}

import scala.concurrent.duration._
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global


object Main {
  implicit val timeout = Timeout(5.seconds)
  val system = ActorSystem("CoinMonitor")
  val starter = system.actorOf(Props[Starter], "Starter")

  def main(args: Array[String]): Unit = {
    val control = Await.result(
      (starter ? Starter.GiveMeControl).mapTo[ActorRef], 5.seconds
    )
    println("\t\t=============== TOP 10 COIN VALUE MONITOR ===============\n")
    println(f"${"Name"}%-20s${"Symbol"}%-15s${"Price (USD)"}%-15s${"Price (BTC)"}%-15s" +
            f"${"Market Cap"}%-20s${"Percent Change (1H)"}%-25s" +
            f"${"Percent Change (24H)"}%-25s${"Percent Change (7D)"}%-25s")
    print("\n" * 10)
    system.scheduler.schedule(0.seconds, 15.seconds) {
      control ! Controller.Start
    }
  }
}
