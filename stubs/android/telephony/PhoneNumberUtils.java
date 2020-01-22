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


package android.telephony;

import android.content.Intent;
import java.util.Locale;
import android.text.style.TtsSpan;
import android.text.Spannable;

/**
 * Various utilities for dealing with phone number strings.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PhoneNumberUtils {

public PhoneNumberUtils() { throw new RuntimeException("Stub!"); }

/**
 * True if c is ISO-LATIN characters 0-9
 * @apiSince 1
 */

public static boolean isISODigit(char c) { throw new RuntimeException("Stub!"); }

/**
 * True if c is ISO-LATIN characters 0-9, *, #
 * @apiSince 1
 */

public static final boolean is12Key(char c) { throw new RuntimeException("Stub!"); }

/**
 * True if c is ISO-LATIN characters 0-9, *, # , +, WILD
 * @apiSince 1
 */

public static final boolean isDialable(char c) { throw new RuntimeException("Stub!"); }

/**
 * True if c is ISO-LATIN characters 0-9, *, # , + (no WILD)
 * @apiSince 1
 */

public static final boolean isReallyDialable(char c) { throw new RuntimeException("Stub!"); }

/**
 * True if c is ISO-LATIN characters 0-9, *, # , +, WILD, WAIT, PAUSE
 * @apiSince 1
 */

public static final boolean isNonSeparator(char c) { throw new RuntimeException("Stub!"); }

/** This any anything to the right of this char is part of the
 *  post-dial string (eg this is PAUSE or WAIT)
 * @apiSince 1
 */

public static final boolean isStartsPostDial(char c) { throw new RuntimeException("Stub!"); }

/** Extracts the phone number from an Intent.
 *
 * @param intent the intent to get the number of
 * @param context a context to use for database access
 *
 * @return the phone number that would be called by the intent, or
 *         <code>null</code> if the number cannot be found.
 @apiSince 1
 */

public static java.lang.String getNumberFromIntent(android.content.Intent intent, android.content.Context context) { throw new RuntimeException("Stub!"); }

/** Extracts the network address portion and canonicalizes
 *  (filters out separators.)
 *  Network address portion is everything up to DTMF control digit
 *  separators (pause or wait), but without non-dialable characters.
 *
 *  Please note that the GSM wild character is allowed in the result.
 *  This must be resolved before dialing.
 *
 *  Returns null if phoneNumber == null
 * @apiSince 1
 */

public static java.lang.String extractNetworkPortion(java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Strips separators from a phone number string.
 * @param phoneNumber phone number to strip.
 * @return phone string stripped of separators.
 * @apiSince 1
 */

public static java.lang.String stripSeparators(java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Extracts the post-dial sequence of DTMF control digits, pauses, and
 * waits. Strips separators. This string may be empty, but will not be null
 * unless phoneNumber == null.
 *
 * Returns null if phoneNumber == null
 * @apiSince 1
 */

public static java.lang.String extractPostDialPortion(java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Compare phone numbers a and b, return true if they're identical enough for caller ID purposes.
 * @apiSince 1
 */

public static boolean compare(java.lang.String a, java.lang.String b) { throw new RuntimeException("Stub!"); }

/**
 * Compare phone numbers a and b, and return true if they're identical
 * enough for caller ID purposes. Checks a resource to determine whether
 * to use a strict or loose comparison algorithm.
 * @apiSince 5
 */

public static boolean compare(android.content.Context context, java.lang.String a, java.lang.String b) { throw new RuntimeException("Stub!"); }

/**
 * Returns the rightmost minimum matched characters in the network portion
 * in *reversed* order
 *
 * This can be used to do a database lookup against the column
 * that stores getStrippedReversed()
 *
 * Returns null if phoneNumber == null
 * @apiSince 1
 */

public static java.lang.String toCallerIDMinMatch(java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Returns the network portion reversed.
 * This string is intended to go into an index column for a
 * database lookup.
 *
 * Returns null if phoneNumber == null
 * @apiSince 1
 */

public static java.lang.String getStrippedReversed(java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Basically: makes sure there's a + in front of a
 * TOA_International number
 *
 * Returns null if s == null
 * @apiSince 1
 */

public static java.lang.String stringFromStringAndTOA(java.lang.String s, int TOA) { throw new RuntimeException("Stub!"); }

/**
 * Returns the TOA for the given dial string
 * Basically, returns TOA_International if there's a + prefix
 * @apiSince 1
 */

public static int toaFromString(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 *  3GPP TS 24.008 10.5.4.7
 *  Called Party BCD Number
 *
 *  See Also TS 51.011 10.5.1 "dialing number/ssc string"
 *  and TS 11.11 "10.3.1 EF adn (Abbreviated dialing numbers)"
 *
 * @param bytes the data buffer
 * @param offset should point to the TOA (aka. TON/NPI) octet after the length byte
 * @param length is the number of bytes including TOA byte
 *                and must be at least 2
 *
 * @return partial string on invalid decode
 *
 * @deprecated use {@link #calledPartyBCDToString(byte[],int,int,int)} instead. Calling this
 * method is equivalent to calling {@link #calledPartyBCDToString(byte[],int,int)} with
 * {@link #BCD_EXTENDED_TYPE_EF_ADN} as the extended type.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public static java.lang.String calledPartyBCDToString(byte[] bytes, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 *  3GPP TS 24.008 10.5.4.7
 *  Called Party BCD Number
 *
 *  See Also TS 51.011 10.5.1 "dialing number/ssc string"
 *  and TS 11.11 "10.3.1 EF adn (Abbreviated dialing numbers)"
 *
 * @param bytes the data buffer
 * @param offset should point to the TOA (aka. TON/NPI) octet after the length byte
 * @param length is the number of bytes including TOA byte
 *                and must be at least 2
 * @param bcdExtType used to determine the extended bcd coding
 * Value is {@link android.telephony.PhoneNumberUtils#BCD_EXTENDED_TYPE_EF_ADN}, or {@link android.telephony.PhoneNumberUtils#BCD_EXTENDED_TYPE_CALLED_PARTY}
 * @see #BCD_EXTENDED_TYPE_EF_ADN
 * @see #BCD_EXTENDED_TYPE_CALLED_PARTY
 *
 * @apiSince 28
 */

public static java.lang.String calledPartyBCDToString(byte[] bytes, int offset, int length, int bcdExtType) { throw new RuntimeException("Stub!"); }

/**
 * Like calledPartyBCDToString, but field does not start with a
 * TOA byte. For example: SIM ADN extension fields
 *
 * @deprecated use {@link #calledPartyBCDFragmentToString(byte[],int,int,int)} instead.
 * Calling this method is equivalent to calling
 * {@link #calledPartyBCDFragmentToString(byte[],int,int,int)} with
 * {@link #BCD_EXTENDED_TYPE_EF_ADN} as the extended type.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public static java.lang.String calledPartyBCDFragmentToString(byte[] bytes, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Like calledPartyBCDToString, but field does not start with a
 * TOA byte. For example: SIM ADN extension fields
 
 * @param bcdExtType Value is {@link android.telephony.PhoneNumberUtils#BCD_EXTENDED_TYPE_EF_ADN}, or {@link android.telephony.PhoneNumberUtils#BCD_EXTENDED_TYPE_CALLED_PARTY}
 * @apiSince 28
 */

public static java.lang.String calledPartyBCDFragmentToString(byte[] bytes, int offset, int length, int bcdExtType) { throw new RuntimeException("Stub!"); }

/**
 * Return true iff the network portion of <code>address</code> is,
 * as far as we can tell on the device, suitable for use as an SMS
 * destination address.
 * @apiSince 1
 */

public static boolean isWellFormedSmsAddress(java.lang.String address) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static boolean isGlobalPhoneNumber(java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Note: calls extractNetworkPortion(), so do not use for
 * SIM EF[ADN] style records
 *
 * Returns null if network portion is empty.
 * @apiSince 1
 */

public static byte[] networkPortionToCalledPartyBCD(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #networkPortionToCalledPartyBCD}, but includes a
 * one-byte length prefix.
 * @apiSince 1
 */

public static byte[] networkPortionToCalledPartyBCDWithLength(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Convert a dialing number to BCD byte array
 *
 * @param number dialing number string. If the dialing number starts with '+', set to
 * international TOA
 *
 * @return BCD byte array
 *
 * @deprecated use {@link #numberToCalledPartyBCD(java.lang.String,int)} instead. Calling this method
 * is equivalent to calling {@link #numberToCalledPartyBCD(java.lang.String,int)} with
 * {@link #BCD_EXTENDED_TYPE_EF_ADN} as the extended type.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public static byte[] numberToCalledPartyBCD(java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Convert a dialing number to BCD byte array
 *
 * @param number dialing number string. If the dialing number starts with '+', set to
 * international TOA
 * @param bcdExtType used to determine the extended bcd coding
 * Value is {@link android.telephony.PhoneNumberUtils#BCD_EXTENDED_TYPE_EF_ADN}, or {@link android.telephony.PhoneNumberUtils#BCD_EXTENDED_TYPE_CALLED_PARTY}
 * @see #BCD_EXTENDED_TYPE_EF_ADN
 * @see #BCD_EXTENDED_TYPE_CALLED_PARTY
 *
 * @return BCD byte array
 * @apiSince 28
 */

public static byte[] numberToCalledPartyBCD(java.lang.String number, int bcdExtType) { throw new RuntimeException("Stub!"); }

/**
 * Breaks the given number down and formats it according to the rules
 * for the country the number is from.
 *
 * @param source The phone number to format
 * @return A locally acceptable formatting of the input, or the raw input if
 *  formatting rules aren't known for the number
 *
 * @deprecated Use link #formatNumber(String phoneNumber, String defaultCountryIso) instead
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public static java.lang.String formatNumber(java.lang.String source) { throw new RuntimeException("Stub!"); }

/**
 * Returns the phone number formatting type for the given locale.
 *
 * @param locale The locale of interest, usually {@link java.util.Locale#getDefault() Locale#getDefault()}
 * @return The formatting type for the given locale, or FORMAT_UNKNOWN if the formatting
 * rules are not known for the given locale
 *
 * @deprecated Use link #formatNumber(String phoneNumber, String defaultCountryIso) instead
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public static int getFormatTypeForLocale(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Formats a phone number in-place. Currently {@link #FORMAT_JAPAN} and {@link #FORMAT_NANP}
 * is supported as a second argument.
 *
 * @param text The number to be formatted, will be modified with the formatting
 * @param defaultFormattingType The default formatting rules to apply if the number does
 * not begin with +[country_code]
 *
 * @deprecated Use link #formatNumber(String phoneNumber, String defaultCountryIso) instead
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public static void formatNumber(android.text.Editable text, int defaultFormattingType) { throw new RuntimeException("Stub!"); }

/**
 * Formats a phone number in-place using the NANP formatting rules. Numbers will be formatted
 * as:
 *
 * <p><code>
 * xxxxx
 * xxx-xxxx
 * xxx-xxx-xxxx
 * 1-xxx-xxx-xxxx
 * +1-xxx-xxx-xxxx
 * </code></p>
 *
 * @param text the number to be formatted, will be modified with the formatting
 *
 * @deprecated Use link #formatNumber(String phoneNumber, String defaultCountryIso) instead
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public static void formatNanpNumber(android.text.Editable text) { throw new RuntimeException("Stub!"); }

/**
 * Formats a phone number in-place using the Japanese formatting rules.
 * Numbers will be formatted as:
 *
 * <p><code>
 * 03-xxxx-xxxx
 * 090-xxxx-xxxx
 * 0120-xxx-xxx
 * +81-3-xxxx-xxxx
 * +81-90-xxxx-xxxx
 * </code></p>
 *
 * @param text the number to be formatted, will be modified with
 * the formatting
 *
 * @deprecated Use link #formatNumber(String phoneNumber, String defaultCountryIso) instead
 * @apiSince 3
 * @deprecatedSince 21
 */

@Deprecated
public static void formatJapaneseNumber(android.text.Editable text) { throw new RuntimeException("Stub!"); }

/**
 * Formats the specified {@code phoneNumber} to the E.164 representation.
 *
 * @param phoneNumber the phone number to format.
 * @param defaultCountryIso the ISO 3166-1 two letters country code.
 * @return the E.164 representation, or null if the given phone number is not valid.
 * @apiSince 21
 */

public static java.lang.String formatNumberToE164(java.lang.String phoneNumber, java.lang.String defaultCountryIso) { throw new RuntimeException("Stub!"); }

/**
 * Formats the specified {@code phoneNumber} to the RFC3966 representation.
 *
 * @param phoneNumber the phone number to format.
 * @param defaultCountryIso the ISO 3166-1 two letters country code.
 * @return the RFC3966 representation, or null if the given phone number is not valid.
 * @apiSince 23
 */

public static java.lang.String formatNumberToRFC3966(java.lang.String phoneNumber, java.lang.String defaultCountryIso) { throw new RuntimeException("Stub!"); }

/**
 * Format a phone number.
 * <p>
 * If the given number doesn't have the country code, the phone will be
 * formatted to the default country's convention.
 *
 * @param phoneNumber
 *            the number to be formatted.
 * @param defaultCountryIso
 *            the ISO 3166-1 two letters country code whose convention will
 *            be used if the given number doesn't have the country code.
 * @return the formatted number, or null if the given number is not valid.
 * @apiSince 21
 */

public static java.lang.String formatNumber(java.lang.String phoneNumber, java.lang.String defaultCountryIso) { throw new RuntimeException("Stub!"); }

/**
 * Format the phone number only if the given number hasn't been formatted.
 * <p>
 * The number which has only dailable character is treated as not being
 * formatted.
 *
 * @param phoneNumber
 *            the number to be formatted.
 * @param phoneNumberE164
 *            the E164 format number whose country code is used if the given
 *            phoneNumber doesn't have the country code.
 * @param defaultCountryIso
 *            the ISO 3166-1 two letters country code whose convention will
 *            be used if the phoneNumberE164 is null or invalid, or if phoneNumber
 *            contains IDD.
 * @return the formatted number if the given number has been formatted,
 *            otherwise, return the given number.
 * @apiSince 21
 */

public static java.lang.String formatNumber(java.lang.String phoneNumber, java.lang.String phoneNumberE164, java.lang.String defaultCountryIso) { throw new RuntimeException("Stub!"); }

/**
 * Normalize a phone number by removing the characters other than digits. If
 * the given number has keypad letters, the letters will be converted to
 * digits first.
 *
 * @param phoneNumber the number to be normalized.
 * @return the normalized number.
 * @apiSince 21
 */

public static java.lang.String normalizeNumber(java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Replaces all unicode(e.g.&nbsp;Arabic, Persian) digits with their decimal digit equivalents.
 *
 * @param number the number to perform the replacement on.
 * @return the replaced number.
 * @apiSince 21
 */

public static java.lang.String replaceUnicodeDigits(java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Checks a given number against the list of
 * emergency numbers provided by the RIL and SIM card.
 *
 * @param number the number to look up.
 * @return true if the number is in the list of emergency numbers
 *         listed in the RIL / SIM, otherwise return false.
 *
 * @deprecated Please use {@link android.telephony.TelephonyManager#isEmergencyNumber(java.lang.String) TelephonyManager#isEmergencyNumber(String)} instead.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static boolean isEmergencyNumber(java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Checks if a given number is an emergency number for the country that the user is in.
 *
 * @param number the number to look up.
 * @param context the specific context which the number should be checked against
 * @return true if the specified number is an emergency number for the country the user
 * is currently in.
 *
 * @deprecated Please use {@link android.telephony.TelephonyManager#isEmergencyNumber(java.lang.String) TelephonyManager#isEmergencyNumber(String)}
 *             instead.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public static boolean isLocalEmergencyNumber(android.content.Context context, java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * isVoiceMailNumber: checks a given number against the voicemail
 *   number provided by the RIL and SIM card. The caller must have
 *   the READ_PHONE_STATE credential.
 *
 * @param number the number to look up.
 * @return true if the number is in the list of voicemail. False
 * otherwise, including if the caller does not have the permission
 * to read the VM number.
 * @apiSince 21
 */

public static boolean isVoiceMailNumber(java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Translates any alphabetic letters (i.e. [A-Za-z]) in the
 * specified phone number into the equivalent numeric digits,
 * according to the phone keypad letter mapping described in
 * ITU E.161 and ISO/IEC 9995-8.
 *
 * @return the input string, with alpha letters converted to numeric
 *         digits using the phone keypad letter mapping.  For example,
 *         an input of "1-800-GOOG-411" will return "1-800-4664-411".
 * @apiSince 1
 */

public static java.lang.String convertKeypadLettersToDigits(java.lang.String input) { throw new RuntimeException("Stub!"); }

/**
 * Wrap the supplied {@code CharSequence} with a {@code TtsSpan}, annotating it as
 * containing a phone number in its entirety.
 *
 * @param phoneNumber A {@code CharSequence} the entirety of which represents a phone number.
 * @return A {@code CharSequence} with appropriate annotations.
 * @apiSince 23
 */

public static java.lang.CharSequence createTtsSpannable(java.lang.CharSequence phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Attach a {@link android.text.style.TtsSpan TtsSpan} to the supplied {@code Spannable} at the indicated location,
 * annotating that location as containing a phone number.
 *
 * @param s A {@code Spannable} to annotate.
 * @param start The starting character position of the phone number in {@code s}.
 * @param endExclusive The position after the ending character in the phone number {@code s}.
 * @apiSince 23
 */

public static void addTtsSpan(android.text.Spannable s, int start, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@code TtsSpan} for the supplied {@code String}.
 *
 * @param phoneNumberString A {@code String} the entirety of which represents a phone number.
 * @return A {@code TtsSpan} for {@param phoneNumberString}.
 * @apiSince 23
 */

public static android.text.style.TtsSpan createTtsSpan(java.lang.String phoneNumberString) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public static final int BCD_EXTENDED_TYPE_CALLED_PARTY = 2; // 0x2

/** @apiSince 28 */

public static final int BCD_EXTENDED_TYPE_EF_ADN = 1; // 0x1

/**
 * Japanese formatting
 * @apiSince 3
 */

public static final int FORMAT_JAPAN = 2; // 0x2

/**
 * NANP formatting
 * @apiSince 1
 */

public static final int FORMAT_NANP = 1; // 0x1

/**
 * The current locale is unknown, look for a country code or don't format
 * @apiSince 1
 */

public static final int FORMAT_UNKNOWN = 0; // 0x0

/** @apiSince 1 */

public static final char PAUSE = 44; // 0x002c ','

/** @apiSince 1 */

public static final int TOA_International = 145; // 0x91

/** @apiSince 1 */

public static final int TOA_Unknown = 129; // 0x81

/** @apiSince 1 */

public static final char WAIT = 59; // 0x003b ';'

/** @apiSince 1 */

public static final char WILD = 78; // 0x004e 'N'
}

