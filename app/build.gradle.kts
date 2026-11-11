plugins {
    id("com.android.application")
}

android {
    namespace = "com.elorhytm16"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.elorhytm16"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    // One fixed key, so new builds install over old ones and keep your saved banks.
    signingConfigs {
        create("fixed") {
            storeFile = file("elorhytm16.keystore")
            storePassword = "elorhytm16"
            keyAlias = "elorhytm16"
            keyPassword = "elorhytm16"
        }
    }
    buildTypes {
        getByName("debug") { signingConfig = signingConfigs.getByName("fixed") }
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("fixed")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
