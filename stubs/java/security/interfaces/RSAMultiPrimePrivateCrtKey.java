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



package java.security.interfaces;


/**
 * The interface to an RSA multi-prime private key, as defined in the
 * PKCS#1 v2.1, using the <i>Chinese Remainder Theorem</i>
 * (CRT) information values.
 *
 * @author Valerie Peng
 *
 *
 * @see java.security.spec.RSAPrivateKeySpec
 * @see java.security.spec.RSAMultiPrimePrivateCrtKeySpec
 * @see java.security.interfaces.RSAPrivateKey
 * @see java.security.interfaces.RSAPrivateCrtKey
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface RSAMultiPrimePrivateCrtKey extends java.security.interfaces.RSAPrivateKey {

/**
 * Returns the public exponent.
 *
 * @return the public exponent.
 * @apiSince 1
 */

public java.math.BigInteger getPublicExponent();

/**
 * Returns the primeP.
 *
 * @return the primeP.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeP();

/**
 * Returns the primeQ.
 *
 * @return the primeQ.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeQ();

/**
 * Returns the primeExponentP.
 *
 * @return the primeExponentP.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeExponentP();

/**
 * Returns the primeExponentQ.
 *
 * @return the primeExponentQ.
 * @apiSince 1
 */

public java.math.BigInteger getPrimeExponentQ();

/**
 * Returns the crtCoefficient.
 *
 * @return the crtCoefficient.
 * @apiSince 1
 */

public java.math.BigInteger getCrtCoefficient();

/**
 * Returns the otherPrimeInfo or null if there are only
 * two prime factors (p and q).
 *
 * @return the otherPrimeInfo.
 * @apiSince 1
 */

public java.security.spec.RSAOtherPrimeInfo[] getOtherPrimeInfo();

/**
 * The type fingerprint that is set to indicate
 * serialization compatibility with a previous
 * version of the type.
 * @apiSince 1
 */

public static final long serialVersionUID = 618058533534628008L; // 0x893c8f62dbaf8a8L
}

