import org.gradle.api.*

object Constants {

    val Project.isSnapshot: Boolean get() = version.toString().endsWith("-SNAPSHOT")
    val Project.releaseType: String get() = if (isSnapshot) "beta" else "release"

    const val PROJECT_NAME: String = "kess"
    const val PROJECT_DESCRIPTION: String = """
        Kess is an opensource multiplatform chess library for developing chess applications.
        It relies on opensource components, and aims to be a easy-to-use solution for any kind of program.
    """

    const val GITHUB_REPO: String = "kxmpxtxnt/kess"

    val authors: List<String> = listOf(
        "kxmpxtxnt"
    )
}
