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


/**
 * A fairly simple ExpandableListAdapter that creates views defined in an XML
 * file. You can specify the XML file that defines the appearance of the views.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ResourceCursorTreeAdapter extends android.widget.CursorTreeAdapter {

/**
 * Constructor.
 *
 * @param context The context where the ListView associated with this
 *            SimpleListItemFactory is running
 * @param cursor The database cursor
 * @param collapsedGroupLayout resource identifier of a layout file that
 *            defines the views for collapsed groups.
 * @param expandedGroupLayout resource identifier of a layout file that
 *            defines the views for expanded groups.
 * @param childLayout resource identifier of a layout file that defines the
 *            views for all children but the last..
 * @param lastChildLayout resource identifier of a layout file that defines
 *            the views for the last child of a group.
 * @apiSince 1
 */

public ResourceCursorTreeAdapter(android.content.Context context, android.database.Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, int childLayout, int lastChildLayout) { super((android.database.Cursor)null, (android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param context The context where the ListView associated with this
 *            SimpleListItemFactory is running
 * @param cursor The database cursor
 * @param collapsedGroupLayout resource identifier of a layout file that
 *            defines the views for collapsed groups.
 * @param expandedGroupLayout resource identifier of a layout file that
 *            defines the views for expanded groups.
 * @param childLayout resource identifier of a layout file that defines the
 *            views for all children.
 * @apiSince 1
 */

public ResourceCursorTreeAdapter(android.content.Context context, android.database.Cursor cursor, int collapsedGroupLayout, int expandedGroupLayout, int childLayout) { super((android.database.Cursor)null, (android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param context The context where the ListView associated with this
 *            SimpleListItemFactory is running
 * @param cursor The database cursor
 * @param groupLayout resource identifier of a layout file that defines the
 *            views for all groups.
 * @param childLayout resource identifier of a layout file that defines the
 *            views for all children.
 * @apiSince 1
 */

public ResourceCursorTreeAdapter(android.content.Context context, android.database.Cursor cursor, int groupLayout, int childLayout) { super((android.database.Cursor)null, (android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View newChildView(android.content.Context context, android.database.Cursor cursor, boolean isLastChild, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View newGroupView(android.content.Context context, android.database.Cursor cursor, boolean isExpanded, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }
}

