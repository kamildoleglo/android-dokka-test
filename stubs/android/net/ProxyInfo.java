/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.net;

import java.net.URLConnection;

/**
 * Describes a proxy configuration.
 *
 * Proxy configurations are already integrated within the {@code java.net} and
 * Apache HTTP stack. So {@link java.net.URLConnection URLConnection} and Apache's {@code HttpClient} will use
 * them automatically.
 *
 * Other HTTP stacks will need to obtain the proxy info from
 * {@link android.net.Proxy#PROXY_CHANGE_ACTION Proxy#PROXY_CHANGE_ACTION} broadcast as the extra {@link android.net.Proxy#EXTRA_PROXY_INFO Proxy#EXTRA_PROXY_INFO}.
 * @apiSince 21
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ProxyInfo implements android.os.Parcelable {

/**
 * A copy constructor to hold proxy properties.
 
 * @param source This value may be {@code null}.
 * @apiSince R
 */

public ProxyInfo(@androidx.annotation.Nullable android.net.ProxyInfo source) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.net.ProxyInfo ProxyInfo} object that points at a Direct proxy
 * on the specified host and port.
 * @apiSince 21
 * @deprecatedSince 22
 */

public static android.net.ProxyInfo buildDirectProxy(java.lang.String host, int port) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.net.ProxyInfo ProxyInfo} object that points at a Direct proxy
 * on the specified host and port.
 *
 * The proxy will not be used to access any host in exclusion list, exclList.
 *
 * @param exclList Hosts to exclude using the proxy on connections for.  These
 *                 hosts can use wildcards such as *.example.com.
 * @apiSince 21
 * @deprecatedSince 22
 */

public static android.net.ProxyInfo buildDirectProxy(java.lang.String host, int port, java.util.List<java.lang.String> exclList) { throw new RuntimeException("Stub!"); }

/**
 * Construct a {@link android.net.ProxyInfo ProxyInfo} that will download and run the PAC script
 * at the specified URL.
 * @apiSince 21
 * @deprecatedSince 22
 */

public static android.net.ProxyInfo buildPacProxy(android.net.Uri pacUri) { throw new RuntimeException("Stub!"); }

/**
 * Construct a {@link android.net.ProxyInfo ProxyInfo} object that will download and run the PAC script at the
 * specified URL and port.
 
 * @param pacUrl This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince R
 * @deprecatedSince 22
 */

@androidx.annotation.NonNull
public static android.net.ProxyInfo buildPacProxy(@androidx.annotation.NonNull android.net.Uri pacUrl, int port) { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL of the current PAC script or null if there is
 * no PAC script.
 * @apiSince 21
 * @deprecatedSince 22
 */

public android.net.Uri getPacFileUrl() { throw new RuntimeException("Stub!"); }

/**
 * When configured to use a Direct Proxy this returns the host
 * of the proxy.
 * @apiSince 21
 * @deprecatedSince 22
 */

public java.lang.String getHost() { throw new RuntimeException("Stub!"); }

/**
 * When configured to use a Direct Proxy this returns the port
 * of the proxy
 * @apiSince 21
 * @deprecatedSince 22
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * When configured to use a Direct Proxy this returns the list
 * of hosts for which the proxy is ignored.
 * @apiSince 21
 * @deprecatedSince 22
 */

public java.lang.String[] getExclusionList() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the pattern of proxy is valid, otherwise return false.
 * @apiSince R
 * @deprecatedSince 22
 */

public boolean isValid() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 21
 * @deprecatedSince 22
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 21
 * @deprecatedSince 22
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @hide
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 21
 * @deprecatedSince 22
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 * @hide
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 21
 * @deprecatedSince 22
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.ProxyInfo> CREATOR;
static { CREATOR = null; }
}

