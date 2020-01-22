/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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



package javax.crypto;

import java.util.*;
import java.security.*;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;

/**
 * This class provides the functionality of a "Message Authentication Code"
 * (MAC) algorithm.
 *
 * <p> A MAC provides a way to check
 * the integrity of information transmitted over or stored in an unreliable
 * medium, based on a secret key. Typically, message
 * authentication codes are used between two parties that share a secret
 * key in order to validate information transmitted between these
 * parties.
 *
 * <p> A MAC mechanism that is based on cryptographic hash functions is
 * referred to as HMAC. HMAC can be used with any cryptographic hash function,
 * e.g., MD5 or SHA-1, in combination with a secret shared key. HMAC is
 * specified in RFC 2104.
 *
 * <p> Android provides the following <code>Mac</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr class="deprecated">
 *       <td>DESMAC</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DESMAC/CFB8</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DESedeMAC</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DESedeMAC/CFB8</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DESedeMAC64</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DESwithISO9797</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>HmacMD5</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA1</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA224</td>
 *       <td>1-8,22+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA256</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA384</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>HmacSHA512</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>ISO9797ALG3MAC</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>PBEwithHmacSHA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>PBEwithHmacSHA1</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>PBEwithHmacSHA224</td>
 *       <td>26+</td>
 *     </tr>
 *     <tr>
 *       <td>PBEwithHmacSHA256</td>
 *       <td>26+</td>
 *     </tr>
 *     <tr>
 *       <td>PBEwithHmacSHA384</td>
 *       <td>26+</td>
 *     </tr>
 *     <tr>
 *       <td>PBEwithHmacSHA512</td>
 *       <td>26+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These algorithms are described in the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Mac">
 * Mac section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Jan Luehe
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Mac implements java.lang.Cloneable {

/**
 * Creates a MAC object.
 *
 * @param macSpi the delegate
 * @param provider the provider
 * @param algorithm the algorithm
 * @apiSince 1
 */

protected Mac(javax.crypto.MacSpi macSpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm name of this <code>Mac</code> object.
 *
 * <p>This is the same name that was specified in one of the
 * <code>getInstance</code> calls that created this
 * <code>Mac</code> object.
 *
 * @return the algorithm name of this <code>Mac</code> object.
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>Mac</code> object that implements the
 * specified MAC algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new Mac object encapsulating the
 * MacSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the requested MAC algorithm.
 * See the Mac section in the <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Mac">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the new <code>Mac</code> object.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          MacSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.Mac getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>Mac</code> object that implements the
 * specified MAC algorithm.
 *
 * <p> A new Mac object encapsulating the
 * MacSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the requested MAC algorithm.
 * See the Mac section in the <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Mac">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new <code>Mac</code> object.
 *
 * @exception java.security.NoSuchAlgorithmException if a MacSpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @exception java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception java.lang.IllegalArgumentException if the <code>provider</code>
 *          is null or empty.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.Mac getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>Mac</code> object that implements the
 * specified MAC algorithm.
 *
 * <p> A new Mac object encapsulating the
 * MacSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the standard name of the requested MAC algorithm.
 * See the Mac section in the <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Mac">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return the new <code>Mac</code> object.
 *
 * @exception java.security.NoSuchAlgorithmException if a MacSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the <code>provider</code>
 *          is null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.Mac getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this <code>Mac</code> object.
 *
 * @return the provider of this <code>Mac</code> object.
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the MAC in bytes.
 *
 * @return the MAC length in bytes.
 * @apiSince 1
 */

public final int getMacLength() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this <code>Mac</code> object with the given key.
 *
 * @param key the key.
 *
 * @exception java.security.InvalidKeyException if the given key is inappropriate for
 * initializing this MAC.
 * @apiSince 1
 */

public final void init(java.security.Key key) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this <code>Mac</code> object with the given key and
 * algorithm parameters.
 *
 * @param key the key.
 * @param params the algorithm parameters.
 *
 * @exception java.security.InvalidKeyException if the given key is inappropriate for
 * initializing this MAC.
 * @exception java.security.InvalidAlgorithmParameterException if the given algorithm
 * parameters are inappropriate for this MAC.
 * @apiSince 1
 */

public final void init(java.security.Key key, java.security.spec.AlgorithmParameterSpec params) throws java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Processes the given byte.
 *
 * @param input the input byte to be processed.
 *
 * @exception java.lang.IllegalStateException if this <code>Mac</code> has not been
 * initialized.
 * @apiSince 1
 */

public final void update(byte input) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Processes the given array of bytes.
 *
 * @param input the array of bytes to be processed.
 *
 * @exception java.lang.IllegalStateException if this <code>Mac</code> has not been
 * initialized.
 * @apiSince 1
 */

public final void update(byte[] input) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Processes the first <code>len</code> bytes in <code>input</code>,
 * starting at <code>offset</code> inclusive.
 *
 * @param input the input buffer.
 * @param offset the offset in <code>input</code> where the input starts.
 * @param len the number of bytes to process.
 *
 * @exception java.lang.IllegalStateException if this <code>Mac</code> has not been
 * initialized.
 * @apiSince 1
 */

public final void update(byte[] input, int offset, int len) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Processes <code>input.remaining()</code> bytes in the ByteBuffer
 * <code>input</code>, starting at <code>input.position()</code>.
 * Upon return, the buffer's position will be equal to its limit;
 * its limit will not have changed.
 *
 * @param input the ByteBuffer
 *
 * @exception java.lang.IllegalStateException if this <code>Mac</code> has not been
 * initialized.
 * @since 1.5
 * @apiSince 1
 */

public final void update(java.nio.ByteBuffer input) { throw new RuntimeException("Stub!"); }

/**
 * Finishes the MAC operation.
 *
 * <p>A call to this method resets this <code>Mac</code> object to the
 * state it was in when previously initialized via a call to
 * <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 * That is, the object is reset and available to generate another MAC from
 * the same key, if desired, via new calls to <code>update</code> and
 * <code>doFinal</code>.
 * (In order to reuse this <code>Mac</code> object with a different key,
 * it must be reinitialized via a call to <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 *
 * @return the MAC result.
 *
 * @exception java.lang.IllegalStateException if this <code>Mac</code> has not been
 * initialized.
 * @apiSince 1
 */

public final byte[] doFinal() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Finishes the MAC operation.
 *
 * <p>A call to this method resets this <code>Mac</code> object to the
 * state it was in when previously initialized via a call to
 * <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 * That is, the object is reset and available to generate another MAC from
 * the same key, if desired, via new calls to <code>update</code> and
 * <code>doFinal</code>.
 * (In order to reuse this <code>Mac</code> object with a different key,
 * it must be reinitialized via a call to <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 *
 * <p>The MAC result is stored in <code>output</code>, starting at
 * <code>outOffset</code> inclusive.
 *
 * @param output the buffer where the MAC result is stored
 * @param outOffset the offset in <code>output</code> where the MAC is
 * stored
 *
 * @exception javax.crypto.ShortBufferException if the given output buffer is too small
 * to hold the result
 * @exception java.lang.IllegalStateException if this <code>Mac</code> has not been
 * initialized.
 * @apiSince 1
 */

public final void doFinal(byte[] output, int outOffset) throws java.lang.IllegalStateException, javax.crypto.ShortBufferException { throw new RuntimeException("Stub!"); }

/**
 * Processes the given array of bytes and finishes the MAC operation.
 *
 * <p>A call to this method resets this <code>Mac</code> object to the
 * state it was in when previously initialized via a call to
 * <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 * That is, the object is reset and available to generate another MAC from
 * the same key, if desired, via new calls to <code>update</code> and
 * <code>doFinal</code>.
 * (In order to reuse this <code>Mac</code> object with a different key,
 * it must be reinitialized via a call to <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 *
 * @param input data in bytes
 * @return the MAC result.
 *
 * @exception java.lang.IllegalStateException if this <code>Mac</code> has not been
 * initialized.
 * @apiSince 1
 */

public final byte[] doFinal(byte[] input) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Resets this <code>Mac</code> object.
 *
 * <p>A call to this method resets this <code>Mac</code> object to the
 * state it was in when previously initialized via a call to
 * <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 * That is, the object is reset and available to generate another MAC from
 * the same key, if desired, via new calls to <code>update</code> and
 * <code>doFinal</code>.
 * (In order to reuse this <code>Mac</code> object with a different key,
 * it must be reinitialized via a call to <code>init(Key)</code> or
 * <code>init(Key, AlgorithmParameterSpec)</code>.
 * @apiSince 1
 */

public final void reset() { throw new RuntimeException("Stub!"); }

/**
 * Returns a clone if the provider implementation is cloneable.
 *
 * @return a clone if the provider implementation is cloneable.
 *
 * @exception java.lang.CloneNotSupportedException if this is called on a
 * delegate that does not support <code>Cloneable</code>.
 * @apiSince 1
 */

public final java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }
}

