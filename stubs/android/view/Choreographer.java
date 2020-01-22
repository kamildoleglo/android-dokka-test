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


package android.view;

import android.os.Looper;
import android.os.SystemClock;

/**
 * Coordinates the timing of animations, input and drawing.
 * <p>
 * The choreographer receives timing pulses (such as vertical synchronization)
 * from the display subsystem then schedules work to occur as part of rendering
 * the next display frame.
 * </p><p>
 * Applications typically interact with the choreographer indirectly using
 * higher level abstractions in the animation framework or the view hierarchy.
 * Here are some examples of things you can do using the higher-level APIs.
 * </p>
 * <ul>
 * <li>To post an animation to be processed on a regular time basis synchronized with
 * display frame rendering, use {@link android.animation.ValueAnimator#start}.</li>
 * <li>To post a {@link java.lang.Runnable Runnable} to be invoked once at the beginning of the next display
 * frame, use {@link android.view.View#postOnAnimation View#postOnAnimation}.</li>
 * <li>To post a {@link java.lang.Runnable Runnable} to be invoked once at the beginning of the next display
 * frame after a delay, use {@link android.view.View#postOnAnimationDelayed View#postOnAnimationDelayed}.</li>
 * <li>To post a call to {@link android.view.View#invalidate() View#invalidate()} to occur once at the beginning of the
 * next display frame, use {@link android.view.View#postInvalidateOnAnimation() View#postInvalidateOnAnimation()} or
 * {@link android.view.View#postInvalidateOnAnimation(int,int,int,int) View#postInvalidateOnAnimation(int, int, int, int)}.</li>
 * <li>To ensure that the contents of a {@link android.view.View View} scroll smoothly and are drawn in
 * sync with display frame rendering, do nothing.  This already happens automatically.
 * {@link android.view.View#onDraw View#onDraw} will be called at the appropriate time.</li>
 * </ul>
 * <p>
 * However, there are a few cases where you might want to use the functions of the
 * choreographer directly in your application.  Here are some examples.
 * </p>
 * <ul>
 * <li>If your application does its rendering in a different thread, possibly using GL,
 * or does not use the animation framework or view hierarchy at all
 * and you want to ensure that it is appropriately synchronized with the display, then use
 * {@link android.view.Choreographer#postFrameCallback Choreographer#postFrameCallback}.</li>
 * <li>... and that's about it.</li>
 * </ul>
 * <p>
 * Each {@link android.os.Looper Looper} thread has its own choreographer.  Other threads can
 * post callbacks to run on the choreographer but they will run on the {@link android.os.Looper Looper}
 * to which the choreographer belongs.
 * </p>
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Choreographer {

private Choreographer() { throw new RuntimeException("Stub!"); }

/**
 * Gets the choreographer for the calling thread.  Must be called from
 * a thread that already has a {@link android.os.Looper} associated with it.
 *
 * @return The choreographer for this thread.
 * @throws java.lang.IllegalStateException if the thread does not have a looper.
 * @apiSince 16
 */

public static android.view.Choreographer getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Posts a frame callback to run on the next frame.
 * <p>
 * The callback runs once then is automatically removed.
 * </p>
 *
 * @param callback The frame callback to run during the next frame.
 *
 * @see #postFrameCallbackDelayed
 * @see #removeFrameCallback
 * @apiSince 16
 */

public void postFrameCallback(android.view.Choreographer.FrameCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Posts a frame callback to run on the next frame after the specified delay.
 * <p>
 * The callback runs once then is automatically removed.
 * </p>
 *
 * @param callback The frame callback to run during the next frame.
 * @param delayMillis The delay time in milliseconds.
 *
 * @see #postFrameCallback
 * @see #removeFrameCallback
 * @apiSince 16
 */

public void postFrameCallbackDelayed(android.view.Choreographer.FrameCallback callback, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Removes a previously posted frame callback.
 *
 * @param callback The frame callback to remove.
 *
 * @see #postFrameCallback
 * @see #postFrameCallbackDelayed
 * @apiSince 16
 */

public void removeFrameCallback(android.view.Choreographer.FrameCallback callback) { throw new RuntimeException("Stub!"); }
/**
 * Implement this interface to receive a callback when a new display frame is
 * being rendered.  The callback is invoked on the {@link android.os.Looper Looper} thread to
 * which the {@link android.view.Choreographer Choreographer} is attached.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface FrameCallback {

/**
 * Called when a new display frame is being rendered.
 * <p>
 * This method provides the time in nanoseconds when the frame started being rendered.
 * The frame time provides a stable time base for synchronizing animations
 * and drawing.  It should be used instead of {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()}
 * or {@link java.lang.System#nanoTime() System#nanoTime()} for animations and drawing in the UI.  Using the frame
 * time helps to reduce inter-frame jitter because the frame time is fixed at the time
 * the frame was scheduled to start, regardless of when the animations or drawing
 * callback actually runs.  All callbacks that run as part of rendering a frame will
 * observe the same frame time so using the frame time also helps to synchronize effects
 * that are performed by different callbacks.
 * </p><p>
 * Please note that the framework already takes care to process animations and
 * drawing using the frame time as a stable time base.  Most applications should
 * not need to use the frame time information directly.
 * </p>
 *
 * @param frameTimeNanos The time in nanoseconds when the frame started being rendered,
 * in the {@link java.lang.System#nanoTime() System#nanoTime()} timebase.  Divide this value by {@code 1000000}
 * to convert it to the {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()} time base.
 * @apiSince 16
 */

public void doFrame(long frameTimeNanos);
}

}

