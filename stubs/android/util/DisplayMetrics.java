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


package android.util;


/**
 * A structure describing general information about a display, such as its
 * size, density, and font scaling.
 * <p>To access the DisplayMetrics members, initialize an object like this:</p>
 * <pre> DisplayMetrics metrics = new DisplayMetrics();
 * getWindowManager().getDefaultDisplay().getMetrics(metrics);</pre>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DisplayMetrics {

/** @apiSince 1 */

public DisplayMetrics() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setTo(android.util.DisplayMetrics o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setToDefaults() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if these display metrics equal the other display metrics.
 *
 * @param other The display metrics with which to compare.
 * @return True if the display metrics are equal.
 * @apiSince 17
 */

public boolean equals(android.util.DisplayMetrics other) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Intermediate density for screens that sit between {@link #DENSITY_LOW} (120dpi) and
 * {@link #DENSITY_MEDIUM} (160dpi). This is not a density that applications should target,
 * instead relying on the system to scale their {@link #DENSITY_MEDIUM} assets for them.
 * @apiSince 29
 */

public static final int DENSITY_140 = 140; // 0x8c

/**
 * Intermediate density for screens that sit between {@link #DENSITY_MEDIUM} (160dpi) and
 * {@link #DENSITY_HIGH} (240dpi). This is not a density that applications should target,
 * instead relying on the system to scale their {@link #DENSITY_HIGH} assets for them.
 * @apiSince 29
 */

public static final int DENSITY_180 = 180; // 0xb4

/**
 * Intermediate density for screens that sit between {@link #DENSITY_MEDIUM} (160dpi) and
 * {@link #DENSITY_HIGH} (240dpi). This is not a density that applications should target,
 * instead relying on the system to scale their {@link #DENSITY_HIGH} assets for them.
 * @apiSince 29
 */

public static final int DENSITY_200 = 200; // 0xc8

/**
 * Intermediate density for screens that sit between {@link #DENSITY_MEDIUM} (160dpi) and
 * {@link #DENSITY_HIGH} (240dpi). This is not a density that applications should target,
 * instead relying on the system to scale their {@link #DENSITY_HIGH} assets for them.
 * @apiSince 29
 */

public static final int DENSITY_220 = 220; // 0xdc

/**
 * Intermediate density for screens that sit between {@link #DENSITY_HIGH} (240dpi) and
 * {@link #DENSITY_XHIGH} (320dpi). This is not a density that applications should target,
 * instead relying on the system to scale their {@link #DENSITY_XHIGH} assets for them.
 * @apiSince 25
 */

public static final int DENSITY_260 = 260; // 0x104

/**
 * Intermediate density for screens that sit between {@link #DENSITY_HIGH} (240dpi) and
 * {@link #DENSITY_XHIGH} (320dpi). This is not a density that applications should target,
 * instead relying on the system to scale their {@link #DENSITY_XHIGH} assets for them.
 * @apiSince 22
 */

public static final int DENSITY_280 = 280; // 0x118

/**
 * Intermediate density for screens that sit between {@link #DENSITY_HIGH} (240dpi) and
 * {@link #DENSITY_XHIGH} (320dpi). This is not a density that applications should target,
 * instead relying on the system to scale their {@link #DENSITY_XHIGH} assets for them.
 * @apiSince 25
 */

public static final int DENSITY_300 = 300; // 0x12c

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XHIGH} (320 dpi) and {@link #DENSITY_XXHIGH} (480 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXHIGH} assets for them.
 * @apiSince 25
 */

public static final int DENSITY_340 = 340; // 0x154

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XHIGH} (320 dpi) and {@link #DENSITY_XXHIGH} (480 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXHIGH} assets for them.
 * @apiSince 23
 */

public static final int DENSITY_360 = 360; // 0x168

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XHIGH} (320 dpi) and {@link #DENSITY_XXHIGH} (480 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXHIGH} assets for them.
 * @apiSince 19
 */

public static final int DENSITY_400 = 400; // 0x190

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XHIGH} (320 dpi) and {@link #DENSITY_XXHIGH} (480 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXHIGH} assets for them.
 * @apiSince 23
 */

public static final int DENSITY_420 = 420; // 0x1a4

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XHIGH} (320 dpi) and {@link #DENSITY_XXHIGH} (480 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXHIGH} assets for them.
 * @apiSince 28
 */

public static final int DENSITY_440 = 440; // 0x1b8

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XHIGH} (320 dpi) and {@link #DENSITY_XXHIGH} (480 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXHIGH} assets for them.
 * @apiSince 29
 */

public static final int DENSITY_450 = 450; // 0x1c2

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XXHIGH} (480 dpi) and {@link #DENSITY_XXXHIGH} (640 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXXHIGH} assets for them.
 * @apiSince 21
 */

public static final int DENSITY_560 = 560; // 0x230

/**
 * Intermediate density for screens that sit somewhere between
 * {@link #DENSITY_XXHIGH} (480 dpi) and {@link #DENSITY_XXXHIGH} (640 dpi).
 * This is not a density that applications should target, instead relying
 * on the system to scale their {@link #DENSITY_XXXHIGH} assets for them.
 * @apiSince 29
 */

public static final int DENSITY_600 = 600; // 0x258

/**
 * The reference density used throughout the system.
 * @apiSince 4
 */

public static final int DENSITY_DEFAULT = 160; // 0xa0

/**
 * The device's stable density.
 * <p>
 * This value is constant at run time and may not reflect the current
 * display density. To obtain the current density for a specific display,
 * use {@link #densityDpi}.
 * @apiSince 24
 */

public static final int DENSITY_DEVICE_STABLE;
static { DENSITY_DEVICE_STABLE = 0; }

/**
 * Standard quantized DPI for high-density screens.
 * @apiSince 4
 */

public static final int DENSITY_HIGH = 240; // 0xf0

/**
 * Standard quantized DPI for low-density screens.
 * @apiSince 4
 */

public static final int DENSITY_LOW = 120; // 0x78

/**
 * Standard quantized DPI for medium-density screens.
 * @apiSince 4
 */

public static final int DENSITY_MEDIUM = 160; // 0xa0

/**
 * This is a secondary density, added for some common screen configurations.
 * It is recommended that applications not generally target this as a first
 * class density -- that is, don't supply specific graphics for this
 * density, instead allow the platform to scale from other densities
 * (typically {@link #DENSITY_HIGH}) as
 * appropriate.  In most cases (such as using bitmaps in
 * {@link android.graphics.drawable.Drawable}) the platform
 * can perform this scaling at load time, so the only cost is some slight
 * startup runtime overhead.
 *
 * <p>This density was original introduced to correspond with a
 * 720p TV screen: the density for 1080p televisions is
 * {@link #DENSITY_XHIGH}, and the value here provides the same UI
 * size for a TV running at 720p.  It has also found use in 7" tablets,
 * when these devices have 1280x720 displays.
 * @apiSince 13
 */

public static final int DENSITY_TV = 213; // 0xd5

/**
 * Standard quantized DPI for extra-high-density screens.
 * @apiSince 9
 */

public static final int DENSITY_XHIGH = 320; // 0x140

/**
 * Standard quantized DPI for extra-extra-high-density screens.
 * @apiSince 16
 */

public static final int DENSITY_XXHIGH = 480; // 0x1e0

/**
 * Standard quantized DPI for extra-extra-extra-high-density screens.  Applications
 * should not generally worry about this density; relying on XHIGH graphics
 * being scaled up to it should be sufficient for almost all cases.  A typical
 * use of this density would be 4K television screens -- 3840x2160, which
 * is 2x a traditional HD 1920x1080 screen which runs at DENSITY_XHIGH.
 * @apiSince 18
 */

public static final int DENSITY_XXXHIGH = 640; // 0x280

/**
 * The logical density of the display.  This is a scaling factor for the
 * Density Independent Pixel unit, where one DIP is one pixel on an
 * approximately 160 dpi screen (for example a 240x320, 1.5"x2" screen),
 * providing the baseline of the system's display. Thus on a 160dpi screen
 * this density value will be 1; on a 120 dpi screen it would be .75; etc.
 *
 * <p>This value does not exactly follow the real screen size (as given by
 * {@link #xdpi} and {@link #ydpi}, but rather is used to scale the size of
 * the overall UI in steps based on gross changes in the display dpi.  For
 * example, a 240x320 screen will have a density of 1 even if its width is
 * 1.8", 1.3", etc. However, if the screen resolution is increased to
 * 320x480 but the screen size remained 1.5"x2" then the density would be
 * increased (probably to 1.5).
 *
 * @see #DENSITY_DEFAULT
 * @apiSince 1
 */

public float density;

/**
 * The screen density expressed as dots-per-inch.  May be either
 * {@link #DENSITY_LOW}, {@link #DENSITY_MEDIUM}, or {@link #DENSITY_HIGH}.
 * @apiSince 4
 */

public int densityDpi;

/**
 * The absolute height of the available display size in pixels.
 * @apiSince 1
 */

public int heightPixels;

/**
 * A scaling factor for fonts displayed on the display.  This is the same
 * as {@link #density}, except that it may be adjusted in smaller
 * increments at runtime based on a user preference for the font size.
 * @apiSince 1
 */

public float scaledDensity;

/**
 * The absolute width of the available display size in pixels.
 * @apiSince 1
 */

public int widthPixels;

/**
 * The exact physical pixels per inch of the screen in the X dimension.
 * @apiSince 1
 */

public float xdpi;

/**
 * The exact physical pixels per inch of the screen in the Y dimension.
 * @apiSince 1
 */

public float ydpi;
}

