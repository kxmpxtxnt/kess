/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */
@file:OptIn(ExperimentalWasmDsl::class)

import org.gradle.api.tasks.testing.logging.*
import org.jetbrains.kotlin.gradle.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(google.plugins.android.library)
    alias(jetbrains.plugins.multiplatform)
    alias(jetbrains.plugins.serialization)
}

description = "Utilities of the kess library."

kotlin {
    targets.configureEach {
        compilations.configureEach {
            compileTaskProvider.configure {
                compilerOptions {
                    freeCompilerArgs.add("-Xexpect-actual-classes")

                    apiVersion = KotlinVersion.KOTLIN_2_0
                    languageVersion = KotlinVersion.KOTLIN_2_0
                }
            }
        }
    }

    explicitApi()

    jvm()

    androidTarget {
        publishLibraryVariants("release", "debug")
    }

    js {
        browser {
            testTask {
                useKarma {
                    useFirefoxHeadless()
                }
            }
        }
        nodejs()
    }

    wasmJs {
        browser {
            testTask {
                useKarma {
                    useFirefoxHeadless()
                }
            }
        }
    }

    val darwinTargets = listOf(
        macosX64(),
        macosArm64(),
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        watchosX64(),
        watchosArm64(),
        watchosSimulatorArm64(),
        tvosX64(),
        tvosArm64(),
        tvosSimulatorArm64()
    )

    val nativeTargets = listOf(
        mingwX64(),
        linuxX64(),
        linuxArm64(),
        androidNativeX64(),
        androidNativeX86(),
        androidNativeArm32(),
        androidNativeArm64(),
    )

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlinx.kotlinx.serialization.cbor)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val javaMain by creating {
            dependsOn(commonMain)
        }

        val jvmMain by getting {
            dependsOn(javaMain)
            dependencies {
                implementation(libs.oshai.logging.jvm)
            }
        }

        val androidMain by getting {
            dependsOn(javaMain)
        }

        val androidUnitTest by getting {
            dependsOn(commonTest)
        }

        val jsMain by getting {
            dependsOn(commonMain)
        }
        val jsTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        val wasmJsMain by getting {
            dependsOn(commonMain)
        }
        val wasmJsTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(kotlin("test-wasm-js"))
            }
        }

        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val darwinMain by creating {
            dependsOn(commonMain)
        }

        nativeTargets.forEach {
            getByName("${it.targetName}Main") {
                dependsOn(nativeMain)
            }
        }
        darwinTargets.forEach {
            getByName("${it.targetName}Main") {
                dependsOn(darwinMain)
            }
        }
    }
}

android {
    compileSdk = 34
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
    }
    testOptions.unitTests.isReturnDefaultValues = true
    namespace = "fyi.pauli"
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
            showExceptions = true
            exceptionFormat = TestExceptionFormat.FULL
        }
    }

    withType<KotlinCompile> {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }

    withType<Jar> {
        metaInf.with(
            copySpec { from("${project.rootDir}/LICENSE") }
        )
    }
}
