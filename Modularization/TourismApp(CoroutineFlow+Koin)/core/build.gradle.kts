plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.example.tourismapp_coroutineflow_koin.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

apply("../shared_dependencies.gradle")
dependencies {
    implementation (fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:${rootProject.ext["kotlinCoroutinesVersion"]}")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.ext["kotlinCoroutinesVersion"]}")
    api ("androidx.lifecycle:lifecycle-livedata-ktx:${rootProject.ext["lifecycleVersion"]}")
    implementation ("androidx.room:room-ktx:${rootProject.ext["roomVersion"]}")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:${rootProject.ext["retrofitVersion"]}")
    implementation ("com.squareup.retrofit2:converter-gson:${rootProject.ext["retrofitVersion"]}")
    implementation ("com.squareup.okhttp3:logging-interceptor:${rootProject.ext["loggingInterceptorVersion"]}")

    // Room
    kapt ("androidx.room:room-compiler:${rootProject.ext["roomVersion"]}")
    implementation ("androidx.room:room-runtime:${rootProject.ext["roomVersion"]}")
    androidTestImplementation ("androidx.room:room-testing:${rootProject.ext["roomVersion"]}")
}