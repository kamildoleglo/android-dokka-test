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

import android.content.Context;
import android.app.Dialog;
import android.widget.Adapter;
import android.widget.ListView;

/**
 * Represents a top-level {@link android.preference.Preference Preference} that
 * is the root of a Preference hierarchy. A {@link android.preference.PreferenceActivity PreferenceActivity}
 * points to an instance of this class to show the preferences. To instantiate
 * this class, use {@link android.preference.PreferenceManager#createPreferenceScreen(android.content.Context) PreferenceManager#createPreferenceScreen(Context)}.
 * <ul>
 * This class can appear in two places:
 * <li> When a {@link android.preference.PreferenceActivity PreferenceActivity} points to this, it is used as the root
 * and is not shown (only the contained preferences are shown).
 * <li> When it appears inside another preference hierarchy, it is shown and
 * serves as the gateway to another screen of preferences (either by showing
 * another screen of preferences as a {@link android.app.Dialog Dialog} or via a
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(android.content.Intent)} from the
 * {@link android.preference.Preference#getIntent() Preference#getIntent()}). The children of this {@link android.preference.PreferenceScreen PreferenceScreen}
 * are NOT shown in the screen that this {@link android.preference.PreferenceScreen PreferenceScreen} is shown in.
 * Instead, a separate screen will be shown when this preference is clicked.
 * </ul>
 * <p>Here's an example XML layout of a PreferenceScreen:</p>
 * <pre>
 &lt;PreferenceScreen
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:key="first_preferencescreen"&gt;
    &lt;CheckBoxPreference
            android:key="wifi enabled"
            android:title="WiFi" /&gt;
    &lt;PreferenceScreen
            android:key="second_preferencescreen"
            android:title="WiFi settings"&gt;
        &lt;CheckBoxPreference
                android:key="prefer wifi"
                android:title="Prefer WiFi" /&gt;
        ... other preferences here ...
    &lt;/PreferenceScreen&gt;
 &lt;/PreferenceScreen&gt; </pre>
 * <p>
 * In this example, the "first_preferencescreen" will be used as the root of the
 * hierarchy and given to a {@link android.preference.PreferenceActivity PreferenceActivity}. The first screen will
 * show preferences "WiFi" (which can be used to quickly enable/disable WiFi)
 * and "WiFi settings". The "WiFi settings" is the "second_preferencescreen" and when
 * clicked will show another screen of preferences such as "Prefer WiFi" (and
 * the other preferences that are children of the "second_preferencescreen" tag).
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about building a settings UI with Preferences,
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 *
 * @see android.preference.PreferenceCategory
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
public final class PreferenceScreen extends android.preference.PreferenceGroup implements android.widget.AdapterView.OnItemClickListener, android.content.DialogInterface.OnDismissListener {

PreferenceScreen() { super((android.content.Context)null, (android.util.AttributeSet)null); throw new RuntimeException("Stub!"); }

/**
 * Returns an adapter that can be attached to a {@link android.preference.PreferenceActivity PreferenceActivity}
 * or {@link android.preference.PreferenceFragment PreferenceFragment} to show the preferences contained in this
 * {@link android.preference.PreferenceScreen PreferenceScreen}.
 * <p>
 * This {@link android.preference.PreferenceScreen PreferenceScreen} will NOT appear in the returned adapter, instead
 * it appears in the hierarchy above this {@link android.preference.PreferenceScreen PreferenceScreen}.
 * <p>
 * This adapter's {@link android.widget.Adapter#getItem(int) Adapter#getItem(int)} should always return a
 * subclass of {@link android.preference.Preference Preference}.
 *
 * @return An adapter that provides the {@link android.preference.Preference Preference} contained in this
 *         {@link android.preference.PreferenceScreen PreferenceScreen}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.widget.ListAdapter getRootAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Creates the root adapter.
 *
 * @return An adapter that contains the preferences contained in this {@link android.preference.PreferenceScreen PreferenceScreen}.
 * @see #getRootAdapter()
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.widget.ListAdapter onCreateRootAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Binds a {@link android.widget.ListView ListView} to the preferences contained in this {@link android.preference.PreferenceScreen PreferenceScreen} via
 * {@link #getRootAdapter()}. It also handles passing list item clicks to the corresponding
 * {@link android.preference.Preference Preference} contained by this {@link android.preference.PreferenceScreen PreferenceScreen}.
 *
 * @param listView The list view to attach to.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void bind(android.widget.ListView listView) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onClick() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onDismiss(android.content.DialogInterface dialog) { throw new RuntimeException("Stub!"); }

/**
 * Used to get a handle to the dialog.
 * This is useful for cases where we want to manipulate the dialog
 * as we would with any other activity or view.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.app.Dialog getDialog() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onItemClick(android.widget.AdapterView parent, android.view.View view, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean isOnSameScreenAsChildren() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }
}

