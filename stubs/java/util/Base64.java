/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.ByteBuffer;
import java.io.InputStream;

/**
 * This class consists exclusively of static methods for obtaining
 * encoders and decoders for the Base64 encoding scheme. The
 * implementation of this class supports the following types of Base64
 * as specified in
 * <a href="http://www.ietf.org/rfc/rfc4648.txt">RFC 4648</a> and
 * <a href="http://www.ietf.org/rfc/rfc2045.txt">RFC 2045</a>.
 *
 * <ul>
 * <li><a name="basic"><b>Basic</b></a>
 * <p> Uses "The Base64 Alphabet" as specified in Table 1 of
 *     RFC 4648 and RFC 2045 for encoding and decoding operation.
 *     The encoder does not add any line feed (line separator)
 *     character. The decoder rejects data that contains characters
 *     outside the base64 alphabet.</p></li>
 *
 * <li><a name="url"><b>URL and Filename safe</b></a>
 * <p> Uses the "URL and Filename safe Base64 Alphabet" as specified
 *     in Table 2 of RFC 4648 for encoding and decoding. The
 *     encoder does not add any line feed (line separator) character.
 *     The decoder rejects data that contains characters outside the
 *     base64 alphabet.</p></li>
 *
 * <li><a name="mime"><b>MIME</b></a>
 * <p> Uses the "The Base64 Alphabet" as specified in Table 1 of
 *     RFC 2045 for encoding and decoding operation. The encoded output
 *     must be represented in lines of no more than 76 characters each
 *     and uses a carriage return {@code '\r'} followed immediately by
 *     a linefeed {@code '\n'} as the line separator. No line separator
 *     is added to the end of the encoded output. All line separators
 *     or other characters not found in the base64 alphabet table are
 *     ignored in decoding operation.</p></li>
 * </ul>
 *
 * <p> Unless otherwise noted, passing a {@code null} argument to a
 * method of this class will cause a {@link java.lang.NullPointerException
 * NullPointerException} to be thrown.
 *
 * @author  Xueming Shen
 * @since   1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Base64 {

private Base64() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Base64.Encoder Encoder} that encodes using the
 * <a href="#basic">Basic</a> type base64 encoding scheme.
 *
 * @return  A Base64 encoder.
 * @apiSince 26
 */

public static java.util.Base64.Encoder getEncoder() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Base64.Encoder Encoder} that encodes using the
 * <a href="#url">URL and Filename safe</a> type base64
 * encoding scheme.
 *
 * @return  A Base64 encoder.
 * @apiSince 26
 */

public static java.util.Base64.Encoder getUrlEncoder() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Base64.Encoder Encoder} that encodes using the
 * <a href="#mime">MIME</a> type base64 encoding scheme.
 *
 * @return  A Base64 encoder.
 * @apiSince 26
 */

public static java.util.Base64.Encoder getMimeEncoder() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Base64.Encoder Encoder} that encodes using the
 * <a href="#mime">MIME</a> type base64 encoding scheme
 * with specified line length and line separators.
 *
 * @param   lineLength
 *          the length of each output line (rounded down to nearest multiple
 *          of 4). If {@code lineLength <= 0} the output will not be separated
 *          in lines
 * @param   lineSeparator
 *          the line separator for each output line
 *
 * @return  A Base64 encoder.
 *
 * @throws  java.lang.IllegalArgumentException if {@code lineSeparator} includes any
 *          character of "The Base64 Alphabet" as specified in Table 1 of
 *          RFC 2045.
 * @apiSince 26
 */

public static java.util.Base64.Encoder getMimeEncoder(int lineLength, byte[] lineSeparator) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Base64.Decoder Decoder} that decodes using the
 * <a href="#basic">Basic</a> type base64 encoding scheme.
 *
 * @return  A Base64 decoder.
 * @apiSince 26
 */

public static java.util.Base64.Decoder getDecoder() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Base64.Decoder Decoder} that decodes using the
 * <a href="#url">URL and Filename safe</a> type base64
 * encoding scheme.
 *
 * @return  A Base64 decoder.
 * @apiSince 26
 */

public static java.util.Base64.Decoder getUrlDecoder() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Base64.Decoder Decoder} that decodes using the
 * <a href="#mime">MIME</a> type base64 decoding scheme.
 *
 * @return  A Base64 decoder.
 * @apiSince 26
 */

public static java.util.Base64.Decoder getMimeDecoder() { throw new RuntimeException("Stub!"); }
/**
 * This class implements a decoder for decoding byte data using the
 * Base64 encoding scheme as specified in RFC 4648 and RFC 2045.
 *
 * <p> The Base64 padding character {@code '='} is accepted and
 * interpreted as the end of the encoded byte data, but is not
 * required. So if the final unit of the encoded byte data only has
 * two or three Base64 characters (without the corresponding padding
 * character(s) padded), they are decoded as if followed by padding
 * character(s). If there is a padding character present in the
 * final unit, the correct number of padding character(s) must be
 * present, otherwise {@code IllegalArgumentException} (
 * {@code IOException} when reading from a Base64 stream) is thrown
 * during decoding.
 *
 * <p> Instances of {@link java.util.Base64.Decoder Decoder} class are safe for use by
 * multiple concurrent threads.
 *
 * <p> Unless otherwise noted, passing a {@code null} argument to
 * a method of this class will cause a
 * {@link java.lang.NullPointerException NullPointerException} to
 * be thrown.
 *
 * @see     java.util.Base64.Encoder
 * @since   1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Decoder {

private Decoder() { throw new RuntimeException("Stub!"); }

/**
 * Decodes all bytes from the input byte array using the {@link java.util.Base64 Base64}
 * encoding scheme, writing the results into a newly-allocated output
 * byte array. The returned byte array is of the length of the resulting
 * bytes.
 *
 * @param   src
 *          the byte array to decode
 *
 * @return  A newly-allocated byte array containing the decoded bytes.
 *
 * @throws  java.lang.IllegalArgumentException
 *          if {@code src} is not in valid Base64 scheme
 * @apiSince 26
 */

public byte[] decode(byte[] src) { throw new RuntimeException("Stub!"); }

/**
 * Decodes a Base64 encoded String into a newly-allocated byte array
 * using the {@link java.util.Base64 Base64} encoding scheme.
 *
 * <p> An invocation of this method has exactly the same effect as invoking
 * {@code decode(src.getBytes(StandardCharsets.ISO_8859_1))}
 *
 * @param   src
 *          the string to decode
 *
 * @return  A newly-allocated byte array containing the decoded bytes.
 *
 * @throws  java.lang.IllegalArgumentException
 *          if {@code src} is not in valid Base64 scheme
 * @apiSince 26
 */

public byte[] decode(java.lang.String src) { throw new RuntimeException("Stub!"); }

/**
 * Decodes all bytes from the input byte array using the {@link java.util.Base64 Base64}
 * encoding scheme, writing the results into the given output byte array,
 * starting at offset 0.
 *
 * <p> It is the responsibility of the invoker of this method to make
 * sure the output byte array {@code dst} has enough space for decoding
 * all bytes from the input byte array. No bytes will be be written to
 * the output byte array if the output byte array is not big enough.
 *
 * <p> If the input byte array is not in valid Base64 encoding scheme
 * then some bytes may have been written to the output byte array before
 * IllegalargumentException is thrown.
 *
 * @param   src
 *          the byte array to decode
 * @param   dst
 *          the output byte array
 *
 * @return  The number of bytes written to the output byte array
 *
 * @throws  java.lang.IllegalArgumentException
 *          if {@code src} is not in valid Base64 scheme, or {@code dst}
 *          does not have enough space for decoding all input bytes.
 * @apiSince 26
 */

public int decode(byte[] src, byte[] dst) { throw new RuntimeException("Stub!"); }

/**
 * Decodes all bytes from the input byte buffer using the {@link java.util.Base64 Base64}
 * encoding scheme, writing the results into a newly-allocated ByteBuffer.
 *
 * <p> Upon return, the source buffer's position will be updated to
 * its limit; its limit will not have been changed. The returned
 * output buffer's position will be zero and its limit will be the
 * number of resulting decoded bytes
 *
 * <p> {@code IllegalArgumentException} is thrown if the input buffer
 * is not in valid Base64 encoding scheme. The position of the input
 * buffer will not be advanced in this case.
 *
 * @param   buffer
 *          the ByteBuffer to decode
 *
 * @return  A newly-allocated byte buffer containing the decoded bytes
 *
 * @throws  java.lang.IllegalArgumentException
 *          if {@code src} is not in valid Base64 scheme.
 * @apiSince 26
 */

public java.nio.ByteBuffer decode(java.nio.ByteBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Returns an input stream for decoding {@link java.util.Base64 Base64} encoded byte stream.
 *
 * <p> The {@code read}  methods of the returned {@code InputStream} will
 * throw {@code IOException} when reading bytes that cannot be decoded.
 *
 * <p> Closing the returned input stream will close the underlying
 * input stream.
 *
 * @param   is
 *          the input stream
 *
 * @return  the input stream for decoding the specified Base64 encoded
 *          byte stream
 * @apiSince 26
 */

public java.io.InputStream wrap(java.io.InputStream is) { throw new RuntimeException("Stub!"); }
}

/**
 * This class implements an encoder for encoding byte data using
 * the Base64 encoding scheme as specified in RFC 4648 and RFC 2045.
 *
 * <p> Instances of {@link java.util.Base64.Encoder Encoder} class are safe for use by
 * multiple concurrent threads.
 *
 * <p> Unless otherwise noted, passing a {@code null} argument to
 * a method of this class will cause a
 * {@link java.lang.NullPointerException NullPointerException} to
 * be thrown.
 *
 * @see     java.util.Base64.Decoder
 * @since   1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Encoder {

private Encoder() { throw new RuntimeException("Stub!"); }

/**
 * Encodes all bytes from the specified byte array into a newly-allocated
 * byte array using the {@link java.util.Base64 Base64} encoding scheme. The returned byte
 * array is of the length of the resulting bytes.
 *
 * @param   src
 *          the byte array to encode
 * @return  A newly-allocated byte array containing the resulting
 *          encoded bytes.
 * @apiSince 26
 */

public byte[] encode(byte[] src) { throw new RuntimeException("Stub!"); }

/**
 * Encodes all bytes from the specified byte array using the
 * {@link java.util.Base64 Base64} encoding scheme, writing the resulting bytes to the
 * given output byte array, starting at offset 0.
 *
 * <p> It is the responsibility of the invoker of this method to make
 * sure the output byte array {@code dst} has enough space for encoding
 * all bytes from the input byte array. No bytes will be written to the
 * output byte array if the output byte array is not big enough.
 *
 * @param   src
 *          the byte array to encode
 * @param   dst
 *          the output byte array
 * @return  The number of bytes written to the output byte array
 *
 * @throws  java.lang.IllegalArgumentException if {@code dst} does not have enough
 *          space for encoding all input bytes.
 * @apiSince 26
 */

public int encode(byte[] src, byte[] dst) { throw new RuntimeException("Stub!"); }

/**
 * Encodes the specified byte array into a String using the {@link java.util.Base64 Base64}
 * encoding scheme.
 *
 * <p> This method first encodes all input bytes into a base64 encoded
 * byte array and then constructs a new String by using the encoded byte
 * array and the {@link java.nio.charset.StandardCharsets#ISO_8859_1
 * ISO-8859-1} charset.
 *
 * <p> In other words, an invocation of this method has exactly the same
 * effect as invoking
 * {@code new String(encode(src), StandardCharsets.ISO_8859_1)}.
 *
 * @param   src
 *          the byte array to encode
 * @return  A String containing the resulting Base64 encoded characters
 * @apiSince 26
 */

public java.lang.String encodeToString(byte[] src) { throw new RuntimeException("Stub!"); }

/**
 * Encodes all remaining bytes from the specified byte buffer into
 * a newly-allocated ByteBuffer using the {@link java.util.Base64 Base64} encoding
 * scheme.
 *
 * Upon return, the source buffer's position will be updated to
 * its limit; its limit will not have been changed. The returned
 * output buffer's position will be zero and its limit will be the
 * number of resulting encoded bytes.
 *
 * @param   buffer
 *          the source ByteBuffer to encode
 * @return  A newly-allocated byte buffer containing the encoded bytes.
 * @apiSince 26
 */

public java.nio.ByteBuffer encode(java.nio.ByteBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Wraps an output stream for encoding byte data using the {@link java.util.Base64 Base64}
 * encoding scheme.
 *
 * <p> It is recommended to promptly close the returned output stream after
 * use, during which it will flush all possible leftover bytes to the underlying
 * output stream. Closing the returned output stream will close the underlying
 * output stream.
 *
 * @param   os
 *          the output stream.
 * @return  the output stream for encoding the byte data into the
 *          specified Base64 encoded format
 * @apiSince 26
 */

public java.io.OutputStream wrap(java.io.OutputStream os) { throw new RuntimeException("Stub!"); }

/**
 * Returns an encoder instance that encodes equivalently to this one,
 * but without adding any padding character at the end of the encoded
 * byte data.
 *
 * <p> The encoding scheme of this encoder instance is unaffected by
 * this invocation. The returned encoder instance should be used for
 * non-padding encoding operation.
 *
 * @return an equivalent encoder that encodes without adding any
 *         padding character at the end
 * @apiSince 26
 */

public java.util.Base64.Encoder withoutPadding() { throw new RuntimeException("Stub!"); }
}

}

