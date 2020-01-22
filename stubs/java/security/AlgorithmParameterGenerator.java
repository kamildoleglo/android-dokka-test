/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.security.spec.AlgorithmParameterSpec;

/**
 * The {@code AlgorithmParameterGenerator} class is used to generate a
 * set of
 * parameters to be used with a certain algorithm. Parameter generators
 * are constructed using the {@code getInstance} factory methods
 * (static methods that return instances of a given class).
 *
 * <P>The object that will generate the parameters can be initialized
 * in two different ways: in an algorithm-independent manner, or in an
 * algorithm-specific manner:
 *
 * <ul>
 * <li>The algorithm-independent approach uses the fact that all parameter
 * generators share the concept of a "size" and a
 * source of randomness. The measure of size is universally shared
 * by all algorithm parameters, though it is interpreted differently
 * for different algorithms. For example, in the case of parameters for
 * the <i>DSA</i> algorithm, "size" corresponds to the size
 * of the prime modulus (in bits).
 * When using this approach, algorithm-specific parameter generation
 * values - if any - default to some standard values, unless they can be
 * derived from the specified size.
 *
 * <li>The other approach initializes a parameter generator object
 * using algorithm-specific semantics, which are represented by a set of
 * algorithm-specific parameter generation values. To generate
 * Diffie-Hellman system parameters, for example, the parameter generation
 * values usually
 * consist of the size of the prime modulus and the size of the
 * random exponent, both specified in number of bits.
 * </ul>
 *
 * <P>In case the client does not explicitly initialize the
 * AlgorithmParameterGenerator
 * (via a call to an {@code init} method), each provider must supply (and
 * document) a default initialization. For example, the Sun provider uses a
 * default modulus prime size of 1024 bits for the generation of DSA
 * parameters.
 *
 * <p> Android provides the following <code>AlgorithmParameterGenerator</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr class="deprecated">
 *       <td>AES</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DES</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DESede</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>DH</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>DSA</td>
 *       <td>1+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These algorithms are described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#AlgorithmParameterGenerator">
 * AlgorithmParameterGenerator section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.AlgorithmParameters
 * @see java.security.spec.AlgorithmParameterSpec
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AlgorithmParameterGenerator {

/**
 * Creates an AlgorithmParameterGenerator object.
 *
 * @param paramGenSpi the delegate
 * @param provider the provider
 * @param algorithm the algorithm
 * @apiSince 1
 */

protected AlgorithmParameterGenerator(java.security.AlgorithmParameterGeneratorSpi paramGenSpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns the standard name of the algorithm this parameter
 * generator is associated with.
 *
 * @return the string name of the algorithm.
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns an AlgorithmParameterGenerator object for generating
 * a set of parameters to be used with the specified algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new AlgorithmParameterGenerator object encapsulating the
 * AlgorithmParameterGeneratorSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the algorithm this
 * parameter generator is associated with.
 * See the AlgorithmParameterGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#AlgorithmParameterGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the new AlgorithmParameterGenerator object.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports an
 *          AlgorithmParameterGeneratorSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.AlgorithmParameterGenerator getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns an AlgorithmParameterGenerator object for generating
 * a set of parameters to be used with the specified algorithm.
 *
 * <p> A new AlgorithmParameterGenerator object encapsulating the
 * AlgorithmParameterGeneratorSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the algorithm this
 * parameter generator is associated with.
 * See the AlgorithmParameterGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#AlgorithmParameterGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the string name of the Provider.
 *
 * @return the new AlgorithmParameterGenerator object.
 *
 * @exception java.security.NoSuchAlgorithmException if an AlgorithmParameterGeneratorSpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @exception java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception java.lang.IllegalArgumentException if the provider name is null
 *          or empty.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.AlgorithmParameterGenerator getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns an AlgorithmParameterGenerator object for generating
 * a set of parameters to be used with the specified algorithm.
 *
 * <p> A new AlgorithmParameterGenerator object encapsulating the
 * AlgorithmParameterGeneratorSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the string name of the algorithm this
 * parameter generator is associated with.
 * See the AlgorithmParameterGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#AlgorithmParameterGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the Provider object.
 *
 * @return the new AlgorithmParameterGenerator object.
 *
 * @exception java.security.NoSuchAlgorithmException if an AlgorithmParameterGeneratorSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the specified provider is null.
 *
 * @see java.security.Provider
 *
 * @since 1.4
 * @apiSince 1
 */

public static java.security.AlgorithmParameterGenerator getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this algorithm parameter generator object.
 *
 * @return the provider of this algorithm parameter generator object
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this parameter generator for a certain size.
 * To create the parameters, the {@code SecureRandom}
 * implementation of the highest-priority installed provider is used as
 * the source of randomness.
 * (If none of the installed providers supply an implementation of
 * {@code SecureRandom}, a system-provided source of randomness is
 * used.)
 *
 * @param size the size (number of bits).
 * @apiSince 1
 */

public final void init(int size) { throw new RuntimeException("Stub!"); }

/**
 * Initializes this parameter generator for a certain size and source
 * of randomness.
 *
 * @param size the size (number of bits).
 * @param random the source of randomness.
 * @apiSince 1
 */

public final void init(int size, java.security.SecureRandom random) { throw new RuntimeException("Stub!"); }

/**
 * Initializes this parameter generator with a set of algorithm-specific
 * parameter generation values.
 * To generate the parameters, the {@code SecureRandom}
 * implementation of the highest-priority installed provider is used as
 * the source of randomness.
 * (If none of the installed providers supply an implementation of
 * {@code SecureRandom}, a system-provided source of randomness is
 * used.)
 *
 * @param genParamSpec the set of algorithm-specific parameter generation values.
 *
 * @exception java.security.InvalidAlgorithmParameterException if the given parameter
 * generation values are inappropriate for this parameter generator.
 * @apiSince 1
 */

public final void init(java.security.spec.AlgorithmParameterSpec genParamSpec) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this parameter generator with a set of algorithm-specific
 * parameter generation values.
 *
 * @param genParamSpec the set of algorithm-specific parameter generation values.
 * @param random the source of randomness.
 *
 * @exception java.security.InvalidAlgorithmParameterException if the given parameter
 * generation values are inappropriate for this parameter generator.
 * @apiSince 1
 */

public final void init(java.security.spec.AlgorithmParameterSpec genParamSpec, java.security.SecureRandom random) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Generates the parameters.
 *
 * @return the new AlgorithmParameters object.
 * @apiSince 1
 */

public final java.security.AlgorithmParameters generateParameters() { throw new RuntimeException("Stub!"); }
}

