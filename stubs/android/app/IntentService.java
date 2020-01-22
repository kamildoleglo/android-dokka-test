/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.app;

import android.content.Intent;

/**
 * IntentService is a base class for {@link android.app.Service Service}s that handle asynchronous
 * requests (expressed as {@link android.content.Intent Intent}s) on demand.  Clients send requests
 * through {@link android.content.Context#startService(Intent)} calls; the
 * service is started as needed, handles each Intent in turn using a worker
 * thread, and stops itself when it runs out of work.
 *
 * <p>This "work queue processor" pattern is commonly used to offload tasks
 * from an application's main thread.  The IntentService class exists to
 * simplify this pattern and take care of the mechanics.  To use it, extend
 * IntentService and implement {@link #onHandleIntent(android.content.Intent)}.  IntentService
 * will receive the Intents, launch a worker thread, and stop the service as
 * appropriate.
 *
 * <p>All requests are handled on a single worker thread -- they may take as
 * long as necessary (and will not block the application's main loop), but
 * only one request will be processed at a time.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For a detailed discussion about how to create services, read the
 * <a href="{@docRoot}guide/components/services.html">Services</a> developer
 * guide.</p>
 * </div>
 *
 * @see android.support.v4.app.JobIntentService
 *
 * @deprecated IntentService is subject to all the
 *   <a href="/preview/features/background.html">background execution limits</a>
 *   imposed with Android 8.0 (API level 26). Consider using {@link androidx.work.WorkManager}
 *   or {@link androidx.core.app.JobIntentService}, which uses jobs
 *   instead of services when running on Android 8.0 or higher.
 * @apiSince 3
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class IntentService extends android.app.Service {

/**
 * Creates an IntentService.  Invoked by your subclass's constructor.
 *
 * @param name Used to name the worker thread, important only for debugging.
 * @apiSince 3
 */

@Deprecated
public IntentService(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets intent redelivery preferences.  Usually called from the constructor
 * with your preferred semantics.
 *
 * <p>If enabled is true,
 * {@link #onStartCommand(android.content.Intent,int,int)} will return
 * {@link android.app.Service#START_REDELIVER_INTENT Service#START_REDELIVER_INTENT}, so if this process dies before
 * {@link #onHandleIntent(android.content.Intent)} returns, the process will be restarted
 * and the intent redelivered.  If multiple Intents have been sent, only
 * the most recent one is guaranteed to be redelivered.
 *
 * <p>If enabled is false (the default),
 * {@link #onStartCommand(android.content.Intent,int,int)} will return
 * {@link android.app.Service#START_NOT_STICKY Service#START_NOT_STICKY}, and if the process dies, the Intent
 * dies along with it.
 * @apiSince 5
 * @deprecatedSince R
 */

@Deprecated
public void setIntentRedelivery(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince R
 */

@Deprecated
public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param intent This value may be {@code null}.
 * @apiSince 3
 * @deprecatedSince R
 */

@Deprecated
public void onStart(@androidx.annotation.Nullable android.content.Intent intent, int startId) { throw new RuntimeException("Stub!"); }

/**
 * You should not override this method for your IntentService. Instead,
 * override {@link #onHandleIntent}, which the system calls when the IntentService
 * receives a start request.
 * @see android.app.Service#onStartCommand
 
 * @param intent This value may be {@code null}.
 * @apiSince 5
 * @deprecatedSince R
 */

@Deprecated
public int onStartCommand(@androidx.annotation.Nullable android.content.Intent intent, int flags, int startId) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince R
 */

@Deprecated
public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Unless you provide binding for your service, you don't need to implement this
 * method, because the default implementation returns null.
 * @see android.app.Service#onBind
 * @apiSince 3
 * @deprecatedSince R
 */

@Deprecated
@androidx.annotation.Nullable
public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked on the worker thread with a request to process.
 * Only one Intent is processed at a time, but the processing happens on a
 * worker thread that runs independently from other application logic.
 * So, if this code takes a long time, it will hold up other requests to
 * the same IntentService, but it will not hold up anything else.
 * When all requests have been handled, the IntentService stops itself,
 * so you should not call {@link #stopSelf}.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param intent The value passed to {@link
 *               android.content.Context#startService(Intent)}.
 *               This may be null if the service is being restarted after
 *               its process has gone away; see
 *               {@link android.app.Service#onStartCommand}
 *               for details.
 
 * This value may be {@code null}.
 * @apiSince 3
 * @deprecatedSince R
 */

@Deprecated
protected abstract void onHandleIntent(@androidx.annotation.Nullable android.content.Intent intent);
}

