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


/**
 * Defines if a field is valid based on a regular expression (regex).
 *
 * <p>See {@link android.service.autofill.SaveInfo.Builder#setValidator(android.service.autofill.Validator) SaveInfo.Builder#setValidator(Validator)} for examples.
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RegexValidator implements android.service.autofill.Validator, android.os.Parcelable {

/**
 * Default constructor.
 *
 * @param id id of the field whose regex is applied to.
 * This value must never be {@code null}.
 * @param regex regular expression that defines the result of the validator: if the regex
 * matches the contents of the field identified by {@code id}, it returns {@code true};
 * otherwise, it returns {@code false}.
 
 * This value must never be {@code null}.
 * @apiSince 27
 */

public RegexValidator(@androidx.annotation.NonNull android.view.autofill.AutofillId id, @androidx.annotation.NonNull java.util.regex.Pattern regex) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.RegexValidator> CREATOR;
static { CREATOR = null; }
}

