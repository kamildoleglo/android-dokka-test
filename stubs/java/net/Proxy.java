/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * This class represents a proxy setting, typically a type (http, socks) and
 * a socket address.
 * A {@code Proxy} is an immutable object.
 *
 * @see     java.net.ProxySelector
 * @author Yingxian Wang
 * @author Jean-Christophe Collet
 * @since   1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Proxy {

/**
 * Creates an entry representing a PROXY connection.
 * Certain combinations are illegal. For instance, for types Http, and
 * Socks, a SocketAddress <b>must</b> be provided.
 * <P>
 * Use the {@code Proxy.NO_PROXY} constant
 * for representing a direct connection.
 *
 * @param type the {@code Type} of the proxy
 * @param sa the {@code SocketAddress} for that proxy
 * @throws java.lang.IllegalArgumentException when the type and the address are
 * incompatible
 * @apiSince 1
 */

public Proxy(java.net.Proxy.Type type, java.net.SocketAddress sa) { throw new RuntimeException("Stub!"); }

/**
 * Returns the proxy type.
 *
 * @return a Type representing the proxy type
 * @apiSince 1
 */

public java.net.Proxy.Type type() { throw new RuntimeException("Stub!"); }

/**
 * Returns the socket address of the proxy, or
 * {@code null} if its a direct connection.
 *
 * @return a {@code SocketAddress} representing the socket end
 *         point of the proxy
 * @apiSince 1
 */

public java.net.SocketAddress address() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string representation of this Proxy.
 * This String is constructed by calling toString() on its type
 * and concatenating " @ " and the toString() result from its address
 * if its type is not {@code DIRECT}.
 *
 * @return  a string representation of this object.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Compares this object against the specified object.
 * The result is {@code true} if and only if the argument is
 * not {@code null} and it represents the same proxy as
 * this object.
 * <p>
 * Two instances of {@code Proxy} represent the same
 * address if both the SocketAddresses and type are equal.
 *
 * @param   obj   the object to compare against.
 * @return  {@code true} if the objects are the same;
 *          {@code false} otherwise.
 * @see java.net.InetSocketAddress#equals(java.lang.Object)
 * @apiSince 1
 */

public final boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode for this Proxy.
 *
 * @return  a hash code value for this Proxy.
 * @apiSince 1
 */

public final int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * A proxy setting that represents a {@code DIRECT} connection,
 * basically telling the protocol handler not to use any proxying.
 * Used, for instance, to create sockets bypassing any other global
 * proxy settings (like SOCKS):
 * <P>
 * {@code Socket s = new Socket(Proxy.NO_PROXY);}
 *
 * @apiSince 1
 */

public static final java.net.Proxy NO_PROXY;
static { NO_PROXY = null; }
/**
 * Represents the proxy type.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Type {
/**
 * Represents a direct connection, or the absence of a proxy.
 * @apiSince 1
 */

DIRECT,
/**
 * Represents proxy for high level protocols such as HTTP or FTP.
 * @apiSince 1
 */

HTTP,
/**
 * Represents a SOCKS (V4 or V5) proxy.
 * @apiSince 1
 */

SOCKS;
}

}

