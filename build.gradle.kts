/*
 * Copy right 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

description = "Kess is an multiplatform library for building chess applications."

allprojects {
    this.group = "fyi.pauli"
    this.version = "0.0.1"

    this.repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

subprojects {
    apply(plugin = "kotlin-multiplatform")
    apply(plugin = "kotlinx-serialization")
    configureTargets()
}
