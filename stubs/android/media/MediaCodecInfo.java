/*
 * Copyright (C) 2012 The Android Open Source Project
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

import android.os.Build;

/**
 * Provides information about a given media codec available on the device. You can
 * iterate through all codecs available by querying {@link android.media.MediaCodecList MediaCodecList}. For example,
 * here's how to find an encoder that supports a given MIME type:
 * <pre>
 * private static MediaCodecInfo selectCodec(String mimeType) {
 *     int numCodecs = MediaCodecList.getCodecCount();
 *     for (int i = 0; i &lt; numCodecs; i++) {
 *         MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
 *
 *         if (!codecInfo.isEncoder()) {
 *             continue;
 *         }
 *
 *         String[] types = codecInfo.getSupportedTypes();
 *         for (int j = 0; j &lt; types.length; j++) {
 *             if (types[j].equalsIgnoreCase(mimeType)) {
 *                 return codecInfo;
 *             }
 *         }
 *     }
 *     return null;
 * }</pre>
 *
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaCodecInfo {

MediaCodecInfo() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the codec name.
 *
 * <strong>Note:</strong> Implementations may provide multiple aliases (codec
 * names) for the same underlying codec, any of which can be used to instantiate the same
 * underlying codec in {@link android.media.MediaCodec#createByCodecName MediaCodec#createByCodecName}.
 *
 * Applications targeting SDK < {@link android.os.Build.VERSION_CODES#Q}, cannot determine if
 * the multiple codec names listed in MediaCodecList are in-fact for the same codec.
 
 * @return This value will never be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the underlying codec name.
 *
 * Device implementations may provide multiple aliases (codec names) for the same underlying
 * codec to maintain backward app compatibility. This method returns the name of the underlying
 * codec name, which must not be another alias. For non-aliases this is always the name of the
 * codec.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getCanonicalName() { throw new RuntimeException("Stub!"); }

/**
 * Query if the codec is an alias for another underlying codec.
 * @apiSince 29
 */

public boolean isAlias() { throw new RuntimeException("Stub!"); }

/**
 * Query if the codec is an encoder.
 * @apiSince 16
 */

public boolean isEncoder() { throw new RuntimeException("Stub!"); }

/**
 * Query if the codec is provided by the Android platform (false) or the device manufacturer
 * (true).
 * @apiSince 29
 */

public boolean isVendor() { throw new RuntimeException("Stub!"); }

/**
 * Query if the codec is software only. Software-only codecs are more secure as they run in
 * a tighter security sandbox. On the other hand, software-only codecs do not provide any
 * performance guarantees.
 * @apiSince 29
 */

public boolean isSoftwareOnly() { throw new RuntimeException("Stub!"); }

/**
 * Query if the codec is hardware accelerated. This attribute is provided by the device
 * manufacturer. Note that it cannot be tested for correctness.
 * @apiSince 29
 */

public boolean isHardwareAccelerated() { throw new RuntimeException("Stub!"); }

/**
 * Query the media types supported by the codec.
 * @apiSince 16
 */

public java.lang.String[] getSupportedTypes() { throw new RuntimeException("Stub!"); }

/**
 * Enumerates the capabilities of the codec component. Since a single
 * component can support data of a variety of types, the type has to be
 * specified to yield a meaningful result.
 * @param type The MIME type to query
 * @apiSince 16
 */

public android.media.MediaCodecInfo.CodecCapabilities getCapabilitiesForType(java.lang.String type) { throw new RuntimeException("Stub!"); }
/**
 * A class that supports querying the audio capabilities of a codec.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AudioCapabilities {

private AudioCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported bitrates in bits/second.
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getBitrateRange() { throw new RuntimeException("Stub!"); }

/**
 * Returns the array of supported sample rates if the codec
 * supports only discrete values.  Otherwise, it returns
 * {@code null}.  The array is sorted in ascending order.
 * @apiSince 21
 */

public int[] getSupportedSampleRates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the array of supported sample rate ranges.  The
 * array is sorted in ascending order, and the ranges are
 * distinct.
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer>[] getSupportedSampleRateRanges() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of input channels supported.  The codec
 * supports any number of channels between 1 and this maximum value.
 * @apiSince 21
 */

public int getMaxInputChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Query whether the sample rate is supported by the codec.
 * @apiSince 21
 */

public boolean isSampleRateSupported(int sampleRate) { throw new RuntimeException("Stub!"); }
}

/**
 * Encapsulates the capabilities of a given codec component.
 * For example, what profile/level combinations it supports and what colorspaces
 * it is capable of providing the decoded data in, as well as some
 * codec-type specific capability flags.
 * <p>You can get an instance for a given {@link android.media.MediaCodecInfo MediaCodecInfo} object with
 * {@link android.media.MediaCodecInfo#getCapabilitiesForType MediaCodecInfo#getCapabilitiesForType}, passing a MIME type.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CodecCapabilities {

/** @apiSince 16 */

public CodecCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Query codec feature capabilities.
 * <p>
 * These features are supported to be used by the codec.  These
 * include optional features that can be turned on, as well as
 * features that are always on.
 * @apiSince 19
 */

public boolean isFeatureSupported(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Query codec feature requirements.
 * <p>
 * These features are required to be used by the codec, and as such,
 * they are always turned on.
 * @apiSince 21
 */

public boolean isFeatureRequired(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Query whether codec supports a given {@link android.media.MediaFormat MediaFormat}.
 *
 * <p class=note>
 * <strong>Note:</strong> On {@link android.os.Build.VERSION_CODES#LOLLIPOP},
 * {@code format} must not contain a {@linkplain android.media.MediaFormat#KEY_FRAME_RATE MediaFormat#KEY_FRAME_RATE}. Use
 * <code class=prettyprint>format.setString(MediaFormat.KEY_FRAME_RATE, null)</code>
 * to clear any existing frame rate setting in the format.
 * <p>
 *
 * The following table summarizes the format keys considered by this method.
 *
 * <table style="width: 0%">
 *  <thead>
 *   <tr>
 *    <th rowspan=3>OS Version(s)</th>
 *    <td colspan=3>{@code MediaFormat} keys considered for</th>
 *   </tr><tr>
 *    <th>Audio Codecs</th>
 *    <th>Video Codecs</th>
 *    <th>Encoders</th>
 *   </tr>
 *  </thead>
 *  <tbody>
 *   <tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP}</th>
 *    <td rowspan=3>{@link android.media.MediaFormat#KEY_MIME MediaFormat#KEY_MIME}<sup>*</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_SAMPLE_RATE MediaFormat#KEY_SAMPLE_RATE},<br>
 *        {@link android.media.MediaFormat#KEY_CHANNEL_COUNT MediaFormat#KEY_CHANNEL_COUNT},</td>
 *    <td>{@link android.media.MediaFormat#KEY_MIME MediaFormat#KEY_MIME}<sup>*</sup>,<br>
 *        {@link android.media.MediaCodecInfo.CodecCapabilities#FEATURE_AdaptivePlayback CodecCapabilities#FEATURE_AdaptivePlayback}<sup>D</sup>,<br>
 *        {@link android.media.MediaCodecInfo.CodecCapabilities#FEATURE_SecurePlayback CodecCapabilities#FEATURE_SecurePlayback}<sup>D</sup>,<br>
 *        {@link android.media.MediaCodecInfo.CodecCapabilities#FEATURE_TunneledPlayback CodecCapabilities#FEATURE_TunneledPlayback}<sup>D</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_WIDTH MediaFormat#KEY_WIDTH},<br>
 *        {@link android.media.MediaFormat#KEY_HEIGHT MediaFormat#KEY_HEIGHT},<br>
 *        <strong>no</strong> {@code KEY_FRAME_RATE}</td>
 *    <td rowspan=4>{@link android.media.MediaFormat#KEY_BITRATE_MODE MediaFormat#KEY_BITRATE_MODE},<br>
 *        {@link android.media.MediaFormat#KEY_PROFILE MediaFormat#KEY_PROFILE}
 *        (and/or {@link android.media.MediaFormat#KEY_AAC_PROFILE MediaFormat#KEY_AAC_PROFILE}<sup>~</sup>),<br>
 *        <!-- {link MediaFormat#KEY_QUALITY},<br> -->
 *        {@link android.media.MediaFormat#KEY_COMPLEXITY MediaFormat#KEY_COMPLEXITY}
 *        (and/or {@link android.media.MediaFormat#KEY_FLAC_COMPRESSION_LEVEL MediaFormat#KEY_FLAC_COMPRESSION_LEVEL}<sup>~</sup>)</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}</th>
 *    <td rowspan=2>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_FRAME_RATE MediaFormat#KEY_FRAME_RATE}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#M}</th>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#N}</th>
 *    <td>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_PROFILE MediaFormat#KEY_PROFILE},<br>
 *        <!-- {link MediaFormat#KEY_MAX_BIT_RATE},<br> -->
 *        {@link android.media.MediaFormat#KEY_BIT_RATE MediaFormat#KEY_BIT_RATE}</td>
 *    <td>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_PROFILE MediaFormat#KEY_PROFILE},<br>
 *        {@link android.media.MediaFormat#KEY_LEVEL MediaFormat#KEY_LEVEL}<sup>+</sup>,<br>
 *        <!-- {link MediaFormat#KEY_MAX_BIT_RATE},<br> -->
 *        {@link android.media.MediaFormat#KEY_BIT_RATE MediaFormat#KEY_BIT_RATE},<br>
 *        {@link android.media.MediaCodecInfo.CodecCapabilities#FEATURE_IntraRefresh CodecCapabilities#FEATURE_IntraRefresh}<sup>E</sup></td>
 *   </tr>
 *   <tr>
 *    <td colspan=4>
 *     <p class=note><strong>Notes:</strong><br>
 *      *: must be specified; otherwise, method returns {@code false}.<br>
 *      +: method does not verify that the format parameters are supported
 *      by the specified level.<br>
 *      D: decoders only<br>
 *      E: encoders only<br>
 *      ~: if both keys are provided values must match
 *    </td>
 *   </tr>
 *  </tbody>
 * </table>
 *
 * @param format media format with optional feature directives.
 * @throws java.lang.IllegalArgumentException if format is not a valid media format.
 * @return whether the codec capabilities support the given format
 *         and feature requests.
 * @apiSince 21
 */

public boolean isFormatSupported(android.media.MediaFormat format) { throw new RuntimeException("Stub!"); }

/**
 * Returns a MediaFormat object with default values for configurations that have
 * defaults.
 * @apiSince 21
 */

public android.media.MediaFormat getDefaultFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the mime type for which this codec-capability object was created.
 * @apiSince 21
 */

public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the max number of the supported concurrent codec instances.
 * <p>
 * This is a hint for an upper bound. Applications should not expect to successfully
 * operate more instances than the returned value, but the actual number of
 * concurrently operable instances may be less as it depends on the available
 * resources at time of use.
 * @apiSince 23
 */

public int getMaxSupportedInstances() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio capabilities or {@code null} if this is not an audio codec.
 * @apiSince 21
 */

public android.media.MediaCodecInfo.AudioCapabilities getAudioCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the encoding capabilities or {@code null} if this is not an encoder.
 * @apiSince 21
 */

public android.media.MediaCodecInfo.EncoderCapabilities getEncoderCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the video capabilities or {@code null} if this is not a video codec.
 * @apiSince 21
 */

public android.media.MediaCodecInfo.VideoCapabilities getVideoCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the codec capabilities for a certain {@code mime type}, {@code
 * profile} and {@code level}.  If the type, or profile-level combination
 * is not understood by the framework, it returns null.
 * <p class=note> In {@link android.os.Build.VERSION_CODES#M}, calling this
 * method without calling any method of the {@link android.media.MediaCodecList MediaCodecList} class beforehand
 * results in a {@link java.lang.NullPointerException NullPointerException}.</p>
 * @apiSince 21
 */

public static android.media.MediaCodecInfo.CodecCapabilities createFromProfileLevel(java.lang.String mime, int profile, int level) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #COLOR_Format24bitBGR888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format12bitRGB444 = 3; // 0x3

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format16bitARGB1555 = 5; // 0x5

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format16bitARGB4444 = 4; // 0x4

/**
 * @deprecated Use {@link #COLOR_Format16bitRGB565}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format16bitBGR565 = 7; // 0x7

/**
 * 16 bits per pixel RGB color format, with 5-bit red & blue and 6-bit green component.
 * <p>
 * Using 16-bit little-endian representation, colors stored as Red 15:11, Green 10:5, Blue 4:0.
 * <pre>
 *            byte                   byte
 *  <--------- i --------> | <------ i + 1 ------>
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 * |     BLUE     |      GREEN      |     RED      |
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 *  0           4  5     7   0     2  3           7
 * bit
 * </pre>
 *
 * This format corresponds to {@link android.graphics.PixelFormat#RGB_565} and
 * {@link android.graphics.ImageFormat#RGB_565}.
 * @apiSince 16
 */

public static final int COLOR_Format16bitRGB565 = 6; // 0x6

/**
 * @deprecated Use {@link #COLOR_Format24bitBGR888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format18BitBGR666 = 41; // 0x29

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format18bitARGB1665 = 9; // 0x9

/**
 * @deprecated Use {@link #COLOR_Format24bitBGR888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format18bitRGB666 = 8; // 0x8

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format19bitARGB1666 = 10; // 0xa

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format24BitABGR6666 = 43; // 0x2b

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format24BitARGB6666 = 42; // 0x2a

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format24bitARGB1887 = 13; // 0xd

/**
 * 24 bits per pixel RGB color format, with 8-bit red, green & blue components.
 * <p>
 * Using 24-bit little-endian representation, colors stored as Red 7:0, Green 15:8, Blue 23:16.
 * <pre>
 *         byte              byte             byte
 *  <------ i -----> | <---- i+1 ----> | <---- i+2 ----->
 * +-----------------+-----------------+-----------------+
 * |       RED       |      GREEN      |       BLUE      |
 * +-----------------+-----------------+-----------------+
 * </pre>
 *
 * This format corresponds to {@link android.graphics.PixelFormat#RGB_888}, and can also be
 * represented as a flexible format by {@link #COLOR_FormatRGBFlexible}.
 * @apiSince 16
 */

public static final int COLOR_Format24bitBGR888 = 12; // 0xc

/**
 * @deprecated Use {@link #COLOR_Format24bitBGR888} or {@link #COLOR_FormatRGBFlexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format24bitRGB888 = 11; // 0xb

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format25bitARGB1888 = 14; // 0xe

/**
 * 32 bits per pixel RGBA color format, with 8-bit red, green, blue, and alpha components.
 * <p>
 * Using 32-bit little-endian representation, colors stored as Red 7:0, Green 15:8,
 * Blue 23:16, and Alpha 31:24.
 * <pre>
 *         byte              byte             byte              byte
 *  <------ i -----> | <---- i+1 ----> | <---- i+2 ----> | <---- i+3 ----->
 * +-----------------+-----------------+-----------------+-----------------+
 * |       RED       |      GREEN      |       BLUE      |      ALPHA      |
 * +-----------------+-----------------+-----------------+-----------------+
 * </pre>
 *
 * This corresponds to {@link android.graphics.PixelFormat#RGBA_8888}.
 * @apiSince 23
 */

public static final int COLOR_Format32bitABGR8888 = 2130747392; // 0x7f00a000

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888} Or {@link #COLOR_FormatRGBAFlexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format32bitARGB8888 = 16; // 0x10

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888} Or {@link #COLOR_FormatRGBAFlexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format32bitBGRA8888 = 15; // 0xf

/**
 * @deprecated Use {@link #COLOR_Format24bitBGR888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_Format8bitRGB332 = 2; // 0x2

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatCbYCrY = 27; // 0x1b

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatCrYCbY = 28; // 0x1c

/**
 * 16 bits per pixel, little-endian Y color format.
 * <p>
 * <pre>
 *            byte                   byte
 *  <--------- i --------> | <------ i + 1 ------>
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 * |                       Y                       |
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 *  0                    7   0                    7
 * bit
 * </pre>
 * @apiSince 16
 */

public static final int COLOR_FormatL16 = 36; // 0x24

/**
 * @deprecated Use {@link #COLOR_FormatL8}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatL2 = 33; // 0x21

/**
 * @deprecated Use {@link #COLOR_FormatL16}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatL24 = 37; // 0x25

/**
 * 32 bits per pixel, little-endian Y color format.
 * <p>
 * <pre>
 *         byte              byte             byte              byte
 *  <------ i -----> | <---- i+1 ----> | <---- i+2 ----> | <---- i+3 ----->
 * +-----------------+-----------------+-----------------+-----------------+
 * |                                   Y                                   |
 * +-----------------+-----------------+-----------------+-----------------+
 *  0               7 0               7 0               7 0               7
 * bit
 * </pre>
 *
 * @deprecated Use {@link #COLOR_FormatL16}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatL32 = 38; // 0x26

/**
 * @deprecated Use {@link #COLOR_FormatL8}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatL4 = 34; // 0x22

/**
 * 8 bits per pixel Y color format.
 * <p>
 * Each byte contains a single pixel.
 * This format corresponds to {@link android.graphics.PixelFormat#L_8}.
 * @apiSince 16
 */

public static final int COLOR_FormatL8 = 35; // 0x23

/**
 * @deprecated Use {@link #COLOR_Format24bitBGR888}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatMonochrome = 1; // 0x1

/**
 * Flexible 32 bits per pixel RGBA color format with 8-bit red, green, blue, and alpha
 * components.
 * <p>
 * Use this format with {@link android.media.Image Image}. This format corresponds to
 * {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, and can represent
 * {@link #COLOR_Format32bitBGRA8888}, {@link #COLOR_Format32bitABGR8888} and
 * {@link #COLOR_Format32bitARGB8888} formats.
 *
 * @see android.media.Image#getFormat()
 * @apiSince 23
 */

public static final int COLOR_FormatRGBAFlexible = 2134288520; // 0x7f36a888

/**
 * Flexible 24 bits per pixel RGB color format with 8-bit red, green and blue
 * components.
 * <p>
 * Use this format with {@link android.media.Image Image}. This format corresponds to
 * {@link android.graphics.ImageFormat#FLEX_RGB_888}, and can represent
 * {@link #COLOR_Format24bitBGR888} and {@link #COLOR_Format24bitRGB888} formats.
 * @see android.media.Image#getFormat()
 * @apiSince 23
 */

public static final int COLOR_FormatRGBFlexible = 2134292616; // 0x7f36b888

/**
 * SMIA 10-bit Bayer format.
 * @apiSince 16
 */

public static final int COLOR_FormatRawBayer10bit = 31; // 0x1f

/**
 * SMIA 8-bit Bayer format.
 * Each byte represents the top 8-bits of a 10-bit signal.
 * @apiSince 16
 */

public static final int COLOR_FormatRawBayer8bit = 30; // 0x1e

/**
 * SMIA 8-bit compressed Bayer format.
 * Each byte represents a sample from the 10-bit signal that is compressed into 8-bits
 * using DPCM/PCM compression, as defined by the SMIA Functional Specification.
 * @apiSince 16
 */

public static final int COLOR_FormatRawBayer8bitcompressed = 32; // 0x20

/** @apiSince 18 */

public static final int COLOR_FormatSurface = 2130708361; // 0x7f000789

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYCbYCr = 25; // 0x19

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYCrYCb = 26; // 0x1a

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV411PackedPlanar = 18; // 0x12

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV411Planar = 17; // 0x11

/**
 * Flexible 12 bits per pixel, subsampled YUV color format with 8-bit chroma and luma
 * components.
 * <p>
 * Chroma planes are subsampled by 2 both horizontally and vertically.
 * Use this format with {@link android.media.Image Image}.
 * This format corresponds to {@link android.graphics.ImageFormat#YUV_420_888},
 * and can represent the {@link #COLOR_FormatYUV411Planar},
 * {@link #COLOR_FormatYUV411PackedPlanar}, {@link #COLOR_FormatYUV420Planar},
 * {@link #COLOR_FormatYUV420PackedPlanar}, {@link #COLOR_FormatYUV420SemiPlanar}
 * and {@link #COLOR_FormatYUV420PackedSemiPlanar} formats.
 *
 * @see android.media.Image#getFormat
 * @apiSince 21
 */

public static final int COLOR_FormatYUV420Flexible = 2135033992; // 0x7f420888

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV420PackedPlanar = 20; // 0x14

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV420PackedSemiPlanar = 39; // 0x27

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV420Planar = 19; // 0x13

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV420SemiPlanar = 21; // 0x15

/**
 * Flexible 16 bits per pixel, subsampled YUV color format with 8-bit chroma and luma
 * components.
 * <p>
 * Chroma planes are horizontally subsampled by 2. Use this format with {@link android.media.Image Image}.
 * This format corresponds to {@link android.graphics.ImageFormat#YUV_422_888},
 * and can represent the {@link #COLOR_FormatYCbYCr}, {@link #COLOR_FormatYCrYCb},
 * {@link #COLOR_FormatCbYCrY}, {@link #COLOR_FormatCrYCbY},
 * {@link #COLOR_FormatYUV422Planar}, {@link #COLOR_FormatYUV422PackedPlanar},
 * {@link #COLOR_FormatYUV422SemiPlanar} and {@link #COLOR_FormatYUV422PackedSemiPlanar}
 * formats.
 *
 * @see android.media.Image#getFormat
 * @apiSince 23
 */

public static final int COLOR_FormatYUV422Flexible = 2135042184; // 0x7f422888

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV422PackedPlanar = 23; // 0x17

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV422PackedSemiPlanar = 40; // 0x28

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV422Planar = 22; // 0x16

/**
 * @deprecated Use {@link #COLOR_FormatYUV422Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV422SemiPlanar = 24; // 0x18

/**
 * Flexible 24 bits per pixel YUV color format with 8-bit chroma and luma
 * components.
 * <p>
 * Chroma planes are not subsampled. Use this format with {@link android.media.Image Image}.
 * This format corresponds to {@link android.graphics.ImageFormat#YUV_444_888},
 * and can represent the {@link #COLOR_FormatYUV444Interleaved} format.
 * @see android.media.Image#getFormat
 * @apiSince 23
 */

public static final int COLOR_FormatYUV444Flexible = 2135181448; // 0x7f444888

/**
 * @deprecated Use {@link #COLOR_FormatYUV444Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_FormatYUV444Interleaved = 29; // 0x1d

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_QCOM_FormatYUV420SemiPlanar = 2141391872; // 0x7fa30c00

/**
 * @deprecated Use {@link #COLOR_FormatYUV420Flexible}.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated public static final int COLOR_TI_FormatYUV420PackedSemiPlanar = 2130706688; // 0x7f000100

/**
 * <b>video decoder only</b>: codec supports seamless resolution changes.
 * @apiSince 19
 */

public static final java.lang.String FEATURE_AdaptivePlayback = "adaptive-playback";

/**
 * If true, the timestamp of each output buffer is derived from the timestamp of the input
 * buffer that produced the output. If false, the timestamp of each output buffer is
 * derived from the timestamp of the first input buffer.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_DynamicTimestamp = "dynamic-timestamp";

/**
 * <b>decoder only</b>If true, the codec supports partial (including multiple) access units
 * per input buffer.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_FrameParsing = "frame-parsing";

/**
 * <b>video encoder only</b>: codec supports intra refresh.
 * @apiSince 24
 */

public static final java.lang.String FEATURE_IntraRefresh = "intra-refresh";

/**
 * If true, the codec supports multiple access units (for decoding, or to output for
 * encoders). If false, the codec only supports single access units. Producing multiple
 * access units for output is an optional feature.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_MultipleFrames = "multiple-frames";

/**
 * <b>video decoder only</b>: codec supports queuing partial frames.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_PartialFrame = "partial-frame";

/**
 * <b>video decoder only</b>: codec supports secure decryption.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_SecurePlayback = "secure-playback";

/**
 * <b>video or audio decoder only</b>: codec supports tunneled playback.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_TunneledPlayback = "tunneled-playback";

/**
 * The color format for the media. This is one of the color constants defined in this class.
 * @apiSince 16
 */

public int[] colorFormats;

/** @apiSince 16 */

public android.media.MediaCodecInfo.CodecProfileLevel[] profileLevels;
}

/**
 * Encapsulates the profiles available for a codec component.
 * <p>You can get a set of {@link android.media.MediaCodecInfo.CodecProfileLevel MediaCodecInfo.CodecProfileLevel} objects for a given
 * {@link android.media.MediaCodecInfo MediaCodecInfo} object from the
 * {@link android.media.MediaCodecInfo.CodecCapabilities#profileLevels MediaCodecInfo.CodecCapabilities#profileLevels} field.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CodecProfileLevel {

public CodecProfileLevel() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public static final int AACObjectELD = 39; // 0x27

/** @apiSince 16 */

public static final int AACObjectERLC = 17; // 0x11

/** @apiSince 26 */

public static final int AACObjectERScalable = 20; // 0x14

/** @apiSince 16 */

public static final int AACObjectHE = 5; // 0x5

/** @apiSince 16 */

public static final int AACObjectHE_PS = 29; // 0x1d

/** @apiSince 16 */

public static final int AACObjectLC = 2; // 0x2

/** @apiSince 16 */

public static final int AACObjectLD = 23; // 0x17

/** @apiSince 16 */

public static final int AACObjectLTP = 4; // 0x4

/** @apiSince 16 */

public static final int AACObjectMain = 1; // 0x1

/** @apiSince 16 */

public static final int AACObjectSSR = 3; // 0x3

/** @apiSince 16 */

public static final int AACObjectScalable = 6; // 0x6

/**
 * xHE-AAC (includes USAC)
 * @apiSince 28
 */

public static final int AACObjectXHE = 42; // 0x2a

/** @apiSince 29 */

public static final int AV1Level2 = 1; // 0x1

/** @apiSince 29 */

public static final int AV1Level21 = 2; // 0x2

/** @apiSince 29 */

public static final int AV1Level22 = 4; // 0x4

/** @apiSince 29 */

public static final int AV1Level23 = 8; // 0x8

/** @apiSince 29 */

public static final int AV1Level3 = 16; // 0x10

/** @apiSince 29 */

public static final int AV1Level31 = 32; // 0x20

/** @apiSince 29 */

public static final int AV1Level32 = 64; // 0x40

/** @apiSince 29 */

public static final int AV1Level33 = 128; // 0x80

/** @apiSince 29 */

public static final int AV1Level4 = 256; // 0x100

/** @apiSince 29 */

public static final int AV1Level41 = 512; // 0x200

/** @apiSince 29 */

public static final int AV1Level42 = 1024; // 0x400

/** @apiSince 29 */

public static final int AV1Level43 = 2048; // 0x800

/** @apiSince 29 */

public static final int AV1Level5 = 4096; // 0x1000

/** @apiSince 29 */

public static final int AV1Level51 = 8192; // 0x2000

/** @apiSince 29 */

public static final int AV1Level52 = 16384; // 0x4000

/** @apiSince 29 */

public static final int AV1Level53 = 32768; // 0x8000

/** @apiSince 29 */

public static final int AV1Level6 = 65536; // 0x10000

/** @apiSince 29 */

public static final int AV1Level61 = 131072; // 0x20000

/** @apiSince 29 */

public static final int AV1Level62 = 262144; // 0x40000

/** @apiSince 29 */

public static final int AV1Level63 = 524288; // 0x80000

/** @apiSince 29 */

public static final int AV1Level7 = 1048576; // 0x100000

/** @apiSince 29 */

public static final int AV1Level71 = 2097152; // 0x200000

/** @apiSince 29 */

public static final int AV1Level72 = 4194304; // 0x400000

/** @apiSince 29 */

public static final int AV1Level73 = 8388608; // 0x800000

/**
 * AV1 Main profile 4:2:0 10-bit
 *
 * See definition in
 * <a href="https://aomedia.org/av1-bitstream-and-decoding-process-specification/">AV1 Specification</a>
 * Annex A.
 * @apiSince 29
 */

public static final int AV1ProfileMain10 = 2; // 0x2

/**
 * AV1 Main profile 4:2:0 10-bit with HDR10.
 * @apiSince 29
 */

public static final int AV1ProfileMain10HDR10 = 4096; // 0x1000

/**
 * AV1 Main profile 4:2:0 10-bit with HDR10Plus.
 * @apiSince 29
 */

public static final int AV1ProfileMain10HDR10Plus = 8192; // 0x2000

/**
 * AV1 Main profile 4:2:0 8-bit
 *
 * See definition in
 * <a href="https://aomedia.org/av1-bitstream-and-decoding-process-specification/">AV1 Specification</a>
 * Annex A.
 * @apiSince 29
 */

public static final int AV1ProfileMain8 = 1; // 0x1

/** @apiSince 16 */

public static final int AVCLevel1 = 1; // 0x1

/** @apiSince 16 */

public static final int AVCLevel11 = 4; // 0x4

/** @apiSince 16 */

public static final int AVCLevel12 = 8; // 0x8

/** @apiSince 16 */

public static final int AVCLevel13 = 16; // 0x10

/** @apiSince 16 */

public static final int AVCLevel1b = 2; // 0x2

/** @apiSince 16 */

public static final int AVCLevel2 = 32; // 0x20

/** @apiSince 16 */

public static final int AVCLevel21 = 64; // 0x40

/** @apiSince 16 */

public static final int AVCLevel22 = 128; // 0x80

/** @apiSince 16 */

public static final int AVCLevel3 = 256; // 0x100

/** @apiSince 16 */

public static final int AVCLevel31 = 512; // 0x200

/** @apiSince 16 */

public static final int AVCLevel32 = 1024; // 0x400

/** @apiSince 16 */

public static final int AVCLevel4 = 2048; // 0x800

/** @apiSince 16 */

public static final int AVCLevel41 = 4096; // 0x1000

/** @apiSince 16 */

public static final int AVCLevel42 = 8192; // 0x2000

/** @apiSince 16 */

public static final int AVCLevel5 = 16384; // 0x4000

/** @apiSince 16 */

public static final int AVCLevel51 = 32768; // 0x8000

/** @apiSince 21 */

public static final int AVCLevel52 = 65536; // 0x10000

/** @apiSince 29 */

public static final int AVCLevel6 = 131072; // 0x20000

/** @apiSince 29 */

public static final int AVCLevel61 = 262144; // 0x40000

/** @apiSince 29 */

public static final int AVCLevel62 = 524288; // 0x80000

/**
 * AVC Baseline profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 16
 */

public static final int AVCProfileBaseline = 1; // 0x1

/**
 * AVC Constrained Baseline profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 27
 */

public static final int AVCProfileConstrainedBaseline = 65536; // 0x10000

/**
 * AVC Constrained High profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 27
 */

public static final int AVCProfileConstrainedHigh = 524288; // 0x80000

/**
 * AVC Extended profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 16
 */

public static final int AVCProfileExtended = 4; // 0x4

/**
 * AVC High profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 16
 */

public static final int AVCProfileHigh = 8; // 0x8

/**
 * AVC High 10 profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 16
 */

public static final int AVCProfileHigh10 = 16; // 0x10

/**
 * AVC High 4:2:2 profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 16
 */

public static final int AVCProfileHigh422 = 32; // 0x20

/**
 * AVC High 4:4:4 profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 16
 */

public static final int AVCProfileHigh444 = 64; // 0x40

/**
 * AVC Main profile.
 * See definition in
 * <a href="https://www.itu.int/rec/T-REC-H.264-201704-I">H.264 recommendation</a>,
 * Annex A.
 * @apiSince 16
 */

public static final int AVCProfileMain = 2; // 0x2

/** @apiSince 24 */

public static final int DolbyVisionLevelFhd24 = 4; // 0x4

/** @apiSince 24 */

public static final int DolbyVisionLevelFhd30 = 8; // 0x8

/** @apiSince 24 */

public static final int DolbyVisionLevelFhd60 = 16; // 0x10

/** @apiSince 24 */

public static final int DolbyVisionLevelHd24 = 1; // 0x1

/** @apiSince 24 */

public static final int DolbyVisionLevelHd30 = 2; // 0x2

/** @apiSince 24 */

public static final int DolbyVisionLevelUhd24 = 32; // 0x20

/** @apiSince 24 */

public static final int DolbyVisionLevelUhd30 = 64; // 0x40

/** @apiSince 24 */

public static final int DolbyVisionLevelUhd48 = 128; // 0x80

/** @apiSince 24 */

public static final int DolbyVisionLevelUhd60 = 256; // 0x100

/** @apiSince 24 */

public static final int DolbyVisionProfileDvavPen = 2; // 0x2

/** @apiSince 24 */

public static final int DolbyVisionProfileDvavPer = 1; // 0x1

/** @apiSince 27 */

public static final int DolbyVisionProfileDvavSe = 512; // 0x200

/** @apiSince 24 */

public static final int DolbyVisionProfileDvheDen = 8; // 0x8

/** @apiSince 24 */

public static final int DolbyVisionProfileDvheDer = 4; // 0x4

/** @apiSince 24 */

public static final int DolbyVisionProfileDvheDtb = 128; // 0x80

/** @apiSince 24 */

public static final int DolbyVisionProfileDvheDth = 64; // 0x40

/** @apiSince 24 */

public static final int DolbyVisionProfileDvheDtr = 16; // 0x10

/** @apiSince 27 */

public static final int DolbyVisionProfileDvheSt = 256; // 0x100

/** @apiSince 24 */

public static final int DolbyVisionProfileDvheStn = 32; // 0x20

/** @apiSince 16 */

public static final int H263Level10 = 1; // 0x1

/** @apiSince 16 */

public static final int H263Level20 = 2; // 0x2

/** @apiSince 16 */

public static final int H263Level30 = 4; // 0x4

/** @apiSince 16 */

public static final int H263Level40 = 8; // 0x8

/** @apiSince 16 */

public static final int H263Level45 = 16; // 0x10

/** @apiSince 16 */

public static final int H263Level50 = 32; // 0x20

/** @apiSince 16 */

public static final int H263Level60 = 64; // 0x40

/** @apiSince 16 */

public static final int H263Level70 = 128; // 0x80

/** @apiSince 16 */

public static final int H263ProfileBackwardCompatible = 4; // 0x4

/** @apiSince 16 */

public static final int H263ProfileBaseline = 1; // 0x1

/** @apiSince 16 */

public static final int H263ProfileH320Coding = 2; // 0x2

/** @apiSince 16 */

public static final int H263ProfileHighCompression = 32; // 0x20

/** @apiSince 16 */

public static final int H263ProfileHighLatency = 256; // 0x100

/** @apiSince 16 */

public static final int H263ProfileISWV2 = 8; // 0x8

/** @apiSince 16 */

public static final int H263ProfileISWV3 = 16; // 0x10

/** @apiSince 16 */

public static final int H263ProfileInterlace = 128; // 0x80

/** @apiSince 16 */

public static final int H263ProfileInternet = 64; // 0x40

/** @apiSince 21 */

public static final int HEVCHighTierLevel1 = 2; // 0x2

/** @apiSince 21 */

public static final int HEVCHighTierLevel2 = 8; // 0x8

/** @apiSince 21 */

public static final int HEVCHighTierLevel21 = 32; // 0x20

/** @apiSince 21 */

public static final int HEVCHighTierLevel3 = 128; // 0x80

/** @apiSince 21 */

public static final int HEVCHighTierLevel31 = 512; // 0x200

/** @apiSince 21 */

public static final int HEVCHighTierLevel4 = 2048; // 0x800

/** @apiSince 21 */

public static final int HEVCHighTierLevel41 = 8192; // 0x2000

/** @apiSince 21 */

public static final int HEVCHighTierLevel5 = 32768; // 0x8000

/** @apiSince 21 */

public static final int HEVCHighTierLevel51 = 131072; // 0x20000

/** @apiSince 21 */

public static final int HEVCHighTierLevel52 = 524288; // 0x80000

/** @apiSince 21 */

public static final int HEVCHighTierLevel6 = 2097152; // 0x200000

/** @apiSince 21 */

public static final int HEVCHighTierLevel61 = 8388608; // 0x800000

/** @apiSince 21 */

public static final int HEVCHighTierLevel62 = 33554432; // 0x2000000

/** @apiSince 21 */

public static final int HEVCMainTierLevel1 = 1; // 0x1

/** @apiSince 21 */

public static final int HEVCMainTierLevel2 = 4; // 0x4

/** @apiSince 21 */

public static final int HEVCMainTierLevel21 = 16; // 0x10

/** @apiSince 21 */

public static final int HEVCMainTierLevel3 = 64; // 0x40

/** @apiSince 21 */

public static final int HEVCMainTierLevel31 = 256; // 0x100

/** @apiSince 21 */

public static final int HEVCMainTierLevel4 = 1024; // 0x400

/** @apiSince 21 */

public static final int HEVCMainTierLevel41 = 4096; // 0x1000

/** @apiSince 21 */

public static final int HEVCMainTierLevel5 = 16384; // 0x4000

/** @apiSince 21 */

public static final int HEVCMainTierLevel51 = 65536; // 0x10000

/** @apiSince 21 */

public static final int HEVCMainTierLevel52 = 262144; // 0x40000

/** @apiSince 21 */

public static final int HEVCMainTierLevel6 = 1048576; // 0x100000

/** @apiSince 21 */

public static final int HEVCMainTierLevel61 = 4194304; // 0x400000

/** @apiSince 21 */

public static final int HEVCMainTierLevel62 = 16777216; // 0x1000000

/** @apiSince 21 */

public static final int HEVCProfileMain = 1; // 0x1

/** @apiSince 21 */

public static final int HEVCProfileMain10 = 2; // 0x2

/** @apiSince 24 */

public static final int HEVCProfileMain10HDR10 = 4096; // 0x1000

/** @apiSince 29 */

public static final int HEVCProfileMain10HDR10Plus = 8192; // 0x2000

/** @apiSince 28 */

public static final int HEVCProfileMainStill = 4; // 0x4

/** @apiSince 23 */

public static final int MPEG2LevelH14 = 2; // 0x2

/** @apiSince 23 */

public static final int MPEG2LevelHL = 3; // 0x3

/** @apiSince 24 */

public static final int MPEG2LevelHP = 4; // 0x4

/** @apiSince 23 */

public static final int MPEG2LevelLL = 0; // 0x0

/** @apiSince 23 */

public static final int MPEG2LevelML = 1; // 0x1

/** @apiSince 23 */

public static final int MPEG2Profile422 = 2; // 0x2

/** @apiSince 23 */

public static final int MPEG2ProfileHigh = 5; // 0x5

/** @apiSince 23 */

public static final int MPEG2ProfileMain = 1; // 0x1

/** @apiSince 23 */

public static final int MPEG2ProfileSNR = 3; // 0x3

/** @apiSince 23 */

public static final int MPEG2ProfileSimple = 0; // 0x0

/** @apiSince 23 */

public static final int MPEG2ProfileSpatial = 4; // 0x4

/** @apiSince 16 */

public static final int MPEG4Level0 = 1; // 0x1

/** @apiSince 16 */

public static final int MPEG4Level0b = 2; // 0x2

/** @apiSince 16 */

public static final int MPEG4Level1 = 4; // 0x4

/** @apiSince 16 */

public static final int MPEG4Level2 = 8; // 0x8

/** @apiSince 16 */

public static final int MPEG4Level3 = 16; // 0x10

/** @apiSince 24 */

public static final int MPEG4Level3b = 24; // 0x18

/** @apiSince 16 */

public static final int MPEG4Level4 = 32; // 0x20

/** @apiSince 16 */

public static final int MPEG4Level4a = 64; // 0x40

/** @apiSince 16 */

public static final int MPEG4Level5 = 128; // 0x80

/** @apiSince 24 */

public static final int MPEG4Level6 = 256; // 0x100

/** @apiSince 16 */

public static final int MPEG4ProfileAdvancedCoding = 4096; // 0x1000

/** @apiSince 16 */

public static final int MPEG4ProfileAdvancedCore = 8192; // 0x2000

/** @apiSince 16 */

public static final int MPEG4ProfileAdvancedRealTime = 1024; // 0x400

/** @apiSince 16 */

public static final int MPEG4ProfileAdvancedScalable = 16384; // 0x4000

/** @apiSince 16 */

public static final int MPEG4ProfileAdvancedSimple = 32768; // 0x8000

/** @apiSince 16 */

public static final int MPEG4ProfileBasicAnimated = 256; // 0x100

/** @apiSince 16 */

public static final int MPEG4ProfileCore = 4; // 0x4

/** @apiSince 16 */

public static final int MPEG4ProfileCoreScalable = 2048; // 0x800

/** @apiSince 16 */

public static final int MPEG4ProfileHybrid = 512; // 0x200

/** @apiSince 16 */

public static final int MPEG4ProfileMain = 8; // 0x8

/** @apiSince 16 */

public static final int MPEG4ProfileNbit = 16; // 0x10

/** @apiSince 16 */

public static final int MPEG4ProfileScalableTexture = 32; // 0x20

/** @apiSince 16 */

public static final int MPEG4ProfileSimple = 1; // 0x1

/** @apiSince 16 */

public static final int MPEG4ProfileSimpleFBA = 128; // 0x80

/** @apiSince 16 */

public static final int MPEG4ProfileSimpleFace = 64; // 0x40

/** @apiSince 16 */

public static final int MPEG4ProfileSimpleScalable = 2; // 0x2

/** @apiSince 18 */

public static final int VP8Level_Version0 = 1; // 0x1

/** @apiSince 18 */

public static final int VP8Level_Version1 = 2; // 0x2

/** @apiSince 18 */

public static final int VP8Level_Version2 = 4; // 0x4

/** @apiSince 18 */

public static final int VP8Level_Version3 = 8; // 0x8

/** @apiSince 18 */

public static final int VP8ProfileMain = 1; // 0x1

/** @apiSince 24 */

public static final int VP9Level1 = 1; // 0x1

/** @apiSince 24 */

public static final int VP9Level11 = 2; // 0x2

/** @apiSince 24 */

public static final int VP9Level2 = 4; // 0x4

/** @apiSince 24 */

public static final int VP9Level21 = 8; // 0x8

/** @apiSince 24 */

public static final int VP9Level3 = 16; // 0x10

/** @apiSince 24 */

public static final int VP9Level31 = 32; // 0x20

/** @apiSince 24 */

public static final int VP9Level4 = 64; // 0x40

/** @apiSince 24 */

public static final int VP9Level41 = 128; // 0x80

/** @apiSince 24 */

public static final int VP9Level5 = 256; // 0x100

/** @apiSince 24 */

public static final int VP9Level51 = 512; // 0x200

/** @apiSince 24 */

public static final int VP9Level52 = 1024; // 0x400

/** @apiSince 24 */

public static final int VP9Level6 = 2048; // 0x800

/** @apiSince 24 */

public static final int VP9Level61 = 4096; // 0x1000

/** @apiSince 24 */

public static final int VP9Level62 = 8192; // 0x2000

/**
 * VP9 Profile 0 4:2:0 8-bit
 * @apiSince 24
 */

public static final int VP9Profile0 = 1; // 0x1

/**
 * VP9 Profile 1 4:2:2 8-bit
 * @apiSince 24
 */

public static final int VP9Profile1 = 2; // 0x2

/**
 * VP9 Profile 2 4:2:0 10-bit
 * @apiSince 24
 */

public static final int VP9Profile2 = 4; // 0x4

/**
 * VP9 Profile 2 4:2:0 10-bit HDR
 * @apiSince 24
 */

public static final int VP9Profile2HDR = 4096; // 0x1000

/**
 * VP9 Profile 2 4:2:0 10-bit HDR10Plus
 * @apiSince 29
 */

public static final int VP9Profile2HDR10Plus = 16384; // 0x4000

/**
 * VP9 Profile 3 4:2:2 10-bit
 * @apiSince 24
 */

public static final int VP9Profile3 = 8; // 0x8

/**
 * VP9 Profile 3 4:2:2 10-bit HDR
 * @apiSince 24
 */

public static final int VP9Profile3HDR = 8192; // 0x2000

/**
 * VP9 Profile 3 4:2:2 10-bit HDR10Plus
 * @apiSince 29
 */

public static final int VP9Profile3HDR10Plus = 32768; // 0x8000

/**
 * The level of the media content. Depending on the type of media this can be
 * one of the level values defined in this class.
 *
 * Note that VP9 decoder on platforms before {@link android.os.Build.VERSION_CODES#N} may
 * not advertise a profile level support. For those VP9 decoders, please use
 * {@link android.media.MediaCodecInfo.VideoCapabilities VideoCapabilities} to determine the codec capabilities.
 * @apiSince 16
 */

public int level;

/**
 * The profile of the media content. Depending on the type of media this can be
 * one of the profile values defined in this class.
 * @apiSince 16
 */

public int profile;
}

/**
 * A class that supports querying the encoding capabilities of a codec.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EncoderCapabilities {

private EncoderCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the supported range of quality values.
 *
 * Quality is implementation-specific. As a general rule, a higher quality
 * setting results in a better image quality and a lower compression ratio.
 * @apiSince 28
 */

public android.util.Range<java.lang.Integer> getQualityRange() { throw new RuntimeException("Stub!"); }

/**
 * Returns the supported range of encoder complexity values.
 * <p>
 * Some codecs may support multiple complexity levels, where higher
 * complexity values use more encoder tools (e.g. perform more
 * intensive calculations) to improve the quality or the compression
 * ratio.  Use a lower value to save power and/or time.
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getComplexityRange() { throw new RuntimeException("Stub!"); }

/**
 * Query whether a bitrate mode is supported.
 * @apiSince 21
 */

public boolean isBitrateModeSupported(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Constant bitrate mode
 * @apiSince 21
 */

public static final int BITRATE_MODE_CBR = 2; // 0x2

/**
 * Constant quality mode
 * @apiSince 21
 */

public static final int BITRATE_MODE_CQ = 0; // 0x0

/**
 * Variable bitrate mode
 * @apiSince 21
 */

public static final int BITRATE_MODE_VBR = 1; // 0x1
}

/**
 * A class that supports querying the video capabilities of a codec.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class VideoCapabilities {

private VideoCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported bitrates in bits/second.
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getBitrateRange() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video widths.
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getSupportedWidths() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video heights.
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getSupportedHeights() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alignment requirement for video width (in pixels).
 *
 * This is a power-of-2 value that video width must be a
 * multiple of.
 * @apiSince 21
 */

public int getWidthAlignment() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alignment requirement for video height (in pixels).
 *
 * This is a power-of-2 value that video height must be a
 * multiple of.
 * @apiSince 21
 */

public int getHeightAlignment() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported frame rates.
 * <p>
 * This is not a performance indicator.  Rather, it expresses the
 * limits specified in the coding standard, based on the complexities
 * of encoding material for later playback at a certain frame rate,
 * or the decoding of such material in non-realtime.
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getSupportedFrameRates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video widths for a video height.
 * @param height the height of the video
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getSupportedWidthsFor(int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video heights for a video width
 * @param width the width of the video
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer> getSupportedHeightsFor(int width) { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video frame rates for a video size.
 * <p>
 * This is not a performance indicator.  Rather, it expresses the limits specified in
 * the coding standard, based on the complexities of encoding material of a given
 * size for later playback at a certain frame rate, or the decoding of such material
 * in non-realtime.
 
 * @param width the width of the video
 * @param height the height of the video
 * @apiSince 21
 */

public android.util.Range<java.lang.Double> getSupportedFrameRatesFor(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of achievable video frame rates for a video size.
 * May return {@code null}, if the codec did not publish any measurement
 * data.
 * <p>
 * This is a performance estimate provided by the device manufacturer based on statistical
 * sampling of full-speed decoding and encoding measurements in various configurations
 * of common video sizes supported by the codec. As such it should only be used to
 * compare individual codecs on the device. The value is not suitable for comparing
 * different devices or even different android releases for the same device.
 * <p>
 * <em>On {@link android.os.Build.VERSION_CODES#M} release</em> the returned range
 * corresponds to the fastest frame rates achieved in the tested configurations. As
 * such, it should not be used to gauge guaranteed or even average codec performance
 * on the device.
 * <p>
 * <em>On {@link android.os.Build.VERSION_CODES#N} release</em> the returned range
 * corresponds closer to sustained performance <em>in tested configurations</em>.
 * One can expect to achieve sustained performance higher than the lower limit more than
 * 50% of the time, and higher than half of the lower limit at least 90% of the time
 * <em>in tested configurations</em>.
 * Conversely, one can expect performance lower than twice the upper limit at least
 * 90% of the time.
 * <p class=note>
 * Tested configurations use a single active codec. For use cases where multiple
 * codecs are active, applications can expect lower and in most cases significantly lower
 * performance.
 * <p class=note>
 * The returned range value is interpolated from the nearest frame size(s) tested.
 * Codec performance is severely impacted by other activity on the device as well
 * as environmental factors (such as battery level, temperature or power source), and can
 * vary significantly even in a steady environment.
 * <p class=note>
 * Use this method in cases where only codec performance matters, e.g. to evaluate if
 * a codec has any chance of meeting a performance target. Codecs are listed
 * in {@link android.media.MediaCodecList MediaCodecList} in the preferred order as defined by the device
 * manufacturer. As such, applications should use the first suitable codec in the
 * list to achieve the best balance between power use and performance.
 *
 * @param width the width of the video
 * @param height the height of the video
 *
 * @throws java.lang.IllegalArgumentException if the video size is not supported.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.util.Range<java.lang.Double> getAchievableFrameRatesFor(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the supported performance points. May return {@code null} if the codec did not
 * publish any performance point information (e.g. the vendor codecs have not been updated
 * to the latest android release). May return an empty list if the codec published that
 * if does not guarantee any performance points.
 * <p>
 * This is a performance guarantee provided by the device manufacturer for hardware codecs
 * based on hardware capabilities of the device.
 * <p>
 * The returned list is sorted first by decreasing number of pixels, then by decreasing
 * width, and finally by decreasing frame rate.
 * Performance points assume a single active codec. For use cases where multiple
 * codecs are active, should use that highest pixel count, and add the frame rates of
 * each individual codec.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.List<android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint> getSupportedPerformancePoints() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a given video size ({@code width} and
 * {@code height}) and {@code frameRate} combination is supported.
 * @apiSince 21
 */

public boolean areSizeAndRateSupported(int width, int height, double frameRate) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a given video size ({@code width} and
 * {@code height}) is supported.
 * @apiSince 21
 */

public boolean isSizeSupported(int width, int height) { throw new RuntimeException("Stub!"); }
/**
 * Video performance points are a set of standard performance points defined by number of
 * pixels, pixel rate and frame rate. Performance point represents an upper bound. This
 * means that it covers all performance points with fewer pixels, pixel rate and frame
 * rate.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PerformancePoint {

/**
 * Create a performance point for a given frame size and frame rate.
 *
 * @param width width of the frame in pixels
 * @param height height of the frame in pixels
 * @param frameRate frame rate in frames per second
 * @apiSince 29
 */

public PerformancePoint(int width, int height, int frameRate) { throw new RuntimeException("Stub!"); }

/**
 * Convert to a debug string
 * @apiSince 29
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the performance point covers a media format.
 *
 * @param format Stream format considered
 *
 * This value must never be {@code null}.
 * @return {@code true} if the performance point covers the format.
 * @apiSince 29
 */

public boolean covers(@androidx.annotation.NonNull android.media.MediaFormat format) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the performance point covers another performance point. Use this
 * method to determine if a performance point advertised by a codec covers the
 * performance point required. This method can also be used for loose ordering as this
 * method is transitive.
 *
 * @param other other performance point considered
 *
 * This value must never be {@code null}.
 * @return {@code true} if the performance point covers the other.
 * @apiSince 29
 */

public boolean covers(@androidx.annotation.NonNull android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint other) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * 1080p 100fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_100;
static { FHD_100 = null; }

/**
 * 1080p 120fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_120;
static { FHD_120 = null; }

/**
 * 1080p 200fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_200;
static { FHD_200 = null; }

/**
 * 1080p 24fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_24;
static { FHD_24 = null; }

/**
 * 1080p 240fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_240;
static { FHD_240 = null; }

/**
 * 1080p 25fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_25;
static { FHD_25 = null; }

/**
 * 1080p 30fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_30;
static { FHD_30 = null; }

/**
 * 1080p 50fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_50;
static { FHD_50 = null; }

/**
 * 1080p 60fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint FHD_60;
static { FHD_60 = null; }

/**
 * 720p 100fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_100;
static { HD_100 = null; }

/**
 * 720p 120fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_120;
static { HD_120 = null; }

/**
 * 720p 200fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_200;
static { HD_200 = null; }

/**
 * 720p 24fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_24;
static { HD_24 = null; }

/**
 * 720p 240fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_240;
static { HD_240 = null; }

/**
 * 720p 25fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_25;
static { HD_25 = null; }

/**
 * 720p 30fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_30;
static { HD_30 = null; }

/**
 * 720p 50fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_50;
static { HD_50 = null; }

/**
 * 720p 60fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint HD_60;
static { HD_60 = null; }

/**
 * 480p 24fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint SD_24;
static { SD_24 = null; }

/**
 * 576p 25fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint SD_25;
static { SD_25 = null; }

/**
 * 480p 30fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint SD_30;
static { SD_30 = null; }

/**
 * 480p 48fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint SD_48;
static { SD_48 = null; }

/**
 * 576p 50fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint SD_50;
static { SD_50 = null; }

/**
 * 480p 60fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint SD_60;
static { SD_60 = null; }

/**
 * 2160p 100fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_100;
static { UHD_100 = null; }

/**
 * 2160p 120fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_120;
static { UHD_120 = null; }

/**
 * 2160p 200fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_200;
static { UHD_200 = null; }

/**
 * 2160p 24fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_24;
static { UHD_24 = null; }

/**
 * 2160p 240fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_240;
static { UHD_240 = null; }

/**
 * 2160p 25fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_25;
static { UHD_25 = null; }

/**
 * 2160p 30fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_30;
static { UHD_30 = null; }

/**
 * 2160p 50fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_50;
static { UHD_50 = null; }

/**
 * 2160p 60fps
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint UHD_60;
static { UHD_60 = null; }
}

}

}

