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

import android.view.ViewGroup;
import android.view.View;

/**
 * <p>This class is used to create a multiple-exclusion scope for a set of radio
 * buttons. Checking one radio button that belongs to a radio group unchecks
 * any previously checked radio button within the same group.</p>
 *
 * <p>Intially, all of the radio buttons are unchecked. While it is not possible
 * to uncheck a particular radio button, the radio group can be cleared to
 * remove the checked state.</p>
 *
 * <p>The selection is identified by the unique id of the radio button as defined
 * in the XML layout file.</p>
 *
 * <p><strong>XML Attributes</strong></p>
 * <p>See {@link android.R.styleable#RadioGroup RadioGroup Attributes},
 * {@link android.R.styleable#LinearLayout LinearLayout Attributes},
 * {@link android.R.styleable#ViewGroup ViewGroup Attributes},
 * {@link android.R.styleable#View View Attributes}</p>
 * <p>Also see
 * {@link android.widget.LinearLayout.LayoutParams LinearLayout.LayoutParams}
 * for layout attributes.</p>
 *
 * @see android.widget.RadioButton
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RadioGroup extends android.widget.LinearLayout {

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public RadioGroup(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public RadioGroup(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

protected void onFinishInflate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the selection to the radio button whose identifier is passed in
 * parameter. Using -1 as the selection identifier clears the selection;
 * such an operation is equivalent to invoking {@link #clearCheck()}.</p>
 *
 * @param id the unique id of the radio button to select in this group
 *
 * @see #getCheckedRadioButtonId()
 * @see #clearCheck()
 * @apiSince 1
 */

public void check(int id) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the identifier of the selected radio button in this group.
 * Upon empty selection, the returned value is -1.</p>
 *
 * @return the unique id of the selected radio button in this group
 *
 * @see #check(int)
 * @see #clearCheck()
 *
 * @attr ref android.R.styleable#RadioGroup_checkedButton
 * @apiSince 1
 */

public int getCheckedRadioButtonId() { throw new RuntimeException("Stub!"); }

/**
 * <p>Clears the selection. When the selection is cleared, no radio button
 * in this group is selected and {@link #getCheckedRadioButtonId()} returns
 * null.</p>
 *
 * @see #check(int)
 * @see #getCheckedRadioButtonId()
 * @apiSince 1
 */

public void clearCheck() { throw new RuntimeException("Stub!"); }

/**
 * <p>Register a callback to be invoked when the checked radio button
 * changes in this group.</p>
 *
 * @param listener the callback to call on checked state change
 * @apiSince 1
 */

public void setOnCheckedChangeListener(android.widget.RadioGroup.OnCheckedChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public android.widget.RadioGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

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
/**
 * <p>This set of layout parameters defaults the width and the height of
 * the children to {@link #WRAP_CONTENT} when they are not specified in the
 * XML file. Otherwise, this class ussed the value read from the XML file.</p>
 *
 * <p>See
 * {@link android.R.styleable#LinearLayout_Layout LinearLayout Attributes}
 * for a list of all child view attributes that this class supports.</p>
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(int w, int h) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(int w, int h, float initWeight) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.LayoutParams p) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Fixes the child's width to
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} and the child's
 * height to  {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}
 * when not specified in the XML file.</p>
 *
 * @param a the styled attributes set
 * @param widthAttr the width attribute to fetch
 * @param heightAttr the height attribute to fetch
 * @apiSince 1
 */

protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) { throw new RuntimeException("Stub!"); }
}

/**
 * <p>Interface definition for a callback to be invoked when the checked
 * radio button changed in this group.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCheckedChangeListener {

/**
 * <p>Called when the checked radio button has changed. When the
 * selection is cleared, checkedId is -1.</p>
 *
 * @param group the group in which the checked radio button has changed
 * @param checkedId the unique identifier of the newly checked radio button
 * @apiSince 1
 */

public void onCheckedChanged(android.widget.RadioGroup group, int checkedId);
}

}

