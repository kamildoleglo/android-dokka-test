/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
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
 * This class specifies an RSA public key.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see java.security.spec.KeySpec
 * @see java.security.spec.X509EncodedKeySpec
 * @see java.security.spec.RSAPrivateKeySpec
 * @see java.security.spec.RSAPrivateCrtKeySpec
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RSAPublicKeySpec implements java.security.spec.KeySpec {

/**
 * Creates a new RSAPublicKeySpec.
 *
 * @param modulus the modulus
 * @param publicExponent the public exponent
 * @apiSince 1
 */

public RSAPublicKeySpec(java.math.BigInteger modulus, java.math.BigInteger publicExponent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the modulus.
 *
 * @return the modulus
 * @apiSince 1
 */

public java.math.BigInteger getModulus() { throw new RuntimeException("Stub!"); }

/**
 * Returns the public exponent.
 *
 * @return the public exponent
 * @apiSince 1
 */

public java.math.BigInteger getPublicExponent() { throw new RuntimeException("Stub!"); }
}

