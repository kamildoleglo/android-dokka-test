/*
 * Copyright (c) 1999, 2001, Oracle and/or its affiliates. All rights reserved.
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

import java.security.*;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the <code>KeyManagerFactory</code> class.
 *
 * <p> All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a particular key manager factory.
 *
 * @since 1.4
 * @see javax.net.ssl.KeyManagerFactory
 * @see javax.net.ssl.KeyManager
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class KeyManagerFactorySpi {

/** @apiSince 1 */

public KeyManagerFactorySpi() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this factory with a source of key material.
 *
 * @param ks the key store or null
 * @param password the password for recovering keys
 * @throws java.security.KeyStoreException if this operation fails
 * @throws java.security.NoSuchAlgorithmException if the specified algorithm is not
 *          available from the specified provider.
 * @throws java.security.UnrecoverableKeyException if the key cannot be recovered
 * @see javax.net.ssl.KeyManagerFactory#init(KeyStore, char[])
 * @apiSince 1
 */

protected abstract void engineInit(java.security.KeyStore ks, char[] password) throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException;

/**
 * Initializes this factory with a source of key material.
 * <P>
 * In some cases, initialization parameters other than a keystore
 * and password may be needed by a provider.  Users of that
 * particular provider are expected to pass an implementation of
 * the appropriate <CODE>ManagerFactoryParameters</CODE> as
 * defined by the provider.  The provider can then call the
 * specified methods in the ManagerFactoryParameters
 * implementation to obtain the needed information.
 *
 * @param spec an implementation of a provider-specific parameter
 *          specification
 * @throws java.security.InvalidAlgorithmParameterException if there is problem
 *          with the parameters
 * @see javax.net.ssl.KeyManagerFactory#init(ManagerFactoryParameters spec)
 * @apiSince 1
 */

protected abstract void engineInit(javax.net.ssl.ManagerFactoryParameters spec) throws java.security.InvalidAlgorithmParameterException;

/**
 * Returns one key manager for each type of key material.
 *
 * @return the key managers
 * @throws java.lang.IllegalStateException
 *         if the KeyManagerFactorySpi is not initialized
 * @apiSince 1
 */

protected abstract javax.net.ssl.KeyManager[] engineGetKeyManagers();
}

