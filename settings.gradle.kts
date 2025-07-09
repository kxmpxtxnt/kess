rootProject.name = "kess"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

include(
    ":kess-core",
    ":kess-engine",
    ":kess-fen"
)
