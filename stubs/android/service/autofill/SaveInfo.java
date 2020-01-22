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

import android.app.Activity;
import android.view.autofill.AutofillManager;
import android.content.IntentSender;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;

/**
 * Information used to indicate that an {@link android.service.autofill.AutofillService AutofillService} is interested on saving the
 * user-inputed data for future use, through a
 * {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)}
 * call.
 *
 * <p>A {@link android.service.autofill.SaveInfo SaveInfo} is always associated with a {@link android.service.autofill.FillResponse FillResponse}, and it contains at least
 * two pieces of information:
 *
 * <ol>
 *   <li>The type(s) of user data (like password or credit card info) that would be saved.
 *   <li>The minimum set of views (represented by their {@link android.view.autofill.AutofillId AutofillId}) that need to be changed
 *       to trigger a save request.
 * </ol>
 *
 * <p>Typically, the {@link android.service.autofill.SaveInfo SaveInfo} contains the same {@code id}s as the {@link android.service.autofill.Dataset Dataset}:
 *
 * <pre class="prettyprint">
 *   new FillResponse.Builder()
 *       .addDataset(new Dataset.Builder()
 *           .setValue(id1, AutofillValue.forText("homer"), createPresentation("homer")) // username
 *           .setValue(id2, AutofillValue.forText("D'OH!"), createPresentation("password for homer")) // password
 *           .build())
 *       .setSaveInfo(new SaveInfo.Builder(
 *           SaveInfo.SAVE_DATA_TYPE_USERNAME | SaveInfo.SAVE_DATA_TYPE_PASSWORD,
 *           new AutofillId[] { id1, id2 }).build())
 *       .build();
 * </pre>
 *
 * <p>The save type flags are used to display the appropriate strings in the autofill save UI.
 * You can pass multiple values, but try to keep it short if possible. In the above example, just
 * {@code SaveInfo.SAVE_DATA_TYPE_PASSWORD} would be enough.
 *
 * <p>There might be cases where the {@link android.service.autofill.AutofillService AutofillService} knows how to fill the screen,
 * but the user has no data for it. In that case, the {@link android.service.autofill.FillResponse FillResponse} should contain just the
 * {@link android.service.autofill.SaveInfo SaveInfo}, but no {@link android.service.autofill.Dataset Dataset}:
 *
 * <pre class="prettyprint">
 *   new FillResponse.Builder()
 *       .setSaveInfo(new SaveInfo.Builder(SaveInfo.SAVE_DATA_TYPE_PASSWORD,
 *           new AutofillId[] { id1, id2 }).build())
 *       .build();
 * </pre>
 *
 * <p>There might be cases where the user data in the {@link android.service.autofill.AutofillService AutofillService} is enough
 * to populate some fields but not all, and the service would still be interested on saving the
 * other fields. In that case, the service could set the
 * {@link android.service.autofill.SaveInfo.Builder#setOptionalIds(android.view.autofill.AutofillId[]) SaveInfo.Builder#setOptionalIds(AutofillId[])} as well:
 *
 * <pre class="prettyprint">
 *   new FillResponse.Builder()
 *       .addDataset(new Dataset.Builder()
 *           .setValue(id1, AutofillValue.forText("742 Evergreen Terrace"),
 *               createPresentation("742 Evergreen Terrace")) // street
 *           .setValue(id2, AutofillValue.forText("Springfield"),
 *               createPresentation("Springfield")) // city
 *           .build())
 *       .setSaveInfo(new SaveInfo.Builder(SaveInfo.SAVE_DATA_TYPE_ADDRESS,
 *           new AutofillId[] { id1, id2 }) // street and  city
 *           .setOptionalIds(new AutofillId[] { id3, id4 }) // state and zipcode
 *           .build())
 *       .build();
 * </pre>
 *
 * <a name="TriggeringSaveRequest"></a>
 * <h3>Triggering a save request</h3>
 *
 * <p>The {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)} can be triggered after
 * any of the following events:
 * <ul>
 *   <li>The {@link android.app.Activity Activity} finishes.
 *   <li>The app explicitly calls {@link android.view.autofill.AutofillManager#commit() AutofillManager#commit()}.
 *   <li>All required views become invisible (if the {@link android.service.autofill.SaveInfo SaveInfo} was created with the
 *       {@link #FLAG_SAVE_ON_ALL_VIEWS_INVISIBLE} flag).
 *   <li>The user clicks a specific view (defined by {@link android.service.autofill.SaveInfo.Builder#setTriggerId(android.view.autofill.AutofillId) Builder#setTriggerId(AutofillId)}.
 * </ul>
 *
 * <p>But it is only triggered when all conditions below are met:
 * <ul>
 *   <li>The {@link android.service.autofill.SaveInfo SaveInfo} associated with the {@link android.service.autofill.FillResponse FillResponse} is not {@code null} neither
 *       has the {@link #FLAG_DELAY_SAVE} flag.
 *   <li>The {@link android.view.autofill.AutofillValue AutofillValue}s of all required views (as set by the {@code requiredIds} passed
 *       to the {@link android.service.autofill.SaveInfo.Builder SaveInfo.Builder} constructor are not empty.
 *   <li>The {@link android.view.autofill.AutofillValue AutofillValue} of at least one view (be it required or optional) has changed
 *       (i.e., it's neither the same value passed in a {@link android.service.autofill.Dataset Dataset}, nor the initial value
 *       presented in the view).
 *   <li>There is no {@link android.service.autofill.Dataset Dataset} in the last {@link android.service.autofill.FillResponse FillResponse} that completely matches the
 *       screen state (i.e., all required and optional fields in the dataset have the same value as
 *       the fields in the screen).
 *   <li>The user explicitly tapped the autofill save UI asking to save data for autofill.
 * </ul>
 *
 * <a name="CustomizingSaveUI"></a>
 * <h3>Customizing the autofill save UI</h3>
 *
 * <p>The service can also customize some aspects of the autofill save UI:
 * <ul>
 *   <li>Add a simple subtitle by calling {@link android.service.autofill.SaveInfo.Builder#setDescription(java.lang.CharSequence) Builder#setDescription(CharSequence)}.
 *   <li>Add a customized subtitle by calling
 *       {@link android.service.autofill.SaveInfo.Builder#setCustomDescription(android.service.autofill.CustomDescription) Builder#setCustomDescription(CustomDescription)}.
 *   <li>Customize the button used to reject the save request by calling
 *       {@link android.service.autofill.SaveInfo.Builder#setNegativeAction(int,android.content.IntentSender) Builder#setNegativeAction(int, IntentSender)}.
 *   <li>Decide whether the UI should be shown based on the user input validation by calling
 *       {@link android.service.autofill.SaveInfo.Builder#setValidator(android.service.autofill.Validator) Builder#setValidator(Validator)}.
 * </ul>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SaveInfo implements android.os.Parcelable {

private SaveInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.SaveInfo> CREATOR;
static { CREATOR = null; }

/**
 * Postpone the autofill save UI.
 *
 * <p>If flag is set, the autofill save UI is not triggered when the
 * autofill context associated with the response associated with this {@link android.service.autofill.SaveInfo SaveInfo} is
 * committed (with {@link android.view.autofill.AutofillManager#commit() AutofillManager#commit()}). Instead, the {@link android.service.autofill.FillContext FillContext}
 * is delivered in future fill requests (with {@link android.service.autofill.AutofillService#onFillRequest(android.service.autofill.FillRequest,android.os.CancellationSignal,android.service.autofill.FillCallback) AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)})
 * and save request (with {@link android.service.autofill.AutofillService#onSaveRequest(android.service.autofill.SaveRequest,android.service.autofill.SaveCallback) AutofillService#onSaveRequest(SaveRequest, SaveCallback)})
 * of an activity belonging to the same task.
 *
 * <p>This flag should be used when the service detects that the application uses
 * multiple screens to implement an autofillable workflow (for example, one screen for the
 * username field, another for password).
 * @apiSince 29
 */

public static final int FLAG_DELAY_SAVE = 4; // 0x4

/**
 * By default, a save request is automatically <a href="#TriggeringSaveRequest">triggered</a>
 * once the {@link android.app.Activity Activity} finishes. If this flag is set, finishing the activity doesn't
 * trigger a save request.
 *
 * <p>This flag is typically used in conjunction with {@link android.service.autofill.SaveInfo.Builder#setTriggerId(android.view.autofill.AutofillId) Builder#setTriggerId(AutofillId)}.
 * @apiSince 28
 */

public static final int FLAG_DONT_SAVE_ON_FINISH = 2; // 0x2

/**
 * Usually, a save request is only automatically <a href="#TriggeringSaveRequest">triggered</a>
 * once the {@link android.app.Activity Activity} finishes. If this flag is set, it is triggered once all saved views
 * become invisible.
 * @apiSince 26
 */

public static final int FLAG_SAVE_ON_ALL_VIEWS_INVISIBLE = 1; // 0x1

/**
 * Style for the negative button of the save UI to cancel the
 * save operation. In this case, the user tapping the negative
 * button signals that they would prefer to not save the filled
 * content.
 * @apiSince 26
 */

public static final int NEGATIVE_BUTTON_STYLE_CANCEL = 0; // 0x0

/**
 * Style for the negative button of the save UI to reject the
 * save operation. This could be useful if the user needs to
 * opt-in your service and the save prompt is an advertisement
 * of the potential value you can add to the user. In this
 * case, the user tapping the negative button sends a strong
 * signal that the feature may not be useful and you may
 * consider some backoff strategy.
 * @apiSince 26
 */

public static final int NEGATIVE_BUTTON_STYLE_REJECT = 1; // 0x1

/**
 * Type used on when the {@link android.service.autofill.FillResponse FillResponse} represents a physical address (such as street,
 * city, state, etc).
 * @apiSince 26
 */

public static final int SAVE_DATA_TYPE_ADDRESS = 2; // 0x2

/**
 * Type used when the {@link android.service.autofill.FillResponse FillResponse} represents a credit card.
 * @apiSince 26
 */

public static final int SAVE_DATA_TYPE_CREDIT_CARD = 4; // 0x4

/**
 * Type used when the {@link android.service.autofill.FillResponse FillResponse} represents just an email address, without a password.
 * @apiSince 26
 */

public static final int SAVE_DATA_TYPE_EMAIL_ADDRESS = 16; // 0x10

/**
 * Type used when the service can save the contents of a screen, but cannot describe what
 * the content is for.
 * @apiSince 26
 */

public static final int SAVE_DATA_TYPE_GENERIC = 0; // 0x0

/**
 * Type used when the {@link android.service.autofill.FillResponse FillResponse} represents user credentials that have a password.
 * @apiSince 26
 */

public static final int SAVE_DATA_TYPE_PASSWORD = 1; // 0x1

/**
 * Type used when the {@link android.service.autofill.FillResponse FillResponse} represents just an username, without a password.
 * @apiSince 26
 */

public static final int SAVE_DATA_TYPE_USERNAME = 8; // 0x8
/**
 * A builder for {@link android.service.autofill.SaveInfo SaveInfo} objects.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new builder.
 *
 * @param type the type of information the associated {@link android.service.autofill.FillResponse FillResponse} represents. It
 * can be any combination of {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_GENERIC SaveInfo#SAVE_DATA_TYPE_GENERIC},
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_PASSWORD SaveInfo#SAVE_DATA_TYPE_PASSWORD},
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_ADDRESS SaveInfo#SAVE_DATA_TYPE_ADDRESS}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_CREDIT_CARD SaveInfo#SAVE_DATA_TYPE_CREDIT_CARD},
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_USERNAME SaveInfo#SAVE_DATA_TYPE_USERNAME}, or
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_EMAIL_ADDRESS SaveInfo#SAVE_DATA_TYPE_EMAIL_ADDRESS}.
 * Value is either <code>0</code> or a combination of {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_GENERIC}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_PASSWORD}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_ADDRESS}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_CREDIT_CARD}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_USERNAME}, and {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_EMAIL_ADDRESS}
 * @param requiredIds ids of all required views that will trigger a save request.
 *
 * <p>See {@link android.service.autofill.SaveInfo SaveInfo} for more info.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code requiredIds} is {@code null} or empty, or if
 * it contains any {@code null} entry.
 * @apiSince 26
 */

public Builder(int type, @androidx.annotation.NonNull android.view.autofill.AutofillId[] requiredIds) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new builder when no id is required.
 *
 * <p>When using this builder, caller must call {@link #setOptionalIds(android.view.autofill.AutofillId[])} before
 * calling {@link #build()}.
 *
 * @param type the type of information the associated {@link android.service.autofill.FillResponse FillResponse} represents. It
 * can be any combination of {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_GENERIC SaveInfo#SAVE_DATA_TYPE_GENERIC},
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_PASSWORD SaveInfo#SAVE_DATA_TYPE_PASSWORD},
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_ADDRESS SaveInfo#SAVE_DATA_TYPE_ADDRESS}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_CREDIT_CARD SaveInfo#SAVE_DATA_TYPE_CREDIT_CARD},
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_USERNAME SaveInfo#SAVE_DATA_TYPE_USERNAME}, or
 * {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_EMAIL_ADDRESS SaveInfo#SAVE_DATA_TYPE_EMAIL_ADDRESS}.
 *
 * <p>See {@link android.service.autofill.SaveInfo SaveInfo} for more info.
 
 * Value is either <code>0</code> or a combination of {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_GENERIC}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_PASSWORD}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_ADDRESS}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_CREDIT_CARD}, {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_USERNAME}, and {@link android.service.autofill.SaveInfo#SAVE_DATA_TYPE_EMAIL_ADDRESS}
 * @apiSince 27
 */

public Builder(int type) { throw new RuntimeException("Stub!"); }

/**
 * Sets flags changing the save behavior.
 *
 * @param flags {@link #FLAG_SAVE_ON_ALL_VIEWS_INVISIBLE},
 * {@link #FLAG_DONT_SAVE_ON_FINISH}, {@link #FLAG_DELAY_SAVE}, or {@code 0}.
 * Value is either <code>0</code> or a combination of {@link android.service.autofill.SaveInfo#FLAG_SAVE_ON_ALL_VIEWS_INVISIBLE}, {@link android.service.autofill.SaveInfo#FLAG_DONT_SAVE_ON_FINISH}, and {@link android.service.autofill.SaveInfo#FLAG_DELAY_SAVE}
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder setFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Sets the ids of additional, optional views the service would be interested to save.
 *
 * <p>See {@link android.service.autofill.SaveInfo SaveInfo} for more info.
 *
 * @param ids The ids of the optional views.
 * This value must never be {@code null}.
 * @return This builder.
 *
 * @throws java.lang.IllegalArgumentException if {@code ids} is {@code null} or empty, or if
 * it contains any {@code null} entry.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder setOptionalIds(@androidx.annotation.NonNull android.view.autofill.AutofillId[] ids) { throw new RuntimeException("Stub!"); }

/**
 * Sets an optional description to be shown in the UI when the user is asked to save.
 *
 * <p>Typically, it describes how the data will be stored by the service, so it can help
 * users to decide whether they can trust the service to save their data.
 *
 * @param description a succint description.
 * This value may be {@code null}.
 * @return This Builder.
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if this call was made after calling
 * {@link #setCustomDescription(android.service.autofill.CustomDescription)}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder setDescription(@androidx.annotation.Nullable java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Sets a custom description to be shown in the UI when the user is asked to save.
 *
 * <p>Typically used when the service must show more info about the object being saved,
 * like a credit card logo, masked number, and expiration date.
 *
 * @param customDescription the custom description.
 * This value must never be {@code null}.
 * @return This Builder.
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if this call was made after calling
 * {@link #setDescription(java.lang.CharSequence)}.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder setCustomDescription(@androidx.annotation.NonNull android.service.autofill.CustomDescription customDescription) { throw new RuntimeException("Stub!"); }

/**
 * Sets the style and listener for the negative save action.
 *
 * <p>This allows an autofill service to customize the style and be
 * notified when the user selects the negative action in the save
 * UI. Note that selecting the negative action regardless of its style
 * and listener being customized would dismiss the save UI and if a
 * custom listener intent is provided then this intent is
 * started. The default style is {@link #NEGATIVE_BUTTON_STYLE_CANCEL}</p>
 *
 * @param style The action style.
 * Value is {@link android.service.autofill.SaveInfo#NEGATIVE_BUTTON_STYLE_CANCEL}, or {@link android.service.autofill.SaveInfo#NEGATIVE_BUTTON_STYLE_REJECT}
 * @param listener The action listener.
 * This value may be {@code null}.
 * @return This builder.
 *
 * This value will never be {@code null}.
 * @see #NEGATIVE_BUTTON_STYLE_CANCEL
 * @see #NEGATIVE_BUTTON_STYLE_REJECT
 *
 * @throws java.lang.IllegalArgumentException If the style is invalid
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder setNegativeAction(int style, @androidx.annotation.Nullable android.content.IntentSender listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets an object used to validate the user input - if the input is not valid, the
 * autofill save UI is not shown.
 *
 * <p>Typically used to validate credit card numbers. Examples:
 *
 * <p>Validator for a credit number that must have exactly 16 digits:
 *
 * <pre class="prettyprint">
 * Validator validator = new RegexValidator(ccNumberId, Pattern.compile(""^\\d{16}$"))
 * </pre>
 *
 * <p>Validator for a credit number that must pass a Luhn checksum and either have
 * 16 digits, or 15 digits starting with 108:
 *
 * <pre class="prettyprint">
 * import static android.service.autofill.Validators.and;
 * import static android.service.autofill.Validators.or;
 *
 * Validator validator =
 *   and(
 *     new LuhnChecksumValidator(ccNumberId),
 *     or(
 *       new RegexValidator(ccNumberId, Pattern.compile("^\\d{16}$")),
 *       new RegexValidator(ccNumberId, Pattern.compile("^108\\d{12}$"))
 *     )
 *   );
 * </pre>
 *
 * <p><b>Note:</b> the example above is just for illustrative purposes; the same validator
 * could be created using a single regex for the {@code OR} part:
 *
 * <pre class="prettyprint">
 * Validator validator =
 *   and(
 *     new LuhnChecksumValidator(ccNumberId),
 *     new RegexValidator(ccNumberId, Pattern.compile(""^(\\d{16}|108\\d{12})$"))
 *   );
 * </pre>
 *
 * <p>Validator for a credit number contained in just 4 fields and that must have exactly
 * 4 digits on each field:
 *
 * <pre class="prettyprint">
 * import static android.service.autofill.Validators.and;
 *
 * Validator validator =
 *   and(
 *     new RegexValidator(ccNumberId1, Pattern.compile("^\\d{4}$")),
 *     new RegexValidator(ccNumberId2, Pattern.compile("^\\d{4}$")),
 *     new RegexValidator(ccNumberId3, Pattern.compile("^\\d{4}$")),
 *     new RegexValidator(ccNumberId4, Pattern.compile("^\\d{4}$"))
 *   );
 * </pre>
 *
 * @param validator an implementation provided by the Android System.
 * This value must never be {@code null}.
 * @return this builder.
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code validator} is not a class provided
 * by the Android System.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder setValidator(@androidx.annotation.NonNull android.service.autofill.Validator validator) { throw new RuntimeException("Stub!"); }

/**
 * Adds a sanitizer for one or more field.
 *
 * <p>When a sanitizer is set for a field, the {@link android.view.autofill.AutofillValue AutofillValue} is sent to the
 * sanitizer before a save request is <a href="#TriggeringSaveRequest">triggered</a>.
 *
 * <p>Typically used to avoid displaying the save UI for values that are autofilled but
 * reformattedby the app. For example, to remove spaces between every 4 digits of a
 * credit card number:
 *
 * <pre class="prettyprint">
 * builder.addSanitizer(new TextValueSanitizer(
 *     Pattern.compile("^(\\d{4})\\s?(\\d{4})\\s?(\\d{4})\\s?(\\d{4})$", "$1$2$3$4")),
 *     ccNumberId);
 * </pre>
 *
 * <p>The same sanitizer can be reused to sanitize multiple fields. For example, to trim
 * both the username and password fields:
 *
 * <pre class="prettyprint">
 * builder.addSanitizer(
 *     new TextValueSanitizer(Pattern.compile("^\\s*(.*)\\s*$"), "$1"),
 *         usernameId, passwordId);
 * </pre>
 *
 * <p>The sanitizer can also be used as an alternative for a
 * {@link #setValidator(android.service.autofill.Validator) validator}. If any of the {@code ids} is a
 * {@link #SaveInfo.Builder(int,android.view.autofill.AutofillId[]) required id} and the {@code sanitizer} fails
 * because of it, then the save UI is not shown.
 *
 * @param sanitizer an implementation provided by the Android System.
 * This value must never be {@code null}.
 * @param ids id of fields whose value will be sanitized.
 * This value must never be {@code null}.
 * @return this builder.
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if a sanitizer for any of the {@code ids} has already
 * been added or if {@code ids} is empty.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder addSanitizer(@androidx.annotation.NonNull android.service.autofill.Sanitizer sanitizer, @androidx.annotation.NonNull android.view.autofill.AutofillId... ids) { throw new RuntimeException("Stub!"); }

/**
 * Explicitly defines the view that should commit the autofill context when clicked.
 *
 * <p>Usually, the save request is only automatically
 * <a href="#TriggeringSaveRequest">triggered</a> after the activity is
 * finished or all relevant views become invisible, but there are scenarios where the
 * autofill context is automatically commited too late
 * &mdash;for example, when the activity manually clears the autofillable views when a
 * button is tapped. This method can be used to trigger the autofill save UI earlier in
 * these scenarios.
 *
 * <p><b>Note:</b> This method should only be used in scenarios where the automatic workflow
 * is not enough, otherwise it could trigger the autofill save UI when it should not&mdash;
 * for example, when the user entered invalid credentials for the autofillable views.
 
 * @param id This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.SaveInfo.Builder setTriggerId(@androidx.annotation.NonNull android.view.autofill.AutofillId id) { throw new RuntimeException("Stub!"); }

/**
 * Builds a new {@link android.service.autofill.SaveInfo SaveInfo} instance.
 *
 * @throws java.lang.IllegalStateException if no
 * {@link #SaveInfo.Builder(int,android.view.autofill.AutofillId[]) required ids},
 * or {@link #setOptionalIds(android.view.autofill.AutofillId[]) optional ids}, or {@link #FLAG_DELAY_SAVE}
 * were set
 * @apiSince 26
 */

public android.service.autofill.SaveInfo build() { throw new RuntimeException("Stub!"); }
}

}

