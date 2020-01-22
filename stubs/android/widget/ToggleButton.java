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


/**
 * Displays checked/unchecked states as a button
 * with a "light" indicator and by default accompanied with the text "ON" or "OFF".
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/controls/togglebutton.html">Toggle Buttons</a>
 * guide.</p>
 *
 * @attr ref android.R.styleable#ToggleButton_textOn
 * @attr ref android.R.styleable#ToggleButton_textOff
 * @attr ref android.R.styleable#ToggleButton_disabledAlpha
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ToggleButton extends android.widget.CompoundButton {

/** @apiSince 21 */

public ToggleButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ToggleButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ToggleButton(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ToggleButton(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setChecked(boolean checked) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text for when the button is in the checked state.
 *
 * @return The text.
 * @apiSince 1
 */

public java.lang.CharSequence getTextOn() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text for when the button is in the checked state.
 *
 * @param textOn The text.
 * @apiSince 1
 */

public void setTextOn(java.lang.CharSequence textOn) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text for when the button is not in the checked state.
 *
 * @return The text.
 * @apiSince 1
 */

public java.lang.CharSequence getTextOff() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text for when the button is not in the checked state.
 *
 * @param textOff The text.
 * @apiSince 1
 */

public void setTextOff(java.lang.CharSequence textOff) { throw new RuntimeException("Stub!"); }

/**
 * Returns the alpha value of the button when it is disabled
 *
 * @return the alpha value, 0.0-1.0
 
 * Value is between 0.0 and 1.0 inclusive
 * @apiSince 29
 */

public float getDisabledAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onFinishInflate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setBackgroundDrawable(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

