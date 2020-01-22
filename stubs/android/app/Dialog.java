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

import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.content.res.Resources;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.view.KeyEvent;
import android.os.Build;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SearchEvent;
import android.graphics.drawable.Drawable;
import android.content.DialogInterface;

/**
 * Base class for Dialogs.
 *
 * <p>Note: Activities provide a facility to manage the creation, saving and
 * restoring of dialogs. See {@link android.app.Activity#onCreateDialog(int) Activity#onCreateDialog(int)},
 * {@link android.app.Activity#onPrepareDialog(int,android.app.Dialog) Activity#onPrepareDialog(int, Dialog)},
 * {@link android.app.Activity#showDialog(int) Activity#showDialog(int)}, and {@link android.app.Activity#dismissDialog(int) Activity#dismissDialog(int)}. If
 * these methods are used, {@link #getOwnerActivity()} will return the Activity
 * that managed this dialog.
 *
 * <p>Often you will want to have a Dialog display on top of the current
 * input method, because there is no reason for it to accept text.  You can
 * do this by setting the {@link android.view.WindowManager.LayoutParams#FLAG_ALT_FOCUSABLE_IM WindowManager.LayoutParams#FLAG_ALT_FOCUSABLE_IM} window flag (assuming
 * your Dialog takes input focus, as it the default) with the following code:
 *
 * <pre>
 * getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
 *         WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);</pre>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating dialogs, read the
 * <a href="{@docRoot}guide/topics/ui/dialogs.html">Dialogs</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Dialog implements android.content.DialogInterface, android.view.Window.Callback, android.view.KeyEvent.Callback, android.view.View.OnCreateContextMenuListener {

/**
 * Creates a dialog window that uses the default dialog theme.
 * <p>
 * The supplied {@code context} is used to obtain the window manager and
 * base theme used to present the dialog.
 *
 * @param context the context in which the dialog should run
 * This value must never be {@code null}.
 * @see android.R.styleable#Theme_dialogTheme
 * @apiSince 1
 */

public Dialog(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Creates a dialog window that uses a custom dialog style.
 * <p>
 * The supplied {@code context} is used to obtain the window manager and
 * base theme used to present the dialog.
 * <p>
 * The supplied {@code theme} is applied on top of the context's theme. See
 * <a href="{@docRoot}guide/topics/resources/available-resources.html#stylesandthemes">
 * Style and Theme Resources</a> for more information about defining and
 * using styles.
 *
 * @param context the context in which the dialog should run
 * This value must never be {@code null}.
 * @param themeResId a style resource describing the theme to use for the
 *              window, or {@code 0} to use the default dialog theme
 * @apiSince 1
 */

public Dialog(@androidx.annotation.NonNull android.content.Context context, int themeResId) { throw new RuntimeException("Stub!"); }

/**
 * @param context This value must never be {@code null}.
 
 * @param cancelListener This value may be {@code null}.
 * @apiSince 1
 */

protected Dialog(@androidx.annotation.NonNull android.content.Context context, boolean cancelable, @androidx.annotation.Nullable android.content.DialogInterface.OnCancelListener cancelListener) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the Context this Dialog is running in.
 *
 * @return Context The Context used by the Dialog.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.app.ActionBar ActionBar} attached to this dialog, if present.
 *
 * @return The ActionBar attached to the dialog or null if no ActionBar is present.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.app.ActionBar getActionBar() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Activity that owns this dialog. An example use: This Dialog will
 * use the suggested volume control stream of the Activity.
 *
 * @param activity The Activity that owns this dialog.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public final void setOwnerActivity(@androidx.annotation.NonNull android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Activity that owns this Dialog. For example, if
 * {@link android.app.Activity#showDialog(int) Activity#showDialog(int)} is used to show this Dialog, that
 * Activity will be the owner (by default). Depending on how this dialog was
 * created, this may return null.
 *
 * @return The Activity that owns this Dialog.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final android.app.Activity getOwnerActivity() { throw new RuntimeException("Stub!"); }

/**
 * @return Whether the dialog is currently showing.
 * @apiSince 1
 */

public boolean isShowing() { throw new RuntimeException("Stub!"); }

/**
 * Forces immediate creation of the dialog.
 * <p>
 * Note that you should not override this method to perform dialog creation.
 * Rather, override {@link #onCreate(android.os.Bundle)}.
 * @apiSince 21
 */

public void create() { throw new RuntimeException("Stub!"); }

/**
 * Start the dialog and display it on screen.  The window is placed in the
 * application layer and opaque.  Note that you should not override this
 * method to do initialization when the dialog is shown, instead implement
 * that in {@link #onStart}.
 * @apiSince 1
 */

public void show() { throw new RuntimeException("Stub!"); }

/**
 * Hide the dialog, but do not dismiss it.
 * @apiSince 1
 */

public void hide() { throw new RuntimeException("Stub!"); }

/**
 * Dismiss this dialog, removing it from the screen. This method can be
 * invoked safely from any thread.  Note that you should not override this
 * method to do cleanup when the dialog is dismissed, instead implement
 * that in {@link #onStop}.
 * @apiSince 1
 */

public void dismiss() { throw new RuntimeException("Stub!"); }

/**
 * Similar to {@link android.app.Activity#onCreate Activity#onCreate}, you should initialize your dialog
 * in this method, including calling {@link #setContentView}.
 * @param savedInstanceState If this dialog is being reinitialized after a
 *     the hosting activity was previously shut down, holds the result from
 *     the most recent call to {@link #onSaveInstanceState}, or null if this
 *     is the first time.
 * @apiSince 1
 */

protected void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Called when the dialog is starting.
 * @apiSince 1
 */

protected void onStart() { throw new RuntimeException("Stub!"); }

/**
 * Called to tell you that you're stopping.
 * @apiSince 1
 */

protected void onStop() { throw new RuntimeException("Stub!"); }

/**
 * Saves the state of the dialog into a bundle.
 *
 * The default implementation saves the state of its view hierarchy, so you'll
 * likely want to call through to super if you override this to save additional
 * state.
 * @return A bundle with the state of the dialog.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.os.Bundle onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * Restore the state of the dialog from a previously saved bundle.
 *
 * The default implementation restores the state of the dialog's view
 * hierarchy that was saved in the default implementation of {@link #onSaveInstanceState()},
 * so be sure to call through to super when overriding unless you want to
 * do all restoring of state yourself.
 * @param savedInstanceState The state of the dialog previously saved by
 *     {@link #onSaveInstanceState()}.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void onRestoreInstanceState(@androidx.annotation.NonNull android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current Window for the activity.  This can be used to
 * directly access parts of the Window API that are not available
 * through Activity/Screen.
 *
 * @return Window The current window, or null if the activity is not
 *         visual.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.view.Window getWindow() { throw new RuntimeException("Stub!"); }

/**
 * Call {@link android.view.Window#getCurrentFocus} on the
 * Window if this Activity to return the currently focused view.
 *
 * @return View The current View with focus or null.
 *
 * @see #getWindow
 * @see android.view.Window#getCurrentFocus
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.view.View getCurrentFocus() { throw new RuntimeException("Stub!"); }

/**
 * Finds the first descendant view with the given ID or {@code null} if the
 * ID is invalid (< 0), there is no matching view in the hierarchy, or the
 * dialog has not yet been fully created (for example, via {@link #show()}
 * or {@link #create()}).
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID if found, or {@code null} otherwise
 * @see android.view.View#findViewById(int)
 * @see android.app.Dialog#requireViewById(int)
 * @apiSince 1
 */

public <T extends android.view.View> T findViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Finds the first descendant view with the given ID or throws an IllegalArgumentException if
 * the ID is invalid (< 0), there is no matching view in the hierarchy, or the dialog has not
 * yet been fully created (for example, via {@link #show()} or {@link #create()}).
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID
 * This value will never be {@code null}.
 * @see android.view.View#requireViewById(int)
 * @see android.app.Dialog#findViewById(int)
 * @apiSince 28
 */

@androidx.annotation.NonNull
public final <T extends android.view.View> T requireViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Set the screen content from a layout resource.  The resource will be
 * inflated, adding all top-level views to the screen.
 *
 * @param layoutResID Resource ID to be inflated.
 * @apiSince 1
 */

public void setContentView(int layoutResID) { throw new RuntimeException("Stub!"); }

/**
 * Set the screen content to an explicit view.  This view is placed
 * directly into the screen's view hierarchy.  It can itself be a complex
 * view hierarchy.
 *
 * @param view The desired content to display.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void setContentView(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Set the screen content to an explicit view.  This view is placed
 * directly into the screen's view hierarchy.  It can itself be a complex
 * view hierarchy.
 *
 * @param view The desired content to display.
 * This value must never be {@code null}.
 * @param params Layout parameters for the view.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setContentView(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Add an additional content view to the screen.  Added after any existing
 * ones in the screen -- existing views are NOT removed.
 *
 * @param view The desired content to display.
 * This value must never be {@code null}.
 * @param params Layout parameters for the view.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void addContentView(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Set the title text for this dialog's window.
 *
 * @param title The new text to display in the title.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setTitle(@androidx.annotation.Nullable java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the title text for this dialog's window. The text is retrieved
 * from the resources with the supplied identifier.
 *
 * @param titleId the title's text resource identifier
 * @apiSince 1
 */

public void setTitle(int titleId) { throw new RuntimeException("Stub!"); }

/**
 * A key was pressed down.
 * <p>
 * If the focused view didn't want this event, this method is called.
 * <p>
 * Default implementation consumes {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK}
 * and, as of {@link android.os.Build.VERSION_CODES#P P}, {@link android.view.KeyEvent#KEYCODE_ESCAPE KeyEvent#KEYCODE_ESCAPE} to later handle them in {@link #onKeyUp}.
 *
 * @see #onKeyUp
 * @see android.view.KeyEvent
 
 * @param event This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onKeyDown(int keyCode, @androidx.annotation.NonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link android.view.KeyEvent.Callback#onKeyLongPress(int,android.view.KeyEvent) KeyEvent.Callback#onKeyLongPress(int, KeyEvent)}: always returns false (doesn't handle
 * the event).
 
 * @param event This value must never be {@code null}.
 * @apiSince 5
 */

public boolean onKeyLongPress(int keyCode, @androidx.annotation.NonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * A key was released.
 * <p>
 * Default implementation consumes {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK}
 * and, as of {@link android.os.Build.VERSION_CODES#P P}, {@link android.view.KeyEvent#KEYCODE_ESCAPE KeyEvent#KEYCODE_ESCAPE} to close the dialog.
 *
 * @see #onKeyDown
 * @see android.view.KeyEvent
 
 * @param event This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onKeyUp(int keyCode, @androidx.annotation.NonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link android.view.KeyEvent.Callback#onKeyMultiple(int,int,android.view.KeyEvent) KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)}: always returns false (doesn't handle
 * the event).
 
 * @param event This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onKeyMultiple(int keyCode, int repeatCount, @androidx.annotation.NonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when the dialog has detected the user's press of the back
 * key.  The default implementation simply cancels the dialog (only if
 * it is cancelable), but you can override this to do whatever you want.
 * @apiSince 5
 */

public void onBackPressed() { throw new RuntimeException("Stub!"); }

/**
 * Called when a key shortcut event is not handled by any of the views in the Dialog.
 * Override this method to implement global key shortcuts for the Dialog.
 * Key shortcuts can also be implemented by setting the
 * {@link android.view.MenuItem#setShortcut(char,char) MenuItem#setShortcut(char, char)} property of menu items.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 * This value must never be {@code null}.
 * @return True if the key shortcut was handled.
 * @apiSince 11
 */

public boolean onKeyShortcut(int keyCode, @androidx.annotation.NonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when a touch screen event was not handled by any of the views
 * under it. This is most useful to process touch events that happen outside
 * of your window bounds, where there is no view to receive it.
 *
 * @param event The touch screen event being processed.
 * This value must never be {@code null}.
 * @return Return true if you have consumed the event, false if you haven't.
 *         The default implementation will cancel the dialog when a touch
 *         happens outside of the window bounds.
 * @apiSince 1
 */

public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when the trackball was moved and not handled by any of the
 * views inside of the activity.  So, for example, if the trackball moves
 * while focus is on a button, you will receive a call here because
 * buttons do not normally do anything with trackball events.  The call
 * here happens <em>before</em> trackball movements are converted to
 * DPAD key events, which then get sent back to the view hierarchy, and
 * will be processed at the point for things like focus navigation.
 *
 * @param event The trackball event being processed.
 *
 * This value must never be {@code null}.
 * @return Return true if you have consumed the event, false if you haven't.
 * The default implementation always returns false.
 * @apiSince 1
 */

public boolean onTrackballEvent(@androidx.annotation.NonNull android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when a generic motion event was not handled by any of the
 * views inside of the dialog.
 * <p>
 * Generic motion events describe joystick movements, mouse hovers, track pad
 * touches, scroll wheel movements and other input events.  The
 * {@link android.view.MotionEvent#getSource() MotionEvent#getSource()} of the motion event specifies
 * the class of input that was received.  Implementations of this method
 * must examine the bits in the source before processing the event.
 * The following code example shows how this is done.
 * </p><p>
 * Generic motion events with source class
 * {@link android.view.InputDevice#SOURCE_CLASS_POINTER}
 * are delivered to the view under the pointer.  All other generic motion events are
 * delivered to the focused view.
 * </p><p>
 * See {@link android.view.View#onGenericMotionEvent(android.view.MotionEvent) View#onGenericMotionEvent(MotionEvent)} for an example of how to
 * handle this event.
 * </p>
 *
 * @param event The generic motion event being processed.
 *
 * This value must never be {@code null}.
 * @return Return true if you have consumed the event, false if you haven't.
 * The default implementation always returns false.
 * @apiSince 12
 */

public boolean onGenericMotionEvent(@androidx.annotation.NonNull android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onContentChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * Called to process key events.  You can override this to intercept all
 * key events before they are dispatched to the window.  Be sure to call
 * this implementation for key events that should be handled normally.
 *
 * @param event The key event.
 *
 * This value must never be {@code null}.
 * @return boolean Return true if this event was consumed.
 * @apiSince 1
 */

public boolean dispatchKeyEvent(@androidx.annotation.NonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called to process a key shortcut event.
 * You can override this to intercept all key shortcut events before they are
 * dispatched to the window.  Be sure to call this implementation for key shortcut
 * events that should be handled normally.
 *
 * @param event The key shortcut event.
 * This value must never be {@code null}.
 * @return True if this event was consumed.
 * @apiSince 11
 */

public boolean dispatchKeyShortcutEvent(@androidx.annotation.NonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called to process touch screen events.  You can override this to
 * intercept all touch screen events before they are dispatched to the
 * window.  Be sure to call this implementation for touch screen events
 * that should be handled normally.
 *
 * @param ev The touch screen event.
 *
 * This value must never be {@code null}.
 * @return boolean Return true if this event was consumed.
 * @apiSince 1
 */

public boolean dispatchTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * Called to process trackball events.  You can override this to
 * intercept all trackball events before they are dispatched to the
 * window.  Be sure to call this implementation for trackball events
 * that should be handled normally.
 *
 * @param ev The trackball event.
 *
 * This value must never be {@code null}.
 * @return boolean Return true if this event was consumed.
 * @apiSince 1
 */

public boolean dispatchTrackballEvent(@androidx.annotation.NonNull android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * Called to process generic motion events.  You can override this to
 * intercept all generic motion events before they are dispatched to the
 * window.  Be sure to call this implementation for generic motion events
 * that should be handled normally.
 *
 * @param ev The generic motion event.
 *
 * This value must never be {@code null}.
 * @return boolean Return true if this event was consumed.
 * @apiSince 12
 */

public boolean dispatchGenericMotionEvent(@androidx.annotation.NonNull android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param event This value must never be {@code null}.
 * @apiSince 4
 */

public boolean dispatchPopulateAccessibilityEvent(@androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onCreatePanelView(int)
 * @apiSince 1
 */

public android.view.View onCreatePanelView(int featureId) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onCreatePanelMenu(int, Menu)
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onCreatePanelMenu(int featureId, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onPreparePanel(int, View, Menu)
 
 * @param view This value may be {@code null}.
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onPreparePanel(int featureId, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onMenuOpened(int, Menu)
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onMenuOpened(int featureId, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onMenuItemSelected(int, MenuItem)
 
 * @param item This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onMenuItemSelected(int featureId, @androidx.annotation.NonNull android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onPanelClosed(int, Menu)
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public void onPanelClosed(int featureId, @androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * It is usually safe to proxy this call to the owner activity's
 * {@link android.app.Activity#onCreateOptionsMenu(android.view.Menu) Activity#onCreateOptionsMenu(Menu)} if the client desires the same
 * menu for this Dialog.
 *
 * @see android.app.Activity#onCreateOptionsMenu(Menu)
 * @see #getOwnerActivity()
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onCreateOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * It is usually safe to proxy this call to the owner activity's
 * {@link android.app.Activity#onPrepareOptionsMenu(android.view.Menu) Activity#onPrepareOptionsMenu(Menu)} if the client desires the
 * same menu for this Dialog.
 *
 * @see android.app.Activity#onPrepareOptionsMenu(Menu)
 * @see #getOwnerActivity()
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onPrepareOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onOptionsItemSelected(MenuItem)
 
 * @param item This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onOptionsItemSelected(@androidx.annotation.NonNull android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onOptionsMenuClosed(Menu)
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public void onOptionsMenuClosed(@androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#openOptionsMenu()
 * @apiSince 1
 */

public void openOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#closeOptionsMenu()
 * @apiSince 1
 */

public void closeOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#invalidateOptionsMenu()
 * @apiSince 11
 */

public void invalidateOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onCreateContextMenu(ContextMenu, View, ContextMenuInfo)
 * @apiSince 1
 */

public void onCreateContextMenu(android.view.ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#registerForContextMenu(View)
 
 * @param view This value must never be {@code null}.
 * @apiSince 1
 */

public void registerForContextMenu(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#unregisterForContextMenu(View)
 
 * @param view This value must never be {@code null}.
 * @apiSince 1
 */

public void unregisterForContextMenu(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#openContextMenu(View)
 
 * @param view This value must never be {@code null}.
 * @apiSince 1
 */

public void openContextMenu(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onContextItemSelected(MenuItem)
 
 * @param item This value must never be {@code null}.
 * @apiSince 1
 */

public boolean onContextItemSelected(@androidx.annotation.NonNull android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#onContextMenuClosed(Menu)
 
 * @param menu This value must never be {@code null}.
 * @apiSince 1
 */

public void onContextMenuClosed(@androidx.annotation.NonNull android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called when the user signals the desire to start a search.
 
 * @param searchEvent This value must never be {@code null}.
 * @apiSince 23
 */

public boolean onSearchRequested(@androidx.annotation.NonNull android.view.SearchEvent searchEvent) { throw new RuntimeException("Stub!"); }

/**
 * This hook is called when the user signals the desire to start a search.
 * @apiSince 1
 */

public boolean onSearchRequested() { throw new RuntimeException("Stub!"); }

/**
 * During the onSearchRequested() callbacks, this function will return the
 * {@link android.view.SearchEvent SearchEvent} that triggered the callback, if it exists.
 *
 * @return SearchEvent The SearchEvent that triggered the {@link
 *                    #onSearchRequested} callback.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public final android.view.SearchEvent getSearchEvent() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * Note that if you override this method you should always call through
 * to the superclass implementation by calling super.onActionModeStarted(mode).
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 */

public void onActionModeStarted(android.view.ActionMode mode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * Note that if you override this method you should always call through
 * to the superclass implementation by calling super.onActionModeFinished(mode).
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 11
 */

public void onActionModeFinished(android.view.ActionMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Request that key events come to this dialog. Use this if your
 * dialog has no views with focus, but the dialog still wants
 * a chance to process key events.
 *
 * @param get true if the dialog should receive key events, false otherwise
 * @see android.view.Window#takeKeyEvents
 * @apiSince 1
 */

public void takeKeyEvents(boolean get) { throw new RuntimeException("Stub!"); }

/**
 * Enable extended window features.  This is a convenience for calling
 * {@link android.view.Window#requestFeature getWindow().requestFeature()}.
 *
 * @param featureId The desired feature as defined in
 *                  {@link android.view.Window}.
 * @return Returns true if the requested feature is supported and now
 *         enabled.
 *
 * @see android.view.Window#requestFeature
 * @apiSince 1
 */

public final boolean requestWindowFeature(int featureId) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawableResource}.
 * @apiSince 1
 */

public final void setFeatureDrawableResource(int featureId, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawableUri}.
 
 * @param uri This value may be {@code null}.
 * @apiSince 1
 */

public final void setFeatureDrawableUri(int featureId, @androidx.annotation.Nullable android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawable(int, Drawable)}.
 
 * @param drawable This value may be {@code null}.
 * @apiSince 1
 */

public final void setFeatureDrawable(int featureId, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling
 * {@link android.view.Window#setFeatureDrawableAlpha}.
 * @apiSince 1
 */

public final void setFeatureDrawableAlpha(int featureId, int alpha) { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.view.LayoutInflater getLayoutInflater() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this dialog is cancelable with the
 * {@link android.view.KeyEvent#KEYCODE_BACK KeyEvent#KEYCODE_BACK} key.
 * @apiSince 1
 */

public void setCancelable(boolean flag) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this dialog is canceled when touched outside the window's
 * bounds. If setting to true, the dialog is set to be cancelable if not
 * already set.
 *
 * @param cancel Whether the dialog should be canceled when touched outside
 *            the window.
 * @apiSince 1
 */

public void setCanceledOnTouchOutside(boolean cancel) { throw new RuntimeException("Stub!"); }

/**
 * Cancel the dialog.  This is essentially the same as calling {@link #dismiss()}, but it will
 * also call your {@link android.content.DialogInterface.OnCancelListener DialogInterface.OnCancelListener} (if registered).
 * @apiSince 1
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the dialog is canceled.
 *
 * <p>This will only be invoked when the dialog is canceled.
 * Cancel events alone will not capture all ways that
 * the dialog might be dismissed. If the creator needs
 * to know when a dialog is dismissed in general, use
 * {@link #setOnDismissListener}.</p>
 *
 * @param listener The {@link android.content.DialogInterface.OnCancelListener DialogInterface.OnCancelListener} to use.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setOnCancelListener(@androidx.annotation.Nullable android.content.DialogInterface.OnCancelListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a message to be sent when the dialog is canceled.
 * @param msg The msg to send when the dialog is canceled.
 * This value may be {@code null}.
 * @see #setOnCancelListener(android.content.DialogInterface.OnCancelListener)
 * @apiSince 1
 */

public void setCancelMessage(@androidx.annotation.Nullable android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be invoked when the dialog is dismissed.
 * @param listener The {@link android.content.DialogInterface.OnDismissListener DialogInterface.OnDismissListener} to use.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setOnDismissListener(@androidx.annotation.Nullable android.content.DialogInterface.OnDismissListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to be invoked when the dialog is shown.
 * @param listener The {@link android.content.DialogInterface.OnShowListener DialogInterface.OnShowListener} to use.
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public void setOnShowListener(@androidx.annotation.Nullable android.content.DialogInterface.OnShowListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a message to be sent when the dialog is dismissed.
 * @param msg The msg to send when the dialog is dismissed.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setDismissMessage(@androidx.annotation.Nullable android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * By default, this will use the owner Activity's suggested stream type.
 *
 * @see android.app.Activity#setVolumeControlStream(int)
 * @see #setOwnerActivity(Activity)
 * @apiSince 1
 */

public final void setVolumeControlStream(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * @see android.app.Activity#getVolumeControlStream()
 * @apiSince 1
 */

public final int getVolumeControlStream() { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback that will be called if a key is dispatched to the dialog.
 
 * @param onKeyListener This value may be {@code null}.
 * @apiSince 1
 */

public void setOnKeyListener(@androidx.annotation.Nullable android.content.DialogInterface.OnKeyListener onKeyListener) { throw new RuntimeException("Stub!"); }
}

