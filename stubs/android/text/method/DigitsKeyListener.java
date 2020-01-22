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

import java.util.Locale;

/**
 * For digits-only text entry
 * <p></p>
 * As for all implementations of {@link android.text.method.KeyListener KeyListener}, this class is only concerned
 * with hardware keyboards.  Software input methods have no obligation to trigger
 * the methods in this class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DigitsKeyListener extends android.text.method.NumberKeyListener {

/**
 * Allocates a DigitsKeyListener that accepts the ASCII digits 0 through 9.
 *
 * @deprecated Use {@link #DigitsKeyListener(java.util.Locale)} instead.
 * @apiSince 1
 */

@Deprecated
public DigitsKeyListener() { throw new RuntimeException("Stub!"); }

/**
 * Allocates a DigitsKeyListener that accepts the ASCII digits 0 through 9, plus the ASCII plus
 * or minus sign (only at the beginning) and/or the ASCII period ('.') as the decimal point
 * (only one per field) if specified.
 *
 * @deprecated Use {@link #DigitsKeyListener(java.util.Locale,boolean,boolean)} instead.
 * @apiSince 1
 */

@Deprecated
public DigitsKeyListener(boolean sign, boolean decimal) { throw new RuntimeException("Stub!"); }

/**
 * @param locale This value may be {@code null}.
 * @apiSince 26
 */

public DigitsKeyListener(@androidx.annotation.Nullable java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * @param locale This value may be {@code null}.
 * @apiSince 26
 */

public DigitsKeyListener(@androidx.annotation.Nullable java.util.Locale locale, boolean sign, boolean decimal) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected char[] getAcceptedChars() { throw new RuntimeException("Stub!"); }

/**
 * Returns a DigitsKeyListener that accepts the ASCII digits 0 through 9.
 *
 * @deprecated Use {@link #getInstance(java.util.Locale)} instead.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
@androidx.annotation.NonNull
public static android.text.method.DigitsKeyListener getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a DigitsKeyListener that accepts the ASCII digits 0 through 9, plus the ASCII plus
 * or minus sign (only at the beginning) and/or the ASCII period ('.') as the decimal point
 * (only one per field) if specified.
 *
 * @deprecated Use {@link #getInstance(java.util.Locale,boolean,boolean)} instead.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
@androidx.annotation.NonNull
public static android.text.method.DigitsKeyListener getInstance(boolean sign, boolean decimal) { throw new RuntimeException("Stub!"); }

/**
 * Returns a DigitsKeyListener that accepts the locale-appropriate digits.
 
 * @param locale This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.text.method.DigitsKeyListener getInstance(@androidx.annotation.Nullable java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a DigitsKeyListener that accepts the locale-appropriate digits, plus the
 * locale-appropriate plus or minus sign (only at the beginning) and/or the locale-appropriate
 * decimal separator (only one per field) if specified.
 
 * @param locale This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.text.method.DigitsKeyListener getInstance(@androidx.annotation.Nullable java.util.Locale locale, boolean sign, boolean decimal) { throw new RuntimeException("Stub!"); }

/**
 * Returns a DigitsKeyListener that accepts only the characters
 * that appear in the specified String.  Note that not all characters
 * may be available on every keyboard.
 
 * @param accepted This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static android.text.method.DigitsKeyListener getInstance(@androidx.annotation.NonNull java.lang.String accepted) { throw new RuntimeException("Stub!"); }

/**
 * Returns the input type for the listener.
 * @apiSince 3
 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.CharSequence filter(java.lang.CharSequence source, int start, int end, android.text.Spanned dest, int dstart, int dend) { throw new RuntimeException("Stub!"); }
}

