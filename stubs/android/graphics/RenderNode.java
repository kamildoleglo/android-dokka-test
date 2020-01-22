/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.view.View;
import android.view.Surface;

/**
 * <p>RenderNode is used to build hardware accelerated rendering hierarchies. Each RenderNode
 * contains both a display list as well as a set of properties that affect the rendering of the
 * display list. RenderNodes are used internally for all Views by default and are not typically
 * used directly.</p>
 *
 * <p>RenderNodes are used to divide up the rendering content of a complex scene into smaller
 * pieces that can then be updated individually more cheaply. Updating part of the scene only needs
 * to update the display list or properties of a small number of RenderNode instead of redrawing
 * everything from scratch. A RenderNode only needs its display list re-recorded when its content
 * alone should be changed. RenderNodes can also be transformed without re-recording the display
 * list through the transform properties.</p>
 *
 * <p>A text editor might for instance store each paragraph into its own RenderNode.
 * Thus when the user inserts or removes characters, only the display list of the
 * affected paragraph needs to be recorded again.</p>
 *
 * <h3>Hardware acceleration</h3>
 * <p>RenderNodes can be drawn using a {@link android.graphics.RecordingCanvas RecordingCanvas}. They are not
 * supported in software. Always make sure that the {@link android.graphics.Canvas}
 * you are using to render a display list is hardware accelerated using
 * {@link android.graphics.Canvas#isHardwareAccelerated()}.</p>
 *
 * <h3>Creating a RenderNode</h3>
 * <pre class="prettyprint">
 *     RenderNode renderNode = new RenderNode("myRenderNode");
 *     renderNode.setLeftTopRightBottom(0, 0, 50, 50); // Set the size to 50x50
 *     RecordingCanvas canvas = renderNode.beginRecording();
 *     try {
 *         // Draw with the canvas
 *         canvas.drawRect(...);
 *     } finally {
 *         renderNode.endRecording();
 *     }</pre>
 *
 * <h3>Drawing a RenderNode in a View</h3>
 * <pre class="prettyprint">
 *     protected void onDraw(Canvas canvas) {
 *         if (canvas.isHardwareAccelerated()) {
 *             // Check that the RenderNode has a display list, re-recording it if it does not.
 *             if (!myRenderNode.hasDisplayList()) {
 *                 updateDisplayList(myRenderNode);
 *             }
 *             // Draw the RenderNode into this canvas.
 *             canvas.drawRenderNode(myRenderNode);
 *         }
 *     }</pre>
 *
 * <h3>Releasing resources</h3>
 * <p>This step is not mandatory but recommended if you want to release resources
 * held by a display list as soon as possible. Most significantly any bitmaps it may contain.</p>
 * <pre class="prettyprint">
 *     // Discards the display list content allowing for any held resources to be released.
 *     // After calling this
 *     renderNode.discardDisplayList();</pre>
 *
 *
 * <h3>Properties</h3>
 * <p>In addition, a RenderNode offers several properties, such as
 * {@link #setScaleX(float)} or {@link #setTranslationX(float)}, that can be used to affect all
 * the drawing commands recorded within. For instance, these properties can be used
 * to move around a large number of images without re-issuing all the individual
 * <code>canvas.drawBitmap()</code> calls.</p>
 *
 * <pre class="prettyprint">
 *     private void createDisplayList() {
 *         mRenderNode = new RenderNode("MyRenderNode");
 *         mRenderNode.setLeftTopRightBottom(0, 0, width, height);
 *         RecordingCanvas canvas = mRenderNode.beginRecording();
 *         try {
 *             for (Bitmap b : mBitmaps) {
 *                 canvas.drawBitmap(b, 0.0f, 0.0f, null);
 *                 canvas.translate(0.0f, b.getHeight());
 *             }
 *         } finally {
 *             mRenderNode.endRecording();
 *         }
 *     }
 *
 *     protected void onDraw(Canvas canvas) {
 *         if (canvas.isHardwareAccelerated())
 *             canvas.drawRenderNode(mRenderNode);
 *         }
 *     }
 *
 *     private void moveContentBy(int x) {
 *          // This will move all the bitmaps recorded inside the display list
 *          // by x pixels to the right and redraw this view. All the commands
 *          // recorded in createDisplayList() won't be re-issued, only onDraw()
 *          // will be invoked and will execute very quickly
 *          mRenderNode.offsetLeftAndRight(x);
 *          invalidate();
 *     }</pre>
 *
 * <p>A few of the properties may at first appear redundant, such as {@link #setElevation(float)}
 * and {@link #setTranslationZ(float)}. The reason for these duplicates are to allow for a
 * separation between static & transient usages. For example consider a button that raises from 2dp
 * to 8dp when pressed. To achieve that an application may decide to setElevation(2dip), and then
 * on press to animate setTranslationZ to 6dip. Combined this achieves the final desired 8dip
 * value, but the animation need only concern itself with animating the lift from press without
 * needing to know the initial starting value. {@link #setTranslationX(float)} and
 * {@link #setTranslationY(float)} are similarly provided for animation uses despite the functional
 * overlap with {@link #setPosition(android.graphics.Rect)}.
 *
 * <p>The RenderNode's transform matrix is computed at render time as follows:
 * <pre class="prettyprint">
 *     Matrix transform = new Matrix();
 *     transform.setTranslate(renderNode.getTranslationX(), renderNode.getTranslationY());
 *     transform.preRotate(renderNode.getRotationZ(),
 *             renderNode.getPivotX(), renderNode.getPivotY());
 *     transform.preScale(renderNode.getScaleX(), renderNode.getScaleY(),
 *             renderNode.getPivotX(), renderNode.getPivotY());</pre>
 * The current canvas transform matrix, which is translated to the RenderNode's position,
 * is then multiplied by the RenderNode's transform matrix. Therefore the ordering of calling
 * property setters does not affect the result. That is to say that:
 *
 * <pre class="prettyprint">
 *     renderNode.setTranslationX(100);
 *     renderNode.setScaleX(100);</pre>
 *
 * is equivalent to:
 *
 * <pre class="prettyprint">
 *     renderNode.setScaleX(100);
 *     renderNode.setTranslationX(100);</pre>
 *
 * <h3>Threading</h3>
 * <p>RenderNode may be created and used on any thread but they are not thread-safe. Only
 * a single thread may interact with a RenderNode at any given time. It is critical
 * that the RenderNode is only used on the same thread it is drawn with. For example when using
 * RenderNode with a custom View, then that RenderNode must only be used from the UI thread.</p>
 *
 * <h3>When to re-render</h3>
 * <p>Many of the RenderNode mutation methods, such as {@link #setTranslationX(float)}, return
 * a boolean indicating if the value actually changed or not. This is useful in detecting
 * if a new frame should be rendered or not. A typical usage would look like:
 * <pre class="prettyprint">
 *     public void translateTo(int x, int y) {
 *         boolean needsUpdate = myRenderNode.setTranslationX(x);
 *         needsUpdate |= myRenderNode.setTranslationY(y);
 *         if (needsUpdate) {
 *             myOwningView.invalidate();
 *         }
 *     }</pre>
 * This is marginally faster than doing a more explicit up-front check if the value changed by
 * comparing the desired value against {@link #getTranslationX()} as it minimizes JNI transitions.
 * The actual mechanism of requesting a new frame to be rendered will depend on how this
 * RenderNode is being drawn. If it's drawn to a containing View, as in the above snippet,
 * then simply invalidating that View works. If instead the RenderNode is being drawn to a Canvas
 * directly such as with {@link android.view.Surface#lockHardwareCanvas() Surface#lockHardwareCanvas()} then a new frame needs to be drawn
 * by calling {@link android.view.Surface#lockHardwareCanvas() Surface#lockHardwareCanvas()}, re-drawing the root RenderNode or whatever
 * top-level content is desired, and finally calling {@link android.view.Surface#unlockCanvasAndPost(android.graphics.Canvas) Surface#unlockCanvasAndPost(Canvas)}.
 * </p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RenderNode {

/**
 * Creates a new RenderNode that can be used to record batches of
 * drawing operations, and store / apply render properties when drawn.
 *
 * @param name The name of the RenderNode, used for debugging purpose. May be null.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public RenderNode(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Starts recording a display list for the render node. All
 * operations performed on the returned canvas are recorded and
 * stored in this display list.
 *
 * {@link #endRecording()} must be called when the recording is finished in order to apply
 * the updated display list. Failing to call {@link #endRecording()} will result in an
 * {@link java.lang.IllegalStateException IllegalStateException} if {@link #beginRecording(int,int)} is called again.
 *
 * @param width  The width of the recording viewport. This will not alter the width of the
 *               RenderNode itself, that must be set with {@link #setPosition(android.graphics.Rect)}.
 * @param height The height of the recording viewport. This will not alter the height of the
 *               RenderNode itself, that must be set with {@link #setPosition(android.graphics.Rect)}.
 * @return A canvas to record drawing operations.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException If a recording is already in progress. That is, the previous
 * call to {@link #beginRecording(int,int)} did not call {@link #endRecording()}.
 * @see #endRecording()
 * @see #hasDisplayList()
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.RecordingCanvas beginRecording(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #beginRecording(int,int)} with the width & height set
 * to the RenderNode's own width & height. The RenderNode's width & height may be set
 * with {@link #setPosition(int,int,int,int)}.
 *
 * @return A canvas to record drawing operations.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException If a recording is already in progress. That is, the previous
 * call to {@link #beginRecording(int,int)} did not call {@link #endRecording()}.
 * @see #endRecording()
 * @see #hasDisplayList()
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.RecordingCanvas beginRecording() { throw new RuntimeException("Stub!"); }

/**
 * `
 * Ends the recording for this display list. Calling this method marks
 * the display list valid and {@link #hasDisplayList()} will return true.
 *
 * @see #beginRecording(int, int)
 * @see #hasDisplayList()
 * @apiSince 29
 */

public void endRecording() { throw new RuntimeException("Stub!"); }

/**
 * Reset native resources. This is called when cleaning up the state of display lists
 * during destruction of hardware resources, to ensure that we do not hold onto
 * obsolete resources after related resources are gone.
 * @apiSince 29
 */

public void discardDisplayList() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the RenderNode has a display list. If this returns false, the RenderNode
 * should be re-recorded with {@link #beginRecording()} and {@link #endRecording()}.
 *
 * A RenderNode without a display list may still be drawn, however it will have no impact
 * on the rendering content until its display list is updated.
 *
 * When a RenderNode is no longer drawn by anything the system may automatically
 * invoke {@link #discardDisplayList()}. It is therefore important to ensure that
 * {@link #hasDisplayList()} is true on a RenderNode prior to drawing it.
 *
 * See {@link #discardDisplayList()}
 *
 * @return boolean true if this RenderNode has a display list, false otherwise.
 * @apiSince 29
 */

public boolean hasDisplayList() { throw new RuntimeException("Stub!"); }

/**
 * Whether or not the RenderNode has an identity transform. This is a faster
 * way to do the otherwise equivalent {@link #getMatrix(android.graphics.Matrix)} {@link android.graphics.Matrix#isIdentity() Matrix#isIdentity()}
 * as it doesn't require copying the Matrix first, thus minimizing overhead.
 *
 * @return true if the RenderNode has an identity transform, false otherwise
 * @apiSince 29
 */

public boolean hasIdentityMatrix() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current transform matrix
 *
 * @param outMatrix The matrix to store the transform of the RenderNode
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void getMatrix(@androidx.annotation.NonNull android.graphics.Matrix outMatrix) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current transform inverted. This is a faster way to do the otherwise
 * equivalent {@link #getMatrix(android.graphics.Matrix)} followed by {@link android.graphics.Matrix#invert(android.graphics.Matrix) Matrix#invert(Matrix)}
 *
 * @param outMatrix The matrix to store the inverse transform of the RenderNode
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void getInverseMatrix(@androidx.annotation.NonNull android.graphics.Matrix outMatrix) { throw new RuntimeException("Stub!"); }

/**
 * Controls whether or not to force this RenderNode to render to an intermediate buffer.
 * Internally RenderNode will already promote itself to a composition layer if it's useful
 * for performance or required for the current combination of {@link #setAlpha(float)} and
 * {@link #setHasOverlappingRendering(boolean)}.
 *
 * <p>The usage of this is instead to allow for either overriding of the internal behavior
 * if it's measured to be necessary for the particular rendering content in question or, more
 * usefully, to add a composition effect to the RenderNode via the optional paint parameter.
 *
 * <p>Note: When a RenderNode is using a compositing layer it will also result in
 * clipToBounds=true behavior.
 *
 * @param forceToLayer if true this forces the RenderNode to use an intermediate buffer.
 *                     Default & generally recommended value is false.
 * @param paint        The blend mode, alpha, and ColorFilter to apply to the compositing layer.
 *                     Only applies if forceToLayer is true. The paint's alpha is multiplied
 *                     with {@link #getAlpha()} to resolve the final alpha of the RenderNode.
 *                     If null then no additional composition effects are applied on top of the
 *                     composition layer.
 * This value may be {@code null}.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setUseCompositingLayer(boolean forceToLayer, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether or not a compositing layer is forced to be used. The default & recommended
 * is false, as it is typically faster to avoid using compositing layers.
 * See {@link #setUseCompositingLayer(boolean,android.graphics.Paint)}.
 *
 * @return true if a compositing layer is forced, false otherwise
 * @apiSince 29
 */

public boolean getUseCompositingLayer() { throw new RuntimeException("Stub!"); }

/**
 * Sets an additional clip on the RenderNode. If null, the extra clip is removed from the
 * RenderNode. If non-null, the RenderNode will be clipped to this rect. In addition  if
 * {@link #setClipToBounds(boolean)} is true, then the RenderNode will be clipped to the
 * intersection of this rectangle and the bounds of the render node, which is set with
 * {@link #setPosition(android.graphics.Rect)}.
 *
 * <p>This is equivalent to do a {@link android.graphics.Canvas#clipRect(android.graphics.Rect) Canvas#clipRect(Rect)} at the start of this
 * RenderNode's display list. However, as this is a property of the RenderNode instead
 * of part of the display list it can be more easily animated for transient additional
 * clipping. An example usage of this would be the {@link android.transition.ChangeBounds}
 * transition animation with the resizeClip=true option.
 *
 * @param rect the bounds to clip to. If null, the additional clip is removed.
 * This value may be {@code null}.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setClipRect(@androidx.annotation.Nullable android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the Render node should clip itself to its bounds. This defaults to true,
 * and is useful to the renderer in enable quick-rejection of chunks of the tree as well as
 * better partial invalidation support. Clipping can be further restricted or controlled
 * through the combination of this property as well as {@link #setClipRect(android.graphics.Rect)}, which
 * allows for a different clipping rectangle to be used in addition to or instead of the
 * {@link #setPosition(int,int,int,int)} or the RenderNode.
 *
 * @param clipToBounds true if the display list should clip to its bounds, false otherwise.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setClipToBounds(boolean clipToBounds) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not the RenderNode is clipping to its bounds. See
 * {@link #setClipToBounds(boolean)} and {@link #setPosition(int,int,int,int)}
 *
 * @return true if the render node clips to its bounds, false otherwise.
 * @apiSince 29
 */

public boolean getClipToBounds() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets whether the RenderNode should be drawn immediately after the
 * closest ancestor RenderNode containing a projection receiver.
 *
 * <p>The default is false, and the rendering of this node happens in the typical draw order.
 *
 * <p>If true, then at rendering time this rendernode will not be drawn in order with the
 * {@link android.graphics.Canvas#drawRenderNode(android.graphics.RenderNode) Canvas#drawRenderNode(RenderNode)} command that drew this RenderNode, but instead
 * it will be re-positioned in the RenderNode tree to be drawn on the closet ancestor with a
 * child rendernode that has {@link #setProjectionReceiver(boolean)} as true.
 *
 * <p>The typical usage of this is to allow a child RenderNode to draw on a parent's background,
 * such as the platform's usage with {@link android.graphics.drawable.RippleDrawable}. Consider
 * the following structure, built out of which RenderNode called drawRenderNode on a different
 * RenderNode:
 *
 * <pre>
 *        +-------------+
 *        |RenderNode: P|
 *        +-+----------++
 *          |          |
 *          v          v
 *  +-------+-----+  +-+--------------+
 *  |RenderNode: C|  |RenderNode: P'BG|
 *  +-------+-----+  +----------------+
 *          |
 *          |
 * +--------+-------+
 * |RenderNode: C'BG|
 * +----------------+
 * </pre>
 *
 * If P'BG is a projection receiver, and C'BG is set to project backwards then C'BG will
 * behave as if it was drawn directly by P'BG instead of by C. This includes inheriting P'BG's
 * clip instead of C's clip.
 *
 * @param shouldProject true if the display list should be projected onto a
 *                      containing volume. Default is false.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setProjectBackwards(boolean shouldProject) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the RenderNode is a projection receiver. If true then this RenderNode's parent
 * should draw any descendant RenderNodes with ProjectBackwards=true directly on top of it.
 * Default value is false. See
 * {@link #setProjectBackwards(boolean)} for a description of what this entails.
 *
 * @param shouldRecieve True if this RenderNode is a projection receiver, false otherwise.
 *                      Default is false.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setProjectionReceiver(boolean shouldRecieve) { throw new RuntimeException("Stub!"); }

/**
 * Sets the outline, defining the shape that casts a shadow, and the path to
 * be clipped if setClipToOutline is set.
 *
 * This will make a copy of the provided {@link android.graphics.Outline Outline}, so any future modifications
 * to the outline will need to call {@link #setOutline(android.graphics.Outline)} with the modified
 * outline for those changes to be applied.
 *
 * @param outline The outline to use for this RenderNode.
 * This value may be {@code null}.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setOutline(@androidx.annotation.Nullable android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the RenderNode has a shadow. That is, if the combination of {@link #getElevation()}
 * and {@link #getTranslationZ()} is greater than zero, there is an {@link android.graphics.Outline Outline} set with
 * a valid shadow caster path, and the provided outline has a non-zero
 * {@link android.graphics.Outline#getAlpha() Outline#getAlpha()}.
 *
 * @return True if this RenderNode has a shadow, false otherwise
 * @apiSince 29
 */

public boolean hasShadow() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of the spot shadow that is drawn when the RenderNode has a positive Z or
 * elevation value and is drawn inside of a {@link android.graphics.Canvas#enableZ() Canvas#enableZ()} section.
 * <p>
 * By default the shadow color is black. Generally, this color will be opaque so the intensity
 * of the shadow is consistent between different RenderNodes with different colors.
 * <p>
 * The opacity of the final spot shadow is a function of the shadow caster height, the
 * alpha channel of the outlineSpotShadowColor (typically opaque), and the
 * {@link android.R.attr#spotShadowAlpha} theme attribute
 *
 * @param color The color this RenderNode will cast for its elevation spot shadow.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setSpotShadowColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * @return The shadow color set by {@link #setSpotShadowColor(int)}, or black if nothing
 * was set
 * @apiSince 29
 */

public int getSpotShadowColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of the ambient shadow that is drawn when the RenderNode has a positive Z or
 * elevation value and is drawn inside of a {@link android.graphics.Canvas#enableZ() Canvas#enableZ()} section.
 * <p>
 * By default the shadow color is black. Generally, this color will be opaque so the intensity
 * of the shadow is consistent between different RenderNodes with different colors.
 * <p>
 * The opacity of the final ambient shadow is a function of the shadow caster height, the
 * alpha channel of the outlineAmbientShadowColor (typically opaque), and the
 * {@link android.R.attr#ambientShadowAlpha} theme attribute.
 *
 * @param color The color this RenderNode will cast for its elevation shadow.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setAmbientShadowColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * @return The shadow color set by {@link #setAmbientShadowColor(int)}, or black if
 * nothing was set
 * @apiSince 29
 */

public int getAmbientShadowColor() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables clipping to the outline.
 *
 * @param clipToOutline true if clipping to the outline.
 * @return True if the clipToOutline value changed, false if previous value matched the new
 *         value.
 * @apiSince 29
 */

public boolean setClipToOutline(boolean clipToOutline) { throw new RuntimeException("Stub!"); }

/**
 * See {@link #setClipToOutline(boolean)}
 *
 * @return True if this RenderNode clips to its outline, false otherwise
 * @apiSince 29
 */

public boolean getClipToOutline() { throw new RuntimeException("Stub!"); }

/**
 * Sets the translucency level for the display list.
 *
 * @param alpha The translucency of the display list, must be a value between 0.0f and 1.0f
 * @see android.view.View#setAlpha(float)
 * @see #getAlpha()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setAlpha(float alpha) { throw new RuntimeException("Stub!"); }

/**
 * Returns the translucency level of this display list.
 *
 * @return A value between 0.0f and 1.0f
 * @see #setAlpha(float)
 * @apiSince 29
 */

public float getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the display list renders content which overlaps. Non-overlapping rendering
 * can use a fast path for alpha that avoids rendering to an offscreen buffer. By default
 * display lists consider they do not have overlapping content.
 *
 * @param hasOverlappingRendering False if the content is guaranteed to be non-overlapping,
 *                                true otherwise.
 * @see android.view.View#hasOverlappingRendering()
 * @see #hasOverlappingRendering()
 * @apiSince 29
 */

public boolean setHasOverlappingRendering(boolean hasOverlappingRendering) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the content of this display list overlaps.
 *
 * @return True if this display list renders content which overlaps, false otherwise.
 * @see #setHasOverlappingRendering(boolean)
 * @apiSince 29
 */

public boolean hasOverlappingRendering() { throw new RuntimeException("Stub!"); }

/**
 * Sets the base elevation of this RenderNode in pixels
 *
 * @param lift the elevation in pixels
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setElevation(float lift) { throw new RuntimeException("Stub!"); }

/**
 * See {@link #setElevation(float)}
 *
 * @return The RenderNode's current elevation
 * @apiSince 29
 */

public float getElevation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the translation value for the display list on the X axis.
 *
 * @param translationX The X axis translation value of the display list, in pixels
 * @see android.view.View#setTranslationX(float)
 * @see #getTranslationX()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setTranslationX(float translationX) { throw new RuntimeException("Stub!"); }

/**
 * Returns the translation value for this display list on the X axis, in pixels.
 *
 * @see #setTranslationX(float)
 * @apiSince 29
 */

public float getTranslationX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the translation value for the display list on the Y axis.
 *
 * @param translationY The Y axis translation value of the display list, in pixels
 * @see android.view.View#setTranslationY(float)
 * @see #getTranslationY()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setTranslationY(float translationY) { throw new RuntimeException("Stub!"); }

/**
 * Returns the translation value for this display list on the Y axis, in pixels.
 *
 * @see #setTranslationY(float)
 * @apiSince 29
 */

public float getTranslationY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the translation value for the display list on the Z axis.
 *
 * @see android.view.View#setTranslationZ(float)
 * @see #getTranslationZ()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setTranslationZ(float translationZ) { throw new RuntimeException("Stub!"); }

/**
 * Returns the translation value for this display list on the Z axis.
 *
 * @see #setTranslationZ(float)
 * @apiSince 29
 */

public float getTranslationZ() { throw new RuntimeException("Stub!"); }

/**
 * Sets the rotation value for the display list around the Z axis.
 *
 * @param rotation The rotation value of the display list, in degrees
 * @see View#setRotationZ(float)
 * @see #getRotationZ()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setRotationZ(float rotation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the rotation value for this display list around the Z axis, in degrees.
 *
 * @see #setRotationZ(float)
 * @apiSince 29
 */

public float getRotationZ() { throw new RuntimeException("Stub!"); }

/**
 * Sets the rotation value for the display list around the X axis.
 *
 * @param rotationX The rotation value of the display list, in degrees
 * @see android.view.View#setRotationX(float)
 * @see #getRotationX()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setRotationX(float rotationX) { throw new RuntimeException("Stub!"); }

/**
 * Returns the rotation value for this display list around the X axis, in degrees.
 *
 * @see #setRotationX(float)
 * @apiSince 29
 */

public float getRotationX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the rotation value for the display list around the Y axis.
 *
 * @param rotationY The rotation value of the display list, in degrees
 * @see android.view.View#setRotationY(float)
 * @see #getRotationY()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setRotationY(float rotationY) { throw new RuntimeException("Stub!"); }

/**
 * Returns the rotation value for this display list around the Y axis, in degrees.
 *
 * @see #setRotationY(float)
 * @apiSince 29
 */

public float getRotationY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the scale value for the display list on the X axis.
 *
 * @param scaleX The scale value of the display list
 * @see android.view.View#setScaleX(float)
 * @see #getScaleX()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setScaleX(float scaleX) { throw new RuntimeException("Stub!"); }

/**
 * Returns the scale value for this display list on the X axis.
 *
 * @see #setScaleX(float)
 * @apiSince 29
 */

public float getScaleX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the scale value for the display list on the Y axis.
 *
 * @param scaleY The scale value of the display list
 * @see android.view.View#setScaleY(float)
 * @see #getScaleY()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setScaleY(float scaleY) { throw new RuntimeException("Stub!"); }

/**
 * Returns the scale value for this display list on the Y axis.
 *
 * @see #setScaleY(float)
 * @apiSince 29
 */

public float getScaleY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the pivot value for the display list on the X axis
 *
 * @param pivotX The pivot value of the display list on the X axis, in pixels
 * @see android.view.View#setPivotX(float)
 * @see #getPivotX()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setPivotX(float pivotX) { throw new RuntimeException("Stub!"); }

/**
 * Returns the pivot value for this display list on the X axis, in pixels.
 *
 * @see #setPivotX(float)
 * @apiSince 29
 */

public float getPivotX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the pivot value for the display list on the Y axis
 *
 * @param pivotY The pivot value of the display list on the Y axis, in pixels
 * @see android.view.View#setPivotY(float)
 * @see #getPivotY()
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setPivotY(float pivotY) { throw new RuntimeException("Stub!"); }

/**
 * Returns the pivot value for this display list on the Y axis, in pixels.
 *
 * @see #setPivotY(float)
 * @apiSince 29
 */

public float getPivotY() { throw new RuntimeException("Stub!"); }

/**
 * @return Whether or not a pivot was explicitly set with {@link #setPivotX(float)} or
 * {@link #setPivotY(float)}. If no pivot has been set then the pivot will be the center
 * of the RenderNode.
 * @apiSince 29
 */

public boolean isPivotExplicitlySet() { throw new RuntimeException("Stub!"); }

/**
 * Clears any pivot previously set by a call to  {@link #setPivotX(float)} or
 * {@link #setPivotY(float)}. After calling this {@link #isPivotExplicitlySet()} will be false
 * and the pivot used for rotation will return to default of being centered on the view.
 *
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean resetPivot() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the distance along the Z axis (orthogonal to the X/Y plane on which
 * RenderNodes are drawn) from the camera to this RenderNode. The camera's distance
 * affects 3D transformations, for instance rotations around the X and Y
 * axis. If the rotationX or rotationY properties are changed and this view is
 * large (more than half the size of the screen), it is recommended to always
 * use a camera distance that's greater than the height (X axis rotation) or
 * the width (Y axis rotation) of this view.</p>
 *
 * <p>The distance of the camera from the drawing plane can have an affect on the
 * perspective distortion of the RenderNode when it is rotated around the x or y axis.
 * For example, a large distance will result in a large viewing angle, and there
 * will not be much perspective distortion of the view as it rotates. A short
 * distance may cause much more perspective distortion upon rotation, and can
 * also result in some drawing artifacts if the rotated view ends up partially
 * behind the camera (which is why the recommendation is to use a distance at
 * least as far as the size of the view, if the view is to be rotated.)</p>
 *
 * <p>The distance is expressed in pixels and must always be positive</p>
 *
 * @param distance The distance in pixels, must always be positive
 * Value is between 0.0f and Float.MAX_VALUE inclusive
 * @see #setRotationX(float)
 * @see #setRotationY(float)
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setCameraDistance(float distance) { throw new RuntimeException("Stub!"); }

/**
 * Returns the distance in Z of the camera for this RenderNode
 *
 * @return the distance along the Z axis in pixels.
 * Value is between 0.0f and Float.MAX_VALUE inclusive
 * @see #setCameraDistance(float)
 * @apiSince 29
 */

public float getCameraDistance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the left position for the RenderNode.
 *
 * @return the left position in pixels
 * @apiSince 29
 */

public int getLeft() { throw new RuntimeException("Stub!"); }

/**
 * Gets the top position for the RenderNode.
 *
 * @return the top position in pixels
 * @apiSince 29
 */

public int getTop() { throw new RuntimeException("Stub!"); }

/**
 * Gets the right position for the RenderNode.
 *
 * @return the right position in pixels
 * @apiSince 29
 */

public int getRight() { throw new RuntimeException("Stub!"); }

/**
 * Gets the bottom position for the RenderNode.
 *
 * @return the bottom position in pixels
 * @apiSince 29
 */

public int getBottom() { throw new RuntimeException("Stub!"); }

/**
 * Gets the width of the RenderNode, which is the right - left.
 *
 * @return the width of the RenderNode
 * @apiSince 29
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the height of the RenderNode, which is the bottom - top.
 *
 * @return the height of the RenderNode
 * @apiSince 29
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the RenderNode.
 *
 * @param left   The left position of the RenderNode, in pixels
 * @param top    The top position of the RenderNode, in pixels
 * @param right  The right position of the RenderNode, in pixels
 * @param bottom The bottom position of the RenderNode, in pixels
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setPosition(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the RenderNode.
 *
 * @param position The position rectangle in pixels
 * This value must never be {@code null}.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setPosition(@androidx.annotation.NonNull android.graphics.Rect position) { throw new RuntimeException("Stub!"); }

/**
 * Offsets the left and right positions for the RenderNode
 *
 * @param offset The amount that the left and right positions are offset in pixels
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean offsetLeftAndRight(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Offsets the top and bottom values for the RenderNode
 *
 * @param offset The amount that the left and right positions are offset in pixels
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean offsetTopAndBottom(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Gets the approximate memory usage of the RenderNode for debug purposes. Does not include
 * the memory usage of any child RenderNodes nor any bitmaps, only the memory usage of
 * this RenderNode and any data it owns.
 *
 * <br>
 * Value is a non-negative number of bytes.
 * @return Approximate memory usage in bytes.
 
 * Value is a non-negative number of bytes.
 * @apiSince 29
 */

public long computeApproximateMemoryUsage() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether or not to allow force dark to apply to this RenderNode.
 *
 * Setting this to false will disable the auto-dark feature on everything this RenderNode
 * draws, including any descendants.
 *
 * Setting this to true will allow this RenderNode to be automatically made dark, however
 * a value of 'true' will not override any 'false' value in its parent chain nor will
 * it prevent any 'false' in any of its children.
 *
 * @param allow Whether or not to allow force dark.
 * @return True if the value changed, false if the new value was the same as the previous value.
 * @apiSince 29
 */

public boolean setForceDarkAllowed(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * See {@link #setForceDarkAllowed(boolean)}
 *
 * @return true if force dark is allowed (default), false if it is disabled
 * @apiSince 29
 */

public boolean isForceDarkAllowed() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique ID that identifies this RenderNode. This ID is unique for the
 * lifetime of the process. IDs are reset on process death, and are unique only within
 * the process.
 *
 * This ID is intended to be used with debugging tools to associate a particular
 * RenderNode across different debug dumping & inspection tools. For example
 * a View layout inspector should include the unique ID for any RenderNodes that it owns
 * to associate the drawing content with the layout content.
 *
 * @return the unique ID for this RenderNode
 * @apiSince 29
 */

public long getUniqueId() { throw new RuntimeException("Stub!"); }
}

