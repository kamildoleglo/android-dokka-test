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


package android.app;

import android.content.pm.ShortcutInfo;
import android.content.LocusId;
import android.view.contentcapture.ContentCaptureContext;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.widget.RemoteViews;
import android.media.AudioManager;
import android.media.AudioAttributes;
import android.graphics.Color;
import android.graphics.Bitmap;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Parcelable;
import android.os.Bundle;
import java.util.Set;
import android.content.Context;
import android.widget.ProgressBar;
import java.lang.reflect.Constructor;
import java.util.List;
import android.view.Gravity;

/**
 * A class that represents how a persistent notification is to be presented to
 * the user using the {@link android.app.NotificationManager}.
 *
 * <p>The {@link android.app.Notification.Builder Notification.Builder} has been added to make it
 * easier to construct Notifications.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For a guide to creating notifications, read the
 * <a href="{@docRoot}guide/topics/ui/notifiers/notifications.html">Status Bar Notifications</a>
 * developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Notification implements android.os.Parcelable {

/**
 * Constructs a Notification object with default values.
 * You might want to consider using {@link android.app.Notification.Builder Builder} instead.
 * @apiSince 1
 */

public Notification() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Notification object with the information needed to
 * have a status bar icon without the standard expanded view.
 *
 * @param icon          The resource id of the icon to put in the status bar.
 * @param tickerText    The text that flows by in the status bar when the notification first
 *                      activates.
 * @param when          The time to show in the time field.  In the System.currentTimeMillis
 *                      timebase.
 *
 * @deprecated Use {@link android.app.Notification.Builder Builder} instead.
 * @apiSince 1
 */

@Deprecated
public Notification(int icon, java.lang.CharSequence tickerText, long when) { throw new RuntimeException("Stub!"); }

/**
 * Unflatten the notification from a parcel.
 * @apiSince 1
 */

public Notification(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * Get the key used to group this notification into a cluster or stack
 * with other notifications on devices which support such rendering.
 * @apiSince 20
 */

public java.lang.String getGroup() { throw new RuntimeException("Stub!"); }

/**
 * Get a sort key that orders this notification among other notifications from the
 * same package. This can be useful if an external sort was already applied and an app
 * would like to preserve this. Notifications will be sorted lexicographically using this
 * value, although providing different priorities in addition to providing sort key may
 * cause this value to be ignored.
 *
 * <p>This sort key can also be used to order members of a notification group. See
 * {@link android.app.Notification.Builder#setGroup Builder#setGroup}.
 *
 * @see java.lang.String#compareTo(String)
 * @apiSince 20
 */

public java.lang.String getSortKey() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.app.Notification clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Flatten this notification into a parcel.
 * @apiSince 1
 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of the channel this notification posts to.
 * @apiSince 26
 */

public java.lang.String getChannelId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the duration from posting after which this notification should be canceled by the
 * system, if it's not canceled already.
 * @apiSince 26
 */

public long getTimeoutAfter() { throw new RuntimeException("Stub!"); }

/**
 * Returns what icon should be shown for this notification if it is being displayed in a
 * Launcher that supports badging. Will be one of {@link #BADGE_ICON_NONE},
 * {@link #BADGE_ICON_SMALL}, or {@link #BADGE_ICON_LARGE}.
 * @apiSince 26
 */

public int getBadgeIconType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.pm.ShortcutInfo#getId() ShortcutInfo#getId()} that this notification supersedes, if any.
 *
 * <p>Used by some Launchers that display notification content to hide shortcuts that duplicate
 * notifications.
 * @apiSince 26
 */

public java.lang.String getShortcutId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.content.LocusId LocusId} associated with this notification.
 *
 * <p>Used by the Android system to correlate objects (such as
 * {@link android.content.pm.ShortcutInfo ShortcutInfo} and {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext}).
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.content.LocusId getLocusId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the settings text provided to {@link android.app.Notification.Builder#setSettingsText(java.lang.CharSequence) Builder#setSettingsText(CharSequence)}.
 * @apiSince 26
 */

public java.lang.CharSequence getSettingsText() { throw new RuntimeException("Stub!"); }

/**
 * Returns which type of notifications in a group are responsible for audibly alerting the
 * user. See {@link #GROUP_ALERT_ALL}, {@link #GROUP_ALERT_CHILDREN},
 * {@link #GROUP_ALERT_SUMMARY}.
 
 * @return Value is {@link android.app.Notification#GROUP_ALERT_ALL}, {@link android.app.Notification#GROUP_ALERT_CHILDREN}, or {@link android.app.Notification#GROUP_ALERT_SUMMARY}
 * @apiSince 26
 */

public int getGroupAlertBehavior() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bubble metadata that will be used to display app content in a floating window
 * over the existing foreground activity.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.app.Notification.BubbleMetadata getBubbleMetadata() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the platform is allowed (by the app developer) to generate contextual actions
 * for this notification.
 * @apiSince 29
 */

public boolean getAllowSystemGeneratedContextualActions() { throw new RuntimeException("Stub!"); }

/**
 * The small icon representing this notification in the status bar and content view.
 *
 * @return the small icon representing this notification.
 *
 * @see android.app.Notification.Builder#getSmallIcon()
 * @see android.app.Notification.Builder#setSmallIcon(Icon)
 * @apiSince 23
 */

public android.graphics.drawable.Icon getSmallIcon() { throw new RuntimeException("Stub!"); }

/**
 * The large icon shown in this notification's content view.
 * @see android.app.Notification.Builder#getLargeIcon()
 * @see android.app.Notification.Builder#setLargeIcon(Icon)
 * @apiSince 23
 */

public android.graphics.drawable.Icon getLargeIcon() { throw new RuntimeException("Stub!"); }

/**
 * The default value of {@link #audioAttributes}.
 * @apiSince 21
 */

public static final android.media.AudioAttributes AUDIO_ATTRIBUTES_DEFAULT;
static { AUDIO_ATTRIBUTES_DEFAULT = null; }

/**
 * If this notification is being shown as a badge, use the {@link #getLargeIcon()} to
 * represent this notification.
 * @apiSince 26
 */

public static final int BADGE_ICON_LARGE = 2; // 0x2

/**
 * If this notification is being shown as a badge, always show as a number.
 * @apiSince 26
 */

public static final int BADGE_ICON_NONE = 0; // 0x0

/**
 * If this notification is being shown as a badge, use the {@link #getSmallIcon()} to
 * represent this notification.
 * @apiSince 26
 */

public static final int BADGE_ICON_SMALL = 1; // 0x1

/**
 * Notification category: alarm or timer.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_ALARM = "alarm";

/**
 * Notification category: incoming call (voice or video) or similar synchronous communication request.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_CALL = "call";

/**
 * Notification category: asynchronous bulk message (email).
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_EMAIL = "email";

/**
 * Notification category: error in background operation or authentication status.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_ERROR = "err";

/**
 * Notification category: calendar event.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_EVENT = "event";

/**
 * Notification category: incoming direct message (SMS, instant message, etc.).
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_MESSAGE = "msg";

/**
 * Notification category: map turn-by-turn navigation.
 * @apiSince 28
 */

public static final java.lang.String CATEGORY_NAVIGATION = "navigation";

/**
 * Notification category: progress of a long-running background operation.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_PROGRESS = "progress";

/**
 * Notification category: promotion or advertisement.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_PROMO = "promo";

/**
 * Notification category: a specific, timely recommendation for a single thing.
 * For example, a news app might want to recommend a news story it believes the user will
 * want to read next.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_RECOMMENDATION = "recommendation";

/**
 * Notification category: user-scheduled reminder.
 * @apiSince 23
 */

public static final java.lang.String CATEGORY_REMINDER = "reminder";

/**
 * Notification category: indication of running background service.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_SERVICE = "service";

/**
 * Notification category: social network or sharing update.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_SOCIAL = "social";

/**
 * Notification category: ongoing information about device or contextual status.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_STATUS = "status";

/**
 * Notification category: system or device status update.  Reserved for system use.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_SYSTEM = "sys";

/**
 * Notification category: media transport control for playback.
 * @apiSince 21
 */

public static final java.lang.String CATEGORY_TRANSPORT = "transport";

/**
 * Special value of {@link #color} telling the system not to decorate this notification with
 * any special color but instead use default colors when presenting this notification.
 * @apiSince 21
 */

public static final int COLOR_DEFAULT = 0; // 0x0

/**
 * Parcelable.Creator that instantiates Notification objects
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.Notification> CREATOR;
static { CREATOR = null; }

/**
 * Use all default values (where applicable).
 * @apiSince 1
 */

public static final int DEFAULT_ALL = -1; // 0xffffffff

/**
 * Use the default notification lights. This will ignore the
 * {@link #FLAG_SHOW_LIGHTS} bit, and {@link #ledARGB}, {@link #ledOffMS}, or
 * {@link #ledOnMS}.
 *
 * @see #defaults
 * @apiSince 1
 */

public static final int DEFAULT_LIGHTS = 4; // 0x4

/**
 * Use the default notification sound. This will ignore any given
 * {@link #sound}.
 *
 * <p>
 * A notification that is noisy is more likely to be presented as a heads-up notification.
 * </p>
 *
 * @see #defaults
 * @apiSince 1
 */

public static final int DEFAULT_SOUND = 1; // 0x1

/**
 * Use the default notification vibrate. This will ignore any given
 * {@link #vibrate}. Using phone vibration requires the
 * {@link android.Manifest.permission#VIBRATE VIBRATE} permission.
 *
 * <p>
 * A notification that vibrates is more likely to be presented as a heads-up notification.
 * </p>
 *
 * @see #defaults
 * @apiSince 1
 */

public static final int DEFAULT_VIBRATE = 2; // 0x2

/**
 * {@link #extras} key: the audio contents of this notification.
 *
 * This is for use when rendering the notification on an audio-focused interface;
 * the audio contents are a complete sound sample that contains the contents/body of the
 * notification. This may be used in substitute of a Text-to-Speech reading of the
 * notification. For example if the notification represents a voice message this should point
 * to the audio of that message.
 *
 * The data stored under this key should be a String representation of a Uri that contains the
 * audio contents in one of the following formats: WAV, PCM 16-bit, AMR-WB.
 *
 * This extra is unnecessary if you are using {@code MessagingStyle} since each {@code Message}
 * has a field for holding data URI. That field can be used for audio.
 * See {@code Message#setData}.
 *
 * Example usage:
 * <pre>
 * {@code
 * Notification.Builder myBuilder = (build your Notification as normal);
 * myBuilder.getExtras().putString(EXTRA_AUDIO_CONTENTS_URI, myAudioUri.toString());
 * }
 * </pre>
 * @apiSince 26
 */

public static final java.lang.String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";

/**
 * {@link #extras} key:
 * flat {@link java.lang.String String} representation of a {@link android.content.ContentUris content URI}
 * pointing to an image that can be displayed in the background when the notification is
 * selected. Used on television platforms. The URI must point to an image stream suitable for
 * passing into {@link android.graphics.BitmapFactory#decodeStream(java.io.InputStream)
 * BitmapFactory.decodeStream}; all other content types will be ignored.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";

/**
 * {@link #extras} key: this is the longer text shown in the big form of a
 * {@link android.app.Notification.BigTextStyle BigTextStyle} notification, as supplied to
 * {@link android.app.Notification.BigTextStyle#bigText(java.lang.CharSequence) BigTextStyle#bigText(CharSequence)}.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_BIG_TEXT = "android.bigText";

/**
 * Optional extra for {@link #INTENT_CATEGORY_NOTIFICATION_PREFERENCES}. If provided, will
 * contain a {@link android.app.NotificationChannelGroup#getId() NotificationChannelGroup#getId()} that can be used to narrow down
 * what settings should be shown in the target app.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";

/**
 * Optional extra for {@link #INTENT_CATEGORY_NOTIFICATION_PREFERENCES}. If provided, will
 * contain a {@link android.app.NotificationChannel#getId() NotificationChannel#getId()} that can be used to narrow down
 * what settings should be shown in the target app.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";

/**
 * {@link #extras} key: whether the chronometer set on the notification should count down
 * instead of counting up. Is only relevant if key {@link #EXTRA_SHOW_CHRONOMETER} is present.
 * This extra is a boolean. The default is false.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";

/**
 * {@link #extras} key: whether the notification should be colorized as
 * supplied to {@link android.app.Notification.Builder#setColorized(boolean) Builder#setColorized(boolean)}.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_COLORIZED = "android.colorized";

/**
 * {@link #extras} key: the indices of actions to be shown in the compact view,
 * as supplied to (e.g.) {@link android.app.Notification.MediaStyle#setShowActionsInCompactView(int...) MediaStyle#setShowActionsInCompactView(int...)}.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_COMPACT_ACTIONS = "android.compactActions";

/**
 * {@link #extras} key: a {@link java.lang.CharSequence CharSequence} to be displayed as the title to a conversation
 * represented by a {@link android.app.Notification.MessagingStyle}
 * @apiSince 24
 */

public static final java.lang.String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";

/**
 * {@link #extras} key: an array of
 * {@link android.app.Notification.MessagingStyle#addHistoricMessage historic}
 * {@link android.app.Notification.MessagingStyle.Message} bundles provided by a
 * {@link android.app.Notification.MessagingStyle} notification. This extra is a parcelable
 * array of bundles.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";

/**
 * {@link #extras} key: this is a small piece of additional text as supplied to
 * {@link android.app.Notification.Builder#setContentInfo(java.lang.CharSequence) Builder#setContentInfo(CharSequence)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_INFO_TEXT = "android.infoText";

/**
 * {@link #extras} key: whether the {@link android.app.Notification.MessagingStyle} notification
 * represents a group conversation.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";

/**
 * {@link #extras} key: this is a bitmap to be used instead of the small icon when showing the
 * notification payload, as
 * supplied to {@link android.app.Notification.Builder#setLargeIcon(android.graphics.Bitmap) Builder#setLargeIcon(android.graphics.Bitmap)}.
 *
 * @deprecated Use {@link #getLargeIcon()}, which supports a wider variety of icon sources.
 * @apiSince 19
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String EXTRA_LARGE_ICON = "android.largeIcon";

/**
 * {@link #extras} key: this is a bitmap to be used instead of the one from
 * {@link android.app.Notification.Builder#setLargeIcon(android.graphics.Bitmap) Builder#setLargeIcon(android.graphics.Bitmap)} when the notification is
 * shown in its expanded form, as supplied to
 * {@link android.app.Notification.BigPictureStyle#bigLargeIcon(android.graphics.Bitmap) BigPictureStyle#bigLargeIcon(android.graphics.Bitmap)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";

/**
 * {@link #extras} key: A
 * {@link android.media.session.MediaSession.Token} associated with a
 * {@link android.app.Notification.MediaStyle} notification.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_MEDIA_SESSION = "android.mediaSession";

/**
 * {@link #extras} key: an array of {@link android.app.Notification.MessagingStyle.Message}
 * bundles provided by a
 * {@link android.app.Notification.MessagingStyle} notification. This extra is a parcelable
 * array of bundles.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_MESSAGES = "android.messages";

/**
 * {@link #extras} key: the person to be displayed for all messages sent by the user including
 * direct replies
 * {@link android.app.Notification.MessagingStyle} notification. This extra is a
 * {@link android.app.Person Person}
 * @apiSince 28
 */

public static final java.lang.String EXTRA_MESSAGING_PERSON = "android.messagingUser";

/**
 * Optional extra for {@link #INTENT_CATEGORY_NOTIFICATION_PREFERENCES}. If provided, will
 * contain the id provided to {@link android.app.NotificationManager#notify(java.lang.String,int,android.app.Notification) NotificationManager#notify(String, int, Notification)}
 * that can be used to narrow down what settings should be shown in the target app.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";

/**
 * Optional extra for {@link #INTENT_CATEGORY_NOTIFICATION_PREFERENCES}. If provided, will
 * contain the tag provided to {@link android.app.NotificationManager#notify(java.lang.String,int,android.app.Notification) NotificationManager#notify(String, int, Notification)}
 * that can be used to narrow down what settings should be shown in the target app.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

/**
 * {@link #extras} key: A String array containing the people that this notification relates to,
 * each of which was supplied to {@link android.app.Notification.Builder#addPerson(java.lang.String) Builder#addPerson(String)}.
 *
 * @deprecated the actual objects are now in {@link #EXTRA_PEOPLE_LIST}
 * @apiSince 19
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String EXTRA_PEOPLE = "android.people";

/**
 * {@link #extras} key: An arrayList of {@link android.app.Person Person} objects containing the people that
 * this notification relates to.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_PEOPLE_LIST = "android.people.list";

/**
 * {@link #extras} key: this is a bitmap to be shown in {@link android.app.Notification.BigPictureStyle BigPictureStyle} expanded
 * notifications, supplied to {@link android.app.Notification.BigPictureStyle#bigPicture(android.graphics.Bitmap) BigPictureStyle#bigPicture(android.graphics.Bitmap)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PICTURE = "android.picture";

/**
 * {@link #extras} key: this is the progress value supplied to
 * {@link android.app.Notification.Builder#setProgress(int,int,boolean) Builder#setProgress(int, int, boolean)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PROGRESS = "android.progress";

/**
 * {@link #extras} key: whether the progress bar is indeterminate, supplied to
 * {@link android.app.Notification.Builder#setProgress(int,int,boolean) Builder#setProgress(int, int, boolean)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";

/**
 * {@link #extras} key: this is the maximum value supplied to
 * {@link android.app.Notification.Builder#setProgress(int,int,boolean) Builder#setProgress(int, int, boolean)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PROGRESS_MAX = "android.progressMax";

/**
 * If the notification contained an unsent draft for a RemoteInput when the user clicked on it,
 * we're adding the draft as a String extra to the {@link #contentIntent} using this key.
 *
 * <p>Apps may use this extra to prepopulate text fields in the app, where the user usually
 * sends messages.</p>
 * @apiSince 28
 */

public static final java.lang.String EXTRA_REMOTE_INPUT_DRAFT = "android.remoteInputDraft";

/**
 * {@link #extras} key: this is the remote input history, as supplied to
 * {@link android.app.Notification.Builder#setRemoteInputHistory(java.lang.CharSequence[]) Builder#setRemoteInputHistory(CharSequence[])}.
 *
 * Apps can fill this through {@link android.app.Notification.Builder#setRemoteInputHistory(java.lang.CharSequence[]) Builder#setRemoteInputHistory(CharSequence[])}
 * with the most recent inputs that have been sent through a {@link android.app.RemoteInput RemoteInput} of this
 * Notification and are expected to clear it once the it is no longer relevant (e.g. for chat
 * notifications once the other party has responded).
 *
 * The extra with this key is of type CharSequence[] and contains the most recent entry at
 * the 0 index, the second most recent at the 1 index, etc.
 *
 * @see android.app.Notification.Builder#setRemoteInputHistory(CharSequence[])
 * @apiSince 24
 */

public static final java.lang.String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";

/**
 * {@link #extras} key: the username to be displayed for all messages sent by the user including
 * direct replies
 * {@link android.app.Notification.MessagingStyle} notification. This extra is a
 * {@link java.lang.CharSequence CharSequence}
 *
 * @deprecated use {@link #EXTRA_MESSAGING_PERSON}
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";

/**
 * {@link #extras} key: whether {@link #when} should be shown as a count-up timer (specifically
 * a {@link android.widget.Chronometer}) instead of a timestamp, as supplied to
 * {@link android.app.Notification.Builder#setUsesChronometer(boolean) Builder#setUsesChronometer(boolean)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";

/**
 * {@link #extras} key: whether {@link #when} should be shown,
 * as supplied to {@link android.app.Notification.Builder#setShowWhen(boolean) Builder#setShowWhen(boolean)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_SHOW_WHEN = "android.showWhen";

/**
 * {@link #extras} key: this is the resource ID of the notification's main small icon, as
 * supplied to {@link android.app.Notification.Builder#setSmallIcon(int) Builder#setSmallIcon(int)}.
 *
 * @deprecated Use {@link #getSmallIcon()}, which supports a wider variety of icon sources.
 * @apiSince 19
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String EXTRA_SMALL_ICON = "android.icon";

/**
 * {@link #extras} key: this is a third line of text, as supplied to
 * {@link android.app.Notification.Builder#setSubText(java.lang.CharSequence) Builder#setSubText(CharSequence)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_SUB_TEXT = "android.subText";

/**
 * {@link #extras} key: this is a line of summary information intended to be shown
 * alongside expanded notifications, as supplied to (e.g.)
 * {@link android.app.Notification.BigTextStyle#setSummaryText(java.lang.CharSequence) BigTextStyle#setSummaryText(CharSequence)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_SUMMARY_TEXT = "android.summaryText";

/**
 * {@link #extras} key: A string representing the name of the specific
 * {@link android.app.Notification.Style} used to create this notification.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_TEMPLATE = "android.template";

/**
 * {@link #extras} key: this is the main text payload, as supplied to
 * {@link android.app.Notification.Builder#setContentText(java.lang.CharSequence) Builder#setContentText(CharSequence)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_TEXT = "android.text";

/**
 * {@link #extras} key: An array of CharSequences to show in {@link android.app.Notification.InboxStyle InboxStyle} expanded
 * notifications, each of which was supplied to {@link android.app.Notification.InboxStyle#addLine(java.lang.CharSequence) InboxStyle#addLine(CharSequence)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_TEXT_LINES = "android.textLines";

/**
 * {@link #extras} key: this is the title of the notification,
 * as supplied to {@link android.app.Notification.Builder#setContentTitle(java.lang.CharSequence) Builder#setContentTitle(CharSequence)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_TITLE = "android.title";

/**
 * {@link #extras} key: this is the title of the notification when shown in expanded form,
 * e.g.&nbsp;as supplied to {@link android.app.Notification.BigTextStyle#setBigContentTitle(java.lang.CharSequence) BigTextStyle#setBigContentTitle(CharSequence)}.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_TITLE_BIG = "android.title.big";

/**
 * Bit to be bitwise-ored into the {@link #flags} field that should be
 * set if the notification should be canceled when it is clicked by the
 * user.
 * @apiSince 1
 */

public static final int FLAG_AUTO_CANCEL = 16; // 0x10

/**
 * Bit to be bitswised-ored into the {@link #flags} field that should be
 * set by the system if this notification is showing as a bubble.
 *
 * Applications cannot set this flag directly; they should instead call
 * {@link android.app.Notification.Builder#setBubbleMetadata(android.app.Notification.BubbleMetadata) Notification.Builder#setBubbleMetadata(BubbleMetadata)} to
 * request that a notification be displayed as a bubble, and then check
 * this flag to see whether that request was honored by the system.
 * @apiSince 29
 */

public static final int FLAG_BUBBLE = 4096; // 0x1000

/**
 * Bit to be bitwise-ored into the {@link #flags} field that should be
 * set if this notification represents a currently running service.  This
 * will normally be set for you by {@link android.app.Service#startForeground Service#startForeground}.
 * @apiSince 5
 */

public static final int FLAG_FOREGROUND_SERVICE = 64; // 0x40

/**
 * Bit to be bitswise-ored into the {@link #flags} field that should be
 * set if this notification is the group summary for a group of notifications.
 * Grouped notifications may display in a cluster or stack on devices which
 * support such rendering. Requires a group key also be set using {@link android.app.Notification.Builder#setGroup Builder#setGroup}.
 * @apiSince 20
 */

public static final int FLAG_GROUP_SUMMARY = 512; // 0x200

/**
 * Obsolete flag indicating high-priority notifications; use the priority field instead.
 *
 * @deprecated Use {@link #priority} with a positive value.
 * @apiSince 11
 * @deprecatedSince 16
 */

@Deprecated public static final int FLAG_HIGH_PRIORITY = 128; // 0x80

/**
 * Bit to be bitwise-ored into the {@link #flags} field that if set,
 * the audio will be repeated until the notification is
 * cancelled or the notification window is opened.
 * @apiSince 1
 */

public static final int FLAG_INSISTENT = 4; // 0x4

/**
 * Bit to be bitswise-ored into the {@link #flags} field that should be
 * set if this notification is relevant to the current device only
 * and it is not recommended that it bridge to other devices.
 * @apiSince 20
 */

public static final int FLAG_LOCAL_ONLY = 256; // 0x100

/**
 * Bit to be bitwise-ored into the {@link #flags} field that should be
 * set if the notification should not be canceled when the user clicks
 * the Clear all button.
 * @apiSince 1
 */

public static final int FLAG_NO_CLEAR = 32; // 0x20

/**
 * Bit to be bitwise-ored into the {@link #flags} field that should be
 * set if this notification is in reference to something that is ongoing,
 * like a phone call.  It should not be set if this notification is in
 * reference to something that happened at a particular point in time,
 * like a missed phone call.
 * @apiSince 1
 */

public static final int FLAG_ONGOING_EVENT = 2; // 0x2

/**
 * Bit to be bitwise-ored into the {@link #flags} field that should be
 * set if you would only like the sound, vibrate and ticker to be played
 * if the notification was not already showing.
 * @apiSince 1
 */

public static final int FLAG_ONLY_ALERT_ONCE = 8; // 0x8

/**
 * Bit to be bitwise-ored into the {@link #flags} field that should be
 * set if you want the LED on for this notification.
 * <ul>
 * <li>To turn the LED off, pass 0 in the alpha channel for colorARGB
 *      or 0 for both ledOnMS and ledOffMS.</li>
 * <li>To turn the LED on, pass 1 for ledOnMS and 0 for ledOffMS.</li>
 * <li>To flash the LED, pass the number of milliseconds that it should
 *      be on and off to ledOnMS and ledOffMS.</li>
 * </ul>
 * <p>
 * Since hardware varies, you are not guaranteed that any of the values
 * you pass are honored exactly.  Use the system defaults if possible
 * because they will be set to values that work on any given hardware.
 * <p>
 * The alpha channel must be set for forward compatibility.
 *
 * @deprecated use {@link android.app.NotificationChannel#shouldShowLights() NotificationChannel#shouldShowLights()}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final int FLAG_SHOW_LIGHTS = 1; // 0x1

/**
 * Constant for {@link android.app.Notification.Builder#setGroupAlertBehavior(int) Builder#setGroupAlertBehavior(int)}, meaning that all notifications in a
 * group with sound or vibration ought to make sound or vibrate (respectively), so this
 * notification will not be muted when it is in a group.
 * @apiSince 26
 */

public static final int GROUP_ALERT_ALL = 0; // 0x0

/**
 * Constant for {@link android.app.Notification.Builder#setGroupAlertBehavior(int) Builder#setGroupAlertBehavior(int)}, meaning that the summary
 * notification in a group should be silenced (no sound or vibration) even if they are
 * posted to a {@link android.app.NotificationChannel NotificationChannel} that has sound and/or vibration. Use this constant
 * to mute this notification if this notification is a group summary.
 *
 * <p>For example, you might want to use this constant if only the children notifications
 * in your group have content and the summary is only used to visually group notifications
 * rather than to alert the user that new information is available.
 * @apiSince 26
 */

public static final int GROUP_ALERT_CHILDREN = 2; // 0x2

/**
 * Constant for {@link android.app.Notification.Builder#setGroupAlertBehavior(int) Builder#setGroupAlertBehavior(int)}, meaning that all children
 * notification in a group should be silenced (no sound or vibration) even if they are posted
 * to a {@link android.app.NotificationChannel NotificationChannel} that has sound and/or vibration. Use this constant to
 * mute this notification if this notification is a group child. This must be applied to all
 * children notifications you want to mute.
 *
 * <p> For example, you might want to use this constant if you post a number of children
 * notifications at once (say, after a periodic sync), and only need to notify the user
 * audibly once.
 * @apiSince 26
 */

public static final int GROUP_ALERT_SUMMARY = 1; // 0x1

/**
 * An activity that provides a user interface for adjusting notification preferences for its
 * containing application.
 * @apiSince 21
 */

public static final java.lang.String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";

/**
 * Default notification {@link #priority}. If your application does not prioritize its own
 * notifications, use this value for all notifications.
 *
 * @deprecated use {@link android.app.NotificationManager#IMPORTANCE_DEFAULT NotificationManager#IMPORTANCE_DEFAULT} instead.
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated public static final int PRIORITY_DEFAULT = 0; // 0x0

/**
 * Higher {@link #priority}, for more important notifications or alerts. The UI may choose to
 * show these items larger, or at a different position in notification lists, compared with
 * your app's {@link #PRIORITY_DEFAULT} items.
 *
 * @deprecated use {@link android.app.NotificationManager#IMPORTANCE_HIGH NotificationManager#IMPORTANCE_HIGH} instead.
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated public static final int PRIORITY_HIGH = 1; // 0x1

/**
 * Lower {@link #priority}, for items that are less important. The UI may choose to show these
 * items smaller, or at a different position in the list, compared with your app's
 * {@link #PRIORITY_DEFAULT} items.
 *
 * @deprecated use {@link android.app.NotificationManager#IMPORTANCE_LOW NotificationManager#IMPORTANCE_LOW} instead.
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated public static final int PRIORITY_LOW = -1; // 0xffffffff

/**
 * Highest {@link #priority}, for your application's most important items that require the
 * user's prompt attention or input.
 *
 * @deprecated use {@link android.app.NotificationManager#IMPORTANCE_HIGH NotificationManager#IMPORTANCE_HIGH} instead.
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated public static final int PRIORITY_MAX = 2; // 0x2

/**
 * Lowest {@link #priority}; these items might not be shown to the user except under special
 * circumstances, such as detailed notification logs.
 *
 * @deprecated use {@link android.app.NotificationManager#IMPORTANCE_MIN NotificationManager#IMPORTANCE_MIN} instead.
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated public static final int PRIORITY_MIN = -2; // 0xfffffffe

/**
 * Use this constant as the value for audioStreamType to request that
 * the default stream type for notifications be used.  Currently the
 * default stream type is {@link android.media.AudioManager#STREAM_NOTIFICATION AudioManager#STREAM_NOTIFICATION}.
 *
 * @deprecated Use {@link android.app.NotificationChannel#getAudioAttributes() NotificationChannel#getAudioAttributes()} instead.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated public static final int STREAM_DEFAULT = -1; // 0xffffffff

/**
 * Notification visibility: Show this notification on all lockscreens, but conceal sensitive or
 * private information on secure lockscreens.
 *
 * {@see #visibility}
 * @apiSince 21
 */

public static final int VISIBILITY_PRIVATE = 0; // 0x0

/**
 * Notification visibility: Show this notification in its entirety on all lockscreens.
 *
 * {@see #visibility}
 * @apiSince 21
 */

public static final int VISIBILITY_PUBLIC = 1; // 0x1

/**
 * Notification visibility: Do not reveal any part of this notification on a secure lockscreen.
 *
 * {@see #visibility}
 * @apiSince 21
 */

public static final int VISIBILITY_SECRET = -1; // 0xffffffff

/**
 * Array of all {@link android.app.Notification.Action Action} structures attached to this notification by
 * {@link android.app.Notification.Builder#addAction(int,java.lang.CharSequence,android.app.PendingIntent) Builder#addAction(int, CharSequence, PendingIntent)}. Mostly useful for instances of
 * {@link android.service.notification.NotificationListenerService} that provide an alternative
 * interface for invoking actions.
 * @apiSince 19
 */

public android.app.Notification.Action[] actions;

/**
 * The {@link android.media.AudioAttributes AudioAttributes} to use when playing the sound.
 *
 * @deprecated use {@link android.app.NotificationChannel#getAudioAttributes() NotificationChannel#getAudioAttributes()} instead.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated public android.media.AudioAttributes audioAttributes;

/**
 * The audio stream type to use when playing the sound.
 * Should be one of the STREAM_ constants from
 * {@link android.media.AudioManager}.
 *
 * @deprecated Use {@link #audioAttributes} instead.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated public int audioStreamType = -1; // 0xffffffff

/**
 * A large-format version of {@link #contentView}, giving the Notification an
 * opportunity to show more detail. The system UI may choose to show this
 * instead of the normal content view at its discretion.
 *
 * As of N, this field may be null. The expanded notification view is determined by the
 * inputs to {@link android.app.Notification.Builder Notification.Builder}; a custom RemoteViews can optionally be
 * supplied with {@link android.app.Notification.Builder#setCustomBigContentView(android.widget.RemoteViews) Notification.Builder#setCustomBigContentView(RemoteViews)}.
 * @apiSince 16
 * @deprecatedSince 24
 */

@Deprecated public android.widget.RemoteViews bigContentView;

/**
 * One of the predefined notification categories (see the <code>CATEGORY_*</code> constants)
 * that best describes this Notification.  May be used by the system for ranking and filtering.
 * @apiSince 21
 */

public java.lang.String category;

/**
 * Accent color (an ARGB integer like the constants in {@link android.graphics.Color})
 * to be applied by the standard Style templates when presenting this notification.
 *
 * The current template design constructs a colorful header image by overlaying the
 * {@link #icon} image (stenciled in white) atop a field of this color. Alpha components are
 * ignored.
 * @apiSince 21
 */

public int color = 0; // 0x0

/**
 * The intent to execute when the expanded status entry is clicked.  If
 * this is an activity, it must include the
 * {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK} flag, which requires
 * that you take care of task management as described in the
 * <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and Back
 * Stack</a> document.  In particular, make sure to read the notification section
 * <a href="{@docRoot}guide/topics/ui/notifiers/notifications.html#HandlingNotifications">Handling
 * Notifications</a> for the correct ways to launch an application from a
 * notification.
 * @apiSince 1
 */

public android.app.PendingIntent contentIntent;

/**
 * The view that will represent this notification in the notification list (which is pulled
 * down from the status bar).
 *
 * As of N, this field may be null. The notification view is determined by the inputs
 * to {@link android.app.Notification.Builder Notification.Builder}; a custom RemoteViews can optionally be
 * supplied with {@link android.app.Notification.Builder#setCustomContentView(android.widget.RemoteViews) Notification.Builder#setCustomContentView(RemoteViews)}.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public android.widget.RemoteViews contentView;

/**
 * Specifies which values should be taken from the defaults.
 * <p>
 * To set, OR the desired from {@link #DEFAULT_SOUND},
 * {@link #DEFAULT_VIBRATE}, {@link #DEFAULT_LIGHTS}. For all default
 * values, use {@link #DEFAULT_ALL}.
 * </p>
 *
 * @deprecated use {@link android.app.NotificationChannel#getSound() NotificationChannel#getSound()} and
 * {@link android.app.NotificationChannel#shouldShowLights() NotificationChannel#shouldShowLights()} and
 * {@link android.app.NotificationChannel#shouldVibrate() NotificationChannel#shouldVibrate()}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public int defaults;

/**
 * The intent to execute when the notification is explicitly dismissed by the user, either with
 * the "Clear All" button or by swiping it away individually.
 *
 * This probably shouldn't be launching an activity since several of those will be sent
 * at the same time.
 * @apiSince 1
 */

public android.app.PendingIntent deleteIntent;

/**
 * Additional semantic data to be carried around with this Notification.
 * <p>
 * The extras keys defined here are intended to capture the original inputs to {@link android.app.Notification.Builder Builder}
 * APIs, and are intended to be used by
 * {@link android.service.notification.NotificationListenerService} implementations to extract
 * detailed information from notification objects.
 * @apiSince 19
 */

public android.os.Bundle extras;

/** @apiSince 1 */

public int flags;

/**
 * An intent to launch instead of posting the notification to the status bar.
 *
 * <p>
 * The system UI may choose to display a heads-up notification, instead of
 * launching this intent, while the user is using the device.
 * </p>
 *
 * @see android.app.Notification.Builder#setFullScreenIntent
 * @apiSince 9
 */

public android.app.PendingIntent fullScreenIntent;

/**
 * A medium-format version of {@link #contentView}, providing the Notification an
 * opportunity to add action buttons to contentView. At its discretion, the system UI may
 * choose to show this as a heads-up notification, which will pop up so the user can see
 * it without leaving their current activity.
 *
 * As of N, this field may be null. The heads-up notification view is determined by the
 * inputs to {@link android.app.Notification.Builder Notification.Builder}; a custom RemoteViews can optionally be
 * supplied with {@link android.app.Notification.Builder#setCustomHeadsUpContentView(android.widget.RemoteViews) Notification.Builder#setCustomHeadsUpContentView(RemoteViews)}.
 * @apiSince 21
 * @deprecatedSince 24
 */

@Deprecated public android.widget.RemoteViews headsUpContentView;

/**
 * The resource id of a drawable to use as the icon in the status bar.
 *
 * @deprecated Use {@link android.app.Notification.Builder#setSmallIcon(android.graphics.drawable.Icon) Builder#setSmallIcon(Icon)} instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated public int icon;

/**
 * If the icon in the status bar is to have more than one level, you can set this.  Otherwise,
 * leave it at its default value of 0.
 *
 * @see android.widget.ImageView#setImageLevel
 * @see android.graphics.drawable.Drawable#setLevel
 * @apiSince 1
 */

public int iconLevel;

/**
 * A large bitmap to be shown in the notification content area.
 *
 * @deprecated Use {@link android.app.Notification.Builder#setLargeIcon(android.graphics.drawable.Icon) Builder#setLargeIcon(Icon)} instead.
 * @apiSince 11
 * @deprecatedSince 23
 */

@Deprecated public android.graphics.Bitmap largeIcon;

/**
 * The color of the led.  The hardware will do its best approximation.
 *
 * @see #FLAG_SHOW_LIGHTS
 * @see #flags
 * @deprecated use {@link android.app.NotificationChannel#shouldShowLights() NotificationChannel#shouldShowLights()}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public int ledARGB;

/**
 * The number of milliseconds for the LED to be off while it's flashing.
 * The hardware will do its best approximation.
 *
 * @see #FLAG_SHOW_LIGHTS
 * @see #flags
 *
 * @deprecated use {@link android.app.NotificationChannel#shouldShowLights() NotificationChannel#shouldShowLights()}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public int ledOffMS;

/**
 * The number of milliseconds for the LED to be on while it's flashing.
 * The hardware will do its best approximation.
 *
 * @see #FLAG_SHOW_LIGHTS
 * @see #flags
 * @deprecated use {@link android.app.NotificationChannel#shouldShowLights() NotificationChannel#shouldShowLights()}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public int ledOnMS;

/**
 * The number of events that this notification represents. For example, in a new mail
 * notification, this could be the number of unread messages.
 *
 * The system may or may not use this field to modify the appearance of the notification.
 * Starting with {@link android.os.Build.VERSION_CODES#O}, the number may be displayed as a
 * badge icon in Launchers that support badging.
 * @apiSince 1
 * @deprecatedSince 24
 */

public int number = 0; // 0x0

/**
 * Relative priority for this notification.
 *
 * Priority is an indication of how much of the user's valuable attention should be consumed by
 * this notification. Low-priority notifications may be hidden from the user in certain
 * situations, while the user might be interrupted for a higher-priority notification. The
 * system will make a determination about how to interpret this priority when presenting
 * the notification.
 *
 * <p>
 * A notification that is at least {@link #PRIORITY_HIGH} is more likely to be presented
 * as a heads-up notification.
 * </p>
 *
 * <br>
 * Value is {@link android.app.Notification#PRIORITY_DEFAULT}, {@link android.app.Notification#PRIORITY_LOW}, {@link android.app.Notification#PRIORITY_MIN}, {@link android.app.Notification#PRIORITY_HIGH}, or {@link android.app.Notification#PRIORITY_MAX}
 * @deprecated use {@link android.app.NotificationChannel#getImportance() NotificationChannel#getImportance()} instead.
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated public int priority;

/**
 * Replacement version of this notification whose content will be shown
 * in an insecure context such as atop a secure keyguard. See {@link #visibility}
 * and {@link #VISIBILITY_PUBLIC}.
 * @apiSince 21
 */

public android.app.Notification publicVersion;

/**
 * The sound to play.
 *
 * <p>
 * A notification that is noisy is more likely to be presented as a heads-up notification.
 * </p>
 *
 * <p>
 * To play the default notification sound, see {@link #defaults}.
 * </p>
 * @deprecated use {@link android.app.NotificationChannel#getSound() NotificationChannel#getSound()}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public android.net.Uri sound;

/**
 * Text that summarizes this notification for accessibility services.
 *
 * As of the L release, this text is no longer shown on screen, but it is still useful to
 * accessibility services (where it serves as an audible announcement of the notification's
 * appearance).
 *
 * @see #tickerView
 * @apiSince 1
 */

public java.lang.CharSequence tickerText;

/**
 * Formerly, a view showing the {@link #tickerText}.
 *
 * No longer displayed in the status bar as of API 21.
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated public android.widget.RemoteViews tickerView;

/**
 * The pattern with which to vibrate.
 *
 * <p>
 * To vibrate the default pattern, see {@link #defaults}.
 * </p>
 *
 * @see android.os.Vibrator#vibrate(long[],int)
 * @deprecated use {@link android.app.NotificationChannel#getVibrationPattern() NotificationChannel#getVibrationPattern()}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public long[] vibrate;

/**
 * Sphere of visibility of this notification, which affects how and when the SystemUI reveals
 * the notification's presence and contents in untrusted situations (namely, on the secure
 * lockscreen).
 *
 * The default level, {@link #VISIBILITY_PRIVATE}, behaves exactly as notifications have always
 * done on Android: The notification's {@link #icon} and {@link #tickerText} (if available) are
 * shown in all situations, but the contents are only available if the device is unlocked for
 * the appropriate user.
 *
 * A more permissive policy can be expressed by {@link #VISIBILITY_PUBLIC}; such a notification
 * can be read even in an "insecure" context (that is, above a secure lockscreen).
 * To modify the public version of this notification—for example, to redact some portions—see
 * {@link android.app.Notification.Builder#setPublicVersion(android.app.Notification) Builder#setPublicVersion(Notification)}.
 *
 * Finally, a notification can be made {@link #VISIBILITY_SECRET}, which will suppress its icon
 * and ticker until the user has bypassed the lockscreen.
 
 * <br>
 * Value is {@link android.app.Notification#VISIBILITY_PUBLIC}, {@link android.app.Notification#VISIBILITY_PRIVATE}, or {@link android.app.Notification#VISIBILITY_SECRET}
 * @apiSince 21
 */

public int visibility;

/**
 * A timestamp related to this notification, in milliseconds since the epoch.
 *
 * Default value: {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 *
 * Choose a timestamp that will be most relevant to the user. For most finite events, this
 * corresponds to the time the event happened (or will happen, in the case of events that have
 * yet to occur but about which the user is being informed). Indefinite events should be
 * timestamped according to when the activity began.
 *
 * Some examples:
 *
 * <ul>
 *   <li>Notification of a new chat message should be stamped when the message was received.</li>
 *   <li>Notification of an ongoing file download (with a progress bar, for example) should be stamped when the download started.</li>
 *   <li>Notification of a completed file download should be stamped when the download finished.</li>
 *   <li>Notification of an upcoming meeting should be stamped with the time the meeting will begin (that is, in the future).</li>
 *   <li>Notification of an ongoing stopwatch (increasing timer) should be stamped with the watch's start time.
 *   <li>Notification of an ongoing countdown timer should be stamped with the timer's end time.
 * </ul>
 *
 * For apps targeting {@link android.os.Build.VERSION_CODES#N} and above, this time is not shown
 * anymore by default and must be opted into by using
 * {@link android.app.Notification.Builder#setShowWhen(boolean)}
 * @apiSince 1
 */

public long when;
/**
 * Structure to encapsulate a named action that can be shown as part of this notification.
 * It must include an icon, a label, and a {@link android.app.PendingIntent PendingIntent} to be fired when the action is
 * selected by the user.
 * <p>
 * Apps should use {@link android.app.Notification.Builder#addAction(int,java.lang.CharSequence,android.app.PendingIntent) Notification.Builder#addAction(int, CharSequence, PendingIntent)}
 * or {@link android.app.Notification.Builder#addAction(android.app.Notification.Action) Notification.Builder#addAction(Notification.Action)}
 * to attach actions.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Action implements android.os.Parcelable {

/**
 * @deprecated Use {@link android.app.Notification.Action.Builder}.
 * @apiSince 19
 */

@Deprecated
public Action(int icon, java.lang.CharSequence title, android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Return an icon representing the action.
 * @apiSince 23
 */

public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Get additional metadata carried around with this Action.
 * @apiSince 20
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the platform should automatically generate possible replies for this
 * {@link android.app.Notification.Action Action}
 * @apiSince 24
 */

public boolean getAllowGeneratedReplies() { throw new RuntimeException("Stub!"); }

/**
 * Get the list of inputs to be collected from the user when this action is sent.
 * May return null if no remote inputs were added. Only returns inputs which accept
 * a text input. For inputs which only accept data use {@link #getDataOnlyRemoteInputs}.
 * @apiSince 20
 */

public android.app.RemoteInput[] getRemoteInputs() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code SemanticAction} associated with this {@link android.app.Notification.Action Action}. A
 * {@code SemanticAction} denotes what an {@link android.app.Notification.Action Action}'s {@link android.app.PendingIntent PendingIntent} will do
 * (eg. reply, mark as read, delete, etc).
 
 * @return Value is {@link android.app.Notification.Action#SEMANTIC_ACTION_NONE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_REPLY}, {@link android.app.Notification.Action#SEMANTIC_ACTION_MARK_AS_READ}, {@link android.app.Notification.Action#SEMANTIC_ACTION_MARK_AS_UNREAD}, {@link android.app.Notification.Action#SEMANTIC_ACTION_DELETE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_ARCHIVE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_MUTE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_UNMUTE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_THUMBS_UP}, {@link android.app.Notification.Action#SEMANTIC_ACTION_THUMBS_DOWN}, or {@link android.app.Notification.Action#SEMANTIC_ACTION_CALL}
 * @apiSince 28
 */

public int getSemanticAction() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this is a contextual Action, i.e. whether the action is dependent on the
 * notification message body. An example of a contextual action could be an action opening a
 * map application with an address shown in the notification.
 * @apiSince 29
 */

public boolean isContextual() { throw new RuntimeException("Stub!"); }

/**
 * Get the list of inputs to be collected from the user that ONLY accept data when this
 * action is sent. These remote inputs are guaranteed to return true on a call to
 * {@link android.app.RemoteInput#isDataOnly RemoteInput#isDataOnly}.
 *
 * Returns null if there are no data-only remote inputs.
 *
 * This method exists so that legacy RemoteInput collectors that pre-date the addition
 * of non-textual RemoteInputs do not access these remote inputs.
 * @apiSince 26
 */

public android.app.RemoteInput[] getDataOnlyRemoteInputs() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.app.Notification.Action clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.Notification.Action> CREATOR;
static { CREATOR = null; }

/**
 * {@code SemanticAction}: Archive the content associated with the notification. This
 * could mean archiving an email, message, etc.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_ARCHIVE = 5; // 0x5

/**
 * {@code SemanticAction}: Call a contact, group, etc.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_CALL = 10; // 0xa

/**
 * {@code SemanticAction}: Delete the content associated with the notification. This
 * could mean deleting an email, message, etc.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_DELETE = 4; // 0x4

/**
 * {@code SemanticAction}: Mark content as read.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_MARK_AS_READ = 2; // 0x2

/**
 * {@code SemanticAction}: Mark content as unread.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3; // 0x3

/**
 * {@code SemanticAction}: Mute the content associated with the notification. This could
 * mean silencing a conversation or currently playing media.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_MUTE = 6; // 0x6

/**
 * {@link }: No semantic action defined.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_NONE = 0; // 0x0

/**
 * {@code SemanticAction}: Reply to a conversation, chat, group, or wherever replies
 * may be appropriate.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_REPLY = 1; // 0x1

/**
 * {@code SemanticAction}: Mark content with a thumbs down.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9; // 0x9

/**
 * {@code SemanticAction}: Mark content with a thumbs up.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_THUMBS_UP = 8; // 0x8

/**
 * {@code SemanticAction}: Unmute the content associated with the notification. This could
 * mean un-silencing a conversation or currently playing media.
 * @apiSince 28
 */

public static final int SEMANTIC_ACTION_UNMUTE = 7; // 0x7

/**
 * Intent to send when the user invokes this action. May be null, in which case the action
 * may be rendered in a disabled presentation by the system UI.
 * @apiSince 19
 */

public android.app.PendingIntent actionIntent;

/**
 * Small icon representing the action.
 *
 * @deprecated Use {@link android.app.Notification.Action#getIcon() Action#getIcon()} instead.
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated public int icon;

/**
 * Title of the action.
 * @apiSince 19
 */

public java.lang.CharSequence title;
/**
 * Builder class for {@link android.app.Notification.Action Action} objects.
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Construct a new builder for {@link android.app.Notification.Action Action} object.
 * @param icon icon to show for this action
 * @param title the title of the action
 * @param intent the {@link android.app.PendingIntent PendingIntent} to fire when users trigger this action
 * @apiSince 20
 */

@Deprecated
public Builder(int icon, java.lang.CharSequence title, android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Construct a new builder for {@link android.app.Notification.Action Action} object.
 * @param icon icon to show for this action
 * @param title the title of the action
 * @param intent the {@link android.app.PendingIntent PendingIntent} to fire when users trigger this action
 * @apiSince 23
 */

public Builder(android.graphics.drawable.Icon icon, java.lang.CharSequence title, android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Construct a new builder for {@link android.app.Notification.Action Action} object using the fields from an
 * {@link android.app.Notification.Action Action}.
 * @param action the action to read fields from.
 * @apiSince 20
 */

public Builder(android.app.Notification.Action action) { throw new RuntimeException("Stub!"); }

/**
 * Merge additional metadata into this builder.
 *
 * <p>Values within the Bundle will replace existing extras values in this Builder.
 *
 * @see android.app.Notification.Action#extras
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Action.Builder addExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Get the metadata Bundle used by this Builder.
 *
 * <p>The returned Bundle is shared with this Builder.
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Add an input to be collected from the user when this action is sent.
 * Response values can be retrieved from the fired intent by using the
 * {@link android.app.RemoteInput#getResultsFromIntent RemoteInput#getResultsFromIntent} function.
 * @param remoteInput a {@link android.app.RemoteInput RemoteInput} to add to the action
 * @return this object for method chaining
 
 * This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Action.Builder addRemoteInput(android.app.RemoteInput remoteInput) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the platform should automatically generate possible replies to add to
 * {@link android.app.RemoteInput#getChoices() RemoteInput#getChoices()}. If the {@link android.app.Notification.Action Action} doesn't have a
 * {@link android.app.RemoteInput RemoteInput}, this has no effect.
 * @param allowGeneratedReplies {@code true} to allow generated replies, {@code false}
 * otherwise
 * @return this object for method chaining
 * The default value is {@code true}
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Action.Builder setAllowGeneratedReplies(boolean allowGeneratedReplies) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@code SemanticAction} for this {@link android.app.Notification.Action Action}. A
 * {@code SemanticAction} denotes what an {@link android.app.Notification.Action Action}'s
 * {@link android.app.PendingIntent PendingIntent} will do (eg. reply, mark as read, delete, etc).
 * @param semanticAction a SemanticAction defined within {@link android.app.Notification.Action Action} with
 * {@code SEMANTIC_ACTION_} prefixes
 * Value is {@link android.app.Notification.Action#SEMANTIC_ACTION_NONE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_REPLY}, {@link android.app.Notification.Action#SEMANTIC_ACTION_MARK_AS_READ}, {@link android.app.Notification.Action#SEMANTIC_ACTION_MARK_AS_UNREAD}, {@link android.app.Notification.Action#SEMANTIC_ACTION_DELETE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_ARCHIVE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_MUTE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_UNMUTE}, {@link android.app.Notification.Action#SEMANTIC_ACTION_THUMBS_UP}, {@link android.app.Notification.Action#SEMANTIC_ACTION_THUMBS_DOWN}, or {@link android.app.Notification.Action#SEMANTIC_ACTION_CALL}
 * @return this object for method chaining
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Notification.Action.Builder setSemanticAction(int semanticAction) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this {@link android.app.Notification.Action Action} is a contextual action, i.e. whether the action is
 * dependent on the notification message body. An example of a contextual action could
 * be an action opening a map application with an address shown in the notification.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.Action.Builder setContextual(boolean isContextual) { throw new RuntimeException("Stub!"); }

/**
 * Apply an extender to this action builder. Extenders may be used to add
 * metadata or change options on this builder.
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Action.Builder extend(android.app.Notification.Action.Extender extender) { throw new RuntimeException("Stub!"); }

/**
 * Combine all of the options that have been set and return a new {@link android.app.Notification.Action Action}
 * object.
 * @return the built action
 
 * This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Action build() { throw new RuntimeException("Stub!"); }
}

/**
 * Extender interface for use with {@link android.app.Notification.Action.Builder#extend Builder#extend}. Extenders may be used to add
 * metadata or change options on an action builder.
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Extender {

/**
 * Apply this extender to a notification action builder.
 * @param builder the builder to be modified.
 * @return the build object for chaining.
 * @apiSince 20
 */

public android.app.Notification.Action.Builder extend(android.app.Notification.Action.Builder builder);
}

/**
 * Wearable extender for notification actions. To add extensions to an action,
 * create a new {@link android.app.Notification.Action.WearableExtender} object using
 * the {@code WearableExtender()} constructor and apply it to a
 * {@link android.app.Notification.Action.Builder} using
 * {@link android.app.Notification.Action.Builder#extend}.
 *
 * <pre class="prettyprint">
 * Notification.Action action = new Notification.Action.Builder(
 *         R.drawable.archive_all, "Archive all", actionIntent)
 *         .extend(new Notification.Action.WearableExtender()
 *                 .setAvailableOffline(false))
 *         .build();</pre>
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class WearableExtender implements android.app.Notification.Action.Extender {

/**
 * Create a {@link android.app.Notification.Action.WearableExtender} with default
 * options.
 * @apiSince 20
 */

public WearableExtender() { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.app.Notification.Action.WearableExtender} by reading
 * wearable options present in an existing notification action.
 * @param action the notification action to inspect.
 * @apiSince 20
 */

public WearableExtender(android.app.Notification.Action action) { throw new RuntimeException("Stub!"); }

/**
 * Apply wearable extensions to a notification action that is being built. This is
 * typically called by the {@link android.app.Notification.Action.Builder#extend}
 * method of {@link android.app.Notification.Action.Builder}.
 * @apiSince 20
 */

public android.app.Notification.Action.Builder extend(android.app.Notification.Action.Builder builder) { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public android.app.Notification.Action.WearableExtender clone() { throw new RuntimeException("Stub!"); }

/**
 * Set whether this action is available when the wearable device is not connected to
 * a companion device. The user can still trigger this action when the wearable device is
 * offline, but a visual hint will indicate that the action may not be available.
 * Defaults to true.
 * @apiSince 20
 */

public android.app.Notification.Action.WearableExtender setAvailableOffline(boolean availableOffline) { throw new RuntimeException("Stub!"); }

/**
 * Get whether this action is available when the wearable device is not connected to
 * a companion device. The user can still trigger this action when the wearable device is
 * offline, but a visual hint will indicate that the action may not be available.
 * Defaults to true.
 * @apiSince 20
 */

public boolean isAvailableOffline() { throw new RuntimeException("Stub!"); }

/**
 * Set a label to display while the wearable is preparing to automatically execute the
 * action. This is usually a 'ing' verb ending in ellipsis like "Sending..."
 *
 * @param label the label to display while the action is being prepared to execute
 * @return this object for method chaining
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.Action.WearableExtender setInProgressLabel(java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Get the label to display while the wearable is preparing to automatically execute
 * the action. This is usually a 'ing' verb ending in ellipsis like "Sending..."
 *
 * @return the label to display while the action is being prepared to execute
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.CharSequence getInProgressLabel() { throw new RuntimeException("Stub!"); }

/**
 * Set a label to display to confirm that the action should be executed.
 * This is usually an imperative verb like "Send".
 *
 * @param label the label to confirm the action should be executed
 * @return this object for method chaining
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.Action.WearableExtender setConfirmLabel(java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Get the label to display to confirm that the action should be executed.
 * This is usually an imperative verb like "Send".
 *
 * @return the label to confirm the action should be executed
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.CharSequence getConfirmLabel() { throw new RuntimeException("Stub!"); }

/**
 * Set a label to display to cancel the action.
 * This is usually an imperative verb, like "Cancel".
 *
 * @param label the label to display to cancel the action
 * @return this object for method chaining
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.Action.WearableExtender setCancelLabel(java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Get the label to display to cancel the action.
 * This is usually an imperative verb like "Cancel".
 *
 * @return the label to display to cancel the action
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.CharSequence getCancelLabel() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint that this Action will launch an {@link android.app.Activity Activity} directly, telling the
 * platform that it can generate the appropriate transitions.
 * @param hintLaunchesActivity {@code true} if the content intent will launch
 * an activity and transitions should be generated, false otherwise.
 * @return this object for method chaining
 * @apiSince 24
 */

public android.app.Notification.Action.WearableExtender setHintLaunchesActivity(boolean hintLaunchesActivity) { throw new RuntimeException("Stub!"); }

/**
 * Get a hint that this Action will launch an {@link android.app.Activity Activity} directly, telling the
 * platform that it can generate the appropriate transitions
 * @return {@code true} if the content intent will launch an activity and transitions
 * should be generated, false otherwise. The default value is {@code false} if this was
 * never set.
 * @apiSince 24
 */

public boolean getHintLaunchesActivity() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint that this Action should be displayed inline.
 *
 * @param hintDisplayInline {@code true} if action should be displayed inline, false
 *        otherwise
 * @return this object for method chaining
 * @apiSince 25
 */

public android.app.Notification.Action.WearableExtender setHintDisplayActionInline(boolean hintDisplayInline) { throw new RuntimeException("Stub!"); }

/**
 * Get a hint that this Action should be displayed inline.
 *
 * @return {@code true} if the Action should be displayed inline, {@code false}
 *         otherwise. The default value is {@code false} if this was never set.
 * @apiSince 25
 */

public boolean getHintDisplayActionInline() { throw new RuntimeException("Stub!"); }
}

}

/**
 * Helper class for generating large-format notifications that include a large image attachment.
 *
 * Here's how you'd set the <code>BigPictureStyle</code> on a notification:
 * <pre class="prettyprint">
 * Notification notif = new Notification.Builder(mContext)
 *     .setContentTitle(&quot;New photo from &quot; + sender.toString())
 *     .setContentText(subject)
 *     .setSmallIcon(R.drawable.new_post)
 *     .setLargeIcon(aBitmap)
 *     .setStyle(new Notification.BigPictureStyle()
 *         .bigPicture(aBigBitmap))
 *     .build();
 * </pre>
 *
 * @see android.app.Notification#bigContentView
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class BigPictureStyle extends android.app.Notification.Style {

/** @apiSince 16 */

public BigPictureStyle() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@code BigPictureStyle()}.
 * @apiSince 16
 */

@Deprecated
public BigPictureStyle(android.app.Notification.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * Overrides ContentTitle in the big form of the template.
 * This defaults to the value passed to setContentTitle().
 * @apiSince 16
 */

public android.app.Notification.BigPictureStyle setBigContentTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the first line of text after the detail section in the big form of the template.
 * @apiSince 16
 */

public android.app.Notification.BigPictureStyle setSummaryText(java.lang.CharSequence cs) { throw new RuntimeException("Stub!"); }

/**
 * Provide the bitmap to be used as the payload for the BigPicture notification.
 * @apiSince 16
 */

public android.app.Notification.BigPictureStyle bigPicture(android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * Override the large icon when the big notification is shown.
 * @apiSince 16
 */

public android.app.Notification.BigPictureStyle bigLargeIcon(android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * Override the large icon when the big notification is shown.
 * @apiSince 23
 */

public android.app.Notification.BigPictureStyle bigLargeIcon(android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }
}

/**
 * Helper class for generating large-format notifications that include a lot of text.
 *
 * Here's how you'd set the <code>BigTextStyle</code> on a notification:
 * <pre class="prettyprint">
 * Notification notif = new Notification.Builder(mContext)
 *     .setContentTitle(&quot;New mail from &quot; + sender.toString())
 *     .setContentText(subject)
 *     .setSmallIcon(R.drawable.new_mail)
 *     .setLargeIcon(aBitmap)
 *     .setStyle(new Notification.BigTextStyle()
 *         .bigText(aVeryLongString))
 *     .build();
 * </pre>
 *
 * @see android.app.Notification#bigContentView
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class BigTextStyle extends android.app.Notification.Style {

/** @apiSince 16 */

public BigTextStyle() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@code BigTextStyle()}.
 * @apiSince 16
 */

@Deprecated
public BigTextStyle(android.app.Notification.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * Overrides ContentTitle in the big form of the template.
 * This defaults to the value passed to setContentTitle().
 * @apiSince 16
 */

public android.app.Notification.BigTextStyle setBigContentTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the first line of text after the detail section in the big form of the template.
 * @apiSince 16
 */

public android.app.Notification.BigTextStyle setSummaryText(java.lang.CharSequence cs) { throw new RuntimeException("Stub!"); }

/**
 * Provide the longer text to be displayed in the big form of the
 * template in place of the content text.
 * @apiSince 16
 */

public android.app.Notification.BigTextStyle bigText(java.lang.CharSequence cs) { throw new RuntimeException("Stub!"); }
}

/**
 * Encapsulates the information needed to display a notification as a bubble.
 *
 * <p>A bubble is used to display app content in a floating window over the existing
 * foreground activity. A bubble has a collapsed state represented by an icon,
 * {@link BubbleMetadata.Builder#setIcon(Icon)} and an expanded state which is populated
 * via {@link BubbleMetadata.Builder#setIntent(PendingIntent)}.</p>
 *
 * <b>Notifications with a valid and allowed bubble will display in collapsed state
 * outside of the notification shade on unlocked devices. When a user interacts with the
 * collapsed bubble, the bubble intent will be invoked and displayed.</b>
 *
 * @see android.app.Notification.Builder#setBubbleMetadata(BubbleMetadata)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class BubbleMetadata implements android.os.Parcelable {

private BubbleMetadata() { throw new RuntimeException("Stub!"); }

/**
 * @return the pending intent used to populate the floating window for this bubble.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.PendingIntent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * @return the pending intent to send when the bubble is dismissed by a user, if one exists.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.app.PendingIntent getDeleteIntent() { throw new RuntimeException("Stub!"); }

/**
 * @return the icon that will be displayed for this bubble when it is collapsed.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * @return the ideal height, in DPs, for the floating window that app content defined by
 * {@link #getIntent()} for this bubble. A value of 0 indicates a desired height has not
 * been set.
 * @apiSince 29
 */

public int getDesiredHeight() { throw new RuntimeException("Stub!"); }

/**
 * @return the resId of ideal height for the floating window that app content defined by
 * {@link #getIntent()} for this bubble. A value of 0 indicates a res value has not
 * been provided for the desired height.
 * @apiSince 29
 */

public int getDesiredHeightResId() { throw new RuntimeException("Stub!"); }

/**
 * @return whether this bubble should auto expand when it is posted.
 *
 * @see android.app.Notification.BubbleMetadata.Builder#setAutoExpandBubble(boolean)
 * @apiSince 29
 */

public boolean getAutoExpandBubble() { throw new RuntimeException("Stub!"); }

/**
 * @return whether this bubble should suppress the notification when it is posted.
 *
 * @see android.app.Notification.BubbleMetadata.Builder#setSuppressNotification(boolean)
 * @apiSince 29
 */

public boolean isNotificationSuppressed() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.Notification.BubbleMetadata> CREATOR;
static { CREATOR = null; }
/**
 * Builder to construct a {@link android.app.Notification.BubbleMetadata BubbleMetadata} object.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs a new builder object.
 * @apiSince 29
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the intent that will be used when the bubble is expanded. This will display the
 * app content in a floating window over the existing foreground activity.
 *
 * <p>An intent is required.</p>
 *
 * @throws java.lang.IllegalArgumentException if intent is null
 
 * @param intent This value must never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata.Builder setIntent(@androidx.annotation.NonNull android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon that will represent the bubble when it is collapsed.
 *
 * <p>An icon is required and should be representative of the content within the bubble.
 * If your app produces multiple bubbles, the image should be unique for each of them.
 * </p>
 *
 * <p>The shape of a bubble icon is adaptive and can match the device theme.
 *
 * If your icon is bitmap-based, you should create it using
 * {@link android.graphics.drawable.Icon#createWithAdaptiveBitmap(android.graphics.Bitmap) Icon#createWithAdaptiveBitmap(Bitmap)}, otherwise this method will throw.
 *
 * If your icon is not bitmap-based, you should expect that the icon will be tinted.
 * </p>
 *
 * @throws java.lang.IllegalArgumentException if icon is null or a non-adaptive bitmap
 
 * @param icon This value must never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata.Builder setIcon(@androidx.annotation.NonNull android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the desired height in DPs for the app content defined by
 * {@link #setIntent(android.app.PendingIntent)}.
 *
 * <p>This height may not be respected if there is not enough space on the screen or if
 * the provided height is too small to be useful.</p>
 *
 * <p>If {@link #setDesiredHeightResId(int)} was previously called on this builder, the
 * previous value set will be cleared after calling this method, and this value will
 * be used instead.</p>
 *
 * <p>A desired height (in DPs or via resID) is optional.</p>
 *
 * @see #setDesiredHeightResId(int)
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata.Builder setDesiredHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * Sets the desired height via resId for the app content defined by
 * {@link #setIntent(android.app.PendingIntent)}.
 *
 * <p>This height may not be respected if there is not enough space on the screen or if
 * the provided height is too small to be useful.</p>
 *
 * <p>If {@link #setDesiredHeight(int)} was previously called on this builder, the
 * previous value set will be cleared after calling this method, and this value will
 * be used instead.</p>
 *
 * <p>A desired height (in DPs or via resID) is optional.</p>
 *
 * @see #setDesiredHeight(int)
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata.Builder setDesiredHeightResId(int heightResId) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the bubble will be posted in its expanded state (with the contents of
 * {@link #getIntent()} in a floating window).
 *
 * <p>This flag has no effect if the app posting the bubble is not in the foreground.
 * The app is considered foreground if it is visible and on the screen, note that
 * a foreground service does not qualify.
 * </p>
 *
 * <p>Generally, this flag should only be set if the user has performed an action to
 * request or create a bubble.</p>
 *
 * <p>Setting this flag is optional; it defaults to false.</p>
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata.Builder setAutoExpandBubble(boolean shouldExpand) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the bubble will be posted <b>without</b> the associated notification in
 * the notification shade.
 *
 * <p>This flag has no effect if the app posting the bubble is not in the foreground.
 * The app is considered foreground if it is visible and on the screen, note that
 * a foreground service does not qualify.
 * </p>
 *
 * <p>Generally, this flag should only be set if the user has performed an action to
 * request or create a bubble, or if the user has seen the content in the notification
 * and the notification is no longer relevant.</p>
 *
 * <p>Setting this flag is optional; it defaults to false.</p>
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata.Builder setSuppressNotification(boolean shouldSuppressNotif) { throw new RuntimeException("Stub!"); }

/**
 * Sets an intent to send when this bubble is explicitly removed by the user.
 *
 * <p>Setting a delete intent is optional.</p>
 
 * @param deleteIntent This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata.Builder setDeleteIntent(@androidx.annotation.Nullable android.app.PendingIntent deleteIntent) { throw new RuntimeException("Stub!"); }

/**
 * Creates the {@link android.app.Notification.BubbleMetadata BubbleMetadata} defined by this builder.
 *
 * @throws java.lang.IllegalStateException if {@link #setIntent(android.app.PendingIntent)} and/or
 *                               {@link #setIcon(android.graphics.drawable.Icon)} have not been called on this
 *                               builder.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.BubbleMetadata build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * Builder class for {@link android.app.Notification Notification} objects.
 *
 * Provides a convenient way to set the various fields of a {@link android.app.Notification Notification} and generate
 * content views using the platform's notification layout template. If your app supports
 * versions of Android as old as API level 4, you can instead use
 * {@link android.support.v4.app.NotificationCompat.Builder NotificationCompat.Builder},
 * available in the <a href="{@docRoot}tools/extras/support-library.html">Android Support
 * library</a>.
 *
 * <p>Example:
 *
 * <pre class="prettyprint">
 * Notification noti = new Notification.Builder(mContext)
 *         .setContentTitle(&quot;New mail from &quot; + sender.toString())
 *         .setContentText(subject)
 *         .setSmallIcon(R.drawable.new_mail)
 *         .setLargeIcon(aBitmap)
 *         .build();
 * </pre>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new Builder with the defaults:
 *
 * @param context
 *            A {@link android.content.Context Context} that will be used by the Builder to construct the
 *            RemoteViews. The Context will not be held past the lifetime of this Builder
 *            object.
 * @param channelId
 *            The constructed Notification will be posted on this
 *            {@link android.app.NotificationChannel NotificationChannel}. To use a NotificationChannel, it must first be
 *            created using {@link android.app.NotificationManager#createNotificationChannel NotificationManager#createNotificationChannel}.
 * @apiSince 26
 */

public Builder(android.content.Context context, java.lang.String channelId) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link android.app.Notification.Builder#Notification.Builder(android.content.Context,java.lang.String) Notification.Builder#Notification.Builder(Context, String)}
 * instead. All posted Notifications must specify a NotificationChannel Id.
 * @apiSince 11
 */

@Deprecated
public Builder(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * If this notification is duplicative of a Launcher shortcut, sets the
 * {@link android.content.pm.ShortcutInfo#getId() ShortcutInfo#getId()} of the shortcut, in case the Launcher wants to hide
 * the shortcut.
 *
 * This field will be ignored by Launchers that don't support badging, don't show
 * notification content, or don't show {@link android.content.pm.ShortcutManager shortcuts}.
 *
 * @param shortcutId the {@link android.content.pm.ShortcutInfo#getId() ShortcutInfo#getId()} of the shortcut this notification
 *                   supersedes
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setShortcutId(java.lang.String shortcutId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.content.LocusId LocusId} associated with this notification.
 *
 * <p>This method should be called when the {@link android.content.LocusId LocusId} is used in other places (such
 * as {@link android.content.pm.ShortcutInfo ShortcutInfo} and {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext}) so the Android system can
 * correlate them.
 
 * @param locusId This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setLocusId(@androidx.annotation.Nullable android.content.LocusId locusId) { throw new RuntimeException("Stub!"); }

/**
 * Sets which icon to display as a badge for this notification.
 *
 * Must be one of {@link #BADGE_ICON_NONE}, {@link #BADGE_ICON_SMALL},
 * {@link #BADGE_ICON_LARGE}.
 *
 * Note: This value might be ignored, for launchers that don't support badge icons.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setBadgeIconType(int icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the group alert behavior for this notification. Use this method to mute this
 * notification if alerts for this notification's group should be handled by a different
 * notification. This is only applicable for notifications that belong to a
 * {@link #setGroup(java.lang.String) group}. This must be called on all notifications you want to
 * mute. For example, if you want only the summary of your group to make noise, all
 * children in the group should have the group alert behavior {@link #GROUP_ALERT_SUMMARY}.
 *
 * <p> The default value is {@link #GROUP_ALERT_ALL}.</p>
 
 * @param groupAlertBehavior Value is {@link android.app.Notification#GROUP_ALERT_ALL}, {@link android.app.Notification#GROUP_ALERT_CHILDREN}, or {@link android.app.Notification#GROUP_ALERT_SUMMARY}
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setGroupAlertBehavior(int groupAlertBehavior) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.app.Notification.BubbleMetadata BubbleMetadata} that will be used to display app content in a floating
 * window over the existing foreground activity.
 *
 * <p>This data will be ignored unless the notification is posted to a channel that
 * allows {@link android.app.NotificationChannel#canBubble() NotificationChannel#canBubble()}.</p>
 *
 * <p>Notifications allowed to bubble that have valid bubble metadata will display in
 * collapsed state outside of the notification shade on unlocked devices. When a user
 * interacts with the collapsed state, the bubble intent will be invoked and displayed.</p>
 
 * @param data This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setBubbleMetadata(@androidx.annotation.Nullable android.app.Notification.BubbleMetadata data) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the channel the notification should be delivered on.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setChannelId(java.lang.String channelId) { throw new RuntimeException("Stub!"); }

/**
 * Specifies a duration in milliseconds after which this notification should be canceled,
 * if it is not already canceled.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setTimeoutAfter(long durationMs) { throw new RuntimeException("Stub!"); }

/**
 * Add a timestamp pertaining to the notification (usually the time the event occurred).
 *
 * For apps targeting {@link android.os.Build.VERSION_CODES#N} and above, this time is not
 * shown anymore by default and must be opted into by using
 * {@link android.app.Notification.Builder#setShowWhen(boolean)}
 *
 * @see android.app.Notification#when
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setWhen(long when) { throw new RuntimeException("Stub!"); }

/**
 * Control whether the timestamp set with {@link #setWhen(long) setWhen} is shown
 * in the content view.
 * For apps targeting {@link android.os.Build.VERSION_CODES#N} and above, this defaults to
 * {@code false}. For earlier apps, the default is {@code true}.
 
 * @return This value will never be {@code null}.
 * @apiSince 17
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setShowWhen(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Show the {@link android.app.Notification#when Notification#when} field as a stopwatch.
 *
 * Instead of presenting <code>when</code> as a timestamp, the notification will show an
 * automatically updating display of the minutes and seconds since <code>when</code>.
 *
 * Useful when showing an elapsed time (like an ongoing phone call).
 *
 * The counter can also be set to count down to <code>when</code> when using
 * {@link #setChronometerCountDown(boolean)}.
 *
 * @see android.widget.Chronometer
 * @see android.app.Notification#when
 * @see #setChronometerCountDown(boolean)
 
 * @return This value will never be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setUsesChronometer(boolean b) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Chronometer to count down instead of counting up.
 *
 * <p>This is only relevant if {@link #setUsesChronometer(boolean)} has been set to true.
 * If it isn't set the chronometer will count up.
 *
 * @see #setUsesChronometer(boolean)
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setChronometerCountDown(boolean countDown) { throw new RuntimeException("Stub!"); }

/**
 * Set the small icon resource, which will be used to represent the notification in the
 * status bar.
 *
 
 * The platform template for the expanded view will draw this icon in the left, unless a
 * {@link #setLargeIcon(android.graphics.Bitmap) large icon} has also been specified, in which case the small
 * icon will be moved to the right-hand side.
 *
 
 * @param icon
 *            A resource ID in the application's package of the drawable to use.
 * @see android.app.Notification#icon
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setSmallIcon(int icon) { throw new RuntimeException("Stub!"); }

/**
 * A variant of {@link #setSmallIcon(int) setSmallIcon(int)} that takes an additional
 * level parameter for when the icon is a {@link android.graphics.drawable.LevelListDrawable
 * LevelListDrawable}.
 *
 * @param icon A resource ID in the application's package of the drawable to use.
 * @param level The level to use for the icon.
 *
 * @see android.app.Notification#icon
 * @see android.app.Notification#iconLevel
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setSmallIcon(int icon, int level) { throw new RuntimeException("Stub!"); }

/**
 * Set the small icon, which will be used to represent the notification in the
 * status bar and content view (unless overridden there by a
 * {@link #setLargeIcon(android.graphics.Bitmap) large icon}).
 *
 * @param icon An Icon object to use.
 * @see android.app.Notification#icon
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setSmallIcon(android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Set the first line of text in the platform notification template.
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setContentTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the second line of text in the platform notification template.
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setContentText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * This provides some additional information that is displayed in the notification. No
 * guarantees are given where exactly it is displayed.
 *
 * <p>This information should only be provided if it provides an essential
 * benefit to the understanding of the notification. The more text you provide the
 * less readable it becomes. For example, an email client should only provide the account
 * name here if more than one email account has been added.</p>
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#N} this information is displayed in the
 * notification header area.
 *
 * On Android versions before {@link android.os.Build.VERSION_CODES#N}
 * this will be shown in the third line of text in the platform notification template.
 * You should not be using {@link #setProgress(int,int,boolean)} at the
 * same time on those versions; they occupy the same place.
 * </p>
 
 * @return This value will never be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setSubText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Provides text that will appear as a link to your application's settings.
 *
 * <p>This text does not appear within notification {@link android.app.Notification.Style Style} but may
 * appear when the user uses an affordance to learn more about the notification.
 * Additionally, this text will not appear unless you provide a valid link target by
 * handling {@link #INTENT_CATEGORY_NOTIFICATION_PREFERENCES}.
 *
 * <p>This text is meant to be concise description about what the user can customize
 * when they click on this link. The recommended maximum length is 40 characters.
 * @param text
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setSettingsText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Set the remote input history.
 *
 * This should be set to the most recent inputs that have been sent
 * through a {@link android.app.RemoteInput RemoteInput} of this Notification and cleared once the it is no
 * longer relevant (e.g. for chat notifications once the other party has responded).
 *
 * The most recent input must be stored at the 0 index, the second most recent at the
 * 1 index, etc. Note that the system will limit both how far back the inputs will be shown
 * and how much of each individual input is shown.
 *
 * <p>Note: The reply text will only be shown on notifications that have least one action
 * with a {@code RemoteInput}.</p>
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setRemoteInputHistory(java.lang.CharSequence[] text) { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of items this notification represents. May be displayed as a badge count
 * for Launchers that support badging.
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 * @deprecatedSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setNumber(int number) { throw new RuntimeException("Stub!"); }

/**
 * A small piece of additional information pertaining to this notification.
 *
 * The platform template will draw this on the last line of the notification, at the far
 * right (to the right of a smallIcon if it has been placed there).
 *
 * @deprecated use {@link #setSubText(java.lang.CharSequence)} instead to set a text in the header.
 * For legacy apps targeting a version below {@link android.os.Build.VERSION_CODES#N} this
 * field will still show up, but the subtext will take precedence.
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated
public android.app.Notification.Builder setContentInfo(java.lang.CharSequence info) { throw new RuntimeException("Stub!"); }

/**
 * Set the progress this notification represents.
 *
 * The platform template will represent this using a {@link android.widget.ProgressBar ProgressBar}.
 
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setProgress(int max, int progress, boolean indeterminate) { throw new RuntimeException("Stub!"); }

/**
 * Supply a custom RemoteViews to use instead of the platform template.
 *
 * Use {@link #setCustomContentView(android.widget.RemoteViews)} instead.
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated
public android.app.Notification.Builder setContent(android.widget.RemoteViews views) { throw new RuntimeException("Stub!"); }

/**
 * Supply custom RemoteViews to use instead of the platform template.
 *
 * This will override the layout that would otherwise be constructed by this Builder
 * object.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setCustomContentView(android.widget.RemoteViews contentView) { throw new RuntimeException("Stub!"); }

/**
 * Supply custom RemoteViews to use instead of the platform template in the expanded form.
 *
 * This will override the expanded layout that would otherwise be constructed by this
 * Builder object.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setCustomBigContentView(android.widget.RemoteViews contentView) { throw new RuntimeException("Stub!"); }

/**
 * Supply custom RemoteViews to use instead of the platform template in the heads up dialog.
 *
 * This will override the heads-up layout that would otherwise be constructed by this
 * Builder object.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setCustomHeadsUpContentView(android.widget.RemoteViews contentView) { throw new RuntimeException("Stub!"); }

/**
 * Supply a {@link android.app.PendingIntent PendingIntent} to be sent when the notification is clicked.
 *
 * As of {@link android.os.Build.VERSION_CODES#HONEYCOMB}, if this field is unset and you
 * have specified a custom RemoteViews with {@link #setContent(android.widget.RemoteViews)}, you can use
 * {@link android.widget.RemoteViews#setOnClickPendingIntent RemoteViews#setOnClickPendingIntent}
 * to assign PendingIntents to individual views in that custom layout (i.e., to create
 * clickable buttons inside the notification view).
 *
 * @see android.app.Notification#contentIntent Notification.contentIntent
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setContentIntent(android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Supply a {@link android.app.PendingIntent PendingIntent} to send when the notification is cleared explicitly by the user.
 *
 * @see android.app.Notification#deleteIntent
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setDeleteIntent(android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * An intent to launch instead of posting the notification to the status bar.
 * Only for use with extremely high-priority notifications demanding the user's
 * <strong>immediate</strong> attention, such as an incoming phone call or
 * alarm clock that the user has explicitly set to a particular time.
 * If this facility is used for something else, please give the user an option
 * to turn it off and use a normal notification, as this can be extremely
 * disruptive.
 *
 * <p>
 * The system UI may choose to display a heads-up notification, instead of
 * launching this intent, while the user is using the device.
 * </p>
 * <p>Apps targeting {@link android.os.Build.VERSION_CODES#Q Build.VERSION_CODES#Q} and above will have to request
 * a permission ({@link android.Manifest.permission#USE_FULL_SCREEN_INTENT}) in order to
 * use full screen intents.</p>
 *
 * @param intent The pending intent to launch.
 * @param highPriority Passing true will cause this notification to be sent
 *          even if other notifications are suppressed.
 *
 * @see android.app.Notification#fullScreenIntent
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setFullScreenIntent(android.app.PendingIntent intent, boolean highPriority) { throw new RuntimeException("Stub!"); }

/**
 * Set the "ticker" text which is sent to accessibility services.
 *
 * @see android.app.Notification#tickerText
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setTicker(java.lang.CharSequence tickerText) { throw new RuntimeException("Stub!"); }

/**
 * Obsolete version of {@link #setTicker(java.lang.CharSequence)}.
 *
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public android.app.Notification.Builder setTicker(java.lang.CharSequence tickerText, android.widget.RemoteViews views) { throw new RuntimeException("Stub!"); }

/**
 * Add a large icon to the notification content view.
 *
 * In the platform template, this image will be shown on the left of the notification view
 * in place of the {@link #setSmallIcon(android.graphics.drawable.Icon) small icon} (which will be placed in a small
 * badge atop the large icon).
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setLargeIcon(android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * Add a large icon to the notification content view.
 *
 * In the platform template, this image will be shown on the left of the notification view
 * in place of the {@link #setSmallIcon(android.graphics.drawable.Icon) small icon} (which will be placed in a small
 * badge atop the large icon).
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setLargeIcon(android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Set the sound to play.
 *
 * It will be played using the {@link #AUDIO_ATTRIBUTES_DEFAULT default audio attributes}
 * for notifications.
 *
 * @deprecated use {@link android.app.NotificationChannel#setSound(android.net.Uri,android.media.AudioAttributes) NotificationChannel#setSound(Uri, AudioAttributes)} instead.
 * @apiSince 11
 * @deprecatedSince 26
 */

@Deprecated
public android.app.Notification.Builder setSound(android.net.Uri sound) { throw new RuntimeException("Stub!"); }

/**
 * Set the sound to play, along with a specific stream on which to play it.
 *
 * See {@link android.media.AudioManager} for the <code>STREAM_</code> constants.
 *
 * @deprecated use {@link android.app.NotificationChannel#setSound(android.net.Uri,android.media.AudioAttributes) NotificationChannel#setSound(Uri, AudioAttributes)}.
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public android.app.Notification.Builder setSound(android.net.Uri sound, int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Set the sound to play, along with specific {@link android.media.AudioAttributes AudioAttributes} to
 * use during playback.
 *
 * @deprecated use {@link android.app.NotificationChannel#setSound(android.net.Uri,android.media.AudioAttributes) NotificationChannel#setSound(Uri, AudioAttributes)} instead.
 * @see android.app.Notification#sound
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated
public android.app.Notification.Builder setSound(android.net.Uri sound, android.media.AudioAttributes audioAttributes) { throw new RuntimeException("Stub!"); }

/**
 * Set the vibration pattern to use.
 *
 * See {@link android.os.Vibrator#vibrate(long[], int)} for a discussion of the
 * <code>pattern</code> parameter.
 *
 * <p>
 * A notification that vibrates is more likely to be presented as a heads-up notification.
 * </p>
 *
 * @deprecated use {@link android.app.NotificationChannel#setVibrationPattern(long[]) NotificationChannel#setVibrationPattern(long[])} instead.
 * @see android.app.Notification#vibrate
 * @apiSince 11
 * @deprecatedSince 26
 */

@Deprecated
public android.app.Notification.Builder setVibrate(long[] pattern) { throw new RuntimeException("Stub!"); }

/**
 * Set the desired color for the indicator LED on the device, as well as the
 * blink duty cycle (specified in milliseconds).
 *
 
 * Not all devices will honor all (or even any) of these values.
 *
 * @deprecated use {@link android.app.NotificationChannel#enableLights(boolean) NotificationChannel#enableLights(boolean)} instead.
 * @see android.app.Notification#ledARGB
 * @see android.app.Notification#ledOnMS
 * @see android.app.Notification#ledOffMS
 * @apiSince 11
 * @deprecatedSince 26
 */

@Deprecated
public android.app.Notification.Builder setLights(int argb, int onMs, int offMs) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this is an "ongoing" notification.
 *
 
 * Ongoing notifications cannot be dismissed by the user, so your application or service
 * must take care of canceling them.
 *
 
 * They are typically used to indicate a background task that the user is actively engaged
 * with (e.g., playing music) or is pending in some way and therefore occupying the device
 * (e.g., a file download, sync operation, active network connection).
 *
 
 * @see android.app.Notification#FLAG_ONGOING_EVENT
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setOngoing(boolean ongoing) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this notification should be colorized. When set, the color set with
 * {@link #setColor(int)} will be used as the background color of this notification.
 * <p>
 * This should only be used for high priority ongoing tasks like navigation, an ongoing
 * call, or other similarly high-priority events for the user.
 * <p>
 * For most styles, the coloring will only be applied if the notification is for a
 * foreground service notification.
 * However, for {@link android.app.Notification.MediaStyle MediaStyle} and {@link android.app.Notification.DecoratedMediaCustomViewStyle DecoratedMediaCustomViewStyle} notifications
 * that have a media session attached there is no such requirement.
 *
 * @see #setColor(int)
 * @see android.app.Notification.MediaStyle#setMediaSession(MediaSession.Token)
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setColorized(boolean colorize) { throw new RuntimeException("Stub!"); }

/**
 * Set this flag if you would only like the sound, vibrate
 * and ticker to be played if the notification is not already showing.
 *
 * @see android.app.Notification#FLAG_ONLY_ALERT_ONCE
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setOnlyAlertOnce(boolean onlyAlertOnce) { throw new RuntimeException("Stub!"); }

/**
 * Make this notification automatically dismissed when the user touches it.
 *
 * @see android.app.Notification#FLAG_AUTO_CANCEL
 
 * @return This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setAutoCancel(boolean autoCancel) { throw new RuntimeException("Stub!"); }

/**
 * Set whether or not this notification should not bridge to other devices.
 *
 * <p>Some notifications can be bridged to other devices for remote display.
 * This hint can be set to recommend this notification not be bridged.
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setLocalOnly(boolean localOnly) { throw new RuntimeException("Stub!"); }

/**
 * Set which notification properties will be inherited from system defaults.
 * <p>
 * The value should be one or more of the following fields combined with
 * bitwise-or:
 * {@link #DEFAULT_SOUND}, {@link #DEFAULT_VIBRATE}, {@link #DEFAULT_LIGHTS}.
 * <p>
 * For all default values, use {@link #DEFAULT_ALL}.
 *
 * @deprecated use {@link android.app.NotificationChannel#enableVibration(boolean) NotificationChannel#enableVibration(boolean)} and
 * {@link android.app.NotificationChannel#enableLights(boolean) NotificationChannel#enableLights(boolean)} and
 * {@link android.app.NotificationChannel#setSound(android.net.Uri,android.media.AudioAttributes) NotificationChannel#setSound(Uri, AudioAttributes)} instead.
 * @apiSince 11
 * @deprecatedSince 26
 */

@Deprecated
public android.app.Notification.Builder setDefaults(int defaults) { throw new RuntimeException("Stub!"); }

/**
 * Set the priority of this notification.
 *
 * @see android.app.Notification#priority
 * @deprecated use {@link android.app.NotificationChannel#setImportance(int) NotificationChannel#setImportance(int)} instead.
 
 * @param pri Value is {@link android.app.Notification#PRIORITY_DEFAULT}, {@link android.app.Notification#PRIORITY_LOW}, {@link android.app.Notification#PRIORITY_MIN}, {@link android.app.Notification#PRIORITY_HIGH}, or {@link android.app.Notification#PRIORITY_MAX}
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated
public android.app.Notification.Builder setPriority(int pri) { throw new RuntimeException("Stub!"); }

/**
 * Set the notification category.
 *
 * @see android.app.Notification#category
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setCategory(java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Add a person that is relevant to this notification.
 *
 * <P>
 * Depending on user preferences, this annotation may allow the notification to pass
 * through interruption filters, if this notification is of category {@link #CATEGORY_CALL}
 * or {@link #CATEGORY_MESSAGE}. The addition of people may also cause this notification to
 * appear more prominently in the user interface.
 * </P>
 *
 * <P>
 * The person should be specified by the {@code String} representation of a
 * {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}.
 * </P>
 *
 * <P>The system will also attempt to resolve {@code mailto:} and {@code tel:} schema
 * URIs.  The path part of these URIs must exist in the contacts database, in the
 * appropriate column, or the reference will be discarded as invalid. Telephone schema
 * URIs will be resolved by {@link android.provider.ContactsContract.PhoneLookup}.
 * It is also possible to provide a URI with the schema {@code name:} in order to uniquely
 * identify a person without an entry in the contacts database.
 * </P>
 *
 * @param uri A URI for the person.
 * @see android.app.Notification#EXTRA_PEOPLE
 * @deprecated use {@link #addPerson(android.app.Person)}
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.Builder addPerson(java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Add a person that is relevant to this notification.
 *
 * <P>
 * Depending on user preferences, this annotation may allow the notification to pass
 * through interruption filters, if this notification is of category {@link #CATEGORY_CALL}
 * or {@link #CATEGORY_MESSAGE}. The addition of people may also cause this notification to
 * appear more prominently in the user interface.
 * </P>
 *
 * <P>
 * A person should usually contain a uri in order to benefit from the ranking boost.
 * However, even if no uri is provided, it's beneficial to provide other people in the
 * notification, such that listeners and voice only devices can announce and handle them
 * properly.
 * </P>
 *
 * @param person the person to add.
 * @see android.app.Notification#EXTRA_PEOPLE_LIST
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder addPerson(android.app.Person person) { throw new RuntimeException("Stub!"); }

/**
 * Set this notification to be part of a group of notifications sharing the same key.
 * Grouped notifications may display in a cluster or stack on devices which
 * support such rendering.
 *
 * <p>To make this notification the summary for its group, also call
 * {@link #setGroupSummary}. A sort order can be specified for group members by using
 * {@link #setSortKey}.
 * @param groupKey The group key of the group.
 * @return this object for method chaining
 
 * This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setGroup(java.lang.String groupKey) { throw new RuntimeException("Stub!"); }

/**
 * Set this notification to be the group summary for a group of notifications.
 * Grouped notifications may display in a cluster or stack on devices which
 * support such rendering. If thereRequires a group key also be set using {@link #setGroup}.
 * The group summary may be suppressed if too few notifications are included in the group.
 * @param isGroupSummary Whether this notification should be a group summary.
 * @return this object for method chaining
 
 * This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setGroupSummary(boolean isGroupSummary) { throw new RuntimeException("Stub!"); }

/**
 * Set a sort key that orders this notification among other notifications from the
 * same package. This can be useful if an external sort was already applied and an app
 * would like to preserve this. Notifications will be sorted lexicographically using this
 * value, although providing different priorities in addition to providing sort key may
 * cause this value to be ignored.
 *
 * <p>This sort key can also be used to order members of a notification group. See
 * {@link #setGroup}.
 *
 * @see java.lang.String#compareTo(String)
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setSortKey(java.lang.String sortKey) { throw new RuntimeException("Stub!"); }

/**
 * Merge additional metadata into this notification.
 *
 * <p>Values within the Bundle will replace existing extras values in this Builder.
 *
 * @see android.app.Notification#extras
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder addExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Set metadata for this notification.
 *
 * <p>A reference to the Bundle is held for the lifetime of this Builder, and the Bundle's
 * current contents are copied into the Notification each time {@link #build()} is
 * called.
 *
 * <p>Replaces any existing extras values with those from the provided Bundle.
 * Use {@link #addExtras} to merge in metadata instead.
 *
 * @see android.app.Notification#extras
 
 * @return This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Get the current metadata Bundle used by this notification Builder.
 *
 * <p>The returned Bundle is shared with this Builder.
 *
 * <p>The current contents of this Bundle are copied into the Notification each time
 * {@link #build()} is called.
 *
 * @see android.app.Notification#extras
 * @apiSince 20
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Add an action to this notification. Actions are typically displayed by
 * the system as a button adjacent to the notification content.
 * <p>
 * Every action must have an icon (32dp square and matching the
 * <a href="{@docRoot}design/style/iconography.html#action-bar">Holo
 * Dark action bar</a> visual style), a textual label, and a {@link android.app.PendingIntent PendingIntent}.
 * <p>
 * A notification in its expanded form can display up to 3 actions, from left to right in
 * the order they were added. Actions will not be displayed when the notification is
 * collapsed, however, so be sure that any essential functions may be accessed by the user
 * in some other way (for example, in the Activity pointed to by {@link #contentIntent}).
 *
 * @param icon Resource ID of a drawable that represents the action.
 * @param title Text describing the action.
 * @param intent PendingIntent to be fired when the action is invoked.
 *
 * @deprecated Use {@link #addAction(android.app.Notification.Action)} instead.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public android.app.Notification.Builder addAction(int icon, java.lang.CharSequence title, android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Add an action to this notification. Actions are typically displayed by
 * the system as a button adjacent to the notification content.
 * <p>
 * Every action must have an icon (32dp square and matching the
 * <a href="{@docRoot}design/style/iconography.html#action-bar">Holo
 * Dark action bar</a> visual style), a textual label, and a {@link android.app.PendingIntent PendingIntent}.
 * <p>
 * A notification in its expanded form can display up to 3 actions, from left to right in
 * the order they were added. Actions will not be displayed when the notification is
 * collapsed, however, so be sure that any essential functions may be accessed by the user
 * in some other way (for example, in the Activity pointed to by {@link #contentIntent}).
 *
 * @param action The action to add.
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder addAction(android.app.Notification.Action action) { throw new RuntimeException("Stub!"); }

/**
 * Alter the complete list of actions attached to this notification.
 * @see #addAction(Action).
 *
 * @param actions
 * @return
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setActions(android.app.Notification.Action... actions) { throw new RuntimeException("Stub!"); }

/**
 * Add a rich notification style to be applied at build time.
 *
 * @param style Object responsible for modifying the notification style.
 
 * @return This value will never be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setStyle(android.app.Notification.Style style) { throw new RuntimeException("Stub!"); }

/**
 * Returns the style set by {@link #setStyle(android.app.Notification.Style)}.
 * @apiSince 28
 */

public android.app.Notification.Style getStyle() { throw new RuntimeException("Stub!"); }

/**
 * Specify the value of {@link #visibility}.
 *
 * @param visibility Value is {@link android.app.Notification#VISIBILITY_PUBLIC}, {@link android.app.Notification#VISIBILITY_PRIVATE}, or {@link android.app.Notification#VISIBILITY_SECRET}
 * @return The same Builder.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Supply a replacement Notification whose contents should be shown in insecure contexts
 * (i.e. atop the secure lockscreen). See {@link #visibility} and {@link #VISIBILITY_PUBLIC}.
 * @param n A replacement notification, presumably with some or all info redacted.
 * @return The same Builder.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setPublicVersion(android.app.Notification n) { throw new RuntimeException("Stub!"); }

/**
 * Apply an extender to this notification builder. Extenders may be used to add
 * metadata or change options on this builder.
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder extend(android.app.Notification.Extender extender) { throw new RuntimeException("Stub!"); }

/**
 * Set the value for a notification flag
 *
 * @param mask Bit mask of the flag
 * Value is {@link android.app.Notification#FLAG_SHOW_LIGHTS}, {@link android.app.Notification#FLAG_ONGOING_EVENT}, {@link android.app.Notification#FLAG_INSISTENT}, {@link android.app.Notification#FLAG_ONLY_ALERT_ONCE}, {@link android.app.Notification#FLAG_AUTO_CANCEL}, {@link android.app.Notification#FLAG_NO_CLEAR}, {@link android.app.Notification#FLAG_FOREGROUND_SERVICE}, {@link android.app.Notification#FLAG_HIGH_PRIORITY}, {@link android.app.Notification#FLAG_LOCAL_ONLY}, {@link android.app.Notification#FLAG_GROUP_SUMMARY}, android.app.Notification.FLAG_AUTOGROUP_SUMMARY, or {@link android.app.Notification#FLAG_BUBBLE}
 * @param value Status (on/off) of the flag
 *
 * @return The same Builder.
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setFlag(int mask, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Sets {@link android.app.Notification#color Notification#color}.
 *
 * @param argb The accent color to use
 *
 * @return The same Builder.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setColor(int argb) { throw new RuntimeException("Stub!"); }

/**
 * Construct a RemoteViews for the final 1U notification layout. In order:
 *   1. Custom contentView from the caller
 *   2. Style's proposed content view
 *   3. Standard template view
 * @apiSince 24
 */

public android.widget.RemoteViews createContentView() { throw new RuntimeException("Stub!"); }

/**
 * Construct a RemoteViews for the final big notification layout.
 * @apiSince 24
 */

public android.widget.RemoteViews createBigContentView() { throw new RuntimeException("Stub!"); }

/**
 * Construct a RemoteViews for the final heads-up notification layout.
 * @apiSince 24
 */

public android.widget.RemoteViews createHeadsUpContentView() { throw new RuntimeException("Stub!"); }

/**
 * Creates a Builder from an existing notification so further changes can be made.
 * @param context The context for your application / activity.
 * @param n The notification to create a Builder from.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static android.app.Notification.Builder recoverBuilder(android.content.Context context, android.app.Notification n) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the platform can generate contextual actions for a notification.
 * By default this is true.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification.Builder setAllowSystemGeneratedContextualActions(boolean allowed) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #build()} instead.
 * @apiSince 11
 * @deprecatedSince 16
 */

@Deprecated
public android.app.Notification getNotification() { throw new RuntimeException("Stub!"); }

/**
 * Combine all of the options that have been set and return a new {@link android.app.Notification Notification}
 * object.
 
 * @return This value will never be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.NonNull
public android.app.Notification build() { throw new RuntimeException("Stub!"); }
}

/**
 * <p>Helper class to add Android Auto extensions to notifications. To create a notification
 * with car extensions:
 *
 * <ol>
 *  <li>Create an {@link android.app.Notification.Builder Notification.Builder}, setting any desired
 *  properties.
 *  <li>Create a {@link android.app.Notification.CarExtender CarExtender}.
 *  <li>Set car-specific properties using the {@code add} and {@code set} methods of
 *  {@link android.app.Notification.CarExtender CarExtender}.
 *  <li>Call {@link android.app.Notification.Builder#extend(android.app.Notification.Extender) Notification.Builder#extend(Notification.Extender)}
 *  to apply the extensions to a notification.
 * </ol>
 *
 * <pre class="prettyprint">
 * Notification notification = new Notification.Builder(context)
 *         ...
 *         .extend(new CarExtender()
 *                 .set*(...))
 *         .build();
 * </pre>
 *
 * <p>Car extensions can be accessed on an existing notification by using the
 * {@code CarExtender(Notification)} constructor, and then using the {@code get} methods
 * to access values.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CarExtender implements android.app.Notification.Extender {

/**
 * Create a {@link android.app.Notification.CarExtender CarExtender} with default options.
 * @apiSince 23
 */

public CarExtender() { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.app.Notification.CarExtender CarExtender} from the CarExtender options of an existing Notification.
 *
 * @param notif The notification from which to copy options.
 * @apiSince 23
 */

public CarExtender(android.app.Notification notif) { throw new RuntimeException("Stub!"); }

/**
 * Apply car extensions to a notification that is being built. This is typically called by
 * the {@link android.app.Notification.Builder#extend(android.app.Notification.Extender) Notification.Builder#extend(Notification.Extender)}
 * method of {@link android.app.Notification.Builder Notification.Builder}.
 * @apiSince 23
 */

public android.app.Notification.Builder extend(android.app.Notification.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * Sets the accent color to use when Android Auto presents the notification.
 *
 * Android Auto uses the color set with {@link android.app.Notification.Builder#setColor(int) Notification.Builder#setColor(int)}
 * to accent the displayed notification. However, not all colors are acceptable in an
 * automotive setting. This method can be used to override the color provided in the
 * notification in such a situation.
 * @apiSince 23
 */

public android.app.Notification.CarExtender setColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Gets the accent color.
 *
 * @see #setColor
 * @apiSince 23
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the large icon of the car notification.
 *
 * If no large icon is set in the extender, Android Auto will display the icon
 * specified by {@link android.app.Notification.Builder#setLargeIcon(android.graphics.Bitmap) Notification.Builder#setLargeIcon(android.graphics.Bitmap)}
 *
 * @param largeIcon The large icon to use in the car notification.
 * @return This object for method chaining.
 * @apiSince 23
 */

public android.app.Notification.CarExtender setLargeIcon(android.graphics.Bitmap largeIcon) { throw new RuntimeException("Stub!"); }

/**
 * Gets the large icon used in this car notification, or null if no icon has been set.
 *
 * @return The large icon for the car notification.
 * @see android.app.Notification.CarExtender#setLargeIcon
 * @apiSince 23
 */

public android.graphics.Bitmap getLargeIcon() { throw new RuntimeException("Stub!"); }

/**
 * Sets the unread conversation in a message notification.
 *
 * @param unreadConversation The unread part of the conversation this notification conveys.
 * @return This object for method chaining.
 * @apiSince 23
 */

public android.app.Notification.CarExtender setUnreadConversation(android.app.Notification.CarExtender.UnreadConversation unreadConversation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the unread conversation conveyed by this notification.
 * @see #setUnreadConversation(UnreadConversation)
 * @apiSince 23
 */

public android.app.Notification.CarExtender.UnreadConversation getUnreadConversation() { throw new RuntimeException("Stub!"); }
/**
 * Builder class for {@link android.app.Notification.CarExtender.UnreadConversation CarExtender.UnreadConversation} objects.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new builder for {@link android.app.Notification.CarExtender.UnreadConversation CarExtender.UnreadConversation}.
 *
 * @param name The name of the other participant in the conversation.
 * @apiSince 23
 */

public Builder(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Appends a new unread message to the list of messages for this conversation.
 *
 * The messages should be added from oldest to newest.
 *
 * @param message The text of the new unread message.
 * @return This object for method chaining.
 * @apiSince 23
 */

public android.app.Notification.CarExtender.Builder addMessage(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Sets the pending intent and remote input which will convey the reply to this
 * notification.
 *
 * @param pendingIntent The pending intent which will be triggered on a reply.
 * @param remoteInput The remote input parcelable which will carry the reply.
 * @return This object for method chaining.
 *
 * @see android.app.Notification.CarExtender.UnreadConversation#getRemoteInput
 * @see android.app.Notification.CarExtender.UnreadConversation#getReplyPendingIntent
 * @apiSince 23
 */

public android.app.Notification.CarExtender.Builder setReplyAction(android.app.PendingIntent pendingIntent, android.app.RemoteInput remoteInput) { throw new RuntimeException("Stub!"); }

/**
 * Sets the pending intent that will be sent once the messages in this notification
 * are read.
 *
 * @param pendingIntent The pending intent to use.
 * @return This object for method chaining.
 * @apiSince 23
 */

public android.app.Notification.CarExtender.Builder setReadPendingIntent(android.app.PendingIntent pendingIntent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the timestamp of the most recent message in an unread conversation.
 *
 * If a messaging notification has been posted by your application and has not
 * yet been cancelled, posting a later notification with the same id and tag
 * but without a newer timestamp may result in Android Auto not displaying a
 * heads up notification for the later notification.
 *
 * @param timestamp The timestamp of the most recent message in the conversation.
 * @return This object for method chaining.
 * @apiSince 23
 */

public android.app.Notification.CarExtender.Builder setLatestTimestamp(long timestamp) { throw new RuntimeException("Stub!"); }

/**
 * Builds a new unread conversation object.
 *
 * @return The new unread conversation object.
 * @apiSince 23
 */

public android.app.Notification.CarExtender.UnreadConversation build() { throw new RuntimeException("Stub!"); }
}

/**
 * A class which holds the unread messages from a conversation.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class UnreadConversation {

UnreadConversation() { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of messages conveyed by this notification.
 * @apiSince 23
 */

public java.lang.String[] getMessages() { throw new RuntimeException("Stub!"); }

/**
 * Gets the remote input that will be used to convey the response to a message list, or
 * null if no such remote input exists.
 * @apiSince 23
 */

public android.app.RemoteInput getRemoteInput() { throw new RuntimeException("Stub!"); }

/**
 * Gets the pending intent that will be triggered when the user replies to this
 * notification.
 * @apiSince 23
 */

public android.app.PendingIntent getReplyPendingIntent() { throw new RuntimeException("Stub!"); }

/**
 * Gets the pending intent that Android Auto will send after it reads aloud all messages
 * in this object's message list.
 * @apiSince 23
 */

public android.app.PendingIntent getReadPendingIntent() { throw new RuntimeException("Stub!"); }

/**
 * Gets the participants in the conversation.
 * @apiSince 23
 */

public java.lang.String[] getParticipants() { throw new RuntimeException("Stub!"); }

/**
 * Gets the firs participant in the conversation.
 * @apiSince 23
 */

public java.lang.String getParticipant() { throw new RuntimeException("Stub!"); }

/**
 * Gets the timestamp of the conversation.
 * @apiSince 23
 */

public long getLatestTimestamp() { throw new RuntimeException("Stub!"); }
}

}

/**
 * Notification style for custom views that are decorated by the system
 *
 * <p>Instead of providing a notification that is completely custom, a developer can set this
 * style and still obtain system decorations like the notification header with the expand
 * affordance and actions.
 *
 * <p>Use {@link android.app.Notification.Builder#setCustomContentView(RemoteViews)},
 * {@link android.app.Notification.Builder#setCustomBigContentView(RemoteViews)} and
 * {@link android.app.Notification.Builder#setCustomHeadsUpContentView(RemoteViews)} to set the
 * corresponding custom views to display.
 *
 * To use this style with your Notification, feed it to
 * {@link android.app.Notification.Builder#setStyle(android.app.Notification.Style) Notification.Builder#setStyle(android.app.Notification.Style)} like so:
 * <pre class="prettyprint">
 * Notification noti = new Notification.Builder()
 *     .setSmallIcon(R.drawable.ic_stat_player)
 *     .setLargeIcon(albumArtBitmap))
 *     .setCustomContentView(contentView);
 *     .setStyle(<b>new Notification.DecoratedCustomViewStyle()</b>)
 *     .build();
 * </pre>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DecoratedCustomViewStyle extends android.app.Notification.Style {

/** @apiSince 24 */

public DecoratedCustomViewStyle() { throw new RuntimeException("Stub!"); }
}

/**
 * Notification style for media custom views that are decorated by the system
 *
 * <p>Instead of providing a media notification that is completely custom, a developer can set
 * this style and still obtain system decorations like the notification header with the expand
 * affordance and actions.
 *
 * <p>Use {@link android.app.Notification.Builder#setCustomContentView(RemoteViews)},
 * {@link android.app.Notification.Builder#setCustomBigContentView(RemoteViews)} and
 * {@link android.app.Notification.Builder#setCustomHeadsUpContentView(RemoteViews)} to set the
 * corresponding custom views to display.
 * <p>
 * Contrary to {@link android.app.Notification.MediaStyle MediaStyle} a developer has to opt-in to the colorizing of the
 * notification by using {@link android.app.Notification.Builder#setColorized(boolean) Notification.Builder#setColorized(boolean)}.
 * <p>
 * To use this style with your Notification, feed it to
 * {@link android.app.Notification.Builder#setStyle(android.app.Notification.Style) Notification.Builder#setStyle(android.app.Notification.Style)} like so:
 * <pre class="prettyprint">
 * Notification noti = new Notification.Builder()
 *     .setSmallIcon(R.drawable.ic_stat_player)
 *     .setLargeIcon(albumArtBitmap))
 *     .setCustomContentView(contentView);
 *     .setStyle(<b>new Notification.DecoratedMediaCustomViewStyle()</b>
 *          .setMediaSession(mySession))
 *     .build();
 * </pre>
 *
 * @see android.app.Notification.DecoratedCustomViewStyle
 * @see android.app.Notification.MediaStyle
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DecoratedMediaCustomViewStyle extends android.app.Notification.MediaStyle {

/** @apiSince 24 */

public DecoratedMediaCustomViewStyle() { throw new RuntimeException("Stub!"); }
}

/**
 * Extender interface for use with {@link android.app.Notification.Builder#extend Builder#extend}. Extenders may be used to add
 * metadata or change options on a notification builder.
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Extender {

/**
 * Apply this extender to a notification builder.
 * @param builder the builder to be modified.
 * @return the build object for chaining.
 * @apiSince 20
 */

public android.app.Notification.Builder extend(android.app.Notification.Builder builder);
}

/**
 * Helper class for generating large-format notifications that include a list of (up to 5) strings.
 *
 * Here's how you'd set the <code>InboxStyle</code> on a notification:
 * <pre class="prettyprint">
 * Notification notif = new Notification.Builder(mContext)
 *     .setContentTitle(&quot;5 New mails from &quot; + sender.toString())
 *     .setContentText(subject)
 *     .setSmallIcon(R.drawable.new_mail)
 *     .setLargeIcon(aBitmap)
 *     .setStyle(new Notification.InboxStyle()
 *         .addLine(str1)
 *         .addLine(str2)
 *         .setContentTitle(&quot;&quot;)
 *         .setSummaryText(&quot;+3 more&quot;))
 *     .build();
 * </pre>
 *
 * @see android.app.Notification#bigContentView
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class InboxStyle extends android.app.Notification.Style {

/** @apiSince 16 */

public InboxStyle() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@code InboxStyle()}.
 * @apiSince 16
 */

@Deprecated
public InboxStyle(android.app.Notification.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * Overrides ContentTitle in the big form of the template.
 * This defaults to the value passed to setContentTitle().
 * @apiSince 16
 */

public android.app.Notification.InboxStyle setBigContentTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the first line of text after the detail section in the big form of the template.
 * @apiSince 16
 */

public android.app.Notification.InboxStyle setSummaryText(java.lang.CharSequence cs) { throw new RuntimeException("Stub!"); }

/**
 * Append a line to the digest section of the Inbox notification.
 * @apiSince 16
 */

public android.app.Notification.InboxStyle addLine(java.lang.CharSequence cs) { throw new RuntimeException("Stub!"); }
}

/**
 * Notification style for media playback notifications.
 *
 * In the expanded form, {@link android.app.Notification#bigContentView Notification#bigContentView}, up to 5
 * {@link android.app.Notification.Action Notification.Action}s specified with
 * {@link android.app.Notification.Builder#addAction(android.app.Notification.Action) Notification.Builder#addAction(Action)} will be
 * shown as icon-only pushbuttons, suitable for transport controls. The Bitmap given to
 * {@link android.app.Notification.Builder#setLargeIcon(android.graphics.Bitmap) Notification.Builder#setLargeIcon(android.graphics.Bitmap)} will be
 * treated as album artwork.
 * <p>
 * Unlike the other styles provided here, MediaStyle can also modify the standard-size
 * {@link android.app.Notification#contentView Notification#contentView}; by providing action indices to
 * {@link #setShowActionsInCompactView(int...)} you can promote up to 3 actions to be displayed
 * in the standard view alongside the usual content.
 * <p>
 * Notifications created with MediaStyle will have their category set to
 * {@link android.app.Notification#CATEGORY_TRANSPORT Notification#CATEGORY_TRANSPORT} unless you set a different
 * category using {@link android.app.Notification.Builder#setCategory(java.lang.String) Notification.Builder#setCategory(String)}.
 * <p>
 * Finally, if you attach a {@link android.media.session.MediaSession.Token} using
 * {@link android.app.Notification.MediaStyle#setMediaSession(MediaSession.Token)},
 * the System UI can identify this as a notification representing an active media session
 * and respond accordingly (by showing album artwork in the lockscreen, for example).
 *
 * <p>
 * Starting at {@link android.os.Build.VERSION_CODES#O Android O} any notification that has a
 * media session attached with {@link #setMediaSession(android.media.session.MediaSession.Token)} will be colorized.
 * You can opt-out of this behavior by using {@link android.app.Notification.Builder#setColorized(boolean) Notification.Builder#setColorized(boolean)}.
 * <p>
 *
 * To use this style with your Notification, feed it to
 * {@link android.app.Notification.Builder#setStyle(android.app.Notification.Style) Notification.Builder#setStyle(android.app.Notification.Style)} like so:
 * <pre class="prettyprint">
 * Notification noti = new Notification.Builder()
 *     .setSmallIcon(R.drawable.ic_stat_player)
 *     .setContentTitle(&quot;Track title&quot;)
 *     .setContentText(&quot;Artist - Album&quot;)
 *     .setLargeIcon(albumArtBitmap))
 *     .setStyle(<b>new Notification.MediaStyle()</b>
 *         .setMediaSession(mySession))
 *     .build();
 * </pre>
 *
 * @see android.app.Notification#bigContentView
 * @see android.app.Notification.Builder#setColorized(boolean)
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MediaStyle extends android.app.Notification.Style {

/** @apiSince 21 */

public MediaStyle() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@code MediaStyle()}.
 * @apiSince 21
 */

@Deprecated
public MediaStyle(android.app.Notification.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * Request up to 3 actions (by index in the order of addition) to be shown in the compact
 * notification view.
 *
 * @param actions the indices of the actions to show in the compact notification view
 * @apiSince 21
 */

public android.app.Notification.MediaStyle setShowActionsInCompactView(int... actions) { throw new RuntimeException("Stub!"); }

/**
 * Attach a {@link android.media.session.MediaSession.Token} to this Notification
 * to provide additional playback information and control to the SystemUI.
 * @apiSince 21
 */

public android.app.Notification.MediaStyle setMediaSession(android.media.session.MediaSession.Token token) { throw new RuntimeException("Stub!"); }
}

/**
 * Helper class for generating large-format notifications that include multiple back-and-forth
 * messages of varying types between any number of people.
 *
 * <p>
 * If the platform does not provide large-format notifications, this method has no effect. The
 * user will always see the normal notification view.
 *
 * <p>
 * If the app is targeting Android P and above, it is required to use the {@link android.app.Person Person}
 * class in order to get an optimal rendering of the notification and its avatars. For
 * conversations involving multiple people, the app should also make sure that it marks the
 * conversation as a group with {@link #setGroupConversation(boolean)}.
 *
 * <p>
 * This class is a "rebuilder": It attaches to a Builder object and modifies its behavior.
 * Here's an example of how this may be used:
 * <pre class="prettyprint">
 *
 * Person user = new Person.Builder().setIcon(userIcon).setName(userName).build();
 * MessagingStyle style = new MessagingStyle(user)
 *      .addMessage(messages[1].getText(), messages[1].getTime(), messages[1].getPerson())
 *      .addMessage(messages[2].getText(), messages[2].getTime(), messages[2].getPerson())
 *      .setGroupConversation(hasMultiplePeople());
 *
 * Notification noti = new Notification.Builder()
 *     .setContentTitle(&quot;2 new messages with &quot; + sender.toString())
 *     .setContentText(subject)
 *     .setSmallIcon(R.drawable.new_message)
 *     .setLargeIcon(aBitmap)
 *     .setStyle(style)
 *     .build();
 * </pre>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MessagingStyle extends android.app.Notification.Style {

/**
 * @param userDisplayName Required - the name to be displayed for any replies sent by the
 * user before the posting app reposts the notification with those messages after they've
 * been actually sent and in previous messages sent by the user added in
 * {@link #addMessage(android.app.Notification.MessagingStyle.Message)}
 *
 * This value must never be {@code null}.
 * @deprecated use {@code MessagingStyle(Person)}
 * @apiSince 24
 */

@Deprecated
public MessagingStyle(@androidx.annotation.NonNull java.lang.CharSequence userDisplayName) { throw new RuntimeException("Stub!"); }

/**
 * @param user Required - The person displayed for any messages that are sent by the
 * user. Any messages added with {@link #addMessage(android.app.Notification.MessagingStyle.Message)}
 * who don't have a Person associated with it will be displayed as if they were sent
 * by this user. The user also needs to have a valid name associated with it, which will
 * be enforced starting in Android P.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public MessagingStyle(@androidx.annotation.NonNull android.app.Person user) { throw new RuntimeException("Stub!"); }

/**
 * @return the user to be displayed for any replies sent by the user
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Person getUser() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name to be displayed for any replies sent by the user
 *
 * @deprecated use {@link #getUser()} instead
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.CharSequence getUserDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the title to be displayed on this conversation. May be set to {@code null}.
 *
 * <p>This API's behavior was changed in SDK version {@link android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}. If your
 * application's target version is less than {@link android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}, setting a
 * conversation title to a non-null value will make {@link #isGroupConversation()} return
 * {@code true} and passing {@code null} will make it return {@code false}. In
 * {@link android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} and beyond, use {@link #setGroupConversation(boolean)}
 * to set group conversation status.
 *
 * @param conversationTitle Title displayed for this conversation
 * This value may be {@code null}.
 * @return this object for method chaining
 * @apiSince 24
 */

public android.app.Notification.MessagingStyle setConversationTitle(@androidx.annotation.Nullable java.lang.CharSequence conversationTitle) { throw new RuntimeException("Stub!"); }

/**
 * Return the title to be displayed on this conversation. May return {@code null}.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getConversationTitle() { throw new RuntimeException("Stub!"); }

/**
 * Adds a message for display by this notification. Convenience call for a simple
 * {@link android.app.Notification.MessagingStyle.Message Message} in {@link #addMessage(android.app.Notification.MessagingStyle.Message)}.
 * @param text A {@link java.lang.CharSequence CharSequence} to be displayed as the message content
 * @param timestamp Time at which the message arrived
 * @param sender A {@link java.lang.CharSequence CharSequence} to be used for displaying the name of the
 * sender. Should be <code>null</code> for messages by the current user, in which case
 * the platform will insert {@link #getUserDisplayName()}.
 * Should be unique amongst all individuals in the conversation, and should be
 * consistent during re-posts of the notification.
 *
 * @see Message#Notification.MessagingStyle.Message(CharSequence, long, CharSequence)
 *
 * @return this object for method chaining
 *
 * @deprecated use {@link #addMessage(java.lang.CharSequence,long,android.app.Person)}
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.MessagingStyle addMessage(java.lang.CharSequence text, long timestamp, java.lang.CharSequence sender) { throw new RuntimeException("Stub!"); }

/**
 * Adds a message for display by this notification. Convenience call for a simple
 * {@link android.app.Notification.MessagingStyle.Message Message} in {@link #addMessage(android.app.Notification.MessagingStyle.Message)}.
 * @param text A {@link java.lang.CharSequence CharSequence} to be displayed as the message content
 * This value must never be {@code null}.
 * @param timestamp Time at which the message arrived
 * @param sender The {@link android.app.Person Person} who sent the message.
 * Should be <code>null</code> for messages by the current user, in which case
 * the platform will insert the user set in {@code MessagingStyle(Person)}.
 *
 * This value may be {@code null}.
 * @see Message#Notification.MessagingStyle.Message(CharSequence, long, CharSequence)
 *
 * @return this object for method chaining
 * @apiSince 28
 */

public android.app.Notification.MessagingStyle addMessage(@androidx.annotation.NonNull java.lang.CharSequence text, long timestamp, @androidx.annotation.Nullable android.app.Person sender) { throw new RuntimeException("Stub!"); }

/**
 * Adds a {@link android.app.Notification.MessagingStyle.Message Message} for display in this notification.
 *
 * <p>The messages should be added in chronologic order, i.e. the oldest first,
 * the newest last.
 *
 * @param message The {@link android.app.Notification.MessagingStyle.Message Message} to be displayed
 * @return this object for method chaining
 * @apiSince 24
 */

public android.app.Notification.MessagingStyle addMessage(android.app.Notification.MessagingStyle.Message message) { throw new RuntimeException("Stub!"); }

/**
 * Adds a {@link android.app.Notification.MessagingStyle.Message Message} for historic context in this notification.
 *
 * <p>Messages should be added as historic if they are not the main subject of the
 * notification but may give context to a conversation. The system may choose to present
 * them only when relevant, e.g. when replying to a message through a {@link android.app.RemoteInput RemoteInput}.
 *
 * <p>The messages should be added in chronologic order, i.e. the oldest first,
 * the newest last.
 *
 * @param message The historic {@link android.app.Notification.MessagingStyle.Message Message} to be added
 * @return this object for method chaining
 * @apiSince 26
 */

public android.app.Notification.MessagingStyle addHistoricMessage(android.app.Notification.MessagingStyle.Message message) { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of {@code Message} objects that represent the notification
 * @apiSince 24
 */

public java.util.List<android.app.Notification.MessagingStyle.Message> getMessages() { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of historic {@code Message}s in the notification.
 * @apiSince 26
 */

public java.util.List<android.app.Notification.MessagingStyle.Message> getHistoricMessages() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this conversation notification represents a group. If the app is targeting
 * Android P, this is required if the app wants to display the largeIcon set with
 * {@link android.app.Notification.Builder#setLargeIcon(android.graphics.Bitmap) Notification.Builder#setLargeIcon(Bitmap)}, otherwise it will be hidden.
 *
 * @param isGroupConversation {@code true} if the conversation represents a group,
 * {@code false} otherwise.
 * @return this object for method chaining
 * @apiSince 28
 */

public android.app.Notification.MessagingStyle setGroupConversation(boolean isGroupConversation) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this notification represents a group conversation, otherwise
 * {@code false}.
 *
 * <p> If the application that generated this {@link android.app.Notification.MessagingStyle MessagingStyle} targets an SDK version
 * less than {@link android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}, this method becomes dependent on whether or
 * not the conversation title is set; returning {@code true} if the conversation title is
 * a non-null value, or {@code false} otherwise. From {@link android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} forward,
 * this method returns what's set by {@link #setGroupConversation(boolean)} allowing for
 * named, non-group conversations.
 *
 * @see #setConversationTitle(CharSequence)
 * @apiSince 28
 */

public boolean isGroupConversation() { throw new RuntimeException("Stub!"); }

/**
 * The maximum number of messages that will be retained in the Notification itself (the
 * number displayed is up to the platform).
 * @apiSince 24
 */

public static final int MAXIMUM_RETAINED_MESSAGES = 25; // 0x19
/** @apiSince 24 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Message {

/**
 * Constructor
 * @param text A {@link java.lang.CharSequence CharSequence} to be displayed as the message content
 * @param timestamp Time at which the message arrived
 * @param sender A {@link java.lang.CharSequence CharSequence} to be used for displaying the name of the
 * sender. Should be <code>null</code> for messages by the current user, in which case
 * the platform will insert {@link android.app.Notification.MessagingStyle#getUserDisplayName() MessagingStyle#getUserDisplayName()}.
 * Should be unique amongst all individuals in the conversation, and should be
 * consistent during re-posts of the notification.
 *
 *  @deprecated use {@code Message(CharSequence, long, Person)}
 * @apiSince 24
 */

@Deprecated
public Message(java.lang.CharSequence text, long timestamp, java.lang.CharSequence sender) { throw new RuntimeException("Stub!"); }

/**
 * Constructor
 * @param text A {@link java.lang.CharSequence CharSequence} to be displayed as the message content
 * This value must never be {@code null}.
 * @param timestamp Time at which the message arrived
 * @param sender The {@link android.app.Person Person} who sent the message.
 * Should be <code>null</code> for messages by the current user, in which case
 * the platform will insert the user set in {@code MessagingStyle(Person)}.
 * <p>
 * The person provided should contain an Icon, set with
 * {@link android.app.Person.Builder#setIcon(android.graphics.drawable.Icon) Person.Builder#setIcon(Icon)} and also have a name provided
 * with {@link android.app.Person.Builder#setName(java.lang.CharSequence) Person.Builder#setName(CharSequence)}. If multiple users have the same
 * name, consider providing a key with {@link android.app.Person.Builder#setKey(java.lang.String) Person.Builder#setKey(String)} in order
 * to differentiate between the different users.
 * </p>
 
 * This value may be {@code null}.
 * @apiSince 28
 */

public Message(@androidx.annotation.NonNull java.lang.CharSequence text, long timestamp, @androidx.annotation.Nullable android.app.Person sender) { throw new RuntimeException("Stub!"); }

/**
 * Sets a binary blob of data and an associated MIME type for a message. In the case
 * where the platform doesn't support the MIME type, the original text provided in the
 * constructor will be used.
 * @param dataMimeType The MIME type of the content. See
 * <a href="{@docRoot}notifications/messaging.html"> for the list of supported MIME
 * types on Android and Android Wear.
 * @param dataUri The uri containing the content whose type is given by the MIME type.
 * <p class="note">
 * <ol>
 *   <li>Notification Listeners including the System UI need permission to access the
 *       data the Uri points to. The recommended ways to do this are:</li>
 *   <li>Store the data in your own ContentProvider, making sure that other apps have
 *       the correct permission to access your provider. The preferred mechanism for
 *       providing access is to use per-URI permissions which are temporary and only
 *       grant access to the receiving application. An easy way to create a
 *       ContentProvider like this is to use the FileProvider helper class.</li>
 *   <li>Use the system MediaStore. The MediaStore is primarily aimed at video, audio
 *       and image MIME types, however beginning with Android 3.0 (API level 11) it can
 *       also store non-media types (see MediaStore.Files for more info). Files can be
 *       inserted into the MediaStore using scanFile() after which a content:// style
 *       Uri suitable for sharing is passed to the provided onScanCompleted() callback.
 *       Note that once added to the system MediaStore the content is accessible to any
 *       app on the device.</li>
 * </ol>
 * @return this object for method chaining
 * @apiSince 24
 */

public android.app.Notification.MessagingStyle.Message setData(java.lang.String dataMimeType, android.net.Uri dataUri) { throw new RuntimeException("Stub!"); }

/**
 * Get the text to be used for this message, or the fallback text if a type and content
 * Uri have been set
 * @apiSince 24
 */

public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Get the time at which this message arrived
 * @apiSince 24
 */

public long getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the extras Bundle for this message.
 * @apiSince 26
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Get the text used to display the contact's name in the messaging experience
 *
 * @deprecated use {@link #getSenderPerson()}
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.CharSequence getSender() { throw new RuntimeException("Stub!"); }

/**
 * Get the sender associated with this message.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.app.Person getSenderPerson() { throw new RuntimeException("Stub!"); }

/**
 * Get the MIME type of the data pointed to by the Uri
 * @apiSince 24
 */

public java.lang.String getDataMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Get the Uri pointing to the content of the message. Can be null, in which case
 * {@see #getText()} is used.
 * @apiSince 24
 */

public android.net.Uri getDataUri() { throw new RuntimeException("Stub!"); }
}

}

/**
 * An object that can apply a rich notification style to a {@link android.app.Notification.Builder Notification.Builder}
 * object.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Style {

public Style() { throw new RuntimeException("Stub!"); }

/**
 * Overrides ContentTitle in the big form of the template.
 * This defaults to the value passed to setContentTitle().
 * @apiSince 16
 */

protected void internalSetBigContentTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the first line of text after the detail section in the big form of the template.
 * @apiSince 16
 */

protected void internalSetSummaryText(java.lang.CharSequence cs) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void setBuilder(android.app.Notification.Builder builder) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

protected void checkBuilder() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

protected android.widget.RemoteViews getStandardView(int layoutId) { throw new RuntimeException("Stub!"); }

/**
 * Calls {@link android.app.Notification.Builder#build()} on the Builder this Style is
 * attached to.
 *
 * @return the fully constructed Notification.
 * @apiSince 16
 */

public android.app.Notification build() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

protected android.app.Notification.Builder mBuilder;
}

/**
 * Helper class to add wearable extensions to notifications.
 * <p class="note"> See
 * <a href="{@docRoot}wear/notifications/creating.html">Creating Notifications
 * for Android Wear</a> for more information on how to use this class.
 * <p>
 * To create a notification with wearable extensions:
 * <ol>
 *   <li>Create a {@link android.app.Notification.Builder}, setting any desired
 *   properties.
 *   <li>Create a {@link android.app.Notification.WearableExtender}.
 *   <li>Set wearable-specific properties using the
 *   {@code add} and {@code set} methods of {@link android.app.Notification.WearableExtender}.
 *   <li>Call {@link android.app.Notification.Builder#extend} to apply the extensions to a
 *   notification.
 *   <li>Post the notification to the notification system with the
 *   {@code NotificationManager.notify(...)} methods.
 * </ol>
 *
 * <pre class="prettyprint">
 * Notification notif = new Notification.Builder(mContext)
 *         .setContentTitle(&quot;New mail from &quot; + sender.toString())
 *         .setContentText(subject)
 *         .setSmallIcon(R.drawable.new_mail)
 *         .extend(new Notification.WearableExtender()
 *                 .setContentIcon(R.drawable.new_mail))
 *         .build();
 * NotificationManager notificationManger =
 *         (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
 * notificationManger.notify(0, notif);</pre>
 *
 * <p>Wearable extensions can be accessed on an existing notification by using the
 * {@code WearableExtender(Notification)} constructor,
 * and then using the {@code get} methods to access values.
 *
 * <pre class="prettyprint">
 * Notification.WearableExtender wearableExtender = new Notification.WearableExtender(
 *         notification);
 * List&lt;Notification&gt; pages = wearableExtender.getPages();</pre>
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class WearableExtender implements android.app.Notification.Extender {

/**
 * Create a {@link android.app.Notification.WearableExtender} with default
 * options.
 * @apiSince 20
 */

public WearableExtender() { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public WearableExtender(android.app.Notification notif) { throw new RuntimeException("Stub!"); }

/**
 * Apply wearable extensions to a notification that is being built. This is typically
 * called by the {@link android.app.Notification.Builder#extend} method of
 * {@link android.app.Notification.Builder}.
 * @apiSince 20
 */

public android.app.Notification.Builder extend(android.app.Notification.Builder builder) { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public android.app.Notification.WearableExtender clone() { throw new RuntimeException("Stub!"); }

/**
 * Add a wearable action to this notification.
 *
 * <p>When wearable actions are added using this method, the set of actions that
 * show on a wearable device splits from devices that only show actions added
 * using {@link android.app.Notification.Builder#addAction}. This allows for customization
 * of which actions display on different devices.
 *
 * @param action the action to add to this notification
 * @return this object for method chaining
 * @see android.app.Notification.Action
 * @apiSince 20
 */

public android.app.Notification.WearableExtender addAction(android.app.Notification.Action action) { throw new RuntimeException("Stub!"); }

/**
 * Adds wearable actions to this notification.
 *
 * <p>When wearable actions are added using this method, the set of actions that
 * show on a wearable device splits from devices that only show actions added
 * using {@link android.app.Notification.Builder#addAction}. This allows for customization
 * of which actions display on different devices.
 *
 * @param actions the actions to add to this notification
 * @return this object for method chaining
 * @see android.app.Notification.Action
 * @apiSince 20
 */

public android.app.Notification.WearableExtender addActions(java.util.List<android.app.Notification.Action> actions) { throw new RuntimeException("Stub!"); }

/**
 * Clear all wearable actions present on this builder.
 * @return this object for method chaining.
 * @see #addAction
 * @apiSince 20
 */

public android.app.Notification.WearableExtender clearActions() { throw new RuntimeException("Stub!"); }

/**
 * Get the wearable actions present on this notification.
 * @apiSince 20
 */

public java.util.List<android.app.Notification.Action> getActions() { throw new RuntimeException("Stub!"); }

/**
 * Set an intent to launch inside of an activity view when displaying
 * this notification. The {@link android.app.PendingIntent PendingIntent} provided should be for an activity.
 *
 * <pre class="prettyprint">
 * Intent displayIntent = new Intent(context, MyDisplayActivity.class);
 * PendingIntent displayPendingIntent = PendingIntent.getActivity(context,
 *         0, displayIntent, PendingIntent.FLAG_UPDATE_CURRENT);
 * Notification notif = new Notification.Builder(context)
 *         .extend(new Notification.WearableExtender()
 *                 .setDisplayIntent(displayPendingIntent)
 *                 .setCustomSizePreset(Notification.WearableExtender.SIZE_MEDIUM))
 *         .build();</pre>
 *
 * <p>The activity to launch needs to allow embedding, must be exported, and
 * should have an empty task affinity. It is also recommended to use the device
 * default light theme.
 *
 * <p>Example AndroidManifest.xml entry:
 * <pre class="prettyprint">
 * &lt;activity android:name=&quot;com.example.MyDisplayActivity&quot;
 *     android:exported=&quot;true&quot;
 *     android:allowEmbedded=&quot;true&quot;
 *     android:taskAffinity=&quot;&quot;
 *     android:theme=&quot;@android:style/Theme.DeviceDefault.Light&quot; /&gt;</pre>
 *
 * @param intent the {@link android.app.PendingIntent PendingIntent} for an activity
 * @return this object for method chaining
 * @see android.app.Notification.WearableExtender#getDisplayIntent
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Notification.WearableExtender setDisplayIntent(android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Get the intent to launch inside of an activity view when displaying this
 * notification. This {@code PendingIntent} should be for an activity.
 *
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public android.app.PendingIntent getDisplayIntent() { throw new RuntimeException("Stub!"); }

/**
 * Add an additional page of content to display with this notification. The current
 * notification forms the first page, and pages added using this function form
 * subsequent pages. This field can be used to separate a notification into multiple
 * sections.
 *
 * @param page the notification to add as another page
 * @return this object for method chaining
 * @see android.app.Notification.WearableExtender#getPages
 * @deprecated Multiple content pages are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Notification.WearableExtender addPage(android.app.Notification page) { throw new RuntimeException("Stub!"); }

/**
 * Add additional pages of content to display with this notification. The current
 * notification forms the first page, and pages added using this function form
 * subsequent pages. This field can be used to separate a notification into multiple
 * sections.
 *
 * @param pages a list of notifications
 * @return this object for method chaining
 * @see android.app.Notification.WearableExtender#getPages
 * @deprecated Multiple content pages are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Notification.WearableExtender addPages(java.util.List<android.app.Notification> pages) { throw new RuntimeException("Stub!"); }

/**
 * Clear all additional pages present on this builder.
 * @return this object for method chaining.
 * @see #addPage
 * @deprecated Multiple content pages are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Notification.WearableExtender clearPages() { throw new RuntimeException("Stub!"); }

/**
 * Get the array of additional pages of content for displaying this notification. The
 * current notification forms the first page, and elements within this array form
 * subsequent pages. This field can be used to separate a notification into multiple
 * sections.
 * @return the pages for this notification
 * @deprecated Multiple content pages are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public java.util.List<android.app.Notification> getPages() { throw new RuntimeException("Stub!"); }

/**
 * Set a background image to be displayed behind the notification content.
 * Contrary to the {@link android.app.Notification.BigPictureStyle}, this background
 * will work with any notification style.
 *
 * @param background the background bitmap
 * @return this object for method chaining
 * @see android.app.Notification.WearableExtender#getBackground
 * @deprecated Background images are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Notification.WearableExtender setBackground(android.graphics.Bitmap background) { throw new RuntimeException("Stub!"); }

/**
 * Get a background image to be displayed behind the notification content.
 * Contrary to the {@link android.app.Notification.BigPictureStyle}, this background
 * will work with any notification style.
 *
 * @return the background image
 * @see android.app.Notification.WearableExtender#setBackground
 * @deprecated Background images are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
public android.graphics.Bitmap getBackground() { throw new RuntimeException("Stub!"); }

/**
 * Set an icon that goes with the content of this notification.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setContentIcon(int icon) { throw new RuntimeException("Stub!"); }

/**
 * Get an icon that goes with the content of this notification.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public int getContentIcon() { throw new RuntimeException("Stub!"); }

/**
 * Set the gravity that the content icon should have within the notification display.
 * Supported values include {@link android.view.Gravity#START} and
 * {@link android.view.Gravity#END}. The default value is {@link android.view.Gravity#END}.
 * @see #setContentIcon
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setContentIconGravity(int contentIconGravity) { throw new RuntimeException("Stub!"); }

/**
 * Get the gravity that the content icon should have within the notification display.
 * Supported values include {@link android.view.Gravity#START} and
 * {@link android.view.Gravity#END}. The default value is {@link android.view.Gravity#END}.
 * @see #getContentIcon
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public int getContentIconGravity() { throw new RuntimeException("Stub!"); }

/**
 * Set an action from this notification's actions as the primary action. If the action has a
 * {@link android.app.RemoteInput RemoteInput} associated with it, shortcuts to the options for that input are shown
 * directly on the notification.
 *
 * @param actionIndex The index of the primary action.
 *                    If wearable actions were added to the main notification, this index
 *                    will apply to that list, otherwise it will apply to the regular
 *                    actions list.
 * @apiSince 20
 */

public android.app.Notification.WearableExtender setContentAction(int actionIndex) { throw new RuntimeException("Stub!"); }

/**
 * Get the index of the notification action, if any, that was specified as the primary
 * action.
 *
 * <p>If wearable specific actions were added to the main notification, this index will
 * apply to that list, otherwise it will apply to the regular actions list.
 *
 * @return the action index or {@link #UNSET_ACTION_INDEX} if no action was selected.
 * @apiSince 20
 */

public int getContentAction() { throw new RuntimeException("Stub!"); }

/**
 * Set the gravity that this notification should have within the available viewport space.
 * Supported values include {@link android.view.Gravity#TOP},
 * {@link android.view.Gravity#CENTER_VERTICAL} and {@link android.view.Gravity#BOTTOM}.
 * The default value is {@link android.view.Gravity#BOTTOM}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Get the gravity that this notification should have within the available viewport space.
 * Supported values include {@link android.view.Gravity#TOP},
 * {@link android.view.Gravity#CENTER_VERTICAL} and {@link android.view.Gravity#BOTTOM}.
 * The default value is {@link android.view.Gravity#BOTTOM}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public int getGravity() { throw new RuntimeException("Stub!"); }

/**
 * Set the custom size preset for the display of this notification out of the available
 * presets found in {@link android.app.Notification.WearableExtender}, e.g.
 * {@link #SIZE_LARGE}.
 * <p>Some custom size presets are only applicable for custom display notifications created
 * using {@link android.app.Notification.WearableExtender#setDisplayIntent}. Check the
 * documentation for the preset in question. See also
 * {@link #setCustomContentHeight} and {@link #getCustomSizePreset}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setCustomSizePreset(int sizePreset) { throw new RuntimeException("Stub!"); }

/**
 * Get the custom size preset for the display of this notification out of the available
 * presets found in {@link android.app.Notification.WearableExtender}, e.g.
 * {@link #SIZE_LARGE}.
 * <p>Some custom size presets are only applicable for custom display notifications created
 * using {@link #setDisplayIntent}. Check the documentation for the preset in question.
 * See also {@link #setCustomContentHeight} and {@link #setCustomSizePreset}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public int getCustomSizePreset() { throw new RuntimeException("Stub!"); }

/**
 * Set the custom height in pixels for the display of this notification's content.
 * <p>This option is only available for custom display notifications created
 * using {@link android.app.Notification.WearableExtender#setDisplayIntent}. See also
 * {@link android.app.Notification.WearableExtender#setCustomSizePreset} and
 * {@link #getCustomContentHeight}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setCustomContentHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * Get the custom height in pixels for the display of this notification's content.
 * <p>This option is only available for custom display notifications created
 * using {@link #setDisplayIntent}. See also {@link #setCustomSizePreset} and
 * {@link #setCustomContentHeight}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public int getCustomContentHeight() { throw new RuntimeException("Stub!"); }

/**
 * Set whether the scrolling position for the contents of this notification should start
 * at the bottom of the contents instead of the top when the contents are too long to
 * display within the screen.  Default is false (start scroll at the top).
 * @apiSince 20
 */

public android.app.Notification.WearableExtender setStartScrollBottom(boolean startScrollBottom) { throw new RuntimeException("Stub!"); }

/**
 * Get whether the scrolling position for the contents of this notification should start
 * at the bottom of the contents instead of the top when the contents are too long to
 * display within the screen. Default is false (start scroll at the top).
 * @apiSince 20
 */

public boolean getStartScrollBottom() { throw new RuntimeException("Stub!"); }

/**
 * Set whether the content intent is available when the wearable device is not connected
 * to a companion device.  The user can still trigger this intent when the wearable device
 * is offline, but a visual hint will indicate that the content intent may not be available.
 * Defaults to true.
 * @apiSince 20
 */

public android.app.Notification.WearableExtender setContentIntentAvailableOffline(boolean contentIntentAvailableOffline) { throw new RuntimeException("Stub!"); }

/**
 * Get whether the content intent is available when the wearable device is not connected
 * to a companion device.  The user can still trigger this intent when the wearable device
 * is offline, but a visual hint will indicate that the content intent may not be available.
 * Defaults to true.
 * @apiSince 20
 */

public boolean getContentIntentAvailableOffline() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint that this notification's icon should not be displayed.
 * @param hintHideIcon {@code true} to hide the icon, {@code false} otherwise.
 * @return this object for method chaining
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setHintHideIcon(boolean hintHideIcon) { throw new RuntimeException("Stub!"); }

/**
 * Get a hint that this notification's icon should not be displayed.
 * @return {@code true} if this icon should not be displayed, false otherwise.
 * The default value is {@code false} if this was never set.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public boolean getHintHideIcon() { throw new RuntimeException("Stub!"); }

/**
 * Set a visual hint that only the background image of this notification should be
 * displayed, and other semantic content should be hidden. This hint is only applicable
 * to sub-pages added using {@link #addPage}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setHintShowBackgroundOnly(boolean hintShowBackgroundOnly) { throw new RuntimeException("Stub!"); }

/**
 * Get a visual hint that only the background image of this notification should be
 * displayed, and other semantic content should be hidden. This hint is only applicable
 * to sub-pages added using {@link android.app.Notification.WearableExtender#addPage}.
 * @apiSince 20
 * @deprecatedSince 28
 */

@Deprecated
public boolean getHintShowBackgroundOnly() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint that this notification's background should not be clipped if possible,
 * and should instead be resized to fully display on the screen, retaining the aspect
 * ratio of the image. This can be useful for images like barcodes or qr codes.
 * @param hintAvoidBackgroundClipping {@code true} to avoid clipping if possible.
 * @return this object for method chaining
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setHintAvoidBackgroundClipping(boolean hintAvoidBackgroundClipping) { throw new RuntimeException("Stub!"); }

/**
 * Get a hint that this notification's background should not be clipped if possible,
 * and should instead be resized to fully display on the screen, retaining the aspect
 * ratio of the image. This can be useful for images like barcodes or qr codes.
 * @return {@code true} if it's ok if the background is clipped on the screen, false
 * otherwise. The default value is {@code false} if this was never set.
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public boolean getHintAvoidBackgroundClipping() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint that the screen should remain on for at least this duration when
 * this notification is displayed on the screen.
 * @param timeout The requested screen timeout in milliseconds. Can also be either
 *     {@link #SCREEN_TIMEOUT_SHORT} or {@link #SCREEN_TIMEOUT_LONG}.
 * @return this object for method chaining
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Notification.WearableExtender setHintScreenTimeout(int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Get the duration, in milliseconds, that the screen should remain on for
 * when this notification is displayed.
 * @return the duration in milliseconds if > 0, or either one of the sentinel values
 *     {@link #SCREEN_TIMEOUT_SHORT} or {@link #SCREEN_TIMEOUT_LONG}.
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public int getHintScreenTimeout() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint that this notification's {@link android.app.Notification.BigPictureStyle BigPictureStyle} (if present) should be
 * converted to low-bit and displayed in ambient mode, especially useful for barcodes and
 * qr codes, as well as other simple black-and-white tickets.
 * @param hintAmbientBigPicture {@code true} to enable converstion and ambient.
 * @return this object for method chaining
 * @deprecated This feature is no longer supported.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Notification.WearableExtender setHintAmbientBigPicture(boolean hintAmbientBigPicture) { throw new RuntimeException("Stub!"); }

/**
 * Get a hint that this notification's {@link android.app.Notification.BigPictureStyle BigPictureStyle} (if present) should be
 * converted to low-bit and displayed in ambient mode, especially useful for barcodes and
 * qr codes, as well as other simple black-and-white tickets.
 * @return {@code true} if it should be displayed in ambient, false otherwise
 * otherwise. The default value is {@code false} if this was never set.
 * @deprecated This feature is no longer supported.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public boolean getHintAmbientBigPicture() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint that this notification's content intent will launch an {@link android.app.Activity Activity}
 * directly, telling the platform that it can generate the appropriate transitions.
 * @param hintContentIntentLaunchesActivity {@code true} if the content intent will launch
 * an activity and transitions should be generated, false otherwise.
 * @return this object for method chaining
 * @apiSince 24
 */

public android.app.Notification.WearableExtender setHintContentIntentLaunchesActivity(boolean hintContentIntentLaunchesActivity) { throw new RuntimeException("Stub!"); }

/**
 * Get a hint that this notification's content intent will launch an {@link android.app.Activity Activity}
 * directly, telling the platform that it can generate the appropriate transitions
 * @return {@code true} if the content intent will launch an activity and transitions should
 * be generated, false otherwise. The default value is {@code false} if this was never set.
 * @apiSince 24
 */

public boolean getHintContentIntentLaunchesActivity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the dismissal id for this notification. If a notification is posted with a
 * dismissal id, then when that notification is canceled, notifications on other wearables
 * and the paired Android phone having that same dismissal id will also be canceled. See
 * <a href="{@docRoot}wear/notifications/index.html">Adding Wearable Features to
 * Notifications</a> for more information.
 * @param dismissalId the dismissal id of the notification.
 * @return this object for method chaining
 * @apiSince 24
 */

public android.app.Notification.WearableExtender setDismissalId(java.lang.String dismissalId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the dismissal id of the notification.
 * @return the dismissal id of the notification or null if it has not been set.
 * @apiSince 24
 */

public java.lang.String getDismissalId() { throw new RuntimeException("Stub!"); }

/**
 * Sets a bridge tag for this notification. A bridge tag can be set for notifications
 * posted from a phone to provide finer-grained control on what notifications are bridged
 * to wearables. See <a href="{@docRoot}wear/notifications/index.html">Adding Wearable
 * Features to Notifications</a> for more information.
 * @param bridgeTag the bridge tag of the notification.
 * @return this object for method chaining
 * @apiSince 26
 */

public android.app.Notification.WearableExtender setBridgeTag(java.lang.String bridgeTag) { throw new RuntimeException("Stub!"); }

/**
 * Returns the bridge tag of the notification.
 * @return the bridge tag or null if not present.
 * @apiSince 26
 */

public java.lang.String getBridgeTag() { throw new RuntimeException("Stub!"); }

/**
 * Sentinel value for use with {@link #setHintScreenTimeout} to keep the screen on
 * for a longer amount of time when this notification is displayed on the screen.
 *
 * @deprecated This feature is no longer supported.
 * @apiSince 22
 * @deprecatedSince 29
 */

@Deprecated public static final int SCREEN_TIMEOUT_LONG = -1; // 0xffffffff

/**
 * Sentinel value for use with {@link #setHintScreenTimeout} to keep the screen on for a
 * short amount of time when this notification is displayed on the screen. This
 * is the default value.
 *
 * @deprecated This feature is no longer supported.
 * @apiSince 22
 * @deprecatedSince 29
 */

@Deprecated public static final int SCREEN_TIMEOUT_SHORT = 0; // 0x0

/**
 * Size value for use with {@link #setCustomSizePreset} to show this notification with
 * default sizing.
 * <p>For custom display notifications created using {@link #setDisplayIntent},
 * the default is {@link #SIZE_MEDIUM}. All other notifications size automatically based
 * on their content.
 *
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated public static final int SIZE_DEFAULT = 0; // 0x0

/**
 * Size value for use with {@link #setCustomSizePreset} to show this notification
 * full screen.
 * <p>This value is only applicable for custom display notifications created using
 * {@link #setDisplayIntent}.
 *
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated public static final int SIZE_FULL_SCREEN = 5; // 0x5

/**
 * Size value for use with {@link #setCustomSizePreset} to show this notification
 * with a large size.
 * <p>This value is only applicable for custom display notifications created using
 * {@link #setDisplayIntent}.
 *
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated public static final int SIZE_LARGE = 4; // 0x4

/**
 * Size value for use with {@link #setCustomSizePreset} to show this notification
 * with a medium size.
 * <p>This value is only applicable for custom display notifications created using
 * {@link #setDisplayIntent}.
 *
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated public static final int SIZE_MEDIUM = 3; // 0x3

/**
 * Size value for use with {@link #setCustomSizePreset} to show this notification
 * with a small size.
 * <p>This value is only applicable for custom display notifications created using
 * {@link #setDisplayIntent}.
 *
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated public static final int SIZE_SMALL = 2; // 0x2

/**
 * Size value for use with {@link #setCustomSizePreset} to show this notification
 * with an extra small size.
 * <p>This value is only applicable for custom display notifications created using
 * {@link #setDisplayIntent}.
 *
 * @deprecated Display intents are no longer supported.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated public static final int SIZE_XSMALL = 1; // 0x1

/**
 * Sentinel value for an action index that is unset.
 * @apiSince 20
 */

public static final int UNSET_ACTION_INDEX = -1; // 0xffffffff
}

}

