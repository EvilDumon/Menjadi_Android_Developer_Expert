plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.example.tourismapp_coroutineflow"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.tourismapp_coroutineflow"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
dependencies {
    // New Added
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.ext["kotlinCoroutinesVersion"]}")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$${rootProject.ext["kotlinCoroutinesVersion"]}")
    implementation ("androidx.room:room-ktx:${rootProject.ext["roomVersion"]}")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:${rootProject.ext["lifecycleVersion"]}")

    implementation ("com.squareup.retrofit2:retrofit:${rootProject.ext["retrofitVersion"]}")
    implementation ("com.squareup.retrofit2:converter-gson:${rootProject.ext["retrofitVersion"]}")
    implementation ("com.squareup.okhttp3:logging-interceptor:${rootProject.ext["loggingInterceptorVersion"]}")

    implementation ("androidx.legacy:legacy-support-v4:${rootProject.ext["legacySupportVersion"]}")
    implementation ("androidx.multidex:multidex:${rootProject.ext["multidexVersion"]}")

    implementation ("androidx.cardview:cardview:${rootProject.ext["cardviewVersion"]}")
    implementation ("androidx.recyclerview:recyclerview:${rootProject.ext["recyclerviewVersion"]}")
    implementation ("com.github.bumptech.glide:glide:${rootProject.ext["glideVersion"]}")

    implementation ("androidx.room:room-runtime:${rootProject.ext["roomVersion"]}")
    kapt ("androidx.room:room-compiler:${rootProject.ext["roomVersion"]}")
    androidTestImplementation ("androidx.room:room-testing:${rootProject.ext["roomVersion"]}")

    implementation("androidx.core:core-ktx:${rootProject.ext["coreKtxVersion"]}")
    implementation("androidx.appcompat:appcompat:${rootProject.ext["appCompatVersion"]}")
    implementation("com.google.android.material:material:${rootProject.ext["materialVersion"]}")
    implementation("androidx.constraintlayout:constraintlayout:${rootProject.ext["constraintVersion"]}")
    testImplementation("junit:junit:${rootProject.ext["jUnitVersion"]}")
    androidTestImplementation("androidx.test.ext:junit:${rootProject.ext["androidxJunitVersion"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.ext["espressoVersion"]}")
}