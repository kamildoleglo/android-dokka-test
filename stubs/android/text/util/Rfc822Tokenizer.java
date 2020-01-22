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


package android.text.util;

import android.widget.MultiAutoCompleteTextView;

/**
 * This class works as a Tokenizer for MultiAutoCompleteTextView for
 * address list fields, and also provides a method for converting
 * a string of addresses (such as might be typed into such a field)
 * into a series of Rfc822Tokens.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Rfc822Tokenizer implements android.widget.MultiAutoCompleteTextView.Tokenizer {

public Rfc822Tokenizer() { throw new RuntimeException("Stub!"); }

/**
 * This constructor will try to take a string like
 * "Foo Bar (something) &lt;foo\@google.com&gt;,
 * blah\@google.com (something)"
 * and convert it into one or more Rfc822Tokens, output into the supplied
 * collection.
 *
 * It does *not* decode MIME encoded-words; charset conversion
 * must already have taken place if necessary.
 * It will try to be tolerant of broken syntax instead of
 * returning an error.
 *
 * @apiSince 8
 */

public static void tokenize(java.lang.CharSequence text, java.util.Collection<android.text.util.Rfc822Token> out) { throw new RuntimeException("Stub!"); }

/**
 * This method will try to take a string like
 * "Foo Bar (something) &lt;foo\@google.com&gt;,
 * blah\@google.com (something)"
 * and convert it into one or more Rfc822Tokens.
 * It does *not* decode MIME encoded-words; charset conversion
 * must already have taken place if necessary.
 * It will try to be tolerant of broken syntax instead of
 * returning an error.
 * @apiSince 1
 */

public static android.text.util.Rfc822Token[] tokenize(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public int findTokenStart(java.lang.CharSequence text, int cursor) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public int findTokenEnd(java.lang.CharSequence text, int cursor) { throw new RuntimeException("Stub!"); }

/**
 * Terminates the specified address with a comma and space.
 * This assumes that the specified text already has valid syntax.
 * The Adapter subclass's convertToString() method must make that
 * guarantee.
 * @apiSince 1
 */

public java.lang.CharSequence terminateToken(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }
}

