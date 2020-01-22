/*
 * Copyright (C) 2017 The Android Open Source Project
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

import android.Manifest;

/**
 * StatsLog provides an API for developers to send events to statsd. The events can be used to
 * define custom metrics inside statsd.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StatsLog {

private StatsLog() { throw new RuntimeException("Stub!"); }

/**
 * Logs a start event.
 *
 * @param label developer-chosen label.
 * @return True if the log request was sent to statsd.
 * @apiSince 28
 */

public static boolean logStart(int label) { throw new RuntimeException("Stub!"); }

/**
 * Logs a stop event.
 *
 * @param label developer-chosen label.
 * @return True if the log request was sent to statsd.
 * @apiSince 28
 */

public static boolean logStop(int label) { throw new RuntimeException("Stub!"); }

/**
 * Logs an event that does not represent a start or stop boundary.
 *
 * @param label developer-chosen label.
 * @return True if the log request was sent to statsd.
 * @apiSince 28
 */

public static boolean logEvent(int label) { throw new RuntimeException("Stub!"); }

/**
 * Logs an event for binary push for module updates.
 *
 * <br>
 * Requires {@link android.Manifest.permission#DUMP} and {@link android.Manifest.permission#PACKAGE_USAGE_STATS}
 * @param trainName        name of install train.
 * This value must never be {@code null}.
 * @param trainVersionCode version code of the train.
 * @param options          optional flags about this install.
 *                         The last 3 bits indicate options:
 *                             0x01: FLAG_REQUIRE_STAGING
 *                             0x02: FLAG_ROLLBACK_ENABLED
 *                             0x04: FLAG_REQUIRE_LOW_LATENCY_MONITOR
 * @param state            current install state. Defined as State enums in
 *                         BinaryPushStateChanged atom in
 *                         frameworks/base/cmds/statsd/src/atoms.proto
 * @param experimentIds    experiment ids.
 * This value must never be {@code null}.
 * @return True if the log request was sent to statsd.
 * @apiSince 29
 */

public static boolean logBinaryPushStateChanged(@androidx.annotation.NonNull java.lang.String trainName, long trainVersionCode, int options, int state, @androidx.annotation.NonNull long[] experimentIds) { throw new RuntimeException("Stub!"); }
}

