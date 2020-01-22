/*
 * Copyright (c) 1996, 2015, Oracle and/or its affiliates. All rights reserved.
 * Copyright (C) 2014 The Android Open Source Project
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
import java.io.*;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;

/**
 * The Signature class is used to provide applications the functionality
 * of a digital signature algorithm. Digital signatures are used for
 * authentication and integrity assurance of digital data.
 *
 * <p> The signature algorithm can be, among others, the NIST standard
 * DSA, using DSA and SHA-1. The DSA algorithm using the
 * SHA-1 message digest algorithm can be specified as {@code SHA1withDSA}.
 * In the case of RSA, there are multiple choices for the message digest
 * algorithm, so the signing algorithm could be specified as, for example,
 * {@code MD2withRSA}, {@code MD5withRSA}, or {@code SHA1withRSA}.
 * The algorithm name must be specified, as there is no default.
 *
 * <p> A Signature object can be used to generate and verify digital
 * signatures.
 *
 * <p> There are three phases to the use of a Signature object for
 * either signing data or verifying a signature:<ol>
 *
 * <li>Initialization, with either
 *
 *     <ul>
 *
 *     <li>a public key, which initializes the signature for
 *     verification (see {@link #initVerify(java.security.PublicKey) initVerify}), or
 *
 *     <li>a private key (and optionally a Secure Random Number Generator),
 *     which initializes the signature for signing
 *     (see {@link #initSign(java.security.PrivateKey)}
 *     and {@link #initSign(java.security.PrivateKey,java.security.SecureRandom)}).
 *
 *     </ul>
 *
 * <li>Updating
 *
 * <p>Depending on the type of initialization, this will update the
 * bytes to be signed or verified. See the
 * {@link #update(byte) update} methods.
 *
 * <li>Signing or Verifying a signature on all updated bytes. See the
 * {@link #sign() sign} methods and the {@link #verify(byte[]) verify}
 * method.
 *
 * </ol>
 *
 * <p>Note that this class is abstract and extends from
 * {@code SignatureSpi} for historical reasons.
 * Application developers should only take notice of the methods defined in
 * this {@code Signature} class; all the methods in
 * the superclass are intended for cryptographic service providers who wish to
 * supply their own implementations of digital signature algorithms.
 *
 * <p> Android provides the following {@code Signature} algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>DSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>DSAwithSHA1</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>DSS</td>
 *       <td>1-19</td>
 *     </tr>
 *     <tr>
 *       <td>ECDSA</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>ECDSAwithSHA1</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>MD2withRSA</td>
 *       <td>1-3</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>MD4withRSA</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>MD5withRSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>MD5withRSA/ISO9796-2</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>NONEwithDSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>NONEwithECDSA</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>NONEwithRSA</td>
 *       <td>17+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>RSASSA-PSS</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>SHA1withDSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA1withECDSA</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA1withRSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>SHA1withRSA/ISO9796-2</td>
 *       <td>1-8</td>
 *     </tr>
 *     <tr>
 *       <td>SHA1withRSA/PSS</td>
 *       <td>23+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA224withDSA</td>
 *       <td>20+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA224withECDSA</td>
 *       <td>20+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA224withRSA</td>
 *       <td>20+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA224withRSA/PSS</td>
 *       <td>23+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA256withDSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA256withECDSA</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA256withRSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA256withRSA/PSS</td>
 *       <td>23+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA384withECDSA</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA384withRSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA384withRSA/PSS</td>
 *       <td>23+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA512withECDSA</td>
 *       <td>11+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA512withRSA</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>SHA512withRSA/PSS</td>
 *       <td>23+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * These algorithms are described in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature">
 * Signature section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Benjamin Renaud
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Signature extends java.security.SignatureSpi {

/**
 * Creates a Signature object for the specified algorithm.
 *
 * @param algorithm the standard string name of the algorithm.
 * See the Signature section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 * @apiSince 1
 */

protected Signature(java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Signature object that implements the specified signature
 * algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new Signature object encapsulating the
 * SignatureSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the algorithm requested.
 * See the Signature section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the new Signature object.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports a
 *          Signature implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static java.security.Signature getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a Signature object that implements the specified signature
 * algorithm.
 *
 * <p> A new Signature object encapsulating the
 * SignatureSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the name of the algorithm requested.
 * See the Signature section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new Signature object.
 *
 * @exception java.security.NoSuchAlgorithmException if a SignatureSpi
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

public static java.security.Signature getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a Signature object that implements the specified
 * signature algorithm.
 *
 * <p> A new Signature object encapsulating the
 * SignatureSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the name of the algorithm requested.
 * See the Signature section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return the new Signature object.
 *
 * @exception java.security.NoSuchAlgorithmException if a SignatureSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the provider is null.
 *
 * @see java.security.Provider
 *
 * @since 1.4
 * @apiSince 1
 */

public static java.security.Signature getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this signature object.
 *
 * @return the provider of this signature object
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this object for verification. If this method is called
 * again with a different argument, it negates the effect
 * of this call.
 *
 * @param publicKey the public key of the identity whose signature is
 * going to be verified.
 *
 * @exception java.security.InvalidKeyException if the key is invalid.
 * @apiSince 1
 */

public final void initVerify(java.security.PublicKey publicKey) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this object for verification, using the public key from
 * the given certificate.
 * <p>If the certificate is of type X.509 and has a <i>key usage</i>
 * extension field marked as critical, and the value of the <i>key usage</i>
 * extension field implies that the public key in
 * the certificate and its corresponding private key are not
 * supposed to be used for digital signatures, an
 * {@code InvalidKeyException} is thrown.
 *
 * @param certificate the certificate of the identity whose signature is
 * going to be verified.
 *
 * @exception java.security.InvalidKeyException  if the public key in the certificate
 * is not encoded properly or does not include required  parameter
 * information or cannot be used for digital signature purposes.
 * @since 1.3
 * @apiSince 1
 */

public final void initVerify(java.security.cert.Certificate certificate) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initialize this object for signing. If this method is called
 * again with a different argument, it negates the effect
 * of this call.
 *
 * @param privateKey the private key of the identity whose signature
 * is going to be generated.
 *
 * @exception java.security.InvalidKeyException if the key is invalid.
 * @apiSince 1
 */

public final void initSign(java.security.PrivateKey privateKey) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initialize this object for signing. If this method is called
 * again with a different argument, it negates the effect
 * of this call.
 *
 * @param privateKey the private key of the identity whose signature
 * is going to be generated.
 *
 * @param random the source of randomness for this signature.
 *
 * @exception java.security.InvalidKeyException if the key is invalid.
 * @apiSince 1
 */

public final void initSign(java.security.PrivateKey privateKey, java.security.SecureRandom random) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Returns the signature bytes of all the data updated.
 * The format of the signature depends on the underlying
 * signature scheme.
 *
 * <p>A call to this method resets this signature object to the state
 * it was in when previously initialized for signing via a
 * call to {@code initSign(PrivateKey)}. That is, the object is
 * reset and available to generate another signature from the same
 * signer, if desired, via new calls to {@code update} and
 * {@code sign}.
 *
 * @return the signature bytes of the signing operation's result.
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly or if this signature algorithm is unable to
 * process the input data provided.
 * @apiSince 1
 */

public final byte[] sign() throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Finishes the signature operation and stores the resulting signature
 * bytes in the provided buffer {@code outbuf}, starting at
 * {@code offset}.
 * The format of the signature depends on the underlying
 * signature scheme.
 *
 * <p>This signature object is reset to its initial state (the state it
 * was in after a call to one of the {@code initSign} methods) and
 * can be reused to generate further signatures with the same private key.
 *
 * @param outbuf buffer for the signature result.
 *
 * @param offset offset into {@code outbuf} where the signature is
 * stored.
 *
 * @param len number of bytes within {@code outbuf} allotted for the
 * signature.
 *
 * @return the number of bytes placed into {@code outbuf}.
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly, if this signature algorithm is unable to
 * process the input data provided, or if {@code len} is less
 * than the actual signature length.
 *
 * @since 1.2
 * @apiSince 1
 */

public final int sign(byte[] outbuf, int offset, int len) throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Verifies the passed-in signature.
 *
 * <p>A call to this method resets this signature object to the state
 * it was in when previously initialized for verification via a
 * call to {@code initVerify(PublicKey)}. That is, the object is
 * reset and available to verify another signature from the identity
 * whose public key was specified in the call to {@code initVerify}.
 *
 * @param signature the signature bytes to be verified.
 *
 * @return true if the signature was verified, false if not.
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly, the passed-in signature is improperly
 * encoded or of the wrong type, if this signature algorithm is unable to
 * process the input data provided, etc.
 * @apiSince 1
 */

public final boolean verify(byte[] signature) throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Verifies the passed-in signature in the specified array
 * of bytes, starting at the specified offset.
 *
 * <p>A call to this method resets this signature object to the state
 * it was in when previously initialized for verification via a
 * call to {@code initVerify(PublicKey)}. That is, the object is
 * reset and available to verify another signature from the identity
 * whose public key was specified in the call to {@code initVerify}.
 *
 *
 * @param signature the signature bytes to be verified.
 * @param offset the offset to start from in the array of bytes.
 * @param length the number of bytes to use, starting at offset.
 *
 * @return true if the signature was verified, false if not.
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly, the passed-in signature is improperly
 * encoded or of the wrong type, if this signature algorithm is unable to
 * process the input data provided, etc.
 * @exception java.lang.IllegalArgumentException if the {@code signature}
 * byte array is null, or the {@code offset} or {@code length}
 * is less than 0, or the sum of the {@code offset} and
 * {@code length} is greater than the length of the
 * {@code signature} byte array.
 * @since 1.4
 * @apiSince 1
 */

public final boolean verify(byte[] signature, int offset, int length) throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Updates the data to be signed or verified by a byte.
 *
 * @param b the byte to use for the update.
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly.
 * @apiSince 1
 */

public final void update(byte b) throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Updates the data to be signed or verified, using the specified
 * array of bytes.
 *
 * @param data the byte array to use for the update.
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly.
 * @apiSince 1
 */

public final void update(byte[] data) throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Updates the data to be signed or verified, using the specified
 * array of bytes, starting at the specified offset.
 *
 * @param data the array of bytes.
 * @param off the offset to start from in the array of bytes.
 * @param len the number of bytes to use, starting at offset.
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly.
 * @apiSince 1
 */

public final void update(byte[] data, int off, int len) throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Updates the data to be signed or verified using the specified
 * ByteBuffer. Processes the {@code data.remaining()} bytes
 * starting at at {@code data.position()}.
 * Upon return, the buffer's position will be equal to its limit;
 * its limit will not have changed.
 *
 * @param data the ByteBuffer
 *
 * @exception java.security.SignatureException if this signature object is not
 * initialized properly.
 * @since 1.5
 * @apiSince 1
 */

public final void update(java.nio.ByteBuffer data) throws java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the algorithm for this signature object.
 *
 * @return the name of the algorithm for this signature object.
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this signature object,
 * providing information that includes the state of the object
 * and the name of the algorithm used.
 *
 * @return a string representation of this signature object.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Sets the specified algorithm parameter to the specified value.
 * This method supplies a general-purpose mechanism through
 * which it is possible to set the various parameters of this object.
 * A parameter may be any settable parameter for the algorithm, such as
 * a parameter size, or a source of random bits for signature generation
 * (if appropriate), or an indication of whether or not to perform
 * a specific but optional computation. A uniform algorithm-specific
 * naming scheme for each parameter is desirable but left unspecified
 * at this time.
 *
 * @param param the string identifier of the parameter.
 * @param value the parameter value.
 *
 * @exception java.security.InvalidParameterException if {@code param} is an
 * invalid parameter for this signature algorithm engine,
 * the parameter is already set
 * and cannot be set again, a security exception occurs, and so on.
 *
 * @see #getParameter
 *
 * @deprecated Use
 * {@link #setParameter(java.security.spec.AlgorithmParameterSpec)
 * setParameter}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final void setParameter(java.lang.String param, java.lang.Object value) throws java.security.InvalidParameterException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this signature engine with the specified parameter set.
 *
 * @param params the parameters
 *
 * @exception java.security.InvalidAlgorithmParameterException if the given parameters
 * are inappropriate for this signature engine
 *
 * @see #getParameters
 * @apiSince 1
 */

public final void setParameter(java.security.spec.AlgorithmParameterSpec params) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Returns the parameters used with this signature object.
 *
 * <p>The returned parameters may be the same that were used to initialize
 * this signature, or may contain a combination of default and randomly
 * generated parameter values used by the underlying signature
 * implementation if this signature requires algorithm parameters but
 * was not initialized with any.
 *
 * @return the parameters used with this signature, or null if this
 * signature does not use any parameters.
 *
 * @see #setParameter(AlgorithmParameterSpec)
 * @since 1.4
 * @apiSince 1
 */

public final java.security.AlgorithmParameters getParameters() { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the specified algorithm parameter. This method
 * supplies a general-purpose mechanism through which it is possible to
 * get the various parameters of this object. A parameter may be any
 * settable parameter for the algorithm, such as a parameter size, or
 * a source of random bits for signature generation (if appropriate),
 * or an indication of whether or not to perform a specific but optional
 * computation. A uniform algorithm-specific naming scheme for each
 * parameter is desirable but left unspecified at this time.
 *
 * @param param the string name of the parameter.
 *
 * @return the object that represents the parameter value, or null if
 * there is none.
 *
 * @exception java.security.InvalidParameterException if {@code param} is an invalid
 * parameter for this engine, or another exception occurs while
 * trying to get this parameter.
 *
 * @see #setParameter(String, Object)
 *
 * @deprecated Deprecated.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final java.lang.Object getParameter(java.lang.String param) throws java.security.InvalidParameterException { throw new RuntimeException("Stub!"); }

/**
 * Returns a clone if the implementation is cloneable.
 *
 * @return a clone if the implementation is cloneable.
 *
 * @exception java.lang.CloneNotSupportedException if this is called
 * on an implementation that does not support {@code Cloneable}.
 * @apiSince 1
 */

public java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Possible {@link #state} value, signifying that
 * this signature object has been initialized for signing.
 * @apiSince 1
 */

protected static final int SIGN = 2; // 0x2

/**
 * Possible {@link #state} value, signifying that
 * this signature object has not yet been initialized.
 * @apiSince 1
 */

protected static final int UNINITIALIZED = 0; // 0x0

/**
 * Possible {@link #state} value, signifying that
 * this signature object has been initialized for verification.
 * @apiSince 1
 */

protected static final int VERIFY = 3; // 0x3

/**
 * Current state of this signature object.
 * @apiSince 1
 */

protected int state = 0; // 0x0
}

