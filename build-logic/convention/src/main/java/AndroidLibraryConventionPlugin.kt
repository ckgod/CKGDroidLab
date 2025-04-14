import app.ckg.androidlab.convention.configureFlavors
import app.ckg.androidlab.convention.configureKotlinAndroid
import app.ckg.androidlab.convention.libs
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies


class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")
            apply(plugin = "org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 35
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                configureFlavors(this)
                resourcePrefix =
                    path.split("""\W""".toRegex()).drop(1).distinct().joinToString(separator = "_")
                        .lowercase() + "_"
            }

            dependencies {
                "implementation"(libs.findLibrary("androidx.tracing.ktx").get())

                // TODO 추후 테스트 코드 작성 시 추가
//                "androidTestImplementation"(libs.findLibrary("kotlin.test").get())
//                "testImplementation"(libs.findLibrary("kotlin.test").get())
            }
        }
    }
}