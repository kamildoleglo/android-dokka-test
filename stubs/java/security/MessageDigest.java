/*
 * Copyright (c) 1996, 2015, Oracle and/or its affiliates. All rights reserved.
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



package java.security;

import java.util.*;
import java.lang.*;
import java.nio.ByteBuffer;

/**
 * This MessageDigest class provides applications the functionality of a
 * message digest algorithm, such as SHA-1 or SHA-256.
 * Message digests are secure one-way hash functions that take arbitrary-sized
 * data and output a fixed-length hash value.
 *
 * <p>A MessageDigest object starts out initialized. The data is
 * processed through it using the {@link #update(byte) update}
 * methods. At any point {@link #reset() reset} can be called
 * to reset the digest. Once all the data to be updated has been
 * updated, one of the {@link #digest() digest} methods should
 * be called to complete the hash computation.
 *
 * <p>The {@code digest} method can be called once for a given number
 * of updates. After {@code digest} has been called, the MessageDigest
 * object is reset to its initialized state.
 *
 * <p>Implementations are free to implement the Cloneable interface.
 * Client applications can test cloneability by attempting cloning
 * and catching the CloneNotSupportedException:
 *
 * <pre>{@code
 * MessageDigest md = MessageDigest.getInstance("SHA");
 *
 * try {
 *     md.update(toChapter1);
 *     MessageDigest tc1 = md.clone();
 *     byte[] toChapter1Digest = tc1.digest();
 *     md.update(toChapter2);
 *     ...etc.
 * } catch (CloneNotSupportedException cnse) {
 *     throw new DigestException("couldn't make digest of partial content");
 * }
 * }</pre>
 *
 * <p>Note that if a given implementation is not cloneable, it is
 * still possible to compute intermediate digests by instantiating
 * several instances, if the number of digests is known in advance.
 *
 * <p>Note that this class is abstract and extends from
 * {@code MessageDigestSpi} for historical reasons.
 * Application developers should only take notice of the methods defined in
 * this {@code MessageDigest} class; all the methods in
 * the superclass are intended for cryptographic service providers who wish to
 * supply their own implementations of message digest algorithms.
 *
 * <p> Android provides the following <code>MessageDigest</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>MD5</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA-1</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA-224</td>
 *       <td>1-8,22+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA-256</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA-384</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA-512</td>
 *       <td>1+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These algorithms are described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">
 * MessageDigest section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Benjamin Renaud
 *
 * @see java.security.DigestInputStream
 * @see java.security.DigestOutputStream
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class MessageDigest extends java.security.MessageDigestSpi {

/**
 * Creates a message digest with the specified algorithm name.
 *
 * @param algorithm the standard name of the digest algorithm.
 * See the MessageDigest section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 * @apiSince 1
 */

protected MessageDigest(@androidx.annotation.NonNull java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns a MessageDigest object that implements the specified digest
 * algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new MessageDigest object encapsulating the
 * MessageDigestSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the algorithm requested.
 * See the MessageDigest section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return a Message Digest object that implements the specified algorithm.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          MessageDigestSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.security.MessageDigest getInstance(@androidx.annotation.NonNull java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a MessageDigest object that implements the specified digest
 * algorithm.
 *
 * <p> A new MessageDigest object encapsulating the
 * MessageDigestSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the algorithm requested.
 * See the MessageDigest section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return a MessageDigest object that implements the specified algorithm.
 *
 * @exception java.security.NoSuchAlgorithmException if a MessageDigestSpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @exception java.security.NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception java.lang.IllegalArgumentException if the provider name is null
 *          or empty.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.security.MessageDigest getInstance(@androidx.annotation.NonNull java.lang.String algorithm, @androidx.annotation.NonNull java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a MessageDigest object that implements the specified digest
 * algorithm.
 *
 * <p> A new MessageDigest object encapsulating the
 * MessageDigestSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the name of the algorithm requested.
 * See the MessageDigest section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return a MessageDigest object that implements the specified algorithm.
 *
 * @exception java.security.NoSuchAlgorithmException if a MessageDigestSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the specified provider is null.
 *
 * @see java.security.Provider
 *
 * @since 1.4
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.security.MessageDigest getInstance(@androidx.annotation.NonNull java.lang.String algorithm, @androidx.annotation.NonNull java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this message digest object.
 *
 * @return the provider of this message digest object
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Updates the digest using the specified byte.
 *
 * @param input the byte with which to update the digest.
 * @apiSince 1
 */

public void update(byte input) { throw new RuntimeException("Stub!"); }

/**
 * Updates the digest using the specified array of bytes, starting
 * at the specified offset.
 *
 * @param input the array of bytes.
 *
 * @param offset the offset to start from in the array of bytes.
 *
 * @param len the number of bytes to use, starting at
 * {@code offset}.
 * @apiSince 1
 */

public void update(@androidx.annotation.NonNull byte[] input, int offset, int len) { throw new RuntimeException("Stub!"); }

/**
 * Updates the digest using the specified array of bytes.
 *
 * @param input the array of bytes.
 * @apiSince 1
 */

public void update(@androidx.annotation.NonNull byte[] input) { throw new RuntimeException("Stub!"); }

/**
 * Update the digest using the specified ByteBuffer. The digest is
 * updated using the {@code input.remaining()} bytes starting
 * at {@code input.position()}.
 * Upon return, the buffer's position will be equal to its limit;
 * its limit will not have changed.
 *
 * @param input the ByteBuffer
 * @since 1.5
 * @apiSince 1
 */

public final void update(@androidx.annotation.NonNull java.nio.ByteBuffer input) { throw new RuntimeException("Stub!"); }

/**
 * Completes the hash computation by performing final operations
 * such as padding. The digest is reset after this call is made.
 *
 * @return the array of bytes for the resulting hash value.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public byte[] digest() { throw new RuntimeException("Stub!"); }

/**
 * Completes the hash computation by performing final operations
 * such as padding. The digest is reset after this call is made.
 *
 * @param buf output buffer for the computed digest
 *
 * @param offset offset into the output buffer to begin storing the digest
 *
 * @param len number of bytes within buf allotted for the digest
 *
 * @return the number of bytes placed into {@code buf}
 *
 * @exception java.security.DigestException if an error occurs.
 * @apiSince 1
 */

public int digest(@androidx.annotation.NonNull byte[] buf, int offset, int len) throws java.security.DigestException { throw new RuntimeException("Stub!"); }

/**
 * Performs a final update on the digest using the specified array
 * of bytes, then completes the digest computation. That is, this
 * method first calls {@link #update(byte[]) update(input)},
 * passing the <i>input</i> array to the {@code update} method,
 * then calls {@link #digest() digest()}.
 *
 * @param input the input to be updated before the digest is
 * completed.
 *
 * @return the array of bytes for the resulting hash value.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public byte[] digest(@androidx.annotation.NonNull byte[] input) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this message digest object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Compares two digests for equality. Does a simple byte compare.
 *
 * @param digesta one of the digests to compare.
 *
 * @param digestb the other digest to compare.
 *
 * @return true if the digests are equal, false otherwise.
 * @apiSince 1
 */

public static boolean isEqual(@androidx.annotation.Nullable byte[] digesta, @androidx.annotation.Nullable byte[] digestb) { throw new RuntimeException("Stub!"); }

/**
 * Resets the digest for further use.
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string that identifies the algorithm, independent of
 * implementation details. The name should be a standard
 * Java Security name (such as "SHA", "MD5", and so on).
 * See the MessageDigest section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the name of the algorithm
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the digest in bytes, or 0 if this operation is
 * not supported by the provider and the implementation is not cloneable.
 *
 * @return the digest length in bytes, or 0 if this operation is not
 * supported by the provider and the implementation is not cloneable.
 *
 * @since 1.2
 * @apiSince 1
 */

public final int getDigestLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns a clone if the implementation is cloneable.
 *
 * @return a clone if the implementation is cloneable.
 *
 * @exception java.lang.CloneNotSupportedException if this is called on an
 * implementation that does not support {@code Cloneable}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }
}

