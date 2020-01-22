/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * The abstract class {@code SocketImpl} is a common superclass
 * of all classes that actually implement sockets. It is used to
 * create both client and server sockets.
 * <p>
 * A "plain" socket implements these methods exactly as
 * described, without attempting to go through a firewall or proxy.
 *
 * @author  unascribed
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SocketImpl implements java.net.SocketOptions {

/** @apiSince 1 */

public SocketImpl() { throw new RuntimeException("Stub!"); }

/**
 * Creates either a stream or a datagram socket.
 *
 * @param      stream   if {@code true}, create a stream socket;
 *                      otherwise, create a datagram socket.
 * @exception  java.io.IOException  if an I/O error occurs while creating the
 *               socket.
 * @apiSince 1
 */

protected abstract void create(boolean stream) throws java.io.IOException;

/**
 * Connects this socket to the specified port on the named host.
 *
 * @param      host   the name of the remote host.
 * @param      port   the port number.
 * @exception  java.io.IOException  if an I/O error occurs when connecting to the
 *               remote host.
 * @apiSince 1
 */

protected abstract void connect(java.lang.String host, int port) throws java.io.IOException;

/**
 * Connects this socket to the specified port number on the specified host.
 *
 * @param      address   the IP address of the remote host.
 * @param      port      the port number.
 * @exception  java.io.IOException  if an I/O error occurs when attempting a
 *               connection.
 * @apiSince 1
 */

protected abstract void connect(java.net.InetAddress address, int port) throws java.io.IOException;

/**
 * Connects this socket to the specified port number on the specified host.
 * A timeout of zero is interpreted as an infinite timeout. The connection
 * will then block until established or an error occurs.
 *
 * @param      address   the Socket address of the remote host.
 * @param     timeout  the timeout value, in milliseconds, or zero for no timeout.
 * @exception  java.io.IOException  if an I/O error occurs when attempting a
 *               connection.
 * @since 1.4
 * @apiSince 1
 */

protected abstract void connect(java.net.SocketAddress address, int timeout) throws java.io.IOException;

/**
 * Binds this socket to the specified local IP address and port number.
 *
 * @param      host   an IP address that belongs to a local interface.
 * @param      port   the port number.
 * @exception  java.io.IOException  if an I/O error occurs when binding this socket.
 * @apiSince 1
 */

protected abstract void bind(java.net.InetAddress host, int port) throws java.io.IOException;

/**
 * Sets the maximum queue length for incoming connection indications
 * (a request to connect) to the {@code count} argument. If a
 * connection indication arrives when the queue is full, the
 * connection is refused.
 *
 * @param      backlog   the maximum length of the queue.
 * @exception  java.io.IOException  if an I/O error occurs when creating the queue.
 * @apiSince 1
 */

protected abstract void listen(int backlog) throws java.io.IOException;

/**
 * Accepts a connection.
 *
 * @param      s   the accepted connection.
 * @exception  java.io.IOException  if an I/O error occurs when accepting the
 *               connection.
 * @apiSince 1
 */

protected abstract void accept(java.net.SocketImpl s) throws java.io.IOException;

/**
 * Returns an input stream for this socket.
 *
 * @return     a stream for reading from this socket.
 * @exception  java.io.IOException  if an I/O error occurs when creating the
 *               input stream.
 * @apiSince 1
 */

protected abstract java.io.InputStream getInputStream() throws java.io.IOException;

/**
 * Returns an output stream for this socket.
 *
 * @return     an output stream for writing to this socket.
 * @exception  java.io.IOException  if an I/O error occurs when creating the
 *               output stream.
 * @apiSince 1
 */

protected abstract java.io.OutputStream getOutputStream() throws java.io.IOException;

/**
 * Returns the number of bytes that can be read from this socket
 * without blocking.
 *
 * @return     the number of bytes that can be read from this socket
 *             without blocking.
 * @exception  java.io.IOException  if an I/O error occurs when determining the
 *               number of bytes available.
 * @apiSince 1
 */

protected abstract int available() throws java.io.IOException;

/**
 * Closes this socket.
 *
 * @exception  java.io.IOException  if an I/O error occurs when closing this socket.
 * @apiSince 1
 */

protected abstract void close() throws java.io.IOException;

/**
 * Places the input stream for this socket at "end of stream".
 * Any data sent to this socket is acknowledged and then
 * silently discarded.
 *
 * If you read from a socket input stream after invoking this method on the
 * socket, the stream's {@code available} method will return 0, and its
 * {@code read} methods will return {@code -1} (end of stream).
 *
 * @exception java.io.IOException if an I/O error occurs when shutting down this
 * socket.
 * @see java.net.Socket#shutdownOutput()
 * @see java.net.Socket#close()
 * @see java.net.Socket#setSoLinger(boolean, int)
 * @since 1.3
 * @apiSince 1
 */

protected void shutdownInput() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Disables the output stream for this socket.
 * For a TCP socket, any previously written data will be sent
 * followed by TCP's normal connection termination sequence.
 *
 * If you write to a socket output stream after invoking
 * shutdownOutput() on the socket, the stream will throw
 * an IOException.
 *
 * @exception java.io.IOException if an I/O error occurs when shutting down this
 * socket.
 * @see java.net.Socket#shutdownInput()
 * @see java.net.Socket#close()
 * @see java.net.Socket#setSoLinger(boolean, int)
 * @since 1.3
 * @apiSince 1
 */

protected void shutdownOutput() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this socket's {@code fd} field.
 *
 * @return  the value of this socket's {@code fd} field.
 * @see     java.net.SocketImpl#fd
 * @apiSince 1
 */

protected java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this socket's {@code address} field.
 *
 * @return  the value of this socket's {@code address} field.
 * @see     java.net.SocketImpl#address
 * @apiSince 1
 */

protected java.net.InetAddress getInetAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this socket's {@code port} field.
 *
 * @return  the value of this socket's {@code port} field.
 * @see     java.net.SocketImpl#port
 * @apiSince 1
 */

protected int getPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this SocketImpl supports sending
 * urgent data. By default, false is returned
 * unless the method is overridden in a sub-class
 *
 * @return  true if urgent data supported
 * @see     java.net.SocketImpl#address
 * @since 1.4
 * @apiSince 1
 */

protected boolean supportsUrgentData() { throw new RuntimeException("Stub!"); }

/**
 * Send one byte of urgent data on the socket.
 * The byte to be sent is the low eight bits of the parameter
 * @param data The byte of data to send
 * @exception java.io.IOException if there is an error
 *  sending the data.
 * @since 1.4
 * @apiSince 1
 */

protected abstract void sendUrgentData(int data) throws java.io.IOException;

/**
 * Returns the value of this socket's {@code localport} field.
 *
 * @return  the value of this socket's {@code localport} field.
 * @see     java.net.SocketImpl#localport
 * @apiSince 1
 */

protected int getLocalPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the address and port of this socket as a {@code String}.
 *
 * @return  a string representation of this socket.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Sets performance preferences for this socket.
 *
 * <p> Sockets use the TCP/IP protocol by default.  Some implementations
 * may offer alternative protocols which have different performance
 * characteristics than TCP/IP.  This method allows the application to
 * express its own preferences as to how these tradeoffs should be made
 * when the implementation chooses from the available protocols.
 *
 * <p> Performance preferences are described by three integers
 * whose values indicate the relative importance of short connection time,
 * low latency, and high bandwidth.  The absolute values of the integers
 * are irrelevant; in order to choose a protocol the values are simply
 * compared, with larger values indicating stronger preferences. Negative
 * values represent a lower priority than positive values. If the
 * application prefers short connection time over both low latency and high
 * bandwidth, for example, then it could invoke this method with the values
 * {@code (1, 0, 0)}.  If the application prefers high bandwidth above low
 * latency, and low latency above short connection time, then it could
 * invoke this method with the values {@code (0, 1, 2)}.
 *
 * By default, this method does nothing, unless it is overridden in a
 * a sub-class.
 *
 * @param  connectionTime
 *         An {@code int} expressing the relative importance of a short
 *         connection time
 *
 * @param  latency
 *         An {@code int} expressing the relative importance of low
 *         latency
 *
 * @param  bandwidth
 *         An {@code int} expressing the relative importance of high
 *         bandwidth
 *
 * @since 1.5
 * @apiSince 1
 */

protected void setPerformancePreferences(int connectionTime, int latency, int bandwidth) { throw new RuntimeException("Stub!"); }

/**
 * The IP address of the remote end of this socket.
 * @apiSince 1
 */

protected java.net.InetAddress address;

/**
 * The file descriptor object for this socket.
 * @apiSince 1
 */

protected java.io.FileDescriptor fd;

/**
 * The local port number to which this socket is connected.
 * @apiSince 1
 */

protected int localport;

/**
 * The port number on the remote host to which this socket is connected.
 * @apiSince 1
 */

protected int port;
}

