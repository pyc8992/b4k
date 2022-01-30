tasks.register("prepareKotlinBuildScriptModel"){}

dependencies {

  implementation(project(":b4k2-domain"))

  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

springBoot.buildInfo { properties { } }