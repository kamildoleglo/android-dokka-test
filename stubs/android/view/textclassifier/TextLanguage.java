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
 * Represents the result of language detection of a piece of text.
 * <p>
 * This contains a list of locales, each paired with a confidence score, sorted in decreasing
 * order of those scores. E.g., for a given input text, the model may return
 * {@code [<"en", 0.85>, <"fr", 0.15>]}. This sample result means the model reports that it is
 * 85% likely that the entire text is in English and 15% likely that the entire text is in French,
 * etc. It does not mean that 85% of the input is in English and 15% is in French.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextLanguage implements android.os.Parcelable {

private TextLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id, if one exists, for this object.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of possible locales for the processed text.
 
 * @return Value is 0 or greater
 * @apiSince 29
 */

public int getLocaleHypothesisCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the language locale at the specified index. Locales are ordered from high
 * confidence to low confidence.
 * <p>
 * See {@link #getLocaleHypothesisCount()} for the number of locales available.
 *
 * @throws java.lang.IndexOutOfBoundsException if the specified index is out of range.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.icu.util.ULocale getLocale(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the confidence score for the specified language locale. The value ranges from
 * 0 (low confidence) to 1 (high confidence). 0 indicates that the locale was not found for
 * the processed text.
 
 * @param locale This value must never be {@code null}.
 * @return Value is between 0.0 and 1.0 inclusive
 * @apiSince 29
 */

public float getConfidenceScore(@androidx.annotation.NonNull android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a bundle containing non-structured extra information about this result. What is
 * returned in the extras is specific to the {@link android.view.textclassifier.TextClassifier TextClassifier} implementation.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLanguage> CREATOR;
static { CREATOR = null; }
/**
 * Builder used to build TextLanguage objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets a language locale for the processed text and assigns a confidence score. If the
 * locale has already been set, this updates it.
 *
 * @param confidenceScore a value from 0 (low confidence) to 1 (high confidence).
 *      0 implies the locale does not exist for the processed text.
 *      Values greater than 1 are clamped to 1.
 
 * Value is between 0.0 and 1.0 inclusive
 * @param locale This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLanguage.Builder putLocale(@androidx.annotation.NonNull android.icu.util.ULocale locale, float confidenceScore) { throw new RuntimeException("Stub!"); }

/**
 * Sets an optional id for the TextLanguage object.
 
 * @param id This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLanguage.Builder setId(@androidx.annotation.Nullable java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Sets a bundle containing non-structured extra information about the TextLanguage object.
 
 * @param bundle This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLanguage.Builder setExtras(@androidx.annotation.NonNull android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns a new TextLanguage object.
 * <p>
 * If necessary, this method will verify fields, clamp them, and make them immutable.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLanguage build() { throw new RuntimeException("Stub!"); }
}

/**
 * A request object for detecting the language of a piece of text.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Request implements android.os.Parcelable {

private Request() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text to process.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the package that sent this request.
 * This returns null if no calling package name is set.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getCallingPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bundle containing non-structured extra information about this request.
 *
 * <p><b>NOTE: </b>Do not modify this bundle.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLanguage.Request> CREATOR;
static { CREATOR = null; }
/**
 * A builder for building TextLanguage requests.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a builder to build TextLanguage requests.
 *
 * @param text the text to process.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Sets a bundle containing non-structured extra information about the request.
 
 * @param bundle This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLanguage.Request.Builder setExtras(@androidx.annotation.NonNull android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns a new TextLanguage request object.
 * <p>
 * If necessary, this method will verify fields, clamp them, and make them immutable.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextLanguage.Request build() { throw new RuntimeException("Stub!"); }
}

}

}

