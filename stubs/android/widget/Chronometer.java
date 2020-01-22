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


package android.widget;

import android.os.SystemClock;

/**
 * Class that implements a simple timer.
 * <p>
 * You can give it a start time in the {@link android.os.SystemClock#elapsedRealtime SystemClock#elapsedRealtime} timebase,
 * and it counts up from that, or if you don't give it a base time, it will use the
 * time at which you call {@link #start}.
 *
 * <p>The timer can also count downward towards the base time by
 * setting {@link #setCountDown(boolean)} to true.
 *
 *  <p>By default it will display the current
 * timer value in the form "MM:SS" or "H:MM:SS", or you can use {@link #setFormat}
 * to format the timer value into an arbitrary string.
 *
 * @attr ref android.R.styleable#Chronometer_format
 * @attr ref android.R.styleable#Chronometer_countDown
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class Chronometer extends android.widget.TextView {

/**
 * Initialize this Chronometer object.
 * Sets the base to the current time.
 * @apiSince 1
 */

public Chronometer(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Initialize with standard view layout information.
 * Sets the base to the current time.
 * @apiSince 1
 */

public Chronometer(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Initialize with standard view layout information and style.
 * Sets the base to the current time.
 * @apiSince 1
 */

public Chronometer(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Chronometer(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Set this view to count down to the base instead of counting up from it.
 *
 * @param countDown whether this view should count down
 *
 * @see #setBase(long)
 * @apiSince 24
 */

public void setCountDown(boolean countDown) { throw new RuntimeException("Stub!"); }

/**
 * @return whether this view counts down
 *
 * @see #setCountDown(boolean)
 * @apiSince 24
 */

public boolean isCountDown() { throw new RuntimeException("Stub!"); }

/**
 * @return whether this is the final countdown
 * @apiSince 26
 */

public boolean isTheFinalCountDown() { throw new RuntimeException("Stub!"); }

/**
 * Set the time that the count-up timer is in reference to.
 *
 * @param base Use the {@link android.os.SystemClock#elapsedRealtime SystemClock#elapsedRealtime} time base.
 * @apiSince 1
 */

public void setBase(long base) { throw new RuntimeException("Stub!"); }

/**
 * Return the base time as set through {@link #setBase}.
 * @apiSince 1
 */

public long getBase() { throw new RuntimeException("Stub!"); }

/**
 * Sets the format string used for display.  The Chronometer will display
 * this string, with the first "%s" replaced by the current timer value in
 * "MM:SS" or "H:MM:SS" form.
 *
 * If the format string is null, or if you never call setFormat(), the
 * Chronometer will simply display the timer value in "MM:SS" or "H:MM:SS"
 * form.
 *
 * @param format the format string.
 * @apiSince 1
 */

public void setFormat(java.lang.String format) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current format string as set through {@link #setFormat}.
 * @apiSince 1
 */

public java.lang.String getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be called when the chronometer changes.
 *
 * @param listener The listener.
 * @apiSince 3
 */

public void setOnChronometerTickListener(android.widget.Chronometer.OnChronometerTickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @return The listener (may be null) that is listening for chronometer change
 *         events.
 * @apiSince 3
 */

public android.widget.Chronometer.OnChronometerTickListener getOnChronometerTickListener() { throw new RuntimeException("Stub!"); }

/**
 * Start counting up.  This does not affect the base as set from {@link #setBase}, just
 * the view display.
 *
 * Chronometer works by regularly scheduling messages to the handler, even when the
 * Widget is not visible.  To make sure resource leaks do not occur, the user should
 * make sure that each start() call has a reciprocal call to {@link #stop}.
 * @apiSince 1
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Stop counting up.  This does not affect the base as set from {@link #setBase}, just
 * the view display.
 *
 * This stops the messages to the handler, effectively releasing resources that would
 * be held as the chronometer is running, via {@link #start}.
 * @apiSince 1
 */

public void stop() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

protected void onVisibilityChanged(android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * A callback that notifies when the chronometer has incremented on its own.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnChronometerTickListener {

/**
 * Notification that the chronometer has changed.
 * @apiSince 3
 */

public void onChronometerTick(android.widget.Chronometer chronometer);
}

}

