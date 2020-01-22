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


package android.content;

import android.os.IBinder;
import android.os.Bundle;

/**
 * Base class for code that receives and handles broadcast intents sent by
 * {@link android.content.Context#sendBroadcast(Intent)}.
 *
 * <p>You can either dynamically register an instance of this class with
 * {@link android.content.Context#registerReceiver Context#registerReceiver}
 * or statically declare an implementation with the
 * {@link android.R.styleable#AndroidManifestReceiver &lt;receiver&gt;}
 * tag in your <code>AndroidManifest.xml</code>.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using BroadcastReceiver, read the
 * <a href="{@docRoot}guide/components/broadcasts.html">Broadcasts</a> developer guide.</p></div>
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BroadcastReceiver {

/** @apiSince 1 */

public BroadcastReceiver() { throw new RuntimeException("Stub!"); }

/**
 * This method is called when the BroadcastReceiver is receiving an Intent
 * broadcast.  During this time you can use the other methods on
 * BroadcastReceiver to view/modify the current result values.  This method
 * is always called within the main thread of its process, unless you
 * explicitly asked for it to be scheduled on a different thread using
 * {@link android.content.Context#registerReceiver(BroadcastReceiver,
 * IntentFilter, String, android.os.Handler)}. When it runs on the main
 * thread you should
 * never perform long-running operations in it (there is a timeout of
 * 10 seconds that the system allows before considering the receiver to
 * be blocked and a candidate to be killed). You cannot launch a popup dialog
 * in your implementation of onReceive().
 *
 * <p><b>If this BroadcastReceiver was launched through a &lt;receiver&gt; tag,
 * then the object is no longer alive after returning from this
 * function.</b> This means you should not perform any operations that
 * return a result to you asynchronously. If you need to perform any follow up
 * background work, schedule a {@link android.app.job.JobService} with
 * {@link android.app.job.JobScheduler}.
 *
 * If you wish to interact with a service that is already running and previously
 * bound using {@link android.content.Context#bindService(Intent, ServiceConnection, int) bindService()},
 * you can use {@link #peekService}.
 *
 * <p>The Intent filters used in {@link android.content.Context#registerReceiver}
 * and in application manifests are <em>not</em> guaranteed to be exclusive. They
 * are hints to the operating system about how to find suitable recipients. It is
 * possible for senders to force delivery to specific recipients, bypassing filter
 * resolution.  For this reason, {@link #onReceive(android.content.Context,android.content.Intent) onReceive()}
 * implementations should respond only to known actions, ignoring any unexpected
 * Intents that they may receive.
 *
 * @param context The Context in which the receiver is running.
 * @param intent The Intent being received.
 * @apiSince 1
 */

public abstract void onReceive(android.content.Context context, android.content.Intent intent);

/**
 * This can be called by an application in {@link #onReceive} to allow
 * it to keep the broadcast active after returning from that function.
 * This does <em>not</em> change the expectation of being relatively
 * responsive to the broadcast, but does allow
 * the implementation to move work related to it over to another thread
 * to avoid glitching the main UI thread due to disk IO.
 *
 * <p>As a general rule, broadcast receivers are allowed to run for up to 10 seconds
 * before they system will consider them non-responsive and ANR the app.  Since these usually
 * execute on the app's main thread, they are already bound by the ~5 second time limit
 * of various operations that can happen there (not to mention just avoiding UI jank), so
 * the receive limit is generally not of concern.  However, once you use {@code goAsync}, though
 * able to be off the main thread, the broadcast execution limit still applies, and that
 * includes the time spent between calling this method and ultimately
 * {@link android.content.BroadcastReceiver.PendingResult#finish() PendingResult#finish()}.</p>
 *
 * <p>If you are taking advantage of this method to have more time to execute, it is useful
 * to know that the available time can be longer in certain situations.  In particular, if
 * the broadcast you are receiving is not a foreground broadcast (that is, the sender has not
 * used {@link android.content.Intent#FLAG_RECEIVER_FOREGROUND Intent#FLAG_RECEIVER_FOREGROUND}), then more time is allowed for the receivers
 * to run, allowing them to execute for 30 seconds or even a bit more.  This is something that
 * receivers should rarely take advantage of (long work should be punted to another system
 * facility such as {@link android.app.job.JobScheduler}, {@link android.app.Service}, or
 * see especially {@link android.support.v4.app.JobIntentService}), but can be useful in
 * certain rare cases where it is necessary to do some work as soon as the broadcast is
 * delivered.  Keep in mind that the work you do here will block further broadcasts until
 * it completes, so taking advantage of this at all excessively can be counter-productive
 * and cause later events to be received more slowly.</p>
 *
 * @return Returns a {@link android.content.BroadcastReceiver.PendingResult PendingResult} representing the result of
 * the active broadcast.  The BroadcastRecord itself is no longer active;
 * all data and other interaction must go through {@link android.content.BroadcastReceiver.PendingResult PendingResult}
 * APIs.  The {@link android.content.BroadcastReceiver.PendingResult#finish PendingResult#finish} method
 * must be called once processing of the broadcast is done.
 * @apiSince 11
 */

public final android.content.BroadcastReceiver.PendingResult goAsync() { throw new RuntimeException("Stub!"); }

/**
 * Provide a binder to an already-bound service.  This method is synchronous
 * and will not start the target service if it is not present, so it is safe
 * to call from {@link #onReceive}.
 *
 * For peekService() to return a non null {@link android.os.IBinder} interface
 * the service must have published it before. In other words some component
 * must have called {@link android.content.Context#bindService(Intent, ServiceConnection, int)} on it.
 *
 * @param myContext The Context that had been passed to {@link #onReceive(android.content.Context,android.content.Intent)}
 * @param service Identifies the already-bound service you wish to use. See
 * {@link android.content.Context#bindService(Intent, ServiceConnection, int)}
 * for more information.
 * @apiSince 3
 */

public android.os.IBinder peekService(android.content.Context myContext, android.content.Intent service) { throw new RuntimeException("Stub!"); }

/**
 * Change the current result code of this broadcast; only works with
 * broadcasts sent through
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String) Context#sendOrderedBroadcast(Intent, String)}.  Often uses the
 * Activity {@link android.app.Activity#RESULT_CANCELED} and
 * {@link android.app.Activity#RESULT_OK} constants, though the
 * actual meaning of this value is ultimately up to the broadcaster.
 *
 * <p class="note">This method does not work with non-ordered broadcasts such
 * as those sent with {@link android.content.Context#sendBroadcast(android.content.Intent) Context#sendBroadcast(Intent)}</p>
 *
 * @param code The new result code.
 *
 * @see #setResult(int, String, Bundle)
 * @apiSince 1
 */

public final void setResultCode(int code) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current result code, as set by the previous receiver.
 *
 * @return int The current result code.
 * @apiSince 1
 */

public final int getResultCode() { throw new RuntimeException("Stub!"); }

/**
 * Change the current result data of this broadcast; only works with
 * broadcasts sent through
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String) Context#sendOrderedBroadcast(Intent, String)}.  This is an arbitrary
 * string whose interpretation is up to the broadcaster.
 *
 * <p><strong>This method does not work with non-ordered broadcasts such
 * as those sent with {@link android.content.Context#sendBroadcast(android.content.Intent) Context#sendBroadcast(Intent)}</strong></p>
 *
 * @param data The new result data; may be null.
 *
 * @see #setResult(int, String, Bundle)
 * @apiSince 1
 */

public final void setResultData(java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current result data, as set by the previous receiver.
 * Often this is null.
 *
 * @return String The current result data; may be null.
 * @apiSince 1
 */

public final java.lang.String getResultData() { throw new RuntimeException("Stub!"); }

/**
 * Change the current result extras of this broadcast; only works with
 * broadcasts sent through
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String) Context#sendOrderedBroadcast(Intent, String)}.  This is a Bundle
 * holding arbitrary data, whose interpretation is up to the
 * broadcaster.  Can be set to null.  Calling this method completely
 * replaces the current map (if any).
 *
 * <p><strong>This method does not work with non-ordered broadcasts such
 * as those sent with {@link android.content.Context#sendBroadcast(android.content.Intent) Context#sendBroadcast(Intent)}</strong></p>
 *
 * @param extras The new extra data map; may be null.
 *
 * @see #setResult(int, String, Bundle)
 * @apiSince 1
 */

public final void setResultExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current result extra data, as set by the previous receiver.
 * Any changes you make to the returned Map will be propagated to the next
 * receiver.
 *
 * @param makeMap If true then a new empty Map will be made for you if the
 *                current Map is null; if false you should be prepared to
 *                receive a null Map.
 *
 * @return Map The current extras map.
 * @apiSince 1
 */

public final android.os.Bundle getResultExtras(boolean makeMap) { throw new RuntimeException("Stub!"); }

/**
 * Change all of the result data returned from this broadcasts; only works
 * with broadcasts sent through
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String) Context#sendOrderedBroadcast(Intent, String)}.  All current result data is replaced
 * by the value given to this method.
 *
 * <p><strong>This method does not work with non-ordered broadcasts such
 * as those sent with {@link android.content.Context#sendBroadcast(android.content.Intent) Context#sendBroadcast(Intent)}</strong></p>
 *
 * @param code The new result code.  Often uses the
 * Activity {@link android.app.Activity#RESULT_CANCELED} and
 * {@link android.app.Activity#RESULT_OK} constants, though the
 * actual meaning of this value is ultimately up to the broadcaster.
 * @param data The new result data.  This is an arbitrary
 * string whose interpretation is up to the broadcaster; may be null.
 * @param extras The new extra data map.  This is a Bundle
 * holding arbitrary data, whose interpretation is up to the
 * broadcaster.  Can be set to null.  This completely
 * replaces the current map (if any).
 * @apiSince 1
 */

public final void setResult(int code, java.lang.String data, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Returns the flag indicating whether or not this receiver should
 * abort the current broadcast.
 *
 * @return True if the broadcast should be aborted.
 * @apiSince 1
 */

public final boolean getAbortBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Sets the flag indicating that this receiver should abort the
 * current broadcast; only works with broadcasts sent through
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String) Context#sendOrderedBroadcast(Intent, String)}.  This will prevent
 * any other broadcast receivers from receiving the broadcast. It will still
 * call {@link #onReceive} of the BroadcastReceiver that the caller of
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String) Context#sendOrderedBroadcast(Intent, String)} passed in.
 *
 * <p><strong>This method does not work with non-ordered broadcasts such
 * as those sent with {@link android.content.Context#sendBroadcast(android.content.Intent) Context#sendBroadcast(Intent)}</strong></p>
 * @apiSince 1
 */

public final void abortBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Clears the flag indicating that this receiver should abort the current
 * broadcast.
 * @apiSince 1
 */

public final void clearAbortBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the receiver is currently processing an ordered
 * broadcast.
 * @apiSince 5
 */

public final boolean isOrderedBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the receiver is currently processing the initial
 * value of a sticky broadcast -- that is, the value that was last
 * broadcast and is currently held in the sticky cache, so this is
 * not directly the result of a broadcast right now.
 * @apiSince 5
 */

public final boolean isInitialStickyBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * For internal use, sets the hint about whether this BroadcastReceiver is
 * running in ordered mode.
 * @apiSince 1
 */

public final void setOrderedHint(boolean isOrdered) { throw new RuntimeException("Stub!"); }

/**
 * Control inclusion of debugging help for mismatched
 * calls to {@link android.content.Context#registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter) Context#registerReceiver(BroadcastReceiver, IntentFilter)}.
 * If called with true, before given to registerReceiver(), then the
 * callstack of the following {@link android.content.Context#unregisterReceiver(android.content.BroadcastReceiver) Context#unregisterReceiver(BroadcastReceiver)} call is retained, to be printed if a later
 * incorrect unregister call is made.  Note that doing this requires retaining
 * information about the BroadcastReceiver for the lifetime of the app,
 * resulting in a leak -- this should only be used for debugging.
 * @apiSince 1
 */

public final void setDebugUnregister(boolean debug) { throw new RuntimeException("Stub!"); }

/**
 * Return the last value given to {@link #setDebugUnregister}.
 * @apiSince 1
 */

public final boolean getDebugUnregister() { throw new RuntimeException("Stub!"); }
/**
 * State for a result that is pending for a broadcast receiver.  Returned
 * by {@link android.content.BroadcastReceiver#goAsync() BroadcastReceiver#goAsync()}
 * while in {@link android.content.BroadcastReceiver#onReceive BroadcastReceiver#onReceive}.
 * This allows you to return from onReceive() without having the broadcast
 * terminate; you must call {@link #finish()} once you are done with the
 * broadcast.  This allows you to process the broadcast off of the main
 * thread of your app.
 *
 * <p>Note on threading: the state inside of this class is not itself
 * thread-safe, however you can use it from any thread if you properly
 * sure that you do not have races.  Typically this means you will hand
 * the entire object to another thread, which will be solely responsible
 * for setting any results and finally calling {@link #finish()}.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PendingResult {

PendingResult() { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#setResultCode(int) BroadcastReceiver#setResultCode(int)} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final void setResultCode(int code) { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#getResultCode() BroadcastReceiver#getResultCode()} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final int getResultCode() { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#setResultData(java.lang.String) BroadcastReceiver#setResultData(String)} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final void setResultData(java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#getResultData() BroadcastReceiver#getResultData()} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final java.lang.String getResultData() { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#setResultExtras(android.os.Bundle) BroadcastReceiver#setResultExtras(Bundle)} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final void setResultExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#getResultExtras(boolean) BroadcastReceiver#getResultExtras(boolean)} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final android.os.Bundle getResultExtras(boolean makeMap) { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#setResult(int,java.lang.String,android.os.Bundle) BroadcastReceiver#setResult(int, String, Bundle)} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final void setResult(int code, java.lang.String data, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#getAbortBroadcast() BroadcastReceiver#getAbortBroadcast()} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final boolean getAbortBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#abortBroadcast() BroadcastReceiver#abortBroadcast()} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final void abortBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link android.content.BroadcastReceiver#clearAbortBroadcast() BroadcastReceiver#clearAbortBroadcast()} for
 * asynchronous broadcast handling.
 * @apiSince 11
 */

public final void clearAbortBroadcast() { throw new RuntimeException("Stub!"); }

/**
 * Finish the broadcast.  The current result will be sent and the
 * next broadcast will proceed.
 * @apiSince 11
 */

public final void finish() { throw new RuntimeException("Stub!"); }
}

}

