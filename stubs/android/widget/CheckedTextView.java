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
 * An extension to {@link android.widget.TextView TextView} that supports the {@link android.widget.Checkable Checkable}
 * interface and displays.
 * <p>
 * This is useful when used in a {@link android.widget.ListView ListView} where
 * the {@link android.widget.ListView#setChoiceMode(int) setChoiceMode} has
 * been set to something other than
 * {@link android.widget.ListView#CHOICE_MODE_NONE CHOICE_MODE_NONE}.
 *
 * @attr ref android.R.styleable#CheckedTextView_checked
 * @attr ref android.R.styleable#CheckedTextView_checkMark
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CheckedTextView extends android.widget.TextView implements android.widget.Checkable {

/** @apiSince 1 */

public CheckedTextView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public CheckedTextView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public CheckedTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public CheckedTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void toggle() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@android.view.ViewDebug.ExportedProperty
public boolean isChecked() { throw new RuntimeException("Stub!"); }

/**
 * Sets the checked state of this view.
 *
 * @param checked {@code true} set the state to checked, {@code false} to
 *                uncheck
 * @apiSince 1
 */

public void setChecked(boolean checked) { throw new RuntimeException("Stub!"); }

/**
 * Sets the check mark to the drawable with the specified resource ID.
 * <p>
 * When this view is checked, the drawable's state set will include
 * {@link android.R.attr#state_checked}.
 *
 * @param resId the resource identifier of drawable to use as the check
 *              mark
 * @attr ref android.R.styleable#CheckedTextView_checkMark
 * @see #setCheckMarkDrawable(Drawable)
 * @see #getCheckMarkDrawable()
 * @apiSince 1
 */

public void setCheckMarkDrawable(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the check mark to the specified drawable.
 * <p>
 * When this view is checked, the drawable's state set will include
 * {@link android.R.attr#state_checked}.
 *
 * @param d the drawable to use for the check mark
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CheckedTextView_checkMark
 * @see #setCheckMarkDrawable(int)
 * @see #getCheckMarkDrawable()
 * @apiSince 1
 */

public void setCheckMarkDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the check mark drawable. Does not modify the
 * current tint mode, which is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setCheckMarkDrawable(android.graphics.drawable.Drawable)} will
 * automatically mutate the drawable and apply the specified tint and
 * tint mode using
 * {@link android.graphics.drawable.Drawable#setTintList(android.content.res.ColorStateList) Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CheckedTextView_checkMarkTint
 * @see #getCheckMarkTintList()
 * @see android.graphics.drawable.Drawable#setTintList(ColorStateList)
 * @apiSince 21
 */

public void setCheckMarkTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tint applied to the check mark drawable, if specified.
 *
 * @return the tint applied to the check mark drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CheckedTextView_checkMarkTint
 * @see #setCheckMarkTintList(ColorStateList)
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.content.res.ColorStateList getCheckMarkTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setCheckMarkTintList(android.content.res.ColorStateList)} to the check mark
 * drawable. The default mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CheckedTextView_checkMarkTintMode
 * @see #setCheckMarkTintList(ColorStateList)
 * @see android.graphics.drawable.Drawable#setTintMode(PorterDuff.Mode)
 * @apiSince 21
 */

public void setCheckMarkTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setCheckMarkTintList(android.content.res.ColorStateList)} to the check mark
 * drawable. The default mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CheckedTextView_checkMarkTintMode
 * @see #setCheckMarkTintList(ColorStateList)
 * @see android.graphics.drawable.Drawable#setTintBlendMode(BlendMode)
 * @apiSince 29
 */

public void setCheckMarkTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the check mark
 * drawable, if specified.
 *
 * @return the blending mode used to apply the tint to the check mark
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CheckedTextView_checkMarkTintMode
 * @see #setCheckMarkTintMode(PorterDuff.Mode)
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.PorterDuff.Mode getCheckMarkTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the check mark
 * drawable, if specified.
 *
 * @return the blending mode used to apply the tint to the check mark
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CheckedTextView_checkMarkTintMode
 * @see #setCheckMarkTintMode(PorterDuff.Mode)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.BlendMode getCheckMarkTintBlendMode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 1
 */

protected boolean verifyDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * Gets the checkmark drawable
 *
 * @return The drawable use to represent the checkmark, if any.
 *
 * @see #setCheckMarkDrawable(Drawable)
 * @see #setCheckMarkDrawable(int)
 *
 * @attr ref android.R.styleable#CheckedTextView_checkMark
 * @apiSince 16
 */

public android.graphics.drawable.Drawable getCheckMarkDrawable() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }
}

