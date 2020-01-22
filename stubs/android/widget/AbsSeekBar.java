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

import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;

/**
 * AbsSeekBar extends the capabilities of ProgressBar by adding a draggable thumb.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbsSeekBar extends android.widget.ProgressBar {

/** @apiSince 1 */

public AbsSeekBar(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public AbsSeekBar(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public AbsSeekBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public AbsSeekBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the thumb that will be drawn at the end of the progress meter within the SeekBar.
 * <p>
 * If the thumb is a valid drawable (i.e. not null), half its width will be
 * used as the new thumb offset (@see #setThumbOffset(int)).
 *
 * @param thumb Drawable representing the thumb
 * @apiSince 1
 */

public void setThumb(android.graphics.drawable.Drawable thumb) { throw new RuntimeException("Stub!"); }

/**
 * Return the drawable used to represent the scroll thumb - the component that
 * the user can drag back and forth indicating the current value by its position.
 *
 * @return The current thumb drawable
 * @apiSince 16
 */

public android.graphics.drawable.Drawable getThumb() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the thumb drawable. Does not modify the current tint
 * mode, which is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setThumb(android.graphics.drawable.Drawable)} will automatically
 * mutate the drawable and apply the specified tint and tint mode using
 * {@link android.graphics.drawable.Drawable#setTintList(android.content.res.ColorStateList) Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_thumbTint
 * @see #getThumbTintList()
 * @see android.graphics.drawable.Drawable#setTintList(ColorStateList)
 * @apiSince 21
 */

public void setThumbTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tint applied to the thumb drawable, if specified.
 *
 * @return the tint applied to the thumb drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_thumbTint
 * @see #setThumbTintList(ColorStateList)
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.content.res.ColorStateList getThumbTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setThumbTintList(android.content.res.ColorStateList)}} to the thumb drawable. The
 * default mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_thumbTintMode
 * @see #getThumbTintMode()
 * @see android.graphics.drawable.Drawable#setTintMode(PorterDuff.Mode)
 * @apiSince 21
 */

public void setThumbTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setThumbTintList(android.content.res.ColorStateList)}} to the thumb drawable. The
 * default mode is {@link android.graphics.BlendMode#SRC_IN BlendMode#SRC_IN}.
 *
 * @param blendMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_thumbTintMode
 * @see #getThumbTintMode()
 * @see android.graphics.drawable.Drawable#setTintBlendMode(BlendMode)
 * @apiSince 29
 */

public void setThumbTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the thumb drawable,
 * if specified.
 *
 * @return the blending mode used to apply the tint to the thumb drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_thumbTintMode
 * @see #setThumbTintMode(PorterDuff.Mode)
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.PorterDuff.Mode getThumbTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the thumb drawable,
 * if specified.
 *
 * @return the blending mode used to apply the tint to the thumb drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_thumbTintMode
 * @see #setThumbTintBlendMode(BlendMode)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.BlendMode getThumbTintBlendMode() { throw new RuntimeException("Stub!"); }

/**
 * @see #setThumbOffset(int)
 * @apiSince 1
 */

public int getThumbOffset() { throw new RuntimeException("Stub!"); }

/**
 * Sets the thumb offset that allows the thumb to extend out of the range of
 * the track.
 *
 * @param thumbOffset The offset amount in pixels.
 * @apiSince 1
 */

public void setThumbOffset(int thumbOffset) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the track should be split by the thumb. When true,
 * the thumb's optical bounds will be clipped out of the track drawable,
 * then the thumb will be drawn into the resulting gap.
 *
 * @param splitTrack Whether the track should be split by the thumb
 * @apiSince 21
 */

public void setSplitTrack(boolean splitTrack) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the track should be split by the thumb.
 * @apiSince 21
 */

public boolean getSplitTrack() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable displayed at each progress position, e.g.&nbsp;at each
 * possible thumb position.
 *
 * @param tickMark the drawable to display at each progress position
 * @apiSince 24
 */

public void setTickMark(android.graphics.drawable.Drawable tickMark) { throw new RuntimeException("Stub!"); }

/**
 * @return the drawable displayed at each progress position
 * @apiSince 24
 */

public android.graphics.drawable.Drawable getTickMark() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the tick mark drawable. Does not modify the current tint
 * mode, which is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setTickMark(android.graphics.drawable.Drawable)} will automatically
 * mutate the drawable and apply the specified tint and tint mode using
 * {@link android.graphics.drawable.Drawable#setTintList(android.content.res.ColorStateList) Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_tickMarkTint
 * @see #getTickMarkTintList()
 * @see android.graphics.drawable.Drawable#setTintList(ColorStateList)
 * @apiSince 24
 */

public void setTickMarkTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tint applied to the tick mark drawable, if specified.
 *
 * @return the tint applied to the tick mark drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_tickMarkTint
 * @see #setTickMarkTintList(ColorStateList)
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.content.res.ColorStateList getTickMarkTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setTickMarkTintList(android.content.res.ColorStateList)}} to the tick mark drawable. The
 * default mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_tickMarkTintMode
 * @see #getTickMarkTintMode()
 * @see android.graphics.drawable.Drawable#setTintMode(PorterDuff.Mode)
 * @apiSince 24
 */

public void setTickMarkTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setTickMarkTintList(android.content.res.ColorStateList)}} to the tick mark drawable. The
 * default mode is {@link android.graphics.BlendMode#SRC_IN BlendMode#SRC_IN}.
 *
 * @param blendMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_tickMarkTintMode
 * @see #getTickMarkTintMode()
 * @see android.graphics.drawable.Drawable#setTintBlendMode(BlendMode)
 * @apiSince 29
 */

public void setTickMarkTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the tick mark drawable,
 * if specified.
 *
 * @return the blending mode used to apply the tint to the tick mark drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_tickMarkTintMode
 * @see #setTickMarkTintMode(PorterDuff.Mode)
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.graphics.PorterDuff.Mode getTickMarkTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the tick mark drawable,
 * if specified.
 *
 * @return the blending mode used to apply the tint to the tick mark drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#SeekBar_tickMarkTintMode
 * @see #setTickMarkTintMode(PorterDuff.Mode)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.BlendMode getTickMarkTintBlendMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the amount of progress changed via the arrow keys.
 *
 * @param increment The amount to increment or decrement when the user
 *            presses the arrow keys.
 * @apiSince 3
 */

public void setKeyProgressIncrement(int increment) { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of progress changed via the arrow keys.
 * <p>
 * By default, this will be a value that is derived from the progress range.
 *
 * @return The amount to increment or decrement when the user presses the
 *         arrow keys. This will be positive.
 * @apiSince 3
 */

public int getKeyProgressIncrement() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public synchronized void setMin(int min) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void setMax(int max) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 1
 */

protected boolean verifyDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param rects This value must never be {@code null}.
 * @apiSince 29
 */

public void setSystemGestureExclusionRects(@androidx.annotation.NonNull java.util.List<android.graphics.Rect> rects) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected synchronized void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }
}

