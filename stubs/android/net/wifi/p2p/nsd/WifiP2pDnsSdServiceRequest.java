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
 * A class for creating a Bonjour service discovery request for use with
 * {@link android.net.wifi.p2p.WifiP2pManager#addServiceRequest WifiP2pManager#addServiceRequest} and {@link android.net.wifi.p2p.WifiP2pManager#removeServiceRequest WifiP2pManager#removeServiceRequest}
 *
 * {@see WifiP2pManager}
 * {@see WifiP2pServiceRequest}
 * {@see WifiP2pUpnpServiceRequest}
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pDnsSdServiceRequest extends android.net.wifi.p2p.nsd.WifiP2pServiceRequest {

private WifiP2pDnsSdServiceRequest() { throw new RuntimeException("Stub!"); }

/**
 * Create a service discovery request to search all Bonjour services.
 *
 * @return service request for Bonjour.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest newInstance() { throw new RuntimeException("Stub!"); }

/**
 * Create a service discovery to search for Bonjour services with the specified
 * service type.
 *
 * @param serviceType service type. Cannot be null <br>
 *  "_afpovertcp._tcp."(Apple File Sharing over TCP)<br>
 *  "_ipp._tcp" (IP Printing over TCP)<br>
 *  "_http._tcp" (http service)
 * @return service request for DnsSd.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest newInstance(java.lang.String serviceType) { throw new RuntimeException("Stub!"); }

/**
 * Create a service discovery request to get the TXT data from the specified
 * Bonjour service.
 *
 * @param instanceName instance name. Cannot be null. <br>
 *  "MyPrinter"
 * @param serviceType service type. Cannot be null. <br>
 * e.g) <br>
 *  "_afpovertcp._tcp"(Apple File Sharing over TCP)<br>
 *  "_ipp._tcp" (IP Printing over TCP)<br>
 * @return service request for Bonjour.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest newInstance(java.lang.String instanceName, java.lang.String serviceType) { throw new RuntimeException("Stub!"); }
}

