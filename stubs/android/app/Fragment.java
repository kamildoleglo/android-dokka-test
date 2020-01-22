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


package android.app;

import android.os.Build;
import android.view.View;
import android.os.Build.VERSION_CODES;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.content.IntentSender;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.view.ContextMenu;
import android.view.View.OnCreateContextMenuListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.transition.Transition;
import java.io.PrintWriter;

/**
 * A Fragment is a piece of an application's user interface or behavior
 * that can be placed in an {@link android.app.Activity Activity}.  Interaction with fragments
 * is done through {@link android.app.FragmentManager FragmentManager}, which can be obtained via
 * {@link android.app.Activity#getFragmentManager() Activity#getFragmentManager()} and
 * {@link android.app.Fragment#getFragmentManager() Fragment#getFragmentManager()}.
 *
 * <p>The Fragment class can be used many ways to achieve a wide variety of
 * results. In its core, it represents a particular operation or interface
 * that is running within a larger {@link android.app.Activity Activity}.  A Fragment is closely
 * tied to the Activity it is in, and can not be used apart from one.  Though
 * Fragment defines its own lifecycle, that lifecycle is dependent on its
 * activity: if the activity is stopped, no fragments inside of it can be
 * started; when the activity is destroyed, all fragments will be destroyed.
 *
 * <p>All subclasses of Fragment must include a public no-argument constructor.
 * The framework will often re-instantiate a fragment class when needed,
 * in particular during state restore, and needs to be able to find this
 * constructor to instantiate it.  If the no-argument constructor is not
 * available, a runtime exception will occur in some cases during state
 * restore.
 *
 * <p>Topics covered here:
 * <ol>
 * <li><a href="#OlderPlatforms">Older Platforms</a>
 * <li><a href="#Lifecycle">Lifecycle</a>
 * <li><a href="#Layout">Layout</a>
 * <li><a href="#BackStack">Back Stack</a>
 * </ol>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using fragments, read the
 * <a href="{@docRoot}guide/components/fragments.html">Fragments</a> developer guide.</p>
 * </div>
 *
 * <a name="OlderPlatforms"></a>
 * <h3>Older Platforms</h3>
 *
 * While the Fragment API was introduced in
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB}, a version of the API
 * at is also available for use on older platforms through
 * {@link android.support.v4.app.FragmentActivity}.  See the blog post
 * <a href="http://android-developers.blogspot.com/2011/03/fragments-for-all.html">
 * Fragments For All</a> for more details.
 *
 * <a name="Lifecycle"></a>
 * <h3>Lifecycle</h3>
 *
 * <p>Though a Fragment's lifecycle is tied to its owning activity, it has
 * its own wrinkle on the standard activity lifecycle.  It includes basic
 * activity lifecycle methods such as {@link #onResume}, but also important
 * are methods related to interactions with the activity and UI generation.
 *
 * <p>The core series of lifecycle methods that are called to bring a fragment
 * up to resumed state (interacting with the user) are:
 *
 * <ol>
 * <li> {@link #onAttach} called once the fragment is associated with its activity.
 * <li> {@link #onCreate} called to do initial creation of the fragment.
 * <li> {@link #onCreateView} creates and returns the view hierarchy associated
 * with the fragment.
 * <li> {@link #onActivityCreated} tells the fragment that its activity has
 * completed its own {@link android.app.Activity#onCreate Activity#onCreate}.
 * <li> {@link #onViewStateRestored} tells the fragment that all of the saved
 * state of its view hierarchy has been restored.
 * <li> {@link #onStart} makes the fragment visible to the user (based on its
 * containing activity being started).
 * <li> {@link #onResume} makes the fragment begin interacting with the user
 * (based on its containing activity being resumed).
 * </ol>
 *
 * <p>As a fragment is no longer being used, it goes through a reverse
 * series of callbacks:
 *
 * <ol>
 * <li> {@link #onPause} fragment is no longer interacting with the user either
 * because its activity is being paused or a fragment operation is modifying it
 * in the activity.
 * <li> {@link #onStop} fragment is no longer visible to the user either
 * because its activity is being stopped or a fragment operation is modifying it
 * in the activity.
 * <li> {@link #onDestroyView} allows the fragment to clean up resources
 * associated with its View.
 * <li> {@link #onDestroy} called to do final cleanup of the fragment's state.
 * <li> {@link #onDetach} called immediately prior to the fragment no longer
 * being associated with its activity.
 * </ol>
 *
 * <a name="Layout"></a>
 * <h3>Layout</h3>
 *
 * <p>Fragments can be used as part of your application's layout, allowing
 * you to better modularize your code and more easily adjust your user
 * interface to the screen it is running on.  As an example, we can look
 * at a simple program consisting of a list of items, and display of the
 * details of each item.</p>
 *
 * <p>An activity's layout XML can include <code>&lt;fragment&gt;</code> tags
 * to embed fragment instances inside of the layout.  For example, here is
 * a simple layout that embeds one fragment:</p>
 *
 * {@sample development/samples/ApiDemos/res/layout/fragment_layout.xml layout}
 *
 * <p>The layout is installed in the activity in the normal way:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentLayout.java
 *      main}
 *
 * <p>The titles fragment, showing a list of titles, is fairly simple, relying
 * on {@link android.app.ListFragment ListFragment} for most of its work.  Note the implementation of
 * clicking an item: depending on the current activity's layout, it can either
 * create and display a new fragment to show the details in-place (more about
 * this later), or start a new activity to show the details.</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentLayout.java
 *      titles}
 *
 * <p>The details fragment showing the contents of a selected item just
 * displays a string of text based on an index of a string array built in to
 * the app:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentLayout.java
 *      details}
 *
 * <p>In this case when the user clicks on a title, there is no details
 * container in the current activity, so the titles fragment's click code will
 * launch a new activity to display the details fragment:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentLayout.java
 *      details_activity}
 *
 * <p>However the screen may be large enough to show both the list of titles
 * and details about the currently selected title.  To use such a layout on
 * a landscape screen, this alternative layout can be placed under layout-land:</p>
 *
 * {@sample development/samples/ApiDemos/res/layout-land/fragment_layout.xml layout}
 *
 * <p>Note how the prior code will adjust to this alternative UI flow: the titles
 * fragment will now embed the details fragment inside of this activity, and the
 * details activity will finish itself if it is running in a configuration
 * where the details can be shown in-place.
 *
 * <p>When a configuration change causes the activity hosting these fragments
 * to restart, its new instance may use a different layout that doesn't
 * include the same fragments as the previous layout.  In this case all of
 * the previous fragments will still be instantiated and running in the new
 * instance.  However, any that are no longer associated with a &lt;fragment&gt;
 * tag in the view hierarchy will not have their content view created
 * and will return false from {@link #isInLayout}.  (The code here also shows
 * how you can determine if a fragment placed in a container is no longer
 * running in a layout with that container and avoid creating its view hierarchy
 * in that case.)
 *
 * <p>The attributes of the &lt;fragment&gt; tag are used to control the
 * LayoutParams provided when attaching the fragment's view to the parent
 * container.  They can also be parsed by the fragment in {@link #onInflate}
 * as parameters.
 *
 * <p>The fragment being instantiated must have some kind of unique identifier
 * so that it can be re-associated with a previous instance if the parent
 * activity needs to be destroyed and recreated.  This can be provided these
 * ways:
 *
 * <ul>
 * <li>If nothing is explicitly supplied, the view ID of the container will
 * be used.
 * <li><code>android:tag</code> can be used in &lt;fragment&gt; to provide
 * a specific tag name for the fragment.
 * <li><code>android:id</code> can be used in &lt;fragment&gt; to provide
 * a specific identifier for the fragment.
 * </ul>
 *
 * <a name="BackStack"></a>
 * <h3>Back Stack</h3>
 *
 * <p>The transaction in which fragments are modified can be placed on an
 * internal back-stack of the owning activity.  When the user presses back
 * in the activity, any transactions on the back stack are popped off before
 * the activity itself is finished.
 *
 * <p>For example, consider this simple fragment that is instantiated with
 * an integer argument and displays that in a TextView in its UI:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentStack.java
 *      fragment}
 *
 * <p>A function that creates a new instance of the fragment, replacing
 * whatever current fragment instance is being shown and pushing that change
 * on to the back stack could be written as:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentStack.java
 *      add_stack}
 *
 * <p>After each call to this function, a new entry is on the stack, and
 * pressing back will pop it to return the user to whatever previous state
 * the activity UI was in.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.Fragment} for consistent behavior across all devices
 *      and access to <a href="{@docRoot}topic/libraries/architecture/lifecycle.html">Lifecycle</a>.
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Fragment implements android.content.ComponentCallbacks2, android.view.View.OnCreateContextMenuListener {

/**
 * Default constructor.  <strong>Every</strong> fragment must have an
 * empty constructor, so it can be instantiated when restoring its
 * activity's state.  It is strongly recommended that subclasses do not
 * have other constructors with parameters, since these constructors
 * will not be called when the fragment is re-instantiated; instead,
 * arguments can be supplied by the caller with {@link #setArguments}
 * and later retrieved by the Fragment with {@link #getArguments}.
 *
 * <p>Applications should generally not implement a constructor. Prefer
 * {@link #onAttach(android.content.Context)} instead. It is the first place application code can run where
 * the fragment is ready to be used - the point where the fragment is actually associated with
 * its context. Some applications may also want to implement {@link #onInflate} to retrieve
 * attributes from a layout resource, although note this happens when the fragment is attached.
 * @apiSince 11
 */

@Deprecated
public Fragment() { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #instantiate(android.content.Context,java.lang.String,android.os.Bundle)} but with a null
 * argument Bundle.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public static android.app.Fragment instantiate(android.content.Context context, java.lang.String fname) { throw new RuntimeException("Stub!"); }

/**
 * Create a new instance of a Fragment with the given class name.  This is
 * the same as calling its empty constructor.
 *
 * @param context The calling context being used to instantiate the fragment.
 * This is currently just used to get its ClassLoader.
 * @param fname The class name of the fragment to instantiate.
 * @param args Bundle of arguments to supply to the fragment, which it
 * can retrieve with {@link #getArguments()}.  May be null.
 * This value may be {@code null}.
 * @return Returns a new fragment instance.
 * @throws android.app.Fragment.InstantiationException If there is a failure in instantiating
 * the given fragment class.  This is a runtime exception; it is not
 * normally expected to happen.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public static android.app.Fragment instantiate(android.content.Context context, java.lang.String fname, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses can not override equals().
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses can not override hashCode().
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Return the identifier this fragment is known by.  This is either
 * the android:id value supplied in a layout or the container view ID
 * supplied when adding the fragment.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final int getId() { throw new RuntimeException("Stub!"); }

/**
 * Get the tag name of the fragment, if specified.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final java.lang.String getTag() { throw new RuntimeException("Stub!"); }

/**
 * Supply the construction arguments for this fragment.
 * The arguments supplied here will be retained across fragment destroy and
 * creation.
 *
 * <p>This method cannot be called if the fragment is added to a FragmentManager and
 * if {@link #isStateSaved()} would return true. Prior to {@link android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O},
 * this method may only be called if the fragment has not yet been added to a FragmentManager.
 * </p>
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setArguments(android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Return the arguments supplied to {@link #setArguments}, if any.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final android.os.Bundle getArguments() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this fragment is added and its state has already been saved
 * by its host. Any operations that would change saved state should not be performed
 * if this method returns true, and some operations such as {@link #setArguments(android.os.Bundle)}
 * will fail.
 *
 * @return true if this fragment's state has already been saved by its host
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isStateSaved() { throw new RuntimeException("Stub!"); }

/**
 * Set the initial saved state that this Fragment should restore itself
 * from when first being constructed, as returned by
 * {@link android.app.FragmentManager#saveFragmentInstanceState(android.app.Fragment) FragmentManager#saveFragmentInstanceState(Fragment)}.
 *
 * @param state The state the fragment should be restored from.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public void setInitialSavedState(android.app.Fragment.SavedState state) { throw new RuntimeException("Stub!"); }

/**
 * Optional target for this fragment.  This may be used, for example,
 * if this fragment is being started by another, and when done wants to
 * give a result back to the first.  The target set here is retained
 * across instances via {@link android.app.FragmentManager#putFragment FragmentManager#putFragment}.
 *
 * @param fragment The fragment that is the target of this one.
 * @param requestCode Optional request code, for convenience if you
 * are going to call back with {@link #onActivityResult(int,int,android.content.Intent)}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setTargetFragment(android.app.Fragment fragment, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Return the target fragment set by {@link #setTargetFragment}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final android.app.Fragment getTargetFragment() { throw new RuntimeException("Stub!"); }

/**
 * Return the target request code set by {@link #setTargetFragment}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final int getTargetRequestCode() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.content.Context Context} this fragment is currently associated with.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Return the Activity this fragment is currently associated with.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final android.app.Activity getActivity() { throw new RuntimeException("Stub!"); }

/**
 * Return the host object of this fragment. May return {@code null} if the fragment
 * isn't currently being hosted.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public final java.lang.Object getHost() { throw new RuntimeException("Stub!"); }

/**
 * Return <code>getActivity().getResources()</code>.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final android.content.res.Resources getResources() { throw new RuntimeException("Stub!"); }

/**
 * Return a localized, styled CharSequence from the application's package's
 * default string table.
 *
 * @param resId Resource id for the CharSequence text
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final java.lang.CharSequence getText(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Return a localized string from the application's package's
 * default string table.
 *
 * @param resId Resource id for the string
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final java.lang.String getString(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Return a localized formatted string from the application's package's
 * default string table, substituting the format arguments as defined in
 * {@link java.util.Formatter} and {@link java.lang.String#format}.
 *
 * @param resId Resource id for the format string
 * @param formatArgs The format arguments that will be used for substitution.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final java.lang.String getString(int resId, java.lang.Object... formatArgs) { throw new RuntimeException("Stub!"); }

/**
 * Return the FragmentManager for interacting with fragments associated
 * with this fragment's activity.  Note that this will be non-null slightly
 * before {@link #getActivity()}, during the time from when the fragment is
 * placed in a {@link android.app.FragmentTransaction FragmentTransaction} until it is committed and
 * attached to its activity.
 *
 * <p>If this Fragment is a child of another Fragment, the FragmentManager
 * returned here will be the parent's {@link #getChildFragmentManager()}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final android.app.FragmentManager getFragmentManager() { throw new RuntimeException("Stub!"); }

/**
 * Return a private FragmentManager for placing and managing Fragments
 * inside of this Fragment.
 * @apiSince 17
 * @deprecatedSince 28
 */

@Deprecated
public final android.app.FragmentManager getChildFragmentManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the parent Fragment containing this Fragment.  If this Fragment
 * is attached directly to an Activity, returns null.
 * @apiSince 17
 * @deprecatedSince 28
 */

@Deprecated
public final android.app.Fragment getParentFragment() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the fragment is currently added to its activity.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isAdded() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the fragment has been explicitly detached from the UI.
 * That is, {@link android.app.FragmentTransaction#detach(android.app.Fragment) FragmentTransaction#detach(Fragment)} has been used on it.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isDetached() { throw new RuntimeException("Stub!"); }

/**
 * Return true if this fragment is currently being removed from its
 * activity.  This is  <em>not</em> whether its activity is finishing, but
 * rather whether it is in the process of being removed from its activity.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isRemoving() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the layout is included as part of an activity view
 * hierarchy via the &lt;fragment&gt; tag.  This will always be true when
 * fragments are created through the &lt;fragment&gt; tag, <em>except</em>
 * in the case where an old fragment is restored from a previous state and
 * it does not appear in the layout of the current state.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isInLayout() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the fragment is in the resumed state.  This is true
 * for the duration of {@link #onResume()} and {@link #onPause()} as well.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isResumed() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the fragment is currently visible to the user.  This means
 * it: (1) has been added, (2) has its view attached to the window, and
 * (3) is not hidden.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isVisible() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the fragment has been hidden.  By default fragments
 * are shown.  You can find out about changes to this state with
 * {@link #onHiddenChanged}.  Note that the hidden state is orthogonal
 * to other states -- that is, to be visible to the user, a fragment
 * must be both started and not hidden.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean isHidden() { throw new RuntimeException("Stub!"); }

/**
 * Called when the hidden state (as returned by {@link #isHidden()} of
 * the fragment has changed.  Fragments start out not hidden; this will
 * be called whenever the fragment changes state from that.
 * @param hidden True if the fragment is now hidden, false otherwise.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onHiddenChanged(boolean hidden) { throw new RuntimeException("Stub!"); }

/**
 * Control whether a fragment instance is retained across Activity
 * re-creation (such as from a configuration change).  This can only
 * be used with fragments not in the back stack.  If set, the fragment
 * lifecycle will be slightly different when an activity is recreated:
 * <ul>
 * <li> {@link #onDestroy()} will not be called (but {@link #onDetach()} still
 * will be, because the fragment is being detached from its current activity).
 * <li> {@link #onCreate(android.os.Bundle)} will not be called since the fragment
 * is not being re-created.
 * <li> {@link #onAttach(android.app.Activity)} and {@link #onActivityCreated(android.os.Bundle)} <b>will</b>
 * still be called.
 * </ul>
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setRetainInstance(boolean retain) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public final boolean getRetainInstance() { throw new RuntimeException("Stub!"); }

/**
 * Report that this fragment would like to participate in populating
 * the options menu by receiving a call to {@link #onCreateOptionsMenu}
 * and related methods.
 *
 * @param hasMenu If true, the fragment has menu items to contribute.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setHasOptionsMenu(boolean hasMenu) { throw new RuntimeException("Stub!"); }

/**
 * Set a hint for whether this fragment's menu should be visible.  This
 * is useful if you know that a fragment has been placed in your view
 * hierarchy so that the user can not currently seen it, so any menu items
 * it has should also not be shown.
 *
 * @param menuVisible The default is true, meaning the fragment's menu will
 * be shown as usual.  If false, the user will not see the menu.
 * @apiSince 14
 * @deprecatedSince 28
 */

@Deprecated
public void setMenuVisibility(boolean menuVisible) { throw new RuntimeException("Stub!"); }

/**
 * Set a hint to the system about whether this fragment's UI is currently visible
 * to the user. This hint defaults to true and is persistent across fragment instance
 * state save and restore.
 *
 * <p>An app may set this to false to indicate that the fragment's UI is
 * scrolled out of visibility or is otherwise not directly visible to the user.
 * This may be used by the system to prioritize operations such as fragment lifecycle updates
 * or loader ordering behavior.</p>
 *
 * <p><strong>Note:</strong> This method may be called outside of the fragment lifecycle
 * and thus has no ordering guarantees with regard to fragment lifecycle method calls.</p>
 *
 * <p><strong>Note:</strong> Prior to Android N there was a platform bug that could cause
 * <code>setUserVisibleHint</code> to bring a fragment up to the started state before its
 * <code>FragmentTransaction</code> had been committed. As some apps relied on this behavior,
 * it is preserved for apps that declare a <code>targetSdkVersion</code> of 23 or lower.</p>
 *
 * @param isVisibleToUser true if this fragment's UI is currently visible to the user (default),
 *                        false if it is not.
 * @apiSince 15
 * @deprecatedSince 28
 */

@Deprecated
public void setUserVisibleHint(boolean isVisibleToUser) { throw new RuntimeException("Stub!"); }

/**
 * @return The current value of the user-visible hint on this fragment.
 * @see #setUserVisibleHint(boolean)
 * @apiSince 15
 * @deprecatedSince 28
 */

@Deprecated
public boolean getUserVisibleHint() { throw new RuntimeException("Stub!"); }

/**
 * Return the LoaderManager for this fragment, creating it if needed.
 *
 * @deprecated Use {@link android.support.v4.app.Fragment#getLoaderManager()}
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.app.LoaderManager getLoaderManager() { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.app.Activity#startActivity(android.content.Intent) Activity#startActivity(Intent)} from the fragment's
 * containing Activity.
 *
 * @param intent The intent to start.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void startActivity(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.app.Activity#startActivity(android.content.Intent,android.os.Bundle) Activity#startActivity(Intent, Bundle)} from the fragment's
 * containing Activity.
 *
 * @param intent The intent to start.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void startActivity(android.content.Intent intent, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)} from the fragment's
 * containing Activity.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void startActivityForResult(android.content.Intent intent, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.app.Activity#startActivityForResult(android.content.Intent,int,android.os.Bundle) Activity#startActivityForResult(Intent, int, Bundle)} from the fragment's
 * containing Activity.
 * @apiSince 16
 * @deprecatedSince 28
 */

@Deprecated
public void startActivityForResult(android.content.Intent intent, int requestCode, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.app.Activity#startIntentSenderForResult(android.content.IntentSender,int,android.content.Intent,int,int,int,android.os.Bundle) Activity#startIntentSenderForResult(IntentSender, int, Intent, int, int, int,
 * Bundle)} from the fragment's containing Activity.
 
 * @param fillInIntent This value may be {@code null}.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public void startIntentSenderForResult(android.content.IntentSender intent, int requestCode, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Receive the result from a previous call to
 * {@link #startActivityForResult(android.content.Intent,int)}.  This follows the
 * related Activity API as described there in
 * {@link android.app.Activity#onActivityResult(int,int,android.content.Intent) Activity#onActivityResult(int, int, Intent)}.
 *
 * @param requestCode The integer request code originally supplied to
 *                    startActivityForResult(), allowing you to identify who this
 *                    result came from.
 * @param resultCode The integer result code returned by the child activity
 *                   through its setResult().
 * @param data An Intent, which can return result data to the caller
 *               (various data can be attached to Intent "extras").
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }

/**
 * Requests permissions to be granted to this application. These permissions
 * must be requested in your manifest, they should not be granted to your app,
 * and they should have protection level {@link android.content.pm.PermissionInfo
 * #PROTECTION_DANGEROUS dangerous}, regardless whether they are declared by
 * the platform or a third-party app.
 * <p>
 * Normal permissions {@link android.content.pm.PermissionInfo#PROTECTION_NORMAL}
 * are granted at install time if requested in the manifest. Signature permissions
 * {@link android.content.pm.PermissionInfo#PROTECTION_SIGNATURE} are granted at
 * install time if requested in the manifest and the signature of your app matches
 * the signature of the app declaring the permissions.
 * </p>
 * <p>
 * If your app does not have the requested permissions the user will be presented
 * with UI for accepting them. After the user has accepted or rejected the
 * requested permissions you will receive a callback on {@link
 * #onRequestPermissionsResult(int,java.lang.String[],int[])} reporting whether the
 * permissions were granted or not.
 * </p>
 * <p>
 * Note that requesting a permission does not guarantee it will be granted and
 * your app should be able to run without having this permission.
 * </p>
 * <p>
 * This method may start an activity allowing the user to choose which permissions
 * to grant and which to reject. Hence, you should be prepared that your activity
 * may be paused and resumed. Further, granting some permissions may require
 * a restart of you application. In such a case, the system will recreate the
 * activity stack before delivering the result to {@link
 * #onRequestPermissionsResult(int,java.lang.String[],int[])}.
 * </p>
 * <p>
 * When checking whether you have a permission you should use {@link
 * android.content.Context#checkSelfPermission(String)}.
 * </p>
 * <p>
 * Calling this API for permissions already granted to your app would show UI
 * to the user to decide whether the app can still hold these permissions. This
 * can be useful if the way your app uses data guarded by the permissions
 * changes significantly.
 * </p>
 * <p>
 * You cannot request a permission if your activity sets {@link
 * android.R.styleable#AndroidManifestActivity_noHistory noHistory} to
 * <code>true</code> because in this case the activity would not receive
 * result callbacks including {@link #onRequestPermissionsResult(int,java.lang.String[],int[])}.
 * </p>
 * <p>
 * A sample permissions request looks like this:
 * </p>
 * <code><pre><p>
 * private void showContacts() {
 *     if (getActivity().checkSelfPermission(Manifest.permission.READ_CONTACTS)
 *             != PackageManager.PERMISSION_GRANTED) {
 *         requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},
 *                 PERMISSIONS_REQUEST_READ_CONTACTS);
 *     } else {
 *         doShowContacts();
 *     }
 * }
 *
 * {@literal @}Override
 * public void onRequestPermissionsResult(int requestCode, String[] permissions,
 *         int[] grantResults) {
 *     if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS
 *             && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
 *         doShowContacts();
 *     }
 * }
 * </code></pre></p>
 *
 * @param permissions The requested permissions. Must me non-null and not empty.
 * This value must never be {@code null}.
 * @param requestCode Application specific request code to match with a result
 *    reported to {@link #onRequestPermissionsResult(int,java.lang.String[],int[])}.
 *    Should be >= 0.
 *
 * @see #onRequestPermissionsResult(int, String[], int[])
 * @see android.content.Context#checkSelfPermission(String)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public final void requestPermissions(@androidx.annotation.NonNull java.lang.String[] permissions, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Callback for the result from requesting permissions. This method
 * is invoked for every call on {@link #requestPermissions(java.lang.String[],int)}.
 * <p>
 * <strong>Note:</strong> It is possible that the permissions request interaction
 * with the user is interrupted. In this case you will receive empty permissions
 * and results arrays which should be treated as a cancellation.
 * </p>
 *
 * @param requestCode The request code passed in {@link #requestPermissions(java.lang.String[],int)}.
 * @param permissions The requested permissions. Never null.
 * This value must never be {@code null}.
 * @param grantResults The grant results for the corresponding permissions
 *     which is either {@link android.content.pm.PackageManager#PERMISSION_GRANTED}
 *     or {@link android.content.pm.PackageManager#PERMISSION_DENIED}. Never null.
 *
 * This value must never be {@code null}.
 * @see #requestPermissions(String[], int)
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onRequestPermissionsResult(int requestCode, @androidx.annotation.NonNull java.lang.String[] permissions, @androidx.annotation.NonNull int[] grantResults) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether you should show UI with rationale for requesting a permission.
 * You should do this only if you do not have the permission and the context in
 * which the permission is requested does not clearly communicate to the user
 * what would be the benefit from granting this permission.
 * <p>
 * For example, if you write a camera app, requesting the camera permission
 * would be expected by the user and no rationale for why it is requested is
 * needed. If however, the app needs location for tagging photos then a non-tech
 * savvy user may wonder how location is related to taking photos. In this case
 * you may choose to show UI with rationale of requesting this permission.
 * </p>
 *
 * @param permission A permission your app wants to request.
 * This value must never be {@code null}.
 * @return Whether you can show permission rationale UI.
 *
 * @see android.content.Context#checkSelfPermission(String)
 * @see #requestPermissions(String[], int)
 * @see #onRequestPermissionsResult(int, String[], int[])
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean shouldShowRequestPermissionRationale(@androidx.annotation.NonNull java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Returns the LayoutInflater used to inflate Views of this Fragment. The default
 * implementation will throw an exception if the Fragment is not attached.
 *
 * @return The LayoutInflater used to inflate Views of this Fragment.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Returns the cached LayoutInflater used to inflate Views of this Fragment. If
 * {@link #onGetLayoutInflater(android.os.Bundle)} has not been called {@link #onGetLayoutInflater(android.os.Bundle)}
 * will be called with a {@code null} argument and that value will be cached.
 * <p>
 * The cached LayoutInflater will be replaced immediately prior to
 * {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)} and cleared immediately after
 * {@link #onDetach()}.
 *
 * @return The LayoutInflater used to inflate Views of this Fragment.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public final android.view.LayoutInflater getLayoutInflater() { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @deprecated Use {@link #onInflate(android.content.Context,android.util.AttributeSet,android.os.Bundle)} instead.
 * @apiSince 11
 * @deprecatedSince 15
 */

@Deprecated
public void onInflate(android.util.AttributeSet attrs, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called when a fragment is being created as part of a view layout
 * inflation, typically from setting the content view of an activity.  This
 * may be called immediately after the fragment is created from a <fragment>
 * tag in a layout file.  Note this is <em>before</em> the fragment's
 * {@link #onAttach(android.app.Activity)} has been called; all you should do here is
 * parse the attributes and save them away.
 *
 * <p>This is called every time the fragment is inflated, even if it is
 * being inflated into a new instance with saved state.  It typically makes
 * sense to re-parse the parameters each time, to allow them to change with
 * different configurations.</p>
 *
 * <p>Here is a typical implementation of a fragment that can take parameters
 * both through attributes supplied here as well from {@link #getArguments()}:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentArguments.java
 *      fragment}
 *
 * <p>Note that parsing the XML attributes uses a "styleable" resource.  The
 * declaration for the styleable used here is:</p>
 *
 * {@sample development/samples/ApiDemos/res/values/attrs.xml fragment_arguments}
 *
 * <p>The fragment can then be declared within its activity's content layout
 * through a tag like this:</p>
 *
 * {@sample development/samples/ApiDemos/res/layout/fragment_arguments.xml from_attributes}
 *
 * <p>This fragment can also be created dynamically from arguments given
 * at runtime in the arguments Bundle; here is an example of doing so at
 * creation of the containing activity:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentArguments.java
 *      create}
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param context The Context that is inflating this fragment.
 * @param attrs The attributes at the tag where the fragment is
 * being created.
 * @param savedInstanceState If the fragment is being re-created from
 * a previous saved state, this is the state.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onInflate(android.content.Context context, android.util.AttributeSet attrs, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @deprecated Use {@link #onInflate(android.content.Context,android.util.AttributeSet,android.os.Bundle)} instead.
 * @apiSince 12
 * @deprecatedSince 23
 */

@Deprecated
public void onInflate(android.app.Activity activity, android.util.AttributeSet attrs, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called when a fragment is attached as a child of this fragment.
 *
 * <p>This is called after the attached fragment's <code>onAttach</code> and before
 * the attached fragment's <code>onCreate</code> if the fragment has not yet had a previous
 * call to <code>onCreate</code>.</p>
 *
 * @param childFragment child fragment being attached
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public void onAttachFragment(android.app.Fragment childFragment) { throw new RuntimeException("Stub!"); }

/**
 * Called when a fragment is first attached to its context.
 * {@link #onCreate(android.os.Bundle)} will be called after this.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onAttach(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @deprecated Use {@link #onAttach(android.content.Context)} instead.
 * @apiSince 11
 * @deprecatedSince 23
 */

@Deprecated
public void onAttach(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Called when a fragment loads an animation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.animation.Animator onCreateAnimator(int transit, boolean enter, int nextAnim) { throw new RuntimeException("Stub!"); }

/**
 * Called to do initial creation of a fragment.  This is called after
 * {@link #onAttach(android.app.Activity)} and before
 * {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)}, but is not called if the fragment
 * instance is retained across Activity re-creation (see {@link #setRetainInstance(boolean)}).
 *
 * <p>Note that this can be called while the fragment's activity is
 * still in the process of being created.  As such, you can not rely
 * on things like the activity's content view hierarchy being initialized
 * at this point.  If you want to do work once the activity itself is
 * created, see {@link #onActivityCreated(android.os.Bundle)}.
 *
 * <p>If your app's <code>targetSdkVersion</code> is {@link android.os.Build.VERSION_CODES#M}
 * or lower, child fragments being restored from the savedInstanceState are restored after
 * <code>onCreate</code> returns. When targeting {@link android.os.Build.VERSION_CODES#N} or
 * above and running on an N or newer platform version
 * they are restored by <code>Fragment.onCreate</code>.</p>
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param savedInstanceState If the fragment is being re-created from
 * a previous saved state, this is the state.
 
 * This value may be {@code null}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onCreate(@androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called to have the fragment instantiate its user interface view.
 * This is optional, and non-graphical fragments can return null (which
 * is the default implementation).  This will be called between
 * {@link #onCreate(android.os.Bundle)} and {@link #onActivityCreated(android.os.Bundle)}.
 *
 * <p>If you return a View from here, you will later be called in
 * {@link #onDestroyView} when the view is being released.
 *
 * @param inflater The LayoutInflater object that can be used to inflate
 * any views in the fragment,
 * @param container If non-null, this is the parent view that the fragment's
 * UI should be attached to.  The fragment should not add the view itself,
 * but this can be used to generate the LayoutParams of the view.
 * This value may be {@code null}.
 * @param savedInstanceState If non-null, this fragment is being re-constructed
 * from a previous saved state as given here.
 *
 * @return Return the View for the fragment's UI, or null.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public android.view.View onCreateView(android.view.LayoutInflater inflater, @androidx.annotation.Nullable android.view.ViewGroup container, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called immediately after {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)}
 * has returned, but before any saved state has been restored in to the view.
 * This gives subclasses a chance to initialize themselves once
 * they know their view hierarchy has been completely created.  The fragment's
 * view hierarchy is not however attached to its parent at this point.
 * @param view The View returned by {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)}.
 * @param savedInstanceState If non-null, this fragment is being re-constructed
 * from a previous saved state as given here.
 
 * This value may be {@code null}.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public void onViewCreated(android.view.View view, @androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Get the root view for the fragment's layout (the one returned by {@link #onCreateView}),
 * if provided.
 *
 * @return The fragment's root view, or null if it has no layout.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public android.view.View getView() { throw new RuntimeException("Stub!"); }

/**
 * Called when the fragment's activity has been created and this
 * fragment's view hierarchy instantiated.  It can be used to do final
 * initialization once these pieces are in place, such as retrieving
 * views or restoring state.  It is also useful for fragments that use
 * {@link #setRetainInstance(boolean)} to retain their instance,
 * as this callback tells the fragment when it is fully associated with
 * the new activity instance.  This is called after {@link #onCreateView}
 * and before {@link #onViewStateRestored(android.os.Bundle)}.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param savedInstanceState If the fragment is being re-created from
 * a previous saved state, this is the state.
 
 * This value may be {@code null}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onActivityCreated(@androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called when all saved state has been restored into the view hierarchy
 * of the fragment.  This can be used to do initialization based on saved
 * state that you are letting the view hierarchy track itself, such as
 * whether check box widgets are currently checked.  This is called
 * after {@link #onActivityCreated(android.os.Bundle)} and before
 * {@link #onStart()}.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param savedInstanceState If the fragment is being re-created from
 * a previous saved state, this is the state.
 * @apiSince 17
 * @deprecatedSince 28
 */

@Deprecated
public void onViewStateRestored(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Fragment is visible to the user.  This is generally
 * tied to {@link android.app.Activity#onStart() Activity#onStart()} of the containing
 * Activity's lifecycle.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onStart() { throw new RuntimeException("Stub!"); }

/**
 * Called when the fragment is visible to the user and actively running.
 * This is generally
 * tied to {@link android.app.Activity#onResume() Activity#onResume()} of the containing
 * Activity's lifecycle.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onResume() { throw new RuntimeException("Stub!"); }

/**
 * Called to ask the fragment to save its current dynamic state, so it
 * can later be reconstructed in a new instance of its process is
 * restarted.  If a new instance of the fragment later needs to be
 * created, the data you place in the Bundle here will be available
 * in the Bundle given to {@link #onCreate(android.os.Bundle)},
 * {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)}, and
 * {@link #onActivityCreated(android.os.Bundle)}.
 *
 * <p>This corresponds to {@link android.app.Activity#onSaveInstanceState(android.os.Bundle) Activity#onSaveInstanceState(Bundle)} and most of the discussion there
 * applies here as well.  Note however: <em>this method may be called
 * at any time before {@link #onDestroy()}</em>.  There are many situations
 * where a fragment may be mostly torn down (such as when placed on the
 * back stack with no UI showing), but its state will not be saved until
 * its owning activity actually needs to save its state.
 *
 * @param outState Bundle in which to place your saved state.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onSaveInstanceState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Fragment's activity changes from fullscreen mode to multi-window mode and
 * visa-versa. This is generally tied to {@link android.app.Activity#onMultiWindowModeChanged Activity#onMultiWindowModeChanged} of the
 * containing Activity. This method provides the same configuration that will be sent in the
 * following {@link #onConfigurationChanged(android.content.res.Configuration)} call after the activity enters this
 * mode.
 *
 * @param isInMultiWindowMode True if the activity is in multi-window mode.
 * @param newConfig The new configuration of the activity with the state
 *                  {@param isInMultiWindowMode}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onMultiWindowModeChanged(boolean isInMultiWindowMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Fragment's activity changes from fullscreen mode to multi-window mode and
 * visa-versa. This is generally tied to {@link android.app.Activity#onMultiWindowModeChanged Activity#onMultiWindowModeChanged} of the
 * containing Activity.
 *
 * @param isInMultiWindowMode True if the activity is in multi-window mode.
 *
 * @deprecated Use {@link #onMultiWindowModeChanged(boolean,android.content.res.Configuration)} instead.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void onMultiWindowModeChanged(boolean isInMultiWindowMode) { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the activity changes to and from picture-in-picture mode. This is
 * generally tied to {@link android.app.Activity#onPictureInPictureModeChanged Activity#onPictureInPictureModeChanged} of the containing Activity.
 * This method provides the same configuration that will be sent in the following
 * {@link #onConfigurationChanged(android.content.res.Configuration)} call after the activity enters this mode.
 *
 * @param isInPictureInPictureMode True if the activity is in picture-in-picture mode.
 * @param newConfig The new configuration of the activity with the state
 *                  {@param isInPictureInPictureMode}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the activity changes to and from picture-in-picture mode. This is
 * generally tied to {@link android.app.Activity#onPictureInPictureModeChanged Activity#onPictureInPictureModeChanged} of the containing Activity.
 *
 * @param isInPictureInPictureMode True if the activity is in picture-in-picture mode.
 *
 * @deprecated Use {@link #onPictureInPictureModeChanged(boolean,android.content.res.Configuration)} instead.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Fragment is no longer resumed.  This is generally
 * tied to {@link android.app.Activity#onPause() Activity#onPause()} of the containing
 * Activity's lifecycle.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onPause() { throw new RuntimeException("Stub!"); }

/**
 * Called when the Fragment is no longer started.  This is generally
 * tied to {@link android.app.Activity#onStop() Activity#onStop()} of the containing
 * Activity's lifecycle.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onStop() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onLowMemory() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 14
 * @deprecatedSince 28
 */

@Deprecated
public void onTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/**
 * Called when the view previously created by {@link #onCreateView} has
 * been detached from the fragment.  The next time the fragment needs
 * to be displayed, a new view will be created.  This is called
 * after {@link #onStop()} and before {@link #onDestroy()}.  It is called
 * <em>regardless</em> of whether {@link #onCreateView} returned a
 * non-null view.  Internally it is called after the view's state has
 * been saved but before it has been removed from its parent.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDestroyView() { throw new RuntimeException("Stub!"); }

/**
 * Called when the fragment is no longer in use.  This is called
 * after {@link #onStop()} and before {@link #onDetach()}.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Called when the fragment is no longer attached to its activity.  This is called after
 * {@link #onDestroy()}, except in the cases where the fragment instance is retained across
 * Activity re-creation (see {@link #setRetainInstance(boolean)}), in which case it is called
 * after {@link #onStop()}.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDetach() { throw new RuntimeException("Stub!"); }

/**
 * Initialize the contents of the Activity's standard options menu.  You
 * should place your menu items in to <var>menu</var>.  For this method
 * to be called, you must have first called {@link #setHasOptionsMenu}.  See
 * {@link android.app.Activity#onCreateOptionsMenu(android.view.Menu) Activity#onCreateOptionsMenu(Menu)}
 * for more information.
 *
 * @param menu The options menu in which you place your items.
 *
 * @see #setHasOptionsMenu
 * @see #onPrepareOptionsMenu
 * @see #onOptionsItemSelected
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater inflater) { throw new RuntimeException("Stub!"); }

/**
 * Prepare the Screen's standard options menu to be displayed.  This is
 * called right before the menu is shown, every time it is shown.  You can
 * use this method to efficiently enable/disable items or otherwise
 * dynamically modify the contents.  See
 * {@link android.app.Activity#onPrepareOptionsMenu(android.view.Menu) Activity#onPrepareOptionsMenu(Menu)}
 * for more information.
 *
 * @param menu The options menu as last shown or first initialized by
 *             onCreateOptionsMenu().
 *
 * @see #setHasOptionsMenu
 * @see #onCreateOptionsMenu
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onPrepareOptionsMenu(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Called when this fragment's option menu items are no longer being
 * included in the overall options menu.  Receiving this call means that
 * the menu needed to be rebuilt, but this fragment's items were not
 * included in the newly built menu (its {@link #onCreateOptionsMenu(android.view.Menu,android.view.MenuInflater)}
 * was not called).
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDestroyOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * This hook is called whenever an item in your options menu is selected.
 * The default implementation simply returns false to have the normal
 * processing happen (calling the item's Runnable or sending a message to
 * its Handler as appropriate).  You can use this method for any items
 * for which you would like to do processing without those other
 * facilities.
 *
 * <p>Derived classes should call through to the base class for it to
 * perform the default menu handling.
 *
 * @param item The menu item that was selected.
 *
 * @return boolean Return false to allow normal menu processing to
 *         proceed, true to consume it here.
 *
 * @see #onCreateOptionsMenu
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean onOptionsItemSelected(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called whenever the options menu is being closed (either by the user canceling
 * the menu with the back/menu button, or when an item is selected).
 *
 * @param menu The options menu as last shown or first initialized by
 *             onCreateOptionsMenu().
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onOptionsMenuClosed(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Called when a context menu for the {@code view} is about to be shown.
 * Unlike {@link #onCreateOptionsMenu}, this will be called every
 * time the context menu is about to be shown and should be populated for
 * the view (or item inside the view for {@link android.widget.AdapterView AdapterView} subclasses,
 * this can be found in the {@code menuInfo})).
 * <p>
 * Use {@link #onContextItemSelected(android.view.MenuItem)} to know when an
 * item has been selected.
 * <p>
 * The default implementation calls up to
 * {@link android.app.Activity#onCreateContextMenu Activity#onCreateContextMenu}, though
 * you can not call this implementation if you don't want that behavior.
 * <p>
 * It is not safe to hold onto the context menu after this method returns.
 * {@inheritDoc}
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onCreateContextMenu(android.view.ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo) { throw new RuntimeException("Stub!"); }

/**
 * Registers a context menu to be shown for the given view (multiple views
 * can show the context menu). This method will set the
 * {@link android.view.View.OnCreateContextMenuListener OnCreateContextMenuListener} on the view to this fragment, so
 * {@link #onCreateContextMenu(android.view.ContextMenu,android.view.View,android.view.ContextMenu.ContextMenuInfo)} will be
 * called when it is time to show the context menu.
 *
 * @see #unregisterForContextMenu(View)
 * @param view The view that should show a context menu.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void registerForContextMenu(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Prevents a context menu to be shown for the given view. This method will
 * remove the {@link android.view.View.OnCreateContextMenuListener OnCreateContextMenuListener} on the view.
 *
 * @see #registerForContextMenu(View)
 * @param view The view that should stop showing a context menu.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void unregisterForContextMenu(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called whenever an item in a context menu is selected. The
 * default implementation simply returns false to have the normal processing
 * happen (calling the item's Runnable or sending a message to its Handler
 * as appropriate). You can use this method for any items for which you
 * would like to do processing without those other facilities.
 * <p>
 * Use {@link android.view.MenuItem#getMenuInfo() MenuItem#getMenuInfo()} to get extra information set by the
 * View that added this menu item.
 * <p>
 * Derived classes should call through to the base class for it to perform
 * the default menu handling.
 *
 * @param item The context menu item that was selected.
 * @return boolean Return false to allow normal context menu processing to
 *         proceed, true to consume it here.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean onContextItemSelected(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * When custom transitions are used with Fragments, the enter transition callback
 * is called when this Fragment is attached or detached when not popping the back stack.
 *
 * @param callback Used to manipulate the shared element transitions on this Fragment
 *                 when added not as a pop from the back stack.
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setEnterSharedElementCallback(android.app.SharedElementCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * When custom transitions are used with Fragments, the exit transition callback
 * is called when this Fragment is attached or detached when popping the back stack.
 *
 * @param callback Used to manipulate the shared element transitions on this Fragment
 *                 when added as a pop from the back stack.
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setExitSharedElementCallback(android.app.SharedElementCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views into the initial scene. The entering
 * Views will be those that are regular Views or ViewGroups that have
 * {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link android.view.View#INVISIBLE View#INVISIBLE} to {@link android.view.View#VISIBLE View#VISIBLE}. If <code>transition</code> is null,
 * entering Views will remain unaffected.
 *
 * @param transition The Transition to use to move Views into the initial Scene.
 * @attr ref android.R.styleable#Fragment_fragmentEnterTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setEnterTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used to move Views into the initial scene. The entering
 * Views will be those that are regular Views or ViewGroups that have
 * {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link android.view.View#INVISIBLE View#INVISIBLE} to {@link android.view.View#VISIBLE View#VISIBLE}.
 *
 * @return the Transition to use to move Views into the initial Scene.
 * @attr ref android.R.styleable#Fragment_fragmentEnterTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public android.transition.Transition getEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views out of the scene when the Fragment is
 * preparing to be removed, hidden, or detached because of popping the back stack. The exiting
 * Views will be those that are regular Views or ViewGroups that have
 * {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link android.view.View#VISIBLE View#VISIBLE} to {@link android.view.View#INVISIBLE View#INVISIBLE}. If <code>transition</code> is null,
 * entering Views will remain unaffected. If nothing is set, the default will be to
 * use the same value as set in {@link #setEnterTransition(android.transition.Transition)}.
 *
 * @param transition The Transition to use to move Views out of the Scene when the Fragment
 *                   is preparing to close.
 * @attr ref android.R.styleable#Fragment_fragmentExitTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setReturnTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used to move Views out of the scene when the Fragment is
 * preparing to be removed, hidden, or detached because of popping the back stack. The exiting
 * Views will be those that are regular Views or ViewGroups that have
 * {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link android.view.View#VISIBLE View#VISIBLE} to {@link android.view.View#INVISIBLE View#INVISIBLE}. If <code>transition</code> is null,
 * entering Views will remain unaffected.
 *
 * @return the Transition to use to move Views out of the Scene when the Fragment
 *         is preparing to close.
 * @attr ref android.R.styleable#Fragment_fragmentExitTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public android.transition.Transition getReturnTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views out of the scene when the
 * fragment is removed, hidden, or detached when not popping the back stack.
 * The exiting Views will be those that are regular Views or ViewGroups that
 * have {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as exiting is governed by changing visibility
 * from {@link android.view.View#VISIBLE View#VISIBLE} to {@link android.view.View#INVISIBLE View#INVISIBLE}. If transition is null, the views will
 * remain unaffected.
 *
 * @param transition The Transition to use to move Views out of the Scene when the Fragment
 *                   is being closed not due to popping the back stack.
 * @attr ref android.R.styleable#Fragment_fragmentExitTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setExitTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used to move Views out of the scene when the
 * fragment is removed, hidden, or detached when not popping the back stack.
 * The exiting Views will be those that are regular Views or ViewGroups that
 * have {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as exiting is governed by changing visibility
 * from {@link android.view.View#VISIBLE View#VISIBLE} to {@link android.view.View#INVISIBLE View#INVISIBLE}. If transition is null, the views will
 * remain unaffected.
 *
 * @return the Transition to use to move Views out of the Scene when the Fragment
 *         is being closed not due to popping the back stack.
 * @attr ref android.R.styleable#Fragment_fragmentExitTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public android.transition.Transition getExitTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views in to the scene when returning due
 * to popping a back stack. The entering Views will be those that are regular Views
 * or ViewGroups that have {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions
 * will extend {@link android.transition.Visibility} as exiting is governed by changing
 * visibility from {@link android.view.View#VISIBLE View#VISIBLE} to {@link android.view.View#INVISIBLE View#INVISIBLE}. If transition is null,
 * the views will remain unaffected. If nothing is set, the default will be to use the same
 * transition as {@link #setExitTransition(android.transition.Transition)}.
 *
 * @param transition The Transition to use to move Views into the scene when reentering from a
 *                   previously-started Activity.
 * @attr ref android.R.styleable#Fragment_fragmentReenterTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setReenterTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used to move Views in to the scene when returning due
 * to popping a back stack. The entering Views will be those that are regular Views
 * or ViewGroups that have {@link android.view.ViewGroup#isTransitionGroup ViewGroup#isTransitionGroup} return true. Typical Transitions
 * will extend {@link android.transition.Visibility} as exiting is governed by changing
 * visibility from {@link android.view.View#VISIBLE View#VISIBLE} to {@link android.view.View#INVISIBLE View#INVISIBLE}. If transition is null,
 * the views will remain unaffected. If nothing is set, the default will be to use the same
 * transition as {@link #setExitTransition(android.transition.Transition)}.
 *
 * @return the Transition to use to move Views into the scene when reentering from a
 *                   previously-started Activity.
 * @attr ref android.R.styleable#Fragment_fragmentReenterTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public android.transition.Transition getReenterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used for shared elements transferred into the content
 * Scene. Typical Transitions will affect size and location, such as
 * {@link android.transition.ChangeBounds}. A null
 * value will cause transferred shared elements to blink to the final position.
 *
 * @param transition The Transition to use for shared elements transferred into the content
 *                   Scene.
 * @attr ref android.R.styleable#Fragment_fragmentSharedElementEnterTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setSharedElementEnterTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used for shared elements transferred into the content
 * Scene. Typical Transitions will affect size and location, such as
 * {@link android.transition.ChangeBounds}. A null
 * value will cause transferred shared elements to blink to the final position.
 *
 * @return The Transition to use for shared elements transferred into the content
 *                   Scene.
 * @attr ref android.R.styleable#Fragment_fragmentSharedElementEnterTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public android.transition.Transition getSharedElementEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used for shared elements transferred back during a
 * pop of the back stack. This Transition acts in the leaving Fragment.
 * Typical Transitions will affect size and location, such as
 * {@link android.transition.ChangeBounds}. A null
 * value will cause transferred shared elements to blink to the final position.
 * If no value is set, the default will be to use the same value as
 * {@link #setSharedElementEnterTransition(android.transition.Transition)}.
 *
 * @param transition The Transition to use for shared elements transferred out of the content
 *                   Scene.
 * @attr ref android.R.styleable#Fragment_fragmentSharedElementReturnTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setSharedElementReturnTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Return the Transition that will be used for shared elements transferred back during a
 * pop of the back stack. This Transition acts in the leaving Fragment.
 * Typical Transitions will affect size and location, such as
 * {@link android.transition.ChangeBounds}. A null
 * value will cause transferred shared elements to blink to the final position.
 * If no value is set, the default will be to use the same value as
 * {@link #setSharedElementEnterTransition(android.transition.Transition)}.
 *
 * @return The Transition to use for shared elements transferred out of the content
 *                   Scene.
 * @attr ref android.R.styleable#Fragment_fragmentSharedElementReturnTransition
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public android.transition.Transition getSharedElementReturnTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the exit transition and enter transition overlap or not.
 * When true, the enter transition will start as soon as possible. When false, the
 * enter transition will wait until the exit transition completes before starting.
 *
 * @param allow true to start the enter transition when possible or false to
 *              wait until the exiting transition completes.
 * @attr ref android.R.styleable#Fragment_fragmentAllowEnterTransitionOverlap
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setAllowEnterTransitionOverlap(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the exit transition and enter transition overlap or not.
 * When true, the enter transition will start as soon as possible. When false, the
 * enter transition will wait until the exit transition completes before starting.
 *
 * @return true when the enter transition should start as soon as possible or false to
 * when it should wait until the exiting transition completes.
 * @attr ref android.R.styleable#Fragment_fragmentAllowEnterTransitionOverlap
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public boolean getAllowEnterTransitionOverlap() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the return transition and reenter transition overlap or not.
 * When true, the reenter transition will start as soon as possible. When false, the
 * reenter transition will wait until the return transition completes before starting.
 *
 * @param allow true to start the reenter transition when possible or false to wait until the
 *              return transition completes.
 * @attr ref android.R.styleable#Fragment_fragmentAllowReturnTransitionOverlap
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void setAllowReturnTransitionOverlap(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the return transition and reenter transition overlap or not.
 * When true, the reenter transition will start as soon as possible. When false, the
 * reenter transition will wait until the return transition completes before starting.
 *
 * @return true to start the reenter transition when possible or false to wait until the
 *         return transition completes.
 * @attr ref android.R.styleable#Fragment_fragmentAllowReturnTransitionOverlap
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public boolean getAllowReturnTransitionOverlap() { throw new RuntimeException("Stub!"); }

/**
 * Postpone the entering Fragment transition until {@link #startPostponedEnterTransition()}
 * or {@link android.app.FragmentManager#executePendingTransactions() FragmentManager#executePendingTransactions()} has been called.
 * <p>
 * This method gives the Fragment the ability to delay Fragment animations
 * until all data is loaded. Until then, the added, shown, and
 * attached Fragments will be INVISIBLE and removed, hidden, and detached Fragments won't
 * be have their Views removed. The transaction runs when all postponed added Fragments in the
 * transaction have called {@link #startPostponedEnterTransition()}.
 * <p>
 * This method should be called before being added to the FragmentTransaction or
 * in {@link #onCreate(android.os.Bundle)}, {@link #onAttach(android.content.Context)}, or
 * {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)}}.
 * {@link #startPostponedEnterTransition()} must be called to allow the Fragment to
 * start the transitions.
 * <p>
 * When a FragmentTransaction is started that may affect a postponed FragmentTransaction,
 * based on which containers are in their operations, the postponed FragmentTransaction
 * will have its start triggered. The early triggering may result in faulty or nonexistent
 * animations in the postponed transaction. FragmentTransactions that operate only on
 * independent containers will not interfere with each other's postponement.
 * <p>
 * Calling postponeEnterTransition on Fragments with a null View will not postpone the
 * transition. Likewise, postponement only works if FragmentTransaction optimizations are
 * enabled.
 *
 * @see android.app.Activity#postponeEnterTransition()
 * @see android.app.FragmentTransaction#setReorderingAllowed(boolean)
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void postponeEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Begin postponed transitions after {@link #postponeEnterTransition()} was called.
 * If postponeEnterTransition() was called, you must call startPostponedEnterTransition()
 * or {@link android.app.FragmentManager#executePendingTransactions() FragmentManager#executePendingTransactions()} to complete the FragmentTransaction.
 * If postponement was interrupted with {@link android.app.FragmentManager#executePendingTransactions() FragmentManager#executePendingTransactions()},
 * before {@code startPostponedEnterTransition()}, animations may not run or may execute
 * improperly.
 *
 * @see android.app.Activity#startPostponedEnterTransition()
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void startPostponedEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Print the Fragments's state into the given stream.
 *
 * @param prefix Text to print at the front of each line.
 * @param fd The raw file descriptor that the dump is being sent to.
 * @param writer The PrintWriter to which you should dump your state.  This will be
 * closed for you after you return.
 * @param args additional arguments to the dump request.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
/**
 * Thrown by {@link android.app.Fragment#instantiate(android.content.Context,java.lang.String,android.os.Bundle) Fragment#instantiate(Context, String, Bundle)} when
 * there is an instantiation failure.
 *
 * @deprecated Use {@link android.support.v4.app.Fragment.InstantiationException}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class InstantiationException extends android.util.AndroidRuntimeException {

/** @apiSince 11 */

@Deprecated
public InstantiationException(java.lang.String msg, java.lang.Exception cause) { throw new RuntimeException("Stub!"); }
}

/**
 * State information that has been retrieved from a fragment instance
 * through {@link android.app.FragmentManager#saveFragmentInstanceState(android.app.Fragment) FragmentManager#saveFragmentInstanceState(Fragment)}.
 *
 * @deprecated Use {@link android.support.v4.app.Fragment.SavedState}
 * @apiSince 13
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class SavedState implements android.os.Parcelable {

SavedState() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated public static final android.os.Parcelable.ClassLoaderCreator<android.app.Fragment.SavedState> CREATOR;
static { CREATOR = null; }
}

}

