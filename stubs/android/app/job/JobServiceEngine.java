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

import android.app.Service;
import android.content.Intent;

/**
 * Helper for implementing a {@link android.app.Service} that interacts with
 * {@link android.app.job.JobScheduler JobScheduler}.  This is not intended for use by regular applications, but
 * allows frameworks built on top of the platform to create their own
 * {@link android.app.Service} that interact with {@link android.app.job.JobScheduler JobScheduler} as well as
 * add in additional functionality.  If you just want to execute jobs normally, you
 * should instead be looking at {@link android.app.job.JobService JobService}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class JobServiceEngine {

/**
 * Create a new engine, ready for use.
 *
 * @param service The {@link android.app.Service Service} that is creating this engine and in which it will run.
 * @apiSince 26
 */

public JobServiceEngine(android.app.Service service) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the engine's IPC interface that should be returned by
 * {@link android.app.Service#onBind(android.content.Intent) Service#onBind(Intent)}.
 * @apiSince 26
 */

public final android.os.IBinder getBinder() { throw new RuntimeException("Stub!"); }

/**
 * Engine's report that a job has started.  See
 * {@link android.app.job.JobService#onStartJob(android.app.job.JobParameters) JobService#onStartJob(JobParameters)} for more information.
 * @apiSince 26
 */

public abstract boolean onStartJob(android.app.job.JobParameters params);

/**
 * Engine's report that a job has stopped.  See
 * {@link android.app.job.JobService#onStopJob(android.app.job.JobParameters) JobService#onStopJob(JobParameters)} for more information.
 * @apiSince 26
 */

public abstract boolean onStopJob(android.app.job.JobParameters params);

/**
 * Call in to engine to report that a job has finished executing.  See
 * {@link android.app.job.JobService#jobFinished(android.app.job.JobParameters,boolean) JobService#jobFinished(JobParameters, boolean)}  JobService.jobFinished} for more
 * information.
 * @apiSince 26
 */

public void jobFinished(android.app.job.JobParameters params, boolean needsReschedule) { throw new RuntimeException("Stub!"); }
}

