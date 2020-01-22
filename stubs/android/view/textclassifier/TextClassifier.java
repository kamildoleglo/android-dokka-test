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

import java.util.Collection;

/**
 * Interface for providing text classification related features.
 * <p>
 * The TextClassifier may be used to understand the meaning of text, as well as generating predicted
 * next actions based on the text.
 *
 * <p><strong>NOTE: </strong>Unless otherwise stated, methods of this interface are blocking
 * operations. Call on a worker thread.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TextClassifier {

/**
 * Returns suggested text selection start and end indices, recognized entity types, and their
 * associated confidence scores. The entity types are ordered from highest to lowest scoring.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param request the text selection request
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public default android.view.textclassifier.TextSelection suggestSelection(@androidx.annotation.NonNull android.view.textclassifier.TextSelection.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Returns suggested text selection start and end indices, recognized entity types, and their
 * associated confidence scores. The entity types are ordered from highest to lowest scoring.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <p><b>NOTE:</b> Do not implement. The default implementation of this method calls
 * {@link #suggestSelection(android.view.textclassifier.TextSelection.Request)}. If that method calls this method,
 * a stack overflow error will happen.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param text text providing context for the selected text (which is specified
 *      by the sub sequence starting at selectionStartIndex and ending at selectionEndIndex)
 * This value must never be {@code null}.
 * @param selectionStartIndex start index of the selected part of text
 * Value is 0 or greater
 * @param selectionEndIndex end index of the selected part of text
 * Value is 0 or greater
 * @param defaultLocales ordered list of locale preferences that may be used to
 *      disambiguate the provided text. If no locale preferences exist, set this to null
 *      or an empty locale list.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if text is null; selectionStartIndex is negative;
 *      selectionEndIndex is greater than text.length() or not greater than selectionStartIndex
 *
 * @see #suggestSelection(TextSelection.Request)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public default android.view.textclassifier.TextSelection suggestSelection(@androidx.annotation.NonNull java.lang.CharSequence text, int selectionStartIndex, int selectionEndIndex, @androidx.annotation.Nullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * Classifies the specified text and returns a {@link android.view.textclassifier.TextClassification TextClassification} object that can be
 * used to generate a widget for handling the classified text.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param request the text classification request
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public default android.view.textclassifier.TextClassification classifyText(@androidx.annotation.NonNull android.view.textclassifier.TextClassification.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Classifies the specified text and returns a {@link android.view.textclassifier.TextClassification TextClassification} object that can be
 * used to generate a widget for handling the classified text.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><b>NOTE:</b> Do not implement. The default implementation of this method calls
 * {@link #classifyText(android.view.textclassifier.TextClassification.Request)}. If that method calls this method,
 * a stack overflow error will happen.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param text text providing context for the text to classify (which is specified
 *      by the sub sequence starting at startIndex and ending at endIndex)
 * This value must never be {@code null}.
 * @param startIndex start index of the text to classify
 * Value is 0 or greater
 * @param endIndex end index of the text to classify
 * Value is 0 or greater
 * @param defaultLocales ordered list of locale preferences that may be used to
 *      disambiguate the provided text. If no locale preferences exist, set this to null
 *      or an empty locale list.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if text is null; startIndex is negative;
 *      endIndex is greater than text.length() or not greater than startIndex
 *
 * @see #classifyText(TextClassification.Request)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public default android.view.textclassifier.TextClassification classifyText(@androidx.annotation.NonNull java.lang.CharSequence text, int startIndex, int endIndex, @androidx.annotation.Nullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * Generates and returns a {@link android.view.textclassifier.TextLinks TextLinks} that may be applied to the text to annotate it with
 * links information.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param request the text links request
 *
 * This value must never be {@code null}.
 * @see #getMaxGenerateLinksTextLength()
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public default android.view.textclassifier.TextLinks generateLinks(@androidx.annotation.NonNull android.view.textclassifier.TextLinks.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximal length of text that can be processed by generateLinks.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @see #generateLinks(TextLinks.Request)
 * @apiSince 28
 */

public default int getMaxGenerateLinksTextLength() { throw new RuntimeException("Stub!"); }

/**
 * Detects the language of the text in the given request.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param request the {@link android.view.textclassifier.TextLanguage TextLanguage} request.
 * This value must never be {@code null}.
 * @return the {@link android.view.textclassifier.TextLanguage TextLanguage} result.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public default android.view.textclassifier.TextLanguage detectLanguage(@androidx.annotation.NonNull android.view.textclassifier.TextLanguage.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Suggests and returns a list of actions according to the given conversation.
 
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 
 * @param request This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public default android.view.textclassifier.ConversationActions suggestConversationActions(@androidx.annotation.NonNull android.view.textclassifier.ConversationActions.Request request) { throw new RuntimeException("Stub!"); }

/**
 * <strong>NOTE: </strong>Use {@link #onTextClassifierEvent(android.view.textclassifier.TextClassifierEvent)} instead.
 * <p>
 * Reports a selection event.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 
 * @param event This value must never be {@code null}.
 * @apiSince 28
 */

public default void onSelectionEvent(@androidx.annotation.NonNull android.view.textclassifier.SelectionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Reports a text classifier event.
 * <p>
 * <strong>NOTE: </strong>Call on a worker thread.
 *
 * @throws java.lang.IllegalStateException if this TextClassifier has been destroyed.
 * @see #isDestroyed()
 
 * @param event This value must never be {@code null}.
 * @apiSince 29
 */

public default void onTextClassifierEvent(@androidx.annotation.NonNull android.view.textclassifier.TextClassifierEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Destroys this TextClassifier.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to its methods should
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <p>Subsequent calls to this method are no-ops.
 * @apiSince 28
 */

public default void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this TextClassifier has been destroyed.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, caller should not interact
 * with the classifier and an attempt to do so would throw an {@link java.lang.IllegalStateException IllegalStateException}.
 * However, this method should never throw an {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * @see #destroy()
 * @apiSince 28
 */

public default boolean isDestroyed() { throw new RuntimeException("Stub!"); }

/**
 * Extra that is included on activity intents coming from a TextClassifier when
 * it suggests actions to its caller.
 * <p>
 * All {@link android.view.textclassifier.TextClassifier TextClassifier} implementations should make sure this extra exists in their
 * generated intents.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_FROM_TEXT_CLASSIFIER = "android.view.textclassifier.extra.FROM_TEXT_CLASSIFIER";

/**
 * Designates that the text in question is editable. *
 * @apiSince 28
 */

public static final java.lang.String HINT_TEXT_IS_EDITABLE = "android.text_is_editable";

/**
 * Designates that the text in question is not editable. *
 * @apiSince 28
 */

public static final java.lang.String HINT_TEXT_IS_NOT_EDITABLE = "android.text_is_not_editable";

/**
 * No-op TextClassifier.
 * This may be used to turn off TextClassifier features.
 * @apiSince 26
 */

public static final android.view.textclassifier.TextClassifier NO_OP = null;

/**
 * Physical address.
 * @apiSince 26
 */

public static final java.lang.String TYPE_ADDRESS = "address";

/** Time reference that is no more specific than a date. May be absolute such as "01/01/2000" or
 * relative like "tomorrow". *     * @apiSince 28
 */

public static final java.lang.String TYPE_DATE = "date";

/** Time reference that includes a specific time. May be absolute such as "01/01/2000 5:30pm" or
 * relative like "tomorrow at 5:30pm". *     * @apiSince 28
 */

public static final java.lang.String TYPE_DATE_TIME = "datetime";

/**
 * E-mail address (e.g.&nbsp;"noreply@android.com").
 * @apiSince 26
 */

public static final java.lang.String TYPE_EMAIL = "email";

/**
 * Flight number in IATA format.
 * @apiSince 28
 */

public static final java.lang.String TYPE_FLIGHT_NUMBER = "flight";

/**
 * The classifier ran, but didn't recognize a known entity.
 * @apiSince 26
 */

public static final java.lang.String TYPE_OTHER = "other";

/**
 * Phone number (e.g.&nbsp;"555-123 456").
 * @apiSince 26
 */

public static final java.lang.String TYPE_PHONE = "phone";

/**
 * The TextClassifier failed to run.
 * @apiSince 28
 */

public static final java.lang.String TYPE_UNKNOWN = "";

/**
 * Web URL.
 * @apiSince 26
 */

public static final java.lang.String TYPE_URL = "url";

/**
 * The widget involved in the text classification context is a custom editable text widget.
 * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_CUSTOM_EDITTEXT = "customedit";

/**
 * The widget involved in the text classification context is a custom text widget.
 * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_CUSTOM_TEXTVIEW = "customview";

/** The widget involved in the text classification context is a custom non-selectable text
 * widget.     * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_CUSTOM_UNSELECTABLE_TEXTVIEW = "nosel-customview";

/** The widget involved in the text classification context is a standard
 * {@link android.widget.EditText}.     * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_EDITTEXT = "edittext";

/** The widget involved in the text classification context is a standard editable
 * {@link android.webkit.WebView}.     * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_EDIT_WEBVIEW = "edit-webview";

/**
 * The widget involved in the text classification context is a notification
 * @apiSince 29
 */

public static final java.lang.String WIDGET_TYPE_NOTIFICATION = "notification";

/** The widget involved in the text classification context is a standard
 * {@link android.widget.TextView}.     * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_TEXTVIEW = "textview";

/**
 * The widget involved in the text classification context is of an unknown/unspecified type.
 * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_UNKNOWN = "unknown";

/** The widget involved in the text classification context is a standard non-selectable
 * {@link android.widget.TextView}.     * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_UNSELECTABLE_TEXTVIEW = "nosel-textview";

/** The widget involved in the text classification context is a standard
 * {@link android.webkit.WebView}.     * @apiSince 28
 */

public static final java.lang.String WIDGET_TYPE_WEBVIEW = "webview";
/**
 * Configuration object for specifying what entity types to identify.
 *
 * Configs are initially based on a predefined preset, and can be modified from there.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EntityConfig implements android.os.Parcelable {

private EntityConfig() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Creates an EntityConfig.
 *
 * @param hints Hints for the TextClassifier to determine what types of entities to find.
 *
 * This value may be {@code null}.
 * @deprecated Use {@link android.view.textclassifier.TextClassifier.EntityConfig.Builder Builder} instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public static android.view.textclassifier.TextClassifier.EntityConfig createWithHints(@androidx.annotation.Nullable java.util.Collection<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Creates an EntityConfig.
 *
 * @param hints Hints for the TextClassifier to determine what types of entities to find
 * This value may be {@code null}.
 * @param includedEntityTypes Entity types, e.g. {@link #TYPE_EMAIL}, to explicitly include
 * This value may be {@code null}.
 * @param excludedEntityTypes Entity types, e.g. {@link #TYPE_PHONE}, to explicitly exclude
 *
 *
 * Note that if an entity has been excluded, the exclusion will take precedence.
 *
 * This value may be {@code null}.
 * @deprecated Use {@link android.view.textclassifier.TextClassifier.EntityConfig.Builder Builder} instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public static android.view.textclassifier.TextClassifier.EntityConfig create(@androidx.annotation.Nullable java.util.Collection<java.lang.String> hints, @androidx.annotation.Nullable java.util.Collection<java.lang.String> includedEntityTypes, @androidx.annotation.Nullable java.util.Collection<java.lang.String> excludedEntityTypes) { throw new RuntimeException("Stub!"); }

/**
 * Creates an EntityConfig with an explicit entity list.
 *
 * @param entityTypes Complete set of entities, e.g. {@link #TYPE_URL} to find.
 *
 * This value may be {@code null}.
 * @deprecated Use {@link android.view.textclassifier.TextClassifier.EntityConfig.Builder Builder} instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public static android.view.textclassifier.TextClassifier.EntityConfig createWithExplicitEntityList(@androidx.annotation.Nullable java.util.Collection<java.lang.String> entityTypes) { throw new RuntimeException("Stub!"); }

/**
 * Returns a final list of entity types to find.
 *
 * @param entityTypes Entity types we think should be found before factoring in
 *                    includes/excludes
 *
 * This method is intended for use by TextClassifier implementations.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public java.util.Collection<java.lang.String> resolveEntityListModifications(@androidx.annotation.NonNull java.util.Collection<java.lang.String> entityTypes) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the list of hints.
 *
 * @return An unmodifiable collection of the hints.
 * @apiSince 28
 */

public java.util.Collection<java.lang.String> getHints() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the client allows the text classifier to include its own list of
 * default types. If this function returns {@code true}, a default list of types suggested
 * from a text classifier will be taking into account.
 *
 * <p>NOTE: This method is intended for use by a text classifier.
 *
 * @see #resolveEntityListModifications(Collection)
 * @apiSince 29
 */

public boolean shouldIncludeTypesFromTextClassifier() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassifier.EntityConfig> CREATOR;
static { CREATOR = null; }
/**
 * Builder class to construct the {@link android.view.textclassifier.TextClassifier.EntityConfig EntityConfig} object.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets a collection of types that are explicitly included.
 
 * @param includedTypes This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier.EntityConfig.Builder setIncludedTypes(@androidx.annotation.Nullable java.util.Collection<java.lang.String> includedTypes) { throw new RuntimeException("Stub!"); }

/**
 * Sets a collection of types that are explicitly excluded.
 
 * @param excludedTypes This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier.EntityConfig.Builder setExcludedTypes(@androidx.annotation.Nullable java.util.Collection<java.lang.String> excludedTypes) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether or not to include the types suggested by the text classifier. By
 * default, it is included.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier.EntityConfig.Builder includeTypesFromTextClassifier(boolean includeTypesFromTextClassifier) { throw new RuntimeException("Stub!"); }

/**
 * Sets the hints for the TextClassifier to determine what types of entities to find.
 * These hints will only be used if {@link #includeTypesFromTextClassifier} is
 * set to be true.
 
 * @param hints This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier.EntityConfig.Builder setHints(@androidx.annotation.Nullable java.util.Collection<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Combines all of the options that have been set and returns a new {@link android.view.textclassifier.TextClassifier.EntityConfig EntityConfig}
 * object.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier.EntityConfig build() { throw new RuntimeException("Stub!"); }
}

}

}

