/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
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



package java.util;


/**
 * Thrown by various accessor methods to indicate that the element being requested
 * does not exist.
 *
 * @author  unascribed
 * @see     java.util.Enumeration#nextElement()
 * @see     java.util.Iterator#next()
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NoSuchElementException extends java.lang.RuntimeException {

/**
 * Constructs a <code>NoSuchElementException</code> with <tt>null</tt>
 * as its error message string.
 * @apiSince 1
 */

public NoSuchElementException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>NoSuchElementException</code>, saving a reference
 * to the error message string <tt>s</tt> for later retrieval by the
 * <tt>getMessage</tt> method.
 *
 * @param   s   the detail message.
 * @apiSince 1
 */

public NoSuchElementException(java.lang.String s) { throw new RuntimeException("Stub!"); }
}

