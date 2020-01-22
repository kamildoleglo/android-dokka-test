/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.telecom;

import android.os.UserHandle;
import android.content.ComponentName;

/**
 * The unique identifier for a {@link android.telecom.PhoneAccount PhoneAccount}. A {@code PhoneAccountHandle} is made of two
 * parts:
 * <ul>
 *  <li>The component name of the associated connection service.</li>
 *  <li>A string identifier that is unique across {@code PhoneAccountHandle}s with the same
 *      component name.</li>
 * </ul>
 *
 * Note: This Class requires a non-null {@link android.content.ComponentName ComponentName} and {@link android.os.UserHandle UserHandle} to operate
 * properly. Passing in invalid parameters will generate a log warning.
 *
 * See {@link android.telecom.PhoneAccount PhoneAccount}, {@link android.telecom.TelecomManager TelecomManager}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PhoneAccountHandle implements android.os.Parcelable {

/**
 * @param componentName This value must never be {@code null}.
 
 * @param id This value must never be {@code null}.
 * @apiSince 23
 */

public PhoneAccountHandle(@androidx.annotation.NonNull android.content.ComponentName componentName, @androidx.annotation.NonNull java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * @param componentName This value must never be {@code null}.
 
 * @param id This value must never be {@code null}.
 
 * @param userHandle This value must never be {@code null}.
 * @apiSince 23
 */

public PhoneAccountHandle(@androidx.annotation.NonNull android.content.ComponentName componentName, @androidx.annotation.NonNull java.lang.String id, @androidx.annotation.NonNull android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * The {@code ComponentName} of the connection service which is responsible for making phone
 * calls using this {@code PhoneAccountHandle}.
 *
 * @return A suitable {@code ComponentName}.
 * @apiSince 23
 */

public android.content.ComponentName getComponentName() { throw new RuntimeException("Stub!"); }

/**
 * A string that uniquely distinguishes this particular {@code PhoneAccountHandle} from all the
 * others supported by the connection service that created it.
 * <p>
 * A connection service must select identifiers that are stable for the lifetime of
 * their users' relationship with their service, across many Android devices. For example, a
 * good set of identifiers might be the email addresses with which with users registered for
 * their accounts with a particular service. Depending on how a service chooses to operate,
 * a bad set of identifiers might be an increasing series of integers
 * ({@code 0}, {@code 1}, {@code 2}, ...) that are generated locally on each phone and could
 * collide with values generated on other phones or after a data wipe of a given phone.
 *
 * Important: A non-unique identifier could cause non-deterministic call-log backup/restore
 * behavior.
 *
 * @return A service-specific unique identifier for this {@code PhoneAccountHandle}.
 * @apiSince 23
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * @return the {@link android.os.UserHandle UserHandle} to use when connecting to this PhoneAccount.
 * @apiSince 23
 */

public android.os.UserHandle getUserHandle() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telecom.PhoneAccountHandle> CREATOR;
static { CREATOR = null; }
}

