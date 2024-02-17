rootProject.name = "kess"

include("kess-core")

pluginManagement {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	versionCatalogs {
		create("jetbrains") {
			version("kotlin", "1.9.22")

			plugin("dokka", "org.jetbrains.dokka").version("1.9.10")
			plugin("multiplatform", "org.jetbrains.kotlin.multiplatform").versionRef("kotlin")
		}

		create("kotlinx") {
			library("io", "org.jetbrains.kotlinx", "kotlinx-io-core").version("0.3.1")
			library("coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version("1.8.0")
			library("coroutines.test", "org.jetbrains.kotlinx", "kotlinx-coroutines-test").version("1.8.0")
			library("collections", "org.jetbrains.kotlinx", "kotlinx-collections-immutable").version("0.3.7")
		}

		create("various") {
			plugin("android", "com.android.library").version("7.4.2")
			plugin("detekt", "io.gitlab.arturbosch.detekt").version("1.23.5")
			plugin("github", "com.github.breadmoirai.github-release").version("2.5.2")
		}
	}
}
