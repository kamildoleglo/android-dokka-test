/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.charset;

import java.nio.*;

/**
 * A description of the result state of a coder.
 *
 * <p> A charset coder, that is, either a decoder or an encoder, consumes bytes
 * (or characters) from an input buffer, translates them, and writes the
 * resulting characters (or bytes) to an output buffer.  A coding process
 * terminates for one of four categories of reasons, which are described by
 * instances of this class:
 *
 * <ul>
 *
 *   <li><p> <i>Underflow</i> is reported when there is no more input to be
 *   processed, or there is insufficient input and additional input is
 *   required.  This condition is represented by the unique result object
 *   {@link #UNDERFLOW}, whose {@link #isUnderflow() isUnderflow} method
 *   returns <tt>true</tt>.  </p></li>
 *
 *   <li><p> <i>Overflow</i> is reported when there is insufficient room
 *   remaining in the output buffer.  This condition is represented by the
 *   unique result object {@link #OVERFLOW}, whose {@link #isOverflow()
 *   isOverflow} method returns <tt>true</tt>.  </p></li>
 *
 *   <li><p> A <i>malformed-input error</i> is reported when a sequence of
 *   input units is not well-formed.  Such errors are described by instances of
 *   this class whose {@link #isMalformed() isMalformed} method returns
 *   <tt>true</tt> and whose {@link #length() length} method returns the length
 *   of the malformed sequence.  There is one unique instance of this class for
 *   all malformed-input errors of a given length.  </p></li>
 *
 *   <li><p> An <i>unmappable-character error</i> is reported when a sequence
 *   of input units denotes a character that cannot be represented in the
 *   output charset.  Such errors are described by instances of this class
 *   whose {@link #isUnmappable() isUnmappable} method returns <tt>true</tt> and
 *   whose {@link #length() length} method returns the length of the input
 *   sequence denoting the unmappable character.  There is one unique instance
 *   of this class for all unmappable-character errors of a given length.
 *   </p></li>
 *
 * </ul>
 *
 * <p> For convenience, the {@link #isError() isError} method returns <tt>true</tt>
 * for result objects that describe malformed-input and unmappable-character
 * errors but <tt>false</tt> for those that describe underflow or overflow
 * conditions.  </p>
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CoderResult {

private CoderResult() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this coder result.
 *
 * @return  A descriptive string
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this object describes an underflow condition.
 *
 * @return  <tt>true</tt> if, and only if, this object denotes underflow
 * @apiSince 1
 */

public boolean isUnderflow() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this object describes an overflow condition.
 *
 * @return  <tt>true</tt> if, and only if, this object denotes overflow
 * @apiSince 1
 */

public boolean isOverflow() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this object describes an error condition.
 *
 * @return  <tt>true</tt> if, and only if, this object denotes either a
 *          malformed-input error or an unmappable-character error
 * @apiSince 1
 */

public boolean isError() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this object describes a malformed-input error.
 *
 * @return  <tt>true</tt> if, and only if, this object denotes a
 *          malformed-input error
 * @apiSince 1
 */

public boolean isMalformed() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this object describes an unmappable-character
 * error.
 *
 * @return  <tt>true</tt> if, and only if, this object denotes an
 *          unmappable-character error
 * @apiSince 1
 */

public boolean isUnmappable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the erroneous input described by this
 * object&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * @return  The length of the erroneous input, a positive integer
 *
 * @throws  java.lang.UnsupportedOperationException
 *          If this object does not describe an error condition, that is,
 *          if the {@link #isError() isError} does not return <tt>true</tt>
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Static factory method that returns the unique object describing a
 * malformed-input error of the given length.
 *
 * @param   length
 *          The given length
 *
 * @return  The requested coder-result object
 * @apiSince 1
 */

public static java.nio.charset.CoderResult malformedForLength(int length) { throw new RuntimeException("Stub!"); }

/**
 * Static factory method that returns the unique result object describing
 * an unmappable-character error of the given length.
 *
 * @param   length
 *          The given length
 *
 * @return  The requested coder-result object
 * @apiSince 1
 */

public static java.nio.charset.CoderResult unmappableForLength(int length) { throw new RuntimeException("Stub!"); }

/**
 * Throws an exception appropriate to the result described by this object.
 *
 * @throws  java.nio.BufferUnderflowException
 *          If this object is {@link #UNDERFLOW}
 *
 * @throws  java.nio.BufferOverflowException
 *          If this object is {@link #OVERFLOW}
 *
 * @throws  java.nio.charset.MalformedInputException
 *          If this object represents a malformed-input error; the
 *          exception's length value will be that of this object
 *
 * @throws  java.nio.charset.UnmappableCharacterException
 *          If this object represents an unmappable-character error; the
 *          exceptions length value will be that of this object
 * @apiSince 1
 */

public void throwException() throws java.nio.charset.CharacterCodingException { throw new RuntimeException("Stub!"); }

/**
 * Result object indicating overflow, meaning that there is insufficient
 * room in the output buffer.
 * @apiSince 1
 */

public static final java.nio.charset.CoderResult OVERFLOW;
static { OVERFLOW = null; }

/**
 * Result object indicating underflow, meaning that either the input buffer
 * has been completely consumed or, if the input buffer is not yet empty,
 * that additional input is required.
 * @apiSince 1
 */

public static final java.nio.charset.CoderResult UNDERFLOW;
static { UNDERFLOW = null; }
}

