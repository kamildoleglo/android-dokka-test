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
import android.app.Activity;
import android.net.Uri;
import android.content.ContentResolver;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.ContentUris;
import android.app.admin.DevicePolicyManager;
import java.util.Set;
import android.content.ComponentName;
import android.database.Cursor;
import android.content.ContentProviderClient;
import android.text.format.Time;

/**
 * <p>
 * The contract between the calendar provider and applications. Contains
 * definitions for the supported URIs and data columns.
 * </p>
 * <h3>Overview</h3>
 * <p>
 * CalendarContract defines the data model of calendar and event related
 * information. This data is stored in a number of tables:
 * </p>
 * <ul>
 * <li>The {@link android.provider.CalendarContract.Calendars Calendars} table holds the calendar specific information. Each
 * row in this table contains the details for a single calendar, such as the
 * name, color, sync info, etc.</li>
 * <li>The {@link android.provider.CalendarContract.Events Events} table holds the event specific information. Each row
 * in this table has the info for a single event. It contains information such
 * as event title, location, start time, end time, etc. The event can occur
 * one-time or can recur multiple times. Attendees, reminders, and extended
 * properties are stored on separate tables and reference the {@link android.provider.CalendarContract.Events#_ID Events#_ID}
 * to link them with the event.</li>
 * <li>The {@link android.provider.CalendarContract.Instances Instances} table holds the start and end time for occurrences
 * of an event. Each row in this table represents a single occurrence. For
 * one-time events there will be a 1:1 mapping of instances to events. For
 * recurring events, multiple rows will automatically be generated which
 * correspond to multiple occurrences of that event.</li>
 * <li>The {@link android.provider.CalendarContract.Attendees Attendees} table holds the event attendee or guest
 * information. Each row represents a single guest of an event. It specifies the
 * type of guest they are and their attendance response for the event.</li>
 * <li>The {@link android.provider.CalendarContract.Reminders Reminders} table holds the alert/notification data. Each row
 * represents a single alert for an event. An event can have multiple reminders.
 * The number of reminders per event is specified in
 * {@link android.provider.CalendarContract.Calendars#MAX_REMINDERS Calendars#MAX_REMINDERS} which is set by the Sync Adapter that owns
 * the given calendar. Reminders are specified in minutes before the event and
 * have a type.</li>
 * <li>The {@link android.provider.CalendarContract.ExtendedProperties ExtendedProperties} table holds opaque data fields used by the
 * sync adapter. The provider takes no action with items in this table except to
 * delete them when their related events are deleted.</li>
 * </ul>
 * <p>
 * Other tables include:
 * </p>
 * <ul>
 * <li>
 * {@link android.provider.CalendarContract.SyncState SyncState}, which contains free-form data maintained by the sync
 * adapters</li>
 * </ul>
 *
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CalendarContract {

private CalendarContract() { throw new RuntimeException("Stub!"); }

/**
 * Starts an activity to view calendar events in the managed profile.
 *
 * When this API is called, the system will attempt to start an activity
 * in the managed profile with an intent targeting the same caller package.
 * The intent will have its action set to
 * {@link android.provider.CalendarContract#ACTION_VIEW_MANAGED_PROFILE_CALENDAR_EVENT CalendarContract#ACTION_VIEW_MANAGED_PROFILE_CALENDAR_EVENT} and contain extras
 * corresponding to the API's arguments. A calendar app intending to support
 * cross-profile events viewing should handle this intent, parse the arguments
 * and show the appropriate UI.
 *
 * @param context the context.
 * This value must never be {@code null}.
 * @param eventId the id of the event to be viewed. Will be put into {@link #EXTRA_EVENT_ID}
 *                field of the intent.
 * @param startMs the start time of the event in milliseconds since epoch.
 *                Will be put into {@link #EXTRA_EVENT_BEGIN_TIME} field of the intent.
 * @param endMs the end time of the event in milliseconds since epoch.
 *              Will be put into {@link #EXTRA_EVENT_END_TIME} field of the intent.
 * @param allDay if the event is an all-day event. Will be put into
 *               {@link #EXTRA_EVENT_ALL_DAY} field of the intent.
 * @param flags flags to be set on the intent via {@link android.content.Intent#setFlags Intent#setFlags}
 * @return {@code true} if the activity is started successfully. {@code false} otherwise.
 *
 * @see #EXTRA_EVENT_ID
 * @see #EXTRA_EVENT_BEGIN_TIME
 * @see #EXTRA_EVENT_END_TIME
 * @see #EXTRA_EVENT_ALL_DAY
 * @apiSince 29
 */

public static boolean startViewCalendarEventInManagedProfile(@androidx.annotation.NonNull android.content.Context context, long eventId, long startMs, long endMs, boolean allDay, int flags) { throw new RuntimeException("Stub!"); }

/**
 * A special account type for calendars not associated with any account.
 * Normally calendars that do not match an account on the device will be
 * removed. Setting the account_type on a calendar to this will prevent it
 * from being wiped if it does not match an existing account.
 *
 * @see android.provider.CalendarContract.SyncColumns#ACCOUNT_TYPE
 * @apiSince 14
 */

public static final java.lang.String ACCOUNT_TYPE_LOCAL = "LOCAL";

/**
 * Broadcast Action: This is the intent that gets fired when an alarm
 * notification needs to be posted for a reminder.
 *
 * @apiSince 14
 */

public static final java.lang.String ACTION_EVENT_REMINDER = "android.intent.action.EVENT_REMINDER";

/**
 * Activity Action: Display the event to the user in the custom app as
 * specified in {@link android.provider.CalendarContract.EventsColumns#CUSTOM_APP_PACKAGE EventsColumns#CUSTOM_APP_PACKAGE}. The custom app
 * will be started via {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)}
 * and it should call {@link android.app.Activity#setResult(int) Activity#setResult(int)} with
 * {@link android.app.Activity#RESULT_OK Activity#RESULT_OK} or {@link android.app.Activity#RESULT_CANCELED Activity#RESULT_CANCELED} to
 * acknowledge whether the action was handled or not.
 *
 * The custom app should have an intent filter like the following:
 * <pre>
 * &lt;intent-filter&gt;
 *    &lt;action android:name="android.provider.calendar.action.HANDLE_CUSTOM_EVENT" /&gt;
 *    &lt;category android:name="android.intent.category.DEFAULT" /&gt;
 *    &lt;data android:mimeType="vnd.android.cursor.item/event" /&gt;
 * &lt;/intent-filter&gt;</pre>
 * <p>
 * Input: {@link android.content.Intent#getData Intent#getData} has the event URI. The extra
 * {@link #EXTRA_EVENT_BEGIN_TIME} has the start time of the instance. The
 * extra {@link #EXTRA_CUSTOM_APP_URI} will have the
 * {@link android.provider.CalendarContract.EventsColumns#CUSTOM_APP_URI EventsColumns#CUSTOM_APP_URI}.
 * <p>
 * Output: {@link android.app.Activity#RESULT_OK Activity#RESULT_OK} if this was handled; otherwise
 * {@link android.app.Activity#RESULT_CANCELED Activity#RESULT_CANCELED}.
 * @apiSince 16
 */

public static final java.lang.String ACTION_HANDLE_CUSTOM_EVENT = "android.provider.calendar.action.HANDLE_CUSTOM_EVENT";

/**
 * Action used to help apps show calendar events in the managed profile.
 * @apiSince 29
 */

public static final java.lang.String ACTION_VIEW_MANAGED_PROFILE_CALENDAR_EVENT = "android.provider.calendar.action.VIEW_MANAGED_PROFILE_CALENDAR_EVENT";

/**
 * This authority is used for writing to or querying from the calendar
 * provider. Note: This is set at first run and cannot be changed without
 * breaking apps that access the provider.
 * @apiSince 14
 */

public static final java.lang.String AUTHORITY = "com.android.calendar";

/**
 * An optional insert, update or delete URI parameter that allows the caller
 * to specify that it is a sync adapter. The default value is false. If set
 * to true, the modified row is not marked as "dirty" (needs to be synced)
 * and when the provider calls
 * {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(android.net.Uri, android.database.ContentObserver, boolean)}
 * , the third parameter "syncToNetwork" is set to false. Furthermore, if
 * set to true, the caller must also include
 * {@link android.provider.CalendarContract.Calendars#ACCOUNT_NAME Calendars#ACCOUNT_NAME} and {@link android.provider.CalendarContract.Calendars#ACCOUNT_TYPE Calendars#ACCOUNT_TYPE} as
 * query parameters.
 *
 * @see android.net.Uri.Builder#appendQueryParameter(java.lang.String, java.lang.String)
 * @apiSince 14
 */

public static final java.lang.String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";

/**
 * The content:// style URL for the top-level calendar authority
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Intent Extras key: {@link android.provider.CalendarContract.EventsColumns#CUSTOM_APP_URI EventsColumns#CUSTOM_APP_URI} for the event in
 * the {@link #ACTION_HANDLE_CUSTOM_EVENT} intent
 * @apiSince 16
 */

public static final java.lang.String EXTRA_CUSTOM_APP_URI = "customAppUri";

/**
 * Intent Extras key: When creating an event, set this to true to create an
 * all-day event by default
 * @apiSince 14
 */

public static final java.lang.String EXTRA_EVENT_ALL_DAY = "allDay";

/**
 * Intent Extras key: The start time of an event or an instance of a
 * recurring event. (milliseconds since epoch)
 * @apiSince 14
 */

public static final java.lang.String EXTRA_EVENT_BEGIN_TIME = "beginTime";

/**
 * Intent Extras key: The end time of an event or an instance of a recurring
 * event. (milliseconds since epoch)
 * @apiSince 14
 */

public static final java.lang.String EXTRA_EVENT_END_TIME = "endTime";

/**
 * Intent Extras key: An extra of type {@code long} holding the id of an event.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_EVENT_ID = "id";
/**
 * Fields and helpers for interacting with Attendees. Each row of this table
 * represents a single attendee or guest of an event. Calling
 * {@link #query(android.content.ContentResolver,long,java.lang.String[])} will return a list of attendees for
 * the event with the given eventId. Both apps and sync adapters may write
 * to this table. There are six writable fields and all of them except
 * {@link #ATTENDEE_NAME} must be included when inserting a new attendee.
 * They are:
 * <ul>
 * <li>{@link #EVENT_ID}</li>
 * <li>{@link #ATTENDEE_NAME}</li>
 * <li>{@link #ATTENDEE_EMAIL}</li>
 * <li>{@link #ATTENDEE_RELATIONSHIP}</li>
 * <li>{@link #ATTENDEE_TYPE}</li>
 * <li>{@link #ATTENDEE_STATUS}</li>
 * <li>{@link #ATTENDEE_IDENTITY}</li>
 * <li>{@link #ATTENDEE_ID_NAMESPACE}</li>
 * </ul>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Attendees implements android.provider.BaseColumns, android.provider.CalendarContract.AttendeesColumns, android.provider.CalendarContract.EventsColumns {

private Attendees() { throw new RuntimeException("Stub!"); }

/**
 * Queries all attendees associated with the given event. This is a
 * blocking call and should not be done on the UI thread.
 *
 * @param cr The content resolver to use for the query
 * @param eventId The id of the event to retrieve attendees for
 * @param projection the columns to return in the cursor
 * @return A Cursor containing all attendees for the event
 * @apiSince 14
 */

public static android.database.Cursor query(android.content.ContentResolver cr, long eventId, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URL for accessing Attendees data
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/**
 * Columns from the Attendees table that other tables join into themselves.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface AttendeesColumns {

/**
 * The email address of the attendee. Column name.
 * <P>Type: STRING</P>
 * @apiSince 14
 */

public static final java.lang.String ATTENDEE_EMAIL = "attendeeEmail";

/**
 * The identity of the attendee as referenced in
 * {@link android.provider.ContactsContract.CommonDataKinds.Identity#IDENTITY ContactsContract.CommonDataKinds.Identity#IDENTITY}.
 * This is required only if {@link #ATTENDEE_ID_NAMESPACE} is present. Column name.
 * <P>Type: STRING</P>
 * @apiSince 16
 */

public static final java.lang.String ATTENDEE_IDENTITY = "attendeeIdentity";

/**
 * The identity name space of the attendee as referenced in
 * {@link android.provider.ContactsContract.CommonDataKinds.Identity#NAMESPACE ContactsContract.CommonDataKinds.Identity#NAMESPACE}.
 * This is required only if {@link #ATTENDEE_IDENTITY} is present. Column name.
 * <P>Type: STRING</P>
 * @apiSince 16
 */

public static final java.lang.String ATTENDEE_ID_NAMESPACE = "attendeeIdNamespace";

/**
 * The name of the attendee. Column name.
 * <P>Type: STRING</P>
 * @apiSince 14
 */

public static final java.lang.String ATTENDEE_NAME = "attendeeName";

/**
 * The relationship of the attendee to the user. Column name.
 * <P>Type: INTEGER (one of {@link #RELATIONSHIP_ATTENDEE}, ...}.</P>
 * @apiSince 14
 */

public static final java.lang.String ATTENDEE_RELATIONSHIP = "attendeeRelationship";

/**
 * The attendance status of the attendee. Column name.
 * <P>Type: Integer (one of {@link #ATTENDEE_STATUS_ACCEPTED}, ...).</P>
 * @apiSince 14
 */

public static final java.lang.String ATTENDEE_STATUS = "attendeeStatus";

/** @apiSince 14 */

public static final int ATTENDEE_STATUS_ACCEPTED = 1; // 0x1

/** @apiSince 14 */

public static final int ATTENDEE_STATUS_DECLINED = 2; // 0x2

/** @apiSince 14 */

public static final int ATTENDEE_STATUS_INVITED = 3; // 0x3

/** @apiSince 14 */

public static final int ATTENDEE_STATUS_NONE = 0; // 0x0

/** @apiSince 14 */

public static final int ATTENDEE_STATUS_TENTATIVE = 4; // 0x4

/**
 * The type of attendee. Column name.
 * <P>
 * Type: Integer (one of {@link #TYPE_NONE}, {@link #TYPE_REQUIRED},
 * {@link #TYPE_OPTIONAL}, {@link #TYPE_RESOURCE})
 * </P>
 * @apiSince 14
 */

public static final java.lang.String ATTENDEE_TYPE = "attendeeType";

/**
 * The id of the event. Column name.
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_ID = "event_id";

/** @apiSince 14 */

public static final int RELATIONSHIP_ATTENDEE = 1; // 0x1

/** @apiSince 14 */

public static final int RELATIONSHIP_NONE = 0; // 0x0

/** @apiSince 14 */

public static final int RELATIONSHIP_ORGANIZER = 2; // 0x2

/** @apiSince 14 */

public static final int RELATIONSHIP_PERFORMER = 3; // 0x3

/** @apiSince 14 */

public static final int RELATIONSHIP_SPEAKER = 4; // 0x4

/** @apiSince 14 */

public static final int TYPE_NONE = 0; // 0x0

/** @apiSince 14 */

public static final int TYPE_OPTIONAL = 2; // 0x2

/** @apiSince 14 */

public static final int TYPE_REQUIRED = 1; // 0x1

/**
 * This specifies that an attendee is a resource, like a room, a
 * cabbage, or something and not an actual person.
 * @apiSince 15
 */

public static final int TYPE_RESOURCE = 3; // 0x3
}

/**
 * Fields and helpers for accessing calendar alerts information. These
 * fields are for tracking which alerts have been fired. Scheduled alarms
 * will generate an intent using {@link #ACTION_EVENT_REMINDER}. Apps that
 * receive this action may update the {@link #STATE} for the reminder when
 * they have finished handling it. Apps that have their notifications
 * disabled should not modify the table to ensure that they do not conflict
 * with another app that is generating a notification. In general, apps
 * should not need to write to this table directly except to update the
 * state of a reminder.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CalendarAlerts implements android.provider.BaseColumns, android.provider.CalendarContract.CalendarAlertsColumns, android.provider.CalendarContract.EventsColumns, android.provider.CalendarContract.CalendarColumns {

private CalendarAlerts() { throw new RuntimeException("Stub!"); }

/**
 * The Uri for querying calendar alert information
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * This URI is for grouping the query results by event_id and begin
 * time.  This will return one result per instance of an event.  So
 * events with multiple alarms will appear just once, but multiple
 * instances of a repeating event will show up multiple times.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI_BY_INSTANCE;
static { CONTENT_URI_BY_INSTANCE = null; }
}

/** @apiSince 14 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface CalendarAlertsColumns {

/**
 * The alarm time of the event, in UTC. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String ALARM_TIME = "alarmTime";

/**
 * The start time of the event, in UTC. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String BEGIN = "begin";

/**
 * The creation time of this database entry, in UTC.
 * Useful for debugging missed reminders. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String CREATION_TIME = "creationTime";

/**
 * The default sort order for this alerts queries
 * @apiSince 14
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "begin ASC,title ASC";

/**
 * The end time of the event, in UTC. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String END = "end";

/**
 * The event that the alert belongs to. Column name.
 * <P>Type: INTEGER (foreign key to the Events table)</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_ID = "event_id";

/**
 * The number of minutes that this alarm precedes the start time. Column
 * name.
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String MINUTES = "minutes";

/**
 * The time that the notification was created by the Calendar app,
 * in UTC. Useful for debugging missed reminders. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String NOTIFY_TIME = "notifyTime";

/**
 * The time that the alarm broadcast was received by the Calendar app,
 * in UTC. Useful for debugging missed reminders. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String RECEIVED_TIME = "receivedTime";

/**
 * The state of this alert. It starts out as {@link #STATE_SCHEDULED}, then
 * when the alarm goes off, it changes to {@link #STATE_FIRED}, and then when
 * the user dismisses the alarm it changes to {@link #STATE_DISMISSED}. Column
 * name.
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String STATE = "state";

/**
 * Once the user has dismissed the notification the alert's state should
 * be set to dismissed so it is not fired again.
 * @apiSince 14
 */

public static final int STATE_DISMISSED = 2; // 0x2

/**
 * After a notification for an alert has been created it should be
 * updated to fired.
 * @apiSince 14
 */

public static final int STATE_FIRED = 1; // 0x1

/**
 * An alert begins in this state when it is first created.
 * @apiSince 14
 */

public static final int STATE_SCHEDULED = 0; // 0x0
}

/**
 * CalendarCache stores some settings for calendar including the current
 * time zone for the instances. These settings are stored using a key/value
 * scheme. A {@link #KEY} must be specified when updating these values.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CalendarCache implements android.provider.CalendarContract.CalendarCacheColumns {

private CalendarCache() { throw new RuntimeException("Stub!"); }

/**
 * The key for updating the time zone used by the provider when it
 * generates the instances table. This should only be written if the
 * type is set to {@link #TIMEZONE_TYPE_HOME}. A valid time zone id
 * should be written to this field.
 * @apiSince 14
 */

public static final java.lang.String KEY_TIMEZONE_INSTANCES = "timezoneInstances";

/**
 * The key for reading the last time zone set by the user. This should
 * only be read by apps and it will be automatically updated whenever
 * {@link #KEY_TIMEZONE_INSTANCES} is updated with
 * {@link #TIMEZONE_TYPE_HOME} set.
 * @apiSince 14
 */

public static final java.lang.String KEY_TIMEZONE_INSTANCES_PREVIOUS = "timezoneInstancesPrevious";

/**
 * They key for updating the use of auto/home time zones in Calendar.
 * Valid values are {@link #TIMEZONE_TYPE_AUTO} or
 * {@link #TIMEZONE_TYPE_HOME}.
 * @apiSince 14
 */

public static final java.lang.String KEY_TIMEZONE_TYPE = "timezoneType";

/**
 * The value to write to {@link #KEY_TIMEZONE_TYPE} if the provider
 * should stay in sync with the device's time zone.
 * @apiSince 14
 */

public static final java.lang.String TIMEZONE_TYPE_AUTO = "auto";

/**
 * The value to write to {@link #KEY_TIMEZONE_TYPE} if the provider
 * should use a fixed time zone set by the user.
 * @apiSince 14
 */

public static final java.lang.String TIMEZONE_TYPE_HOME = "home";

/**
 * The URI to use for retrieving the properties from the Calendar db.
 * @apiSince 14
 */

public static final android.net.Uri URI;
static { URI = null; }
}

/** @apiSince 14 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface CalendarCacheColumns {

/**
 * The key for the setting. Keys are defined in {@link android.provider.CalendarContract.CalendarCache CalendarCache}.
 * @apiSince 14
 */

public static final java.lang.String KEY = "key";

/**
 * The value of the given setting.
 * @apiSince 14
 */

public static final java.lang.String VALUE = "value";
}

/**
 * Columns specific to the Calendars Uri that other Uris can query.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface CalendarColumns {

/**
 * A comma separated list of attendee types supported for this calendar
 * in the format "#,#,#". Valid types are {@link android.provider.CalendarContract.Attendees#TYPE_NONE Attendees#TYPE_NONE},
 * {@link android.provider.CalendarContract.Attendees#TYPE_OPTIONAL Attendees#TYPE_OPTIONAL}, {@link android.provider.CalendarContract.Attendees#TYPE_REQUIRED Attendees#TYPE_REQUIRED},
 * {@link android.provider.CalendarContract.Attendees#TYPE_RESOURCE Attendees#TYPE_RESOURCE}. Setting this field to only
 * {@link android.provider.CalendarContract.Attendees#TYPE_NONE Attendees#TYPE_NONE} should be used to indicate that changing
 * the attendee type is not supported.
 *
 * @apiSince 15
 */

public static final java.lang.String ALLOWED_ATTENDEE_TYPES = "allowedAttendeeTypes";

/**
 * A comma separated list of availability types supported for this
 * calendar in the format "#,#,#". Valid types are
 * {@link android.provider.CalendarContract.Events#AVAILABILITY_BUSY Events#AVAILABILITY_BUSY}, {@link android.provider.CalendarContract.Events#AVAILABILITY_FREE Events#AVAILABILITY_FREE},
 * {@link android.provider.CalendarContract.Events#AVAILABILITY_TENTATIVE Events#AVAILABILITY_TENTATIVE}. Setting this field to only
 * {@link android.provider.CalendarContract.Events#AVAILABILITY_BUSY Events#AVAILABILITY_BUSY} should be used to indicate that
 * changing the availability is not supported.
 *
 * @apiSince 15
 */

public static final java.lang.String ALLOWED_AVAILABILITY = "allowedAvailability";

/**
 * A comma separated list of reminder methods supported for this
 * calendar in the format "#,#,#". Valid types are
 * {@link android.provider.CalendarContract.Reminders#METHOD_DEFAULT Reminders#METHOD_DEFAULT}, {@link android.provider.CalendarContract.Reminders#METHOD_ALERT Reminders#METHOD_ALERT},
 * {@link android.provider.CalendarContract.Reminders#METHOD_EMAIL Reminders#METHOD_EMAIL}, {@link android.provider.CalendarContract.Reminders#METHOD_SMS Reminders#METHOD_SMS},
 * {@link android.provider.CalendarContract.Reminders#METHOD_ALARM Reminders#METHOD_ALARM}. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String ALLOWED_REMINDERS = "allowedReminders";

/**
 * The level of access that the user has for the calendar
 * <P>Type: INTEGER (one of the values below)</P>
 * @apiSince 14
 */

public static final java.lang.String CALENDAR_ACCESS_LEVEL = "calendar_access_level";

/**
 * The color of the calendar. This should only be updated by the sync
 * adapter, not other apps, as changing a calendar's color can adversely
 * affect its display.
 * <P>Type: INTEGER (color value)</P>
 * @apiSince 14
 */

public static final java.lang.String CALENDAR_COLOR = "calendar_color";

/**
 * A key for looking up a color from the {@link android.provider.CalendarContract.Colors Colors} table. NULL or
 * an empty string are reserved for indicating that the calendar does
 * not use a key for looking up the color. The provider will update
 * {@link #CALENDAR_COLOR} automatically when a valid key is written to
 * this column. The key must reference an existing row of the
 * {@link android.provider.CalendarContract.Colors Colors} table. @see Colors
 * <P>
 * Type: TEXT
 * </P>
 * @apiSince 15
 */

public static final java.lang.String CALENDAR_COLOR_KEY = "calendar_color_index";

/**
 * The display name of the calendar. Column name.
 * <P>
 * Type: TEXT
 * </P>
 * @apiSince 14
 */

public static final java.lang.String CALENDAR_DISPLAY_NAME = "calendar_displayName";

/**
 * The time zone the calendar is associated with.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CALENDAR_TIME_ZONE = "calendar_timezone";

/** Full access to modify the calendar, but not the access control
 * settings
 * @apiSince 14
 */

public static final int CAL_ACCESS_CONTRIBUTOR = 500; // 0x1f4

/** Full access to modify the calendar, but not the access control
 * settings
 * @apiSince 14
 */

public static final int CAL_ACCESS_EDITOR = 600; // 0x258

/**
 * Can only see free/busy information about the calendar
 * @apiSince 14
 */

public static final int CAL_ACCESS_FREEBUSY = 100; // 0x64

/**
 * Cannot access the calendar
 * @apiSince 14
 */

public static final int CAL_ACCESS_NONE = 0; // 0x0

/**
 * not used
 * @apiSince 14
 */

public static final int CAL_ACCESS_OVERRIDE = 400; // 0x190

/**
 * Full access to the calendar
 * @apiSince 14
 */

public static final int CAL_ACCESS_OWNER = 700; // 0x2bc

/**
 * Can read all event details
 * @apiSince 14
 */

public static final int CAL_ACCESS_READ = 200; // 0xc8

/**
 * Can reply yes/no/maybe to an event
 * @apiSince 14
 */

public static final int CAL_ACCESS_RESPOND = 300; // 0x12c

/**
 * Domain admin
 * @apiSince 14
 */

public static final int CAL_ACCESS_ROOT = 800; // 0x320

/**
 * Can the organizer modify the time zone of the event? Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String CAN_MODIFY_TIME_ZONE = "canModifyTimeZone";

/**
 * Can the organizer respond to the event?  If no, the status of the
 * organizer should not be shown by the UI.  Defaults to 1. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String CAN_ORGANIZER_RESPOND = "canOrganizerRespond";

/**
 * Is this the primary calendar for this account. If this column is not explicitly set, the
 * provider will return 1 if {@link android.provider.CalendarContract.Calendars#ACCOUNT_NAME Calendars#ACCOUNT_NAME} is equal to
 * {@link android.provider.CalendarContract.Calendars#OWNER_ACCOUNT Calendars#OWNER_ACCOUNT}.
 * @apiSince 17
 */

public static final java.lang.String IS_PRIMARY = "isPrimary";

/**
 * The maximum number of reminders allowed for an event. Column name.
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String MAX_REMINDERS = "maxReminders";

/**
 * The owner account for this calendar, based on the calendar feed.
 * This will be different from the _SYNC_ACCOUNT for delegated calendars.
 * Column name.
 * <P>Type: String</P>
 * @apiSince 14
 */

public static final java.lang.String OWNER_ACCOUNT = "ownerAccount";

/**
 * Is this calendar synced and are its events stored on the device?
 * 0 - Do not sync this calendar or store events for this calendar.
 * 1 - Sync down events for this calendar.
 * <p>Type: INTEGER (boolean)</p>
 * @apiSince 14
 */

public static final java.lang.String SYNC_EVENTS = "sync_events";

/**
 * Is the calendar selected to be displayed?
 * 0 - do not show events associated with this calendar.
 * 1 - show events associated with this calendar
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String VISIBLE = "visible";
}

/**
 * Class that represents a Calendar Entity. There is one entry per calendar.
 * This is a helper class to make batch operations easier.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CalendarEntity implements android.provider.BaseColumns, android.provider.CalendarContract.SyncColumns, android.provider.CalendarContract.CalendarColumns {

private CalendarEntity() { throw new RuntimeException("Stub!"); }

/**
 * Creates an entity iterator for the given cursor. It assumes the
 * cursor contains a calendars query.
 *
 * @param cursor query on {@link #CONTENT_URI}
 * @return an EntityIterator of calendars
 * @apiSince 14
 */

public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * The default Uri used when creating a new calendar EntityIterator.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/**
 * Generic columns for use by sync adapters. The specific functions of these
 * columns are private to the sync adapter. Other clients of the API should
 * not attempt to either read or write this column. These columns are
 * editable as part of the Calendars Uri, but can only be read if accessed
 * through any other Uri.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface CalendarSyncColumns {

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC1 = "cal_sync1";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC10 = "cal_sync10";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC2 = "cal_sync2";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC3 = "cal_sync3";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC4 = "cal_sync4";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC5 = "cal_sync5";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC6 = "cal_sync6";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC7 = "cal_sync7";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC8 = "cal_sync8";

/**
 * Generic column for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CAL_SYNC9 = "cal_sync9";
}

/**
 * Constants and helpers for the Calendars table, which contains details for
 * individual calendars. <h3>Operations</h3> All operations can be done
 * either as an app or as a sync adapter. To perform an operation as a sync
 * adapter {@link #CALLER_IS_SYNCADAPTER} should be set to true and
 * {@link #ACCOUNT_NAME} and {@link #ACCOUNT_TYPE} must be set in the Uri
 * parameters. See
 * {@link android.net.Uri.Builder#appendQueryParameter(java.lang.String,java.lang.String) Uri.Builder#appendQueryParameter(java.lang.String, java.lang.String)}
 * for details on adding parameters. Sync adapters have write access to more
 * columns but are restricted to a single account at a time. Calendars are
 * designed to be primarily managed by a sync adapter and inserting new
 * calendars should be done as a sync adapter. For the most part, apps
 * should only update calendars (such as changing the color or display
 * name). If a local calendar is required an app can do so by inserting as a
 * sync adapter and using an {@link #ACCOUNT_TYPE} of
 * {@link #ACCOUNT_TYPE_LOCAL} .
 * <dl>
 * <dt><b>Insert</b></dt>
 * <dd>When inserting a new calendar the following fields must be included:
 * <ul>
 * <li>{@link #ACCOUNT_NAME}</li>
 * <li>{@link #ACCOUNT_TYPE}</li>
 * <li>{@link #NAME}</li>
 * <li>{@link #CALENDAR_DISPLAY_NAME}</li>
 * <li>{@link #CALENDAR_COLOR}</li>
 * <li>{@link #CALENDAR_ACCESS_LEVEL}</li>
 * <li>{@link #OWNER_ACCOUNT}</li>
 * </ul>
 * The following fields are not required when inserting a Calendar but are
 * generally a good idea to include:
 * <ul>
 * <li>{@link #SYNC_EVENTS} set to 1</li>
 * <li>{@link #CALENDAR_TIME_ZONE}</li>
 * <li>{@link #ALLOWED_REMINDERS}</li>
 * <li>{@link #ALLOWED_AVAILABILITY}</li>
 * <li>{@link #ALLOWED_ATTENDEE_TYPES}</li>
 * </ul>
 * <dt><b>Update</b></dt>
 * <dd>To perform an update on a calendar the {@link #_ID} of the calendar
 * should be provided either as an appended id to the Uri (
 * {@link android.content.ContentUris#withAppendedId ContentUris#withAppendedId}) or as the first selection item--the
 * selection should start with "_id=?" and the first selectionArg should be
 * the _id of the calendar. Calendars may also be updated using a selection
 * without the id. In general, the {@link #ACCOUNT_NAME} and
 * {@link #ACCOUNT_TYPE} should not be changed after a calendar is created
 * as this can cause issues for sync adapters.
 * <dt><b>Delete</b></dt>
 * <dd>Calendars can be deleted either by the {@link #_ID} as an appended id
 * on the Uri or using any standard selection. Deleting a calendar should
 * generally be handled by a sync adapter as it will remove the calendar
 * from the database and all associated data (aka events).</dd>
 * <dt><b>Query</b></dt>
 * <dd>Querying the Calendars table will get you all information about a set
 * of calendars. There will be one row returned for each calendar that
 * matches the query selection, or at most a single row if the {@link #_ID}
 * is appended to the Uri.</dd>
 * </dl>
 * <h3>Calendar Columns</h3> The following Calendar columns are writable by
 * both an app and a sync adapter.
 * <ul>
 * <li>{@link #NAME}</li>
 * <li>{@link #CALENDAR_DISPLAY_NAME}</li>
 * <li>{@link #VISIBLE}</li>
 * <li>{@link #SYNC_EVENTS}</li>
 * </ul>
 * The following Calendars columns are writable only by a sync adapter
 * <ul>
 * <li>{@link #ACCOUNT_NAME}</li>
 * <li>{@link #ACCOUNT_TYPE}</li>
 * <li>{@link #CALENDAR_COLOR}</li>
 * <li>{@link #_SYNC_ID}</li>
 * <li>{@link #DIRTY}</li>
 * <li>{@link #MUTATORS}</li>
 * <li>{@link #OWNER_ACCOUNT}</li>
 * <li>{@link #MAX_REMINDERS}</li>
 * <li>{@link #ALLOWED_REMINDERS}</li>
 * <li>{@link #ALLOWED_AVAILABILITY}</li>
 * <li>{@link #ALLOWED_ATTENDEE_TYPES}</li>
 * <li>{@link #CAN_MODIFY_TIME_ZONE}</li>
 * <li>{@link #CAN_ORGANIZER_RESPOND}</li>
 * <li>{@link #CAN_PARTIALLY_UPDATE}</li>
 * <li>{@link #CALENDAR_LOCATION}</li>
 * <li>{@link #CALENDAR_TIME_ZONE}</li>
 * <li>{@link #CALENDAR_ACCESS_LEVEL}</li>
 * <li>{@link #DELETED}</li>
 * <li>{@link #CAL_SYNC1}</li>
 * <li>{@link #CAL_SYNC2}</li>
 * <li>{@link #CAL_SYNC3}</li>
 * <li>{@link #CAL_SYNC4}</li>
 * <li>{@link #CAL_SYNC5}</li>
 * <li>{@link #CAL_SYNC6}</li>
 * <li>{@link #CAL_SYNC7}</li>
 * <li>{@link #CAL_SYNC8}</li>
 * <li>{@link #CAL_SYNC9}</li>
 * <li>{@link #CAL_SYNC10}</li>
 * </ul>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Calendars implements android.provider.BaseColumns, android.provider.CalendarContract.SyncColumns, android.provider.CalendarContract.CalendarColumns {

private Calendars() { throw new RuntimeException("Stub!"); }

/**
 * The default location for the calendar. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String CALENDAR_LOCATION = "calendar_location";

/**
 * The content:// style URL for accessing Calendars
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The default sort order for this table
 * @apiSince 14
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "calendar_displayName";

/**
 * The content:// style URL for querying Calendars table in the managed profile. Appending
 * a calendar id using {@link android.content.ContentUris#withAppendedId(android.net.Uri,long) ContentUris#withAppendedId(Uri, long)} specifies
 * a single calendar.
 *
 * <p>The following columns are allowed to be queried via this uri:
 * <ul>
 * <li>{@link #_ID}</li>
 * <li>{@link #CALENDAR_COLOR}</li>
 * <li>{@link #VISIBLE}</li>
 * <li>{@link #CALENDAR_LOCATION}</li>
 * <li>{@link #CALENDAR_TIME_ZONE}</li>
 * <li>{@link #IS_PRIMARY}</li>
 * </ul>
 *
 * <p>{@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown if there exists columns in the
 * projection of the query to this uri that are not contained in the above list.
 *
 * <p>This uri returns an empty cursor if the calling user is not a parent profile
 * of a managed profile, or the managed profile is disabled, or cross-profile calendar is
 * disabled in Settings, or this uri is queried from a package that is not allowed by
 * the profile owner of the managed profile via
 * {@link android.app.admin.DevicePolicyManager#setCrossProfileCalendarPackages(android.content.ComponentName,java.util.Set) DevicePolicyManager#setCrossProfileCalendarPackages(ComponentName, Set)}.
 *
 * <p>Apps can register a {@link android.database.ContentObserver} for this URI to listen
 * to changes.
 *
 * @see android.app.admin.DevicePolicyManager#getCrossProfileCalendarPackages(ComponentName)
 * @see android.provider.Settings.Secure#CROSS_PROFILE_CALENDAR_ENABLED
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri ENTERPRISE_CONTENT_URI;
static { ENTERPRISE_CONTENT_URI = null; }

/**
 * The name of the calendar. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String NAME = "name";
}

/**
 * Fields for accessing colors available for a given account. Colors are
 * referenced by {@link #COLOR_KEY} which must be unique for a given
 * account name/type. These values can only be updated by the sync
 * adapter. Only {@link #COLOR} may be updated after the initial insert. In
 * addition, a row can only be deleted once all references to that color
 * have been removed from the {@link android.provider.CalendarContract.Calendars Calendars} or {@link android.provider.CalendarContract.Events Events} tables.
 * @apiSince 15
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Colors implements android.provider.CalendarContract.ColorsColumns {

private Colors() { throw new RuntimeException("Stub!"); }

/**
 * The Uri for querying color information
 * @apiSince 15
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/** @apiSince 15 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface ColorsColumns extends android.provider.SyncStateContract.Columns {

/**
 * The color as an 8-bit ARGB integer value. Colors should specify alpha
 * as fully opaque (eg 0xFF993322) as the alpha may be ignored or
 * modified for display. It is reccomended that colors be usable with
 * light (near white) text. Apps should not depend on that assumption,
 * however. Column name.
 * <P>
 * Type: INTEGER (NOT NULL)
 * </P>
 * @apiSince 15
 */

public static final java.lang.String COLOR = "color";

/**
 * The key used to reference this color. This can be any non-empty
 * string, but must be unique for a given {@link #ACCOUNT_TYPE} and
 * {@link #ACCOUNT_NAME}. Column name.
 * <P>
 * Type: TEXT
 * </P>
 * @apiSince 15
 */

public static final java.lang.String COLOR_KEY = "color_index";

/**
 * The type of color, which describes how it should be used. Valid types
 * are {@link #TYPE_CALENDAR} and {@link #TYPE_EVENT}. Column name.
 * <P>
 * Type: INTEGER (NOT NULL)
 * </P>
 * @apiSince 15
 */

public static final java.lang.String COLOR_TYPE = "color_type";

/**
 * This indicateds a color that can be used for calendars.
 * @apiSince 15
 */

public static final int TYPE_CALENDAR = 0; // 0x0

/**
 * This indicates a color that can be used for events.
 * @apiSince 15
 */

public static final int TYPE_EVENT = 1; // 0x1
}

/**
 * Fields and helpers for querying for a list of days that contain events.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EventDays implements android.provider.CalendarContract.EventDaysColumns {

private EventDays() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the days with events for the Julian days starting at
 * "startDay" for "numDays". It returns a cursor containing startday and
 * endday representing the max range of days for all events beginning on
 * each startday.This is a blocking function and should not be done on
 * the UI thread.
 *
 * @param cr the ContentResolver
 * @param startDay the first Julian day in the range
 * @param numDays the number of days to load (must be at least 1)
 * @param projection the columns to return in the cursor
 * @return a database cursor containing a list of start and end days for
 *         events
 * @apiSince 14
 */

public static android.database.Cursor query(android.content.ContentResolver cr, int startDay, int numDays, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/** @apiSince 14 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface EventDaysColumns {

/**
 * The Julian ending day number. Column name.
 * <P>Type: INTEGER (int)</P>
 * @apiSince 14
 */

public static final java.lang.String ENDDAY = "endDay";

/**
 * The Julian starting day number. Column name.
 * <P>Type: INTEGER (int)</P>
 * @apiSince 14
 */

public static final java.lang.String STARTDAY = "startDay";
}

/**
 * Constants and helpers for the Events table, which contains details for
 * individual events. <h3>Operations</h3> All operations can be done either
 * as an app or as a sync adapter. To perform an operation as a sync adapter
 * {@link #CALLER_IS_SYNCADAPTER} should be set to true and
 * {@link #ACCOUNT_NAME} and {@link #ACCOUNT_TYPE} must be set in the Uri
 * parameters. See
 * {@link android.net.Uri.Builder#appendQueryParameter(java.lang.String,java.lang.String) Uri.Builder#appendQueryParameter(java.lang.String, java.lang.String)}
 * for details on adding parameters. Sync adapters have write access to more
 * columns but are restricted to a single account at a time.
 * <dl>
 * <dt><b>Insert</b></dt>
 * <dd>When inserting a new event the following fields must be included:
 * <ul>
 * <li>dtstart</li>
 * <li>dtend if the event is non-recurring</li>
 * <li>duration if the event is recurring</li>
 * <li>rrule or rdate if the event is recurring</li>
 * <li>eventTimezone</li>
 * <li>a calendar_id</li>
 * </ul>
 * There are also further requirements when inserting or updating an event.
 * See the section on Writing to Events.</dd>
 * <dt><b>Update</b></dt>
 * <dd>To perform an update of an Event the {@link android.provider.CalendarContract.Events#_ID Events#_ID} of the event
 * should be provided either as an appended id to the Uri (
 * {@link android.content.ContentUris#withAppendedId ContentUris#withAppendedId}) or as the first selection item--the
 * selection should start with "_id=?" and the first selectionArg should be
 * the _id of the event. Updates may also be done using a selection and no
 * id. Updating an event must respect the same rules as inserting and is
 * further restricted in the fields that can be written. See the section on
 * Writing to Events.</dd>
 * <dt><b>Delete</b></dt>
 * <dd>Events can be deleted either by the {@link android.provider.CalendarContract.Events#_ID Events#_ID} as an appended
 * id on the Uri or using any standard selection. If an appended id is used
 * a selection is not allowed. There are two versions of delete: as an app
 * and as a sync adapter. An app delete will set the deleted column on an
 * event and remove all instances of that event. A sync adapter delete will
 * remove the event from the database and all associated data.</dd>
 * <dt><b>Query</b></dt>
 * <dd>Querying the Events table will get you all information about a set of
 * events except their reminders, attendees, and extended properties. There
 * will be one row returned for each event that matches the query selection,
 * or at most a single row if the {@link android.provider.CalendarContract.Events#_ID Events#_ID} is appended to the Uri.
 * Recurring events will only return a single row regardless of the number
 * of times that event repeats.</dd>
 * </dl>
 * <h3>Writing to Events</h3> There are further restrictions on all Updates
 * and Inserts in the Events table:
 * <ul>
 * <li>If allDay is set to 1 eventTimezone must be {@link android.text.format.Time#TIMEZONE_UTC Time#TIMEZONE_UTC}
 * and the time must correspond to a midnight boundary.</li>
 * <li>Exceptions are not allowed to recur. If rrule or rdate is not empty,
 * original_id and original_sync_id must be empty.</li>
 * <li>In general a calendar_id should not be modified after insertion. This
 * is not explicitly forbidden but many sync adapters will not behave in an
 * expected way if the calendar_id is modified.</li>
 * </ul>
 * The following Events columns are writable by both an app and a sync
 * adapter.
 * <ul>
 * <li>{@link #CALENDAR_ID}</li>
 * <li>{@link #ORGANIZER}</li>
 * <li>{@link #TITLE}</li>
 * <li>{@link #EVENT_LOCATION}</li>
 * <li>{@link #DESCRIPTION}</li>
 * <li>{@link #EVENT_COLOR}</li>
 * <li>{@link #DTSTART}</li>
 * <li>{@link #DTEND}</li>
 * <li>{@link #EVENT_TIMEZONE}</li>
 * <li>{@link #EVENT_END_TIMEZONE}</li>
 * <li>{@link #DURATION}</li>
 * <li>{@link #ALL_DAY}</li>
 * <li>{@link #RRULE}</li>
 * <li>{@link #RDATE}</li>
 * <li>{@link #EXRULE}</li>
 * <li>{@link #EXDATE}</li>
 * <li>{@link #ORIGINAL_ID}</li>
 * <li>{@link #ORIGINAL_SYNC_ID}</li>
 * <li>{@link #ORIGINAL_INSTANCE_TIME}</li>
 * <li>{@link #ORIGINAL_ALL_DAY}</li>
 * <li>{@link #ACCESS_LEVEL}</li>
 * <li>{@link #AVAILABILITY}</li>
 * <li>{@link #GUESTS_CAN_MODIFY}</li>
 * <li>{@link #GUESTS_CAN_INVITE_OTHERS}</li>
 * <li>{@link #GUESTS_CAN_SEE_GUESTS}</li>
 * <li>{@link #CUSTOM_APP_PACKAGE}</li>
 * <li>{@link #CUSTOM_APP_URI}</li>
 * <li>{@link #UID_2445}</li>
 * </ul>
 * The following Events columns are writable only by a sync adapter
 * <ul>
 * <li>{@link #DIRTY}</li>
 * <li>{@link #MUTATORS}</li>
 * <li>{@link #_SYNC_ID}</li>
 * <li>{@link #SYNC_DATA1}</li>
 * <li>{@link #SYNC_DATA2}</li>
 * <li>{@link #SYNC_DATA3}</li>
 * <li>{@link #SYNC_DATA4}</li>
 * <li>{@link #SYNC_DATA5}</li>
 * <li>{@link #SYNC_DATA6}</li>
 * <li>{@link #SYNC_DATA7}</li>
 * <li>{@link #SYNC_DATA8}</li>
 * <li>{@link #SYNC_DATA9}</li>
 * <li>{@link #SYNC_DATA10}</li>
 * </ul>
 * The remaining columns are either updated by the provider only or are
 * views into other tables and cannot be changed through the Events table.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Events implements android.provider.BaseColumns, android.provider.CalendarContract.SyncColumns, android.provider.CalendarContract.EventsColumns, android.provider.CalendarContract.CalendarColumns {

private Events() { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URI for recurring event exceptions.  Insertions require an
 * appended event ID.  Deletion of exceptions requires both the original event ID and
 * the exception event ID (see {@link android.net.Uri.Builder#appendPath Uri.Builder#appendPath}).
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_EXCEPTION_URI;
static { CONTENT_EXCEPTION_URI = null; }

/**
 * The content:// style URL for interacting with events. Appending an
 * event id using {@link android.content.ContentUris#withAppendedId(android.net.Uri,long) ContentUris#withAppendedId(Uri, long)} will
 * specify a single event.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The content:// style URL for querying Events table in the managed profile. Appending an
 * event id using {@link android.content.ContentUris#withAppendedId(android.net.Uri,long) ContentUris#withAppendedId(Uri, long)} specifies a single event.
 *
 * <p>The following columns are allowed to be queried via this uri:
 * <ul>
 * <li>{@link #_ID}</li>
 * <li>{@link #CALENDAR_ID}</li>
 * <li>{@link #TITLE}</li>
 * <li>{@link #EVENT_LOCATION}</li>
 * <li>{@link #EVENT_COLOR}</li>
 * <li>{@link #STATUS}</li>
 * <li>{@link #DTSTART}</li>
 * <li>{@link #DTEND}</li>
 * <li>{@link #EVENT_TIMEZONE}</li>
 * <li>{@link #EVENT_END_TIMEZONE}</li>
 * <li>{@link #DURATION}</li>
 * <li>{@link #ALL_DAY}</li>
 * <li>{@link #AVAILABILITY}</li>
 * <li>{@link #RRULE}</li>
 * <li>{@link #RDATE}</li>
 * <li>{@link #LAST_DATE}</li>
 * <li>{@link #EXRULE}</li>
 * <li>{@link #EXDATE}</li>
 * <li>{@link #SELF_ATTENDEE_STATUS}</li>
 * <li>{@link #DISPLAY_COLOR}</li>
 * <li>{@link #CALENDAR_COLOR}</li>
 * <li>{@link #VISIBLE}</li>
 * <li>{@link #CALENDAR_TIME_ZONE}</li>
 * <li>{@link #IS_PRIMARY}</li>
 * </ul>
 *
 * <p>{@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown if there exists columns in the
 * projection of the query to this uri that are not contained in the above list.
 *
 * <p>This uri returns an empty cursor if the calling user is not a parent profile
 * of a managed profile, or the managed profile is disabled, or cross-profile calendar is
 * disabled in Settings, or this uri is queried from a package that is not allowed by
 * the profile owner of the managed profile via
 * {@link android.app.admin.DevicePolicyManager#setCrossProfileCalendarPackages(android.content.ComponentName,java.util.Set) DevicePolicyManager#setCrossProfileCalendarPackages(ComponentName, Set)}.
 *
 * <p>Apps can register a {@link android.database.ContentObserver} for this URI to listen
 * to changes.
 *
 * @see android.app.admin.DevicePolicyManager#getCrossProfileCalendarPackages(ComponentName)
 * @see android.provider.Settings.Secure#CROSS_PROFILE_CALENDAR_ENABLED
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri ENTERPRISE_CONTENT_URI;
static { ENTERPRISE_CONTENT_URI = null; }
}

/**
 * Columns from the Events table that other tables join into themselves.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface EventsColumns {

/**
 * Confidential is not used by the app.
 * @apiSince 14
 */

public static final int ACCESS_CONFIDENTIAL = 1; // 0x1

/**
 * Default access is controlled by the server and will be treated as
 * public on the device.
 * @apiSince 14
 */

public static final int ACCESS_DEFAULT = 0; // 0x0

/**
 * Defines how the event shows up for others when the calendar is
 * shared. Column name.
 * <P>Type: INTEGER (One of {@link #ACCESS_DEFAULT}, ...)</P>
 * @apiSince 14
 */

public static final java.lang.String ACCESS_LEVEL = "accessLevel";

/**
 * Private shares the event as a free/busy slot with no details.
 * @apiSince 14
 */

public static final int ACCESS_PRIVATE = 2; // 0x2

/**
 * Public makes the contents visible to anyone with access to the
 * calendar.
 * @apiSince 14
 */

public static final int ACCESS_PUBLIC = 3; // 0x3

/**
 * Is the event all day (time zone independent). Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String ALL_DAY = "allDay";

/**
 * If this event counts as busy time or is still free time that can be
 * scheduled over. Column name.
 * <P>
 * Type: INTEGER (One of {@link #AVAILABILITY_BUSY},
 * {@link #AVAILABILITY_FREE}, {@link #AVAILABILITY_TENTATIVE})
 * </P>
 * @apiSince 14
 */

public static final java.lang.String AVAILABILITY = "availability";

/**
 * Indicates that this event takes up time and will conflict with other
 * events.
 * @apiSince 14
 */

public static final int AVAILABILITY_BUSY = 0; // 0x0

/**
 * Indicates that this event is free time and will not conflict with
 * other events.
 * @apiSince 14
 */

public static final int AVAILABILITY_FREE = 1; // 0x1

/**
 * Indicates that the owner's availability may change, but should be
 * considered busy time that will conflict.
 * @apiSince 15
 */

public static final int AVAILABILITY_TENTATIVE = 2; // 0x2

/**
 * The {@link android.provider.CalendarContract.Calendars#_ID Calendars#_ID} of the calendar the event belongs to.
 * Column name.
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String CALENDAR_ID = "calendar_id";

/**
 * Whether the user can invite others to the event. The
 * GUESTS_CAN_INVITE_OTHERS is a setting that applies to an arbitrary
 * guest, while CAN_INVITE_OTHERS indicates if the user can invite
 * others (either through GUESTS_CAN_INVITE_OTHERS or because the user
 * has modify access to the event). Column name.
 * <P>Type: INTEGER (boolean, readonly)</P>
 * @apiSince 14
 */

public static final java.lang.String CAN_INVITE_OTHERS = "canInviteOthers";

/**
 * The package name of the custom app that can provide a richer
 * experience for the event. See the ACTION TYPE
 * {@link android.provider.CalendarContract#ACTION_HANDLE_CUSTOM_EVENT CalendarContract#ACTION_HANDLE_CUSTOM_EVENT} for details.
 * Column name.
 * <P> Type: TEXT </P>
 * @apiSince 16
 */

public static final java.lang.String CUSTOM_APP_PACKAGE = "customAppPackage";

/**
 * The URI used by the custom app for the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 16
 */

public static final java.lang.String CUSTOM_APP_URI = "customAppUri";

/**
 * The description of the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String DESCRIPTION = "description";

/**
 * This will be {@link #EVENT_COLOR} if it is not null; otherwise, this will be
 * {@link android.provider.CalendarContract.Calendars#CALENDAR_COLOR Calendars#CALENDAR_COLOR}.
 * Read-only value. To modify, write to {@link #EVENT_COLOR} or
 * {@link android.provider.CalendarContract.Calendars#CALENDAR_COLOR Calendars#CALENDAR_COLOR} directly.
 *<P>
 *     Type: INTEGER
 *</P>
 * @apiSince 16
 */

public static final java.lang.String DISPLAY_COLOR = "displayColor";

/**
 * The time the event ends in UTC millis since epoch. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String DTEND = "dtend";

/**
 * The time the event starts in UTC millis since epoch. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String DTSTART = "dtstart";

/**
 * The duration of the event in RFC2445 format. Column name.
 * <P>Type: TEXT (duration in RFC2445 format)</P>
 * @apiSince 14
 */

public static final java.lang.String DURATION = "duration";

/**
 * A secondary color for the individual event. This should only be
 * updated by the sync adapter for a given account.
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_COLOR = "eventColor";

/**
 * A secondary color key for the individual event. NULL or an empty
 * string are reserved for indicating that the event does not use a key
 * for looking up the color. The provider will update
 * {@link #EVENT_COLOR} automatically when a valid key is written to
 * this column. The key must reference an existing row of the
 * {@link android.provider.CalendarContract.Colors Colors} table. @see Colors
 * <P>
 * Type: TEXT
 * </P>
 * @apiSince 15
 */

public static final java.lang.String EVENT_COLOR_KEY = "eventColor_index";

/**
 * The timezone for the end time of the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_END_TIMEZONE = "eventEndTimezone";

/**
 * Where the event takes place. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_LOCATION = "eventLocation";

/**
 * The timezone for the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_TIMEZONE = "eventTimezone";

/**
 * The recurrence exception dates for the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String EXDATE = "exdate";

/**
 * The recurrence exception rule for the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String EXRULE = "exrule";

/**
 * Whether guests can invite other guests. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String GUESTS_CAN_INVITE_OTHERS = "guestsCanInviteOthers";

/**
 * Whether guests can modify the event. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String GUESTS_CAN_MODIFY = "guestsCanModify";

/**
 * Whether guests can see the list of attendees. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String GUESTS_CAN_SEE_GUESTS = "guestsCanSeeGuests";

/**
 * Whether the event has an alarm or not. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String HAS_ALARM = "hasAlarm";

/**
 * Whether the event has attendee information.  True if the event
 * has full attendee data, false if the event has information about
 * self only. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String HAS_ATTENDEE_DATA = "hasAttendeeData";

/**
 * Whether the event has extended properties or not. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String HAS_EXTENDED_PROPERTIES = "hasExtendedProperties";

/**
 * Are we the organizer of this event. If this column is not explicitly set, the provider
 * will return 1 if {@link #ORGANIZER} is equal to {@link android.provider.CalendarContract.Calendars#OWNER_ACCOUNT Calendars#OWNER_ACCOUNT}.
 * Column name.
 * <P>Type: STRING</P>
 * @apiSince 17
 */

public static final java.lang.String IS_ORGANIZER = "isOrganizer";

/**
 * The last date this event repeats on, or NULL if it never ends. Column
 * name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String LAST_DATE = "lastDate";

/**
 * Used to indicate that a row is not a real event but an original copy of a locally
 * modified event. A copy is made when an event changes from non-dirty to dirty and the
 * event is on a calendar with {@link android.provider.CalendarContract.Calendars#CAN_PARTIALLY_UPDATE Calendars#CAN_PARTIALLY_UPDATE} set to 1. This copy
 * does not get expanded in the instances table and is only visible in queries made by a
 * sync adapter. The copy gets removed when the event is changed back to non-dirty by a
 * sync adapter.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String LAST_SYNCED = "lastSynced";

/**
 * Email of the organizer (owner) of the event. Column name.
 * <P>Type: STRING</P>
 * @apiSince 14
 */

public static final java.lang.String ORGANIZER = "organizer";

/**
 * The allDay status (true or false) of the original recurring event
 * for which this event is an exception. Column name.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String ORIGINAL_ALL_DAY = "originalAllDay";

/**
 * The {@link android.provider.CalendarContract.Events#_ID Events#_ID} of the original recurring event for which this
 * event is an exception. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String ORIGINAL_ID = "original_id";

/**
 * The original instance time of the recurring event for which this
 * event is an exception. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String ORIGINAL_INSTANCE_TIME = "originalInstanceTime";

/**
 * The _sync_id of the original recurring event for which this event is
 * an exception. The provider should keep the original_id in sync when
 * this is updated. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String ORIGINAL_SYNC_ID = "original_sync_id";

/**
 * The recurrence dates for the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String RDATE = "rdate";

/**
 * The recurrence rule for the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String RRULE = "rrule";

/**
 * This is a copy of the attendee status for the owner of this event.
 * This field is copied here so that we can efficiently filter out
 * events that are declined without having to look in the Attendees
 * table. Column name.
 *
 * <P>Type: INTEGER (int)</P>
 * @apiSince 14
 */

public static final java.lang.String SELF_ATTENDEE_STATUS = "selfAttendeeStatus";

/**
 * The event status. Column name.
 * <P>Type: INTEGER (one of {@link #STATUS_TENTATIVE}...)</P>
 * @apiSince 14
 */

public static final java.lang.String STATUS = "eventStatus";

/** @apiSince 14 */

public static final int STATUS_CANCELED = 2; // 0x2

/** @apiSince 14 */

public static final int STATUS_CONFIRMED = 1; // 0x1

/** @apiSince 14 */

public static final int STATUS_TENTATIVE = 0; // 0x0

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA1 = "sync_data1";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA10 = "sync_data10";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA2 = "sync_data2";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA3 = "sync_data3";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA4 = "sync_data4";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA5 = "sync_data5";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA6 = "sync_data6";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA7 = "sync_data7";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA8 = "sync_data8";

/**
 * This column is available for use by sync adapters. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String SYNC_DATA9 = "sync_data9";

/**
 * The title of the event. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String TITLE = "title";

/**
 * The UID for events added from the RFC 2445 iCalendar format.
 * Column name.
 * <P>Type: TEXT</P>
 * @apiSince 17
 */

public static final java.lang.String UID_2445 = "uid2445";
}

/**
 * Class that represents an Event Entity. There is one entry per event.
 * Recurring events show up as a single entry. This is a helper class to
 * make batch operations easier. A {@link android.content.ContentResolver ContentResolver} or
 * {@link android.content.ContentProviderClient ContentProviderClient} is required as the helper does additional
 * queries to add reminders and attendees to each entry.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EventsEntity implements android.provider.BaseColumns, android.provider.CalendarContract.SyncColumns, android.provider.CalendarContract.EventsColumns {

private EventsEntity() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new iterator for events
 *
 * @param cursor An event query
 * @param resolver For performing additional queries
 * @return an EntityIterator containing one entity per event in the
 *         cursor
 * @apiSince 14
 */

public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor, android.content.ContentResolver resolver) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new iterator for events
 *
 * @param cursor An event query
 * @param provider For performing additional queries
 * @return an EntityIterator containing one entity per event in the
 *         cursor
 * @apiSince 14
 */

public static android.content.EntityIterator newEntityIterator(android.database.Cursor cursor, android.content.ContentProviderClient provider) { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URL for this table
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/**
 * Fields for accessing the Extended Properties. This is a generic set of
 * name/value pairs for use by sync adapters to add extra
 * information to events. There are three writable columns and all three
 * must be present when inserting a new value. They are:
 * <ul>
 * <li>{@link #EVENT_ID}</li>
 * <li>{@link #NAME}</li>
 * <li>{@link #VALUE}</li>
 * </ul>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ExtendedProperties implements android.provider.BaseColumns, android.provider.CalendarContract.ExtendedPropertiesColumns, android.provider.CalendarContract.EventsColumns {

private ExtendedProperties() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/** @apiSince 14 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface ExtendedPropertiesColumns {

/**
 * The event the extended property belongs to. Column name.
 * <P>Type: INTEGER (foreign key to the Events table)</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_ID = "event_id";

/**
 * The name of the extended property.  This is a uri of the form
 * {scheme}#{local-name} convention. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String NAME = "name";

/**
 * The value of the extended property. Column name.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String VALUE = "value";
}

/**
 * Fields and helpers for interacting with Instances. An instance is a
 * single occurrence of an event including time zone specific start and end
 * days and minutes. The instances table is not writable and only provides a
 * way to query event occurrences.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Instances implements android.provider.BaseColumns, android.provider.CalendarContract.EventsColumns, android.provider.CalendarContract.CalendarColumns {

private Instances() { throw new RuntimeException("Stub!"); }

/**
 * Performs a query to return all visible instances in the given range.
 * This is a blocking function and should not be done on the UI thread.
 * This will cause an expansion of recurring events to fill this time
 * range if they are not already expanded and will slow down for larger
 * time ranges with many recurring events.
 *
 * @param cr The ContentResolver to use for the query
 * @param projection The columns to return
 * @param begin The start of the time range to query in UTC millis since
 *            epoch
 * @param end The end of the time range to query in UTC millis since
 *            epoch
 * @return A Cursor containing all instances in the given range
 * @apiSince 14
 */

public static android.database.Cursor query(android.content.ContentResolver cr, java.lang.String[] projection, long begin, long end) { throw new RuntimeException("Stub!"); }

/**
 * Performs a query to return all visible instances in the given range
 * that match the given query. This is a blocking function and should
 * not be done on the UI thread. This will cause an expansion of
 * recurring events to fill this time range if they are not already
 * expanded and will slow down for larger time ranges with many
 * recurring events.
 *
 * @param cr The ContentResolver to use for the query
 * @param projection The columns to return
 * @param begin The start of the time range to query in UTC millis since
 *            epoch
 * @param end The end of the time range to query in UTC millis since
 *            epoch
 * @param searchQuery A string of space separated search terms. Segments
 *            enclosed by double quotes will be treated as a single
 *            term.
 * @return A Cursor of instances matching the search terms in the given
 *         time range
 * @apiSince 14
 */

public static android.database.Cursor query(android.content.ContentResolver cr, java.lang.String[] projection, long begin, long end, java.lang.String searchQuery) { throw new RuntimeException("Stub!"); }

/**
 * The beginning time of the instance, in UTC milliseconds. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String BEGIN = "begin";

/**
 * The content:// style URL for querying an instance range by Julian
 * Day. The start and end day should be added as path segments if this
 * is used directly.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_BY_DAY_URI;
static { CONTENT_BY_DAY_URI = null; }

/**
 * The content:// style URL for querying an instance range with a search
 * term. The start day, end day, and search string should be appended as
 * path segments if this is used directly.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_SEARCH_BY_DAY_URI;
static { CONTENT_SEARCH_BY_DAY_URI = null; }

/**
 * The content:// style URL for querying an instance range with a search
 * term. The begin, end, and search string should be appended as path
 * segments if this is used directly.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_SEARCH_URI;
static { CONTENT_SEARCH_URI = null; }

/**
 * The content:// style URL for querying an instance range. The begin
 * and end of the range to query should be added as path segments if
 * this is used directly.
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * The ending time of the instance, in UTC milliseconds. Column name.
 * <P>Type: INTEGER (long; millis since epoch)</P>
 * @apiSince 14
 */

public static final java.lang.String END = "end";

/**
 * The Julian end day of the instance, relative to the local time
 * zone. Column name.
 * <P>Type: INTEGER (int)</P>
 * @apiSince 14
 */

public static final java.lang.String END_DAY = "endDay";

/**
 * The end minute of the instance measured from midnight in the
 * local time zone. Column name.
 * <P>Type: INTEGER (int)</P>
 * @apiSince 14
 */

public static final java.lang.String END_MINUTE = "endMinute";

/**
 * The content:// style URL for querying an instance range by Julian
 * Day in the managed profile. It supports similar semantics as {@link #CONTENT_BY_DAY_URI}
 * and performs similar checks as {@link #ENTERPRISE_CONTENT_URI}.
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri ENTERPRISE_CONTENT_BY_DAY_URI;
static { ENTERPRISE_CONTENT_BY_DAY_URI = null; }

/**
 * The content:// style URL for querying an instance range with a search
 * term in the managed profile. It supports similar semantics as
 * {@link #CONTENT_SEARCH_BY_DAY_URI} and performs similar checks as
 * {@link #ENTERPRISE_CONTENT_URI}.
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri ENTERPRISE_CONTENT_SEARCH_BY_DAY_URI;
static { ENTERPRISE_CONTENT_SEARCH_BY_DAY_URI = null; }

/**
 * The content:// style URL for querying an instance range with a search
 * term in the managed profile. It supports similar semantics as {@link #CONTENT_SEARCH_URI}
 * and performs similar checks as {@link #ENTERPRISE_CONTENT_URI}.
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri ENTERPRISE_CONTENT_SEARCH_URI;
static { ENTERPRISE_CONTENT_SEARCH_URI = null; }

/**
 * The content:// style URL for querying an instance range in the managed profile.
 * It supports similar semantics as {@link #CONTENT_URI}.
 *
 * <p>The following columns plus the columns that are allowed by
 * {@link android.provider.CalendarContract.Events#ENTERPRISE_CONTENT_URI Events#ENTERPRISE_CONTENT_URI} are allowed to be queried via this uri:
 * <ul>
 * <li>{@link #_ID}</li>
 * <li>{@link #EVENT_ID}</li>
 * <li>{@link #BEGIN}</li>
 * <li>{@link #END}</li>
 * <li>{@link #START_DAY}</li>
 * <li>{@link #END_DAY}</li>
 * <li>{@link #START_MINUTE}</li>
 * <li>{@link #END_MINUTE}</li>
 * </ul>
 *
 * <p>{@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown if there exists columns in the
 * projection of the query to this uri that are not contained in the above list.
 *
 * <p>This uri returns an empty cursor if the calling user is not a parent profile
 * of a managed profile, or the managed profile is disabled, or cross-profile calendar is
 * disabled in Settings, or this uri is queried from a package that is not allowed by
 * the profile owner of the managed profile via
 * {@link android.app.admin.DevicePolicyManager#setCrossProfileCalendarPackages(android.content.ComponentName,java.util.Set) DevicePolicyManager#setCrossProfileCalendarPackages(ComponentName, Set)}.
 *
 * @see android.app.admin.DevicePolicyManager#getCrossProfileCalendarPackages(ComponentName)
 * @see android.provider.Settings.Secure#CROSS_PROFILE_CALENDAR_ENABLED
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.net.Uri ENTERPRISE_CONTENT_URI;
static { ENTERPRISE_CONTENT_URI = null; }

/**
 * The _id of the event for this instance. Column name.
 * <P>Type: INTEGER (long, foreign key to the Events table)</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_ID = "event_id";

/**
 * The Julian start day of the instance, relative to the local time
 * zone. Column name.
 * <P>Type: INTEGER (int)</P>
 * @apiSince 14
 */

public static final java.lang.String START_DAY = "startDay";

/**
 * The start minute of the instance measured from midnight in the
 * local time zone. Column name.
 * <P>Type: INTEGER (int)</P>
 * @apiSince 14
 */

public static final java.lang.String START_MINUTE = "startMinute";
}

/**
 * Fields and helpers for accessing reminders for an event. Each row of this
 * table represents a single reminder for an event. Calling
 * {@link #query(android.content.ContentResolver,long,java.lang.String[])} will return a list of reminders for
 * the event with the given eventId. Both apps and sync adapters may write
 * to this table. There are three writable fields and all of them must be
 * included when inserting a new reminder. They are:
 * <ul>
 * <li>{@link #EVENT_ID}</li>
 * <li>{@link #MINUTES}</li>
 * <li>{@link #METHOD}</li>
 * </ul>
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Reminders implements android.provider.BaseColumns, android.provider.CalendarContract.RemindersColumns, android.provider.CalendarContract.EventsColumns {

private Reminders() { throw new RuntimeException("Stub!"); }

/**
 * Queries all reminders associated with the given event. This is a
 * blocking call and should not be done on the UI thread.
 *
 * @param cr The content resolver to use for the query
 * @param eventId The id of the event to retrieve reminders for
 * @param projection the columns to return in the cursor
 * @return A Cursor containing all reminders for the event
 * @apiSince 14
 */

public static android.database.Cursor query(android.content.ContentResolver cr, long eventId, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

/** @apiSince 14 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface RemindersColumns {

/**
 * The event the reminder belongs to. Column name.
 * <P>Type: INTEGER (foreign key to the Events table)</P>
 * @apiSince 14
 */

public static final java.lang.String EVENT_ID = "event_id";

/**
 * The alarm method, as set on the server. {@link #METHOD_DEFAULT},
 * {@link #METHOD_ALERT}, {@link #METHOD_EMAIL}, {@link #METHOD_SMS} and
 * {@link #METHOD_ALARM} are possible values; the device will only
 * process {@link #METHOD_DEFAULT} and {@link #METHOD_ALERT} reminders
 * (the other types are simply stored so we can send the same reminder
 * info back to the server when we make changes).
 * @apiSince 14
 */

public static final java.lang.String METHOD = "method";

/** @apiSince 16 */

public static final int METHOD_ALARM = 4; // 0x4

/** @apiSince 14 */

public static final int METHOD_ALERT = 1; // 0x1

/** @apiSince 14 */

public static final int METHOD_DEFAULT = 0; // 0x0

/** @apiSince 14 */

public static final int METHOD_EMAIL = 2; // 0x2

/** @apiSince 14 */

public static final int METHOD_SMS = 3; // 0x3

/**
 * The minutes prior to the event that the alarm should ring.  -1
 * specifies that we should use the default value for the system.
 * Column name.
 * <P>Type: INTEGER</P>
 * @apiSince 14
 */

public static final java.lang.String MINUTES = "minutes";

/**
 * Passing this as a minutes value will use the default reminder
 * minutes.
 * @apiSince 14
 */

public static final int MINUTES_DEFAULT = -1; // 0xffffffff
}

/**
 * Columns for Sync information used by Calendars and Events tables. These
 * have specific uses which are expected to be consistent by the app and
 * sync adapter.
 *
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static interface SyncColumns extends android.provider.CalendarContract.CalendarSyncColumns {

/**
 * The account that was used to sync the entry to the device. If the
 * account_type is not {@link #ACCOUNT_TYPE_LOCAL} then the name and
 * type must match an account on the device or the calendar will be
 * deleted.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String ACCOUNT_NAME = "account_name";

/**
 * The type of the account that was used to sync the entry to the
 * device. A type of {@link #ACCOUNT_TYPE_LOCAL} will keep this event
 * form being deleted if there are no matching accounts on the device.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String ACCOUNT_TYPE = "account_type";

/**
 * If set to 1 this causes events on this calendar to be duplicated with
 * {@link android.provider.CalendarContract.Events#LAST_SYNCED Events#LAST_SYNCED} set to 1 whenever the event
 * transitions from non-dirty to dirty. The duplicated event will not be
 * expanded in the instances table and will only show up in sync adapter
 * queries of the events table. It will also be deleted when the
 * originating event has its dirty flag cleared by the sync adapter.
 * <P>Type: INTEGER (boolean)</P>
 * @apiSince 14
 */

public static final java.lang.String CAN_PARTIALLY_UPDATE = "canPartiallyUpdate";

/**
 * Whether the row has been deleted but not synced to the server. A
 * deleted row should be ignored.
 * <P>
 * Type: INTEGER (boolean)
 * </P>
 * @apiSince 14
 */

public static final java.lang.String DELETED = "deleted";

/**
 * Used to indicate that local, unsynced, changes are present.
 * <P>Type: INTEGER (long)</P>
 * @apiSince 14
 */

public static final java.lang.String DIRTY = "dirty";

/**
 * Used in conjunction with {@link #DIRTY} to indicate what packages wrote local changes.
 * <P>Type: TEXT</P>
 * @apiSince 18
 */

public static final java.lang.String MUTATORS = "mutators";

/**
 * The unique ID for a row assigned by the sync source. NULL if the row
 * has never been synced. This is used as a reference id for exceptions
 * along with {@link android.provider.BaseColumns#_ID BaseColumns#_ID}.
 * <P>Type: TEXT</P>
 * @apiSince 14
 */

public static final java.lang.String _SYNC_ID = "_sync_id";
}

/**
 * A table provided for sync adapters to use for storing private sync state data.
 *
 * @see android.provider.SyncStateContract
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SyncState implements android.provider.SyncStateContract.Columns {

private SyncState() { throw new RuntimeException("Stub!"); }

/**
 * The content:// style URI for this table
 * @apiSince 14
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
}

}

