/*
 * Copyright (C) 2011 The Android Open Source Project
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

import android.content.Context;

/**
 * An ActionProvider defines rich menu interaction in a single component.
 * ActionProvider can generate action views for use in the action bar,
 * dynamically populate submenus of a MenuItem, and handle default menu
 * item invocations.
 *
 * <p>An ActionProvider can be optionally specified for a {@link android.view.MenuItem MenuItem} and will be
 * responsible for creating the action view that appears in the {@link android.app.ActionBar}
 * in place of a simple button in the bar. When the menu item is presented in a way that
 * does not allow custom action views, (e.g. in an overflow menu,) the ActionProvider
 * can perform a default action.</p>
 *
 * <p>There are two ways to use an action provider:
 * <ul>
 * <li>
 * Set the action provider on a {@link android.view.MenuItem MenuItem} directly by calling
 * {@link android.view.MenuItem#setActionProvider(android.view.ActionProvider) MenuItem#setActionProvider(ActionProvider)}.
 * </li>
 * <li>
 * Declare the action provider in an XML menu resource. For example:
 * <pre>
 * <code>
 *   &lt;item android:id="@+id/my_menu_item"
 *     android:title="Title"
 *     android:icon="@drawable/my_menu_item_icon"
 *     android:showAsAction="ifRoom"
 *     android:actionProviderClass="foo.bar.SomeActionProvider" /&gt;
 * </code>
 * </pre>
 * </li>
 * </ul>
 * </p>
 *
 * @see android.view.MenuItem#setActionProvider(ActionProvider)
 * @see android.view.MenuItem#getActionProvider()
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ActionProvider {

/**
 * Creates a new instance. ActionProvider classes should always implement a
 * constructor that takes a single Context parameter for inflating from menu XML.
 *
 * @param context Context for accessing resources.
 * @apiSince 14
 */

public ActionProvider(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Factory method called by the Android framework to create new action views.
 *
 * <p>This method has been deprecated in favor of {@link #onCreateActionView(android.view.MenuItem)}.
 * Newer apps that wish to support platform versions prior to API 16 should also
 * implement this method to return a valid action view.</p>
 *
 * @return A new action view.
 *
 * @deprecated use {@link #onCreateActionView(android.view.MenuItem)}
 * @apiSince 14
 * @deprecatedSince 16
 */

@Deprecated
public abstract android.view.View onCreateActionView();

/**
 * Factory method called by the Android framework to create new action views.
 * This method returns a new action view for the given MenuItem.
 *
 * <p>If your ActionProvider implementation overrides the deprecated no-argument overload
 * {@link #onCreateActionView()}, overriding this method for devices running API 16 or later
 * is recommended but optional. The default implementation calls {@link #onCreateActionView()}
 * for compatibility with applications written for older platform versions.</p>
 *
 * @param forItem MenuItem to create the action view for
 * @return the new action view
 * @apiSince 16
 */

public android.view.View onCreateActionView(android.view.MenuItem forItem) { throw new RuntimeException("Stub!"); }

/**
 * The result of this method determines whether or not {@link #isVisible()} will be used
 * by the {@link android.view.MenuItem MenuItem} this ActionProvider is bound to help determine its visibility.
 *
 * @return true if this ActionProvider overrides the visibility of the MenuItem
 *         it is bound to, false otherwise. The default implementation returns false.
 * @see #isVisible()
 * @apiSince 16
 */

public boolean overridesItemVisibility() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #overridesItemVisibility()} returns true, the return value of this method
 * will help determine the visibility of the {@link android.view.MenuItem MenuItem} this ActionProvider is bound to.
 *
 * <p>If the MenuItem's visibility is explicitly set to false by the application,
 * the MenuItem will not be shown, even if this method returns true.</p>
 *
 * @return true if the MenuItem this ActionProvider is bound to is visible, false if
 *         it is invisible. The default implementation returns true.
 * @apiSince 16
 */

public boolean isVisible() { throw new RuntimeException("Stub!"); }

/**
 * If this ActionProvider is associated with an item in a menu,
 * refresh the visibility of the item based on {@link #overridesItemVisibility()} and
 * {@link #isVisible()}. If {@link #overridesItemVisibility()} returns false, this call
 * will have no effect.
 * @apiSince 16
 */

public void refreshVisibility() { throw new RuntimeException("Stub!"); }

/**
 * Performs an optional default action.
 * <p>
 * For the case of an action provider placed in a menu item not shown as an action this
 * method is invoked if previous callbacks for processing menu selection has handled
 * the event.
 * </p>
 * <p>
 * A menu item selection is processed in the following order:
 * <ul>
 * <li>
 * Receiving a call to {@link android.view.MenuItem.OnMenuItemClickListener#onMenuItemClick MenuItem.OnMenuItemClickListener#onMenuItemClick}.
 * </li>
 * <li>
 * Receiving a call to {@link android.app.Activity#onOptionsItemSelected(MenuItem)
 *  Activity.onOptionsItemSelected(MenuItem)}
 * </li>
 * <li>
 * Receiving a call to {@link android.app.Fragment#onOptionsItemSelected(MenuItem)
 *  Fragment.onOptionsItemSelected(MenuItem)}
 * </li>
 * <li>
 * Launching the {@link android.content.Intent} set via
 * {@link android.view.MenuItem#setIntent(android.content.Intent) MenuItem#setIntent(android.content.Intent)}
 * </li>
 * <li>
 * Invoking this method.
 * </li>
 * </ul>
 * </p>
 * <p>
 * The default implementation does not perform any action and returns false.
 * </p>
 * @apiSince 14
 */

public boolean onPerformDefaultAction() { throw new RuntimeException("Stub!"); }

/**
 * Determines if this ActionProvider has a submenu associated with it.
 *
 * <p>Associated submenus will be shown when an action view is not. This
 * provider instance will receive a call to {@link #onPrepareSubMenu(android.view.SubMenu)}
 * after the call to {@link #onPerformDefaultAction()} and before a submenu is
 * displayed to the user.
 *
 * @return true if the item backed by this provider should have an associated submenu
 * @apiSince 14
 */

public boolean hasSubMenu() { throw new RuntimeException("Stub!"); }

/**
 * Called to prepare an associated submenu for the menu item backed by this ActionProvider.
 *
 * <p>if {@link #hasSubMenu()} returns true, this method will be called when the
 * menu item is selected to prepare the submenu for presentation to the user. Apps
 * may use this to create or alter submenu content right before display.
 *
 * @param subMenu Submenu that will be displayed
 * @apiSince 14
 */

public void onPrepareSubMenu(android.view.SubMenu subMenu) { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to be notified when this ActionProvider's overridden visibility changes.
 * This should only be used by MenuItem implementations.
 *
 * @param listener listener to set
 * @apiSince 16
 */

public void setVisibilityListener(android.view.ActionProvider.VisibilityListener listener) { throw new RuntimeException("Stub!"); }
/**
 * Listens to changes in visibility as reported by {@link android.view.ActionProvider#refreshVisibility() ActionProvider#refreshVisibility()}.
 *
 * @see android.view.ActionProvider#overridesItemVisibility()
 * @see android.view.ActionProvider#isVisible()
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface VisibilityListener {

/** @apiSince 16 */

public void onActionProviderVisibilityChanged(boolean isVisible);
}

}

