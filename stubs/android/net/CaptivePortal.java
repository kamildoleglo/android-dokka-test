/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed urnder the Apache License, Version 2.0 (the "License");
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

package android.net;


/**
 * A class allowing apps handling the {@link android.net.ConnectivityManager#ACTION_CAPTIVE_PORTAL_SIGN_IN ConnectivityManager#ACTION_CAPTIVE_PORTAL_SIGN_IN}
 * activity to indicate to the system different outcomes of captive portal sign in.  This class is
 * passed as an extra named {@link android.net.ConnectivityManager#EXTRA_CAPTIVE_PORTAL ConnectivityManager#EXTRA_CAPTIVE_PORTAL} with the
 * {@code ACTION_CAPTIVE_PORTAL_SIGN_IN} activity.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CaptivePortal implements android.os.Parcelable {

CaptivePortal() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Indicate to the system that the captive portal has been
 * dismissed.  In response the framework will re-evaluate the network's
 * connectivity and might take further action thereafter.
 * @apiSince 23
 */

public void reportCaptivePortalDismissed() { throw new RuntimeException("Stub!"); }

/**
 * Indicate to the system that the user does not want to pursue signing in to the
 * captive portal and the system should continue to prefer other networks
 * without captive portals for use as the default active data network.  The
 * system will not retest the network for a captive portal so as to avoid
 * disturbing the user with further sign in to network notifications.
 * @apiSince 23
 */

public void ignoreNetwork() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.CaptivePortal> CREATOR;
static { CREATOR = null; }
}

