/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net.wifi;


/**
 * Describes information about a detected access point. In addition
 * to the attributes described here, the supplicant keeps track of
 * {@code quality}, {@code noise}, and {@code maxbitrate} attributes,
 * but does not currently report them to external clients.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScanResult implements android.os.Parcelable {

ScanResult() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean is80211mcResponder() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean isPasspointNetwork() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * The address of the access point.
 * @apiSince 1
 */

public java.lang.String BSSID;

/**
 * AP Channel bandwidth is 160 MHZ
 * @apiSince 23
 */

public static final int CHANNEL_WIDTH_160MHZ = 3; // 0x3

/**
 * AP Channel bandwidth is 20 MHZ
 * @apiSince 23
 */

public static final int CHANNEL_WIDTH_20MHZ = 0; // 0x0

/**
 * AP Channel bandwidth is 40 MHZ
 * @apiSince 23
 */

public static final int CHANNEL_WIDTH_40MHZ = 1; // 0x1

/**
 * AP Channel bandwidth is 80 MHZ
 * @apiSince 23
 */

public static final int CHANNEL_WIDTH_80MHZ = 2; // 0x2

/**
 * AP Channel bandwidth is 160 MHZ, but 80MHZ + 80MHZ
 * @apiSince 23
 */

public static final int CHANNEL_WIDTH_80MHZ_PLUS_MHZ = 4; // 0x4

/**
 * The network name.
 * @apiSince 1
 */

public java.lang.String SSID;

/**
 * Describes the authentication, key management, and encryption schemes
 * supported by the access point.
 * @apiSince 1
 */

public java.lang.String capabilities;

/**
 * Not used if the AP bandwidth is 20 MHz
 * If the AP use 40, 80 or 160 MHz, this is the center frequency (in MHz)
 * if the AP use 80 + 80 MHz, this is the center frequency of the first segment (in MHz)
 * @apiSince 23
 */

public int centerFreq0;

/**
 * Only used if the AP bandwidth is 80 + 80 MHz
 * if the AP use 80 + 80 MHz, this is the center frequency of the second segment (in MHz)
 * @apiSince 23
 */

public int centerFreq1;

/**
 * AP Channel bandwidth; one of {@link #CHANNEL_WIDTH_20MHZ}, {@link #CHANNEL_WIDTH_40MHZ},
 * {@link #CHANNEL_WIDTH_80MHZ}, {@link #CHANNEL_WIDTH_160MHZ}
 * or {@link #CHANNEL_WIDTH_80MHZ_PLUS_MHZ}.
 * @apiSince 23
 */

public int channelWidth;

/**
 * The primary 20 MHz frequency (in MHz) of the channel over which the client is communicating
 * with the access point.
 * @apiSince 1
 */

public int frequency;

/**
 * The detected signal level in dBm, also known as the RSSI.
 *
 * <p>Use {@link android.net.wifi.WifiManager#calculateSignalLevel} to convert this number into
 * an absolute signal level which can be displayed to a user.
 * @apiSince 1
 */

public int level;

/**
 * Indicates Passpoint operator name published by access point.
 * @apiSince 23
 */

public java.lang.CharSequence operatorFriendlyName;

/**
 * timestamp in microseconds (since boot) when
 * this result was last seen.
 * @apiSince 17
 */

public long timestamp;

/**
 * Indicates venue name (such as 'San Francisco Airport') published by access point; only
 * available on Passpoint network and if published by access point.
 * @apiSince 23
 */

public java.lang.CharSequence venueName;
}

