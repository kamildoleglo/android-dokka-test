/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.graphics.drawable.Drawable;

/**
 * Defines a simple shape, used for bounding graphical regions.
 * <p>
 * Can be computed for a View, or computed by a Drawable, to drive the shape of
 * shadows cast by a View, or to clip the contents of the View.
 *
 * @see android.view.ViewOutlineProvider
 * @see android.view.View#setOutlineProvider(android.view.ViewOutlineProvider)
 * @see android.graphics.drawable.Drawable#getOutline(Outline)
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Outline {

/**
 * Constructs an empty Outline. Call one of the setter methods to make
 * the outline valid for use with a View.
 * @apiSince 21
 */

public Outline() { throw new RuntimeException("Stub!"); }

/**
 * Constructs an Outline with a copy of the data in src.
 
 * @param src This value must never be {@code null}.
 * @apiSince 21
 */

public Outline(@androidx.annotation.NonNull android.graphics.Outline src) { throw new RuntimeException("Stub!"); }

/**
 * Sets the outline to be empty.
 *
 * @see #isEmpty()
 * @apiSince 21
 */

public void setEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the Outline is empty.
 * <p>
 * Outlines are empty when constructed, or if {@link #setEmpty()} is called,
 * until a setter method is called
 *
 * @see #setEmpty()
 * @apiSince 21
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the outline can be used to clip a View.
 * <p>
 * Currently, only Outlines that can be represented as a rectangle, circle,
 * or round rect support clipping.
 *
 * @see android.view.View#setClipToOutline(boolean)
 * @apiSince 21
 */

public boolean canClip() { throw new RuntimeException("Stub!"); }

/**
 * Sets the alpha represented by the Outline - the degree to which the
 * producer is guaranteed to be opaque over the Outline's shape.
 * <p>
 * An alpha value of <code>0.0f</code> either represents completely
 * transparent content, or content that isn't guaranteed to fill the shape
 * it publishes.
 * <p>
 * Content producing a fully opaque (alpha = <code>1.0f</code>) outline is
 * assumed by the drawing system to fully cover content beneath it,
 * meaning content beneath may be optimized away.
 
 * @param alpha Value is between 0.0 and 1.0 inclusive
 * @apiSince 21
 */

public void setAlpha(float alpha) { throw new RuntimeException("Stub!"); }

/**
 * Returns the alpha represented by the Outline.
 * @apiSince 21
 */

public float getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Replace the contents of this Outline with the contents of src.
 *
 * @param src Source outline to copy from.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void set(@androidx.annotation.NonNull android.graphics.Outline src) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Outline to the rounded rect defined by the input rect, and
 * corner radius.
 * @apiSince 21
 */

public void setRect(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link #setRect(int,int,int,int)}
 
 * @param rect This value must never be {@code null}.
 * @apiSince 21
 */

public void setRect(@androidx.annotation.NonNull android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Outline to the rounded rect defined by the input rect, and corner radius.
 * <p>
 * Passing a zero radius is equivalent to calling {@link #setRect(int,int,int,int)}
 * @apiSince 21
 */

public void setRoundRect(int left, int top, int right, int bottom, float radius) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link #setRoundRect(int,int,int,int,float)}
 
 * @param rect This value must never be {@code null}.
 * @apiSince 21
 */

public void setRoundRect(@androidx.annotation.NonNull android.graphics.Rect rect, float radius) { throw new RuntimeException("Stub!"); }

/**
 * Populates {@code outBounds} with the outline bounds, if set, and returns
 * {@code true}. If no outline bounds are set, or if a path has been set
 * via {@link #setConvexPath(android.graphics.Path)}, returns {@code false}.
 *
 * @param outRect the rect to populate with the outline bounds, if set
 * This value must never be {@code null}.
 * @return {@code true} if {@code outBounds} was populated with outline
 *         bounds, or {@code false} if no outline bounds are set
 * @apiSince 24
 */

public boolean getRect(@androidx.annotation.NonNull android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Returns the rounded rect radius, if set, or a value less than 0 if a path has
 * been set via {@link #setConvexPath(android.graphics.Path)}. A return value of {@code 0}
 * indicates a non-rounded rect.
 *
 * @return the rounded rect radius, or value < 0
 * @apiSince 24
 */

public float getRadius() { throw new RuntimeException("Stub!"); }

/**
 * Sets the outline to the oval defined by input rect.
 * @apiSince 21
 */

public void setOval(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link #setOval(int,int,int,int)}
 
 * @param rect This value must never be {@code null}.
 * @apiSince 21
 */

public void setOval(@androidx.annotation.NonNull android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Outline to a
 * {@link android.graphics.Path#isConvex() convex path}.
 *
 * @param convexPath used to construct the Outline. As of
 * {@link android.os.Build.VERSION_CODES#Q}, it is no longer required to be
 * convex.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void setConvexPath(@androidx.annotation.NonNull android.graphics.Path convexPath) { throw new RuntimeException("Stub!"); }

/**
 * Offsets the Outline by (dx,dy)
 * @apiSince 22
 */

public void offset(int dx, int dy) { throw new RuntimeException("Stub!"); }
}

