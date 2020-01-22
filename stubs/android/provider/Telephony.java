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

import android.content.Intent;
import android.Manifest;
import android.telephony.TelephonyManager;
import java.util.Set;
import android.net.Uri;
import android.telephony.SubscriptionManager;
import android.telephony.ServiceState;
import android.database.ContentObserver;

/**
 * The Telephony provider contains data related to phone operation, specifically SMS and MMS
 * messages, access to the APN list, including the MMSC to use, and the service state.
 *
 * <p class="note"><strong>Note:</strong> These APIs are not available on all Android-powered
 * devices. If your app depends on telephony features such as for managing SMS messages, include
 * a <a href="{@docRoot}guide/topics/manifest/uses-feature-element.html">{@code <uses-feature>}
 * </a> element in your manifest that declares the {@code "android.hardware.telephony"} hardware
 * feature. Alternatively, you can check for telephony availability at runtime using either
 * {@link android.content.pm.PackageManager#hasSystemFeature
 * hasSystemFeature(PackageManager.FEATURE_TELEPHONY)} or {@link
 * android.telephony.TelephonyManager#getPhoneType}.</p>
 *
 * <h3>Creating an SMS app</h3>
 *
 * <p>Only the default SMS app (selected by the user in system settings) is able to write to the
 * SMS Provider (the tables defined within the {@code Telephony} class) and only the default SMS
 * app receives the {@link android.provider.Telephony.Sms.Intents#SMS_DELIVER_ACTION} broadcast
 * when the user receives an SMS or the {@link
 * android.provider.Telephony.Sms.Intents#WAP_PUSH_DELIVER_ACTION} broadcast when the user
 * receives an MMS.</p>
 *
 * <p>Any app that wants to behave as the user's default SMS app must handle the following intents:
 * <ul>
 * <li>In a broadcast receiver, include an intent filter for {@link Sms.Intents#SMS_DELIVER_ACTION}
 * (<code>"android.provider.Telephony.SMS_DELIVER"</code>). The broadcast receiver must also
 * require the {@link android.Manifest.permission#BROADCAST_SMS} permission.
 * <p>This allows your app to directly receive incoming SMS messages.</p></li>
 * <li>In a broadcast receiver, include an intent filter for {@link
 * Sms.Intents#WAP_PUSH_DELIVER_ACTION}} ({@code "android.provider.Telephony.WAP_PUSH_DELIVER"})
 * with the MIME type <code>"application/vnd.wap.mms-message"</code>.
 * The broadcast receiver must also require the {@link
 * android.Manifest.permission#BROADCAST_WAP_PUSH} permission.
 * <p>This allows your app to directly receive incoming MMS messages.</p></li>
 * <li>In your activity that delivers new messages, include an intent filter for
 * {@link android.content.Intent#ACTION_SENDTO} (<code>"android.intent.action.SENDTO"
 * </code>) with schemas, <code>sms:</code>, <code>smsto:</code>, <code>mms:</code>, and
 * <code>mmsto:</code>.
 * <p>This allows your app to receive intents from other apps that want to deliver a
 * message.</p></li>
 * <li>In a service, include an intent filter for {@link
 * android.telephony.TelephonyManager#ACTION_RESPOND_VIA_MESSAGE}
 * (<code>"android.intent.action.RESPOND_VIA_MESSAGE"</code>) with schemas,
 * <code>sms:</code>, <code>smsto:</code>, <code>mms:</code>, and <code>mmsto:</code>.
 * This service must also require the {@link
 * android.Manifest.permission#SEND_RESPOND_VIA_MESSAGE} permission.
 * <p>This allows users to respond to incoming phone calls with an immediate text message
 * using your app.</p></li>
 * </ul>
 *
 * <p>Other apps that are not selected as the default SMS app can only <em>read</em> the SMS
 * Provider, but may also be notified when a new SMS arrives by listening for the {@link
 * Sms.Intents#SMS_RECEIVED_ACTION}
 * broadcast, which is a non-abortable broadcast that may be delivered to multiple apps. This
 * broadcast is intended for apps that&mdash;while not selected as the default SMS app&mdash;need to
 * read special incoming messages such as to perform phone number verification.</p>
 *
 * <p>For more information about building SMS apps, read the blog post, <a
 * href="http://android-developers.blogspot.com/2013/10/getting-your-sms-apps-ready-for-kitkat.html"
 * >Getting Your SMS Apps Ready for KitKat</a>.</p>
 *
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Telephony {

private Telephony() { throw new RuntimeException("Stub!"); }
/**
 * Base columns for tables that contain MMSs.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface BaseMmsColumns extends android.provider.BaseColumns {

/**
 * The {@code content-class} of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String CONTENT_CLASS = "ct_cls";

/**
 * The {@code Content-Location} of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String CONTENT_LOCATION = "ct_l";

/**
 * The {@code Content-Type} of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String CONTENT_TYPE = "ct_t";

/**
 * The identity of the sender of a sent message. It is
 * usually the package name of the app which sends the message.
 * <p class="note"><strong>Note:</strong>
 * This column is read-only. It is set by the provider and can not be changed by apps.
 * <p>Type: TEXT</p>
 * @apiSince 21
 */

public static final java.lang.String CREATOR = "creator";

/**
 * The date the message was received.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String DATE = "date";

/**
 * The date the message was sent.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String DATE_SENT = "date_sent";

/**
 * The {@code delivery-report} of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String DELIVERY_REPORT = "d_rpt";

/**
 * The {@code delivery-time} of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String DELIVERY_TIME = "d_tm";

/**
 * The expiry time of the message.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String EXPIRY = "exp";

/**
 * Is the message locked?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String LOCKED = "locked";

/**
 * The box which the message belongs to, e.g.&nbsp;{@link #MESSAGE_BOX_INBOX}.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MESSAGE_BOX = "msg_box";

/**
 * Message box: all messages.
 * @apiSince 19
 */

public static final int MESSAGE_BOX_ALL = 0; // 0x0

/**
 * Message box: drafts.
 * @apiSince 19
 */

public static final int MESSAGE_BOX_DRAFTS = 3; // 0x3

/**
 * Message box: failed.
 * @apiSince 21
 */

public static final int MESSAGE_BOX_FAILED = 5; // 0x5

/**
 * Message box: inbox.
 * @apiSince 19
 */

public static final int MESSAGE_BOX_INBOX = 1; // 0x1

/**
 * Message box: outbox.
 * @apiSince 19
 */

public static final int MESSAGE_BOX_OUTBOX = 4; // 0x4

/**
 * Message box: sent messages.
 * @apiSince 19
 */

public static final int MESSAGE_BOX_SENT = 2; // 0x2

/**
 * The class of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String MESSAGE_CLASS = "m_cls";

/**
 * The {@code Message-ID} of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String MESSAGE_ID = "m_id";

/**
 * The size of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MESSAGE_SIZE = "m_size";

/**
 * The type of the message defined by MMS spec.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MESSAGE_TYPE = "m_type";

/**
 * The version of the specification that this message conforms to.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MMS_VERSION = "v";

/**
 * The priority of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String PRIORITY = "pri";

/**
 * Has the message been read?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String READ = "read";

/**
 * The {@code read-report} of the message.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String READ_REPORT = "rr";

/**
 * The {@code read-status} of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String READ_STATUS = "read_status";

/**
 * Is read report allowed?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String REPORT_ALLOWED = "rpt_a";

/**
 * The {@code response-status} of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String RESPONSE_STATUS = "resp_st";

/**
 * The {@code response-text} of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String RESPONSE_TEXT = "resp_txt";

/**
 * The {@code retrieve-status} of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String RETRIEVE_STATUS = "retr_st";

/**
 * The {@code retrieve-text} of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String RETRIEVE_TEXT = "retr_txt";

/**
 * The character set of the retrieve-text.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String RETRIEVE_TEXT_CHARSET = "retr_txt_cs";

/**
 * Has the message been seen by the user? The "seen" flag determines
 * whether we need to show a new message notification.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String SEEN = "seen";

/**
 * The {@code status} of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String STATUS = "st";

/**
 * The subject of the message, if present.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String SUBJECT = "sub";

/**
 * The character set of the subject, if present.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String SUBJECT_CHARSET = "sub_cs";

/**
 * The subscription to which the message belongs to. Its value will be
 * < 0 if the sub id cannot be determined.
 * <p>Type: INTEGER (long)</p>
 * @apiSince 22
 */

public static final java.lang.String SUBSCRIPTION_ID = "sub_id";

/**
 * Does the message have only a text part (can also have a subject) with
 * no picture, slideshow, sound, etc. parts?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String TEXT_ONLY = "text_only";

/**
 * The thread ID of the message.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String THREAD_ID = "thread_id";

/**
 * The {@code transaction-id} of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String TRANSACTION_ID = "tr_id";
}

/**
 * Columns for the "canonical_addresses" table used by MMS and SMS.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface CanonicalAddressesColumns extends android.provider.BaseColumns {

/**
 * An address used in MMS or SMS.  Email addresses are
 * converted to lower case and are compared by string
 * equality.  Other addresses are compared using
 * PHONE_NUMBERS_EQUAL.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String ADDRESS = "address";
}

/**
 * Contains carrier identification information for the current subscriptions.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CarrierId implements android.provider.BaseColumns {

private CarrierId() { throw new RuntimeException("Stub!"); }

/**
 * Generates a content {@link android.net.Uri Uri} used to receive updates on carrier identity change
 * on the given subscriptionId
 * <p>
 * Use this {@link android.net.Uri Uri} with a {@link android.database.ContentObserver ContentObserver} to be notified of changes to the
 * carrier identity {@link android.telephony.TelephonyManager#getSimCarrierId() TelephonyManager#getSimCarrierId()}
 * while your app is running. You can also use a {@link android.app.job.JobService}
 * to ensure your app
 * is notified of changes to the {@link android.net.Uri Uri} even when it is not running.
 * Note, however, that using a {@link android.app.job.JobService} does not guarantee
 * timely delivery of updates to the {@link android.net.Uri Uri}.
 *
 * @param subscriptionId the subscriptionId to receive updates on
 * @return the Uri used to observe carrier identity changes
 * @apiSince 28
 */

public static android.net.Uri getUriForSubscriptionId(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Generates a content {@link android.net.Uri Uri} used to receive updates on specific carrier identity
 * change on the given subscriptionId returned by
 * {@link android.telephony.TelephonyManager#getSimSpecificCarrierId() TelephonyManager#getSimSpecificCarrierId()}.
 * @see android.telephony.TelephonyManager#ACTION_SUBSCRIPTION_SPECIFIC_CARRIER_IDENTITY_CHANGED
 * <p>
 * Use this {@link android.net.Uri Uri} with a {@link android.database.ContentObserver ContentObserver} to be notified of changes to the
 * specific carrier identity {@link android.telephony.TelephonyManager#getSimSpecificCarrierId() TelephonyManager#getSimSpecificCarrierId()}
 * while your app is running. You can also use a {@link android.app.job.JobService}
 * to ensure your app
 * is notified of changes to the {@link android.net.Uri Uri} even when it is not running.
 * Note, however, that using a {@link android.app.job.JobService} does not guarantee timely
 * delivery of updates to the {@link android.net.Uri Uri}.
 *
 * @param subscriptionId the subscriptionId to receive updates on
 * @return the Uri used to observe specific carrier identity changes
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.net.Uri getSpecificCarrierIdUriForSubscriptionId(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * A unique carrier id
 * @see android.telephony.TelephonyManager#getSimCarrierId()
 * <P>Type: INTEGER </P>
 * @apiSince 28
 */

public static final java.lang.String CARRIER_ID = "carrier_id";

/**
 * A user facing carrier name.
 * @see android.telephony.TelephonyManager#getSimCarrierIdName()
 * <P>Type: TEXT </P>
 * @apiSince 28
 */

public static final java.lang.String CARRIER_NAME = "carrier_name";

/**
 * The {@code content://} style URI for this provider.
 * @apiSince 28
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * A fine-grained carrier id.
 * The specific carrier ID would be used for configuration purposes, but apps wishing to
 * know about the carrier itself should use the regular carrier ID returned by
 * {@link android.telephony.TelephonyManager#getSimCarrierId() TelephonyManager#getSimCarrierId()}.
 *
 * @see android.telephony.TelephonyManager#getSimSpecificCarrierId()
 * This is not a database column, only used to notify content observers for
 * {@link #getSpecificCarrierIdUriForSubscriptionId(int)}
 * @apiSince 29
 */

public static final java.lang.String SPECIFIC_CARRIER_ID = "specific_carrier_id";

/**
 * A user facing carrier name for specific carrier id {@link #SPECIFIC_CARRIER_ID}.
 * @see android.telephony.TelephonyManager#getSimSpecificCarrierIdName()
 * This is not a database column, only used to notify content observers for
 * {@link #getSpecificCarrierIdUriForSubscriptionId(int)}
 * @apiSince 29
 */

public static final java.lang.String SPECIFIC_CARRIER_ID_NAME = "specific_carrier_id_name";
}

/**
 * Carriers class contains information about APNs, including MMSC information.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Carriers implements android.provider.BaseColumns {

private Carriers() { throw new RuntimeException("Stub!"); }

/**
 * APN name.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String APN = "apn";

/**
 * Authentication type.
 * <P>Type:  INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String AUTH_TYPE = "authtype";

/**
 * Radio Access Technology info.
 * To check what values are allowed, refer to {@link android.telephony.ServiceState}.
 * This should be spread to other technologies,
 * but is currently only used for LTE (14) and eHRPD (13).
 * <P>Type: INTEGER</P>
 * @deprecated this column is no longer supported, use {@link #NETWORK_TYPE_BITMASK} instead
 * @apiSince 19
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String BEARER = "bearer";

/**
 * Is this APN enabled?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String CARRIER_ENABLED = "carrier_enabled";

/**
 * A unique carrier id associated with this APN
 * {@see TelephonyManager#getSimCarrierId()}
 * <p>Type: STRING</p>
 * @apiSince 29
 */

public static final java.lang.String CARRIER_ID = "carrier_id";

/**
 * The {@code content://} style URL for this table.
 * For MSIM, this will return APNs for the default subscription
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}. To specify subId for MSIM,
 * use {@link android.net.Uri#withAppendedPath(android.net.Uri,java.lang.String) Uri#withAppendedPath(Uri, String)} to append with subscription id.
 * @apiSince 19
 */

@androidx.annotation.NonNull public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Is this the current APN?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String CURRENT = "current";

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "name ASC";

/**
 * Mobile Country Code (MCC).
 * <P>Type: TEXT</P>
 * @deprecated Use {@link #SIM_APN_URI} to query APN instead, this API will return
 * matching APNs based on current subscription carrier, thus no need to specify MCC and
 * other carrier matching information. In the future, Android will not support MCC for
 * APN query.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String MCC = "mcc";

/**
 * MMSC URL.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String MMSC = "mmsc";

/**
 * MMS proxy port.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String MMSPORT = "mmsport";

/**
 * MMS proxy address.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String MMSPROXY = "mmsproxy";

/**
 * Mobile Network Code (MNC).
 * <P>Type: TEXT</P>
 * @deprecated Use {@link #SIM_APN_URI} to query APN instead, this API will return
 * matching APNs based on current subscription carrier, thus no need to specify MNC and
 * other carrier matching information. In the future, Android will not support MNC for
 * APN query.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String MNC = "mnc";

/**
 * MVNO data.
 * Use the following examples.
 * <ul>
 *     <li>SPN: A MOBILE, BEN NL, ...</li>
 *     <li>IMSI: 302720x94, 2060188, ...</li>
 *     <li>GID: 4E, 33, ...</li>
 * </ul>
 * <P>Type: TEXT</P>
 * @deprecated Use {@link #SIM_APN_URI} to query APN instead, this API will return
 * matching APNs based on current subscription carrier, thus no need to specify
 * MVNO_MATCH_DATA and other carrier matching information. In the future, Android will not
 * support MVNO_MATCH_DATA for APN query.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String MVNO_MATCH_DATA = "mvno_match_data";

/**
 * MVNO type:
 * {@code SPN (Service Provider Name), IMSI, GID (Group Identifier Level 1)}.
 * <P>Type: TEXT</P>
 * @deprecated Use {@link #SIM_APN_URI} to query APN instead, this API will return
 * matching APNs based on current subscription carrier, thus no need to specify MVNO_TYPE
 * and other carrier matching information. In the future, Android will not support MVNO_TYPE
 * for APN query.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String MVNO_TYPE = "mvno_type";

/**
 * Entry name.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String NAME = "name";

/**
 * Radio technology (network type) bitmask.
 * To check what values can be contained, refer to the NETWORK_TYPE_ constants in
 * {@link android.telephony.TelephonyManager}.
 * Bitmask for a radio tech R is (1 << (R - 1))
 * <P>Type: INTEGER</P>
 * @apiSince 28
 */

public static final java.lang.String NETWORK_TYPE_BITMASK = "network_type_bitmask";

/**
 * Numeric operator ID (as String). Usually {@code MCC + MNC}.
 * <P>Type: TEXT</P>
 * @deprecated Use {@link #SIM_APN_URI} to query APN instead, this API will return
 * matching APNs based on current subscription carrier, thus no need to specify Numeric
 * and other carrier matching information. In the future, Android will not support Numeric
 * for APN query.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String NUMERIC = "numeric";

/**
 * APN password.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String PASSWORD = "password";

/**
 * Proxy port.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String PORT = "port";

/**
 * The protocol to use to connect to this APN.
 *
 * One of the {@code PDP_type} values in TS 27.007 section 10.1.1.
 * For example: {@code IP}, {@code IPV6}, {@code IPV4V6}, or {@code PPP}.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String PROTOCOL = "protocol";

/**
 * Proxy address.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String PROXY = "proxy";

/**
 * The protocol to use to connect to this APN when roaming.
 * The syntax is the same as protocol.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String ROAMING_PROTOCOL = "roaming_protocol";

/**
 * Server address.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String SERVER = "server";

/**
 * The {@code content://} style URL for this table. Used for APN query based on current
 * subscription. Instead of specifying carrier matching information in the selection,
 * this API will return all matching APNs from current subscription carrier and queries
 * will be applied on top of that. If there is no match for MVNO (Mobile Virtual Network
 * Operator) APNs, return APNs from its MNO (based on mccmnc) instead. For MSIM, this will
 * return APNs for the default subscription
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}. To specify subId for MSIM,
 * use {@link android.net.Uri#withAppendedPath(android.net.Uri,java.lang.String) Uri#withAppendedPath(Uri, String)} to append with subscription id.
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri SIM_APN_URI;
static { SIM_APN_URI = null; }

/**
 * The subscription to which the APN belongs to
 * <p>Type: INTEGER (long) </p>
 * @apiSince 22
 */

public static final java.lang.String SUBSCRIPTION_ID = "sub_id";

/**
 * Comma-delimited list of APN types.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String TYPE = "type";

/**
 * APN username.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String USER = "user";
}

/**
 * Contains all MMS messages.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Mms implements android.provider.Telephony.BaseMmsColumns {

private Mms() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} URI for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";

/**
 * Content URI for getting MMS report requests.
 * @apiSince 19
 */

public static final android.net.Uri REPORT_REQUEST_URI;
static { REPORT_REQUEST_URI = null; }

/**
 * Content URI for getting MMS report status.
 * @apiSince 19
 */

public static final android.net.Uri REPORT_STATUS_URI;
static { REPORT_STATUS_URI = null; }
/**
 * Contains address information for an MMS message.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Addr implements android.provider.BaseColumns {

private Addr() { throw new RuntimeException("Stub!"); }

/**
 * Generates a Addr {@link android.net.Uri Uri} for message, used to perform Addr table operation
 * for mms.
 *
 * @param messageId the messageId used to generate Addr {@link android.net.Uri Uri} dynamically
 * This value must never be {@code null}.
 * @return the addrUri used to perform Addr table operation for mms
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public static android.net.Uri getAddrUriForMessage(@androidx.annotation.NonNull java.lang.String messageId) { throw new RuntimeException("Stub!"); }

/**
 * The address text.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String ADDRESS = "address";

/**
 * Character set of this entry (MMS charset value).
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String CHARSET = "charset";

/**
 * The ID of contact entry in Phone Book.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String CONTACT_ID = "contact_id";

/**
 * The ID of MM which this address entry belongs to.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String MSG_ID = "msg_id";

/**
 * Type of address: must be one of {@code PduHeaders.BCC},
 * {@code PduHeaders.CC}, {@code PduHeaders.FROM}, {@code PduHeaders.TO}.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String TYPE = "type";
}

/**
 * Contains all MMS messages in the MMS app drafts folder.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Draft implements android.provider.Telephony.BaseMmsColumns {

private Draft() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

/**
 * Contains all MMS messages in the MMS app inbox.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Inbox implements android.provider.Telephony.BaseMmsColumns {

private Inbox() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

/**
 * Intents class.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Intents {

private Intents() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the contents of specified URIs were changed.
 * The application which is showing or caching these contents
 * should be updated.
 * @apiSince 19
 */

public static final java.lang.String CONTENT_CHANGED_ACTION = "android.intent.action.CONTENT_CHANGED";

/**
 * An extra field which stores the URI of deleted contents.
 * @apiSince 19
 */

public static final java.lang.String DELETED_CONTENTS = "deleted_contents";
}

/**
 * Contains all MMS messages in the MMS app outbox.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Outbox implements android.provider.Telephony.BaseMmsColumns {

private Outbox() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

/**
 * Contains message parts.
 *
 * To avoid issues where applications might cache a part ID, the ID of a deleted part must
 * not be reused to point at a new part.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Part implements android.provider.BaseColumns {

private Part() { throw new RuntimeException("Stub!"); }

/**
 * Generates a Part {@link android.net.Uri Uri} for message, used to perform Part table operation
 * for mms.
 *
 * @param messageId the messageId used to generate Part {@link android.net.Uri Uri} dynamically
 * This value must never be {@code null}.
 * @return the partUri used to perform Part table operation for mms
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public static android.net.Uri getPartUriForMessage(@androidx.annotation.NonNull java.lang.String messageId) { throw new RuntimeException("Stub!"); }

/**
 * The charset of the part.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String CHARSET = "chset";

/**
 * The content disposition of the part.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String CONTENT_DISPOSITION = "cd";

/**
 * The content ID of the part.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String CONTENT_ID = "cid";

/**
 * The content location of the part.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String CONTENT_LOCATION = "cl";

/**
 * The content type of the part.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String CONTENT_TYPE = "ct";

/**
 * The {@code content://} style URL for this table. Can be appended with a part ID to
 * address individual parts.
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The start of content-type of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String CT_START = "ctt_s";

/**
 * The type of content-type of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String CT_TYPE = "ctt_t";

/**
 * The file name of the part.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String FILENAME = "fn";

/**
 * The identifier of the message which this part belongs to.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MSG_ID = "mid";

/**
 * The name of the part.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String NAME = "name";

/**
 * The order of the part.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String SEQ = "seq";

/**
 * The message text.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String TEXT = "text";

/**
 * The location (on filesystem) of the binary data of the part.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String _DATA = "_data";
}

/**
 * Message send rate table.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Rate {

private Rate() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * When a message was successfully sent.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String SENT_TIME = "sent_time";
}

/**
 * Contains all MMS messages in the MMS app sent folder.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Sent implements android.provider.Telephony.BaseMmsColumns {

private Sent() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

}

/**
 * Contains all MMS and SMS messages.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MmsSms implements android.provider.BaseColumns {

private MmsSms() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table, by conversation.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_CONVERSATIONS_URI;
static { CONTENT_CONVERSATIONS_URI = null; }

/**
 * The {@code content://} style URL for draft messages in this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_DRAFT_URI;
static { CONTENT_DRAFT_URI = null; }

/**
 * The {@code content://} style URL for this table, by phone number.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_FILTER_BYPHONE_URI;
static { CONTENT_FILTER_BYPHONE_URI = null; }

/**
 * The {@code content://} style URL for locked messages in this table.
 * <P>This {@link android.net.Uri Uri} is used to check at most one locked message found in the union of MMS
 * and SMS messages. Also this will return only _id column in response.</P>
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_LOCKED_URI;
static { CONTENT_LOCKED_URI = null; }

/**
 * The {@code content://} style URL for undelivered messages in this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_UNDELIVERED_URI;
static { CONTENT_UNDELIVERED_URI = null; }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Error type: generic transient error.
 * @apiSince 19
 */

public static final int ERR_TYPE_GENERIC = 1; // 0x1

/**
 * Error type: permanent error (along with all higher error values).
 * @apiSince 19
 */

public static final int ERR_TYPE_GENERIC_PERMANENT = 10; // 0xa

/**
 * Error type: MMS protocol permanent error.
 * @apiSince 19
 */

public static final int ERR_TYPE_MMS_PROTO_PERMANENT = 12; // 0xc

/**
 * Error type: MMS protocol transient error.
 * @apiSince 19
 */

public static final int ERR_TYPE_MMS_PROTO_TRANSIENT = 3; // 0x3

/**
 * Error type: SMS protocol permanent error.
 * @apiSince 19
 */

public static final int ERR_TYPE_SMS_PROTO_PERMANENT = 11; // 0xb

/**
 * Error type: SMS protocol transient error.
 * @apiSince 19
 */

public static final int ERR_TYPE_SMS_PROTO_TRANSIENT = 2; // 0x2

/**
 * Error type: transport failure.
 * @apiSince 19
 */

public static final int ERR_TYPE_TRANSPORT_FAILURE = 4; // 0x4

/**
 * MMS protocol type.
 * @apiSince 19
 */

public static final int MMS_PROTO = 1; // 0x1

/**
 * Error type: no error.
 * @apiSince 19
 */

public static final int NO_ERROR = 0; // 0x0

/**
 * Pass in a query parameter called "pattern" which is the text to search for.
 * The sort order is fixed to be: {@code thread_id ASC, date DESC}.
 * @apiSince 19
 */

public static final android.net.Uri SEARCH_URI;
static { SEARCH_URI = null; }

/**
 * SMS protocol type.
 * @apiSince 19
 */

public static final int SMS_PROTO = 0; // 0x0

/**
 * The column to distinguish SMS and MMS messages in query results.
 * @apiSince 19
 */

public static final java.lang.String TYPE_DISCRIMINATOR_COLUMN = "transport_type";
/**
 * Contains pending messages info.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PendingMessages implements android.provider.BaseColumns {

private PendingMessages() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The time to do next retry.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String DUE_TIME = "due_time";

/**
 * The error code of sending/retrieving process.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String ERROR_CODE = "err_code";

/**
 * The type of the error code.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String ERROR_TYPE = "err_type";

/**
 * The time we last tried to send or download the message.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String LAST_TRY = "last_try";

/**
 * The ID of the message to be sent or downloaded.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String MSG_ID = "msg_id";

/**
 * The type of the message to be sent or downloaded.
 * This field is only valid for MM. For SM, its value is always set to 0.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MSG_TYPE = "msg_type";

/**
 * The type of transport protocol (MMS or SMS).
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String PROTO_TYPE = "proto_type";

/**
 * How many times we tried to send or download the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String RETRY_INDEX = "retry_index";

/**
 * The subscription to which the message belongs to. Its value will be
 * < 0 if the sub id cannot be determined.
 * <p>Type: INTEGER (long) </p>
 * @apiSince 22
 */

public static final java.lang.String SUBSCRIPTION_ID = "pending_sub_id";
}

}

/**
 * Constants for interfacing with the ServiceStateProvider and the different fields of the
 * {@link android.telephony.ServiceState ServiceState} class accessible through the provider.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ServiceStateTable {

private ServiceStateTable() { throw new RuntimeException("Stub!"); }

/**
 * Generates a content {@link android.net.Uri Uri} used to receive updates on a specific field in the
 * ServiceState provider.
 * <p>
 * Use this {@link android.net.Uri Uri} with a {@link android.database.ContentObserver ContentObserver} to be notified of changes to the
 * {@link android.telephony.ServiceState ServiceState} while your app is running.
 * You can also use a {@link android.app.job.JobService} to
 * ensure your app is notified of changes to the {@link android.net.Uri Uri} even when it is not running.
 * Note, however, that using a {@link android.app.job.JobService}
 * does not guarantee timely delivery of
 * updates to the {@link android.net.Uri Uri}.
 *
 * @param subscriptionId the subscriptionId to receive updates on
 * @param field the ServiceState field to receive updates on
 * @return the Uri used to observe {@link android.telephony.ServiceState ServiceState} changes
 * @apiSince 26
 */

public static android.net.Uri getUriForSubscriptionIdAndField(int subscriptionId, java.lang.String field) { throw new RuntimeException("Stub!"); }

/**
 * Generates a content {@link android.net.Uri Uri} used to receive updates on every field in the
 * ServiceState provider.
 * <p>
 * Use this {@link android.net.Uri Uri} with a {@link android.database.ContentObserver ContentObserver} to be notified of changes to the
 * {@link android.telephony.ServiceState ServiceState} while your app is running.  You can also use a
 * {@link android.app.job.JobService} to
 * ensure your app is notified of changes to the {@link android.net.Uri Uri} even when it is not running.
 * Note, however, that using a {@link android.app.job.JobService}
 * does not guarantee timely delivery of
 * updates to the {@link android.net.Uri Uri}.
 *
 * @param subscriptionId the subscriptionId to receive updates on
 * @return the Uri used to observe {@link android.telephony.ServiceState ServiceState} changes
 * @apiSince 26
 */

public static android.net.Uri getUriForSubscriptionId(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * The authority string for the ServiceStateProvider
 * @apiSince 26
 */

public static final java.lang.String AUTHORITY = "service-state";

/**
 * The {@code content://} style URL for the ServiceStateProvider
 * @apiSince 26
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The current network selection mode.
 * <p>
 * This is the same as {@link android.telephony.ServiceState#getIsManualSelection() ServiceState#getIsManualSelection()}.
 * @apiSince 26
 */

public static final java.lang.String IS_MANUAL_NETWORK_SELECTION = "is_manual_network_selection";

/**
 * The current registered operator numeric id.
 * <p>
 * In GSM/UMTS, numeric format is 3 digit country code plus 2 or 3 digit
 * network code.
 * <p>
 * This is the same as {@link android.telephony.ServiceState#getOperatorNumeric() ServiceState#getOperatorNumeric()}.
 * @apiSince 26
 */

public static final java.lang.String VOICE_OPERATOR_NUMERIC = "voice_operator_numeric";

/**
 * An integer value indicating the current voice service state.
 * <p>
 * Valid values: {@link android.telephony.ServiceState#STATE_IN_SERVICE ServiceState#STATE_IN_SERVICE},
 * {@link android.telephony.ServiceState#STATE_OUT_OF_SERVICE ServiceState#STATE_OUT_OF_SERVICE}, {@link android.telephony.ServiceState#STATE_EMERGENCY_ONLY ServiceState#STATE_EMERGENCY_ONLY},
 * {@link android.telephony.ServiceState#STATE_POWER_OFF ServiceState#STATE_POWER_OFF}.
 * <p>
 * This is the same as {@link android.telephony.ServiceState#getState() ServiceState#getState()}.
 * @apiSince 26
 */

public static final java.lang.String VOICE_REG_STATE = "voice_reg_state";
}

/**
 * Contains all text-based SMS messages.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Sms implements android.provider.BaseColumns, android.provider.Telephony.TextBasedSmsColumns {

private Sms() { throw new RuntimeException("Stub!"); }

/**
 * Used to determine the currently configured default SMS package.
 * @param context context of the requesting application
 * @return package name for the default SMS package or null
 * @apiSince 19
 */

public static java.lang.String getDefaultSmsPackage(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
/**
 * Contains a view of SMS conversations (also referred to as threads). This is similar to
 * {@link android.provider.Telephony.Threads Threads}, but only includes SMS messages and columns relevant to SMS
 * conversations.
 * <p>
 * Note that this view ignores any information about MMS messages, it is a
 * view of conversations as if MMS messages did not exist at all. This means that all
 * relevant information, such as snippets and message count, will ignore any MMS messages
 * that might be in the same thread through other views and present only data based on the
 * SMS messages in that thread.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Conversations implements android.provider.BaseColumns, android.provider.Telephony.TextBasedSmsColumns {

private Conversations() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";

/**
 * The number of messages in the conversation.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MESSAGE_COUNT = "msg_count";

/**
 * The first 45 characters of the body of the most recent message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String SNIPPET = "snippet";
}

/**
 * Contains all draft text-based SMS messages in the SMS app.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Draft implements android.provider.BaseColumns, android.provider.Telephony.TextBasedSmsColumns {

private Draft() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

/**
 * Contains all text-based SMS messages in the SMS app inbox.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Inbox implements android.provider.BaseColumns, android.provider.Telephony.TextBasedSmsColumns {

private Inbox() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

/**
 * Contains constants for SMS related Intents that are broadcast.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Intents {

private Intents() { throw new RuntimeException("Stub!"); }

/**
 * Read the PDUs out of an {@link #SMS_RECEIVED_ACTION} or a
 * {@link #DATA_SMS_RECEIVED_ACTION} intent.
 *
 * @param intent the intent to read from
 * @return an array of SmsMessages for the PDUs
 * @apiSince 19
 */

public static android.telephony.SmsMessage[] getMessagesFromIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Activity action: Ask the user to change the default
 * SMS application. This will show a dialog that asks the
 * user whether they want to replace the current default
 * SMS application with the one specified in
 * {@link #EXTRA_PACKAGE_NAME}.
 * <p>
 * This is no longer supported since Q, please use
 * {@link android.app.role.RoleManager#createRequestRoleIntent(String)} with
 * {@link android.app.role.RoleManager#ROLE_SMS} instead.
 * @apiSince 19
 */

public static final java.lang.String ACTION_CHANGE_DEFAULT = "android.provider.Telephony.ACTION_CHANGE_DEFAULT";

/**
 * Broadcast action: When the default SMS package changes,
 * the previous default SMS package and the new default SMS
 * package are sent this broadcast to notify them of the change.
 * A boolean is specified in {@link #EXTRA_IS_DEFAULT_SMS_APP} to
 * indicate whether the package is the new default SMS package.
 * @apiSince 24
 */

public static final java.lang.String ACTION_DEFAULT_SMS_PACKAGE_CHANGED = "android.provider.action.DEFAULT_SMS_PACKAGE_CHANGED";

/**
 * Broadcast action: When a change is made to the SmsProvider or
 * MmsProvider by a process other than the default SMS application,
 * this intent is broadcast to the default SMS application so it can
 * re-sync or update the change. The uri that was used to call the provider
 * can be retrieved from the intent with getData(). The actual affected uris
 * (which would depend on the selection specified) are not included.
 * @apiSince 24
 */

public static final java.lang.String ACTION_EXTERNAL_PROVIDER_CHANGE = "android.provider.action.EXTERNAL_PROVIDER_CHANGE";

/**
 * Broadcast Action: A new data based SMS message has been received
 * by the device. This intent will be delivered to all registered
 * receivers as a notification. The intent will have the following extra
 * values:</p>
 *
 * <ul>
 *   <li><em>"pdus"</em> - An Object[] of byte[]s containing the PDUs
 *   that make up the message.</li>
 * </ul>
 *
 * <p>The extra values can be extracted using
 * {@link #getMessagesFromIntent(android.content.Intent)}.</p>
 *
 * <p>If a BroadcastReceiver encounters an error while processing
 * this intent it should set the result code appropriately.</p>
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_SMS} to receive.</p>
 * @apiSince 19
 */

public static final java.lang.String DATA_SMS_RECEIVED_ACTION = "android.intent.action.DATA_SMS_RECEIVED";

/**
 * The IsDefaultSmsApp boolean passed as an
 * extra for {@link #ACTION_DEFAULT_SMS_PACKAGE_CHANGED} to indicate whether the
 * SMS app is becoming the default SMS app or is no longer the default.
 *
 * @see #ACTION_DEFAULT_SMS_PACKAGE_CHANGED
 * @apiSince 24
 */

public static final java.lang.String EXTRA_IS_DEFAULT_SMS_APP = "android.provider.extra.IS_DEFAULT_SMS_APP";

/**
 * The PackageName string passed in as an
 * extra for {@link #ACTION_CHANGE_DEFAULT}
 *
 * @see #ACTION_CHANGE_DEFAULT
 * <p>
 * This is no longer supported since Q, please use
 * {@link android.app.role.RoleManager#createRequestRoleIntent(String)} with
 * {@link android.app.role.RoleManager#ROLE_SMS} instead.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PACKAGE_NAME = "package";

/**
 * Set by BroadcastReceiver to indicate a duplicate incoming message.
 * @apiSince 19
 */

public static final int RESULT_SMS_DUPLICATED = 5; // 0x5

/**
 * Set by BroadcastReceiver to indicate a generic error while
 * processing the message.
 * @apiSince 19
 */

public static final int RESULT_SMS_GENERIC_ERROR = 2; // 0x2

/**
 * Set by BroadcastReceiver to indicate that the message was handled
 * successfully.
 * @apiSince 19
 */

public static final int RESULT_SMS_HANDLED = 1; // 0x1

/**
 * Set by BroadcastReceiver to indicate insufficient memory to store
 * the message.
 * @apiSince 19
 */

public static final int RESULT_SMS_OUT_OF_MEMORY = 3; // 0x3

/**
 * Set by BroadcastReceiver to indicate that the message, while
 * possibly valid, is of a format or encoding that is not
 * supported.
 * @apiSince 19
 */

public static final int RESULT_SMS_UNSUPPORTED = 4; // 0x4

/**
 * Broadcast Action: A debug code has been entered in the dialer. This intent is
 * broadcast by the system and OEM telephony apps may need to receive these broadcasts.
 * These "secret codes" are used to activate developer menus by dialing certain codes.
 * And they are of the form {@code *#*#<code>#*#*}. The intent will have the data
 * URI: {@code android_secret_code://<code>}. It is possible that a manifest
 * receiver would be woken up even if it is not currently running.
 *
 * <p>Requires {@code android.Manifest.permission#CONTROL_INCALL_EXPERIENCE} to
 * send and receive.</p>
 * @deprecated it is no longer supported, use {@link android.telephony.TelephonyManager#ACTION_SECRET_CODE TelephonyManager#ACTION_SECRET_CODE} instead
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String SECRET_CODE_ACTION = "android.provider.Telephony.SECRET_CODE";

/**
 * Broadcast Action: The SIM storage for SMS messages is full.  If
 * space is not freed, messages targeted for the SIM (class 2) may
 * not be saved.
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_SMS} to receive.</p>
 * @apiSince 19
 */

public static final java.lang.String SIM_FULL_ACTION = "android.provider.Telephony.SIM_FULL";

/**
 * Broadcast Action: A new Cell Broadcast message has been received
 * by the device. The intent will have the following extra
 * values:</p>
 *
 * <ul>
 *   <li><em>"message"</em> - An SmsCbMessage object containing the broadcast message
 *   data. This is not an emergency alert, so ETWS and CMAS data will be null.</li>
 * </ul>
 *
 * <p>The extra values can be extracted using
 * {@link #getMessagesFromIntent(android.content.Intent)}.</p>
 *
 * <p>If a BroadcastReceiver encounters an error while processing
 * this intent it should set the result code appropriately.</p>
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_SMS} to receive.</p>
 * @apiSince 19
 */

public static final java.lang.String SMS_CB_RECEIVED_ACTION = "android.provider.Telephony.SMS_CB_RECEIVED";

/**
 * Broadcast Action: A new text-based SMS message has been received
 * by the device. This intent will only be delivered to the default
 * sms app. That app is responsible for writing the message and notifying
 * the user. The intent will have the following extra values:</p>
 *
 * <ul>
 *   <li><em>"pdus"</em> - An Object[] of byte[]s containing the PDUs
 *   that make up the message.</li>
 *   <li><em>"format"</em> - A String describing the format of the PDUs. It can
 *   be either "3gpp" or "3gpp2".</li>
 *   <li><em>"subscription"</em> - An optional long value of the subscription id which
 *   received the message.</li>
 *   <li><em>"slot"</em> - An optional int value of the SIM slot containing the
 *   subscription.</li>
 *   <li><em>"phone"</em> - An optional int value of the phone id associated with the
 *   subscription.</li>
 *   <li><em>"errorCode"</em> - An optional int error code associated with receiving
 *   the message.</li>
 * </ul>
 *
 * <p>The extra values can be extracted using
 * {@link #getMessagesFromIntent(android.content.Intent)}.</p>
 *
 * <p>If a BroadcastReceiver encounters an error while processing
 * this intent it should set the result code appropriately.</p>
 *
 * <p class="note"><strong>Note:</strong>
 * The broadcast receiver that filters for this intent must declare
 * {@link android.Manifest.permission#BROADCAST_SMS} as a required permission in
 * the <a href="{@docRoot}guide/topics/manifest/receiver-element.html">{@code
 * <receiver>}</a> tag.
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_SMS} to receive.</p>
 * @apiSince 19
 */

public static final java.lang.String SMS_DELIVER_ACTION = "android.provider.Telephony.SMS_DELIVER";

/**
 * Broadcast Action: A new text-based SMS message has been received
 * by the device. This intent will be delivered to all registered
 * receivers as a notification. These apps are not expected to write the
 * message or notify the user. The intent will have the following extra
 * values:</p>
 *
 * <ul>
 *   <li><em>"pdus"</em> - An Object[] of byte[]s containing the PDUs
 *   that make up the message.</li>
 * </ul>
 *
 * <p>The extra values can be extracted using
 * {@link #getMessagesFromIntent(android.content.Intent)}.</p>
 *
 * <p>If a BroadcastReceiver encounters an error while processing
 * this intent it should set the result code appropriately.</p>
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_SMS} to receive.</p>
 * @apiSince 19
 */

public static final java.lang.String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";

/**
 * Broadcast Action: An incoming SMS has been rejected by the
 * telephony framework.  This intent is sent in lieu of any
 * of the RECEIVED_ACTION intents.  The intent will have the
 * following extra value:</p>
 *
 * <ul>
 *   <li><em>"result"</em> - An int result code, e.g. {@link #RESULT_SMS_OUT_OF_MEMORY}
 *   indicating the error returned to the network.</li>
 * </ul>
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_SMS} to receive.</p>
 * @apiSince 19
 */

public static final java.lang.String SMS_REJECTED_ACTION = "android.provider.Telephony.SMS_REJECTED";

/**
 * Broadcast Action: A new CDMA SMS has been received containing Service Category
 * Program Data (updates the list of enabled broadcast channels). The intent will
 * have the following extra values:</p>
 *
 * <ul>
 *   <li><em>"operations"</em> - An array of CdmaSmsCbProgramData objects containing
 *   the service category operations (add/delete/clear) to perform.</li>
 * </ul>
 *
 * <p>The extra values can be extracted using
 * {@link #getMessagesFromIntent(android.content.Intent)}.</p>
 *
 * <p>If a BroadcastReceiver encounters an error while processing
 * this intent it should set the result code appropriately.</p>
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_SMS} to receive.</p>
 * @apiSince 19
 */

public static final java.lang.String SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED_ACTION = "android.provider.Telephony.SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED";

/**
 * Broadcast Action: A new WAP PUSH message has been received by the
 * device. This intent will only be delivered to the default
 * sms app. That app is responsible for writing the message and notifying
 * the user. The intent will have the following extra values:</p>
 *
 * <ul>
 *   <li><em>"transactionId"</em> - (Integer) The WAP transaction ID</li>
 *   <li><em>"pduType"</em> - (Integer) The WAP PDU type</li>
 *   <li><em>"header"</em> - (byte[]) The header of the message</li>
 *   <li><em>"data"</em> - (byte[]) The data payload of the message</li>
 *   <li><em>"contentTypeParameters" </em>
 *   -(HashMap&lt;String,String&gt;) Any parameters associated with the content type
 *   (decoded from the WSP Content-Type header)</li>
 *   <li><em>"subscription"</em> - An optional long value of the subscription id which
 *   received the message.</li>
 *   <li><em>"slot"</em> - An optional int value of the SIM slot containing the
 *   subscription.</li>
 *   <li><em>"phone"</em> - An optional int value of the phone id associated with the
 *   subscription.</li>
 * </ul>
 *
 * <p>If a BroadcastReceiver encounters an error while processing
 * this intent it should set the result code appropriately.</p>
 *
 * <p>The contentTypeParameters extra value is map of content parameters keyed by
 * their names.</p>
 *
 * <p>If any unassigned well-known parameters are encountered, the key of the map will
 * be 'unassigned/0x...', where '...' is the hex value of the unassigned parameter.  If
 * a parameter has No-Value the value in the map will be null.</p>
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_MMS} or
 * {@link android.Manifest.permission#RECEIVE_WAP_PUSH} (depending on WAP PUSH type) to
 * receive.</p>
 *
 * <p class="note"><strong>Note:</strong>
 * The broadcast receiver that filters for this intent must declare
 * {@link android.Manifest.permission#BROADCAST_WAP_PUSH} as a required permission in
 * the <a href="{@docRoot}guide/topics/manifest/receiver-element.html">{@code
 * <receiver>}</a> tag.
 * @apiSince 19
 */

public static final java.lang.String WAP_PUSH_DELIVER_ACTION = "android.provider.Telephony.WAP_PUSH_DELIVER";

/**
 * Broadcast Action: A new WAP PUSH message has been received by the
 * device. This intent will be delivered to all registered
 * receivers as a notification. These apps are not expected to write the
 * message or notify the user. The intent will have the following extra
 * values:</p>
 *
 * <ul>
 *   <li><em>"transactionId"</em> - (Integer) The WAP transaction ID</li>
 *   <li><em>"pduType"</em> - (Integer) The WAP PDU type</li>
 *   <li><em>"header"</em> - (byte[]) The header of the message</li>
 *   <li><em>"data"</em> - (byte[]) The data payload of the message</li>
 *   <li><em>"contentTypeParameters"</em>
 *   - (HashMap&lt;String,String&gt;) Any parameters associated with the content type
 *   (decoded from the WSP Content-Type header)</li>
 * </ul>
 *
 * <p>If a BroadcastReceiver encounters an error while processing
 * this intent it should set the result code appropriately.</p>
 *
 * <p>The contentTypeParameters extra value is map of content parameters keyed by
 * their names.</p>
 *
 * <p>If any unassigned well-known parameters are encountered, the key of the map will
 * be 'unassigned/0x...', where '...' is the hex value of the unassigned parameter.  If
 * a parameter has No-Value the value in the map will be null.</p>
 *
 * <p>Requires {@link android.Manifest.permission#RECEIVE_MMS} or
 * {@link android.Manifest.permission#RECEIVE_WAP_PUSH} (depending on WAP PUSH type) to
 * receive.</p>
 * @apiSince 19
 */

public static final java.lang.String WAP_PUSH_RECEIVED_ACTION = "android.provider.Telephony.WAP_PUSH_RECEIVED";
}

/**
 * Contains all pending outgoing text-based SMS messages.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Outbox implements android.provider.BaseColumns, android.provider.Telephony.TextBasedSmsColumns {

private Outbox() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

/**
 * Contains all sent text-based SMS messages in the SMS app.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Sent implements android.provider.BaseColumns, android.provider.Telephony.TextBasedSmsColumns {

private Sent() { throw new RuntimeException("Stub!"); }

/**
 * The {@code content://} style URL for this table.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table.
 * @apiSince 19
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "date DESC";
}

}

/**
 * Base columns for tables that contain text-based SMSs.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TextBasedSmsColumns {

/**
 * The address of the other party.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String ADDRESS = "address";

/**
 * The body of the message.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String BODY = "body";

/**
 * The identity of the sender of a sent message. It is
 * usually the package name of the app which sends the message.
 * <p class="note"><strong>Note:</strong>
 * This column is read-only. It is set by the provider and can not be changed by apps.
 * <p>Type: TEXT</p>
 * @apiSince 21
 */

public static final java.lang.String CREATOR = "creator";

/**
 * The date the message was received.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String DATE = "date";

/**
 * The date the message was sent.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String DATE_SENT = "date_sent";

/**
 * Error code associated with sending or receiving this message
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String ERROR_CODE = "error_code";

/**
 * Is the message locked?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String LOCKED = "locked";

/**
 * Message type: all messages.
 * @apiSince 19
 */

public static final int MESSAGE_TYPE_ALL = 0; // 0x0

/**
 * Message type: drafts.
 * @apiSince 19
 */

public static final int MESSAGE_TYPE_DRAFT = 3; // 0x3

/**
 * Message type: failed outgoing message.
 * @apiSince 19
 */

public static final int MESSAGE_TYPE_FAILED = 5; // 0x5

/**
 * Message type: inbox.
 * @apiSince 19
 */

public static final int MESSAGE_TYPE_INBOX = 1; // 0x1

/**
 * Message type: outbox.
 * @apiSince 19
 */

public static final int MESSAGE_TYPE_OUTBOX = 4; // 0x4

/**
 * Message type: queued to send later.
 * @apiSince 19
 */

public static final int MESSAGE_TYPE_QUEUED = 6; // 0x6

/**
 * Message type: sent messages.
 * @apiSince 19
 */

public static final int MESSAGE_TYPE_SENT = 2; // 0x2

/**
 * The ID of the sender of the conversation, if present.
 * <P>Type: INTEGER (reference to item in {@code content://contacts/people})</P>
 * @apiSince 19
 */

public static final java.lang.String PERSON = "person";

/**
 * The protocol identifier code.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String PROTOCOL = "protocol";

/**
 * Has the message been read?
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String READ = "read";

/**
 * Is the {@code TP-Reply-Path} flag set?
 * <P>Type: BOOLEAN</P>
 * @apiSince 19
 */

public static final java.lang.String REPLY_PATH_PRESENT = "reply_path_present";

/**
 * Has the message been seen by the user? The "seen" flag determines
 * whether we need to show a notification.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 19
 */

public static final java.lang.String SEEN = "seen";

/**
 * The service center (SC) through which to send the message, if present.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String SERVICE_CENTER = "service_center";

/**
 * {@code TP-Status} value for the message, or -1 if no status has been received.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String STATUS = "status";

/**
 * TP-Status: complete.
 * @apiSince 19
 */

public static final int STATUS_COMPLETE = 0; // 0x0

/**
 * TP-Status: failed.
 * @apiSince 19
 */

public static final int STATUS_FAILED = 64; // 0x40

/**
 * TP-Status: no status received.
 * @apiSince 19
 */

public static final int STATUS_NONE = -1; // 0xffffffff

/**
 * TP-Status: pending.
 * @apiSince 19
 */

public static final int STATUS_PENDING = 32; // 0x20

/**
 * The subject of the message, if present.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String SUBJECT = "subject";

/**
 * The subscription to which the message belongs to. Its value will be
 * < 0 if the sub id cannot be determined.
 * <p>Type: INTEGER (long) </p>
 * @apiSince 22
 */

public static final java.lang.String SUBSCRIPTION_ID = "sub_id";

/**
 * The thread ID of the message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String THREAD_ID = "thread_id";

/**
 * The type of message.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String TYPE = "type";
}

/**
 * Helper functions for the "threads" table used by MMS and SMS.
 *
 * Thread IDs are determined by the participants in a conversation and can be used to match
 * both SMS and MMS messages.
 *
 * To avoid issues where applications might cache a thread ID, the thread ID of a deleted thread
 * must not be reused to point at a new thread.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Threads implements android.provider.Telephony.ThreadsColumns {

private Threads() { throw new RuntimeException("Stub!"); }

/**
 * This is a single-recipient version of {@code getOrCreateThreadId}.
 * It's convenient for use with SMS messages.
 * @param context the context object to use.
 * @param recipient the recipient to send to.
 * @apiSince 23
 */

public static long getOrCreateThreadId(android.content.Context context, java.lang.String recipient) { throw new RuntimeException("Stub!"); }

/**
 * Given a set of recipients return its thread ID.
 * <p>
 * If a thread exists containing the provided participants, return its thread ID. Otherwise,
 * this will create a new thread containing the provided participants and return its ID.
 * @apiSince 23
 */

public static long getOrCreateThreadId(android.content.Context context, java.util.Set<java.lang.String> recipients) { throw new RuntimeException("Stub!"); }

/**
 * Thread type: broadcast thread.
 * @apiSince 19
 */

public static final int BROADCAST_THREAD = 1; // 0x1

/**
 * Thread type: common thread.
 * @apiSince 19
 */

public static final int COMMON_THREAD = 0; // 0x0

/**
 * The {@code content://} style URL for this table, by conversation.
 * @apiSince 19
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The {@code content://} style URL for this table, for obsolete threads.
 * @apiSince 19
 */

public static final android.net.Uri OBSOLETE_THREADS_URI;
static { OBSOLETE_THREADS_URI = null; }
}

/**
 * Columns for the "threads" table used by MMS and SMS.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ThreadsColumns extends android.provider.BaseColumns {

/**
 * If the thread is archived
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 21
 */

public static final java.lang.String ARCHIVED = "archived";

/**
 * The date at which the thread was created.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 19
 */

public static final java.lang.String DATE = "date";

/**
 * Indicates whether there is a transmission error in the thread.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String ERROR = "error";

/**
 * Indicates whether this thread contains any attachments.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String HAS_ATTACHMENT = "has_attachment";

/**
 * The message count of the thread.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String MESSAGE_COUNT = "message_count";

/**
 * Indicates whether all messages of the thread have been read.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String READ = "read";

/**
 * A string encoding of the recipient IDs of the recipients of
 * the message, in numerical order and separated by spaces.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String RECIPIENT_IDS = "recipient_ids";

/**
 * The snippet of the latest message in the thread.
 * <P>Type: TEXT</P>
 * @apiSince 19
 */

public static final java.lang.String SNIPPET = "snippet";

/**
 * The charset of the snippet.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String SNIPPET_CHARSET = "snippet_cs";

/**
 * Type of the thread, either {@link android.provider.Telephony.Threads#COMMON_THREAD Threads#COMMON_THREAD} or
 * {@link android.provider.Telephony.Threads#BROADCAST_THREAD Threads#BROADCAST_THREAD}.
 * <P>Type: INTEGER</P>
 * @apiSince 19
 */

public static final java.lang.String TYPE = "type";
}

}

