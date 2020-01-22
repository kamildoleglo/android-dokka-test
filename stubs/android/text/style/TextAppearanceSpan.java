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


package android.text.style;

import android.os.LocaleList;

/**
 * Sets the text appearance using the given
 * {@link android.R.styleable#TextAppearance TextAppearance} attributes.
 * By default {@link android.text.style.TextAppearanceSpan TextAppearanceSpan} only changes the specified attributes in XML.
 * {@link android.R.styleable#TextAppearance_textColorHighlight textColorHighlight},
 * {@link android.R.styleable#TextAppearance_textColorHint textColorHint},
 * {@link android.R.styleable#TextAppearance_textAllCaps textAllCaps} and
 * {@link android.R.styleable#TextAppearance_fallbackLineSpacing fallbackLineSpacing}
 * are not supported by {@link android.text.style.TextAppearanceSpan TextAppearanceSpan}.
 *
 * {@see android.widget.TextView#setTextAppearance(int)}
 *
 * @attr ref android.R.styleable#TextAppearance_fontFamily
 * @attr ref android.R.styleable#TextAppearance_textColor
 * @attr ref android.R.styleable#TextAppearance_textColorLink
 * @attr ref android.R.styleable#TextAppearance_textFontWeight
 * @attr ref android.R.styleable#TextAppearance_textSize
 * @attr ref android.R.styleable#TextAppearance_textStyle
 * @attr ref android.R.styleable#TextAppearance_typeface
 * @attr ref android.R.styleable#TextAppearance_shadowColor
 * @attr ref android.R.styleable#TextAppearance_shadowDx
 * @attr ref android.R.styleable#TextAppearance_shadowDy
 * @attr ref android.R.styleable#TextAppearance_shadowRadius
 * @attr ref android.R.styleable#TextAppearance_elegantTextHeight
 * @attr ref android.R.styleable#TextAppearance_letterSpacing
 * @attr ref android.R.styleable#TextAppearance_fontFeatureSettings
 * @attr ref android.R.styleable#TextAppearance_fontVariationSettings
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextAppearanceSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Uses the specified TextAppearance resource to determine the
 * text appearance.  The <code>appearance</code> should be, for example,
 * <code>android.R.style.TextAppearance_Small</code>.
 * @apiSince 1
 */

public TextAppearanceSpan(android.content.Context context, int appearance) { throw new RuntimeException("Stub!"); }

/**
 * Uses the specified TextAppearance resource to determine the
 * text appearance, and the specified text color resource
 * to determine the color.  The <code>appearance</code> should be,
 * for example, <code>android.R.style.TextAppearance_Small</code>,
 * and the <code>colorList</code> should be, for example,
 * <code>android.R.styleable.Theme_textColorPrimary</code>.
 * @apiSince 1
 */

public TextAppearanceSpan(android.content.Context context, int appearance, int colorList) { throw new RuntimeException("Stub!"); }

/**
 * Makes text be drawn with the specified typeface, size, style,
 * and colors.
 * @apiSince 1
 */

public TextAppearanceSpan(java.lang.String family, int style, int size, android.content.res.ColorStateList color, android.content.res.ColorStateList linkColor) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public TextAppearanceSpan(android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the typeface family specified by this span, or <code>null</code>
 * if it does not specify one.
 * @apiSince 1
 */

public java.lang.String getFamily() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text color specified by this span, or <code>null</code>
 * if it does not specify one.
 * @apiSince 1
 */

public android.content.res.ColorStateList getTextColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the link color specified by this span, or <code>null</code>
 * if it does not specify one.
 * @apiSince 1
 */

public android.content.res.ColorStateList getLinkTextColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text size specified by this span, or <code>-1</code>
 * if it does not specify one.
 * @apiSince 1
 */

public int getTextSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text style specified by this span, or <code>0</code>
 * if it does not specify one.
 * @apiSince 1
 */

public int getTextStyle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text font weight specified by this span, or <code>-1</code>
 * if it does not specify one.
 * @apiSince 29
 */

public int getTextFontWeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.os.LocaleList} specified by this span, or <code>null</code>
 * if it does not specify one.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.LocaleList getTextLocales() { throw new RuntimeException("Stub!"); }

/**
 * Returns the typeface specified by this span, or <code>null</code>
 * if it does not specify one.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.Typeface getTypeface() { throw new RuntimeException("Stub!"); }

/**
 * Returns the color of the text shadow specified by this span, or <code>0</code>
 * if it does not specify one.
 * @apiSince 29
 */

public int getShadowColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the horizontal offset of the text shadow specified by this span, or <code>0.0f</code>
 * if it does not specify one.
 * @apiSince 29
 */

public float getShadowDx() { throw new RuntimeException("Stub!"); }

/**
 * Returns the vertical offset of the text shadow specified by this span, or <code>0.0f</code>
 * if it does not specify one.
 * @apiSince 29
 */

public float getShadowDy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the blur radius of the text shadow specified by this span, or <code>0.0f</code>
 * if it does not specify one.
 * @apiSince 29
 */

public float getShadowRadius() { throw new RuntimeException("Stub!"); }

/**
 * Returns the font feature settings specified by this span, or <code>null</code>
 * if it does not specify one.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getFontFeatureSettings() { throw new RuntimeException("Stub!"); }

/**
 * Returns the font variation settings specified by this span, or <code>null</code>
 * if it does not specify one.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getFontVariationSettings() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of elegant height metrics flag specified by this span,
 * or <code>false</code> if it does not specify one.
 * @apiSince 29
 */

public boolean isElegantTextHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void updateDrawState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void updateMeasureState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

