tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
  enabled = false
}

tasks.getByName<Jar>("jar") {
  enabled = true
}

tasks.register("prepareKotlinBuildScriptModel"){}

dependencies {

  api(kotlin("reflect"))
  api(kotlin("stdlib-jdk8"))
  api("org.springframework.boot:spring-boot-starter")
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  api("org.springframework.boot:spring-boot-starter-jdbc")
  api("org.springframework.boot:spring-boot-starter-web")

  runtimeOnly("mysql:mysql-connector-java")
}