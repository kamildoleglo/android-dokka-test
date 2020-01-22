/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.service.autofill;

import java.util.regex.Pattern;
import android.view.autofill.AutofillValue;

/**
 * Sanitizes a text {@link android.view.autofill.AutofillValue AutofillValue} using a regular expression (regex) substitution.
 *
 * <p>For example, to remove spaces from groups of 4-digits in a credit card:
 *
 * <pre class="prettyprint">
 * new TextValueSanitizer(Pattern.compile("^(\\d{4})\\s?(\\d{4})\\s?(\\d{4})\\s?(\\d{4})$"),
 *     "$1$2$3$4")
 * </pre>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextValueSanitizer implements android.service.autofill.Sanitizer, android.os.Parcelable {

/**
 * Default constructor.
 *
 * @param regex regular expression with groups (delimited by {@code (} and {@code (}) that
 * are used to substitute parts of the {@link android.view.autofill.AutofillValue#getTextValue() AutofillValue#getTextValue()}.
 * This value must never be {@code null}.
 * @param subst the string that substitutes the matched regex, using {@code $} for
 * group substitution ({@code $1} for 1st group match, {@code $2} for 2nd, etc).
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public TextValueSanitizer(@androidx.annotation.NonNull java.util.regex.Pattern regex, @androidx.annotation.NonNull java.lang.String subst) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.TextValueSanitizer> CREATOR;
static { CREATOR = null; }
}

