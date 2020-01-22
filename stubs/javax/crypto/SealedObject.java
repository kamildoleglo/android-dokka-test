/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.NoSuchProviderException;

/**
 * This class enables a programmer to create an object and protect its
 * confidentiality with a cryptographic algorithm.
 *
 * <p> Given any Serializable object, one can create a SealedObject
 * that encapsulates the original object, in serialized
 * format (i.e., a "deep copy"), and seals (encrypts) its serialized contents,
 * using a cryptographic algorithm such as DES, to protect its
 * confidentiality.  The encrypted content can later be decrypted (with
 * the corresponding algorithm using the correct decryption key) and
 * de-serialized, yielding the original object.
 *
 * <p> Note that the Cipher object must be fully initialized with the
 * correct algorithm, key, padding scheme, etc., before being applied
 * to a SealedObject.
 *
 * <p> The original object that was sealed can be recovered in two different
 * ways:
 *
 * <ul>
 *
 * <li>by using the {@link #getObject(javax.crypto.Cipher) getObject}
 * method that takes a <code>Cipher</code> object.
 *
 * <p> This method requires a fully initialized <code>Cipher</code> object,
 * initialized with the
 * exact same algorithm, key, padding scheme, etc., that were used to seal the
 * object.
 *
 * <p> This approach has the advantage that the party who unseals the
 * sealed object does not require knowledge of the decryption key. For example,
 * after one party has initialized the cipher object with the required
 * decryption key, it could hand over the cipher object to
 * another party who then unseals the sealed object.
 *
 * <li>by using one of the
 * {@link #getObject(java.security.Key) getObject} methods
 * that take a <code>Key</code> object.
 *
 * <p> In this approach, the <code>getObject</code> method creates a cipher
 * object for the appropriate decryption algorithm and initializes it with the
 * given decryption key and the algorithm parameters (if any) that were stored
 * in the sealed object.
 *
 * <p> This approach has the advantage that the party who
 * unseals the object does not need to keep track of the parameters (e.g., an
 * IV) that were used to seal the object.
 *
 * </ul>
 *
 * @author Li Gong
 * @author Jan Luehe
 * @see javax.crypto.Cipher
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SealedObject implements java.io.Serializable {

/**
 * Constructs a SealedObject from any Serializable object.
 *
 * <p>The given object is serialized, and its serialized contents are
 * encrypted using the given Cipher, which must be fully initialized.
 *
 * <p>Any algorithm parameters that may be used in the encryption
 * operation are stored inside of the new <code>SealedObject</code>.
 *
 * @param object the object to be sealed; can be null.
 * @param c the cipher used to seal the object.
 *
 * @exception java.lang.NullPointerException if the given cipher is null.
 * @exception java.io.IOException if an error occurs during serialization
 * @exception javax.crypto.IllegalBlockSizeException if the given cipher is a block
 * cipher, no padding has been requested, and the total input length
 * (i.e., the length of the serialized object contents) is not a multiple
 * of the cipher's block size
 * @apiSince 1
 */

public SealedObject(java.io.Serializable object, javax.crypto.Cipher c) throws java.io.IOException, javax.crypto.IllegalBlockSizeException { throw new RuntimeException("Stub!"); }

/**
 * Constructs a SealedObject object from the passed-in SealedObject.
 *
 * @param so a SealedObject object
 * @exception java.lang.NullPointerException if the given sealed object is null.
 * @apiSince 1
 */

protected SealedObject(javax.crypto.SealedObject so) { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm that was used to seal this object.
 *
 * @return the algorithm that was used to seal this object.
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the original (encapsulated) object.
 *
 * <p>This method creates a cipher for the algorithm that had been used in
 * the sealing operation.
 * If the default provider package provides an implementation of that
 * algorithm, an instance of Cipher containing that implementation is used.
 * If the algorithm is not available in the default package, other
 * packages are searched.
 * The Cipher object is initialized for decryption, using the given
 * <code>key</code> and the parameters (if any) that had been used in the
 * sealing operation.
 *
 * <p>The encapsulated object is unsealed and de-serialized, before it is
 * returned.
 *
 * @param key the key used to unseal the object.
 *
 * @return the original object.
 *
 * @exception java.io.IOException if an error occurs during de-serialiazation.
 * @exception java.lang.ClassNotFoundException if an error occurs during
 * de-serialiazation.
 * @exception java.security.NoSuchAlgorithmException if the algorithm to unseal the
 * object is not available.
 * @exception java.security.InvalidKeyException if the given key cannot be used to unseal
 * the object (e.g., it has the wrong algorithm).
 * @exception java.lang.NullPointerException if <code>key</code> is null.
 * @apiSince 1
 */

public final java.lang.Object getObject(java.security.Key key) throws java.lang.ClassNotFoundException, java.io.IOException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the original (encapsulated) object.
 *
 * <p>The encapsulated object is unsealed (using the given Cipher,
 * assuming that the Cipher is already properly initialized) and
 * de-serialized, before it is returned.
 *
 * @param c the cipher used to unseal the object
 *
 * @return the original object.
 *
 * @exception java.lang.NullPointerException if the given cipher is null.
 * @exception java.io.IOException if an error occurs during de-serialiazation
 * @exception java.lang.ClassNotFoundException if an error occurs during
 * de-serialiazation
 * @exception javax.crypto.IllegalBlockSizeException if the given cipher is a block
 * cipher, no padding has been requested, and the total input length is
 * not a multiple of the cipher's block size
 * @exception javax.crypto.BadPaddingException if the given cipher has been
 * initialized for decryption, and padding has been specified, but
 * the input data does not have proper expected padding bytes
 * @apiSince 1
 */

public final java.lang.Object getObject(javax.crypto.Cipher c) throws javax.crypto.BadPaddingException, java.lang.ClassNotFoundException, java.io.IOException, javax.crypto.IllegalBlockSizeException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the original (encapsulated) object.
 *
 * <p>This method creates a cipher for the algorithm that had been used in
 * the sealing operation, using an implementation of that algorithm from
 * the given <code>provider</code>.
 * The Cipher object is initialized for decryption, using the given
 * <code>key</code> and the parameters (if any) that had been used in the
 * sealing operation.
 *
 * <p>The encapsulated object is unsealed and de-serialized, before it is
 * returned.
 *
 * @param key the key used to unseal the object.
 * @param provider the name of the provider of the algorithm to unseal
 * the object.
 *
 * @return the original object.
 *
 * @exception java.lang.IllegalArgumentException if the given provider is null
 * or empty.
 * @exception java.io.IOException if an error occurs during de-serialiazation.
 * @exception java.lang.ClassNotFoundException if an error occurs during
 * de-serialiazation.
 * @exception java.security.NoSuchAlgorithmException if the algorithm to unseal the
 * object is not available.
 * @exception java.security.NoSuchProviderException if the given provider is not
 * configured.
 * @exception java.security.InvalidKeyException if the given key cannot be used to unseal
 * the object (e.g., it has the wrong algorithm).
 * @exception java.lang.NullPointerException if <code>key</code> is null.
 * @apiSince 1
 */

public final java.lang.Object getObject(java.security.Key key, java.lang.String provider) throws java.lang.ClassNotFoundException, java.io.IOException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * The cryptographic parameters used by the sealing Cipher,
 * encoded in the default format.
 * <p>
 * That is, <code>cipher.getParameters().getEncoded()</code>.
 *
 * @serial
 * @apiSince 1
 */

protected byte[] encodedParams;
}

