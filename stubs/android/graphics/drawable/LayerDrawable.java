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
import android.view.View;
import android.view.Gravity;
import android.graphics.Rect;
import android.graphics.Outline;
import android.graphics.PixelFormat;

/**
 * A Drawable that manages an array of other Drawables. These are drawn in array
 * order, so the element with the largest index will be drawn on top.
 * <p>
 * It can be defined in an XML file with the <code>&lt;layer-list></code> element.
 * Each Drawable in the layer is defined in a nested <code>&lt;item></code>.
 * <p>
 * For more information, see the guide to
 * <a href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.
 *
 * @attr ref android.R.styleable#LayerDrawable_paddingMode
 * @attr ref android.R.styleable#LayerDrawableItem_left
 * @attr ref android.R.styleable#LayerDrawableItem_top
 * @attr ref android.R.styleable#LayerDrawableItem_right
 * @attr ref android.R.styleable#LayerDrawableItem_bottom
 * @attr ref android.R.styleable#LayerDrawableItem_start
 * @attr ref android.R.styleable#LayerDrawableItem_end
 * @attr ref android.R.styleable#LayerDrawableItem_width
 * @attr ref android.R.styleable#LayerDrawableItem_height
 * @attr ref android.R.styleable#LayerDrawableItem_gravity
 * @attr ref android.R.styleable#LayerDrawableItem_drawable
 * @attr ref android.R.styleable#LayerDrawableItem_id
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LayerDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {

/**
 * Creates a new layer drawable with the list of specified layers.
 *
 * @param layers a list of drawables to use as layers in this new drawable,
 *               must be non-null
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public LayerDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable[] layers) { throw new RuntimeException("Stub!"); }

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

/**
 * @hide
 */

public boolean isProjected() { throw new RuntimeException("Stub!"); }

/**
 * Adds a new layer containing the specified {@code drawable} to the end of
 * the layer list and returns its index.
 *
 * @param dr The drawable to add as a new layer.
 * @return The index of the new layer.
 * @apiSince 23
 */

public int addLayer(android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/**
 * Looks for a layer with the given ID and returns its {@link android.graphics.drawable.Drawable Drawable}.
 * <p>
 * If multiple layers are found for the given ID, returns the
 * {@link android.graphics.drawable.Drawable Drawable} for the matching layer at the highest index.
 *
 * @param id The layer ID to search for.
 * @return The {@link android.graphics.drawable.Drawable Drawable} for the highest-indexed layer that has the
 *         given ID, or null if not found.
 * @apiSince 1
 */

public android.graphics.drawable.Drawable findDrawableByLayerId(int id) { throw new RuntimeException("Stub!"); }

/**
 * Sets the ID of a layer.
 *
 * @param index The index of the layer to modify, must be in the range
 *              {@code 0...getNumberOfLayers()-1}.
 * @param id The id to assign to the layer.
 *
 * @see #getId(int)
 * @attr ref android.R.styleable#LayerDrawableItem_id
 * @apiSince 1
 */

public void setId(int index, int id) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of the specified layer.
 *
 * @param index The index of the layer, must be in the range
 *              {@code 0...getNumberOfLayers()-1}.
 * @return The id of the layer or {@link android.view.View#NO_ID} if the
 *         layer has no id.
 *
 * @see #setId(int, int)
 * @attr ref android.R.styleable#LayerDrawableItem_id
 * @apiSince 1
 */

public int getId(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of layers contained within this layer drawable.
 *
 * @return The number of layers.
 * @apiSince 1
 */

public int getNumberOfLayers() { throw new RuntimeException("Stub!"); }

/**
 * Replaces the {@link android.graphics.drawable.Drawable Drawable} for the layer with the given id.
 *
 * @param id The layer ID to search for.
 * @param drawable The replacement {@link android.graphics.drawable.Drawable Drawable}.
 * @return Whether the {@link android.graphics.drawable.Drawable Drawable} was replaced (could return false if
 *         the id was not found).
 * @apiSince 1
 */

public boolean setDrawableByLayerId(int id, android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Returns the layer with the specified {@code id}.
 * <p>
 * If multiple layers have the same ID, returns the layer with the lowest
 * index.
 *
 * @param id The ID of the layer to return.
 * @return The index of the layer with the specified ID.
 * @apiSince 23
 */

public int findIndexByLayerId(int id) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable for the layer at the specified index.
 *
 * @param index The index of the layer to modify, must be in the range
 *              {@code 0...getNumberOfLayers()-1}.
 * @param drawable The drawable to set for the layer.
 *
 * @see #getDrawable(int)
 * @attr ref android.R.styleable#LayerDrawableItem_drawable
 * @apiSince 23
 */

public void setDrawable(int index, android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Returns the drawable for the layer at the specified index.
 *
 * @param index The index of the layer, must be in the range
 *              {@code 0...getNumberOfLayers()-1}.
 * @return The {@link android.graphics.drawable.Drawable Drawable} at the specified layer index.
 *
 * @see #setDrawable(int, Drawable)
 * @attr ref android.R.styleable#LayerDrawableItem_drawable
 * @apiSince 1
 */

public android.graphics.drawable.Drawable getDrawable(int index) { throw new RuntimeException("Stub!"); }

/**
 * Sets an explicit size for the specified layer.
 * <p>
 * <strong>Note:</strong> Setting an explicit layer size changes the
 * default layer gravity behavior. See {@link #setLayerGravity(int,int)}
 * for more information.
 *
 * @param index the index of the layer to adjust
 * @param w width in pixels, or -1 to use the intrinsic width
 * @param h height in pixels, or -1 to use the intrinsic height
 * @see #getLayerWidth(int)
 * @see #getLayerHeight(int)
 * @attr ref android.R.styleable#LayerDrawableItem_width
 * @attr ref android.R.styleable#LayerDrawableItem_height
 * @apiSince 23
 */

public void setLayerSize(int index, int w, int h) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param w width in pixels, or -1 to use the intrinsic width
 * @attr ref android.R.styleable#LayerDrawableItem_width
 * @apiSince 23
 */

public void setLayerWidth(int index, int w) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the drawable to adjust
 * @return the explicit width of the layer, or -1 if not specified
 * @see #setLayerSize(int, int, int)
 * @attr ref android.R.styleable#LayerDrawableItem_width
 * @apiSince 23
 */

public int getLayerWidth(int index) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param h height in pixels, or -1 to use the intrinsic height
 * @attr ref android.R.styleable#LayerDrawableItem_height
 * @apiSince 23
 */

public void setLayerHeight(int index, int h) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the drawable to adjust
 * @return the explicit height of the layer, or -1 if not specified
 * @see #setLayerSize(int, int, int)
 * @attr ref android.R.styleable#LayerDrawableItem_height
 * @apiSince 23
 */

public int getLayerHeight(int index) { throw new RuntimeException("Stub!"); }

/**
 * Sets the gravity used to position or stretch the specified layer within
 * its container. Gravity is applied after any layer insets (see
 * {@link #setLayerInset(int,int,int,int,int)}) or padding (see
 * {@link #setPaddingMode(int)}).
 * <p>
 * If gravity is specified as {@link android.view.Gravity#NO_GRAVITY Gravity#NO_GRAVITY}, the default
 * behavior depends on whether an explicit width or height has been set
 * (see {@link #setLayerSize(int,int,int)}), If a dimension is not set,
 * gravity in that direction defaults to {@link android.view.Gravity#FILL_HORIZONTAL Gravity#FILL_HORIZONTAL} or
 * {@link android.view.Gravity#FILL_VERTICAL Gravity#FILL_VERTICAL}; otherwise, gravity in that direction
 * defaults to {@link android.view.Gravity#LEFT Gravity#LEFT} or {@link android.view.Gravity#TOP Gravity#TOP}.
 *
 * @param index the index of the drawable to adjust
 * @param gravity the gravity to set for the layer
 *
 * @see #getLayerGravity(int)
 * @attr ref android.R.styleable#LayerDrawableItem_gravity
 * @apiSince 23
 */

public void setLayerGravity(int index, int gravity) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer
 * @return the gravity used to position or stretch the specified layer
 *         within its container
 *
 * @see #setLayerGravity(int, int)
 * @attr ref android.R.styleable#LayerDrawableItem_gravity
 * @apiSince 23
 */

public int getLayerGravity(int index) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the insets in pixels for the drawable at the specified index.
 *
 * @param index the index of the drawable to adjust
 * @param l number of pixels to add to the left bound
 * @param t number of pixels to add to the top bound
 * @param r number of pixels to subtract from the right bound
 * @param b number of pixels to subtract from the bottom bound
 *
 * @attr ref android.R.styleable#LayerDrawableItem_left
 * @attr ref android.R.styleable#LayerDrawableItem_top
 * @attr ref android.R.styleable#LayerDrawableItem_right
 * @attr ref android.R.styleable#LayerDrawableItem_bottom
 * @apiSince 1
 */

public void setLayerInset(int index, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the relative insets in pixels for the drawable at the
 * specified index.
 *
 * @param index the index of the layer to adjust
 * @param s number of pixels to inset from the start bound
 * @param t number of pixels to inset from the top bound
 * @param e number of pixels to inset from the end bound
 * @param b number of pixels to inset from the bottom bound
 *
 * @attr ref android.R.styleable#LayerDrawableItem_start
 * @attr ref android.R.styleable#LayerDrawableItem_top
 * @attr ref android.R.styleable#LayerDrawableItem_end
 * @attr ref android.R.styleable#LayerDrawableItem_bottom
 * @apiSince 23
 */

public void setLayerInsetRelative(int index, int s, int t, int e, int b) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param l number of pixels to inset from the left bound
 * @attr ref android.R.styleable#LayerDrawableItem_left
 * @apiSince 23
 */

public void setLayerInsetLeft(int index, int l) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer
 * @return number of pixels to inset from the left bound
 * @attr ref android.R.styleable#LayerDrawableItem_left
 * @apiSince 23
 */

public int getLayerInsetLeft(int index) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param r number of pixels to inset from the right bound
 * @attr ref android.R.styleable#LayerDrawableItem_right
 * @apiSince 23
 */

public void setLayerInsetRight(int index, int r) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer
 * @return number of pixels to inset from the right bound
 * @attr ref android.R.styleable#LayerDrawableItem_right
 * @apiSince 23
 */

public int getLayerInsetRight(int index) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param t number of pixels to inset from the top bound
 * @attr ref android.R.styleable#LayerDrawableItem_top
 * @apiSince 23
 */

public void setLayerInsetTop(int index, int t) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer
 * @return number of pixels to inset from the top bound
 * @attr ref android.R.styleable#LayerDrawableItem_top
 * @apiSince 23
 */

public int getLayerInsetTop(int index) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param b number of pixels to inset from the bottom bound
 * @attr ref android.R.styleable#LayerDrawableItem_bottom
 * @apiSince 23
 */

public void setLayerInsetBottom(int index, int b) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer
 * @return number of pixels to inset from the bottom bound
 * @attr ref android.R.styleable#LayerDrawableItem_bottom
 * @apiSince 23
 */

public int getLayerInsetBottom(int index) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param s number of pixels to inset from the start bound
 * @attr ref android.R.styleable#LayerDrawableItem_start
 * @apiSince 23
 */

public void setLayerInsetStart(int index, int s) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer
 * @return the number of pixels to inset from the start bound, or
 *         {@link #INSET_UNDEFINED} if not specified
 * @attr ref android.R.styleable#LayerDrawableItem_start
 * @apiSince 23
 */

public int getLayerInsetStart(int index) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer to adjust
 * @param e number of pixels to inset from the end bound, or
 *         {@link #INSET_UNDEFINED} if not specified
 * @attr ref android.R.styleable#LayerDrawableItem_end
 * @apiSince 23
 */

public void setLayerInsetEnd(int index, int e) { throw new RuntimeException("Stub!"); }

/**
 * @param index the index of the layer
 * @return number of pixels to inset from the end bound
 * @attr ref android.R.styleable#LayerDrawableItem_end
 * @apiSince 23
 */

public int getLayerInsetEnd(int index) { throw new RuntimeException("Stub!"); }

/**
 * Specifies how layer padding should affect the bounds of subsequent
 * layers. The default value is {@link #PADDING_MODE_NEST}.
 *
 * @param mode padding mode, one of:
 *            <ul>
 *            <li>{@link #PADDING_MODE_NEST} to nest each layer inside the
 *            padding of the previous layer
 *            <li>{@link #PADDING_MODE_STACK} to stack each layer directly
 *            atop the previous layer
 *            </ul>
 *
 * @see #getPaddingMode()
 * @attr ref android.R.styleable#LayerDrawable_paddingMode
 * @apiSince 21
 */

public void setPaddingMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * @return the current padding mode
 *
 * @see #setPaddingMode(int)
 * @attr ref android.R.styleable#LayerDrawable_paddingMode
 * @apiSince 21
 */

public int getPaddingMode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 1
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 1
 */

public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param who This value must never be {@code null}.
 
 * @param what This value must never be {@code null}.
 * @apiSince 1
 */

public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who, @androidx.annotation.NonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getPadding(android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * Sets the absolute padding.
 * <p>
 * If padding in a dimension is specified as {@code -1}, the resolved
 * padding will use the value computed according to the padding mode (see
 * {@link #setPaddingMode(int)}).
 * <p>
 * Calling this method clears any relative padding values previously set
 * using {@link #setPaddingRelative(int,int,int,int)}.
 *
 * @param left the left padding in pixels, or -1 to use computed padding
 * @param top the top padding in pixels, or -1 to use computed padding
 * @param right the right padding in pixels, or -1 to use computed padding
 * @param bottom the bottom padding in pixels, or -1 to use computed
 *               padding
 * @attr ref android.R.styleable#LayerDrawable_paddingLeft
 * @attr ref android.R.styleable#LayerDrawable_paddingTop
 * @attr ref android.R.styleable#LayerDrawable_paddingRight
 * @attr ref android.R.styleable#LayerDrawable_paddingBottom
 * @see #setPaddingRelative(int, int, int, int)
 * @apiSince 23
 */

public void setPadding(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative padding.
 * <p>
 * If padding in a dimension is specified as {@code -1}, the resolved
 * padding will use the value computed according to the padding mode (see
 * {@link #setPaddingMode(int)}).
 * <p>
 * Calling this method clears any absolute padding values previously set
 * using {@link #setPadding(int,int,int,int)}.
 *
 * @param start the start padding in pixels, or -1 to use computed padding
 * @param top the top padding in pixels, or -1 to use computed padding
 * @param end the end padding in pixels, or -1 to use computed padding
 * @param bottom the bottom padding in pixels, or -1 to use computed
 *               padding
 * @attr ref android.R.styleable#LayerDrawable_paddingStart
 * @attr ref android.R.styleable#LayerDrawable_paddingTop
 * @attr ref android.R.styleable#LayerDrawable_paddingEnd
 * @attr ref android.R.styleable#LayerDrawable_paddingBottom
 * @see #setPadding(int, int, int, int)
 * @apiSince 23
 */

public void setPaddingRelative(int start, int top, int end, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Returns the left padding in pixels.
 * <p>
 * A return value of {@code -1} means there is no explicit padding set for
 * this dimension. As a result, the value for this dimension returned by
 * {@link #getPadding(android.graphics.Rect)} will be computed from the child layers
 * according to the padding mode (see {@link #getPaddingMode()}.
 *
 * @return the left padding in pixels, or -1 if not explicitly specified
 * @see #setPadding(int, int, int, int)
 * @see #getPadding(Rect)
 * @apiSince 23
 */

public int getLeftPadding() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right padding in pixels.
 * <p>
 * A return value of {@code -1} means there is no explicit padding set for
 * this dimension. As a result, the value for this dimension returned by
 * {@link #getPadding(android.graphics.Rect)} will be computed from the child layers
 * according to the padding mode (see {@link #getPaddingMode()}.
 *
 * @return the right padding in pixels, or -1 if not explicitly specified
 * @see #setPadding(int, int, int, int)
 * @see #getPadding(Rect)
 * @apiSince 23
 */

public int getRightPadding() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start padding in pixels.
 * <p>
 * A return value of {@code -1} means there is no explicit padding set for
 * this dimension. As a result, the value for this dimension returned by
 * {@link #getPadding(android.graphics.Rect)} will be computed from the child layers
 * according to the padding mode (see {@link #getPaddingMode()}.
 *
 * @return the start padding in pixels, or -1 if not explicitly specified
 * @see #setPaddingRelative(int, int, int, int)
 * @see #getPadding(Rect)
 * @apiSince 23
 */

public int getStartPadding() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end padding in pixels.
 * <p>
 * A return value of {@code -1} means there is no explicit padding set for
 * this dimension. As a result, the value for this dimension returned by
 * {@link #getPadding(android.graphics.Rect)} will be computed from the child layers
 * according to the padding mode (see {@link #getPaddingMode()}.
 *
 * @return the end padding in pixels, or -1 if not explicitly specified
 * @see #setPaddingRelative(int, int, int, int)
 * @see #getPadding(Rect)
 * @apiSince 23
 */

public int getEndPadding() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top padding in pixels.
 * <p>
 * A return value of {@code -1} means there is no explicit padding set for
 * this dimension. As a result, the value for this dimension returned by
 * {@link #getPadding(android.graphics.Rect)} will be computed from the child layers
 * according to the padding mode (see {@link #getPaddingMode()}.
 *
 * @return the top padding in pixels, or -1 if not explicitly specified
 * @see #setPadding(int, int, int, int)
 * @see #setPaddingRelative(int, int, int, int)
 * @see #getPadding(Rect)
 * @apiSince 23
 */

public int getTopPadding() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bottom padding in pixels.
 * <p>
 * A return value of {@code -1} means there is no explicit padding set for
 * this dimension. As a result, the value for this dimension returned by
 * {@link #getPadding(android.graphics.Rect)} will be computed from the child layers
 * according to the padding mode (see {@link #getPaddingMode()}.
 *
 * @return the bottom padding in pixels, or -1 if not explicitly specified
 * @see #setPadding(int, int, int, int)
 * @see #setPaddingRelative(int, int, int, int)
 * @see #getPadding(Rect)
 * @apiSince 23
 */

public int getBottomPadding() { throw new RuntimeException("Stub!"); }

/**
 * Populates <code>outline</code> with the first available (non-empty) layer outline.
 *
 * @param outline Outline in which to place the first available layer outline
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void getHotspotBounds(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param blendMode This value must never be {@code null}.
 * @apiSince 29
 */

public void setTintBlendMode(@androidx.annotation.NonNull android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the opacity of this drawable directly instead of collecting the
 * states from the layers.
 *
 * @param opacity The opacity to use, or {@link android.graphics.PixelFormat#UNKNOWN PixelFormat#UNKNOWN} for the default behavior
 * @see android.graphics.PixelFormat#UNKNOWN
 * @see android.graphics.PixelFormat#TRANSLUCENT
 * @see android.graphics.PixelFormat#TRANSPARENT
 * @see android.graphics.PixelFormat#OPAQUE
 * @apiSince 11
 */

public void setOpacity(int opacity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOpacity() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void jumpToCurrentState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param layoutDirection Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @apiSince 23
 */

public boolean onLayoutDirectionChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Value used for undefined start and end insets.
 *
 * @see #getLayerInsetStart(int)
 * @see #getLayerInsetEnd(int)
 * @apiSince 24
 */

public static final int INSET_UNDEFINED = -2147483648; // 0x80000000

/**
 * Padding mode used to nest each layer inside the padding of the previous
 * layer.
 *
 * @see #setPaddingMode(int)
 * @apiSince 21
 */

public static final int PADDING_MODE_NEST = 0; // 0x0

/**
 * Padding mode used to stack each layer directly atop the previous layer.
 *
 * @see #setPaddingMode(int)
 * @apiSince 21
 */

public static final int PADDING_MODE_STACK = 1; // 0x1
}

