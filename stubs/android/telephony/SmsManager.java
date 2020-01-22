/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.app.PendingIntent;
import java.util.ArrayList;
import android.net.Uri;
import android.content.Context;
import android.database.CursorWindow;
import java.util.concurrent.Executor;

/**
 * Manages SMS operations such as sending data, text, and pdu SMS messages.
 * Get this object by calling the static method {@link #getDefault()}. To create an instance of
 * {@link android.telephony.SmsManager SmsManager} associated with a specific subscription ID, call
 * {@link #getSmsManagerForSubscriptionId(int)}. This is typically used for devices that support
 * multiple active subscriptions at once.
 *
 * <p>For information about how to behave as the default SMS app on Android 4.4 (API level 19)
 * and higher, see {@link android.provider.Telephony}.
 *
 * @see android.telephony.SubscriptionManager#getActiveSubscriptionInfoList()
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SmsManager {

private SmsManager() { throw new RuntimeException("Stub!"); }

/**
 * Send a text based SMS.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app has the
 * {@link android.Manifest.permission#SEND_SMS} permission.</p>
 *
 * <p class="note"><strong>Note:</strong> Beginning with Android 4.4 (API level 19), if
 * <em>and only if</em> an app is not selected as the default SMS app, the system automatically
 * writes messages sent using this method to the SMS Provider (the default SMS app is always
 * responsible for writing its sent messages to the SMS Provider). For information about
 * how to behave as the default SMS app, see {@link android.provider.Telephony}.</p>
 *
 * <p class="note"><strong>Note:</strong> If {@link #getDefault()} is used to instantiate this
 * manager on a multi-SIM device, this operation may fail sending the SMS message because no
 * suitable default subscription could be found. In this case, if {@code sentIntent} is
 * non-null, then the {@link android.app.PendingIntent PendingIntent} will be sent with an error code
 * {@code RESULT_ERROR_GENERIC_FAILURE} and an extra string {@code "noDefault"} containing the
 * boolean value {@code true}. See {@link #getDefault()} for more information on the conditions
 * where this operation may fail.
 * </p>
 *
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *  the current default SMSC
 * @param text the body of the message to send
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully sent, or failed.
 *  The result code will be <code>Activity.RESULT_OK</code> for success,
 *  or one of these errors:<br>
 *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
 *  <code>RESULT_ERROR_RADIO_OFF</code><br>
 *  <code>RESULT_ERROR_NULL_PDU</code><br>
 *  <code>RESULT_ERROR_NO_SERVICE</code><br>
 *  <code>RESULT_ERROR_NO_SERVICE</code><br>
 *  <code>RESULT_ERROR_LIMIT_EXCEEDED</code><br>
 *  <code>RESULT_ERROR_FDN_CHECK_FAILURE</code><br>
 *  <code>RESULT_ERROR_SHORT_CODE_NOT_ALLOWED</code><br>
 *  <code>RESULT_ERROR_SHORT_CODE_NEVER_ALLOWED</code><br>
 *  <code>RESULT_RADIO_NOT_AVAILABLE</code><br>
 *  <code>RESULT_NETWORK_REJECT</code><br>
 *  <code>RESULT_INVALID_ARGUMENTS</code><br>
 *  <code>RESULT_INVALID_STATE</code><br>
 *  <code>RESULT_NO_MEMORY</code><br>
 *  <code>RESULT_INVALID_SMS_FORMAT</code><br>
 *  <code>RESULT_SYSTEM_ERROR</code><br>
 *  <code>RESULT_MODEM_ERROR</code><br>
 *  <code>RESULT_NETWORK_ERROR</code><br>
 *  <code>RESULT_ENCODING_ERROR</code><br>
 *  <code>RESULT_INVALID_SMSC_ADDRESS</code><br>
 *  <code>RESULT_OPERATION_NOT_ALLOWED</code><br>
 *  <code>RESULT_INTERNAL_ERROR</code><br>
 *  <code>RESULT_NO_RESOURCES</code><br>
 *  <code>RESULT_CANCELLED</code><br>
 *  <code>RESULT_REQUEST_NOT_SUPPORTED</code><br>
 *  <code>RESULT_NO_BLUETOOTH_SERVICE</code><br>
 *  <code>RESULT_INVALID_BLUETOOTH_ADDRESS</code><br>
 *  <code>RESULT_BLUETOOTH_DISCONNECTED</code><br>
 *  <code>RESULT_UNEXPECTED_EVENT_STOP_SENDING</code><br>
 *  <code>RESULT_SMS_BLOCKED_DURING_EMERGENCY</code><br>
 *  <code>RESULT_SMS_SEND_RETRY_FAILED</code><br>
 *  <code>RESULT_REMOTE_EXCEPTION</code><br>
 *  <code>RESULT_NO_DEFAULT_SMS_APP</code><br>
 *  <code>RESULT_RIL_RADIO_NOT_AVAILABLE</code><br>
 *  <code>RESULT_RIL_SMS_SEND_FAIL_RETRY</code><br>
 *  <code>RESULT_RIL_NETWORK_REJECT</code><br>
 *  <code>RESULT_RIL_INVALID_STATE</code><br>
 *  <code>RESULT_RIL_INVALID_ARGUMENTS</code><br>
 *  <code>RESULT_RIL_NO_MEMORY</code><br>
 *  <code>RESULT_RIL_REQUEST_RATE_LIMITED</code><br>
 *  <code>RESULT_RIL_INVALID_SMS_FORMAT</code><br>
 *  <code>RESULT_RIL_SYSTEM_ERR</code><br>
 *  <code>RESULT_RIL_ENCODING_ERR</code><br>
 *  <code>RESULT_RIL_INVALID_SMSC_ADDRESS</code><br>
 *  <code>RESULT_RIL_MODEM_ERR</code><br>
 *  <code>RESULT_RIL_NETWORK_ERR</code><br>
 *  <code>RESULT_RIL_INTERNAL_ERR</code><br>
 *  <code>RESULT_RIL_REQUEST_NOT_SUPPORTED</code><br>
 *  <code>RESULT_RIL_INVALID_MODEM_STATE</code><br>
 *  <code>RESULT_RIL_NETWORK_NOT_READY</code><br>
 *  <code>RESULT_RIL_OPERATION_NOT_ALLOWED</code><br>
 *  <code>RESULT_RIL_NO_RESOURCES</code><br>
 *  <code>RESULT_RIL_CANCELLED</code><br>
 *  <code>RESULT_RIL_SIM_ABSENT</code><br>
 *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> or any of the RESULT_RIL errors,
 *  the sentIntent may include the extra "errorCode" containing a radio technology specific
 *  value, generally only useful for troubleshooting.<br>
 *  The per-application based SMS control checks sentIntent. If sentIntent
 *  is NULL the caller will be checked against all unknown applications,
 *  which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is delivered to the recipient.  The
 *  raw pdu of the status report is in the extended data ("pdu").
 *
 * @throws java.lang.IllegalArgumentException if destinationAddress or text are empty
 * @apiSince 4
 */

public void sendTextMessage(java.lang.String destinationAddress, java.lang.String scAddress, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/**
 * Send a text based SMS without writing it into the SMS Provider.
 *
 * <p>
 * The message will be sent directly over the network and will not be visible in SMS
 * applications. Intended for internal carrier use only.
 * </p>
 *
 * <p>Requires Permission: Both {@link android.Manifest.permission#SEND_SMS} and
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE}, or that the calling app has carrier
 * privileges (see {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}), or that the calling app is
 * the default IMS app (see
 * {@link android.telephony.CarrierConfigManager#KEY_CONFIG_IMS_PACKAGE_OVERRIDE_STRING CarrierConfigManager#KEY_CONFIG_IMS_PACKAGE_OVERRIDE_STRING}).
 * </p>
 *
 * <p class="note"><strong>Note:</strong> This method is intended for internal use by carrier
 * applications or the Telephony framework and will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the SMS being sent on the subscription associated with logical
 * slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the SMS is sent on the
 * correct subscription.
 * </p>
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE} and {@link android.Manifest.permission#SEND_SMS}
 * @see #sendTextMessage(String, String, String, PendingIntent, PendingIntent)
 * @apiSince 28
 */

public void sendTextMessageWithoutPersisting(java.lang.String destinationAddress, java.lang.String scAddress, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/**
 *
 * Inject an SMS PDU into the android application framework.
 *
 * <p>Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE} or carrier
 * privileges per {@link android.telephony.TelephonyManager#hasCarrierPrivileges}.
 *
 * <p class="note"><strong>Note:</strong> This method is intended for internal use by carrier
 * applications or the Telephony framework and will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the SMS being injected on the subscription associated with
 * logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the SMS is
 * delivered to the correct subscription.
 * </p>
 *
 * @param pdu is the byte array of pdu to be injected into android application framework
 * @param format is the format of SMS pdu ({@link android.telephony.SmsMessage#FORMAT_3GPP SmsMessage#FORMAT_3GPP} or
 *  {@link android.telephony.SmsMessage#FORMAT_3GPP2 SmsMessage#FORMAT_3GPP2})
 * Value is {@link android.telephony.SmsMessage#FORMAT_3GPP}, or {@link android.telephony.SmsMessage#FORMAT_3GPP2}
 * @param receivedIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully received by the
 *  android application framework, or failed. This intent is broadcasted at
 *  the same time an SMS received from radio is acknowledged back.
 *  The result code will be {@link android.provider.Telephony.Sms.Intents#RESULT_SMS_HANDLED}
 *  for success, or {@link android.provider.Telephony.Sms.Intents#RESULT_SMS_GENERIC_ERROR} for
 *  error.
 *
 * @throws java.lang.IllegalArgumentException if the format is invalid.
 @apiSince 22
 */

public void injectSmsPdu(byte[] pdu, java.lang.String format, android.app.PendingIntent receivedIntent) { throw new RuntimeException("Stub!"); }

/**
 * Divide a message text into several fragments, none bigger than the maximum SMS message size.
 *
 * @param text the original message. Must not be null.
 * @return an <code>ArrayList</code> of strings that, in order, comprise the original message.
 * @throws java.lang.IllegalArgumentException if text is null.
 * @apiSince 4
 */

public java.util.ArrayList<java.lang.String> divideMessage(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Send a multi-part text based SMS.  The callee should have already
 * divided the message into correctly sized parts by calling
 * <code>divideMessage</code>.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app has the
 * {@link android.Manifest.permission#SEND_SMS} permission.</p>
 *
 * <p class="note"><strong>Note:</strong> Beginning with Android 4.4 (API level 19), if
 * <em>and only if</em> an app is not selected as the default SMS app, the system automatically
 * writes messages sent using this method to the SMS Provider (the default SMS app is always
 * responsible for writing its sent messages to the SMS Provider). For information about
 * how to behave as the default SMS app, see {@link android.provider.Telephony}.</p>
 *
 * <p class="note"><strong>Note:</strong> If {@link #getDefault()} is used to instantiate this
 * manager on a multi-SIM device, this operation may fail sending the SMS message because no
 * suitable default subscription could be found. In this case, if {@code sentIntent} is
 * non-null, then the {@link android.app.PendingIntent PendingIntent} will be sent with an error code
 * {@code RESULT_ERROR_GENERIC_FAILURE} and an extra string {@code "noDefault"} containing the
 * boolean value {@code true}. See {@link #getDefault()} for more information on the conditions
 * where this operation may fail.
 * </p>
 *
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *   the current default SMSC
 * @param parts an <code>ArrayList</code> of strings that, in order,
 *   comprise the original message
 * @param sentIntents if not null, an <code>ArrayList</code> of
 *   <code>PendingIntent</code>s (one for each message part) that is
 *   broadcast when the corresponding message part has been sent.
 *   The result code will be <code>Activity.RESULT_OK</code> for success,
 *   or one of these errors:<br>
 *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
 *  <code>RESULT_ERROR_RADIO_OFF</code><br>
 *  <code>RESULT_ERROR_NULL_PDU</code><br>
 *  <code>RESULT_ERROR_NO_SERVICE</code><br>
 *  <code>RESULT_ERROR_NO_SERVICE</code><br>
 *  <code>RESULT_ERROR_LIMIT_EXCEEDED</code><br>
 *  <code>RESULT_ERROR_FDN_CHECK_FAILURE</code><br>
 *  <code>RESULT_ERROR_SHORT_CODE_NOT_ALLOWED</code><br>
 *  <code>RESULT_ERROR_SHORT_CODE_NEVER_ALLOWED</code><br>
 *  <code>RESULT_RADIO_NOT_AVAILABLE</code><br>
 *  <code>RESULT_NETWORK_REJECT</code><br>
 *  <code>RESULT_INVALID_ARGUMENTS</code><br>
 *  <code>RESULT_INVALID_STATE</code><br>
 *  <code>RESULT_NO_MEMORY</code><br>
 *  <code>RESULT_INVALID_SMS_FORMAT</code><br>
 *  <code>RESULT_SYSTEM_ERROR</code><br>
 *  <code>RESULT_MODEM_ERROR</code><br>
 *  <code>RESULT_NETWORK_ERROR</code><br>
 *  <code>RESULT_ENCODING_ERROR</code><br>
 *  <code>RESULT_INVALID_SMSC_ADDRESS</code><br>
 *  <code>RESULT_OPERATION_NOT_ALLOWED</code><br>
 *  <code>RESULT_INTERNAL_ERROR</code><br>
 *  <code>RESULT_NO_RESOURCES</code><br>
 *  <code>RESULT_CANCELLED</code><br>
 *  <code>RESULT_REQUEST_NOT_SUPPORTED</code><br>
 *  <code>RESULT_NO_BLUETOOTH_SERVICE</code><br>
 *  <code>RESULT_INVALID_BLUETOOTH_ADDRESS</code><br>
 *  <code>RESULT_BLUETOOTH_DISCONNECTED</code><br>
 *  <code>RESULT_UNEXPECTED_EVENT_STOP_SENDING</code><br>
 *  <code>RESULT_SMS_BLOCKED_DURING_EMERGENCY</code><br>
 *  <code>RESULT_SMS_SEND_RETRY_FAILED</code><br>
 *  <code>RESULT_REMOTE_EXCEPTION</code><br>
 *  <code>RESULT_NO_DEFAULT_SMS_APP</code><br>
 *  <code>RESULT_RIL_RADIO_NOT_AVAILABLE</code><br>
 *  <code>RESULT_RIL_SMS_SEND_FAIL_RETRY</code><br>
 *  <code>RESULT_RIL_NETWORK_REJECT</code><br>
 *  <code>RESULT_RIL_INVALID_STATE</code><br>
 *  <code>RESULT_RIL_INVALID_ARGUMENTS</code><br>
 *  <code>RESULT_RIL_NO_MEMORY</code><br>
 *  <code>RESULT_RIL_REQUEST_RATE_LIMITED</code><br>
 *  <code>RESULT_RIL_INVALID_SMS_FORMAT</code><br>
 *  <code>RESULT_RIL_SYSTEM_ERR</code><br>
 *  <code>RESULT_RIL_ENCODING_ERR</code><br>
 *  <code>RESULT_RIL_INVALID_SMSC_ADDRESS</code><br>
 *  <code>RESULT_RIL_MODEM_ERR</code><br>
 *  <code>RESULT_RIL_NETWORK_ERR</code><br>
 *  <code>RESULT_RIL_INTERNAL_ERR</code><br>
 *  <code>RESULT_RIL_REQUEST_NOT_SUPPORTED</code><br>
 *  <code>RESULT_RIL_INVALID_MODEM_STATE</code><br>
 *  <code>RESULT_RIL_NETWORK_NOT_READY</code><br>
 *  <code>RESULT_RIL_OPERATION_NOT_ALLOWED</code><br>
 *  <code>RESULT_RIL_NO_RESOURCES</code><br>
 *  <code>RESULT_RIL_CANCELLED</code><br>
 *  <code>RESULT_RIL_SIM_ABSENT</code><br>
 *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> or any of the RESULT_RIL errors,
 *  the sentIntent may include the extra "errorCode" containing a radio technology specific
 *  value, generally only useful for troubleshooting.<br>
 *   The per-application based SMS control checks sentIntent. If sentIntent
 *   is NULL the caller will be checked against all unknown applications,
 *   which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntents if not null, an <code>ArrayList</code> of
 *   <code>PendingIntent</code>s (one for each message part) that is
 *   broadcast when the corresponding message part has been delivered
 *   to the recipient.  The raw pdu of the status report is in the
 *   extended data ("pdu").
 *
 * @throws java.lang.IllegalArgumentException if destinationAddress or data are empty
 * @apiSince 4
 */

public void sendMultipartTextMessage(java.lang.String destinationAddress, java.lang.String scAddress, java.util.ArrayList<java.lang.String> parts, java.util.ArrayList<android.app.PendingIntent> sentIntents, java.util.ArrayList<android.app.PendingIntent> deliveryIntents) { throw new RuntimeException("Stub!"); }

/**
 * Send a data based SMS to a specific application port.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app has the
 * {@link android.Manifest.permission#SEND_SMS} permission.</p>
 *
 * <p class="note"><strong>Note:</strong> If {@link #getDefault()} is used to instantiate this
 * manager on a multi-SIM device, this operation may fail sending the SMS message because no
 * suitable default subscription could be found. In this case, if {@code sentIntent} is
 * non-null, then the {@link android.app.PendingIntent PendingIntent} will be sent with an error code
 * {@code RESULT_ERROR_GENERIC_FAILURE} and an extra string {@code "noDefault"} containing the
 * boolean value {@code true}. See {@link #getDefault()} for more information on the conditions
 * where this operation may fail.
 * </p>
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *  the current default SMSC
 * @param destinationPort the port to deliver the message to
 * @param data the body of the message to send
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully sent, or failed.
 *  The result code will be <code>Activity.RESULT_OK</code> for success,
 *  or one of these errors:<br>
 *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
 *  <code>RESULT_ERROR_RADIO_OFF</code><br>
 *  <code>RESULT_ERROR_NULL_PDU</code><br>
 *  <code>RESULT_ERROR_NO_SERVICE</code><br>
 *  <code>RESULT_ERROR_NO_SERVICE</code><br>
 *  <code>RESULT_ERROR_LIMIT_EXCEEDED</code><br>
 *  <code>RESULT_ERROR_FDN_CHECK_FAILURE</code><br>
 *  <code>RESULT_ERROR_SHORT_CODE_NOT_ALLOWED</code><br>
 *  <code>RESULT_ERROR_SHORT_CODE_NEVER_ALLOWED</code><br>
 *  <code>RESULT_RADIO_NOT_AVAILABLE</code><br>
 *  <code>RESULT_NETWORK_REJECT</code><br>
 *  <code>RESULT_INVALID_ARGUMENTS</code><br>
 *  <code>RESULT_INVALID_STATE</code><br>
 *  <code>RESULT_NO_MEMORY</code><br>
 *  <code>RESULT_INVALID_SMS_FORMAT</code><br>
 *  <code>RESULT_SYSTEM_ERROR</code><br>
 *  <code>RESULT_MODEM_ERROR</code><br>
 *  <code>RESULT_NETWORK_ERROR</code><br>
 *  <code>RESULT_ENCODING_ERROR</code><br>
 *  <code>RESULT_INVALID_SMSC_ADDRESS</code><br>
 *  <code>RESULT_OPERATION_NOT_ALLOWED</code><br>
 *  <code>RESULT_INTERNAL_ERROR</code><br>
 *  <code>RESULT_NO_RESOURCES</code><br>
 *  <code>RESULT_CANCELLED</code><br>
 *  <code>RESULT_REQUEST_NOT_SUPPORTED</code><br>
 *  <code>RESULT_NO_BLUETOOTH_SERVICE</code><br>
 *  <code>RESULT_INVALID_BLUETOOTH_ADDRESS</code><br>
 *  <code>RESULT_BLUETOOTH_DISCONNECTED</code><br>
 *  <code>RESULT_UNEXPECTED_EVENT_STOP_SENDING</code><br>
 *  <code>RESULT_SMS_BLOCKED_DURING_EMERGENCY</code><br>
 *  <code>RESULT_SMS_SEND_RETRY_FAILED</code><br>
 *  <code>RESULT_REMOTE_EXCEPTION</code><br>
 *  <code>RESULT_NO_DEFAULT_SMS_APP</code><br>
 *  <code>RESULT_RIL_RADIO_NOT_AVAILABLE</code><br>
 *  <code>RESULT_RIL_SMS_SEND_FAIL_RETRY</code><br>
 *  <code>RESULT_RIL_NETWORK_REJECT</code><br>
 *  <code>RESULT_RIL_INVALID_STATE</code><br>
 *  <code>RESULT_RIL_INVALID_ARGUMENTS</code><br>
 *  <code>RESULT_RIL_NO_MEMORY</code><br>
 *  <code>RESULT_RIL_REQUEST_RATE_LIMITED</code><br>
 *  <code>RESULT_RIL_INVALID_SMS_FORMAT</code><br>
 *  <code>RESULT_RIL_SYSTEM_ERR</code><br>
 *  <code>RESULT_RIL_ENCODING_ERR</code><br>
 *  <code>RESULT_RIL_INVALID_SMSC_ADDRESS</code><br>
 *  <code>RESULT_RIL_MODEM_ERR</code><br>
 *  <code>RESULT_RIL_NETWORK_ERR</code><br>
 *  <code>RESULT_RIL_INTERNAL_ERR</code><br>
 *  <code>RESULT_RIL_REQUEST_NOT_SUPPORTED</code><br>
 *  <code>RESULT_RIL_INVALID_MODEM_STATE</code><br>
 *  <code>RESULT_RIL_NETWORK_NOT_READY</code><br>
 *  <code>RESULT_RIL_OPERATION_NOT_ALLOWED</code><br>
 *  <code>RESULT_RIL_NO_RESOURCES</code><br>
 *  <code>RESULT_RIL_CANCELLED</code><br>
 *  <code>RESULT_RIL_SIM_ABSENT</code><br>
 *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> or any of the RESULT_RIL errors,
 *  the sentIntent may include the extra "errorCode" containing a radio technology specific
 *  value, generally only useful for troubleshooting.<br>
 *  The per-application based SMS control checks sentIntent. If sentIntent
 *  is NULL the caller will be checked against all unknown applications,
 *  which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is delivered to the recipient.  The
 *  raw pdu of the status report is in the extended data ("pdu").
 *
 * @throws java.lang.IllegalArgumentException if destinationAddress or data are empty
 * @apiSince 4
 */

public void sendDataMessage(java.lang.String destinationAddress, java.lang.String scAddress, short destinationPort, byte[] data, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/**
 * Get the SmsManager associated with the default subscription id. The instance will always be
 * associated with the default subscription id, even if the default subscription id changes.
 *
 * <p class="note"><strong>Note:</strong> For devices that support multiple active subscriptions
 * at a time, SmsManager will track the subscription set by the user as the default SMS
 * subscription. If the user has not set a default, {@link android.telephony.SmsManager SmsManager} may
 * start an activity to kick off a subscription disambiguation dialog. Most operations will not
 * complete until the user has chosen the subscription that will be associated with the
 * operation. If the user cancels the dialog without choosing a subscription, one of the
 * following will happen, depending on the target SDK version of the application. For
 * compatibility purposes, if the target SDK level is <= 28, telephony will still send the SMS
 * over the first available subscription. If the target SDK level is > 28, the operation will
 * fail to complete.
 * </p>
 *
 * <p class="note"><strong>Note:</strong> If this method is used to perform an operation on a
 * device that has multiple active subscriptions, the user has not set a default SMS
 * subscription, and the operation is being performed while the application is not in the
 * foreground, the SMS disambiguation dialog will not be shown. The result of the operation will
 * conclude as if the user cancelled the disambiguation dialog and the operation will finish as
 * outlined above, depending on the target SDK version of the calling application. It is safer
 * to use {@link #getSmsManagerForSubscriptionId(int)} if the application will perform the
 * operation while in the background because this can cause unpredictable results, such as the
 * operation being sent over the wrong subscription or failing completely, depending on the
 * user's default SMS subscription setting.
 * </p>
 *
 * @return the {@link android.telephony.SmsManager SmsManager} associated with the default subscription id.
 *
 * @see android.telephony.SubscriptionManager#getDefaultSmsSubscriptionId()
 * @apiSince 4
 */

public static android.telephony.SmsManager getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Get the instance of the SmsManager associated with a particular subscription ID.
 *
 * <p class="note"><strong>Note:</strong> Constructing an {@link android.telephony.SmsManager SmsManager} in this manner will
 * never cause an SMS disambiguation dialog to appear, unlike {@link #getDefault()}.
 * </p>
 *
 * @param subId an SMS subscription ID, typically accessed using {@link android.telephony.SubscriptionManager SubscriptionManager}
 * @return the instance of the SmsManager associated with subscription
 *
 * @see android.telephony.SubscriptionManager#getActiveSubscriptionInfoList()
 * @see android.telephony.SubscriptionManager#getDefaultSmsSubscriptionId()
 * @apiSince 22
 */

public static android.telephony.SmsManager getSmsManagerForSubscriptionId(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Get the associated subscription id. If the instance was returned by {@link #getDefault()},
 * then this method may return different values at different points in time (if the user
 * changes the default subscription id).
 *
 * <p class="note"><strong>Note:</strong> This method used to display a disambiguation dialog to
 * the user asking them to choose a default subscription to send SMS messages over if they
 * haven't chosen yet. Starting in API level 29, we allow the user to not have a default set as
 * a valid option for the default SMS subscription on multi-SIM devices. We no longer show the
 * disambiguation dialog and return {@link android.telephony.SubscriptionManager#INVALID_SUBSCRIPTION_ID SubscriptionManager#INVALID_SUBSCRIPTION_ID} if the
 * device has multiple active subscriptions and no default is set.
 * </p>
 *
 * @return associated subscription ID or {@link android.telephony.SubscriptionManager#INVALID_SUBSCRIPTION_ID SubscriptionManager#INVALID_SUBSCRIPTION_ID} if
 * the default subscription id cannot be determined or the device has multiple active
 * subscriptions and and no default is set ("ask every time") by the user.
 * @apiSince 22
 */

public int getSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Get default sms subscription id.
 *
 * <p class="note"><strong>Note:</strong>This returns a value different from
 * {@link android.telephony.SubscriptionManager#getDefaultSmsSubscriptionId SubscriptionManager#getDefaultSmsSubscriptionId} if the user has not chosen a default.
 * In this case it returns the active subscription id if there's only one active subscription
 * available.
 *
 * @return the user-defined default SMS subscription id, or the active subscription id if
 * there's only one active subscription available, otherwise
 * {@link android.telephony.SubscriptionManager#INVALID_SUBSCRIPTION_ID SubscriptionManager#INVALID_SUBSCRIPTION_ID}.
 * @apiSince 22
 */

public static int getDefaultSmsSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Send an MMS message
 *
 * <p class="note"><strong>Note:</strong> This method will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the
 * operation is performed on the correct subscription.
 * </p>
 *
 * @param context application context
 * @param contentUri the content Uri from which the message pdu will be read
 * @param locationUrl the optional location url where message should be sent to
 * @param configOverrides the carrier-specific messaging configuration values to override for
 *  sending the message.
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully sent, or failed
 * @throws java.lang.IllegalArgumentException if contentUri is empty
 * @apiSince 21
 */

public void sendMultimediaMessage(android.content.Context context, android.net.Uri contentUri, java.lang.String locationUrl, android.os.Bundle configOverrides, android.app.PendingIntent sentIntent) { throw new RuntimeException("Stub!"); }

/**
 * Download an MMS message from carrier by a given location URL
 *
 * <p class="note"><strong>Note:</strong> This method will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the
 * operation is performed on the correct subscription.
 * </p>
 *
 * @param context application context
 * @param locationUrl the location URL of the MMS message to be downloaded, usually obtained
 *  from the MMS WAP push notification
 * @param contentUri the content uri to which the downloaded pdu will be written
 * @param configOverrides the carrier-specific messaging configuration values to override for
 *  downloading the message.
 * @param downloadedIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is downloaded, or the download is failed
 * @throws java.lang.IllegalArgumentException if locationUrl or contentUri is empty
 * @apiSince 21
 */

public void downloadMultimediaMessage(android.content.Context context, java.lang.String locationUrl, android.net.Uri contentUri, android.os.Bundle configOverrides, android.app.PendingIntent downloadedIntent) { throw new RuntimeException("Stub!"); }

/**
 * Get carrier-dependent configuration values.
 *
 * <p class="note"><strong>Note:</strong> This method is intended for internal use by carrier
 * applications or the Telephony framework and will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the
 * operation is performed on the correct subscription.
 * </p>
 *
 * @return bundle key/values pairs of configuration values
 * @apiSince 21
 */

public android.os.Bundle getCarrierConfigValues() { throw new RuntimeException("Stub!"); }

/**
 * Create a single use app specific incoming SMS request for the calling package.
 *
 * This method returns a token that if included in a subsequent incoming SMS message will cause
 * {@code intent} to be sent with the SMS data.
 *
 * The token is only good for one use, after an SMS has been received containing the token all
 * subsequent SMS messages with the token will be routed as normal.
 *
 * An app can only have one request at a time, if the app already has a request pending it will
 * be replaced with a new request.
 *
 * <p class="note"><strong>Note:</strong> This method will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the
 * operation is performed on the correct subscription.
 * </p>
 *
 * @return Token to include in an SMS message. The token will be 11 characters long.
 * @see android.provider.Telephony.Sms.Intents#getMessagesFromIntent
 * @apiSince 26
 */

public java.lang.String createAppSpecificSmsToken(android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Get SMS messages for the calling financial app.
 * The result will be delivered asynchronously in the passing in callback interface.
 *
 * <p class="note"><strong>Note:</strong> This method will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the
 * operation is performed on the correct subscription.
 * </p>
 *
 * <br>
 * Requires {@link android.Manifest.permission#SMS_FINANCIAL_TRANSACTIONS}
 * @param params the parameters to filter SMS messages returned.
 * @param executor the executor on which callback will be invoked.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback a callback to receive CursorWindow with SMS messages.
 *
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void getSmsMessagesForFinancialApp(android.os.Bundle params, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.SmsManager.FinancialSmsCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Create a single use app specific incoming SMS request for the calling package.
 *
 * This method returns a token that if included in a subsequent incoming SMS message, and the
 * SMS message has a prefix from the given prefixes list, the provided {@code intent} will be
 * sent with the SMS data to the calling package.
 *
 * The token is only good for one use within a reasonable amount of time. After an SMS has been
 * received containing the token all subsequent SMS messages with the token will be routed as
 * normal.
 *
 * An app can only have one request at a time, if the app already has a request pending it will
 * be replaced with a new request.
 *
 * <p class="note"><strong>Note:</strong> This method will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this message will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the
 * operation is performed on the correct subscription.
 * </p>
 *
 * @param prefixes this is a list of prefixes string separated by REGEX_PREFIX_DELIMITER. The
 *  matching SMS message should have at least one of the prefixes in the beginning of the
 *  message.
 * This value may be {@code null}.
 * @param intent this intent is sent when the matching SMS message is received.
 * This value must never be {@code null}.
 * @return Token to include in an SMS message.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String createAppSpecificSmsTokenWithPackageInfo(@androidx.annotation.Nullable java.lang.String prefixes, @androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Gets the SMSC address from (U)SIM.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app is the
 * default SMS application, or READ_PRIVILEGED_PHONE_STATE permission, or has the carrier
 * privileges.</p>
 *
 * <p class="note"><strong>Note:</strong> This method will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this method will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the operation
 * is performed on the correct subscription.
 * </p>
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @return the SMSC address string, null if failed.
 * @apiSince R
 */

@androidx.annotation.Nullable
public java.lang.String getSmscAddress() { throw new RuntimeException("Stub!"); }

/**
 * Sets the SMSC address on (U)SIM.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app is the
 * default SMS application, or has {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * permission, or has the carrier privileges.</p>
 *
 * <p class="note"><strong>Note:</strong> This method will never trigger an SMS disambiguation
 * dialog. If this method is called on a device that has multiple active subscriptions, this
 * {@link android.telephony.SmsManager SmsManager} instance has been created with {@link #getDefault()}, and no user-defined
 * default subscription is defined, the subscription ID associated with this method will be
 * INVALID, which will result in the operation being completed on the subscription associated
 * with logical slot 0. Use {@link #getSmsManagerForSubscriptionId(int)} to ensure the operation
 * is performed on the correct subscription.
 * </p>
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param smsc the SMSC address string.
 * This value must never be {@code null}.
 * @return true for success, false otherwise.
 * @apiSince R
 */

public boolean setSmscAddress(@androidx.annotation.NonNull java.lang.String smsc) { throw new RuntimeException("Stub!"); }

/**
 * Intent extra name for MMS sending result data in byte array type
 * @apiSince 21
 */

public static final java.lang.String EXTRA_MMS_DATA = "android.telephony.extra.MMS_DATA";

/**
 * Intent extra name for HTTP status code for MMS HTTP failure in integer type
 * @apiSince 22
 */

public static final java.lang.String EXTRA_MMS_HTTP_STATUS = "android.telephony.extra.MMS_HTTP_STATUS";

/**
 * Whether alias is enabled (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_ALIAS_ENABLED = "aliasEnabled";

/**
 * Max alias character count (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_ALIAS_MAX_CHARS = "aliasMaxChars";

/**
 * Min alias character count (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_ALIAS_MIN_CHARS = "aliasMinChars";

/**
 * Whether audio is allowed to be attached for MMS messages (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_ALLOW_ATTACH_AUDIO = "allowAttachAudio";

/**
 * Whether to append transaction id to MMS WAP Push M-Notification.ind's content location URI
 * when constructing the download URL of a new MMS (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_APPEND_TRANSACTION_ID = "enabledTransID";

/**
 * Email gateway number (String type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_EMAIL_GATEWAY_NUMBER = "emailGatewayNumber";

/**
 * Whether group MMS is enabled for the current carrier (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_GROUP_MMS_ENABLED = "enableGroupMms";

/**
 * A list of HTTP headers to add to MMS HTTP request, separated by "|" (String type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_HTTP_PARAMS = "httpParams";

/**
 * MMS HTTP socket timeout in milliseconds (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_HTTP_SOCKET_TIMEOUT = "httpSocketTimeout";

/**
 * Max MMS image height (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MAX_IMAGE_HEIGHT = "maxImageHeight";

/**
 * Max MMS image width (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MAX_IMAGE_WIDTH = "maxImageWidth";

/**
 * Max MMS message size in bytes (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MAX_MESSAGE_SIZE = "maxMessageSize";

/**
 * Max message text size (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MESSAGE_TEXT_MAX_SIZE = "maxMessageTextSize";

/**
 * Whether MMS delivery report is enabled (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MMS_DELIVERY_REPORT_ENABLED = "enableMMSDeliveryReports";

/**
 * Whether MMS is enabled for the current carrier (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MMS_ENABLED = "enabledMMS";

/**
 * Whether MMS read report is enabled (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MMS_READ_REPORT_ENABLED = "enableMMSReadReports";

/**
 * Whether multipart SMS is enabled (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_MULTIPART_SMS_ENABLED = "enableMultipartSMS";

/**
 * The suffix to append to the NAI header value for MMS HTTP request (String type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_NAI_SUFFIX = "naiSuffix";

/**
 * If this is enabled, M-NotifyResp.ind should be sent to the WAP Push content location instead
 * of the default MMSC (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_NOTIFY_WAP_MMSC_ENABLED = "enabledNotifyWapMMSC";

/**
 * Limit of recipients of MMS messages (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_RECIPIENT_LIMIT = "recipientLimit";

/**
 * Whether multipart SMS should be sent as separate messages
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_SEND_MULTIPART_SMS_AS_SEPARATE_MESSAGES = "sendMultipartSmsAsSeparateMessages";

/**
 * If true, show the cell broadcast (amber alert) in the SMS settings. Some carriers don't want
 * this shown. (Boolean type)
 * @apiSince 22
 */

public static final java.lang.String MMS_CONFIG_SHOW_CELL_BROADCAST_APP_LINKS = "config_cellBroadcastAppLinks";

/**
 * Whether SMS delivery report is enabled (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_SMS_DELIVERY_REPORT_ENABLED = "enableSMSDeliveryReports";

/**
 * Some carriers require SMS to be converted into MMS when text length reaches this threshold
 * (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_SMS_TO_MMS_TEXT_LENGTH_THRESHOLD = "smsToMmsTextLengthThreshold";

/**
 * When the number of parts of a multipart SMS reaches this threshold, it should be converted
 * into an MMS (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_SMS_TO_MMS_TEXT_THRESHOLD = "smsToMmsTextThreshold";

/**
 * Max message subject length (int type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_SUBJECT_MAX_LENGTH = "maxSubjectLength";

/**
 * Whether the carrier MMSC supports charset field in Content-Type header. If this is false,
 * then we don't add "charset" to "Content-Type"
 * @apiSince 23
 */

public static final java.lang.String MMS_CONFIG_SUPPORT_HTTP_CHARSET_HEADER = "supportHttpCharsetHeader";

/**
 * Whether content-disposition field should be expected in an MMS PDU (boolean type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_SUPPORT_MMS_CONTENT_DISPOSITION = "supportMmsContentDisposition";

/**
 * The name of the UA Prof URL HTTP header for MMS HTTP request (String type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_UA_PROF_TAG_NAME = "uaProfTagName";

/**
 * The UA Profile URL header value for MMS HTTP request (String type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_UA_PROF_URL = "uaProfUrl";

/**
 * The User-Agent header value for MMS HTTP request (String type)
 * @apiSince 21
 */

public static final java.lang.String MMS_CONFIG_USER_AGENT = "userAgent";

/** @apiSince 21 */

public static final int MMS_ERROR_CONFIGURATION_ERROR = 7; // 0x7

/** @apiSince 21 */

public static final int MMS_ERROR_HTTP_FAILURE = 4; // 0x4

/** @apiSince 21 */

public static final int MMS_ERROR_INVALID_APN = 2; // 0x2

/** @apiSince 21 */

public static final int MMS_ERROR_IO_ERROR = 5; // 0x5

/** @apiSince 22 */

public static final int MMS_ERROR_NO_DATA_NETWORK = 8; // 0x8

/** @apiSince 21 */

public static final int MMS_ERROR_RETRY = 6; // 0x6

/** @apiSince 21 */

public static final int MMS_ERROR_UNABLE_CONNECT_MMS = 3; // 0x3

/** @apiSince 21 */

public static final int MMS_ERROR_UNSPECIFIED = 1; // 0x1

/**
 * Failed sending via bluetooth because bluetooth disconnected
 * @apiSince R
 */

public static final int RESULT_BLUETOOTH_DISCONNECTED = 27; // 0x1b

/**
 * Failed because the operation was cancelled
 * @apiSince R
 */

public static final int RESULT_CANCELLED = 23; // 0x17

/**
 * Failed because of an encoding error
 * @apiSince R
 */

public static final int RESULT_ENCODING_ERROR = 18; // 0x12

/**
 * Failed because FDN is enabled.
 * @apiSince R
 */

public static final int RESULT_ERROR_FDN_CHECK_FAILURE = 6; // 0x6

/**
 * Generic failure cause
 * @apiSince 4
 */

public static final int RESULT_ERROR_GENERIC_FAILURE = 1; // 0x1

/**
 * Failed because we reached the sending queue limit.
 * @apiSince 27
 */

public static final int RESULT_ERROR_LIMIT_EXCEEDED = 5; // 0x5

/**
 * No error.
 * @apiSince R
 */

public static final int RESULT_ERROR_NONE = 0; // 0x0

/**
 * Failed because service is currently unavailable
 * @apiSince 4
 */

public static final int RESULT_ERROR_NO_SERVICE = 4; // 0x4

/**
 * Failed because no pdu provided
 * @apiSince 4
 */

public static final int RESULT_ERROR_NULL_PDU = 3; // 0x3

/**
 * Failed because radio was explicitly turned off
 * @apiSince 4
 */

public static final int RESULT_ERROR_RADIO_OFF = 2; // 0x2

/**
 * Failed because the user has denied this app ever send premium short codes.
 * @apiSince 27
 */

public static final int RESULT_ERROR_SHORT_CODE_NEVER_ALLOWED = 8; // 0x8

/**
 * Failed because user denied the sending of this short code.
 * @apiSince 27
 */

public static final int RESULT_ERROR_SHORT_CODE_NOT_ALLOWED = 7; // 0x7

/**
 * Failed because of an internal error
 * @apiSince R
 */

public static final int RESULT_INTERNAL_ERROR = 21; // 0x15

/**
 * Failed because of invalid arguments
 * @apiSince R
 */

public static final int RESULT_INVALID_ARGUMENTS = 11; // 0xb

/**
 * Failed sending via bluetooth because the bluetooth device address is invalid
 * @apiSince R
 */

public static final int RESULT_INVALID_BLUETOOTH_ADDRESS = 26; // 0x1a

/**
 * Failed because of an invalid smsc address
 * @apiSince R
 */

public static final int RESULT_INVALID_SMSC_ADDRESS = 19; // 0x13

/**
 * Failed because the sms format is not valid
 * @apiSince R
 */

public static final int RESULT_INVALID_SMS_FORMAT = 14; // 0xe

/**
 * Failed because of an invalid state
 * @apiSince R
 */

public static final int RESULT_INVALID_STATE = 12; // 0xc

/**
 * Failed because of a modem error
 * @apiSince R
 */

public static final int RESULT_MODEM_ERROR = 16; // 0x10

/**
 * Failed because of a network error
 * @apiSince R
 */

public static final int RESULT_NETWORK_ERROR = 17; // 0x11

/**
 * Failed because of network rejection
 * @apiSince R
 */

public static final int RESULT_NETWORK_REJECT = 10; // 0xa

/**
 * Failed sending via bluetooth because the bluetooth service is not available
 * @apiSince R
 */

public static final int RESULT_NO_BLUETOOTH_SERVICE = 25; // 0x19

/**
 * Set by BroadcastReceiver to indicate there's no default sms app.
 * @apiSince R
 */

public static final int RESULT_NO_DEFAULT_SMS_APP = 32; // 0x20

/**
 * Failed because there is no memory
 * @apiSince R
 */

public static final int RESULT_NO_MEMORY = 13; // 0xd

/**
 * Failed because there are no resources
 * @apiSince R
 */

public static final int RESULT_NO_RESOURCES = 22; // 0x16

/**
 * Failed because the operation is not allowed
 * @apiSince R
 */

public static final int RESULT_OPERATION_NOT_ALLOWED = 20; // 0x14

/**
 * Failed because the radio was not available
 * @apiSince R
 */

public static final int RESULT_RADIO_NOT_AVAILABLE = 9; // 0x9

/**
 * Set by BroadcastReceiver to indicate a remote exception while handling a message.
 * @apiSince R
 */

public static final int RESULT_REMOTE_EXCEPTION = 31; // 0x1f

/**
 * Failed because the request is not supported
 * @apiSince R
 */

public static final int RESULT_REQUEST_NOT_SUPPORTED = 24; // 0x18

/**
 * The request has been cancelled.
 * @apiSince R
 */

public static final int RESULT_RIL_CANCELLED = 119; // 0x77

/**
 * The SMS message was not encoded properly.
 * @apiSince R
 */

public static final int RESULT_RIL_ENCODING_ERR = 109; // 0x6d

/**
 * The modem encountered an unexpected error scenario while handling the request.
 * @apiSince R
 */

public static final int RESULT_RIL_INTERNAL_ERR = 113; // 0x71

/**
 * The radio received invalid arguments in the request.
 * @apiSince R
 */

public static final int RESULT_RIL_INVALID_ARGUMENTS = 104; // 0x68

/**
 * The radio cannot process the request in the current modem state.
 * @apiSince R
 */

public static final int RESULT_RIL_INVALID_MODEM_STATE = 115; // 0x73

/**
 * The specified SMSC address was invalid.
 * @apiSince R
 */

public static final int RESULT_RIL_INVALID_SMSC_ADDRESS = 110; // 0x6e

/**
 * The radio returned an error indicating invalid sms format.
 * @apiSince R
 */

public static final int RESULT_RIL_INVALID_SMS_FORMAT = 107; // 0x6b

/**
 * The radio returned an unexpected request for the current state.
 * @apiSince R
 */

public static final int RESULT_RIL_INVALID_STATE = 103; // 0x67

/**
 * The vendor RIL received an unexpected or incorrect response.
 * @apiSince R
 */

public static final int RESULT_RIL_MODEM_ERR = 111; // 0x6f

/**
 * The radio received an error from the network.
 * @apiSince R
 */

public static final int RESULT_RIL_NETWORK_ERR = 112; // 0x70

/**
 * The network is not ready to perform the request.
 * @apiSince R
 */

public static final int RESULT_RIL_NETWORK_NOT_READY = 116; // 0x74

/**
 * The sms request was rejected by the network.
 * @apiSince R
 */

public static final int RESULT_RIL_NETWORK_REJECT = 102; // 0x66

/**
 * The radio didn't have sufficient memory to process the request.
 * @apiSince R
 */

public static final int RESULT_RIL_NO_MEMORY = 105; // 0x69

/**
 * There are not sufficient resources to process the request.
 * @apiSince R
 */

public static final int RESULT_RIL_NO_RESOURCES = 118; // 0x76

/**
 * The radio reports the request is not allowed.
 * @apiSince R
 */

public static final int RESULT_RIL_OPERATION_NOT_ALLOWED = 117; // 0x75

/**
 * The radio did not start or is resetting.
 * @apiSince R
 */

public static final int RESULT_RIL_RADIO_NOT_AVAILABLE = 100; // 0x64

/**
 * The request was not supported by the radio.
 * @apiSince R
 */

public static final int RESULT_RIL_REQUEST_NOT_SUPPORTED = 114; // 0x72

/**
 * The radio denied the operation due to overly-frequent requests.
 * @apiSince R
 */

public static final int RESULT_RIL_REQUEST_RATE_LIMITED = 106; // 0x6a

/**
 * The radio failed to set the location where the CDMA subscription
 * can be retrieved because the SIM or RUIM is absent.
 * @apiSince R
 */

public static final int RESULT_RIL_SIM_ABSENT = 120; // 0x78

/**
 * The radio failed to send the sms and needs to retry.
 * @apiSince R
 */

public static final int RESULT_RIL_SMS_SEND_FAIL_RETRY = 101; // 0x65

/**
 * The radio encountered a platform or system error.
 * @apiSince R
 */

public static final int RESULT_RIL_SYSTEM_ERR = 108; // 0x6c

/**
 * Failed sending during an emergency call
 * @apiSince R
 */

public static final int RESULT_SMS_BLOCKED_DURING_EMERGENCY = 29; // 0x1d

/**
 * Failed to send an sms retry
 * @apiSince R
 */

public static final int RESULT_SMS_SEND_RETRY_FAILED = 30; // 0x1e

/**
 * Failed because of a system error
 * @apiSince R
 */

public static final int RESULT_SYSTEM_ERROR = 15; // 0xf

/**
 * Failed sending because the user denied or canceled the dialog displayed for a premium
 * shortcode sms or rate-limited sms.
 * @apiSince R
 */

public static final int RESULT_UNEXPECTED_EVENT_STOP_SENDING = 28; // 0x1c

/**
 * Free space (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27).
 * @apiSince 4
 */

public static final int STATUS_ON_ICC_FREE = 0; // 0x0

/**
 * Received and read (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27).
 * @apiSince 4
 */

public static final int STATUS_ON_ICC_READ = 1; // 0x1

/**
 * Stored and sent (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27).
 * @apiSince 4
 */

public static final int STATUS_ON_ICC_SENT = 5; // 0x5

/**
 * Received and unread (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27).
 * @apiSince 4
 */

public static final int STATUS_ON_ICC_UNREAD = 3; // 0x3

/**
 * Stored and unsent (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27).
 * @apiSince 4
 */

public static final int STATUS_ON_ICC_UNSENT = 7; // 0x7
/**
 * callback for providing asynchronous sms messages for financial app.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class FinancialSmsCallback {

public FinancialSmsCallback() { throw new RuntimeException("Stub!"); }

/**
 * Callback to send sms messages back to financial app asynchronously.
 *
 * @param msgs SMS messages.
 * @apiSince 29
 */

public abstract void onFinancialSmsMessages(android.database.CursorWindow msgs);
}

}

