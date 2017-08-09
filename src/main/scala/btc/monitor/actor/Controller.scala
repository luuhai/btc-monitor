package btc.monitor.actor

import akka.actor.{Actor, ActorRef}
import btc.monitor.model.Coin
import dispatch._
import io.circe._
import io.circe.parser._

import scala.concurrent.ExecutionContext.Implicits.global

object Controller {
  case object Start
}

class Controller(representor: ActorRef) extends Actor {
  import Controller._
  import Representor._

  implicit val decoderCoin: Decoder[Coin] = Decoder.instance( c =>
    for {
      id <- c.downField("id").as[String]
      name <- c.downField("name").as[String]
      symbol <- c.downField("symbol").as[String]
      priceUSD <- c.downField("price_usd").as[Double]
      priceBTC <- c.downField("price_btc").as[Double]
      marketCapUSD <- c.downField("market_cap_usd").as[Double]
      percentChange1H <- c.downField("percent_change_1h").as[Double]
      percentChange24H <- c.downField("percent_change_24h").as[Double]
      percentChange7D <- c.downField("percent_change_7d").as[Double]
    } yield new Coin(id, name, symbol, priceUSD, priceBTC,
                     marketCapUSD, percentChange1H,
                     percentChange24H, percentChange7D)
  )


  def receive = {
    case Start => {
      val request = url("https://api.coinmarketcap.com/v1/ticker/?limit=10")
      val response = Http.default(request OK as.String)
      for (jsonString <- response) {
        val json = parse(jsonString).getOrElse(Json.Null)
        json.as[List[Coin]] match {
          case Right(coins) => representor ! Print(coins)
        }
      }
    }
  }
}
