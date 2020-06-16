plugins {
    java
    kotlin("jvm") version "1.3.72"
    application
}

group = "com.github.educar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-netty:1.3.2")
    implementation("io.ktor:ktor-gson:1.3.2")
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