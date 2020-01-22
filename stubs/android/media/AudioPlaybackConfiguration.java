/*
 * Copyright (C) 2016 The Android Open Source Project
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
 * The AudioPlaybackConfiguration class collects the information describing an audio playback
 * session.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioPlaybackConfiguration implements android.os.Parcelable {

AudioPlaybackConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.media.AudioAttributes AudioAttributes} of the corresponding player.
 * @return the audio attributes of the player
 * @apiSince 26
 */

public android.media.AudioAttributes getAudioAttributes() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.AudioPlaybackConfiguration> CREATOR;
static { CREATOR = null; }
}

