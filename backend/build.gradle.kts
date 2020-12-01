plugins {
	kotlin("jvm")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":basic-study"))

	implementation(kotlin("reflect"))
	implementation(kotlin("stdlib-jdk8"))
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-gateway")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Use the Kotlin test library.
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// Use the Kotlin JUnit integration.
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}


