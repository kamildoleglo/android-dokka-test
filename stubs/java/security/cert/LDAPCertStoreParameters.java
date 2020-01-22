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



package java.security.cert;


/**
 * Parameters used as input for the LDAP {@code CertStore} algorithm.
 * <p>
 * This class is used to provide necessary configuration parameters (server
 * name and port number) to implementations of the LDAP {@code CertStore}
 * algorithm.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @since       1.4
 * @author      Steve Hanna
 * @see         java.security.cert.CertStore
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LDAPCertStoreParameters implements java.security.cert.CertStoreParameters {

/**
 * Creates an instance of {@code LDAPCertStoreParameters} with the
 * specified parameter values.
 *
 * @param serverName the DNS name of the LDAP server
 * @param port the port number of the LDAP server
 * @exception java.lang.NullPointerException if {@code serverName} is
 * {@code null}
 * @apiSince 1
 */

public LDAPCertStoreParameters(java.lang.String serverName, int port) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance of {@code LDAPCertStoreParameters} with the
 * specified server name and a default port of 389.
 *
 * @param serverName the DNS name of the LDAP server
 * @exception java.lang.NullPointerException if {@code serverName} is
 * {@code null}
 * @apiSince 1
 */

public LDAPCertStoreParameters(java.lang.String serverName) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance of {@code LDAPCertStoreParameters} with the
 * default parameter values (server name "localhost", port 389).
 * @apiSince 1
 */

public LDAPCertStoreParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns the DNS name of the LDAP server.
 *
 * @return the name (not {@code null})
 * @apiSince 1
 */

public java.lang.String getServerName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the port number of the LDAP server.
 *
 * @return the port number
 * @apiSince 1
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this object. Changes to the copy will not affect
 * the original and vice versa.
 * <p>
 * Note: this method currently performs a shallow copy of the object
 * (simply calls {@code Object.clone()}). This may be changed in a
 * future revision to perform a deep copy if new parameters are added
 * that should not be shared.
 *
 * @return the copy
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns a formatted string describing the parameters.
 *
 * @return a formatted string describing the parameters
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

