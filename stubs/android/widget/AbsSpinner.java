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

/**
 * An abstract base class for spinner widgets. SDK users will probably not
 * need to use this class.
 *
 * @attr ref android.R.styleable#AbsSpinner_entries
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbsSpinner extends android.widget.AdapterView<android.widget.SpinnerAdapter> {

/** @apiSince 1 */

public AbsSpinner(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public AbsSpinner(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public AbsSpinner(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public AbsSpinner(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * The Adapter is used to provide the data which backs this Spinner.
 * It also provides methods to transform spinner items based on their position
 * relative to the selected item.
 * @param adapter The SpinnerAdapter to use for this Spinner
 * @apiSince 1
 */

public void setAdapter(android.widget.SpinnerAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * @see android.view.View#measure(int, int)
 *
 * Figure out the dimensions of this Spinner. The width comes from
 * the widthMeasureSpec as Spinnners can't have their width set to
 * UNSPECIFIED. The height is based on the height of the selected item
 * plus padding.
 * @apiSince 1
 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/**
 * Jump directly to a specific item in the adapter data.
 * @apiSince 1
 */

public void setSelection(int position, boolean animate) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setSelection(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.view.View getSelectedView() { throw new RuntimeException("Stub!"); }

/**
 * Override to prevent spamming ourselves with layout requests
 * as we place views
 *
 * @see android.view.View#requestLayout()
 * @apiSince 1
 */

public void requestLayout() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.SpinnerAdapter getAdapter() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * Maps a point to a position in the list.
 *
 * @param x X in local coordinate
 * @param y Y in local coordinate
 * @return The position of the item which contains the specified point, or
 *         {@link #INVALID_POSITION} if the point does not intersect an item.
 * @apiSince 1
 */

public int pointToPosition(int x, int y) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void autofill(android.view.autofill.AutofillValue value) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is {@link android.view.View#AUTOFILL_TYPE_NONE}, {@link android.view.View#AUTOFILL_TYPE_TEXT}, {@link android.view.View#AUTOFILL_TYPE_TOGGLE}, {@link android.view.View#AUTOFILL_TYPE_LIST}, or {@link android.view.View#AUTOFILL_TYPE_DATE}
 * @apiSince 26
 */

public int getAutofillType() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.view.autofill.AutofillValue getAutofillValue() { throw new RuntimeException("Stub!"); }
}

