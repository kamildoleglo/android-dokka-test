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


package android.telephony;


/**
 * Response to the {@link android.telephony.TelephonyManager#iccOpenLogicalChannel TelephonyManager#iccOpenLogicalChannel} command.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IccOpenLogicalChannelResponse implements android.os.Parcelable {

IccOpenLogicalChannelResponse() { throw new RuntimeException("Stub!"); }

/**
 * @return the channel id.
 * @apiSince 21
 */

public int getChannel() { throw new RuntimeException("Stub!"); }

/**
 * @return the status of the command.
 * @apiSince 21
 */

public int getStatus() { throw new RuntimeException("Stub!"); }

/**
 * @return the select response.
 * @apiSince 21
 */

public byte[] getSelectResponse() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.IccOpenLogicalChannelResponse> CREATOR;
static { CREATOR = null; }

/**
 * Indicates an invalid channel.
 * @apiSince 21
 */

public static final int INVALID_CHANNEL = -1; // 0xffffffff

/** @apiSince 21 */

public static final int STATUS_MISSING_RESOURCE = 2; // 0x2

/**
 * Possible status values returned by open channel command.
 *
 * STATUS_NO_ERROR: Open channel command returned successfully.
 * STATUS_MISSING_RESOURCE: No logical channels available.
 * STATUS_NO_SUCH_ELEMENT: AID not found on UICC.
 * STATUS_UNKNOWN_ERROR: Unknown error in open channel command.
 * @apiSince 21
 */

public static final int STATUS_NO_ERROR = 1; // 0x1

/** @apiSince 21 */

public static final int STATUS_NO_SUCH_ELEMENT = 3; // 0x3

/** @apiSince 21 */

public static final int STATUS_UNKNOWN_ERROR = 4; // 0x4
}

