/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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



package javax.crypto.spec;


/**
 * This class specifies the parameters used with the
 * <a href="http://www.ietf.org/rfc/rfc2268.txt"><i>RC2</i></a>
 * algorithm.
 *
 * <p> The parameters consist of an effective key size and optionally
 * an 8-byte initialization vector (IV) (only in feedback mode).
 *
 * <p> This class can be used to initialize a <code>Cipher</code> object that
 * implements the <i>RC2</i> algorithm.
 *
 * @author Jan Luehe
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RC2ParameterSpec implements java.security.spec.AlgorithmParameterSpec {

/**
 * Constructs a parameter set for RC2 from the given effective key size
 * (in bits).
 *
 * @param effectiveKeyBits the effective key size in bits.
 * @apiSince 1
 */

public RC2ParameterSpec(int effectiveKeyBits) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a parameter set for RC2 from the given effective key size
 * (in bits) and an 8-byte IV.
 *
 * <p> The bytes that constitute the IV are those between
 * <code>iv[0]</code> and <code>iv[7]</code> inclusive.
 *
 * @param effectiveKeyBits the effective key size in bits.
 * @param iv the buffer with the 8-byte IV. The first 8 bytes of
 * the buffer are copied to protect against subsequent modification.
 * @exception java.lang.IllegalArgumentException if <code>iv</code> is null.
 * @apiSince 1
 */

public RC2ParameterSpec(int effectiveKeyBits, byte[] iv) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a parameter set for RC2 from the given effective key size
 * (in bits) and IV.
 *
 * <p> The IV is taken from <code>iv</code>, starting at
 * <code>offset</code> inclusive.
 * The bytes that constitute the IV are those between
 * <code>iv[offset]</code> and <code>iv[offset+7]</code> inclusive.
 *
 * @param effectiveKeyBits the effective key size in bits.
 * @param iv the buffer with the IV. The first 8 bytes
 * of the buffer beginning at <code>offset</code> inclusive
 * are copied to protect against subsequent modification.
 * @param offset the offset in <code>iv</code> where the 8-byte IV
 * starts.
 * @exception java.lang.IllegalArgumentException if <code>iv</code> is null.
 * @apiSince 1
 */

public RC2ParameterSpec(int effectiveKeyBits, byte[] iv, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Returns the effective key size in bits.
 *
 * @return the effective key size in bits.
 * @apiSince 1
 */

public int getEffectiveKeyBits() { throw new RuntimeException("Stub!"); }

/**
 * Returns the IV or null if this parameter set does not contain an IV.
 *
 * @return the IV or null if this parameter set does not contain an IV.
 * Returns a new array each time this method is called.
 * @apiSince 1
 */

public byte[] getIV() { throw new RuntimeException("Stub!"); }

/**
 * Tests for equality between the specified object and this
 * object. Two RC2ParameterSpec objects are considered equal if their
 * effective key sizes and IVs are equal.
 * (Two IV references are considered equal if both are <tt>null</tt>.)
 *
 * @param obj the object to test for equality with this object.
 *
 * @return true if the objects are considered equal, false if
 * <code>obj</code> is null or otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Calculates a hash code value for the object.
 * Objects that are equal will also have the same hashcode.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

