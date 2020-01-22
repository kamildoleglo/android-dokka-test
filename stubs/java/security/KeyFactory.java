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

import java.util.*;
import java.security.spec.KeySpec;
import java.security.spec.InvalidKeySpecException;

/**
 * Key factories are used to convert <I>keys</I> (opaque
 * cryptographic keys of type {@code Key}) into <I>key specifications</I>
 * (transparent representations of the underlying key material), and vice
 * versa.
 *
 * <P> Key factories are bi-directional. That is, they allow you to build an
 * opaque key object from a given key specification (key material), or to
 * retrieve the underlying key material of a key object in a suitable format.
 *
 * <P> Multiple compatible key specifications may exist for the same key.
 * For example, a DSA public key may be specified using
 * {@code DSAPublicKeySpec} or
 * {@code X509EncodedKeySpec}. A key factory can be used to translate
 * between compatible key specifications.
 *
 * <P> The following is an example of how to use a key factory in order to
 * instantiate a DSA public key from its encoding.
 * Assume Alice has received a digital signature from Bob.
 * Bob also sent her his public key (in encoded format) to verify
 * his signature. Alice then performs the following actions:
 *
 * <pre>
 * X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(bobEncodedPubKey);
 * KeyFactory keyFactory = KeyFactory.getInstance("DSA");
 * PublicKey bobPubKey = keyFactory.generatePublic(bobPubKeySpec);
 * Signature sig = Signature.getInstance("DSA");
 * sig.initVerify(bobPubKey);
 * sig.update(data);
 * sig.verify(signature);
 * </pre>
 *
 * <p> Android provides the following <code>KeyFactory</code> algorithms:
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
 *     <tr class="deprecated">
 *       <td>X.509</td>
 *       <td>1-8</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These algorithms are described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyFactory">
 * KeyFactory section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Jan Luehe
 *
 * @see java.security.Key
 * @see java.security.PublicKey
 * @see java.security.PrivateKey
 * @see java.security.spec.KeySpec
 * @see java.security.spec.DSAPublicKeySpec
 * @see java.security.spec.X509EncodedKeySpec
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyFactory {

/**
 * Creates a KeyFactory object.
 *
 * @param keyFacSpi the delegate
 * @param provider the provider
 * @param algorithm the name of the algorithm
 * to associate with this {@code KeyFactory}
 * @apiSince 1
 */

protected KeyFactory(java.security.KeyFactorySpi keyFacSpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns a KeyFactory object that converts
 * public/private keys of the specified algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new KeyFactory object encapsulating the
 * KeyFactorySpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the requested key algorithm.
 * See the KeyFactory section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyFactory">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the new KeyFactory object.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          KeyFactorySpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.KeyFactory getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a KeyFactory object that converts
 * public/private keys of the specified algorithm.
 *
 * <p> A new KeyFactory object encapsulating the
 * KeyFactorySpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the requested key algorithm.
 * See the KeyFactory section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyFactory">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new KeyFactory object.
 *
 * @exception java.security.NoSuchAlgorithmException if a KeyFactorySpi
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

public static java.security.KeyFactory getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a KeyFactory object that converts
 * public/private keys of the specified algorithm.
 *
 * <p> A new KeyFactory object encapsulating the
 * KeyFactorySpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the name of the requested key algorithm.
 * See the KeyFactory section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyFactory">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return the new KeyFactory object.
 *
 * @exception java.security.NoSuchAlgorithmException if a KeyFactorySpi
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

public static java.security.KeyFactory getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this key factory object.
 *
 * @return the provider of this key factory object
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the algorithm
 * associated with this {@code KeyFactory}.
 *
 * @return the name of the algorithm associated with this
 * {@code KeyFactory}
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Generates a public key object from the provided key specification
 * (key material).
 *
 * @param keySpec the specification (key material) of the public key.
 *
 * @return the public key.
 *
 * @exception java.security.spec.InvalidKeySpecException if the given key specification
 * is inappropriate for this key factory to produce a public key.
 * @apiSince 1
 */

public final java.security.PublicKey generatePublic(java.security.spec.KeySpec keySpec) throws java.security.spec.InvalidKeySpecException { throw new RuntimeException("Stub!"); }

/**
 * Generates a private key object from the provided key specification
 * (key material).
 *
 * @param keySpec the specification (key material) of the private key.
 *
 * @return the private key.
 *
 * @exception java.security.spec.InvalidKeySpecException if the given key specification
 * is inappropriate for this key factory to produce a private key.
 * @apiSince 1
 */

public final java.security.PrivateKey generatePrivate(java.security.spec.KeySpec keySpec) throws java.security.spec.InvalidKeySpecException { throw new RuntimeException("Stub!"); }

/**
 * Returns a specification (key material) of the given key object.
 * {@code keySpec} identifies the specification class in which
 * the key material should be returned. It could, for example, be
 * {@code DSAPublicKeySpec.class}, to indicate that the
 * key material should be returned in an instance of the
 * {@code DSAPublicKeySpec} class.
 *
 * @param <T> the type of the key specification to be returned
 *
 * @param key the key.
 *
 * @param keySpec the specification class in which
 * the key material should be returned.
 *
 * @return the underlying key specification (key material) in an instance
 * of the requested specification class.
 *
 * @exception java.security.spec.InvalidKeySpecException if the requested key specification is
 * inappropriate for the given key, or the given key cannot be processed
 * (e.g., the given key has an unrecognized algorithm or format).
 * @apiSince 1
 */

public final <T extends java.security.spec.KeySpec> T getKeySpec(java.security.Key key, java.lang.Class<T> keySpec) throws java.security.spec.InvalidKeySpecException { throw new RuntimeException("Stub!"); }

/**
 * Translates a key object, whose provider may be unknown or potentially
 * untrusted, into a corresponding key object of this key factory.
 *
 * @param key the key whose provider is unknown or untrusted.
 *
 * @return the translated key.
 *
 * @exception java.security.InvalidKeyException if the given key cannot be processed
 * by this key factory.
 * @apiSince 1
 */

public final java.security.Key translateKey(java.security.Key key) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }
}

