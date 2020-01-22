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
 * A class for creating a service discovery request for use with
 * {@link android.net.wifi.p2p.WifiP2pManager#addServiceRequest WifiP2pManager#addServiceRequest} and {@link android.net.wifi.p2p.WifiP2pManager#removeServiceRequest WifiP2pManager#removeServiceRequest}
 *
 * <p>This class is used to create service discovery request for custom
 * vendor specific service discovery protocol {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC}
 * or to search all service protocols {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo#SERVICE_TYPE_ALL WifiP2pServiceInfo#SERVICE_TYPE_ALL}.
 *
 * <p>For the purpose of creating a UPnP or Bonjour service request, use
 * {@link android.net.wifi.p2p.nsd.WifiP2pUpnpServiceRequest WifiP2pUpnpServiceRequest} or {@link android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest WifiP2pDnsSdServiceRequest} respectively.
 *
 * {@see WifiP2pManager}
 * {@see WifiP2pUpnpServiceRequest}
 * {@see WifiP2pDnsSdServiceRequest}
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pServiceRequest implements android.os.Parcelable {

WifiP2pServiceRequest() { throw new RuntimeException("Stub!"); }

/**
 * Create a service discovery request.
 *
 * @param protocolType can be {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo#SERVICE_TYPE_ALL WifiP2pServiceInfo#SERVICE_TYPE_ALL}
 * or {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC}.
 * In order to create a UPnP or Bonjour service request, use
 * {@link android.net.wifi.p2p.nsd.WifiP2pUpnpServiceRequest WifiP2pUpnpServiceRequest} or {@link android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest WifiP2pDnsSdServiceRequest}
 * respectively
 *
 * @param queryData hex string that is vendor specific.  Can be null.
 * @return service discovery request.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pServiceRequest newInstance(int protocolType, java.lang.String queryData) { throw new RuntimeException("Stub!"); }

/**
 * Create a service discovery request.
 *
 * @param protocolType can be {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo#SERVICE_TYPE_ALL WifiP2pServiceInfo#SERVICE_TYPE_ALL}
 * or {@link android.net.wifi.p2p.nsd.WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC WifiP2pServiceInfo#SERVICE_TYPE_VENDOR_SPECIFIC}.
 * In order to create a UPnP or Bonjour service request, use
 * {@link android.net.wifi.p2p.nsd.WifiP2pUpnpServiceRequest WifiP2pUpnpServiceRequest} or {@link android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest WifiP2pDnsSdServiceRequest}
 * respectively
 *
 * @return service discovery request.
 * @apiSince 16
 */

public static android.net.wifi.p2p.nsd.WifiP2pServiceRequest newInstance(int protocolType) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }
}

