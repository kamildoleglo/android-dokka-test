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


/**
 * <p>Entry point for the callback from the {@link android.app.job.JobScheduler}.</p>
 * <p>This is the base class that handles asynchronous requests that were previously scheduled. You
 * are responsible for overriding {@link android.app.job.JobService#onStartJob(android.app.job.JobParameters) JobService#onStartJob(JobParameters)}, which is where
 * you will implement your job logic.</p>
 * <p>This service executes each incoming job on a {@link android.os.Handler} running on your
 * application's main thread. This means that you <b>must</b> offload your execution logic to
 * another thread/handler/{@link android.os.AsyncTask} of your choosing. Not doing so will result
 * in blocking any future callbacks from the JobManager - specifically
 * {@link #onStopJob(android.app.job.JobParameters)}, which is meant to inform you that the
 * scheduling requirements are no longer being met.</p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class JobService extends android.app.Service {

public JobService() { throw new RuntimeException("Stub!"); }

/** @hide */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Call this to inform the JobScheduler that the job has finished its work.  When the
 * system receives this message, it releases the wakelock being held for the job.
 * <p>
 * You can request that the job be scheduled again by passing {@code true} as
 * the <code>wantsReschedule</code> parameter. This will apply back-off policy
 * for the job; this policy can be adjusted through the
 * {@link android.app.job.JobInfo.Builder#setBackoffCriteria(long, int)} method
 * when the job is originally scheduled.  The job's initial
 * requirements are preserved when jobs are rescheduled, regardless of backed-off
 * policy.
 * <p class="note">
 * A job running while the device is dozing will not be rescheduled with the normal back-off
 * policy.  Instead, the job will be re-added to the queue and executed again during
 * a future idle maintenance window.
 * </p>
 *
 * @param params The parameters identifying this job, as supplied to
 *               the job in the {@link #onStartJob(android.app.job.JobParameters)} callback.
 * @param wantsReschedule {@code true} if this job should be rescheduled according
 *     to the back-off criteria specified when it was first scheduled; {@code false}
 *     otherwise.
 * @apiSince 21
 */

public final void jobFinished(android.app.job.JobParameters params, boolean wantsReschedule) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate that the job has begun executing.  Override this method with the
 * logic for your job.  Like all other component lifecycle callbacks, this method executes
 * on your application's main thread.
 * <p>
 * Return {@code true} from this method if your job needs to continue running.  If you
 * do this, the job remains active until you call
 * {@link #jobFinished(android.app.job.JobParameters,boolean)} to tell the system that it has completed
 * its work, or until the job's required constraints are no longer satisfied.  For
 * example, if the job was scheduled using
 * {@link android.app.job.JobInfo.Builder#setRequiresCharging(boolean) JobInfo.Builder#setRequiresCharging(boolean)},
 * it will be immediately halted by the system if the user unplugs the device from power,
 * the job's {@link #onStopJob(android.app.job.JobParameters)} callback will be invoked, and the app
 * will be expected to shut down all ongoing work connected with that job.
 * <p>
 * The system holds a wakelock on behalf of your app as long as your job is executing.
 * This wakelock is acquired before this method is invoked, and is not released until either
 * you call {@link #jobFinished(android.app.job.JobParameters,boolean)}, or after the system invokes
 * {@link #onStopJob(android.app.job.JobParameters)} to notify your job that it is being shut down
 * prematurely.
 * <p>
 * Returning {@code false} from this method means your job is already finished.  The
 * system's wakelock for the job will be released, and {@link #onStopJob(android.app.job.JobParameters)}
 * will not be invoked.
 *
 * @param params Parameters specifying info about this job, including the optional
 *     extras configured with {@link android.app.job.JobInfo.Builder#setExtras(android.os.PersistableBundle) JobInfo.Builder#setExtras(android.os.PersistableBundle)}
 */

public abstract boolean onStartJob(android.app.job.JobParameters params);

/**
 * This method is called if the system has determined that you must stop execution of your job
 * even before you've had a chance to call {@link #jobFinished(android.app.job.JobParameters,boolean)}.
 *
 * <p>This will happen if the requirements specified at schedule time are no longer met. For
 * example you may have requested WiFi with
 * {@link android.app.job.JobInfo.Builder#setRequiredNetworkType(int)}, yet while your
 * job was executing the user toggled WiFi. Another example is if you had specified
 * {@link android.app.job.JobInfo.Builder#setRequiresDeviceIdle(boolean)}, and the phone left its
 * idle maintenance window. You are solely responsible for the behavior of your application
 * upon receipt of this message; your app will likely start to misbehave if you ignore it.
 * <p>
 * Once this method returns, the system releases the wakelock that it is holding on
 * behalf of the job.</p>
 *
 * @param params The parameters identifying this job, as supplied to
 *               the job in the {@link #onStartJob(android.app.job.JobParameters)} callback.
 * @return {@code true} to indicate to the JobManager whether you'd like to reschedule
 * this job based on the retry criteria provided at job creation-time; or {@code false}
 * to end the job entirely.  Regardless of the value returned, your job must stop executing.
 * @apiSince 21
 */

public abstract boolean onStopJob(android.app.job.JobParameters params);

/**
 * Job services must be protected with this permission:
 *
 * <pre class="prettyprint">
 *     &#60;service android:name="MyJobService"
 *              android:permission="android.permission.BIND_JOB_SERVICE" &#62;
 *         ...
 *     &#60;/service&#62;
 * </pre>
 *
 * <p>If a job service is declared in the manifest but not protected with this
 * permission, that service will be ignored by the system.
 * @apiSince 21
 */

public static final java.lang.String PERMISSION_BIND = "android.permission.BIND_JOB_SERVICE";
}

