package albumprinter.rules

/**
 * @author otaykalo
 *
 */

import org.scalatest.{ ShouldMatchers, FunSpec }
class OrderRulesTest extends FunSpec with ShouldMatchers {
  describe("Order rule Engine") {

    describe("BLL tests") {

      describe("OrderLine") {
        val productPrice = 3.0
        val product = new Product("product_id", "PAP_24", "Desc", productPrice)
        val ol = new OrderLine("orderline_id", product, amount = 19)

        it("should have an id") {
          ol.Id should be("orderline_id")
        }
        it("should have a product") {
          ol.Product.Pap should be("PAP_24")
        }
        it("should have an amount") {
          ol.Amount should be(19)
        }
        it("should have initial price"){
          ol.InitialPrice should be(19 * productPrice)
        }
      }
      describe("Product") {
        val product = new Product("product_id", "PAP_24", "Desc", 3.0)
        it("should have an id") {
          product.Id should be("product_id")
        }
        it("should have pap code") {
          product.Pap should be("PAP_24")
        }
        it("should have description") {
          product.Description should be("Desc")
        }
        it("should have initial price") {
          product.Price should be(3.0)
        }
      }
      describe("User") {
        val user = new User(id = "user_id", name = "Oleg", age = 33)
        it("should have name") {
          user.Name should be("Oleg")
        }

        it("should have an age") {
          user.Age should be(33)
        }
        it("should have an id") {
          user.Id should be("user_id")
        }
      }
      describe("Order"){

        val user = new User(id = "user_id", name = "Oleg", age = 33)
        val product1 = new Product("product_id", "PAP_24", "Desc", 3.0)
        val ol1 = new OrderLine("orderline_id", product1, amount = 19)
        val product2 = new Product("product_id", "PAP_24", "Desc", 3.0)
        val ol2 = new OrderLine("orderline_id", product2, amount = 19)
        val order = new Order(id = "order_id", orderLines = List(ol1, ol2 ), user )
        it("should have user"){
          order.User should be(user)
        }
        it("should have id"){
          order.Id should be("order_id")
        }
        
      }
      describe("Discount") {
        val discount = new Discount(name = "dics_1", message = "-10%", delta = 40)
        it("should have name") {
          discount.Name should be("dics_1")

        }
        it("should have message") {
          discount.Message should be("-10%")
        }
        it("should have delta") {
          discount.Delta should be(40)
        }
      }
      describe("Product discount") {
        val discount = new Discount(name = "dics_1", message = "-10%", delta = 40)
        val prodd = new ProductDiscount(productId = "pd1", discount = discount)
        it("should have product id") {
          prodd.ProductId should be("pd1")
        }
        it("should have discount") {
          prodd.Discount should be(discount)
        }
      }
      describe("Order discount") {
        val discount = new Discount(name = "dics_1", message = "-10%", delta = 40)
        val orderd = new OrderDiscount(orderId = "pd1", discount = discount)
        it("should have product id") {
          orderd.OrderId should be("pd1")
        }
        it("should have discount") {
          orderd.Discount should be(discount)
        }
      }
      describe("OrderLine discount") {
        val discount = new Discount(name = "dics_1", message = "-10%", delta = 40)
        val orderld = new OrderLineDiscount(orderLineId = "pd1", discount = discount)
        it("should have product id") {
          orderld.OrderLineId should be("pd1")
        }
        it("should have discount") {
          orderld.Discount should be(discount)
        }
      }
      

    }
  }
}