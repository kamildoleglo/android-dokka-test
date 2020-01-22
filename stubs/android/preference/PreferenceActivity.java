/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.preference;

import android.app.Fragment;
import android.os.Bundle;
import android.content.Intent;
import android.app.FragmentBreadCrumbs;

/**
 * This is the base class for an activity to show a hierarchy of preferences
 * to the user.  Prior to {@link android.os.Build.VERSION_CODES#HONEYCOMB}
 * this class only allowed the display of a single set of preference; this
 * functionality should now be found in the new {@link android.preference.PreferenceFragment PreferenceFragment}
 * class.  If you are using PreferenceActivity in its old mode, the documentation
 * there applies to the deprecated APIs here.
 *
 * <p>This activity shows one or more headers of preferences, each of which
 * is associated with a {@link android.preference.PreferenceFragment PreferenceFragment} to display the preferences
 * of that header.  The actual layout and display of these associations can
 * however vary; currently there are two major approaches it may take:
 *
 * <ul>
 * <li>On a small screen it may display only the headers as a single list when first launched.
 * Selecting one of the header items will only show the PreferenceFragment of that header (on
 * Android N and lower a new Activity is launched).
 * <li>On a large screen it may display both the headers and current PreferenceFragment together as
 * panes. Selecting a header item switches to showing the correct PreferenceFragment for that item.
 * </ul>
 *
 * <p>Subclasses of PreferenceActivity should implement
 * {@link #onBuildHeaders} to populate the header list with the desired
 * items.  Doing this implicitly switches the class into its new "headers
 * + fragments" mode rather than the old style of just showing a single
 * preferences list.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about using {@code PreferenceActivity},
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices. For more information on
 *      using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class PreferenceActivity extends android.app.ListActivity implements android.preference.PreferenceFragment.OnPreferenceStartFragmentCallback {

@Deprecated
public PreferenceActivity() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean onOptionsItemSelected(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param savedInstanceState This value may be {@code null}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onCreate(@androidx.annotation.Nullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 5
 * @deprecatedSince 29
 */

@Deprecated
public void onBackPressed() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this activity is currently showing the header list.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public boolean hasHeaders() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this activity is showing multiple panes -- the headers
 * and a preference fragment.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public boolean isMultiPane() { throw new RuntimeException("Stub!"); }

/**
 * Called to determine if the activity should run in multi-pane mode.
 * The default implementation returns true if the screen is large
 * enough.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public boolean onIsMultiPane() { throw new RuntimeException("Stub!"); }

/**
 * Called to determine whether the header list should be hidden.
 * The default implementation returns the
 * value given in {@link #EXTRA_NO_HEADERS} or false if it is not supplied.
 * This is set to false, for example, when the activity is being re-launched
 * to show a particular preference activity.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public boolean onIsHidingHeaders() { throw new RuntimeException("Stub!"); }

/**
 * Called to determine the initial header to be shown.  The default
 * implementation simply returns the fragment of the first header.  Note
 * that the returned Header object does not actually need to exist in
 * your header list -- whatever its fragment is will simply be used to
 * show for the initial UI.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.PreferenceActivity.Header onGetInitialHeader() { throw new RuntimeException("Stub!"); }

/**
 * Called after the header list has been updated ({@link #onBuildHeaders}
 * has been called and returned due to {@link #invalidateHeaders()}) to
 * specify the header that should now be selected.  The default implementation
 * returns null to keep whatever header is currently selected.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.PreferenceActivity.Header onGetNewHeader() { throw new RuntimeException("Stub!"); }

/**
 * Called when the activity needs its list of headers build.  By
 * implementing this and adding at least one item to the list, you
 * will cause the activity to run in its modern fragment mode.  Note
 * that this function may not always be called; for example, if the
 * activity has been asked to display a particular fragment without
 * the header list, there is no need to build the headers.
 *
 * <p>Typical implementations will use {@link #loadHeadersFromResource}
 * to fill in the list from a resource.
 *
 * @param target The list in which to place the headers.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void onBuildHeaders(java.util.List<android.preference.PreferenceActivity.Header> target) { throw new RuntimeException("Stub!"); }

/**
 * Call when you need to change the headers being displayed.  Will result
 * in onBuildHeaders() later being called to retrieve the new list.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void invalidateHeaders() { throw new RuntimeException("Stub!"); }

/**
 * Parse the given XML file as a header description, adding each
 * parsed Header into the target list.
 *
 * @param resid The XML resource to load and parse.
 * @param target The list in which the parsed headers should be placed.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void loadHeadersFromResource(int resid, java.util.List<android.preference.PreferenceActivity.Header> target) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses should override this method and verify that the given fragment is a valid type
 * to be attached to this activity. The default implementation returns <code>true</code> for
 * apps built for <code>android:targetSdkVersion</code> older than
 * {@link android.os.Build.VERSION_CODES#KITKAT}. For later versions, it will throw an exception.
 * @param fragmentName the class name of the Fragment about to be attached to this activity.
 * @return true if the fragment class name is valid for this Activity and false otherwise.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
protected boolean isValidFragment(java.lang.String fragmentName) { throw new RuntimeException("Stub!"); }

/**
 * Set a footer that should be shown at the bottom of the header list.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void setListFooter(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onStop() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onSaveInstanceState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Bundle state) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * Called when the user selects an item in the header list.  The default
 * implementation will call either
 * {@link #startWithFragment(java.lang.String,android.os.Bundle,android.app.Fragment,int,int,int)}
 * or {@link #switchToHeader(android.preference.PreferenceActivity.Header)} as appropriate.
 *
 * @param header The header that was selected.
 * @param position The header's position in the list.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void onHeaderClick(android.preference.PreferenceActivity.Header header, int position) { throw new RuntimeException("Stub!"); }

/**
 * Called by {@link #startWithFragment(java.lang.String,android.os.Bundle,android.app.Fragment,int,int,int)} when
 * in single-pane mode, to build an Intent to launch a new activity showing
 * the selected fragment.  The default implementation constructs an Intent
 * that re-launches the current activity with the appropriate arguments to
 * display the fragment.
 *
 * @param fragmentName The name of the fragment to display.
 * @param args Optional arguments to supply to the fragment.
 * @param titleRes Optional resource ID of title to show for this item.
 * @param shortTitleRes Optional resource ID of short title to show for this item.
 * @return Returns an Intent that can be launched to display the given
 * fragment.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public android.content.Intent onBuildStartFragmentIntent(java.lang.String fragmentName, android.os.Bundle args, int titleRes, int shortTitleRes) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #startWithFragment(java.lang.String,android.os.Bundle,android.app.Fragment,int,int,int)}
 * but uses a 0 titleRes.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void startWithFragment(java.lang.String fragmentName, android.os.Bundle args, android.app.Fragment resultTo, int resultRequestCode) { throw new RuntimeException("Stub!"); }

/**
 * Start a new instance of this activity, showing only the given
 * preference fragment.  When launched in this mode, the header list
 * will be hidden and the given preference fragment will be instantiated
 * and fill the entire activity.
 *
 * @param fragmentName The name of the fragment to display.
 * @param args Optional arguments to supply to the fragment.
 * @param resultTo Option fragment that should receive the result of
 * the activity launch.
 * @param resultRequestCode If resultTo is non-null, this is the request
 * code in which to report the result.
 * @param titleRes Resource ID of string to display for the title of
 * this set of preferences.
 * @param shortTitleRes Resource ID of string to display for the short title of
 * this set of preferences.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void startWithFragment(java.lang.String fragmentName, android.os.Bundle args, android.app.Fragment resultTo, int resultRequestCode, int titleRes, int shortTitleRes) { throw new RuntimeException("Stub!"); }

/**
 * Change the base title of the bread crumbs for the current preferences.
 * This will normally be called for you.  See
 * {@link android.app.FragmentBreadCrumbs} for more information.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void showBreadCrumbs(java.lang.CharSequence title, java.lang.CharSequence shortTitle) { throw new RuntimeException("Stub!"); }

/**
 * Should be called after onCreate to ensure that the breadcrumbs, if any, were created.
 * This prepends a title to the fragment breadcrumbs and attaches a listener to any clicks
 * on the parent entry.
 * @param title the title for the breadcrumb
 * @param shortTitle the short title for the breadcrumb
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void setParentTitle(java.lang.CharSequence title, java.lang.CharSequence shortTitle, android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * When in two-pane mode, switch the fragment pane to show the given
 * preference fragment.
 *
 * @param fragmentName The name of the fragment to display.
 * @param args Optional arguments to supply to the fragment.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void switchToHeader(java.lang.String fragmentName, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * When in two-pane mode, switch to the fragment pane to show the given
 * preference fragment.
 *
 * @param header The new header to display.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void switchToHeader(android.preference.PreferenceActivity.Header header) { throw new RuntimeException("Stub!"); }

/**
 * Start a new fragment.
 *
 * @param fragment The fragment to start
 * @param push If true, the current fragment will be pushed onto the back stack.  If false,
 * the current fragment will be replaced.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void startPreferenceFragment(android.app.Fragment fragment, boolean push) { throw new RuntimeException("Stub!"); }

/**
 * Start a new fragment containing a preference panel.  If the preferences
 * are being displayed in multi-pane mode, the given fragment class will
 * be instantiated and placed in the appropriate pane.  If running in
 * single-pane mode, a new activity will be launched in which to show the
 * fragment.
 *
 * @param fragmentClass Full name of the class implementing the fragment.
 * @param args Any desired arguments to supply to the fragment.
 * @param titleRes Optional resource identifier of the title of this
 * fragment.
 * @param titleText Optional text of the title of this fragment.
 * @param resultTo Optional fragment that result data should be sent to.
 * If non-null, resultTo.onActivityResult() will be called when this
 * preference panel is done.  The launched panel must use
 * {@link #finishPreferencePanel(android.app.Fragment,int,android.content.Intent)} when done.
 * @param resultRequestCode If resultTo is non-null, this is the caller's
 * request code to be received with the result.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void startPreferencePanel(java.lang.String fragmentClass, android.os.Bundle args, int titleRes, java.lang.CharSequence titleText, android.app.Fragment resultTo, int resultRequestCode) { throw new RuntimeException("Stub!"); }

/**
 * Called by a preference panel fragment to finish itself.
 *
 * @param caller The fragment that is asking to be finished.
 * @param resultCode Optional result code to send back to the original
 * launching fragment.
 * @param resultData Optional result data to send back to the original
 * launching fragment.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void finishPreferencePanel(android.app.Fragment caller, int resultCode, android.content.Intent resultData) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public boolean onPreferenceStartFragment(android.preference.PreferenceFragment caller, android.preference.Preference pref) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.preference.PreferenceManager PreferenceManager} used by this activity.
 * @return The {@link android.preference.PreferenceManager PreferenceManager}.
 *
 * @deprecated This function is not relevant for a modern fragment-based
 * PreferenceActivity.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public android.preference.PreferenceManager getPreferenceManager() { throw new RuntimeException("Stub!"); }

/**
 * Sets the root of the preference hierarchy that this activity is showing.
 *
 * @param preferenceScreen The root {@link android.preference.PreferenceScreen PreferenceScreen} of the preference hierarchy.
 *
 * @deprecated This function is not relevant for a modern fragment-based
 * PreferenceActivity.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setPreferenceScreen(android.preference.PreferenceScreen preferenceScreen) { throw new RuntimeException("Stub!"); }

/**
 * Gets the root of the preference hierarchy that this activity is showing.
 *
 * @return The {@link android.preference.PreferenceScreen PreferenceScreen} that is the root of the preference
 *         hierarchy.
 *
 * @deprecated This function is not relevant for a modern fragment-based
 * PreferenceActivity.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public android.preference.PreferenceScreen getPreferenceScreen() { throw new RuntimeException("Stub!"); }

/**
 * Adds preferences from activities that match the given {@link android.content.Intent Intent}.
 *
 * @param intent The {@link android.content.Intent Intent} to query activities.
 *
 * @deprecated This function is not relevant for a modern fragment-based
 * PreferenceActivity.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void addPreferencesFromIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Inflates the given XML resource and adds the preference hierarchy to the current
 * preference hierarchy.
 *
 * @param preferencesResId The XML resource ID to inflate.
 *
 * @deprecated This function is not relevant for a modern fragment-based
 * PreferenceActivity.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void addPreferencesFromResource(int preferencesResId) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @deprecated This function is not relevant for a modern fragment-based
 * PreferenceActivity.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean onPreferenceTreeClick(android.preference.PreferenceScreen preferenceScreen, android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Finds a {@link android.preference.Preference Preference} based on its key.
 *
 * @param key The key of the preference to retrieve.
 * @return The {@link android.preference.Preference Preference} with the key, or null.
 * @see android.preference.PreferenceGroup#findPreference(CharSequence)
 *
 * @deprecated This function is not relevant for a modern fragment-based
 * PreferenceActivity.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public android.preference.Preference findPreference(java.lang.CharSequence key) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onNewIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * When starting this activity, the invoking Intent can contain this extra
 * boolean that the header list should not be displayed.  This is most often
 * used in conjunction with {@link #EXTRA_SHOW_FRAGMENT} to launch
 * the activity to display a specific fragment that the user has navigated
 * to.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_NO_HEADERS = ":android:no_headers";

/**
 * When starting this activity, the invoking Intent can contain this extra
 * string to specify which fragment should be initially displayed.
 * <p/>Starting from Key Lime Pie, when this argument is passed in, the PreferenceActivity
 * will call isValidFragment() to confirm that the fragment class name is valid for this
 * activity.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";

/**
 * When starting this activity and using {@link #EXTRA_SHOW_FRAGMENT},
 * this extra can also be specified to supply a Bundle of arguments to pass
 * to that fragment when it is instantiated during the initial creation
 * of PreferenceActivity.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";

/**
 * When starting this activity and using {@link #EXTRA_SHOW_FRAGMENT},
 * this extra can also be specify to supply the short title to be shown for
 * that fragment.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_SHOW_FRAGMENT_SHORT_TITLE = ":android:show_fragment_short_title";

/**
 * When starting this activity and using {@link #EXTRA_SHOW_FRAGMENT},
 * this extra can also be specify to supply the title to be shown for
 * that fragment.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";

/**
 * Default value for {@link android.preference.PreferenceActivity.Header#id Header#id} indicating that no
 * identifier value is set.  All other values (including those below -1)
 * are valid.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public static final long HEADER_ID_UNDEFINED = -1L; // 0xffffffffffffffffL
/**
 * Description of a single Header item that the user can select.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices.
 *      For more information on using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 11
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Header implements android.os.Parcelable {

/** @apiSince 11 */

@Deprecated
public Header() { throw new RuntimeException("Stub!"); }

/**
 * Return the currently set title.  If {@link #titleRes} is set,
 * this resource is loaded from <var>res</var> and returned.  Otherwise
 * {@link #title} is returned.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getTitle(android.content.res.Resources res) { throw new RuntimeException("Stub!"); }

/**
 * Return the currently set summary.  If {@link #summaryRes} is set,
 * this resource is loaded from <var>res</var> and returned.  Otherwise
 * {@link #summary} is returned.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getSummary(android.content.res.Resources res) { throw new RuntimeException("Stub!"); }

/**
 * Return the currently set bread crumb title.  If {@link #breadCrumbTitleRes} is set,
 * this resource is loaded from <var>res</var> and returned.  Otherwise
 * {@link #breadCrumbTitle} is returned.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getBreadCrumbTitle(android.content.res.Resources res) { throw new RuntimeException("Stub!"); }

/**
 * Return the currently set bread crumb short title.  If
 * {@link #breadCrumbShortTitleRes} is set,
 * this resource is loaded from <var>res</var> and returned.  Otherwise
 * {@link #breadCrumbShortTitle} is returned.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getBreadCrumbShortTitle(android.content.res.Resources res) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void readFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.preference.PreferenceActivity.Header> CREATOR;
static { CREATOR = null; }

/**
 * Optional text to show as the short title in the bread crumb.
 * @attr ref android.R.styleable#PreferenceHeader_breadCrumbShortTitle
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence breadCrumbShortTitle;

/**
 * Resource ID of optional text to show as the short title in the bread crumb.
 * @attr ref android.R.styleable#PreferenceHeader_breadCrumbShortTitle
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public int breadCrumbShortTitleRes;

/**
 * Optional text to show as the title in the bread crumb.
 * @attr ref android.R.styleable#PreferenceHeader_breadCrumbTitle
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence breadCrumbTitle;

/**
 * Resource ID of optional text to show as the title in the bread crumb.
 * @attr ref android.R.styleable#PreferenceHeader_breadCrumbTitle
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public int breadCrumbTitleRes;

/**
 * Optional additional data for use by subclasses of PreferenceActivity.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public android.os.Bundle extras;

/**
 * Full class name of the fragment to display when this header is
 * selected.
 * @attr ref android.R.styleable#PreferenceHeader_fragment
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public java.lang.String fragment;

/**
 * Optional arguments to supply to the fragment when it is
 * instantiated.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public android.os.Bundle fragmentArguments;

/**
 * Optional icon resource to show for this header.
 * @attr ref android.R.styleable#PreferenceHeader_icon
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public int iconRes;

/**
 * Identifier for this header, to correlate with a new list when
 * it is updated.  The default value is
 * {@link android.preference.PreferenceActivity#HEADER_ID_UNDEFINED PreferenceActivity#HEADER_ID_UNDEFINED}, meaning no id.
 * @attr ref android.R.styleable#PreferenceHeader_id
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public long id = -1L; // 0xffffffffffffffffL

/**
 * Intent to launch when the preference is selected.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public android.content.Intent intent;

/**
 * Optional summary describing what this header controls.
 * @attr ref android.R.styleable#PreferenceHeader_summary
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence summary;

/**
 * Resource ID of optional summary describing what this header controls.
 * @attr ref android.R.styleable#PreferenceHeader_summary
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public int summaryRes;

/**
 * Title of the header that is shown to the user.
 * @attr ref android.R.styleable#PreferenceHeader_title
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence title;

/**
 * Resource ID of title of the header that is shown to the user.
 * @attr ref android.R.styleable#PreferenceHeader_title
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public int titleRes;
}

}

