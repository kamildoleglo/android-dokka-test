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


package android.graphics.drawable;

import android.graphics.NinePatch;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 *
 * A resizeable bitmap, with stretchable areas that you define. This type of image
 * is defined in a .png file with a special format.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use a NinePatchDrawable, read the
 * <a href="{@docRoot}guide/topics/graphics/2d-graphics.html#nine-patch">
 * Canvas and Drawables</a> developer guide. For information about creating a NinePatch image
 * file using the draw9patch tool, see the
 * <a href="{@docRoot}guide/developing/tools/draw9patch.html">Draw 9-patch</a> tool guide.</p></div>
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NinePatchDrawable extends android.graphics.drawable.Drawable {

/**
 * Create drawable from raw nine-patch data, not dealing with density.
 *
 * @deprecated Use {@link #NinePatchDrawable(android.content.res.Resources,android.graphics.Bitmap,byte[],android.graphics.Rect,java.lang.String)}
 *             to ensure that the drawable has correctly set its target density.
 * @apiSince 1
 */

@Deprecated
public NinePatchDrawable(android.graphics.Bitmap bitmap, byte[] chunk, android.graphics.Rect padding, java.lang.String srcName) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from raw nine-patch data, setting initial target density
 * based on the display metrics of the resources.
 * @apiSince 4
 */

public NinePatchDrawable(android.content.res.Resources res, android.graphics.Bitmap bitmap, byte[] chunk, android.graphics.Rect padding, java.lang.String srcName) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from existing nine-patch, not dealing with density.
 *
 * @deprecated Use {@link #NinePatchDrawable(android.content.res.Resources,android.graphics.NinePatch)}
 *             to ensure that the drawable has correctly set its target
 *             density.
 
 * @param patch This value must never be {@code null}.
 * @apiSince 1
 */

@Deprecated
public NinePatchDrawable(@androidx.annotation.NonNull android.graphics.NinePatch patch) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from existing nine-patch, setting initial target density
 * based on the display metrics of the resources.
 
 * @param res This value may be {@code null}.
 
 * @param patch This value must never be {@code null}.
 * @apiSince 4
 */

public NinePatchDrawable(@androidx.annotation.Nullable android.content.res.Resources res, @androidx.annotation.NonNull android.graphics.NinePatch patch) { throw new RuntimeException("Stub!"); }

/**
 * Set the density scale at which this drawable will be rendered. This
 * method assumes the drawable will be rendered at the same density as the
 * specified canvas.
 *
 * @param canvas The Canvas from which the density scale must be obtained.
 *
 * This value must never be {@code null}.
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 * @apiSince 4
 */

public void setTargetDensity(@androidx.annotation.NonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Set the density scale at which this drawable will be rendered.
 *
 * @param metrics The DisplayMetrics indicating the density scale for this drawable.
 *
 * This value must never be {@code null}.
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 * @apiSince 4
 */

public void setTargetDensity(@androidx.annotation.NonNull android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Set the density at which this drawable will be rendered.
 *
 * @param density The density scale for this drawable.
 *
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 * @apiSince 4
 */

public void setTargetDensity(int density) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param padding This value must never be {@code null}.
 * @apiSince 1
 */

public boolean getPadding(@androidx.annotation.NonNull android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param colorFilter This value may be {@code null}.
 * @apiSince 1
 */

public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param tint This value may be {@code null}.
 * @apiSince 21
 */

public void setTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value may be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setFilterBitmap(boolean filter) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean isFilterBitmap() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param t This value must never be {@code null}.
 * @apiSince 21
 */

public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.graphics.Paint getPaint() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.Region getTransparentRegion() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }
}

