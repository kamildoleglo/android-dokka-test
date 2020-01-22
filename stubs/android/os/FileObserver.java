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

import java.io.File;

/**
 * Monitors files (using <a href="http://en.wikipedia.org/wiki/Inotify">inotify</a>)
 * to fire an event after files are accessed or changed by by any process on
 * the device (including this one).  FileObserver is an abstract class;
 * subclasses must implement the event handler {@link #onEvent(int,java.lang.String)}.
 *
 * <p>Each FileObserver instance can monitor multiple files or directories.
 * If a directory is monitored, events will be triggered for all files and
 * subdirectories inside the monitored directory.</p>
 *
 * <p>An event mask is used to specify which changes or actions to report.
 * Event type constants are used to describe the possible changes in the
 * event mask as well as what actually happened in event callbacks.</p>
 *
 * <p class="caution"><b>Warning</b>: If a FileObserver is garbage collected, it
 * will stop sending events.  To ensure you keep receiving events, you must
 * keep a reference to the FileObserver instance from some other live object.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class FileObserver {

/**
 * Equivalent to FileObserver(path, FileObserver.ALL_EVENTS).
 *
 * @deprecated use {@link #FileObserver(java.io.File)} instead.
 * @apiSince 1
 */

@Deprecated
public FileObserver(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to FileObserver(file, FileObserver.ALL_EVENTS).
 
 * @param file This value must never be {@code null}.
 * @apiSince 29
 */

public FileObserver(@androidx.annotation.NonNull java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to FileObserver(paths, FileObserver.ALL_EVENTS).
 *
 * @param files The files or directories to monitor
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public FileObserver(@androidx.annotation.NonNull java.util.List<java.io.File> files) { throw new RuntimeException("Stub!"); }

/**
 * Create a new file observer for a certain file or directory.
 * Monitoring does not start on creation!  You must call
 * {@link #startWatching()} before you will receive events.
 *
 * @param path The file or directory to monitor
 * @param mask The event or events (added together) to watch for
 *
 * Value is either <code>0</code> or a combination of {@link android.os.FileObserver#ACCESS}, {@link android.os.FileObserver#MODIFY}, {@link android.os.FileObserver#ATTRIB}, {@link android.os.FileObserver#CLOSE_WRITE}, {@link android.os.FileObserver#CLOSE_NOWRITE}, {@link android.os.FileObserver#OPEN}, {@link android.os.FileObserver#MOVED_FROM}, {@link android.os.FileObserver#MOVED_TO}, {@link android.os.FileObserver#CREATE}, {@link android.os.FileObserver#DELETE}, {@link android.os.FileObserver#DELETE_SELF}, and {@link android.os.FileObserver#MOVE_SELF}
 * @deprecated use {@link #FileObserver(java.io.File,int)} instead.
 * @apiSince 1
 */

@Deprecated
public FileObserver(java.lang.String path, int mask) { throw new RuntimeException("Stub!"); }

/**
 * Create a new file observer for a certain file or directory.
 * Monitoring does not start on creation!  You must call
 * {@link #startWatching()} before you will receive events.
 *
 * @param file The file or directory to monitor
 * This value must never be {@code null}.
 * @param mask The event or events (added together) to watch for
 
 * Value is either <code>0</code> or a combination of {@link android.os.FileObserver#ACCESS}, {@link android.os.FileObserver#MODIFY}, {@link android.os.FileObserver#ATTRIB}, {@link android.os.FileObserver#CLOSE_WRITE}, {@link android.os.FileObserver#CLOSE_NOWRITE}, {@link android.os.FileObserver#OPEN}, {@link android.os.FileObserver#MOVED_FROM}, {@link android.os.FileObserver#MOVED_TO}, {@link android.os.FileObserver#CREATE}, {@link android.os.FileObserver#DELETE}, {@link android.os.FileObserver#DELETE_SELF}, and {@link android.os.FileObserver#MOVE_SELF}
 * @apiSince 29
 */

public FileObserver(@androidx.annotation.NonNull java.io.File file, int mask) { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link #FileObserver(java.io.File,int)} that allows callers to monitor
 * multiple files or directories.
 *
 * @param files The files or directories to monitor
 * This value must never be {@code null}.
 * @param mask The event or events (added together) to watch for
 
 * Value is either <code>0</code> or a combination of {@link android.os.FileObserver#ACCESS}, {@link android.os.FileObserver#MODIFY}, {@link android.os.FileObserver#ATTRIB}, {@link android.os.FileObserver#CLOSE_WRITE}, {@link android.os.FileObserver#CLOSE_NOWRITE}, {@link android.os.FileObserver#OPEN}, {@link android.os.FileObserver#MOVED_FROM}, {@link android.os.FileObserver#MOVED_TO}, {@link android.os.FileObserver#CREATE}, {@link android.os.FileObserver#DELETE}, {@link android.os.FileObserver#DELETE_SELF}, and {@link android.os.FileObserver#MOVE_SELF}
 * @apiSince 29
 */

public FileObserver(@androidx.annotation.NonNull java.util.List<java.io.File> files, int mask) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Start watching for events.  The monitored file or directory must exist at
 * this time, or else no events will be reported (even if it appears later).
 * If monitoring is already started, this call has no effect.
 * @apiSince 1
 */

public void startWatching() { throw new RuntimeException("Stub!"); }

/**
 * Stop watching for events.  Some events may be in process, so events
 * may continue to be reported even after this method completes.  If
 * monitoring is already stopped, this call has no effect.
 * @apiSince 1
 */

public void stopWatching() { throw new RuntimeException("Stub!"); }

/**
 * The event handler, which must be implemented by subclasses.
 *
 * <p class="note">This method is invoked on a special FileObserver thread.
 * It runs independently of any threads, so take care to use appropriate
 * synchronization!  Consider using {@link android.os.Handler#post(java.lang.Runnable) Handler#post(Runnable)} to shift
 * event handling work to the main thread to avoid concurrency problems.</p>
 *
 * <p>Event handlers must not throw exceptions.</p>
 *
 * @param event The type of event which happened
 * @param path The path, relative to the main monitored file or directory,
 *     of the file or directory which triggered the event.  This value can
 *     be {@code null} for certain events, such as {@link #MOVE_SELF}.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public abstract void onEvent(int event, @androidx.annotation.Nullable java.lang.String path);

/**
 * Event type: Data was read from a file
 * @apiSince 1
 */

public static final int ACCESS = 1; // 0x1

/**
 * Event mask: All valid event types, combined
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.os.FileObserver#ACCESS}, {@link android.os.FileObserver#MODIFY}, {@link android.os.FileObserver#ATTRIB}, {@link android.os.FileObserver#CLOSE_WRITE}, {@link android.os.FileObserver#CLOSE_NOWRITE}, {@link android.os.FileObserver#OPEN}, {@link android.os.FileObserver#MOVED_FROM}, {@link android.os.FileObserver#MOVED_TO}, {@link android.os.FileObserver#CREATE}, {@link android.os.FileObserver#DELETE}, {@link android.os.FileObserver#DELETE_SELF}, and {@link android.os.FileObserver#MOVE_SELF}
 * @apiSince 1
 */

public static final int ALL_EVENTS = 4095; // 0xfff

/**
 * Event type: Metadata (permissions, owner, timestamp) was changed explicitly
 * @apiSince 1
 */

public static final int ATTRIB = 4; // 0x4

/**
 * Event type: Someone had a file or directory open read-only, and closed it
 * @apiSince 1
 */

public static final int CLOSE_NOWRITE = 16; // 0x10

/**
 * Event type: Someone had a file or directory open for writing, and closed it
 * @apiSince 1
 */

public static final int CLOSE_WRITE = 8; // 0x8

/**
 * Event type: A new file or subdirectory was created under the monitored directory
 * @apiSince 1
 */

public static final int CREATE = 256; // 0x100

/**
 * Event type: A file was deleted from the monitored directory
 * @apiSince 1
 */

public static final int DELETE = 512; // 0x200

/**
 * Event type: The monitored file or directory was deleted; monitoring effectively stops
 * @apiSince 1
 */

public static final int DELETE_SELF = 1024; // 0x400

/**
 * Event type: Data was written to a file
 * @apiSince 1
 */

public static final int MODIFY = 2; // 0x2

/**
 * Event type: A file or subdirectory was moved from the monitored directory
 * @apiSince 1
 */

public static final int MOVED_FROM = 64; // 0x40

/**
 * Event type: A file or subdirectory was moved to the monitored directory
 * @apiSince 1
 */

public static final int MOVED_TO = 128; // 0x80

/**
 * Event type: The monitored file or directory was moved; monitoring continues
 * @apiSince 1
 */

public static final int MOVE_SELF = 2048; // 0x800

/**
 * Event type: A file or directory was opened
 * @apiSince 1
 */

public static final int OPEN = 32; // 0x20
}

