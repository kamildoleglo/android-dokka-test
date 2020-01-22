/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.text.method;


/**
 * This transformation method causes the characters in the {@link #getOriginal}
 * array to be replaced by the corresponding characters in the
 * {@link #getReplacement} array.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ReplacementTransformationMethod implements android.text.method.TransformationMethod {

public ReplacementTransformationMethod() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of characters that are to be replaced by other
 * characters when displayed.
 * @apiSince 1
 */

protected abstract char[] getOriginal();

/**
 * Returns a parallel array of replacement characters for the ones
 * that are to be replaced.
 * @apiSince 1
 */

protected abstract char[] getReplacement();

/**
 * Returns a CharSequence that will mirror the contents of the
 * source CharSequence but with the characters in {@link #getOriginal}
 * replaced by ones from {@link #getReplacement}.
 * @apiSince 1
 */

public java.lang.CharSequence getTransformation(java.lang.CharSequence source, android.view.View v) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onFocusChanged(android.view.View view, java.lang.CharSequence sourceText, boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }
}

