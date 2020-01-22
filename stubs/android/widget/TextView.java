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

import android.app.Activity;
import android.R;
import android.os.Bundle;
import android.view.View;
import android.util.TypedValue;
import android.graphics.Typeface;
import android.graphics.Paint;
import android.text.method.KeyListener;
import android.text.Spannable;
import android.text.Editable;
import android.text.Layout;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.BlendMode;
import android.text.util.Linkify;
import java.util.Locale;
import android.os.LocaleList;
import android.text.StaticLayout;
import android.text.PrecomputedText;
import android.graphics.fonts.FontVariationAxis;
import android.content.Context;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.Spanned;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.CorrectionInfo;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.inputmethod.BaseInputConnection;
import android.text.style.SuggestionSpan;
import android.view.ActionMode;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextClassificationManager;
import android.view.MotionEvent;
import android.text.TextDirectionHeuristic;

/**
 * A user interface element that displays text to the user.
 * To provide user-editable text, see {@link android.widget.EditText EditText}.
 * <p>
 * The following code sample shows a typical use, with an XML layout
 * and code to modify the contents of the text view:
 * </p>
 
 * <pre>
 * &lt;LinearLayout
      xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="match_parent"&gt;
 *    &lt;TextView
 *        android:id="@+id/text_view_id"
 *        android:layout_height="wrap_content"
 *        android:layout_width="wrap_content"
 *        android:text="@string/hello" /&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 * <p>
 * This code sample demonstrates how to modify the contents of the text view
 * defined in the previous XML layout:
 * </p>
 * <pre>
 * public class MainActivity extends Activity {
 *
 *    protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.activity_main);
 *         final TextView helloTextView = (TextView) findViewById(R.id.text_view_id);
 *         helloTextView.setText(R.string.user_greeting);
 *     }
 * }
 * </pre>
 * <p>
 * To customize the appearance of TextView, see <a href="https://developer.android.com/guide/topics/ui/themes.html">Styles and Themes</a>.
 * </p>
 * <p>
 * <b>XML attributes</b>
 * <p>
 * See {@link android.R.styleable#TextView TextView Attributes},
 * {@link android.R.styleable#View View Attributes}
 *
 * @attr ref android.R.styleable#TextView_text
 * @attr ref android.R.styleable#TextView_bufferType
 * @attr ref android.R.styleable#TextView_hint
 * @attr ref android.R.styleable#TextView_textColor
 * @attr ref android.R.styleable#TextView_textColorHighlight
 * @attr ref android.R.styleable#TextView_textColorHint
 * @attr ref android.R.styleable#TextView_textAppearance
 * @attr ref android.R.styleable#TextView_textColorLink
 * @attr ref android.R.styleable#TextView_textFontWeight
 * @attr ref android.R.styleable#TextView_textSize
 * @attr ref android.R.styleable#TextView_textScaleX
 * @attr ref android.R.styleable#TextView_fontFamily
 * @attr ref android.R.styleable#TextView_typeface
 * @attr ref android.R.styleable#TextView_textStyle
 * @attr ref android.R.styleable#TextView_cursorVisible
 * @attr ref android.R.styleable#TextView_maxLines
 * @attr ref android.R.styleable#TextView_maxHeight
 * @attr ref android.R.styleable#TextView_lines
 * @attr ref android.R.styleable#TextView_height
 * @attr ref android.R.styleable#TextView_minLines
 * @attr ref android.R.styleable#TextView_minHeight
 * @attr ref android.R.styleable#TextView_maxEms
 * @attr ref android.R.styleable#TextView_maxWidth
 * @attr ref android.R.styleable#TextView_ems
 * @attr ref android.R.styleable#TextView_width
 * @attr ref android.R.styleable#TextView_minEms
 * @attr ref android.R.styleable#TextView_minWidth
 * @attr ref android.R.styleable#TextView_gravity
 * @attr ref android.R.styleable#TextView_scrollHorizontally
 * @attr ref android.R.styleable#TextView_password
 * @attr ref android.R.styleable#TextView_singleLine
 * @attr ref android.R.styleable#TextView_selectAllOnFocus
 * @attr ref android.R.styleable#TextView_includeFontPadding
 * @attr ref android.R.styleable#TextView_maxLength
 * @attr ref android.R.styleable#TextView_shadowColor
 * @attr ref android.R.styleable#TextView_shadowDx
 * @attr ref android.R.styleable#TextView_shadowDy
 * @attr ref android.R.styleable#TextView_shadowRadius
 * @attr ref android.R.styleable#TextView_autoLink
 * @attr ref android.R.styleable#TextView_linksClickable
 * @attr ref android.R.styleable#TextView_numeric
 * @attr ref android.R.styleable#TextView_digits
 * @attr ref android.R.styleable#TextView_phoneNumber
 * @attr ref android.R.styleable#TextView_inputMethod
 * @attr ref android.R.styleable#TextView_capitalize
 * @attr ref android.R.styleable#TextView_autoText
 * @attr ref android.R.styleable#TextView_editable
 * @attr ref android.R.styleable#TextView_freezesText
 * @attr ref android.R.styleable#TextView_ellipsize
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableBottom
 * @attr ref android.R.styleable#TextView_drawableRight
 * @attr ref android.R.styleable#TextView_drawableLeft
 * @attr ref android.R.styleable#TextView_drawableStart
 * @attr ref android.R.styleable#TextView_drawableEnd
 * @attr ref android.R.styleable#TextView_drawablePadding
 * @attr ref android.R.styleable#TextView_drawableTint
 * @attr ref android.R.styleable#TextView_drawableTintMode
 * @attr ref android.R.styleable#TextView_lineSpacingExtra
 * @attr ref android.R.styleable#TextView_lineSpacingMultiplier
 * @attr ref android.R.styleable#TextView_justificationMode
 * @attr ref android.R.styleable#TextView_marqueeRepeatLimit
 * @attr ref android.R.styleable#TextView_inputType
 * @attr ref android.R.styleable#TextView_imeOptions
 * @attr ref android.R.styleable#TextView_privateImeOptions
 * @attr ref android.R.styleable#TextView_imeActionLabel
 * @attr ref android.R.styleable#TextView_imeActionId
 * @attr ref android.R.styleable#TextView_editorExtras
 * @attr ref android.R.styleable#TextView_elegantTextHeight
 * @attr ref android.R.styleable#TextView_fallbackLineSpacing
 * @attr ref android.R.styleable#TextView_letterSpacing
 * @attr ref android.R.styleable#TextView_fontFeatureSettings
 * @attr ref android.R.styleable#TextView_fontVariationSettings
 * @attr ref android.R.styleable#TextView_breakStrategy
 * @attr ref android.R.styleable#TextView_hyphenationFrequency
 * @attr ref android.R.styleable#TextView_autoSizeTextType
 * @attr ref android.R.styleable#TextView_autoSizeMinTextSize
 * @attr ref android.R.styleable#TextView_autoSizeMaxTextSize
 * @attr ref android.R.styleable#TextView_autoSizeStepGranularity
 * @attr ref android.R.styleable#TextView_autoSizePresetSizes
 * @attr ref android.R.styleable#TextView_textCursorDrawable
 * @attr ref android.R.styleable#TextView_textSelectHandle
 * @attr ref android.R.styleable#TextView_textSelectHandleLeft
 * @attr ref android.R.styleable#TextView_textSelectHandleRight
 * @attr ref android.R.styleable#TextView_allowUndo
 * @attr ref android.R.styleable#TextView_enabled
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class TextView extends android.view.View implements android.view.ViewTreeObserver.OnPreDrawListener {

/** @apiSince 1 */

public TextView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public TextView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public TextView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 21
 */

public TextView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit
 * within the layout bounds by using the default auto-size configuration.
 *
 * @param autoSizeTextType the type of auto-size. Must be one of
 *        {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_NONE TextView#AUTO_SIZE_TEXT_TYPE_NONE} or
 *        {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_UNIFORM TextView#AUTO_SIZE_TEXT_TYPE_UNIFORM}
 *
 * Value is {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_NONE}, or {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_UNIFORM}
 * @throws java.lang.IllegalArgumentException if <code>autoSizeTextType</code> is none of the types above.
 *
 * @attr ref android.R.styleable#TextView_autoSizeTextType
 *
 * @see #getAutoSizeTextType()
 * @apiSince 26
 */

public void setAutoSizeTextTypeWithDefaults(int autoSizeTextType) { throw new RuntimeException("Stub!"); }

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit
 * within the layout bounds. If all the configuration params are valid the type of auto-size is
 * set to {@link #AUTO_SIZE_TEXT_TYPE_UNIFORM}.
 *
 * @param autoSizeMinTextSize the minimum text size available for auto-size
 * @param autoSizeMaxTextSize the maximum text size available for auto-size
 * @param autoSizeStepGranularity the auto-size step granularity. It is used in conjunction with
 *                                the minimum and maximum text size in order to build the set of
 *                                text sizes the system uses to choose from when auto-sizing
 * @param unit the desired dimension unit for all sizes above. See {@link android.util.TypedValue TypedValue} for the
 *             possible dimension units
 *
 * @throws java.lang.IllegalArgumentException if any of the configuration params are invalid.
 *
 * @attr ref android.R.styleable#TextView_autoSizeTextType
 * @attr ref android.R.styleable#TextView_autoSizeMinTextSize
 * @attr ref android.R.styleable#TextView_autoSizeMaxTextSize
 * @attr ref android.R.styleable#TextView_autoSizeStepGranularity
 *
 * @see #setAutoSizeTextTypeWithDefaults(int)
 * @see #setAutoSizeTextTypeUniformWithPresetSizes(int[], int)
 * @see #getAutoSizeMinTextSize()
 * @see #getAutoSizeMaxTextSize()
 * @see #getAutoSizeStepGranularity()
 * @see #getAutoSizeTextAvailableSizes()
 * @apiSince 26
 */

public void setAutoSizeTextTypeUniformWithConfiguration(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) { throw new RuntimeException("Stub!"); }

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit
 * within the layout bounds. If at least one value from the <code>presetSizes</code> is valid
 * then the type of auto-size is set to {@link #AUTO_SIZE_TEXT_TYPE_UNIFORM}.
 *
 * @param presetSizes an {@code int} array of sizes in pixels
 * This value must never be {@code null}.
 * @param unit the desired dimension unit for the preset sizes above. See {@link android.util.TypedValue TypedValue} for
 *             the possible dimension units
 *
 * @throws java.lang.IllegalArgumentException if all of the <code>presetSizes</code> are invalid.
 *
 * @attr ref android.R.styleable#TextView_autoSizeTextType
 * @attr ref android.R.styleable#TextView_autoSizePresetSizes
 *
 * @see #setAutoSizeTextTypeWithDefaults(int)
 * @see #setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int)
 * @see #getAutoSizeMinTextSize()
 * @see #getAutoSizeMaxTextSize()
 * @see #getAutoSizeTextAvailableSizes()
 * @apiSince 26
 */

public void setAutoSizeTextTypeUniformWithPresetSizes(@androidx.annotation.NonNull int[] presetSizes, int unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of auto-size set for this widget.
 *
 * @return an {@code int} corresponding to one of the auto-size types:
 *         {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_NONE TextView#AUTO_SIZE_TEXT_TYPE_NONE} or
 *         {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_UNIFORM TextView#AUTO_SIZE_TEXT_TYPE_UNIFORM}
 *
 * Value is {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_NONE}, or {@link android.widget.TextView#AUTO_SIZE_TEXT_TYPE_UNIFORM}
 * @attr ref android.R.styleable#TextView_autoSizeTextType
 *
 * @see #setAutoSizeTextTypeWithDefaults(int)
 * @see #setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int)
 * @see #setAutoSizeTextTypeUniformWithPresetSizes(int[], int)
 * @apiSince 26
 */

public int getAutoSizeTextType() { throw new RuntimeException("Stub!"); }

/**
 * @return the current auto-size step granularity in pixels.
 *
 * @attr ref android.R.styleable#TextView_autoSizeStepGranularity
 *
 * @see #setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int)
 * @apiSince 26
 */

public int getAutoSizeStepGranularity() { throw new RuntimeException("Stub!"); }

/**
 * @return the current auto-size minimum text size in pixels (the default is 12sp). Note that
 *         if auto-size has not been configured this function returns {@code -1}.
 *
 * @attr ref android.R.styleable#TextView_autoSizeMinTextSize
 *
 * @see #setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int)
 * @see #setAutoSizeTextTypeUniformWithPresetSizes(int[], int)
 * @apiSince 26
 */

public int getAutoSizeMinTextSize() { throw new RuntimeException("Stub!"); }

/**
 * @return the current auto-size maximum text size in pixels (the default is 112sp). Note that
 *         if auto-size has not been configured this function returns {@code -1}.
 *
 * @attr ref android.R.styleable#TextView_autoSizeMaxTextSize
 *
 * @see #setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int)
 * @see #setAutoSizeTextTypeUniformWithPresetSizes(int[], int)
 * @apiSince 26
 */

public int getAutoSizeMaxTextSize() { throw new RuntimeException("Stub!"); }

/**
 * @return the current auto-size {@code int} sizes array (in pixels).
 *
 * @see #setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int)
 * @see #setAutoSizeTextTypeUniformWithPresetSizes(int[], int)
 * @apiSince 26
 */

public int[] getAutoSizeTextAvailableSizes() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets the typeface and style in which the text should be displayed,
 * and turns on the fake bold and italic bits in the Paint if the
 * Typeface that you provided does not have all the bits in the
 * style that you specified.
 *
 * @attr ref android.R.styleable#TextView_typeface
 * @attr ref android.R.styleable#TextView_textStyle
 
 * @param tf This value may be {@code null}.
 
 * @param style Value is {@link android.graphics.Typeface#NORMAL}, {@link android.graphics.Typeface#BOLD}, {@link android.graphics.Typeface#ITALIC}, or {@link android.graphics.Typeface#BOLD_ITALIC}
 * @apiSince 1
 */

public void setTypeface(@androidx.annotation.Nullable android.graphics.Typeface tf, int style) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses override this to specify that they have a KeyListener
 * by default even if not specifically called for in the XML options.
 * @apiSince 1
 */

protected boolean getDefaultEditable() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses override this to specify a default movement method.
 * @apiSince 1
 */

protected android.text.method.MovementMethod getDefaultMovementMethod() { throw new RuntimeException("Stub!"); }

/**
 * Return the text that TextView is displaying. If {@link #setText(java.lang.CharSequence)} was called
 * with an argument of {@link android.widget.TextView.BufferType#SPANNABLE BufferType.SPANNABLE}
 * or {@link android.widget.TextView.BufferType#EDITABLE BufferType.EDITABLE}, you can cast
 * the return value from this method to Spannable or Editable, respectively.
 *
 * <p>The content of the return value should not be modified. If you want a modifiable one, you
 * should make your own copy first.</p>
 *
 * @return The text displayed by the text view.
 * @attr ref android.R.styleable#TextView_text
 * @apiSince 1
 */

@android.view.ViewDebug.CapturedViewProperty
public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length, in characters, of the text managed by this TextView
 * @return The length of the text managed by the TextView in characters.
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Return the text that TextView is displaying as an Editable object. If the text is not
 * editable, null is returned.
 *
 * @see #getText
 * @apiSince 3
 */

public android.text.Editable getEditableText() { throw new RuntimeException("Stub!"); }

/**
 * Gets the vertical distance between lines of text, in pixels.
 * Note that markup within the text can cause individual lines
 * to be taller or shorter than this height, and the layout may
 * contain additional first-or last-line padding.
 * @return The height of one standard line in pixels.
 * @apiSince 1
 */

public int getLineHeight() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.text.Layout} that is currently being used to display the text.
 * This value can be null if the text or width has recently changed.
 * @return The Layout that is currently being used to display the text.
 * @apiSince 1
 */

public final android.text.Layout getLayout() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current {@link android.text.method.KeyListener KeyListener} for the TextView.
 * This will frequently be null for non-EditText TextViews.
 * @return the current key listener for this TextView.
 *
 * @attr ref android.R.styleable#TextView_numeric
 * @attr ref android.R.styleable#TextView_digits
 * @attr ref android.R.styleable#TextView_phoneNumber
 * @attr ref android.R.styleable#TextView_inputMethod
 * @attr ref android.R.styleable#TextView_capitalize
 * @attr ref android.R.styleable#TextView_autoText
 * @apiSince 1
 */

public final android.text.method.KeyListener getKeyListener() { throw new RuntimeException("Stub!"); }

/**
 * Sets the key listener to be used with this TextView.  This can be null
 * to disallow user input.  Note that this method has significant and
 * subtle interactions with soft keyboards and other input method:
 * see {@link android.text.method.KeyListener#getInputType() KeyListener#getInputType()}
 * for important details.  Calling this method will replace the current
 * content type of the text view with the content type returned by the
 * key listener.
 * <p>
 * Be warned that if you want a TextView with a key listener or movement
 * method not to be focusable, or if you want a TextView without a
 * key listener or movement method to be focusable, you must call
 * {@link #setFocusable} again after calling this to get the focusability
 * back the way you want it.
 *
 * @attr ref android.R.styleable#TextView_numeric
 * @attr ref android.R.styleable#TextView_digits
 * @attr ref android.R.styleable#TextView_phoneNumber
 * @attr ref android.R.styleable#TextView_inputMethod
 * @attr ref android.R.styleable#TextView_capitalize
 * @attr ref android.R.styleable#TextView_autoText
 * @apiSince 1
 */

public void setKeyListener(android.text.method.KeyListener input) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.text.method.MovementMethod} being used for this TextView,
 * which provides positioning, scrolling, and text selection functionality.
 * This will frequently be null for non-EditText TextViews.
 * @return the movement method being used for this TextView.
 * @see android.text.method.MovementMethod
 * @apiSince 1
 */

public final android.text.method.MovementMethod getMovementMethod() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.text.method.MovementMethod} for handling arrow key movement
 * for this TextView. This can be null to disallow using the arrow keys to move the
 * cursor or scroll the view.
 * <p>
 * Be warned that if you want a TextView with a key listener or movement
 * method not to be focusable, or if you want a TextView without a
 * key listener or movement method to be focusable, you must call
 * {@link #setFocusable} again after calling this to get the focusability
 * back the way you want it.
 * @apiSince 1
 */

public final void setMovementMethod(android.text.method.MovementMethod movement) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current {@link android.text.method.TransformationMethod} for the TextView.
 * This is frequently null, except for single-line and password fields.
 * @return the current transformation method for this TextView.
 *
 * @attr ref android.R.styleable#TextView_password
 * @attr ref android.R.styleable#TextView_singleLine
 * @apiSince 1
 */

public final android.text.method.TransformationMethod getTransformationMethod() { throw new RuntimeException("Stub!"); }

/**
 * Sets the transformation that is applied to the text that this
 * TextView is displaying.
 *
 * @attr ref android.R.styleable#TextView_password
 * @attr ref android.R.styleable#TextView_singleLine
 * @apiSince 1
 */

public final void setTransformationMethod(android.text.method.TransformationMethod method) { throw new RuntimeException("Stub!"); }

/**
 * Returns the top padding of the view, plus space for the top
 * Drawable if any.
 * @apiSince 1
 */

public int getCompoundPaddingTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bottom padding of the view, plus space for the bottom
 * Drawable if any.
 * @apiSince 1
 */

public int getCompoundPaddingBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns the left padding of the view, plus space for the left
 * Drawable if any.
 * @apiSince 1
 */

public int getCompoundPaddingLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right padding of the view, plus space for the right
 * Drawable if any.
 * @apiSince 1
 */

public int getCompoundPaddingRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start padding of the view, plus space for the start
 * Drawable if any.
 * @apiSince 17
 */

public int getCompoundPaddingStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end padding of the view, plus space for the end
 * Drawable if any.
 * @apiSince 17
 */

public int getCompoundPaddingEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extended top padding of the view, including both the
 * top Drawable if any and any extra space to keep more than maxLines
 * of text from showing.  It is only valid to call this after measuring.
 * @apiSince 1
 */

public int getExtendedPaddingTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extended bottom padding of the view, including both the
 * bottom Drawable if any and any extra space to keep more than maxLines
 * of text from showing.  It is only valid to call this after measuring.
 * @apiSince 1
 */

public int getExtendedPaddingBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total left padding of the view, including the left
 * Drawable if any.
 * @apiSince 1
 */

public int getTotalPaddingLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total right padding of the view, including the right
 * Drawable if any.
 * @apiSince 1
 */

public int getTotalPaddingRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total start padding of the view, including the start
 * Drawable if any.
 * @apiSince 17
 */

public int getTotalPaddingStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total end padding of the view, including the end
 * Drawable if any.
 * @apiSince 17
 */

public int getTotalPaddingEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total top padding of the view, including the top
 * Drawable if any, the extra space to keep more than maxLines
 * from showing, and the vertical offset for gravity, if any.
 * @apiSince 1
 */

public int getTotalPaddingTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total bottom padding of the view, including the bottom
 * Drawable if any, the extra space to keep more than maxLines
 * from showing, and the vertical offset for gravity, if any.
 * @apiSince 1
 */

public int getTotalPaddingBottom() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawables (if any) to appear to the left of, above, to the
 * right of, and below the text. Use {@code null} if you do not want a
 * Drawable there. The Drawables must already have had
 * {@link android.graphics.drawable.Drawable#setBounds Drawable#setBounds} called.
 * <p>
 * Calling this method will overwrite any Drawables previously set using
 * {@link #setCompoundDrawablesRelative} or related methods.
 *
 * @attr ref android.R.styleable#TextView_drawableLeft
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableRight
 * @attr ref android.R.styleable#TextView_drawableBottom
 
 * @param left This value may be {@code null}.
 
 * @param top This value may be {@code null}.
 
 * @param right This value may be {@code null}.
 
 * @param bottom This value may be {@code null}.
 * @apiSince 1
 */

public void setCompoundDrawables(@androidx.annotation.Nullable android.graphics.drawable.Drawable left, @androidx.annotation.Nullable android.graphics.drawable.Drawable top, @androidx.annotation.Nullable android.graphics.drawable.Drawable right, @androidx.annotation.Nullable android.graphics.drawable.Drawable bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawables (if any) to appear to the left of, above, to the
 * right of, and below the text. Use 0 if you do not want a Drawable there.
 * The Drawables' bounds will be set to their intrinsic bounds.
 * <p>
 * Calling this method will overwrite any Drawables previously set using
 * {@link #setCompoundDrawablesRelative} or related methods.
 *
 * @param left Resource identifier of the left Drawable.
 * @param top Resource identifier of the top Drawable.
 * @param right Resource identifier of the right Drawable.
 * @param bottom Resource identifier of the bottom Drawable.
 *
 * @attr ref android.R.styleable#TextView_drawableLeft
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableRight
 * @attr ref android.R.styleable#TextView_drawableBottom
 * @apiSince 3
 */

public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawables (if any) to appear to the left of, above, to the
 * right of, and below the text. Use {@code null} if you do not want a
 * Drawable there. The Drawables' bounds will be set to their intrinsic
 * bounds.
 * <p>
 * Calling this method will overwrite any Drawables previously set using
 * {@link #setCompoundDrawablesRelative} or related methods.
 *
 * @attr ref android.R.styleable#TextView_drawableLeft
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableRight
 * @attr ref android.R.styleable#TextView_drawableBottom
 
 * @param left This value may be {@code null}.
 
 * @param top This value may be {@code null}.
 
 * @param right This value may be {@code null}.
 
 * @param bottom This value may be {@code null}.
 * @apiSince 1
 */

public void setCompoundDrawablesWithIntrinsicBounds(@androidx.annotation.Nullable android.graphics.drawable.Drawable left, @androidx.annotation.Nullable android.graphics.drawable.Drawable top, @androidx.annotation.Nullable android.graphics.drawable.Drawable right, @androidx.annotation.Nullable android.graphics.drawable.Drawable bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawables (if any) to appear to the start of, above, to the end
 * of, and below the text. Use {@code null} if you do not want a Drawable
 * there. The Drawables must already have had {@link android.graphics.drawable.Drawable#setBounds Drawable#setBounds}
 * called.
 * <p>
 * Calling this method will overwrite any Drawables previously set using
 * {@link #setCompoundDrawables} or related methods.
 *
 * @attr ref android.R.styleable#TextView_drawableStart
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableEnd
 * @attr ref android.R.styleable#TextView_drawableBottom
 
 * @param start This value may be {@code null}.
 
 * @param top This value may be {@code null}.
 
 * @param end This value may be {@code null}.
 
 * @param bottom This value may be {@code null}.
 * @apiSince 17
 */

public void setCompoundDrawablesRelative(@androidx.annotation.Nullable android.graphics.drawable.Drawable start, @androidx.annotation.Nullable android.graphics.drawable.Drawable top, @androidx.annotation.Nullable android.graphics.drawable.Drawable end, @androidx.annotation.Nullable android.graphics.drawable.Drawable bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawables (if any) to appear to the start of, above, to the end
 * of, and below the text. Use 0 if you do not want a Drawable there. The
 * Drawables' bounds will be set to their intrinsic bounds.
 * <p>
 * Calling this method will overwrite any Drawables previously set using
 * {@link #setCompoundDrawables} or related methods.
 *
 * @param start Resource identifier of the start Drawable.
 * @param top Resource identifier of the top Drawable.
 * @param end Resource identifier of the end Drawable.
 * @param bottom Resource identifier of the bottom Drawable.
 *
 * @attr ref android.R.styleable#TextView_drawableStart
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableEnd
 * @attr ref android.R.styleable#TextView_drawableBottom
 * @apiSince 17
 */

public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawables (if any) to appear to the start of, above, to the end
 * of, and below the text. Use {@code null} if you do not want a Drawable
 * there. The Drawables' bounds will be set to their intrinsic bounds.
 * <p>
 * Calling this method will overwrite any Drawables previously set using
 * {@link #setCompoundDrawables} or related methods.
 *
 * @attr ref android.R.styleable#TextView_drawableStart
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableEnd
 * @attr ref android.R.styleable#TextView_drawableBottom
 
 * @param start This value may be {@code null}.
 
 * @param top This value may be {@code null}.
 
 * @param end This value may be {@code null}.
 
 * @param bottom This value may be {@code null}.
 * @apiSince 17
 */

public void setCompoundDrawablesRelativeWithIntrinsicBounds(@androidx.annotation.Nullable android.graphics.drawable.Drawable start, @androidx.annotation.Nullable android.graphics.drawable.Drawable top, @androidx.annotation.Nullable android.graphics.drawable.Drawable end, @androidx.annotation.Nullable android.graphics.drawable.Drawable bottom) { throw new RuntimeException("Stub!"); }

/**
 * Returns drawables for the left, top, right, and bottom borders.
 *
 * @attr ref android.R.styleable#TextView_drawableLeft
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableRight
 * @attr ref android.R.styleable#TextView_drawableBottom
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable[] getCompoundDrawables() { throw new RuntimeException("Stub!"); }

/**
 * Returns drawables for the start, top, end, and bottom borders.
 *
 * @attr ref android.R.styleable#TextView_drawableStart
 * @attr ref android.R.styleable#TextView_drawableTop
 * @attr ref android.R.styleable#TextView_drawableEnd
 * @attr ref android.R.styleable#TextView_drawableBottom
 
 * @return This value will never be {@code null}.
 * @apiSince 17
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Drawable[] getCompoundDrawablesRelative() { throw new RuntimeException("Stub!"); }

/**
 * Sets the size of the padding between the compound drawables and
 * the text.
 *
 * @attr ref android.R.styleable#TextView_drawablePadding
 * @apiSince 1
 */

public void setCompoundDrawablePadding(int pad) { throw new RuntimeException("Stub!"); }

/**
 * Returns the padding between the compound drawables and the text.
 *
 * @attr ref android.R.styleable#TextView_drawablePadding
 * @apiSince 1
 */

public int getCompoundDrawablePadding() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the compound drawables. Does not modify the
 * current tint mode, which is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to
 * {@link #setCompoundDrawables(android.graphics.drawable.Drawable,android.graphics.drawable.Drawable,android.graphics.drawable.Drawable,android.graphics.drawable.Drawable)}
 * and related methods will automatically mutate the drawables and apply
 * the specified tint and tint mode using
 * {@link android.graphics.drawable.Drawable#setTintList(android.content.res.ColorStateList) Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#TextView_drawableTint
 * @see #getCompoundDrawableTintList()
 * @see android.graphics.drawable.Drawable#setTintList(ColorStateList)
 * @apiSince 23
 */

public void setCompoundDrawableTintList(@androidx.annotation.Nullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @return the tint applied to the compound drawables
 * @attr ref android.R.styleable#TextView_drawableTint
 * @see #setCompoundDrawableTintList(ColorStateList)
 * @apiSince 23
 */

public android.content.res.ColorStateList getCompoundDrawableTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setCompoundDrawableTintList(android.content.res.ColorStateList)} to the compound
 * drawables. The default mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#TextView_drawableTintMode
 * @see #setCompoundDrawableTintList(ColorStateList)
 * @see android.graphics.drawable.Drawable#setTintMode(PorterDuff.Mode)
 * @apiSince 23
 */

public void setCompoundDrawableTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setCompoundDrawableTintList(android.content.res.ColorStateList)} to the compound
 * drawables. The default mode is {@link android.graphics.PorterDuff.Mode#SRC_IN PorterDuff.Mode#SRC_IN}.
 *
 * @param blendMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#TextView_drawableTintMode
 * @see #setCompoundDrawableTintList(ColorStateList)
 * @see android.graphics.drawable.Drawable#setTintBlendMode(BlendMode)
 * @apiSince 29
 */

public void setCompoundDrawableTintBlendMode(@androidx.annotation.Nullable android.graphics.BlendMode blendMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the compound
 * drawables, if specified.
 *
 * @return the blending mode used to apply the tint to the compound
 *         drawables
 * @attr ref android.R.styleable#TextView_drawableTintMode
 * @see #setCompoundDrawableTintMode(PorterDuff.Mode)
 *
 * @apiSince 23
 */

public android.graphics.PorterDuff.Mode getCompoundDrawableTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the compound
 * drawables, if specified.
 *
 * @return the blending mode used to apply the tint to the compound
 *         drawables
 * This value may be {@code null}.
 * @attr ref android.R.styleable#TextView_drawableTintMode
 * @see #setCompoundDrawableTintBlendMode(BlendMode)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.BlendMode getCompoundDrawableTintBlendMode() { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 *
 * @see #setFirstBaselineToTopHeight(int)
 * @see #setLastBaselineToBottomHeight(int)
 * @apiSince 1
 */

public void setPadding(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 *
 * @see #setFirstBaselineToTopHeight(int)
 * @see #setLastBaselineToBottomHeight(int)
 * @apiSince 16
 */

public void setPaddingRelative(int start, int top, int end, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Updates the top padding of the TextView so that {@code firstBaselineToTopHeight} is
 * the distance between the top of the TextView and first line's baseline.
 * <p>
 * <img src="{@docRoot}reference/android/images/text/widget/first_last_baseline.png" />
 * <figcaption>First and last baseline metrics for a TextView.</figcaption>
 *
 * <strong>Note</strong> that if {@code FontMetrics.top} or {@code FontMetrics.ascent} was
 * already greater than {@code firstBaselineToTopHeight}, the top padding is not updated.
 * Moreover since this function sets the top padding, if the height of the TextView is less than
 * the sum of top padding, line height and bottom padding, top of the line will be pushed
 * down and bottom will be clipped.
 *
 * @param firstBaselineToTopHeight distance between first baseline to top of the container
 *      in pixels
 *
 * This units of this value are pixels.
 * Value is 0 or greater
 * @see #getFirstBaselineToTopHeight()
 * @see #setLastBaselineToBottomHeight(int)
 * @see #setPadding(int, int, int, int)
 * @see #setPaddingRelative(int, int, int, int)
 *
 * @attr ref android.R.styleable#TextView_firstBaselineToTopHeight
 * @apiSince 28
 */

public void setFirstBaselineToTopHeight(int firstBaselineToTopHeight) { throw new RuntimeException("Stub!"); }

/**
 * Updates the bottom padding of the TextView so that {@code lastBaselineToBottomHeight} is
 * the distance between the bottom of the TextView and the last line's baseline.
 * <p>
 * <img src="{@docRoot}reference/android/images/text/widget/first_last_baseline.png" />
 * <figcaption>First and last baseline metrics for a TextView.</figcaption>
 *
 * <strong>Note</strong> that if {@code FontMetrics.bottom} or {@code FontMetrics.descent} was
 * already greater than {@code lastBaselineToBottomHeight}, the bottom padding is not updated.
 * Moreover since this function sets the bottom padding, if the height of the TextView is less
 * than the sum of top padding, line height and bottom padding, bottom of the text will be
 * clipped.
 *
 * @param lastBaselineToBottomHeight distance between last baseline to bottom of the container
 *      in pixels
 *
 * This units of this value are pixels.
 * Value is 0 or greater
 * @see #getLastBaselineToBottomHeight()
 * @see #setFirstBaselineToTopHeight(int)
 * @see #setPadding(int, int, int, int)
 * @see #setPaddingRelative(int, int, int, int)
 *
 * @attr ref android.R.styleable#TextView_lastBaselineToBottomHeight
 * @apiSince 28
 */

public void setLastBaselineToBottomHeight(int lastBaselineToBottomHeight) { throw new RuntimeException("Stub!"); }

/**
 * Returns the distance between the first text baseline and the top of this TextView.
 *
 * @see #setFirstBaselineToTopHeight(int)
 * @attr ref android.R.styleable#TextView_firstBaselineToTopHeight
 * @apiSince 28
 */

public int getFirstBaselineToTopHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the distance between the last text baseline and the bottom of this TextView.
 *
 * @see #setLastBaselineToBottomHeight(int)
 * @attr ref android.R.styleable#TextView_lastBaselineToBottomHeight
 * @apiSince 28
 */

public int getLastBaselineToBottomHeight() { throw new RuntimeException("Stub!"); }

/**
 * Gets the autolink mask of the text.
 *
 * See {@link android.text.util.Linkify#ALL Linkify#ALL} and peers for possible values.
 *
 * @attr ref android.R.styleable#TextView_autoLink
 * @apiSince 1
 */

public final int getAutoLinkMask() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the selection handle used for
 * positioning the cursor within text. The Drawable defaults to the value
 * of the textSelectHandle attribute.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @see #setTextSelectHandle(int)
 * @attr ref android.R.styleable#TextView_textSelectHandle
 
 * @param textSelectHandle This value must never be {@code null}.
 * @apiSince 29
 */

public void setTextSelectHandle(@androidx.annotation.NonNull android.graphics.drawable.Drawable textSelectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the selection handle used for
 * positioning the cursor within text. The Drawable defaults to the value
 * of the textSelectHandle attribute.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @see #setTextSelectHandle(Drawable)
 * @attr ref android.R.styleable#TextView_textSelectHandle
 * @apiSince 29
 */

public void setTextSelectHandle(int textSelectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Drawable corresponding to the selection handle used
 * for positioning the cursor within text.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @return the text select handle drawable
 *
 * This value may be {@code null}.
 * @see #setTextSelectHandle(Drawable)
 * @see #setTextSelectHandle(int)
 * @attr ref android.R.styleable#TextView_textSelectHandle
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getTextSelectHandle() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the left handle used
 * for selecting text. The Drawable defaults to the value of the
 * textSelectHandleLeft attribute.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @see #setTextSelectHandleLeft(int)
 * @attr ref android.R.styleable#TextView_textSelectHandleLeft
 
 * @param textSelectHandleLeft This value must never be {@code null}.
 * @apiSince 29
 */

public void setTextSelectHandleLeft(@androidx.annotation.NonNull android.graphics.drawable.Drawable textSelectHandleLeft) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the left handle used
 * for selecting text. The Drawable defaults to the value of the
 * textSelectHandleLeft attribute.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @see #setTextSelectHandleLeft(Drawable)
 * @attr ref android.R.styleable#TextView_textSelectHandleLeft
 * @apiSince 29
 */

public void setTextSelectHandleLeft(int textSelectHandleLeft) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Drawable corresponding to the left handle used
 * for selecting text.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @return the left text selection handle drawable
 *
 * This value may be {@code null}.
 * @see #setTextSelectHandleLeft(Drawable)
 * @see #setTextSelectHandleLeft(int)
 * @attr ref android.R.styleable#TextView_textSelectHandleLeft
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getTextSelectHandleLeft() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the right handle used
 * for selecting text. The Drawable defaults to the value of the
 * textSelectHandleRight attribute.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @see #setTextSelectHandleRight(int)
 * @attr ref android.R.styleable#TextView_textSelectHandleRight
 
 * @param textSelectHandleRight This value must never be {@code null}.
 * @apiSince 29
 */

public void setTextSelectHandleRight(@androidx.annotation.NonNull android.graphics.drawable.Drawable textSelectHandleRight) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the right handle used
 * for selecting text. The Drawable defaults to the value of the
 * textSelectHandleRight attribute.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @see #setTextSelectHandleRight(Drawable)
 * @attr ref android.R.styleable#TextView_textSelectHandleRight
 * @apiSince 29
 */

public void setTextSelectHandleRight(int textSelectHandleRight) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Drawable corresponding to the right handle used
 * for selecting text.
 * Note that any change applied to the handle Drawable will not be visible
 * until the handle is hidden and then drawn again.
 *
 * @return the right text selection handle drawable
 *
 * This value may be {@code null}.
 * @see #setTextSelectHandleRight(Drawable)
 * @see #setTextSelectHandleRight(int)
 * @attr ref android.R.styleable#TextView_textSelectHandleRight
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getTextSelectHandleRight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the text cursor. The Drawable defaults to the
 * value of the textCursorDrawable attribute.
 * Note that any change applied to the cursor Drawable will not be visible
 * until the cursor is hidden and then drawn again.
 *
 * @see #setTextCursorDrawable(int)
 * @attr ref android.R.styleable#TextView_textCursorDrawable
 
 * @param textCursorDrawable This value may be {@code null}.
 * @apiSince 29
 */

public void setTextCursorDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable textCursorDrawable) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Drawable corresponding to the text cursor. The Drawable defaults to the
 * value of the textCursorDrawable attribute.
 * Note that any change applied to the cursor Drawable will not be visible
 * until the cursor is hidden and then drawn again.
 *
 * @see #setTextCursorDrawable(Drawable)
 * @attr ref android.R.styleable#TextView_textCursorDrawable
 * @apiSince 29
 */

public void setTextCursorDrawable(int textCursorDrawable) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Drawable corresponding to the text cursor.
 * Note that any change applied to the cursor Drawable will not be visible
 * until the cursor is hidden and then drawn again.
 *
 * @return the text cursor drawable
 *
 * This value may be {@code null}.
 * @see #setTextCursorDrawable(Drawable)
 * @see #setTextCursorDrawable(int)
 * @attr ref android.R.styleable#TextView_textCursorDrawable
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getTextCursorDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text appearance from the specified style resource.
 * <p>
 * Use a framework-defined {@code TextAppearance} style like
 * {@link android.R.style#TextAppearance_Material_Body1 @android:style/TextAppearance.Material.Body1}
 * or see {@link android.R.styleable#TextAppearance TextAppearance} for the
 * set of attributes that can be used in a custom style.
 *
 * @param resId the resource identifier of the style to apply
 * @attr ref android.R.styleable#TextView_textAppearance
 * @apiSince 23
 */

public void setTextAppearance(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text color, size, style, hint color, and highlight color
 * from the specified TextAppearance resource.
 *
 * @deprecated Use {@link #setTextAppearance(int)} instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setTextAppearance(android.content.Context context, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Get the default primary {@link java.util.Locale Locale} of the text in this TextView. This will always be
 * the first member of {@link #getTextLocales()}.
 * @return the default primary {@link java.util.Locale Locale} of the text in this TextView.
 
 * This value will never be {@code null}.
 * @apiSince 17
 */

@androidx.annotation.NonNull
public java.util.Locale getTextLocale() { throw new RuntimeException("Stub!"); }

/**
 * Get the default {@link android.os.LocaleList LocaleList} of the text in this TextView.
 * @return the default {@link android.os.LocaleList LocaleList} of the text in this TextView.
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.os.LocaleList getTextLocales() { throw new RuntimeException("Stub!"); }

/**
 * Set the default {@link java.util.Locale Locale} of the text in this TextView to a one-member
 * {@link android.os.LocaleList LocaleList} containing just the given Locale.
 *
 * @param locale the {@link java.util.Locale Locale} for drawing text, must not be null.
 *
 * This value must never be {@code null}.
 * @see #setTextLocales
 * @apiSince 17
 */

public void setTextLocale(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Set the default {@link android.os.LocaleList LocaleList} of the text in this TextView to the given value.
 *
 * This value is used to choose appropriate typefaces for ambiguous characters (typically used
 * for CJK locales to disambiguate Hanzi/Kanji/Hanja characters). It also affects
 * other aspects of text display, including line breaking.
 *
 * @param locales the {@link android.os.LocaleList LocaleList} for drawing text, must not be null or empty.
 *
 * This value must never be {@code null}.
 * @see android.graphics.Paint#setTextLocales
 * @apiSince 24
 */

public void setTextLocales(@androidx.annotation.NonNull android.os.LocaleList locales) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

protected void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * @return the size (in pixels) of the default text size in this TextView.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="text")
public float getTextSize() { throw new RuntimeException("Stub!"); }

/**
 * Set the default text size to the given value, interpreted as "scaled
 * pixel" units.  This size is adjusted based on the current density and
 * user font size preference.
 *
 * <p>Note: if this TextView has the auto-size feature enabled than this function is no-op.
 *
 * @param size The scaled pixel size.
 *
 * @attr ref android.R.styleable#TextView_textSize
 * @apiSince 1
 */

public void setTextSize(float size) { throw new RuntimeException("Stub!"); }

/**
 * Set the default text size to a given unit and value. See {@link android.util.TypedValue TypedValue} for the possible dimension units.
 *
 * <p>Note: if this TextView has the auto-size feature enabled than this function is no-op.
 *
 * @param unit The desired dimension unit.
 * @param size The desired size in the given units.
 *
 * @attr ref android.R.styleable#TextView_textSize
 * @apiSince 1
 */

public void setTextSize(int unit, float size) { throw new RuntimeException("Stub!"); }

/**
 * Gets the extent by which text should be stretched horizontally.
 * This will usually be 1.0.
 * @return The horizontal scale factor.
 * @apiSince 1
 */

public float getTextScaleX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the horizontal scale factor for text. The default value
 * is 1.0. Values greater than 1.0 stretch the text wider.
 * Values less than 1.0 make the text narrower. By default, this value is 1.0.
 * @param size The horizontal scale factor.
 * @attr ref android.R.styleable#TextView_textScaleX
 * @apiSince 1
 */

public void setTextScaleX(float size) { throw new RuntimeException("Stub!"); }

/**
 * Sets the typeface and style in which the text should be displayed.
 * Note that not all Typeface families actually have bold and italic
 * variants, so you may need to use
 * {@link #setTypeface(android.graphics.Typeface,int)} to get the appearance
 * that you actually want.
 *
 * @see #getTypeface()
 *
 * @attr ref android.R.styleable#TextView_fontFamily
 * @attr ref android.R.styleable#TextView_typeface
 * @attr ref android.R.styleable#TextView_textStyle
 
 * @param tf This value may be {@code null}.
 * @apiSince 1
 */

public void setTypeface(@androidx.annotation.Nullable android.graphics.Typeface tf) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current {@link android.graphics.Typeface Typeface} that is used to style the text.
 * @return The current Typeface.
 *
 * @see #setTypeface(Typeface)
 *
 * @attr ref android.R.styleable#TextView_fontFamily
 * @attr ref android.R.styleable#TextView_typeface
 * @attr ref android.R.styleable#TextView_textStyle
 * @apiSince 1
 */

public android.graphics.Typeface getTypeface() { throw new RuntimeException("Stub!"); }

/**
 * Set the TextView's elegant height metrics flag. This setting selects font
 * variants that have not been compacted to fit Latin-based vertical
 * metrics, and also increases top and bottom bounds to provide more space.
 *
 * @param elegant set the paint's elegant metrics flag.
 *
 * @see #isElegantTextHeight()
 * @see android.graphics.Paint#isElegantTextHeight()
 *
 * @attr ref android.R.styleable#TextView_elegantTextHeight
 * @apiSince 21
 */

public void setElegantTextHeight(boolean elegant) { throw new RuntimeException("Stub!"); }

/**
 * Set whether to respect the ascent and descent of the fallback fonts that are used in
 * displaying the text (which is needed to avoid text from consecutive lines running into
 * each other). If set, fallback fonts that end up getting used can increase the ascent
 * and descent of the lines that they are used on.
 * <p/>
 * It is required to be true if text could be in languages like Burmese or Tibetan where text
 * is typically much taller or deeper than Latin text.
 *
 * @param enabled whether to expand linespacing based on fallback fonts, {@code true} by default
 *
 * @see android.text.StaticLayout.Builder#setUseLineSpacingFromFallbacks(boolean)
 *
 * @attr ref android.R.styleable#TextView_fallbackLineSpacing
 * @apiSince 28
 */

public void setFallbackLineSpacing(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * @return whether fallback line spacing is enabled, {@code true} by default
 *
 * @see #setFallbackLineSpacing(boolean)
 *
 * @attr ref android.R.styleable#TextView_fallbackLineSpacing
 * @apiSince 28
 */

public boolean isFallbackLineSpacing() { throw new RuntimeException("Stub!"); }

/**
 * Get the value of the TextView's elegant height metrics flag. This setting selects font
 * variants that have not been compacted to fit Latin-based vertical
 * metrics, and also increases top and bottom bounds to provide more space.
 * @return {@code true} if the elegant height metrics flag is set.
 *
 * @see #setElegantTextHeight(boolean)
 * @see android.graphics.Paint#setElegantTextHeight(boolean)
 * @apiSince 28
 */

public boolean isElegantTextHeight() { throw new RuntimeException("Stub!"); }

/**
 * Gets the text letter-space value, which determines the spacing between characters.
 * The value returned is in ems. Normally, this value is 0.0.
 * @return The text letter-space value in ems.
 *
 * @see #setLetterSpacing(float)
 * @see android.graphics.Paint#setLetterSpacing
 * @apiSince 21
 */

public float getLetterSpacing() { throw new RuntimeException("Stub!"); }

/**
 * Sets text letter-spacing in em units.  Typical values
 * for slight expansion will be around 0.05.  Negative values tighten text.
 *
 * @see #getLetterSpacing()
 * @see android.graphics.Paint#getLetterSpacing
 *
 * @param letterSpacing A text letter-space value in ems.
 * @attr ref android.R.styleable#TextView_letterSpacing
 * @apiSince 21
 */

public void setLetterSpacing(float letterSpacing) { throw new RuntimeException("Stub!"); }

/**
 * Returns the font feature settings. The format is the same as the CSS
 * font-feature-settings attribute:
 * <a href="https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop">
 *     https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop</a>
 *
 * @return the currently set font feature settings.  Default is null.
 *
 * @see #setFontFeatureSettings(String)
 * @see android.graphics.Paint#setFontFeatureSettings(String) Paint.setFontFeatureSettings(String)
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getFontFeatureSettings() { throw new RuntimeException("Stub!"); }

/**
 * Returns the font variation settings.
 *
 * @return the currently set font variation settings.  Returns null if no variation is
 * specified.
 *
 * @see #setFontVariationSettings(String)
 * @see android.graphics.Paint#setFontVariationSettings(String) Paint.setFontVariationSettings(String)
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.lang.String getFontVariationSettings() { throw new RuntimeException("Stub!"); }

/**
 * Sets the break strategy for breaking paragraphs into lines. The default value for
 * TextView is {@link android.text.Layout#BREAK_STRATEGY_HIGH_QUALITY Layout#BREAK_STRATEGY_HIGH_QUALITY}, and the default value for
 * EditText is {@link android.text.Layout#BREAK_STRATEGY_SIMPLE Layout#BREAK_STRATEGY_SIMPLE}, the latter to avoid the
 * text "dancing" when being edited.
 * <p/>
 * Enabling hyphenation with either using {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL Layout#HYPHENATION_FREQUENCY_NORMAL} or
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL Layout#HYPHENATION_FREQUENCY_FULL} while line breaking is set to one of
 * {@link android.text.Layout#BREAK_STRATEGY_BALANCED Layout#BREAK_STRATEGY_BALANCED}, {@link android.text.Layout#BREAK_STRATEGY_HIGH_QUALITY Layout#BREAK_STRATEGY_HIGH_QUALITY}
 * improves the structure of text layout however has performance impact and requires more time
 * to do the text layout.
 *
 * @attr ref android.R.styleable#TextView_breakStrategy
 * @see #getBreakStrategy()
 * @see #setHyphenationFrequency(int)
 
 * @param breakStrategy Value is {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_SIMPLE}, {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_HIGH_QUALITY}, or {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_BALANCED}
 * @apiSince 23
 */

public void setBreakStrategy(int breakStrategy) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current strategy for breaking paragraphs into lines.
 * @return the current strategy for breaking paragraphs into lines.
 *
 * Value is {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_SIMPLE}, {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_HIGH_QUALITY}, or {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_BALANCED}
 * @attr ref android.R.styleable#TextView_breakStrategy
 * @see #setBreakStrategy(int)
 * @apiSince 23
 */

public int getBreakStrategy() { throw new RuntimeException("Stub!"); }

/**
 * Sets the frequency of automatic hyphenation to use when determining word breaks.
 * The default value for both TextView and {@link android.widget.EditText EditText} is
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE Layout#HYPHENATION_FREQUENCY_NONE}. Note that the default hyphenation frequency value
 * is set from the theme.
 * <p/>
 * Enabling hyphenation with either using {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL Layout#HYPHENATION_FREQUENCY_NORMAL} or
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL Layout#HYPHENATION_FREQUENCY_FULL} while line breaking is set to one of
 * {@link android.text.Layout#BREAK_STRATEGY_BALANCED Layout#BREAK_STRATEGY_BALANCED}, {@link android.text.Layout#BREAK_STRATEGY_HIGH_QUALITY Layout#BREAK_STRATEGY_HIGH_QUALITY}
 * improves the structure of text layout however has performance impact and requires more time
 * to do the text layout.
 * <p/>
 * Note: Before Android Q, in the theme hyphenation frequency is set to
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL Layout#HYPHENATION_FREQUENCY_NORMAL}. The default value is changed into
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE Layout#HYPHENATION_FREQUENCY_NONE} on Q.
 *
 * @param hyphenationFrequency the hyphenation frequency to use, one of
 *                             {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE Layout#HYPHENATION_FREQUENCY_NONE},
 *                             {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL Layout#HYPHENATION_FREQUENCY_NORMAL},
 *                             {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL Layout#HYPHENATION_FREQUENCY_FULL}
 * Value is {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL}, {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL}, or {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE}
 * @attr ref android.R.styleable#TextView_hyphenationFrequency
 * @see #getHyphenationFrequency()
 * @see #getBreakStrategy()
 * @apiSince 23
 */

public void setHyphenationFrequency(int hyphenationFrequency) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current frequency of automatic hyphenation to be used when determining word breaks.
 * @return the current frequency of automatic hyphenation to be used when determining word
 * breaks.
 *
 * Value is {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL}, {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL}, or {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE}
 * @attr ref android.R.styleable#TextView_hyphenationFrequency
 * @see #setHyphenationFrequency(int)
 * @apiSince 23
 */

public int getHyphenationFrequency() { throw new RuntimeException("Stub!"); }

/**
 * Gets the parameters for text layout precomputation, for use with {@link android.text.PrecomputedText PrecomputedText}.
 *
 * @return a current {@link android.text.PrecomputedText.Params PrecomputedText.Params}
 * This value will never be {@code null}.
 * @see android.text.PrecomputedText
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.PrecomputedText.Params getTextMetricsParams() { throw new RuntimeException("Stub!"); }

/**
 * Apply the text layout parameter.
 *
 * Update the TextView parameters to be compatible with {@link android.text.PrecomputedText.Params PrecomputedText.Params}.
 * @see android.text.PrecomputedText
 
 * @param params This value must never be {@code null}.
 * @apiSince 28
 */

public void setTextMetricsParams(@androidx.annotation.NonNull android.text.PrecomputedText.Params params) { throw new RuntimeException("Stub!"); }

/**
 * Set justification mode. The default value is {@link android.text.Layout#JUSTIFICATION_MODE_NONE Layout#JUSTIFICATION_MODE_NONE}. If the
 * last line is too short for justification, the last line will be displayed with the
 * alignment set by {@link android.view.View#setTextAlignment}.
 *
 * @see #getJustificationMode()
 
 * @param justificationMode Value is {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_NONE}, or {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_INTER_WORD}
 * @return Value is {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_NONE}, or {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_INTER_WORD}
 * @apiSince 26
 */

public void setJustificationMode(int justificationMode) { throw new RuntimeException("Stub!"); }

/**
 * @return true if currently paragraph justification mode.
 *
 * Value is {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_NONE}, or {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_INTER_WORD}
 * @see #setJustificationMode(int)
 * @apiSince 26
 */

public int getJustificationMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets font feature settings. The format is the same as the CSS
 * font-feature-settings attribute:
 * <a href="https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop">
 *     https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop</a>
 *
 * @param fontFeatureSettings font feature settings represented as CSS compatible string
 *
 * This value may be {@code null}.
 * @see #getFontFeatureSettings()
 * @see android.graphics.Paint#getFontFeatureSettings() Paint.getFontFeatureSettings()
 *
 * @attr ref android.R.styleable#TextView_fontFeatureSettings
 * @apiSince 21
 */

public void setFontFeatureSettings(@androidx.annotation.Nullable java.lang.String fontFeatureSettings) { throw new RuntimeException("Stub!"); }

/**
 * Sets TrueType or OpenType font variation settings. The settings string is constructed from
 * multiple pairs of axis tag and style values. The axis tag must contain four ASCII characters
 * and must be wrapped with single quotes (U+0027) or double quotes (U+0022). Axis strings that
 * are longer or shorter than four characters, or contain characters outside of U+0020..U+007E
 * are invalid. If a specified axis name is not defined in the font, the settings will be
 * ignored.
 *
 * <p>
 * Examples,
 * <ul>
 * <li>Set font width to 150.
 * <pre>
 * <code>
 *   TextView textView = (TextView) findViewById(R.id.textView);
 *   textView.setFontVariationSettings("'wdth' 150");
 * </code>
 * </pre>
 * </li>
 *
 * <li>Set the font slant to 20 degrees and ask for italic style.
 * <pre>
 * <code>
 *   TextView textView = (TextView) findViewById(R.id.textView);
 *   textView.setFontVariationSettings("'slnt' 20, 'ital' 1");
 * </code>
 * </pre>
 * </p>
 * </li>
 * </ul>
 *
 * @param fontVariationSettings font variation settings. You can pass null or empty string as
 *                              no variation settings.
 * This value may be {@code null}.
 * @return true if the given settings is effective to at least one font file underlying this
 *         TextView. This function also returns true for empty settings string. Otherwise
 *         returns false.
 *
 * @throws java.lang.IllegalArgumentException If given string is not a valid font variation settings
 *                                  format.
 *
 * @see #getFontVariationSettings()
 * @see android.graphics.fonts.FontVariationAxis
 *
 * @attr ref android.R.styleable#TextView_fontVariationSettings
 * @apiSince 26
 */

public boolean setFontVariationSettings(@androidx.annotation.Nullable java.lang.String fontVariationSettings) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text color for all the states (normal, selected,
 * focused) to be this color.
 *
 * @param color A color value in the form 0xAARRGGBB.
 * Do not pass a resource ID. To get a color value from a resource ID, call
 * {@link android.support.v4.content.ContextCompat#getColor(Context, int) getColor}.
 *
 * @see #setTextColor(ColorStateList)
 * @see #getTextColors()
 *
 * @attr ref android.R.styleable#TextView_textColor
 * @apiSince 1
 */

public void setTextColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text color.
 *
 * @see #setTextColor(int)
 * @see #getTextColors()
 * @see #setHintTextColor(ColorStateList)
 * @see #setLinkTextColor(ColorStateList)
 *
 * @attr ref android.R.styleable#TextView_textColor
 * @apiSince 1
 */

public void setTextColor(android.content.res.ColorStateList colors) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text colors for the different states (normal, selected, focused) of the TextView.
 *
 * @see #setTextColor(ColorStateList)
 * @see #setTextColor(int)
 *
 * @attr ref android.R.styleable#TextView_textColor
 * @apiSince 1
 */

public final android.content.res.ColorStateList getTextColors() { throw new RuntimeException("Stub!"); }

/**
 * Return the current color selected for normal text.
 *
 * @return Returns the current text color.
 * @apiSince 1
 */

public final int getCurrentTextColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color used to display the selection highlight.
 *
 * @attr ref android.R.styleable#TextView_textColorHighlight
 * @apiSince 1
 */

public void setHighlightColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * @return the color used to display the selection highlight
 *
 * @see #setHighlightColor(int)
 *
 * @attr ref android.R.styleable#TextView_textColorHighlight
 * @apiSince 16
 */

public int getHighlightColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the soft input method will be made visible when this
 * TextView gets focused. The default is true.
 * @apiSince 21
 */

public final void setShowSoftInputOnFocus(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the soft input method will be made visible when this
 * TextView gets focused. The default is true.
 * @apiSince 21
 */

public final boolean getShowSoftInputOnFocus() { throw new RuntimeException("Stub!"); }

/**
 * Gives the text a shadow of the specified blur radius and color, the specified
 * distance from its drawn position.
 * <p>
 * The text shadow produced does not interact with the properties on view
 * that are responsible for real time shadows,
 * {@link android.view.View#getElevation() View#getElevation()} and
 * {@link android.view.View#getTranslationZ() View#getTranslationZ()}.
 *
 * @see android.graphics.Paint#setShadowLayer(float, float, float, int)
 *
 * @attr ref android.R.styleable#TextView_shadowColor
 * @attr ref android.R.styleable#TextView_shadowDx
 * @attr ref android.R.styleable#TextView_shadowDy
 * @attr ref android.R.styleable#TextView_shadowRadius
 * @apiSince 1
 */

public void setShadowLayer(float radius, float dx, float dy, int color) { throw new RuntimeException("Stub!"); }

/**
 * Gets the radius of the shadow layer.
 *
 * @return the radius of the shadow layer. If 0, the shadow layer is not visible
 *
 * @see #setShadowLayer(float, float, float, int)
 *
 * @attr ref android.R.styleable#TextView_shadowRadius
 * @apiSince 16
 */

public float getShadowRadius() { throw new RuntimeException("Stub!"); }

/**
 * @return the horizontal offset of the shadow layer
 *
 * @see #setShadowLayer(float, float, float, int)
 *
 * @attr ref android.R.styleable#TextView_shadowDx
 * @apiSince 16
 */

public float getShadowDx() { throw new RuntimeException("Stub!"); }

/**
 * Gets the vertical offset of the shadow layer.
 * @return The vertical offset of the shadow layer.
 *
 * @see #setShadowLayer(float, float, float, int)
 *
 * @attr ref android.R.styleable#TextView_shadowDy
 * @apiSince 16
 */

public float getShadowDy() { throw new RuntimeException("Stub!"); }

/**
 * Gets the color of the shadow layer.
 * @return the color of the shadow layer
 *
 * @see #setShadowLayer(float, float, float, int)
 *
 * @attr ref android.R.styleable#TextView_shadowColor
 * @apiSince 16
 */

public int getShadowColor() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.text.TextPaint TextPaint} used for the text.
 * Use this only to consult the Paint's properties and not to change them.
 * @return The base paint used for the text.
 * @apiSince 1
 */

public android.text.TextPaint getPaint() { throw new RuntimeException("Stub!"); }

/**
 * Sets the autolink mask of the text.  See {@link
 * android.text.util.Linkify#ALL Linkify.ALL} and peers for
 * possible values.
 *
 * <p class="note"><b>Note:</b>
 * {@link android.text.util.Linkify#MAP_ADDRESSES Linkify.MAP_ADDRESSES}
 * is deprecated and should be avoided; see its documentation.
 *
 * @attr ref android.R.styleable#TextView_autoLink
 * @apiSince 1
 */

public final void setAutoLinkMask(int mask) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the movement method will automatically be set to
 * {@link android.text.method.LinkMovementMethod LinkMovementMethod} if {@link #setAutoLinkMask} has been
 * set to nonzero and links are detected in {@link #setText}.
 * The default is true.
 *
 * @attr ref android.R.styleable#TextView_linksClickable
 * @apiSince 1
 */

public final void setLinksClickable(boolean whether) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the movement method will automatically be set to
 * {@link android.text.method.LinkMovementMethod LinkMovementMethod} if {@link #setAutoLinkMask} has been
 * set to nonzero and links are detected in {@link #setText}.
 * The default is true.
 *
 * @attr ref android.R.styleable#TextView_linksClickable
 * @apiSince 1
 */

public final boolean getLinksClickable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of {@link android.text.style.URLSpan URLSpans} attached to the text
 * (by {@link android.text.util.Linkify Linkify} or otherwise) if any.  You can call
 * {@link android.text.style.URLSpan#getURL URLSpan#getURL} on them to find where they link to
 * or use {@link android.text.Spanned#getSpanStart Spanned#getSpanStart} and {@link android.text.Spanned#getSpanEnd Spanned#getSpanEnd}
 * to find the region of the text they are attached to.
 * @apiSince 1
 */

public android.text.style.URLSpan[] getUrls() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of the hint text for all the states (disabled, focussed, selected...) of this
 * TextView.
 *
 * @see #setHintTextColor(ColorStateList)
 * @see #getHintTextColors()
 * @see #setTextColor(int)
 *
 * @attr ref android.R.styleable#TextView_textColorHint
 * @apiSince 1
 */

public final void setHintTextColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of the hint text.
 *
 * @see #getHintTextColors()
 * @see #setHintTextColor(int)
 * @see #setTextColor(ColorStateList)
 * @see #setLinkTextColor(ColorStateList)
 *
 * @attr ref android.R.styleable#TextView_textColorHint
 * @apiSince 1
 */

public final void setHintTextColor(android.content.res.ColorStateList colors) { throw new RuntimeException("Stub!"); }

/**
 * @return the color of the hint text, for the different states of this TextView.
 *
 * @see #setHintTextColor(ColorStateList)
 * @see #setHintTextColor(int)
 * @see #setTextColor(ColorStateList)
 * @see #setLinkTextColor(ColorStateList)
 *
 * @attr ref android.R.styleable#TextView_textColorHint
 * @apiSince 1
 */

public final android.content.res.ColorStateList getHintTextColors() { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the current color selected to paint the hint text.</p>
 *
 * @return Returns the current hint text color.
 * @apiSince 1
 */

public final int getCurrentHintTextColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of links in the text.
 *
 * @see #setLinkTextColor(ColorStateList)
 * @see #getLinkTextColors()
 *
 * @attr ref android.R.styleable#TextView_textColorLink
 * @apiSince 1
 */

public final void setLinkTextColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Sets the color of links in the text.
 *
 * @see #setLinkTextColor(int)
 * @see #getLinkTextColors()
 * @see #setTextColor(ColorStateList)
 * @see #setHintTextColor(ColorStateList)
 *
 * @attr ref android.R.styleable#TextView_textColorLink
 * @apiSince 1
 */

public final void setLinkTextColor(android.content.res.ColorStateList colors) { throw new RuntimeException("Stub!"); }

/**
 * @return the list of colors used to paint the links in the text, for the different states of
 * this TextView
 *
 * @see #setLinkTextColor(ColorStateList)
 * @see #setLinkTextColor(int)
 *
 * @attr ref android.R.styleable#TextView_textColorLink
 * @apiSince 1
 */

public final android.content.res.ColorStateList getLinkTextColors() { throw new RuntimeException("Stub!"); }

/**
 * Sets the horizontal alignment of the text and the
 * vertical gravity that will be used when there is extra space
 * in the TextView beyond what is required for the text itself.
 *
 * @see android.view.Gravity
 * @attr ref android.R.styleable#TextView_gravity
 * @apiSince 1
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Returns the horizontal and vertical alignment of this TextView.
 *
 * @see android.view.Gravity
 * @attr ref android.R.styleable#TextView_gravity
 * @apiSince 1
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/**
 * Gets the flags on the Paint being used to display the text.
 * @return The flags on the Paint being used to display the text.
 * @see android.graphics.Paint#getFlags
 * @apiSince 1
 */

public int getPaintFlags() { throw new RuntimeException("Stub!"); }

/**
 * Sets flags on the Paint being used to display the text and
 * reflows the text if they are different from the old flags.
 * @see android.graphics.Paint#setFlags
 * @apiSince 1
 */

public void setPaintFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the text should be allowed to be wider than the
 * View is.  If false, it will be wrapped to the width of the View.
 *
 * @attr ref android.R.styleable#TextView_scrollHorizontally
 * @apiSince 1
 */

public void setHorizontallyScrolling(boolean whether) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the text is allowed to be wider than the View.
 * If false, the text will be wrapped to the width of the View.
 *
 * @attr ref android.R.styleable#TextView_scrollHorizontally
 * @see #setHorizontallyScrolling(boolean)
 * @apiSince 29
 */

public final boolean isHorizontallyScrollable() { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the TextView to be at least {@code minLines} tall.
 * <p>
 * This value is used for height calculation if LayoutParams does not force TextView to have an
 * exact height. Setting this value overrides other previous minimum height configurations such
 * as {@link #setMinHeight(int)} or {@link #setHeight(int)}. {@link #setSingleLine()} will set
 * this value to 1.
 *
 * @param minLines the minimum height of TextView in terms of number of lines
 *
 * @see #getMinLines()
 * @see #setLines(int)
 *
 * @attr ref android.R.styleable#TextView_minLines
 * @apiSince 1
 */

public void setMinLines(int minLines) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum height of TextView in terms of number of lines or -1 if the minimum
 * height was set using {@link #setMinHeight(int)} or {@link #setHeight(int)}.
 *
 * @return the minimum height of TextView in terms of number of lines or -1 if the minimum
 *         height is not defined in lines
 *
 * @see #setMinLines(int)
 * @see #setLines(int)
 *
 * @attr ref android.R.styleable#TextView_minLines
 * @apiSince 16
 */

public int getMinLines() { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the TextView to be at least {@code minPixels} tall.
 * <p>
 * This value is used for height calculation if LayoutParams does not force TextView to have an
 * exact height. Setting this value overrides previous minimum height configurations such as
 * {@link #setMinLines(int)} or {@link #setLines(int)}.
 * <p>
 * The value given here is different than {@link #setMinimumHeight(int)}. Between
 * {@code minHeight} and the value set in {@link #setMinimumHeight(int)}, the greater one is
 * used to decide the final height.
 *
 * @param minPixels the minimum height of TextView in terms of pixels
 *
 * @see #getMinHeight()
 * @see #setHeight(int)
 *
 * @attr ref android.R.styleable#TextView_minHeight
 * @apiSince 1
 */

public void setMinHeight(int minPixels) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum height of TextView in terms of pixels or -1 if the minimum height was
 * set using {@link #setMinLines(int)} or {@link #setLines(int)}.
 *
 * @return the minimum height of TextView in terms of pixels or -1 if the minimum height is not
 *         defined in pixels
 *
 * @see #setMinHeight(int)
 * @see #setHeight(int)
 *
 * @attr ref android.R.styleable#TextView_minHeight
 * @apiSince 16
 */

public int getMinHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the TextView to be at most {@code maxLines} tall.
 * <p>
 * This value is used for height calculation if LayoutParams does not force TextView to have an
 * exact height. Setting this value overrides previous maximum height configurations such as
 * {@link #setMaxHeight(int)} or {@link #setLines(int)}.
 *
 * @param maxLines the maximum height of TextView in terms of number of lines
 *
 * @see #getMaxLines()
 * @see #setLines(int)
 *
 * @attr ref android.R.styleable#TextView_maxLines
 * @apiSince 1
 */

public void setMaxLines(int maxLines) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum height of TextView in terms of number of lines or -1 if the
 * maximum height was set using {@link #setMaxHeight(int)} or {@link #setHeight(int)}.
 *
 * @return the maximum height of TextView in terms of number of lines. -1 if the maximum height
 *         is not defined in lines.
 *
 * @see #setMaxLines(int)
 * @see #setLines(int)
 *
 * @attr ref android.R.styleable#TextView_maxLines
 * @apiSince 16
 */

public int getMaxLines() { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the TextView to be at most {@code maxPixels} tall.
 * <p>
 * This value is used for height calculation if LayoutParams does not force TextView to have an
 * exact height. Setting this value overrides previous maximum height configurations such as
 * {@link #setMaxLines(int)} or {@link #setLines(int)}.
 *
 * @param maxPixels the maximum height of TextView in terms of pixels
 *
 * @see #getMaxHeight()
 * @see #setHeight(int)
 *
 * @attr ref android.R.styleable#TextView_maxHeight
 * @apiSince 1
 */

public void setMaxHeight(int maxPixels) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum height of TextView in terms of pixels or -1 if the maximum height was
 * set using {@link #setMaxLines(int)} or {@link #setLines(int)}.
 *
 * @return the maximum height of TextView in terms of pixels or -1 if the maximum height
 *         is not defined in pixels
 *
 * @see #setMaxHeight(int)
 * @see #setHeight(int)
 *
 * @attr ref android.R.styleable#TextView_maxHeight
 * @apiSince 16
 */

public int getMaxHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the TextView to be exactly {@code lines} tall.
 * <p>
 * This value is used for height calculation if LayoutParams does not force TextView to have an
 * exact height. Setting this value overrides previous minimum/maximum height configurations
 * such as {@link #setMinLines(int)} or {@link #setMaxLines(int)}. {@link #setSingleLine()} will
 * set this value to 1.
 *
 * @param lines the exact height of the TextView in terms of lines
 *
 * @see #setHeight(int)
 *
 * @attr ref android.R.styleable#TextView_lines
 * @apiSince 1
 */

public void setLines(int lines) { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the TextView to be exactly <code>pixels</code> tall.
 * <p>
 * This value is used for height calculation if LayoutParams does not force TextView to have an
 * exact height. Setting this value overrides previous minimum/maximum height configurations
 * such as {@link #setMinHeight(int)} or {@link #setMaxHeight(int)}.
 *
 * @param pixels the exact height of the TextView in terms of pixels
 *
 * @see #setLines(int)
 *
 * @attr ref android.R.styleable#TextView_height
 * @apiSince 1
 */

public void setHeight(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the TextView to be at least {@code minEms} wide.
 * <p>
 * This value is used for width calculation if LayoutParams does not force TextView to have an
 * exact width. Setting this value overrides previous minimum width configurations such as
 * {@link #setMinWidth(int)} or {@link #setWidth(int)}.
 *
 * @param minEms the minimum width of TextView in terms of ems
 *
 * @see #getMinEms()
 * @see #setEms(int)
 *
 * @attr ref android.R.styleable#TextView_minEms
 * @apiSince 1
 */

public void setMinEms(int minEms) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum width of TextView in terms of ems or -1 if the minimum width was set
 * using {@link #setMinWidth(int)} or {@link #setWidth(int)}.
 *
 * @return the minimum width of TextView in terms of ems. -1 if the minimum width is not
 *         defined in ems
 *
 * @see #setMinEms(int)
 * @see #setEms(int)
 *
 * @attr ref android.R.styleable#TextView_minEms
 * @apiSince 16
 */

public int getMinEms() { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the TextView to be at least {@code minPixels} wide.
 * <p>
 * This value is used for width calculation if LayoutParams does not force TextView to have an
 * exact width. Setting this value overrides previous minimum width configurations such as
 * {@link #setMinEms(int)} or {@link #setEms(int)}.
 * <p>
 * The value given here is different than {@link #setMinimumWidth(int)}. Between
 * {@code minWidth} and the value set in {@link #setMinimumWidth(int)}, the greater one is used
 * to decide the final width.
 *
 * @param minPixels the minimum width of TextView in terms of pixels
 *
 * @see #getMinWidth()
 * @see #setWidth(int)
 *
 * @attr ref android.R.styleable#TextView_minWidth
 * @apiSince 1
 */

public void setMinWidth(int minPixels) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum width of TextView in terms of pixels or -1 if the minimum width was set
 * using {@link #setMinEms(int)} or {@link #setEms(int)}.
 *
 * @return the minimum width of TextView in terms of pixels or -1 if the minimum width is not
 *         defined in pixels
 *
 * @see #setMinWidth(int)
 * @see #setWidth(int)
 *
 * @attr ref android.R.styleable#TextView_minWidth
 * @apiSince 16
 */

public int getMinWidth() { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the TextView to be at most {@code maxEms} wide.
 * <p>
 * This value is used for width calculation if LayoutParams does not force TextView to have an
 * exact width. Setting this value overrides previous maximum width configurations such as
 * {@link #setMaxWidth(int)} or {@link #setWidth(int)}.
 *
 * @param maxEms the maximum width of TextView in terms of ems
 *
 * @see #getMaxEms()
 * @see #setEms(int)
 *
 * @attr ref android.R.styleable#TextView_maxEms
 * @apiSince 1
 */

public void setMaxEms(int maxEms) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum width of TextView in terms of ems or -1 if the maximum width was set
 * using {@link #setMaxWidth(int)} or {@link #setWidth(int)}.
 *
 * @return the maximum width of TextView in terms of ems or -1 if the maximum width is not
 *         defined in ems
 *
 * @see #setMaxEms(int)
 * @see #setEms(int)
 *
 * @attr ref android.R.styleable#TextView_maxEms
 * @apiSince 16
 */

public int getMaxEms() { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the TextView to be at most {@code maxPixels} wide.
 * <p>
 * This value is used for width calculation if LayoutParams does not force TextView to have an
 * exact width. Setting this value overrides previous maximum width configurations such as
 * {@link #setMaxEms(int)} or {@link #setEms(int)}.
 *
 * @param maxPixels the maximum width of TextView in terms of pixels
 *
 * @see #getMaxWidth()
 * @see #setWidth(int)
 *
 * @attr ref android.R.styleable#TextView_maxWidth
 * @apiSince 1
 */

public void setMaxWidth(int maxPixels) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum width of TextView in terms of pixels or -1 if the maximum width was set
 * using {@link #setMaxEms(int)} or {@link #setEms(int)}.
 *
 * @return the maximum width of TextView in terms of pixels. -1 if the maximum width is not
 *         defined in pixels
 *
 * @see #setMaxWidth(int)
 * @see #setWidth(int)
 *
 * @attr ref android.R.styleable#TextView_maxWidth
 * @apiSince 16
 */

public int getMaxWidth() { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the TextView to be exactly {@code ems} wide.
 *
 * This value is used for width calculation if LayoutParams does not force TextView to have an
 * exact width. Setting this value overrides previous minimum/maximum configurations such as
 * {@link #setMinEms(int)} or {@link #setMaxEms(int)}.
 *
 * @param ems the exact width of the TextView in terms of ems
 *
 * @see #setWidth(int)
 *
 * @attr ref android.R.styleable#TextView_ems
 * @apiSince 1
 */

public void setEms(int ems) { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the TextView to be exactly {@code pixels} wide.
 * <p>
 * This value is used for width calculation if LayoutParams does not force TextView to have an
 * exact width. Setting this value overrides previous minimum/maximum width configurations
 * such as {@link #setMinWidth(int)} or {@link #setMaxWidth(int)}.
 *
 * @param pixels the exact width of the TextView in terms of pixels
 *
 * @see #setEms(int)
 *
 * @attr ref android.R.styleable#TextView_width
 * @apiSince 1
 */

public void setWidth(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Sets line spacing for this TextView.  Each line other than the last line will have its height
 * multiplied by {@code mult} and have {@code add} added to it.
 *
 * @param add The value in pixels that should be added to each line other than the last line.
 *            This will be applied after the multiplier
 * @param mult The value by which each line height other than the last line will be multiplied
 *             by
 *
 * @attr ref android.R.styleable#TextView_lineSpacingExtra
 * @attr ref android.R.styleable#TextView_lineSpacingMultiplier
 * @apiSince 1
 */

public void setLineSpacing(float add, float mult) { throw new RuntimeException("Stub!"); }

/**
 * Gets the line spacing multiplier
 *
 * @return the value by which each line's height is multiplied to get its actual height.
 *
 * @see #setLineSpacing(float, float)
 * @see #getLineSpacingExtra()
 *
 * @attr ref android.R.styleable#TextView_lineSpacingMultiplier
 * @apiSince 16
 */

public float getLineSpacingMultiplier() { throw new RuntimeException("Stub!"); }

/**
 * Gets the line spacing extra space
 *
 * @return the extra space that is added to the height of each lines of this TextView.
 *
 * @see #setLineSpacing(float, float)
 * @see #getLineSpacingMultiplier()
 *
 * @attr ref android.R.styleable#TextView_lineSpacingExtra
 * @apiSince 16
 */

public float getLineSpacingExtra() { throw new RuntimeException("Stub!"); }

/**
 * Sets an explicit line height for this TextView. This is equivalent to the vertical distance
 * between subsequent baselines in the TextView.
 *
 * @param lineHeight the line height in pixels
 *
 * This units of this value are pixels.
 * Value is 0 or greater
 * @see #setLineSpacing(float, float)
 * @see #getLineSpacingExtra()
 *
 * @attr ref android.R.styleable#TextView_lineHeight
 * @apiSince 28
 */

public void setLineHeight(int lineHeight) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to append the specified text to the TextView's
 * display buffer, upgrading it to {@link android.widget.TextView.BufferType#EDITABLE}
 * if it was not already editable.
 *
 * @param text text to be appended to the already displayed text
 * @apiSince 1
 */

public final void append(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to append the specified text slice to the TextView's
 * display buffer, upgrading it to {@link android.widget.TextView.BufferType#EDITABLE}
 * if it was not already editable.
 *
 * @param text text to be appended to the already displayed text
 * @param start the index of the first character in the {@code text}
 * @param end the index of the character following the last character in the {@code text}
 *
 * @see java.lang.Appendable#append(CharSequence, int, int)
 * @apiSince 1
 */

public void append(java.lang.CharSequence text, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/**
 * Control whether this text view saves its entire text contents when
 * freezing to an icicle, in addition to dynamic state such as cursor
 * position.  By default this is false, not saving the text.  Set to true
 * if the text in the text view is not being saved somewhere else in
 * persistent storage (such as in a content provider) so that if the
 * view is later thawed the user will not lose their data. For
 * {@link android.widget.EditText} it is always enabled, regardless of
 * the value of the attribute.
 *
 * @param freezesText Controls whether a frozen icicle should include the
 * entire text data: true to include it, false to not.
 *
 * @attr ref android.R.styleable#TextView_freezesText
 * @apiSince 1
 */

public void setFreezesText(boolean freezesText) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this text view is including its entire text contents
 * in frozen icicles. For {@link android.widget.EditText} it always returns true.
 *
 * @return Returns true if text is included, false if it isn't.
 *
 * @see #setFreezesText
 * @apiSince 1
 */

public boolean getFreezesText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Factory used to create new {@link android.text.Editable Editable}.
 *
 * @param factory {@link android.text.Editable.Factory Editable.Factory} to be used
 *
 * @see android.text.Editable.Factory
 * @see android.widget.TextView.BufferType#EDITABLE
 * @apiSince 1
 */

public final void setEditableFactory(android.text.Editable.Factory factory) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Factory used to create new {@link android.text.Spannable Spannable}.
 *
 * @param factory {@link android.text.Spannable.Factory Spannable.Factory} to be used
 *
 * @see android.text.Spannable.Factory
 * @see android.widget.TextView.BufferType#SPANNABLE
 * @apiSince 1
 */

public final void setSpannableFactory(android.text.Spannable.Factory factory) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed. TextView <em>does not</em> accept
 * HTML-like formatting, which you can do with text strings in XML resource files.
 * To style your strings, attach android.text.style.* objects to a
 * {@link android.text.SpannableString}, or see the
 * <a href="{@docRoot}guide/topics/resources/available-resources.html#stringresources">
 * Available Resource Types</a> documentation for an example of setting
 * formatted text in the XML resource file.
 * <p/>
 * When required, TextView will use {@link android.text.Spannable.Factory} to create final or
 * intermediate {@link android.text.Spannable Spannable}. Likewise it will use
 * {@link android.text.Editable.Factory} to create final or intermediate
 * {@link android.text.Editable Editable}.
 *
 * If the passed text is a {@link android.text.PrecomputedText PrecomputedText} but the parameters used to create the
 * PrecomputedText mismatches with this TextView, IllegalArgumentException is thrown. To ensure
 * the parameters match, you can call {@link android.widget.TextView#setTextMetricsParams TextView#setTextMetricsParams} before calling this.
 *
 * @param text text to be displayed
 *
 * @attr ref android.R.styleable#TextView_text
 * @throws java.lang.IllegalArgumentException if the passed text is a {@link android.text.PrecomputedText PrecomputedText} but the
 *                                  parameters used to create the PrecomputedText mismatches
 *                                  with this TextView.
 * @apiSince 1
 */

public final void setText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed but retains the cursor position. Same as
 * {@link #setText(java.lang.CharSequence)} except that the cursor position (if any) is retained in the
 * new text.
 * <p/>
 * When required, TextView will use {@link android.text.Spannable.Factory} to create final or
 * intermediate {@link android.text.Spannable Spannable}. Likewise it will use
 * {@link android.text.Editable.Factory} to create final or intermediate
 * {@link android.text.Editable Editable}.
 *
 * @param text text to be displayed
 *
 * @see #setText(CharSequence)
 * @apiSince 1
 */

public final void setTextKeepState(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed and the {@link android.widget.TextView.BufferType}.
 * <p/>
 * When required, TextView will use {@link android.text.Spannable.Factory} to create final or
 * intermediate {@link android.text.Spannable Spannable}. Likewise it will use
 * {@link android.text.Editable.Factory} to create final or intermediate
 * {@link android.text.Editable Editable}.
 *
 * Subclasses overriding this method should ensure that the following post condition holds,
 * in order to guarantee the safety of the view's measurement and layout operations:
 * regardless of the input, after calling #setText both {@code mText} and {@code mTransformed}
 * will be different from {@code null}.
 *
 * @param text text to be displayed
 * @param type a {@link android.widget.TextView.BufferType} which defines whether the text is
 *              stored as a static text, styleable/spannable text, or editable text
 *
 * @see #setText(CharSequence)
 * @see android.widget.TextView.BufferType
 * @see #setSpannableFactory(Spannable.Factory)
 * @see #setEditableFactory(Editable.Factory)
 *
 * @attr ref android.R.styleable#TextView_text
 * @attr ref android.R.styleable#TextView_bufferType
 * @apiSince 1
 */

public void setText(java.lang.CharSequence text, android.widget.TextView.BufferType type) { throw new RuntimeException("Stub!"); }

/**
 * Sets the TextView to display the specified slice of the specified
 * char array. You must promise that you will not change the contents
 * of the array except for right before another call to setText(),
 * since the TextView has no way to know that the text
 * has changed and that it needs to invalidate and re-layout.
 *
 * @param text char array to be displayed
 * @param start start index in the char array
 * @param len length of char count after {@code start}
 * @apiSince 1
 */

public final void setText(char[] text, int start, int len) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed and the {@link android.widget.TextView.BufferType} but retains
 * the cursor position. Same as
 * {@link #setText(java.lang.CharSequence,android.widget.TextView.BufferType)} except that the cursor
 * position (if any) is retained in the new text.
 * <p/>
 * When required, TextView will use {@link android.text.Spannable.Factory} to create final or
 * intermediate {@link android.text.Spannable Spannable}. Likewise it will use
 * {@link android.text.Editable.Factory} to create final or intermediate
 * {@link android.text.Editable Editable}.
 *
 * @param text text to be displayed
 * @param type a {@link android.widget.TextView.BufferType} which defines whether the text is
 *              stored as a static text, styleable/spannable text, or editable text
 *
 * @see #setText(CharSequence, android.widget.TextView.BufferType)
 * @apiSince 1
 */

public final void setTextKeepState(java.lang.CharSequence text, android.widget.TextView.BufferType type) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed using a string resource identifier.
 *
 * @param resid the resource identifier of the string resource to be displayed
 *
 * @see #setText(CharSequence)
 *
 * @attr ref android.R.styleable#TextView_text
 * @apiSince 1
 */

public final void setText(int resid) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed using a string resource identifier and the
 * {@link android.widget.TextView.BufferType}.
 * <p/>
 * When required, TextView will use {@link android.text.Spannable.Factory} to create final or
 * intermediate {@link android.text.Spannable Spannable}. Likewise it will use
 * {@link android.text.Editable.Factory} to create final or intermediate
 * {@link android.text.Editable Editable}.
 *
 * @param resid the resource identifier of the string resource to be displayed
 * @param type a {@link android.widget.TextView.BufferType} which defines whether the text is
 *              stored as a static text, styleable/spannable text, or editable text
 *
 * @see #setText(int)
 * @see #setText(CharSequence)
 * @see android.widget.TextView.BufferType
 * @see #setSpannableFactory(Spannable.Factory)
 * @see #setEditableFactory(Editable.Factory)
 *
 * @attr ref android.R.styleable#TextView_text
 * @attr ref android.R.styleable#TextView_bufferType
 * @apiSince 1
 */

public final void setText(int resid, android.widget.TextView.BufferType type) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed when the text of the TextView is empty.
 * Null means to use the normal empty text. The hint does not currently
 * participate in determining the size of the view.
 *
 * @attr ref android.R.styleable#TextView_hint
 * @apiSince 1
 */

public final void setHint(java.lang.CharSequence hint) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text to be displayed when the text of the TextView is empty,
 * from a resource.
 *
 * @attr ref android.R.styleable#TextView_hint
 * @apiSince 1
 */

public final void setHint(int resid) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hint that is displayed when the text of the TextView
 * is empty.
 *
 * @attr ref android.R.styleable#TextView_hint
 * @apiSince 1
 */

@android.view.ViewDebug.CapturedViewProperty
public java.lang.CharSequence getHint() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the text is constrained to a single horizontally scrolling line ignoring new
 * line characters instead of letting it wrap onto multiple lines.
 *
 * @attr ref android.R.styleable#TextView_singleLine
 * @apiSince 29
 */

public boolean isSingleLine() { throw new RuntimeException("Stub!"); }

/**
 * Set the type of the content with a constant as defined for {@link android.view.inputmethod.EditorInfo#inputType EditorInfo#inputType}. This
 * will take care of changing the key listener, by calling {@link #setKeyListener(android.text.method.KeyListener)},
 * to match the given content type.  If the given content type is {@link android.view.inputmethod.EditorInfo#TYPE_NULL EditorInfo#TYPE_NULL}
 * then a soft keyboard will not be displayed for this text view.
 *
 * Note that the maximum number of displayed lines (see {@link #setMaxLines(int)}) will be
 * modified if you change the {@link android.view.inputmethod.EditorInfo#TYPE_TEXT_FLAG_MULTI_LINE EditorInfo#TYPE_TEXT_FLAG_MULTI_LINE} flag of the input
 * type.
 *
 * @see #getInputType()
 * @see #setRawInputType(int)
 * @see android.text.InputType
 * @attr ref android.R.styleable#TextView_inputType
 * @apiSince 3
 */

public void setInputType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Directly change the content type integer of the text view, without
 * modifying any other state.
 * @see #setInputType(int)
 * @see android.text.InputType
 * @attr ref android.R.styleable#TextView_inputType
 * @apiSince 3
 */

public void setRawInputType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Get the type of the editable content.
 *
 * @see #setInputType(int)
 * @see android.text.InputType
 * @apiSince 3
 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/**
 * Change the editor type integer associated with the text view, which
 * is reported to an Input Method Editor (IME) with {@link android.view.inputmethod.EditorInfo#imeOptions EditorInfo#imeOptions}
 * when it has focus.
 * @see #getImeOptions
 * @see android.view.inputmethod.EditorInfo
 * @attr ref android.R.styleable#TextView_imeOptions
 * @apiSince 3
 */

public void setImeOptions(int imeOptions) { throw new RuntimeException("Stub!"); }

/**
 * Get the type of the Input Method Editor (IME).
 * @return the type of the IME
 * @see #setImeOptions(int)
 * @see android.view.inputmethod.EditorInfo
 * @apiSince 3
 */

public int getImeOptions() { throw new RuntimeException("Stub!"); }

/**
 * Change the custom IME action associated with the text view, which
 * will be reported to an IME with {@link android.view.inputmethod.EditorInfo#actionLabel EditorInfo#actionLabel}
 * and {@link android.view.inputmethod.EditorInfo#actionId EditorInfo#actionId} when it has focus.
 * @see #getImeActionLabel
 * @see #getImeActionId
 * @see android.view.inputmethod.EditorInfo
 * @attr ref android.R.styleable#TextView_imeActionLabel
 * @attr ref android.R.styleable#TextView_imeActionId
 * @apiSince 3
 */

public void setImeActionLabel(java.lang.CharSequence label, int actionId) { throw new RuntimeException("Stub!"); }

/**
 * Get the IME action label previous set with {@link #setImeActionLabel}.
 *
 * @see #setImeActionLabel
 * @see android.view.inputmethod.EditorInfo
 * @apiSince 3
 */

public java.lang.CharSequence getImeActionLabel() { throw new RuntimeException("Stub!"); }

/**
 * Get the IME action ID previous set with {@link #setImeActionLabel}.
 *
 * @see #setImeActionLabel
 * @see android.view.inputmethod.EditorInfo
 * @apiSince 3
 */

public int getImeActionId() { throw new RuntimeException("Stub!"); }

/**
 * Set a special listener to be called when an action is performed
 * on the text view.  This will be called when the enter key is pressed,
 * or when an action supplied to the IME is selected by the user.  Setting
 * this means that the normal hard key event will not insert a newline
 * into the text view, even if it is multi-line; holding down the ALT
 * modifier will, however, allow the user to insert a newline character.
 * @apiSince 3
 */

public void setOnEditorActionListener(android.widget.TextView.OnEditorActionListener l) { throw new RuntimeException("Stub!"); }

/**
 * Called when an attached input method calls
 * {@link android.view.inputmethod.InputConnection#performEditorAction(int) InputConnection#performEditorAction(int)}
 * for this text view.  The default implementation will call your action
 * listener supplied to {@link #setOnEditorActionListener}, or perform
 * a standard operation for {@link android.view.inputmethod.EditorInfo#IME_ACTION_NEXT EditorInfo#IME_ACTION_NEXT}, {@link android.view.inputmethod.EditorInfo#IME_ACTION_PREVIOUS EditorInfo#IME_ACTION_PREVIOUS}, or {@link android.view.inputmethod.EditorInfo#IME_ACTION_DONE EditorInfo#IME_ACTION_DONE}.
 *
 * <p>For backwards compatibility, if no IME options have been set and the
 * text view would not normally advance focus on enter, then
 * the NEXT and DONE actions received here will be turned into an enter
 * key down/up pair to go through the normal key handling.
 *
 * @param actionCode The code of the action being performed.
 *
 * @see #setOnEditorActionListener
 * @apiSince 3
 */

public void onEditorAction(int actionCode) { throw new RuntimeException("Stub!"); }

/**
 * Set the private content type of the text, which is the
 * {@link android.view.inputmethod.EditorInfo#privateImeOptions EditorInfo#privateImeOptions}
 * field that will be filled in when creating an input connection.
 *
 * @see #getPrivateImeOptions()
 * @see android.view.inputmethod.EditorInfo#privateImeOptions
 * @attr ref android.R.styleable#TextView_privateImeOptions
 * @apiSince 3
 */

public void setPrivateImeOptions(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Get the private type of the content.
 *
 * @see #setPrivateImeOptions(String)
 * @see android.view.inputmethod.EditorInfo#privateImeOptions
 * @apiSince 3
 */

public java.lang.String getPrivateImeOptions() { throw new RuntimeException("Stub!"); }

/**
 * Set the extra input data of the text, which is the
 * {@link android.view.inputmethod.EditorInfo#extras EditorInfo#extras}
 * Bundle that will be filled in when creating an input connection.  The
 * given integer is the resource identifier of an XML resource holding an
 * {@link android.R.styleable#InputExtras &lt;input-extras&gt;} XML tree.
 *
 * @see #getInputExtras(boolean)
 * @see android.view.inputmethod.EditorInfo#extras
 * @attr ref android.R.styleable#TextView_editorExtras
 * @apiSince 3
 */

public void setInputExtras(int xmlResId) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the input extras currently associated with the text view, which
 * can be viewed as well as modified.
 *
 * @param create If true, the extras will be created if they don't already
 * exist.  Otherwise, null will be returned if none have been created.
 * @see #setInputExtras(int)
 * @see android.view.inputmethod.EditorInfo#extras
 * @attr ref android.R.styleable#TextView_editorExtras
 * @apiSince 3
 */

public android.os.Bundle getInputExtras(boolean create) { throw new RuntimeException("Stub!"); }

/**
 * Change "hint" locales associated with the text view, which will be reported to an IME with
 * {@link android.view.inputmethod.EditorInfo#hintLocales EditorInfo#hintLocales} when it has focus.
 *
 * Starting with Android O, this also causes internationalized listeners to be created (or
 * change locale) based on the first locale in the input locale list.
 *
 * <p><strong>Note:</strong> If you want new "hint" to take effect immediately you need to
 * call {@link android.view.inputmethod.InputMethodManager#restartInput(android.view.View) InputMethodManager#restartInput(View)}.</p>
 * @param hintLocales List of the languages that the user is supposed to switch to no matter
 * what input method subtype is currently used. Set {@code null} to clear the current "hint".
 * This value may be {@code null}.
 * @see #getImeHintLocales()
 * @see android.view.inputmethod.EditorInfo#hintLocales
 * @apiSince 24
 */

public void setImeHintLocales(@androidx.annotation.Nullable android.os.LocaleList hintLocales) { throw new RuntimeException("Stub!"); }

/**
 * @return The current languages list "hint". {@code null} when no "hint" is available.
 * @see #setImeHintLocales(LocaleList)
 * @see android.view.inputmethod.EditorInfo#hintLocales
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.os.LocaleList getImeHintLocales() { throw new RuntimeException("Stub!"); }

/**
 * Returns the error message that was set to be displayed with
 * {@link #setError}, or <code>null</code> if no error was set
 * or if it the error was cleared by the widget after user input.
 * @apiSince 1
 */

public java.lang.CharSequence getError() { throw new RuntimeException("Stub!"); }

/**
 * Sets the right-hand compound drawable of the TextView to the "error"
 * icon and sets an error message that will be displayed in a popup when
 * the TextView has focus.  The icon and error message will be reset to
 * null when any key events cause changes to the TextView's text.  If the
 * <code>error</code> is <code>null</code>, the error message and icon
 * will be cleared.
 * @apiSince 1
 */

public void setError(java.lang.CharSequence error) { throw new RuntimeException("Stub!"); }

/**
 * Sets the right-hand compound drawable of the TextView to the specified
 * icon and sets an error message that will be displayed in a popup when
 * the TextView has focus.  The icon and error message will be reset to
 * null when any key events cause changes to the TextView's text.  The
 * drawable must already have had {@link android.graphics.drawable.Drawable#setBounds Drawable#setBounds} set on it.
 * If the <code>error</code> is <code>null</code>, the error message will
 * be cleared (and you should provide a <code>null</code> icon as well).
 * @apiSince 1
 */

public void setError(java.lang.CharSequence error, android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean setFrame(int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * Sets the list of input filters that will be used if the buffer is
 * Editable. Has no effect otherwise.
 *
 * @attr ref android.R.styleable#TextView_maxLength
 * @apiSince 1
 */

public void setFilters(android.text.InputFilter[] filters) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current list of input filters.
 *
 * @attr ref android.R.styleable#TextView_maxLength
 * @apiSince 1
 */

public android.text.InputFilter[] getFilters() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public boolean onPreDraw() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void onScreenStateChanged(int screenState) { throw new RuntimeException("Stub!"); }

/** @apiSince 2 */

protected boolean isPaddingOffsetRequired() { throw new RuntimeException("Stub!"); }

/** @apiSince 2 */

protected int getLeftPaddingOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 2 */

protected int getTopPaddingOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 2 */

protected int getBottomPaddingOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 2 */

protected int getRightPaddingOffset() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param who This value must never be {@code null}.
 * @apiSince 1
 */

protected boolean verifyDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param drawable This value must never be {@code null}.
 * @apiSince 1
 */

public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public boolean hasOverlappingRendering() { throw new RuntimeException("Stub!"); }

/**
 *
 * Returns the state of the {@code textIsSelectable} flag (See
 * {@link #setTextIsSelectable setTextIsSelectable()}). Although you have to set this flag
 * to allow users to select and copy text in a non-editable TextView, the content of an
 * {@link android.widget.EditText EditText} can always be selected, independently of the value of this flag.
 * <p>
 *
 * @return True if the text displayed in this TextView can be selected by the user.
 *
 * @attr ref android.R.styleable#TextView_textIsSelectable
 @apiSince 11
 */

public boolean isTextSelectable() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the content of this view is selectable by the user. The default is
 * {@code false}, meaning that the content is not selectable.
 * <p>
 * When you use a TextView to display a useful piece of information to the user (such as a
 * contact's address), make it selectable, so that the user can select and copy its
 * content. You can also use set the XML attribute
 * {@link android.R.styleable#TextView_textIsSelectable} to "true".
 * <p>
 * When you call this method to set the value of {@code textIsSelectable}, it sets
 * the flags {@code focusable}, {@code focusableInTouchMode}, {@code clickable},
 * and {@code longClickable} to the same value. These flags correspond to the attributes
 * {@link android.R.styleable#View_focusable android:focusable},
 * {@link android.R.styleable#View_focusableInTouchMode android:focusableInTouchMode},
 * {@link android.R.styleable#View_clickable android:clickable}, and
 * {@link android.R.styleable#View_longClickable android:longClickable}. To restore any of these
 * flags to a state you had set previously, call one or more of the following methods:
 * {@link #setFocusable(boolean) setFocusable()},
 * {@link #setFocusableInTouchMode(boolean) setFocusableInTouchMode()},
 * {@link #setClickable(boolean) setClickable()} or
 * {@link #setLongClickable(boolean) setLongClickable()}.
 *
 * @param selectable Whether the content of this TextView should be selectable.
 * @apiSince 11
 */

public void setTextIsSelectable(boolean selectable) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void getFocusedRect(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of lines of text, or 0 if the internal Layout has not
 * been built.
 * @apiSince 1
 */

public int getLineCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the baseline for the specified line (0...getLineCount() - 1)
 * If bounds is not null, return the top, left, right, bottom extents
 * of the specified line in it. If the internal Layout has not been built,
 * return 0 and set bounds to (0, 0, 0, 0)
 * @param line which line to examine (0..getLineCount() - 1)
 * @param bounds Optional. If not null, it returns the extent of the line
 * @return the Y-coordinate of the baseline
 * @apiSince 1
 */

public int getLineBounds(int line, android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBaseline() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent event, int pointerIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onKeyPreIme(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onCheckIsTextEditor() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) { throw new RuntimeException("Stub!"); }

/**
 * If this TextView contains editable content, extract a portion of it
 * based on the information in <var>request</var> in to <var>outText</var>.
 * @return Returns true if the text was successfully extracted, else false.
 * @apiSince 3
 */

public boolean extractText(android.view.inputmethod.ExtractedTextRequest request, android.view.inputmethod.ExtractedText outText) { throw new RuntimeException("Stub!"); }

/**
 * Apply to this text view the given extracted text, as previously
 * returned by {@link #extractText(android.view.inputmethod.ExtractedTextRequest,android.view.inputmethod.ExtractedText)}.
 * @apiSince 3
 */

public void setExtractedText(android.view.inputmethod.ExtractedText text) { throw new RuntimeException("Stub!"); }

/**
 * Called by the framework in response to a text completion from
 * the current input method, provided by it calling
 * {@link android.view.inputmethod.InputConnection#commitCompletion InputConnection#commitCompletion}.  The default implementation does
 * nothing; text views that are supporting auto-completion should override
 * this to do their desired behavior.
 *
 * @param text The auto complete text the user has selected.
 * @apiSince 3
 */

public void onCommitCompletion(android.view.inputmethod.CompletionInfo text) { throw new RuntimeException("Stub!"); }

/**
 * Called by the framework in response to a text auto-correction (such as fixing a typo using a
 * dictionary) from the current input method, provided by it calling
 * {@link android.view.inputmethod.InputConnection#commitCorrection(android.view.inputmethod.CorrectionInfo) InputConnection#commitCorrection(CorrectionInfo)}.
 * The default implementation flashes the background of the corrected word to provide
 * feedback to the user.
 *
 * @param info The auto correct info about the text that was corrected.
 * @apiSince 11
 */

public void onCommitCorrection(android.view.inputmethod.CorrectionInfo info) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void beginBatchEdit() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void endBatchEdit() { throw new RuntimeException("Stub!"); }

/**
 * Called by the framework in response to a request to begin a batch
 * of edit operations through a call to link {@link #beginBatchEdit()}.
 * @apiSince 3
 */

public void onBeginBatchEdit() { throw new RuntimeException("Stub!"); }

/**
 * Called by the framework in response to a request to end a batch
 * of edit operations through a call to link {@link #endBatchEdit}.
 * @apiSince 3
 */

public void onEndBatchEdit() { throw new RuntimeException("Stub!"); }

/**
 * Called by the framework in response to a private command from the
 * current method, provided by it calling
 * {@link android.view.inputmethod.InputConnection#performPrivateCommand InputConnection#performPrivateCommand}.
 *
 * @param action The action name of the command.
 * @param data Any additional data for the command.  This may be null.
 * @return Return true if you handled the command, else false.
 * @apiSince 3
 */

public boolean onPrivateIMECommand(java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the TextView includes extra top and bottom padding to make
 * room for accents that go above the normal ascent and descent.
 * The default is true.
 *
 * @see #getIncludeFontPadding()
 *
 * @attr ref android.R.styleable#TextView_includeFontPadding
 * @apiSince 1
 */

public void setIncludeFontPadding(boolean includepad) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the TextView includes extra top and bottom padding to make
 * room for accents that go above the normal ascent and descent.
 *
 * @see #setIncludeFontPadding(boolean)
 *
 * @attr ref android.R.styleable#TextView_includeFontPadding
 * @apiSince 16
 */

public boolean getIncludeFontPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Move the point, specified by the offset, into the view if it is needed.
 * This has to be called after layout. Returns true if anything changed.
 * @apiSince 3
 */

public boolean bringPointIntoView(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Move the cursor, if needed, so that it is at an offset that is visible
 * to the user.  This will not move the cursor if it represents more than
 * one character (a selection range).  This will only work if the
 * TextView contains spannable text; otherwise it will do nothing.
 *
 * @return True if the cursor was actually moved, false otherwise.
 * @apiSince 3
 */

public boolean moveCursorToVisibleOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void computeScroll() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void debug(int depth) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link android.text.Selection#getSelectionStart Selection#getSelectionStart}.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="text")
public int getSelectionStart() { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link android.text.Selection#getSelectionEnd Selection#getSelectionEnd}.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="text")
public int getSelectionEnd() { throw new RuntimeException("Stub!"); }

/**
 * Return true iff there is a selection of nonzero length inside this text view.
 * @apiSince 1
 */

public boolean hasSelection() { throw new RuntimeException("Stub!"); }

/**
 * Sets the properties of this field (lines, horizontally scrolling,
 * transformation method) to be for a single-line input.
 *
 * @attr ref android.R.styleable#TextView_singleLine
 * @apiSince 1
 */

public void setSingleLine() { throw new RuntimeException("Stub!"); }

/**
 * Sets the properties of this field to transform input to ALL CAPS
 * display. This may use a "small caps" formatting if available.
 * This setting will be ignored if this field is editable or selectable.
 *
 * This call replaces the current transformation method. Disabling this
 * will not necessarily restore the previous behavior from before this
 * was enabled.
 *
 * @see #setTransformationMethod(TransformationMethod)
 * @attr ref android.R.styleable#TextView_textAllCaps
 * @apiSince 14
 */

public void setAllCaps(boolean allCaps) { throw new RuntimeException("Stub!"); }

/**
 *
 * Checks whether the transformation method applied to this TextView is set to ALL CAPS.
 * @return Whether the current transformation method is for ALL CAPS.
 *
 * @see #setAllCaps(boolean)
 * @see #setTransformationMethod(TransformationMethod)
 @apiSince 28
 */

public boolean isAllCaps() { throw new RuntimeException("Stub!"); }

/**
 * If true, sets the properties of this field (number of lines, horizontally scrolling,
 * transformation method) to be for a single-line input; if false, restores these to the default
 * conditions.
 *
 * Note that the default conditions are not necessarily those that were in effect prior this
 * method, and you may want to reset these properties to your custom values.
 *
 * @attr ref android.R.styleable#TextView_singleLine
 * @apiSince 1
 */

public void setSingleLine(boolean singleLine) { throw new RuntimeException("Stub!"); }

/**
 * Causes words in the text that are longer than the view's width
 * to be ellipsized instead of broken in the middle.  You may also
 * want to {@link #setSingleLine} or {@link #setHorizontallyScrolling}
 * to constrain the text to a single line.  Use <code>null</code>
 * to turn off ellipsizing.
 *
 * If {@link #setMaxLines} has been used to set two or more lines,
 * only {@link android.text.TextUtils.TruncateAt#END} and
 * {@link android.text.TextUtils.TruncateAt#MARQUEE} are supported
 * (other ellipsizing types will not do anything).
 *
 * @attr ref android.R.styleable#TextView_ellipsize
 * @apiSince 1
 */

public void setEllipsize(android.text.TextUtils.TruncateAt where) { throw new RuntimeException("Stub!"); }

/**
 * Sets how many times to repeat the marquee animation. Only applied if the
 * TextView has marquee enabled. Set to -1 to repeat indefinitely.
 *
 * @see #getMarqueeRepeatLimit()
 *
 * @attr ref android.R.styleable#TextView_marqueeRepeatLimit
 * @apiSince 2
 */

public void setMarqueeRepeatLimit(int marqueeLimit) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of times the marquee animation is repeated. Only meaningful if the
 * TextView has marquee enabled.
 *
 * @return the number of times the marquee animation is repeated. -1 if the animation
 * repeats indefinitely
 *
 * @see #setMarqueeRepeatLimit(int)
 *
 * @attr ref android.R.styleable#TextView_marqueeRepeatLimit
 * @apiSince 16
 */

public int getMarqueeRepeatLimit() { throw new RuntimeException("Stub!"); }

/**
 * Returns where, if anywhere, words that are longer than the view
 * is wide should be ellipsized.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty
public android.text.TextUtils.TruncateAt getEllipsize() { throw new RuntimeException("Stub!"); }

/**
 * Set the TextView so that when it takes focus, all the text is
 * selected.
 *
 * @attr ref android.R.styleable#TextView_selectAllOnFocus
 * @apiSince 1
 */

public void setSelectAllOnFocus(boolean selectAllOnFocus) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the cursor is visible. The default is true. Note that this property only
 * makes sense for editable TextView.
 *
 * @see #isCursorVisible()
 *
 * @attr ref android.R.styleable#TextView_cursorVisible
 * @apiSince 1
 */

public void setCursorVisible(boolean visible) { throw new RuntimeException("Stub!"); }

/**
 * @return whether or not the cursor is visible (assuming this TextView is editable)
 *
 * @see #setCursorVisible(boolean)
 *
 * @attr ref android.R.styleable#TextView_cursorVisible
 * @apiSince 16
 */

public boolean isCursorVisible() { throw new RuntimeException("Stub!"); }

/**
 * This method is called when the text is changed, in case any subclasses
 * would like to know.
 *
 * Within <code>text</code>, the <code>lengthAfter</code> characters
 * beginning at <code>start</code> have just replaced old text that had
 * length <code>lengthBefore</code>. It is an error to attempt to make
 * changes to <code>text</code> from this callback.
 *
 * @param text The text the TextView is displaying
 * @param start The offset of the start of the range of the text that was
 * modified
 * @param lengthBefore The length of the former text that has been replaced
 * @param lengthAfter The length of the replacement modified text
 * @apiSince 1
 */

protected void onTextChanged(java.lang.CharSequence text, int start, int lengthBefore, int lengthAfter) { throw new RuntimeException("Stub!"); }

/**
 * This method is called when the selection has changed, in case any
 * subclasses would like to know.
 *
 * @param selStart The new selection start location.
 * @param selEnd The new selection end location.
 * @apiSince 3
 */

protected void onSelectionChanged(int selStart, int selEnd) { throw new RuntimeException("Stub!"); }

/**
 * Adds a TextWatcher to the list of those whose methods are called
 * whenever this TextView's text changes.
 * <p>
 * In 1.0, the {@link android.text.TextWatcher#afterTextChanged TextWatcher#afterTextChanged} method was erroneously
 * not called after {@link #setText} calls.  Now, doing {@link #setText}
 * if there are any text changed listeners forces the buffer type to
 * Editable if it would not otherwise be and does call this method.
 * @apiSince 1
 */

public void addTextChangedListener(android.text.TextWatcher watcher) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified TextWatcher from the list of those whose
 * methods are called
 * whenever this TextView's text changes.
 * @apiSince 1
 */

public void removeTextChangedListener(android.text.TextWatcher watcher) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onWindowFocusChanged(boolean hasWindowFocus) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

protected void onVisibilityChanged(android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Use {@link android.view.inputmethod.BaseInputConnection#removeComposingSpans BaseInputConnection#removeComposingSpans} to remove any IME composing
 * state from this text view.
 * @apiSince 3
 */

public void clearComposingText() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setSelected(boolean selected) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onCreateContextMenu(android.view.ContextMenu menu) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean showContextMenu() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean showContextMenu(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Returns true, only while processing a touch gesture, if the initial
 * touch down event caused focus to move to the text view and as a result
 * its selection changed.  Only valid while processing the touch gesture
 * of interest, in an editable text view.
 * @apiSince 3
 */

public boolean didTouchFocusSelect() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void cancelLongPress() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Scroller used for producing a scrolling animation
 *
 * @param s A Scroller instance
 * @apiSince 1
 */

public void setScroller(android.widget.Scroller s) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected float getLeftFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected float getRightFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeHorizontalScrollRange() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollRange() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollExtent() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void findViewsWithText(java.util.ArrayList<android.view.View> outViews, java.lang.CharSequence searched, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyShortcut(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

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

/**
 * Gets the {@link android.widget.TextView TextView}'s current text for AutoFill. The value is trimmed to 100K
 * {@code char}s if longer.
 *
 * @return current text, {@code null} if the text is not editable
 *
 * @see android.view.View#getAutofillValue()
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.view.autofill.AutofillValue getAutofillValue() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void addExtraDataToAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info, java.lang.String extraDataKey, android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void sendAccessibilityEventUnchecked(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this text view is a current input method target.  The
 * default implementation just checks with {@link android.view.inputmethod.InputMethodManager InputMethodManager}.
 * @return True if the TextView is a current input method target; false otherwise.
 * @apiSince 3
 */

public boolean isInputMethodTarget() { throw new RuntimeException("Stub!"); }

/**
 * Called when a context menu option for the text view is selected.  Currently
 * this will be one of {@link android.R.id#selectAll}, {@link android.R.id#cut},
 * {@link android.R.id#copy}, {@link android.R.id#paste} or {@link android.R.id#shareText}.
 *
 * @return true if the context menu item action was performed.
 * @apiSince 3
 */

public boolean onTextContextMenuItem(int id) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean performLongClick() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) { throw new RuntimeException("Stub!"); }

/**
 * Return whether or not suggestions are enabled on this TextView. The suggestions are generated
 * by the IME or by the spell checker as the user types. This is done by adding
 * {@link android.text.style.SuggestionSpan SuggestionSpan}s to the text.
 *
 * When suggestions are enabled (default), this list of suggestions will be displayed when the
 * user asks for them on these parts of the text. This value depends on the inputType of this
 * TextView.
 *
 * The class of the input type must be {@link android.text.InputType#TYPE_CLASS_TEXT InputType#TYPE_CLASS_TEXT}.
 *
 * In addition, the type variation must be one of
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_NORMAL InputType#TYPE_TEXT_VARIATION_NORMAL},
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_EMAIL_SUBJECT InputType#TYPE_TEXT_VARIATION_EMAIL_SUBJECT},
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_LONG_MESSAGE InputType#TYPE_TEXT_VARIATION_LONG_MESSAGE},
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_SHORT_MESSAGE InputType#TYPE_TEXT_VARIATION_SHORT_MESSAGE} or
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_WEB_EDIT_TEXT InputType#TYPE_TEXT_VARIATION_WEB_EDIT_TEXT}.
 *
 * And finally, the {@link android.text.InputType#TYPE_TEXT_FLAG_NO_SUGGESTIONS InputType#TYPE_TEXT_FLAG_NO_SUGGESTIONS} flag must <i>not</i> be set.
 *
 * @return true if the suggestions popup window is enabled, based on the inputType.
 * @apiSince 14
 */

public boolean isSuggestionsEnabled() { throw new RuntimeException("Stub!"); }

/**
 * If provided, this ActionMode.Callback will be used to create the ActionMode when text
 * selection is initiated in this View.
 *
 * <p>The standard implementation populates the menu with a subset of Select All, Cut, Copy,
 * Paste, Replace and Share actions, depending on what this View supports.
 *
 * <p>A custom implementation can add new entries in the default menu in its
 * {@link android.view.ActionMode.Callback#onPrepareActionMode(ActionMode, android.view.Menu)}
 * method. The default actions can also be removed from the menu using
 * {@link android.view.Menu#removeItem(int)} and passing {@link android.R.id#selectAll},
 * {@link android.R.id#cut}, {@link android.R.id#copy}, {@link android.R.id#paste},
 * {@link android.R.id#replaceText} or {@link android.R.id#shareText} ids as parameters.
 *
 * <p>Returning false from
 * {@link android.view.ActionMode.Callback#onCreateActionMode(ActionMode, android.view.Menu)}
 * will prevent the action mode from being started.
 *
 * <p>Action click events should be handled by the custom implementation of
 * {@link android.view.ActionMode.Callback#onActionItemClicked(ActionMode,
 * android.view.MenuItem)}.
 *
 * <p>Note that text selection mode is not started when a TextView receives focus and the
 * {@link android.R.attr#selectAllOnFocus} flag has been set. The content is highlighted in
 * that case, to allow for quick replacement.
 * @apiSince 11
 */

public void setCustomSelectionActionModeCallback(android.view.ActionMode.Callback actionModeCallback) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the value set in {@link #setCustomSelectionActionModeCallback}. Default is null.
 *
 * @return The current custom selection callback.
 * @apiSince 11
 */

public android.view.ActionMode.Callback getCustomSelectionActionModeCallback() { throw new RuntimeException("Stub!"); }

/**
 * If provided, this ActionMode.Callback will be used to create the ActionMode when text
 * insertion is initiated in this View.
 * The standard implementation populates the menu with a subset of Select All,
 * Paste and Replace actions, depending on what this View supports.
 *
 * <p>A custom implementation can add new entries in the default menu in its
 * {@link android.view.ActionMode.Callback#onPrepareActionMode(android.view.ActionMode,
 * android.view.Menu)} method. The default actions can also be removed from the menu using
 * {@link android.view.Menu#removeItem(int)} and passing {@link android.R.id#selectAll},
 * {@link android.R.id#paste} or {@link android.R.id#replaceText} ids as parameters.</p>
 *
 * <p>Returning false from
 * {@link android.view.ActionMode.Callback#onCreateActionMode(android.view.ActionMode,
 * android.view.Menu)} will prevent the action mode from being started.</p>
 *
 * <p>Action click events should be handled by the custom implementation of
 * {@link android.view.ActionMode.Callback#onActionItemClicked(android.view.ActionMode,
 * android.view.MenuItem)}.</p>
 *
 * <p>Note that text insertion mode is not started when a TextView receives focus and the
 * {@link android.R.attr#selectAllOnFocus} flag has been set.</p>
 * @apiSince 23
 */

public void setCustomInsertionActionModeCallback(android.view.ActionMode.Callback actionModeCallback) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the value set in {@link #setCustomInsertionActionModeCallback}. Default is null.
 *
 * @return The current custom insertion callback.
 * @apiSince 23
 */

public android.view.ActionMode.Callback getCustomInsertionActionModeCallback() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.view.textclassifier.TextClassifier TextClassifier} for this TextView.
 
 * @param textClassifier This value may be {@code null}.
 * @apiSince 26
 */

public void setTextClassifier(@androidx.annotation.Nullable android.view.textclassifier.TextClassifier textClassifier) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.view.textclassifier.TextClassifier TextClassifier} used by this TextView.
 * If no TextClassifier has been set, this TextView uses the default set by the
 * {@link android.view.textclassifier.TextClassificationManager TextClassificationManager}.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier getTextClassifier() { throw new RuntimeException("Stub!"); }

/**
 * Get the character offset closest to the specified absolute position. A typical use case is to
 * pass the result of {@link android.view.MotionEvent#getX() MotionEvent#getX()} and {@link android.view.MotionEvent#getY() MotionEvent#getY()} to this method.
 *
 * @param x The horizontal absolute position of a point on screen
 * @param y The vertical absolute position of a point on screen
 * @return the character offset for the character whose position is closest to the specified
 *  position. Returns -1 if there is no layout.
 * @apiSince 14
 */

public int getOffsetForPosition(float x, float y) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean onDragEvent(android.view.DragEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Returns resolved {@link android.text.TextDirectionHeuristic TextDirectionHeuristic} that will be used for text layout.
 * The {@link android.text.TextDirectionHeuristic TextDirectionHeuristic} that is used by TextView is only available after
 * {@link #getTextDirection()} and {@link #getLayoutDirection()} is resolved. Therefore the
 * return value may not be the same as the one TextView uses if the View's layout direction is
 * not resolved or detached from parent root view.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.text.TextDirectionHeuristic getTextDirectionHeuristic() { throw new RuntimeException("Stub!"); }

/**
 * The TextView does not auto-size text (default).
 * @apiSince 26
 */

public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0; // 0x0

/**
 * The TextView scales text size both horizontally and vertically to fit within the
 * container.
 * @apiSince 26
 */

public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1; // 0x1
/**
 * Type of the text buffer that defines the characteristics of the text such as static,
 * styleable, or editable.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum BufferType {
/** @apiSince 1 */

NORMAL,
/** @apiSince 1 */

SPANNABLE,
/** @apiSince 1 */

EDITABLE;
}

/**
 * Interface definition for a callback to be invoked when an action is
 * performed on the editor.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnEditorActionListener {

/**
 * Called when an action is being performed.
 *
 * @param v The view that was clicked.
 * @param actionId Identifier of the action.  This will be either the
 * identifier you supplied, or {@link android.view.inputmethod.EditorInfo#IME_NULL EditorInfo#IME_NULL} if being called due to the enter key
 * being pressed.
 * @param event If triggered by an enter key, this is the event;
 * otherwise, this is null.
 * @return Return true if you have consumed the action, else false.
 * @apiSince 3
 */

public boolean onEditorAction(android.widget.TextView v, int actionId, android.view.KeyEvent event);
}

/**
 * User interface state that is stored by TextView for implementing
 * {@link android.view.View#onSaveInstanceState View#onSaveInstanceState}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SavedState extends android.view.View.BaseSavedState {

SavedState() { super((android.os.Parcel)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.widget.TextView.SavedState> CREATOR;
static { CREATOR = null; }
}

}

