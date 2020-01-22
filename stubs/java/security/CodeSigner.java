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

/**
 * This class encapsulates information about a code signer.
 * It is immutable.
 *
 * @since 1.5
 * @author Vincent Ryan
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CodeSigner implements java.io.Serializable {

/**
 * Constructs a CodeSigner object.
 *
 * @param signerCertPath The signer's certificate path.
 *                       It must not be {@code null}.
 * @param timestamp A signature timestamp.
 *                  If {@code null} then no timestamp was generated
 *                  for the signature.
 * @throws java.lang.NullPointerException if {@code signerCertPath} is
 *                              {@code null}.
 * @apiSince 1
 */

public CodeSigner(java.security.cert.CertPath signerCertPath, java.security.Timestamp timestamp) { throw new RuntimeException("Stub!"); }

/**
 * Returns the signer's certificate path.
 *
 * @return A certificate path.
 * @apiSince 1
 */

public java.security.cert.CertPath getSignerCertPath() { throw new RuntimeException("Stub!"); }

/**
 * Returns the signature timestamp.
 *
 * @return The timestamp or {@code null} if none is present.
 * @apiSince 1
 */

public java.security.Timestamp getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this code signer.
 * The hash code is generated using the signer's certificate path and the
 * timestamp, if present.
 *
 * @return a hash code value for this code signer.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Tests for equality between the specified object and this
 * code signer. Two code signers are considered equal if their
 * signer certificate paths are equal and if their timestamps are equal,
 * if present in both.
 *
 * @param obj the object to test for equality with this object.
 *
 * @return true if the objects are considered equal, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this code signer.
 *
 * @return A string comprising the signer's certificate and a timestamp,
 *         if present.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

