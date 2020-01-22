/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.os;

import java.security.GeneralSecurityException;
import java.io.IOException;
import android.content.Context;

/**
 * RecoverySystem contains methods for interacting with the Android
 * recovery system (the separate partition that can be used to install
 * system updates, wipe user data, etc.)
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RecoverySystem {

RecoverySystem() { throw new RuntimeException("Stub!"); }

/**
 * Verify the cryptographic signature of a system update package
 * before installing it.  Note that the package is also verified
 * separately by the installer once the device is rebooted into
 * the recovery system.  This function will return only if the
 * package was successfully verified; otherwise it will throw an
 * exception.
 *
 * Verification of a package can take significant time, so this
 * function should not be called from a UI thread.  Interrupting
 * the thread while this function is in progress will result in a
 * SecurityException being thrown (and the thread's interrupt flag
 * will be cleared).
 *
 * @param packageFile  the package to be verified
 * @param listener     an object to receive periodic progress
 * updates as verification proceeds.  May be null.
 * @param deviceCertsZipFile  the zip file of certificates whose
 * public keys we will accept.  Verification succeeds if the
 * package is signed by the private key corresponding to any
 * public key in this file.  May be null to use the system default
 * file (currently "/system/etc/security/otacerts.zip").
 *
 * @throws java.io.IOException if there were any errors reading the
 * package or certs files.
 * @throws java.security.GeneralSecurityException if verification failed
 * @apiSince 8
 */

public static void verifyPackage(java.io.File packageFile, android.os.RecoverySystem.ProgressListener listener, java.io.File deviceCertsZipFile) throws java.security.GeneralSecurityException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reboots the device in order to install the given update
 * package.
 * Requires the {@link android.Manifest.permission#REBOOT} permission.
 *
 * <br>
 * Requires android.Manifest.permission.RECOVERY
 * @param context      the Context to use
 * @param packageFile  the update package to install.  Must be on
 * a partition mountable by recovery.  (The set of partitions
 * known to recovery may vary from device to device.  Generally,
 * /cache and /data are safe.)
 *
 * @throws java.io.IOException  if writing the recovery command file
 * fails, or if the reboot itself fails.
 * @apiSince 8
 */

public static void installPackage(android.content.Context context, java.io.File packageFile) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reboots the device and wipes the user data and cache
 * partitions.  This is sometimes called a "factory reset", which
 * is something of a misnomer because the system partition is not
 * restored to its factory state.  Requires the
 * {@link android.Manifest.permission#REBOOT} permission.
 *
 * @param context  the Context to use
 *
 * @throws java.io.IOException  if writing the recovery command file
 * fails, or if the reboot itself fails.
 * @throws java.lang.SecurityException if the current user is not allowed to wipe data.
 * @apiSince 8
 */

public static void rebootWipeUserData(android.content.Context context) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reboot into the recovery system to wipe the /cache partition.
 * @throws java.io.IOException if something goes wrong.
 * @apiSince 14
 */

public static void rebootWipeCache(android.content.Context context) throws java.io.IOException { throw new RuntimeException("Stub!"); }
/**
 * Interface definition for a callback to be invoked regularly as
 * verification proceeds.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ProgressListener {

/**
 * Called periodically as the verification progresses.
 *
 * @param progress  the approximate percentage of the
 *        verification that has been completed, ranging from 0
 *        to 100 (inclusive).
 * @apiSince 8
 */

public void onProgress(int progress);
}

}

