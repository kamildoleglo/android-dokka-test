/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.app;

import android.hardware.biometrics.BiometricPrompt;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.Context;
import android.view.WindowManager.LayoutParams;
import android.Manifest;

/**
 * Class that can be used to lock and unlock the keyguard. The
 * actual class to control the keyguard locking is
 * {@link android.app.KeyguardManager.KeyguardLock}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyguardManager {

KeyguardManager() { throw new RuntimeException("Stub!"); }

/**
 * Get an intent to prompt the user to confirm credentials (pin, pattern, password or biometrics
 * if enrolled) for the current user of the device. The caller is expected to launch this
 * activity using {@link android.app.Activity#startActivityForResult(Intent, int)} and check for
 * {@link android.app.Activity#RESULT_OK} if the user successfully completes the challenge.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @return the intent for launching the activity or null if no password is required.
 * @deprecated see {@link android.hardware.biometrics.BiometricPrompt.Builder#setDeviceCredentialAllowed(boolean) BiometricPrompt.Builder#setDeviceCredentialAllowed(boolean)}
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public android.content.Intent createConfirmDeviceCredentialIntent(java.lang.CharSequence title, java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Enables you to lock or unlock the keyguard. Get an instance of this class by
 * calling {@link android.content.Context#getSystemService(java.lang.String) Context.getSystemService()}.
 * This class is wrapped by {@link android.app.KeyguardManager KeyguardManager}.
 * @param tag A tag that informally identifies who you are (for debugging who
 *   is disabling the keyguard).
 *
 * @return A {@link android.app.KeyguardManager.KeyguardLock KeyguardLock} handle to use to disable and reenable the
 *   keyguard.
 *
 * @deprecated Use {@link android.view.WindowManager.LayoutParams#FLAG_DISMISS_KEYGUARD LayoutParams#FLAG_DISMISS_KEYGUARD}
 *   and/or {@link android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED LayoutParams#FLAG_SHOW_WHEN_LOCKED}
 *   instead; this allows you to seamlessly hide the keyguard as your application
 *   moves in and out of the foreground and does not require that any special
 *   permissions be requested.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public android.app.KeyguardManager.KeyguardLock newKeyguardLock(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the keyguard is currently locked.
 *
 * @return true if keyguard is locked.
 * @apiSince 16
 */

public boolean isKeyguardLocked() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the keyguard is secured by a PIN, pattern or password or a SIM card
 * is currently locked.
 *
 * <p>See also {@link #isDeviceSecure()} which ignores SIM locked states.
 *
 * @return true if a PIN, pattern or password is set or a SIM card is locked.
 * @apiSince 16
 */

public boolean isKeyguardSecure() { throw new RuntimeException("Stub!"); }

/**
 * If keyguard screen is showing or in restricted key input mode (i.e. in
 * keyguard password emergency screen). When in such mode, certain keys,
 * such as the Home key and the right soft keys, don't work.
 *
 * @return true if in keyguard restricted input mode.
 * @deprecated Use {@link #isKeyguardLocked()} instead.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public boolean inKeyguardRestrictedInputMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the device is currently locked and requires a PIN, pattern or
 * password to unlock.
 *
 * @return true if unlocking the device currently requires a PIN, pattern or
 * password.
 * @apiSince 22
 */

public boolean isDeviceLocked() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the device is secured with a PIN, pattern or
 * password.
 *
 * <p>See also {@link #isKeyguardSecure} which treats SIM locked states as secure.
 *
 * @return true if a PIN, pattern or password was set.
 * @apiSince 23
 */

public boolean isDeviceSecure() { throw new RuntimeException("Stub!"); }

/**
 * If the device is currently locked (see {@link #isKeyguardLocked()}, requests the Keyguard to
 * be dismissed.
 * <p>
 * If the Keyguard is not secure or the device is currently in a trusted state, calling this
 * method will immediately dismiss the Keyguard without any user interaction.
 * <p>
 * If the Keyguard is secure and the device is not in a trusted state, this will bring up the
 * UI so the user can enter their credentials.
 * <p>
 * If the value set for the {@link android.app.Activity Activity} attr {@link android.R.attr#turnScreenOn} is true,
 * the screen will turn on when the keyguard is dismissed.
 *
 * @param activity The activity requesting the dismissal. The activity must be either visible
 *                 by using {@link android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED LayoutParams#FLAG_SHOW_WHEN_LOCKED} or must be in a state in
 *                 which it would be visible if Keyguard would not be hiding it. If that's not
 *                 the case, the request will fail immediately and
 *                 {@link android.app.KeyguardManager.KeyguardDismissCallback#onDismissError KeyguardDismissCallback#onDismissError} will be invoked.
 * This value must never be {@code null}.
 * @param callback The callback to be called if the request to dismiss Keyguard was successful
 *                 or {@code null} if the caller isn't interested in knowing the result. The
 *                 callback will not be invoked if the activity was destroyed before the
 *                 callback was received.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void requestDismissKeyguard(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.app.KeyguardManager.KeyguardDismissCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Exit the keyguard securely.  The use case for this api is that, after
 * disabling the keyguard, your app, which was granted permission to
 * disable the keyguard and show a limited amount of information deemed
 * safe without the user getting past the keyguard, needs to navigate to
 * something that is not safe to view without getting past the keyguard.
 *
 * This will, if the keyguard is secure, bring up the unlock screen of
 * the keyguard.
 *
 * <br>
 * Requires {@link android.Manifest.permission#DISABLE_KEYGUARD}
 * @param callback Lets you know whether the operation was successful and
 *   it is safe to launch anything that would normally be considered safe
 *   once the user has gotten past the keyguard.
 
 * @deprecated Use {@link android.view.WindowManager.LayoutParams#FLAG_DISMISS_KEYGUARD LayoutParams#FLAG_DISMISS_KEYGUARD}
 *   and/or {@link android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED LayoutParams#FLAG_SHOW_WHEN_LOCKED}
 *   instead; this allows you to seamlessly hide the keyguard as your application
 *   moves in and out of the foreground and does not require that any special
 *   permissions be requested.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void exitKeyguardSecurely(android.app.KeyguardManager.OnKeyguardExitResult callback) { throw new RuntimeException("Stub!"); }
/**
 * Callback passed to
 * {@link android.app.KeyguardManager#requestDismissKeyguard(android.app.Activity,android.app.KeyguardManager.KeyguardDismissCallback) KeyguardManager#requestDismissKeyguard(Activity, KeyguardDismissCallback)}
 * to notify caller of result.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class KeyguardDismissCallback {

public KeyguardDismissCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when dismissing Keyguard is currently not feasible, i.e. when Keyguard is not
 * available, not showing or when the activity requesting the Keyguard dismissal isn't
 * showing or isn't showing behind Keyguard.
 * @apiSince 26
 */

public void onDismissError() { throw new RuntimeException("Stub!"); }

/**
 * Called when dismissing Keyguard has succeeded and the device is now unlocked.
 * @apiSince 26
 */

public void onDismissSucceeded() { throw new RuntimeException("Stub!"); }

/**
 * Called when dismissing Keyguard has been cancelled, i.e. when the user cancelled the
 * operation or the bouncer was hidden for some other reason.
 * @apiSince 26
 */

public void onDismissCancelled() { throw new RuntimeException("Stub!"); }
}

/**
 * Handle returned by {@link android.app.KeyguardManager#newKeyguardLock KeyguardManager#newKeyguardLock} that allows
 * you to disable / reenable the keyguard.
 *
 * @deprecated Use {@link android.view.WindowManager.LayoutParams#FLAG_DISMISS_KEYGUARD LayoutParams#FLAG_DISMISS_KEYGUARD}
 * and/or {@link android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED LayoutParams#FLAG_SHOW_WHEN_LOCKED}
 * instead; this allows you to seamlessly hide the keyguard as your application
 * moves in and out of the foreground and does not require that any special
 * permissions be requested.
 * @apiSince 1
 * @deprecatedSince 15
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class KeyguardLock {

KeyguardLock() { throw new RuntimeException("Stub!"); }

/**
 * Disable the keyguard from showing.  If the keyguard is currently
 * showing, hide it.  The keyguard will be prevented from showing again
 * until {@link #reenableKeyguard()} is called.
 *
 * A good place to call this is from {@link android.app.Activity#onResume()}
 *
 * Note: This call has no effect while any {@link android.app.admin.DevicePolicyManager}
 * is enabled that requires a password.
 *
 * <br>
 * Requires {@link android.Manifest.permission#DISABLE_KEYGUARD}
 * @see #reenableKeyguard()
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void disableKeyguard() { throw new RuntimeException("Stub!"); }

/**
 * Reenable the keyguard.  The keyguard will reappear if the previous
 * call to {@link #disableKeyguard()} caused it to be hidden.
 *
 * A good place to call this is from {@link android.app.Activity#onPause()}
 *
 * Note: This call has no effect while any {@link android.app.admin.DevicePolicyManager}
 * is enabled that requires a password.
 *
 * <br>
 * Requires {@link android.Manifest.permission#DISABLE_KEYGUARD}
 * @see #disableKeyguard()
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void reenableKeyguard() { throw new RuntimeException("Stub!"); }
}

/**
 * Callback passed to {@link android.app.KeyguardManager#exitKeyguardSecurely KeyguardManager#exitKeyguardSecurely} to notify
 * caller of result.
 *
 * @deprecated Use {@link android.app.KeyguardManager.KeyguardDismissCallback KeyguardDismissCallback}
 * @apiSince 1
 * @deprecatedSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnKeyguardExitResult {

/**
 * @param success True if the user was able to authenticate, false if
 *   not.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void onKeyguardExitResult(boolean success);
}

}

