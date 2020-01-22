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

import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;

/**
 * ActionMenuView is a presentation of a series of menu options as a View. It provides
 * several top level options as action buttons while spilling remaining options over as
 * items in an overflow menu. This allows applications to present packs of actions inline with
 * specific or repeating content.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ActionMenuView extends android.widget.LinearLayout {

/** @apiSince 21 */

public ActionMenuView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ActionMenuView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Specifies the theme to use when inflating popup menus. By default, uses
 * the same theme as the action menu view itself.
 *
 * @param resId theme used to inflate popup menus
 * @see #getPopupTheme()
 * @apiSince 21
 */

public void setPopupTheme(int resId) { throw new RuntimeException("Stub!"); }

/**
 * @return resource identifier of the theme used to inflate popup menus, or
 *         0 if menus are inflated against the action menu view theme
 * @see #setPopupTheme(int)
 * @apiSince 21
 */

public int getPopupTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setOnMenuItemClickListener(android.widget.ActionMenuView.OnMenuItemClickListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * Set the icon to use for the overflow button.
 *
 * @param icon Drawable to set, may be null to clear the icon
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void setOverflowIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Return the current drawable used as the overflow icon.
 *
 * @return The overflow icon drawable
 
 * This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getOverflowIcon() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected android.widget.ActionMenuView.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.widget.ActionMenuView.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected android.widget.ActionMenuView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Menu object that this ActionMenuView is currently presenting.
 *
 * <p>Applications should use this method to obtain the ActionMenuView's Menu object
 * and inflate or add content to it as necessary.</p>
 *
 * @return the Menu presented by this view
 * @apiSince 21
 */

public android.view.Menu getMenu() { throw new RuntimeException("Stub!"); }

/**
 * Show the overflow items from the associated menu.
 *
 * @return true if the menu was able to be shown, false otherwise
 * @apiSince 21
 */

public boolean showOverflowMenu() { throw new RuntimeException("Stub!"); }

/**
 * Hide the overflow items from the associated menu.
 *
 * @return true if the menu was able to be hidden, false otherwise
 * @apiSince 21
 */

public boolean hideOverflowMenu() { throw new RuntimeException("Stub!"); }

/**
 * Check whether the overflow menu is currently showing. This may not reflect
 * a pending show operation in progress.
 *
 * @return true if the overflow menu is currently showing
 * @apiSince 21
 */

public boolean isOverflowMenuShowing() { throw new RuntimeException("Stub!"); }

/**
 * Dismiss any popups associated with this menu view.
 * @apiSince 21
 */

public void dismissPopupMenus() { throw new RuntimeException("Stub!"); }
/** @apiSince 21 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {

/** @apiSince 21 */

public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(android.view.ViewGroup.LayoutParams other) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(android.widget.ActionMenuView.LayoutParams other) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LayoutParams(int width, int height) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }
}

/**
 * Interface responsible for receiving menu item click events if the items themselves
 * do not have individual item click listeners.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnMenuItemClickListener {

/**
 * This method will be invoked when a menu item is clicked if the item itself did
 * not already handle the event.
 *
 * @param item {@link android.view.MenuItem MenuItem} that was clicked
 * @return <code>true</code> if the event was handled, <code>false</code> otherwise.
 * @apiSince 21
 */

public boolean onMenuItemClick(android.view.MenuItem item);
}

}

