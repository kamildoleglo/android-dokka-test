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


package android.widget;

import android.graphics.PorterDuff;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.view.View;
import android.net.Uri;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.graphics.drawable.Icon;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Matrix;
import android.graphics.ColorFilter;

/**
 * Displays image resources, for example {@link android.graphics.Bitmap}
 * or {@link android.graphics.drawable.Drawable} resources.
 * ImageView is also commonly used to
 * <a href="#setImageTintMode(android.graphics.PorterDuff.Mode)">apply tints to an image</a> and
 * handle <a href="#setScaleType(android.widget.ImageView.ScaleType)">image scaling</a>.
 *
 * <p>
 * The following XML snippet is a common example of using an ImageView to display an image resource:
 * </p>
 * <pre>
 * &lt;LinearLayout
 *     xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"&gt;
 *     &lt;ImageView
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:src="@drawable/my_image"
 *         android:contentDescription="@string/my_image_description"
 *         /&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 *
 * <p>
 * To learn more about Drawables, see: <a href="{@docRoot}guide/topics/resources/drawable-resource.html">Drawable Resources</a>.
 * To learn more about working with Bitmaps, see: <a href="{@docRoot}topic/performance/graphics/index.html">Handling Bitmaps</a>.
 * </p>
 *
 * @attr ref android.R.styleable#ImageView_adjustViewBounds
 * @attr ref android.R.styleable#ImageView_src
 * @attr ref android.R.styleable#ImageView_maxWidth
 * @attr ref android.R.styleable#ImageView_maxHeight
 * @attr ref android.R.styleable#ImageView_tint
 * @attr ref android.R.styleable#ImageView_scaleType
 * @attr ref android.R.styleable#ImageView_cropToPadding
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class ImageView extends android.view.View {

/** @apiSince 1 */

public ImageView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public ImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public ImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 21
 */

public ImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dr This value must never be {@code null}.
 * @apiSince 1
 */

protected boolean verifyDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dr This value must never be {@code null}.
 * @apiSince 1
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean hasOverlappingRendering() { throw new RuntimeException("Stub!"); }

/**
 * True when ImageView is adjusting its bounds
 * to preserve the aspect ratio of its drawable
 *
 * @return whether to adjust the bounds of this view
 * to preserve the original aspect ratio of the drawable
 *
 * @see #setAdjustViewBounds(boolean)
 *
 * @attr ref android.R.styleable#ImageView_adjustViewBounds
 * @apiSince 16
 */

public boolean getAdjustViewBounds() { throw new RuntimeException("Stub!"); }

/**
 * Set this to true if you want the ImageView to adjust its bounds
 * to preserve the aspect ratio of its drawable.
 *
 * <p><strong>Note:</strong> If the application targets API level 17 or lower,
 * adjustViewBounds will allow the drawable to shrink the view bounds, but not grow
 * to fill available measured space in all cases. This is for compatibility with
 * legacy {@link android.view.View.MeasureSpec MeasureSpec} and
 * {@link android.widget.RelativeLayout RelativeLayout} behavior.</p>
 *
 * @param adjustViewBounds Whether to adjust the bounds of this view
 * to preserve the original aspect ratio of the drawable.
 *
 * @see #getAdjustViewBounds()
 *
 * @attr ref android.R.styleable#ImageView_adjustViewBounds
 * @apiSince 1
 */

public void setAdjustViewBounds(boolean adjustViewBounds) { throw new RuntimeException("Stub!"); }

/**
 * The maximum width of this view.
 *
 * @return The maximum width of this view
 *
 * @see #setMaxWidth(int)
 *
 * @attr ref android.R.styleable#ImageView_maxWidth
 * @apiSince 16
 */

public int getMaxWidth() { throw new RuntimeException("Stub!"); }

/**
 * An optional argument to supply a maximum width for this view. Only valid if
 * {@link #setAdjustViewBounds(boolean)} has been set to true. To set an image to be a maximum
 * of 100 x 100 while preserving the original aspect ratio, do the following: 1) set
 * adjustViewBounds to true 2) set maxWidth and maxHeight to 100 3) set the height and width
 * layout params to WRAP_CONTENT.
 *
 * <p>
 * Note that this view could be still smaller than 100 x 100 using this approach if the original
 * image is small. To set an image to a fixed size, specify that size in the layout params and
 * then use {@link #setScaleType(android.widget.ImageView.ScaleType)} to determine how to fit
 * the image within the bounds.
 * </p>
 *
 * @param maxWidth maximum width for this view
 *
 * @see #getMaxWidth()
 *
 * @attr ref android.R.styleable#ImageView_maxWidth
 * @apiSince 1
 */

public void setMaxWidth(int maxWidth) { throw new RuntimeException("Stub!"); }

/**
 * The maximum height of this view.
 *
 * @return The maximum height of this view
 *
 * @see #setMaxHeight(int)
 *
 * @attr ref android.R.styleable#ImageView_maxHeight
 * @apiSince 16
 */

public int getMaxHeight() { throw new RuntimeException("Stub!"); }

/**
 * An optional argument to supply a maximum height for this view. Only valid if
 * {@link #setAdjustViewBounds(boolean)} has been set to true. To set an image to be a
 * maximum of 100 x 100 while preserving the original aspect ratio, do the following: 1) set
 * adjustViewBounds to true 2) set maxWidth and maxHeight to 100 3) set the height and width
 * layout params to WRAP_CONTENT.
 *
 * <p>
 * Note that this view could be still smaller than 100 x 100 using this approach if the original
 * image is small. To set an image to a fixed size, specify that size in the layout params and
 * then use {@link #setScaleType(android.widget.ImageView.ScaleType)} to determine how to fit
 * the image within the bounds.
 * </p>
 *
 * @param maxHeight maximum height for this view
 *
 * @see #getMaxHeight()
 *
 * @attr ref android.R.styleable#ImageView_maxHeight
 * @apiSince 1
 */

public void setMaxHeight(int maxHeight) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current Drawable, or null if no Drawable has been
 * assigned.
 *
 * @return the view's drawable, or null if no drawable has been
 * assigned.
 * @apiSince 1
 */

public android.graphics.drawable.Drawable getDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Sets a drawable as the content of this ImageView.
 * <p class="note">This does Bitmap reading and decoding on the UI
 * thread, which can cause a latency hiccup.  If that's a concern,
 * consider using {@link #setImageDrawable(android.graphics.drawable.Drawable)} or
 * {@link #setImageBitmap(android.graphics.Bitmap)} and
 * {@link android.graphics.BitmapFactory} instead.</p>
 *
 * @param resId the resource identifier of the drawable
 *
 * @attr ref android.R.styleable#ImageView_src
 * @apiSince 1
 */

public void setImageResource(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the content of this ImageView to the specified Uri.
 * Note that you use this method to load images from a local Uri only.
 * <p/>
 * To learn how to display images from a remote Uri see: <a href="https://developer.android.com/topic/performance/graphics/index.html">Handling Bitmaps</a>
 * <p/>
 * <p class="note">This does Bitmap reading and decoding on the UI
 * thread, which can cause a latency hiccup.  If that's a concern,
 * consider using {@link #setImageDrawable(android.graphics.drawable.Drawable)} or
 * {@link #setImageBitmap(android.graphics.Bitmap)} and
 * {@link android.graphics.BitmapFactory} instead.</p>
 *
 * <p class="note">On devices running SDK < 24, this method will fail to
 * apply correct density scaling to images loaded from
 * {@link android.content.ContentResolver#SCHEME_CONTENT ContentResolver#SCHEME_CONTENT} and
 * {@link android.content.ContentResolver#SCHEME_FILE ContentResolver#SCHEME_FILE} schemes. Applications running
 * on devices with SDK >= 24 <strong>MUST</strong> specify the
 * {@code targetSdkVersion} in their manifest as 24 or above for density
 * scaling to be applied to images loaded from these schemes.</p>
 *
 * @param uri the Uri of an image, or {@code null} to clear the content
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setImageURI(@androidx.annotation.Nullable android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Sets a drawable as the content of this ImageView.
 *
 * @param drawable the Drawable to set, or {@code null} to clear the
 *                 content
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setImageDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the content of this ImageView to the specified Icon.
 *
 * <p class="note">Depending on the Icon type, this may do Bitmap reading
 * and decoding on the UI thread, which can cause UI jank.  If that's a
 * concern, consider using
 * {@link android.graphics.drawable.Icon#loadDrawableAsync(android.content.Context,android.graphics.drawable.Icon.OnDrawableLoadedListener,android.os.Handler) Icon#loadDrawableAsync(Context, Icon.OnDrawableLoadedListener, Handler)}
 * and then {@link #setImageDrawable(android.graphics.drawable.Drawable)}
 * instead.</p>
 *
 * @param icon an Icon holding the desired image, or {@code null} to clear
 *             the content
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void setImageIcon(@androidx.annotation.Nullable android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the image drawable. Does not modify the current tint
 * mode, which is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setImageDrawable(android.graphics.drawable.Drawable)} will automatically
 * mutate the drawable and apply the specified tint and tint mode using
 * {@link android.graphics.drawable.Drawable#setTintList(android.content.res.ColorStateList) Drawable#setTintList(ColorStateList)}.
 * <p>
 * <em>Note:</em> The default tint mode used by this setter is NOT
 * consistent with the default tint mode used by the
 * {@link android.R.styleable#ImageView_tint android:tint}
 * attribute. If the {@code android:tint} attribute is specified, the
 * default tint mode will be set to {@link android.graphics.PorterDuff.Mode#SRC_ATOP PorterDuff.Mode#SRC_ATOP} to
 * ensure consistency with earlier versions of the platform.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ImageView_tint
 * @see #getImageTintList()
 * @see android.graphics.drawable.Drawable#setTintList(ColorStateList)
 * @apiSince 21
 */

public void setImageTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Get the current {@link android.content.res.ColorStateList} used to tint the image Drawable,
 * or null if no tint is applied.
 *
 * @return the tint applied to the image drawable
 * @attr ref android.R.styleable#ImageView_tint
 * @see #setImageTintList(ColorStateList)
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.content.res.ColorStateList getImageTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setImageTintList(android.content.res.ColorStateList)}} to the image drawable. The default
 * mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ImageView_tintMode
 * @see #getImageTintMode()
 * @see android.graphics.drawable.Drawable#setTintMode(PorterDuff.Mode)
 * @apiSince 21
 */

public void setImageTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setImageTintList(android.content.res.ColorStateList)}} to the image drawable. The default
 * mode is {@link android.graphics.BlendMode#SRC_IN BlendMode#SRC_IN}.
 *
 * @param blendMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ImageView_tintMode
 * @see #getImageTintMode()
 * @see android.graphics.drawable.Drawable#setTintBlendMode(BlendMode)
 * @apiSince 29
 */

public void setImageTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the blending mode used to apply the tint to the image Drawable
 * @return the blending mode used to apply the tint to the image Drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ImageView_tintMode
 * @see #setImageTintMode(PorterDuff.Mode)
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.PorterDuff.Mode getImageTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the blending mode used to apply the tint to the image Drawable
 * @return the blending mode used to apply the tint to the image Drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ImageView_tintMode
 * @see #setImageTintBlendMode(BlendMode)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.BlendMode getImageTintBlendMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets a Bitmap as the content of this ImageView.
 *
 * @param bm The bitmap to set
 * @apiSince 1
 */

public void setImageBitmap(android.graphics.Bitmap bm) { throw new RuntimeException("Stub!"); }

/**
 * Set the state of the current {@link android.graphics.drawable.StateListDrawable}.
 * For more information about State List Drawables, see: <a href="https://developer.android.com/guide/topics/resources/drawable-resource.html#StateList">the Drawable Resource Guide</a>.
 *
 * @param state the state to set for the StateListDrawable
 * @param merge if true, merges the state values for the state you specify into the current state
 * @apiSince 1
 */

public void setImageState(int[] state, boolean merge) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setSelected(boolean selected) { throw new RuntimeException("Stub!"); }

/**
 * Sets the image level, when it is constructed from a
 * {@link android.graphics.drawable.LevelListDrawable}.
 *
 * @param level The new level for the image.
 * @apiSince 1
 */

public void setImageLevel(int level) { throw new RuntimeException("Stub!"); }

/**
 * Controls how the image should be resized or moved to match the size
 * of this ImageView.
 *
 * @param scaleType The desired scaling mode.
 *
 * @attr ref android.R.styleable#ImageView_scaleType
 * @apiSince 1
 */

public void setScaleType(android.widget.ImageView.ScaleType scaleType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current ScaleType that is used to scale the bounds of an image to the bounds of the ImageView.
 * @return The ScaleType used to scale the image.
 * @see android.widget.ImageView.ScaleType
 * @attr ref android.R.styleable#ImageView_scaleType
 * @apiSince 1
 */

public android.widget.ImageView.ScaleType getScaleType() { throw new RuntimeException("Stub!"); }

/** Returns the view's optional matrix. This is applied to the
 view's drawable when it is drawn. If there is no matrix,
 this method will return an identity matrix.
 Do not change this matrix in place but make a copy.
 If you want a different matrix applied to the drawable,
 be sure to call setImageMatrix().
 @apiSince 1
 */

public android.graphics.Matrix getImageMatrix() { throw new RuntimeException("Stub!"); }

/**
 * Adds a transformation {@link android.graphics.Matrix Matrix} that is applied
 * to the view's drawable when it is drawn.  Allows custom scaling,
 * translation, and perspective distortion.
 *
 * @param matrix The transformation parameters in matrix form.
 * @apiSince 1
 */

public void setImageMatrix(android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this ImageView crops to padding.
 *
 * @return whether this ImageView crops to padding
 *
 * @see #setCropToPadding(boolean)
 *
 * @attr ref android.R.styleable#ImageView_cropToPadding
 * @apiSince 16
 */

public boolean getCropToPadding() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this ImageView will crop to padding.
 *
 * @param cropToPadding whether this ImageView will crop to padding
 *
 * @see #getCropToPadding()
 *
 * @attr ref android.R.styleable#ImageView_cropToPadding
 * @apiSince 16
 */

public void setCropToPadding(boolean cropToPadding) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean setFrame(int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Applies a temporary transformation {@link android.graphics.Matrix Matrix} to the view's drawable when it is drawn.
 * Allows custom scaling, translation, and perspective distortion during an animation.
 *
 * This method is a lightweight analogue of {@link android.widget.ImageView#setImageMatrix(android.graphics.Matrix) ImageView#setImageMatrix(Matrix)} to use
 * only during animations as this matrix will be cleared after the next drawable
 * update or view's bounds change.
 *
 * @param matrix The transformation parameters in matrix form.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void animateTransform(@androidx.annotation.Nullable android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the offset of the widget's text baseline from the widget's top
 * boundary. </p>
 *
 * @return the offset of the baseline within the widget's bounds or -1
 *         if baseline alignment is not supported.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout")
public int getBaseline() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the offset of the widget's text baseline from the widget's top
 * boundary.  This value is overridden by the {@link #setBaselineAlignBottom(boolean)}
 * property.</p>
 *
 * @param baseline The baseline to use, or -1 if none is to be provided.
 *
 * @see #setBaseline(int)
 * @attr ref android.R.styleable#ImageView_baseline
 * @apiSince 11
 */

public void setBaseline(int baseline) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the baseline of this view to the bottom of the view.
 * Setting this value overrides any calls to setBaseline.
 *
 * @param aligned If true, the image view will be baseline aligned by its bottom edge.
 *
 * @attr ref android.R.styleable#ImageView_baselineAlignBottom
 * @apiSince 11
 */

public void setBaselineAlignBottom(boolean aligned) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this view's baseline is considered the bottom of the view.
 *
 * @return True if the ImageView's baseline is considered the bottom of the view, false if otherwise.
 * @see #setBaselineAlignBottom(boolean)
 * @apiSince 11
 */

public boolean getBaselineAlignBottom() { throw new RuntimeException("Stub!"); }

/**
 * Sets a tinting option for the image.
 *
 * @param color Color tint to apply.
 * @param mode How to apply the color.  The standard mode is
 * {@link android.graphics.PorterDuff.Mode#SRC_ATOP PorterDuff.Mode#SRC_ATOP}
 *
 * @attr ref android.R.styleable#ImageView_tint
 * @apiSince 1
 */

public final void setColorFilter(int color, android.graphics.PorterDuff.Mode mode) { throw new RuntimeException("Stub!"); }

/**
 * Set a tinting option for the image. Assumes
 * {@link android.graphics.PorterDuff.Mode#SRC_ATOP PorterDuff.Mode#SRC_ATOP} blending mode.
 *
 * @param color Color tint to apply.
 * @attr ref android.R.styleable#ImageView_tint
 * @apiSince 8
 */

public final void setColorFilter(int color) { throw new RuntimeException("Stub!"); }

/**
 * Removes the image's {@link android.graphics.ColorFilter}.
 *
 * @see #setColorFilter(int)
 * @see #getColorFilter()
 * @apiSince 1
 */

public final void clearColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the active color filter for this ImageView.
 *
 * @return the active color filter for this ImageView
 *
 * @see #setColorFilter(android.graphics.ColorFilter)
 * @apiSince 16
 */

public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * Apply an arbitrary colorfilter to the image.
 *
 * @param cf the colorfilter to apply (may be null)
 *
 * @see #getColorFilter()
 * @apiSince 1
 */

public void setColorFilter(android.graphics.ColorFilter cf) { throw new RuntimeException("Stub!"); }

/**
 * Returns the alpha that will be applied to the drawable of this ImageView.
 *
 * @return the alpha value that will be applied to the drawable of this
 * ImageView (between 0 and 255 inclusive, with 0 being transparent and
 * 255 being opaque)
 *
 * @see #setImageAlpha(int)
 * @apiSince 16
 */

public int getImageAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Sets the alpha value that should be applied to the image.
 *
 * @param alpha the alpha value that should be applied to the image (between
 * 0 and 255 inclusive, with 0 being transparent and 255 being opaque)
 *
 * @see #getImageAlpha()
 * @apiSince 16
 */

public void setImageAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Sets the alpha value that should be applied to the image.
 *
 * @param alpha the alpha value that should be applied to the image
 *
 * @deprecated use #setImageAlpha(int) instead
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 7 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void onVisibilityAggregated(boolean isVisible) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * Options for scaling the bounds of an image to the bounds of this view.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum ScaleType {
/**
 * Scale using the image matrix when drawing. The image matrix can be set using
 * {@link android.widget.ImageView#setImageMatrix(android.graphics.Matrix) ImageView#setImageMatrix(Matrix)}. From XML, use this syntax:
 * <code>android:scaleType="matrix"</code>.
 * @apiSince 1
 */

MATRIX,
/**
 * Scale the image using {@link android.graphics.Matrix.ScaleToFit#FILL Matrix.ScaleToFit#FILL}.
 * From XML, use this syntax: <code>android:scaleType="fitXY"</code>.
 * @apiSince 1
 */

FIT_XY,
/**
 * Scale the image using {@link android.graphics.Matrix.ScaleToFit#START Matrix.ScaleToFit#START}.
 * From XML, use this syntax: <code>android:scaleType="fitStart"</code>.
 * @apiSince 1
 */

FIT_START,
/**
 * Scale the image using {@link android.graphics.Matrix.ScaleToFit#CENTER Matrix.ScaleToFit#CENTER}.
 * From XML, use this syntax:
 * <code>android:scaleType="fitCenter"</code>.
 * @apiSince 1
 */

FIT_CENTER,
/**
 * Scale the image using {@link android.graphics.Matrix.ScaleToFit#END Matrix.ScaleToFit#END}.
 * From XML, use this syntax: <code>android:scaleType="fitEnd"</code>.
 * @apiSince 1
 */

FIT_END,
/**
 * Center the image in the view, but perform no scaling.
 * From XML, use this syntax: <code>android:scaleType="center"</code>.
 * @apiSince 1
 */

CENTER,
/**
 * Scale the image uniformly (maintain the image's aspect ratio) so
 * that both dimensions (width and height) of the image will be equal
 * to or larger than the corresponding dimension of the view
 * (minus padding). The image is then centered in the view.
 * From XML, use this syntax: <code>android:scaleType="centerCrop"</code>.
 * @apiSince 1
 */

CENTER_CROP,
/**
 * Scale the image uniformly (maintain the image's aspect ratio) so
 * that both dimensions (width and height) of the image will be equal
 * to or less than the corresponding dimension of the view
 * (minus padding). The image is then centered in the view.
 * From XML, use this syntax: <code>android:scaleType="centerInside"</code>.
 * @apiSince 1
 */

CENTER_INSIDE;
}

}

