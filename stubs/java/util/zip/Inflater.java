/*
 * Copyright (C) 2014 The Android Open Source Project
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



package java.util.zip;


/**
 * This class provides support for general purpose decompression using the
 * popular ZLIB compression library. The ZLIB compression library was
 * initially developed as part of the PNG graphics standard and is not
 * protected by patents. It is fully described in the specifications at
 * the <a href="package-summary.html#package_description">java.util.zip
 * package description</a>.
 *
 * <p>The following code fragment demonstrates a trivial compression
 * and decompression of a string using <tt>Deflater</tt> and
 * <tt>Inflater</tt>.
 *
 * <blockquote><pre>
 * try {
 *     // Encode a String into bytes
 *     String inputString = "blahblahblah\u20AC\u20AC";
 *     byte[] input = inputString.getBytes("UTF-8");
 *
 *     // Compress the bytes
 *     byte[] output = new byte[100];
 *     Deflater compresser = new Deflater();
 *     compresser.setInput(input);
 *     compresser.finish();
 *     int compressedDataLength = compresser.deflate(output);
 *
 *     // Decompress the bytes
 *     Inflater decompresser = new Inflater();
 *     decompresser.setInput(output, 0, compressedDataLength);
 *     byte[] result = new byte[100];
 *     int resultLength = decompresser.inflate(result);
 *     decompresser.end();
 *
 *     // Decode the bytes into a String
 *     String outputString = new String(result, 0, resultLength, "UTF-8");
 * } catch(java.io.UnsupportedEncodingException ex) {
 *     // handle
 * } catch (java.util.zip.DataFormatException ex) {
 *     // handle
 * }
 * </pre></blockquote>
 *
 * @see         java.util.zip.Deflater
 * @author      David Connelly
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Inflater {

/**
 * Creates a new decompressor. If the parameter 'nowrap' is true then
 * the ZLIB header and checksum fields will not be used. This provides
 * compatibility with the compression format used by both GZIP and PKZIP.
 * <p>
 * Note: When using the 'nowrap' option it is also necessary to provide
 * an extra "dummy" byte as input. This is required by the ZLIB native
 * library in order to support certain optimizations.
 *
 * @param nowrap if true then support GZIP compatible compression
 * @apiSince 1
 */

public Inflater(boolean nowrap) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new decompressor.
 * @apiSince 1
 */

public Inflater() { throw new RuntimeException("Stub!"); }

/**
 * Sets input data for decompression. Should be called whenever
 * needsInput() returns true indicating that more input data is
 * required.
 * @param b the input data bytes
 * @param off the start offset of the input data
 * @param len the length of the input data
 * @see java.util.zip.Inflater#needsInput
 * @apiSince 1
 */

public void setInput(byte[] b, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Sets input data for decompression. Should be called whenever
 * needsInput() returns true indicating that more input data is
 * required.
 * @param b the input data bytes
 * @see java.util.zip.Inflater#needsInput
 * @apiSince 1
 */

public void setInput(byte[] b) { throw new RuntimeException("Stub!"); }

/**
 * Sets the preset dictionary to the given array of bytes. Should be
 * called when inflate() returns 0 and needsDictionary() returns true
 * indicating that a preset dictionary is required. The method getAdler()
 * can be used to get the Adler-32 value of the dictionary needed.
 * @param b the dictionary data bytes
 * @param off the start offset of the data
 * @param len the length of the data
 * @see java.util.zip.Inflater#needsDictionary
 * @see java.util.zip.Inflater#getAdler
 * @apiSince 1
 */

public void setDictionary(byte[] b, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Sets the preset dictionary to the given array of bytes. Should be
 * called when inflate() returns 0 and needsDictionary() returns true
 * indicating that a preset dictionary is required. The method getAdler()
 * can be used to get the Adler-32 value of the dictionary needed.
 * @param b the dictionary data bytes
 * @see java.util.zip.Inflater#needsDictionary
 * @see java.util.zip.Inflater#getAdler
 * @apiSince 1
 */

public void setDictionary(byte[] b) { throw new RuntimeException("Stub!"); }

/**
 * Returns the total number of bytes remaining in the input buffer.
 * This can be used to find out what bytes still remain in the input
 * buffer after decompression has finished.
 * @return the total number of bytes remaining in the input buffer
 * @apiSince 1
 */

public int getRemaining() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if no data remains in the input buffer. This can
 * be used to determine if #setInput should be called in order
 * to provide more input.
 * @return true if no data remains in the input buffer
 * @apiSince 1
 */

public boolean needsInput() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if a preset dictionary is needed for decompression.
 * @return true if a preset dictionary is needed for decompression
 * @see Inflater#setDictionary
 * @apiSince 1
 */

public boolean needsDictionary() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the end of the compressed data stream has been
 * reached.
 * @return true if the end of the compressed data stream has been
 * reached
 * @apiSince 1
 */

public boolean finished() { throw new RuntimeException("Stub!"); }

/**
 * Uncompresses bytes into specified buffer. Returns actual number
 * of bytes uncompressed. A return value of 0 indicates that
 * needsInput() or needsDictionary() should be called in order to
 * determine if more input data or a preset dictionary is required.
 * In the latter case, getAdler() can be used to get the Adler-32
 * value of the dictionary required.
 * @param b the buffer for the uncompressed data
 * @param off the start offset of the data
 * @param len the maximum number of uncompressed bytes
 * @return the actual number of uncompressed bytes
 * @exception java.util.zip.DataFormatException if the compressed data format is invalid
 * @see java.util.zip.Inflater#needsInput
 * @see java.util.zip.Inflater#needsDictionary
 * @apiSince 1
 */

public int inflate(byte[] b, int off, int len) throws java.util.zip.DataFormatException { throw new RuntimeException("Stub!"); }

/**
 * Uncompresses bytes into specified buffer. Returns actual number
 * of bytes uncompressed. A return value of 0 indicates that
 * needsInput() or needsDictionary() should be called in order to
 * determine if more input data or a preset dictionary is required.
 * In the latter case, getAdler() can be used to get the Adler-32
 * value of the dictionary required.
 * @param b the buffer for the uncompressed data
 * @return the actual number of uncompressed bytes
 * @exception java.util.zip.DataFormatException if the compressed data format is invalid
 * @see java.util.zip.Inflater#needsInput
 * @see java.util.zip.Inflater#needsDictionary
 * @apiSince 1
 */

public int inflate(byte[] b) throws java.util.zip.DataFormatException { throw new RuntimeException("Stub!"); }

/**
 * Returns the ADLER-32 value of the uncompressed data.
 * @return the ADLER-32 value of the uncompressed data
 * @apiSince 1
 */

public int getAdler() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total number of compressed bytes input so far.
 *
 * <p>Since the number of bytes may be greater than
 * Integer.MAX_VALUE, the {@link #getBytesRead()} method is now
 * the preferred means of obtaining this information.</p>
 *
 * @return the total number of compressed bytes input so far
 * @apiSince 1
 */

public int getTotalIn() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total number of compressed bytes input so far.
 *
 * @return the total (non-negative) number of compressed bytes input so far
 * @since 1.5
 * @apiSince 1
 */

public long getBytesRead() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total number of uncompressed bytes output so far.
 *
 * <p>Since the number of bytes may be greater than
 * Integer.MAX_VALUE, the {@link #getBytesWritten()} method is now
 * the preferred means of obtaining this information.</p>
 *
 * @return the total number of uncompressed bytes output so far
 * @apiSince 1
 */

public int getTotalOut() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total number of uncompressed bytes output so far.
 *
 * @return the total (non-negative) number of uncompressed bytes output so far
 * @since 1.5
 * @apiSince 1
 */

public long getBytesWritten() { throw new RuntimeException("Stub!"); }

/**
 * Resets inflater so that a new set of input data can be processed.
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Closes the decompressor and discards any unprocessed input.
 * This method should be called when the decompressor is no longer
 * being used, but will also be called automatically by the finalize()
 * method. Once this method is called, the behavior of the Inflater
 * object is undefined.
 * @apiSince 1
 */

public void end() { throw new RuntimeException("Stub!"); }

/**
 * Closes the decompressor when garbage is collected.
 * @apiSince 1
 */

protected void finalize() { throw new RuntimeException("Stub!"); }
}

