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

import android.content.Intent;
import android.view.View;

/**
 * Container for a tabbed window view. This object holds two children: a set of tab labels that the
 * user clicks to select a specific tab, and a FrameLayout object that displays the contents of that
 * page. The individual elements are typically controlled using this container object, rather than
 * setting values on the child elements themselves.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TabHost extends android.widget.FrameLayout implements android.view.ViewTreeObserver.OnTouchModeChangeListener {

/** @apiSince 1 */

public TabHost(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public TabHost(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TabHost(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TabHost(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.widget.TabHost.TabSpec TabSpec} associated with this tab host.
 *
 * @param tag tag for the tab specification, must be non-null
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException If the passed tag is null
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.widget.TabHost.TabSpec newTabSpec(@androidx.annotation.NonNull java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
      * <p>Call setup() before adding tabs if loading TabHost using findViewById().
      * <i><b>However</i></b>: You do not need to call setup() after getTabHost()
      * in {@link android.app.TabActivity TabActivity}.
      * Example:</p>
 <pre>mTabHost = (TabHost)findViewById(R.id.tabhost);
 mTabHost.setup();
 mTabHost.addTab(TAB_TAG_1, "Hello, world!", "Tab 1");
      * @apiSince 1
       */

public void setup() { throw new RuntimeException("Stub!"); }

/**
 * If you are using {@link android.widget.TabHost.TabSpec#setContent(android.content.Intent) TabSpec#setContent(android.content.Intent)}, this
 * must be called since the activityGroup is needed to launch the local activity.
 *
 * This is done for you if you extend {@link android.app.TabActivity}.
 * @param activityGroup Used to launch activities for tab content.
 * @apiSince 1
 */

public void setup(android.app.LocalActivityManager activityGroup) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onTouchModeChanged(boolean isInTouchMode) { throw new RuntimeException("Stub!"); }

/**
 * Add a tab.
 * @param tabSpec Specifies how to create the indicator and content.
 * @throws java.lang.IllegalArgumentException If the passed tab spec has null indicator strategy and / or
 *      null content strategy.
 * @apiSince 1
 */

public void addTab(android.widget.TabHost.TabSpec tabSpec) { throw new RuntimeException("Stub!"); }

/**
 * Removes all tabs from the tab widget associated with this tab host.
 * @apiSince 1
 */

public void clearAllTabs() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.TabWidget getTabWidget() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current tab.
 *
 * @return the current tab, may be {@code null} if no tab is set as current
 * @apiSince 1
 */

@androidx.annotation.Nullable
public int getCurrentTab() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tag for the current tab.
 *
 * @return the tag for the current tab, may be {@code null} if no tab is
 *         set as current
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getCurrentTabTag() { throw new RuntimeException("Stub!"); }

/**
 * Returns the view for the current tab.
 *
 * @return the view for the current tab, may be {@code null} if no tab is
 *         set as current
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.view.View getCurrentTabView() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View getCurrentView() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current tab based on its tag.
 *
 * @param tag the tag for the tab to set as current
 * @apiSince 1
 */

public void setCurrentTabByTag(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Get the FrameLayout which holds tab content
 * @apiSince 1
 */

public android.widget.FrameLayout getTabContentView() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dispatchWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setCurrentTab(int index) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the selected state of any of the items
 * in this list changes
 * @param l
 * The callback that will run
 * @apiSince 1
 */

public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener l) { throw new RuntimeException("Stub!"); }
/**
 * Interface definition for a callback to be invoked when tab changed
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTabChangeListener {

/** @apiSince 1 */

public void onTabChanged(java.lang.String tabId);
}

/**
 * Makes the content of a tab when it is selected. Use this if your tab
 * content needs to be created on demand, i.e. you are not showing an
 * existing view or starting an activity.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TabContentFactory {

/**
 * Callback to make the tab contents
 *
 * @param tag
 *            Which tab was selected.
 * @return The view to display the contents of the selected tab.
 * @apiSince 1
 */

public android.view.View createTabContent(java.lang.String tag);
}

/**
 * A tab has a tab indicator, content, and a tag that is used to keep
 * track of it.  This builder helps choose among these options.
 *
 * For the tab indicator, your choices are:
 * 1) set a label
 * 2) set a label and an icon
 *
 * For the tab content, your choices are:
 * 1) the id of a {@link android.view.View View}
 * 2) a {@link android.widget.TabHost.TabContentFactory TabContentFactory} that creates the {@link android.view.View View} content.
 * 3) an {@link android.content.Intent Intent} that launches an {@link android.app.Activity}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TabSpec {

private TabSpec() { throw new RuntimeException("Stub!"); }

/**
 * Specify a label as the tab indicator.
 * @apiSince 1
 */

public android.widget.TabHost.TabSpec setIndicator(java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Specify a label and icon as the tab indicator.
 * @apiSince 1
 */

public android.widget.TabHost.TabSpec setIndicator(java.lang.CharSequence label, android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Specify a view as the tab indicator.
 * @apiSince 4
 */

public android.widget.TabHost.TabSpec setIndicator(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Specify the id of the view that should be used as the content
 * of the tab.
 * @apiSince 1
 */

public android.widget.TabHost.TabSpec setContent(int viewId) { throw new RuntimeException("Stub!"); }

/**
 * Specify a {@link android.widget.TabHost.TabContentFactory} to use to
 * create the content of the tab.
 * @apiSince 1
 */

public android.widget.TabHost.TabSpec setContent(android.widget.TabHost.TabContentFactory contentFactory) { throw new RuntimeException("Stub!"); }

/**
 * Specify an intent to use to launch an activity as the tab content.
 * @apiSince 1
 */

public android.widget.TabHost.TabSpec setContent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tag for this tab specification.
 *
 * @return the tag for this tab specification
 
 * This value will never be {@code null}.
 * @apiSince 4
 */

@androidx.annotation.NonNull
public java.lang.String getTag() { throw new RuntimeException("Stub!"); }
}

}

