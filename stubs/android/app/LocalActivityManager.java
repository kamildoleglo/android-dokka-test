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

import android.content.Intent;
import android.os.Bundle;

/**
 * <p>Helper class for managing multiple running embedded activities in the same
 * process. This class is not normally used directly, but rather created for
 * you as part of the {@link android.app.ActivityGroup} implementation.
 *
 * @see android.app.ActivityGroup
 *
 * @deprecated Use the new {@link android.app.Fragment Fragment} and {@link android.app.FragmentManager FragmentManager} APIs
 * instead; these are also
 * available on older platforms through the Android compatibility package.
 * @apiSince 1
 * @deprecatedSince 13
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class LocalActivityManager {

/**
 * Create a new LocalActivityManager for holding activities running within
 * the given <var>parent</var>.
 *
 * @param parent the host of the embedded activities
 * @param singleMode True if the LocalActivityManger should keep a maximum
 * of one activity resumed
 * @apiSince 1
 */

@Deprecated
public LocalActivityManager(android.app.Activity parent, boolean singleMode) { throw new RuntimeException("Stub!"); }

/**
 * Start a new activity running in the group.  Every activity you start
 * must have a unique string ID associated with it -- this is used to keep
 * track of the activity, so that if you later call startActivity() again
 * on it the same activity object will be retained.
 *
 * <p>When there had previously been an activity started under this id,
 * it may either be destroyed and a new one started, or the current
 * one re-used, based on these conditions, in order:</p>
 *
 * <ul>
 * <li> If the Intent maps to a different activity component than is
 * currently running, the current activity is finished and a new one
 * started.
 * <li> If the current activity uses a non-multiple launch mode (such
 * as singleTop), or the Intent has the
 * {@link android.content.Intent#FLAG_ACTIVITY_SINGLE_TOP Intent#FLAG_ACTIVITY_SINGLE_TOP} flag set, then the current
 * activity will remain running and its
 * {@link android.app.Activity#onNewIntent(android.content.Intent) Activity#onNewIntent(Intent)} method
 * called.
 * <li> If the new Intent is the same (excluding extras) as the previous
 * one, and the new Intent does not have the
 * {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TOP Intent#FLAG_ACTIVITY_CLEAR_TOP} set, then the current activity
 * will remain running as-is.
 * <li> Otherwise, the current activity will be finished and a new
 * one started.
 * </ul>
 *
 * <p>If the given Intent can not be resolved to an available Activity,
 * this method throws {@link android.content.ActivityNotFoundException}.
 *
 * <p>Warning: There is an issue where, if the Intent does not
 * include an explicit component, we can restore the state for a different
 * activity class than was previously running when the state was saved (if
 * the set of available activities changes between those points).
 *
 * @param id Unique identifier of the activity to be started
 * @param intent The Intent describing the activity to be started
 *
 * @return Returns the window of the activity.  The caller needs to take
 * care of adding this window to a view hierarchy, and likewise dealing
 * with removing the old window if the activity has changed.
 *
 * @throws android.content.ActivityNotFoundException
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public android.view.Window startActivity(java.lang.String id, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Destroy the activity associated with a particular id.  This activity
 * will go through the normal lifecycle events and fine onDestroy(), and
 * then the id removed from the group.
 *
 * @param id Unique identifier of the activity to be destroyed
 * @param finish If true, this activity will be finished, so its id and
 * all state are removed from the group.
 *
 * @return Returns the window that was used to display the activity, or
 * null if there was none.
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public android.view.Window destroyActivity(java.lang.String id, boolean finish) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the Activity that is currently running.
 *
 * @return the currently running (resumed) Activity, or null if there is
 *         not one
 *
 * @see #startActivity
 * @see #getCurrentId
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public android.app.Activity getCurrentActivity() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the ID of the activity that is currently running.
 *
 * @return the ID of the currently running (resumed) Activity, or null if
 *         there is not one
 *
 * @see #startActivity
 * @see #getCurrentActivity
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public java.lang.String getCurrentId() { throw new RuntimeException("Stub!"); }

/**
 * Return the Activity object associated with a string ID.
 *
 * @see #startActivity
 *
 * @return the associated Activity object, or null if the id is unknown or
 *         its activity is not currently instantiated
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public android.app.Activity getActivity(java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Restore a state that was previously returned by {@link #saveInstanceState}.  This
 * adds to the activity group information about all activity IDs that had
 * previously been saved, even if they have not been started yet, so if the
 * user later navigates to them the correct state will be restored.
 *
 * <p>Note: This does <b>not</b> change the current running activity, or
 * start whatever activity was previously running when the state was saved.
 * That is up to the client to do, in whatever way it thinks is best.
 *
 * @param state a previously saved state; does nothing if this is null
 *
 * @see #saveInstanceState
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void dispatchCreate(android.os.Bundle state) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the state of all activities known by the group.  For
 * activities that have previously run and are now stopped or finished, the
 * last saved state is used.  For the current running activity, its
 * {@link android.app.Activity#onSaveInstanceState Activity#onSaveInstanceState} is called to retrieve its current state.
 *
 * @return a Bundle holding the newly created state of all known activities
 *
 * @see #dispatchCreate
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public android.os.Bundle saveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * Called by the container activity in its {@link android.app.Activity#onResume Activity#onResume} so
 * that LocalActivityManager can perform the corresponding action on the
 * activities it holds.
 *
 * @see android.app.Activity#onResume
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void dispatchResume() { throw new RuntimeException("Stub!"); }

/**
 * Called by the container activity in its {@link android.app.Activity#onPause Activity#onPause} so
 * that LocalActivityManager can perform the corresponding action on the
 * activities it holds.
 *
 * @param finishing set to true if the parent activity has been finished;
 *                  this can be determined by calling
 *                  Activity.isFinishing()
 *
 * @see android.app.Activity#onPause
 * @see android.app.Activity#isFinishing
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void dispatchPause(boolean finishing) { throw new RuntimeException("Stub!"); }

/**
 * Called by the container activity in its {@link android.app.Activity#onStop Activity#onStop} so
 * that LocalActivityManager can perform the corresponding action on the
 * activities it holds.
 *
 * @see android.app.Activity#onStop
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void dispatchStop() { throw new RuntimeException("Stub!"); }

/**
 * Remove all activities from this LocalActivityManager, performing an
 * {@link android.app.Activity#onDestroy Activity#onDestroy} on any that are currently instantiated.
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void removeAllActivities() { throw new RuntimeException("Stub!"); }

/**
 * Called by the container activity in its {@link android.app.Activity#onDestroy Activity#onDestroy} so
 * that LocalActivityManager can perform the corresponding action on the
 * activities it holds.
 *
 * @see android.app.Activity#onDestroy
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void dispatchDestroy(boolean finishing) { throw new RuntimeException("Stub!"); }
}

