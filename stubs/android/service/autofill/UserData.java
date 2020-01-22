/*
 * Copyright 2017 The Android Open Source Project
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

import android.service.autofill.FieldClassification.Match;
import android.view.autofill.AutofillManager;

/**
 * Defines the user data used for
 * <a href="AutofillService.html#FieldClassification">field classification</a>.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UserData implements android.os.Parcelable {

private UserData() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the default algorithm that is used to calculate
 * {@link android.service.autofill.FieldClassification.Match#getScore() Match#getScore()} match scores}.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getFieldClassificationAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the algorithm corresponding to the specific autofill category
 * that is used to calculate {@link android.service.autofill.FieldClassification.Match#getScore() Match#getScore()}
 *
 * @param categoryId autofill field category
 *
 * This value must never be {@code null}.
 * @return String name of algorithm, null if none found.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getFieldClassificationAlgorithmForCategory(@androidx.annotation.NonNull java.lang.String categoryId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id.
 * @apiSince 28
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of values that can be added to a {@link android.service.autofill.UserData UserData}.
 * @apiSince 28
 */

public static int getMaxUserDataSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of ids that can be passed to {@link android.service.autofill.FillResponse.Builder#setFieldClassificationIds(android.view.autofill.AutofillId...) FillResponse.Builder#setFieldClassificationIds(android.view.autofill.AutofillId...)}.
 * @apiSince 28
 */

public static int getMaxFieldClassificationIdsSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of unique category ids that can be passed to
 * the builder's constructor and {@link android.service.autofill.UserData.Builder#add(java.lang.String,java.lang.String) Builder#add(String, String)}.
 * @apiSince 28
 */

public static int getMaxCategoryCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimum length of values passed to the builder's constructor or
 * or {@link android.service.autofill.UserData.Builder#add(java.lang.String,java.lang.String) Builder#add(String, String)}.
 * @apiSince 28
 */

public static int getMinValueLength() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum length of values passed to the builder's constructor or
 * or {@link android.service.autofill.UserData.Builder#add(java.lang.String,java.lang.String) Builder#add(String, String)}.
 * @apiSince 28
 */

public static int getMaxValueLength() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.UserData> CREATOR;
static { CREATOR = null; }
/**
 * A builder for {@link android.service.autofill.UserData UserData} objects.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new builder for the user data used for <a href="#FieldClassification">field
 * classification</a>.
 *
 * <p>The user data must contain at least one pair of {@code value} -> {@code categoryId},
 * and more pairs can be added through the {@link #add(java.lang.String,java.lang.String)} method. For example:
 *
 * <pre class="prettyprint">
 * new UserData.Builder("v1", "Bart Simpson", "name")
 *   .add("bart.simpson@example.com", "email")
 *   .add("el_barto@example.com", "email")
 *   .build();
 * </pre>
 *
 * @param id id used to identify the whole {@link android.service.autofill.UserData UserData} object. This id is also returned
 * by {@link android.view.autofill.AutofillManager#getUserDataId() AutofillManager#getUserDataId()}, which can be used to check if the
 * {@link android.service.autofill.UserData UserData} is up-to-date without fetching the whole object (through
 * {@link android.view.autofill.AutofillManager#getUserData() AutofillManager#getUserData()}).
 *
 * This value must never be {@code null}.
 * @param value value of the user data.
 * This value must never be {@code null}.
 * @param categoryId autofill field category.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if any of the following occurs:
 * <ul>
 *   <li>{@code id} is empty</li>
 *   <li>{@code categoryId} is empty</li>
 *   <li>{@code value} is empty</li>
 *   <li>the length of {@code value} is lower than {@link android.service.autofill.UserData#getMinValueLength() UserData#getMinValueLength()}</li>
 *   <li>the length of {@code value} is higher than
 *       {@link android.service.autofill.UserData#getMaxValueLength() UserData#getMaxValueLength()}</li>
 * </ul>
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull java.lang.String id, @androidx.annotation.NonNull java.lang.String value, @androidx.annotation.NonNull java.lang.String categoryId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default algorithm used for
 * <a href="#FieldClassification">field classification</a>.
 *
 * <p>The currently available algorithms can be retrieve through
 * {@link android.view.autofill.AutofillManager#getAvailableFieldClassificationAlgorithms() AutofillManager#getAvailableFieldClassificationAlgorithms()}.
 *
 * <p>If not set, the
 * {@link android.view.autofill.AutofillManager#getDefaultFieldClassificationAlgorithm() AutofillManager#getDefaultFieldClassificationAlgorithm()} is
 * used instead.
 *
 * @param name name of the algorithm or {@code null} to used default.
 * This value may be {@code null}.
 * @param args optional arguments to the algorithm.
 *
 * This value may be {@code null}.
 * @return this builder
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.UserData.Builder setFieldClassificationAlgorithm(@androidx.annotation.Nullable java.lang.String name, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Sets the algorithm used for <a href="#FieldClassification">field classification</a>
 * for the specified category.
 *
 * <p>The currently available algorithms can be retrieved through
 * {@link android.view.autofill.AutofillManager#getAvailableFieldClassificationAlgorithms() AutofillManager#getAvailableFieldClassificationAlgorithms()}.
 *
 * <p>If not set, the
 * {@link android.view.autofill.AutofillManager#getDefaultFieldClassificationAlgorithm() AutofillManager#getDefaultFieldClassificationAlgorithm()} is
 * used instead.
 *
 * @param categoryId autofill field category.
 * This value must never be {@code null}.
 * @param name name of the algorithm or {@code null} to used default.
 * This value may be {@code null}.
 * @param args optional arguments to the algorithm.
 *
 * This value may be {@code null}.
 * @return this builder
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.autofill.UserData.Builder setFieldClassificationAlgorithmForCategory(@androidx.annotation.NonNull java.lang.String categoryId, @androidx.annotation.Nullable java.lang.String name, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new value for user data.
 *
 * @param value value of the user data.
 * This value must never be {@code null}.
 * @param categoryId string used to identify the category the value is associated with.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if:
 * <ul>
 *   <li>{@link #build()} already called</li>
 *   <li>the {@code value} has already been added (<b>Note: </b> this restriction was
 *   lifted on Android {@link android.os.Build.VERSION_CODES#Q} and later)</li>
 *   <li>the number of unique {@code categoryId} values added so far is more than
 *       {@link android.service.autofill.UserData#getMaxCategoryCount() UserData#getMaxCategoryCount()}</li>
 *   <li>the number of {@code values} added so far is is more than
 *       {@link android.service.autofill.UserData#getMaxUserDataSize() UserData#getMaxUserDataSize()}</li>
 * </ul>
 *
 * @throws java.lang.IllegalArgumentException if any of the following occurs:
 * <ul>
 *   <li>{@code id} is empty</li>
 *   <li>{@code categoryId} is empty</li>
 *   <li>{@code value} is empty</li>
 *   <li>the length of {@code value} is lower than {@link android.service.autofill.UserData#getMinValueLength() UserData#getMinValueLength()}</li>
 *   <li>the length of {@code value} is higher than
 *       {@link android.service.autofill.UserData#getMaxValueLength() UserData#getMaxValueLength()}</li>
 * </ul>
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.UserData.Builder add(@androidx.annotation.NonNull java.lang.String value, @androidx.annotation.NonNull java.lang.String categoryId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.service.autofill.UserData UserData} instance.
 *
 * <p>You should not interact with this builder once this method is called.
 *
 * @throws java.lang.IllegalStateException if {@link #build()} was already called.
 *
 * @return The built dataset.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.UserData build() { throw new RuntimeException("Stub!"); }
}

}

