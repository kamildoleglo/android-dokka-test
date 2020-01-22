/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.os.Handler;

/**
 * Detects scaling transformation gestures using the supplied {@link android.view.MotionEvent MotionEvent}s.
 * The {@link android.view.ScaleGestureDetector.OnScaleGestureListener OnScaleGestureListener} callback will notify users when a particular
 * gesture event has occurred.
 *
 * This class should only be used with {@link android.view.MotionEvent MotionEvent}s reported via touch.
 *
 * To use this class:
 * <ul>
 *  <li>Create an instance of the {@code ScaleGestureDetector} for your
 *      {@link android.view.View View}
 *  <li>In the {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)} method ensure you call
 *          {@link #onTouchEvent(android.view.MotionEvent)}. The methods defined in your
 *          callback will be executed when the events occur.
 * </ul>
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScaleGestureDetector {

/**
 * Creates a ScaleGestureDetector with the supplied listener.
 * You may only use this constructor from a {@link android.os.Looper Looper} thread.
 *
 * @param context the application's context
 * @param listener the listener invoked for all the callbacks, this must
 * not be null.
 *
 * @throws java.lang.NullPointerException if {@code listener} is null.
 * @apiSince 8
 */

public ScaleGestureDetector(android.content.Context context, android.view.ScaleGestureDetector.OnScaleGestureListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Creates a ScaleGestureDetector with the supplied listener.
 * @see android.os.Handler#Handler()
 *
 * @param context the application's context
 * @param listener the listener invoked for all the callbacks, this must
 * not be null.
 * @param handler the handler to use for running deferred listener events.
 *
 * @throws java.lang.NullPointerException if {@code listener} is null.
 * @apiSince 19
 */

public ScaleGestureDetector(android.content.Context context, android.view.ScaleGestureDetector.OnScaleGestureListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Accepts MotionEvents and dispatches events to a {@link android.view.ScaleGestureDetector.OnScaleGestureListener OnScaleGestureListener}
 * when appropriate.
 *
 * <p>Applications should pass a complete and consistent event stream to this method.
 * A complete and consistent event stream involves all MotionEvents from the initial
 * ACTION_DOWN to the final ACTION_UP or ACTION_CANCEL.</p>
 *
 * @param event The event to process
 * @return true if the event was processed and the detector wants to receive the
 *         rest of the MotionEvents in this event stream.
 * @apiSince 8
 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the associated {@link android.view.ScaleGestureDetector.OnScaleGestureListener OnScaleGestureListener} should receive onScale callbacks
 * when the user performs a doubleTap followed by a swipe. Note that this is enabled by default
 * if the app targets API 19 and newer.
 * @param scales true to enable quick scaling, false to disable
 * @apiSince 19
 */

public void setQuickScaleEnabled(boolean scales) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the quick scale gesture, in which the user performs a double tap followed by a
 * swipe, should perform scaling. {@see #setQuickScaleEnabled(boolean)}.
 * @apiSince 19
 */

public boolean isQuickScaleEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the associates {@link android.view.ScaleGestureDetector.OnScaleGestureListener OnScaleGestureListener} should receive
 * onScale callbacks when the user uses a stylus and presses the button.
 * Note that this is enabled by default if the app targets API 23 and newer.
 *
 * @param scales true to enable stylus scaling, false to disable.
 * @apiSince 23
 */

public void setStylusScaleEnabled(boolean scales) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the stylus scale gesture, in which the user uses a stylus and presses the
 * button, should perform scaling. {@see #setStylusScaleEnabled(boolean)}
 * @apiSince 23
 */

public boolean isStylusScaleEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if a scale gesture is in progress.
 * @apiSince 8
 */

public boolean isInProgress() { throw new RuntimeException("Stub!"); }

/**
 * Get the X coordinate of the current gesture's focal point.
 * If a gesture is in progress, the focal point is between
 * each of the pointers forming the gesture.
 *
 * If {@link #isInProgress()} would return false, the result of this
 * function is undefined.
 *
 * @return X coordinate of the focal point in pixels.
 * @apiSince 8
 */

public float getFocusX() { throw new RuntimeException("Stub!"); }

/**
 * Get the Y coordinate of the current gesture's focal point.
 * If a gesture is in progress, the focal point is between
 * each of the pointers forming the gesture.
 *
 * If {@link #isInProgress()} would return false, the result of this
 * function is undefined.
 *
 * @return Y coordinate of the focal point in pixels.
 * @apiSince 8
 */

public float getFocusY() { throw new RuntimeException("Stub!"); }

/**
 * Return the average distance between each of the pointers forming the
 * gesture in progress through the focal point.
 *
 * @return Distance between pointers in pixels.
 * @apiSince 8
 */

public float getCurrentSpan() { throw new RuntimeException("Stub!"); }

/**
 * Return the average X distance between each of the pointers forming the
 * gesture in progress through the focal point.
 *
 * @return Distance between pointers in pixels.
 * @apiSince 11
 */

public float getCurrentSpanX() { throw new RuntimeException("Stub!"); }

/**
 * Return the average Y distance between each of the pointers forming the
 * gesture in progress through the focal point.
 *
 * @return Distance between pointers in pixels.
 * @apiSince 11
 */

public float getCurrentSpanY() { throw new RuntimeException("Stub!"); }

/**
 * Return the previous average distance between each of the pointers forming the
 * gesture in progress through the focal point.
 *
 * @return Previous distance between pointers in pixels.
 * @apiSince 8
 */

public float getPreviousSpan() { throw new RuntimeException("Stub!"); }

/**
 * Return the previous average X distance between each of the pointers forming the
 * gesture in progress through the focal point.
 *
 * @return Previous distance between pointers in pixels.
 * @apiSince 11
 */

public float getPreviousSpanX() { throw new RuntimeException("Stub!"); }

/**
 * Return the previous average Y distance between each of the pointers forming the
 * gesture in progress through the focal point.
 *
 * @return Previous distance between pointers in pixels.
 * @apiSince 11
 */

public float getPreviousSpanY() { throw new RuntimeException("Stub!"); }

/**
 * Return the scaling factor from the previous scale event to the current
 * event. This value is defined as
 * ({@link #getCurrentSpan()} / {@link #getPreviousSpan()}).
 *
 * @return The current scaling factor.
 * @apiSince 8
 */

public float getScaleFactor() { throw new RuntimeException("Stub!"); }

/**
 * Return the time difference in milliseconds between the previous
 * accepted scaling event and the current scaling event.
 *
 * @return Time difference since the last scaling event in milliseconds.
 * @apiSince 8
 */

public long getTimeDelta() { throw new RuntimeException("Stub!"); }

/**
 * Return the event time of the current event being processed.
 *
 * @return Current event time in milliseconds.
 * @apiSince 8
 */

public long getEventTime() { throw new RuntimeException("Stub!"); }
/**
 * The listener for receiving notifications when gestures occur.
 * If you want to listen for all the different gestures then implement
 * this interface. If you only want to listen for a subset it might
 * be easier to extend {@link android.view.ScaleGestureDetector.SimpleOnScaleGestureListener SimpleOnScaleGestureListener}.
 *
 * An application will receive events in the following order:
 * <ul>
 *  <li>One {@link android.view.ScaleGestureDetector.OnScaleGestureListener#onScaleBegin(android.view.ScaleGestureDetector) OnScaleGestureListener#onScaleBegin(ScaleGestureDetector)}
 *  <li>Zero or more {@link android.view.ScaleGestureDetector.OnScaleGestureListener#onScale(android.view.ScaleGestureDetector) OnScaleGestureListener#onScale(ScaleGestureDetector)}
 *  <li>One {@link android.view.ScaleGestureDetector.OnScaleGestureListener#onScaleEnd(android.view.ScaleGestureDetector) OnScaleGestureListener#onScaleEnd(ScaleGestureDetector)}
 * </ul>
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnScaleGestureListener {

/**
 * Responds to scaling events for a gesture in progress.
 * Reported by pointer motion.
 *
 * @param detector The detector reporting the event - use this to
 *          retrieve extended info about event state.
 * @return Whether or not the detector should consider this event
 *          as handled. If an event was not handled, the detector
 *          will continue to accumulate movement until an event is
 *          handled. This can be useful if an application, for example,
 *          only wants to update scaling factors if the change is
 *          greater than 0.01.
 * @apiSince 8
 */

public boolean onScale(android.view.ScaleGestureDetector detector);

/**
 * Responds to the beginning of a scaling gesture. Reported by
 * new pointers going down.
 *
 * @param detector The detector reporting the event - use this to
 *          retrieve extended info about event state.
 * @return Whether or not the detector should continue recognizing
 *          this gesture. For example, if a gesture is beginning
 *          with a focal point outside of a region where it makes
 *          sense, onScaleBegin() may return false to ignore the
 *          rest of the gesture.
 * @apiSince 8
 */

public boolean onScaleBegin(android.view.ScaleGestureDetector detector);

/**
 * Responds to the end of a scale gesture. Reported by existing
 * pointers going up.
 *
 * Once a scale has ended, {@link android.view.ScaleGestureDetector#getFocusX() ScaleGestureDetector#getFocusX()}
 * and {@link android.view.ScaleGestureDetector#getFocusY() ScaleGestureDetector#getFocusY()} will return focal point
 * of the pointers remaining on the screen.
 *
 * @param detector The detector reporting the event - use this to
 *          retrieve extended info about event state.
 * @apiSince 8
 */

public void onScaleEnd(android.view.ScaleGestureDetector detector);
}

/**
 * A convenience class to extend when you only want to listen for a subset
 * of scaling-related events. This implements all methods in
 * {@link android.view.ScaleGestureDetector.OnScaleGestureListener OnScaleGestureListener} but does nothing.
 * {@link android.view.ScaleGestureDetector.OnScaleGestureListener#onScale(android.view.ScaleGestureDetector) OnScaleGestureListener#onScale(ScaleGestureDetector)} returns
 * {@code false} so that a subclass can retrieve the accumulated scale
 * factor in an overridden onScaleEnd.
 * {@link android.view.ScaleGestureDetector.OnScaleGestureListener#onScaleBegin(android.view.ScaleGestureDetector) OnScaleGestureListener#onScaleBegin(ScaleGestureDetector)} returns
 * {@code true}.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SimpleOnScaleGestureListener implements android.view.ScaleGestureDetector.OnScaleGestureListener {

public SimpleOnScaleGestureListener() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public boolean onScale(android.view.ScaleGestureDetector detector) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public boolean onScaleBegin(android.view.ScaleGestureDetector detector) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void onScaleEnd(android.view.ScaleGestureDetector detector) { throw new RuntimeException("Stub!"); }
}

}

