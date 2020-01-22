/*
 * Copyright 2015 The Android Open Source Project
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
 * Class that embodies one timed metadata access unit, including
 *
 * <ul>
 * <li> a time stamp, and </li>
 * <li> raw uninterpreted byte-array extracted directly from the container. </li>
 * </ul>
 *
 * @see android.media.MediaPlayer#setOnTimedMetaDataAvailableListener(android.media.MediaPlayer.OnTimedMetaDataAvailableListener)
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TimedMetaData {

/**
 * Constructor.
 *
 * @param timestampUs the timestamp in microsecond for the timed metadata
 * @param metaData the metadata array for the timed metadata. No data copying is made.
 *     It should not be null.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public TimedMetaData(long timestampUs, @androidx.annotation.NonNull byte[] metaData) { throw new RuntimeException("Stub!"); }

/**
 * @return the timestamp associated with this metadata access unit in microseconds;
 * 0 denotes playback start.
 * @apiSince 23
 */

public long getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * @return raw, uninterpreted content of this metadata access unit; for ID3 tags this includes
 * everything starting from the 3 byte signature "ID3".
 * @apiSince 23
 */

public byte[] getMetaData() { throw new RuntimeException("Stub!"); }
}

