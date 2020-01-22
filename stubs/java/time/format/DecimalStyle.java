/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Copyright (c) 2008-2012, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


package java.time.format;

import java.util.Set;
import java.util.Locale;

/**
 * Localized decimal style used in date and time formatting.
 * <p>
 * A significant part of dealing with dates and times is the localization.
 * This class acts as a central point for accessing the information.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DecimalStyle {

private DecimalStyle() { throw new RuntimeException("Stub!"); }

/**
 * Lists all the locales that are supported.
 * <p>
 * The locale 'en_US' will always be present.
 *
 * @return a Set of Locales for which localization is supported
 * @apiSince 26
 */

public static java.util.Set<java.util.Locale> getAvailableLocales() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the DecimalStyle for the default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>
 * This method provides access to locale sensitive decimal style symbols.
 * <p>
 * This is equivalent to calling
 * {@link #of(java.util.Locale)
 *     of(Locale.getDefault(Locale.Category.FORMAT))}.
 *
 * @see java.util.Locale.Category#FORMAT
 * @return the decimal style, not null
 * @apiSince 26
 */

public static java.time.format.DecimalStyle ofDefaultLocale() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the DecimalStyle for the specified locale.
 * <p>
 * This method provides access to locale sensitive decimal style symbols.
 *
 * @param locale  the locale, not null
 * @return the decimal style, not null
 * @apiSince 26
 */

public static java.time.format.DecimalStyle of(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character that represents zero.
 * <p>
 * The character used to represent digits may vary by culture.
 * This method specifies the zero character to use, which implies the characters for one to nine.
 *
 * @return the character for zero
 * @apiSince 26
 */

public char getZeroDigit() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the info with a new character that represents zero.
 * <p>
 * The character used to represent digits may vary by culture.
 * This method specifies the zero character to use, which implies the characters for one to nine.
 *
 * @param zeroDigit  the character for zero
 * @return  a copy with a new character that represents zero, not null
 
 * @apiSince 26
 */

public java.time.format.DecimalStyle withZeroDigit(char zeroDigit) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character that represents the positive sign.
 * <p>
 * The character used to represent a positive number may vary by culture.
 * This method specifies the character to use.
 *
 * @return the character for the positive sign
 * @apiSince 26
 */

public char getPositiveSign() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the info with a new character that represents the positive sign.
 * <p>
 * The character used to represent a positive number may vary by culture.
 * This method specifies the character to use.
 *
 * @param positiveSign  the character for the positive sign
 * @return  a copy with a new character that represents the positive sign, not null
 * @apiSince 26
 */

public java.time.format.DecimalStyle withPositiveSign(char positiveSign) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character that represents the negative sign.
 * <p>
 * The character used to represent a negative number may vary by culture.
 * This method specifies the character to use.
 *
 * @return the character for the negative sign
 * @apiSince 26
 */

public char getNegativeSign() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the info with a new character that represents the negative sign.
 * <p>
 * The character used to represent a negative number may vary by culture.
 * This method specifies the character to use.
 *
 * @param negativeSign  the character for the negative sign
 * @return  a copy with a new character that represents the negative sign, not null
 * @apiSince 26
 */

public java.time.format.DecimalStyle withNegativeSign(char negativeSign) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character that represents the decimal point.
 * <p>
 * The character used to represent a decimal point may vary by culture.
 * This method specifies the character to use.
 *
 * @return the character for the decimal point
 * @apiSince 26
 */

public char getDecimalSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the info with a new character that represents the decimal point.
 * <p>
 * The character used to represent a decimal point may vary by culture.
 * This method specifies the character to use.
 *
 * @param decimalSeparator  the character for the decimal point
 * @return  a copy with a new character that represents the decimal point, not null
 * @apiSince 26
 */

public java.time.format.DecimalStyle withDecimalSeparator(char decimalSeparator) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this DecimalStyle is equal to another DecimalStyle.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other date
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this DecimalStyle.
 *
 * @return a suitable hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this DecimalStyle.
 *
 * @return a string description, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The standard set of non-localized decimal style symbols.
 * <p>
 * This uses standard ASCII characters for zero, positive, negative and a dot for the decimal point.
 * @apiSince 26
 */

public static final java.time.format.DecimalStyle STANDARD;
static { STANDARD = null; }
}

