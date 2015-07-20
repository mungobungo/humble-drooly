package albumprinter.rules

import spray.routing.{ExceptionHandler, HttpService}
import spray.http.StatusCodes.InternalServerError
import spray.util.LoggingContext
import spray.routing.Directive.pimpApply
import spray.routing.directives.CompletionMagnet.fromObject
import spray.routing.directives.CompletionMagnet.fromStatusObject
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
      complete("ping!?")
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
  
