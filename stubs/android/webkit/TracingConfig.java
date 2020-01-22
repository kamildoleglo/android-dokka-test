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

import java.util.Collection;

/**
 * Holds tracing configuration information and predefined settings.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TracingConfig {

TracingConfig() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmask of the predefined category sets of this configuration.
 *
 * @return Bitmask of predefined category sets.
 
 * Value is either <code>0</code> or a combination of {@link android.webkit.TracingConfig#CATEGORIES_NONE}, {@link android.webkit.TracingConfig#CATEGORIES_ALL}, {@link android.webkit.TracingConfig#CATEGORIES_ANDROID_WEBVIEW}, {@link android.webkit.TracingConfig#CATEGORIES_WEB_DEVELOPER}, {@link android.webkit.TracingConfig#CATEGORIES_INPUT_LATENCY}, {@link android.webkit.TracingConfig#CATEGORIES_RENDERING}, {@link android.webkit.TracingConfig#CATEGORIES_JAVASCRIPT_AND_RENDERING}, and {@link android.webkit.TracingConfig#CATEGORIES_FRAME_VIEWER}
 * @apiSince 28
 */

public int getPredefinedCategories() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of included custom category patterns for this configuration.
 *
 * @return Empty list if no custom category patterns are specified.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getCustomIncludedCategories() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tracing mode of this configuration.
 *
 * @return The tracing mode of this configuration.
 
 * Value is {@link android.webkit.TracingConfig#RECORD_UNTIL_FULL}, or {@link android.webkit.TracingConfig#RECORD_CONTINUOUSLY}
 * @apiSince 28
 */

public int getTracingMode() { throw new RuntimeException("Stub!"); }

/**
 * Predefined set of categories, includes all categories enabled by default in chromium.
 * Use with caution: this setting may produce large trace output.
 * @apiSince 28
 */

public static final int CATEGORIES_ALL = 1; // 0x1

/**
 * Predefined set of categories typically useful for analyzing WebViews.
 * Typically includes "android_webview" and "Java" categories.
 * @apiSince 28
 */

public static final int CATEGORIES_ANDROID_WEBVIEW = 2; // 0x2

/**
 * Predefined set of categories for studying difficult rendering performance problems.
 * Typically includes "blink", "compositor", "gpu", "renderer.scheduler", "v8" and
 * some other compositor categories which are disabled by default.
 * @apiSince 28
 */

public static final int CATEGORIES_FRAME_VIEWER = 64; // 0x40

/**
 * Predefined set of categories for analyzing input latency issues.
 * Typically includes "input", "renderer.scheduler" categories.
 * @apiSince 28
 */

public static final int CATEGORIES_INPUT_LATENCY = 8; // 0x8

/**
 * Predefined set of categories for analyzing javascript and rendering issues.
 * Typically includes "blink", "compositor", "gpu", "renderer.scheduler" and "v8" categories.
 * @apiSince 28
 */

public static final int CATEGORIES_JAVASCRIPT_AND_RENDERING = 32; // 0x20

/**
 * Indicates that there are no predefined categories.
 * @apiSince 28
 */

public static final int CATEGORIES_NONE = 0; // 0x0

/**
 * Predefined set of categories for analyzing rendering issues.
 * Typically includes "blink", "compositor" and "gpu" categories.
 * @apiSince 28
 */

public static final int CATEGORIES_RENDERING = 16; // 0x10

/**
 * Predefined set of categories typically useful for web developers.
 * Typically includes "blink", "compositor", "renderer.scheduler" and "v8" categories.
 * @apiSince 28
 */

public static final int CATEGORIES_WEB_DEVELOPER = 4; // 0x4

/**
 * Record trace events continuously using an internal ring buffer. Default tracing mode.
 *
 * Overwrites old events if they exceed buffer capacity. Uses less memory than the
 * {@link #RECORD_UNTIL_FULL} mode. Depending on the implementation typically allows
 * up to 64k events to be stored.
 * @apiSince 28
 */

public static final int RECORD_CONTINUOUSLY = 1; // 0x1

/**
 * Record trace events until the internal tracing buffer is full.
 *
 * Typically the buffer memory usage is larger than {@link #RECORD_CONTINUOUSLY}.
 * Depending on the implementation typically allows up to 256k events to be stored.
 * @apiSince 28
 */

public static final int RECORD_UNTIL_FULL = 0; // 0x0
/**
 * Builder used to create {@link android.webkit.TracingConfig TracingConfig} objects.
 * <p>
 * Examples:
 * <pre class="prettyprint">
 *   // Create a configuration with default options: {@link #CATEGORIES_NONE},
 *   // {@link #RECORD_CONTINUOUSLY}.
 *   <code>new TracingConfig.Builder().build()</code>
 *
 *   // Record trace events from the "web developer" predefined category sets.
 *   // Uses a ring buffer (the default {@link #RECORD_CONTINUOUSLY} mode) for
 *   // internal storage during tracing.
 *   <code>new TracingConfig.Builder().addCategories(CATEGORIES_WEB_DEVELOPER).build()</code>
 *
 *   // Record trace events from the "rendering" and "input latency" predefined
 *   // category sets.
 *   <code>new TracingConfig.Builder().addCategories(CATEGORIES_RENDERING,
 *                                     CATEGORIES_INPUT_LATENCY).build()</code>
 *
 *   // Record only the trace events from the "browser" category.
 *   <code>new TracingConfig.Builder().addCategories("browser").build()</code>
 *
 *   // Record only the trace events matching the "blink*" and "renderer*" patterns
 *   // (e.g. "blink.animations", "renderer_host" and "renderer.scheduler" categories).
 *   <code>new TracingConfig.Builder().addCategories("blink*","renderer*").build()</code>
 *
 *   // Record events from the "web developer" predefined category set and events from
 *   // the "disabled-by-default-v8.gc" category to understand where garbage collection
 *   // is being triggered. Uses a limited size buffer for internal storage during tracing.
 *   <code>new TracingConfig.Builder().addCategories(CATEGORIES_WEB_DEVELOPER)
 *                              .addCategories("disabled-by-default-v8.gc")
 *                              .setTracingMode(RECORD_UNTIL_FULL).build()</code>
 * </pre>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Default constructor for Builder.
 * @apiSince 28
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.webkit.TracingConfig TracingConfig} using the current settings.
 *
 * @return The {@link android.webkit.TracingConfig TracingConfig} with the current settings.
 * @apiSince 28
 */

public android.webkit.TracingConfig build() { throw new RuntimeException("Stub!"); }

/**
 * Adds predefined sets of categories to be included in the trace output.
 *
 * A predefined category set can be one of {@link #CATEGORIES_NONE},
 * {@link #CATEGORIES_ALL}, {@link #CATEGORIES_ANDROID_WEBVIEW},
 * {@link #CATEGORIES_WEB_DEVELOPER}, {@link #CATEGORIES_INPUT_LATENCY},
 * {@link #CATEGORIES_RENDERING}, {@link #CATEGORIES_JAVASCRIPT_AND_RENDERING} or
 * {@link #CATEGORIES_FRAME_VIEWER}.
 *
 * @param predefinedCategories A list or bitmask of predefined category sets.
 * Value is either <code>0</code> or a combination of {@link android.webkit.TracingConfig#CATEGORIES_NONE}, {@link android.webkit.TracingConfig#CATEGORIES_ALL}, {@link android.webkit.TracingConfig#CATEGORIES_ANDROID_WEBVIEW}, {@link android.webkit.TracingConfig#CATEGORIES_WEB_DEVELOPER}, {@link android.webkit.TracingConfig#CATEGORIES_INPUT_LATENCY}, {@link android.webkit.TracingConfig#CATEGORIES_RENDERING}, {@link android.webkit.TracingConfig#CATEGORIES_JAVASCRIPT_AND_RENDERING}, and {@link android.webkit.TracingConfig#CATEGORIES_FRAME_VIEWER}
 * @return The builder to facilitate chaining.
 * @apiSince 28
 */

public android.webkit.TracingConfig.Builder addCategories(int... predefinedCategories) { throw new RuntimeException("Stub!"); }

/**
 * Adds custom categories to be included in trace output.
 *
 * Note that the categories are defined by the currently-in-use version of WebView. They
 * live in chromium code and are not part of the Android API.
 * See <a href="https://www.chromium.org/developers/how-tos/trace-event-profiling-tool">
 * chromium documentation on tracing</a> for more details.
 *
 * @param categories A list of category patterns. A category pattern can contain wildcards,
 *        e.g. "blink*" or full category name e.g. "renderer.scheduler".
 * @return The builder to facilitate chaining.
 * @apiSince 28
 */

public android.webkit.TracingConfig.Builder addCategories(java.lang.String... categories) { throw new RuntimeException("Stub!"); }

/**
 * Adds custom categories to be included in trace output.
 *
 * Same as {@link #addCategories(java.lang.String...)} but allows to pass a Collection as a parameter.
 *
 * @param categories A list of category patterns.
 * @return The builder to facilitate chaining.
 * @apiSince 28
 */

public android.webkit.TracingConfig.Builder addCategories(java.util.Collection<java.lang.String> categories) { throw new RuntimeException("Stub!"); }

/**
 * Sets the tracing mode for this configuration.
 * When tracingMode is not set explicitly, the default is {@link #RECORD_CONTINUOUSLY}.
 *
 * @param tracingMode The tracing mode to use, one of {@link #RECORD_UNTIL_FULL} or
 *                    {@link #RECORD_CONTINUOUSLY}.
 * Value is {@link android.webkit.TracingConfig#RECORD_UNTIL_FULL}, or {@link android.webkit.TracingConfig#RECORD_CONTINUOUSLY}
 * @return The builder to facilitate chaining.
 * @apiSince 28
 */

public android.webkit.TracingConfig.Builder setTracingMode(int tracingMode) { throw new RuntimeException("Stub!"); }
}

}

