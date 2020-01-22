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


package android.test;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.app.Application;

/**
 * This class provides isolated testing of a single activity.  The activity under test will
 * be created with minimal connection to the system infrastructure, and you can inject mocked or
 * wrappered versions of many of Activity's dependencies.  Most of the work is handled
 * automatically here by {@link #setUp} and {@link #tearDown}.
 *
 * <p>If you prefer a functional test, see {@link android.test.ActivityInstrumentationTestCase}.
 *
 * <p>It must be noted that, as a true unit test, your Activity will not be running in the
 * normal system and will not participate in the normal interactions with other Activities.
 * The following methods should not be called in this configuration - most of them will throw
 * exceptions:
 * <ul>
 * <li>{@link android.app.Activity#createPendingResult(int, Intent, int)}</li>
 * <li>{@link android.app.Activity#startActivityIfNeeded(Intent, int)}</li>
 * <li>{@link android.app.Activity#startActivityFromChild(Activity, Intent, int)}</li>
 * <li>{@link android.app.Activity#startNextMatchingActivity(Intent)}</li>
 * <li>{@link android.app.Activity#getCallingActivity()}</li>
 * <li>{@link android.app.Activity#getCallingPackage()}</li>
 * <li>{@link android.app.Activity#createPendingResult(int, Intent, int)}</li>
 * <li>{@link android.app.Activity#getTaskId()}</li>
 * <li>{@link android.app.Activity#isTaskRoot()}</li>
 * <li>{@link android.app.Activity#moveTaskToBack(boolean)}</li>
 * </ul>
 *
 * <p>The following methods may be called but will not do anything.  For test purposes, you can use
 * the methods {@link #getStartedActivityIntent()} and {@link #getStartedActivityRequest()} to
 * inspect the parameters that they were called with.
 * <ul>
 * <li>{@link android.app.Activity#startActivity(Intent)}</li>
 * <li>{@link android.app.Activity#startActivityForResult(Intent, int)}</li>
 * </ul>
 *
 * <p>The following methods may be called but will not do anything.  For test purposes, you can use
 * the methods {@link #isFinishCalled()} and {@link #getFinishedActivityRequest()} to inspect the
 * parameters that they were called with.
 * <ul>
 * <li>{@link android.app.Activity#finish()}</li>
 * <li>{@link android.app.Activity#finishFromChild(Activity child)}</li>
 * <li>{@link android.app.Activity#finishActivity(int requestCode)}</li>
 * </ul>
 *
 * @deprecated Write
 * <a href="{@docRoot}training/testing/unit-testing/local-unit-tests.html">Local Unit Tests</a>
 * instead.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class ActivityUnitTestCase<T extends android.app.Activity> extends android.test.ActivityTestCase {

/** @apiSince 1 */

@Deprecated
public ActivityUnitTestCase(java.lang.Class<T> activityClass) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public T getActivity() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void setUp() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * Start the activity under test, in the same way as if it was started by
 * {@link android.content.Context#startActivity Context.startActivity()}, providing the
 * arguments it supplied.  When you use this method to start the activity, it will automatically
 * be stopped by {@link #tearDown}.
 *
 * <p>This method will call onCreate(), but if you wish to further exercise Activity life
 * cycle methods, you must call them yourself from your test case.
 *
 * <p><i>Do not call from your setUp() method.  You must call this method from each of your
 * test methods.</i>
 *
 * @param intent The Intent as if supplied to {@link android.content.Context#startActivity}.
 * @param savedInstanceState The instance state, if you are simulating this part of the life
 * cycle.  Typically null.
 * @param lastNonConfigurationInstance This Object will be available to the
 * Activity if it calls {@link android.app.Activity#getLastNonConfigurationInstance()}.
 * Typically null.
 * @return Returns the Activity that was created
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected T startActivity(android.content.Intent intent, android.os.Bundle savedInstanceState, java.lang.Object lastNonConfigurationInstance) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void tearDown() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * Set the application for use during the test.  You must call this function before calling
 * {@link #startActivity}.  If your test does not call this method,
 * @param application The Application object that will be injected into the Activity under test.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void setApplication(android.app.Application application) { throw new RuntimeException("Stub!"); }

/**
 * If you wish to inject a Mock, Isolated, or otherwise altered context, you can do so
 * here.  You must call this function before calling {@link #startActivity}.  If you wish to
 * obtain a real Context, as a building block, use getInstrumentation().getTargetContext().
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void setActivityContext(android.content.Context activityContext) { throw new RuntimeException("Stub!"); }

/**
 * This method will return the value if your Activity under test calls
 * {@link android.app.Activity#setRequestedOrientation}.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public int getRequestedOrientation() { throw new RuntimeException("Stub!"); }

/**
 * This method will return the launch intent if your Activity under test calls
 * {@link android.app.Activity#startActivity(Intent)} or
 * {@link android.app.Activity#startActivityForResult(Intent, int)}.
 * @return The Intent provided in the start call, or null if no start call was made.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public android.content.Intent getStartedActivityIntent() { throw new RuntimeException("Stub!"); }

/**
 * This method will return the launch request code if your Activity under test calls
 * {@link android.app.Activity#startActivityForResult(Intent, int)}.
 * @return The request code provided in the start call, or -1 if no start call was made.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public int getStartedActivityRequest() { throw new RuntimeException("Stub!"); }

/**
 * This method will notify you if the Activity under test called
 * {@link android.app.Activity#finish()},
 * {@link android.app.Activity#finishFromChild(Activity)}, or
 * {@link android.app.Activity#finishActivity(int)}.
 * @return Returns true if one of the listed finish methods was called.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public boolean isFinishCalled() { throw new RuntimeException("Stub!"); }

/**
 * This method will return the request code if the Activity under test called
 * {@link android.app.Activity#finishActivity(int)}.
 * @return The request code provided in the start call, or -1 if no finish call was made.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public int getFinishedActivityRequest() { throw new RuntimeException("Stub!"); }
}

