/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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



package java.util;


/**
 * Represents a currency. Currencies are identified by their ISO 4217 currency
 * codes. Visit the <a href="http://www.iso.org/iso/home/standards/currency_codes.htm">
 * ISO web site</a> for more information.
 * <p>
 * The class is designed so that there's never more than one
 * <code>Currency</code> instance for any given currency. Therefore, there's
 * no public constructor. You obtain a <code>Currency</code> instance using
 * the <code>getInstance</code> methods.
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Currency implements java.io.Serializable {

private Currency() { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>Currency</code> instance for the given currency code.
 *
 * @param currencyCode the ISO 4217 code of the currency
 * @return the <code>Currency</code> instance for the given currency code
 * @exception java.lang.NullPointerException if <code>currencyCode</code> is null
 * @exception java.lang.IllegalArgumentException if <code>currencyCode</code> is not
 * a supported ISO 4217 code.
 * @apiSince 1
 */

public static java.util.Currency getInstance(java.lang.String currencyCode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>Currency</code> instance for the country of the
 * given locale. The language and variant components of the locale
 * are ignored. The result may vary over time, as countries change their
 * currencies. For example, for the original member countries of the
 * European Monetary Union, the method returns the old national currencies
 * until December 31, 2001, and the Euro from January 1, 2002, local time
 * of the respective countries.
 * <p>
 * The method returns <code>null</code> for territories that don't
 * have a currency, such as Antarctica.
 *
 * @param locale the locale for whose country a <code>Currency</code>
 * instance is needed
 * @return the <code>Currency</code> instance for the country of the given
 * locale, or {@code null}
 * @exception java.lang.NullPointerException if <code>locale</code> or its country
 * code is {@code null}
 * @exception java.lang.IllegalArgumentException if the country of the given {@code locale}
 * is not a supported ISO 3166 country code.
 * @apiSince 1
 */

public static java.util.Currency getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of available currencies.  The returned set of currencies
 * contains all of the available currencies, which may include currencies
 * that represent obsolete ISO 4217 codes.  The set can be modified
 * without affecting the available currencies in the runtime.
 *
 * @return the set of available currencies.  If there is no currency
 *    available in the runtime, the returned set is empty.
 * @since 1.7
 * @apiSince 19
 */

public static java.util.Set<java.util.Currency> getAvailableCurrencies() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ISO 4217 currency code of this currency.
 *
 * @return the ISO 4217 currency code of this currency.
 * @apiSince 1
 */

public java.lang.String getCurrencyCode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the symbol of this currency for the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale.
 * For example, for the US Dollar, the symbol is "$" if the default
 * locale is the US, while for other locales it may be "US$". If no
 * symbol can be determined, the ISO 4217 currency code is returned.
 * <p>
 * This is equivalent to calling
 * {@link #getSymbol(java.util.Locale)
 *     getSymbol(Locale.getDefault(Locale.Category.DISPLAY))}.
 *
 * @return the symbol of this currency for the default
 *     {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale
 * @apiSince 1
 */

public java.lang.String getSymbol() { throw new RuntimeException("Stub!"); }

/**
 * Gets the symbol of this currency for the specified locale.
 * For example, for the US Dollar, the symbol is "$" if the specified
 * locale is the US, while for other locales it may be "US$". If no
 * symbol can be determined, the ISO 4217 currency code is returned.
 *
 * @param locale the locale for which a display name for this currency is
 * needed
 * @return the symbol of this currency for the specified locale
 * @exception java.lang.NullPointerException if <code>locale</code> is null
 * @apiSince 1
 */

public java.lang.String getSymbol(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the default number of fraction digits used with this currency.
 * For example, the default number of fraction digits for the Euro is 2,
 * while for the Japanese Yen it's 0.
 * In the case of pseudo-currencies, such as IMF Special Drawing Rights,
 * -1 is returned.
 *
 * @return the default number of fraction digits used with this currency
 * @apiSince 1
 */

public int getDefaultFractionDigits() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ISO 4217 numeric code of this currency.
 *
 * @return the ISO 4217 numeric code of this currency
 * @since 1.7
 * @apiSince 24
 */

public int getNumericCode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name that is suitable for displaying this currency for
 * the default {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale.
 * If there is no suitable display name found
 * for the default locale, the ISO 4217 currency code is returned.
 * <p>
 * This is equivalent to calling
 * {@link #getDisplayName(java.util.Locale)
 *     getDisplayName(Locale.getDefault(Locale.Category.DISPLAY))}.
 *
 * @return the display name of this currency for the default
 *     {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale
 * @since 1.7
 * @apiSince 19
 */

public java.lang.String getDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name that is suitable for displaying this currency for
 * the specified locale.  If there is no suitable display name found
 * for the specified locale, the ISO 4217 currency code is returned.
 *
 * @param locale the locale for which a display name for this currency is
 * needed
 * @return the display name of this currency for the specified locale
 * @exception java.lang.NullPointerException if <code>locale</code> is null
 * @since 1.7
 * @apiSince 19
 */

public java.lang.String getDisplayName(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ISO 4217 currency code of this currency.
 *
 * @return the ISO 4217 currency code of this currency
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

