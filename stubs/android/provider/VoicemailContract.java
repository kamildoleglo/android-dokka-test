/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * limitations under the License
 */


package android.provider;

import android.content.Intent;
import android.database.ContentObserver;
import android.telecom.PhoneAccountHandle;
import android.telecom.PhoneAccount;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.ContentResolver;

/**
 * The contract between the voicemail provider and applications. Contains
 * definitions for the supported URIs and columns.
 *
 * <P>The content providers exposes two tables through this interface:
 * <ul>
 *   <li> Voicemails table: This stores the actual voicemail records. The
 *   columns and URIs for accessing this table are defined by the
 *   {@link android.provider.VoicemailContract.Voicemails Voicemails} class.
 *   </li>
 *   <li> Status table: This provides a way for the voicemail source application
 *   to convey its current state to the system. The columns and URIS for
 *   accessing this table are defined by the {@link android.provider.VoicemailContract.Status Status} class.
 *   </li>
 * </ul>
 *
 * <P> The minimum permission needed to access this content provider is
 * {@link android.Manifest.permission#ADD_VOICEMAIL} or carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges}).
 *
 * <P>Voicemails are inserted by what is called as a "voicemail source"
 * application, which is responsible for syncing voicemail data between a remote
 * server and the local voicemail content provider. "voicemail source"
 * application should always set the {@link #PARAM_KEY_SOURCE_PACKAGE} in the
 * URI to identify its package.
 *
 * <P>In addition to the {@link android.database.ContentObserver ContentObserver} notifications the voicemail
 * provider also generates broadcast intents to notify change for applications
 * that are not active and therefore cannot listen to ContentObserver
 * notifications. Broadcast intents with following actions are generated:
 * <ul>
 *   <li> {@link #ACTION_NEW_VOICEMAIL} is generated for each new voicemail
 *   inserted.
 *   </li>
 *   <li> {@link android.content.Intent#ACTION_PROVIDER_CHANGED Intent#ACTION_PROVIDER_CHANGED} is generated for any change
 *    made into the database, including new voicemail.
 *   </li>
 * </ul>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class VoicemailContract {

private VoicemailContract() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent to request a voicemail source to fetch voicemail content of a specific
 * voicemail from the remote server. The voicemail to fetch is specified by the data uri
 * of the intent.
 * <p>
 * All voicemail sources are expected to handle this event. After storing the content
 * the application should also set {@link android.provider.VoicemailContract.Voicemails#HAS_CONTENT Voicemails#HAS_CONTENT} to 1;
 * @apiSince 14
 */

public static final java.lang.String ACTION_FETCH_VOICEMAIL = "android.intent.action.FETCH_VOICEMAIL";

/**
 * Broadcast intent when a new voicemail record is inserted.
 * @apiSince 14
 */

public static final java.lang.String ACTION_NEW_VOICEMAIL = "android.intent.action.NEW_VOICEMAIL";

/**
 * Broadcast intent to request all voicemail sources to perform a sync with the remote server.
 * @apiSince 24
 */

public static final java.lang.String ACTION_SYNC_VOICEMAIL = "android.provider.action.SYNC_VOICEMAIL";

/**
 * The authority used by the voicemail provider.
 * @apiSince 14
 */

public static final java.lang.String AUTHORITY = "com.android.voicemail";

/**
 * Extra included in {@link #ACTION_SYNC_VOICEMAIL} broadcast intents to indicate which {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} to sync.
 * @apiSince 25
 */

public static final java.lang.String EXTRA_PHONE_ACCOUNT_HANDLE = "android.provider.extra.PHONE_ACCOUNT_HANDLE";

/**
 * Extra included in {@link android.content.Intent#ACTION_PROVIDER_CHANGED Intent#ACTION_PROVIDER_CHANGED} broadcast intents to indicate if the
 * receiving package made this change.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_SELF_CHANGE = "com.android.voicemail.extra.SELF_CHANGE";

/**
 * Parameter key used in the URI to specify the voicemail source package name.
 * <p> This field must be set in all requests that originate from a voicemail source.
 * @apiSince 14
 */

public static final java.lang.String PARAM_KEY_SOURCE_PACKAGE = "source_package";
/**
 * Defines fields exposed through the /status path of this content provider.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Status implements android.provider.BaseColumns {

private Status() { throw new RuntimeException("Stub!"); }

/**
 * A convenience method to build status URI specific to a source package by appending
 * {@link android.provider.VoicemailContract#PARAM_KEY_SOURCE_PACKAGE VoicemailContract#PARAM_KEY_SOURCE_PACKAGE} param to the base URI.
 * @apiSince 14
 */

public static android.net.Uri buildSourceUri(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * The configuration state of the voicemail source.
 *
 * <P>Negative values are reserved to the source for source-specific states, see
 * {@link #SOURCE_TYPE}
 *
 * <P> Possible values:
 * {@link #CONFIGURATION_STATE_OK},
 * {@link #CONFIGURATION_STATE_NOT_CONFIGURED},
 * {@link #CONFIGURATION_STATE_CAN_BE_CONFIGURED}
 * {@link #CONFIGURATION_STATE_CONFIGURING}
 * {@link #CONFIGURATION_STATE_FAILED}
 * {@link #CONFIGURATION_STATE_DISABLED}
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String CONFIGURATION_STATE = "configuration_state";

/**
 * Value of {@link #CONFIGURATION_STATE} to indicate the visual voicemail is not
 * yet configured on this device but can be configured by the user.
 * <p> This state must be used when the source has verified that the current user can be
 * upgraded to visual voicemail and would like to show a set up invitation message.
 * @apiSince 14
 */

public static final int CONFIGURATION_STATE_CAN_BE_CONFIGURED = 2; // 0x2

/**
 * Value of {@link #CONFIGURATION_STATE} to indicate that visual voicemail still is being
 * configured.
 * @apiSince 25
 */

public static final int CONFIGURATION_STATE_CONFIGURING = 3; // 0x3

/**
 * Value of {@link #CONFIGURATION_STATE} to indicate that visual voicemail is disabled by
 * the user.
 * @apiSince 25
 */

public static final int CONFIGURATION_STATE_DISABLED = 5; // 0x5

/**
 * Value of {@link #CONFIGURATION_STATE} to indicate that visual voicemail has failed to
 * be configured.
 * @apiSince 25
 */

public static final int CONFIGURATION_STATE_FAILED = 4; // 0x4

/**
 * Value of {@link #CONFIGURATION_STATE} to indicate the visual voicemail is not
 * yet configured on this device.
 * @apiSince 14
 */

public static final int CONFIGURATION_STATE_NOT_CONFIGURED = 1; // 0x1

/**
 * Value of {@link #CONFIGURATION_STATE} to indicate an all OK configuration status.
 * @apiSince 14
 */

public static final int CONFIGURATION_STATE_OK = 0; // 0x0

/**
 * URI to insert/retrieve status of voicemail source.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The data channel state of the voicemail source. This the channel through which the source
 * pulls voicemail data from a remote server.
 *
 * <P>Negative values are reserved to the source for source-specific states, see
 * {@link #SOURCE_TYPE}
 *
 * <P> Possible values:
 * {@link #DATA_CHANNEL_STATE_OK},
 * {@link #DATA_CHANNEL_STATE_NO_CONNECTION}
 * </P>
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String DATA_CHANNEL_STATE = "data_channel_state";

/**
 *  Value of {@link #DATA_CHANNEL_STATE} to indicate that data channel received incorrect
 *  settings or credentials to connect to the server
 * @apiSince 24
 */

public static final int DATA_CHANNEL_STATE_BAD_CONFIGURATION = 3; // 0x3

/**
 *  Value of {@link #DATA_CHANNEL_STATE} to indicate that a error has occurred in the data
 *  channel while communicating with the server
 * @apiSince 24
 */

public static final int DATA_CHANNEL_STATE_COMMUNICATION_ERROR = 4; // 0x4

/**
 *  Value of {@link #DATA_CHANNEL_STATE} to indicate that data channel failed to find a
 *  suitable network to connect to the server.
 * @apiSince 14
 */

public static final int DATA_CHANNEL_STATE_NO_CONNECTION = 1; // 0x1

/**
 *  Value of {@link #DATA_CHANNEL_STATE} to indicate that data channel failed to find a
 *  suitable network to connect to the server, and the carrier requires using cellular
 *  data network to connect to the server.
 * @apiSince 24
 */

public static final int DATA_CHANNEL_STATE_NO_CONNECTION_CELLULAR_REQUIRED = 2; // 0x2

/**
 *  Value of {@link #DATA_CHANNEL_STATE} to indicate that data channel is working fine.
 * @apiSince 14
 */

public static final int DATA_CHANNEL_STATE_OK = 0; // 0x0

/**
 *  Value of {@link #DATA_CHANNEL_STATE} to indicate that while there is a suitable network,
 *  the data channel is unable to establish a connection with the server.
 * @apiSince 24
 */

public static final int DATA_CHANNEL_STATE_SERVER_CONNECTION_ERROR = 6; // 0x6

/**
 *  Value of {@link #DATA_CHANNEL_STATE} to indicate that the server reported an internal
 *  error to the data channel.
 * @apiSince 24
 */

public static final int DATA_CHANNEL_STATE_SERVER_ERROR = 5; // 0x5

/**
 * The MIME type for a collection of voicemail source statuses.
 * @apiSince 14
 */

public static final java.lang.String DIR_TYPE = "vnd.android.cursor.dir/voicemail.source.status";

/**
 * The MIME type for a single voicemail source status entry.
 * @apiSince 14
 */

public static final java.lang.String ITEM_TYPE = "vnd.android.cursor.item/voicemail.source.status";

/**
 * The notification channel state of the voicemail source. This is the channel through which
 * the source gets notified of new voicemails on the remote server.
 *
 * <P>Negative values are reserved to the source for source-specific states, see
 * {@link #SOURCE_TYPE}
 *
 * <P> Possible values:
 * {@link #NOTIFICATION_CHANNEL_STATE_OK},
 * {@link #NOTIFICATION_CHANNEL_STATE_NO_CONNECTION},
 * {@link #NOTIFICATION_CHANNEL_STATE_MESSAGE_WAITING}
 * </P>
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String NOTIFICATION_CHANNEL_STATE = "notification_channel_state";

/**
 * Value of {@link #NOTIFICATION_CHANNEL_STATE} to indicate that there are messages waiting
 * on the server but the details are not known.
 * <p> Use this state when the notification can only tell that there are pending messages on
 * the server but no details of the sender/time etc are known.
 * @apiSince 14
 */

public static final int NOTIFICATION_CHANNEL_STATE_MESSAGE_WAITING = 2; // 0x2

/**
 * Value of {@link #NOTIFICATION_CHANNEL_STATE} to indicate that the notification channel
 * connection is not working.
 * @apiSince 14
 */

public static final int NOTIFICATION_CHANNEL_STATE_NO_CONNECTION = 1; // 0x1

/**
 * Value of {@link #NOTIFICATION_CHANNEL_STATE} to indicate that the notification channel is
 * working fine.
 * @apiSince 14
 */

public static final int NOTIFICATION_CHANNEL_STATE_OK = 0; // 0x0

/**
 * The {@link android.content.ComponentName ComponentName} of the {@link android.telecom.PhoneAccount PhoneAccount} in string form. The
 * {@link android.telecom.PhoneAccount PhoneAccount} differentiates voicemail sources from the same package.
 * <P>Type: TEXT</P>
 * @apiSince 23
 */

public static final java.lang.String PHONE_ACCOUNT_COMPONENT_NAME = "phone_account_component_name";

/**
 * The identifier of a {@link android.telecom.PhoneAccount PhoneAccount} that is unique to a specified component. The
 * {@link android.telecom.PhoneAccount PhoneAccount} differentiates voicemail sources from the same package.
 * <P>Type: TEXT</P>
 * @apiSince 23
 */

public static final java.lang.String PHONE_ACCOUNT_ID = "phone_account_id";

/**
 * Amount of resource that is used by existing voicemail in the visual voicemail inbox,
 * or {@link #QUOTA_UNAVAILABLE} if the quota has never been updated before. This value is
 * used to inform the client the situation on the remote server. Unit is not specified.
 * <P>Type: INTEGER</P>
 * @apiSince 24
 */

public static final java.lang.String QUOTA_OCCUPIED = "quota_occupied";

/**
 * Total resource in the visual voicemail inbox that can be used, or
 * {@link #QUOTA_UNAVAILABLE} if server either has unlimited quota or does not provide quota
 * information. This value is used to inform the client the situation on the remote server.
 * Unit is not specified.
 * <P>Type: INTEGER</P>
 * @apiSince 24
 */

public static final java.lang.String QUOTA_TOTAL = "quota_total";

/**
 * Value for {@link #QUOTA_OCCUPIED} and {@link #QUOTA_TOTAL} to indicate that no
 * information is available.
 * @apiSince 24
 */

public static final int QUOTA_UNAVAILABLE = -1; // 0xffffffff

/**
 * The URI to call to invoke source specific voicemail settings screen. On a user request
 * to setup voicemail an intent with action VIEW with this URI will be fired by the system.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SETTINGS_URI = "settings_uri";

/**
 * The package name of the voicemail source. There can only be a one entry per account
 * per source.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SOURCE_PACKAGE = "source_package";

/**
 * The type of the source, which determines how to interpret source-specific states.
 * Typically this will be set to the same string as
 * {@link android.telephony.CarrierConfigManager#KEY_VVM_TYPE_STRING}. For example,
 * "vvm_type_omtp".
 *
 * <P>Type: TEXT</P>
 *
 * @see #CONFIGURATION_STATE
 * @see #DATA_CHANNEL_STATE
 * @see #NOTIFICATION_CHANNEL_STATE
 * @apiSince 25
 */

public static final java.lang.String SOURCE_TYPE = "source_type";

/**
 * The URI to call when the user requests to directly access the voicemail from the remote
 * server. In case of an IVR voicemail system this is typically set to the the voicemail
 * number specified using a tel:/ URI.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String VOICEMAIL_ACCESS_URI = "voicemail_access_uri";
}

/**
 * Defines fields exposed through the /voicemail path of this content provider.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Voicemails implements android.provider.BaseColumns, android.provider.OpenableColumns {

private Voicemails() { throw new RuntimeException("Stub!"); }

/**
 * A convenience method to build voicemail URI specific to a source package by appending
 * {@link android.provider.VoicemailContract#PARAM_KEY_SOURCE_PACKAGE VoicemailContract#PARAM_KEY_SOURCE_PACKAGE} param to the base URI.
 * @apiSince 14
 */

public static android.net.Uri buildSourceUri(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Flag to indicate the voicemail was marked as archived. Archived voicemail should not be
 * deleted even if it no longer exist on the server. The value will be 1 if archived true, 0
 * if not.
 *
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 26
 */

public static final java.lang.String ARCHIVED = "archived";

/**
 * Flag to indicate the voicemail was backed up. The value will be 1 if backed up, 0 if
 * not.
 *
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 26
 */

public static final java.lang.String BACKED_UP = "backed_up";

/**
 * URI to insert/retrieve voicemails.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The date the voicemail was sent, in milliseconds since the epoch
 * <P>Type: INTEGER (long)</P>
 * @apiSince 14
 */

public static final java.lang.String DATE = "date";

/**
 * Flag used to indicate that the voicemail was deleted but not synced to the server.
 * A deleted row should be ignored.
 * The value will be 1 if deleted is true, 0 if false.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 23
 */

public static final java.lang.String DELETED = "deleted";

/**
 * Flag used to indicate that local, unsynced changes are present.
 * Currently, this is used to indicate that the voicemail was read or deleted.
 * The value will be 1 if dirty is true, 0 if false.
 *
 * <p>When a caller updates a voicemail row (either with {@link android.content.ContentResolver#update ContentResolver#update} or
 * {@link android.content.ContentResolver#applyBatch ContentResolver#applyBatch}), and if the {@link android.content.ContentValues ContentValues} doesn't contain
 * this column, the voicemail provider implicitly sets it to 0 if the calling package is
 * the {@link #SOURCE_PACKAGE} or to 1 otherwise. To prevent this behavior, explicitly set
 * {@link #DIRTY_RETAIN} to DIRTY in the {@link android.content.ContentValues ContentValues}.
 *
 * <P>Type: INTEGER (boolean)</P>
 *
 * @see #DIRTY_RETAIN
 * @apiSince 23
 */

public static final java.lang.String DIRTY = "dirty";

/**
 * Value of {@link #DIRTY} when updating to indicate that the value should not be updated
 * during this operation.
 * @apiSince 28
 */

public static final int DIRTY_RETAIN = -1; // 0xffffffff

/**
 * The MIME type for a collection of voicemails.
 * @apiSince 14
 */

public static final java.lang.String DIR_TYPE = "vnd.android.cursor.dir/voicemails";

/**
 * The duration of the voicemail in seconds.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 14
 */

public static final java.lang.String DURATION = "duration";

/**
 * Whether the media content for this voicemail is available for
 * consumption.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String HAS_CONTENT = "has_content";

/**
 * Flag to indicate the voicemail is a OMTP voicemail handled by the {@link
 * android.telephony.VisualVoicemailService}. The UI should only show OMTP voicemails from
 * the current visual voicemail package. For example, the selection could be
 * {@code WHERE (IS_OMTP_VOICEMAIL == 0) OR ( IS_OMTP_VOICEMAIL == 1 AND SOURCE_PACKAGE ==
 * "current.vvm.package")}
 *
 * <P>Type: INTEGER (boolean)</P>
 *
 * @see android.telephony.TelephonyManager#getVisualVoicemailPackageName
 * @apiSince 26
 */

public static final java.lang.String IS_OMTP_VOICEMAIL = "is_omtp_voicemail";

/**
 * Whether this item has been read or otherwise consumed by the user.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String IS_READ = "is_read";

/**
 * The MIME type for a single voicemail.
 * @apiSince 14
 */

public static final java.lang.String ITEM_TYPE = "vnd.android.cursor.item/voicemail";

/**
 * The date the row is last inserted, updated, or marked as deleted, in milliseconds
 * since the epoch. Read only.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 24
 */

public static final java.lang.String LAST_MODIFIED = "last_modified";

/**
 * MIME type of the media content for the voicemail.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String MIME_TYPE = "mime_type";

/**
 * Whether or not the voicemail has been acknowledged (notification sent to the user).
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 28
 */

public static final java.lang.String NEW = "new";

/**
 * Phone number of the voicemail sender.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String NUMBER = "number";

/**
 * The {@link android.content.ComponentName ComponentName} of the {@link android.telecom.PhoneAccount PhoneAccount} in string form. The
 * {@link android.telecom.PhoneAccount PhoneAccount} of the voicemail is used to differentiate voicemails from different
 * sources.
 * <P>Type: TEXT</P>
 * @apiSince 23
 */

public static final java.lang.String PHONE_ACCOUNT_COMPONENT_NAME = "subscription_component_name";

/**
 * The identifier of a {@link android.telecom.PhoneAccount PhoneAccount} that is unique to a specified
 * {@link android.content.ComponentName ComponentName}. The {@link android.telecom.PhoneAccount PhoneAccount} of the voicemail is used to differentiate
 * voicemails from different sources.
 * <P>Type: TEXT</P>
 * @apiSince 23
 */

public static final java.lang.String PHONE_ACCOUNT_ID = "subscription_id";

/**
 * Flag to indicate the voicemail was restored from a backup. The value will be 1 if
 * restored, 0 if not.
 *
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 26
 */

public static final java.lang.String RESTORED = "restored";

/**
 * Application-specific data available to the source application that
 * inserted the voicemail. This is typically used to store the source
 * specific message id to identify this voicemail on the remote
 * voicemail server.
 * <P>Type: TEXT</P>
 * <P> Note that this is NOT the voicemail media content data.
 * @apiSince 14
 */

public static final java.lang.String SOURCE_DATA = "source_data";

/**
 * Package name of the source application that inserted the voicemail.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SOURCE_PACKAGE = "source_package";

/**
 * The transcription of the voicemail entry. This will only be populated if the voicemail
 * entry has a valid transcription.
 * <P>Type: TEXT</P>
 * @apiSince 21
 */

public static final java.lang.String TRANSCRIPTION = "transcription";
}

}

