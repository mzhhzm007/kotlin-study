import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.springframework.boot") version "2.2.0.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false

    kotlin("jvm") version "1.4.10" apply false
    kotlin("plugin.spring") version "1.4.10" apply false
    kotlin("plugin.jpa") version "1.4.10" apply false
    kotlin("plugin.allopen") version "1.3.61" apply false
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
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("io.spring.dependency-management")
    }
}
