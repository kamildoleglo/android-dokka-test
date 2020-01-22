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


package android.telephony;

import android.os.Parcelable;

/**
 * Define capability of a modem group. That is, the capabilities
 * are shared between those modems defined by list of modem IDs.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PhoneCapability implements android.os.Parcelable {

PhoneCapability() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * {@link android.os.Parcelable#describeContents Parcelable#describeContents}
 
 * @return Value is either <code>0</code> or {@link android.os.Parcelable#CONTENTS_FILE_DESCRIPTOR}
 * @apiSince R
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@link android.os.Parcelable#writeToParcel Parcelable#writeToParcel}
 
 * @param dest This value must never be {@code null}.
 
 * @param flags Value is either <code>0</code> or a combination of {@link android.os.Parcelable#PARCELABLE_WRITE_RETURN_VALUE}, and android.os.Parcelable.PARCELABLE_ELIDE_DUPLICATES
 * @apiSince R
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.PhoneCapability> CREATOR;
static { CREATOR = null; }
}

