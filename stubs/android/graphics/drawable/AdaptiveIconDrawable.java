/*
 * Copyright (C) 2017 The Android Open Source Project
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

import android.graphics.Rect;

/**
 * <p>This class can also be created via XML inflation using <code>&lt;adaptive-icon></code> tag
 * in addition to dynamic creation.
 *
 * <p>This drawable supports two drawable layers: foreground and background. The layers are clipped
 * when rendering using the mask defined in the device configuration.
 *
 * <ul>
 * <li>Both foreground and background layers should be sized at 108 x 108 dp.</li>
 * <li>The inner 72 x 72 dp  of the icon appears within the masked viewport.</li>
 * <li>The outer 18 dp on each of the 4 sides of the layers is reserved for use by the system UI
 * surfaces to create interesting visual effects, such as parallax or pulsing.</li>
 * </ul>
 *
 * Such motion effect is achieved by internally setting the bounds of the foreground and
 * background layer as following:
 * <pre>
 * Rect(getBounds().left - getBounds().getWidth() * #getExtraInsetFraction(),
 *      getBounds().top - getBounds().getHeight() * #getExtraInsetFraction(),
 *      getBounds().right + getBounds().getWidth() * #getExtraInsetFraction(),
 *      getBounds().bottom + getBounds().getHeight() * #getExtraInsetFraction())
 * </pre>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AdaptiveIconDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {

/**
 * Constructor used to dynamically create this drawable.
 *
 * @param backgroundDrawable drawable that should be rendered in the background
 * @param foregroundDrawable drawable that should be rendered in the foreground
 * @apiSince 26
 */

public AdaptiveIconDrawable(android.graphics.drawable.Drawable backgroundDrawable, android.graphics.drawable.Drawable foregroundDrawable) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param r This value must never be {@code null}.
 
 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.
 
 * @param theme This value may be {@code null}.
 * @apiSince 26
 */

public void inflate(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * All four sides of the layers are padded with extra inset so as to provide
 * extra content to reveal within the clip path when performing affine transformations on the
 * layers.
 *
 * @see #getForeground() and #getBackground() for more info on how this value is used
 * @apiSince 26
 */

public static float getExtraInsetFraction() { throw new RuntimeException("Stub!"); }

/**
 * When called before the bound is set, the returned path is identical to
 * R.string.config_icon_mask. After the bound is set, the
 * returned path's computed bound is same as the #getBounds().
 *
 * @return the mask path object used to clip the drawable
 * @apiSince 26
 */

public android.graphics.Path getIconMask() { throw new RuntimeException("Stub!"); }

/**
 * Returns the foreground drawable managed by this class. The bound of this drawable is
 * extended by {@link #getExtraInsetFraction()} * getBounds().width on left/right sides and by
 * {@link #getExtraInsetFraction()} * getBounds().height on top/bottom sides.
 *
 * @return the foreground drawable managed by this drawable
 * @apiSince 26
 */

public android.graphics.drawable.Drawable getForeground() { throw new RuntimeException("Stub!"); }

/**
 * Returns the foreground drawable managed by this class. The bound of this drawable is
 * extended by {@link #getExtraInsetFraction()} * getBounds().width on left/right sides and by
 * {@link #getExtraInsetFraction()} * getBounds().height on top/bottom sides.
 *
 * @return the background drawable managed by this drawable
 * @apiSince 26
 */

public android.graphics.drawable.Drawable getBackground() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void invalidateSelf() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 26
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.graphics.Region getTransparentRegion() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param t This value must never be {@code null}.
 * @apiSince 26
 */

public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public boolean isProjected() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 26
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 26
 */

public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 26
 */

public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 26
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void getHotspotBounds(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setOpacity(int opacity) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void jumpToCurrentState() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }
}

