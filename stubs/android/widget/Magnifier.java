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


package android.widget;

import android.graphics.drawable.Drawable;
import android.view.SurfaceView;
import android.graphics.Rect;
import android.view.View;
import android.graphics.drawable.ColorDrawable;
import android.view.Surface;

/**
 * Android magnifier widget. Can be used by any view which is attached to a window.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Magnifier {

/**
 * Initializes a magnifier.
 *
 * @param view the view for which this magnifier is attached
 *
 * This value must never be {@code null}.
 * @deprecated Please use {@link android.widget.Magnifier.Builder Builder} instead
 * @apiSince 28
 */

@Deprecated
public Magnifier(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Shows the magnifier on the screen. The method takes the coordinates of the center
 * of the content source going to be magnified and copied to the magnifier. The coordinates
 * are relative to the top left corner of the magnified view. The magnifier will be
 * positioned such that its center will be at the default offset from the center of the source.
 * The default offset can be specified using the method
 * {@link android.widget.Magnifier.Builder#setDefaultSourceToMagnifierOffset(int,int) Builder#setDefaultSourceToMagnifierOffset(int, int)}. If the offset should
 * be different across calls to this method, you should consider to use method
 * {@link #show(float,float,float,float)} instead.
 *
 * @param sourceCenterX horizontal coordinate of the source center, relative to the view
 * Value is 0 or greater
 * @param sourceCenterY vertical coordinate of the source center, relative to the view
 *
 * Value is 0 or greater
 * @see android.widget.Magnifier.Builder#setDefaultSourceToMagnifierOffset(int, int)
 * @see android.widget.Magnifier.Builder#getDefaultHorizontalSourceToMagnifierOffset()
 * @see android.widget.Magnifier.Builder#getDefaultVerticalSourceToMagnifierOffset()
 * @see #show(float, float, float, float)
 * @apiSince 28
 */

public void show(float sourceCenterX, float sourceCenterY) { throw new RuntimeException("Stub!"); }

/**
 * Shows the magnifier on the screen at a position that is independent from its content
 * position. The first two arguments represent the coordinates of the center of the
 * content source going to be magnified and copied to the magnifier. The last two arguments
 * represent the coordinates of the center of the magnifier itself. All four coordinates
 * are relative to the top left corner of the magnified view. If you consider using this
 * method such that the offset between the source center and the magnifier center coordinates
 * remains constant, you should consider using method {@link #show(float,float)} instead.
 *
 * @param sourceCenterX horizontal coordinate of the source center relative to the view
 * Value is 0 or greater
 * @param sourceCenterY vertical coordinate of the source center, relative to the view
 * Value is 0 or greater
 * @param magnifierCenterX horizontal coordinate of the magnifier center, relative to the view
 * @param magnifierCenterY vertical coordinate of the magnifier center, relative to the view
 * @apiSince 29
 */

public void show(float sourceCenterX, float sourceCenterY, float magnifierCenterX, float magnifierCenterY) { throw new RuntimeException("Stub!"); }

/**
 * Dismisses the magnifier from the screen. Calling this on a dismissed magnifier is a no-op.
 * @apiSince 28
 */

public void dismiss() { throw new RuntimeException("Stub!"); }

/**
 * Asks the magnifier to update its content. It uses the previous coordinates passed to
 * {@link #show(float,float)} or {@link #show(float,float,float,float)}. The
 * method only has effect if the magnifier is currently showing.
 * @apiSince 28
 */

public void update() { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * This units of this value are pixels.
 * @return the width of the magnifier window, in pixels
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setSize(int, int)
 * @apiSince 28
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * This units of this value are pixels.
 * @return the height of the magnifier window, in pixels
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setSize(int, int)
 * @apiSince 28
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * This units of this value are pixels.
 * @return the initial width of the content magnified and copied to the magnifier, in pixels
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setSize(int, int)
 * @see android.widget.Magnifier.Builder#setInitialZoom(float)
 * @apiSince 29
 */

public int getSourceWidth() { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * This units of this value are pixels.
 * @return the initial height of the content magnified and copied to the magnifier, in pixels
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setSize(int, int)
 * @see android.widget.Magnifier.Builder#setInitialZoom(float)
 * @apiSince 29
 */

public int getSourceHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the zoom to be applied to the chosen content before being copied to the magnifier popup.
 * The change will become effective at the next #show or #update call.
 * @param zoom the zoom to be set
 
 * Value is 0f or greater
 * @apiSince 29
 */

public void setZoom(float zoom) { throw new RuntimeException("Stub!"); }

/**
 * Returns the zoom to be applied to the magnified view region copied to the magnifier.
 * If the zoom is x and the magnifier window size is (width, height), the original size
 * of the content being magnified will be (width / x, height / x).
 * @return the zoom applied to the content
 * @see android.widget.Magnifier.Builder#setInitialZoom(float)
 * @apiSince 28
 */

public float getZoom() { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * This units of this value are pixels.
 * @return the elevation set for the magnifier window, in pixels
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setElevation(float)
 * @apiSince 29
 */

public float getElevation() { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * This units of this value are pixels.
 * @return the corner radius of the magnifier window, in pixels
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setCornerRadius(float)
 * @apiSince 29
 */

public float getCornerRadius() { throw new RuntimeException("Stub!"); }

/**
 * Returns the horizontal offset, in pixels, to be applied to the source center position
 * to obtain the magnifier center position when {@link #show(float,float)} is called.
 * The value is ignored when {@link #show(float,float,float,float)} is used instead.
 *
 * <br>
 * This units of this value are pixels.
 * @return the default horizontal offset between the source center and the magnifier
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setDefaultSourceToMagnifierOffset(int, int)
 * @see android.widget.Magnifier#show(float, float)
 * @apiSince 29
 */

public int getDefaultHorizontalSourceToMagnifierOffset() { throw new RuntimeException("Stub!"); }

/**
 * Returns the vertical offset, in pixels, to be applied to the source center position
 * to obtain the magnifier center position when {@link #show(float,float)} is called.
 * The value is ignored when {@link #show(float,float,float,float)} is used instead.
 *
 * <br>
 * This units of this value are pixels.
 * @return the default vertical offset between the source center and the magnifier
 * This units of this value are pixels.
 * {}
 * @see android.widget.Magnifier.Builder#setDefaultSourceToMagnifierOffset(int, int)
 * @see android.widget.Magnifier#show(float, float)
 * @apiSince 29
 */

public int getDefaultVerticalSourceToMagnifierOffset() { throw new RuntimeException("Stub!"); }

/**
 * Returns the overlay to be drawn on the top of the magnifier, or
 * {@code null} if no overlay should be drawn.
 * @return the overlay
 * @see android.widget.Magnifier.Builder#setOverlay(Drawable)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getOverlay() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the magnifier position will be adjusted such that the magnifier will be
 * fully within the bounds of the main application window, by also avoiding any overlap
 * with system insets (such as the one corresponding to the status bar) i.e. whether the
 * area where the magnifier can be positioned will be clipped to the main application window
 * and the system insets.
 * @return whether the magnifier position will be adjusted
 * @see android.widget.Magnifier.Builder#setClippingEnabled(boolean)
 * @apiSince 29
 */

public boolean isClippingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top left coordinates of the magnifier, relative to the main application
 * window. They will be determined by the coordinates of the last {@link #show(float,float)}
 * or {@link #show(float,float,float,float)} call, adjusted to take into account any
 * potential clamping behavior. The method can be used immediately after a #show
 * call to find out where the magnifier will be positioned. However, the position of the
 * magnifier will not be updated visually in the same frame, due to the async nature of
 * the content copying and of the magnifier rendering.
 * The method will return {@code null} if #show has not yet been called, or if the last
 * operation performed was a #dismiss.
 *
 * @return the top left coordinates of the magnifier
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.Point getPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top left coordinates of the magnifier source (i.e. the view region going to
 * be magnified and copied to the magnifier), relative to the window or surface the content
 * is copied from. The content will be copied:
 * - if the magnified view is a {@link android.view.SurfaceView SurfaceView}, from the surface backing it
 * - otherwise, from the surface backing the main application window, and the coordinates
 *   returned will be relative to the main application window
 * The method will return {@code null} if #show has not yet been called, or if the last
 * operation performed was a #dismiss.
 *
 * @return the top left coordinates of the magnifier source
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.Point getSourcePosition() { throw new RuntimeException("Stub!"); }

/**
 * A source bound that will extend as much as possible, while remaining within the surface
 * the content is copied from.
 * @apiSince 29
 */

public static final int SOURCE_BOUND_MAX_IN_SURFACE = 0; // 0x0

/**
 * A source bound that will extend as much as possible, while remaining within the
 * visible region of the magnified view, as determined by
 * {@link android.view.View#getGlobalVisibleRect(android.graphics.Rect) View#getGlobalVisibleRect(Rect)}.
 * @apiSince 29
 */

public static final int SOURCE_BOUND_MAX_VISIBLE = 1; // 0x1
/**
 * Builder class for {@link android.widget.Magnifier Magnifier} objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Construct a new builder for {@link android.widget.Magnifier Magnifier} objects.
 * @param view the view this magnifier is attached to
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Sets the size of the magnifier window, in pixels. Defaults to (100dp, 48dp).
 * Note that the size of the content being magnified and copied to the magnifier
 * will be computed as (window width / zoom, window height / zoom).
 * @param width the window width to be set
 * This units of this value are pixels.
 * Value is 0 or greater
 * @param height the window height to be set
 
 * This units of this value are pixels.
 * Value is 0 or greater
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Sets the zoom to be applied to the chosen content before being copied to the magnifier.
 * A content of size (content_width, content_height) will be magnified to
 * (content_width * zoom, content_height * zoom), which will coincide with the size
 * of the magnifier. A zoom of 1 will translate to no magnification (the content will
 * be just copied to the magnifier with no scaling). The zoom defaults to 1.25.
 * Note that the zoom can also be changed after the instance is built, using the
 * {@link android.widget.Magnifier#setZoom(float) Magnifier#setZoom(float)} method.
 * @param zoom the zoom to be set
 
 * Value is 0f or greater
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setInitialZoom(float zoom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the elevation of the magnifier window, in pixels. Defaults to 4dp.
 * @param elevation the elevation to be set
 
 * This units of this value are pixels.
 * Value is 0 or greater
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setElevation(float elevation) { throw new RuntimeException("Stub!"); }

/**
 * Sets the corner radius of the magnifier window, in pixels. Defaults to 2dp.
 * @param cornerRadius the corner radius to be set
 
 * This units of this value are pixels.
 * Value is 0 or greater
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setCornerRadius(float cornerRadius) { throw new RuntimeException("Stub!"); }

/**
 * Sets an overlay that will be drawn on the top of the magnifier.
 * In general, the overlay should not be opaque, in order to let the magnified
 * content be partially visible in the magnifier. The default overlay is {@code null}
 * (no overlay). As an example, TextView applies a white {@link android.graphics.drawable.ColorDrawable ColorDrawable}
 * overlay with 5% alpha, aiming to make the magnifier distinguishable when shown in dark
 * application regions. To disable the overlay, the parameter should be set
 * to {@code null}. If not null, the overlay will be automatically redrawn
 * when the drawable is invalidated. To achieve this, the magnifier will set a new
 * {@link android.graphics.drawable.Drawable.Callback} for the overlay drawable,
 * so keep in mind that any existing one set by the application will be lost.
 * @param overlay the overlay to be drawn on top
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setOverlay(@androidx.annotation.Nullable android.graphics.drawable.Drawable overlay) { throw new RuntimeException("Stub!"); }

/**
 * Sets an offset that should be added to the content source center to obtain
 * the position of the magnifier window, when the {@link #show(float,float)}
 * method is called. The offset is ignored when {@link #show(float,float,float,float)}
 * is used. The offset can be negative. It defaults to (0dp, 0dp).
 * @param horizontalOffset the horizontal component of the offset
 * This units of this value are pixels.
 * @param verticalOffset the vertical component of the offset
 
 * This units of this value are pixels.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setDefaultSourceToMagnifierOffset(int horizontalOffset, int verticalOffset) { throw new RuntimeException("Stub!"); }

/**
 * Defines the behavior of the magnifier when it is requested to position outside the
 * surface of the main application window. The default value is {@code true}, which means
 * that the position will be adjusted such that the magnifier will be fully within the
 * bounds of the main application window, while also avoiding any overlap with system insets
 * (such as the one corresponding to the status bar). If this flag is set to {@code false},
 * the area where the magnifier can be positioned will no longer be clipped, so the
 * magnifier will be able to extend outside the main application window boundaries (and also
 * overlap the system insets). This can be useful if you require a custom behavior, but it
 * should be handled with care, when passing coordinates to {@link #show(float,float)};
 * note that:
 * <ul>
 *   <li>in a multiwindow context, if the magnifier crosses the boundary between the two
 *   windows, it will not be able to show over the window of the other application</li>
 *   <li>if the magnifier overlaps the status bar, there is no guarantee about which one
 *   will be displayed on top. This should be handled with care.</li>
 * </ul>
 * @param clip whether the magnifier position will be adjusted
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setClippingEnabled(boolean clip) { throw new RuntimeException("Stub!"); }

/**
 * Defines the bounds of the rectangle where the magnifier will be able to copy its content
 * from. The content will always be copied from the {@link android.view.Surface Surface} of the main application
 * window unless the magnified view is a {@link android.view.SurfaceView SurfaceView}, in which case its backing
 * surface will be used. Each bound can have a different behavior, with the options being:
 * <ul>
 *   <li>{@link #SOURCE_BOUND_MAX_VISIBLE}, which extends the bound as much as possible
 *   while remaining in the visible region of the magnified view, as given by
 *   {@link android.view.View#getGlobalVisibleRect(Rect)}. For example, this will take into
 *   account the case when the view is contained in a scrollable container, and the
 *   magnifier will refuse to copy content outside of the visible view region</li>
 *   <li>{@link #SOURCE_BOUND_MAX_IN_SURFACE}, which extends the bound as much
 *   as possible while remaining inside the surface the content is copied from.</li>
 * </ul>
 * Note that if either of the first three options is used, the bound will be compared to
 * the bound of the surface (i.e. as if {@link #SOURCE_BOUND_MAX_IN_SURFACE} was used),
 * and the more restrictive one will be chosen. In other words, no attempt to copy content
 * from outside the surface will be permitted. If two opposite bounds are not well-behaved
 * (i.e. left + sourceWidth > right or top + sourceHeight > bottom), the left and top
 * bounds will have priority and the others will be extended accordingly. If the pairs
 * obtained this way still remain out of bounds, the smallest possible offset will be added
 * to the pairs to bring them inside the surface bounds. If this is impossible
 * (i.e. the surface is too small for the size of the content we try to copy on either
 * dimension), an error will be logged and the magnifier content will look distorted.
 * The default values assumed by the builder for the source bounds are
 * left: {@link #SOURCE_BOUND_MAX_VISIBLE}, top: {@link #SOURCE_BOUND_MAX_IN_SURFACE},
 * right: {@link #SOURCE_BOUND_MAX_VISIBLE}, bottom: {@link #SOURCE_BOUND_MAX_IN_SURFACE}.
 * @param left the left bound for content copy
 * Value is {@link android.widget.Magnifier#SOURCE_BOUND_MAX_IN_SURFACE}, or {@link android.widget.Magnifier#SOURCE_BOUND_MAX_VISIBLE}
 * @param top the top bound for content copy
 * Value is {@link android.widget.Magnifier#SOURCE_BOUND_MAX_IN_SURFACE}, or {@link android.widget.Magnifier#SOURCE_BOUND_MAX_VISIBLE}
 * @param right the right bound for content copy
 * Value is {@link android.widget.Magnifier#SOURCE_BOUND_MAX_IN_SURFACE}, or {@link android.widget.Magnifier#SOURCE_BOUND_MAX_VISIBLE}
 * @param bottom the bottom bound for content copy
 
 * Value is {@link android.widget.Magnifier#SOURCE_BOUND_MAX_IN_SURFACE}, or {@link android.widget.Magnifier#SOURCE_BOUND_MAX_VISIBLE}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier.Builder setSourceBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Builds a {@link android.widget.Magnifier Magnifier} instance based on the configuration of this {@link android.widget.Magnifier.Builder Builder}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.widget.Magnifier build() { throw new RuntimeException("Stub!"); }
}

}

