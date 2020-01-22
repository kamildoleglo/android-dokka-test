/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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



package javax.net.ssl;

import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * Instances of this class represent a server name of type
 * {@link javax.net.ssl.StandardConstants#SNI_HOST_NAME StandardConstants#SNI_HOST_NAME} in a Server Name
 * Indication (SNI) extension.
 * <P>
 * As described in section 3, "Server Name Indication", of
 * <A HREF="http://www.ietf.org/rfc/rfc6066.txt">TLS Extensions (RFC 6066)</A>,
 * "HostName" contains the fully qualified DNS hostname of the server, as
 * understood by the client.  The encoded server name value of a hostname is
 * represented as a byte string using ASCII encoding without a trailing dot.
 * This allows the support of Internationalized Domain Names (IDN) through
 * the use of A-labels (the ASCII-Compatible Encoding (ACE) form of a valid
 * string of Internationalized Domain Names for Applications (IDNA)) defined
 * in <A HREF="http://www.ietf.org/rfc/rfc5890.txt">RFC 5890</A>.
 * <P>
 * Note that {@code SNIHostName} objects are immutable.
 *
 * @see javax.net.ssl.SNIServerName
 * @see javax.net.ssl.StandardConstants#SNI_HOST_NAME
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SNIHostName extends javax.net.ssl.SNIServerName {

/**
 * Creates an {@code SNIHostName} using the specified hostname.
 * <P>
 * Note that per <A HREF="http://www.ietf.org/rfc/rfc6066.txt">RFC 6066</A>,
 * the encoded server name value of a hostname is
 * {@link java.nio.charset.StandardCharsets#US_ASCII StandardCharsets#US_ASCII}-compliant.  In this method,
 * {@code hostname} can be a user-friendly Internationalized Domain Name
 * (IDN).  {@link java.net.IDN#toASCII(java.lang.String,int) IDN#toASCII(String, int)} is used to enforce the
 * restrictions on ASCII characters in hostnames (see
 * <A HREF="http://www.ietf.org/rfc/rfc3490.txt">RFC 3490</A>,
 * <A HREF="http://www.ietf.org/rfc/rfc1122.txt">RFC 1122</A>,
 * <A HREF="http://www.ietf.org/rfc/rfc1123.txt">RFC 1123</A>) and
 * translate the {@code hostname} into ASCII Compatible Encoding (ACE), as:
 * <pre>
 *     IDN.toASCII(hostname, IDN.USE_STD3_ASCII_RULES);
 * </pre>
 * <P>
 * The {@code hostname} argument is illegal if it:
 * <ul>
 * <li> {@code hostname} is empty,</li>
 * <li> {@code hostname} ends with a trailing dot,</li>
 * <li> {@code hostname} is not a valid Internationalized
 *      Domain Name (IDN) compliant with the RFC 3490 specification.</li>
 * </ul>
 * @param  hostname
 *         the hostname of this server name
 *
 * @throws java.lang.NullPointerException if {@code hostname} is {@code null}
 * @throws java.lang.IllegalArgumentException if {@code hostname} is illegal
 * @apiSince 24
 */

public SNIHostName(java.lang.String hostname) { super(0, null); throw new RuntimeException("Stub!"); }

/**
 * Creates an {@code SNIHostName} using the specified encoded value.
 * <P>
 * This method is normally used to parse the encoded name value in a
 * requested SNI extension.
 * <P>
 * Per <A HREF="http://www.ietf.org/rfc/rfc6066.txt">RFC 6066</A>,
 * the encoded name value of a hostname is
 * {@link java.nio.charset.StandardCharsets#US_ASCII StandardCharsets#US_ASCII}-compliant.  However, in the previous
 * version of the SNI extension (
 * <A HREF="http://www.ietf.org/rfc/rfc4366.txt">RFC 4366</A>),
 * the encoded hostname is represented as a byte string using UTF-8
 * encoding.  For the purpose of version tolerance, this method allows
 * that the charset of {@code encoded} argument can be
 * {@link java.nio.charset.StandardCharsets#UTF_8 StandardCharsets#UTF_8}, as well as
 * {@link java.nio.charset.StandardCharsets#US_ASCII StandardCharsets#US_ASCII}.  {@link java.net.IDN#toASCII(java.lang.String) IDN#toASCII(String)} is used
 * to translate the {@code encoded} argument into ASCII Compatible
 * Encoding (ACE) hostname.
 * <P>
 * It is strongly recommended that this constructor is only used to parse
 * the encoded name value in a requested SNI extension.  Otherwise, to
 * comply with <A HREF="http://www.ietf.org/rfc/rfc6066.txt">RFC 6066</A>,
 * please always use {@link java.nio.charset.StandardCharsets#US_ASCII StandardCharsets#US_ASCII}-compliant charset
 * and enforce the restrictions on ASCII characters in hostnames (see
 * <A HREF="http://www.ietf.org/rfc/rfc3490.txt">RFC 3490</A>,
 * <A HREF="http://www.ietf.org/rfc/rfc1122.txt">RFC 1122</A>,
 * <A HREF="http://www.ietf.org/rfc/rfc1123.txt">RFC 1123</A>)
 * for {@code encoded} argument, or use
 * {@link javax.net.ssl.SNIHostName#SNIHostName(java.lang.String) SNIHostName#SNIHostName(String)} instead.
 * <P>
 * The {@code encoded} argument is illegal if it:
 * <ul>
 * <li> {@code encoded} is empty,</li>
 * <li> {@code encoded} ends with a trailing dot,</li>
 * <li> {@code encoded} is not encoded in
 *      {@link java.nio.charset.StandardCharsets#US_ASCII StandardCharsets#US_ASCII} or
 *      {@link java.nio.charset.StandardCharsets#UTF_8 StandardCharsets#UTF_8}-compliant charset,</li>
 * <li> {@code encoded} is not a valid Internationalized
 *      Domain Name (IDN) compliant with the RFC 3490 specification.</li>
 * </ul>
 *
 * <P>
 * Note that the {@code encoded} byte array is cloned
 * to protect against subsequent modification.
 *
 * @param  encoded
 *         the encoded hostname of this server name
 *
 * @throws java.lang.NullPointerException if {@code encoded} is {@code null}
 * @throws java.lang.IllegalArgumentException if {@code encoded} is illegal
 * @apiSince 24
 */

public SNIHostName(byte[] encoded) { super(0, null); throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link java.nio.charset.StandardCharsets#US_ASCII StandardCharsets#US_ASCII}-compliant hostname of
 * this {@code SNIHostName} object.
 * <P>
 * Note that, per
 * <A HREF="http://www.ietf.org/rfc/rfc6066.txt">RFC 6066</A>, the
 * returned hostname may be an internationalized domain name that
 * contains A-labels. See
 * <A HREF="http://www.ietf.org/rfc/rfc5890.txt">RFC 5890</A>
 * for more information about the detailed A-label specification.
 *
 * @return the {@link java.nio.charset.StandardCharsets#US_ASCII StandardCharsets#US_ASCII}-compliant hostname
 *         of this {@code SNIHostName} object
 * @apiSince 24
 */

public java.lang.String getAsciiName() { throw new RuntimeException("Stub!"); }

/**
 * Compares this server name to the specified object.
 * <P>
 * Per <A HREF="http://www.ietf.org/rfc/rfc6066.txt">RFC 6066</A>, DNS
 * hostnames are case-insensitive.  Two server hostnames are equal if,
 * and only if, they have the same name type, and the hostnames are
 * equal in a case-independent comparison.
 *
 * @param  other
 *         the other server name object to compare with.
 * @return true if, and only if, the {@code other} is considered
 *         equal to this instance
 * @apiSince 24
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for this {@code SNIHostName}.
 * <P>
 * The hash code value is generated using the case-insensitive hostname
 * of this {@code SNIHostName}.
 *
 * @return a hash code value for this {@code SNIHostName}.
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the object, including the DNS
 * hostname in this {@code SNIHostName} object.
 * <P>
 * The exact details of the representation are unspecified and subject
 * to change, but the following may be regarded as typical:
 * <pre>
 *     "type=host_name (0), value={@literal <hostname>}"
 * </pre>
 * The "{@literal <hostname>}" is an ASCII representation of the hostname,
 * which may contains A-labels.  For example, a returned value of an pseudo
 * hostname may look like:
 * <pre>
 *     "type=host_name (0), value=www.example.com"
 * </pre>
 * or
 * <pre>
 *     "type=host_name (0), value=xn--fsqu00a.xn--0zwm56d"
 * </pre>
 * <P>
 * Please NOTE that the exact details of the representation are unspecified
 * and subject to change.
 *
 * @return a string representation of the object.
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link javax.net.ssl.SNIMatcher SNIMatcher} object for {@code SNIHostName}s.
 * <P>
 * This method can be used by a server to verify the acceptable
 * {@code SNIHostName}s.  For example,
 * <pre>
 *     SNIMatcher matcher =
 *         SNIHostName.createSNIMatcher("www\\.example\\.com");
 * </pre>
 * will accept the hostname "www.example.com".
 * <pre>
 *     SNIMatcher matcher =
 *         SNIHostName.createSNIMatcher("www\\.example\\.(com|org)");
 * </pre>
 * will accept hostnames "www.example.com" and "www.example.org".
 *
 * @param  regex
 *         the <a href="{@docRoot}/java/util/regex/Pattern.html#sum">
 *         regular expression pattern</a>
 *         representing the hostname(s) to match
 * @return a {@code SNIMatcher} object for {@code SNIHostName}s
 * @throws java.lang.NullPointerException if {@code regex} is
 *         {@code null}
 * @throws java.util.regex.PatternSyntaxException if the regular expression's
 *         syntax is invalid
 * @apiSince 24
 */

public static javax.net.ssl.SNIMatcher createSNIMatcher(java.lang.String regex) { throw new RuntimeException("Stub!"); }
}

