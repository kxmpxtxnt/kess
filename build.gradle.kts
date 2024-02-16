import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.targets.jvm.tasks.KotlinJvmTest

plugins {
	idea
	alias(various.plugins.android)
	alias(jetbrains.plugins.dokka)
	alias(various.plugins.spotless)
	alias(jetbrains.plugins.multiplatform)
}

repositories {
	mavenCentral()
}

allprojects {
	group = "fyi.pauli"
	version = "0.0.1"
	description = "Kess is a chess library for kotlin."
}

val kotlinLanguageVersion = KotlinVersion.KOTLIN_1_9
val jvmTargetVersion = JavaVersion.VERSION_1_8

kotlin {
	androidTarget()
	explicitApi()

	@OptIn(ExperimentalKotlinGradlePluginApi::class)
	compilerOptions {
		apiVersion = kotlinLanguageVersion
		languageVersion = kotlinLanguageVersion

		freeCompilerArgs.add("-Xexpect-actual-classes")
	}

	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = jvmTargetVersion.toString()
		}
	}

	androidTarget {
		publishLibraryVariants("release", "debug")
	}

	val linuxTargets =
		listOf(
			linuxX64(),
			linuxArm64(),
		)

	val darwinTargets =
		listOf(
			iosX64(),
			tvosX64(),
			macosX64(),
			iosArm64(),
			tvosArm64(),
			macosArm64(),
			watchosX64(),
			watchosArm64(),
			iosSimulatorArm64(),
			tvosSimulatorArm64(),
			watchosSimulatorArm64(),
		)

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(kotlinx.io)
				implementation(kotlinx.coroutines)
				implementation(kotlinx.collections)
			}
		}

		val commonTest by getting {
			dependencies {
				implementation(kotlinx.coroutines.test)
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		val nativeMain by creating {
			dependsOn(commonMain)
		}

		val nativeTest by creating {
			dependsOn(commonTest)
			dependencies {
				implementation(kotlin("test"))
			}
		}

		val androidMain by getting {
			dependsOn(commonMain)
		}

		val androidUnitTest by getting {
			dependsOn(commonTest)
			dependencies {
				implementation(kotlin("test"))
			}
		}

		val javaMain by creating {
			dependsOn(nativeMain)
		}

		val jvmMain by getting {
			dependsOn(nativeMain)
		}

		val jvmTest by getting {
			dependsOn(nativeTest)
			dependencies {
				implementation(kotlin("test"))
			}
		}

		val directMain by creating {
			dependsOn(nativeMain)
		}

		val linuxMain by creating {
			dependsOn(nativeMain)
		}

		val darwinMain by creating {
			dependsOn(nativeMain)
		}

		linuxTargets.forEach {
			getByName("${it.targetName}Main") {
				dependsOn(linuxMain)
			}
		}

		darwinTargets.forEach {
			getByName("${it.targetName}Main") {
				dependsOn(darwinMain)
			}
		}
	}
}

android {
	compileSdk = 31
	sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
	defaultConfig {
		minSdk = 21
	}
	testOptions {
		unitTests.isReturnDefaultValues = true
	}
	namespace = "fyi.pauli"
}

spotless {
	ratchetFrom = "origin/main"

	kotlin {
		ktfmt()
		ktlint()
		diktat()
		prettier()
		trimTrailingWhitespace()
		indentWithTabs(1)
		endWithNewline()
	}

	kotlinGradle {
		target("*.gradle.kts")
		ktlint()
	}
}

idea {
	module {
		excludeDirs.add(file("docs"))
	}
}

tasks {
	withType<KotlinJvmTest> {
		useJUnitPlatform()
	}

	withType<DokkaMultiModuleTask> {
		includes.from("dokka/includes/main.md")
	}
}
