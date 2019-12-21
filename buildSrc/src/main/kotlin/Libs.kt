import kotlin.String

object Libs {
    const val kotlinAndroidExtensions = "org.jetbrains.kotlin:kotlin-android-extensions:" + Versions.org_jetbrains_kotlin

    const val kotlin_android_extensions_runtime: String =
        "org.jetbrains.kotlin:kotlin-android-extensions-runtime:" +
            Versions.org_jetbrains_kotlin

    const val kotlin_gradle_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" +
        Versions.org_jetbrains_kotlin

    const val kotlin_stdlib_jdk7: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:" +
        Versions.org_jetbrains_kotlin

    const val com_android_tools_build_gradle: String = "com.android.tools.build:gradle:" +
        Versions.com_android_tools_build_gradle

    const val androidx_test_ext_junit: String = "androidx.test.ext:junit:" +
        Versions.androidx_test_ext_junit

    const val junit_junit: String = "junit:junit:" + Versions.junit_junit

    const val de_fayard_buildsrcversions_gradle_plugin: String =
        "de.fayard.buildSrcVersions:de.fayard.buildSrcVersions.gradle.plugin:" +
            Versions.de_fayard_buildsrcversions_gradle_plugin

    const val constraintlayout: String = "androidx.constraintlayout:constraintlayout:" +
        Versions.constraintlayout

    const val espresso_core: String = "androidx.test.espresso:espresso-core:" +
        Versions.espresso_core

    const val lint_gradle: String = "com.android.tools.lint:lint-gradle:" + Versions.lint_gradle

    const val appcompat: String = "androidx.appcompat:appcompat:" + Versions.appcompat

    const val core_ktx: String = "androidx.core:core-ktx:" + Versions.core_ktx

    const val aapt2: String = "com.android.tools.build:aapt2:" + Versions.aapt2
}
