/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 1996-2016, International Business Machines Corporation and
 * others. All Rights Reserved.
 *******************************************************************************
 */

package android.icu.text;

import java.util.Locale;
import android.icu.util.ULocale.Category;
import android.icu.util.Currency;

/**
 * <strong>[icu enhancement]</strong> ICU's replacement for {@link java.text.DecimalFormatSymbols}.&nbsp;Methods, fields, and other functionality specific to ICU are labeled '<strong>[icu]</strong>'.
 *
 * This class represents the set of symbols (such as the decimal separator, the grouping
 * separator, and so on) needed by <code>DecimalFormat</code> to format
 * numbers. <code>DecimalFormat</code> creates for itself an instance of
 * <code>DecimalFormatSymbols</code> from its locale data.  If you need to change any of
 * these symbols, you can get the <code>DecimalFormatSymbols</code> object from your
 * <code>DecimalFormat</code> and modify it.
 *
 * @see          java.util.Locale
 * @see          android.icu.text.DecimalFormat
 * @author       Mark Davis
 * @author       Alan Liu
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DecimalFormatSymbols implements java.lang.Cloneable, java.io.Serializable {

/**
 * Creates a DecimalFormatSymbols object for the default <code>FORMAT</code> locale.
 * @see android.icu.util.ULocale.Category#FORMAT
 * @apiSince 24
 */

public DecimalFormatSymbols() { throw new RuntimeException("Stub!"); }

/**
 * Creates a DecimalFormatSymbols object for the given locale.
 * @param locale the locale
 * @apiSince 24
 */

public DecimalFormatSymbols(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Creates a DecimalFormatSymbols object for the given locale.
 * @param locale the locale
 * @apiSince 24
 */

public DecimalFormatSymbols(android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a DecimalFormatSymbols instance for the default locale.
 *
 * <p><strong>Note:</strong> Unlike
 * <code>java.text.DecimalFormatSymbols#getInstance</code>, this method simply returns
 * <code>new android.icu.text.DecimalFormatSymbols()</code>.  ICU currently does not
 * support <code>DecimalFormatSymbolsProvider</code>, which was introduced in Java 6.
 *
 * @return A DecimalFormatSymbols instance.
 * @apiSince 24
 */

public static android.icu.text.DecimalFormatSymbols getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a DecimalFormatSymbols instance for the given locale.
 *
 * <p><strong>Note:</strong> Unlike
 * <code>java.text.DecimalFormatSymbols#getInstance</code>, this method simply returns
 * <code>new android.icu.text.DecimalFormatSymbols(locale)</code>.  ICU currently does
 * not support <code>DecimalFormatSymbolsProvider</code>, which was introduced in Java
 * 6.
 *
 * @param locale the locale.
 * @return A DecimalFormatSymbols instance.
 * @apiSince 24
 */

public static android.icu.text.DecimalFormatSymbols getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a DecimalFormatSymbols instance for the given locale.
 *
 * <p><strong>Note:</strong> Unlike
 * <code>java.text.DecimalFormatSymbols#getInstance</code>, this method simply returns
 * <code>new android.icu.text.DecimalFormatSymbols(locale)</code>.  ICU currently does
 * not support <code>DecimalFormatSymbolsProvider</code>, which was introduced in Java
 * 6.
 *
 * @param locale the locale.
 * @return A DecimalFormatSymbols instance.
 * @apiSince 24
 */

public static android.icu.text.DecimalFormatSymbols getInstance(android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns a DecimalFormatSymbols instance for the given locale with digits and symbols
 * corresponding to the given {@link android.icu.text.NumberingSystem NumberingSystem}.
 *
 * <p>This method behaves equivalently to {@link #getInstance} called with a locale having a
 * "numbers=xxxx" keyword specifying the numbering system by name.
 *
 * <p>In this method, the NumberingSystem argument will be used even if the locale has its own
 * "numbers=xxxx" keyword.
 *
 * @param locale the locale.
 * @param ns the numbering system.
 * @return A DecimalFormatSymbols instance.
 * @apiSince 29
 */

public static android.icu.text.DecimalFormatSymbols forNumberingSystem(java.util.Locale locale, android.icu.text.NumberingSystem ns) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns a DecimalFormatSymbols instance for the given locale with digits and symbols
 * corresponding to the given {@link android.icu.text.NumberingSystem NumberingSystem}.
 *
 * <p>This method behaves equivalently to {@link #getInstance} called with a locale having a
 * "numbers=xxxx" keyword specifying the numbering system by name.
 *
 * <p>In this method, the NumberingSystem argument will be used even if the locale has its own
 * "numbers=xxxx" keyword.
 *
 * @param locale the locale.
 * @param ns the numbering system.
 * @return A DecimalFormatSymbols instance.
 * @apiSince 29
 */

public static android.icu.text.DecimalFormatSymbols forNumberingSystem(android.icu.util.ULocale locale, android.icu.text.NumberingSystem ns) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all locales for which the <code>getInstance</code> methods of
 * this class can return localized instances.
 *
 * <p><strong>Note:</strong> Unlike
 * <code>java.text.DecimalFormatSymbols#getAvailableLocales</code>, this method simply
 * returns the array of <code>Locale</code>s available for this class.  ICU currently
 * does not support <code>DecimalFormatSymbolsProvider</code>, which was introduced in
 * Java 6.
 *
 * @return An array of <code>Locale</code>s for which localized
 * <code>DecimalFormatSymbols</code> instances are available.
 * @apiSince 24
 */

public static java.util.Locale[] getAvailableLocales() { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used for zero. Different for Arabic, etc.
 * @return the character
 * @apiSince 24
 */

public char getZeroDigit() { throw new RuntimeException("Stub!"); }

/**
 * Returns the array of characters used as digits, in order from 0 through 9
 * @return The array
 * @apiSince 24
 */

public char[] getDigits() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for zero.
 * <p>
 * <b>Note:</b> This method propagates digit 1 to
 * digit 9 by incrementing code point one by one.
 *
 * @param zeroDigit the zero character.
 * @apiSince 24
 */

public void setZeroDigit(char zeroDigit) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the array of strings used as digits, in order from 0 through 9
 * @return The array of ten digit strings
 * @see #setDigitStrings(String[])
 * @apiSince 28
 */

public java.lang.String[] getDigitStrings() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the array of strings used as digits, in order from 0 through 9
 * <p>
 * <b>Note:</b>
 * <p>
 * When the input array of digit strings contains any strings
 * represented by multiple Java chars, then {@link #getDigits()} will return
 * the default digits ('0' - '9') and {@link #getZeroDigit()} will return the
 * default zero digit ('0').
 *
 * @param digitStrings The array of digit strings. The length of the array must be exactly 10.
 * @throws java.lang.NullPointerException if the <code>digitStrings</code> is null.
 * @throws java.lang.IllegalArgumentException if the length of the array is not 10.
 * @see #getDigitStrings()
 * @apiSince 28
 */

public void setDigitStrings(java.lang.String[] digitStrings) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used to represent a significant digit in a pattern.
 * @return the significant digit pattern character
 * @apiSince 24
 */

public char getSignificantDigit() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used to represent a significant digit in a pattern.
 * @param sigDigit the significant digit pattern character
 * @apiSince 24
 */

public void setSignificantDigit(char sigDigit) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used for grouping separator. Different for French, etc.
 * @return the thousands character
 * @apiSince 24
 */

public char getGroupingSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for grouping separator. Different for French, etc.
 * @param groupingSeparator the thousands character
 * @apiSince 24
 */

public void setGroupingSeparator(char groupingSeparator) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the string used for grouping separator. Different for French, etc.
 * @return the grouping separator string
 * @see #setGroupingSeparatorString(String)
 * @apiSince 28
 */

public java.lang.String getGroupingSeparatorString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the string used for grouping separator.
 * <p>
 * <b>Note:</b> When the input grouping separator String is represented
 * by multiple Java chars, then {@link #getGroupingSeparator()} will
 * return the default grouping separator character (',').
 *
 * @param groupingSeparatorString the grouping separator string
 * @throws java.lang.NullPointerException if <code>groupingSeparatorString</code> is null.
 * @see #getGroupingSeparatorString()
 * @apiSince 28
 */

public void setGroupingSeparatorString(java.lang.String groupingSeparatorString) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used for decimal sign. Different for French, etc.
 * @return the decimal character
 * @apiSince 24
 */

public char getDecimalSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for decimal sign. Different for French, etc.
 * @param decimalSeparator the decimal character
 * @apiSince 24
 */

public void setDecimalSeparator(char decimalSeparator) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the string used for decimal sign.
 * @return the decimal sign string
 * @see #setDecimalSeparatorString(String)
 * @apiSince 28
 */

public java.lang.String getDecimalSeparatorString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the string used for decimal sign.
 * <p>
 * <b>Note:</b> When the input decimal separator String is represented
 * by multiple Java chars, then {@link #getDecimalSeparator()} will
 * return the default decimal separator character ('.').
 *
 * @param decimalSeparatorString the decimal sign string
 * @throws java.lang.NullPointerException if <code>decimalSeparatorString</code> is null.
 * @see #getDecimalSeparatorString()
 * @apiSince 28
 */

public void setDecimalSeparatorString(java.lang.String decimalSeparatorString) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used for mille percent sign. Different for Arabic, etc.
 * @return the mille percent character
 * @apiSince 24
 */

public char getPerMill() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for mille percent sign. Different for Arabic, etc.
 * @param perMill the mille percent character
 * @apiSince 24
 */

public void setPerMill(char perMill) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the string used for permille sign.
 * @return the permille string
 * @see #setPerMillString(String)
 * @apiSince 28
 */

public java.lang.String getPerMillString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the string used for permille sign.
 * <p>
 * <b>Note:</b> When the input permille String is represented
 * by multiple Java chars, then {@link #getPerMill()} will
 * return the default permille character ('&#x2030;').
 *
 * @param perMillString the permille string
 * @throws java.lang.NullPointerException if <code>perMillString</code> is null.
 * @see #getPerMillString()
 * @apiSince 28
 */

public void setPerMillString(java.lang.String perMillString) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used for percent sign. Different for Arabic, etc.
 * @return the percent character
 * @apiSince 24
 */

public char getPercent() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for percent sign. Different for Arabic, etc.
 * @param percent the percent character
 * @apiSince 24
 */

public void setPercent(char percent) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the string used for percent sign.
 * @return the percent string
 * @see #setPercentString(String)
 * @apiSince 28
 */

public java.lang.String getPercentString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the string used for percent sign.
 * <p>
 * <b>Note:</b> When the input grouping separator String is represented
 * by multiple Java chars, then {@link #getPercent()} will
 * return the default percent sign character ('%').
 *
 * @param percentString the percent string
 * @throws java.lang.NullPointerException if <code>percentString</code> is null.
 * @see #getPercentString()
 * @apiSince 28
 */

public void setPercentString(java.lang.String percentString) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used for a digit in a pattern.
 * @return the digit pattern character
 * @apiSince 24
 */

public char getDigit() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used for a digit in a pattern.
 * @param digit the digit pattern character
 * @apiSince 24
 */

public void setDigit(char digit) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used to separate positive and negative subpatterns
 * in a pattern.
 * @return the pattern separator character
 * @apiSince 24
 */

public char getPatternSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used to separate positive and negative subpatterns
 * in a pattern.
 * @param patternSeparator the pattern separator character
 * @apiSince 24
 */

public void setPatternSeparator(char patternSeparator) { throw new RuntimeException("Stub!"); }

/**
 * Returns the String used to represent infinity. Almost always left
 * unchanged.
 * @return the Infinity string
 * @apiSince 24
 */

public java.lang.String getInfinity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the String used to represent infinity. Almost always left
 * unchanged.
 * @param infinity the Infinity String
 * @apiSince 24
 */

public void setInfinity(java.lang.String infinity) { throw new RuntimeException("Stub!"); }

/**
 * Returns the String used to represent NaN. Almost always left
 * unchanged.
 * @return the NaN String
 * @apiSince 24
 */

public java.lang.String getNaN() { throw new RuntimeException("Stub!"); }

/**
 * Sets the String used to represent NaN. Almost always left
 * unchanged.
 * @param NaN the NaN String
 * @apiSince 24
 */

public void setNaN(java.lang.String NaN) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character used to represent minus sign. If no explicit
 * negative format is specified, one is formed by prefixing
 * minusSign to the positive format.
 * @return the minus sign character
 * @apiSince 24
 */

public char getMinusSign() { throw new RuntimeException("Stub!"); }

/**
 * Sets the character used to represent minus sign. If no explicit
 * negative format is specified, one is formed by prefixing
 * minusSign to the positive format.
 * @param minusSign the minus sign character
 * @apiSince 24
 */

public void setMinusSign(char minusSign) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the string used to represent minus sign.
 * @return the minus sign string
 * @see #setMinusSignString(String)
 * @apiSince 28
 */

public java.lang.String getMinusSignString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the string used to represent minus sign.
 * <p>
 * <b>Note:</b> When the input minus sign String is represented
 * by multiple Java chars, then {@link #getMinusSign()} will
 * return the default minus sign character ('-').
 *
 * @param minusSignString the minus sign string
 * @throws java.lang.NullPointerException if <code>minusSignString</code> is null.
 * @see #getGroupingSeparatorString()
 * @apiSince 28
 */

public void setMinusSignString(java.lang.String minusSignString) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the localized plus sign.
 * @return the plus sign, used in localized patterns and formatted
 * strings
 * @see #setPlusSign
 * @see #setMinusSign
 * @see #getMinusSign
 * @apiSince 24
 */

public char getPlusSign() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the localized plus sign.
 * @param plus the plus sign, used in localized patterns and formatted
 * strings
 * @see #getPlusSign
 * @see #setMinusSign
 * @see #getMinusSign
 * @apiSince 24
 */

public void setPlusSign(char plus) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the string used to represent plus sign.
 * @return the plus sign string
 * @apiSince 28
 */

public java.lang.String getPlusSignString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the localized plus sign string.
 * <p>
 * <b>Note:</b> When the input plus sign String is represented
 * by multiple Java chars, then {@link #getPlusSign()} will
 * return the default plus sign character ('+').
 *
 * @param plusSignString the plus sign string, used in localized patterns and formatted
 * strings
 * @throws java.lang.NullPointerException if <code>plusSignString</code> is null.
 * @see #getPlusSignString()
 * @apiSince 28
 */

public void setPlusSignString(java.lang.String plusSignString) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string denoting the local currency.
 * @return the local currency String.
 * @apiSince 24
 */

public java.lang.String getCurrencySymbol() { throw new RuntimeException("Stub!"); }

/**
 * Sets the string denoting the local currency.
 * @param currency the local currency String.
 * @apiSince 24
 */

public void setCurrencySymbol(java.lang.String currency) { throw new RuntimeException("Stub!"); }

/**
 * Returns the international string denoting the local currency.
 * @return the international string denoting the local currency
 * @apiSince 24
 */

public java.lang.String getInternationalCurrencySymbol() { throw new RuntimeException("Stub!"); }

/**
 * Sets the international string denoting the local currency.
 * @param currency the international string denoting the local currency.
 * @apiSince 24
 */

public void setInternationalCurrencySymbol(java.lang.String currency) { throw new RuntimeException("Stub!"); }

/**
 * Returns the currency symbol, for {@link android.icu.text.DecimalFormatSymbols#getCurrency() DecimalFormatSymbols#getCurrency()} API
 * compatibility only. ICU clients should use the Currency API directly.
 * @return the currency used, or null
 * @apiSince 24
 */

public android.icu.util.Currency getCurrency() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currency.
 *
 * <p><strong>Note:</strong> ICU does not use the DecimalFormatSymbols for the currency
 * any more.  This API is present for API compatibility only.
 *
 * <p>This also sets the currency symbol attribute to the currency's symbol
 * in the DecimalFormatSymbols' locale, and the international currency
 * symbol attribute to the currency's ISO 4217 currency code.
 *
 * @param currency the new currency to be used
 * @throws java.lang.NullPointerException if <code>currency</code> is null
 * @see #setCurrencySymbol
 * @see #setInternationalCurrencySymbol
 * @apiSince 24
 */

public void setCurrency(android.icu.util.Currency currency) { throw new RuntimeException("Stub!"); }

/**
 * Returns the monetary decimal separator.
 * @return the monetary decimal separator character
 * @apiSince 24
 */

public char getMonetaryDecimalSeparator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the monetary decimal separator.
 * @param sep the monetary decimal separator character
 * @apiSince 24
 */

public void setMonetaryDecimalSeparator(char sep) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the monetary decimal separator string.
 * @return the monetary decimal separator string
 * @see #setMonetaryDecimalSeparatorString(String)
 * @apiSince 28
 */

public java.lang.String getMonetaryDecimalSeparatorString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the monetary decimal separator string.
 * <p>
 * <b>Note:</b> When the input monetary decimal separator String is represented
 * by multiple Java chars, then {@link #getMonetaryDecimalSeparatorString()} will
 * return the default monetary decimal separator character ('.').
 *
 * @param sep the monetary decimal separator string
 * @throws java.lang.NullPointerException if <code>sep</code> is null.
 * @see #getMonetaryDecimalSeparatorString()
 * @apiSince 28
 */

public void setMonetaryDecimalSeparatorString(java.lang.String sep) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the monetary grouping separator.
 * @return the monetary grouping separator character
 * @apiSince 24
 */

public char getMonetaryGroupingSeparator() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the monetary grouping separator.
 * @param sep the monetary grouping separator character
 * @apiSince 24
 */

public void setMonetaryGroupingSeparator(char sep) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the monetary grouping separator.
 * @return the monetary grouping separator string
 * @see #setMonetaryGroupingSeparatorString(String)
 * @apiSince 28
 */

public java.lang.String getMonetaryGroupingSeparatorString() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the monetary grouping separator string.
 * <p>
 * <b>Note:</b> When the input grouping separator String is represented
 * by multiple Java chars, then {@link #getMonetaryGroupingSeparator()} will
 * return the default monetary grouping separator character (',').
 *
 * @param sep the monetary grouping separator string
 * @throws java.lang.NullPointerException if <code>sep</code> is null.
 * @see #getMonetaryGroupingSeparatorString()
 * @apiSince 28
 */

public void setMonetaryGroupingSeparatorString(java.lang.String sep) { throw new RuntimeException("Stub!"); }

/**
 * Returns the multiplication sign
 * @apiSince 24
 */

public java.lang.String getExponentMultiplicationSign() { throw new RuntimeException("Stub!"); }

/**
 * Sets the multiplication sign
 * @apiSince 24
 */

public void setExponentMultiplicationSign(java.lang.String exponentMultiplicationSign) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the string used to separate the mantissa from the exponent.
 * Examples: "x10^" for 1.23x10^4, "E" for 1.23E4.
 * @return the localized exponent symbol, used in localized patterns
 * and formatted strings
 * @see #setExponentSeparator
 * @apiSince 24
 */

public java.lang.String getExponentSeparator() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the string used to separate the mantissa from the exponent.
 * Examples: "x10^" for 1.23x10^4, "E" for 1.23E4.
 * @param exp the localized exponent symbol, used in localized patterns
 * and formatted strings
 * @see #getExponentSeparator
 * @apiSince 24
 */

public void setExponentSeparator(java.lang.String exp) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the character used to pad numbers out to a specified width.  This is
 * not the pad character itself; rather, it is the special pattern character
 * <em>preceding</em> the pad character.  In the pattern "*_#,##0", '*' is the pad
 * escape, and '_' is the pad character.
 * @return the character
 * @see #setPadEscape
 * @see android.icu.text.DecimalFormat#getFormatWidth
 * @see android.icu.text.DecimalFormat#getPadPosition
 * @see android.icu.text.DecimalFormat#getPadCharacter
 * @apiSince 24
 */

public char getPadEscape() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the character used to pad numbers out to a specified width.  This is not
 * the pad character itself; rather, it is the special pattern character
 * <em>preceding</em> the pad character.  In the pattern "*_#,##0", '*' is the pad
 * escape, and '_' is the pad character.
 * @see #getPadEscape
 * @see android.icu.text.DecimalFormat#setFormatWidth
 * @see android.icu.text.DecimalFormat#setPadPosition
 * @see android.icu.text.DecimalFormat#setPadCharacter
 * @apiSince 24
 */

public void setPadEscape(char c) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Returns the desired currency spacing value. Original values come from ICU's
 * CLDR data based on the locale provided during construction, and can be null.  These
 * values govern what and when text is inserted between a currency code/name/symbol
 * and the currency amount when formatting money.
 *
 * <p>For more information, see <a href="http://www.unicode.org/reports/tr35/#Currencies"
 * >UTS#35 section 5.10.2</a>.
 *
 * @param itemType one of CURRENCY_SPC_CURRENCY_MATCH, CURRENCY_SPC_SURROUNDING_MATCH
 * or CURRENCY_SPC_INSERT
 * @param beforeCurrency true to get the <code>beforeCurrency</code> values, false
 * to get the <code>afterCurrency</code> values.
 * @return the value, or null.
 * @see #setPatternForCurrencySpacing(int, boolean, String)
 * @apiSince 24
 */

public java.lang.String getPatternForCurrencySpacing(int itemType, boolean beforeCurrency) { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Sets the indicated currency spacing pattern or value. See {@link
 * #getPatternForCurrencySpacing} for more information.
 *
 * <p>Values for currency match and surrounding match must be {@link
 * android.icu.text.UnicodeSet} patterns. Values for insert can be any string.
 *
 * <p><strong>Note:</strong> ICU4J does not currently use this information.
 *
 * @param itemType one of CURRENCY_SPC_CURRENCY_MATCH, CURRENCY_SPC_SURROUNDING_MATCH
 * or CURRENCY_SPC_INSERT
 * @param beforeCurrency true if the pattern is for before the currency symbol.
 * false if the pattern is for after it.
 * @param  pattern string to override current setting; can be null.
 * @see #getPatternForCurrencySpacing(int, boolean)
 * @apiSince 24
 */

public void setPatternForCurrencySpacing(int itemType, boolean beforeCurrency, java.lang.String pattern) { throw new RuntimeException("Stub!"); }

/**
 * Returns the locale for which this object was constructed.
 * @return the locale for which this object was constructed
 * @apiSince 24
 */

public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * Returns the locale for which this object was constructed.
 * @return the locale for which this object was constructed
 * @apiSince 24
 */

public android.icu.util.ULocale getULocale() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 24
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 24
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * <strong>[icu]</strong> Indicates the currency match pattern used in {@link #getPatternForCurrencySpacing}.
 * @apiSince 24
 */

public static final int CURRENCY_SPC_CURRENCY_MATCH = 0; // 0x0

/**
 * <strong>[icu]</strong> Indicates the insertion value used in {@link #getPatternForCurrencySpacing}.
 * @apiSince 24
 */

public static final int CURRENCY_SPC_INSERT = 2; // 0x2

/**
 * <strong>[icu]</strong> Indicates the surrounding match pattern used in {@link
 * #getPatternForCurrencySpacing}.
 * @apiSince 24
 */

public static final int CURRENCY_SPC_SURROUNDING_MATCH = 1; // 0x1
}

