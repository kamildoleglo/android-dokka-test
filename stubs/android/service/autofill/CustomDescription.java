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

import android.widget.RemoteViews;
import android.app.Activity;
import android.app.PendingIntent;

/**
 * Defines a custom description for the autofill save UI.
 *
 * <p>This is useful when the autofill service needs to show a detailed view of what would be saved;
 * for example, when the screen contains a credit card, it could display a logo of the credit card
 * bank, the last four digits of the credit card number, and its expiration number.
 *
 * <p>A custom description is made of 2 parts:
 * <ul>
 *   <li>A {@link android.widget.RemoteViews RemoteViews} containing children views.
 *   <li>{@link android.service.autofill.Transformation Transformation} to populate the children views.
 * </ul>
 *
 * <p>For the credit card example mentioned above, the (simplified) template would be:
 *
 * <pre class="prettyprint">
 * &lt;LinearLayout&gt;
 *   &lt;ImageView android:id="@+id/templateccLogo"/&gt;
 *   &lt;TextView android:id="@+id/templateCcNumber"/&gt;
 *   &lt;TextView android:id="@+id/templateExpDate"/&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 *
 * <p>Which in code translates to:
 *
 * <pre class="prettyprint">
 *   CustomDescription.Builder buider = new Builder(new RemoteViews(pgkName, R.layout.cc_template);
 * </pre>
 *
 * <p>Then the value of each of the 3 children would be changed at runtime based on the the value of
 * the screen fields and the {@link android.service.autofill.Transformation Transformation}:
 *
 * <pre class="prettyprint">
 * // Image child - different logo for each bank, based on credit card prefix
 * builder.addChild(R.id.templateccLogo,
 *   new ImageTransformation.Builder(ccNumberId)
 *     .addOption(Pattern.compile("^4815.*$"), R.drawable.ic_credit_card_logo1)
 *     .addOption(Pattern.compile("^1623.*$"), R.drawable.ic_credit_card_logo2)
 *     .addOption(Pattern.compile("^42.*$"), R.drawable.ic_credit_card_logo3)
 *     .build();
 * // Masked credit card number (as .....LAST_4_DIGITS)
 * builder.addChild(R.id.templateCcNumber, new CharSequenceTransformation
 *     .Builder(ccNumberId, Pattern.compile("^.*(\\d\\d\\d\\d)$"), "...$1")
 *     .build();
 * // Expiration date as MM / YYYY:
 * builder.addChild(R.id.templateExpDate, new CharSequenceTransformation
 *     .Builder(ccExpMonthId, Pattern.compile("^(\\d\\d)$"), "Exp: $1")
 *     .addField(ccExpYearId, Pattern.compile("^(\\d\\d)$"), "/$1")
 *     .build();
 * </pre>
 *
 * <p>See {@link android.service.autofill.ImageTransformation ImageTransformation}, {@link android.service.autofill.CharSequenceTransformation CharSequenceTransformation} for more info about these
 * transformations.
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CustomDescription implements android.os.Parcelable {

private CustomDescription() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.autofill.CustomDescription> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link android.service.autofill.CustomDescription CustomDescription} objects.
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Default constructor.
 *
 * <p><b>Note:</b> If any child view of presentation triggers a
 * {@link android.widget.RemoteViews#setOnClickPendingIntent(int,android.app.PendingIntent) RemoteViews#setOnClickPendingIntent(int, android.app.PendingIntent)}, such {@link android.app.PendingIntent PendingIntent} must follow the restrictions below, otherwise
 * it might not be triggered or the autofill save UI might not be shown when its activity
 * is finished:
 * <ul>
 *   <li>It cannot be created with the {@link android.app.PendingIntent#FLAG_IMMUTABLE PendingIntent#FLAG_IMMUTABLE} flag.
 *   <li>It must be a PendingIntent for an {@link android.app.Activity Activity}.
 *   <li>The activity must call {@link android.app.Activity#finish() Activity#finish()} when done.
 *   <li>The activity should not launch other activities.
 * </ul>
 *
 * @param parentPresentation template presentation with (optional) children views.
 * This value must never be {@code null}.
 * @throws java.lang.NullPointerException if {@code parentPresentation} is null (on Android
 * {@link android.os.Build.VERSION_CODES#P} or higher).
 * @apiSince 27
 */

public Builder(@androidx.annotation.NonNull android.widget.RemoteViews parentPresentation) { throw new RuntimeException("Stub!"); }

/**
 * Adds a transformation to replace the value of a child view with the fields in the
 * screen.
 *
 * <p>When multiple transformations are added for the same child view, they will be applied
 * in the same order as added.
 *
 * @param id view id of the children view.
 * @param transformation an implementation provided by the Android System.
 *
 * This value must never be {@code null}.
 * @return this builder.
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code transformation} is not a class provided
 * by the Android System.
 * @throws java.lang.IllegalStateException if {@link #build()} was already called.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public android.service.autofill.CustomDescription.Builder addChild(int id, @androidx.annotation.NonNull android.service.autofill.Transformation transformation) { throw new RuntimeException("Stub!"); }

/**
 * Updates the {@link android.widget.RemoteViews RemoteViews} when a condition is satisfied by
 * applying a series of remote view operations. This allows dynamic customization of the
 * portion of the save UI that is controlled by the autofill service. Such dynamic
 * customization is based on the content of target views.
 *
 * <p>The updates are applied in the sequence they are added, after the
 * {@link #addChild(int,android.service.autofill.Transformation) transformations} are applied to the children
 * views.
 *
 * <p>For example, to make children views visible when fields are not empty:
 *
 * <pre class="prettyprint">
 * RemoteViews template = new RemoteViews(pgkName, R.layout.my_full_template);
 *
 * Pattern notEmptyPattern = Pattern.compile(".+");
 * Validator hasAddress = new RegexValidator(addressAutofillId, notEmptyPattern);
 * Validator hasCcNumber = new RegexValidator(ccNumberAutofillId, notEmptyPattern);
 *
 * RemoteViews addressUpdates = new RemoteViews(pgkName, R.layout.my_full_template)
 * addressUpdates.setViewVisibility(R.id.address, View.VISIBLE);
 *
 * // Make address visible
 * BatchUpdates addressBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(addressUpdates)
 *     .build();
 *
 * RemoteViews ccUpdates = new RemoteViews(pgkName, R.layout.my_full_template)
 * ccUpdates.setViewVisibility(R.id.cc_number, View.VISIBLE);
 *
 * // Mask credit card number (as .....LAST_4_DIGITS) and make it visible
 * BatchUpdates ccBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(ccUpdates)
 *     .transformChild(R.id.templateCcNumber, new CharSequenceTransformation
 *                     .Builder(ccNumberId, Pattern.compile("^.*(\\d\\d\\d\\d)$"), "...$1")
 *                     .build())
 *     .build();
 *
 * CustomDescription customDescription = new CustomDescription.Builder(template)
 *     .batchUpdate(hasAddress, addressBatchUpdates)
 *     .batchUpdate(hasCcNumber, ccBatchUpdates)
 *     .build();
 * </pre>
 *
 * <p>Another approach is to add a child first, then apply the transformations. Example:
 *
 * <pre class="prettyprint">
 * RemoteViews template = new RemoteViews(pgkName, R.layout.my_base_template);
 *
 * RemoteViews addressPresentation = new RemoteViews(pgkName, R.layout.address)
 * RemoteViews addressUpdates = new RemoteViews(pgkName, R.layout.my_template)
 * addressUpdates.addView(R.id.parentId, addressPresentation);
 * BatchUpdates addressBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(addressUpdates)
 *     .build();
 *
 * RemoteViews ccPresentation = new RemoteViews(pgkName, R.layout.cc)
 * RemoteViews ccUpdates = new RemoteViews(pgkName, R.layout.my_template)
 * ccUpdates.addView(R.id.parentId, ccPresentation);
 * BatchUpdates ccBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(ccUpdates)
 *     .transformChild(R.id.templateCcNumber, new CharSequenceTransformation
 *                     .Builder(ccNumberId, Pattern.compile("^.*(\\d\\d\\d\\d)$"), "...$1")
 *                     .build())
 *     .build();
 *
 * CustomDescription customDescription = new CustomDescription.Builder(template)
 *     .batchUpdate(hasAddress, addressBatchUpdates)
 *     .batchUpdate(hasCcNumber, ccBatchUpdates)
 *     .build();
 * </pre>
 *
 * @param condition condition used to trigger the updates.
 * This value must never be {@code null}.
 * @param updates actions to be applied to the
 * {@link #CustomDescription.Builder(android.widget.RemoteViews) template presentation} when the condition
 * is satisfied.
 *
 * This value must never be {@code null}.
 * @return this builder
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code condition} is not a class provided
 * by the Android System.
 * @throws java.lang.IllegalStateException if {@link #build()} was already called.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.service.autofill.CustomDescription.Builder batchUpdate(@androidx.annotation.NonNull android.service.autofill.Validator condition, @androidx.annotation.NonNull android.service.autofill.BatchUpdates updates) { throw new RuntimeException("Stub!"); }

/**
 * Sets an action to be applied to the {@link android.widget.RemoteViews RemoteViews} when the
 * child view with the given {@code id} is clicked.
 *
 * <p>Typically used when the presentation uses a masked field (like {@code ****}) for
 * sensitive fields like passwords or credit cards numbers, but offers a an icon that the
 * user can tap to show the value for that field.
 *
 * <p>Example:
 *
 * <pre class="prettyprint">
 * customDescriptionBuilder
 *   .addChild(R.id.password_plain, new CharSequenceTransformation
 *      .Builder(passwordId, Pattern.compile("^(.*)$"), "$1").build())
 *   .addOnClickAction(R.id.showIcon, new VisibilitySetterAction
 *     .Builder(R.id.hideIcon, View.VISIBLE)
 *     .setVisibility(R.id.showIcon, View.GONE)
 *     .setVisibility(R.id.password_plain, View.VISIBLE)
 *     .setVisibility(R.id.password_masked, View.GONE)
 *     .build())
 *   .addOnClickAction(R.id.hideIcon, new VisibilitySetterAction
 *     .Builder(R.id.showIcon, View.VISIBLE)
 *     .setVisibility(R.id.hideIcon, View.GONE)
 *     .setVisibility(R.id.password_masked, View.VISIBLE)
 *     .setVisibility(R.id.password_plain, View.GONE)
 *     .build());
 * </pre>
 *
 * <p><b>Note:</b> Currently only one action can be applied to a child; if this method
 * is called multiple times passing the same {@code id}, only the last call will be used.
 *
 * @param id resource id of the child view.
 * @param action action to be performed. Must be an an implementation provided by the
 * Android System.
 *
 * This value must never be {@code null}.
 * @return this builder
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code action} is not a class provided
 * by the Android System.
 * @throws java.lang.IllegalStateException if {@link #build()} was already called.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.service.autofill.CustomDescription.Builder addOnClickAction(int id, @androidx.annotation.NonNull android.service.autofill.OnClickAction action) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link android.service.autofill.CustomDescription CustomDescription} instance.
 
 * @return This value will never be {@code null}.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public android.service.autofill.CustomDescription build() { throw new RuntimeException("Stub!"); }
}

}

