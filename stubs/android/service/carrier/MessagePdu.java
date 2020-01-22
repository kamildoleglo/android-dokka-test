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


package android.service.carrier;

import android.os.Parcel;

/**
 * A parcelable list of PDUs representing contents of a possibly multi-part SMS.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MessagePdu implements android.os.Parcelable {

/**
 * Constructs a MessagePdu with the list of message PDUs.
 *
 * @param pduList the list of message PDUs
 
 * This value must never be {@code null}.
 * @apiSince 22
 */

public MessagePdu(@androidx.annotation.NonNull java.util.List<byte[]> pduList) { throw new RuntimeException("Stub!"); }

/**
 * Returns the contents of a possibly multi-part SMS.
 *
 * @return the list of PDUs
 
 * This value will never be {@code null}.
 * @apiSince 22
 */

@androidx.annotation.NonNull
public java.util.List<byte[]> getPdus() { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 22 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.service.carrier.MessagePdu MessagePdu} from a {@link android.os.Parcel Parcel}.
 * @apiSince 22
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.carrier.MessagePdu> CREATOR;
static { CREATOR = null; }
}

