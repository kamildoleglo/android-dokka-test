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
 * TextView uses TransformationMethods to do things like replacing the
 * characters of passwords with dots, or keeping the newline characters
 * from causing line breaks in single-line text fields.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TransformationMethod {

/**
 * Returns a CharSequence that is a transformation of the source text --
 * for example, replacing each character with a dot in a password field.
 * Beware that the returned text must be exactly the same length as
 * the source text, and that if the source text is Editable, the returned
 * text must mirror it dynamically instead of doing a one-time copy.
 * The method should not return {@code null} unless {@code source}
 * is {@code null}.
 * @apiSince 1
 */

public java.lang.CharSequence getTransformation(java.lang.CharSequence source, android.view.View view);

/**
 * This method is called when the TextView that uses this
 * TransformationMethod gains or loses focus.
 * @apiSince 1
 */

public void onFocusChanged(android.view.View view, java.lang.CharSequence sourceText, boolean focused, int direction, android.graphics.Rect previouslyFocusedRect);
}

