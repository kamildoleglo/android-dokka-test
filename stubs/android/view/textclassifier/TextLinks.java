/*
 * Copyright 2017 The Android Open Source Project
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
import android.text.method.MovementMethod;
import android.widget.TextView;
import android.text.style.ClickableSpan;
import android.view.textclassifier.TextClassifier.EntityConfig;
import java.util.Map;

/**
 * A collection of links, representing subsequences of text and the entity types (phone number,
 * address, url, etc) they may be.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextLinks implements android.os.Parcelable {

private TextLinks() { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable Collection of the links.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Collection<android.view.textclassifier.TextLinks.TextLink> getLinks() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extended data.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Annotates the given text with the generated links. It will fail if the provided text doesn't
 * match the original text used to create the TextLinks.
 *
 * <p><strong>NOTE: </strong>It may be necessary to set a LinkMovementMethod on the TextView
 * widget to properly handle links. See {@link android.widget.TextView#setMovementMethod(android.text.method.MovementMethod) TextView#setMovementMethod(MovementMethod)}
 *
 * @param text the text to apply the links to. Must match the original text
 * This value must never be {@code null}.
 * @param applyStrategy the apply strategy used to determine how to apply links to text.
 *      e.g {@link android.view.textclassifier.TextLinks#APPLY_STRATEGY_IGNORE TextLinks#APPLY_STRATEGY_IGNORE}
 * Value is {@link android.view.textclassifier.TextLinks#APPLY_STRATEGY_IGNORE}, or {@link android.view.textclassifier.TextLinks#APPLY_STRATEGY_REPLACE}
 * @param spanFactory a custom span factory for converting TextLinks to TextLinkSpans.
 *      Set to {@code null} to use the default span factory.
 *
 * This value may be {@code null}.
 * @return a status code indicating whether or not the links were successfully applied
 *      e.g. {@link #STATUS_LINKS_APPLIED}
 
 * Value is {@link android.view.textclassifier.TextLinks#STATUS_LINKS_APPLIED}, {@link android.view.textclassifier.TextLinks#STATUS_NO_LINKS_FOUND}, {@link android.view.textclassifier.TextLinks#STATUS_NO_LINKS_APPLIED}, {@link android.view.textclassifier.TextLinks#STATUS_DIFFERENT_TEXT}, or {@link android.view.textclassifier.TextLinks#STATUS_UNSUPPORTED_CHARACTER}
 * @apiSince 28
 */

public int apply(@androidx.annotation.NonNull android.text.Spannable text, int applyStrategy, @androidx.annotation.Nullable java.util.function.Function<android.view.textclassifier.TextLinks.TextLink,android.view.textclassifier.TextLinks.TextLinkSpan> spanFactory) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Do not replace {@link android.text.style.ClickableSpan ClickableSpan}s that exist where the {@link android.view.textclassifier.TextLinks.TextLinkSpan TextLinkSpan} needs to
 * be applied to. Do not apply the TextLinkSpan.
 * @apiSince 28
 */

public static final int APPLY_STRATEGY_IGNORE = 0; // 0x0

/**
 * Replace any {@link android.text.style.ClickableSpan ClickableSpan}s that exist where the {@link android.view.textclassifier.TextLinks.TextLinkSpan TextLinkSpan} needs to be
 * applied to.
 * @apiSince 28
 */

public static final int APPLY_STRATEGY_REPLACE = 1; // 0x1

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLinks> CREATOR;
static { CREATOR = null; }

/**
 * The specified text does not match the text used to generate the links.
 * @apiSince 28
 */

public static final int STATUS_DIFFERENT_TEXT = 3; // 0x3

/**
 * Links were successfully applied to the text.
 * @apiSince 28
 */

public static final int STATUS_LINKS_APPLIED = 0; // 0x0

/**
 * No links applied to text. The links were filtered out.
 * @apiSince 28
 */

public static final int STATUS_NO_LINKS_APPLIED = 2; // 0x2

/**
 * No links exist to apply to text. Links count is zero.
 * @apiSince 28
 */

public static final int STATUS_NO_LINKS_FOUND = 1; // 0x1

/**
 * The specified text contains unsupported characters.
 * @apiSince 29
 */

public static final int STATUS_UNSUPPORTED_CHARACTER = 4; // 0x4
/**
 * A builder to construct a TextLinks instance.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create a new TextLinks.Builder.
 *
 * @param fullText The full text to annotate with links
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull java.lang.String fullText) { throw new RuntimeException("Stub!"); }

/**
 * Adds a TextLink.
 *
 * @param start The start index of the identified subsequence
 * @param end The end index of the identified subsequence
 * @param entityScores A mapping of entity type to confidence score
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if entityScores is null or empty.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks.Builder addLink(int start, int end, @androidx.annotation.NonNull java.util.Map<java.lang.String,java.lang.Float> entityScores) { throw new RuntimeException("Stub!"); }

/**
 * Adds a TextLink.
 *
 * @see #addLink(int, int, Map)
 * @param extras An optional bundle containing custom data related to this TextLink
 
 * This value must never be {@code null}.
 * @param entityScores This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks.Builder addLink(int start, int end, @androidx.annotation.NonNull java.util.Map<java.lang.String,java.lang.Float> entityScores, @androidx.annotation.NonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Removes all {@link android.view.textclassifier.TextLinks.TextLink TextLink}s.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks.Builder clearTextLinks() { throw new RuntimeException("Stub!"); }

/**
 * Sets the extended data.
 *
 * @param extras This value may be {@code null}.
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a TextLinks instance.
 *
 * @return the constructed TextLinks
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks build() { throw new RuntimeException("Stub!"); }
}

/**
 * A request object for generating TextLinks.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Request implements android.os.Parcelable {

private Request() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text to generate links for.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * @return ordered list of locale preferences that can be used to disambiguate
 *      the provided text
 
 * This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.os.LocaleList getDefaultLocales() { throw new RuntimeException("Stub!"); }

/**
 * @return The config representing the set of entities to look for
 * This value may be {@code null}.
 * @see android.view.textclassifier.TextLinks.Request.Builder#setEntityConfig(EntityConfig)
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.view.textclassifier.TextClassifier.EntityConfig getEntityConfig() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLinks.Request> CREATOR;
static { CREATOR = null; }
/**
 * A builder for building TextLinks requests.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * @param text This value must never be {@code null}.
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * @param defaultLocales ordered list of locale preferences that may be used to
 *                       disambiguate the provided text. If no locale preferences exist,
 *                       set this to null or an empty locale list.
 * This value may be {@code null}.
 * @return this builder
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks.Request.Builder setDefaultLocales(@androidx.annotation.Nullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * Sets the entity configuration to use. This determines what types of entities the
 * TextClassifier will look for.
 * Set to {@code null} for the default entity config and teh TextClassifier will
 * automatically determine what links to generate.
 *
 * @param entityConfig This value may be {@code null}.
 * @return this builder
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks.Request.Builder setEntityConfig(@androidx.annotation.Nullable android.view.textclassifier.TextClassifier.EntityConfig entityConfig) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extended data.
 *
 * @param extras This value may be {@code null}.
 * @return this builder
 * @apiSince 29
 */

public android.view.textclassifier.TextLinks.Request.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns the request object.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLinks.Request build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * A link, identifying a substring of text and possible entity types for it.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class TextLink implements android.os.Parcelable {

private TextLink() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start index of this link in the original text.
 *
 * @return the start index
 * @apiSince 28
 */

public int getStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end index of this link in the original text.
 *
 * @return the end index
 * @apiSince 28
 */

public int getEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of entity types that have confidence scores.
 *
 * @return the entity count
 * @apiSince 28
 */

public int getEntityCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the entity type at a given index. Entity types are sorted by confidence.
 *
 * @return the entity type at the provided index
 
 * This value will never be {@code null}.
 
 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}, or android.view.textclassifier.TextClassifier.TYPE_DICTIONARY
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getEntity(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the confidence score for a particular entity type.
 *
 * @param entityType the entity type
 
 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}, or android.view.textclassifier.TextClassifier.TYPE_DICTIONARY
 * @return Value is between 0.0 and 1.0 inclusive
 * @apiSince 28
 */

public float getConfidenceScore(java.lang.String entityType) { throw new RuntimeException("Stub!"); }

/**
 * Returns a bundle containing custom data related to this TextLink.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLinks.TextLink> CREATOR;
static { CREATOR = null; }
}

/**
 * A ClickableSpan for a TextLink.
 *
 * <p>Applies only to TextViews.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TextLinkSpan extends android.text.style.ClickableSpan {

/**
 * @param textLink This value must never be {@code null}.
 * @apiSince 28
 */

public TextLinkSpan(@androidx.annotation.NonNull android.view.textclassifier.TextLinks.TextLink textLink) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void onClick(android.view.View widget) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public final android.view.textclassifier.TextLinks.TextLink getTextLink() { throw new RuntimeException("Stub!"); }
}

}

