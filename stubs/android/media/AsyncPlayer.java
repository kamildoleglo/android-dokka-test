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

import android.content.Context;
import android.net.Uri;

/**
 * Plays a series of audio URIs, but does all the hard work on another thread
 * so that any slowness with preparing or loading doesn't block the calling thread.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AsyncPlayer {

/**
 * Construct an AsyncPlayer object.
 *
 * @param tag a string to use for debugging
 * @apiSince 1
 */

public AsyncPlayer(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Start playing the sound.  It will actually start playing at some
 * point in the future.  There are no guarantees about latency here.
 * Calling this before another audio file is done playing will stop
 * that one and start the new one.
 *
 * @param context Your application's context.
 * @param uri The URI to play.  (see {@link android.media.MediaPlayer#setDataSource(android.content.Context,android.net.Uri) MediaPlayer#setDataSource(Context, Uri)})
 * @param looping Whether the audio should loop forever.
 *          (see {@link android.media.MediaPlayer#setLooping(boolean) MediaPlayer#setLooping(boolean)})
 * @param stream the AudioStream to use.
 *          (see {@link android.media.MediaPlayer#setAudioStreamType(int) MediaPlayer#setAudioStreamType(int)})
 * @deprecated use {@link #play(android.content.Context,android.net.Uri,boolean,android.media.AudioAttributes)} instead
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void play(android.content.Context context, android.net.Uri uri, boolean looping, int stream) { throw new RuntimeException("Stub!"); }

/**
 * Start playing the sound.  It will actually start playing at some
 * point in the future.  There are no guarantees about latency here.
 * Calling this before another audio file is done playing will stop
 * that one and start the new one.
 *
 * @param context the non-null application's context.
 * This value must never be {@code null}.
 * @param uri the non-null URI to play.  (see {@link android.media.MediaPlayer#setDataSource(android.content.Context,android.net.Uri) MediaPlayer#setDataSource(Context, Uri)})
 * This value must never be {@code null}.
 * @param looping whether the audio should loop forever.
 *          (see {@link android.media.MediaPlayer#setLooping(boolean) MediaPlayer#setLooping(boolean)})
 * @param attributes the non-null {@link android.media.AudioAttributes AudioAttributes} to use.
 *          (see {@link android.media.MediaPlayer#setAudioAttributes(android.media.AudioAttributes) MediaPlayer#setAudioAttributes(AudioAttributes)})
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 23
 */

public void play(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri, boolean looping, @androidx.annotation.NonNull android.media.AudioAttributes attributes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Stop a previously played sound.  It can't be played again or unpaused
 * at this point.  Calling this multiple times has no ill effects.
 * @apiSince 1
 */

public void stop() { throw new RuntimeException("Stub!"); }
}

