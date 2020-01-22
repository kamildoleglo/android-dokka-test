/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * This immutable class specifies the set of domain parameters
 * used with elliptic curve cryptography (ECC).
 *
 * @see java.security.spec.AlgorithmParameterSpec
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ECParameterSpec implements java.security.spec.AlgorithmParameterSpec {

/**
 * Creates elliptic curve domain parameters based on the
 * specified values.
 * @param curve the elliptic curve which this parameter
 * defines.
 * @param g the generator which is also known as the base point.
 * @param n the order of the generator {@code g}.
 * @param h the cofactor.
 * @exception java.lang.NullPointerException if {@code curve},
 * {@code g}, or {@code n} is null.
 * @exception java.lang.IllegalArgumentException if {@code n}
 * or {@code h} is not positive.
 * @apiSince 1
 */

public ECParameterSpec(java.security.spec.EllipticCurve curve, java.security.spec.ECPoint g, java.math.BigInteger n, int h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the elliptic curve that this parameter defines.
 * @return the elliptic curve that this parameter defines.
 * @apiSince 1
 */

public java.security.spec.EllipticCurve getCurve() { throw new RuntimeException("Stub!"); }

/**
 * Returns the generator which is also known as the base point.
 * @return the generator which is also known as the base point.
 * @apiSince 1
 */

public java.security.spec.ECPoint getGenerator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the order of the generator.
 * @return the order of the generator.
 * @apiSince 1
 */

public java.math.BigInteger getOrder() { throw new RuntimeException("Stub!"); }

/**
 * Returns the cofactor.
 * @return the cofactor.
 * @apiSince 1
 */

public int getCofactor() { throw new RuntimeException("Stub!"); }
}

