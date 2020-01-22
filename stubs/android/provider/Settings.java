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


package android.provider;

import android.Manifest;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION_CODES;
import android.net.ConnectivityManager;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.content.ContentResolver;
import android.content.res.Configuration;
import java.util.Set;
import android.content.ComponentName;
import android.net.Uri;
import android.app.WallpaperManager;
import android.view.Display;
import android.location.LocationManager;
import android.content.pm.PackageManager;
import android.speech.tts.TextToSpeech;
import android.os.BatteryManager;

/**
 * The Settings provider contains global system-level device preferences.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Settings {

public Settings() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified context can draw on top of other apps. As of API
 * level 23, an app cannot draw on top of other apps unless it declares the
 * {@link android.Manifest.permission#SYSTEM_ALERT_WINDOW} permission in its
 * manifest, <em>and</em> the user specifically grants the app this
 * capability. To prompt the user to grant this approval, the app must send an
 * intent with the action
 * {@link android.provider.Settings#ACTION_MANAGE_OVERLAY_PERMISSION}, which
 * causes the system to display a permission management screen.
 *
 * @param context App context.
 * @return true if the specified context can draw on top of other apps, false otherwise
 * @apiSince 23
 */

public static boolean canDrawOverlays(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Show settings for accessibility modules.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 5
 */

public static final java.lang.String ACTION_ACCESSIBILITY_SETTINGS = "android.settings.ACCESSIBILITY_SETTINGS";

/**
 * Activity Action: Show add account screen for creating a new account.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * The account types available to add may be restricted by adding an {@link #EXTRA_AUTHORITIES}
 * extra to the Intent with one or more syncable content provider's authorities.  Only account
 * types which can sync with that content provider will be offered to the user.
 * <p>
 * Account types can also be filtered by adding an {@link #EXTRA_ACCOUNT_TYPES} extra to the
 * Intent with one or more account types.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 8
 */

public static final java.lang.String ACTION_ADD_ACCOUNT = "android.settings.ADD_ACCOUNT_SETTINGS";

/**
 * Activity Action: Show settings to allow entering/exiting airplane mode.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_AIRPLANE_MODE_SETTINGS = "android.settings.AIRPLANE_MODE_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of APNs.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 *
 * <p class="note">
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * @apiSince 1
 */

public static final java.lang.String ACTION_APN_SETTINGS = "android.settings.APN_SETTINGS";

/**
 * Activity Action: Show screen of details about a particular application.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: The Intent's data URI specifies the application package name
 * to be shown, with the "package" scheme.  That is "package:com.my.app".
 * <p>
 * Output: Nothing.
 * @apiSince 9
 */

public static final java.lang.String ACTION_APPLICATION_DETAILS_SETTINGS = "android.settings.APPLICATION_DETAILS_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of application
 * development-related settings.  As of
 * {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1} this action is
 * a required part of the platform.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_APPLICATION_DEVELOPMENT_SETTINGS = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of application-related settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_APPLICATION_SETTINGS = "android.settings.APPLICATION_SETTINGS";

/**
 * Activity Action: Show notification bubble settings for a single app.
 * See {@link android.app.NotificationManager#areBubblesAllowed() NotificationManager#areBubblesAllowed()}.
 * <p>
 *     Input: {@link #EXTRA_APP_PACKAGE}, the package to display.
 * <p>
 * Output: Nothing.
 * @apiSince 29
 */

public static final java.lang.String ACTION_APP_NOTIFICATION_BUBBLE_SETTINGS = "android.settings.APP_NOTIFICATION_BUBBLE_SETTINGS";

/**
 * Activity Action: Show notification settings for a single app.
 * <p>
 *     Input: {@link #EXTRA_APP_PACKAGE}, the package to display.
 * <p>
 * Output: Nothing.
 * @apiSince 26
 */

public static final java.lang.String ACTION_APP_NOTIFICATION_SETTINGS = "android.settings.APP_NOTIFICATION_SETTINGS";

/**
 * Activity action: Show Settings app search UI when this action is available for device.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 29
 */

public static final java.lang.String ACTION_APP_SEARCH_SETTINGS = "android.settings.APP_SEARCH_SETTINGS";

/**
 * Activity Action: Show screen for controlling app usage properties for an app.
 * Input: Intent's extra {@link android.content.Intent#EXTRA_PACKAGE_NAME} must specify the
 * application package name.
 * Output: Nothing.
 * @apiSince 29
 */

public static final java.lang.String ACTION_APP_USAGE_SETTINGS = "android.settings.action.APP_USAGE_SETTINGS";

/**
 * Activity Action: Show battery saver settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard
 * against this.
 * @apiSince 22
 */

public static final java.lang.String ACTION_BATTERY_SAVER_SETTINGS = "android.settings.BATTERY_SAVER_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of Bluetooth.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_BLUETOOTH_SETTINGS = "android.settings.BLUETOOTH_SETTINGS";

/**
 * Activity Action: Show settings for video captioning.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard
 * against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 19
 */

public static final java.lang.String ACTION_CAPTIONING_SETTINGS = "android.settings.CAPTIONING_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of cast endpoints.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 21
 */

public static final java.lang.String ACTION_CAST_SETTINGS = "android.settings.CAST_SETTINGS";

/**
 * Activity Action: Show notification settings for a single {@link android.app.NotificationChannel NotificationChannel}.
 * <p>
 *     Input: {@link #EXTRA_APP_PACKAGE}, the package containing the channel to display.
 *     Input: {@link #EXTRA_CHANNEL_ID}, the id of the channel to display.
 * <p>
 * Output: Nothing.
 * @apiSince 26
 */

public static final java.lang.String ACTION_CHANNEL_NOTIFICATION_SETTINGS = "android.settings.CHANNEL_NOTIFICATION_SETTINGS";

/**
 * Activity Action: Show settings for selection of 2G/3G.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_DATA_ROAMING_SETTINGS = "android.settings.DATA_ROAMING_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of data and view data usage.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 28
 */

public static final java.lang.String ACTION_DATA_USAGE_SETTINGS = "android.settings.DATA_USAGE_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of date and time.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_DATE_SETTINGS = "android.settings.DATE_SETTINGS";

/**
 * Activity Action: Show general device information settings (serial
 * number, software version, phone number, etc.).
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing
 * @apiSince 8
 */

public static final java.lang.String ACTION_DEVICE_INFO_SETTINGS = "android.settings.DEVICE_INFO_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of display.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_DISPLAY_SETTINGS = "android.settings.DISPLAY_SETTINGS";

/**
 * Activity Action: Show Daydream settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @see android.service.dreams.DreamService
 * @apiSince 18
 */

public static final java.lang.String ACTION_DREAM_SETTINGS = "android.settings.DREAM_SETTINGS";

/**
 * Activity Action: Show settings to enroll fingerprints, and setup PIN/Pattern/Pass if
 * necessary.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 28
 */

public static final java.lang.String ACTION_FINGERPRINT_ENROLL = "android.settings.FINGERPRINT_ENROLL";

/**
 * Activity Action: Show settings to configure the hardware keyboard.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 24
 */

public static final java.lang.String ACTION_HARD_KEYBOARD_SETTINGS = "android.settings.HARD_KEYBOARD_SETTINGS";

/**
 * Activity Action: Show Home selection settings. If there are multiple activities
 * that can satisfy the {@link android.content.Intent#CATEGORY_HOME Intent#CATEGORY_HOME} intent, this screen allows you
 * to pick your preferred activity.
 * @apiSince 21
 */

public static final java.lang.String ACTION_HOME_SETTINGS = "android.settings.HOME_SETTINGS";

/**
 * Activity Action: Show screen for controlling background data
 * restrictions for a particular application.
 * <p>
 * Input: Intent's data URI set with an application name, using the
 * "package" schema (like "package:com.my.app").
 *
 * <p>
 * Output: Nothing.
 * <p>
 * Applications can also use {@link android.net.ConnectivityManager#getRestrictBackgroundStatus
 * ConnectivityManager#getRestrictBackgroundStatus()} to determine the
 * status of the background data restrictions for them.
 *
 * <p class="note">
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * @apiSince 24
 */

public static final java.lang.String ACTION_IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS = "android.settings.IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS";

/**
 * Activity Action: Show screen for controlling which apps can ignore battery optimizations.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * <p>
 * You can use {@link android.os.PowerManager#isIgnoringBatteryOptimizations
 * PowerManager.isIgnoringBatteryOptimizations()} to determine if an application is
 * already ignoring optimizations.  You can use
 * {@link #ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS} to ask the user to put you
 * on this list.
 * @apiSince 23
 */

public static final java.lang.String ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS = "android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS";

/**
 * Activity Action: Show settings to configure input methods, in particular
 * allowing the user to enable input methods.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_INPUT_METHOD_SETTINGS = "android.settings.INPUT_METHOD_SETTINGS";

/**
 * Activity Action: Show settings to enable/disable input method subtypes.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * To tell which input method's subtypes are displayed in the settings, add
 * {@link #EXTRA_INPUT_METHOD_ID} extra to this Intent with the input method id.
 * If there is no extra in this Intent, subtypes from all installed input methods
 * will be displayed in the settings.
 *
 * @see android.view.inputmethod.InputMethodInfo#getId
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 11
 */

public static final java.lang.String ACTION_INPUT_METHOD_SUBTYPE_SETTINGS = "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";

/**
 * Activity Action: Show settings for internal storage.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_INTERNAL_STORAGE_SETTINGS = "android.settings.INTERNAL_STORAGE_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of locale.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_LOCALE_SETTINGS = "android.settings.LOCALE_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of current location
 * sources.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_LOCATION_SOURCE_SETTINGS = "android.settings.LOCATION_SOURCE_SETTINGS";

/**
 * Activity Action: Show settings to manage all applications.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 9
 */

public static final java.lang.String ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS = "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";

/**
 * Activity Action: Show settings to manage installed applications.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_MANAGE_APPLICATIONS_SETTINGS = "android.settings.MANAGE_APPLICATIONS_SETTINGS";

/**
 * Activity Action: Show Default apps settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 24
 */

public static final java.lang.String ACTION_MANAGE_DEFAULT_APPS_SETTINGS = "android.settings.MANAGE_DEFAULT_APPS_SETTINGS";

/**
 * Activity Action: Show screen for controlling which apps can draw on top of other apps.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Optionally, the Intent's data URI can specify the application package name to
 * directly invoke the management GUI specific to the package name. For example
 * "package:com.my.app".
 * <p>
 * Output: Nothing.
 * @apiSince 23
 */

public static final java.lang.String ACTION_MANAGE_OVERLAY_PERMISSION = "android.settings.action.MANAGE_OVERLAY_PERMISSION";

/**
 * Activity Action: Show settings to allow configuration of trusted external sources
 *
 * Input: Optionally, the Intent's data URI can specify the application package name to
 * directly invoke the management GUI specific to the package name. For example
 * "package:com.my.app".
 * <p>
 * Output: Nothing.
 * @apiSince 26
 */

public static final java.lang.String ACTION_MANAGE_UNKNOWN_APP_SOURCES = "android.settings.MANAGE_UNKNOWN_APP_SOURCES";

/**
 * Activity Action: Show screen for controlling which apps are allowed to write/modify
 * system settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Optionally, the Intent's data URI can specify the application package name to
 * directly invoke the management GUI specific to the package name. For example
 * "package:com.my.app".
 * <p>
 * Output: Nothing.
 * @apiSince 23
 */

public static final java.lang.String ACTION_MANAGE_WRITE_SETTINGS = "android.settings.action.MANAGE_WRITE_SETTINGS";

/**
 * Activity Action: Show settings for memory card storage.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_MEMORY_CARD_SETTINGS = "android.settings.MEMORY_CARD_SETTINGS";

/**
 * Activity Action: Show settings for selecting the network operator.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * The subscription ID of the subscription for which available network operators should be
 * displayed may be optionally specified with {@link #EXTRA_SUB_ID}.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_NETWORK_OPERATOR_SETTINGS = "android.settings.NETWORK_OPERATOR_SETTINGS";

/**
 * Activity Action: Show NFC Sharing settings.
 * <p>
 * This shows UI that allows NDEF Push (Android Beam) to be turned on or
 * off.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing
 * @see android.nfc.NfcAdapter#isNdefPushEnabled()
 * @apiSince 14
 */

public static final java.lang.String ACTION_NFCSHARING_SETTINGS = "android.settings.NFCSHARING_SETTINGS";

/**
 * Activity Action: Show NFC Tap & Pay settings
 * <p>
 * This shows UI that allows the user to configure Tap&Pay
 * settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing
 * @apiSince 19
 */

public static final java.lang.String ACTION_NFC_PAYMENT_SETTINGS = "android.settings.NFC_PAYMENT_SETTINGS";

/**
 * Activity Action: Show NFC settings.
 * <p>
 * This shows UI that allows NFC to be turned on or off.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing
 * @see android.nfc.NfcAdapter#isEnabled()
 * @apiSince 16
 */

public static final java.lang.String ACTION_NFC_SETTINGS = "android.settings.NFC_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of Night display.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 26
 */

public static final java.lang.String ACTION_NIGHT_DISPLAY_SETTINGS = "android.settings.NIGHT_DISPLAY_SETTINGS";

/**
 * Activity Action: Show Notification assistant settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @see android.service.notification.NotificationAssistantService
 * @apiSince 29
 */

public static final java.lang.String ACTION_NOTIFICATION_ASSISTANT_SETTINGS = "android.settings.NOTIFICATION_ASSISTANT_SETTINGS";

/**
 * Activity Action: Show Notification listener settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @see android.service.notification.NotificationListenerService
 * @apiSince 22
 */

public static final java.lang.String ACTION_NOTIFICATION_LISTENER_SETTINGS = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";

/**
 * Activity Action: Show Do Not Disturb access settings.
 * <p>
 * Users can grant and deny access to Do Not Disturb configuration from here. Managed
 * profiles cannot grant Do Not Disturb access.
 * See {@link android.app.NotificationManager#isNotificationPolicyAccessGranted()} for more
 * details.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 *
 * <p class="note">
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * @apiSince 23
 */

public static final java.lang.String ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS = "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS";

/**
 * Activity Action: Show the top level print settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 19
 */

public static final java.lang.String ACTION_PRINT_SETTINGS = "android.settings.ACTION_PRINT_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of privacy options.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 5
 */

public static final java.lang.String ACTION_PRIVACY_SETTINGS = "android.settings.PRIVACY_SETTINGS";

/**
 * Activity Action: Show setting page to process an Easy Connect (Wi-Fi DPP) QR code and start
 * configuration. This intent should be used when you want to use this device to take on the
 * configurator role for an IoT/other device. When provided with a valid DPP URI string Settings
 * will open a wifi selection screen for the user to indicate which network they would like
 * to configure the device specified in the DPP URI string for and carry them through the rest
 * of the flow for provisioning the device.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard
 * against this by checking WifiManager.isEasyConnectSupported();
 * <p>
 * Input: The Intent's data URI specifies bootstrapping information for authenticating and
 * provisioning the peer, with the "DPP" scheme.
 * <p>
 * Output: After {@code startActivityForResult}, the callback {@code onActivityResult} will have
 *         resultCode {@link android.app.Activity#RESULT_OK} if Wi-Fi Easy Connect configuration
 *         success and the user clicks 'Done' button.
 * @apiSince 29
 */

public static final java.lang.String ACTION_PROCESS_WIFI_EASY_CONNECT_URI = "android.settings.PROCESS_WIFI_EASY_CONNECT_URI";

/**
 * Activity Action: Show settings to allow configuration of quick launch shortcuts.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_QUICK_LAUNCH_SETTINGS = "android.settings.QUICK_LAUNCH_SETTINGS";

/**
 * Activity Action: Ask the user to allow an app to ignore battery optimizations (that is,
 * put them on the whitelist of apps shown by
 * {@link #ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS}).  For an app to use this, it also
 * must hold the {@link android.Manifest.permission#REQUEST_IGNORE_BATTERY_OPTIMIZATIONS}
 * permission.
 * <p><b>Note:</b> most applications should <em>not</em> use this; there are many facilities
 * provided by the platform for applications to operate correctly in the various power
 * saving modes.  This is only for unusual applications that need to deeply control their own
 * execution, at the potential expense of the user's battery life.  Note that these applications
 * greatly run the risk of showing to the user as high power consumers on their device.</p>
 * <p>
 * Input: The Intent's data URI must specify the application package name
 * to be shown, with the "package" scheme.  That is "package:com.my.app".
 * <p>
 * Output: Nothing.
 * <p>
 * You can use {@link android.os.PowerManager#isIgnoringBatteryOptimizations
 * PowerManager.isIgnoringBatteryOptimizations()} to determine if an application is
 * already ignoring optimizations.
 * @apiSince 23
 */

public static final java.lang.String ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS = "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";

/**
 * Activity Action: Show screen that let user select its Autofill Service.
 * <p>
 * Input: Intent's data URI set with an application name, using the
 * "package" schema (like "package:com.my.app").
 *
 * <p>
 * Output: {@link android.app.Activity#RESULT_OK} if user selected an Autofill Service belonging
 * to the caller package.
 *
 * <p>
 * <b>NOTE: </b> Applications should call
 * {@link android.view.autofill.AutofillManager#hasEnabledAutofillServices()} and
 * {@link android.view.autofill.AutofillManager#isAutofillSupported()}, and only use this action
 * to start an activity if they return {@code false} and {@code true} respectively.
 * @apiSince 26
 */

public static final java.lang.String ACTION_REQUEST_SET_AUTOFILL_SERVICE = "android.settings.REQUEST_SET_AUTOFILL_SERVICE";

/**
 * Activity Action: Show settings for global search.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing
 * @apiSince 8
 */

public static final java.lang.String ACTION_SEARCH_SETTINGS = "android.search.action.SEARCH_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of security and
 * location privacy.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_SECURITY_SETTINGS = "android.settings.SECURITY_SETTINGS";

/**
 * Activity Action: Show system settings.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_SETTINGS = "android.settings.SETTINGS";

/**
 * Activity Action: Show the regulatory information screen for the device.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard
 * against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 21
 */

public static final java.lang.String ACTION_SHOW_REGULATORY_INFO = "android.settings.SHOW_REGULATORY_INFO";

/**
 * Activity Action: Show settings to allow configuration of sound and volume.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_SOUND_SETTINGS = "android.settings.SOUND_SETTINGS";

/**
 * Activity Action: Show screen for controlling which apps have access on volume directories.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * <p>
 * Applications typically use this action to ask the user to revert the "Do not ask again"
 * status of directory access requests made by
 * {@link android.os.storage.StorageVolume#createAccessIntent(String)}.
 * @deprecated use {@link #ACTION_APPLICATION_DETAILS_SETTINGS} to manage storage permissions
 *             for a specific application
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String ACTION_STORAGE_VOLUME_ACCESS_SETTINGS = "android.settings.STORAGE_VOLUME_ACCESS_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of sync settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * The account types available to add via the add account button may be restricted by adding an
 * {@link #EXTRA_AUTHORITIES} extra to this Intent with one or more syncable content provider's
 * authorities. Only account types which can sync with that content provider will be offered to
 * the user.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_SYNC_SETTINGS = "android.settings.SYNC_SETTINGS";

/**
 * Activity Action: Show settings to control access to usage information.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 21
 */

public static final java.lang.String ACTION_USAGE_ACCESS_SETTINGS = "android.settings.USAGE_ACCESS_SETTINGS";

/**
 * Activity Action: Show settings to manage the user input dictionary.
 * <p>
 * Starting with {@link android.os.Build.VERSION_CODES#KITKAT},
 * it is guaranteed there will always be an appropriate implementation for this Intent action.
 * In prior releases of the platform this was optional, so ensure you safeguard against it.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_USER_DICTIONARY_SETTINGS = "android.settings.USER_DICTIONARY_SETTINGS";

/**
 * Activity Action: Modify Airplane mode settings using a voice command.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard against this.
 * <p>
 * This intent MUST be started using
 * {@link android.service.voice.VoiceInteractionSession#startVoiceActivity
 * startVoiceActivity}.
 * <p>
 * Note: The activity implementing this intent MUST verify that
 * {@link android.app.Activity#isVoiceInteraction isVoiceInteraction} returns true before
 * modifying the setting.
 * <p>
 * Input: To tell which state airplane mode should be set to, add the
 * {@link #EXTRA_AIRPLANE_MODE_ENABLED} extra to this Intent with the state specified.
 * If the extra is not included, no changes will be made.
 * <p>
 * Output: Nothing.
 * @apiSince 23
 */

public static final java.lang.String ACTION_VOICE_CONTROL_AIRPLANE_MODE = "android.settings.VOICE_CONTROL_AIRPLANE_MODE";

/**
 * Activity Action: Modify Battery Saver mode setting using a voice command.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard against this.
 * <p>
 * This intent MUST be started using
 * {@link android.service.voice.VoiceInteractionSession#startVoiceActivity
 * startVoiceActivity}.
 * <p>
 * Note: The activity implementing this intent MUST verify that
 * {@link android.app.Activity#isVoiceInteraction isVoiceInteraction} returns true before
 * modifying the setting.
 * <p>
 * Input: To tell which state batter saver mode should be set to, add the
 * {@link #EXTRA_BATTERY_SAVER_MODE_ENABLED} extra to this Intent with the state specified.
 * If the extra is not included, no changes will be made.
 * <p>
 * Output: Nothing.
 * @apiSince 23
 */

public static final java.lang.String ACTION_VOICE_CONTROL_BATTERY_SAVER_MODE = "android.settings.VOICE_CONTROL_BATTERY_SAVER_MODE";

/**
 * Activity Action: Modify do not disturb mode settings.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard against this.
 * <p>
 * This intent MUST be started using
 * {@link android.service.voice.VoiceInteractionSession#startVoiceActivity
 * startVoiceActivity}.
 * <p>
 * Note: The Activity implementing this intent MUST verify that
 * {@link android.app.Activity#isVoiceInteraction isVoiceInteraction}.
 * returns true before modifying the setting.
 * <p>
 * Input: The optional {@link #EXTRA_DO_NOT_DISTURB_MODE_MINUTES} extra can be used to indicate
 * how long the user wishes to avoid interruptions for. The optional
 * {@link #EXTRA_DO_NOT_DISTURB_MODE_ENABLED} extra can be to indicate if the user is
 * enabling or disabling do not disturb mode. If either extra is not included, the
 * user maybe asked to provide the value.
 * <p>
 * Output: Nothing.
 * @apiSince 23
 */

public static final java.lang.String ACTION_VOICE_CONTROL_DO_NOT_DISTURB_MODE = "android.settings.VOICE_CONTROL_DO_NOT_DISTURB_MODE";

/**
 * Activity Action: Show settings to configure input methods, in particular
 * allowing the user to enable input methods.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 21
 */

public static final java.lang.String ACTION_VOICE_INPUT_SETTINGS = "android.settings.VOICE_INPUT_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of VPN.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 24
 */

public static final java.lang.String ACTION_VPN_SETTINGS = "android.settings.VPN_SETTINGS";

/**
 * Activity Action: Show VR listener settings.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 *
 * @see android.service.vr.VrListenerService
 * @apiSince 24
 */

public static final java.lang.String ACTION_VR_LISTENER_SETTINGS = "android.settings.VR_LISTENER_SETTINGS";

/**
 * Activity Action: Allows user to select current webview implementation.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 24
 */

public static final java.lang.String ACTION_WEBVIEW_SETTINGS = "android.settings.WEBVIEW_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of a static IP
 * address for Wi-Fi.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard
 * against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 3
 */

public static final java.lang.String ACTION_WIFI_IP_SETTINGS = "android.settings.WIFI_IP_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of Wi-Fi.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_WIFI_SETTINGS = "android.settings.WIFI_SETTINGS";

/**
 * Activity Action: Show settings to allow configuration of wireless controls
 * such as Wi-Fi, Bluetooth and Mobile networks.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_WIRELESS_SETTINGS = "android.settings.WIRELESS_SETTINGS";

/**
 * Activity Action: Show Zen Mode (aka Do Not Disturb) priority configuration settings.
 * @apiSince 26
 */

public static final java.lang.String ACTION_ZEN_MODE_PRIORITY_SETTINGS = "android.settings.ZEN_MODE_PRIORITY_SETTINGS";

/** @apiSince 1 */

public static final java.lang.String AUTHORITY = "settings";

/**
 * Activity Extra: Limit available options in launched activity based on the given account
 * types.
 * <p>
 * This can be passed as an extra field in an Activity Intent with one or more account types
 * as a String[]. This field is used by some intents to alter the behavior of the called
 * activity.
 * <p>
 * Example: The {@link #ACTION_ADD_ACCOUNT} intent restricts the account types to the specified
 * list.
 * @apiSince 18
 */

public static final java.lang.String EXTRA_ACCOUNT_TYPES = "account_types";

/**
 * Activity Extra: Enable or disable Airplane Mode.
 * <p>
 * This can be passed as an extra field to the {@link #ACTION_VOICE_CONTROL_AIRPLANE_MODE}
 * intent as a boolean to indicate if it should be enabled.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_AIRPLANE_MODE_ENABLED = "airplane_mode_enabled";

/**
 * Activity Extra: The package owner of the notification channel settings to display.
 * <p>
 * This must be passed as an extra field to the {@link #ACTION_CHANNEL_NOTIFICATION_SETTINGS}.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_APP_PACKAGE = "android.provider.extra.APP_PACKAGE";

/**
 * Activity Extra: Limit available options in launched activity based on the given authority.
 * <p>
 * This can be passed as an extra field in an Activity Intent with one or more syncable content
 * provider's authorities as a String[]. This field is used by some intents to alter the
 * behavior of the called activity.
 * <p>
 * Example: The {@link #ACTION_ADD_ACCOUNT} intent restricts the account types available based
 * on the authority given.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_AUTHORITIES = "authorities";

/**
 * Activity Extra: Enable or disable Battery saver mode.
 * <p>
 * This can be passed as an extra field to the {@link #ACTION_VOICE_CONTROL_BATTERY_SAVER_MODE}
 * intent as a boolean to indicate if it should be enabled.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_BATTERY_SAVER_MODE_ENABLED = "android.settings.extra.battery_saver_mode_enabled";

/**
 * Activity Extra: The {@link android.app.NotificationChannel#getId() NotificationChannel#getId()} of the notification channel settings
 * to display.
 * <p>
 * This must be passed as an extra field to the {@link #ACTION_CHANNEL_NOTIFICATION_SETTINGS}.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_CHANNEL_ID = "android.provider.extra.CHANNEL_ID";

/**
 * Activity Extra: Enable or disable Do Not Disturb mode.
 * <p>
 * This can be passed as an extra field to the {@link #ACTION_VOICE_CONTROL_DO_NOT_DISTURB_MODE}
 * intent as a boolean to indicate if it should be enabled.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_DO_NOT_DISTURB_MODE_ENABLED = "android.settings.extra.do_not_disturb_mode_enabled";

/**
 * Activity Extra: How many minutes to enable do not disturb mode for.
 * <p>
 * This can be passed as an extra field to the {@link #ACTION_VOICE_CONTROL_DO_NOT_DISTURB_MODE}
 * intent to indicate how long do not disturb mode should be enabled for.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_DO_NOT_DISTURB_MODE_MINUTES = "android.settings.extra.do_not_disturb_mode_minutes";

/** @apiSince 11 */

public static final java.lang.String EXTRA_INPUT_METHOD_ID = "input_method_id";

/**
 * An int extra specifying a subscription ID.
 *
 * @see android.telephony.SubscriptionInfo#getSubscriptionId
 * @apiSince 28
 */

public static final java.lang.String EXTRA_SUB_ID = "android.provider.extra.SUB_ID";

/**
 * Activity Category: Show application settings related to usage access.
 * <p>
 * An activity that provides a user interface for adjusting usage access related
 * preferences for its containing application. Optional but recommended for apps that
 * use {@link android.Manifest.permission#PACKAGE_USAGE_STATS}.
 * <p>
 * The activity may define meta-data to describe what usage access is
 * used for within their app with {@link #METADATA_USAGE_ACCESS_REASON}, which
 * will be displayed in Settings.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 23
 */

public static final java.lang.String INTENT_CATEGORY_USAGE_ACCESS_CONFIG = "android.intent.category.USAGE_ACCESS_CONFIG";

/**
 * Metadata key: Reason for needing usage access.
 * <p>
 * A key for metadata attached to an activity that receives action
 * {@link #INTENT_CATEGORY_USAGE_ACCESS_CONFIG}, shown to the
 * user as description of how the app uses usage access.
 * <p>
 * @apiSince 23
 */

public static final java.lang.String METADATA_USAGE_ACCESS_REASON = "android.settings.metadata.USAGE_ACCESS_REASON";
/**
 * Global system settings, containing preferences that always apply identically
 * to all defined users.  Applications can read these but are not allowed to write;
 * like the "Secure" settings, these are for preferences that the user must
 * explicitly modify through the system UI or specialized APIs for those values.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Global extends android.provider.Settings.NameValueTable {

public Global() { throw new RuntimeException("Stub!"); }

/**
 * Look up a name in the database.
 * @param resolver to access the database with
 * @param name to look up in the table
 * @return the corresponding value, or null if not present
 * @apiSince 17
 */

public static java.lang.String getString(android.content.ContentResolver resolver, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Store a name/value pair into the database.
 * @param resolver to access the database with
 * @param name to store
 * @param value to associate with the name
 * @return true if the value was set, false on database errors
 * @apiSince 17
 */

public static boolean putString(android.content.ContentResolver resolver, java.lang.String name, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Construct the content URI for a particular name/value pair,
 * useful for monitoring changes with a ContentObserver.
 * @param name to look up in the table
 * @return the corresponding content URI, or null if not present
 * @apiSince 17
 */

public static android.net.Uri getUriFor(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as an integer.  Note that internally setting values are always
 * stored as strings; this function converts the string to an integer
 * for you.  The default value will be returned if the setting is
 * not defined or not an integer.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid integer.
 * @apiSince 17
 */

public static int getInt(android.content.ContentResolver cr, java.lang.String name, int def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as an integer.  Note that internally setting values are always
 * stored as strings; this function converts the string to an integer
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not an integer.
 *
 * @return The setting's current value.
 * @apiSince 17
 */

public static int getInt(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a single settings value as an
 * integer. This will either create a new entry in the table if the
 * given name does not exist, or modify the value of the existing row
 * with that name.  Note that internally setting values are always
 * stored as strings, so this function converts the given value to a
 * string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 17
 */

public static boolean putInt(android.content.ContentResolver cr, java.lang.String name, int value) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a {@code long}.  Note that internally setting values are always
 * stored as strings; this function converts the string to a {@code long}
 * for you.  The default value will be returned if the setting is
 * not defined or not a {@code long}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid {@code long}.
 * @apiSince 17
 */

public static long getLong(android.content.ContentResolver cr, java.lang.String name, long def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a {@code long}.  Note that internally setting values are always
 * stored as strings; this function converts the string to a {@code long}
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @return The setting's current value.
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not an integer.
 * @apiSince 17
 */

public static long getLong(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a secure settings value as a long
 * integer. This will either create a new entry in the table if the
 * given name does not exist, or modify the value of the existing row
 * with that name.  Note that internally setting values are always
 * stored as strings, so this function converts the given value to a
 * string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 17
 */

public static boolean putLong(android.content.ContentResolver cr, java.lang.String name, long value) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a floating point number.  Note that internally setting values are
 * always stored as strings; this function converts the string to an
 * float for you. The default value will be returned if the setting
 * is not defined or not a valid float.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid float.
 * @apiSince 17
 */

public static float getFloat(android.content.ContentResolver cr, java.lang.String name, float def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a float.  Note that internally setting values are always
 * stored as strings; this function converts the string to a float
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not a float.
 *
 * @return The setting's current value.
 * @apiSince 17
 */

public static float getFloat(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a single settings value as a
 * floating point number. This will either create a new entry in the
 * table if the given name does not exist, or modify the value of the
 * existing row with that name.  Note that internally setting values
 * are always stored as strings, so this function converts the given
 * value to a string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 17
 */

public static boolean putFloat(android.content.ContentResolver cr, java.lang.String name, float value) { throw new RuntimeException("Stub!"); }

/**
 * Whether ADB is enabled.
 * @apiSince 17
 */

public static final java.lang.String ADB_ENABLED = "adb_enabled";

/**
 * Whether Airplane Mode is on.
 * @apiSince 17
 */

public static final java.lang.String AIRPLANE_MODE_ON = "airplane_mode_on";

/**
 * A comma separated list of radios that need to be disabled when airplane mode
 * is on. This overrides WIFI_ON and BLUETOOTH_ON, if Wi-Fi and bluetooth are
 * included in the comma separated list.
 * @apiSince 17
 */

public static final java.lang.String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";

/**
 * If not 0, the activity manager will aggressively finish activities and
 * processes as soon as they are no longer needed.  If 0, the normal
 * extended lifetime is used.
 * @apiSince 17
 */

public static final java.lang.String ALWAYS_FINISH_ACTIVITIES = "always_finish_activities";

/**
 * Scaling factor for Animator-based animations. This affects both the
 * start delay and duration of all such animations. Setting to 0 will
 * cause animations to end immediately. The default value is 1.
 * @apiSince 17
 */

public static final java.lang.String ANIMATOR_DURATION_SCALE = "animator_duration_scale";

/**
 * Whether applying ramping ringer on incoming phone call ringtone.
 * <p>1 = apply ramping ringer
 * <p>0 = do not apply ramping ringer
 * @apiSince 29
 */

public static final java.lang.String APPLY_RAMPING_RINGER = "apply_ramping_ringer";

/**
 * Value to specify if the user prefers the date, time and time zone
 * to be automatically fetched from the network (NITZ). 1=yes, 0=no
 * @apiSince 17
 */

public static final java.lang.String AUTO_TIME = "auto_time";

/**
 * Value to specify if the user prefers the time zone
 * to be automatically fetched from the network (NITZ). 1=yes, 0=no
 * @apiSince 17
 */

public static final java.lang.String AUTO_TIME_ZONE = "auto_time_zone";

/**
 * Whether bluetooth is enabled/disabled
 * 0=disabled. 1=enabled.
 * @apiSince 17
 */

public static final java.lang.String BLUETOOTH_ON = "bluetooth_on";

/**
 * Boot count since the device starts running API level 24.
 * <p>
 * Type: int
 * @apiSince 24
 */

public static final java.lang.String BOOT_COUNT = "boot_count";

/**
 * Whether to enable contacts metadata syncing or not
 * The value 1 - enable, 0 - disable
 * @apiSince 24
 */

public static final java.lang.String CONTACT_METADATA_SYNC_ENABLED = "contact_metadata_sync_enabled";

/**
 * The content:// style URL for global secure settings items.  Not public.
 * @apiSince 17
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Whether or not data roaming is enabled. (0 = false, 1 = true)
 * @apiSince 17
 */

public static final java.lang.String DATA_ROAMING = "data_roaming";

/**
 * Name of an application package to be debugged.
 * @apiSince 17
 */

public static final java.lang.String DEBUG_APP = "debug_app";

/**
 * Whether user has enabled development settings.
 * @apiSince 17
 */

public static final java.lang.String DEVELOPMENT_SETTINGS_ENABLED = "development_settings_enabled";

/**
 * The name of the device
 * @apiSince 25
 */

public static final java.lang.String DEVICE_NAME = "device_name";

/**
 * Whether the device has been provisioned (0 = false, 1 = true).
 * <p>On a multiuser device with a separate system user, the screen may be locked
 * as soon as this is set to true and further activities cannot be launched on the
 * system user unless they are marked to show over keyguard.
 * @apiSince 17
 */

public static final java.lang.String DEVICE_PROVISIONED = "device_provisioned";

/**
 * Host name and port for global http proxy. Uses ':' seperator for
 * between host and port.
 * @apiSince 17
 */

public static final java.lang.String HTTP_PROXY = "http_proxy";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#INSTALL_NON_MARKET_APPS} instead
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String INSTALL_NON_MARKET_APPS = "install_non_market_apps";

/**
 * Ringer mode. This is used internally, changing this value will not
 * change the ringer mode. See AudioManager.
 * @apiSince 17
 */

public static final java.lang.String MODE_RINGER = "mode_ringer";

/**
 * User preference for which network(s) should be used. Only the
 * connectivity service should touch this.
 * @apiSince 17
 */

public static final java.lang.String NETWORK_PREFERENCE = "network_preference";

/**
 * Constant for use in AIRPLANE_MODE_RADIOS to specify Bluetooth radio.
 * @apiSince 17
 */

public static final java.lang.String RADIO_BLUETOOTH = "bluetooth";

/**
 * Constant for use in AIRPLANE_MODE_RADIOS to specify Cellular radio.
 * @apiSince 17
 */

public static final java.lang.String RADIO_CELL = "cell";

/**
 * Constant for use in AIRPLANE_MODE_RADIOS to specify NFC radio.
 * @apiSince 17
 */

public static final java.lang.String RADIO_NFC = "nfc";

/**
 * Constant for use in AIRPLANE_MODE_RADIOS to specify Wi-Fi radio.
 * @apiSince 17
 */

public static final java.lang.String RADIO_WIFI = "wifi";

/**
 * Control whether the process CPU usage meter should be shown.
 *
 * @deprecated This functionality is no longer available as of
 * {@link android.os.Build.VERSION_CODES#N_MR1}.
 * @apiSince 17
 * @deprecatedSince 25
 */

@Deprecated public static final java.lang.String SHOW_PROCESSES = "show_processes";

/**
 * Whether we keep the device on while the device is plugged in.
 * Supported values are:
 * <ul>
 * <li>{@code 0} to never stay on while plugged in</li>
 * <li>{@link android.os.BatteryManager#BATTERY_PLUGGED_AC BatteryManager#BATTERY_PLUGGED_AC} to stay on for AC charger</li>
 * <li>{@link android.os.BatteryManager#BATTERY_PLUGGED_USB BatteryManager#BATTERY_PLUGGED_USB} to stay on for USB charger</li>
 * <li>{@link android.os.BatteryManager#BATTERY_PLUGGED_WIRELESS BatteryManager#BATTERY_PLUGGED_WIRELESS} to stay on for wireless charger</li>
 * </ul>
 * These values can be OR-ed together.
 * @apiSince 17
 */

public static final java.lang.String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";

/**
 * Scaling factor for activity transition animations. Setting to 0 will
 * disable window animations.
 * @apiSince 17
 */

public static final java.lang.String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";

/**
 * USB Mass Storage Enabled
 * @apiSince 17
 */

public static final java.lang.String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";

/**
 * If this setting is set (to anything), then all references
 * to Gmail on the device must change to Google Mail.
 * @apiSince 17
 */

public static final java.lang.String USE_GOOGLE_MAIL = "use_google_mail";

/**
 * If 1, when launching DEBUG_APP it will wait for the debugger before
 * starting user code.  If 0, it will run normally.
 * @apiSince 17
 */

public static final java.lang.String WAIT_FOR_DEBUGGER = "wait_for_debugger";

/**
 * This setting controls whether WiFi configurations created by a Device Owner app
 * should be locked down (that is, be editable or removable only by the Device Owner App,
 * not even by Settings app).
 * This setting takes integer values. Non-zero values mean DO created configurations
 * are locked down. Value of zero means they are not. Default value in the absence of
 * actual value to this setting is 0.
 * @apiSince 23
 */

public static final java.lang.String WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN = "wifi_device_owner_configs_lockdown";

/**
 * The maximum number of times we will retry a connection to an access
 * point for which we have failed in acquiring an IP address from DHCP.
 * A value of N means that we will make N+1 connection attempts in all.
 * @apiSince 17
 */

public static final java.lang.String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";

/**
 * Maximum amount of time in milliseconds to hold a wakelock while waiting for mobile
 * data connectivity to be established after a disconnect from Wi-Fi.
 * @apiSince 17
 */

public static final java.lang.String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";

/**
 * Whether to notify the user of open networks.
 * <p>
 * If not connected and the scan results have an open network, we will
 * put this notification up. If we attempt to connect to a network or
 * the open network(s) disappear, we remove the notification. When we
 * show the notification, we will not show it again for
 * {@link android.provider.Settings.Secure#WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY} time.
 *
 * @deprecated This feature is no longer controlled by this setting in
 * {@link android.os.Build.VERSION_CODES#O}.
 * @apiSince 17
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";

/**
 * Delay (in seconds) before repeating the Wi-Fi networks available notification.
 * Connecting to a network will reset the timer.
 * @apiSince 17
 */

public static final java.lang.String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";

/**
 * When the number of open networks exceeds this number, the
 * least-recently-used excess networks will be removed.
 * @apiSince 17
 */

public static final java.lang.String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";

/**
 * Whether the Wi-Fi should be on.  Only the Wi-Fi service should touch this.
 * @apiSince 17
 */

public static final java.lang.String WIFI_ON = "wifi_on";

/**
 * The policy for deciding when Wi-Fi should go to sleep (which will in
 * turn switch to using the mobile data as an Internet connection).
 * <p>
 * Set to one of {@link #WIFI_SLEEP_POLICY_DEFAULT},
 * {@link #WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED}, or
 * {@link #WIFI_SLEEP_POLICY_NEVER}.
 * @apiSince 17
 */

public static final java.lang.String WIFI_SLEEP_POLICY = "wifi_sleep_policy";

/**
 * Value for {@link #WIFI_SLEEP_POLICY} to use the default Wi-Fi sleep
 * policy, which is to sleep shortly after the turning off
 * according to the {@link #STAY_ON_WHILE_PLUGGED_IN} setting.
 * @apiSince 17
 */

public static final int WIFI_SLEEP_POLICY_DEFAULT = 0; // 0x0

/**
 * Value for {@link #WIFI_SLEEP_POLICY} to never go to sleep.
 * @apiSince 17
 */

public static final int WIFI_SLEEP_POLICY_NEVER = 2; // 0x2

/**
 * Value for {@link #WIFI_SLEEP_POLICY} to use the default policy when
 * the device is on battery, and never go to sleep when the device is
 * plugged in.
 * @apiSince 17
 */

public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1; // 0x1

/**
 * Whether the Wi-Fi watchdog is enabled.
 * @apiSince 17
 */

public static final java.lang.String WIFI_WATCHDOG_ON = "wifi_watchdog_on";

/**
 * Scaling factor for normal window animations. Setting to 0 will
 * disable window animations.
 * @apiSince 17
 */

public static final java.lang.String WINDOW_ANIMATION_SCALE = "window_animation_scale";
}

/**
 * Common base for tables of name/value settings.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class NameValueTable implements android.provider.BaseColumns {

public NameValueTable() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected static boolean putString(android.content.ContentResolver resolver, android.net.Uri uri, java.lang.String name, java.lang.String value) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.net.Uri getUriFor(android.net.Uri uri, java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final java.lang.String NAME = "name";

/** @apiSince 1 */

public static final java.lang.String VALUE = "value";
}

/**
 * <p>
 *     A Settings panel is floating UI that contains a fixed subset of settings to address a
 *     particular user problem. For example, the
 *     {@link #ACTION_INTERNET_CONNECTIVITY Internet Panel} surfaces settings related to
 *     connecting to the internet.
 * <p>
 *     Settings panels appear above the calling app to address the problem without
 *     the user needing to open Settings and thus leave their current screen.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Panel {

private Panel() { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Show a settings dialog containing settings to enable internet
 * connection.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 29
 */

public static final java.lang.String ACTION_INTERNET_CONNECTIVITY = "android.settings.panel.action.INTERNET_CONNECTIVITY";

/**
 * Activity Action: Show a settings dialog containing NFC-related settings.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 29
 */

public static final java.lang.String ACTION_NFC = "android.settings.panel.action.NFC";

/**
 * Activity Action: Show a settings dialog containing all volume streams.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 29
 */

public static final java.lang.String ACTION_VOLUME = "android.settings.panel.action.VOLUME";

/**
 * Activity Action: Show a settings dialog containing controls for Wifi.
 * <p>
 * Input: Nothing.
 * <p>
 * Output: Nothing.
 * @apiSince 29
 */

public static final java.lang.String ACTION_WIFI = "android.settings.panel.action.WIFI";
}

/**
 * Secure system settings, containing system preferences that applications
 * can read but are not allowed to write.  These are for preferences that
 * the user must explicitly modify through the system UI or specialized
 * APIs for those values, not modified directly by applications.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Secure extends android.provider.Settings.NameValueTable {

public Secure() { throw new RuntimeException("Stub!"); }

/**
 * Look up a name in the database.
 * @param resolver to access the database with
 * @param name to look up in the table
 * @return the corresponding value, or null if not present
 * @apiSince 3
 */

public static java.lang.String getString(android.content.ContentResolver resolver, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Store a name/value pair into the database.
 * @param resolver to access the database with
 * @param name to store
 * @param value to associate with the name
 * @return true if the value was set, false on database errors
 * @apiSince 3
 */

public static boolean putString(android.content.ContentResolver resolver, java.lang.String name, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Construct the content URI for a particular name/value pair,
 * useful for monitoring changes with a ContentObserver.
 * @param name to look up in the table
 * @return the corresponding content URI, or null if not present
 * @apiSince 3
 */

public static android.net.Uri getUriFor(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as an integer.  Note that internally setting values are always
 * stored as strings; this function converts the string to an integer
 * for you.  The default value will be returned if the setting is
 * not defined or not an integer.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid integer.
 * @apiSince 3
 */

public static int getInt(android.content.ContentResolver cr, java.lang.String name, int def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as an integer.  Note that internally setting values are always
 * stored as strings; this function converts the string to an integer
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not an integer.
 *
 * @return The setting's current value.
 * @apiSince 3
 */

public static int getInt(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a single settings value as an
 * integer. This will either create a new entry in the table if the
 * given name does not exist, or modify the value of the existing row
 * with that name.  Note that internally setting values are always
 * stored as strings, so this function converts the given value to a
 * string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 3
 */

public static boolean putInt(android.content.ContentResolver cr, java.lang.String name, int value) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a {@code long}.  Note that internally setting values are always
 * stored as strings; this function converts the string to a {@code long}
 * for you.  The default value will be returned if the setting is
 * not defined or not a {@code long}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid {@code long}.
 * @apiSince 3
 */

public static long getLong(android.content.ContentResolver cr, java.lang.String name, long def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a {@code long}.  Note that internally setting values are always
 * stored as strings; this function converts the string to a {@code long}
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @return The setting's current value.
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not an integer.
 * @apiSince 3
 */

public static long getLong(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a secure settings value as a long
 * integer. This will either create a new entry in the table if the
 * given name does not exist, or modify the value of the existing row
 * with that name.  Note that internally setting values are always
 * stored as strings, so this function converts the given value to a
 * string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 3
 */

public static boolean putLong(android.content.ContentResolver cr, java.lang.String name, long value) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a floating point number.  Note that internally setting values are
 * always stored as strings; this function converts the string to an
 * float for you. The default value will be returned if the setting
 * is not defined or not a valid float.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid float.
 * @apiSince 3
 */

public static float getFloat(android.content.ContentResolver cr, java.lang.String name, float def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single secure settings value
 * as a float.  Note that internally setting values are always
 * stored as strings; this function converts the string to a float
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not a float.
 *
 * @return The setting's current value.
 * @apiSince 3
 */

public static float getFloat(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a single settings value as a
 * floating point number. This will either create a new entry in the
 * table if the given name does not exist, or modify the value of the
 * existing row with that name.  Note that internally setting values
 * are always stored as strings, so this function converts the given
 * value to a string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 3
 */

public static boolean putFloat(android.content.ContentResolver cr, java.lang.String name, float value) { throw new RuntimeException("Stub!"); }

/**
 * Helper method for determining if a location provider is enabled.
 *
 * @param cr the content resolver to use
 * @param provider the location provider to query
 * @return true if the provider is enabled
 *
 * @deprecated use {@link android.location.LocationManager#isProviderEnabled(java.lang.String) LocationManager#isProviderEnabled(String)}
 * @apiSince 8
 * @deprecatedSince 19
 */

@Deprecated
public static boolean isLocationProviderEnabled(android.content.ContentResolver cr, java.lang.String provider) { throw new RuntimeException("Stub!"); }

/**
 * Thread-safe method for enabling or disabling a single location provider. This will have
 * no effect on Android Q and above.
 * @param cr the content resolver to use
 * @param provider the location provider to enable or disable
 * @param enabled true if the provider should be enabled
 * @deprecated This API is deprecated
 * @apiSince 8
 * @deprecatedSince 19
 */

@Deprecated
public static void setLocationProviderEnabled(android.content.ContentResolver cr, java.lang.String provider, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Setting that specifies whether display color inversion is enabled.
 * @apiSince 21
 */

public static final java.lang.String ACCESSIBILITY_DISPLAY_INVERSION_ENABLED = "accessibility_display_inversion_enabled";

/**
 * If accessibility is enabled.
 * @apiSince 4
 */

public static final java.lang.String ACCESSIBILITY_ENABLED = "accessibility_enabled";

/**
 * Whether to speak passwords while in accessibility mode.
 *
 * @deprecated The speaking of passwords is controlled by individual accessibility services.
 * Apps should ignore this setting and provide complete information to accessibility
 * at all times, which was the behavior when this value was {@code true}.
 * @apiSince 15
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String ACCESSIBILITY_SPEAK_PASSWORD = "speak_password";

/**
 * @deprecated Use {@link android.provider.Settings.Global#ADB_ENABLED} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String ADB_ENABLED = "adb_enabled";

/**
 * Origins for which browsers should allow geolocation by default.
 * The value is a space-separated list of origins.
 * @apiSince 8
 */

public static final java.lang.String ALLOWED_GEOLOCATION_ORIGINS = "allowed_geolocation_origins";

/**
 * Setting to allow mock locations and location provider status to be injected into the
 * LocationManager service for testing purposes during application development.  These
 * locations and status values  override actual location and status information generated
 * by network, gps, or other location providers.
 *
 * @deprecated This settings is not used anymore.
 * @apiSince 3
 * @deprecatedSince 23
 */

@Deprecated public static final java.lang.String ALLOW_MOCK_LOCATION = "mock_location";

/**
 * On Android 8.0 (API level 26) and higher versions of the platform,
 * a 64-bit number (expressed as a hexadecimal string), unique to
 * each combination of app-signing key, user, and device.
 * Values of {@code ANDROID_ID} are scoped by signing key and user.
 * The value may change if a factory reset is performed on the
 * device or if an APK signing key changes.
 *
 * For more information about how the platform handles {@code ANDROID_ID}
 * in Android 8.0 (API level 26) and higher, see <a
 * href="{@docRoot}about/versions/oreo/android-8.0-changes.html#privacy-all">
 * Android 8.0 Behavior Changes</a>.
 *
 * <p class="note"><strong>Note:</strong> For apps that were installed
 * prior to updating the device to a version of Android 8.0
 * (API level 26) or higher, the value of {@code ANDROID_ID} changes
 * if the app is uninstalled and then reinstalled after the OTA.
 * To preserve values across uninstalls after an OTA to Android 8.0
 * or higher, developers can use
 * <a href="{@docRoot}guide/topics/data/keyvaluebackup.html">
 * Key/Value Backup</a>.</p>
 *
 * <p>In versions of the platform lower than Android 8.0 (API level 26),
 * a 64-bit number (expressed as a hexadecimal string) that is randomly
 * generated when the user first sets up the device and should remain
 * constant for the lifetime of the user's device.
 *
 * On devices that have
 * <a href="{@docRoot}about/versions/android-4.2.html#MultipleUsers">
 * multiple users</a>, each user appears as a
 * completely separate device, so the {@code ANDROID_ID} value is
 * unique to each user.</p>
 *
 * <p class="note"><strong>Note:</strong> If the caller is an Instant App the ID is scoped
 * to the Instant App, it is generated when the Instant App is first installed and reset if
 * the user clears the Instant App.
 * @apiSince 3
 */

public static final java.lang.String ANDROID_ID = "android_id";

/**
 * Whether background data usage is allowed.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH VERSION_CODES#ICE_CREAM_SANDWICH},
 *             availability of background data depends on several
 *             combined factors. When background data is unavailable,
 *             {@link android.net.ConnectivityManager#getActiveNetworkInfo() ConnectivityManager#getActiveNetworkInfo()} will
 *             now appear disconnected.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String BACKGROUND_DATA = "background_data";

/**
 * @deprecated Use {@link android.provider.Settings.Global#BLUETOOTH_ON} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String BLUETOOTH_ON = "bluetooth_on";

/**
 * The content:// style URL for this table
 * @apiSince 3
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * @deprecated Use {@link android.provider.Settings.Global#DATA_ROAMING} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String DATA_ROAMING = "data_roaming";

/**
 * Setting to record the input method used by default, holding the ID
 * of the desired method.
 * @apiSince 3
 */

public static final java.lang.String DEFAULT_INPUT_METHOD = "default_input_method";

/**
 * @deprecated Use {@link android.provider.Settings.Global#DEVELOPMENT_SETTINGS_ENABLED}
 * instead
 * @apiSince 16
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String DEVELOPMENT_SETTINGS_ENABLED = "development_settings_enabled";

/**
 * @deprecated Use {@link android.provider.Settings.Global#DEVICE_PROVISIONED} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String DEVICE_PROVISIONED = "device_provisioned";

/**
 * List of the enabled accessibility providers.
 * @apiSince 4
 */

public static final java.lang.String ENABLED_ACCESSIBILITY_SERVICES = "enabled_accessibility_services";

/**
 * List of input methods that are currently enabled.  This is a string
 * containing the IDs of all enabled input methods, each ID separated
 * by ':'.
 *
 * Format like "ime0;subtype0;subtype1;subtype2:ime1:ime2;subtype0"
 * where imeId is ComponentName and subtype is int32.
 * @apiSince 3
 */

public static final java.lang.String ENABLED_INPUT_METHODS = "enabled_input_methods";

/**
 * Host name and port for global http proxy. Uses ':' seperator for
 * between host and port.
 *
 * @deprecated Use {@link android.provider.Settings.Global#HTTP_PROXY Global#HTTP_PROXY}
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String HTTP_PROXY = "http_proxy";

/**
 * Setting to record the visibility of input method selector
 * @apiSince 11
 */

public static final java.lang.String INPUT_METHOD_SELECTOR_VISIBILITY = "input_method_selector_visibility";

/**
 * Whether applications can be installed for this user via the system's
 * {@link android.content.Intent#ACTION_INSTALL_PACKAGE Intent#ACTION_INSTALL_PACKAGE} mechanism.
 *
 * <p>1 = permit app installation via the system package installer intent
 * <p>0 = do not allow use of the package installer
 * @deprecated Starting from {@link android.os.Build.VERSION_CODES#O}, apps should use
 * {@link android.content.pm.PackageManager#canRequestPackageInstalls() PackageManager#canRequestPackageInstalls()}
 * @see android.content.pm.PackageManager#canRequestPackageInstalls()
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String INSTALL_NON_MARKET_APPS = "install_non_market_apps";

/**
 * The current location mode of the device. Do not rely on this value being present or on
 * ContentObserver notifications on the corresponding Uri.
 *
 * @deprecated The preferred methods for checking location mode and listening for changes
 * are via {@link android.location.LocationManager#isLocationEnabled() LocationManager#isLocationEnabled()} and
 * {@link android.location.LocationManager#MODE_CHANGED_ACTION LocationManager#MODE_CHANGED_ACTION}.
 * @apiSince 19
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String LOCATION_MODE = "location_mode";

/**
 * This mode no longer has any distinct meaning, but is interpreted as the location mode is
 * on.
 *
 * @deprecated See {@link #LOCATION_MODE}.
 * @apiSince 19
 * @deprecatedSince 28
 */

@Deprecated public static final int LOCATION_MODE_BATTERY_SAVING = 2; // 0x2

/**
 * This mode no longer has any distinct meaning, but is interpreted as the location mode is
 * on.
 *
 * @deprecated See {@link #LOCATION_MODE}.
 * @apiSince 19
 * @deprecatedSince 28
 */

@Deprecated public static final int LOCATION_MODE_HIGH_ACCURACY = 3; // 0x3

/**
 * Location mode is off.
 * @apiSince 19
 * @deprecatedSince 28
 */

public static final int LOCATION_MODE_OFF = 0; // 0x0

/**
 * This mode no longer has any distinct meaning, but is interpreted as the location mode is
 * on.
 *
 * @deprecated See {@link #LOCATION_MODE}.
 * @apiSince 19
 * @deprecatedSince 28
 */

@Deprecated public static final int LOCATION_MODE_SENSORS_ONLY = 1; // 0x1

/**
 * Comma-separated list of location providers that are enabled. Do not rely on this value
 * being present or correct, or on ContentObserver notifications on the corresponding Uri.
 *
 * @deprecated The preferred methods for checking provider status and listening for changes
 * are via {@link android.location.LocationManager#isProviderEnabled(java.lang.String) LocationManager#isProviderEnabled(String)} and
 * {@link android.location.LocationManager#PROVIDERS_CHANGED_ACTION LocationManager#PROVIDERS_CHANGED_ACTION}.
 * @apiSince 3
 * @deprecatedSince 19
 */

@Deprecated public static final java.lang.String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";

/**
 * Whether autolock is enabled (0 = false, 1 = true)
 *
 * @deprecated Use {@link android.app.KeyguardManager} to determine the state and security
 *             level of the keyguard. Accessing this setting from an app that is targeting
 *             {@link android.os.Build.VERSION_CODES#M VERSION_CODES#M} or later throws a {@code SecurityException}.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated public static final java.lang.String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";

/**
 * Whether lock pattern will vibrate as user enters (0 = false, 1 =
 * true)
 *
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1 VERSION_CODES#JELLY_BEAN_MR1} the
 *             lockscreen uses
 *             {@link android.provider.Settings.System#HAPTIC_FEEDBACK_ENABLED Settings.System#HAPTIC_FEEDBACK_ENABLED}.
 *             Accessing this setting from an app that is targeting
 *             {@link android.os.Build.VERSION_CODES#M VERSION_CODES#M} or later throws a {@code SecurityException}.
 * @apiSince 8
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";

/**
 * Whether lock pattern is visible as user enters (0 = false, 1 = true)
 *
 * @deprecated Accessing this setting from an app that is targeting
 *             {@link android.os.Build.VERSION_CODES#M VERSION_CODES#M} or later throws a {@code SecurityException}.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated public static final java.lang.String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";

/**
 * The Logging ID (a unique 64-bit value) as a hex string.
 * Used as a pseudonymous identifier for logging.
 * @deprecated This identifier is poorly initialized and has
 * many collisions.  It should not be used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String LOGGING_ID = "logging_id";

/**
 * @deprecated Use {@link android.provider.Settings.Global#NETWORK_PREFERENCE} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String NETWORK_PREFERENCE = "network_preference";

/**
 * No longer supported.
 * @apiSince 3
 */

public static final java.lang.String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";

/**
 * No longer supported.
 * @apiSince 3
 */

public static final java.lang.String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";

/**
 * No longer supported.
 * @apiSince 3
 */

public static final java.lang.String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";

/**
 * User-selected RTT mode. When on, outgoing and incoming calls will be answered as RTT
 * calls when supported by the device and carrier. Boolean value.
 * 0 = OFF
 * 1 = ON
 * @apiSince 28
 */

public static final java.lang.String RTT_CALLING_MODE = "rtt_calling_mode";

/**
 * Setting to record the input method subtype used by default, holding the ID
 * of the desired method.
 * @apiSince 11
 */

public static final java.lang.String SELECTED_INPUT_METHOD_SUBTYPE = "selected_input_method_subtype";

/**
 * Settings classname to launch when Settings is clicked from All
 * Applications.  Needed because of user testing between the old
 * and new Settings apps.
 * @apiSince 3
 */

public static final java.lang.String SETTINGS_CLASSNAME = "settings_classname";

/**
 * If enabled, apps should try to skip any introductory hints on first launch. This might
 * apply to users that are already familiar with the environment or temporary users.
 * <p>
 * Type : int (0 to show hints, 1 to skip showing hints)
 * @apiSince 21
 */

public static final java.lang.String SKIP_FIRST_USE_HINTS = "skip_first_use_hints";

/**
 * If touch exploration is enabled.
 * @apiSince 14
 */

public static final java.lang.String TOUCH_EXPLORATION_ENABLED = "touch_exploration_enabled";

/**
 * Default text-to-speech country.
 *
 * @deprecated this setting is no longer in use, as of the Ice Cream
 * Sandwich release. Apps should never need to read this setting directly,
 * instead can query the TextToSpeech framework classes for the default
 * locale. {@link android.speech.tts.TextToSpeech#getLanguage() TextToSpeech#getLanguage()}.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String TTS_DEFAULT_COUNTRY = "tts_default_country";

/**
 * Default text-to-speech language.
 *
 * @deprecated this setting is no longer in use, as of the Ice Cream
 * Sandwich release. Apps should never need to read this setting directly,
 * instead can query the TextToSpeech framework classes for the default
 * locale. {@link android.speech.tts.TextToSpeech#getLanguage() TextToSpeech#getLanguage()}.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String TTS_DEFAULT_LANG = "tts_default_lang";

/**
 * Default text-to-speech engine pitch. 100 = 1x
 * @apiSince 4
 */

public static final java.lang.String TTS_DEFAULT_PITCH = "tts_default_pitch";

/**
 * Default text-to-speech engine speech rate. 100 = 1x
 * @apiSince 4
 */

public static final java.lang.String TTS_DEFAULT_RATE = "tts_default_rate";

/**
 * Default text-to-speech engine.
 * @apiSince 4
 */

public static final java.lang.String TTS_DEFAULT_SYNTH = "tts_default_synth";

/**
 * Default text-to-speech locale variant.
 *
 * @deprecated this setting is no longer in use, as of the Ice Cream
 * Sandwich release. Apps should never need to read this setting directly,
 * instead can query the TextToSpeech framework classes for the
 * locale that is in use {@link android.speech.tts.TextToSpeech#getLanguage() TextToSpeech#getLanguage()}.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String TTS_DEFAULT_VARIANT = "tts_default_variant";

/**
 * Space delimited list of plugin packages that are enabled.
 * @apiSince 8
 */

public static final java.lang.String TTS_ENABLED_PLUGINS = "tts_enabled_plugins";

/**
 * Setting to always use the default text-to-speech settings regardless
 * of the application settings.
 * 1 = override application settings,
 * 0 = use application settings (if specified).
 *
 * @deprecated  The value of this setting is no longer respected by
 * the framework text to speech APIs as of the Ice Cream Sandwich release.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String TTS_USE_DEFAULTS = "tts_use_defaults";

/**
 * @deprecated Use {@link android.provider.Settings.Global#USB_MASS_STORAGE_ENABLED} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";

/**
 * @deprecated Use {@link android.provider.Settings.Global#USE_GOOGLE_MAIL} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String USE_GOOGLE_MAIL = "use_google_mail";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Global#WIFI_MAX_DHCP_RETRY_COUNT} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Global#WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON}
 * instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY}
 * instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_NUM_OPEN_NETWORKS_KEPT}
 * instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_ON}
 * instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_ON = "wifi_on";

/**
 * The acceptable packet loss percentage (range 0 - 100) before trying
 * another AP on the same network.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";

/**
 * The number of access points required for a network in order for the
 * watchdog to monitor it.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";

/**
 * The delay between background checks.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";

/**
 * Whether the Wi-Fi watchdog is enabled for background checking even
 * after it thinks the user has connected to a good access point.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";

/**
 * The timeout for a background ping
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";

/**
 * The number of initial pings to perform that *may* be ignored if they
 * fail. Again, if these fail, they will *not* be used in packet loss
 * calculation. For example, one network always seemed to time out for
 * the first couple pings, so this is set to 3 by default.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";

/**
 * The maximum number of access points (per network) to attempt to test.
 * If this number is reached, the watchdog will no longer monitor the
 * initial connection state for the network. This is a safeguard for
 * networks containing multiple APs whose DNS does not respond to pings.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_WATCHDOG_ON} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_ON = "wifi_watchdog_on";

/**
 * The number of pings to test if an access point is a good connection.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";

/**
 * The delay between pings.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";

/**
 * The timeout per ping.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";

/**
 * A comma-separated list of SSIDs for which the Wi-Fi watchdog should be enabled.
 * @deprecated This setting is not used.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_WATCH_LIST = "wifi_watchdog_watch_list";
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SettingNotFoundException extends android.util.AndroidException {

/** @apiSince 1 */

public SettingNotFoundException(java.lang.String msg) { throw new RuntimeException("Stub!"); }
}

/**
 * System settings, containing miscellaneous system preferences.  This
 * table holds simple name/value pairs.  There are convenience
 * functions for accessing individual settings entries.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class System extends android.provider.Settings.NameValueTable {

public System() { throw new RuntimeException("Stub!"); }

/**
 * Look up a name in the database.
 * @param resolver to access the database with
 * @param name to look up in the table
 * @return the corresponding value, or null if not present
 * @apiSince 1
 */

public static java.lang.String getString(android.content.ContentResolver resolver, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Store a name/value pair into the database.
 * @param resolver to access the database with
 * @param name to store
 * @param value to associate with the name
 * @return true if the value was set, false on database errors
 * @apiSince 1
 */

public static boolean putString(android.content.ContentResolver resolver, java.lang.String name, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Construct the content URI for a particular name/value pair,
 * useful for monitoring changes with a ContentObserver.
 * @param name to look up in the table
 * @return the corresponding content URI, or null if not present
 * @apiSince 1
 */

public static android.net.Uri getUriFor(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single system settings value
 * as an integer.  Note that internally setting values are always
 * stored as strings; this function converts the string to an integer
 * for you.  The default value will be returned if the setting is
 * not defined or not an integer.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid integer.
 * @apiSince 1
 */

public static int getInt(android.content.ContentResolver cr, java.lang.String name, int def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single system settings value
 * as an integer.  Note that internally setting values are always
 * stored as strings; this function converts the string to an integer
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not an integer.
 *
 * @return The setting's current value.
 * @apiSince 1
 */

public static int getInt(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a single settings value as an
 * integer. This will either create a new entry in the table if the
 * given name does not exist, or modify the value of the existing row
 * with that name.  Note that internally setting values are always
 * stored as strings, so this function converts the given value to a
 * string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 1
 */

public static boolean putInt(android.content.ContentResolver cr, java.lang.String name, int value) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single system settings value
 * as a {@code long}.  Note that internally setting values are always
 * stored as strings; this function converts the string to a {@code long}
 * for you.  The default value will be returned if the setting is
 * not defined or not a {@code long}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid {@code long}.
 * @apiSince 3
 */

public static long getLong(android.content.ContentResolver cr, java.lang.String name, long def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single system settings value
 * as a {@code long}.  Note that internally setting values are always
 * stored as strings; this function converts the string to a {@code long}
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @return The setting's current value.
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not an integer.
 * @apiSince 3
 */

public static long getLong(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a single settings value as a long
 * integer. This will either create a new entry in the table if the
 * given name does not exist, or modify the value of the existing row
 * with that name.  Note that internally setting values are always
 * stored as strings, so this function converts the given value to a
 * string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 3
 */

public static boolean putLong(android.content.ContentResolver cr, java.lang.String name, long value) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single system settings value
 * as a floating point number.  Note that internally setting values are
 * always stored as strings; this function converts the string to an
 * float for you. The default value will be returned if the setting
 * is not defined or not a valid float.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 * @param def Value to return if the setting is not defined.
 *
 * @return The setting's current value, or 'def' if it is not defined
 * or not a valid float.
 * @apiSince 1
 */

public static float getFloat(android.content.ContentResolver cr, java.lang.String name, float def) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for retrieving a single system settings value
 * as a float.  Note that internally setting values are always
 * stored as strings; this function converts the string to a float
 * for you.
 * <p>
 * This version does not take a default value.  If the setting has not
 * been set, or the string value is not a number,
 * it throws {@link android.provider.Settings.SettingNotFoundException SettingNotFoundException}.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to retrieve.
 *
 * @throws android.provider.Settings.SettingNotFoundException Thrown if a setting by the given
 * name can't be found or the setting value is not a float.
 *
 * @return The setting's current value.
 * @apiSince 1
 */

public static float getFloat(android.content.ContentResolver cr, java.lang.String name) throws android.provider.Settings.SettingNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for updating a single settings value as a
 * floating point number. This will either create a new entry in the
 * table if the given name does not exist, or modify the value of the
 * existing row with that name.  Note that internally setting values
 * are always stored as strings, so this function converts the given
 * value to a string before storing it.
 *
 * @param cr The ContentResolver to access.
 * @param name The name of the setting to modify.
 * @param value The new value for the setting.
 * @return true if the value was set, false on database errors
 * @apiSince 1
 */

public static boolean putFloat(android.content.ContentResolver cr, java.lang.String name, float value) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function to read all of the current
 * configuration-related settings into a
 * {@link android.content.res.Configuration Configuration} object.
 *
 * @param cr The ContentResolver to access.
 * @param outConfig Where to place the configuration settings.
 * @apiSince 1
 */

public static void getConfiguration(android.content.ContentResolver cr, android.content.res.Configuration outConfig) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function to write a batch of configuration-related
 * settings from a {@link android.content.res.Configuration Configuration} object.
 *
 * @param cr The ContentResolver to access.
 * @param config The settings to write.
 * @return true if the values were set, false on database errors
 * @apiSince 1
 */

public static boolean putConfiguration(android.content.ContentResolver cr, android.content.res.Configuration config) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated - Do not use
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public static boolean getShowGTalkServiceStatus(android.content.ContentResolver cr) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated - Do not use
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public static void setShowGTalkServiceStatus(android.content.ContentResolver cr, boolean flag) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified app can modify system settings. As of API
 * level 23, an app cannot modify system settings unless it declares the
 * {@link android.Manifest.permission#WRITE_SETTINGS}
 * permission in its manifest, <em>and</em> the user specifically grants
 * the app this capability. To prompt the user to grant this approval,
 * the app must send an intent with the action {@link
 * android.provider.Settings#ACTION_MANAGE_WRITE_SETTINGS}, which causes
 * the system to display a permission management screen.
 *
 * @param context App context.
 * @return true if the calling app can write to system settings, false otherwise
 * @apiSince 23
 */

public static boolean canWrite(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Control whether the accelerometer will be used to change screen
 * orientation.  If 0, it will not be used unless explicitly requested
 * by the application; if 1, it will be used by default unless explicitly
 * disabled by the application.
 * @apiSince 3
 */

public static final java.lang.String ACCELEROMETER_ROTATION = "accelerometer_rotation";

/**
 * @deprecated Use {@link android.provider.Settings.Global#ADB_ENABLED}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String ADB_ENABLED = "adb_enabled";

/**
 * @deprecated Use {@link android.provider.Settings.Global#AIRPLANE_MODE_ON} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String AIRPLANE_MODE_ON = "airplane_mode_on";

/**
 * @deprecated Use {@link android.provider.Settings.Global#AIRPLANE_MODE_RADIOS} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String AIRPLANE_MODE_RADIOS = "airplane_mode_radios";

/**
 * Persistent store for the system-wide default alarm alert.
 *
 * @see #RINGTONE
 * @see #DEFAULT_ALARM_ALERT_URI
 * @apiSince 5
 */

public static final java.lang.String ALARM_ALERT = "alarm_alert";

/**
 * If 1, the activity manager will aggressively finish activities and
 * processes as soon as they are no longer needed.  If 0, the normal
 * extended lifetime is used.
 *
 * @deprecated Use {@link android.provider.Settings.Global#ALWAYS_FINISH_ACTIVITIES Global#ALWAYS_FINISH_ACTIVITIES} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String ALWAYS_FINISH_ACTIVITIES = "always_finish_activities";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#ANDROID_ID} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String ANDROID_ID = "android_id";

/**
 * Scaling factor for Animator-based animations. This affects both the start delay and
 * duration of all such animations. Setting to 0 will cause animations to end immediately.
 * The default value is 1.
 *
 * @deprecated Use {@link android.provider.Settings.Global#ANIMATOR_DURATION_SCALE Global#ANIMATOR_DURATION_SCALE} instead
 * @apiSince 16
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String ANIMATOR_DURATION_SCALE = "animator_duration_scale";

/**
 * @deprecated Use {@link android.provider.Settings.Global#AUTO_TIME}
 * instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String AUTO_TIME = "auto_time";

/**
 * @deprecated Use {@link android.provider.Settings.Global#AUTO_TIME_ZONE}
 * instead
 * @apiSince 11
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String AUTO_TIME_ZONE = "auto_time_zone";

/**
 * Determines whether remote devices may discover and/or connect to
 * this device.
 * <P>Type: INT</P>
 * 2 -- discoverable and connectable
 * 1 -- connectable but not discoverable
 * 0 -- neither connectable nor discoverable
 * @apiSince 1
 */

public static final java.lang.String BLUETOOTH_DISCOVERABILITY = "bluetooth_discoverability";

/**
 * Bluetooth discoverability timeout.  If this value is nonzero, then
 * Bluetooth becomes discoverable for a certain number of seconds,
 * after which is becomes simply connectable.  The value is in seconds.
 * @apiSince 1
 */

public static final java.lang.String BLUETOOTH_DISCOVERABILITY_TIMEOUT = "bluetooth_discoverability_timeout";

/**
 * @deprecated Use {@link android.provider.Settings.Global#BLUETOOTH_ON} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String BLUETOOTH_ON = "bluetooth_on";

/**
 * The content:// style URL for this table
 * @apiSince 1
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * @deprecated Use {@link android.provider.Settings.Global#DATA_ROAMING} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String DATA_ROAMING = "data_roaming";

/**
 * Date format string
 *   mm/dd/yyyy
 *   dd/mm/yyyy
 *   yyyy/mm/dd
 * @apiSince 1
 */

public static final java.lang.String DATE_FORMAT = "date_format";

/**
 * Name of an application package to be debugged.
 *
 * @deprecated Use {@link android.provider.Settings.Global#DEBUG_APP Global#DEBUG_APP} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String DEBUG_APP = "debug_app";

/**
 * A {@link android.net.Uri Uri} that will point to the current default alarm alert at
 * any given time.
 *
 * @see #DEFAULT_ALARM_ALERT_URI
 * @apiSince 5
 */

public static final android.net.Uri DEFAULT_ALARM_ALERT_URI;
static { DEFAULT_ALARM_ALERT_URI = null; }

/**
 * A {@link android.net.Uri Uri} that will point to the current default notification
 * sound at any given time.
 *
 * @see #DEFAULT_RINGTONE_URI
 * @apiSince 1
 */

public static final android.net.Uri DEFAULT_NOTIFICATION_URI;
static { DEFAULT_NOTIFICATION_URI = null; }

/**
 * A {@link android.net.Uri Uri} that will point to the current default ringtone at any
 * given time.
 * <p>
 * If the current default ringtone is in the DRM provider and the caller
 * does not have permission, the exception will be a
 * FileNotFoundException.
 * @apiSince 1
 */

public static final android.net.Uri DEFAULT_RINGTONE_URI;
static { DEFAULT_RINGTONE_URI = null; }

/**
 * @deprecated Use {@link android.provider.Settings.Global#DEVICE_PROVISIONED} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String DEVICE_PROVISIONED = "device_provisioned";

/**
 * Whether or not to dim the screen. 0=no  1=yes
 * @deprecated This setting is no longer used.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String DIM_SCREEN = "dim_screen";

/**
 * CDMA only settings
 * DTMF tone type played by the dialer when dialing.
 *                 0 = Normal
 *                 1 = Long
 * @apiSince 23
 */

public static final java.lang.String DTMF_TONE_TYPE_WHEN_DIALING = "dtmf_tone_type";

/**
 * Whether the audible DTMF tones are played by the dialer when dialing. The value is
 * boolean (1 or 0).
 * @apiSince 1
 */

public static final java.lang.String DTMF_TONE_WHEN_DIALING = "dtmf_tone";

/**
 * What happens when the user presses the end call button if they're not
 * on a call.<br/>
 * <b>Values:</b><br/>
 * 0 - The end button does nothing.<br/>
 * 1 - The end button goes to the home screen.<br/>
 * 2 - The end button puts the device to sleep and locks the keyguard.<br/>
 * 3 - The end button goes to the home screen.  If the user is already on the
 * home screen, it puts the device to sleep.
 * @apiSince 1
 */

public static final java.lang.String END_BUTTON_BEHAVIOR = "end_button_behavior";

/**
 * Scaling factor for fonts, float.
 * @apiSince 1
 */

public static final java.lang.String FONT_SCALE = "font_scale";

/**
 * Whether haptic feedback (Vibrate on tap) is enabled. The value is
 * boolean (1 or 0).
 * @apiSince 3
 */

public static final java.lang.String HAPTIC_FEEDBACK_ENABLED = "haptic_feedback_enabled";

/**
 * @deprecated Use {@link android.provider.Settings.Global#HTTP_PROXY} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String HTTP_PROXY = "http_proxy";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#INSTALL_NON_MARKET_APPS} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String INSTALL_NON_MARKET_APPS = "install_non_market_apps";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#LOCATION_PROVIDERS_ALLOWED}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String LOCATION_PROVIDERS_ALLOWED = "location_providers_allowed";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#LOCK_PATTERN_ENABLED}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String LOCK_PATTERN_ENABLED = "lock_pattern_autolock";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Secure#LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED}
 * instead
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED = "lock_pattern_tactile_feedback_enabled";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#LOCK_PATTERN_VISIBLE}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String LOCK_PATTERN_VISIBLE = "lock_pattern_visible_pattern";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#LOGGING_ID} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String LOGGING_ID = "logging_id";

/**
 * @deprecated Use {@link android.provider.Settings.Global#MODE_RINGER} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String MODE_RINGER = "mode_ringer";

/**
 * Determines which streams are affected by ringer and zen mode changes. The
 * stream type's bit should be set to 1 if it should be muted when going
 * into an inaudible ringer mode.
 * @apiSince 1
 */

public static final java.lang.String MODE_RINGER_STREAMS_AFFECTED = "mode_ringer_streams_affected";

/**
 * Determines which streams are affected by mute. The
 * stream type's bit should be set to 1 if it should be muted when a mute request
 * is received.
 * @apiSince 1
 */

public static final java.lang.String MUTE_STREAMS_AFFECTED = "mute_streams_affected";

/**
 * @deprecated Use {@link android.provider.Settings.Global#NETWORK_PREFERENCE} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String NETWORK_PREFERENCE = "network_preference";

/**
 * A formatted string of the next alarm that is set, or the empty string
 * if there is no alarm set.
 *
 * @deprecated Use {@link android.app.AlarmManager#getNextAlarmClock()}.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String NEXT_ALARM_FORMATTED = "next_alarm_formatted";

/**
 * Persistent store for the system-wide default notification sound.
 *
 * @see #RINGTONE
 * @see #DEFAULT_NOTIFICATION_URI
 * @apiSince 1
 */

public static final java.lang.String NOTIFICATION_SOUND = "notification_sound";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#PARENTAL_CONTROL_ENABLED}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String PARENTAL_CONTROL_ENABLED = "parental_control_enabled";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#PARENTAL_CONTROL_LAST_UPDATE}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String PARENTAL_CONTROL_LAST_UPDATE = "parental_control_last_update";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#PARENTAL_CONTROL_REDIRECT_URL}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String PARENTAL_CONTROL_REDIRECT_URL = "parental_control_redirect_url";

/**
 * @deprecated Use {@link android.provider.Settings.Global#RADIO_BLUETOOTH} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String RADIO_BLUETOOTH = "bluetooth";

/**
 * @deprecated Use {@link android.provider.Settings.Global#RADIO_CELL} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String RADIO_CELL = "cell";

/**
 * @deprecated Use {@link android.provider.Settings.Global#RADIO_NFC} instead
 * @apiSince 14
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String RADIO_NFC = "nfc";

/**
 * @deprecated Use {@link android.provider.Settings.Global#RADIO_WIFI} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String RADIO_WIFI = "wifi";

/**
 * Persistent store for the system-wide default ringtone URI.
 * <p>
 * If you need to play the default ringtone at any given time, it is recommended
 * you give {@link #DEFAULT_RINGTONE_URI} to the media player.  It will resolve
 * to the set default ringtone at the time of playing.
 *
 * @see #DEFAULT_RINGTONE_URI
 * @apiSince 1
 */

public static final java.lang.String RINGTONE = "ringtone";

/**
 * The screen backlight brightness between 0 and 255.
 * @apiSince 1
 */

public static final java.lang.String SCREEN_BRIGHTNESS = "screen_brightness";

/**
 * Control whether to enable automatic brightness mode.
 * @apiSince 8
 */

public static final java.lang.String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";

/**
 * SCREEN_BRIGHTNESS_MODE value for automatic mode.
 * @apiSince 8
 */

public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1; // 0x1

/**
 * SCREEN_BRIGHTNESS_MODE value for manual mode.
 * @apiSince 8
 */

public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0; // 0x0

/**
 * The amount of time in milliseconds before the device goes to sleep or begins
 * to dream after a period of inactivity.  This value is also known as the
 * user activity timeout period since the screen isn't necessarily turned off
 * when it expires.
 *
 * <p>
 * This value is bounded by maximum timeout set by
 * {@link android.app.admin.DevicePolicyManager#setMaximumTimeToLock(ComponentName, long)}.
 * @apiSince 1
 */

public static final java.lang.String SCREEN_OFF_TIMEOUT = "screen_off_timeout";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#SETTINGS_CLASSNAME} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String SETTINGS_CLASSNAME = "settings_classname";

/**
 * Whether the setup wizard has been run before (on first boot), or if
 * it still needs to be run.
 *
 * nonzero = it has been run in the past
 * 0 = it has not been run in the past
 * @apiSince 1
 */

public static final java.lang.String SETUP_WIZARD_HAS_RUN = "setup_wizard_has_run";

/** @apiSince 1 */

public static final java.lang.String SHOW_GTALK_SERVICE_STATUS = "SHOW_GTALK_SERVICE_STATUS";

/**
 * Control whether the process CPU usage meter should be shown.
 *
 * @deprecated This functionality is no longer available as of
 * {@link android.os.Build.VERSION_CODES#N_MR1}.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String SHOW_PROCESSES = "show_processes";

/**
 * @deprecated Each application that shows web suggestions should have its own
 * setting for this.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String SHOW_WEB_SUGGESTIONS = "show_web_suggestions";

/**
 * Whether the sounds effects (key clicks, lid open ...) are enabled. The value is
 * boolean (1 or 0).
 * @apiSince 1
 */

public static final java.lang.String SOUND_EFFECTS_ENABLED = "sound_effects_enabled";

/**
 * @deprecated Use {@link android.provider.Settings.Global#STAY_ON_WHILE_PLUGGED_IN} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String STAY_ON_WHILE_PLUGGED_IN = "stay_on_while_plugged_in";

/**
 * Setting to enable Auto Caps in text editors. 1 = On, 0 = Off
 * @apiSince 1
 */

public static final java.lang.String TEXT_AUTO_CAPS = "auto_caps";

/**
 * Setting to enable Auto Punctuate in text editors. 1 = On, 0 = Off. This
 * feature converts two spaces to a "." and space.
 * @apiSince 1
 */

public static final java.lang.String TEXT_AUTO_PUNCTUATE = "auto_punctuate";

/**
 * Setting to enable Auto Replace (AutoText) in text editors. 1 = On, 0 = Off
 * @apiSince 1
 */

public static final java.lang.String TEXT_AUTO_REPLACE = "auto_replace";

/**
 * Setting to showing password characters in text editors. 1 = On, 0 = Off
 * @apiSince 1
 */

public static final java.lang.String TEXT_SHOW_PASSWORD = "show_password";

/**
 * Display times as 12 or 24 hours
 *   12
 *   24
 * @apiSince 1
 */

public static final java.lang.String TIME_12_24 = "time_12_24";

/**
 * Scaling factor for activity transition animations. Setting to 0 will disable window
 * animations.
 *
 * @deprecated Use {@link android.provider.Settings.Global#TRANSITION_ANIMATION_SCALE Global#TRANSITION_ANIMATION_SCALE} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String TRANSITION_ANIMATION_SCALE = "transition_animation_scale";

/**
 * @deprecated Use {@link android.provider.Settings.Global#USB_MASS_STORAGE_ENABLED} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String USB_MASS_STORAGE_ENABLED = "usb_mass_storage_enabled";

/**
 * Default screen rotation when no other policy applies.
 * When {@link #ACCELEROMETER_ROTATION} is zero and no on-screen Activity expresses a
 * preference, this rotation value will be used. Must be one of the
 * {@link android.view.Surface#ROTATION_0 Surface rotation constants}.
 *
 * @see android.view.Display#getRotation
 * @apiSince 11
 */

public static final java.lang.String USER_ROTATION = "user_rotation";

/**
 * @deprecated Use {@link android.provider.Settings.Global#USE_GOOGLE_MAIL} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String USE_GOOGLE_MAIL = "use_google_mail";

/**
 * Whether vibrate is on for different events. This is used internally,
 * changing this value will not change the vibrate. See AudioManager.
 * @apiSince 1
 */

public static final java.lang.String VIBRATE_ON = "vibrate_on";

/**
 * Whether the phone vibrates when it is ringing due to an incoming call. This will
 * be used by Phone and Setting apps; it shouldn't affect other apps.
 * The value is boolean (1 or 0).
 *
 * Note: this is not same as "vibrate on ring", which had been available until ICS.
 * It was about AudioManager's setting and thus affected all the applications which
 * relied on the setting, while this is purely about the vibration setting for incoming
 * calls.
 * @apiSince 23
 */

public static final java.lang.String VIBRATE_WHEN_RINGING = "vibrate_when_ringing";

/**
 * If 1, when launching DEBUG_APP it will wait for the debugger before
 * starting user code.  If 0, it will run normally.
 *
 * @deprecated Use {@link android.provider.Settings.Global#WAIT_FOR_DEBUGGER Global#WAIT_FOR_DEBUGGER} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WAIT_FOR_DEBUGGER = "wait_for_debugger";

/**
 * Name of activity to use for wallpaper on the home screen.
 *
 * @deprecated Use {@link android.app.WallpaperManager WallpaperManager} instead.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WALLPAPER_ACTIVITY = "wallpaper_activity";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Global#WIFI_MAX_DHCP_RETRY_COUNT} instead
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_MAX_DHCP_RETRY_COUNT = "wifi_max_dhcp_retry_count";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Global#WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS} instead
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Global#WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON = "wifi_networks_available_notification_on";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Global#WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY = "wifi_networks_available_repeat_delay";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_NUM_OPEN_NETWORKS_KEPT}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_NUM_OPEN_NETWORKS_KEPT = "wifi_num_open_networks_kept";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_ON} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_ON = "wifi_on";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_SLEEP_POLICY} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_SLEEP_POLICY = "wifi_sleep_policy";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_SLEEP_POLICY_DEFAULT} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int WIFI_SLEEP_POLICY_DEFAULT = 0; // 0x0

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_SLEEP_POLICY_NEVER} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int WIFI_SLEEP_POLICY_NEVER = 2; // 0x2

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED} instead
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int WIFI_SLEEP_POLICY_NEVER_WHILE_PLUGGED = 1; // 0x1

/**
 * If using static IP, the primary DNS's IP address.
 * <p>
 * Example: "192.168.1.1"
 *
 * @deprecated Use {@link android.net.wifi.WifiManager WifiManager} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_STATIC_DNS1 = "wifi_static_dns1";

/**
 * If using static IP, the secondary DNS's IP address.
 * <p>
 * Example: "192.168.1.2"
 *
 * @deprecated Use {@link android.net.wifi.WifiManager WifiManager} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_STATIC_DNS2 = "wifi_static_dns2";

/**
 * If using static IP, the gateway's IP address.
 * <p>
 * Example: "192.168.1.1"
 *
 * @deprecated Use {@link android.net.wifi.WifiManager WifiManager} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_STATIC_GATEWAY = "wifi_static_gateway";

/**
 * The static IP address.
 * <p>
 * Example: "192.168.1.51"
 *
 * @deprecated Use {@link android.net.wifi.WifiManager WifiManager} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_STATIC_IP = "wifi_static_ip";

/**
 * If using static IP, the net mask.
 * <p>
 * Example: "255.255.255.0"
 *
 * @deprecated Use {@link android.net.wifi.WifiManager WifiManager} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_STATIC_NETMASK = "wifi_static_netmask";

/**
 * Whether to use static IP and other static network attributes.
 * <p>
 * Set to 1 for true and 0 for false.
 *
 * @deprecated Use {@link android.net.wifi.WifiManager WifiManager} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WIFI_USE_STATIC_IP = "wifi_use_static_ip";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Secure#WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE = "wifi_watchdog_acceptable_packet_loss_percentage";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#WIFI_WATCHDOG_AP_COUNT} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_AP_COUNT = "wifi_watchdog_ap_count";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Secure#WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS = "wifi_watchdog_background_check_delay_ms";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Secure#WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED = "wifi_watchdog_background_check_enabled";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Secure#WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS = "wifi_watchdog_background_check_timeout_ms";

/**
 * @deprecated Use
 * {@link android.provider.Settings.Secure#WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT = "wifi_watchdog_initial_ignored_ping_count";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#WIFI_WATCHDOG_MAX_AP_CHECKS}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_MAX_AP_CHECKS = "wifi_watchdog_max_ap_checks";

/**
 * @deprecated Use {@link android.provider.Settings.Global#WIFI_WATCHDOG_ON} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_ON = "wifi_watchdog_on";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#WIFI_WATCHDOG_PING_COUNT} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_PING_COUNT = "wifi_watchdog_ping_count";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#WIFI_WATCHDOG_PING_DELAY_MS}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_PING_DELAY_MS = "wifi_watchdog_ping_delay_ms";

/**
 * @deprecated Use {@link android.provider.Settings.Secure#WIFI_WATCHDOG_PING_TIMEOUT_MS}
 * instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String WIFI_WATCHDOG_PING_TIMEOUT_MS = "wifi_watchdog_ping_timeout_ms";

/**
 * Scaling factor for normal window animations. Setting to 0 will disable window
 * animations.
 *
 * @deprecated Use {@link android.provider.Settings.Global#WINDOW_ANIMATION_SCALE Global#WINDOW_ANIMATION_SCALE} instead
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String WINDOW_ANIMATION_SCALE = "window_animation_scale";
}

}

