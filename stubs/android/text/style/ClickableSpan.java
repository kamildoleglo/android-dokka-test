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


/**
 * If an object of this type is attached to the text of a TextView
 * with a movement method of LinkMovementMethod, the affected spans of
 * text can be selected. If selected and clicked, the {@link #onClick} method will
 * be called.
 * <p>
 * The text with a <code>ClickableSpan</code> attached will be underlined and the link color will be
 * used as a text color. The default link color is the theme's accent color or
 * <code>android:textColorLink</code> if this attribute is defined in the theme.
 * For example, considering that we have a <code>CustomClickableSpan</code> that extends
 * <code>ClickableSpan</code>, it can be used like this:
 * <pre>{@code SpannableString string = new SpannableString("Text with clickable text");
 *string.setSpan(new CustomClickableSpan(), 10, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/clickablespan.png" />
 * <figcaption>Text with <code>ClickableSpan</code>.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ClickableSpan extends android.text.style.CharacterStyle implements android.text.style.UpdateAppearance {

public ClickableSpan() { throw new RuntimeException("Stub!"); }

/**
 * Performs the click action associated with this span.
 
 * @param widget This value must never be {@code null}.
 * @apiSince 1
 */

public abstract void onClick(@androidx.annotation.NonNull android.view.View widget);

/**
 * Makes the text underlined and in the link color.
 
 * @param ds This value must never be {@code null}.
 * @apiSince 1
 */

public void updateDrawState(@androidx.annotation.NonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

