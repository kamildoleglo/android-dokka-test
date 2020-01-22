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


package android.widget;

import android.graphics.drawable.Drawable;

/**
 *
 * Displays a list of tab labels representing each page in the parent's tab
 * collection.
 * <p>
 * The container object for this widget is {@link android.widget.TabHost TabHost}.
 * When the user selects a tab, this object sends a message to the parent
 * container, TabHost, to tell it to switch the displayed page. You typically
 * won't use many methods directly on this object. The container TabHost is
 * used to add labels, add the callback handler, and manage callbacks. You
 * might call this object to iterate the list of tabs, or to tweak the layout
 * of the tab list, but most methods should be called on the containing TabHost
 * object.
 *
 * @attr ref android.R.styleable#TabWidget_divider
 * @attr ref android.R.styleable#TabWidget_tabStripEnabled
 * @attr ref android.R.styleable#TabWidget_tabStripLeft
 * @attr ref android.R.styleable#TabWidget_tabStripRight
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TabWidget extends android.widget.LinearLayout implements android.view.View.OnFocusChangeListener {

/** @apiSince 1 */

public TabWidget(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public TabWidget(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public TabWidget(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TabWidget(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int getChildDrawingOrder(int childCount, int i) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tab indicator view at the given index.
 *
 * @param index the zero-based index of the tab indicator view to return
 * @return the tab indicator view at the given index
 * @apiSince 4
 */

public android.view.View getChildTabViewAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of tab indicator views.
 *
 * @return the number of tab indicator views
 * @apiSince 4
 */

public int getTabCount() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to use as a divider between the tab indicators.
 *
 * @param drawable the divider drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#TabWidget_divider
 * @apiSince 4
 */

public void setDividerDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to use as a divider between the tab indicators.
 *
 * @param resId the resource identifier of the drawable to use as a divider
 * @attr ref android.R.styleable#TabWidget_divider
 * @apiSince 4
 */

public void setDividerDrawable(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to use as the left part of the strip below the tab
 * indicators.
 *
 * @param drawable the left strip drawable
 * This value may be {@code null}.
 * @see #getLeftStripDrawable()
 * @attr ref android.R.styleable#TabWidget_tabStripLeft
 * @apiSince 8
 */

public void setLeftStripDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to use as the left part of the strip below the tab
 * indicators.
 *
 * @param resId the resource identifier of the drawable to use as the left
 *              strip drawable
 * @see #getLeftStripDrawable()
 * @attr ref android.R.styleable#TabWidget_tabStripLeft
 * @apiSince 8
 */

public void setLeftStripDrawable(int resId) { throw new RuntimeException("Stub!"); }

/**
 * @return the drawable used as the left part of the strip below the tab
 *         indicators, may be {@code null}
 * @see #setLeftStripDrawable(int)
 * @see #setLeftStripDrawable(Drawable)
 * @attr ref android.R.styleable#TabWidget_tabStripLeft
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getLeftStripDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to use as the right part of the strip below the tab
 * indicators.
 *
 * @param drawable the right strip drawable
 * This value may be {@code null}.
 * @see #getRightStripDrawable()
 * @attr ref android.R.styleable#TabWidget_tabStripRight
 * @apiSince 8
 */

public void setRightStripDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable to use as the right part of the strip below the tab
 * indicators.
 *
 * @param resId the resource identifier of the drawable to use as the right
 *              strip drawable
 * @see #getRightStripDrawable()
 * @attr ref android.R.styleable#TabWidget_tabStripRight
 * @apiSince 8
 */

public void setRightStripDrawable(int resId) { throw new RuntimeException("Stub!"); }

/**
 * @return the drawable used as the right part of the strip below the tab
 *         indicators, may be {@code null}
 * @see #setRightStripDrawable(int)
 * @see #setRightStripDrawable(Drawable)
 * @attr ref android.R.styleable#TabWidget_tabStripRight
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getRightStripDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether the bottom strips on the tab indicators are drawn or
 * not.  The default is to draw them.  If the user specifies a custom
 * view for the tab indicators, then the TabHost class calls this method
 * to disable drawing of the bottom strips.
 * @param stripEnabled true if the bottom strips should be drawn.
 * @apiSince 8
 */

public void setStripEnabled(boolean stripEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the bottom strips on the tab indicators are drawn
 * or not.
 * @apiSince 8
 */

public boolean isStripEnabled() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void childDrawableStateChanged(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current tab.
 * <p>
 * This method is used to bring a tab to the front of the Widget,
 * and is used to post to the rest of the UI that a different tab
 * has been brought to the foreground.
 * <p>
 * Note, this is separate from the traditional "focus" that is
 * employed from the view logic.
 * <p>
 * For instance, if we have a list in a tabbed view, a user may be
 * navigating up and down the list, moving the UI focus (orange
 * highlighting) through the list items.  The cursor movement does
 * not effect the "selected" tab though, because what is being
 * scrolled through is all on the same tab.  The selected tab only
 * changes when we navigate between tabs (moving from the list view
 * to the next tabbed view, in this example).
 * <p>
 * To move both the focus AND the selected tab at once, please use
 * {@link #focusCurrentTab}. Normally, the view logic takes care of
 * adjusting the focus, so unless you're circumventing the UI,
 * you'll probably just focus your interest here.
 *
 * @param index the index of the tab that you want to indicate as the
 *              selected tab (tab brought to the front of the widget)
 * @see #focusCurrentTab
 * @apiSince 1
 */

public void setCurrentTab(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current tab and focuses the UI on it.
 * This method makes sure that the focused tab matches the selected
 * tab, normally at {@link #setCurrentTab}.  Normally this would not
 * be an issue if we go through the UI, since the UI is responsible
 * for calling TabWidget.onFocusChanged(), but in the case where we
 * are selecting the tab programmatically, we'll need to make sure
 * focus keeps up.
 *
 *  @param index The tab that you want focused (highlighted in orange)
 *  and selected (tab brought to the front of the widget)
 *
 *  @see #setCurrentTab
 * @apiSince 1
 */

public void focusCurrentTab(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void addView(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeAllViews() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent event, int pointerIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onFocusChange(android.view.View v, boolean hasFocus) { throw new RuntimeException("Stub!"); }
}

