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

import java.security.spec.KeySpec;
import java.security.spec.InvalidKeySpecException;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the {@code KeyFactory} class.
 * All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a key factory for a particular algorithm.
 *
 * <P> Key factories are used to convert <I>keys</I> (opaque
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
 * <P> A provider should document all the key specifications supported by its
 * key factory.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.KeyFactory
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
public abstract class KeyFactorySpi {

/** @apiSince 1 */

public KeyFactorySpi() { throw new RuntimeException("Stub!"); }

/**
 * Generates a public key object from the provided key
 * specification (key material).
 *
 * @param keySpec the specification (key material) of the public key.
 *
 * @return the public key.
 *
 * @exception java.security.spec.InvalidKeySpecException if the given key specification
 * is inappropriate for this key factory to produce a public key.
 * @apiSince 1
 */

protected abstract java.security.PublicKey engineGeneratePublic(java.security.spec.KeySpec keySpec) throws java.security.spec.InvalidKeySpecException;

/**
 * Generates a private key object from the provided key
 * specification (key material).
 *
 * @param keySpec the specification (key material) of the private key.
 *
 * @return the private key.
 *
 * @exception java.security.spec.InvalidKeySpecException if the given key specification
 * is inappropriate for this key factory to produce a private key.
 * @apiSince 1
 */

protected abstract java.security.PrivateKey engineGeneratePrivate(java.security.spec.KeySpec keySpec) throws java.security.spec.InvalidKeySpecException;

/**
 * Returns a specification (key material) of the given key
 * object.
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
 
 * @exception java.security.spec.InvalidKeySpecException if the requested key specification is
 * inappropriate for the given key, or the given key cannot be dealt with
 * (e.g., the given key has an unrecognized format).
 * @apiSince 1
 */

protected abstract <T extends java.security.spec.KeySpec> T engineGetKeySpec(java.security.Key key, java.lang.Class<T> keySpec) throws java.security.spec.InvalidKeySpecException;

/**
 * Translates a key object, whose provider may be unknown or
 * potentially untrusted, into a corresponding key object of this key
 * factory.
 *
 * @param key the key whose provider is unknown or untrusted.
 *
 * @return the translated key.
 *
 * @exception java.security.InvalidKeyException if the given key cannot be processed
 * by this key factory.
 * @apiSince 1
 */

protected abstract java.security.Key engineTranslateKey(java.security.Key key) throws java.security.InvalidKeyException;
}

