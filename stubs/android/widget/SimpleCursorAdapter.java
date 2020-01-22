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
import android.content.Context;
import android.net.Uri;

/**
 * An easy adapter to map columns from a cursor to TextViews or ImageViews
 * defined in an XML file. You can specify which columns you want, which
 * views you want to display the columns, and the XML file that defines
 * the appearance of these views.
 *
 * Binding occurs in two phases. First, if a
 * {@link android.widget.SimpleCursorAdapter.ViewBinder} is available,
 * {@link android.widget.SimpleCursorAdapter.ViewBinder#setViewValue(android.view.View,android.database.Cursor,int) ViewBinder#setViewValue(android.view.View, android.database.Cursor, int)}
 * is invoked. If the returned value is true, binding has occured. If the
 * returned value is false and the view to bind is a TextView,
 * {@link #setViewText(android.widget.TextView,java.lang.String)} is invoked. If the returned value
 * is false and the view to bind is an ImageView,
 * {@link #setViewImage(android.widget.ImageView,java.lang.String)} is invoked. If no appropriate
 * binding can be found, an {@link java.lang.IllegalStateException IllegalStateException} is thrown.
 *
 * If this adapter is used with filtering, for instance in an
 * {@link android.widget.AutoCompleteTextView}, you can use the
 * {@link android.widget.SimpleCursorAdapter.CursorToStringConverter} and the
 * {@link android.widget.FilterQueryProvider} interfaces
 * to get control over the filtering process. You can refer to
 * {@link #convertToString(android.database.Cursor)} and
 * {@link #runQueryOnBackgroundThread(java.lang.CharSequence)} for more information.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SimpleCursorAdapter extends android.widget.ResourceCursorAdapter {

/**
 * Constructor the enables auto-requery.
 *
 * @deprecated This option is discouraged, as it results in Cursor queries
 * being performed on the application's UI thread and thus can cause poor
 * responsiveness or even Application Not Responding errors.  As an alternative,
 * use {@link android.app.LoaderManager} with a {@link android.content.CursorLoader}.
 * @apiSince 1
 */

@Deprecated
public SimpleCursorAdapter(android.content.Context context, int layout, android.database.Cursor c, java.lang.String[] from, int[] to) { super((android.content.Context)null, 0, (android.database.Cursor)null); throw new RuntimeException("Stub!"); }

/**
 * Standard constructor.
 *
 * @param context The context where the ListView associated with this
 *            SimpleListItemFactory is running
 * @param layout resource identifier of a layout file that defines the views
 *            for this list item. The layout file should include at least
 *            those named views defined in "to"
 * @param c The database cursor.  Can be null if the cursor is not available yet.
 * @param from A list of column names representing the data to bind to the UI.  Can be null
 *            if the cursor is not available yet.
 * @param to The views that should display column in the "from" parameter.
 *            These should all be TextViews. The first N views in this list
 *            are given the values of the first N columns in the from
 *            parameter.  Can be null if the cursor is not available yet.
 * @param flags Flags used to determine the behavior of the adapter,
 * as per {@link android.widget.CursorAdapter#CursorAdapter(android.content.Context,android.database.Cursor,int) CursorAdapter#CursorAdapter(Context, Cursor, int)}.
 * @apiSince 11
 */

public SimpleCursorAdapter(android.content.Context context, int layout, android.database.Cursor c, java.lang.String[] from, int[] to, int flags) { super((android.content.Context)null, 0, (android.database.Cursor)null); throw new RuntimeException("Stub!"); }

/**
 * Binds all of the field names passed into the "to" parameter of the
 * constructor with their corresponding cursor columns as specified in the
 * "from" parameter.
 *
 * Binding occurs in two phases. First, if a
 * {@link android.widget.SimpleCursorAdapter.ViewBinder} is available,
 * {@link android.widget.SimpleCursorAdapter.ViewBinder#setViewValue(android.view.View,android.database.Cursor,int) ViewBinder#setViewValue(android.view.View, android.database.Cursor, int)}
 * is invoked. If the returned value is true, binding has occured. If the
 * returned value is false and the view to bind is a TextView,
 * {@link #setViewText(android.widget.TextView,java.lang.String)} is invoked. If the returned value is
 * false and the view to bind is an ImageView,
 * {@link #setViewImage(android.widget.ImageView,java.lang.String)} is invoked. If no appropriate
 * binding can be found, an {@link java.lang.IllegalStateException IllegalStateException} is thrown.
 *
 * @throws java.lang.IllegalStateException if binding cannot occur
 *
 * @see android.widget.CursorAdapter#bindView(android.view.View,
 *      android.content.Context, android.database.Cursor)
 * @see #getViewBinder()
 * @see #setViewBinder(android.widget.SimpleCursorAdapter.ViewBinder)
 * @see #setViewImage(ImageView, String)
 * @see #setViewText(TextView, String)
 * @apiSince 1
 */

public void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.widget.SimpleCursorAdapter.ViewBinder ViewBinder} used to bind data to views.
 *
 * @return a ViewBinder or null if the binder does not exist
 *
 * @see #bindView(android.view.View, android.content.Context, android.database.Cursor)
 * @see #setViewBinder(android.widget.SimpleCursorAdapter.ViewBinder)
 * @apiSince 1
 */

public android.widget.SimpleCursorAdapter.ViewBinder getViewBinder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the binder used to bind data to views.
 *
 * @param viewBinder the binder used to bind data to views, can be null to
 *        remove the existing binder
 *
 * @see #bindView(android.view.View, android.content.Context, android.database.Cursor)
 * @see #getViewBinder()
 * @apiSince 1
 */

public void setViewBinder(android.widget.SimpleCursorAdapter.ViewBinder viewBinder) { throw new RuntimeException("Stub!"); }

/**
 * Called by bindView() to set the image for an ImageView but only if
 * there is no existing ViewBinder or if the existing ViewBinder cannot
 * handle binding to an ImageView.
 *
 * By default, the value will be treated as an image resource. If the
 * value cannot be used as an image resource, the value is used as an
 * image Uri.
 *
 * Intended to be overridden by Adapters that need to filter strings
 * retrieved from the database.
 *
 * @param v ImageView to receive an image
 * @param value the value retrieved from the cursor
 * @apiSince 1
 */

public void setViewImage(android.widget.ImageView v, java.lang.String value) { throw new RuntimeException("Stub!"); }

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
 * @apiSince 1
 */

public void setViewText(android.widget.TextView v, java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Return the index of the column used to get a String representation
 * of the Cursor.
 *
 * @return a valid index in the current Cursor or -1
 *
 * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
 * @see #setStringConversionColumn(int)
 * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter)
 * @see #getCursorToStringConverter()
 * @apiSince 1
 */

public int getStringConversionColumn() { throw new RuntimeException("Stub!"); }

/**
 * Defines the index of the column in the Cursor used to get a String
 * representation of that Cursor. The column is used to convert the
 * Cursor to a String only when the current CursorToStringConverter
 * is null.
 *
 * @param stringConversionColumn a valid index in the current Cursor or -1 to use the default
 *        conversion mechanism
 *
 * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
 * @see #getStringConversionColumn()
 * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter)
 * @see #getCursorToStringConverter()
 * @apiSince 1
 */

public void setStringConversionColumn(int stringConversionColumn) { throw new RuntimeException("Stub!"); }

/**
 * Returns the converter used to convert the filtering Cursor
 * into a String.
 *
 * @return null if the converter does not exist or an instance of
 *         {@link android.widget.SimpleCursorAdapter.CursorToStringConverter}
 *
 * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter)
 * @see #getStringConversionColumn()
 * @see #setStringConversionColumn(int)
 * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
 * @apiSince 1
 */

public android.widget.SimpleCursorAdapter.CursorToStringConverter getCursorToStringConverter() { throw new RuntimeException("Stub!"); }

/**
 * Sets the converter  used to convert the filtering Cursor
 * into a String.
 *
 * @param cursorToStringConverter the Cursor to String converter, or
 *        null to remove the converter
 *
 * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter)
 * @see #getStringConversionColumn()
 * @see #setStringConversionColumn(int)
 * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
 * @apiSince 1
 */

public void setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter cursorToStringConverter) { throw new RuntimeException("Stub!"); }

/**
 * Returns a CharSequence representation of the specified Cursor as defined
 * by the current CursorToStringConverter. If no CursorToStringConverter
 * has been set, the String conversion column is used instead. If the
 * conversion column is -1, the returned String is empty if the cursor
 * is null or Cursor.toString().
 *
 * @param cursor the Cursor to convert to a CharSequence
 *
 * @return a non-null CharSequence representing the cursor
 * @apiSince 1
 */

public java.lang.CharSequence convertToString(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.database.Cursor swapCursor(android.database.Cursor c) { throw new RuntimeException("Stub!"); }

/**
 * Change the cursor and change the column-to-view mappings at the same time.
 *
 * @param c The database cursor.  Can be null if the cursor is not available yet.
 * @param from A list of column names representing the data to bind to the UI.  Can be null
 *            if the cursor is not available yet.
 * @param to The views that should display column in the "from" parameter.
 *            These should all be TextViews. The first N views in this list
 *            are given the values of the first N columns in the from
 *            parameter.  Can be null if the cursor is not available yet.
 * @apiSince 3
 */

public void changeCursorAndColumns(android.database.Cursor c, java.lang.String[] from, int[] to) { throw new RuntimeException("Stub!"); }
/**
 * This class can be used by external clients of SimpleCursorAdapter
 * to define how the Cursor should be converted to a String.
 *
 * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface CursorToStringConverter {

/**
 * Returns a CharSequence representing the specified Cursor.
 *
 * @param cursor the cursor for which a CharSequence representation
 *        is requested
 *
 * @return a non-null CharSequence representing the cursor
 * @apiSince 1
 */

public java.lang.CharSequence convertToString(android.database.Cursor cursor);
}

/**
 * This class can be used by external clients of SimpleCursorAdapter
 * to bind values fom the Cursor to views.
 *
 * You should use this class to bind values from the Cursor to views
 * that are not directly supported by SimpleCursorAdapter or to
 * change the way binding occurs for views supported by
 * SimpleCursorAdapter.
 *
 * @see android.widget.SimpleCursorAdapter#bindView(android.view.View, android.content.Context, android.database.Cursor)
 * @see android.widget.SimpleCursorAdapter#setViewImage(ImageView, String)
 * @see android.widget.SimpleCursorAdapter#setViewText(TextView, String)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ViewBinder {

/**
 * Binds the Cursor column defined by the specified index to the specified view.
 *
 * When binding is handled by this ViewBinder, this method must return true.
 * If this method returns false, SimpleCursorAdapter will attempts to handle
 * the binding on its own.
 *
 * @param view the view to bind the data to
 * @param cursor the cursor to get the data from
 * @param columnIndex the column at which the data can be found in the cursor
 *
 * @return true if the data was bound to the view, false otherwise
 * @apiSince 1
 */

public boolean setViewValue(android.view.View view, android.database.Cursor cursor, int columnIndex);
}

}

