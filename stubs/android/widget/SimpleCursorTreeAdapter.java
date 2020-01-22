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

import android.database.Cursor;
import android.view.View;
import android.net.Uri;

/**
 * An easy adapter to map columns from a cursor to TextViews or ImageViews
 * defined in an XML file. You can specify which columns you want, which views
 * you want to display the columns, and the XML file that defines the appearance
 * of these views. Separate XML files for child and groups are possible.
 *
 * Binding occurs in two phases. First, if a
 * {@link android.widget.SimpleCursorTreeAdapter.ViewBinder} is available,
 * {@link android.widget.SimpleCursorTreeAdapter.ViewBinder#setViewValue(android.view.View,android.database.Cursor,int) ViewBinder#setViewValue(android.view.View, android.database.Cursor, int)}
 * is invoked. If the returned value is true, binding has occurred. If the
 * returned value is false and the view to bind is a TextView,
 * {@link #setViewText(android.widget.TextView,java.lang.String)} is invoked. If the returned value
 * is false and the view to bind is an ImageView,
 * {@link #setViewImage(android.widget.ImageView,java.lang.String)} is invoked. If no appropriate
 * binding can be found, an {@link java.lang.IllegalStateException IllegalStateException} is thrown.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SimpleCursorTreeAdapter extends android.widget.ResourceCursorTreeAdapter {

/**
 * Constructor.
 *
 * @param context The context where the {@link android.widget.ExpandableListView ExpandableListView}
 *            associated with this {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter} is
 *            running
 * @param cursor The database cursor
 * @param collapsedGroupLayout The resource identifier of a layout file that
 *            defines the views for a collapsed group. The layout file
 *            should include at least those named views defined in groupTo.
 * @param expandedGroupLayout The resource identifier of a layout file that
 *            defines the views for an expanded group. The layout file
 *            should include at least those named views defined in groupTo.
 * @param groupFrom A list of column names that will be used to display the
 *            data for a group.
 * @param groupTo The group views (from the group layouts) that should
 *            display column in the "from" parameter. These should all be
 *            TextViews or ImageViews. The first N views in this list are
 *            given the values of the first N columns in the from parameter.
 * @param childLayout The resource identifier of a layout file that defines
 *            the views for a child (except the last). The layout file
 *            should include at least those named views defined in childTo.
 * @param lastChildLayout The resource identifier of a layout file that
 *            defines the views for the last child within a group. The
 *            layout file should include at least those named views defined
 *            in childTo.
 * @param childFrom A list of column names that will be used to display the
 *            data for a child.
 * @param childTo The child views (from the child layouts) that should
 *            display column in the "from" parameter. These should all be
 *            TextViews or ImageViews. The first N views in this list are
 *            given the values of the first N columns in the from parameter.
 * @apiSince 1
 */

public SimpleCursorTreeAdapter(android.content.Context context, android.database.Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, java.lang.String[] groupFrom, int[] groupTo, int childLayout, int lastChildLayout, java.lang.String[] childFrom, int[] childTo) { super((android.content.Context)null, (android.database.Cursor)null, 0, 0); throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param context The context where the {@link android.widget.ExpandableListView ExpandableListView}
 *            associated with this {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter} is
 *            running
 * @param cursor The database cursor
 * @param collapsedGroupLayout The resource identifier of a layout file that
 *            defines the views for a collapsed group. The layout file
 *            should include at least those named views defined in groupTo.
 * @param expandedGroupLayout The resource identifier of a layout file that
 *            defines the views for an expanded group. The layout file
 *            should include at least those named views defined in groupTo.
 * @param groupFrom A list of column names that will be used to display the
 *            data for a group.
 * @param groupTo The group views (from the group layouts) that should
 *            display column in the "from" parameter. These should all be
 *            TextViews or ImageViews. The first N views in this list are
 *            given the values of the first N columns in the from parameter.
 * @param childLayout The resource identifier of a layout file that defines
 *            the views for a child. The layout file
 *            should include at least those named views defined in childTo.
 * @param childFrom A list of column names that will be used to display the
 *            data for a child.
 * @param childTo The child views (from the child layouts) that should
 *            display column in the "from" parameter. These should all be
 *            TextViews or ImageViews. The first N views in this list are
 *            given the values of the first N columns in the from parameter.
 * @apiSince 1
 */

public SimpleCursorTreeAdapter(android.content.Context context, android.database.Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, java.lang.String[] groupFrom, int[] groupTo, int childLayout, java.lang.String[] childFrom, int[] childTo) { super((android.content.Context)null, (android.database.Cursor)null, 0, 0); throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param context The context where the {@link android.widget.ExpandableListView ExpandableListView}
 *            associated with this {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter} is
 *            running
 * @param cursor The database cursor
 * @param groupLayout The resource identifier of a layout file that defines
 *            the views for a group. The layout file should include at least
 *            those named views defined in groupTo.
 * @param groupFrom A list of column names that will be used to display the
 *            data for a group.
 * @param groupTo The group views (from the group layouts) that should
 *            display column in the "from" parameter. These should all be
 *            TextViews or ImageViews. The first N views in this list are
 *            given the values of the first N columns in the from parameter.
 * @param childLayout The resource identifier of a layout file that defines
 *            the views for a child. The layout file should include at least
 *            those named views defined in childTo.
 * @param childFrom A list of column names that will be used to display the
 *            data for a child.
 * @param childTo The child views (from the child layouts) that should
 *            display column in the "from" parameter. These should all be
 *            TextViews or ImageViews. The first N views in this list are
 *            given the values of the first N columns in the from parameter.
 * @apiSince 1
 */

public SimpleCursorTreeAdapter(android.content.Context context, android.database.Cursor cursor, int groupLayout, java.lang.String[] groupFrom, int[] groupTo, int childLayout, java.lang.String[] childFrom, int[] childTo) { super((android.content.Context)null, (android.database.Cursor)null, 0, 0); throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.widget.SimpleCursorTreeAdapter.ViewBinder ViewBinder} used to bind data to views.
 *
 * @return a ViewBinder or null if the binder does not exist
 *
 * @see #setViewBinder(android.widget.SimpleCursorTreeAdapter.ViewBinder)
 * @apiSince 5
 */

public android.widget.SimpleCursorTreeAdapter.ViewBinder getViewBinder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the binder used to bind data to views.
 *
 * @param viewBinder the binder used to bind data to views, can be null to
 *        remove the existing binder
 *
 * @see #getViewBinder()
 * @apiSince 5
 */

public void setViewBinder(android.widget.SimpleCursorTreeAdapter.ViewBinder viewBinder) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void bindChildView(android.view.View view, android.content.Context context, android.database.Cursor cursor, boolean isLastChild) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void bindGroupView(android.view.View view, android.content.Context context, android.database.Cursor cursor, boolean isExpanded) { throw new RuntimeException("Stub!"); }

/**
 * Called by bindView() to set the image for an ImageView. By default, the
 * value will be treated as a Uri. Intended to be overridden by Adapters
 * that need to filter strings retrieved from the database.
 *
 * @param v ImageView to receive an image
 * @param value the value retrieved from the cursor
 * @apiSince 1
 */

protected void setViewImage(android.widget.ImageView v, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Called by bindView() to set the text for a TextView but only if
 * there is no existing ViewBinder or if the existing ViewBinder cannot
 * handle binding to a TextView.
 *
 * Intended to be overridden by Adapters that need to filter strings
 * retrieved from the database.
 *
 * @param v TextView to receive text
 * @param text the text to be set for the TextView
 * @apiSince 5
 */

public void setViewText(android.widget.TextView v, java.lang.String text) { throw new RuntimeException("Stub!"); }
/**
 * This class can be used by external clients of SimpleCursorTreeAdapter
 * to bind values from the Cursor to views.
 *
 * You should use this class to bind values from the Cursor to views
 * that are not directly supported by SimpleCursorTreeAdapter or to
 * change the way binding occurs for views supported by
 * SimpleCursorTreeAdapter.
 *
 * @see android.widget.SimpleCursorTreeAdapter#setViewImage(ImageView, String)
 * @see android.widget.SimpleCursorTreeAdapter#setViewText(TextView, String)
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ViewBinder {

/**
 * Binds the Cursor column defined by the specified index to the specified view.
 *
 * When binding is handled by this ViewBinder, this method must return true.
 * If this method returns false, SimpleCursorTreeAdapter will attempts to handle
 * the binding on its own.
 *
 * @param view the view to bind the data to
 * @param cursor the cursor to get the data from
 * @param columnIndex the column at which the data can be found in the cursor
 *
 * @return true if the data was bound to the view, false otherwise
 * @apiSince 5
 */

public boolean setViewValue(android.view.View view, android.database.Cursor cursor, int columnIndex);
}

}

