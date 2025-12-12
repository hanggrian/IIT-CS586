val releaseGroup: String by project
val releaseVersion: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaLanguageVersion.of(libs.versions.java.support.get())

allprojects {
    group = releaseGroup
    version = releaseVersion
}

plugins {
    java
    checkstyle
    alias(libs.plugins.shadow)
}

java.toolchain.languageVersion.set(javaCompileVersion)

checkstyle.toolVersion = libs.versions.checkstyle.get()

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(libs.guava)
    implementation(libs.chalk)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks {
    compileJava {
        options.release = javaSupportVersion.asInt()
    }
    test {
        useJUnitPlatform()
    }
    shadowJar {
        archiveFileName.set("${rootProject.name}.jar")
        manifest.attributes("Main-Class" to "$releaseGroup.Main")
    }
}
