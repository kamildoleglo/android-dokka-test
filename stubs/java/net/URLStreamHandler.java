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
 * The abstract class {@code URLStreamHandler} is the common
 * superclass for all stream protocol handlers. A stream protocol
 * handler knows how to make a connection for a particular protocol
 * type, such as {@code http} or {@code https}.
 * <p>
 * In most cases, an instance of a {@code URLStreamHandler}
 * subclass is not created directly by an application. Rather, the
 * first time a protocol name is encountered when constructing a
 * {@code URL}, the appropriate stream protocol handler is
 * automatically loaded.
 *
 * @author  James Gosling
 * @see     java.net.URL#URL(java.lang.String, java.lang.String, int, java.lang.String)
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class URLStreamHandler {

/** @apiSince 1 */

public URLStreamHandler() { throw new RuntimeException("Stub!"); }

/**
 * Opens a connection to the object referenced by the
 * {@code URL} argument.
 * This method should be overridden by a subclass.
 *
 * <p>If for the handler's protocol (such as HTTP or JAR), there
 * exists a public, specialized URLConnection subclass belonging
 * to one of the following packages or one of their subpackages:
 * java.lang, java.io, java.util, java.net, the connection
 * returned will be of that subclass. For example, for HTTP an
 * HttpURLConnection will be returned, and for JAR a
 * JarURLConnection will be returned.
 *
 * @param      u   the URL that this connects to.
 * @return     a {@code URLConnection} object for the {@code URL}.
 * @exception  java.io.IOException  if an I/O error occurs while opening the
 *               connection.
 * @apiSince 1
 */

protected abstract java.net.URLConnection openConnection(java.net.URL u) throws java.io.IOException;

/**
 * Same as openConnection(URL), except that the connection will be
 * made through the specified proxy; Protocol handlers that do not
 * support proxying will ignore the proxy parameter and make a
 * normal connection.
 *
 * Calling this method preempts the system's default ProxySelector
 * settings.
 *
 * @param      u   the URL that this connects to.
 * @param      p   the proxy through which the connection will be made.
 *                 If direct connection is desired, Proxy.NO_PROXY
 *                 should be specified.
 * @return     a {@code URLConnection} object for the {@code URL}.
 * @exception  java.io.IOException  if an I/O error occurs while opening the
 *               connection.
 * @exception  java.lang.IllegalArgumentException if either u or p is null,
 *               or p has the wrong type.
 * @exception  java.lang.UnsupportedOperationException if the subclass that
 *               implements the protocol doesn't support this method.
 * @since      1.5
 * @apiSince 1
 */

protected java.net.URLConnection openConnection(java.net.URL u, java.net.Proxy p) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Parses the string representation of a {@code URL} into a
 * {@code URL} object.
 * <p>
 * If there is any inherited context, then it has already been
 * copied into the {@code URL} argument.
 * <p>
 * The {@code parseURL} method of {@code URLStreamHandler}
 * parses the string representation as if it were an
 * {@code http} specification. Most URL protocol families have a
 * similar parsing. A stream protocol handler for a protocol that has
 * a different syntax must override this routine.
 *
 * @param   u       the {@code URL} to receive the result of parsing
 *                  the spec.
 * @param   spec    the {@code String} representing the URL that
 *                  must be parsed.
 * @param   start   the character index at which to begin parsing. This is
 *                  just past the '{@code :}' (if there is one) that
 *                  specifies the determination of the protocol name.
 * @param   limit   the character position to stop parsing at. This is the
 *                  end of the string or the position of the
 *                  "{@code #}" character, if present. All information
 *                  after the sharp sign indicates an anchor.
 * @apiSince 1
 */

protected void parseURL(java.net.URL u, java.lang.String spec, int start, int limit) { throw new RuntimeException("Stub!"); }

/**
 * Returns the default port for a URL parsed by this handler. This method
 * is meant to be overidden by handlers with default port numbers.
 * @return the default port for a {@code URL} parsed by this handler.
 * @since 1.3
 * @apiSince 1
 */

protected int getDefaultPort() { throw new RuntimeException("Stub!"); }

/**
 * Provides the default equals calculation. May be overidden by handlers
 * for other protocols that have different requirements for equals().
 * This method requires that none of its arguments is null. This is
 * guaranteed by the fact that it is only called by java.net.URL class.
 * @param u1 a URL object
 * @param u2 a URL object
 * @return {@code true} if the two urls are
 * considered equal, ie. they refer to the same
 * fragment in the same file.
 * @since 1.3
 * @apiSince 1
 */

protected boolean equals(java.net.URL u1, java.net.URL u2) { throw new RuntimeException("Stub!"); }

/**
 * Provides the default hash calculation. May be overidden by handlers for
 * other protocols that have different requirements for hashCode
 * calculation.
 * @param u a URL object
 * @return an {@code int} suitable for hash table indexing
 * @since 1.3
 * @apiSince 1
 */

protected int hashCode(java.net.URL u) { throw new RuntimeException("Stub!"); }

/**
 * Compare two urls to see whether they refer to the same file,
 * i.e., having the same protocol, host, port, and path.
 * This method requires that none of its arguments is null. This is
 * guaranteed by the fact that it is only called indirectly
 * by java.net.URL class.
 * @param u1 a URL object
 * @param u2 a URL object
 * @return true if u1 and u2 refer to the same file
 * @since 1.3
 * @apiSince 1
 */

protected boolean sameFile(java.net.URL u1, java.net.URL u2) { throw new RuntimeException("Stub!"); }

/**
 * Get the IP address of our host. An empty host field or a DNS failure
 * will result in a null return.
 *
 * @param u a URL object
 * @return an {@code InetAddress} representing the host
 * IP address.
 * @since 1.3
 * @apiSince 1
 */

protected synchronized java.net.InetAddress getHostAddress(java.net.URL u) { throw new RuntimeException("Stub!"); }

/**
 * Compares the host components of two URLs.
 * @param u1 the URL of the first host to compare
 * @param u2 the URL of the second host to compare
 * @return  {@code true} if and only if they
 * are equal, {@code false} otherwise.
 * @since 1.3
 * @apiSince 1
 */

protected boolean hostsEqual(java.net.URL u1, java.net.URL u2) { throw new RuntimeException("Stub!"); }

/**
 * Converts a {@code URL} of a specific protocol to a
 * {@code String}.
 *
 * @param   u   the URL.
 * @return  a string representation of the {@code URL} argument.
 * @apiSince 1
 */

protected java.lang.String toExternalForm(java.net.URL u) { throw new RuntimeException("Stub!"); }

/**
 * Sets the fields of the {@code URL} argument to the indicated values.
 * Only classes derived from URLStreamHandler are able
 * to use this method to set the values of the URL fields.
 *
 * @param   u         the URL to modify.
 * @param   protocol  the protocol name.
 * @param   host      the remote host value for the URL.
 * @param   port      the port on the remote machine.
 * @param   authority the authority part for the URL.
 * @param   userInfo the userInfo part of the URL.
 * @param   path      the path component of the URL.
 * @param   query     the query part for the URL.
 * @param   ref       the reference.
 * @exception       java.lang.SecurityException       if the protocol handler of the URL is
 *                                  different from this one
 * @since 1.3
 * @apiSince 1
 */

protected void setURL(java.net.URL u, java.lang.String protocol, java.lang.String host, int port, java.lang.String authority, java.lang.String userInfo, java.lang.String path, java.lang.String query, java.lang.String ref) { throw new RuntimeException("Stub!"); }

/**
 * Sets the fields of the {@code URL} argument to the indicated values.
 * Only classes derived from URLStreamHandler are able
 * to use this method to set the values of the URL fields.
 *
 * @param   u         the URL to modify.
 * @param   protocol  the protocol name. This value is ignored since 1.2.
 * @param   host      the remote host value for the URL.
 * @param   port      the port on the remote machine.
 * @param   file      the file.
 * @param   ref       the reference.
 * @exception       java.lang.SecurityException       if the protocol handler of the URL is
 *                                  different from this one
 * @deprecated Use setURL(URL, String, String, int, String, String, String,
 *             String);
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected void setURL(java.net.URL u, java.lang.String protocol, java.lang.String host, int port, java.lang.String file, java.lang.String ref) { throw new RuntimeException("Stub!"); }
}

