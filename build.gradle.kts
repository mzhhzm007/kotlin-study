import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

extra["springCloudVersion"] = "2020.0.0-M5"


plugins {
    id("org.springframework.boot") version "2.2.0.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE"

    kotlin("jvm") version "1.4.10" apply false
    kotlin("plugin.spring") version "1.4.10" apply false
    kotlin("plugin.jpa") version "1.4.10" apply false
    kotlin("plugin.allopen") version "1.3.61" apply false

    `java-platform`
    `maven-publish`
}

javaPlatform {
    allowDependencies()
}

allprojects {
    group = "com.mzh.study"
    version = "0.0.1-SNAPSHOT"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://repo.spring.io/snapshot")
        maven("https://repo.spring.io/milestone")
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")

    println("Enabling Kotlin Spring plugin in project ${project.name}...")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    println("Enabling Spring Boot Dependency Management in project ${project.name}...")
    apply(plugin = "io.spring.dependency-management")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

}



