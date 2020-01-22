/*
 * Copyright (c) 1995, 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * The multicast datagram socket class is useful for sending
 * and receiving IP multicast packets.  A MulticastSocket is
 * a (UDP) DatagramSocket, with additional capabilities for
 * joining "groups" of other multicast hosts on the internet.
 * <P>
 * A multicast group is specified by a class D IP address
 * and by a standard UDP port number. Class D IP addresses
 * are in the range <CODE>224.0.0.0</CODE> to <CODE>239.255.255.255</CODE>,
 * inclusive. The address 224.0.0.0 is reserved and should not be used.
 * <P>
 * One would join a multicast group by first creating a MulticastSocket
 * with the desired port, then invoking the
 * <CODE>joinGroup(InetAddress groupAddr)</CODE>
 * method:
 * <PRE>
 * // join a Multicast group and send the group salutations
 * ...
 * String msg = "Hello";
 * InetAddress group = InetAddress.getByName("228.5.6.7");
 * MulticastSocket s = new MulticastSocket(6789);
 * s.joinGroup(group);
 * byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
 * DatagramPacket hi = new DatagramPacket(bytes, bytes.length,
 *                             group, 6789);
 * s.send(hi);
 * // get their responses!
 * byte[] buf = new byte[1000];
 * DatagramPacket recv = new DatagramPacket(buf, buf.length);
 * s.receive(recv);
 * ...
 * // OK, I'm done talking - leave the group...
 * s.leaveGroup(group);
 * </PRE>
 *
 * When one sends a message to a multicast group, <B>all</B> subscribing
 * recipients to that host and port receive the message (within the
 * time-to-live range of the packet, see below).  The socket needn't
 * be a member of the multicast group to send messages to it.
 * <P>
 * When a socket subscribes to a multicast group/port, it receives
 * datagrams sent by other hosts to the group/port, as do all other
 * members of the group and port.  A socket relinquishes membership
 * in a group by the leaveGroup(InetAddress addr) method.  <B>
 * Multiple MulticastSocket's</B> may subscribe to a multicast group
 * and port concurrently, and they will all receive group datagrams.
 * <P>
 * Currently applets are not allowed to use multicast sockets.
 *
 * @author Pavani Diwanji
 * @since  JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MulticastSocket extends java.net.DatagramSocket {

/**
 * Create a multicast socket.
 *
 * <p>If there is a security manager,
 * its {@code checkListen} method is first called
 * with 0 as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 * <p>
 * When the socket is created the
 * {@link java.net.DatagramSocket#setReuseAddress(boolean) DatagramSocket#setReuseAddress(boolean)} method is
 * called to enable the SO_REUSEADDR socket option.
 *
 * @exception java.io.IOException if an I/O exception occurs
 * while creating the MulticastSocket
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 * @see java.lang.SecurityManager#checkListen
 * @see java.net.DatagramSocket#setReuseAddress(boolean)
 * @apiSince 1
 */

public MulticastSocket() throws java.io.IOException { super((java.net.DatagramSocketImpl)null); throw new RuntimeException("Stub!"); }

/**
 * Create a multicast socket and bind it to a specific port.
 *
 * <p>If there is a security manager,
 * its {@code checkListen} method is first called
 * with the {@code port} argument
 * as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 * <p>
 * When the socket is created the
 * {@link java.net.DatagramSocket#setReuseAddress(boolean) DatagramSocket#setReuseAddress(boolean)} method is
 * called to enable the SO_REUSEADDR socket option.
 *
 * @param port port to use
 * @exception java.io.IOException if an I/O exception occurs
 * while creating the MulticastSocket
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 * @see java.lang.SecurityManager#checkListen
 * @see java.net.DatagramSocket#setReuseAddress(boolean)
 * @apiSince 1
 */

public MulticastSocket(int port) throws java.io.IOException { super((java.net.DatagramSocketImpl)null); throw new RuntimeException("Stub!"); }

/**
 * Create a MulticastSocket bound to the specified socket address.
 * <p>
 * Or, if the address is {@code null}, create an unbound socket.
 *
 * <p>If there is a security manager,
 * its {@code checkListen} method is first called
 * with the SocketAddress port as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 * <p>
 * When the socket is created the
 * {@link java.net.DatagramSocket#setReuseAddress(boolean) DatagramSocket#setReuseAddress(boolean)} method is
 * called to enable the SO_REUSEADDR socket option.
 *
 * @param bindaddr Socket address to bind to, or {@code null} for
 *                 an unbound socket.
 * @exception java.io.IOException if an I/O exception occurs
 * while creating the MulticastSocket
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 * @see java.lang.SecurityManager#checkListen
 * @see java.net.DatagramSocket#setReuseAddress(boolean)
 *
 * @since 1.4
 * @apiSince 1
 */

public MulticastSocket(java.net.SocketAddress bindaddr) throws java.io.IOException { super((java.net.DatagramSocketImpl)null); throw new RuntimeException("Stub!"); }

/**
 * Set the default time-to-live for multicast packets sent out
 * on this {@code MulticastSocket} in order to control the
 * scope of the multicasts.
 *
 * <p>The ttl is an <b>unsigned</b> 8-bit quantity, and so <B>must</B> be
 * in the range {@code 0 <= ttl <= 0xFF }.
 *
 * @param ttl the time-to-live
 * @exception java.io.IOException if an I/O exception occurs
 * while setting the default time-to-live value
 * @deprecated use the setTimeToLive method instead, which uses
 * <b>int</b> instead of <b>byte</b> as the type for ttl.
 * @see #getTTL()
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setTTL(byte ttl) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Set the default time-to-live for multicast packets sent out
 * on this {@code MulticastSocket} in order to control the
 * scope of the multicasts.
 *
 * <P> The ttl <B>must</B> be in the range {@code  0 <= ttl <=
 * 255} or an {@code IllegalArgumentException} will be thrown.
 * Multicast packets sent with a TTL of {@code 0} are not transmitted
 * on the network but may be delivered locally.
 *
 * @param  ttl
 *         the time-to-live
 *
 * @throws  java.io.IOException
 *          if an I/O exception occurs while setting the
 *          default time-to-live value
 *
 * @see #getTimeToLive()
 * @apiSince 1
 */

public void setTimeToLive(int ttl) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Get the default time-to-live for multicast packets sent out on
 * the socket.
 *
 * @exception java.io.IOException if an I/O exception occurs
 * while getting the default time-to-live value
 * @return the default time-to-live value
 * @deprecated use the getTimeToLive method instead, which returns
 * an <b>int</b> instead of a <b>byte</b>.
 * @see #setTTL(byte)
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public byte getTTL() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Get the default time-to-live for multicast packets sent out on
 * the socket.
 * @exception java.io.IOException if an I/O exception occurs while
 * getting the default time-to-live value
 * @return the default time-to-live value
 * @see #setTimeToLive(int)
 * @apiSince 1
 */

public int getTimeToLive() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Joins a multicast group. Its behavior may be affected by
 * {@code setInterface} or {@code setNetworkInterface}.
 *
 * <p>If there is a security manager, this method first
 * calls its {@code checkMulticast} method
 * with the {@code mcastaddr} argument
 * as its argument.
 *
 * @param mcastaddr is the multicast address to join
 *
 * @exception java.io.IOException if there is an error joining
 * or when the address is not a multicast address.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 * {@code checkMulticast} method doesn't allow the join.
 *
 * @see java.lang.SecurityManager#checkMulticast(InetAddress)
 * @apiSince 1
 */

public void joinGroup(java.net.InetAddress mcastaddr) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Leave a multicast group. Its behavior may be affected by
 * {@code setInterface} or {@code setNetworkInterface}.
 *
 * <p>If there is a security manager, this method first
 * calls its {@code checkMulticast} method
 * with the {@code mcastaddr} argument
 * as its argument.
 *
 * @param mcastaddr is the multicast address to leave
 * @exception java.io.IOException if there is an error leaving
 * or when the address is not a multicast address.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 * {@code checkMulticast} method doesn't allow the operation.
 *
 * @see java.lang.SecurityManager#checkMulticast(InetAddress)
 * @apiSince 1
 */

public void leaveGroup(java.net.InetAddress mcastaddr) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Joins the specified multicast group at the specified interface.
 *
 * <p>If there is a security manager, this method first
 * calls its {@code checkMulticast} method
 * with the {@code mcastaddr} argument
 * as its argument.
 *
 * @param mcastaddr is the multicast address to join
 * @param netIf specifies the local interface to receive multicast
 *        datagram packets, or <i>null</i> to defer to the interface set by
 *       {@link java.net.MulticastSocket#setInterface(java.net.InetAddress) MulticastSocket#setInterface(InetAddress)} or
 *       {@link java.net.MulticastSocket#setNetworkInterface(java.net.NetworkInterface) MulticastSocket#setNetworkInterface(NetworkInterface)}
 *
 * @exception java.io.IOException if there is an error joining
 * or when the address is not a multicast address.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 * {@code checkMulticast} method doesn't allow the join.
 * @throws  java.lang.IllegalArgumentException if mcastaddr is null or is a
 *          SocketAddress subclass not supported by this socket
 *
 * @see java.lang.SecurityManager#checkMulticast(InetAddress)
 * @since 1.4
 * @apiSince 1
 */

public void joinGroup(java.net.SocketAddress mcastaddr, java.net.NetworkInterface netIf) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Leave a multicast group on a specified local interface.
 *
 * <p>If there is a security manager, this method first
 * calls its {@code checkMulticast} method
 * with the {@code mcastaddr} argument
 * as its argument.
 *
 * @param mcastaddr is the multicast address to leave
 * @param netIf specifies the local interface or <i>null</i> to defer
 *             to the interface set by
 *             {@link java.net.MulticastSocket#setInterface(java.net.InetAddress) MulticastSocket#setInterface(InetAddress)} or
 *             {@link java.net.MulticastSocket#setNetworkInterface(java.net.NetworkInterface) MulticastSocket#setNetworkInterface(NetworkInterface)}
 * @exception java.io.IOException if there is an error leaving
 * or when the address is not a multicast address.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 * {@code checkMulticast} method doesn't allow the operation.
 * @throws  java.lang.IllegalArgumentException if mcastaddr is null or is a
 *          SocketAddress subclass not supported by this socket
 *
 * @see java.lang.SecurityManager#checkMulticast(InetAddress)
 * @since 1.4
 * @apiSince 1
 */

public void leaveGroup(java.net.SocketAddress mcastaddr, java.net.NetworkInterface netIf) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Set the multicast network interface used by methods
 * whose behavior would be affected by the value of the
 * network interface. Useful for multihomed hosts.
 * @param inf the InetAddress
 * @exception java.net.SocketException if there is an error in
 * the underlying protocol, such as a TCP error.
 * @see #getInterface()
 * @apiSince 1
 */

public void setInterface(java.net.InetAddress inf) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the address of the network interface used for
 * multicast packets.
 *
 * @return An {@code InetAddress} representing
 *  the address of the network interface used for
 *  multicast packets.
 *
 * @exception java.net.SocketException if there is an error in
 * the underlying protocol, such as a TCP error.
 *
 * @see #setInterface(java.net.InetAddress)
 * @apiSince 1
 */

public java.net.InetAddress getInterface() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Specify the network interface for outgoing multicast datagrams
 * sent on this socket.
 *
 * @param netIf the interface
 * @exception java.net.SocketException if there is an error in
 * the underlying protocol, such as a TCP error.
 * @see #getNetworkInterface()
 * @since 1.4
 * @apiSince 1
 */

public void setNetworkInterface(java.net.NetworkInterface netIf) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Get the multicast network interface set.
 *
 * @exception java.net.SocketException if there is an error in
 * the underlying protocol, such as a TCP error.
 * @return the multicast {@code NetworkInterface} currently set
 * @see #setNetworkInterface(NetworkInterface)
 * @since 1.4
 * @apiSince 1
 */

public java.net.NetworkInterface getNetworkInterface() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Disable/Enable local loopback of multicast datagrams
 * The option is used by the platform's networking code as a hint
 * for setting whether multicast data will be looped back to
 * the local socket.
 *
 * <p>Because this option is a hint, applications that want to
 * verify what loopback mode is set to should call
 * {@link #getLoopbackMode()}
 * @param disable {@code true} to disable the LoopbackMode
 * @throws java.net.SocketException if an error occurs while setting the value
 * @since 1.4
 * @see #getLoopbackMode
 * @apiSince 1
 */

public void setLoopbackMode(boolean disable) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Get the setting for local loopback of multicast datagrams.
 *
 * @throws java.net.SocketException  if an error occurs while getting the value
 * @return true if the LoopbackMode has been disabled
 * @since 1.4
 * @see #setLoopbackMode
 * @apiSince 1
 */

public boolean getLoopbackMode() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Sends a datagram packet to the destination, with a TTL (time-
 * to-live) other than the default for the socket.  This method
 * need only be used in instances where a particular TTL is desired;
 * otherwise it is preferable to set a TTL once on the socket, and
 * use that default TTL for all packets.  This method does <B>not
 * </B> alter the default TTL for the socket. Its behavior may be
 * affected by {@code setInterface}.
 *
 * <p>If there is a security manager, this method first performs some
 * security checks. First, if {@code p.getAddress().isMulticastAddress()}
 * is true, this method calls the
 * security manager's {@code checkMulticast} method
 * with {@code p.getAddress()} and {@code ttl} as its arguments.
 * If the evaluation of that expression is false,
 * this method instead calls the security manager's
 * {@code checkConnect} method with arguments
 * {@code p.getAddress().getHostAddress()} and
 * {@code p.getPort()}. Each call to a security manager method
 * could result in a SecurityException if the operation is not allowed.
 *
 * @param p is the packet to be sent. The packet should contain
 * the destination multicast ip address and the data to be sent.
 * One does not need to be the member of the group to send
 * packets to a destination multicast address.
 * @param ttl optional time to live for multicast packet.
 * default ttl is 1.
 *
 * @exception java.io.IOException is raised if an error occurs i.e
 * error while setting ttl.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkMulticast} or {@code checkConnect}
 *             method doesn't allow the send.
 *
 * @deprecated Use the following code or its equivalent instead:
 *  ......
 *  int ttl = mcastSocket.getTimeToLive();
 *  mcastSocket.setTimeToLive(newttl);
 *  mcastSocket.send(p);
 *  mcastSocket.setTimeToLive(ttl);
 *  ......
 *
 * @see java.net.DatagramSocket#send
 * @see java.net.DatagramSocket#receive
 * @see java.lang.SecurityManager#checkMulticast(java.net.InetAddress, byte)
 * @see SecurityManager#checkConnect
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void send(java.net.DatagramPacket p, byte ttl) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

