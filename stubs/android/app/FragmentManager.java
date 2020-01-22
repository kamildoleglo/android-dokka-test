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
import android.os.Bundle;
import java.io.PrintWriter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;

/**
 * Interface for interacting with {@link android.app.Fragment Fragment} objects inside of an
 * {@link android.app.Activity Activity}
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using fragments, read the
 * <a href="{@docRoot}guide/components/fragments.html">Fragments</a> developer guide.</p>
 * </div>
 *
 * While the FragmentManager API was introduced in
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB}, a version of the API
 * at is also available for use on older platforms through
 * {@link android.support.v4.app.FragmentActivity}.  See the blog post
 * <a href="http://android-developers.blogspot.com/2011/03/fragments-for-all.html">
 * Fragments For All</a> for more details.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentManager} for consistent behavior across all devices
 *      and access to <a href="{@docRoot}topic/libraries/architecture/lifecycle.html">Lifecycle</a>.
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class FragmentManager {

@Deprecated
public FragmentManager() { throw new RuntimeException("Stub!"); }

/**
 * Start a series of edit operations on the Fragments associated with
 * this FragmentManager.
 *
 * <p>Note: A fragment transaction can only be created/committed prior
 * to an activity saving its state.  If you try to commit a transaction
 * after {@link android.app.Activity#onSaveInstanceState Activity#onSaveInstanceState}
 * (and prior to a following {@link android.app.Activity#onStart Activity#onStart}
 * or {@link android.app.Activity#onResume Activity#onResume}, you will get an error.
 * This is because the framework takes care of saving your current fragments
 * in the state, and if changes are made after the state is saved then they
 * will be lost.</p>
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction beginTransaction();

/**
 * After a {@link android.app.FragmentTransaction FragmentTransaction} is committed with
 * {@link android.app.FragmentTransaction#commit FragmentTransaction#commit}, it
 * is scheduled to be executed asynchronously on the process's main thread.
 * If you want to immediately executing any such pending operations, you
 * can call this function (only from the main thread) to do so.  Note that
 * all callbacks and other related behavior will be done from within this
 * call, so be careful about where this is called from.
 * <p>
 * This also forces the start of any postponed Transactions where
 * {@link android.app.Fragment#postponeEnterTransition() Fragment#postponeEnterTransition()} has been called.
 *
 * @return Returns true if there were any pending transactions to be
 * executed.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean executePendingTransactions();

/**
 * Finds a fragment that was identified by the given id either when inflated
 * from XML or as the container ID when added in a transaction.  This first
 * searches through fragments that are currently added to the manager's
 * activity; if no such fragment is found, then all fragments currently
 * on the back stack associated with this ID are searched.
 * @return The fragment if found or null otherwise.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.Fragment findFragmentById(int id);

/**
 * Finds a fragment that was identified by the given tag either when inflated
 * from XML or as supplied when added in a transaction.  This first
 * searches through fragments that are currently added to the manager's
 * activity; if no such fragment is found, then all fragments currently
 * on the back stack are searched.
 * @return The fragment if found or null otherwise.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.Fragment findFragmentByTag(java.lang.String tag);

/**
 * Pop the top state off the back stack.  This function is asynchronous -- it
 * enqueues the request to pop, but the action will not be performed until the
 * application returns to its event loop.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract void popBackStack();

/**
 * Like {@link #popBackStack()}, but performs the operation immediately
 * inside of the call.  This is like calling {@link #executePendingTransactions()}
 * afterwards without forcing the start of postponed Transactions.
 * @return Returns true if there was something popped, else false.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean popBackStackImmediate();

/**
 * Pop the last fragment transition from the manager's fragment
 * back stack.  If there is nothing to pop, false is returned.
 * This function is asynchronous -- it enqueues the
 * request to pop, but the action will not be performed until the application
 * returns to its event loop.
 *
 * @param name If non-null, this is the name of a previous back state
 * to look for; if found, all states up to that state will be popped.  The
 * {@link #POP_BACK_STACK_INCLUSIVE} flag can be used to control whether
 * the named state itself is popped. If null, only the top state is popped.
 * @param flags Either 0 or {@link #POP_BACK_STACK_INCLUSIVE}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract void popBackStack(java.lang.String name, int flags);

/**
 * Like {@link #popBackStack(java.lang.String,int)}, but performs the operation immediately
 * inside of the call.  This is like calling {@link #executePendingTransactions()}
 * afterwards without forcing the start of postponed Transactions.
 * @return Returns true if there was something popped, else false.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean popBackStackImmediate(java.lang.String name, int flags);

/**
 * Pop all back stack states up to the one with the given identifier.
 * This function is asynchronous -- it enqueues the
 * request to pop, but the action will not be performed until the application
 * returns to its event loop.
 *
 * @param id Identifier of the stated to be popped. If no identifier exists,
 * false is returned.
 * The identifier is the number returned by
 * {@link android.app.FragmentTransaction#commit() FragmentTransaction#commit()}.  The
 * {@link #POP_BACK_STACK_INCLUSIVE} flag can be used to control whether
 * the named state itself is popped.
 * @param flags Either 0 or {@link #POP_BACK_STACK_INCLUSIVE}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract void popBackStack(int id, int flags);

/**
 * Like {@link #popBackStack(int,int)}, but performs the operation immediately
 * inside of the call.  This is like calling {@link #executePendingTransactions()}
 * afterwards without forcing the start of postponed Transactions.
 * @return Returns true if there was something popped, else false.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean popBackStackImmediate(int id, int flags);

/**
 * Return the number of entries currently in the back stack.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract int getBackStackEntryCount();

/**
 * Return the BackStackEntry at index <var>index</var> in the back stack;
 * where the item on the bottom of the stack has index 0.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentManager.BackStackEntry getBackStackEntryAt(int index);

/**
 * Add a new listener for changes to the fragment back stack.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract void addOnBackStackChangedListener(android.app.FragmentManager.OnBackStackChangedListener listener);

/**
 * Remove a listener that was previously added with
 * {@link #addOnBackStackChangedListener(android.app.FragmentManager.OnBackStackChangedListener)}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract void removeOnBackStackChangedListener(android.app.FragmentManager.OnBackStackChangedListener listener);

/**
 * Put a reference to a fragment in a Bundle.  This Bundle can be
 * persisted as saved state, and when later restoring
 * {@link #getFragment(android.os.Bundle,java.lang.String)} will return the current
 * instance of the same fragment.
 *
 * @param bundle The bundle in which to put the fragment reference.
 * @param key The name of the entry in the bundle.
 * @param fragment The Fragment whose reference is to be stored.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract void putFragment(android.os.Bundle bundle, java.lang.String key, android.app.Fragment fragment);

/**
 * Retrieve the current Fragment instance for a reference previously
 * placed with {@link #putFragment(android.os.Bundle,java.lang.String,android.app.Fragment)}.
 *
 * @param bundle The bundle from which to retrieve the fragment reference.
 * @param key The name of the entry in the bundle.
 * @return Returns the current Fragment instance that is associated with
 * the given reference.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.Fragment getFragment(android.os.Bundle bundle, java.lang.String key);

/**
 * Get a list of all fragments that are currently added to the FragmentManager.
 * This may include those that are hidden as well as those that are shown.
 * This will not include any fragments only in the back stack, or fragments that
 * are detached or removed.
 * <p>
 * The order of the fragments in the list is the order in which they were
 * added or attached.
 *
 * @return A list of all fragments that are added to the FragmentManager.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract java.util.List<android.app.Fragment> getFragments();

/**
 * Save the current instance state of the given Fragment.  This can be
 * used later when creating a new instance of the Fragment and adding
 * it to the fragment manager, to have it create itself to match the
 * current state returned here.  Note that there are limits on how
 * this can be used:
 *
 * <ul>
 * <li>The Fragment must currently be attached to the FragmentManager.
 * <li>A new Fragment created using this saved state must be the same class
 * type as the Fragment it was created from.
 * <li>The saved state can not contain dependencies on other fragments --
 * that is it can't use {@link #putFragment(android.os.Bundle,java.lang.String,android.app.Fragment)} to
 * store a fragment reference because that reference may not be valid when
 * this saved state is later used.  Likewise the Fragment's target and
 * result code are not included in this state.
 * </ul>
 *
 * @param f The Fragment whose state is to be saved.
 * @return The generated state.  This will be null if there was no
 * interesting state created by the fragment.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.Fragment.SavedState saveFragmentInstanceState(android.app.Fragment f);

/**
 * Returns true if the final {@link android.app.Activity#onDestroy() Activity#onDestroy()}
 * call has been made on the FragmentManager's Activity, so this instance is now dead.
 * @apiSince 17
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean isDestroyed();

/**
 * Registers a {@link android.app.FragmentManager.FragmentLifecycleCallbacks FragmentLifecycleCallbacks} to listen to fragment lifecycle events
 * happening in this FragmentManager. All registered callbacks will be automatically
 * unregistered when this FragmentManager is destroyed.
 *
 * @param cb Callbacks to register
 * @param recursive true to automatically register this callback for all child FragmentManagers
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract void registerFragmentLifecycleCallbacks(android.app.FragmentManager.FragmentLifecycleCallbacks cb, boolean recursive);

/**
 * Unregisters a previously registered {@link android.app.FragmentManager.FragmentLifecycleCallbacks FragmentLifecycleCallbacks}. If the callback
 * was not previously registered this call has no effect. All registered callbacks will be
 * automatically unregistered when this FragmentManager is destroyed.
 *
 * @param cb Callbacks to unregister
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract void unregisterFragmentLifecycleCallbacks(android.app.FragmentManager.FragmentLifecycleCallbacks cb);

/**
 * Return the currently active primary navigation fragment for this FragmentManager.
 *
 * <p>The primary navigation fragment's
 * {@link android.app.Fragment#getChildFragmentManager() Fragment#getChildFragmentManager()} will be called first
 * to process delegated navigation actions such as {@link #popBackStack()} if no ID
 * or transaction name is provided to pop to.</p>
 *
 * @return the fragment designated as the primary navigation fragment
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.Fragment getPrimaryNavigationFragment();

/**
 * Print the FragmentManager's state into the given stream.
 *
 * @param prefix Text to print at the front of each line.
 * @param fd The raw file descriptor that the dump is being sent to.
 * @param writer A PrintWriter to which the dump is to be set.
 * @param args Additional arguments to the dump request.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args);

/**
 * Control whether the framework's internal fragment manager debugging
 * logs are turned on.  If enabled, you will see output in logcat as
 * the framework performs fragment operations.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public static void enableDebugLogging(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Invalidate the attached activity's options menu as necessary.
 * This may end up being deferred until we move to the resumed state.
 * @apiSince 14
 * @deprecatedSince 28
 */

@Deprecated
public void invalidateOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the FragmentManager's state has already been saved
 * by its host. Any operations that would change saved state should not be performed
 * if this method returns true. For example, any popBackStack() method, such as
 * {@link #popBackStackImmediate()} or any FragmentTransaction using
 * {@link android.app.FragmentTransaction#commit() FragmentTransaction#commit()} instead of
 * {@link android.app.FragmentTransaction#commitAllowingStateLoss() FragmentTransaction#commitAllowingStateLoss()} will change
 * the state and will result in an error.
 *
 * @return true if this FragmentManager's state has already been saved by its host
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean isStateSaved();

/**
 * Flag for {@link #popBackStack(java.lang.String,int)}
 * and {@link #popBackStack(int,int)}: If set, and the name or ID of
 * a back stack entry has been supplied, then all matching entries will
 * be consumed until one that doesn't match is found or the bottom of
 * the stack is reached.  Otherwise, all entries up to but not including that entry
 * will be removed.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int POP_BACK_STACK_INCLUSIVE = 1; // 0x1
/**
 * Representation of an entry on the fragment back stack, as created
 * with {@link android.app.FragmentTransaction#addToBackStack(java.lang.String) FragmentTransaction#addToBackStack(String)}.  Entries can later be
 * retrieved with {@link android.app.FragmentManager#getBackStackEntryAt(int) FragmentManager#getBackStackEntryAt(int)}.
 *
 * <p>Note that you should never hold on to a BackStackEntry object;
 * the identifier as returned by {@link #getId} is the only thing that
 * will be persisted across activity instances.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">
 *      Support Library</a> {@link android.support.v4.app.FragmentManager.BackStackEntry}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface BackStackEntry {

/**
 * Return the unique identifier for the entry.  This is the only
 * representation of the entry that will persist across activity
 * instances.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public int getId();

/**
 * Get the name that was supplied to
 * {@link android.app.FragmentTransaction#addToBackStack(java.lang.String) FragmentTransaction#addToBackStack(String)} when creating this entry.
 * @apiSince 14
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.String getName();

/**
 * Return the full bread crumb title resource identifier for the entry,
 * or 0 if it does not have one.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public int getBreadCrumbTitleRes();

/**
 * Return the short bread crumb title resource identifier for the entry,
 * or 0 if it does not have one.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public int getBreadCrumbShortTitleRes();

/**
 * Return the full bread crumb title for the entry, or null if it
 * does not have one.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.CharSequence getBreadCrumbTitle();

/**
 * Return the short bread crumb title for the entry, or null if it
 * does not have one.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.CharSequence getBreadCrumbShortTitle();
}

/**
 * Callback interface for listening to fragment state changes that happen
 * within a given FragmentManager.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">
 *      Support Library</a>
 *      {@link android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks}
 * @apiSince 26
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract static class FragmentLifecycleCallbacks {

@Deprecated
public FragmentLifecycleCallbacks() { throw new RuntimeException("Stub!"); }

/**
 * Called right before the fragment's {@link android.app.Fragment#onAttach(android.content.Context) Fragment#onAttach(Context)} method is called.
 * This is a good time to inject any required dependencies for the fragment before any of
 * the fragment's lifecycle methods are invoked.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @param context Context that the Fragment is being attached to
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentPreAttached(android.app.FragmentManager fm, android.app.Fragment f, android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has been attached to its host. Its host will have had
 * <code>onAttachFragment</code> called before this call happens.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @param context Context that the Fragment was attached to
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentAttached(android.app.FragmentManager fm, android.app.Fragment f, android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Called right before the fragment's {@link android.app.Fragment#onCreate(android.os.Bundle) Fragment#onCreate(Bundle)} method is called.
 * This is a good time to inject any required dependencies or perform other configuration
 * for the fragment.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @param savedInstanceState Saved instance bundle from a previous instance
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentPreCreated(android.app.FragmentManager fm, android.app.Fragment f, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onCreate(android.os.Bundle) Fragment#onCreate(Bundle)}. This will only happen once for any given
 * fragment instance, though the fragment may be attached and detached multiple times.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @param savedInstanceState Saved instance bundle from a previous instance
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentCreated(android.app.FragmentManager fm, android.app.Fragment f, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onActivityCreated(android.os.Bundle) Fragment#onActivityCreated(Bundle)}. This will only happen once for any given
 * fragment instance, though the fragment may be attached and detached multiple times.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @param savedInstanceState Saved instance bundle from a previous instance
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentActivityCreated(android.app.FragmentManager fm, android.app.Fragment f, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned a non-null view from the FragmentManager's
 * request to {@link android.app.Fragment#onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle) Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment that created and owns the view
 * @param v View returned by the fragment
 * @param savedInstanceState Saved instance bundle from a previous instance
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentViewCreated(android.app.FragmentManager fm, android.app.Fragment f, android.view.View v, android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onStart() Fragment#onStart()}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentStarted(android.app.FragmentManager fm, android.app.Fragment f) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onResume() Fragment#onResume()}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentResumed(android.app.FragmentManager fm, android.app.Fragment f) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onPause() Fragment#onPause()}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentPaused(android.app.FragmentManager fm, android.app.Fragment f) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onStop() Fragment#onStop()}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentStopped(android.app.FragmentManager fm, android.app.Fragment f) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onSaveInstanceState(android.os.Bundle) Fragment#onSaveInstanceState(Bundle)}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @param outState Saved state bundle for the fragment
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentSaveInstanceState(android.app.FragmentManager fm, android.app.Fragment f, android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onDestroyView() Fragment#onDestroyView()}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentViewDestroyed(android.app.FragmentManager fm, android.app.Fragment f) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onDestroy() Fragment#onDestroy()}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentDestroyed(android.app.FragmentManager fm, android.app.Fragment f) { throw new RuntimeException("Stub!"); }

/**
 * Called after the fragment has returned from the FragmentManager's call to
 * {@link android.app.Fragment#onDetach() Fragment#onDetach()}.
 *
 * @param fm Host FragmentManager
 * @param f Fragment changing state
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void onFragmentDetached(android.app.FragmentManager fm, android.app.Fragment f) { throw new RuntimeException("Stub!"); }
}

/**
 * Interface to watch for changes to the back stack.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">
 *      Support Library</a>
 *      {@link android.support.v4.app.FragmentManager.OnBackStackChangedListener}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnBackStackChangedListener {

/**
 * Called whenever the contents of the back stack change.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onBackStackChanged();
}

}

