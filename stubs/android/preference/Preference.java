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

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ListView;
import android.content.Context;
import android.util.AttributeSet;
import android.content.res.TypedArray;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import java.util.Set;
import android.os.Parcelable;

/**
 * Represents the basic Preference UI building
 * block displayed by a {@link android.preference.PreferenceActivity PreferenceActivity} in the form of a
 * {@link android.widget.ListView ListView}. This class provides the {@link android.view.View View} to be displayed in
 * the activity and associates with a {@link android.content.SharedPreferences SharedPreferences} to
 * store/retrieve the preference data.
 * <p>
 * When specifying a preference hierarchy in XML, each element can point to a
 * subclass of {@link android.preference.Preference Preference}, similar to the view hierarchy and layouts.
 * <p>
 * This class contains a {@code key} that will be used as the key into the
 * {@link android.content.SharedPreferences SharedPreferences}. It is up to the subclass to decide how to store
 * the value.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about building a settings UI with Preferences,
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 *
 * @attr ref android.R.styleable#Preference_icon
 * @attr ref android.R.styleable#Preference_key
 * @attr ref android.R.styleable#Preference_title
 * @attr ref android.R.styleable#Preference_summary
 * @attr ref android.R.styleable#Preference_order
 * @attr ref android.R.styleable#Preference_fragment
 * @attr ref android.R.styleable#Preference_layout
 * @attr ref android.R.styleable#Preference_widgetLayout
 * @attr ref android.R.styleable#Preference_enabled
 * @attr ref android.R.styleable#Preference_selectable
 * @attr ref android.R.styleable#Preference_dependency
 * @attr ref android.R.styleable#Preference_persistent
 * @attr ref android.R.styleable#Preference_defaultValue
 * @attr ref android.R.styleable#Preference_shouldDisableView
 * @attr ref android.R.styleable#Preference_recycleEnabled
 * @attr ref android.R.styleable#Preference_singleLineTitle
 * @attr ref android.R.styleable#Preference_iconSpaceReserved
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
public class Preference implements java.lang.Comparable<android.preference.Preference> {

/**
 * Perform inflation from XML and apply a class-specific base style. This
 * constructor of Preference allows subclasses to use their own base style
 * when they are inflating. For example, a {@link android.preference.CheckBoxPreference CheckBoxPreference}
 * constructor calls this version of the super class constructor and
 * supplies {@code android.R.attr.checkBoxPreferenceStyle} for
 * <var>defStyleAttr</var>. This allows the theme's checkbox preference
 * style to modify all of the base preference attributes as well as the
 * {@link android.preference.CheckBoxPreference CheckBoxPreference} class's attributes.
 *
 * @param context The Context this is associated with, through which it can
 *            access the current theme, resources,
 *            {@link android.content.SharedPreferences SharedPreferences}, etc.
 * @param attrs The attributes of the XML tag that is inflating the
 *            preference.
 * @param defStyleAttr An attribute in the current theme that contains a
 *            reference to a style resource that supplies default values for
 *            the view. Can be 0 to not look for defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *            supplies default values for the view, used only if
 *            defStyleAttr is 0 or can not be found in the theme. Can be 0
 *            to not look for defaults.
 * @see #Preference(Context, AttributeSet)
 * @apiSince 21
 */

@Deprecated
public Preference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { throw new RuntimeException("Stub!"); }

/**
 * Perform inflation from XML and apply a class-specific base style. This
 * constructor of Preference allows subclasses to use their own base style
 * when they are inflating. For example, a {@link android.preference.CheckBoxPreference CheckBoxPreference}
 * constructor calls this version of the super class constructor and
 * supplies {@code android.R.attr.checkBoxPreferenceStyle} for
 * <var>defStyleAttr</var>. This allows the theme's checkbox preference
 * style to modify all of the base preference attributes as well as the
 * {@link android.preference.CheckBoxPreference CheckBoxPreference} class's attributes.
 *
 * @param context The Context this is associated with, through which it can
 *            access the current theme, resources,
 *            {@link android.content.SharedPreferences SharedPreferences}, etc.
 * @param attrs The attributes of the XML tag that is inflating the
 *            preference.
 * @param defStyleAttr An attribute in the current theme that contains a
 *            reference to a style resource that supplies default values for
 *            the view. Can be 0 to not look for defaults.
 * @see #Preference(Context, AttributeSet)
 * @apiSince 1
 */

@Deprecated
public Preference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { throw new RuntimeException("Stub!"); }

/**
 * Constructor that is called when inflating a Preference from XML. This is
 * called when a Preference is being constructed from an XML file, supplying
 * attributes that were specified in the XML file. This version uses a
 * default style of 0, so the only attribute values applied are those in the
 * Context's Theme and the given AttributeSet.
 *
 * @param context The Context this is associated with, through which it can
 *            access the current theme, resources, {@link android.content.SharedPreferences SharedPreferences},
 *            etc.
 * @param attrs The attributes of the XML tag that is inflating the
 *            preference.
 * @see #Preference(Context, AttributeSet, int)
 * @apiSince 1
 */

@Deprecated
public Preference(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Constructor to create a Preference.
 *
 * @param context The Context in which to store Preference values.
 * @apiSince 1
 */

@Deprecated
public Preference(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Called when a Preference is being inflated and the default value
 * attribute needs to be read. Since different Preference types have
 * different value types, the subclass should get and return the default
 * value which will be its value type.
 * <p>
 * For example, if the value type is String, the body of the method would
 * proxy to {@link android.content.res.TypedArray#getString(int) TypedArray#getString(int)}.
 *
 * @param a The set of attributes.
 * @param index The index of the default value attribute.
 * @return The default value of this preference type.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected java.lang.Object onGetDefaultValue(android.content.res.TypedArray a, int index) { throw new RuntimeException("Stub!"); }

/**
 * Sets an {@link android.content.Intent Intent} to be used for
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)} when this Preference is clicked.
 *
 * @param intent The intent associated with this Preference.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.content.Intent Intent} associated with this Preference.
 *
 * @return The {@link android.content.Intent Intent} last set via {@link #setIntent(android.content.Intent)} or XML.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.content.Intent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * Sets the class name of a fragment to be shown when this Preference is clicked.
 *
 * @param fragment The class name of the fragment associated with this Preference.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void setFragment(java.lang.String fragment) { throw new RuntimeException("Stub!"); }

/**
 * Return the fragment class name associated with this Preference.
 *
 * @return The fragment class name last set via {@link #setFragment} or XML.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getFragment() { throw new RuntimeException("Stub!"); }

/**
 * Sets a {@link android.preference.PreferenceDataStore PreferenceDataStore} to be used by this Preference instead of using
 * {@link android.content.SharedPreferences}.
 *
 * <p>The data store will remain assigned even if the Preference is moved around the preference
 * hierarchy. It will also override a data store propagated from the {@link android.preference.PreferenceManager PreferenceManager}
 * that owns this Preference.
 *
 * @param dataStore The {@link android.preference.PreferenceDataStore PreferenceDataStore} to be used by this Preference.
 * @see android.preference.PreferenceManager#setPreferenceDataStore(PreferenceDataStore)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void setPreferenceDataStore(android.preference.PreferenceDataStore dataStore) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@link android.preference.PreferenceDataStore PreferenceDataStore} used by this Preference. Returns {@code null} if
 * {@link android.content.SharedPreferences} is used instead.
 *
 * <p>By default preferences always use {@link android.content.SharedPreferences}. To make this
 * preference to use the {@link android.preference.PreferenceDataStore PreferenceDataStore} you need to assign your implementation
 * to the Preference itself via {@link #setPreferenceDataStore(android.preference.PreferenceDataStore)} or to its
 * {@link android.preference.PreferenceManager PreferenceManager} via
 * {@link android.preference.PreferenceManager#setPreferenceDataStore(android.preference.PreferenceDataStore) PreferenceManager#setPreferenceDataStore(PreferenceDataStore)}.
 *
 * @return The {@link android.preference.PreferenceDataStore PreferenceDataStore} used by this Preference or {@code null} if none.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public android.preference.PreferenceDataStore getPreferenceDataStore() { throw new RuntimeException("Stub!"); }

/**
 * Return the extras Bundle object associated with this preference, creating
 * a new Bundle if there currently isn't one.  You can use this to get and
 * set individual extra key/value pairs.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Return the extras Bundle object associated with this preference, returning {@code null} if
 * there is not currently one.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public android.os.Bundle peekExtras() { throw new RuntimeException("Stub!"); }

/**
 * Sets the layout resource that is inflated as the {@link android.view.View View} to be shown
 * for this Preference. In most cases, the default layout is sufficient for
 * custom Preference objects and only the widget layout needs to be changed.
 * <p>
 * This layout should contain a {@link android.view.ViewGroup ViewGroup} with ID
 * {@link android.R.id#widget_frame} to be the parent of the specific widget
 * for this Preference. It should similarly contain
 * {@link android.R.id#title} and {@link android.R.id#summary}.
 *
 * @param layoutResId The layout resource ID to be inflated and returned as
 *            a {@link android.view.View View}.
 * @see #setWidgetLayoutResource(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setLayoutResource(int layoutResId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the layout resource that will be shown as the {@link android.view.View View} for this Preference.
 *
 * @return The layout resource ID.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int getLayoutResource() { throw new RuntimeException("Stub!"); }

/**
 * Sets the layout for the controllable widget portion of this Preference. This
 * is inflated into the main layout. For example, a {@link android.preference.CheckBoxPreference CheckBoxPreference}
 * would specify a custom layout (consisting of just the CheckBox) here,
 * instead of creating its own main layout.
 *
 * @param widgetLayoutResId The layout resource ID to be inflated into the
 *            main layout.
 * @see #setLayoutResource(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setWidgetLayoutResource(int widgetLayoutResId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the layout resource for the controllable widget portion of this Preference.
 *
 * @return The layout resource ID.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int getWidgetLayoutResource() { throw new RuntimeException("Stub!"); }

/**
 * Gets the View that will be shown in the {@link android.preference.PreferenceActivity PreferenceActivity}.
 *
 * @param convertView The old View to reuse, if possible. Note: You should
 *            check that this View is non-null and of an appropriate type
 *            before using. If it is not possible to convert this View to
 *            display the correct data, this method can create a new View.
 * @param parent The parent that this View will eventually be attached to.
 * @return Returns the same Preference object, for chaining multiple calls
 *         into a single statement.
 * @see #onCreateView(ViewGroup)
 * @see #onBindView(View)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.view.View getView(android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Creates the View to be shown for this Preference in the
 * {@link android.preference.PreferenceActivity PreferenceActivity}. The default behavior is to inflate the main
 * layout of this Preference (see {@link #setLayoutResource(int)}. If
 * changing this behavior, please specify a {@link android.view.ViewGroup ViewGroup} with ID
 * {@link android.R.id#widget_frame}.
 * <p>
 * Make sure to call through to the superclass's implementation.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param parent The parent that this View will eventually be attached to.
 * @return The View that displays this Preference.
 * @see #onBindView(View)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.view.View onCreateView(android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Binds the created View to the data for this Preference.
 * <p>
 * This is a good place to grab references to custom Views in the layout and
 * set properties on them.
 * <p>
 * Make sure to call through to the superclass's implementation.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param view The View that shows this Preference.
 * @see #onCreateView(ViewGroup)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onBindView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Sets the order of this Preference with respect to other Preference objects on the same level.
 * If this is not specified, the default behavior is to sort alphabetically. The
 * {@link android.preference.PreferenceGroup#setOrderingAsAdded(boolean) PreferenceGroup#setOrderingAsAdded(boolean)} can be used to order Preference objects
 * based on the order they appear in the XML.
 *
 * @param order the order for this Preference. A lower value will be shown first. Use
 *              {@link #DEFAULT_ORDER} to sort alphabetically or allow ordering from XML
 * @see android.preference.PreferenceGroup#setOrderingAsAdded(boolean)
 * @see #DEFAULT_ORDER
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setOrder(int order) { throw new RuntimeException("Stub!"); }

/**
 * Gets the order of this Preference with respect to other Preference objects on the same level.
 *
 * @return the order of this Preference
 * @see #setOrder(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int getOrder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the title for this Preference with a CharSequence. This title will be placed into the ID
 * {@link android.R.id#title} within the View created by {@link #onCreateView(android.view.ViewGroup)}.
 *
 * @param title the title for this Preference
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Sets the title for this Preference with a resource ID.
 *
 * @see #setTitle(CharSequence)
 * @param titleResId the title as a resource ID
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setTitle(int titleResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the title resource ID of this Preference. If the title did not come from a resource,
 * {@code 0} is returned.
 *
 * @return the title resource
 * @see #setTitle(int)
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public int getTitleRes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the title of this Preference.
 *
 * @return the title
 * @see #setTitle(CharSequence)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon for this Preference with a Drawable. This icon will be placed into the ID
 * {@link android.R.id#icon} within the View created by {@link #onCreateView(android.view.ViewGroup)}.
 *
 * @param icon the optional icon for this Preference
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void setIcon(android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon for this Preference with a resource ID.
 *
 * @see #setIcon(Drawable)
 * @param iconResId the icon as a resource ID
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void setIcon(int iconResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the icon of this Preference.
 *
 * @return the icon
 * @see #setIcon(Drawable)
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public android.graphics.drawable.Drawable getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Returns the summary of this Preference.
 *
 * @return the summary
 * @see #setSummary(CharSequence)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getSummary() { throw new RuntimeException("Stub!"); }

/**
 * Sets the summary for this Preference with a CharSequence.
 *
 * @param summary the summary for the preference
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setSummary(java.lang.CharSequence summary) { throw new RuntimeException("Stub!"); }

/**
 * Sets the summary for this Preference with a resource ID.
 *
 * @see #setSummary(CharSequence)
 * @param summaryResId the summary as a resource
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setSummary(int summaryResId) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this Preference is enabled. If disabled, it will
 * not handle clicks.
 *
 * @param enabled set {@code true} to enable it
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this Preference should be enabled in the list.
 *
 * @return {@code true} if this Preference is enabled, false otherwise
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this Preference is selectable.
 *
 * @param selectable set {@code true} to make it selectable
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setSelectable(boolean selectable) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this Preference should be selectable in the list.
 *
 * @return {@code true} if it is selectable, {@code false} otherwise
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean isSelectable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this Preference should disable its view when it gets disabled.
 *
 * <p>For example, set this and {@link #setEnabled(boolean)} to false for preferences that are
 * only displaying information and 1) should not be clickable 2) should not have the view set to
 * the disabled state.
 *
 * @param shouldDisableView set {@code true} if this preference should disable its view when
 *                          the preference is disabled
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setShouldDisableView(boolean shouldDisableView) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this Preference should disable its view when it's action is disabled.
 *
 * @see #setShouldDisableView(boolean)
 * @return {@code true} if it should disable the view
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean getShouldDisableView() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this Preference has enabled to have its view recycled when used in the list
 * view. By default the recycling is enabled.
 *
 * <p>The value can be changed only before this preference is added to the preference hierarchy.
 *
 * <p>If view recycling is not allowed then each time the list view populates this preference
 * the {@link #getView(android.view.View,android.view.ViewGroup)} method receives a {@code null} convert view and needs
 * to recreate the view. Otherwise view gets recycled and only {@link #onBindView(android.view.View)} gets
 * called.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @param enabled set {@code true} if this preference view should be recycled
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void setRecycleEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this Preference has enabled to have its view recycled when used in the list
 * view.
 *
 * @see #setRecycleEnabled(boolean)
 * @return {@code true} if this preference view should be recycled
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public boolean isRecycleEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether to constrain the title of this Preference to a single line instead of
 * letting it wrap onto multiple lines.
 *
 * @param singleLineTitle set {@code true} if the title should be constrained to one line
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void setSingleLineTitle(boolean singleLineTitle) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the title of this preference is constrained to a single line.
 *
 * @see #setSingleLineTitle(boolean)
 * @return {@code true} if the title of this preference is constrained to a single line
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public boolean isSingleLineTitle() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether to reserve the space of this Preference icon view when no icon is provided.
 *
 * @param iconSpaceReserved set {@code true} if the space for the icon view should be reserved
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void setIconSpaceReserved(boolean iconSpaceReserved) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the space this preference icon view is reserved.
 *
 * @see #setIconSpaceReserved(boolean)
 * @return {@code true} if the space of this preference icon view is reserved
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public boolean isIconSpaceReserved() { throw new RuntimeException("Stub!"); }

/**
 * Processes a click on the preference. This includes saving the value to
 * the {@link android.content.SharedPreferences SharedPreferences}. However, the overridden method should
 * call {@link #callChangeListener(java.lang.Object)} to make sure the client wants to
 * update the preference's state with the new value.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onClick() { throw new RuntimeException("Stub!"); }

/**
 * Sets the key for this Preference, which is used as a key to the {@link android.content.SharedPreferences SharedPreferences} or
 * {@link android.preference.PreferenceDataStore PreferenceDataStore}. This should be unique for the package.
 *
 * @param key The key for the preference.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets the key for this Preference, which is also the key used for storing values into
 * {@link android.content.SharedPreferences SharedPreferences} or {@link android.preference.PreferenceDataStore PreferenceDataStore}.
 *
 * @return The key.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this Preference has a valid key.
 *
 * @return True if the key exists and is not a blank string, false otherwise.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean hasKey() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this Preference is persistent. If it is, it stores its value(s) into
 * the persistent {@link android.content.SharedPreferences SharedPreferences} storage by default or into
 * {@link android.preference.PreferenceDataStore PreferenceDataStore} if assigned.
 *
 * @return True if it is persistent.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean isPersistent() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether, at the given time this method is called, this Preference should store/restore
 * its value(s) into the {@link android.content.SharedPreferences SharedPreferences} or into {@link android.preference.PreferenceDataStore PreferenceDataStore} if
 * assigned. This, at minimum, checks whether this Preference is persistent and it currently has
 * a key. Before you save/restore from the storage, check this first.
 *
 * @return True if it should persist the value.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean shouldPersist() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this Preference is persistent. When persistent, it stores its value(s) into
 * the persistent {@link android.content.SharedPreferences SharedPreferences} storage by default or into
 * {@link android.preference.PreferenceDataStore PreferenceDataStore} if assigned.
 *
 * @param persistent set {@code true} if it should store its value(s) into the storage.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setPersistent(boolean persistent) { throw new RuntimeException("Stub!"); }

/**
 * Call this method after the user changes the preference, but before the
 * internal state is set. This allows the client to ignore the user value.
 *
 * @param newValue The new value of this Preference.
 * @return True if the user value should be set as the preference
 *         value (and persisted).
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean callChangeListener(java.lang.Object newValue) { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback to be invoked when this Preference is changed by the
 * user (but before the internal state has been updated).
 *
 * @param onPreferenceChangeListener The callback to be invoked.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setOnPreferenceChangeListener(android.preference.Preference.OnPreferenceChangeListener onPreferenceChangeListener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the callback to be invoked when this Preference is changed by the
 * user (but before the internal state has been updated).
 *
 * @return The callback to be invoked.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.Preference.OnPreferenceChangeListener getOnPreferenceChangeListener() { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback to be invoked when this Preference is clicked.
 *
 * @param onPreferenceClickListener The callback to be invoked.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setOnPreferenceClickListener(android.preference.Preference.OnPreferenceClickListener onPreferenceClickListener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the callback to be invoked when this Preference is clicked.
 *
 * @return The callback to be invoked.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.Preference.OnPreferenceClickListener getOnPreferenceClickListener() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.Context} of this Preference.
 * Each Preference in a Preference hierarchy can be
 * from different Context (for example, if multiple activities provide preferences into a single
 * {@link android.preference.PreferenceActivity PreferenceActivity}). This Context will be used to save the Preference values.
 *
 * @return The Context of this Preference.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.SharedPreferences SharedPreferences} where this Preference can read its
 * value(s). Usually, it's easier to use one of the helper read methods:
 * {@link #getPersistedBoolean(boolean)}, {@link #getPersistedFloat(float)},
 * {@link #getPersistedInt(int)}, {@link #getPersistedLong(long)},
 * {@link #getPersistedString(java.lang.String)}. To save values, see
 * {@link #getEditor()}.
 * <p>
 * In some cases, writes to the {@link #getEditor()} will not be committed
 * right away and hence not show up in the returned
 * {@link android.content.SharedPreferences SharedPreferences}, this is intended behavior to improve
 * performance.
 *
 * @return the {@link android.content.SharedPreferences SharedPreferences} where this Preference reads its value(s). If
 *         this preference isn't attached to a Preference hierarchy or if
 *         a {@link android.preference.PreferenceDataStore PreferenceDataStore} has been set, this method returns {@code null}.
 * @see #getEditor()
 * @see #setPreferenceDataStore(PreferenceDataStore)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.content.SharedPreferences getSharedPreferences() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link android.content.SharedPreferences.Editor SharedPreferences.Editor} where this Preference can
 * save its value(s). Usually it's easier to use one of the helper save
 * methods: {@link #persistBoolean(boolean)}, {@link #persistFloat(float)},
 * {@link #persistInt(int)}, {@link #persistLong(long)},
 * {@link #persistString(java.lang.String)}. To read values, see
 * {@link #getSharedPreferences()}. If {@link #shouldCommit()} returns
 * true, it is this Preference's responsibility to commit.
 * <p>
 * In some cases, writes to this will not be committed right away and hence
 * not show up in the SharedPreferences, this is intended behavior to
 * improve performance.
 *
 * @return a {@link android.content.SharedPreferences.Editor SharedPreferences.Editor} where this preference saves its value(s). If
 *         this preference isn't attached to a Preference hierarchy or if
 *         a {@link android.preference.PreferenceDataStore PreferenceDataStore} has been set, this method returns {@code null}.
 * @see #shouldCommit()
 * @see #getSharedPreferences()
 * @see #setPreferenceDataStore(PreferenceDataStore)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.content.SharedPreferences.Editor getEditor() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the {@link android.preference.Preference Preference} should commit its saved value(s) in
 * {@link #getEditor()}. This may return false in situations where batch
 * committing is being done (by the manager) to improve performance.
 *
 * <p>If this preference is using {@link android.preference.PreferenceDataStore PreferenceDataStore} this value is irrelevant.
 *
 * @return Whether the Preference should commit its saved value(s).
 * @see #getEditor()
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean shouldCommit() { throw new RuntimeException("Stub!"); }

/**
 * Compares Preference objects based on order (if set), otherwise alphabetically on the titles.
 *
 * @param another The Preference to compare to this one.
 * @return 0 if the same; less than 0 if this Preference sorts ahead of <var>another</var>;
 *          greater than 0 if this Preference sorts after <var>another</var>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int compareTo(android.preference.Preference another) { throw new RuntimeException("Stub!"); }

/**
 * Should be called when the data of this {@link android.preference.Preference Preference} has changed.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void notifyChanged() { throw new RuntimeException("Stub!"); }

/**
 * Should be called when a Preference has been
 * added/removed from this group, or the ordering should be
 * re-evaluated.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void notifyHierarchyChanged() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.preference.PreferenceManager PreferenceManager} that manages this Preference object's tree.
 *
 * @return The {@link android.preference.PreferenceManager PreferenceManager}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.PreferenceManager getPreferenceManager() { throw new RuntimeException("Stub!"); }

/**
 * Called when this Preference has been attached to a Preference hierarchy.
 * Make sure to call the super implementation.
 *
 * @param preferenceManager The PreferenceManager of the hierarchy.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onAttachedToHierarchy(android.preference.PreferenceManager preferenceManager) { throw new RuntimeException("Stub!"); }

/**
 * Called when the Preference hierarchy has been attached to the
 * {@link android.preference.PreferenceActivity PreferenceActivity}. This can also be called when this
 * Preference has been attached to a group that was already attached
 * to the {@link android.preference.PreferenceActivity PreferenceActivity}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onAttachedToActivity() { throw new RuntimeException("Stub!"); }

/**
 * Finds a Preference in this hierarchy (the whole thing,
 * even above/below your {@link android.preference.PreferenceScreen PreferenceScreen} screen break) with the given
 * key.
 * <p>
 * This only functions after we have been attached to a hierarchy.
 *
 * @param key The key of the Preference to find.
 * @return The Preference that uses the given key.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.preference.Preference findPreferenceInHierarchy(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Notifies any listening dependents of a change that affects the
 * dependency.
 *
 * @param disableDependents Whether this Preference should disable
 *            its dependents.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void notifyDependencyChange(boolean disableDependents) { throw new RuntimeException("Stub!"); }

/**
 * Called when the dependency changes.
 *
 * @param dependency The Preference that this Preference depends on.
 * @param disableDependent Set true to disable this Preference.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onDependencyChanged(android.preference.Preference dependency, boolean disableDependent) { throw new RuntimeException("Stub!"); }

/**
 * Called when the implicit parent dependency changes.
 *
 * @param parent The Preference that this Preference depends on.
 * @param disableChild Set true to disable this Preference.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public void onParentChanged(android.preference.Preference parent, boolean disableChild) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this preference's dependents should currently be
 * disabled.
 *
 * @return True if the dependents should be disabled, otherwise false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean shouldDisableDependents() { throw new RuntimeException("Stub!"); }

/**
 * Sets the key of a Preference that this Preference will depend on. If that
 * Preference is not set or is off, this Preference will be disabled.
 *
 * @param dependencyKey The key of the Preference that this depends on.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDependency(java.lang.String dependencyKey) { throw new RuntimeException("Stub!"); }

/**
 * Returns the key of the dependency on this Preference.
 *
 * @return The key of the dependency.
 * @see #setDependency(String)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getDependency() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.preference.PreferenceGroup PreferenceGroup} which is this Preference assigned to or {@code null} if
 * this preference is not assigned to any group or is a root Preference.
 *
 * @return the parent PreferenceGroup or {@code null} if not attached to any
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public android.preference.PreferenceGroup getParent() { throw new RuntimeException("Stub!"); }

/**
 * Called when this Preference is being removed from the hierarchy. You
 * should remove any references to this Preference that you know about. Make
 * sure to call through to the superclass implementation.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onPrepareForRemoval() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default value for this Preference, which will be set either if
 * persistence is off or persistence is on and the preference is not found
 * in the persistent storage.
 *
 * @param defaultValue The default value.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setDefaultValue(java.lang.Object defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to set the initial value of the Preference.
 *
 * <p>If <var>restorePersistedValue</var> is true, you should restore the
 * Preference value from the {@link android.content.SharedPreferences}. If
 * <var>restorePersistedValue</var> is false, you should set the Preference
 * value to defaultValue that is given (and possibly store to SharedPreferences
 * if {@link #shouldPersist()} is true).
 *
 * <p>In case of using {@link android.preference.PreferenceDataStore PreferenceDataStore}, the <var>restorePersistedValue</var> is
 * always {@code true}. But the default value (if provided) is set.
 *
 * <p>This may not always be called. One example is if it should not persist
 * but there is no default value given.
 *
 * @param restorePersistedValue True to restore the persisted value;
 *            false to use the given <var>defaultValue</var>.
 * @param defaultValue The default value for this Preference. Only use this
 *            if <var>restorePersistedValue</var> is false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onSetInitialValue(boolean restorePersistedValue, java.lang.Object defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to persist a String if this Preference is persistent.
 *
 * @param value The value to persist.
 * @return True if this Preference is persistent. (This is not whether the
 *         value was persisted, since we may not necessarily commit if there
 *         will be a batch commit later.)
 * @see #getPersistedString(String)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean persistString(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to get a persisted String if this Preference is persistent.
 *
 * @param defaultReturnValue The default value to return if either this
 *            Preference is not persistent or this Preference is not present.
 * @return The value from the data store or the default return
 *         value.
 * @see #persistString(String)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected java.lang.String getPersistedString(java.lang.String defaultReturnValue) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to persist a set of Strings if this Preference is persistent.
 *
 * @param values The values to persist.
 * @return True if this Preference is persistent. (This is not whether the
 *         value was persisted, since we may not necessarily commit if there
 *         will be a batch commit later.)
 * @see #getPersistedStringSet(Set)
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public boolean persistStringSet(java.util.Set<java.lang.String> values) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to get a persisted set of Strings if this Preference is persistent.
 *
 * @param defaultReturnValue The default value to return if either this
 *            Preference is not persistent or this Preference is not present.
 * @return The value from the data store or the default return
 *         value.
 * @see #persistStringSet(Set)
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public java.util.Set<java.lang.String> getPersistedStringSet(java.util.Set<java.lang.String> defaultReturnValue) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to persist an int if this Preference is persistent.
 *
 * @param value The value to persist.
 * @return True if this Preference is persistent. (This is not whether the
 *         value was persisted, since we may not necessarily commit if there
 *         will be a batch commit later.)
 * @see #persistString(String)
 * @see #getPersistedInt(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean persistInt(int value) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to get a persisted int if this Preference is persistent.
 *
 * @param defaultReturnValue The default value to return if either this
 *            Preference is not persistent or this Preference is not present.
 * @return The value from the data store or the default return
 *         value.
 * @see #getPersistedString(String)
 * @see #persistInt(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected int getPersistedInt(int defaultReturnValue) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to persist a long if this Preference is persistent.
 *
 * @param value The value to persist.
 * @return True if this Preference is persistent. (This is not whether the
 *         value was persisted, since we may not necessarily commit if there
 *         will be a batch commit later.)
 * @see #persistString(String)
 * @see #getPersistedFloat(float)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean persistFloat(float value) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to get a persisted float if this Preference is persistent.
 *
 * @param defaultReturnValue The default value to return if either this
 *            Preference is not persistent or this Preference is not present.
 * @return The value from the data store or the default return
 *         value.
 * @see #getPersistedString(String)
 * @see #persistFloat(float)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected float getPersistedFloat(float defaultReturnValue) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to persist a long if this Preference is persistent.
 *
 * @param value The value to persist.
 * @return True if this Preference is persistent. (This is not whether the
 *         value was persisted, since we may not necessarily commit if there
 *         will be a batch commit later.)
 * @see #persistString(String)
 * @see #getPersistedLong(long)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean persistLong(long value) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to get a persisted long if this Preference is persistent.
 *
 * @param defaultReturnValue The default value to return if either this
 *            Preference is not persistent or this Preference is not present.
 * @return The value from the data store or the default return
 *         value.
 * @see #getPersistedString(String)
 * @see #persistLong(long)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected long getPersistedLong(long defaultReturnValue) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to persist a boolean if this Preference is persistent.
 *
 * @param value The value to persist.
 * @return True if this Preference is persistent. (This is not whether the
 *         value was persisted, since we may not necessarily commit if there
 *         will be a batch commit later.)
 * @see #persistString(String)
 * @see #getPersistedBoolean(boolean)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean persistBoolean(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to get a persisted boolean if this Preference is persistent.
 *
 * @param defaultReturnValue The default value to return if either this
 *            Preference is not persistent or this Preference is not present.
 * @return The value from the data store or the default return
 *         value.
 * @see #getPersistedString(String)
 * @see #persistBoolean(boolean)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected boolean getPersistedBoolean(boolean defaultReturnValue) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Store this Preference hierarchy's frozen state into the given container.
 *
 * @param container The Bundle in which to save the instance of this Preference.
 *
 * @see #restoreHierarchyState
 * @see #onSaveInstanceState
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void saveHierarchyState(android.os.Bundle container) { throw new RuntimeException("Stub!"); }

/**
 * Hook allowing a Preference to generate a representation of its internal
 * state that can later be used to create a new instance with that same
 * state. This state should only contain information that is not persistent
 * or can be reconstructed later.
 *
 * @return A Parcelable object containing the current dynamic state of this Preference, or
 *         {@code null} if there is nothing interesting to save. The default implementation
 *         returns {@code null}.
 * @see #onRestoreInstanceState
 * @see #saveHierarchyState
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * Restore this Preference hierarchy's previously saved state from the given container.
 *
 * @param container The Bundle that holds the previously saved state.
 *
 * @see #saveHierarchyState
 * @see #onRestoreInstanceState
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void restoreHierarchyState(android.os.Bundle container) { throw new RuntimeException("Stub!"); }

/**
 * Hook allowing a Preference to re-apply a representation of its internal state that had
 * previously been generated by {@link #onSaveInstanceState}. This function will never be called
 * with a {@code null} state.
 *
 * @param state The saved state that had previously been returned by
 *            {@link #onSaveInstanceState}.
 * @see #onSaveInstanceState
 * @see #restoreHierarchyState
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/**
 * Specify for {@link #setOrder(int)} if a specific order is not required.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int DEFAULT_ORDER = 2147483647; // 0x7fffffff
/**
 * A base class for managing the instance state of a {@link android.preference.Preference Preference}.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices.
 *      For more information on using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class BaseSavedState extends android.view.AbsSavedState {

/** @apiSince 1 */

@Deprecated
public BaseSavedState(android.os.Parcel source) { super((android.os.Parcelable)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public BaseSavedState(android.os.Parcelable superState) { super((android.os.Parcelable)null); throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.preference.Preference.BaseSavedState> CREATOR;
static { CREATOR = null; }
}

/**
 * Interface definition for a callback to be invoked when the value of this
 * {@link android.preference.Preference Preference} has been changed by the user and is
 * about to be set and/or persisted.  This gives the client a chance
 * to prevent setting and/or persisting the value.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices.
 *      For more information on using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnPreferenceChangeListener {

/**
 * Called when a Preference has been changed by the user. This is
 * called before the state of the Preference is about to be updated and
 * before the state is persisted.
 *
 * @param preference The changed Preference.
 * @param newValue The new value of the Preference.
 * @return True to update the state of the Preference with the new value.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean onPreferenceChange(android.preference.Preference preference, java.lang.Object newValue);
}

/**
 * Interface definition for a callback to be invoked when a {@link android.preference.Preference Preference} is
 * clicked.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices.
 *      For more information on using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnPreferenceClickListener {

/**
 * Called when a Preference has been clicked.
 *
 * @param preference The Preference that was clicked.
 * @return True if the click was handled.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean onPreferenceClick(android.preference.Preference preference);
}

}

