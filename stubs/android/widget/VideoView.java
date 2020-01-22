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


package android.widget;

import android.media.AudioManager;
import android.media.AudioAttributes;
import android.media.MediaFormat;
import android.media.MediaPlayer;

/**
 * Displays a video file.  The VideoView class
 * can load images from various sources (such as resources or content
 * providers), takes care of computing its measurement from the video so that
 * it can be used in any layout manager, and provides various display options
 * such as scaling and tinting.<p>
 *
 * <em>Note: VideoView does not retain its full state when going into the
 * background.</em>  In particular, it does not restore the current play state,
 * play position, selected tracks, or any subtitle tracks added via
 * {@link #addSubtitleSource addSubtitleSource()}.  Applications should
 * save and restore these on their own in
 * {@link android.app.Activity#onSaveInstanceState} and
 * {@link android.app.Activity#onRestoreInstanceState}.<p>
 * Also note that the audio session id (from {@link #getAudioSessionId}) may
 * change from its previously returned value when the VideoView is restored.
 * <p>
 * By default, VideoView requests audio focus with {@link android.media.AudioManager#AUDIOFOCUS_GAIN AudioManager#AUDIOFOCUS_GAIN}. Use
 * {@link #setAudioFocusRequest(int)} to change this behavior.
 * <p>
 * The default {@link android.media.AudioAttributes AudioAttributes} used during playback have a usage of
 * {@link android.media.AudioAttributes#USAGE_MEDIA AudioAttributes#USAGE_MEDIA} and a content type of
 * {@link android.media.AudioAttributes#CONTENT_TYPE_MOVIE AudioAttributes#CONTENT_TYPE_MOVIE}, use {@link #setAudioAttributes(android.media.AudioAttributes)} to
 * modify them.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class VideoView extends android.view.SurfaceView implements android.widget.MediaController.MediaPlayerControl {

/** @apiSince 1 */

public VideoView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public VideoView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public VideoView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public VideoView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int resolveAdjustedSize(int desiredSize, int measureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Sets video path.
 *
 * @param path the path of the video.
 * @apiSince 1
 */

public void setVideoPath(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Sets video URI.
 *
 * @param uri the URI of the video.
 * @apiSince 1
 */

public void setVideoURI(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Sets video URI using specific headers.
 *
 * @param uri     the URI of the video.
 * @param headers the headers for the URI request.
 *                Note that the cross domain redirection is allowed by default, but that can be
 *                changed with key/value pairs through the headers parameter with
 *                "android-allow-cross-domain-redirect" as the key and "0" or "1" as the value
 *                to disallow or allow cross domain redirection.
 * @apiSince 21
 */

public void setVideoURI(android.net.Uri uri, java.util.Map<java.lang.String,java.lang.String> headers) { throw new RuntimeException("Stub!"); }

/**
 * Sets which type of audio focus will be requested during the playback, or configures playback
 * to not request audio focus. Valid values for focus requests are
 * {@link android.media.AudioManager#AUDIOFOCUS_GAIN AudioManager#AUDIOFOCUS_GAIN}, {@link android.media.AudioManager#AUDIOFOCUS_GAIN_TRANSIENT AudioManager#AUDIOFOCUS_GAIN_TRANSIENT},
 * {@link android.media.AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK}, and
 * {@link android.media.AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE AudioManager#AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE}. Or use
 * {@link android.media.AudioManager#AUDIOFOCUS_NONE AudioManager#AUDIOFOCUS_NONE} to express that audio focus should not be
 * requested when playback starts. You can for instance use this when playing a silent animation
 * through this class, and you don't want to affect other audio applications playing in the
 * background.
 * @param focusGain the type of audio focus gain that will be requested, or
 *    {@link android.media.AudioManager#AUDIOFOCUS_NONE AudioManager#AUDIOFOCUS_NONE} to disable the use audio focus during playback.
 * @apiSince 26
 */

public void setAudioFocusRequest(int focusGain) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.media.AudioAttributes AudioAttributes} to be used during the playback of the video.
 * @param attributes non-null <code>AudioAttributes</code>.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void setAudioAttributes(@androidx.annotation.NonNull android.media.AudioAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Adds an external subtitle source file (from the provided input stream.)
 *
 * Note that a single external subtitle source may contain multiple or no
 * supported tracks in it. If the source contained at least one track in
 * it, one will receive an {@link android.media.MediaPlayer#MEDIA_INFO_METADATA_UPDATE MediaPlayer#MEDIA_INFO_METADATA_UPDATE}
 * info message. Otherwise, if reading the source takes excessive time,
 * one will receive a {@link android.media.MediaPlayer#MEDIA_INFO_SUBTITLE_TIMED_OUT MediaPlayer#MEDIA_INFO_SUBTITLE_TIMED_OUT}
 * message. If the source contained no supported track (including an empty
 * source file or null input stream), one will receive a {@link android.media.MediaPlayer#MEDIA_INFO_UNSUPPORTED_SUBTITLE MediaPlayer#MEDIA_INFO_UNSUPPORTED_SUBTITLE} message. One can find the
 * total number of available tracks using {@link android.media.MediaPlayer#getTrackInfo() MediaPlayer#getTrackInfo()}
 * to see what additional tracks become available after this method call.
 *
 * @param is     input stream containing the subtitle data.  It will be
 *               closed by the media framework.
 * @param format the format of the subtitle track(s).  Must contain at least
 *               the mime type ({@link android.media.MediaFormat#KEY_MIME MediaFormat#KEY_MIME}) and the
 *               language ({@link android.media.MediaFormat#KEY_LANGUAGE MediaFormat#KEY_LANGUAGE}) of the file.
 *               If the file itself contains the language information,
 *               specify "und" for the language.
 * @apiSince 19
 */

public void addSubtitleSource(java.io.InputStream is, android.media.MediaFormat format) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void stopPlayback() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setMediaController(android.widget.MediaController controller) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the media file
 * is loaded and ready to go.
 *
 * @param l The callback that will be run
 * @apiSince 1
 */

public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the end of a media file
 * has been reached during playback.
 *
 * @param l The callback that will be run
 * @apiSince 1
 */

public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an error occurs
 * during playback or setup.  If no listener is specified,
 * or if the listener returned false, VideoView will inform
 * the user of any errors.
 *
 * @param l The callback that will be run
 * @apiSince 1
 */

public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an informational event
 * occurs during playback or setup.
 *
 * @param l The callback that will be run
 * @apiSince 17
 */

public void setOnInfoListener(android.media.MediaPlayer.OnInfoListener l) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTrackballEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void start() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void pause() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void suspend() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void resume() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getDuration() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getCurrentPosition() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void seekTo(int msec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isPlaying() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBufferPercentage() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean canPause() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean canSeekBackward() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean canSeekForward() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public int getAudioSessionId() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }
}

