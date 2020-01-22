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


package android.app;

import android.view.View;
import android.app.FragmentManager.BackStackEntry;

/**
 * Helper class for showing "bread crumbs" representing the fragment
 * stack in an activity.  This is intended to be used with
 * {@link android.app.ActionBar#setCustomView(android.view.View) ActionBar#setCustomView(View)} to place the bread crumbs in
 * the action bar.
 *
 * <p>The default style for this view is
 * {@link android.R.style#Widget_FragmentBreadCrumbs}.
 *
 * @deprecated This widget is no longer supported.
 * @apiSince 11
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class FragmentBreadCrumbs extends android.view.ViewGroup implements android.app.FragmentManager.OnBackStackChangedListener {

/** @apiSince 11 */

@Deprecated
public FragmentBreadCrumbs(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

@Deprecated
public FragmentBreadCrumbs(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

@Deprecated
public FragmentBreadCrumbs(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Attach the bread crumbs to their activity.  This must be called once
 * when creating the bread crumbs.
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public void setActivity(android.app.Activity a) { throw new RuntimeException("Stub!"); }

/**
 * The maximum number of breadcrumbs to show. Older fragment headers will be hidden from view.
 * @param visibleCrumbs the number of visible breadcrumbs. This should be greater than zero.
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public void setMaxVisible(int visibleCrumbs) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an optional parent entry at the first position in the breadcrumbs. Selecting this
 * entry will result in a call to the specified listener's
 * {@link android.view.View.OnClickListener#onClick(View)}
 * method.
 *
 * @param title the title for the parent entry
 * @param shortTitle the short title for the parent entry
 * @param listener the {@link android.view.View.OnClickListener} to be called when clicked.
 * A null will result in no action being taken when the parent entry is clicked.
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public void setParentTitle(java.lang.CharSequence title, java.lang.CharSequence shortTitle, android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener for clicks on the bread crumbs.  This will be called before
 * the default click action is performed.
 *
 * @param listener The new listener to set.  Replaces any existing listener.
 * @apiSince 12
 * @deprecatedSince 21
 */

@Deprecated
public void setOnBreadCrumbClickListener(android.app.FragmentBreadCrumbs.OnBreadCrumbClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a custom title for the bread crumbs.  This will be the first entry
 * shown at the left, representing the root of the bread crumbs.  If the
 * title is null, it will not be shown.
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public void setTitle(java.lang.CharSequence title, java.lang.CharSequence shortTitle) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public void onBackStackChanged() { throw new RuntimeException("Stub!"); }
/**
 * Interface to intercept clicks on the bread crumbs.
 *
 * @deprecated This widget is no longer supported.
 * @apiSince 12
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnBreadCrumbClickListener {

/**
 * Called when a bread crumb is clicked.
 *
 * @param backStack The BackStackEntry whose bread crumb was clicked.
 * May be null, if this bread crumb is for the root of the back stack.
 * @param flags Additional information about the entry.  Currently
 * always 0.
 *
 * @return Return true to consume this click.  Return to false to allow
 * the default action (popping back stack to this entry) to occur.
 * @apiSince 12
 * @deprecatedSince 28
 */

@Deprecated
public boolean onBreadCrumbClick(android.app.FragmentManager.BackStackEntry backStack, int flags);
}

}

