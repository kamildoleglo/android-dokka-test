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


package android.util;


/**
 * API for sending log output.
 *
 * <p>Generally, you should use the {@link #v Log.v()}, {@link #d Log.d()},
 * {@link #i Log.i()}, {@link #w Log.w()}, and {@link #e Log.e()} methods to write logs.
 * You can then <a href="{@docRoot}studio/debug/am-logcat.html">view the logs in logcat</a>.
 *
 * <p>The order in terms of verbosity, from least to most is
 * ERROR, WARN, INFO, DEBUG, VERBOSE.  Verbose should never be compiled
 * into an application except during development.  Debug logs are compiled
 * in but stripped at runtime.  Error, warning and info logs are always kept.
 *
 * <p><b>Tip:</b> A good convention is to declare a <code>TAG</code> constant
 * in your class:
 *
 * <pre>private static final String TAG = "MyActivity";</pre>
 *
 * and use that in subsequent calls to the log methods.
 * </p>
 *
 * <p><b>Tip:</b> Don't forget that when you make a call like
 * <pre>Log.v(TAG, "index=" + i);</pre>
 * that when you're building the string to pass into Log.d, the compiler uses a
 * StringBuilder and at least three allocations occur: the StringBuilder
 * itself, the buffer, and the String object.  Realistically, there is also
 * another buffer allocation and copy, and even more pressure on the gc.
 * That means that if your log message is filtered out, you might be doing
 * significant work and incurring significant overhead.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Log {

private Log() { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #VERBOSE} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static int v(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.NonNull java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #VERBOSE} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 * This value may be {@code null}.
 * @param tr An exception to log
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public static int v(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.String msg, @androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #DEBUG} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static int d(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.NonNull java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #DEBUG} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 * This value may be {@code null}.
 * @param tr An exception to log
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public static int d(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.String msg, @androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send an {@link #INFO} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static int i(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.NonNull java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #INFO} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 * This value may be {@code null}.
 * @param tr An exception to log
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public static int i(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.String msg, @androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #WARN} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static int w(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.NonNull java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #WARN} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 * This value may be {@code null}.
 * @param tr An exception to log
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public static int w(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.String msg, @androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Checks to see whether or not a log for the specified tag is loggable at the specified level.
 *
 *  The default level of any tag is set to INFO. This means that any level above and including
 *  INFO will be logged. Before you make any calls to a logging method you should check to see
 *  if your tag should be logged. You can change the default level by setting a system property:
 *      'setprop log.tag.&lt;YOUR_LOG_TAG> &lt;LEVEL>'
 *  Where level is either VERBOSE, DEBUG, INFO, WARN, ERROR, or ASSERT.
 *  You can also create a local.prop file that with the following in it:
 *      'log.tag.&lt;YOUR_LOG_TAG>=&lt;LEVEL>'
 *  and place that in /data/local.prop.
 *
 * @param tag The tag to check.
 * This value may be {@code null}.
 * @param level The level to check.
 * Value is {@link android.util.Log#ASSERT}, {@link android.util.Log#ERROR}, {@link android.util.Log#WARN}, {@link android.util.Log#INFO}, {@link android.util.Log#DEBUG}, or {@link android.util.Log#VERBOSE}
 * @return Whether or not that this is allowed to be logged.
 * @throws java.lang.IllegalArgumentException is thrown if the tag.length() > 23
 *         for Nougat (7.0) releases (API <= 23) and prior, there is no
 *         tag limit of concern after this API level.
 * @apiSince 1
 */

public static native boolean isLoggable(@androidx.annotation.Nullable java.lang.String tag, int level);

/**
 * Send a {@link #WARN} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param tr An exception to log
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public static int w(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send an {@link #ERROR} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static int e(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.NonNull java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #ERROR} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 * This value may be {@code null}.
 * @param tr An exception to log
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public static int e(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.String msg, @androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * What a Terrible Failure: Report a condition that should never happen.
 * The error will always be logged at level ASSERT with the call stack.
 * Depending on system configuration, a report may be added to the
 * {@link android.os.DropBoxManager} and/or the process may be terminated
 * immediately with an error dialog.
 * @param tag Used to identify the source of a log message.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public static int wtf(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * What a Terrible Failure: Report an exception that should never happen.
 * Similar to {@link #wtf(java.lang.String,java.lang.String)}, with an exception to log.
 * @param tag Used to identify the source of a log message.
 * This value may be {@code null}.
 * @param tr An exception to log.
 
 * This value must never be {@code null}.
 * @apiSince 8
 */

public static int wtf(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.NonNull java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * What a Terrible Failure: Report an exception that should never happen.
 * Similar to {@link #wtf(java.lang.String,java.lang.Throwable)}, with a message as well.
 * @param tag Used to identify the source of a log message.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 * This value may be {@code null}.
 * @param tr An exception to log.  May be null.
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public static int wtf(@androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.Nullable java.lang.String msg, @androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Handy function to get a loggable stack trace from a Throwable
 * @param tr An exception to log
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String getStackTraceString(@androidx.annotation.Nullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Low-level logging call.
 * @param priority The priority/type of this log message
 * Value is {@link android.util.Log#ASSERT}, {@link android.util.Log#ERROR}, {@link android.util.Log#WARN}, {@link android.util.Log#INFO}, {@link android.util.Log#DEBUG}, or {@link android.util.Log#VERBOSE}
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * This value may be {@code null}.
 * @param msg The message you would like logged.
 * This value must never be {@code null}.
 * @return The number of bytes written.
 * @apiSince 1
 */

public static int println(int priority, @androidx.annotation.Nullable java.lang.String tag, @androidx.annotation.NonNull java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Priority constant for the println method.
 * @apiSince 1
 */

public static final int ASSERT = 7; // 0x7

/**
 * Priority constant for the println method; use Log.d.
 * @apiSince 1
 */

public static final int DEBUG = 3; // 0x3

/**
 * Priority constant for the println method; use Log.e.
 * @apiSince 1
 */

public static final int ERROR = 6; // 0x6

/**
 * Priority constant for the println method; use Log.i.
 * @apiSince 1
 */

public static final int INFO = 4; // 0x4

/**
 * Priority constant for the println method; use Log.v.
 * @apiSince 1
 */

public static final int VERBOSE = 2; // 0x2

/**
 * Priority constant for the println method; use Log.w.
 * @apiSince 1
 */

public static final int WARN = 5; // 0x5
}

