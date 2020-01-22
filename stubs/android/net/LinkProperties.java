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

import java.util.List;
import java.util.Collection;
import java.net.InetAddress;
import android.os.Parcelable;

/**
 * Describes the properties of a network link.
 *
 * A link represents a connection to a network.
 * It may have multiple addresses and multiple gateways,
 * multiple dns servers but only one http proxy and one
 * network interface.
 *
 * Note that this is just a holder of data.  Modifying it
 * does not affect live networks.
 *
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LinkProperties implements android.os.Parcelable {

/**
 * Constructs a new {@code LinkProperties} with default values.
 * @apiSince 29
 */

public LinkProperties() { throw new RuntimeException("Stub!"); }

/**
 * Sets the interface name for this link.  All {@link android.net.RouteInfo RouteInfo} already set for this
 * will have their interface changed to match this new value.
 *
 * @param iface The name of the network interface used for this link.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setInterfaceName(@androidx.annotation.Nullable java.lang.String iface) { throw new RuntimeException("Stub!"); }

/**
 * Gets the interface name for this link.  May be {@code null} if not set.
 *
 * @return The interface name set for this link or {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getInterfaceName() { throw new RuntimeException("Stub!"); }

/**
 * Returns all the {@link android.net.LinkAddress LinkAddress} on this link.  Typically a link will have
 * one IPv4 address and one or more IPv6 addresses.
 *
 * @return An unmodifiable {@link java.util.List List} of {@link android.net.LinkAddress LinkAddress} for this link.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.net.LinkAddress> getLinkAddresses() { throw new RuntimeException("Stub!"); }

/**
 * Replaces the {@link android.net.LinkAddress LinkAddress} in this {@code LinkProperties} with
 * the given {@link java.util.Collection Collection} of {@link android.net.LinkAddress LinkAddress}.
 *
 * @param addresses The {@link java.util.Collection Collection} of {@link android.net.LinkAddress LinkAddress} to set in this
 *                  object.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void setLinkAddresses(@androidx.annotation.NonNull java.util.Collection<android.net.LinkAddress> addresses) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the DNS servers in this {@code LinkProperties} with
 * the given {@link java.util.Collection Collection} of {@link java.net.InetAddress InetAddress} objects.
 *
 * @param dnsServers The {@link java.util.Collection Collection} of DNS servers to set in this object.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void setDnsServers(@androidx.annotation.NonNull java.util.Collection<java.net.InetAddress> dnsServers) { throw new RuntimeException("Stub!"); }

/**
 * Returns all the {@link java.net.InetAddress InetAddress} for DNS servers on this link.
 *
 * @return An unmodifiable {@link java.util.List List} of {@link java.net.InetAddress InetAddress} for DNS servers on
 *         this link.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<java.net.InetAddress> getDnsServers() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether private DNS is currently in use on this network. When
 * private DNS is in use, applications must not send unencrypted DNS
 * queries as doing so could reveal private user information. Furthermore,
 * if private DNS is in use and {@link #getPrivateDnsServerName} is not
 * {@code null}, DNS queries must be sent to the specified DNS server.
 *
 * @return {@code true} if private DNS is in use, {@code false} otherwise.
 * @apiSince 28
 */

public boolean isPrivateDnsActive() { throw new RuntimeException("Stub!"); }

/**
 * Returns the private DNS server name that is in use. If not {@code null},
 * private DNS is in strict mode. In this mode, applications should ensure
 * that all DNS queries are encrypted and sent to this hostname and that
 * queries are only sent if the hostname's certificate is valid. If
 * {@code null} and {@link #isPrivateDnsActive} is {@code true}, private
 * DNS is in opportunistic mode, and applications should ensure that DNS
 * queries are encrypted and sent to a DNS server returned by
 * {@link #getDnsServers}. System DNS will handle each of these cases
 * correctly, but applications implementing their own DNS lookups must make
 * sure to follow these requirements.
 *
 * @return The private DNS server name.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getPrivateDnsServerName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the DNS domain search path used on this link.
 *
 * @param domains A {@link java.lang.String String} listing in priority order the comma separated
 *                domains to search when resolving host names on this link.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setDomains(@androidx.annotation.Nullable java.lang.String domains) { throw new RuntimeException("Stub!"); }

/**
 * Get the DNS domains search path set for this link. May be {@code null} if not set.
 *
 * @return A {@link java.lang.String String} containing the comma separated domains to search when resolving host
 *         names on this link or {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getDomains() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Maximum Transmission Unit size to use on this link.  This should not be used
 * unless the system default (1500) is incorrect.  Values less than 68 or greater than
 * 10000 will be ignored.
 *
 * @param mtu The MTU to use for this link.
 * @apiSince 29
 */

public void setMtu(int mtu) { throw new RuntimeException("Stub!"); }

/**
 * Gets any non-default MTU size set for this link.  Note that if the default is being used
 * this will return 0.
 *
 * @return The mtu value set for this link.
 * @apiSince 29
 */

public int getMtu() { throw new RuntimeException("Stub!"); }

/**
 * Adds a {@link android.net.RouteInfo RouteInfo} to this {@code LinkProperties}, if not present. If the
 * {@link android.net.RouteInfo RouteInfo} had an interface name set and that differs from the interface set for this
 * {@code LinkProperties} an {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown.  The proper
 * course is to add either un-named or properly named {@link android.net.RouteInfo RouteInfo}.
 *
 * @param route A {@link android.net.RouteInfo RouteInfo} to add to this object.
 * This value must never be {@code null}.
 * @return {@code false} if the route was already present, {@code true} if it was added.
 * @apiSince 29
 */

public boolean addRoute(@androidx.annotation.NonNull android.net.RouteInfo route) { throw new RuntimeException("Stub!"); }

/**
 * Returns all the {@link android.net.RouteInfo RouteInfo} set on this link.
 *
 * @return An unmodifiable {@link java.util.List List} of {@link android.net.RouteInfo RouteInfo} for this link.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.net.RouteInfo> getRoutes() { throw new RuntimeException("Stub!"); }

/**
 * Sets the recommended {@link android.net.ProxyInfo ProxyInfo} to use on this link, or {@code null} for none.
 * Note that Http Proxies are only a hint - the system recommends their use, but it does
 * not enforce it and applications may ignore them.
 *
 * @param proxy A {@link android.net.ProxyInfo ProxyInfo} defining the HTTP Proxy to use on this link.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setHttpProxy(@androidx.annotation.Nullable android.net.ProxyInfo proxy) { throw new RuntimeException("Stub!"); }

/**
 * Gets the recommended {@link android.net.ProxyInfo ProxyInfo} (or {@code null}) set on this link.
 *
 * @return The {@link android.net.ProxyInfo ProxyInfo} set on this link or {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.net.ProxyInfo getHttpProxy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the NAT64 prefix in use on this link, if any.
 *
 * @return the NAT64 prefix or {@code null}.
 * @apiSince R
 */

@androidx.annotation.Nullable
public android.net.IpPrefix getNat64Prefix() { throw new RuntimeException("Stub!"); }

/**
 * Sets the NAT64 prefix in use on this link.
 *
 * Currently, only 96-bit prefixes (i.e., where the 32-bit IPv4 address is at the end of the
 * 128-bit IPv6 address) are supported or {@code null} for no prefix.
 *
 * @param prefix the NAT64 prefix.
 
 * This value may be {@code null}.
 * @apiSince R
 */

public void setNat64Prefix(@androidx.annotation.Nullable android.net.IpPrefix prefix) { throw new RuntimeException("Stub!"); }

/**
 * Clears this object to its initial state.
 * @apiSince 29
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 21
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the network interface supports WakeOnLAN
 *
 * @return {@code true} if interface supports WakeOnLAN, {@code false} otherwise.
 * @apiSince R
 */

public boolean isWakeOnLanSupported() { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code LinkProperties} instance against the target
 * LinkProperties in {@code obj}. Two LinkPropertieses are equal if
 * all their fields are equal in values.
 *
 * For collection fields, such as mDnses, containsAll() is used to check
 * if two collections contains the same elements, independent of order.
 * There are two thoughts regarding containsAll()
 * 1. Duplicated elements. eg, (A, B, B) and (A, A, B) are equal.
 * 2. Worst case performance is O(n^2).
 *
 * @param obj the object to be tested for equality.
 * @return {@code true} if both objects are equal, {@code false} otherwise.
 * @apiSince 21
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Generate hashcode based on significant fields
 *
 * Equal objects must produce the same hash code, while unequal objects
 * may have the same hash codes.
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 * @apiSince 21
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.LinkProperties> CREATOR;
static { CREATOR = null; }
}

