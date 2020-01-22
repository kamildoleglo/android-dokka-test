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


/**
 * A container for multiple
 * {@link android.preference.Preference Preference} objects. It is a base class for  Preference objects that are
 * parents, such as {@link android.preference.PreferenceCategory PreferenceCategory} and {@link android.preference.PreferenceScreen PreferenceScreen}.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about building a settings UI with Preferences,
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 *
 * @attr ref android.R.styleable#PreferenceGroup_orderingFromXml
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
public abstract class PreferenceGroup extends android.preference.Preference {

/** @apiSince 21 */

@Deprecated
public PreferenceGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public PreferenceGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public PreferenceGroup(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Whether to order the {@link android.preference.Preference Preference} children of this group as they
 * are added. If this is false, the ordering will follow each Preference
 * order and default to alphabetic for those without an order.
 * <p>
 * If this is called after preferences are added, they will not be
 * re-ordered in the order they were added, hence call this method early on.
 *
 * @param orderingAsAdded Whether to order according to the order added.
 * @see android.preference.Preference#setOrder(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setOrderingAsAdded(boolean orderingAsAdded) { throw new RuntimeException("Stub!"); }

/**
 * Whether this group is ordering preferences in the order they are added.
 *
 * @return Whether this group orders based on the order the children are added.
 * @see #setOrderingAsAdded(boolean)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean isOrderingAsAdded() { throw new RuntimeException("Stub!"); }

/**
 * Called by the inflater to add an item to this group.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void addItemFromInflater(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of children {@link android.preference.Preference Preference}s.
 * @return The number of preference children in this group.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int getPreferenceCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.preference.Preference Preference} at a particular index.
 *
 * @param index The index of the {@link android.preference.Preference Preference} to retrieve.
 * @return The {@link android.preference.Preference Preference}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.Preference getPreference(int index) { throw new RuntimeException("Stub!"); }

/**
 * Adds a {@link android.preference.Preference Preference} at the correct position based on the
 * preference's order.
 *
 * @param preference The preference to add.
 * @return Whether the preference is now in this group.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean addPreference(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Removes a {@link android.preference.Preference Preference} from this group.
 *
 * @param preference The preference to remove.
 * @return Whether the preference was found and removed.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean removePreference(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Removes all {@link android.preference.Preference Preference} from this group.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void removeAll() { throw new RuntimeException("Stub!"); }

/**
 * Prepares a {@link android.preference.Preference Preference} to be added to the group.
 *
 * @param preference The preference to add.
 * @return Whether to allow adding the preference (true), or not (false).
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean onPrepareAddPreference(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Finds a {@link android.preference.Preference Preference} based on its key. If two {@link android.preference.Preference Preference}
 * share the same key (not recommended), the first to appear will be
 * returned (to retrieve the other preference with the same key, call this
 * method on the first preference). If this preference has the key, it will
 * not be returned.
 * <p>
 * This will recursively search for the preference into children that are
 * also {@link android.preference.PreferenceGroup PreferenceGroup}.
 *
 * @param key The key of the preference to retrieve.
 * @return The {@link android.preference.Preference Preference} with the key, or null.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.Preference findPreference(java.lang.CharSequence key) { throw new RuntimeException("Stub!"); }

/**
 * Whether this preference group should be shown on the same screen as its
 * contained preferences.
 *
 * @return True if the contained preferences should be shown on the same
 *         screen as this preference.
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
protected void onAttachedToActivity() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onPrepareForRemoval() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void notifyDependencyChange(boolean disableDependents) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void dispatchSaveInstanceState(android.os.Bundle container) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void dispatchRestoreInstanceState(android.os.Bundle container) { throw new RuntimeException("Stub!"); }
}

