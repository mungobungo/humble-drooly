package albumprinter.rules

import java.util

import scala.collection.convert.wrapAsScala._
import java.beans._
import spray.json._
/**s
 * Created by otaykalo on 12-7-2015.
 * Original domain model for orders checking
 */

sealed trait OrderFact


class Discount(name: String, message: String, delta: Double){
  val Name = name
  val Message = message
  val Delta = delta
}

class ProductDiscount(productId: String, discount: Discount) {
  val ProductId= productId
  val Discount = discount
}

class OrderLineDiscount(orderLineId : String, discount: Discount ){
  val OrderLineId = orderLineId
  val Discount = discount
}

class OrderDiscount(orderId : String, discount: Discount){
  val OrderId = orderId
  val Discount = discount
}

case class User(id:String, name: String, age: Int) {
  val Name = name
  val Age = age
  val Id = id
}

case class Product(id: String, pap: String, description: String, price: Double) {


}

//case  object PrintProduct1013 extends Product(1, "PAP_101", "print 10x13", 0.1)
//
//case object PrintProduct2027 extends Product(2, "PAP_102", "print 20x27", 0.15)
//
//case object EnlargementProduct100 extends  Product (3, "PAP_201", "enlargement 100", 1.10 )
//
//case object EnlargementProduct200 extends Product (4, "PAP_202", "enlargement 200", 1.50 )
//
//case object WallDecorAluminiumProduct extends Product (5, "PAP_301", "Wall decor aluminium", 40)
//
//case object WallDecorWoodProduct extends  Product (6, "PAP_302", "Wall decor wood", 60)


class OrderLine(id:String, product: Product, amount: Int) extends OrderFact {

  val Amount = amount
  val Product = product
  val Id = id
  //val Discounts : java.util.List[Discount]  = new util.ArrayList[Discount]
  val InitialPrice : Double = {product.price * amount}
  //def TotalPrice = InitialPrice - Discounts.map(_.Delta).sum

}

class Order (id:String, orderLines: List[OrderLine], user: User) extends OrderFact {
  val Id = id
  val OrderLines = orderLines
  val User = user
  //val Discounts : java.util.List[Discount]  = new util.ArrayList[Discount]()
  //def InitialPrice = OrderLines.map(_.TotalPrice).sum
  //def TotalPrice = InitialPrice - Discounts.map(_.Delta).sum
}


object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val colorFormat = jsonFormat4(Product)
}