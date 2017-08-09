package btc.monitor.actor

import akka.actor.Actor
import btc.monitor.model.Coin

object Representor {
  case class Print(coins: Seq[Coin])

  def apply() = new Representor
}

class Representor extends Actor {
  import Representor._

  def receive = {
    case Print(coins) => {
      print("\u001b[10A")
      for (coin <- coins)
        println(f"${coin.name}%-20s${coin.symbol}%-15s" +
                f"${coin.priceUSD}%-15f${coin.priceBTC}%-15f" +
                f"${coin.marketCapUSD}%-20.2f" +
                f"${coin.percentChange1h}%-25.2f" +
                f"${coin.percentChange24h}%-25.2f" +
                f"${coin.percentChange7d}%-25.2f")
    }
  }
}
