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
import android.os.CancellationSignal;
import android.view.autofill.AutofillId;

/**
 * This class represents a context for each fill request made via {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, CancellationSignal, FillCallback)}.
 * It contains a snapshot of the UI state, the view ids that were returned by
 * the {@link android.service.autofill.AutofillService AutofillService} as both required to trigger a save
 * and optional that can be saved, and the id of the corresponding {@link android.service.autofill.FillRequest FillRequest}.
 * <p>
 * This context allows you to inspect the values for the interesting views
 * in the context they appeared. Also a reference to the corresponding fill
 * request is useful to store meta-data in the client state bundle passed
 * to {@link android.service.autofill.FillResponse.Builder#setClientState(android.os.Bundle) FillResponse.Builder#setClientState(Bundle)} to avoid interpreting
 * the UI state again while saving.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FillContext implements android.os.Parcelable {

FillContext() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the {@link android.service.autofill.FillRequest FillRequest} this context
 * corresponds to. This is useful to associate your custom client
 * state with every request to avoid reinterpreting the UI when saving
 * user data.
 *
 * @return The request id.
 * @apiSince 26
 */

public int getRequestId() { throw new RuntimeException("Stub!"); }

/**
 * @return The screen content.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.assist.AssistStructure getStructure() { throw new RuntimeException("Stub!"); }

/**
 * @return the AutofillId of the view that triggered autofill.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.autofill.AutofillId getFocusedId() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.FillContext> CREATOR;
static { CREATOR = null; }
}

