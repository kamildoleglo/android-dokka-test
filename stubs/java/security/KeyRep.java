/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Standardized representation for serialized Key objects.
 *
 * <p>
 *
 * Note that a serialized Key may contain sensitive information
 * which should not be exposed in untrusted environments.  See the
 * <a href="https://docs.oracle.com/javase/8/docs/platform/serialization/spec/security.html">
 * Security Appendix</a>
 * of the Serialization Specification for more information.
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see javax.crypto.spec.SecretKeySpec
 * @see java.security.spec.X509EncodedKeySpec
 * @see java.security.spec.PKCS8EncodedKeySpec
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyRep implements java.io.Serializable {

/**
 * Construct the alternate Key class.
 *
 * <p>
 *
 * @param type either one of Type.SECRET, Type.PUBLIC, or Type.PRIVATE
 * @param algorithm the algorithm returned from
 *          {@code Key.getAlgorithm()}
 * @param format the encoding format returned from
 *          {@code Key.getFormat()}
 * @param encoded the encoded bytes returned from
 *          {@code Key.getEncoded()}
 *
 * @exception java.lang.NullPointerException
 *          if type is {@code null},
 *          if algorithm is {@code null},
 *          if format is {@code null},
 *          or if encoded is {@code null}
 * @apiSince 1
 */

public KeyRep(java.security.KeyRep.Type type, java.lang.String algorithm, java.lang.String format, byte[] encoded) { throw new RuntimeException("Stub!"); }

/**
 * Resolve the Key object.
 *
 * <p> This method supports three Type/format combinations:
 * <ul>
 * <li> Type.SECRET/"RAW" - returns a SecretKeySpec object
 * constructed using encoded key bytes and algorithm
 * <li> Type.PUBLIC/"X.509" - gets a KeyFactory instance for
 * the key algorithm, constructs an X509EncodedKeySpec with the
 * encoded key bytes, and generates a public key from the spec
 * <li> Type.PRIVATE/"PKCS#8" - gets a KeyFactory instance for
 * the key algorithm, constructs a PKCS8EncodedKeySpec with the
 * encoded key bytes, and generates a private key from the spec
 * </ul>
 *
 * <p>
 *
 * @return the resolved Key object
 *
 * @exception java.io.ObjectStreamException if the Type/format
 *  combination is unrecognized, if the algorithm, key format, or
 *  encoded key bytes are unrecognized/invalid, of if the
 *  resolution of the key fails for any reason
 * @apiSince 1
 */

protected java.lang.Object readResolve() throws java.io.ObjectStreamException { throw new RuntimeException("Stub!"); }
/**
 * Key type.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Type {
/**
 * Type for secret keys.
 * @apiSince 1
 */

SECRET,
/**
 * Type for public keys.
 * @apiSince 1
 */

PUBLIC,
/**
 * Type for private keys.
 * @apiSince 1
 */

PRIVATE;
}

}

