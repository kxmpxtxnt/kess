/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package internal

import org.gradle.accessors.dm.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*

internal val Project.libs: LibrariesForLibs
    get() = rootProject.the<LibrariesForLibs>()
