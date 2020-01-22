/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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
 *
 * This class implements an IP Socket Address (IP address + port number)
 * It can also be a pair (hostname + port number), in which case an attempt
 * will be made to resolve the hostname. If resolution fails then the address
 * is said to be <I>unresolved</I> but can still be used on some circumstances
 * like connecting through a proxy.
 * <p>
 * It provides an immutable object used by sockets for binding, connecting, or
 * as returned values.
 * <p>
 * The <i>wildcard</i> is a special local IP address. It usually means "any"
 * and can only be used for {@code bind} operations.
 *
 * @see java.net.Socket
 * @see java.net.ServerSocket
 * @since 1.4
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InetSocketAddress extends java.net.SocketAddress {

/**
 * Creates a socket address where the IP address is the wildcard address
 * and the port number a specified value.
 * <p>
 * A valid port value is between 0 and 65535.
 * A port number of {@code zero} will let the system pick up an
 * ephemeral port in a {@code bind} operation.
 * <p>
 * @param   port    The port number
 * @throws java.lang.IllegalArgumentException if the port parameter is outside the specified
 * range of valid port values.
 * @apiSince 1
 */

public InetSocketAddress(int port) { throw new RuntimeException("Stub!"); }

/**
 *
 * Creates a socket address from an IP address and a port number.
 * <p>
 * A valid port value is between 0 and 65535.
 * A port number of {@code zero} will let the system pick up an
 * ephemeral port in a {@code bind} operation.
 * <P>
 * A {@code null} address will assign the <i>wildcard</i> address.
 * <p>
 * @param   addr    The IP address
 * @param   port    The port number
 * @throws java.lang.IllegalArgumentException if the port parameter is outside the specified
 * range of valid port values.
 @apiSince 1
 */

public InetSocketAddress(java.net.InetAddress addr, int port) { throw new RuntimeException("Stub!"); }

/**
 *
 * Creates a socket address from a hostname and a port number.
 * <p>
 * An attempt will be made to resolve the hostname into an InetAddress.
 * If that attempt fails, the address will be flagged as <I>unresolved</I>.
 * <p>
 * If there is a security manager, its {@code checkConnect} method
 * is called with the host name as its argument to check the permission
 * to resolve it. This could result in a SecurityException.
 * <P>
 * A valid port value is between 0 and 65535.
 * A port number of {@code zero} will let the system pick up an
 * ephemeral port in a {@code bind} operation.
 * <P>
 * @param   hostname the Host name
 * @param   port    The port number
 * @throws java.lang.IllegalArgumentException if the port parameter is outside the range
 * of valid port values, or if the hostname parameter is <TT>null</TT>.
 * @throws java.lang.SecurityException if a security manager is present and
 *                           permission to resolve the host name is
 *                           denied.
 * @see     #isUnresolved()
 @apiSince 1
 */

public InetSocketAddress(java.lang.String hostname, int port) { throw new RuntimeException("Stub!"); }

/**
 *
 * Creates an unresolved socket address from a hostname and a port number.
 * <p>
 * No attempt will be made to resolve the hostname into an InetAddress.
 * The address will be flagged as <I>unresolved</I>.
 * <p>
 * A valid port value is between 0 and 65535.
 * A port number of {@code zero} will let the system pick up an
 * ephemeral port in a {@code bind} operation.
 * <P>
 * @param   host    the Host name
 * @param   port    The port number
 * @throws java.lang.IllegalArgumentException if the port parameter is outside
 *                  the range of valid port values, or if the hostname
 *                  parameter is <TT>null</TT>.
 * @see     #isUnresolved()
 * @return  a {@code InetSocketAddress} representing the unresolved
 *          socket address
 * @since 1.5
 @apiSince 1
 */

public static java.net.InetSocketAddress createUnresolved(java.lang.String host, int port) { throw new RuntimeException("Stub!"); }

/**
 * Gets the port number.
 *
 * @return the port number.
 * @apiSince 1
 */

public final int getPort() { throw new RuntimeException("Stub!"); }

/**
 *
 * Gets the {@code InetAddress}.
 *
 * @return the InetAdress or {@code null} if it is unresolved.
 @apiSince 1
 */

public final java.net.InetAddress getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code hostname}.
 * Note: This method may trigger a name service reverse lookup if the
 * address was created with a literal IP address.
 *
 * @return  the hostname part of the address.
 * @apiSince 1
 */

public final java.lang.String getHostName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hostname, or the String form of the address if it
 * doesn't have a hostname (it was created using a literal).
 * This has the benefit of <b>not</b> attempting a reverse lookup.
 *
 * @return the hostname, or String representation of the address.
 * @since 1.7
 * @apiSince 19
 */

public final java.lang.String getHostString() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the address has been resolved or not.
 *
 * @return {@code true} if the hostname couldn't be resolved into
 *          an {@code InetAddress}.
 * @apiSince 1
 */

public final boolean isUnresolved() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string representation of this InetSocketAddress.
 * This String is constructed by calling toString() on the InetAddress
 * and concatenating the port number (with a colon). If the address
 * is unresolved then the part before the colon will only contain the hostname.
 *
 * @return  a string representation of this object.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Compares this object against the specified object.
 * The result is {@code true} if and only if the argument is
 * not {@code null} and it represents the same address as
 * this object.
 * <p>
 * Two instances of {@code InetSocketAddress} represent the same
 * address if both the InetAddresses (or hostnames if it is unresolved) and port
 * numbers are equal.
 * If both addresses are unresolved, then the hostname and the port number
 * are compared.
 *
 * Note: Hostnames are case insensitive. e.g. "FooBar" and "foobar" are
 * considered equal.
 *
 * @param   obj   the object to compare against.
 * @return  {@code true} if the objects are the same;
 *          {@code false} otherwise.
 * @see java.net.InetAddress#equals(java.lang.Object)
 * @apiSince 1
 */

public final boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode for this socket address.
 *
 * @return  a hash code value for this socket address.
 * @apiSince 1
 */

public final int hashCode() { throw new RuntimeException("Stub!"); }
}

