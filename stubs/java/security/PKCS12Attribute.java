/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.security;

import java.util.Arrays;

/**
 * An attribute associated with a PKCS12 keystore entry.
 * The attribute name is an ASN.1 Object Identifier and the attribute
 * value is a set of ASN.1 types.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PKCS12Attribute implements java.security.KeyStore.Entry.Attribute {

/**
 * Constructs a PKCS12 attribute from its name and value.
 * The name is an ASN.1 Object Identifier represented as a list of
 * dot-separated integers.
 * A string value is represented as the string itself.
 * A binary value is represented as a string of colon-separated
 * pairs of hexadecimal digits.
 * Multi-valued attributes are represented as a comma-separated
 * list of values, enclosed in square brackets. See
 * {@link java.util.Arrays#toString(java.lang.Object[]) Arrays#toString(java.lang.Object[])}.
 * <p>
 * A string value will be DER-encoded as an ASN.1 UTF8String and a
 * binary value will be DER-encoded as an ASN.1 Octet String.
 *
 * @param name the attribute's identifier
 * @param value the attribute's value
 *
 * @exception java.lang.NullPointerException if {@code name} or {@code value}
 *     is {@code null}
 * @exception java.lang.IllegalArgumentException if {@code name} or
 *     {@code value} is incorrectly formatted
 * @apiSince 26
 */

public PKCS12Attribute(java.lang.String name, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a PKCS12 attribute from its ASN.1 DER encoding.
 * The DER encoding is specified by the following ASN.1 definition:
 * <pre>
 *
 * Attribute ::= SEQUENCE {
 *     type   AttributeType,
 *     values SET OF AttributeValue
 * }
 * AttributeType ::= OBJECT IDENTIFIER
 * AttributeValue ::= ANY defined by type
 *
 * </pre>
 *
 * @param encoded the attribute's ASN.1 DER encoding. It is cloned
 *     to prevent subsequent modificaion.
 *
 * @exception java.lang.NullPointerException if {@code encoded} is
 *     {@code null}
 * @exception java.lang.IllegalArgumentException if {@code encoded} is
 *     incorrectly formatted
 * @apiSince 26
 */

public PKCS12Attribute(byte[] encoded) { throw new RuntimeException("Stub!"); }

/**
 * Returns the attribute's ASN.1 Object Identifier represented as a
 * list of dot-separated integers.
 *
 * @return the attribute's identifier
 * @apiSince 26
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the attribute's ASN.1 DER-encoded value as a string.
 * An ASN.1 DER-encoded value is returned in one of the following
 * {@code String} formats:
 * <ul>
 * <li> the DER encoding of a basic ASN.1 type that has a natural
 *      string representation is returned as the string itself.
 *      Such types are currently limited to BOOLEAN, INTEGER,
 *      OBJECT IDENTIFIER, UTCTime, GeneralizedTime and the
 *      following six ASN.1 string types: UTF8String,
 *      PrintableString, T61String, IA5String, BMPString and
 *      GeneralString.
 * <li> the DER encoding of any other ASN.1 type is not decoded but
 *      returned as a binary string of colon-separated pairs of
 *      hexadecimal digits.
 * </ul>
 * Multi-valued attributes are represented as a comma-separated
 * list of values, enclosed in square brackets. See
 * {@link java.util.Arrays#toString(java.lang.Object[]) Arrays#toString(java.lang.Object[])}.
 *
 * @return the attribute value's string encoding
 * @apiSince 26
 */

public java.lang.String getValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the attribute's ASN.1 DER encoding.
 *
 * @return a clone of the attribute's DER encoding
 * @apiSince 26
 */

public byte[] getEncoded() { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code PKCS12Attribute} and a specified object for
 * equality.
 *
 * @param obj the comparison object
 *
 * @return true if {@code obj} is a {@code PKCS12Attribute} and
 * their DER encodings are equal.
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hashcode for this {@code PKCS12Attribute}.
 * The hash code is computed from its DER encoding.
 *
 * @return the hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this {@code PKCS12Attribute}.
 *
 * @return a name/value pair separated by an 'equals' symbol
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

