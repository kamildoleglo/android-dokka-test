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

/**
 * Contains the parameters used to configure/identify your job. You do not create this object
 * yourself, instead it is handed in to your application by the System.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JobParameters implements android.os.Parcelable {

JobParameters() { throw new RuntimeException("Stub!"); }

/**
 * @return The unique id of this job, specified at creation time.
 * @apiSince 21
 */

public int getJobId() { throw new RuntimeException("Stub!"); }

/**
 * @return The extras you passed in when constructing this job with
 * {@link android.app.job.JobInfo.Builder#setExtras(android.os.PersistableBundle)}. This will
 * never be null. If you did not set any extras this will be an empty bundle.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.os.PersistableBundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * @return The transient extras you passed in when constructing this job with
 * {@link android.app.job.JobInfo.Builder#setTransientExtras(android.os.Bundle)}. This will
 * never be null. If you did not set any extras this will be an empty bundle.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.os.Bundle getTransientExtras() { throw new RuntimeException("Stub!"); }

/**
 * @return The clip you passed in when constructing this job with
 * {@link android.app.job.JobInfo.Builder#setClipData(ClipData, int)}. Will be null
 * if it was not set.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.content.ClipData getClipData() { throw new RuntimeException("Stub!"); }

/**
 * @return The clip grant flags you passed in when constructing this job with
 * {@link android.app.job.JobInfo.Builder#setClipData(ClipData, int)}. Will be 0
 * if it was not set.
 * @apiSince 26
 */

public int getClipGrantFlags() { throw new RuntimeException("Stub!"); }

/**
 * For jobs with {@link android.app.job.JobInfo.Builder#setOverrideDeadline(long)} set, this
 * provides an easy way to tell whether the job is being executed due to the deadline
 * expiring. Note: If the job is running because its deadline expired, it implies that its
 * constraints will not be met.
 * @apiSince 21
 */

public boolean isOverrideDeadlineExpired() { throw new RuntimeException("Stub!"); }

/**
 * For jobs with {@link android.app.job.JobInfo.Builder#addTriggerContentUri} set, this
 * reports which URIs have triggered the job.  This will be null if either no URIs have
 * triggered it (it went off due to a deadline or other reason), or the number of changed
 * URIs is too large to report.  Whether or not the number of URIs is too large, you can
 * always use {@link #getTriggeredContentAuthorities()} to determine whether the job was
 * triggered due to any content changes and the authorities they are associated with.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.net.Uri[] getTriggeredContentUris() { throw new RuntimeException("Stub!"); }

/**
 * For jobs with {@link android.app.job.JobInfo.Builder#addTriggerContentUri} set, this
 * reports which content authorities have triggered the job.  It will only be null if no
 * authorities have triggered it -- that is, the job executed for some other reason, such
 * as a deadline expiring.  If this is non-null, you can use {@link #getTriggeredContentUris()}
 * to retrieve the details of which URIs changed (as long as that has not exceeded the maximum
 * number it can reported).
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.String[] getTriggeredContentAuthorities() { throw new RuntimeException("Stub!"); }

/**
 * Return the network that should be used to perform any network requests
 * for this job.
 * <p>
 * Devices may have multiple active network connections simultaneously, or
 * they may not have a default network route at all. To correctly handle all
 * situations like this, your job should always use the network returned by
 * this method instead of implicitly using the default network route.
 * <p>
 * Note that the system may relax the constraints you originally requested,
 * such as allowing a {@link android.app.job.JobInfo#NETWORK_TYPE_UNMETERED JobInfo#NETWORK_TYPE_UNMETERED} job to run over
 * a metered network when there is a surplus of metered data available.
 *
 * @return the network that should be used to perform any network requests
 *         for this job, or {@code null} if this job didn't set any required
 *         network type.
 * @see android.app.job.JobInfo.Builder#setRequiredNetworkType(int)
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.net.Network getNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Dequeue the next pending {@link android.app.job.JobWorkItem JobWorkItem} from these JobParameters associated with their
 * currently running job.  Calling this method when there is no more work available and all
 * previously dequeued work has been completed will result in the system taking care of
 * stopping the job for you --
 * you should not call {@link android.app.job.JobService#jobFinished(android.app.job.JobParameters,boolean) JobService#jobFinished(JobParameters, boolean)} yourself
 * (otherwise you risk losing an upcoming JobWorkItem that is being enqueued at the same time).
 *
 * <p>Once you are done with the {@link android.app.job.JobWorkItem JobWorkItem} returned by this method, you must call
 * {@link #completeWork(android.app.job.JobWorkItem)} with it to inform the system that you are done
 * executing the work.  The job will not be finished until all dequeued work has been
 * completed.  You do not, however, have to complete each returned work item before deqeueing
 * the next one -- you can use {@link #dequeueWork()} multiple times before completing
 * previous work if you want to process work in parallel, and you can complete the work
 * in whatever order you want.</p>
 *
 * <p>If the job runs to the end of its available time period before all work has been
 * completed, it will stop as normal.  You should return true from
 * {@link android.app.job.JobService#onStopJob(android.app.job.JobParameters) JobService#onStopJob(JobParameters)} in order to have the job rescheduled, and by
 * doing so any pending as well as remaining uncompleted work will be re-queued
 * for the next time the job runs.</p>
 *
 * <p>This example shows how to construct a JobService that will serially dequeue and
 * process work that is available for it:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/JobWorkService.java
 *      service}
 *
 * @return Returns a new {@link android.app.job.JobWorkItem JobWorkItem} if there is one pending, otherwise null.
 * If null is returned, the system will also stop the job if all work has also been completed.
 * (This means that for correct operation, you must always call dequeueWork() after you have
 * completed other work, to check either for more work or allow the system to stop the job.)
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.app.job.JobWorkItem dequeueWork() { throw new RuntimeException("Stub!"); }

/**
 * Report the completion of executing a {@link android.app.job.JobWorkItem JobWorkItem} previously returned by
 * {@link #dequeueWork()}.  This tells the system you are done with the
 * work associated with that item, so it will not be returned again.  Note that if this
 * is the last work in the queue, completing it here will <em>not</em> finish the overall
 * job -- for that to happen, you still need to call {@link #dequeueWork()}
 * again.
 *
 * <p>If you are enqueueing work into a job, you must call this method for each piece
 * of work you process.  Do <em>not</em> call
 * {@link android.app.job.JobService#jobFinished(android.app.job.JobParameters,boolean) JobService#jobFinished(JobParameters, boolean)}
 * or else you can lose work in your queue.</p>
 *
 * @param work The work you have completed processing, as previously returned by
 * {@link #dequeueWork()}
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void completeWork(@androidx.annotation.NonNull android.app.job.JobWorkItem work) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.job.JobParameters> CREATOR;
static { CREATOR = null; }
}

