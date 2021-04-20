plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "xyz.teamgravity.rocketanimation"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    // compose
    implementation("androidx.compose.ui:ui:1.0.0-beta04")

    // tooling support (previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta04")

    // foundation (border, background, box, image, scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.0.0-beta04")

    // material design
    implementation("androidx.compose.material:material:1.0.0-beta04")

    // material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.0-beta04")
    implementation("androidx.compose.material:material-icons-extended:1.0.0-beta04")

    // integration with activities
    implementation("androidx.activity:activity-compose:1.3.0-alpha06")

    // integration with viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04")

    // integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta04")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.0.0-beta04")

    // animation
    implementation("androidx.compose.animation:animation:1.0.0-beta04")
}