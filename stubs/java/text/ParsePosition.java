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

/*
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1998 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */



package java.text;


/**
 * <code>ParsePosition</code> is a simple class used by <code>Format</code>
 * and its subclasses to keep track of the current position during parsing.
 * The <code>parseObject</code> method in the various <code>Format</code>
 * classes requires a <code>ParsePosition</code> object as an argument.
 *
 * <p>
 * By design, as you parse through a string with different formats,
 * you can use the same <code>ParsePosition</code>, since the index parameter
 * records the current position.
 *
 * @author      Mark Davis
 * @see         java.text.Format
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ParsePosition {

/**
 * Create a new ParsePosition with the given initial index.
 *
 * @param index initial index
 * @apiSince 1
 */

public ParsePosition(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current parse position.  On input to a parse method, this
 * is the index of the character at which parsing will begin; on output, it
 * is the index of the character following the last character parsed.
 *
 * @return the current parse position
 * @apiSince 1
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Set the current parse position.
 *
 * @param index the current parse position
 * @apiSince 1
 */

public void setIndex(int index) { throw new RuntimeException("Stub!"); }

/**
 * Set the index at which a parse error occurred.  Formatters
 * should set this before returning an error code from their
 * parseObject method.  The default value is -1 if this is not set.
 *
 * @param ei the index at which an error occurred
 * @since 1.2
 * @apiSince 1
 */

public void setErrorIndex(int ei) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the index at which an error occurred, or -1 if the
 * error index has not been set.
 *
 * @return the index at which an error occurred
 * @since 1.2
 * @apiSince 1
 */

public int getErrorIndex() { throw new RuntimeException("Stub!"); }

/**
 * Overrides equals
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this ParsePosition.
 * @return a hash code value for this object
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Return a string representation of this ParsePosition.
 * @return  a string representation of this object
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

