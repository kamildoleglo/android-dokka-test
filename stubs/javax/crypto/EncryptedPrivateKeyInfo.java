/*
 * Copyright (c) 2001, 2011, Oracle and/or its affiliates. All rights reserved.
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
import java.security.*;
import java.security.spec.*;

/**
 * This class implements the <code>EncryptedPrivateKeyInfo</code> type
 * as defined in PKCS #8.
 * <p>Its ASN.1 definition is as follows:
 *
 * <pre>
 * EncryptedPrivateKeyInfo ::=  SEQUENCE {
 *     encryptionAlgorithm   AlgorithmIdentifier,
 *     encryptedData   OCTET STRING }
 *
 * AlgorithmIdentifier  ::=  SEQUENCE  {
 *     algorithm              OBJECT IDENTIFIER,
 *     parameters             ANY DEFINED BY algorithm OPTIONAL  }
 * </pre>
 *
 * @author Valerie Peng
 *
 * @see java.security.spec.PKCS8EncodedKeySpec
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EncryptedPrivateKeyInfo {

/**
 * Constructs (i.e., parses) an <code>EncryptedPrivateKeyInfo</code> from
 * its ASN.1 encoding.
 * @param encoded the ASN.1 encoding of this object. The contents of
 * the array are copied to protect against subsequent modification.
 * @exception java.lang.NullPointerException if the <code>encoded</code> is null.
 * @exception java.io.IOException if error occurs when parsing the ASN.1 encoding.
 * @apiSince 1
 */

public EncryptedPrivateKeyInfo(byte[] encoded) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Constructs an <code>EncryptedPrivateKeyInfo</code> from the
 * encryption algorithm name and the encrypted data.
 *
 * <p>Note: This constructor will use null as the value of the
 * algorithm parameters. If the encryption algorithm has
 * parameters whose value is not null, a different constructor,
 * e.g. EncryptedPrivateKeyInfo(AlgorithmParameters, byte[]),
 * should be used.
 *
 * @param algName encryption algorithm name. See Appendix A in the
 * <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html#AppA">
 * Java Cryptography Architecture Reference Guide</a>
 * for information about standard Cipher algorithm names.
 * @param encryptedData encrypted data. The contents of
 * <code>encrypedData</code> are copied to protect against subsequent
 * modification when constructing this object.
 * @exception java.lang.NullPointerException if <code>algName</code> or
 * <code>encryptedData</code> is null.
 * @exception java.lang.IllegalArgumentException if <code>encryptedData</code>
 * is empty, i.e. 0-length.
 * @exception java.security.NoSuchAlgorithmException if the specified algName is
 * not supported.
 * @apiSince 1
 */

public EncryptedPrivateKeyInfo(java.lang.String algName, byte[] encryptedData) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Constructs an <code>EncryptedPrivateKeyInfo</code> from the
 * encryption algorithm parameters and the encrypted data.
 *
 * @param algParams the algorithm parameters for the encryption
 * algorithm. <code>algParams.getEncoded()</code> should return
 * the ASN.1 encoded bytes of the <code>parameters</code> field
 * of the <code>AlgorithmIdentifer</code> component of the
 * <code>EncryptedPrivateKeyInfo</code> type.
 * @param encryptedData encrypted data. The contents of
 * <code>encrypedData</code> are copied to protect against
 * subsequent modification when constructing this object.
 * @exception java.lang.NullPointerException if <code>algParams</code> or
 * <code>encryptedData</code> is null.
 * @exception java.lang.IllegalArgumentException if <code>encryptedData</code>
 * is empty, i.e. 0-length.
 * @exception java.security.NoSuchAlgorithmException if the specified algName of
 * the specified <code>algParams</code> parameter is not supported.
 * @apiSince 1
 */

public EncryptedPrivateKeyInfo(java.security.AlgorithmParameters algParams, byte[] encryptedData) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the encryption algorithm.
 * <p>Note: Standard name is returned instead of the specified one
 * in the constructor when such mapping is available.
 * See Appendix A in the
 * <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html#AppA">
 * Java Cryptography Architecture Reference Guide</a>
 * for information about standard Cipher algorithm names.
 *
 * @return the encryption algorithm name.
 * @apiSince 1
 */

public java.lang.String getAlgName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm parameters used by the encryption algorithm.
 * @return the algorithm parameters.
 * @apiSince 1
 */

public java.security.AlgorithmParameters getAlgParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns the encrypted data.
 * @return the encrypted data. Returns a new array
 * each time this method is called.
 * @apiSince 1
 */

public byte[] getEncryptedData() { throw new RuntimeException("Stub!"); }

/**
 * Extract the enclosed PKCS8EncodedKeySpec object from the
 * encrypted data and return it.
 * <br>Note: In order to successfully retrieve the enclosed
 * PKCS8EncodedKeySpec object, <code>cipher</code> needs
 * to be initialized to either Cipher.DECRYPT_MODE or
 * Cipher.UNWRAP_MODE, with the same key and parameters used
 * for generating the encrypted data.
 *
 * @param cipher the initialized cipher object which will be
 * used for decrypting the encrypted data.
 * @return the PKCS8EncodedKeySpec object.
 * @exception java.lang.NullPointerException if <code>cipher</code>
 * is null.
 * @exception java.security.spec.InvalidKeySpecException if the given cipher is
 * inappropriate for the encrypted data or the encrypted
 * data is corrupted and cannot be decrypted.
 * @apiSince 1
 */

public java.security.spec.PKCS8EncodedKeySpec getKeySpec(javax.crypto.Cipher cipher) throws java.security.spec.InvalidKeySpecException { throw new RuntimeException("Stub!"); }

/**
 * Extract the enclosed PKCS8EncodedKeySpec object from the
 * encrypted data and return it.
 * @param decryptKey key used for decrypting the encrypted data.
 * @return the PKCS8EncodedKeySpec object.
 * @exception java.lang.NullPointerException if <code>decryptKey</code>
 * is null.
 * @exception java.security.NoSuchAlgorithmException if cannot find appropriate
 * cipher to decrypt the encrypted data.
 * @exception java.security.InvalidKeyException if <code>decryptKey</code>
 * cannot be used to decrypt the encrypted data or the decryption
 * result is not a valid PKCS8KeySpec.
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.spec.PKCS8EncodedKeySpec getKeySpec(java.security.Key decryptKey) throws java.security.InvalidKeyException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Extract the enclosed PKCS8EncodedKeySpec object from the
 * encrypted data and return it.
 * @param decryptKey key used for decrypting the encrypted data.
 * @param providerName the name of provider whose Cipher
 * implementation will be used.
 * @return the PKCS8EncodedKeySpec object.
 * @exception java.lang.NullPointerException if <code>decryptKey</code>
 * or <code>providerName</code> is null.
 * @exception java.security.NoSuchProviderException if no provider
 * <code>providerName</code> is registered.
 * @exception java.security.NoSuchAlgorithmException if cannot find appropriate
 * cipher to decrypt the encrypted data.
 * @exception java.security.InvalidKeyException if <code>decryptKey</code>
 * cannot be used to decrypt the encrypted data or the decryption
 * result is not a valid PKCS8KeySpec.
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.spec.PKCS8EncodedKeySpec getKeySpec(java.security.Key decryptKey, java.lang.String providerName) throws java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Extract the enclosed PKCS8EncodedKeySpec object from the
 * encrypted data and return it.
 * @param decryptKey key used for decrypting the encrypted data.
 * @param provider the name of provider whose Cipher implementation
 * will be used.
 * @return the PKCS8EncodedKeySpec object.
 * @exception java.lang.NullPointerException if <code>decryptKey</code>
 * or <code>provider</code> is null.
 * @exception java.security.NoSuchAlgorithmException if cannot find appropriate
 * cipher to decrypt the encrypted data in <code>provider</code>.
 * @exception java.security.InvalidKeyException if <code>decryptKey</code>
 * cannot be used to decrypt the encrypted data or the decryption
 * result is not a valid PKCS8KeySpec.
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.spec.PKCS8EncodedKeySpec getKeySpec(java.security.Key decryptKey, java.security.Provider provider) throws java.security.InvalidKeyException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the ASN.1 encoding of this object.
 * @return the ASN.1 encoding. Returns a new array
 * each time this method is called.
 * @exception java.io.IOException if error occurs when constructing its
 * ASN.1 encoding.
 * @apiSince 1
 */

public byte[] getEncoded() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

