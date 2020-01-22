/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.security.*;
import java.security.spec.*;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the <code>KeyGenerator</code> class.
 * All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a key generator for a particular algorithm.
 *
 * @author Jan Luehe
 *
 * @see javax.crypto.SecretKey
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class KeyGeneratorSpi {

/** @apiSince 1 */

public KeyGeneratorSpi() { throw new RuntimeException("Stub!"); }

/**
 * Initializes the key generator.
 *
 * @param random the source of randomness for this generator
 * @apiSince 1
 */

protected abstract void engineInit(java.security.SecureRandom random);

/**
 * Initializes the key generator with the specified parameter
 * set and a user-provided source of randomness.
 *
 * @param params the key generation parameters
 * @param random the source of randomness for this key generator
 *
 * @exception java.security.InvalidAlgorithmParameterException if <code>params</code> is
 * inappropriate for this key generator
 * @apiSince 1
 */

protected abstract void engineInit(java.security.spec.AlgorithmParameterSpec params, java.security.SecureRandom random) throws java.security.InvalidAlgorithmParameterException;

/**
 * Initializes this key generator for a certain keysize, using the given
 * source of randomness.
 *
 * @param keysize the keysize. This is an algorithm-specific metric,
 * specified in number of bits.
 * @param random the source of randomness for this key generator
 *
 * @exception java.security.InvalidParameterException if the keysize is wrong or not
 * supported.
 * @apiSince 1
 */

protected abstract void engineInit(int keysize, java.security.SecureRandom random);

/**
 * Generates a secret key.
 *
 * @return the new key
 * @apiSince 1
 */

protected abstract javax.crypto.SecretKey engineGenerateKey();
}

