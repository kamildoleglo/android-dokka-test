/*
 * Copyright (c) 1998, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.security.*;
import java.security.spec.*;
import java.nio.ByteBuffer;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the <code>Mac</code> class.
 * All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a particular MAC algorithm.
 *
 * <p> Implementations are free to implement the Cloneable interface.
 *
 * @author Jan Luehe
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class MacSpi {

/** @apiSince 1 */

public MacSpi() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the MAC in bytes.
 *
 * @return the MAC length in bytes.
 * @apiSince 1
 */

protected abstract int engineGetMacLength();

/**
 * Initializes the MAC with the given (secret) key and algorithm
 * parameters.
 *
 * @param key the (secret) key.
 * @param params the algorithm parameters.
 *
 * @exception java.security.InvalidKeyException if the given key is inappropriate for
 * initializing this MAC.
 * @exception java.security.InvalidAlgorithmParameterException if the given algorithm
 * parameters are inappropriate for this MAC.
 * @apiSince 1
 */

protected abstract void engineInit(java.security.Key key, java.security.spec.AlgorithmParameterSpec params) throws java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException;

/**
 * Processes the given byte.
 *
 * @param input the input byte to be processed.
 * @apiSince 1
 */

protected abstract void engineUpdate(byte input);

/**
 * Processes the first <code>len</code> bytes in <code>input</code>,
 * starting at <code>offset</code> inclusive.
 *
 * @param input the input buffer.
 * @param offset the offset in <code>input</code> where the input starts.
 * @param len the number of bytes to process.
 * @apiSince 1
 */

protected abstract void engineUpdate(byte[] input, int offset, int len);

/**
 * Processes <code>input.remaining()</code> bytes in the ByteBuffer
 * <code>input</code>, starting at <code>input.position()</code>.
 * Upon return, the buffer's position will be equal to its limit;
 * its limit will not have changed.
 *
 * <p>Subclasses should consider overriding this method if they can
 * process ByteBuffers more efficiently than byte arrays.
 *
 * @param input the ByteBuffer
 * @since 1.5
 * @apiSince 1
 */

protected void engineUpdate(java.nio.ByteBuffer input) { throw new RuntimeException("Stub!"); }

/**
 * Completes the MAC computation and resets the MAC for further use,
 * maintaining the secret key that the MAC was initialized with.
 *
 * @return the MAC result.
 * @apiSince 1
 */

protected abstract byte[] engineDoFinal();

/**
 * Resets the MAC for further use, maintaining the secret key that the
 * MAC was initialized with.
 * @apiSince 1
 */

protected abstract void engineReset();

/**
 * Returns a clone if the implementation is cloneable.
 *
 * @return a clone if the implementation is cloneable.
 *
 * @exception java.lang.CloneNotSupportedException if this is called
 * on an implementation that does not support <code>Cloneable</code>.
 * @apiSince 1
 */

public java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }
}

