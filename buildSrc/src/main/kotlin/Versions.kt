import kotlin.String
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

object Versions {
    const val org_jetbrains_kotlin: String = "1.3.61"

    const val com_android_tools_build_gradle: String = "3.5.3"

    const val androidx_test_ext_junit: String = "1.1.1"

    const val junit_junit: String = "4.12"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.7.0"

    const val constraintlayout: String = "1.1.3"

    const val espresso_core: String = "3.2.0"

    const val lint_gradle: String = "26.5.3"

    const val appcompat: String = "1.1.0"

    const val core_ktx: String = "1.1.0"

    const val aapt2: String = "3.5.3-5435860"

    const val gradleLatestVersion: String = "6.0.1"
}

val PluginDependenciesSpec.buildSrcVersions: PluginDependencySpec
    inline get() = id("de.fayard.buildSrcVersions").version(Versions.de_fayard_buildsrcversions_gradle_plugin)
