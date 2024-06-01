/*
 * Copyright 2023 Atick Faisal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.atick.auth.repository

import android.app.Activity
import dev.atick.auth.models.AuthUser

/**
 * Interface defining authentication-related operations.
 */
interface AuthRepository {
    /**
     * Sign in with an email and password.
     *
     * @param email The user's email address.
     * @param password The user's password.
     * @return A [Result] containing the authenticated [AuthUser] upon successful sign-in.
     */
    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<AuthUser>

    /**
     * Register a new user with an email and password.
     *
     * @param name The user's name.
     * @param email The user's email address.
     * @param password The user's password.
     * @return A [Result] containing the authenticated [AuthUser] upon successful registration.
     */
    suspend fun registerWithEmailAndPassword(
        name: String,
        email: String,
        password: String,
    ): Result<AuthUser>

    /**
     * Sign in with Google.
     *
     * @return A [Result] containing the authenticated [AuthUser] upon successful sign-in.
     */
    suspend fun signInWithGoogle(activity: Activity): Result<AuthUser>

    /**
     * Register a new user with Google.
     *
     * @param activity The activity used to launch the Google sign-in intent.
     * @return A [Result] containing the authenticated [AuthUser] upon successful registration.
     */
    suspend fun registerWithGoogle(activity: Activity): Result<AuthUser>
}
