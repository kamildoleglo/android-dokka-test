/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.view;

import android.graphics.SurfaceTexture;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * <p>A TextureView can be used to display a content stream. Such a content
 * stream can for instance be a video or an OpenGL scene. The content stream
 * can come from the application's process as well as a remote process.</p>
 *
 * <p>TextureView can only be used in a hardware accelerated window. When
 * rendered in software, TextureView will draw nothing.</p>
 *
 * <p>Unlike {@link android.view.SurfaceView SurfaceView}, TextureView does not create a separate
 * window but behaves as a regular View. This key difference allows a
 * TextureView to be moved, transformed, animated, etc. For instance, you
 * can make a TextureView semi-translucent by calling
 * <code>myView.setAlpha(0.5f)</code>.</p>
 *
 * <p>Using a TextureView is simple: all you need to do is get its
 * {@link android.graphics.SurfaceTexture SurfaceTexture}. The {@link android.graphics.SurfaceTexture SurfaceTexture} can then be used to
 * render content. The following example demonstrates how to render the
 * camera preview into a TextureView:</p>
 *
 * <pre>
 *  public class LiveCameraActivity extends Activity implements TextureView.SurfaceTextureListener {
 *      private Camera mCamera;
 *      private TextureView mTextureView;
 *
 *      protected void onCreate(Bundle savedInstanceState) {
 *          super.onCreate(savedInstanceState);
 *
 *          mTextureView = new TextureView(this);
 *          mTextureView.setSurfaceTextureListener(this);
 *
 *          setContentView(mTextureView);
 *      }
 *
 *      public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
 *          mCamera = Camera.open();
 *
 *          try {
 *              mCamera.setPreviewTexture(surface);
 *              mCamera.startPreview();
 *          } catch (IOException ioe) {
 *              // Something bad happened
 *          }
 *      }
 *
 *      public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
 *          // Ignored, Camera does all the work for us
 *      }
 *
 *      public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
 *          mCamera.stopPreview();
 *          mCamera.release();
 *          return true;
 *      }
 *
 *      public void onSurfaceTextureUpdated(SurfaceTexture surface) {
 *          // Invoked every time there's a new Camera preview frame
 *      }
 *  }
 * </pre>
 *
 * <p>A TextureView's SurfaceTexture can be obtained either by invoking
 * {@link #getSurfaceTexture()} or by using a {@link android.view.TextureView.SurfaceTextureListener SurfaceTextureListener}.
 * It is important to know that a SurfaceTexture is available only after the
 * TextureView is attached to a window (and {@link #onAttachedToWindow()} has
 * been invoked.) It is therefore highly recommended you use a listener to
 * be notified when the SurfaceTexture becomes available.</p>
 *
 * <p>It is important to note that only one producer can use the TextureView.
 * For instance, if you use a TextureView to display the camera preview, you
 * cannot use {@link #lockCanvas()} to draw onto the TextureView at the same
 * time.</p>
 *
 * @see android.view.SurfaceView
 * @see android.graphics.SurfaceTexture
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextureView extends android.view.View {

/**
 * Creates a new TextureView.
 *
 * @param context The context to associate this view with.
 * @apiSince 14
 */

public TextureView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new TextureView.
 *
 * @param context The context to associate this view with.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @apiSince 14
 */

public TextureView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new TextureView.
 *
 * @param context The context to associate this view with.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @apiSince 14
 */

public TextureView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new TextureView.
 *
 * @param context The context to associate this view with.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *        supplies default values for the view, used only if
 *        defStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 * @apiSince 21
 */

public TextureView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 14
 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the content of this TextureView is opaque. The
 * content is assumed to be opaque by default.
 *
 * @param opaque True if the content of this TextureView is opaque,
 *               false otherwise
 * @apiSince 14
 */

public void setOpaque(boolean opaque) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/**
 * The layer type of a TextureView is ignored since a TextureView is always
 * considered to act as a hardware layer. The optional paint supplied to this
 * method will however be taken into account when rendering the content of
 * this TextureView.
 *
 * @param layerType The type of layer to use with this view, must be one of
 *        {@link #LAYER_TYPE_NONE}, {@link #LAYER_TYPE_SOFTWARE} or
 *        {@link #LAYER_TYPE_HARDWARE}
 * @param paint The paint used to compose the layer. This argument is optional
 *        and can be null. It is ignored when the layer type is
 *        {@link #LAYER_TYPE_NONE}
 
 * This value may be {@code null}.
 * @apiSince 14
 */

public void setLayerType(int layerType, @androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value may be {@code null}.
 * @apiSince 17
 */

public void setLayerPaint(@androidx.annotation.Nullable android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@link #LAYER_TYPE_HARDWARE}.
 * @apiSince 14
 */

public int getLayerType() { throw new RuntimeException("Stub!"); }

/**
 * Calling this method has no effect.
 * @apiSince 14
 */

public void buildLayer() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void setForeground(android.graphics.drawable.Drawable foreground) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void setBackgroundDrawable(android.graphics.drawable.Drawable background) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses of TextureView cannot do their own rendering
 * with the {@link android.graphics.Canvas Canvas} object.
 *
 * @param canvas The Canvas to which the View is rendered.
 * @apiSince 14
 */

public final void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses of TextureView cannot do their own rendering
 * with the {@link android.graphics.Canvas Canvas} object.
 *
 * @param canvas The Canvas to which the View is rendered.
 * @apiSince 14
 */

protected final void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected void onVisibilityChanged(android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the transform to associate with this texture view.
 * The specified transform applies to the underlying surface
 * texture and does not affect the size or position of the view
 * itself, only of its content.</p>
 *
 * <p>Some transforms might prevent the content from drawing
 * all the pixels contained within this view's bounds. In such
 * situations, make sure this texture view is not marked opaque.</p>
 *
 * @param transform The transform to apply to the content of
 *        this view.
 *
 * @see #getTransform(android.graphics.Matrix)
 * @see #isOpaque()
 * @see #setOpaque(boolean)
 * @apiSince 14
 */

public void setTransform(android.graphics.Matrix transform) { throw new RuntimeException("Stub!"); }

/**
 * Returns the transform associated with this texture view.
 *
 * @param transform The {@link android.graphics.Matrix Matrix} in which to copy the current
 *        transform. Can be null.
 *
 * @return The specified matrix if not null or a new {@link android.graphics.Matrix Matrix}
 *         instance otherwise.
 *
 * @see #setTransform(android.graphics.Matrix)
 * @apiSince 14
 */

public android.graphics.Matrix getTransform(android.graphics.Matrix transform) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a {@link android.graphics.Bitmap} representation of the content
 * of the associated surface texture. If the surface texture is not available,
 * this method returns null.</p>
 *
 * <p>The bitmap returned by this method uses the {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888}
 * pixel format and its dimensions are the same as this view's.</p>
 *
 * <p><strong>Do not</strong> invoke this method from a drawing method
 * ({@link #onDraw(android.graphics.Canvas)} for instance).</p>
 *
 * <p>If an error occurs during the copy, an empty bitmap will be returned.</p>
 *
 * @return A valid {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888} bitmap, or null if the surface
 *         texture is not available or the width &lt;= 0 or the height &lt;= 0
 *
 * @see #isAvailable()
 * @see #getBitmap(android.graphics.Bitmap)
 * @see #getBitmap(int, int)
 * @apiSince 14
 */

public android.graphics.Bitmap getBitmap() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a {@link android.graphics.Bitmap} representation of the content
 * of the associated surface texture. If the surface texture is not available,
 * this method returns null.</p>
 *
 * <p>The bitmap returned by this method uses the {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888}
 * pixel format.</p>
 *
 * <p><strong>Do not</strong> invoke this method from a drawing method
 * ({@link #onDraw(android.graphics.Canvas)} for instance).</p>
 *
 * <p>If an error occurs during the copy, an empty bitmap will be returned.</p>
 *
 * @param width The width of the bitmap to create
 * @param height The height of the bitmap to create
 *
 * @return A valid {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888} bitmap, or null if the surface
 *         texture is not available or width is &lt;= 0 or height is &lt;= 0
 *
 * @see #isAvailable()
 * @see #getBitmap(android.graphics.Bitmap)
 * @see #getBitmap()
 * @apiSince 14
 */

public android.graphics.Bitmap getBitmap(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * <p>Copies the content of this view's surface texture into the specified
 * bitmap. If the surface texture is not available, the copy is not executed.
 * The content of the surface texture will be scaled to fit exactly inside
 * the specified bitmap.</p>
 *
 * <p><strong>Do not</strong> invoke this method from a drawing method
 * ({@link #onDraw(android.graphics.Canvas)} for instance).</p>
 *
 * <p>If an error occurs, the bitmap is left unchanged.</p>
 *
 * @param bitmap The bitmap to copy the content of the surface texture into,
 *               cannot be null, all configurations are supported
 *
 * @return The bitmap specified as a parameter
 *
 * @see #isAvailable()
 * @see #getBitmap(int, int)
 * @see #getBitmap()
 *
 * @throws java.lang.IllegalStateException if the hardware rendering context cannot be
 *         acquired to capture the bitmap
 * @apiSince 14
 */

public android.graphics.Bitmap getBitmap(android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the {@link android.graphics.SurfaceTexture SurfaceTexture} associated with this
 * TextureView is available for rendering. When this method returns
 * true, {@link #getSurfaceTexture()} returns a valid surface texture.
 * @apiSince 14
 */

public boolean isAvailable() { throw new RuntimeException("Stub!"); }

/**
 * <p>Start editing the pixels in the surface.  The returned Canvas can be used
 * to draw into the surface's bitmap.  A null is returned if the surface has
 * not been created or otherwise cannot be edited. You will usually need
 * to implement
 * {@link android.view.TextureView.SurfaceTextureListener#onSurfaceTextureAvailable(android.graphics.SurfaceTexture,int,int) SurfaceTextureListener#onSurfaceTextureAvailable(android.graphics.SurfaceTexture, int, int)}
 * to find out when the Surface is available for use.</p>
 *
 * <p>The content of the Surface is never preserved between unlockCanvas()
 * and lockCanvas(), for this reason, every pixel within the Surface area
 * must be written. The only exception to this rule is when a dirty
 * rectangle is specified, in which case, non-dirty pixels will be
 * preserved.</p>
 *
 * <p>This method can only be used if the underlying surface is not already
 * owned by another producer. For instance, if the TextureView is being used
 * to render the camera's preview you cannot invoke this method.</p>
 *
 * @return A Canvas used to draw into the surface.
 *
 * @see #lockCanvas(android.graphics.Rect)
 * @see #unlockCanvasAndPost(android.graphics.Canvas)
 * @apiSince 14
 */

public android.graphics.Canvas lockCanvas() { throw new RuntimeException("Stub!"); }

/**
 * Just like {@link #lockCanvas()} but allows specification of a dirty
 * rectangle. Every pixel within that rectangle must be written; however
 * pixels outside the dirty rectangle will be preserved by the next call
 * to lockCanvas().
 *
 * This method can return null if the underlying surface texture is not
 * available (see {@link #isAvailable()} or if the surface texture is
 * already connected to an image producer (for instance: the camera,
 * OpenGL, a media player, etc.)
 *
 * @param dirty Area of the surface that will be modified.
 
 * @return A Canvas used to draw into the surface.
 *
 * @see #lockCanvas()
 * @see #unlockCanvasAndPost(android.graphics.Canvas)
 * @see #isAvailable()
 * @apiSince 14
 */

public android.graphics.Canvas lockCanvas(android.graphics.Rect dirty) { throw new RuntimeException("Stub!"); }

/**
 * Finish editing pixels in the surface. After this call, the surface's
 * current pixels will be shown on the screen, but its content is lost,
 * in particular there is no guarantee that the content of the Surface
 * will remain unchanged when lockCanvas() is called again.
 *
 * @param canvas The Canvas previously returned by lockCanvas()
 *
 * @see #lockCanvas()
 * @see #lockCanvas(android.graphics.Rect)
 * @apiSince 14
 */

public void unlockCanvasAndPost(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.graphics.SurfaceTexture SurfaceTexture} used by this view. This method
 * may return null if the view is not attached to a window or if the surface
 * texture has not been initialized yet.
 *
 * @see #isAvailable()
 * @apiSince 14
 */

public android.graphics.SurfaceTexture getSurfaceTexture() { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link android.graphics.SurfaceTexture SurfaceTexture} for this view to use. If a {@link android.graphics.SurfaceTexture SurfaceTexture} is already being used by this view, it is immediately
 * released and not usable any more.  The {@link android.view.TextureView.SurfaceTextureListener#onSurfaceTextureDestroyed SurfaceTextureListener#onSurfaceTextureDestroyed} callback is <b>not</b>
 * called for the previous {@link android.graphics.SurfaceTexture SurfaceTexture}.  Similarly, the {@link android.view.TextureView.SurfaceTextureListener#onSurfaceTextureAvailable SurfaceTextureListener#onSurfaceTextureAvailable} callback is <b>not</b>
 * called for the {@link android.graphics.SurfaceTexture SurfaceTexture} passed to setSurfaceTexture.
 *
 * The {@link android.graphics.SurfaceTexture SurfaceTexture} object must be detached from all OpenGL ES
 * contexts prior to calling this method.
 *
 * @param surfaceTexture The {@link android.graphics.SurfaceTexture SurfaceTexture} that the view should use.
 * @see android.graphics.SurfaceTexture#detachFromGLContext()
 * @apiSince 16
 */

public void setSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.view.TextureView.SurfaceTextureListener SurfaceTextureListener} currently associated with this
 * texture view.
 *
 * @see #setSurfaceTextureListener(android.view.TextureView.SurfaceTextureListener)
 * @see android.view.TextureView.SurfaceTextureListener
 * @apiSince 14
 */

public android.view.TextureView.SurfaceTextureListener getSurfaceTextureListener() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.view.TextureView.SurfaceTextureListener SurfaceTextureListener} used to listen to surface
 * texture events.
 *
 * @see #getSurfaceTextureListener()
 * @see android.view.TextureView.SurfaceTextureListener
 * @apiSince 14
 */

public void setSurfaceTextureListener(android.view.TextureView.SurfaceTextureListener listener) { throw new RuntimeException("Stub!"); }
/**
 * This listener can be used to be notified when the surface texture
 * associated with this texture view is available.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface SurfaceTextureListener {

/**
 * Invoked when a {@link android.view.TextureView TextureView}'s SurfaceTexture is ready for use.
 *
 * @param surface The surface returned by
 *                {@link android.view.TextureView#getSurfaceTexture()}
 * @param width The width of the surface
 * @param height The height of the surface
 * @apiSince 14
 */

public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surface, int width, int height);

/**
 * Invoked when the {@link android.graphics.SurfaceTexture SurfaceTexture}'s buffers size changed.
 *
 * @param surface The surface returned by
 *                {@link android.view.TextureView#getSurfaceTexture()}
 * @param width The new width of the surface
 * @param height The new height of the surface
 * @apiSince 14
 */

public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surface, int width, int height);

/**
 * Invoked when the specified {@link android.graphics.SurfaceTexture SurfaceTexture} is about to be destroyed.
 * If returns true, no rendering should happen inside the surface texture after this method
 * is invoked. If returns false, the client needs to call {@link android.graphics.SurfaceTexture#release() SurfaceTexture#release()}.
 * Most applications should return true.
 *
 * @param surface The surface about to be destroyed
 * @apiSince 14
 */

public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surface);

/**
 * Invoked when the specified {@link android.graphics.SurfaceTexture SurfaceTexture} is updated through
 * {@link android.graphics.SurfaceTexture#updateTexImage() SurfaceTexture#updateTexImage()}.
 *
 * @param surface The surface just updated
 * @apiSince 14
 */

public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surface);
}

}

