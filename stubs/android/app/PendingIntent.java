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


package android.app;

import android.content.Intent;
import android.content.Context;
import android.content.IntentSender;
import android.os.Handler;
import android.os.UserHandle;
import android.os.Parcel;
import android.os.Bundle;

/**
 * A description of an Intent and target action to perform with it.  Instances
 * of this class are created with {@link #getActivity}, {@link #getActivities},
 * {@link #getBroadcast}, and {@link #getService}; the returned object can be
 * handed to other applications so that they can perform the action you
 * described on your behalf at a later time.
 *
 * <p>By giving a PendingIntent to another application,
 * you are granting it the right to perform the operation you have specified
 * as if the other application was yourself (with the same permissions and
 * identity).  As such, you should be careful about how you build the PendingIntent:
 * almost always, for example, the base Intent you supply should have the component
 * name explicitly set to one of your own components, to ensure it is ultimately
 * sent there and nowhere else.
 *
 * <p>A PendingIntent itself is simply a reference to a token maintained by
 * the system describing the original data used to retrieve it.  This means
 * that, even if its owning application's process is killed, the
 * PendingIntent itself will remain usable from other processes that
 * have been given it.  If the creating application later re-retrieves the
 * same kind of PendingIntent (same operation, same Intent action, data,
 * categories, and components, and same flags), it will receive a PendingIntent
 * representing the same token if that is still valid, and can thus call
 * {@link #cancel} to remove it.
 *
 * <p>Because of this behavior, it is important to know when two Intents
 * are considered to be the same for purposes of retrieving a PendingIntent.
 * A common mistake people make is to create multiple PendingIntent objects
 * with Intents that only vary in their "extra" contents, expecting to get
 * a different PendingIntent each time.  This does <em>not</em> happen.  The
 * parts of the Intent that are used for matching are the same ones defined
 * by {@link android.content.Intent#filterEquals(android.content.Intent) Intent#filterEquals(Intent)}.  If you use two
 * Intent objects that are equivalent as per
 * {@link android.content.Intent#filterEquals(android.content.Intent) Intent#filterEquals(Intent)}, then you will get
 * the same PendingIntent for both of them.
 *
 * <p>There are two typical ways to deal with this.
 *
 * <p>If you truly need multiple distinct PendingIntent objects active at
 * the same time (such as to use as two notifications that are both shown
 * at the same time), then you will need to ensure there is something that
 * is different about them to associate them with different PendingIntents.
 * This may be any of the Intent attributes considered by
 * {@link android.content.Intent#filterEquals(android.content.Intent) Intent#filterEquals(Intent)}, or different
 * request code integers supplied to {@link #getActivity}, {@link #getActivities},
 * {@link #getBroadcast}, or {@link #getService}.
 *
 * <p>If you only need one PendingIntent active at a time for any of the
 * Intents you will use, then you can alternatively use the flags
 * {@link #FLAG_CANCEL_CURRENT} or {@link #FLAG_UPDATE_CURRENT} to either
 * cancel or modify whatever current PendingIntent is associated with the
 * Intent you are supplying.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PendingIntent implements android.os.Parcelable {

PendingIntent() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a PendingIntent that will start a new activity, like calling
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)}.
 * Note that the activity will be started outside of the context of an
 * existing activity, so you must use the {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} launch flag in the Intent.
 *
 * <p class="note">For security reasons, the {@link android.content.Intent}
 * you supply here should almost always be an <em>explicit intent</em>,
 * that is specify an explicit component to be delivered to through
 * {@link android.content.Intent#setClass(android.content.Context,java.lang.Class) Intent#setClass(android.content.Context, Class)}</p>
 *
 * @param context The Context in which this PendingIntent should start
 * the activity.
 * @param requestCode Private request code for the sender
 * @param intent Intent of the activity to be launched.
 * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
 * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
 * or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
 * supplied.
 * @apiSince 1
 */

public static android.app.PendingIntent getActivity(android.content.Context context, int requestCode, android.content.Intent intent, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a PendingIntent that will start a new activity, like calling
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)}.
 * Note that the activity will be started outside of the context of an
 * existing activity, so you must use the {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} launch flag in the Intent.
 *
 * <p class="note">For security reasons, the {@link android.content.Intent}
 * you supply here should almost always be an <em>explicit intent</em>,
 * that is specify an explicit component to be delivered to through
 * {@link android.content.Intent#setClass(android.content.Context,java.lang.Class) Intent#setClass(android.content.Context, Class)}</p>
 *
 * @param context The Context in which this PendingIntent should start
 * the activity.
 * @param requestCode Private request code for the sender
 * @param intent Intent of the activity to be launched.
 * This value must never be {@code null}.
 * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
 * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
 * or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @param options Additional options for how the Activity should be started.
 * May be null if there are no options.
 *
 * This value may be {@code null}.
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
 * supplied.
 * @apiSince 16
 */

public static android.app.PendingIntent getActivity(android.content.Context context, int requestCode, @androidx.annotation.NonNull android.content.Intent intent, int flags, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #getActivity(android.content.Context,int,android.content.Intent,int)}, but allows an
 * array of Intents to be supplied.  The last Intent in the array is
 * taken as the primary key for the PendingIntent, like the single Intent
 * given to {@link #getActivity(android.content.Context,int,android.content.Intent,int)}.  Upon sending
 * the resulting PendingIntent, all of the Intents are started in the same
 * way as they would be by passing them to {@link android.content.Context#startActivities(android.content.Intent[]) Context#startActivities(Intent[])}.
 *
 * <p class="note">
 * The <em>first</em> intent in the array will be started outside of the context of an
 * existing activity, so you must use the {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} launch flag in the Intent.  (Activities after
 * the first in the array are started in the context of the previous activity
 * in the array, so FLAG_ACTIVITY_NEW_TASK is not needed nor desired for them.)
 * </p>
 *
 * <p class="note">
 * The <em>last</em> intent in the array represents the key for the
 * PendingIntent.  In other words, it is the significant element for matching
 * (as done with the single intent given to {@link #getActivity(android.content.Context,int,android.content.Intent,int)},
 * its content will be the subject of replacement by
 * {@link #send(android.content.Context,int,android.content.Intent)} and {@link #FLAG_UPDATE_CURRENT}, etc.
 * This is because it is the most specific of the supplied intents, and the
 * UI the user actually sees when the intents are started.
 * </p>
 *
 * <p class="note">For security reasons, the {@link android.content.Intent} objects
 * you supply here should almost always be <em>explicit intents</em>,
 * that is specify an explicit component to be delivered to through
 * {@link android.content.Intent#setClass(android.content.Context,java.lang.Class) Intent#setClass(android.content.Context, Class)}</p>
 *
 * @param context The Context in which this PendingIntent should start
 * the activity.
 * @param requestCode Private request code for the sender
 * @param intents Array of Intents of the activities to be launched.
 * This value must never be {@code null}.
 * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
 * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
 * or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
 * supplied.
 * @apiSince 11
 */

public static android.app.PendingIntent getActivities(android.content.Context context, int requestCode, @androidx.annotation.NonNull android.content.Intent[] intents, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #getActivity(android.content.Context,int,android.content.Intent,int)}, but allows an
 * array of Intents to be supplied.  The last Intent in the array is
 * taken as the primary key for the PendingIntent, like the single Intent
 * given to {@link #getActivity(android.content.Context,int,android.content.Intent,int)}.  Upon sending
 * the resulting PendingIntent, all of the Intents are started in the same
 * way as they would be by passing them to {@link android.content.Context#startActivities(android.content.Intent[]) Context#startActivities(Intent[])}.
 *
 * <p class="note">
 * The <em>first</em> intent in the array will be started outside of the context of an
 * existing activity, so you must use the {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} launch flag in the Intent.  (Activities after
 * the first in the array are started in the context of the previous activity
 * in the array, so FLAG_ACTIVITY_NEW_TASK is not needed nor desired for them.)
 * </p>
 *
 * <p class="note">
 * The <em>last</em> intent in the array represents the key for the
 * PendingIntent.  In other words, it is the significant element for matching
 * (as done with the single intent given to {@link #getActivity(android.content.Context,int,android.content.Intent,int)},
 * its content will be the subject of replacement by
 * {@link #send(android.content.Context,int,android.content.Intent)} and {@link #FLAG_UPDATE_CURRENT}, etc.
 * This is because it is the most specific of the supplied intents, and the
 * UI the user actually sees when the intents are started.
 * </p>
 *
 * <p class="note">For security reasons, the {@link android.content.Intent} objects
 * you supply here should almost always be <em>explicit intents</em>,
 * that is specify an explicit component to be delivered to through
 * {@link android.content.Intent#setClass(android.content.Context,java.lang.Class) Intent#setClass(android.content.Context, Class)}</p>
 *
 * @param context The Context in which this PendingIntent should start
 * the activity.
 * @param requestCode Private request code for the sender
 * @param intents Array of Intents of the activities to be launched.
 * This value must never be {@code null}.
 * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
 * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
 * {@link #FLAG_IMMUTABLE} or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @param options This value may be {@code null}.
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
 * supplied.
 * @apiSince 16
 */

public static android.app.PendingIntent getActivities(android.content.Context context, int requestCode, @androidx.annotation.NonNull android.content.Intent[] intents, int flags, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a PendingIntent that will perform a broadcast, like calling
 * {@link android.content.Context#sendBroadcast(android.content.Intent) Context#sendBroadcast(Intent)}.
 *
 * <p class="note">For security reasons, the {@link android.content.Intent}
 * you supply here should almost always be an <em>explicit intent</em>,
 * that is specify an explicit component to be delivered to through
 * {@link android.content.Intent#setClass(android.content.Context,java.lang.Class) Intent#setClass(android.content.Context, Class)}</p>
 *
 * @param context The Context in which this PendingIntent should perform
 * the broadcast.
 * @param requestCode Private request code for the sender
 * @param intent The Intent to be broadcast.
 * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
 * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
 * {@link #FLAG_IMMUTABLE} or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
 * supplied.
 * @apiSince 1
 */

public static android.app.PendingIntent getBroadcast(android.content.Context context, int requestCode, android.content.Intent intent, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a PendingIntent that will start a service, like calling
 * {@link android.content.Context#startService Context#startService}.  The start
 * arguments given to the service will come from the extras of the Intent.
 *
 * <p class="note">For security reasons, the {@link android.content.Intent}
 * you supply here should almost always be an <em>explicit intent</em>,
 * that is specify an explicit component to be delivered to through
 * {@link android.content.Intent#setClass(android.content.Context,java.lang.Class) Intent#setClass(android.content.Context, Class)}</p>
 *
 * @param context The Context in which this PendingIntent should start
 * the service.
 * @param requestCode Private request code for the sender
 * @param intent An Intent describing the service to be started.
 * This value must never be {@code null}.
 * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
 * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
 * {@link #FLAG_IMMUTABLE} or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
 * supplied.
 * @apiSince 1
 */

public static android.app.PendingIntent getService(android.content.Context context, int requestCode, @androidx.annotation.NonNull android.content.Intent intent, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a PendingIntent that will start a foreground service, like calling
 * {@link android.content.Context#startForegroundService Context#startForegroundService}.  The start
 * arguments given to the service will come from the extras of the Intent.
 *
 * <p class="note">For security reasons, the {@link android.content.Intent}
 * you supply here should almost always be an <em>explicit intent</em>,
 * that is specify an explicit component to be delivered to through
 * {@link android.content.Intent#setClass(android.content.Context,java.lang.Class) Intent#setClass(android.content.Context, Class)}</p>
 *
 * @param context The Context in which this PendingIntent should start
 * the service.
 * @param requestCode Private request code for the sender
 * @param intent An Intent describing the service to be started.
 * This value must never be {@code null}.
 * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
 * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
 * {@link #FLAG_IMMUTABLE} or any of the flags as supported by
 * {@link android.content.Intent#fillIn Intent#fillIn} to control which unspecified parts
 * of the intent that can be supplied when the actual send happens.
 *
 * Value is either <code>0</code> or a combination of {@link android.app.PendingIntent#FLAG_ONE_SHOT}, {@link android.app.PendingIntent#FLAG_NO_CREATE}, {@link android.app.PendingIntent#FLAG_CANCEL_CURRENT}, {@link android.app.PendingIntent#FLAG_UPDATE_CURRENT}, {@link android.app.PendingIntent#FLAG_IMMUTABLE}, {@link android.content.Intent#FILL_IN_ACTION}, {@link android.content.Intent#FILL_IN_DATA}, {@link android.content.Intent#FILL_IN_CATEGORIES}, {@link android.content.Intent#FILL_IN_COMPONENT}, {@link android.content.Intent#FILL_IN_PACKAGE}, {@link android.content.Intent#FILL_IN_SOURCE_BOUNDS}, {@link android.content.Intent#FILL_IN_SELECTOR}, and {@link android.content.Intent#FILL_IN_CLIP_DATA}
 * @return Returns an existing or new PendingIntent matching the given
 * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
 * supplied.
 * @apiSince 26
 */

public static android.app.PendingIntent getForegroundService(android.content.Context context, int requestCode, @androidx.annotation.NonNull android.content.Intent intent, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a IntentSender object that wraps the existing sender of the PendingIntent
 *
 * @return Returns a IntentSender object that wraps the sender of PendingIntent
 *
 * @apiSince 4
 */

public android.content.IntentSender getIntentSender() { throw new RuntimeException("Stub!"); }

/**
 * Cancel a currently active PendingIntent.  Only the original application
 * owning a PendingIntent can cancel it.
 * @apiSince 1
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this PendingIntent.
 *
 * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
 *
 * @throws android.app.PendingIntent.CanceledException Throws CanceledException if the PendingIntent
 * is no longer allowing more intents to be sent through it.
 * @apiSince 1
 */

public void send() throws android.app.PendingIntent.CanceledException { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this PendingIntent.
 *
 * @param code Result code to supply back to the PendingIntent's target.
 *
 * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
 *
 * @throws android.app.PendingIntent.CanceledException Throws CanceledException if the PendingIntent
 * is no longer allowing more intents to be sent through it.
 * @apiSince 1
 */

public void send(int code) throws android.app.PendingIntent.CanceledException { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this PendingIntent, allowing the
 * caller to specify information about the Intent to use.
 *
 * @param context The Context of the caller.
 * @param code Result code to supply back to the PendingIntent's target.
 * @param intent Additional Intent data.  See {@link android.content.Intent#fillIn Intent#fillIn} for information on how this is applied to the
 * original Intent. If flag {@link #FLAG_IMMUTABLE} was set when this
 * pending intent was created, this argument will be ignored.
 *
 * This value may be {@code null}.
 * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
 *
 * @throws android.app.PendingIntent.CanceledException Throws CanceledException if the PendingIntent
 * is no longer allowing more intents to be sent through it.
 * @apiSince 1
 */

public void send(android.content.Context context, int code, @androidx.annotation.Nullable android.content.Intent intent) throws android.app.PendingIntent.CanceledException { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this PendingIntent, allowing the
 * caller to be notified when the send has completed.
 *
 * @param code Result code to supply back to the PendingIntent's target.
 * @param onFinished The object to call back on when the send has
 * completed, or null for no callback.
 * This value may be {@code null}.
 * @param handler Handler identifying the thread on which the callback
 * should happen.  If null, the callback will happen from the thread
 * pool of the process.
 *
 * This value may be {@code null}.
 * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
 *
 * @throws android.app.PendingIntent.CanceledException Throws CanceledException if the PendingIntent
 * is no longer allowing more intents to be sent through it.
 * @apiSince 1
 */

public void send(int code, @androidx.annotation.Nullable android.app.PendingIntent.OnFinished onFinished, @androidx.annotation.Nullable android.os.Handler handler) throws android.app.PendingIntent.CanceledException { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this PendingIntent, allowing the
 * caller to specify information about the Intent to use and be notified
 * when the send has completed.
 *
 * <p>For the intent parameter, a PendingIntent
 * often has restrictions on which fields can be supplied here, based on
 * how the PendingIntent was retrieved in {@link #getActivity},
 * {@link #getBroadcast}, or {@link #getService}.
 *
 * @param context The Context of the caller.  This may be null if
 * <var>intent</var> is also null.
 * @param code Result code to supply back to the PendingIntent's target.
 * @param intent Additional Intent data.  See {@link android.content.Intent#fillIn Intent#fillIn} for information on how this is applied to the
 * original Intent.  Use null to not modify the original Intent.
 * If flag {@link #FLAG_IMMUTABLE} was set when this pending intent was
 * created, this argument will be ignored.
 * This value may be {@code null}.
 * @param onFinished The object to call back on when the send has
 * completed, or null for no callback.
 * This value may be {@code null}.
 * @param handler Handler identifying the thread on which the callback
 * should happen.  If null, the callback will happen from the thread
 * pool of the process.
 *
 * This value may be {@code null}.
 * @see #send()
 * @see #send(int)
 * @see #send(Context, int, Intent)
 * @see #send(int, android.app.PendingIntent.OnFinished, Handler)
 * @see #send(Context, int, Intent, OnFinished, Handler, String)
 *
 * @throws android.app.PendingIntent.CanceledException Throws CanceledException if the PendingIntent
 * is no longer allowing more intents to be sent through it.
 * @apiSince 1
 */

public void send(android.content.Context context, int code, @androidx.annotation.Nullable android.content.Intent intent, @androidx.annotation.Nullable android.app.PendingIntent.OnFinished onFinished, @androidx.annotation.Nullable android.os.Handler handler) throws android.app.PendingIntent.CanceledException { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this PendingIntent, allowing the
 * caller to specify information about the Intent to use and be notified
 * when the send has completed.
 *
 * <p>For the intent parameter, a PendingIntent
 * often has restrictions on which fields can be supplied here, based on
 * how the PendingIntent was retrieved in {@link #getActivity},
 * {@link #getBroadcast}, or {@link #getService}.
 *
 * @param context The Context of the caller.  This may be null if
 * <var>intent</var> is also null.
 * @param code Result code to supply back to the PendingIntent's target.
 * @param intent Additional Intent data.  See {@link android.content.Intent#fillIn Intent#fillIn} for information on how this is applied to the
 * original Intent.  Use null to not modify the original Intent.
 * If flag {@link #FLAG_IMMUTABLE} was set when this pending intent was
 * created, this argument will be ignored.
 * This value may be {@code null}.
 * @param onFinished The object to call back on when the send has
 * completed, or null for no callback.
 * This value may be {@code null}.
 * @param handler Handler identifying the thread on which the callback
 * should happen.  If null, the callback will happen from the thread
 * pool of the process.
 * This value may be {@code null}.
 * @param requiredPermission Name of permission that a recipient of the PendingIntent
 * is required to hold.  This is only valid for broadcast intents, and
 * corresponds to the permission argument in
 * {@link android.content.Context#sendBroadcast(android.content.Intent,java.lang.String) Context#sendBroadcast(Intent, String)}.
 * If null, no permission is required.
 *
 * This value may be {@code null}.
 * @see #send()
 * @see #send(int)
 * @see #send(Context, int, Intent)
 * @see #send(int, android.app.PendingIntent.OnFinished, Handler)
 * @see #send(Context, int, Intent, OnFinished, Handler)
 *
 * @throws android.app.PendingIntent.CanceledException Throws CanceledException if the PendingIntent
 * is no longer allowing more intents to be sent through it.
 * @apiSince 14
 */

public void send(android.content.Context context, int code, @androidx.annotation.Nullable android.content.Intent intent, @androidx.annotation.Nullable android.app.PendingIntent.OnFinished onFinished, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable java.lang.String requiredPermission) throws android.app.PendingIntent.CanceledException { throw new RuntimeException("Stub!"); }

/**
 * Perform the operation associated with this PendingIntent, allowing the
 * caller to specify information about the Intent to use and be notified
 * when the send has completed.
 *
 * <p>For the intent parameter, a PendingIntent
 * often has restrictions on which fields can be supplied here, based on
 * how the PendingIntent was retrieved in {@link #getActivity},
 * {@link #getBroadcast}, or {@link #getService}.
 *
 * @param context The Context of the caller.  This may be null if
 * <var>intent</var> is also null.
 * @param code Result code to supply back to the PendingIntent's target.
 * @param intent Additional Intent data.  See {@link android.content.Intent#fillIn Intent#fillIn} for information on how this is applied to the
 * original Intent.  Use null to not modify the original Intent.
 * If flag {@link #FLAG_IMMUTABLE} was set when this pending intent was
 * created, this argument will be ignored.
 * This value may be {@code null}.
 * @param onFinished The object to call back on when the send has
 * completed, or null for no callback.
 * This value may be {@code null}.
 * @param handler Handler identifying the thread on which the callback
 * should happen.  If null, the callback will happen from the thread
 * pool of the process.
 * This value may be {@code null}.
 * @param requiredPermission Name of permission that a recipient of the PendingIntent
 * is required to hold.  This is only valid for broadcast intents, and
 * corresponds to the permission argument in
 * {@link android.content.Context#sendBroadcast(android.content.Intent,java.lang.String) Context#sendBroadcast(Intent, String)}.
 * If null, no permission is required.
 * This value may be {@code null}.
 * @param options Additional options the caller would like to provide to modify the sending
 * behavior.  May be built from an {@link android.app.ActivityOptions ActivityOptions} to apply to an activity start.
 *
 * This value may be {@code null}.
 * @see #send()
 * @see #send(int)
 * @see #send(Context, int, Intent)
 * @see #send(int, android.app.PendingIntent.OnFinished, Handler)
 * @see #send(Context, int, Intent, OnFinished, Handler)
 *
 * @throws android.app.PendingIntent.CanceledException Throws CanceledException if the PendingIntent
 * is no longer allowing more intents to be sent through it.
 * @apiSince 23
 */

public void send(android.content.Context context, int code, @androidx.annotation.Nullable android.content.Intent intent, @androidx.annotation.Nullable android.app.PendingIntent.OnFinished onFinished, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable java.lang.String requiredPermission, @androidx.annotation.Nullable android.os.Bundle options) throws android.app.PendingIntent.CanceledException { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Renamed to {@link #getCreatorPackage()}.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public java.lang.String getTargetPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name of the application that created this
 * PendingIntent, that is the identity under which you will actually be
 * sending the Intent.  The returned string is supplied by the system, so
 * that an application can not spoof its package.
 *
 * <p class="note">Be careful about how you use this.  All this tells you is
 * who created the PendingIntent.  It does <strong>not</strong> tell you who
 * handed the PendingIntent to you: that is, PendingIntent objects are intended to be
 * passed between applications, so the PendingIntent you receive from an application
 * could actually be one it received from another application, meaning the result
 * you get here will identify the original application.  Because of this, you should
 * only use this information to identify who you expect to be interacting with
 * through a {@link #send} call, not who gave you the PendingIntent.</p>
 *
 * @return The package name of the PendingIntent, or null if there is
 * none associated with it.
 * @apiSince 17
 */

@androidx.annotation.Nullable
public java.lang.String getCreatorPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return the uid of the application that created this
 * PendingIntent, that is the identity under which you will actually be
 * sending the Intent.  The returned integer is supplied by the system, so
 * that an application can not spoof its uid.
 *
 * <p class="note">Be careful about how you use this.  All this tells you is
 * who created the PendingIntent.  It does <strong>not</strong> tell you who
 * handed the PendingIntent to you: that is, PendingIntent objects are intended to be
 * passed between applications, so the PendingIntent you receive from an application
 * could actually be one it received from another application, meaning the result
 * you get here will identify the original application.  Because of this, you should
 * only use this information to identify who you expect to be interacting with
 * through a {@link #send} call, not who gave you the PendingIntent.</p>
 *
 * @return The uid of the PendingIntent, or -1 if there is
 * none associated with it.
 * @apiSince 17
 */

public int getCreatorUid() { throw new RuntimeException("Stub!"); }

/**
 * Return the user handle of the application that created this
 * PendingIntent, that is the user under which you will actually be
 * sending the Intent.  The returned UserHandle is supplied by the system, so
 * that an application can not spoof its user.  See
 * {@link android.os.Process#myUserHandle() Process.myUserHandle()} for
 * more explanation of user handles.
 *
 * <p class="note">Be careful about how you use this.  All this tells you is
 * who created the PendingIntent.  It does <strong>not</strong> tell you who
 * handed the PendingIntent to you: that is, PendingIntent objects are intended to be
 * passed between applications, so the PendingIntent you receive from an application
 * could actually be one it received from another application, meaning the result
 * you get here will identify the original application.  Because of this, you should
 * only use this information to identify who you expect to be interacting with
 * through a {@link #send} call, not who gave you the PendingIntent.</p>
 *
 * @return The user handle of the PendingIntent, or null if there is
 * none associated with it.
 * @apiSince 17
 */

@androidx.annotation.Nullable
public android.os.UserHandle getCreatorUserHandle() { throw new RuntimeException("Stub!"); }

/**
 * Comparison operator on two PendingIntent objects, such that true
 * is returned then they both represent the same operation from the
 * same package.  This allows you to use {@link #getActivity},
 * {@link #getBroadcast}, or {@link #getService} multiple times (even
 * across a process being killed), resulting in different PendingIntent
 * objects but whose equals() method identifies them as being the same
 * operation.
 * @apiSince 1
 */

public boolean equals(java.lang.Object otherObj) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for writing either a PendingIntent or null pointer to
 * a Parcel.  You must use this with {@link #readPendingIntentOrNullFromParcel}
 * for later reading it.
 *
 * @param sender The PendingIntent to write, or null.
 * This value may be {@code null}.
 * @param out Where to write the PendingIntent.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static void writePendingIntentOrNullToParcel(@androidx.annotation.Nullable android.app.PendingIntent sender, @androidx.annotation.NonNull android.os.Parcel out) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for reading either a PendingIntent or null pointer from
 * a Parcel.  You must have previously written the PendingIntent with
 * {@link #writePendingIntentOrNullToParcel}.
 *
 * @param in The Parcel containing the written PendingIntent.
 *
 * This value must never be {@code null}.
 * @return Returns the PendingIntent read from the Parcel, or null if null had
 * been written.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public static android.app.PendingIntent readPendingIntentOrNullFromParcel(@androidx.annotation.NonNull android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.PendingIntent> CREATOR;
static { CREATOR = null; }

/**
 * Flag indicating that if the described PendingIntent already exists,
 * the current one should be canceled before generating a new one.
 * For use with {@link #getActivity}, {@link #getBroadcast}, and
 * {@link #getService}. <p>You can use
 * this to retrieve a new PendingIntent when you are only changing the
 * extra data in the Intent; by canceling the previous pending intent,
 * this ensures that only entities given the new data will be able to
 * launch it.  If this assurance is not an issue, consider
 * {@link #FLAG_UPDATE_CURRENT}.
 * @apiSince 1
 */

public static final int FLAG_CANCEL_CURRENT = 268435456; // 0x10000000

/**
 * Flag indicating that the created PendingIntent should be immutable.
 * This means that the additional intent argument passed to the send
 * methods to fill in unpopulated properties of this intent will be
 * ignored.
 * @apiSince 23
 */

public static final int FLAG_IMMUTABLE = 67108864; // 0x4000000

/**
 * Flag indicating that if the described PendingIntent does not
 * already exist, then simply return null instead of creating it.
 * For use with {@link #getActivity}, {@link #getBroadcast}, and
 * {@link #getService}.
 * @apiSince 1
 */

public static final int FLAG_NO_CREATE = 536870912; // 0x20000000

/**
 * Flag indicating that this PendingIntent can be used only once.
 * For use with {@link #getActivity}, {@link #getBroadcast}, and
 * {@link #getService}. <p>If set, after
 * {@link #send()} is called on it, it will be automatically
 * canceled for you and any future attempt to send through it will fail.
 * @apiSince 1
 */

public static final int FLAG_ONE_SHOT = 1073741824; // 0x40000000

/**
 * Flag indicating that if the described PendingIntent already exists,
 * then keep it but replace its extra data with what is in this new
 * Intent. For use with {@link #getActivity}, {@link #getBroadcast}, and
 * {@link #getService}. <p>This can be used if you are creating intents where only the
 * extras change, and don't care that any entities that received your
 * previous PendingIntent will be able to launch it with your new
 * extras even if they are not explicitly given to it.
 * @apiSince 3
 */

public static final int FLAG_UPDATE_CURRENT = 134217728; // 0x8000000
/**
 * Exception thrown when trying to send through a PendingIntent that
 * has been canceled or is otherwise no longer able to execute the request.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CanceledException extends android.util.AndroidException {

/** @apiSince 1 */

public CanceledException() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public CanceledException(java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public CanceledException(java.lang.Exception cause) { throw new RuntimeException("Stub!"); }
}

/**
 * Callback interface for discovering when a send operation has
 * completed.  Primarily for use with a PendingIntent that is
 * performing a broadcast, this provides the same information as
 * calling {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle) Context#sendOrderedBroadcast(Intent, String,
 * android.content.BroadcastReceiver, Handler, int, String, Bundle)} with a final BroadcastReceiver.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnFinished {

/**
 * Called when a send operation as completed.
 *
 * @param pendingIntent The PendingIntent this operation was sent through.
 * @param intent The original Intent that was sent.
 * @param resultCode The final result code determined by the send.
 * @param resultData The final data collected by a broadcast.
 * @param resultExtras The final extras collected by a broadcast.
 * @apiSince 1
 */

public void onSendFinished(android.app.PendingIntent pendingIntent, android.content.Intent intent, int resultCode, java.lang.String resultData, android.os.Bundle resultExtras);
}

}

