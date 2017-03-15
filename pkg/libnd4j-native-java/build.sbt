name := "libnd4j-native-java"

organization := "org.nd4j"

version := "0.8.0"

scalaVersion := "2.11.8"

maintainer := "Eduardo Gonzalez <eduardo@skymind.io>"

packageSummary := "AVX Java-bindings for libnd4j."

packageDescription := "CPU bindings for ND4J"

libraryDependencies += "org.nd4j" % "nd4j-native-platform" % "0.8.0"

enablePlugins(JavaAppPackaging)
//enablePlugins(RpmPlugin)
enablePlugins(JDebPackaging)

import DebianConstants._
maintainerScripts in Debian := maintainerScriptsAppend((maintainerScripts in Debian).value)(
  Preinst -> "echo 'Installing nd4j from Skymind'",
  Postinst -> s"echo 'installed ${(packageName in Debian).value}'"
)


daemonUser in Linux := "root"

defaultLinuxInstallLocation := "/opt/"

debianPackageDependencies in Debian ++= Seq("java2-runtime-headless")

