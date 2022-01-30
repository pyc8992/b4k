object DependencyVersions {
  const val SWAGGER_VERSION = "2.9.2"
}

tasks.register("prepareKotlinBuildScriptModel"){}

dependencies {

  implementation(project(":b4k-domain"))

  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

springBoot.buildInfo { properties { } }