package albumprinter.rules

/**
 * Created by otaykalo on 12-7-2015.
 * simple Kie singleton for using with order rules
 */

import org.kie.api.KieServices
import org.kie.api.runtime.{StatelessKieSession, KieContainer}

object Kie {
  private lazy val kieServices: KieServices = KieServices.Factory.get()
  private lazy val kContainer: KieContainer = kieServices.getKieClasspathContainer

  def newStatelessSession: StatelessKieSession = kContainer.newStatelessKieSession()

  def executeStateless(facts: List[Any]) = newStatelessSession.execute(facts)

  def newSession = kContainer.newKieSession()
}
