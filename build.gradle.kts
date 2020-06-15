plugins {
    java
    kotlin("jvm") version "1.3.72"
    application
}

group = "com.github.educar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

application {
    mainClassName = "com.github.educar.MainKt"
    applicationName = "educar"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}