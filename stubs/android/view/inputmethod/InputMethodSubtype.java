/*
 * Copyright (C) 2010 The Android Open Source Project
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

import java.util.Arrays;
import java.util.Locale;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * This class is used to specify meta information of a subtype contained in an input method editor
 * (IME). Subtype can describe locale (e.g. en_US, fr_FR...) and mode (e.g. voice, keyboard...),
 * and is used for IME switch and settings. The input method subtype allows the system to bring up
 * the specified subtype of the designated IME directly.
 *
 * <p>It should be defined in an XML resource file of the input method with the
 * <code>&lt;subtype&gt;</code> element, which resides within an {@code <input-method>} element.
 * For more information, see the guide to
 * <a href="{@docRoot}guide/topics/text/creating-input-method.html">
 * Creating an Input Method</a>.</p>
 *
 * @see android.view.inputmethod.InputMethodInfo
 *
 * @attr ref android.R.styleable#InputMethod_Subtype_label
 * @attr ref android.R.styleable#InputMethod_Subtype_icon
 * @attr ref android.R.styleable#InputMethod_Subtype_languageTag
 * @attr ref android.R.styleable#InputMethod_Subtype_imeSubtypeLocale
 * @attr ref android.R.styleable#InputMethod_Subtype_imeSubtypeMode
 * @attr ref android.R.styleable#InputMethod_Subtype_imeSubtypeExtraValue
 * @attr ref android.R.styleable#InputMethod_Subtype_isAuxiliary
 * @attr ref android.R.styleable#InputMethod_Subtype_overridesImplicitlyEnabledSubtype
 * @attr ref android.R.styleable#InputMethod_Subtype_subtypeId
 * @attr ref android.R.styleable#InputMethod_Subtype_isAsciiCapable
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputMethodSubtype implements android.os.Parcelable {

/**
 * Constructor with no subtype ID specified.
 * @deprecated use {@link android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder InputMethodSubtypeBuilder} instead.
 * Arguments for this constructor have the same meanings as
 * {@link android.view.inputmethod.InputMethodSubtype#InputMethodSubtype(int,int,java.lang.String,java.lang.String,java.lang.String,boolean,boolean,int) InputMethodSubtype#InputMethodSubtype(int, int, String, String, String, boolean,
 * boolean, int)} except "id".
 * @apiSince 14
 */

@Deprecated
public InputMethodSubtype(int nameId, int iconId, java.lang.String locale, java.lang.String mode, java.lang.String extraValue, boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 * @deprecated use {@link android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder InputMethodSubtypeBuilder} instead.
 * "isAsciiCapable" is "false" in this constructor.
 * @param nameId Resource ID of the subtype name string. The string resource may have exactly
 * one %s in it. If there is, the %s part will be replaced with the locale's display name by
 * the formatter. Please refer to {@link #getDisplayName} for details.
 * @param iconId Resource ID of the subtype icon drawable.
 * @param locale The locale supported by the subtype
 * @param mode The mode supported by the subtype
 * @param extraValue The extra value of the subtype. This string is free-form, but the API
 * supplies tools to deal with a key-value comma-separated list; see
 * {@link #containsExtraValueKey} and {@link #getExtraValueOf}.
 * @param isAuxiliary true when this subtype is auxiliary, false otherwise. An auxiliary
 * subtype will not be shown in the list of enabled IMEs for choosing the current IME in
 * the Settings even when this subtype is enabled. Please note that this subtype will still
 * be shown in the list of IMEs in the IME switcher to allow the user to tentatively switch
 * to this subtype while an IME is shown. The framework will never switch the current IME to
 * this subtype by {@link android.view.inputmethod.InputMethodManager#switchToLastInputMethod}.
 * The intent of having this flag is to allow for IMEs that are invoked in a one-shot way as
 * auxiliary input mode, and return to the previous IME once it is finished (e.g. voice input).
 * @param overridesImplicitlyEnabledSubtype true when this subtype should be enabled by default
 * if no other subtypes in the IME are enabled explicitly. Note that a subtype with this
 * parameter being true will not be shown in the list of subtypes in each IME's subtype enabler.
 * Having an "automatic" subtype is an example use of this flag.
 * @param id The unique ID for the subtype. The input method framework keeps track of enabled
 * subtypes by ID. When the IME package gets upgraded, enabled IDs will stay enabled even if
 * other attributes are different. If the ID is unspecified or 0,
 * Arrays.hashCode(new Object[] {locale, mode, extraValue,
 * isAuxiliary, overridesImplicitlyEnabledSubtype, isAsciiCapable}) will be used instead.
 * @apiSince 17
 */

@Deprecated
public InputMethodSubtype(int nameId, int iconId, java.lang.String locale, java.lang.String mode, java.lang.String extraValue, boolean isAuxiliary, boolean overridesImplicitlyEnabledSubtype, int id) { throw new RuntimeException("Stub!"); }

/**
 * @return Resource ID of the subtype name string.
 * @apiSince 11
 */

public int getNameResId() { throw new RuntimeException("Stub!"); }

/**
 * @return Resource ID of the subtype icon drawable.
 * @apiSince 11
 */

public int getIconResId() { throw new RuntimeException("Stub!"); }

/**
 * @return The locale of the subtype. This method returns the "locale" string parameter passed
 * to the constructor.
 *
 * This value will never be {@code null}.
 * @deprecated Use {@link #getLanguageTag()} instead.
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated
@androidx.annotation.NonNull
public java.lang.String getLocale() { throw new RuntimeException("Stub!"); }

/**
 * @return the BCP-47 Language Tag of the subtype.  Returns an empty string when no Language Tag
 * is specified.
 *
 * This value will never be {@code null}.
 * @see java.util.Locale#forLanguageTag(String)
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.lang.String getLanguageTag() { throw new RuntimeException("Stub!"); }

/**
 * @return The mode of the subtype.
 * @apiSince 11
 */

public java.lang.String getMode() { throw new RuntimeException("Stub!"); }

/**
 * @return The extra value of the subtype.
 * @apiSince 11
 */

public java.lang.String getExtraValue() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this subtype is auxiliary, false otherwise. An auxiliary subtype will not be
 * shown in the list of enabled IMEs for choosing the current IME in the Settings even when this
 * subtype is enabled. Please note that this subtype will still be shown in the list of IMEs in
 * the IME switcher to allow the user to tentatively switch to this subtype while an IME is
 * shown. The framework will never switch the current IME to this subtype by
 * {@link android.view.inputmethod.InputMethodManager#switchToLastInputMethod}.
 * The intent of having this flag is to allow for IMEs that are invoked in a one-shot way as
 * auxiliary input mode, and return to the previous IME once it is finished (e.g. voice input).
 * @apiSince 14
 */

public boolean isAuxiliary() { throw new RuntimeException("Stub!"); }

/**
 * @return true when this subtype will be enabled by default if no other subtypes in the IME
 * are enabled explicitly, false otherwise. Note that a subtype with this method returning true
 * will not be shown in the list of subtypes in each IME's subtype enabler. Having an
 * "automatic" subtype is an example use of this flag.
 * @apiSince 14
 */

public boolean overridesImplicitlyEnabledSubtype() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this subtype is Ascii capable, false otherwise. If the subtype is ASCII
 * capable, it should guarantee that the user can input ASCII characters with this subtype.
 * This is important because many password fields only allow ASCII-characters.
 * @apiSince 19
 */

public boolean isAsciiCapable() { throw new RuntimeException("Stub!"); }

/**
 * Returns a display name for this subtype.
 *
 * <p>If {@code subtypeNameResId} is specified (!= 0) text generated from that resource will
 * be returned. The localized string resource of the label should be capitalized for inclusion
 * in UI lists. The string resource may contain at most one {@code %s}. If present, the
 * {@code %s} will be replaced with the display name of the subtype locale in the user's locale.
 *
 * <p>If {@code subtypeNameResId} is not specified (== 0) the framework returns the display name
 * of the subtype locale, as capitalized for use in UI lists, in the user's locale.
 *
 * @param context {@link android.content.Context Context} will be used for getting {@link java.util.Locale Locale} and
 * {@link android.content.pm.PackageManager}.
 * @param packageName The package name of the input method.
 * @param appInfo The {@link android.content.pm.ApplicationInfo ApplicationInfo} of the input method.
 * @return a display name for this subtype.
 
 * This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getDisplayName(android.content.Context context, java.lang.String packageName, android.content.pm.ApplicationInfo appInfo) { throw new RuntimeException("Stub!"); }

/**
 * The string of ExtraValue in subtype should be defined as follows:
 * example: key0,key1=value1,key2,key3,key4=value4
 * @param key The key of extra value
 * @return The subtype contains specified the extra value
 * @apiSince 12
 */

public boolean containsExtraValueKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * The string of ExtraValue in subtype should be defined as follows:
 * example: key0,key1=value1,key2,key3,key4=value4
 * @param key The key of extra value
 * @return The value of the specified key
 * @apiSince 12
 */

public java.lang.String getExtraValueOf(java.lang.String key) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.InputMethodSubtype> CREATOR;
static { CREATOR = null; }
/**
 * InputMethodSubtypeBuilder is a builder class of InputMethodSubtype.
 * This class is designed to be used with
 * {@link android.view.inputmethod.InputMethodManager#setAdditionalInputMethodSubtypes}.
 * The developer needs to be aware of what each parameter means.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class InputMethodSubtypeBuilder {

public InputMethodSubtypeBuilder() { throw new RuntimeException("Stub!"); }

/**
 * @param isAuxiliary should true when this subtype is auxiliary, false otherwise.
 * An auxiliary subtype has the following differences with a regular subtype:
 * - An auxiliary subtype cannot be chosen as the default IME in Settings.
 * - The framework will never switch to this subtype through
 *   {@link android.view.inputmethod.InputMethodManager#switchToLastInputMethod}.
 * Note that the subtype will still be available in the IME switcher.
 * The intent is to allow for IMEs to specify they are meant to be invoked temporarily
 * in a one-shot way, and to return to the previous IME once finished (e.g. voice input).
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setIsAuxiliary(boolean isAuxiliary) { throw new RuntimeException("Stub!"); }

/**
 * @param overridesImplicitlyEnabledSubtype should be true if this subtype should be
 * enabled by default if no other subtypes in the IME are enabled explicitly. Note that a
 * subtype with this parameter set will not be shown in the list of subtypes in each IME's
 * subtype enabler. A canonical use of this would be for an IME to supply an "automatic"
 * subtype that adapts to the current system language.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setOverridesImplicitlyEnabledSubtype(boolean overridesImplicitlyEnabledSubtype) { throw new RuntimeException("Stub!"); }

/**
 * @param isAsciiCapable should be true if this subtype is ASCII capable. If the subtype
 * is ASCII capable, it should guarantee that the user can input ASCII characters with
 * this subtype. This is important because many password fields only allow
 * ASCII-characters.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setIsAsciiCapable(boolean isAsciiCapable) { throw new RuntimeException("Stub!"); }

/**
 * @param subtypeIconResId is a resource ID of the subtype icon drawable.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setSubtypeIconResId(int subtypeIconResId) { throw new RuntimeException("Stub!"); }

/**
 * @param subtypeNameResId is the resource ID of the subtype name string.
 * The string resource may have exactly one %s in it. If present,
 * the %s part will be replaced with the locale's display name by
 * the formatter. Please refer to {@link #getDisplayName} for details.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setSubtypeNameResId(int subtypeNameResId) { throw new RuntimeException("Stub!"); }

/**
 * @param subtypeId is the unique ID for this subtype. The input method framework keeps
 * track of enabled subtypes by ID. When the IME package gets upgraded, enabled IDs will
 * stay enabled even if other attributes are different. If the ID is unspecified or 0,
 * Arrays.hashCode(new Object[] {locale, mode, extraValue,
 * isAuxiliary, overridesImplicitlyEnabledSubtype, isAsciiCapable}) will be used instead.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setSubtypeId(int subtypeId) { throw new RuntimeException("Stub!"); }

/**
 * @param subtypeLocale is the locale supported by this subtype.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setSubtypeLocale(java.lang.String subtypeLocale) { throw new RuntimeException("Stub!"); }

/**
 * @param languageTag is the BCP-47 Language Tag supported by this subtype.
 * @apiSince 24
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setLanguageTag(java.lang.String languageTag) { throw new RuntimeException("Stub!"); }

/**
 * @param subtypeMode is the mode supported by this subtype.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setSubtypeMode(java.lang.String subtypeMode) { throw new RuntimeException("Stub!"); }

/**
 * @param subtypeExtraValue is the extra value of the subtype. This string is free-form,
 * but the API supplies tools to deal with a key-value comma-separated list; see
 * {@link #containsExtraValueKey} and {@link #getExtraValueOf}.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype.InputMethodSubtypeBuilder setSubtypeExtraValue(java.lang.String subtypeExtraValue) { throw new RuntimeException("Stub!"); }

/**
 * @return InputMethodSubtype using parameters in this InputMethodSubtypeBuilder.
 * @apiSince 19
 */

public android.view.inputmethod.InputMethodSubtype build() { throw new RuntimeException("Stub!"); }
}

}

