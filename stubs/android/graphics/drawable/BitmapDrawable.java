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

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.content.res.Resources;
import java.io.InputStream;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.graphics.Shader;

/**
 * A Drawable that wraps a bitmap and can be tiled, stretched, or aligned. You can create a
 * BitmapDrawable from a file path, an input stream, through XML inflation, or from
 * a {@link android.graphics.Bitmap} object.
 * <p>It can be defined in an XML file with the <code>&lt;bitmap></code> element.  For more
 * information, see the guide to <a
 * href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.</p>
 * <p>
 * Also see the {@link android.graphics.Bitmap} class, which handles the management and
 * transformation of raw bitmap graphics, and should be used when drawing to a
 * {@link android.graphics.Canvas}.
 * </p>
 *
 * @attr ref android.R.styleable#BitmapDrawable_src
 * @attr ref android.R.styleable#BitmapDrawable_antialias
 * @attr ref android.R.styleable#BitmapDrawable_filter
 * @attr ref android.R.styleable#BitmapDrawable_dither
 * @attr ref android.R.styleable#BitmapDrawable_gravity
 * @attr ref android.R.styleable#BitmapDrawable_mipMap
 * @attr ref android.R.styleable#BitmapDrawable_tileMode
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BitmapDrawable extends android.graphics.drawable.Drawable {

/**
 * Create an empty drawable, not dealing with density.
 * @deprecated Use {@link #BitmapDrawable(android.content.res.Resources,android.graphics.Bitmap)}
 * instead to specify a bitmap to draw with and ensure the correct density is set.
 * @apiSince 1
 */

@Deprecated
public BitmapDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Create an empty drawable, setting initial target density based on
 * the display metrics of the resources.
 *
 * @deprecated Use {@link #BitmapDrawable(android.content.res.Resources,android.graphics.Bitmap)}
 * instead to specify a bitmap to draw with.
 * @apiSince 4
 */

@Deprecated
public BitmapDrawable(android.content.res.Resources res) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from a bitmap, not dealing with density.
 * @deprecated Use {@link #BitmapDrawable(android.content.res.Resources,android.graphics.Bitmap)} to ensure
 * that the drawable has correctly set its target density.
 * @apiSince 1
 */

@Deprecated
public BitmapDrawable(android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from a bitmap, setting initial target density based on
 * the display metrics of the resources.
 * @apiSince 4
 */

public BitmapDrawable(android.content.res.Resources res, android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable by opening a given file path and decoding the bitmap.
 * @deprecated Use {@link #BitmapDrawable(android.content.res.Resources,java.lang.String)} to ensure
 * that the drawable has correctly set its target density.
 * @apiSince 1
 */

@Deprecated
public BitmapDrawable(java.lang.String filepath) { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable by opening a given file path and decoding the bitmap.
 * @apiSince 5
 */

public BitmapDrawable(android.content.res.Resources res, java.lang.String filepath) { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable by decoding a bitmap from the given input stream.
 * @deprecated Use {@link #BitmapDrawable(android.content.res.Resources,java.io.InputStream)} to ensure
 * that the drawable has correctly set its target density.
 * @apiSince 1
 */

@Deprecated
public BitmapDrawable(java.io.InputStream is) { throw new RuntimeException("Stub!"); }

/**
 * Create a drawable by decoding a bitmap from the given input stream.
 * @apiSince 5
 */

public BitmapDrawable(android.content.res.Resources res, java.io.InputStream is) { throw new RuntimeException("Stub!"); }

/**
 * Returns the paint used to render this drawable.
 * @apiSince 1
 */

public final android.graphics.Paint getPaint() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bitmap used by this drawable to render. May be null.
 * @apiSince 1
 */

public final android.graphics.Bitmap getBitmap() { throw new RuntimeException("Stub!"); }

/**
 * Set the density scale at which this drawable will be rendered. This
 * method assumes the drawable will be rendered at the same density as the
 * specified canvas.
 *
 * @param canvas The Canvas from which the density scale must be obtained.
 *
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 * @apiSince 4
 */

public void setTargetDensity(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Set the density scale at which this drawable will be rendered.
 *
 * @param metrics The DisplayMetrics indicating the density scale for this drawable.
 *
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 * @apiSince 4
 */

public void setTargetDensity(android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

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

/** Get the gravity used to position/stretch the bitmap within its bounds.
 * See android.view.Gravity
 * @return the gravity applied to the bitmap
 * @apiSince 1
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/** Set the gravity used to position/stretch the bitmap within its bounds.
   See android.view.Gravity
 * @param gravity the gravity
   @apiSince 1
    */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the mipmap hint for this drawable's bitmap.
 * See {@link android.graphics.Bitmap#setHasMipMap(boolean) Bitmap#setHasMipMap(boolean)} for more information.
 *
 * If the bitmap is null calling this method has no effect.
 *
 * @param mipMap True if the bitmap should use mipmaps, false otherwise.
 *
 * @see #hasMipMap()
 * @apiSince 18
 */

public void setMipMap(boolean mipMap) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the mipmap hint is enabled on this drawable's bitmap.
 *
 * @return True if the mipmap hint is set, false otherwise. If the bitmap
 *         is null, this method always returns false.
 *
 * @see #setMipMap(boolean)
 * @attr ref android.R.styleable#BitmapDrawable_mipMap
 * @apiSince 18
 */

public boolean hasMipMap() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables anti-aliasing for this drawable. Anti-aliasing affects
 * the edges of the bitmap only so it applies only when the drawable is rotated.
 *
 * @param aa True if the bitmap should be anti-aliased, false otherwise.
 *
 * @see #hasAntiAlias()
 * @apiSince 1
 */

public void setAntiAlias(boolean aa) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether anti-aliasing is enabled for this drawable.
 *
 * @return True if anti-aliasing is enabled, false otherwise.
 *
 * @see #setAntiAlias(boolean)
 * @apiSince 18
 */

public boolean hasAntiAlias() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setFilterBitmap(boolean filter) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean isFilterBitmap() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/**
 * Indicates the repeat behavior of this drawable on the X axis.
 *
 * @return {@link android.graphics.Shader.TileMode#CLAMP} if the bitmap does not repeat,
 *         {@link android.graphics.Shader.TileMode#REPEAT} or
 *         {@link android.graphics.Shader.TileMode#MIRROR} otherwise.
 * @apiSince 1
 */

public android.graphics.Shader.TileMode getTileModeX() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the repeat behavior of this drawable on the Y axis.
 *
 * @return {@link android.graphics.Shader.TileMode#CLAMP} if the bitmap does not repeat,
 *         {@link android.graphics.Shader.TileMode#REPEAT} or
 *         {@link android.graphics.Shader.TileMode#MIRROR} otherwise.
 * @apiSince 1
 */

public android.graphics.Shader.TileMode getTileModeY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the repeat behavior of this drawable on the X axis. By default, the drawable
 * does not repeat its bitmap. Using {@link android.graphics.Shader.TileMode#REPEAT} or
 * {@link android.graphics.Shader.TileMode#MIRROR} the bitmap can be repeated (or tiled)
 * if the bitmap is smaller than this drawable.
 *
 * @param mode The repeat mode for this drawable.
 *
 * @see #setTileModeY(android.graphics.Shader.TileMode)
 * @see #setTileModeXY(android.graphics.Shader.TileMode, android.graphics.Shader.TileMode)
 * @attr ref android.R.styleable#BitmapDrawable_tileModeX
 * @apiSince 1
 */

public void setTileModeX(android.graphics.Shader.TileMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the repeat behavior of this drawable on the Y axis. By default, the drawable
 * does not repeat its bitmap. Using {@link android.graphics.Shader.TileMode#REPEAT} or
 * {@link android.graphics.Shader.TileMode#MIRROR} the bitmap can be repeated (or tiled)
 * if the bitmap is smaller than this drawable.
 *
 * @param mode The repeat mode for this drawable.
 *
 * @see #setTileModeX(android.graphics.Shader.TileMode)
 * @see #setTileModeXY(android.graphics.Shader.TileMode, android.graphics.Shader.TileMode)
 * @attr ref android.R.styleable#BitmapDrawable_tileModeY
 * @apiSince 1
 */

public final void setTileModeY(android.graphics.Shader.TileMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the repeat behavior of this drawable on both axis. By default, the drawable
 * does not repeat its bitmap. Using {@link android.graphics.Shader.TileMode#REPEAT} or
 * {@link android.graphics.Shader.TileMode#MIRROR} the bitmap can be repeated (or tiled)
 * if the bitmap is smaller than this drawable.
 *
 * @param xmode The X repeat mode for this drawable.
 * @param ymode The Y repeat mode for this drawable.
 *
 * @see #setTileModeX(android.graphics.Shader.TileMode)
 * @see #setTileModeY(android.graphics.Shader.TileMode)
 * @apiSince 1
 */

public void setTileModeXY(android.graphics.Shader.TileMode xmode, android.graphics.Shader.TileMode ymode) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public final boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * A mutable BitmapDrawable still shares its Bitmap with any other Drawable
 * that comes from the same resource.
 *
 * @return This drawable.
 * @apiSince 3
 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void applyTheme(android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }
}

