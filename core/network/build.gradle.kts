plugins {
    alias(libs.plugins.ckgdroidlab.android.library)
    alias(libs.plugins.ckgdroidlab.hilt)
}

android {
    namespace = "app.ckg.androidlab.core.network"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(projects.core.common)
    api(projects.core.model)
}