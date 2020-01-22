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


/**
 * A class for storing Bonjour service information that is advertised
 * over a Wi-Fi peer-to-peer setup.
 *
 * {@see android.net.wifi.p2p.WifiP2pManager#addLocalService}
 * {@see android.net.wifi.p2p.WifiP2pManager#removeLocalService}
 * {@see WifiP2pServiceInfo}
 * {@see WifiP2pUpnpServiceInfo}
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pDnsSdServiceInfo extends android.net.wifi.p2p.nsd.WifiP2pServiceInfo {

private WifiP2pDnsSdServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Create a Bonjour service information object.
 *
 * @param instanceName instance name.<br>
 *  e.g) "MyPrinter"
 * @param serviceType service type.<br>
 *  e.g) "_ipp._tcp"
 * @param txtMap TXT record with key/value pair in a map confirming to format defined at
 * http://files.dns-sd.org/draft-cheshire-dnsext-dns-sd.txt
 * @return Bonjour service information object
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo newInstance(java.lang.String instanceName, java.lang.String serviceType, java.util.Map<java.lang.String,java.lang.String> txtMap) { throw new RuntimeException("Stub!"); }
}

