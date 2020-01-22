/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.net.wifi.rtt;

import java.util.List;
import android.net.wifi.aware.PeerHandle;

/**
 * Ranging result for a request started by
 * {@link android.net.wifi.rtt.WifiRttManager#startRanging(android.net.wifi.rtt.RangingRequest,java.util.concurrent.Executor,android.net.wifi.rtt.RangingResultCallback) WifiRttManager#startRanging(RangingRequest, java.util.concurrent.Executor, RangingResultCallback)}.
 * Results are returned in {@link android.net.wifi.rtt.RangingResultCallback#onRangingResults(java.util.List) RangingResultCallback#onRangingResults(List)}.
 * <p>
 * A ranging result is the distance measurement result for a single device specified in the
 * {@link android.net.wifi.rtt.RangingRequest RangingRequest}.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RangingResult implements android.os.Parcelable {

RangingResult() { throw new RuntimeException("Stub!"); }

/**
 * @return The status of ranging measurement: {@link #STATUS_SUCCESS} in case of success, and
 * {@link #STATUS_FAIL} in case of failure.
 
 * Value is {@link android.net.wifi.rtt.RangingResult#STATUS_SUCCESS}, {@link android.net.wifi.rtt.RangingResult#STATUS_FAIL}, or {@link android.net.wifi.rtt.RangingResult#STATUS_RESPONDER_DOES_NOT_SUPPORT_IEEE80211MC}
 * @apiSince 28
 */

public int getStatus() { throw new RuntimeException("Stub!"); }

/**
 * @return The MAC address of the device whose range measurement was requested. Will correspond
 * to the MAC address of the device in the {@link android.net.wifi.rtt.RangingRequest RangingRequest}.
 * <p>
 * Will return a {@code null} for results corresponding to requests issued using a {@code
 * PeerHandle}, i.e. using the {@link android.net.wifi.rtt.RangingRequest.Builder#addWifiAwarePeer(android.net.wifi.aware.PeerHandle) RangingRequest.Builder#addWifiAwarePeer(PeerHandle)} API.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.net.MacAddress getMacAddress() { throw new RuntimeException("Stub!"); }

/**
 * @return The PeerHandle of the device whose reange measurement was requested. Will correspond
 * to the PeerHandle of the devices requested using
 * {@link android.net.wifi.rtt.RangingRequest.Builder#addWifiAwarePeer(android.net.wifi.aware.PeerHandle) RangingRequest.Builder#addWifiAwarePeer(PeerHandle)}.
 * <p>
 * Will return a {@code null} for results corresponding to requests issued using a MAC address.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.net.wifi.aware.PeerHandle getPeerHandle() { throw new RuntimeException("Stub!"); }

/**
 * @return The distance (in mm) to the device specified by {@link #getMacAddress()} or
 * {@link #getPeerHandle()}.
 * <p>
 * Note: the measured distance may be negative for very close devices.
 * <p>
 * Only valid if {@link #getStatus()} returns {@link #STATUS_SUCCESS}, otherwise will throw an
 * exception.
 * @apiSince 28
 */

public int getDistanceMm() { throw new RuntimeException("Stub!"); }

/**
 * @return The standard deviation of the measured distance (in mm) to the device specified by
 * {@link #getMacAddress()} or {@link #getPeerHandle()}. The standard deviation is calculated
 * over the measurements executed in a single RTT burst. The number of measurements is returned
 * by {@link #getNumSuccessfulMeasurements()} - 0 successful measurements indicate that the
 * standard deviation is not valid (a valid standard deviation requires at least 2 data points).
 * <p>
 * Only valid if {@link #getStatus()} returns {@link #STATUS_SUCCESS}, otherwise will throw an
 * exception.
 * @apiSince 28
 */

public int getDistanceStdDevMm() { throw new RuntimeException("Stub!"); }

/**
 * @return The average RSSI, in units of dBm, observed during the RTT measurement.
 * <p>
 * Only valid if {@link #getStatus()} returns {@link #STATUS_SUCCESS}, otherwise will throw an
 * exception.
 * @apiSince 28
 */

public int getRssi() { throw new RuntimeException("Stub!"); }

/**
 * @return The number of attempted measurements used in the RTT exchange resulting in this set
 * of results. The number of successful measurements is returned by
 * {@link #getNumSuccessfulMeasurements()} which at most, if there are no errors, will be 1 less
 * that the number of attempted measurements.
 * <p>
 * Only valid if {@link #getStatus()} returns {@link #STATUS_SUCCESS}, otherwise will throw an
 * exception.
 * @apiSince 28
 */

public int getNumAttemptedMeasurements() { throw new RuntimeException("Stub!"); }

/**
 * @return The number of successful measurements used to calculate the distance and standard
 * deviation. If the number of successful measurements if 1 then then standard deviation,
 * returned by {@link #getDistanceStdDevMm()}, is not valid (a 0 is returned for the standard
 * deviation).
 * <p>
 * The total number of measurement attempts is returned by
 * {@link #getNumAttemptedMeasurements()}. The number of successful measurements will be at
 * most 1 less then the number of attempted measurements.
 * <p>
 * Only valid if {@link #getStatus()} returns {@link #STATUS_SUCCESS}, otherwise will throw an
 * exception.
 * @apiSince 28
 */

public int getNumSuccessfulMeasurements() { throw new RuntimeException("Stub!"); }

/**
 * @return The unverified responder location represented as {@link android.net.wifi.rtt.ResponderLocation ResponderLocation} which
 * captures location information the responder is programmed to broadcast. The responder
 * location is referred to as unverified, because we are relying on the device/site
 * administrator to correctly configure its location data.
 * <p>
 * Will return a {@code null} when the location information cannot be parsed.
 * <p>
 * Only valid if {@link #getStatus()} returns {@link #STATUS_SUCCESS}, otherwise will throw an
 * exception.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.net.wifi.rtt.ResponderLocation getUnverifiedResponderLocation() { throw new RuntimeException("Stub!"); }

/**
 * @return The timestamp at which the ranging operation was performed. The timestamp is in
 * milliseconds since boot, including time spent in sleep, corresponding to values provided by
 * {@link android.os.SystemClock#elapsedRealtime()}.
 * <p>
 * Only valid if {@link #getStatus()} returns {@link #STATUS_SUCCESS}, otherwise will throw an
 * exception.
 * @apiSince 28
 */

public long getRangingTimestampMillis() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @hide */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.rtt.RangingResult> CREATOR;
static { CREATOR = null; }

/**
 * Individual range request status, {@link #getStatus()}. Indicates ranging operation failed
 * and the distance value is invalid.
 * @apiSince 28
 */

public static final int STATUS_FAIL = 1; // 0x1

/**
 * Individual range request status, {@link #getStatus()}. Indicates that the ranging operation
 * failed because the specified peer does not support IEEE 802.11mc RTT operations. Support by
 * an Access Point can be confirmed using
 * {@link android.net.wifi.ScanResult#is80211mcResponder()}.
 * <p>
 * On such a failure, the individual result fields of {@link android.net.wifi.rtt.RangingResult RangingResult} such as
 * {@link android.net.wifi.rtt.RangingResult#getDistanceMm() RangingResult#getDistanceMm()} are invalid.
 * @apiSince 28
 */

public static final int STATUS_RESPONDER_DOES_NOT_SUPPORT_IEEE80211MC = 2; // 0x2

/**
 * Individual range request status, {@link #getStatus()}. Indicates ranging operation was
 * successful and distance value is valid.
 * @apiSince 28
 */

public static final int STATUS_SUCCESS = 0; // 0x0
}

