/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * Class encapsulating subtitle data, as received through the
 * {@link android.media.MediaPlayer.OnSubtitleDataListener MediaPlayer.OnSubtitleDataListener} interface.
 * The subtitle data includes:
 * <ul>
 * <li> the track index</li>
 * <li> the start time (in microseconds) of the data</li>
 * <li> the duration (in microseconds) of the data</li>
 * <li> the actual data.</li>
 * </ul>
 * The data is stored in a byte-array, and is encoded in one of the supported in-band
 * subtitle formats. The subtitle encoding is determined by the MIME type of the
 * {@link android.media.MediaPlayer.TrackInfo MediaPlayer.TrackInfo} of the subtitle track, one of
 * {@link android.media.MediaFormat#MIMETYPE_TEXT_CEA_608 MediaFormat#MIMETYPE_TEXT_CEA_608}, {@link android.media.MediaFormat#MIMETYPE_TEXT_CEA_708 MediaFormat#MIMETYPE_TEXT_CEA_708},
 * {@link android.media.MediaFormat#MIMETYPE_TEXT_VTT MediaFormat#MIMETYPE_TEXT_VTT}.
 * <p>
 * Here is an example of iterating over the tracks of a {@link android.media.MediaPlayer MediaPlayer}, and checking which
 * encoding is used for the subtitle tracks:
 * <p>
 * <pre class="prettyprint">
 * MediaPlayer mp = new MediaPlayer();
 * mp.setDataSource(myContentLocation);
 * mp.prepare(); // synchronous prepare, ready to use when method returns
 * final TrackInfo[] trackInfos = mp.getTrackInfo();
 * for (TrackInfo info : trackInfo) {
 *     if (info.getTrackType() == TrackInfo.MEDIA_TRACK_TYPE_SUBTITLE) {
 *         final String mime = info.getFormat().getString(MediaFormat.KEY_MIME);
 *         if (MediaFormat.MIMETYPE_TEXT_CEA_608.equals(mime) {
 *             // subtitle encoding is CEA 608
 *         } else if (MediaFormat.MIMETYPE_TEXT_CEA_708.equals(mime) {
 *             // subtitle encoding is CEA 708
 *         } else if (MediaFormat.MIMETYPE_TEXT_VTT.equals(mime) {
 *             // subtitle encoding is WebVTT
 *         }
 *     }
 * }
 * </pre>
 * <p>
 * See
 * {@link android.media.MediaPlayer#setOnSubtitleDataListener(android.media.MediaPlayer.OnSubtitleDataListener,android.os.Handler) MediaPlayer#setOnSubtitleDataListener(android.media.MediaPlayer.OnSubtitleDataListener, android.os.Handler)}
 * to receive subtitle data from a MediaPlayer object.
 *
 * @see android.media.MediaPlayer
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SubtitleData {

/**
 * Constructor.
 *
 * @param trackIndex the index of the media player track which contains this subtitle data.
 * @param startTimeUs the start time in microsecond for the subtitle data
 * @param durationUs the duration in microsecond for the subtitle data
 * @param data the data array for the subtitle data. It should not be null.
 *            No data copying is made.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public SubtitleData(int trackIndex, long startTimeUs, long durationUs, @androidx.annotation.NonNull byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the media player track which contains this subtitle data.
 * @return an index in the array returned by {@link android.media.MediaPlayer#getTrackInfo() MediaPlayer#getTrackInfo()}.
 * @apiSince 28
 */

public int getTrackIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the media time at which the subtitle should be displayed, expressed in microseconds.
 * @return the display start time for the subtitle
 * @apiSince 28
 */

public long getStartTimeUs() { throw new RuntimeException("Stub!"); }

/**
 * Returns the duration in microsecond during which the subtitle should be displayed.
 * @return the display duration for the subtitle
 * @apiSince 28
 */

public long getDurationUs() { throw new RuntimeException("Stub!"); }

/**
 * Returns the encoded data for the subtitle content.
 * Encoding format depends on the subtitle type, refer to
 * <a href="https://en.wikipedia.org/wiki/CEA-708">CEA 708</a>,
 * <a href="https://en.wikipedia.org/wiki/EIA-608">CEA/EIA 608</a> and
 * <a href="https://www.w3.org/TR/webvtt1/">WebVTT</a>, defined by the MIME type
 * of the subtitle track.
 * @return the encoded subtitle data
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public byte[] getData() { throw new RuntimeException("Stub!"); }
}

