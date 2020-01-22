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



package javax.crypto;

import java.util.*;
import java.security.*;
import java.security.spec.*;

/**
 * This class provides the functionality of a secret (symmetric) key generator.
 *
 * <p>Key generators are constructed using one of the <code>getInstance</code>
 * class methods of this class.
 *
 * <p>KeyGenerator objects are reusable, i.e., after a key has been
 * generated, the same KeyGenerator object can be re-used to generate further
 * keys.
 *
 * <p>There are two ways to generate a key: in an algorithm-independent
 * manner, and in an algorithm-specific manner.
 * The only difference between the two is the initialization of the object:
 *
 * <ul>
 * <li><b>Algorithm-Independent Initialization</b>
 * <p>All key generators share the concepts of a <i>keysize</i> and a
 * <i>source of randomness</i>.
 * There is an
 * {@link #init(int,java.security.SecureRandom) init}
 * method in this KeyGenerator class that takes these two universally
 * shared types of arguments. There is also one that takes just a
 * <code>keysize</code> argument, and uses the SecureRandom implementation
 * of the highest-priority installed provider as the source of randomness
 * (or a system-provided source of randomness if none of the installed
 * providers supply a SecureRandom implementation), and one that takes just a
 * source of randomness.
 *
 * <p>Since no other parameters are specified when you call the above
 * algorithm-independent <code>init</code> methods, it is up to the
 * provider what to do about the algorithm-specific parameters (if any) to be
 * associated with each of the keys.
 *
 * <li><b>Algorithm-Specific Initialization</b>
 * <p>For situations where a set of algorithm-specific parameters already
 * exists, there are two
 * {@link #init(java.security.spec.AlgorithmParameterSpec) init}
 * methods that have an <code>AlgorithmParameterSpec</code>
 * argument. One also has a <code>SecureRandom</code> argument, while the
 * other uses the SecureRandom implementation
 * of the highest-priority installed provider as the source of randomness
 * (or a system-provided source of randomness if none of the installed
 * providers supply a SecureRandom implementation).
 * </ul>
 *
 * <p>In case the client does not explicitly initialize the KeyGenerator
 * (via a call to an <code>init</code> method), each provider must
 * supply (and document) a default initialization.
 *
 * <p> Android provides the following <code>KeyGenerator</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>AES</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>AESWRAP</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>ARC4</td>
 *       <td>14+</td>
 *     </tr>
 *     <tr>
 *       <td>BLOWFISH</td>
 *       <td>10+</td>
 *     </tr>
 *     <tr>
 *       <td>ChaCha20</td>
 *       <td>28+</td>
 *     </tr>
 *     <tr>
 *       <td>DES</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>DESede</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DESedeWRAP</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>HmacMD5</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA1</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA224</td>
 *       <td>1-8,22+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA256</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA384</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA512</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>RC4</td>
 *       <td>10-13</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These algorithms are described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyGenerator">
 * KeyGenerator section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Jan Luehe
 *
 * @see javax.crypto.SecretKey
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyGenerator {

/**
 * Creates a KeyGenerator object.
 *
 * @param keyGenSpi the delegate
 * @param provider the provider
 * @param algorithm the algorithm
 * @apiSince 1
 */

protected KeyGenerator(javax.crypto.KeyGeneratorSpi keyGenSpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm name of this <code>KeyGenerator</code> object.
 *
 * <p>This is the same name that was specified in one of the
 * <code>getInstance</code> calls that created this
 * <code>KeyGenerator</code> object.
 *
 * @return the algorithm name of this <code>KeyGenerator</code> object.
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyGenerator</code> object that generates secret keys
 * for the specified algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new KeyGenerator object encapsulating the
 * KeyGeneratorSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the requested key algorithm.
 * See the KeyGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the new <code>KeyGenerator</code> object.
 *
 * @exception java.lang.NullPointerException if the specified algorithm is null.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          KeyGeneratorSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.KeyGenerator getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyGenerator</code> object that generates secret keys
 * for the specified algorithm.
 *
 * <p> A new KeyGenerator object encapsulating the
 * KeyGeneratorSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the requested key algorithm.
 * See the KeyGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new <code>KeyGenerator</code> object.
 *
 * @exception java.lang.NullPointerException if the specified algorithm is null.
 *
 * @exception java.security.NoSuchAlgorithmException if a KeyGeneratorSpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @exception java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception java.lang.IllegalArgumentException if the <code>provider</code>
 *          is null or empty.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.KeyGenerator getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyGenerator</code> object that generates secret keys
 * for the specified algorithm.
 *
 * <p> A new KeyGenerator object encapsulating the
 * KeyGeneratorSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the standard name of the requested key algorithm.
 * See the KeyGenerator section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyGenerator">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return the new <code>KeyGenerator</code> object.
 *
 * @exception java.lang.NullPointerException if the specified algorithm is null.
 *
 * @exception java.security.NoSuchAlgorithmException if a KeyGeneratorSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the <code>provider</code>
 *          is null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.KeyGenerator getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this <code>KeyGenerator</code> object.
 *
 * @return the provider of this <code>KeyGenerator</code> object
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key generator.
 *
 * @param random the source of randomness for this generator
 * @apiSince 1
 */

public final void init(java.security.SecureRandom random) { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key generator with the specified parameter set.
 *
 * <p> If this key generator requires any random bytes, it will get them
 * using the
 * {@link java.security.SecureRandom}
 * implementation of the highest-priority installed
 * provider as the source of randomness.
 * (If none of the installed providers supply an implementation of
 * SecureRandom, a system-provided source of randomness will be used.)
 *
 * @param params the key generation parameters
 *
 * @exception java.security.InvalidAlgorithmParameterException if the given parameters
 * are inappropriate for this key generator
 * @apiSince 1
 */

public final void init(java.security.spec.AlgorithmParameterSpec params) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key generator with the specified parameter
 * set and a user-provided source of randomness.
 *
 * @param params the key generation parameters
 * @param random the source of randomness for this key generator
 *
 * @exception java.security.InvalidAlgorithmParameterException if <code>params</code> is
 * inappropriate for this key generator
 * @apiSince 1
 */

public final void init(java.security.spec.AlgorithmParameterSpec params, java.security.SecureRandom random) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key generator for a certain keysize.
 *
 * <p> If this key generator requires any random bytes, it will get them
 * using the
 * {@link java.security.SecureRandom}
 * implementation of the highest-priority installed
 * provider as the source of randomness.
 * (If none of the installed providers supply an implementation of
 * SecureRandom, a system-provided source of randomness will be used.)
 *
 * @param keysize the keysize. This is an algorithm-specific metric,
 * specified in number of bits.
 *
 * @exception java.security.InvalidParameterException if the keysize is wrong or not
 * supported.
 * @apiSince 1
 */

public final void init(int keysize) { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key generator for a certain keysize, using a
 * user-provided source of randomness.
 *
 * @param keysize the keysize. This is an algorithm-specific metric,
 * specified in number of bits.
 * @param random the source of randomness for this key generator
 *
 * @exception java.security.InvalidParameterException if the keysize is wrong or not
 * supported.
 * @apiSince 1
 */

public final void init(int keysize, java.security.SecureRandom random) { throw new RuntimeException("Stub!"); }

/**
 * Generates a secret key.
 *
 * @return the new key
 * @apiSince 1
 */

public final javax.crypto.SecretKey generateKey() { throw new RuntimeException("Stub!"); }
}

