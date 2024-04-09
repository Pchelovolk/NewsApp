plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-android-extensions")

}

android {
    namespace = "com.study.newsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.study.newsapp"
        minSdk = 26
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding{
        enable = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Lifecycle
    val lifecycleVersion = "2.4.1"
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // Room
    val roomVersion = "2.4.2"
    implementation ("androidx.room:room-runtime:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")

    // Coroutines
    val coroutinesVersion = "1.5.2"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Hilt
    val hiltVersion = "2.41"
    implementation ("com.google.dagger:hilt-android:$hiltVersion")
    kapt ("com.google.dagger:hilt-compiler:$hiltVersion")

    // Retrofit
    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // OkHTTP
    val okhttpVersion = "4.9.0"
    implementation ("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    // Navigation Components
    val navVersion = "2.4.2"
    implementation ("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Glide
    val glideVersion = "4.13.0"
    implementation ("com.github.bumptech.glide:glide:$glideVersion")
    kapt ("com.github.bumptech.glide:compiler:$glideVersion")
}