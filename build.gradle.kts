plugins {
    id("java-library")
    `maven-publish`
    `java-gradle-plugin`
}

group = "lol.koblizek"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.9")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "lol.koblizek"
            artifactId = "inter-api"
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}

tasks.test {
    useJUnitPlatform()
}