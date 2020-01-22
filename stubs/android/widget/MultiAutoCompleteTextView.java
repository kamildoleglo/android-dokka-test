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
 * An editable text view, extending {@link android.widget.AutoCompleteTextView AutoCompleteTextView}, that
 * can show completion suggestions for the substring of the text where
 * the user is typing instead of necessarily for the entire thing.
 * <p>
 * You must provide a {@link android.widget.MultiAutoCompleteTextView.Tokenizer Tokenizer} to distinguish the
 * various substrings.
 *
 * <p>The following code snippet shows how to create a text view which suggests
 * various countries names while the user is typing:</p>
 *
 * <pre class="prettyprint">
 * public class CountriesActivity extends Activity {
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.autocomplete_7);
 *
 *         ArrayAdapter&lt;String&gt; adapter = new ArrayAdapter&lt;String&gt;(this,
 *                 android.R.layout.simple_dropdown_item_1line, COUNTRIES);
 *         MultiAutoCompleteTextView textView = findViewById(R.id.edit);
 *         textView.setAdapter(adapter);
 *         textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
 *     }
 *
 *     private static final String[] COUNTRIES = new String[] {
 *         "Belgium", "France", "Italy", "Germany", "Spain"
 *     };
 * }</pre>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MultiAutoCompleteTextView extends android.widget.AutoCompleteTextView {

/** @apiSince 1 */

public MultiAutoCompleteTextView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public MultiAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public MultiAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public MultiAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the Tokenizer that will be used to determine the relevant
 * range of the text where the user is typing.
 * @apiSince 1
 */

public void setTokenizer(android.widget.MultiAutoCompleteTextView.Tokenizer t) { throw new RuntimeException("Stub!"); }

/**
 * Instead of filtering on the entire contents of the edit box,
 * this subclass method filters on the range from
 * {@link android.widget.MultiAutoCompleteTextView.Tokenizer#findTokenStart Tokenizer#findTokenStart} to {@link #getSelectionEnd}
 * if the length of that range meets or exceeds {@link #getThreshold}.
 * @apiSince 1
 */

protected void performFiltering(java.lang.CharSequence text, int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Instead of filtering whenever the total length of the text
 * exceeds the threshhold, this subclass filters only when the
 * length of the range from
 * {@link android.widget.MultiAutoCompleteTextView.Tokenizer#findTokenStart Tokenizer#findTokenStart} to {@link #getSelectionEnd}
 * meets or exceeds {@link #getThreshold}.
 * @apiSince 1
 */

public boolean enoughToFilter() { throw new RuntimeException("Stub!"); }

/**
 * Instead of validating the entire text, this subclass method validates
 * each token of the text individually.  Empty tokens are removed.
 * @apiSince 1
 */

public void performValidation() { throw new RuntimeException("Stub!"); }

/**
 * <p>Starts filtering the content of the drop down list. The filtering
 * pattern is the specified range of text from the edit box. Subclasses may
 * override this method to filter with a different pattern, for
 * instance a smaller substring of <code>text</code>.</p>
 * @apiSince 1
 */

protected void performFiltering(java.lang.CharSequence text, int start, int end, int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * <p>Performs the text completion by replacing the range from
 * {@link android.widget.MultiAutoCompleteTextView.Tokenizer#findTokenStart Tokenizer#findTokenStart} to {@link #getSelectionEnd} by the
 * the result of passing <code>text</code> through
 * {@link android.widget.MultiAutoCompleteTextView.Tokenizer#terminateToken Tokenizer#terminateToken}.
 * In addition, the replaced region will be marked as an AutoText
 * substition so that if the user immediately presses DEL, the
 * completion will be undone.
 * Subclasses may override this method to do some different
 * insertion of the content into the edit box.</p>
 *
 * @param text the selected suggestion in the drop down list
 * @apiSince 1
 */

protected void replaceText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * This simple Tokenizer can be used for lists where the items are
 * separated by a comma and one or more spaces.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CommaTokenizer implements android.widget.MultiAutoCompleteTextView.Tokenizer {

public CommaTokenizer() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int findTokenStart(java.lang.CharSequence text, int cursor) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int findTokenEnd(java.lang.CharSequence text, int cursor) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.CharSequence terminateToken(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Tokenizer {

/**
 * Returns the start of the token that ends at offset
 * <code>cursor</code> within <code>text</code>.
 * @apiSince 1
 */

public int findTokenStart(java.lang.CharSequence text, int cursor);

/**
 * Returns the end of the token (minus trailing punctuation)
 * that begins at offset <code>cursor</code> within <code>text</code>.
 * @apiSince 1
 */

public int findTokenEnd(java.lang.CharSequence text, int cursor);

/**
 * Returns <code>text</code>, modified, if necessary, to ensure that
 * it ends with a token terminator (for example a space or comma).
 * @apiSince 1
 */

public java.lang.CharSequence terminateToken(java.lang.CharSequence text);
}

}

