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

import android.content.Context;
import android.app.Presentation;
import android.content.pm.ActivityInfo;
import android.Manifest.permission;
import android.app.KeyguardManager;
import android.graphics.Rect;
import android.graphics.PixelFormat;

/**
 * The interface that apps use to talk to the window manager.
 * </p><p>
 * Each window manager instance is bound to a particular {@link android.view.Display Display}.
 * To obtain a {@link android.view.WindowManager WindowManager} for a different display, use
 * {@link android.content.Context#createDisplayContext Context#createDisplayContext} to obtain a {@link android.content.Context Context} for that
 * display, then use <code>Context.getSystemService(Context.WINDOW_SERVICE)</code>
 * to get the WindowManager.
 * </p><p>
 * The simplest way to show a window on another display is to create a
 * {@link android.app.Presentation Presentation}.  The presentation will automatically obtain a
 * {@link android.view.WindowManager WindowManager} and {@link android.content.Context Context} for that display.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface WindowManager extends android.view.ViewManager {

/**
 * Returns the {@link android.view.Display Display} upon which this {@link android.view.WindowManager WindowManager} instance
 * will create new windows.
 * <p>
 * Despite the name of this method, the display that is returned is not
 * necessarily the primary display of the system (see {@link android.view.Display#DEFAULT_DISPLAY Display#DEFAULT_DISPLAY}).
 * The returned display could instead be a secondary display that this
 * window manager instance is managing.  Think of it as the display that
 * this {@link android.view.WindowManager WindowManager} instance uses by default.
 * </p><p>
 * To create windows on a different display, you need to obtain a
 * {@link android.view.WindowManager WindowManager} for that {@link android.view.Display Display}.  (See the {@link android.view.WindowManager WindowManager}
 * class documentation for more information.)
 * </p>
 *
 * @return The display that this window manager is managing.
 * @apiSince 1
 */

public android.view.Display getDefaultDisplay();

/**
 * Special variation of {@link #removeView} that immediately invokes
 * the given view hierarchy's {@link android.view.View#onDetachedFromWindow() View#onDetachedFromWindow()} methods before returning.  This is not
 * for normal applications; using it correctly requires great care.
 *
 * @param view The view to be removed.
 * @apiSince 1
 */

public void removeViewImmediate(android.view.View view);
/**
 * Exception that is thrown when trying to add view whose
 * {@link android.view.WindowManager.LayoutParams LayoutParams} {@link android.view.WindowManager.LayoutParams#token LayoutParams#token}
 * is invalid.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class BadTokenException extends java.lang.RuntimeException {

/** @apiSince 1 */

public BadTokenException() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public BadTokenException(java.lang.String name) { throw new RuntimeException("Stub!"); }
}

/**
 * Exception that is thrown when calling {@link #addView} to a secondary display that cannot
 * be found. See {@link android.app.Presentation} for more information on secondary displays.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class InvalidDisplayException extends java.lang.RuntimeException {

/** @apiSince 17 */

public InvalidDisplayException() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public InvalidDisplayException(java.lang.String name) { throw new RuntimeException("Stub!"); }
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.view.ViewGroup.LayoutParams implements android.os.Parcelable {

/** @apiSince 1 */

public LayoutParams() { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(int _type) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(int _type, int _flags) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(int _type, int _flags, int _format) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(int w, int h, int _type, int _flags, int _format) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(int w, int h, int xpos, int ypos, int _type, int _flags, int _format) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(android.os.Parcel in) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Given a particular set of window manager flags, determine whether
 * such a window may be a target for an input method when it has
 * focus.  In particular, this checks the
 * {@link #FLAG_NOT_FOCUSABLE} and {@link #FLAG_ALT_FOCUSABLE_IM}
 * flags and returns true if the combination of the two corresponds
 * to a window that needs to be behind the input method so that the
 * user can type into it.
 *
 * @param flags The current window manager flags.
 *
 * @return Returns true if such a window should be behind/interact
 * with an input method, false if not.
 * @apiSince 3
 */

public static boolean mayUseInputMethod(int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final void setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the color mode of the window. Setting the color mode might
 * override the window's pixel {@link android.view.WindowManager.LayoutParams#format WindowManager.LayoutParams#format}.</p>
 *
 * <p>The color mode must be one of {@link android.content.pm.ActivityInfo#COLOR_MODE_DEFAULT ActivityInfo#COLOR_MODE_DEFAULT},
 * {@link android.content.pm.ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT} or
 * {@link android.content.pm.ActivityInfo#COLOR_MODE_HDR ActivityInfo#COLOR_MODE_HDR}.</p>
 *
 * @see #getColorMode()
 
 * @param colorMode Value is {@link android.content.pm.ActivityInfo#COLOR_MODE_DEFAULT}, {@link android.content.pm.ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT}, or {@link android.content.pm.ActivityInfo#COLOR_MODE_HDR}
 * @apiSince 26
 */

public void setColorMode(int colorMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the color mode of the window, one of {@link android.content.pm.ActivityInfo#COLOR_MODE_DEFAULT ActivityInfo#COLOR_MODE_DEFAULT},
 * {@link android.content.pm.ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT} or {@link android.content.pm.ActivityInfo#COLOR_MODE_HDR ActivityInfo#COLOR_MODE_HDR}.
 *
 * @see #setColorMode(int)
 
 * @return Value is {@link android.content.pm.ActivityInfo#COLOR_MODE_DEFAULT}, {@link android.content.pm.ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT}, or {@link android.content.pm.ActivityInfo#COLOR_MODE_HDR}
 * @apiSince 26
 */

public int getColorMode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int copyFrom(android.view.WindowManager.LayoutParams o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String debug(java.lang.String output) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int ALPHA_CHANGED = 128; // 0x80

/** @apiSince 1 */

public static final int ANIMATION_CHANGED = 16; // 0x10

/**
 * Value for {@link #screenBrightness} and {@link #buttonBrightness}
 * indicating that the screen or button backlight brightness should be set
 * to the hightest value when this window is in front.
 * @apiSince 8
 */

public static final float BRIGHTNESS_OVERRIDE_FULL = 1.0f;

/**
 * Default value for {@link #screenBrightness} and {@link #buttonBrightness}
 * indicating that the brightness value is not overridden for this window
 * and normal brightness policy should be used.
 * @apiSince 8
 */

public static final float BRIGHTNESS_OVERRIDE_NONE = -1.0f;

/**
 * Value for {@link #screenBrightness} and {@link #buttonBrightness}
 * indicating that the screen or button backlight brightness should be set
 * to the lowest value when this window is in front.
 * @apiSince 8
 */

public static final float BRIGHTNESS_OVERRIDE_OFF = 0.0f;

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.WindowManager.LayoutParams> CREATOR;
static { CREATOR = null; }

/** @apiSince 1 */

public static final int DIM_AMOUNT_CHANGED = 32; // 0x20

/**
 * Start of window types that represent normal application windows.
 * @apiSince 1
 */

public static final int FIRST_APPLICATION_WINDOW = 1; // 0x1

/**
 * Start of types of sub-windows.  The {@link #token} of these windows
 * must be set to the window they are attached to.  These types of
 * windows are kept next to their attached window in Z-order, and their
 * coordinate space is relative to their attached window.
 * @apiSince 1
 */

public static final int FIRST_SUB_WINDOW = 1000; // 0x3e8

/**
 * Start of system-specific window types.  These are not normally
 * created by applications.
 * @apiSince 1
 */

public static final int FIRST_SYSTEM_WINDOW = 2000; // 0x7d0

/** @apiSince 1 */

public static final int FLAGS_CHANGED = 4; // 0x4

/** Window flag: as long as this window is visible to the user, allow
 *  the lock screen to activate while the screen is on.
 *  This can be used independently, or in combination with
 *  {@link #FLAG_KEEP_SCREEN_ON} and/or {@link #FLAG_SHOW_WHEN_LOCKED}         * @apiSince 8
 */

public static final int FLAG_ALLOW_LOCK_WHILE_SCREEN_ON = 1; // 0x1

/** Window flag: invert the state of {@link #FLAG_NOT_FOCUSABLE} with
 * respect to how this window interacts with the current method.  That
 * is, if FLAG_NOT_FOCUSABLE is set and this flag is set, then the
 * window will behave as if it needs to interact with the input method
 * and thus be placed behind/away from it; if FLAG_NOT_FOCUSABLE is
 * not set and this flag is set, then the window will behave as if it
 * doesn't need to interact with the input method and can be placed
 * to use more space and cover the input method.
 * @apiSince 3
 */

public static final int FLAG_ALT_FOCUSABLE_IM = 131072; // 0x20000

/** Window flag: blur everything behind this window.
 * @deprecated Blurring is no longer supported.         * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int FLAG_BLUR_BEHIND = 4; // 0x4

/** Window flag: everything behind this window will be dimmed.
 *  Use {@link #dimAmount} to control the amount of dim.         * @apiSince 1
 */

public static final int FLAG_DIM_BEHIND = 2; // 0x2

/**
 * Window flag: when set the window will cause the keyguard to be
 * dismissed, only if it is not a secure lock keyguard. Because such a
 * keyguard is not needed for security, it will never re-appear if the
 * user navigates to another window (in contrast to
 * {@link #FLAG_SHOW_WHEN_LOCKED}, which will only temporarily hide both
 * secure and non-secure keyguards but ensure they reappear when the
 * user moves to another UI that doesn't hide them). If the keyguard is
 * currently active and is secure (requires an unlock credential) than
 * the user will still need to confirm it before seeing this window,
 * unless {@link #FLAG_SHOW_WHEN_LOCKED} has also been set.
 *
 * @deprecated Use {@link #FLAG_SHOW_WHEN_LOCKED} or
 *             {@link android.app.KeyguardManager#requestDismissKeyguard KeyguardManager#requestDismissKeyguard} instead.
 *             Since keyguard was dismissed all the time as long as an
 *             activity with this flag on its window was focused,
 *             keyguard couldn't guard against unintentional touches on
 *             the screen, which isn't desired.
 * @apiSince 5
 * @deprecatedSince 26
 */

@Deprecated public static final int FLAG_DISMISS_KEYGUARD = 4194304; // 0x400000

/** Window flag: turn on dithering when compositing this window to
 *  the screen.
 * @deprecated This flag is no longer used.         * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final int FLAG_DITHER = 4096; // 0x1000

/**
 * Flag indicating that this Window is responsible for drawing the background for the
 * system bars. If set, the system bars are drawn with a transparent background and the
 * corresponding areas in this window are filled with the colors specified in
 * {@link android.view.Window#getStatusBarColor() Window#getStatusBarColor()} and {@link android.view.Window#getNavigationBarColor() Window#getNavigationBarColor()}.
 * @apiSince 21
 */

public static final int FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS = -2147483648; // 0x80000000

/** Window flag: override {@link #FLAG_FULLSCREEN} and force the
 *  screen decorations (such as the status bar) to be shown.         * @apiSince 1
 */

public static final int FLAG_FORCE_NOT_FULLSCREEN = 2048; // 0x800

/**
 * Window flag: hide all screen decorations (such as the status bar) while
 * this window is displayed.  This allows the window to use the entire
 * display space for itself -- the status bar will be hidden when
 * an app window with this flag set is on the top layer. A fullscreen window
 * will ignore a value of {@link #SOFT_INPUT_ADJUST_RESIZE} for the window's
 * {@link #softInputMode} field; the window will stay fullscreen
 * and will not resize.
 *
 * <p>This flag can be controlled in your theme through the
 * {@link android.R.attr#windowFullscreen} attribute; this attribute
 * is automatically set for you in the standard fullscreen themes
 * such as {@link android.R.style#Theme_NoTitleBar_Fullscreen},
 * {@link android.R.style#Theme_Black_NoTitleBar_Fullscreen},
 * {@link android.R.style#Theme_Light_NoTitleBar_Fullscreen},
 * {@link android.R.style#Theme_Holo_NoActionBar_Fullscreen},
 * {@link android.R.style#Theme_Holo_Light_NoActionBar_Fullscreen},
 * {@link android.R.style#Theme_DeviceDefault_NoActionBar_Fullscreen}, and
 * {@link android.R.style#Theme_DeviceDefault_Light_NoActionBar_Fullscreen}.</p>
 * @apiSince 1
 */

public static final int FLAG_FULLSCREEN = 1024; // 0x400

/**
 * <p>Indicates whether this window should be hardware accelerated.
 * Requesting hardware acceleration does not guarantee it will happen.</p>
 *
 * <p>This flag can be controlled programmatically <em>only</em> to enable
 * hardware acceleration. To enable hardware acceleration for a given
 * window programmatically, do the following:</p>
 *
 * <pre>
 * Window w = activity.getWindow(); // in Activity's onCreate() for instance
 * w.setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
 *         WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
 * </pre>
 *
 * <p>It is important to remember that this flag <strong>must</strong>
 * be set before setting the content view of your activity or dialog.</p>
 *
 * <p>This flag cannot be used to disable hardware acceleration after it
 * was enabled in your manifest using
 * {@link android.R.attr#hardwareAccelerated}. If you need to selectively
 * and programmatically disable hardware acceleration (for automated testing
 * for instance), make sure it is turned off in your manifest and enable it
 * on your activity or dialog when you need it instead, using the method
 * described above.</p>
 *
 * <p>This flag is automatically set by the system if the
 * {@link android.R.attr#hardwareAccelerated android:hardwareAccelerated}
 * XML attribute is set to true on an activity or on the application.</p>
 * @apiSince 11
 */

public static final int FLAG_HARDWARE_ACCELERATED = 16777216; // 0x1000000

/** Window flag: intended for windows that will often be used when the user is
 * holding the screen against their face, it will aggressively filter the event
 * stream to prevent unintended presses in this situation that may not be
 * desired for a particular window, when such an event stream is detected, the
 * application will receive a CANCEL motion event to indicate this so applications
 * can handle this accordingly by taking no action on the event
 * until the finger is released.         * @apiSince 1
 */

public static final int FLAG_IGNORE_CHEEK_PRESSES = 32768; // 0x8000

/** Window flag: as long as this window is visible to the user, keep
 *  the device's screen turned on and bright.         * @apiSince 1
 */

public static final int FLAG_KEEP_SCREEN_ON = 128; // 0x80

/**
 * Window flag: When requesting layout with an attached window, the attached window may
 * overlap with the screen decorations of the parent window such as the navigation bar. By
 * including this flag, the window manager will layout the attached window within the decor
 * frame of the parent window such that it doesn't overlap with screen decorations.
 * @apiSince 22
 */

public static final int FLAG_LAYOUT_ATTACHED_IN_DECOR = 1073741824; // 0x40000000

/** Window flag: a special option only for use in combination with
 * {@link #FLAG_LAYOUT_IN_SCREEN}.  When requesting layout in the
 * screen your window may appear on top of or behind screen decorations
 * such as the status bar.  By also including this flag, the window
 * manager will report the inset rectangle needed to ensure your
 * content is not covered by screen decorations.  This flag is normally
 * set for you by Window as described in {@link android.view.Window#setFlags Window#setFlags}.         * @apiSince 1
 */

public static final int FLAG_LAYOUT_INSET_DECOR = 65536; // 0x10000

/**
 * Window flag: allow window contents to extend in to the screen's
 * overscan area, if there is one.  The window should still correctly
 * position its contents to take the overscan area into account.
 *
 * <p>This flag can be controlled in your theme through the
 * {@link android.R.attr#windowOverscan} attribute; this attribute
 * is automatically set for you in the standard overscan themes
 * such as
 * {@link android.R.style#Theme_Holo_NoActionBar_Overscan},
 * {@link android.R.style#Theme_Holo_Light_NoActionBar_Overscan},
 * {@link android.R.style#Theme_DeviceDefault_NoActionBar_Overscan}, and
 * {@link android.R.style#Theme_DeviceDefault_Light_NoActionBar_Overscan}.</p>
 *
 * <p>When this flag is enabled for a window, its normal content may be obscured
 * to some degree by the overscan region of the display.  To ensure key parts of
 * that content are visible to the user, you can use
 * {@link android.view.View#setFitsSystemWindows(boolean) View#setFitsSystemWindows(boolean)}
 * to set the point in the view hierarchy where the appropriate offsets should
 * be applied.  (This can be done either by directly calling this function, using
 * the {@link android.R.attr#fitsSystemWindows} attribute in your view hierarchy,
 * or implementing you own {@link android.view.View#fitSystemWindows(android.graphics.Rect) View#fitSystemWindows(android.graphics.Rect)} method).</p>
 *
 * <p>This mechanism for positioning content elements is identical to its equivalent
 * use with layout and {@link android.view.View#setSystemUiVisibility(int) View#setSystemUiVisibility(int)}; here is an example layout that will correctly
 * position its UI elements with this overscan flag is set:</p>
 *
 * {@sample development/samples/ApiDemos/res/layout/overscan_activity.xml complete}
 * @apiSince 18
 */

public static final int FLAG_LAYOUT_IN_OVERSCAN = 33554432; // 0x2000000

/** Window flag: place the window within the entire screen, ignoring
 *  decorations around the border (such as the status bar).  The
 *  window must correctly position its contents to take the screen
 *  decoration into account.  This flag is normally set for you
 *  by Window as described in {@link android.view.Window#setFlags Window#setFlags}.
 *
 *  <p>Note: on displays that have a {@link android.view.DisplayCutout DisplayCutout}, the window may be placed
 *  such that it avoids the {@link android.view.DisplayCutout DisplayCutout} area if necessary according to the
 *  {@link #layoutInDisplayCutoutMode}.
 * @apiSince 1
 */

public static final int FLAG_LAYOUT_IN_SCREEN = 256; // 0x100

/**
 * Window flag: allow window to extend outside of the screen.
 * @apiSince 1
 */

public static final int FLAG_LAYOUT_NO_LIMITS = 512; // 0x200

/**
 * Flag for a window in local focus mode.
 * Window in local focus mode can control focus independent of window manager using
 * {@link android.view.Window#setLocalFocus(boolean,boolean) Window#setLocalFocus(boolean, boolean)}.
 * Usually window in this mode will not get touch/key events from window manager, but will
 * get events only via local injection using {@link android.view.Window#injectInputEvent(android.view.InputEvent) Window#injectInputEvent(InputEvent)}.
 * @apiSince 19
 */

public static final int FLAG_LOCAL_FOCUS_MODE = 268435456; // 0x10000000

/** Window flag: this window won't ever get key input focus, so the
 * user can not send key or other button events to it.  Those will
 * instead go to whatever focusable window is behind it.  This flag
 * will also enable {@link #FLAG_NOT_TOUCH_MODAL} whether or not that
 * is explicitly set.
 *
 * <p>Setting this flag also implies that the window will not need to
 * interact with
 * a soft input method, so it will be Z-ordered and positioned
 * independently of any active input method (typically this means it
 * gets Z-ordered on top of the input method, so it can use the full
 * screen for its content and cover the input method if needed.  You
 * can use {@link #FLAG_ALT_FOCUSABLE_IM} to modify this behavior.         * @apiSince 1
 */

public static final int FLAG_NOT_FOCUSABLE = 8; // 0x8

/**
 * Window flag: this window can never receive touch events.
 * @apiSince 1
 */

public static final int FLAG_NOT_TOUCHABLE = 16; // 0x10

/** Window flag: even when this window is focusable (its
 * {@link #FLAG_NOT_FOCUSABLE} is not set), allow any pointer events
 * outside of the window to be sent to the windows behind it.  Otherwise
 * it will consume all pointer events itself, regardless of whether they
 * are inside of the window.         * @apiSince 1
 */

public static final int FLAG_NOT_TOUCH_MODAL = 32; // 0x20

/** Window flag: a special mode where the layout parameters are used
 * to perform scaling of the surface when it is composited to the
 * screen.         * @apiSince 1
 */

public static final int FLAG_SCALED = 16384; // 0x4000

/** Window flag: treat the content of the window as secure, preventing
 * it from appearing in screenshots or from being viewed on non-secure
 * displays.
 *
 * <p>See {@link android.view.Display#FLAG_SECURE} for more details about
 * secure surfaces and secure displays.
 * @apiSince 1
 */

public static final int FLAG_SECURE = 8192; // 0x2000

/** Window flag: ask that the system wallpaper be shown behind
 * your window.  The window surface must be translucent to be able
 * to actually see the wallpaper behind it; this flag just ensures
 * that the wallpaper surface will be there if this window actually
 * has translucent regions.
 *
 * <p>This flag can be controlled in your theme through the
 * {@link android.R.attr#windowShowWallpaper} attribute; this attribute
 * is automatically set for you in the standard wallpaper themes
 * such as {@link android.R.style#Theme_Wallpaper},
 * {@link android.R.style#Theme_Wallpaper_NoTitleBar},
 * {@link android.R.style#Theme_Wallpaper_NoTitleBar_Fullscreen},
 * {@link android.R.style#Theme_Holo_Wallpaper},
 * {@link android.R.style#Theme_Holo_Wallpaper_NoTitleBar},
 * {@link android.R.style#Theme_DeviceDefault_Wallpaper}, and
 * {@link android.R.style#Theme_DeviceDefault_Wallpaper_NoTitleBar}.</p>
 * @apiSince 5
 */

public static final int FLAG_SHOW_WALLPAPER = 1048576; // 0x100000

/** Window flag: special flag to let windows be shown when the screen
 * is locked. This will let application windows take precedence over
 * key guard or any other lock screens. Can be used with
 * {@link #FLAG_KEEP_SCREEN_ON} to turn screen on and display windows
 * directly before showing the key guard window.  Can be used with
 * {@link #FLAG_DISMISS_KEYGUARD} to automatically fully dismisss
 * non-secure keyguards.  This flag only applies to the top-most
 * full-screen window.
 * @deprecated Use {@link android.R.attr#showWhenLocked} or
 * {@link android.app.Activity#setShowWhenLocked(boolean)} instead to prevent an
 * unintentional double life-cycle event.
 * @apiSince 5
 * @deprecatedSince 27
 */

@Deprecated public static final int FLAG_SHOW_WHEN_LOCKED = 524288; // 0x80000

/** Window flag: when set the window will accept for touch events
 * outside of its bounds to be sent to other windows that also
 * support split touch.  When this flag is not set, the first pointer
 * that goes down determines the window to which all subsequent touches
 * go until all pointers go up.  When this flag is set, each pointer
 * (not necessarily the first) that goes down determines the window
 * to which all subsequent touches of that pointer will go until that
 * pointer goes up thereby enabling touches with multiple pointers
 * to be split across multiple windows.
 * @apiSince 11
 */

public static final int FLAG_SPLIT_TOUCH = 8388608; // 0x800000

/** Window flag: when set, if the device is asleep when the touch
 * screen is pressed, you will receive this first touch event.  Usually
 * the first touch event is consumed by the system since the user can
 * not see what they are pressing on.
 *
 * @deprecated This flag has no effect.
 * @apiSince 1
 * @deprecatedSince 20
 */

@Deprecated public static final int FLAG_TOUCHABLE_WHEN_WAKING = 64; // 0x40

/**
 * Window flag: request a translucent navigation bar with minimal system-provided
 * background protection.
 *
 * <p>This flag can be controlled in your theme through the
 * {@link android.R.attr#windowTranslucentNavigation} attribute; this attribute
 * is automatically set for you in the standard translucent decor themes
 * such as
 * {@link android.R.style#Theme_Holo_NoActionBar_TranslucentDecor},
 * {@link android.R.style#Theme_Holo_Light_NoActionBar_TranslucentDecor},
 * {@link android.R.style#Theme_DeviceDefault_NoActionBar_TranslucentDecor}, and
 * {@link android.R.style#Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor}.</p>
 *
 * <p>When this flag is enabled for a window, it automatically sets
 * the system UI visibility flags {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_STABLE View#SYSTEM_UI_FLAG_LAYOUT_STABLE} and
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION}.</p>
 *
 * <p>Note: For devices that support
 * {@link android.content.pm.PackageManager#FEATURE_AUTOMOTIVE} this flag can be disabled
 * by the car manufacturers.
 * @apiSince 19
 */

public static final int FLAG_TRANSLUCENT_NAVIGATION = 134217728; // 0x8000000

/**
 * Window flag: request a translucent status bar with minimal system-provided
 * background protection.
 *
 * <p>This flag can be controlled in your theme through the
 * {@link android.R.attr#windowTranslucentStatus} attribute; this attribute
 * is automatically set for you in the standard translucent decor themes
 * such as
 * {@link android.R.style#Theme_Holo_NoActionBar_TranslucentDecor},
 * {@link android.R.style#Theme_Holo_Light_NoActionBar_TranslucentDecor},
 * {@link android.R.style#Theme_DeviceDefault_NoActionBar_TranslucentDecor}, and
 * {@link android.R.style#Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor}.</p>
 *
 * <p>When this flag is enabled for a window, it automatically sets
 * the system UI visibility flags {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_STABLE View#SYSTEM_UI_FLAG_LAYOUT_STABLE} and
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN}.</p>
 *
 * <p>Note: For devices that support
 * {@link android.content.pm.PackageManager#FEATURE_AUTOMOTIVE} this flag may be ignored.
 * @apiSince 19
 */

public static final int FLAG_TRANSLUCENT_STATUS = 67108864; // 0x4000000

/** Window flag: when set as a window is being added or made
 * visible, once the window has been shown then the system will
 * poke the power manager's user activity (as if the user had woken
 * up the device) to turn the screen on.
 * @deprecated Use {@link android.R.attr#turnScreenOn} or
 * {@link android.app.Activity#setTurnScreenOn(boolean)} instead to prevent an
 * unintentional double life-cycle event.
 * @apiSince 5
 * @deprecatedSince 27
 */

@Deprecated public static final int FLAG_TURN_SCREEN_ON = 2097152; // 0x200000

/** Window flag: if you have set {@link #FLAG_NOT_TOUCH_MODAL}, you
 * can set this flag to receive a single special MotionEvent with
 * the action
 * {@link android.view.MotionEvent#ACTION_OUTSIDE MotionEvent#ACTION_OUTSIDE} for
 * touches that occur outside of your window.  Note that you will not
 * receive the full down/move/up gesture, only the location of the
 * first down as an ACTION_OUTSIDE.
 * @apiSince 3
 */

public static final int FLAG_WATCH_OUTSIDE_TOUCH = 262144; // 0x40000

/** @apiSince 1 */

public static final int FORMAT_CHANGED = 8; // 0x8

/**
 * End of types of application windows.
 * @apiSince 1
 */

public static final int LAST_APPLICATION_WINDOW = 99; // 0x63

/**
 * End of types of sub-windows.
 * @apiSince 1
 */

public static final int LAST_SUB_WINDOW = 1999; // 0x7cf

/**
 * End of types of system windows.
 * @apiSince 1
 */

public static final int LAST_SYSTEM_WINDOW = 2999; // 0xbb7

/** @apiSince 1 */

public static final int LAYOUT_CHANGED = 1; // 0x1

/**
 * The window is allowed to extend into the {@link android.view.DisplayCutout DisplayCutout} area, only if the
 * {@link android.view.DisplayCutout DisplayCutout} is fully contained within a system bar. Otherwise, the window is
 * laid out such that it does not overlap with the {@link android.view.DisplayCutout DisplayCutout} area.
 *
 * <p>
 * In practice, this means that if the window did not set {@link #FLAG_FULLSCREEN} or
 * {@link android.view.View#SYSTEM_UI_FLAG_FULLSCREEN View#SYSTEM_UI_FLAG_FULLSCREEN}, it can extend into the cutout area in portrait
 * if the cutout is at the top edge. Similarly for
 * {@link android.view.View#SYSTEM_UI_FLAG_HIDE_NAVIGATION View#SYSTEM_UI_FLAG_HIDE_NAVIGATION} and a cutout at the bottom of the screen.
 * Otherwise (i.e. fullscreen or landscape) it is laid out such that it does not overlap the
 * cutout area.
 *
 * <p>
 * The usual precautions for not overlapping with the status and navigation bar are
 * sufficient for ensuring that no important content overlaps with the DisplayCutout.
 *
 * @see android.view.DisplayCutout
 * @see android.view.WindowInsets
 * @see #layoutInDisplayCutoutMode
 * @see android.R.attr#windowLayoutInDisplayCutoutMode
 *         android:windowLayoutInDisplayCutoutMode
 * @apiSince 28
 */

public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT = 0; // 0x0

/**
 * The window is never allowed to overlap with the DisplayCutout area.
 *
 * <p>
 * This should be used with windows that transiently set
 * {@link android.view.View#SYSTEM_UI_FLAG_FULLSCREEN View#SYSTEM_UI_FLAG_FULLSCREEN} or {@link android.view.View#SYSTEM_UI_FLAG_HIDE_NAVIGATION View#SYSTEM_UI_FLAG_HIDE_NAVIGATION}
 * to avoid a relayout of the window when the respective flag is set or cleared.
 *
 * @see android.view.DisplayCutout
 * @see #layoutInDisplayCutoutMode
 * @see android.R.attr#windowLayoutInDisplayCutoutMode
 *         android:windowLayoutInDisplayCutoutMode
 * @apiSince 28
 */

public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER = 2; // 0x2

/**
 * The window is always allowed to extend into the {@link android.view.DisplayCutout DisplayCutout} areas on the short
 * edges of the screen.
 *
 * The window will never extend into a {@link android.view.DisplayCutout DisplayCutout} area on the long edges of the
 * screen.
 *
 * <p>
 * The window must make sure that no important content overlaps with the
 * {@link android.view.DisplayCutout DisplayCutout}.
 *
 * <p>
 * In this mode, the window extends under cutouts on the short edge of the display in both
 * portrait and landscape, regardless of whether the window is hiding the system bars:<br/>
 * <img src="{@docRoot}reference/android/images/display_cutout/short_edge/fullscreen_top_no_letterbox.png"
 * height="720"
 * alt="Screenshot of a fullscreen activity on a display with a cutout at the top edge in
 *         portrait, no letterbox is applied."/>
 *
 * <img src="{@docRoot}reference/android/images/display_cutout/short_edge/landscape_top_no_letterbox.png"
 * width="720"
 * alt="Screenshot of an activity on a display with a cutout at the top edge in landscape,
 *         no letterbox is applied."/>
 *
 * <p>
 * A cutout in the corner is considered to be on the short edge: <br/>
 * <img src="{@docRoot}reference/android/images/display_cutout/short_edge/fullscreen_corner_no_letterbox.png"
 * height="720"
 * alt="Screenshot of a fullscreen activity on a display with a cutout in the corner in
 *         portrait, no letterbox is applied."/>
 *
 * <p>
 * On the other hand, should the cutout be on the long edge of the display, a letterbox will
 * be applied such that the window does not extend into the cutout on either long edge:
 * <br/>
 * <img src="{@docRoot}reference/android/images/display_cutout/short_edge/portrait_side_letterbox.png"
 * height="720"
 * alt="Screenshot of an activity on a display with a cutout on the long edge in portrait,
 *         letterbox is applied."/>
 *
 * @see android.view.DisplayCutout
 * @see android.view.WindowInsets#getDisplayCutout()
 * @see #layoutInDisplayCutoutMode
 * @see android.R.attr#windowLayoutInDisplayCutoutMode
 *         android:windowLayoutInDisplayCutoutMode
 * @apiSince 28
 */

public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES = 1; // 0x1

/** @apiSince 1 */

public static final int MEMORY_TYPE_CHANGED = 256; // 0x100

/**
 * @deprecated this is ignored, this value is set automatically when needed.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int MEMORY_TYPE_GPU = 2; // 0x2

/**
 * @deprecated this is ignored, this value is set automatically when needed.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int MEMORY_TYPE_HARDWARE = 1; // 0x1

/**
 * @deprecated this is ignored, this value is set automatically when needed.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int MEMORY_TYPE_NORMAL = 0; // 0x0

/**
 * @deprecated this is ignored, this value is set automatically when needed.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int MEMORY_TYPE_PUSH_BUFFERS = 3; // 0x3

/** @apiSince 18 */

public static final int ROTATION_ANIMATION_CHANGED = 4096; // 0x1000

/**
 * Value for {@link #rotationAnimation} which specifies that this
 * window will fade in or out following a rotation.
 * @apiSince 18
 */

public static final int ROTATION_ANIMATION_CROSSFADE = 1; // 0x1

/**
 * Value for {@link #rotationAnimation} which specifies that this window
 * will immediately disappear or appear following a rotation.
 * @apiSince 18
 */

public static final int ROTATION_ANIMATION_JUMPCUT = 2; // 0x2

/**
 * Value for {@link #rotationAnimation} which specifies that this
 * window will visually rotate in or out following a rotation.
 * @apiSince 18
 */

public static final int ROTATION_ANIMATION_ROTATE = 0; // 0x0

/**
 * Value for {@link #rotationAnimation} to specify seamless rotation mode.
 * This works like JUMPCUT but will fall back to CROSSFADE if rotation
 * can't be applied without pausing the screen. For example, this is ideal
 * for Camera apps which don't want the viewfinder contents to ever rotate
 * or fade (and rather to be seamless) but also don't want ROTATION_ANIMATION_JUMPCUT
 * during app transition scenarios where seamless rotation can't be applied.
 * @apiSince 26
 */

public static final int ROTATION_ANIMATION_SEAMLESS = 3; // 0x3

/** @apiSince 3 */

public static final int SCREEN_BRIGHTNESS_CHANGED = 2048; // 0x800

/** @apiSince 3 */

public static final int SCREEN_ORIENTATION_CHANGED = 1024; // 0x400

/** Adjustment option for {@link #softInputMode}: set to have a window
 * not adjust for a shown input method.  The window will not be resized,
 * and it will not be panned to make its focus visible.
 * @apiSince 11
 */

public static final int SOFT_INPUT_ADJUST_NOTHING = 48; // 0x30

/** Adjustment option for {@link #softInputMode}: set to have a window
 * pan when an input method is
 * shown, so it doesn't need to deal with resizing but just panned
 * by the framework to ensure the current input focus is visible.  This
 * can <em>not</em> be combined with {@link #SOFT_INPUT_ADJUST_RESIZE}; if
 * neither of these are set, then the system will try to pick one or
 * the other depending on the contents of the window.
 * @apiSince 3
 */

public static final int SOFT_INPUT_ADJUST_PAN = 32; // 0x20

/** Adjustment option for {@link #softInputMode}: set to allow the
 * window to be resized when an input
 * method is shown, so that its contents are not covered by the input
 * method.  This can <em>not</em> be combined with
 * {@link #SOFT_INPUT_ADJUST_PAN}; if
 * neither of these are set, then the system will try to pick one or
 * the other depending on the contents of the window. If the window's
 * layout parameter flags include {@link #FLAG_FULLSCREEN}, this
 * value for {@link #softInputMode} will be ignored; the window will
 * not resize, but will stay fullscreen.
 * @apiSince 3
 */

public static final int SOFT_INPUT_ADJUST_RESIZE = 16; // 0x10

/** Adjustment option for {@link #softInputMode}: nothing specified.
 * The system will try to pick one or
 * the other depending on the contents of the window.
 * @apiSince 3
 */

public static final int SOFT_INPUT_ADJUST_UNSPECIFIED = 0; // 0x0

/**
 * Bit for {@link #softInputMode}: set when the user has navigated
 * forward to the window.  This is normally set automatically for
 * you by the system, though you may want to set it in certain cases
 * when you are displaying a window yourself.  This flag will always
 * be cleared automatically after the window is displayed.
 * @apiSince 3
 */

public static final int SOFT_INPUT_IS_FORWARD_NAVIGATION = 256; // 0x100

/**
 * Mask for {@link #softInputMode} of the bits that determine the
 * way that the window should be adjusted to accommodate the soft
 * input window.
 * @apiSince 3
 */

public static final int SOFT_INPUT_MASK_ADJUST = 240; // 0xf0

/**
 * Mask for {@link #softInputMode} of the bits that determine the
 * desired visibility state of the soft input area for this window.
 * @apiSince 3
 */

public static final int SOFT_INPUT_MASK_STATE = 15; // 0xf

/** @apiSince 3 */

public static final int SOFT_INPUT_MODE_CHANGED = 512; // 0x200

/**
 * Visibility state for {@link #softInputMode}: please always hide any
 * soft input area when this window receives focus.
 * @apiSince 3
 */

public static final int SOFT_INPUT_STATE_ALWAYS_HIDDEN = 3; // 0x3

/**
 * Visibility state for {@link #softInputMode}: please always make the
 * soft input area visible when this window receives input focus.
 *
 * <p>Applications that target {@link android.os.Build.VERSION_CODES#P} and later, this flag
 * is ignored unless there is a focused view that returns {@code true} from
 * {@link android.view.View#isInEditMode() View#isInEditMode()} when the window is focused.</p>
 * @apiSince 3
 */

public static final int SOFT_INPUT_STATE_ALWAYS_VISIBLE = 5; // 0x5

/**
 * Visibility state for {@link #softInputMode}: please hide any soft input
 * area when normally appropriate (when the user is navigating
 * forward to your window).
 * @apiSince 3
 */

public static final int SOFT_INPUT_STATE_HIDDEN = 2; // 0x2

/**
 * Visibility state for {@link #softInputMode}: please don't change the state of
 * the soft input area.
 * @apiSince 3
 */

public static final int SOFT_INPUT_STATE_UNCHANGED = 1; // 0x1

/**
 * Visibility state for {@link #softInputMode}: no state has been specified. The system may
 * show or hide the software keyboard for better user experience when the window gains
 * focus.
 * @apiSince 3
 */

public static final int SOFT_INPUT_STATE_UNSPECIFIED = 0; // 0x0

/**
 * Visibility state for {@link #softInputMode}: please show the soft
 * input area when normally appropriate (when the user is navigating
 * forward to your window).
 *
 * <p>Applications that target {@link android.os.Build.VERSION_CODES#P} and later, this flag
 * is ignored unless there is a focused view that returns {@code true} from
 * {@link android.view.View#isInEditMode() View#isInEditMode()} when the window is focused.</p>
 * @apiSince 3
 */

public static final int SOFT_INPUT_STATE_VISIBLE = 4; // 0x4

/** @apiSince 1 */

public static final int TITLE_CHANGED = 64; // 0x40

/**
 * Window type: Windows that are overlaid <em>only</em> by a connected {@link
 * android.accessibilityservice.AccessibilityService} for interception of
 * user interactions without changing the windows an accessibility service
 * can introspect. In particular, an accessibility service can introspect
 * only windows that a sighted user can interact with which is they can touch
 * these windows or can type into these windows. For example, if there
 * is a full screen accessibility overlay that is touchable, the windows
 * below it will be introspectable by an accessibility service even though
 * they are covered by a touchable window.
 * @apiSince 22
 */

public static final int TYPE_ACCESSIBILITY_OVERLAY = 2032; // 0x7f0

/**
 * Window type: a normal application window.  The {@link #token} must be
 * an Activity token identifying who the window belongs to.
 * In multiuser systems shows only on the owning user's window.
 * @apiSince 1
 */

public static final int TYPE_APPLICATION = 2; // 0x2

/** Window type: like {@link #TYPE_APPLICATION_PANEL}, but layout
 * of the window happens as that of a top-level window, <em>not</em>
 * as a child of its container.
 * @apiSince 3
 */

public static final int TYPE_APPLICATION_ATTACHED_DIALOG = 1003; // 0x3eb

/**
 * Window type: window for showing media (such as video).  These windows
 * are displayed behind their attached window.
 * @apiSince 1
 */

public static final int TYPE_APPLICATION_MEDIA = 1001; // 0x3e9

/**
 * Window type: Application overlay windows are displayed above all activity windows
 * (types between {@link #FIRST_APPLICATION_WINDOW} and {@link #LAST_APPLICATION_WINDOW})
 * but below critical system windows like the status bar or IME.
 * <p>
 * The system may change the position, size, or visibility of these windows at anytime
 * to reduce visual clutter to the user and also manage resources.
 * <p>
 * Requires {@link android.Manifest.permission#SYSTEM_ALERT_WINDOW} permission.
 * <p>
 * The system will adjust the importance of processes with this window type to reduce the
 * chance of the low-memory-killer killing them.
 * <p>
 * In multi-user systems shows only on the owning user's screen.
 * @apiSince 26
 */

public static final int TYPE_APPLICATION_OVERLAY = 2038; // 0x7f6

/**
 * Window type: a panel on top of an application window.  These windows
 * appear on top of their attached window.
 * @apiSince 1
 */

public static final int TYPE_APPLICATION_PANEL = 1000; // 0x3e8

/**
 * Window type: special application window that is displayed while the
 * application is starting.  Not for use by applications themselves;
 * this is used by the system to display something until the
 * application can show its own windows.
 * In multiuser systems shows on all users' windows.
 * @apiSince 1
 */

public static final int TYPE_APPLICATION_STARTING = 3; // 0x3

/**
 * Window type: a sub-panel on top of an application window.  These
 * windows are displayed on top their attached window and any
 * {@link #TYPE_APPLICATION_PANEL} panels.
 * @apiSince 1
 */

public static final int TYPE_APPLICATION_SUB_PANEL = 1002; // 0x3ea

/**
 * Window type: an application window that serves as the "base" window
 * of the overall application; all other application windows will
 * appear on top of it.
 * In multiuser systems shows only on the owning user's window.
 * @apiSince 1
 */

public static final int TYPE_BASE_APPLICATION = 1; // 0x1

/** @apiSince 1 */

public static final int TYPE_CHANGED = 2; // 0x2

/**
 * Window type: a variation on TYPE_APPLICATION that ensures the window
 * manager will wait for this window to be drawn before the app is shown.
 * In multiuser systems shows only on the owning user's window.
 * @apiSince 25
 */

public static final int TYPE_DRAWN_APPLICATION = 4; // 0x4

/**
 * Window type: internal input methods windows, which appear above
 * the normal UI.  Application windows may be resized or panned to keep
 * the input focus visible while this window is displayed.
 * In multiuser systems shows only on the owning user's window.
 * @apiSince 3
 */

public static final int TYPE_INPUT_METHOD = 2011; // 0x7db

/**
 * Window type: internal input methods dialog windows, which appear above
 * the current input method window.
 * In multiuser systems shows only on the owning user's window.
 * @apiSince 3
 */

public static final int TYPE_INPUT_METHOD_DIALOG = 2012; // 0x7dc

/**
 * Window type: dialogs that the keyguard shows
 * In multiuser systems shows on all users' windows.
 * @apiSince 1
 */

public static final int TYPE_KEYGUARD_DIALOG = 2009; // 0x7d9

/**
 * Window type: phone.  These are non-application windows providing
 * user interaction with the phone (in particular incoming calls).
 * These windows are normally placed above all applications, but behind
 * the status bar.
 * In multiuser systems shows on all users' windows.
 * @deprecated for non-system apps. Use {@link #TYPE_APPLICATION_OVERLAY} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int TYPE_PHONE = 2002; // 0x7d2

/**
 * Window type: priority phone UI, which needs to be displayed even if
 * the keyguard is active.  These windows must not take input
 * focus, or they will interfere with the keyguard.
 * In multiuser systems shows on all users' windows.
 * @deprecated for non-system apps. Use {@link #TYPE_APPLICATION_OVERLAY} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int TYPE_PRIORITY_PHONE = 2007; // 0x7d7

/**
 * Window type: Window for Presentation on top of private
 * virtual display.
 * @apiSince 19
 */

public static final int TYPE_PRIVATE_PRESENTATION = 2030; // 0x7ee

/**
 * Window type: the search bar.  There can be only one search bar
 * window; it is placed at the top of the screen.
 * In multiuser systems shows on all users' windows.
 * @apiSince 1
 */

public static final int TYPE_SEARCH_BAR = 2001; // 0x7d1

/**
 * Window type: the status bar.  There can be only one status bar
 * window; it is placed at the top of the screen, and all other
 * windows are shifted down so they are below it.
 * In multiuser systems shows on all users' windows.
 * @apiSince 1
 */

public static final int TYPE_STATUS_BAR = 2000; // 0x7d0

/**
 * Window type: panel that slides out from over the status bar
 * In multiuser systems shows on all users' windows.
 * @apiSince 1
 */

public static final int TYPE_STATUS_BAR_PANEL = 2014; // 0x7de

/**
 * Window type: system window, such as low power alert. These windows
 * are always on top of application windows.
 * In multiuser systems shows only on the owning user's window.
 * @deprecated for non-system apps. Use {@link #TYPE_APPLICATION_OVERLAY} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int TYPE_SYSTEM_ALERT = 2003; // 0x7d3

/**
 * Window type: panel that slides out from the status bar
 * In multiuser systems shows on all users' windows.
 * @apiSince 1
 */

public static final int TYPE_SYSTEM_DIALOG = 2008; // 0x7d8

/**
 * Window type: internal system error windows, appear on top of
 * everything they can.
 * In multiuser systems shows only on the owning user's window.
 * @deprecated for non-system apps. Use {@link #TYPE_APPLICATION_OVERLAY} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int TYPE_SYSTEM_ERROR = 2010; // 0x7da

/**
 * Window type: system overlay windows, which need to be displayed
 * on top of everything else.  These windows must not take input
 * focus, or they will interfere with the keyguard.
 * In multiuser systems shows only on the owning user's window.
 * @deprecated for non-system apps. Use {@link #TYPE_APPLICATION_OVERLAY} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int TYPE_SYSTEM_OVERLAY = 2006; // 0x7d6

/**
 * Window type: transient notifications.
 * In multiuser systems shows only on the owning user's window.
 * @deprecated for non-system apps. Use {@link #TYPE_APPLICATION_OVERLAY} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int TYPE_TOAST = 2005; // 0x7d5

/**
 * Window type: wallpaper window, placed behind any window that wants
 * to sit on top of the wallpaper.
 * In multiuser systems shows only on the owning user's window.
 * @apiSince 5
 */

public static final int TYPE_WALLPAPER = 2013; // 0x7dd

/**
 * An alpha value to apply to this entire window.
 * An alpha of 1.0 means fully opaque and 0.0 means fully transparent
 * @apiSince 1
 */

public float alpha = 1.0f;

/**
 * This can be used to override the standard behavior of the button and
 * keyboard backlights.  A value of less than 0, the default, means to
 * use the standard backlight behavior.  0 to 1 adjusts the brightness
 * from dark to full bright.
 * @apiSince 8
 */

public float buttonBrightness = -1.0f;

/**
 * When {@link #FLAG_DIM_BEHIND} is set, this is the amount of dimming
 * to apply.  Range is from 1.0 for completely opaque to 0.0 for no
 * dim.
 * @apiSince 1
 */

public float dimAmount = 1.0f;

/**
 * Various behavioral options/flags.  Default is none.
 *
 * @see #FLAG_ALLOW_LOCK_WHILE_SCREEN_ON
 * @see #FLAG_DIM_BEHIND
 * @see #FLAG_NOT_FOCUSABLE
 * @see #FLAG_NOT_TOUCHABLE
 * @see #FLAG_NOT_TOUCH_MODAL
 * @see #FLAG_TOUCHABLE_WHEN_WAKING
 * @see #FLAG_KEEP_SCREEN_ON
 * @see #FLAG_LAYOUT_IN_SCREEN
 * @see #FLAG_LAYOUT_NO_LIMITS
 * @see #FLAG_FULLSCREEN
 * @see #FLAG_FORCE_NOT_FULLSCREEN
 * @see #FLAG_SECURE
 * @see #FLAG_SCALED
 * @see #FLAG_IGNORE_CHEEK_PRESSES
 * @see #FLAG_LAYOUT_INSET_DECOR
 * @see #FLAG_ALT_FOCUSABLE_IM
 * @see #FLAG_WATCH_OUTSIDE_TOUCH
 * @see #FLAG_SHOW_WHEN_LOCKED
 * @see #FLAG_SHOW_WALLPAPER
 * @see #FLAG_TURN_SCREEN_ON
 * @see #FLAG_DISMISS_KEYGUARD
 * @see #FLAG_SPLIT_TOUCH
 * @see #FLAG_HARDWARE_ACCELERATED
 * @see #FLAG_LOCAL_FOCUS_MODE
 * @see #FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(flagMapping={@android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON, equals=android.view.WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON, name="ALLOW_LOCK_WHILE_SCREEN_ON"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_DIM_BEHIND, equals=android.view.WindowManager.LayoutParams.FLAG_DIM_BEHIND, name="DIM_BEHIND"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_BLUR_BEHIND, equals=android.view.WindowManager.LayoutParams.FLAG_BLUR_BEHIND, name="BLUR_BEHIND"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, equals=android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, name="NOT_FOCUSABLE"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, equals=android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, name="NOT_TOUCHABLE"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, equals=android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, name="NOT_TOUCH_MODAL"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_TOUCHABLE_WHEN_WAKING, equals=android.view.WindowManager.LayoutParams.FLAG_TOUCHABLE_WHEN_WAKING, name="TOUCHABLE_WHEN_WAKING"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, equals=android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, name="KEEP_SCREEN_ON"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, equals=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, name="LAYOUT_IN_SCREEN"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, equals=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, name="LAYOUT_NO_LIMITS"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN, equals=android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN, name="FULLSCREEN"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, equals=android.view.WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, name="FORCE_NOT_FULLSCREEN"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_DITHER, equals=android.view.WindowManager.LayoutParams.FLAG_DITHER, name="DITHER"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_SECURE, equals=android.view.WindowManager.LayoutParams.FLAG_SECURE, name="SECURE"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_SCALED, equals=android.view.WindowManager.LayoutParams.FLAG_SCALED, name="SCALED"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES, equals=android.view.WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES, name="IGNORE_CHEEK_PRESSES"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR, equals=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR, name="LAYOUT_INSET_DECOR"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, equals=android.view.WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, name="ALT_FOCUSABLE_IM"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, equals=android.view.WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, name="WATCH_OUTSIDE_TOUCH"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED, equals=android.view.WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED, name="SHOW_WHEN_LOCKED"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER, equals=android.view.WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER, name="SHOW_WALLPAPER"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON, equals=android.view.WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON, name="TURN_SCREEN_ON"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD, equals=android.view.WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD, name="DISMISS_KEYGUARD"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_SPLIT_TOUCH, equals=android.view.WindowManager.LayoutParams.FLAG_SPLIT_TOUCH, name="SPLIT_TOUCH"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, equals=android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, name="HARDWARE_ACCELERATED"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN, equals=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN, name="LOCAL_FOCUS_MODE"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, equals=android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, name="TRANSLUCENT_STATUS"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, equals=android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, name="TRANSLUCENT_NAVIGATION"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_LOCAL_FOCUS_MODE, equals=android.view.WindowManager.LayoutParams.FLAG_LOCAL_FOCUS_MODE, name="LOCAL_FOCUS_MODE"), @android.view.ViewDebug.FlagToString(mask=0x20000000, equals=0x20000000, name="FLAG_SLIPPERY"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_ATTACHED_IN_DECOR, equals=android.view.WindowManager.LayoutParams.FLAG_LAYOUT_ATTACHED_IN_DECOR, name="FLAG_LAYOUT_ATTACHED_IN_DECOR"), @android.view.ViewDebug.FlagToString(mask=android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, equals=android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, name="DRAWS_SYSTEM_BAR_BACKGROUNDS")}, formatToHexString=true) public int flags;

/**
 * The desired bitmap format.  May be one of the constants in
 * {@link android.graphics.PixelFormat}. The choice of format
 * might be overridden by {@link #setColorMode(int)}. Default is OPAQUE.
 * @apiSince 1
 */

public int format;

/**
 * Placement of window within the screen as per {@link android.view.Gravity Gravity}.  Both
 * {@link android.view.Gravity#apply(int,int,int,android.graphics.Rect,int,int,android.graphics.Rect) Gravity#apply(int, int, int, android.graphics.Rect, int, int,
 * android.graphics.Rect)} and
 * {@link android.view.Gravity#applyDisplay(int,android.graphics.Rect,android.graphics.Rect) Gravity#applyDisplay(int, android.graphics.Rect, android.graphics.Rect)} are used during window layout, with this value
 * given as the desired gravity.  For example you can specify
 * {@link android.view.Gravity#DISPLAY_CLIP_HORIZONTAL Gravity#DISPLAY_CLIP_HORIZONTAL} and
 * {@link android.view.Gravity#DISPLAY_CLIP_VERTICAL Gravity#DISPLAY_CLIP_VERTICAL} here
 * to control the behavior of
 * {@link android.view.Gravity#applyDisplay(int,android.graphics.Rect,android.graphics.Rect) Gravity#applyDisplay(int, android.graphics.Rect, android.graphics.Rect)}.
 *
 * @see android.view.Gravity
 * @apiSince 1
 */

public int gravity;

/**
 * The horizontal margin, as a percentage of the container's width,
 * between the container and the widget.  See
 * {@link android.view.Gravity#apply(int,int,int,android.graphics.Rect,int,int,android.graphics.Rect) Gravity#apply(int, int, int, android.graphics.Rect, int, int,
 * android.graphics.Rect)} for how this is used.  This
 * field is added with {@link #x} to supply the <var>xAdj</var> parameter.
 * @apiSince 1
 */

public float horizontalMargin;

/**
 * Indicates how much of the extra space will be allocated horizontally
 * to the view associated with these LayoutParams. Specify 0 if the view
 * should not be stretched. Otherwise the extra pixels will be pro-rated
 * among all views whose weight is greater than 0.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty public float horizontalWeight;

/**
 * Controls how the window is laid out if there is a {@link android.view.DisplayCutout DisplayCutout}.
 *
 * <p>
 * Defaults to {@link #LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT}.
 *
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.view.WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT}, {@link android.view.WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES}, and {@link android.view.WindowManager.LayoutParams#LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER}
 * @see #LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
 * @see #LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
 * @see #LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER
 * @see android.view.DisplayCutout
 * @see android.R.attr#windowLayoutInDisplayCutoutMode
 *         android:windowLayoutInDisplayCutoutMode
 * @apiSince 28
 */

public int layoutInDisplayCutoutMode = 0; // 0x0

/**
 * @deprecated this is ignored
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public int memoryType;

/**
 * Name of the package owning this window.
 * @apiSince 1
 */

public java.lang.String packageName;

/**
 * Id of the preferred display mode for the window.
 * <p>
 * This must be one of the supported modes obtained for the display(s) the window is on.
 * A value of {@code 0} means no preference.
 *
 * @see android.view.Display#getSupportedModes()
 * @see android.view.Display.Mode#getModeId()
 * @apiSince 23
 */

public int preferredDisplayModeId;

/**
 * The preferred refresh rate for the window.
 *
 * This must be one of the supported refresh rates obtained for the display(s) the window
 * is on. The selected refresh rate will be applied to the display's default mode.
 *
 * This value is ignored if {@link #preferredDisplayModeId} is set.
 *
 * @see android.view.Display#getSupportedRefreshRates()
 * @deprecated use {@link #preferredDisplayModeId} instead
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated public float preferredRefreshRate;

/**
 * Define the exit and entry animations used on this window when the device is rotated.
 * This only has an affect if the incoming and outgoing topmost
 * opaque windows have the #FLAG_FULLSCREEN bit set and are not covered
 * by other windows. All other situations default to the
 * {@link #ROTATION_ANIMATION_ROTATE} behavior.
 *
 * @see #ROTATION_ANIMATION_ROTATE
 * @see #ROTATION_ANIMATION_CROSSFADE
 * @see #ROTATION_ANIMATION_JUMPCUT
 * @apiSince 18
 */

public int rotationAnimation = 0; // 0x0

/**
 * This can be used to override the user's preferred brightness of
 * the screen.  A value of less than 0, the default, means to use the
 * preferred screen brightness.  0 to 1 adjusts the brightness from
 * dark to full bright.
 * @apiSince 3
 */

public float screenBrightness = -1.0f;

/**
 * Specific orientation value for a window.
 * May be any of the same values allowed
 * for {@link android.content.pm.ActivityInfo#screenOrientation}.
 * If not set, a default value of
 * {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_UNSPECIFIED}
 * will be used.
 * @apiSince 3
 */

public int screenOrientation = -1; // 0xffffffff

/**
 * Desired operating mode for any soft input area.  May be any combination
 * of:
 *
 * <ul>
 * <li> One of the visibility states
 * {@link #SOFT_INPUT_STATE_UNSPECIFIED}, {@link #SOFT_INPUT_STATE_UNCHANGED},
 * {@link #SOFT_INPUT_STATE_HIDDEN}, {@link #SOFT_INPUT_STATE_ALWAYS_HIDDEN},
 * {@link #SOFT_INPUT_STATE_VISIBLE}, or {@link #SOFT_INPUT_STATE_ALWAYS_VISIBLE}.
 * <li> One of the adjustment options
 * {@link #SOFT_INPUT_ADJUST_UNSPECIFIED}, {@link #SOFT_INPUT_ADJUST_RESIZE},
 * {@link #SOFT_INPUT_ADJUST_PAN}, or {@link #SOFT_INPUT_ADJUST_NOTHING}.
 * </ul>
 *
 *
 * <p>This flag can be controlled in your theme through the
 * {@link android.R.attr#windowSoftInputMode} attribute.</p>
 
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNCHANGED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_RESIZE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_PAN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_NOTHING}, and {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_IS_FORWARD_NAVIGATION}
 * @apiSince 3
 */

public int softInputMode;

/**
 * Control the visibility of the status bar.
 *
 * @see android.view.View#STATUS_BAR_VISIBLE
 * @see android.view.View#STATUS_BAR_HIDDEN
 * @apiSince 11
 */

public int systemUiVisibility;

/**
 * Identifier for this window.  This will usually be filled in for
 * you.
 * @apiSince 1
 */

public android.os.IBinder token;

/**
 * The general type of window.  There are three main classes of
 * window types:
 * <ul>
 * <li> <strong>Application windows</strong> (ranging from
 * {@link #FIRST_APPLICATION_WINDOW} to
 * {@link #LAST_APPLICATION_WINDOW}) are normal top-level application
 * windows.  For these types of windows, the {@link #token} must be
 * set to the token of the activity they are a part of (this will
 * normally be done for you if {@link #token} is null).
 * <li> <strong>Sub-windows</strong> (ranging from
 * {@link #FIRST_SUB_WINDOW} to
 * {@link #LAST_SUB_WINDOW}) are associated with another top-level
 * window.  For these types of windows, the {@link #token} must be
 * the token of the window it is attached to.
 * <li> <strong>System windows</strong> (ranging from
 * {@link #FIRST_SYSTEM_WINDOW} to
 * {@link #LAST_SYSTEM_WINDOW}) are special types of windows for
 * use by the system for specific purposes.  They should not normally
 * be used by applications, and a special permission is required
 * to use them.
 * </ul>
 *
 * @see #TYPE_BASE_APPLICATION
 * @see #TYPE_APPLICATION
 * @see #TYPE_APPLICATION_STARTING
 * @see #TYPE_DRAWN_APPLICATION
 * @see #TYPE_APPLICATION_PANEL
 * @see #TYPE_APPLICATION_MEDIA
 * @see #TYPE_APPLICATION_SUB_PANEL
 * @see #TYPE_APPLICATION_ATTACHED_DIALOG
 * @see #TYPE_STATUS_BAR
 * @see #TYPE_SEARCH_BAR
 * @see #TYPE_PHONE
 * @see #TYPE_SYSTEM_ALERT
 * @see #TYPE_TOAST
 * @see #TYPE_SYSTEM_OVERLAY
 * @see #TYPE_PRIORITY_PHONE
 * @see #TYPE_STATUS_BAR_PANEL
 * @see #TYPE_SYSTEM_DIALOG
 * @see #TYPE_KEYGUARD_DIALOG
 * @see #TYPE_SYSTEM_ERROR
 * @see #TYPE_INPUT_METHOD
 * @see #TYPE_INPUT_METHOD_DIALOG
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(mapping={@android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_BASE_APPLICATION, to="BASE_APPLICATION"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_APPLICATION, to="APPLICATION"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_APPLICATION_STARTING, to="APPLICATION_STARTING"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_DRAWN_APPLICATION, to="DRAWN_APPLICATION"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_APPLICATION_PANEL, to="APPLICATION_PANEL"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA, to="APPLICATION_MEDIA"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL, to="APPLICATION_SUB_PANEL"), @android.view.ViewDebug.IntToString(from=0x3ed, to="APPLICATION_ABOVE_SUB_PANEL"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG, to="APPLICATION_ATTACHED_DIALOG"), @android.view.ViewDebug.IntToString(from=0x3ec, to="APPLICATION_MEDIA_OVERLAY"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_STATUS_BAR, to="STATUS_BAR"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_SEARCH_BAR, to="SEARCH_BAR"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_PHONE, to="PHONE"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ALERT, to="SYSTEM_ALERT"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_TOAST, to="TOAST"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY, to="SYSTEM_OVERLAY"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_PRIORITY_PHONE, to="PRIORITY_PHONE"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG, to="SYSTEM_DIALOG"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG, to="KEYGUARD_DIALOG"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ERROR, to="SYSTEM_ERROR"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_INPUT_METHOD, to="INPUT_METHOD"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_INPUT_METHOD_DIALOG, to="INPUT_METHOD_DIALOG"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_WALLPAPER, to="WALLPAPER"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL, to="STATUS_BAR_PANEL"), @android.view.ViewDebug.IntToString(from=0x7df, to="SECURE_SYSTEM_OVERLAY"), @android.view.ViewDebug.IntToString(from=0x7e0, to="DRAG"), @android.view.ViewDebug.IntToString(from=0x7e1, to="STATUS_BAR_SUB_PANEL"), @android.view.ViewDebug.IntToString(from=0x7e2, to="POINTER"), @android.view.ViewDebug.IntToString(from=0x7e3, to="NAVIGATION_BAR"), @android.view.ViewDebug.IntToString(from=0x7e4, to="VOLUME_OVERLAY"), @android.view.ViewDebug.IntToString(from=0x7e5, to="BOOT_PROGRESS"), @android.view.ViewDebug.IntToString(from=0x7e6, to="INPUT_CONSUMER"), @android.view.ViewDebug.IntToString(from=0x7e7, to="DREAM"), @android.view.ViewDebug.IntToString(from=0x7e8, to="NAVIGATION_BAR_PANEL"), @android.view.ViewDebug.IntToString(from=0x7ea, to="DISPLAY_OVERLAY"), @android.view.ViewDebug.IntToString(from=0x7eb, to="MAGNIFICATION_OVERLAY"), @android.view.ViewDebug.IntToString(from=0x7f5, to="PRESENTATION"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_PRIVATE_PRESENTATION, to="PRIVATE_PRESENTATION"), @android.view.ViewDebug.IntToString(from=0x7ef, to="VOICE_INTERACTION"), @android.view.ViewDebug.IntToString(from=0x7f1, to="VOICE_INTERACTION_STARTING"), @android.view.ViewDebug.IntToString(from=0x7f2, to="DOCK_DIVIDER"), @android.view.ViewDebug.IntToString(from=0x7f3, to="QS_DIALOG"), @android.view.ViewDebug.IntToString(from=0x7f4, to="SCREENSHOT"), @android.view.ViewDebug.IntToString(from=android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, to="APPLICATION_OVERLAY")}) public int type;

/**
 * The vertical margin, as a percentage of the container's height,
 * between the container and the widget.  See
 * {@link android.view.Gravity#apply(int,int,int,android.graphics.Rect,int,int,android.graphics.Rect) Gravity#apply(int, int, int, android.graphics.Rect, int, int,
 * android.graphics.Rect)} for how this is used.  This
 * field is added with {@link #y} to supply the <var>yAdj</var> parameter.
 * @apiSince 1
 */

public float verticalMargin;

/**
 * Indicates how much of the extra space will be allocated vertically
 * to the view associated with these LayoutParams. Specify 0 if the view
 * should not be stretched. Otherwise the extra pixels will be pro-rated
 * among all views whose weight is greater than 0.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty public float verticalWeight;

/**
 * A style resource defining the animations to use for this window.
 * This must be a system resource; it can not be an application resource
 * because the window manager does not have access to applications.
 * @apiSince 1
 */

public int windowAnimations;

/**
 * X position for this window.  With the default gravity it is ignored.
 * When using {@link android.view.Gravity#LEFT Gravity#LEFT} or {@link android.view.Gravity#START Gravity#START} or {@link android.view.Gravity#RIGHT Gravity#RIGHT} or
 * {@link android.view.Gravity#END Gravity#END} it provides an offset from the given edge.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty public int x;

/**
 * Y position for this window.  With the default gravity it is ignored.
 * When using {@link android.view.Gravity#TOP Gravity#TOP} or {@link android.view.Gravity#BOTTOM Gravity#BOTTOM} it provides
 * an offset from the given edge.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty public int y;
}

}

