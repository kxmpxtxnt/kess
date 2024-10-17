/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    `kotlin-dsl`
    alias(libs.plugins.serialization) version embeddedKotlinVersion apply false
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    val kotlin_version = libs.versions.kotlin.get()
    implementation(kotlin("gradle-plugin", kotlin_version))
    implementation(kotlin("serialization", kotlin_version))

    // A hack to make version catalogs accessible from buildSrc sources
    // https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

}

kotlin {
    jvmToolchain(8)
}
