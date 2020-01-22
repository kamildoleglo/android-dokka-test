/*
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

import java.util.Enumeration;
import java.util.List;

/**
 * This class represents a Network Interface made up of a name,
 * and a list of IP addresses assigned to this interface.
 * It is used to identify the local interface on which a multicast group
 * is joined.
 *
 * Interfaces are normally known by names such as "le0".
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NetworkInterface {

NetworkInterface() { throw new RuntimeException("Stub!"); }

/**
 * Get the name of this network interface.
 *
 * @return the name of this network interface
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to return an Enumeration with all or a
 * subset of the InetAddresses bound to this network interface.
 * <p>
 * If there is a security manager, its {@code checkConnect}
 * method is called for each InetAddress. Only InetAddresses where
 * the {@code checkConnect} doesn't throw a SecurityException
 * will be returned in the Enumeration. However, if the caller has the
 * {@link java.net.NetPermission NetPermission}("getNetworkInformation") permission, then all
 * InetAddresses are returned.
 * @return an Enumeration object with all or a subset of the InetAddresses
 * bound to this network interface
 * @apiSince 1
 */

public java.util.Enumeration<java.net.InetAddress> getInetAddresses() { throw new RuntimeException("Stub!"); }

/**
 * Get a List of all or a subset of the {@code InterfaceAddresses}
 * of this network interface.
 * <p>
 * If there is a security manager, its {@code checkConnect}
 * method is called with the InetAddress for each InterfaceAddress.
 * Only InterfaceAddresses where the {@code checkConnect} doesn't throw
 * a SecurityException will be returned in the List.
 *
 * @return a {@code List} object with all or a subset of the
 *         InterfaceAddresss of this network interface
 * @since 1.6
 * @apiSince 9
 */

public java.util.List<java.net.InterfaceAddress> getInterfaceAddresses() { throw new RuntimeException("Stub!"); }

/**
 * Get an Enumeration with all the subinterfaces (also known as virtual
 * interfaces) attached to this network interface.
 * <p>
 * For instance eth0:1 will be a subinterface to eth0.
 *
 * @return an Enumeration object with all of the subinterfaces
 * of this network interface
 * @since 1.6
 * @apiSince 9
 */

public java.util.Enumeration<java.net.NetworkInterface> getSubInterfaces() { throw new RuntimeException("Stub!"); }

/**
 * Returns the parent NetworkInterface of this interface if this is
 * a subinterface, or {@code null} if it is a physical
 * (non virtual) interface or has no parent.
 *
 * @return The {@code NetworkInterface} this interface is attached to.
 * @since 1.6
 * @apiSince 9
 */

public java.net.NetworkInterface getParent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of this network interface. The index is an integer greater
 * or equal to zero, or {@code -1} for unknown. This is a system specific value
 * and interfaces with the same name can have different indexes on different
 * machines.
 *
 * @return the index of this network interface or {@code -1} if the index is
 *         unknown
 * @see #getByIndex(int)
 * @since 1.7
 * @apiSince 19
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Get the display name of this network interface.
 * A display name is a human readable String describing the network
 * device.
 *
 * @return a non-empty string representing the display name of this network
 *         interface, or null if no display name is available.
 * @apiSince 1
 */

public java.lang.String getDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Searches for the network interface with the specified name.
 *
 * @param   name
 *          The name of the network interface.
 *
 * @return  A {@code NetworkInterface} with the specified name,
 *          or {@code null} if there is no network interface
 *          with the specified name.
 *
 * @throws  java.net.SocketException
 *          If an I/O error occurs.
 *
 * @throws  java.lang.NullPointerException
 *          If the specified name is {@code null}.
 * @apiSince 1
 */

public static java.net.NetworkInterface getByName(java.lang.String name) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Get a network interface given its index.
 *
 * @param index an integer, the index of the interface
 * @return the NetworkInterface obtained from its index, or {@code null} if
 *         there is no interface with such an index on the system
 * @throws  java.net.SocketException  if an I/O error occurs.
 * @throws  java.lang.IllegalArgumentException if index has a negative value
 * @see #getIndex()
 * @since 1.7
 * @apiSince 19
 */

public static java.net.NetworkInterface getByIndex(int index) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to search for a network interface that
 * has the specified Internet Protocol (IP) address bound to
 * it.
 * <p>
 * If the specified IP address is bound to multiple network
 * interfaces it is not defined which network interface is
 * returned.
 *
 * @param   addr
 *          The {@code InetAddress} to search with.
 *
 * @return  A {@code NetworkInterface}
 *          or {@code null} if there is no network interface
 *          with the specified IP address.
 *
 * @throws  java.net.SocketException
 *          If an I/O error occurs.
 *
 * @throws  java.lang.NullPointerException
 *          If the specified address is {@code null}.
 * @apiSince 1
 */

public static java.net.NetworkInterface getByInetAddress(java.net.InetAddress addr) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns all the interfaces on this machine. The {@code Enumeration}
 * contains at least one element, possibly representing a loopback
 * interface that only supports communication between entities on
 * this machine.
 *
 * NOTE: can use getNetworkInterfaces()+getInetAddresses()
 *       to obtain all IP addresses for this node
 *
 * @return an Enumeration of NetworkInterfaces found on this machine
 * @exception  java.net.SocketException  if an I/O error occurs.
 * @apiSince 1
 */

public static java.util.Enumeration<java.net.NetworkInterface> getNetworkInterfaces() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a network interface is up and running.
 *
 * @return  {@code true} if the interface is up and running.
 * @exception       java.net.SocketException if an I/O error occurs.
 * @since 1.6
 * @apiSince 9
 */

public boolean isUp() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a network interface is a loopback interface.
 *
 * @return  {@code true} if the interface is a loopback interface.
 * @exception       java.net.SocketException if an I/O error occurs.
 * @since 1.6
 * @apiSince 9
 */

public boolean isLoopback() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a network interface is a point to point interface.
 * A typical point to point interface would be a PPP connection through
 * a modem.
 *
 * @return  {@code true} if the interface is a point to point
 *          interface.
 * @exception       java.net.SocketException if an I/O error occurs.
 * @since 1.6
 * @apiSince 9
 */

public boolean isPointToPoint() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a network interface supports multicasting or not.
 *
 * @return  {@code true} if the interface supports Multicasting.
 * @exception       java.net.SocketException if an I/O error occurs.
 * @since 1.6
 * @apiSince 9
 */

public boolean supportsMulticast() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns the hardware address (usually MAC) of the interface if it
 * has one and if it can be accessed given the current privileges.
 * If a security manager is set, then the caller must have
 * the permission {@link java.net.NetPermission NetPermission}("getNetworkInformation").
 *
 * @return  a byte array containing the address, or {@code null} if
 *          the address doesn't exist, is not accessible or a security
 *          manager is set and the caller does not have the permission
 *          NetPermission("getNetworkInformation")
 *
 * @exception       java.net.SocketException if an I/O error occurs.
 * @since 1.6
 * @apiSince 9
 */

public byte[] getHardwareAddress() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns the Maximum Transmission Unit (MTU) of this interface.
 *
 * @return the value of the MTU for that interface.
 * @exception       java.net.SocketException if an I/O error occurs.
 * @since 1.6
 * @apiSince 9
 */

public int getMTU() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this interface is a virtual interface (also called
 * subinterface).
 * Virtual interfaces are, on some systems, interfaces created as a child
 * of a physical interface and given different settings (like address or
 * MTU). Usually the name of the interface will the name of the parent
 * followed by a colon (:) and a number identifying the child since there
 * can be several virtual interfaces attached to a single physical
 * interface.
 *
 * @return {@code true} if this interface is a virtual interface.
 * @since 1.6
 * @apiSince 9
 */

public boolean isVirtual() { throw new RuntimeException("Stub!"); }

/**
 * Compares this object against the specified object.
 * The result is {@code true} if and only if the argument is
 * not {@code null} and it represents the same NetworkInterface
 * as this object.
 * <p>
 * Two instances of {@code NetworkInterface} represent the same
 * NetworkInterface if both name and addrs are the same for both.
 *
 * @param   obj   the object to compare against.
 * @return  {@code true} if the objects are the same;
 *          {@code false} otherwise.
 * @see     java.net.InetAddress#getAddress()
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

