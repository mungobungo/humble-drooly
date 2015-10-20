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


after that, go to root folder of the project and run

``` Batchfile
sbt clean compile test
```

it will get all the dependencies , build solution and launch tests.

output should be something like this
```
[info]     - should have product id
[info]     - should have discount
[info]     OrderLine discount
[info]     - should have product id
[info]     - should have discount
[info]   rule engine Tests
[info]   - should get 2 discounts - one for PAP, other for small amount
[info] Run completed in 2 seconds, 234 milliseconds.
[info] Total number of tests run: 23
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 23, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 8 s, completed 20-okt-2015 16:40:57
```

classes of domain model can be found in [OrderFacts.scala](src/main/scala/albumprinter/rules/OrdersFacts.scala)

tests can be found in [OrderRulesTest.scala](src/test/scala/albumprinter/rules/OrderRulesTest.scala)

rules can be found in [Orders.drl](src/main/resources/albumprinter.rules/Orders.drl)




