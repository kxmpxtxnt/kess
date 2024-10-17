/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package target

import internal.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.targets.js.dsl.*
import java.io.*

fun Project.configureJs() {
    kotlin {
        js {
            nodejs { useMochaForTests() }
            browser { useKarmaForTests() }

            binaries.library()
        }

        sourceSets {
            jsTest {
                dependencies {
                    implementation(npm("puppeteer", libs.versions.puppeteer.get()))
                }
            }
        }
    }
}

internal fun KotlinJsSubTargetDsl.useMochaForTests() {
    testTask {
        useMocha {
            timeout = "10000"
        }
    }
}

internal fun KotlinJsSubTargetDsl.useKarmaForTests() {
    testTask {
        useKarma {
            useChromeHeadless()
            useConfigDirectory(File(project.rootProject.projectDir, "karma"))
        }
    }
}
