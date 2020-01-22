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
 * This is the interface for text to which markup objects can be
 * attached and detached.  Not all Spannable classes have mutable text;
 * see {@link android.text.Editable Editable} for that.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Spannable extends android.text.Spanned {

/**
 * Attach the specified markup object to the range <code>start&hellip;end</code>
 * of the text, or move the object to that range if it was already
 * attached elsewhere.  See {@link android.text.Spanned Spanned} for an explanation of
 * what the flags mean.  The object can be one that has meaning only
 * within your application, or it can be one that the text system will
 * use to affect text display or behavior.  Some noteworthy ones are
 * the subclasses of {@link android.text.style.CharacterStyle} and
 * {@link android.text.style.ParagraphStyle}, and
 * {@link android.text.TextWatcher} and
 * {@link android.text.SpanWatcher}.
 * @apiSince 1
 */

public void setSpan(java.lang.Object what, int start, int end, int flags);

/**
 * Remove the specified object from the range of text to which it
 * was attached, if any.  It is OK to remove an object that was never
 * attached in the first place.
 * @apiSince 1
 */

public void removeSpan(java.lang.Object what);
/**
 * Factory used by TextView to create new {@link android.text.Spannable Spannable}. You can subclass
 * it to provide something other than {@link android.text.SpannableString SpannableString}.
 *
 * @see android.widget.TextView#setSpannableFactory(Factory)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Factory {

public Factory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the standard Spannable Factory.
 * @apiSince 1
 */

public static android.text.Spannable.Factory getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new SpannableString from the specified CharSequence.
 * You can override this to provide a different kind of Spannable.
 * @apiSince 1
 */

public android.text.Spannable newSpannable(java.lang.CharSequence source) { throw new RuntimeException("Stub!"); }
}

}

