/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.app;

import android.os.Bundle;
import android.net.Uri;
import java.util.Map;
import android.content.ClipData;
import java.util.Set;

/**
 * A {@code RemoteInput} object specifies input to be collected from a user to be passed along with
 * an intent inside a {@link android.app.PendingIntent} that is sent.
 * Always use {@link android.app.RemoteInput.Builder RemoteInput.Builder} to create instances of this class.
 * <p class="note"> See
 * <a href="{@docRoot}guide/topics/ui/notifiers/notifications.html#direct">Replying
 * to notifications</a> for more information on how to use this class.
 *
 * <p>The following example adds a {@code RemoteInput} to a {@link android.app.Notification.Action Notification.Action},
 * sets the result key as {@code quick_reply}, and sets the label as {@code Quick reply}.
 * Users are prompted to input a response when they trigger the action. The results are sent along
 * with the intent and can be retrieved with the result key (provided to the {@link android.app.RemoteInput.Builder Builder}
 * constructor) from the Bundle returned by {@link #getResultsFromIntent}.
 *
 * <pre class="prettyprint">
 * public static final String KEY_QUICK_REPLY_TEXT = "quick_reply";
 * Notification.Action action = new Notification.Action.Builder(
 *         R.drawable.reply, &quot;Reply&quot;, actionIntent)
 *         <b>.addRemoteInput(new RemoteInput.Builder(KEY_QUICK_REPLY_TEXT)
 *                 .setLabel("Quick reply").build()</b>)
 *         .build();</pre>
 *
 * <p>When the {@link android.app.PendingIntent} is fired, the intent inside will contain the
 * input results if collected. To access these results, use the {@link #getResultsFromIntent}
 * function. The result values will present under the result key passed to the {@link android.app.RemoteInput.Builder Builder}
 * constructor.
 *
 * <pre class="prettyprint">
 * public static final String KEY_QUICK_REPLY_TEXT = "quick_reply";
 * Bundle results = RemoteInput.getResultsFromIntent(intent);
 * if (results != null) {
 *     CharSequence quickReplyResult = results.getCharSequence(KEY_QUICK_REPLY_TEXT);
 * }</pre>
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RemoteInput implements android.os.Parcelable {

private RemoteInput() { throw new RuntimeException("Stub!"); }

/**
 * Get the key that the result of this input will be set in from the Bundle returned by
 * {@link #getResultsFromIntent} when the {@link android.app.PendingIntent} is sent.
 * @apiSince 20
 */

public java.lang.String getResultKey() { throw new RuntimeException("Stub!"); }

/**
 * Get the label to display to users when collecting this input.
 * @apiSince 20
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Get possible input choices. This can be {@code null} if there are no choices to present.
 * @apiSince 20
 */

public java.lang.CharSequence[] getChoices() { throw new RuntimeException("Stub!"); }

/**
 * Get possible non-textual inputs that are accepted.
 * This can be {@code null} if the input does not accept non-textual values.
 * See {@link android.app.RemoteInput.Builder#setAllowDataType Builder#setAllowDataType}.
 * @apiSince 26
 */

public java.util.Set<java.lang.String> getAllowedDataTypes() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the input only accepts data, meaning {@link #getAllowFreeFormInput}
 * is false, {@link #getChoices} is null or empty, and {@link #getAllowedDataTypes} is
 * non-null and not empty.
 * @apiSince 26
 */

public boolean isDataOnly() { throw new RuntimeException("Stub!"); }

/**
 * Get whether or not users can provide an arbitrary value for
 * input. If you set this to {@code false}, users must select one of the
 * choices in {@link #getChoices}. An {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown
 * if you set this to false and {@link #getChoices} returns {@code null} or empty.
 * @apiSince 20
 */

public boolean getAllowFreeFormInput() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether tapping on a choice should let the user edit the input before it is sent to the
 * app.
 
 * @return Value is {@link android.app.RemoteInput#EDIT_CHOICES_BEFORE_SENDING_AUTO}, {@link android.app.RemoteInput#EDIT_CHOICES_BEFORE_SENDING_DISABLED}, or {@link android.app.RemoteInput#EDIT_CHOICES_BEFORE_SENDING_ENABLED}
 * @apiSince 29
 */

public int getEditChoicesBeforeSending() { throw new RuntimeException("Stub!"); }

/**
 * Get additional metadata carried around with this remote input.
 * @apiSince 20
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Similar as {@link #getResultsFromIntent} but retrieves data results for a
 * specific RemoteInput result. To retrieve a value use:
 * <pre>
 * {@code
 * Map<String, Uri> results =
 *     RemoteInput.getDataResultsFromIntent(intent, REMOTE_INPUT_KEY);
 * if (results != null) {
 *   Uri data = results.get(MIME_TYPE_OF_INTEREST);
 * }
 * }
 * </pre>
 * @param intent The intent object that fired in response to an action or content intent
 *               which also had one or more remote input requested.
 * @param remoteInputResultKey The result key for the RemoteInput you want results for.
 * @apiSince 26
 */

public static java.util.Map<java.lang.String,android.net.Uri> getDataResultsFromIntent(android.content.Intent intent, java.lang.String remoteInputResultKey) { throw new RuntimeException("Stub!"); }

/**
 * Get the remote input text results bundle from an intent. The returned Bundle will
 * contain a key/value for every result key populated with text by remote input collector.
 * Use the {@link android.os.Bundle#getCharSequence(java.lang.String) Bundle#getCharSequence(String)} method to retrieve a value. For non-text
 * results use {@link #getDataResultsFromIntent}.
 * @param intent The intent object that fired in response to an action or content intent
 *               which also had one or more remote input requested.
 * @apiSince 20
 */

public static android.os.Bundle getResultsFromIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Populate an intent object with the text results gathered from remote input. This method
 * should only be called by remote input collection services when sending results to a
 * pending intent.
 * @param remoteInputs The remote inputs for which results are being provided
 * @param intent The intent to add remote inputs to. The {@link android.content.ClipData ClipData}
 *               field of the intent will be modified to contain the results.
 * @param results A bundle holding the remote input results. This bundle should
 *                be populated with keys matching the result keys specified in
 *                {@code remoteInputs} with values being the CharSequence results per key.
 * @apiSince 20
 */

public static void addResultsToIntent(android.app.RemoteInput[] remoteInputs, android.content.Intent intent, android.os.Bundle results) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #addResultsToIntent} but for setting data results. This is used
 * for inputs that accept non-textual results (see {@link android.app.RemoteInput.Builder#setAllowDataType Builder#setAllowDataType}).
 * Only one result can be provided for every mime type accepted by the RemoteInput.
 * If multiple inputs of the same mime type are expected then multiple RemoteInputs
 * should be used.
 *
 * @param remoteInput The remote input for which results are being provided
 * @param intent The intent to add remote input results to. The {@link android.content.ClipData ClipData}
 *               field of the intent will be modified to contain the results.
 * @param results A map of mime type to the Uri result for that mime type.
 * @apiSince 26
 */

public static void addDataResultToIntent(android.app.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String,android.net.Uri> results) { throw new RuntimeException("Stub!"); }

/**
 * Set the source of the RemoteInput results. This method should only be called by remote
 * input collection services (e.g.
 * {@link android.service.notification.NotificationListenerService})
 * when sending results to a pending intent.
 *
 * @see #SOURCE_FREE_FORM_INPUT
 * @see #SOURCE_CHOICE
 *
 * @param intent The intent to add remote input source to. The {@link android.content.ClipData ClipData}
 *               field of the intent will be modified to contain the source.
 * @param source The source of the results.
 
 * Value is {@link android.app.RemoteInput#SOURCE_FREE_FORM_INPUT}, or {@link android.app.RemoteInput#SOURCE_CHOICE}
 * @apiSince 28
 */

public static void setResultsSource(android.content.Intent intent, int source) { throw new RuntimeException("Stub!"); }

/**
 * Get the source of the RemoteInput results.
 *
 * @see #SOURCE_FREE_FORM_INPUT
 * @see #SOURCE_CHOICE
 *
 * @param intent The intent object that fired in response to an action or content intent
 *               which also had one or more remote input requested.
 * @return The source of the results. If no source was set, {@link #SOURCE_FREE_FORM_INPUT} will
 * be returned.
 
 * Value is {@link android.app.RemoteInput#SOURCE_FREE_FORM_INPUT}, or {@link android.app.RemoteInput#SOURCE_CHOICE}
 * @apiSince 28
 */

public static int getResultsSource(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.RemoteInput> CREATOR;
static { CREATOR = null; }

/**
 * The platform will determine whether choices will be edited before being sent to the app.
 * @apiSince 29
 */

public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0; // 0x0

/**
 * Tapping on a choice should send the input immediately, without letting the user edit it.
 * @apiSince 29
 */

public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1; // 0x1

/**
 * Tapping on a choice should let the user edit the input before it is sent to the app.
 * @apiSince 29
 */

public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2; // 0x2

/**
 * Extra added to a clip data intent object to hold the text results bundle.
 * @apiSince 20
 */

public static final java.lang.String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";

/**
 * Label used to denote the clip data type used for remote input transport
 * @apiSince 20
 */

public static final java.lang.String RESULTS_CLIP_LABEL = "android.remoteinput.results";

/**
 * The user selected one of the choices from {@link #getChoices}.
 * @apiSince 28
 */

public static final int SOURCE_CHOICE = 1; // 0x1

/**
 * The user manually entered the data.
 * @apiSince 28
 */

public static final int SOURCE_FREE_FORM_INPUT = 0; // 0x0
/**
 * Builder class for {@link android.app.RemoteInput RemoteInput} objects.
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create a builder object for {@link android.app.RemoteInput RemoteInput} objects.
 *
 * @param resultKey the Bundle key that refers to this input when collected from the user
 
 * This value must never be {@code null}.
 * @apiSince 20
 */

public Builder(@androidx.annotation.NonNull java.lang.String resultKey) { throw new RuntimeException("Stub!"); }

/**
 * Set a label to be displayed to the user when collecting this input.
 *
 * @param label The label to show to users when they input a response
 * This value may be {@code null}.
 * @return this object for method chaining
 
 * This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.RemoteInput.Builder setLabel(@androidx.annotation.Nullable java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Specifies choices available to the user to satisfy this input.
 *
 * <p>Note: Starting in Android P, these choices will always be shown on phones if the app's
 * target SDK is >= P. However, these choices may also be rendered on other types of devices
 * regardless of target SDK.
 *
 * @param choices an array of pre-defined choices for users input.
 *        You must provide a non-null and non-empty array if
 *        you disabled free form input using {@link #setAllowFreeFormInput}
 * This value may be {@code null}.
 * @return this object for method chaining
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.RemoteInput.Builder setChoices(@androidx.annotation.Nullable java.lang.CharSequence[] choices) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the user can provide arbitrary values. This allows an input
 * to accept non-textual values. Examples of usage are an input that wants audio
 * or an image.
 *
 * @param mimeType A mime type that results are allowed to come in.
 *         Be aware that text results (see {@link #setAllowFreeFormInput}
 *         are allowed by default. If you do not want text results you will have to
 *         pass false to {@code setAllowFreeFormInput}
 * This value must never be {@code null}.
 * @param doAllow Whether the mime type should be allowed or not
 * @return this object for method chaining
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.RemoteInput.Builder setAllowDataType(@androidx.annotation.NonNull java.lang.String mimeType, boolean doAllow) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the user can provide arbitrary text values.
 *
 * @param allowFreeFormTextInput The default is {@code true}.
 *         If you specify {@code false}, you must either provide a non-null
 *         and non-empty array to {@link #setChoices}, or enable a data result
 *         in {@code setAllowDataType}. Otherwise an
 *         {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown
 * @return this object for method chaining
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.RemoteInput.Builder setAllowFreeFormInput(boolean allowFreeFormTextInput) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether tapping on a choice should let the user edit the input before it is
 * sent to the app. The default is {@link #EDIT_CHOICES_BEFORE_SENDING_AUTO}.
 *
 * It cannot be used if {@link #setAllowFreeFormInput} has been set to false.
 
 * @param editChoicesBeforeSending Value is {@link android.app.RemoteInput#EDIT_CHOICES_BEFORE_SENDING_AUTO}, {@link android.app.RemoteInput#EDIT_CHOICES_BEFORE_SENDING_DISABLED}, or {@link android.app.RemoteInput#EDIT_CHOICES_BEFORE_SENDING_ENABLED}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.RemoteInput.Builder setEditChoicesBeforeSending(int editChoicesBeforeSending) { throw new RuntimeException("Stub!"); }

/**
 * Merge additional metadata into this builder.
 *
 * <p>Values within the Bundle will replace existing extras values in this Builder.
 *
 * @see android.app.RemoteInput#getExtras
 
 * @param extras This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.RemoteInput.Builder addExtras(@androidx.annotation.NonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Get the metadata Bundle used by this Builder.
 *
 * <p>The returned Bundle is shared with this Builder.
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Combine all of the options that have been set and return a new {@link android.app.RemoteInput RemoteInput}
 * object.
 
 * @return This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.app.RemoteInput build() { throw new RuntimeException("Stub!"); }
}

}

