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


package android.view;

import android.graphics.Point;
import android.graphics.Rect;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Provides information about the size and density of a logical display.
 * <p>
 * The display area is described in two different ways.
 * <ul>
 * <li>The application display area specifies the part of the display that may contain
 * an application window, excluding the system decorations.  The application display area may
 * be smaller than the real display area because the system subtracts the space needed
 * for decor elements such as the status bar.  Use the following methods to query the
 * application display area: {@link #getSize}, {@link #getRectSize} and {@link #getMetrics}.</li>
 * <li>The real display area specifies the part of the display that contains content
 * including the system decorations.  Even so, the real display area may be smaller than the
 * physical size of the display if the window manager is emulating a smaller display
 * using (adb shell wm size).  Use the following methods to query the
 * real display area: {@link #getRealSize}, {@link #getRealMetrics}.</li>
 * </ul>
 * </p><p>
 * A logical display does not necessarily represent a particular physical display device
 * such as the built-in screen or an external monitor.  The contents of a logical
 * display may be presented on one or more physical displays according to the devices
 * that are currently attached and whether mirroring has been enabled.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Display {

Display() { throw new RuntimeException("Stub!"); }

/**
 * Gets the display id.
 * <p>
 * Each logical display has a unique id.
 * The default display has id {@link #DEFAULT_DISPLAY}.
 * </p>
 * @apiSince 1
 */

public int getDisplayId() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this display is still valid, false if the display has been removed.
 *
 * If the display is invalid, then the methods of this class will
 * continue to report the most recently observed display information.
 * However, it is unwise (and rather fruitless) to continue using a
 * {@link android.view.Display Display} object after the display's demise.
 *
 * It's possible for a display that was previously invalid to become
 * valid again if a display with the same id is reconnected.
 *
 * @return True if the display is still valid.
 * @apiSince 17
 */

public boolean isValid() { throw new RuntimeException("Stub!"); }

/**
 * Returns a combination of flags that describe the capabilities of the display.
 *
 * @return The display flags.
 *
 * @see #FLAG_SUPPORTS_PROTECTED_BUFFERS
 * @see #FLAG_SECURE
 * @see #FLAG_PRIVATE
 * @apiSince 17
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the display.
 * <p>
 * Note that some displays may be renamed by the user.
 * </p>
 *
 * @return The display's name.
 * @apiSince 17
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the size of the display, in pixels.
 * Value returned by this method does not necessarily represent the actual raw size
 * (native resolution) of the display.
 * <p>
 * 1. The returned size may be adjusted to exclude certain system decor elements
 * that are always visible.
 * </p><p>
 * 2. It may be scaled to provide compatibility with older applications that
 * were originally designed for smaller displays.
 * </p><p>
 * 3. It can be different depending on the WindowManager to which the display belongs.
 * </p><p>
 * - If requested from non-Activity context (e.g. Application context via
 * {@code (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)})
 * it will report the size of the entire display based on current rotation and with subtracted
 * system decoration areas.
 * </p><p>
 * - If requested from activity (either using {@code getWindowManager()} or
 * {@code (WindowManager) getSystemService(Context.WINDOW_SERVICE)}) resulting size will
 * correspond to current app window size. In this case it can be smaller than physical size in
 * multi-window mode.
 * </p><p>
 * Typically for the purposes of layout apps should make a request from activity context
 * to obtain size available for the app content.
 * </p>
 *
 * @param outSize A {@link android.graphics.Point Point} object to receive the size information.
 * @apiSince 13
 */

public void getSize(android.graphics.Point outSize) { throw new RuntimeException("Stub!"); }

/**
 * Gets the size of the display as a rectangle, in pixels.
 *
 * @param outSize A {@link android.graphics.Rect Rect} object to receive the size information.
 * @see #getSize(Point)
 * @apiSince 13
 */

public void getRectSize(android.graphics.Rect outSize) { throw new RuntimeException("Stub!"); }

/**
 * Return the range of display sizes an application can expect to encounter
 * under normal operation, as long as there is no physical change in screen
 * size.  This is basically the sizes you will see as the orientation
 * changes, taking into account whatever screen decoration there is in
 * each rotation.  For example, the status bar is always at the top of the
 * screen, so it will reduce the height both in landscape and portrait, and
 * the smallest height returned here will be the smaller of the two.
 *
 * This is intended for applications to get an idea of the range of sizes
 * they will encounter while going through device rotations, to provide a
 * stable UI through rotation.  The sizes here take into account all standard
 * system decorations that reduce the size actually available to the
 * application: the status bar, navigation bar, system bar, etc.  It does
 * <em>not</em> take into account more transient elements like an IME
 * soft keyboard.
 *
 * @param outSmallestSize Filled in with the smallest width and height
 * that the application will encounter, in pixels (not dp units).  The x
 * (width) dimension here directly corresponds to
 * {@link android.content.res.Configuration#smallestScreenWidthDp
 * Configuration.smallestScreenWidthDp}, except the value here is in raw
 * screen pixels rather than dp units.  Your application may of course
 * still get smaller space yet if, for example, a soft keyboard is
 * being displayed.
 * @param outLargestSize Filled in with the largest width and height
 * that the application will encounter, in pixels (not dp units).  Your
 * application may of course still get larger space than this if,
 * for example, screen decorations like the status bar are being hidden.
 * @apiSince 16
 */

public void getCurrentSizeRange(android.graphics.Point outSmallestSize, android.graphics.Point outLargestSize) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getSize(android.graphics.Point)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getSize(android.graphics.Point)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the rotation of the screen from its "natural" orientation.
 * The returned value may be {@link android.view.Surface#ROTATION_0 Surface#ROTATION_0}
 * (no rotation), {@link android.view.Surface#ROTATION_90 Surface#ROTATION_90},
 * {@link android.view.Surface#ROTATION_180 Surface#ROTATION_180}, or
 * {@link android.view.Surface#ROTATION_270 Surface#ROTATION_270}.  For
 * example, if a device has a naturally tall screen, and the user has
 * turned it on its side to go into a landscape orientation, the value
 * returned here may be either {@link android.view.Surface#ROTATION_90 Surface#ROTATION_90}
 * or {@link android.view.Surface#ROTATION_270 Surface#ROTATION_270} depending on
 * the direction it was turned.  The angle is the rotation of the drawn
 * graphics on the screen, which is the opposite direction of the physical
 * rotation of the device.  For example, if the device is rotated 90
 * degrees counter-clockwise, to compensate rendering will be rotated by
 * 90 degrees clockwise and thus the returned value here will be
 * {@link android.view.Surface#ROTATION_90 Surface#ROTATION_90}.
 
 * @return Value is {@link android.view.Surface#ROTATION_0}, {@link android.view.Surface#ROTATION_90}, {@link android.view.Surface#ROTATION_180}, or {@link android.view.Surface#ROTATION_270}
 * @apiSince 8
 */

public int getRotation() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #getRotation}
 * @return orientation of this display.
 
 * Value is {@link android.view.Surface#ROTATION_0}, {@link android.view.Surface#ROTATION_90}, {@link android.view.Surface#ROTATION_180}, or {@link android.view.Surface#ROTATION_270}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public int getOrientation() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.view.DisplayCutout DisplayCutout}, or {@code null} if there is none.
 *
 * @see android.view.DisplayCutout
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.view.DisplayCutout getCutout() { throw new RuntimeException("Stub!"); }

/**
 * Gets the pixel format of the display.
 * @return One of the constants defined in {@link android.graphics.PixelFormat}.
 *
 * @deprecated This method is no longer supported.
 * The result is always {@link android.graphics.PixelFormat#RGBA_8888 PixelFormat#RGBA_8888}.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public int getPixelFormat() { throw new RuntimeException("Stub!"); }

/**
 * Gets the refresh rate of this display in frames per second.
 * @apiSince 1
 */

public float getRefreshRate() { throw new RuntimeException("Stub!"); }

/**
 * Get the supported refresh rates of this display in frames per second.
 * <p>
 * This method only returns refresh rates for the display's default modes. For more options, use
 * {@link #getSupportedModes()}.
 *
 * @deprecated use {@link #getSupportedModes()} instead
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated
public float[] getSupportedRefreshRates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the active mode of the display.
 * @apiSince 23
 */

public android.view.Display.Mode getMode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported modes of this display.
 * @apiSince 23
 */

public android.view.Display.Mode[] getSupportedModes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the display's HDR capabilities.
 *
 * @see #isHdr()
 * @apiSince 24
 */

public android.view.Display.HdrCapabilities getHdrCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this display supports any HDR type.
 *
 * @see #getHdrCapabilities()
 * @see android.view.Display.HdrCapabilities#getSupportedHdrTypes()
 * @apiSince 26
 */

public boolean isHdr() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this display can be used to display wide color gamut content.
 * This does not necessarily mean the device itself can render wide color gamut
 * content. To ensure wide color gamut content can be produced, refer to
 * {@link android.content.res.Configuration#isScreenWideColorGamut() Configuration#isScreenWideColorGamut()}.
 * @apiSince 26
 */

public boolean isWideColorGamut() { throw new RuntimeException("Stub!"); }

/**
 * Returns the preferred wide color space of the Display.
 * The returned wide gamut color space is based on hardware capability and
 * is preferred by the composition pipeline.
 * Returns null if the display doesn't support wide color gamut.
 * {@link android.view.Display#isWideColorGamut() Display#isWideColorGamut()}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.ColorSpace getPreferredWideGamutColorSpace() { throw new RuntimeException("Stub!"); }

/**
 * Gets the app VSYNC offset, in nanoseconds.  This is a positive value indicating
 * the phase offset of the VSYNC events provided by Choreographer relative to the
 * display refresh.  For example, if Choreographer reports that the refresh occurred
 * at time N, it actually occurred at (N - appVsyncOffset).
 * <p>
 * Apps generally do not need to be aware of this.  It's only useful for fine-grained
 * A/V synchronization.
 * @apiSince 21
 */

public long getAppVsyncOffsetNanos() { throw new RuntimeException("Stub!"); }

/**
 * This is how far in advance a buffer must be queued for presentation at
 * a given time.  If you want a buffer to appear on the screen at
 * time N, you must submit the buffer before (N - presentationDeadline).
 * <p>
 * The desired presentation time for GLES rendering may be set with
 * {@link android.opengl.EGLExt#eglPresentationTimeANDROID}.  For video decoding, use
 * {@link android.media.MediaCodec#releaseOutputBuffer(int, long)}.  Times are
 * expressed in nanoseconds, using the system monotonic clock
 * ({@link java.lang.System#nanoTime System#nanoTime}).
 * @apiSince 21
 */

public long getPresentationDeadlineNanos() { throw new RuntimeException("Stub!"); }

/**
 * Gets display metrics that describe the size and density of this display.
 * The size returned by this method does not necessarily represent the
 * actual raw size (native resolution) of the display.
 * <p>
 * 1. The returned size may be adjusted to exclude certain system decor elements
 * that are always visible.
 * </p><p>
 * 2. It may be scaled to provide compatibility with older applications that
 * were originally designed for smaller displays.
 * </p><p>
 * 3. It can be different depending on the WindowManager to which the display belongs.
 * </p><p>
 * - If requested from non-Activity context (e.g. Application context via
 * {@code (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)})
 * metrics will report the size of the entire display based on current rotation and with
 * subtracted system decoration areas.
 * </p><p>
 * - If requested from activity (either using {@code getWindowManager()} or
 * {@code (WindowManager) getSystemService(Context.WINDOW_SERVICE)}) resulting metrics will
 * correspond to current app window metrics. In this case the size can be smaller than physical
 * size in multi-window mode.
 * </p>
 *
 * @param outMetrics A {@link android.util.DisplayMetrics DisplayMetrics} object to receive the metrics.
 * @apiSince 1
 */

public void getMetrics(android.util.DisplayMetrics outMetrics) { throw new RuntimeException("Stub!"); }

/**
 * Gets the real size of the display without subtracting any window decor or
 * applying any compatibility scale factors.
 * <p>
 * The size is adjusted based on the current rotation of the display.
 * </p><p>
 * The real size may be smaller than the physical size of the screen when the
 * window manager is emulating a smaller display (using adb shell wm size).
 * </p>
 *
 * @param outSize Set to the real size of the display.
 * @apiSince 17
 */

public void getRealSize(android.graphics.Point outSize) { throw new RuntimeException("Stub!"); }

/**
 * Gets display metrics based on the real size of this display.
 * <p>
 * The size is adjusted based on the current rotation of the display.
 * </p><p>
 * The real size may be smaller than the physical size of the screen when the
 * window manager is emulating a smaller display (using adb shell wm size).
 * </p>
 *
 * @param outMetrics A {@link android.util.DisplayMetrics DisplayMetrics} object to receive the metrics.
 * @apiSince 17
 */

public void getRealMetrics(android.util.DisplayMetrics outMetrics) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the display, such as whether it is on or off.
 *
 * @return The state of the display: one of {@link #STATE_OFF}, {@link #STATE_ON},
 * {@link #STATE_DOZE}, {@link #STATE_DOZE_SUSPEND}, {@link #STATE_ON_SUSPEND}, or
 * {@link #STATE_UNKNOWN}.
 * @apiSince 20
 */

public int getState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The default Display id, which is the id of the built-in primary display
 * assuming there is one.
 * @apiSince 1
 */

public static final int DEFAULT_DISPLAY = 0; // 0x0

/**
 * Display flag: Indicates that the display is a presentation display.
 * <p>
 * This flag identifies secondary displays that are suitable for
 * use as presentation displays such as HDMI or Wireless displays.  Applications
 * may automatically project their content to presentation displays to provide
 * richer second screen experiences.
 * </p>
 *
 * @see #getFlags
 * @apiSince 19
 */

public static final int FLAG_PRESENTATION = 8; // 0x8

/**
 * Display flag: Indicates that the display is private.  Only the application that
 * owns the display and apps that are already on the display can create windows on it.
 *
 * @see #getFlags
 * @apiSince 19
 */

public static final int FLAG_PRIVATE = 4; // 0x4

/**
 * Display flag: Indicates that the display has a round shape.
 * <p>
 * This flag identifies displays that are circular, elliptical or otherwise
 * do not permit the user to see all the way to the logical corners of the display.
 * </p>
 *
 * @see #getFlags
 * @apiSince 23
 */

public static final int FLAG_ROUND = 16; // 0x10

/**
 * Display flag: Indicates that the display has a secure video output and
 * supports compositing secure surfaces.
 * <p>
 * If this flag is set then the display device has a secure video output
 * and is capable of showing secure surfaces.  It may also be capable of
 * showing {@link #FLAG_SUPPORTS_PROTECTED_BUFFERS protected buffers}.
 * </p><p>
 * If this flag is not set then the display device may not have a secure video
 * output; the user may see a blank region on the screen instead of
 * the contents of secure surfaces or protected buffers.
 * </p><p>
 * Secure surfaces are used to prevent content rendered into those surfaces
 * by applications from appearing in screenshots or from being viewed
 * on non-secure displays.  Protected buffers are used by secure video decoders
 * for a similar purpose.
 * </p><p>
 * An application creates a window with a secure surface by specifying the
 * {@link android.view.WindowManager.LayoutParams#FLAG_SECURE WindowManager.LayoutParams#FLAG_SECURE} window flag.
 * Likewise, an application creates a {@link android.view.SurfaceView SurfaceView} with a secure surface
 * by calling {@link android.view.SurfaceView#setSecure SurfaceView#setSecure} before attaching the secure view to
 * its containing window.
 * </p><p>
 * An application can use the absence of this flag as a hint that it should not create
 * secure surfaces or protected buffers on this display because the content may
 * not be visible.  For example, if the flag is not set then the application may
 * choose not to show content on this display, show an informative error message,
 * select an alternate content stream or adopt a different strategy for decoding
 * content that does not rely on secure surfaces or protected buffers.
 * </p>
 *
 * @see #getFlags
 * @apiSince 17
 */

public static final int FLAG_SECURE = 2; // 0x2

/**
 * Display flag: Indicates that the display supports compositing content
 * that is stored in protected graphics buffers.
 * <p>
 * If this flag is set then the display device supports compositing protected buffers.
 * </p><p>
 * If this flag is not set then the display device may not support compositing
 * protected buffers; the user may see a blank region on the screen instead of
 * the protected content.
 * </p><p>
 * Secure (DRM) video decoders may allocate protected graphics buffers to request that
 * a hardware-protected path be provided between the video decoder and the external
 * display sink.  If a hardware-protected path is not available, then content stored
 * in protected graphics buffers may not be composited.
 * </p><p>
 * An application can use the absence of this flag as a hint that it should not use protected
 * buffers for this display because the content may not be visible.  For example,
 * if the flag is not set then the application may choose not to show content on this
 * display, show an informative error message, select an alternate content stream
 * or adopt a different strategy for decoding content that does not rely on
 * protected buffers.
 * </p>
 *
 * @see #getFlags
 * @apiSince 17
 */

public static final int FLAG_SUPPORTS_PROTECTED_BUFFERS = 1; // 0x1

/**
 * Invalid display id.
 * @apiSince 23
 */

public static final int INVALID_DISPLAY = -1; // 0xffffffff

/**
 * Display state: The display is dozing in a low power state; it is still
 * on but is optimized for showing system-provided content while the
 * device is non-interactive.
 *
 * @see #getState
 * @see android.os.PowerManager#isInteractive
 * @apiSince 21
 */

public static final int STATE_DOZE = 3; // 0x3

/**
 * Display state: The display is dozing in a suspended low power state; it is still
 * on but the CPU is not updating it. This may be used in one of two ways: to show
 * static system-provided content while the device is non-interactive, or to allow
 * a "Sidekick" compute resource to update the display. For this reason, the
 * CPU must not control the display in this mode.
 *
 * @see #getState
 * @see android.os.PowerManager#isInteractive
 * @apiSince 21
 */

public static final int STATE_DOZE_SUSPEND = 4; // 0x4

/**
 * Display state: The display is off.
 *
 * @see #getState
 * @apiSince 20
 */

public static final int STATE_OFF = 1; // 0x1

/**
 * Display state: The display is on.
 *
 * @see #getState
 * @apiSince 20
 */

public static final int STATE_ON = 2; // 0x2

/**
 * Display state: The display is in a suspended full power state; it is still
 * on but the CPU is not updating it. This may be used in one of two ways: to show
 * static system-provided content while the device is non-interactive, or to allow
 * a "Sidekick" compute resource to update the display. For this reason, the
 * CPU must not control the display in this mode.
 *
 * @see #getState
 * @see android.os.PowerManager#isInteractive
 * @apiSince 28
 */

public static final int STATE_ON_SUSPEND = 6; // 0x6

/**
 * Display state: The display state is unknown.
 *
 * @see #getState
 * @apiSince 20
 */

public static final int STATE_UNKNOWN = 0; // 0x0

/**
 * Display state: The display is on and optimized for VR mode.
 *
 * @see #getState
 * @see android.os.PowerManager#isInteractive
 * @apiSince 26
 */

public static final int STATE_VR = 5; // 0x5
/**
 * Encapsulates the HDR capabilities of a given display.
 * For example, what HDR types it supports and details about the desired luminance data.
 * <p>You can get an instance for a given {@link android.view.Display Display} object with
 * {@link android.view.Display#getHdrCapabilities Display#getHdrCapabilities}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class HdrCapabilities implements android.os.Parcelable {

HdrCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported HDR types of this display.
 * Returns empty array if HDR is not supported by the display.
 
 * @return Value is {@link android.view.Display.HdrCapabilities#HDR_TYPE_DOLBY_VISION}, {@link android.view.Display.HdrCapabilities#HDR_TYPE_HDR10}, {@link android.view.Display.HdrCapabilities#HDR_TYPE_HLG}, or {@link android.view.Display.HdrCapabilities#HDR_TYPE_HDR10_PLUS}
 * @apiSince 24
 */

public int[] getSupportedHdrTypes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the desired content max luminance data in cd/m2 for this display.
 * @apiSince 24
 */

public float getDesiredMaxLuminance() { throw new RuntimeException("Stub!"); }

/**
 * Returns the desired content max frame-average luminance data in cd/m2 for this display.
 * @apiSince 24
 */

public float getDesiredMaxAverageLuminance() { throw new RuntimeException("Stub!"); }

/**
 * Returns the desired content min luminance data in cd/m2 for this display.
 * @apiSince 24
 */

public float getDesiredMinLuminance() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.Display.HdrCapabilities> CREATOR;
static { CREATOR = null; }

/**
 * Dolby Vision high dynamic range (HDR) display.
 * @apiSince 24
 */

public static final int HDR_TYPE_DOLBY_VISION = 1; // 0x1

/**
 * HDR10 display.
 * @apiSince 24
 */

public static final int HDR_TYPE_HDR10 = 2; // 0x2

/**
 * HDR10+ display.
 * @apiSince 29
 */

public static final int HDR_TYPE_HDR10_PLUS = 4; // 0x4

/**
 * Hybrid Log-Gamma HDR display.
 * @apiSince 24
 */

public static final int HDR_TYPE_HLG = 3; // 0x3

/**
 * Invalid luminance value.
 * @apiSince 24
 */

public static final float INVALID_LUMINANCE = -1.0f;
}

/**
 * A mode supported by a given display.
 *
 * @see android.view.Display#getSupportedModes()
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Mode implements android.os.Parcelable {

Mode() { throw new RuntimeException("Stub!"); }

/**
 * Returns this mode's id.
 * @apiSince 23
 */

public int getModeId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the physical width of the display in pixels when configured in this mode's
 * resolution.
 * <p>
 * Note that due to application UI scaling, the number of pixels made available to
 * applications when the mode is active (as reported by {@link android.view.Display#getWidth() Display#getWidth()} may
 * differ from the mode's actual resolution (as reported by this function).
 * <p>
 * For example, applications running on a 4K display may have their UI laid out and rendered
 * in 1080p and then scaled up. Applications can take advantage of the extra resolution by
 * rendering content through a {@link android.view.SurfaceView} using full size buffers.
 * @apiSince 23
 */

public int getPhysicalWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the physical height of the display in pixels when configured in this mode's
 * resolution.
 * <p>
 * Note that due to application UI scaling, the number of pixels made available to
 * applications when the mode is active (as reported by {@link android.view.Display#getHeight() Display#getHeight()} may
 * differ from the mode's actual resolution (as reported by this function).
 * <p>
 * For example, applications running on a 4K display may have their UI laid out and rendered
 * in 1080p and then scaled up. Applications can take advantage of the extra resolution by
 * rendering content through a {@link android.view.SurfaceView} using full size buffers.
 * @apiSince 23
 */

public int getPhysicalHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the refresh rate in frames per second.
 * @apiSince 23
 */

public float getRefreshRate() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel out, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.Display.Mode> CREATOR;
static { CREATOR = null; }
}

}

