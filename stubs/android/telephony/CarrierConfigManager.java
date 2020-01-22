/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.telephony;

import android.os.PersistableBundle;
import android.Manifest;
import android.service.carrier.CarrierService;
import android.content.ComponentName;
import android.content.Context;
import android.telecom.TelecomManager;

/**
 * Provides access to telephony configuration values that are carrier-specific.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CarrierConfigManager {

CarrierConfigManager() { throw new RuntimeException("Stub!"); }

/**
 * Gets the configuration values for a particular subscription, which is associated with a
 * specific SIM card. If an invalid subId is used, the returned config will contain default
 * values. After using this method to get the configuration bundle,
 * {@link #isConfigForIdentifiedCarrier(android.os.PersistableBundle)} should be called to confirm whether
 * any carrier specific configuration has been applied.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 *
 * @param subId the subscription ID, normally obtained from {@link android.telephony.SubscriptionManager SubscriptionManager}.
 * @return A {@link android.os.PersistableBundle PersistableBundle} containing the config for the given subId, or default
 *         values for an invalid subId.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.os.PersistableBundle getConfigForSubId(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the configuration values for the default subscription. After using this method to get
 * the configuration bundle, {@link #isConfigForIdentifiedCarrier(android.os.PersistableBundle)} should be
 * called to confirm whether any carrier specific configuration has been applied.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 *
 * @see #getConfigForSubId
 
 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.os.PersistableBundle getConfig() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether a configuration {@link android.os.PersistableBundle PersistableBundle} obtained from
 * {@link #getConfig()} or {@link #getConfigForSubId(int)} corresponds to an identified carrier.
 * <p>
 * When an app receives the {@link android.telephony.CarrierConfigManager#ACTION_CARRIER_CONFIG_CHANGED CarrierConfigManager#ACTION_CARRIER_CONFIG_CHANGED}
 * broadcast which informs it that the carrier configuration has changed, it is possible
 * that another reload of the carrier configuration has begun since the intent was sent.
 * In this case, the carrier configuration the app fetches (e.g. via {@link #getConfig()})
 * may not represent the configuration for the current carrier. It should be noted that it
 * does not necessarily mean the configuration belongs to current carrier when this function
 * return true because it may belong to another previous identified carrier. Users should
 * always call {@link #getConfig()} or {@link #getConfigForSubId(int)} after receiving the
 * broadcast {@link #ACTION_CARRIER_CONFIG_CHANGED}.
 * </p>
 * <p>
 * After using {@link #getConfig()} or {@link #getConfigForSubId(int)} an app should always
 * use this method to confirm whether any carrier specific configuration has been applied.
 * Especially when an app misses the broadcast {@link #ACTION_CARRIER_CONFIG_CHANGED} but it
 * still needs to get the current configuration, it must use this method to verify whether the
 * configuration is default or carrier overridden.
 * </p>
 *
 * @param bundle the configuration bundle to be checked.
 * @return boolean true if any carrier specific configuration bundle has been applied, false
 * otherwise or the bundle is null.
 * @apiSince 28
 */

public static boolean isConfigForIdentifiedCarrier(android.os.PersistableBundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Calling this method triggers telephony services to fetch the current carrier configuration.
 * <p>
 * Normally this does not need to be called because the platform reloads config on its own.
 * This should be called by a carrier service app if it wants to update config at an arbitrary
 * moment.
 * </p>
 * <p>Requires that the calling app has carrier privileges.
 * <p>
 * This method returns before the reload has completed, and
 * {@link android.service.carrier.CarrierService#onLoadConfig} will be called from an
 * arbitrary thread.
 * </p>
 * @see TelephonyManager#hasCarrierPrivileges
 * @apiSince 23
 */

public void notifyConfigChangedForSubId(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the configuration values for a component using its prefix.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 *
 * @param prefix prefix of the component.
 * This value must never be {@code null}.
 * @param subId the subscription ID, normally obtained from {@link android.telephony.SubscriptionManager SubscriptionManager}.
 *
 * @see #getConfigForSubId
 
 * @return This value may be {@code null}.
 * @apiSince R
 */

@androidx.annotation.Nullable
public android.os.PersistableBundle getConfigByComponentForSubId(@androidx.annotation.NonNull java.lang.String prefix, int subId) { throw new RuntimeException("Stub!"); }

/**
 * This intent is broadcast by the system when carrier config changes. An int is specified in
 * {@link #EXTRA_SLOT_INDEX} to indicate the slot index that this is for. An optional int extra
 * {@link #EXTRA_SUBSCRIPTION_INDEX} is included to indicate the subscription index if a valid
 * one is available for the slot index. An optional int extra
 * {@link android.telephony.TelephonyManager#EXTRA_CARRIER_ID TelephonyManager#EXTRA_CARRIER_ID} is included to indicate the carrier id for the
 * changed carrier configuration. An optional int extra
 * {@link android.telephony.TelephonyManager#EXTRA_SPECIFIC_CARRIER_ID TelephonyManager#EXTRA_SPECIFIC_CARRIER_ID} is included to indicate the precise
 * carrier id for the changed carrier configuration.
 * @see android.telephony.TelephonyManager#getSimCarrierId()
 * @see android.telephony.TelephonyManager#getSimSpecificCarrierId()
 * @apiSince 23
 */

public static final java.lang.String ACTION_CARRIER_CONFIG_CHANGED = "android.telephony.action.CARRIER_CONFIG_CHANGED";

/**
 * Flag indicating that a data cycle threshold should be disabled.
 * <p>
 * If {@link #KEY_DATA_WARNING_THRESHOLD_BYTES_LONG} is set to this value, the platform's
 * default data warning, if one exists, will be disabled. A user selected data warning will not
 * be overridden.
 * <p>
 * If {@link #KEY_DATA_LIMIT_THRESHOLD_BYTES_LONG} is set to this value, the platform's
 * default data limit, if one exists, will be disabled. A user selected data limit will not be
 * overridden.
 * @apiSince 26
 */

public static final int DATA_CYCLE_THRESHOLD_DISABLED = -2; // 0xfffffffe

/**
 * When {@link #KEY_MONTHLY_DATA_CYCLE_DAY_INT}, {@link #KEY_DATA_LIMIT_THRESHOLD_BYTES_LONG},
 * or {@link #KEY_DATA_WARNING_THRESHOLD_BYTES_LONG} are set to this value, the platform default
 * value will be used for that key.
 * @apiSince R
 */

public static final int DATA_CYCLE_USE_PLATFORM_DEFAULT = -1; // 0xffffffff

/**
 * Extra included in {@link #ACTION_CARRIER_CONFIG_CHANGED} to indicate the slot index that the
 * broadcast is for.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_SLOT_INDEX = "android.telephony.extra.SLOT_INDEX";

/**
 * Optional extra included in {@link #ACTION_CARRIER_CONFIG_CHANGED} to indicate the
 * subscription index that the broadcast is for, if a valid one is available.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_SUBSCRIPTION_INDEX = "android.telephony.extra.SUBSCRIPTION_INDEX";

/**
 * List of 4 customized 5G SS reference signal received power (SSRSRP) thresholds.
 *
 * Reference: 3GPP TS 38.215
 *
 * 4 threshold integers must be within the boundaries [-140 dB, -44 dB], and the levels are:
 *     "NONE: [-140, threshold1]"
 *     "POOR: (threshold1, threshold2]"
 *     "MODERATE: (threshold2, threshold3]"
 *     "GOOD:  (threshold3, threshold4]"
 *     "EXCELLENT:  (threshold4, -44]"
 *
 * This key is considered invalid if the format is violated. If the key is invalid or
 * not configured, a default value set will apply.
 * @apiSince R
 */

public static final java.lang.String KEY_5G_NR_SSRSRP_THRESHOLDS_INT_ARRAY = "5g_nr_ssrsrp_thresholds_int_array";

/**
 * List of 4 customized 5G SS reference signal received quality (SSRSRQ) thresholds.
 *
 * Reference: 3GPP TS 38.215
 *
 * 4 threshold integers must be within the boundaries [-20 dB, -3 dB], and the levels are:
 *     "NONE: [-20, threshold1]"
 *     "POOR: (threshold1, threshold2]"
 *     "MODERATE: (threshold2, threshold3]"
 *     "GOOD:  (threshold3, threshold4]"
 *     "EXCELLENT:  (threshold4, -3]"
 *
 * This key is considered invalid if the format is violated. If the key is invalid or
 * not configured, a default value set will apply.
 * @apiSince R
 */

public static final java.lang.String KEY_5G_NR_SSRSRQ_THRESHOLDS_INT_ARRAY = "5g_nr_ssrsrq_thresholds_int_array";

/**
 * List of 4 customized 5G SS signal-to-noise and interference ratio (SSSINR) thresholds.
 *
 * Reference: 3GPP TS 38.215,
 *            3GPP TS 38.133 10.1.16.1
 *
 * 4 threshold integers must be within the boundaries [-23 dB, 40 dB], and the levels are:
 *     "NONE: [-23, threshold1]"
 *     "POOR: (threshold1, threshold2]"
 *     "MODERATE: (threshold2, threshold3]"
 *     "GOOD:  (threshold3, threshold4]"
 *     "EXCELLENT:  (threshold4, 40]"
 *
 * This key is considered invalid if the format is violated. If the key is invalid or
 * not configured, a default value set will apply.
 * @apiSince R
 */

public static final java.lang.String KEY_5G_NR_SSSINR_THRESHOLDS_INT_ARRAY = "5g_nr_sssinr_thresholds_int_array";

/**
 * Does not display additional call setting for IMS phone based on GSM Phone
 * @apiSince 23
 */

public static final java.lang.String KEY_ADDITIONAL_CALL_SETTING_BOOL = "additional_call_setting_bool";

/**
 * Allow user to add APNs
 * @apiSince 24
 */

public static final java.lang.String KEY_ALLOW_ADDING_APNS_BOOL = "allow_adding_apns_bool";

/**
 * When true, indicates that adding a call is disabled when there is an ongoing video call
 * or when there is an ongoing call on wifi which was downgraded from video and VoWifi is
 * turned off.
 * @apiSince 25
 */

public static final java.lang.String KEY_ALLOW_ADD_CALL_DURING_VIDEO_CALL_BOOL = "allow_add_call_during_video_call";

/**
 * Determines if the current device should allow emergency numbers to be logged in the Call Log.
 * (Some carriers require that emergency calls *not* be logged, presumably to avoid the risk of
 * accidental redialing from the call log UI. This is a good idea, so the default here is
 * false.)
 * @apiSince 23
 */

public static final java.lang.String KEY_ALLOW_EMERGENCY_NUMBERS_IN_CALL_LOG_BOOL = "allow_emergency_numbers_in_call_log_bool";

/**
 * Flag indicating whether to allow carrier video calls to emergency numbers.
 * When {@code true}, video calls to emergency numbers will be allowed.  When {@code false},
 * video calls to emergency numbers will be initiated as audio-only calls instead.
 * @apiSince 24
 */

public static final java.lang.String KEY_ALLOW_EMERGENCY_VIDEO_CALLS_BOOL = "allow_emergency_video_calls_bool";

/**
 * When false, indicates that holding a video call is disabled
 * @apiSince R
 */

public static final java.lang.String KEY_ALLOW_HOLDING_VIDEO_CALL_BOOL = "allow_holding_video_call";

/**
 * Flag indicating whether or not an ongoing call will be held when an outgoing emergency call
 * is placed. If true, ongoing calls will be put on hold when an emergency call is placed. If
 * false, placing an emergency call will trigger the disconnect of all ongoing calls before
 * the emergency call is placed.
 * @apiSince R
 */

public static final java.lang.String KEY_ALLOW_HOLD_CALL_DURING_EMERGENCY_BOOL = "allow_hold_call_during_emergency_bool";

/**
 * Determine whether we want to play local DTMF tones in a call, or just let the radio/BP handle
 * playing of the tones.
 * @apiSince 23
 */

public static final java.lang.String KEY_ALLOW_LOCAL_DTMF_TONES_BOOL = "allow_local_dtmf_tones_bool";

/**
 * Flag indicating whether the carrier supports merging wifi calls when VoWIFI is disabled.
 * This can happen in the case of a carrier which allows offloading video calls to WIFI
 * separately of whether voice over wifi is enabled.  In such a scenario when two video calls
 * are downgraded to voice, they remain over wifi.  However, if VoWIFI is disabled, these calls
 * cannot be merged.
 * @apiSince 25
 */

public static final java.lang.String KEY_ALLOW_MERGE_WIFI_CALLS_WHEN_VOWIFI_OFF_BOOL = "allow_merge_wifi_calls_when_vowifi_off_bool";

/**
 * Determines whether the carrier supports making non-emergency phone calls while the phone is
 * in emergency callback mode.  Default value is {@code true}, meaning that non-emergency calls
 * are allowed in emergency callback mode.
 * @apiSince 24
 */

public static final java.lang.String KEY_ALLOW_NON_EMERGENCY_CALLS_IN_ECM_BOOL = "allow_non_emergency_calls_in_ecm_bool";

/**
 * The default flag specifying whether "Turn on Notifications" option will be always shown in
 * Settings->More->Emergency broadcasts menu regardless developer options is turned on or not.
 * @apiSince 24
 */

public static final java.lang.String KEY_ALWAYS_SHOW_EMERGENCY_ALERT_ONOFF_BOOL = "always_show_emergency_alert_onoff_bool";

/**
 * Control whether users can edit APNs in Settings.
 * @apiSince 23
 */

public static final java.lang.String KEY_APN_EXPAND_BOOL = "apn_expand_bool";

/**
 * Flag indicating if auto retry is enabled
 * @apiSince 23
 */

public static final java.lang.String KEY_AUTO_RETRY_ENABLED_BOOL = "auto_retry_enabled_bool";

/**
 * Flag indicating whether or not deactivating all call barring features via the "Call Barring"
 * settings menu is supported. If true, the option will be visible in the "Call
 * Barring" settings menu. If false, the option will not be visible.
 *
 * Enabled by default.
 * @apiSince 29
 */

public static final java.lang.String KEY_CALL_BARRING_SUPPORTS_DEACTIVATE_ALL_BOOL = "call_barring_supports_deactivate_all_bool";

/**
 * Flag indicating whether or not changing the call barring password via the "Call Barring"
 * settings menu is supported. If true, the option will be visible in the "Call
 * Barring" settings menu. If false, the option will not be visible.
 *
 * Enabled by default.
 * @apiSince 29
 */

public static final java.lang.String KEY_CALL_BARRING_SUPPORTS_PASSWORD_CHANGE_BOOL = "call_barring_supports_password_change_bool";

/**
 * Boolean indicating if the "Call barring" item is visible in the Call Settings menu.
 * If true, the "Call Barring" menu will be visible. If false, the menu will be gone.
 *
 * Disabled by default.
 * @apiSince 29
 */

public static final java.lang.String KEY_CALL_BARRING_VISIBILITY_BOOL = "call_barring_visibility_bool";

/**
 * An array containing custom call forwarding number prefixes that will be blocked while the
 * device is reporting that it is roaming. By default, there are no custom call
 * forwarding prefixes and none of these numbers will be filtered. If one or more entries are
 * present, the system will not complete the call and display an error message.
 *
 * To display a message to the user when call forwarding fails for 3gpp MMI codes while roaming,
 * use the {@link #KEY_SUPPORT_3GPP_CALL_FORWARDING_WHILE_ROAMING_BOOL} option instead.
 * @apiSince 26
 */

public static final java.lang.String KEY_CALL_FORWARDING_BLOCKS_WHILE_ROAMING_STRING_ARRAY = "call_forwarding_blocks_while_roaming_string_array";

/**
 * Flag specifying whether IMS service can be turned off. If false then the service will not be
 * turned-off completely, but individual features can be disabled.
 * @apiSince 23
 */

public static final java.lang.String KEY_CARRIER_ALLOW_TURNOFF_IMS_BOOL = "carrier_allow_turnoff_ims_bool";

/**
 * Determines whether the carrier app needed to be involved when users try to finish setting up
 * the SIM card to get network service.
 * @apiSince R
 */

public static final java.lang.String KEY_CARRIER_APP_REQUIRED_DURING_SIM_SETUP_BOOL = "carrier_app_required_during_setup_bool";

/**
 * The Component Name of a carrier-provided CallScreeningService implementation. Telecom will
 * bind to {@link android.telecom.CallScreeningService} for ALL incoming calls and provide
 * the carrier
 * CallScreeningService with the opportunity to allow or block calls.
 * <p>
 * The String includes the package name/the class name.
 * Example:
 * <item>com.android.carrier/com.android.carrier.callscreeningserviceimpl</item>
 * <p>
 * Using {@link android.content.ComponentName#flattenToString() ComponentName#flattenToString()} to convert a ComponentName object to String.
 * Using {@link android.content.ComponentName#unflattenFromString(java.lang.String) ComponentName#unflattenFromString(String)} to convert a String object to a
 * ComponentName.
 * @apiSince 29
 */

public static final java.lang.String KEY_CARRIER_CALL_SCREENING_APP_STRING = "call_screening_app";

/**
 * Specifies a value that identifies the version of the carrier configuration that is
 * currently in use. This string is displayed on the UI.
 * The format of the string is not specified.
 * @apiSince 29
 */

public static final java.lang.String KEY_CARRIER_CONFIG_VERSION_STRING = "carrier_config_version_string";

/**
 * Data call setup permanent failure causes by the carrier
 * @apiSince 26
 */

public static final java.lang.String KEY_CARRIER_DATA_CALL_PERMANENT_FAILURE_STRINGS = "carrier_data_call_permanent_failure_strings";

/**
 * Default mode for WFC over IMS on home network:
 * <ul>
 *   <li>0: Wi-Fi only
 *   <li>1: prefer mobile network
 *   <li>2: prefer Wi-Fi
 * </ul>
 * @apiSince 29
 */

public static final java.lang.String KEY_CARRIER_DEFAULT_WFC_IMS_MODE_INT = "carrier_default_wfc_ims_mode_int";

/**
 * Default mode for WFC over IMS on roaming network.
 * See {@link #KEY_CARRIER_DEFAULT_WFC_IMS_MODE_INT} for meaning of values.
 * @apiSince 29
 */

public static final java.lang.String KEY_CARRIER_DEFAULT_WFC_IMS_ROAMING_MODE_INT = "carrier_default_wfc_ims_roaming_mode_int";

/**
 * The default flag specifying whether ETWS/CMAS test setting is forcibly disabled in
 * Settings->More->Emergency broadcasts menu even though developer options is turned on.
 * @deprecated moved to cellbroadcastreceiver resource show_test_settings
 * @apiSince 24
 * @deprecatedSince R
 */

@Deprecated public static final java.lang.String KEY_CARRIER_FORCE_DISABLE_ETWS_CMAS_TEST_BOOL = "carrier_force_disable_etws_cmas_test_bool";

/**
 * Flag specifying whether Generic Bootstrapping Architecture capable SIM is required for IMS.
 * @apiSince 24
 */

public static final java.lang.String KEY_CARRIER_IMS_GBA_REQUIRED_BOOL = "carrier_ims_gba_required_bool";

/**
 * Flag specifying whether IMS instant lettering is available for the carrier.  {@code True} if
 * instant lettering is available for the carrier, {@code false} otherwise.
 * @apiSince 24
 */

public static final java.lang.String KEY_CARRIER_INSTANT_LETTERING_AVAILABLE_BOOL = "carrier_instant_lettering_available_bool";

/**
 * When IMS instant lettering is available for a carrier (see
 * {@link #KEY_CARRIER_INSTANT_LETTERING_AVAILABLE_BOOL}), determines the character encoding
 * which will be used when determining the length of messages.  Used in the InCall UI to limit
 * the number of characters the user may type.  If empty-string, the instant lettering
 * message size limit will be enforced on a 1:1 basis.  That is, each character will count
 * towards the messages size limit as a single bye.  If a character encoding is specified, the
 * message size limit will be based on the number of bytes in the message per the specified
 * encoding.
 * @apiSince 24
 */

public static final java.lang.String KEY_CARRIER_INSTANT_LETTERING_ENCODING_STRING = "carrier_instant_lettering_encoding_string";

/**
 * When IMS instant lettering is available for a carrier (see
 * {@link #KEY_CARRIER_INSTANT_LETTERING_AVAILABLE_BOOL}), determines a list of characters which
 * must be escaped with a backslash '\' character.  Should be specified as a string containing
 * the characters to be escaped.  For example to escape quote and backslash the string would be
 * a quote and a backslash.
 * @apiSince 24
 */

public static final java.lang.String KEY_CARRIER_INSTANT_LETTERING_ESCAPED_CHARS_STRING = "carrier_instant_lettering_escaped_chars_string";

/**
 * When IMS instant lettering is available for a carrier (see
 * {@link #KEY_CARRIER_INSTANT_LETTERING_AVAILABLE_BOOL}), determines the list of characters
 * which may not be contained in messages.  Should be specified as a regular expression suitable
 * for use with {@link java.lang.String#matches(java.lang.String) String#matches(String)}.
 * @apiSince 24
 */

public static final java.lang.String KEY_CARRIER_INSTANT_LETTERING_INVALID_CHARS_STRING = "carrier_instant_lettering_invalid_chars_string";

/**
 * When IMS instant lettering is available for a carrier (see
 * {@link #KEY_CARRIER_INSTANT_LETTERING_AVAILABLE_BOOL}), the length limit for messages.  Used
 * in the InCall UI to ensure the user cannot enter more characters than allowed by the carrier.
 * See also {@link #KEY_CARRIER_INSTANT_LETTERING_ENCODING_STRING} for more information on how
 * the length of the message is calculated.
 * @apiSince 24
 */

public static final java.lang.String KEY_CARRIER_INSTANT_LETTERING_LENGTH_LIMIT_INT = "carrier_instant_lettering_length_limit_int";

/**
 * Unconditionally override the carrier name string using #KEY_CARRIER_NAME_STRING.
 *
 * If true, then the carrier name string will be #KEY_CARRIER_NAME_STRING, unconditionally.
 *
 * <p>If false, then the override will be performed conditionally and the
 * #KEY_CARRIER_NAME_STRING will have the lowest-precedence; it will only be used in the event
 * that the name string would otherwise be empty, allowing it to serve as a last-resort. If
 * used, this value functions in place of the SPN on any/all ICC records for the corresponding
 * subscription.
 * @apiSince 28
 */

public static final java.lang.String KEY_CARRIER_NAME_OVERRIDE_BOOL = "carrier_name_override_bool";

/**
 * String to identify carrier name in CarrierConfig app. This string overrides SPN if
 * #KEY_CARRIER_NAME_OVERRIDE_BOOL is true; otherwise, it will be used if its value is provided
 * and SPN is unavailable
 * @apiSince 28
 */

public static final java.lang.String KEY_CARRIER_NAME_STRING = "carrier_name_string";

/**
 * Display carrier settings menu if true
 * @apiSince 23
 */

public static final java.lang.String KEY_CARRIER_SETTINGS_ENABLE_BOOL = "carrier_settings_enable_bool";

/**
 * Flag indicating whether or not the carrier supports Supplementary Services over the UT
 * interface for this subscription.
 *
 * If true, the device will use Supplementary Services over UT when provisioned (see
 * {@link #KEY_CARRIER_UT_PROVISIONING_REQUIRED_BOOL}). If false, this device will fallback to
 * circuit switch for supplementary services and will disable this capability for IMS entirely.
 *
 * The default value for this key is {@code true}.
 * @apiSince 29
 */

public static final java.lang.String KEY_CARRIER_SUPPORTS_SS_OVER_UT_BOOL = "carrier_supports_ss_over_ut_bool";

/** @apiSince 24 */

public static final java.lang.String KEY_CARRIER_USE_IMS_FIRST_FOR_EMERGENCY_BOOL = "carrier_use_ims_first_for_emergency_bool";

/**
 * Flag indicating whether or not the IMS MmTel UT capability requires carrier provisioning
 * before it can be set as enabled.
 *
 * If true, the UT capability will be set to false for the newly loaded subscription
 * and will require the carrier provisioning app to set the persistent provisioning result.
 * If false, the platform will not wait for provisioning status updates for the UT capability
 * and enable the UT over IMS capability for the subscription when the subscription is loaded.
 *
 * The default value for this key is {@code false}.
 * @apiSince 29
 */

public static final java.lang.String KEY_CARRIER_UT_PROVISIONING_REQUIRED_BOOL = "carrier_ut_provisioning_required_bool";

/**
 * Flag specifying whether VoLTE should be available for carrier, independent of carrier
 * provisioning. If false: hard disabled. If true: then depends on carrier provisioning,
 * availability, etc.
 * @apiSince 23
 */

public static final java.lang.String KEY_CARRIER_VOLTE_AVAILABLE_BOOL = "carrier_volte_available_bool";

/**
 * This flag specifies whether VoLTE availability is based on provisioning. By default this is
 * false.
 * @apiSince 26
 */

public static final java.lang.String KEY_CARRIER_VOLTE_PROVISIONED_BOOL = "carrier_volte_provisioned_bool";

/**
 * Flag specifying whether provisioning is required for VoLTE, Video Telephony, and WiFi
 * Calling.
 * @apiSince 23
 */

public static final java.lang.String KEY_CARRIER_VOLTE_PROVISIONING_REQUIRED_BOOL = "carrier_volte_provisioning_required_bool";

/**
 * Flag specifying whether VoLTE TTY is supported.
 * @apiSince 23
 */

public static final java.lang.String KEY_CARRIER_VOLTE_TTY_SUPPORTED_BOOL = "carrier_volte_tty_supported_bool";

/**
 * Flag specifying whether video telephony is available for carrier. If false: hard disabled.
 * If true: then depends on carrier provisioning, availability, etc.
 * @apiSince 23
 */

public static final java.lang.String KEY_CARRIER_VT_AVAILABLE_BOOL = "carrier_vt_available_bool";

/**
 * The package name of the carrier's visual voicemail app to ensure that dialer visual voicemail
 * and carrier visual voicemail are not active at the same time.
 *
 * @deprecated use {@link #KEY_CARRIER_VVM_PACKAGE_NAME_STRING_ARRAY}.
 * @apiSince 23
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String KEY_CARRIER_VVM_PACKAGE_NAME_STRING = "carrier_vvm_package_name_string";

/**
 * A list of the carrier's visual voicemail app package names to ensure that dialer visual
 * voicemail and carrier visual voicemail are not active at the same time.
 * @apiSince 26
 */

public static final java.lang.String KEY_CARRIER_VVM_PACKAGE_NAME_STRING_ARRAY = "carrier_vvm_package_name_string_array";

/**
 * Flag specifying whether WFC over IMS should be available for carrier: independent of
 * carrier provisioning. If false: hard disabled. If true: then depends on carrier
 * provisioning, availability etc.
 * @apiSince 23
 */

public static final java.lang.String KEY_CARRIER_WFC_IMS_AVAILABLE_BOOL = "carrier_wfc_ims_available_bool";

/**
 * Flag specifying whether WFC over IMS supports the "wifi only" option.  If false, the wifi
 * calling settings will not include an option for "wifi only".  If true, the wifi calling
 * settings will include an option for "wifi only"
 * <p>
 * By default, it is assumed that WFC supports "wifi only".
 * @apiSince 24
 */

public static final java.lang.String KEY_CARRIER_WFC_SUPPORTS_WIFI_ONLY_BOOL = "carrier_wfc_supports_wifi_only_bool";

/**
 * For carriers which require an empty flash to be sent before sending the normal 3-way calling
 * flash, the duration in milliseconds of the empty flash to send.  When {@code 0}, no empty
 * flash is sent.
 * @apiSince 26
 */

public static final java.lang.String KEY_CDMA_3WAYCALL_FLASH_DELAY_INT = "cdma_3waycall_flash_delay_int";

/**
 * Specifies the amount of gap to be added in millis between postdial DTMF tones. When a
 * non-zero value is specified, the UE shall wait for the specified amount of time before it
 * sends out successive DTMF tones on the network.
 * @apiSince 24
 */

public static final java.lang.String KEY_CDMA_DTMF_TONE_DELAY_INT = "cdma_dtmf_tone_delay_int";

/**
 * Override the platform's notion of a network operator being considered non roaming.
 * Value is string array of SIDs to be considered not roaming for 3GPP2 RATs.
 * @apiSince 23
 */

public static final java.lang.String KEY_CDMA_NONROAMING_NETWORKS_STRING_ARRAY = "cdma_nonroaming_networks_string_array";

/**
 * The CDMA roaming mode (aka CDMA system select).
 *
 * <p>The value should be one of the CDMA_ROAMING_MODE_ constants in {@link android.telephony.TelephonyManager TelephonyManager}.
 * Values other than {@link android.telephony.TelephonyManager#CDMA_ROAMING_MODE_RADIO_DEFAULT TelephonyManager#CDMA_ROAMING_MODE_RADIO_DEFAULT} (which is the
 * default) will take precedence over user selection.
 *
 * @see android.telephony.TelephonyManager#CDMA_ROAMING_MODE_RADIO_DEFAULT
 * @see android.telephony.TelephonyManager#CDMA_ROAMING_MODE_HOME
 * @see android.telephony.TelephonyManager#CDMA_ROAMING_MODE_AFFILIATED
 * @see android.telephony.TelephonyManager#CDMA_ROAMING_MODE_ANY
 * @apiSince 28
 */

public static final java.lang.String KEY_CDMA_ROAMING_MODE_INT = "cdma_roaming_mode_int";

/**
 * Override the platform's notion of a network operator being considered roaming.
 * Value is string array of SIDs to be considered roaming for 3GPP2 RATs.
 * @apiSince 23
 */

public static final java.lang.String KEY_CDMA_ROAMING_NETWORKS_STRING_ARRAY = "cdma_roaming_networks_string_array";

/**
 * Flag specifying whether an additional (client initiated) intent needs to be sent on System
 * update
 * @apiSince 24
 */

public static final java.lang.String KEY_CI_ACTION_ON_SYS_UPDATE_BOOL = "ci_action_on_sys_update_bool";

/**
 * Extra to be included in the intent sent for additional action on System update
 * @apiSince 24
 */

public static final java.lang.String KEY_CI_ACTION_ON_SYS_UPDATE_EXTRA_STRING = "ci_action_on_sys_update_extra_string";

/**
 * Value of extra included in intent sent for additional action on System update
 * @apiSince 24
 */

public static final java.lang.String KEY_CI_ACTION_ON_SYS_UPDATE_EXTRA_VAL_STRING = "ci_action_on_sys_update_extra_val_string";

/**
 * Intent to be sent for the additional action on System update
 * @apiSince 24
 */

public static final java.lang.String KEY_CI_ACTION_ON_SYS_UPDATE_INTENT_STRING = "ci_action_on_sys_update_intent_string";

/**
 * The package name containing the ImsService that will be bound to the telephony framework to
 * support IMS MMTEL feature functionality instead of the device default ImsService for this
 * subscription.
 * @apiSince R
 */

public static final java.lang.String KEY_CONFIG_IMS_MMTEL_PACKAGE_OVERRIDE_STRING = "config_ims_mmtel_package_override_string";

/**
 * The package name containing the ImsService that will be bound to the telephony framework to
 * support both IMS MMTEL and RCS feature functionality instead of the device default
 * ImsService for this subscription.
 * @deprecated Use {@link #KEY_CONFIG_IMS_MMTEL_PACKAGE_OVERRIDE_STRING} and
 * {@link #KEY_CONFIG_IMS_RCS_PACKAGE_OVERRIDE_STRING} instead to configure these values
 * separately. If any of those values are not empty, they will override this value.
 * @apiSince 26
 * @deprecatedSince R
 */

@Deprecated public static final java.lang.String KEY_CONFIG_IMS_PACKAGE_OVERRIDE_STRING = "config_ims_package_override_string";

/**
 * The package name containing the ImsService that will be bound to the telephony framework to
 * support IMS RCS feature functionality instead of the device default ImsService for this
 * subscription.
 * @apiSince R
 */

public static final java.lang.String KEY_CONFIG_IMS_RCS_PACKAGE_OVERRIDE_STRING = "config_ims_rcs_package_override_string";

/**
 * Override the package that will manage {@link android.telephony.SubscriptionPlan SubscriptionPlan}
 * information instead of the {@link android.service.carrier.CarrierService CarrierService} that defines this
 * value.
 *
 * @see android.telephony.SubscriptionManager#getSubscriptionPlans(int)
 * @see android.telephony.SubscriptionManager#setSubscriptionPlans(int, java.util.List)
 * @apiSince 28
 */

public static final java.lang.String KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING = "config_plans_package_override_string";

/**
 * Flag that specifies to use the user's own phone number as the voicemail number when there is
 * no pre-loaded voicemail number on the SIM card.
 * <p>
 * {@link #KEY_DEFAULT_VM_NUMBER_STRING} takes precedence over this flag.
 * <p>
 * If false, the system default (*86) will be used instead.
 * @apiSince 28
 */

public static final java.lang.String KEY_CONFIG_TELEPHONY_USE_OWN_NUMBER_FOR_VOICEMAIL_BOOL = "config_telephony_use_own_number_for_voicemail_bool";

/**
 * If this is true, the SIM card (through Customer Service Profile EF file) will be able to
 * prevent manual operator selection. If false, this SIM setting will be ignored and manual
 * operator selection will always be available. See CPHS4_2.WW6, CPHS B.4.7.1 for more
 * information
 * @apiSince 23
 */

public static final java.lang.String KEY_CSP_ENABLED_BOOL = "csp_enabled_bool";

/**
 * Controls if the device should automatically notify the user as they reach
 * their cellular data limit. When set to {@code false} the carrier is
 * expected to have implemented their own notification mechanism. {@code true} by default.
 * @apiSince R
 */

public static final java.lang.String KEY_DATA_LIMIT_NOTIFICATION_BOOL = "data_limit_notification_bool";

/**
 * Controls the cellular data limit.
 * <p>
 * If the user uses more than this amount of data in their billing cycle, as defined by
 * {@link #KEY_MONTHLY_DATA_CYCLE_DAY_INT}, cellular data will be turned off by the user's
 * phone. If the value is set to {@link #DATA_CYCLE_THRESHOLD_DISABLED}, the data limit will be
 * disabled.
 * <p>
 * This setting may be overridden by explicit user choice. By default,
 * {@link #DATA_CYCLE_USE_PLATFORM_DEFAULT} will be used.
 * @apiSince 26
 */

public static final java.lang.String KEY_DATA_LIMIT_THRESHOLD_BYTES_LONG = "data_limit_threshold_bytes_long";

/**
 * Controls if the device should automatically notify the user when rapid
 * cellular data usage is observed. When set to {@code false} the carrier is
 * expected to have implemented their own notification mechanism.  {@code true} by default.
 * @apiSince R
 */

public static final java.lang.String KEY_DATA_RAPID_NOTIFICATION_BOOL = "data_rapid_notification_bool";

/**
 * Controls if the device should automatically notify the user as they reach
 * their cellular data warning. When set to {@code false} the carrier is
 * expected to have implemented their own notification mechanism. {@code true} by default.
 * @apiSince R
 */

public static final java.lang.String KEY_DATA_WARNING_NOTIFICATION_BOOL = "data_warning_notification_bool";

/**
 * Controls the data usage warning.
 * <p>
 * If the user uses more than this amount of data in their billing cycle, as defined by
 * {@link #KEY_MONTHLY_DATA_CYCLE_DAY_INT}, the user will be alerted about the usage.
 * If the value is set to {@link #DATA_CYCLE_THRESHOLD_DISABLED}, the data usage warning will
 * be disabled.
 * <p>
 * This setting may be overridden by explicit user choice. By default,
 * {@link #DATA_CYCLE_USE_PLATFORM_DEFAULT} will be used.
 * @apiSince 26
 */

public static final java.lang.String KEY_DATA_WARNING_THRESHOLD_BYTES_LONG = "data_warning_threshold_bytes_long";

/**
 * The default sim call manager to use when the default dialer doesn't implement one. A sim call
 * manager can control and route outgoing and incoming phone calls, even if they're placed
 * using another connection service (PSTN, for example).
 * @apiSince 23
 */

public static final java.lang.String KEY_DEFAULT_SIM_CALL_MANAGER_STRING = "default_sim_call_manager_string";

/**
 * Where there is no preloaded voicemail number on a SIM card, specifies the carrier's default
 * voicemail number while the device is both roaming and not registered for IMS.
 * When empty string, no default voicemail number is specified for roaming network and
 * unregistered state in IMS.
 * @apiSince R
 */

public static final java.lang.String KEY_DEFAULT_VM_NUMBER_ROAMING_AND_IMS_UNREGISTERED_STRING = "default_vm_number_roaming_and_ims_unregistered_string";

/**
 * Where there is no preloaded voicemail number on a SIM card, specifies the carrier's default
 * voicemail number.
 * When empty string, no default voicemail number is specified.
 * @apiSince 26
 */

public static final java.lang.String KEY_DEFAULT_VM_NUMBER_STRING = "default_vm_number_string";

/**
 * Specifies a map from dialstrings to replacements for roaming network service numbers which
 * cannot be replaced on the carrier side.
 * <p>
 * Individual entries have the format:
 * [dialstring to replace]:[replacement]
 * @apiSince 26
 */

public static final java.lang.String KEY_DIAL_STRING_REPLACE_STRING_ARRAY = "dial_string_replace_string_array";

/**
 * Disables dialing "*228" (OTASP provisioning) on CDMA carriers where it is not supported or is
 * potentially harmful by locking the SIM to 3G.
 * @apiSince 23
 */

public static final java.lang.String KEY_DISABLE_CDMA_ACTIVATION_CODE_BOOL = "disable_cdma_activation_code_bool";

/**
 * Boolean indicating the Supplementary Services(SS) is disable when airplane mode on in the
 * Call Settings menu.
 * {@code true}: SS is disable when airplane mode on.
 * {@code false}: SS is enable when airplane mode on.
 * The default value for this key is {@code false}
 * @apiSince R
 */

public static final java.lang.String KEY_DISABLE_SUPPLEMENTARY_SERVICES_IN_AIRPLANE_MODE_BOOL = "disable_supplementary_services_in_airplane_mode_bool";

/**
 * DisconnectCause array to play busy tone. Value should be array of
 * {@link android.telephony.DisconnectCause}.
 * @apiSince R
 */

public static final java.lang.String KEY_DISCONNECT_CAUSE_PLAY_BUSYTONE_INT_ARRAY = "disconnect_cause_play_busytone_int_array";

/**
 * Determines whether High Definition audio property is displayed in the dialer UI.
 * If {@code false}, remove the HD audio property from the connection so that HD audio related
 * UI is not displayed. If {@code true}, keep HD audio property as it is configured.
 * @apiSince 27
 */

public static final java.lang.String KEY_DISPLAY_HD_AUDIO_PROPERTY_BOOL = "display_hd_audio_property_bool";

/**
 * When {@code true}, if the user is in an ongoing video call over WIFI and answers an incoming
 * audio call, the video call will be disconnected before the audio call is answered.  This is
 * in contrast to the usual expected behavior where a foreground video call would be put into
 * the background and held when an incoming audio call is answered.
 * @apiSince 25
 */

public static final java.lang.String KEY_DROP_VIDEO_CALL_WHEN_ANSWERING_AUDIO_CALL_BOOL = "drop_video_call_when_answering_audio_call_bool";

/**
 * Flag indicating if dtmf tone type is enabled
 * @apiSince 23
 */

public static final java.lang.String KEY_DTMF_TYPE_ENABLED_BOOL = "dtmf_type_enabled_bool";

/**
 * The duration in seconds that platform call and message blocking is disabled after the user
 * contacts emergency services. Platform considers values for below cases:
 *  1) 0 <= VALUE <= 604800(one week): the value will be used as the duration directly.
 *  2) VALUE > 604800(one week): will use the default value as duration instead.
 *  3) VALUE < 0: block will be disabled forever until user re-eanble block manually,
 *     the suggested value to disable forever is -1.
 * See {@code android.provider.BlockedNumberContract#notifyEmergencyContact(Context)}
 * See {@code android.provider.BlockedNumberContract#isBlocked(Context, String)}.
 * @apiSince 24
 */

public static final java.lang.String KEY_DURATION_BLOCKING_DISABLED_AFTER_EMERGENCY_INT = "duration_blocking_disabled_after_emergency_int";

/**
 * Determine whether user can toggle Enhanced 4G LTE Mode in Settings.
 * @apiSince 24
 */

public static final java.lang.String KEY_EDITABLE_ENHANCED_4G_LTE_BOOL = "editable_enhanced_4g_lte_bool";

/**
 * Since the default voicemail number is empty, if a SIM card does not have a voicemail number
 * available the user cannot use voicemail. This flag allows the user to edit the voicemail
 * number in such cases, and is false by default.
 * @apiSince 26
 */

public static final java.lang.String KEY_EDITABLE_VOICEMAIL_NUMBER_BOOL = "editable_voicemail_number_bool";

/**
 * Determine whether user can edit voicemail number in Settings.
 * @apiSince 28
 */

public static final java.lang.String KEY_EDITABLE_VOICEMAIL_NUMBER_SETTING_BOOL = "editable_voicemail_number_setting_bool";

/**
 * Indicates zero or more emergency number prefix(es), because some carrier requires
 * if users dial an emergency number address with a specific prefix, the combination of the
 * prefix and the address is also a valid emergency number to dial. For example, an emergency
 * number prefix is 318, and the emergency number is 911. Both 318911 and 911 can be dialed by
 * users for emergency call. An empty array of string indicates that current carrier does not
 * have this requirement.
 * @apiSince 29
 */

public static final java.lang.String KEY_EMERGENCY_NUMBER_PREFIX_STRING_ARRAY = "emergency_number_prefix_string_array";

/**
 * If true, enable vibration (haptic feedback) for key presses in the EmergencyDialer activity.
 * The pattern is set on a per-platform basis using config_virtualKeyVibePattern. To be
 * consistent with the regular Dialer, this value should agree with the corresponding values
 * from config.xml under apps/Contacts.
 * @apiSince 23
 */

public static final java.lang.String KEY_ENABLE_DIALER_KEY_VIBRATION_BOOL = "enable_dialer_key_vibration_bool";

/**
 * Sets the default state for the "Enhanced 4G LTE" or "Advanced Calling" mode toggle set by the
 * user. When this is {@code true}, this mode by default is on, otherwise if {@code false},
 * this mode by default is off.
 * @apiSince 29
 */

public static final java.lang.String KEY_ENHANCED_4G_LTE_ON_BY_DEFAULT_BOOL = "enhanced_4g_lte_on_by_default_bool";

/**
 * Override the platform's notion of a network operator being considered non roaming.
 * If true all networks are considered as home network a.k.a non-roaming.  When false,
 * the 2 pairs of CMDA and GSM roaming/non-roaming arrays are consulted.
 *
 * @see #KEY_GSM_ROAMING_NETWORKS_STRING_ARRAY
 * @see #KEY_GSM_NONROAMING_NETWORKS_STRING_ARRAY
 * @see #KEY_CDMA_ROAMING_NETWORKS_STRING_ARRAY
 * @see #KEY_CDMA_NONROAMING_NETWORKS_STRING_ARRAY
 * @apiSince 23
 */

public static final java.lang.String KEY_FORCE_HOME_NETWORK_BOOL = "force_home_network_bool";

/**
 * Specifies the amount of gap to be added in millis between postdial DTMF tones. When a
 * non-zero value is specified, the UE shall wait for the specified amount of time before it
 * sends out successive DTMF tones on the network.
 * @apiSince 24
 */

public static final java.lang.String KEY_GSM_DTMF_TONE_DELAY_INT = "gsm_dtmf_tone_delay_int";

/**
 * Override the platform's notion of a network operator being considered not roaming.
 * Value is string array of MCCMNCs to be considered not roaming for 3GPP RATs.
 * @apiSince 23
 */

public static final java.lang.String KEY_GSM_NONROAMING_NETWORKS_STRING_ARRAY = "gsm_nonroaming_networks_string_array";

/**
 * Override the platform's notion of a network operator being considered roaming.
 * Value is string array of MCCMNCs to be considered roaming for 3GPP RATs.
 * @apiSince 23
 */

public static final java.lang.String KEY_GSM_ROAMING_NETWORKS_STRING_ARRAY = "gsm_roaming_networks_string_array";

/**
 * Determines if device implements a noise suppression device for in call audio.
 * @apiSince 23
 */

public static final java.lang.String KEY_HAS_IN_CALL_NOISE_SUPPRESSION_BOOL = "has_in_call_noise_suppression_bool";

/**
 * Control whether users can reach the carrier portions of Cellular Network Settings.
 * @apiSince 23
 */

public static final java.lang.String KEY_HIDE_CARRIER_NETWORK_SETTINGS_BOOL = "hide_carrier_network_settings_bool";

/**
 * Determines whether the Enhanced 4G LTE toggle will be shown in the settings. When this
 * option is {@code true}, the toggle will be hidden regardless of whether the device and
 * carrier supports 4G LTE or not.
 * @apiSince 26
 */

public static final java.lang.String KEY_HIDE_ENHANCED_4G_LTE_BOOL = "hide_enhanced_4g_lte_bool";

/**
 * Determine whether IMS apn can be shown.
 * @apiSince 24
 */

public static final java.lang.String KEY_HIDE_IMS_APN_BOOL = "hide_ims_apn_bool";

/**
 * Determine whether preferred network type can be shown.
 * @apiSince 24
 */

public static final java.lang.String KEY_HIDE_PREFERRED_NETWORK_TYPE_BOOL = "hide_preferred_network_type_bool";

/**
 * Flag to hide Preset APN details. If true, user cannot enter ApnEditor view of Preset APN,
 * and cannot view details of the APN. If false, user can enter ApnEditor view of Preset APN.
 * Default value is false.
 * @apiSince 29
 */

public static final java.lang.String KEY_HIDE_PRESET_APN_DETAILS_BOOL = "hide_preset_apn_details_bool";

/**
 * Control whether users can reach the SIM lock settings.
 * @apiSince 23
 */

public static final java.lang.String KEY_HIDE_SIM_LOCK_SETTINGS_BOOL = "hide_sim_lock_settings_bool";

/**
 * Flag indicating whether the Phone app should ignore EVENT_SIM_NETWORK_LOCKED
 * events from the Sim.
 * If true, this will prevent the IccNetworkDepersonalizationPanel from being shown, and
 * effectively disable the "Sim network lock" feature.
 * @apiSince 23
 */

public static final java.lang.String KEY_IGNORE_SIM_NETWORK_LOCKED_EVENTS_BOOL = "ignore_sim_network_locked_events_bool";

/**
 * Determines the maximum number of participants the carrier supports for a conference call.
 * This number is exclusive of the current device.  A conference between 3 devices, for example,
 * would have a size limit of 2 participants.
 * Enforced when {@link #KEY_IS_IMS_CONFERENCE_SIZE_ENFORCED_BOOL} is {@code true}.
 * @apiSince 26
 */

public static final java.lang.String KEY_IMS_CONFERENCE_SIZE_LIMIT_INT = "ims_conference_size_limit_int";

/**
 * Specifies the amount of gap to be added in millis between DTMF tones. When a non-zero value
 * is specified, the UE shall wait for the specified amount of time before it sends out
 * successive DTMF tones on the network.
 * @apiSince 24
 */

public static final java.lang.String KEY_IMS_DTMF_TONE_DELAY_INT = "ims_dtmf_tone_delay_int";

/**
 * Determines whether a maximum size limit for IMS conference calls is enforced on the device.
 * When {@code true}, IMS conference calls will be limited to at most
 * {@link #KEY_IMS_CONFERENCE_SIZE_LIMIT_INT} participants.  When {@code false}, no attempt is made
 * to limit the number of participants in a conference (the carrier will raise an error when an
 * attempt is made to merge too many participants into a conference).
 * @apiSince 26
 */

public static final java.lang.String KEY_IS_IMS_CONFERENCE_SIZE_ENFORCED_BOOL = "is_ims_conference_size_enforced_bool";

/**
 * A list of 4 customized LTE Reference Signal Received Quality (RSRQ) thresholds.
 *
 * Reference: TS 136.133 v12.6.0 section 9.1.7 - RSRQ Measurement Report Mapping.
 *
 * 4 threshold integers must be within the boundaries [-34 dB, 3 dB], and the levels are:
 *     "NONE: [-34, threshold1)"
 *     "POOR: [threshold1, threshold2)"
 *     "MODERATE: [threshold2, threshold3)"
 *     "GOOD:  [threshold3, threshold4)"
 *     "EXCELLENT:  [threshold4, 3]"
 *
 * This key is considered invalid if the format is violated. If the key is invalid or
 * not configured, a default value set will apply.
 * @apiSince R
 */

public static final java.lang.String KEY_LTE_RSRQ_THRESHOLDS_INT_ARRAY = "lte_rsrq_thresholds_int_array";

/**
 * A list of 4 customized LTE Reference Signal Signal to Noise Ratio (RSSNR) thresholds.
 *
 * 4 threshold integers must be within the boundaries [-200, 300], and the levels are:
 *     "NONE: [-200, threshold1)"
 *     "POOR: [threshold1, threshold2)"
 *     "MODERATE: [threshold2, threshold3)"
 *     "GOOD:  [threshold3, threshold4)"
 *     "EXCELLENT:  [threshold4, 300]"
 * Note: the unit of the values is 10*db; it is derived by multiplying 10 on the original dB
 * value reported by modem.
 *
 * This key is considered invalid if the format is violated. If the key is invalid or
 * not configured, a default value set will apply.
 * @apiSince R
 */

public static final java.lang.String KEY_LTE_RSSNR_THRESHOLDS_INT_ARRAY = "lte_rssnr_thresholds_int_array";

/**
 * When checking if a given number is the voicemail number, if this flag is true
 * then in addition to comparing the given number to the voicemail number, we also compare it
 * to the mdn. If this flag is false, the given number is only compared to the voicemail number.
 * By default this value is false.
 * @apiSince 26
 */

public static final java.lang.String KEY_MDN_IS_ADDITIONAL_VOICEMAIL_NUMBER_BOOL = "mdn_is_additional_voicemail_number_bool";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_ALIAS_ENABLED_BOOL = "aliasEnabled";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_ALIAS_MAX_CHARS_INT = "aliasMaxChars";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_ALIAS_MIN_CHARS_INT = "aliasMinChars";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_ALLOW_ATTACH_AUDIO_BOOL = "allowAttachAudio";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_APPEND_TRANSACTION_ID_BOOL = "enabledTransID";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_EMAIL_GATEWAY_NUMBER_STRING = "emailGatewayNumber";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_GROUP_MMS_ENABLED_BOOL = "enableGroupMms";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_HTTP_PARAMS_STRING = "httpParams";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_HTTP_SOCKET_TIMEOUT_INT = "httpSocketTimeout";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MAX_IMAGE_HEIGHT_INT = "maxImageHeight";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MAX_IMAGE_WIDTH_INT = "maxImageWidth";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MAX_MESSAGE_SIZE_INT = "maxMessageSize";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MESSAGE_TEXT_MAX_SIZE_INT = "maxMessageTextSize";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MMS_DELIVERY_REPORT_ENABLED_BOOL = "enableMMSDeliveryReports";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MMS_ENABLED_BOOL = "enabledMMS";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MMS_READ_REPORT_ENABLED_BOOL = "enableMMSReadReports";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_MULTIPART_SMS_ENABLED_BOOL = "enableMultipartSMS";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_NAI_SUFFIX_STRING = "naiSuffix";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_NOTIFY_WAP_MMSC_ENABLED_BOOL = "enabledNotifyWapMMSC";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_RECIPIENT_LIMIT_INT = "recipientLimit";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SEND_MULTIPART_SMS_AS_SEPARATE_MESSAGES_BOOL = "sendMultipartSmsAsSeparateMessages";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SHOW_CELL_BROADCAST_APP_LINKS_BOOL = "config_cellBroadcastAppLinks";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SMS_DELIVERY_REPORT_ENABLED_BOOL = "enableSMSDeliveryReports";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SMS_TO_MMS_TEXT_LENGTH_THRESHOLD_INT = "smsToMmsTextLengthThreshold";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SMS_TO_MMS_TEXT_THRESHOLD_INT = "smsToMmsTextThreshold";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SUBJECT_MAX_LENGTH_INT = "maxSubjectLength";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SUPPORT_HTTP_CHARSET_HEADER_BOOL = "supportHttpCharsetHeader";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_SUPPORT_MMS_CONTENT_DISPOSITION_BOOL = "supportMmsContentDisposition";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_UA_PROF_TAG_NAME_STRING = "uaProfTagName";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_UA_PROF_URL_STRING = "uaProfUrl";

/** @apiSince 23 */

public static final java.lang.String KEY_MMS_USER_AGENT_STRING = "userAgent";

/**
 * The day of the month (1-31) on which the data cycle rolls over.
 * <p>
 * If the current month does not have this day, the cycle will roll over at
 * the start of the next month.
 * <p>
 * This setting may be still overridden by explicit user choice. By default,
 * {@link #DATA_CYCLE_USE_PLATFORM_DEFAULT} will be used.
 * @apiSince 26
 */

public static final java.lang.String KEY_MONTHLY_DATA_CYCLE_DAY_INT = "monthly_data_cycle_day_int";

/**
 * List of RIL radio technologies (See {@link android.telephony.ServiceState ServiceState} {@code RIL_RADIO_TECHNOLOGY_*}
 * constants) which support only a single data connection at a time. Some carriers do not
 * support multiple pdp on UMTS.
 * @apiSince 26
 */

public static final java.lang.String KEY_ONLY_SINGLE_DC_ALLOWED_INT_ARRAY = "only_single_dc_allowed_int_array";

/**
 * Control whether users can choose a network operator.
 * @apiSince 23
 */

public static final java.lang.String KEY_OPERATOR_SELECTION_EXPAND_BOOL = "operator_selection_expand_bool";

/**
 * Controls hysteresis time in milli seconds for which OpportunisticNetworkService
 * will wait before switching data to an opportunistic network.
 * @apiSince 29
 */

public static final java.lang.String KEY_OPPORTUNISTIC_NETWORK_DATA_SWITCH_HYSTERESIS_TIME_LONG = "opportunistic_network_data_switch_hysteresis_time_long";

/**
 * Controls hysteresis time in milli seconds for which OpportunisticNetworkService
 * will wait before attaching to a network.
 * @apiSince 29
 */

public static final java.lang.String KEY_OPPORTUNISTIC_NETWORK_ENTRY_OR_EXIT_HYSTERESIS_TIME_LONG = "opportunistic_network_entry_or_exit_hysteresis_time_long";

/**
 * Controls bandwidth threshold in Kbps at which OpportunisticNetworkService will decide whether
 * the opportunistic network is good enough for internet data.
 * @apiSince 29
 */

public static final java.lang.String KEY_OPPORTUNISTIC_NETWORK_ENTRY_THRESHOLD_BANDWIDTH_INT = "opportunistic_network_entry_threshold_bandwidth_int";

/**
 * Controls RSRP threshold at which OpportunisticNetworkService will decide whether
 * the opportunistic network is good enough for internet data.
 * @apiSince 29
 */

public static final java.lang.String KEY_OPPORTUNISTIC_NETWORK_ENTRY_THRESHOLD_RSRP_INT = "opportunistic_network_entry_threshold_rsrp_int";

/**
 * Controls RSSNR threshold at which OpportunisticNetworkService will decide whether
 * the opportunistic network is good enough for internet data.
 * @apiSince 29
 */

public static final java.lang.String KEY_OPPORTUNISTIC_NETWORK_ENTRY_THRESHOLD_RSSNR_INT = "opportunistic_network_entry_threshold_rssnr_int";

/**
 * Controls RSRP threshold below which OpportunisticNetworkService will decide whether
 * the opportunistic network available is not good enough for internet data.
 * @apiSince 29
 */

public static final java.lang.String KEY_OPPORTUNISTIC_NETWORK_EXIT_THRESHOLD_RSRP_INT = "opportunistic_network_exit_threshold_rsrp_int";

/**
 * Controls RSSNR threshold below which OpportunisticNetworkService will decide whether
 * the opportunistic network available is not good enough for internet data.
 * @apiSince 29
 */

public static final java.lang.String KEY_OPPORTUNISTIC_NETWORK_EXIT_THRESHOLD_RSSNR_INT = "opportunistic_network_exit_threshold_rssnr_int";

/**
 * Used in Cellular Network Settings for preferred network type.
 * @apiSince 23
 */

public static final java.lang.String KEY_PREFER_2G_BOOL = "prefer_2g_bool";

/**
 * Flag specifying whether to prevent sending CLIR activation("*31#") and deactivation("#31#")
 * code only without dialing number.
 * When {@code true}, these are prevented, {@code false} otherwise.
 * @apiSince R
 */

public static final java.lang.String KEY_PREVENT_CLIR_ACTIVATION_AND_DEACTIVATION_CODE_BOOL = "prevent_clir_activation_and_deactivation_code_bool";

/**
 * A list of failure cause codes that will trigger a modem restart when telephony receiving
 * one of those during data setup. The cause codes are defined in 3GPP TS 24.008 Annex I and
 * TS 24.301 Annex B.
 * @apiSince 29
 */

public static final java.lang.String KEY_RADIO_RESTART_FAILURE_CAUSES_INT_ARRAY = "radio_restart_failure_causes_int_array";

/**
 * The RCS configuration server URL. This URL is used to initiate RCS provisioning.
 * @apiSince 26
 */

public static final java.lang.String KEY_RCS_CONFIG_SERVER_URL_STRING = "rcs_config_server_url_string";

/**
 * Flag to require or skip entitlement checks.
 * If true, entitlement checks will be executed if device has been configured for it,
 * If false, entitlement checks will be skipped.
 * @apiSince 24
 */

public static final java.lang.String KEY_REQUIRE_ENTITLEMENT_CHECKS_BOOL = "require_entitlement_checks_bool";

/**
 * Flag indicating whether radio is to be restarted on error PDP_FAIL_REGULAR_DEACTIVATION
 * This is false by default.
 *
 * @deprecated Use {@link #KEY_RADIO_RESTART_FAILURE_CAUSES_INT_ARRAY} instead
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String KEY_RESTART_RADIO_ON_PDP_FAIL_REGULAR_DEACTIVATION_BOOL = "restart_radio_on_pdp_fail_regular_deactivation_bool";

/**
 * Flag indicating whether the carrier supports RTT over IMS.
 * @apiSince 28
 */

public static final java.lang.String KEY_RTT_SUPPORTED_BOOL = "rtt_supported_bool";

/**
 * Show APN Settings for some CDMA carriers
 * @apiSince 23
 */

public static final java.lang.String KEY_SHOW_APN_SETTING_CDMA_BOOL = "show_apn_setting_cdma_bool";

/**
 * Flag specifying whether to show notification(call blocking disabled) when Enhanced Call
 * Blocking(KEY_SUPPORT_ENHANCED_CALL_BLOCKING_BOOL) is enabled and making emergency call.
 * When true, notification is shown always.
 * When false, notification is shown only when any setting of "Enhanced Blocked number" is
 * enabled.
 * @apiSince 29
 */

public static final java.lang.String KEY_SHOW_CALL_BLOCKING_DISABLED_NOTIFICATION_ALWAYS_BOOL = "show_call_blocking_disabled_notification_always_bool";

/**
 * Show cdma network mode choices 1x, 3G, global etc.
 * @apiSince 23
 */

public static final java.lang.String KEY_SHOW_CDMA_CHOICES_BOOL = "show_cdma_choices_bool";

/**
 * Flag specifying whether ICCID is showed in SIM Status screen, default to false.
 * @apiSince 24
 */

public static final java.lang.String KEY_SHOW_ICCID_IN_SIM_STATUS_BOOL = "show_iccid_in_sim_status_bool";

/**
 * If true, show an onscreen "Dial" button in the dialer. In practice this is used on all
 * platforms, even the ones with hard SEND/END keys, but for maximum flexibility it's controlled
 * by a flag here (which can be overridden on a per-product basis.)
 * @apiSince 23
 */

public static final java.lang.String KEY_SHOW_ONSCREEN_DIAL_BUTTON_BOOL = "show_onscreen_dial_button_bool";

/**
 * Flag specifying whether the {@link android.telephony.SignalStrength} is shown in the SIM
 * Status screen. The default value is true.
 * @apiSince 28
 */

public static final java.lang.String KEY_SHOW_SIGNAL_STRENGTH_IN_SIM_STATUS_BOOL = "show_signal_strength_in_sim_status_bool";

/**
 * Control whether users receive a simplified network settings UI and improved network
 * selection.
 * @apiSince 26
 */

public static final java.lang.String KEY_SIMPLIFIED_NETWORK_SETTINGS_BOOL = "simplified_network_settings_bool";

/**
 * Flag indicating whether the Phone app should provide a "Dismiss" button on the SIM network
 * unlock screen. The default value is true. If set to false, there will be *no way* to dismiss
 * the SIM network unlock screen if you don't enter the correct unlock code. (One important
 * consequence: there will be no way to make an Emergency Call if your SIM is network-locked and
 * you don't know the PIN.)
 * @apiSince 23
 */

public static final java.lang.String KEY_SIM_NETWORK_UNLOCK_ALLOW_DISMISS_BOOL = "sim_network_unlock_allow_dismiss_bool";

/**
 * Determines if the carrier requires converting the destination number before sending out an
 * SMS. Certain networks and numbering plans require different formats.
 * @apiSince 26
 */

public static final java.lang.String KEY_SMS_REQUIRES_DESTINATION_NUMBER_CONVERSION_BOOL = "sms_requires_destination_number_conversion_bool";

/**
 * Indicates whether the carrier supports 3gpp call forwarding MMI codes while roaming. If
 * false, the user will be notified that call forwarding is not available when the MMI code
 * fails.
 * @apiSince 26
 */

public static final java.lang.String KEY_SUPPORT_3GPP_CALL_FORWARDING_WHILE_ROAMING_BOOL = "support_3gpp_call_forwarding_while_roaming_bool";

/**
 * Flag indicating whether to support "Network default" option in Caller ID settings for Calling
 * Line Identification Restriction (CLIR).
 * @apiSince 29
 */

public static final java.lang.String KEY_SUPPORT_CLIR_NETWORK_DEFAULT_BOOL = "support_clir_network_default_bool";

/**
 * Determines whether conference calls are supported by a carrier.  When {@code true},
 * conference calling is supported, {@code false otherwise}.
 * @apiSince 24
 */

public static final java.lang.String KEY_SUPPORT_CONFERENCE_CALL_BOOL = "support_conference_call_bool";

/**
 * Flag indicating whether or not sending emergency SMS messages over IMS
 * is supported when in LTE/limited LTE (Emergency only) service mode..
 *
 * @apiSince 29
 */

public static final java.lang.String KEY_SUPPORT_EMERGENCY_SMS_OVER_IMS_BOOL = "support_emergency_sms_over_ims_bool";

/**
 * For IMS video over LTE calls, determines whether video pause signalling is supported.
 * @apiSince 23
 */

public static final java.lang.String KEY_SUPPORT_PAUSE_IMS_VIDEO_CALLS_BOOL = "support_pause_ims_video_calls_bool";

/**
 * After a CDMA conference call is merged, the swap button should be displayed.
 * @apiSince 23
 */

public static final java.lang.String KEY_SUPPORT_SWAP_AFTER_MERGE_BOOL = "support_swap_after_merge_bool";

/**
 * Flag indicating whether some telephony logic will treat a call which was formerly a video
 * call as if it is still a video call.  When {@code true}:
 * <p>
 * Logic which will automatically drop a video call which takes place over WIFI when a
 * voice call is answered (see {@link #KEY_DROP_VIDEO_CALL_WHEN_ANSWERING_AUDIO_CALL_BOOL}.
 * <p>
 * Logic which determines whether the user can use TTY calling.
 * @apiSince 25
 */

public static final java.lang.String KEY_TREAT_DOWNGRADED_VIDEO_CALLS_AS_VIDEO_CALLS_BOOL = "treat_downgraded_video_calls_as_video_calls_bool";

/**
 * Boolean flag indicating whether the carrier supports TTY.
 * <p>
 * Note that {@link #KEY_CARRIER_VOLTE_TTY_SUPPORTED_BOOL} controls availability of TTY over
 * VoLTE; if {@link #KEY_TTY_SUPPORTED_BOOL} is disabled, then
 * {@link #KEY_CARRIER_VOLTE_TTY_SUPPORTED_BOOL} is also implicitly disabled.
 * <p>
 * {@link android.telecom.TelecomManager#isTtySupported() TelecomManager#isTtySupported()} should be used to determine if a device supports TTY,
 * and this carrier config key should be used to see if the current carrier supports it.
 * @apiSince 29
 */

public static final java.lang.String KEY_TTY_SUPPORTED_BOOL = "tty_supported_bool";

/**
 * CDMA activation goes through HFA
 * @apiSince 23
 */

public static final java.lang.String KEY_USE_HFA_FOR_PROVISIONING_BOOL = "use_hfa_for_provisioning_bool";

/**
 * CDMA activation goes through OTASP.
 * <p>
 * TODO: This should be combined with config_use_hfa_for_provisioning and implemented as an enum
 * (NONE, HFA, OTASP).
 * @apiSince 23
 */

public static final java.lang.String KEY_USE_OTASP_FOR_PROVISIONING_BOOL = "use_otasp_for_provisioning_bool";

/**
 * Flag indicating whether the carrier supports RCS presence indication for
 * User Capability Exchange (UCE).  When presence is supported, the device should use the
 * {@link android.provider.ContactsContract.Data#CARRIER_PRESENCE} bit mask and set the
 * {@link android.provider.ContactsContract.Data#CARRIER_PRESENCE_VT_CAPABLE} bit to indicate
 * whether each contact supports video calling.  The UI is made aware that presence is enabled
 * via {@link android.telecom.PhoneAccount#CAPABILITY_VIDEO_CALLING_RELIES_ON_PRESENCE}
 * and can choose to hide or show the video calling icon based on whether a contact supports
 * video.
 * @apiSince 24
 */

public static final java.lang.String KEY_USE_RCS_PRESENCE_BOOL = "use_rcs_presence_bool";

/**
 * Flag indicating whether the carrier supports RCS SIP OPTIONS indication for
 * User Capability Exchange (UCE).
 * @apiSince R
 */

public static final java.lang.String KEY_USE_RCS_SIP_OPTIONS_BOOL = "use_rcs_sip_options_bool";

/**
 * Determine whether the voicemail notification is persistent in the notification bar. If true,
 * the voicemail notifications cannot be dismissed from the notification bar.
 * @apiSince 23
 */

public static final java.lang.String KEY_VOICEMAIL_NOTIFICATION_PERSISTENT_BOOL = "voicemail_notification_persistent_bool";

/**
 * If true, removes the Voice Privacy option from Call Settings
 * @apiSince 23
 */

public static final java.lang.String KEY_VOICE_PRIVACY_DISABLE_UI_BOOL = "voice_privacy_disable_ui_bool";

/**
 * If Voice Radio Technology is RIL_RADIO_TECHNOLOGY_LTE:14 or RIL_RADIO_TECHNOLOGY_UNKNOWN:0
 * this is the value that should be used instead. A configuration value of
 * RIL_RADIO_TECHNOLOGY_UNKNOWN:0 means there is no replacement value and that the default
 * assumption for phone type (GSM) should be used.
 * @apiSince 23
 */

public static final java.lang.String KEY_VOLTE_REPLACEMENT_RAT_INT = "volte_replacement_rat_int";

/**
 * Whether cellular data is required to access visual voicemail.
 * @apiSince 24
 */

public static final java.lang.String KEY_VVM_CELLULAR_DATA_REQUIRED_BOOL = "vvm_cellular_data_required_bool";

/**
 * The default OMTP visual voicemail client prefix to use. Defaulted to "//VVM"
 * @apiSince 26
 */

public static final java.lang.String KEY_VVM_CLIENT_PREFIX_STRING = "vvm_client_prefix_string";

/**
 * The carrier number mobile outgoing (MO) sms messages are sent to.
 * @apiSince 23
 */

public static final java.lang.String KEY_VVM_DESTINATION_NUMBER_STRING = "vvm_destination_number_string";

/**
 * A set of capabilities that should not be used even if it is reported by the visual voicemail
 * IMAP CAPABILITY command.
 * @apiSince 26
 */

public static final java.lang.String KEY_VVM_DISABLED_CAPABILITIES_STRING_ARRAY = "vvm_disabled_capabilities_string_array";

/**
 * Whether legacy mode should be used when the visual voicemail client is disabled.
 *
 * <p>Legacy mode is a mode that on the carrier side visual voicemail is still activated, but on
 * the client side all network operations are disabled. SMSs are still monitored so a new
 * message SYNC SMS will be translated to show a message waiting indicator, like traditional
 * voicemails.
 *
 * <p>This is for carriers that does not support VVM deactivation so voicemail can continue to
 * function without the data cost.
 * @apiSince 26
 */

public static final java.lang.String KEY_VVM_LEGACY_MODE_ENABLED_BOOL = "vvm_legacy_mode_enabled_bool";

/**
 * The port through which the mobile outgoing (MO) sms messages are sent through.
 * @apiSince 23
 */

public static final java.lang.String KEY_VVM_PORT_NUMBER_INT = "vvm_port_number_int";

/**
 * Whether to prefetch audio data on new voicemail arrival, defaulted to true.
 * @apiSince 24
 */

public static final java.lang.String KEY_VVM_PREFETCH_BOOL = "vvm_prefetch_bool";

/**
 * Whether to use SSL to connect to the visual voicemail IMAP server. Defaulted to false.
 * @apiSince 26
 */

public static final java.lang.String KEY_VVM_SSL_ENABLED_BOOL = "vvm_ssl_enabled_bool";

/**
 * The type of visual voicemail protocol the carrier adheres to. See {@link android.telephony.TelephonyManager TelephonyManager}
 * for possible values. For example {@link android.telephony.TelephonyManager#VVM_TYPE_OMTP TelephonyManager#VVM_TYPE_OMTP}.
 * @apiSince 23
 */

public static final java.lang.String KEY_VVM_TYPE_STRING = "vvm_type_string";

/**
 * Flag indicating if the phone is a world phone
 * @apiSince 23
 */

public static final java.lang.String KEY_WORLD_PHONE_BOOL = "world_phone_bool";
/**
 * GPS configs. See the GNSS HAL documentation for more details.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Gps {

private Gps() { throw new RuntimeException("Stub!"); }

/**
 * Determine whether current lpp_mode used for E-911 needs to be kept persistently.
 * {@code false} - not keeping the lpp_mode means using default configuration of gps.conf
 *                 when sim is not presented.
 * {@code true}  - current lpp_profile of carrier will be kepted persistently
 *                 even after sim is removed. This is default.
 * @apiSince R
 */

public static final java.lang.String KEY_PERSIST_LPP_MODE_BOOL = "gps.persist_lpp_mode_bool";

/**
 * Prefix of all Gps.KEY_* constants.
 * @apiSince R
 */

public static final java.lang.String KEY_PREFIX = "gps.";
}

/**
 * Configs used by the IMS stack.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Ims {

private Ims() { throw new RuntimeException("Stub!"); }

/**
 * Prefix of all Ims.KEY_* constants.
 * @apiSince R
 */

public static final java.lang.String KEY_PREFIX = "ims.";
}

}

