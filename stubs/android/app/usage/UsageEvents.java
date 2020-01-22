/**
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package android.app.usage;

import android.content.res.Configuration;

/**
 * A result returned from {@link android.app.usage.UsageStatsManager#queryEvents(long, long)}
 * from which to read {@link android.app.usage.UsageEvents.Event} objects.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UsageEvents implements android.os.Parcelable {

UsageEvents() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not there are more events to read using
 * {@link #getNextEvent(android.app.usage.UsageEvents.Event)}.
 *
 * @return true if there are more events, false otherwise.
 * @apiSince 21
 */

public boolean hasNextEvent() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the next {@link android.app.usage.UsageEvents.Event} from the collection and put the
 * resulting data into {@code eventOut}.
 *
 * @param eventOut The {@link android.app.usage.UsageEvents.Event} object that will receive the
 *                 next event data.
 * @return true if an event was available, false if there are no more events.
 * @apiSince 21
 */

public boolean getNextEvent(android.app.usage.UsageEvents.Event eventOut) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.usage.UsageEvents> CREATOR;
static { CREATOR = null; }
/**
 * An event representing a state change for a component.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Event {

/** @apiSince 21 */

public Event() { throw new RuntimeException("Stub!"); }

/**
 * The package name of the source of this event.
 * @apiSince 21
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * The class name of the source of this event. This may be null for
 * certain events.
 * @apiSince 21
 */

public java.lang.String getClassName() { throw new RuntimeException("Stub!"); }

/**
 * The time at which this event occurred, measured in milliseconds since the epoch.
 * <p/>
 * See {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 * @apiSince 21
 */

public long getTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * The event type.
 * @see #ACTIVITY_PAUSED
 * @see #ACTIVITY_RESUMED
 * @see #CONFIGURATION_CHANGE
 * @see #USER_INTERACTION
 * @see #STANDBY_BUCKET_CHANGED
 * @see #FOREGROUND_SERVICE_START
 * @see #FOREGROUND_SERVICE_STOP
 * @see #ACTIVITY_STOPPED
 * @apiSince 21
 */

public int getEventType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.content.res.Configuration Configuration} for this event if the event is of type
 * {@link #CONFIGURATION_CHANGE}, otherwise it returns null.
 * @apiSince 21
 */

public android.content.res.Configuration getConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of a {@link android.content.pm.ShortcutInfo} for this event
 * if the event is of type {@link #SHORTCUT_INVOCATION}, otherwise it returns null.
 *
 * @see android.content.pm.ShortcutManager#reportShortcutUsed(String)
 * @apiSince 25
 */

public java.lang.String getShortcutId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the standby bucket of the app, if the event is of type
 * {@link #STANDBY_BUCKET_CHANGED}, otherwise returns 0.
 * @return the standby bucket associated with the event.
 *
 * @apiSince 28
 */

public int getAppStandbyBucket() { throw new RuntimeException("Stub!"); }

/**
 * An event type denoting that an {@link android.app.Activity} moved to the background.
 * This event has a package name and class name associated with it and can be retrieved
 * using {@link #getPackageName()} and {@link #getClassName()}.
 * If a package has multiple activities, this event is reported for each activity that moves
 * to background.
 * This event is corresponding to {@link android.app.Activity#onPause()} of the activity's
 * lifecycle.
 * @apiSince 29
 */

public static final int ACTIVITY_PAUSED = 2; // 0x2

/**
 * An event type denoting that an {@link android.app.Activity} moved to the foreground.
 * This event has a package name and class name associated with it and can be retrieved
 * using {@link #getPackageName()} and {@link #getClassName()}.
 * If a package has multiple activities, this event is reported for each activity that moves
 * to foreground.
 * This event is corresponding to {@link android.app.Activity#onResume()} of the
 * activity's lifecycle.
 * @apiSince 29
 */

public static final int ACTIVITY_RESUMED = 1; // 0x1

/**
 * An activity becomes invisible on the UI, corresponding to
 * {@link android.app.Activity#onStop()} of the activity's lifecycle.
 * @apiSince 29
 */

public static final int ACTIVITY_STOPPED = 23; // 0x17

/**
 * An event type denoting that the device configuration has changed.
 * @apiSince 21
 */

public static final int CONFIGURATION_CHANGE = 5; // 0x5

/**
 * An event type denoting that the Android runtime underwent a shutdown process.
 * A DEVICE_SHUTDOWN event should be treated as if all started activities and foreground
 * services are now stopped and no explicit {@link #ACTIVITY_STOPPED} and
 * {@link #FOREGROUND_SERVICE_STOP} events will be generated for them.
 *
 * <p>The DEVICE_SHUTDOWN timestamp is actually the last time UsageStats database is
 * persisted before the actual shutdown. Events (if there are any) between this timestamp
 * and the actual shutdown is not persisted in the database. So any open events without
 * matching close events between DEVICE_SHUTDOWN and {@link #DEVICE_STARTUP} should be
 * ignored because the closing time is unknown.</p>
 * @apiSince 29
 */

public static final int DEVICE_SHUTDOWN = 26; // 0x1a

/**
 * An event type denoting that the Android runtime started up. This could be after a
 * shutdown or a runtime restart. Any open events without matching close events between
 * {@link #DEVICE_SHUTDOWN} and DEVICE_STARTUP should be ignored because the closing time is
 * unknown.
 * @apiSince 29
 */

public static final int DEVICE_STARTUP = 27; // 0x1b

/**
 * An event type denoting start of a foreground service.
 * This event has a package name and class name associated with it and can be retrieved
 * using {@link #getPackageName()} and {@link #getClassName()}.
 * If a package has multiple foreground services, this event is reported for each service
 * that is started.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_START = 19; // 0x13

/**
 * An event type denoting stop of a foreground service.
 * This event has a package name and class name associated with it and can be retrieved
 * using {@link #getPackageName()} and {@link #getClassName()}.
 * If a package has multiple foreground services, this event is reported for each service
 * that is stopped.
 * @apiSince 29
 */

public static final int FOREGROUND_SERVICE_STOP = 20; // 0x14

/**
 * An event type denoting that the screen's keyguard has been hidden.  This typically
 * happens when the user unlocks their phone after turning it on.
 * @apiSince 28
 */

public static final int KEYGUARD_HIDDEN = 18; // 0x12

/**
 * An event type denoting that the screen's keyguard has been shown, whether or not
 * the screen is off.
 * @apiSince 28
 */

public static final int KEYGUARD_SHOWN = 17; // 0x11

/**
 * @deprecated by {@link #ACTIVITY_PAUSED}
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated public static final int MOVE_TO_BACKGROUND = 2; // 0x2

/**
 * @deprecated by {@link #ACTIVITY_RESUMED}
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated public static final int MOVE_TO_FOREGROUND = 1; // 0x1

/**
 * No event type.
 * @apiSince 21
 */

public static final int NONE = 0; // 0x0

/**
 * An event type denoting that the screen has gone in to an interactive state (turned
 * on for full user interaction, not ambient display or other non-interactive state).
 * @apiSince 28
 */

public static final int SCREEN_INTERACTIVE = 15; // 0xf

/**
 * An event type denoting that the screen has gone in to a non-interactive state
 * (completely turned off or turned on only in a non-interactive state like ambient
 * display).
 * @apiSince 28
 */

public static final int SCREEN_NON_INTERACTIVE = 16; // 0x10

/**
 * An event type denoting that an action equivalent to a ShortcutInfo is taken by the user.
 *
 * @see android.content.pm.ShortcutManager#reportShortcutUsed(String)
 * @apiSince 25
 */

public static final int SHORTCUT_INVOCATION = 8; // 0x8

/**
 * An event type denoting a change in App Standby Bucket. The new bucket can be
 * retrieved by calling {@link #getAppStandbyBucket()}.
 *
 * @see android.app.usage.UsageStatsManager#getAppStandbyBucket()
 * @apiSince 28
 */

public static final int STANDBY_BUCKET_CHANGED = 11; // 0xb

/**
 * An event type denoting that a package was interacted with in some way by the user.
 * @apiSince 23
 */

public static final int USER_INTERACTION = 7; // 0x7
}

}

