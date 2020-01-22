/*
 * Copyright (C) 2016 The Android Open Source Project
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

import java.util.List;

/**
 * Defines the configuration of a Aware subscribe session. Built using
 * {@link android.net.wifi.aware.SubscribeConfig.Builder SubscribeConfig.Builder}. Subscribe is done using
 * {@link android.net.wifi.aware.WifiAwareSession#subscribe(android.net.wifi.aware.SubscribeConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#subscribe(SubscribeConfig, DiscoverySessionCallback,
 * android.os.Handler)} or
 * {@link android.net.wifi.aware.SubscribeDiscoverySession#updateSubscribe(android.net.wifi.aware.SubscribeConfig) SubscribeDiscoverySession#updateSubscribe(SubscribeConfig)}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SubscribeConfig implements android.os.Parcelable {

SubscribeConfig() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.aware.SubscribeConfig> CREATOR;
static { CREATOR = null; }

/**
 * Defines an active subscribe session - a subscribe session where
 * subscribe packets are transmitted over-the-air. Configuration is done
 * using {@link android.net.wifi.aware.SubscribeConfig.Builder#setSubscribeType(int) SubscribeConfig.Builder#setSubscribeType(int)}.
 * @apiSince 26
 */

public static final int SUBSCRIBE_TYPE_ACTIVE = 1; // 0x1

/**
 * Defines a passive subscribe session - a subscribe session where
 * subscribe packets are not transmitted over-the-air and the device listens
 * and matches to transmitted publish packets. Configuration is done using
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setSubscribeType(int) SubscribeConfig.Builder#setSubscribeType(int)}.
 * @apiSince 26
 */

public static final int SUBSCRIBE_TYPE_PASSIVE = 0; // 0x0
/**
 * Builder used to build {@link android.net.wifi.aware.SubscribeConfig SubscribeConfig} objects.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Specify the service name of the subscribe session. The actual on-air
 * value is a 6 byte hashed representation of this string.
 * <p>
 * The Service Name is a UTF-8 encoded string from 1 to 255 bytes in length.
 * The only acceptable single-byte UTF-8 symbols for a Service Name are alphanumeric
 * values (A-Z, a-z, 0-9), the hyphen ('-'), and the period ('.'). All valid multi-byte
 * UTF-8 characters are acceptable in a Service Name.
 * <p>
 * Must be called - an empty ServiceName is not valid.
 *
 * @param serviceName The service name for the subscribe session.
 *
 * This value must never be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.SubscribeConfig.Builder setServiceName(@androidx.annotation.NonNull java.lang.String serviceName) { throw new RuntimeException("Stub!"); }

/**
 * Specify service specific information for the subscribe session. This is
 * a free-form byte array available to the application to send
 * additional information as part of the discovery operation - i.e. it
 * will not be used to determine whether a publish/subscribe match
 * occurs.
 * <p>
 *     Optional. Empty by default.
 *
 * @param serviceSpecificInfo A byte-array for the service-specific
 *            information field.
 *
 * This value may be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.SubscribeConfig.Builder setServiceSpecificInfo(@androidx.annotation.Nullable byte[] serviceSpecificInfo) { throw new RuntimeException("Stub!"); }

/**
 * The match filter for a subscribe session. Used to determine whether a service
 * discovery occurred - in addition to relying on the service name.
 * <p>
 *     Optional. Empty by default.
 *
 * @param matchFilter A list of match filter entries (each of which is an arbitrary byte
 *                    array).
 *
 * This value may be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.SubscribeConfig.Builder setMatchFilter(@androidx.annotation.Nullable java.util.List<byte[]> matchFilter) { throw new RuntimeException("Stub!"); }

/**
 * Sets the type of the subscribe session: active (subscribe packets are
 * transmitted over-the-air), or passive (no subscribe packets are
 * transmitted, a match is made against a solicited/active publish
 * session whose packets are transmitted over-the-air).
 *
 * @param subscribeType Subscribe session type:
 *            {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE} or
 *            {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE}.
 *
 * Value is {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE}, or {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE}
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.SubscribeConfig.Builder setSubscribeType(int subscribeType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the time interval (in seconds) an active (
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setSubscribeType(int) SubscribeConfig.Builder#setSubscribeType(int)}) subscribe session
 * will be alive - i.e. broadcasting a packet. When the TTL is reached
 * an event will be generated for
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onSessionTerminated() DiscoverySessionCallback#onSessionTerminated()}.
 * <p>
 *     Optional. 0 by default - indicating the session doesn't terminate on its own.
 *     Session will be terminated when {@link android.net.wifi.aware.DiscoverySession#close() DiscoverySession#close()} is
 *     called.
 *
 * @param ttlSec Lifetime of a subscribe session in seconds.
 *
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.SubscribeConfig.Builder setTtlSec(int ttlSec) { throw new RuntimeException("Stub!"); }

/**
 * Configure whether a subscribe terminate notification
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onSessionTerminated() DiscoverySessionCallback#onSessionTerminated()} is reported
 * back to the callback.
 *
 * @param enable If true the terminate callback will be called when the
 *            subscribe is terminated. Otherwise it will not be called.
 *
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.SubscribeConfig.Builder setTerminateNotificationEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Configure the minimum distance to a discovered publisher at which to trigger a discovery
 * notification. I.e. discovery will be triggered if we've found a matching publisher
 * (based on the other criteria in this configuration) <b>and</b> the distance to the
 * publisher is larger than the value specified in this API. Can be used in conjunction with
 * {@link #setMaxDistanceMm(int)} to specify a geofence, i.e. discovery with min <=
 * distance <= max.
 * <p>
 * For ranging to be used in discovery it must also be enabled on the publisher using
 * {@link android.net.wifi.aware.PublishConfig.Builder#setRangingEnabled(boolean) PublishConfig.Builder#setRangingEnabled(boolean)}. However, ranging may
 * not be available or enabled on the publisher or may be temporarily disabled on either
 * subscriber or publisher - in such cases discovery will proceed without ranging.
 * <p>
 * When ranging is enabled and available on both publisher and subscriber and a service
 * is discovered based on geofence constraints the
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onServiceDiscoveredWithinRange(android.net.wifi.aware.PeerHandle,byte[],java.util.List,int) DiscoverySessionCallback#onServiceDiscoveredWithinRange(PeerHandle, byte[], List, int)}
 * is called, otherwise the
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onServiceDiscovered(android.net.wifi.aware.PeerHandle,byte[],java.util.List) DiscoverySessionCallback#onServiceDiscovered(PeerHandle, byte[], List)}
 * is called.
 * <p>
 * The device must support Wi-Fi RTT for this feature to be used. Feature support is checked
 * as described in {@link android.net.wifi.rtt}.
 *
 * @param minDistanceMm Minimum distance, in mm, to the publisher above which to trigger
 *                      discovery.
 *
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 28
 */

public android.net.wifi.aware.SubscribeConfig.Builder setMinDistanceMm(int minDistanceMm) { throw new RuntimeException("Stub!"); }

/**
 * Configure the maximum distance to a discovered publisher at which to trigger a discovery
 * notification. I.e. discovery will be triggered if we've found a matching publisher
 * (based on the other criteria in this configuration) <b>and</b> the distance to the
 * publisher is smaller than the value specified in this API. Can be used in conjunction
 * with {@link #setMinDistanceMm(int)} to specify a geofence, i.e. discovery with min <=
 * distance <= max.
 * <p>
 * For ranging to be used in discovery it must also be enabled on the publisher using
 * {@link android.net.wifi.aware.PublishConfig.Builder#setRangingEnabled(boolean) PublishConfig.Builder#setRangingEnabled(boolean)}. However, ranging may
 * not be available or enabled on the publisher or may be temporarily disabled on either
 * subscriber or publisher - in such cases discovery will proceed without ranging.
 * <p>
 * When ranging is enabled and available on both publisher and subscriber and a service
 * is discovered based on geofence constraints the
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onServiceDiscoveredWithinRange(android.net.wifi.aware.PeerHandle,byte[],java.util.List,int) DiscoverySessionCallback#onServiceDiscoveredWithinRange(PeerHandle, byte[], List, int)}
 * is called, otherwise the
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onServiceDiscovered(android.net.wifi.aware.PeerHandle,byte[],java.util.List) DiscoverySessionCallback#onServiceDiscovered(PeerHandle, byte[], List)}
 * is called.
 * <p>
 * The device must support Wi-Fi RTT for this feature to be used. Feature support is checked
 * as described in {@link android.net.wifi.rtt}.
 *
 * @param maxDistanceMm Maximum distance, in mm, to the publisher below which to trigger
 *                      discovery.
 *
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 28
 */

public android.net.wifi.aware.SubscribeConfig.Builder setMaxDistanceMm(int maxDistanceMm) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.net.wifi.aware.SubscribeConfig SubscribeConfig} given the current requests made on the
 * builder.
 * @apiSince 26
 */

public android.net.wifi.aware.SubscribeConfig build() { throw new RuntimeException("Stub!"); }
}

}

