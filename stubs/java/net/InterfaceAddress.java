/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.net;


/**
 * This class represents a Network Interface address. In short it's an
 * IP address, a subnet mask and a broadcast address when the address is
 * an IPv4 one. An IP address and a network prefix length in the case
 * of IPv6 address.
 *
 * @see java.net.NetworkInterface
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InterfaceAddress {

InterfaceAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@code InetAddress} for this address.
 *
 * @return the {@code InetAddress} for this address.
 * @apiSince 9
 */

public java.net.InetAddress getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@code InetAddress} for the broadcast address
 * for this InterfaceAddress.
 * <p>
 * Only IPv4 networks have broadcast address therefore, in the case
 * of an IPv6 network, {@code null} will be returned.
 *
 * @return the {@code InetAddress} representing the broadcast
 *         address or {@code null} if there is no broadcast address.
 * @apiSince 9
 */

public java.net.InetAddress getBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network prefix length for this address. This is also known
 * as the subnet mask in the context of IPv4 addresses.
 * Typical IPv4 values would be 8 (255.0.0.0), 16 (255.255.0.0)
 * or 24 (255.255.255.0). <p>
 * Typical IPv6 values would be 128 (::1/128) or 10 (fe80::203:baff:fe27:1243/10)
 *
 * @return a {@code short} representing the prefix length for the
 *         subnet of that address.
 * @apiSince 9
 */

public short getNetworkPrefixLength() { throw new RuntimeException("Stub!"); }

/**
 * Compares this object against the specified object.
 * The result is {@code true} if and only if the argument is
 * not {@code null} and it represents the same interface address as
 * this object.
 * <p>
 * Two instances of {@code InterfaceAddress} represent the same
 * address if the InetAddress, the prefix length and the broadcast are
 * the same for both.
 *
 * @param   obj   the object to compare against.
 * @return  {@code true} if the objects are the same;
 *          {@code false} otherwise.
 * @see     java.net.InterfaceAddress#hashCode()
 * @apiSince 9
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode for this Interface address.
 *
 * @return  a hash code value for this Interface address.
 * @apiSince 9
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Converts this Interface address to a {@code String}. The
 * string returned is of the form: InetAddress / prefix length [ broadcast address ].
 *
 * @return  a string representation of this Interface address.
 * @apiSince 9
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

