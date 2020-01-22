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


package android.text;


/**
 * AndroidCharacter exposes some character properties that used to be not
 * easily accessed from java.lang.Character, but are now available in ICU.
 * @deprecated Use various methods from {@link android.icu.lang.UCharacter}, instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class AndroidCharacter {

@Deprecated
public AndroidCharacter() { throw new RuntimeException("Stub!"); }

/**
 * Fill in the first <code>count</code> bytes of <code>dest</code> with the
 * directionalities from the first <code>count</code> chars of <code>src</code>.
 * This is just like Character.getDirectionality() except it is a
 * batch operation.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static native void getDirectionalities(char[] src, byte[] dest, int count);

/**
 * Calculate the East Asian Width of a character according to
 * <a href="http://unicode.org/reports/tr11/">Unicode TR#11</a>. The return
 * will be one of {@link #EAST_ASIAN_WIDTH_NEUTRAL},
 * {@link #EAST_ASIAN_WIDTH_AMBIGUOUS}, {@link #EAST_ASIAN_WIDTH_HALF_WIDTH},
 * {@link #EAST_ASIAN_WIDTH_FULL_WIDTH}, {@link #EAST_ASIAN_WIDTH_NARROW},
 * or {@link #EAST_ASIAN_WIDTH_WIDE}.
 *
 * @param input the character to measure
 * @return the East Asian Width for input
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated
public static native int getEastAsianWidth(char input);

/**
 * Fill the first <code>count</code> bytes of <code>dest</code> with the
 * East Asian Width from <code>count</code> chars of <code>src</code>
 * starting at <code>start</code>. East Asian Width is calculated based on
 * <a href="http://unicode.org/reports/tr11/">Unicode TR#11</a>. Each entry
 * in <code>dest</code> will be one of {@link #EAST_ASIAN_WIDTH_NEUTRAL},
 * {@link #EAST_ASIAN_WIDTH_AMBIGUOUS}, {@link #EAST_ASIAN_WIDTH_HALF_WIDTH},
 * {@link #EAST_ASIAN_WIDTH_FULL_WIDTH}, {@link #EAST_ASIAN_WIDTH_NARROW},
 * or {@link #EAST_ASIAN_WIDTH_WIDE}.
 *
 * @param src character array of input to measure
 * @param start first character in array to measure
 * @param count maximum number of characters to measure
 * @param dest byte array of results for each character in src
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated
public static native void getEastAsianWidths(char[] src, int start, int count, byte[] dest);

/**
 * Replace the specified slice of <code>text</code> with the chars'
 * right-to-left mirrors (if any), returning true if any
 * replacements were made.
 *
 * @param text array of characters to apply mirror operation
 * @param start first character in array to mirror
 * @param count maximum number of characters to mirror
 * @return true if replacements were made
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static native boolean mirror(char[] text, int start, int count);

/**
 * Return the right-to-left mirror (or the original char if none)
 * of the specified char.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static native char getMirror(char ch);

/**
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated public static final int EAST_ASIAN_WIDTH_AMBIGUOUS = 1; // 0x1

/**
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated public static final int EAST_ASIAN_WIDTH_FULL_WIDTH = 3; // 0x3

/**
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated public static final int EAST_ASIAN_WIDTH_HALF_WIDTH = 2; // 0x2

/**
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated public static final int EAST_ASIAN_WIDTH_NARROW = 4; // 0x4

/**
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated public static final int EAST_ASIAN_WIDTH_NEUTRAL = 0; // 0x0

/**
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated public static final int EAST_ASIAN_WIDTH_WIDE = 5; // 0x5
}

