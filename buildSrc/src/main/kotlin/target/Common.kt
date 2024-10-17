/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package target

import internal.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*

fun Project.configureCommon() {
    kotlin {
        sourceSets {
            commonMain {
                dependencies {
                    api(libs.oshai.logging)
                    api(libs.kotlinx.coroutines.core)
                    api(libs.kotlinx.serialization.core)
                    api(libs.kotlinx.serialization.cbor)
                    api(libs.kotlinx.serialization.json)
                    api(libs.kotlinx.serialization.json.io)
                    if (this@configureCommon.name != "kess-util") api(project(":kess-util"))
                }
            }

            commonTest {
                dependencies {
                    api(libs.kotlin.test)
                }
            }
        }
    }
}
