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

import android.content.Context;
import android.os.PersistableBundle;
import android.os.Bundle;
import android.content.ClipData;

/**
 * This is an API for scheduling various types of jobs against the framework that will be executed
 * in your application's own process.
 * <p>
 * See {@link android.app.job.JobInfo} for more description of the types of jobs that can be run
 * and how to construct them. You will construct these JobInfo objects and pass them to the
 * JobScheduler with {@link #schedule(android.app.job.JobInfo)}. When the criteria declared are met, the
 * system will execute this job on your application's {@link android.app.job.JobService}.
 * You identify the service component that implements the logic for your job when you
 * construct the JobInfo using
 * {@link android.app.job.JobInfo.Builder#JobInfo.Builder(int,android.content.ComponentName)}.
 * </p>
 * <p>
 * The framework will be intelligent about when it executes jobs, and attempt to batch
 * and defer them as much as possible. Typically if you don't specify a deadline on a job, it
 * can be run at any moment depending on the current state of the JobScheduler's internal queue.
 * <p>
 * While a job is running, the system holds a wakelock on behalf of your app.  For this reason,
 * you do not need to take any action to guarantee that the device stays awake for the
 * duration of the job.
 * </p>
 * <p>You do not
 * instantiate this class directly; instead, retrieve it through
 * {@link android.content.Context#getSystemService
 * Context.getSystemService(Context.JOB_SCHEDULER_SERVICE)}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class JobScheduler {

public JobScheduler() { throw new RuntimeException("Stub!"); }

/**
 * Schedule a job to be executed.  Will replace any currently scheduled job with the same
 * ID with the new information in the {@link android.app.job.JobInfo JobInfo}.  If a job with the given ID is currently
 * running, it will be stopped.
 *
 * @param job The job you wish scheduled. See
 * {@link android.app.job.JobInfo.Builder JobInfo.Builder} for more detail on the sorts of jobs
 * you can schedule.
 * This value must never be {@code null}.
 * @return the result of the schedule request.
 
 * Value is {@link android.app.job.JobScheduler#RESULT_FAILURE}, or {@link android.app.job.JobScheduler#RESULT_SUCCESS}
 * @apiSince 21
 */

public abstract int schedule(@androidx.annotation.NonNull android.app.job.JobInfo job);

/**
 * Similar to {@link #schedule}, but allows you to enqueue work for a new <em>or existing</em>
 * job.  If a job with the same ID is already scheduled, it will be replaced with the
 * new {@link android.app.job.JobInfo JobInfo}, but any previously enqueued work will remain and be dispatched the
 * next time it runs.  If a job with the same ID is already running, the new work will be
 * enqueued for it.
 *
 * <p>The work you enqueue is later retrieved through
 * {@link android.app.job.JobParameters#dequeueWork() JobParameters#dequeueWork()}.  Be sure to see there
 * about how to process work; the act of enqueueing work changes how you should handle the
 * overall lifecycle of an executing job.</p>
 *
 * <p>It is strongly encouraged that you use the same {@link android.app.job.JobInfo JobInfo} for all work you
 * enqueue.  This will allow the system to optimally schedule work along with any pending
 * and/or currently running work.  If the JobInfo changes from the last time the job was
 * enqueued, the system will need to update the associated JobInfo, which can cause a disruption
 * in execution.  In particular, this can result in any currently running job that is processing
 * previous work to be stopped and restarted with the new JobInfo.</p>
 *
 * <p>It is recommended that you avoid using
 * {@link android.app.job.JobInfo.Builder#setExtras(android.os.PersistableBundle) JobInfo.Builder#setExtras(PersistableBundle)} or
 * {@link android.app.job.JobInfo.Builder#setTransientExtras(android.os.Bundle) JobInfo.Builder#setTransientExtras(Bundle)} with a JobInfo you are using to
 * enqueue work.  The system will try to compare these extras with the previous JobInfo,
 * but there are situations where it may get this wrong and count the JobInfo as changing.
 * (That said, you should be relatively safe with a simple set of consistent data in these
 * fields.)  You should never use {@link android.app.job.JobInfo.Builder#setClipData(android.content.ClipData,int) JobInfo.Builder#setClipData(ClipData, int)} with
 * work you are enqueue, since currently this will always be treated as a different JobInfo,
 * even if the ClipData contents are exactly the same.</p>
 *
 * @param job The job you wish to enqueue work for. See
 * {@link android.app.job.JobInfo.Builder JobInfo.Builder} for more detail on the sorts of jobs
 * you can schedule.
 * This value must never be {@code null}.
 * @param work New work to enqueue.  This will be available later when the job starts running.
 * This value must never be {@code null}.
 * @return the result of the enqueue request.
 
 * Value is {@link android.app.job.JobScheduler#RESULT_FAILURE}, or {@link android.app.job.JobScheduler#RESULT_SUCCESS}
 * @apiSince 26
 */

public abstract int enqueue(@androidx.annotation.NonNull android.app.job.JobInfo job, @androidx.annotation.NonNull android.app.job.JobWorkItem work);

/**
 * Cancel the specified job.  If the job is currently executing, it is stopped
 * immediately and the return value from its {@link android.app.job.JobService#onStopJob(android.app.job.JobParameters) JobService#onStopJob(JobParameters)}
 * method is ignored.
 *
 * @param jobId unique identifier for the job to be canceled, as supplied to
 *     {@link android.app.job.JobInfo.Builder#JobInfo.Builder(int,android.content.ComponentName) JobInfo.Builder#JobInfo.Builder(int, android.content.ComponentName)}.
 * @apiSince 21
 */

public abstract void cancel(int jobId);

/**
 * Cancel <em>all</em> jobs that have been scheduled by the calling application.
 * @apiSince 21
 */

public abstract void cancelAll();

/**
 * Retrieve all jobs that have been scheduled by the calling application.
 *
 * @return a list of all of the app's scheduled jobs.  This includes jobs that are
 *     currently started as well as those that are still waiting to run.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.app.job.JobInfo> getAllPendingJobs();

/**
 * Look up the description of a scheduled job.
 *
 * @return The {@link android.app.job.JobInfo JobInfo} description of the given scheduled job, or {@code null}
 *     if the supplied job ID does not correspond to any job.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public abstract android.app.job.JobInfo getPendingJob(int jobId);

/**
 * Returned from {@link #schedule(android.app.job.JobInfo)} when an invalid parameter was supplied. This can occur
 * if the run-time for your job is too short, or perhaps the system can't resolve the
 * requisite {@link android.app.job.JobService JobService} in your package.
 * @apiSince 21
 */

public static final int RESULT_FAILURE = 0; // 0x0

/**
 * Returned from {@link #schedule(android.app.job.JobInfo)} if this job has been successfully scheduled.
 * @apiSince 21
 */

public static final int RESULT_SUCCESS = 1; // 0x1
}

