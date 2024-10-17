/*
 * Copy right 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

rootProject.name = "kess"

include(
    "kess-board",
    "kess-util",
    "kess-fen"
)

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
