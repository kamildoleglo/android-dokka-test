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
 * limitations under the License
 */


package android.location;


/**
 * A class containing a GNSS satellite Navigation Message.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GnssNavigationMessage implements android.os.Parcelable {

GnssNavigationMessage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of the navigation message contained in the object.
 
 * @return Value is {@link android.location.GnssNavigationMessage#TYPE_UNKNOWN}, {@link android.location.GnssNavigationMessage#TYPE_GPS_L1CA}, {@link android.location.GnssNavigationMessage#TYPE_GPS_L2CNAV}, {@link android.location.GnssNavigationMessage#TYPE_GPS_L5CNAV}, {@link android.location.GnssNavigationMessage#TYPE_GPS_CNAV2}, {@link android.location.GnssNavigationMessage#TYPE_GLO_L1CA}, {@link android.location.GnssNavigationMessage#TYPE_BDS_D1}, {@link android.location.GnssNavigationMessage#TYPE_BDS_D2}, {@link android.location.GnssNavigationMessage#TYPE_GAL_I}, or {@link android.location.GnssNavigationMessage#TYPE_GAL_F}
 * @apiSince 24
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the satellite ID.
 *
 * <p>Range varies by constellation.  See definition at {@code GnssStatus#getSvid(int)}
 * @apiSince 24
 */

public int getSvid() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Message identifier.
 *
 * <p>This provides an index to help with complete Navigation Message assembly. Similar
 * identifiers within the data bits themselves often supplement this information, in ways even
 * more specific to each message type; see the relevant satellite constellation ICDs for
 * details.
 *
 * <ul>
 * <li> For GPS L1 C/A subframe 4 and 5, this value corresponds to the 'frame id' of the
 * navigation message, in the range of 1-25 (Subframe 1, 2, 3 does not contain a 'frame id' and
 * this value can be set to -1.)</li>
 * <li> For Glonass L1 C/A, this refers to the frame ID, in the range of 1-5.</li>
 * <li> For BeiDou D1, this refers to the frame number in the range of 1-24</li>
 * <li> For Beidou D2, this refers to the frame number, in the range of 1-120</li>
 * <li> For Galileo F/NAV nominal frame structure, this refers to the subframe number, in the
 * range of 1-12</li>
 * <li> For Galileo I/NAV nominal frame structure, this refers to the subframe number in the
 * range of 1-24</li>
 * </ul>
 * @apiSince 24
 */

public int getMessageId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the sub-message identifier, relevant to the {@link #getType()} of the message.
 *
 * <ul>
 * <li> For GPS L1 C/A, BeiDou D1 &amp; BeiDou D2, the submessage id corresponds to the subframe
 * number of the navigation message, in the range of 1-5.</li>
 * <li>For Glonass L1 C/A, this refers to the String number, in the range from 1-15</li>
 * <li>For Galileo F/NAV, this refers to the page type in the range 1-6</li>
 * <li>For Galileo I/NAV, this refers to the word type in the range 1-10+</li>
 * <li>For Galileo in particular, the type information embedded within the data bits may be even
 * more useful in interpretation, than the nominal page and word types provided in this
 * field.</li>
 * </ul>
 * @apiSince 24
 */

public int getSubmessageId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the data of the reported GPS message.
 *
 * <p>The bytes (or words) specified using big endian format (MSB first).
 *
 * <ul>
 * <li>For GPS L1 C/A, Beidou D1 &amp; Beidou D2, each subframe contains 10 30-bit words. Each
 * word (30 bits) should be fit into the last 30 bits in a 4-byte word (skip B31 and B32), with
 * MSB first, for a total of 40 bytes, covering a time period of 6, 6, and 0.6 seconds,
 * respectively.</li>
 * <li>For Glonass L1 C/A, each string contains 85 data bits, including the checksum.  These
 * bits should be fit into 11 bytes, with MSB first (skip B86-B88), covering a time period of 2
 * seconds.</li>
 * <li>For Galileo F/NAV, each word consists of 238-bit (sync &amp; tail symbols excluded). Each
 * word should be fit into 30-bytes, with MSB first (skip B239, B240), covering a time period of
 * 10 seconds.</li>
 * <li>For Galileo I/NAV, each page contains 2 page parts, even and odd, with a total of 2x114 =
 * 228 bits, (sync &amp; tail excluded) that should be fit into 29 bytes, with MSB first (skip
 * B229-B232).</li>
 * </ul>
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public byte[] getData() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Status of the navigation message contained in the object.
 * @apiSince 24
 */

public int getStatus() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.location.GnssNavigationMessage> CREATOR;
static { CREATOR = null; }

/**
 * The Navigation Message was received without any parity error in its navigation words.
 * @apiSince 24
 */

public static final int STATUS_PARITY_PASSED = 1; // 0x1

/**
 * The Navigation Message was received with words that failed parity check, but the receiver was
 * able to correct those words.
 * @apiSince 24
 */

public static final int STATUS_PARITY_REBUILT = 2; // 0x2

/**
 * The Navigation Message Status is 'unknown'.
 * @apiSince 24
 */

public static final int STATUS_UNKNOWN = 0; // 0x0

/**
 * Beidou D1 message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_BDS_D1 = 1281; // 0x501

/**
 * Beidou D2 message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_BDS_D2 = 1282; // 0x502

/**
 * Galileo F/NAV message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_GAL_F = 1538; // 0x602

/**
 * Galileo I/NAV message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_GAL_I = 1537; // 0x601

/**
 * Glonass L1 CA message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_GLO_L1CA = 769; // 0x301

/**
 * GPS CNAV-2 message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_GPS_CNAV2 = 260; // 0x104

/**
 * GPS L1 C/A message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_GPS_L1CA = 257; // 0x101

/**
 * GPS L2-CNAV message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_GPS_L2CNAV = 258; // 0x102

/**
 * GPS L5-CNAV message contained in the structure.
 * @apiSince 24
 */

public static final int TYPE_GPS_L5CNAV = 259; // 0x103

/**
 * Message type unknown
 * @apiSince 24
 */

public static final int TYPE_UNKNOWN = 0; // 0x0
/**
 * Used for receiving GNSS satellite Navigation Messages from the GNSS engine.
 *
 * <p>You can implement this interface and call
 * {@link android.location.LocationManager#registerGnssNavigationMessageCallback LocationManager#registerGnssNavigationMessageCallback}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Returns the latest collected GNSS Navigation Message.
 * @apiSince 24
 */

public void onGnssNavigationMessageReceived(android.location.GnssNavigationMessage event) { throw new RuntimeException("Stub!"); }

/**
 * Returns the latest status of the GNSS Navigation Messages sub-system.
 
 * @param status Value is {@link android.location.GnssNavigationMessage.Callback#STATUS_NOT_SUPPORTED}, {@link android.location.GnssNavigationMessage.Callback#STATUS_READY}, or {@link android.location.GnssNavigationMessage.Callback#STATUS_LOCATION_DISABLED}
 * @apiSince 24
 */

public void onStatusChanged(int status) { throw new RuntimeException("Stub!"); }

/**
 * GNSS provider or Location is disabled, updated will not be received until they are
 * enabled.
 * @apiSince 24
 */

public static final int STATUS_LOCATION_DISABLED = 2; // 0x2

/**
 * The system does not support tracking of GNSS Navigation Messages.
 *
 * This status will not change in the future.
 * @apiSince 24
 */

public static final int STATUS_NOT_SUPPORTED = 0; // 0x0

/**
 * GNSS Navigation Messages are successfully being tracked, it will receive updates once
 * they are available.
 * @apiSince 24
 */

public static final int STATUS_READY = 1; // 0x1
}

}

