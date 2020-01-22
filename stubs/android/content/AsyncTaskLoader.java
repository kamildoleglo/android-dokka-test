/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.content;

import android.os.AsyncTask;
import android.os.OperationCanceledException;

/**
 * Abstract Loader that provides an {@link android.os.AsyncTask AsyncTask} to do the work.  See
 * {@link android.content.Loader Loader} and {@link android.app.LoaderManager} for more details.
 *
 * <p>Here is an example implementation of an AsyncTaskLoader subclass that
 * loads the currently installed applications from the package manager.  This
 * implementation takes care of retrieving the application labels and sorting
 * its result set from them, monitoring for changes to the installed
 * applications, and rebuilding the list when a change in configuration requires
 * this (such as a locale change).
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/LoaderCustom.java
 *      loader}
 *
 * <p>An example implementation of a fragment that uses the above loader to show
 * the currently installed applications in a list is below.
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/LoaderCustom.java
 *      fragment}
 *
 * @param <D> the data type to be loaded.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.content.AsyncTaskLoader}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class AsyncTaskLoader<D> extends android.content.Loader<D> {

/** @apiSince 11 */

@Deprecated
public AsyncTaskLoader(android.content.Context context) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Set amount to throttle updates by.  This is the minimum time from
 * when the last {@link #loadInBackground()} call has completed until
 * a new load is scheduled.
 *
 * @param delayMS Amount of delay, in milliseconds.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setUpdateThrottle(long delayMS) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
protected void onForceLoad() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
protected boolean onCancelLoad() { throw new RuntimeException("Stub!"); }

/**
 * Called if the task was canceled before it was completed.  Gives the class a chance
 * to clean up post-cancellation and to properly dispose of the result.
 *
 * @param data The value that was returned by {@link #loadInBackground}, or null
 * if the task threw {@link android.os.OperationCanceledException OperationCanceledException}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onCanceled(D data) { throw new RuntimeException("Stub!"); }

/**
 * Called on a worker thread to perform the actual load and to return
 * the result of the load operation.
 *
 * Implementations should not deliver the result directly, but should return them
 * from this method, which will eventually end up calling {@link #deliverResult} on
 * the UI thread.  If implementations need to process the results on the UI thread
 * they may override {@link #deliverResult} and do so there.
 *
 * To support cancellation, this method should periodically check the value of
 * {@link #isLoadInBackgroundCanceled} and terminate when it returns true.
 * Subclasses may also override {@link #cancelLoadInBackground} to interrupt the load
 * directly instead of polling {@link #isLoadInBackgroundCanceled}.
 *
 * When the load is canceled, this method may either return normally or throw
 * {@link android.os.OperationCanceledException OperationCanceledException}.  In either case, the {@link android.content.Loader Loader} will
 * call {@link #onCanceled} to perform post-cancellation cleanup and to dispose of the
 * result object, if any.
 *
 * @return The result of the load operation.
 *
 * @throws android.os.OperationCanceledException if the load is canceled during execution.
 *
 * @see #isLoadInBackgroundCanceled
 * @see #cancelLoadInBackground
 * @see #onCanceled
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract D loadInBackground();

/**
 * Calls {@link #loadInBackground()}.
 *
 * This method is reserved for use by the loader framework.
 * Subclasses should override {@link #loadInBackground} instead of this method.
 *
 * @return The result of the load operation.
 *
 * @throws android.os.OperationCanceledException if the load is canceled during execution.
 *
 * @see #loadInBackground
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
protected D onLoadInBackground() { throw new RuntimeException("Stub!"); }

/**
 * Called on the main thread to abort a load in progress.
 *
 * Override this method to abort the current invocation of {@link #loadInBackground}
 * that is running in the background on a worker thread.
 *
 * This method should do nothing if {@link #loadInBackground} has not started
 * running or if it has already finished.
 *
 * @see #loadInBackground
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void cancelLoadInBackground() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current invocation of {@link #loadInBackground} is being canceled.
 *
 * @return True if the current invocation of {@link #loadInBackground} is being canceled.
 *
 * @see #loadInBackground
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public boolean isLoadInBackgroundCanceled() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
}

