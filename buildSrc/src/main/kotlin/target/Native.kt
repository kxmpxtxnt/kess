/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package target

import internal.*
import org.gradle.api.*

fun Project.posixTargets(): List<String> = nixTargets() + windowsTargets()

fun Project.nixTargets(): List<String> = darwinTargets() + linuxTargets() + androidNativeTargets()

fun Project.androidNativeTargets(): List<String> = with(kotlin) {
    listOf(
        androidNativeArm32(),
        androidNativeArm64(),
        androidNativeX86(),
        androidNativeX64(),
    )
}.map { it.name }

fun Project.linuxTargets(): List<String> = with(kotlin) {
    listOf(
        linuxX64(),
        linuxArm64(),
    )
}.map { it.name }

fun Project.darwinTargets(): List<String> = macosTargets() + iosTargets() + watchosTargets() + tvosTargets()

fun Project.macosTargets(): List<String> = with(kotlin) {
    listOf(
        macosX64(),
        macosArm64()
    ).map { it.name }
}

fun Project.iosTargets(): List<String> = with(kotlin) {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).map { it.name }
}

fun Project.watchosTargets(): List<String> = with(kotlin) {
    listOfNotNull(
        watchosX64(),
        watchosArm64(),
        watchosSimulatorArm64(),
    ).map { it.name }
}

fun Project.tvosTargets(): List<String> = with(kotlin) {
    listOf(
        tvosX64(),
        tvosArm64(),
        tvosSimulatorArm64(),
    ).map { it.name }
}

fun Project.desktopTargets(): List<String> = with(kotlin) {
    listOf(
        macosX64(),
        macosArm64(),
        linuxX64(),
        linuxArm64(),
        mingwX64()
    ).map { it.name }
}

fun Project.windowsTargets(): List<String> = with(kotlin) {
    listOf(
        mingwX64()
    ).map { it.name }
}
