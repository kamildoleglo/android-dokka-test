/**
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package android.app.usage;


/**
 * Contains usage statistics for an app package for a specific
 * time range.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UsageStats implements android.os.Parcelable {

/** @apiSince 21 */

public UsageStats(android.app.usage.UsageStats stats) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Get the beginning of the time range this {@link android.app.usage.UsageStats} represents,
 * measured in milliseconds since the epoch.
 * <p/>
 * See {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 * @apiSince 21
 */

public long getFirstTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the end of the time range this {@link android.app.usage.UsageStats} represents,
 * measured in milliseconds since the epoch.
 * <p/>
 * See {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 * @apiSince 21
 */

public long getLastTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the last time this package's activity was used, measured in milliseconds since the epoch.
 * <p/>
 * See {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 * @apiSince 21
 */

public long getLastTimeUsed() { throw new RuntimeException("Stub!"); }

/**
 * Get the last time this package's activity is visible in the UI, measured in milliseconds
 * since the epoch.
 * @apiSince 29
 */

public long getLastTimeVisible() { throw new RuntimeException("Stub!"); }

/**
 * Get the total time this package spent in the foreground, measured in milliseconds.
 * @apiSince 21
 */

public long getTotalTimeInForeground() { throw new RuntimeException("Stub!"); }

/**
 * Get the total time this package's activity is visible in the UI, measured in milliseconds.
 * @apiSince 29
 */

public long getTotalTimeVisible() { throw new RuntimeException("Stub!"); }

/**
 * Get the last time this package's foreground service was used, measured in milliseconds since
 * the epoch.
 * <p/>
 * See {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 * @apiSince 29
 */

public long getLastTimeForegroundServiceUsed() { throw new RuntimeException("Stub!"); }

/**
 * Get the total time this package's foreground services are started, measured in milliseconds.
 * @apiSince 29
 */

public long getTotalTimeForegroundServiceUsed() { throw new RuntimeException("Stub!"); }

/**
 * Add the statistics from the right {@link android.app.usage.UsageStats UsageStats} to the left. The package name for
 * both {@link android.app.usage.UsageStats UsageStats} objects must be the same.
 * @param right The {@link android.app.usage.UsageStats UsageStats} object to merge into this one.
 * @throws java.lang.IllegalArgumentException if the package names of the two
 *         {@link android.app.usage.UsageStats UsageStats} objects are different.
 * @apiSince 21
 */

public void add(android.app.usage.UsageStats right) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.usage.UsageStats> CREATOR;
static { CREATOR = null; }
}

