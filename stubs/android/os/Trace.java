/*
 * Copyright (C) 2012 The Android Open Source Project
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
 * Writes trace events to the system trace buffer.  These trace events can be
 * collected and visualized using the Systrace tool.
 *
 * <p>This tracing mechanism is independent of the method tracing mechanism
 * offered by {@link android.os.Debug#startMethodTracing Debug#startMethodTracing}.  In particular, it enables
 * tracing of events that occur across multiple processes.
 * <p>For information about using the Systrace tool, read <a
 * href="{@docRoot}tools/debugging/systrace.html">Analyzing Display and Performance
 * with Systrace</a>.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Trace {

private Trace() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether or not tracing is currently enabled. This is useful to avoid intermediate
 * string creation for trace sections that require formatting. It is not necessary
 * to guard all Trace method calls as they internally already check this. However it is
 * recommended to use this to prevent creating any temporary objects that would then be
 * passed to those methods to reduce runtime cost when tracing isn't enabled.
 *
 * @return true if tracing is currently enabled, false otherwise
 * @apiSince 29
 */

public static boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Writes a trace message to indicate that a given section of code has begun. This call must
 * be followed by a corresponding call to {@link #endSection()} on the same thread.
 *
 * <p class="note"> At this time the vertical bar character '|', newline character '\n', and
 * null character '\0' are used internally by the tracing mechanism.  If sectionName contains
 * these characters they will be replaced with a space character in the trace.
 *
 * @param sectionName The name of the code section to appear in the trace.  This may be at
 * most 127 Unicode code units long.
 
 * This value must never be {@code null}.
 * @apiSince 18
 */

public static void beginSection(@androidx.annotation.NonNull java.lang.String sectionName) { throw new RuntimeException("Stub!"); }

/**
 * Writes a trace message to indicate that a given section of code has ended. This call must
 * be preceeded by a corresponding call to {@link #beginSection(java.lang.String)}. Calling this method
 * will mark the end of the most recently begun section of code, so care must be taken to
 * ensure that beginSection / endSection pairs are properly nested and called from the same
 * thread.
 * @apiSince 18
 */

public static void endSection() { throw new RuntimeException("Stub!"); }

/**
 * Writes a trace message to indicate that a given section of code has
 * begun. Must be followed by a call to {@link #endAsyncSection(java.lang.String,int)} with the same
 * methodName and cookie. Unlike {@link #beginSection(java.lang.String)} and {@link #endSection()},
 * asynchronous events do not need to be nested. The name and cookie used to
 * begin an event must be used to end it.
 *
 * @param methodName The method name to appear in the trace.
 * This value must never be {@code null}.
 * @param cookie Unique identifier for distinguishing simultaneous events
 * @apiSince 29
 */

public static void beginAsyncSection(@androidx.annotation.NonNull java.lang.String methodName, int cookie) { throw new RuntimeException("Stub!"); }

/**
 * Writes a trace message to indicate that the current method has ended.
 * Must be called exactly once for each call to {@link #beginAsyncSection(java.lang.String,int)}
 * using the same name and cookie.
 *
 * @param methodName The method name to appear in the trace.
 * This value must never be {@code null}.
 * @param cookie Unique identifier for distinguishing simultaneous events
 * @apiSince 29
 */

public static void endAsyncSection(@androidx.annotation.NonNull java.lang.String methodName, int cookie) { throw new RuntimeException("Stub!"); }

/**
 * Writes trace message to indicate the value of a given counter.
 *
 * @param counterName The counter name to appear in the trace.
 * This value must never be {@code null}.
 * @param counterValue The counter value.
 * @apiSince 29
 */

public static void setCounter(@androidx.annotation.NonNull java.lang.String counterName, long counterValue) { throw new RuntimeException("Stub!"); }
}

