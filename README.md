# humble-drooly

simple drools introduction example

to compile you need to install

0) Oracle JDK


0.1) 
(might not be needed, but just in case)
Maven 
https://maven.apache.org/guides/getting-started/windows-prerequisites.html


1) Scala http://www.scala-lang.org/download/2.11.7.html

2) Scala build tool (SBT) http://www.scala-sbt.org/download.html

make sure that Scala and SBT are accessible in command line

in some wierd scenarios you should set JAVA_HOME variable to correct JDK path


after go to root folder of the project and run

'''
sbt clean compile test
'''

it will get all the dependencies , build solution and launch tests.

classes of domain model can be found in src\main\scala\albumprinter\rules\OrderFacts.scala

tests can be found in src\test\scala\albumprinter\rules\OrderRulesTest.scala

rules can be found in src\main\resources\albumprinter.rules\Orders.drl




