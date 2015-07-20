
package albumprinter.rules

/**
 * @author otaykalo
 */
import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.actor.actorRef2Scala

 
object Main {
  def main(args: Array[String]) {
    // we need an ActorSystem to host our service
    implicit val system = ActorSystem()
    
    //create our service actor
    val service = system.actorOf(Props[RulesActor], "rules-service")
    
    //bind our actor to an HTTP port
    IO(Http) ! Http.Bind(service, interface = "localhost", port = 8000)
  }
}