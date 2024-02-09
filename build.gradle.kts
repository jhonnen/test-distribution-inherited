plugins {
    id("java")
}

gradleEnterprise {
    server = property("gradleEnterprise.server") as String
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    distribution {
        enabled = true
        maxRemoteExecutors = 0

        remoteOnly {
            includeAnnotationClasses.add("com.project.RemoteOnly")
        }
    }
}
