/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.graphics.PixelFormat;

/**
 * Handle to an on-screen Surface managed by the system compositor. The SurfaceControl is
 * a combination of a buffer source, and metadata about how to display the buffers.
 * By constructing a {@link android.view.Surface Surface} from this SurfaceControl you can submit buffers to be
 * composited. Using {@link android.view.SurfaceControl.Transaction SurfaceControl.Transaction} you can manipulate various
 * properties of how the buffer will be displayed on-screen. SurfaceControl's are
 * arranged into a scene-graph like hierarchy, and as such any SurfaceControl may have
 * a parent. Geometric properties like transform, crop, and Z-ordering will be inherited
 * from the parent, as if the child were content in the parents buffer stream.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SurfaceControl implements android.os.Parcelable {

SurfaceControl() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void readFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Release the local reference to the server-side surface. The surface
 * may continue to exist on-screen as long as its parent continues
 * to exist. To explicitly remove a surface from the screen use
 * {@link android.view.SurfaceControl.Transaction#reparent Transaction#reparent} with a null-parent. After release,
 * {@link #isValid} will return false and other methods will throw
 * an exception.
 *
 * Always call release() when you're done with a SurfaceControl.
 * @apiSince 29
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this instance points to a valid layer with the system-compositor. For
 * example this may be false if construction failed, or the layer was released
 * ({@link #release}).
 *
 * @return Whether this SurfaceControl is valid.
 * @apiSince 29
 */

public boolean isValid() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.SurfaceControl> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link android.view.SurfaceControl SurfaceControl} objects.
 *
 * By default the surface will be hidden, and have "unset" bounds, meaning it can
 * be as large as the bounds of its parent if a buffer or child so requires.
 *
 * It is necessary to set at least a name via {@link android.view.SurfaceControl.Builder#setName Builder#setName}
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Begin building a SurfaceControl.
 * @apiSince 29
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Construct a new {@link android.view.SurfaceControl SurfaceControl} with the set parameters. The builder
 * remains valid.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl build() { throw new RuntimeException("Stub!"); }

/**
 * Set a debugging-name for the SurfaceControl.
 *
 * @param name A name to identify the Surface in debugging.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Builder setName(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Set the initial size of the controlled surface's buffers in pixels.
 *
 * @param width The buffer width in pixels.
 * Value is 0 or greater
 * @param height The buffer height in pixels.
 
 * Value is 0 or greater
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Builder setBufferSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Set the pixel format of the controlled surface's buffers, using constants from
 * {@link android.graphics.PixelFormat}.
 
 * @param format Value is {@link android.graphics.PixelFormat#RGBA_8888}, {@link android.graphics.PixelFormat#RGBX_8888}, {@link android.graphics.PixelFormat#RGBA_F16}, {@link android.graphics.PixelFormat#RGBA_1010102}, {@link android.graphics.PixelFormat#RGB_888}, or {@link android.graphics.PixelFormat#RGB_565}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Builder setFormat(int format) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the surface must be considered opaque,
 * even if its pixel format is set to translucent. This can be useful if an
 * application needs full RGBA 8888 support for instance but will
 * still draw every pixel opaque.
 * <p>
 * This flag only determines whether opacity will be sampled from the alpha channel.
 * Plane-alpha from calls to setAlpha() can still result in blended composition
 * regardless of the opaque setting.
 *
 * Combined effects are (assuming a buffer format with an alpha channel):
 * <ul>
 * <li>OPAQUE + alpha(1.0) == opaque composition
 * <li>OPAQUE + alpha(0.x) == blended composition
 * <li>OPAQUE + alpha(0.0) == no composition
 * <li>!OPAQUE + alpha(1.0) == blended composition
 * <li>!OPAQUE + alpha(0.x) == blended composition
 * <li>!OPAQUE + alpha(0.0) == no composition
 * </ul>
 * If the underlying buffer lacks an alpha channel, it is as if setOpaque(true)
 * were set automatically.
 * @param opaque Whether the Surface is OPAQUE.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Builder setOpaque(boolean opaque) { throw new RuntimeException("Stub!"); }

/**
 * Set a parent surface for our new SurfaceControl.
 *
 * Child surfaces are constrained to the onscreen region of their parent.
 * Furthermore they stack relatively in Z order, and inherit the transformation
 * of the parent.
 *
 * @param parent The parent control.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Builder setParent(@androidx.annotation.Nullable android.view.SurfaceControl parent) { throw new RuntimeException("Stub!"); }
}

/**
 * An atomic set of changes to a set of SurfaceControl.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Transaction implements java.io.Closeable {

/**
 * Open a new transaction object. The transaction may be filed with commands to
 * manipulate {@link android.view.SurfaceControl SurfaceControl} instances, and then applied atomically with
 * {@link #apply}. Eventually the user should invoke {@link #close}, when the object
 * is no longer required. Note however that re-using a transaction after a call to apply
 * is allowed as a convenience.
 * @apiSince 29
 */

public Transaction() { throw new RuntimeException("Stub!"); }

/**
 * Apply the transaction, clearing it's state, and making it usable
 * as a new transaction.
 * @apiSince 29
 */

public void apply() { throw new RuntimeException("Stub!"); }

/**
 * Release the native transaction object, without applying it.
 * @apiSince 29
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Toggle the visibility of a given Layer and it's sub-tree.
 *
 * @param sc The SurfaceControl for which to set the visibility
 * This value must never be {@code null}.
 * @param visible The new visibility
 * @return This transaction object.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Transaction setVisibility(@androidx.annotation.NonNull android.view.SurfaceControl sc, boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * Set the default buffer size for the SurfaceControl, if there is a
 * {@link android.view.Surface Surface} associated with the control, then
 * this will be the default size for buffers dequeued from it.
 * @param sc The surface to set the buffer size for.
 * This value must never be {@code null}.
 * @param w The default width
 * Value is 0 or greater
 * @param h The default height
 * Value is 0 or greater
 * @return This Transaction
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Transaction setBufferSize(@androidx.annotation.NonNull android.view.SurfaceControl sc, int w, int h) { throw new RuntimeException("Stub!"); }

/**
 * Set the Z-order for a given SurfaceControl, relative to it's siblings.
 * If two siblings share the same Z order the ordering is undefined. Surfaces
 * with a negative Z will be placed below the parent surface.
 *
 * @param sc The SurfaceControl to set the Z order on
 * This value must never be {@code null}.
 * @param z The Z-order
 * Value is between Integer.MIN_VALUE and Integer.MAX_VALUE inclusive
 * @return This Transaction.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Transaction setLayer(@androidx.annotation.NonNull android.view.SurfaceControl sc, int z) { throw new RuntimeException("Stub!"); }

/**
 * Set the alpha for a given surface. If the alpha is non-zero the SurfaceControl
 * will be blended with the Surfaces under it according to the specified ratio.
 *
 * @param sc The given SurfaceControl.
 * This value must never be {@code null}.
 * @param alpha The alpha to set.
 
 * Value is between 0.0 and 1.0 inclusive
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Transaction setAlpha(@androidx.annotation.NonNull android.view.SurfaceControl sc, float alpha) { throw new RuntimeException("Stub!"); }

/**
 * Specify how the buffer assosciated with this Surface is mapped in to the
 * parent coordinate space. The source frame will be scaled to fit the destination
 * frame, after being rotated according to the orientation parameter.
 *
 * @param sc The SurfaceControl to specify the geometry of
 * This value must never be {@code null}.
 * @param sourceCrop The source rectangle in buffer space. Or null for the entire buffer.
 * This value may be {@code null}.
 * @param destFrame The destination rectangle in parent space. Or null for the source frame.
 * This value may be {@code null}.
 * @param orientation The buffer rotation
 * Value is {@link android.view.Surface#ROTATION_0}, {@link android.view.Surface#ROTATION_90}, {@link android.view.Surface#ROTATION_180}, or {@link android.view.Surface#ROTATION_270}
 * @return This transaction object.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Transaction setGeometry(@androidx.annotation.NonNull android.view.SurfaceControl sc, @androidx.annotation.Nullable android.graphics.Rect sourceCrop, @androidx.annotation.Nullable android.graphics.Rect destFrame, int orientation) { throw new RuntimeException("Stub!"); }

/**
 * Re-parents a given layer to a new parent. Children inherit transform (position, scaling)
 * crop, visibility, and Z-ordering from their parents, as if the children were pixels within the
 * parent Surface.
 *
 * @param sc The SurfaceControl to reparent
 * This value must never be {@code null}.
 * @param newParent The new parent for the given control.
 * This value may be {@code null}.
 * @return This Transaction
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Transaction reparent(@androidx.annotation.NonNull android.view.SurfaceControl sc, @androidx.annotation.Nullable android.view.SurfaceControl newParent) { throw new RuntimeException("Stub!"); }

/**
 * Merge the other transaction into this transaction, clearing the
 * other transaction as if it had been applied.
 *
 * @param other The transaction to merge in to this one.
 * This value must never be {@code null}.
 * @return This transaction.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.SurfaceControl.Transaction merge(@androidx.annotation.NonNull android.view.SurfaceControl.Transaction other) { throw new RuntimeException("Stub!"); }
}

}

