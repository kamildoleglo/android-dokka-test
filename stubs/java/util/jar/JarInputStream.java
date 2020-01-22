/*
 * Copyright (c) 1997, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * The <code>JarInputStream</code> class is used to read the contents of
 * a JAR file from any input stream. It extends the class
 * <code>java.util.zip.ZipInputStream</code> with support for reading
 * an optional <code>Manifest</code> entry. The <code>Manifest</code>
 * can be used to store meta-information about the JAR file and its entries.
 *
 * @author  David Connelly
 * @see     java.util.jar.Manifest
 * @see     java.util.zip.ZipInputStream
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JarInputStream extends java.util.zip.ZipInputStream {

/**
 * Creates a new <code>JarInputStream</code> and reads the optional
 * manifest. If a manifest is present, also attempts to verify
 * the signatures if the JarInputStream is signed.
 * @param in the actual input stream
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public JarInputStream(java.io.InputStream in) throws java.io.IOException { super((java.io.InputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarInputStream</code> and reads the optional
 * manifest. If a manifest is present and verify is true, also attempts
 * to verify the signatures if the JarInputStream is signed.
 *
 * @param in the actual input stream
 * @param verify whether or not to verify the JarInputStream if
 * it is signed.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public JarInputStream(java.io.InputStream in, boolean verify) throws java.io.IOException { super((java.io.InputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>Manifest</code> for this JAR file, or
 * <code>null</code> if none.
 *
 * @return the <code>Manifest</code> for this JAR file, or
 *         <code>null</code> if none.
 * @apiSince 1
 */

public java.util.jar.Manifest getManifest() { throw new RuntimeException("Stub!"); }

/**
 * Reads the next ZIP file entry and positions the stream at the
 * beginning of the entry data. If verification has been enabled,
 * any invalid signature detected while positioning the stream for
 * the next entry will result in an exception.
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @exception java.lang.SecurityException if any of the jar file entries
 *         are incorrectly signed.
 * @apiSince 1
 */

public java.util.zip.ZipEntry getNextEntry() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads the next JAR file entry and positions the stream at the
 * beginning of the entry data. If verification has been enabled,
 * any invalid signature detected while positioning the stream for
 * the next entry will result in an exception.
 * @return the next JAR file entry, or null if there are no more entries
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @exception java.lang.SecurityException if any of the jar file entries
 *         are incorrectly signed.
 * @apiSince 1
 */

public java.util.jar.JarEntry getNextJarEntry() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads from the current JAR file entry into an array of bytes.
 * If <code>len</code> is not zero, the method
 * blocks until some input is available; otherwise, no
 * bytes are read and <code>0</code> is returned.
 * If verification has been enabled, any invalid signature
 * on the current entry will be reported at some point before the
 * end of the entry is reached.
 * @param b the buffer into which the data is read
 * @param off the start offset in the destination array <code>b</code>
 * @param len the maximum number of bytes to read
 * @return the actual number of bytes read, or -1 if the end of the
 *         entry is reached
 * @exception  java.lang.NullPointerException If <code>b</code> is <code>null</code>.
 * @exception  java.lang.IndexOutOfBoundsException If <code>off</code> is negative,
 * <code>len</code> is negative, or <code>len</code> is greater than
 * <code>b.length - off</code>
 * @exception java.util.zip.ZipException if a ZIP file error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @exception java.lang.SecurityException if any of the jar file entries
 *         are incorrectly signed.
 * @apiSince 1
 */

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarEntry</code> (<code>ZipEntry</code>) for the
 * specified JAR file entry name. The manifest attributes of
 * the specified JAR file entry name will be copied to the new
 * <CODE>JarEntry</CODE>.
 *
 * @param name the name of the JAR/ZIP file entry
 * @return the <code>JarEntry</code> object just created
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

