/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.content.res;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.content.pm.ActivityInfo;

/**
 * Container for an array of values that were retrieved with
 * {@link android.content.res.Resources.Theme#obtainStyledAttributes(android.util.AttributeSet,int[],int,int) Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)}
 * or {@link android.content.res.Resources#obtainAttributes Resources#obtainAttributes}.  Be
 * sure to call {@link #recycle} when done with them.
 *
 * The indices used to retrieve values from this structure correspond to
 * the positions of the attributes given to obtainStyledAttributes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TypedArray {

TypedArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of values in this array.
 *
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of indices in the array that actually have data. Attributes with a value
 * of @empty are included, as this is an explicit indicator.
 *
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public int getIndexCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an index in the array that has data. Attributes with a value of @empty are included,
 * as this is an explicit indicator.
 *
 * @param at The index you would like to returned, ranging from 0 to
 *           {@link #getIndexCount()}.
 *
 * @return The index at the given offset, which can be used with
 *         {@link #getValue} and related APIs.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public int getIndex(int at) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Resources object this array was loaded from.
 *
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public android.content.res.Resources getResources() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the styled string value for the attribute at <var>index</var>.
 * <p>
 * If the attribute is not a string, this method will attempt to coerce
 * it to a string.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return CharSequence holding string data. May be styled. Returns
 *         {@code null} if the attribute is not defined or could not be
 *         coerced to a string.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public java.lang.CharSequence getText(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the string value for the attribute at <var>index</var>.
 * <p>
 * If the attribute is not a string, this method will attempt to coerce
 * it to a string.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return String holding string data. Any styling information is removed.
 *         Returns {@code null} if the attribute is not defined or could
 *         not be coerced to a string.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getString(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the string value for the attribute at <var>index</var>, but
 * only if that string comes from an immediate value in an XML file.  That
 * is, this does not allow references to string resources, string
 * attributes, or conversions from other types.  As such, this method
 * will only return strings for TypedArray objects that come from
 * attributes in an XML file.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return String holding string data. Any styling information is removed.
 *         Returns {@code null} if the attribute is not defined or is not
 *         an immediate string value.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public java.lang.String getNonResourceString(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the boolean value for the attribute at <var>index</var>.
 * <p>
 * If the attribute is an integer value, this method will return whether
 * it is equal to zero. If the attribute is not a boolean or integer value,
 * this method will attempt to coerce it to an integer using
 * {@link java.lang.Integer#decode(java.lang.String) Integer#decode(String)} and return whether it is equal to zero.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 cannot be coerced to an integer.
 *
 * @return Boolean value of the attribute, or defValue if the attribute was
 *         not defined or could not be coerced to an integer.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public boolean getBoolean(int index, boolean defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the integer value for the attribute at <var>index</var>.
 * <p>
 * If the attribute is not an integer, this method will attempt to coerce
 * it to an integer using {@link java.lang.Integer#decode(java.lang.String) Integer#decode(String)}.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 cannot be coerced to an integer.
 *
 * @return Integer value of the attribute, or defValue if the attribute was
 *         not defined or could not be coerced to an integer.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public int getInt(int index, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the float value for the attribute at <var>index</var>.
 * <p>
 * If the attribute is not a float or an integer, this method will attempt
 * to coerce it to a float using {@link java.lang.Float#parseFloat(java.lang.String) Float#parseFloat(String)}.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return Attribute float value, or defValue if the attribute was
 *         not defined or could not be coerced to a float.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public float getFloat(int index, float defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the color value for the attribute at <var>index</var>.  If
 * the attribute references a color resource holding a complex
 * {@link android.content.res.ColorStateList}, then the default color from
 * the set is returned.
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not an integer color or color state list.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 not a resource.
 *
 * @return Attribute color value, or defValue if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not an integer color or color state list.
 * @apiSince 1
 */

public int getColor(int index, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the ColorStateList for the attribute at <var>index</var>.
 * The value may be either a single solid color or a reference to
 * a color or complex {@link android.content.res.ColorStateList}
 * description.
 * <p>
 * This method will return {@code null} if the attribute is not defined or
 * is not an integer color or color state list.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return ColorStateList for the attribute, or {@code null} if not
 *         defined.
 * @throws java.lang.RuntimeException if the attribute if the TypedArray has already
 *         been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not an integer color or color state list.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.content.res.ColorStateList getColorStateList(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the integer value for the attribute at <var>index</var>.
 * <p>
 * Unlike {@link #getInt(int,int)}, this method will throw an exception if
 * the attribute is defined but is not an integer.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 not a resource.
 *
 * @return Attribute integer value, or defValue if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not an integer.
 * @apiSince 1
 */

public int getInteger(int index, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a dimensional unit attribute at <var>index</var>. Unit
 * conversions are based on the current {@link android.util.DisplayMetrics DisplayMetrics}
 * associated with the resources this {@link android.content.res.TypedArray TypedArray} object
 * came from.
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not a dimension.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 not a resource.
 *
 * @return Attribute dimension value multiplied by the appropriate
 *         metric, or defValue if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not an integer.
 *
 * @see #getDimensionPixelOffset
 * @see #getDimensionPixelSize
 * @apiSince 1
 */

public float getDimension(int index, float defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a dimensional unit attribute at <var>index</var> for use
 * as an offset in raw pixels.  This is the same as
 * {@link #getDimension}, except the returned value is converted to
 * integer pixels for you.  An offset conversion involves simply
 * truncating the base value to an integer.
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not a dimension.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 not a resource.
 *
 * @return Attribute dimension value multiplied by the appropriate
 *         metric and truncated to integer pixels, or defValue if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not an integer.
 *
 * @see #getDimension
 * @see #getDimensionPixelSize
 * @apiSince 1
 */

public int getDimensionPixelOffset(int index, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a dimensional unit attribute at <var>index</var> for use
 * as a size in raw pixels.  This is the same as
 * {@link #getDimension}, except the returned value is converted to
 * integer pixels for use as a size.  A size conversion involves
 * rounding the base value, and ensuring that a non-zero base value
 * is at least one pixel in size.
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not a dimension.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 not a resource.
 *
 * @return Attribute dimension value multiplied by the appropriate
 *         metric and truncated to integer pixels, or defValue if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not a dimension.
 *
 * @see #getDimension
 * @see #getDimensionPixelOffset
 * @apiSince 1
 */

public int getDimensionPixelSize(int index, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Special version of {@link #getDimensionPixelSize} for retrieving
 * {@link android.view.ViewGroup}'s layout_width and layout_height
 * attributes.  This is only here for performance reasons; applications
 * should use {@link #getDimensionPixelSize}.
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not a dimension or integer (enum).
 *
 * @param index Index of the attribute to retrieve.
 * @param name Textual name of attribute for error reporting.
 *
 * @return Attribute dimension value multiplied by the appropriate
 *         metric and truncated to integer pixels.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not a dimension or integer (enum).
 * @apiSince 1
 */

public int getLayoutDimension(int index, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Special version of {@link #getDimensionPixelSize} for retrieving
 * {@link android.view.ViewGroup}'s layout_width and layout_height
 * attributes.  This is only here for performance reasons; applications
 * should use {@link #getDimensionPixelSize}.
 *
 * @param index Index of the attribute to retrieve.
 * @param defValue The default value to return if this attribute is not
 *                 default or contains the wrong type of data.
 *
 * @return Attribute dimension value multiplied by the appropriate
 *         metric and truncated to integer pixels.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 3
 */

public int getLayoutDimension(int index, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a fractional unit attribute at <var>index</var>.
 *
 * @param index Index of attribute to retrieve.
 * @param base The base value of this fraction.  In other words, a
 *             standard fraction is multiplied by this value.
 * @param pbase The parent base value of this fraction.  In other
 *             words, a parent fraction (nn%p) is multiplied by this
 *             value.
 * @param defValue Value to return if the attribute is not defined or
 *                 not a resource.
 *
 * @return Attribute fractional value multiplied by the appropriate
 *         base value, or defValue if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not a fraction.
 * @apiSince 1
 */

public float getFraction(int index, int base, int pbase, float defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the resource identifier for the attribute at
 * <var>index</var>.  Note that attribute resource as resolved when
 * the overall {@link android.content.res.TypedArray TypedArray} object is retrieved.  As a
 * result, this function will return the resource identifier of the
 * final resource value that was found, <em>not</em> necessarily the
 * original resource that was specified by the attribute.
 *
 * @param index Index of attribute to retrieve.
 * @param defValue Value to return if the attribute is not defined or
 *                 not a resource.
 *
 * @return Attribute resource identifier, or defValue if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public int getResourceId(int index, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the Drawable for the attribute at <var>index</var>.
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not a color or drawable resource.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return Drawable for the attribute, or {@code null} if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not a color or drawable resource.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getDrawable(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the Typeface for the attribute at <var>index</var>.
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not a font.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return Typeface for the attribute, or {@code null} if not defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @throws java.lang.UnsupportedOperationException if the attribute is defined but is
 *         not a font resource.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.graphics.Typeface getFont(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the CharSequence[] for the attribute at <var>index</var>.
 * This gets the resource ID of the selected attribute, and uses
 * {@link android.content.res.Resources#getTextArray Resources#getTextArray} of the owning
 * Resources object to retrieve its String[].
 * <p>
 * This method will throw an exception if the attribute is defined but is
 * not a text array resource.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return CharSequence[] for the attribute, or {@code null} if not
 *         defined.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public java.lang.CharSequence[] getTextArray(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the raw TypedValue for the attribute at <var>index</var>.
 *
 * @param index Index of attribute to retrieve.
 * @param outValue TypedValue object in which to place the attribute's
 *                 data.
 *
 * @return {@code true} if the value was retrieved and not @empty, {@code false} otherwise.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public boolean getValue(int index, android.util.TypedValue outValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of attribute at the specified index.
 *
 * @param index Index of attribute whose type to retrieve.
 *
 * @return Attribute type.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 21
 */

public int getType(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the resource ID of the style or layout against which the specified attribute was
 * resolved, otherwise returns defValue.
 *
 * For example, if you we resolving two attributes {@code android:attribute1} and
 * {@code android:attribute2} and you were inflating a {@link android.view.View} from
 * {@code layout/my_layout.xml}:
 * <pre>
 *     &lt;View
 *         style="@style/viewStyle"
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:attribute1="foo"/&gt;
 * </pre>
 *
 * and {@code @style/viewStyle} is:
 * <pre>
 *     &lt;style android:name="viewStyle"&gt;
 *         &lt;item name="android:attribute2"&gt;bar&lt;item/&gt;
 *     &lt;style/&gt;
 * </pre>
 *
 * then resolved {@link android.content.res.TypedArray TypedArray} will have values that return source resource ID of
 * {@code R.layout.my_layout} for {@code android:attribute1} and {@code R.style.viewStyle} for
 * {@code android:attribute2}.
 *
 * @param index Index of attribute whose source style to retrieve.
 * @param defaultValue Value to return if the attribute is not defined or
 *                     not a resource.
 *
 * @return Either a style resource ID, layout resource ID, or defaultValue if it was not
 * resolved in a style or layout.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 29
 */

public int getSourceResourceId(int index, int defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether there is an attribute at <var>index</var>.
 * <p>
 * <strong>Note:</strong> If the attribute was set to {@code @empty} or
 * {@code @undefined}, this method returns {@code false}.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return True if the attribute has a value, false otherwise.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public boolean hasValue(int index) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether there is an attribute at <var>index</var>, returning
 * {@code true} if the attribute was explicitly set to {@code @empty} and
 * {@code false} only if the attribute was undefined.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return True if the attribute has a value or is empty, false otherwise.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 22
 */

public boolean hasValueOrEmpty(int index) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the raw TypedValue for the attribute at <var>index</var>
 * and return a temporary object holding its data.  This object is only
 * valid until the next call on to {@link android.content.res.TypedArray TypedArray}.
 *
 * @param index Index of attribute to retrieve.
 *
 * @return Returns a TypedValue object if the attribute is defined,
 *         containing its data; otherwise returns null.  (You will not
 *         receive a TypedValue whose type is TYPE_NULL.)
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public android.util.TypedValue peekValue(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns a message about the parser state suitable for printing error messages.
 *
 * @return Human-readable description of current parser state.
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public java.lang.String getPositionDescription() { throw new RuntimeException("Stub!"); }

/**
 * Recycles the TypedArray, to be re-used by a later caller. After calling
 * this function you must not ever touch the typed array again.
 *
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @apiSince 1
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * Return a mask of the configuration parameters for which the values in
 * this typed array may change.
 *
 * @return Returns a mask of the changing configuration parameters, as
 *         defined by {@link android.content.pm.ActivityInfo}.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @throws java.lang.RuntimeException if the TypedArray has already been recycled.
 * @see android.content.pm.ActivityInfo
 * @apiSince 21
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

