ThisBuild / scalaVersion := "3.3.3"

val sparkVersion = "3.5.1"

lazy val common = project
  .settings(
    scalaVersion := "3.3.3",
    libraryDependencies ++= commonDependencies
  )

lazy val commonDependencies = Seq (
  // For Spark
  ("org.apache.spark" %% "spark-core" % sparkVersion).cross(CrossVersion.for3Use2_13) % "provided",
  ("org.apache.spark" %% "spark-sql"  % sparkVersion).cross(CrossVersion.for3Use2_13) % "provided",

  // For ScalaTest
  ("org.scalactic" %% "scalactic"         % "3.2.18") , 
  ("org.scalatest" %% "scalatest"         % "3.2.18") exclude("org.scala-lang.modules", "scala-xml_3") ,
  ("org.scalatest" %% "scalatest-funspec" % "3.2.18") exclude("org.scala-lang.modules", "scala-xml_3")
)

lazy val chapter_001 = project
  .in(file("./chapters/001-hello-scala3"))
  .settings(name := "chapter_001", libraryDependencies ++= commonDependencies)
  .dependsOn(common)
