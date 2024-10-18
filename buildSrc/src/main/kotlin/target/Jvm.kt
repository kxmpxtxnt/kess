/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package target

import internal.*
import org.gradle.api.*

fun Project.jvmTarget() {
    kotlin {
        jvm()
    }
}
