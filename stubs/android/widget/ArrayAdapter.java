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

import android.view.ViewGroup;
import android.view.View;
import java.util.Collection;
import java.util.Comparator;
import android.content.Context;
import android.content.res.Resources;

/**
 * You can use this adapter to provide views for an {@link android.widget.AdapterView AdapterView},
 * Returns a view for each object in a collection of data objects you
 * provide, and can be used with list-based user interface widgets such as
 * {@link android.widget.ListView ListView} or {@link android.widget.Spinner Spinner}.
 * <p>
 * By default, the array adapter creates a view by calling {@link java.lang.Object#toString() Object#toString()} on each
 * data object in the collection you provide, and places the result in a TextView.
 * You may also customize what type of view is used for the data object in the collection.
 * To customize what type of view is used for the data object,
 * override {@link #getView(int,android.view.View,android.view.ViewGroup)}
 * and inflate a view resource.
 * For a code example, see
 * the <a href="https://github.com/googlesamples/android-CustomChoiceList/#readme">
 * CustomChoiceList</a> sample.
 * </p>
 * <p>
 * For an example of using an array adapter with a ListView, see the
 * <a href="{@docRoot}guide/topics/ui/declaring-layout.html#AdapterViews">
 * Adapter Views</a> guide.
 * </p>
 * <p>
 * For an example of using an array adapter with a Spinner, see the
 * <a href="{@docRoot}guide/topics/ui/controls/spinner.html">Spinners</a> guide.
 * </p>
 * <p class="note"><strong>Note:</strong>
 * If you are considering using array adapter with a ListView, consider using
 * {@link android.support.v7.widget.RecyclerView} instead.
 * RecyclerView offers similar features with better performance and more flexibility than
 * ListView provides.
 * See the
 * <a href="https://developer.android.com/guide/topics/ui/layout/recyclerview.html">
 * Recycler View</a> guide.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ArrayAdapter<T> extends android.widget.BaseAdapter implements android.widget.Filterable, android.widget.ThemedSpinnerAdapter {

/**
 * Constructor
 *
 * @param context The current context.
 * This value must never be {@code null}.
 * @param resource The resource ID for a layout file containing a TextView to use when
 *                 instantiating views.
 * @apiSince 1
 */

public ArrayAdapter(@androidx.annotation.NonNull android.content.Context context, int resource) { throw new RuntimeException("Stub!"); }

/**
 * Constructor
 *
 * @param context The current context.
 * This value must never be {@code null}.
 * @param resource The resource ID for a layout file containing a layout to use when
 *                 instantiating views.
 * @param textViewResourceId The id of the TextView within the layout resource to be populated
 * @apiSince 1
 */

public ArrayAdapter(@androidx.annotation.NonNull android.content.Context context, int resource, int textViewResourceId) { throw new RuntimeException("Stub!"); }

/**
 * Constructor. This constructor will result in the underlying data collection being
 * immutable, so methods such as {@link #clear()} will throw an exception.
 *
 * @param context The current context.
 * This value must never be {@code null}.
 * @param resource The resource ID for a layout file containing a TextView to use when
 *                 instantiating views.
 * @param objects The objects to represent in the ListView.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ArrayAdapter(@androidx.annotation.NonNull android.content.Context context, int resource, @androidx.annotation.NonNull T[] objects) { throw new RuntimeException("Stub!"); }

/**
 * Constructor. This constructor will result in the underlying data collection being
 * immutable, so methods such as {@link #clear()} will throw an exception.
 *
 * @param context The current context.
 * This value must never be {@code null}.
 * @param resource The resource ID for a layout file containing a layout to use when
 *                 instantiating views.
 * @param textViewResourceId The id of the TextView within the layout resource to be populated
 * @param objects The objects to represent in the ListView.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ArrayAdapter(@androidx.annotation.NonNull android.content.Context context, int resource, int textViewResourceId, @androidx.annotation.NonNull T[] objects) { throw new RuntimeException("Stub!"); }

/**
 * Constructor
 *
 * @param context The current context.
 * This value must never be {@code null}.
 * @param resource The resource ID for a layout file containing a TextView to use when
 *                 instantiating views.
 * @param objects The objects to represent in the ListView.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ArrayAdapter(@androidx.annotation.NonNull android.content.Context context, int resource, @androidx.annotation.NonNull java.util.List<T> objects) { throw new RuntimeException("Stub!"); }

/**
 * Constructor
 *
 * @param context The current context.
 * This value must never be {@code null}.
 * @param resource The resource ID for a layout file containing a layout to use when
 *                 instantiating views.
 * @param textViewResourceId The id of the TextView within the layout resource to be populated
 * @param objects The objects to represent in the ListView.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ArrayAdapter(@androidx.annotation.NonNull android.content.Context context, int resource, int textViewResourceId, @androidx.annotation.NonNull java.util.List<T> objects) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified object at the end of the array.
 *
 * @param object The object to add at the end of the array.
 * This value may be {@code null}.
 * @throws java.lang.UnsupportedOperationException if the underlying data collection is immutable
 * @apiSince 1
 */

public void add(@androidx.annotation.Nullable T object) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified Collection at the end of the array.
 *
 * @param collection The Collection to add at the end of the array.
 * This value must never be {@code null}.
 * @throws java.lang.UnsupportedOperationException if the <tt>addAll</tt> operation
 *         is not supported by this list
 * @throws java.lang.ClassCastException if the class of an element of the specified
 *         collection prevents it from being added to this list
 * @throws java.lang.NullPointerException if the specified collection contains one
 *         or more null elements and this list does not permit null
 *         elements, or if the specified collection is null
 * @throws java.lang.IllegalArgumentException if some property of an element of the
 *         specified collection prevents it from being added to this list
 * @apiSince 11
 */

public void addAll(@androidx.annotation.NonNull java.util.Collection<? extends T> collection) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified items at the end of the array.
 *
 * @param items The items to add at the end of the array.
 * @throws java.lang.UnsupportedOperationException if the underlying data collection is immutable
 * @apiSince 11
 */

public void addAll(T... items) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified object at the specified index in the array.
 *
 * @param object The object to insert into the array.
 * This value may be {@code null}.
 * @param index The index at which the object must be inserted.
 * @throws java.lang.UnsupportedOperationException if the underlying data collection is immutable
 * @apiSince 1
 */

public void insert(@androidx.annotation.Nullable T object, int index) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified object from the array.
 *
 * @param object The object to remove.
 * This value may be {@code null}.
 * @throws java.lang.UnsupportedOperationException if the underlying data collection is immutable
 * @apiSince 1
 */

public void remove(@androidx.annotation.Nullable T object) { throw new RuntimeException("Stub!"); }

/**
 * Remove all elements from the list.
 *
 * @throws java.lang.UnsupportedOperationException if the underlying data collection is immutable
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Sorts the content of this adapter using the specified comparator.
 *
 * @param comparator The comparator used to sort the objects contained
 *        in this adapter.
 
 * This value must never be {@code null}.
 * @apiSince 3
 */

public void sort(@androidx.annotation.NonNull java.util.Comparator<? super T> comparator) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void notifyDataSetChanged() { throw new RuntimeException("Stub!"); }

/**
 * Control whether methods that change the list ({@link #add}, {@link #addAll(java.util.Collection)},
 * {@link #addAll(java.lang.Object[])}, {@link #insert}, {@link #remove}, {@link #clear},
 * {@link #sort(java.util.Comparator)}) automatically call {@link #notifyDataSetChanged}.  If set to
 * false, caller must manually call notifyDataSetChanged() to have the changes
 * reflected in the attached view.
 *
 * The default is true, and calling notifyDataSetChanged()
 * resets the flag to true.
 *
 * @param notifyOnChange if true, modifications to the list will
 *                       automatically call {@link
 *                       #notifyDataSetChanged}
 * @apiSince 1
 */

public void setNotifyOnChange(boolean notifyOnChange) { throw new RuntimeException("Stub!"); }

/**
 * Returns the context associated with this array adapter. The context is used
 * to create views from the resource passed to the constructor.
 *
 * @return The Context associated with this adapter.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public T getItem(int position) { throw new RuntimeException("Stub!"); }

/**
 * Returns the position of the specified item in the array.
 *
 * @param item The item to retrieve the position of.
 *
 * This value may be {@code null}.
 * @return The position of the specified item.
 * @apiSince 1
 */

public int getPosition(@androidx.annotation.Nullable T item) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getItemId(int position) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param convertView This value may be {@code null}.
 * @param parent This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.view.View getView(int position, @androidx.annotation.Nullable android.view.View convertView, @androidx.annotation.NonNull android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the layout resource to create the drop down views.</p>
 *
 * @param resource the layout resource defining the drop down views
 * @see #getDropDownView(int, android.view.View, android.view.ViewGroup)
 * @apiSince 1
 */

public void setDropDownViewResource(int resource) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.content.res.Resources.Theme Resources.Theme} against which drop-down views are
 * inflated.
 * <p>
 * By default, drop-down views are inflated against the theme of the
 * {@link android.content.Context Context} passed to the adapter's constructor.
 *
 * @param theme the theme against which to inflate drop-down views or
 *              {@code null} to use the theme from the adapter's context
 * This value may be {@code null}.
 * @see #getDropDownView(int, View, ViewGroup)
 * @apiSince 23
 */

public void setDropDownViewTheme(@androidx.annotation.Nullable android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value may be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.content.res.Resources.Theme getDropDownViewTheme() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param convertView This value may be {@code null}.
 
 * @param parent This value must never be {@code null}.
 * @apiSince 1
 */

public android.view.View getDropDownView(int position, @androidx.annotation.Nullable android.view.View convertView, @androidx.annotation.NonNull android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new ArrayAdapter from external resources. The content of the array is
 * obtained through {@link android.content.res.Resources#getTextArray(int)}.
 *
 * @param context The application's environment.
 * This value must never be {@code null}.
 * @param textArrayResId The identifier of the array to use as the data source.
 * @param textViewResId The identifier of the layout used to create views.
 *
 * @return An ArrayAdapter<CharSequence>.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static android.widget.ArrayAdapter<java.lang.CharSequence> createFromResource(@androidx.annotation.NonNull android.content.Context context, int textArrayResId, int textViewResId) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.widget.Filter getFilter() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @return values from the string array used by {@link #createFromResource(android.content.Context,int,int)},
 * or {@code null} if object was created otherwsie or if contents were dynamically changed after
 * creation.
 * @apiSince 26
 */

public java.lang.CharSequence[] getAutofillOptions() { throw new RuntimeException("Stub!"); }
}

