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
 * A class representing a Aware subscribe session. Created when
 * {@link android.net.wifi.aware.WifiAwareSession#subscribe(android.net.wifi.aware.SubscribeConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#subscribe(SubscribeConfig,
 * DiscoverySessionCallback, android.os.Handler)}
 * is called and a discovery session is created and returned in
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onSubscribeStarted(android.net.wifi.aware.SubscribeDiscoverySession) DiscoverySessionCallback#onSubscribeStarted(SubscribeDiscoverySession)}.
 * See baseline functionality of all discovery sessions in {@link android.net.wifi.aware.DiscoverySession DiscoverySession}.
 * This object allows updating an existing/running subscribe discovery session using
 * {@link #updateSubscribe(android.net.wifi.aware.SubscribeConfig)}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SubscribeDiscoverySession extends android.net.wifi.aware.DiscoverySession {

SubscribeDiscoverySession() { throw new RuntimeException("Stub!"); }

/**
 * Re-configure the currently active subscribe session. The
 * {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback} is not replaced - the same listener used
 * at creation is still used. The results of the configuration are returned using
 * {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback}:
 * <ul>
 *     <li>{@link android.net.wifi.aware.DiscoverySessionCallback#onSessionConfigUpdated() DiscoverySessionCallback#onSessionConfigUpdated()}: configuration
 *     update succeeded.
 *     <li>{@link android.net.wifi.aware.DiscoverySessionCallback#onSessionConfigFailed() DiscoverySessionCallback#onSessionConfigFailed()}: configuration
 *     update failed. The subscribe discovery session is still running using its previous
 *     configuration (i.e. update failure does not terminate the session).
 * </ul>
 *
 * @param subscribeConfig The new discovery subscribe session configuration
 *                        ({@link android.net.wifi.aware.SubscribeConfig SubscribeConfig}).
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void updateSubscribe(@androidx.annotation.NonNull android.net.wifi.aware.SubscribeConfig subscribeConfig) { throw new RuntimeException("Stub!"); }
}

