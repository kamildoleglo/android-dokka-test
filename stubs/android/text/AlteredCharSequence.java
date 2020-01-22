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
 * An AlteredCharSequence is a CharSequence that is largely mirrored from
 * another CharSequence, except that a specified range of characters are
 * mirrored from a different char array instead.
 *
 * @deprecated The functionality this class offers is easily implemented outside the framework.
 * @apiSince 1
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class AlteredCharSequence implements java.lang.CharSequence, android.text.GetChars {

private AlteredCharSequence() { throw new RuntimeException("Stub!"); }

/**
 * Create an AlteredCharSequence whose text (and possibly spans)
 * are mirrored from <code>source</code>, except that the range of
 * offsets <code>substart</code> inclusive to <code>subend</code> exclusive
 * are mirrored instead from <code>sub</code>, beginning at offset 0.
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public static android.text.AlteredCharSequence make(java.lang.CharSequence source, char[] sub, int substart, int subend) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public char charAt(int off) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public int length() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public java.lang.CharSequence subSequence(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void getChars(int start, int end, char[] dest, int off) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

