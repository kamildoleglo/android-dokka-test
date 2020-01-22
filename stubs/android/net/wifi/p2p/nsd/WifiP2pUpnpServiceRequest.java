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

import android.net.wifi.p2p.WifiP2pManager;

/**
 * A class for creating a Upnp service discovery request for use with
 * {@link android.net.wifi.p2p.WifiP2pManager#addServiceRequest WifiP2pManager#addServiceRequest} and {@link android.net.wifi.p2p.WifiP2pManager#removeServiceRequest WifiP2pManager#removeServiceRequest}
 *
 * {@see WifiP2pManager}
 * {@see WifiP2pServiceRequest}
 * {@see WifiP2pDnsSdServiceRequest}
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pUpnpServiceRequest extends android.net.wifi.p2p.nsd.WifiP2pServiceRequest {

WifiP2pUpnpServiceRequest() { throw new RuntimeException("Stub!"); }

/**
 * Create a service discovery request to search all UPnP services.
 *
 * @return service request for UPnP.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pUpnpServiceRequest newInstance() { throw new RuntimeException("Stub!"); }

/**
 * Create a service discovery request to search specified UPnP services.
 *
 * @param st ssdp search target.  Cannot be null.<br>
 * e.g ) <br>
 * <ul>
 * <li>"ssdp:all"
 * <li>"upnp:rootdevice"
 * <li>"urn:schemas-upnp-org:device:MediaServer:2"
 * <li>"urn:schemas-upnp-org:service:ContentDirectory:2"
 * <li>"uuid:6859dede-8574-59ab-9332-123456789012"
 * </ul>
 * @return service request for UPnP.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pUpnpServiceRequest newInstance(java.lang.String st) { throw new RuntimeException("Stub!"); }
}

