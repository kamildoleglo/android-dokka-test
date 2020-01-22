/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.content.Intent;
import android.app.Activity;
import android.view.View.OnCreateContextMenuListener;

/**
 * Interface for direct access to a previously created menu item.
 * <p>
 * An Item is returned by calling one of the {@link android.view.Menu#add}
 * methods.
 * <p>
 * For a feature set of specific menu types, see {@link android.view.Menu Menu}.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about creating menus, read the
 * <a href="{@docRoot}guide/topics/ui/menus.html">Menus</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface MenuItem {

/**
 * Return the identifier for this menu item.  The identifier can not
 * be changed after the menu is created.
 *
 * @return The menu item's identifier.
 * @apiSince 1
 */

public int getItemId();

/**
 * Return the group identifier that this menu item is part of. The group
 * identifier can not be changed after the menu is created.
 *
 * @return The menu item's group identifier.
 * @apiSince 1
 */

public int getGroupId();

/**
 * Return the category and order within the category of this item. This
 * item will be shown before all items (within its category) that have
 * order greater than this value.
 * <p>
 * An order integer contains the item's category (the upper bits of the
 * integer; set by or/add the category with the order within the
 * category) and the ordering of the item within that category (the
 * lower bits). Example categories are {@link android.view.Menu#CATEGORY_SYSTEM Menu#CATEGORY_SYSTEM},
 * {@link android.view.Menu#CATEGORY_SECONDARY Menu#CATEGORY_SECONDARY}, {@link android.view.Menu#CATEGORY_ALTERNATIVE Menu#CATEGORY_ALTERNATIVE},
 * {@link android.view.Menu#CATEGORY_CONTAINER Menu#CATEGORY_CONTAINER}. See {@link android.view.Menu Menu} for a full list.
 *
 * @return The order of this item.
 * @apiSince 1
 */

public int getOrder();

/**
 * Change the title associated with this item.
 *
 * @param title The new text to be displayed.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setTitle(java.lang.CharSequence title);

/**
 * Change the title associated with this item.
 * <p>
 * Some menu types do not sufficient space to show the full title, and
 * instead a condensed title is preferred. See {@link android.view.Menu Menu} for more
 * information.
 *
 * @param title The resource id of the new text to be displayed.
 * @return This Item so additional setters can be called.
 * @see #setTitleCondensed(CharSequence)
 * @apiSince 1
 */

public android.view.MenuItem setTitle(int title);

/**
 * Retrieve the current title of the item.
 *
 * @return The title.
 * @apiSince 1
 */

public java.lang.CharSequence getTitle();

/**
 * Change the condensed title associated with this item. The condensed
 * title is used in situations where the normal title may be too long to
 * be displayed.
 *
 * @param title The new text to be displayed as the condensed title.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setTitleCondensed(java.lang.CharSequence title);

/**
 * Retrieve the current condensed title of the item. If a condensed
 * title was never set, it will return the normal title.
 *
 * @return The condensed title, if it exists.
 *         Otherwise the normal title.
 * @apiSince 1
 */

public java.lang.CharSequence getTitleCondensed();

/**
 * Change the icon associated with this item. This icon will not always be
 * shown, so the title should be sufficient in describing this item. See
 * {@link android.view.Menu Menu} for the menu types that support icons.
 *
 * @param icon The new icon (as a Drawable) to be displayed.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setIcon(android.graphics.drawable.Drawable icon);

/**
 * Change the icon associated with this item. This icon will not always be
 * shown, so the title should be sufficient in describing this item. See
 * {@link android.view.Menu Menu} for the menu types that support icons.
 * <p>
 * This method will set the resource ID of the icon which will be used to
 * lazily get the Drawable when this item is being shown.
 *
 * @param iconRes The new icon (as a resource ID) to be displayed.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setIcon(int iconRes);

/**
 * Returns the icon for this item as a Drawable (getting it from resources if it hasn't been
 * loaded before). Note that if you call {@link #setIconTintList(android.content.res.ColorStateList)} or
 * {@link #setIconTintMode(android.graphics.PorterDuff.Mode)} on this item, and you use a custom menu presenter
 * in your application, you have to apply the tinting explicitly on the {@link android.graphics.drawable.Drawable Drawable}
 * returned by this method.
 *
 * @return The icon as a Drawable.
 * @apiSince 1
 */

public android.graphics.drawable.Drawable getIcon();

/**
 * Applies a tint to this item's icon. Does not modify the
 * current tint mode, which is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setIcon(android.graphics.drawable.Drawable)} or {@link #setIcon(int)} will
 * automatically mutate the icon and apply the specified tint and
 * tint mode using
 * {@link android.graphics.drawable.Drawable#setTintList(android.content.res.ColorStateList) Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#MenuItem_iconTint
 * @see #getIconTintList()
 * @see android.graphics.drawable.Drawable#setTintList(ColorStateList)
 * @apiSince 26
 */

public default android.view.MenuItem setIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @return the tint applied to this item's icon
 * This value may be {@code null}.
 * @attr ref android.R.styleable#MenuItem_iconTint
 * @see #setIconTintList(ColorStateList)
 * @apiSince 26
 */

@androidx.annotation.Nullable
public default android.content.res.ColorStateList getIconTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setIconTintList(android.content.res.ColorStateList)} to this item's icon. The default mode is
 * {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#MenuItem_iconTintMode
 * @see #setIconTintList(ColorStateList)
 * @see android.graphics.drawable.Drawable#setTintMode(PorterDuff.Mode)
 * @see android.graphics.drawable.Drawable#setTintBlendMode(BlendMode)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public default android.view.MenuItem setIconTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setIconTintList(android.content.res.ColorStateList)} to this item's icon. The default mode is
 * {@link android.graphics.BlendMode#SRC_IN BlendMode#SRC_IN}.
 *
 * @param blendMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#MenuItem_iconTintMode
 * @see #setIconTintList(ColorStateList)
 * @apiSince 29
 */

@androidx.annotation.NonNull
public default android.view.MenuItem setIconTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to this item's icon, if specified.
 *
 * @return the blending mode used to apply the tint to this item's icon
 * This value may be {@code null}.
 * @attr ref android.R.styleable#MenuItem_iconTintMode
 * @see #setIconTintMode(PorterDuff.Mode)
 * @see #setIconTintBlendMode(BlendMode)
 *
 * @apiSince 26
 */

@androidx.annotation.Nullable
public default android.graphics.PorterDuff.Mode getIconTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to this item's icon, if specified.
 *
 * @return the blending mode used to apply the tint to this item's icon
 * This value may be {@code null}.
 * @attr ref android.R.styleable#MenuItem_iconTintMode
 * @see #setIconTintBlendMode(BlendMode)
 *
 * @apiSince 29
 */

@androidx.annotation.Nullable
public default android.graphics.BlendMode getIconTintBlendMode() { throw new RuntimeException("Stub!"); }

/**
 * Change the Intent associated with this item.  By default there is no
 * Intent associated with a menu item.  If you set one, and nothing
 * else handles the item, then the default behavior will be to call
 * {@link android.content.Context#startActivity} with the given Intent.
 *
 * <p>Note that setIntent() can not be used with the versions of
 * {@link android.view.Menu#add Menu#add} that take a Runnable, because {@link java.lang.Runnable#run Runnable#run}
 * does not return a value so there is no way to tell if it handled the
 * item.  In this case it is assumed that the Runnable always handles
 * the item, and the intent will never be started.
 *
 * @see #getIntent
 * @param intent The Intent to associated with the item.  This Intent
 *               object is <em>not</em> copied, so be careful not to
 *               modify it later.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setIntent(android.content.Intent intent);

/**
 * Return the Intent associated with this item.  This returns a
 * reference to the Intent which you can change as desired to modify
 * what the Item is holding.
 *
 * @see #setIntent
 * @return Returns the last value supplied to {@link #setIntent}, or
 *         null.
 * @apiSince 1
 */

public android.content.Intent getIntent();

/**
 * Change both the numeric and alphabetic shortcut associated with this
 * item. Note that the shortcut will be triggered when the key that
 * generates the given character is pressed along with the corresponding
 * modifier key. The default modifier is  {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON} in
 * case nothing is specified. Also note that case is not significant and
 * that alphabetic shortcut characters will be handled in lower case.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support shortcuts.
 *
 * @param numericChar The numeric shortcut key. This is the shortcut when
 *        using a numeric (e.g., 12-key) keyboard.
 * @param alphaChar The alphabetic shortcut key. This is the shortcut when
 *        using a keyboard with alphabetic keys.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setShortcut(char numericChar, char alphaChar);

/**
 * Change both the numeric and alphabetic shortcut associated with this
 * item. Note that the shortcut will be triggered when the key that
 * generates the given character is pressed along with the corresponding
 * modifier key. Also note that case is not significant and that alphabetic
 * shortcut characters will be handled in lower case.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support shortcuts.
 *
 * @param numericChar The numeric shortcut key. This is the shortcut when
 *        using a numeric (e.g., 12-key) keyboard.
 * @param numericModifiers The numeric modifier associated with the shortcut. It should
 *        be a combination of {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON}, {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON},
 *        {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON}, {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON},
 *        {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON}, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}.
 * @param alphaChar The alphabetic shortcut key. This is the shortcut when
 *        using a keyboard with alphabetic keys.
 * @param alphaModifiers The alphabetic modifier associated with the shortcut. It should
 *        be a combination of {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON}, {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON},
 *        {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON}, {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON},
 *        {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON}, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}.
 * @return This Item so additional setters can be called.
 * @apiSince 26
 */

public default android.view.MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) { throw new RuntimeException("Stub!"); }

/**
 * Change the numeric shortcut associated with this item.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support shortcuts.
 *
 * @param numericChar The numeric shortcut key.  This is the shortcut when
 *                 using a 12-key (numeric) keyboard.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setNumericShortcut(char numericChar);

/**
 * Change the numeric shortcut and modifiers associated with this item.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support shortcuts.
 *
 * @param numericChar The numeric shortcut key.  This is the shortcut when
 *                 using a 12-key (numeric) keyboard.
 * @param numericModifiers The modifier associated with the shortcut. It should
 *        be a combination of {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON}, {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON},
 *        {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON}, {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON},
 *        {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON}, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}.
 * @return This Item so additional setters can be called.
 * @apiSince 26
 */

public default android.view.MenuItem setNumericShortcut(char numericChar, int numericModifiers) { throw new RuntimeException("Stub!"); }

/**
 * Return the char for this menu item's numeric (12-key) shortcut.
 *
 * @return Numeric character to use as a shortcut.
 * @apiSince 1
 */

public char getNumericShortcut();

/**
 * Return the modifiers for this menu item's numeric (12-key) shortcut.
 * The modifier is a combination of {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON},
 * {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON}, {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON},
 * {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON}, {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON},
 * {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}.
 * For example, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}|{@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON}
 *
 * @return Modifier associated with the numeric shortcut.
 * @apiSince 26
 */

public default int getNumericModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Change the alphabetic shortcut associated with this item. The shortcut
 * will be triggered when the key that generates the given character is
 * pressed along with the corresponding modifier key. The default modifier
 * is {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON} in case nothing is specified. Case is
 * not significant and shortcut characters will be displayed in lower case.
 * Note that menu items with the characters '\b' or '\n' as shortcuts will
 * get triggered by the Delete key or Carriage Return key, respectively.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support shortcuts.
 *
 * @param alphaChar The alphabetic shortcut key. This is the shortcut when
 *        using a keyboard with alphabetic keys.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setAlphabeticShortcut(char alphaChar);

/**
 * Change the alphabetic shortcut associated with this item. The shortcut
 * will be triggered when the key that generates the given character is
 * pressed along with the modifier keys. Case is not significant and shortcut
 * characters will be displayed in lower case. Note that menu items with
 * the characters '\b' or '\n' as shortcuts will get triggered by the
 * Delete key or Carriage Return key, respectively.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support shortcuts.
 *
 * @param alphaChar The alphabetic shortcut key. This is the shortcut when
 *        using a keyboard with alphabetic keys.
 * @param alphaModifiers The modifier associated with the shortcut. It should
 *        be a combination of {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON}, {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON},
 *        {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON}, {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON},
 *        {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON}, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}.
 * @return This Item so additional setters can be called.
 * @apiSince 26
 */

public default android.view.MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) { throw new RuntimeException("Stub!"); }

/**
 * Return the char for this menu item's alphabetic shortcut.
 *
 * @return Alphabetic character to use as a shortcut.
 * @apiSince 1
 */

public char getAlphabeticShortcut();

/**
 * Return the modifier for this menu item's alphabetic shortcut.
 * The modifier is a combination of {@link android.view.KeyEvent#META_META_ON KeyEvent#META_META_ON},
 * {@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON}, {@link android.view.KeyEvent#META_ALT_ON KeyEvent#META_ALT_ON},
 * {@link android.view.KeyEvent#META_SHIFT_ON KeyEvent#META_SHIFT_ON}, {@link android.view.KeyEvent#META_SYM_ON KeyEvent#META_SYM_ON},
 * {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}.
 * For example, {@link android.view.KeyEvent#META_FUNCTION_ON KeyEvent#META_FUNCTION_ON}|{@link android.view.KeyEvent#META_CTRL_ON KeyEvent#META_CTRL_ON}
 *
 * @return Modifier associated with the keyboard shortcut.
 * @apiSince 26
 */

public default int getAlphabeticModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Control whether this item can display a check mark. Setting this does
 * not actually display a check mark (see {@link #setChecked} for that);
 * rather, it ensures there is room in the item in which to display a
 * check mark.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support check marks.
 *
 * @param checkable Set to true to allow a check mark, false to
 *            disallow. The default is false.
 * @see #setChecked
 * @see #isCheckable
 * @see android.view.Menu#setGroupCheckable
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setCheckable(boolean checkable);

/**
 * Return whether the item can currently display a check mark.
 *
 * @return If a check mark can be displayed, returns true.
 *
 * @see #setCheckable
 * @apiSince 1
 */

public boolean isCheckable();

/**
 * Control whether this item is shown with a check mark.  Note that you
 * must first have enabled checking with {@link #setCheckable} or else
 * the check mark will not appear.  If this item is a member of a group that contains
 * mutually-exclusive items (set via {@link android.view.Menu#setGroupCheckable(int,boolean,boolean) Menu#setGroupCheckable(int, boolean, boolean)},
 * the other items in the group will be unchecked.
 * <p>
 * See {@link android.view.Menu Menu} for the menu types that support check marks.
 *
 * @see #setCheckable
 * @see #isChecked
 * @see android.view.Menu#setGroupCheckable
 * @param checked Set to true to display a check mark, false to hide
 *                it.  The default value is false.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setChecked(boolean checked);

/**
 * Return whether the item is currently displaying a check mark.
 *
 * @return If a check mark is displayed, returns true.
 *
 * @see #setChecked
 * @apiSince 1
 */

public boolean isChecked();

/**
 * Sets the visibility of the menu item. Even if a menu item is not visible,
 * it may still be invoked via its shortcut (to completely disable an item,
 * set it to invisible and {@link #setEnabled(boolean) disabled}).
 *
 * @param visible If true then the item will be visible; if false it is
 *        hidden.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setVisible(boolean visible);

/**
 * Return the visibility of the menu item.
 *
 * @return If true the item is visible; else it is hidden.
 * @apiSince 1
 */

public boolean isVisible();

/**
 * Sets whether the menu item is enabled. Disabling a menu item will not
 * allow it to be invoked via its shortcut. The menu item will still be
 * visible.
 *
 * @param enabled If true then the item will be invokable; if false it is
 *        won't be invokable.
 * @return This Item so additional setters can be called.
 * @apiSince 1
 */

public android.view.MenuItem setEnabled(boolean enabled);

/**
 * Return the enabled state of the menu item.
 *
 * @return If true the item is enabled and hence invokable; else it is not.
 * @apiSince 1
 */

public boolean isEnabled();

/**
 * Check whether this item has an associated sub-menu.  I.e. it is a
 * sub-menu of another menu.
 *
 * @return If true this item has a menu; else it is a
 *         normal item.
 * @apiSince 1
 */

public boolean hasSubMenu();

/**
 * Get the sub-menu to be invoked when this item is selected, if it has
 * one. See {@link #hasSubMenu()}.
 *
 * @return The associated menu if there is one, else null
 * @apiSince 1
 */

public android.view.SubMenu getSubMenu();

/**
 * Set a custom listener for invocation of this menu item. In most
 * situations, it is more efficient and easier to use
 * {@link android.app.Activity#onOptionsItemSelected(android.view.MenuItem) Activity#onOptionsItemSelected(MenuItem)} or
 * {@link android.app.Activity#onContextItemSelected(android.view.MenuItem) Activity#onContextItemSelected(MenuItem)}.
 *
 * @param menuItemClickListener The object to receive invokations.
 * @return This Item so additional setters can be called.
 * @see android.app.Activity#onOptionsItemSelected(MenuItem)
 * @see android.app.Activity#onContextItemSelected(MenuItem)
 * @apiSince 1
 */

public android.view.MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener menuItemClickListener);

/**
 * Gets the extra information linked to this menu item.  This extra
 * information is set by the View that added this menu item to the
 * menu.
 *
 * @see android.view.View.OnCreateContextMenuListener
 * @return The extra information linked to the View that added this
 *         menu item to the menu. This can be null.
 * @apiSince 1
 */

public android.view.ContextMenu.ContextMenuInfo getMenuInfo();

/**
 * Sets how this item should display in the presence of an Action Bar.
 * The parameter actionEnum is a flag set. One of {@link #SHOW_AS_ACTION_ALWAYS},
 * {@link #SHOW_AS_ACTION_IF_ROOM}, or {@link #SHOW_AS_ACTION_NEVER} should
 * be used, and you may optionally OR the value with {@link #SHOW_AS_ACTION_WITH_TEXT}.
 * SHOW_AS_ACTION_WITH_TEXT requests that when the item is shown as an action,
 * it should be shown with a text label.
 *
 * @param actionEnum How the item should display. One of
 * {@link #SHOW_AS_ACTION_ALWAYS}, {@link #SHOW_AS_ACTION_IF_ROOM}, or
 * {@link #SHOW_AS_ACTION_NEVER}. SHOW_AS_ACTION_NEVER is the default.
 *
 * @see android.app.ActionBar
 * @see #setActionView(View)
 * @apiSince 11
 */

public void setShowAsAction(int actionEnum);

/**
 * Sets how this item should display in the presence of an Action Bar.
 * The parameter actionEnum is a flag set. One of {@link #SHOW_AS_ACTION_ALWAYS},
 * {@link #SHOW_AS_ACTION_IF_ROOM}, or {@link #SHOW_AS_ACTION_NEVER} should
 * be used, and you may optionally OR the value with {@link #SHOW_AS_ACTION_WITH_TEXT}.
 * SHOW_AS_ACTION_WITH_TEXT requests that when the item is shown as an action,
 * it should be shown with a text label.
 *
 * <p>Note: This method differs from {@link #setShowAsAction(int)} only in that it
 * returns the current MenuItem instance for call chaining.
 *
 * @param actionEnum How the item should display. One of
 * {@link #SHOW_AS_ACTION_ALWAYS}, {@link #SHOW_AS_ACTION_IF_ROOM}, or
 * {@link #SHOW_AS_ACTION_NEVER}. SHOW_AS_ACTION_NEVER is the default.
 *
 * @see android.app.ActionBar
 * @see #setActionView(View)
 * @return This MenuItem instance for call chaining.
 * @apiSince 14
 */

public android.view.MenuItem setShowAsActionFlags(int actionEnum);

/**
 * Set an action view for this menu item. An action view will be displayed in place
 * of an automatically generated menu item element in the UI when this item is shown
 * as an action within a parent.
 * <p>
 *   <strong>Note:</strong> Setting an action view overrides the action provider
 *           set via {@link #setActionProvider(android.view.ActionProvider)}.
 * </p>
 *
 * @param view View to use for presenting this item to the user.
 * @return This Item so additional setters can be called.
 *
 * @see #setShowAsAction(int)
 * @apiSince 11
 */

public android.view.MenuItem setActionView(android.view.View view);

/**
 * Set an action view for this menu item. An action view will be displayed in place
 * of an automatically generated menu item element in the UI when this item is shown
 * as an action within a parent.
 * <p>
 *   <strong>Note:</strong> Setting an action view overrides the action provider
 *           set via {@link #setActionProvider(android.view.ActionProvider)}.
 * </p>
 *
 * @param resId Layout resource to use for presenting this item to the user.
 * @return This Item so additional setters can be called.
 *
 * @see #setShowAsAction(int)
 * @apiSince 11
 */

public android.view.MenuItem setActionView(int resId);

/**
 * Returns the currently set action view for this menu item.
 *
 * @return This item's action view
 *
 * @see #setActionView(View)
 * @see #setShowAsAction(int)
 * @apiSince 11
 */

public android.view.View getActionView();

/**
 * Sets the {@link android.view.ActionProvider ActionProvider} responsible for creating an action view if
 * the item is placed on the action bar. The provider also provides a default
 * action invoked if the item is placed in the overflow menu.
 * <p>
 *   <strong>Note:</strong> Setting an action provider overrides the action view
 *           set via {@link #setActionView(int)} or {@link #setActionView(android.view.View)}.
 * </p>
 *
 * @param actionProvider The action provider.
 * @return This Item so additional setters can be called.
 *
 * @see android.view.ActionProvider
 * @apiSince 14
 */

public android.view.MenuItem setActionProvider(android.view.ActionProvider actionProvider);

/**
 * Gets the {@link android.view.ActionProvider ActionProvider}.
 *
 * @return The action provider.
 *
 * @see android.view.ActionProvider
 * @see #setActionProvider(ActionProvider)
 * @apiSince 14
 */

public android.view.ActionProvider getActionProvider();

/**
 * Expand the action view associated with this menu item.
 * The menu item must have an action view set, as well as
 * the showAsAction flag {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}.
 * If a listener has been set using {@link #setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener)}
 * it will have its {@link android.view.MenuItem.OnActionExpandListener#onMenuItemActionExpand(android.view.MenuItem) OnActionExpandListener#onMenuItemActionExpand(MenuItem)}
 * method invoked. The listener may return false from this method to prevent expanding
 * the action view.
 *
 * @return true if the action view was expanded, false otherwise.
 * @apiSince 14
 */

public boolean expandActionView();

/**
 * Collapse the action view associated with this menu item.
 * The menu item must have an action view set, as well as the showAsAction flag
 * {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}. If a listener has been set using
 * {@link #setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener)} it will have its
 * {@link android.view.MenuItem.OnActionExpandListener#onMenuItemActionCollapse(android.view.MenuItem) OnActionExpandListener#onMenuItemActionCollapse(MenuItem)} method invoked.
 * The listener may return false from this method to prevent collapsing the action view.
 *
 * @return true if the action view was collapsed, false otherwise.
 * @apiSince 14
 */

public boolean collapseActionView();

/**
 * Returns true if this menu item's action view has been expanded.
 *
 * @return true if the item's action view is expanded, false otherwise.
 *
 * @see #expandActionView()
 * @see #collapseActionView()
 * @see #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW
 * @see android.view.MenuItem.OnActionExpandListener
 * @apiSince 14
 */

public boolean isActionViewExpanded();

/**
 * Set an {@link android.view.MenuItem.OnActionExpandListener OnActionExpandListener} on this menu item to be notified when
 * the associated action view is expanded or collapsed. The menu item must
 * be configured to expand or collapse its action view using the flag
 * {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}.
 *
 * @param listener Listener that will respond to expand/collapse events
 * @return This menu item instance for call chaining
 * @apiSince 14
 */

public android.view.MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener listener);

/**
 * Change the content description associated with this menu item.
 *
 * @param contentDescription The new content description.
 * @apiSince 26
 */

public default android.view.MenuItem setContentDescription(java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the content description associated with this menu item.
 *
 * @return The content description.
 * @apiSince 26
 */

public default java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Change the tooltip text associated with this menu item.
 *
 * @param tooltipText The new tooltip text.
 * @apiSince 26
 */

public default android.view.MenuItem setTooltipText(java.lang.CharSequence tooltipText) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the tooltip text associated with this menu item.
 *
 * @return The tooltip text.
 * @apiSince 26
 */

public default java.lang.CharSequence getTooltipText() { throw new RuntimeException("Stub!"); }

/**
 * Always show this item as a button in an Action Bar.
 * Use sparingly! If too many items are set to always show in the Action Bar it can
 * crowd the Action Bar and degrade the user experience on devices with smaller screens.
 * A good rule of thumb is to have no more than 2 items set to always show at a time.
 * @apiSince 11
 */

public static final int SHOW_AS_ACTION_ALWAYS = 2; // 0x2

/**
 * This item's action view collapses to a normal menu item.
 * When expanded, the action view temporarily takes over
 * a larger segment of its container.
 * @apiSince 14
 */

public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8; // 0x8

/**
 * Show this item as a button in an Action Bar if the system decides there is room for it.
 * @apiSince 11
 */

public static final int SHOW_AS_ACTION_IF_ROOM = 1; // 0x1

/**
 * Never show this item as a button in an Action Bar.
 * @apiSince 11
 */

public static final int SHOW_AS_ACTION_NEVER = 0; // 0x0

/**
 * When this item is in the action bar, always show it with a text label even if
 * it also has an icon specified.
 * @apiSince 11
 */

public static final int SHOW_AS_ACTION_WITH_TEXT = 4; // 0x4
/**
 * Interface definition for a callback to be invoked when a menu item
 * marked with {@link android.view.MenuItem#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW MenuItem#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW} is
 * expanded or collapsed.
 *
 * @see android.view.MenuItem#expandActionView()
 * @see android.view.MenuItem#collapseActionView()
 * @see android.view.MenuItem#setShowAsActionFlags(int)
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnActionExpandListener {

/**
 * Called when a menu item with {@link android.view.MenuItem#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW MenuItem#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}
 * is expanded.
 * @param item Item that was expanded
 * @return true if the item should expand, false if expansion should be suppressed.
 * @apiSince 14
 */

public boolean onMenuItemActionExpand(android.view.MenuItem item);

/**
 * Called when a menu item with {@link android.view.MenuItem#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW MenuItem#SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}
 * is collapsed.
 * @param item Item that was collapsed
 * @return true if the item should collapse, false if collapsing should be suppressed.
 * @apiSince 14
 */

public boolean onMenuItemActionCollapse(android.view.MenuItem item);
}

/**
 * Interface definition for a callback to be invoked when a menu item is
 * clicked.
 *
 * @see android.app.Activity#onContextItemSelected(MenuItem)
 * @see android.app.Activity#onOptionsItemSelected(MenuItem)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnMenuItemClickListener {

/**
 * Called when a menu item has been invoked.  This is the first code
 * that is executed; if it returns true, no other callbacks will be
 * executed.
 *
 * @param item The menu item that was invoked.
 *
 * @return Return true to consume this click and prevent others from
 *         executing.
 * @apiSince 1
 */

public boolean onMenuItemClick(android.view.MenuItem item);
}

}

