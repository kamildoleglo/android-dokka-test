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


package android.media.projection;

import android.hardware.display.VirtualDisplay;
import android.hardware.display.DisplayManager;
import android.os.Handler;

/**
 * A token granting applications the ability to capture screen contents and/or
 * record system audio. The exact capabilities granted depend on the type of
 * MediaProjection.
 *
 * <p>
 * A screen capture session can be started through {@link android.media.projection.MediaProjectionManager#createScreenCaptureIntent MediaProjectionManager#createScreenCaptureIntent}. This grants the ability to
 * capture screen contents, but not system audio.
 * </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaProjection {

MediaProjection() { throw new RuntimeException("Stub!"); }

/** Register a listener to receive notifications about when the {@link android.media.projection.MediaProjection MediaProjection} changes state.
 *
 * @param callback The callback to call.
 * @param handler The handler on which the callback should be invoked, or
 * null if the callback should be invoked on the calling thread's looper.
 *
 * @see #unregisterCallback
 * @apiSince 21
 */

public void registerCallback(android.media.projection.MediaProjection.Callback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/** Unregister a MediaProjection listener.
 *
 * @param callback The callback to unregister.
 *
 * @see #registerCallback
 @apiSince 21
 */

public void unregisterCallback(android.media.projection.MediaProjection.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.hardware.display.VirtualDisplay} to capture the
 * contents of the screen.
 *
 * @param name The name of the virtual display, must be non-empty.
 * This value must never be {@code null}.
 * @param width The width of the virtual display in pixels. Must be
 * greater than 0.
 * @param height The height of the virtual display in pixels. Must be
 * greater than 0.
 * @param dpi The density of the virtual display in dpi. Must be greater
 * than 0.
 * @param surface The surface to which the content of the virtual display
 * should be rendered, or null if there is none initially.
 * This value may be {@code null}.
 * @param flags A combination of virtual display flags. See {@link android.hardware.display.DisplayManager DisplayManager} for the full
 * list of flags.
 * @param callback Callback to call when the virtual display's state
 * changes, or null if none.
 * This value may be {@code null}.
 * @param handler The {@link android.os.Handler} on which the callback should be
 * invoked, or null if the callback should be invoked on the calling
 * thread's main {@link android.os.Looper}.
 *
 * This value may be {@code null}.
 * @see android.hardware.display.VirtualDisplay
 * @apiSince 21
 */

public android.hardware.display.VirtualDisplay createVirtualDisplay(@androidx.annotation.NonNull java.lang.String name, int width, int height, int dpi, int flags, @androidx.annotation.Nullable android.view.Surface surface, @androidx.annotation.Nullable android.hardware.display.VirtualDisplay.Callback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Stops projection.
 * @apiSince 21
 */

public void stop() { throw new RuntimeException("Stub!"); }
/**
 * Callbacks for the projection session.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the MediaProjection session is no longer valid.
 * <p>
 * Once a MediaProjection has been stopped, it's up to the application to release any
 * resources it may be holding (e.g. {@link android.hardware.display.VirtualDisplay}s).
 * </p>
 * @apiSince 21
 */

public void onStop() { throw new RuntimeException("Stub!"); }
}

}

