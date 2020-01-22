/*
 * Copyright (C) 2015 The Android Open Source Project
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

package android.view;


/**
 * A group of {@link android.view.KeyboardShortcutInfo KeyboardShortcutInfo}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class KeyboardShortcutGroup implements android.os.Parcelable {

/**
 * @param label The title to be used for this group, or null if there is none.
 * This value may be {@code null}.
 * @param items The set of items to be included.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public KeyboardShortcutGroup(@androidx.annotation.Nullable java.lang.CharSequence label, @androidx.annotation.NonNull java.util.List<android.view.KeyboardShortcutInfo> items) { throw new RuntimeException("Stub!"); }

/**
 * @param label The title to be used for this group, or null if there is none.
 
 * This value may be {@code null}.
 * @apiSince 24
 */

public KeyboardShortcutGroup(@androidx.annotation.Nullable java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Returns the label to be used to describe this group.
 * @apiSince 24
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of items included in this group.
 * @apiSince 24
 */

public java.util.List<android.view.KeyboardShortcutInfo> getItems() { throw new RuntimeException("Stub!"); }

/**
 * Adds an item to the existing list.
 *
 * @param item The item to be added.
 * @apiSince 24
 */

public void addItem(android.view.KeyboardShortcutInfo item) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.KeyboardShortcutGroup> CREATOR;
static { CREATOR = null; }
}

