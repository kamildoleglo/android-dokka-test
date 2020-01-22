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


/**
 * A Short Message Service message.
 * @see android.provider.Telephony.Sms.Intents#getMessagesFromIntent
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SmsMessage {

SmsMessage() { throw new RuntimeException("Stub!"); }

/**
 * Create an SmsMessage from a raw PDU. Guess format based on Voice
 * technology first, if it fails use other format.
 * All applications which handle
 * incoming SMS messages by processing the {@code SMS_RECEIVED_ACTION} broadcast
 * intent <b>must</b> now pass the new {@code format} String extra from the intent
 * into the new method {@code createFromPdu(byte[], String)} which takes an
 * extra format parameter. This is required in order to correctly decode the PDU on
 * devices that require support for both 3GPP and 3GPP2 formats at the same time,
 * such as dual-mode GSM/CDMA and CDMA/LTE phones.
 * @deprecated Use {@link #createFromPdu(byte[],java.lang.String)} instead.
 * @apiSince 4
 * @deprecatedSince 23
 */

@Deprecated
public static android.telephony.SmsMessage createFromPdu(byte[] pdu) { throw new RuntimeException("Stub!"); }

/**
 * Create an SmsMessage from a raw PDU with the specified message format. The
 * message format is passed in the
 * {@link android.provider.Telephony.Sms.Intents#SMS_RECEIVED_ACTION} as the {@code format}
 * String extra, and will be either "3gpp" for GSM/UMTS/LTE messages in 3GPP format
 * or "3gpp2" for CDMA/LTE messages in 3GPP2 format.
 *
 * @param pdu the message PDU from the
 * {@link android.provider.Telephony.Sms.Intents#SMS_RECEIVED_ACTION} intent
 * @param format the format extra from the
 * {@link android.provider.Telephony.Sms.Intents#SMS_RECEIVED_ACTION} intent
 * @apiSince 23
 */

public static android.telephony.SmsMessage createFromPdu(byte[] pdu, java.lang.String format) { throw new RuntimeException("Stub!"); }

/**
 * Get the TP-Layer-Length for the given SMS-SUBMIT PDU Basically, the
 * length in bytes (not hex chars) less the SMSC header
 *
 * FIXME: This method is only used by a CTS test case that isn't run on CDMA devices.
 * We should probably deprecate it and remove the obsolete test case.
 * @apiSince 4
 */

public static int getTPLayerLengthForPDU(java.lang.String pdu) { throw new RuntimeException("Stub!"); }

/**
 * Calculates the number of SMS's required to encode the message body and the number of
 * characters remaining until the next message.
 *
 * @param msgBody the message to encode
 * @param use7bitOnly if true, characters that are not part of the radio-specific 7-bit encoding
 *     are counted as single space chars. If false, and if the messageBody contains non-7-bit
 *     encodable characters, length is calculated using a 16-bit encoding.
 * @return an int[6] with int[0] being the number of SMS's required, int[1] the number of code
 *     units used, and int[2] is the number of code units remaining until the next message.
 *     int[3] is an indicator of the encoding code unit size (see the ENCODING_* definitions in
 *     SmsConstants). int[4] is the GSM national language table to use, or 0 for the default
 *     7-bit alphabet. int[5] The GSM national language shift table to use, or 0 for the default
 *     7-bit extension table.
 * @apiSince 4
 */

public static int[] calculateLength(java.lang.CharSequence msgBody, boolean use7bitOnly) { throw new RuntimeException("Stub!"); }

/**
 * Calculates the number of SMS's required to encode the message body and the number of
 * characters remaining until the next message, given the current encoding.
 *
 * @param messageBody the message to encode
 * @param use7bitOnly if true, characters that are not part of the radio specific (GSM / CDMA)
 *     alphabet encoding are converted to as a single space characters. If false, a messageBody
 *     containing non-GSM or non-CDMA alphabet characters are encoded using 16-bit encoding.
 * @return an int[4] with int[0] being the number of SMS's required, int[1] the number of code
 *     units used, and int[2] is the number of code units remaining until the next message.
 *     int[3] is the encoding type that should be used for the message.
 * @apiSince 4
 */

public static int[] calculateLength(java.lang.String messageBody, boolean use7bitOnly) { throw new RuntimeException("Stub!"); }

/**
 * Get an SMS-SUBMIT PDU for a destination address and a message.
 * This method will not attempt to use any GSM national language 7 bit encodings.
 *
 * @param scAddress Service Centre address.  Null means use default.
 * @return a <code>SubmitPdu</code> containing the encoded SC
 *         address, if applicable, and the encoded message.
 *         Returns null on encode error.
 * @apiSince 4
 */

public static android.telephony.SmsMessage.SubmitPdu getSubmitPdu(java.lang.String scAddress, java.lang.String destinationAddress, java.lang.String message, boolean statusReportRequested) { throw new RuntimeException("Stub!"); }

/**
 * Get an SMS-SUBMIT PDU for a data message to a destination address &amp; port.
 * This method will not attempt to use any GSM national language 7 bit encodings.
 *
 * @param scAddress Service Centre address. null == use default
 * @param destinationAddress the address of the destination for the message
 * @param destinationPort the port to deliver the message to at the
 *        destination
 * @param data the data for the message
 * @return a <code>SubmitPdu</code> containing the encoded SC
 *         address, if applicable, and the encoded message.
 *         Returns null on encode error.
 * @apiSince 4
 */

public static android.telephony.SmsMessage.SubmitPdu getSubmitPdu(java.lang.String scAddress, java.lang.String destinationAddress, short destinationPort, byte[] data, boolean statusReportRequested) { throw new RuntimeException("Stub!"); }

/**
 * Returns the address of the SMS service center that relayed this message
 * or null if there is none.
 * @apiSince 4
 */

public java.lang.String getServiceCenterAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the originating address (sender) of this SMS message in String
 * form or null if unavailable.
 *
 * <p>If the address is a GSM-formatted address, it will be in a format specified by 3GPP
 * 23.040 Sec 9.1.2.5. If it is a CDMA address, it will be a format specified by 3GPP2
 * C.S005-D Table 2.7.1.3.2.4-2. The choice of format is carrier-specific, so callers of the
 * should be careful to avoid assumptions about the returned content.
 *
 * @return a String representation of the address; null if unavailable.
 * @apiSince 4
 */

@androidx.annotation.Nullable
public java.lang.String getOriginatingAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the originating address, or email from address if this message
 * was from an email gateway. Returns null if originating address
 * unavailable.
 * @apiSince 4
 */

public java.lang.String getDisplayOriginatingAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the message body as a String, if it exists and is text based.
 * @return message body if there is one, otherwise null
 * @apiSince 4
 */

public java.lang.String getMessageBody() { throw new RuntimeException("Stub!"); }

/**
 * Returns the class of this message.
 * @apiSince 4
 */

public android.telephony.SmsMessage.MessageClass getMessageClass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the message body, or email message body if this message was from
 * an email gateway. Returns null if message body unavailable.
 * @apiSince 4
 */

public java.lang.String getDisplayMessageBody() { throw new RuntimeException("Stub!"); }

/**
 * Unofficial convention of a subject line enclosed in parens empty string
 * if not present
 * @apiSince 4
 */

public java.lang.String getPseudoSubject() { throw new RuntimeException("Stub!"); }

/**
 * Returns the service centre timestamp in currentTimeMillis() format
 * @apiSince 4
 */

public long getTimestampMillis() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if message is an email.
 *
 * @return true if this message came through an email gateway and email
 *         sender / subject / parsed body are available
 * @apiSince 4
 */

public boolean isEmail() { throw new RuntimeException("Stub!"); }

/**
 * @return if isEmail() is true, body of the email sent through the gateway.
 *         null otherwise
 * @apiSince 4
 */

public java.lang.String getEmailBody() { throw new RuntimeException("Stub!"); }

/**
 * @return if isEmail() is true, email from address of email sent through
 *         the gateway. null otherwise
 * @apiSince 4
 */

public java.lang.String getEmailFrom() { throw new RuntimeException("Stub!"); }

/**
 * Get protocol identifier.
 * @apiSince 4
 */

public int getProtocolIdentifier() { throw new RuntimeException("Stub!"); }

/**
 * See TS 23.040 9.2.3.9 returns true if this is a "replace short message"
 * SMS
 * @apiSince 4
 */

public boolean isReplace() { throw new RuntimeException("Stub!"); }

/**
 * Returns true for CPHS MWI toggle message.
 *
 * @return true if this is a CPHS MWI toggle message See CPHS 4.2 section
 *         B.4.2
 * @apiSince 4
 */

public boolean isCphsMwiMessage() { throw new RuntimeException("Stub!"); }

/**
 * returns true if this message is a CPHS voicemail / message waiting
 * indicator (MWI) clear message
 * @apiSince 4
 */

public boolean isMWIClearMessage() { throw new RuntimeException("Stub!"); }

/**
 * returns true if this message is a CPHS voicemail / message waiting
 * indicator (MWI) set message
 * @apiSince 4
 */

public boolean isMWISetMessage() { throw new RuntimeException("Stub!"); }

/**
 * returns true if this message is a "Message Waiting Indication Group:
 * Discard Message" notification and should not be stored.
 * @apiSince 4
 */

public boolean isMwiDontStore() { throw new RuntimeException("Stub!"); }

/**
 * returns the user data section minus the user data header if one was
 * present.
 * @apiSince 4
 */

public byte[] getUserData() { throw new RuntimeException("Stub!"); }

/**
 * Returns the raw PDU for the message.
 *
 * @return the raw PDU for the message.
 * @apiSince 4
 */

public byte[] getPdu() { throw new RuntimeException("Stub!"); }

/**
 * Returns the status of the message on the SIM (read, unread, sent, unsent).
 *
 * @return the status of the message on the SIM.  These are:
 *         SmsManager.STATUS_ON_SIM_FREE
 *         SmsManager.STATUS_ON_SIM_READ
 *         SmsManager.STATUS_ON_SIM_UNREAD
 *         SmsManager.STATUS_ON_SIM_SEND
 *         SmsManager.STATUS_ON_SIM_UNSENT
 * @deprecated Use getStatusOnIcc instead.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated
public int getStatusOnSim() { throw new RuntimeException("Stub!"); }

/**
 * Returns the status of the message on the ICC (read, unread, sent, unsent).
 *
 * @return the status of the message on the ICC.  These are:
 *         SmsManager.STATUS_ON_ICC_FREE
 *         SmsManager.STATUS_ON_ICC_READ
 *         SmsManager.STATUS_ON_ICC_UNREAD
 *         SmsManager.STATUS_ON_ICC_SEND
 *         SmsManager.STATUS_ON_ICC_UNSENT
 * @apiSince 4
 */

public int getStatusOnIcc() { throw new RuntimeException("Stub!"); }

/**
 * Returns the record index of the message on the SIM (1-based index).
 * @return the record index of the message on the SIM, or -1 if this
 *         SmsMessage was not created from a SIM SMS EF record.
 * @deprecated Use getIndexOnIcc instead.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated
public int getIndexOnSim() { throw new RuntimeException("Stub!"); }

/**
 * Returns the record index of the message on the ICC (1-based index).
 * @return the record index of the message on the ICC, or -1 if this
 *         SmsMessage was not created from a ICC SMS EF record.
 * @apiSince 4
 */

public int getIndexOnIcc() { throw new RuntimeException("Stub!"); }

/**
 * GSM: For an SMS-STATUS-REPORT message, this returns the status field from the status report.
 * This field indicates the status of a previously submitted SMS, if requested.
 * See TS 23.040, 9.2.3.15 TP-Status for a description of values.
 * CDMA: For not interfering with status codes from GSM, the value is shifted to the bits 31-16.
 * The value is composed of an error class (bits 25-24) and a status code (bits 23-16). Possible
 * codes are described in C.S0015-B, v2.0, 4.5.21.
 *
 * @return 0 for GSM or 2 shifted left by 16 for CDMA indicates the previously sent message was
 *         received. See TS 23.040, 9.2.3.15 and C.S0015-B, v2.0, 4.5.21 for a description of
 *         other possible values.
 * @apiSince 4
 */

public int getStatus() { throw new RuntimeException("Stub!"); }

/**
 * Return true iff the message is a SMS-STATUS-REPORT message.
 * @apiSince 4
 */

public boolean isStatusReportMessage() { throw new RuntimeException("Stub!"); }

/**
 * Returns true iff the <code>TP-Reply-Path</code> bit is set in
 * this message.
 * @apiSince 4
 */

public boolean isReplyPathPresent() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public static final int ENCODING_16BIT = 3; // 0x3

/** @apiSince 4 */

public static final int ENCODING_7BIT = 1; // 0x1

/** @apiSince 4 */

public static final int ENCODING_8BIT = 2; // 0x2

/**
 * User data text encoding code unit size
 * @apiSince 4
 */

public static final int ENCODING_UNKNOWN = 0; // 0x0

/**
 * Indicates a 3GPP format SMS message.
 * @see SmsManager#injectSmsPdu(byte[], String, PendingIntent)
 * @apiSince 28
 */

public static final java.lang.String FORMAT_3GPP = "3gpp";

/**
 * Indicates a 3GPP2 format SMS message.
 * @see SmsManager#injectSmsPdu(byte[], String, PendingIntent)
 * @apiSince 28
 */

public static final java.lang.String FORMAT_3GPP2 = "3gpp2";

/**
 * The maximum number of payload bytes per message
 * @apiSince 4
 */

public static final int MAX_USER_DATA_BYTES = 140; // 0x8c

/**
 * The maximum number of payload bytes per message if a user data header
 * is present.  This assumes the header only contains the
 * CONCATENATED_8_BIT_REFERENCE element.
 * @apiSince 4
 */

public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134; // 0x86

/**
 * The maximum number of payload septets per message
 * @apiSince 4
 */

public static final int MAX_USER_DATA_SEPTETS = 160; // 0xa0

/**
 * The maximum number of payload septets per message if a user data header
 * is present.  This assumes the header only contains the
 * CONCATENATED_8_BIT_REFERENCE element.
 * @apiSince 4
 */

public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153; // 0x99
/**
 * SMS Class enumeration.
 * See TS 23.038.
 *
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum MessageClass {
/** @apiSince 4 */

UNKNOWN,
/** @apiSince 4 */

CLASS_0,
/** @apiSince 4 */

CLASS_1,
/** @apiSince 4 */

CLASS_2,
/** @apiSince 4 */

CLASS_3;
}

/** @apiSince 4 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SubmitPdu {

SubmitPdu() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public byte[] encodedMessage;

/** @apiSince 4 */

public byte[] encodedScAddress;
}

}

