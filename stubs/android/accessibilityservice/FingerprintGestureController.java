/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.accessibilityservice;


/**
 * An {@link android.accessibilityservice.AccessibilityService AccessibilityService} can capture gestures performed on a device's fingerprint
 * sensor, as long as the device has a sensor capable of detecting gestures.
 * <p>
 * This capability must be declared by the service as
 * {@link android.accessibilityservice.AccessibilityServiceInfo#CAPABILITY_CAN_REQUEST_FINGERPRINT_GESTURES AccessibilityServiceInfo#CAPABILITY_CAN_REQUEST_FINGERPRINT_GESTURES}. It also requires
 * the permission {@link android.Manifest.permission#USE_FINGERPRINT}.
 * <p>
 * Because capturing fingerprint gestures may have side effects, services with the capability only
 * capture gestures when {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_REQUEST_FINGERPRINT_GESTURES AccessibilityServiceInfo#FLAG_REQUEST_FINGERPRINT_GESTURES} is set.
 * <p>
 * <strong>Note: </strong>The fingerprint sensor is used for authentication in critical use cases,
 * so services must carefully design their user's experience when performing gestures on the sensor.
 * When the sensor is in use by an app, for example, when authenticating or enrolling a user,
 * the sensor will not detect gestures. Services need to ensure that users understand when the
 * sensor is in-use for authentication to prevent users from authenticating unintentionally when
 * trying to interact with the service. They can use
 * {@link android.accessibilityservice.FingerprintGestureController.FingerprintGestureCallback#onGestureDetectionAvailabilityChanged(boolean) FingerprintGestureCallback#onGestureDetectionAvailabilityChanged(boolean)} to learn when
 * gesture detection becomes unavailable.
 * <p>
 * Multiple accessibility services may listen for fingerprint gestures simultaneously, so services
 * should provide a way for the user to disable the use of this feature so multiple services don't
 * conflict with each other.
 * <p>
 * {@see android.hardware.fingerprint.FingerprintManager#isHardwareDetected}
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FingerprintGestureController {

FingerprintGestureController() { throw new RuntimeException("Stub!"); }

/**
 * Gets if the fingerprint sensor's gesture detection is available.
 *
 * @return {@code true} if the sensor's gesture detection is available. {@code false} if it is
 * not currently detecting gestures (for example, if it is enrolling a finger).
 * @apiSince 26
 */

public boolean isGestureDetectionAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be informed of fingerprint sensor gesture events.
 *
 * @param callback The listener to be added.
 * This value must never be {@code null}.
 * @param handler The handler to use for the callback. If {@code null}, callbacks will happen
 * on the service's main thread.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void registerFingerprintGestureCallback(@androidx.annotation.NonNull android.accessibilityservice.FingerprintGestureController.FingerprintGestureCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregister a listener added with {@link #registerFingerprintGestureCallback}.
 *
 * @param callback The callback to remove. Removing a callback that was never added has no
 * effect.
 * @apiSince 26
 */

public void unregisterFingerprintGestureCallback(android.accessibilityservice.FingerprintGestureController.FingerprintGestureCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Identifier for a swipe down on the fingerprint sensor
 * @apiSince 26
 */

public static final int FINGERPRINT_GESTURE_SWIPE_DOWN = 8; // 0x8

/**
 * Identifier for a swipe left on the fingerprint sensor
 * @apiSince 26
 */

public static final int FINGERPRINT_GESTURE_SWIPE_LEFT = 2; // 0x2

/**
 * Identifier for a swipe right on the fingerprint sensor
 * @apiSince 26
 */

public static final int FINGERPRINT_GESTURE_SWIPE_RIGHT = 1; // 0x1

/**
 * Identifier for a swipe up on the fingerprint sensor
 * @apiSince 26
 */

public static final int FINGERPRINT_GESTURE_SWIPE_UP = 4; // 0x4
/**
 * Class that is called back when fingerprint gestures are being used for accessibility.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class FingerprintGestureCallback {

public FingerprintGestureCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the fingerprint sensor's gesture detection becomes available or unavailable.
 *
 * @param available Whether or not the sensor's gesture detection is now available.
 * @apiSince 26
 */

public void onGestureDetectionAvailabilityChanged(boolean available) { throw new RuntimeException("Stub!"); }

/**
 * Called when the fingerprint sensor detects gestures.
 *
 * @param gesture The id of the gesture that was detected. For example,
 * {@link #FINGERPRINT_GESTURE_SWIPE_RIGHT}.
 * @apiSince 26
 */

public void onGestureDetected(int gesture) { throw new RuntimeException("Stub!"); }
}

}

