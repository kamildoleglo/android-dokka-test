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

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.Window;
import android.content.DialogInterface;

/**
 * A fragment that displays a dialog window, floating on top of its
 * activity's window.  This fragment contains a Dialog object, which it
 * displays as appropriate based on the fragment's state.  Control of
 * the dialog (deciding when to show, hide, dismiss it) should be done through
 * the API here, not with direct calls on the dialog.
 *
 * <p>Implementations should override this class and implement
 * {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)} to supply the
 * content of the dialog.  Alternatively, they can override
 * {@link #onCreateDialog(android.os.Bundle)} to create an entirely custom dialog, such
 * as an AlertDialog, with its own content.
 *
 * <p>Topics covered here:
 * <ol>
 * <li><a href="#Lifecycle">Lifecycle</a>
 * <li><a href="#BasicDialog">Basic Dialog</a>
 * <li><a href="#AlertDialog">Alert Dialog</a>
 * <li><a href="#DialogOrEmbed">Selecting Between Dialog or Embedding</a>
 * </ol>
 *
 * <a name="Lifecycle"></a>
 * <h3>Lifecycle</h3>
 *
 * <p>DialogFragment does various things to keep the fragment's lifecycle
 * driving it, instead of the Dialog.  Note that dialogs are generally
 * autonomous entities -- they are their own window, receiving their own
 * input events, and often deciding on their own when to disappear (by
 * receiving a back key event or the user clicking on a button).
 *
 * <p>DialogFragment needs to ensure that what is happening with the Fragment
 * and Dialog states remains consistent.  To do this, it watches for dismiss
 * events from the dialog and takes care of removing its own state when they
 * happen.  This means you should use {@link #show(android.app.FragmentManager,java.lang.String)}
 * or {@link #show(android.app.FragmentTransaction,java.lang.String)} to add an instance of
 * DialogFragment to your UI, as these keep track of how DialogFragment should
 * remove itself when the dialog is dismissed.
 *
 * <a name="BasicDialog"></a>
 * <h3>Basic Dialog</h3>
 *
 * <p>The simplest use of DialogFragment is as a floating container for the
 * fragment's view hierarchy.  A simple implementation may look like this:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentDialog.java
 *      dialog}
 *
 * <p>An example showDialog() method on the Activity could be:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentDialog.java
 *      add_dialog}
 *
 * <p>This removes any currently shown dialog, creates a new DialogFragment
 * with an argument, and shows it as a new state on the back stack.  When the
 * transaction is popped, the current DialogFragment and its Dialog will be
 * destroyed, and the previous one (if any) re-shown.  Note that in this case
 * DialogFragment will take care of popping the transaction of the Dialog
 * is dismissed separately from it.
 *
 * <a name="AlertDialog"></a>
 * <h3>Alert Dialog</h3>
 *
 * <p>Instead of (or in addition to) implementing {@link #onCreateView} to
 * generate the view hierarchy inside of a dialog, you may implement
 * {@link #onCreateDialog(android.os.Bundle)} to create your own custom Dialog object.
 *
 * <p>This is most useful for creating an {@link android.app.AlertDialog AlertDialog}, allowing you
 * to display standard alerts to the user that are managed by a fragment.
 * A simple example implementation of this is:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentAlertDialog.java
 *      dialog}
 *
 * <p>The activity creating this fragment may have the following methods to
 * show the dialog and receive results from it:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentAlertDialog.java
 *      activity}
 *
 * <p>Note that in this case the fragment is not placed on the back stack, it
 * is just added as an indefinitely running fragment.  Because dialogs normally
 * are modal, this will still operate as a back stack, since the dialog will
 * capture user input until it is dismissed.  When it is dismissed, DialogFragment
 * will take care of removing itself from its fragment manager.
 *
 * <a name="DialogOrEmbed"></a>
 * <h3>Selecting Between Dialog or Embedding</h3>
 *
 * <p>A DialogFragment can still optionally be used as a normal fragment, if
 * desired.  This is useful if you have a fragment that in some cases should
 * be shown as a dialog and others embedded in a larger UI.  This behavior
 * will normally be automatically selected for you based on how you are using
 * the fragment, but can be customized with {@link #setShowsDialog(boolean)}.
 *
 * <p>For example, here is a simple dialog fragment:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentDialogOrActivity.java
 *      dialog}
 *
 * <p>An instance of this fragment can be created and shown as a dialog:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentDialogOrActivity.java
 *      show_dialog}
 *
 * <p>It can also be added as content in a view hierarchy:
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentDialogOrActivity.java
 *      embed}
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.DialogFragment} for consistent behavior across all devices
 *      and access to <a href="{@docRoot}topic/libraries/architecture/lifecycle.html">Lifecycle</a>.
 * @apiSince 11
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class DialogFragment extends android.app.Fragment implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener {

/** @apiSince 11 */

@Deprecated
public DialogFragment() { throw new RuntimeException("Stub!"); }

/**
 * Call to customize the basic appearance and behavior of the
 * fragment's dialog.  This can be used for some common dialog behaviors,
 * taking care of selecting flags, theme, and other options for you.  The
 * same effect can be achieve by manually setting Dialog and Window
 * attributes yourself.  Calling this after the fragment's Dialog is
 * created will have no effect.
 *
 * @param style Selects a standard style: may be {@link #STYLE_NORMAL},
 * {@link #STYLE_NO_TITLE}, {@link #STYLE_NO_FRAME}, or
 * {@link #STYLE_NO_INPUT}.
 * @param theme Optional custom theme.  If 0, an appropriate theme (based
 * on the style) will be selected for you.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setStyle(int style, int theme) { throw new RuntimeException("Stub!"); }

/**
 * Display the dialog, adding the fragment to the given FragmentManager.  This
 * is a convenience for explicitly creating a transaction, adding the
 * fragment to it with the given tag, and committing it.  This does
 * <em>not</em> add the transaction to the back stack.  When the fragment
 * is dismissed, a new transaction will be executed to remove it from
 * the activity.
 * @param manager The FragmentManager this fragment will be added to.
 * @param tag The tag for this fragment, as per
 * {@link android.app.FragmentTransaction#add(android.app.Fragment,java.lang.String) FragmentTransaction#add(Fragment, String)}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void show(android.app.FragmentManager manager, java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Display the dialog, adding the fragment using an existing transaction
 * and then committing the transaction.
 * @param transaction An existing transaction in which to add the fragment.
 * @param tag The tag for this fragment, as per
 * {@link android.app.FragmentTransaction#add(android.app.Fragment,java.lang.String) FragmentTransaction#add(Fragment, String)}.
 * @return Returns the identifier of the committed transaction, as per
 * {@link android.app.FragmentTransaction#commit() FragmentTransaction#commit()}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public int show(android.app.FragmentTransaction transaction, java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Dismiss the fragment and its dialog.  If the fragment was added to the
 * back stack, all back stack state up to and including this entry will
 * be popped.  Otherwise, a new transaction will be committed to remove
 * the fragment.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void dismiss() { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link #dismiss()} that uses
 * {@link android.app.FragmentTransaction#commitAllowingStateLoss() FragmentTransaction#commitAllowingStateLoss()}.  See linked
 * documentation for further details.
 * @apiSince 12
 * @deprecatedSince 28
 */

@Deprecated
public void dismissAllowingStateLoss() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Dialog getDialog() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public int getTheme() { throw new RuntimeException("Stub!"); }

/**
 * Control whether the shown Dialog is cancelable.  Use this instead of
 * directly calling {@link android.app.Dialog#setCancelable(boolean) Dialog#setCancelable(boolean)}, because DialogFragment needs to change
 * its behavior based on this.
 *
 * @param cancelable If true, the dialog is cancelable.  The default
 * is true.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setCancelable(boolean cancelable) { throw new RuntimeException("Stub!"); }

/**
 * Return the current value of {@link #setCancelable(boolean)}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean isCancelable() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether this fragment should be shown in a dialog.  If not
 * set, no Dialog will be created in {@link #onActivityCreated(android.os.Bundle)},
 * and the fragment's view hierarchy will thus not be added to it.  This
 * allows you to instead use it as a normal fragment (embedded inside of
 * its activity).
 *
 * <p>This is normally set for you based on whether the fragment is
 * associated with a container view ID passed to
 * {@link android.app.FragmentTransaction#add(int,android.app.Fragment) FragmentTransaction#add(int, Fragment)}.
 * If the fragment was added with a container, setShowsDialog will be
 * initialized to false; otherwise, it will be true.
 *
 * @param showsDialog If true, the fragment will be displayed in a Dialog.
 * If false, no Dialog will be created and the fragment's view hierarchly
 * left undisturbed.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void setShowsDialog(boolean showsDialog) { throw new RuntimeException("Stub!"); }

/**
 * Return the current value of {@link #setShowsDialog(boolean)}.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public boolean getShowsDialog() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public void onAttach(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDetach() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/** @hide */

public android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Override to build your own custom Dialog container.  This is typically
 * used to show an AlertDialog instead of a generic Dialog; when doing so,
 * {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)} does not need
 * to be implemented since the AlertDialog takes care of its own content.
 *
 * <p>This method will be called after {@link #onCreate(android.os.Bundle)} and
 * before {@link #onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle)}.  The
 * default implementation simply instantiates and returns a {@link android.app.Dialog Dialog}
 * class.
 *
 * <p><em>Note: DialogFragment own the {@link android.app.Dialog#setOnCancelListener Dialog#setOnCancelListener} and {@link android.app.Dialog#setOnDismissListener Dialog#setOnDismissListener} callbacks.  You must not set them yourself.</em>
 * To find out about these events, override {@link #onCancel(android.content.DialogInterface)}
 * and {@link #onDismiss(android.content.DialogInterface)}.</p>
 *
 * @param savedInstanceState The last saved instance state of the Fragment,
 * or null if this is a freshly created Fragment.
 *
 * @return Return a new Dialog instance to be displayed by the Fragment.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public android.app.Dialog onCreateDialog(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onCancel(android.content.DialogInterface dialog) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDismiss(android.content.DialogInterface dialog) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onActivityCreated(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onStart() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onSaveInstanceState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onStop() { throw new RuntimeException("Stub!"); }

/**
 * Remove dialog.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void onDestroyView() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated
public void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Style for {@link #setStyle(int,int)}: a basic,
 * normal dialog.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int STYLE_NORMAL = 0; // 0x0

/**
 * Style for {@link #setStyle(int,int)}: don't draw
 * any frame at all; the view hierarchy returned by {@link #onCreateView}
 * is entirely responsible for drawing the dialog.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int STYLE_NO_FRAME = 2; // 0x2

/**
 * Style for {@link #setStyle(int,int)}: like
 * {@link #STYLE_NO_FRAME}, but also disables all input to the dialog.
 * The user can not touch it, and its window will not receive input focus.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int STYLE_NO_INPUT = 3; // 0x3

/**
 * Style for {@link #setStyle(int,int)}: don't include
 * a title area.
 * @apiSince 11
 * @deprecatedSince 28
 */

@Deprecated public static final int STYLE_NO_TITLE = 1; // 0x1
}

