/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package target

import internal.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.*

fun Project.configureWasm() {
    kotlin {
        @OptIn(ExperimentalWasmDsl::class)
        wasmJs {
            nodejs { useMochaForTests() }
            browser { useKarmaForTests() }
        }

        sourceSets {
            wasmJsMain {
                dependencies {
                    implementation(libs.kotlinx.browser)
                }
            }
            wasmJsTest {
                dependencies {
                    implementation(npm("puppeteer", libs.versions.puppeteer.get()))
                }
            }
        }
    }
}
