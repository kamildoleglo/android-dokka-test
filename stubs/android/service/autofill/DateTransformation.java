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

import android.widget.TextView;
import android.view.autofill.AutofillValue;

/**
 * Replaces a {@link android.widget.TextView TextView} child of a {@link android.service.autofill.CustomDescription CustomDescription} with the contents of a field
 * that is expected to have a {@link android.view.autofill.AutofillValue#forDate(long) AutofillValue#forDate(long)}.
 *
 * <p>For example, a transformation to display a credit card expiration date as month/year would be:
 *
 * <pre class="prettyprint">
 * new DateTransformation(ccExpDate, new java.text.SimpleDateFormat("MM/yyyy")
 * </pre>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DateTransformation implements android.service.autofill.Transformation, android.os.Parcelable {

/**
 * Creates a new transformation.
 *
 * @param id id of the screen field.
 * This value must never be {@code null}.
 * @param dateFormat object used to transform the date value of the field to a String.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public DateTransformation(@androidx.annotation.NonNull android.view.autofill.AutofillId id, @androidx.annotation.NonNull android.icu.text.DateFormat dateFormat) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.DateTransformation> CREATOR;
static { CREATOR = null; }
}

