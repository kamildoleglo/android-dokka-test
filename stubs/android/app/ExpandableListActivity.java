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


package android.app;

import android.widget.SimpleCursorTreeAdapter;
import java.util.List;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.database.Cursor;
import android.view.View;
import java.util.Map;
import android.widget.ExpandableListView;
import android.os.Bundle;

/**
 * An activity that displays an expandable list of items by binding to a data
 * source implementing the ExpandableListAdapter, and exposes event handlers
 * when the user selects an item.
 * <p>
 * ExpandableListActivity hosts a
 * {@link android.widget.ExpandableListView ExpandableListView} object that can
 * be bound to different data sources that provide a two-levels of data (the
 * top-level is group, and below each group are children). Binding, screen
 * layout, and row layout are discussed in the following sections.
 * <p>
 * <strong>Screen Layout</strong>
 * </p>
 * <p>
 * ExpandableListActivity has a default layout that consists of a single,
 * full-screen, centered expandable list. However, if you desire, you can
 * customize the screen layout by setting your own view layout with
 * setContentView() in onCreate(). To do this, your own view MUST contain an
 * ExpandableListView object with the id "@android:id/list" (or
 * {@link android.R.id#list} if it's in code)
 * <p>
 * Optionally, your custom view can contain another view object of any type to
 * display when the list view is empty. This "empty list" notifier must have an
 * id "android:empty". Note that when an empty view is present, the expandable
 * list view will be hidden when there is no data to display.
 * <p>
 * The following code demonstrates an (ugly) custom screen layout. It has a list
 * with a green background, and an alternate red "no data" message.
 * </p>
 *
 * <pre>
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
 * &lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *         android:orientation=&quot;vertical&quot;
 *         android:layout_width=&quot;match_parent&quot;
 *         android:layout_height=&quot;match_parent&quot;
 *         android:paddingLeft=&quot;8dp&quot;
 *         android:paddingRight=&quot;8dp&quot;&gt;
 *
 *     &lt;ExpandableListView android:id=&quot;@id/android:list&quot;
 *               android:layout_width=&quot;match_parent&quot;
 *               android:layout_height=&quot;match_parent&quot;
 *               android:background=&quot;#00FF00&quot;
 *               android:layout_weight=&quot;1&quot;
 *               android:drawSelectorOnTop=&quot;false&quot;/&gt;
 *
 *     &lt;TextView android:id=&quot;@id/android:empty&quot;
 *               android:layout_width=&quot;match_parent&quot;
 *               android:layout_height=&quot;match_parent&quot;
 *               android:background=&quot;#FF0000&quot;
 *               android:text=&quot;No data&quot;/&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 *
 * <p>
 * <strong>Row Layout</strong>
 * </p>
 * The {@link android.widget.ExpandableListAdapter ExpandableListAdapter} set in the {@link android.app.ExpandableListActivity ExpandableListActivity}
 * via {@link #setListAdapter(android.widget.ExpandableListAdapter)} provides the {@link android.view.View View}s
 * for each row. This adapter has separate methods for providing the group
 * {@link android.view.View View}s and child {@link android.view.View View}s. There are a couple provided
 * {@link android.widget.ExpandableListAdapter ExpandableListAdapter}s that simplify use of adapters:
 * {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter} and {@link android.widget.SimpleExpandableListAdapter SimpleExpandableListAdapter}.
 * <p>
 * With these, you can specify the layout of individual rows for groups and
 * children in the list. These constructor takes a few parameters that specify
 * layout resources for groups and children. It also has additional parameters
 * that let you specify which data field to associate with which object in the
 * row layout resource. The {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter} fetches data from
 * {@link android.database.Cursor Cursor}s and the {@link android.widget.SimpleExpandableListAdapter SimpleExpandableListAdapter} fetches data
 * from {@link java.util.List List}s of {@link java.util.Map Map}s.
 * </p>
 * <p>
 * Android provides some standard row layout resources. These are in the
 * {@link android.R.layout} class, and have names such as simple_list_item_1,
 * simple_list_item_2, and two_line_list_item. The following layout XML is the
 * source for the resource two_line_list_item, which displays two data
 * fields,one above the other, for each list row.
 * </p>
 *
 * <pre>
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?&gt;
 * &lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:layout_width=&quot;match_parent&quot;
 *     android:layout_height=&quot;wrap_content&quot;
 *     android:orientation=&quot;vertical&quot;&gt;
 *
 *     &lt;TextView android:id=&quot;@+id/text1&quot;
 *         android:textSize=&quot;16sp&quot;
 *         android:textStyle=&quot;bold&quot;
 *         android:layout_width=&quot;match_parent&quot;
 *         android:layout_height=&quot;wrap_content&quot;/&gt;
 *
 *     &lt;TextView android:id=&quot;@+id/text2&quot;
 *         android:textSize=&quot;16sp&quot;
 *         android:layout_width=&quot;match_parent&quot;
 *         android:layout_height=&quot;wrap_content&quot;/&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 *
 * <p>
 * You must identify the data bound to each TextView object in this layout. The
 * syntax for this is discussed in the next section.
 * </p>
 * <p>
 * <strong>Binding to Data</strong>
 * </p>
 * <p>
 * You bind the ExpandableListActivity's ExpandableListView object to data using
 * a class that implements the
 * {@link android.widget.ExpandableListAdapter ExpandableListAdapter} interface.
 * Android provides two standard list adapters:
 * {@link android.widget.SimpleExpandableListAdapter SimpleExpandableListAdapter}
 * for static data (Maps), and
 * {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter} for
 * Cursor query results.
 * </p>
 *
 * @see #setListAdapter
 * @see android.widget.ExpandableListView
 *
 * @deprecated Use {@link androidx.recyclerview.widget.RecyclerView} or use
 *   {@link android.widget.ExpandableListView} directly
 * @apiSince 1
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class ExpandableListActivity extends android.app.Activity implements android.view.View.OnCreateContextMenuListener, android.widget.ExpandableListView.OnChildClickListener, android.widget.ExpandableListView.OnGroupCollapseListener, android.widget.ExpandableListView.OnGroupExpandListener {

@Deprecated
public ExpandableListActivity() { throw new RuntimeException("Stub!"); }

/**
 * Override this to populate the context menu when an item is long pressed. menuInfo
 * will contain an {@link android.widget.ExpandableListView.ExpandableListContextMenuInfo}
 * whose packedPosition is a packed position
 * that should be used with {@link android.widget.ExpandableListView#getPackedPositionType(long) ExpandableListView#getPackedPositionType(long)} and
 * the other similar methods.
 * <p>
 * {@inheritDoc}
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void onCreateContextMenu(android.view.ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo) { throw new RuntimeException("Stub!"); }

/**
 * Override this for receiving callbacks when a child has been clicked.
 * <p>
 * {@inheritDoc}
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public boolean onChildClick(android.widget.ExpandableListView parent, android.view.View v, int groupPosition, int childPosition, long id) { throw new RuntimeException("Stub!"); }

/**
 * Override this for receiving callbacks when a group has been collapsed.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void onGroupCollapse(int groupPosition) { throw new RuntimeException("Stub!"); }

/**
 * Override this for receiving callbacks when a group has been expanded.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void onGroupExpand(int groupPosition) { throw new RuntimeException("Stub!"); }

/**
 * Ensures the expandable list view has been created before Activity restores all
 * of the view states.
 *
 *@see android.app.Activity#onRestoreInstanceState(Bundle)
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Bundle state) { throw new RuntimeException("Stub!"); }

/**
 * Updates the screen state (current list and other views) when the
 * content changes.
 *
 * @see android.app.Activity#onContentChanged()
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void onContentChanged() { throw new RuntimeException("Stub!"); }

/**
 * Provide the adapter for the expandable list.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void setListAdapter(android.widget.ExpandableListAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Get the activity's expandable list view widget.  This can be used to get the selection,
 * set the selection, and many other useful functions.
 *
 * @see android.widget.ExpandableListView
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public android.widget.ExpandableListView getExpandableListView() { throw new RuntimeException("Stub!"); }

/**
 * Get the ExpandableListAdapter associated with this activity's
 * ExpandableListView.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public android.widget.ExpandableListAdapter getExpandableListAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ID of the currently selected group or child.
 *
 * @return The ID of the currently selected group or child.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public long getSelectedId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the position (in packed position representation) of the currently
 * selected group or child. Use
 * {@link android.widget.ExpandableListView#getPackedPositionType ExpandableListView#getPackedPositionType},
 * {@link android.widget.ExpandableListView#getPackedPositionGroup ExpandableListView#getPackedPositionGroup}, and
 * {@link android.widget.ExpandableListView#getPackedPositionChild ExpandableListView#getPackedPositionChild} to unpack the returned
 * packed position.
 *
 * @return A packed position representation containing the currently
 *         selected group or child's position and type.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public long getSelectedPosition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the selection to the specified child. If the child is in a collapsed
 * group, the group will only be expanded and child subsequently selected if
 * shouldExpandGroup is set to true, otherwise the method will return false.
 *
 * @param groupPosition The position of the group that contains the child.
 * @param childPosition The position of the child within the group.
 * @param shouldExpandGroup Whether the child's group should be expanded if
 *            it is collapsed.
 * @return Whether the selection was successfully set on the child.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) { throw new RuntimeException("Stub!"); }

/**
 * Sets the selection to the specified group.
 * @param groupPosition The position of the group that should be selected.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void setSelectedGroup(int groupPosition) { throw new RuntimeException("Stub!"); }
}

