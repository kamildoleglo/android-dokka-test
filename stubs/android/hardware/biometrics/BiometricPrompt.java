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

import android.content.Context;
import android.content.DialogInterface;
import java.util.concurrent.Executor;
import android.os.CancellationSignal;
import android.app.KeyguardManager;
import javax.crypto.Mac;
import java.security.Signature;
import javax.crypto.Cipher;

/**
 * A class that manages a system-provided biometric dialog.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BiometricPrompt {

private BiometricPrompt() { throw new RuntimeException("Stub!"); }

/**
 * This call warms up the biometric hardware, displays a system-provided dialog, and starts
 * scanning for a biometric. It terminates when {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback#onAuthenticationError(int,java.lang.CharSequence) AuthenticationCallback#onAuthenticationError(int, CharSequence)} is called, when {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback#onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult) AuthenticationCallback#onAuthenticationSucceeded( AuthenticationResult)}, or when the user
 * dismisses the system-provided dialog, at which point the crypto object becomes invalid. This
 * operation can be canceled by using the provided cancel object. The application will receive
 * authentication errors through {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback AuthenticationCallback}, and button events through the
 * corresponding callback set in {@link android.hardware.biometrics.BiometricPrompt.Builder#setNegativeButton(java.lang.CharSequence,java.util.concurrent.Executor,android.content.DialogInterface.OnClickListener) Builder#setNegativeButton(CharSequence, Executor,
 * DialogInterface.OnClickListener)}. It is safe to reuse the {@link android.hardware.biometrics.BiometricPrompt BiometricPrompt} object,
 * and calling {@link android.hardware.biometrics.BiometricPrompt#authenticate(android.os.CancellationSignal,java.util.concurrent.Executor,android.hardware.biometrics.BiometricPrompt.AuthenticationCallback) BiometricPrompt#authenticate( CancellationSignal, Executor,
 * AuthenticationCallback)} while an existing authentication attempt is occurring will stop the
 * previous client and start a new authentication. The interrupted client will receive a
 * cancelled notification through {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback#onAuthenticationError(int,java.lang.CharSequence) AuthenticationCallback#onAuthenticationError(int,
 * CharSequence)}.
 *
 * Note: Applications generally should not cancel and start authentication in quick succession.
 * For example, to properly handle authentication across configuration changes, it's recommended
 * to use BiometricPrompt in a fragment with setRetainInstance(true). By doing so, the
 * application will not need to cancel/restart authentication during the configuration change.
 *
 * <br>
 * Requires {@link android.Manifest.permission#USE_BIOMETRIC}
 * @throws java.lang.IllegalArgumentException If any of the arguments are null
 *
 * @param crypto Object associated with the call
 * This value must never be {@code null}.
 * @param cancel An object that can be used to cancel authentication
 * This value must never be {@code null}.
 * @param executor An executor to handle callback events
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback An object to receive authentication events
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void authenticate(@androidx.annotation.NonNull android.hardware.biometrics.BiometricPrompt.CryptoObject crypto, @androidx.annotation.NonNull android.os.CancellationSignal cancel, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.hardware.biometrics.BiometricPrompt.AuthenticationCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * This call warms up the biometric hardware, displays a system-provided dialog, and starts
 * scanning for a biometric. It terminates when {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback#onAuthenticationError(int,java.lang.CharSequence) AuthenticationCallback#onAuthenticationError(int, CharSequence)} is called, when {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback#onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult) AuthenticationCallback#onAuthenticationSucceeded( AuthenticationResult)} is called, or when
 * the user dismisses the system-provided dialog.  This operation can be canceled by using the
 * provided cancel object. The application will receive authentication errors through {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback AuthenticationCallback}, and button events through the corresponding callback set in {@link android.hardware.biometrics.BiometricPrompt.Builder#setNegativeButton(java.lang.CharSequence,java.util.concurrent.Executor,android.content.DialogInterface.OnClickListener) Builder#setNegativeButton(CharSequence, Executor, DialogInterface.OnClickListener)}.  It is
 * safe to reuse the {@link android.hardware.biometrics.BiometricPrompt BiometricPrompt} object, and calling {@link android.hardware.biometrics.BiometricPrompt#authenticate(android.os.CancellationSignal,java.util.concurrent.Executor,android.hardware.biometrics.BiometricPrompt.AuthenticationCallback) BiometricPrompt#authenticate(CancellationSignal, Executor, AuthenticationCallback)} while
 * an existing authentication attempt is occurring will stop the previous client and start a new
 * authentication. The interrupted client will receive a cancelled notification through {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback#onAuthenticationError(int,java.lang.CharSequence) AuthenticationCallback#onAuthenticationError(int, CharSequence)}.
 *
 * Note: Applications generally should not cancel and start authentication in quick succession.
 * For example, to properly handle authentication across configuration changes, it's recommended
 * to use BiometricPrompt in a fragment with setRetainInstance(true). By doing so, the
 * application will not need to cancel/restart authentication during the configuration change.
 *
 * <br>
 * Requires {@link android.Manifest.permission#USE_BIOMETRIC}
 * @throws java.lang.IllegalArgumentException If any of the arguments are null
 *
 * @param cancel An object that can be used to cancel authentication
 * This value must never be {@code null}.
 * @param executor An executor to handle callback events
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback An object to receive authentication events
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void authenticate(@androidx.annotation.NonNull android.os.CancellationSignal cancel, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.hardware.biometrics.BiometricPrompt.AuthenticationCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * The image acquired was good.
 */

public static final int BIOMETRIC_ACQUIRED_GOOD = 0; // 0x0

/**
 * The biometric image was too noisy due to suspected or detected dirt on the sensor.  For
 * example, it's reasonable return this after multiple {@link #BIOMETRIC_ACQUIRED_INSUFFICIENT}
 * or actual detection of dirt on the sensor (stuck pixels, swaths, etc.). The user is expected
 * to take action to clean the sensor when this is returned.
 */

public static final int BIOMETRIC_ACQUIRED_IMAGER_DIRTY = 3; // 0x3

/**
 * The biometric image was too noisy to process due to a detected condition or a possibly dirty
 * sensor (See {@link #BIOMETRIC_ACQUIRED_IMAGER_DIRTY}).
 */

public static final int BIOMETRIC_ACQUIRED_INSUFFICIENT = 2; // 0x2

/**
 * Only a partial biometric image was detected. During enrollment, the user should be informed
 * on what needs to happen to resolve this problem, e.g. "press firmly on sensor." (for
 * fingerprint)
 */

public static final int BIOMETRIC_ACQUIRED_PARTIAL = 1; // 0x1

/**
 * The biometric image was incomplete due to quick motion. For example, this could also happen
 * if the user moved during acquisition. The user should be asked to repeat the operation more
 * slowly.
 */

public static final int BIOMETRIC_ACQUIRED_TOO_FAST = 5; // 0x5

/**
 * The biometric image was unreadable due to lack of motion.
 */

public static final int BIOMETRIC_ACQUIRED_TOO_SLOW = 4; // 0x4

/**
 * The operation was canceled because the biometric sensor is unavailable. For example, this may
 * happen when the user is switched, the device is locked or another pending operation prevents
 * or disables it.
 */

public static final int BIOMETRIC_ERROR_CANCELED = 5; // 0x5

/**
 * The device does not have a biometric sensor.
 */

public static final int BIOMETRIC_ERROR_HW_NOT_PRESENT = 12; // 0xc

/**
 * The hardware is unavailable. Try again later.
 */

public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = 1; // 0x1

/**
 * The operation was canceled because the API is locked out due to too many attempts.
 * This occurs after 5 failed attempts, and lasts for 30 seconds.
 */

public static final int BIOMETRIC_ERROR_LOCKOUT = 7; // 0x7

/**
 * The operation was canceled because BIOMETRIC_ERROR_LOCKOUT occurred too many times.
 * Biometric authentication is disabled until the user unlocks with strong authentication
 * (PIN/Pattern/Password)
 */

public static final int BIOMETRIC_ERROR_LOCKOUT_PERMANENT = 9; // 0x9

/**
 * The user does not have any biometrics enrolled.
 */

public static final int BIOMETRIC_ERROR_NO_BIOMETRICS = 11; // 0xb

/**
 * The device does not have pin, pattern, or password set up. See
 * {@link android.hardware.biometrics.BiometricPrompt.Builder#setDeviceCredentialAllowed(boolean) BiometricPrompt.Builder#setDeviceCredentialAllowed(boolean)} and
 * {@link android.app.KeyguardManager#isDeviceSecure() KeyguardManager#isDeviceSecure()}
 */

public static final int BIOMETRIC_ERROR_NO_DEVICE_CREDENTIAL = 14; // 0xe

/**
 * Error state returned for operations like enrollment; the operation cannot be completed
 * because there's not enough storage remaining to complete the operation.
 */

public static final int BIOMETRIC_ERROR_NO_SPACE = 4; // 0x4

/**
 * Error state returned when the current request has been running too long. This is intended to
 * prevent programs from waiting for the biometric sensor indefinitely. The timeout is platform
 * and sensor-specific, but is generally on the order of 30 seconds.
 */

public static final int BIOMETRIC_ERROR_TIMEOUT = 3; // 0x3

/**
 * Error state returned when the sensor was unable to process the current image.
 */

public static final int BIOMETRIC_ERROR_UNABLE_TO_PROCESS = 2; // 0x2

/**
 * The user canceled the operation. Upon receiving this, applications should use alternate
 * authentication (e.g. a password). The application should also provide the means to return to
 * biometric authentication, such as a "use <biometric>" button.
 */

public static final int BIOMETRIC_ERROR_USER_CANCELED = 10; // 0xa

/**
 * Hardware vendors may extend this list if there are conditions that do not fall under one of
 * the above categories. Vendors are responsible for providing error strings for these errors.
 * These messages are typically reserved for internal operations such as enrollment, but may be
 * used to express vendor errors not otherwise covered. Applications are expected to show the
 * error message string if they happen, but are advised not to rely on the message id since they
 * will be device and vendor-specific
 */

public static final int BIOMETRIC_ERROR_VENDOR = 8; // 0x8
/**
 * Callback structure provided to {@link android.hardware.biometrics.BiometricPrompt#authenticate(android.os.CancellationSignal,java.util.concurrent.Executor,android.hardware.biometrics.BiometricPrompt.AuthenticationCallback) BiometricPrompt#authenticate(CancellationSignal,
 * Executor, AuthenticationCallback)} or {@link android.hardware.biometrics.BiometricPrompt#authenticate(android.hardware.biometrics.BiometricPrompt.CryptoObject,android.os.CancellationSignal,java.util.concurrent.Executor,android.hardware.biometrics.BiometricPrompt.AuthenticationCallback) BiometricPrompt#authenticate(CryptoObject,
 * CancellationSignal, Executor, AuthenticationCallback)}. Users must provide an implementation
 * of this for listening to authentication events.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AuthenticationCallback {

public AuthenticationCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when an unrecoverable error has been encountered and the operation is complete.
 * No further actions will be made on this object.
 * @param errorCode An integer identifying the error message
 * @param errString A human-readable error string that can be shown on an UI
 * @apiSince 28
 */

public void onAuthenticationError(int errorCode, java.lang.CharSequence errString) { throw new RuntimeException("Stub!"); }

/**
 * Called when a recoverable error has been encountered during authentication. The help
 * string is provided to give the user guidance for what went wrong, such as "Sensor dirty,
 * please clean it."
 * @param helpCode An integer identifying the error message
 * @param helpString A human-readable string that can be shown on an UI
 * @apiSince 28
 */

public void onAuthenticationHelp(int helpCode, java.lang.CharSequence helpString) { throw new RuntimeException("Stub!"); }

/**
 * Called when a biometric is recognized.
 * @param result An object containing authentication-related data
 * @apiSince 28
 */

public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) { throw new RuntimeException("Stub!"); }

/**
 * Called when a biometric is valid but not recognized.
 * @apiSince 28
 */

public void onAuthenticationFailed() { throw new RuntimeException("Stub!"); }
}

/**
 * Container for callback data from {@link #authenticate(android.os.CancellationSignal,java.util.concurrent.Executor,android.hardware.biometrics.BiometricPrompt.AuthenticationCallback)} and {@link #authenticate(android.hardware.biometrics.BiometricPrompt.CryptoObject,android.os.CancellationSignal,java.util.concurrent.Executor,android.hardware.biometrics.BiometricPrompt.AuthenticationCallback)}
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AuthenticationResult {

AuthenticationResult() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the crypto object associated with this transaction
 * @return crypto object provided to {@link #authenticate(android.hardware.biometrics.BiometricPrompt.CryptoObject,android.os.CancellationSignal,java.util.concurrent.Executor,android.hardware.biometrics.BiometricPrompt.AuthenticationCallback)}
 * @apiSince 28
 */

public android.hardware.biometrics.BiometricPrompt.CryptoObject getCryptoObject() { throw new RuntimeException("Stub!"); }
}

/**
 * A builder that collects arguments to be shown on the system-provided biometric dialog.
 *     * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates a builder for a biometric dialog.
 * @param context
 * @apiSince 28
 */

public Builder(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Required: Set the title to display.
 * @param title
 * This value must never be {@code null}.
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.hardware.biometrics.BiometricPrompt.Builder setTitle(@androidx.annotation.NonNull java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Optional: Set the subtitle to display.
 * @param subtitle
 * This value must never be {@code null}.
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.hardware.biometrics.BiometricPrompt.Builder setSubtitle(@androidx.annotation.NonNull java.lang.CharSequence subtitle) { throw new RuntimeException("Stub!"); }

/**
 * Optional: Set the description to display.
 * @param description
 * This value must never be {@code null}.
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.hardware.biometrics.BiometricPrompt.Builder setDescription(@androidx.annotation.NonNull java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Required: Set the text for the negative button. This would typically be used as a
 * "Cancel" button, but may be also used to show an alternative method for authentication,
 * such as screen that asks for a backup password.
 *
 * Note that this should not be set if {@link #setDeviceCredentialAllowed(boolean)}(boolean)
 * is set to true.
 *
 * @param text
 * This value must never be {@code null}.
 * @param executor This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param listener This value must never be {@code null}.
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.hardware.biometrics.BiometricPrompt.Builder setNegativeButton(@androidx.annotation.NonNull java.lang.CharSequence text, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.content.DialogInterface.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Optional: A hint to the system to require user confirmation after a biometric has been
 * authenticated. For example, implicit modalities like Face and Iris authentication are
 * passive, meaning they don't require an explicit user action to complete. When set to
 * 'false', the user action (e.g. pressing a button) will not be required. BiometricPrompt
 * will require confirmation by default.
 *
 * A typical use case for not requiring confirmation would be for low-risk transactions,
 * such as re-authenticating a recently authenticated application. A typical use case for
 * requiring confirmation would be for authorizing a purchase.
 *
 * Note that this is a hint to the system. The system may choose to ignore the flag. For
 * example, if the user disables implicit authentication in Settings, or if it does not
 * apply to a modality (e.g. Fingerprint). When ignored, the system will default to
 * requiring confirmation.
 *
 * @param requireConfirmation
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.hardware.biometrics.BiometricPrompt.Builder setConfirmationRequired(boolean requireConfirmation) { throw new RuntimeException("Stub!"); }

/**
 * The user will first be prompted to authenticate with biometrics, but also given the
 * option to authenticate with their device PIN, pattern, or password. Developers should
 * first check {@link android.app.KeyguardManager#isDeviceSecure() KeyguardManager#isDeviceSecure()} before enabling this. If the device
 * is not secure, {@link android.hardware.biometrics.BiometricPrompt#BIOMETRIC_ERROR_NO_DEVICE_CREDENTIAL BiometricPrompt#BIOMETRIC_ERROR_NO_DEVICE_CREDENTIAL} will be
 * returned in {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback#onAuthenticationError(int,java.lang.CharSequence) AuthenticationCallback#onAuthenticationError(int, CharSequence)}}.
 * Defaults to false.
 *
 * Note that {@link #setNegativeButton(java.lang.CharSequence,java.util.concurrent.Executor,android.content.DialogInterface.OnClickListener)} should not be set if this is set to true.
 *
 * @param allowed When true, the prompt will fall back to ask for the user's device
 *               credentials (PIN, pattern, or password).
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.hardware.biometrics.BiometricPrompt.Builder setDeviceCredentialAllowed(boolean allowed) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.hardware.biometrics.BiometricPrompt BiometricPrompt}.
 * @return a {@link android.hardware.biometrics.BiometricPrompt BiometricPrompt}
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if any of the required fields are not set.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.hardware.biometrics.BiometricPrompt build() { throw new RuntimeException("Stub!"); }
}

/**
 * A wrapper class for the crypto objects supported by BiometricPrompt. Currently the framework
 * supports {@link java.security.Signature Signature}, {@link javax.crypto.Cipher Cipher} and {@link javax.crypto.Mac Mac} objects.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CryptoObject {

/**
 * @param signature This value must never be {@code null}.
 * @apiSince 28
 */

public CryptoObject(@androidx.annotation.NonNull java.security.Signature signature) { throw new RuntimeException("Stub!"); }

/**
 * @param cipher This value must never be {@code null}.
 * @apiSince 28
 */

public CryptoObject(@androidx.annotation.NonNull javax.crypto.Cipher cipher) { throw new RuntimeException("Stub!"); }

/**
 * @param mac This value must never be {@code null}.
 * @apiSince 28
 */

public CryptoObject(@androidx.annotation.NonNull javax.crypto.Mac mac) { throw new RuntimeException("Stub!"); }

/**
 * Get {@link java.security.Signature Signature} object.
 * @return {@link java.security.Signature Signature} object or null if this doesn't contain one.
 * @apiSince 28
 */

public java.security.Signature getSignature() { throw new RuntimeException("Stub!"); }

/**
 * Get {@link javax.crypto.Cipher Cipher} object.
 * @return {@link javax.crypto.Cipher Cipher} object or null if this doesn't contain one.
 * @apiSince 28
 */

public javax.crypto.Cipher getCipher() { throw new RuntimeException("Stub!"); }

/**
 * Get {@link javax.crypto.Mac Mac} object.
 * @return {@link javax.crypto.Mac Mac} object or null if this doesn't contain one.
 * @apiSince 28
 */

public javax.crypto.Mac getMac() { throw new RuntimeException("Stub!"); }
}

}

