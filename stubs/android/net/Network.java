/*
 * Copyright (C) 2014 The Android Open Source Project
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

import javax.net.SocketFactory;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.DatagramSocket;
import java.io.FileDescriptor;

/**
 * Identifies a {@code Network}.  This is supplied to applications via
 * {@link android.net.ConnectivityManager.NetworkCallback ConnectivityManager.NetworkCallback} in response to the active
 * {@link android.net.ConnectivityManager#requestNetwork ConnectivityManager#requestNetwork} or passive
 * {@link android.net.ConnectivityManager#registerNetworkCallback ConnectivityManager#registerNetworkCallback} calls.
 * It is used to direct traffic to the given {@code Network}, either on a {@link java.net.Socket Socket} basis
 * through a targeted {@link javax.net.SocketFactory SocketFactory} or process-wide via
 * {@link android.net.ConnectivityManager#bindProcessToNetwork ConnectivityManager#bindProcessToNetwork}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Network implements android.os.Parcelable {

Network() { throw new RuntimeException("Stub!"); }

/**
 * Operates the same as {@code InetAddress.getAllByName} except that host
 * resolution is done on this network.
 *
 * @param host the hostname or literal IP string to be resolved.
 * @return the array of addresses associated with the specified host.
 * @throws java.net.UnknownHostException if the address lookup fails.
 * @apiSince 21
 */

public java.net.InetAddress[] getAllByName(java.lang.String host) throws java.net.UnknownHostException { throw new RuntimeException("Stub!"); }

/**
 * Operates the same as {@code InetAddress.getByName} except that host
 * resolution is done on this network.
 *
 * @param host the hostname to be resolved to an address or {@code null}.
 * @return the {@code InetAddress} instance representing the host.
 * @throws java.net.UnknownHostException
 *             if the address lookup fails.
 * @apiSince 21
 */

public java.net.InetAddress getByName(java.lang.String host) throws java.net.UnknownHostException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link javax.net.SocketFactory SocketFactory} bound to this network.  Any {@link java.net.Socket Socket} created by
 * this factory will have its traffic sent over this {@code Network}.  Note that if this
 * {@code Network} ever disconnects, this factory and any {@link java.net.Socket Socket} it produced in the
 * past or future will cease to work.
 *
 * @return a {@link javax.net.SocketFactory SocketFactory} which produces {@link java.net.Socket Socket} instances bound to this
 *         {@code Network}.
 * @apiSince 21
 */

public javax.net.SocketFactory getSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Opens the specified {@link java.net.URL URL} on this {@code Network}, such that all traffic will be sent
 * on this Network. The URL protocol must be {@code HTTP} or {@code HTTPS}.
 *
 * @return a {@code URLConnection} to the resource referred to by this URL.
 * @throws java.net.MalformedURLException if the URL protocol is not HTTP or HTTPS.
 * @throws java.io.IOException if an error occurs while opening the connection.
 * @see java.net.URL#openConnection()
 * @apiSince 21
 */

public java.net.URLConnection openConnection(java.net.URL url) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens the specified {@link java.net.URL URL} on this {@code Network}, such that all traffic will be sent
 * on this Network. The URL protocol must be {@code HTTP} or {@code HTTPS}.
 *
 * @param proxy the proxy through which the connection will be established.
 * @return a {@code URLConnection} to the resource referred to by this URL.
 * @throws java.net.MalformedURLException if the URL protocol is not HTTP or HTTPS.
 * @throws java.lang.IllegalArgumentException if the argument proxy is null.
 * @throws java.io.IOException if an error occurs while opening the connection.
 * @see java.net.URL#openConnection()
 * @apiSince 23
 */

public java.net.URLConnection openConnection(java.net.URL url, java.net.Proxy proxy) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the specified {@link java.net.DatagramSocket DatagramSocket} to this {@code Network}. All data traffic on the
 * socket will be sent on this {@code Network}, irrespective of any process-wide network binding
 * set by {@link android.net.ConnectivityManager#bindProcessToNetwork ConnectivityManager#bindProcessToNetwork}. The socket must not be
 * connected.
 * @apiSince 22
 */

public void bindSocket(java.net.DatagramSocket socket) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the specified {@link java.net.Socket Socket} to this {@code Network}. All data traffic on the socket
 * will be sent on this {@code Network}, irrespective of any process-wide network binding set by
 * {@link android.net.ConnectivityManager#bindProcessToNetwork ConnectivityManager#bindProcessToNetwork}. The socket must not be connected.
 * @apiSince 21
 */

public void bindSocket(java.net.Socket socket) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the specified {@link java.io.FileDescriptor FileDescriptor} to this {@code Network}. All data traffic on the
 * socket represented by this file descriptor will be sent on this {@code Network},
 * irrespective of any process-wide network binding set by
 * {@link android.net.ConnectivityManager#bindProcessToNetwork ConnectivityManager#bindProcessToNetwork}. The socket must not be connected.
 * @apiSince 23
 */

public void bindSocket(java.io.FileDescriptor fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.net.Network Network} object given a handle returned from {@link #getNetworkHandle}.
 *
 * @param networkHandle a handle returned from {@link #getNetworkHandle}.
 * @return A {@link android.net.Network Network} object derived from {@code networkHandle}.
 * @apiSince 28
 */

public static android.net.Network fromNetworkHandle(long networkHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a handle representing this {@code Network}, for use with the NDK API.
 * @apiSince 23
 */

public long getNetworkHandle() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.Network> CREATOR;
static { CREATOR = null; }
}

