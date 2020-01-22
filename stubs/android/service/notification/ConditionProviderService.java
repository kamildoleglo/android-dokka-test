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


package android.service.notification;

import android.content.ComponentName;
import android.app.ActivityManager;
import android.net.Uri;
import android.content.Intent;

/**
 * A service that provides conditions about boolean state.
 * <p>To extend this class, you must declare the service in your manifest file with
 * the {@link android.Manifest.permission#BIND_CONDITION_PROVIDER_SERVICE} permission
 * and include an intent filter with the {@link #SERVICE_INTERFACE} action. If you want users to be
 * able to create and update conditions for this service to monitor, include the
 * {@link #META_DATA_RULE_TYPE} and {@link #META_DATA_CONFIGURATION_ACTIVITY} tags and request the
 * {@link android.Manifest.permission#ACCESS_NOTIFICATION_POLICY} permission. For example:</p>
 * <pre>
 * &lt;service android:name=".MyConditionProvider"
 *          android:label="&#64;string/service_name"
 *          android:permission="android.permission.BIND_CONDITION_PROVIDER_SERVICE">
 *     &lt;intent-filter>
 *         &lt;action android:name="android.service.notification.ConditionProviderService" />
 *     &lt;/intent-filter>
 *     &lt;meta-data
 *               android:name="android.service.zen.automatic.ruleType"
 *               android:value="@string/my_condition_rule">
 *           &lt;/meta-data>
 *           &lt;meta-data
 *               android:name="android.service.zen.automatic.configurationActivity"
 *               android:value="com.my.package/.MyConditionConfigurationActivity">
 *           &lt;/meta-data>
 * &lt;/service></pre>
 *
 *  <p> Condition providers cannot be bound by the system on
 * {@link android.app.ActivityManager#isLowRamDevice() ActivityManager#isLowRamDevice()} devices</p>
 *
 * @deprecated Instead of using an automatically bound service, use
 * {@link android.app.NotificationManager#setAutomaticZenRuleState(String, Condition)} to tell the
 * system about the state of your rule. In order to maintain a link from
 * Settings to your rule configuration screens, provide a configuration activity that handles
 * {@link android.app.NotificationManager#ACTION_AUTOMATIC_ZEN_RULE} on your
 * {@link android.app.AutomaticZenRule} via
 * {@link android.app.AutomaticZenRule#setConfigurationActivity(ComponentName)}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class ConditionProviderService extends android.app.Service {

@Deprecated
public ConditionProviderService() { throw new RuntimeException("Stub!"); }

/**
 * Called when this service is connected.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public abstract void onConnected();

/**
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public void onRequestConditions(int relevance) { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when there is a new {@link android.service.notification.Condition Condition} to be managed by this provider.
 * @param conditionId the Uri describing the criteria of the condition.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public abstract void onSubscribe(android.net.Uri conditionId);

/**
 * Called by the system when a {@link android.service.notification.Condition Condition} has been deleted.
 * @param conditionId the Uri describing the criteria of the deleted condition.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public abstract void onUnsubscribe(android.net.Uri conditionId);

/**
 * Request that the provider be rebound, after a previous call to (@link #requestUnbind).
 *
 * <p>This method will fail for providers that have not been granted the permission by the user.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public static final void requestRebind(android.content.ComponentName componentName) { throw new RuntimeException("Stub!"); }

/**
 * Request that the provider service be unbound.
 *
 * <p>This will no longer receive subscription updates and will not be able to update the
 * state of conditions until {@link #requestRebind(android.content.ComponentName)} is called.
 * The service will likely be killed by the system after this call.
 *
 * <p>The service should wait for the {@link #onConnected()} event before performing this
 * operation.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public final void requestUnbind() { throw new RuntimeException("Stub!"); }

/**
 * Informs the notification manager that the state of a Condition has changed. Use this method
 * to put the system into Do Not Disturb mode or request that it exits Do Not Disturb mode. This
 * call will be ignored unless there is an enabled {@link android.app.AutomaticZenRule} owned by
 * service that has an {@link android.app.AutomaticZenRule#getConditionId()} equal to this
 * {@link android.service.notification.Condition#id Condition#id}.
 * @param condition the condition that has changed.
 *
 * @deprecated see
 * {@link android.app.NotificationManager#setAutomaticZenRuleState(String, Condition)}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public final void notifyCondition(android.service.notification.Condition condition) { throw new RuntimeException("Stub!"); }

/**
 * Informs the notification manager that the state of one or more Conditions has changed. See
 * {@link #notifyCondition(android.service.notification.Condition)} for restrictions.
 * @param conditions the changed conditions.
 *
 * @deprecated see
 *       {@link android.app.NotificationManager#setAutomaticZenRuleState(String, Condition)}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public final void notifyConditions(android.service.notification.Condition... conditions) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * A String rule id extra passed to {@link #META_DATA_CONFIGURATION_ACTIVITY}.
 *
 * @deprecated see {@link android.app.NotificationManager#EXTRA_AUTOMATIC_RULE_ID}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_RULE_ID = "android.service.notification.extra.RULE_ID";

/**
 * The name of the {@code meta-data} tag containing the {@link android.content.ComponentName ComponentName} of an activity
 * that allows users to configure the conditions provided by this service.
 *
 * @deprecated see {@link android.app.NotificationManager#ACTION_AUTOMATIC_ZEN_RULE}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String META_DATA_CONFIGURATION_ACTIVITY = "android.service.zen.automatic.configurationActivity";

/**
 * The name of the {@code meta-data} tag containing the maximum number of rule instances that
 * can be created for this rule type. Omit or enter a value <= 0 to allow unlimited instances.
 *
 * @deprecated see {@link android.app.NotificationManager#META_DATA_RULE_INSTANCE_LIMIT}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String META_DATA_RULE_INSTANCE_LIMIT = "android.service.zen.automatic.ruleInstanceLimit";

/**
 * The name of the {@code meta-data} tag containing a localized name of the type of zen rules
 * provided by this service.
 *
 * @deprecated see {@link android.app.NotificationManager#META_DATA_AUTOMATIC_RULE_TYPE}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String META_DATA_RULE_TYPE = "android.service.zen.automatic.ruleType";

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String SERVICE_INTERFACE = "android.service.notification.ConditionProviderService";
}

