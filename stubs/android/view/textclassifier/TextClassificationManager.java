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


/**
 * Interface to the text classification service.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextClassificationManager {

TextClassificationManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text classifier that was set via {@link #setTextClassifier(android.view.textclassifier.TextClassifier)}.
 * If this is null, this method returns a default text classifier (i.e. either the system text
 * classifier if one exists, or a local text classifier running in this process.)
 * <p>
 * Note that requests to the TextClassifier may be handled in an OEM-provided process rather
 * than in the calling app's process.
 *
 * @see #setTextClassifier(TextClassifier)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier getTextClassifier() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text classifier.
 * Set to null to use the system default text classifier.
 * Set to {@link android.view.textclassifier.TextClassifier#NO_OP TextClassifier#NO_OP} to disable text classifier features.
 
 * @param textClassifier This value may be {@code null}.
 * @apiSince 26
 */

public void setTextClassifier(@androidx.annotation.Nullable android.view.textclassifier.TextClassifier textClassifier) { throw new RuntimeException("Stub!"); }

/**
 * Call this method to start a text classification session with the given context.
 * A session is created with a context helping the classifier better understand
 * what the user needs and consists of queries and feedback events. The queries
 * are directly related to providing useful functionality to the user and the events
 * are a feedback loop back to the classifier helping it learn and better serve
 * future queries.
 *
 * <p> All interactions with the returned classifier are considered part of a single
 * session and are logically grouped. For example, when a text widget is focused
 * all user interactions around text editing (selection, editing, etc) can be
 * grouped together to allow the classifier get better.
 *
 * @param classificationContext The context in which classification would occur
 *
 * This value must never be {@code null}.
 * @return An instance to perform classification in the given context
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.textclassifier.TextClassifier createTextClassificationSession(@androidx.annotation.NonNull android.view.textclassifier.TextClassificationContext classificationContext) { throw new RuntimeException("Stub!"); }

/**
 * Sets a TextClassificationSessionFactory to be used to create session-aware TextClassifiers.
 *
 * @param factory the textClassification session factory. If this is null, the default factory
 *      will be used.
 
 * This value may be {@code null}.
 * @apiSince 28
 */

public void setTextClassificationSessionFactory(@androidx.annotation.Nullable android.view.textclassifier.TextClassificationSessionFactory factory) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

