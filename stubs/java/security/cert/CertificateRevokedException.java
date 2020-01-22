/*
 * Copyright (c) 2007, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.security.auth.x500.X500Principal;
import java.util.Date;

/**
 * An exception that indicates an X.509 certificate is revoked. A
 * {@code CertificateRevokedException} contains additional information
 * about the revoked certificate, such as the date on which the
 * certificate was revoked and the reason it was revoked.
 *
 * @author Sean Mullan
 * @since 1.7
 * @see java.security.cert.CertPathValidatorException
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CertificateRevokedException extends java.security.cert.CertificateException {

/**
 * Constructs a {@code CertificateRevokedException} with
 * the specified revocation date, reason code, authority name, and map
 * of extensions.
 *
 * @param revocationDate the date on which the certificate was revoked. The
 *    date is copied to protect against subsequent modification.
 * @param reason the revocation reason
 * @param extensions a map of X.509 Extensions. Each key is an OID String
 *    that maps to the corresponding Extension. The map is copied to
 *    prevent subsequent modification.
 * @param authority the {@code X500Principal} that represents the name
 *    of the authority that signed the certificate's revocation status
 *    information
 * @throws java.lang.NullPointerException if {@code revocationDate},
 *    {@code reason}, {@code authority}, or
 *    {@code extensions} is {@code null}
 * @apiSince 24
 */

public CertificateRevokedException(java.util.Date revocationDate, java.security.cert.CRLReason reason, javax.security.auth.x500.X500Principal authority, java.util.Map<java.lang.String,java.security.cert.Extension> extensions) { throw new RuntimeException("Stub!"); }

/**
 * Returns the date on which the certificate was revoked. A new copy is
 * returned each time the method is invoked to protect against subsequent
 * modification.
 *
 * @return the revocation date
 * @apiSince 24
 */

public java.util.Date getRevocationDate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the reason the certificate was revoked.
 *
 * @return the revocation reason
 * @apiSince 24
 */

public java.security.cert.CRLReason getRevocationReason() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the authority that signed the certificate's
 * revocation status information.
 *
 * @return the {@code X500Principal} that represents the name of the
 *     authority that signed the certificate's revocation status information
 * @apiSince 24
 */

public javax.security.auth.x500.X500Principal getAuthorityName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the invalidity date, as specified in the Invalidity Date
 * extension of this {@code CertificateRevokedException}. The
 * invalidity date is the date on which it is known or suspected that the
 * private key was compromised or that the certificate otherwise became
 * invalid. This implementation calls {@code getExtensions()} and
 * checks the returned map for an entry for the Invalidity Date extension
 * OID ("2.5.29.24"). If found, it returns the invalidity date in the
 * extension; otherwise null. A new Date object is returned each time the
 * method is invoked to protect against subsequent modification.
 *
 * @return the invalidity date, or {@code null} if not specified
 * @apiSince 24
 */

public java.util.Date getInvalidityDate() { throw new RuntimeException("Stub!"); }

/**
 * Returns a map of X.509 extensions containing additional information
 * about the revoked certificate, such as the Invalidity Date
 * Extension. Each key is an OID String that maps to the corresponding
 * Extension.
 *
 * @return an unmodifiable map of X.509 extensions, or an empty map
 *    if there are no extensions
 * @apiSince 24
 */

public java.util.Map<java.lang.String,java.security.cert.Extension> getExtensions() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }
}

