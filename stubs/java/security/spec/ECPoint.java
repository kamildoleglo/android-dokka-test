/*
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
 * This immutable class represents a point on an elliptic curve (EC)
 * in affine coordinates. Other coordinate systems can
 * extend this class to represent this point in other
 * coordinates.
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ECPoint {

/**
 * Creates an ECPoint from the specified affine x-coordinate
 * {@code x} and affine y-coordinate {@code y}.
 * @param x the affine x-coordinate.
 * @param y the affine y-coordinate.
 * @exception java.lang.NullPointerException if {@code x} or
 * {@code y} is null.
 * @apiSince 1
 */

public ECPoint(java.math.BigInteger x, java.math.BigInteger y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the affine x-coordinate {@code x}.
 * Note: POINT_INFINITY has a null affine x-coordinate.
 * @return the affine x-coordinate.
 * @apiSince 1
 */

public java.math.BigInteger getAffineX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the affine y-coordinate {@code y}.
 * Note: POINT_INFINITY has a null affine y-coordinate.
 * @return the affine y-coordinate.
 * @apiSince 1
 */

public java.math.BigInteger getAffineY() { throw new RuntimeException("Stub!"); }

/**
 * Compares this elliptic curve point for equality with
 * the specified object.
 * @param obj the object to be compared.
 * @return true if {@code obj} is an instance of
 * ECPoint and the affine coordinates match, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for this elliptic curve point.
 * @return a hash code value.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * This defines the point at infinity.
 * @apiSince 1
 */

public static final java.security.spec.ECPoint POINT_INFINITY;
static { POINT_INFINITY = null; }
}

