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


package android.view;

import android.content.Context;
import android.os.Handler;

/**
 * Detects various gestures and events using the supplied {@link android.view.MotionEvent MotionEvent}s.
 * The {@link android.view.GestureDetector.OnGestureListener OnGestureListener} callback will notify users when a particular
 * motion event has occurred. This class should only be used with {@link android.view.MotionEvent MotionEvent}s
 * reported via touch (don't use for trackball events).
 *
 * To use this class:
 * <ul>
 *  <li>Create an instance of the {@code GestureDetector} for your {@link android.view.View View}
 *  <li>In the {@link android.view.View#onTouchEvent(android.view.MotionEvent) View#onTouchEvent(MotionEvent)} method ensure you call
 *          {@link #onTouchEvent(android.view.MotionEvent)}. The methods defined in your callback
 *          will be executed when the events occur.
 *  <li>If listening for {@link android.view.GestureDetector.OnContextClickListener#onContextClick(android.view.MotionEvent) OnContextClickListener#onContextClick(MotionEvent)}
 *          you must call {@link #onGenericMotionEvent(android.view.MotionEvent)}
 *          in {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)}.
 * </ul>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GestureDetector {

/**
 * Creates a GestureDetector with the supplied listener.
 * This variant of the constructor should be used from a non-UI thread
 * (as it allows specifying the Handler).
 *
 * @param listener the listener invoked for all the callbacks, this must
 * not be null.
 * @param handler the handler to use
 *
 * @throws java.lang.NullPointerException if either {@code listener} or
 * {@code handler} is null.
 *
 * @deprecated Use {@link #GestureDetector(android.content.Context,android.view.GestureDetector.OnGestureListener,android.os.Handler)} instead.
 * @apiSince 1
 */

@Deprecated
public GestureDetector(android.view.GestureDetector.OnGestureListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Creates a GestureDetector with the supplied listener.
 * You may only use this constructor from a UI thread (this is the usual situation).
 * @see android.os.Handler#Handler()
 *
 * @param listener the listener invoked for all the callbacks, this must
 * not be null.
 *
 * @throws java.lang.NullPointerException if {@code listener} is null.
 *
 * @deprecated Use {@link #GestureDetector(android.content.Context,android.view.GestureDetector.OnGestureListener)} instead.
 * @apiSince 1
 */

@Deprecated
public GestureDetector(android.view.GestureDetector.OnGestureListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Creates a GestureDetector with the supplied listener.
 * You may only use this constructor from a {@link android.os.Looper} thread.
 * @see android.os.Handler#Handler()
 *
 * @param context the application's context
 * @param listener the listener invoked for all the callbacks, this must
 * not be null.
 *
 * @throws java.lang.NullPointerException if {@code listener} is null.
 * @apiSince 3
 */

public GestureDetector(android.content.Context context, android.view.GestureDetector.OnGestureListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Creates a GestureDetector with the supplied listener that runs deferred events on the
 * thread associated with the supplied {@link android.os.Handler}.
 * @see android.os.Handler#Handler()
 *
 * @param context the application's context
 * @param listener the listener invoked for all the callbacks, this must
 * not be null.
 * @param handler the handler to use for running deferred listener events.
 *
 * @throws java.lang.NullPointerException if {@code listener} is null.
 * @apiSince 3
 */

public GestureDetector(android.content.Context context, android.view.GestureDetector.OnGestureListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Creates a GestureDetector with the supplied listener that runs deferred events on the
 * thread associated with the supplied {@link android.os.Handler}.
 * @see android.os.Handler#Handler()
 *
 * @param context the application's context
 * @param listener the listener invoked for all the callbacks, this must
 * not be null.
 * @param handler the handler to use for running deferred listener events.
 * @param unused currently not used.
 *
 * @throws java.lang.NullPointerException if {@code listener} is null.
 * @apiSince 8
 */

public GestureDetector(android.content.Context context, android.view.GestureDetector.OnGestureListener listener, android.os.Handler handler, boolean unused) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener which will be called for double-tap and related
 * gestures.
 *
 * @param onDoubleTapListener the listener invoked for all the callbacks, or
 *        null to stop listening for double-tap gestures.
 * @apiSince 3
 */

public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener onDoubleTapListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener which will be called for context clicks.
 *
 * @param onContextClickListener the listener invoked for all the callbacks, or null to stop
 *            listening for context clicks.
 * @apiSince 23
 */

public void setContextClickListener(android.view.GestureDetector.OnContextClickListener onContextClickListener) { throw new RuntimeException("Stub!"); }

/**
 * Set whether longpress is enabled, if this is enabled when a user
 * presses and holds down you get a longpress event and nothing further.
 * If it's disabled the user can press and hold down and then later
 * moved their finger and you will get scroll events. By default
 * longpress is enabled.
 *
 * @param isLongpressEnabled whether longpress should be enabled.
 * @apiSince 1
 */

public void setIsLongpressEnabled(boolean isLongpressEnabled) { throw new RuntimeException("Stub!"); }

/**
 * @return true if longpress is enabled, else false.
 * @apiSince 1
 */

public boolean isLongpressEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Analyzes the given motion event and if applicable triggers the
 * appropriate callbacks on the {@link android.view.GestureDetector.OnGestureListener OnGestureListener} supplied.
 *
 * @param ev The current motion event.
 * @return true if the {@link android.view.GestureDetector.OnGestureListener OnGestureListener} consumed the event,
 *              else false.
 * @apiSince 1
 */

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * Analyzes the given generic motion event and if applicable triggers the
 * appropriate callbacks on the {@link android.view.GestureDetector.OnGestureListener OnGestureListener} supplied.
 *
 * @param ev The current motion event.
 * @return true if the {@link android.view.GestureDetector.OnGestureListener OnGestureListener} consumed the event,
 *              else false.
 * @apiSince 23
 */

public boolean onGenericMotionEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }
/**
 * The listener that is used to notify when a context click occurs. When listening for a
 * context click ensure that you call {@link #onGenericMotionEvent(android.view.MotionEvent)} in
 * {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnContextClickListener {

/**
 * Notified when a context click occurs.
 *
 * @param e The motion event that occurred during the context click.
 * @return true if the event is consumed, else false
 * @apiSince 23
 */

public boolean onContextClick(android.view.MotionEvent e);
}

/**
 * The listener that is used to notify when a double-tap or a confirmed
 * single-tap occur.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDoubleTapListener {

/**
 * Notified when a single-tap occurs.
 * <p>
 * Unlike {@link android.view.GestureDetector.OnGestureListener#onSingleTapUp(android.view.MotionEvent) OnGestureListener#onSingleTapUp(MotionEvent)}, this
 * will only be called after the detector is confident that the user's
 * first tap is not followed by a second tap leading to a double-tap
 * gesture.
 *
 * @param e The down motion event of the single-tap.
 * @return true if the event is consumed, else false
 * @apiSince 3
 */

public boolean onSingleTapConfirmed(android.view.MotionEvent e);

/**
 * Notified when a double-tap occurs.
 *
 * @param e The down motion event of the first tap of the double-tap.
 * @return true if the event is consumed, else false
 * @apiSince 3
 */

public boolean onDoubleTap(android.view.MotionEvent e);

/**
 * Notified when an event within a double-tap gesture occurs, including
 * the down, move, and up events.
 *
 * @param e The motion event that occurred during the double-tap gesture.
 * @return true if the event is consumed, else false
 * @apiSince 3
 */

public boolean onDoubleTapEvent(android.view.MotionEvent e);
}

/**
 * The listener that is used to notify when gestures occur.
 * If you want to listen for all the different gestures then implement
 * this interface. If you only want to listen for a subset it might
 * be easier to extend {@link android.view.GestureDetector.SimpleOnGestureListener SimpleOnGestureListener}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGestureListener {

/**
 * Notified when a tap occurs with the down {@link android.view.MotionEvent MotionEvent}
 * that triggered it. This will be triggered immediately for
 * every down event. All other events should be preceded by this.
 *
 * @param e The down motion event.
 * @apiSince 1
 */

public boolean onDown(android.view.MotionEvent e);

/**
 * The user has performed a down {@link android.view.MotionEvent MotionEvent} and not performed
 * a move or up yet. This event is commonly used to provide visual
 * feedback to the user to let them know that their action has been
 * recognized i.e. highlight an element.
 *
 * @param e The down motion event
 * @apiSince 1
 */

public void onShowPress(android.view.MotionEvent e);

/**
 * Notified when a tap occurs with the up {@link android.view.MotionEvent MotionEvent}
 * that triggered it.
 *
 * @param e The up motion event that completed the first tap
 * @return true if the event is consumed, else false
 * @apiSince 1
 */

public boolean onSingleTapUp(android.view.MotionEvent e);

/**
 * Notified when a scroll occurs with the initial on down {@link android.view.MotionEvent MotionEvent} and the
 * current move {@link android.view.MotionEvent MotionEvent}. The distance in x and y is also supplied for
 * convenience.
 *
 * @param e1 The first down motion event that started the scrolling.
 * @param e2 The move motion event that triggered the current onScroll.
 * @param distanceX The distance along the X axis that has been scrolled since the last
 *              call to onScroll. This is NOT the distance between {@code e1}
 *              and {@code e2}.
 * @param distanceY The distance along the Y axis that has been scrolled since the last
 *              call to onScroll. This is NOT the distance between {@code e1}
 *              and {@code e2}.
 * @return true if the event is consumed, else false
 * @apiSince 1
 */

public boolean onScroll(android.view.MotionEvent e1, android.view.MotionEvent e2, float distanceX, float distanceY);

/**
 * Notified when a long press occurs with the initial on down {@link android.view.MotionEvent MotionEvent}
 * that trigged it.
 *
 * @param e The initial on down motion event that started the longpress.
 * @apiSince 1
 */

public void onLongPress(android.view.MotionEvent e);

/**
 * Notified of a fling event when it occurs with the initial on down {@link android.view.MotionEvent MotionEvent}
 * and the matching up {@link android.view.MotionEvent MotionEvent}. The calculated velocity is supplied along
 * the x and y axis in pixels per second.
 *
 * @param e1 The first down motion event that started the fling.
 * @param e2 The move motion event that triggered the current onFling.
 * @param velocityX The velocity of this fling measured in pixels per second
 *              along the x axis.
 * @param velocityY The velocity of this fling measured in pixels per second
 *              along the y axis.
 * @return true if the event is consumed, else false
 * @apiSince 1
 */

public boolean onFling(android.view.MotionEvent e1, android.view.MotionEvent e2, float velocityX, float velocityY);
}

/**
 * A convenience class to extend when you only want to listen for a subset
 * of all the gestures. This implements all methods in the
 * {@link android.view.GestureDetector.OnGestureListener OnGestureListener}, {@link android.view.GestureDetector.OnDoubleTapListener OnDoubleTapListener}, and {@link android.view.GestureDetector.OnContextClickListener OnContextClickListener}
 * but does nothing and return {@code false} for all applicable methods.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SimpleOnGestureListener implements android.view.GestureDetector.OnGestureListener, android.view.GestureDetector.OnDoubleTapListener, android.view.GestureDetector.OnContextClickListener {

public SimpleOnGestureListener() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onSingleTapUp(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onLongPress(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onScroll(android.view.MotionEvent e1, android.view.MotionEvent e2, float distanceX, float distanceY) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onFling(android.view.MotionEvent e1, android.view.MotionEvent e2, float velocityX, float velocityY) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onShowPress(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onDown(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onDoubleTap(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onDoubleTapEvent(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onSingleTapConfirmed(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean onContextClick(android.view.MotionEvent e) { throw new RuntimeException("Stub!"); }
}

}

