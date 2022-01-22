import Dependencies._

lazy val root =
  (project in file("."))
    .enablePlugins(BuildInfoPlugin, JavaAppPackaging)
    .settings(
      name := "leetcode-problems",
      organization := "com.ruchij",
      scalaVersion := Dependencies.ScalaVersion,
      version := "0.0.1",
      maintainer := "me@ruchij.com",
      libraryDependencies ++= rootDependencies ++ rootTestDependencies.map(_ % Test),
      buildInfoKeys := Seq[BuildInfoKey](name, organization, version, scalaVersion, sbtVersion),
      buildInfoPackage := "com.eed3si9n.ruchij",
      topLevelDirectory := None,
      scalacOptions ++= Seq("-Xlint", "-feature"),
      addCompilerPlugin(kindProjector)
    )

lazy val rootDependencies =
  Seq()

lazy val rootTestDependencies =
  Seq(scalaTest, pegdown, junitJupiterApi)

addCommandAlias("testWithCoverage", "; coverage; test; coverageReport")
