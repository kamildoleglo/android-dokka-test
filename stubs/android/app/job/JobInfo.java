/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * limitations under the License
 */


package android.app.job;

import android.os.PersistableBundle;
import android.os.Bundle;
import android.content.ClipData;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.NetworkSpecifier;

/**
 * Container of data passed to the {@link android.app.job.JobScheduler} fully encapsulating the
 * parameters required to schedule work against the calling application. These are constructed
 * using the {@link android.app.job.JobInfo.Builder JobInfo.Builder}.
 * You must specify at least one sort of constraint on the JobInfo object that you are creating.
 * The goal here is to provide the scheduler with high-level semantics about the work you want to
 * accomplish. Doing otherwise with throw an exception in your app.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JobInfo implements android.os.Parcelable {

private JobInfo() { throw new RuntimeException("Stub!"); }

/**
 * Query the minimum interval allowed for periodic scheduled jobs.  Attempting
 * to declare a smaller period that this when scheduling a job will result in a
 * job that is still periodic, but will run with this effective period.
 *
 * @return The minimum available interval for scheduling periodic jobs, in milliseconds.
 * @apiSince 24
 */

public static final long getMinPeriodMillis() { throw new RuntimeException("Stub!"); }

/**
 * Query the minimum flex time allowed for periodic scheduled jobs.  Attempting
 * to declare a shorter flex time than this when scheduling such a job will
 * result in this amount as the effective flex time for the job.
 *
 * @return The minimum available flex time for scheduling periodic jobs, in milliseconds.
 * @apiSince 24
 */

public static final long getMinFlexMillis() { throw new RuntimeException("Stub!"); }

/**
 * Unique job id associated with this application (uid).  This is the same job ID
 * you supplied in the {@link android.app.job.JobInfo.Builder Builder} constructor.
 * @apiSince 21
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setExtras(PersistableBundle)
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.os.PersistableBundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setTransientExtras(Bundle)
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.os.Bundle getTransientExtras() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setClipData(ClipData, int)
 
 * @return This value may be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.content.ClipData getClipData() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setClipData(ClipData, int)
 * @apiSince 26
 */

public int getClipGrantFlags() { throw new RuntimeException("Stub!"); }

/**
 * Name of the service endpoint that will be called back into by the JobScheduler.
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.content.ComponentName getService() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setRequiresCharging(boolean)
 * @apiSince 21
 */

public boolean isRequireCharging() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setRequiresBatteryNotLow(boolean)
 * @apiSince 26
 */

public boolean isRequireBatteryNotLow() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setRequiresDeviceIdle(boolean)
 * @apiSince 21
 */

public boolean isRequireDeviceIdle() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setRequiresStorageNotLow(boolean)
 * @apiSince 26
 */

public boolean isRequireStorageNotLow() { throw new RuntimeException("Stub!"); }

/**
 * Which content: URIs must change for the job to be scheduled.  Returns null
 * if there are none required.
 * @see android.app.job.JobInfo.Builder#addTriggerContentUri(TriggerContentUri)
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.app.job.JobInfo.TriggerContentUri[] getTriggerContentUris() { throw new RuntimeException("Stub!"); }

/**
 * When triggering on content URI changes, this is the delay from when a change
 * is detected until the job is scheduled.
 * @see android.app.job.JobInfo.Builder#setTriggerContentUpdateDelay(long)
 * @apiSince 24
 */

public long getTriggerContentUpdateDelay() { throw new RuntimeException("Stub!"); }

/**
 * When triggering on content URI changes, this is the maximum delay we will
 * use before scheduling the job.
 * @see android.app.job.JobInfo.Builder#setTriggerContentMaxDelay(long)
 * @apiSince 24
 */

public long getTriggerContentMaxDelay() { throw new RuntimeException("Stub!"); }

/**
 * Return the basic description of the kind of network this job requires.
 *
 * @deprecated This method attempts to map {@link #getRequiredNetwork()}
 *             into the set of simple constants, which results in a loss of
 *             fidelity. Callers should move to using
 *             {@link #getRequiredNetwork()} directly.
 * @see android.app.job.JobInfo.Builder#setRequiredNetworkType(int)
 
 * @return Value is {@link android.app.job.JobInfo#NETWORK_TYPE_NONE}, {@link android.app.job.JobInfo#NETWORK_TYPE_ANY}, {@link android.app.job.JobInfo#NETWORK_TYPE_UNMETERED}, {@link android.app.job.JobInfo#NETWORK_TYPE_NOT_ROAMING}, or {@link android.app.job.JobInfo#NETWORK_TYPE_CELLULAR}
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public int getNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * Return the detailed description of the kind of network this job requires,
 * or {@code null} if no specific kind of network is required.
 *
 * @see android.app.job.JobInfo.Builder#setRequiredNetwork(NetworkRequest)
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.net.NetworkRequest getRequiredNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Return the estimated size of download traffic that will be performed by
 * this job, in bytes.
 *
 * <br>
 * Value is a non-negative number of bytes.
 * @return Estimated size of download traffic, or
 *         {@link #NETWORK_BYTES_UNKNOWN} when unknown.
 * Value is a non-negative number of bytes.
 * @see android.app.job.JobInfo.Builder#setEstimatedNetworkBytes(long, long)
 * @apiSince 28
 */

public long getEstimatedNetworkDownloadBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the estimated size of upload traffic that will be performed by
 * this job, in bytes.
 *
 * <br>
 * Value is a non-negative number of bytes.
 * @return Estimated size of upload traffic, or
 *         {@link #NETWORK_BYTES_UNKNOWN} when unknown.
 * Value is a non-negative number of bytes.
 * @see android.app.job.JobInfo.Builder#setEstimatedNetworkBytes(long, long)
 * @apiSince 28
 */

public long getEstimatedNetworkUploadBytes() { throw new RuntimeException("Stub!"); }

/**
 * Set for a job that does not recur periodically, to specify a delay after which the job
 * will be eligible for execution. This value is not set if the job recurs periodically.
 * @see android.app.job.JobInfo.Builder#setMinimumLatency(long)
 * @apiSince 21
 */

public long getMinLatencyMillis() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setOverrideDeadline(long)
 * @apiSince 21
 */

public long getMaxExecutionDelayMillis() { throw new RuntimeException("Stub!"); }

/**
 * Track whether this job will repeat with a given period.
 * @see android.app.job.JobInfo.Builder#setPeriodic(long)
 * @see android.app.job.JobInfo.Builder#setPeriodic(long, long)
 * @apiSince 21
 */

public boolean isPeriodic() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setPersisted(boolean)
 * @apiSince 21
 */

public boolean isPersisted() { throw new RuntimeException("Stub!"); }

/**
 * Set to the interval between occurrences of this job. This value is <b>not</b> set if the
 * job does not recur periodically.
 * @see android.app.job.JobInfo.Builder#setPeriodic(long)
 * @see android.app.job.JobInfo.Builder#setPeriodic(long, long)
 * @apiSince 21
 */

public long getIntervalMillis() { throw new RuntimeException("Stub!"); }

/**
 * Flex time for this job. Only valid if this is a periodic job.  The job can
 * execute at any time in a window of flex length at the end of the period.
 * @see android.app.job.JobInfo.Builder#setPeriodic(long)
 * @see android.app.job.JobInfo.Builder#setPeriodic(long, long)
 * @apiSince 24
 */

public long getFlexMillis() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time the JobScheduler will wait before rescheduling a failed job. This value
 * will be increased depending on the backoff policy specified at job creation time. Defaults
 * to 30 seconds, minimum is currently 10 seconds.
 * @see android.app.job.JobInfo.Builder#setBackoffCriteria(long, int)
 * @apiSince 21
 */

public long getInitialBackoffMillis() { throw new RuntimeException("Stub!"); }

/**
 * Return the backoff policy of this job.
 * @see android.app.job.JobInfo.Builder#setBackoffCriteria(long, int)
 
 * @return Value is {@link android.app.job.JobInfo#BACKOFF_POLICY_LINEAR}, or {@link android.app.job.JobInfo#BACKOFF_POLICY_EXPONENTIAL}
 * @apiSince 21
 */

public int getBackoffPolicy() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setImportantWhileForeground(boolean)
 * @apiSince 28
 */

public boolean isImportantWhileForeground() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.job.JobInfo.Builder#setPrefetch(boolean)
 * @apiSince 28
 */

public boolean isPrefetch() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Exponentially back-off a failed job. See
 * {@link android.app.job.JobInfo.Builder#setBackoffCriteria(long, int)}
 *
 * retry_time(current_time, num_failures) =
 *     current_time + initial_backoff_millis * 2 ^ (num_failures - 1), num_failures >= 1
 * @apiSince 21
 */

public static final int BACKOFF_POLICY_EXPONENTIAL = 1; // 0x1

/**
 * Linearly back-off a failed job. See
 * {@link android.app.job.JobInfo.Builder#setBackoffCriteria(long, int)}
 * retry_time(current_time, num_failures) =
 *     current_time + initial_backoff_millis * num_failures, num_failures >= 1
 * @apiSince 21
 */

public static final int BACKOFF_POLICY_LINEAR = 0; // 0x0

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.job.JobInfo> CREATOR;
static { CREATOR = null; }

/**
 * Amount of backoff a job has initially by default, in milliseconds.
 * @apiSince 21
 */

public static final long DEFAULT_INITIAL_BACKOFF_MILLIS = 30000L; // 0x7530L

/**
 * Maximum backoff we allow for a job, in milliseconds.
 * @apiSince 21
 */

public static final long MAX_BACKOFF_DELAY_MILLIS = 18000000L; // 0x112a880L

/**
 * Sentinel value indicating that bytes are unknown.
 * @apiSince 28
 */

public static final int NETWORK_BYTES_UNKNOWN = -1; // 0xffffffff

/**
 * This job requires network connectivity.
 * @apiSince 21
 */

public static final int NETWORK_TYPE_ANY = 1; // 0x1

/**
 * This job requires network connectivity that is a cellular network.
 * @apiSince 28
 */

public static final int NETWORK_TYPE_CELLULAR = 4; // 0x4

/**
 * This job requires metered connectivity such as most cellular data
 * networks.
 *
 * @deprecated Cellular networks may be unmetered, or Wi-Fi networks may be
 *             metered, so this isn't a good way of selecting a specific
 *             transport. Instead, use {@link #NETWORK_TYPE_CELLULAR} or
 *             {@link android.net.NetworkRequest.Builder#addTransportType(int)}
 *             if your job requires a specific network transport.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated public static final int NETWORK_TYPE_METERED = 4; // 0x4

/**
 * Default.
 * @apiSince 21
 */

public static final int NETWORK_TYPE_NONE = 0; // 0x0

/**
 * This job requires network connectivity that is not roaming.
 * @apiSince 24
 */

public static final int NETWORK_TYPE_NOT_ROAMING = 3; // 0x3

/**
 * This job requires network connectivity that is unmetered.
 * @apiSince 21
 */

public static final int NETWORK_TYPE_UNMETERED = 2; // 0x2
/**
 * Builder class for constructing {@link android.app.job.JobInfo JobInfo} objects.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Initialize a new Builder to construct a {@link android.app.job.JobInfo JobInfo}.
 *
 * @param jobId Application-provided id for this job. Subsequent calls to cancel, or
 * jobs created with the same jobId, will update the pre-existing job with
 * the same id.  This ID must be unique across all clients of the same uid
 * (not just the same package).  You will want to make sure this is a stable
 * id across app updates, so probably not based on a resource ID.
 * @param jobService The endpoint that you implement that will receive the callback from the
 * JobScheduler.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public Builder(int jobId, @androidx.annotation.NonNull android.content.ComponentName jobService) { throw new RuntimeException("Stub!"); }

/**
 * Set optional extras. This is persisted, so we only allow primitive types.
 * @param extras Bundle containing extras you want the scheduler to hold on to for you.
 * This value must never be {@code null}.
 * @see android.app.job.JobInfo#getExtras()
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setExtras(@androidx.annotation.NonNull android.os.PersistableBundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Set optional transient extras.
 *
 * <p>Because setting this property is not compatible with persisted
 * jobs, doing so will throw an {@link java.lang.IllegalArgumentException} when
 * {@link android.app.job.JobInfo.Builder#build()} is called.</p>
 *
 * @param extras Bundle containing extras you want the scheduler to hold on to for you.
 * This value must never be {@code null}.
 * @see android.app.job.JobInfo#getTransientExtras()
 * @apiSince 26
 */

public android.app.job.JobInfo.Builder setTransientExtras(@androidx.annotation.NonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Set a {@link android.content.ClipData ClipData} associated with this Job.
 *
 * <p>The main purpose of providing a ClipData is to allow granting of
 * URI permissions for data associated with the clip.  The exact kind
 * of permission grant to perform is specified through <var>grantFlags</var>.
 *
 * <p>If the ClipData contains items that are Intents, any
 * grant flags in those Intents will be ignored.  Only flags provided as an argument
 * to this method are respected, and will be applied to all Uri or
 * Intent items in the clip (or sub-items of the clip).
 *
 * <p>Because setting this property is not compatible with persisted
 * jobs, doing so will throw an {@link java.lang.IllegalArgumentException} when
 * {@link android.app.job.JobInfo.Builder#build()} is called.</p>
 *
 * @param clip The new clip to set.  May be null to clear the current clip.
 * This value may be {@code null}.
 * @param grantFlags The desired permissions to grant for any URIs.  This should be
 * a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION},
 * {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}, and
 * {@link android.content.Intent#FLAG_GRANT_PREFIX_URI_PERMISSION}.
 * @see android.app.job.JobInfo#getClipData()
 * @see android.app.job.JobInfo#getClipGrantFlags()
 * @apiSince 26
 */

public android.app.job.JobInfo.Builder setClipData(@androidx.annotation.Nullable android.content.ClipData clip, int grantFlags) { throw new RuntimeException("Stub!"); }

/**
 * Set basic description of the kind of network your job requires. If
 * you need more precise control over network capabilities, see
 * {@link #setRequiredNetwork(android.net.NetworkRequest)}.
 * <p>
 * If your job doesn't need a network connection, you don't need to call
 * this method, as the default value is {@link #NETWORK_TYPE_NONE}.
 * <p>
 * Calling this method defines network as a strict requirement for your
 * job. If the network requested is not available your job will never
 * run. See {@link #setOverrideDeadline(long)} to change this behavior.
 * Calling this method will override any requirements previously defined
 * by {@link #setRequiredNetwork(android.net.NetworkRequest)}; you typically only
 * want to call one of these methods.
 * <p class="note">
 * When your job executes in
 * {@link android.app.job.JobService#onStartJob(android.app.job.JobParameters) JobService#onStartJob(JobParameters)}, be sure to use the
 * specific network returned by {@link android.app.job.JobParameters#getNetwork() JobParameters#getNetwork()},
 * otherwise you'll use the default network which may not meet this
 * constraint.
 *
 * @see #setRequiredNetwork(NetworkRequest)
 * @see android.app.job.JobInfo#getNetworkType()
 * @see android.app.job.JobParameters#getNetwork()
 
 * @param networkType Value is {@link android.app.job.JobInfo#NETWORK_TYPE_NONE}, {@link android.app.job.JobInfo#NETWORK_TYPE_ANY}, {@link android.app.job.JobInfo#NETWORK_TYPE_UNMETERED}, {@link android.app.job.JobInfo#NETWORK_TYPE_NOT_ROAMING}, or {@link android.app.job.JobInfo#NETWORK_TYPE_CELLULAR}
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setRequiredNetworkType(int networkType) { throw new RuntimeException("Stub!"); }

/**
 * Set detailed description of the kind of network your job requires.
 * <p>
 * If your job doesn't need a network connection, you don't need to call
 * this method, as the default is {@code null}.
 * <p>
 * Calling this method defines network as a strict requirement for your
 * job. If the network requested is not available your job will never
 * run. See {@link #setOverrideDeadline(long)} to change this behavior.
 * Calling this method will override any requirements previously defined
 * by {@link #setRequiredNetworkType(int)}; you typically only want to
 * call one of these methods.
 * <p class="note">
 * When your job executes in
 * {@link android.app.job.JobService#onStartJob(android.app.job.JobParameters) JobService#onStartJob(JobParameters)}, be sure to use the
 * specific network returned by {@link android.app.job.JobParameters#getNetwork() JobParameters#getNetwork()},
 * otherwise you'll use the default network which may not meet this
 * constraint.
 *
 * @param networkRequest The detailed description of the kind of network
 *            this job requires, or {@code null} if no specific kind of
 *            network is required. Defining a {@link android.net.NetworkSpecifier NetworkSpecifier}
 *            is only supported for jobs that aren't persisted.
 * This value may be {@code null}.
 * @see #setRequiredNetworkType(int)
 * @see android.app.job.JobInfo#getRequiredNetwork()
 * @see android.app.job.JobParameters#getNetwork()
 * @apiSince 28
 */

public android.app.job.JobInfo.Builder setRequiredNetwork(@androidx.annotation.Nullable android.net.NetworkRequest networkRequest) { throw new RuntimeException("Stub!"); }

/**
 * Set the estimated size of network traffic that will be performed by
 * this job, in bytes.
 * <p>
 * Apps are encouraged to provide values that are as accurate as
 * possible, but when the exact size isn't available, an
 * order-of-magnitude estimate can be provided instead. Here are some
 * specific examples:
 * <ul>
 * <li>A job that is backing up a photo knows the exact size of that
 * photo, so it should provide that size as the estimate.
 * <li>A job that refreshes top news stories wouldn't know an exact
 * size, but if the size is expected to be consistently around 100KB, it
 * can provide that order-of-magnitude value as the estimate.
 * <li>A job that synchronizes email could end up using an extreme range
 * of data, from under 1KB when nothing has changed, to dozens of MB
 * when there are new emails with attachments. Jobs that cannot provide
 * reasonable estimates should use the sentinel value
 * {@link android.app.job.JobInfo#NETWORK_BYTES_UNKNOWN JobInfo#NETWORK_BYTES_UNKNOWN}.
 * </ul>
 * Note that the system may choose to delay jobs with large network
 * usage estimates when the device has a poor network connection, in
 * order to save battery.
 * <p>
 * The values provided here only reflect the traffic that will be
 * performed by the base job; if you're using {@link android.app.job.JobWorkItem JobWorkItem} then
 * you also need to define the network traffic used by each work item
 * when constructing them.
 *
 * @param downloadBytes The estimated size of network traffic that will
 *            be downloaded by this job, in bytes.
 * Value is a non-negative number of bytes.
 * @param uploadBytes The estimated size of network traffic that will be
 *            uploaded by this job, in bytes.
 * Value is a non-negative number of bytes.
 * @see android.app.job.JobInfo#getEstimatedNetworkDownloadBytes()
 * @see android.app.job.JobInfo#getEstimatedNetworkUploadBytes()
 * @see android.app.job.JobWorkItem#JobWorkItem(android.content.Intent, long, long)
 * @apiSince 28
 */

public android.app.job.JobInfo.Builder setEstimatedNetworkBytes(long downloadBytes, long uploadBytes) { throw new RuntimeException("Stub!"); }

/**
 * Specify that to run this job, the device must be charging (or be a
 * non-battery-powered device connected to permanent power, such as Android TV
 * devices). This defaults to {@code false}.
 *
 * <p class="note">For purposes of running jobs, a battery-powered device
 * "charging" is not quite the same as simply being connected to power.  If the
 * device is so busy that the battery is draining despite a power connection, jobs
 * with this constraint will <em>not</em> run.  This can happen during some
 * common use cases such as video chat, particularly if the device is plugged in
 * to USB rather than to wall power.
 *
 * @param requiresCharging Pass {@code true} to require that the device be
 *     charging in order to run the job.
 * @see android.app.job.JobInfo#isRequireCharging()
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setRequiresCharging(boolean requiresCharging) { throw new RuntimeException("Stub!"); }

/**
 * Specify that to run this job, the device's battery level must not be low.
 * This defaults to false.  If true, the job will only run when the battery level
 * is not low, which is generally the point where the user is given a "low battery"
 * warning.
 * @param batteryNotLow Whether or not the device's battery level must not be low.
 * @see android.app.job.JobInfo#isRequireBatteryNotLow()
 * @apiSince 26
 */

public android.app.job.JobInfo.Builder setRequiresBatteryNotLow(boolean batteryNotLow) { throw new RuntimeException("Stub!"); }

/**
 * When set {@code true}, ensure that this job will not run if the device is in active use.
 * The default state is {@code false}: that is, the for the job to be runnable even when
 * someone is interacting with the device.
 *
 * <p>This state is a loose definition provided by the system. In general, it means that
 * the device is not currently being used interactively, and has not been in use for some
 * time. As such, it is a good time to perform resource heavy jobs. Bear in mind that
 * battery usage will still be attributed to your application, and surfaced to the user in
 * battery stats.</p>
 *
 * <p class="note">Despite the similar naming, this job constraint is <em>not</em>
 * related to the system's "device idle" or "doze" states.  This constraint only
 * determines whether a job is allowed to run while the device is directly in use.
 *
 * @param requiresDeviceIdle Pass {@code true} to prevent the job from running
 *     while the device is being used interactively.
 * @see android.app.job.JobInfo#isRequireDeviceIdle()
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setRequiresDeviceIdle(boolean requiresDeviceIdle) { throw new RuntimeException("Stub!"); }

/**
 * Specify that to run this job, the device's available storage must not be low.
 * This defaults to false.  If true, the job will only run when the device is not
 * in a low storage state, which is generally the point where the user is given a
 * "low storage" warning.
 * @param storageNotLow Whether or not the device's available storage must not be low.
 * @see android.app.job.JobInfo#isRequireStorageNotLow()
 * @apiSince 26
 */

public android.app.job.JobInfo.Builder setRequiresStorageNotLow(boolean storageNotLow) { throw new RuntimeException("Stub!"); }

/**
 * Add a new content: URI that will be monitored with a
 * {@link android.database.ContentObserver}, and will cause the job to execute if changed.
 * If you have any trigger content URIs associated with a job, it will not execute until
 * there has been a change report for one or more of them.
 *
 * <p>Note that trigger URIs can not be used in combination with
 * {@link #setPeriodic(long)} or {@link #setPersisted(boolean)}.  To continually monitor
 * for content changes, you need to schedule a new JobInfo observing the same URIs
 * before you finish execution of the JobService handling the most recent changes.
 * Following this pattern will ensure you do not lost any content changes: while your
 * job is running, the system will continue monitoring for content changes, and propagate
 * any it sees over to the next job you schedule.</p>
 *
 * <p>Because setting this property is not compatible with periodic or
 * persisted jobs, doing so will throw an {@link java.lang.IllegalArgumentException} when
 * {@link android.app.job.JobInfo.Builder#build()} is called.</p>
 *
 * <p>The following example shows how this feature can be used to monitor for changes
 * in the photos on a device.</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/PhotosContentJob.java
 *      job}
 *
 * @param uri The content: URI to monitor.
 * This value must never be {@code null}.
 * @see android.app.job.JobInfo#getTriggerContentUris()
 * @apiSince 24
 */

public android.app.job.JobInfo.Builder addTriggerContentUri(@androidx.annotation.NonNull android.app.job.JobInfo.TriggerContentUri uri) { throw new RuntimeException("Stub!"); }

/**
 * Set the delay (in milliseconds) from when a content change is detected until
 * the job is scheduled.  If there are more changes during that time, the delay
 * will be reset to start at the time of the most recent change.
 * @param durationMs Delay after most recent content change, in milliseconds.
 * @see android.app.job.JobInfo#getTriggerContentUpdateDelay()
 * @apiSince 24
 */

public android.app.job.JobInfo.Builder setTriggerContentUpdateDelay(long durationMs) { throw new RuntimeException("Stub!"); }

/**
 * Set the maximum total delay (in milliseconds) that is allowed from the first
 * time a content change is detected until the job is scheduled.
 * @param durationMs Delay after initial content change, in milliseconds.
 * @see android.app.job.JobInfo#getTriggerContentMaxDelay()
 * @apiSince 24
 */

public android.app.job.JobInfo.Builder setTriggerContentMaxDelay(long durationMs) { throw new RuntimeException("Stub!"); }

/**
 * Specify that this job should recur with the provided interval, not more than once per
 * period. You have no control over when within this interval this job will be executed,
 * only the guarantee that it will be executed at most once within this interval.
 * Setting this function on the builder with {@link #setMinimumLatency(long)} or
 * {@link #setOverrideDeadline(long)} will result in an error.
 * @param intervalMillis Millisecond interval for which this job will repeat.
 * @see android.app.job.JobInfo#getIntervalMillis()
 * @see android.app.job.JobInfo#getFlexMillis()
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setPeriodic(long intervalMillis) { throw new RuntimeException("Stub!"); }

/**
 * Specify that this job should recur with the provided interval and flex. The job can
 * execute at any time in a window of flex length at the end of the period.
 * @param intervalMillis Millisecond interval for which this job will repeat. A minimum
 *                       value of {@link #getMinPeriodMillis()} is enforced.
 * @param flexMillis Millisecond flex for this job. Flex is clamped to be at least
 *                   {@link #getMinFlexMillis()} or 5 percent of the period, whichever is
 *                   higher.
 * @see android.app.job.JobInfo#getIntervalMillis()
 * @see android.app.job.JobInfo#getFlexMillis()
 * @apiSince 24
 */

public android.app.job.JobInfo.Builder setPeriodic(long intervalMillis, long flexMillis) { throw new RuntimeException("Stub!"); }

/**
 * Specify that this job should be delayed by the provided amount of time.
 * Because it doesn't make sense setting this property on a periodic job, doing so will
 * throw an {@link java.lang.IllegalArgumentException} when
 * {@link android.app.job.JobInfo.Builder#build()} is called.
 * @param minLatencyMillis Milliseconds before which this job will not be considered for
 *                         execution.
 * @see android.app.job.JobInfo#getMinLatencyMillis()
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setMinimumLatency(long minLatencyMillis) { throw new RuntimeException("Stub!"); }

/**
 * Set deadline which is the maximum scheduling latency. The job will be run by this
 * deadline even if other requirements are not met. Because it doesn't make sense setting
 * this property on a periodic job, doing so will throw an
 * {@link java.lang.IllegalArgumentException} when
 * {@link android.app.job.JobInfo.Builder#build()} is called.
 * @see android.app.job.JobInfo#getMaxExecutionDelayMillis()
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setOverrideDeadline(long maxExecutionDelayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Set up the back-off/retry policy.
 * This defaults to some respectable values: {30 seconds, Exponential}. We cap back-off at
 * 5hrs.
 * Note that trying to set a backoff criteria for a job with
 * {@link #setRequiresDeviceIdle(boolean)} will throw an exception when you call build().
 * This is because back-off typically does not make sense for these types of jobs. See
 * {@link android.app.job.JobService#jobFinished(android.app.job.JobParameters, boolean)}
 * for more description of the return value for the case of a job executing while in idle
 * mode.
 * @param initialBackoffMillis Millisecond time interval to wait initially when job has
 *                             failed.
 * @see android.app.job.JobInfo#getInitialBackoffMillis()
 * @see android.app.job.JobInfo#getBackoffPolicy()
 
 * @param backoffPolicy Value is {@link android.app.job.JobInfo#BACKOFF_POLICY_LINEAR}, or {@link android.app.job.JobInfo#BACKOFF_POLICY_EXPONENTIAL}
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setBackoffCriteria(long initialBackoffMillis, int backoffPolicy) { throw new RuntimeException("Stub!"); }

/**
 * Setting this to true indicates that this job is important while the scheduling app
 * is in the foreground or on the temporary whitelist for background restrictions.
 * This means that the system will relax doze restrictions on this job during this time.
 *
 * Apps should use this flag only for short jobs that are essential for the app to function
 * properly in the foreground.
 *
 * Note that once the scheduling app is no longer whitelisted from background restrictions
 * and in the background, or the job failed due to unsatisfied constraints,
 * this job should be expected to behave like other jobs without this flag.
 *
 * @param importantWhileForeground whether to relax doze restrictions for this job when the
 *                                 app is in the foreground. False by default.
 * @see android.app.job.JobInfo#isImportantWhileForeground()
 * @apiSince 28
 */

public android.app.job.JobInfo.Builder setImportantWhileForeground(boolean importantWhileForeground) { throw new RuntimeException("Stub!"); }

/**
 * Setting this to true indicates that this job is designed to prefetch
 * content that will make a material improvement to the experience of
 * the specific user of this device. For example, fetching top headlines
 * of interest to the current user.
 * <p>
 * The system may use this signal to relax the network constraints you
 * originally requested, such as allowing a
 * {@link android.app.job.JobInfo#NETWORK_TYPE_UNMETERED JobInfo#NETWORK_TYPE_UNMETERED} job to run over a metered
 * network when there is a surplus of metered data available. The system
 * may also use this signal in combination with end user usage patterns
 * to ensure data is prefetched before the user launches your app.
 * @see android.app.job.JobInfo#isPrefetch()
 * @apiSince 28
 */

public android.app.job.JobInfo.Builder setPrefetch(boolean prefetch) { throw new RuntimeException("Stub!"); }

/**
 * Set whether or not to persist this job across device reboots.
 *
 * <br>
 * Requires {@link android.Manifest.permission#RECEIVE_BOOT_COMPLETED}
 * @param isPersisted True to indicate that the job will be written to
 *            disk and loaded at boot.
 * @see android.app.job.JobInfo#isPersisted()
 * @apiSince 21
 */

public android.app.job.JobInfo.Builder setPersisted(boolean isPersisted) { throw new RuntimeException("Stub!"); }

/**
 * @return The job object to hand to the JobScheduler. This object is immutable.
 * @apiSince 21
 */

public android.app.job.JobInfo build() { throw new RuntimeException("Stub!"); }
}

/**
 * Information about a content URI modification that a job would like to
 * trigger on.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class TriggerContentUri implements android.os.Parcelable {

/**
 * Create a new trigger description.
 * @param uri The URI to observe.  Must be non-null.
 * This value must never be {@code null}.
 * @param flags Flags for the observer.
 
 * Value is either <code>0</code> or {@link android.app.job.JobInfo.TriggerContentUri#FLAG_NOTIFY_FOR_DESCENDANTS}
 * @apiSince 24
 */

public TriggerContentUri(@androidx.annotation.NonNull android.net.Uri uri, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return the Uri this trigger was created for.
 * @apiSince 24
 */

public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * Return the flags supplied for the trigger.
 
 * @return Value is either <code>0</code> or {@link android.app.job.JobInfo.TriggerContentUri#FLAG_NOTIFY_FOR_DESCENDANTS}
 * @apiSince 24
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.job.JobInfo.TriggerContentUri> CREATOR;
static { CREATOR = null; }

/**
 * Flag for trigger: also trigger if any descendants of the given URI change.
 * Corresponds to the <var>notifyForDescendants</var> of
 * {@link android.content.ContentResolver#registerContentObserver}.
 * @apiSince 24
 */

public static final int FLAG_NOTIFY_FOR_DESCENDANTS = 1; // 0x1
}

}

