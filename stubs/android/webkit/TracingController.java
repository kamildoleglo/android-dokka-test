/*
 * Copyright 2017 The Android Open Source Project
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


package android.webkit;

import java.util.concurrent.Executor;
import java.io.OutputStream;

/**
 * Manages tracing of WebViews. In particular provides functionality for the app
 * to enable/disable tracing of parts of code and to collect tracing data.
 * This is useful for profiling performance issues, debugging and memory usage
 * analysis in production and real life scenarios.
 * <p>
 * The resulting trace data is sent back as a byte sequence in json format. This
 * file can be loaded in "chrome://tracing" for further analysis.
 * <p>
 * Example usage:
 * <pre class="prettyprint">
 * TracingController tracingController = TracingController.getInstance();
 * tracingController.start(new TracingConfig.Builder()
 *                  .addCategories(TracingConfig.CATEGORIES_WEB_DEVELOPER).build());
 * ...
 * tracingController.stop(new FileOutputStream("trace.json"),
 *                        Executors.newSingleThreadExecutor());
 * </pre></p>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TracingController {

/**
 * @deprecated This class should not be constructed by applications, use {@link #getInstance}
 * instead to fetch the singleton instance.
 * @apiSince 28
 */

@Deprecated
public TracingController() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default TracingController instance. At present there is
 * only one TracingController instance for all WebView instances,
 * however this restriction may be relaxed in a future Android release.
 *
 * @return The default TracingController instance.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.webkit.TracingController getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Starts tracing all webviews. Depending on the trace mode in traceConfig
 * specifies how the trace events are recorded.
 *
 * For tracing modes {@link android.webkit.TracingConfig#RECORD_UNTIL_FULL TracingConfig#RECORD_UNTIL_FULL} and
 * {@link android.webkit.TracingConfig#RECORD_CONTINUOUSLY TracingConfig#RECORD_CONTINUOUSLY} the events are recorded
 * using an internal buffer and flushed to the outputStream when
 * {@link #stop(java.io.OutputStream,java.util.concurrent.Executor)} is called.
 *
 * @param tracingConfig Configuration options to use for tracing.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException If the system is already tracing.
 * @throws java.lang.IllegalArgumentException If the configuration is invalid (e.g.
 *         invalid category pattern or invalid tracing mode).
 * @apiSince 28
 */

public abstract void start(@androidx.annotation.NonNull android.webkit.TracingConfig tracingConfig);

/**
 * Stops tracing and flushes tracing data to the specified outputStream.
 *
 * The data is sent to the specified output stream in json format typically
 * in chunks by invoking {@link java.io.OutputStream#write(byte[])}. On completion
 * the {@link java.io.OutputStream#close()} method is called.
 *
 * @param outputStream The output stream the tracing data will be sent to. If null
 *                     the tracing data will be discarded.
 * This value may be {@code null}.
 * @param executor The {@link java.util.concurrent.Executor} on which the
 *        outputStream {@link java.io.OutputStream#write(byte[])} and
 *        {@link java.io.OutputStream#close()} methods will be invoked.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @return False if the WebView framework was not tracing at the time of the call,
 *         true otherwise.
 * @apiSince 28
 */

public abstract boolean stop(@androidx.annotation.Nullable java.io.OutputStream outputStream, @androidx.annotation.NonNull java.util.concurrent.Executor executor);

/**
 * Returns whether the WebView framework is tracing.
 *
 * @return True if tracing is enabled.
 * @apiSince 28
 */

public abstract boolean isTracing();
}

