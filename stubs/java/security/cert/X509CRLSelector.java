/*
 * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;
import javax.security.auth.x500.X500Principal;
import java.io.IOException;

/**
 * A {@code CRLSelector} that selects {@code X509CRLs} that
 * match all specified criteria. This class is particularly useful when
 * selecting CRLs from a {@code CertStore} to check revocation status
 * of a particular certificate.
 * <p>
 * When first constructed, an {@code X509CRLSelector} has no criteria
 * enabled and each of the {@code get} methods return a default
 * value ({@code null}). Therefore, the {@link #match match} method
 * would return {@code true} for any {@code X509CRL}. Typically,
 * several criteria are enabled (by calling {@link #setIssuers setIssuers}
 * or {@link #setDateAndTime setDateAndTime}, for instance) and then the
 * {@code X509CRLSelector} is passed to
 * {@link java.security.cert.CertStore#getCRLs CertStore#getCRLs} or some similar
 * method.
 * <p>
 * Please refer to <a href="http://www.ietf.org/rfc/rfc3280.txt">RFC 3280:
 * Internet X.509 Public Key Infrastructure Certificate and CRL Profile</a>
 * for definitions of the X.509 CRL fields and extensions mentioned below.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see java.security.cert.CRLSelector
 * @see java.security.cert.X509CRL
 *
 * @since       1.4
 * @author      Steve Hanna
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class X509CRLSelector implements java.security.cert.CRLSelector {

/**
 * Creates an {@code X509CRLSelector}. Initially, no criteria are set
 * so any {@code X509CRL} will match.
 * @apiSince 1
 */

public X509CRLSelector() { throw new RuntimeException("Stub!"); }

/**
 * Sets the issuerNames criterion. The issuer distinguished name in the
 * {@code X509CRL} must match at least one of the specified
 * distinguished names. If {@code null}, any issuer distinguished name
 * will do.
 * <p>
 * This method allows the caller to specify, with a single method call,
 * the complete set of issuer names which {@code X509CRLs} may contain.
 * The specified value replaces the previous value for the issuerNames
 * criterion.
 * <p>
 * The {@code names} parameter (if not {@code null}) is a
 * {@code Collection} of {@code X500Principal}s.
 * <p>
 * Note that the {@code names} parameter can contain duplicate
 * distinguished names, but they may be removed from the
 * {@code Collection} of names returned by the
 * {@link #getIssuers getIssuers} method.
 * <p>
 * Note that a copy is performed on the {@code Collection} to
 * protect against subsequent modifications.
 *
 * @param issuers a {@code Collection} of X500Principals
 *   (or {@code null})
 * @see #getIssuers
 * @since 1.5
 * @apiSince 1
 */

public void setIssuers(java.util.Collection<javax.security.auth.x500.X500Principal> issuers) { throw new RuntimeException("Stub!"); }

/**
 * <strong>Note:</strong> use {@linkplain #setIssuers(java.util.Collection)} instead
 * or only specify the byte array form of distinguished names when using
 * this method. See {@link #addIssuerName(java.lang.String)} for more information.
 * <p>
 * Sets the issuerNames criterion. The issuer distinguished name in the
 * {@code X509CRL} must match at least one of the specified
 * distinguished names. If {@code null}, any issuer distinguished name
 * will do.
 * <p>
 * This method allows the caller to specify, with a single method call,
 * the complete set of issuer names which {@code X509CRLs} may contain.
 * The specified value replaces the previous value for the issuerNames
 * criterion.
 * <p>
 * The {@code names} parameter (if not {@code null}) is a
 * {@code Collection} of names. Each name is a {@code String}
 * or a byte array representing a distinguished name (in
 * <a href="http://www.ietf.org/rfc/rfc2253.txt">RFC 2253</a> or
 * ASN.1 DER encoded form, respectively). If {@code null} is supplied
 * as the value for this argument, no issuerNames check will be performed.
 * <p>
 * Note that the {@code names} parameter can contain duplicate
 * distinguished names, but they may be removed from the
 * {@code Collection} of names returned by the
 * {@link #getIssuerNames getIssuerNames} method.
 * <p>
 * If a name is specified as a byte array, it should contain a single DER
 * encoded distinguished name, as defined in X.501. The ASN.1 notation for
 * this structure is as follows.
 * <pre>{@code
 * Name ::= CHOICE {
 *   RDNSequence }
 *
 * RDNSequence ::= SEQUENCE OF RelativeDistinguishedName
 *
 * RelativeDistinguishedName ::=
 *   SET SIZE (1 .. MAX) OF AttributeTypeAndValue
 *
 * AttributeTypeAndValue ::= SEQUENCE {
 *   type     AttributeType,
 *   value    AttributeValue }
 *
 * AttributeType ::= OBJECT IDENTIFIER
 *
 * AttributeValue ::= ANY DEFINED BY AttributeType
 * ....
 * DirectoryString ::= CHOICE {
 *       teletexString           TeletexString (SIZE (1..MAX)),
 *       printableString         PrintableString (SIZE (1..MAX)),
 *       universalString         UniversalString (SIZE (1..MAX)),
 *       utf8String              UTF8String (SIZE (1.. MAX)),
 *       bmpString               BMPString (SIZE (1..MAX)) }
 * }</pre>
 * <p>
 * Note that a deep copy is performed on the {@code Collection} to
 * protect against subsequent modifications.
 *
 * @param names a {@code Collection} of names (or {@code null})
 * @throws java.io.IOException if a parsing error occurs
 * @see #getIssuerNames
 * @apiSince 1
 */

public void setIssuerNames(java.util.Collection<?> names) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Adds a name to the issuerNames criterion. The issuer distinguished
 * name in the {@code X509CRL} must match at least one of the specified
 * distinguished names.
 * <p>
 * This method allows the caller to add a name to the set of issuer names
 * which {@code X509CRLs} may contain. The specified name is added to
 * any previous value for the issuerNames criterion.
 * If the specified name is a duplicate, it may be ignored.
 *
 * @param issuer the issuer as X500Principal
 * @since 1.5
 * @apiSince 1
 */

public void addIssuer(javax.security.auth.x500.X500Principal issuer) { throw new RuntimeException("Stub!"); }

/**
 * <strong>Denigrated</strong>, use
 * {@linkplain #addIssuer(javax.security.auth.x500.X500Principal)} or
 * {@linkplain #addIssuerName(byte[])} instead. This method should not be
 * relied on as it can fail to match some CRLs because of a loss of
 * encoding information in the RFC 2253 String form of some distinguished
 * names.
 * <p>
 * Adds a name to the issuerNames criterion. The issuer distinguished
 * name in the {@code X509CRL} must match at least one of the specified
 * distinguished names.
 * <p>
 * This method allows the caller to add a name to the set of issuer names
 * which {@code X509CRLs} may contain. The specified name is added to
 * any previous value for the issuerNames criterion.
 * If the specified name is a duplicate, it may be ignored.
 *
 * @param name the name in RFC 2253 form
 * @throws java.io.IOException if a parsing error occurs
 * @apiSince 1
 */

public void addIssuerName(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Adds a name to the issuerNames criterion. The issuer distinguished
 * name in the {@code X509CRL} must match at least one of the specified
 * distinguished names.
 * <p>
 * This method allows the caller to add a name to the set of issuer names
 * which {@code X509CRLs} may contain. The specified name is added to
 * any previous value for the issuerNames criterion. If the specified name
 * is a duplicate, it may be ignored.
 * If a name is specified as a byte array, it should contain a single DER
 * encoded distinguished name, as defined in X.501. The ASN.1 notation for
 * this structure is as follows.
 * <p>
 * The name is provided as a byte array. This byte array should contain
 * a single DER encoded distinguished name, as defined in X.501. The ASN.1
 * notation for this structure appears in the documentation for
 * {@link #setIssuerNames setIssuerNames(java.util.Collection)}.
 * <p>
 * Note that the byte array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param name a byte array containing the name in ASN.1 DER encoded form
 * @throws java.io.IOException if a parsing error occurs
 * @apiSince 1
 */

public void addIssuerName(byte[] name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the minCRLNumber criterion. The {@code X509CRL} must have a
 * CRL number extension whose value is greater than or equal to the
 * specified value. If {@code null}, no minCRLNumber check will be
 * done.
 *
 * @param minCRL the minimum CRL number accepted (or {@code null})
 * @apiSince 1
 */

public void setMinCRLNumber(java.math.BigInteger minCRL) { throw new RuntimeException("Stub!"); }

/**
 * Sets the maxCRLNumber criterion. The {@code X509CRL} must have a
 * CRL number extension whose value is less than or equal to the
 * specified value. If {@code null}, no maxCRLNumber check will be
 * done.
 *
 * @param maxCRL the maximum CRL number accepted (or {@code null})
 * @apiSince 1
 */

public void setMaxCRLNumber(java.math.BigInteger maxCRL) { throw new RuntimeException("Stub!"); }

/**
 * Sets the dateAndTime criterion. The specified date must be
 * equal to or later than the value of the thisUpdate component
 * of the {@code X509CRL} and earlier than the value of the
 * nextUpdate component. There is no match if the {@code X509CRL}
 * does not contain a nextUpdate component.
 * If {@code null}, no dateAndTime check will be done.
 * <p>
 * Note that the {@code Date} supplied here is cloned to protect
 * against subsequent modifications.
 *
 * @param dateAndTime the {@code Date} to match against
 *                    (or {@code null})
 * @see #getDateAndTime
 * @apiSince 1
 */

public void setDateAndTime(java.util.Date dateAndTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets the certificate being checked. This is not a criterion. Rather,
 * it is optional information that may help a {@code CertStore}
 * find CRLs that would be relevant when checking revocation for the
 * specified certificate. If {@code null} is specified, then no
 * such optional information is provided.
 *
 * @param cert the {@code X509Certificate} being checked
 *             (or {@code null})
 * @see #getCertificateChecking
 * @apiSince 1
 */

public void setCertificateChecking(java.security.cert.X509Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Returns the issuerNames criterion. The issuer distinguished
 * name in the {@code X509CRL} must match at least one of the specified
 * distinguished names. If the value returned is {@code null}, any
 * issuer distinguished name will do.
 * <p>
 * If the value returned is not {@code null}, it is a
 * unmodifiable {@code Collection} of {@code X500Principal}s.
 *
 * @return an unmodifiable {@code Collection} of names
 *   (or {@code null})
 * @see #setIssuers
 * @since 1.5
 * @apiSince 1
 */

public java.util.Collection<javax.security.auth.x500.X500Principal> getIssuers() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the issuerNames criterion. The issuer distinguished
 * name in the {@code X509CRL} must match at least one of the specified
 * distinguished names. If the value returned is {@code null}, any
 * issuer distinguished name will do.
 * <p>
 * If the value returned is not {@code null}, it is a
 * {@code Collection} of names. Each name is a {@code String}
 * or a byte array representing a distinguished name (in RFC 2253 or
 * ASN.1 DER encoded form, respectively).  Note that the
 * {@code Collection} returned may contain duplicate names.
 * <p>
 * If a name is specified as a byte array, it should contain a single DER
 * encoded distinguished name, as defined in X.501. The ASN.1 notation for
 * this structure is given in the documentation for
 * {@link #setIssuerNames setIssuerNames(java.util.Collection)}.
 * <p>
 * Note that a deep copy is performed on the {@code Collection} to
 * protect against subsequent modifications.
 *
 * @return a {@code Collection} of names (or {@code null})
 * @see #setIssuerNames
 * @apiSince 1
 */

public java.util.Collection<java.lang.Object> getIssuerNames() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minCRLNumber criterion. The {@code X509CRL} must have a
 * CRL number extension whose value is greater than or equal to the
 * specified value. If {@code null}, no minCRLNumber check will be done.
 *
 * @return the minimum CRL number accepted (or {@code null})
 * @apiSince 1
 */

public java.math.BigInteger getMinCRL() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maxCRLNumber criterion. The {@code X509CRL} must have a
 * CRL number extension whose value is less than or equal to the
 * specified value. If {@code null}, no maxCRLNumber check will be
 * done.
 *
 * @return the maximum CRL number accepted (or {@code null})
 * @apiSince 1
 */

public java.math.BigInteger getMaxCRL() { throw new RuntimeException("Stub!"); }

/**
 * Returns the dateAndTime criterion. The specified date must be
 * equal to or later than the value of the thisUpdate component
 * of the {@code X509CRL} and earlier than the value of the
 * nextUpdate component. There is no match if the
 * {@code X509CRL} does not contain a nextUpdate component.
 * If {@code null}, no dateAndTime check will be done.
 * <p>
 * Note that the {@code Date} returned is cloned to protect against
 * subsequent modifications.
 *
 * @return the {@code Date} to match against (or {@code null})
 * @see #setDateAndTime
 * @apiSince 1
 */

public java.util.Date getDateAndTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the certificate being checked. This is not a criterion. Rather,
 * it is optional information that may help a {@code CertStore}
 * find CRLs that would be relevant when checking revocation for the
 * specified certificate. If the value returned is {@code null}, then
 * no such optional information is provided.
 *
 * @return the certificate being checked (or {@code null})
 * @see #setCertificateChecking
 * @apiSince 1
 */

public java.security.cert.X509Certificate getCertificateChecking() { throw new RuntimeException("Stub!"); }

/**
 * Returns a printable representation of the {@code X509CRLSelector}.
 *
 * @return a {@code String} describing the contents of the
 *         {@code X509CRLSelector}.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Decides whether a {@code CRL} should be selected.
 *
 * @param crl the {@code CRL} to be checked
 * @return {@code true} if the {@code CRL} should be selected,
 *         {@code false} otherwise
 * @apiSince 1
 */

public boolean match(java.security.cert.CRL crl) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this object.
 *
 * @return the copy
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }
}

