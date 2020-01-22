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

import java.util.List;
import java.util.Map;
import android.view.View;

/**
 * An easy adapter to map static data to group and child views defined in an XML
 * file. You can separately specify the data backing the group as a List of
 * Maps. Each entry in the ArrayList corresponds to one group in the expandable
 * list. The Maps contain the data for each row. You also specify an XML file
 * that defines the views used to display a group, and a mapping from keys in
 * the Map to specific views. This process is similar for a child, except it is
 * one-level deeper so the data backing is specified as a List<List<Map>>,
 * where the first List corresponds to the group of the child, the second List
 * corresponds to the position of the child within the group, and finally the
 * Map holds the data for that particular child.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SimpleExpandableListAdapter extends android.widget.BaseExpandableListAdapter {

/**
 * Constructor
 *
 * @param context The context where the {@link android.widget.ExpandableListView ExpandableListView}
 *            associated with this {@link android.widget.SimpleExpandableListAdapter SimpleExpandableListAdapter} is
 *            running
 * @param groupData A List of Maps. Each entry in the List corresponds to
 *            one group in the list. The Maps contain the data for each
 *            group, and should include all the entries specified in
 *            "groupFrom"
 * @param groupFrom A list of keys that will be fetched from the Map
 *            associated with each group.
 * @param groupTo The group views that should display column in the
 *            "groupFrom" parameter. These should all be TextViews. The
 *            first N views in this list are given the values of the first N
 *            columns in the groupFrom parameter.
 * @param groupLayout resource identifier of a view layout that defines the
 *            views for a group. The layout file should include at least
 *            those named views defined in "groupTo"
 * @param childData A List of List of Maps. Each entry in the outer List
 *            corresponds to a group (index by group position), each entry
 *            in the inner List corresponds to a child within the group
 *            (index by child position), and the Map corresponds to the data
 *            for a child (index by values in the childFrom array). The Map
 *            contains the data for each child, and should include all the
 *            entries specified in "childFrom"
 * @param childFrom A list of keys that will be fetched from the Map
 *            associated with each child.
 * @param childTo The child views that should display column in the
 *            "childFrom" parameter. These should all be TextViews. The
 *            first N views in this list are given the values of the first N
 *            columns in the childFrom parameter.
 * @param childLayout resource identifier of a view layout that defines the
 *            views for a child. The layout file should include at least
 *            those named views defined in "childTo"
 * @apiSince 1
 */

public SimpleExpandableListAdapter(android.content.Context context, java.util.List<? extends java.util.Map<java.lang.String,?>> groupData, int groupLayout, java.lang.String[] groupFrom, int[] groupTo, java.util.List<? extends java.util.List<? extends java.util.Map<java.lang.String,?>>> childData, int childLayout, java.lang.String[] childFrom, int[] childTo) { throw new RuntimeException("Stub!"); }

/**
 * Constructor
 *
 * @param context The context where the {@link android.widget.ExpandableListView ExpandableListView}
 *            associated with this {@link android.widget.SimpleExpandableListAdapter SimpleExpandableListAdapter} is
 *            running
 * @param groupData A List of Maps. Each entry in the List corresponds to
 *            one group in the list. The Maps contain the data for each
 *            group, and should include all the entries specified in
 *            "groupFrom"
 * @param groupFrom A list of keys that will be fetched from the Map
 *            associated with each group.
 * @param groupTo The group views that should display column in the
 *            "groupFrom" parameter. These should all be TextViews. The
 *            first N views in this list are given the values of the first N
 *            columns in the groupFrom parameter.
 * @param expandedGroupLayout resource identifier of a view layout that
 *            defines the views for an expanded group. The layout file
 *            should include at least those named views defined in "groupTo"
 * @param collapsedGroupLayout resource identifier of a view layout that
 *            defines the views for a collapsed group. The layout file
 *            should include at least those named views defined in "groupTo"
 * @param childData A List of List of Maps. Each entry in the outer List
 *            corresponds to a group (index by group position), each entry
 *            in the inner List corresponds to a child within the group
 *            (index by child position), and the Map corresponds to the data
 *            for a child (index by values in the childFrom array). The Map
 *            contains the data for each child, and should include all the
 *            entries specified in "childFrom"
 * @param childFrom A list of keys that will be fetched from the Map
 *            associated with each child.
 * @param childTo The child views that should display column in the
 *            "childFrom" parameter. These should all be TextViews. The
 *            first N views in this list are given the values of the first N
 *            columns in the childFrom parameter.
 * @param childLayout resource identifier of a view layout that defines the
 *            views for a child. The layout file should include at least
 *            those named views defined in "childTo"
 * @apiSince 1
 */

public SimpleExpandableListAdapter(android.content.Context context, java.util.List<? extends java.util.Map<java.lang.String,?>> groupData, int expandedGroupLayout, int collapsedGroupLayout, java.lang.String[] groupFrom, int[] groupTo, java.util.List<? extends java.util.List<? extends java.util.Map<java.lang.String,?>>> childData, int childLayout, java.lang.String[] childFrom, int[] childTo) { throw new RuntimeException("Stub!"); }

/**
 * Constructor
 *
 * @param context The context where the {@link android.widget.ExpandableListView ExpandableListView}
 *            associated with this {@link android.widget.SimpleExpandableListAdapter SimpleExpandableListAdapter} is
 *            running
 * @param groupData A List of Maps. Each entry in the List corresponds to
 *            one group in the list. The Maps contain the data for each
 *            group, and should include all the entries specified in
 *            "groupFrom"
 * @param groupFrom A list of keys that will be fetched from the Map
 *            associated with each group.
 * @param groupTo The group views that should display column in the
 *            "groupFrom" parameter. These should all be TextViews. The
 *            first N views in this list are given the values of the first N
 *            columns in the groupFrom parameter.
 * @param expandedGroupLayout resource identifier of a view layout that
 *            defines the views for an expanded group. The layout file
 *            should include at least those named views defined in "groupTo"
 * @param collapsedGroupLayout resource identifier of a view layout that
 *            defines the views for a collapsed group. The layout file
 *            should include at least those named views defined in "groupTo"
 * @param childData A List of List of Maps. Each entry in the outer List
 *            corresponds to a group (index by group position), each entry
 *            in the inner List corresponds to a child within the group
 *            (index by child position), and the Map corresponds to the data
 *            for a child (index by values in the childFrom array). The Map
 *            contains the data for each child, and should include all the
 *            entries specified in "childFrom"
 * @param childFrom A list of keys that will be fetched from the Map
 *            associated with each child.
 * @param childTo The child views that should display column in the
 *            "childFrom" parameter. These should all be TextViews. The
 *            first N views in this list are given the values of the first N
 *            columns in the childFrom parameter.
 * @param childLayout resource identifier of a view layout that defines the
 *            views for a child (unless it is the last child within a group,
 *            in which case the lastChildLayout is used). The layout file
 *            should include at least those named views defined in "childTo"
 * @param lastChildLayout resource identifier of a view layout that defines
 *            the views for the last child within each group. The layout
 *            file should include at least those named views defined in
 *            "childTo"
 * @apiSince 1
 */

public SimpleExpandableListAdapter(android.content.Context context, java.util.List<? extends java.util.Map<java.lang.String,?>> groupData, int expandedGroupLayout, int collapsedGroupLayout, java.lang.String[] groupFrom, int[] groupTo, java.util.List<? extends java.util.List<? extends java.util.Map<java.lang.String,?>>> childData, int childLayout, int lastChildLayout, java.lang.String[] childFrom, int[] childTo) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.Object getChild(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getChildId(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View getChildView(int groupPosition, int childPosition, boolean isLastChild, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Instantiates a new View for a child.
 * @param isLastChild Whether the child is the last child within its group.
 * @param parent The eventual parent of this new View.
 * @return A new child View
 * @apiSince 1
 */

public android.view.View newChildView(boolean isLastChild, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getChildrenCount(int groupPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.Object getGroup(int groupPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getGroupCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getGroupId(int groupPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View getGroupView(int groupPosition, boolean isExpanded, android.view.View convertView, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Instantiates a new View for a group.
 * @param isExpanded Whether the group is currently expanded.
 * @param parent The eventual parent of this new View.
 * @return A new group View
 * @apiSince 1
 */

public android.view.View newGroupView(boolean isExpanded, android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isChildSelectable(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean hasStableIds() { throw new RuntimeException("Stub!"); }
}

