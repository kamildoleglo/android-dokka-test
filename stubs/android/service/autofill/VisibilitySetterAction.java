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

import android.widget.RemoteViews;
import android.view.View;

/**
 * Action used to change the visibility of other child view in a {@link android.service.autofill.CustomDescription CustomDescription}
 * {@link android.widget.RemoteViews RemoteViews}.
 *
 * <p>See {@link android.service.autofill.CustomDescription.Builder#addOnClickAction(int,android.service.autofill.OnClickAction) CustomDescription.Builder#addOnClickAction(int, OnClickAction)} for more details.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VisibilitySetterAction implements android.service.autofill.OnClickAction, android.os.Parcelable {

private VisibilitySetterAction() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.VisibilitySetterAction> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link android.service.autofill.VisibilitySetterAction VisibilitySetterAction} objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new builder for an action that change the visibility of one child view.
 *
 * @param id view resource id of the children view.
 * @param visibility one of {@link android.view.View#VISIBLE View#VISIBLE}, {@link android.view.View#INVISIBLE View#INVISIBLE}, or
 *            {@link android.view.View#GONE View#GONE}.
 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 * @throws java.lang.IllegalArgumentException if visibility is not one of {@link android.view.View#VISIBLE View#VISIBLE},
 * {@link android.view.View#INVISIBLE View#INVISIBLE}, or {@link android.view.View#GONE View#GONE}.
 * @apiSince 29
 */

public Builder(int id, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Sets the action to changes the visibility of a child view.
 *
 * @param id view resource id of the children view.
 * @param visibility one of {@link android.view.View#VISIBLE View#VISIBLE}, {@link android.view.View#INVISIBLE View#INVISIBLE}, or
 *            {@link android.view.View#GONE View#GONE}.
 * Value is {@link android.view.View#VISIBLE}, {@link android.view.View#INVISIBLE}, or {@link android.view.View#GONE}
 * @throws java.lang.IllegalArgumentException if visibility is not one of {@link android.view.View#VISIBLE View#VISIBLE},
 * {@link android.view.View#INVISIBLE View#INVISIBLE}, or {@link android.view.View#GONE View#GONE}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.autofill.VisibilitySetterAction.Builder setVisibility(int id, int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.service.autofill.VisibilitySetterAction VisibilitySetterAction} instance.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.autofill.VisibilitySetterAction build() { throw new RuntimeException("Stub!"); }
}

}

