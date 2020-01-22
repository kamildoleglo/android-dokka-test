/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.Provider;
import java.security.NoSuchProviderException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;

/**
 * This class provides the functionality of an exemption mechanism, examples
 * of which are <i>key recovery</i>, <i>key weakening</i>, and
 * <i>key escrow</i>.
 *
 * <p>Applications or applets that use an exemption mechanism may be granted
 * stronger encryption capabilities than those which don't.
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ExemptionMechanism {

/**
 * Creates a ExemptionMechanism object.
 *
 * @param exmechSpi the delegate
 * @param provider the provider
 * @param mechanism the exemption mechanism
 * @apiSince 1
 */

protected ExemptionMechanism(javax.crypto.ExemptionMechanismSpi exmechSpi, java.security.Provider provider, java.lang.String mechanism) { throw new RuntimeException("Stub!"); }

/**
 * Returns the exemption mechanism name of this
 * <code>ExemptionMechanism</code> object.
 *
 * <p>This is the same name that was specified in one of the
 * <code>getInstance</code> calls that created this
 * <code>ExemptionMechanism</code> object.
 *
 * @return the exemption mechanism name of this
 * <code>ExemptionMechanism</code> object.
 * @apiSince 1
 */

public final java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns an <code>ExemptionMechanism</code> object that implements the
 * specified exemption mechanism algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new ExemptionMechanism object encapsulating the
 * ExemptionMechanismSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 *
 * @param algorithm the standard name of the requested exemption
 * mechanism.
 * See the ExemptionMechanism section in the
 * <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Exemption">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard exemption mechanism names.
 *
 * @return the new <code>ExemptionMechanism</code> object.
 *
 * @exception java.lang.NullPointerException if <code>algorithm</code>
 *          is null.
 *
 * @exception java.security.NoSuchAlgorithmException if no Provider supports an
 *          ExemptionMechanismSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.ExemptionMechanism getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns an <code>ExemptionMechanism</code> object that implements the
 * specified exemption mechanism algorithm.
 *
 * <p> A new ExemptionMechanism object encapsulating the
 * ExemptionMechanismSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link java.security.Security#getProviders() Security#getProviders()} method.
 
 * @param algorithm the standard name of the requested exemption mechanism.
 * See the ExemptionMechanism section in the
 * <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Exemption">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard exemption mechanism names.
 *
 * @param provider the name of the provider.
 *
 * @return the new <code>ExemptionMechanism</code> object.
 *
 * @exception java.lang.NullPointerException if <code>algorithm</code>
 *          is null.
 *
 * @exception java.security.NoSuchAlgorithmException if an ExemptionMechanismSpi
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

public static final javax.crypto.ExemptionMechanism getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns an <code>ExemptionMechanism</code> object that implements the
 * specified exemption mechanism algorithm.
 *
 * <p> A new ExemptionMechanism object encapsulating the
 * ExemptionMechanismSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the standard name of the requested exemption mechanism.
 * See the ExemptionMechanism section in the
 * <a href=
 *   "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Exemption">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard exemption mechanism names.
 *
 * @param provider the provider.
 *
 * @return the new <code>ExemptionMechanism</code> object.
 *
 * @exception java.lang.NullPointerException if <code>algorithm</code>
 *          is null.
 *
 * @exception java.security.NoSuchAlgorithmException if an ExemptionMechanismSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception java.lang.IllegalArgumentException if the <code>provider</code>
 *          is null.
 *
 * @see java.security.Provider
 * @apiSince 1
 */

public static final javax.crypto.ExemptionMechanism getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this <code>ExemptionMechanism</code> object.
 *
 * @return the provider of this <code>ExemptionMechanism</code> object.
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the result blob has been generated successfully by this
 * exemption mechanism.
 *
 * <p>The method also makes sure that the key passed in is the same as
 * the one this exemption mechanism used in initializing and generating
 * phases.
 *
 * @param key the key the crypto is going to use.
 *
 * @return whether the result blob of the same key has been generated
 * successfully by this exemption mechanism; false if <code>key</code>
 * is null.
 *
 * @exception javax.crypto.ExemptionMechanismException if problem(s) encountered
 * while determining whether the result blob has been generated successfully
 * by this exemption mechanism object.
 * @apiSince 1
 */

public final boolean isCryptoAllowed(java.security.Key key) throws javax.crypto.ExemptionMechanismException { throw new RuntimeException("Stub!"); }

/**
 * Returns the length in bytes that an output buffer would need to be in
 * order to hold the result of the next
 * {@link #genExemptionBlob(byte[]) genExemptionBlob}
 * operation, given the input length <code>inputLen</code> (in bytes).
 *
 * <p>The actual output length of the next
 * {@link #genExemptionBlob(byte[]) genExemptionBlob}
 * call may be smaller than the length returned by this method.
 *
 * @param inputLen the input length (in bytes)
 *
 * @return the required output buffer size (in bytes)
 *
 * @exception java.lang.IllegalStateException if this exemption mechanism is in a
 * wrong state (e.g., has not yet been initialized)
 * @apiSince 1
 */

public final int getOutputSize(int inputLen) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this exemption mechanism with a key.
 *
 * <p>If this exemption mechanism requires any algorithm parameters
 * that cannot be derived from the given <code>key</code>, the
 * underlying exemption mechanism implementation is supposed to
 * generate the required parameters itself (using provider-specific
 * default values); in the case that algorithm parameters must be
 * specified by the caller, an <code>InvalidKeyException</code> is raised.
 *
 * @param key the key for this exemption mechanism
 *
 * @exception java.security.InvalidKeyException if the given key is inappropriate for
 * this exemption mechanism.
 * @exception javax.crypto.ExemptionMechanismException if problem(s) encountered in the
 * process of initializing.
 * @apiSince 1
 */

public final void init(java.security.Key key) throws javax.crypto.ExemptionMechanismException, java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this exemption mechanism with a key and a set of algorithm
 * parameters.
 *
 * <p>If this exemption mechanism requires any algorithm parameters
 * and <code>params</code> is null, the underlying exemption
 * mechanism implementation is supposed to generate the required
 * parameters itself (using provider-specific default values); in the case
 * that algorithm parameters must be specified by the caller, an
 * <code>InvalidAlgorithmParameterException</code> is raised.
 *
 * @param key the key for this exemption mechanism
 * @param params the algorithm parameters
 *
 * @exception java.security.InvalidKeyException if the given key is inappropriate for
 * this exemption mechanism.
 * @exception java.security.InvalidAlgorithmParameterException if the given algorithm
 * parameters are inappropriate for this exemption mechanism.
 * @exception javax.crypto.ExemptionMechanismException if problem(s) encountered in the
 * process of initializing.
 * @apiSince 1
 */

public final void init(java.security.Key key, java.security.spec.AlgorithmParameterSpec params) throws javax.crypto.ExemptionMechanismException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this exemption mechanism with a key and a set of algorithm
 * parameters.
 *
 * <p>If this exemption mechanism requires any algorithm parameters
 * and <code>params</code> is null, the underlying exemption mechanism
 * implementation is supposed to generate the required parameters itself
 * (using provider-specific default values); in the case that algorithm
 * parameters must be specified by the caller, an
 * <code>InvalidAlgorithmParameterException</code> is raised.
 *
 * @param key the key for this exemption mechanism
 * @param params the algorithm parameters
 *
 * @exception java.security.InvalidKeyException if the given key is inappropriate for
 * this exemption mechanism.
 * @exception java.security.InvalidAlgorithmParameterException if the given algorithm
 * parameters are inappropriate for this exemption mechanism.
 * @exception javax.crypto.ExemptionMechanismException if problem(s) encountered in the
 * process of initializing.
 * @apiSince 1
 */

public final void init(java.security.Key key, java.security.AlgorithmParameters params) throws javax.crypto.ExemptionMechanismException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Generates the exemption mechanism key blob.
 *
 * @return the new buffer with the result key blob.
 *
 * @exception java.lang.IllegalStateException if this exemption mechanism is in
 * a wrong state (e.g., has not been initialized).
 * @exception javax.crypto.ExemptionMechanismException if problem(s) encountered in the
 * process of generating.
 * @apiSince 1
 */

public final byte[] genExemptionBlob() throws javax.crypto.ExemptionMechanismException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Generates the exemption mechanism key blob, and stores the result in
 * the <code>output</code> buffer.
 *
 * <p>If the <code>output</code> buffer is too small to hold the result,
 * a <code>ShortBufferException</code> is thrown. In this case, repeat this
 * call with a larger output buffer. Use
 * {@link #getOutputSize(int) getOutputSize} to determine how big
 * the output buffer should be.
 *
 * @param output the buffer for the result
 *
 * @return the number of bytes stored in <code>output</code>
 *
 * @exception java.lang.IllegalStateException if this exemption mechanism is in
 * a wrong state (e.g., has not been initialized).
 * @exception javax.crypto.ShortBufferException if the given output buffer is too small
 * to hold the result.
 * @exception javax.crypto.ExemptionMechanismException if problem(s) encountered in the
 * process of generating.
 * @apiSince 1
 */

public final int genExemptionBlob(byte[] output) throws javax.crypto.ExemptionMechanismException, java.lang.IllegalStateException, javax.crypto.ShortBufferException { throw new RuntimeException("Stub!"); }

/**
 * Generates the exemption mechanism key blob, and stores the result in
 * the <code>output</code> buffer, starting at <code>outputOffset</code>
 * inclusive.
 *
 * <p>If the <code>output</code> buffer is too small to hold the result,
 * a <code>ShortBufferException</code> is thrown. In this case, repeat this
 * call with a larger output buffer. Use
 * {@link #getOutputSize(int) getOutputSize} to determine how big
 * the output buffer should be.
 *
 * @param output the buffer for the result
 * @param outputOffset the offset in <code>output</code> where the result
 * is stored
 *
 * @return the number of bytes stored in <code>output</code>
 *
 * @exception java.lang.IllegalStateException if this exemption mechanism is in
 * a wrong state (e.g., has not been initialized).
 * @exception javax.crypto.ShortBufferException if the given output buffer is too small
 * to hold the result.
 * @exception javax.crypto.ExemptionMechanismException if problem(s) encountered in the
 * process of generating.
 * @apiSince 1
 */

public final int genExemptionBlob(byte[] output, int outputOffset) throws javax.crypto.ExemptionMechanismException, java.lang.IllegalStateException, javax.crypto.ShortBufferException { throw new RuntimeException("Stub!"); }
}

