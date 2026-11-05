plugins {
    java
    id("org.springframework.boot") version "4.1.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.ibm"
version = "0.0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
    maven {
        // Hosts com.ibm.gol:GameOfLifeHdM
        url = uri("https://mymavenrepo.com/repo/wNFFvG0nRh9xnwHJXqEQ/")
    }
}

tasks.bootJar {
    archiveBaseName = "gol-spring-boot"
}

// Only the executable Spring Boot jar is needed (build/libs/gol-spring-boot-0.0.1.jar)
tasks.jar {
    enabled = false
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.webjars:webjars-locator-lite")
    implementation("org.webjars:sockjs-client:1.5.1")
    implementation("org.webjars:stomp-websocket:2.3.4")
    implementation("org.webjars:bootstrap:3.4.1")
    implementation("org.webjars:jquery:3.7.1")

    implementation("com.ibm.gol:GameOfLifeHdM:1.0.0")

    implementation("com.google.code.gson:gson:2.15.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
