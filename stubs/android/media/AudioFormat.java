/*
 * Copyright (C) 2008 The Android Open Source Project
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


/**
 * The {@link android.media.AudioFormat AudioFormat} class is used to access a number of audio format and
 * channel configuration constants. They are for instance used
 * in {@link android.media.AudioTrack AudioTrack} and {@link android.media.AudioRecord AudioRecord}, as valid values in individual parameters of
 * constructors like {@link android.media.AudioTrack#AudioTrack(int,int,int,int,int,int) AudioTrack#AudioTrack(int, int, int, int, int, int)}, where the fourth
 * parameter is one of the <code>AudioFormat.ENCODING_*</code> constants.
 * The <code>AudioFormat</code> constants are also used in {@link android.media.MediaFormat MediaFormat} to specify
 * audio related values commonly used in media, such as for {@link android.media.MediaFormat#KEY_CHANNEL_MASK MediaFormat#KEY_CHANNEL_MASK}.
 * <p>The {@link android.media.AudioFormat.Builder AudioFormat.Builder} class can be used to create instances of
 * the <code>AudioFormat</code> format class.
 * Refer to
 * {@link android.media.AudioFormat.Builder AudioFormat.Builder} for documentation on the mechanics of the configuration and building
 * of such instances. Here we describe the main concepts that the <code>AudioFormat</code> class
 * allow you to convey in each instance, they are:
 * <ol>
 * <li><a href="#sampleRate">sample rate</a>
 * <li><a href="#encoding">encoding</a>
 * <li><a href="#channelMask">channel masks</a>
 * </ol>
 * <p>Closely associated with the <code>AudioFormat</code> is the notion of an
 * <a href="#audioFrame">audio frame</a>, which is used throughout the documentation
 * to represent the minimum size complete unit of audio data.
 *
 * <h4 id="sampleRate">Sample rate</h4>
 * <p>Expressed in Hz, the sample rate in an <code>AudioFormat</code> instance expresses the number
 * of audio samples for each channel per second in the content you are playing or recording. It is
 * not the sample rate
 * at which content is rendered or produced. For instance a sound at a media sample rate of 8000Hz
 * can be played on a device operating at a sample rate of 48000Hz; the sample rate conversion is
 * automatically handled by the platform, it will not play at 6x speed.
 *
 * <p>As of API {@link android.os.Build.VERSION_CODES#M},
 * sample rates up to 192kHz are supported
 * for <code>AudioRecord</code> and <code>AudioTrack</code>, with sample rate conversion
 * performed as needed.
 * To improve efficiency and avoid lossy conversions, it is recommended to match the sample rate
 * for <code>AudioRecord</code> and <code>AudioTrack</code> to the endpoint device
 * sample rate, and limit the sample rate to no more than 48kHz unless there are special
 * device capabilities that warrant a higher rate.
 *
 * <h4 id="encoding">Encoding</h4>
 * <p>Audio encoding is used to describe the bit representation of audio data, which can be
 * either linear PCM or compressed audio, such as AC3 or DTS.
 * <p>For linear PCM, the audio encoding describes the sample size, 8 bits, 16 bits, or 32 bits,
 * and the sample representation, integer or float.
 * <ul>
 * <li> {@link #ENCODING_PCM_8BIT}: The audio sample is a 8 bit unsigned integer in the
 * range [0, 255], with a 128 offset for zero. This is typically stored as a Java byte in a
 * byte array or ByteBuffer. Since the Java byte is <em>signed</em>,
 * be careful with math operations and conversions as the most significant bit is inverted.
 * </li>
 * <li> {@link #ENCODING_PCM_16BIT}: The audio sample is a 16 bit signed integer
 * typically stored as a Java short in a short array, but when the short
 * is stored in a ByteBuffer, it is native endian (as compared to the default Java big endian).
 * The short has full range from [-32768, 32767],
 * and is sometimes interpreted as fixed point Q.15 data.
 * </li>
 * <li> {@link #ENCODING_PCM_FLOAT}: Introduced in
 * API {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this encoding specifies that
 * the audio sample is a 32 bit IEEE single precision float. The sample can be
 * manipulated as a Java float in a float array, though within a ByteBuffer
 * it is stored in native endian byte order.
 * The nominal range of <code>ENCODING_PCM_FLOAT</code> audio data is [-1.0, 1.0].
 * It is implementation dependent whether the positive maximum of 1.0 is included
 * in the interval. Values outside of the nominal range are clamped before
 * sending to the endpoint device. Beware that
 * the handling of NaN is undefined; subnormals may be treated as zero; and
 * infinities are generally clamped just like other values for <code>AudioTrack</code>
 * &ndash; try to avoid infinities because they can easily generate a NaN.
 * <br>
 * To achieve higher audio bit depth than a signed 16 bit integer short,
 * it is recommended to use <code>ENCODING_PCM_FLOAT</code> for audio capture, processing,
 * and playback.
 * Floats are efficiently manipulated by modern CPUs,
 * have greater precision than 24 bit signed integers,
 * and have greater dynamic range than 32 bit signed integers.
 * <code>AudioRecord</code> as of API {@link android.os.Build.VERSION_CODES#M} and
 * <code>AudioTrack</code> as of API {@link android.os.Build.VERSION_CODES#LOLLIPOP}
 * support <code>ENCODING_PCM_FLOAT</code>.
 * </li>
 * </ul>
 * <p>For compressed audio, the encoding specifies the method of compression,
 * for example {@link #ENCODING_AC3} and {@link #ENCODING_DTS}. The compressed
 * audio data is typically stored as bytes in
 * a byte array or ByteBuffer. When a compressed audio encoding is specified
 * for an <code>AudioTrack</code>, it creates a direct (non-mixed) track
 * for output to an endpoint (such as HDMI) capable of decoding the compressed audio.
 * For (most) other endpoints, which are not capable of decoding such compressed audio,
 * you will need to decode the data first, typically by creating a {@link android.media.MediaCodec MediaCodec}.
 * Alternatively, one may use {@link android.media.MediaPlayer MediaPlayer} for playback of compressed
 * audio files or streams.
 * <p>When compressed audio is sent out through a direct <code>AudioTrack</code>,
 * it need not be written in exact multiples of the audio access unit;
 * this differs from <code>MediaCodec</code> input buffers.
 *
 * <h4 id="channelMask">Channel mask</h4>
 * <p>Channel masks are used in <code>AudioTrack</code> and <code>AudioRecord</code> to describe
 * the samples and their arrangement in the audio frame. They are also used in the endpoint (e.g.
 * a USB audio interface, a DAC connected to headphones) to specify allowable configurations of a
 * particular device.
 * <br>As of API {@link android.os.Build.VERSION_CODES#M}, there are two types of channel masks:
 * channel position masks and channel index masks.
 *
 * <h5 id="channelPositionMask">Channel position masks</h5>
 * Channel position masks are the original Android channel masks, and are used since API
 * {@link android.os.Build.VERSION_CODES#BASE}.
 * For input and output, they imply a positional nature - the location of a speaker or a microphone
 * for recording or playback.
 * <br>For a channel position mask, each allowed channel position corresponds to a bit in the
 * channel mask. If that channel position is present in the audio frame, that bit is set,
 * otherwise it is zero. The order of the bits (from lsb to msb) corresponds to the order of that
 * position's sample in the audio frame.
 * <br>The canonical channel position masks by channel count are as follows:
 * <br><table>
 * <tr><td>channel count</td><td>channel position mask</td></tr>
 * <tr><td>1</td><td>{@link #CHANNEL_OUT_MONO}</td></tr>
 * <tr><td>2</td><td>{@link #CHANNEL_OUT_STEREO}</td></tr>
 * <tr><td>3</td><td>{@link #CHANNEL_OUT_STEREO} | {@link #CHANNEL_OUT_FRONT_CENTER}</td></tr>
 * <tr><td>4</td><td>{@link #CHANNEL_OUT_QUAD}</td></tr>
 * <tr><td>5</td><td>{@link #CHANNEL_OUT_QUAD} | {@link #CHANNEL_OUT_FRONT_CENTER}</td></tr>
 * <tr><td>6</td><td>{@link #CHANNEL_OUT_5POINT1}</td></tr>
 * <tr><td>7</td><td>{@link #CHANNEL_OUT_5POINT1} | {@link #CHANNEL_OUT_BACK_CENTER}</td></tr>
 * <tr><td>8</td><td>{@link #CHANNEL_OUT_7POINT1_SURROUND}</td></tr>
 * </table>
 * <br>These masks are an ORed composite of individual channel masks. For example
 * {@link #CHANNEL_OUT_STEREO} is composed of {@link #CHANNEL_OUT_FRONT_LEFT} and
 * {@link #CHANNEL_OUT_FRONT_RIGHT}.
 *
 * <h5 id="channelIndexMask">Channel index masks</h5>
 * Channel index masks are introduced in API {@link android.os.Build.VERSION_CODES#M}. They allow
 * the selection of a particular channel from the source or sink endpoint by number, i.e. the first
 * channel, the second channel, and so forth. This avoids problems with artificially assigning
 * positions to channels of an endpoint, or figuring what the i<sup>th</sup> position bit is within
 * an endpoint's channel position mask etc.
 * <br>Here's an example where channel index masks address this confusion: dealing with a 4 channel
 * USB device. Using a position mask, and based on the channel count, this would be a
 * {@link #CHANNEL_OUT_QUAD} device, but really one is only interested in channel 0
 * through channel 3. The USB device would then have the following individual bit channel masks:
 * {@link #CHANNEL_OUT_FRONT_LEFT},
 * {@link #CHANNEL_OUT_FRONT_RIGHT}, {@link #CHANNEL_OUT_BACK_LEFT}
 * and {@link #CHANNEL_OUT_BACK_RIGHT}. But which is channel 0 and which is
 * channel 3?
 * <br>For a channel index mask, each channel number is represented as a bit in the mask, from the
 * lsb (channel 0) upwards to the msb, numerically this bit value is
 * <code>1 << channelNumber</code>.
 * A set bit indicates that channel is present in the audio frame, otherwise it is cleared.
 * The order of the bits also correspond to that channel number's sample order in the audio frame.
 * <br>For the previous 4 channel USB device example, the device would have a channel index mask
 * <code>0xF</code>. Suppose we wanted to select only the first and the third channels; this would
 * correspond to a channel index mask <code>0x5</code> (the first and third bits set). If an
 * <code>AudioTrack</code> uses this channel index mask, the audio frame would consist of two
 * samples, the first sample of each frame routed to channel 0, and the second sample of each frame
 * routed to channel 2.
 * The canonical channel index masks by channel count are given by the formula
 * <code>(1 << channelCount) - 1</code>.
 *
 * <h5>Use cases</h5>
 * <ul>
 * <li><i>Channel position mask for an endpoint:</i> <code>CHANNEL_OUT_FRONT_LEFT</code>,
 *  <code>CHANNEL_OUT_FRONT_CENTER</code>, etc. for HDMI home theater purposes.
 * <li><i>Channel position mask for an audio stream:</i> Creating an <code>AudioTrack</code>
 *  to output movie content, where 5.1 multichannel output is to be written.
 * <li><i>Channel index mask for an endpoint:</i> USB devices for which input and output do not
 *  correspond to left or right speaker or microphone.
 * <li><i>Channel index mask for an audio stream:</i> An <code>AudioRecord</code> may only want the
 *  third and fourth audio channels of the endpoint (i.e. the second channel pair), and not care the
 *  about position it corresponds to, in which case the channel index mask is <code>0xC</code>.
 *  Multichannel <code>AudioRecord</code> sessions should use channel index masks.
 * </ul>
 * <h4 id="audioFrame">Audio Frame</h4>
 * <p>For linear PCM, an audio frame consists of a set of samples captured at the same time,
 * whose count and
 * channel association are given by the <a href="#channelMask">channel mask</a>,
 * and whose sample contents are specified by the <a href="#encoding">encoding</a>.
 * For example, a stereo 16 bit PCM frame consists of
 * two 16 bit linear PCM samples, with a frame size of 4 bytes.
 * For compressed audio, an audio frame may alternately
 * refer to an access unit of compressed data bytes that is logically grouped together for
 * decoding and bitstream access (e.g. {@link android.media.MediaCodec MediaCodec}),
 * or a single byte of compressed data (e.g. {@link android.media.AudioTrack#getBufferSizeInFrames() AudioTrack#getBufferSizeInFrames()}),
 * or the linear PCM frame result from decoding the compressed data
 * (e.g.{@link android.media.AudioTrack#getPlaybackHeadPosition() AudioTrack#getPlaybackHeadPosition()}),
 * depending on the context where audio frame is used.
 * For the purposes of {@link android.media.AudioFormat#getFrameSizeInBytes() AudioFormat#getFrameSizeInBytes()}, a compressed data format
 * returns a frame size of 1 byte.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioFormat implements android.os.Parcelable {

AudioFormat() { throw new RuntimeException("Stub!"); }

/**
 * Return the encoding.
 * See the section on <a href="#encoding">encodings</a> for more information about the different
 * types of supported audio encoding.
 * @return one of the values that can be set in {@link android.media.AudioFormat.Builder#setEncoding(int) Builder#setEncoding(int)} or
 * {@link android.media.AudioFormat#ENCODING_INVALID AudioFormat#ENCODING_INVALID} if not set.
 * @apiSince 21
 */

public int getEncoding() { throw new RuntimeException("Stub!"); }

/**
 * Return the sample rate.
 * @return one of the values that can be set in {@link android.media.AudioFormat.Builder#setSampleRate(int) Builder#setSampleRate(int)} or
 * {@link #SAMPLE_RATE_UNSPECIFIED} if not set.
 * @apiSince 21
 */

public int getSampleRate() { throw new RuntimeException("Stub!"); }

/**
 * Return the channel mask.
 * See the section on <a href="#channelMask">channel masks</a> for more information about
 * the difference between index-based masks(as returned by {@link #getChannelIndexMask()}) and
 * the position-based mask returned by this function.
 * @return one of the values that can be set in {@link android.media.AudioFormat.Builder#setChannelMask(int) Builder#setChannelMask(int)} or
 * {@link android.media.AudioFormat#CHANNEL_INVALID AudioFormat#CHANNEL_INVALID} if not set.
 * @apiSince 21
 */

public int getChannelMask() { throw new RuntimeException("Stub!"); }

/**
 * Return the channel index mask.
 * See the section on <a href="#channelMask">channel masks</a> for more information about
 * the difference between index-based masks, and position-based masks (as returned
 * by {@link #getChannelMask()}).
 * @return one of the values that can be set in {@link android.media.AudioFormat.Builder#setChannelIndexMask(int) Builder#setChannelIndexMask(int)} or
 * {@link android.media.AudioFormat#CHANNEL_INVALID AudioFormat#CHANNEL_INVALID} if not set or an invalid mask was used.
 * @apiSince 23
 */

public int getChannelIndexMask() { throw new RuntimeException("Stub!"); }

/**
 * Return the channel count.
 * @return the channel count derived from the channel position mask or the channel index mask.
 * Zero is returned if both the channel position mask and the channel index mask are not set.
 * @apiSince 23
 */

public int getChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the frame size in bytes.
 *
 * For PCM or PCM packed compressed data this is the size of a sample multiplied
 * by the channel count. For all other cases, including invalid/unset channel masks,
 * this will return 1 byte.
 * As an example, a stereo 16-bit PCM format would have a frame size of 4 bytes,
 * an 8 channel float PCM format would have a frame size of 32 bytes,
 * and a compressed data format (not packed in PCM) would have a frame size of 1 byte.
 *
 * Both {@link android.media.AudioRecord AudioRecord} or {@link android.media.AudioTrack AudioTrack} process data in multiples of
 * this frame size.
 *
 * @return The audio frame size in bytes corresponding to the encoding and the channel mask.
 
 * Value is 1 or greater
 * @apiSince 29
 */

public int getFrameSizeInBytes() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #CHANNEL_OUT_DEFAULT} or {@link #CHANNEL_IN_DEFAULT} instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int CHANNEL_CONFIGURATION_DEFAULT = 1; // 0x1

/**
 * @deprecated Use {@link #CHANNEL_INVALID} instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int CHANNEL_CONFIGURATION_INVALID = 0; // 0x0

/**
 * @deprecated Use {@link #CHANNEL_OUT_MONO} or {@link #CHANNEL_IN_MONO} instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int CHANNEL_CONFIGURATION_MONO = 2; // 0x2

/**
 * @deprecated Use {@link #CHANNEL_OUT_STEREO} or {@link #CHANNEL_IN_STEREO} instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int CHANNEL_CONFIGURATION_STEREO = 3; // 0x3

/**
 * Invalid audio channel mask
 * @apiSince 5
 */

public static final int CHANNEL_INVALID = 0; // 0x0

/** @apiSince 5 */

public static final int CHANNEL_IN_BACK = 32; // 0x20

/** @apiSince 5 */

public static final int CHANNEL_IN_BACK_PROCESSED = 512; // 0x200

/** @apiSince 5 */

public static final int CHANNEL_IN_DEFAULT = 1; // 0x1

/** @apiSince 5 */

public static final int CHANNEL_IN_FRONT = 16; // 0x10

/** @apiSince 5 */

public static final int CHANNEL_IN_FRONT_PROCESSED = 256; // 0x100

/** @apiSince 5 */

public static final int CHANNEL_IN_LEFT = 4; // 0x4

/** @apiSince 5 */

public static final int CHANNEL_IN_LEFT_PROCESSED = 64; // 0x40

/** @apiSince 5 */

public static final int CHANNEL_IN_MONO = 16; // 0x10

/** @apiSince 5 */

public static final int CHANNEL_IN_PRESSURE = 1024; // 0x400

/** @apiSince 5 */

public static final int CHANNEL_IN_RIGHT = 8; // 0x8

/** @apiSince 5 */

public static final int CHANNEL_IN_RIGHT_PROCESSED = 128; // 0x80

/** @apiSince 5 */

public static final int CHANNEL_IN_STEREO = 12; // 0xc

/** @apiSince 5 */

public static final int CHANNEL_IN_VOICE_DNLINK = 32768; // 0x8000

/** @apiSince 5 */

public static final int CHANNEL_IN_VOICE_UPLINK = 16384; // 0x4000

/** @apiSince 5 */

public static final int CHANNEL_IN_X_AXIS = 2048; // 0x800

/** @apiSince 5 */

public static final int CHANNEL_IN_Y_AXIS = 4096; // 0x1000

/** @apiSince 5 */

public static final int CHANNEL_IN_Z_AXIS = 8192; // 0x2000

/** @apiSince 5 */

public static final int CHANNEL_OUT_5POINT1 = 252; // 0xfc

/**
 * @deprecated Not the typical 7.1 surround configuration. Use {@link #CHANNEL_OUT_7POINT1_SURROUND} instead.
 * @apiSince 5
 * @deprecatedSince 23
 */

@Deprecated public static final int CHANNEL_OUT_7POINT1 = 1020; // 0x3fc

/** @apiSince 23 */

public static final int CHANNEL_OUT_7POINT1_SURROUND = 6396; // 0x18fc

/** @apiSince 5 */

public static final int CHANNEL_OUT_BACK_CENTER = 1024; // 0x400

/** @apiSince 5 */

public static final int CHANNEL_OUT_BACK_LEFT = 64; // 0x40

/** @apiSince 5 */

public static final int CHANNEL_OUT_BACK_RIGHT = 128; // 0x80

/**
 * Default audio channel mask
 * @apiSince 5
 */

public static final int CHANNEL_OUT_DEFAULT = 1; // 0x1

/** @apiSince 5 */

public static final int CHANNEL_OUT_FRONT_CENTER = 16; // 0x10

/** @apiSince 5 */

public static final int CHANNEL_OUT_FRONT_LEFT = 4; // 0x4

/** @apiSince 5 */

public static final int CHANNEL_OUT_FRONT_LEFT_OF_CENTER = 256; // 0x100

/** @apiSince 5 */

public static final int CHANNEL_OUT_FRONT_RIGHT = 8; // 0x8

/** @apiSince 5 */

public static final int CHANNEL_OUT_FRONT_RIGHT_OF_CENTER = 512; // 0x200

/** @apiSince 5 */

public static final int CHANNEL_OUT_LOW_FREQUENCY = 32; // 0x20

/** @apiSince 5 */

public static final int CHANNEL_OUT_MONO = 4; // 0x4

/** @apiSince 5 */

public static final int CHANNEL_OUT_QUAD = 204; // 0xcc

/** @apiSince 21 */

public static final int CHANNEL_OUT_SIDE_LEFT = 2048; // 0x800

/** @apiSince 21 */

public static final int CHANNEL_OUT_SIDE_RIGHT = 4096; // 0x1000

/** @apiSince 5 */

public static final int CHANNEL_OUT_STEREO = 12; // 0xc

/** @apiSince 5 */

public static final int CHANNEL_OUT_SURROUND = 1052; // 0x41c

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.AudioFormat> CREATOR;
static { CREATOR = null; }

/**
 * Audio data format: AAC ELD compressed
 * @apiSince 28
 */

public static final int ENCODING_AAC_ELD = 15; // 0xf

/**
 * Audio data format: AAC HE V1 compressed
 * @apiSince 28
 */

public static final int ENCODING_AAC_HE_V1 = 11; // 0xb

/**
 * Audio data format: AAC HE V2 compressed
 * @apiSince 28
 */

public static final int ENCODING_AAC_HE_V2 = 12; // 0xc

/**
 * Audio data format: AAC LC compressed
 * @apiSince 28
 */

public static final int ENCODING_AAC_LC = 10; // 0xa

/**
 * Audio data format: AAC xHE compressed
 * @apiSince 28
 */

public static final int ENCODING_AAC_XHE = 16; // 0x10

/**
 * Audio data format: AC-3 compressed
 * @apiSince 21
 */

public static final int ENCODING_AC3 = 5; // 0x5

/**
 * Audio data format: AC-4 sync frame transport format
 * @apiSince 28
 */

public static final int ENCODING_AC4 = 17; // 0x11

/**
 * Default audio data format
 * @apiSince 3
 */

public static final int ENCODING_DEFAULT = 1; // 0x1

/** Audio data format: Dolby MAT (Metadata-enhanced Audio Transmission)
 * Dolby MAT bitstreams are used to transmit Dolby TrueHD, channel-based PCM, or PCM with
 * metadata (object audio) over HDMI (e.g.&nbsp;Dolby Atmos content).
 *     * @apiSince 29
 */

public static final int ENCODING_DOLBY_MAT = 19; // 0x13

/** Audio data format: DOLBY TRUEHD compressed
 *     @apiSince 25
 */

public static final int ENCODING_DOLBY_TRUEHD = 14; // 0xe

/**
 * Audio data format: DTS compressed
 * @apiSince 23
 */

public static final int ENCODING_DTS = 7; // 0x7

/**
 * Audio data format: DTS HD compressed
 * @apiSince 23
 */

public static final int ENCODING_DTS_HD = 8; // 0x8

/**
 * Audio data format: E-AC-3 compressed
 * @apiSince 21
 */

public static final int ENCODING_E_AC3 = 6; // 0x6

/** Audio data format: E-AC-3-JOC compressed
 * E-AC-3-JOC streams can be decoded by downstream devices supporting {@link #ENCODING_E_AC3}.
 * Use {@link #ENCODING_E_AC3} as the AudioTrack encoding when the downstream device
 * supports {@link #ENCODING_E_AC3} but not {@link #ENCODING_E_AC3_JOC}.
 *     * @apiSince 28
 */

public static final int ENCODING_E_AC3_JOC = 18; // 0x12

/** Audio data format: compressed audio wrapped in PCM for HDMI
 * or S/PDIF passthrough.
 * IEC61937 uses a stereo stream of 16-bit samples as the wrapper.
 * So the channel mask for the track must be {@link #CHANNEL_OUT_STEREO}.
 * Data should be written to the stream in a short[] array.
 * If the data is written in a byte[] array then there may be endian problems
 * on some platforms when converting to short internally.
 * @apiSince 24
 */

public static final int ENCODING_IEC61937 = 13; // 0xd

/**
 * Invalid audio data format
 * @apiSince 3
 */

public static final int ENCODING_INVALID = 0; // 0x0

/**
 * Audio data format: MP3 compressed
 * @apiSince 28
 */

public static final int ENCODING_MP3 = 9; // 0x9

/**
 * Audio data format: OPUS compressed.
 * @apiSince R
 */

public static final int ENCODING_OPUS = 20; // 0x14

/**
 * Audio data format: PCM 16 bit per sample. Guaranteed to be supported by devices.
 * @apiSince 3
 */

public static final int ENCODING_PCM_16BIT = 2; // 0x2

/**
 * Audio data format: PCM 8 bit per sample. Not guaranteed to be supported by devices.
 * @apiSince 3
 */

public static final int ENCODING_PCM_8BIT = 3; // 0x3

/**
 * Audio data format: single-precision floating-point per sample
 * @apiSince 21
 */

public static final int ENCODING_PCM_FLOAT = 4; // 0x4

/** Sample rate will be a route-dependent value.
 * For AudioTrack, it is usually the sink sample rate,
 * and for AudioRecord it is usually the source sample rate.
 * @apiSince 24
 */

public static final int SAMPLE_RATE_UNSPECIFIED = 0; // 0x0
/**
 * Builder class for {@link android.media.AudioFormat AudioFormat} objects.
 * Use this class to configure and create an AudioFormat instance. By setting format
 * characteristics such as audio encoding, channel mask or sample rate, you indicate which
 * of those are to vary from the default behavior on this device wherever this audio format
 * is used. See {@link android.media.AudioFormat AudioFormat} for a complete description of the different parameters that
 * can be used to configure an <code>AudioFormat</code> instance.
 * <p>{@link android.media.AudioFormat AudioFormat} is for instance used in
 * {@link android.media.AudioTrack#AudioTrack(android.media.AudioAttributes,android.media.AudioFormat,int,int,int) AudioTrack#AudioTrack(AudioAttributes, AudioFormat, int, int, int)}. In this
 * constructor, every format characteristic set on the <code>Builder</code> (e.g. with
 * {@link #setSampleRate(int)}) will alter the default values used by an
 * <code>AudioTrack</code>. In this case for audio playback with <code>AudioTrack</code>, the
 * sample rate set in the <code>Builder</code> would override the platform output sample rate
 * which would otherwise be selected by default.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new Builder with none of the format characteristics set.
 * @apiSince 21
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new Builder from a given {@link android.media.AudioFormat AudioFormat}.
 * @param af the {@link android.media.AudioFormat AudioFormat} object whose data will be reused in the new Builder.
 * @apiSince 21
 */

public Builder(android.media.AudioFormat af) { throw new RuntimeException("Stub!"); }

/**
 * Combines all of the format characteristics that have been set and return a new
 * {@link android.media.AudioFormat AudioFormat} object.
 * @return a new {@link android.media.AudioFormat AudioFormat} object
 * @apiSince 21
 */

public android.media.AudioFormat build() { throw new RuntimeException("Stub!"); }

/**
 * Sets the data encoding format.
 * @param encoding the specified encoding or default.
 * Value is {@link android.media.AudioFormat#ENCODING_DEFAULT}, {@link android.media.AudioFormat#ENCODING_PCM_16BIT}, {@link android.media.AudioFormat#ENCODING_PCM_8BIT}, {@link android.media.AudioFormat#ENCODING_PCM_FLOAT}, {@link android.media.AudioFormat#ENCODING_AC3}, {@link android.media.AudioFormat#ENCODING_E_AC3}, {@link android.media.AudioFormat#ENCODING_DTS}, {@link android.media.AudioFormat#ENCODING_DTS_HD}, {@link android.media.AudioFormat#ENCODING_MP3}, {@link android.media.AudioFormat#ENCODING_AAC_LC}, {@link android.media.AudioFormat#ENCODING_AAC_HE_V1}, {@link android.media.AudioFormat#ENCODING_AAC_HE_V2}, {@link android.media.AudioFormat#ENCODING_IEC61937}, {@link android.media.AudioFormat#ENCODING_DOLBY_TRUEHD}, {@link android.media.AudioFormat#ENCODING_AAC_ELD}, {@link android.media.AudioFormat#ENCODING_AAC_XHE}, {@link android.media.AudioFormat#ENCODING_AC4}, {@link android.media.AudioFormat#ENCODING_E_AC3_JOC}, {@link android.media.AudioFormat#ENCODING_DOLBY_MAT}, or {@link android.media.AudioFormat#ENCODING_OPUS}
 * @return the same Builder instance.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 21
 */

public android.media.AudioFormat.Builder setEncoding(int encoding) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the channel position mask.
 * The channel position mask specifies the association between audio samples in a frame
 * with named endpoint channels. The samples in the frame correspond to the
 * named set bits in the channel position mask, in ascending bit order.
 * See {@link #setChannelIndexMask(int)} to specify channels
 * based on endpoint numbered channels. This <a href="#channelPositionMask>description of
 * channel position masks</a> covers the concept in more details.
 * @param channelMask describes the configuration of the audio channels.
 *    <p> For output, the channelMask can be an OR-ed combination of
 *    channel position masks, e.g.
 *    {@link android.media.AudioFormat#CHANNEL_OUT_FRONT_LEFT AudioFormat#CHANNEL_OUT_FRONT_LEFT},
 *    {@link android.media.AudioFormat#CHANNEL_OUT_FRONT_RIGHT AudioFormat#CHANNEL_OUT_FRONT_RIGHT},
 *    {@link android.media.AudioFormat#CHANNEL_OUT_FRONT_CENTER AudioFormat#CHANNEL_OUT_FRONT_CENTER},
 *    {@link android.media.AudioFormat#CHANNEL_OUT_LOW_FREQUENCY AudioFormat#CHANNEL_OUT_LOW_FREQUENCY}
 *    {@link android.media.AudioFormat#CHANNEL_OUT_BACK_LEFT AudioFormat#CHANNEL_OUT_BACK_LEFT},
 *    {@link android.media.AudioFormat#CHANNEL_OUT_BACK_RIGHT AudioFormat#CHANNEL_OUT_BACK_RIGHT},
 *    {@link android.media.AudioFormat#CHANNEL_OUT_BACK_CENTER AudioFormat#CHANNEL_OUT_BACK_CENTER},
 *    {@link android.media.AudioFormat#CHANNEL_OUT_SIDE_LEFT AudioFormat#CHANNEL_OUT_SIDE_LEFT},
 *    {@link android.media.AudioFormat#CHANNEL_OUT_SIDE_RIGHT AudioFormat#CHANNEL_OUT_SIDE_RIGHT}.
 *    <p> For a valid {@link android.media.AudioTrack AudioTrack} channel position mask,
 *    the following conditions apply:
 *    <br> (1) at most eight channel positions may be used;
 *    <br> (2) right/left pairs should be matched.
 *    <p> For input or {@link android.media.AudioRecord AudioRecord}, the mask should be
 *    {@link android.media.AudioFormat#CHANNEL_IN_MONO AudioFormat#CHANNEL_IN_MONO} or
 *    {@link android.media.AudioFormat#CHANNEL_IN_STEREO AudioFormat#CHANNEL_IN_STEREO}.  {@link android.media.AudioFormat#CHANNEL_IN_MONO AudioFormat#CHANNEL_IN_MONO} is
 *    guaranteed to work on all devices.
 * @return the same <code>Builder</code> instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the channel mask is invalid or
 *    if both channel index mask and channel position mask
 *    are specified but do not have the same channel count.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.media.AudioFormat.Builder setChannelMask(int channelMask) { throw new RuntimeException("Stub!"); }

/**
 * Sets the channel index mask.
 * A channel index mask specifies the association of audio samples in the frame
 * with numbered endpoint channels. The i-th bit in the channel index
 * mask corresponds to the i-th endpoint channel.
 * For example, an endpoint with four channels is represented
 * as index mask bits 0 through 3. This <a href="#channelIndexMask>description of channel
 * index masks</a> covers the concept in more details.
 * See {@link #setChannelMask(int)} for a positional mask interpretation.
 * <p> Both {@link android.media.AudioTrack AudioTrack} and {@link android.media.AudioRecord AudioRecord} support
 * a channel index mask.
 * If a channel index mask is specified it is used,
 * otherwise the channel position mask specified
 * by <code>setChannelMask</code> is used.
 * For <code>AudioTrack</code> and <code>AudioRecord</code>,
 * a channel position mask is not required if a channel index mask is specified.
 *
 * @param channelIndexMask describes the configuration of the audio channels.
 *    <p> For output, the <code>channelIndexMask</code> is an OR-ed combination of
 *    bits representing the mapping of <code>AudioTrack</code> write samples
 *    to output sink channels.
 *    For example, a mask of <code>0xa</code>, or binary <code>1010</code>,
 *    means the <code>AudioTrack</code> write frame consists of two samples,
 *    which are routed to the second and the fourth channels of the output sink.
 *    Unmatched output sink channels are zero filled and unmatched
 *    <code>AudioTrack</code> write samples are dropped.
 *    <p> For input, the <code>channelIndexMask</code> is an OR-ed combination of
 *    bits representing the mapping of input source channels to
 *    <code>AudioRecord</code> read samples.
 *    For example, a mask of <code>0x5</code>, or binary
 *    <code>101</code>, will read from the first and third channel of the input
 *    source device and store them in the first and second sample of the
 *    <code>AudioRecord</code> read frame.
 *    Unmatched input source channels are dropped and
 *    unmatched <code>AudioRecord</code> read samples are zero filled.
 * @return the same <code>Builder</code> instance.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the channel index mask is invalid or
 *    if both channel index mask and channel position mask
 *    are specified but do not have the same channel count.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.media.AudioFormat.Builder setChannelIndexMask(int channelIndexMask) { throw new RuntimeException("Stub!"); }

/**
 * Sets the sample rate.
 * @param sampleRate the sample rate expressed in Hz
 * @return the same Builder instance.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 21
 */

public android.media.AudioFormat.Builder setSampleRate(int sampleRate) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }
}

}

