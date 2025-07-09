plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    fun plugin(id: String, version: String) = "${id}:${id}.gradle.plugin:${version}"

    val kotlinVersion = "2.2.0"

    implementation(kotlin("gradle-plugin", kotlinVersion))

    val androidVersion = "8.10.0"

    implementation(plugin("com.android.library", androidVersion))
    implementation(plugin("com.android.application", androidVersion))

}
