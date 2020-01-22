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

import java.io.IOException;

/**
 * Access to the system diagnostic event record.  System diagnostic events are
 * used to record certain system-level events (such as garbage collection,
 * activity manager state, system watchdogs, and other low level activity),
 * which may be automatically collected and analyzed during system development.
 *
 * <p>This is <b>not</b> the main "logcat" debugging log ({@link android.util.Log})!
 * These diagnostic events are for system integrators, not application authors.
 *
 * <p>Events use integer tag codes corresponding to /system/etc/event-log-tags.
 * They carry a payload of one or more int, long, or String values.  The
 * event-log-tags file defines the payload contents for each type code.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EventLog {

EventLog() { throw new RuntimeException("Stub!"); }

/**
 * Record an event log message.
 * @param tag The event type tag code
 * @param value A value to log
 * @return The number of bytes written
 * @apiSince 8
 */

public static native int writeEvent(int tag, int value);

/**
 * Record an event log message.
 * @param tag The event type tag code
 * @param value A value to log
 * @return The number of bytes written
 * @apiSince 8
 */

public static native int writeEvent(int tag, long value);

/**
 * Record an event log message.
 * @param tag The event type tag code
 * @param value A value to log
 * @return The number of bytes written
 * @apiSince 23
 */

public static native int writeEvent(int tag, float value);

/**
 * Record an event log message.
 * @param tag The event type tag code
 * @param str A value to log
 * @return The number of bytes written
 * @apiSince 8
 */

public static native int writeEvent(int tag, java.lang.String str);

/**
 * Record an event log message.
 * @param tag The event type tag code
 * @param list A list of values to log
 * @return The number of bytes written
 * @apiSince 8
 */

public static native int writeEvent(int tag, java.lang.Object... list);

/**
 * Read events from the log, filtered by type.
 * @param tags to search for
 * @param output container to add events into
 * @throws java.io.IOException if something goes wrong reading events
 * @apiSince 8
 */

public static native void readEvents(int[] tags, java.util.Collection<android.util.EventLog.Event> output) throws java.io.IOException;

/**
 * Get the name associated with an event type tag code.
 * @param tag code to look up
 * @return the name of the tag, or null if no tag has that number
 * @apiSince 8
 */

public static java.lang.String getTagName(int tag) { throw new RuntimeException("Stub!"); }

/**
 * Get the event type tag code associated with an event name.
 * @param name of event to look up
 * @return the tag code, or -1 if no tag has that name
 * @apiSince 8
 */

public static int getTagCode(java.lang.String name) { throw new RuntimeException("Stub!"); }
/**
 * A previously logged event read from the logs. Instances are thread safe.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Event {

Event() { throw new RuntimeException("Stub!"); }

/**
 * @return the process ID which wrote the log entry
 * @apiSince 8
 */

public int getProcessId() { throw new RuntimeException("Stub!"); }

/**
 * @return the thread ID which wrote the log entry
 * @apiSince 8
 */

public int getThreadId() { throw new RuntimeException("Stub!"); }

/**
 * @return the wall clock time when the entry was written
 * @apiSince 8
 */

public long getTimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * @return the type tag code of the entry
 * @apiSince 8
 */

public int getTag() { throw new RuntimeException("Stub!"); }

/**
 * @return one of Integer, Long, Float, String, null, or Object[] of same.
 * @apiSince 8
 */

public synchronized java.lang.Object getData() { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

}

