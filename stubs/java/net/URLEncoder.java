/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.net;

import java.io.UnsupportedEncodingException;

/**
 * Utility class for HTML form encoding. This class contains static methods
 * for converting a String to the <CODE>application/x-www-form-urlencoded</CODE> MIME
 * format. For more information about HTML form encoding, consult the HTML
 * <A HREF="http://www.w3.org/TR/html4/">specification</A>.
 *
 * <p>
 * When encoding a String, the following rules apply:
 *
 * <ul>
 * <li>The alphanumeric characters &quot;{@code a}&quot; through
 *     &quot;{@code z}&quot;, &quot;{@code A}&quot; through
 *     &quot;{@code Z}&quot; and &quot;{@code 0}&quot;
 *     through &quot;{@code 9}&quot; remain the same.
 * <li>The special characters &quot;{@code .}&quot;,
 *     &quot;{@code -}&quot;, &quot;{@code *}&quot;, and
 *     &quot;{@code _}&quot; remain the same.
 * <li>The space character &quot; &nbsp; &quot; is
 *     converted into a plus sign &quot;{@code +}&quot;.
 * <li>All other characters are unsafe and are first converted into
 *     one or more bytes using some encoding scheme. Then each byte is
 *     represented by the 3-character string
 *     &quot;<i>{@code %xy}</i>&quot;, where <i>xy</i> is the
 *     two-digit hexadecimal representation of the byte.
 *     The recommended encoding scheme to use is UTF-8. However,
 *     for compatibility reasons, if an encoding is not specified,
 *     then the default encoding of the platform is used.
 * </ul>
 *
 * <p>
 * For example using UTF-8 as the encoding scheme the string &quot;The
 * string &#252;@foo-bar&quot; would get converted to
 * &quot;The+string+%C3%BC%40foo-bar&quot; because in UTF-8 the character
 * &#252; is encoded as two bytes C3 (hex) and BC (hex), and the
 * character @ is encoded as one byte 40 (hex).
 *
 * @author  Herb Jellinek
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class URLEncoder {

private URLEncoder() { throw new RuntimeException("Stub!"); }

/**
 * Translates a string into {@code x-www-form-urlencoded}
 * format. This method uses the platform's default encoding
 * as the encoding scheme to obtain the bytes for unsafe characters.
 *
 * @param   s   {@code String} to be translated.
 * @deprecated The resulting string may vary depending on the platform's
 *             default encoding. Instead, use the encode(String,String)
 *             method to specify the encoding.
 * @return  the translated {@code String}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static java.lang.String encode(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Translates a string into {@code application/x-www-form-urlencoded}
 * format using a specific encoding scheme. This method uses the
 * supplied encoding scheme to obtain the bytes for unsafe
 * characters.
 * <p>
 * <em><strong>Note:</strong> The <a href=
 * "http://www.w3.org/TR/html40/appendix/notes.html#non-ascii-chars">
 * World Wide Web Consortium Recommendation</a> states that
 * UTF-8 should be used. Not doing so may introduce
 * incompatibilities.</em>
 *
 * @param   s   {@code String} to be translated.
 * @param   enc   The name of a supported
 *    <a href="../lang/package-summary.html#charenc">character
 *    encoding</a>.
 * @return  the translated {@code String}.
 * @exception  java.io.UnsupportedEncodingException
 *             If the named encoding is not supported
 * @see java.net.URLDecoder#decode(java.lang.String, java.lang.String)
 * @since 1.4
 * @apiSince 1
 */

public static java.lang.String encode(java.lang.String s, java.lang.String enc) throws java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }
}

