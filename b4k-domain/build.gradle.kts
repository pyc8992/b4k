
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
  implementation("org.springframework.boot:spring-boot-starter-data-redis")

  // query dsl configure
  implementation("com.querydsl:querydsl-jpa:5.0.0")
  implementation("org.mariadb.jdbc:mariadb-java-client:3.1.2")
//  implementation("junit:junit:4.13.2")
  kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
  // query dsl configure end

  runtimeOnly("mysql:mysql-connector-java")

  testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
  testImplementation("io.kotest:kotest-assertions-core:5.5.5")
  testImplementation("io.kotest:kotest-extensions-spring:4.4.3")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class){
  kotlin.srcDir("$buildDir/generated/source/kapt/main")
}


allOpen {
  annotation("javax.persistence.Entity")
  annotation("javax.persistence.MappedSuperclass")
  annotation("javax.persistence.Embeddable")
}
