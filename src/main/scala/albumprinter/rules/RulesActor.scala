package albumprinter.rules

import akka.actor._
import spray.http.StatusCodes._
import albumprinter.rules.RulesService


/**
 * @author otaykalo
 */
class RulesActor extends RulesService with Actor {
  
  def actorRefFactory = context;
  def receive = runRoute(rootRoute);
}