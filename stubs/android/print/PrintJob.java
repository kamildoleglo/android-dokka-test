/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.print;


/**
 * This class represents a print job from the perspective of an
 * application. It contains behavior methods for performing operations
 * on it as well as methods for querying its state. A snapshot of the
 * print job state is represented by the {@link android.print.PrintJobInfo PrintJobInfo} class.
 * The state of a print job may change over time. An application receives
 * instances of this class when creating a print job or querying for
 * its print jobs.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrintJob {

PrintJob() { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique print job id.
 *
 * @return The id.
 
 * This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.print.PrintJobId getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.print.PrintJobInfo PrintJobInfo} that describes this job.
 * <p>
 * <strong>Node:</strong>The returned info object is a snapshot of the
 * current print job state. Every call to this method returns a fresh
 * info object that reflects the current print job state.
 * </p>
 *
 * @return The print job info.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public android.print.PrintJobInfo getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Cancels this print job. You can request cancellation of a
 * queued, started, blocked, or failed print job.
 *
 * @see #isQueued()
 * @see #isStarted()
 * @see #isBlocked()
 * @see #isFailed()
 * @apiSince 19
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Restarts this print job. You can request restart of a failed
 * print job.
 *
 * @see #isFailed()
 * @apiSince 19
 */

public void restart() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is queued. Such a print job is
 * ready to be printed. You can request a cancellation via
 * {@link #cancel()}.
 *
 * @return Whether the print job is queued.
 *
 * @see #cancel()
 * @apiSince 19
 */

public boolean isQueued() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is started. Such a print job is
 * being printed. You can request a cancellation via
 * {@link #cancel()}.
 *
 * @return Whether the print job is started.
 *
 * @see #cancel()
 * @apiSince 19
 */

public boolean isStarted() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is blocked. Such a print job is halted
 * due to an abnormal condition. You can request a cancellation via
 * {@link #cancel()}.
 *
 * @return Whether the print job is blocked.
 *
 * @see #cancel()
 * @apiSince 19
 */

public boolean isBlocked() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is completed. Such a print job
 * is successfully printed. You can neither cancel nor restart
 * such a print job.
 *
 * @return Whether the print job is completed.
 * @apiSince 19
 */

public boolean isCompleted() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is failed. Such a print job is
 * not successfully printed due to an error. You can request
 * a restart via {@link #restart()} or cancel via {@link #cancel()}.
 *
 * @return Whether the print job is failed.
 *
 * @see #restart()
 * @see #cancel()
 * @apiSince 19
 */

public boolean isFailed() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is cancelled. Such a print job was
 * cancelled as a result of a user request. This is a final state.
 * You cannot restart such a print job.
 *
 * @return Whether the print job is cancelled.
 * @apiSince 19
 */

public boolean isCancelled() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

