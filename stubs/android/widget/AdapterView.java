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

import android.view.View;
import android.view.ViewStructure;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;

/**
 * An AdapterView is a view whose children are determined by an {@link android.widget.Adapter Adapter}.
 *
 * <p>
 * See {@link android.widget.ListView ListView}, {@link android.widget.GridView GridView}, {@link android.widget.Spinner Spinner} and
 *      {@link android.widget.Gallery Gallery} for commonly used subclasses of AdapterView.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using AdapterView, read the
 * <a href="{@docRoot}guide/topics/ui/binding.html">Binding to Data with AdapterView</a>
 * developer guide.</p></div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AdapterView<T extends android.widget.Adapter> extends android.view.ViewGroup {

/** @apiSince 1 */

public AdapterView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public AdapterView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public AdapterView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public AdapterView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an item in this AdapterView has
 * been clicked.
 *
 * @param listener The callback that will be invoked.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setOnItemClickListener(@androidx.annotation.Nullable android.widget.AdapterView.OnItemClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @return The callback to be invoked with an item in this AdapterView has
 *         been clicked, or null if no callback has been set.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final android.widget.AdapterView.OnItemClickListener getOnItemClickListener() { throw new RuntimeException("Stub!"); }

/**
 * Call the OnItemClickListener, if it is defined. Performs all normal
 * actions associated with clicking: reporting accessibility event, playing
 * a sound, etc.
 *
 * @param view The view within the AdapterView that was clicked.
 * @param position The position of the view in the adapter.
 * @param id The row id of the item that was clicked.
 * @return True if there was an assigned OnItemClickListener that was
 *         called, false otherwise is returned.
 * @apiSince 1
 */

public boolean performItemClick(android.view.View view, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an item in this AdapterView has
 * been clicked and held
 *
 * @param listener The callback that will run
 * @apiSince 1
 */

public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @return The callback to be invoked with an item in this AdapterView has
 *         been clicked and held, or null if no callback has been set.
 * @apiSince 1
 */

public final android.widget.AdapterView.OnItemLongClickListener getOnItemLongClickListener() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an item in this AdapterView has
 * been selected.
 *
 * @param listener The callback that will run
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setOnItemSelectedListener(@androidx.annotation.Nullable android.widget.AdapterView.OnItemSelectedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final android.widget.AdapterView.OnItemSelectedListener getOnItemSelectedListener() { throw new RuntimeException("Stub!"); }

/**
 * Returns the adapter currently associated with this widget.
 *
 * @return The adapter used to provide this view's content.
 * @apiSince 1
 */

public abstract T getAdapter();

/**
 * Sets the adapter that provides the data and the views to represent the data
 * in this widget.
 *
 * @param adapter The adapter to use to create this view's content.
 * @apiSince 1
 */

public abstract void setAdapter(T adapter);

/**
 * This method is not supported and throws an UnsupportedOperationException when called.
 *
 * @param child Ignored.
 *
 * @throws java.lang.UnsupportedOperationException Every time this method is invoked.
 * @apiSince 1
 */

public void addView(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * This method is not supported and throws an UnsupportedOperationException when called.
 *
 * @param child Ignored.
 * @param index Ignored.
 *
 * @throws java.lang.UnsupportedOperationException Every time this method is invoked.
 * @apiSince 1
 */

public void addView(android.view.View child, int index) { throw new RuntimeException("Stub!"); }

/**
 * This method is not supported and throws an UnsupportedOperationException when called.
 *
 * @param child Ignored.
 * @param params Ignored.
 *
 * @throws java.lang.UnsupportedOperationException Every time this method is invoked.
 * @apiSince 1
 */

public void addView(android.view.View child, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * This method is not supported and throws an UnsupportedOperationException when called.
 *
 * @param child Ignored.
 * @param index Ignored.
 * @param params Ignored.
 *
 * @throws java.lang.UnsupportedOperationException Every time this method is invoked.
 * @apiSince 1
 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * This method is not supported and throws an UnsupportedOperationException when called.
 *
 * @param child Ignored.
 *
 * @throws java.lang.UnsupportedOperationException Every time this method is invoked.
 * @apiSince 1
 */

public void removeView(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * This method is not supported and throws an UnsupportedOperationException when called.
 *
 * @param index Ignored.
 *
 * @throws java.lang.UnsupportedOperationException Every time this method is invoked.
 * @apiSince 1
 */

public void removeViewAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * This method is not supported and throws an UnsupportedOperationException when called.
 *
 * @throws java.lang.UnsupportedOperationException Every time this method is invoked.
 * @apiSince 1
 */

public void removeAllViews() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Return the position of the currently selected item within the adapter's data set
 *
 * @return int Position (starting at 0), or {@link #INVALID_POSITION} if there is nothing selected.
 * @apiSince 1
 */

@android.view.ViewDebug.CapturedViewProperty
public int getSelectedItemPosition() { throw new RuntimeException("Stub!"); }

/**
 * @return The id corresponding to the currently selected item, or {@link #INVALID_ROW_ID}
 * if nothing is selected.
 * @apiSince 1
 */

@android.view.ViewDebug.CapturedViewProperty
public long getSelectedItemId() { throw new RuntimeException("Stub!"); }

/**
 * @return The view corresponding to the currently selected item, or null
 * if nothing is selected
 * @apiSince 1
 */

public abstract android.view.View getSelectedView();

/**
 * @return The data corresponding to the currently selected item, or
 * null if there is nothing selected.
 * @apiSince 1
 */

public java.lang.Object getSelectedItem() { throw new RuntimeException("Stub!"); }

/**
 * @return The number of items owned by the Adapter associated with this
 *         AdapterView. (This is the number of data items, which may be
 *         larger than the number of visible views.)
 * @apiSince 1
 */

@android.view.ViewDebug.CapturedViewProperty
public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the position within the adapter's data set for the view, where
 * view is a an adapter item or a descendant of an adapter item.
 * <p>
 * <strong>Note:</strong> The result of this method only reflects the
 * position of the data bound to <var>view</var> during the most recent
 * layout pass. If the adapter's data set has changed without a subsequent
 * layout pass, the position returned by this method may not match the
 * current position of the data within the adapter.
 *
 * @param view an adapter item, or a descendant of an adapter item. This
 *             must be visible in this AdapterView at the time of the call.
 * @return the position within the adapter's data set of the view, or
 *         {@link #INVALID_POSITION} if the view does not correspond to a
 *         list item (or it is not currently visible)
 * @apiSince 1
 */

public int getPositionForView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Returns the position within the adapter's data set for the first item
 * displayed on screen.
 *
 * @return The position within the adapter's data set
 * @apiSince 1
 */

public int getFirstVisiblePosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the position within the adapter's data set for the last item
 * displayed on screen.
 *
 * @return The position within the adapter's data set
 * @apiSince 1
 */

public int getLastVisiblePosition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currently selected item. To support accessibility subclasses that
 * override this method must invoke the overridden super method first.
 *
 * @param position Index (starting at 0) of the data item to be selected.
 * @apiSince 1
 */

public abstract void setSelection(int position);

/**
 * Sets the view to show if the adapter is empty
 * @apiSince 1
 */

public void setEmptyView(android.view.View emptyView) { throw new RuntimeException("Stub!"); }

/**
 * When the current adapter is empty, the AdapterView can display a special view
 * called the empty view. The empty view is used to provide feedback to the user
 * that no data is available in this AdapterView.
 *
 * @return The view to show if the adapter is empty.
 * @apiSince 1
 */

public android.view.View getEmptyView() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param focusable Value is {@link android.view.View#NOT_FOCUSABLE}, {@link android.view.View#FOCUSABLE}, or {@link android.view.View#FOCUSABLE_AUTO}
 * @apiSince 26
 */

public void setFocusable(int focusable) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setFocusableInTouchMode(boolean focusable) { throw new RuntimeException("Stub!"); }

/**
 * Gets the data associated with the specified position in the list.
 *
 * @param position Which data to get
 * @return The data associated with the specified position in the list
 * @apiSince 1
 */

public java.lang.Object getItemAtPosition(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getItemIdAtPosition(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setOnClickListener(android.view.View.OnClickListener l) { throw new RuntimeException("Stub!"); }

/**
 * Override to prevent freezing of any views created by the adapter.
 * @apiSince 1
 */

protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/**
 * Override to prevent thawing of any views created by the adapter.
 * @apiSince 1
 */

protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean canAnimate() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>It also sets the autofill options in the structure; when overridden, it should set it as
 * well, either explicitly by calling {@link android.view.ViewStructure#setAutofillOptions(java.lang.CharSequence[]) ViewStructure#setAutofillOptions(CharSequence[])}
 * or implicitly by calling {@code super.onProvideAutofillStructure(structure, flags)}.
 * @apiSince 26
 */

public void onProvideAutofillStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Represents an invalid position. All valid positions are in the range 0 to 1 less than the
 * number of items in the current adapter.
 * @apiSince 1
 */

public static final int INVALID_POSITION = -1; // 0xffffffff

/**
 * Represents an empty or invalid row id
 * @apiSince 1
 */

public static final long INVALID_ROW_ID = -9223372036854775808L; // 0x8000000000000000L

/**
 * The item view type returned by {@link android.widget.Adapter#getItemViewType(int) Adapter#getItemViewType(int)} when
 * the item is a header or footer.
 * @apiSince 1
 */

public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2; // 0xfffffffe

/**
 * The item view type returned by {@link android.widget.Adapter#getItemViewType(int) Adapter#getItemViewType(int)} when
 * the adapter does not want the item's view recycled.
 * @apiSince 1
 */

public static final int ITEM_VIEW_TYPE_IGNORE = -1; // 0xffffffff
/**
 * Extra menu information provided to the
 * {@link android.view.View.OnCreateContextMenuListener#onCreateContextMenu(ContextMenu, View, ContextMenuInfo) }
 * callback when a context menu is brought up for this AdapterView.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AdapterContextMenuInfo implements android.view.ContextMenu.ContextMenuInfo {

/** @apiSince 1 */

public AdapterContextMenuInfo(android.view.View targetView, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * The row id of the item for which the context menu is being displayed.
 * @apiSince 1
 */

public long id;

/**
 * The position in the adapter for which the context menu is being
 * displayed.
 * @apiSince 1
 */

public int position;

/**
 * The child view for which the context menu is being displayed. This
 * will be one of the children of this AdapterView.
 * @apiSince 1
 */

public android.view.View targetView;
}

/**
 * Interface definition for a callback to be invoked when an item in this
 * AdapterView has been clicked.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnItemClickListener {

/**
 * Callback method to be invoked when an item in this AdapterView has
 * been clicked.
 * <p>
 * Implementers can call getItemAtPosition(position) if they need
 * to access the data associated with the selected item.
 *
 * @param parent The AdapterView where the click happened.
 * @param view The view within the AdapterView that was clicked (this
 *            will be a view provided by the adapter)
 * @param position The position of the view in the adapter.
 * @param id The row id of the item that was clicked.
 * @apiSince 1
 */

public void onItemClick(android.widget.AdapterView<?> parent, android.view.View view, int position, long id);
}

/**
 * Interface definition for a callback to be invoked when an item in this
 * view has been clicked and held.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnItemLongClickListener {

/**
 * Callback method to be invoked when an item in this view has been
 * clicked and held.
 *
 * Implementers can call getItemAtPosition(position) if they need to access
 * the data associated with the selected item.
 *
 * @param parent The AbsListView where the click happened
 * @param view The view within the AbsListView that was clicked
 * @param position The position of the view in the list
 * @param id The row id of the item that was clicked
 *
 * @return true if the callback consumed the long click, false otherwise
 * @apiSince 1
 */

public boolean onItemLongClick(android.widget.AdapterView<?> parent, android.view.View view, int position, long id);
}

/**
 * Interface definition for a callback to be invoked when
 * an item in this view has been selected.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnItemSelectedListener {

/**
 * <p>Callback method to be invoked when an item in this view has been
 * selected. This callback is invoked only when the newly selected
 * position is different from the previously selected position or if
 * there was no selected item.</p>
 *
 * Implementers can call getItemAtPosition(position) if they need to access the
 * data associated with the selected item.
 *
 * @param parent The AdapterView where the selection happened
 * @param view The view within the AdapterView that was clicked
 * @param position The position of the view in the adapter
 * @param id The row id of the item that is selected
 * @apiSince 1
 */

public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id);

/**
 * Callback method to be invoked when the selection disappears from this
 * view. The selection can disappear for instance when touch is activated
 * or when the adapter becomes empty.
 *
 * @param parent The AdapterView that now contains no selected item.
 * @apiSince 1
 */

public void onNothingSelected(android.widget.AdapterView<?> parent);
}

}

