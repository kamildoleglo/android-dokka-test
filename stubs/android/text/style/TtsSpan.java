/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.text.style;


/**
 * A span that supplies additional meta-data for the associated text intended
 * for text-to-speech engines. If the text is being processed by a
 * text-to-speech engine, the engine may use the data in this span in addition
 * to or instead of its associated text.
 *
 * Each instance of a TtsSpan has a type, for example {@link #TYPE_DATE}
 * or {@link #TYPE_MEASURE}. And a list of arguments, provided as
 * key-value pairs in a bundle.
 *
 * The inner classes are there for convenience and provide builders for each
 * TtsSpan type.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TtsSpan implements android.text.ParcelableSpan {

/** @apiSince 21 */

public TtsSpan(java.lang.String type, android.os.PersistableBundle args) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TtsSpan(android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type.
 * @return The type of this instance.
 * @apiSince 21
 */

public java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bundle of the arguments set.
 * @return The bundle of the arguments set.
 * @apiSince 21
 */

public android.os.PersistableBundle getArgs() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public static final java.lang.String ANIMACY_ANIMATE = "android.animate";

/** @apiSince 21 */

public static final java.lang.String ANIMACY_INANIMATE = "android.inanimate";

/**
 * String argument supplying animacy information. Can be
 * {@link #ANIMACY_ANIMATE} or
 * {@link #ANIMACY_INANIMATE}
 * @apiSince 21
 */

public static final java.lang.String ARG_ANIMACY = "android.arg.animacy";

/**
 * String argument supplying case information. Can be any of
 * {@link #CASE_NOMINATIVE}, {@link #CASE_ACCUSATIVE}, {@link #CASE_DATIVE},
 * {@link #CASE_ABLATIVE}, {@link #CASE_GENITIVE}, {@link #CASE_VOCATIVE},
 * {@link #CASE_LOCATIVE} and {@link #CASE_INSTRUMENTAL}
 * @apiSince 21
 */

public static final java.lang.String ARG_CASE = "android.arg.case";

/**
 * Argument used to specify the country code of a telephone number. Can be
 * a string of digits optionally prefixed with a "+".
 * Can be used with {@link #TYPE_TELEPHONE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_COUNTRY_CODE = "android.arg.country_code";

/**
 * Argument used to specify the currency. Should be a ISO4217 currency code,
 * e.g. "USD".
 * Can be used with {@link #TYPE_MONEY}.
 * @apiSince 21
 */

public static final java.lang.String ARG_CURRENCY = "android.arg.money";

/**
 * Argument used to specify the day of the month of a date. The value should
 * be provided as an integer in the range from 1 up to and including 31.
 * Can be used with {@link #TYPE_DATE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_DAY = "android.arg.day";

/**
 * Argument used to specify the denominator of a fraction. The value can be
 * a string of digits of any size optionally prefixed with a + or -.
 * Can be used with {@link #TYPE_FRACTION}.
 * @apiSince 21
 */

public static final java.lang.String ARG_DENOMINATOR = "android.arg.denominator";

/**
 * Argument used to specify a string of digits.
 * Can be used with {@link #TYPE_DIGITS}.
 * @apiSince 21
 */

public static final java.lang.String ARG_DIGITS = "android.arg.digits";

/**
 * Argument used to specify the domain part of a URI. For example
 * "source.android.com".
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_DOMAIN = "android.arg.domain";

/**
 * Argument used to specify the extension part of a telephone number. Can be
 * a string of digits.
 * Can be used with {@link #TYPE_TELEPHONE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_EXTENSION = "android.arg.extension";

/**
 * Argument used to specify the fractional part of a decimal. The value can
 * be a string of digits of any size.
 * Can be used with {@link #TYPE_DECIMAL}.
 * @apiSince 21
 */

public static final java.lang.String ARG_FRACTIONAL_PART = "android.arg.fractional_part";

/**
 * Argument used to specify the fragment id of a URI. Should be specified as
 * a string.
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_FRAGMENT_ID = "android.arg.fragment_id";

/**
 * String argument supplying gender information. Can be any of
 * {@link #GENDER_NEUTRAL}, {@link #GENDER_MALE} and
 * {@link #GENDER_FEMALE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_GENDER = "android.arg.gender";

/**
 * Argument used to specify the hours of a time. The hours should be
 * provided as an integer in the range from 0 up to and including 24.
 * Can be used with {@link #TYPE_TIME}.
 * @apiSince 21
 */

public static final java.lang.String ARG_HOURS = "android.arg.hours";

/**
 * Argument used to specify the integer part of a decimal or fraction. The
 * value can be a string of digits of any size optionally prefixed with
 * a - or +.
 * Can be used with {@link #TYPE_DECIMAL} and {@link #TYPE_FRACTION}.
 * @apiSince 21
 */

public static final java.lang.String ARG_INTEGER_PART = "android.arg.integer_part";

/**
 * Argument used to specify the minutes of a time. The hours should be
 * provided as an integer in the range from 0 up to and including 59.
 * Can be used with {@link #TYPE_TIME}.
 * @apiSince 21
 */

public static final java.lang.String ARG_MINUTES = "android.arg.minutes";

/**
 * Argument used to specify the month of a date. The value should be
 * provided as an integer and can be any of {@link #MONTH_JANUARY},
 * {@link #MONTH_FEBRUARY},  {@link #MONTH_MARCH}, {@link #MONTH_APRIL},
 * {@link #MONTH_MAY}, {@link #MONTH_JUNE}, {@link #MONTH_JULY},
 * {@link #MONTH_AUGUST}, {@link #MONTH_SEPTEMBER}, {@link #MONTH_OCTOBER},
 * {@link #MONTH_NOVEMBER} and {@link #MONTH_DECEMBER}.
 * Can be used with {@link #TYPE_DATE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_MONTH = "android.arg.month";

/**
 * String argument supplying multiplicity information. Can be any of
 * {@link #MULTIPLICITY_SINGLE}, {@link #MULTIPLICITY_DUAL} and
 * {@link #MULTIPLICITY_PLURAL}
 * @apiSince 21
 */

public static final java.lang.String ARG_MULTIPLICITY = "android.arg.multiplicity";

/**
 * Argument used to specify a whole number. The value can be a string of
 * digits of any size optionally prefixed with a - or +.
 * Can be used with {@link #TYPE_CARDINAL} and {@link #TYPE_ORDINAL}.
 * @apiSince 21
 */

public static final java.lang.String ARG_NUMBER = "android.arg.number";

/**
 * Argument used to specify the main number part of a telephone number. Can
 * be a string of digits where the different parts of the telephone number
 * can be separated with a space, '-', '/' or '.'.
 * Can be used with {@link #TYPE_TELEPHONE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_NUMBER_PARTS = "android.arg.number_parts";

/**
 * Argument used to specify the numerator of a fraction. The value can be a
 * string of digits of any size optionally prefixed with a - or +.
 * Can be used with {@link #TYPE_FRACTION}.
 * @apiSince 21
 */

public static final java.lang.String ARG_NUMERATOR = "android.arg.numerator";

/**
 * Argument used to specify the password part of a URI. Should be set as a
 * string.
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_PASSWORD = "android.arg.password";

/**
 * Argument used to specify the path part of a URI. For example
 * "source/index.html".
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_PATH = "android.arg.path";

/**
 * Argument used to specify the port number of a URI. Should be specified as
 * an integer.
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_PORT = "android.arg.port";

/**
 * Argument used to specify the protocol of a URI. Examples are "http" and
 * "ftp".
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_PROTOCOL = "android.arg.protocol";

/**
 * Argument used to choose the suffix (thousand, million, etc) that is used
 * to pronounce large amounts of money. For example it can be used to
 * disambiguate between "two thousand five hundred dollars" and
 * "two point five thousand dollars".
 * If implemented, engines should support at least "1000", "1000000",
 * "1000000000" and "1000000000000".
 * Example: if the {@link #ARG_INTEGER_PART} argument is "10", the
 * {@link #ARG_FRACTIONAL_PART} argument is "4", the {@link #ARG_QUANTITY}
 * argument is "1000" and the {@link #ARG_CURRENCY} argument is "usd", the
 * TTS engine may pronounce the span as "ten point four thousand dollars".
 * With the same example but with the quantity set as "1000000" the TTS
 * engine may pronounce the span as "ten point four million dollars".
 * Can be used with {@link #TYPE_MONEY}.
 * @apiSince 21
 */

public static final java.lang.String ARG_QUANTITY = "android.arg.quantity";

/**
 * Argument used to specify the query string of a URI. For example
 * "arg=value&argtwo=value".
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_QUERY_STRING = "android.arg.query_string";

/**
 * String supplying the text to be synthesized. The synthesizer is free
 * to decide how to interpret the text.
 * Can be used with {@link #TYPE_TEXT}.
 * @apiSince 21
 */

public static final java.lang.String ARG_TEXT = "android.arg.text";

/**
 * Argument used to specify the unit of a measure. The unit should always be
 * specified in English singular form. Prefixes may be used. Engines will do
 * their best to pronounce them correctly in the language used. Engines are
 * expected to at least support the most common ones like "meter", "second",
 * "degree celsius" and "degree fahrenheit" with some common prefixes like
 * "milli" and "kilo".
 * Can be used with {@link #TYPE_MEASURE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_UNIT = "android.arg.unit";

/**
 * Argument used to specify the username part of a URI. Should be set as a
 * string.
 * Can be used with {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public static final java.lang.String ARG_USERNAME = "android.arg.username";

/**
 * Argument used to specify a string where the characters are read verbatim,
 * except whitespace.
 * Can be used with {@link #TYPE_VERBATIM}.
 * @apiSince 21
 */

public static final java.lang.String ARG_VERBATIM = "android.arg.verbatim";

/**
 * Argument used to specify the weekday of a date. The value should be
 * provided as an integer and can be any of {@link #WEEKDAY_SUNDAY},
 * {@link #WEEKDAY_MONDAY}, {@link #WEEKDAY_TUESDAY},
 * {@link #WEEKDAY_WEDNESDAY}, {@link #WEEKDAY_THURSDAY},
 * {@link #WEEKDAY_FRIDAY} and {@link #WEEKDAY_SATURDAY}.
 * Can be used with {@link #TYPE_DATE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_WEEKDAY = "android.arg.weekday";

/**
 * Argument used to specify the year of a date. The value should be provided
 * as a positive integer.
 * Can be used with {@link #TYPE_DATE}.
 * @apiSince 21
 */

public static final java.lang.String ARG_YEAR = "android.arg.year";

/** @apiSince 21 */

public static final java.lang.String CASE_ABLATIVE = "android.ablative";

/** @apiSince 21 */

public static final java.lang.String CASE_ACCUSATIVE = "android.accusative";

/** @apiSince 21 */

public static final java.lang.String CASE_DATIVE = "android.dative";

/** @apiSince 21 */

public static final java.lang.String CASE_GENITIVE = "android.genitive";

/** @apiSince 21 */

public static final java.lang.String CASE_INSTRUMENTAL = "android.instrumental";

/** @apiSince 21 */

public static final java.lang.String CASE_LOCATIVE = "android.locative";

/** @apiSince 21 */

public static final java.lang.String CASE_NOMINATIVE = "android.nominative";

/** @apiSince 21 */

public static final java.lang.String CASE_VOCATIVE = "android.vocative";

/** @apiSince 21 */

public static final java.lang.String GENDER_FEMALE = "android.female";

/** @apiSince 21 */

public static final java.lang.String GENDER_MALE = "android.male";

/** @apiSince 21 */

public static final java.lang.String GENDER_NEUTRAL = "android.neutral";

/** @apiSince 21 */

public static final int MONTH_APRIL = 3; // 0x3

/** @apiSince 21 */

public static final int MONTH_AUGUST = 7; // 0x7

/** @apiSince 21 */

public static final int MONTH_DECEMBER = 11; // 0xb

/** @apiSince 21 */

public static final int MONTH_FEBRUARY = 1; // 0x1

/** @apiSince 21 */

public static final int MONTH_JANUARY = 0; // 0x0

/** @apiSince 21 */

public static final int MONTH_JULY = 6; // 0x6

/** @apiSince 21 */

public static final int MONTH_JUNE = 5; // 0x5

/** @apiSince 21 */

public static final int MONTH_MARCH = 2; // 0x2

/** @apiSince 21 */

public static final int MONTH_MAY = 4; // 0x4

/** @apiSince 21 */

public static final int MONTH_NOVEMBER = 10; // 0xa

/** @apiSince 21 */

public static final int MONTH_OCTOBER = 9; // 0x9

/** @apiSince 21 */

public static final int MONTH_SEPTEMBER = 8; // 0x8

/** @apiSince 21 */

public static final java.lang.String MULTIPLICITY_DUAL = "android.dual";

/** @apiSince 21 */

public static final java.lang.String MULTIPLICITY_PLURAL = "android.plural";

/** @apiSince 21 */

public static final java.lang.String MULTIPLICITY_SINGLE = "android.single";

/**
 * The text associated with this span is a cardinal. Must include the
 * number to be synthesized with {@link #ARG_NUMBER}.
 * Also accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and
 * {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_CARDINAL = "android.type.cardinal";

/**
 * The text associated with this span is a date. At least one of the
 * arguments {@link #ARG_MONTH} and {@link #ARG_YEAR} has to be provided.
 * The argument {@link #ARG_DAY} is optional if {@link #ARG_MONTH} is set.
 * The argument {@link #ARG_WEEKDAY} is optional if {@link #ARG_DAY} is set.
 * Also accepts the arguments {@link #ARG_GENDER}, {@link #ARG_ANIMACY},
 * {@link #ARG_MULTIPLICITY} and {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_DATE = "android.type.date";

/**
 * The text associated with this span is a decimal number. Must include the
 * number to be synthesized with {@link #ARG_INTEGER_PART} and
 * {@link #ARG_FRACTIONAL_PART}.
 * Also accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and
 * {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_DECIMAL = "android.type.decimal";

/**
 * The text associated with this span is a series of digits that have to be
 * read sequentially. The digits can be set with {@link #ARG_DIGITS}.
 * Also accepts the arguments {@link #ARG_GENDER}, {@link #ARG_ANIMACY},
 * {@link #ARG_MULTIPLICITY} and {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_DIGITS = "android.type.digits";

/**
 * The text associated with this span is a URI (can be used for URLs and
 * email addresses). The full schema for URLs, which email addresses can
 * effectively be seen as a subset of, is:
 * protocol://username:password@domain:port/path?query_string#fragment_id
 * Hence populating just username and domain will read as an email address.
 * All arguments are optional, but at least one has to be provided:
 * {@link #ARG_PROTOCOL}, {@link #ARG_USERNAME}, {@link #ARG_PASSWORD},
 * {@link #ARG_DOMAIN}, {@link #ARG_PORT}, {@link #ARG_PATH},
 * {@link #ARG_QUERY_STRING} and {@link #ARG_FRAGMENT_ID}.
 * Also accepts the arguments {@link #ARG_GENDER}, {@link #ARG_ANIMACY},
 * {@link #ARG_MULTIPLICITY} and {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_ELECTRONIC = "android.type.electronic";

/**
 * The text associated with this span is a fractional number. Must include
 * the number to be synthesized with {@link #ARG_NUMERATOR} and
 * {@link #ARG_DENOMINATOR}. {@link #ARG_INTEGER_PART} is optional
 * Also accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and
 * {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_FRACTION = "android.type.fraction";

/**
 * The text associated with this span is a measure, consisting of a number
 * and a unit. The number can be a cardinal, decimal or a fraction. Set the
 * number with the same arguments as {@link #TYPE_CARDINAL},
 * {@link #TYPE_DECIMAL} or {@link #TYPE_FRACTION}. The unit can be
 * specified with {@link #ARG_UNIT}.
 * Also accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and
 * {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_MEASURE = "android.type.measure";

/**
 * The text associated with this span is an amount of money. Set the amount
 * with the same arguments as {@link #TYPE_DECIMAL}.
 * {@link #ARG_CURRENCY} is used to set the currency. {@link #ARG_QUANTITY}
 * is optional.
 * Also accepts the arguments {@link #ARG_GENDER}, {@link #ARG_ANIMACY},
 * {@link #ARG_MULTIPLICITY} and {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_MONEY = "android.type.money";

/**
 * The text associated with this span is an ordinal. Must include the
 * number to be synthesized with {@link #ARG_NUMBER}.
 * Also accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and
 * {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_ORDINAL = "android.type.ordinal";

/**
 * The text associated with this span is a telephone number. The argument
 * {@link #ARG_NUMBER_PARTS} is required. {@link #ARG_COUNTRY_CODE} and
 * {@link #ARG_EXTENSION} are optional.
 * Also accepts the arguments {@link #ARG_GENDER}, {@link #ARG_ANIMACY},
 * {@link #ARG_MULTIPLICITY} and {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_TELEPHONE = "android.type.telephone";

/**
 * This span type can be used to add morphosyntactic features to the text it
 * spans over, or synthesize a something else than the spanned text. Use
 * the argument {@link #ARG_TEXT} to set a different text.
 * Accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and
 * {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_TEXT = "android.type.text";

/**
 * The text associated with this span is a time, consisting of a number of
 * hours and minutes, specified with {@link #ARG_HOURS} and
 * {@link #ARG_MINUTES}.
 * Also accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and
 * {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_TIME = "android.type.time";

/**
 * The text associated with this span is a series of characters that have to
 * be read verbatim. The engine will attempt to read out any character like
 * punctuation but excluding whitespace. {@link #ARG_VERBATIM} is required.
 * Also accepts the arguments {@link #ARG_GENDER},
 * {@link #ARG_ANIMACY}, {@link #ARG_MULTIPLICITY} and {@link #ARG_CASE}.
 * @apiSince 21
 */

public static final java.lang.String TYPE_VERBATIM = "android.type.verbatim";

/** @apiSince 21 */

public static final int WEEKDAY_FRIDAY = 6; // 0x6

/** @apiSince 21 */

public static final int WEEKDAY_MONDAY = 2; // 0x2

/** @apiSince 21 */

public static final int WEEKDAY_SATURDAY = 7; // 0x7

/** @apiSince 21 */

public static final int WEEKDAY_SUNDAY = 1; // 0x1

/** @apiSince 21 */

public static final int WEEKDAY_THURSDAY = 5; // 0x5

/** @apiSince 21 */

public static final int WEEKDAY_TUESDAY = 3; // 0x3

/** @apiSince 21 */

public static final int WEEKDAY_WEDNESDAY = 4; // 0x4
/**
 * A simple builder for TtsSpans.
 * This builder can be used directly, but the more specific subclasses of
 * this builder like {@link android.text.style.TtsSpan.TextBuilder TtsSpan.TextBuilder} and
 * {@link android.text.style.TtsSpan.CardinalBuilder TtsSpan.CardinalBuilder} are likely more useful.
 *
 * This class uses generics so methods from this class can return instances
 * of its child classes, resulting in a fluent API (CRTP pattern).
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder<C extends android.text.style.TtsSpan.Builder<?>> {

/** @apiSince 21 */

public Builder(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a TtsSpan built from the parameters set by the setter
 * methods.
 * @return A TtsSpan built with parameters of this builder.
 * @apiSince 21
 */

public android.text.style.TtsSpan build() { throw new RuntimeException("Stub!"); }

/**
 * Sets an argument to a string value.
 * @param arg The argument name.
 * @param value The value the argument should be set to.
 * @return This instance.
 * @apiSince 21
 */

public C setStringArgument(java.lang.String arg, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Sets an argument to an int value.
 * @param arg The argument name.
 * @param value The value the argument should be set to.
 * @apiSince 21
 */

public C setIntArgument(java.lang.String arg, int value) { throw new RuntimeException("Stub!"); }

/**
 * Sets an argument to a long value.
 * @param arg The argument name.
 * @param value The value the argument should be set to.
 * @apiSince 21
 */

public C setLongArgument(java.lang.String arg, long value) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_CARDINAL}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CardinalBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.CardinalBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_CARDINAL}.
 * @apiSince 21
 */

public CardinalBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_CARDINAL} and sets the
 * {@link #ARG_NUMBER} argument.
 * @param number The number to synthesize.
 * @see #setNumber(long)
 * @apiSince 21
 */

public CardinalBuilder(long number) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_CARDINAL} and sets the
 * {@link #ARG_NUMBER} argument.
 * @param number The number to synthesize.
 * @see #setNumber(String)
 * @apiSince 21
 */

public CardinalBuilder(java.lang.String number) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the number to a String and set it to
 * the value for {@link #ARG_NUMBER}.
 * @param number The number that will be synthesized.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.CardinalBuilder setNumber(long number) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_NUMBER} argument.
 * @param number A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.CardinalBuilder setNumber(java.lang.String number) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_DATE}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DateBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.DateBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_DATE}.
 * @apiSince 21
 */

public DateBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_TIME} and
 * possibly sets the {@link #ARG_WEEKDAY}, {@link #ARG_DAY},
 * {@link #ARG_MONTH} and {@link #ARG_YEAR} arguments. Pass null to any
 * argument to leave it unset.
 * @apiSince 21
 */

public DateBuilder(java.lang.Integer weekday, java.lang.Integer day, java.lang.Integer month, java.lang.Integer year) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_WEEKDAY} argument.
 * @param weekday The value to be set for weekday. See
 *     {@link #ARG_WEEKDAY}.
 * @return This instance.
 * @see #ARG_WEEKDAY
 * @apiSince 21
 */

public android.text.style.TtsSpan.DateBuilder setWeekday(int weekday) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_DAY} argument.
 * @param day The value to be set for day. See {@link #ARG_DAY}.
 * @return This instance.
 * @see #ARG_DAY
 * @apiSince 21
 */

public android.text.style.TtsSpan.DateBuilder setDay(int day) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_MONTH} argument.
 * @param month The value to be set for month. See {@link #ARG_MONTH}.
 * @return This instance.
 * @see #ARG_MONTH
 * @apiSince 21
 */

public android.text.style.TtsSpan.DateBuilder setMonth(int month) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_YEAR} argument.
 * @param year The value to be set for year. See {@link #ARG_YEAR}.
 * @return This instance.
 * @see #ARG_YEAR
 * @apiSince 21
 */

public android.text.style.TtsSpan.DateBuilder setYear(int year) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_DECIMAL}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DecimalBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.DecimalBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_DECIMAL}.
 * @apiSince 21
 */

public DecimalBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_DECIMAL} and sets the
 * {@link #ARG_INTEGER_PART} and {@link #ARG_FRACTIONAL_PART} arguments.
 * @see #setArgumentsFromDouble(double, int, int)
 * @apiSince 21
 */

public DecimalBuilder(double number, int minimumFractionDigits, int maximumFractionDigits) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_DECIMAL} and sets the
 * {@link #ARG_INTEGER_PART} and {@link #ARG_FRACTIONAL_PART} arguments.
 * @apiSince 21
 */

public DecimalBuilder(java.lang.String integerPart, java.lang.String fractionalPart) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Convenience method takes a double and a maximum number of fractional
 * digits, it sets the {@link #ARG_INTEGER_PART} and
 * {@link #ARG_FRACTIONAL_PART} arguments.
 * @param number The number to be synthesized.
 * @param minimumFractionDigits The minimum number of fraction digits
 *     that are pronounced.
 * @param maximumFractionDigits The maximum number of fraction digits
 *     that are pronounced. If maximumFractionDigits <
 *     minimumFractionDigits then minimumFractionDigits will be assumed
 *     to be equal to maximumFractionDigits.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.DecimalBuilder setArgumentsFromDouble(double number, int minimumFractionDigits, int maximumFractionDigits) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the number to a String and sets it
 * to the value for {@link #ARG_INTEGER_PART}.
 * @param integerPart The integer part of the decimal.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.DecimalBuilder setIntegerPart(long integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_INTEGER_PART} argument.
 * @param integerPart A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.DecimalBuilder setIntegerPart(java.lang.String integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_FRACTIONAL_PART} argument.
 * @param fractionalPart A non-empty string of digits.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.DecimalBuilder setFractionalPart(java.lang.String fractionalPart) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_DIGITS}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DigitsBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.DigitsBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_DIGITS}.
 * @apiSince 21
 */

public DigitsBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_DIGITS}
 * and sets the {@link #ARG_DIGITS} argument.
 * @apiSince 21
 */

public DigitsBuilder(java.lang.String digits) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_DIGITS} argument.
 * @param digits A string of digits.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.DigitsBuilder setDigits(java.lang.String digits) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ElectronicBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.ElectronicBuilder> {

/**
 * Creates a TtsSpan of type {@link #TYPE_ELECTRONIC}.
 * @apiSince 21
 */

public ElectronicBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_USERNAME} and {@link #ARG_DOMAIN}
 *     arguments, representing an email address.
 * @param username The part before the @ in the email address.
 * @param domain The part after the @ in the email address.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setEmailArguments(java.lang.String username, java.lang.String domain) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_PROTOCOL} argument.
 * @param protocol The protocol of the URI. Examples are "http" and
 *     "ftp".
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setProtocol(java.lang.String protocol) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_USERNAME} argument.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setUsername(java.lang.String username) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_PASSWORD} argument.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setPassword(java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_DOMAIN} argument.
 * @param domain The domain, for example "source.android.com".
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setDomain(java.lang.String domain) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_PORT} argument.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setPort(int port) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_PATH} argument.
 * @param path For example "source/index.html".
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setPath(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_QUERY_STRING} argument.
 * @param queryString For example "arg=value&argtwo=value".
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setQueryString(java.lang.String queryString) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_FRAGMENT_ID} argument.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.ElectronicBuilder setFragmentId(java.lang.String fragmentId) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_FRACTION}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FractionBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.FractionBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_FRACTION}.
 * @apiSince 21
 */

public FractionBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_FRACTION} and sets the
 * {@link #ARG_INTEGER_PART}, {@link #ARG_NUMERATOR}, and
 * {@link #ARG_DENOMINATOR} arguments.
 * @apiSince 21
 */

public FractionBuilder(long integerPart, long numerator, long denominator) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the integer to a String and sets the
 * argument {@link #ARG_NUMBER}.
 * @param integerPart The integer part.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.FractionBuilder setIntegerPart(long integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_INTEGER_PART} argument.
 * @param integerPart A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.FractionBuilder setIntegerPart(java.lang.String integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the numerator to a String and sets
 * the argument {@link #ARG_NUMERATOR}.
 * @param numerator The numerator.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.FractionBuilder setNumerator(long numerator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_NUMERATOR} argument.
 * @param numerator A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.FractionBuilder setNumerator(java.lang.String numerator) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the denominator to a String and sets
 * the argument {@link #ARG_DENOMINATOR}.
 * @param denominator The denominator.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.FractionBuilder setDenominator(long denominator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_DENOMINATOR} argument.
 * @param denominator A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.FractionBuilder setDenominator(java.lang.String denominator) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_MEASURE}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MeasureBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.MeasureBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_MEASURE}.
 * @apiSince 21
 */

public MeasureBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the number to a String and set it to
 * the value for {@link #ARG_NUMBER}.
 * @param number The amount of the measure.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setNumber(long number) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_NUMBER} argument.
 * @param number A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setNumber(java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the integer part to a String and set
 * it to the value for {@link #ARG_INTEGER_PART}.
 * @param integerPart The integer part of a decimal or fraction.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setIntegerPart(long integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_INTEGER_PART} argument.
 * @param integerPart The integer part of a decimal or fraction; a
 * non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setIntegerPart(java.lang.String integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_FRACTIONAL_PART} argument.
 * @param fractionalPart The fractional part of a decimal; a non-empty
 *     string of digits with an optional leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setFractionalPart(java.lang.String fractionalPart) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the numerator to a String and set it
 * to the value for {@link #ARG_NUMERATOR}.
 * @param numerator The numerator of a fraction.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setNumerator(long numerator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_NUMERATOR} argument.
 * @param numerator The numerator of a fraction; a non-empty string of
 *     digits with an optional leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setNumerator(java.lang.String numerator) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the denominator to a String and set
 * it to the value for {@link #ARG_DENOMINATOR}.
 * @param denominator The denominator of a fraction.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setDenominator(long denominator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_DENOMINATOR} argument.
 * @param denominator The denominator of a fraction; a non-empty string
 *     of digits with an optional leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setDenominator(java.lang.String denominator) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_UNIT} argument.
 * @param unit The unit of the measure.
 * @return This instance.
 * @see android.text.style.TtsSpan#ARG_UNIT
 * @apiSince 21
 */

public android.text.style.TtsSpan.MeasureBuilder setUnit(java.lang.String unit) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_MONEY}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MoneyBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.MoneyBuilder> {

/**
 * Creates a TtsSpan of type {@link #TYPE_MONEY}.
 * @apiSince 21
 */

public MoneyBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the number to a String and set it to
 * the value for {@link #ARG_INTEGER_PART}.
 * @param integerPart The integer part of the amount.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MoneyBuilder setIntegerPart(long integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_INTEGER_PART} argument.
 * @param integerPart A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MoneyBuilder setIntegerPart(java.lang.String integerPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_FRACTIONAL_PART} argument.
 * @param fractionalPart Can be a string of digits of any size.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MoneyBuilder setFractionalPart(java.lang.String fractionalPart) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_CURRENCY} argument.
 * @param currency Should be a ISO4217 currency code, e.g. "USD".
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MoneyBuilder setCurrency(java.lang.String currency) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_QUANTITY} argument.
 * @param quantity
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.MoneyBuilder setQuantity(java.lang.String quantity) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_ORDINAL}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class OrdinalBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.OrdinalBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_ORDINAL}.
 * @apiSince 21
 */

public OrdinalBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_ORDINAL} and sets the
 * {@link #ARG_NUMBER} argument.
 * @param number The ordinal number to synthesize.
 * @see #setNumber(long)
 * @apiSince 21
 */

public OrdinalBuilder(long number) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_ORDINAL} and sets the
 * {@link #ARG_NUMBER} argument.
 * @param number The number to synthesize.
 * @see #setNumber(String)
 * @apiSince 21
 */

public OrdinalBuilder(java.lang.String number) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Convenience method that converts the number to a String and sets it
 * to the value for {@link #ARG_NUMBER}.
 * @param number The ordinal number that will be synthesized.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.OrdinalBuilder setNumber(long number) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_NUMBER} argument.
 * @param number A non-empty string of digits with an optional
 *     leading + or -.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.OrdinalBuilder setNumber(java.lang.String number) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans, has setters for morphosyntactic features.
 * This builder can be used directly, but the more specific subclasses of
 * this builder like {@link android.text.style.TtsSpan.TextBuilder TtsSpan.TextBuilder} and
 * {@link android.text.style.TtsSpan.CardinalBuilder TtsSpan.CardinalBuilder} are likely more useful.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SemioticClassBuilder<C extends android.text.style.TtsSpan.SemioticClassBuilder<?>> extends android.text.style.TtsSpan.Builder<C> {

/** @apiSince 21 */

public SemioticClassBuilder(java.lang.String type) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the gender information for this instance.
 * @param gender Can any of {@link #GENDER_NEUTRAL},
 *     {@link #GENDER_MALE} and {@link #GENDER_FEMALE}.
 * @return This instance.
 * @apiSince 21
 */

public C setGender(java.lang.String gender) { throw new RuntimeException("Stub!"); }

/**
 * Sets the animacy information for this instance.
 * @param animacy Can be any of {@link #ANIMACY_ANIMATE} and
 *     {@link #ANIMACY_INANIMATE}.
 * @return This instance.
 * @apiSince 21
 */

public C setAnimacy(java.lang.String animacy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the multiplicity information for this instance.
 * @param multiplicity Can be any of
 *     {@link #MULTIPLICITY_SINGLE}, {@link #MULTIPLICITY_DUAL} and
 *     {@link #MULTIPLICITY_PLURAL}.
 * @return This instance.
 * @apiSince 21
 */

public C setMultiplicity(java.lang.String multiplicity) { throw new RuntimeException("Stub!"); }

/**
 * Sets the grammatical case information for this instance.
 * @param grammaticalCase Can be any of {@link #CASE_NOMINATIVE},
 *     {@link #CASE_ACCUSATIVE}, {@link #CASE_DATIVE},
 *     {@link #CASE_ABLATIVE}, {@link #CASE_GENITIVE},
 *     {@link #CASE_VOCATIVE}, {@link #CASE_LOCATIVE} and
 *     {@link #CASE_INSTRUMENTAL}.
 * @return This instance.
 * @apiSince 21
 */

public C setCase(java.lang.String grammaticalCase) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_TELEPHONE}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TelephoneBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.TelephoneBuilder> {

/**
 * Creates a TtsSpan of type {@link #TYPE_TELEPHONE}.
 * @apiSince 21
 */

public TelephoneBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_TELEPHONE} and sets the
 * {@link #ARG_NUMBER_PARTS} argument.
 * @apiSince 21
 */

public TelephoneBuilder(java.lang.String numberParts) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_COUNTRY_CODE} argument.
 * @param countryCode The country code can be a series of digits
 * optionally prefixed with a "+".
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.TelephoneBuilder setCountryCode(java.lang.String countryCode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_NUMBER_PARTS} argument.
 * @param numberParts The main telephone number. Can be a series of
 *     digits and letters separated by spaces, "/", "-" or ".".
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.TelephoneBuilder setNumberParts(java.lang.String numberParts) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_EXTENSION} argument.
 * @param extension The extension can be a series of digits.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.TelephoneBuilder setExtension(java.lang.String extension) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_TEXT}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TextBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.TextBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_TEXT}.
 * @apiSince 21
 */

public TextBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a TtsSpan of type {@link #TYPE_TEXT} and sets the
 * {@link #ARG_TEXT} argument.
 * @param text The text to be synthesized.
 * @see #setText(String)
 * @apiSince 21
 */

public TextBuilder(java.lang.String text) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_TEXT} argument, the text to be synthesized.
 * @param text The string that will be synthesized.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.TextBuilder setText(java.lang.String text) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_TIME}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TimeBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.TimeBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_TIME}.
 * @apiSince 21
 */

public TimeBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_TIME} and
 * sets the {@link #ARG_HOURS} and {@link #ARG_MINUTES} arguments.
 * @apiSince 21
 */

public TimeBuilder(int hours, int minutes) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_HOURS} argument.
 * @param hours The value to be set for hours. See {@link #ARG_HOURS}.
 * @return This instance.
 * @see #ARG_HOURS
 * @apiSince 21
 */

public android.text.style.TtsSpan.TimeBuilder setHours(int hours) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_MINUTES} argument.
 * @param minutes The value to be set for minutes. See
 *     {@link #ARG_MINUTES}.
 * @return This instance.
 * @see #ARG_MINUTES
 * @apiSince 21
 */

public android.text.style.TtsSpan.TimeBuilder setMinutes(int minutes) { throw new RuntimeException("Stub!"); }
}

/**
 * A builder for TtsSpans of type {@link #TYPE_VERBATIM}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class VerbatimBuilder extends android.text.style.TtsSpan.SemioticClassBuilder<android.text.style.TtsSpan.VerbatimBuilder> {

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_VERBATIM}.
 * @apiSince 21
 */

public VerbatimBuilder() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a builder for a TtsSpan of type {@link #TYPE_VERBATIM}
 * and sets the {@link #ARG_VERBATIM} argument.
 * @apiSince 21
 */

public VerbatimBuilder(java.lang.String verbatim) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link #ARG_VERBATIM} argument.
 * @param verbatim A string of characters that will be read verbatim,
 *     except whitespace.
 * @return This instance.
 * @apiSince 21
 */

public android.text.style.TtsSpan.VerbatimBuilder setVerbatim(java.lang.String verbatim) { throw new RuntimeException("Stub!"); }
}

}

