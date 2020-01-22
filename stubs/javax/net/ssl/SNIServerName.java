/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


/**
 * Instances of this class represent a server name in a Server Name
 * Indication (SNI) extension.
 * <P>
 * The SNI extension is a feature that extends the SSL/TLS protocols to
 * indicate what server name the client is attempting to connect to during
 * handshaking.  See section 3, "Server Name Indication", of <A
 * HREF="http://www.ietf.org/rfc/rfc6066.txt">TLS Extensions (RFC 6066)</A>.
 * <P>
 * {@code SNIServerName} objects are immutable.  Subclasses should not provide
 * methods that can change the state of an instance once it has been created.
 *
 * @see javax.net.ssl.SSLParameters#getServerNames()
 * @see SSLParameters#setServerNames(List)
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SNIServerName {

/**
 * Creates an {@code SNIServerName} using the specified name type and
 * encoded value.
 * <P>
 * Note that the {@code encoded} byte array is cloned to protect against
 * subsequent modification.
 *
 * @param  type
 *         the type of the server name
 * @param  encoded
 *         the encoded value of the server name
 *
 * @throws java.lang.IllegalArgumentException if {@code type} is not in the range
 *         of 0 to 255, inclusive.
 * @throws java.lang.NullPointerException if {@code encoded} is null
 * @apiSince 24
 */

protected SNIServerName(int type, byte[] encoded) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name type of this server name.
 *
 * @return the name type of this server name
 * @apiSince 24
 */

public final int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the encoded server name value of this server name.
 *
 * @return a copy of the encoded server name value of this server name
 * @apiSince 24
 */

public final byte[] getEncoded() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether some other object is "equal to" this server name.
 *
 * @return true if, and only if, {@code other} is of the same class
 *         of this object, and has the same name type and
 *         encoded value as this server name.
 * @apiSince 24
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for this server name.
 * <P>
 * The hash code value is generated using the name type and encoded
 * value of this server name.
 *
 * @return a hash code value for this server name.
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this server name, including the server
 * name type and the encoded server name value in this
 * {@code SNIServerName} object.
 * <P>
 * The exact details of the representation are unspecified and subject
 * to change, but the following may be regarded as typical:
 * <pre>
 *     "type={@literal <name type>}, value={@literal <name value>}"
 * </pre>
 * <P>
 * In this class, the format of "{@literal <name type>}" is
 * "[LITERAL] (INTEGER)", where the optional "LITERAL" is the literal
 * name, and INTEGER is the integer value of the name type.  The format
 * of "{@literal <name value>}" is "XX:...:XX", where "XX" is the
 * hexadecimal digit representation of a byte value. For example, a
 * returned value of an pseudo server name may look like:
 * <pre>
 *     "type=(31), value=77:77:77:2E:65:78:61:6D:70:6C:65:2E:63:6E"
 * </pre>
 * or
 * <pre>
 *     "type=host_name (0), value=77:77:77:2E:65:78:61:6D:70:6C:65:2E:63:6E"
 * </pre>
 *
 * <P>
 * Please NOTE that the exact details of the representation are unspecified
 * and subject to change, and subclasses may override the method with
 * their own formats.
 *
 * @return a string representation of this server name
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

