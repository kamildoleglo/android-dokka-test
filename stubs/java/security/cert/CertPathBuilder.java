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

import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.Provider;
import java.security.NoSuchProviderException;
import java.security.InvalidAlgorithmParameterException;

/**
 * A class for building certification paths (also known as certificate chains).
 * <p>
 * This class uses a provider-based architecture.
 * To create a {@code CertPathBuilder}, call
 * one of the static {@code getInstance} methods, passing in the
 * algorithm name of the {@code CertPathBuilder} desired and optionally
 * the name of the provider desired.
 *
 * <p>Once a {@code CertPathBuilder} object has been created, certification
 * paths can be constructed by calling the {@link #build build} method and
 * passing it an algorithm-specific set of parameters. If successful, the
 * result (including the {@code CertPath} that was built) is returned
 * in an object that implements the {@code CertPathBuilderResult}
 * interface.
 *
 * <p>The {@link #getRevocationChecker} method allows an application to specify
 * additional algorithm-specific parameters and options used by the
 * {@code CertPathBuilder} when checking the revocation status of certificates.
 * Here is an example demonstrating how it is used with the PKIX algorithm:
 *
 * <pre>
 * CertPathBuilder cpb = CertPathBuilder.getInstance("PKIX");
 * PKIXRevocationChecker rc = (PKIXRevocationChecker)cpb.getRevocationChecker();
 * rc.setOptions(EnumSet.of(Option.PREFER_CRLS));
 * params.addCertPathChecker(rc);
 * CertPathBuilderResult cpbr = cpb.build(params);
 * </pre>
 *
 * <p> Android provides the following {@code CertPathBuilder} algorithms:
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
 * This algorithm is described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertPathBuilder">
 * CertPathBuilder section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 * Consult the release documentation for your implementation to see if any
 * other algorithms are supported.
 *
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * The static methods of this class are guaranteed to be thread-safe.
 * Multiple threads may concurrently invoke the static methods defined in
 * this class with no ill effects.
 * <p>
 * However, this is not true for the non-static methods defined by this class.
 * Unless otherwise documented by a specific provider, threads that need to
 * access a single {@code CertPathBuilder} instance concurrently should
 * synchronize amongst themselves and provide the necessary locking. Multiple
 * threads each manipulating a different {@code CertPathBuilder} instance
 * need not synchronize.
 *
 * @see java.security.cert.CertPath
 *
 * @since       1.4
 * @author      Sean Mullan
 * @author      Yassir Elley
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CertPathBuilder {

/**
 * Creates a {@code CertPathBuilder} object of the given algorithm,
 * and encapsulates the given provider implementation (SPI object) in it.
 *
 * @param builderSpi the provider implementation
 * @param provider the provider
 * @param algorithm the algorithm name
 * @apiSince 1
 */

protected CertPathBuilder(java.security.cert.CertPathBuilderSpi builderSpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code CertPathBuilder} object that implements the
 * specified algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new CertPathBuilder object encapsulating the
 * CertPathBuilderSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the requested {@code CertPathBuilder}
 *  algorithm.  See the CertPathBuilder section in the <a href=
 *  "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertPathBuilder">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return a {@code CertPathBuilder} object that implements the
 *          specified algorithm.
 *
 * @throws java.security.NoSuchAlgorithmException if no Provider supports a
 *          CertPathBuilderSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.cert.CertPathBuilder getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code CertPathBuilder} object that implements the
 * specified algorithm.
 *
 * <p> A new CertPathBuilder object encapsulating the
 * CertPathBuilderSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the requested {@code CertPathBuilder}
 *  algorithm.  See the CertPathBuilder section in the <a href=
 *  "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertPathBuilder">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return a {@code CertPathBuilder} object that implements the
 *          specified algorithm.
 *
 * @throws java.security.NoSuchAlgorithmException if a CertPathBuilderSpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
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

public static java.security.cert.CertPathBuilder getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code CertPathBuilder} object that implements the
 * specified algorithm.
 *
 * <p> A new CertPathBuilder object encapsulating the
 * CertPathBuilderSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the name of the requested {@code CertPathBuilder}
 *  algorithm.  See the CertPathBuilder section in the <a href=
 *  "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertPathBuilder">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return a {@code CertPathBuilder} object that implements the
 *          specified algorithm.
 *
 * @exception java.security.NoSuchAlgorithmException if a CertPathBuilderSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the {@code provider} is
 *          null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.cert.CertPathBuilder getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this {@code CertPathBuilder}.
 *
 * @return the provider of this {@code CertPathBuilder}
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the algorithm of this {@code CertPathBuilder}.
 *
 * @return the name of the algorithm of this {@code CertPathBuilder}
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Attempts to build a certification path using the specified algorithm
 * parameter set.
 *
 * @param params the algorithm parameters
 * @return the result of the build algorithm
 * @throws java.security.cert.CertPathBuilderException if the builder is unable to construct
 *  a certification path that satisfies the specified parameters
 * @throws java.security.InvalidAlgorithmParameterException if the specified parameters
 * are inappropriate for this {@code CertPathBuilder}
 * @apiSince 1
 */

public final java.security.cert.CertPathBuilderResult build(java.security.cert.CertPathParameters params) throws java.security.cert.CertPathBuilderException, java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Returns the default {@code CertPathBuilder} type as specified by
 * the {@code certpathbuilder.type} security property, or the string
 * {@literal "PKIX"} if no such property exists.
 *
 * <p>The default {@code CertPathBuilder} type can be used by
 * applications that do not want to use a hard-coded type when calling one
 * of the {@code getInstance} methods, and want to provide a default
 * type in case a user does not specify its own.
 *
 * <p>The default {@code CertPathBuilder} type can be changed by
 * setting the value of the {@code certpathbuilder.type} security property
 * to the desired type.
 *
 * @see java.security.Security security properties
 * @return the default {@code CertPathBuilder} type as specified
 * by the {@code certpathbuilder.type} security property, or the string
 * {@literal "PKIX"} if no such property exists.
 * @apiSince 1
 */

public static final java.lang.String getDefaultType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code CertPathChecker} that the encapsulated
 * {@code CertPathBuilderSpi} implementation uses to check the revocation
 * status of certificates. A PKIX implementation returns objects of
 * type {@code PKIXRevocationChecker}. Each invocation of this method
 * returns a new instance of {@code CertPathChecker}.
 *
 * <p>The primary purpose of this method is to allow callers to specify
 * additional input parameters and options specific to revocation checking.
 * See the class description for an example.
 *
 * @return a {@code CertPathChecker}
 * @throws java.lang.UnsupportedOperationException if the service provider does not
 *         support this method
 * @since 1.8
 * @apiSince 24
 */

public final java.security.cert.CertPathChecker getRevocationChecker() { throw new RuntimeException("Stub!"); }
}

