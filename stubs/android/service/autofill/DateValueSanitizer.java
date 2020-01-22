/*
 * Copyright (C) 2018 The Android Open Source Project
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

import android.icu.text.DateFormat;
import android.view.autofill.AutofillValue;

/**
 * Sanitizes a date {@link android.view.autofill.AutofillValue AutofillValue} using a {@link android.icu.text.DateFormat DateFormat}.
 *
 * <p>For example, to sanitize a credit card expiration date to just its month and year:
 *
 * <pre class="prettyprint">
 * new DateValueSanitizer(new java.text.SimpleDateFormat("MM/yyyy");
 * </pre>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DateValueSanitizer implements android.service.autofill.Sanitizer, android.os.Parcelable {

/**
 * Default constructor.
 *
 * @param dateFormat date format applied to the actual date value of an input field.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public DateValueSanitizer(@androidx.annotation.NonNull android.icu.text.DateFormat dateFormat) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.DateValueSanitizer> CREATOR;
static { CREATOR = null; }
}

