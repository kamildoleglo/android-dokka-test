/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1995, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.file.attribute.FileTime;

/**
 * This class is used to represent a ZIP file entry.
 *
 * @author      David Connelly
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ZipEntry implements java.lang.Cloneable {

/**
 * Creates a new zip entry with the specified name.
 *
 * @param  name
 *         The entry name
 *
 * @throws java.lang.NullPointerException if the entry name is null
 * @throws java.lang.IllegalArgumentException if the entry name is longer than
 *         0xFFFF bytes
 * @apiSince 1
 */

public ZipEntry(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new zip entry with fields taken from the specified
 * zip entry.
 *
 * @param  e
 *         A zip Entry object
 *
 * @throws java.lang.NullPointerException if the entry object is null
 * @apiSince 1
 */

public ZipEntry(java.util.zip.ZipEntry e) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the entry.
 * @return the name of the entry
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the last modification time of the entry.
 *
 * <p> If the entry is output to a ZIP file or ZIP file formatted
 * output stream the last modification time set by this method will
 * be stored into the {@code date and time fields} of the zip file
 * entry and encoded in standard {@code MS-DOS date and time format}.
 * The {@link java.util.TimeZone#getDefault() default TimeZone} is
 * used to convert the epoch time to the MS-DOS data and time.
 *
 * @param  time
 *         The last modification time of the entry in milliseconds
 *         since the epoch
 *
 * @see #getTime()
 * @see #getLastModifiedTime()
 * @apiSince 1
 */

public void setTime(long time) { throw new RuntimeException("Stub!"); }

/**
 * Returns the last modification time of the entry.
 *
 * <p> If the entry is read from a ZIP file or ZIP file formatted
 * input stream, this is the last modification time from the {@code
 * date and time fields} of the zip file entry. The
 * {@link java.util.TimeZone#getDefault() default TimeZone} is used
 * to convert the standard MS-DOS formatted date and time to the
 * epoch time.
 *
 * @return  The last modification time of the entry in milliseconds
 *          since the epoch, or -1 if not specified
 *
 * @see #setTime(long)
 * @see #setLastModifiedTime(FileTime)
 * @apiSince 1
 */

public long getTime() { throw new RuntimeException("Stub!"); }

/**
 * Sets the last modification time of the entry.
 *
 * <p> When output to a ZIP file or ZIP file formatted output stream
 * the last modification time set by this method will be stored into
 * zip file entry's {@code date and time fields} in {@code standard
 * MS-DOS date and time format}), and the extended timestamp fields
 * in {@code optional extra data} in UTC time.
 *
 * @param  time
 *         The last modification time of the entry
 * @return This zip entry
 *
 * @throws java.lang.NullPointerException if the {@code time} is null
 *
 * @see #getLastModifiedTime()
 * @since 1.8
 * @apiSince 26
 */

public java.util.zip.ZipEntry setLastModifiedTime(java.nio.file.attribute.FileTime time) { throw new RuntimeException("Stub!"); }

/**
 * Returns the last modification time of the entry.
 *
 * <p> If the entry is read from a ZIP file or ZIP file formatted
 * input stream, this is the last modification time from the zip
 * file entry's {@code optional extra data} if the extended timestamp
 * fields are present. Otherwise the last modification time is read
 * from the entry's {@code date and time fields}, the {@link
 * java.util.TimeZone#getDefault() default TimeZone} is used to convert
 * the standard MS-DOS formatted date and time to the epoch time.
 *
 * @return The last modification time of the entry, null if not specified
 *
 * @see #setLastModifiedTime(FileTime)
 * @since 1.8
 * @apiSince 26
 */

public java.nio.file.attribute.FileTime getLastModifiedTime() { throw new RuntimeException("Stub!"); }

/**
 * Sets the last access time of the entry.
 *
 * <p> If set, the last access time will be stored into the extended
 * timestamp fields of entry's {@code optional extra data}, when output
 * to a ZIP file or ZIP file formatted stream.
 *
 * @param  time
 *         The last access time of the entry
 * @return This zip entry
 *
 * @throws java.lang.NullPointerException if the {@code time} is null
 *
 * @see #getLastAccessTime()
 * @since 1.8
 * @apiSince 26
 */

public java.util.zip.ZipEntry setLastAccessTime(java.nio.file.attribute.FileTime time) { throw new RuntimeException("Stub!"); }

/**
 * Returns the last access time of the entry.
 *
 * <p> The last access time is from the extended timestamp fields
 * of entry's {@code optional extra data} when read from a ZIP file
 * or ZIP file formatted stream.
 *
 * @return The last access time of the entry, null if not specified
 
 * @see #setLastAccessTime(FileTime)
 * @since 1.8
 * @apiSince 26
 */

public java.nio.file.attribute.FileTime getLastAccessTime() { throw new RuntimeException("Stub!"); }

/**
 * Sets the creation time of the entry.
 *
 * <p> If set, the creation time will be stored into the extended
 * timestamp fields of entry's {@code optional extra data}, when
 * output to a ZIP file or ZIP file formatted stream.
 *
 * @param  time
 *         The creation time of the entry
 * @return This zip entry
 *
 * @throws java.lang.NullPointerException if the {@code time} is null
 *
 * @see #getCreationTime()
 * @since 1.8
 * @apiSince 26
 */

public java.util.zip.ZipEntry setCreationTime(java.nio.file.attribute.FileTime time) { throw new RuntimeException("Stub!"); }

/**
 * Returns the creation time of the entry.
 *
 * <p> The creation time is from the extended timestamp fields of
 * entry's {@code optional extra data} when read from a ZIP file
 * or ZIP file formatted stream.
 *
 * @return the creation time of the entry, null if not specified
 * @see #setCreationTime(FileTime)
 * @since 1.8
 * @apiSince 26
 */

public java.nio.file.attribute.FileTime getCreationTime() { throw new RuntimeException("Stub!"); }

/**
 * Sets the uncompressed size of the entry data.
 *
 * @param size the uncompressed size in bytes
 *
 * @throws java.lang.IllegalArgumentException if the specified size is less
 *         than 0, is greater than 0xFFFFFFFF when
 *         <a href="package-summary.html#zip64">ZIP64 format</a> is not supported,
 *         or is less than 0 when ZIP64 is supported
 * @see #getSize()
 * @apiSince 1
 */

public void setSize(long size) { throw new RuntimeException("Stub!"); }

/**
 * Returns the uncompressed size of the entry data.
 *
 * @return the uncompressed size of the entry data, or -1 if not known
 * @see #setSize(long)
 * @apiSince 1
 */

public long getSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the compressed entry data.
 *
 * <p> In the case of a stored entry, the compressed size will be the same
 * as the uncompressed size of the entry.
 *
 * @return the size of the compressed entry data, or -1 if not known
 * @see #setCompressedSize(long)
 * @apiSince 1
 */

public long getCompressedSize() { throw new RuntimeException("Stub!"); }

/**
 * Sets the size of the compressed entry data.
 *
 * @param csize the compressed size to set to
 *
 * @see #getCompressedSize()
 * @apiSince 1
 */

public void setCompressedSize(long csize) { throw new RuntimeException("Stub!"); }

/**
 * Sets the CRC-32 checksum of the uncompressed entry data.
 *
 * @param crc the CRC-32 value
 *
 * @throws java.lang.IllegalArgumentException if the specified CRC-32 value is
 *         less than 0 or greater than 0xFFFFFFFF
 * @see #getCrc()
 * @apiSince 1
 */

public void setCrc(long crc) { throw new RuntimeException("Stub!"); }

/**
 * Returns the CRC-32 checksum of the uncompressed entry data.
 *
 * @return the CRC-32 checksum of the uncompressed entry data, or -1 if
 * not known
 *
 * @see #setCrc(long)
 * @apiSince 1
 */

public long getCrc() { throw new RuntimeException("Stub!"); }

/**
 * Sets the compression method for the entry.
 *
 * @param method the compression method, either STORED or DEFLATED
 *
 * @throws  java.lang.IllegalArgumentException if the specified compression
 *          method is invalid
 * @see #getMethod()
 * @apiSince 1
 */

public void setMethod(int method) { throw new RuntimeException("Stub!"); }

/**
 * Returns the compression method of the entry.
 *
 * @return the compression method of the entry, or -1 if not specified
 * @see #setMethod(int)
 * @apiSince 1
 */

public int getMethod() { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional extra field data for the entry.
 *
 * <p> Invoking this method may change this entry's last modification
 * time, last access time and creation time, if the {@code extra} field
 * data includes the extensible timestamp fields, such as {@code NTFS tag
 * 0x0001} or {@code Info-ZIP Extended Timestamp}, as specified in
 * <a href="http://www.info-zip.org/doc/appnote-19970311-iz.zip">Info-ZIP
 * Application Note 970311</a>.
 *
 * @param  extra
 *         The extra field data bytes
 *
 * @throws java.lang.IllegalArgumentException if the length of the specified
 *         extra field data is greater than 0xFFFF bytes
 *
 * @see #getExtra()
 * @apiSince 1
 */

public void setExtra(byte[] extra) { throw new RuntimeException("Stub!"); }

/**
 * Returns the extra field data for the entry.
 *
 * @return the extra field data for the entry, or null if none
 *
 * @see #setExtra(byte[])
 * @apiSince 1
 */

public byte[] getExtra() { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional comment string for the entry.
 *
 * <p>ZIP entry comments have maximum length of 0xffff. If the length of the
 * specified comment string is greater than 0xFFFF bytes after encoding, only
 * the first 0xFFFF bytes are output to the ZIP file entry.
 *
 * @param comment the comment string
 *
 * @see #getComment()
 * @apiSince 1
 */

public void setComment(java.lang.String comment) { throw new RuntimeException("Stub!"); }

/**
 * Returns the comment string for the entry.
 *
 * @return the comment string for the entry, or null if none
 *
 * @see #setComment(String)
 * @apiSince 1
 */

public java.lang.String getComment() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this is a directory entry. A directory entry is
 * defined to be one whose name ends with a '/'.
 * @return true if this is a directory entry
 * @apiSince 1
 */

public boolean isDirectory() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the ZIP entry.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this entry.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this entry.
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

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
 * Compression method for compressed (deflated) entries.
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
 * Compression method for uncompressed entries.
 * @apiSince 1
 */

public static final int STORED = 0; // 0x0
}

