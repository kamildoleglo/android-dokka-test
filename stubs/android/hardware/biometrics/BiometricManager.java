/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.hardware.biometrics;


/**
 * A class that contains biometric utilities. For authentication, see {@link android.hardware.biometrics.BiometricPrompt BiometricPrompt}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BiometricManager {

BiometricManager() { throw new RuntimeException("Stub!"); }

/**
 * Determine if biometrics can be used. In other words, determine if {@link android.hardware.biometrics.BiometricPrompt BiometricPrompt}
 * can be expected to be shown (hardware available, templates enrolled, user-enabled).
 *
 * <br>
 * Requires {@link android.Manifest.permission#USE_BIOMETRIC}
 * @return Returns {@link #BIOMETRIC_ERROR_NONE_ENROLLED} if the user does not have any
 *     enrolled, or {@link #BIOMETRIC_ERROR_HW_UNAVAILABLE} if none are currently
 *     supported/enabled. Returns {@link #BIOMETRIC_SUCCESS} if a biometric can currently be
 *     used (enrolled and available).
 
 * Value is {@link android.hardware.biometrics.BiometricManager#BIOMETRIC_SUCCESS}, {@link android.hardware.biometrics.BiometricManager#BIOMETRIC_ERROR_HW_UNAVAILABLE}, {@link android.hardware.biometrics.BiometricManager#BIOMETRIC_ERROR_NONE_ENROLLED}, or {@link android.hardware.biometrics.BiometricManager#BIOMETRIC_ERROR_NO_HARDWARE}
 * @apiSince 29
 */

public int canAuthenticate() { throw new RuntimeException("Stub!"); }

/**
 * The hardware is unavailable. Try again later.
 * @apiSince 29
 */

public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = 1; // 0x1

/**
 * The user does not have any biometrics enrolled.
 * @apiSince 29
 */

public static final int BIOMETRIC_ERROR_NONE_ENROLLED = 11; // 0xb

/**
 * There is no biometric hardware.
 * @apiSince 29
 */

public static final int BIOMETRIC_ERROR_NO_HARDWARE = 12; // 0xc

/**
 * No error detected.
 * @apiSince 29
 */

public static final int BIOMETRIC_SUCCESS = 0; // 0x0
}

