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

import android.database.DataSetObservable;

/**
 * Base class for a {@link android.widget.ExpandableListAdapter ExpandableListAdapter} used to provide data and Views
 * from some data to an expandable list view.
 * <p>
 * Adapters inheriting this class should verify that the base implementations of
 * {@link #getCombinedChildId(long,long)} and {@link #getCombinedGroupId(long)}
 * are correct in generating unique IDs from the group/children IDs.
 * <p>
 * @see android.widget.SimpleExpandableListAdapter
 * @see android.widget.SimpleCursorTreeAdapter
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BaseExpandableListAdapter implements android.widget.ExpandableListAdapter, android.widget.HeterogeneousExpandableList {

public BaseExpandableListAdapter() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void registerDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void unregisterDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * @see android.database.DataSetObservable#notifyInvalidated()
 * @apiSince 1
 */

public void notifyDataSetInvalidated() { throw new RuntimeException("Stub!"); }

/**
 * @see android.database.DataSetObservable#notifyChanged()
 * @apiSince 1
 */

public void notifyDataSetChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean areAllItemsEnabled() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onGroupCollapsed(int groupPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onGroupExpanded(int groupPosition) { throw new RuntimeException("Stub!"); }

/**
 * Override this method if you foresee a clash in IDs based on this scheme:
 * <p>
 * Base implementation returns a long:
 * <li> bit 0: Whether this ID points to a child (unset) or group (set), so for this method
 *             this bit will be 1.
 * <li> bit 1-31: Lower 31 bits of the groupId
 * <li> bit 32-63: Lower 32 bits of the childId.
 * <p>
 * {@inheritDoc}
 * @apiSince 1
 */

public long getCombinedChildId(long groupId, long childId) { throw new RuntimeException("Stub!"); }

/**
 * Override this method if you foresee a clash in IDs based on this scheme:
 * <p>
 * Base implementation returns a long:
 * <li> bit 0: Whether this ID points to a child (unset) or group (set), so for this method
 *             this bit will be 0.
 * <li> bit 1-31: Lower 31 bits of the groupId
 * <li> bit 32-63: Lower 32 bits of the childId.
 * <p>
 * {@inheritDoc}
 * @apiSince 1
 */

public long getCombinedGroupId(long groupId) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return 0 for any group or child position, since only one child type count is declared.
 * @apiSince 8
 */

public int getChildType(int groupPosition, int childPosition) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return 1 as a default value in BaseExpandableListAdapter.
 * @apiSince 8
 */

public int getChildTypeCount() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return 0 for any groupPosition, since only one group type count is declared.
 * @apiSince 8
 */

public int getGroupType(int groupPosition) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return 1 as a default value in BaseExpandableListAdapter.
 * @apiSince 8
 */

public int getGroupTypeCount() { throw new RuntimeException("Stub!"); }
}

