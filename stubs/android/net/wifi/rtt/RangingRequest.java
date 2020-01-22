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

import android.net.wifi.ScanResult;
import java.util.List;
import android.net.wifi.aware.IdentityChangedListener;
import android.os.Handler;
import android.net.wifi.aware.AttachCallback;
import android.net.wifi.aware.WifiAwareManager;
import android.net.wifi.aware.DiscoverySessionCallback;
import android.net.wifi.aware.PeerHandle;

/**
 * Defines the ranging request to other devices. The ranging request is built using
 * {@link android.net.wifi.rtt.RangingRequest.Builder RangingRequest.Builder}.
 * A ranging request is executed using
 * {@link android.net.wifi.rtt.WifiRttManager#startRanging(android.net.wifi.rtt.RangingRequest,java.util.concurrent.Executor,android.net.wifi.rtt.RangingResultCallback) WifiRttManager#startRanging(RangingRequest, java.util.concurrent.Executor, RangingResultCallback)}.
 * <p>
 * The ranging request is a batch request - specifying a set of devices (specified using
 * {@link android.net.wifi.rtt.RangingRequest.Builder#addAccessPoint(android.net.wifi.ScanResult) RangingRequest.Builder#addAccessPoint(ScanResult)} and
 * {@link android.net.wifi.rtt.RangingRequest.Builder#addAccessPoints(java.util.List) RangingRequest.Builder#addAccessPoints(List)}).
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RangingRequest implements android.os.Parcelable {

private RangingRequest() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of peers to range which can be specified in a single {@code
 * RangingRequest}. The limit applies no matter how the peers are added to the request, e.g.
 * through {@link android.net.wifi.rtt.RangingRequest.Builder#addAccessPoint(android.net.wifi.ScanResult) RangingRequest.Builder#addAccessPoint(ScanResult)} or
 * {@link android.net.wifi.rtt.RangingRequest.Builder#addAccessPoints(java.util.List) RangingRequest.Builder#addAccessPoints(List)}.
 *
 * @return Maximum number of peers.
 * @apiSince 28
 */

public static int getMaxPeers() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @hide */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param o This value may be {@code null}.
 * @apiSince 28
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.rtt.RangingRequest> CREATOR;
static { CREATOR = null; }
/**
 * Builder class used to construct {@link android.net.wifi.rtt.RangingRequest RangingRequest} objects.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Add the device specified by the {@link android.net.wifi.ScanResult ScanResult} to the list of devices with
 * which to measure range. The total number of peers added to a request cannot exceed the
 * limit specified by {@link #getMaxPeers()}.
 * <p>
 * Ranging may not be supported if the Access Point does not support IEEE 802.11mc. Use
 * {@link android.net.wifi.ScanResult#is80211mcResponder() ScanResult#is80211mcResponder()} to verify the Access Point's capabilities. If
 * not supported the result status will be
 * {@link android.net.wifi.rtt.RangingResult#STATUS_RESPONDER_DOES_NOT_SUPPORT_IEEE80211MC RangingResult#STATUS_RESPONDER_DOES_NOT_SUPPORT_IEEE80211MC}.
 *
 * @param apInfo Information of an Access Point (AP) obtained in a Scan Result.
 * This value must never be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 28
 */

public android.net.wifi.rtt.RangingRequest.Builder addAccessPoint(@androidx.annotation.NonNull android.net.wifi.ScanResult apInfo) { throw new RuntimeException("Stub!"); }

/**
 * Add the devices specified by the {@link android.net.wifi.ScanResult ScanResult}s to the list of devices with
 * which to measure range. The total number of peers added to a request cannot exceed the
 * limit specified by {@link #getMaxPeers()}.
 * <p>
 * Ranging may not be supported if the Access Point does not support IEEE 802.11mc. Use
 * {@link android.net.wifi.ScanResult#is80211mcResponder() ScanResult#is80211mcResponder()} to verify the Access Point's capabilities. If
 * not supported the result status will be
 * {@link android.net.wifi.rtt.RangingResult#STATUS_RESPONDER_DOES_NOT_SUPPORT_IEEE80211MC RangingResult#STATUS_RESPONDER_DOES_NOT_SUPPORT_IEEE80211MC}.
 *
 * @param apInfos Information of an Access Points (APs) obtained in a Scan Result.
 * This value must never be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 28
 */

public android.net.wifi.rtt.RangingRequest.Builder addAccessPoints(@androidx.annotation.NonNull java.util.List<android.net.wifi.ScanResult> apInfos) { throw new RuntimeException("Stub!"); }

/**
 * Add the device specified by the {@code peerMacAddress} to the list of devices with
 * which to measure range.
 * <p>
 * The MAC address may be obtained out-of-band from a peer Wi-Fi Aware device. A Wi-Fi
 * Aware device may obtain its MAC address using the {@link android.net.wifi.aware.IdentityChangedListener IdentityChangedListener}
 * provided to
 * {@link android.net.wifi.aware.WifiAwareManager#attach(android.net.wifi.aware.AttachCallback,android.net.wifi.aware.IdentityChangedListener,android.os.Handler) WifiAwareManager#attach(AttachCallback, IdentityChangedListener, Handler)}.
 * <p>
 * Note: in order to use this API the device must support Wi-Fi Aware
 * {@link android.net.wifi.aware}. The peer device which is being ranged to must be
 * configured to publish a service (with any name) with:
 * <li>Type {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_UNSOLICITED}.
 * <li>Ranging enabled
 * {@link android.net.wifi.aware.PublishConfig.Builder#setRangingEnabled(boolean)}.
 *
 * @param peerMacAddress The MAC address of the Wi-Fi Aware peer.
 * This value must never be {@code null}.
 * @return The builder, to facilitate chaining {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 28
 */

public android.net.wifi.rtt.RangingRequest.Builder addWifiAwarePeer(@androidx.annotation.NonNull android.net.MacAddress peerMacAddress) { throw new RuntimeException("Stub!"); }

/**
 * Add a device specified by a {@link android.net.wifi.aware.PeerHandle PeerHandle} to the list of devices with which to
 * measure range.
 * <p>
 * The {@link android.net.wifi.aware.PeerHandle PeerHandle} may be obtained as part of the Wi-Fi Aware discovery process. E.g.
 * using {@link android.net.wifi.aware.DiscoverySessionCallback#onServiceDiscovered(android.net.wifi.aware.PeerHandle,byte[],java.util.List) DiscoverySessionCallback#onServiceDiscovered(PeerHandle, byte[], List)}.
 * <p>
 * Note: in order to use this API the device must support Wi-Fi Aware
 * {@link android.net.wifi.aware}. The peer device which is being ranged to must be
 * configured to publish a service (with any name) with:
 * <li>Type {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_UNSOLICITED}.
 * <li>Ranging enabled
 * {@link android.net.wifi.aware.PublishConfig.Builder#setRangingEnabled(boolean)}.
 *
 * @param peerHandle The peer handler of the peer Wi-Fi Aware device.
 * This value must never be {@code null}.
 * @return The builder, to facilitate chaining {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 28
 */

public android.net.wifi.rtt.RangingRequest.Builder addWifiAwarePeer(@androidx.annotation.NonNull android.net.wifi.aware.PeerHandle peerHandle) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.net.wifi.rtt.RangingRequest RangingRequest} given the current configurations made on the
 * builder.
 * @apiSince 28
 */

public android.net.wifi.rtt.RangingRequest build() { throw new RuntimeException("Stub!"); }
}

}

