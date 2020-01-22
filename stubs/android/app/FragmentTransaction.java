
package android.app;

import android.view.View;
import android.os.Bundle;

/**
 * API for performing a set of Fragment operations.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using fragments, read the
 * <a href="{@docRoot}guide/components/fragments.html">Fragments</a> developer
 * guide.</p>
 * </div>
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentTransaction}
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class FragmentTransaction {

@Deprecated
public FragmentTransaction() { throw new RuntimeException("Stub!"); }

/**
 * Calls {@link #add(int,android.app.Fragment,java.lang.String)} with a 0 containerViewId.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction add(android.app.Fragment fragment, java.lang.String tag);

/**
 * Calls {@link #add(int,android.app.Fragment,java.lang.String)} with a null tag.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction add(int containerViewId, android.app.Fragment fragment);

/**
 * Add a fragment to the activity state.  This fragment may optionally
 * also have its view (if {@link android.app.Fragment#onCreateView Fragment#onCreateView}
 * returns non-null) inserted into a container view of the activity.
 *
 * @param containerViewId Optional identifier of the container this fragment is
 * to be placed in.  If 0, it will not be placed in a container.
 * @param fragment The fragment to be added.  This fragment must not already
 * be added to the activity.
 * @param tag Optional tag name for the fragment, to later retrieve the
 * fragment with {@link android.app.FragmentManager#findFragmentByTag(java.lang.String) FragmentManager#findFragmentByTag(String)}.
 *
 * @return Returns the same FragmentTransaction instance.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction add(int containerViewId, android.app.Fragment fragment, java.lang.String tag);

/**
 * Calls {@link #replace(int,android.app.Fragment,java.lang.String)} with a null tag.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction replace(int containerViewId, android.app.Fragment fragment);

/**
 * Replace an existing fragment that was added to a container.  This is
 * essentially the same as calling {@link #remove(android.app.Fragment)} for all
 * currently added fragments that were added with the same containerViewId
 * and then {@link #add(int,android.app.Fragment,java.lang.String)} with the same arguments
 * given here.
 *
 * @param containerViewId Identifier of the container whose fragment(s) are
 * to be replaced.
 * @param fragment The new fragment to place in the container.
 * @param tag Optional tag name for the fragment, to later retrieve the
 * fragment with {@link android.app.FragmentManager#findFragmentByTag(java.lang.String) FragmentManager#findFragmentByTag(String)}.
 *
 * @return Returns the same FragmentTransaction instance.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction replace(int containerViewId, android.app.Fragment fragment, java.lang.String tag);

/**
 * Remove an existing fragment.  If it was added to a container, its view
 * is also removed from that container.
 *
 * @param fragment The fragment to be removed.
 *
 * @return Returns the same FragmentTransaction instance.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction remove(android.app.Fragment fragment);

/**
 * Hides an existing fragment.  This is only relevant for fragments whose
 * views have been added to a container, as this will cause the view to
 * be hidden.
 *
 * @param fragment The fragment to be hidden.
 *
 * @return Returns the same FragmentTransaction instance.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction hide(android.app.Fragment fragment);

/**
 * Shows a previously hidden fragment.  This is only relevant for fragments whose
 * views have been added to a container, as this will cause the view to
 * be shown.
 *
 * @param fragment The fragment to be shown.
 *
 * @return Returns the same FragmentTransaction instance.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction show(android.app.Fragment fragment);

/**
 * Detach the given fragment from the UI.  This is the same state as
 * when it is put on the back stack: the fragment is removed from
 * the UI, however its state is still being actively managed by the
 * fragment manager.  When going into this state its view hierarchy
 * is destroyed.
 *
 * @param fragment The fragment to be detached.
 *
 * @return Returns the same FragmentTransaction instance.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction detach(android.app.Fragment fragment);

/**
 * Re-attach a fragment after it had previously been detached from
 * the UI with {@link #detach(android.app.Fragment)}.  This
 * causes its view hierarchy to be re-created, attached to the UI,
 * and displayed.
 *
 * @param fragment The fragment to be attached.
 *
 * @return Returns the same FragmentTransaction instance.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction attach(android.app.Fragment fragment);

/**
 * Set a currently active fragment in this FragmentManager as the primary navigation fragment.
 *
 * <p>The primary navigation fragment's
 * {@link android.app.Fragment#getChildFragmentManager() Fragment#getChildFragmentManager()} will be called first
 * to process delegated navigation actions such as {@link android.app.FragmentManager#popBackStack() FragmentManager#popBackStack()}
 * if no ID or transaction name is provided to pop to. Navigation operations outside of the
 * fragment system may choose to delegate those actions to the primary navigation fragment
 * as returned by {@link android.app.FragmentManager#getPrimaryNavigationFragment() FragmentManager#getPrimaryNavigationFragment()}.</p>
 *
 * <p>The fragment provided must currently be added to the FragmentManager to be set as
 * a primary navigation fragment, or previously added as part of this transaction.</p>
 *
 * @param fragment the fragment to set as the primary navigation fragment
 * @return the same FragmentTransaction instance
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setPrimaryNavigationFragment(android.app.Fragment fragment);

/**
 * @return <code>true</code> if this transaction contains no operations,
 * <code>false</code> otherwise.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean isEmpty();

/**
 * Set specific animation resources to run for the fragments that are
 * entering and exiting in this transaction. These animations will not be
 * played when popping the back stack.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setCustomAnimations(int enter, int exit);

/**
 * Set specific animation resources to run for the fragments that are
 * entering and exiting in this transaction. The <code>popEnter</code>
 * and <code>popExit</code> animations will be played for enter/exit
 * operations specifically when popping the back stack.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setCustomAnimations(int enter, int exit, int popEnter, int popExit);

/**
 * Select a standard transition animation for this transaction.  May be
 * one of {@link #TRANSIT_NONE}, {@link #TRANSIT_FRAGMENT_OPEN},
 * {@link #TRANSIT_FRAGMENT_CLOSE}, or {@link #TRANSIT_FRAGMENT_FADE}.
 
 * @param transit Value is {@link android.app.FragmentTransaction#TRANSIT_NONE}, {@link android.app.FragmentTransaction#TRANSIT_FRAGMENT_OPEN}, {@link android.app.FragmentTransaction#TRANSIT_FRAGMENT_CLOSE}, or {@link android.app.FragmentTransaction#TRANSIT_FRAGMENT_FADE}
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setTransition(int transit);

/**
 * Used with to map a View from a removed or hidden Fragment to a View from a shown
 * or added Fragment.
 * @param sharedElement A View in a disappearing Fragment to match with a View in an
 *                      appearing Fragment.
 * @param name The transitionName for a View in an appearing Fragment to match to the shared
 *             element.
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction addSharedElement(android.view.View sharedElement, java.lang.String name);

/**
 * Set a custom style resource that will be used for resolving transit
 * animations.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setTransitionStyle(int styleRes);

/**
 * Add this transaction to the back stack.  This means that the transaction
 * will be remembered after it is committed, and will reverse its operation
 * when later popped off the stack.
 *
 * @param name An optional name for this back stack state, or null.
 
 * This value may be {@code null}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction addToBackStack(@androidx.annotation.Nullable java.lang.String name);

/**
 * Returns true if this FragmentTransaction is allowed to be added to the back
 * stack. If this method would return false, {@link #addToBackStack(java.lang.String)}
 * will throw {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * @return True if {@link #addToBackStack(java.lang.String)} is permitted on this transaction.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract boolean isAddToBackStackAllowed();

/**
 * Disallow calls to {@link #addToBackStack(java.lang.String)}. Any future calls to
 * addToBackStack will throw {@link java.lang.IllegalStateException IllegalStateException}. If addToBackStack
 * has already been called, this method will throw IllegalStateException.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction disallowAddToBackStack();

/**
 * Set the full title to show as a bread crumb when this transaction
 * is on the back stack, as used by {@link android.app.FragmentBreadCrumbs FragmentBreadCrumbs}.
 *
 * @param res A string resource containing the title.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setBreadCrumbTitle(int res);

/**
 * Like {@link #setBreadCrumbTitle(int)} but taking a raw string; this
 * method is <em>not</em> recommended, as the string can not be changed
 * later if the locale changes.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setBreadCrumbTitle(java.lang.CharSequence text);

/**
 * Set the short title to show as a bread crumb when this transaction
 * is on the back stack, as used by {@link android.app.FragmentBreadCrumbs FragmentBreadCrumbs}.
 *
 * @param res A string resource containing the title.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setBreadCrumbShortTitle(int res);

/**
 * Like {@link #setBreadCrumbShortTitle(int)} but taking a raw string; this
 * method is <em>not</em> recommended, as the string can not be changed
 * later if the locale changes.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setBreadCrumbShortTitle(java.lang.CharSequence text);

/**
 * Sets whether or not to allow optimizing operations within and across
 * transactions. This will remove redundant operations, eliminating
 * operations that cancel. For example, if two transactions are executed
 * together, one that adds a fragment A and the next replaces it with fragment B,
 * the operations will cancel and only fragment B will be added. That means that
 * fragment A may not go through the creation/destruction lifecycle.
 * <p>
 * The side effect of removing redundant operations is that fragments may have state changes
 * out of the expected order. For example, one transaction adds fragment A,
 * a second adds fragment B, then a third removes fragment A. Without removing the redundant
 * operations, fragment B could expect that while it is being created, fragment A will also
 * exist because fragment A will be removed after fragment B was added.
 * With removing redundant operations, fragment B cannot expect fragment A to exist when
 * it has been created because fragment A's add/remove will be optimized out.
 * <p>
 * It can also reorder the state changes of Fragments to allow for better Transitions.
 * Added Fragments may have {@link android.app.Fragment#onCreate(android.os.Bundle) Fragment#onCreate(Bundle)} called before replaced
 * Fragments have {@link android.app.Fragment#onDestroy() Fragment#onDestroy()} called.
 * <p>
 * The default is {@code false} for applications targeting version
 * versions prior to O and {@code true} for applications targeting O and
 * later.
 *
 * @param reorderingAllowed {@code true} to enable optimizing out redundant operations
 *                          or {@code false} to disable optimizing out redundant
 *                          operations on this transaction.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction setReorderingAllowed(boolean reorderingAllowed);

/**
 * Add a Runnable to this transaction that will be run after this transaction has
 * been committed. If fragment transactions are {@link #setReorderingAllowed(boolean) optimized}
 * this may be after other subsequent fragment operations have also taken place, or operations
 * in this transaction may have been optimized out due to the presence of a subsequent
 * fragment transaction in the batch.
 *
 *
 * <p>If a transaction is committed using {@link #commitAllowingStateLoss()} this runnable
 * may be executed when the FragmentManager is in a state where new transactions may not
 * be committed without allowing state loss.</p>
 *
 * <p><code>runOnCommit</code> may not be used with transactions
 * {@link #addToBackStack(java.lang.String) added to the back stack} as Runnables cannot be persisted
 * with back stack state. {@link java.lang.IllegalStateException IllegalStateException} will be thrown if
 * {@link #addToBackStack(java.lang.String)} has been previously called for this transaction
 * or if it is called after a call to <code>runOnCommit</code>.</p>
 *
 * @param runnable Runnable to add
 * @return this FragmentTransaction
 * @throws java.lang.IllegalStateException if {@link #addToBackStack(java.lang.String)} has been called
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public abstract android.app.FragmentTransaction runOnCommit(java.lang.Runnable runnable);

/**
 * Schedules a commit of this transaction.  The commit does
 * not happen immediately; it will be scheduled as work on the main thread
 * to be done the next time that thread is ready.
 *
 * <p class="note">A transaction can only be committed with this method
 * prior to its containing activity saving its state.  If the commit is
 * attempted after that point, an exception will be thrown.  This is
 * because the state after the commit can be lost if the activity needs to
 * be restored from its state.  See {@link #commitAllowingStateLoss()} for
 * situations where it may be okay to lose the commit.</p>
 *
 * @return Returns the identifier of this transaction's back stack entry,
 * if {@link #addToBackStack(java.lang.String)} had been called.  Otherwise, returns
 * a negative number.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract int commit();

/**
 * Like {@link #commit} but allows the commit to be executed after an
 * activity's state is saved.  This is dangerous because the commit can
 * be lost if the activity needs to later be restored from its state, so
 * this should only be used for cases where it is okay for the UI state
 * to change unexpectedly on the user.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public abstract int commitAllowingStateLoss();

/**
 * Commits this transaction synchronously. Any added fragments will be
 * initialized and brought completely to the lifecycle state of their host
 * and any removed fragments will be torn down accordingly before this
 * call returns. Committing a transaction in this way allows fragments
 * to be added as dedicated, encapsulated components that monitor the
 * lifecycle state of their host while providing firmer ordering guarantees
 * around when those fragments are fully initialized and ready. Fragments
 * that manage views will have those views created and attached.
 *
 * <p>Calling <code>commitNow</code> is preferable to calling
 * {@link #commit()} followed by {@link android.app.FragmentManager#executePendingTransactions() FragmentManager#executePendingTransactions()}
 * as the latter will have the side effect of attempting to commit <em>all</em>
 * currently pending transactions whether that is the desired behavior
 * or not.</p>
 *
 * <p>Transactions committed in this way may not be added to the
 * FragmentManager's back stack, as doing so would break other expected
 * ordering guarantees for other asynchronously committed transactions.
 * This method will throw {@link java.lang.IllegalStateException IllegalStateException} if the transaction
 * previously requested to be added to the back stack with
 * {@link #addToBackStack(java.lang.String)}.</p>
 *
 * <p class="note">A transaction can only be committed with this method
 * prior to its containing activity saving its state.  If the commit is
 * attempted after that point, an exception will be thrown.  This is
 * because the state after the commit can be lost if the activity needs to
 * be restored from its state.  See {@link #commitAllowingStateLoss()} for
 * situations where it may be okay to lose the commit.</p>
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public abstract void commitNow();

/**
 * Like {@link #commitNow} but allows the commit to be executed after an
 * activity's state is saved.  This is dangerous because the commit can
 * be lost if the activity needs to later be restored from its state, so
 * this should only be used for cases where it is okay for the UI state
 * to change unexpectedly on the user.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated
public abstract void commitNowAllowingStateLoss();

/**
 * Bit mask that is set for all enter transitions.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int TRANSIT_ENTER_MASK = 4096; // 0x1000

/**
 * Bit mask that is set for all exit transitions.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int TRANSIT_EXIT_MASK = 8192; // 0x2000

/**
 * Fragment is being removed from the stack
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int TRANSIT_FRAGMENT_CLOSE = 8194; // 0x2002

/** Fragment should simply fade in or out; that is, no strong navigation associated
 * with it except that it is appearing or disappearing for some reason.     * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int TRANSIT_FRAGMENT_FADE = 4099; // 0x1003

/**
 * Fragment is being added onto the stack
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int TRANSIT_FRAGMENT_OPEN = 4097; // 0x1001

/**
 * No animation for transition.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int TRANSIT_NONE = 0; // 0x0

/**
 * Not set up for a transition.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int TRANSIT_UNSET = -1; // 0xffffffff
}

