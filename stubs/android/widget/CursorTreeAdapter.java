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


package android.widget;

import android.database.Cursor;
import android.app.Activity;

/**
 * An adapter that exposes data from a series of {@link android.database.Cursor Cursor}s to an
 * {@link android.widget.ExpandableListView ExpandableListView} widget. The top-level {@link android.database.Cursor Cursor} (that is
 * given in the constructor) exposes the groups, while subsequent {@link android.database.Cursor Cursor}s
 * returned from {@link #getChildrenCursor(android.database.Cursor)} expose children within a
 * particular group. The Cursors must include a column named "_id" or this class
 * will not work.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CursorTreeAdapter extends android.widget.BaseExpandableListAdapter implements android.widget.Filterable {

/**
 * Constructor. The adapter will call {@link android.database.Cursor#requery() Cursor#requery()} on the cursor whenever
 * it changes so that the most recent data is always displayed.
 *
 * @param cursor The cursor from which to get the data for the groups.
 * @apiSince 1
 */

public CursorTreeAdapter(android.database.Cursor cursor, android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param cursor The cursor from which to get the data for the groups.
 * @param context The context
 * @param autoRequery If true the adapter will call {@link android.database.Cursor#requery() Cursor#requery()}
 *        on the cursor whenever it changes so the most recent data is
 *        always displayed.
 * @apiSince 1
 */

public CursorTreeAdapter(android.database.Cursor cursor, android.content.Context context, boolean autoRequery) { throw new RuntimeException("Stub!"); }

/**
 * Gets the Cursor for the children at the given group. Subclasses must
 * implement this method to return the children data for a particular group.
 * <p>
 * If you want to asynchronously query a provider to prevent blocking the
 * UI, it is possible to return null and at a later time call
 * {@link #setChildrenCursor(int,android.database.Cursor)}.
 * <p>
 * It is your responsibility to manage this Cursor through the Activity
 * lifecycle. It is a good idea to use {@link android.app.Activity#managedQuery Activity#managedQuery} which
 * will handle this for you. In some situations, the adapter will deactivate
 * the Cursor on its own, but this will not always be the case, so please
 * ensure the Cursor is properly managed.
 *
 * @param groupCursor The cursor pointing to the group whose children cursor
 *            should be returned
 * @return The cursor for the children of a particular group, or null.
 * @apiSince 1
 */

protected abstract android.database.Cursor getChildrenCursor(android.database.Cursor groupCursor);

/**
 * Sets the group Cursor.
 *
 * @param cursor The Cursor to set for the group. If there is an existing cursor
 * it will be closed.
 * @apiSince 1
 */

public void setGroupCursor(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Sets the children Cursor for a particular group. If there is an existing cursor
 * it will be closed.
 * <p>
 * This is useful when asynchronously querying to prevent blocking the UI.
 *
 * @param groupPosition The group whose children are being set via this Cursor.
 * @param childrenCursor The Cursor that contains the children of the group.
 * @apiSince 1
 */

public void setChildrenCursor(int groupPosition, android.database.Cursor childrenCursor) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.database.Cursor getChild(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getChildId(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getChildrenCount(int groupPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.database.Cursor getGroup(int groupPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getGroupCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getGroupId(int groupPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View getGroupView(int groupPosition, boolean isExpanded, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Makes a new group view to hold the group data pointed to by cursor.
 *
 * @param context Interface to application's global information
 * @param cursor The group cursor from which to get the data. The cursor is
 *            already moved to the correct position.
 * @param isExpanded Whether the group is expanded.
 * @param parent The parent to which the new view is attached to
 * @return The newly created view.
 * @apiSince 1
 */

protected abstract android.view.View newGroupView(android.content.Context context, android.database.Cursor cursor, boolean isExpanded, android.view.ViewGroup parent);

/**
 * Bind an existing view to the group data pointed to by cursor.
 *
 * @param view Existing view, returned earlier by newGroupView.
 * @param context Interface to application's global information
 * @param cursor The cursor from which to get the data. The cursor is
 *            already moved to the correct position.
 * @param isExpanded Whether the group is expanded.
 * @apiSince 1
 */

protected abstract void bindGroupView(android.view.View view, android.content.Context context, android.database.Cursor cursor, boolean isExpanded);

/** @apiSince 1 */

public android.view.View getChildView(int groupPosition, int childPosition, boolean isLastChild, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Makes a new child view to hold the data pointed to by cursor.
 *
 * @param context Interface to application's global information
 * @param cursor The cursor from which to get the data. The cursor is
 *            already moved to the correct position.
 * @param isLastChild Whether the child is the last child within its group.
 * @param parent The parent to which the new view is attached to
 * @return the newly created view.
 * @apiSince 1
 */

protected abstract android.view.View newChildView(android.content.Context context, android.database.Cursor cursor, boolean isLastChild, android.view.ViewGroup parent);

/**
 * Bind an existing view to the child data pointed to by cursor
 *
 * @param view Existing view, returned earlier by newChildView
 * @param context Interface to application's global information
 * @param cursor The cursor from which to get the data. The cursor is
 *            already moved to the correct position.
 * @param isLastChild Whether the child is the last child within its group.
 * @apiSince 1
 */

protected abstract void bindChildView(android.view.View view, android.content.Context context, android.database.Cursor cursor, boolean isLastChild);

/** @apiSince 1 */

public boolean isChildSelectable(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean hasStableIds() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void notifyDataSetChanged() { throw new RuntimeException("Stub!"); }

/**
 * Notifies a data set change, but with the option of not releasing any
 * cached cursors.
 *
 * @param releaseCursors Whether to release and deactivate any cached
 *            cursors.
 * @apiSince 1
 */

public void notifyDataSetChanged(boolean releaseCursors) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void notifyDataSetInvalidated() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onGroupCollapsed(int groupPosition) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.CursorAdapter#convertToString(Cursor)
 * @apiSince 1
 */

public java.lang.String convertToString(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.CursorAdapter#runQueryOnBackgroundThread(CharSequence)
 * @apiSince 1
 */

public android.database.Cursor runQueryOnBackgroundThread(java.lang.CharSequence constraint) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.Filter getFilter() { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.CursorAdapter#getFilterQueryProvider()
 * @apiSince 1
 */

public android.widget.FilterQueryProvider getFilterQueryProvider() { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.CursorAdapter#setFilterQueryProvider(FilterQueryProvider)
 * @apiSince 1
 */

public void setFilterQueryProvider(android.widget.FilterQueryProvider filterQueryProvider) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.CursorAdapter#changeCursor(Cursor)
 * @apiSince 1
 */

public void changeCursor(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * @see android.widget.CursorAdapter#getCursor()
 * @apiSince 1
 */

public android.database.Cursor getCursor() { throw new RuntimeException("Stub!"); }
}

