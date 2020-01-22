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


package android.net.wifi.aware;

import android.os.Parcelable;

/**
 * A Parcelable {@link android.net.wifi.aware.PeerHandle PeerHandle}. Can be constructed from a {@code PeerHandle} and then passed
 * to any of the APIs which take a {@code PeerHandle} as inputs.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ParcelablePeerHandle extends android.net.wifi.aware.PeerHandle implements android.os.Parcelable {

/**
 * Construct a parcelable version of {@link android.net.wifi.aware.PeerHandle PeerHandle}.
 *
 * @param peerHandle The {@link android.net.wifi.aware.PeerHandle PeerHandle} to be made parcelable.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public ParcelablePeerHandle(@androidx.annotation.NonNull android.net.wifi.aware.PeerHandle peerHandle) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.aware.ParcelablePeerHandle> CREATOR;
static { CREATOR = null; }
}

