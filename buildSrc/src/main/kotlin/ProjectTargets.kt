/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import internal.*
import target.*
import org.gradle.api.*
import org.jetbrains.kotlin.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

fun Project.configureTargets() {
    kotlin {
        configureCommon()

        jvmTarget()

        configureJs()
        configureWasm()

        posixTargets()
        nixTargets()
        darwinTargets()
        linuxTargets()
        androidNativeTargets()
        desktopTargets()
        windowsTargets()

        applyHierarchyTemplate(hierarchyTemplate)
    }
}

private val hierarchyTemplate = KotlinHierarchyTemplate {
    withSourceSetTree(KotlinSourceSetTree.main, KotlinSourceSetTree.test)

    common {
        group("posix") {
            group("windows") { withMingw() }

            group("nix") {
                group("linux") { withLinux() }

                group("darwin") {
                    group("ios") { withIos() }
                    group("tvos") { withTvos() }
                    group("watchos") { withWatchos() }
                    group("macos") { withMacos() }
                }

                group("androidNative") {
                    group("androidNative64") {
                        withAndroidNativeX64()
                        withAndroidNativeArm64()
                    }

                    group("androidNative32") {
                        withAndroidNativeX86()
                        withAndroidNativeArm32()
                    }
                }
            }
        }

        group("jsAndWasmShared") {
            withJs()
            withWasmJs()
        }

        group("jvmAndPosix") {
            withJvm()
            group("posix")
        }

        group("jvmAndNix") {
            withJvm()
            group("nix")
        }

        group("desktop") {
            group("linux")
            group("windows")
            group("macos")
        }
    }
}
