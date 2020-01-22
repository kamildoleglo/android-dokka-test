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

import java.io.PrintWriter;
import android.database.ContentObserver;

/**
 * A class that performs asynchronous loading of data. While Loaders are active
 * they should monitor the source of their data and deliver new results when the contents
 * change.  See {@link android.app.LoaderManager} for more detail.
 *
 * <p><b>Note on threading:</b> Clients of loaders should as a rule perform
 * any calls on to a Loader from the main thread of their process (that is,
 * the thread the Activity callbacks and other things occur on).  Subclasses
 * of Loader (such as {@link android.content.AsyncTaskLoader AsyncTaskLoader}) will often perform their work
 * in a separate thread, but when delivering their results this too should
 * be done on the main thread.</p>
 *
 * <p>Subclasses generally must implement at least {@link #onStartLoading()},
 * {@link #onStopLoading()}, {@link #onForceLoad()}, and {@link #onReset()}.</p>
 *
 * <p>Most implementations should not derive directly from this class, but
 * instead inherit from {@link android.content.AsyncTaskLoader AsyncTaskLoader}.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using loaders, read the
 * <a href="{@docRoot}guide/components/loaders.html">Loaders</a> developer guide.</p>
 * </div>
 *
 * @param <D> The result returned when the load is complete
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.content.Loader}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Loader<D> {

/**
 * Stores away the application context associated with context.
 * Since Loaders can be used across multiple activities it's dangerous to
 * store the context directly; always use {@link #getContext()} to retrieve
 * the Loader's Context, don't use the constructor argument directly.
 * The Context returned by {@link #getContext} is safe to use across
 * Activity instances.
 *
 * @param context used to retrieve the application context.
 * @apiSince 11
 */

@Deprecated
public Loader(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Sends the result of the load to the registered listener. Should only be called by subclasses.
 *
 * Must be called from the process's main thread.
 *
 * @param data the result of the load
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void deliverResult(D data) { throw new RuntimeException("Stub!"); }

/**
 * Informs the registered {@link android.content.Loader.OnLoadCanceledListener OnLoadCanceledListener} that the load has been canceled.
 * Should only be called by subclasses.
 *
 * Must be called from the process's main thread.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void deliverCancellation() { throw new RuntimeException("Stub!"); }

/**
 * @return an application context retrieved from the Context passed to the constructor.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * @return the ID of this loader
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Registers a class that will receive callbacks when a load is complete.
 * The callback will be called on the process's main thread so it's safe to
 * pass the results to widgets.
 *
 * <p>Must be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void registerListener(int id, android.content.Loader.OnLoadCompleteListener<D> listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a listener that was previously added with {@link #registerListener}.
 *
 * Must be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void unregisterListener(android.content.Loader.OnLoadCompleteListener<D> listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a listener that will receive callbacks when a load is canceled.
 * The callback will be called on the process's main thread so it's safe to
 * pass the results to widgets.
 *
 * Must be called from the process's main thread.
 *
 * @param listener The listener to register.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void registerOnLoadCanceledListener(android.content.Loader.OnLoadCanceledListener<D> listener) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a listener that was previously added with
 * {@link #registerOnLoadCanceledListener}.
 *
 * Must be called from the process's main thread.
 *
 * @param listener The listener to unregister.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void unregisterOnLoadCanceledListener(android.content.Loader.OnLoadCanceledListener<D> listener) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this load has been started.  That is, its {@link #startLoading()}
 * has been called and no calls to {@link #stopLoading()} or
 * {@link #reset()} have yet been made.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean isStarted() { throw new RuntimeException("Stub!"); }

/**
 * Return whether this loader has been abandoned.  In this state, the
 * loader <em>must not</em> report any new data, and <em>must</em> keep
 * its last reported data valid until it is finally reset.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean isAbandoned() { throw new RuntimeException("Stub!"); }

/**
 * Return whether this load has been reset.  That is, either the loader
 * has not yet been started for the first time, or its {@link #reset()}
 * has been called.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean isReset() { throw new RuntimeException("Stub!"); }

/**
 * This function will normally be called for you automatically by
 * {@link android.app.LoaderManager} when the associated fragment/activity
 * is being started.  When using a Loader with {@link android.app.LoaderManager},
 * you <em>must not</em> call this method yourself, or you will conflict
 * with its management of the Loader.
 *
 * Starts an asynchronous load of the Loader's data. When the result
 * is ready the callbacks will be called on the process's main thread.
 * If a previous load has been completed and is still valid
 * the result may be passed to the callbacks immediately.
 * The loader will monitor the source of
 * the data set and may deliver future callbacks if the source changes.
 * Calling {@link #stopLoading} will stop the delivery of callbacks.
 *
 * <p>This updates the Loader's internal state so that
 * {@link #isStarted()} and {@link #isReset()} will return the correct
 * values, and then calls the implementation's {@link #onStartLoading()}.
 *
 * <p>Must be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final void startLoading() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must implement this to take care of loading their data,
 * as per {@link #startLoading()}.  This is not called by clients directly,
 * but as a result of a call to {@link #startLoading()}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
protected void onStartLoading() { throw new RuntimeException("Stub!"); }

/**
 * Attempt to cancel the current load task.
 * Must be called on the main thread of the process.
 *
 * <p>Cancellation is not an immediate operation, since the load is performed
 * in a background thread.  If there is currently a load in progress, this
 * method requests that the load be canceled, and notes this is the case;
 * once the background thread has completed its work its remaining state
 * will be cleared.  If another load request comes in during this time,
 * it will be held until the canceled load is complete.
 *
 * @return Returns <tt>false</tt> if the task could not be canceled,
 * typically because it has already completed normally, or
 * because {@link #startLoading()} hasn't been called; returns
 * <tt>true</tt> otherwise.  When <tt>true</tt> is returned, the task
 * is still running and the {@link android.content.Loader.OnLoadCanceledListener OnLoadCanceledListener} will be called
 * when the task completes.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public boolean cancelLoad() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must implement this to take care of requests to {@link #cancelLoad()}.
 * This will always be called from the process's main thread.
 *
 * @return Returns <tt>false</tt> if the task could not be canceled,
 * typically because it has already completed normally, or
 * because {@link #startLoading()} hasn't been called; returns
 * <tt>true</tt> otherwise.  When <tt>true</tt> is returned, the task
 * is still running and the {@link android.content.Loader.OnLoadCanceledListener OnLoadCanceledListener} will be called
 * when the task completes.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
protected boolean onCancelLoad() { throw new RuntimeException("Stub!"); }

/**
 * Force an asynchronous load. Unlike {@link #startLoading()} this will ignore a previously
 * loaded data set and load a new one.  This simply calls through to the
 * implementation's {@link #onForceLoad()}.  You generally should only call this
 * when the loader is started -- that is, {@link #isStarted()} returns true.
 *
 * <p>Must be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void forceLoad() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must implement this to take care of requests to {@link #forceLoad()}.
 * This will always be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
protected void onForceLoad() { throw new RuntimeException("Stub!"); }

/**
 * This function will normally be called for you automatically by
 * {@link android.app.LoaderManager} when the associated fragment/activity
 * is being stopped.  When using a Loader with {@link android.app.LoaderManager},
 * you <em>must not</em> call this method yourself, or you will conflict
 * with its management of the Loader.
 *
 * <p>Stops delivery of updates until the next time {@link #startLoading()} is called.
 * Implementations should <em>not</em> invalidate their data at this point --
 * clients are still free to use the last data the loader reported.  They will,
 * however, typically stop reporting new data if the data changes; they can
 * still monitor for changes, but must not report them to the client until and
 * if {@link #startLoading()} is later called.
 *
 * <p>This updates the Loader's internal state so that
 * {@link #isStarted()} will return the correct
 * value, and then calls the implementation's {@link #onStopLoading()}.
 *
 * <p>Must be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void stopLoading() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must implement this to take care of stopping their loader,
 * as per {@link #stopLoading()}.  This is not called by clients directly,
 * but as a result of a call to {@link #stopLoading()}.
 * This will always be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
protected void onStopLoading() { throw new RuntimeException("Stub!"); }

/**
 * This function will normally be called for you automatically by
 * {@link android.app.LoaderManager} when restarting a Loader.  When using
 * a Loader with {@link android.app.LoaderManager},
 * you <em>must not</em> call this method yourself, or you will conflict
 * with its management of the Loader.
 *
 * Tell the Loader that it is being abandoned.  This is called prior
 * to {@link #reset} to have it retain its current data but not report
 * any new data.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void abandon() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses implement this to take care of being abandoned.  This is
 * an optional intermediate state prior to {@link #onReset()} -- it means that
 * the client is no longer interested in any new data from the loader,
 * so the loader must not report any further updates.  However, the
 * loader <em>must</em> keep its last reported data valid until the final
 * {@link #onReset()} happens.  You can retrieve the current abandoned
 * state with {@link #isAbandoned}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
protected void onAbandon() { throw new RuntimeException("Stub!"); }

/**
 * This function will normally be called for you automatically by
 * {@link android.app.LoaderManager} when destroying a Loader.  When using
 * a Loader with {@link android.app.LoaderManager},
 * you <em>must not</em> call this method yourself, or you will conflict
 * with its management of the Loader.
 *
 * Resets the state of the Loader.  The Loader should at this point free
 * all of its resources, since it may never be called again; however, its
 * {@link #startLoading()} may later be called at which point it must be
 * able to start running again.
 *
 * <p>This updates the Loader's internal state so that
 * {@link #isStarted()} and {@link #isReset()} will return the correct
 * values, and then calls the implementation's {@link #onReset()}.
 *
 * <p>Must be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must implement this to take care of resetting their loader,
 * as per {@link #reset()}.  This is not called by clients directly,
 * but as a result of a call to {@link #reset()}.
 * This will always be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
protected void onReset() { throw new RuntimeException("Stub!"); }

/**
 * Take the current flag indicating whether the loader's content had
 * changed while it was stopped.  If it had, true is returned and the
 * flag is cleared.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean takeContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * Commit that you have actually fully processed a content change that
 * was returned by {@link #takeContentChanged}.  This is for use with
 * {@link #rollbackContentChanged()} to handle situations where a load
 * is cancelled.  Call this when you have completely processed a load
 * without it being cancelled.
 * @apiSince 18
 * @deprecatedSince 28
 */

@Deprecated
public void commitContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * Report that you have abandoned the processing of a content change that
 * was returned by {@link #takeContentChanged()} and would like to rollback
 * to the state where there is again a pending content change.  This is
 * to handle the case where a data load due to a content change has been
 * canceled before its data was delivered back to the loader.
 * @apiSince 18
 * @deprecatedSince 28
 */

@Deprecated
public void rollbackContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * Called when {@link android.content.Loader.ForceLoadContentObserver ForceLoadContentObserver} detects a change.  The
 * default implementation checks to see if the loader is currently started;
 * if so, it simply calls {@link #forceLoad()}; otherwise, it sets a flag
 * so that {@link #takeContentChanged()} returns true.
 *
 * <p>Must be called from the process's main thread.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * For debugging, converts an instance of the Loader's data class to
 * a string that can be printed.  Must handle a null data.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.String dataToString(D data) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Print the Loader's state into the given stream.
 *
 * @param prefix Text to print at the front of each line.
 * @param fd The raw file descriptor that the dump is being sent to.
 * @param writer A PrintWriter to which the dump is to be set.
 * @param args Additional arguments to the dump request.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
/**
 * An implementation of a ContentObserver that takes care of connecting
 * it to the Loader to have the loader re-load its data when the observer
 * is told it has changed.  You do not normally need to use this yourself;
 * it is used for you by {@link android.content.CursorLoader CursorLoader} to take care of executing
 * an update when the cursor's backing data changes.
 *
 * @deprecated Use {@link android.support.v4.content.Loader.ForceLoadContentObserver}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class ForceLoadContentObserver extends android.database.ContentObserver {

@Deprecated
public ForceLoadContentObserver() { super(null); throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean deliverSelfNotifications() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onChange(boolean selfChange) { throw new RuntimeException("Stub!"); }
}

/**
 * Interface that is implemented to discover when a Loader has been canceled
 * before it finished loading its data.  You do not normally need to implement
 * this yourself; it is used in the implementation of {@link android.app.LoaderManager}
 * to find out when a Loader it is managing has been canceled so that it
 * can schedule the next Loader.  This interface should only be used if a
 * Loader is not being used in conjunction with LoaderManager.
 *
 * @deprecated Use {@link android.support.v4.content.Loader.OnLoadCanceledListener}
 * @apiSince 16
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnLoadCanceledListener<D> {

/**
 * Called on the thread that created the Loader when the load is canceled.
 *
 * @param loader the loader that canceled the load
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void onLoadCanceled(android.content.Loader<D> loader);
}

/**
 * Interface that is implemented to discover when a Loader has finished
 * loading its data.  You do not normally need to implement this yourself;
 * it is used in the implementation of {@link android.app.LoaderManager}
 * to find out when a Loader it is managing has completed so that this can
 * be reported to its client.  This interface should only be used if a
 * Loader is not being used in conjunction with LoaderManager.
 *
 * @deprecated Use {@link android.support.v4.content.Loader.OnLoadCompleteListener}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnLoadCompleteListener<D> {

/**
 * Called on the thread that created the Loader when the load is complete.
 *
 * @param loader the loader that completed the load
 * @param data the result of the load
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onLoadComplete(android.content.Loader<D> loader, D data);
}

}

