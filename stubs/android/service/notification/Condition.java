/**
 * Copyright (c) 2014, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.service.notification;


/**
 * The current condition of an {@link android.app.AutomaticZenRule}, provided by the
 * app that owns the rule. Used to tell the system to enter Do Not
 * Disturb mode and request that the system exit Do Not Disturb mode.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Condition implements android.os.Parcelable {

/**
 * An object representing the current state of a {@link android.app.AutomaticZenRule}.
 * @param id the {@link android.app.AutomaticZenRule#getConditionId()} of the zen rule
 * @param summary a user visible description of the rule state.
 * @apiSince 24
 */

public Condition(android.net.Uri id, java.lang.String summary, int state) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public Condition(android.net.Uri id, java.lang.String summary, java.lang.String line1, java.lang.String line2, int icon, int state, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public Condition(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public static java.lang.String stateToString(int state) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public static java.lang.String relevanceToString(int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.service.notification.Condition copy() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public static android.net.Uri.Builder newId(android.content.Context context) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public static boolean isValidId(android.net.Uri id, java.lang.String pkg) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.notification.Condition> CREATOR;
static { CREATOR = null; }

/** @apiSince 24 */

public static final int FLAG_RELEVANT_ALWAYS = 2; // 0x2

/** @apiSince 24 */

public static final int FLAG_RELEVANT_NOW = 1; // 0x1

/** @apiSince 24 */

public static final java.lang.String SCHEME = "condition";

/** @apiSince 24 */

public static final int STATE_ERROR = 3; // 0x3

/**
 * Indicates that Do Not Disturb should be turned off. Note that all Conditions from all
 * {@link android.app.AutomaticZenRule} providers must be off for Do Not Disturb to be turned
 * off on the device.
 * @apiSince 24
 */

public static final int STATE_FALSE = 0; // 0x0

/**
 * Indicates that Do Not Disturb should be turned on.
 * @apiSince 24
 */

public static final int STATE_TRUE = 1; // 0x1

/** @apiSince 24 */

public static final int STATE_UNKNOWN = 2; // 0x2

/** @apiSince 24 */

public final int flags;
{ flags = 0; }

/** @apiSince 24 */

public final int icon;
{ icon = 0; }

/**
 * The URI representing the rule being updated.
 * See {@link android.app.AutomaticZenRule#getConditionId()}.
 * @apiSince 24
 */

public final android.net.Uri id;
{ id = null; }

/** @apiSince 24 */

public final java.lang.String line1;
{ line1 = null; }

/** @apiSince 24 */

public final java.lang.String line2;
{ line2 = null; }

/**
 * The state of this condition. {@link #STATE_TRUE} will enable Do Not Disturb mode.
 * {@link #STATE_FALSE} will turn Do Not Disturb off for this rule. Note that Do Not Disturb
 * might still be enabled globally if other conditions are in a {@link #STATE_TRUE} state.
 
 * <br>
 * Value is {@link android.service.notification.Condition#STATE_FALSE}, {@link android.service.notification.Condition#STATE_TRUE}, {@link android.service.notification.Condition#STATE_UNKNOWN}, or {@link android.service.notification.Condition#STATE_ERROR}
 * @apiSince 24
 */

public final int state;
{ state = 0; }

/**
 * A summary of what the rule encoded in {@link #id} means when it is enabled. User visible
 * if the state of the condition is {@link #STATE_TRUE}.
 * @apiSince 24
 */

public final java.lang.String summary;
{ summary = null; }
}

