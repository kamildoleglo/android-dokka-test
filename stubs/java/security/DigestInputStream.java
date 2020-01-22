/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;

/**
 * A transparent stream that updates the associated message digest using
 * the bits going through the stream.
 *
 * <p>To complete the message digest computation, call one of the
 * {@code digest} methods on the associated message
 * digest after your calls to one of this digest input stream's
 * {@link #read() read} methods.
 *
 * <p>It is possible to turn this stream on or off (see
 * {@link #on(boolean) on}). When it is on, a call to one of the
 * {@code read} methods
 * results in an update on the message digest.  But when it is off,
 * the message digest is not updated. The default is for the stream
 * to be on.
 *
 * <p>Note that digest objects can compute only one digest (see
 * {@link java.security.MessageDigest MessageDigest}),
 * so that in order to compute intermediate digests, a caller should
 * retain a handle onto the digest object, and clone it for each
 * digest to be computed, leaving the orginal digest untouched.
 *
 * @see java.security.MessageDigest
 *
 * @see java.security.DigestOutputStream
 *
 * @author Benjamin Renaud
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DigestInputStream extends java.io.FilterInputStream {

/**
 * Creates a digest input stream, using the specified input stream
 * and message digest.
 *
 * @param stream the input stream.
 *
 * @param digest the message digest to associate with this stream.
 * @apiSince 1
 */

public DigestInputStream(java.io.InputStream stream, java.security.MessageDigest digest) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the message digest associated with this stream.
 *
 * @return the message digest associated with this stream.
 * @see #setMessageDigest(java.security.MessageDigest)
 * @apiSince 1
 */

public java.security.MessageDigest getMessageDigest() { throw new RuntimeException("Stub!"); }

/**
 * Associates the specified message digest with this stream.
 *
 * @param digest the message digest to be associated with this stream.
 * @see #getMessageDigest()
 * @apiSince 1
 */

public void setMessageDigest(java.security.MessageDigest digest) { throw new RuntimeException("Stub!"); }

/**
 * Reads a byte, and updates the message digest (if the digest
 * function is on).  That is, this method reads a byte from the
 * input stream, blocking until the byte is actually read. If the
 * digest function is on (see {@link #on(boolean) on}), this method
 * will then call {@code update} on the message digest associated
 * with this stream, passing it the byte read.
 *
 * @return the byte read.
 *
 * @exception java.io.IOException if an I/O error occurs.
 *
 * @see java.security.MessageDigest#update(byte)
 * @apiSince 1
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads into a byte array, and updates the message digest (if the
 * digest function is on).  That is, this method reads up to
 * {@code len} bytes from the input stream into the array
 * {@code b}, starting at offset {@code off}. This method
 * blocks until the data is actually
 * read. If the digest function is on (see
 * {@link #on(boolean) on}), this method will then call {@code update}
 * on the message digest associated with this stream, passing it
 * the data.
 *
 * @param b the array into which the data is read.
 *
 * @param off the starting offset into {@code b} of where the
 * data should be placed.
 *
 * @param len the maximum number of bytes to be read from the input
 * stream into b, starting at offset {@code off}.
 *
 * @return  the actual number of bytes read. This is less than
 * {@code len} if the end of the stream is reached prior to
 * reading {@code len} bytes. -1 is returned if no bytes were
 * read because the end of the stream had already been reached when
 * the call was made.
 *
 * @exception java.io.IOException if an I/O error occurs.
 *
 * @see java.security.MessageDigest#update(byte[], int, int)
 * @apiSince 1
 */

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Turns the digest function on or off. The default is on.  When
 * it is on, a call to one of the {@code read} methods results in an
 * update on the message digest.  But when it is off, the message
 * digest is not updated.
 *
 * @param on true to turn the digest function on, false to turn
 * it off.
 * @apiSince 1
 */

public void on(boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Prints a string representation of this digest input stream and
 * its associated message digest object.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The message digest associated with this stream.
 * @apiSince 1
 */

protected java.security.MessageDigest digest;
}

