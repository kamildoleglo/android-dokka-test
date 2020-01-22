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


package android.util;


/**
 * A utility class to help log timings splits throughout a method call.
 * Typical usage is:
 *
 * <pre>
 *     TimingLogger timings = new TimingLogger(TAG, "methodA");
 *     // ... do some work A ...
 *     timings.addSplit("work A");
 *     // ... do some work B ...
 *     timings.addSplit("work B");
 *     // ... do some work C ...
 *     timings.addSplit("work C");
 *     timings.dumpToLog();
 * </pre>
 *
 * <p>The dumpToLog call would add the following to the log:</p>
 *
 * <pre>
 *     D/TAG     ( 3459): methodA: begin
 *     D/TAG     ( 3459): methodA:      9 ms, work A
 *     D/TAG     ( 3459): methodA:      1 ms, work B
 *     D/TAG     ( 3459): methodA:      6 ms, work C
 *     D/TAG     ( 3459): methodA: end, 16 ms
 * </pre>
 *
 * @deprecated Use {@link android.os.Trace}, or
 *   <a href="https://developer.android.com/studio/profile/benchmark">Android Studio</a>. In
 *   general, milliseconds is the wrong granularity for method-level tracing. Rounding errors
 *   can overemphasize cheap operations, or underemphasize repeated operations. This timing
 *   system also does not take CPU scheduling or frequency into account.
 * @apiSince 1
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class TimingLogger {

/**
 * Create and initialize a TimingLogger object that will log using
 * the specific tag. If the Log.isLoggable is not enabled to at
 * least the Log.VERBOSE level for that tag at creation time then
 * the addSplit and dumpToLog call will do nothing.
 * @param tag the log tag to use while logging the timings
 * @param label a string to be displayed with each log
 * @apiSince 1
 */

@Deprecated
public TimingLogger(java.lang.String tag, java.lang.String label) { throw new RuntimeException("Stub!"); }

/**
 * Clear and initialize a TimingLogger object that will log using
 * the specific tag. If the Log.isLoggable is not enabled to at
 * least the Log.VERBOSE level for that tag at creation time then
 * the addSplit and dumpToLog call will do nothing.
 * @param tag the log tag to use while logging the timings
 * @param label a string to be displayed with each log
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void reset(java.lang.String tag, java.lang.String label) { throw new RuntimeException("Stub!"); }

/**
 * Clear and initialize a TimingLogger object that will log using
 * the tag and label that was specified previously, either via
 * the constructor or a call to reset(tag, label). If the
 * Log.isLoggable is not enabled to at least the Log.VERBOSE
 * level for that tag at creation time then the addSplit and
 * dumpToLog call will do nothing.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Add a split for the current time, labeled with splitLabel. If
 * Log.isLoggable was not enabled to at least the Log.VERBOSE for
 * the specified tag at construction or reset() time then this
 * call does nothing.
 * @param splitLabel a label to associate with this split.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void addSplit(java.lang.String splitLabel) { throw new RuntimeException("Stub!"); }

/**
 * Dumps the timings to the log using Log.d(). If Log.isLoggable was
 * not enabled to at least the Log.VERBOSE for the specified tag at
 * construction or reset() time then this call does nothing.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void dumpToLog() { throw new RuntimeException("Stub!"); }
}

