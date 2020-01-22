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
 * This class represents the triplet (prime, exponent, and coefficient)
 * inside RSA's OtherPrimeInfo structure, as defined in the PKCS#1 v2.1.
 * The ASN.1 syntax of RSA's OtherPrimeInfo is as follows:
 *
 * <pre>
 * OtherPrimeInfo ::= SEQUENCE {
 *   prime INTEGER,
 *   exponent INTEGER,
 *   coefficient INTEGER
 *   }
 *
 * </pre>
 *
 * @author Valerie Peng
 *
 *
 * @see java.security.spec.RSAPrivateCrtKeySpec
 * @see java.security.interfaces.RSAMultiPrimePrivateCrtKey
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RSAOtherPrimeInfo {

/**
 * Creates a new {@code RSAOtherPrimeInfo}
 * given the prime, primeExponent, and
 * crtCoefficient as defined in PKCS#1.
 *
 * @param prime the prime factor of n.
 * @param primeExponent the exponent.
 * @param crtCoefficient the Chinese Remainder Theorem
 * coefficient.
 * @exception java.lang.NullPointerException if any of the parameters, i.e.
 * {@code prime}, {@code primeExponent},
 * {@code crtCoefficient}, is null.
 *
 * @apiSince 1
 */

public RSAOtherPrimeInfo(java.math.BigInteger prime, java.math.BigInteger primeExponent, java.math.BigInteger crtCoefficient) { throw new RuntimeException("Stub!"); }

/**
 * Returns the prime.
 *
 * @return the prime.
 * @apiSince 1
 */

public final java.math.BigInteger getPrime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prime's exponent.
 *
 * @return the primeExponent.
 * @apiSince 1
 */

public final java.math.BigInteger getExponent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prime's crtCoefficient.
 *
 * @return the crtCoefficient.
 * @apiSince 1
 */

public final java.math.BigInteger getCrtCoefficient() { throw new RuntimeException("Stub!"); }
}

