/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.media;

import android.media.MediaCasException.UnsupportedCasException;
import java.nio.ByteBuffer;

/**
 * MediaDescrambler class can be used in conjunction with {@link android.media.MediaCodec}
 * and {@link android.media.MediaExtractor} to decode media data scrambled by conditional
 * access (CA) systems such as those in the ISO/IEC13818-1.
 *
 * A MediaDescrambler object is initialized from a session opened by a MediaCas object,
 * and can be used to descramble media streams scrambled with that session's keys.
 *
 * Scrambling schemes are identified by 16-bit unsigned integer as in CA_system_id.
 *
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaDescrambler implements java.lang.AutoCloseable {

/**
 * Instantiate a MediaDescrambler.
 *
 * @param CA_system_id The system id of the scrambling scheme.
 *
 * @throws android.media.MediaCasException.UnsupportedCasException if the scrambling scheme is not supported.
 * @apiSince 26
 */

public MediaDescrambler(int CA_system_id) throws android.media.MediaCasException.UnsupportedCasException { throw new RuntimeException("Stub!"); }

/**
 * Query if the scrambling scheme requires the use of a secure decoder
 * to decode data of the given mime type.
 *
 * @param mime The mime type of the media data
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the descrambler instance is not valid.
 * @apiSince 26
 */

public boolean requiresSecureDecoderComponent(@androidx.annotation.NonNull java.lang.String mime) { throw new RuntimeException("Stub!"); }

/**
 * Associate a MediaCas session with this MediaDescrambler instance.
 * The MediaCas session is used to securely load decryption keys for
 * the descrambler. The crypto keys loaded through the MediaCas session
 * may be selected for use during the descrambling operation performed
 * by {@link android.media.MediaExtractor or @link
 * android.media.MediaCodec#queueSecureInputBuffer} by specifying even
 * or odd key in the {@link android.media.MediaCodec.CryptoInfo#key} field.
 *
 * @param session the MediaCas session to associate with this
 * MediaDescrambler instance.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the descrambler instance is not valid.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public void setMediaCasSession(@androidx.annotation.NonNull android.media.MediaCas.Session session) { throw new RuntimeException("Stub!"); }

/**
 * Descramble a ByteBuffer of data described by a
 * {@link android.media.MediaCodec.CryptoInfo} structure.
 *
 * @param srcBuf ByteBuffer containing the scrambled data, which starts at
 * srcBuf.position().
 * This value must never be {@code null}.
 * @param dstBuf ByteBuffer to hold the descrambled data, which starts at
 * dstBuf.position().
 * This value must never be {@code null}.
 * @param cryptoInfo a {@link android.media.MediaCodec.CryptoInfo} structure
 * describing the subsamples contained in srcBuf. The iv and mode fields in
 * CryptoInfo are not used. key[0] contains the MPEG2TS scrambling control bits
 * (as defined in ETSI TS 100 289 (2011): "Digital Video Broadcasting (DVB);
 * Support for use of the DVB Scrambling Algorithm version 3 within digital
 * broadcasting systems"), and the value must be one of {@link #SCRAMBLE_CONTROL_UNSCRAMBLED},
 * {@link #SCRAMBLE_CONTROL_RESERVED}, {@link #SCRAMBLE_CONTROL_EVEN_KEY} or
 * {@link #SCRAMBLE_CONTROL_ODD_KEY}. key[1] is a set of bit flags, with the
 * only possible bit being {@link #SCRAMBLE_FLAG_PES_HEADER} currently.
 * key[2~15] are not used.
 *
 * This value must never be {@code null}.
 * @return number of bytes that have been successfully descrambled, with negative
 * values indicating errors.
 *
 * @throws java.lang.IllegalStateException if the descrambler instance is not valid.
 * @throws android.media.MediaCasStateException for CAS-specific state exceptions.
 * @apiSince 26
 */

public int descramble(@androidx.annotation.NonNull java.nio.ByteBuffer srcBuf, @androidx.annotation.NonNull java.nio.ByteBuffer dstBuf, @androidx.annotation.NonNull android.media.MediaCodec.CryptoInfo cryptoInfo) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Scramble control value indicating that the even key is used.
 * @see #descramble(ByteBuffer, ByteBuffer, android.media.MediaCodec.CryptoInfo)
 * @apiSince 28
 */

public static final byte SCRAMBLE_CONTROL_EVEN_KEY = 2; // 0x2

/**
 * Scramble control value indicating that the odd key is used.
 * @see #descramble(ByteBuffer, ByteBuffer, android.media.MediaCodec.CryptoInfo)
 * @apiSince 28
 */

public static final byte SCRAMBLE_CONTROL_ODD_KEY = 3; // 0x3

/**
 * Scramble control value reserved and shouldn't be used currently.
 * @see #descramble(ByteBuffer, ByteBuffer, android.media.MediaCodec.CryptoInfo)
 * @apiSince 28
 */

public static final byte SCRAMBLE_CONTROL_RESERVED = 1; // 0x1

/**
 * Scramble control value indicating that the samples are not scrambled.
 * @see #descramble(ByteBuffer, ByteBuffer, android.media.MediaCodec.CryptoInfo)
 * @apiSince 28
 */

public static final byte SCRAMBLE_CONTROL_UNSCRAMBLED = 0; // 0x0

/**
 * Scramble flag for a hint indicating that the descrambling request is for
 * retrieving the PES header info only.
 *
 * @see #descramble(ByteBuffer, ByteBuffer, android.media.MediaCodec.CryptoInfo)
 * @apiSince 28
 */

public static final byte SCRAMBLE_FLAG_PES_HEADER = 1; // 0x1
}

