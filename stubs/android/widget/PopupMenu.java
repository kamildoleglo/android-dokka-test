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


package android.widget;

import android.view.Menu;
import android.view.View;
import android.content.Context;
import android.view.Gravity;
import android.view.View.OnTouchListener;
import android.view.MenuInflater;

/**
 * A PopupMenu displays a {@link android.view.Menu Menu} in a modal popup window anchored to a
 * {@link android.view.View View}. The popup will appear below the anchor view if there is room,
 * or above it if there is not. If the IME is visible the popup will not
 * overlap it until it is touched. Touching outside of the popup will dismiss
 * it.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PopupMenu {

/**
 * Constructor to create a new popup menu with an anchor view.
 *
 * @param context Context the popup menu is running in, through which it
 *        can access the current theme, resources, etc.
 * @param anchor Anchor view for this popup. The popup will appear below
 *        the anchor if there is room, or above it if there is not.
 * @apiSince 11
 */

public PopupMenu(android.content.Context context, android.view.View anchor) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to create a new popup menu with an anchor view and alignment
 * gravity.
 *
 * @param context Context the popup menu is running in, through which it
 *        can access the current theme, resources, etc.
 * @param anchor Anchor view for this popup. The popup will appear below
 *        the anchor if there is room, or above it if there is not.
 * @param gravity The {@link android.view.Gravity Gravity} value for aligning the popup with its
 *        anchor.
 * @apiSince 19
 */

public PopupMenu(android.content.Context context, android.view.View anchor, int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Constructor a create a new popup menu with a specific style.
 *
 * @param context Context the popup menu is running in, through which it
 *        can access the current theme, resources, etc.
 * @param anchor Anchor view for this popup. The popup will appear below
 *        the anchor if there is room, or above it if there is not.
 * @param gravity The {@link android.view.Gravity Gravity} value for aligning the popup with its
 *        anchor.
 * @param popupStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the popup window. Can be 0 to not look for defaults.
 * @param popupStyleRes A resource identifier of a style resource that
 *        supplies default values for the popup window, used only if
 *        popupStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 * @apiSince 22
 */

public PopupMenu(android.content.Context context, android.view.View anchor, int gravity, int popupStyleAttr, int popupStyleRes) { throw new RuntimeException("Stub!"); }

/**
 * Sets the gravity used to align the popup window to its anchor view.
 * <p>
 * If the popup is showing, calling this method will take effect only
 * the next time the popup is shown.
 *
 * @param gravity the gravity used to align the popup window
 * @see #getGravity()
 * @apiSince 23
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * @return the gravity used to align the popup window to its anchor view
 * @see #setGravity(int)
 * @apiSince 23
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link android.view.View.OnTouchListener OnTouchListener} that can be added to the anchor view
 * to implement drag-to-open behavior.
 * <p>
 * When the listener is set on a view, touching that view and dragging
 * outside of its bounds will open the popup window. Lifting will select
 * the currently touched list item.
 * <p>
 * Example usage:
 * <pre>
 * PopupMenu myPopup = new PopupMenu(context, myAnchor);
 * myAnchor.setOnTouchListener(myPopup.getDragToOpenListener());
 * </pre>
 *
 * @return a touch listener that controls drag-to-open behavior
 * @apiSince 19
 */

public android.view.View.OnTouchListener getDragToOpenListener() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.view.Menu Menu} associated with this popup. Populate the
 * returned Menu with items before calling {@link #show()}.
 *
 * @return the {@link android.view.Menu Menu} associated with this popup
 * @see #show()
 * @see #getMenuInflater()
 * @apiSince 11
 */

public android.view.Menu getMenu() { throw new RuntimeException("Stub!"); }

/**
 * @return a {@link android.view.MenuInflater MenuInflater} that can be used to inflate menu items
 *         from XML into the menu returned by {@link #getMenu()}
 * @see #getMenu()
 * @apiSince 11
 */

public android.view.MenuInflater getMenuInflater() { throw new RuntimeException("Stub!"); }

/**
 * Inflate a menu resource into this PopupMenu. This is equivalent to
 * calling {@code popupMenu.getMenuInflater().inflate(menuRes, popupMenu.getMenu())}.
 *
 * @param menuRes Menu resource to inflate
 * @apiSince 14
 */

public void inflate(int menuRes) { throw new RuntimeException("Stub!"); }

/**
 * Show the menu popup anchored to the view specified during construction.
 *
 * @see #dismiss()
 * @apiSince 11
 */

public void show() { throw new RuntimeException("Stub!"); }

/**
 * Dismiss the menu popup.
 *
 * @see #show()
 * @apiSince 11
 */

public void dismiss() { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener that will be notified when the user selects an item from
 * the menu.
 *
 * @param listener the listener to notify
 * @apiSince 11
 */

public void setOnMenuItemClickListener(android.widget.PopupMenu.OnMenuItemClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener that will be notified when this menu is dismissed.
 *
 * @param listener the listener to notify
 * @apiSince 14
 */

public void setOnDismissListener(android.widget.PopupMenu.OnDismissListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the popup menu's adapter is forced to show icons in the
 * menu item views.
 * <p>
 * Changes take effect on the next call to show().
 *
 * @param forceShowIcon {@code true} to force icons to be shown, or
 *                  {@code false} for icons to be optionally shown
 * @apiSince 29
 */

public void setForceShowIcon(boolean forceShowIcon) { throw new RuntimeException("Stub!"); }
/**
 * Callback interface used to notify the application that the menu has closed.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDismissListener {

/**
 * Called when the associated menu has been dismissed.
 *
 * @param menu the popup menu that was dismissed
 * @apiSince 14
 */

public void onDismiss(android.widget.PopupMenu menu);
}

/**
 * Interface responsible for receiving menu item click events if the items
 * themselves do not have individual item click listeners.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnMenuItemClickListener {

/**
 * This method will be invoked when a menu item is clicked if the item
 * itself did not already handle the event.
 *
 * @param item the menu item that was clicked
 * @return {@code true} if the event was handled, {@code false}
 *         otherwise
 * @apiSince 11
 */

public boolean onMenuItemClick(android.view.MenuItem item);
}

}

