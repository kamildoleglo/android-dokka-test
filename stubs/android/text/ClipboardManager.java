/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.text;


/**
 * @deprecated Old text-only interface to the clipboard.  See
 * {@link android.content.ClipboardManager} for the modern API.
 * @apiSince 1
 * @deprecatedSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class ClipboardManager {

@Deprecated
public ClipboardManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text on the clipboard.  It will eventually be possible
 * to store types other than text too, in which case this will return
 * null if the type cannot be coerced to text.
 * @apiSince 1
 * @deprecatedSince 11
 */

@Deprecated
public abstract java.lang.CharSequence getText();

/**
 * Sets the contents of the clipboard to the specified text.
 * @apiSince 1
 * @deprecatedSince 11
 */

@Deprecated
public abstract void setText(java.lang.CharSequence text);

/**
 * Returns true if the clipboard contains text; false otherwise.
 * @apiSince 1
 * @deprecatedSince 11
 */

@Deprecated
public abstract boolean hasText();
}

