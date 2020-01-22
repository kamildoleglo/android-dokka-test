/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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



package javax.net.ssl;


/**
 * Instances of this class represent a matcher that performs match
 * operations on an {@link javax.net.ssl.SNIServerName SNIServerName} instance.
 * <P>
 * Servers can use Server Name Indication (SNI) information to decide if
 * specific {@link javax.net.ssl.SSLSocket SSLSocket} or {@link javax.net.ssl.SSLEngine SSLEngine} instances should accept
 * a connection.  For example, when multiple "virtual" or "name-based"
 * servers are hosted on a single underlying network address, the server
 * application can use SNI information to determine whether this server is
 * the exact server that the client wants to access.  Instances of this
 * class can be used by a server to verify the acceptable server names of
 * a particular type, such as host names.
 * <P>
 * {@code SNIMatcher} objects are immutable.  Subclasses should not provide
 * methods that can change the state of an instance once it has been created.
 *
 * @see javax.net.ssl.SNIServerName
 * @see javax.net.ssl.SNIHostName
 * @see javax.net.ssl.SSLParameters#getSNIMatchers()
 * @see SSLParameters#setSNIMatchers(Collection)
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SNIMatcher {

/**
 * Creates an {@code SNIMatcher} using the specified server name type.
 *
 * @param  type
 *         the type of the server name that this matcher performs on
 *
 * @throws java.lang.IllegalArgumentException if {@code type} is not in the range
 *         of 0 to 255, inclusive.
 * @apiSince 24
 */

protected SNIMatcher(int type) { throw new RuntimeException("Stub!"); }

/**
 * Returns the server name type of this {@code SNIMatcher} object.
 *
 * @return the server name type of this {@code SNIMatcher} object.
 *
 * @see javax.net.ssl.SNIServerName
 * @apiSince 24
 */

public final int getType() { throw new RuntimeException("Stub!"); }

/**
 * Attempts to match the given {@link javax.net.ssl.SNIServerName SNIServerName}.
 *
 * @param  serverName
 *         the {@link javax.net.ssl.SNIServerName SNIServerName} instance on which this matcher
 *         performs match operations
 *
 * @return {@code true} if, and only if, the matcher matches the
 *         given {@code serverName}
 *
 * @throws java.lang.NullPointerException if {@code serverName} is {@code null}
 * @throws java.lang.IllegalArgumentException if {@code serverName} is
 *         not of the given server name type of this matcher
 *
 * @see javax.net.ssl.SNIServerName
 * @apiSince 24
 */

public abstract boolean matches(javax.net.ssl.SNIServerName serverName);
}

