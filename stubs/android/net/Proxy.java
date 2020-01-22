/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.content.Context;

/**
 * A convenience class for accessing the user and default proxy
 * settings.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Proxy {

public Proxy() { throw new RuntimeException("Stub!"); }

/**
 * Return the proxy host set by the user.
 * @param ctx A Context used to get the settings for the proxy host.
 * @return String containing the host name. If the user did not set a host
 *         name it returns the default host. A null value means that no
 *         host is to be used.
 * @deprecated Use standard java vm proxy values to find the host, port
 *         and exclusion list.  This call ignores the exclusion list.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static java.lang.String getHost(android.content.Context ctx) { throw new RuntimeException("Stub!"); }

/**
 * Return the proxy port set by the user.
 * @param ctx A Context used to get the settings for the proxy port.
 * @return The port number to use or -1 if no proxy is to be used.
 * @deprecated Use standard java vm proxy values to find the host, port
 *         and exclusion list.  This call ignores the exclusion list.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getPort(android.content.Context ctx) { throw new RuntimeException("Stub!"); }

/**
 * Return the default proxy host specified by the carrier.
 * @return String containing the host name or null if there is no proxy for
 * this carrier.
 * @deprecated Use standard java vm proxy values to find the host, port and
 *         exclusion list.  This call ignores the exclusion list and no
 *         longer reports only mobile-data apn-based proxy values.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static java.lang.String getDefaultHost() { throw new RuntimeException("Stub!"); }

/**
 * Return the default proxy port specified by the carrier.
 * @return The port number to be used with the proxy host or -1 if there is
 * no proxy for this carrier.
 * @deprecated Use standard java vm proxy values to find the host, port and
 *         exclusion list.  This call ignores the exclusion list and no
 *         longer reports only mobile-data apn-based proxy values.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getDefaultPort() { throw new RuntimeException("Stub!"); }

/**
 * Intent extra included with {@link #PROXY_CHANGE_ACTION} intents.
 * It describes the new proxy being used (as a {@link android.net.ProxyInfo ProxyInfo} object).
 * @deprecated Because {@code PROXY_CHANGE_ACTION} is sent whenever the proxy
 * for any network on the system changes, applications should always use
 * {@link android.net.ConnectivityManager#getDefaultProxy() ConnectivityManager#getDefaultProxy()} or
 * {@link android.net.ConnectivityManager#getLinkProperties(android.net.Network) ConnectivityManager#getLinkProperties(Network)}.{@link android.net.LinkProperties#getHttpProxy() LinkProperties#getHttpProxy()}
 * to get the proxy for the Network(s) they are using.
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated public static final java.lang.String EXTRA_PROXY_INFO = "android.intent.extra.PROXY_INFO";

/**
 * Used to notify an app that's caching the proxy that either the default
 * connection has changed or any connection's proxy has changed. The new
 * proxy should be queried using {@link android.net.ConnectivityManager#getDefaultProxy() ConnectivityManager#getDefaultProxy()}.
 *
 * <p class="note">This is a protected intent that can only be sent by the system
 * @apiSince 1
 */

public static final java.lang.String PROXY_CHANGE_ACTION = "android.intent.action.PROXY_CHANGE";
}

