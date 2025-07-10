import org.apache.tools.ant.taskdefs.condition.*
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.*

plugins {
    idea
    kotlin("multiplatform")
    id("com.android.library")
}

repositories {
    google()
    mavenCentral()
}

kotlin {
    sourceSets {
        jvm()

        mingwX64()

        linuxX64()
        linuxArm64()

        androidTarget()
        androidNativeX64()
        androidNativeX86()
        androidNativeArm64()

        js {
            nodejs { useMochaForTests() }
            browser { useKarmaForTests() }

            binaries.library()
        }

        @OptIn(ExperimentalWasmDsl::class)
        wasmJs {
            nodejs { useMochaForTests() }
            browser { useKarmaForTests() }
        }

        if (Os.isFamily(Os.FAMILY_MAC)) {
            macosX64()
            macosArm64()

            tvosX64()
            tvosArm64()
            tvosSimulatorArm64()

            watchosX64()
            watchosArm64()
            watchosSimulatorArm64()

            iosX64()
            iosArm64()
            iosSimulatorArm64()
        }


        commonMain.dependencies {
            implementation("io.github.oshai:kotlin-logging:7.0.7")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

            if (project.name != "kess-core")
                implementation(project(":kess-core"))
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        jsTest.dependencies {
            implementation(npm("puppeteer","21.5.0"))
        }

        wasmJsMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-browser:0.2")
        }

        wasmJsTest.dependencies {
            implementation(npm("puppeteer", "21.5.0"))
        }

        applyDefaultHierarchyTemplate()
    }
}

android {
    namespace = "fyi.pauli.kess"

    compileSdk = 35
}

fun KotlinJsNodeDsl.useMochaForTests() {
    testTask {
        useMocha { timeout = "10000" }
    }
}

fun KotlinJsBrowserDsl.useKarmaForTests() {
    testTask {
        useKarma {
            useFirefoxHeadless()
            useConfigDirectory(File(project.rootProject.projectDir, "karma"))
        }
    }
}
