/*
 * Copyright (C) 2019 The Android Open Source Project
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


package android.telephony;

import android.content.Intent;

/**
 * Helper class for monitoring the state of packages: adding, removing,
 * updating, and disappearing and reappearing on the SD card.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PackageChangeReceiver extends android.content.BroadcastReceiver {

public PackageChangeReceiver() { throw new RuntimeException("Stub!"); }

/**
 * To register the intents that needed for monitoring the state of packages
 
 * @param context This value must never be {@code null}.
 
 * @param thread This value may be {@code null}.
 
 * @param user This value may be {@code null}.
 * @apiSince R
 */

public void register(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.Looper thread, @androidx.annotation.Nullable android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * To unregister the intents for monitoring the state of packages
 * @apiSince R
 */

public void unregister() { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked when receive the Intent.ACTION_PACKAGE_ADDED
 
 * @param packageName This value may be {@code null}.
 * @apiSince R
 */

public void onPackageAdded(@androidx.annotation.Nullable java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked when receive the Intent.ACTION_PACKAGE_REMOVED
 
 * @param packageName This value may be {@code null}.
 * @apiSince R
 */

public void onPackageRemoved(@androidx.annotation.Nullable java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked when Intent.EXTRA_REPLACING as extra field is true
 
 * @param packageName This value may be {@code null}.
 * @apiSince R
 */

public void onPackageUpdateFinished(@androidx.annotation.Nullable java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked when receive the Intent.ACTION_PACKAGE_CHANGED or
 * Intent.EXTRA_REPLACING as extra field is true
 
 * @param packageName This value may be {@code null}.
 * @apiSince R
 */

public void onPackageModified(@androidx.annotation.Nullable java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked when receive the Intent.ACTION_QUERY_PACKAGE_RESTART and
 * Intent.ACTION_PACKAGE_RESTARTED
 
 * @param packages This value may be {@code null}.
 * @apiSince R
 */

public void onHandleForceStop(@androidx.annotation.Nullable java.lang.String[] packages, boolean doit) { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked when receive the Intent.ACTION_PACKAGE_REMOVED
 * @apiSince R
 */

public void onPackageDisappeared() { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked when receive the Intent.ACTION_PACKAGE_ADDED
 * @apiSince R
 */

public void onPackageAppeared() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param context This value may be {@code null}.
 
 * @param intent This value may be {@code null}.
 * @apiSince R
 */

public void onReceive(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable android.content.Intent intent) { throw new RuntimeException("Stub!"); }
}

