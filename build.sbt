name := "drools-scala-example"

organization := "us.bleibinha"

version := "0.0.1"

javaHome := sys.env.get("JAVA_HOME")  map file

scalaVersion := "2.11.7"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies ++= Seq(
  "com.thoughtworks.xstream" % "xstream" % "1.4.7",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

val droolsVersion = "6.0.1.Final"

resolvers += "JBoss public" at "http://repository.jboss.org/nexus/content/groups/public/"

libraryDependencies ++= {
  "org.kie" % "kie-api" % droolsVersion ::
    List("drools-compiler", "drools-core", "drools-jsr94", "drools-decisiontables", "knowledge-api")
      .map("org.drools" % _ % droolsVersion)
}

fork in Test := true

initialCommands := "import us.bleibinha.droolsscalaexample._"

libraryDependencies ++= Seq(
    "io.spray" % "spray-can" % "1.1-M8",
    "io.spray" % "spray-http" % "1.1-M8",
    "io.spray" % "spray-routing" % "1.1-M8",
    "io.spray" %%  "spray-json" % "1.3.2",
    "com.typesafe.akka" %% "akka-actor" % "2.4.0",
    "com.typesafe.akka" %% "akka-slf4j" % "2.4.0",
    "com.typesafe.slick" %% "slick" % "3.1.0", 
    "mysql" % "mysql-connector-java" % "5.1.25",
    "net.liftweb" %% "lift-json" % "2.6.2"
)

resolvers ++= Seq(
    "Spray repository" at "http://repo.spray.io",
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Bintray artifactory" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"
)




