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

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import android.content.Context;
import android.net.Uri;
import java.io.FileDescriptor;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.os.PersistableBundle;

/**
 * MediaExtractor facilitates extraction of demuxed, typically encoded,  media data
 * from a data source.
 * <p>It is generally used like this:
 * <pre>
 * MediaExtractor extractor = new MediaExtractor();
 * extractor.setDataSource(...);
 * int numTracks = extractor.getTrackCount();
 * for (int i = 0; i &lt; numTracks; ++i) {
 *   MediaFormat format = extractor.getTrackFormat(i);
 *   String mime = format.getString(MediaFormat.KEY_MIME);
 *   if (weAreInterestedInThisTrack) {
 *     extractor.selectTrack(i);
 *   }
 * }
 * ByteBuffer inputBuffer = ByteBuffer.allocate(...)
 * while (extractor.readSampleData(inputBuffer, ...) &gt;= 0) {
 *   int trackIndex = extractor.getSampleTrackIndex();
 *   long presentationTimeUs = extractor.getSampleTime();
 *   ...
 *   extractor.advance();
 * }
 *
 * extractor.release();
 * extractor = null;
 * </pre>
 *
 * <p>This class requires the {@link android.Manifest.permission#INTERNET} permission
 * when used with network-based content.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaExtractor {

/** @apiSince 16 */

public MediaExtractor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (MediaDataSource) to use.
 *
 * @param dataSource the MediaDataSource for the media you want to extract from
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if dataSource is invalid.
 * @apiSince 23
 */

public native void setDataSource(@androidx.annotation.NonNull android.media.MediaDataSource dataSource) throws java.io.IOException;

/**
 * Sets the data source as a content Uri.
 *
 * @param context the Context to use when resolving the Uri
 * This value must never be {@code null}.
 * @param uri the Content URI of the data you want to extract from.
 *
 * <p>When <code>uri</code> refers to a network file the
 * {@link android.Manifest.permission#INTERNET} permission is required.
 *
 * This value must never be {@code null}.
 * @param headers the headers to be sent together with the request for the data.
 *        This can be {@code null} if no specific headers are to be sent with the
 *        request.
 
 * This value may be {@code null}.
 * @apiSince 16
 */

public void setDataSource(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> headers) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (file-path or http URL) to use.
 *
 * @param path the path of the file, or the http URL
 *
 * <p>When <code>path</code> refers to a network file the
 * {@link android.Manifest.permission#INTERNET} permission is required.
 *
 * This value must never be {@code null}.
 * @param headers the headers associated with the http request for the stream you want to play.
 *        This can be {@code null} if no specific headers are to be sent with the
 *        request.
 
 * This value may be {@code null}.
 * @apiSince 16
 */

public void setDataSource(@androidx.annotation.NonNull java.lang.String path, @androidx.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> headers) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (file-path or http URL) to use.
 *
 * @param path the path of the file, or the http URL of the stream
 *
 * <p>When <code>path</code> refers to a local file, the file may actually be opened by a
 * process other than the calling application.  This implies that the pathname
 * should be an absolute path (as any other process runs with unspecified current working
 * directory), and that the pathname should reference a world-readable file.
 * As an alternative, the application could first open the file for reading,
 * and then use the file descriptor form {@link #setDataSource(java.io.FileDescriptor)}.
 *
 * <p>When <code>path</code> refers to a network file the
 * {@link android.Manifest.permission#INTERNET} permission is required.
 
 * This value must never be {@code null}.
 * @apiSince 16
 */

public void setDataSource(@androidx.annotation.NonNull java.lang.String path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (AssetFileDescriptor) to use. It is the caller's
 * responsibility to close the file descriptor. It is safe to do so as soon
 * as this call returns.
 *
 * @param afd the AssetFileDescriptor for the file you want to extract from.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void setDataSource(@androidx.annotation.NonNull android.content.res.AssetFileDescriptor afd) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (FileDescriptor) to use. It is the caller's responsibility
 * to close the file descriptor. It is safe to do so as soon as this call returns.
 *
 * @param fd the FileDescriptor for the file you want to extract from.
 
 * This value must never be {@code null}.
 * @apiSince 16
 */

public void setDataSource(@androidx.annotation.NonNull java.io.FileDescriptor fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the data source (FileDescriptor) to use.  The FileDescriptor must be
 * seekable (N.B. a LocalSocket is not seekable). It is the caller's responsibility
 * to close the file descriptor. It is safe to do so as soon as this call returns.
 *
 * @param fd the FileDescriptor for the file you want to extract from.
 * This value must never be {@code null}.
 * @param offset the offset into the file where the data to be extracted starts, in bytes
 * @param length the length in bytes of the data to be extracted
 * @apiSince 16
 */

public native void setDataSource(@androidx.annotation.NonNull java.io.FileDescriptor fd, long offset, long length) throws java.io.IOException;

/**
 * Sets the MediaCas instance to use. This should be called after a
 * successful setDataSource() if at least one track reports mime type
 * of {@link android.media.MediaFormat#MIMETYPE_AUDIO_SCRAMBLED}
 * or {@link android.media.MediaFormat#MIMETYPE_VIDEO_SCRAMBLED}.
 * Stream parsing will not proceed until a valid MediaCas object
 * is provided.
 *
 * @param mediaCas the MediaCas object to use.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void setMediaCas(@androidx.annotation.NonNull android.media.MediaCas mediaCas) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the information about the conditional access system used to scramble
 * a track.
 *
 * @param index of the track.
 * @return an {@link android.media.MediaExtractor.CasInfo CasInfo} object describing the conditional access system.
 * @apiSince 26
 */

public android.media.MediaExtractor.CasInfo getCasInfo(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Make sure you call this when you're done to free up any resources
 * instead of relying on the garbage collector to do this for you at
 * some point in the future.
 * @apiSince 16
 */

public native void release();

/**
 * Count the number of tracks found in the data source.
 * @apiSince 16
 */

public native int getTrackCount();

/**
 * Extract DRM initialization data if it exists
 *
 * @return DRM initialization data in the content, or {@code null}
 * if no recognizable DRM format is found;
 * @see android.media.DrmInitData
 * @apiSince 24
 */

public android.media.DrmInitData getDrmInitData() { throw new RuntimeException("Stub!"); }

/**
 * Get the list of available audio presentations for the track.
 * @param trackIndex index of the track.
 * @return a list of available audio presentations for a given valid audio track index.
 * The list will be empty if the source does not contain any audio presentations.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.media.AudioPresentation> getAudioPresentations(int trackIndex) { throw new RuntimeException("Stub!"); }

/**
 * Get the PSSH info if present.
 * @return a map of uuid-to-bytes, with the uuid specifying
 * the crypto scheme, and the bytes being the data specific to that scheme.
 * This can be {@code null} if the source does not contain PSSH info.
 * @apiSince 18
 */

@androidx.annotation.Nullable
public java.util.Map<java.util.UUID,byte[]> getPsshInfo() { throw new RuntimeException("Stub!"); }

/**
 * Get the track format at the specified index.
 *
 * More detail on the representation can be found at {@link android.media.MediaCodec}
 * <p>
 * The following table summarizes support for format keys across android releases:
 *
 * <table style="width: 0%">
 *  <thead>
 *   <tr>
 *    <th rowspan=2>OS Version(s)</th>
 *    <td colspan=3>{@code MediaFormat} keys used for</th>
 *   </tr><tr>
 *    <th>All Tracks</th>
 *    <th>Audio Tracks</th>
 *    <th>Video Tracks</th>
 *   </tr>
 *  </thead>
 *  <tbody>
 *   <tr>
 *    <td>{@link android.os.Build.VERSION_CODES#JELLY_BEAN}</td>
 *    <td rowspan=8>{@link android.media.MediaFormat#KEY_MIME MediaFormat#KEY_MIME},<br>
 *        {@link android.media.MediaFormat#KEY_DURATION MediaFormat#KEY_DURATION},<br>
 *        {@link android.media.MediaFormat#KEY_MAX_INPUT_SIZE MediaFormat#KEY_MAX_INPUT_SIZE}</td>
 *    <td rowspan=5>{@link android.media.MediaFormat#KEY_SAMPLE_RATE MediaFormat#KEY_SAMPLE_RATE},<br>
 *        {@link android.media.MediaFormat#KEY_CHANNEL_COUNT MediaFormat#KEY_CHANNEL_COUNT},<br>
 *        {@link android.media.MediaFormat#KEY_CHANNEL_MASK MediaFormat#KEY_CHANNEL_MASK},<br>
 *        gapless playback information<sup>.mp3, .mp4</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_IS_ADTS MediaFormat#KEY_IS_ADTS}<sup>AAC if streaming</sup>,<br>
 *        codec-specific data<sup>AAC, Vorbis</sup></td>
 *    <td rowspan=2>{@link android.media.MediaFormat#KEY_WIDTH MediaFormat#KEY_WIDTH},<br>
 *        {@link android.media.MediaFormat#KEY_HEIGHT MediaFormat#KEY_HEIGHT},<br>
 *        codec-specific data<sup>AVC, MPEG4</sup></td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}</td>
 *    <td rowspan=3>as above, plus<br>
 *        Pixel aspect ratio information<sup>AVC, *</sup></td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#KITKAT}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#KITKAT_WATCH}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP}</td>
 *    <td rowspan=2>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_BIT_RATE MediaFormat#KEY_BIT_RATE}<sup>AAC</sup>,<br>
 *        codec-specific data<sup>Opus</sup></td>
 *    <td rowspan=2>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_ROTATION MediaFormat#KEY_ROTATION}<sup>.mp4</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_BIT_RATE MediaFormat#KEY_BIT_RATE}<sup>MPEG4</sup>,<br>
 *        codec-specific data<sup>HEVC</sup></td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#M}</td>
 *    <td>as above, plus<br>
 *        gapless playback information<sup>Opus</sup></td>
 *    <td>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_FRAME_RATE MediaFormat#KEY_FRAME_RATE} (integer)</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#N}</td>
 *    <td>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_TRACK_ID MediaFormat#KEY_TRACK_ID},<br>
 *        <!-- {link MediaFormat#KEY_MAX_BIT_RATE}<sup>#, .mp4</sup>,<br> -->
 *        {@link android.media.MediaFormat#KEY_BIT_RATE MediaFormat#KEY_BIT_RATE}<sup>#, .mp4</sup></td>
 *    <td>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_PCM_ENCODING MediaFormat#KEY_PCM_ENCODING},<br>
 *        {@link android.media.MediaFormat#KEY_PROFILE MediaFormat#KEY_PROFILE}<sup>AAC</sup></td>
 *    <td>as above, plus<br>
 *        {@link android.media.MediaFormat#KEY_HDR_STATIC_INFO MediaFormat#KEY_HDR_STATIC_INFO}<sup>#, .webm</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_COLOR_STANDARD MediaFormat#KEY_COLOR_STANDARD}<sup>#</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_COLOR_TRANSFER MediaFormat#KEY_COLOR_TRANSFER}<sup>#</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_COLOR_RANGE MediaFormat#KEY_COLOR_RANGE}<sup>#</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_PROFILE MediaFormat#KEY_PROFILE}<sup>MPEG2, H.263, MPEG4, AVC, HEVC, VP9</sup>,<br>
 *        {@link android.media.MediaFormat#KEY_LEVEL MediaFormat#KEY_LEVEL}<sup>H.263, MPEG4, AVC, HEVC, VP9</sup>,<br>
 *        codec-specific data<sup>VP9</sup></td>
 *   </tr>
 *   <tr>
 *    <td colspan=4>
 *     <p class=note><strong>Notes:</strong><br>
 *      #: container-specified value only.<br>
 *      .mp4, .webm&hellip;: for listed containers<br>
 *      MPEG4, AAC&hellip;: for listed codecs
 *    </td>
 *   </tr><tr>
 *    <td colspan=4>
 *     <p class=note>Note that that level information contained in the container many times
 *     does not match the level of the actual bitstream. You may want to clear the level using
 *     {@code MediaFormat.setString(KEY_LEVEL, null)} before using the track format to find a
 *     decoder that can play back a particular track.
 *    </td>
 *   </tr><tr>
 *    <td colspan=4>
 *     <p class=note><strong>*Pixel (sample) aspect ratio</strong> is returned in the following
 *     keys. The display width can be calculated for example as:
 *     <p align=center>
 *     display-width = display-height * crop-width / crop-height * sar-width / sar-height
 *    </td>
 *   </tr><tr>
 *    <th>Format Key</th><th>Value Type</th><th colspan=2>Description</th>
 *   </tr><tr>
 *    <td>{@code "sar-width"}</td><td>Integer</td><td colspan=2>Pixel aspect ratio width</td>
 *   </tr><tr>
 *    <td>{@code "sar-height"}</td><td>Integer</td><td colspan=2>Pixel aspect ratio height</td>
 *   </tr>
 *  </tbody>
 * </table>
 *
 * @apiSince 16
 */

@androidx.annotation.NonNull
public android.media.MediaFormat getTrackFormat(int index) { throw new RuntimeException("Stub!"); }

/**
 * Subsequent calls to {@link #readSampleData}, {@link #getSampleTrackIndex} and
 * {@link #getSampleTime} only retrieve information for the subset of tracks
 * selected.
 * Selecting the same track multiple times has no effect, the track is
 * only selected once.
 * @apiSince 16
 */

public native void selectTrack(int index);

/**
 * Subsequent calls to {@link #readSampleData}, {@link #getSampleTrackIndex} and
 * {@link #getSampleTime} only retrieve information for the subset of tracks
 * selected.
 * @apiSince 16
 */

public native void unselectTrack(int index);

/**
 * All selected tracks seek near the requested time according to the
 * specified mode.
 
 * @param mode Value is {@link android.media.MediaExtractor#SEEK_TO_PREVIOUS_SYNC}, {@link android.media.MediaExtractor#SEEK_TO_NEXT_SYNC}, or {@link android.media.MediaExtractor#SEEK_TO_CLOSEST_SYNC}
 * @apiSince 16
 */

public native void seekTo(long timeUs, int mode);

/**
 * Advance to the next sample. Returns false if no more sample data
 * is available (end of stream).
 *
 * When extracting a local file, the behaviors of {@link #advance} and
 * {@link #readSampleData} are undefined in presence of concurrent
 * writes to the same local file; more specifically, end of stream
 * could be signalled earlier than expected.
 * @apiSince 16
 */

public native boolean advance();

/**
 * Retrieve the current encoded sample and store it in the byte buffer
 * starting at the given offset.
 * <p>
 * <b>Note:</b>As of API 21, on success the position and limit of
 * {@code byteBuf} is updated to point to the data just read.
 * @param byteBuf the destination byte buffer
 * This value must never be {@code null}.
 * @return the sample size (or -1 if no more samples are available).
 * @apiSince 16
 */

public native int readSampleData(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuf, int offset);

/**
 * Returns the track index the current sample originates from (or -1
 * if no more samples are available)
 * @apiSince 16
 */

public native int getSampleTrackIndex();

/**
 * Returns the current sample's presentation time in microseconds.
 * or -1 if no more samples are available.
 * @apiSince 16
 */

public native long getSampleTime();

/**
 * @return size of the current sample in bytes or -1 if no more
 * samples are available.
 * @apiSince 28
 */

public native long getSampleSize();

/**
 * Returns the current sample's flags.
 
 * @return Value is either <code>0</code> or a combination of {@link android.media.MediaExtractor#SAMPLE_FLAG_SYNC}, {@link android.media.MediaExtractor#SAMPLE_FLAG_ENCRYPTED}, and {@link android.media.MediaExtractor#SAMPLE_FLAG_PARTIAL_FRAME}
 * @apiSince 16
 */

public native int getSampleFlags();

/**
 * If the sample flags indicate that the current sample is at least
 * partially encrypted, this call returns relevant information about
 * the structure of the sample data required for decryption.
 * @param info The android.media.MediaCodec.CryptoInfo structure
 *             to be filled in.
 * This value must never be {@code null}.
 * @return true iff the sample flags contain {@link #SAMPLE_FLAG_ENCRYPTED}
 * @apiSince 16
 */

public native boolean getSampleCryptoInfo(@androidx.annotation.NonNull android.media.MediaCodec.CryptoInfo info);

/**
 * Returns an estimate of how much data is presently cached in memory
 * expressed in microseconds. Returns -1 if that information is unavailable
 * or not applicable (no cache).
 * @apiSince 16
 */

public native long getCachedDuration();

/**
 * Returns true iff we are caching data and the cache has reached the
 * end of the data stream (for now, a future seek may of course restart
 * the fetching of data).
 * This API only returns a meaningful result if {@link #getCachedDuration}
 * indicates the presence of a cache, i.e. does NOT return -1.
 * @apiSince 16
 */

public native boolean hasCacheReachedEndOfStream();

/**
 *  Return Metrics data about the current media container.
 *
 * @return a {@link android.os.PersistableBundle PersistableBundle} containing the set of attributes and values
 * available for the media container being handled by this instance
 * of MediaExtractor.
 * The attributes are descibed in {@link android.media.MediaExtractor.MetricsConstants MetricsConstants}.
 *
 *  Additional vendor-specific fields may also be present in
 *  the return value.
 * @apiSince 26
 */

public android.os.PersistableBundle getMetrics() { throw new RuntimeException("Stub!"); }

/**
 * The sample is (at least partially) encrypted, see also the documentation
 * for {@link android.media.MediaCodec#queueSecureInputBuffer}
 * @apiSince 16
 */

public static final int SAMPLE_FLAG_ENCRYPTED = 2; // 0x2

/**
 * This indicates that the buffer only contains part of a frame,
 * and the decoder should batch the data until a buffer without
 * this flag appears before decoding the frame.
 *
 * @see android.media.MediaCodec#BUFFER_FLAG_PARTIAL_FRAME
 * @apiSince 26
 */

public static final int SAMPLE_FLAG_PARTIAL_FRAME = 4; // 0x4

/**
 * The sample is a sync sample (or in {@link android.media.MediaCodec MediaCodec}'s terminology
 * it is a key frame.)
 *
 * @see android.media.MediaCodec#BUFFER_FLAG_KEY_FRAME
 * @apiSince 16
 */

public static final int SAMPLE_FLAG_SYNC = 1; // 0x1

/**
 * If possible, seek to the sync sample closest to the specified time
 * @apiSince 16
 */

public static final int SEEK_TO_CLOSEST_SYNC = 2; // 0x2

/**
 * If possible, seek to a sync sample at or after the specified time
 * @apiSince 16
 */

public static final int SEEK_TO_NEXT_SYNC = 1; // 0x1

/**
 * If possible, seek to a sync sample at or before the specified time
 * @apiSince 16
 */

public static final int SEEK_TO_PREVIOUS_SYNC = 0; // 0x0
/**
 * Describes the conditional access system used to scramble a track.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CasInfo {

CasInfo() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the system id of the conditional access system.
 *
 * @return CA system id of the CAS used to scramble the track.
 * @apiSince 26
 */

public int getSystemId() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the private data in the CA_Descriptor associated with a track.
 * Some CAS systems may need this to initialize the CAS plugin object. This
 * private data can only be retrieved before a valid {@link android.media.MediaCas MediaCas} object
 * is set on the extractor.
 * <p>
 * @see android.media.MediaExtractor#setMediaCas
 * <p>
 * @return a byte array containing the private data. A null return value
 *         indicates that the private data is unavailable. An empty array,
 *         on the other hand, indicates that the private data is empty
 *         (zero in length).
 * @apiSince 29
 */

@androidx.annotation.Nullable
public byte[] getPrivateData() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the {@link android.media.MediaCas.Session MediaCas.Session} associated with a track. The
 * session is needed to initialize a descrambler in order to decode the
 * scrambled track. The session object can only be retrieved after a valid
 * {@link android.media.MediaCas MediaCas} object is set on the extractor.
 * <p>
 * @see android.media.MediaExtractor#setMediaCas
 * @see android.media.MediaDescrambler#setMediaCasSession
 * <p>
 * @return a {@link android.media.MediaCas.Session MediaCas.Session} object associated with a track.
 * @apiSince 26
 */

public android.media.MediaCas.Session getSession() { throw new RuntimeException("Stub!"); }
}

/** @apiSince 26 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MetricsConstants {

private MetricsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Key to extract the container format
 * from the {@link android.media.MediaExtractor#getMetrics MediaExtractor#getMetrics} return value.
 * The value is a String.
 * @apiSince 26
 */

public static final java.lang.String FORMAT = "android.media.mediaextractor.fmt";

/**
 * Key to extract the container MIME type
 * from the {@link android.media.MediaExtractor#getMetrics MediaExtractor#getMetrics} return value.
 * The value is a String.
 * @apiSince 26
 */

public static final java.lang.String MIME_TYPE = "android.media.mediaextractor.mime";

/**
 * Key to extract the number of tracks in the container
 * from the {@link android.media.MediaExtractor#getMetrics MediaExtractor#getMetrics} return value.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String TRACKS = "android.media.mediaextractor.ntrk";
}

}

