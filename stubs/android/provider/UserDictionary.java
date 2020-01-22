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


package android.provider;

import java.util.Locale;
import android.content.Context;

/**
 * A provider of user defined words for input methods to use for predictive text input.
 * Applications and input methods may add words into the dictionary. Words can have associated
 * frequency information and locale information.
 *
 * <p><strong>NOTE: </strong>Starting on API 23, the user dictionary is only accessible through
 * IME and spellchecker.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UserDictionary {

public UserDictionary() { throw new RuntimeException("Stub!"); }

/**
 * Authority string for this provider.
 * @apiSince 3
 */

public static final java.lang.String AUTHORITY = "user_dictionary";

/**
 * The content:// style URL for this provider
 * @apiSince 3
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }
/**
 * Contains the user defined words.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Words implements android.provider.BaseColumns {

public Words() { throw new RuntimeException("Stub!"); }

/** Adds a word to the dictionary, with the given frequency and the specified
 *  specified locale type.
 *
 *  @deprecated Please use
 *  {@link #addWord(android.content.Context,java.lang.String,int,java.lang.String,java.util.Locale)} instead.
 *
 *  @param context the current application context
 *  @param word the word to add to the dictionary. This should not be null or
 *  empty.
 *  @param localeType the locale type for this word. It should be one of
 *  {@link #LOCALE_TYPE_ALL} or {@link #LOCALE_TYPE_CURRENT}.
 * @apiSince 3
 * @deprecatedSince 16
 */

@Deprecated
public static void addWord(android.content.Context context, java.lang.String word, int frequency, int localeType) { throw new RuntimeException("Stub!"); }

/** Adds a word to the dictionary, with the given frequency and the specified
 *  locale type.
 *
 *  @param context the current application context
 *  @param word the word to add to the dictionary. This should not be null or
 *  empty.
 *  @param shortcut optional shortcut spelling for this word. When the shortcut
 *  is typed, the word may be suggested by applications that support it. May be null.
 *  @param locale the locale to insert the word for, or null to insert the word
 *  for all locales.
 * @apiSince 16
 */

public static void addWord(android.content.Context context, java.lang.String word, int frequency, java.lang.String shortcut, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * The uid of the application that inserted the word.
 * <p>TYPE: INTEGER</p>
 * @apiSince 3
 */

public static final java.lang.String APP_ID = "appid";

/**
 * The MIME type of a {@link #CONTENT_URI} sub-directory of a single word.
 * @apiSince 3
 */

public static final java.lang.String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.userword";

/**
 * The MIME type of {@link #CONTENT_URI} providing a directory of words.
 * @apiSince 3
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.userword";

/**
 * The content:// style URL for this table
 * @apiSince 3
 */

public static final android.net.Uri CONTENT_URI;
static { CONTENT_URI = null; }

/**
 * Sort by descending order of frequency.
 * @apiSince 3
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "frequency DESC";

/**
 * The frequency column. A value between 1 and 255. Higher values imply higher frequency.
 * <p>TYPE: INTEGER</p>
 * @apiSince 3
 */

public static final java.lang.String FREQUENCY = "frequency";

/**
 * The locale that this word belongs to. Null if it pertains to all
 * locales. Locale is as defined by the string returned by Locale.toString().
 * <p>TYPE: TEXT</p>
 * @apiSince 3
 */

public static final java.lang.String LOCALE = "locale";

/**
 * @deprecated Use {@link #addWord(android.content.Context,java.lang.String,int,java.lang.String,java.util.Locale)}.
 * @apiSince 3
 * @deprecatedSince 16
 */

@Deprecated public static final int LOCALE_TYPE_ALL = 0; // 0x0

/**
 * @deprecated Use {@link #addWord(android.content.Context,java.lang.String,int,java.lang.String,java.util.Locale)}.
 * @apiSince 3
 * @deprecatedSince 16
 */

@Deprecated public static final int LOCALE_TYPE_CURRENT = 1; // 0x1

/**
 * An optional shortcut for this word. When the shortcut is typed, supporting IMEs should
 * suggest the word in this row as an alternate spelling too.
 * @apiSince 16
 */

public static final java.lang.String SHORTCUT = "shortcut";

/**
 * The word column.
 * <p>TYPE: TEXT</p>
 * @apiSince 3
 */

public static final java.lang.String WORD = "word";

/** @apiSince 3 */

public static final java.lang.String _ID = "_id";
}

}

