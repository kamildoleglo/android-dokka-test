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
 * Base class for Aware session events callbacks. Should be extended by
 * applications wanting notifications. The callbacks are set when a
 * publish or subscribe session is created using
 * {@link android.net.wifi.aware.WifiAwareSession#publish(android.net.wifi.aware.PublishConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#publish(PublishConfig, DiscoverySessionCallback,
 * android.os.Handler)} or
 * {@link android.net.wifi.aware.WifiAwareSession#subscribe(android.net.wifi.aware.SubscribeConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#subscribe(SubscribeConfig, DiscoverySessionCallback,
 * android.os.Handler)}.
 * <p>
 * A single callback is set at session creation - it cannot be replaced.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DiscoverySessionCallback {

public DiscoverySessionCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when a publish operation is started successfully in response to a
 * {@link android.net.wifi.aware.WifiAwareSession#publish(android.net.wifi.aware.PublishConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#publish(PublishConfig, DiscoverySessionCallback,
 * android.os.Handler)} operation.
 *
 * @param session The {@link android.net.wifi.aware.PublishDiscoverySession PublishDiscoverySession} used to control the
 *            discovery session.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onPublishStarted(@androidx.annotation.NonNull android.net.wifi.aware.PublishDiscoverySession session) { throw new RuntimeException("Stub!"); }

/**
 * Called when a subscribe operation is started successfully in response to a
 * {@link android.net.wifi.aware.WifiAwareSession#subscribe(android.net.wifi.aware.SubscribeConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#subscribe(SubscribeConfig, DiscoverySessionCallback,
 * android.os.Handler)} operation.
 *
 * @param session The {@link android.net.wifi.aware.SubscribeDiscoverySession SubscribeDiscoverySession} used to control the
 *            discovery session.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onSubscribeStarted(@androidx.annotation.NonNull android.net.wifi.aware.SubscribeDiscoverySession session) { throw new RuntimeException("Stub!"); }

/**
 * Called when a publish or subscribe discovery session configuration update request
 * succeeds. Called in response to
 * {@link android.net.wifi.aware.PublishDiscoverySession#updatePublish(android.net.wifi.aware.PublishConfig) PublishDiscoverySession#updatePublish(PublishConfig)} or
 * {@link android.net.wifi.aware.SubscribeDiscoverySession#updateSubscribe(android.net.wifi.aware.SubscribeConfig) SubscribeDiscoverySession#updateSubscribe(SubscribeConfig)}.
 * @apiSince 26
 */

public void onSessionConfigUpdated() { throw new RuntimeException("Stub!"); }

/**
 * Called when a publish or subscribe discovery session cannot be created:
 * {@link android.net.wifi.aware.WifiAwareSession#publish(android.net.wifi.aware.PublishConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#publish(PublishConfig, DiscoverySessionCallback,
 * android.os.Handler)} or
 * {@link android.net.wifi.aware.WifiAwareSession#subscribe(android.net.wifi.aware.SubscribeConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#subscribe(SubscribeConfig, DiscoverySessionCallback,
 * android.os.Handler)}, or when a configuration update fails:
 * {@link android.net.wifi.aware.PublishDiscoverySession#updatePublish(android.net.wifi.aware.PublishConfig) PublishDiscoverySession#updatePublish(PublishConfig)} or
 * {@link android.net.wifi.aware.SubscribeDiscoverySession#updateSubscribe(android.net.wifi.aware.SubscribeConfig) SubscribeDiscoverySession#updateSubscribe(SubscribeConfig)}.
 * <p>
 *     For discovery session updates failure leaves the session running with its previous
 *     configuration - the discovery session is not terminated.
 * @apiSince 26
 */

public void onSessionConfigFailed() { throw new RuntimeException("Stub!"); }

/**
 * Called when a discovery session (publish or subscribe) terminates. Termination may be due
 * to user-request (either directly through {@link android.net.wifi.aware.DiscoverySession#close() DiscoverySession#close()} or
 * application-specified expiration, e.g. {@link android.net.wifi.aware.PublishConfig.Builder#setTtlSec(int) PublishConfig.Builder#setTtlSec(int)}
 * or {@link android.net.wifi.aware.SubscribeConfig.Builder#setTtlSec(int) SubscribeConfig.Builder#setTtlSec(int)}).
 * @apiSince 26
 */

public void onSessionTerminated() { throw new RuntimeException("Stub!"); }

/**
 * Called when a discovery (publish or subscribe) operation results in a
 * service discovery.
 * <p>
 * Note that this method and
 * {@link #onServiceDiscoveredWithinRange(android.net.wifi.aware.PeerHandle,byte[],java.util.List,int)} may be called
 * multiple times per service discovery.
 *
 * @param peerHandle An opaque handle to the peer matching our discovery operation.
 * @param serviceSpecificInfo The service specific information (arbitrary
 *            byte array) provided by the peer as part of its discovery
 *            configuration.
 * @param matchFilter The filter which resulted in this service discovery. For
 * {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_UNSOLICITED PublishConfig#PUBLISH_TYPE_UNSOLICITED},
 * {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE} discovery sessions this is the publisher's
 *                    match filter. For {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_SOLICITED PublishConfig#PUBLISH_TYPE_SOLICITED},
 *                    {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE} discovery sessions this
 *                    is the subscriber's match filter.
 * @apiSince 26
 */

public void onServiceDiscovered(android.net.wifi.aware.PeerHandle peerHandle, byte[] serviceSpecificInfo, java.util.List<byte[]> matchFilter) { throw new RuntimeException("Stub!"); }

/**
 * Called when a discovery (publish or subscribe) operation results in a
 * service discovery. Called when a Subscribe service was configured with a range requirement
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setMinDistanceMm(int) SubscribeConfig.Builder#setMinDistanceMm(int)} and/or
 * {@link android.net.wifi.aware.SubscribeConfig.Builder#setMaxDistanceMm(int) SubscribeConfig.Builder#setMaxDistanceMm(int)} and the Publish service was configured
 * with {@link android.net.wifi.aware.PublishConfig.Builder#setRangingEnabled(boolean) PublishConfig.Builder#setRangingEnabled(boolean)}.
 * <p>
 * If either Publisher or Subscriber does not enable Ranging, or if Ranging is temporarily
 * disabled by the underlying device, service discovery proceeds without ranging and the
 * {@link #onServiceDiscovered(android.net.wifi.aware.PeerHandle,byte[],java.util.List)} is called.
 * <p>
 * Note that this method and {@link #onServiceDiscovered(android.net.wifi.aware.PeerHandle,byte[],java.util.List)} may be
 * called multiple times per service discovery.
 *
 * @param peerHandle An opaque handle to the peer matching our discovery operation.
 * @param serviceSpecificInfo The service specific information (arbitrary
 *            byte array) provided by the peer as part of its discovery
 *            configuration.
 * @param matchFilter The filter which resulted in this service discovery. For
 * {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_UNSOLICITED PublishConfig#PUBLISH_TYPE_UNSOLICITED},
 * {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE SubscribeConfig#SUBSCRIBE_TYPE_PASSIVE} discovery sessions this is the publisher's
 *                    match filter. For {@link android.net.wifi.aware.PublishConfig#PUBLISH_TYPE_SOLICITED PublishConfig#PUBLISH_TYPE_SOLICITED},
 *                    {@link android.net.wifi.aware.SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE SubscribeConfig#SUBSCRIBE_TYPE_ACTIVE} discovery sessions this
 *                    is the subscriber's match filter.
 * @param distanceMm The measured distance to the Publisher in mm. Note: the measured distance
 *                   may be negative for very close devices.
 * @apiSince 28
 */

public void onServiceDiscoveredWithinRange(android.net.wifi.aware.PeerHandle peerHandle, byte[] serviceSpecificInfo, java.util.List<byte[]> matchFilter, int distanceMm) { throw new RuntimeException("Stub!"); }

/**
 * Called in response to
 * {@link android.net.wifi.aware.DiscoverySession#sendMessage(android.net.wifi.aware.PeerHandle,int,byte[]) DiscoverySession#sendMessage(PeerHandle, int, byte[])}
 * when a message is transmitted successfully - i.e. when it was received successfully by the
 * peer (corresponds to an ACK being received).
 * <p>
 * Note that either this callback or
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onMessageSendFailed(int) DiscoverySessionCallback#onMessageSendFailed(int)} will be
 * received - never both.
 *
 * @param messageId The arbitrary message ID specified when sending the message.
 * @apiSince 26
 */

public void onMessageSendSucceeded(int messageId) { throw new RuntimeException("Stub!"); }

/**
 * Called when message transmission initiated with
 * {@link android.net.wifi.aware.DiscoverySession#sendMessage(android.net.wifi.aware.PeerHandle,int,byte[]) DiscoverySession#sendMessage(PeerHandle, int, byte[])} fails. E.g. when no ACK is
 * received from the peer.
 * <p>
 * Note that either this callback or
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onMessageSendSucceeded(int) DiscoverySessionCallback#onMessageSendSucceeded(int)} will be received
 * - never both.
 *
 * @param messageId The arbitrary message ID specified when sending the message.
 * @apiSince 26
 */

public void onMessageSendFailed(int messageId) { throw new RuntimeException("Stub!"); }

/**
 * Called when a message is received from a discovery session peer - in response to the
 * peer's {@link android.net.wifi.aware.DiscoverySession#sendMessage(android.net.wifi.aware.PeerHandle,int,byte[]) DiscoverySession#sendMessage(PeerHandle, int, byte[])}.
 *
 * @param peerHandle An opaque handle to the peer matching our discovery operation.
 * @param message A byte array containing the message.
 * @apiSince 26
 */

public void onMessageReceived(android.net.wifi.aware.PeerHandle peerHandle, byte[] message) { throw new RuntimeException("Stub!"); }
}

