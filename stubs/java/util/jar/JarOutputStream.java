/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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



package java.util.jar;

import java.util.zip.*;
import java.io.*;

/**
 * The <code>JarOutputStream</code> class is used to write the contents
 * of a JAR file to any output stream. It extends the class
 * <code>java.util.zip.ZipOutputStream</code> with support
 * for writing an optional <code>Manifest</code> entry. The
 * <code>Manifest</code> can be used to specify meta-information about
 * the JAR file and its entries.
 *
 * @author  David Connelly
 * @see     java.util.jar.Manifest
 * @see     java.util.zip.ZipOutputStream
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JarOutputStream extends java.util.zip.ZipOutputStream {

/**
 * Creates a new <code>JarOutputStream</code> with the specified
 * <code>Manifest</code>. The manifest is written as the first
 * entry to the output stream.
 *
 * @param out the actual output stream
 * @param man the optional <code>Manifest</code>
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public JarOutputStream(java.io.OutputStream out, java.util.jar.Manifest man) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarOutputStream</code> with no manifest.
 * @param out the actual output stream
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public JarOutputStream(java.io.OutputStream out) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Begins writing a new JAR file entry and positions the stream
 * to the start of the entry data. This method will also close
 * any previous entry. The default compression method will be
 * used if no compression method was specified for the entry.
 * The current time will be used if the entry has no set modification
 * time.
 *
 * @param ze the ZIP/JAR entry to be written
 * @exception java.util.zip.ZipException if a ZIP error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void putNextEntry(java.util.zip.ZipEntry ze) throws java.io.IOException { throw new RuntimeException("Stub!"); }

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

