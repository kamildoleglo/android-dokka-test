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
 * This immutable class defines an elliptic curve (EC) prime
 * finite field.
 *
 * @see java.security.spec.ECField
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ECFieldFp implements java.security.spec.ECField {

/**
 * Creates an elliptic curve prime finite field
 * with the specified prime {@code p}.
 * @param p the prime.
 * @exception java.lang.NullPointerException if {@code p} is null.
 * @exception java.lang.IllegalArgumentException if {@code p}
 * is not positive.
 * @apiSince 1
 */

public ECFieldFp(java.math.BigInteger p) { throw new RuntimeException("Stub!"); }

/**
 * Returns the field size in bits which is size of prime p
 * for this prime finite field.
 * @return the field size in bits.
 * @apiSince 1
 */

public int getFieldSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prime {@code p} of this prime finite field.
 * @return the prime.
 * @apiSince 1
 */

public java.math.BigInteger getP() { throw new RuntimeException("Stub!"); }

/**
 * Compares this prime finite field for equality with the
 * specified object.
 * @param obj the object to be compared.
 * @return true if {@code obj} is an instance
 * of ECFieldFp and the prime value match, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for this prime finite field.
 * @return a hash code value.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

