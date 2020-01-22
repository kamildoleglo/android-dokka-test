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



package java.security.spec;


/**
 * This class specifies a DSA public key with its associated parameters.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see java.security.spec.KeySpec
 * @see java.security.spec.DSAPrivateKeySpec
 * @see java.security.spec.X509EncodedKeySpec
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DSAPublicKeySpec implements java.security.spec.KeySpec {

/**
 * Creates a new DSAPublicKeySpec with the specified parameter values.
 *
 * @param y the public key.
 *
 * @param p the prime.
 *
 * @param q the sub-prime.
 *
 * @param g the base.
 * @apiSince 1
 */

public DSAPublicKeySpec(java.math.BigInteger y, java.math.BigInteger p, java.math.BigInteger q, java.math.BigInteger g) { throw new RuntimeException("Stub!"); }

/**
 * Returns the public key {@code y}.
 *
 * @return the public key {@code y}.
 * @apiSince 1
 */

public java.math.BigInteger getY() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prime {@code p}.
 *
 * @return the prime {@code p}.
 * @apiSince 1
 */

public java.math.BigInteger getP() { throw new RuntimeException("Stub!"); }

/**
 * Returns the sub-prime {@code q}.
 *
 * @return the sub-prime {@code q}.
 * @apiSince 1
 */

public java.math.BigInteger getQ() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base {@code g}.
 *
 * @return the base {@code g}.
 * @apiSince 1
 */

public java.math.BigInteger getG() { throw new RuntimeException("Stub!"); }
}

