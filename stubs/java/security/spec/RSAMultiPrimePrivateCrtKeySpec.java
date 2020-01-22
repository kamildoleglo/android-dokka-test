/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.security.spec;


/**
 * This class specifies an RSA multi-prime private key, as defined in the
 * PKCS#1 v2.1, using the Chinese Remainder Theorem (CRT) information
 * values for efficiency.
 *
 * @author Valerie Peng
 *
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see java.security.spec.KeySpec
 * @see java.security.spec.PKCS8EncodedKeySpec
 * @see java.security.spec.RSAPrivateKeySpec
 * @see java.security.spec.RSAPublicKeySpec
 * @see java.security.spec.RSAOtherPrimeInfo
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RSAMultiPrimePrivateCrtKeySpec extends java.security.spec.RSAPrivateKeySpec {

/**
 * Creates a new {@code RSAMultiPrimePrivateCrtKeySpec}
 * given the modulus, publicExponent, privateExponent,
 * primeP, primeQ, primeExponentP, primeExponentQ,
 * crtCoefficient, and otherPrimeInfo as defined in PKCS#1 v2.1.
 *
 * <p>Note that the contents of {@code otherPrimeInfo}
 * are copied to protect against subsequent modification when
 * constructing this object.
 *
 * @param modulus the modulus n.
 * @param publicExponent the public exponent e.
 * @param privateExponent the private exponent d.
 * @param primeP the prime factor p of n.
 * @param primeQ the prime factor q of n.
 * @param primeExponentP this is d mod (p-1).
 * @param primeExponentQ this is d mod (q-1).
 * @param crtCoefficient the Chinese Remainder Theorem
 * coefficient q-1 mod p.
 * @param otherPrimeInfo triplets of the rest of primes, null can be
 * specified if there are only two prime factors (p and q).
 * @exception java.lang.NullPointerException if any of the parameters, i.e.
 * {@code modulus},
 * {@code publicExponent}, {@code privateExponent},
 * {@code primeP}, {@code primeQ},
 * {@code primeExponentP}, {@code primeExponentQ},
 * {@code crtCoefficient}, is null.
 * @exception java.lang.IllegalArgumentException if an empty, i.e. 0-length,
 * {@code otherPrimeInfo} is specified.
 * @apiSince 1
 */

public RSAMultiPrimePrivateCrtKeySpec(java.math.BigInteger modulus, java.math.BigInteger publicExponent, java.math.BigInteger privateExponent, java.math.BigInteger primeP, java.math.BigInteger primeQ, java.math.BigInteger primeExponentP, java.math.BigInteger primeExponentQ, java.math.BigInteger crtCoefficient, java.security.spec.RSAOtherPrimeInfo[] otherPrimeInfo) { super(null, null); throw new RuntimeException("Stub!"); }

/**
 * Returns the public exponent.
 *
 * @return the public exponent.
 * @apiSince 1
 */

public java.math.BigInteger getPublicExponent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeP.
 *
 * @return the primeP.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeP() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeQ.
 *
 * @return the primeQ.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeQ() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeExponentP.
 *
 * @return the primeExponentP.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeExponentP() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeExponentQ.
 *
 * @return the primeExponentQ.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeExponentQ() { throw new RuntimeException("Stub!"); }

/**
 * Returns the crtCoefficient.
 *
 * @return the crtCoefficient.
 * @apiSince 1
 */

public java.math.BigInteger getCrtCoefficient() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the otherPrimeInfo or null if there are
 * only two prime factors (p and q).
 *
 * @return the otherPrimeInfo. Returns a new array each
 * time this method is called.
 * @apiSince 1
 */

public java.security.spec.RSAOtherPrimeInfo[] getOtherPrimeInfo() { throw new RuntimeException("Stub!"); }
}

