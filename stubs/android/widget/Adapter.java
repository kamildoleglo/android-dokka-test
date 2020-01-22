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

import android.view.View;
import android.view.ViewGroup;

/**
 * An Adapter object acts as a bridge between an {@link android.widget.AdapterView AdapterView} and the
 * underlying data for that view. The Adapter provides access to the data items.
 * The Adapter is also responsible for making a {@link android.view.View} for
 * each item in the data set.
 *
 * @see android.widget.ArrayAdapter
 * @see android.widget.CursorAdapter
 * @see android.widget.SimpleCursorAdapter
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Adapter {

/**
 * Register an observer that is called when changes happen to the data used by this adapter.
 *
 * @param observer the object that gets notified when the data set changes.
 * @apiSince 1
 */

public void registerDataSetObserver(android.database.DataSetObserver observer);

/**
 * Unregister an observer that has previously been registered with this
 * adapter via {@link #registerDataSetObserver}.
 *
 * @param observer the object to unregister.
 * @apiSince 1
 */

public void unregisterDataSetObserver(android.database.DataSetObserver observer);

/**
 * How many items are in the data set represented by this Adapter.
 *
 * @return Count of items.
 * @apiSince 1
 */

public int getCount();

/**
 * Get the data item associated with the specified position in the data set.
 *
 * @param position Position of the item whose data we want within the adapter's
 * data set.
 * @return The data at the specified position.
 * @apiSince 1
 */

public java.lang.Object getItem(int position);

/**
 * Get the row id associated with the specified position in the list.
 *
 * @param position The position of the item within the adapter's data set whose row id we want.
 * @return The id of the item at the specified position.
 * @apiSince 1
 */

public long getItemId(int position);

/**
 * Indicates whether the item ids are stable across changes to the
 * underlying data.
 *
 * @return True if the same id always refers to the same object.
 * @apiSince 1
 */

public boolean hasStableIds();

/**
 * Get a View that displays the data at the specified position in the data set. You can either
 * create a View manually or inflate it from an XML layout file. When the View is inflated, the
 * parent View (GridView, ListView...) will apply default layout parameters unless you use
 * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
 * to specify a root view and to prevent attachment to the root.
 *
 * @param position The position of the item within the adapter's data set of the item whose view
 *        we want.
 * @param convertView The old view to reuse, if possible. Note: You should check that this view
 *        is non-null and of an appropriate type before using. If it is not possible to convert
 *        this view to display the correct data, this method can create a new view.
 *        Heterogeneous lists can specify their number of view types, so that this View is
 *        always of the right type (see {@link #getViewTypeCount()} and
 *        {@link #getItemViewType(int)}).
 * @param parent The parent that this view will eventually be attached to
 * @return A View corresponding to the data at the specified position.
 * @apiSince 1
 */

public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent);

/**
 * Get the type of View that will be created by {@link #getView} for the specified item.
 *
 * @param position The position of the item within the adapter's data set whose view type we
 *        want.
 * @return An integer representing the type of View. Two views should share the same type if one
 *         can be converted to the other in {@link #getView}. Note: Integers must be in the
 *         range 0 to {@link #getViewTypeCount} - 1. {@link #IGNORE_ITEM_VIEW_TYPE} can
 *         also be returned.
 * @see #IGNORE_ITEM_VIEW_TYPE
 * @apiSince 1
 */

public int getItemViewType(int position);

/**
 * <p>
 * Returns the number of types of Views that will be created by
 * {@link #getView}. Each type represents a set of views that can be
 * converted in {@link #getView}. If the adapter always returns the same
 * type of View for all items, this method should return 1.
 * </p>
 * <p>
 * This method will only be called when the adapter is set on the {@link android.widget.AdapterView AdapterView}.
 * </p>
 *
 * @return The number of types of Views that will be created by this adapter
 * @apiSince 1
 */

public int getViewTypeCount();

/**
 * @return true if this adapter doesn't contain any data.  This is used to determine
 * whether the empty view should be displayed.  A typical implementation will return
 * getCount() == 0 but since getCount() includes the headers and footers, specialized
 * adapters might want a different behavior.
 * @apiSince 1
 */

public boolean isEmpty();

/**
 * Gets a string representation of the adapter data that can help
 * {@link android.service.autofill.AutofillService} autofill the view backed by the adapter.
 *
 * <p>
 * It should only be set (i.e., non-{@code null} if the values do not represent PII
 * (Personally Identifiable Information - sensitive data such as email addresses,
 * credit card numbers, passwords, etc...). For
 * example, it's ok to return a list of month names, but not a list of usernames. A good rule of
 * thumb is that if the adapter data comes from static resources, such data is not PII - see
 * {@link android.view.ViewStructure#setDataIsSensitive(boolean)} for more info.
 *
 * @return {@code null} by default, unless implementations override it.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public default java.lang.CharSequence[] getAutofillOptions() { throw new RuntimeException("Stub!"); }

/**
 * An item view type that causes the {@link android.widget.AdapterView AdapterView} to ignore the item
 * view. For example, this can be used if the client does not want a
 * particular view to be given for conversion in
 * {@link #getView(int,android.view.View,android.view.ViewGroup)}.
 *
 * @see #getItemViewType(int)
 * @see #getViewTypeCount()
 * @apiSince 1
 */

public static final int IGNORE_ITEM_VIEW_TYPE = -1; // 0xffffffff

/** @apiSince 1 */

public static final int NO_SELECTION = -2147483648; // 0x80000000
}

