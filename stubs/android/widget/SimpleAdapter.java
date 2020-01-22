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

import java.util.ArrayList;
import android.view.View;
import java.util.Map;
import java.util.List;
import android.view.ViewGroup;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

/**
 * An easy adapter to map static data to views defined in an XML file. You can specify the data
 * backing the list as an ArrayList of Maps. Each entry in the ArrayList corresponds to one row
 * in the list. The Maps contain the data for each row. You also specify an XML file that
 * defines the views used to display the row, and a mapping from keys in the Map to specific
 * views.
 *
 * Binding data to views occurs in two phases. First, if a
 * {@link android.widget.SimpleAdapter.ViewBinder} is available,
 * {@link android.widget.SimpleAdapter.ViewBinder#setViewValue(android.view.View,java.lang.Object,java.lang.String) ViewBinder#setViewValue(android.view.View, Object, String)}
 * is invoked. If the returned value is true, binding has occurred.
 * If the returned value is false, the following views are then tried in order:
 * <ul>
 * <li> A view that implements Checkable (e.g. CheckBox).  The expected bind value is a boolean.
 * <li> TextView.  The expected bind value is a string and {@link #setViewText(android.widget.TextView,java.lang.String)}
 * is invoked.
 * <li> ImageView. The expected bind value is a resource id or a string and
 * {@link #setViewImage(android.widget.ImageView,int)} or {@link #setViewImage(android.widget.ImageView,java.lang.String)} is invoked.
 * </ul>
 * If no appropriate binding can be found, an {@link java.lang.IllegalStateException IllegalStateException} is thrown.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SimpleAdapter extends android.widget.BaseAdapter implements android.widget.Filterable, android.widget.ThemedSpinnerAdapter {

/**
 * Constructor
 *
 * @param context The context where the View associated with this SimpleAdapter is running
 * @param data A List of Maps. Each entry in the List corresponds to one row in the list. The
 *        Maps contain the data for each row, and should include all the entries specified in
 *        "from"
 * @param resource Resource identifier of a view layout that defines the views for this list
 *        item. The layout file should include at least those named views defined in "to"
 * @param from A list of column names that will be added to the Map associated with each
 *        item.
 * @param to The views that should display column in the "from" parameter. These should all be
 *        TextViews. The first N views in this list are given the values of the first N columns
 *        in the from parameter.
 * @apiSince 1
 */

public SimpleAdapter(android.content.Context context, java.util.List<? extends java.util.Map<java.lang.String,?>> data, int resource, java.lang.String[] from, int[] to) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.Adapter#getCount()
 * @apiSince 1
 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.Adapter#getItem(int)
 * @apiSince 1
 */

public java.lang.Object getItem(int position) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.Adapter#getItemId(int)
 * @apiSince 1
 */

public long getItemId(int position) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.Adapter#getView(int, View, ViewGroup)
 * @apiSince 1
 */

public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the layout resource to create the drop down views.</p>
 *
 * @param resource the layout resource defining the drop down views
 * @see #getDropDownView(int, android.view.View, android.view.ViewGroup)
 * @apiSince 1
 */

public void setDropDownViewResource(int resource) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.content.res.Resources.Theme} against which drop-down views are
 * inflated.
 * <p>
 * By default, drop-down views are inflated against the theme of the
 * {@link android.content.Context Context} passed to the adapter's constructor.
 *
 * @param theme the theme against which to inflate drop-down views or
 *              {@code null} to use the theme from the adapter's context
 * @see #getDropDownView(int, View, ViewGroup)
 * @apiSince 23
 */

public void setDropDownViewTheme(android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.content.res.Resources.Theme getDropDownViewTheme() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View getDropDownView(int position, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.widget.SimpleAdapter.ViewBinder ViewBinder} used to bind data to views.
 *
 * @return a ViewBinder or null if the binder does not exist
 *
 * @see #setViewBinder(android.widget.SimpleAdapter.ViewBinder)
 * @apiSince 1
 */

public android.widget.SimpleAdapter.ViewBinder getViewBinder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the binder used to bind data to views.
 *
 * @param viewBinder the binder used to bind data to views, can be null to
 *        remove the existing binder
 *
 * @see #getViewBinder()
 * @apiSince 1
 */

public void setViewBinder(android.widget.SimpleAdapter.ViewBinder viewBinder) { throw new RuntimeException("Stub!"); }

/**
 * Called by bindView() to set the image for an ImageView but only if
 * there is no existing ViewBinder or if the existing ViewBinder cannot
 * handle binding to an ImageView.
 *
 * This method is called instead of {@link #setViewImage(android.widget.ImageView,java.lang.String)}
 * if the supplied data is an int or Integer.
 *
 * @param v ImageView to receive an image
 * @param value the value retrieved from the data set
 *
 * @see #setViewImage(ImageView, String)
 * @apiSince 1
 */

public void setViewImage(android.widget.ImageView v, int value) { throw new RuntimeException("Stub!"); }

/**
 * Called by bindView() to set the image for an ImageView but only if
 * there is no existing ViewBinder or if the existing ViewBinder cannot
 * handle binding to an ImageView.
 *
 * By default, the value will be treated as an image resource. If the
 * value cannot be used as an image resource, the value is used as an
 * image Uri.
 *
 * This method is called instead of {@link #setViewImage(android.widget.ImageView,int)}
 * if the supplied data is not an int or Integer.
 *
 * @param v ImageView to receive an image
 * @param value the value retrieved from the data set
 *
 * @see #setViewImage(ImageView, int)
 * @apiSince 1
 */

public void setViewImage(android.widget.ImageView v, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Called by bindView() to set the text for a TextView but only if
 * there is no existing ViewBinder or if the existing ViewBinder cannot
 * handle binding to a TextView.
 *
 * @param v TextView to receive text
 * @param text the text to be set for the TextView
 * @apiSince 1
 */

public void setViewText(android.widget.TextView v, java.lang.String text) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.Filter getFilter() { throw new RuntimeException("Stub!"); }
/**
 * This class can be used by external clients of SimpleAdapter to bind
 * values to views.
 *
 * You should use this class to bind values to views that are not
 * directly supported by SimpleAdapter or to change the way binding
 * occurs for views supported by SimpleAdapter.
 *
 * @see android.widget.SimpleAdapter#setViewImage(ImageView, int)
 * @see android.widget.SimpleAdapter#setViewImage(ImageView, String)
 * @see android.widget.SimpleAdapter#setViewText(TextView, String)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ViewBinder {

/**
 * Binds the specified data to the specified view.
 *
 * When binding is handled by this ViewBinder, this method must return true.
 * If this method returns false, SimpleAdapter will attempts to handle
 * the binding on its own.
 *
 * @param view the view to bind the data to
 * @param data the data to bind to the view
 * @param textRepresentation a safe String representation of the supplied data:
 *        it is either the result of data.toString() or an empty String but it
 *        is never null
 *
 * @return true if the data was bound to the view, false otherwise
 * @apiSince 1
 */

public boolean setViewValue(android.view.View view, java.lang.Object data, java.lang.String textRepresentation);
}

}

