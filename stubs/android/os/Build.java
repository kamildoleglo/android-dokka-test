/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.os;

import android.Manifest;
import android.content.Context;
import android.view.View;
import android.app.Application;

/**
 * Information about the current build, extracted from system properties.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Build {

public Build() { throw new RuntimeException("Stub!"); }

/**
 * Gets the hardware serial number, if available.
 *
 * <p class="note"><b>Note:</b> Root access may allow you to modify device identifiers, such as
 * the hardware serial number. If you change these identifiers, you can use
 * <a href="/training/articles/security-key-attestation.html">key attestation</a> to obtain
 * proof of the device's original identifiers.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link android.telephony.TelephonyManager#hasCarrierPrivileges}). The profile
 * owner is an app that owns a managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then {@link android.os.Build#UNKNOWN Build#UNKNOWN} is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 * *
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @return The serial number if specified.
 * @apiSince 26
 */

public static java.lang.String getSerial() { throw new RuntimeException("Stub!"); }

/**
 * Get build information about partitions that have a separate fingerprint defined.
 *
 * The list includes partitions that are suitable candidates for over-the-air updates. This is
 * not an exhaustive list of partitions on the device.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static java.util.List<android.os.Build.Partition> getFingerprintedPartitions() { throw new RuntimeException("Stub!"); }

/**
 * Returns the version string for the radio firmware.  May return
 * null (if, for instance, the radio is not currently on).
 * @apiSince 14
 */

public static java.lang.String getRadioVersion() { throw new RuntimeException("Stub!"); }

/**
 * The name of the underlying board, like "goldfish".
 * @apiSince 1
 */

public static final java.lang.String BOARD;
static { BOARD = null; }

/**
 * The system bootloader version number.
 * @apiSince 8
 */

public static final java.lang.String BOOTLOADER;
static { BOOTLOADER = null; }

/**
 * The consumer-visible brand with which the product/hardware will be associated, if any.
 * @apiSince 1
 */

public static final java.lang.String BRAND;
static { BRAND = null; }

/**
 * The name of the instruction set (CPU type + ABI convention) of native code.
 *
 * @deprecated Use {@link #SUPPORTED_ABIS} instead.
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String CPU_ABI;
static { CPU_ABI = null; }

/**
 * The name of the second instruction set (CPU type + ABI convention) of native code.
 *
 * @deprecated Use {@link #SUPPORTED_ABIS} instead.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String CPU_ABI2;
static { CPU_ABI2 = null; }

/**
 * The name of the industrial design.
 * @apiSince 1
 */

public static final java.lang.String DEVICE;
static { DEVICE = null; }

/**
 * A build ID string meant for displaying to the user
 * @apiSince 3
 */

public static final java.lang.String DISPLAY;
static { DISPLAY = null; }

/**
 * A string that uniquely identifies this build.  Do not attempt to parse this value.
 * @apiSince 1
 */

public static final java.lang.String FINGERPRINT;
static { FINGERPRINT = null; }

/**
 * The name of the hardware (from the kernel command line or /proc).
 * @apiSince 8
 */

public static final java.lang.String HARDWARE;
static { HARDWARE = null; }

/** @apiSince 1 */

public static final java.lang.String HOST;
static { HOST = null; }

/**
 * Either a changelist number, or a label like "M4-rc20".
 * @apiSince 1
 */

public static final java.lang.String ID;
static { ID = null; }

/**
 * The manufacturer of the product/hardware.
 * @apiSince 4
 */

public static final java.lang.String MANUFACTURER;
static { MANUFACTURER = null; }

/**
 * The end-user-visible name for the end product.
 * @apiSince 1
 */

public static final java.lang.String MODEL;
static { MODEL = null; }

/**
 * The name of the overall product.
 * @apiSince 1
 */

public static final java.lang.String PRODUCT;
static { PRODUCT = null; }

/**
 * The radio firmware version number.
 *
 * @deprecated The radio firmware version is frequently not
 * available when this class is initialized, leading to a blank or
 * "unknown" value for this string.  Use
 * {@link #getRadioVersion} instead.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String RADIO;
static { RADIO = null; }

/**
 * A hardware serial number, if available. Alphanumeric only, case-insensitive.
 * This field is always set to {@link android.os.Build#UNKNOWN Build#UNKNOWN}.
 *
 * @deprecated Use {@link #getSerial()} instead.
 *     * @apiSince 9
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String SERIAL;
static { SERIAL = null; }

/**
 * An ordered list of <b>32 bit</b> ABIs supported by this device. The most preferred ABI
 * is the first element in the list.
 *
 * See {@link #SUPPORTED_ABIS} and {@link #SUPPORTED_64_BIT_ABIS}.
 * @apiSince 21
 */

public static final java.lang.String[] SUPPORTED_32_BIT_ABIS;
static { SUPPORTED_32_BIT_ABIS = new java.lang.String[0]; }

/**
 * An ordered list of <b>64 bit</b> ABIs supported by this device. The most preferred ABI
 * is the first element in the list.
 *
 * See {@link #SUPPORTED_ABIS} and {@link #SUPPORTED_32_BIT_ABIS}.
 * @apiSince 21
 */

public static final java.lang.String[] SUPPORTED_64_BIT_ABIS;
static { SUPPORTED_64_BIT_ABIS = new java.lang.String[0]; }

/**
 * An ordered list of ABIs supported by this device. The most preferred ABI is the first
 * element in the list.
 *
 * See {@link #SUPPORTED_32_BIT_ABIS} and {@link #SUPPORTED_64_BIT_ABIS}.
 * @apiSince 21
 */

public static final java.lang.String[] SUPPORTED_ABIS;
static { SUPPORTED_ABIS = new java.lang.String[0]; }

/**
 * Comma-separated tags describing the build, like "unsigned,debug".
 * @apiSince 1
 */

public static final java.lang.String TAGS;
static { TAGS = null; }

/**
 * The time at which the build was produced, given in milliseconds since the UNIX epoch.
 * @apiSince 1
 */

public static final long TIME;
static { TIME = 0; }

/**
 * The type of build, like "user" or "eng".
 * @apiSince 1
 */

public static final java.lang.String TYPE;
static { TYPE = null; }

/**
 * Value used for when a build property is unknown.
 * @apiSince 8
 */

public static final java.lang.String UNKNOWN = "unknown";

/** @apiSince 1 */

public static final java.lang.String USER;
static { USER = null; }
/**
 * Build information for a particular device partition.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Partition {

private Partition() { throw new RuntimeException("Stub!"); }

/**
 * The name of this partition, e.g.&nbsp;"system", or "vendor"
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * The build fingerprint of this partition, see {@link android.os.Build#FINGERPRINT Build#FINGERPRINT}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getFingerprint() { throw new RuntimeException("Stub!"); }

/**
 * The time (ms since epoch), at which this partition was built, see {@link android.os.Build#TIME Build#TIME}.
 * @apiSince 29
 */

public long getBuildTimeMillis() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * The name identifying the system partition.
 * @apiSince 29
 */

public static final java.lang.String PARTITION_NAME_SYSTEM = "system";
}

/**
 * Various version strings.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class VERSION {

public VERSION() { throw new RuntimeException("Stub!"); }

/**
 * The base OS build the product is based on.
 * @apiSince 23
 */

public static final java.lang.String BASE_OS;
static { BASE_OS = null; }

/**
 * The current development codename, or the string "REL" if this is
 * a release build.
 * @apiSince 4
 */

public static final java.lang.String CODENAME;
static { CODENAME = null; }

/**
 * The internal value used by the underlying source control to
 * represent this build.  E.g., a perforce changelist number
 * or a git hash.
 * @apiSince 1
 */

public static final java.lang.String INCREMENTAL;
static { INCREMENTAL = null; }

/**
 * The developer preview revision of a prerelease SDK. This value will always
 * be <code>0</code> on production platform builds/devices.
 *
 * <p>When this value is nonzero, any new API added since the last
 * officially published {@link #SDK_INT API level} is only guaranteed to be present
 * on that specific preview revision. For example, an API <code>Activity.fooBar()</code>
 * might be present in preview revision 1 but renamed or removed entirely in
 * preview revision 2, which may cause an app attempting to call it to crash
 * at runtime.</p>
 *
 * <p>Experimental apps targeting preview APIs should check this value for
 * equality (<code>==</code>) with the preview SDK revision they were built for
 * before using any prerelease platform APIs. Apps that detect a preview SDK revision
 * other than the specific one they expect should fall back to using APIs from
 * the previously published API level only to avoid unwanted runtime exceptions.
 * </p>
 * @apiSince 23
 */

public static final int PREVIEW_SDK_INT;
static { PREVIEW_SDK_INT = 0; }

/**
 * The user-visible version string.  E.g., "1.0" or "3.4b5" or "bananas".
 *
 * This field is an opaque string. Do not assume that its value
 * has any particular structure or that values of RELEASE from
 * different releases can be somehow ordered.
 * @apiSince 1
 */

public static final java.lang.String RELEASE;
static { RELEASE = null; }

/**
 * The user-visible SDK version of the framework in its raw String
 * representation; use {@link #SDK_INT} instead.
 *
 * @deprecated Use {@link #SDK_INT} to easily get this as an integer.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String SDK;
static { SDK = null; }

/**
 * The SDK version of the software currently running on this hardware
 * device. This value never changes while a device is booted, but it may
 * increase when the hardware manufacturer provides an OTA update.
 * <p>
 * Possible values are defined in {@link android.os.Build.VERSION_CODES Build.VERSION_CODES}.
 * @apiSince 4
 */

public static final int SDK_INT;
static { SDK_INT = 0; }

/**
 * The user-visible security patch level.
 * @apiSince 23
 */

public static final java.lang.String SECURITY_PATCH;
static { SECURITY_PATCH = null; }
}

/**
 * Enumeration of the currently known SDK version codes.  These are the
 * values that can be found in {@link android.os.Build.VERSION#SDK VERSION#SDK}.  Version numbers
 * increment monotonically with each official platform release.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class VERSION_CODES {

public VERSION_CODES() { throw new RuntimeException("Stub!"); }

/**
 * October 2008: The original, first, version of Android.  Yay!
 * @apiSince 4
 */

public static final int BASE = 1; // 0x1

/**
 * February 2009: First Android update, officially called 1.1.
 * @apiSince 4
 */

public static final int BASE_1_1 = 2; // 0x2

/**
 * May 2009: Android 1.5.
 * @apiSince 4
 */

public static final int CUPCAKE = 3; // 0x3

/**
 * Magic version number for a current development build, which has
 * not yet turned into an official release.
 * @apiSince 4
 */

public static final int CUR_DEVELOPMENT = 10000; // 0x2710

/**
 * September 2009: Android 1.6.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li> They must explicitly request the
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} permission to be
 * able to modify the contents of the SD card.  (Apps targeting
 * earlier versions will always request the permission.)
 * <li> They must explicitly request the
 * {@link android.Manifest.permission#READ_PHONE_STATE} permission to be
 * able to be able to retrieve phone state info.  (Apps targeting
 * earlier versions will always request the permission.)
 * <li> They are assumed to support different screen densities and
 * sizes.  (Apps targeting earlier versions are assumed to only support
 * medium density normal size screens unless otherwise indicated).
 * They can still explicitly specify screen support either way with the
 * supports-screens manifest tag.
 * <li> {@link android.widget.TabHost} will use the new dark tab
 * background design.
 * </ul>
 * @apiSince 4
 */

public static final int DONUT = 4; // 0x4

/**
 * November 2009: Android 2.0
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li> The {@link android.app.Service#onStartCommand
 * Service.onStartCommand} function will return the new
 * {@link android.app.Service#START_STICKY} behavior instead of the
 * old compatibility {@link android.app.Service#START_STICKY_COMPATIBILITY}.
 * <li> The {@link android.app.Activity} class will now execute back
 * key presses on the key up instead of key down, to be able to detect
 * canceled presses from virtual keys.
 * <li> The {@link android.widget.TabWidget} class will use a new color scheme
 * for tabs. In the new scheme, the foreground tab has a medium gray background
 * the background tabs have a dark gray background.
 * </ul>
 * @apiSince 5
 */

public static final int ECLAIR = 5; // 0x5

/**
 * December 2009: Android 2.0.1
 * @apiSince 6
 */

public static final int ECLAIR_0_1 = 6; // 0x6

/**
 * January 2010: Android 2.1
 * @apiSince 7
 */

public static final int ECLAIR_MR1 = 7; // 0x7

/**
 * June 2010: Android 2.2
 * @apiSince 8
 */

public static final int FROYO = 8; // 0x8

/**
 * November 2010: Android 2.3
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li> The application's notification icons will be shown on the new
 * dark status bar background, so must be visible in this situation.
 * </ul>
 * @apiSince 9
 */

public static final int GINGERBREAD = 9; // 0x9

/**
 * February 2011: Android 2.3.3.
 * @apiSince 10
 */

public static final int GINGERBREAD_MR1 = 10; // 0xa

/**
 * February 2011: Android 3.0.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li> The default theme for applications is now dark holographic:
 *      {@link android.R.style#Theme_Holo}.
 * <li> On large screen devices that do not have a physical menu
 * button, the soft (compatibility) menu is disabled.
 * <li> The activity lifecycle has changed slightly as per
 * {@link android.app.Activity}.
 * <li> An application will crash if it does not call through
 * to the super implementation of its
 * {@link android.app.Activity#onPause Activity.onPause()} method.
 * <li> When an application requires a permission to access one of
 * its components (activity, receiver, service, provider), this
 * permission is no longer enforced when the application wants to
 * access its own component.  This means it can require a permission
 * on a component that it does not itself hold and still access that
 * component.
 * <li> {@link android.content.Context#getSharedPreferences
 * Context.getSharedPreferences()} will not automatically reload
 * the preferences if they have changed on storage, unless
 * {@link android.content.Context#MODE_MULTI_PROCESS} is used.
 * <li> {@link android.view.ViewGroup#setMotionEventSplittingEnabled}
 * will default to true.
 * <li> {@link android.view.WindowManager.LayoutParams#FLAG_SPLIT_TOUCH}
 * is enabled by default on windows.
 * <li> {@link android.widget.PopupWindow#isSplitTouchEnabled()
 * PopupWindow.isSplitTouchEnabled()} will return true by default.
 * <li> {@link android.widget.GridView} and {@link android.widget.ListView}
 * will use {@link android.view.View#setActivated View.setActivated}
 * for selected items if they do not implement {@link android.widget.Checkable}.
 * <li> {@link android.widget.Scroller} will be constructed with
 * "flywheel" behavior enabled by default.
 * </ul>
 * @apiSince 11
 */

public static final int HONEYCOMB = 11; // 0xb

/**
 * May 2011: Android 3.1.
 * @apiSince 12
 */

public static final int HONEYCOMB_MR1 = 12; // 0xc

/**
 * June 2011: Android 3.2.
 *
 * <p>Update to Honeycomb MR1 to support 7 inch tablets, improve
 * screen compatibility mode, etc.</p>
 *
 * <p>As of this version, applications that don't say whether they
 * support XLARGE screens will be assumed to do so only if they target
 * {@link #HONEYCOMB} or later; it had been {@link #GINGERBREAD} or
 * later.  Applications that don't support a screen size at least as
 * large as the current screen will provide the user with a UI to
 * switch them in to screen size compatibility mode.</p>
 *
 * <p>This version introduces new screen size resource qualifiers
 * based on the screen size in dp: see
 * {@link android.content.res.Configuration#screenWidthDp},
 * {@link android.content.res.Configuration#screenHeightDp}, and
 * {@link android.content.res.Configuration#smallestScreenWidthDp}.
 * Supplying these in &lt;supports-screens&gt; as per
 * {@link android.content.pm.ApplicationInfo#requiresSmallestWidthDp},
 * {@link android.content.pm.ApplicationInfo#compatibleWidthLimitDp}, and
 * {@link android.content.pm.ApplicationInfo#largestWidthLimitDp} is
 * preferred over the older screen size buckets and for older devices
 * the appropriate buckets will be inferred from them.</p>
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li><p>New {@link android.content.pm.PackageManager#FEATURE_SCREEN_PORTRAIT}
 * and {@link android.content.pm.PackageManager#FEATURE_SCREEN_LANDSCAPE}
 * features were introduced in this release.  Applications that target
 * previous platform versions are assumed to require both portrait and
 * landscape support in the device; when targeting Honeycomb MR1 or
 * greater the application is responsible for specifying any specific
 * orientation it requires.</p>
 * <li><p>{@link android.os.AsyncTask} will use the serial executor
 * by default when calling {@link android.os.AsyncTask#execute}.</p>
 * <li><p>{@link android.content.pm.ActivityInfo#configChanges
 * ActivityInfo.configChanges} will have the
 * {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE} and
 * {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}
 * bits set; these need to be cleared for older applications because
 * some developers have done absolute comparisons against this value
 * instead of correctly masking the bits they are interested in.
 * </ul>
 * @apiSince 13
 */

public static final int HONEYCOMB_MR2 = 13; // 0xd

/**
 * October 2011: Android 4.0.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li> For devices without a dedicated menu key, the software compatibility
 * menu key will not be shown even on phones.  By targeting Ice Cream Sandwich
 * or later, your UI must always have its own menu UI affordance if needed,
 * on both tablets and phones.  The ActionBar will take care of this for you.
 * <li> 2d drawing hardware acceleration is now turned on by default.
 * You can use
 * {@link android.R.attr#hardwareAccelerated android:hardwareAccelerated}
 * to turn it off if needed, although this is strongly discouraged since
 * it will result in poor performance on larger screen devices.
 * <li> The default theme for applications is now the "device default" theme:
 *      {@link android.R.style#Theme_DeviceDefault}. This may be the
 *      holo dark theme or a different dark theme defined by the specific device.
 *      The {@link android.R.style#Theme_Holo} family must not be modified
 *      for a device to be considered compatible. Applications that explicitly
 *      request a theme from the Holo family will be guaranteed that these themes
 *      will not change character within the same platform version. Applications
 *      that wish to blend in with the device should use a theme from the
 *      {@link android.R.style#Theme_DeviceDefault} family.
 * <li> Managed cursors can now throw an exception if you directly close
 * the cursor yourself without stopping the management of it; previously failures
 * would be silently ignored.
 * <li> The fadingEdge attribute on views will be ignored (fading edges is no
 * longer a standard part of the UI).  A new requiresFadingEdge attribute allows
 * applications to still force fading edges on for special cases.
 * <li> {@link android.content.Context#bindService Context.bindService()}
 * will not automatically add in {@link android.content.Context#BIND_WAIVE_PRIORITY}.
 * <li> App Widgets will have standard padding automatically added around
 * them, rather than relying on the padding being baked into the widget itself.
 * <li> An exception will be thrown if you try to change the type of a
 * window after it has been added to the window manager.  Previously this
 * would result in random incorrect behavior.
 * <li> {@link android.view.animation.AnimationSet} will parse out
 * the duration, fillBefore, fillAfter, repeatMode, and startOffset
 * XML attributes that are defined.
 * <li> {@link android.app.ActionBar#setHomeButtonEnabled
 * ActionBar.setHomeButtonEnabled()} is false by default.
 * </ul>
 * @apiSince 14
 */

public static final int ICE_CREAM_SANDWICH = 14; // 0xe

/**
 * December 2011: Android 4.0.3.
 * @apiSince 15
 */

public static final int ICE_CREAM_SANDWICH_MR1 = 15; // 0xf

/**
 * June 2012: Android 4.1.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li> You must explicitly request the {@link android.Manifest.permission#READ_CALL_LOG}
 * and/or {@link android.Manifest.permission#WRITE_CALL_LOG} permissions;
 * access to the call log is no longer implicitly provided through
 * {@link android.Manifest.permission#READ_CONTACTS} and
 * {@link android.Manifest.permission#WRITE_CONTACTS}.
 * <li> {@link android.widget.RemoteViews} will throw an exception if
 * setting an onClick handler for views being generated by a
 * {@link android.widget.RemoteViewsService} for a collection container;
 * previously this just resulted in a warning log message.
 * <li> New {@link android.app.ActionBar} policy for embedded tabs:
 * embedded tabs are now always stacked in the action bar when in portrait
 * mode, regardless of the size of the screen.
 * <li> {@link android.webkit.WebSettings#setAllowFileAccessFromFileURLs(boolean)
 * WebSettings.setAllowFileAccessFromFileURLs} and
 * {@link android.webkit.WebSettings#setAllowUniversalAccessFromFileURLs(boolean)
 * WebSettings.setAllowUniversalAccessFromFileURLs} default to false.
 * <li> Calls to {@link android.content.pm.PackageManager#setComponentEnabledSetting
 * PackageManager.setComponentEnabledSetting} will now throw an
 * IllegalArgumentException if the given component class name does not
 * exist in the application's manifest.
 * <li> {@link android.nfc.NfcAdapter#setNdefPushMessage
 * NfcAdapter.setNdefPushMessage},
 * {@link android.nfc.NfcAdapter#setNdefPushMessageCallback
 * NfcAdapter.setNdefPushMessageCallback} and
 * {@link android.nfc.NfcAdapter#setOnNdefPushCompleteCallback
 * NfcAdapter.setOnNdefPushCompleteCallback} will throw
 * IllegalStateException if called after the Activity has been destroyed.
 * <li> Accessibility services must require the new
 * {@link android.Manifest.permission#BIND_ACCESSIBILITY_SERVICE} permission or
 * they will not be available for use.
 * <li> {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_INCLUDE_NOT_IMPORTANT_VIEWS
 * AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS} must be set
 * for unimportant views to be included in queries.
 * </ul>
 * @apiSince 16
 */

public static final int JELLY_BEAN = 16; // 0x10

/**
 * November 2012: Android 4.2, Moar jelly beans!
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li>Content Providers: The default value of {@code android:exported} is now
 * {@code false}. See
 * <a href="{@docRoot}guide/topics/manifest/provider-element.html#exported">
 * the android:exported section</a> in the provider documentation for more details.</li>
 * <li>{@link android.view.View#getLayoutDirection() View.getLayoutDirection()}
 * can return different values than {@link android.view.View#LAYOUT_DIRECTION_LTR}
 * based on the locale etc.
 * <li> {@link android.webkit.WebView#addJavascriptInterface(Object, String)
 * WebView.addJavascriptInterface} requires explicit annotations on methods
 * for them to be accessible from Javascript.
 * </ul>
 * @apiSince 17
 */

public static final int JELLY_BEAN_MR1 = 17; // 0x11

/**
 * July 2013: Android 4.3, the revenge of the beans.
 * @apiSince 18
 */

public static final int JELLY_BEAN_MR2 = 18; // 0x12

/**
 * October 2013: Android 4.4, KitKat, another tasty treat.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior. For more information about this release, see the
 * <a href="/about/versions/kitkat/">Android KitKat overview</a>.</p>
 * <ul>
 * <li> The default result of
 * {@link android.preference.PreferenceActivity#isValidFragment(String)
 * PreferenceActivity.isValueFragment} becomes false instead of true.</li>
 * <li> In {@link android.webkit.WebView}, apps targeting earlier versions will have
 * JS URLs evaluated directly and any result of the evaluation will not replace
 * the current page content.  Apps targetting KITKAT or later that load a JS URL will
 * have the result of that URL replace the content of the current page</li>
 * <li> {@link android.app.AlarmManager#set AlarmManager.set} becomes interpreted as
 * an inexact value, to give the system more flexibility in scheduling alarms.</li>
 * <li> {@link android.content.Context#getSharedPreferences(String, int)
 * Context.getSharedPreferences} no longer allows a null name.</li>
 * <li> {@link android.widget.RelativeLayout} changes to compute wrapped content
 * margins correctly.</li>
 * <li> {@link android.app.ActionBar}'s window content overlay is allowed to be
 * drawn.</li>
 * <li>The {@link android.Manifest.permission#READ_EXTERNAL_STORAGE}
 * permission is now always enforced.</li>
 * <li>Access to package-specific external storage directories belonging
 * to the calling app no longer requires the
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} or
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE}
 * permissions.</li>
 * </ul>
 * @apiSince 19
 */

public static final int KITKAT = 19; // 0x13

/**
 * June 2014: Android 4.4W. KitKat for watches, snacks on the run.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior:</p>
 * <ul>
 * <li>{@link android.app.AlertDialog} might not have a default background if the theme does
 * not specify one.</li>
 * </ul>
 * @apiSince 20
 */

public static final int KITKAT_WATCH = 20; // 0x14

/**
 * November 2014: Lollipop.  A flat one with beautiful shadows.  But still tasty.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior.  For more information about this release, see the
 * <a href="/about/versions/lollipop/">Android Lollipop overview</a>.</p>
 * <ul>
 * <li> {@link android.content.Context#bindService Context.bindService} now
 * requires an explicit Intent, and will throw an exception if given an implicit
 * Intent.</li>
 * <li> {@link android.app.Notification.Builder Notification.Builder} will
 * not have the colors of their various notification elements adjusted to better
 * match the new material design look.</li>
 * <li> {@link android.os.Message} will validate that a message is not currently
 * in use when it is recycled.</li>
 * <li> Hardware accelerated drawing in windows will be enabled automatically
 * in most places.</li>
 * <li> {@link android.widget.Spinner} throws an exception if attaching an
 * adapter with more than one item type.</li>
 * <li> If the app is a launcher, the launcher will be available to the user
 * even when they are using corporate profiles (which requires that the app
 * use {@link android.content.pm.LauncherApps} to correctly populate its
 * apps UI).</li>
 * <li> Calling {@link android.app.Service#stopForeground Service.stopForeground}
 * with removeNotification false will modify the still posted notification so that
 * it is no longer forced to be ongoing.</li>
 * <li> A {@link android.service.dreams.DreamService} must require the
 * {@link android.Manifest.permission#BIND_DREAM_SERVICE} permission to be usable.</li>
 * </ul>
 * @apiSince 21
 */

public static final int LOLLIPOP = 21; // 0x15

/**
 * March 2015: Lollipop with an extra sugar coating on the outside!
 * For more information about this release, see the
 * <a href="/about/versions/android-5.1">Android 5.1 APIs</a>.
 * @apiSince 22
 */

public static final int LOLLIPOP_MR1 = 22; // 0x16

/**
 * M is for Marshmallow!
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior. For more information about this release, see the
 * <a href="/about/versions/marshmallow/">Android 6.0 Marshmallow overview</a>.</p>
 * <ul>
 * <li> Runtime permissions.  Dangerous permissions are no longer granted at
 * install time, but must be requested by the application at runtime through
 * {@link android.app.Activity#requestPermissions}.</li>
 * <li> Bluetooth and Wi-Fi scanning now requires holding the location permission.</li>
 * <li> {@link android.app.AlarmManager#setTimeZone AlarmManager.setTimeZone} will fail if
 * the given timezone is non-Olson.</li>
 * <li> Activity transitions will only return shared
 * elements mapped in the returned view hierarchy back to the calling activity.</li>
 * <li> {@link android.view.View} allows a number of behaviors that may break
 * existing apps: Canvas throws an exception if restore() is called too many times,
 * widgets may return a hint size when returning UNSPECIFIED measure specs, and it
 * will respect the attributes {@link android.R.attr#foreground},
 * {@link android.R.attr#foregroundGravity}, {@link android.R.attr#foregroundTint}, and
 * {@link android.R.attr#foregroundTintMode}.</li>
 * <li> {@link android.view.MotionEvent#getButtonState MotionEvent.getButtonState}
 * will no longer report {@link android.view.MotionEvent#BUTTON_PRIMARY}
 * and {@link android.view.MotionEvent#BUTTON_SECONDARY} as synonyms for
 * {@link android.view.MotionEvent#BUTTON_STYLUS_PRIMARY} and
 * {@link android.view.MotionEvent#BUTTON_STYLUS_SECONDARY}.</li>
 * <li> {@link android.widget.ScrollView} now respects the layout param margins
 * when measuring.</li>
 * </ul>
 * @apiSince 23
 */

public static final int M = 23; // 0x17

/**
 * N is for Nougat.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior. For more information about this release, see
 * the <a href="/about/versions/nougat/">Android Nougat overview</a>.</p>
 * <ul>
 * <li> {@link android.app.DownloadManager.Request#setAllowedNetworkTypes
 * DownloadManager.Request.setAllowedNetworkTypes}
 * will disable "allow over metered" when specifying only
 * {@link android.app.DownloadManager.Request#NETWORK_WIFI}.</li>
 * <li> {@link android.app.DownloadManager} no longer allows access to raw
 * file paths.</li>
 * <li> {@link android.app.Notification.Builder#setShowWhen
 * Notification.Builder.setShowWhen}
 * must be called explicitly to have the time shown, and various other changes in
 * {@link android.app.Notification.Builder Notification.Builder} to how notifications
 * are shown.</li>
 * <li>{@link android.content.Context#MODE_WORLD_READABLE} and
 * {@link android.content.Context#MODE_WORLD_WRITEABLE} are no longer supported.</li>
 * <li>{@link android.os.FileUriExposedException} will be thrown to applications.</li>
 * <li>Applications will see global drag and drops as per
 * {@link android.view.View#DRAG_FLAG_GLOBAL}.</li>
 * <li>{@link android.webkit.WebView#evaluateJavascript WebView.evaluateJavascript}
 * will not persist state from an empty WebView.</li>
 * <li>{@link android.animation.AnimatorSet} will not ignore calls to end() before
 * start().</li>
 * <li>{@link android.app.AlarmManager#cancel(android.app.PendingIntent)
 * AlarmManager.cancel} will throw a NullPointerException if given a null operation.</li>
 * <li>{@link android.app.FragmentManager} will ensure fragments have been created
 * before being placed on the back stack.</li>
 * <li>{@link android.app.FragmentManager} restores fragments in
 * {@link android.app.Fragment#onCreate Fragment.onCreate} rather than after the
 * method returns.</li>
 * <li>{@link android.R.attr#resizeableActivity} defaults to true.</li>
 * <li>{@link android.graphics.drawable.AnimatedVectorDrawable} throws exceptions when
 * opening invalid VectorDrawable animations.</li>
 * <li>{@link android.view.ViewGroup.MarginLayoutParams} will no longer be dropped
 * when converting between some types of layout params (such as
 * {@link android.widget.LinearLayout.LayoutParams LinearLayout.LayoutParams} to
 * {@link android.widget.RelativeLayout.LayoutParams RelativeLayout.LayoutParams}).</li>
 * <li>Your application processes will not be killed when the device density changes.</li>
 * <li>Drag and drop. After a view receives the
 * {@link android.view.DragEvent#ACTION_DRAG_ENTERED} event, when the drag shadow moves into
 * a descendant view that can accept the data, the view receives the
 * {@link android.view.DragEvent#ACTION_DRAG_EXITED} event and won’t receive
 * {@link android.view.DragEvent#ACTION_DRAG_LOCATION} and
 * {@link android.view.DragEvent#ACTION_DROP} events while the drag shadow is within that
 * descendant view, even if the descendant view returns <code>false</code> from its handler
 * for these events.</li>
 * </ul>
 * @apiSince 24
 */

public static final int N = 24; // 0x18

/**
 * N MR1: Nougat++. For more information about this release, see
 * <a href="/about/versions/nougat/android-7.1">Android 7.1 for
 * Developers</a>.
 * @apiSince 25
 */

public static final int N_MR1 = 25; // 0x19

/**
 * O.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior. For more information about this release, see
 * the <a href="/about/versions/oreo/">Android Oreo overview</a>.</p>
 * <ul>
 * <li><a href="{@docRoot}about/versions/oreo/background.html">Background execution limits</a>
 * are applied to the application.</li>
 * <li>The behavior of AccountManager's
 * {@link android.accounts.AccountManager#getAccountsByType},
 * {@link android.accounts.AccountManager#getAccountsByTypeAndFeatures}, and
 * {@link android.accounts.AccountManager#hasFeatures} has changed as documented there.</li>
 * <li>{@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_PERCEPTIBLE_PRE_26}
 * is now returned as
 * {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_PERCEPTIBLE}.</li>
 * <li>The {@link android.app.NotificationManager} now requires the use of notification
 * channels.</li>
 * <li>Changes to the strict mode that are set in
 * {@link android.app.Application#onCreate Application#onCreate} will no longer be clobbered after
 * that function returns.</li>
 * <li>A shared library apk with native code will have that native code included in
 * the library path of its clients.</li>
 * <li>{@link android.content.Context#getSharedPreferences Context.getSharedPreferences}
 * in credential encrypted storage will throw an exception before the user is unlocked.</li>
 * <li>Attempting to retrieve a {@link android.content.Context#FINGERPRINT_SERVICE Context#FINGERPRINT_SERVICE} on a device that
 * does not support that feature will now throw a runtime exception.</li>
 * <li>{@link android.app.Fragment} will stop any active view animations when
 * the fragment is stopped.</li>
 * <li>Some compatibility code in Resources that attempts to use the default Theme
 * the app may be using will be turned off, requiring the app to explicitly request
 * resources with the right theme.</li>
 * <li>{@link android.content.ContentResolver#notifyChange ContentResolver.notifyChange} and
 * {@link android.content.ContentResolver#registerContentObserver
 * ContentResolver.registerContentObserver}
 * will throw a SecurityException if the caller does not have permission to access
 * the provider (or the provider doesn't exit); otherwise the call will be silently
 * ignored.</li>
 * <li>{@link android.hardware.camera2.CameraDevice#createCaptureRequest
 * CameraDevice.createCaptureRequest} will enable
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_ENABLE_ZSL} by default for
 * still image capture.</li>
 * <li>WallpaperManager's {@link android.app.WallpaperManager#getWallpaperFile},
 * {@link android.app.WallpaperManager#getDrawable},
 * {@link android.app.WallpaperManager#getFastDrawable},
 * {@link android.app.WallpaperManager#peekDrawable}, and
 * {@link android.app.WallpaperManager#peekFastDrawable} will throw an exception
 * if you can not access the wallpaper.</li>
 * <li>The behavior of
 * {@link android.hardware.usb.UsbDeviceConnection#requestWait UsbDeviceConnection.requestWait}
 * is modified as per the documentation there.</li>
 * <li>{@link android.os.StrictMode.VmPolicy.Builder#detectAll StrictMode.VmPolicy.Builder#detectAll}
 * will also enable {@link android.os.StrictMode.VmPolicy.Builder#detectContentUriWithoutPermission StrictMode.VmPolicy.Builder#detectContentUriWithoutPermission}
 * and {@link android.os.StrictMode.VmPolicy.Builder#detectUntaggedSockets StrictMode.VmPolicy.Builder#detectUntaggedSockets}.</li>
 * <li>{@link android.os.StrictMode.ThreadPolicy.Builder#detectAll StrictMode.ThreadPolicy.Builder#detectAll}
 * will also enable {@link android.os.StrictMode.ThreadPolicy.Builder#detectUnbufferedIo StrictMode.ThreadPolicy.Builder#detectUnbufferedIo}.</li>
 * <li>{@link android.provider.DocumentsContract}'s various methods will throw failure
 * exceptions back to the caller instead of returning null.
 * <li>{@link android.view.View#hasFocusable View#hasFocusable} now includes auto-focusable views.</li>
 * <li>{@link android.view.SurfaceView} will no longer always change the underlying
 * Surface object when something about it changes; apps need to look at the current
 * state of the object to determine which things they are interested in have changed.</li>
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_APPLICATION_OVERLAY} must be
 * used for overlay windows, other system overlay window types are not allowed.</li>
 * <li>{@link android.view.ViewTreeObserver#addOnDrawListener
 * ViewTreeObserver.addOnDrawListener} will throw an exception if called from within
 * onDraw.</li>
 * <li>{@link android.graphics.Canvas#setBitmap Canvas.setBitmap} will no longer preserve
 * the current matrix and clip stack of the canvas.</li>
 * <li>{@link android.widget.ListPopupWindow#setHeight ListPopupWindow.setHeight}
 * will throw an exception if a negative height is supplied.</li>
 * <li>{@link android.widget.TextView} will use internationalized input for numbers,
 * dates, and times.</li>
 * <li>{@link android.widget.Toast} must be used for showing toast windows; the toast
 * window type can not be directly used.</li>
 * <li>{@link android.net.wifi.WifiManager#getConnectionInfo WifiManager.getConnectionInfo}
 * requires that the caller hold the location permission to return BSSID/SSID</li>
 * <li>{@link android.net.wifi.p2p.WifiP2pManager#requestPeers WifiP2pManager.requestPeers}
 * requires the caller hold the location permission.</li>
 * <li>{@link android.R.attr#maxAspectRatio} defaults to 0, meaning there is no restriction
 * on the app's maximum aspect ratio (so it can be stretched to fill larger screens).</li>
 * <li>{@link android.R.attr#focusable} defaults to a new state ({@code auto}) where it will
 * inherit the value of {@link android.R.attr#clickable} unless explicitly overridden.</li>
 * <li>A default theme-appropriate focus-state highlight will be supplied to all Views
 * which don't provide a focus-state drawable themselves. This can be disabled by setting
 * {@link android.R.attr#defaultFocusHighlightEnabled} to false.</li>
 * </ul>
 * @apiSince 26
 */

public static final int O = 26; // 0x1a

/**
 * O MR1.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior. For more information about this release, see
 * <a href="/about/versions/oreo/android-8.1">Android 8.1 features and
 * APIs</a>.</p>
 * <ul>
 * <li>Apps exporting and linking to apk shared libraries must explicitly
 * enumerate all signing certificates in a consistent order.</li>
 * <li>{@link android.R.attr#screenOrientation} can not be used to request a fixed
 * orientation if the associated activity is not fullscreen and opaque.</li>
 * </ul>
 *
 * @apiSince 27
 */

public static final int O_MR1 = 27; // 0x1b

/**
 * P.
 *
 * <p>Applications targeting this or a later release will get these
 * new changes in behavior. For more information about this release, see the
 * <a href="/about/versions/pie/">Android 9 Pie overview</a>.</p>
 * <ul>
 * <li>{@link android.app.Service#startForeground Service.startForeground} requires
 * that apps hold the permission
 * {@link android.Manifest.permission#FOREGROUND_SERVICE}.</li>
 * <li>{@link android.widget.LinearLayout} will always remeasure weighted children,
 * even if there is no excess space.</li>
 * </ul>
 *
 * @apiSince 28
 */

public static final int P = 28; // 0x1c

/**
 * Q.
 * <p>
 * <em>Why? Why, to give you a taste of your future, a preview of things
 * to come. Con permiso, Capitan. The hall is rented, the orchestra
 * engaged. It's now time to see if you can dance.</em>
 * @apiSince 29
 */

public static final int Q = 29; // 0x1d

/**
 * R.
 * @apiSince R
 */

public static final int R = 10000; // 0x2710
}

}

