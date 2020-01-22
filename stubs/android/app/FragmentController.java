/*
 * Copyright (C) 2015 The Android Open Source Project
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

import android.os.Parcelable;
import android.os.Bundle;
import android.content.res.Configuration;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Provides integration points with a {@link android.app.FragmentManager FragmentManager} for a fragment host.
 * <p>
 * It is the responsibility of the host to take care of the Fragment's lifecycle.
 * The methods provided by {@link android.app.FragmentController FragmentController} are for that purpose.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentController}
 * @apiSince 23
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class FragmentController {

private FragmentController() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.app.FragmentController FragmentController}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public static final android.app.FragmentController createController(android.app.FragmentHostCallback<?> callbacks) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.app.FragmentManager FragmentManager} for this controller.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public android.app.FragmentManager getFragmentManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.app.LoaderManager LoaderManager}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public android.app.LoaderManager getLoaderManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns a fragment with the given identifier.
 
 * @return This value may be {@code null}.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public android.app.Fragment findFragmentByWho(java.lang.String who) { throw new RuntimeException("Stub!"); }

/**
 * Attaches the host to the FragmentManager for this controller. The host must be
 * attached before the FragmentManager can be used to manage Fragments.
 *     * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void attachHost(android.app.Fragment parent) { throw new RuntimeException("Stub!"); }

/**
 * Instantiates a Fragment's view.
 *
 * @param parent The parent that the created view will be placed
 * in; <em>note that this may be null</em>.
 * @param name Tag name to be inflated.
 * @param context The context the view is being created in.
 * @param attrs Inflation attributes as specified in XML file.
 *
 * @return view the newly created view
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public android.view.View onCreateView(android.view.View parent, java.lang.String name, android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Marks the fragment state as unsaved. This allows for "state loss" detection.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void noteStateNotSaved() { throw new RuntimeException("Stub!"); }

/**
 * Saves the state for all Fragments.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public android.os.Parcelable saveAllState() { throw new RuntimeException("Stub!"); }

/**
 * Restores the saved state for all Fragments. The given Fragment list are Fragment
 * instances retained across configuration changes.
 *
 * @see #retainNonConfig()
 *
 * @deprecated use {@link #restoreAllState(android.os.Parcelable,android.app.FragmentManagerNonConfig)}
 * @apiSince 23
 * @deprecatedSince 24
 */

@Deprecated
public void restoreAllState(android.os.Parcelable state, java.util.List<android.app.Fragment> nonConfigList) { throw new RuntimeException("Stub!"); }

/**
 * Restores the saved state for all Fragments. The given FragmentManagerNonConfig are Fragment
 * instances retained across configuration changes, including nested fragments
 *
 * @see #retainNestedNonConfig()
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public void restoreAllState(android.os.Parcelable state, android.app.FragmentManagerNonConfig nonConfig) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of Fragments that have opted to retain their instance across
 * configuration changes.
 *
 * @deprecated use {@link #retainNestedNonConfig()} to also track retained
 *             nested child fragments
 * @apiSince 23
 * @deprecatedSince 24
 */

@Deprecated
public java.util.List<android.app.Fragment> retainNonConfig() { throw new RuntimeException("Stub!"); }

/**
 * Returns a nested tree of Fragments that have opted to retain their instance across
 * configuration changes.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public android.app.FragmentManagerNonConfig retainNestedNonConfig() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the create state.
 * <p>Call when Fragments should be created.
 *
 * @see android.app.Fragment#onCreate(Bundle)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchCreate() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the activity created state.
 * <p>Call when Fragments should be informed their host has been created.
 *
 * @see android.app.Fragment#onActivityCreated(Bundle)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchActivityCreated() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the start state.
 * <p>Call when Fragments should be started.
 *
 * @see android.app.Fragment#onStart()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchStart() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the resume state.
 * <p>Call when Fragments should be resumed.
 *
 * @see android.app.Fragment#onResume()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchResume() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the pause state.
 * <p>Call when Fragments should be paused.
 *
 * @see android.app.Fragment#onPause()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchPause() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the stop state.
 * <p>Call when Fragments should be stopped.
 *
 * @see android.app.Fragment#onStop()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchStop() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the destroy view state.
 * <p>Call when the Fragment's views should be destroyed.
 *
 * @see android.app.Fragment#onDestroyView()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchDestroyView() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the destroy state.
 * <p>Call when Fragments should be destroyed.
 *
 * @see android.app.Fragment#onDestroy()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the multi-window mode of
 * the activity changed.
 * <p>Call when the multi-window mode of the activity changed.
 *
 * @see Fragment#onMultiWindowModeChanged
 * @deprecated use {@link #dispatchMultiWindowModeChanged(boolean,android.content.res.Configuration)}
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void dispatchMultiWindowModeChanged(boolean isInMultiWindowMode) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the multi-window mode of
 * the activity changed.
 * <p>Call when the multi-window mode of the activity changed.
 *
 * @see Fragment#onMultiWindowModeChanged
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchMultiWindowModeChanged(boolean isInMultiWindowMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the picture-in-picture
 * mode of the activity changed.
 * <p>Call when the picture-in-picture mode of the activity changed.
 *
 * @see Fragment#onPictureInPictureModeChanged
 * @deprecated use {@link #dispatchPictureInPictureModeChanged(boolean,android.content.res.Configuration)}
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void dispatchPictureInPictureModeChanged(boolean isInPictureInPictureMode) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the picture-in-picture
 * mode of the activity changed.
 * <p>Call when the picture-in-picture mode of the activity changed.
 *
 * @see Fragment#onPictureInPictureModeChanged
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchPictureInPictureModeChanged(boolean isInPictureInPictureMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know a configuration change occurred.
 * <p>Call when there is a configuration change.
 *
 * @see android.app.Fragment#onConfigurationChanged(Configuration)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know the device is in a low memory condition.
 * <p>Call when the device is low on memory and Fragment's should trim
 * their memory usage.
 *
 * @see android.app.Fragment#onLowMemory()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchLowMemory() { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know they should trim their memory usage.
 * <p>Call when the Fragment can release allocated memory [such as if
 * the Fragment is in the background].
 *
 * @see android.app.Fragment#onTrimMemory(int)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know they should create an options menu.
 * <p>Call when the Fragment should create an options menu.
 *
 * @return {@code true} if the options menu contains items to display
 * @see android.app.Fragment#onCreateOptionsMenu(Menu, MenuInflater)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean dispatchCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater inflater) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know they should prepare their options menu for display.
 * <p>Call immediately before displaying the Fragment's options menu.
 *
 * @return {@code true} if the options menu contains items to display
 * @see android.app.Fragment#onPrepareOptionsMenu(Menu)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean dispatchPrepareOptionsMenu(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Sends an option item selection event to the Fragments managed by the
 * controller's FragmentManager. Once the event has been consumed,
 * no additional handling will be performed.
 * <p>Call immediately after an options menu item has been selected
 *
 * @return {@code true} if the options menu selection event was consumed
 * @see android.app.Fragment#onOptionsItemSelected(MenuItem)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean dispatchOptionsItemSelected(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * Sends a context item selection event to the Fragments managed by the
 * controller's FragmentManager. Once the event has been consumed,
 * no additional handling will be performed.
 * <p>Call immediately after an options menu item has been selected
 *
 * @return {@code true} if the context menu selection event was consumed
 * @see android.app.Fragment#onContextItemSelected(MenuItem)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean dispatchContextItemSelected(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know their options menu has closed.
 * <p>Call immediately after closing the Fragment's options menu.
 *
 * @see android.app.Fragment#onOptionsMenuClosed(Menu)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dispatchOptionsMenuClosed(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Execute any pending actions for the Fragments managed by the
 * controller's FragmentManager.
 * <p>Call when queued actions can be performed [eg when the
 * Fragment moves into a start or resume state].
 * @return {@code true} if queued actions were performed
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean execPendingActions() { throw new RuntimeException("Stub!"); }

/**
 * Starts the loaders.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void doLoaderStart() { throw new RuntimeException("Stub!"); }

/**
 * Stops the loaders, optionally retaining their state. This is useful for keeping the
 * loader state across configuration changes.
 *
 * @param retain When {@code true}, the loaders aren't stopped, but, their instances
 * are retained in a started state
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void doLoaderStop(boolean retain) { throw new RuntimeException("Stub!"); }

/**
 * Destroys the loaders and, if their state is not being retained, removes them.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void doLoaderDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Lets the loaders know the host is ready to receive notifications.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void reportLoaderStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of LoaderManagers that have opted to retain their instance across
 * configuration changes.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public android.util.ArrayMap<java.lang.String,android.app.LoaderManager> retainLoaderNonConfig() { throw new RuntimeException("Stub!"); }

/**
 * Restores the saved state for all LoaderManagers. The given LoaderManager list are
 * LoaderManager instances retained across configuration changes.
 *
 * @see #retainLoaderNonConfig()
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void restoreLoaderNonConfig(android.util.ArrayMap<java.lang.String,android.app.LoaderManager> loaderManagers) { throw new RuntimeException("Stub!"); }

/**
 * Dumps the current state of the loaders.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void dumpLoaders(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
}

