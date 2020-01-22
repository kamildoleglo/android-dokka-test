/*
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

import java.util.zip.ZipEntry;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.CodeSigner;

/**
 * This class is used to represent a JAR file entry.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JarEntry extends java.util.zip.ZipEntry {

/**
 * Creates a new <code>JarEntry</code> for the specified JAR file
 * entry name.
 *
 * @param name the JAR file entry name
 * @exception java.lang.NullPointerException if the entry name is <code>null</code>
 * @exception java.lang.IllegalArgumentException if the entry name is longer than
 *            0xFFFF bytes.
 * @apiSince 1
 */

public JarEntry(java.lang.String name) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarEntry</code> with fields taken from the
 * specified <code>ZipEntry</code> object.
 * @param ze the <code>ZipEntry</code> object to create the
 *           <code>JarEntry</code> from
 * @apiSince 1
 */

public JarEntry(java.util.zip.ZipEntry ze) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>JarEntry</code> with fields taken from the
 * specified <code>JarEntry</code> object.
 *
 * @param je the <code>JarEntry</code> to copy
 * @apiSince 1
 */

public JarEntry(java.util.jar.JarEntry je) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>Manifest</code> <code>Attributes</code> for this
 * entry, or <code>null</code> if none.
 *
 * @return the <code>Manifest</code> <code>Attributes</code> for this
 * entry, or <code>null</code> if none
 * @throws java.io.IOException  if an I/O error has occurred
 * @apiSince 1
 */

public java.util.jar.Attributes getAttributes() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>Certificate</code> objects for this entry, or
 * <code>null</code> if none. This method can only be called once
 * the <code>JarEntry</code> has been completely verified by reading
 * from the entry input stream until the end of the stream has been
 * reached. Otherwise, this method will return <code>null</code>.
 *
 * <p>The returned certificate array comprises all the signer certificates
 * that were used to verify this entry. Each signer certificate is
 * followed by its supporting certificate chain (which may be empty).
 * Each signer certificate and its supporting certificate chain are ordered
 * bottom-to-top (i.e., with the signer certificate first and the (root)
 * certificate authority last).
 *
 * @return the <code>Certificate</code> objects for this entry, or
 * <code>null</code> if none.
 * @apiSince 1
 */

public java.security.cert.Certificate[] getCertificates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>CodeSigner</code> objects for this entry, or
 * <code>null</code> if none. This method can only be called once
 * the <code>JarEntry</code> has been completely verified by reading
 * from the entry input stream until the end of the stream has been
 * reached. Otherwise, this method will return <code>null</code>.
 *
 * <p>The returned array comprises all the code signers that have signed
 * this entry.
 *
 * @return the <code>CodeSigner</code> objects for this entry, or
 * <code>null</code> if none.
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.CodeSigner[] getCodeSigners() { throw new RuntimeException("Stub!"); }

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

