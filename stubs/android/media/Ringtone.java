/*
 * Copyright (C) 2006 The Android Open Source Project
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
 * Ringtone provides a quick method for playing a ringtone, notification, or
 * other similar types of sounds.
 * <p>
 * For ways of retrieving {@link android.media.Ringtone Ringtone} objects or to show a ringtone
 * picker, see {@link android.media.RingtoneManager RingtoneManager}.
 *
 * @see android.media.RingtoneManager
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Ringtone {

Ringtone() { throw new RuntimeException("Stub!"); }

/**
 * Sets the stream type where this ringtone will be played.
 *
 * @param streamType The stream, see {@link android.media.AudioManager AudioManager}.
 * @deprecated use {@link #setAudioAttributes(android.media.AudioAttributes)}
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setStreamType(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the stream type where this ringtone will be played.
 *
 * @return The stream type, see {@link android.media.AudioManager AudioManager}.
 * @deprecated use of stream types is deprecated, see
 *     {@link #setAudioAttributes(android.media.AudioAttributes)}
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public int getStreamType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.media.AudioAttributes AudioAttributes} for this ringtone.
 * @param attributes the non-null attributes characterizing this ringtone.
 * @apiSince 21
 */

public void setAudioAttributes(android.media.AudioAttributes attributes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.media.AudioAttributes AudioAttributes} used by this object.
 * @return the {@link android.media.AudioAttributes AudioAttributes} that were set with
 *     {@link #setAudioAttributes(android.media.AudioAttributes)} or the default attributes if none were set.
 * @apiSince 21
 */

public android.media.AudioAttributes getAudioAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Sets the player to be looping or non-looping.
 * @param looping whether to loop or not.
 * @apiSince 28
 */

public void setLooping(boolean looping) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the looping mode was enabled on this player.
 * @return true if this player loops when playing.
 * @apiSince 28
 */

public boolean isLooping() { throw new RuntimeException("Stub!"); }

/**
 * Sets the volume on this player.
 * @param volume a raw scalar in range 0.0 to 1.0, where 0.0 mutes this player, and 1.0
 *   corresponds to no attenuation being applied.
 * @apiSince 28
 */

public void setVolume(float volume) { throw new RuntimeException("Stub!"); }

/**
 * Returns the volume scalar set on this player.
 * @return a value between 0.0f and 1.0f.
 * @apiSince 28
 */

public float getVolume() { throw new RuntimeException("Stub!"); }

/**
 * Returns a human-presentable title for ringtone. Looks in media
 * content provider. If not in either, uses the filename
 *
 * @param context A context used for querying.
 * @apiSince 1
 */

public java.lang.String getTitle(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Plays the ringtone.
 * @apiSince 1
 */

public void play() { throw new RuntimeException("Stub!"); }

/**
 * Stops a playing ringtone.
 * @apiSince 1
 */

public void stop() { throw new RuntimeException("Stub!"); }

/**
 * Whether this ringtone is currently playing.
 *
 * @return True if playing, false otherwise.
 * @apiSince 1
 */

public boolean isPlaying() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() { throw new RuntimeException("Stub!"); }
}

