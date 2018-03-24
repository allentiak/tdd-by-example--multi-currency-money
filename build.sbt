lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.11.12"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "multi-currency-money",
    libraryDependencies ++= Seq(
 	    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
      )
    )
