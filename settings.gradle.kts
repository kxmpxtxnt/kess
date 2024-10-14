/*
 * Copy right 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

rootProject.name = "kess"

include(
    "kess-board",
    "kess-util"
)

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("jetbrains") {
        version("kotlin", "2.0.21")

        plugin("multiplatform", "org.jetbrains.kotlin.multiplatform").versionRef("kotlin")
        plugin("serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
    }

    versionCatalogs.create("google") {
        version("android", "8.6.0-alpha07")

        plugin("android-library", "com.android.library").versionRef("android")
        plugin("android-application", "com.android.application").versionRef("android")
    }

    versionCatalogs.create("kotlinx") {
        version("kotlinx-coroutines", "1.9.0")
        version("kotlinx-serialization", "1.7.3")

        val kotlinxGroup = "org.jetbrains.kotlinx"

        library(
            "kotlinx-serialization-core",
            kotlinxGroup,
            "kotlinx-serialization-core"
        ).versionRef("kotlinx-serialization")
        library(
            "kotlinx-serialization-cbor",
            kotlinxGroup,
            "kotlinx-serialization-cbor"
        ).versionRef("kotlinx-serialization")
        library(
            "kotlinx-serialization-json",
            kotlinxGroup,
            "kotlinx-serialization-json"
        ).versionRef("kotlinx-serialization")
        library(
            "kotlinx-serialization-json-io",
            kotlinxGroup,
            "kotlinx-serialization-json-io"
        ).versionRef("kotlinx-serialization")

        library(
            "kotlinx-coroutines-core",
            kotlinxGroup,
            "kotlinx-coroutines-core"
        ).versionRef("kotlinx-coroutines")
    }

    versionCatalogs.create("libs") {
        version("logging", "7.0.0")
        library("oshai-logging", "io.github.oshai", "kotlin-logging").versionRef("logging")
        library("oshai-logging-jvm", "io.github.oshai", "kotlin-logging-jvm").versionRef("logging")
    }
}
