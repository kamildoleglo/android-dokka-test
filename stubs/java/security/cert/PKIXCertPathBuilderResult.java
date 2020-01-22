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
 * path builder algorithm. All certification paths that are built and
 * returned using this algorithm are also validated according to the PKIX
 * certification path validation algorithm.
 *
 * <p>Instances of {@code PKIXCertPathBuilderResult} are returned by
 * the {@code build} method of {@code CertPathBuilder}
 * objects implementing the PKIX algorithm.
 *
 * <p>All {@code PKIXCertPathBuilderResult} objects contain the
 * certification path constructed by the build algorithm, the
 * valid policy tree and subject public key resulting from the build
 * algorithm, and a {@code TrustAnchor} describing the certification
 * authority (CA) that served as a trust anchor for the certification path.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see java.security.cert.CertPathBuilderResult
 *
 * @since       1.4
 * @author      Anne Anderson
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PKIXCertPathBuilderResult extends java.security.cert.PKIXCertPathValidatorResult implements java.security.cert.CertPathBuilderResult {

/**
 * Creates an instance of {@code PKIXCertPathBuilderResult}
 * containing the specified parameters.
 *
 * @param certPath the validated {@code CertPath}
 * @param trustAnchor a {@code TrustAnchor} describing the CA that
 * served as a trust anchor for the certification path
 * @param policyTree the immutable valid policy tree, or {@code null}
 * if there are no valid policies
 * @param subjectPublicKey the public key of the subject
 * @throws java.lang.NullPointerException if the {@code certPath},
 * {@code trustAnchor} or {@code subjectPublicKey} parameters
 * are {@code null}
 * @apiSince 1
 */

public PKIXCertPathBuilderResult(java.security.cert.CertPath certPath, java.security.cert.TrustAnchor trustAnchor, java.security.cert.PolicyNode policyTree, java.security.PublicKey subjectPublicKey) { super(null, null, null); throw new RuntimeException("Stub!"); }

/**
 * Returns the built and validated certification path. The
 * {@code CertPath} object does not include the trust anchor.
 * Instead, use the {@link #getTrustAnchor() getTrustAnchor()} method to
 * obtain the {@code TrustAnchor} that served as the trust anchor
 * for the certification path.
 *
 * @return the built and validated {@code CertPath} (never
 * {@code null})
 * @apiSince 1
 */

public java.security.cert.CertPath getCertPath() { throw new RuntimeException("Stub!"); }

/**
 * Return a printable representation of this
 * {@code PKIXCertPathBuilderResult}.
 *
 * @return a {@code String} describing the contents of this
 *         {@code PKIXCertPathBuilderResult}
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

