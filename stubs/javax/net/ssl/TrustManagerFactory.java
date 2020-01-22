/*
 * Copyright (c) 1999, 2012, Oracle and/or its affiliates. All rights reserved.
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
import java.security.Security;

/**
 * This class acts as a factory for trust managers based on a
 * source of trust material. Each trust manager manages a specific
 * type of trust material for use by secure sockets. The trust
 * material is based on a KeyStore and/or provider specific sources.
 *
 * <p> Android provides the following <code>TrustManagerFactory</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>PKIX</td>
 *       <td>1+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * @since 1.4
 * @see javax.net.ssl.TrustManager
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TrustManagerFactory {

/**
 * Creates a TrustManagerFactory object.
 *
 * @param factorySpi the delegate
 * @param provider the provider
 * @param algorithm the algorithm
 * @apiSince 1
 */

protected TrustManagerFactory(javax.net.ssl.TrustManagerFactorySpi factorySpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the default TrustManagerFactory algorithm name.
 *
 * <p>The default TrustManager can be changed at runtime by setting
 * the value of the {@code ssl.TrustManagerFactory.algorithm}
 * security property to the desired algorithm name.
 *
 * @see java.security.Security security properties
 * @return the default algorithm name as specified by the
 * {@code ssl.TrustManagerFactory.algorithm} security property, or an
 * implementation-specific default if no such property exists.
 * @apiSince 1
 */

public static final java.lang.String getDefaultAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm name of this <code>TrustManagerFactory</code>
 * object.
 *
 * <p>This is the same name that was specified in one of the
 * <code>getInstance</code> calls that created this
 * <code>TrustManagerFactory</code> object.
 *
 * @return the algorithm name of this <code>TrustManagerFactory</code>
 *          object
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>TrustManagerFactory</code> object that acts as a
 * factory for trust managers.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new TrustManagerFactory object encapsulating the
 * TrustManagerFactorySpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the requested trust management
 *          algorithm.  See the <a href=
 *  "https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html">
 *          Java Secure Socket Extension Reference Guide </a>
 *          for information about standard algorithm names.
 *
 * @return the new <code>TrustManagerFactory</code> object.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          TrustManagerFactorySpi implementation for the
 *          specified algorithm.
 * @exception java.lang.NullPointerException if algorithm is null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.net.ssl.TrustManagerFactory getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>TrustManagerFactory</code> object that acts as a
 * factory for trust managers.
 *
 * <p> A new KeyManagerFactory object encapsulating the
 * KeyManagerFactorySpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the requested trust management
 *          algorithm.  See the <a href=
 *  "https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html">
 *          Java Secure Socket Extension Reference Guide </a>
 *          for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new <code>TrustManagerFactory</code> object
 *
 * @throws java.security.NoSuchAlgorithmException if a TrustManagerFactorySpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @throws java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @throws java.lang.IllegalArgumentException if the provider name is null or empty.
 * @throws java.lang.NullPointerException if algorithm is null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.net.ssl.TrustManagerFactory getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>TrustManagerFactory</code> object that acts as a
 * factory for trust managers.
 *
 * <p> A new TrustManagerFactory object encapsulating the
 * TrustManagerFactorySpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the standard name of the requested trust management
 *          algorithm.  See the <a href=
 *  "https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html">
 *          Java Secure Socket Extension Reference Guide </a>
 *          for information about standard algorithm names.
 *
 * @param provider an instance of the provider.
 *
 * @return the new <code>TrustManagerFactory</code> object.
 *
 * @throws java.security.NoSuchAlgorithmException if a TrustManagerFactorySpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @throws java.lang.IllegalArgumentException if the provider is null.
 * @throws java.lang.NullPointerException if algorithm is null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.net.ssl.TrustManagerFactory getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this <code>TrustManagerFactory</code> object.
 *
 * @return the provider of this <code>TrustManagerFactory</code> object
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this factory with a source of certificate
 * authorities and related trust material.
 * <P>
 * The provider typically uses a KeyStore as a basis for making
 * trust decisions.
 * <P>
 * For more flexible initialization, please see
 * {@link #init(javax.net.ssl.ManagerFactoryParameters)}.
 *
 * @param ks the key store, or null
 * @throws java.security.KeyStoreException if this operation fails
 * @apiSince 1
 */

public final void init(java.security.KeyStore ks) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this factory with a source of provider-specific
 * trust material.
 * <P>
 * In some cases, initialization parameters other than a keystore
 * may be needed by a provider.  Users of that particular provider
 * are expected to pass an implementation of the appropriate
 * <CODE>ManagerFactoryParameters</CODE> as defined by the
 * provider.  The provider can then call the specified methods in
 * the <CODE>ManagerFactoryParameters</CODE> implementation to obtain the
 * needed information.
 *
 * @param spec an implementation of a provider-specific parameter
 *          specification
 * @throws java.security.InvalidAlgorithmParameterException if an error is
 *          encountered
 * @apiSince 1
 */

public final void init(javax.net.ssl.ManagerFactoryParameters spec) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Returns one trust manager for each type of trust material.
 *
 * @throws java.lang.IllegalStateException if the factory is not initialized.
 *
 * @return the trust managers
 * @apiSince 1
 */

public final javax.net.ssl.TrustManager[] getTrustManagers() { throw new RuntimeException("Stub!"); }
}

