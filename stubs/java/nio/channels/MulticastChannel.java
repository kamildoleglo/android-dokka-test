/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.channels;

import java.net.StandardSocketOptions;
import java.net.ProtocolFamily;
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.net.StandardProtocolFamily;
import java.io.IOException;

/**
 * A network channel that supports Internet Protocol (IP) multicasting.
 *
 * <p> IP multicasting is the transmission of IP datagrams to members of
 * a <em>group</em> that is zero or more hosts identified by a single destination
 * address.
 *
 * <p> In the case of a channel to an {@link java.net.StandardProtocolFamily#INET StandardProtocolFamily#INET} socket,
 * the underlying operating system supports <a href="http://www.ietf.org/rfc/rfc2236.txt">
 * <i>RFC&nbsp;2236: Internet Group Management Protocol, Version 2 (IGMPv2)</i></a>.
 * It may optionally support source filtering as specified by <a
 * href="http://www.ietf.org/rfc/rfc3376.txt"> <i>RFC&nbsp;3376: Internet Group
 * Management Protocol, Version 3 (IGMPv3)</i></a>.
 * For channels to an {@link java.net.StandardProtocolFamily#INET6 StandardProtocolFamily#INET6} socket, the equivalent
 * standards are <a href="http://www.ietf.org/rfc/rfc2710.txt"> <i>RFC&nbsp;2710:
 * Multicast Listener Discovery (MLD) for IPv6</i></a> and <a
 * href="http://www.ietf.org/rfc/rfc3810.txt"> <i>RFC&nbsp;3810: Multicast Listener
 * Discovery Version 2 (MLDv2) for IPv6</i></a>.
 *
 * <p> The {@link #join(java.net.InetAddress,java.net.NetworkInterface)} method is used to
 * join a group and receive all multicast datagrams sent to the group. A channel
 * may join several multicast groups and may join the same group on several
 * {@link java.net.NetworkInterface NetworkInterface}. Membership is dropped by invoking the {@link java.nio.channels.MembershipKey#drop MembershipKey#drop} method on the returned {@link java.nio.channels.MembershipKey MembershipKey}. If the
 * underlying platform supports source filtering then the {@link java.nio.channels.MembershipKey#block MembershipKey#block} and {@link java.nio.channels.MembershipKey#unblock MembershipKey#unblock} methods can be used to block or
 * unblock multicast datagrams from particular source addresses.
 *
 * <p> The {@link #join(java.net.InetAddress,java.net.NetworkInterface,java.net.InetAddress)} method
 * is used to begin receiving datagrams sent to a group whose source address matches
 * a given source address. This method throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}
 * if the underlying platform does not support source filtering.  Membership is
 * <em>cumulative</em> and this method may be invoked again with the same group
 * and interface to allow receiving datagrams from other source addresses. The
 * method returns a {@link java.nio.channels.MembershipKey MembershipKey} that represents membership to receive
 * datagrams from the given source address. Invoking the key's {@link java.nio.channels.MembershipKey#drop MembershipKey#drop} method drops membership so that datagrams from the
 * source address can no longer be received.
 *
 * <h2>Platform dependencies</h2>
 *
 * The multicast implementation is intended to map directly to the native
 * multicasting facility. Consequently, the following items should be considered
 * when developing an application that receives IP multicast datagrams:
 *
 * <ol>
 *
 * <li><p> The creation of the channel should specify the {@link java.net.ProtocolFamily ProtocolFamily}
 * that corresponds to the address type of the multicast groups that the channel
 * will join. There is no guarantee that a channel to a socket in one protocol
 * family can join and receive multicast datagrams when the address of the
 * multicast group corresponds to another protocol family. For example, it is
 * implementation specific if a channel to an {@link java.net.StandardProtocolFamily#INET6 StandardProtocolFamily#INET6}
 * socket can join an {@link java.net.StandardProtocolFamily#INET StandardProtocolFamily#INET} multicast group and receive
 * multicast datagrams sent to the group. </p></li>
 *
 * <li><p> The channel's socket should be bound to the {@link java.net.InetAddress#isAnyLocalAddress InetAddress#isAnyLocalAddress} address. If the socket is bound to
 * a specific address, rather than the wildcard address then it is implementation
 * specific if multicast datagrams are received by the socket. </p></li>
 *
 * <li><p> The {@link java.net.StandardSocketOptions#SO_REUSEADDR StandardSocketOptions#SO_REUSEADDR} option should be
 * enabled prior to {@link java.nio.channels.NetworkChannel#bind NetworkChannel#bind} the socket. This is
 * required to allow multiple members of the group to bind to the same
 * address. </p></li>
 *
 * </ol>
 *
 * <p> <b>Usage Example:</b>
 * <pre>
 *     // join multicast group on this interface, and also use this
 *     // interface for outgoing multicast datagrams
 *     NetworkInterface ni = NetworkInterface.getByName("hme0");
 *
 *     DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET)
 *         .setOption(StandardSocketOptions.SO_REUSEADDR, true)
 *         .bind(new InetSocketAddress(5000))
 *         .setOption(StandardSocketOptions.IP_MULTICAST_IF, ni);
 *
 *     InetAddress group = InetAddress.getByName("225.4.5.6");
 *
 *     MembershipKey key = dc.join(group, ni);
 * </pre>
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface MulticastChannel extends java.nio.channels.NetworkChannel {

/**
 * Closes this channel.
 *
 * <p> If the channel is a member of a multicast group then the membership
 * is {@link java.nio.channels.MembershipKey#drop MembershipKey#drop}. Upon return, the {@link java.nio.channels.MembershipKey MembershipKey} will be {@link java.nio.channels.MembershipKey#isValid MembershipKey#isValid}.
 *
 * <p> This method otherwise behaves exactly as specified by the {@link java.nio.channels.Channel Channel} interface.
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public void close() throws java.io.IOException;

/**
 * Joins a multicast group to begin receiving all datagrams sent to the group,
 * returning a membership key.
 *
 * <p> If this channel is currently a member of the group on the given
 * interface to receive all datagrams then the membership key, representing
 * that membership, is returned. Otherwise this channel joins the group and
 * the resulting new membership key is returned. The resulting membership key
 * is not {@link java.nio.channels.MembershipKey#sourceAddress MembershipKey#sourceAddress}.
 *
 * <p> A multicast channel may join several multicast groups, including
 * the same group on more than one interface. An implementation may impose a
 * limit on the number of groups that may be joined at the same time.
 *
 * @param   group
 *          The multicast address to join
 * @param   interf
 *          The network interface on which to join the group
 *
 * @return  The membership key
 *
 * @throws  java.lang.IllegalArgumentException
 *          If the group parameter is not a {@link java.net.InetAddress#isMulticastAddress InetAddress#isMulticastAddress} address, or the group parameter is an address type
 *          that is not supported by this channel
 * @throws  java.lang.IllegalStateException
 *          If the channel already has source-specific membership of the
 *          group on the interface
 * @throws  java.lang.UnsupportedOperationException
 *          If the channel's socket is not an Internet Protocol socket
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @throws  java.lang.SecurityException
 *          If a security manager is set, and its
 *          {@link java.lang.SecurityManager#checkMulticast(java.net.InetAddress) SecurityManager#checkMulticast(InetAddress)}
 *          method denies access to the multiast group
 * @apiSince 26
 */

public java.nio.channels.MembershipKey join(java.net.InetAddress group, java.net.NetworkInterface interf) throws java.io.IOException;

/**
 * Joins a multicast group to begin receiving datagrams sent to the group
 * from a given source address.
 *
 * <p> If this channel is currently a member of the group on the given
 * interface to receive datagrams from the given source address then the
 * membership key, representing that membership, is returned. Otherwise this
 * channel joins the group and the resulting new membership key is returned.
 * The resulting membership key is {@link java.nio.channels.MembershipKey#sourceAddress MembershipKey#sourceAddress}.
 *
 * <p> Membership is <em>cumulative</em> and this method may be invoked
 * again with the same group and interface to allow receiving datagrams sent
 * by other source addresses to the group.
 *
 * @param   group
 *          The multicast address to join
 * @param   interf
 *          The network interface on which to join the group
 * @param   source
 *          The source address
 *
 * @return  The membership key
 *
 * @throws  java.lang.IllegalArgumentException
 *          If the group parameter is not a {@link java.net.InetAddress#isMulticastAddress InetAddress#isMulticastAddress} address, the
 *          source parameter is not a unicast address, the group
 *          parameter is an address type that is not supported by this channel,
 *          or the source parameter is not the same address type as the group
 * @throws  java.lang.IllegalStateException
 *          If the channel is currently a member of the group on the given
 *          interface to receive all datagrams
 * @throws  java.lang.UnsupportedOperationException
 *          If the channel's socket is not an Internet Protocol socket or
 *          source filtering is not supported
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @throws  java.lang.SecurityException
 *          If a security manager is set, and its
 *          {@link java.lang.SecurityManager#checkMulticast(java.net.InetAddress) SecurityManager#checkMulticast(InetAddress)}
 *          method denies access to the multiast group
 * @apiSince 26
 */

public java.nio.channels.MembershipKey join(java.net.InetAddress group, java.net.NetworkInterface interf, java.net.InetAddress source) throws java.io.IOException;
}

