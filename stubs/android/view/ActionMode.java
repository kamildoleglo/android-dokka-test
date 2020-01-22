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


package android.view;

import android.graphics.Rect;

/**
 * Represents a contextual mode of the user interface. Action modes can be used to provide
 * alternative interaction modes and replace parts of the normal UI until finished.
 * Examples of good action modes include text selection and contextual actions.
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about how to provide contextual actions with {@code ActionMode},
 * read the <a href="{@docRoot}guide/topics/ui/menus.html#context-menu">Menus</a>
 * developer guide.</p>
 * </div>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ActionMode {

public ActionMode() { throw new RuntimeException("Stub!"); }

/**
 * Set a tag object associated with this ActionMode.
 *
 * <p>Like the tag available to views, this allows applications to associate arbitrary
 * data with an ActionMode for later reference.
 *
 * @param tag Tag to associate with this ActionMode
 *
 * @see #getTag()
 * @apiSince 14
 */

public void setTag(java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the tag object associated with this ActionMode.
 *
 * <p>Like the tag available to views, this allows applications to associate arbitrary
 * data with an ActionMode for later reference.
 *
 * @return Tag associated with this ActionMode
 *
 * @see #setTag(Object)
 * @apiSince 14
 */

public java.lang.Object getTag() { throw new RuntimeException("Stub!"); }

/**
 * Set the title of the action mode. This method will have no visible effect if
 * a custom view has been set.
 *
 * @param title Title string to set
 *
 * @see #setTitle(int)
 * @see #setCustomView(View)
 * @apiSince 11
 */

public abstract void setTitle(java.lang.CharSequence title);

/**
 * Set the title of the action mode. This method will have no visible effect if
 * a custom view has been set.
 *
 * @param resId Resource ID of a string to set as the title
 *
 * @see #setTitle(CharSequence)
 * @see #setCustomView(View)
 * @apiSince 11
 */

public abstract void setTitle(int resId);

/**
 * Set the subtitle of the action mode. This method will have no visible effect if
 * a custom view has been set.
 *
 * @param subtitle Subtitle string to set
 *
 * @see #setSubtitle(int)
 * @see #setCustomView(View)
 * @apiSince 11
 */

public abstract void setSubtitle(java.lang.CharSequence subtitle);

/**
 * Set the subtitle of the action mode. This method will have no visible effect if
 * a custom view has been set.
 *
 * @param resId Resource ID of a string to set as the subtitle
 *
 * @see #setSubtitle(CharSequence)
 * @see #setCustomView(View)
 * @apiSince 11
 */

public abstract void setSubtitle(int resId);

/**
 * Set whether or not the title/subtitle display for this action mode
 * is optional.
 *
 * <p>In many cases the supplied title for an action mode is merely
 * meant to add context and is not strictly required for the action
 * mode to be useful. If the title is optional, the system may choose
 * to hide the title entirely rather than truncate it due to a lack
 * of available space.</p>
 *
 * <p>Note that this is merely a hint; the underlying implementation
 * may choose to ignore this setting under some circumstances.</p>
 *
 * @param titleOptional true if the title only presents optional information.
 * @apiSince 16
 */

public void setTitleOptionalHint(boolean titleOptional) { throw new RuntimeException("Stub!"); }

/**
 * @return true if this action mode has been given a hint to consider the
 *         title/subtitle display to be optional.
 *
 * @see #setTitleOptionalHint(boolean)
 * @see #isTitleOptional()
 * @apiSince 16
 */

public boolean getTitleOptionalHint() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this action mode considers the title and subtitle fields
 *         as optional. Optional titles may not be displayed to the user.
 * @apiSince 16
 */

public boolean isTitleOptional() { throw new RuntimeException("Stub!"); }

/**
 * Set a custom view for this action mode. The custom view will take the place of
 * the title and subtitle. Useful for things like search boxes.
 *
 * @param view Custom view to use in place of the title/subtitle.
 *
 * @see #setTitle(CharSequence)
 * @see #setSubtitle(CharSequence)
 * @apiSince 11
 */

public abstract void setCustomView(android.view.View view);

/**
 * Set a type for this action mode. This will affect how the system renders the action mode if
 * it has to.
 *
 * @param type One of {@link #TYPE_PRIMARY} or {@link #TYPE_FLOATING}.
 * @apiSince 23
 */

public void setType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type for this action mode.
 *
 * @return One of {@link #TYPE_PRIMARY} or {@link #TYPE_FLOATING}.
 * @apiSince 23
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Invalidate the action mode and refresh menu content. The mode's
 * {@link android.view.ActionMode.Callback ActionMode.Callback} will have its
 * {@link android.view.ActionMode.Callback#onPrepareActionMode(android.view.ActionMode,android.view.Menu) Callback#onPrepareActionMode(ActionMode, Menu)} method called.
 * If it returns true the menu will be scanned for updated content and any relevant changes
 * will be reflected to the user.
 * @apiSince 11
 */

public abstract void invalidate();

/**
 * Invalidate the content rect associated to this ActionMode. This only makes sense for
 * action modes that support dynamic positioning on the screen, and provides a more efficient
 * way to reposition it without invalidating the whole action mode.
 *
 * @see android.view.ActionMode.Callback2#onGetContentRect(ActionMode, View, Rect) .
 * @apiSince 23
 */

public void invalidateContentRect() { throw new RuntimeException("Stub!"); }

/**
 * Hide the action mode view from obstructing the content below for a short duration.
 * This only makes sense for action modes that support dynamic positioning on the screen.
 * If this method is called again before the hide duration expires, the later hide call will
 * cancel the former and then take effect.
 * NOTE that there is an internal limit to how long the mode can be hidden for. It's typically
 * about a few seconds.
 *
 * @param duration The number of milliseconds to hide for.
 * @see #DEFAULT_HIDE_DURATION
 * @apiSince 23
 */

public void hide(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Finish and close this action mode. The action mode's {@link android.view.ActionMode.Callback ActionMode.Callback} will
 * have its {@link android.view.ActionMode.Callback#onDestroyActionMode(android.view.ActionMode) Callback#onDestroyActionMode(ActionMode)} method called.
 * @apiSince 11
 */

public abstract void finish();

/**
 * Returns the menu of actions that this action mode presents.
 * @return The action mode's menu.
 * @apiSince 11
 */

public abstract android.view.Menu getMenu();

/**
 * Returns the current title of this action mode.
 * @return Title text
 * @apiSince 11
 */

public abstract java.lang.CharSequence getTitle();

/**
 * Returns the current subtitle of this action mode.
 * @return Subtitle text
 * @apiSince 11
 */

public abstract java.lang.CharSequence getSubtitle();

/**
 * Returns the current custom view for this action mode.
 * @return The current custom view
 * @apiSince 11
 */

public abstract android.view.View getCustomView();

/**
 * Returns a {@link android.view.MenuInflater MenuInflater} with the ActionMode's context.
 * @apiSince 11
 */

public abstract android.view.MenuInflater getMenuInflater();

/**
 * Called when the window containing the view that started this action mode gains or loses
 * focus.
 *
 * @param hasWindowFocus True if the window containing the view that started this action mode
 *        now has focus, false otherwise.
 *
 * @apiSince 23
 */

public void onWindowFocusChanged(boolean hasWindowFocus) { throw new RuntimeException("Stub!"); }

/**
 * Default value to hide the action mode for
 * {@link android.view.ViewConfiguration#getDefaultActionModeHideDuration() ViewConfiguration#getDefaultActionModeHideDuration()}.
 * @apiSince 23
 */

public static final int DEFAULT_HIDE_DURATION = -1; // 0xffffffff

/**
 * The action mode is treated as a Floating Toolbar.
 * Use with {@link #setType}.
 * @apiSince 23
 */

public static final int TYPE_FLOATING = 1; // 0x1

/**
 * The action mode is treated as a Primary mode. This is the default.
 * Use with {@link #setType}.
 * @apiSince 23
 */

public static final int TYPE_PRIMARY = 0; // 0x0
/**
 * Callback interface for action modes. Supplied to
 * {@link android.view.View#startActionMode(android.view.ActionMode.Callback) View#startActionMode(Callback)}, a Callback
 * configures and handles events raised by a user's interaction with an action mode.
 *
 * <p>An action mode's lifecycle is as follows:
 * <ul>
 * <li>{@link android.view.ActionMode.Callback#onCreateActionMode(android.view.ActionMode,android.view.Menu) Callback#onCreateActionMode(ActionMode, Menu)} once on initial
 * creation</li>
 * <li>{@link android.view.ActionMode.Callback#onPrepareActionMode(android.view.ActionMode,android.view.Menu) Callback#onPrepareActionMode(ActionMode, Menu)} after creation
 * and any time the {@link android.view.ActionMode ActionMode} is invalidated</li>
 * <li>{@link android.view.ActionMode.Callback#onActionItemClicked(android.view.ActionMode,android.view.MenuItem) Callback#onActionItemClicked(ActionMode, MenuItem)} any time a
 * contextual action button is clicked</li>
 * <li>{@link android.view.ActionMode.Callback#onDestroyActionMode(android.view.ActionMode) Callback#onDestroyActionMode(ActionMode)} when the action mode
 * is closed</li>
 * </ul>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * Called when action mode is first created. The menu supplied will be used to
 * generate action buttons for the action mode.
 *
 * @param mode ActionMode being created
 * @param menu Menu used to populate action buttons
 * @return true if the action mode should be created, false if entering this
 *              mode should be aborted.
 * @apiSince 11
 */

public boolean onCreateActionMode(android.view.ActionMode mode, android.view.Menu menu);

/**
 * Called to refresh an action mode's action menu whenever it is invalidated.
 *
 * @param mode ActionMode being prepared
 * @param menu Menu used to populate action buttons
 * @return true if the menu or action mode was updated, false otherwise.
 * @apiSince 11
 */

public boolean onPrepareActionMode(android.view.ActionMode mode, android.view.Menu menu);

/**
 * Called to report a user click on an action button.
 *
 * @param mode The current ActionMode
 * @param item The item that was clicked
 * @return true if this callback handled the event, false if the standard MenuItem
 *          invocation should continue.
 * @apiSince 11
 */

public boolean onActionItemClicked(android.view.ActionMode mode, android.view.MenuItem item);

/**
 * Called when an action mode is about to be exited and destroyed.
 *
 * @param mode The current ActionMode being destroyed
 * @apiSince 11
 */

public void onDestroyActionMode(android.view.ActionMode mode);
}

/**
 * Extension of {@link android.view.ActionMode.Callback ActionMode.Callback} to provide content rect information. This is
 * required for ActionModes with dynamic positioning such as the ones with type
 * {@link android.view.ActionMode#TYPE_FLOATING ActionMode#TYPE_FLOATING} to ensure the positioning doesn't obscure app content. If
 * an app fails to provide a subclass of this class, a default implementation will be used.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback2 implements android.view.ActionMode.Callback {

public Callback2() { throw new RuntimeException("Stub!"); }

/**
 * Called when an ActionMode needs to be positioned on screen, potentially occluding view
 * content. Note this may be called on a per-frame basis.
 *
 * @param mode The ActionMode that requires positioning.
 * @param view The View that originated the ActionMode, in whose coordinates the Rect should
 *          be provided.
 * @param outRect The Rect to be populated with the content position. Use this to specify
 *          where the content in your app lives within the given view. This will be used
 *          to avoid occluding the given content Rect with the created ActionMode.
 * @apiSince 23
 */

public void onGetContentRect(android.view.ActionMode mode, android.view.View view, android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }
}

}

