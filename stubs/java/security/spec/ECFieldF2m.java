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

import java.math.BigInteger;

/**
 * This immutable class defines an elliptic curve (EC)
 * characteristic 2 finite field.
 *
 * @see java.security.spec.ECField
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ECFieldF2m implements java.security.spec.ECField {

/**
 * Creates an elliptic curve characteristic 2 finite
 * field which has 2^{@code m} elements with normal basis.
 * @param m with 2^{@code m} being the number of elements.
 * @exception java.lang.IllegalArgumentException if {@code m}
 * is not positive.
 * @apiSince 1
 */

public ECFieldF2m(int m) { throw new RuntimeException("Stub!"); }

/**
 * Creates an elliptic curve characteristic 2 finite
 * field which has 2^{@code m} elements with
 * polynomial basis.
 * The reduction polynomial for this field is based
 * on {@code rp} whose i-th bit corresponds to
 * the i-th coefficient of the reduction polynomial.<p>
 * Note: A valid reduction polynomial is either a
 * trinomial (X^{@code m} + X^{@code k} + 1
 * with {@code m} &gt; {@code k} &gt;= 1) or a
 * pentanomial (X^{@code m} + X^{@code k3}
 * + X^{@code k2} + X^{@code k1} + 1 with
 * {@code m} &gt; {@code k3} &gt; {@code k2}
 * &gt; {@code k1} &gt;= 1).
 * @param m with 2^{@code m} being the number of elements.
 * @param rp the BigInteger whose i-th bit corresponds to
 * the i-th coefficient of the reduction polynomial.
 * @exception java.lang.NullPointerException if {@code rp} is null.
 * @exception java.lang.IllegalArgumentException if {@code m}
 * is not positive, or {@code rp} does not represent
 * a valid reduction polynomial.
 * @apiSince 1
 */

public ECFieldF2m(int m, java.math.BigInteger rp) { throw new RuntimeException("Stub!"); }

/**
 * Creates an elliptic curve characteristic 2 finite
 * field which has 2^{@code m} elements with
 * polynomial basis. The reduction polynomial for this
 * field is based on {@code ks} whose content
 * contains the order of the middle term(s) of the
 * reduction polynomial.
 * Note: A valid reduction polynomial is either a
 * trinomial (X^{@code m} + X^{@code k} + 1
 * with {@code m} &gt; {@code k} &gt;= 1) or a
 * pentanomial (X^{@code m} + X^{@code k3}
 * + X^{@code k2} + X^{@code k1} + 1 with
 * {@code m} &gt; {@code k3} &gt; {@code k2}
 * &gt; {@code k1} &gt;= 1), so {@code ks} should
 * have length 1 or 3.
 * @param m with 2^{@code m} being the number of elements.
 * @param ks the order of the middle term(s) of the
 * reduction polynomial. Contents of this array are copied
 * to protect against subsequent modification.
 * @exception java.lang.NullPointerException if {@code ks} is null.
 * @exception java.lang.IllegalArgumentException if{@code m}
 * is not positive, or the length of {@code ks}
 * is neither 1 nor 3, or values in {@code ks}
 * are not between {@code m}-1 and 1 (inclusive)
 * and in descending order.
 * @apiSince 1
 */

public ECFieldF2m(int m, int[] ks) { throw new RuntimeException("Stub!"); }

/**
 * Returns the field size in bits which is {@code m}
 * for this characteristic 2 finite field.
 * @return the field size in bits.
 * @apiSince 1
 */

public int getFieldSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value {@code m} of this characteristic
 * 2 finite field.
 * @return {@code m} with 2^{@code m} being the
 * number of elements.
 * @apiSince 1
 */

public int getM() { throw new RuntimeException("Stub!"); }

/**
 * Returns a BigInteger whose i-th bit corresponds to the
 * i-th coefficient of the reduction polynomial for polynomial
 * basis or null for normal basis.
 * @return a BigInteger whose i-th bit corresponds to the
 * i-th coefficient of the reduction polynomial for polynomial
 * basis or null for normal basis.
 * @apiSince 1
 */

public java.math.BigInteger getReductionPolynomial() { throw new RuntimeException("Stub!"); }

/**
 * Returns an integer array which contains the order of the
 * middle term(s) of the reduction polynomial for polynomial
 * basis or null for normal basis.
 * @return an integer array which contains the order of the
 * middle term(s) of the reduction polynomial for polynomial
 * basis or null for normal basis. A new array is returned
 * each time this method is called.
 * @apiSince 1
 */

public int[] getMidTermsOfReductionPolynomial() { throw new RuntimeException("Stub!"); }

/**
 * Compares this finite field for equality with the
 * specified object.
 * @param obj the object to be compared.
 * @return true if {@code obj} is an instance
 * of ECFieldF2m and both {@code m} and the reduction
 * polynomial match, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for this characteristic 2
 * finite field.
 * @return a hash code value.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

