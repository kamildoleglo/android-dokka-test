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

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;

/**
 * A view that shows items in a vertically scrolling two-level list. This
 * differs from the {@link android.widget.ListView ListView} by allowing two levels: groups which can
 * individually be expanded to show its children. The items come from the
 * {@link android.widget.ExpandableListAdapter ExpandableListAdapter} associated with this view.
 * <p>
 * Expandable lists are able to show an indicator beside each item to display
 * the item's current state (the states are usually one of expanded group,
 * collapsed group, child, or last child). Use
 * {@link #setChildIndicator(android.graphics.drawable.Drawable)} or {@link #setGroupIndicator(android.graphics.drawable.Drawable)}
 * (or the corresponding XML attributes) to set these indicators (see the docs
 * for each method to see additional state that each Drawable can have). The
 * default style for an {@link android.widget.ExpandableListView ExpandableListView} provides indicators which
 * will be shown next to Views given to the {@link android.widget.ExpandableListView ExpandableListView}. The
 * layouts android.R.layout.simple_expandable_list_item_1 and
 * android.R.layout.simple_expandable_list_item_2 (which should be used with
 * {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter}) contain the preferred position information
 * for indicators.
 * <p>
 * The context menu information set by an {@link android.widget.ExpandableListView ExpandableListView} will be a
 * {@link android.widget.ExpandableListView.ExpandableListContextMenuInfo ExpandableListContextMenuInfo} object with
 * {@link android.widget.ExpandableListView.ExpandableListContextMenuInfo#packedPosition ExpandableListContextMenuInfo#packedPosition} being a packed position
 * that can be used with {@link #getPackedPositionType(long)} and the other
 * similar methods.
 * <p>
 * <em><b>Note:</b></em> You cannot use the value <code>wrap_content</code>
 * for the <code>android:layout_height</code> attribute of a
 * ExpandableListView in XML if the parent's size is also not strictly specified
 * (for example, if the parent were ScrollView you could not specify
 * wrap_content since it also can be any length. However, you can use
 * wrap_content if the ExpandableListView parent has a specific size, such as
 * 100 pixels.
 *
 * @attr ref android.R.styleable#ExpandableListView_groupIndicator
 * @attr ref android.R.styleable#ExpandableListView_indicatorLeft
 * @attr ref android.R.styleable#ExpandableListView_indicatorRight
 * @attr ref android.R.styleable#ExpandableListView_childIndicator
 * @attr ref android.R.styleable#ExpandableListView_childIndicatorLeft
 * @attr ref android.R.styleable#ExpandableListView_childIndicatorRight
 * @attr ref android.R.styleable#ExpandableListView_childDivider
 * @attr ref android.R.styleable#ExpandableListView_indicatorStart
 * @attr ref android.R.styleable#ExpandableListView_indicatorEnd
 * @attr ref android.R.styleable#ExpandableListView_childIndicatorStart
 * @attr ref android.R.styleable#ExpandableListView_childIndicatorEnd
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ExpandableListView extends android.widget.ListView {

/** @apiSince 1 */

public ExpandableListView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ExpandableListView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ExpandableListView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ExpandableListView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable that will be drawn adjacent to every child in the list. This will
 * be drawn using the same height as the normal divider ({@link #setDivider(android.graphics.drawable.Drawable)}) or
 * if it does not have an intrinsic height, the height set by {@link #setDividerHeight(int)}.
 *
 * @param childDivider The drawable to use.
 * @apiSince 1
 */

public void setChildDivider(android.graphics.drawable.Drawable childDivider) { throw new RuntimeException("Stub!"); }

/**
 * This overloaded method should not be used, instead use
 * {@link #setAdapter(android.widget.ExpandableListAdapter)}.
 * <p>
 * {@inheritDoc}
 * @apiSince 1
 */

public void setAdapter(android.widget.ListAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * This method should not be used, use {@link #getExpandableListAdapter()}.
 * @apiSince 1
 */

public android.widget.ListAdapter getAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an item has been clicked and the
 * caller prefers to receive a ListView-style position instead of a group
 * and/or child position. In most cases, the caller should use
 * {@link #setOnGroupClickListener} and/or {@link #setOnChildClickListener}.
 * <p />
 * {@inheritDoc}
 * @apiSince 1
 */

public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener l) { throw new RuntimeException("Stub!"); }

/**
 * Sets the adapter that provides data to this view.
 * @param adapter The adapter that provides data to this view.
 * @apiSince 1
 */

public void setAdapter(android.widget.ExpandableListAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Gets the adapter that provides data to this view.
 * @return The adapter that provides data to this view.
 * @apiSince 1
 */

public android.widget.ExpandableListAdapter getExpandableListAdapter() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean performItemClick(android.view.View v, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * Expand a group in the grouped list view
 *
 * @param groupPos the group to be expanded
 * @return True if the group was expanded, false otherwise (if the group
 *         was already expanded, this will return false)
 * @apiSince 1
 */

public boolean expandGroup(int groupPos) { throw new RuntimeException("Stub!"); }

/**
 * Expand a group in the grouped list view
 *
 * @param groupPos the group to be expanded
 * @param animate true if the expanding group should be animated in
 * @return True if the group was expanded, false otherwise (if the group
 *         was already expanded, this will return false)
 * @apiSince 14
 */

public boolean expandGroup(int groupPos, boolean animate) { throw new RuntimeException("Stub!"); }

/**
 * Collapse a group in the grouped list view
 *
 * @param groupPos position of the group to collapse
 * @return True if the group was collapsed, false otherwise (if the group
 *         was already collapsed, this will return false)
 * @apiSince 1
 */

public boolean collapseGroup(int groupPos) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setOnGroupCollapseListener(android.widget.ExpandableListView.OnGroupCollapseListener onGroupCollapseListener) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setOnGroupExpandListener(android.widget.ExpandableListView.OnGroupExpandListener onGroupExpandListener) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setOnGroupClickListener(android.widget.ExpandableListView.OnGroupClickListener onGroupClickListener) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setOnChildClickListener(android.widget.ExpandableListView.OnChildClickListener onChildClickListener) { throw new RuntimeException("Stub!"); }

/**
 * Converts a flat list position (the raw position of an item (child or group)
 * in the list) to a group and/or child position (represented in a
 * packed position). This is useful in situations where the caller needs to
 * use the underlying {@link android.widget.ListView ListView}'s methods. Use
 * {@link android.widget.ExpandableListView#getPackedPositionType ExpandableListView#getPackedPositionType} ,
 * {@link android.widget.ExpandableListView#getPackedPositionChild ExpandableListView#getPackedPositionChild},
 * {@link android.widget.ExpandableListView#getPackedPositionGroup ExpandableListView#getPackedPositionGroup} to unpack.
 *
 * @param flatListPosition The flat list position to be converted.
 * @return The group and/or child position for the given flat list position
 *         in packed position representation. #PACKED_POSITION_VALUE_NULL if
 *         the position corresponds to a header or a footer item.
 * @apiSince 1
 */

public long getExpandableListPosition(int flatListPosition) { throw new RuntimeException("Stub!"); }

/**
 * Converts a group and/or child position to a flat list position. This is
 * useful in situations where the caller needs to use the underlying
 * {@link android.widget.ListView ListView}'s methods.
 *
 * @param packedPosition The group and/or child positions to be converted in
 *            packed position representation. Use
 *            {@link #getPackedPositionForChild(int,int)} or
 *            {@link #getPackedPositionForGroup(int)}.
 * @return The flat list position for the given child or group.
 * @apiSince 1
 */

public int getFlatListPosition(long packedPosition) { throw new RuntimeException("Stub!"); }

/**
 * Gets the position of the currently selected group or child (along with
 * its type). Can return {@link #PACKED_POSITION_VALUE_NULL} if no selection.
 *
 * @return A packed position containing the currently selected group or
 *         child's position and type. #PACKED_POSITION_VALUE_NULL if no selection
 *         or if selection is on a header or a footer item.
 * @apiSince 1
 */

public long getSelectedPosition() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ID of the currently selected group or child. Can return -1 if no
 * selection.
 *
 * @return The ID of the currently selected group or child. -1 if no
 *         selection.
 * @apiSince 1
 */

public long getSelectedId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the selection to the specified group.
 * @param groupPosition The position of the group that should be selected.
 * @apiSince 1
 */

public void setSelectedGroup(int groupPosition) { throw new RuntimeException("Stub!"); }

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
 */

public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) { throw new RuntimeException("Stub!"); }

/**
 * Whether the given group is currently expanded.
 *
 * @param groupPosition The group to check.
 * @return Whether the group is currently expanded.
 * @apiSince 1
 */

public boolean isGroupExpanded(int groupPosition) { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of a packed position. See
 * {@link #getPackedPositionForChild(int,int)}.
 *
 * @param packedPosition The packed position for which to return the type.
 * @return The type of the position contained within the packed position,
 *         either {@link #PACKED_POSITION_TYPE_CHILD}, {@link #PACKED_POSITION_TYPE_GROUP}, or
 *         {@link #PACKED_POSITION_TYPE_NULL}.
 * @apiSince 1
 */

public static int getPackedPositionType(long packedPosition) { throw new RuntimeException("Stub!"); }

/**
 * Gets the group position from a packed position. See
 * {@link #getPackedPositionForChild(int,int)}.
 *
 * @param packedPosition The packed position from which the group position
 *            will be returned.
 * @return The group position portion of the packed position. If this does
 *         not contain a group, returns -1.
 * @apiSince 1
 */

public static int getPackedPositionGroup(long packedPosition) { throw new RuntimeException("Stub!"); }

/**
 * Gets the child position from a packed position that is of
 * {@link #PACKED_POSITION_TYPE_CHILD} type (use {@link #getPackedPositionType(long)}).
 * To get the group that this child belongs to, use
 * {@link #getPackedPositionGroup(long)}. See
 * {@link #getPackedPositionForChild(int,int)}.
 *
 * @param packedPosition The packed position from which the child position
 *            will be returned.
 * @return The child position portion of the packed position. If this does
 *         not contain a child, returns -1.
 * @apiSince 1
 */

public static int getPackedPositionChild(long packedPosition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the packed position representation of a child's position.
 * <p>
 * In general, a packed position should be used in
 * situations where the position given to/returned from an
 * {@link android.widget.ExpandableListAdapter ExpandableListAdapter} or {@link android.widget.ExpandableListView ExpandableListView} method can
 * either be a child or group. The two positions are packed into a single
 * long which can be unpacked using
 * {@link #getPackedPositionChild(long)},
 * {@link #getPackedPositionGroup(long)}, and
 * {@link #getPackedPositionType(long)}.
 *
 * @param groupPosition The child's parent group's position.
 * @param childPosition The child position within the group.
 * @return The packed position representation of the child (and parent group).
 * @apiSince 1
 */

public static long getPackedPositionForChild(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the packed position representation of a group's position. See
 * {@link #getPackedPositionForChild(int,int)}.
 *
 * @param groupPosition The child's parent group's position.
 * @return The packed position representation of the group.
 * @apiSince 1
 */

public static long getPackedPositionForGroup(int groupPosition) { throw new RuntimeException("Stub!"); }

/**
 * Sets the indicator to be drawn next to a child.
 *
 * @param childIndicator The drawable to be used as an indicator. If the
 *            child is the last child for a group, the state
 *            {@link android.R.attr#state_last} will be set.
 * @apiSince 1
 */

public void setChildIndicator(android.graphics.drawable.Drawable childIndicator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawing bounds for the child indicator. For either, you can
 * specify {@link #CHILD_INDICATOR_INHERIT} to use inherit from the general
 * indicator's bounds.
 *
 * @see #setIndicatorBounds(int, int)
 * @param left The left position (relative to the left bounds of this View)
 *            to start drawing the indicator.
 * @param right The right position (relative to the left bounds of this
 *            View) to end the drawing of the indicator.
 * @apiSince 1
 */

public void setChildIndicatorBounds(int left, int right) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative drawing bounds for the child indicator. For either, you can
 * specify {@link #CHILD_INDICATOR_INHERIT} to use inherit from the general
 * indicator's bounds.
 *
 * @see #setIndicatorBounds(int, int)
 * @param start The start position (relative to the start bounds of this View)
 *            to start drawing the indicator.
 * @param end The end position (relative to the end bounds of this
 *            View) to end the drawing of the indicator.
 * @apiSince 18
 */

public void setChildIndicatorBoundsRelative(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Sets the indicator to be drawn next to a group.
 *
 * @param groupIndicator The drawable to be used as an indicator. If the
 *            group is empty, the state {@link android.R.attr#state_empty} will be
 *            set. If the group is expanded, the state
 *            {@link android.R.attr#state_expanded} will be set.
 * @apiSince 1
 */

public void setGroupIndicator(android.graphics.drawable.Drawable groupIndicator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawing bounds for the indicators (at minimum, the group indicator
 * is affected by this; the child indicator is affected by this if the
 * child indicator bounds are set to inherit).
 *
 * @see #setChildIndicatorBounds(int, int)
 * @param left The left position (relative to the left bounds of this View)
 *            to start drawing the indicator.
 * @param right The right position (relative to the left bounds of this
 *            View) to end the drawing of the indicator.
 * @apiSince 1
 */

public void setIndicatorBounds(int left, int right) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative drawing bounds for the indicators (at minimum, the group indicator
 * is affected by this; the child indicator is affected by this if the
 * child indicator bounds are set to inherit).
 *
 * @see #setChildIndicatorBounds(int, int)
 * @param start The start position (relative to the start bounds of this View)
 *            to start drawing the indicator.
 * @param end The end position (relative to the end bounds of this
 *            View) to end the drawing of the indicator.
 * @apiSince 18
 */

public void setIndicatorBoundsRelative(int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Denotes when a child indicator should inherit this bound from the generic
 * indicator bounds
 * @apiSince 1
 */

public static final int CHILD_INDICATOR_INHERIT = -1; // 0xffffffff

/**
 * The packed position represents a child.
 * @apiSince 1
 */

public static final int PACKED_POSITION_TYPE_CHILD = 1; // 0x1

/**
 * The packed position represents a group.
 * @apiSince 1
 */

public static final int PACKED_POSITION_TYPE_GROUP = 0; // 0x0

/**
 * The packed position represents a neither/null/no preference.
 * @apiSince 1
 */

public static final int PACKED_POSITION_TYPE_NULL = 2; // 0x2

/**
 * The value for a packed position that represents neither/null/no
 * preference. This value is not otherwise possible since a group type
 * (first bit 0) should not have a child position filled.
 * @apiSince 1
 */

public static final long PACKED_POSITION_VALUE_NULL = 4294967295L; // 0xffffffffL
/**
 * Extra menu information specific to an {@link android.widget.ExpandableListView ExpandableListView} provided
 * to the
 * {@link android.view.View.OnCreateContextMenuListener#onCreateContextMenu(ContextMenu, View, ContextMenuInfo) }
 * callback when a context menu is brought up for this AdapterView.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ExpandableListContextMenuInfo implements android.view.ContextMenu.ContextMenuInfo {

/** @apiSince 1 */

public ExpandableListContextMenuInfo(android.view.View targetView, long packedPosition, long id) { throw new RuntimeException("Stub!"); }

/**
 * The ID of the item (group or child) for which the context menu is
 * being displayed.
 * @apiSince 1
 */

public long id;

/**
 * The packed position in the list represented by the adapter for which
 * the context menu is being displayed. Use the methods
 * {@link android.widget.ExpandableListView#getPackedPositionType ExpandableListView#getPackedPositionType},
 * {@link android.widget.ExpandableListView#getPackedPositionChild ExpandableListView#getPackedPositionChild}, and
 * {@link android.widget.ExpandableListView#getPackedPositionGroup ExpandableListView#getPackedPositionGroup} to unpack this.
 * @apiSince 1
 */

public long packedPosition;

/**
 * The view for which the context menu is being displayed. This
 * will be one of the children Views of this {@link android.widget.ExpandableListView ExpandableListView}.
 * @apiSince 1
 */

public android.view.View targetView;
}

/**
 * Interface definition for a callback to be invoked when a child in this
 * expandable list has been clicked.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnChildClickListener {

/**
 * Callback method to be invoked when a child in this expandable list has
 * been clicked.
 *
 * @param parent The ExpandableListView where the click happened
 * @param v The view within the expandable list/ListView that was clicked
 * @param groupPosition The group position that contains the child that
 *        was clicked
 * @param childPosition The child position within the group
 * @param id The row id of the child that was clicked
 * @return True if the click was handled
 * @apiSince 1
 */

public boolean onChildClick(android.widget.ExpandableListView parent, android.view.View v, int groupPosition, int childPosition, long id);
}

/**
 * Interface definition for a callback to be invoked when a group in this
 * expandable list has been clicked.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGroupClickListener {

/**
 * Callback method to be invoked when a group in this expandable list has
 * been clicked.
 *
 * @param parent The ExpandableListConnector where the click happened
 * @param v The view within the expandable list/ListView that was clicked
 * @param groupPosition The group position that was clicked
 * @param id The row id of the group that was clicked
 * @return True if the click was handled
 * @apiSince 1
 */

public boolean onGroupClick(android.widget.ExpandableListView parent, android.view.View v, int groupPosition, long id);
}

/**
 * Used for being notified when a group is collapsed
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGroupCollapseListener {

/**
 * Callback method to be invoked when a group in this expandable list has
 * been collapsed.
 *
 * @param groupPosition The group position that was collapsed
 * @apiSince 1
 */

public void onGroupCollapse(int groupPosition);
}

/**
 * Used for being notified when a group is expanded
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnGroupExpandListener {

/**
 * Callback method to be invoked when a group in this expandable list has
 * been expanded.
 *
 * @param groupPosition The group position that was expanded
 * @apiSince 1
 */

public void onGroupExpand(int groupPosition);
}

}

