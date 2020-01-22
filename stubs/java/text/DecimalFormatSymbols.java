/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1998 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */



package java.text;

import java.util.Locale;
import java.util.Currency;

/**
 * This class represents the set of symbols (such as the decimal separator,
 * the grouping separator, and so on) needed by <code>DecimalFormat</code>
 * to format numbers. <code>DecimalFormat</code> creates for itself an instance of
 * <code>DecimalFormatSymbols</code> from its locale data.  If you need to change any
 * of these symbols, you can get the <code>DecimalFormatSymbols</code> object from
 * your <code>DecimalFormat</code> and modify it.
 *
 * @see          java.util.Locale
 * @see          java.text.DecimalFormat
 * @author       Mark Davis
 * @author       Alan Liu
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DecimalFormatSymbols implements java.lang.Cloneable, java.io.Serializable {

/**
 * Create a DecimalFormatSymbols object for the default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * It is recommended that the {@link #getInstance(java.util.Locale) getInstance} method is used
 * instead.
 * <p>This is equivalent to calling
 * {@link #DecimalFormatSymbols(java.util.Locale)
 *     DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @apiSince 1
 */

public DecimalFormatSymbols() { throw new RuntimeException("Stub!"); }

/**
 * Create a DecimalFormatSymbols object for the given locale.
 * It is recommended that the {@link #getInstance(java.util.Locale) getInstance} method is used
 * instead.
 * If the specified locale contains the {@link java.util.Locale#UNICODE_LOCALE_EXTENSION}
 * for the numbering system, the instance is initialized with the specified numbering
 * system if the JRE implementation supports it. For example,
 * <pre>
 * NumberFormat.getNumberInstance(Locale.forLanguageTag("th-TH-u-nu-thai"))
 * </pre>
 * This may return a {@code NumberFormat} instance with the Thai numbering system,
 * instead of the Latin numbering system.
 *
 * @param locale the desired locale
 * @exception java.lang.NullPointerException if <code>locale</code> is null
 * @apiSince 1
 */

public DecimalFormatSymbols(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all locales for which the
 * <code>getInstance</code> methods of this class can return
 * localized instances.
 *
 * @return an array of locales for which localized
 *         <code>DecimalFormatSymbols</code> instances are available.
 * @since 1.6
 * @apiSince 9
 */

public static java.util.Locale[] getAvailableLocales() { throw new RuntimeException("Stub!"); }

/**
 * Gets the <code>DecimalFormatSymbols</code> instance for the default
 * locale.
 * <p>This is equivalent to calling
 * {@link #getInstance(java.util.Locale)
 *     getInstance(Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @return a <code>DecimalFormatSymbols</code> instance.
 * @since 1.6
 * @apiSince 9
 */

public static final java.text.DecimalFormatSymbols getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the <code>DecimalFormatSymbols</code> instance for the specified
 * locale.
 * If the specified locale contains the {@link java.util.Locale#UNICODE_LOCALE_EXTENSION}
 * for the numbering system, the instance is initialized with the specified numbering
 * system if the JRE implementation supports it. For example,
 * <pre>
 * NumberFormat.getNumberInstance(Locale.forLanguageTag("th-TH-u-nu-thai"))
 * </pre>
 * This may return a {@code NumberFormat} instance with the Thai numbering system,
 * instead of the Latin numbering system.
 *
 * @param locale the desired locale.
 * @return a <code>DecimalFormatSymbols</code> instance.
 * @exception java.lang.NullPointerException if <code>locale</code> is null
 * @since 1.6
 * @apiSince 9
 */

public static final java.text.DecimalFormatSymbols getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used for zero. Different for Arabic, etc.
 *
 * @return the character used for zero
 * @apiSince 1
 */

public char getZeroDigit() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for zero. Different for Arabic, etc.
 *
 * @param zeroDigit the character used for zero
 * @apiSince 1
 */

public void setZeroDigit(char zeroDigit) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used for thousands separator. Different for French, etc.
 *
 * @return the grouping separator
 * @apiSince 1
 */

public char getGroupingSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for thousands separator. Different for French, etc.
 *
 * @param groupingSeparator the grouping separator
 * @apiSince 1
 */

public void setGroupingSeparator(char groupingSeparator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used for decimal sign. Different for French, etc.
 *
 * @return the character used for decimal sign
 * @apiSince 1
 */

public char getDecimalSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for decimal sign. Different for French, etc.
 *
 * @param decimalSeparator the character used for decimal sign
 * @apiSince 1
 */

public void setDecimalSeparator(char decimalSeparator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used for per mille sign. Different for Arabic, etc.
 *
 * @return the character used for per mille sign
 * @apiSince 1
 */

public char getPerMill() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for per mille sign. Different for Arabic, etc.
 *
 * @param perMill the character used for per mille sign
 * @apiSince 1
 */

public void setPerMill(char perMill) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used for percent sign. Different for Arabic, etc.
 *
 * @return the character used for percent sign
 * @apiSince 1
 */

public char getPercent() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for percent sign. Different for Arabic, etc.
 *
 * @param percent the character used for percent sign
 * @apiSince 1
 */

public void setPercent(char percent) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used for a digit in a pattern.
 *
 * @return the character used for a digit in a pattern
 * @apiSince 1
 */

public char getDigit() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for a digit in a pattern.
 *
 * @param digit the character used for a digit in a pattern
 * @apiSince 1
 */

public void setDigit(char digit) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used to separate positive and negative subpatterns
 * in a pattern.
 *
 * @return the pattern separator
 * @apiSince 1
 */

public char getPatternSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used to separate positive and negative subpatterns
 * in a pattern.
 *
 * @param patternSeparator the pattern separator
 * @apiSince 1
 */

public void setPatternSeparator(char patternSeparator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the string used to represent infinity. Almost always left
 * unchanged.
 *
 * @return the string representing infinity
 * @apiSince 1
 */

public java.lang.String getInfinity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the string used to represent infinity. Almost always left
 * unchanged.
 *
 * @param infinity the string representing infinity
 * @apiSince 1
 */

public void setInfinity(java.lang.String infinity) { throw new RuntimeException("Stub!"); }

/**
 * Gets the string used to represent "not a number". Almost always left
 * unchanged.
 *
 * @return the string representing "not a number"
 * @apiSince 1
 */

public java.lang.String getNaN() { throw new RuntimeException("Stub!"); }

/**
 * Sets the string used to represent "not a number". Almost always left
 * unchanged.
 *
 * @param NaN the string representing "not a number"
 * @apiSince 1
 */

public void setNaN(java.lang.String NaN) { throw new RuntimeException("Stub!"); }

/**
 * Gets the character used to represent minus sign. If no explicit
 * negative format is specified, one is formed by prefixing
 * minusSign to the positive format.
 *
 * @return the character representing minus sign
 * @apiSince 1
 */

public char getMinusSign() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used to represent minus sign. If no explicit
 * negative format is specified, one is formed by prefixing
 * minusSign to the positive format.
 *
 * @param minusSign the character representing minus sign
 * @apiSince 1
 */

public void setMinusSign(char minusSign) { throw new RuntimeException("Stub!"); }

/**
 * Returns the currency symbol for the currency of these
 * DecimalFormatSymbols in their locale.
 *
 * @return the currency symbol
 * @since 1.2
 * @apiSince 1
 */

public java.lang.String getCurrencySymbol() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currency symbol for the currency of these
 * DecimalFormatSymbols in their locale.
 *
 * @param currency the currency symbol
 * @since 1.2
 * @apiSince 1
 */

public void setCurrencySymbol(java.lang.String currency) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ISO 4217 currency code of the currency of these
 * DecimalFormatSymbols.
 *
 * @return the currency code
 * @since 1.2
 * @apiSince 1
 */

public java.lang.String getInternationalCurrencySymbol() { throw new RuntimeException("Stub!"); }

/**
 * Sets the ISO 4217 currency code of the currency of these
 * DecimalFormatSymbols.
 * If the currency code is valid (as defined by
 * {@link java.util.Currency#getInstance(java.lang.String) Currency.getInstance}),
 * this also sets the currency attribute to the corresponding Currency
 * instance and the currency symbol attribute to the currency's symbol
 * in the DecimalFormatSymbols' locale. If the currency code is not valid,
 * then the currency attribute is set to null and the currency symbol
 * attribute is not modified.
 *
 * @param currencyCode the currency code
 * @see #setCurrency
 * @see #setCurrencySymbol
 * @since 1.2
 * @apiSince 1
 */

public void setInternationalCurrencySymbol(java.lang.String currencyCode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the currency of these DecimalFormatSymbols. May be null if the
 * currency symbol attribute was previously set to a value that's not
 * a valid ISO 4217 currency code.
 *
 * @return the currency used, or null
 * @since 1.4
 * @apiSince 1
 */

public java.util.Currency getCurrency() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currency of these DecimalFormatSymbols.
 * This also sets the currency symbol attribute to the currency's symbol
 * in the DecimalFormatSymbols' locale, and the international currency
 * symbol attribute to the currency's ISO 4217 currency code.
 *
 * @param currency the new currency to be used
 * @exception java.lang.NullPointerException if <code>currency</code> is null
 * @since 1.4
 * @see #setCurrencySymbol
 * @see #setInternationalCurrencySymbol
 * @apiSince 1
 */

public void setCurrency(java.util.Currency currency) { throw new RuntimeException("Stub!"); }

/**
 * Returns the monetary decimal separator.
 *
 * @return the monetary decimal separator
 * @since 1.2
 * @apiSince 1
 */

public char getMonetaryDecimalSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the monetary decimal separator.
 *
 * @param sep the monetary decimal separator
 * @since 1.2
 * @apiSince 1
 */

public void setMonetaryDecimalSeparator(char sep) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string used to separate the mantissa from the exponent.
 * Examples: "x10^" for 1.23x10^4, "E" for 1.23E4.
 *
 * @return the exponent separator string
 * @see #setExponentSeparator(java.lang.String)
 * @since 1.6
 * @apiSince 9
 */

public java.lang.String getExponentSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the string used to separate the mantissa from the exponent.
 * Examples: "x10^" for 1.23x10^4, "E" for 1.23E4.
 *
 * @param exp the exponent separator string
 * @exception java.lang.NullPointerException if <code>exp</code> is null
 * @see #getExponentSeparator()
 * @since 1.6
 * @apiSince 9
 */

public void setExponentSeparator(java.lang.String exp) { throw new RuntimeException("Stub!"); }

/**
 * Standard override.
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Override equals.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Override hashCode.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

