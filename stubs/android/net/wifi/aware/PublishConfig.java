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


/**
 * Defines the configuration of a Aware publish session. Built using
 * {@link android.net.wifi.aware.PublishConfig.Builder PublishConfig.Builder}. A publish session is created using
 * {@link android.net.wifi.aware.WifiAwareSession#publish(android.net.wifi.aware.PublishConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#publish(PublishConfig, DiscoverySessionCallback,
 * android.os.Handler)} or updated using
 * {@link android.net.wifi.aware.PublishDiscoverySession#updatePublish(android.net.wifi.aware.PublishConfig) PublishDiscoverySession#updatePublish(PublishConfig)}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PublishConfig implements android.os.Parcelable {

PublishConfig() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.aware.PublishConfig> CREATOR;
static { CREATOR = null; }

/**
 * Defines a solicited publish session - a publish session which is silent, waiting for a
 * matching active subscribe session - and responding to it in unicast. A
 * solicited publish session is paired with an active subscribe session
 * {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE}. Configuration is done using
 * {@link android.net.wifi.aware.PublishConfig.Builder#setPublishType(int) PublishConfig.Builder#setPublishType(int)}.
 * @apiSince 26
 */

public static final int PUBLISH_TYPE_SOLICITED = 1; // 0x1

/**
 * Defines an unsolicited publish session - a publish session where the publisher is
 * advertising itself by broadcasting on-the-air. An unsolicited publish session is paired
 * with an passive subscribe session {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE}.
 * Configuration is done using {@link android.net.wifi.aware.PublishConfig.Builder#setPublishType(int) PublishConfig.Builder#setPublishType(int)}.
 * @apiSince 26
 */

public static final int PUBLISH_TYPE_UNSOLICITED = 0; // 0x0
/**
 * Builder used to build {@link android.net.wifi.aware.PublishConfig PublishConfig} objects.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Specify the service name of the publish session. The actual on-air
 * value is a 6 byte hashed representation of this string.
 * <p>
 * The Service Name is a UTF-8 encoded string from 1 to 255 bytes in length.
 * The only acceptable single-byte UTF-8 symbols for a Service Name are alphanumeric
 * values (A-Z, a-z, 0-9), the hyphen ('-'), and the period ('.'). All valid multi-byte
 * UTF-8 characters are acceptable in a Service Name.
 * <p>
 * Must be called - an empty ServiceName is not valid.
 *
 * @param serviceName The service name for the publish session.
 *
 * This value must never be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.PublishConfig.Builder setServiceName(@androidx.annotation.NonNull java.lang.String serviceName) { throw new RuntimeException("Stub!"); }

/**
 * Specify service specific information for the publish session. This is
 * a free-form byte array available to the application to send
 * additional information as part of the discovery operation - it
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

public android.net.wifi.aware.PublishConfig.Builder setServiceSpecificInfo(@androidx.annotation.Nullable byte[] serviceSpecificInfo) { throw new RuntimeException("Stub!"); }

/**
 * The match filter for a publish session. Used to determine whether a service
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

public android.net.wifi.aware.PublishConfig.Builder setMatchFilter(@androidx.annotation.Nullable java.util.List<byte[]> matchFilter) { throw new RuntimeException("Stub!"); }

/**
 * Specify the type of the publish session: solicited (aka active - publish
 * packets are transmitted over-the-air), or unsolicited (aka passive -
 * no publish packets are transmitted, a match is made against an active
 * subscribe session whose packets are transmitted over-the-air).
 *
 * @param publishType Publish session type:
 *            {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_SOLICITED PublishConfig#PUBLISH_TYPE_SOLICITED} or
 *            {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_UNSOLICITED PublishConfig#PUBLISH_TYPE_UNSOLICITED} (the default).
 *
 * Value is {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_UNSOLICITED}, or {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_SOLICITED}
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.PublishConfig.Builder setPublishType(int publishType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the time interval (in seconds) an unsolicited (
 * {@link android.net.wifi.aware.PublishConfig.Builder#setPublishType(int) PublishConfig.Builder#setPublishType(int)}) publish session
 * will be alive - broadcasting a packet. When the TTL is reached
 * an event will be generated for
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onSessionTerminated() DiscoverySessionCallback#onSessionTerminated()} [unless
 * {@link #setTerminateNotificationEnabled(boolean)} disables the callback].
 * <p>
 *     Optional. 0 by default - indicating the session doesn't terminate on its own.
 *     Session will be terminated when {@link android.net.wifi.aware.DiscoverySession#close() DiscoverySession#close()} is
 *     called.
 *
 * @param ttlSec Lifetime of a publish session in seconds.
 *
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.PublishConfig.Builder setTtlSec(int ttlSec) { throw new RuntimeException("Stub!"); }

/**
 * Configure whether a publish terminate notification
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onSessionTerminated() DiscoverySessionCallback#onSessionTerminated()} is reported
 * back to the callback.
 *
 * @param enable If true the terminate callback will be called when the
 *            publish is terminated. Otherwise it will not be called.
 *
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 26
 */

public android.net.wifi.aware.PublishConfig.Builder setTerminateNotificationEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Configure whether the publish discovery session supports ranging and allows peers to
 * measure distance to it. This API is used in conjunction with
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setMinDistanceMm(int) SubscribeConfig.Builder#setMinDistanceMm(int)} and
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setMaxDistanceMm(int) SubscribeConfig.Builder#setMaxDistanceMm(int)} to specify a minimum and/or
 * maximum distance at which discovery will be triggered.
 * <p>
 * Optional. Disabled by default - i.e. any peer attempt to measure distance to this device
 * will be refused and discovery will proceed without ranging constraints.
 * <p>
 * The device must support Wi-Fi RTT for this feature to be used. Feature support is checked
 * as described in {@link android.net.wifi.rtt}.
 *
 * @param enable If true, ranging is supported on request of the peer.
 *
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 28
 */

public android.net.wifi.aware.PublishConfig.Builder setRangingEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.net.wifi.aware.PublishConfig PublishConfig} given the current requests made on the
 * builder.
 * @apiSince 26
 */

public android.net.wifi.aware.PublishConfig build() { throw new RuntimeException("Stub!"); }
}

}

