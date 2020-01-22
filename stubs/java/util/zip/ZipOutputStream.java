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
 * This class implements an output stream filter for writing files in the
 * ZIP file format. Includes support for both compressed and uncompressed
 * entries.
 *
 * @author      David Connelly
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ZipOutputStream extends java.util.zip.DeflaterOutputStream {

/**
 * Creates a new ZIP output stream.
 *
 * <p>The UTF-8 {@link java.nio.charset.Charset charset} is used
 * to encode the entry names and comments.
 *
 * @param out the actual output stream
 * @apiSince 1
 */

public ZipOutputStream(java.io.OutputStream out) { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new ZIP output stream.
 *
 * @param out the actual output stream
 *
 * @param charset the {@linkplain java.nio.charset.Charset charset}
 *                to be used to encode the entry names and comments
 *
 * @since 1.7
 * @apiSince 24
 */

public ZipOutputStream(java.io.OutputStream out, java.nio.charset.Charset charset) { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the ZIP file comment.
 * @param comment the comment string
 * @exception java.lang.IllegalArgumentException if the length of the specified
 *            ZIP file comment is greater than 0xFFFF bytes
 * @apiSince 1
 */

public void setComment(java.lang.String comment) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default compression method for subsequent entries. This
 * default will be used whenever the compression method is not specified
 * for an individual ZIP file entry, and is initially set to DEFLATED.
 * @param method the default compression method
 * @exception java.lang.IllegalArgumentException if the specified compression method
 *            is invalid
 * @apiSince 1
 */

public void setMethod(int method) { throw new RuntimeException("Stub!"); }

/**
 * Sets the compression level for subsequent entries which are DEFLATED.
 * The default setting is DEFAULT_COMPRESSION.
 * @param level the compression level (0-9)
 * @exception java.lang.IllegalArgumentException if the compression level is invalid
 * @apiSince 1
 */

public void setLevel(int level) { throw new RuntimeException("Stub!"); }

/**
 * Begins writing a new ZIP file entry and positions the stream to the
 * start of the entry data. Closes the current entry if still active.
 * The default compression method will be used if no compression method
 * was specified for the entry, and the current time will be used if
 * the entry has no set modification time.
 * @param e the ZIP entry to be written
 * @exception java.util.zip.ZipException if a ZIP format error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void putNextEntry(java.util.zip.ZipEntry e) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the current ZIP entry and positions the stream for writing
 * the next entry.
 * @exception java.util.zip.ZipException if a ZIP format error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void closeEntry() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes an array of bytes to the current ZIP entry data. This method
 * will block until all the bytes are written.
 * @param b the data to be written
 * @param off the start offset in the data
 * @param len the number of bytes that are written
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public synchronized void write(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Finishes writing the contents of the ZIP output stream without closing
 * the underlying stream. Use this method when applying multiple filters
 * in succession to the same output stream.
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O exception has occurred
 * @apiSince 1
 */

public void finish() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the ZIP output stream as well as the stream being filtered.
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

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

/**
 * Compression method for compressed (DEFLATED) entries.
 * @apiSince 1
 */

public static final int DEFLATED = 8; // 0x8

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

/**
 * Compression method for uncompressed (STORED) entries.
 * @apiSince 1
 */

public static final int STORED = 0; // 0x0
}

