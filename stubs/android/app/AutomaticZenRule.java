/**
 * Copyright (c) 2015, The Android Open Source Project
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


package android.app;

import android.service.notification.Condition;
import android.service.notification.ZenPolicy;
import android.content.ComponentName;
import android.net.Uri;

/**
 * Rule instance information for zen mode.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AutomaticZenRule implements android.os.Parcelable {

/**
 * Creates an automatic zen rule.
 *
 * @param name The name of the rule.
 * @param owner The Condition Provider service that owns this rule.
 * @param interruptionFilter The interruption filter defines which notifications are allowed to
 *                           interrupt the user (e.g. via sound &amp; vibration) while this rule
 *                           is active.
 * @param enabled Whether the rule is enabled.
 * @deprecated use {@link #AutomaticZenRule(java.lang.String,android.content.ComponentName,android.content.ComponentName,android.net.Uri,android.service.notification.ZenPolicy,int,boolean)}.
 * @apiSince 24
 */

@Deprecated
public AutomaticZenRule(java.lang.String name, android.content.ComponentName owner, android.net.Uri conditionId, int interruptionFilter, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Creates an automatic zen rule.
 *
 * @param name The name of the rule.
 * This value must never be {@code null}.
 * @param owner The Condition Provider service that owns this rule. This can be null if you're
 *              using {@link android.app.NotificationManager#setAutomaticZenRuleState(java.lang.String,android.service.notification.Condition) NotificationManager#setAutomaticZenRuleState(String, Condition)}
 *              instead of {@link android.service.notification.ConditionProviderService}.
 * This value may be {@code null}.
 * @param configurationActivity An activity that handles
 *                              {@link android.app.NotificationManager#ACTION_AUTOMATIC_ZEN_RULE NotificationManager#ACTION_AUTOMATIC_ZEN_RULE} that shows
 *                              the user
 *                              more information about this rule and/or allows them to
 *                              configure it. This is required if you are not using a
 *                              {@link android.service.notification.ConditionProviderService}.
 *                              If you are, it overrides the information specified in your
 *                              manifest.
 * This value may be {@code null}.
 * @param conditionId A representation of the state that should cause your app to apply the
 *                    given interruption filter.
 * This value must never be {@code null}.
 * @param interruptionFilter The interruption filter defines which notifications are allowed to
 *                           interrupt the user (e.g. via sound &amp; vibration) while this rule
 *                           is active.
 * @param policy The policy defines which notifications are allowed to interrupt the user
 *               while this rule is active. This overrides the global policy while this rule is
 *               action ({@link android.service.notification.Condition#STATE_TRUE Condition#STATE_TRUE}).
 * This value may be {@code null}.
 * @param enabled Whether the rule is enabled.
 * @apiSince 29
 */

public AutomaticZenRule(@androidx.annotation.NonNull java.lang.String name, @androidx.annotation.Nullable android.content.ComponentName owner, @androidx.annotation.Nullable android.content.ComponentName configurationActivity, @androidx.annotation.NonNull android.net.Uri conditionId, @androidx.annotation.Nullable android.service.notification.ZenPolicy policy, int interruptionFilter, boolean enabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public AutomaticZenRule(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.ComponentName ComponentName} of the condition provider service that owns this rule.
 * @apiSince 24
 */

public android.content.ComponentName getOwner() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.ComponentName ComponentName} of the activity that shows configuration options
 * for this rule.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.content.ComponentName getConfigurationActivity() { throw new RuntimeException("Stub!"); }

/**
 * Returns the representation of the state that causes this rule to become active.
 * @apiSince 24
 */

public android.net.Uri getConditionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interruption filter that is applied when this rule is active.
 * @apiSince 24
 */

public int getInterruptionFilter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this rule.
 * @apiSince 24
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this rule is enabled.
 * @apiSince 24
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Gets the zen policy.
 * @apiSince 29
 */

public android.service.notification.ZenPolicy getZenPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time this rule was created, represented as milliseconds since the epoch.
 * @apiSince 24
 */

public long getCreationTime() { throw new RuntimeException("Stub!"); }

/**
 * Sets the representation of the state that causes this rule to become active.
 * @apiSince 24
 */

public void setConditionId(android.net.Uri conditionId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the interruption filter that is applied when this rule is active.
 * @param interruptionFilter The do not disturb mode to enter when this rule is active.
 
 * Value is {@link android.app.NotificationManager#INTERRUPTION_FILTER_NONE}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_PRIORITY}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALARMS}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALL}, or {@link android.app.NotificationManager#INTERRUPTION_FILTER_UNKNOWN}
 * @apiSince 24
 */

public void setInterruptionFilter(int interruptionFilter) { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of this rule.
 * @apiSince 24
 */

public void setName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Enables this rule.
 * @apiSince 24
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets the zen policy.
 * @apiSince 29
 */

public void setZenPolicy(android.service.notification.ZenPolicy zenPolicy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the configuration activity - an activity that handles
 * {@link android.app.NotificationManager#ACTION_AUTOMATIC_ZEN_RULE NotificationManager#ACTION_AUTOMATIC_ZEN_RULE} that shows the user more information
 * about this rule and/or allows them to configure it. This is required to be non-null for rules
 * that are not backed by {@link android.service.notification.ConditionProviderService}.
 
 * @param componentName This value may be {@code null}.
 * @apiSince 29
 */

public void setConfigurationActivity(@androidx.annotation.Nullable android.content.ComponentName componentName) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.AutomaticZenRule> CREATOR;
static { CREATOR = null; }
}

