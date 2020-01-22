/*
 * Copyright (C) 2007 The Android Open Source Project
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
 * A RatingBar is an extension of SeekBar and ProgressBar that shows a rating in
 * stars. The user can touch/drag or use arrow keys to set the rating when using
 * the default size RatingBar. The smaller RatingBar style (
 * {@link android.R.attr#ratingBarStyleSmall}) and the larger indicator-only
 * style ({@link android.R.attr#ratingBarStyleIndicator}) do not support user
 * interaction and should only be used as indicators.
 * <p>
 * When using a RatingBar that supports user interaction, placing widgets to the
 * left or right of the RatingBar is discouraged.
 * <p>
 * The number of stars set (via {@link #setNumStars(int)} or in an XML layout)
 * will be shown when the layout width is set to wrap content (if another layout
 * width is set, the results may be unpredictable).
 * <p>
 * The secondary progress should not be modified by the client as it is used
 * internally as the background for a fractionally filled star.
 *
 * @attr ref android.R.styleable#RatingBar_numStars
 * @attr ref android.R.styleable#RatingBar_rating
 * @attr ref android.R.styleable#RatingBar_stepSize
 * @attr ref android.R.styleable#RatingBar_isIndicator
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RatingBar extends android.widget.AbsSeekBar {

/** @apiSince 1 */

public RatingBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public RatingBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public RatingBar(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public RatingBar(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be called when the rating changes.
 *
 * @param listener The listener.
 * @apiSince 1
 */

public void setOnRatingBarChangeListener(android.widget.RatingBar.OnRatingBarChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @return The listener (may be null) that is listening for rating change
 *         events.
 * @apiSince 1
 */

public android.widget.RatingBar.OnRatingBarChangeListener getOnRatingBarChangeListener() { throw new RuntimeException("Stub!"); }

/**
 * Whether this rating bar should only be an indicator (thus non-changeable
 * by the user).
 *
 * @param isIndicator Whether it should be an indicator.
 *
 * @attr ref android.R.styleable#RatingBar_isIndicator
 * @apiSince 1
 */

public void setIsIndicator(boolean isIndicator) { throw new RuntimeException("Stub!"); }

/**
 * @return Whether this rating bar is only an indicator.
 *
 * @attr ref android.R.styleable#RatingBar_isIndicator
 * @apiSince 1
 */

public boolean isIndicator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of stars to show. In order for these to be shown
 * properly, it is recommended the layout width of this widget be wrap
 * content.
 *
 * @param numStars The number of stars.
 * @apiSince 1
 */

public void setNumStars(int numStars) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of stars shown.
 * @return The number of stars shown.
 * @apiSince 1
 */

public int getNumStars() { throw new RuntimeException("Stub!"); }

/**
 * Sets the rating (the number of stars filled).
 *
 * @param rating The rating to set.
 * @apiSince 1
 */

public void setRating(float rating) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current rating (number of stars filled).
 *
 * @return The current rating.
 * @apiSince 1
 */

public float getRating() { throw new RuntimeException("Stub!"); }

/**
 * Sets the step size (granularity) of this rating bar.
 *
 * @param stepSize The step size of this rating bar. For example, if
 *            half-star granularity is wanted, this would be 0.5.
 * @apiSince 1
 */

public void setStepSize(float stepSize) { throw new RuntimeException("Stub!"); }

/**
 * Gets the step size of this rating bar.
 *
 * @return The step size.
 * @apiSince 1
 */

public float getStepSize() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void setMax(int max) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * A callback that notifies clients when the rating has been changed. This
 * includes changes that were initiated by the user through a touch gesture
 * or arrow key/trackball as well as changes that were initiated
 * programmatically.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnRatingBarChangeListener {

/**
 * Notification that the rating has changed. Clients can use the
 * fromUser parameter to distinguish user-initiated changes from those
 * that occurred programmatically. This will not be called continuously
 * while the user is dragging, only when the user finalizes a rating by
 * lifting the touch.
 *
 * @param ratingBar The RatingBar whose rating has changed.
 * @param rating The current rating. This will be in the range
 *            0..numStars.
 * @param fromUser True if the rating change was initiated by a user's
 *            touch gesture or arrow key/horizontal trackbell movement.
 * @apiSince 1
 */

public void onRatingChanged(android.widget.RatingBar ratingBar, float rating, boolean fromUser);
}

}

