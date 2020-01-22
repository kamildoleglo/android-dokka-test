/*
 * Copyright (C) 2011 The Android Open Source Project
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

import java.net.InetAddress;
import android.os.Parcelable;

/**
 * Represents a network route.
 * <p>
 * This is used both to describe static network configuration and live network
 * configuration information.
 *
 * A route contains three pieces of information:
 * <ul>
 * <li>a destination {@link android.net.IpPrefix IpPrefix} specifying the network destinations covered by this route.
 *     If this is {@code null} it indicates a default route of the address family (IPv4 or IPv6)
 *     implied by the gateway IP address.
 * <li>a gateway {@link java.net.InetAddress InetAddress} indicating the next hop to use.  If this is {@code null} it
 *     indicates a directly-connected route.
 * <li>an interface (which may be unspecified).
 * </ul>
 * Either the destination or the gateway may be {@code null}, but not both.  If the
 * destination and gateway are both specified, they must be of the same address family
 * (IPv4 or IPv6).
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RouteInfo implements android.os.Parcelable {

RouteInfo() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the destination address and prefix length in the form of an {@link android.net.IpPrefix IpPrefix}.
 *
 * @return {@link android.net.IpPrefix IpPrefix} specifying the destination.  This is never {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.net.IpPrefix getDestination() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the gateway or next hop {@link java.net.InetAddress InetAddress} for this route.
 *
 * @return {@link java.net.InetAddress InetAddress} specifying the gateway or next hop.  This may be
 *                             {@code null} for a directly-connected route."
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.net.InetAddress getGateway() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the interface used for this route if specified, else {@code null}.
 *
 * @return The name of the interface used for this route.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getInterface() { throw new RuntimeException("Stub!"); }

/**
 * Indicates if this route is a default route (ie, has no destination specified).
 *
 * @return {@code true} if the destination has a prefix length of 0.
 * @apiSince 21
 */

public boolean isDefaultRoute() { throw new RuntimeException("Stub!"); }

/**
 * Indicates if this route has a next hop ({@code true}) or is directly-connected
 * ({@code false}).
 *
 * @return {@code true} if a gateway is specified
 * @apiSince 29
 */

public boolean hasGateway() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the destination and prefix of this route includes the specified
 * address.
 *
 * @param destination A {@link java.net.InetAddress InetAddress} to test to see if it would match this route.
 * @return {@code true} if the destination and prefix length cover the given address.
 * @apiSince 21
 */

public boolean matches(java.net.InetAddress destination) { throw new RuntimeException("Stub!"); }

/**
 * Returns a human-readable description of this object.
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Compares this RouteInfo object against the specified object and indicates if they are equal.
 * @return {@code true} if the objects are equal, {@code false} otherwise.
 * @apiSince 21
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 *  Returns a hashcode for this <code>RouteInfo</code> object.
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 21
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 21
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.RouteInfo> CREATOR;
static { CREATOR = null; }
}

