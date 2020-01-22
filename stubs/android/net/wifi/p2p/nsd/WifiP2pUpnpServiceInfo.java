/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.net.wifi.p2p.nsd;

import java.util.UUID;

/**
 * A class for storing Upnp service information that is advertised
 * over a Wi-Fi peer-to-peer setup.
 *
 * {@see android.net.wifi.p2p.WifiP2pManager#addLocalService}
 * {@see android.net.wifi.p2p.WifiP2pManager#removeLocalService}
 * {@see WifiP2pServiceInfo}
 * {@see WifiP2pDnsSdServiceInfo}
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pUpnpServiceInfo extends android.net.wifi.p2p.nsd.WifiP2pServiceInfo {

private WifiP2pUpnpServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Create UPnP service information object.
 *
 * @param uuid a string representation of this UUID in the following format,
 *  as per <a href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.<br>
 *  e.g) 6859dede-8574-59ab-9332-123456789012
 * @param device a string representation of this device in the following format,
 * as per
 * <a href="http://www.upnp.org/specs/arch/UPnP-arch-DeviceArchitecture-v1.1.pdf">
 *  UPnP Device Architecture1.1</a><br>
 *  e.g) urn:schemas-upnp-org:device:MediaServer:1
 * @param services a string representation of this service in the following format,
 * as per
 * <a href="http://www.upnp.org/specs/arch/UPnP-arch-DeviceArchitecture-v1.1.pdf">
 *  UPnP Device Architecture1.1</a><br>
 *  e.g) urn:schemas-upnp-org:service:ContentDirectory:1
 * @return UPnP service information object.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pUpnpServiceInfo newInstance(java.lang.String uuid, java.lang.String device, java.util.List<java.lang.String> services) { throw new RuntimeException("Stub!"); }
}

