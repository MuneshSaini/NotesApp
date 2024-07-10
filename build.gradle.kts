// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false

}
buildscript {
    val kotlin_version = "2.0.0"
    val navigation_version = "2.7.7"

    dependencies {
        classpath ("com.android.tools.build:gradle:4.1.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$navigation_version")
    }
}