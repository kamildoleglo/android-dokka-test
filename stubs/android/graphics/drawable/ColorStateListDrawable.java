/*
 * Copyright 2018 The Android Open Source Project
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

import android.content.res.ColorStateList;
import android.graphics.PixelFormat;

/**
 * A Drawable that manages a {@link android.graphics.drawable.ColorDrawable ColorDrawable} to make it stateful and backed by a
 * {@link android.content.res.ColorStateList ColorStateList}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ColorStateListDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {

/** @apiSince 29 */

public ColorStateListDrawable() { throw new RuntimeException("Stub!"); }

/**
 * @param colorStateList This value must never be {@code null}.
 * @apiSince 29
 */

public ColorStateListDrawable(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param canvas This value must never be {@code null}.
 * @apiSince 29
 */

public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is between 0 and 255 inclusive
 * @apiSince 29
 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean hasFocusStateSpecified() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable getCurrent() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param t This value must never be {@code null}.
 * @apiSince 29
 */

public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param alpha Value is between 0 and 255 inclusive
 * @apiSince 29
 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Remove the alpha override, reverting to the alpha defined on each color in the
 * {@link android.content.res.ColorStateList ColorStateList}.
 * @apiSince 29
 */

public void clearAlpha() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param tint This value may be {@code null}.
 * @apiSince 29
 */

public void setTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param colorFilter This value may be {@code null}.
 * @apiSince 29
 */

public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is {@link android.graphics.PixelFormat#UNKNOWN}, {@link android.graphics.PixelFormat#TRANSLUCENT}, {@link android.graphics.PixelFormat#TRANSPARENT}, or {@link android.graphics.PixelFormat#OPAQUE}
 * @apiSince 29
 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 29
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 29
 */

public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 29
 */

public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ColorStateList backing this Drawable, or a new ColorStateList of the default
 * ColorDrawable color if one hasn't been defined yet.
 *
 * @return a ColorStateList
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.res.ColorStateList getColorStateList() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * Replace this Drawable's ColorStateList. It is not copied, so changes will propagate on the
 * next call to {@link #setState(int[])}.
 *
 * @param colorStateList A color state list to attach.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void setColorStateList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) { throw new RuntimeException("Stub!"); }
}

