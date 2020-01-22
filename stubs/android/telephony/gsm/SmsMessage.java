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


package android.telephony.gsm;


/**
 * A Short Message Service message.
 * @deprecated Replaced by android.telephony.SmsMessage that supports both GSM and CDMA.
 * @apiSince 1
 * @deprecatedSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class SmsMessage {

/**
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 */

@Deprecated
public SmsMessage() { throw new RuntimeException("Stub!"); }

/**
 * Create an SmsMessage from a raw PDU.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public static android.telephony.gsm.SmsMessage createFromPdu(byte[] pdu) { throw new RuntimeException("Stub!"); }

/**
 * Get the TP-Layer-Length for the given SMS-SUBMIT PDU Basically, the
 * length in bytes (not hex chars) less the SMSC header
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public static int getTPLayerLengthForPDU(java.lang.String pdu) { throw new RuntimeException("Stub!"); }

/**
 * Calculates the number of SMS's required to encode the message body and
 * the number of characters remaining until the next message, given the
 * current encoding.
 *
 * @param messageBody the message to encode
 * @param use7bitOnly if true, characters that are not part of the GSM
 *         alphabet are counted as a single space char.  If false, a
 *         messageBody containing non-GSM alphabet characters is calculated
 *         for 16-bit encoding.
 * @return an int[4] with int[0] being the number of SMS's required, int[1]
 *         the number of code units used, and int[2] is the number of code
 *         units remaining until the next message. int[3] is the encoding
 *         type that should be used for the message.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 3
 * @deprecatedSince 4
 */

@Deprecated
public static int[] calculateLength(java.lang.CharSequence messageBody, boolean use7bitOnly) { throw new RuntimeException("Stub!"); }

/**
 * Calculates the number of SMS's required to encode the message body and
 * the number of characters remaining until the next message, given the
 * current encoding.
 *
 * @param messageBody the message to encode
 * @param use7bitOnly if true, characters that are not part of the GSM
 *         alphabet are counted as a single space char.  If false, a
 *         messageBody containing non-GSM alphabet characters is calculated
 *         for 16-bit encoding.
 * @return an int[4] with int[0] being the number of SMS's required, int[1]
 *         the number of code units used, and int[2] is the number of code
 *         units remaining until the next message. int[3] is the encoding
 *         type that should be used for the message.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public static int[] calculateLength(java.lang.String messageBody, boolean use7bitOnly) { throw new RuntimeException("Stub!"); }

/**
 * Get an SMS-SUBMIT PDU for a destination address and a message
 *
 * @param scAddress Service Centre address.  Null means use default.
 * @return a <code>SubmitPdu</code> containing the encoded SC
 *         address, if applicable, and the encoded message.
 *         Returns null on encode error.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public static android.telephony.gsm.SmsMessage.SubmitPdu getSubmitPdu(java.lang.String scAddress, java.lang.String destinationAddress, java.lang.String message, boolean statusReportRequested) { throw new RuntimeException("Stub!"); }

/**
 * Get an SMS-SUBMIT PDU for a data message to a destination address &amp; port
 *
 * @param scAddress Service Centre address. null == use default
 * @param destinationAddress the address of the destination for the message
 * @param destinationPort the port to deliver the message to at the
 *        destination
 * @param data the dat for the message
 * @return a <code>SubmitPdu</code> containing the encoded SC
 *         address, if applicable, and the encoded message.
 *         Returns null on encode error.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public static android.telephony.gsm.SmsMessage.SubmitPdu getSubmitPdu(java.lang.String scAddress, java.lang.String destinationAddress, short destinationPort, byte[] data, boolean statusReportRequested) { throw new RuntimeException("Stub!"); }

/**
 * Returns the address of the SMS service center that relayed this message
 * or null if there is none.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getServiceCenterAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the originating address (sender) of this SMS message in String
 * form or null if unavailable
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getOriginatingAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the originating address, or email from address if this message
 * was from an email gateway. Returns null if originating address
 * unavailable.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getDisplayOriginatingAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the message body as a String, if it exists and is text based.
 * @return message body is there is one, otherwise null
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getMessageBody() { throw new RuntimeException("Stub!"); }

/**
 * Returns the class of this message.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public android.telephony.gsm.SmsMessage.MessageClass getMessageClass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the message body, or email message body if this message was from
 * an email gateway. Returns null if message body unavailable.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getDisplayMessageBody() { throw new RuntimeException("Stub!"); }

/**
 * Unofficial convention of a subject line enclosed in parens empty string
 * if not present
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getPseudoSubject() { throw new RuntimeException("Stub!"); }

/**
 * Returns the service centre timestamp in currentTimeMillis() format
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public long getTimestampMillis() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if message is an email.
 *
 * @return true if this message came through an email gateway and email
 *         sender / subject / parsed body are available
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isEmail() { throw new RuntimeException("Stub!"); }

/**
 * @return if isEmail() is true, body of the email sent through the gateway.
 *         null otherwise
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getEmailBody() { throw new RuntimeException("Stub!"); }

/**
 * @return if isEmail() is true, email from address of email sent through
 *         the gateway. null otherwise
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String getEmailFrom() { throw new RuntimeException("Stub!"); }

/**
 * Get protocol identifier.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public int getProtocolIdentifier() { throw new RuntimeException("Stub!"); }

/**
 * See TS 23.040 9.2.3.9 returns true if this is a "replace short message" SMS
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isReplace() { throw new RuntimeException("Stub!"); }

/**
 * Returns true for CPHS MWI toggle message.
 *
 * @return true if this is a CPHS MWI toggle message See CPHS 4.2 section B.4.2
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isCphsMwiMessage() { throw new RuntimeException("Stub!"); }

/**
 * returns true if this message is a CPHS voicemail / message waiting
 * indicator (MWI) clear message
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isMWIClearMessage() { throw new RuntimeException("Stub!"); }

/**
 * returns true if this message is a CPHS voicemail / message waiting
 * indicator (MWI) set message
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isMWISetMessage() { throw new RuntimeException("Stub!"); }

/**
 * returns true if this message is a "Message Waiting Indication Group:
 * Discard Message" notification and should not be stored.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isMwiDontStore() { throw new RuntimeException("Stub!"); }

/**
 * returns the user data section minus the user data header if one was present.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public byte[] getUserData() { throw new RuntimeException("Stub!"); }

/**
 * Returns the raw PDU for the message.
 *
 * @return the raw PDU for the message.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
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
 * @deprecated Use android.telephony.SmsMessage and getStatusOnIcc instead.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public int getStatusOnSim() { throw new RuntimeException("Stub!"); }

/**
 * Returns the record index of the message on the SIM (1-based index).
 * @return the record index of the message on the SIM, or -1 if this
 *         SmsMessage was not created from a SIM SMS EF record.
 * @deprecated Use android.telephony.SmsMessage and getIndexOnIcc instead.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public int getIndexOnSim() { throw new RuntimeException("Stub!"); }

/**
 * GSM:
 * For an SMS-STATUS-REPORT message, this returns the status field from
 * the status report.  This field indicates the status of a previously
 * submitted SMS, if requested.  See TS 23.040, 9.2.3.15 TP-Status for a
 * description of values.
 * CDMA:
 * For not interfering with status codes from GSM, the value is
 * shifted to the bits 31-16.
 * The value is composed of an error class (bits 25-24) and a status code (bits 23-16).
 * Possible codes are described in C.S0015-B, v2.0, 4.5.21.
 *
 * @return 0 indicates the previously sent message was received.
 *         See TS 23.040, 9.9.2.3.15 and C.S0015-B, v2.0, 4.5.21
 *         for a description of other possible values.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public int getStatus() { throw new RuntimeException("Stub!"); }

/**
 * Return true iff the message is a SMS-STATUS-REPORT message.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isStatusReportMessage() { throw new RuntimeException("Stub!"); }

/**
 * Returns true iff the <code>TP-Reply-Path</code> bit is set in
 * this message.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public boolean isReplyPathPresent() { throw new RuntimeException("Stub!"); }

/** 16-bit encoding scheme (see TS 23.038)
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int ENCODING_16BIT = 3; // 0x3

/** 7-bit encoding scheme (see TS 23.038)
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int ENCODING_7BIT = 1; // 0x1

/** 8-bit encoding scheme (see TS 23.038)
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int ENCODING_8BIT = 2; // 0x2

/** Unknown encoding scheme (see TS 23.038)
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int ENCODING_UNKNOWN = 0; // 0x0

/** The maximum number of payload bytes per message
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int MAX_USER_DATA_BYTES = 140; // 0x8c

/** The maximum number of payload septets per message
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int MAX_USER_DATA_SEPTETS = 160; // 0xa0

/**
 * The maximum number of payload septets per message if a user data header
 * is present.  This assumes the header only contains the
 * CONCATENATED_8_BIT_REFERENCE element.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153; // 0x99
/**
 * SMS Class enumeration.
 * See TS 23.038.
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public enum MessageClass {
/**
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
UNKNOWN,
/**
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
CLASS_0,
/**
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
CLASS_1,
/**
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
CLASS_2,
/**
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
CLASS_3;
}

/**
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class SubmitPdu {

/**
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 */

@Deprecated
public SubmitPdu() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public byte[] encodedMessage;

/**
 * @deprecated Use android.telephony.SmsMessage.
 * @apiSince 1
 * @deprecatedSince 4
 */

@Deprecated public byte[] encodedScAddress;
}

}

