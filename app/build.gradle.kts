import java.io.FileInputStream
import java.text.SimpleDateFormat
import java.util.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val sdf = SimpleDateFormat("yyyy.M.dd")
val currentDate: String = sdf.format(Date())

android {
    compileSdk = Config.COMPILE_SDK

    signingConfigs {
        create("releaseSign")
                {
                    val properties = Properties()
                    properties.load(FileInputStream(file("./../conf.properties")))
                    storeFile = file("./../key.jks")
                    storePassword = properties.getProperty("storePassword", "")
                    keyAlias = properties.getProperty("keyAlias", "")
                    keyPassword = properties.getProperty("keyPassword", "")
                }
    }

    defaultConfig {
        applicationId = Config.APPLICATION_ID
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = currentDate

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("releaseSign")
        }
    }

    compileOptions {
        sourceCompatibility = Config.java_version
        targetCompatibility = Config.java_version
    }

    kotlinOptions {
        jvmTarget = Config.JVM_TARGET
    }

    buildFeatures {
        android.buildFeatures.viewBinding = true
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    buildTypes.forEach {
        val properties = Properties()
        properties.load(FileInputStream(file("./../conf.properties")))
    }
}

dependencies {

    implementation(Kotlin.CORE)

    // Design
    implementation(Design.APPCOMPAT)
    implementation(Design.MATERIAL)
    implementation(Design.CONSTRAINT_LAYOUT)
    implementation(Design.NAVIGATION_FRAGMENT)
    implementation(Design.NAVIGATION_UI_KTX)

    // LifeCycle
    implementation(LifeCycle.LIVEDATA_KTX)
    implementation(LifeCycle.VIEW_MODEL_KTX)

    // Tests
    testImplementation(Tests.JUNIT)
    androidTestImplementation(Tests.TEST_EXT_JUNIT)
    androidTestImplementation(Tests.ESPRESSO)
}