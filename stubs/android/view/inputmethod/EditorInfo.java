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


package android.view.inputmethod;

import android.text.InputType;
import android.os.Parcel;
import android.text.TextUtils;
import android.os.LocaleList;
import android.os.Bundle;

/**
 * An EditorInfo describes several attributes of a text editing object
 * that an input method is communicating with (typically an EditText), most
 * importantly the type of text content it contains and the current cursor position.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EditorInfo implements android.text.InputType, android.os.Parcelable {

public EditorInfo() { throw new RuntimeException("Stub!"); }

/**
 * Ensure that the data in this EditorInfo is compatible with an application
 * that was developed against the given target API version.  This can
 * impact the following input types:
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS InputType#TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS},
 * {@link android.text.InputType#TYPE_TEXT_VARIATION_WEB_PASSWORD InputType#TYPE_TEXT_VARIATION_WEB_PASSWORD},
 * {@link android.text.InputType#TYPE_NUMBER_VARIATION_NORMAL InputType#TYPE_NUMBER_VARIATION_NORMAL},
 * {@link android.text.InputType#TYPE_NUMBER_VARIATION_PASSWORD InputType#TYPE_NUMBER_VARIATION_PASSWORD}.
 *
 * <p>This is called by the framework for input method implementations;
 * you should not generally need to call it yourself.
 *
 * @param targetSdkVersion The API version number that the compatible
 * application was developed against.
 * @apiSince 11
 */

public final void makeCompatible(int targetSdkVersion) { throw new RuntimeException("Stub!"); }

/**
 * Write debug output of this object.
 * @apiSince 3
 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 3
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 3
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.EditorInfo> CREATOR;
static { CREATOR = null; }

/**
 * Bits of {@link #IME_MASK_ACTION}: the action key performs a "done"
 * operation, typically meaning there is nothing more to input and the
 * IME will be closed.
 * @apiSince 3
 */

public static final int IME_ACTION_DONE = 6; // 0x6

/**
 * Bits of {@link #IME_MASK_ACTION}: the action key performs a "go"
 * operation to take the user to the target of the text they typed.
 * Typically used, for example, when entering a URL.
 * @apiSince 3
 */

public static final int IME_ACTION_GO = 2; // 0x2

/**
 * Bits of {@link #IME_MASK_ACTION}: the action key performs a "next"
 * operation, taking the user to the next field that will accept text.
 * @apiSince 3
 */

public static final int IME_ACTION_NEXT = 5; // 0x5

/**
 * Bits of {@link #IME_MASK_ACTION}: there is no available action.
 * @apiSince 3
 */

public static final int IME_ACTION_NONE = 1; // 0x1

/**
 * Bits of {@link #IME_MASK_ACTION}: like {@link #IME_ACTION_NEXT}, but
 * for moving to the previous field.  This will normally not be used to
 * specify an action (since it precludes {@link #IME_ACTION_NEXT}), but
 * can be returned to the app if it sets {@link #IME_FLAG_NAVIGATE_PREVIOUS}.
 * @apiSince 11
 */

public static final int IME_ACTION_PREVIOUS = 7; // 0x7

/**
 * Bits of {@link #IME_MASK_ACTION}: the action key performs a "search"
 * operation, taking the user to the results of searching for the text
 * they have typed (in whatever context is appropriate).
 * @apiSince 3
 */

public static final int IME_ACTION_SEARCH = 3; // 0x3

/**
 * Bits of {@link #IME_MASK_ACTION}: the action key performs a "send"
 * operation, delivering the text to its target.  This is typically used
 * when composing a message in IM or SMS where sending is immediate.
 * @apiSince 3
 */

public static final int IME_ACTION_SEND = 4; // 0x4

/**
 * Bits of {@link #IME_MASK_ACTION}: no specific action has been
 * associated with this editor, let the editor come up with its own if
 * it can.
 * @apiSince 3
 */

public static final int IME_ACTION_UNSPECIFIED = 0; // 0x0

/**
 * Flag of {@link #imeOptions}: used to request an IME that is capable of
 * inputting ASCII characters.  The intention of this flag is to ensure that
 * the user can type Roman alphabet characters in a {@link android.widget.TextView}.
 * It is typically used for an account ID or password input. A lot of the time,
 * IMEs are already able to input ASCII even without being told so (such IMEs
 * already respect this flag in a sense), but there are cases when this is not
 * the default. For instance, users of languages using a different script like
 * Arabic, Greek, Hebrew or Russian typically have a keyboard that can't
 * input ASCII characters by default. Applications need to be
 * aware that the flag is not a guarantee, and some IMEs may not respect it.
 * However, it is strongly recommended for IME authors to respect this flag
 * especially when their IME could end up with a state where only languages
 * using non-ASCII are enabled.
 * @apiSince 16
 */

public static final int IME_FLAG_FORCE_ASCII = -2147483648; // 0x80000000

/**
 * Flag of {@link #imeOptions}: used to specify that there is something
 * interesting that a forward navigation can focus on. This is like using
 * {@link #IME_ACTION_NEXT}, except allows the IME to be multiline (with
 * an enter key) as well as provide forward navigation.  Note that some
 * IMEs may not be able to do this, especially when running on a small
 * screen where there is little space.  In that case it does not need to
 * present a UI for this option.  Like {@link #IME_ACTION_NEXT}, if the
 * user selects the IME's facility to forward navigate, this will show up
 * in the application at {@link android.view.inputmethod.InputConnection#performEditorAction(int) InputConnection#performEditorAction(int)}.
 * @apiSince 11
 */

public static final int IME_FLAG_NAVIGATE_NEXT = 134217728; // 0x8000000

/**
 * Flag of {@link #imeOptions}: like {@link #IME_FLAG_NAVIGATE_NEXT}, but
 * specifies there is something interesting that a backward navigation
 * can focus on.  If the user selects the IME's facility to backward
 * navigate, this will show up in the application as an {@link #IME_ACTION_PREVIOUS}
 * at {@link android.view.inputmethod.InputConnection#performEditorAction(int) InputConnection#performEditorAction(int)}.
 * @apiSince 11
 */

public static final int IME_FLAG_NAVIGATE_PREVIOUS = 67108864; // 0x4000000

/**
 * Flag of {@link #imeOptions}: used in conjunction with one of the actions
 * masked by {@link #IME_MASK_ACTION}, this indicates that the action
 * should not be available as an accessory button on the right of the extracted
 * text when the input method is full-screen. Note that by setting this flag,
 * there can be cases where the action is simply never available to the
 * user. Setting this generally means that you think that in fullscreen mode,
 * where there is little space to show the text, it's not worth taking some
 * screen real estate to display the action and it should be used instead
 * to show more text.
 * @apiSince 3
 */

public static final int IME_FLAG_NO_ACCESSORY_ACTION = 536870912; // 0x20000000

/**
 * Flag of {@link #imeOptions}: used in conjunction with one of the actions
 * masked by {@link #IME_MASK_ACTION}. If this flag is not set, IMEs will
 * normally replace the "enter" key with the action supplied. This flag
 * indicates that the action should not be available in-line as a replacement
 * for the "enter" key. Typically this is because the action has such a
 * significant impact or is not recoverable enough that accidentally hitting
 * it should be avoided, such as sending a message. Note that
 * {@link android.widget.TextView} will automatically set this flag for you
 * on multi-line text views.
 * @apiSince 3
 */

public static final int IME_FLAG_NO_ENTER_ACTION = 1073741824; // 0x40000000

/**
 * Flag of {@link #imeOptions}: used to specify that the IME does not need
 * to show its extracted text UI.  For input methods that may be fullscreen,
 * often when in landscape mode, this allows them to be smaller and let part
 * of the application be shown behind, through transparent UI parts in the
 * fullscreen IME. The part of the UI visible to the user may not be responsive
 * to touch because the IME will receive touch events, which may confuse the
 * user; use {@link #IME_FLAG_NO_FULLSCREEN} instead for a better experience.
 * Using this flag is discouraged and it may become deprecated in the future.
 * Its meaning is unclear in some situations and it may not work appropriately
 * on older versions of the platform.
 * @apiSince 3
 */

public static final int IME_FLAG_NO_EXTRACT_UI = 268435456; // 0x10000000

/**
 * Flag of {@link #imeOptions}: used to request that the IME never go
 * into fullscreen mode.
 * By default, IMEs may go into full screen mode when they think
 * it's appropriate, for example on small screens in landscape
 * orientation where displaying a software keyboard may occlude
 * such a large portion of the screen that the remaining part is
 * too small to meaningfully display the application UI.
 * If this flag is set, compliant IMEs will never go into full screen mode,
 * and always leave some space to display the application UI.
 * Applications need to be aware that the flag is not a guarantee, and
 * some IMEs may ignore it.
 * @apiSince 11
 */

public static final int IME_FLAG_NO_FULLSCREEN = 33554432; // 0x2000000

/**
 * Flag of {@link #imeOptions}: used to request that the IME should not update any personalized
 * data such as typing history and personalized language model based on what the user typed on
 * this text editing object.  Typical use cases are:
 * <ul>
 *     <li>When the application is in a special mode, where user's activities are expected to be
 *     not recorded in the application's history.  Some web browsers and chat applications may
 *     have this kind of modes.</li>
 *     <li>When storing typing history does not make much sense.  Specifying this flag in typing
 *     games may help to avoid typing history from being filled up with words that the user is
 *     less likely to type in their daily life.  Another example is that when the application
 *     already knows that the expected input is not a valid word (e.g. a promotion code that is
 *     not a valid word in any natural language).</li>
 * </ul>
 *
 * <p>Applications need to be aware that the flag is not a guarantee, and some IMEs may not
 * respect it.</p>
 * @apiSince 26
 */

public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216; // 0x1000000

/**
 * Set of bits in {@link #imeOptions} that provide alternative actions
 * associated with the "enter" key.  This both helps the IME provide
 * better feedback about what the enter key will do, and also allows it
 * to provide alternative mechanisms for providing that command.
 * @apiSince 3
 */

public static final int IME_MASK_ACTION = 255; // 0xff

/**
 * Generic unspecified type for {@link #imeOptions}.
 * @apiSince 3
 */

public static final int IME_NULL = 0; // 0x0

/**
 * If {@link #actionLabel} has been given, this is the id for that command
 * when the user presses its button that is delivered back with
 * {@link android.view.inputmethod.InputConnection#performEditorAction(int) InputConnection#performEditorAction(int)}.
 * @apiSince 3
 */

public int actionId = 0; // 0x0

/**
 * In some cases an IME may be able to display an arbitrary label for
 * a command the user can perform, which you can specify here. This is
 * typically used as the label for the action to use in-line as a replacement
 * for the "enter" key (see {@link #actionId}). Remember the key where
 * this will be displayed is typically very small, and there are significant
 * localization challenges to make this fit in all supported languages. Also
 * you can not count absolutely on this being used, as some IMEs may
 * ignore this.
 * @apiSince 3
 */

public java.lang.CharSequence actionLabel;

/**
 * List of acceptable MIME types for
 * {@link android.view.inputmethod.InputConnection#commitContent(android.view.inputmethod.InputContentInfo,int,android.os.Bundle) InputConnection#commitContent(InputContentInfo, int, Bundle)}.
 *
 * <p>{@code null} or an empty array means that
 * {@link android.view.inputmethod.InputConnection#commitContent(android.view.inputmethod.InputContentInfo,int,android.os.Bundle) InputConnection#commitContent(InputContentInfo, int, Bundle)} is not supported in this
 * editor.</p>
 * @apiSince 25
 */

@androidx.annotation.Nullable public java.lang.String[] contentMimeTypes;

/**
 * Any extra data to supply to the input method.  This is for extended
 * communication with specific input methods; the name fields in the
 * bundle should be scoped (such as "com.mydomain.im.SOME_FIELD") so
 * that they don't conflict with others.  This field can be
 * filled in from the {@link android.R.attr#editorExtras}
 * attribute of a TextView.
 * @apiSince 3
 */

public android.os.Bundle extras;

/**
 * Identifier for the editor's field.  This is optional, and may be
 * 0.  By default it is filled in with the result of
 * {@link android.view.View#getId() View.getId()} on the View that
 * is being edited.
 * @apiSince 3
 */

public int fieldId;

/**
 * Additional name for the editor's field.  This can supply additional
 * name information for the field.  By default it is null.  The actual
 * contents have no meaning.
 * @apiSince 3
 */

public java.lang.String fieldName;

/**
 * List of the languages that the user is supposed to switch to no matter what input method
 * subtype is currently used.  This special "hint" can be used mainly for, but not limited to,
 * multilingual users who want IMEs to switch language context automatically.
 *
 * <p>{@code null} means that no special language "hint" is needed.</p>
 *
 * <p><strong>Editor authors:</strong> Specify this only when you are confident that the user
 * will switch to certain languages in this context no matter what input method subtype is
 * currently selected.  Otherwise, keep this {@code null}.  Explicit user actions and/or
 * preferences would be good signals to specify this special "hint",  For example, a chat
 * application may be able to put the last used language at the top of {@link #hintLocales}
 * based on whom the user is going to talk, by remembering what language is used in the last
 * conversation.  Do not specify {@link android.widget.TextView#getTextLocales()} only because
 * it is used for text rendering.</p>
 *
 * @see android.widget.TextView#setImeHintLocales(LocaleList)
 * @see android.widget.TextView#getImeHintLocales()
 * @apiSince 24
 */

@androidx.annotation.Nullable public android.os.LocaleList hintLocales;

/**
 * The "hint" text of the text view, typically shown in-line when the
 * text is empty to tell the user what to enter.
 * @apiSince 3
 */

public java.lang.CharSequence hintText;

/**
 * Extended type information for the editor, to help the IME better
 * integrate with it.
 * @apiSince 3
 */

public int imeOptions = 0; // 0x0

/**
 * The capitalization mode of the first character being edited in the
 * text.  Values may be any combination of
 * {@link android.text.TextUtils#CAP_MODE_CHARACTERS TextUtils#CAP_MODE_CHARACTERS},
 * {@link android.text.TextUtils#CAP_MODE_WORDS TextUtils#CAP_MODE_WORDS}, and
 * {@link android.text.TextUtils#CAP_MODE_SENTENCES TextUtils#CAP_MODE_SENTENCES}, though
 * you should generally just take a non-zero value to mean "start out in
 * caps mode".
 * @apiSince 3
 */

public int initialCapsMode = 0; // 0x0

/**
 * <p>The text offset of the end of the selection at the time editing
 * begins; -1 if not known. Keep in mind that, without knowing the cursor
 * position, many IMEs will not be able to offer their full feature set and
 * may behave in unpredictable ways: pass the actual cursor position
 * here if possible at all.</p>
 *
 * <p>Also, this needs to be the cursor position <strong>right now</strong>,
 * not at some point in the past, even if input is starting in the same text field
 * as before. When the app is filling this object, input is about to start by
 * definition, and this value will override any value the app may have passed to
 * {@link android.view.inputmethod.InputMethodManager#updateSelection(android.view.View,int,int,int,int) InputMethodManager#updateSelection(android.view.View, int, int, int, int)}
 * before.</p>
 * @apiSince 3
 */

public int initialSelEnd = -1; // 0xffffffff

/**
 * The text offset of the start of the selection at the time editing
 * begins; -1 if not known. Keep in mind that, without knowing the cursor
 * position, many IMEs will not be able to offer their full feature set and
 * may even behave in unpredictable ways: pass the actual cursor position
 * here if possible at all.
 *
 * <p>Also, this needs to be the cursor position <strong>right now</strong>,
 * not at some point in the past, even if input is starting in the same text field
 * as before. When the app is filling this object, input is about to start by
 * definition, and this value will override any value the app may have passed to
 * {@link android.view.inputmethod.InputMethodManager#updateSelection(android.view.View,int,int,int,int) InputMethodManager#updateSelection(android.view.View, int, int, int, int)}
 * before.</p>
 * @apiSince 3
 */

public int initialSelStart = -1; // 0xffffffff

/**
 * The content type of the text box, whose bits are defined by
 * {@link android.text.InputType InputType}.
 *
 * @see android.text.InputType
 * @see #TYPE_MASK_CLASS
 * @see #TYPE_MASK_VARIATION
 * @see #TYPE_MASK_FLAGS
 * @apiSince 3
 */

public int inputType = 0; // 0x0

/**
 * A label to show to the user describing the text they are writing.
 * @apiSince 3
 */

public java.lang.CharSequence label;

/**
 * Name of the package that owns this editor.
 *
 * <p><strong>IME authors:</strong> In API level 22
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1} and prior, do not trust this package
 * name. The system had not verified the consistency between the package name here and
 * application's uid. Consider to use {@link android.view.inputmethod.InputBinding#getUid() InputBinding#getUid()}, which is trustworthy.
 * Starting from {@link android.os.Build.VERSION_CODES#M}, the system verifies the consistency
 * between this package name and application uid before {@link android.view.inputmethod.EditorInfo EditorInfo} is passed to the
 * input method.</p>
 *
 * <p><strong>Editor authors:</strong> Starting from {@link android.os.Build.VERSION_CODES#M},
 * the application is no longer
 * able to establish input connections if the package name provided here is inconsistent with
 * application's uid.</p>
 * @apiSince 3
 */

public java.lang.String packageName;

/**
 * A string supplying additional information options that are
 * private to a particular IME implementation.  The string must be
 * scoped to a package owned by the implementation, to ensure there are
 * no conflicts between implementations, but other than that you can put
 * whatever you want in it to communicate with the IME.  For example,
 * you could have a string that supplies an argument like
 * <code>"com.example.myapp.SpecialMode=3"</code>.  This field is can be
 * filled in from the {@link android.R.attr#privateImeOptions}
 * attribute of a TextView.
 * @apiSince 3
 */

public java.lang.String privateImeOptions;
}

