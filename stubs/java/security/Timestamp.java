/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * This class encapsulates information about a signed timestamp.
 * It is immutable.
 * It includes the timestamp's date and time as well as information about the
 * Timestamping Authority (TSA) which generated and signed the timestamp.
 *
 * @since 1.5
 * @author Vincent Ryan
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Timestamp implements java.io.Serializable {

/**
 * Constructs a Timestamp.
 *
 * @param timestamp is the timestamp's date and time. It must not be null.
 * @param signerCertPath is the TSA's certificate path. It must not be null.
 * @throws java.lang.NullPointerException if timestamp or signerCertPath is null.
 * @apiSince 1
 */

public Timestamp(java.util.Date timestamp, java.security.cert.CertPath signerCertPath) { throw new RuntimeException("Stub!"); }

/**
 * Returns the date and time when the timestamp was generated.
 *
 * @return The timestamp's date and time.
 * @apiSince 1
 */

public java.util.Date getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Returns the certificate path for the Timestamping Authority.
 *
 * @return The TSA's certificate path.
 * @apiSince 1
 */

public java.security.cert.CertPath getSignerCertPath() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this timestamp.
 * The hash code is generated using the date and time of the timestamp
 * and the TSA's certificate path.
 *
 * @return a hash code value for this timestamp.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Tests for equality between the specified object and this
 * timestamp. Two timestamps are considered equal if the date and time of
 * their timestamp's and their signer's certificate paths are equal.
 *
 * @param obj the object to test for equality with this timestamp.
 *
 * @return true if the timestamp are considered equal, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this timestamp.
 *
 * @return A string comprising the date and time of the timestamp and
 *         its signer's certificate.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

