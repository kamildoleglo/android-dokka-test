/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.content;


/**
 * Applications can expose restrictions for a restricted user on a
 * multiuser device. The administrator can configure these restrictions that will then be
 * applied to the restricted user. Each RestrictionsEntry is one configurable restriction.
 * <p/>
 * Any application that chooses to expose such restrictions does so by implementing a
 * receiver that handles the {@link android.content.Intent#ACTION_GET_RESTRICTION_ENTRIES Intent#ACTION_GET_RESTRICTION_ENTRIES} action.
 * The receiver then returns a result bundle that contains an entry called "restrictions", whose
 * value is an ArrayList<RestrictionsEntry>.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RestrictionEntry implements android.os.Parcelable {

/**
 * Constructor for specifying the type and key, with no initial value;
 *
 * @param type the restriction type.
 * @param key the unique key for this restriction
 * @apiSince 21
 */

public RestrictionEntry(int type, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Constructor for {@link #TYPE_CHOICE} type.
 * @param key the unique key for this restriction
 * @param selectedString the current value
 * @apiSince 18
 */

public RestrictionEntry(java.lang.String key, java.lang.String selectedString) { throw new RuntimeException("Stub!"); }

/**
 * Constructor for {@link #TYPE_BOOLEAN} type.
 * @param key the unique key for this restriction
 * @param selectedState whether this restriction is selected or not
 * @apiSince 18
 */

public RestrictionEntry(java.lang.String key, boolean selectedState) { throw new RuntimeException("Stub!"); }

/**
 * Constructor for {@link #TYPE_MULTI_SELECT} type.
 * @param key the unique key for this restriction
 * @param selectedStrings the list of values that are currently selected
 * @apiSince 18
 */

public RestrictionEntry(java.lang.String key, java.lang.String[] selectedStrings) { throw new RuntimeException("Stub!"); }

/**
 * Constructor for {@link #TYPE_INTEGER} type.
 * @param key the unique key for this restriction
 * @param selectedInt the integer value of the restriction
 * @apiSince 21
 */

public RestrictionEntry(java.lang.String key, int selectedInt) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public RestrictionEntry(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Creates an entry of type {@link #TYPE_BUNDLE}.
 * @param key the unique key for this restriction
 * @param restrictionEntries array of nested restriction entries.
 * @return the newly created restriction
 * @apiSince 23
 */

public static android.content.RestrictionEntry createBundleEntry(java.lang.String key, android.content.RestrictionEntry[] restrictionEntries) { throw new RuntimeException("Stub!"); }

/**
 * Creates an entry of type {@link #TYPE_BUNDLE_ARRAY}.
 * @param key the unique key for this restriction
 * @param restrictionEntries array of nested restriction entries. The array may only contain
 * elements of type {@link #TYPE_BUNDLE bundle}.
 * @return the newly created restriction
 * @apiSince 23
 */

public static android.content.RestrictionEntry createBundleArrayEntry(java.lang.String key, android.content.RestrictionEntry[] restrictionEntries) { throw new RuntimeException("Stub!"); }

/**
 * Sets the type for this restriction.
 * @param type the type for this restriction.
 * @apiSince 18
 */

public void setType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type for this restriction.
 * @return the type for this restriction
 * @apiSince 18
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the currently selected string value.
 * @return the currently selected value, which can be null for types that aren't for holding
 * single string values.
 * @apiSince 18
 */

public java.lang.String getSelectedString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of currently selected values.
 * @return the list of current selections, if type is {@link #TYPE_MULTI_SELECT},
 *  null otherwise.
 * @apiSince 18
 */

public java.lang.String[] getAllSelectedStrings() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current selected state for an entry of type {@link #TYPE_BOOLEAN}.
 * @return the current selected state of the entry.
 * @apiSince 18
 */

public boolean getSelectedState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the entry as an integer when the type is {@link #TYPE_INTEGER}.
 * @return the integer value of the entry.
 * @apiSince 21
 */

public int getIntValue() { throw new RuntimeException("Stub!"); }

/**
 * Sets the integer value of the entry when the type is {@link #TYPE_INTEGER}.
 * @param value the integer value to set.
 * @apiSince 21
 */

public void setIntValue(int value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the string value to use as the selected value for this restriction. This value will
 * be persisted by the system for later use by the application.
 * @param selectedString the string value to select.
 * @apiSince 18
 */

public void setSelectedString(java.lang.String selectedString) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current selected state for an entry of type {@link #TYPE_BOOLEAN}. This value will
 * be persisted by the system for later use by the application.
 * @param state the current selected state
 * @apiSince 18
 */

public void setSelectedState(boolean state) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current list of selected values for an entry of type {@link #TYPE_MULTI_SELECT}.
 * These values will be persisted by the system for later use by the application.
 * @param allSelectedStrings the current list of selected values.
 * @apiSince 18
 */

public void setAllSelectedStrings(java.lang.String[] allSelectedStrings) { throw new RuntimeException("Stub!"); }

/**
 * Sets a list of string values that can be selected by the user. If no user-visible entries
 * are set by a call to {@link #setChoiceEntries(java.lang.String[])}, these values will be the ones
 * shown to the user. Values will be chosen from this list as the user's selection and the
 * selected values can be retrieved by a call to {@link #getAllSelectedStrings()}, or
 * {@link #getSelectedString()}, depending on whether it is a multi-select type or choice type.
 * This method is not relevant for types other than
 * {@link #TYPE_CHOICE}, and {@link #TYPE_MULTI_SELECT}.
 * @param choiceValues an array of Strings which will be the selected values for the user's
 * selections.
 * @see #getChoiceValues()
 * @see #getAllSelectedStrings()
 * @apiSince 18
 */

public void setChoiceValues(java.lang.String[] choiceValues) { throw new RuntimeException("Stub!"); }

/**
 * Sets a list of string values that can be selected by the user, similar to
 * {@link #setChoiceValues(java.lang.String[])}.
 * @param context the application context for retrieving the resources.
 * @param stringArrayResId the resource id for a string array containing the possible values.
 * @see #setChoiceValues(String[])
 * @apiSince 18
 */

public void setChoiceValues(android.content.Context context, int stringArrayResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns array of possible restriction entries that this entry may contain.
 * @apiSince 23
 */

public android.content.RestrictionEntry[] getRestrictions() { throw new RuntimeException("Stub!"); }

/**
 * Sets an array of possible restriction entries, that this entry may contain.
 * <p>This method is only relevant for types {@link #TYPE_BUNDLE} and
 * {@link #TYPE_BUNDLE_ARRAY}
 * @apiSince 23
 */

public void setRestrictions(android.content.RestrictionEntry[] restrictions) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of possible string values set earlier.
 * @return the list of possible values.
 * @apiSince 18
 */

public java.lang.String[] getChoiceValues() { throw new RuntimeException("Stub!"); }

/**
 * Sets a list of strings that will be presented as choices to the user. When the
 * user selects one or more of these choices, the corresponding value from the possible values
 * are stored as the selected strings. The size of this array must match the size of the array
 * set in {@link #setChoiceValues(java.lang.String[])}. This method is not relevant for types other
 * than {@link #TYPE_CHOICE}, and {@link #TYPE_MULTI_SELECT}.
 * @param choiceEntries the list of user-visible choices.
 * @see #setChoiceValues(String[])
 * @apiSince 18
 */

public void setChoiceEntries(java.lang.String[] choiceEntries) { throw new RuntimeException("Stub!"); }

/** Sets a list of strings that will be presented as choices to the user. This is similar to
 * {@link #setChoiceEntries(java.lang.String[])}.
 * @param context the application context, used for retrieving the resources.
 * @param stringArrayResId the resource id of a string array containing the possible entries.
 * @apiSince 18
 */

public void setChoiceEntries(android.content.Context context, int stringArrayResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of strings, set earlier, that will be presented as choices to the user.
 * @return the list of choices presented to the user.
 * @apiSince 18
 */

public java.lang.String[] getChoiceEntries() { throw new RuntimeException("Stub!"); }

/**
 * Returns the provided user-visible description of the entry, if any.
 * @return the user-visible description, null if none was set earlier.
 * @apiSince 18
 */

public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Sets the user-visible description of the entry, as a possible sub-text for the title.
 * You can use this to describe the entry in more detail or to display the current state of
 * the restriction.
 * @param description the user-visible description string.
 * @apiSince 18
 */

public void setDescription(java.lang.String description) { throw new RuntimeException("Stub!"); }

/**
 * This is the unique key for the restriction entry.
 * @return the key for the restriction.
 * @apiSince 18
 */

public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user-visible title for the entry, if any.
 * @return the user-visible title for the entry, null if none was set earlier.
 * @apiSince 18
 */

public java.lang.String getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Sets the user-visible title for the entry.
 * @param title the user-visible title for the entry.
 * @apiSince 18
 */

public void setTitle(java.lang.String title) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.RestrictionEntry> CREATOR;
static { CREATOR = null; }

/**
 * Restriction of type "bool". Use this for storing a boolean value, typically presented as
 * a checkbox in the UI.
 * @apiSince 18
 */

public static final int TYPE_BOOLEAN = 1; // 0x1

/**
 * Restriction of type "bundle". Use this for storing {@link android.os.Bundle bundles} of
 * restrictions
 * @apiSince 23
 */

public static final int TYPE_BUNDLE = 7; // 0x7

/**
 * Restriction of type "bundle_array". Use this for storing arrays of
 * {@link android.os.Bundle bundles} of restrictions
 * @apiSince 23
 */

public static final int TYPE_BUNDLE_ARRAY = 8; // 0x8

/**
 * Restriction of type "choice". Use this for storing a string value, typically presented as
 * a single-select list. Call {@link #setChoiceEntries(java.lang.String[])} and
 * {@link #setChoiceValues(java.lang.String[])} to set the localized list entries to present to the user
 * and the corresponding values, respectively.
 * @apiSince 18
 */

public static final int TYPE_CHOICE = 2; // 0x2

/**
 * Restriction of type "integer". Use this for storing an integer value. The range of values
 * is from {@link java.lang.Integer#MIN_VALUE Integer#MIN_VALUE} to {@link java.lang.Integer#MAX_VALUE Integer#MAX_VALUE}.
 * @apiSince 21
 */

public static final int TYPE_INTEGER = 5; // 0x5

/**
 * Restriction of type "multi-select". Use this for presenting a multi-select list where more
 * than one entry can be selected, such as for choosing specific titles to white-list.
 * Call {@link #setChoiceEntries(java.lang.String[])} and
 * {@link #setChoiceValues(java.lang.String[])} to set the localized list entries to present to the user
 * and the corresponding values, respectively.
 * Use {@link #getAllSelectedStrings()} and {@link #setAllSelectedStrings(java.lang.String[])} to
 * manipulate the selections.
 * @apiSince 18
 */

public static final int TYPE_MULTI_SELECT = 4; // 0x4

/**
 * Hidden restriction type. Use this type for information that needs to be transferred
 * across but shouldn't be presented to the user in the UI. Stores a single String value.
 * @apiSince 18
 */

public static final int TYPE_NULL = 0; // 0x0

/**
 * Restriction of type "string". Use this for storing a string value.
 * @see #setSelectedString
 * @see #getSelectedString
 * @apiSince 21
 */

public static final int TYPE_STRING = 6; // 0x6
}

