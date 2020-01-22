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

import android.os.Bundle;

/**
 * This class represents a request to an {@link android.service.autofill.AutofillService AutofillService} to save applicable data entered by the user.
 *
 * @see android.service.autofill.AutofillService#onSaveRequest(SaveRequest, SaveCallback)
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SaveRequest implements android.os.Parcelable {

SaveRequest() { throw new RuntimeException("Stub!"); }

/**
 * Gets the contexts associated with each previous fill request.
 *
 * <p><b>Note:</b> Starting on Android {@link android.os.Build.VERSION_CODES#Q}, it could also
 * include contexts from requests whose {@link android.service.autofill.SaveInfo SaveInfo} had the
 * {@link android.service.autofill.SaveInfo#FLAG_DELAY_SAVE SaveInfo#FLAG_DELAY_SAVE} flag.
 *
 * @return The contexts associated with each previous fill request.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.List<android.service.autofill.FillContext> getFillContexts() { throw new RuntimeException("Stub!"); }

/**
 * Gets the latest client state bundle set by the service in a
 * {@link android.service.autofill.FillResponse.Builder#setClientState(android.os.Bundle) FillResponse.Builder#setClientState(Bundle)}.
 *
 * <p><b>Note:</b> Prior to Android {@link android.os.Build.VERSION_CODES#P}, only client state
 * bundles set by {@link android.service.autofill.FillResponse.Builder#setClientState(android.os.Bundle) FillResponse.Builder#setClientState(Bundle)} were considered. On
 * Android {@link android.os.Build.VERSION_CODES#P} and higher, bundles set in the result of
 * an authenticated request through the
 * {@link android.view.autofill.AutofillManager#EXTRA_CLIENT_STATE} extra are
 * also considered (and take precedence when set).
 *
 * @return The client state.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.os.Bundle getClientState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ids of the datasets selected by the user, in the order in which they were selected.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.util.List<java.lang.String> getDatasetIds() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.SaveRequest> CREATOR;
static { CREATOR = null; }
}

