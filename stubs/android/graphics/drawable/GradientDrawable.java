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

import android.content.res.Resources;
import android.content.res.ColorStateList;
import android.graphics.Color;

/**
 * A Drawable with a color gradient for buttons, backgrounds, etc.
 *
 * <p>It can be defined in an XML file with the <code>&lt;shape></code> element. For more
 * information, see the guide to <a
 * href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.</p>
 *
 * @attr ref android.R.styleable#GradientDrawable_visible
 * @attr ref android.R.styleable#GradientDrawable_shape
 * @attr ref android.R.styleable#GradientDrawable_innerRadiusRatio
 * @attr ref android.R.styleable#GradientDrawable_innerRadius
 * @attr ref android.R.styleable#GradientDrawable_thicknessRatio
 * @attr ref android.R.styleable#GradientDrawable_thickness
 * @attr ref android.R.styleable#GradientDrawable_useLevel
 * @attr ref android.R.styleable#GradientDrawableSize_width
 * @attr ref android.R.styleable#GradientDrawableSize_height
 * @attr ref android.R.styleable#GradientDrawableGradient_startColor
 * @attr ref android.R.styleable#GradientDrawableGradient_centerColor
 * @attr ref android.R.styleable#GradientDrawableGradient_endColor
 * @attr ref android.R.styleable#GradientDrawableGradient_useLevel
 * @attr ref android.R.styleable#GradientDrawableGradient_angle
 * @attr ref android.R.styleable#GradientDrawableGradient_type
 * @attr ref android.R.styleable#GradientDrawableGradient_centerX
 * @attr ref android.R.styleable#GradientDrawableGradient_centerY
 * @attr ref android.R.styleable#GradientDrawableGradient_gradientRadius
 * @attr ref android.R.styleable#GradientDrawableSolid_color
 * @attr ref android.R.styleable#GradientDrawableStroke_width
 * @attr ref android.R.styleable#GradientDrawableStroke_color
 * @attr ref android.R.styleable#GradientDrawableStroke_dashWidth
 * @attr ref android.R.styleable#GradientDrawableStroke_dashGap
 * @attr ref android.R.styleable#GradientDrawablePadding_left
 * @attr ref android.R.styleable#GradientDrawablePadding_top
 * @attr ref android.R.styleable#GradientDrawablePadding_right
 * @attr ref android.R.styleable#GradientDrawablePadding_bottom
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GradientDrawable extends android.graphics.drawable.Drawable {

/** @apiSince 1 */

public GradientDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Create a new gradient drawable given an orientation and an array
 * of colors for the gradient.
 * @apiSince 1
 */

public GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation orientation, int[] colors) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getPadding(android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * Specifies radii for each of the 4 corners. For each corner, the array
 * contains 2 values, <code>[X_radius, Y_radius]</code>. The corners are
 * ordered top-left, top-right, bottom-right, bottom-left. This property
 * is honored only when the shape is of type {@link #RECTANGLE}.
 * <p>
 * <strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.
 *
 * @param radii an array of length >= 8 containing 4 pairs of X and Y
 *              radius for each corner, specified in pixels
 *
 * This value may be {@code null}.
 * @see #mutate()
 * @see #setShape(int)
 * @see #setCornerRadius(float)
 * @apiSince 1
 */

public void setCornerRadii(@androidx.annotation.Nullable float[] radii) { throw new RuntimeException("Stub!"); }

/**
 * Returns the radii for each of the 4 corners. For each corner, the array
 * contains 2 values, <code>[X_radius, Y_radius]</code>. The corners are
 * ordered top-left, top-right, bottom-right, bottom-left.
 * <p>
 * If the radius was previously set with {@link #setCornerRadius(float)},
 * or if the corners are not rounded, this method will return {@code null}.
 *
 * @return an array containing the radii for each of the 4 corners, or
 *         {@code null}
 * @see #setCornerRadii(float[])
 * @apiSince 24
 */

@androidx.annotation.Nullable
public float[] getCornerRadii() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the radius for the corners of the gradient. If this is > 0,
 * then the drawable is drawn in a round-rectangle, rather than a
 * rectangle. This property is honored only when the shape is of type
 * {@link #RECTANGLE}.
 * <p>
 * <strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.
 *
 * @param radius The radius in pixels of the corners of the rectangle shape
 *
 * @see #mutate()
 * @see #setCornerRadii(float[])
 * @see #setShape(int)
 * @apiSince 1
 */

public void setCornerRadius(float radius) { throw new RuntimeException("Stub!"); }

/**
 * Returns the radius for the corners of the gradient, that was previously set with
 * {@link #setCornerRadius(float)}.
 * <p>
 * If the radius was previously cleared via passing {@code null}
 * to {@link #setCornerRadii(float[])}, this method will return 0.
 *
 * @return the radius in pixels of the corners of the rectangle shape, or 0
 * @see #setCornerRadius
 * @apiSince 24
 */

public float getCornerRadius() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the stroke width and color for the drawable. If width is zero,
 * then no stroke is drawn.</p>
 * <p><strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.</p>
 *
 * @param width The width in pixels of the stroke
 * @param color The color of the stroke
 *
 * @see #mutate()
 * @see #setStroke(int, int, float, float)
 * @apiSince 1
 */

public void setStroke(int width, int color) { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the stroke width and color state list for the drawable. If width
 * is zero, then no stroke is drawn.</p>
 * <p><strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.</p>
 *
 * @param width The width in pixels of the stroke
 * @param colorStateList The color state list of the stroke
 *
 * @see #mutate()
 * @see #setStroke(int, ColorStateList, float, float)
 * @apiSince 21
 */

public void setStroke(int width, android.content.res.ColorStateList colorStateList) { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the stroke width and color for the drawable. If width is zero,
 * then no stroke is drawn. This method can also be used to dash the stroke.</p>
 * <p><strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.</p>
 *
 * @param width The width in pixels of the stroke
 * @param color The color of the stroke
 * @param dashWidth The length in pixels of the dashes, set to 0 to disable dashes
 * @param dashGap The gap in pixels between dashes
 *
 * @see #mutate()
 * @see #setStroke(int, int)
 * @apiSince 1
 */

public void setStroke(int width, int color, float dashWidth, float dashGap) { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the stroke width and color state list for the drawable. If width
 * is zero, then no stroke is drawn. This method can also be used to dash
 * the stroke.</p>
 * <p><strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.</p>
 *
 * @param width The width in pixels of the stroke
 * @param colorStateList The color state list of the stroke
 * @param dashWidth The length in pixels of the dashes, set to 0 to disable dashes
 * @param dashGap The gap in pixels between dashes
 *
 * @see #mutate()
 * @see #setStroke(int, ColorStateList)
 * @apiSince 21
 */

public void setStroke(int width, android.content.res.ColorStateList colorStateList, float dashWidth, float dashGap) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the size of the shape drawn by this drawable.</p>
 * <p><strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.</p>
 *
 * @param width The width of the shape used by this drawable
 * @param height The height of the shape used by this drawable
 *
 * @see #mutate()
 * @see #setGradientType(int)
 * @apiSince 1
 */

public void setSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the type of shape used to draw the gradient.</p>
 * <p><strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.</p>
 *
 * @param shape The desired shape for this drawable: {@link #LINE},
 *              {@link #OVAL}, {@link #RECTANGLE} or {@link #RING}
 *
 * Value is {@link android.graphics.drawable.GradientDrawable#RECTANGLE}, {@link android.graphics.drawable.GradientDrawable#OVAL}, {@link android.graphics.drawable.GradientDrawable#LINE}, or {@link android.graphics.drawable.GradientDrawable#RING}
 * @see #mutate()
 * @apiSince 1
 */

public void setShape(int shape) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of shape used by this drawable, one of {@link #LINE},
 * {@link #OVAL}, {@link #RECTANGLE} or {@link #RING}.
 *
 * @return the type of shape used by this drawable
 * Value is {@link android.graphics.drawable.GradientDrawable#RECTANGLE}, {@link android.graphics.drawable.GradientDrawable#OVAL}, {@link android.graphics.drawable.GradientDrawable#LINE}, or {@link android.graphics.drawable.GradientDrawable#RING}
 * @see #setShape(int)
 * @apiSince 24
 */

public int getShape() { throw new RuntimeException("Stub!"); }

/**
 * Sets the type of gradient used by this drawable.
 * <p>
 * <strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.
 *
 * @param gradient The type of the gradient: {@link #LINEAR_GRADIENT},
 *                 {@link #RADIAL_GRADIENT} or {@link #SWEEP_GRADIENT}
 *
 * Value is {@link android.graphics.drawable.GradientDrawable#LINEAR_GRADIENT}, {@link android.graphics.drawable.GradientDrawable#RADIAL_GRADIENT}, or {@link android.graphics.drawable.GradientDrawable#SWEEP_GRADIENT}
 * @see #mutate()
 * @see #getGradientType()
 * @apiSince 1
 */

public void setGradientType(int gradient) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of gradient used by this drawable, one of
 * {@link #LINEAR_GRADIENT}, {@link #RADIAL_GRADIENT}, or
 * {@link #SWEEP_GRADIENT}.
 *
 * @return the type of gradient used by this drawable
 * Value is {@link android.graphics.drawable.GradientDrawable#LINEAR_GRADIENT}, {@link android.graphics.drawable.GradientDrawable#RADIAL_GRADIENT}, or {@link android.graphics.drawable.GradientDrawable#SWEEP_GRADIENT}
 * @see #setGradientType(int)
 * @apiSince 24
 */

public int getGradientType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the center of the gradient as a fraction of the
 * width and height.
 * <p>
 * The default value is (0.5, 0.5).
 * <p>
 * <strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.
 *
 * @param x the X-position of the center of the gradient
 * @param y the Y-position of the center of the gradient
 *
 * @see #mutate()
 * @see #setGradientType(int)
 * @see #getGradientCenterX()
 * @see #getGradientCenterY()
 * @apiSince 1
 */

public void setGradientCenter(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the X-position of the center of the gradient as a fraction of
 * the width.
 *
 * @return the X-position of the center of the gradient
 * @see #setGradientCenter(float, float)
 * @apiSince 24
 */

public float getGradientCenterX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Y-position of the center of this gradient as a fraction of
 * the height.
 *
 * @return the Y-position of the center of the gradient
 * @see #setGradientCenter(float, float)
 * @apiSince 24
 */

public float getGradientCenterY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the radius of the gradient. The radius is honored only when the
 * gradient type is set to {@link #RADIAL_GRADIENT}.
 * <p>
 * <strong>Note</strong>: changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.
 *
 * @param gradientRadius the radius of the gradient in pixels
 *
 * @see #mutate()
 * @see #setGradientType(int)
 * @see #getGradientRadius()
 * @apiSince 1
 */

public void setGradientRadius(float gradientRadius) { throw new RuntimeException("Stub!"); }

/**
 * Returns the radius of the gradient in pixels. The radius is valid only
 * when the gradient type is set to {@link #RADIAL_GRADIENT}.
 *
 * @return the radius of the gradient in pixels
 * @see #setGradientRadius(float)
 * @apiSince 21
 */

public float getGradientRadius() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this drawable's {@code level} property will be used to
 * scale the gradient. If a gradient is not used, this property has no
 * effect.
 * <p>
 * Scaling behavior varies based on gradient type:
 * <ul>
 *     <li>{@link #LINEAR_GRADIENT} adjusts the ending position along the
 *         gradient's axis of orientation (see {@link #getOrientation()})
 *     <li>{@link #RADIAL_GRADIENT} adjusts the outer radius
 *     <li>{@link #SWEEP_GRADIENT} adjusts the ending angle
 * <ul>
 * <p>
 * The default value for this property is {@code false}.
 * <p>
 * <strong>Note</strong>: This property corresponds to the
 * {@code android:useLevel} attribute on the inner {@code <gradient>}
 * tag, NOT the {@code android:useLevel} attribute on the outer
 * {@code <shape>} tag. For example,
 * <pre>{@code
 * <shape ...>
 *     <gradient
 *         ...
 *         android:useLevel="true" />
 * </shape>
 * }</pre><p>
 * <strong>Note</strong>: Changing this property will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing this property.
 *
 * @param useLevel {@code true} if the gradient should be scaled based on
 *                 level, {@code false} otherwise
 *
 * @see #mutate()
 * @see #setLevel(int)
 * @see #getLevel()
 * @see #getUseLevel()
 * @attr ref android.R.styleable#GradientDrawableGradient_useLevel
 * @apiSince 1
 */

public void setUseLevel(boolean useLevel) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this drawable's {@code level} property will be used to
 * scale the gradient.
 *
 * @return {@code true} if the gradient should be scaled based on level,
 *         {@code false} otherwise
 * @see #setUseLevel(boolean)
 * @attr ref android.R.styleable#GradientDrawableGradient_useLevel
 * @apiSince 24
 */

public boolean getUseLevel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the orientation of the gradient defined in this drawable.
 *
 * @return the orientation of the gradient defined in this drawable
 * @see #setOrientation(Orientation)
 * @apiSince 16
 */

public android.graphics.drawable.GradientDrawable.Orientation getOrientation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the orientation of the gradient defined in this drawable.
 * <p>
 * <strong>Note</strong>: changing orientation will affect all instances
 * of a drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing the orientation.
 *
 * @param orientation the desired orientation (angle) of the gradient
 *
 * @see #mutate()
 * @see #getOrientation()
 * @apiSince 16
 */

public void setOrientation(android.graphics.drawable.GradientDrawable.Orientation orientation) { throw new RuntimeException("Stub!"); }

/**
 * Sets the colors used to draw the gradient.
 * <p>
 * Each color is specified as an ARGB integer and the array must contain at
 * least 2 colors.
 * <p>
 * <strong>Note</strong>: changing colors will affect all instances of a
 * drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing the colors.
 *
 * @param colors an array containing 2 or more ARGB colors
 * This value may be {@code null}.
 * @see #mutate()
 * @see #setColor(int)
 * @apiSince 16
 */

public void setColors(@androidx.annotation.Nullable int[] colors) { throw new RuntimeException("Stub!"); }

/**
 * Sets the colors and offsets used to draw the gradient.
 * <p>
 * Each color is specified as an ARGB integer and the array must contain at
 * least 2 colors.
 * <p>
 * <strong>Note</strong>: changing colors will affect all instances of a
 * drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing the colors.
 *
 * @param colors an array containing 2 or more ARGB colors
 * This value may be {@code null}.
 * @param offsets optional array of floating point parameters representing the positions
 *                of the colors. Null evenly disperses the colors
 * This value may be {@code null}.
 * @see #mutate()
 * @see #setColors(int[])
 * @apiSince 29
 */

public void setColors(@androidx.annotation.Nullable int[] colors, @androidx.annotation.Nullable float[] offsets) { throw new RuntimeException("Stub!"); }

/**
 * Returns the colors used to draw the gradient, or {@code null} if the
 * gradient is drawn using a single color or no colors.
 *
 * @return the colors used to draw the gradient, or {@code null}
 * @see #setColors(int[] colors)
 * @apiSince 24
 */

@androidx.annotation.Nullable
public int[] getColors() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Inner radius of the ring expressed as a ratio of the ring's width.
 *
 * @see #getInnerRadiusRatio()
 * @attr ref android.R.styleable#GradientDrawable_innerRadiusRatio
 
 * @param innerRadiusRatio Value is 0.0f or greater
 * @apiSince 29
 */

public void setInnerRadiusRatio(float innerRadiusRatio) { throw new RuntimeException("Stub!"); }

/**
 * Return the inner radius of the ring expressed as a ratio of the ring's width.
 *
 * @see #setInnerRadiusRatio(float)
 * @attr ref android.R.styleable#GradientDrawable_innerRadiusRatio
 * @apiSince 29
 */

public float getInnerRadiusRatio() { throw new RuntimeException("Stub!"); }

/**
 * Configure the inner radius of the ring.
 *
 * @see #getInnerRadius()
 * @attr ref android.R.styleable#GradientDrawable_innerRadius
 
 * @param innerRadius This units of this value are pixels.
 * @apiSince 29
 */

public void setInnerRadius(int innerRadius) { throw new RuntimeException("Stub!"); }

/**
 * Retrn the inner radius of the ring
 *
 * <br>
 * This units of this value are pixels.
 * @see #setInnerRadius(int)
 * @attr ref android.R.styleable#GradientDrawable_innerRadius
 
 * @return This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public int getInnerRadius() { throw new RuntimeException("Stub!"); }

/**
 * Configure the thickness of the ring expressed as a ratio of the ring's width.
 *
 * @see #getThicknessRatio()
 * @attr ref android.R.styleable#GradientDrawable_thicknessRatio
 
 * @param thicknessRatio Value is 0.0f or greater
 * @apiSince 29
 */

public void setThicknessRatio(float thicknessRatio) { throw new RuntimeException("Stub!"); }

/**
 * Return the thickness ratio of the ring expressed as a ratio of the ring's width.
 *
 * @see #setThicknessRatio(float)
 * @attr ref android.R.styleable#GradientDrawable_thicknessRatio
 * @apiSince 29
 */

public float getThicknessRatio() { throw new RuntimeException("Stub!"); }

/**
 * Configure the thickness of the ring.
 *
 * @attr ref android.R.styleable#GradientDrawable_thickness
 
 * @param thickness This units of this value are pixels.
 * @apiSince 29
 */

public void setThickness(int thickness) { throw new RuntimeException("Stub!"); }

/**
 * Return the thickness of the ring
 *
 * <br>
 * This units of this value are pixels.
 * @see #setThickness(int)
 * @attr ref android.R.styleable#GradientDrawable_thickness
 
 * @return This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public int getThickness() { throw new RuntimeException("Stub!"); }

/**
 * Configure the padding of the gradient shape
 * @param left Left padding of the gradient shape
 * This units of this value are pixels.
 * @param top Top padding of the gradient shape
 * This units of this value are pixels.
 * @param right Right padding of the gradient shape
 * This units of this value are pixels.
 * @param bottom Bottom padding of the gradient shape
 *
 * This units of this value are pixels.
 * @attr ref android.R.styleable#GradientDrawablePadding_left
 * @attr ref android.R.styleable#GradientDrawablePadding_top
 * @attr ref android.R.styleable#GradientDrawablePadding_right
 * @attr ref android.R.styleable#GradientDrawablePadding_bottom
 * @apiSince 29
 */

public void setPadding(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Changes this drawable to use a single color instead of a gradient.
 * <p>
 * <strong>Note</strong>: changing color will affect all instances of a
 * drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing the color.
 *
 * @param argb The color used to fill the shape
 *
 * @see #mutate()
 * @see #setColors(int[])
 * @see #getColor
 * @apiSince 1
 */

public void setColor(int argb) { throw new RuntimeException("Stub!"); }

/**
 * Changes this drawable to use a single color state list instead of a
 * gradient. Calling this method with a null argument will clear the color
 * and is equivalent to calling {@link #setColor(int)} with the argument
 * {@link android.graphics.Color#TRANSPARENT Color#TRANSPARENT}.
 * <p>
 * <strong>Note</strong>: changing color will affect all instances of a
 * drawable loaded from a resource. It is recommended to invoke
 * {@link #mutate()} before changing the color.</p>
 *
 * @param colorStateList The color state list used to fill the shape
 *
 * This value may be {@code null}.
 * @see #mutate()
 * @see #getColor
 * @apiSince 21
 */

public void setColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) { throw new RuntimeException("Stub!"); }

/**
 * Returns the color state list used to fill the shape, or {@code null} if
 * the shape is filled with a gradient or has no fill color.
 *
 * @return the color state list used to fill this gradient, or {@code null}
 *
 * @see #setColor(int)
 * @see #setColor(ColorStateList)
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.content.res.ColorStateList getColor() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

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

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onBoundsChange(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param r This value must never be {@code null}.
 
 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.
 
 * @param theme This value may be {@code null}.
 * @apiSince 21
 */

public void inflate(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.NonNull android.util.AttributeSet attrs, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param t This value must never be {@code null}.
 * @apiSince 21
 */

public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public android.graphics.Insets getOpticalInsets() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void getOutline(android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * Shape is a line
 * @apiSince 1
 */

public static final int LINE = 2; // 0x2

/**
 * Gradient is linear (default.)
 * @apiSince 1
 */

public static final int LINEAR_GRADIENT = 0; // 0x0

/**
 * Shape is an ellipse
 * @apiSince 1
 */

public static final int OVAL = 1; // 0x1

/**
 * Gradient is circular.
 * @apiSince 1
 */

public static final int RADIAL_GRADIENT = 1; // 0x1

/**
 * Shape is a rectangle, possibly with rounded corners
 * @apiSince 1
 */

public static final int RECTANGLE = 0; // 0x0

/**
 * Shape is a ring.
 * @apiSince 1
 */

public static final int RING = 3; // 0x3

/**
 * Gradient is a sweep.
 * @apiSince 1
 */

public static final int SWEEP_GRADIENT = 2; // 0x2
/**
 * Controls how the gradient is oriented relative to the drawable's bounds
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Orientation {
/**
 * draw the gradient from the top to the bottom
 * @apiSince 1
 */

TOP_BOTTOM,
/**
 * draw the gradient from the top-right to the bottom-left
 * @apiSince 1
 */

TR_BL,
/**
 * draw the gradient from the right to the left
 * @apiSince 1
 */

RIGHT_LEFT,
/**
 * draw the gradient from the bottom-right to the top-left
 * @apiSince 1
 */

BR_TL,
/**
 * draw the gradient from the bottom to the top
 * @apiSince 1
 */

BOTTOM_TOP,
/**
 * draw the gradient from the bottom-left to the top-right
 * @apiSince 1
 */

BL_TR,
/**
 * draw the gradient from the left to the right
 * @apiSince 1
 */

LEFT_RIGHT,
/**
 * draw the gradient from the top-left to the bottom-right
 * @apiSince 1
 */

TL_BR;
}

}

