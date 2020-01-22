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


/**
 * Tools for managing OS processes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Process {

public Process() { throw new RuntimeException("Stub!"); }

/**
 * Returns elapsed milliseconds of the time this process has run.
 * @return  Returns the number of milliseconds this process has return.
 * @apiSince 1
 */

public static final native long getElapsedCpuTime();

/**
 * Return the {@link android.os.SystemClock#elapsedRealtime() SystemClock#elapsedRealtime()} at which this process was started.
 * @apiSince 24
 */

public static final long getStartElapsedRealtime() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()} at which this process was started.
 * @apiSince 24
 */

public static final long getStartUptimeMillis() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current process is a 64-bit runtime.
 * @apiSince 23
 */

public static final boolean is64Bit() { throw new RuntimeException("Stub!"); }

/**
 * Returns the identifier of this process, which can be used with
 * {@link #killProcess} and {@link #sendSignal}.
 * @apiSince 1
 */

public static final int myPid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the identifier of the calling thread, which be used with
 * {@link #setThreadPriority(int,int)}.
 * @apiSince 1
 */

public static final int myTid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the identifier of this process's uid.  This is the kernel uid
 * that the process is running under, which is the identity of its
 * app-specific sandbox.  It is different from {@link #myUserHandle} in that
 * a uid identifies a specific app sandbox in a specific user.
 * @apiSince 2
 */

public static final int myUid() { throw new RuntimeException("Stub!"); }

/**
 * Returns this process's user handle.  This is the
 * user the process is running under.  It is distinct from
 * {@link #myUid()} in that a particular user will have multiple
 * distinct apps running under it each with their own uid.
 * @apiSince 17
 */

public static android.os.UserHandle myUserHandle() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the given uid belongs to an application.
 * @param uid A kernel uid.
 * @return Whether the uid corresponds to an application sandbox running in
 *     a specific user.
 * @apiSince 24
 */

public static boolean isApplicationUid(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the current process is in an isolated sandbox.
 * @apiSince 28
 */

public static final boolean isIsolated() { throw new RuntimeException("Stub!"); }

/**
 * Returns the UID assigned to a particular user name, or -1 if there is
 * none.  If the given string consists of only numbers, it is converted
 * directly to a uid.
 * @apiSince 1
 */

public static final native int getUidForName(java.lang.String name);

/**
 * Returns the GID assigned to a particular user name, or -1 if there is
 * none.  If the given string consists of only numbers, it is converted
 * directly to a gid.
 * @apiSince 1
 */

public static final native int getGidForName(java.lang.String name);

/**
 * Set the priority of a thread, based on Linux priorities.
 *
 * @param tid The identifier of the thread/process to change.
 * @param priority A Linux priority level, from -20 for highest scheduling
 * priority to 19 for lowest scheduling priority.
 *
 * @throws java.lang.IllegalArgumentException Throws IllegalArgumentException if
 * <var>tid</var> does not exist.
 * @throws java.lang.SecurityException Throws SecurityException if your process does
 * not have permission to modify the given thread, or to use the given
 * priority.
 * @apiSince 1
 */

public static final native void setThreadPriority(int tid, int priority) throws java.lang.IllegalArgumentException, java.lang.SecurityException;

/**
 * On some devices, the foreground process may have one or more CPU
 * cores exclusively reserved for it. This method can be used to
 * retrieve which cores that are (if any), so the calling process
 * can then use sched_setaffinity() to lock a thread to these cores.
 * Note that the calling process must currently be running in the
 * foreground for this method to return any cores.
 *
 * The CPU core(s) exclusively reserved for the foreground process will
 * stay reserved for as long as the process stays in the foreground.
 *
 * As soon as a process leaves the foreground, those CPU cores will
 * no longer be reserved for it, and will most likely be reserved for
 * the new foreground process. It's not necessary to change the affinity
 * of your process when it leaves the foreground (if you had previously
 * set it to use a reserved core); the OS will automatically take care
 * of resetting the affinity at that point.
 *
 * @return an array of integers, indicating the CPU cores exclusively
 * reserved for this process. The array will have length zero if no
 * CPU cores are exclusively reserved for this process at this point
 * in time.
 * @apiSince 24
 */

public static final native int[] getExclusiveCores();

/**
 * Set the priority of the calling thread, based on Linux priorities.  See
 * {@link #setThreadPriority(int,int)} for more information.
 *
 * @param priority A Linux priority level, from -20 for highest scheduling
 * priority to 19 for lowest scheduling priority.
 *
 * @throws java.lang.IllegalArgumentException Throws IllegalArgumentException if
 * <var>tid</var> does not exist.
 * @throws java.lang.SecurityException Throws SecurityException if your process does
 * not have permission to modify the given thread, or to use the given
 * priority.
 *
 * @see #setThreadPriority(int, int)
 * @apiSince 1
 */

public static final native void setThreadPriority(int priority) throws java.lang.IllegalArgumentException, java.lang.SecurityException;

/**
 * Return the current priority of a thread, based on Linux priorities.
 *
 * @param tid The identifier of the thread/process. If tid equals zero, the priority of the
 * calling process/thread will be returned.
 *
 * @return Returns the current priority, as a Linux priority level,
 * from -20 for highest scheduling priority to 19 for lowest scheduling
 * priority.
 *
 * @throws java.lang.IllegalArgumentException Throws IllegalArgumentException if
 * <var>tid</var> does not exist.
 * @apiSince 1
 */

public static final native int getThreadPriority(int tid) throws java.lang.IllegalArgumentException;

/**
 * Determine whether the current environment supports multiple processes.
 *
 * @return Returns true if the system can run in multiple processes, else
 * false if everything is running in a single process.
 *
 * @deprecated This method always returns true.  Do not use.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static final boolean supportsProcesses() { throw new RuntimeException("Stub!"); }

/**
 * Kill the process with the given PID.
 * Note that, though this API allows us to request to
 * kill any process based on its PID, the kernel will
 * still impose standard restrictions on which PIDs you
 * are actually able to kill.  Typically this means only
 * the process running the caller's packages/application
 * and any additional processes created by that app; packages
 * sharing a common UID will also be able to kill each
 * other's processes.
 * @apiSince 1
 */

public static final void killProcess(int pid) { throw new RuntimeException("Stub!"); }

/**
 * Send a signal to the given process.
 *
 * @param pid The pid of the target process.
 * @param signal The signal to send.
 * @apiSince 1
 */

public static final native void sendSignal(int pid, int signal);

/**
 * Defines the UID/GID for the Bluetooth service process.
 * @apiSince 29
 */

public static final int BLUETOOTH_UID = 1002; // 0x3ea

/**
 * Defines the start of a range of UIDs (and GIDs), going from this
 * number to {@link #LAST_APPLICATION_UID} that are reserved for assigning
 * to applications.
 * @apiSince 1
 */

public static final int FIRST_APPLICATION_UID = 10000; // 0x2710

/**
 * An invalid UID value.
 * @apiSince 29
 */

public static final int INVALID_UID = -1; // 0xffffffff

/**
 * Last of application-specific UIDs starting at
 * {@link #FIRST_APPLICATION_UID}.
 * @apiSince 1
 */

public static final int LAST_APPLICATION_UID = 19999; // 0x4e1f

/**
 * Defines the UID/GID under which the telephony code runs.
 * @apiSince 1
 */

public static final int PHONE_UID = 1001; // 0x3e9

/**
 * Defines the root UID.
 * @apiSince 29
 */

public static final int ROOT_UID = 0; // 0x0

/**
 * Defines the UID/GID for the user shell.
 * @apiSince 29
 */

public static final int SHELL_UID = 2000; // 0x7d0

/** @apiSince 1 */

public static final int SIGNAL_KILL = 9; // 0x9

/** @apiSince 1 */

public static final int SIGNAL_QUIT = 3; // 0x3

/** @apiSince 1 */

public static final int SIGNAL_USR1 = 10; // 0xa

/**
 * Defines the UID/GID under which system code runs.
 * @apiSince 1
 */

public static final int SYSTEM_UID = 1000; // 0x3e8

/**
 * Standard priority of audio threads.  Applications can not normally
 * change to this priority.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_AUDIO = -16; // 0xfffffff0

/**
 * Standard priority background threads.  This gives your thread a slightly
 * lower than normal priority, so that it will have less chance of impacting
 * the responsiveness of the user interface.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_BACKGROUND = 10; // 0xa

/**
 * Standard priority of application threads.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_DEFAULT = 0; // 0x0

/**
 * Standard priority of system display threads, involved in updating
 * the user interface.  Applications can not
 * normally change to this priority.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_DISPLAY = -4; // 0xfffffffc

/**
 * Standard priority of threads that are currently running a user interface
 * that the user is interacting with.  Applications can not normally
 * change to this priority; the system will automatically adjust your
 * application threads as the user moves through the UI.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_FOREGROUND = -2; // 0xfffffffe

/**
 * Minimum increment to make a priority less favorable.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_LESS_FAVORABLE = 1; // 0x1

/**
 * Lowest available thread priority.  Only for those who really, really
 * don't want to run if anything else is happening.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_LOWEST = 19; // 0x13

/**
 * Minimum increment to make a priority more favorable.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_MORE_FAVORABLE = -1; // 0xffffffff

/**
 * Standard priority of the most important audio threads.
 * Applications can not normally change to this priority.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_URGENT_AUDIO = -19; // 0xffffffed

/**
 * Standard priority of the most important display threads, for compositing
 * the screen and retrieving input events.  Applications can not normally
 * change to this priority.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 1
 */

public static final int THREAD_PRIORITY_URGENT_DISPLAY = -8; // 0xfffffff8

/**
 * Standard priority of video threads.  Applications can not normally
 * change to this priority.
 * Use with {@link #setThreadPriority(int)} and
 * {@link #setThreadPriority(int,int)}, <b>not</b> with the normal
 * {@link java.lang.Thread} class.
 * @apiSince 28
 */

public static final int THREAD_PRIORITY_VIDEO = -10; // 0xfffffff6
}

