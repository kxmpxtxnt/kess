plugins {
	idea
	alias(various.plugins.github).apply(false)
	alias(various.plugins.android).apply(false)
	alias(jetbrains.plugins.dokka).apply(false)
	alias(jetbrains.plugins.multiplatform).apply(false)
}

repositories {
	mavenCentral()
}

allprojects {
	group = "fyi.pauli"
	version = "0.0.1"
	description = "Kess is a chess library for kotlin."
}

idea {
	module {
		excludeDirs.add(file("docs"))
	}
}
