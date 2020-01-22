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


package android.graphics;

import android.os.Build;
import android.graphics.text.MeasuredText;

/**
 * The Canvas class holds the "draw" calls. To draw something, you need
 * 4 basic components: A Bitmap to hold the pixels, a Canvas to host
 * the draw calls (writing into the bitmap), a drawing primitive (e.g. Rect,
 * Path, text, Bitmap), and a paint (to describe the colors and styles for the
 * drawing).
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use Canvas, read the
 * <a href="{@docRoot}guide/topics/graphics/2d-graphics.html">
 * Canvas and Drawables</a> developer guide.</p></div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Canvas {

/**
 * Construct an empty raster canvas. Use setBitmap() to specify a bitmap to
 * draw into.  The initial target density is {@link android.graphics.Bitmap#DENSITY_NONE Bitmap#DENSITY_NONE};
 * this will typically be replaced when a target bitmap is set for the
 * canvas.
 * @apiSince 1
 */

public Canvas() { throw new RuntimeException("Stub!"); }

/**
 * Construct a canvas with the specified bitmap to draw into. The bitmap
 * must be mutable.
 *
 * <p>The initial target density of the canvas is the same as the given
 * bitmap's density.
 *
 * @param bitmap Specifies a mutable bitmap for the canvas to draw into.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public Canvas(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this Canvas uses hardware acceleration.
 *
 * Note that this method does not define what type of hardware acceleration
 * may or may not be used.
 *
 * @return True if drawing operations are hardware accelerated,
 *         false otherwise.
 * @apiSince 11
 */

public boolean isHardwareAccelerated() { throw new RuntimeException("Stub!"); }

/**
 * Specify a bitmap for the canvas to draw into. All canvas state such as
 * layers, filters, and the save/restore stack are reset. Additionally,
 * the canvas' target density is updated to match that of the bitmap.
 *
 * Prior to API level {@value android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O} the current matrix and
 * clip stack were preserved.
 *
 * @param bitmap Specifies a mutable bitmap for the canvas to draw into.
 * This value may be {@code null}.
 * @see #setDensity(int)
 * @see #getDensity()
 * @apiSince 1
 */

public void setBitmap(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * <p>Enables Z support which defaults to disabled. This allows for RenderNodes drawn with
 * {@link #drawRenderNode(android.graphics.RenderNode)} to be re-arranged based off of their
 * {@link android.graphics.RenderNode#getElevation() RenderNode#getElevation()} and {@link android.graphics.RenderNode#getTranslationZ() RenderNode#getTranslationZ()}
 * values. It also enables rendering of shadows for RenderNodes with an elevation or
 * translationZ.</p>
 *
 * <p>Any draw reordering will not be moved before this call. A typical usage of this might
 * look something like:
 *
 * <pre class="prettyprint">
 *     void draw(Canvas canvas) {
 *         // Draw any background content
 *         canvas.drawColor(backgroundColor);
 *
 *         // Begin drawing that may be reordered based off of Z
 *         canvas.enableZ();
 *         for (RenderNode child : children) {
 *             canvas.drawRenderNode(child);
 *         }
 *         // End drawing that may be reordered based off of Z
 *         canvas.disableZ();
 *
 *         // Draw any overlays
 *         canvas.drawText("I'm on top of everything!", 0, 0, paint);
 *     }
 * </pre>
 * </p>
 *
 * Note: This is not impacted by any {@link #save()} or {@link #restore()} calls as it is not
 * considered to be part of the current matrix or clip.
 *
 * See {@link #disableZ()}
 * @apiSince 29
 */

public void enableZ() { throw new RuntimeException("Stub!"); }

/**
 * Disables Z support, preventing any RenderNodes drawn after this point from being
 * visually reordered or having shadows rendered.
 *
 * Note: This is not impacted by any {@link #save()} or {@link #restore()} calls as it is not
 * considered to be part of the current matrix or clip.
 *
 * See {@link #enableZ()}
 * @apiSince 29
 */

public void disableZ() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the device that the current layer draws into is opaque
 * (i.e. does not support per-pixel alpha).
 *
 * @return true if the device that the current layer draws into is opaque
 * @apiSince 1
 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the current drawing layer
 *
 * @return the width of the current drawing layer
 * @apiSince 1
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of the current drawing layer
 *
 * @return the height of the current drawing layer
 * @apiSince 1
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the target density of the canvas.  The default density is
 * derived from the density of its backing bitmap, or
 * {@link android.graphics.Bitmap#DENSITY_NONE Bitmap#DENSITY_NONE} if there is not one.</p>
 *
 * @return Returns the current target density of the canvas, which is used
 * to determine the scaling factor when drawing a bitmap into it.
 *
 * @see #setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 * @apiSince 4
 */

public int getDensity() { throw new RuntimeException("Stub!"); }

/**
 * <p>Specifies the density for this Canvas' backing bitmap.  This modifies
 * the target density of the canvas itself, as well as the density of its
 * backing bitmap via {@link android.graphics.Bitmap#setDensity(int) Bitmap#setDensity(int)}.
 *
 * @param density The new target density of the canvas, which is used
 * to determine the scaling factor when drawing a bitmap into it.  Use
 * {@link android.graphics.Bitmap#DENSITY_NONE Bitmap#DENSITY_NONE} to disable bitmap scaling.
 *
 * @see #getDensity()
 * @see android.graphics.Bitmap#setDensity(int)
 * @apiSince 4
 */

public void setDensity(int density) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum allowed width for bitmaps drawn with this canvas.
 * Attempting to draw with a bitmap wider than this value will result
 * in an error.
 *
 * @see #getMaximumBitmapHeight()
 * @apiSince 14
 */

public int getMaximumBitmapWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum allowed height for bitmaps drawn with this canvas.
 * Attempting to draw with a bitmap taller than this value will result
 * in an error.
 *
 * @see #getMaximumBitmapWidth()
 * @apiSince 14
 */

public int getMaximumBitmapHeight() { throw new RuntimeException("Stub!"); }

/**
 * Saves the current matrix and clip onto a private stack.
 * <p>
 * Subsequent calls to translate,scale,rotate,skew,concat or clipRect,
 * clipPath will all operate as usual, but when the balancing call to
 * restore() is made, those calls will be forgotten, and the settings that
 * existed before the save() will be reinstated.
 *
 * @return The value to pass to restoreToCount() to balance this save()
 * @apiSince 1
 */

public int save() { throw new RuntimeException("Stub!"); }

/**
 * This behaves the same as save(), but in addition it allocates and
 * redirects drawing to an offscreen bitmap.
 * <p class="note"><strong>Note:</strong> this method is very expensive,
 * incurring more than double rendering cost for contained content. Avoid
 * using this method, especially if the bounds provided are large. It is
 * recommended to use a {@link android.view.View#LAYER_TYPE_HARDWARE hardware layer} on a View
 * to apply an xfermode, color filter, or alpha, as it will perform much
 * better than this method.
 * <p>
 * All drawing calls are directed to a newly allocated offscreen bitmap.
 * Only when the balancing call to restore() is made, is that offscreen
 * buffer drawn back to the current target of the Canvas (either the
 * screen, it's target Bitmap, or the previous layer).
 * <p>
 * Attributes of the Paint - {@link android.graphics.Paint#getAlpha() Paint#getAlpha()},
 * {@link android.graphics.Paint#getXfermode() Paint#getXfermode()}, and
 * {@link android.graphics.Paint#getColorFilter() Paint#getColorFilter()} are applied when the
 * offscreen bitmap is drawn back when restore() is called.
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} the only valid
 * {@code saveFlags} is {@link #ALL_SAVE_FLAG}.  All other flags are ignored.
 *
 * @deprecated Use {@link #saveLayer(android.graphics.RectF,android.graphics.Paint)} instead.
 * @param bounds May be null. The maximum size the offscreen bitmap
 *               needs to be (in local coordinates)
 * This value may be {@code null}.
 * @param paint  This is copied, and is applied to the offscreen when
 *               restore() is called.
 * This value may be {@code null}.
 * @param saveFlags see _SAVE_FLAG constants, generally {@link #ALL_SAVE_FLAG} is recommended
 *               for performance reasons.
 * Value is either <code>0</code> or {@link android.graphics.Canvas#ALL_SAVE_FLAG}
 * @return       value to pass to restoreToCount() to balance this save()
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int saveLayer(@androidx.annotation.Nullable android.graphics.RectF bounds, @androidx.annotation.Nullable android.graphics.Paint paint, int saveFlags) { throw new RuntimeException("Stub!"); }

/**
 * This behaves the same as save(), but in addition it allocates and
 * redirects drawing to an offscreen rendering target.
 * <p class="note"><strong>Note:</strong> this method is very expensive,
 * incurring more than double rendering cost for contained content. Avoid
 * using this method when possible and instead use a
 * {@link android.view.View#LAYER_TYPE_HARDWARE hardware layer} on a View
 * to apply an xfermode, color filter, or alpha, as it will perform much
 * better than this method.
 * <p>
 * All drawing calls are directed to a newly allocated offscreen rendering target.
 * Only when the balancing call to restore() is made, is that offscreen
 * buffer drawn back to the current target of the Canvas (which can potentially be a previous
 * layer if these calls are nested).
 * <p>
 * Attributes of the Paint - {@link android.graphics.Paint#getAlpha() Paint#getAlpha()},
 * {@link android.graphics.Paint#getXfermode() Paint#getXfermode()}, and
 * {@link android.graphics.Paint#getColorFilter() Paint#getColorFilter()} are applied when the
 * offscreen rendering target is drawn back when restore() is called.
 *
 * @param bounds May be null. The maximum size the offscreen render target
 *               needs to be (in local coordinates)
 * This value may be {@code null}.
 * @param paint  This is copied, and is applied to the offscreen when
 *               restore() is called.
 * This value may be {@code null}.
 * @return       value to pass to restoreToCount() to balance this save()
 * @apiSince 21
 */

public int saveLayer(@androidx.annotation.Nullable android.graphics.RectF bounds, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Helper version of saveLayer() that takes 4 values rather than a RectF.
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} the only valid
 * {@code saveFlags} is {@link #ALL_SAVE_FLAG}.  All other flags are ignored.
 *
 * @deprecated Use {@link #saveLayer(float,float,float,float,android.graphics.Paint)} instead.
 
 * @param paint This value may be {@code null}.
 
 * @param saveFlags Value is either <code>0</code> or {@link android.graphics.Canvas#ALL_SAVE_FLAG}
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int saveLayer(float left, float top, float right, float bottom, @androidx.annotation.Nullable android.graphics.Paint paint, int saveFlags) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link #saveLayer(android.graphics.RectF,android.graphics.Paint)} that takes the four float coordinates of the
 * bounds rectangle.
 
 * @param paint This value may be {@code null}.
 * @apiSince 21
 */

public int saveLayer(float left, float top, float right, float bottom, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * This behaves the same as save(), but in addition it allocates and
 * redirects drawing to an offscreen bitmap.
 * <p class="note"><strong>Note:</strong> this method is very expensive,
 * incurring more than double rendering cost for contained content. Avoid
 * using this method, especially if the bounds provided are large. It is
 * recommended to use a {@link android.view.View#LAYER_TYPE_HARDWARE hardware layer} on a View
 * to apply an xfermode, color filter, or alpha, as it will perform much
 * better than this method.
 * <p>
 * All drawing calls are directed to a newly allocated offscreen bitmap.
 * Only when the balancing call to restore() is made, is that offscreen
 * buffer drawn back to the current target of the Canvas (either the
 * screen, it's target Bitmap, or the previous layer).
 * <p>
 * The {@code alpha} parameter is applied when the offscreen bitmap is
 * drawn back when restore() is called.
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} the only valid
 * {@code saveFlags} is {@link #ALL_SAVE_FLAG}.  All other flags are ignored.
 *
 * @deprecated Use {@link #saveLayerAlpha(android.graphics.RectF,int)} instead.
 * @param bounds    The maximum size the offscreen bitmap needs to be
 *                  (in local coordinates)
 * This value may be {@code null}.
 * @param alpha     The alpha to apply to the offscreen when it is
                 drawn during restore()
 * @param saveFlags see _SAVE_FLAG constants, generally {@link #ALL_SAVE_FLAG} is recommended
 *                  for performance reasons.
 * Value is either <code>0</code> or {@link android.graphics.Canvas#ALL_SAVE_FLAG}
 * @return          value to pass to restoreToCount() to balance this call
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int saveLayerAlpha(@androidx.annotation.Nullable android.graphics.RectF bounds, int alpha, int saveFlags) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link #saveLayer(android.graphics.RectF,android.graphics.Paint)} but instead of taking a entire Paint object
 * it takes only the {@code alpha} parameter.
 *
 * @param bounds    The maximum size the offscreen bitmap needs to be
 *                  (in local coordinates)
 * This value may be {@code null}.
 * @param alpha     The alpha to apply to the offscreen when it is
                  drawn during restore()
 * @apiSince 21
 */

public int saveLayerAlpha(@androidx.annotation.Nullable android.graphics.RectF bounds, int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Helper for saveLayerAlpha() that takes 4 values instead of a RectF.
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} the only valid
 * {@code saveFlags} is {@link #ALL_SAVE_FLAG}.  All other flags are ignored.
 *
 * @deprecated Use {@link #saveLayerAlpha(float,float,float,float,int)} instead.
 
 * @param saveFlags Value is either <code>0</code> or {@link android.graphics.Canvas#ALL_SAVE_FLAG}
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha, int saveFlags) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link #saveLayerAlpha(android.graphics.RectF,int)} that takes the four float coordinates of
 * the bounds rectangle.
 * @apiSince 21
 */

public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha) { throw new RuntimeException("Stub!"); }

/**
 * This call balances a previous call to save(), and is used to remove all
 * modifications to the matrix/clip state since the last save call. It is
 * an error to call restore() more times than save() was called.
 * @apiSince 1
 */

public void restore() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of matrix/clip states on the Canvas' private stack.
 * This will equal # save() calls - # restore() calls.
 * @apiSince 1
 */

public int getSaveCount() { throw new RuntimeException("Stub!"); }

/**
 * Efficient way to pop any calls to save() that happened after the save
 * count reached saveCount. It is an error for saveCount to be less than 1.
 *
 * Example:
 *    int count = canvas.save();
 *    ... // more calls potentially to save()
 *    canvas.restoreToCount(count);
 *    // now the canvas is back in the same state it was before the initial
 *    // call to save().
 *
 * @param saveCount The save level to restore to.
 * @apiSince 1
 */

public void restoreToCount(int saveCount) { throw new RuntimeException("Stub!"); }

/**
 * Preconcat the current matrix with the specified translation
 *
 * @param dx The distance to translate in X
 * @param dy The distance to translate in Y
 * @apiSince 1
 */

public void translate(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Preconcat the current matrix with the specified scale.
 *
 * @param sx The amount to scale in X
 * @param sy The amount to scale in Y
 * @apiSince 1
 */

public void scale(float sx, float sy) { throw new RuntimeException("Stub!"); }

/**
 * Preconcat the current matrix with the specified scale.
 *
 * @param sx The amount to scale in X
 * @param sy The amount to scale in Y
 * @param px The x-coord for the pivot point (unchanged by the scale)
 * @param py The y-coord for the pivot point (unchanged by the scale)
 * @apiSince 1
 */

public final void scale(float sx, float sy, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Preconcat the current matrix with the specified rotation.
 *
 * @param degrees The amount to rotate, in degrees
 * @apiSince 1
 */

public void rotate(float degrees) { throw new RuntimeException("Stub!"); }

/**
 * Preconcat the current matrix with the specified rotation.
 *
 * @param degrees The amount to rotate, in degrees
 * @param px The x-coord for the pivot point (unchanged by the rotation)
 * @param py The y-coord for the pivot point (unchanged by the rotation)
 * @apiSince 1
 */

public final void rotate(float degrees, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Preconcat the current matrix with the specified skew.
 *
 * @param sx The amount to skew in X
 * @param sy The amount to skew in Y
 * @apiSince 1
 */

public void skew(float sx, float sy) { throw new RuntimeException("Stub!"); }

/**
 * Preconcat the current matrix with the specified matrix. If the specified
 * matrix is null, this method does nothing.
 *
 * @param matrix The matrix to preconcatenate with the current matrix
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void concat(@androidx.annotation.Nullable android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Completely replace the current matrix with the specified matrix. If the
 * matrix parameter is null, then the current matrix is reset to identity.
 *
 * <strong>Note:</strong> it is recommended to use {@link #concat(android.graphics.Matrix)},
 * {@link #scale(float,float)}, {@link #translate(float,float)} and
 * {@link #rotate(float)} instead of this method.
 *
 * @param matrix The matrix to replace the current matrix with. If it is
 *               null, set the current matrix to identity.
 *
 * This value may be {@code null}.
 * @see #concat(Matrix)
 * @apiSince 1
 */

public void setMatrix(@androidx.annotation.Nullable android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Return, in ctm, the current transformation matrix. This does not alter
 * the matrix in the canvas, but just returns a copy of it.
 *
 * @deprecated {@link #isHardwareAccelerated() Hardware accelerated} canvases may have any
 * matrix when passed to a View or Drawable, as it is implementation defined where in the
 * hierarchy such canvases are created. It is recommended in such cases to either draw contents
 * irrespective of the current matrix, or to track relevant transform state outside of the
 * canvas.
 
 * @param ctm This value must never be {@code null}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void getMatrix(@androidx.annotation.NonNull android.graphics.Matrix ctm) { throw new RuntimeException("Stub!"); }

/**
 * Return a new matrix with a copy of the canvas' current transformation
 * matrix.
 *
 * @deprecated {@link #isHardwareAccelerated() Hardware accelerated} canvases may have any
 * matrix when passed to a View or Drawable, as it is implementation defined where in the
 * hierarchy such canvases are created. It is recommended in such cases to either draw contents
 * irrespective of the current matrix, or to track relevant transform state outside of the
 * canvas.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
@androidx.annotation.NonNull
public final android.graphics.Matrix getMatrix() { throw new RuntimeException("Stub!"); }

/**
 * Modify the current clip with the specified rectangle.
 *
 * @param rect The rect to intersect with the current clip
 * This value must never be {@code null}.
 * @param op How the clip is modified
 * This value must never be {@code null}.
 * @return true if the resulting clip is non-empty
 *
 * @deprecated Region.Op values other than {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} have the ability to expand the clip. The canvas clipping APIs
 * are intended to only expand the clip as a result of a restore operation. This enables a view
 * parent to clip a canvas to clearly define the maximal drawing area of its children. The
 * recommended alternative calls are {@link #clipRect(android.graphics.RectF)} and {@link #clipOutRect(android.graphics.RectF)};
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} only {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} are valid Region.Op parameters.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public boolean clipRect(@androidx.annotation.NonNull android.graphics.RectF rect, @androidx.annotation.NonNull android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Modify the current clip with the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param rect The rectangle to intersect with the current clip.
 * This value must never be {@code null}.
 * @param op How the clip is modified
 * This value must never be {@code null}.
 * @return true if the resulting clip is non-empty
 *
 * @deprecated Region.Op values other than {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} have the ability to expand the clip. The canvas clipping APIs
 * are intended to only expand the clip as a result of a restore operation. This enables a view
 * parent to clip a canvas to clearly define the maximal drawing area of its children. The
 * recommended alternative calls are {@link #clipRect(android.graphics.Rect)} and {@link #clipOutRect(android.graphics.Rect)};
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} only {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} are valid Region.Op parameters.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public boolean clipRect(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Intersect the current clip with the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param rect The rectangle to intersect with the current clip.
 * This value must never be {@code null}.
 * @return true if the resulting clip is non-empty
 * @apiSince 1
 */

public boolean clipRect(@androidx.annotation.NonNull android.graphics.RectF rect) { throw new RuntimeException("Stub!"); }

/**
 * Set the clip to the difference of the current clip and the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param rect The rectangle to perform a difference op with the current clip.
 * This value must never be {@code null}.
 * @return true if the resulting clip is non-empty
 * @apiSince 26
 */

public boolean clipOutRect(@androidx.annotation.NonNull android.graphics.RectF rect) { throw new RuntimeException("Stub!"); }

/**
 * Intersect the current clip with the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param rect The rectangle to intersect with the current clip.
 * This value must never be {@code null}.
 * @return true if the resulting clip is non-empty
 * @apiSince 1
 */

public boolean clipRect(@androidx.annotation.NonNull android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/**
 * Set the clip to the difference of the current clip and the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param rect The rectangle to perform a difference op with the current clip.
 * This value must never be {@code null}.
 * @return true if the resulting clip is non-empty
 * @apiSince 26
 */

public boolean clipOutRect(@androidx.annotation.NonNull android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/**
 * Modify the current clip with the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param left   The left side of the rectangle to intersect with the
 *               current clip
 * @param top    The top of the rectangle to intersect with the current
 *               clip
 * @param right  The right side of the rectangle to intersect with the
 *               current clip
 * @param bottom The bottom of the rectangle to intersect with the current
 *               clip
 * @param op     How the clip is modified
 * This value must never be {@code null}.
 * @return       true if the resulting clip is non-empty
 *
 * @deprecated Region.Op values other than {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} have the ability to expand the clip. The canvas clipping APIs
 * are intended to only expand the clip as a result of a restore operation. This enables a view
 * parent to clip a canvas to clearly define the maximal drawing area of its children. The
 * recommended alternative calls are {@link #clipRect(float,float,float,float)} and
 * {@link #clipOutRect(float,float,float,float)};
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} only {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} are valid Region.Op parameters.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public boolean clipRect(float left, float top, float right, float bottom, @androidx.annotation.NonNull android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Intersect the current clip with the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param left   The left side of the rectangle to intersect with the
 *               current clip
 * @param top    The top of the rectangle to intersect with the current clip
 * @param right  The right side of the rectangle to intersect with the
 *               current clip
 * @param bottom The bottom of the rectangle to intersect with the current
 *               clip
 * @return       true if the resulting clip is non-empty
 * @apiSince 1
 */

public boolean clipRect(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * Set the clip to the difference of the current clip and the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param left   The left side of the rectangle used in the difference operation
 * @param top    The top of the rectangle used in the difference operation
 * @param right  The right side of the rectangle used in the difference operation
 * @param bottom The bottom of the rectangle used in the difference operation
 * @return       true if the resulting clip is non-empty
 * @apiSince 26
 */

public boolean clipOutRect(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * Intersect the current clip with the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param left   The left side of the rectangle to intersect with the
 *               current clip
 * @param top    The top of the rectangle to intersect with the current clip
 * @param right  The right side of the rectangle to intersect with the
 *               current clip
 * @param bottom The bottom of the rectangle to intersect with the current
 *               clip
 * @return       true if the resulting clip is non-empty
 * @apiSince 1
 */

public boolean clipRect(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Set the clip to the difference of the current clip and the specified rectangle, which is
 * expressed in local coordinates.
 *
 * @param left   The left side of the rectangle used in the difference operation
 * @param top    The top of the rectangle used in the difference operation
 * @param right  The right side of the rectangle used in the difference operation
 * @param bottom The bottom of the rectangle used in the difference operation
 * @return       true if the resulting clip is non-empty
 * @apiSince 26
 */

public boolean clipOutRect(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
   * Modify the current clip with the specified path.
 *
 * @param path The path to operate on the current clip
 This value must never be {@code null}.
 * @param op   How the clip is modified
 This value must never be {@code null}.
 * @return     true if the resulting is non-empty
 *
 * @deprecated Region.Op values other than {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} have the ability to expand the clip. The canvas clipping APIs
 * are intended to only expand the clip as a result of a restore operation. This enables a view
 * parent to clip a canvas to clearly define the maximal drawing area of its children. The
 * recommended alternative calls are {@link #clipPath(android.graphics.Path)} and
 * {@link #clipOutPath(android.graphics.Path)};
 *
 * As of API Level API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} only {@link android.graphics.Region.Op#INTERSECT Region.Op#INTERSECT} and
 * {@link android.graphics.Region.Op#DIFFERENCE Region.Op#DIFFERENCE} are valid Region.Op parameters.
   * @apiSince 1
   * @deprecatedSince 26
    */

@Deprecated
public boolean clipPath(@androidx.annotation.NonNull android.graphics.Path path, @androidx.annotation.NonNull android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Intersect the current clip with the specified path.
 *
 * @param path The path to intersect with the current clip
 * This value must never be {@code null}.
 * @return     true if the resulting clip is non-empty
 * @apiSince 1
 */

public boolean clipPath(@androidx.annotation.NonNull android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Set the clip to the difference of the current clip and the specified path.
 *
 * @param path The path used in the difference operation
 * This value must never be {@code null}.
 * @return     true if the resulting clip is non-empty
 * @apiSince 26
 */

public boolean clipOutPath(@androidx.annotation.NonNull android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.graphics.DrawFilter getDrawFilter() { throw new RuntimeException("Stub!"); }

/**
 * @param filter This value may be {@code null}.
 * @apiSince 1
 */

public void setDrawFilter(@androidx.annotation.Nullable android.graphics.DrawFilter filter) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the specified rectangle, after being transformed by the
 * current matrix, would lie completely outside of the current clip. Call
 * this to check if an area you intend to draw into is clipped out (and
 * therefore you can skip making the draw calls).
 *
 * @param rect  the rect to compare with the current clip
 * This value must never be {@code null}.
 * @param type  {@link android.graphics.Canvas.EdgeType#AA Canvas.EdgeType#AA} if the path should be considered antialiased,
 *              since that means it may affect a larger area (more pixels) than
 *              non-antialiased ({@link android.graphics.Canvas.EdgeType#BW Canvas.EdgeType#BW}).
 * This value must never be {@code null}.
 * @return      true if the rect (transformed by the canvas' matrix)
 *              does not intersect with the canvas' clip
 * @apiSince 1
 */

public boolean quickReject(@androidx.annotation.NonNull android.graphics.RectF rect, @androidx.annotation.NonNull android.graphics.Canvas.EdgeType type) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the specified path, after being transformed by the
 * current matrix, would lie completely outside of the current clip. Call
 * this to check if an area you intend to draw into is clipped out (and
 * therefore you can skip making the draw calls). Note: for speed it may
 * return false even if the path itself might not intersect the clip
 * (i.e. the bounds of the path intersects, but the path does not).
 *
 * @param path        The path to compare with the current clip
 * This value must never be {@code null}.
 * @param type        {@link android.graphics.Canvas.EdgeType#AA Canvas.EdgeType#AA} if the path should be considered antialiased,
 *                    since that means it may affect a larger area (more pixels) than
 *                    non-antialiased ({@link android.graphics.Canvas.EdgeType#BW Canvas.EdgeType#BW}).
 * This value must never be {@code null}.
 * @return            true if the path (transformed by the canvas' matrix)
 *                    does not intersect with the canvas' clip
 * @apiSince 1
 */

public boolean quickReject(@androidx.annotation.NonNull android.graphics.Path path, @androidx.annotation.NonNull android.graphics.Canvas.EdgeType type) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the specified rectangle, after being transformed by the
 * current matrix, would lie completely outside of the current clip. Call
 * this to check if an area you intend to draw into is clipped out (and
 * therefore you can skip making the draw calls).
 *
 * @param left        The left side of the rectangle to compare with the
 *                    current clip
 * @param top         The top of the rectangle to compare with the current
 *                    clip
 * @param right       The right side of the rectangle to compare with the
 *                    current clip
 * @param bottom      The bottom of the rectangle to compare with the
 *                    current clip
 * @param type        {@link android.graphics.Canvas.EdgeType#AA Canvas.EdgeType#AA} if the path should be considered antialiased,
 *                    since that means it may affect a larger area (more pixels) than
 *                    non-antialiased ({@link android.graphics.Canvas.EdgeType#BW Canvas.EdgeType#BW}).
 * This value must never be {@code null}.
 * @return            true if the rect (transformed by the canvas' matrix)
 *                    does not intersect with the canvas' clip
 * @apiSince 1
 */

public boolean quickReject(float left, float top, float right, float bottom, @androidx.annotation.NonNull android.graphics.Canvas.EdgeType type) { throw new RuntimeException("Stub!"); }

/**
 * Return the bounds of the current clip (in local coordinates) in the
 * bounds parameter, and return true if it is non-empty. This can be useful
 * in a way similar to quickReject, in that it tells you that drawing
 * outside of these bounds will be clipped out.
 *
 * @param bounds Return the clip bounds here. If it is null, ignore it but
 *               still return true if the current clip is non-empty.
 * This value may be {@code null}.
 * @return true if the current clip is non-empty.
 * @apiSince 1
 */

public boolean getClipBounds(@androidx.annotation.Nullable android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the bounds of the current clip (in local coordinates).
 *
 * @return the clip bounds, or [0, 0, 0, 0] if the clip is empty.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.graphics.Rect getClipBounds() { throw new RuntimeException("Stub!"); }

/**
 * Save the canvas state, draw the picture, and restore the canvas state.
 * This differs from picture.draw(canvas), which does not perform any
 * save/restore.
 *
 * <p>
 * <strong>Note:</strong> This forces the picture to internally call
 * {@link android.graphics.Picture#endRecording Picture#endRecording} in order to prepare for playback.
 *
 * @param picture  The picture to be drawn
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPicture(@androidx.annotation.NonNull android.graphics.Picture picture) { throw new RuntimeException("Stub!"); }

/**
 * Draw the picture, stretched to fit into the dst rectangle.
 
 * @param picture This value must never be {@code null}.
 
 * @param dst This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPicture(@androidx.annotation.NonNull android.graphics.Picture picture, @androidx.annotation.NonNull android.graphics.RectF dst) { throw new RuntimeException("Stub!"); }

/**
 * Draw the picture, stretched to fit into the dst rectangle.
 
 * @param picture This value must never be {@code null}.
 
 * @param dst This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPicture(@androidx.annotation.NonNull android.graphics.Picture picture, @androidx.annotation.NonNull android.graphics.Rect dst) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Draw the specified arc, which will be scaled to fit inside the specified oval.
 * </p>
 * <p>
 * If the start angle is negative or >= 360, the start angle is treated as start angle modulo
 * 360.
 * </p>
 * <p>
 * If the sweep angle is >= 360, then the oval is drawn completely. Note that this differs
 * slightly from SkPath::arcTo, which treats the sweep angle modulo 360. If the sweep angle is
 * negative, the sweep angle is treated as sweep angle modulo 360
 * </p>
 * <p>
 * The arc is drawn clockwise. An angle of 0 degrees correspond to the geometric angle of 0
 * degrees (3 o'clock on a watch.)
 * </p>
 *
 * @param oval The bounds of oval used to define the shape and size of the arc
 * This value must never be {@code null}.
 * @param startAngle Starting angle (in degrees) where the arc begins
 * @param sweepAngle Sweep angle (in degrees) measured clockwise
 * @param useCenter If true, include the center of the oval in the arc, and close it if it is
 *            being stroked. This will draw a wedge
 * @param paint The paint used to draw the arc
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawArc(@androidx.annotation.NonNull android.graphics.RectF oval, float startAngle, float sweepAngle, boolean useCenter, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Draw the specified arc, which will be scaled to fit inside the specified oval.
 * </p>
 * <p>
 * If the start angle is negative or >= 360, the start angle is treated as start angle modulo
 * 360.
 * </p>
 * <p>
 * If the sweep angle is >= 360, then the oval is drawn completely. Note that this differs
 * slightly from SkPath::arcTo, which treats the sweep angle modulo 360. If the sweep angle is
 * negative, the sweep angle is treated as sweep angle modulo 360
 * </p>
 * <p>
 * The arc is drawn clockwise. An angle of 0 degrees correspond to the geometric angle of 0
 * degrees (3 o'clock on a watch.)
 * </p>
 *
 * @param startAngle Starting angle (in degrees) where the arc begins
 * @param sweepAngle Sweep angle (in degrees) measured clockwise
 * @param useCenter If true, include the center of the oval in the arc, and close it if it is
 *            being stroked. This will draw a wedge
 * @param paint The paint used to draw the arc
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified ARGB
 * color, using srcover porterduff mode.
 *
 * @param a alpha component (0..255) of the color to draw onto the canvas
 * @param r red component (0..255) of the color to draw onto the canvas
 * @param g green component (0..255) of the color to draw onto the canvas
 * @param b blue component (0..255) of the color to draw onto the canvas
 * @apiSince 1
 */

public void drawARGB(int a, int r, int g, int b) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified bitmap, with its top/left corner at (x,y), using the specified paint,
 * transformed by the current matrix.
 * <p>
 * Note: if the paint contains a maskfilter that generates a mask which extends beyond the
 * bitmap's original width/height (e.g. BlurMaskFilter), then the bitmap will be drawn as if it
 * were in a Shader with CLAMP mode. Thus the color outside of the original width/height will be
 * the edge color replicated.
 * <p>
 * If the bitmap and canvas have different densities, this function will take care of
 * automatically scaling the bitmap to draw at the same density as the canvas.
 *
 * @param bitmap The bitmap to be drawn
 * This value must never be {@code null}.
 * @param left The position of the left side of the bitmap being drawn
 * @param top The position of the top side of the bitmap being drawn
 * @param paint The paint used to draw the bitmap (may be null)
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, float left, float top, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified bitmap, scaling/translating automatically to fill the destination
 * rectangle. If the source rectangle is not null, it specifies the subset of the bitmap to
 * draw.
 * <p>
 * Note: if the paint contains a maskfilter that generates a mask which extends beyond the
 * bitmap's original width/height (e.g. BlurMaskFilter), then the bitmap will be drawn as if it
 * were in a Shader with CLAMP mode. Thus the color outside of the original width/height will be
 * the edge color replicated.
 * <p>
 * This function <em>ignores the density associated with the bitmap</em>. This is because the
 * source and destination rectangle coordinate spaces are in their respective densities, so must
 * already have the appropriate scaling factor applied.
 *
 * @param bitmap The bitmap to be drawn
 * This value must never be {@code null}.
 * @param src May be null. The subset of the bitmap to be drawn
 * This value may be {@code null}.
 * @param dst The rectangle that the bitmap will be scaled/translated to fit into
 * This value must never be {@code null}.
 * @param paint May be null. The paint used to draw the bitmap
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable android.graphics.Rect src, @androidx.annotation.NonNull android.graphics.RectF dst, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified bitmap, scaling/translating automatically to fill the destination
 * rectangle. If the source rectangle is not null, it specifies the subset of the bitmap to
 * draw.
 * <p>
 * Note: if the paint contains a maskfilter that generates a mask which extends beyond the
 * bitmap's original width/height (e.g. BlurMaskFilter), then the bitmap will be drawn as if it
 * were in a Shader with CLAMP mode. Thus the color outside of the original width/height will be
 * the edge color replicated.
 * <p>
 * This function <em>ignores the density associated with the bitmap</em>. This is because the
 * source and destination rectangle coordinate spaces are in their respective densities, so must
 * already have the appropriate scaling factor applied.
 *
 * @param bitmap The bitmap to be drawn
 * This value must never be {@code null}.
 * @param src May be null. The subset of the bitmap to be drawn
 * This value may be {@code null}.
 * @param dst The rectangle that the bitmap will be scaled/translated to fit into
 * This value must never be {@code null}.
 * @param paint May be null. The paint used to draw the bitmap
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable android.graphics.Rect src, @androidx.annotation.NonNull android.graphics.Rect dst, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Treat the specified array of colors as a bitmap, and draw it. This gives the same result as
 * first creating a bitmap from the array, and then drawing it, but this method avoids
 * explicitly creating a bitmap object which can be more efficient if the colors are changing
 * often.
 *
 * @param colors Array of colors representing the pixels of the bitmap
 * This value must never be {@code null}.
 * @param offset Offset into the array of colors for the first pixel
 * @param stride The number of colors in the array between rows (must be >= width or <= -width).
 * @param x The X coordinate for where to draw the bitmap
 * @param y The Y coordinate for where to draw the bitmap
 * @param width The width of the bitmap
 * @param height The height of the bitmap
 * @param hasAlpha True if the alpha channel of the colors contains valid values. If false, the
 *            alpha byte is ignored (assumed to be 0xFF for every pixel).
 * @param paint May be null. The paint used to draw the bitmap
 * This value may be {@code null}.
 * @deprecated Usage with a {@link #isHardwareAccelerated() hardware accelerated} canvas
 *             requires an internal copy of color buffer contents every time this method is
 *             called. Using a Bitmap avoids this copy, and allows the application to more
 *             explicitly control the lifetime and copies of pixel data.
 * @apiSince 3
 * @deprecatedSince 21
 */

@Deprecated
public void drawBitmap(@androidx.annotation.NonNull int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Legacy version of drawBitmap(int[] colors, ...) that took ints for x,y
 *
 * @deprecated Usage with a {@link #isHardwareAccelerated() hardware accelerated} canvas
 *             requires an internal copy of color buffer contents every time this method is
 *             called. Using a Bitmap avoids this copy, and allows the application to more
 *             explicitly control the lifetime and copies of pixel data.
 
 * @param colors This value must never be {@code null}.
 
 * @param paint This value may be {@code null}.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void drawBitmap(@androidx.annotation.NonNull int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the bitmap using the specified matrix.
 *
 * @param bitmap The bitmap to draw
 * This value must never be {@code null}.
 * @param matrix The matrix used to transform the bitmap when it is drawn
 * This value must never be {@code null}.
 * @param paint May be null. The paint used to draw the bitmap
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void drawBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.NonNull android.graphics.Matrix matrix, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the bitmap through the mesh, where mesh vertices are evenly distributed across the
 * bitmap. There are meshWidth+1 vertices across, and meshHeight+1 vertices down. The verts
 * array is accessed in row-major order, so that the first meshWidth+1 vertices are distributed
 * across the top of the bitmap from left to right. A more general version of this method is
 * drawVertices().
 *
 * Prior to API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} vertOffset and colorOffset were ignored,
 * effectively treating them as zeros. In API level {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} and above
 * these parameters will be respected.
 *
 * @param bitmap The bitmap to draw using the mesh
 * This value must never be {@code null}.
 * @param meshWidth The number of columns in the mesh. Nothing is drawn if this is 0
 * @param meshHeight The number of rows in the mesh. Nothing is drawn if this is 0
 * @param verts Array of x,y pairs, specifying where the mesh should be drawn. There must be at
 *            least (meshWidth+1) * (meshHeight+1) * 2 + vertOffset values in the array
 * This value must never be {@code null}.
 * @param vertOffset Number of verts elements to skip before drawing
 * @param colors May be null. Specifies a color at each vertex, which is interpolated across the
 *            cell, and whose values are multiplied by the corresponding bitmap colors. If not
 *            null, there must be at least (meshWidth+1) * (meshHeight+1) + colorOffset values
 *            in the array.
 * This value may be {@code null}.
 * @param colorOffset Number of color elements to skip before drawing
 * @param paint May be null. The paint used to draw the bitmap
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void drawBitmapMesh(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, int meshWidth, int meshHeight, @androidx.annotation.NonNull float[] verts, int vertOffset, @androidx.annotation.Nullable int[] colors, int colorOffset, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified circle using the specified paint. If radius is <= 0, then nothing will be
 * drawn. The circle will be filled or framed based on the Style in the paint.
 *
 * @param cx The x-coordinate of the center of the circle to be drawn
 * @param cy The y-coordinate of the center of the circle to be drawn
 * @param radius The radius of the circle to be drawn
 * @param paint The paint used to draw the circle
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawCircle(float cx, float cy, float radius, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified color,
 * using srcover porterduff mode.
 *
 * @param color the color to draw onto the canvas
 * @apiSince 1
 */

public void drawColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified color,
 * using srcover porterduff mode.
 *
 * @param color the {@code ColorLong} to draw onto the canvas. See the {@link android.graphics.Color Color}
 *              class for details about {@code ColorLong}s.
 * @throws java.lang.IllegalArgumentException if the color space encoded in the {@code ColorLong}
 *                                  is invalid or unknown.
 * @apiSince 29
 */

public void drawColor(long color) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified color and
 * porter-duff xfermode.
 *
 * @param color the color to draw onto the canvas
 * @param mode the porter-duff mode to apply to the color
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawColor(int color, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified color and
 * blendmode.
 *
 * @param color the color to draw onto the canvas
 * @param mode the blendmode to apply to the color
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void drawColor(int color, @androidx.annotation.NonNull android.graphics.BlendMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified color and
 * blendmode.
 *
 * @param color the {@code ColorLong} to draw onto the canvas. See the {@link android.graphics.Color Color}
 *              class for details about {@code ColorLong}s.
 * @param mode the blendmode to apply to the color
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the color space encoded in the {@code ColorLong}
 *                                  is invalid or unknown.
 * @apiSince 29
 */

public void drawColor(long color, @androidx.annotation.NonNull android.graphics.BlendMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Draw a line segment with the specified start and stop x,y coordinates, using the specified
 * paint.
 * <p>
 * Note that since a line is always "framed", the Style is ignored in the paint.
 * </p>
 * <p>
 * Degenerate lines (length is 0) will not be drawn.
 * </p>
 *
 * @param startX The x-coordinate of the start point of the line
 * @param startY The y-coordinate of the start point of the line
 * @param paint The paint used to draw the line
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawLine(float startX, float startY, float stopX, float stopY, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw a series of lines. Each line is taken from 4 consecutive values in the pts array. Thus
 * to draw 1 line, the array must contain at least 4 values. This is logically the same as
 * drawing the array as follows: drawLine(pts[0], pts[1], pts[2], pts[3]) followed by
 * drawLine(pts[4], pts[5], pts[6], pts[7]) and so on.
 *
 * @param pts Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
 * This value must never be {@code null}.
 * @param offset Number of values in the array to skip before drawing.
 * @param count The number of values in the array to process, after skipping "offset" of them.
 *            Since each line uses 4 values, the number of "lines" that are drawn is really
 *            (count >> 2).
 * @param paint The paint used to draw the points
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawLines(@androidx.annotation.NonNull float[] pts, int offset, int count, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param pts This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 * @apiSince 1
 */

public void drawLines(@androidx.annotation.NonNull float[] pts, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified oval using the specified paint. The oval will be filled or framed based on
 * the Style in the paint.
 *
 * @param oval The rectangle bounds of the oval to be drawn
 
 * This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 * @apiSince 1
 */

public void drawOval(@androidx.annotation.NonNull android.graphics.RectF oval, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified oval using the specified paint. The oval will be filled or framed based on
 * the Style in the paint.
 
 * @param paint This value must never be {@code null}.
 * @apiSince 21
 */

public void drawOval(float left, float top, float right, float bottom, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified paint.
 * This is equivalent (but faster) to drawing an infinitely large rectangle with the specified
 * paint.
 *
 * @param paint The paint used to draw onto the canvas
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPaint(@androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified path using the specified paint. The path will be filled or framed based on
 * the Style in the paint.
 *
 * @param path The path to be drawn
 * This value must never be {@code null}.
 * @param paint The paint used to draw the path
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPath(@androidx.annotation.NonNull android.graphics.Path path, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Helper for drawPoints() for drawing a single point.
 
 * @param paint This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPoint(float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw a series of points. Each point is centered at the coordinate specified by pts[], and its
 * diameter is specified by the paint's stroke width (as transformed by the canvas' CTM), with
 * special treatment for a stroke width of 0, which always draws exactly 1 pixel (or at most 4
 * if antialiasing is enabled). The shape of the point is controlled by the paint's Cap type.
 * The shape is a square, unless the cap type is Round, in which case the shape is a circle.
 *
 * @param pts Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
 * @param offset Number of values to skip before starting to draw.
 * @param count The number of values to process, after skipping offset of them. Since one point
 *            uses two values, the number of "points" that are drawn is really (count >> 1).
 * @param paint The paint used to draw the points
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPoints(float[] pts, int offset, int count, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Helper for drawPoints() that assumes you want to draw the entire array
 
 * @param pts This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 * @apiSince 1
 */

public void drawPoints(@androidx.annotation.NonNull float[] pts, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the text in the array, with each character's origin specified by the pos array.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param index The index of the first character to draw
 * @param count The number of characters to draw, starting from index.
 * @param pos Array of [x,y] positions, used to position each character
 * This value must never be {@code null}.
 * @param paint The paint used for the text (e.g. color, size, style)
 * This value must never be {@code null}.
 * @deprecated This method does not support glyph composition and decomposition and should
 *             therefore not be used to render complex scripts. It also doesn't handle
 *             supplementary characters (eg emoji).
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void drawPosText(@androidx.annotation.NonNull char[] text, int index, int count, @androidx.annotation.NonNull float[] pos, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the text in the array, with each character's origin specified by the pos array.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param pos Array of [x,y] positions, used to position each character
 * This value must never be {@code null}.
 * @param paint The paint used for the text (e.g. color, size, style)
 * This value must never be {@code null}.
 * @deprecated This method does not support glyph composition and decomposition and should
 *             therefore not be used to render complex scripts. It also doesn't handle
 *             supplementary characters (eg emoji).
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void drawPosText(@androidx.annotation.NonNull java.lang.String text, @androidx.annotation.NonNull float[] pos, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified Rect using the specified paint. The rectangle will be filled or framed
 * based on the Style in the paint.
 *
 * @param rect The rect to be drawn
 * This value must never be {@code null}.
 * @param paint The paint used to draw the rect
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawRect(@androidx.annotation.NonNull android.graphics.RectF rect, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified Rect using the specified Paint. The rectangle will be filled or framed
 * based on the Style in the paint.
 *
 * @param r The rectangle to be drawn.
 * This value must never be {@code null}.
 * @param paint The paint used to draw the rectangle
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawRect(@androidx.annotation.NonNull android.graphics.Rect r, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified Rect using the specified paint. The rectangle will be filled or framed
 * based on the Style in the paint.
 *
 * @param left The left side of the rectangle to be drawn
 * @param top The top side of the rectangle to be drawn
 * @param right The right side of the rectangle to be drawn
 * @param bottom The bottom side of the rectangle to be drawn
 * @param paint The paint used to draw the rect
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawRect(float left, float top, float right, float bottom, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Fill the entire canvas' bitmap (restricted to the current clip) with the specified RGB color,
 * using srcover porterduff mode.
 *
 * @param r red component (0..255) of the color to draw onto the canvas
 * @param g green component (0..255) of the color to draw onto the canvas
 * @param b blue component (0..255) of the color to draw onto the canvas
 * @apiSince 1
 */

public void drawRGB(int r, int g, int b) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified round-rect using the specified paint. The roundrect will be filled or
 * framed based on the Style in the paint.
 *
 * @param rect The rectangular bounds of the roundRect to be drawn
 * This value must never be {@code null}.
 * @param rx The x-radius of the oval used to round the corners
 * @param ry The y-radius of the oval used to round the corners
 * @param paint The paint used to draw the roundRect
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawRoundRect(@androidx.annotation.NonNull android.graphics.RectF rect, float rx, float ry, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified round-rect using the specified paint. The roundrect will be filled or
 * framed based on the Style in the paint.
 *
 * @param rx The x-radius of the oval used to round the corners
 * @param ry The y-radius of the oval used to round the corners
 * @param paint The paint used to draw the roundRect
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draws a double rounded rectangle using the specified paint. The resultant round rect
 * will be filled in the area defined between the outer and inner rectangular bounds if
 * the {@link android.graphics.Paint Paint} configured with {@link android.graphics.Paint.Style#FILL Paint.Style#FILL}.
 * Otherwise if {@link android.graphics.Paint.Style#STROKE Paint.Style#STROKE} is used, then 2 rounded rect strokes will
 * be drawn at the outer and inner rounded rectangles
 *
 * @param outer The outer rectangular bounds of the roundRect to be drawn
 * This value must never be {@code null}.
 * @param outerRx The x-radius of the oval used to round the corners on the outer rectangle
 * @param outerRy The y-radius of the oval used to round the corners on the outer rectangle
 * @param inner The inner rectangular bounds of the roundRect to be drawn
 * This value must never be {@code null}.
 * @param innerRx The x-radius of the oval used to round the corners on the inner rectangle
 * @param innerRy The y-radius of the oval used to round the corners on the outer rectangle
 * @param paint The paint used to draw the double roundRect
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void drawDoubleRoundRect(@androidx.annotation.NonNull android.graphics.RectF outer, float outerRx, float outerRy, @androidx.annotation.NonNull android.graphics.RectF inner, float innerRx, float innerRy, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draws a double rounded rectangle using the specified paint. The resultant round rect
 * will be filled in the area defined between the outer and inner rectangular bounds if
 * the {@link android.graphics.Paint Paint} configured with {@link android.graphics.Paint.Style#FILL Paint.Style#FILL}.
 * Otherwise if {@link android.graphics.Paint.Style#STROKE Paint.Style#STROKE} is used, then 2 rounded rect strokes will
 * be drawn at the outer and inner rounded rectangles
 *
 * @param outer The outer rectangular bounds of the roundRect to be drawn
 * This value must never be {@code null}.
 * @param outerRadii Array of 8 float representing the x, y corner radii for top left,
 *                   top right, bottom right, bottom left corners respectively on the outer
 *                   rounded rectangle
 *
 * This value must never be {@code null}.
 * @param inner The inner rectangular bounds of the roundRect to be drawn
 * This value must never be {@code null}.
 * @param innerRadii Array of 8 float representing the x, y corner radii for top left,
 *                   top right, bottom right, bottom left corners respectively on the
 *                   outer rounded rectangle
 * This value must never be {@code null}.
 * @param paint The paint used to draw the double roundRect
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void drawDoubleRoundRect(@androidx.annotation.NonNull android.graphics.RectF outer, @androidx.annotation.NonNull float[] outerRadii, @androidx.annotation.NonNull android.graphics.RectF inner, @androidx.annotation.NonNull float[] innerRadii, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the text, with origin at (x,y), using the specified paint. The origin is interpreted
 * based on the Align setting in the paint.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param x The x-coordinate of the origin of the text being drawn
 * @param y The y-coordinate of the baseline of the text being drawn
 * @param paint The paint used for the text (e.g. color, size, style)
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawText(@androidx.annotation.NonNull char[] text, int index, int count, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the text, with origin at (x,y), using the specified paint. The origin is interpreted
 * based on the Align setting in the paint.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param x The x-coordinate of the origin of the text being drawn
 * @param y The y-coordinate of the baseline of the text being drawn
 * @param paint The paint used for the text (e.g. color, size, style)
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawText(@androidx.annotation.NonNull java.lang.String text, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the text, with origin at (x,y), using the specified paint. The origin is interpreted
 * based on the Align setting in the paint.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param start The index of the first character in text to draw
 * @param end (end - 1) is the index of the last character in text to draw
 * @param x The x-coordinate of the origin of the text being drawn
 * @param y The y-coordinate of the baseline of the text being drawn
 * @param paint The paint used for the text (e.g. color, size, style)
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawText(@androidx.annotation.NonNull java.lang.String text, int start, int end, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the specified range of text, specified by start/end, with its origin at (x,y), in the
 * specified Paint. The origin is interpreted based on the Align setting in the Paint.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param start The index of the first character in text to draw
 * @param end (end - 1) is the index of the last character in text to draw
 * @param x The x-coordinate of origin for where to draw the text
 * @param y The y-coordinate of origin for where to draw the text
 * @param paint The paint used for the text (e.g. color, size, style)
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawText(@androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, float x, float y, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the text, with origin at (x,y), using the specified paint, along the specified path. The
 * paint's Align setting determins where along the path to start the text.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param path The path the text should follow for its baseline
 * This value must never be {@code null}.
 * @param hOffset The distance along the path to add to the text's starting position
 * @param vOffset The distance above(-) or below(+) the path to position the text
 * @param paint The paint used for the text (e.g. color, size, style)
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawTextOnPath(@androidx.annotation.NonNull char[] text, int index, int count, @androidx.annotation.NonNull android.graphics.Path path, float hOffset, float vOffset, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the text, with origin at (x,y), using the specified paint, along the specified path. The
 * paint's Align setting determins where along the path to start the text.
 *
 * @param text The text to be drawn
 * This value must never be {@code null}.
 * @param path The path the text should follow for its baseline
 * This value must never be {@code null}.
 * @param hOffset The distance along the path to add to the text's starting position
 * @param vOffset The distance above(-) or below(+) the path to position the text
 * @param paint The paint used for the text (e.g. color, size, style)
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawTextOnPath(@androidx.annotation.NonNull java.lang.String text, @androidx.annotation.NonNull android.graphics.Path path, float hOffset, float vOffset, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw a run of text, all in a single direction, with optional context for complex text
 * shaping.
 * <p>
 * See {@link #drawTextRun(java.lang.CharSequence,int,int,int,int,float,float,boolean,android.graphics.Paint)} for
 * more details. This method uses a character array rather than CharSequence to represent the
 * string. Also, to be consistent with the pattern established in {@link #drawText}, in this
 * method {@code count} and {@code contextCount} are used rather than offsets of the end
 * position; {@code count = end - start, contextCount = contextEnd -
 * contextStart}.
 *
 * @param text the text to render
 * This value must never be {@code null}.
 * @param index the start of the text to render
 * @param count the count of chars to render
 * @param contextIndex the start of the context for shaping. Must be no greater than index.
 * @param contextCount the number of characters in the context for shaping. contexIndex +
 *            contextCount must be no less than index + count.
 * @param x the x position at which to draw the text
 * @param y the y position at which to draw the text
 * @param isRtl whether the run is in RTL direction
 * @param paint the paint
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void drawTextRun(@androidx.annotation.NonNull char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw a run of text, all in a single direction, with optional context for complex text
 * shaping.
 * <p>
 * The run of text includes the characters from {@code start} to {@code end} in the text. In
 * addition, the range {@code contextStart} to {@code contextEnd} is used as context for the
 * purpose of complex text shaping, such as Arabic text potentially shaped differently based on
 * the text next to it.
 * <p>
 * All text outside the range {@code contextStart..contextEnd} is ignored. The text between
 * {@code start} and {@code end} will be laid out and drawn. The context range is useful for
 * contextual shaping, e.g. Kerning, Arabic contextural form.
 * <p>
 * The direction of the run is explicitly specified by {@code isRtl}. Thus, this method is
 * suitable only for runs of a single direction. Alignment of the text is as determined by the
 * Paint's TextAlign value. Further, {@code 0 <= contextStart <= start <= end <= contextEnd
 * <= text.length} must hold on entry.
 * <p>
 * Also see {@link android.graphics.Paint#getRunAdvance} for a corresponding method to measure
 * the text; the advance width of the text drawn matches the value obtained from that method.
 *
 * @param text the text to render
 * This value must never be {@code null}.
 * @param start the start of the text to render. Data before this position can be used for
 *            shaping context.
 * @param end the end of the text to render. Data at or after this position can be used for
 *            shaping context.
 * @param contextStart the index of the start of the shaping context
 * @param contextEnd the index of the end of the shaping context
 * @param x the x position at which to draw the text
 * @param y the y position at which to draw the text
 * @param isRtl whether the run is in RTL direction
 * @param paint the paint
 * This value must never be {@code null}.
 * @see #drawTextRun(char[], int, int, int, int, float, float, boolean, Paint)
 * @apiSince 23
 */

public void drawTextRun(@androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw a run of text, all in a single direction, with optional context for complex text
 * shaping.
 * <p>
 * See {@link #drawTextRun(java.lang.CharSequence,int,int,int,int,float,float,boolean,android.graphics.Paint)} for
 * more details. This method uses a {@link android.graphics.text.MeasuredText MeasuredText} rather than CharSequence to represent
 * the string.
 *
 * @param text the text to render
 * This value must never be {@code null}.
 * @param start the start of the text to render. Data before this position can be used for
 *            shaping context.
 * @param end the end of the text to render. Data at or after this position can be used for
 *            shaping context.
 * @param contextStart the index of the start of the shaping context
 * @param contextEnd the index of the end of the shaping context
 * @param x the x position at which to draw the text
 * @param y the y position at which to draw the text
 * @param isRtl whether the run is in RTL direction
 * @param paint the paint
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void drawTextRun(@androidx.annotation.NonNull android.graphics.text.MeasuredText text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw the array of vertices, interpreted as triangles (based on mode). The verts array is
 * required, and specifies the x,y pairs for each vertex. If texs is non-null, then it is used
 * to specify the coordinate in shader coordinates to use at each vertex (the paint must have a
 * shader in this case). If there is no texs array, but there is a color array, then each color
 * is interpolated across its corresponding triangle in a gradient. If both texs and colors
 * arrays are present, then they behave as before, but the resulting color at each pixels is the
 * result of multiplying the colors from the shader and the color-gradient together. The indices
 * array is optional, but if it is present, then it is used to specify the index of each
 * triangle, rather than just walking through the arrays in order.
 *
 * @param mode How to interpret the array of vertices
 * This value must never be {@code null}.
 * @param vertexCount The number of values in the vertices array (and corresponding texs and
 *            colors arrays if non-null). Each logical vertex is two values (x, y), vertexCount
 *            must be a multiple of 2.
 * @param verts Array of vertices for the mesh
 * This value must never be {@code null}.
 * @param vertOffset Number of values in the verts to skip before drawing.
 * @param texs May be null. If not null, specifies the coordinates to sample into the current
 *            shader (e.g. bitmap tile or gradient)
 * This value may be {@code null}.
 * @param texOffset Number of values in texs to skip before drawing.
 * @param colors May be null. If not null, specifies a color for each vertex, to be interpolated
 *            across the triangle.
 * This value may be {@code null}.
 * @param colorOffset Number of values in colors to skip before drawing.
 * @param indices If not null, array of indices to reference into the vertex (texs, colors)
 *            array.
 * This value may be {@code null}.
 * @param indexCount number of entries in the indices array (if not null).
 * @param paint Specifies the shader to use if the texs array is non-null.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void drawVertices(@androidx.annotation.NonNull android.graphics.Canvas.VertexMode mode, int vertexCount, @androidx.annotation.NonNull float[] verts, int vertOffset, @androidx.annotation.Nullable float[] texs, int texOffset, @androidx.annotation.Nullable int[] colors, int colorOffset, @androidx.annotation.Nullable short[] indices, int indexOffset, int indexCount, @androidx.annotation.NonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draws the given RenderNode. This is only supported in hardware rendering, which can be
 * verified by asserting that {@link #isHardwareAccelerated()} is true. If
 * {@link #isHardwareAccelerated()} is false then this throws an exception.
 *
 * See {@link android.graphics.RenderNode RenderNode} for more information on what a RenderNode is and how to use it.
 *
 * @param renderNode The RenderNode to draw, must be non-null.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void drawRenderNode(@androidx.annotation.NonNull android.graphics.RenderNode renderNode) { throw new RuntimeException("Stub!"); }

/**
 * Restore everything when restore() is called (standard save flags).
 * <p class="note"><strong>Note:</strong> for performance reasons, it is
 * strongly recommended to pass this - the complete set of flags - to any
 * call to <code>saveLayer()</code> and <code>saveLayerAlpha()</code>
 * variants.
 *
 * <p class="note"><strong>Note:</strong> all methods that accept this flag
 * have flagless versions that are equivalent to passing this flag.
 * @apiSince 1
 */

public static final int ALL_SAVE_FLAG = 31; // 0x1f
/**
 * Constant values used as parameters to {@code quickReject()} calls. These values
 * specify how much space around the shape should be accounted for, depending on whether
 * the shaped area is antialiased or not.
 *
 * @see #quickReject(float, float, float, float, EdgeType)
 * @see #quickReject(Path, EdgeType)
 * @see #quickReject(RectF, EdgeType)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum EdgeType {
/**
 * Black-and-White: Treat edges by just rounding to nearest pixel boundary
 * @apiSince 1
 */

BW,
/**
 * Antialiased: Treat edges by rounding-out, since they may be antialiased
 * @apiSince 1
 */

AA;
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum VertexMode {
/** @apiSince 1 */

TRIANGLES,
/** @apiSince 1 */

TRIANGLE_STRIP,
/** @apiSince 1 */

TRIANGLE_FAN;
}

}

