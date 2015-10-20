package albumprinter.rules

/**
 * Created by otaykalo on 12-7-2015.
 * Customly build rule engine that can be used via RESTful interface
 */

import java.util
import java.util.ArrayList


import scala.collection.JavaConversions.iterableAsScalaIterable

class OrdersEngine {
  def calculateOrderLine(orderLine: OrderLine) : List[String] = {
    val orderLineDiscounts = new util.ArrayList[String]
    val session = Kie.newSession

   // session.setGlobal("orderLineDiscounts", orderLineDiscounts)
    session.insert(orderLine)
    session.fireAllRules()
    session.dispose()


    orderLineDiscounts.toList
  }
  def calculateOrder(order: Order) = {
    val session = Kie.newSession

    session.insert(order)
    //order.OrderLines.forEach(session.insert)
    session.insert(order.User)
    for (x <- order.OrderLines) {session.insert(x)}
    session.fireAllRules()
    session.dispose()

  }
}
