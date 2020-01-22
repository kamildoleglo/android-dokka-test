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


package android.app;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.KeyEvent;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.content.pm.ActivityInfo;
import android.os.TestLooperManager;

/**
 * Base class for implementing application instrumentation code.  When running
 * with instrumentation turned on, this class will be instantiated for you
 * before any of the application code, allowing you to monitor all of the
 * interaction the system has with the application.  An Instrumentation
 * implementation is described to the system through an AndroidManifest.xml's
 * &lt;instrumentation&gt; tag.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Instrumentation {

/** @apiSince 1 */

public Instrumentation() { throw new RuntimeException("Stub!"); }

/**
 * Called when the instrumentation is starting, before any application code
 * has been loaded.  Usually this will be implemented to simply call
 * {@link #start} to begin the instrumentation thread, which will then
 * continue execution in {@link #onStart}.
 *
 * <p>If you do not need your own thread -- that is you are writing your
 * instrumentation to be completely asynchronous (returning to the event
 * loop so that the application can run), you can simply begin your
 * instrumentation here, for example call {@link android.content.Context#startActivity Context#startActivity} to
 * begin the appropriate first activity of the application.
 *
 * @param arguments Any additional arguments that were supplied when the
 *                  instrumentation was started.
 * @apiSince 1
 */

public void onCreate(android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/**
 * Create and start a new thread in which to run instrumentation.  This new
 * thread will call to {@link #onStart} where you can implement the
 * instrumentation.
 * @apiSince 1
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Method where the instrumentation thread enters execution.  This allows
 * you to run your instrumentation code in a separate thread than the
 * application, so that it can perform blocking operation such as
 * {@link #sendKeySync} or {@link #startActivitySync}.
 *
 * <p>You will typically want to call finish() when this function is done,
 * to end your instrumentation.
 * @apiSince 1
 */

public void onStart() { throw new RuntimeException("Stub!"); }

/**
 * This is called whenever the system captures an unhandled exception that
 * was thrown by the application.  The default implementation simply
 * returns false, allowing normal system handling of the exception to take
 * place.
 *
 * @param obj The client object that generated the exception.  May be an
 *            Application, Activity, BroadcastReceiver, Service, or null.
 * @param e The exception that was thrown.
 *
 * @return To allow normal system exception process to occur, return false.
 *         If true is returned, the system will proceed as if the exception
 *         didn't happen.
 * @apiSince 1
 */

public boolean onException(java.lang.Object obj, java.lang.Throwable e) { throw new RuntimeException("Stub!"); }

/**
 * Provide a status report about the application.
 *
 * @param resultCode Current success/failure of instrumentation.
 * @param results Any results to send back to the code that started the instrumentation.
 * @apiSince 1
 */

public void sendStatus(int resultCode, android.os.Bundle results) { throw new RuntimeException("Stub!"); }

/**
 * Report some results in the middle of instrumentation execution.  Later results (including
 * those provided by {@link #finish}) will be combined with {@link android.os.Bundle#putAll Bundle#putAll}.
 * @apiSince 26
 */

public void addResults(android.os.Bundle results) { throw new RuntimeException("Stub!"); }

/**
 * Terminate instrumentation of the application.  This will cause the
 * application process to exit, removing this instrumentation from the next
 * time the application is started.  If multiple processes are currently running
 * for this instrumentation, all of those processes will be killed.
 *
 * @param resultCode Overall success/failure of instrumentation.
 * @param results Any results to send back to the code that started the
 *                instrumentation.
 * @apiSince 1
 */

public void finish(int resultCode, android.os.Bundle results) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setAutomaticPerformanceSnapshots() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void startPerformanceSnapshot() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void endPerformanceSnapshot() { throw new RuntimeException("Stub!"); }

/**
 * Called when the instrumented application is stopping, after all of the
 * normal application cleanup has occurred.
 * @apiSince 1
 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Return the Context of this instrumentation's package.  Note that this is
 * often different than the Context of the application being
 * instrumentated, since the instrumentation code often lives is a
 * different package than that of the application it is running against.
 * See {@link #getTargetContext} to retrieve a Context for the target
 * application.
 *
 * @return The instrumentation's package context.
 *
 * @see #getTargetContext
 * @apiSince 1
 */

public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns complete component name of this instrumentation.
 *
 * @return Returns the complete component name for this instrumentation.
 * @apiSince 1
 */

public android.content.ComponentName getComponentName() { throw new RuntimeException("Stub!"); }

/**
 * Return a Context for the target application being instrumented.  Note
 * that this is often different than the Context of the instrumentation
 * code, since the instrumentation code often lives is a different package
 * than that of the application it is running against. See
 * {@link #getContext} to retrieve a Context for the instrumentation code.
 *
 * @return A Context in the target application.
 *
 * @see #getContext
 * @apiSince 1
 */

public android.content.Context getTargetContext() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the process this instrumentation is running in.  Note this should
 * only be used for testing and debugging.  If you are thinking about using this to,
 * for example, conditionalize what is initialized in an Application class, it is strongly
 * recommended to instead use lazy initialization (such as a getter for the state that
 * only creates it when requested).  This can greatly reduce the work your process does
 * when created for secondary things, such as to receive a broadcast.
 * @apiSince 26
 */

public java.lang.String getProcessName() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this instrumentation was started with profiling enabled.
 *
 * @return Returns true if profiling was enabled when starting, else false.
 * @apiSince 1
 */

public boolean isProfiling() { throw new RuntimeException("Stub!"); }

/**
 * This method will start profiling if isProfiling() returns true. You should
 * only call this method if you set the handleProfiling attribute in the
 * manifest file for this Instrumentation to true.
 * @apiSince 1
 */

public void startProfiling() { throw new RuntimeException("Stub!"); }

/**
 * Stops profiling if isProfiling() returns true.
 * @apiSince 1
 */

public void stopProfiling() { throw new RuntimeException("Stub!"); }

/**
 * Force the global system in or out of touch mode.  This can be used if
 * your instrumentation relies on the UI being in one more or the other
 * when it starts.
 *
 * @param inTouch Set to true to be in touch mode, false to be in
 * focus mode.
 * @apiSince 1
 */

public void setInTouchMode(boolean inTouch) { throw new RuntimeException("Stub!"); }

/**
 * Schedule a callback for when the application's main thread goes idle
 * (has no more events to process).
 *
 * @param recipient Called the next time the thread's message queue is
 *                  idle.
 * @apiSince 1
 */

public void waitForIdle(java.lang.Runnable recipient) { throw new RuntimeException("Stub!"); }

/**
 * Synchronously wait for the application to be idle.  Can not be called
 * from the main application thread -- use {@link #start} to execute
 * instrumentation in its own thread.
 * @apiSince 1
 */

public void waitForIdleSync() { throw new RuntimeException("Stub!"); }

/**
 * Execute a call on the application's main thread, blocking until it is
 * complete.  Useful for doing things that are not thread-safe, such as
 * looking at or modifying the view hierarchy.
 *
 * @param runner The code to run on the main thread.
 * @apiSince 1
 */

public void runOnMainSync(java.lang.Runnable runner) { throw new RuntimeException("Stub!"); }

/**
 * Start a new activity and wait for it to begin running before returning.
 * In addition to being synchronous, this method as some semantic
 * differences from the standard {@link android.content.Context#startActivity Context#startActivity} call: the
 * activity component is resolved before talking with the activity manager
 * (its class name is specified in the Intent that this method ultimately
 * starts), and it does not allow you to start activities that run in a
 * different process.  In addition, if the given Intent resolves to
 * multiple activities, instead of displaying a dialog for the user to
 * select an activity, an exception will be thrown.
 *
 * <p>The function returns as soon as the activity goes idle following the
 * call to its {@link android.app.Activity#onCreate Activity#onCreate}.  Generally this means it has gone
 * through the full initialization including {@link android.app.Activity#onResume Activity#onResume} and
 * drawn and displayed its initial window.
 *
 * @param intent Description of the activity to start.
 *
 * @see Context#startActivity
 * @see #startActivitySync(Intent, Bundle)
 * @apiSince 1
 */

public android.app.Activity startActivitySync(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Start a new activity and wait for it to begin running before returning.
 * In addition to being synchronous, this method as some semantic
 * differences from the standard {@link android.content.Context#startActivity Context#startActivity} call: the
 * activity component is resolved before talking with the activity manager
 * (its class name is specified in the Intent that this method ultimately
 * starts), and it does not allow you to start activities that run in a
 * different process.  In addition, if the given Intent resolves to
 * multiple activities, instead of displaying a dialog for the user to
 * select an activity, an exception will be thrown.
 *
 * <p>The function returns as soon as the activity goes idle following the
 * call to its {@link android.app.Activity#onCreate Activity#onCreate}.  Generally this means it has gone
 * through the full initialization including {@link android.app.Activity#onResume Activity#onResume} and
 * drawn and displayed its initial window.
 *
 * @param intent Description of the activity to start.
 * This value must never be {@code null}.
 * @param options Additional options for how the Activity should be started.
 * May be null if there are no options.  See {@link android.app.ActivityOptions}
 * for how to build the Bundle supplied here; there are no supported definitions
 * for building it manually.
 *
 * This value may be {@code null}.
 * @see android.content.Context#startActivity(Intent, Bundle)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.app.Activity startActivitySync(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Add a new {@link android.app.Instrumentation.ActivityMonitor ActivityMonitor} that will be checked whenever an
 * activity is started.  The monitor is added
 * after any existing ones; the monitor will be hit only if none of the
 * existing monitors can themselves handle the Intent.
 *
 * @param monitor The new ActivityMonitor to see.
 *
 * @see #addMonitor(IntentFilter, ActivityResult, boolean)
 * @see #checkMonitorHit
 * @apiSince 1
 */

public void addMonitor(android.app.Instrumentation.ActivityMonitor monitor) { throw new RuntimeException("Stub!"); }

/**
 * A convenience wrapper for {@link #addMonitor(android.app.Instrumentation.ActivityMonitor)} that
 * creates an intent filter matching {@link android.app.Instrumentation.ActivityMonitor ActivityMonitor} for you and
 * returns it.
 *
 * @param filter The set of intents this monitor is responsible for.
 * @param result A canned result to return if the monitor is hit; can
 *               be null.
 * @param block Controls whether the monitor should block the activity
 *              start (returning its canned result) or let the call
 *              proceed.
 *
 * @return The newly created and added activity monitor.
 *
 * @see #addMonitor(ActivityMonitor)
 * @see #checkMonitorHit
 * @apiSince 1
 */

public android.app.Instrumentation.ActivityMonitor addMonitor(android.content.IntentFilter filter, android.app.Instrumentation.ActivityResult result, boolean block) { throw new RuntimeException("Stub!"); }

/**
 * A convenience wrapper for {@link #addMonitor(android.app.Instrumentation.ActivityMonitor)} that
 * creates a class matching {@link android.app.Instrumentation.ActivityMonitor ActivityMonitor} for you and returns it.
 *
 * @param cls The activity class this monitor is responsible for.
 * @param result A canned result to return if the monitor is hit; can
 *               be null.
 * @param block Controls whether the monitor should block the activity
 *              start (returning its canned result) or let the call
 *              proceed.
 *
 * @return The newly created and added activity monitor.
 *
 * @see #addMonitor(ActivityMonitor)
 * @see #checkMonitorHit
 * @apiSince 1
 */

public android.app.Instrumentation.ActivityMonitor addMonitor(java.lang.String cls, android.app.Instrumentation.ActivityResult result, boolean block) { throw new RuntimeException("Stub!"); }

/**
 * Test whether an existing {@link android.app.Instrumentation.ActivityMonitor ActivityMonitor} has been hit.  If the
 * monitor has been hit at least <var>minHits</var> times, then it will be
 * removed from the activity monitor list and true returned.  Otherwise it
 * is left as-is and false is returned.
 *
 * @param monitor The ActivityMonitor to check.
 * @param minHits The minimum number of hits required.
 *
 * @return True if the hit count has been reached, else false.
 *
 * @see #addMonitor
 * @apiSince 1
 */

public boolean checkMonitorHit(android.app.Instrumentation.ActivityMonitor monitor, int minHits) { throw new RuntimeException("Stub!"); }

/**
 * Wait for an existing {@link android.app.Instrumentation.ActivityMonitor ActivityMonitor} to be hit.  Once the
 * monitor has been hit, it is removed from the activity monitor list and
 * the first created Activity object that matched it is returned.
 *
 * @param monitor The ActivityMonitor to wait for.
 *
 * @return The Activity object that matched the monitor.
 * @apiSince 1
 */

public android.app.Activity waitForMonitor(android.app.Instrumentation.ActivityMonitor monitor) { throw new RuntimeException("Stub!"); }

/**
 * Wait for an existing {@link android.app.Instrumentation.ActivityMonitor ActivityMonitor} to be hit till the timeout
 * expires.  Once the monitor has been hit, it is removed from the activity
 * monitor list and the first created Activity object that matched it is
 * returned.  If the timeout expires, a null object is returned.
 *
 * @param monitor The ActivityMonitor to wait for.
 * @param timeOut The timeout value in milliseconds.
 *
 * @return The Activity object that matched the monitor.
 * @apiSince 1
 */

public android.app.Activity waitForMonitorWithTimeout(android.app.Instrumentation.ActivityMonitor monitor, long timeOut) { throw new RuntimeException("Stub!"); }

/**
 * Remove an {@link android.app.Instrumentation.ActivityMonitor ActivityMonitor} that was previously added with
 * {@link #addMonitor}.
 *
 * @param monitor The monitor to remove.
 *
 * @see #addMonitor
 * @apiSince 1
 */

public void removeMonitor(android.app.Instrumentation.ActivityMonitor monitor) { throw new RuntimeException("Stub!"); }

/**
 * Execute a particular menu item.
 *
 * @param targetActivity The activity in question.
 * @param id The identifier associated with the menu item.
 * @param flag Additional flags, if any.
 * @return Whether the invocation was successful (for example, it could be
 *         false if item is disabled).
 * @apiSince 1
 */

public boolean invokeMenuActionSync(android.app.Activity targetActivity, int id, int flag) { throw new RuntimeException("Stub!"); }

/**
 * Show the context menu for the currently focused view and executes a
 * particular context menu item.
 *
 * @param targetActivity The activity in question.
 * @param id The identifier associated with the context menu item.
 * @param flag Additional flags, if any.
 * @return Whether the invocation was successful (for example, it could be
 *         false if item is disabled).
 * @apiSince 1
 */

public boolean invokeContextMenuAction(android.app.Activity targetActivity, int id, int flag) { throw new RuntimeException("Stub!"); }

/**
 * Sends the key events corresponding to the text to the app being
 * instrumented.
 *
 * @param text The text to be sent.
 * @apiSince 1
 */

public void sendStringSync(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Send a key event to the currently focused window/view and wait for it to
 * be processed.  Finished at some point after the recipient has returned
 * from its event processing, though it may <em>not</em> have completely
 * finished reacting from the event -- for example, if it needs to update
 * its display as a result, it may still be in the process of doing that.
 *
 * @param event The event to send to the current focus.
 * @apiSince 1
 */

public void sendKeySync(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Sends an up and down key event sync to the currently focused window.
 *
 * @param key The integer keycode for the event.
 * @apiSince 1
 */

public void sendKeyDownUpSync(int key) { throw new RuntimeException("Stub!"); }

/**
 * Higher-level method for sending both the down and up key events for a
 * particular character key code.  Equivalent to creating both KeyEvent
 * objects by hand and calling {@link #sendKeySync}.  The event appears
 * as if it came from keyboard 0, the built in one.
 *
 * @param keyCode The key code of the character to send.
 * @apiSince 1
 */

public void sendCharacterSync(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a pointer event. Finished at some point after the recipient has
 * returned from its event processing, though it may <em>not</em> have
 * completely finished reacting from the event -- for example, if it needs
 * to update its display as a result, it may still be in the process of
 * doing that.
 *
 * @param event A motion event describing the pointer action.  (As noted in
 * {@link android.view.MotionEvent#obtain(long,long,int,float,float,int) MotionEvent#obtain(long, long, int, float, float, int)}, be sure to use
 * {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()} as the timebase.
 * @apiSince 1
 */

public void sendPointerSync(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a trackball event. Finished at some point after the recipient has
 * returned from its event processing, though it may <em>not</em> have
 * completely finished reacting from the event -- for example, if it needs
 * to update its display as a result, it may still be in the process of
 * doing that.
 *
 * @param event A motion event describing the trackball action.  (As noted in
 * {@link android.view.MotionEvent#obtain(long,long,int,float,float,int) MotionEvent#obtain(long, long, int, float, float, int)}, be sure to use
 * {@link android.os.SystemClock#uptimeMillis() SystemClock#uptimeMillis()} as the timebase.
 * @apiSince 1
 */

public void sendTrackballEventSync(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Perform instantiation of the process's {@link android.app.Application Application} object.  The
 * default implementation provides the normal system behavior.
 *
 * @param cl The ClassLoader with which to instantiate the object.
 * @param className The name of the class implementing the Application
 *                  object.
 * @param context The context to initialize the application with
 *
 * @return The newly instantiated Application object.
 * @apiSince 1
 */

public android.app.Application newApplication(java.lang.ClassLoader cl, java.lang.String className, android.content.Context context) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Perform instantiation of the process's {@link android.app.Application Application} object.  The
 * default implementation provides the normal system behavior.
 *
 * @param clazz The class used to create an Application object from.
 * @param context The context to initialize the application with
 *
 * @return The newly instantiated Application object.
 * @apiSince 1
 */

public static android.app.Application newApplication(java.lang.Class<?> clazz, android.content.Context context) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of the application's {@link android.app.Application#onCreate Application#onCreate}
 * method.  The default implementation simply calls through to that method.
 *
 * <p>Note: This method will be called immediately after {@link #onCreate(android.os.Bundle)}.
 * Often instrumentation tests start their test thread in onCreate(); you
 * need to be careful of races between these.  (Well between it and
 * everything else, but let's start here.)
 *
 * @param app The application being created.
 * @apiSince 1
 */

public void callApplicationOnCreate(android.app.Application app) { throw new RuntimeException("Stub!"); }

/**
 * Perform instantiation of an {@link android.app.Activity Activity} object.  This method is intended for use with
 * unit tests, such as android.test.ActivityUnitTestCase.  The activity will be useable
 * locally but will be missing some of the linkages necessary for use within the system.
 *
 * @param clazz The Class of the desired Activity
 * @param context The base context for the activity to use
 * @param token The token for this activity to communicate with
 * @param application The application object (if any)
 * @param intent The intent that started this Activity
 * @param info ActivityInfo from the manifest
 * @param title The title, typically retrieved from the ActivityInfo record
 * @param parent The parent Activity (if any)
 * @param id The embedded Id (if any)
 * @param lastNonConfigurationInstance Arbitrary object that will be
 * available via {@link android.app.Activity#getLastNonConfigurationInstance() Activity#getLastNonConfigurationInstance()}.
 * @return Returns the instantiated activity
 * @throws java.lang.InstantiationException
 * @throws java.lang.IllegalAccessException
 * @apiSince 1
 */

public android.app.Activity newActivity(java.lang.Class<?> clazz, android.content.Context context, android.os.IBinder token, android.app.Application application, android.content.Intent intent, android.content.pm.ActivityInfo info, java.lang.CharSequence title, android.app.Activity parent, java.lang.String id, java.lang.Object lastNonConfigurationInstance) throws java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Perform instantiation of the process's {@link android.app.Activity Activity} object.  The
 * default implementation provides the normal system behavior.
 *
 * @param cl The ClassLoader with which to instantiate the object.
 * @param className The name of the class implementing the Activity
 *                  object.
 * @param intent The Intent object that specified the activity class being
 *               instantiated.
 *
 * @return The newly instantiated Activity object.
 * @apiSince 1
 */

public android.app.Activity newActivity(java.lang.ClassLoader cl, java.lang.String className, android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onCreate Activity#onCreate}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity being created.
 * @param icicle The previously frozen state (or null) to pass through to onCreate().
 * @apiSince 1
 */

public void callActivityOnCreate(android.app.Activity activity, android.os.Bundle icicle) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onCreate Activity#onCreate}
 * method.  The default implementation simply calls through to that method.
 *  @param activity The activity being created.
 * @param icicle The previously frozen state (or null) to pass through to
 * @param persistentState The previously persisted state (or null)
 * @apiSince 21
 */

public void callActivityOnCreate(android.app.Activity activity, android.os.Bundle icicle, android.os.PersistableBundle persistentState) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void callActivityOnDestroy(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onRestoreInstanceState Activity#onRestoreInstanceState}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity being restored.
 * This value must never be {@code null}.
 * @param savedInstanceState The previously saved state being restored.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void callActivityOnRestoreInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onRestoreInstanceState Activity#onRestoreInstanceState}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity being restored.
 * This value must never be {@code null}.
 * @param savedInstanceState The previously saved state being restored (or null).
 * This value may be {@code null}.
 * @param persistentState The previously persisted state (or null)
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void callActivityOnRestoreInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle savedInstanceState, @androidx.annotation.Nullable android.os.PersistableBundle persistentState) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onPostCreate Activity#onPostCreate} method.
 * The default implementation simply calls through to that method.
 *
 * @param activity The activity being created.
 * This value must never be {@code null}.
 * @param savedInstanceState The previously saved state (or null) to pass through to
 *               onPostCreate().
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void callActivityOnPostCreate(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onPostCreate Activity#onPostCreate} method.
 * The default implementation simply calls through to that method.
 *
 * @param activity The activity being created.
 * This value must never be {@code null}.
 * @param savedInstanceState The previously frozen state (or null) to pass through to
 *               onPostCreate().
 * This value may be {@code null}.
 * @param persistentState The previously persisted state (or null)
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void callActivityOnPostCreate(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle savedInstanceState, @androidx.annotation.Nullable android.os.PersistableBundle persistentState) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onNewIntent Activity#onNewIntent}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity receiving a new Intent.
 * @param intent The new intent being received.
 * @apiSince 1
 */

public void callActivityOnNewIntent(android.app.Activity activity, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onStart Activity#onStart}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity being started.
 * @apiSince 1
 */

public void callActivityOnStart(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onRestart Activity#onRestart}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity being restarted.
 * @apiSince 1
 */

public void callActivityOnRestart(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onResume Activity#onResume} method.  The
 * default implementation simply calls through to that method.
 *
 * @param activity The activity being resumed.
 * @apiSince 1
 */

public void callActivityOnResume(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onStop Activity#onStop}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity being stopped.
 * @apiSince 1
 */

public void callActivityOnStop(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onSaveInstanceState Activity#onSaveInstanceState}
 * method.  The default implementation simply calls through to that method.
 *
 * @param activity The activity being saved.
 * This value must never be {@code null}.
 * @param outState The bundle to pass to the call.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void callActivityOnSaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onSaveInstanceState Activity#onSaveInstanceState}
 * method.  The default implementation simply calls through to that method.
 *  @param activity The activity being saved.
 * This value must never be {@code null}.
 * @param outState The bundle to pass to the call.
 * This value must never be {@code null}.
 * @param outPersistentState The persistent bundle to pass to the call.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void callActivityOnSaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle outState, @androidx.annotation.NonNull android.os.PersistableBundle outPersistentState) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onPause Activity#onPause} method.  The
 * default implementation simply calls through to that method.
 *
 * @param activity The activity being paused.
 * @apiSince 1
 */

public void callActivityOnPause(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Perform calling of an activity's {@link android.app.Activity#onUserLeaveHint Activity#onUserLeaveHint} method.
 * The default implementation simply calls through to that method.
 *
 * @param activity The activity being notified that the user has navigated away
 * @apiSince 3
 */

public void callActivityOnUserLeaving(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void startAllocCounting() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void stopAllocCounting() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bundle with the current results from the allocation counting.
 * @apiSince 1
 */

public android.os.Bundle getAllocCounts() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bundle with the counts for various binder counts for this process. Currently the only two that are
 * reported are the number of send and the number of received transactions.
 * @apiSince 1
 */

public android.os.Bundle getBinderCounts() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.app.UiAutomation UiAutomation} instance with no flags set.
 * <p>
 * <strong>Note:</strong> The APIs exposed via the returned {@link android.app.UiAutomation UiAutomation}
 * work across application boundaries while the APIs exposed by the instrumentation
 * do not. For example, {@link android.app.Instrumentation#sendPointerSync(android.view.MotionEvent) Instrumentation#sendPointerSync(MotionEvent)} will
 * not allow you to inject the event in an app different from the instrumentation
 * target, while {@link android.app.UiAutomation#injectInputEvent(android.view.InputEvent,boolean) UiAutomation#injectInputEvent(android.view.InputEvent, boolean)}
 * will work regardless of the current application.
 * </p>
 * <p>
 * A typical test case should be using either the {@link android.app.UiAutomation UiAutomation} or
 * {@link android.app.Instrumentation Instrumentation} APIs. Using both APIs at the same time is not
 * a mistake by itself but a client has to be aware of the APIs limitations.
 * </p>
 * <p>
 * Equivalent to {@code getUiAutomation(0)}. If a {@link android.app.UiAutomation UiAutomation} exists with different
 * flags, the flags on that instance will be changed, and then it will be returned.
 * </p>
 * @return The UI automation instance.
 *
 * @see android.app.UiAutomation
 * @apiSince 18
 */

public android.app.UiAutomation getUiAutomation() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.app.UiAutomation UiAutomation} instance with flags set.
 * <p>
 * <strong>Note:</strong> The APIs exposed via the returned {@link android.app.UiAutomation UiAutomation}
 * work across application boundaries while the APIs exposed by the instrumentation
 * do not. For example, {@link android.app.Instrumentation#sendPointerSync(android.view.MotionEvent) Instrumentation#sendPointerSync(MotionEvent)} will
 * not allow you to inject the event in an app different from the instrumentation
 * target, while {@link android.app.UiAutomation#injectInputEvent(android.view.InputEvent,boolean) UiAutomation#injectInputEvent(android.view.InputEvent, boolean)}
 * will work regardless of the current application.
 * </p>
 * <p>
 * A typical test case should be using either the {@link android.app.UiAutomation UiAutomation} or
 * {@link android.app.Instrumentation Instrumentation} APIs. Using both APIs at the same time is not
 * a mistake by itself but a client has to be aware of the APIs limitations.
 * </p>
 * <p>
 * If a {@link android.app.UiAutomation UiAutomation} exists with different flags, the flags on that instance will be
 * changed, and then it will be returned.
 * </p>
 *
 * @param flags The flags to be passed to the UiAutomation, for example
 *        {@link android.app.UiAutomation#FLAG_DONT_SUPPRESS_ACCESSIBILITY_SERVICES UiAutomation#FLAG_DONT_SUPPRESS_ACCESSIBILITY_SERVICES}.
 *
 * Value is 0, or {@link android.app.UiAutomation#FLAG_DONT_SUPPRESS_ACCESSIBILITY_SERVICES}
 * @return The UI automation instance.
 *
 * @see android.app.UiAutomation
 * @apiSince 24
 */

public android.app.UiAutomation getUiAutomation(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Takes control of the execution of messages on the specified looper until
 * {@link android.os.TestLooperManager#release TestLooperManager#release} is called.
 * @apiSince 26
 */

public android.os.TestLooperManager acquireLooperManager(android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * If included in the status or final bundle sent to an IInstrumentationWatcher, this key
 * identifies the class that is writing the report.  This can be used to provide more structured
 * logging or reporting capabilities in the IInstrumentationWatcher.
 * @apiSince 1
 */

public static final java.lang.String REPORT_KEY_IDENTIFIER = "id";

/**
 * If included in the status or final bundle sent to an IInstrumentationWatcher, this key
 * identifies a string which can simply be printed to the output stream.  Using these streams
 * provides a "pretty printer" version of the status & final packets.  Any bundles including
 * this key should also include the complete set of raw key/value pairs, so that the
 * instrumentation can also be launched, and results collected, by an automated system.
 * @apiSince 1
 */

public static final java.lang.String REPORT_KEY_STREAMRESULT = "stream";
/**
 * Information about a particular kind of Intent that is being monitored.
 * An instance of this class is added to the
 * current instrumentation through {@link #addMonitor}; after being added,
 * when a new activity is being started the monitor will be checked and, if
 * matching, its hit count updated and (optionally) the call stopped and a
 * canned result returned.
 *
 * <p>An ActivityMonitor can also be used to look for the creation of an
 * activity, through the {@link #waitForActivity} method.  This will return
 * after a matching activity has been created with that activity object.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ActivityMonitor {

/**
 * Create a new ActivityMonitor that looks for a particular kind of
 * intent to be started.
 *
 * @param which The set of intents this monitor is responsible for.
 * @param result A canned result to return if the monitor is hit; can
 *               be null.
 * @param block Controls whether the monitor should block the activity
 *              start (returning its canned result) or let the call
 *              proceed.
 *
 * @see Instrumentation#addMonitor
 * @apiSince 1
 */

public ActivityMonitor(android.content.IntentFilter which, android.app.Instrumentation.ActivityResult result, boolean block) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ActivityMonitor that looks for a specific activity
 * class to be started.
 *
 * @param cls The activity class this monitor is responsible for.
 * @param result A canned result to return if the monitor is hit; can
 *               be null.
 * @param block Controls whether the monitor should block the activity
 *              start (returning its canned result) or let the call
 *              proceed.
 *
 * @see Instrumentation#addMonitor
 * @apiSince 1
 */

public ActivityMonitor(java.lang.String cls, android.app.Instrumentation.ActivityResult result, boolean block) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ActivityMonitor that can be used for intercepting any activity to be
 * started.
 *
 * <p> When an activity is started, {@link #onStartActivity(android.content.Intent)} will be called on
 * instances created using this constructor to see if it is a hit.
 *
 * @see #onStartActivity(Intent)
 * @apiSince 26
 */

public ActivityMonitor() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the filter associated with this ActivityMonitor.
 * @apiSince 1
 */

public final android.content.IntentFilter getFilter() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the result associated with this ActivityMonitor, or null if
 * none.
 * @apiSince 1
 */

public final android.app.Instrumentation.ActivityResult getResult() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this monitor blocks activity starts (not allowing the
 * actual activity to run) or allows them to execute normally.
 * @apiSince 1
 */

public final boolean isBlocking() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the number of times the monitor has been hit so far.
 * @apiSince 1
 */

public final int getHits() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the most recent activity class that was seen by this
 * monitor.
 * @apiSince 1
 */

public final android.app.Activity getLastActivity() { throw new RuntimeException("Stub!"); }

/**
 * Block until an Activity is created that matches this monitor,
 * returning the resulting activity.
 *
 * @return Activity
 * @apiSince 1
 */

public final android.app.Activity waitForActivity() { throw new RuntimeException("Stub!"); }

/**
 * Block until an Activity is created that matches this monitor,
 * returning the resulting activity or till the timeOut period expires.
 * If the timeOut expires before the activity is started, return null.
 *
 * @param timeOut Time to wait in milliseconds before the activity is created.
 *
 * @return Activity
 * @apiSince 1
 */

public final android.app.Activity waitForActivityWithTimeout(long timeOut) { throw new RuntimeException("Stub!"); }

/**
 * Used for intercepting any started activity.
 *
 * <p> A non-null return value here will be considered a hit for this monitor.
 * By default this will return {@code null} and subclasses can override this to return
 * a non-null value if the intent needs to be intercepted.
 *
 * <p> Whenever a new activity is started, this method will be called on instances created
 * using {@link #Instrumentation.ActivityMonitor()} to check if there is a match. In case
 * of a match, the activity start will be blocked and the returned result will be used.
 *
 * @param intent The intent used for starting the activity.
 * @return The {@link android.app.Instrumentation.ActivityResult ActivityResult} that needs to be used in case of a match.
 * @apiSince 26
 */

public android.app.Instrumentation.ActivityResult onStartActivity(android.content.Intent intent) { throw new RuntimeException("Stub!"); }
}

/**
 * Description of a Activity execution result to return to the original
 * activity.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ActivityResult {

/**
 * Create a new activity result.  See {@link android.app.Activity#setResult Activity#setResult} for
 * more information.
 *
 * @param resultCode The result code to propagate back to the
 * originating activity, often RESULT_CANCELED or RESULT_OK
 * @param resultData The data to propagate back to the originating
 * activity.
 * @apiSince 1
 */

public ActivityResult(int resultCode, android.content.Intent resultData) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the result code contained in this result.
 * @apiSince 1
 */

public int getResultCode() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the data contained in this result.
 * @apiSince 1
 */

public android.content.Intent getResultData() { throw new RuntimeException("Stub!"); }
}

}

