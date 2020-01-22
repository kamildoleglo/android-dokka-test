/*
 * Copyright (c) 1996, 2005, Oracle and/or its affiliates. All rights reserved.
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



package java.io;


/**
 * Abstract class for writing filtered character streams.
 * The abstract class <code>FilterWriter</code> itself
 * provides default methods that pass all requests to the
 * contained stream. Subclasses of <code>FilterWriter</code>
 * should override some of these methods and may also
 * provide additional methods and fields.
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class FilterWriter extends java.io.Writer {

/**
 * Create a new filtered writer.
 *
 * @param out  a Writer object to provide the underlying stream.
 * @throws java.lang.NullPointerException if <code>out</code> is <code>null</code>
 * @apiSince 1
 */

protected FilterWriter(java.io.Writer out) { throw new RuntimeException("Stub!"); }

/**
 * Writes a single character.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(int c) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a portion of an array of characters.
 *
 * @param  cbuf  Buffer of characters to be written
 * @param  off   Offset from which to start reading characters
 * @param  len   Number of characters to be written
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(char[] cbuf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a portion of a string.
 *
 * @param  str  String to be written
 * @param  off  Offset from which to start reading characters
 * @param  len  Number of characters to be written
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(java.lang.String str, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Flushes the stream.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void flush() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * The underlying character-output stream.
 * @apiSince 1
 */

protected java.io.Writer out;
}

