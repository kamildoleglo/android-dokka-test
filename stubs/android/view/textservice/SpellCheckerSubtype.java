/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.view.textservice;

import java.util.Locale;
import android.content.Context;

/**
 * This class is used to specify meta information of a subtype contained in a spell checker.
 * Subtype can describe locale (e.g. en_US, fr_FR...) used for settings.
 *
 * @see android.view.textservice.SpellCheckerInfo
 *
 * @attr ref android.R.styleable#SpellChecker_Subtype_label
 * @attr ref android.R.styleable#SpellChecker_Subtype_languageTag
 * @attr ref android.R.styleable#SpellChecker_Subtype_subtypeLocale
 * @attr ref android.R.styleable#SpellChecker_Subtype_subtypeExtraValue
 * @attr ref android.R.styleable#SpellChecker_Subtype_subtypeId
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SpellCheckerSubtype implements android.os.Parcelable {

/**
 * Constructor.
 * @param nameId The name of the subtype
 * @param locale The locale supported by the subtype
 * @param extraValue The extra value of the subtype
 *
 * @deprecated There is no public API that requires developers to directly instantiate custom
 * {@link android.view.textservice.SpellCheckerSubtype SpellCheckerSubtype} objects right now.  Hence only the system is expected to be able
 * to instantiate {@link android.view.textservice.SpellCheckerSubtype SpellCheckerSubtype} object.
 * @apiSince 14
 */

@Deprecated
public SpellCheckerSubtype(int nameId, java.lang.String locale, java.lang.String extraValue) { throw new RuntimeException("Stub!"); }

/**
 * @return the name of the subtype
 * @apiSince 14
 */

public int getNameResId() { throw new RuntimeException("Stub!"); }

/**
 * @return the locale of the subtype
 *
 * This value will never be {@code null}.
 * @deprecated Use {@link #getLanguageTag()} instead.
 * @apiSince 14
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
 * @return the extra value of the subtype
 * @apiSince 14
 */

public java.lang.String getExtraValue() { throw new RuntimeException("Stub!"); }

/**
 * The string of ExtraValue in subtype should be defined as follows:
 * example: key0,key1=value1,key2,key3,key4=value4
 * @param key the key of extra value
 * @return the subtype contains specified the extra value
 * @apiSince 16
 */

public boolean containsExtraValueKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * The string of ExtraValue in subtype should be defined as follows:
 * example: key0,key1=value1,key2,key3,key4=value4
 * @param key the key of extra value
 * @return the value of the specified key
 * @apiSince 16
 */

public java.lang.String getExtraValueOf(java.lang.String key) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @param context Context will be used for getting Locale and PackageManager.
 * @param packageName The package name of the spell checker
 * @param appInfo The application info of the spell checker
 * @return a display name for this subtype. The string resource of the label (mSubtypeNameResId)
 * can have only one %s in it. If there is, the %s part will be replaced with the locale's
 * display name by the formatter. If there is not, this method simply returns the string
 * specified by mSubtypeNameResId. If mSubtypeNameResId is not specified (== 0), it's up to the
 * framework to generate an appropriate display name.
 * @apiSince 14
 */

public java.lang.CharSequence getDisplayName(android.content.Context context, java.lang.String packageName, android.content.pm.ApplicationInfo appInfo) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textservice.SpellCheckerSubtype> CREATOR;
static { CREATOR = null; }
}

