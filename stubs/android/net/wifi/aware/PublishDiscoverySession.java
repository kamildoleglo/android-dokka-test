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
 * A class representing a Aware publish session. Created when
 * {@link android.net.wifi.aware.WifiAwareSession#publish(android.net.wifi.aware.PublishConfig,android.net.wifi.aware.DiscoverySessionCallback,android.os.Handler) WifiAwareSession#publish(PublishConfig, DiscoverySessionCallback,
 * android.os.Handler)} is called and a discovery session is created and returned in
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onPublishStarted(android.net.wifi.aware.PublishDiscoverySession) DiscoverySessionCallback#onPublishStarted(PublishDiscoverySession)}. See
 * baseline functionality of all discovery sessions in {@link android.net.wifi.aware.DiscoverySession DiscoverySession}. This
 * object allows updating an existing/running publish discovery session using
 * {@link #updatePublish(android.net.wifi.aware.PublishConfig)}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PublishDiscoverySession extends android.net.wifi.aware.DiscoverySession {

PublishDiscoverySession() { throw new RuntimeException("Stub!"); }

/**
 * Re-configure the currently active publish session. The
 * {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback} is not replaced - the same listener used
 * at creation is still used. The results of the configuration are returned using
 * {@link android.net.wifi.aware.DiscoverySessionCallback DiscoverySessionCallback}:
 * <ul>
 *     <li>{@link android.net.wifi.aware.DiscoverySessionCallback#onSessionConfigUpdated() DiscoverySessionCallback#onSessionConfigUpdated()}: configuration
 *     update succeeded.
 *     <li>{@link android.net.wifi.aware.DiscoverySessionCallback#onSessionConfigFailed() DiscoverySessionCallback#onSessionConfigFailed()}: configuration
 *     update failed. The publish discovery session is still running using its previous
 *     configuration (i.e. update failure does not terminate the session).
 * </ul>
 *
 * @param publishConfig The new discovery publish session configuration ({@link android.net.wifi.aware.PublishConfig PublishConfig}).
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void updatePublish(@androidx.annotation.NonNull android.net.wifi.aware.PublishConfig publishConfig) { throw new RuntimeException("Stub!"); }
}

