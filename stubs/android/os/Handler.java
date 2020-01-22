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


package android.os;


/**
 * A Handler allows you to send and process {@link android.os.Message Message} and Runnable
 * objects associated with a thread's {@link android.os.MessageQueue MessageQueue}.  Each Handler
 * instance is associated with a single thread and that thread's message
 * queue. When you create a new Handler it is bound to a {@link android.os.Looper Looper}.
 * It will deliver messages and runnables to that Looper's message
 * queue and execute them on that Looper's thread.
 *
 * <p>There are two main uses for a Handler: (1) to schedule messages and
 * runnables to be executed at some point in the future; and (2) to enqueue
 * an action to be performed on a different thread than your own.
 *
 * <p>Scheduling messages is accomplished with the
 * {@link #post}, {@link #postAtTime(java.lang.Runnable,long)},
 * {@link #postDelayed}, {@link #sendEmptyMessage},
 * {@link #sendMessage}, {@link #sendMessageAtTime}, and
 * {@link #sendMessageDelayed} methods.  The <em>post</em> versions allow
 * you to enqueue Runnable objects to be called by the message queue when
 * they are received; the <em>sendMessage</em> versions allow you to enqueue
 * a {@link android.os.Message Message} object containing a bundle of data that will be
 * processed by the Handler's {@link #handleMessage} method (requiring that
 * you implement a subclass of Handler).
 *
 * <p>When posting or sending to a Handler, you can either
 * allow the item to be processed as soon as the message queue is ready
 * to do so, or specify a delay before it gets processed or absolute time for
 * it to be processed.  The latter two allow you to implement timeouts,
 * ticks, and other timing-based behavior.
 *
 * <p>When a
 * process is created for your application, its main thread is dedicated to
 * running a message queue that takes care of managing the top-level
 * application objects (activities, broadcast receivers, etc) and any windows
 * they create.  You can create your own threads, and communicate back with
 * the main application thread through a Handler.  This is done by calling
 * the same <em>post</em> or <em>sendMessage</em> methods as before, but from
 * your new thread.  The given Runnable or Message will then be scheduled
 * in the Handler's message queue and processed when appropriate.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Handler {

/**
 * Default constructor associates this handler with the {@link android.os.Looper Looper} for the
 * current thread.
 *
 * If this thread does not have a looper, this handler won't be able to receive messages
 * so an exception is thrown.
 *
 * @deprecated Implicitly choosing a Looper during Handler construction can lead to bugs
 *   where operations are silently lost (if the Handler is not expecting new tasks and quits),
 *   crashes (if a handler is sometimes created on a thread without a Looper active), or race
 *   conditions, where the thread a handler is associated with is not what the author
 *   anticipated. Instead, use an {@link java.util.concurrent.Executor} or specify the Looper
 *   explicitly, using {@link android.os.Looper#getMainLooper Looper#getMainLooper}, {link android.view.View#getHandler}, or
 *   similar. If the implicit thread local behavior is required for compatibility, use
 *   {@code new Handler(Looper.myLooper())} to make it clear to readers.
 *
 * @apiSince 1
 */

@Deprecated
public Handler() { throw new RuntimeException("Stub!"); }

/**
 * Constructor associates this handler with the {@link android.os.Looper Looper} for the
 * current thread and takes a callback interface in which you can handle
 * messages.
 *
 * If this thread does not have a looper, this handler won't be able to receive messages
 * so an exception is thrown.
 *
 * @param callback The callback interface in which to handle messages, or null.
 *
 * This value may be {@code null}.
 * @deprecated Implicitly choosing a Looper during Handler construction can lead to bugs
 *   where operations are silently lost (if the Handler is not expecting new tasks and quits),
 *   crashes (if a handler is sometimes created on a thread without a Looper active), or race
 *   conditions, where the thread a handler is associated with is not what the author
 *   anticipated. Instead, use an {@link java.util.concurrent.Executor} or specify the Looper
 *   explicitly, using {@link android.os.Looper#getMainLooper Looper#getMainLooper}, {link android.view.View#getHandler}, or
 *   similar. If the implicit thread local behavior is required for compatibility, use
 *   {@code new Handler(Looper.myLooper(), callback)} to make it clear to readers.
 * @apiSince 3
 */

@Deprecated
public Handler(@androidx.annotation.Nullable android.os.Handler.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Use the provided {@link android.os.Looper Looper} instead of the default one.
 *
 * @param looper The looper, must not be null.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public Handler(@androidx.annotation.NonNull android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Use the provided {@link android.os.Looper Looper} instead of the default one and take a callback
 * interface in which to handle messages.
 *
 * @param looper The looper, must not be null.
 * This value must never be {@code null}.
 * @param callback The callback interface in which to handle messages, or null.
 
 * This value may be {@code null}.
 * @apiSince 3
 */

public Handler(@androidx.annotation.NonNull android.os.Looper looper, @androidx.annotation.Nullable android.os.Handler.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must implement this to receive messages.
 
 * @param msg This value must never be {@code null}.
 * @apiSince 1
 */

public void handleMessage(@androidx.annotation.NonNull android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Handle system messages here.
 
 * @param msg This value must never be {@code null}.
 * @apiSince 1
 */

public void dispatchMessage(@androidx.annotation.NonNull android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Create a new Handler whose posted messages and runnables are not subject to
 * synchronization barriers such as display vsync.
 *
 * <p>Messages sent to an async handler are guaranteed to be ordered with respect to one another,
 * but not necessarily with respect to messages from other Handlers.</p>
 *
 * @see #createAsync(Looper, Callback) to create an async Handler with custom message handling.
 *
 * @param looper the Looper that the new Handler should be bound to
 * This value must never be {@code null}.
 * @return a new async Handler instance
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.os.Handler createAsync(@androidx.annotation.NonNull android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Create a new Handler whose posted messages and runnables are not subject to
 * synchronization barriers such as display vsync.
 *
 * <p>Messages sent to an async handler are guaranteed to be ordered with respect to one another,
 * but not necessarily with respect to messages from other Handlers.</p>
 *
 * @see #createAsync(Looper) to create an async Handler without custom message handling.
 *
 * @param looper the Looper that the new Handler should be bound to
 * This value must never be {@code null}.
 * @param callback This value must never be {@code null}.
 * @return a new async Handler instance
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.os.Handler createAsync(@androidx.annotation.NonNull android.os.Looper looper, @androidx.annotation.NonNull android.os.Handler.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representing the name of the specified message.
 * The default implementation will either return the class name of the
 * message callback if any, or the hexadecimal representation of the
 * message "what" field.
 *
 * @param message The message whose name is being queried
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public java.lang.String getMessageName(@androidx.annotation.NonNull android.os.Message message) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@link android.os.Message Message} from the global message pool. More efficient than
 * creating and allocating new instances. The retrieved message has its handler set to this instance (Message.target == this).
 *  If you don't want that facility, just call Message.obtain() instead.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.os.Message obtainMessage() { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtainMessage()}, except that it also sets the what member of the returned Message.
 *
 * @param what Value to assign to the returned Message.what field.
 * @return A Message from the global message pool.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.os.Message obtainMessage(int what) { throw new RuntimeException("Stub!"); }

/**
 *
 * Same as {@link #obtainMessage()}, except that it also sets the what and obj members
 * of the returned Message.
 *
 * @param what Value to assign to the returned Message.what field.
 * @param obj Value to assign to the returned Message.obj field.
 * This value may be {@code null}.
 * @return A Message from the global message pool.
 
 * This value will never be {@code null}.
 @apiSince 1
 */

@androidx.annotation.NonNull
public final android.os.Message obtainMessage(int what, @androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 *
 * Same as {@link #obtainMessage()}, except that it also sets the what, arg1 and arg2 members of the returned
 * Message.
 * @param what Value to assign to the returned Message.what field.
 * @param arg1 Value to assign to the returned Message.arg1 field.
 * @param arg2 Value to assign to the returned Message.arg2 field.
 * @return A Message from the global message pool.
 
 * This value will never be {@code null}.
 @apiSince 1
 */

@androidx.annotation.NonNull
public final android.os.Message obtainMessage(int what, int arg1, int arg2) { throw new RuntimeException("Stub!"); }

/**
 *
 * Same as {@link #obtainMessage()}, except that it also sets the what, obj, arg1,and arg2 values on the
 * returned Message.
 * @param what Value to assign to the returned Message.what field.
 * @param arg1 Value to assign to the returned Message.arg1 field.
 * @param arg2 Value to assign to the returned Message.arg2 field.
 * @param obj Value to assign to the returned Message.obj field.
 * This value may be {@code null}.
 * @return A Message from the global message pool.
 
 * This value will never be {@code null}.
 @apiSince 1
 */

@androidx.annotation.NonNull
public final android.os.Message obtainMessage(int what, int arg1, int arg2, @androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue.
 * The runnable will be run on the thread to which this handler is
 * attached.
 *
 * @param r The Runnable that will be executed.
 *
 * This value must never be {@code null}.
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 * @apiSince 1
 */

public final boolean post(@androidx.annotation.NonNull java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * at a specific time given by <var>uptimeMillis</var>.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 * The runnable will be run on the thread to which this handler is attached.
 *
 * @param r The Runnable that will be executed.
 * This value must never be {@code null}.
 * @param uptimeMillis The absolute time at which the callback should run,
 *         using the {@link android.os.SystemClock#uptimeMillis} time-base.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 * @apiSince 1
 */

public final boolean postAtTime(@androidx.annotation.NonNull java.lang.Runnable r, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * at a specific time given by <var>uptimeMillis</var>.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 * The runnable will be run on the thread to which this handler is attached.
 *
 * @param r The Runnable that will be executed.
 * This value must never be {@code null}.
 * @param token An instance which can be used to cancel {@code r} via
 *         {@link #removeCallbacksAndMessages}.
 * This value may be {@code null}.
 * @param uptimeMillis The absolute time at which the callback should run,
 *         using the {@link android.os.SystemClock#uptimeMillis} time-base.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 *
 * @see android.os.SystemClock#uptimeMillis
 * @apiSince 1
 */

public final boolean postAtTime(@androidx.annotation.NonNull java.lang.Runnable r, @androidx.annotation.Nullable java.lang.Object token, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * after the specified amount of time elapses.
 * The runnable will be run on the thread to which this handler
 * is attached.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 *
 * @param r The Runnable that will be executed.
 * This value must never be {@code null}.
 * @param delayMillis The delay (in milliseconds) until the Runnable
 *        will be executed.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed --
 *         if the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 * @apiSince 1
 */

public final boolean postDelayed(@androidx.annotation.NonNull java.lang.Runnable r, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * after the specified amount of time elapses.
 * The runnable will be run on the thread to which this handler
 * is attached.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 *
 * @param r The Runnable that will be executed.
 * This value must never be {@code null}.
 * @param token An instance which can be used to cancel {@code r} via
 *         {@link #removeCallbacksAndMessages}.
 * This value may be {@code null}.
 * @param delayMillis The delay (in milliseconds) until the Runnable
 *        will be executed.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed --
 *         if the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 * @apiSince 28
 */

public final boolean postDelayed(@androidx.annotation.NonNull java.lang.Runnable r, @androidx.annotation.Nullable java.lang.Object token, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Posts a message to an object that implements Runnable.
 * Causes the Runnable r to executed on the next iteration through the
 * message queue. The runnable will be run on the thread to which this
 * handler is attached.
 * <b>This method is only for use in very special circumstances -- it
 * can easily starve the message queue, cause ordering problems, or have
 * other unexpected side-effects.</b>
 *
 * @param r The Runnable that will be executed.
 *
 * This value must never be {@code null}.
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 * @apiSince 1
 */

public final boolean postAtFrontOfQueue(@androidx.annotation.NonNull java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of Runnable r that are in the message queue.
 
 * @param r This value must never be {@code null}.
 * @apiSince 1
 */

public final void removeCallbacks(@androidx.annotation.NonNull java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of Runnable <var>r</var> with Object
 * <var>token</var> that are in the message queue.  If <var>token</var> is null,
 * all callbacks will be removed.
 
 * @param r This value must never be {@code null}.
 
 * @param token This value may be {@code null}.
 * @apiSince 1
 */

public final void removeCallbacks(@androidx.annotation.NonNull java.lang.Runnable r, @androidx.annotation.Nullable java.lang.Object token) { throw new RuntimeException("Stub!"); }

/**
 * Pushes a message onto the end of the message queue after all pending messages
 * before the current time. It will be received in {@link #handleMessage},
 * in the thread attached to this handler.
 *
 * @param msg This value must never be {@code null}.
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 * @apiSince 1
 */

public final boolean sendMessage(@androidx.annotation.NonNull android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Sends a Message containing only the what value.
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 * @apiSince 1
 */

public final boolean sendEmptyMessage(int what) { throw new RuntimeException("Stub!"); }

/**
 * Sends a Message containing only the what value, to be delivered
 * after the specified amount of time elapses.
 * @see #sendMessageDelayed(android.os.Message, long)
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 * @apiSince 1
 */

public final boolean sendEmptyMessageDelayed(int what, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Sends a Message containing only the what value, to be delivered
 * at a specific time.
 * @see #sendMessageAtTime(android.os.Message, long)
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 * @apiSince 1
 */

public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Enqueue a message into the message queue after all pending messages
 * before (current time + delayMillis). You will receive it in
 * {@link #handleMessage}, in the thread attached to this handler.
 *
 * @param msg This value must never be {@code null}.
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the message will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 * @apiSince 1
 */

public final boolean sendMessageDelayed(@androidx.annotation.NonNull android.os.Message msg, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Enqueue a message into the message queue after all pending messages
 * before the absolute time (in milliseconds) <var>uptimeMillis</var>.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 * You will receive it in {@link #handleMessage}, in the thread attached
 * to this handler.
 *
 * @param uptimeMillis The absolute time at which the message should be
 *         delivered, using the
 *         {@link android.os.SystemClock#uptimeMillis} time-base.
 *
 * @param msg This value must never be {@code null}.
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the message will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 * @apiSince 1
 */

public boolean sendMessageAtTime(@androidx.annotation.NonNull android.os.Message msg, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Enqueue a message at the front of the message queue, to be processed on
 * the next iteration of the message loop.  You will receive it in
 * {@link #handleMessage}, in the thread attached to this handler.
 * <b>This method is only for use in very special circumstances -- it
 * can easily starve the message queue, cause ordering problems, or have
 * other unexpected side-effects.</b>
 *
 * @param msg This value must never be {@code null}.
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 * @apiSince 1
 */

public final boolean sendMessageAtFrontOfQueue(@androidx.annotation.NonNull android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of messages with code 'what' that are in the
 * message queue.
 * @apiSince 1
 */

public final void removeMessages(int what) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of messages with code 'what' and whose obj is
 * 'object' that are in the message queue.  If <var>object</var> is null,
 * all messages will be removed.
 
 * @param object This value may be {@code null}.
 * @apiSince 1
 */

public final void removeMessages(int what, @androidx.annotation.Nullable java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of callbacks and sent messages whose
 * <var>obj</var> is <var>token</var>.  If <var>token</var> is null,
 * all callbacks and messages will be removed.
 
 * @param token This value may be {@code null}.
 * @apiSince 1
 */

public final void removeCallbacksAndMessages(@androidx.annotation.Nullable java.lang.Object token) { throw new RuntimeException("Stub!"); }

/**
 * Check if there are any pending posts of messages with code 'what' in
 * the message queue.
 * @apiSince 1
 */

public final boolean hasMessages(int what) { throw new RuntimeException("Stub!"); }

/**
 * Check if there are any pending posts of messages with code 'what' and
 * whose obj is 'object' in the message queue.
 
 * @param object This value may be {@code null}.
 * @apiSince 1
 */

public final boolean hasMessages(int what, @androidx.annotation.Nullable java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Check if there are any pending posts of messages with callback r in
 * the message queue.
 
 * @param r This value must never be {@code null}.
 * @apiSince 29
 */

public final boolean hasCallbacks(@androidx.annotation.NonNull java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.os.Looper getLooper() { throw new RuntimeException("Stub!"); }

/**
 * @param pw This value must never be {@code null}.
 
 * @param prefix This value must never be {@code null}.
 * @apiSince 1
 */

public final void dump(@androidx.annotation.NonNull android.util.Printer pw, @androidx.annotation.NonNull java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * Callback interface you can use when instantiating a Handler to avoid
 * having to implement your own subclass of Handler.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * @param msg A {@link android.os.Message Message} object
 * This value must never be {@code null}.
 * @return True if no further handling is desired
 * @apiSince 3
 */

public boolean handleMessage(@androidx.annotation.NonNull android.os.Message msg);
}

}

