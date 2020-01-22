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


package android.view.textclassifier;

import android.app.RemoteAction;
import android.view.View.OnClickListener;

/**
 * Information for generating a widget to handle classified text.
 *
 * <p>A TextClassification object contains icons, labels, onClickListeners and intents that may
 * be used to build a widget that can be used to act on classified text. There is the concept of a
 * <i>primary action</i> and other <i>secondary actions</i>.
 *
 * <p>e.g. building a view that, when clicked, shares the classified text with the preferred app:
 *
 * <pre>{@code
 *   // Called preferably outside the UiThread.
 *   TextClassification classification = textClassifier.classifyText(allText, 10, 25);
 *
 *   // Called on the UiThread.
 *   Button button = new Button(context);
 *   button.setCompoundDrawablesWithIntrinsicBounds(classification.getIcon(), null, null, null);
 *   button.setText(classification.getLabel());
 *   button.setOnClickListener(v -> classification.getActions().get(0).getActionIntent().send());
 * }</pre>
 *
 * <p>e.g. starting an action mode with menu items that can handle the classified text:
 *
 * <pre>{@code
 *   // Called preferably outside the UiThread.
 *   final TextClassification classification = textClassifier.classifyText(allText, 10, 25);
 *
 *   // Called on the UiThread.
 *   view.startActionMode(new ActionMode.Callback() {
 *
 *       public boolean onCreateActionMode(ActionMode mode, Menu menu) {
 *           for (int i = 0; i < classification.getActions().size(); ++i) {
 *              RemoteAction action = classification.getActions().get(i);
 *              menu.add(Menu.NONE, i, 20, action.getTitle())
 *                 .setIcon(action.getIcon());
 *           }
 *           return true;
 *       }
 *
 *       public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
 *           classification.getActions().get(item.getItemId()).getActionIntent().send();
 *           return true;
 *       }
 *
 *       ...
 *   });
 * }</pre>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextClassification implements android.os.Parcelable {

private TextClassification() { throw new RuntimeException("Stub!"); }

/**
 * Gets the classified text.
 
 * @return This value may be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.lang.String getText() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of entities found in the classified text.
 
 * @return Value is 0 or greater
 * @apiSince 26
 */

public int getEntityCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the entity at the specified index. Entities are ordered from high confidence
 * to low confidence.
 *
 * @throws java.lang.IndexOutOfBoundsException if the specified index is out of range.
 * @see #getEntityCount() for the number of entities available.
 
 * @return This value will never be {@code null}.
 
 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}, or android.view.textclassifier.TextClassifier.TYPE_DICTIONARY
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String getEntity(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the confidence score for the specified entity. The value ranges from
 * 0 (low confidence) to 1 (high confidence). 0 indicates that the entity was not found for the
 * classified text.
 
 * @param entity Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}, or android.view.textclassifier.TextClassifier.TYPE_DICTIONARY
 * @return Value is between 0.0 and 1.0 inclusive
 * @apiSince 26
 */

public float getConfidenceScore(java.lang.String entity) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of actions that may be performed on the text. The list is ordered based on
 * the likelihood that a user will use the action, with the most likely action appearing first.
 * @apiSince 28
 */

public java.util.List<android.app.RemoteAction> getActions() { throw new RuntimeException("Stub!"); }

/**
 * Returns an icon that may be rendered on a widget used to act on the classified text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelable and only represents the icon of the
 * first {@link android.app.RemoteAction RemoteAction} (if one exists) when this object is read from a parcel.
 *
 * @deprecated Use {@link #getActions()} instead.
 
 * @return This value may be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public android.graphics.drawable.Drawable getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Returns a label that may be rendered on a widget used to act on the classified text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelable and only represents the label of the
 * first {@link android.app.RemoteAction RemoteAction} (if one exists) when this object is read from a parcel.
 *
 * @deprecated Use {@link #getActions()} instead.
 
 * @return This value may be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Returns an intent that may be fired to act on the classified text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelled and will always return null when this
 * object is read from a parcel.
 *
 * @deprecated Use {@link #getActions()} instead.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public android.content.Intent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the OnClickListener that may be triggered to act on the classified text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelable and only represents the first
 * {@link android.app.RemoteAction RemoteAction} (if one exists) when this object is read from a parcel.
 *
 * @deprecated Use {@link #getActions()} instead.
 
 * @return This value may be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.Nullable
public android.view.View.OnClickListener getOnClickListener() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id, if one exists, for this object.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extended data.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassification> CREATOR;
static { CREATOR = null; }
/**
 * Builder for building {@link android.view.textclassifier.TextClassification TextClassification} objects.
 *
 * <p>e.g.
 *
 * <pre>{@code
 *   TextClassification classification = new TextClassification.Builder()
 *          .setText(classifiedText)
 *          .setEntityType(TextClassifier.TYPE_EMAIL, 0.9)
 *          .setEntityType(TextClassifier.TYPE_OTHER, 0.1)
 *          .addAction(remoteAction1)
 *          .addAction(remoteAction2)
 *          .build();
 * }</pre>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the classified text.
 
 * @param text This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setText(@androidx.annotation.Nullable java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Sets an entity type for the classification result and assigns a confidence score.
 * If a confidence score had already been set for the specified entity type, this will
 * override that score.
 *
 * @param confidenceScore a value from 0 (low confidence) to 1 (high confidence).
 *      0 implies the entity does not exist for the classified text.
 *      Values greater than 1 are clamped to 1.
 
 * Value is between 0.0 and 1.0 inclusive
 * @param type This value must never be {@code null}.
 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}, or android.view.textclassifier.TextClassifier.TYPE_DICTIONARY
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setEntityType(@androidx.annotation.NonNull java.lang.String type, float confidenceScore) { throw new RuntimeException("Stub!"); }

/**
 * Adds an action that may be performed on the classified text. Actions should be added in
 * order of likelihood that the user will use them, with the most likely action being added
 * first.
 
 * @param action This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder addAction(@androidx.annotation.NonNull android.app.RemoteAction action) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon for the <i>primary</i> action that may be rendered on a widget used to act
 * on the classified text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelled. If read from a parcel, the
 * returned icon represents the icon of the first {@link android.app.RemoteAction RemoteAction} (if one exists).
 *
 * @deprecated Use {@link #addAction(android.app.RemoteAction)} instead.
 
 * @param icon This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the label for the <i>primary</i> action that may be rendered on a widget used to
 * act on the classified text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelled. If read from a parcel, the
 * returned label represents the label of the first {@link android.app.RemoteAction RemoteAction} (if one exists).
 *
 * @deprecated Use {@link #addAction(android.app.RemoteAction)} instead.
 
 * @param label This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setLabel(@androidx.annotation.Nullable java.lang.String label) { throw new RuntimeException("Stub!"); }

/**
 * Sets the intent for the <i>primary</i> action that may be fired to act on the classified
 * text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelled.
 *
 * @deprecated Use {@link #addAction(android.app.RemoteAction)} instead.
 
 * @param intent This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setIntent(@androidx.annotation.Nullable android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the OnClickListener for the <i>primary</i> action that may be triggered to act on
 * the classified text.
 *
 * <p><strong>NOTE: </strong>This field is not parcelable. If read from a parcel, the
 * returned OnClickListener represents the first {@link android.app.RemoteAction RemoteAction} (if one exists).
 *
 * @deprecated Use {@link #addAction(android.app.RemoteAction)} instead.
 
 * @param onClickListener This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setOnClickListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets an id for the TextClassification object.
 
 * @param id This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setId(@androidx.annotation.Nullable java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extended data.
 
 * @param extras This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns a {@link android.view.textclassifier.TextClassification TextClassification} object.
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification build() { throw new RuntimeException("Stub!"); }
}

/**
 * A request object for generating TextClassification.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Request implements android.os.Parcelable {

private Request() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text providing context for the text to classify (which is specified
 *      by the sub sequence starting at startIndex and ending at endIndex)
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Returns start index of the text to classify.
 
 * @return Value is 0 or greater
 * @apiSince 28
 */

public int getStartIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns end index of the text to classify.
 
 * @return Value is 0 or greater
 * @apiSince 28
 */

public int getEndIndex() { throw new RuntimeException("Stub!"); }

/**
 * @return ordered list of locale preferences that can be used to disambiguate
 *      the provided text.
 
 * This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.os.LocaleList getDefaultLocales() { throw new RuntimeException("Stub!"); }

/**
 * @return reference time based on which relative dates (e.g.&nbsp;"tomorrow") should be
 *      interpreted.
 
 * This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.time.ZonedDateTime getReferenceTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the package that sent this request.
 * This returns {@code null} if no calling package name is set.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getCallingPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extended data.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassification.Request> CREATOR;
static { CREATOR = null; }
/**
 * A builder for building TextClassification requests.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * @param text text providing context for the text to classify (which is specified
 *      by the sub sequence starting at startIndex and ending at endIndex)
 * This value must never be {@code null}.
 * @param startIndex start index of the text to classify
 * Value is 0 or greater
 * @param endIndex end index of the text to classify
 
 * Value is 0 or greater
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull java.lang.CharSequence text, int startIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * @param defaultLocales ordered list of locale preferences that may be used to
 *      disambiguate the provided text. If no locale preferences exist, set this to null
 *      or an empty locale list.
 *
 * This value may be {@code null}.
 * @return this builder
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Request.Builder setDefaultLocales(@androidx.annotation.Nullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * @param referenceTime reference time based on which relative dates (e.g.&nbsp;"tomorrow"
 *      should be interpreted. This should usually be the time when the text was
 *      originally composed. If no reference time is set, now is used.
 *
 * This value may be {@code null}.
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Request.Builder setReferenceTime(@androidx.annotation.Nullable java.time.ZonedDateTime referenceTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extended data.
 *
 * @param extras This value may be {@code null}.
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Request.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns the request object.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassification.Request build() { throw new RuntimeException("Stub!"); }
}

}

}

