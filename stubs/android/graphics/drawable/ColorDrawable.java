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


package android.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;

/**
 * A specialized Drawable that fills the Canvas with a specified color.
 * Note that a ColorDrawable ignores the ColorFilter.
 *
 * <p>It can be defined in an XML file with the <code>&lt;color></code> element.</p>
 *
 * @attr ref android.R.styleable#ColorDrawable_color
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ColorDrawable extends android.graphics.drawable.Drawable {

/**
 * Creates a new black ColorDrawable.
 * @apiSince 1
 */

public ColorDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new ColorDrawable with the specified color.
 *
 * @param color The color to draw.
 * @apiSince 1
 */

public ColorDrawable(int color) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * A mutable BitmapDrawable still shares its Bitmap with any other Drawable
 * that comes from the same resource.
 *
 * @return This drawable.
 * @apiSince 3
 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Gets the drawable's color value.
 *
 * @return int The color to draw.
 * @apiSince 11
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable's color value. This action will clobber the results of
 * prior calls to {@link #setAlpha(int)} on this object, which side-affected
 * the underlying color.
 *
 * @param color The color to draw.
 * @apiSince 11
 */

public void setColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the alpha value of this drawable's color. Note this may not be the same alpha value
 * provided in {@link android.graphics.drawable.Drawable#setAlpha(int) Drawable#setAlpha(int)}. Instead this will return the alpha of the color
 * combined with the alpha provided by setAlpha
 *
 * @return A value between 0 and 255.
 *
 * @see android.graphics.drawable.ColorDrawable#setAlpha(int)
 * @apiSince 1
 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Applies the given alpha to the underlying color. Note if the color already has
 * an alpha applied to it, this will apply this alpha to the existing value instead of
 * overwriting it.
 *
 * @param alpha The alpha value to set, between 0 and 255.
 * @apiSince 1
 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Sets the color filter applied to this color.
 * <p>
 * Only supported on version {@link android.os.Build.VERSION_CODES#LOLLIPOP} and
 * above. Calling this method has no effect on earlier versions.
 *
 * @see android.graphics.drawable.Drawable#setColorFilter(ColorFilter)
 * @apiSince 1
 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/**
 * Returns the color filter applied to this color configured by
 * {@link #setColorFilter(android.graphics.ColorFilter)}
 *
 * @see android.graphics.drawable.Drawable#getColorFilter()
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param outline This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void applyTheme(android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }
}

