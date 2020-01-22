/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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
 * The CRLReason enumeration specifies the reason that a certificate
 * is revoked, as defined in <a href="http://www.ietf.org/rfc/rfc3280.txt">
 * RFC 3280: Internet X.509 Public Key Infrastructure Certificate and CRL
 * Profile</a>.
 *
 * @author Sean Mullan
 * @since 1.7
 * @see java.security.cert.X509CRLEntry#getRevocationReason
 * @see java.security.cert.CertificateRevokedException#getRevocationReason
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum CRLReason {
/**
 * This reason indicates that it is unspecified as to why the
 * certificate has been revoked.
 * @apiSince 24
 */

UNSPECIFIED,
/**
 * This reason indicates that it is known or suspected that the
 * certificate subject's private key has been compromised. It applies
 * to end-entity certificates only.
 * @apiSince 24
 */

KEY_COMPROMISE,
/**
 * This reason indicates that it is known or suspected that the
 * certificate subject's private key has been compromised. It applies
 * to certificate authority (CA) certificates only.
 * @apiSince 24
 */

CA_COMPROMISE,
/**
 * This reason indicates that the subject's name or other information
 * has changed.
 * @apiSince 24
 */

AFFILIATION_CHANGED,
/**
 * This reason indicates that the certificate has been superseded.
 * @apiSince 24
 */

SUPERSEDED,
/**
 * This reason indicates that the certificate is no longer needed.
 * @apiSince 24
 */

CESSATION_OF_OPERATION,
/**
 * This reason indicates that the certificate has been put on hold.
 * @apiSince 24
 */

CERTIFICATE_HOLD,
/**
 * Unused reason.
 * @apiSince 24
 */

UNUSED,
/**
 * This reason indicates that the certificate was previously on hold
 * and should be removed from the CRL. It is for use with delta CRLs.
 * @apiSince 24
 */

REMOVE_FROM_CRL,
/**
 * This reason indicates that the privileges granted to the subject of
 * the certificate have been withdrawn.
 * @apiSince 24
 */

PRIVILEGE_WITHDRAWN,
/**
 * This reason indicates that it is known or suspected that the
 * certificate subject's private key has been compromised. It applies
 * to authority attribute (AA) certificates only.
 * @apiSince 24
 */

AA_COMPROMISE;
}

