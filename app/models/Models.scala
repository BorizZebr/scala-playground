package models

import org.joda.time.DateTime

/**
  * Created by borisbondarenko on 25.05.16.
  */
case class Competitor(id: Option[Long], name: String, url: String)

case class Good(id: Option[Long], competitorId: Option[Long], name: String, price: Double, imgUrl: String, url: String)

case class Review(id: Option[Long], competitorId: Option[Long], author: String, text: String, date: DateTime)

case class ChartPoint(id: Option[Long], competitorId: Option[Long], x: DateTime, amount: Int, change: Int)