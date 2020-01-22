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


/**
 * Simple {@link android.widget.ViewAnimator ViewAnimator} that will animate between two or more views
 * that have been added to it.  Only one child is shown at a time.  If
 * requested, can automatically flip between each child at a regular interval.
 *
 * @attr ref android.R.styleable#ViewFlipper_flipInterval
 * @attr ref android.R.styleable#ViewFlipper_autoStart
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class ViewFlipper extends android.widget.ViewAnimator {

/** @apiSince 1 */

public ViewFlipper(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ViewFlipper(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * How long to wait before flipping to the next view
 *
 * @param milliseconds
 *            time in milliseconds
 
 * Value is 0 or greater
 * @apiSince 1
 */

public void setFlipInterval(int milliseconds) { throw new RuntimeException("Stub!"); }

/**
 * Get the delay before flipping to the next view.
 *
 * @return delay time in milliseconds
 
 * Value is 0 or greater
 * @apiSince 29
 */

public int getFlipInterval() { throw new RuntimeException("Stub!"); }

/**
 * Start a timer to cycle through child views
 * @apiSince 1
 */

public void startFlipping() { throw new RuntimeException("Stub!"); }

/**
 * No more flips
 * @apiSince 1
 */

public void stopFlipping() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the child views are flipping.
 * @apiSince 1
 */

public boolean isFlipping() { throw new RuntimeException("Stub!"); }

/**
 * Set if this view automatically calls {@link #startFlipping()} when it
 * becomes attached to a window.
 * @apiSince 7
 */

public void setAutoStart(boolean autoStart) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view automatically calls {@link #startFlipping()}
 * when it becomes attached to a window.
 * @apiSince 7
 */

public boolean isAutoStart() { throw new RuntimeException("Stub!"); }
}

