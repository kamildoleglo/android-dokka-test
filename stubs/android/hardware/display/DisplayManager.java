/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.hardware.display;

import android.os.Handler;
import android.view.Surface;
import android.view.Display;
import android.media.projection.MediaProjection;

/**
 * Manages the properties of attached displays.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DisplayManager {

DisplayManager() { throw new RuntimeException("Stub!"); }

/**
 * Gets information about a logical display.
 *
 * The display metrics may be adjusted to provide compatibility
 * for legacy applications.
 *
 * @param displayId The logical display id.
 * @return The display object, or null if there is no valid display with the given id.
 * @apiSince 17
 */

public android.view.Display getDisplay(int displayId) { throw new RuntimeException("Stub!"); }

/**
 * Gets all currently valid logical displays.
 *
 * @return An array containing all displays.
 * @apiSince 17
 */

public android.view.Display[] getDisplays() { throw new RuntimeException("Stub!"); }

/**
 * Gets all currently valid logical displays of the specified category.
 * <p>
 * When there are multiple displays in a category the returned displays are sorted
 * of preference.  For example, if the requested category is
 * {@link #DISPLAY_CATEGORY_PRESENTATION} and there are multiple presentation displays
 * then the displays are sorted so that the first display in the returned array
 * is the most preferred presentation display.  The application may simply
 * use the first display or allow the user to choose.
 * </p>
 *
 * @param category The requested display category or null to return all displays.
 * @return An array containing all displays sorted by order of preference.
 *
 * @see #DISPLAY_CATEGORY_PRESENTATION
 * @apiSince 17
 */

public android.view.Display[] getDisplays(java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Registers an display listener to receive notifications about when
 * displays are added, removed or changed.
 *
 * @param listener The listener to register.
 * @param handler The handler on which the listener should be invoked, or null
 * if the listener should be invoked on the calling thread's looper.
 *
 * @see #unregisterDisplayListener
 * @apiSince 17
 */

public void registerDisplayListener(android.hardware.display.DisplayManager.DisplayListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a display listener.
 *
 * @param listener The listener to unregister.
 *
 * @see #registerDisplayListener
 * @apiSince 17
 */

public void unregisterDisplayListener(android.hardware.display.DisplayManager.DisplayListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Creates a virtual display.
 *
 * @see #createVirtualDisplay(String, int, int, int, Surface, int,
 * VirtualDisplay.Callback, Handler)
 
 * @param name This value must never be {@code null}.
 
 * @param surface This value may be {@code null}.
 * @apiSince 19
 */

public android.hardware.display.VirtualDisplay createVirtualDisplay(@androidx.annotation.NonNull java.lang.String name, int width, int height, int densityDpi, @androidx.annotation.Nullable android.view.Surface surface, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Creates a virtual display.
 * <p>
 * The content of a virtual display is rendered to a {@link android.view.Surface Surface} provided
 * by the application.
 * </p><p>
 * The virtual display should be {@link android.hardware.display.VirtualDisplay#release VirtualDisplay#release}
 * when no longer needed.  Because a virtual display renders to a surface
 * provided by the application, it will be released automatically when the
 * process terminates and all remaining windows on it will be forcibly removed.
 * </p><p>
 * The behavior of the virtual display depends on the flags that are provided
 * to this method.  By default, virtual displays are created to be private,
 * non-presentation and unsecure.  Permissions may be required to use certain flags.
 * </p><p>
 * As of {@link android.os.Build.VERSION_CODES#KITKAT_WATCH}, the surface may
 * be attached or detached dynamically using {@link android.hardware.display.VirtualDisplay#setSurface VirtualDisplay#setSurface}.
 * Previously, the surface had to be non-null when {@link #createVirtualDisplay}
 * was called and could not be changed for the lifetime of the display.
 * </p><p>
 * Detaching the surface that backs a virtual display has a similar effect to
 * turning off the screen.
 * </p>
 *
 * @param name The name of the virtual display, must be non-empty.
 * This value must never be {@code null}.
 * @param width The width of the virtual display in pixels, must be greater than 0.
 * @param height The height of the virtual display in pixels, must be greater than 0.
 * @param densityDpi The density of the virtual display in dpi, must be greater than 0.
 * @param surface The surface to which the content of the virtual display should
 * be rendered, or null if there is none initially.
 * This value may be {@code null}.
 * @param flags A combination of virtual display flags:
 * {@link #VIRTUAL_DISPLAY_FLAG_PUBLIC}, {@link #VIRTUAL_DISPLAY_FLAG_PRESENTATION},
 * {@link #VIRTUAL_DISPLAY_FLAG_SECURE}, {@link #VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY},
 * or {@link #VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR}.
 * @param callback Callback to call when the state of the {@link android.hardware.display.VirtualDisplay VirtualDisplay} changes
 * This value may be {@code null}.
 * @param handler The handler on which the listener should be invoked, or null
 * if the listener should be invoked on the calling thread's looper.
 * This value may be {@code null}.
 * @return The newly created virtual display, or null if the application could
 * not create the virtual display.
 *
 * @throws java.lang.SecurityException if the caller does not have permission to create
 * a virtual display with the specified flags.
 * @apiSince 21
 */

public android.hardware.display.VirtualDisplay createVirtualDisplay(@androidx.annotation.NonNull java.lang.String name, int width, int height, int densityDpi, @androidx.annotation.Nullable android.view.Surface surface, int flags, @androidx.annotation.Nullable android.hardware.display.VirtualDisplay.Callback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Display category: Presentation displays.
 * <p>
 * This category can be used to identify secondary displays that are suitable for
 * use as presentation displays such as HDMI or Wireless displays.  Applications
 * may automatically project their content to presentation displays to provide
 * richer second screen experiences.
 * </p>
 *
 * @see android.app.Presentation
 * @see android.view.Display#FLAG_PRESENTATION
 * @see #getDisplays(String)
 * @apiSince 17
 */

public static final java.lang.String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";

/**
 * Virtual display flag: Allows content to be mirrored on private displays when no content is
 * being shown.
 *
 * <p>
 * This flag is mutually exclusive with {@link #VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY}.
 * If both flags are specified then the own-content only behavior will be applied.
 * </p>
 *
 * <p>
 * The behavior of this flag is implied whenever {@link #VIRTUAL_DISPLAY_FLAG_PUBLIC} is set
 * and {@link #VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY} has not been set.   This flag is only
 * required to override the default behavior when creating a private display.
 * </p>
 *
 * <p>
 * Creating an auto-mirroing virtual display requires the CAPTURE_VIDEO_OUTPUT
 * or CAPTURE_SECURE_VIDEO_OUTPUT permission.
 * These permissions are reserved for use by system components and are not available to
 * third-party applications.
 *
 * Alternatively, an appropriate {@link android.media.projection.MediaProjection MediaProjection} may be used to create an
 * auto-mirroring virtual display.
 * </p>
 *
 * @see #createVirtualDisplay
 * @apiSince 21
 */

public static final int VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR = 16; // 0x10

/**
 * Virtual display flag: Only show this display's own content; do not mirror
 * the content of another display.
 *
 * <p>
 * This flag is used in conjunction with {@link #VIRTUAL_DISPLAY_FLAG_PUBLIC}.
 * Ordinarily public virtual displays will automatically mirror the content of the
 * default display if they have no windows of their own.  When this flag is
 * specified, the virtual display will only ever show its own content and
 * will be blanked instead if it has no windows.
 * </p>
 *
 * <p>
 * This flag is mutually exclusive with {@link #VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR}.  If both
 * flags are specified then the own-content only behavior will be applied.
 * </p>
 *
 * <p>
 * This behavior of this flag is implied whenever neither {@link #VIRTUAL_DISPLAY_FLAG_PUBLIC}
 * nor {@link #VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR} have been set.  This flag is only required to
 * override the default behavior when creating a public display.
 * </p>
 *
 * @see #createVirtualDisplay
 * @apiSince 20
 */

public static final int VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY = 8; // 0x8

/**
 * Virtual display flag: Create a presentation display.
 *
 * <h3>Presentation virtual displays</h3>
 * <p>
 * When this flag is set, the virtual display is registered as a presentation
 * display in the {@link #DISPLAY_CATEGORY_PRESENTATION presentation display category}.
 * Applications may automatically project their content to presentation displays
 * to provide richer second screen experiences.
 * </p>
 *
 * <h3>Non-presentation virtual displays</h3>
 * <p>
 * When this flag is not set, the virtual display is not registered as a presentation
 * display.  Applications can still project their content on the display but they
 * will typically not do so automatically.  This option is appropriate for
 * more special-purpose displays.
 * </p>
 *
 * @see android.app.Presentation
 * @see #createVirtualDisplay
 * @see #DISPLAY_CATEGORY_PRESENTATION
 * @see android.view.Display#FLAG_PRESENTATION
 * @apiSince 19
 */

public static final int VIRTUAL_DISPLAY_FLAG_PRESENTATION = 2; // 0x2

/**
 * Virtual display flag: Create a public display.
 *
 * <h3>Public virtual displays</h3>
 * <p>
 * When this flag is set, the virtual display is public.
 * </p><p>
 * A public virtual display behaves just like most any other display that is connected
 * to the system such as an HDMI or Wireless display.  Applications can open
 * windows on the display and the system may mirror the contents of other displays
 * onto it.
 * </p><p>
 * Creating a public virtual display that isn't restricted to own-content only implicitly
 * creates an auto-mirroring display. See {@link #VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR} for
 * restrictions on who is allowed to create an auto-mirroring display.
 * </p>
 *
 * <h3>Private virtual displays</h3>
 * <p>
 * When this flag is not set, the virtual display is private as defined by the
 * {@link android.view.Display#FLAG_PRIVATE Display#FLAG_PRIVATE} display flag.
 * </p>
 *
 * <p>
 * A private virtual display belongs to the application that created it.  Only the a owner of a
 * private virtual display and the apps that are already on that display are allowed to place
 * windows upon it.  The private virtual display also does not participate in display mirroring:
 * it will neither receive mirrored content from another display nor allow its own content to be
 * mirrored elsewhere.  More precisely, the only processes that are allowed to enumerate or
 * interact with the private display are those that have the same UID as the application that
 * originally created the private virtual display or as the activities that are already on that
 * display.
 * </p>
 *
 * @see #createVirtualDisplay
 * @see #VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY
 * @see #VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR
 * @apiSince 19
 */

public static final int VIRTUAL_DISPLAY_FLAG_PUBLIC = 1; // 0x1

/**
 * Virtual display flag: Create a secure display.
 *
 * <h3>Secure virtual displays</h3>
 * <p>
 * When this flag is set, the virtual display is considered secure as defined
 * by the {@link android.view.Display#FLAG_SECURE Display#FLAG_SECURE} display flag.  The caller promises to take
 * reasonable measures, such as over-the-air encryption, to prevent the contents
 * of the display from being intercepted or recorded on a persistent medium.
 * </p><p>
 * Creating a secure virtual display requires the CAPTURE_SECURE_VIDEO_OUTPUT permission.
 * This permission is reserved for use by system components and is not available to
 * third-party applications.
 * </p>
 *
 * <h3>Non-secure virtual displays</h3>
 * <p>
 * When this flag is not set, the virtual display is considered unsecure.
 * The content of secure windows will be blanked if shown on this display.
 * </p>
 *
 * @see android.view.Display#FLAG_SECURE
 * @see #createVirtualDisplay
 * @apiSince 19
 */

public static final int VIRTUAL_DISPLAY_FLAG_SECURE = 4; // 0x4
/**
 * Listens for changes in available display devices.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface DisplayListener {

/**
 * Called whenever a logical display has been added to the system.
 * Use {@link android.hardware.display.DisplayManager#getDisplay DisplayManager#getDisplay} to get more information about
 * the display.
 *
 * @param displayId The id of the logical display that was added.
 * @apiSince 17
 */

public void onDisplayAdded(int displayId);

/**
 * Called whenever a logical display has been removed from the system.
 *
 * @param displayId The id of the logical display that was removed.
 * @apiSince 17
 */

public void onDisplayRemoved(int displayId);

/**
 * Called whenever the properties of a logical {@link android.view.Display},
 * such as size and density, have changed.
 *
 * @param displayId The id of the logical display that changed.
 * @apiSince 17
 */

public void onDisplayChanged(int displayId);
}

}

