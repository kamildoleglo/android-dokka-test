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


package android.telephony.gsm;

import android.app.PendingIntent;
import java.util.ArrayList;

/**
 * Manages SMS operations such as sending data, text, and pdu SMS messages.
 * Get this object by calling the static method SmsManager.getDefault().
 * @deprecated Replaced by android.telephony.SmsManager that supports both GSM and CDMA.
 * @apiSince 1
 * @deprecatedSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class SmsManager {

private SmsManager() { throw new RuntimeException("Stub!"); }

/** Get the default instance of the SmsManager
 *
 * @return the default instance of the SmsManager
 * @deprecated Use android.telephony.SmsManager.
 @apiSince 1
 @deprecatedSince 4
 */

@Deprecated
public static android.telephony.gsm.SmsManager getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Send a text based SMS.
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *  the current default SMSC
 * @param text the body of the message to send
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully sent, or failed.
 *  The result code will be <code>Activity.RESULT_OK<code> for success,
 *  or one of these errors:
 *  <code>RESULT_ERROR_GENERIC_FAILURE</code>
 *  <code>RESULT_ERROR_RADIO_OFF</code>
 *  <code>RESULT_ERROR_NULL_PDU</code>.
 *  The per-application based SMS control checks sentIntent. If sentIntent
 *  is NULL the caller will be checked against all unknown applications,
 *  which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is delivered to the recipient.  The
 *  raw pdu of the status report is in the extended data ("pdu").
 *
 * @throws java.lang.IllegalArgumentException if destinationAddress or text are empty
 * @deprecated Use android.telephony.SmsManager.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public void sendTextMessage(java.lang.String destinationAddress, java.lang.String scAddress, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/**
 * Divide a text message into several messages, none bigger than
 * the maximum SMS message size.
 *
 * @param text the original message.  Must not be null.
 * @return an <code>ArrayList</code> of strings that, in order,
 *   comprise the original message
 * @deprecated Use android.telephony.SmsManager.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.util.ArrayList<java.lang.String> divideMessage(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Send a multi-part text based SMS.  The callee should have already
 * divided the message into correctly sized parts by calling
 * <code>divideMessage</code>.
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *   the current default SMSC
 * @param parts an <code>ArrayList</code> of strings that, in order,
 *   comprise the original message
 * @param sentIntents if not null, an <code>ArrayList</code> of
 *   <code>PendingIntent</code>s (one for each message part) that is
 *   broadcast when the corresponding message part has been sent.
 *   The result code will be <code>Activity.RESULT_OK<code> for success,
 *   or one of these errors:
 *   <code>RESULT_ERROR_GENERIC_FAILURE</code>
 *   <code>RESULT_ERROR_RADIO_OFF</code>
 *   <code>RESULT_ERROR_NULL_PDU</code>.
 *   The per-application based SMS control checks sentIntent. If sentIntent
 *   is NULL the caller will be checked against all unknown applicaitons,
 *   which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntents if not null, an <code>ArrayList</code> of
 *   <code>PendingIntent</code>s (one for each message part) that is
 *   broadcast when the corresponding message part has been delivered
 *   to the recipient.  The raw pdu of the status report is in the
 *   extended data ("pdu").
 *
 * @throws java.lang.IllegalArgumentException if destinationAddress or data are empty
 * @deprecated Use android.telephony.SmsManager.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public void sendMultipartTextMessage(java.lang.String destinationAddress, java.lang.String scAddress, java.util.ArrayList<java.lang.String> parts, java.util.ArrayList<android.app.PendingIntent> sentIntents, java.util.ArrayList<android.app.PendingIntent> deliveryIntents) { throw new RuntimeException("Stub!"); }

/**
 * Send a data based SMS to a specific application port.
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *  the current default SMSC
 * @param destinationPort the port to deliver the message to
 * @param data the body of the message to send
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is sucessfully sent, or failed.
 *  The result code will be <code>Activity.RESULT_OK<code> for success,
 *  or one of these errors:
 *  <code>RESULT_ERROR_GENERIC_FAILURE</code>
 *  <code>RESULT_ERROR_RADIO_OFF</code>
 *  <code>RESULT_ERROR_NULL_PDU</code>.
 *  The per-application based SMS control checks sentIntent. If sentIntent
 *  is NULL the caller will be checked against all unknown applicaitons,
 *  which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is delivered to the recipient.  The
 *  raw pdu of the status report is in the extended data ("pdu").
 *
 * @throws java.lang.IllegalArgumentException if destinationAddress or data are empty
 * @deprecated Use android.telephony.SmsManager.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public void sendDataMessage(java.lang.String destinationAddress, java.lang.String scAddress, short destinationPort, byte[] data, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/** Generic failure cause
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int RESULT_ERROR_GENERIC_FAILURE = 1; // 0x1

/** Failed because service is currently unavailable
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int RESULT_ERROR_NO_SERVICE = 4; // 0x4

/** Failed because no pdu provided
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int RESULT_ERROR_NULL_PDU = 3; // 0x3

/** Failed because radio was explicitly turned off
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int RESULT_ERROR_RADIO_OFF = 2; // 0x2

/** Free space (TS 51.011 10.5.3).
 *  @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int STATUS_ON_SIM_FREE = 0; // 0x0

/** Received and read (TS 51.011 10.5.3).
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int STATUS_ON_SIM_READ = 1; // 0x1

/** Stored and sent (TS 51.011 10.5.3).
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int STATUS_ON_SIM_SENT = 5; // 0x5

/** Received and unread (TS 51.011 10.5.3).
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int STATUS_ON_SIM_UNREAD = 3; // 0x3

/** Stored and unsent (TS 51.011 10.5.3).
 * @deprecated Use android.telephony.SmsManager.     * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int STATUS_ON_SIM_UNSENT = 7; // 0x7
}

