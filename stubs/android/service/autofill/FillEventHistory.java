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

import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.content.IntentSender;

/**
 * Describes what happened after the last
 * {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}
 * call.
 *
 * <p>This history is typically used to keep track of previous user actions to optimize further
 * requests. For example, the service might return email addresses in alphabetical order by
 * default, but change that order based on the address the user picked on previous requests.
 *
 * <p>The history is not persisted over reboots, and it's cleared every time the service
 * replies to a
 * {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}
 * by calling {@link android.service.autofill.FillCallback#onSuccess(android.service.autofill.FillResponse) FillCallback#onSuccess(FillResponse)} or
 * {@link android.service.autofill.FillCallback#onFailure(java.lang.CharSequence) FillCallback#onFailure(CharSequence)} (if the service doesn't call any of these methods,
 * the history will clear out after some pre-defined time).
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FillEventHistory implements android.os.Parcelable {

FillEventHistory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the client state set in the previous {@link android.service.autofill.FillResponse FillResponse}.
 *
 * <p><b>Note: </b>the state is associated with the app that was autofilled in the previous
 * {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}
 * , which is not necessary the same app being autofilled now.
 *
 * @deprecated use {@link #getEvents()} then {@link android.service.autofill.FillEventHistory.Event#getClientState() Event#getClientState()} instead.
 
 * @return This value may be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public android.os.Bundle getClientState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the events occurred after the latest call to
 * {@link android.service.autofill.FillCallback#onSuccess(android.service.autofill.FillResponse) FillCallback#onSuccess(FillResponse)}.
 *
 * @return The list of events or {@code null} if non occurred.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.util.List<android.service.autofill.FillEventHistory.Event> getEvents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.FillEventHistory> CREATOR;
static { CREATOR = null; }
/**
 * Description of an event that occured after the latest call to
 * {@link android.service.autofill.FillCallback#onSuccess(android.service.autofill.FillResponse) FillCallback#onSuccess(FillResponse)}.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Event {

Event() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of the event.
 *
 * @return The type of the event
 * @apiSince 26
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of dataset the id was on.
 *
 * @return The id of dataset, or {@code null} the event is not associated with a dataset.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.lang.String getDatasetId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the client state from the {@link android.service.autofill.FillResponse FillResponse} used to generate this event.
 *
 * <p><b>Note: </b>the state is associated with the app that was autofilled in the previous
 * {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)},
 * which is not necessary the same app being autofilled now.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.os.Bundle getClientState() { throw new RuntimeException("Stub!"); }

/**
 * Returns which datasets were selected by the user.
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> getSelectedDatasetIds() { throw new RuntimeException("Stub!"); }

/**
 * Returns which datasets were NOT selected by the user.
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> getIgnoredDatasetIds() { throw new RuntimeException("Stub!"); }

/**
 * Returns which fields in the selected datasets were changed by the user after the dataset
 * was selected.
 *
 * <p>For example, server provides:
 *
 * <pre class="prettyprint">
 *  FillResponse response = new FillResponse.Builder()
 *      .addDataset(new Dataset.Builder(presentation1)
 *          .setId("4815")
 *          .setValue(usernameId, AutofillValue.forText("MrPlow"))
 *          .build())
 *      .addDataset(new Dataset.Builder(presentation2)
 *          .setId("162342")
 *          .setValue(passwordId, AutofillValue.forText("D'OH"))
 *          .build())
 *      .build();
 * </pre>
 *
 * <p>User select both datasets (for username and password) but after the fields are
 * autofilled, user changes them to:
 *
 * <pre class="prettyprint">
 *   username = "ElBarto";
 *   password = "AyCaramba";
 * </pre>
 *
 * <p>Then the result is the following map:
 *
 * <pre class="prettyprint">
 *   usernameId => "4815"
 *   passwordId => "162342"
 * </pre>
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.
 *
 * @return map map whose key is the id of the change fields, and value is the id of
 * dataset that has that field and was selected by the user.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Map<android.view.autofill.AutofillId,java.lang.String> getChangedFields() { throw new RuntimeException("Stub!"); }

/**
 * Gets the <a href="AutofillService.html#FieldClassification">field classification</a>
 * results.
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}, when the
 * service requested {@link android.service.autofill.FillResponse.Builder#setFieldClassificationIds(android.view.autofill.AutofillId...) FillResponse.Builder#setFieldClassificationIds(AutofillId...)}.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Map<android.view.autofill.AutofillId,android.service.autofill.FieldClassification> getFieldsClassification() { throw new RuntimeException("Stub!"); }

/**
 * Returns which fields were available on datasets provided by the service but manually
 * entered by the user.
 *
 * <p>For example, server provides:
 *
 * <pre class="prettyprint">
 *  FillResponse response = new FillResponse.Builder()
 *      .addDataset(new Dataset.Builder(presentation1)
 *          .setId("4815")
 *          .setValue(usernameId, AutofillValue.forText("MrPlow"))
 *          .setValue(passwordId, AutofillValue.forText("AyCaramba"))
 *          .build())
 *      .addDataset(new Dataset.Builder(presentation2)
 *          .setId("162342")
 *          .setValue(usernameId, AutofillValue.forText("ElBarto"))
 *          .setValue(passwordId, AutofillValue.forText("D'OH"))
 *          .build())
 *      .addDataset(new Dataset.Builder(presentation3)
 *          .setId("108")
 *          .setValue(usernameId, AutofillValue.forText("MrPlow"))
 *          .setValue(passwordId, AutofillValue.forText("D'OH"))
 *          .build())
 *      .build();
 * </pre>
 *
 * <p>User doesn't select a dataset but manually enters:
 *
 * <pre class="prettyprint">
 *   username = "MrPlow";
 *   password = "D'OH";
 * </pre>
 *
 * <p>Then the result is the following map:
 *
 * <pre class="prettyprint">
 *   usernameId => { "4815", "108"}
 *   passwordId => { "162342", "108" }
 * </pre>
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.
 *
 * @return map map whose key is the id of the manually-entered field, and value is the
 * ids of the datasets that have that value but were not selected by the user.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Map<android.view.autofill.AutofillId,java.util.Set<java.lang.String>> getManuallyEnteredField() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * A {@link android.service.autofill.FillResponse.Builder#setAuthentication(android.view.autofill.AutofillId[],android.content.IntentSender,android.widget.RemoteViews) FillResponse.Builder#setAuthentication(android.view.autofill.AutofillId[],
 * IntentSender, android.widget.RemoteViews)} was selected.
 * @apiSince 26
 */

public static final int TYPE_AUTHENTICATION_SELECTED = 2; // 0x2

/**
 * A committed autofill context for which the autofill service provided datasets.
 *
 * <p>This event is useful to track:
 * <ul>
 *   <li>Which datasets (if any) were selected by the user
 *       ({@link #getSelectedDatasetIds()}).
 *   <li>Which datasets (if any) were NOT selected by the user
 *       ({@link #getIgnoredDatasetIds()}).
 *   <li>Which fields in the selected datasets were changed by the user after the dataset
 *       was selected ({@link #getChangedFields()}.
 *   <li>Which fields match the {@link android.service.autofill.UserData UserData} set by the service.
 * </ul>
 *
 * <p><b>Note: </b>This event is only generated when:
 * <ul>
 *   <li>The autofill context is committed.
 *   <li>The service provides at least one dataset in the
 *       {@link android.service.autofill.FillResponse FillResponse} associated with the context.
 *   <li>The last {@link android.service.autofill.FillResponse FillResponse} associated with the context has the
 *       {@link android.service.autofill.FillResponse#FLAG_TRACK_CONTEXT_COMMITED FillResponse#FLAG_TRACK_CONTEXT_COMMITED} flag.
 * </ul>
 *
 * <p>See {@link android.view.autofill.AutofillManager} for more information about autofill
 * contexts.
 * @apiSince 28
 */

public static final int TYPE_CONTEXT_COMMITTED = 4; // 0x4

/**
 * A {@link android.service.autofill.Dataset.Builder#setAuthentication(android.content.IntentSender) Dataset.Builder#setAuthentication(IntentSender)} was
 * selected. The dataset authenticated can be read from {@link #getDatasetId()}.
 * @apiSince 26
 */

public static final int TYPE_DATASET_AUTHENTICATION_SELECTED = 1; // 0x1

/**
 * A dataset was selected. The dataset selected can be read from {@link #getDatasetId()}.
 *
 * <p><b>Note: </b>on Android {@link android.os.Build.VERSION_CODES#O}, this event was also
 * incorrectly reported after a
 * {@link android.service.autofill.Dataset.Builder#setAuthentication(android.content.IntentSender) Dataset.Builder#setAuthentication(IntentSender)} was
 * selected and the service returned a dataset in the
 * {@link android.view.autofill.AutofillManager#EXTRA_AUTHENTICATION_RESULT AutofillManager#EXTRA_AUTHENTICATION_RESULT} of the activity launched from that
 * {@link android.content.IntentSender IntentSender}. This behavior was fixed on Android
 * {@link android.os.Build.VERSION_CODES#O_MR1}.
 * @apiSince 26
 */

public static final int TYPE_DATASET_SELECTED = 0; // 0x0

/**
 * A save UI was shown.
 * @apiSince 26
 */

public static final int TYPE_SAVE_SHOWN = 3; // 0x3
}

}

