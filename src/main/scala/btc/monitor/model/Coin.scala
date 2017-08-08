package btc.monitor.model

case class Coin (id: String, name: String, symbol: String,
                 priceUSD: Double, priceBTC: Double,
                 marketCapUSD: Double,
                 percentChange1h: Double,
                 percentChange24h: Double,
                 percentChange7d: Double)