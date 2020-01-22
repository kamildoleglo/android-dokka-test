/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.service.carrier;

import java.util.List;
import android.content.Intent;

/**
 * A service that receives calls from the system when new SMS and MMS are
 * sent or received.
 * <p>To extend this class, you must declare the service in your manifest file with
 * the {@link android.Manifest.permission#BIND_CARRIER_SERVICES} permission
 * and include an intent filter with the {@link #SERVICE_INTERFACE} action. For example:</p>
 * <pre>
 * &lt;service android:name=".MyMessagingService"
 *          android:label="&#64;string/service_name"
 *          android:permission="android.permission.BIND_CARRIER_SERVICES">
 *     &lt;intent-filter>
 *         &lt;action android:name="android.service.carrier.CarrierMessagingService" />
 *     &lt;/intent-filter>
 * &lt;/service></pre>
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CarrierMessagingService extends android.app.Service {

public CarrierMessagingService() { throw new RuntimeException("Stub!"); }

/**
 * Override this method to filter inbound SMS messages.
 *
 * @param pdu the PDUs of the message
 * This value must never be {@code null}.
 * @param format the format of the PDUs, typically "3gpp" or "3gpp2"
 * This value must never be {@code null}.
 * @param destPort the destination port of a binary SMS, this will be -1 for text SMS
 * @param subId SMS subscription ID of the SIM
 * @param callback result callback. Call with {@code true} to keep an inbound SMS message and
 *        deliver to SMS apps, and {@code false} to drop the message.
 * This value must never be {@code null}.
 * @deprecated Use {@link #onReceiveTextSms} instead.
 * @apiSince 22
 * @deprecatedSince 24
 */

@Deprecated
public void onFilterSms(@androidx.annotation.NonNull android.service.carrier.MessagePdu pdu, @androidx.annotation.NonNull java.lang.String format, int destPort, int subId, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<java.lang.Boolean> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to filter inbound SMS messages.
 *
 * <p>This method will be called once for every incoming text SMS. You can invoke the callback
 * with a bitmask to tell the platform how to handle the SMS. For a SMS received on a
 * file-based encryption capable device while the credential-encrypted storage is not available,
 * this method will be called for the second time when the credential-encrypted storage becomes
 * available after the user unlocks the phone, if the bit {@link #RECEIVE_OPTIONS_DROP} is not
 * set when invoking the callback.
 *
 * @param pdu the PDUs of the message
 * This value must never be {@code null}.
 * @param format the format of the PDUs, typically "3gpp" or "3gpp2"
 * This value must never be {@code null}.
 * @param destPort the destination port of a binary SMS, this will be -1 for text SMS
 * @param subId SMS subscription ID of the SIM
 * @param callback result callback. Call with a bitmask integer to indicate how the incoming
 *        text SMS should be handled by the platform. Use {@link #RECEIVE_OPTIONS_DROP} and
 *        {@link #RECEIVE_OPTIONS_SKIP_NOTIFY_WHEN_CREDENTIAL_PROTECTED_STORAGE_UNAVAILABLE}
 *        to set the flags in the bitmask.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void onReceiveTextSms(@androidx.annotation.NonNull android.service.carrier.MessagePdu pdu, @androidx.annotation.NonNull java.lang.String format, int destPort, int subId, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<java.lang.Integer> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to intercept text SMSs sent from the device.
 * @deprecated Override {@link #onSendTextSms} below instead.
 *
 * @param text the text to send
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param destAddress phone number of the recipient of the message
 * This value must never be {@code null}.
 * @param callback result callback. Call with a {@link android.service.carrier.CarrierMessagingService.SendSmsResult SendSmsResult}.
 
 * This value must never be {@code null}.
 * @apiSince 22
 * @deprecatedSince 23
 */

@Deprecated
public void onSendTextSms(@androidx.annotation.NonNull java.lang.String text, int subId, @androidx.annotation.NonNull java.lang.String destAddress, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<android.service.carrier.CarrierMessagingService.SendSmsResult> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to intercept text SMSs sent from the device.
 *
 * @param text the text to send
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param destAddress phone number of the recipient of the message
 * This value must never be {@code null}.
 * @param sendSmsFlag Flag for sending SMS. Acceptable values are 0 and
 *        {@link #SEND_FLAG_REQUEST_DELIVERY_STATUS}.
 * @param callback result callback. Call with a {@link android.service.carrier.CarrierMessagingService.SendSmsResult SendSmsResult}.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void onSendTextSms(@androidx.annotation.NonNull java.lang.String text, int subId, @androidx.annotation.NonNull java.lang.String destAddress, int sendSmsFlag, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<android.service.carrier.CarrierMessagingService.SendSmsResult> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to intercept binary SMSs sent from the device.
 * @deprecated Override {@link #onSendDataSms} below instead.
 *
 * @param data the binary content
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param destAddress phone number of the recipient of the message
 * This value must never be {@code null}.
 * @param destPort the destination port
 * @param callback result callback. Call with a {@link android.service.carrier.CarrierMessagingService.SendSmsResult SendSmsResult}.
 
 * This value must never be {@code null}.
 * @apiSince 22
 * @deprecatedSince 23
 */

@Deprecated
public void onSendDataSms(@androidx.annotation.NonNull byte[] data, int subId, @androidx.annotation.NonNull java.lang.String destAddress, int destPort, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<android.service.carrier.CarrierMessagingService.SendSmsResult> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to intercept binary SMSs sent from the device.
 *
 * @param data the binary content
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param destAddress phone number of the recipient of the message
 * This value must never be {@code null}.
 * @param destPort the destination port
 * @param sendSmsFlag Flag for sending SMS. Acceptable values are 0 and
 *        {@link #SEND_FLAG_REQUEST_DELIVERY_STATUS}.
 * @param callback result callback. Call with a {@link android.service.carrier.CarrierMessagingService.SendSmsResult SendSmsResult}.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void onSendDataSms(@androidx.annotation.NonNull byte[] data, int subId, @androidx.annotation.NonNull java.lang.String destAddress, int destPort, int sendSmsFlag, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<android.service.carrier.CarrierMessagingService.SendSmsResult> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to intercept long SMSs sent from the device.
 * @deprecated Override {@link #onSendMultipartTextSms} below instead.
 *
 * @param parts a {@link java.util.List List} of the message parts
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param destAddress phone number of the recipient of the message
 * This value must never be {@code null}.
 * @param callback result callback. Call with a {@link android.service.carrier.CarrierMessagingService.SendMultipartSmsResult SendMultipartSmsResult}.
 
 * This value must never be {@code null}.
 * @apiSince 22
 * @deprecatedSince 23
 */

@Deprecated
public void onSendMultipartTextSms(@androidx.annotation.NonNull java.util.List<java.lang.String> parts, int subId, @androidx.annotation.NonNull java.lang.String destAddress, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<android.service.carrier.CarrierMessagingService.SendMultipartSmsResult> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to intercept long SMSs sent from the device.
 *
 * @param parts a {@link java.util.List List} of the message parts
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param destAddress phone number of the recipient of the message
 * This value must never be {@code null}.
 * @param sendSmsFlag Flag for sending SMS. Acceptable values are 0 and
 *        {@link #SEND_FLAG_REQUEST_DELIVERY_STATUS}.
 * @param callback result callback. Call with a {@link android.service.carrier.CarrierMessagingService.SendMultipartSmsResult SendMultipartSmsResult}.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void onSendMultipartTextSms(@androidx.annotation.NonNull java.util.List<java.lang.String> parts, int subId, @androidx.annotation.NonNull java.lang.String destAddress, int sendSmsFlag, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<android.service.carrier.CarrierMessagingService.SendMultipartSmsResult> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to intercept MMSs sent from the device.
 *
 * @param pduUri the content provider URI of the PDU to send
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param location the optional URI to send this MMS PDU. If this is {code null},
 *        the PDU should be sent to the default MMSC URL.
 * This value may be {@code null}.
 * @param callback result callback. Call with a {@link android.service.carrier.CarrierMessagingService.SendMmsResult SendMmsResult}.
 
 * This value must never be {@code null}.
 * @apiSince 22
 */

public void onSendMms(@androidx.annotation.NonNull android.net.Uri pduUri, int subId, @androidx.annotation.Nullable android.net.Uri location, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<android.service.carrier.CarrierMessagingService.SendMmsResult> callback) { throw new RuntimeException("Stub!"); }

/**
 * Override this method to download MMSs received.
 *
 * @param contentUri the content provider URI of the PDU to be downloaded.
 * This value must never be {@code null}.
 * @param subId SMS subscription ID of the SIM
 * @param location the URI of the message to be downloaded.
 * This value must never be {@code null}.
 * @param callback result callback. Call with a status code which is one of
 *        {@link #DOWNLOAD_STATUS_OK},
 *        {@link #DOWNLOAD_STATUS_RETRY_ON_CARRIER_NETWORK}, or {@link #DOWNLOAD_STATUS_ERROR}.
 
 * This value must never be {@code null}.
 * @apiSince 22
 */

public void onDownloadMms(@androidx.annotation.NonNull android.net.Uri contentUri, int subId, @androidx.annotation.NonNull android.net.Uri location, @androidx.annotation.NonNull android.service.carrier.CarrierMessagingService.ResultCallback<java.lang.Integer> callback) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param intent This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 22
 */

@androidx.annotation.Nullable
public android.os.IBinder onBind(@androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * MMS downloading failed. We should not retry via the carrier network.
 * @apiSince 22
 */

public static final int DOWNLOAD_STATUS_ERROR = 2; // 0x2

/**
 * Successfully downloaded an MMS message.
 * @apiSince 22
 */

public static final int DOWNLOAD_STATUS_OK = 0; // 0x0

/**
 * MMS downloading failed. We should retry via the carrier network.
 * @apiSince 22
 */

public static final int DOWNLOAD_STATUS_RETRY_ON_CARRIER_NETWORK = 1; // 0x1

/**
 * The default bitmask value passed to the callback of {@link #onReceiveTextSms} with all
 * {@code RECEIVE_OPTIONS_x} flags cleared to indicate that the message should be kept and a
 * new message notification should be shown.
 *
 * @see #RECEIVE_OPTIONS_DROP
 * @see #RECEIVE_OPTIONS_SKIP_NOTIFY_WHEN_CREDENTIAL_PROTECTED_STORAGE_UNAVAILABLE
 * @apiSince 24
 */

public static final int RECEIVE_OPTIONS_DEFAULT = 0; // 0x0

/**
 * Used to set the flag in the bitmask passed to the callback of {@link #onReceiveTextSms} to
 * indicate that the inbound SMS should be dropped.
 * @apiSince 24
 */

public static final int RECEIVE_OPTIONS_DROP = 1; // 0x1

/**
 * Used to set the flag in the bitmask passed to the callback of {@link #onReceiveTextSms} to
 * indicate that a new message notification should not be shown to the user when the
 * credential-encrypted storage of the device is not available before the user unlocks the
 * phone. It is only applicable to devices that support file-based encryption.
 * @apiSince 24
 */

public static final int RECEIVE_OPTIONS_SKIP_NOTIFY_WHEN_CREDENTIAL_PROTECTED_STORAGE_UNAVAILABLE = 2; // 0x2

/**
 * Flag to request SMS delivery status report.
 * @apiSince 23
 */

public static final int SEND_FLAG_REQUEST_DELIVERY_STATUS = 1; // 0x1

/**
 * SMS/MMS sending failed. We should not retry via the carrier network.
 * @apiSince 22
 */

public static final int SEND_STATUS_ERROR = 2; // 0x2

/**
 * Indicates that an SMS or MMS message was successfully sent.
 * @apiSince 22
 */

public static final int SEND_STATUS_OK = 0; // 0x0

/**
 * SMS/MMS sending failed. We should retry via the carrier network.
 * @apiSince 22
 */

public static final int SEND_STATUS_RETRY_ON_CARRIER_NETWORK = 1; // 0x1

/**
 * The {@link android.content.Intent} that must be declared as handled by the service.
 * @apiSince 22
 */

public static final java.lang.String SERVICE_INTERFACE = "android.service.carrier.CarrierMessagingService";
/**
 * A callback interface used to provide results asynchronously.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ResultCallback<T> {

/**
 * Invoked when the result is available.
 *
 * @param result the result
 
 * This value must never be {@code null}.
 * @apiSince 22
 */

public void onReceiveResult(@androidx.annotation.NonNull T result) throws android.os.RemoteException;
}

/**
 * The result of sending an MMS.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SendMmsResult {

/**
 * Constructs a SendMmsResult with the MMS send result, and the SendConf PDU.
 *
 * @param sendStatus send status, one of {@link #SEND_STATUS_OK},
 *        {@link #SEND_STATUS_RETRY_ON_CARRIER_NETWORK}, and
 *        {@link #SEND_STATUS_ERROR}
 * @param sendConfPdu a possibly {code null} SendConf PDU, which confirms that the message
 *        was sent. sendConfPdu is ignored if the {@code result} is not
 *        {@link #SEND_STATUS_OK}.
 
 * This value may be {@code null}.
 * @apiSince 22
 */

public SendMmsResult(int sendStatus, @androidx.annotation.Nullable byte[] sendConfPdu) { throw new RuntimeException("Stub!"); }

/**
 * Returns the send status of the just-sent MMS.
 *
 * @return the send status which is one of {@link #SEND_STATUS_OK},
 *         {@link #SEND_STATUS_RETRY_ON_CARRIER_NETWORK}, and {@link #SEND_STATUS_ERROR}
 * @apiSince 22
 */

public int getSendStatus() { throw new RuntimeException("Stub!"); }

/**
 * Returns the SendConf PDU, which confirms that the message was sent.
 *
 * @return the SendConf PDU
 
 * This value may be {@code null}.
 * @apiSince 22
 */

@androidx.annotation.Nullable
public byte[] getSendConfPdu() { throw new RuntimeException("Stub!"); }
}

/**
 * The result of sending a multipart SMS.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SendMultipartSmsResult {

/**
 * Constructs a SendMultipartSmsResult with the send status and message references for the
 * just-sent multipart SMS.
 *
 * @param sendStatus send status, one of {@link #SEND_STATUS_OK},
 *        {@link #SEND_STATUS_RETRY_ON_CARRIER_NETWORK}, and {@link #SEND_STATUS_ERROR}.
 * @param messageRefs an array of message references, one for each part of the
 *        multipart SMS. This field is applicable only if send status is
 *        {@link #SEND_STATUS_OK}.
 
 * This value may be {@code null}.
 * @apiSince 22
 */

public SendMultipartSmsResult(int sendStatus, @androidx.annotation.Nullable int[] messageRefs) { throw new RuntimeException("Stub!"); }

/**
 * Returns the message references of the just-sent multipart SMS.
 *
 * @return the message references, one for each part of the multipart SMS
 
 * This value may be {@code null}.
 * @apiSince 22
 */

@androidx.annotation.Nullable
public int[] getMessageRefs() { throw new RuntimeException("Stub!"); }

/**
 * Returns the send status of the just-sent SMS.
 *
 * @return the send status
 * @apiSince 22
 */

public int getSendStatus() { throw new RuntimeException("Stub!"); }
}

/**
 * The result of sending an SMS.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SendSmsResult {

/**
 * Constructs a SendSmsResult with the send status and message reference for the
 * just-sent SMS.
 *
 * @param sendStatus send status, one of {@link #SEND_STATUS_OK},
 *        {@link #SEND_STATUS_RETRY_ON_CARRIER_NETWORK}, and {@link #SEND_STATUS_ERROR}.
 * @param messageRef message reference of the just-sent SMS. This field is applicable only
 *        if send status is {@link #SEND_STATUS_OK}.
 * @apiSince 22
 */

public SendSmsResult(int sendStatus, int messageRef) { throw new RuntimeException("Stub!"); }

/**
 * Returns the message reference of the just-sent SMS.
 *
 * @return the message reference
 * @apiSince 22
 */

public int getMessageRef() { throw new RuntimeException("Stub!"); }

/**
 * Returns the send status of the just-sent SMS.
 *
 * @return the send status
 * @apiSince 22
 */

public int getSendStatus() { throw new RuntimeException("Stub!"); }
}

}

