/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.service.notification;

import android.app.Notification;
import android.app.NotificationChannel;

/**
 * ZenPolicy determines whether to allow certain notifications and their corresponding sounds to
 * play when a device is in Do Not Disturb mode.
 * ZenPolicy also dictates the visual effects of notifications that are intercepted when
 * a device is in Do Not Disturb mode.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ZenPolicy implements android.os.Parcelable {

ZenPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Message senders that can bypass DND.
 * @return {@link #PEOPLE_TYPE_UNSET}, {@link #PEOPLE_TYPE_ANYONE},
 * {@link #PEOPLE_TYPE_CONTACTS}, {@link #PEOPLE_TYPE_STARRED} or {@link #PEOPLE_TYPE_NONE}
 
 * Value is {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_UNSET}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_ANYONE}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_CONTACTS}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_STARRED}, or {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_NONE}
 * @apiSince 29
 */

public int getPriorityMessageSenders() { throw new RuntimeException("Stub!"); }

/**
 * Callers that can bypass DND.
 * @return {@link #PEOPLE_TYPE_UNSET}, {@link #PEOPLE_TYPE_ANYONE},
 * {@link #PEOPLE_TYPE_CONTACTS}, {@link #PEOPLE_TYPE_STARRED} or {@link #PEOPLE_TYPE_NONE}
 
 * Value is {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_UNSET}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_ANYONE}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_CONTACTS}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_STARRED}, or {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_NONE}
 * @apiSince 29
 */

public int getPriorityCallSenders() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow notifications with category
 * {@link android.app.Notification#CATEGORY_REMINDER Notification#CATEGORY_REMINDER} to play sounds and visually appear
 * or to intercept them when DND is active.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategoryReminders() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow notifications with category
 * {@link android.app.Notification#CATEGORY_EVENT Notification#CATEGORY_EVENT} to play sounds and visually appear
 * or to intercept them when DND is active.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategoryEvents() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow notifications with category
 * {@link android.app.Notification#CATEGORY_MESSAGE Notification#CATEGORY_MESSAGE} to play sounds and visually appear
 * or to intercept them when DND is active.  Types of message senders that are allowed
 * are specified by {@link #getPriorityMessageSenders}.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategoryMessages() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow notifications with category
 * {@link android.app.Notification#CATEGORY_CALL Notification#CATEGORY_CALL} to play sounds and visually appear
 * or to intercept them when DND is active.  Types of callers that are allowed
 * are specified by {@link #getPriorityCallSenders()}.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategoryCalls() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow repeat callers (notifications with category
 * {@link android.app.Notification#CATEGORY_CALL Notification#CATEGORY_CALL} that have recently called) to play sounds and
 * visually appear or to intercept them when DND is active.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategoryRepeatCallers() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow notifications with category
 * {@link android.app.Notification#CATEGORY_ALARM Notification#CATEGORY_ALARM} to play sounds and visually appear
 * or to intercept them when DND is active.
 * When alarms are {@link #STATE_DISALLOW disallowed}, the alarm stream will be muted when DND
 * is active.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategoryAlarms() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow media notifications to play sounds and visually appear
 * or to intercept them when DND is active.
 * When media is {@link #STATE_DISALLOW disallowed}, the media stream will be muted when DND is
 * active.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategoryMedia() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy wants to allow system sounds when DND is active.
 * When system is {@link #STATE_DISALLOW}, the system stream will be muted when DND is active.
 * @return {@link #STATE_UNSET}, {@link #STATE_ALLOW} or {@link #STATE_DISALLOW}
 
 * Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getPriorityCategorySystem() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy allows {@link android.app.Notification#fullScreenIntent Notification#fullScreenIntent} from
 * notifications intercepted by DND.
 
 * @return Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getVisualEffectFullScreenIntent() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy allows {@link android.app.NotificationChannel#shouldShowLights() NotificationChannel#shouldShowLights()} from notifications intercepted by DND.
 
 * @return Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getVisualEffectLights() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy allows peeking from notifications intercepted by DND.
 
 * @return Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getVisualEffectPeek() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy allows notifications intercepted by DND from appearing in the status bar
 * on devices that support status bars.
 
 * @return Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getVisualEffectStatusBar() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy allows {@link android.app.NotificationChannel#canShowBadge() NotificationChannel#canShowBadge()} from
 * notifications intercepted by DND on devices that support badging.
 
 * @return Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getVisualEffectBadge() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy allows notifications intercepted by DND from appearing on ambient
 * displays on devices that support ambient display.
 
 * @return Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getVisualEffectAmbient() { throw new RuntimeException("Stub!"); }

/**
 * Whether this policy allows notifications intercepted by DND from appearing in notification
 * list views like the notification shade or lockscreen on devices that support those
 * views.
 
 * @return Value is {@link android.service.notification.ZenPolicy#STATE_UNSET}, {@link android.service.notification.ZenPolicy#STATE_ALLOW}, or {@link android.service.notification.ZenPolicy#STATE_DISALLOW}
 * @apiSince 29
 */

public int getVisualEffectNotificationList() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.notification.ZenPolicy> CREATOR;
static { CREATOR = null; }

/**
 * Used to indicate all calls or messages can bypass dnd.
 * @apiSince 29
 */

public static final int PEOPLE_TYPE_ANYONE = 1; // 0x1

/**
 * Used to indicate calls or messages from contacts can bypass dnd.
 * @apiSince 29
 */

public static final int PEOPLE_TYPE_CONTACTS = 2; // 0x2

/**
 * Used to indicate no calls or messages can bypass dnd.
 * @apiSince 29
 */

public static final int PEOPLE_TYPE_NONE = 4; // 0x4

/**
 * Used to indicate calls or messages from starred contacts can bypass dnd.
 * @apiSince 29
 */

public static final int PEOPLE_TYPE_STARRED = 3; // 0x3

/**
 * Used to indicate no preference for the type of people that can bypass dnd for either
 * calls or messages.
 * @apiSince 29
 */

public static final int PEOPLE_TYPE_UNSET = 0; // 0x0

/**
 * Indicates a type of sound or visual effect is allowed to play/show when DND is active.
 * @apiSince 29
 */

public static final int STATE_ALLOW = 1; // 0x1

/**
 * Indicates a type of sound or visual effect is not allowed to play/show when DND is active.
 * @apiSince 29
 */

public static final int STATE_DISALLOW = 2; // 0x2

/**
 * Indicates no preference for whether a type of sound or visual effect is or isn't allowed
 * to play/show when DND is active.  Will default to the current set policy.
 * @apiSince 29
 */

public static final int STATE_UNSET = 0; // 0x0
/**
 * Builder class for {@link android.service.notification.ZenPolicy ZenPolicy} objects.
 * Provides a convenient way to set the various fields of a {@link android.service.notification.ZenPolicy ZenPolicy}.  If a field
 * is not set, it is (@link STATE_UNSET} and will not change the current set policy.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/** @apiSince 29 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Builds the current ZenPolicy.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy build() { throw new RuntimeException("Stub!"); }

/**
 * Allows all notifications to bypass DND and unmutes all streams.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowAllSounds() { throw new RuntimeException("Stub!"); }

/**
 * Intercepts all notifications and prevents them from playing sounds
 * when DND is active. Also mutes alarm, system and media streams.
 * Notification channels can still play sounds only if they
 * {@link android.app.NotificationChannel#canBypassDnd NotificationChannel#canBypassDnd}. If no channels can bypass DND,
 * the ringer stream is also muted.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder disallowAllSounds() { throw new RuntimeException("Stub!"); }

/**
 * Allows notifications intercepted by DND to show on all surfaces when DND is active.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showAllVisualEffects() { throw new RuntimeException("Stub!"); }

/**
 * Disallows notifications intercepted by DND from showing when DND is active.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder hideAllVisualEffects() { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow notifications with category {@link android.app.Notification#CATEGORY_REMINDER Notification#CATEGORY_REMINDER}
 * to play sounds and visually appear or to intercept them when DND is active.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowReminders(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow notifications with category {@link android.app.Notification#CATEGORY_EVENT Notification#CATEGORY_EVENT}
 * to play sounds and visually appear or to intercept them when DND is active.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowEvents(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow notifications with category {@link android.app.Notification#CATEGORY_MESSAGE Notification#CATEGORY_MESSAGE}
 * that match audienceType to play sounds and visually appear or to intercept
 * them when DND is active.
 * @param audienceType message senders that are allowed to bypass DND
 
 * Value is {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_UNSET}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_ANYONE}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_CONTACTS}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_STARRED}, or {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_NONE}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowMessages(int audienceType) { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow notifications with category {@link android.app.Notification#CATEGORY_CALL Notification#CATEGORY_CALL}
 * that match audienceType to play sounds and visually appear or to intercept
 * them when DND is active.
 * @param audienceType callers that are allowed to bypass DND
 
 * Value is {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_UNSET}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_ANYONE}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_CONTACTS}, {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_STARRED}, or {@link android.service.notification.ZenPolicy#PEOPLE_TYPE_NONE}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowCalls(int audienceType) { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow repeat callers (notifications with category
 * {@link android.app.Notification#CATEGORY_CALL Notification#CATEGORY_CALL} that have recently called
 * to play sounds and visually appear.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowRepeatCallers(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow notifications with category {@link android.app.Notification#CATEGORY_ALARM Notification#CATEGORY_ALARM}
 * to play sounds and visually appear or to intercept them when DND is active.
 * Disallowing alarms will mute the alarm stream when DND is active.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowAlarms(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow media notifications to play sounds and visually
 * appear or to intercept them when DND is active.
 * Disallowing media will mute the media stream when DND is active.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowMedia(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Whether to allow system sounds to play when DND is active.
 * Disallowing system sounds will mute the system stream when DND is active.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder allowSystem(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Whether {@link android.app.Notification#fullScreenIntent Notification#fullScreenIntent} that are intercepted
 * by DND are shown.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showFullScreenIntent(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Whether {@link android.app.NotificationChannel#shouldShowLights() NotificationChannel#shouldShowLights()} from
 * notifications intercepted by DND are blocked.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showLights(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Whether notifications intercepted by DND are prevented from peeking.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showPeeking(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Whether notifications intercepted by DND are prevented from appearing in the status bar
 * on devices that support status bars.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showStatusBarIcons(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Whether {@link android.app.NotificationChannel#canShowBadge() NotificationChannel#canShowBadge()} from
 * notifications intercepted by DND are allowed on devices that support badging.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showBadges(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Whether notification intercepted by DND are prevented from appearing on ambient displays
 * on devices that support ambient display.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showInAmbientDisplay(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Whether notification intercepted by DND are prevented from appearing in notification
 * list views like the notification shade or lockscreen on devices that support those
 * views.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.notification.ZenPolicy.Builder showInNotificationList(boolean show) { throw new RuntimeException("Stub!"); }
}

}

