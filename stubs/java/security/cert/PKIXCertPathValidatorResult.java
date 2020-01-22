/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.security.cert;


/**
 * This class represents the successful result of the PKIX certification
 * path validation algorithm.
 *
 * <p>Instances of {@code PKIXCertPathValidatorResult} are returned by the
 * {@link java.security.cert.CertPathValidator#validate CertPathValidator#validate} method of
 * {@code CertPathValidator} objects implementing the PKIX algorithm.
 *
 * <p> All {@code PKIXCertPathValidatorResult} objects contain the
 * valid policy tree and subject public key resulting from the
 * validation algorithm, as well as a {@code TrustAnchor} describing
 * the certification authority (CA) that served as a trust anchor for the
 * certification path.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see java.security.cert.CertPathValidatorResult
 *
 * @since       1.4
 * @author      Yassir Elley
 * @author      Sean Mullan
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PKIXCertPathValidatorResult implements java.security.cert.CertPathValidatorResult {

/**
 * Creates an instance of {@code PKIXCertPathValidatorResult}
 * containing the specified parameters.
 *
 * @param trustAnchor a {@code TrustAnchor} describing the CA that
 * served as a trust anchor for the certification path
 * @param policyTree the immutable valid policy tree, or {@code null}
 * if there are no valid policies
 * @param subjectPublicKey the public key of the subject
 * @throws java.lang.NullPointerException if the {@code subjectPublicKey} or
 * {@code trustAnchor} parameters are {@code null}
 * @apiSince 1
 */

public PKIXCertPathValidatorResult(java.security.cert.TrustAnchor trustAnchor, java.security.cert.PolicyNode policyTree, java.security.PublicKey subjectPublicKey) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code TrustAnchor} describing the CA that served
 * as a trust anchor for the certification path.
 *
 * @return the {@code TrustAnchor} (never {@code null})
 * @apiSince 1
 */

public java.security.cert.TrustAnchor getTrustAnchor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the root node of the valid policy tree resulting from the
 * PKIX certification path validation algorithm. The
 * {@code PolicyNode} object that is returned and any objects that
 * it returns through public methods are immutable.
 *
 * <p>Most applications will not need to examine the valid policy tree.
 * They can achieve their policy processing goals by setting the
 * policy-related parameters in {@code PKIXParameters}. However, more
 * sophisticated applications, especially those that process policy
 * qualifiers, may need to traverse the valid policy tree using the
 * {@link java.security.cert.PolicyNode#getParent PolicyNode#getParent} and
 * {@link java.security.cert.PolicyNode#getChildren PolicyNode#getChildren} methods.
 *
 * @return the root node of the valid policy tree, or {@code null}
 * if there are no valid policies
 * @apiSince 1
 */

public java.security.cert.PolicyNode getPolicyTree() { throw new RuntimeException("Stub!"); }

/**
 * Returns the public key of the subject (target) of the certification
 * path, including any inherited public key parameters if applicable.
 *
 * @return the public key of the subject (never {@code null})
 * @apiSince 1
 */

public java.security.PublicKey getPublicKey() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this object.
 *
 * @return the copy
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Return a printable representation of this
 * {@code PKIXCertPathValidatorResult}.
 *
 * @return a {@code String} describing the contents of this
 *         {@code PKIXCertPathValidatorResult}
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

