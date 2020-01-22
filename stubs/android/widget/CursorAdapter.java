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
import android.content.Context;
import android.view.ViewGroup;
import android.content.res.Resources;
import android.view.View;
import android.database.ContentObserver;

/**
 * Adapter that exposes data from a {@link android.database.Cursor Cursor} to a
 * {@link android.widget.ListView ListView} widget.
 * <p>
 * The Cursor must include a column named "_id" or this class will not work.
 * Additionally, using {@link android.database.MergeCursor} with this class will
 * not work if the merged Cursors have overlapping values in their "_id"
 * columns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CursorAdapter extends android.widget.BaseAdapter implements android.widget.Filterable, android.widget.ThemedSpinnerAdapter {

/**
 * Constructor that always enables auto-requery.
 *
 * @deprecated This option is discouraged, as it results in Cursor queries
 * being performed on the application's UI thread and thus can cause poor
 * responsiveness or even Application Not Responding errors.  As an alternative,
 * use {@link android.app.LoaderManager} with a {@link android.content.CursorLoader}.
 *
 * @param c The cursor from which to get the data.
 * @param context The context
 * @apiSince 1
 */

@Deprecated
public CursorAdapter(android.content.Context context, android.database.Cursor c) { throw new RuntimeException("Stub!"); }

/**
 * Constructor that allows control over auto-requery.  It is recommended
 * you not use this, but instead {@link #CursorAdapter(android.content.Context,android.database.Cursor,int)}.
 * When using this constructor, {@link #FLAG_REGISTER_CONTENT_OBSERVER}
 * will always be set.
 *
 * @param c The cursor from which to get the data.
 * @param context The context
 * @param autoRequery If true the adapter will call requery() on the
 *                    cursor whenever it changes so the most recent
 *                    data is always displayed.  Using true here is discouraged.
 * @apiSince 1
 */

public CursorAdapter(android.content.Context context, android.database.Cursor c, boolean autoRequery) { throw new RuntimeException("Stub!"); }

/**
 * Recommended constructor.
 *
 * @param c The cursor from which to get the data.
 * @param context The context
 * @param flags Flags used to determine the behavior of the adapter; may
 * be any combination of {@link #FLAG_AUTO_REQUERY} and
 * {@link #FLAG_REGISTER_CONTENT_OBSERVER}.
 * @apiSince 11
 */

public CursorAdapter(android.content.Context context, android.database.Cursor c, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Don't use this, use the normal constructor.  This will
 * be removed in the future.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected void init(android.content.Context context, android.database.Cursor c, boolean autoRequery) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.content.res.Resources.Theme Resources.Theme} against which drop-down views are
 * inflated.
 * <p>
 * By default, drop-down views are inflated against the theme of the
 * {@link android.content.Context Context} passed to the adapter's constructor.
 *
 * @param theme the theme against which to inflate drop-down views or
 *              {@code null} to use the theme from the adapter's context
 * @see #newDropDownView(Context, Cursor, ViewGroup)
 * @apiSince 23
 */

public void setDropDownViewTheme(android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.content.res.Resources.Theme getDropDownViewTheme() { throw new RuntimeException("Stub!"); }

/**
 * Returns the cursor.
 * @return the cursor.
 * @apiSince 1
 */

public android.database.Cursor getCursor() { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.ListAdapter#getCount()
 * @apiSince 1
 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.ListAdapter#getItem(int)
 * @apiSince 1
 */

public java.lang.Object getItem(int position) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.ListAdapter#getItemId(int)
 * @apiSince 1
 */

public long getItemId(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean hasStableIds() { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.ListAdapter#getView(int, View, ViewGroup)
 * @apiSince 1
 */

public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View getDropDownView(int position, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Makes a new view to hold the data pointed to by cursor.
 * @param context Interface to application's global information
 * @param cursor The cursor from which to get the data. The cursor is already
 * moved to the correct position.
 * @param parent The parent to which the new view is attached to
 * @return the newly created view.
 * @apiSince 1
 */

public abstract android.view.View newView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup parent);

/**
 * Makes a new drop down view to hold the data pointed to by cursor.
 * @param context Interface to application's global information
 * @param cursor The cursor from which to get the data. The cursor is already
 * moved to the correct position.
 * @param parent The parent to which the new view is attached to
 * @return the newly created view.
 * @apiSince 1
 */

public android.view.View newDropDownView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Bind an existing view to the data pointed to by cursor
 * @param view Existing view, returned earlier by newView
 * @param context Interface to application's global information
 * @param cursor The cursor from which to get the data. The cursor is already
 * moved to the correct position.
 * @apiSince 1
 */

public abstract void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor);

/**
 * Change the underlying cursor to a new cursor. If there is an existing cursor it will be
 * closed.
 *
 * @param cursor The new cursor to be used
 * @apiSince 1
 */

public void changeCursor(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Swap in a new Cursor, returning the old Cursor.  Unlike
 * {@link #changeCursor(android.database.Cursor)}, the returned old Cursor is <em>not</em>
 * closed.
 *
 * @param newCursor The new cursor to be used.
 * @return Returns the previously set Cursor, or null if there was not one.
 * If the given new Cursor is the same instance is the previously set
 * Cursor, null is also returned.
 * @apiSince 11
 */

public android.database.Cursor swapCursor(android.database.Cursor newCursor) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the cursor into a CharSequence. Subclasses should override this
 * method to convert their results. The default implementation returns an
 * empty String for null values or the default String representation of
 * the value.</p>
 *
 * @param cursor the cursor to convert to a CharSequence
 * @return a CharSequence representing the value
 * @apiSince 1
 */

public java.lang.CharSequence convertToString(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Runs a query with the specified constraint. This query is requested
 * by the filter attached to this adapter.
 *
 * The query is provided by a
 * {@link android.widget.FilterQueryProvider}.
 * If no provider is specified, the current cursor is not filtered and returned.
 *
 * After this method returns the resulting cursor is passed to {@link #changeCursor(android.database.Cursor)}
 * and the previous cursor is closed.
 *
 * This method is always executed on a background thread, not on the
 * application's main thread (or UI thread.)
 *
 * Contract: when constraint is null or empty, the original results,
 * prior to any filtering, must be returned.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param constraint the constraint with which the query must be filtered
 *
 * @return a Cursor representing the results of the new query
 *
 * @see #getFilter()
 * @see #getFilterQueryProvider()
 * @see #setFilterQueryProvider(android.widget.FilterQueryProvider)
 * @apiSince 1
 */

public android.database.Cursor runQueryOnBackgroundThread(java.lang.CharSequence constraint) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.Filter getFilter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the query filter provider used for filtering. When the
 * provider is null, no filtering occurs.
 *
 * @return the current filter query provider or null if it does not exist
 *
 * @see #setFilterQueryProvider(android.widget.FilterQueryProvider)
 * @see #runQueryOnBackgroundThread(CharSequence)
 * @apiSince 1
 */

public android.widget.FilterQueryProvider getFilterQueryProvider() { throw new RuntimeException("Stub!"); }

/**
 * Sets the query filter provider used to filter the current Cursor.
 * The provider's
 * {@link android.widget.FilterQueryProvider#runQuery(CharSequence)}
 * method is invoked when filtering is requested by a client of
 * this adapter.
 *
 * @param filterQueryProvider the filter query provider or null to remove it
 *
 * @see #getFilterQueryProvider()
 * @see #runQueryOnBackgroundThread(CharSequence)
 * @apiSince 1
 */

public void setFilterQueryProvider(android.widget.FilterQueryProvider filterQueryProvider) { throw new RuntimeException("Stub!"); }

/**
 * Called when the {@link android.database.ContentObserver ContentObserver} on the cursor receives a change notification.
 * The default implementation provides the auto-requery logic, but may be overridden by
 * sub classes.
 *
 * @see android.database.ContentObserver#onChange(boolean)
 * @apiSince 3
 */

protected void onContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * If set the adapter will call requery() on the cursor whenever a content change
 * notification is delivered. Implies {@link #FLAG_REGISTER_CONTENT_OBSERVER}.
 *
 * @deprecated This option is discouraged, as it results in Cursor queries
 * being performed on the application's UI thread and thus can cause poor
 * responsiveness or even Application Not Responding errors.  As an alternative,
 * use {@link android.app.LoaderManager} with a {@link android.content.CursorLoader}.
 * @apiSince 11
 * @deprecatedSince 15
 */

@Deprecated public static final int FLAG_AUTO_REQUERY = 1; // 0x1

/**
 * If set the adapter will register a content observer on the cursor and will call
 * {@link #onContentChanged()} when a notification comes in.  Be careful when
 * using this flag: you will need to unset the current Cursor from the adapter
 * to avoid leaks due to its registered observers.  This flag is not needed
 * when using a CursorAdapter with a
 * {@link android.content.CursorLoader}.
 * @apiSince 11
 */

public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2; // 0x2
}

