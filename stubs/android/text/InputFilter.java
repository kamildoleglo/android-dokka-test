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


package android.text;


/**
 * InputFilters can be attached to {@link android.text.Editable Editable}s to constrain the
 * changes that can be made to them.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface InputFilter {

/**
 * This method is called when the buffer is going to replace the
 * range <code>dstart &hellip; dend</code> of <code>dest</code>
 * with the new text from the range <code>start &hellip; end</code>
 * of <code>source</code>.  Return the CharSequence that you would
 * like to have placed there instead, including an empty string
 * if appropriate, or <code>null</code> to accept the original
 * replacement.  Be careful to not to reject 0-length replacements,
 * as this is what happens when you delete text.  Also beware that
 * you should not attempt to make any changes to <code>dest</code>
 * from this method; you may only examine it for context.
 *
 * Note: If <var>source</var> is an instance of {@link android.text.Spanned Spanned} or
 * {@link android.text.Spannable Spannable}, the span objects in the <var>source</var> should be
 * copied into the filtered result (i.e. the non-null return value).
 * {@link android.text.TextUtils#copySpansFrom TextUtils#copySpansFrom} can be used for convenience if the
 * span boundary indices would be remaining identical relative to the source.
 * @apiSince 1
 */

public java.lang.CharSequence filter(java.lang.CharSequence source, int start, int end, android.text.Spanned dest, int dstart, int dend);
/**
 * This filter will capitalize all the lowercase and titlecase letters that are added
 * through edits. (Note that if there are no lowercase or titlecase letters in the input, the
 * text would not be transformed, even if the result of capitalization of the string is
 * different from the string.)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AllCaps implements android.text.InputFilter {

/** @apiSince 1 */

public AllCaps() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a locale-specific AllCaps filter, to make sure capitalization rules of that
 * locale are used for transforming the sequence.
 
 * @param locale This value must never be {@code null}.
 * @apiSince 27
 */

public AllCaps(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.CharSequence filter(java.lang.CharSequence source, int start, int end, android.text.Spanned dest, int dstart, int dend) { throw new RuntimeException("Stub!"); }
}

/**
 * This filter will constrain edits not to make the length of the text
 * greater than the specified length.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LengthFilter implements android.text.InputFilter {

/** @apiSince 1 */

public LengthFilter(int max) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.CharSequence filter(java.lang.CharSequence source, int start, int end, android.text.Spanned dest, int dstart, int dend) { throw new RuntimeException("Stub!"); }

/**
 * @return the maximum length enforced by this input filter
 * @apiSince 21
 */

public int getMax() { throw new RuntimeException("Stub!"); }
}

}

