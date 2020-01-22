/*
 * Copyright (C) 2016 The Android Open Source Project
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
import android.app.Activity;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.autofill.AutofillId;

/**
 * Response for an {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}.
 *
 * <p>See the main {@link android.service.autofill.AutofillService AutofillService} documentation for more details and examples.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FillResponse implements android.os.Parcelable {

private FillResponse() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.FillResponse> CREATOR;
static { CREATOR = null; }

/**
 * Flag used to change the behavior of {@link android.service.autofill.FillResponse.Builder#disableAutofill(long) FillResponse.Builder#disableAutofill(long)}&mdash;
 * when this flag is passed to {@link android.service.autofill.FillResponse.Builder#setFlags(int) Builder#setFlags(int)}, autofill is disabled only for the
 * activiy that generated the {@link android.service.autofill.FillRequest FillRequest}, not the whole app.
 * @apiSince 28
 */

public static final int FLAG_DISABLE_ACTIVITY_ONLY = 2; // 0x2

/**
 * Flag used to generate {@link android.service.autofill.FillEventHistory.Event FillEventHistory.Event} of type
 * {@link android.service.autofill.FillEventHistory.Event#TYPE_CONTEXT_COMMITTED FillEventHistory.Event#TYPE_CONTEXT_COMMITTED}&mdash;if this flag is not passed to
 * {@link android.service.autofill.FillResponse.Builder#setFlags(int) Builder#setFlags(int)}, these events are not generated.
 * @apiSince 28
 */

public static final int FLAG_TRACK_CONTEXT_COMMITED = 1; // 0x1
/**
 * Builder for {@link android.service.autofill.FillResponse FillResponse} objects. You must to provide at least
 * one dataset or set an authentication intent with a presentation view.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Triggers a custom UI before before autofilling the screen with any data set in this
 * response.
 *
 * <p><b>Note:</b> Although the name of this method suggests that it should be used just for
 * authentication flow, it can be used for other advanced flows; see {@link android.service.autofill.AutofillService AutofillService}
 * for examples.
 *
 * <p>This is typically useful when a user interaction is required to unlock their
 * data vault if you encrypt the data set labels and data set data. It is recommended
 * to encrypt only the sensitive data and not the data set labels which would allow
 * auth on the data set level leading to a better user experience. Note that if you
 * use sensitive data as a label, for example an email address, then it should also
 * be encrypted. The provided {@link android.app.PendingIntent intent} must be an
 * {@link android.app.Activity Activity} which implements your authentication flow. Also if you provide an auth
 * intent you also need to specify the presentation view to be shown in the fill UI
 * for the user to trigger your authentication flow.
 *
 * <p>When a user triggers autofill, the system launches the provided intent
 * whose extras will have the
 * {@link android.view.autofill.AutofillManager#EXTRA_ASSIST_STRUCTURE screen
 * content} and your {@link android.view.autofill.AutofillManager#EXTRA_CLIENT_STATE
 * client state}. Once you complete your authentication flow you should set the
 * {@link android.app.Activity Activity} result to {@link android.app.Activity#RESULT_OK} and set the
 * {@link android.view.autofill.AutofillManager#EXTRA_AUTHENTICATION_RESULT} extra
 * with the fully populated {@link android.service.autofill.FillResponse FillResponse} (or {@code null} if the screen
 * cannot be autofilled).
 *
 * <p>For example, if you provided an empty {@link android.service.autofill.FillResponse FillResponse} because the
 * user's data was locked and marked that the response needs an authentication then
 * in the response returned if authentication succeeds you need to provide all
 * available data sets some of which may need to be further authenticated, for
 * example a credit card whose CVV needs to be entered.
 *
 * <p>If you provide an authentication intent you must also provide a presentation
 * which is used to visualize visualize the response for triggering the authentication
 * flow.
 *
 * <p><b>Note:</b> Do not make the provided pending intent
 * immutable by using {@link android.app.PendingIntent#FLAG_IMMUTABLE} as the
 * platform needs to fill in the authentication arguments.
 *
 * <p>Theme does not work with RemoteViews layout. Avoid hardcoded text color
 * or background color: Autofill on different platforms may have different themes.
 *
 * @param authentication Intent to an activity with your authentication flow.
 * This value may be {@code null}.
 * @param presentation The presentation to visualize the response.
 * This value may be {@code null}.
 * @param ids id of Views that when focused will display the authentication UI.
 *
 * This value must never be {@code null}.
 * @return This builder.
 *
 * @throws java.lang.IllegalArgumentException if any of the following occurs:
 * <ul>
 *   <li>{@code ids} is {@code null}</li>
 *   <li>{@code ids} is empty</li>
 *   <li>{@code ids} contains a {@code null} element</li>
 *   <li>both {@code authentication} and {@code presentation} are {@code null}</li>
 *   <li>both {@code authentication} and {@code presentation} are non-{@code null}</li>
 * </ul>
 *
 * @throws java.lang.IllegalStateException if a {@link #setHeader(android.widget.RemoteViews) header} or a
 * {@link #setFooter(android.widget.RemoteViews) footer} are already set for this builder.
 *
 * @see android.app.PendingIntent#getIntentSender()
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setAuthentication(@androidx.annotation.NonNull android.view.autofill.AutofillId[] ids, @androidx.annotation.Nullable android.content.IntentSender authentication, @androidx.annotation.Nullable android.widget.RemoteViews presentation) { throw new RuntimeException("Stub!"); }

/**
 * Specifies views that should not trigger new
 * {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal,
 * FillCallback)} requests.
 *
 * <p>This is typically used when the service cannot autofill the view; for example, a
 * text field representing the result of a Captcha challenge.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setIgnoredIds(android.view.autofill.AutofillId... ids) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new {@link android.service.autofill.Dataset Dataset} to this response.
 *
 * <p><b>Note: </b> on Android {@link android.os.Build.VERSION_CODES#O}, the total number of
 * datasets is limited by the Binder transaction size, so it's recommended to keep it
 * small (in the range of 10-20 at most) and use pagination by adding a fake
 * {@link android.service.autofill.Dataset.Builder#setAuthentication(android.content.IntentSender) Dataset.Builder#setAuthentication(IntentSender)} at the end
 * with a presentation string like "Next 10" that would return a new {@link android.service.autofill.FillResponse FillResponse}
 * with the next 10 datasets, and so on. This limitation was lifted on
 * Android {@link android.os.Build.VERSION_CODES#O_MR1}, although the Binder transaction
 * size can still be reached if each dataset itself is too big.
 *
 * @param dataset This value may be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder addDataset(@androidx.annotation.Nullable android.service.autofill.Dataset dataset) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.service.autofill.SaveInfo SaveInfo} associated with this response.
 *
 * @param saveInfo This value must never be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setSaveInfo(@androidx.annotation.NonNull android.service.autofill.SaveInfo saveInfo) { throw new RuntimeException("Stub!"); }

/**
 * Sets a bundle with state that is passed to subsequent APIs that manipulate this response.
 *
 * <p>You can use this bundle to store intermediate state that is passed to subsequent calls
 * to {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal,
 * FillCallback)} and {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)}, and
 * you can also retrieve it by calling {@link android.service.autofill.FillEventHistory.Event#getClientState() FillEventHistory.Event#getClientState()}.
 *
 * <p>If this method is called on multiple {@link android.service.autofill.FillResponse FillResponse} objects for the same
 * screen, just the latest bundle is passed back to the service.
 *
 * @param clientState The custom client state.
 * This value may be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setClientState(@androidx.annotation.Nullable android.os.Bundle clientState) { throw new RuntimeException("Stub!"); }

/**
 * Sets which fields are used for
 * <a href="AutofillService.html#FieldClassification">field classification</a>
 *
 * <p><b>Note:</b> This method automatically adds the
 * {@link android.service.autofill.FillResponse#FLAG_TRACK_CONTEXT_COMMITED FillResponse#FLAG_TRACK_CONTEXT_COMMITED} to the {@link #setFlags(int) flags}.
 
 * @throws java.lang.IllegalArgumentException is length of {@code ids} args is more than
 * {@link android.service.autofill.UserData#getMaxFieldClassificationIdsSize() UserData#getMaxFieldClassificationIdsSize()}.
 * @throws java.lang.IllegalStateException if {@link #build()} or {@link #disableAutofill(long)} was
 * already called.
 * @throws java.lang.NullPointerException if {@code ids} or any element on it is {@code null}.
 
 * @param ids This value must never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setFieldClassificationIds(@androidx.annotation.NonNull android.view.autofill.AutofillId... ids) { throw new RuntimeException("Stub!"); }

/**
 * Sets flags changing the response behavior.
 *
 * @param flags a combination of {@link #FLAG_TRACK_CONTEXT_COMMITED} and
 * {@link #FLAG_DISABLE_ACTIVITY_ONLY}, or {@code 0}.
 *
 * Value is either <code>0</code> or a combination of {@link android.service.autofill.FillResponse#FLAG_TRACK_CONTEXT_COMMITED}, and {@link android.service.autofill.FillResponse#FLAG_DISABLE_ACTIVITY_ONLY}
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Disables autofill for the app or activity.
 *
 * <p>This method is useful to optimize performance in cases where the service knows it
 * can not autofill an app&mdash;for example, when the service has a list of "blacklisted"
 * apps such as office suites.
 *
 * <p>By default, it disables autofill for all activities in the app, unless the response is
 * {@link #setFlags(int) flagged} with {@link #FLAG_DISABLE_ACTIVITY_ONLY}.
 *
 * <p>Autofill for the app or activity is automatically re-enabled after any of the
 * following conditions:
 *
 * <ol>
 *   <li>{@code duration} milliseconds have passed.
 *   <li>The autofill service for the user has changed.
 *   <li>The device has rebooted.
 * </ol>
 *
 * <p><b>Note:</b> Activities that are running when autofill is re-enabled remain
 * disabled for autofill until they finish and restart.
 *
 * @param duration duration to disable autofill, in milliseconds.
 *
 * @return this builder
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code duration} is not a positive number.
 * @throws java.lang.IllegalStateException if either {@link #addDataset(android.service.autofill.Dataset)},
 *       {@link #setAuthentication(android.view.autofill.AutofillId[],android.content.IntentSender,android.widget.RemoteViews)},
 *       {@link #setSaveInfo(android.service.autofill.SaveInfo)}, {@link #setClientState(android.os.Bundle)}, or
 *       {@link #setFieldClassificationIds(android.view.autofill.AutofillId...)} was already called.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder disableAutofill(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Sets a header to be shown as the first element in the list of datasets.
 *
 * <p>When this method is called, you must also {@link #addDataset(android.service.autofill.Dataset) add a dataset},
 * otherwise {@link #build()} throws an {@link java.lang.IllegalStateException IllegalStateException}. Similarly, this
 * method should only be used on {@link android.service.autofill.FillResponse FillResponse} that do not require
 * authentication (as the header could have been set directly in the main presentation in
 * these cases).
 *
 * <p>Theme does not work with RemoteViews layout. Avoid hardcoded text color
 * or background color: Autofill on different platforms may have different themes.
 *
 * @param header a presentation to represent the header. This presentation is not clickable
 * &mdash;calling
 * {@link android.widget.RemoteViews#setOnClickPendingIntent(int,android.app.PendingIntent) RemoteViews#setOnClickPendingIntent(int, android.app.PendingIntent)} on it would
 * have no effect.
 *
 * This value must never be {@code null}.
 * @return this builder
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if an
 * {@link #setAuthentication(android.view.autofill.AutofillId[],android.content.IntentSender,android.widget.RemoteViews) authentication} was
 * already set for this builder.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setHeader(@androidx.annotation.NonNull android.widget.RemoteViews header) { throw new RuntimeException("Stub!"); }

/**
 * Sets a footer to be shown as the last element in the list of datasets.
 *
 * <p>When this method is called, you must also {@link #addDataset(android.service.autofill.Dataset) add a dataset},
 * otherwise {@link #build()} throws an {@link java.lang.IllegalStateException IllegalStateException}. Similarly, this
 * method should only be used on {@link android.service.autofill.FillResponse FillResponse} that do not require
 * authentication (as the footer could have been set directly in the main presentation in
 * these cases).
 *
 * <p>Theme does not work with RemoteViews layout. Avoid hardcoded text color
 * or background color: Autofill on different platforms may have different themes.
 *
 * @param footer a presentation to represent the footer. This presentation is not clickable
 * &mdash;calling
 * {@link android.widget.RemoteViews#setOnClickPendingIntent(int,android.app.PendingIntent) RemoteViews#setOnClickPendingIntent(int, android.app.PendingIntent)} on it would
 * have no effect.
 *
 * This value must never be {@code null}.
 * @return this builder
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if the FillResponse
 * {@link #setAuthentication(android.view.autofill.AutofillId[],android.content.IntentSender,android.widget.RemoteViews)
 * requires authentication}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setFooter(@androidx.annotation.NonNull android.widget.RemoteViews footer) { throw new RuntimeException("Stub!"); }

/**
 * Sets a specific {@link android.service.autofill.UserData UserData} for field classification for this request only.
 *
 * <p>Any fields in this UserData will override corresponding fields in the generic
 * UserData object
 *
 * @param userData This value must never be {@code null}.
 * @return this builder
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if the FillResponse
 * {@link #setAuthentication(android.view.autofill.AutofillId[],android.content.IntentSender,android.widget.RemoteViews)
 * requires authentication}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse.Builder setUserData(@androidx.annotation.NonNull android.service.autofill.UserData userData) { throw new RuntimeException("Stub!"); }

/**
 * Builds a new {@link android.service.autofill.FillResponse FillResponse} instance.
 *
 * @throws java.lang.IllegalStateException if any of the following conditions occur:
 * <ol>
 *   <li>{@link #build()} was already called.
 *   <li>No call was made to {@link #addDataset(android.service.autofill.Dataset)},
 *       {@link #setAuthentication(android.view.autofill.AutofillId[],android.content.IntentSender,android.widget.RemoteViews)},
 *       {@link #setSaveInfo(android.service.autofill.SaveInfo)}, {@link #disableAutofill(long)},
 *       {@link #setClientState(android.os.Bundle)},
 *       or {@link #setFieldClassificationIds(android.view.autofill.AutofillId...)}.
 *   <li>{@link #setHeader(android.widget.RemoteViews)} or {@link #setFooter(android.widget.RemoteViews)} is called
 *       without any previous calls to {@link #addDataset(android.service.autofill.Dataset)}.
 * </ol>
 *
 * @return A built response.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.FillResponse build() { throw new RuntimeException("Stub!"); }
}

}

