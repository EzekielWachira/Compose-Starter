/*
 * Copyright 2023 Atick Faisal
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "dev.atick.build.logic"

val javaVersion = libs.versions.java.get().toInt()

java {
    sourceCompatibility = JavaVersion.values()[javaVersion - 1]
    targetCompatibility = JavaVersion.values()[javaVersion - 1]
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "$javaVersion"
    }
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("library") {
            id = "dev.atick.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("uiLibrary") {
            id = "dev.atick.ui.library"
            implementationClass = "UiLibraryConventionPlugin"
        }
        register("application") {
            id = "dev.atick.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("daggerHilt") {
            id = "dev.atick.dagger.hilt"
            implementationClass = "DaggerHiltConventionPlugin"
        }
        register("firebase") {
            id = "dev.atick.firebase"
            implementationClass = "FirebaseConventionPlugin"
        }
    }
}