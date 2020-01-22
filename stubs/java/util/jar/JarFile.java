/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 * The <code>JarFile</code> class is used to read the contents of a jar file
 * from any file that can be opened with <code>java.io.RandomAccessFile</code>.
 * It extends the class <code>java.util.zip.ZipFile</code> with support
 * for reading an optional <code>Manifest</code> entry. The
 * <code>Manifest</code> can be used to specify meta-information about the
 * jar file and its entries.
 *
 * <p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor
 * or method in this class will cause a {@link java.lang.NullPointerException NullPointerException} to be
 * thrown.
 *
 * If the verify flag is on when opening a signed jar file, the content of the
 * file is verified against its signature embedded inside the file. Please note
 * that the verification process does not include validating the signer's
 * certificate. A caller should inspect the return value of
 * {@link java.util.jar.JarEntry#getCodeSigners() JarEntry#getCodeSigners()} to further determine if the signature
 * can be trusted.
 *
 * @author  David Connelly
 * @see     java.util.jar.Manifest
 * @see     java.util.zip.ZipFile
 * @see     java.util.jar.JarEntry
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JarFile extends java.util.zip.ZipFile {

/**
 * Creates a new <code>JarFile</code> to read from the specified
 * file <code>name</code>. The <code>JarFile</code> will be verified if
 * it is signed.
 * @param name the name of the jar file to be opened for reading
 * @throws java.io.IOException if an I/O error has occurred
 * @throws java.lang.SecurityException if access to the file is denied
 *         by the SecurityManager
 * @apiSince 1
 */

public JarFile(java.lang.String name) throws java.io.IOException { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarFile</code> to read from the specified
 * file <code>name</code>.
 * @param name the name of the jar file to be opened for reading
 * @param verify whether or not to verify the jar file if
 * it is signed.
 * @throws java.io.IOException if an I/O error has occurred
 * @throws java.lang.SecurityException if access to the file is denied
 *         by the SecurityManager
 * @apiSince 1
 */

public JarFile(java.lang.String name, boolean verify) throws java.io.IOException { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarFile</code> to read from the specified
 * <code>File</code> object. The <code>JarFile</code> will be verified if
 * it is signed.
 * @param file the jar file to be opened for reading
 * @throws java.io.IOException if an I/O error has occurred
 * @throws java.lang.SecurityException if access to the file is denied
 *         by the SecurityManager
 * @apiSince 1
 */

public JarFile(java.io.File file) throws java.io.IOException { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarFile</code> to read from the specified
 * <code>File</code> object.
 * @param file the jar file to be opened for reading
 * @param verify whether or not to verify the jar file if
 * it is signed.
 * @throws java.io.IOException if an I/O error has occurred
 * @throws java.lang.SecurityException if access to the file is denied
 *         by the SecurityManager.
 * @apiSince 1
 */

public JarFile(java.io.File file, boolean verify) throws java.io.IOException { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarFile</code> to read from the specified
 * <code>File</code> object in the specified mode.  The mode argument
 * must be either <tt>OPEN_READ</tt> or <tt>OPEN_READ | OPEN_DELETE</tt>.
 *
 * @param file the jar file to be opened for reading
 * @param verify whether or not to verify the jar file if
 * it is signed.
 * @param mode the mode in which the file is to be opened
 * @throws java.io.IOException if an I/O error has occurred
 * @throws java.lang.IllegalArgumentException
 *         if the <tt>mode</tt> argument is invalid
 * @throws java.lang.SecurityException if access to the file is denied
 *         by the SecurityManager
 * @since 1.3
 * @apiSince 1
 */

public JarFile(java.io.File file, boolean verify, int mode) throws java.io.IOException { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the jar file manifest, or <code>null</code> if none.
 *
 * @return the jar file manifest, or <code>null</code> if none
 *
 * @throws java.lang.IllegalStateException
 *         may be thrown if the jar file has been closed
 * @throws java.io.IOException  if an I/O error has occurred
 * @apiSince 1
 */

public java.util.jar.Manifest getManifest() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>JarEntry</code> for the given entry name or
 * <code>null</code> if not found.
 *
 * @param name the jar file entry name
 * @return the <code>JarEntry</code> for the given entry name or
 *         <code>null</code> if not found.
 *
 * @throws java.lang.IllegalStateException
 *         may be thrown if the jar file has been closed
 *
 * @see java.util.jar.JarEntry
 * @apiSince 1
 */

public java.util.jar.JarEntry getJarEntry(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>ZipEntry</code> for the given entry name or
 * <code>null</code> if not found.
 *
 * @param name the jar file entry name
 * @return the <code>ZipEntry</code> for the given entry name or
 *         <code>null</code> if not found
 *
 * @throws java.lang.IllegalStateException
 *         may be thrown if the jar file has been closed
 *
 * @see java.util.zip.ZipEntry
 * @apiSince 1
 */

public java.util.zip.ZipEntry getEntry(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns an enumeration of the zip file entries.
 * @apiSince 1
 */

public java.util.Enumeration<java.util.jar.JarEntry> entries() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.util.stream.Stream<java.util.jar.JarEntry> stream() { throw new RuntimeException("Stub!"); }

/**
 * Returns an input stream for reading the contents of the specified
 * zip file entry.
 * @param ze the zip file entry
 * @return an input stream for reading the contents of the specified
 *         zip file entry
 * @throws java.util.zip.ZipException if a zip file format error has occurred
 * @throws java.io.IOException if an I/O error has occurred
 * @throws java.lang.SecurityException if any of the jar file entries
 *         are incorrectly signed.
 * @throws java.lang.IllegalStateException
 *         may be thrown if the jar file has been closed
 * @apiSince 1
 */

public synchronized java.io.InputStream getInputStream(java.util.zip.ZipEntry ze) throws java.io.IOException { throw new RuntimeException("Stub!"); }

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

/**
 * The JAR manifest file name.
 * @apiSince 1
 */

public static final java.lang.String MANIFEST_NAME = "META-INF/MANIFEST.MF";
}

