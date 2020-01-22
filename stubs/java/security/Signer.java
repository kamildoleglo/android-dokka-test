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



package java.security;

import java.io.*;

/**
 * This class is used to represent an Identity that can also digitally
 * sign data.
 *
 * <p>The management of a signer's private keys is an important and
 * sensitive issue that should be handled by subclasses as appropriate
 * to their intended use.
 *
 * @see java.security.Identity
 *
 * @author Benjamin Renaud
 *
 * @deprecated This class is no longer used. Its functionality has been
 * replaced by {@code java.security.KeyStore}, the
 * {@code java.security.cert} package, and
 * {@code java.security.Principal}.
 * @apiSince 1
 * @deprecatedSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class Signer extends java.security.Identity {

/**
 * Creates a signer. This constructor should only be used for
 * serialization.
 * @apiSince 1
 */

@Deprecated
protected Signer() { throw new RuntimeException("Stub!"); }

/**
 * Creates a signer with the specified identity name.
 *
 * @param name the identity name.
 * @apiSince 1
 */

@Deprecated
public Signer(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Creates a signer with the specified identity name and scope.
 *
 * @param name the identity name.
 *
 * @param scope the scope of the identity.
 *
 * @exception java.security.KeyManagementException if there is already an identity
 * with the same name in the scope.
 * @apiSince 1
 */

@Deprecated
public Signer(java.lang.String name, java.security.IdentityScope scope) throws java.security.KeyManagementException { throw new RuntimeException("Stub!"); }

/**
 * Returns this signer's private key.
 *
 * <p>First, if there is a security manager, its {@code checkSecurityAccess}
 * method is called with {@code "getSignerPrivateKey"}
 * as its argument to see if it's ok to return the private key.
 *
 * @return this signer's private key, or null if the private key has
 * not yet been set.
 *
 * @exception  java.lang.SecurityException  if a security manager exists and its
 * {@code checkSecurityAccess} method doesn't allow
 * returning the private key.
 *
 * @see java.lang.SecurityManager#checkSecurityAccess
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public java.security.PrivateKey getPrivateKey() { throw new RuntimeException("Stub!"); }

/**
 * Sets the key pair (public key and private key) for this signer.
 *
 * <p>First, if there is a security manager, its {@code checkSecurityAccess}
 * method is called with {@code "setSignerKeyPair"}
 * as its argument to see if it's ok to set the key pair.
 *
 * @param pair an initialized key pair.
 *
 * @exception java.security.InvalidParameterException if the key pair is not
 * properly initialized.
 * @exception java.security.KeyException if the key pair cannot be set for any
 * other reason.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 * {@code checkSecurityAccess} method doesn't allow
 * setting the key pair.
 *
 * @see java.lang.SecurityManager#checkSecurityAccess
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public final void setKeyPair(java.security.KeyPair pair) throws java.security.InvalidParameterException, java.security.KeyException { throw new RuntimeException("Stub!"); }

/**
 * Returns a string of information about the signer.
 *
 * @return a string of information about the signer.
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

