/*
 * Copyright (c) 1999, 2008, Oracle and/or its affiliates. All rights reserved.
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



package java.util.regex;


/**
 * Unchecked exception thrown to indicate a syntax error in a
 * regular-expression pattern.
 *
 * @author  unascribed
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PatternSyntaxException extends java.lang.IllegalArgumentException {

/**
 * Constructs a new instance of this class.
 *
 * @param  desc
 *         A description of the error
 *
 * @param  regex
 *         The erroneous pattern
 *
 * @param  index
 *         The approximate index in the pattern of the error,
 *         or <tt>-1</tt> if the index is not known
 * @apiSince 1
 */

public PatternSyntaxException(java.lang.String desc, java.lang.String regex, int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the error index.
 *
 * @return  The approximate index in the pattern of the error,
 *         or <tt>-1</tt> if the index is not known
 * @apiSince 1
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the description of the error.
 *
 * @return  The description of the error
 * @apiSince 1
 */

public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the erroneous regular-expression pattern.
 *
 * @return  The erroneous pattern
 * @apiSince 1
 */

public java.lang.String getPattern() { throw new RuntimeException("Stub!"); }

/**
 * Returns a multi-line string containing the description of the syntax
 * error and its index, the erroneous regular-expression pattern, and a
 * visual indication of the error index within the pattern.
 *
 * @return  The full detail message
 * @apiSince 1
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }
}

