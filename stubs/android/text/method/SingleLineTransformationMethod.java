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
 * This transformation method causes any newline characters (\n) to be
 * displayed as spaces instead of causing line breaks, and causes
 * carriage return characters (\r) to have no appearance.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SingleLineTransformationMethod extends android.text.method.ReplacementTransformationMethod {

public SingleLineTransformationMethod() { throw new RuntimeException("Stub!"); }

/**
 * The characters to be replaced are \n and \r.
 * @apiSince 1
 */

protected char[] getOriginal() { throw new RuntimeException("Stub!"); }

/**
 * The character \n is replaced with is space;
 * the character \r is replaced with is FEFF (zero width space).
 * @apiSince 1
 */

protected char[] getReplacement() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.text.method.SingleLineTransformationMethod getInstance() { throw new RuntimeException("Stub!"); }
}

