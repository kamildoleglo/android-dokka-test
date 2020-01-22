/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2015, Oracle and/or its affiliates. All rights reserved.
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



package java.util.zip;

import java.nio.charset.Charset;
import java.io.IOException;

/**
 * This class implements an input stream filter for reading files in the
 * ZIP file format. Includes support for both compressed and uncompressed
 * entries.
 *
 * @author      David Connelly
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ZipInputStream extends java.util.zip.InflaterInputStream {

/**
 * Creates a new ZIP input stream.
 *
 * <p>The UTF-8 {@link java.nio.charset.Charset charset} is used to
 * decode the entry names.
 *
 * @param in the actual input stream
 * @apiSince 1
 */

public ZipInputStream(java.io.InputStream in) { super((java.io.InputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new ZIP input stream.
 *
 * @param in the actual input stream
 *
 * @param charset
 *        The {@linkplain java.nio.charset.Charset charset} to be
 *        used to decode the ZIP entry name (ignored if the
 *        <a href="package-summary.html#lang_encoding"> language
 *        encoding bit</a> of the ZIP entry's general purpose bit
 *        flag is set).
 *
 * @since 1.7
 * @apiSince 24
 */

public ZipInputStream(java.io.InputStream in, java.nio.charset.Charset charset) { super((java.io.InputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Reads the next ZIP file entry and positions the stream at the
 * beginning of the entry data.
 * @return the next ZIP file entry, or null if there are no more entries
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public java.util.zip.ZipEntry getNextEntry() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the current ZIP entry and positions the stream for reading the
 * next entry.
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void closeEntry() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns 0 after EOF has reached for the current entry data,
 * otherwise always return 1.
 * <p>
 * Programs should not count on this method to return the actual number
 * of bytes that could be read without blocking.
 *
 * @return     1 before EOF and 0 after EOF has reached for current entry.
 * @exception  java.io.IOException  if an I/O error occurs.
 *
 * @apiSince 1
 */

public int available() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads from the current ZIP entry into an array of bytes.
 * If <code>len</code> is not zero, the method
 * blocks until some input is available; otherwise, no
 * bytes are read and <code>0</code> is returned.
 * @param b the buffer into which the data is read
 * @param off the start offset in the destination array <code>b</code>
 * @param len the maximum number of bytes read
 * @return the actual number of bytes read, or -1 if the end of the
 *         entry is reached
 * @exception  java.lang.NullPointerException if <code>b</code> is <code>null</code>.
 * @exception  java.lang.IndexOutOfBoundsException if <code>off</code> is negative,
 * <code>len</code> is negative, or <code>len</code> is greater than
 * <code>b.length - off</code>
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips specified number of bytes in the current ZIP entry.
 * @param n the number of bytes to skip
 * @return the actual number of bytes skipped
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @exception java.lang.IllegalArgumentException if {@code n < 0}
 * @apiSince 1
 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this input stream and releases any system resources associated
 * with the stream.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>ZipEntry</code> object for the specified
 * entry name.
 *
 * @param name the ZIP file entry name
 * @return the ZipEntry just created
 * @apiSince 1
 */

protected java.util.zip.ZipEntry createZipEntry(java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public static final int CENATT = 36; // 0x24

/** @apiSince 21 */

public static final int CENATX = 38; // 0x26

/** @apiSince 21 */

public static final int CENCOM = 32; // 0x20

/** @apiSince 21 */

public static final int CENCRC = 16; // 0x10

/** @apiSince 21 */

public static final int CENDSK = 34; // 0x22

/** @apiSince 21 */

public static final int CENEXT = 30; // 0x1e

/** @apiSince 21 */

public static final int CENFLG = 8; // 0x8

/** @apiSince 21 */

public static final int CENHDR = 46; // 0x2e

/** @apiSince 21 */

public static final int CENHOW = 10; // 0xa

/** @apiSince 21 */

public static final int CENLEN = 24; // 0x18

/** @apiSince 21 */

public static final int CENNAM = 28; // 0x1c

/** @apiSince 21 */

public static final int CENOFF = 42; // 0x2a

/** @apiSince 21 */

public static final long CENSIG = 33639248L; // 0x2014b50L

/** @apiSince 21 */

public static final int CENSIZ = 20; // 0x14

/** @apiSince 21 */

public static final int CENTIM = 12; // 0xc

/** @apiSince 21 */

public static final int CENVEM = 4; // 0x4

/** @apiSince 21 */

public static final int CENVER = 6; // 0x6

/** @apiSince 21 */

public static final int ENDCOM = 20; // 0x14

/** @apiSince 21 */

public static final int ENDHDR = 22; // 0x16

/** @apiSince 21 */

public static final int ENDOFF = 16; // 0x10

/** @apiSince 21 */

public static final long ENDSIG = 101010256L; // 0x6054b50L

/** @apiSince 21 */

public static final int ENDSIZ = 12; // 0xc

/** @apiSince 21 */

public static final int ENDSUB = 8; // 0x8

/** @apiSince 21 */

public static final int ENDTOT = 10; // 0xa

/** @apiSince 21 */

public static final int EXTCRC = 4; // 0x4

/** @apiSince 21 */

public static final int EXTHDR = 16; // 0x10

/** @apiSince 21 */

public static final int EXTLEN = 12; // 0xc

/** @apiSince 21 */

public static final long EXTSIG = 134695760L; // 0x8074b50L

/** @apiSince 21 */

public static final int EXTSIZ = 8; // 0x8

/** @apiSince 21 */

public static final int LOCCRC = 14; // 0xe

/** @apiSince 21 */

public static final int LOCEXT = 28; // 0x1c

/** @apiSince 21 */

public static final int LOCFLG = 6; // 0x6

/** @apiSince 21 */

public static final int LOCHDR = 30; // 0x1e

/** @apiSince 21 */

public static final int LOCHOW = 8; // 0x8

/** @apiSince 21 */

public static final int LOCLEN = 22; // 0x16

/** @apiSince 21 */

public static final int LOCNAM = 26; // 0x1a

/** @apiSince 21 */

public static final long LOCSIG = 67324752L; // 0x4034b50L

/** @apiSince 21 */

public static final int LOCSIZ = 18; // 0x12

/** @apiSince 21 */

public static final int LOCTIM = 10; // 0xa

/** @apiSince 21 */

public static final int LOCVER = 4; // 0x4
}

