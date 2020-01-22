/*
 * Copyright (C) 2013 The Android Open Source Project
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
 * Structure that groups a position in frame units relative to an assumed audio stream,
 * together with the estimated time when that frame enters or leaves the audio
 * processing pipeline on that device. This can be used to coordinate events
 * and interactions with the external environment.
 * <p>
 * The time is based on the implementation's best effort, using whatever knowledge
 * is available to the system, but cannot account for any delay unknown to the implementation.
 *
 * @see android.media.AudioTrack#getTimestamp AudioTrack.getTimestamp(AudioTimestamp)
 * @see android.media.AudioRecord#getTimestamp AudioRecord.getTimestamp(AudioTimestamp, int)
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioTimestamp {

public AudioTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Clock monotonic including suspend time or its equivalent on the system,
 * in the same units and timebase as {@link android.os.SystemClock#elapsedRealtimeNanos}.
 * @apiSince 24
 */

public static final int TIMEBASE_BOOTTIME = 1; // 0x1

/**
 * Clock monotonic or its equivalent on the system,
 * in the same units and timebase as {@link java.lang.System#nanoTime}.
 * @apiSince 24
 */

public static final int TIMEBASE_MONOTONIC = 0; // 0x0

/**
 * Position in frames relative to start of an assumed audio stream.
 * <p>
 * When obtained through
 * {@link android.media.AudioRecord#getTimestamp AudioRecord#getTimestamp},
 * all 64 bits of position are valid.
 * <p>
 * When obtained through
 * {@link android.media.AudioTrack#getTimestamp AudioTrack#getTimestamp},
 * the low-order 32 bits of position is in wrapping frame units similar to
 * {@link android.media.AudioTrack#getPlaybackHeadPosition AudioTrack#getPlaybackHeadPosition}.
 * @apiSince 19
 */

public long framePosition;

/**
 * Time associated with the frame in the audio pipeline.
 * <p>
 * When obtained through
 * {@link android.media.AudioRecord#getTimestamp AudioRecord#getTimestamp},
 * this is the estimated time in nanoseconds when the frame referred to by
 * {@link #framePosition} was captured. The timebase is either
 * {@link #TIMEBASE_MONOTONIC} or {@link #TIMEBASE_BOOTTIME}, depending
 * on the timebase parameter used in
 * {@link android.media.AudioRecord#getTimestamp AudioRecord#getTimestamp}.
 * <p>
 * When obtained through
 * {@link android.media.AudioTrack#getTimestamp AudioTrack#getTimestamp},
 * this is the estimated time when the frame was presented or is committed to be presented,
 * with a timebase of {@link #TIMEBASE_MONOTONIC}.
 * @apiSince 19
 */

public long nanoTime;
}

