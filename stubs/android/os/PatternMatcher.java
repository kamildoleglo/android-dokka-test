/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.os;


/**
 * A simple pattern matcher, which is safe to use on untrusted data: it does
 * not provide full reg-exp support, only simple globbing that can not be
 * used maliciously.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PatternMatcher implements android.os.Parcelable {

/** @apiSince 1 */

public PatternMatcher(java.lang.String pattern, int type) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public PatternMatcher(android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final java.lang.String getPath() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getType() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean match(java.lang.String str) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.PatternMatcher> CREATOR;
static { CREATOR = null; }

/**
 * Pattern type: the given pattern is interpreted with a regular
 * expression-like syntax for matching against the string it is tested
 * against. Supported tokens include dot ({@code .}) and sets ({@code [...]})
 * with full support for character ranges and the not ({@code ^}) modifier.
 * Supported modifiers include star ({@code *}) for zero-or-more, plus ({@code +})
 * for one-or-more and full range ({@code {...}}) support. This is a simple
 * evaluation implementation in which matching is done against the pattern in
 * real time with no backtracking support.
 * @apiSince 26
 */

public static final int PATTERN_ADVANCED_GLOB = 3; // 0x3

/**
 * Pattern type: the given pattern must exactly match the string it is
 * tested against.
 * @apiSince 1
 */

public static final int PATTERN_LITERAL = 0; // 0x0

/**
 * Pattern type: the given pattern must match the
 * beginning of the string it is tested against.
 * @apiSince 1
 */

public static final int PATTERN_PREFIX = 1; // 0x1

/**
 * Pattern type: the given pattern is interpreted with a
 * simple glob syntax for matching against the string it is tested against.
 * In this syntax, you can use the '*' character to match against zero or
 * more occurrences of the character immediately before.  If the
 * character before it is '.' it will match any character.  The character
 * '\' can be used as an escape.  This essentially provides only the '*'
 * wildcard part of a normal regexp.
 * @apiSince 1
 */

public static final int PATTERN_SIMPLE_GLOB = 2; // 0x2
}

