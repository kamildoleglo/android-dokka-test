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
 * This immutable class holds the necessary values needed to represent
 * an elliptic curve.
 *
 * @see java.security.spec.ECField
 * @see java.security.spec.ECFieldFp
 * @see java.security.spec.ECFieldF2m
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EllipticCurve {

/**
 * Creates an elliptic curve with the specified elliptic field
 * {@code field} and the coefficients {@code a} and
 * {@code b}.
 * @param field the finite field that this elliptic curve is over.
 * @param a the first coefficient of this elliptic curve.
 * @param b the second coefficient of this elliptic curve.
 * @exception java.lang.NullPointerException if {@code field},
 * {@code a}, or {@code b} is null.
 * @exception java.lang.IllegalArgumentException if {@code a}
 * or {@code b} is not null and not in {@code field}.
 * @apiSince 1
 */

public EllipticCurve(java.security.spec.ECField field, java.math.BigInteger a, java.math.BigInteger b) { throw new RuntimeException("Stub!"); }

/**
 * Creates an elliptic curve with the specified elliptic field
 * {@code field}, the coefficients {@code a} and
 * {@code b}, and the {@code seed} used for curve generation.
 * @param field the finite field that this elliptic curve is over.
 * @param a the first coefficient of this elliptic curve.
 * @param b the second coefficient of this elliptic curve.
 * @param seed the bytes used during curve generation for later
 * validation. Contents of this array are copied to protect against
 * subsequent modification.
 * @exception java.lang.NullPointerException if {@code field},
 * {@code a}, or {@code b} is null.
 * @exception java.lang.IllegalArgumentException if {@code a}
 * or {@code b} is not null and not in {@code field}.
 * @apiSince 1
 */

public EllipticCurve(java.security.spec.ECField field, java.math.BigInteger a, java.math.BigInteger b, byte[] seed) { throw new RuntimeException("Stub!"); }

/**
 * Returns the finite field {@code field} that this
 * elliptic curve is over.
 * @return the field {@code field} that this curve
 * is over.
 * @apiSince 1
 */

public java.security.spec.ECField getField() { throw new RuntimeException("Stub!"); }

/**
 * Returns the first coefficient {@code a} of the
 * elliptic curve.
 * @return the first coefficient {@code a}.
 * @apiSince 1
 */

public java.math.BigInteger getA() { throw new RuntimeException("Stub!"); }

/**
 * Returns the second coefficient {@code b} of the
 * elliptic curve.
 * @return the second coefficient {@code b}.
 * @apiSince 1
 */

public java.math.BigInteger getB() { throw new RuntimeException("Stub!"); }

/**
 * Returns the seeding bytes {@code seed} used
 * during curve generation. May be null if not specified.
 * @return the seeding bytes {@code seed}. A new
 * array is returned each time this method is called.
 * @apiSince 1
 */

public byte[] getSeed() { throw new RuntimeException("Stub!"); }

/**
 * Compares this elliptic curve for equality with the
 * specified object.
 * @param obj the object to be compared.
 * @return true if {@code obj} is an instance of
 * EllipticCurve and the field, A, and B match, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for this elliptic curve.
 * @return a hash code value computed from the hash codes of the field, A,
 * and B, as follows:
 * <pre>{@code
 *     (field.hashCode() << 6) + (a.hashCode() << 4) + (b.hashCode() << 2)
 * }</pre>
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

