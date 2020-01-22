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


package android.view;

import android.app.Activity;
import android.content.Intent;

/**
 * Interface for managing the items in a menu.
 * <p>
 * By default, every Activity supports an options menu of actions or options.
 * You can add items to this menu and handle clicks on your additions. The
 * easiest way of adding menu items is inflating an XML file into the
 * {@link android.view.Menu Menu} via {@link android.view.MenuInflater MenuInflater}. The easiest way of attaching code to
 * clicks is via {@link android.app.Activity#onOptionsItemSelected(android.view.MenuItem) Activity#onOptionsItemSelected(MenuItem)} and
 * {@link android.app.Activity#onContextItemSelected(android.view.MenuItem) Activity#onContextItemSelected(MenuItem)}.
 * <p>
 * Different menu types support different features:
 * <ol>
 * <li><b>Context menus</b>: Do not support item shortcuts and item icons.
 * <li><b>Options menus</b>: The <b>icon menus</b> do not support item check
 * marks and only show the item's
 * {@link android.view.MenuItem#setTitleCondensed(java.lang.CharSequence) MenuItem#setTitleCondensed(CharSequence)}. The
 * <b>expanded menus</b> (only available if six or more menu items are visible,
 * reached via the 'More' item in the icon menu) do not show item icons, and
 * item check marks are discouraged.
 * <li><b>Sub menus</b>: Do not support item icons, or nested sub menus.
 * </ol>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating menus, read the
 * <a href="{@docRoot}guide/topics/ui/menus.html">Menus</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Menu {

/**
 * Add a new item to the menu. This item displays the given title for its
 * label.
 *
 * @param title The text to display for the item.
 * @return The newly added menu item.
 * @apiSince 1
 */

public android.view.MenuItem add(java.lang.CharSequence title);

/**
 * Add a new item to the menu. This item displays the given title for its
 * label.
 *
 * @param titleRes Resource identifier of title string.
 * @return The newly added menu item.
 * @apiSince 1
 */

public android.view.MenuItem add(int titleRes);

/**
 * Add a new item to the menu. This item displays the given title for its
 * label.
 *
 * @param groupId The group identifier that this item should be part of.
 *        This can be used to define groups of items for batch state
 *        changes. Normally use {@link #NONE} if an item should not be in a
 *        group.
 * @param itemId Unique item ID. Use {@link #NONE} if you do not need a
 *        unique ID.
 * @param order The order for the item. Use {@link #NONE} if you do not care
 *        about the order. See {@link android.view.MenuItem#getOrder() MenuItem#getOrder()}.
 * @param title The text to display for the item.
 * @return The newly added menu item.
 * @apiSince 1
 */

public android.view.MenuItem add(int groupId, int itemId, int order, java.lang.CharSequence title);

/**
 * Variation on {@link #add(int,int,int,java.lang.CharSequence)} that takes a
 * string resource identifier instead of the string itself.
 *
 * @param groupId The group identifier that this item should be part of.
 *        This can also be used to define groups of items for batch state
 *        changes. Normally use {@link #NONE} if an item should not be in a
 *        group.
 * @param itemId Unique item ID. Use {@link #NONE} if you do not need a
 *        unique ID.
 * @param order The order for the item. Use {@link #NONE} if you do not care
 *        about the order. See {@link android.view.MenuItem#getOrder() MenuItem#getOrder()}.
 * @param titleRes Resource identifier of title string.
 * @return The newly added menu item.
 * @apiSince 1
 */

public android.view.MenuItem add(int groupId, int itemId, int order, int titleRes);

/**
 * Add a new sub-menu to the menu. This item displays the given title for
 * its label. To modify other attributes on the submenu's menu item, use
 * {@link android.view.SubMenu#getItem() SubMenu#getItem()}.
 *
 * @param title The text to display for the item.
 * @return The newly added sub-menu
 * @apiSince 1
 */

public android.view.SubMenu addSubMenu(java.lang.CharSequence title);

/**
 * Add a new sub-menu to the menu. This item displays the given title for
 * its label. To modify other attributes on the submenu's menu item, use
 * {@link android.view.SubMenu#getItem() SubMenu#getItem()}.
 *
 * @param titleRes Resource identifier of title string.
 * @return The newly added sub-menu
 * @apiSince 1
 */

public android.view.SubMenu addSubMenu(int titleRes);

/**
 * Add a new sub-menu to the menu. This item displays the given
 * <var>title</var> for its label. To modify other attributes on the
 * submenu's menu item, use {@link android.view.SubMenu#getItem() SubMenu#getItem()}.
 *<p>
 * Note that you can only have one level of sub-menus, i.e. you cannnot add
 * a subMenu to a subMenu: An {@link java.lang.UnsupportedOperationException UnsupportedOperationException} will be
 * thrown if you try.
 *
 * @param groupId The group identifier that this item should be part of.
 *        This can also be used to define groups of items for batch state
 *        changes. Normally use {@link #NONE} if an item should not be in a
 *        group.
 * @param itemId Unique item ID. Use {@link #NONE} if you do not need a
 *        unique ID.
 * @param order The order for the item. Use {@link #NONE} if you do not care
 *        about the order. See {@link android.view.MenuItem#getOrder() MenuItem#getOrder()}.
 * @param title The text to display for the item.
 * @return The newly added sub-menu
 * @apiSince 1
 */

public android.view.SubMenu addSubMenu(int groupId, int itemId, int order, java.lang.CharSequence title);

/**
 * Variation on {@link #addSubMenu(int,int,int,java.lang.CharSequence)} that takes
 * a string resource identifier for the title instead of the string itself.
 *
 * @param groupId The group identifier that this item should be part of.
 *        This can also be used to define groups of items for batch state
 *        changes. Normally use {@link #NONE} if an item should not be in a group.
 * @param itemId Unique item ID. Use {@link #NONE} if you do not need a unique ID.
 * @param order The order for the item. Use {@link #NONE} if you do not care about the
 *        order. See {@link android.view.MenuItem#getOrder() MenuItem#getOrder()}.
 * @param titleRes Resource identifier of title string.
 * @return The newly added sub-menu
 * @apiSince 1
 */

public android.view.SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes);

/**
 * Add a group of menu items corresponding to actions that can be performed
 * for a particular Intent. The Intent is most often configured with a null
 * action, the data that the current activity is working with, and includes
 * either the {@link android.content.Intent#CATEGORY_ALTERNATIVE Intent#CATEGORY_ALTERNATIVE} or
 * {@link android.content.Intent#CATEGORY_SELECTED_ALTERNATIVE Intent#CATEGORY_SELECTED_ALTERNATIVE} to find activities that have
 * said they would like to be included as optional action. You can, however,
 * use any Intent you want.
 *
 * <p>
 * See {@link android.content.pm.PackageManager#queryIntentActivityOptions}
 * for more * details on the <var>caller</var>, <var>specifics</var>, and
 * <var>intent</var> arguments. The list returned by that function is used
 * to populate the resulting menu items.
 *
 * <p>
 * All of the menu items of possible options for the intent will be added
 * with the given group and id. You can use the group to control ordering of
 * the items in relation to other items in the menu. Normally this function
 * will automatically remove any existing items in the menu in the same
 * group and place a divider above and below the added items; this behavior
 * can be modified with the <var>flags</var> parameter. For each of the
 * generated items {@link android.view.MenuItem#setIntent MenuItem#setIntent} is called to associate the
 * appropriate Intent with the item; this means the activity will
 * automatically be started for you without having to do anything else.
 *
 * @param groupId The group identifier that the items should be part of.
 *        This can also be used to define groups of items for batch state
 *        changes. Normally use {@link #NONE} if the items should not be in
 *        a group.
 * @param itemId Unique item ID. Use {@link #NONE} if you do not need a
 *        unique ID.
 * @param order The order for the items. Use {@link #NONE} if you do not
 *        care about the order. See {@link android.view.MenuItem#getOrder() MenuItem#getOrder()}.
 * @param caller The current activity component name as defined by
 *        queryIntentActivityOptions().
 * @param specifics Specific items to place first as defined by
 *        queryIntentActivityOptions().
 * @param intent Intent describing the kinds of items to populate in the
 *        list as defined by queryIntentActivityOptions().
 * @param flags Additional options controlling how the items are added.
 * @param outSpecificItems Optional array in which to place the menu items
 *        that were generated for each of the <var>specifics</var> that were
 *        requested. Entries may be null if no activity was found for that
 *        specific action.
 * @return The number of menu items that were added.
 *
 * @see #FLAG_APPEND_TO_GROUP
 * @see android.view.MenuItem#setIntent
 * @see android.content.pm.PackageManager#queryIntentActivityOptions
 * @apiSince 1
 */

public int addIntentOptions(int groupId, int itemId, int order, android.content.ComponentName caller, android.content.Intent[] specifics, android.content.Intent intent, int flags, android.view.MenuItem[] outSpecificItems);

/**
 * Remove the item with the given identifier.
 *
 * @param id The item to be removed.  If there is no item with this
 *           identifier, nothing happens.
 * @apiSince 1
 */

public void removeItem(int id);

/**
 * Remove all items in the given group.
 *
 * @param groupId The group to be removed.  If there are no items in this
 *           group, nothing happens.
 * @apiSince 1
 */

public void removeGroup(int groupId);

/**
 * Remove all existing items from the menu, leaving it empty as if it had
 * just been created.
 * @apiSince 1
 */

public void clear();

/**
 * Control whether a particular group of items can show a check mark.  This
 * is similar to calling {@link android.view.MenuItem#setCheckable MenuItem#setCheckable} on all of the menu items
 * with the given group identifier, but in addition you can control whether
 * this group contains a mutually-exclusive set items.  This should be called
 * after the items of the group have been added to the menu.
 *
 * @param group The group of items to operate on.
 * @param checkable Set to true to allow a check mark, false to
 *                  disallow.  The default is false.
 * @param exclusive If set to true, only one item in this group can be
 *                  checked at a time; checking an item will automatically
 *                  uncheck all others in the group.  If set to false, each
 *                  item can be checked independently of the others.
 *
 * @see android.view.MenuItem#setCheckable
 * @see android.view.MenuItem#setChecked
 * @apiSince 1
 */

public void setGroupCheckable(int group, boolean checkable, boolean exclusive);

/**
 * Show or hide all menu items that are in the given group.
 *
 * @param group The group of items to operate on.
 * @param visible If true the items are visible, else they are hidden.
 *
 * @see android.view.MenuItem#setVisible
 * @apiSince 1
 */

public void setGroupVisible(int group, boolean visible);

/**
 * Enable or disable all menu items that are in the given group.
 *
 * @param group The group of items to operate on.
 * @param enabled If true the items will be enabled, else they will be disabled.
 *
 * @see android.view.MenuItem#setEnabled
 * @apiSince 1
 */

public void setGroupEnabled(int group, boolean enabled);

/**
 * Return whether the menu currently has item items that are visible.
 *
 * @return True if there is one or more item visible,
 *         else false.
 * @apiSince 1
 */

public boolean hasVisibleItems();

/**
 * Return the menu item with a particular identifier.
 *
 * @param id The identifier to find.
 *
 * @return The menu item object, or null if there is no item with
 *         this identifier.
 * @apiSince 1
 */

public android.view.MenuItem findItem(int id);

/**
 * Get the number of items in the menu.  Note that this will change any
 * times items are added or removed from the menu.
 *
 * @return The item count.
 * @apiSince 1
 */

public int size();

/**
 * Gets the menu item at the given index.
 *
 * @param index The index of the menu item to return.
 * @return The menu item.
 * @exception java.lang.IndexOutOfBoundsException
 *                when {@code index < 0 || >= size()}
 * @apiSince 3
 */

public android.view.MenuItem getItem(int index);

/**
 * Closes the menu, if open.
 * @apiSince 3
 */

public void close();

/**
 * Execute the menu item action associated with the given shortcut
 * character.
 *
 * @param keyCode The keycode of the shortcut key.
 * @param event Key event message.
 * @param flags Additional option flags or 0.
 *
 * @return If the given shortcut exists and is shown, returns
 *         true; else returns false.
 *
 * @see #FLAG_PERFORM_NO_CLOSE
 * @apiSince 1
 */

public boolean performShortcut(int keyCode, android.view.KeyEvent event, int flags);

/**
 * Is a keypress one of the defined shortcut keys for this window.
 * @param keyCode the key code from {@link android.view.KeyEvent KeyEvent} to check.
 * @param event the {@link android.view.KeyEvent KeyEvent} to use to help check.
 * @apiSince 1
 */

public boolean isShortcutKey(int keyCode, android.view.KeyEvent event);

/**
 * Execute the menu item action associated with the given menu identifier.
 *
 * @param id Identifier associated with the menu item.
 * @param flags Additional option flags or 0.
 *
 * @return If the given identifier exists and is shown, returns
 *         true; else returns false.
 *
 * @see #FLAG_PERFORM_NO_CLOSE
 * @apiSince 1
 */

public boolean performIdentifierAction(int id, int flags);

/**
 * Control whether the menu should be running in qwerty mode (alphabetic
 * shortcuts) or 12-key mode (numeric shortcuts).
 *
 * @param isQwerty If true the menu will use alphabetic shortcuts; else it
 *                 will use numeric shortcuts.
 * @apiSince 1
 */

public void setQwertyMode(boolean isQwerty);

/**
 * Enable or disable the group dividers.
 * @apiSince 28
 */

public default void setGroupDividerEnabled(boolean groupDividerEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Category code for the order integer for items/groups that are
 * alternative actions on the data that is currently displayed -- or/add
 * this with your base value.
 * @apiSince 1
 */

public static final int CATEGORY_ALTERNATIVE = 262144; // 0x40000

/**
 * Category code for the order integer for items/groups that are part of a
 * container -- or/add this with your base value.
 * @apiSince 1
 */

public static final int CATEGORY_CONTAINER = 65536; // 0x10000

/**
 * Category code for the order integer for items/groups that are
 * user-supplied secondary (infrequently used) options -- or/add this with
 * your base value.
 * @apiSince 1
 */

public static final int CATEGORY_SECONDARY = 196608; // 0x30000

/**
 * Category code for the order integer for items/groups that are provided by
 * the system -- or/add this with your base value.
 * @apiSince 1
 */

public static final int CATEGORY_SYSTEM = 131072; // 0x20000

/**
 * First value for group and item identifier integers.
 * @apiSince 1
 */

public static final int FIRST = 1; // 0x1

/**
 * Flag for {@link #performShortcut(int,android.view.KeyEvent,int)}: if set, always
 * close the menu after executing the shortcut. Closing the menu also resets
 * the prepared state.
 * @apiSince 1
 */

public static final int FLAG_ALWAYS_PERFORM_CLOSE = 2; // 0x2

/**
 * Flag for {@link #addIntentOptions}: if set, do not automatically remove
 * any existing menu items in the same group.
 * @apiSince 1
 */

public static final int FLAG_APPEND_TO_GROUP = 1; // 0x1

/**
 * Flag for {@link #performShortcut}: if set, do not close the menu after
 * executing the shortcut.
 * @apiSince 1
 */

public static final int FLAG_PERFORM_NO_CLOSE = 1; // 0x1

/**
 * Value to use for group and item identifier integers when you don't care
 * about them.
 * @apiSince 1
 */

public static final int NONE = 0; // 0x0

/**
 * A mask of all supported modifiers for MenuItem's keyboard shortcuts
 * @apiSince 26
 */

public static final int SUPPORTED_MODIFIERS_MASK = 69647; // 0x1100f
}

