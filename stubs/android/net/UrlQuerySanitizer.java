/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.net;

import java.util.Set;

/**
 *
 * Sanitizes the Query portion of a URL. Simple example:
 * <code>
 * UrlQuerySanitizer sanitizer = new UrlQuerySanitizer();
 * sanitizer.setAllowUnregisteredParamaters(true);
 * sanitizer.parseUrl("http://example.com/?name=Joe+User");
 * String name = sanitizer.getValue("name"));
 * // name now contains "Joe_User"
 * </code>
 *
 * Register ValueSanitizers to customize the way individual
 * parameters are sanitized:
 * <code>
 * UrlQuerySanitizer sanitizer = new UrlQuerySanitizer();
 * sanitizer.registerParamater("name", UrlQuerySanitizer.createSpaceLegal());
 * sanitizer.parseUrl("http://example.com/?name=Joe+User");
 * String name = sanitizer.getValue("name"));
 * // name now contains "Joe User". (The string is first decoded, which
 * // converts the '+' to a ' '. Then the string is sanitized, which
 * // converts the ' ' to an '_'. (The ' ' is converted because the default
 * unregistered parameter sanitizer does not allow any special characters,
 * and ' ' is a special character.)
 * </code>
 *
 * There are several ways to create ValueSanitizers. In order of increasing
 * sophistication:
 * <ol>
 * <li>Call one of the UrlQuerySanitizer.createXXX() methods.
 * <li>Construct your own instance of
 * UrlQuerySanitizer.IllegalCharacterValueSanitizer.
 * <li>Subclass UrlQuerySanitizer.ValueSanitizer to define your own value
 * sanitizer.
 * </ol>
 *
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UrlQuerySanitizer {

/**
 * Constructs a UrlQuerySanitizer.
 * <p>
 * Defaults:
 * <ul>
 * <li>unregistered parameters are not allowed.
 * <li>the last instance of a repeated parameter is preferred.
 * <li>The default value sanitizer is an AllIllegal value sanitizer.
 * <ul>
 * @apiSince 1
 */

public UrlQuerySanitizer() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a UrlQuerySanitizer and parses a URL.
 * This constructor is provided for convenience when the
 * default parsing behavior is acceptable.
 * <p>
 * Because the URL is parsed before the constructor returns, there isn't
 * a chance to configure the sanitizer to change the parsing behavior.
 * <p>
 * <code>
 * UrlQuerySanitizer sanitizer = new UrlQuerySanitizer(myUrl);
 * String name = sanitizer.getValue("name");
 * </code>
 * <p>
 * Defaults:
 * <ul>
 * <li>unregistered parameters <em>are</em> allowed.
 * <li>the last instance of a repeated parameter is preferred.
 * <li>The default value sanitizer is an AllIllegal value sanitizer.
 * <ul>
 * @apiSince 1
 */

public UrlQuerySanitizer(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Get the current value sanitizer used when processing
 * unregistered parameter values.
 * <p>
 * <b>Note:</b> The default unregistered parameter value sanitizer is
 * one that doesn't allow any special characters, similar to what
 * is returned by calling createAllIllegal.
 *
 * @return the current ValueSanitizer used to sanitize unregistered
 * parameter values.
 * @apiSince 1
 */

public android.net.UrlQuerySanitizer.ValueSanitizer getUnregisteredParameterValueSanitizer() { throw new RuntimeException("Stub!"); }

/**
 * Set the value sanitizer used when processing unregistered
 * parameter values.
 * @param sanitizer set the ValueSanitizer used to sanitize unregistered
 * parameter values.
 * @apiSince 1
 */

public void setUnregisteredParameterValueSanitizer(android.net.UrlQuerySanitizer.ValueSanitizer sanitizer) { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that does not allow any special characters,
 * and also does not allow script URLs.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getAllIllegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that allows everything except Nul ('\0')
 * characters. Script URLs are allowed.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getAllButNulLegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that allows everything except Nul ('\0')
 * characters, space (' '), and other whitespace characters.
 * Script URLs are allowed.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getAllButWhitespaceLegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that allows all the characters used by
 * encoded URLs. Does not allow script URLs.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getUrlLegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that allows all the characters used by
 * encoded URLs and allows spaces, which are not technically legal
 * in encoded URLs, but commonly appear anyway.
 * Does not allow script URLs.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getUrlAndSpaceLegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that does not allow any special characters
 * except ampersand ('&'). Does not allow script URLs.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getAmpLegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that does not allow any special characters
 * except ampersand ('&') and space (' '). Does not allow script URLs.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getAmpAndSpaceLegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that does not allow any special characters
 * except space (' '). Does not allow script URLs.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getSpaceLegal() { throw new RuntimeException("Stub!"); }

/**
 * Return a value sanitizer that allows any special characters
 * except angle brackets ('<' and '>') and Nul ('\0').
 * Allows script URLs.
 * @return a value sanitizer
 * @apiSince 1
 */

public static final android.net.UrlQuerySanitizer.ValueSanitizer getAllButNulAndAngleBracketsLegal() { throw new RuntimeException("Stub!"); }

/**
 * Parse the query parameters out of an encoded URL.
 * Works by extracting the query portion from the URL and then
 * calling parseQuery(). If there is no query portion it is
 * treated as if the query portion is an empty string.
 * @param url the encoded URL to parse.
 * @apiSince 1
 */

public void parseUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Parse a query. A query string is any number of parameter-value clauses
 * separated by any non-zero number of ampersands. A parameter-value clause
 * is a parameter followed by an equal sign, followed by a value. If the
 * equal sign is missing, the value is assumed to be the empty string.
 * @param query the query to parse.
 * @apiSince 1
 */

public void parseQuery(java.lang.String query) { throw new RuntimeException("Stub!"); }

/**
 * Get a set of all of the parameters found in the sanitized query.
 * <p>
 * Note: Do not modify this set. Treat it as a read-only set.
 * @return all the parameters found in the current query.
 * @apiSince 1
 */

public java.util.Set<java.lang.String> getParameterSet() { throw new RuntimeException("Stub!"); }

/**
 * An array list of all of the parameter-value pairs in the sanitized
 * query, in the order they appeared in the query. May contain duplicate
 * parameters.
 * <p class="note"><b>Note:</b> Do not modify this list. Treat it as a read-only list.</p>
 * @apiSince 1
 */

public java.util.List<android.net.UrlQuerySanitizer.ParameterValuePair> getParameterList() { throw new RuntimeException("Stub!"); }

/**
 * Check if a parameter exists in the current sanitized query.
 * @param parameter the unencoded name of a parameter.
 * @return true if the parameter exists in the current sanitized queary.
 * @apiSince 1
 */

public boolean hasParameter(java.lang.String parameter) { throw new RuntimeException("Stub!"); }

/**
 * Get the value for a parameter in the current sanitized query.
 * Returns null if the parameter does not
 * exit.
 * @param parameter the unencoded name of a parameter.
 * @return the sanitized unencoded value of the parameter,
 * or null if the parameter does not exist.
 * @apiSince 1
 */

public java.lang.String getValue(java.lang.String parameter) { throw new RuntimeException("Stub!"); }

/**
 * Register a value sanitizer for a particular parameter. Can also be used
 * to replace or remove an already-set value sanitizer.
 * <p>
 * Registering a non-null value sanitizer for a particular parameter
 * makes that parameter a registered parameter.
 * @param parameter an unencoded parameter name
 * @param valueSanitizer the value sanitizer to use for a particular
 * parameter. May be null in order to unregister that parameter.
 * @see #getAllowUnregisteredParamaters()
 * @apiSince 1
 */

public void registerParameter(java.lang.String parameter, android.net.UrlQuerySanitizer.ValueSanitizer valueSanitizer) { throw new RuntimeException("Stub!"); }

/**
 * Register a value sanitizer for an array of parameters.
 * @param parameters An array of unencoded parameter names.
 * @param valueSanitizer
 * @see #registerParameter
 * @apiSince 1
 */

public void registerParameters(java.lang.String[] parameters, android.net.UrlQuerySanitizer.ValueSanitizer valueSanitizer) { throw new RuntimeException("Stub!"); }

/**
 * Set whether or not unregistered parameters are allowed. If they
 * are not allowed, then they will be dropped when a query is sanitized.
 * <p>
 * Defaults to false.
 * @param allowUnregisteredParamaters true to allow unregistered parameters.
 * @see #getAllowUnregisteredParamaters()
 * @apiSince 1
 */

public void setAllowUnregisteredParamaters(boolean allowUnregisteredParamaters) { throw new RuntimeException("Stub!"); }

/**
 * Get whether or not unregistered parameters are allowed. If not
 * allowed, they will be dropped when a query is parsed.
 * @return true if unregistered parameters are allowed.
 * @see #setAllowUnregisteredParamaters(boolean)
 * @apiSince 1
 */

public boolean getAllowUnregisteredParamaters() { throw new RuntimeException("Stub!"); }

/**
 * Set whether or not the first occurrence of a repeated parameter is
 * preferred. True means the first repeated parameter is preferred.
 * False means that the last repeated parameter is preferred.
 * <p>
 * The preferred parameter is the one that is returned when getParameter
 * is called.
 * <p>
 * defaults to false.
 * @param preferFirstRepeatedParameter True if the first repeated
 * parameter is preferred.
 * @see #getPreferFirstRepeatedParameter()
 * @apiSince 1
 */

public void setPreferFirstRepeatedParameter(boolean preferFirstRepeatedParameter) { throw new RuntimeException("Stub!"); }

/**
 * Get whether or not the first occurrence of a repeated parameter is
 * preferred.
 * @return true if the first occurrence of a repeated parameter is
 * preferred.
 * @see #setPreferFirstRepeatedParameter(boolean)
 * @apiSince 1
 */

public boolean getPreferFirstRepeatedParameter() { throw new RuntimeException("Stub!"); }

/**
 * Parse an escaped parameter-value pair. The default implementation
 * unescapes both the parameter and the value, then looks up the
 * effective value sanitizer for the parameter and uses it to sanitize
 * the value. If all goes well then addSanitizedValue is called with
 * the unescaped parameter and the sanitized unescaped value.
 * @param parameter an escaped parameter
 * @param value an unsanitized escaped value
 * @apiSince 1
 */

protected void parseEntry(java.lang.String parameter, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Record a sanitized parameter-value pair. Override if you want to
 * do additional filtering or validation.
 * @param parameter an unescaped parameter
 * @param value a sanitized unescaped value
 * @apiSince 1
 */

protected void addSanitizedEntry(java.lang.String parameter, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Get the value sanitizer for a parameter. Returns null if there
 * is no value sanitizer registered for the parameter.
 * @param parameter the unescaped parameter
 * @return the currently registered value sanitizer for this parameter.
 * @see #registerParameter(String, android.net.UrlQuerySanitizer.ValueSanitizer)
 * @apiSince 1
 */

public android.net.UrlQuerySanitizer.ValueSanitizer getValueSanitizer(java.lang.String parameter) { throw new RuntimeException("Stub!"); }

/**
 * Get the effective value sanitizer for a parameter. Like getValueSanitizer,
 * except if there is no value sanitizer registered for a parameter, and
 * unregistered parameters are allowed, then the default value sanitizer is
 * returned.
 * @param parameter an unescaped parameter
 * @return the effective value sanitizer for a parameter.
 * @apiSince 1
 */

public android.net.UrlQuerySanitizer.ValueSanitizer getEffectiveValueSanitizer(java.lang.String parameter) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String unescape(java.lang.String string) { throw new RuntimeException("Stub!"); }

/**
 * Test if a character is a hexidecimal digit. Both upper case and lower
 * case hex digits are allowed.
 * @param c the character to test
 * @return true if c is a hex digit.
 * @apiSince 1
 */

protected boolean isHexDigit(char c) { throw new RuntimeException("Stub!"); }

/**
 * Convert a character that represents a hexidecimal digit into an integer.
 * If the character is not a hexidecimal digit, then -1 is returned.
 * Both upper case and lower case hex digits are allowed.
 * @param c the hexidecimal digit.
 * @return the integer value of the hexidecimal digit.
 * @apiSince 1
 */

protected int decodeHexDigit(char c) { throw new RuntimeException("Stub!"); }

/**
 * Clear the existing entries. Called to get ready to parse a new
 * query string.
 * @apiSince 1
 */

protected void clear() { throw new RuntimeException("Stub!"); }
/**
 * Sanitize values based on which characters they contain. Illegal
 * characters are replaced with either space or '_', depending upon
 * whether space is a legal character or not.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class IllegalCharacterValueSanitizer implements android.net.UrlQuerySanitizer.ValueSanitizer {

/**
 * Construct a sanitizer. The parameters set the behavior of the
 * sanitizer.
 * @param flags some combination of the XXX_OK flags.
 * @apiSince 1
 */

public IllegalCharacterValueSanitizer(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Sanitize a value.
 * <ol>
 * <li>If script URLs are not OK, they will be removed.
 * <li>If neither spaces nor other white space is OK, then
 * white space will be trimmed from the beginning and end of
 * the URL. (Just the actual white space characters are trimmed, not
 * other control codes.)
 * <li> Illegal characters will be replaced with
 * either ' ' or '_', depending on whether a space is itself a
 * legal character.
 * </ol>
 * @param value
 * @return the sanitized value
 * @apiSince 1
 */

public java.lang.String sanitize(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * <ul>
 * <li>Allow all but.
 * <ul>
 *  <li>Nul ('\0')
 *  <li>Angle brackets ('<', '>')
 * </ul>
 * <li>Deny script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int ALL_BUT_NUL_AND_ANGLE_BRACKETS_LEGAL = 1439; // 0x59f

/**
 * <ul>
 * <li>Allow all special characters except Nul. ('\0').
 * <li>Allow script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int ALL_BUT_NUL_LEGAL = 1535; // 0x5ff

/**
 * <ul>
 * <li>Allow all special characters except for:
 * <ul>
 *  <li>whitespace characters
 *  <li>Nul ('\0')
 * </ul>
 * <li>Allow script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int ALL_BUT_WHITESPACE_LEGAL = 1532; // 0x5fc

/**
 * <ul>
 * <li>Deny all special characters.
 * <li>Deny script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int ALL_ILLEGAL = 0; // 0x0

/**
 * Mask with all fields set to OK
 * @apiSince 1
 */

public static final int ALL_OK = 2047; // 0x7ff

/**
 * Mask with both regular space and other whitespace OK
 * @apiSince 1
 */

public static final int ALL_WHITESPACE_OK = 3; // 0x3

/**
 * <ul>
 * <li>Allow ampersand.
 * <li>Allow space.
 * <li>Deny script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int AMP_AND_SPACE_LEGAL = 129; // 0x81

/**
 * <ul>
 * <li>Allow ampersand.
 * <li>Deny script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int AMP_LEGAL = 128; // 0x80

/**
 * Allow ampersand characters ('&')
 * @apiSince 1
 */

public static final int AMP_OK = 128; // 0x80

/**
 * Allow double quote characters. ('"')
 * @apiSince 1
 */

public static final int DQUOTE_OK = 8; // 0x8

/**
 * Allow greater-than characters. ('>')
 * @apiSince 1
 */

public static final int GT_OK = 64; // 0x40

/**
 * Allow less-than characters. ('<')
 * @apiSince 1
 */

public static final int LT_OK = 32; // 0x20

/**
 * Allow characters with character codes 128 to 255.
 * @apiSince 1
 */

public static final int NON_7_BIT_ASCII_OK = 4; // 0x4

/**
 * Allow nul characters ('\0')
 * @apiSince 1
 */

public static final int NUL_OK = 512; // 0x200

/**
 * Allow whitespace characters other than space. The
 * other whitespace characters are
 * '\t' '\f' '\n' '\r' and '\0x000b' (vertical tab)
 * @apiSince 1
 */

public static final int OTHER_WHITESPACE_OK = 2; // 0x2

/**
 * Allow percent-sign characters ('%')
 * @apiSince 1
 */

public static final int PCT_OK = 256; // 0x100

/**
 * Allow text to start with a script URL
 * such as "javascript:" or "vbscript:"
 * @apiSince 1
 */

public static final int SCRIPT_URL_OK = 1024; // 0x400

/**
 * <ul>
 * <li>Allow space.
 * <li>Deny script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int SPACE_LEGAL = 1; // 0x1

/**
 * Allow space (' ') characters.
 * @apiSince 1
 */

public static final int SPACE_OK = 1; // 0x1

/**
 * Allow single quote characters. ('\'')
 * @apiSince 1
 */

public static final int SQUOTE_OK = 16; // 0x10

/**
 * <ul>
 * <li>Allow characters used by encoded URLs.
 * <li>Allow spaces.
 * <li>Deny script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int URL_AND_SPACE_LEGAL = 405; // 0x195

/**
 * <ul>
 * <li>Allow characters used by encoded URLs.
 * <li>Deny script URLs.
 * </ul>
 * @apiSince 1
 */

public static final int URL_LEGAL = 404; // 0x194
}

/**
 * A simple tuple that holds parameter-value pairs.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ParameterValuePair {

/**
 * Construct a parameter-value tuple.
 * @param parameter an unencoded parameter
 * @param value an unencoded value
 */

public ParameterValuePair(java.lang.String parameter, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * The unencoded parameter
 * @apiSince 1
 */

public java.lang.String mParameter;

/**
 * The unencoded value
 * @apiSince 1
 */

public java.lang.String mValue;
}

/**
 * A functor used to sanitize a single query value.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ValueSanitizer {

/**
 * Sanitize an unencoded value.
 * @param value
 * @return the sanitized unencoded value
 * @apiSince 1
 */

public java.lang.String sanitize(java.lang.String value);
}

}

