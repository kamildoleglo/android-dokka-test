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

import java.util.regex.Pattern;
import android.widget.RemoteViews;
import android.content.IntentSender;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;

/**
 * <p>A <code>Dataset</code> object represents a group of fields (key / value pairs) used
 * to autofill parts of a screen.
 *
 * <p>For more information about the role of datasets in the autofill workflow, read
 * <a href="/guide/topics/text/autofill-services">Build autofill services</a> and the
 * <code><a href="/reference/android/service/autofill/AutofillService">AutofillService</a></code>
 * documentation.
 *
 * <a name="BasicUsage"></a>
 * <h3>Basic usage</h3>
 *
 * <p>In its simplest form, a dataset contains one or more fields (comprised of
 * an {@link android.view.autofill.AutofillId AutofillId}, a {@link android.view.autofill.AutofillValue AutofillValue}, and an optional filter
 * {@link java.util.regex.Pattern Pattern}); and one or more {@link android.widget.RemoteViews RemoteViews} for these fields
 * (each field could have its own {@link android.widget.RemoteViews RemoteViews}, or use the default
 * {@link android.widget.RemoteViews RemoteViews} associated with the whole dataset).
 *
 * <p>When an autofill service returns datasets in a {@link android.service.autofill.FillResponse FillResponse}
 * and the screen input is focused in a view that is present in at least one of these datasets,
 * the Android System displays a UI containing the {@link android.widget.RemoteViews RemoteViews} of
 * all datasets pairs that have that view's {@link android.view.autofill.AutofillId AutofillId}. Then, when the user selects a
 * dataset from the UI, all views in that dataset are autofilled.
 *
 * <a name="Authentication"></a>
 * <h3>Dataset authentication</h3>
 *
 * <p>In a more sophisticated form, the dataset values can be protected until the user authenticates
 * the dataset&mdash;in that case, when a dataset is selected by the user, the Android System
 * launches an intent set by the service to "unlock" the dataset.
 *
 * <p>For example, when a data set contains credit card information (such as number,
 * expiration date, and verification code), you could provide a dataset presentation saying
 * "Tap to authenticate". Then when the user taps that option, you would launch an activity asking
 * the user to enter the credit card code, and if the user enters a valid code, you could then
 * "unlock" the dataset.
 *
 * <p>You can also use authenticated datasets to offer an interactive UI for the user. For example,
 * if the activity being autofilled is an account creation screen, you could use an authenticated
 * dataset to automatically generate a random password for the user.
 *
 * <p>See {@link android.service.autofill.Dataset.Builder#setAuthentication(android.content.IntentSender) Dataset.Builder#setAuthentication(IntentSender)} for more details about the dataset
 * authentication mechanism.
 *
 * <a name="Filtering"></a>
 * <h3>Filtering</h3>
 * <p>The autofill UI automatically changes which values are shown based on value of the view
 * anchoring it, following the rules below:
 * <ol>
 *   <li>If the view's {@link android.view.View#getAutofillValue() autofill value} is not
 * {@link android.view.autofill.AutofillValue#isText() AutofillValue#isText()} or is empty, all datasets are shown.
 *   <li>Datasets that have a filter regex (set through
 * {@link android.service.autofill.Dataset.Builder#setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue,java.util.regex.Pattern) Dataset.Builder#setValue(AutofillId, AutofillValue, Pattern)} or
 * {@link android.service.autofill.Dataset.Builder#setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue,java.util.regex.Pattern,android.widget.RemoteViews) Dataset.Builder#setValue(AutofillId, AutofillValue, Pattern, RemoteViews)}) and whose
 * regex matches the view's text value converted to lower case are shown.
 *   <li>Datasets that do not require authentication, have a field value that is
 * {@link android.view.autofill.AutofillValue#isText() AutofillValue#isText()} and whose {@link android.view.autofill.AutofillValue#getTextValue() AutofillValue#getTextValue()} starts
 * with the lower case value of the view's text are shown.
 *   <li>All other datasets are hidden.
 * </ol>
 *
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Dataset implements android.os.Parcelable {

private Dataset() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.Dataset> CREATOR;
static { CREATOR = null; }
/**
 * A builder for {@link android.service.autofill.Dataset Dataset} objects. You must provide at least
 * one value for a field or set an authentication intent.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new builder.
 *
 * @param presentation The presentation used to visualize this dataset.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public Builder(@androidx.annotation.NonNull android.widget.RemoteViews presentation) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new builder for a dataset where each field will be visualized independently.
 *
 * <p>When using this constructor, fields must be set through
 * {@link #setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue,android.widget.RemoteViews)} or
 * {@link #setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue,java.util.regex.Pattern,android.widget.RemoteViews)}.
 * @apiSince 26
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Triggers a custom UI before before autofilling the screen with the contents of this
 * dataset.
 *
 * <p><b>Note:</b> Although the name of this method suggests that it should be used just for
 * authentication flow, it can be used for other advanced flows; see {@link android.service.autofill.AutofillService AutofillService}
 * for examples.
 *
 * <p>This method is called when you need to provide an authentication
 * UI for the data set. For example, when a data set contains credit card information
 * (such as number, expiration date, and verification code), you can display UI
 * asking for the verification code before filing in the data. Even if the
 * data set is completely populated the system will launch the specified authentication
 * intent and will need your approval to fill it in. Since the data set is "locked"
 * until the user authenticates it, typically this data set name is masked
 * (for example, "VISA....1234"). Typically you would want to store the data set
 * labels non-encrypted and the actual sensitive data encrypted and not in memory.
 * This allows showing the labels in the UI while involving the user if one of
 * the items with these labels is chosen. Note that if you use sensitive data as
 * a label, for example an email address, then it should also be encrypted.</p>
 *
 * <p>When a user triggers autofill, the system launches the provided intent
 * whose extras will have the {@link
 * android.view.autofill.AutofillManager#EXTRA_ASSIST_STRUCTURE screen content},
 * and your {@link android.view.autofill.AutofillManager#EXTRA_CLIENT_STATE client
 * state}. Once you complete your authentication flow you should set the activity
 * result to {@link android.app.Activity#RESULT_OK} and provide the fully populated
 * {@link android.service.autofill.Dataset Dataset} or a fully-populated {@link android.service.autofill.FillResponse FillResponse} by
 * setting it to the {@link
 * android.view.autofill.AutofillManager#EXTRA_AUTHENTICATION_RESULT} extra. If you
 * provide a dataset in the result, it will replace the authenticated dataset and
 * will be immediately filled in. If you provide a response, it will replace the
 * current response and the UI will be refreshed. For example, if you provided
 * credit card information without the CVV for the data set in the {@link android.service.autofill.FillResponse FillResponse} then the returned data set should contain the CVV entry.
 *
 * <p><b>Note:</b> Do not make the provided pending intent
 * immutable by using {@link android.app.PendingIntent#FLAG_IMMUTABLE} as the
 * platform needs to fill in the authentication arguments.
 *
 * @param authentication Intent to an activity with your authentication flow.
 * This value may be {@code null}.
 * @return this builder.
 *
 * This value will never be {@code null}.
 * @see android.app.PendingIntent
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.Dataset.Builder setAuthentication(@androidx.annotation.Nullable android.content.IntentSender authentication) { throw new RuntimeException("Stub!"); }

/**
 * Sets the id for the dataset so its usage can be tracked.
 *
 * <p>Dataset usage can be tracked for 2 purposes:
 *
 * <ul>
 *   <li>For statistical purposes, the service can call
 * {@link android.service.autofill.AutofillService#getFillEventHistory() AutofillService#getFillEventHistory()} when handling {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}
 * calls.
 *   <li>For normal autofill workflow, the service can call
 *   {@link android.service.autofill.SaveRequest#getDatasetIds() SaveRequest#getDatasetIds()} when handling
 *   {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)} calls.
 * </ul>
 *
 * @param id id for this dataset or {@code null} to unset.
 *
 * This value may be {@code null}.
 * @return this builder.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.Dataset.Builder setId(@androidx.annotation.Nullable java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of a field.
 *
 * <b>Note:</b> Prior to Android {@link android.os.Build.VERSION_CODES#P}, this method would
 * throw an {@link java.lang.IllegalStateException IllegalStateException} if this builder was constructed without a
 * {@link android.widget.RemoteViews RemoteViews}. Android {@link android.os.Build.VERSION_CODES#P} and
 * higher removed this restriction because datasets used as an
 * {@link android.view.autofill.AutofillManager#EXTRA_AUTHENTICATION_RESULT
 * authentication result} do not need a presentation. But if you don't set the presentation
 * in the constructor in a dataset that is meant to be shown to the user, the autofill UI
 * for this field will not be displayed.
 *
 * <p><b>Note:</b> On Android {@link android.os.Build.VERSION_CODES#P} and
 * higher, datasets that require authentication can be also be filtered by passing a
 * {@link android.view.autofill.AutofillValue#forText(java.lang.CharSequence) AutofillValue#forText(CharSequence)} as the {@code value} parameter.
 *
 * @param id id returned by {@link
 *         android.app.assist.AssistStructure.ViewNode#getAutofillId()}.
 * This value must never be {@code null}.
 * @param value value to be autofilled. Pass {@code null} if you do not have the value
 *        but the target view is a logical part of the dataset. For example, if
 *        the dataset needs authentication and you have no access to the value.
 * This value may be {@code null}.
 * @return this builder.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.Dataset.Builder setValue(@androidx.annotation.NonNull android.view.autofill.AutofillId id, @androidx.annotation.Nullable android.view.autofill.AutofillValue value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of a field, using a custom {@link android.widget.RemoteViews RemoteViews} to
 * visualize it.
 *
 * <p><b>Note:</b> On Android {@link android.os.Build.VERSION_CODES#P} and
 * higher, datasets that require authentication can be also be filtered by passing a
 * {@link android.view.autofill.AutofillValue#forText(java.lang.CharSequence) AutofillValue#forText(CharSequence)} as the  {@code value} parameter.
 *
 * <p>Theme does not work with RemoteViews layout. Avoid hardcoded text color
 * or background color: Autofill on different platforms may have different themes.
 *
 * @param id id returned by {@link
 *         android.app.assist.AssistStructure.ViewNode#getAutofillId()}.
 * This value must never be {@code null}.
 * @param value the value to be autofilled. Pass {@code null} if you do not have the value
 *        but the target view is a logical part of the dataset. For example, if
 *        the dataset needs authentication and you have no access to the value.
 * This value may be {@code null}.
 * @param presentation the presentation used to visualize this field.
 * This value must never be {@code null}.
 * @return this builder.
 *
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.Dataset.Builder setValue(@androidx.annotation.NonNull android.view.autofill.AutofillId id, @androidx.annotation.Nullable android.view.autofill.AutofillValue value, @androidx.annotation.NonNull android.widget.RemoteViews presentation) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of a field using an <a href="#Filtering">explicit filter</a>.
 *
 * <p>This method is typically used when the dataset requires authentication and the service
 * does not know its value but wants to hide the dataset after the user enters a minimum
 * number of characters. For example, if the dataset represents a credit card number and the
 * service does not want to show the "Tap to authenticate" message until the user tapped
 * 4 digits, in which case the filter would be {@code Pattern.compile("\\d.{4,}")}.
 *
 * <p><b>Note:</b> If the dataset requires authentication but the service knows its text
 * value it's easier to filter by calling {@link #setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue)} and
 * use the value to filter.
 *
 * @param id id returned by {@link
 *         android.app.assist.AssistStructure.ViewNode#getAutofillId()}.
 * This value must never be {@code null}.
 * @param value the value to be autofilled. Pass {@code null} if you do not have the value
 *        but the target view is a logical part of the dataset. For example, if
 *        the dataset needs authentication and you have no access to the value.
 * This value may be {@code null}.
 * @param filter regex used to determine if the dataset should be shown in the autofill UI;
 *        when {@code null}, it disables filtering on that dataset (this is the recommended
 *        approach when {@code value} is not {@code null} and field contains sensitive data
 *        such as passwords).
 *
 * This value may be {@code null}.
 * @return this builder.
 * @throws java.lang.IllegalStateException if the builder was constructed without a
 *         {@link android.widget.RemoteViews RemoteViews}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.Dataset.Builder setValue(@androidx.annotation.NonNull android.view.autofill.AutofillId id, @androidx.annotation.Nullable android.view.autofill.AutofillValue value, @androidx.annotation.Nullable java.util.regex.Pattern filter) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of a field, using a custom {@link android.widget.RemoteViews RemoteViews} to
 * visualize it and a <a href="#Filtering">explicit filter</a>.
 *
 * <p>This method is typically used when the dataset requires authentication and the service
 * does not know its value but wants to hide the dataset after the user enters a minimum
 * number of characters. For example, if the dataset represents a credit card number and the
 * service does not want to show the "Tap to authenticate" message until the user tapped
 * 4 digits, in which case the filter would be {@code Pattern.compile("\\d.{4,}")}.
 *
 * <p><b>Note:</b> If the dataset requires authentication but the service knows its text
 * value it's easier to filter by calling
 * {@link #setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue,android.widget.RemoteViews)} and using the value to filter.
 *
 * @param id id returned by {@link
 *         android.app.assist.AssistStructure.ViewNode#getAutofillId()}.
 * This value must never be {@code null}.
 * @param value the value to be autofilled. Pass {@code null} if you do not have the value
 *        but the target view is a logical part of the dataset. For example, if
 *        the dataset needs authentication and you have no access to the value.
 * This value may be {@code null}.
 * @param filter regex used to determine if the dataset should be shown in the autofill UI;
 *        when {@code null}, it disables filtering on that dataset (this is the recommended
 *        approach when {@code value} is not {@code null} and field contains sensitive data
 *        such as passwords).
 * This value may be {@code null}.
 * @param presentation the presentation used to visualize this field.
 *
 * This value must never be {@code null}.
 * @return this builder.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.Dataset.Builder setValue(@androidx.annotation.NonNull android.view.autofill.AutofillId id, @androidx.annotation.Nullable android.view.autofill.AutofillValue value, @androidx.annotation.Nullable java.util.regex.Pattern filter, @androidx.annotation.NonNull android.widget.RemoteViews presentation) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.service.autofill.Dataset Dataset} instance.
 *
 * <p>You should not interact with this builder once this method is called.
 *
 * @throws java.lang.IllegalStateException if no field was set (through
 * {@link #setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue)} or
 * {@link #setValue(android.view.autofill.AutofillId,android.view.autofill.AutofillValue,android.widget.RemoteViews)}).
 *
 * @return The built dataset.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.Dataset build() { throw new RuntimeException("Stub!"); }
}

}

