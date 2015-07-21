package albumprinter.rules

import spray.routing.{ExceptionHandler, HttpService}
import spray.http.StatusCodes.InternalServerError
import spray.util.LoggingContext
import spray.routing.Directive.pimpApply
import spray.routing.directives.CompletionMagnet.fromObject
import spray.routing.directives.CompletionMagnet.fromStatusObject
import spray.json._
import MyJsonProtocol._
/**

 * @author otaykalo
 */
trait RulesService extends HttpService { 
  
  def rootRoute = pingRoute

  /**
   * http://localhost:8000/ping
   */
  def pingRoute = path("ping") {
    get {
      val prod = new Product(id = "id", pap = "pap1", description = "desc", price = 2.45)
      val prod2 = new Product(id = "id2", pap = "pap2", description = "desc2", price = 4.90) 
      val l = List(prod, prod2).toJson.prettyPrint
      complete(l)
     
    }
    post{
      entity(as[String]) { scrive =>
        val parsed = scrive.parseJson.convertTo[List[Product]]
        val h = parsed.head
        complete(h.toJson.prettyPrint)
      }
      
    }
  }
  
  /**
   * This will be picked up by the runRoute(_) and used to intercept Exceptions
   */
  implicit def TutorialExceptionHandler(implicit log: LoggingContext) =
    ExceptionHandler {
      case e: Exception => 
          complete(InternalServerError, s"Message: ${e.getMessage}\n Trace: ${e.getStackTrace.mkString("</br>")}" )
    }
}
  
