/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;
import java.security.spec.AlgorithmParameterSpec;

/**
 * The KeyPairGenerator class is used to generate pairs of
 * public and private keys. Key pair generators are constructed using the
 * {@code getInstance} factory methods (static methods that
 * return instances of a given class).
 *
 * <p>A Key pair generator for a particular algorithm creates a public/private
 * key pair that can be used with this algorithm. It also associates
 * algorithm-specific parameters with each of the generated keys.
 *
 * <p>There are two ways to generate a key pair: in an algorithm-independent
 * manner, and in an algorithm-specific manner.
 * The only difference between the two is the initialization of the object:
 *
 * <ul>
 * <li><b>Algorithm-Independent Initialization</b>
 * <p>All key pair generators share the concepts of a keysize and a
 * source of randomness. The keysize is interpreted differently for different
 * algorithms (e.g., in the case of the <i>DSA</i> algorithm, the keysize
 * corresponds to the length of the modulus).
 * There is an
 * {@link #initialize(int,java.security.SecureRandom) initialize}
 * method in this KeyPairGenerator class that takes these two universally
 * shared types of arguments. There is also one that takes just a
 * {@code keysize} argument, and uses the {@code SecureRandom}
 * implementation of the highest-priority installed provider as the source
 * of randomness. (If none of the installed providers supply an implementation
 * of {@code SecureRandom}, a system-provided source of randomness is
 * used.)
 *
 * <p>Since no other parameters are specified when you call the above
 * algorithm-independent {@code initialize} methods, it is up to the
 * provider what to do about the algorithm-specific parameters (if any) to be
 * associated with each of the keys.
 *
 * <p>If the algorithm is the <i>DSA</i> algorithm, and the keysize (modulus
 * size) is 512, 768, or 1024, then the <i>Sun</i> provider uses a set of
 * precomputed values for the {@code p}, {@code q}, and
 * {@code g} parameters. If the modulus size is not one of the above
 * values, the <i>Sun</i> provider creates a new set of parameters. Other
 * providers might have precomputed parameter sets for more than just the
 * three modulus sizes mentioned above. Still others might not have a list of
 * precomputed parameters at all and instead always create new parameter sets.
 *
 * <li><b>Algorithm-Specific Initialization</b>
 * <p>For situations where a set of algorithm-specific parameters already
 * exists (e.g., so-called <i>community parameters</i> in DSA), there are two
 * {@link #initialize(java.security.spec.AlgorithmParameterSpec)
 * initialize} methods that have an {@code AlgorithmParameterSpec}
 * argument. One also has a {@code SecureRandom} argument, while the
 * the other uses the {@code SecureRandom}
 * implementation of the highest-priority installed provider as the source
 * of randomness. (If none of the installed providers supply an implementation
 * of {@code SecureRandom}, a system-provided source of randomness is
 * used.)
 * </ul>
 *
 * <p>In case the client does not explicitly initialize the KeyPairGenerator
 * (via a call to an {@code initialize} method), each provider must
 * supply (and document) a default initialization.
 * For example, the <i>Sun</i> provider uses a default modulus size (keysize)
 * of 1024 bits.
 *
 * <p>Note that this class is abstract and extends from
 * {@code KeyPairGeneratorSpi} for historical reasons.
 * Application developers should only take notice of the methods defined in
 * this {@code KeyPairGenerator} class; all the methods in
 * the superclass are intended for cryptographic service providers who wish to
 * supply their own implementations of key pair generators.
 *
 * <p> Android provides the following <code>KeyPairGenerator</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>DH</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>DSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>EC</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>RSA</td>
 *       <td>1+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These algorithms are described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator">
 * KeyPairGenerator section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Benjamin Renaud
 *
 * @see java.security.spec.AlgorithmParameterSpec
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class KeyPairGenerator extends java.security.KeyPairGeneratorSpi {

/**
 * Creates a KeyPairGenerator object for the specified algorithm.
 *
 * @param algorithm the standard string name of the algorithm.
 * See the KeyPairGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 * @apiSince 1
 */

protected KeyPairGenerator(java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns the standard name of the algorithm for this key pair generator.
 * See the KeyPairGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the standard string name of the algorithm.
 * @apiSince 1
 */

public java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns a KeyPairGenerator object that generates public/private
 * key pairs for the specified algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new KeyPairGenerator object encapsulating the
 * KeyPairGeneratorSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard string name of the algorithm.
 * See the KeyPairGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the new KeyPairGenerator object.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          KeyPairGeneratorSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.KeyPairGenerator getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a KeyPairGenerator object that generates public/private
 * key pairs for the specified algorithm.
 *
 * <p> A new KeyPairGenerator object encapsulating the
 * KeyPairGeneratorSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard string name of the algorithm.
 * See the KeyPairGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the string name of the provider.
 *
 * @return the new KeyPairGenerator object.
 *
 * @exception java.security.NoSuchAlgorithmException if a KeyPairGeneratorSpi
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

public static java.security.KeyPairGenerator getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a KeyPairGenerator object that generates public/private
 * key pairs for the specified algorithm.
 *
 * <p> A new KeyPairGenerator object encapsulating the
 * KeyPairGeneratorSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the standard string name of the algorithm.
 * See the KeyPairGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return the new KeyPairGenerator object.
 *
 * @exception java.security.NoSuchAlgorithmException if a KeyPairGeneratorSpi
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

public static java.security.KeyPairGenerator getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this key pair generator object.
 *
 * @return the provider of this key pair generator object
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes the key pair generator for a certain keysize using
 * a default parameter set and the {@code SecureRandom}
 * implementation of the highest-priority installed provider as the source
 * of randomness.
 * (If none of the installed providers supply an implementation of
 * {@code SecureRandom}, a system-provided source of randomness is
 * used.)
 *
 * @param keysize the keysize. This is an
 * algorithm-specific metric, such as modulus length, specified in
 * number of bits.
 *
 * @exception java.security.InvalidParameterException if the {@code keysize} is not
 * supported by this KeyPairGenerator object.
 * @apiSince 1
 */

public void initialize(int keysize) { throw new RuntimeException("Stub!"); }

/**
 * Initializes the key pair generator for a certain keysize with
 * the given source of randomness (and a default parameter set).
 *
 * @param keysize the keysize. This is an
 * algorithm-specific metric, such as modulus length, specified in
 * number of bits.
 * @param random the source of randomness.
 *
 * @exception java.security.InvalidParameterException if the {@code keysize} is not
 * supported by this KeyPairGenerator object.
 *
 * @since 1.2
 * @apiSince 1
 */

public void initialize(int keysize, java.security.SecureRandom random) { throw new RuntimeException("Stub!"); }

/**
 * Initializes the key pair generator using the specified parameter
 * set and the {@code SecureRandom}
 * implementation of the highest-priority installed provider as the source
 * of randomness.
 * (If none of the installed providers supply an implementation of
 * {@code SecureRandom}, a system-provided source of randomness is
 * used.).
 *
 * <p>This concrete method has been added to this previously-defined
 * abstract class.
 * This method calls the KeyPairGeneratorSpi
 * {@link java.security.KeyPairGeneratorSpi#initialize(java.security.spec.AlgorithmParameterSpec,java.security.SecureRandom) KeyPairGeneratorSpi#initialize(
 * java.security.spec.AlgorithmParameterSpec,
 * java.security.SecureRandom)} method,
 * passing it {@code params} and a source of randomness (obtained
 * from the highest-priority installed provider or system-provided if none
 * of the installed providers supply one).
 * That {@code initialize} method always throws an
 * UnsupportedOperationException if it is not overridden by the provider.
 *
 * @param params the parameter set used to generate the keys.
 *
 * @exception java.security.InvalidAlgorithmParameterException if the given parameters
 * are inappropriate for this key pair generator.
 *
 * @since 1.2
 * @apiSince 1
 */

public void initialize(java.security.spec.AlgorithmParameterSpec params) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Initializes the key pair generator with the given parameter
 * set and source of randomness.
 *
 * <p>This concrete method has been added to this previously-defined
 * abstract class.
 * This method calls the KeyPairGeneratorSpi {@link java.security.KeyPairGeneratorSpi#initialize(java.security.spec.AlgorithmParameterSpec,java.security.SecureRandom) KeyPairGeneratorSpi#initialize(
 * java.security.spec.AlgorithmParameterSpec,
 * java.security.SecureRandom)} method,
 * passing it {@code params} and {@code random}.
 * That {@code initialize}
 * method always throws an
 * UnsupportedOperationException if it is not overridden by the provider.
 *
 * @param params the parameter set used to generate the keys.
 * @param random the source of randomness.
 *
 * @exception java.security.InvalidAlgorithmParameterException if the given parameters
 * are inappropriate for this key pair generator.
 *
 * @since 1.2
 * @apiSince 1
 */

public void initialize(java.security.spec.AlgorithmParameterSpec params, java.security.SecureRandom random) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Generates a key pair.
 *
 * <p>If this KeyPairGenerator has not been initialized explicitly,
 * provider-specific defaults will be used for the size and other
 * (algorithm-specific) values of the generated keys.
 *
 * <p>This will generate a new key pair every time it is called.
 *
 * <p>This method is functionally equivalent to
 * {@link #generateKeyPair() generateKeyPair}.
 *
 * @return the generated key pair
 *
 * @since 1.2
 * @apiSince 1
 */

public final java.security.KeyPair genKeyPair() { throw new RuntimeException("Stub!"); }

/**
 * Generates a key pair.
 *
 * <p>If this KeyPairGenerator has not been initialized explicitly,
 * provider-specific defaults will be used for the size and other
 * (algorithm-specific) values of the generated keys.
 *
 * <p>This will generate a new key pair every time it is called.
 *
 * <p>This method is functionally equivalent to
 * {@link #genKeyPair() genKeyPair}.
 *
 * @return the generated key pair
 * @apiSince 1
 */

public java.security.KeyPair generateKeyPair() { throw new RuntimeException("Stub!"); }
}

