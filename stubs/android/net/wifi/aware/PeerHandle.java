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
 * Opaque object used to represent a Wi-Fi Aware peer. Obtained from discovery sessions in
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onServiceDiscovered(android.net.wifi.aware.PeerHandle,byte[],java.util.List) DiscoverySessionCallback#onServiceDiscovered(PeerHandle, byte[], java.util.List)} or
 * received messages in {@link android.net.wifi.aware.DiscoverySessionCallback#onMessageReceived(android.net.wifi.aware.PeerHandle,byte[]) DiscoverySessionCallback#onMessageReceived(PeerHandle, byte[])}, and
 * used when sending messages e,g, {@link android.net.wifi.aware.DiscoverySession#sendMessage(android.net.wifi.aware.PeerHandle,int,byte[]) DiscoverySession#sendMessage(PeerHandle, int, byte[])},
 * or when configuring a network link to a peer, e.g.
 * {@link android.net.wifi.aware.DiscoverySession#createNetworkSpecifierOpen(android.net.wifi.aware.PeerHandle) DiscoverySession#createNetworkSpecifierOpen(PeerHandle)} or
 * {@link android.net.wifi.aware.DiscoverySession#createNetworkSpecifierPassphrase(android.net.wifi.aware.PeerHandle,java.lang.String) DiscoverySession#createNetworkSpecifierPassphrase(PeerHandle, String)}.
 * <p>
 * Note that while a {@code PeerHandle} can be used to track a particular peer (i.e. you can compare
 * the values received from subsequent messages) - it is good practice not to rely on it. Instead
 * use an application level peer identifier encoded in the message,
 * {@link android.net.wifi.aware.DiscoverySession#sendMessage(android.net.wifi.aware.PeerHandle,int,byte[]) DiscoverySession#sendMessage(PeerHandle, int, byte[])}, and/or in the Publish
 * configuration's service-specific information field,
 * {@link android.net.wifi.aware.PublishConfig.Builder#setServiceSpecificInfo(byte[]) PublishConfig.Builder#setServiceSpecificInfo(byte[])}, or match filter,
 * {@link android.net.wifi.aware.PublishConfig.Builder#setMatchFilter(java.util.List) PublishConfig.Builder#setMatchFilter(java.util.List)}.
 * <p>A parcelable handle object is available with {@link android.net.wifi.aware.ParcelablePeerHandle ParcelablePeerHandle}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PeerHandle {

PeerHandle() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

