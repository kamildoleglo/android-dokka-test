/*
 * Copyright (C) 2015 The Android Open Source Project
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

import android.view.View;

/**
 * Drawable container with only one child element.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DrawableWrapper extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {

/**
 * Creates a new wrapper around the specified drawable.
 *
 * @param dr the drawable to wrap
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public DrawableWrapper(@androidx.annotation.Nullable android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/**
 * Sets the wrapped drawable.
 *
 * @param dr the wrapped drawable
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void setDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/**
 * @return the wrapped drawable
 
 * This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getDrawable() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param r This value must never be {@code null}.
 
 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.
 
 * @param theme This value may be {@code null}.
 * @apiSince 23
 */

public void inflate(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param t This value must never be {@code null}.
 * @apiSince 23
 */

public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 23
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 23
 */

public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 23
 */

public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param canvas This value must never be {@code null}.
 * @apiSince 23
 */

public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 23
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param padding This value must never be {@code null}.
 * @apiSince 23
 */

public boolean getPadding(@androidx.annotation.NonNull android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outRect This value must never be {@code null}.
 * @apiSince 23
 */

public void getHotspotBounds(@androidx.annotation.NonNull android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param colorFilter This value may be {@code null}.
 * @apiSince 23
 */

public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param tint This value may be {@code null}.
 * @apiSince 23
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

 * @param layoutDirection Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @apiSince 23
 */

public boolean onLayoutDirectionChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param bounds This value must never be {@code null}.
 * @apiSince 23
 */

protected void onBoundsChange(@androidx.annotation.NonNull android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 23
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }
}

