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


package android.os;

import android.content.Context;
import java.io.IOException;

/**
 * Provides various debugging methods for Android applications, including
 * tracing and allocation counts.
 * <p><strong>Logging Trace Files</strong></p>
 * <p>Debug can create log files that give details about an application, such as
 * a call stack and start/stop times for any running methods. See <a
 * href="{@docRoot}studio/profile/traceview.html">Inspect Trace Logs with
 * Traceview</a> for information about reading trace files. To start logging
 * trace files, call one of the startMethodTracing() methods. To stop tracing,
 * call {@link #stopMethodTracing()}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Debug {

private Debug() { throw new RuntimeException("Stub!"); }

/**
 * Wait until a debugger attaches.  As soon as the debugger attaches,
 * this returns, so you will need to place a breakpoint after the
 * waitForDebugger() call if you want to start tracing immediately.
 * @apiSince 1
 */

public static void waitForDebugger() { throw new RuntimeException("Stub!"); }

/**
 * Returns "true" if one or more threads is waiting for a debugger
 * to attach.
 * @apiSince 1
 */

public static boolean waitingForDebugger() { throw new RuntimeException("Stub!"); }

/**
 * Determine if a debugger is currently attached.
 * @apiSince 1
 */

public static boolean isDebuggerConnected() { throw new RuntimeException("Stub!"); }

/**
 * Change the JDWP port.
 *
 * @deprecated no longer needed or useful
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void changeDebugPort(int port) { throw new RuntimeException("Stub!"); }

/**
 * Enable qemu tracing. For this to work requires running everything inside
 * the qemu emulator; otherwise, this method will have no effect. The trace
 * file is specified on the command line when the emulator is started. For
 * example, the following command line <br />
 * <code>emulator -trace foo</code><br />
 * will start running the emulator and create a trace file named "foo". This
 * method simply enables writing the trace records to the trace file.
 *
 * <p>
 * The main differences between this and {@link #startMethodTracing()} are
 * that tracing in the qemu emulator traces every cpu instruction of every
 * process, including kernel code, so we have more complete information,
 * including all context switches. We can also get more detailed information
 * such as cache misses. The sequence of calls is determined by
 * post-processing the instruction trace. The qemu tracing is also done
 * without modifying the application or perturbing the timing of calls
 * because no instrumentation is added to the application being traced.
 * </p>
 *
 * <p>
 * One limitation of using this method compared to using
 * {@link #startMethodTracing()} on the real device is that the emulator
 * does not model all of the real hardware effects such as memory and
 * bus contention.  The emulator also has a simple cache model and cannot
 * capture all the complexities of a real cache.
 * </p>
 * @apiSince 1
 */

public static void startNativeTracing() { throw new RuntimeException("Stub!"); }

/**
 * Stop qemu tracing.  See {@link #startNativeTracing()} to start tracing.
 *
 * <p>Tracing can be started and stopped as many times as desired.  When
 * the qemu emulator itself is stopped then the buffered trace records
 * are flushed and written to the trace file.  In fact, it is not necessary
 * to call this method at all; simply killing qemu is sufficient.  But
 * starting and stopping a trace is useful for examining a specific
 * region of code.</p>
 * @apiSince 1
 */

public static void stopNativeTracing() { throw new RuntimeException("Stub!"); }

/**
 * Enable "emulator traces", in which information about the current
 * method is made available to the "emulator -trace" feature.  There
 * is no corresponding "disable" call -- this is intended for use by
 * the framework when tracing should be turned on and left that way, so
 * that traces captured with F9/F10 will include the necessary data.
 *
 * This puts the VM into "profile" mode, which has performance
 * consequences.
 *
 * To temporarily enable tracing, use {@link #startNativeTracing()}.
 * @apiSince 1
 */

public static void enableEmulatorTraceOutput() { throw new RuntimeException("Stub!"); }

/**
 * Start method tracing with default log name and buffer size.
 * <p>
 * By default, the trace file is called "dmtrace.trace" and it's placed
 * under your package-specific directory on primary shared/external storage,
 * as returned by {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}.
 * <p>
 * See <a href="{@docRoot}studio/profile/traceview.html">Inspect Trace Logs
 * with Traceview</a> for information about reading trace files.
 * <p class="note">
 * When method tracing is enabled, the VM will run more slowly than usual,
 * so the timings from the trace files should only be considered in relative
 * terms (e.g. was run #1 faster than run #2). The times for native methods
 * will not change, so don't try to use this to compare the performance of
 * interpreted and native implementations of the same method. As an
 * alternative, consider using sampling-based method tracing via
 * {@link #startMethodTracingSampling(java.lang.String,int,int)} or "native" tracing
 * in the emulator via {@link #startNativeTracing()}.
 * </p>
 * @apiSince 1
 */

public static void startMethodTracing() { throw new RuntimeException("Stub!"); }

/**
 * Start method tracing, specifying the trace log file path.
 * <p>
 * When a relative file path is given, the trace file will be placed under
 * your package-specific directory on primary shared/external storage, as
 * returned by {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}.
 * <p>
 * See <a href="{@docRoot}studio/profile/traceview.html">Inspect Trace Logs
 * with Traceview</a> for information about reading trace files.
 * <p class="note">
 * When method tracing is enabled, the VM will run more slowly than usual,
 * so the timings from the trace files should only be considered in relative
 * terms (e.g. was run #1 faster than run #2). The times for native methods
 * will not change, so don't try to use this to compare the performance of
 * interpreted and native implementations of the same method. As an
 * alternative, consider using sampling-based method tracing via
 * {@link #startMethodTracingSampling(java.lang.String,int,int)} or "native" tracing
 * in the emulator via {@link #startNativeTracing()}.
 * </p>
 *
 * @param tracePath Path to the trace log file to create. If {@code null},
 *            this will default to "dmtrace.trace". If the file already
 *            exists, it will be truncated. If the path given does not end
 *            in ".trace", it will be appended for you.
 * @apiSince 1
 */

public static void startMethodTracing(java.lang.String tracePath) { throw new RuntimeException("Stub!"); }

/**
 * Start method tracing, specifying the trace log file name and the buffer
 * size.
 * <p>
 * When a relative file path is given, the trace file will be placed under
 * your package-specific directory on primary shared/external storage, as
 * returned by {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}.
 * <p>
 * See <a href="{@docRoot}studio/profile/traceview.html">Inspect Trace Logs
 * with Traceview</a> for information about reading trace files.
 * <p class="note">
 * When method tracing is enabled, the VM will run more slowly than usual,
 * so the timings from the trace files should only be considered in relative
 * terms (e.g. was run #1 faster than run #2). The times for native methods
 * will not change, so don't try to use this to compare the performance of
 * interpreted and native implementations of the same method. As an
 * alternative, consider using sampling-based method tracing via
 * {@link #startMethodTracingSampling(java.lang.String,int,int)} or "native" tracing
 * in the emulator via {@link #startNativeTracing()}.
 * </p>
 *
 * @param tracePath Path to the trace log file to create. If {@code null},
 *            this will default to "dmtrace.trace". If the file already
 *            exists, it will be truncated. If the path given does not end
 *            in ".trace", it will be appended for you.
 * @param bufferSize The maximum amount of trace data we gather. If not
 *            given, it defaults to 8MB.
 * @apiSince 1
 */

public static void startMethodTracing(java.lang.String tracePath, int bufferSize) { throw new RuntimeException("Stub!"); }

/**
 * Start method tracing, specifying the trace log file name, the buffer
 * size, and flags.
 * <p>
 * When a relative file path is given, the trace file will be placed under
 * your package-specific directory on primary shared/external storage, as
 * returned by {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}.
 * <p>
 * See <a href="{@docRoot}studio/profile/traceview.html">Inspect Trace Logs
 * with Traceview</a> for information about reading trace files.
 * <p class="note">
 * When method tracing is enabled, the VM will run more slowly than usual,
 * so the timings from the trace files should only be considered in relative
 * terms (e.g. was run #1 faster than run #2). The times for native methods
 * will not change, so don't try to use this to compare the performance of
 * interpreted and native implementations of the same method. As an
 * alternative, consider using sampling-based method tracing via
 * {@link #startMethodTracingSampling(java.lang.String,int,int)} or "native" tracing
 * in the emulator via {@link #startNativeTracing()}.
 * </p>
 *
 * @param tracePath Path to the trace log file to create. If {@code null},
 *            this will default to "dmtrace.trace". If the file already
 *            exists, it will be truncated. If the path given does not end
 *            in ".trace", it will be appended for you.
 * @param bufferSize The maximum amount of trace data we gather. If not
 *            given, it defaults to 8MB.
 * @param flags Flags to control method tracing. The only one that is
 *            currently defined is {@link #TRACE_COUNT_ALLOCS}.
 * @apiSince 1
 */

public static void startMethodTracing(java.lang.String tracePath, int bufferSize, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Start sampling-based method tracing, specifying the trace log file name,
 * the buffer size, and the sampling interval.
 * <p>
 * When a relative file path is given, the trace file will be placed under
 * your package-specific directory on primary shared/external storage, as
 * returned by {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}.
 * <p>
 * See <a href="{@docRoot}studio/profile/traceview.html">Inspect Trace Logs
 * with Traceview</a> for information about reading trace files.
 *
 * @param tracePath Path to the trace log file to create. If {@code null},
 *            this will default to "dmtrace.trace". If the file already
 *            exists, it will be truncated. If the path given does not end
 *            in ".trace", it will be appended for you.
 * @param bufferSize The maximum amount of trace data we gather. If not
 *            given, it defaults to 8MB.
 * @param intervalUs The amount of time between each sample in microseconds.
 * @apiSince 21
 */

public static void startMethodTracingSampling(java.lang.String tracePath, int bufferSize, int intervalUs) { throw new RuntimeException("Stub!"); }

/**
 * Stop method tracing.
 * @apiSince 1
 */

public static void stopMethodTracing() { throw new RuntimeException("Stub!"); }

/**
 * Get an indication of thread CPU usage.  The value returned
 * indicates the amount of time that the current thread has spent
 * executing code or waiting for certain types of I/O.
 *
 * The time is expressed in nanoseconds, and is only meaningful
 * when compared to the result from an earlier call.  Note that
 * nanosecond resolution does not imply nanosecond accuracy.
 *
 * On system which don't support this operation, the call returns -1.
 * @apiSince 1
 */

public static long threadCpuTimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * Start counting the number and aggregate size of memory allocations.
 *
 * <p>The {@link #startAllocCounting() start} method resets the counts and enables counting.
 * The {@link #stopAllocCounting() stop} method disables the counting so that the analysis
 * code doesn't cause additional allocations.  The various <code>get</code> methods return
 * the specified value. And the various <code>reset</code> methods reset the specified
 * count.</p>
 *
 * <p>Counts are kept for the system as a whole (global) and for each thread.
 * The per-thread counts for threads other than the current thread
 * are not cleared by the "reset" or "start" calls.</p>
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public static void startAllocCounting() { throw new RuntimeException("Stub!"); }

/**
 * Stop counting the number and aggregate size of memory allocations.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated
public static void stopAllocCounting() { throw new RuntimeException("Stub!"); }

/**
 * Returns the global count of objects allocated by the runtime between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getGlobalAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * Clears the global count of objects allocated.
 * @see #getGlobalAllocCount()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetGlobalAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the global size, in bytes, of objects allocated by the runtime between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getGlobalAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * Clears the global size of objects allocated.
 * @see #getGlobalAllocSize()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetGlobalAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the global count of objects freed by the runtime between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getGlobalFreedCount() { throw new RuntimeException("Stub!"); }

/**
 * Clears the global count of objects freed.
 * @see #getGlobalFreedCount()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetGlobalFreedCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the global size, in bytes, of objects freed by the runtime between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getGlobalFreedSize() { throw new RuntimeException("Stub!"); }

/**
 * Clears the global size of objects freed.
 * @see #getGlobalFreedSize()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetGlobalFreedSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of non-concurrent GC invocations between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getGlobalGcInvocationCount() { throw new RuntimeException("Stub!"); }

/**
 * Clears the count of non-concurrent GC invocations.
 * @see #getGlobalGcInvocationCount()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetGlobalGcInvocationCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of classes successfully initialized (ie those that executed without
 * throwing an exception) between a {@link #startAllocCounting() start} and
 * {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated
public static int getGlobalClassInitCount() { throw new RuntimeException("Stub!"); }

/**
 * Clears the count of classes initialized.
 * @see #getGlobalClassInitCount()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated
public static void resetGlobalClassInitCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time spent successfully initializing classes between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated
public static int getGlobalClassInitTime() { throw new RuntimeException("Stub!"); }

/**
 * Clears the count of time spent initializing classes.
 * @see #getGlobalClassInitTime()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated
public static void resetGlobalClassInitTime() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and always returns 0.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getGlobalExternalAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void resetGlobalExternalAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void resetGlobalExternalAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and always returns 0.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getGlobalExternalAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and always returns 0.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getGlobalExternalFreedCount() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void resetGlobalExternalFreedCount() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getGlobalExternalFreedSize() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void resetGlobalExternalFreedSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the thread-local count of objects allocated by the runtime between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getThreadAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * Clears the thread-local count of objects allocated.
 * @see #getThreadAllocCount()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetThreadAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the thread-local size of objects allocated by the runtime between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 * @return The allocated size in bytes.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getThreadAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * Clears the thread-local count of objects allocated.
 * @see #getThreadAllocSize()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetThreadAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getThreadExternalAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void resetThreadExternalAllocCount() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getThreadExternalAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * This method exists for compatibility and has no effect.
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void resetThreadExternalAllocSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of thread-local non-concurrent GC invocations between a
 * {@link #startAllocCounting() start} and {@link #stopAllocCounting() stop}.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static int getThreadGcInvocationCount() { throw new RuntimeException("Stub!"); }

/**
 * Clears the thread-local count of non-concurrent GC invocations.
 * @see #getThreadGcInvocationCount()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetThreadGcInvocationCount() { throw new RuntimeException("Stub!"); }

/**
 * Clears all the global and thread-local memory allocation counters.
 * @see #startAllocCounting()
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static void resetAllCounts() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of a particular runtime statistic or {@code null} if no
 * such runtime statistic exists.
 *
 * <p>The following table lists the runtime statistics that the runtime supports.
 * All statistics are approximate. Individual allocations may not be immediately reflected
 * in the results.
 * Note runtime statistics may be added or removed in a future API level.</p>
 *
 * <table>
 *     <thead>
 *         <tr>
 *             <th>Runtime statistic name</th>
 *             <th>Meaning</th>
 *             <th>Example</th>
 *             <th>Supported (API Levels)</th>
 *         </tr>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>art.gc.gc-count</td>
 *             <td>The number of garbage collection runs.</td>
 *             <td>{@code 164}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>art.gc.gc-time</td>
 *             <td>The total duration of garbage collection runs in ms.</td>
 *             <td>{@code 62364}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>art.gc.bytes-allocated</td>
 *             <td>The total number of bytes that the application allocated.</td>
 *             <td>{@code 1463948408}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>art.gc.bytes-freed</td>
 *             <td>The total number of bytes that garbage collection reclaimed.</td>
 *             <td>{@code 1313493084}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>art.gc.blocking-gc-count</td>
 *             <td>The number of blocking garbage collection runs.</td>
 *             <td>{@code 2}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>art.gc.blocking-gc-time</td>
 *             <td>The total duration of blocking garbage collection runs in ms.</td>
 *             <td>{@code 804}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>art.gc.gc-count-rate-histogram</td>
 *             <td>Every 10 seconds, the gc-count-rate is computed as the number of garbage
 *                 collection runs that have occurred over the last 10
 *                 seconds. art.gc.gc-count-rate-histogram is a histogram of the gc-count-rate
 *                 samples taken since the process began. The histogram can be used to identify
 *                 instances of high rates of garbage collection runs. For example, a histogram
 *                 of "0:34503,1:45350,2:11281,3:8088,4:43,5:8" shows that most of the time
 *                 there are between 0 and 2 garbage collection runs every 10 seconds, but there
 *                 were 8 distinct 10-second intervals in which 5 garbage collection runs
 *                 occurred.</td>
 *             <td>{@code 0:34503,1:45350,2:11281,3:8088,4:43,5:8}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>art.gc.blocking-gc-count-rate-histogram</td>
 *             <td>Every 10 seconds, the blocking-gc-count-rate is computed as the number of
 *                 blocking garbage collection runs that have occurred over the last 10
 *                 seconds. art.gc.blocking-gc-count-rate-histogram is a histogram of the
 *                 blocking-gc-count-rate samples taken since the process began. The histogram
 *                 can be used to identify instances of high rates of blocking garbage
 *                 collection runs. For example, a histogram of "0:99269,1:1,2:1" shows that
 *                 most of the time there are zero blocking garbage collection runs every 10
 *                 seconds, but there was one 10-second interval in which one blocking garbage
 *                 collection run occurred, and there was one interval in which two blocking
 *                 garbage collection runs occurred.</td>
 *             <td>{@code 0:99269,1:1,2:1}</td>
 *             <td>23</td>
 *         </tr>
 *     </tbody>
 * </table>
 *
 * @param statName
 *            the name of the runtime statistic to look up.
 * @return the value of the specified runtime statistic or {@code null} if the
 *         runtime statistic doesn't exist.
 * @apiSince 23
 */

public static java.lang.String getRuntimeStat(java.lang.String statName) { throw new RuntimeException("Stub!"); }

/**
 * Returns a map of the names/values of the runtime statistics
 * that {@link #getRuntimeStat(java.lang.String)} supports.
 *
 * @return a map of the names/values of the supported runtime statistics.
 * @apiSince 23
 */

public static java.util.Map<java.lang.String,java.lang.String> getRuntimeStats() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the native heap.
 * @return The size of the native heap in bytes.
 * @apiSince 1
 */

public static native long getNativeHeapSize();

/**
 * Returns the amount of allocated memory in the native heap.
 * @return The allocated size in bytes.
 * @apiSince 1
 */

public static native long getNativeHeapAllocatedSize();

/**
 * Returns the amount of free memory in the native heap.
 * @return The freed size in bytes.
 * @apiSince 1
 */

public static native long getNativeHeapFreeSize();

/**
 * Retrieves information about this processes memory usages. This information is broken down by
 * how much is in use by dalvik, the native heap, and everything else.
 *
 * <p><b>Note:</b> this method directly retrieves memory information for the given process
 * from low-level data available to it.  It may not be able to retrieve information about
 * some protected allocations, such as graphics.  If you want to be sure you can see
 * all information about allocations by the process, use
 * {@link android.app.ActivityManager#getProcessMemoryInfo(int[])} instead.</p>
 * @apiSince 1
 */

public static native void getMemoryInfo(android.os.Debug.MemoryInfo memoryInfo);

/**
 * Retrieves the PSS memory used by the process as given by the
 * smaps.
 * @apiSince 14
 */

public static native long getPss();

/**
 * Establish an object allocation limit in the current thread.
 * This feature was never enabled in release builds.  The
 * allocation limits feature was removed in Honeycomb.  This
 * method exists for compatibility and always returns -1 and has
 * no effect.
 *
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int setAllocationLimit(int limit) { throw new RuntimeException("Stub!"); }

/**
 * Establish a global object allocation limit.  This feature was
 * never enabled in release builds.  The allocation limits feature
 * was removed in Honeycomb.  This method exists for compatibility
 * and always returns -1 and has no effect.
 *
 * @deprecated This method is now obsolete.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int setGlobalAllocationLimit(int limit) { throw new RuntimeException("Stub!"); }

/**
 * Dump a list of all currently loaded class to the log file.
 *
 * @param flags See constants above.
 * @apiSince 1
 */

public static void printLoadedClasses(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of loaded classes.
 * @return the number of loaded classes.
 * @apiSince 1
 */

public static int getLoadedClassCount() { throw new RuntimeException("Stub!"); }

/**
 * Dump "hprof" data to the specified file.  This may cause a GC.
 *
 * @param fileName Full pathname of output file (e.g. "/sdcard/dump.hprof").
 * @throws java.lang.UnsupportedOperationException if the VM was built without
 *         HPROF support.
 * @throws java.io.IOException if an error occurs while opening or writing files.
 * @apiSince 3
 */

public static void dumpHprofData(java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of sent transactions from this process.
 * @return The number of sent transactions or -1 if it could not read t.
 * @apiSince 1
 */

public static native int getBinderSentTransactions();

/**
 * Returns the number of received transactions from the binder driver.
 * @return The number of received transactions or -1 if it could not read the stats.
 * @apiSince 1
 */

public static native int getBinderReceivedTransactions();

/**
 * Returns the number of active local Binder objects that exist in the
 * current process.
 * @apiSince 1
 */

public static native int getBinderLocalObjectCount();

/**
 * Returns the number of references to remote proxy Binder objects that
 * exist in the current process.
 * @apiSince 1
 */

public static native int getBinderProxyObjectCount();

/**
 * Returns the number of death notification links to Binder objects that
 * exist in the current process.
 * @apiSince 1
 */

public static native int getBinderDeathObjectCount();

/**
 * Get a debugging dump of a system service by name.
 *
 * <p>Most services require the caller to hold android.permission.DUMP.
 *
 * @param name of the service to dump
 * @param fd to write dump output to (usually an output log file)
 * @param args to pass to the service's dump method, may be null
 * @return true if the service was dumped successfully, false if
 *     the service could not be found or had an error while dumping
 * @apiSince 8
 */

public static boolean dumpService(java.lang.String name, java.io.FileDescriptor fd, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Attach a library as a jvmti agent to the current runtime, with the given classloader
 * determining the library search path.
 * <p>
 * Note: agents may only be attached to debuggable apps. Otherwise, this function will
 * throw a SecurityException.
 *
 * @param library the library containing the agent.
 * This value must never be {@code null}.
 * @param options the options passed to the agent.
 * This value may be {@code null}.
 * @param classLoader the classloader determining the library search path.
 *
 * This value may be {@code null}.
 * @throws java.io.IOException if the agent could not be attached.
 * @throws java.lang.SecurityException if the app is not debuggable.
 * @apiSince 28
 */

public static void attachJvmtiAgent(@androidx.annotation.NonNull java.lang.String library, @androidx.annotation.Nullable java.lang.String options, @androidx.annotation.Nullable java.lang.ClassLoader classLoader) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int SHOW_CLASSLOADER = 2; // 0x2

/**
 * Flags for printLoadedClasses().  Default behavior is to only show
 * the class name.
 * @apiSince 1
 */

public static final int SHOW_FULL_DETAIL = 1; // 0x1

/** @apiSince 1 */

public static final int SHOW_INITIALIZED = 4; // 0x4

/**
 * Flags for startMethodTracing().  These can be ORed together.
 *
 * TRACE_COUNT_ALLOCS adds the results from startAllocCounting to the
 * trace key file.
 *
 * @deprecated Accurate counting is a burden on the runtime and may be removed.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated public static final int TRACE_COUNT_ALLOCS = 1; // 0x1
/**
 * API for gathering and querying instruction counts.
 *
 * Example usage:
 * <pre>
 *   Debug.InstructionCount icount = new Debug.InstructionCount();
 *   icount.resetAndStart();
 *    [... do lots of stuff ...]
 *   if (icount.collect()) {
 *       System.out.println("Total instructions executed: "
 *           + icount.globalTotal());
 *       System.out.println("Method invocations: "
 *           + icount.globalMethodInvocations());
 *   }
 * </pre>
 *
 * @deprecated Instruction counting is no longer supported.
 * @apiSince 1
 * @deprecatedSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class InstructionCount {

/** @apiSince 1 */

@Deprecated
public InstructionCount() { throw new RuntimeException("Stub!"); }

/**
 * Reset counters and ensure counts are running.  Counts may
 * have already been running.
 *
 * @return true if counting was started
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public boolean resetAndStart() { throw new RuntimeException("Stub!"); }

/**
 * Collect instruction counts.  May or may not stop the
 * counting process.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public boolean collect() { throw new RuntimeException("Stub!"); }

/**
 * Return the total number of instructions executed globally (i.e. in
 * all threads).
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public int globalTotal() { throw new RuntimeException("Stub!"); }

/**
 * Return the total number of method-invocation instructions
 * executed globally.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public int globalMethodInvocations() { throw new RuntimeException("Stub!"); }
}

/**
 * This class is used to retrieved various statistics about the memory mappings for this
 * process. The returned info is broken down by dalvik, native, and other. All results are in kB.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MemoryInfo implements android.os.Parcelable {

/** @apiSince 1 */

public MemoryInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return total PSS memory usage in kB.
 * @apiSince 5
 */

public int getTotalPss() { throw new RuntimeException("Stub!"); }

/**
 * Return total PSS memory usage in kB mapping a file of one of the following extension:
 * .so, .jar, .apk, .ttf, .dex, .odex, .oat, .art .
 * @apiSince 19
 */

public int getTotalSwappablePss() { throw new RuntimeException("Stub!"); }

/**
 * Return total private dirty memory usage in kB.
 * @apiSince 5
 */

public int getTotalPrivateDirty() { throw new RuntimeException("Stub!"); }

/**
 * Return total shared dirty memory usage in kB.
 * @apiSince 5
 */

public int getTotalSharedDirty() { throw new RuntimeException("Stub!"); }

/**
 * Return total shared clean memory usage in kB.
 * @apiSince 19
 */

public int getTotalPrivateClean() { throw new RuntimeException("Stub!"); }

/**
 * Return total shared clean memory usage in kB.
 * @apiSince 19
 */

public int getTotalSharedClean() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of a particular memory statistic or {@code null} if no
 * such memory statistic exists.
 *
 * <p>The following table lists the memory statistics that are supported.
 * Note that memory statistics may be added or removed in a future API level.</p>
 *
 * <table>
 *     <thead>
 *         <tr>
 *             <th>Memory statistic name</th>
 *             <th>Meaning</th>
 *             <th>Example</th>
 *             <th>Supported (API Levels)</th>
 *         </tr>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>summary.java-heap</td>
 *             <td>The private Java Heap usage in kB. This corresponds to the Java Heap field
 *                 in the App Summary section output by dumpsys meminfo.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.native-heap</td>
 *             <td>The private Native Heap usage in kB. This corresponds to the Native Heap
 *                 field in the App Summary section output by dumpsys meminfo.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.code</td>
 *             <td>The memory usage for static code and resources in kB. This corresponds to
 *                 the Code field in the App Summary section output by dumpsys meminfo.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.stack</td>
 *             <td>The stack usage in kB. This corresponds to the Stack field in the
 *                 App Summary section output by dumpsys meminfo.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.graphics</td>
 *             <td>The graphics usage in kB. This corresponds to the Graphics field in the
 *                 App Summary section output by dumpsys meminfo.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.private-other</td>
 *             <td>Other private memory usage in kB. This corresponds to the Private Other
 *                 field output in the App Summary section by dumpsys meminfo.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.system</td>
 *             <td>Shared and system memory usage in kB. This corresponds to the System
 *                 field output in the App Summary section by dumpsys meminfo.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.total-pss</td>
 *             <td>Total PPS memory usage in kB.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *         <tr>
 *             <td>summary.total-swap</td>
 *             <td>Total swap usage in kB.</td>
 *             <td>{@code 1442}</td>
 *             <td>23</td>
 *         </tr>
 *     </tbody>
 * </table>
 * @apiSince 23
 */

public java.lang.String getMemoryStat(java.lang.String statName) { throw new RuntimeException("Stub!"); }

/**
 * Returns a map of the names/values of the memory statistics
 * that {@link #getMemoryStat(java.lang.String)} supports.
 *
 * @return a map of the names/values of the supported memory statistics.
 * @apiSince 23
 */

public java.util.Map<java.lang.String,java.lang.String> getMemoryStats() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.Debug.MemoryInfo> CREATOR;
static { CREATOR = null; }

/**
 * The private dirty pages used by dalvik heap.
 * @apiSince 1
 */

public int dalvikPrivateDirty;

/**
 * The proportional set size for dalvik heap.  (Doesn't include other Dalvik overhead.)
 * @apiSince 1
 */

public int dalvikPss;

/**
 * The shared dirty pages used by dalvik heap.
 * @apiSince 1
 */

public int dalvikSharedDirty;

/**
 * The private dirty pages used by the native heap.
 * @apiSince 1
 */

public int nativePrivateDirty;

/**
 * The proportional set size for the native heap.
 * @apiSince 1
 */

public int nativePss;

/**
 * The shared dirty pages used by the native heap.
 * @apiSince 1
 */

public int nativeSharedDirty;

/**
 * The private dirty pages used by everything else.
 * @apiSince 1
 */

public int otherPrivateDirty;

/**
 * The proportional set size for everything else.
 * @apiSince 1
 */

public int otherPss;

/**
 * The shared dirty pages used by everything else.
 * @apiSince 1
 */

public int otherSharedDirty;
}

}

