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


package android.view.textclassifier;


/**
 * A representation of the context in which text classification would be performed.
 * @see android.view.textclassifier.TextClassificationManager#createTextClassificationSession(TextClassificationContext)
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextClassificationContext implements android.os.Parcelable {

private TextClassificationContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns the package name for the calling package.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the widget type for this classification context.
 
 * @return This value will never be {@code null}.
 
 * Value is {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_EDITTEXT}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_UNSELECTABLE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_WEBVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_EDIT_WEBVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_EDITTEXT}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_UNSELECTABLE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_NOTIFICATION}, or {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_UNKNOWN}
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getWidgetType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a custom version string for the widget type.
 *
 * @see #getWidgetType()
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getWidgetVersion() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassificationContext> CREATOR;
static { CREATOR = null; }
/**
 * A builder for building a TextClassification context.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Initializes a new builder for text classification context objects.
 *
 * @param packageName the name of the calling package
 * This value must never be {@code null}.
 * @param widgetType the type of widget e.g. {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_TEXTVIEW TextClassifier#WIDGET_TYPE_TEXTVIEW}
 *
 * This value must never be {@code null}.
 * Value is {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_EDITTEXT}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_UNSELECTABLE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_WEBVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_EDIT_WEBVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_EDITTEXT}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_CUSTOM_UNSELECTABLE_TEXTVIEW}, {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_NOTIFICATION}, or {@link android.view.textclassifier.TextClassifier#WIDGET_TYPE_UNKNOWN}
 * @return this builder
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull java.lang.String widgetType) { throw new RuntimeException("Stub!"); }

/**
 * Sets an optional custom version string for the widget type.
 *
 * @param widgetVersion This value may be {@code null}.
 * @return this builder
 * @apiSince 28
 */

public android.view.textclassifier.TextClassificationContext.Builder setWidgetVersion(@androidx.annotation.Nullable java.lang.String widgetVersion) { throw new RuntimeException("Stub!"); }

/**
 * Builds the text classification context object.
 *
 * @return the built TextClassificationContext object
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassificationContext build() { throw new RuntimeException("Stub!"); }
}

}

