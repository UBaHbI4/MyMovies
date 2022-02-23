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

        //TheMovieDb https://developers.themoviedb.org/3/getting-started/introduction
        val movieApiKey = properties.getProperty("movies_api_key", "")
        it.buildConfigField("String", "MOVIE_API_KEY", movieApiKey)
        val movieBaseUrl = properties.getProperty("movies_base_url", "")
        it.buildConfigField("String", "MOVIE_BASE_URL", movieBaseUrl)
        val posterPath = properties.getProperty("movies_poster_path", "")
        it.buildConfigField("String", "MOVIE_POSTER_PATH", posterPath)
        val backDropPath = properties.getProperty("movies_back_drop_path", "")
        it.buildConfigField("String", "MOVIE_BACKDROP_PATH", backDropPath)
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

    // ViewBindingPropertyDelegate
    implementation(ViewBindingDelegate.DELEGATE)

    // Koin
    implementation(Koin.ANDROID)
    implementation(Koin.ANDROID_COMPAT)
    implementation(Koin.CORE)
    implementation(Koin.TEST)
    implementation(Koin.TEST_JUNIT4)

    // Glide
    implementation(Glide.COMPILER)
    implementation(Glide.GLIDE)
    implementation(Glide.GLIDE_OKHTTP3)

    // Retrofit
    implementation(Retrofit2.RETROFIT)
    implementation(Retrofit2.CONVERTER_JSON)
    implementation(Retrofit2.COROUTINES_ADAPTER)
    implementation(Retrofit2.LOGGING_INTERCEPTOR)

    // Tests
    testImplementation(Tests.JUNIT)
    androidTestImplementation(Tests.TEST_EXT_JUNIT)
    androidTestImplementation(Tests.ESPRESSO)
}