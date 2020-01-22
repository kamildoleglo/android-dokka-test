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

import android.content.Context;
import android.os.Handler;
import android.content.Intent;
import android.os.Build;

/**
 * This class provides access to the system alarm services.  These allow you
 * to schedule your application to be run at some point in the future.  When
 * an alarm goes off, the {@link android.content.Intent Intent} that had been registered for it
 * is broadcast by the system, automatically starting the target application
 * if it is not already running.  Registered alarms are retained while the
 * device is asleep (and can optionally wake the device up if they go off
 * during that time), but will be cleared if it is turned off and rebooted.
 *
 * <p>The Alarm Manager holds a CPU wake lock as long as the alarm receiver's
 * onReceive() method is executing. This guarantees that the phone will not sleep
 * until you have finished handling the broadcast. Once onReceive() returns, the
 * Alarm Manager releases this wake lock. This means that the phone will in some
 * cases sleep as soon as your onReceive() method completes.  If your alarm receiver
 * called {@link android.content.Context#startService Context.startService()}, it
 * is possible that the phone will sleep before the requested service is launched.
 * To prevent this, your BroadcastReceiver and Service will need to implement a
 * separate wake lock policy to ensure that the phone continues running until the
 * service becomes available.
 *
 * <p><b>Note: The Alarm Manager is intended for cases where you want to have
 * your application code run at a specific time, even if your application is
 * not currently running.  For normal timing operations (ticks, timeouts,
 * etc) it is easier and much more efficient to use
 * {@link android.os.Handler}.</b>
 *
 * <p class="caution"><strong>Note:</strong> Beginning with API 19
 * ({@link android.os.Build.VERSION_CODES#KITKAT}) alarm delivery is inexact:
 * the OS will shift alarms in order to minimize wakeups and battery use.  There are
 * new APIs to support applications which need strict delivery guarantees; see
 * {@link #setWindow(int,long,long,android.app.PendingIntent)} and
 * {@link #setExact(int,long,android.app.PendingIntent)}.  Applications whose {@code targetSdkVersion}
 * is earlier than API 19 will continue to see the previous behavior in which all
 * alarms are delivered exactly when requested.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AlarmManager {

AlarmManager() { throw new RuntimeException("Stub!"); }

/**
 * <p>Schedule an alarm.  <b>Note: for timing operations (ticks, timeouts,
 * etc) it is easier and much more efficient to use {@link android.os.Handler}.</b>
 * If there is already an alarm scheduled for the same IntentSender, that previous
 * alarm will first be canceled.
 *
 * <p>If the stated trigger time is in the past, the alarm will be triggered
 * immediately.  If there is already an alarm for this Intent
 * scheduled (with the equality of two intents being defined by
 * {@link android.content.Intent#filterEquals Intent#filterEquals}), then it will be removed and replaced by
 * this one.
 *
 * <p>
 * The alarm is an Intent broadcast that goes to a broadcast receiver that
 * you registered with {@link android.content.Context#registerReceiver}
 * or through the &lt;receiver&gt; tag in an AndroidManifest.xml file.
 *
 * <p>
 * Alarm intents are delivered with a data extra of type int called
 * {@link android.content.Intent#EXTRA_ALARM_COUNT Intent#EXTRA_ALARM_COUNT} that indicates
 * how many past alarm events have been accumulated into this intent
 * broadcast.  Recurring alarms that have gone undelivered because the
 * phone was asleep may have a count greater than one when delivered.
 *
 * <div class="note">
 * <p>
 * <b>Note:</b> Beginning in API 19, the trigger time passed to this method
 * is treated as inexact: the alarm will not be delivered before this time, but
 * may be deferred and delivered some time later.  The OS will use
 * this policy in order to "batch" alarms together across the entire system,
 * minimizing the number of times the device needs to "wake up" and minimizing
 * battery use.  In general, alarms scheduled in the near future will not
 * be deferred as long as alarms scheduled far in the future.
 *
 * <p>
 * With the new batching policy, delivery ordering guarantees are not as
 * strong as they were previously.  If the application sets multiple alarms,
 * it is possible that these alarms' <em>actual</em> delivery ordering may not match
 * the order of their <em>requested</em> delivery times.  If your application has
 * strong ordering requirements there are other APIs that you can use to get
 * the necessary behavior; see {@link #setWindow(int,long,long,android.app.PendingIntent)}
 * and {@link #setExact(int,long,android.app.PendingIntent)}.
 *
 * <p>
 * Applications whose {@code targetSdkVersion} is before API 19 will
 * continue to get the previous alarm behavior: all of their scheduled alarms
 * will be treated as exact.
 * </div>
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param triggerAtMillis time in milliseconds that the alarm should go
 * off, using the appropriate clock (depending on the alarm type).
 * @param operation Action to perform when the alarm goes off;
 * typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see android.os.Handler
 * @see #setExact
 * @see #setRepeating
 * @see #setWindow
 * @see #cancel
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @see #ELAPSED_REALTIME
 * @see #ELAPSED_REALTIME_WAKEUP
 * @see #RTC
 * @see #RTC_WAKEUP
 * @apiSince 1
 */

public void set(int type, long triggerAtMillis, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Direct callback version of {@link #set(int,long,android.app.PendingIntent)}.  Rather than
 * supplying a PendingIntent to be sent when the alarm time is reached, this variant
 * supplies an {@link android.app.AlarmManager.OnAlarmListener OnAlarmListener} instance that will be invoked at that time.
 * <p>
 * The OnAlarmListener's {@link android.app.AlarmManager.OnAlarmListener#onAlarm() OnAlarmListener#onAlarm()} method will be
 * invoked via the specified target Handler, or on the application's main looper
 * if {@code null} is passed as the {@code targetHandler} parameter.
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param triggerAtMillis time in milliseconds that the alarm should go
 *         off, using the appropriate clock (depending on the alarm type).
 * @param tag string describing the alarm, used for logging and battery-use
 *         attribution
 * @param listener {@link android.app.AlarmManager.OnAlarmListener OnAlarmListener} instance whose
 *         {@link android.app.AlarmManager.OnAlarmListener#onAlarm() OnAlarmListener#onAlarm()} method will be
 *         called when the alarm time is reached.  A given OnAlarmListener instance can
 *         only be the target of a single pending alarm, just as a given PendingIntent
 *         can only be used with one alarm at a time.
 * @param targetHandler {@link android.os.Handler Handler} on which to execute the listener's onAlarm()
 *         callback, or {@code null} to run that callback on the main looper.
 * @apiSince 24
 */

public void set(int type, long triggerAtMillis, java.lang.String tag, android.app.AlarmManager.OnAlarmListener listener, android.os.Handler targetHandler) { throw new RuntimeException("Stub!"); }

/**
 * Schedule a repeating alarm.  <b>Note: for timing operations (ticks,
 * timeouts, etc) it is easier and much more efficient to use
 * {@link android.os.Handler}.</b>  If there is already an alarm scheduled
 * for the same IntentSender, it will first be canceled.
 *
 * <p>Like {@link #set}, except you can also supply a period at which
 * the alarm will automatically repeat.  This alarm continues
 * repeating until explicitly removed with {@link #cancel}.  If the stated
 * trigger time is in the past, the alarm will be triggered immediately, with an
 * alarm count depending on how far in the past the trigger time is relative
 * to the repeat interval.
 *
 * <p>If an alarm is delayed (by system sleep, for example, for non
 * _WAKEUP alarm types), a skipped repeat will be delivered as soon as
 * possible.  After that, future alarms will be delivered according to the
 * original schedule; they do not drift over time.  For example, if you have
 * set a recurring alarm for the top of every hour but the phone was asleep
 * from 7:45 until 8:45, an alarm will be sent as soon as the phone awakens,
 * then the next alarm will be sent at 9:00.
 *
 * <p>If your application wants to allow the delivery times to drift in
 * order to guarantee that at least a certain time interval always elapses
 * between alarms, then the approach to take is to use one-time alarms,
 * scheduling the next one yourself when handling each alarm delivery.
 *
 * <p class="note">
 * <b>Note:</b> as of API 19, all repeating alarms are inexact.  If your
 * application needs precise delivery times then it must use one-time
 * exact alarms, rescheduling each time as described above. Legacy applications
 * whose {@code targetSdkVersion} is earlier than API 19 will continue to have all
 * of their alarms, including repeating alarms, treated as exact.
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param triggerAtMillis time in milliseconds that the alarm should first
 * go off, using the appropriate clock (depending on the alarm type).
 * @param intervalMillis interval in milliseconds between subsequent repeats
 * of the alarm.
 * @param operation Action to perform when the alarm goes off;
 * typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see android.os.Handler
 * @see #set
 * @see #setExact
 * @see #setWindow
 * @see #cancel
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @see #ELAPSED_REALTIME
 * @see #ELAPSED_REALTIME_WAKEUP
 * @see #RTC
 * @see #RTC_WAKEUP
 * @apiSince 1
 */

public void setRepeating(int type, long triggerAtMillis, long intervalMillis, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Schedule an alarm to be delivered within a given window of time.  This method
 * is similar to {@link #set(int,long,android.app.PendingIntent)}, but allows the
 * application to precisely control the degree to which its delivery might be
 * adjusted by the OS. This method allows an application to take advantage of the
 * battery optimizations that arise from delivery batching even when it has
 * modest timeliness requirements for its alarms.
 *
 * <p>
 * This method can also be used to achieve strict ordering guarantees among
 * multiple alarms by ensuring that the windows requested for each alarm do
 * not intersect.
 *
 * <p>
 * When precise delivery is not required, applications should use the standard
 * {@link #set(int,long,android.app.PendingIntent)} method.  This will give the OS the most
 * flexibility to minimize wakeups and battery use.  For alarms that must be delivered
 * at precisely-specified times with no acceptable variation, applications can use
 * {@link #setExact(int,long,android.app.PendingIntent)}.
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param windowStartMillis The earliest time, in milliseconds, that the alarm should
 *        be delivered, expressed in the appropriate clock's units (depending on the alarm
 *        type).
 * @param windowLengthMillis The length of the requested delivery window,
 *        in milliseconds.  The alarm will be delivered no later than this many
 *        milliseconds after {@code windowStartMillis}.  Note that this parameter
 *        is a <i>duration,</i> not the timestamp of the end of the window.
 * @param operation Action to perform when the alarm goes off;
 *        typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see #set
 * @see #setExact
 * @see #setRepeating
 * @see #cancel
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @see #ELAPSED_REALTIME
 * @see #ELAPSED_REALTIME_WAKEUP
 * @see #RTC
 * @see #RTC_WAKEUP
 * @apiSince 19
 */

public void setWindow(int type, long windowStartMillis, long windowLengthMillis, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Direct callback version of {@link #setWindow(int,long,long,android.app.PendingIntent)}.  Rather
 * than supplying a PendingIntent to be sent when the alarm time is reached, this variant
 * supplies an {@link android.app.AlarmManager.OnAlarmListener OnAlarmListener} instance that will be invoked at that time.
 * <p>
 * The OnAlarmListener {@link android.app.AlarmManager.OnAlarmListener#onAlarm() OnAlarmListener#onAlarm()} method will be
 * invoked via the specified target Handler, or on the application's main looper
 * if {@code null} is passed as the {@code targetHandler} parameter.
 
 * @param type Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @apiSince 24
 */

public void setWindow(int type, long windowStartMillis, long windowLengthMillis, java.lang.String tag, android.app.AlarmManager.OnAlarmListener listener, android.os.Handler targetHandler) { throw new RuntimeException("Stub!"); }

/**
 * Schedule an alarm to be delivered precisely at the stated time.
 *
 * <p>
 * This method is like {@link #set(int,long,android.app.PendingIntent)}, but does not permit
 * the OS to adjust the delivery time.  The alarm will be delivered as nearly as
 * possible to the requested trigger time.
 *
 * <p>
 * <b>Note:</b> only alarms for which there is a strong demand for exact-time
 * delivery (such as an alarm clock ringing at the requested time) should be
 * scheduled as exact.  Applications are strongly discouraged from using exact
 * alarms unnecessarily as they reduce the OS's ability to minimize battery use.
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param triggerAtMillis time in milliseconds that the alarm should go
 *        off, using the appropriate clock (depending on the alarm type).
 * @param operation Action to perform when the alarm goes off;
 *        typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see #set
 * @see #setRepeating
 * @see #setWindow
 * @see #cancel
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @see #ELAPSED_REALTIME
 * @see #ELAPSED_REALTIME_WAKEUP
 * @see #RTC
 * @see #RTC_WAKEUP
 * @apiSince 19
 */

public void setExact(int type, long triggerAtMillis, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Direct callback version of {@link #setExact(int,long,android.app.PendingIntent)}.  Rather
 * than supplying a PendingIntent to be sent when the alarm time is reached, this variant
 * supplies an {@link android.app.AlarmManager.OnAlarmListener OnAlarmListener} instance that will be invoked at that time.
 * <p>
 * The OnAlarmListener's {@link android.app.AlarmManager.OnAlarmListener#onAlarm() OnAlarmListener#onAlarm()} method will be
 * invoked via the specified target Handler, or on the application's main looper
 * if {@code null} is passed as the {@code targetHandler} parameter.
 
 * @param type Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @apiSince 24
 */

public void setExact(int type, long triggerAtMillis, java.lang.String tag, android.app.AlarmManager.OnAlarmListener listener, android.os.Handler targetHandler) { throw new RuntimeException("Stub!"); }

/**
 * Schedule an alarm that represents an alarm clock, which will be used to notify the user
 * when it goes off.  The expectation is that when this alarm triggers, the application will
 * further wake up the device to tell the user about the alarm -- turning on the screen,
 * playing a sound, vibrating, etc.  As such, the system will typically also use the
 * information supplied here to tell the user about this upcoming alarm if appropriate.
 *
 * <p>Due to the nature of this kind of alarm, similar to {@link #setExactAndAllowWhileIdle},
 * these alarms will be allowed to trigger even if the system is in a low-power idle
 * (a.k.a. doze) mode.  The system may also do some prep-work when it sees that such an
 * alarm coming up, to reduce the amount of background work that could happen if this
 * causes the device to fully wake up -- this is to avoid situations such as a large number
 * of devices having an alarm set at the same time in the morning, all waking up at that
 * time and suddenly swamping the network with pending background work.  As such, these
 * types of alarms can be extremely expensive on battery use and should only be used for
 * their intended purpose.</p>
 *
 * <p>
 * This method is like {@link #setExact(int,long,android.app.PendingIntent)}, but implies
 * {@link #RTC_WAKEUP}.
 *
 * @param info
 * @param operation Action to perform when the alarm goes off;
 *        typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see #set
 * @see #setRepeating
 * @see #setWindow
 * @see #setExact
 * @see #cancel
 * @see #getNextAlarmClock()
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @apiSince 21
 */

public void setAlarmClock(android.app.AlarmManager.AlarmClockInfo info, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Schedule a repeating alarm that has inexact trigger time requirements;
 * for example, an alarm that repeats every hour, but not necessarily at
 * the top of every hour.  These alarms are more power-efficient than
 * the strict recurrences traditionally supplied by {@link #setRepeating}, since the
 * system can adjust alarms' delivery times to cause them to fire simultaneously,
 * avoiding waking the device from sleep more than necessary.
 *
 * <p>Your alarm's first trigger will not be before the requested time,
 * but it might not occur for almost a full interval after that time.  In
 * addition, while the overall period of the repeating alarm will be as
 * requested, the time between any two successive firings of the alarm
 * may vary.  If your application demands very low jitter, use
 * one-shot alarms with an appropriate window instead; see {@link
 * #setWindow(int,long,long,android.app.PendingIntent)} and
 * {@link #setExact(int,long,android.app.PendingIntent)}.
 *
 * <p class="note">
 * As of API 19, all repeating alarms are inexact.  Because this method has
 * been available since API 3, your application can safely call it and be
 * assured that it will get similar behavior on both current and older versions
 * of Android.
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param triggerAtMillis time in milliseconds that the alarm should first
 * go off, using the appropriate clock (depending on the alarm type).  This
 * is inexact: the alarm will not fire before this time, but there may be a
 * delay of almost an entire alarm interval before the first invocation of
 * the alarm.
 * @param intervalMillis interval in milliseconds between subsequent repeats
 * of the alarm.  Prior to API 19, if this is one of INTERVAL_FIFTEEN_MINUTES,
 * INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_HALF_DAY, or INTERVAL_DAY
 * then the alarm will be phase-aligned with other alarms to reduce the
 * number of wakeups.  Otherwise, the alarm will be set as though the
 * application had called {@link #setRepeating}.  As of API 19, all repeating
 * alarms will be inexact and subject to batching with other alarms regardless
 * of their stated repeat interval.
 * @param operation Action to perform when the alarm goes off;
 * typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see android.os.Handler
 * @see #set
 * @see #cancel
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @see #ELAPSED_REALTIME
 * @see #ELAPSED_REALTIME_WAKEUP
 * @see #RTC
 * @see #RTC_WAKEUP
 * @see #INTERVAL_FIFTEEN_MINUTES
 * @see #INTERVAL_HALF_HOUR
 * @see #INTERVAL_HOUR
 * @see #INTERVAL_HALF_DAY
 * @see #INTERVAL_DAY
 * @apiSince 3
 */

public void setInexactRepeating(int type, long triggerAtMillis, long intervalMillis, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #set(int,long,android.app.PendingIntent)}, but this alarm will be allowed to execute
 * even when the system is in low-power idle (a.k.a. doze) modes.  This type of alarm must
 * <b>only</b> be used for situations where it is actually required that the alarm go off while
 * in idle -- a reasonable example would be for a calendar notification that should make a
 * sound so the user is aware of it.  When the alarm is dispatched, the app will also be
 * added to the system's temporary whitelist for approximately 10 seconds to allow that
 * application to acquire further wake locks in which to complete its work.</p>
 *
 * <p>These alarms can significantly impact the power use
 * of the device when idle (and thus cause significant battery blame to the app scheduling
 * them), so they should be used with care.  To reduce abuse, there are restrictions on how
 * frequently these alarms will go off for a particular application.
 * Under normal system operation, it will not dispatch these
 * alarms more than about every minute (at which point every such pending alarm is
 * dispatched); when in low-power idle modes this duration may be significantly longer,
 * such as 15 minutes.</p>
 *
 * <p>Unlike other alarms, the system is free to reschedule this type of alarm to happen
 * out of order with any other alarms, even those from the same app.  This will clearly happen
 * when the device is idle (since this alarm can go off while idle, when any other alarms
 * from the app will be held until later), but may also happen even when not idle.</p>
 *
 * <p>Regardless of the app's target SDK version, this call always allows batching of the
 * alarm.</p>
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param triggerAtMillis time in milliseconds that the alarm should go
 * off, using the appropriate clock (depending on the alarm type).
 * @param operation Action to perform when the alarm goes off;
 * typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see #set(int, long, PendingIntent)
 * @see #setExactAndAllowWhileIdle
 * @see #cancel
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @see #ELAPSED_REALTIME
 * @see #ELAPSED_REALTIME_WAKEUP
 * @see #RTC
 * @see #RTC_WAKEUP
 * @apiSince 23
 */

public void setAndAllowWhileIdle(int type, long triggerAtMillis, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #setExact(int,long,android.app.PendingIntent)}, but this alarm will be allowed to execute
 * even when the system is in low-power idle modes.  If you don't need exact scheduling of
 * the alarm but still need to execute while idle, consider using
 * {@link #setAndAllowWhileIdle}.  This type of alarm must <b>only</b>
 * be used for situations where it is actually required that the alarm go off while in
 * idle -- a reasonable example would be for a calendar notification that should make a
 * sound so the user is aware of it.  When the alarm is dispatched, the app will also be
 * added to the system's temporary whitelist for approximately 10 seconds to allow that
 * application to acquire further wake locks in which to complete its work.</p>
 *
 * <p>These alarms can significantly impact the power use
 * of the device when idle (and thus cause significant battery blame to the app scheduling
 * them), so they should be used with care.  To reduce abuse, there are restrictions on how
 * frequently these alarms will go off for a particular application.
 * Under normal system operation, it will not dispatch these
 * alarms more than about every minute (at which point every such pending alarm is
 * dispatched); when in low-power idle modes this duration may be significantly longer,
 * such as 15 minutes.</p>
 *
 * <p>Unlike other alarms, the system is free to reschedule this type of alarm to happen
 * out of order with any other alarms, even those from the same app.  This will clearly happen
 * when the device is idle (since this alarm can go off while idle, when any other alarms
 * from the app will be held until later), but may also happen even when not idle.
 * Note that the OS will allow itself more flexibility for scheduling these alarms than
 * regular exact alarms, since the application has opted into this behavior.  When the
 * device is idle it may take even more liberties with scheduling in order to optimize
 * for battery life.</p>
 *
 * @param type type of alarm.
 * Value is {@link android.app.AlarmManager#RTC_WAKEUP}, {@link android.app.AlarmManager#RTC}, {@link android.app.AlarmManager#ELAPSED_REALTIME_WAKEUP}, or {@link android.app.AlarmManager#ELAPSED_REALTIME}
 * @param triggerAtMillis time in milliseconds that the alarm should go
 *        off, using the appropriate clock (depending on the alarm type).
 * @param operation Action to perform when the alarm goes off;
 *        typically comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}.
 *
 * @see #set
 * @see #setRepeating
 * @see #setWindow
 * @see #cancel
 * @see android.content.Context#sendBroadcast
 * @see android.content.Context#registerReceiver
 * @see android.content.Intent#filterEquals
 * @see #ELAPSED_REALTIME
 * @see #ELAPSED_REALTIME_WAKEUP
 * @see #RTC
 * @see #RTC_WAKEUP
 * @apiSince 23
 */

public void setExactAndAllowWhileIdle(int type, long triggerAtMillis, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Remove any alarms with a matching {@link android.content.Intent Intent}.
 * Any alarm, of any type, whose Intent matches this one (as defined by
 * {@link android.content.Intent#filterEquals Intent#filterEquals}), will be canceled.
 *
 * @param operation IntentSender which matches a previously added
 * IntentSender. This parameter must not be {@code null}.
 *
 * @see #set
 * @apiSince 1
 */

public void cancel(android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Remove any alarm scheduled to be delivered to the given {@link android.app.AlarmManager.OnAlarmListener OnAlarmListener}.
 *
 * @param listener OnAlarmListener instance that is the target of a currently-set alarm.
 * @apiSince 24
 */

public void cancel(android.app.AlarmManager.OnAlarmListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set the system wall clock time.
 * Requires the permission android.permission.SET_TIME.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_TIME}
 * @param millis time in milliseconds since the Epoch
 * @apiSince 8
 */

public void setTime(long millis) { throw new RuntimeException("Stub!"); }

/**
 * Sets the system's persistent default time zone. This is the time zone for all apps, even
 * after a reboot. Use {@link java.util.TimeZone#setDefault} if you just want to change the
 * time zone within your app, and even then prefer to pass an explicit
 * {@link java.util.TimeZone} to APIs that require it rather than changing the time zone for
 * all threads.
 *
 * <p> On android M and above, it is an error to pass in a non-Olson timezone to this
 * function. Note that this is a bad idea on all Android releases because POSIX and
 * the {@code TimeZone} class have opposite interpretations of {@code '+'} and {@code '-'}
 * in the same non-Olson ID.
 *
 * <br>
 * Requires {@link android.Manifest.permission#SET_TIME_ZONE}
 * @param timeZone one of the Olson ids from the list returned by
 *     {@link java.util.TimeZone#getAvailableIDs}
 * @apiSince 1
 */

public void setTimeZone(java.lang.String timeZone) { throw new RuntimeException("Stub!"); }

/**
 * Gets information about the next alarm clock currently scheduled.
 *
 * The alarm clocks considered are those scheduled by any application
 * using the {@link #setAlarmClock} method.
 *
 * @return An {@link android.app.AlarmManager.AlarmClockInfo AlarmClockInfo} object describing the next upcoming alarm
 *   clock event that will occur.  If there are no alarm clock events currently
 *   scheduled, this method will return {@code null}.
 *
 * @see #setAlarmClock
 * @see android.app.AlarmManager.AlarmClockInfo
 * @see #ACTION_NEXT_ALARM_CLOCK_CHANGED
 * @apiSince 21
 */

public android.app.AlarmManager.AlarmClockInfo getNextAlarmClock() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: Sent after the value returned by
 * {@link #getNextAlarmClock()} has changed.
 *
 * <p class="note">This is a protected intent that can only be sent by the system.
 * It is only sent to registered receivers.</p>
 * @apiSince 21
 */

public static final java.lang.String ACTION_NEXT_ALARM_CLOCK_CHANGED = "android.app.action.NEXT_ALARM_CLOCK_CHANGED";

/**
 * Alarm time in {@link android.os.SystemClock#elapsedRealtime
 * SystemClock.elapsedRealtime()} (time since boot, including sleep).
 * This alarm does not wake the device up; if it goes off while the device
 * is asleep, it will not be delivered until the next time the device
 * wakes up.
 * @apiSince 1
 */

public static final int ELAPSED_REALTIME = 3; // 0x3

/**
 * Alarm time in {@link android.os.SystemClock#elapsedRealtime
 * SystemClock.elapsedRealtime()} (time since boot, including sleep),
 * which will wake up the device when it goes off.
 * @apiSince 1
 */

public static final int ELAPSED_REALTIME_WAKEUP = 2; // 0x2

/**
 * Available inexact recurrence interval recognized by
 * {@link #setInexactRepeating(int,long,long,android.app.PendingIntent)}
 * when running on Android prior to API 19.
 * @apiSince 3
 */

public static final long INTERVAL_DAY = 86400000L; // 0x5265c00L

/**
 * Available inexact recurrence interval recognized by
 * {@link #setInexactRepeating(int,long,long,android.app.PendingIntent)}
 * when running on Android prior to API 19.
 * @apiSince 3
 */

public static final long INTERVAL_FIFTEEN_MINUTES = 900000L; // 0xdbba0L

/**
 * Available inexact recurrence interval recognized by
 * {@link #setInexactRepeating(int,long,long,android.app.PendingIntent)}
 * when running on Android prior to API 19.
 * @apiSince 3
 */

public static final long INTERVAL_HALF_DAY = 43200000L; // 0x2932e00L

/**
 * Available inexact recurrence interval recognized by
 * {@link #setInexactRepeating(int,long,long,android.app.PendingIntent)}
 * when running on Android prior to API 19.
 * @apiSince 3
 */

public static final long INTERVAL_HALF_HOUR = 1800000L; // 0x1b7740L

/**
 * Available inexact recurrence interval recognized by
 * {@link #setInexactRepeating(int,long,long,android.app.PendingIntent)}
 * when running on Android prior to API 19.
 * @apiSince 3
 */

public static final long INTERVAL_HOUR = 3600000L; // 0x36ee80L

/**
 * Alarm time in {@link java.lang.System#currentTimeMillis System#currentTimeMillis}
 * (wall clock time in UTC).  This alarm does not wake the
 * device up; if it goes off while the device is asleep, it will not be
 * delivered until the next time the device wakes up.
 * @apiSince 1
 */

public static final int RTC = 1; // 0x1

/**
 * Alarm time in {@link java.lang.System#currentTimeMillis System#currentTimeMillis}
 * (wall clock time in UTC), which will wake up the device when
 * it goes off.
 * @apiSince 1
 */

public static final int RTC_WAKEUP = 0; // 0x0
/**
 * An immutable description of a scheduled "alarm clock" event.
 *
 * @see android.app.AlarmManager#setAlarmClock
 * @see AlarmManager#getNextAlarmClock
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AlarmClockInfo implements android.os.Parcelable {

/**
 * Creates a new alarm clock description.
 *
 * @param triggerTime time at which the underlying alarm is triggered in wall time
 *                    milliseconds since the epoch
 * @param showIntent an intent that can be used to show or edit details of
 *                        the alarm clock.
 * @apiSince 21
 */

public AlarmClockInfo(long triggerTime, android.app.PendingIntent showIntent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the time at which the alarm is going to trigger.
 *
 * This value is UTC wall clock time in milliseconds, as returned by
 * {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()} for example.
 * @apiSince 21
 */

public long getTriggerTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns an intent that can be used to show or edit details of the alarm clock in
 * the application that scheduled it.
 *
 * <p class="note">Beware that any application can retrieve and send this intent,
 * potentially with additional fields filled in. See
 * {@link android.app.PendingIntent#send(android.content.Context,int,android.content.Intent) PendingIntent#send(android.content.Context, int, android.content.Intent)} and {@link android.content.Intent#fillIn Intent.fillIn()}
 * for details.
 * @apiSince 21
 */

public android.app.PendingIntent getShowIntent() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.AlarmManager.AlarmClockInfo> CREATOR;
static { CREATOR = null; }
}

/**
 * Direct-notification alarms: the requester must be running continuously from the
 * time the alarm is set to the time it is delivered, or delivery will fail.  Only
 * one-shot alarms can be set using this mechanism, not repeating alarms.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnAlarmListener {

/**
 * Callback method that is invoked by the system when the alarm time is reached.
 * @apiSince 24
 */

public void onAlarm();
}

}

