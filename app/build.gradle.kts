import org.jetbrains.kotlin.gradle.targets.js.KotlinJsCompilerAttribute

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    id ("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.muneshsaini.notesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.muneshsaini.notesapp"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    val fragments_version = "1.2.5"
    val lifecycle_version = "2.2.0"
    val room_version = "2.6.1"
    val coroutines = "1.8.1"
    val kotlin_version = "2.0.0"
    val navigation_version = "2.7.7"
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$navigation_version")


    // Room components
    implementation ("androidx.room:room-ktx:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")
    androidTestImplementation ("androidx.room:room-testing:$room_version")

    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

    // fragments
    implementation ("androidx.fragment:fragment-ktx:$fragments_version")

    // Kotlin components
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-auth")

    // Also add the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:21.2.0")
    implementation("com.google.firebase:firebase-analytics")
}