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

import android.os.Handler;
import android.net.NetworkSpecifier;

/**
 * This class represents a Wi-Fi Aware session - an attachment to the Wi-Fi Aware service through
 * which the app can execute discovery operations.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiAwareSession implements java.lang.AutoCloseable {

WifiAwareSession() { throw new RuntimeException("Stub!"); }

/**
 * Destroy the Wi-Fi Aware service session and, if no other applications are attached to Aware,
 * also disable Aware. This method destroys all outstanding operations - i.e. all publish and
 * subscribes are terminated, and any outstanding data-links are shut-down. However, it is
 * good practice to destroy these discovery sessions and connections explicitly before a
 * session-wide destroy.
 * <p>
 * An application may re-attach after a destroy using
 * {@link android.net.wifi.aware.WifiAwareManager#attach(android.net.wifi.aware.AttachCallback,android.os.Handler) WifiAwareManager#attach(AttachCallback, Handler)} .
 * @apiSince 26
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @hide */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Issue a request to the Aware service to create a new Aware publish discovery session, using
 * the specified {@code publishConfig} configuration. The results of the publish operation
 * are routed to the callbacks of {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback}:
 * <ul>
 *     <li>
 *     {@link android.net.wifi.aware.DiscoverySessionCallback#onPublishStarted(android.net.wifi.aware.PublishDiscoverySession) DiscoverySessionCallback#onPublishStarted(
 *PublishDiscoverySession)}
 *     is called when the publish session is created and provides a handle to the session.
 *     Further operations on the publish session can be executed on that object.
 *     <li>{@link android.net.wifi.aware.DiscoverySessionCallback#onSessionConfigFailed() DiscoverySessionCallback#onSessionConfigFailed()} is called if the
 *     publish operation failed.
 * </ul>
 * <p>
 * Other results of the publish session operations will also be routed to callbacks
 * on the {@code callback} object. The resulting publish session can be modified using
 * {@link android.net.wifi.aware.PublishDiscoverySession#updatePublish(android.net.wifi.aware.PublishConfig) PublishDiscoverySession#updatePublish(PublishConfig)}.
 * <p>
 *      An application must use the {@link android.net.wifi.aware.DiscoverySession#close() DiscoverySession#close()} to
 *      terminate the publish discovery session once it isn't needed. This will free
 *      resources as well terminate any on-air transmissions.
 * <p>The application must have the {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * permission to start a publish discovery session.
 *
 * @param publishConfig The {@link android.net.wifi.aware.PublishConfig PublishConfig} specifying the
 *            configuration of the requested publish session.
 * This value must never be {@code null}.
 * @param callback A {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback} derived object to be used for
 *                 session event callbacks.
 * This value must never be {@code null}.
 * @param handler The Handler on whose thread to execute the callbacks of the {@code
 * callback} object. If a null is provided then the application's main thread will be used.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void publish(@androidx.annotation.NonNull android.net.wifi.aware.PublishConfig publishConfig, @androidx.annotation.NonNull android.net.wifi.aware.DiscoverySessionCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Issue a request to the Aware service to create a new Aware subscribe discovery session, using
 * the specified {@code subscribeConfig} configuration. The results of the subscribe
 * operation are routed to the callbacks of {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback}:
 * <ul>
 *     <li>
 *  {@link android.net.wifi.aware.DiscoverySessionCallback#onSubscribeStarted(android.net.wifi.aware.SubscribeDiscoverySession) DiscoverySessionCallback#onSubscribeStarted(
 *SubscribeDiscoverySession)}
 *     is called when the subscribe session is created and provides a handle to the session.
 *     Further operations on the subscribe session can be executed on that object.
 *     <li>{@link android.net.wifi.aware.DiscoverySessionCallback#onSessionConfigFailed() DiscoverySessionCallback#onSessionConfigFailed()} is called if the
 *     subscribe operation failed.
 * </ul>
 * <p>
 * Other results of the subscribe session operations will also be routed to callbacks
 * on the {@code callback} object. The resulting subscribe session can be modified using
 * {@link android.net.wifi.aware.SubscribeDiscoverySession#updateSubscribe(android.net.wifi.aware.SubscribeConfig) SubscribeDiscoverySession#updateSubscribe(SubscribeConfig)}.
 * <p>
 *      An application must use the {@link android.net.wifi.aware.DiscoverySession#close() DiscoverySession#close()} to
 *      terminate the subscribe discovery session once it isn't needed. This will free
 *      resources as well terminate any on-air transmissions.
 * <p>The application must have the {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * permission to start a subscribe discovery session.
 *
 * @param subscribeConfig The {@link android.net.wifi.aware.SubscribeConfig SubscribeConfig} specifying the
 *            configuration of the requested subscribe session.
 * This value must never be {@code null}.
 * @param callback A {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback} derived object to be used for
 *                 session event callbacks.
 * This value must never be {@code null}.
 * @param handler The Handler on whose thread to execute the callbacks of the {@code
 * callback} object. If a null is provided then the application's main thread will be used.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void subscribe(@androidx.annotation.NonNull android.net.wifi.aware.SubscribeConfig subscribeConfig, @androidx.annotation.NonNull android.net.wifi.aware.DiscoverySessionCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} for
 * an unencrypted WiFi Aware connection (link) to the specified peer. The
 * {@link android.net.NetworkRequest.Builder#addTransportType(int)} should be set to
 * {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}.
 * <p>
 *     This API is targeted for applications which can obtain the peer MAC address using OOB
 *     (out-of-band) discovery. Aware discovery does not provide the MAC address of the peer -
 *     when using Aware discovery use the alternative network specifier method -
 *     {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder}.
 * <p>
 * To set up an encrypted link use the
 * {@link #createNetworkSpecifierPassphrase(int,byte[],java.lang.String)} API.
 *
 * @param role  The role of this device:
 *              {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_INITIATOR WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_INITIATOR} or
 *              {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_RESPONDER WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_RESPONDER}
 * Value is {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_INITIATOR}, or {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_RESPONDER}
 * @param peer  The MAC address of the peer's Aware discovery interface. On a RESPONDER this
 *              value is used to gate the acceptance of a connection request from only that
 *              peer.
 *
 * This value must never be {@code null}.
 * @return A {@link android.net.NetworkSpecifier NetworkSpecifier} to be used to construct
 * {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} to pass to
 * {@link android.net.ConnectivityManager#requestNetwork(android.net.NetworkRequest,
 * android.net.ConnectivityManager.NetworkCallback)}
 * [or other varieties of that API].
 * @apiSince 26
 */

public android.net.NetworkSpecifier createNetworkSpecifierOpen(int role, @androidx.annotation.NonNull byte[] peer) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} for
 * an encrypted WiFi Aware connection (link) to the specified peer. The
 * {@link android.net.NetworkRequest.Builder#addTransportType(int)} should be set to
 * {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}.
 * <p>
 *     This API is targeted for applications which can obtain the peer MAC address using OOB
 *     (out-of-band) discovery. Aware discovery does not provide the MAC address of the peer -
 *     when using Aware discovery use the alternative network specifier method -
 *     {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder}.
 *
 * @param role  The role of this device:
 *              {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_INITIATOR WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_INITIATOR} or
 *              {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_RESPONDER WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_RESPONDER}
 * Value is {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_INITIATOR}, or {@link android.net.wifi.aware.WifiAwareManager#WIFI_AWARE_DATA_PATH_ROLE_RESPONDER}
 * @param peer  The MAC address of the peer's Aware discovery interface. On a RESPONDER this
 *              value is used to gate the acceptance of a connection request from only that
 *              peer.
 * This value must never be {@code null}.
 * @param passphrase The passphrase to be used to encrypt the link. The PMK is generated from
 *                   the passphrase. Use {@link #createNetworkSpecifierOpen(int,byte[])} to
 *                   specify an open (unencrypted) link.
 *
 * This value must never be {@code null}.
 * @return A {@link android.net.NetworkSpecifier NetworkSpecifier} to be used to construct
 * {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} to pass to
 * {@link android.net.ConnectivityManager#requestNetwork(android.net.NetworkRequest,
 * android.net.ConnectivityManager.NetworkCallback)}
 * [or other varieties of that API].
 * @apiSince 26
 */

public android.net.NetworkSpecifier createNetworkSpecifierPassphrase(int role, @androidx.annotation.NonNull byte[] peer, @androidx.annotation.NonNull java.lang.String passphrase) { throw new RuntimeException("Stub!"); }
}

