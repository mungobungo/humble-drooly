package albumprinter.rules

/**
 * @author otaykalo
 *
 */

import org.scalatest.{ ShouldMatchers, FunSpec }
class OrderRulesTest extends FunSpec with ShouldMatchers {
  describe("Order rule Engine") {

    describe("BLL tests") {
      val ol = new OrderLine("orderline_id", new Product("product_id", "PAP_24", "Desc", 3.0), amount = 19)

      describe("OrderLine") {
        it("should have an id") {
          ol.Id should be("orderline_id")
        }
        it("should have a product") {
          ol.Product.Pap should be("PAP_24")
        }
        it("should have an amount"){
          ol.Amount should be(19)
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
    }
  }
}