/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.graphics.drawable;

import android.graphics.ImageDecoder;
import android.graphics.PixelFormat;

/**
 * {@link android.graphics.drawable.Drawable Drawable} for drawing animated images (like GIF).
 *
 * <p>The framework handles decoding subsequent frames in another thread and
 * updating when necessary. The drawable will only animate while it is being
 * displayed.</p>
 *
 * <p>Created by {@link android.graphics.ImageDecoder#decodeDrawable ImageDecoder#decodeDrawable}. A user needs to call
 * {@link #start} to start the animation.</p>
 *
 * <p>It can also be defined in XML using the <code>&lt;animated-image></code>
 * element.</p>
 *
 * @attr ref android.R.styleable#AnimatedImageDrawable_src
 * @attr ref android.R.styleable#AnimatedImageDrawable_autoStart
 * @attr ref android.R.styleable#AnimatedImageDrawable_repeatCount
 * @attr ref android.R.styleable#AnimatedImageDrawable_autoMirrored
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnimatedImageDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable2 {

/**
 * Create an empty AnimatedImageDrawable.
 * @apiSince 28
 */

public AnimatedImageDrawable() { throw new RuntimeException("Stub!"); }

/**
 *  Specify the number of times to repeat the animation.
 *
 *  <p>By default, the repeat count in the encoded data is respected. If set
 *  to {@link #REPEAT_INFINITE}, the animation will repeat as long as it is
 *  displayed. If the value is {@code 0}, the animation will play once.</p>
 *
 *  <p>This call replaces the current repeat count. If the encoded data
 *  specified a repeat count of {@code 2} (meaning that
 *  {@link #getRepeatCount()} returns {@code 2}, the animation will play
 *  three times. Calling {@code setRepeatCount(1)} will result in playing only
 *  twice and {@link #getRepeatCount()} returning {@code 1}.</p>
 *
 *  <p>If the animation is already playing, the iterations that have already
 *  occurred count towards the new count. If the animation has already
 *  repeated the appropriate number of times (or more), it will finish its
 *  current iteration and then stop.</p>
 
 * @param repeatCount Value is REPEAT_INFINITE or greater
 * @apiSince 28
 */

public void setRepeatCount(int repeatCount) { throw new RuntimeException("Stub!"); }

/**
 *  Retrieve the number of times the animation will repeat.
 *
 *  <p>By default, the repeat count in the encoded data is respected. If the
 *  value is {@link #REPEAT_INFINITE}, the animation will repeat as long as
 *  it is displayed. If the value is {@code 0}, it will play once.</p>
 *
 *  <p>Calling {@link #setRepeatCount} will make future calls to this method
 *  return the value passed to {@link #setRepeatCount}.</p>
 * @apiSince 28
 */

public int getRepeatCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param canvas This value must never be {@code null}.
 * @apiSince 28
 */

public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param alpha Value is between 0 and 255 inclusive
 * @apiSince 28
 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param colorFilter This value may be {@code null}.
 * @apiSince 28
 */

public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is {@link android.graphics.PixelFormat#UNKNOWN}, {@link android.graphics.PixelFormat#TRANSLUCENT}, {@link android.graphics.PixelFormat#TRANSPARENT}, or {@link android.graphics.PixelFormat#OPAQUE}
 * @apiSince 28
 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean onLayoutDirectionChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

/**
 *  Return whether the animation is currently running.
 *
 *  <p>When this drawable is created, this will return {@code false}. A client
 *  needs to call {@link #start} to start the animation.</p>
 * @apiSince 28
 */

public boolean isRunning() { throw new RuntimeException("Stub!"); }

/**
 *  Start the animation.
 *
 *  <p>Does nothing if the animation is already running. If the animation is stopped,
 *  this will reset it.</p>
 *
 *  <p>When the drawable is drawn, starting the animation,
 *  {@link android.graphics.drawable.Animatable2.AnimationCallback#onAnimationStart Animatable2.AnimationCallback#onAnimationStart} will be called.</p>
 * @apiSince 28
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 *  Stop the animation.
 *
 *  <p>If the animation is stopped, it will continue to display the frame
 *  it was displaying when stopped.</p>
 * @apiSince 28
 */

public void stop() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param callback This value must never be {@code null}.
 * @apiSince 28
 */

public void registerAnimationCallback(@androidx.annotation.NonNull android.graphics.drawable.Animatable2.AnimationCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param callback This value must never be {@code null}.
 * @apiSince 28
 */

public boolean unregisterAnimationCallback(@androidx.annotation.NonNull android.graphics.drawable.Animatable2.AnimationCallback callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void clearAnimationCallbacks() { throw new RuntimeException("Stub!"); }

/**
 *  Pass this to {@link #setRepeatCount} to repeat infinitely.
 *
 *  <p>{@link android.graphics.drawable.Animatable2.AnimationCallback#onAnimationEnd Animatable2.AnimationCallback#onAnimationEnd} will never be
 *  called unless there is an error.</p>
 * @apiSince 28
 */

public static final int REPEAT_INFINITE = -1; // 0xffffffff
}

