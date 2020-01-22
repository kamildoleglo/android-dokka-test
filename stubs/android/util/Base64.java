/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.util;


/**
 * Utilities for encoding and decoding the Base64 representation of
 * binary data.  See RFCs <a
 * href="http://www.ietf.org/rfc/rfc2045.txt">2045</a> and <a
 * href="http://www.ietf.org/rfc/rfc3548.txt">3548</a>.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Base64 {

private Base64() { throw new RuntimeException("Stub!"); }

/**
 * Decode the Base64-encoded data in input and return the data in
 * a new byte array.
 *
 * <p>The padding '=' characters at the end are considered optional, but
 * if any are present, there must be the correct number of them.
 *
 * @param str    the input String to decode, which is converted to
 *               bytes using the default charset
 * @param flags  controls certain features of the decoded output.
 *               Pass {@code DEFAULT} to decode standard Base64.
 *
 * @throws java.lang.IllegalArgumentException if the input contains
 * incorrect padding
 * @apiSince 8
 */

public static byte[] decode(java.lang.String str, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Decode the Base64-encoded data in input and return the data in
 * a new byte array.
 *
 * <p>The padding '=' characters at the end are considered optional, but
 * if any are present, there must be the correct number of them.
 *
 * @param input the input array to decode
 * @param flags  controls certain features of the decoded output.
 *               Pass {@code DEFAULT} to decode standard Base64.
 *
 * @throws java.lang.IllegalArgumentException if the input contains
 * incorrect padding
 * @apiSince 8
 */

public static byte[] decode(byte[] input, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Decode the Base64-encoded data in input and return the data in
 * a new byte array.
 *
 * <p>The padding '=' characters at the end are considered optional, but
 * if any are present, there must be the correct number of them.
 *
 * @param input  the data to decode
 * @param offset the position within the input array at which to start
 * @param len    the number of bytes of input to decode
 * @param flags  controls certain features of the decoded output.
 *               Pass {@code DEFAULT} to decode standard Base64.
 *
 * @throws java.lang.IllegalArgumentException if the input contains
 * incorrect padding
 * @apiSince 8
 */

public static byte[] decode(byte[] input, int offset, int len, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Base64-encode the given data and return a newly allocated
 * String with the result.
 *
 * @param input  the data to encode
 * @param flags  controls certain features of the encoded output.
 *               Passing {@code DEFAULT} results in output that
 *               adheres to RFC 2045.
 * @apiSince 8
 */

public static java.lang.String encodeToString(byte[] input, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Base64-encode the given data and return a newly allocated
 * String with the result.
 *
 * @param input  the data to encode
 * @param offset the position within the input array at which to
 *               start
 * @param len    the number of bytes of input to encode
 * @param flags  controls certain features of the encoded output.
 *               Passing {@code DEFAULT} results in output that
 *               adheres to RFC 2045.
 * @apiSince 8
 */

public static java.lang.String encodeToString(byte[] input, int offset, int len, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Base64-encode the given data and return a newly allocated
 * byte[] with the result.
 *
 * @param input  the data to encode
 * @param flags  controls certain features of the encoded output.
 *               Passing {@code DEFAULT} results in output that
 *               adheres to RFC 2045.
 * @apiSince 8
 */

public static byte[] encode(byte[] input, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Base64-encode the given data and return a newly allocated
 * byte[] with the result.
 *
 * @param input  the data to encode
 * @param offset the position within the input array at which to
 *               start
 * @param len    the number of bytes of input to encode
 * @param flags  controls certain features of the encoded output.
 *               Passing {@code DEFAULT} results in output that
 *               adheres to RFC 2045.
 * @apiSince 8
 */

public static byte[] encode(byte[] input, int offset, int len, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Encoder flag bit to indicate lines should be terminated with a
 * CRLF pair instead of just an LF.  Has no effect if {@code
 * NO_WRAP} is specified as well.
 * @apiSince 8
 */

public static final int CRLF = 4; // 0x4

/**
 * Default values for encoder/decoder flags.
 * @apiSince 8
 */

public static final int DEFAULT = 0; // 0x0

/**
 * Flag to pass to {@link android.util.Base64OutputStream Base64OutputStream} to indicate that it
 * should not close the output stream it is wrapping when it
 * itself is closed.
 * @apiSince 8
 */

public static final int NO_CLOSE = 16; // 0x10

/**
 * Encoder flag bit to omit the padding '=' characters at the end
 * of the output (if any).
 * @apiSince 8
 */

public static final int NO_PADDING = 1; // 0x1

/**
 * Encoder flag bit to omit all line terminators (i.e., the output
 * will be on one long line).
 * @apiSince 8
 */

public static final int NO_WRAP = 2; // 0x2

/**
 * Encoder/decoder flag bit to indicate using the "URL and
 * filename safe" variant of Base64 (see RFC 3548 section 4) where
 * {@code -} and {@code _} are used in place of {@code +} and
 * {@code /}.
 * @apiSince 8
 */

public static final int URL_SAFE = 8; // 0x8
}

