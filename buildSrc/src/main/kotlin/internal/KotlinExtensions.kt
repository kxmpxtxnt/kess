/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package internal

import org.gradle.api.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*

val Project.kotlin: KotlinMultiplatformExtension get() = the()

fun Project.kotlin(block: KotlinMultiplatformExtension.() -> Unit) {
    configure(block)
}
