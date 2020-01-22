/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.FileDescriptor;

/**
 * Abstract datagram and multicast socket implementation base class.
 * @author Pavani Diwanji
 * @since  JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DatagramSocketImpl implements java.net.SocketOptions {

/** @apiSince 1 */

public DatagramSocketImpl() { throw new RuntimeException("Stub!"); }

/**
 * Creates a datagram socket.
 * @exception java.net.SocketException if there is an error in the
 * underlying protocol, such as a TCP error.
 * @apiSince 1
 */

protected abstract void create() throws java.net.SocketException;

/**
 * Binds a datagram socket to a local port and address.
 * @param lport the local port
 * @param laddr the local address
 * @exception java.net.SocketException if there is an error in the
 * underlying protocol, such as a TCP error.
 * @apiSince 1
 */

protected abstract void bind(int lport, java.net.InetAddress laddr) throws java.net.SocketException;

/**
 * Sends a datagram packet. The packet contains the data and the
 * destination address to send the packet to.
 * @param p the packet to be sent.
 * @exception java.io.IOException if an I/O exception occurs while sending the
 * datagram packet.
 * @exception  java.net.PortUnreachableException may be thrown if the socket is connected
 * to a currently unreachable destination. Note, there is no guarantee that
 * the exception will be thrown.
 * @apiSince 1
 */

protected abstract void send(java.net.DatagramPacket p) throws java.io.IOException;

/**
 * Connects a datagram socket to a remote destination. This associates the remote
 * address with the local socket so that datagrams may only be sent to this destination
 * and received from this destination. This may be overridden to call a native
 * system connect.
 *
 * <p>If the remote destination to which the socket is connected does not
 * exist, or is otherwise unreachable, and if an ICMP destination unreachable
 * packet has been received for that address, then a subsequent call to
 * send or receive may throw a PortUnreachableException.
 * Note, there is no guarantee that the exception will be thrown.
 * @param address the remote InetAddress to connect to
 * @param port the remote port number
 * @exception   java.net.SocketException may be thrown if the socket cannot be
 * connected to the remote destination
 * @since 1.4
 * @apiSince 1
 */

protected void connect(java.net.InetAddress address, int port) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Disconnects a datagram socket from its remote destination.
 * @since 1.4
 * @apiSince 1
 */

protected void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Peek at the packet to see who it is from. Updates the specified {@code InetAddress}
 * to the address which the packet came from.
 * @param i an InetAddress object
 * @return the port number which the packet came from.
 * @exception java.io.IOException if an I/O exception occurs
 * @exception  java.net.PortUnreachableException may be thrown if the socket is connected
 *       to a currently unreachable destination. Note, there is no guarantee that the
 *       exception will be thrown.
 * @apiSince 1
 */

protected abstract int peek(java.net.InetAddress i) throws java.io.IOException;

/**
 * Peek at the packet to see who it is from. The data is copied into the specified
 * {@code DatagramPacket}. The data is returned,
 * but not consumed, so that a subsequent peekData/receive operation
 * will see the same data.
 * @param p the Packet Received.
 * @return the port number which the packet came from.
 * @exception java.io.IOException if an I/O exception occurs
 * @exception  java.net.PortUnreachableException may be thrown if the socket is connected
 *       to a currently unreachable destination. Note, there is no guarantee that the
 *       exception will be thrown.
 * @since 1.4
 * @apiSince 1
 */

protected abstract int peekData(java.net.DatagramPacket p) throws java.io.IOException;

/**
 * Receive the datagram packet.
 * @param p the Packet Received.
 * @exception java.io.IOException if an I/O exception occurs
 * while receiving the datagram packet.
 * @exception  java.net.PortUnreachableException may be thrown if the socket is connected
 *       to a currently unreachable destination. Note, there is no guarantee that the
 *       exception will be thrown.
 * @apiSince 1
 */

protected abstract void receive(java.net.DatagramPacket p) throws java.io.IOException;

/**
 * Set the TTL (time-to-live) option.
 * @param ttl a byte specifying the TTL value
 *
 * @deprecated use setTimeToLive instead.
 * @exception java.io.IOException if an I/O exception occurs while setting
 * the time-to-live option.
 * @see #getTTL()
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected abstract void setTTL(byte ttl) throws java.io.IOException;

/**
 * Retrieve the TTL (time-to-live) option.
 *
 * @exception java.io.IOException if an I/O exception occurs
 * while retrieving the time-to-live option
 * @deprecated use getTimeToLive instead.
 * @return a byte representing the TTL value
 * @see #setTTL(byte)
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected abstract byte getTTL() throws java.io.IOException;

/**
 * Set the TTL (time-to-live) option.
 * @param ttl an {@code int} specifying the time-to-live value
 * @exception java.io.IOException if an I/O exception occurs
 * while setting the time-to-live option.
 * @see #getTimeToLive()
 * @apiSince 1
 */

protected abstract void setTimeToLive(int ttl) throws java.io.IOException;

/**
 * Retrieve the TTL (time-to-live) option.
 * @exception java.io.IOException if an I/O exception occurs
 * while retrieving the time-to-live option
 * @return an {@code int} representing the time-to-live value
 * @see #setTimeToLive(int)
 * @apiSince 1
 */

protected abstract int getTimeToLive() throws java.io.IOException;

/**
 * Join the multicast group.
 * @param inetaddr multicast address to join.
 * @exception java.io.IOException if an I/O exception occurs
 * while joining the multicast group.
 * @apiSince 1
 */

protected abstract void join(java.net.InetAddress inetaddr) throws java.io.IOException;

/**
 * Leave the multicast group.
 * @param inetaddr multicast address to leave.
 * @exception java.io.IOException if an I/O exception occurs
 * while leaving the multicast group.
 * @apiSince 1
 */

protected abstract void leave(java.net.InetAddress inetaddr) throws java.io.IOException;

/**
 * Join the multicast group.
 * @param mcastaddr address to join.
 * @param netIf specifies the local interface to receive multicast
 *        datagram packets
 * @throws java.io.IOException if an I/O exception occurs while joining
 * the multicast group
 * @since 1.4
 * @apiSince 1
 */

protected abstract void joinGroup(java.net.SocketAddress mcastaddr, java.net.NetworkInterface netIf) throws java.io.IOException;

/**
 * Leave the multicast group.
 * @param mcastaddr address to leave.
 * @param netIf specified the local interface to leave the group at
 * @throws java.io.IOException if an I/O exception occurs while leaving
 * the multicast group
 * @since 1.4
 * @apiSince 1
 */

protected abstract void leaveGroup(java.net.SocketAddress mcastaddr, java.net.NetworkInterface netIf) throws java.io.IOException;

/**
 * Close the socket.
 * @apiSince 1
 */

protected abstract void close();

/**
 * Gets the local port.
 * @return an {@code int} representing the local port value
 * @apiSince 1
 */

protected int getLocalPort() { throw new RuntimeException("Stub!"); }

/**
 * Gets the datagram socket file descriptor.
 * @return a {@code FileDescriptor} object representing the datagram socket
 * file descriptor
 * @apiSince 1
 */

protected java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * The file descriptor object.
 * @apiSince 1
 */

protected java.io.FileDescriptor fd;

/**
 * The local port number.
 * @apiSince 1
 */

protected int localPort;
}

