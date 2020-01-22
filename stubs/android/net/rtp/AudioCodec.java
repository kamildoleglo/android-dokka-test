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


package android.net.rtp;


/**
 * This class defines a collection of audio codecs to be used with
 * {@link android.net.rtp.AudioStream AudioStream}s. Their parameters are designed to be exchanged using
 * Session Description Protocol (SDP). Most of the values listed here can be
 * found in RFC 3551, while others are described in separated standards.
 *
 * <p>Few simple configurations are defined as public static instances for the
 * convenience of direct uses. More complicated ones could be obtained using
 * {@link #getCodec(int,java.lang.String,java.lang.String)}. For example, one can use the
 * following snippet to create a mode-1-only AMR codec.</p>
 * <pre>
 * AudioCodec codec = AudioCodec.getCodec(100, "AMR/8000", "mode-set=1");
 * </pre>
 *
 * @see android.net.rtp.AudioStream
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioCodec {

private AudioCodec() { throw new RuntimeException("Stub!"); }

/**
 * Returns system supported audio codecs.
 * @apiSince 12
 */

public static android.net.rtp.AudioCodec[] getCodecs() { throw new RuntimeException("Stub!"); }

/**
 * Creates an AudioCodec according to the given configuration.
 *
 * @param type The payload type of the encoding defined in RTP/AVP.
 * @param rtpmap The encoding parameters specified in the corresponding SDP
 *     attribute, or null if it is not available.
 * @param fmtp The format parameters specified in the corresponding SDP
 *     attribute, or null if it is not available.
 * @return The configured AudioCodec or {@code null} if it is not supported.
 * @apiSince 12
 */

public static android.net.rtp.AudioCodec getCodec(int type, java.lang.String rtpmap, java.lang.String fmtp) { throw new RuntimeException("Stub!"); }

/**
 * Adaptive Multi-Rate narrowband audio codec, also known as AMR or AMR-NB.
 * Currently CRC, robust sorting, and interleaving are not supported. See
 * more details about these features in RFC 4867.
 * @apiSince 12
 */

public static final android.net.rtp.AudioCodec AMR;
static { AMR = null; }

/**
 * GSM Full-Rate audio codec, also known as GSM-FR, GSM 06.10, GSM, or
 * simply FR.
 * @apiSince 12
 */

public static final android.net.rtp.AudioCodec GSM;
static { GSM = null; }

/**
 * GSM Enhanced Full-Rate audio codec, also known as GSM-EFR, GSM 06.60, or
 * simply EFR.
 * @apiSince 12
 */

public static final android.net.rtp.AudioCodec GSM_EFR;
static { GSM_EFR = null; }

/**
 * G.711 a-law audio codec.
 * @apiSince 12
 */

public static final android.net.rtp.AudioCodec PCMA;
static { PCMA = null; }

/**
 * G.711 u-law audio codec.
 * @apiSince 12
 */

public static final android.net.rtp.AudioCodec PCMU;
static { PCMU = null; }

/**
 * The format parameters to be used in the corresponding SDP attribute.
 * @apiSince 12
 */

public final java.lang.String fmtp;
{ fmtp = null; }

/**
 * The encoding parameters to be used in the corresponding SDP attribute.
 * @apiSince 12
 */

public final java.lang.String rtpmap;
{ rtpmap = null; }

/**
 * The RTP payload type of the encoding.
 * @apiSince 12
 */

public final int type;
{ type = 0; }
}

