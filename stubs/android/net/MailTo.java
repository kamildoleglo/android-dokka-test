/*
 * Copyright (C) 2008 The Android Open Source Project
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


/**
 *
 * MailTo URL parser
 *
 * This class parses a mailto scheme URL and then can be queried for
 * the parsed parameters. This implements RFC 2368.
 *
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MailTo {

private MailTo() { throw new RuntimeException("Stub!"); }

/**
 * Test to see if the given string is a mailto URL
 * @param url string to be tested
 * @return true if the string is a mailto URL
 * @apiSince 1
 */

public static boolean isMailTo(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Parse and decode a mailto scheme string. This parser implements
 * RFC 2368. The returned object can be queried for the parsed parameters.
 * @param url String containing a mailto URL
 * @return MailTo object
 * @exception android.net.ParseException if the scheme is not a mailto URL
 * @apiSince 1
 */

public static android.net.MailTo parse(java.lang.String url) throws android.net.ParseException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the To address line from the parsed mailto URL. This could be
 * several email address that are comma-space delimited.
 * If no To line was specified, then null is return
 * @return comma delimited email addresses or null
 * @apiSince 1
 */

public java.lang.String getTo() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the CC address line from the parsed mailto URL. This could be
 * several email address that are comma-space delimited.
 * If no CC line was specified, then null is return
 * @return comma delimited email addresses or null
 * @apiSince 1
 */

public java.lang.String getCc() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the subject line from the parsed mailto URL.
 * If no subject line was specified, then null is return
 * @return subject or null
 * @apiSince 1
 */

public java.lang.String getSubject() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the body line from the parsed mailto URL.
 * If no body line was specified, then null is return
 * @return body or null
 * @apiSince 1
 */

public java.lang.String getBody() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve all the parsed email headers from the mailto URL
 * @return map containing all parsed values
 * @apiSince 1
 */

public java.util.Map<java.lang.String,java.lang.String> getHeaders() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final java.lang.String MAILTO_SCHEME = "mailto:";
}

