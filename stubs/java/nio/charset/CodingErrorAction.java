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


/**
 * A typesafe enumeration for coding-error actions.
 *
 * <p> Instances of this class are used to specify how malformed-input and
 * unmappable-character errors are to be handled by charset <a
 * href="CharsetDecoder.html#cae">decoders</a> and <a
 * href="CharsetEncoder.html#cae">encoders</a>.  </p>
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CodingErrorAction {

private CodingErrorAction() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this action.
 *
 * @return  A descriptive string
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Action indicating that a coding error is to be handled by dropping the
 * erroneous input and resuming the coding operation.
 * @apiSince 1
 */

public static final java.nio.charset.CodingErrorAction IGNORE;
static { IGNORE = null; }

/**
 * Action indicating that a coding error is to be handled by dropping the
 * erroneous input, appending the coder's replacement value to the output
 * buffer, and resuming the coding operation.
 * @apiSince 1
 */

public static final java.nio.charset.CodingErrorAction REPLACE;
static { REPLACE = null; }

/**
 * Action indicating that a coding error is to be reported, either by
 * returning a {@link java.nio.charset.CoderResult CoderResult} object or by throwing a {@link java.nio.charset.CharacterCodingException CharacterCodingException}, whichever is appropriate for the method
 * implementing the coding process.
 * @apiSince 1
 */

public static final java.nio.charset.CodingErrorAction REPORT;
static { REPORT = null; }
}

