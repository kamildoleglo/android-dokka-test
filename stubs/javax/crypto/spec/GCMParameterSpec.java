/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Specifies the set of parameters required by a {@link
 * javax.crypto.Cipher} using the Galois/Counter Mode (GCM) mode.
 * <p>
 * Simple block cipher modes (such as CBC) generally require only an
 * initialization vector (such as {@code IvParameterSpec}),
 * but GCM needs these parameters:
 * <ul>
 * <li>{@code IV}: Initialization Vector (IV) </li>
 * <li>{@code tLen}: length (in bits) of authentication tag T</li>
 * </ul>
 * <p>
 * In addition to the parameters described here, other GCM inputs/output
 * (Additional Authenticated Data (AAD), Keys, block ciphers,
 * plain/ciphertext and authentication tags) are handled in the {@code
 * Cipher} class.
 * <p>
 * Please see <a href="http://www.ietf.org/rfc/rfc5116.txt"> RFC 5116
 * </a> for more information on the Authenticated Encryption with
 * Associated Data (AEAD) algorithm, and <a href=
 * "http://csrc.nist.gov/publications/nistpubs/800-38D/SP-800-38D.pdf">
 * NIST Special Publication 800-38D</a>, "NIST Recommendation for Block
 * Cipher Modes of Operation:  Galois/Counter Mode (GCM) and GMAC."
 * <p>
 * The GCM specification states that {@code tLen} may only have the
 * values {128, 120, 112, 104, 96}, or {64, 32} for certain
 * applications.  Other values can be specified for this class, but not
 * all CSP implementations will support them.
 *
 * @see javax.crypto.Cipher
 *
 * @since 1.7
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GCMParameterSpec implements java.security.spec.AlgorithmParameterSpec {

/**
 * Constructs a GCMParameterSpec using the specified authentication
 * tag bit-length and IV buffer.
 *
 * @param tLen the authentication tag length (in bits)
 * @param src the IV source buffer.  The contents of the buffer are
 * copied to protect against subsequent modification.
 *
 * @throws java.lang.IllegalArgumentException if {@code tLen} is negative,
 * or {@code src} is null.
 * @apiSince 19
 */

public GCMParameterSpec(int tLen, byte[] src) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a GCMParameterSpec object using the specified
 * authentication tag bit-length and a subset of the specified
 * buffer as the IV.
 *
 * @param tLen the authentication tag length (in bits)
 * @param src the IV source buffer.  The contents of the
 * buffer are copied to protect against subsequent modification.
 * @param offset the offset in {@code src} where the IV starts
 * @param len the number of IV bytes
 *
 * @throws java.lang.IllegalArgumentException if {@code tLen} is negative,
 * {@code src} is null, {@code len} or {@code offset} is negative,
 * or the sum of {@code offset} and {@code len} is greater than the
 * length of the {@code src} byte array.
 * @apiSince 19
 */

public GCMParameterSpec(int tLen, byte[] src, int offset, int len) { throw new RuntimeException("Stub!"); }

/**
 * Returns the authentication tag length.
 *
 * @return the authentication tag length (in bits)
 * @apiSince 19
 */

public int getTLen() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Initialization Vector (IV).
 *
 * @return the IV.  Creates a new array each time this method
 * is called.
 * @apiSince 19
 */

public byte[] getIV() { throw new RuntimeException("Stub!"); }
}

