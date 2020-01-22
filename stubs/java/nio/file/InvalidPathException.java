/*
 * Copyright (c) 2007, 2009, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.file;


/**
 * Unchecked exception thrown when path string cannot be converted into a
 * {@link java.nio.file.Path Path} because the path string contains invalid characters, or
 * the path string is invalid for other file system specific reasons.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InvalidPathException extends java.lang.IllegalArgumentException {

/**
 * Constructs an instance from the given input string, reason, and error
 * index.
 *
 * @param  input   the input string
 * @param  reason  a string explaining why the input was rejected
 * @param  index   the index at which the error occurred,
 *                 or <tt>-1</tt> if the index is not known
 *
 * @throws  java.lang.NullPointerException
 *          if either the input or reason strings are <tt>null</tt>
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the error index is less than <tt>-1</tt>
 * @apiSince 26
 */

public InvalidPathException(java.lang.String input, java.lang.String reason, int index) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an instance from the given input string and reason.  The
 * resulting object will have an error index of <tt>-1</tt>.
 *
 * @param  input   the input string
 * @param  reason  a string explaining why the input was rejected
 *
 * @throws  java.lang.NullPointerException
 *          if either the input or reason strings are <tt>null</tt>
 * @apiSince 26
 */

public InvalidPathException(java.lang.String input, java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Returns the input string.
 *
 * @return  the input string
 * @apiSince 26
 */

public java.lang.String getInput() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string explaining why the input string was rejected.
 *
 * @return  the reason string
 * @apiSince 26
 */

public java.lang.String getReason() { throw new RuntimeException("Stub!"); }

/**
 * Returns an index into the input string of the position at which the
 * error occurred, or <tt>-1</tt> if this position is not known.
 *
 * @return  the error index
 * @apiSince 26
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing the error.  The resulting string
 * consists of the reason string followed by a colon character
 * (<tt>':'</tt>), a space, and the input string.  If the error index is
 * defined then the string <tt>" at index "</tt> followed by the index, in
 * decimal, is inserted after the reason string and before the colon
 * character.
 *
 * @return  a string describing the error
 * @apiSince 26
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }
}

