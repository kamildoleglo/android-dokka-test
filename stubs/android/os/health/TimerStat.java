/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.os.health;

import android.os.Parcel;

/**
 * A TimerStat object stores a count and a time.
 *
 * @more
 * When possible, the other APIs in this package avoid requiring a TimerStat
 * object to be constructed, even internally, but the getTimers method on
 * {@link android.os.health.HealthStats} does require TimerStat objects.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TimerStat implements android.os.Parcelable {

/**
 * Construct an empty TimerStat object with the count and time set to 0.
 * @apiSince 24
 */

public TimerStat() { throw new RuntimeException("Stub!"); }

/**
 * Construct a TimerStat object with the supplied count and time fields.
 *
 * @param count The count
 * @param time The time
 * @apiSince 24
 */

public TimerStat(int count, long time) { throw new RuntimeException("Stub!"); }

/**
 * Construct a TimerStat object reading the values from a {@link android.os.Parcel Parcel}
 * object.
 * @apiSince 24
 */

public TimerStat(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @apiSince 24
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Write this TimerStat object to a parcel.
 * @apiSince 24
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set the count for this timer.
 * @apiSince 24
 */

public void setCount(int count) { throw new RuntimeException("Stub!"); }

/**
 * Get the count for this timer.
 * @apiSince 24
 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * Set the time for this timer in milliseconds.
 * @apiSince 24
 */

public void setTime(long time) { throw new RuntimeException("Stub!"); }

/**
 * Get the time for this timer in milliseconds.
 * @apiSince 24
 */

public long getTime() { throw new RuntimeException("Stub!"); }

/**
 * The CREATOR instance for use by aidl Binder interfaces.
 * @apiSince 24
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.health.TimerStat> CREATOR;
static { CREATOR = null; }
}

