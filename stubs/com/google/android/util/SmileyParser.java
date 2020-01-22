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


package com.google.android.util;


/**
 * Parses a text message typed by the user looking for smileys.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SmileyParser extends com.google.android.util.AbstractMessageParser {

/** @apiSince R */

public SmileyParser(java.lang.String text, com.google.android.util.SmileyResources res) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/** @apiSince R */

protected com.google.android.util.AbstractMessageParser.Resources getResources() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the parsed text as a spannable string object.
 * @param context the context for fetching smiley resources.
 * @return the spannable string as CharSequence.
 * @apiSince R
 */

public java.lang.CharSequence getSpannableString(android.content.Context context) { throw new RuntimeException("Stub!"); }
}

