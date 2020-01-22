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


package android.text;


/**
 * Bit definitions for an integer defining the basic content type of text
 * held in an {@link android.text.Editable Editable} object. Supported classes may be combined
 * with variations and flags to indicate desired behaviors.
 *
 * <h3>Examples</h3>
 *
 * <dl>
 * <dt>A password field with the password visible to the user:
 * <dd>inputType = TYPE_CLASS_TEXT |
 *     TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
 *
 * <dt>A multi-line postal address with automatic capitalization:
 * <dd>inputType = TYPE_CLASS_TEXT |
 *     TYPE_TEXT_VARIATION_POSTAL_ADDRESS |
 *     TYPE_TEXT_FLAG_MULTI_LINE
 *
 * <dt>A time field:
 * <dd>inputType = TYPE_CLASS_DATETIME |
 *     TYPE_DATETIME_VARIATION_TIME
 * </dl>
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface InputType {

/**
 * Class for dates and times.  It supports the
 * following variations:
 * {@link #TYPE_DATETIME_VARIATION_NORMAL}
 * {@link #TYPE_DATETIME_VARIATION_DATE}, and
 * {@link #TYPE_DATETIME_VARIATION_TIME}.
 * @apiSince 3
 */

public static final int TYPE_CLASS_DATETIME = 4; // 0x4

/**
 * Class for numeric text.  This class supports the following flags:
 * {@link #TYPE_NUMBER_FLAG_SIGNED} and
 * {@link #TYPE_NUMBER_FLAG_DECIMAL}.  It also supports the following
 * variations: {@link #TYPE_NUMBER_VARIATION_NORMAL} and
 * {@link #TYPE_NUMBER_VARIATION_PASSWORD}.
 * <p>IME authors: If you do not recognize
 * the variation, normal should be assumed.</p>
 * @apiSince 3
 */

public static final int TYPE_CLASS_NUMBER = 2; // 0x2

/**
 * Class for a phone number.  This class currently supports no variations
 * or flags.
 * @apiSince 3
 */

public static final int TYPE_CLASS_PHONE = 3; // 0x3

/**
 * Class for normal text.  This class supports the following flags (only
 * one of which should be set):
 * {@link #TYPE_TEXT_FLAG_CAP_CHARACTERS},
 * {@link #TYPE_TEXT_FLAG_CAP_WORDS}, and.
 * {@link #TYPE_TEXT_FLAG_CAP_SENTENCES}.  It also supports the
 * following variations:
 * {@link #TYPE_TEXT_VARIATION_NORMAL}, and
 * {@link #TYPE_TEXT_VARIATION_URI}.  If you do not recognize the
 * variation, normal should be assumed.
 * @apiSince 3
 */

public static final int TYPE_CLASS_TEXT = 1; // 0x1

/**
 * Default variation of {@link #TYPE_CLASS_DATETIME}: allows entering
 * only a date.
 * @apiSince 3
 */

public static final int TYPE_DATETIME_VARIATION_DATE = 16; // 0x10

/**
 * Default variation of {@link #TYPE_CLASS_DATETIME}: allows entering
 * both a date and time.
 * @apiSince 3
 */

public static final int TYPE_DATETIME_VARIATION_NORMAL = 0; // 0x0

/**
 * Default variation of {@link #TYPE_CLASS_DATETIME}: allows entering
 * only a time.
 * @apiSince 3
 */

public static final int TYPE_DATETIME_VARIATION_TIME = 32; // 0x20

/**
 * Mask of bits that determine the overall class
 * of text being given.  Currently supported classes are:
 * {@link #TYPE_CLASS_TEXT}, {@link #TYPE_CLASS_NUMBER},
 * {@link #TYPE_CLASS_PHONE}, {@link #TYPE_CLASS_DATETIME}.
 * <p>IME authors: If the class is not one you
 * understand, assume {@link #TYPE_CLASS_TEXT} with NO variation
 * or flags.<p>
 * @apiSince 3
 */

public static final int TYPE_MASK_CLASS = 15; // 0xf

/**
 * Mask of bits that provide addition bit flags
 * of options.
 * @apiSince 3
 */

public static final int TYPE_MASK_FLAGS = 16773120; // 0xfff000

/**
 * Mask of bits that determine the variation of
 * the base content class.
 * @apiSince 3
 */

public static final int TYPE_MASK_VARIATION = 4080; // 0xff0

/**
 * Special content type for when no explicit type has been specified.
 * This should be interpreted to mean that the target input connection
 * is not rich, it can not process and show things like candidate text nor
 * retrieve the current text, so the input method will need to run in a
 * limited "generate key events" mode, if it supports it. Note that some
 * input methods may not support it, for example a voice-based input
 * method will likely not be able to generate key events even if this
 * flag is set.
 * @apiSince 3
 */

public static final int TYPE_NULL = 0; // 0x0

/**
 * Flag of {@link #TYPE_CLASS_NUMBER}: the number is decimal, allowing
 * a decimal point to provide fractional values.
 * @apiSince 3
 */

public static final int TYPE_NUMBER_FLAG_DECIMAL = 8192; // 0x2000

/**
 * Flag of {@link #TYPE_CLASS_NUMBER}: the number is signed, allowing
 * a positive or negative sign at the start.
 * @apiSince 3
 */

public static final int TYPE_NUMBER_FLAG_SIGNED = 4096; // 0x1000

/**
 * Default variation of {@link #TYPE_CLASS_NUMBER}: plain normal
 * numeric text.  This was added in
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB}.  An IME must target
 * this API version or later to see this input type; if it doesn't, a request
 * for this type will be dropped when passed through
 * {@link android.view.inputmethod.EditorInfo#makeCompatible(int)
 * EditorInfo.makeCompatible(int)}.
 * @apiSince 11
 */

public static final int TYPE_NUMBER_VARIATION_NORMAL = 0; // 0x0

/**
 * Variation of {@link #TYPE_CLASS_NUMBER}: entering a numeric password.
 * This was added in {@link android.os.Build.VERSION_CODES#HONEYCOMB}.  An
 * IME must target this API version or later to see this input type; if it
 * doesn't, a request for this type will be dropped when passed
 * through {@link android.view.inputmethod.EditorInfo#makeCompatible(int)
 * EditorInfo.makeCompatible(int)}.
 * @apiSince 11
 */

public static final int TYPE_NUMBER_VARIATION_PASSWORD = 16; // 0x10

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: the text editor (which means
 * the application) is performing auto-completion of the text being entered
 * based on its own semantics, which it will present to the user as they type.
 * This generally means that the input method should not be showing
 * candidates itself, but can expect the editor to supply its own
 * completions/candidates from
 * {@link android.view.inputmethod.InputMethodSession#displayCompletions
 * InputMethodSession.displayCompletions()} as a result of the editor calling
 * {@link android.view.inputmethod.InputMethodManager#displayCompletions
 * InputMethodManager.displayCompletions()}.
 * Note the contrast with {@link #TYPE_TEXT_FLAG_AUTO_CORRECT} and
 * {@link #TYPE_TEXT_FLAG_NO_SUGGESTIONS}:
 * {@code TYPE_TEXT_FLAG_AUTO_COMPLETE} means the editor should show an
 * interface for displaying suggestions, but instead of supplying its own
 * it will rely on the Editor to pass completions/corrections.
 * @apiSince 3
 */

public static final int TYPE_TEXT_FLAG_AUTO_COMPLETE = 65536; // 0x10000

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: the user is entering free-form
 * text that should have auto-correction applied to it. Without this flag,
 * the IME will not try to correct typos. You should always set this flag
 * unless you really expect users to type non-words in this field, for
 * example to choose a name for a character in a game.
 * Contrast this with {@link #TYPE_TEXT_FLAG_AUTO_COMPLETE} and
 * {@link #TYPE_TEXT_FLAG_NO_SUGGESTIONS}:
 * {@code TYPE_TEXT_FLAG_AUTO_CORRECT} means that the IME will try to
 * auto-correct typos as the user is typing, but does not define whether
 * the IME offers an interface to show suggestions.
 * @apiSince 3
 */

public static final int TYPE_TEXT_FLAG_AUTO_CORRECT = 32768; // 0x8000

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: capitalize all characters.  Overrides
 * {@link #TYPE_TEXT_FLAG_CAP_WORDS} and
 * {@link #TYPE_TEXT_FLAG_CAP_SENTENCES}.  This value is explicitly defined
 * to be the same as {@link android.text.TextUtils#CAP_MODE_CHARACTERS TextUtils#CAP_MODE_CHARACTERS}. Of course,
 * this only affects languages where there are upper-case and lower-case letters.
 * @apiSince 3
 */

public static final int TYPE_TEXT_FLAG_CAP_CHARACTERS = 4096; // 0x1000

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: capitalize the first character of
 * each sentence.  This value is explicitly defined
 * to be the same as {@link android.text.TextUtils#CAP_MODE_SENTENCES TextUtils#CAP_MODE_SENTENCES}. For example
 * in English it means to capitalize after a period and a space (note that other
 * languages may have different characters for period, or not use spaces,
 * or use different grammatical rules). Of course,
 * this only affects languages where there are upper-case and lower-case letters.
 * @apiSince 3
 */

public static final int TYPE_TEXT_FLAG_CAP_SENTENCES = 16384; // 0x4000

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: capitalize the first character of
 * every word.  Overrides {@link #TYPE_TEXT_FLAG_CAP_SENTENCES}.  This
 * value is explicitly defined
 * to be the same as {@link android.text.TextUtils#CAP_MODE_WORDS TextUtils#CAP_MODE_WORDS}. Of course,
 * this only affects languages where there are upper-case and lower-case letters.
 * @apiSince 3
 */

public static final int TYPE_TEXT_FLAG_CAP_WORDS = 8192; // 0x2000

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: the regular text view associated
 * with this should not be multi-line, but when a fullscreen input method
 * is providing text it should use multiple lines if it can.
 * @apiSince 3
 */

public static final int TYPE_TEXT_FLAG_IME_MULTI_LINE = 262144; // 0x40000

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: multiple lines of text can be
 * entered into the field.  If this flag is not set, the text field
 * will be constrained to a single line. The IME may also choose not to
 * display an enter key when this flag is not set, as there should be no
 * need to create new lines.
 * @apiSince 3
 */

public static final int TYPE_TEXT_FLAG_MULTI_LINE = 131072; // 0x20000

/**
 * Flag for {@link #TYPE_CLASS_TEXT}: the input method does not need to
 * display any dictionary-based candidates. This is useful for text views that
 * do not contain words from the language and do not benefit from any
 * dictionary-based completions or corrections. It overrides the
 * {@link #TYPE_TEXT_FLAG_AUTO_CORRECT} value when set.
 * Please avoid using this unless you are certain this is what you want.
 * Many input methods need suggestions to work well, for example the ones
 * based on gesture typing. Consider clearing
 * {@link #TYPE_TEXT_FLAG_AUTO_CORRECT} instead if you just do not
 * want the IME to correct typos.
 * Note the contrast with {@link #TYPE_TEXT_FLAG_AUTO_CORRECT} and
 * {@link #TYPE_TEXT_FLAG_AUTO_COMPLETE}:
 * {@code TYPE_TEXT_FLAG_NO_SUGGESTIONS} means the IME does not need to
 * show an interface to display suggestions. Most IMEs will also take this to
 * mean they do not need to try to auto-correct what the user is typing.
 * @apiSince 5
 */

public static final int TYPE_TEXT_FLAG_NO_SUGGESTIONS = 524288; // 0x80000

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering an e-mail address.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_EMAIL_ADDRESS = 32; // 0x20

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering the subject line of
 * an e-mail.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_EMAIL_SUBJECT = 48; // 0x30

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering text to filter contents
 * of a list etc.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_FILTER = 176; // 0xb0

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering the content of a long, possibly
 * formal message such as the body of an e-mail.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_LONG_MESSAGE = 80; // 0x50

/**
 * Default variation of {@link #TYPE_CLASS_TEXT}: plain old normal text.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_NORMAL = 0; // 0x0

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering a password.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_PASSWORD = 128; // 0x80

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering the name of a person.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_PERSON_NAME = 96; // 0x60

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering text for phonetic
 * pronunciation, such as a phonetic name field in contacts. This is mostly
 * useful for languages where one spelling may have several phonetic
 * readings, like Japanese.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_PHONETIC = 192; // 0xc0

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering a postal mailing address.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_POSTAL_ADDRESS = 112; // 0x70

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering a short, possibly informal
 * message such as an instant message or a text message.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_SHORT_MESSAGE = 64; // 0x40

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering a URI.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_URI = 16; // 0x10

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering a password, which should
 * be visible to the user.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_VISIBLE_PASSWORD = 144; // 0x90

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering text inside of a web form.
 * @apiSince 3
 */

public static final int TYPE_TEXT_VARIATION_WEB_EDIT_TEXT = 160; // 0xa0

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering e-mail address inside
 * of a web form.  This was added in
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB}.  An IME must target
 * this API version or later to see this input type; if it doesn't, a request
 * for this type will be seen as {@link #TYPE_TEXT_VARIATION_EMAIL_ADDRESS}
 * when passed through {@link android.view.inputmethod.EditorInfo#makeCompatible(int)
 * EditorInfo.makeCompatible(int)}.
 * @apiSince 11
 */

public static final int TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS = 208; // 0xd0

/**
 * Variation of {@link #TYPE_CLASS_TEXT}: entering password inside
 * of a web form.  This was added in
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB}.  An IME must target
 * this API version or later to see this input type; if it doesn't, a request
 * for this type will be seen as {@link #TYPE_TEXT_VARIATION_PASSWORD}
 * when passed through {@link android.view.inputmethod.EditorInfo#makeCompatible(int)
 * EditorInfo.makeCompatible(int)}.
 * @apiSince 11
 */

public static final int TYPE_TEXT_VARIATION_WEB_PASSWORD = 224; // 0xe0
}

