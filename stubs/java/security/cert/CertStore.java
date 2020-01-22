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

import java.util.Collection;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.Provider;
import java.security.NoSuchProviderException;

/**
 * A class for retrieving {@code Certificate}s and {@code CRL}s
 * from a repository.
 * <p>
 * This class uses a provider-based architecture.
 * To create a {@code CertStore}, call one of the static
 * {@code getInstance} methods, passing in the type of
 * {@code CertStore} desired, any applicable initialization parameters
 * and optionally the name of the provider desired.
 * <p>
 * Once the {@code CertStore} has been created, it can be used to
 * retrieve {@code Certificate}s and {@code CRL}s by calling its
 * {@link #getCertificates(java.security.cert.CertSelector) getCertificates} and
 * {@link #getCRLs(java.security.cert.CRLSelector) getCRLs} methods.
 * <p>
 * Unlike a {@link java.security.KeyStore KeyStore}, which provides access
 * to a cache of private keys and trusted certificates, a
 * {@code CertStore} is designed to provide access to a potentially
 * vast repository of untrusted certificates and CRLs. For example, an LDAP
 * implementation of {@code CertStore} provides access to certificates
 * and CRLs stored in one or more directories using the LDAP protocol and the
 * schema as defined in the RFC service attribute.
 *
 * <p> Android provides the following <code>CertStore</code> types:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>Collection</td>
 *       <td>1+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * This type is described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertStore">
 * CertStore section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * All public methods of {@code CertStore} objects must be thread-safe.
 * That is, multiple threads may concurrently invoke these methods on a
 * single {@code CertStore} object (or more than one) with no
 * ill effects. This allows a {@code CertPathBuilder} to search for a
 * CRL while simultaneously searching for further certificates, for instance.
 * <p>
 * The static methods of this class are also guaranteed to be thread-safe.
 * Multiple threads may concurrently invoke the static methods defined in
 * this class with no ill effects.
 *
 * @since       1.4
 * @author      Sean Mullan, Steve Hanna
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CertStore {

/**
 * Creates a {@code CertStore} object of the given type, and
 * encapsulates the given provider implementation (SPI object) in it.
 *
 * @param storeSpi the provider implementation
 * @param provider the provider
 * @param type the type
 * @param params the initialization parameters (may be {@code null})
 * @apiSince 1
 */

protected CertStore(java.security.cert.CertStoreSpi storeSpi, java.security.Provider provider, java.lang.String type, java.security.cert.CertStoreParameters params) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collection} of {@code Certificate}s that
 * match the specified selector. If no {@code Certificate}s
 * match the selector, an empty {@code Collection} will be returned.
 * <p>
 * For some {@code CertStore} types, the resulting
 * {@code Collection} may not contain <b>all</b> of the
 * {@code Certificate}s that match the selector. For instance,
 * an LDAP {@code CertStore} may not search all entries in the
 * directory. Instead, it may just search entries that are likely to
 * contain the {@code Certificate}s it is looking for.
 * <p>
 * Some {@code CertStore} implementations (especially LDAP
 * {@code CertStore}s) may throw a {@code CertStoreException}
 * unless a non-null {@code CertSelector} is provided that
 * includes specific criteria that can be used to find the certificates.
 * Issuer and/or subject names are especially useful criteria.
 *
 * @param selector A {@code CertSelector} used to select which
 *  {@code Certificate}s should be returned. Specify {@code null}
 *  to return all {@code Certificate}s (if supported).
 * @return A {@code Collection} of {@code Certificate}s that
 *         match the specified selector (never {@code null})
 * @throws java.security.cert.CertStoreException if an exception occurs
 * @apiSince 1
 */

public final java.util.Collection<? extends java.security.cert.Certificate> getCertificates(java.security.cert.CertSelector selector) throws java.security.cert.CertStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Collection} of {@code CRL}s that
 * match the specified selector. If no {@code CRL}s
 * match the selector, an empty {@code Collection} will be returned.
 * <p>
 * For some {@code CertStore} types, the resulting
 * {@code Collection} may not contain <b>all</b> of the
 * {@code CRL}s that match the selector. For instance,
 * an LDAP {@code CertStore} may not search all entries in the
 * directory. Instead, it may just search entries that are likely to
 * contain the {@code CRL}s it is looking for.
 * <p>
 * Some {@code CertStore} implementations (especially LDAP
 * {@code CertStore}s) may throw a {@code CertStoreException}
 * unless a non-null {@code CRLSelector} is provided that
 * includes specific criteria that can be used to find the CRLs.
 * Issuer names and/or the certificate to be checked are especially useful.
 *
 * @param selector A {@code CRLSelector} used to select which
 *  {@code CRL}s should be returned. Specify {@code null}
 *  to return all {@code CRL}s (if supported).
 * @return A {@code Collection} of {@code CRL}s that
 *         match the specified selector (never {@code null})
 * @throws java.security.cert.CertStoreException if an exception occurs
 * @apiSince 1
 */

public final java.util.Collection<? extends java.security.cert.CRL> getCRLs(java.security.cert.CRLSelector selector) throws java.security.cert.CertStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code CertStore} object that implements the specified
 * {@code CertStore} type and is initialized with the specified
 * parameters.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new CertStore object encapsulating the
 * CertStoreSpi implementation from the first
 * Provider that supports the specified type is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * <p>The {@code CertStore} that is returned is initialized with the
 * specified {@code CertStoreParameters}. The type of parameters
 * needed may vary between different types of {@code CertStore}s.
 * Note that the specified {@code CertStoreParameters} object is
 * cloned.
 *
 * @param type the name of the requested {@code CertStore} type.
 * See the CertStore section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertStore">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard types.
 *
 * @param params the initialization parameters (may be {@code null}).
 *
 * @return a {@code CertStore} object that implements the specified
 *          {@code CertStore} type.
 *
 * @throws java.security.NoSuchAlgorithmException if no Provider supports a
 *          CertStoreSpi implementation for the specified type.
 *
 * @throws java.security.InvalidAlgorithmParameterException if the specified
 *          initialization parameters are inappropriate for this
 *          {@code CertStore}.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.cert.CertStore getInstance(java.lang.String type, java.security.cert.CertStoreParameters params) throws java.security.InvalidAlgorithmParameterException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code CertStore} object that implements the specified
 * {@code CertStore} type.
 *
 * <p> A new CertStore object encapsulating the
 * CertStoreSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * <p>The {@code CertStore} that is returned is initialized with the
 * specified {@code CertStoreParameters}. The type of parameters
 * needed may vary between different types of {@code CertStore}s.
 * Note that the specified {@code CertStoreParameters} object is
 * cloned.
 *
 * @param type the requested {@code CertStore} type.
 * See the CertStore section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertStore">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard types.
 *
 * @param params the initialization parameters (may be {@code null}).
 *
 * @param provider the name of the provider.
 *
 * @return a {@code CertStore} object that implements the
 *          specified type.
 *
 * @throws java.security.NoSuchAlgorithmException if a CertStoreSpi
 *          implementation for the specified type is not
 *          available from the specified provider.
 *
 * @throws java.security.InvalidAlgorithmParameterException if the specified
 *          initialization parameters are inappropriate for this
 *          {@code CertStore}.
 *
 * @throws java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception java.lang.IllegalArgumentException if the {@code provider} is
 *          null or empty.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.cert.CertStore getInstance(java.lang.String type, java.security.cert.CertStoreParameters params, java.lang.String provider) throws java.security.InvalidAlgorithmParameterException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code CertStore} object that implements the specified
 * {@code CertStore} type.
 *
 * <p> A new CertStore object encapsulating the
 * CertStoreSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * <p>The {@code CertStore} that is returned is initialized with the
 * specified {@code CertStoreParameters}. The type of parameters
 * needed may vary between different types of {@code CertStore}s.
 * Note that the specified {@code CertStoreParameters} object is
 * cloned.
 *
 * @param type the requested {@code CertStore} type.
 * See the CertStore section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertStore">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard types.
 *
 * @param params the initialization parameters (may be {@code null}).
 *
 * @param provider the provider.
 *
 * @return a {@code CertStore} object that implements the
 *          specified type.
 *
 * @exception java.security.NoSuchAlgorithmException if a CertStoreSpi
 *          implementation for the specified type is not available
 *          from the specified Provider object.
 *
 * @throws java.security.InvalidAlgorithmParameterException if the specified
 *          initialization parameters are inappropriate for this
 *          {@code CertStore}
 *
 * @exception java.lang.IllegalArgumentException if the {@code provider} is
 *          null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.cert.CertStore getInstance(java.lang.String type, java.security.cert.CertStoreParameters params, java.security.Provider provider) throws java.security.InvalidAlgorithmParameterException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the parameters used to initialize this {@code CertStore}.
 * Note that the {@code CertStoreParameters} object is cloned before
 * it is returned.
 *
 * @return the parameters used to initialize this {@code CertStore}
 * (may be {@code null})
 * @apiSince 1
 */

public final java.security.cert.CertStoreParameters getCertStoreParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this {@code CertStore}.
 *
 * @return the type of this {@code CertStore}
 * @apiSince 1
 */

public final java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this {@code CertStore}.
 *
 * @return the provider of this {@code CertStore}
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default {@code CertStore} type as specified by the
 * {@code certstore.type} security property, or the string
 * {@literal "LDAP"} if no such property exists.
 *
 * <p>The default {@code CertStore} type can be used by applications
 * that do not want to use a hard-coded type when calling one of the
 * {@code getInstance} methods, and want to provide a default
 * {@code CertStore} type in case a user does not specify its own.
 *
 * <p>The default {@code CertStore} type can be changed by setting
 * the value of the {@code certstore.type} security property to the
 * desired type.
 *
 * @see java.security.Security security properties
 * @return the default {@code CertStore} type as specified by the
 * {@code certstore.type} security property, or the string
 * {@literal "LDAP"} if no such property exists.
 * @apiSince 1
 */

public static final java.lang.String getDefaultType() { throw new RuntimeException("Stub!"); }
}

