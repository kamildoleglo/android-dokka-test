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

import java.time.DateTimeException;
import java.time.Clock;

/**
 * Core timekeeping facilities.
 *
 * <p> Three different clocks are available, and they should not be confused:
 *
 * <ul>
 *     <li> <p> {@link java.lang.System#currentTimeMillis System#currentTimeMillis}
 *     is the standard "wall" clock (time and date) expressing milliseconds
 *     since the epoch.  The wall clock can be set by the user or the phone
 *     network (see {@link #setCurrentTimeMillis}), so the time may jump
 *     backwards or forwards unpredictably.  This clock should only be used
 *     when correspondence with real-world dates and times is important, such
 *     as in a calendar or alarm clock application.  Interval or elapsed
 *     time measurements should use a different clock.  If you are using
 *     System.currentTimeMillis(), consider listening to the
 *     {@link android.content.Intent#ACTION_TIME_TICK ACTION_TIME_TICK},
 *     {@link android.content.Intent#ACTION_TIME_CHANGED ACTION_TIME_CHANGED}
 *     and {@link android.content.Intent#ACTION_TIMEZONE_CHANGED
 *     ACTION_TIMEZONE_CHANGED} {@link android.content.Intent Intent}
 *     broadcasts to find out when the time changes.
 *
 *     <li> <p> {@link #uptimeMillis} is counted in milliseconds since the
 *     system was booted.  This clock stops when the system enters deep
 *     sleep (CPU off, display dark, device waiting for external input),
 *     but is not affected by clock scaling, idle, or other power saving
 *     mechanisms.  This is the basis for most interval timing
 *     such as {@link java.lang.Thread#sleep(long) Thread#sleep(long)},
 *     {@link java.lang.Object#wait(long) Object#wait(long)}, and
 *     {@link java.lang.System#nanoTime System#nanoTime}.  This clock is guaranteed
 *     to be monotonic, and is suitable for interval timing when the
 *     interval does not span device sleep.  Most methods that accept a
 *     timestamp value currently expect the {@link #uptimeMillis} clock.
 *
 *     <li> <p> {@link #elapsedRealtime} and {@link #elapsedRealtimeNanos}
 *     return the time since the system was booted, and include deep sleep.
 *     This clock is guaranteed to be monotonic, and continues to tick even
 *     when the CPU is in power saving modes, so is the recommend basis
 *     for general purpose interval timing.
 *
 * </ul>
 *
 * There are several mechanisms for controlling the timing of events:
 *
 * <ul>
 *     <li> <p> Standard functions like {@link java.lang.Thread#sleep(long) Thread#sleep(long)} and {@link java.lang.Object#wait(long) Object#wait(long)}
 *     are always available.  These functions use the {@link #uptimeMillis}
 *     clock; if the device enters sleep, the remainder of the time will be
 *     postponed until the device wakes up.  These synchronous functions may
 *     be interrupted with {@link java.lang.Thread#interrupt Thread#interrupt}, and
 *     you must handle {@link java.lang.InterruptedException InterruptedException}.
 *
 *     <li> <p> {@link #sleep SystemClock.sleep(millis)} is a utility function
 *     very similar to {@link java.lang.Thread#sleep(long) Thread#sleep(long)}, but it
 *     ignores {@link java.lang.InterruptedException InterruptedException}.  Use this function for delays if
 *     you do not use {@link java.lang.Thread#interrupt Thread#interrupt}, as it will
 *     preserve the interrupted state of the thread.
 *
 *     <li> <p> The {@link android.os.Handler} class can schedule asynchronous
 *     callbacks at an absolute or relative time.  Handler objects also use the
 *     {@link #uptimeMillis} clock, and require an {@link android.os.Looper
 *     event loop} (normally present in any GUI application).
 *
 *     <li> <p> The {@link android.app.AlarmManager} can trigger one-time or
 *     recurring events which occur even when the device is in deep sleep
 *     or your application is not running.  Events may be scheduled with your
 *     choice of {@link java.lang.System#currentTimeMillis} (RTC) or
 *     {@link #elapsedRealtime} (ELAPSED_REALTIME), and cause an
 *     {@link android.content.Intent} broadcast when they occur.
 * </ul>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SystemClock {

private SystemClock() { throw new RuntimeException("Stub!"); }

/**
 * Waits a given number of milliseconds (of uptimeMillis) before returning.
 * Similar to {@link java.lang.Thread#sleep(long)}, but does not throw
 * {@link java.lang.InterruptedException InterruptedException}; {@link java.lang.Thread#interrupt() Thread#interrupt()} events are
 * deferred until the next interruptible operation.  Does not return until
 * at least the specified number of milliseconds has elapsed.
 *
 * @param ms to sleep before returning, in milliseconds of uptime.
 * @apiSince 1
 */

public static void sleep(long ms) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current wall time, in milliseconds.  Requires the calling
 * process to have appropriate permissions.
 *
 * @return if the clock was successfully set to the specified time.
 * @apiSince 1
 */

public static boolean setCurrentTimeMillis(long millis) { throw new RuntimeException("Stub!"); }

/**
 * Returns milliseconds since boot, not counting time spent in deep sleep.
 *
 * @return milliseconds of non-sleep uptime since boot.
 * @apiSince 1
 */

public static native long uptimeMillis();

/**
 * Returns milliseconds since boot, including time spent in sleep.
 *
 * @return elapsed milliseconds since boot.
 * @apiSince 1
 */

public static native long elapsedRealtime();

/**
 * Returns nanoseconds since boot, including time spent in sleep.
 *
 * @return elapsed nanoseconds since boot.
 * @apiSince 17
 */

public static native long elapsedRealtimeNanos();

/**
 * Returns milliseconds running in the current thread.
 *
 * @return elapsed milliseconds in the thread
 * @apiSince 1
 */

public static native long currentThreadTimeMillis();

/**
 * Returns a {@link java.time.Clock Clock} that starts at January 1, 1970 00:00:00.0 UTC,
 * synchronized using the device's location provider.
 *
 * @throws java.time.DateTimeException when the location provider has not had a location fix since boot.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static java.time.Clock currentGnssTimeClock() { throw new RuntimeException("Stub!"); }
}

