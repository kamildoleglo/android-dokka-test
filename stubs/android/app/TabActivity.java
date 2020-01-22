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

import android.widget.TabHost;
import android.widget.TabWidget;

/**
 * <p>For apps developing against {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * or later, tabs are typically presented in the UI using the new
 * {@link android.app.ActionBar#newTab() ActionBar#newTab()} and
 * related APIs for placing tabs within their action bar area.</p>
 *
 * @deprecated New applications should use Fragments instead of this class;
 * to continue to run on older devices, you can use the v4 support library
 * which provides a version of the Fragment API that is compatible down to
 * {@link android.os.Build.VERSION_CODES#DONUT}.
 * @apiSince 1
 * @deprecatedSince 13
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class TabActivity extends android.app.ActivityGroup {

/** @apiSince 1 */

@Deprecated
public TabActivity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default tab that is the first tab highlighted.
 *
 * @param tag the name of the default tab
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void setDefaultTab(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default tab that is the first tab highlighted.
 *
 * @param index the index of the default tab
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void setDefaultTab(int index) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Bundle state) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
protected void onPostCreate(android.os.Bundle icicle) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
protected void onSaveInstanceState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * Updates the screen state (current list and other views) when the
 * content changes.
 *
 *@see android.app.Activity#onContentChanged()
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public void onContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
protected void onChildTitleChanged(android.app.Activity childActivity, java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.widget.TabHost TabHost} the activity is using to host its tabs.
 *
 * @return the {@link android.widget.TabHost TabHost} the activity is using to host its tabs.
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public android.widget.TabHost getTabHost() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.widget.TabWidget TabWidget} the activity is using to draw the actual tabs.
 *
 * @return the {@link android.widget.TabWidget TabWidget} the activity is using to draw the actual tabs.
 * @apiSince 1
 * @deprecatedSince 13
 */

@Deprecated
public android.widget.TabWidget getTabWidget() { throw new RuntimeException("Stub!"); }
}

