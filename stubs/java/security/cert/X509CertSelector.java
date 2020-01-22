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

import java.util.*;
import javax.security.auth.x500.X500Principal;
import java.io.IOException;

/**
 * A {@code CertSelector} that selects {@code X509Certificates} that
 * match all specified criteria. This class is particularly useful when
 * selecting certificates from a {@code CertStore} to build a
 * PKIX-compliant certification path.
 * <p>
 * When first constructed, an {@code X509CertSelector} has no criteria
 * enabled and each of the {@code get} methods return a default value
 * ({@code null}, or {@code -1} for the {@link #getBasicConstraints
 * getBasicConstraints} method). Therefore, the {@link #match match}
 * method would return {@code true} for any {@code X509Certificate}.
 * Typically, several criteria are enabled (by calling
 * {@link #setIssuer setIssuer} or
 * {@link #setKeyUsage setKeyUsage}, for instance) and then the
 * {@code X509CertSelector} is passed to
 * {@link java.security.cert.CertStore#getCertificates CertStore#getCertificates} or some similar
 * method.
 * <p>
 * Several criteria can be enabled (by calling {@link #setIssuer setIssuer}
 * and {@link #setSerialNumber setSerialNumber},
 * for example) such that the {@code match} method
 * usually uniquely matches a single {@code X509Certificate}. We say
 * usually, since it is possible for two issuing CAs to have the same
 * distinguished name and each issue a certificate with the same serial
 * number. Other unique combinations include the issuer, subject,
 * subjectKeyIdentifier and/or the subjectPublicKey criteria.
 * <p>
 * Please refer to <a href="http://www.ietf.org/rfc/rfc3280.txt">RFC 3280:
 * Internet X.509 Public Key Infrastructure Certificate and CRL Profile</a> for
 * definitions of the X.509 certificate extensions mentioned below.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see java.security.cert.CertSelector
 * @see java.security.cert.X509Certificate
 *
 * @since       1.4
 * @author      Steve Hanna
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class X509CertSelector implements java.security.cert.CertSelector {

/**
 * Creates an {@code X509CertSelector}. Initially, no criteria are set
 * so any {@code X509Certificate} will match.
 * @apiSince 1
 */

public X509CertSelector() { throw new RuntimeException("Stub!"); }

/**
 * Sets the certificateEquals criterion. The specified
 * {@code X509Certificate} must be equal to the
 * {@code X509Certificate} passed to the {@code match} method.
 * If {@code null}, then this check is not applied.
 *
 * <p>This method is particularly useful when it is necessary to
 * match a single certificate. Although other criteria can be specified
 * in conjunction with the certificateEquals criterion, it is usually not
 * practical or necessary.
 *
 * @param cert the {@code X509Certificate} to match (or
 * {@code null})
 * @see #getCertificate
 * @apiSince 1
 */

public void setCertificate(java.security.cert.X509Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Sets the serialNumber criterion. The specified serial number
 * must match the certificate serial number in the
 * {@code X509Certificate}. If {@code null}, any certificate
 * serial number will do.
 *
 * @param serial the certificate serial number to match
 *        (or {@code null})
 * @see #getSerialNumber
 * @apiSince 1
 */

public void setSerialNumber(java.math.BigInteger serial) { throw new RuntimeException("Stub!"); }

/**
 * Sets the issuer criterion. The specified distinguished name
 * must match the issuer distinguished name in the
 * {@code X509Certificate}. If {@code null}, any issuer
 * distinguished name will do.
 *
 * @param issuer a distinguished name as X500Principal
 *                 (or {@code null})
 * @since 1.5
 * @apiSince 1
 */

public void setIssuer(javax.security.auth.x500.X500Principal issuer) { throw new RuntimeException("Stub!"); }

/**
 * <strong>Denigrated</strong>, use {@linkplain #setIssuer(javax.security.auth.x500.X500Principal)}
 * or {@linkplain #setIssuer(byte[])} instead. This method should not be
 * relied on as it can fail to match some certificates because of a loss of
 * encoding information in the
 * <a href="http://www.ietf.org/rfc/rfc2253.txt">RFC 2253</a> String form
 * of some distinguished names.
 * <p>
 * Sets the issuer criterion. The specified distinguished name
 * must match the issuer distinguished name in the
 * {@code X509Certificate}. If {@code null}, any issuer
 * distinguished name will do.
 * <p>
 * If {@code issuerDN} is not {@code null}, it should contain a
 * distinguished name, in RFC 2253 format.
 *
 * @param issuerDN a distinguished name in RFC 2253 format
 *                 (or {@code null})
 * @throws java.io.IOException if a parsing error occurs (incorrect form for DN)
 * @apiSince 1
 */

public void setIssuer(java.lang.String issuerDN) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the issuer criterion. The specified distinguished name
 * must match the issuer distinguished name in the
 * {@code X509Certificate}. If {@code null} is specified,
 * the issuer criterion is disabled and any issuer distinguished name will
 * do.
 * <p>
 * If {@code issuerDN} is not {@code null}, it should contain a
 * single DER encoded distinguished name, as defined in X.501. The ASN.1
 * notation for this structure is as follows.
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
 * Note that the byte array specified here is cloned to protect against
 * subsequent modifications.
 *
 * @param issuerDN a byte array containing the distinguished name
 *                 in ASN.1 DER encoded form (or {@code null})
 * @throws java.io.IOException if an encoding error occurs (incorrect form for DN)
 * @apiSince 1
 */

public void setIssuer(byte[] issuerDN) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the subject criterion. The specified distinguished name
 * must match the subject distinguished name in the
 * {@code X509Certificate}. If {@code null}, any subject
 * distinguished name will do.
 *
 * @param subject a distinguished name as X500Principal
 *                  (or {@code null})
 * @since 1.5
 * @apiSince 1
 */

public void setSubject(javax.security.auth.x500.X500Principal subject) { throw new RuntimeException("Stub!"); }

/**
 * <strong>Denigrated</strong>, use {@linkplain #setSubject(javax.security.auth.x500.X500Principal)}
 * or {@linkplain #setSubject(byte[])} instead. This method should not be
 * relied on as it can fail to match some certificates because of a loss of
 * encoding information in the RFC 2253 String form of some distinguished
 * names.
 * <p>
 * Sets the subject criterion. The specified distinguished name
 * must match the subject distinguished name in the
 * {@code X509Certificate}. If {@code null}, any subject
 * distinguished name will do.
 * <p>
 * If {@code subjectDN} is not {@code null}, it should contain a
 * distinguished name, in RFC 2253 format.
 *
 * @param subjectDN a distinguished name in RFC 2253 format
 *                  (or {@code null})
 * @throws java.io.IOException if a parsing error occurs (incorrect form for DN)
 * @apiSince 1
 */

public void setSubject(java.lang.String subjectDN) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the subject criterion. The specified distinguished name
 * must match the subject distinguished name in the
 * {@code X509Certificate}. If {@code null}, any subject
 * distinguished name will do.
 * <p>
 * If {@code subjectDN} is not {@code null}, it should contain a
 * single DER encoded distinguished name, as defined in X.501. For the ASN.1
 * notation for this structure, see
 * {@link #setIssuer(byte [] issuerDN) setIssuer(byte [] issuerDN)}.
 *
 * @param subjectDN a byte array containing the distinguished name in
 *                  ASN.1 DER format (or {@code null})
 * @throws java.io.IOException if an encoding error occurs (incorrect form for DN)
 * @apiSince 1
 */

public void setSubject(byte[] subjectDN) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the subjectKeyIdentifier criterion. The
 * {@code X509Certificate} must contain a SubjectKeyIdentifier
 * extension for which the contents of the extension
 * matches the specified criterion value.
 * If the criterion value is {@code null}, no
 * subjectKeyIdentifier check will be done.
 * <p>
 * If {@code subjectKeyID} is not {@code null}, it
 * should contain a single DER encoded value corresponding to the contents
 * of the extension value (not including the object identifier,
 * criticality setting, and encapsulating OCTET STRING)
 * for a SubjectKeyIdentifier extension.
 * The ASN.1 notation for this structure follows.
 *
 * <pre>{@code
 * SubjectKeyIdentifier ::= KeyIdentifier
 *
 * KeyIdentifier ::= OCTET STRING
 * }</pre>
 * <p>
 * Since the format of subject key identifiers is not mandated by
 * any standard, subject key identifiers are not parsed by the
 * {@code X509CertSelector}. Instead, the values are compared using
 * a byte-by-byte comparison.
 * <p>
 * Note that the byte array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param subjectKeyID the subject key identifier (or {@code null})
 * @see #getSubjectKeyIdentifier
 * @apiSince 1
 */

public void setSubjectKeyIdentifier(byte[] subjectKeyID) { throw new RuntimeException("Stub!"); }

/**
 * Sets the authorityKeyIdentifier criterion. The
 * {@code X509Certificate} must contain an
 * AuthorityKeyIdentifier extension for which the contents of the
 * extension value matches the specified criterion value.
 * If the criterion value is {@code null}, no
 * authorityKeyIdentifier check will be done.
 * <p>
 * If {@code authorityKeyID} is not {@code null}, it
 * should contain a single DER encoded value corresponding to the contents
 * of the extension value (not including the object identifier,
 * criticality setting, and encapsulating OCTET STRING)
 * for an AuthorityKeyIdentifier extension.
 * The ASN.1 notation for this structure follows.
 *
 * <pre>{@code
 * AuthorityKeyIdentifier ::= SEQUENCE {
 *    keyIdentifier             [0] KeyIdentifier           OPTIONAL,
 *    authorityCertIssuer       [1] GeneralNames            OPTIONAL,
 *    authorityCertSerialNumber [2] CertificateSerialNumber OPTIONAL  }
 *
 * KeyIdentifier ::= OCTET STRING
 * }</pre>
 * <p>
 * Authority key identifiers are not parsed by the
 * {@code X509CertSelector}.  Instead, the values are
 * compared using a byte-by-byte comparison.
 * <p>
 * When the {@code keyIdentifier} field of
 * {@code AuthorityKeyIdentifier} is populated, the value is
 * usually taken from the {@code SubjectKeyIdentifier} extension
 * in the issuer's certificate.  Note, however, that the result of
 * {@code X509Certificate.getExtensionValue(<SubjectKeyIdentifier Object
 * Identifier>)} on the issuer's certificate may NOT be used
 * directly as the input to {@code setAuthorityKeyIdentifier}.
 * This is because the SubjectKeyIdentifier contains
 * only a KeyIdentifier OCTET STRING, and not a SEQUENCE of
 * KeyIdentifier, GeneralNames, and CertificateSerialNumber.
 * In order to use the extension value of the issuer certificate's
 * {@code SubjectKeyIdentifier}
 * extension, it will be necessary to extract the value of the embedded
 * {@code KeyIdentifier} OCTET STRING, then DER encode this OCTET
 * STRING inside a SEQUENCE.
 * For more details on SubjectKeyIdentifier, see
 * {@link #setSubjectKeyIdentifier(byte[] subjectKeyID)}.
 * <p>
 * Note also that the byte array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param authorityKeyID the authority key identifier
 *        (or {@code null})
 * @see #getAuthorityKeyIdentifier
 * @apiSince 1
 */

public void setAuthorityKeyIdentifier(byte[] authorityKeyID) { throw new RuntimeException("Stub!"); }

/**
 * Sets the certificateValid criterion. The specified date must fall
 * within the certificate validity period for the
 * {@code X509Certificate}. If {@code null}, no certificateValid
 * check will be done.
 * <p>
 * Note that the {@code Date} supplied here is cloned to protect
 * against subsequent modifications.
 *
 * @param certValid the {@code Date} to check (or {@code null})
 * @see #getCertificateValid
 * @apiSince 1
 */

public void setCertificateValid(java.util.Date certValid) { throw new RuntimeException("Stub!"); }

/**
 * Sets the privateKeyValid criterion. The specified date must fall
 * within the private key validity period for the
 * {@code X509Certificate}. If {@code null}, no privateKeyValid
 * check will be done.
 * <p>
 * Note that the {@code Date} supplied here is cloned to protect
 * against subsequent modifications.
 *
 * @param privateKeyValid the {@code Date} to check (or
 *                        {@code null})
 * @see #getPrivateKeyValid
 * @apiSince 1
 */

public void setPrivateKeyValid(java.util.Date privateKeyValid) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subjectPublicKeyAlgID criterion. The
 * {@code X509Certificate} must contain a subject public key
 * with the specified algorithm. If {@code null}, no
 * subjectPublicKeyAlgID check will be done.
 *
 * @param oid The object identifier (OID) of the algorithm to check
 *            for (or {@code null}). An OID is represented by a
 *            set of nonnegative integers separated by periods.
 * @throws java.io.IOException if the OID is invalid, such as
 * the first component being not 0, 1 or 2 or the second component
 * being greater than 39.
 *
 * @see #getSubjectPublicKeyAlgID
 * @apiSince 1
 */

public void setSubjectPublicKeyAlgID(java.lang.String oid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the subjectPublicKey criterion. The
 * {@code X509Certificate} must contain the specified subject public
 * key. If {@code null}, no subjectPublicKey check will be done.
 *
 * @param key the subject public key to check for (or {@code null})
 * @see #getSubjectPublicKey
 * @apiSince 1
 */

public void setSubjectPublicKey(java.security.PublicKey key) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subjectPublicKey criterion. The {@code X509Certificate}
 * must contain the specified subject public key. If {@code null},
 * no subjectPublicKey check will be done.
 * <p>
 * Because this method allows the public key to be specified as a byte
 * array, it may be used for unknown key types.
 * <p>
 * If {@code key} is not {@code null}, it should contain a
 * single DER encoded SubjectPublicKeyInfo structure, as defined in X.509.
 * The ASN.1 notation for this structure is as follows.
 * <pre>{@code
 * SubjectPublicKeyInfo  ::=  SEQUENCE  {
 *   algorithm            AlgorithmIdentifier,
 *   subjectPublicKey     BIT STRING  }
 *
 * AlgorithmIdentifier  ::=  SEQUENCE  {
 *   algorithm               OBJECT IDENTIFIER,
 *   parameters              ANY DEFINED BY algorithm OPTIONAL  }
 *                              -- contains a value of the type
 *                              -- registered for use with the
 *                              -- algorithm object identifier value
 * }</pre>
 * <p>
 * Note that the byte array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param key a byte array containing the subject public key in ASN.1 DER
 *            form (or {@code null})
 * @throws java.io.IOException if an encoding error occurs (incorrect form for
 * subject public key)
 * @see #getSubjectPublicKey
 * @apiSince 1
 */

public void setSubjectPublicKey(byte[] key) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the keyUsage criterion. The {@code X509Certificate}
 * must allow the specified keyUsage values. If {@code null}, no
 * keyUsage check will be done. Note that an {@code X509Certificate}
 * that has no keyUsage extension implicitly allows all keyUsage values.
 * <p>
 * Note that the boolean array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param keyUsage a boolean array in the same format as the boolean
 *                 array returned by
 * {@link java.security.cert.X509Certificate#getKeyUsage() X509Certificate#getKeyUsage()}.
 *                 Or {@code null}.
 * @see #getKeyUsage
 * @apiSince 1
 */

public void setKeyUsage(boolean[] keyUsage) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extendedKeyUsage criterion. The {@code X509Certificate}
 * must allow the specified key purposes in its extended key usage
 * extension. If {@code keyPurposeSet} is empty or {@code null},
 * no extendedKeyUsage check will be done. Note that an
 * {@code X509Certificate} that has no extendedKeyUsage extension
 * implicitly allows all key purposes.
 * <p>
 * Note that the {@code Set} is cloned to protect against
 * subsequent modifications.
 *
 * @param keyPurposeSet a {@code Set} of key purpose OIDs in string
 * format (or {@code null}). Each OID is represented by a set of
 * nonnegative integers separated by periods.
 * @throws java.io.IOException if the OID is invalid, such as
 * the first component being not 0, 1 or 2 or the second component
 * being greater than 39.
 * @see #getExtendedKeyUsage
 * @apiSince 1
 */

public void setExtendedKeyUsage(java.util.Set<java.lang.String> keyPurposeSet) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Enables/disables matching all of the subjectAlternativeNames
 * specified in the {@link #setSubjectAlternativeNames
 * setSubjectAlternativeNames} or {@link #addSubjectAlternativeName
 * addSubjectAlternativeName} methods. If enabled,
 * the {@code X509Certificate} must contain all of the
 * specified subject alternative names. If disabled, the
 * {@code X509Certificate} must contain at least one of the
 * specified subject alternative names.
 *
 * <p>The matchAllNames flag is {@code true} by default.
 *
 * @param matchAllNames if {@code true}, the flag is enabled;
 * if {@code false}, the flag is disabled.
 * @see #getMatchAllSubjectAltNames
 * @apiSince 1
 */

public void setMatchAllSubjectAltNames(boolean matchAllNames) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subjectAlternativeNames criterion. The
 * {@code X509Certificate} must contain all or at least one of the
 * specified subjectAlternativeNames, depending on the value of
 * the matchAllNames flag (see {@link #setMatchAllSubjectAltNames
 * setMatchAllSubjectAltNames}).
 * <p>
 * This method allows the caller to specify, with a single method call,
 * the complete set of subject alternative names for the
 * subjectAlternativeNames criterion. The specified value replaces
 * the previous value for the subjectAlternativeNames criterion.
 * <p>
 * The {@code names} parameter (if not {@code null}) is a
 * {@code Collection} with one
 * entry for each name to be included in the subject alternative name
 * criterion. Each entry is a {@code List} whose first entry is an
 * {@code Integer} (the name type, 0-8) and whose second
 * entry is a {@code String} or a byte array (the name, in
 * string or ASN.1 DER encoded form, respectively).
 * There can be multiple names of the same type. If {@code null}
 * is supplied as the value for this argument, no
 * subjectAlternativeNames check will be performed.
 * <p>
 * Each subject alternative name in the {@code Collection}
 * may be specified either as a {@code String} or as an ASN.1 encoded
 * byte array. For more details about the formats used, see
 * {@link #addSubjectAlternativeName(int type,java.lang.String)
 * addSubjectAlternativeName(int type, String name)} and
 * {@link #addSubjectAlternativeName(int type,byte [] name)
 * addSubjectAlternativeName(int type, byte [] name)}.
 * <p>
 * <strong>Note:</strong> for distinguished names, specify the byte
 * array form instead of the String form. See the note in
 * {@link #addSubjectAlternativeName(int,java.lang.String)} for more information.
 * <p>
 * Note that the {@code names} parameter can contain duplicate
 * names (same name and name type), but they may be removed from the
 * {@code Collection} of names returned by the
 * {@link #getSubjectAlternativeNames getSubjectAlternativeNames} method.
 * <p>
 * Note that a deep copy is performed on the {@code Collection} to
 * protect against subsequent modifications.
 *
 * @param names a {@code Collection} of names (or {@code null})
 * @throws java.io.IOException if a parsing error occurs
 * @see #getSubjectAlternativeNames
 * @apiSince 1
 */

public void setSubjectAlternativeNames(java.util.Collection<java.util.List<?>> names) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Adds a name to the subjectAlternativeNames criterion. The
 * {@code X509Certificate} must contain all or at least one
 * of the specified subjectAlternativeNames, depending on the value of
 * the matchAllNames flag (see {@link #setMatchAllSubjectAltNames
 * setMatchAllSubjectAltNames}).
 * <p>
 * This method allows the caller to add a name to the set of subject
 * alternative names.
 * The specified name is added to any previous value for the
 * subjectAlternativeNames criterion. If the specified name is a
 * duplicate, it may be ignored.
 * <p>
 * The name is provided in string format.
 * <a href="http://www.ietf.org/rfc/rfc822.txt">RFC 822</a>, DNS, and URI
 * names use the well-established string formats for those types (subject to
 * the restrictions included in RFC 3280). IPv4 address names are
 * supplied using dotted quad notation. OID address names are represented
 * as a series of nonnegative integers separated by periods. And
 * directory names (distinguished names) are supplied in RFC 2253 format.
 * No standard string format is defined for otherNames, X.400 names,
 * EDI party names, IPv6 address names, or any other type of names. They
 * should be specified using the
 * {@link #addSubjectAlternativeName(int type,byte [] name)
 * addSubjectAlternativeName(int type, byte [] name)}
 * method.
 * <p>
 * <strong>Note:</strong> for distinguished names, use
 * {@linkplain #addSubjectAlternativeName(int,byte[])} instead.
 * This method should not be relied on as it can fail to match some
 * certificates because of a loss of encoding information in the RFC 2253
 * String form of some distinguished names.
 *
 * @param type the name type (0-8, as specified in
 *             RFC 3280, section 4.2.1.7)
 * @param name the name in string form (not {@code null})
 * @throws java.io.IOException if a parsing error occurs
 * @apiSince 1
 */

public void addSubjectAlternativeName(int type, java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Adds a name to the subjectAlternativeNames criterion. The
 * {@code X509Certificate} must contain all or at least one
 * of the specified subjectAlternativeNames, depending on the value of
 * the matchAllNames flag (see {@link #setMatchAllSubjectAltNames
 * setMatchAllSubjectAltNames}).
 * <p>
 * This method allows the caller to add a name to the set of subject
 * alternative names.
 * The specified name is added to any previous value for the
 * subjectAlternativeNames criterion. If the specified name is a
 * duplicate, it may be ignored.
 * <p>
 * The name is provided as a byte array. This byte array should contain
 * the DER encoded name, as it would appear in the GeneralName structure
 * defined in RFC 3280 and X.509. The encoded byte array should only contain
 * the encoded value of the name, and should not include the tag associated
 * with the name in the GeneralName structure. The ASN.1 definition of this
 * structure appears below.
 * <pre>{@code
 *  GeneralName ::= CHOICE {
 *       otherName                       [0]     OtherName,
 *       rfc822Name                      [1]     IA5String,
 *       dNSName                         [2]     IA5String,
 *       x400Address                     [3]     ORAddress,
 *       directoryName                   [4]     Name,
 *       ediPartyName                    [5]     EDIPartyName,
 *       uniformResourceIdentifier       [6]     IA5String,
 *       iPAddress                       [7]     OCTET STRING,
 *       registeredID                    [8]     OBJECT IDENTIFIER}
 * }</pre>
 * <p>
 * Note that the byte array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param type the name type (0-8, as listed above)
 * @param name a byte array containing the name in ASN.1 DER encoded form
 * @throws java.io.IOException if a parsing error occurs
 * @apiSince 1
 */

public void addSubjectAlternativeName(int type, byte[] name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the name constraints criterion. The {@code X509Certificate}
 * must have subject and subject alternative names that
 * meet the specified name constraints.
 * <p>
 * The name constraints are specified as a byte array. This byte array
 * should contain the DER encoded form of the name constraints, as they
 * would appear in the NameConstraints structure defined in RFC 3280
 * and X.509. The ASN.1 definition of this structure appears below.
 *
 * <pre>{@code
 *  NameConstraints ::= SEQUENCE {
 *       permittedSubtrees       [0]     GeneralSubtrees OPTIONAL,
 *       excludedSubtrees        [1]     GeneralSubtrees OPTIONAL }
 *
 *  GeneralSubtrees ::= SEQUENCE SIZE (1..MAX) OF GeneralSubtree
 *
 *  GeneralSubtree ::= SEQUENCE {
 *       base                    GeneralName,
 *       minimum         [0]     BaseDistance DEFAULT 0,
 *       maximum         [1]     BaseDistance OPTIONAL }
 *
 *  BaseDistance ::= INTEGER (0..MAX)
 *
 *  GeneralName ::= CHOICE {
 *       otherName                       [0]     OtherName,
 *       rfc822Name                      [1]     IA5String,
 *       dNSName                         [2]     IA5String,
 *       x400Address                     [3]     ORAddress,
 *       directoryName                   [4]     Name,
 *       ediPartyName                    [5]     EDIPartyName,
 *       uniformResourceIdentifier       [6]     IA5String,
 *       iPAddress                       [7]     OCTET STRING,
 *       registeredID                    [8]     OBJECT IDENTIFIER}
 * }</pre>
 * <p>
 * Note that the byte array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param bytes a byte array containing the ASN.1 DER encoding of
 *              a NameConstraints extension to be used for checking
 *              name constraints. Only the value of the extension is
 *              included, not the OID or criticality flag. Can be
 *              {@code null},
 *              in which case no name constraints check will be performed.
 * @throws java.io.IOException if a parsing error occurs
 * @see #getNameConstraints
 * @apiSince 1
 */

public void setNameConstraints(byte[] bytes) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the basic constraints constraint. If the value is greater than or
 * equal to zero, {@code X509Certificates} must include a
 * basicConstraints extension with
 * a pathLen of at least this value. If the value is -2, only end-entity
 * certificates are accepted. If the value is -1, no check is done.
 * <p>
 * This constraint is useful when building a certification path forward
 * (from the target toward the trust anchor. If a partial path has been
 * built, any candidate certificate must have a maxPathLen value greater
 * than or equal to the number of certificates in the partial path.
 *
 * @param minMaxPathLen the value for the basic constraints constraint
 * @throws java.lang.IllegalArgumentException if the value is less than -2
 * @see #getBasicConstraints
 * @apiSince 1
 */

public void setBasicConstraints(int minMaxPathLen) { throw new RuntimeException("Stub!"); }

/**
 * Sets the policy constraint. The {@code X509Certificate} must
 * include at least one of the specified policies in its certificate
 * policies extension. If {@code certPolicySet} is empty, then the
 * {@code X509Certificate} must include at least some specified policy
 * in its certificate policies extension. If {@code certPolicySet} is
 * {@code null}, no policy check will be performed.
 * <p>
 * Note that the {@code Set} is cloned to protect against
 * subsequent modifications.
 *
 * @param certPolicySet a {@code Set} of certificate policy OIDs in
 *                      string format (or {@code null}). Each OID is
 *                      represented by a set of nonnegative integers
 *                    separated by periods.
 * @throws java.io.IOException if a parsing error occurs on the OID such as
 * the first component is not 0, 1 or 2 or the second component is
 * greater than 39.
 * @see #getPolicy
 * @apiSince 1
 */

public void setPolicy(java.util.Set<java.lang.String> certPolicySet) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the pathToNames criterion. The {@code X509Certificate} must
 * not include name constraints that would prohibit building a
 * path to the specified names.
 * <p>
 * This method allows the caller to specify, with a single method call,
 * the complete set of names which the {@code X509Certificates}'s
 * name constraints must permit. The specified value replaces
 * the previous value for the pathToNames criterion.
 * <p>
 * This constraint is useful when building a certification path forward
 * (from the target toward the trust anchor. If a partial path has been
 * built, any candidate certificate must not include name constraints that
 * would prohibit building a path to any of the names in the partial path.
 * <p>
 * The {@code names} parameter (if not {@code null}) is a
 * {@code Collection} with one
 * entry for each name to be included in the pathToNames
 * criterion. Each entry is a {@code List} whose first entry is an
 * {@code Integer} (the name type, 0-8) and whose second
 * entry is a {@code String} or a byte array (the name, in
 * string or ASN.1 DER encoded form, respectively).
 * There can be multiple names of the same type. If {@code null}
 * is supplied as the value for this argument, no
 * pathToNames check will be performed.
 * <p>
 * Each name in the {@code Collection}
 * may be specified either as a {@code String} or as an ASN.1 encoded
 * byte array. For more details about the formats used, see
 * {@link #addPathToName(int type,java.lang.String)
 * addPathToName(int type, String name)} and
 * {@link #addPathToName(int type,byte [] name)
 * addPathToName(int type, byte [] name)}.
 * <p>
 * <strong>Note:</strong> for distinguished names, specify the byte
 * array form instead of the String form. See the note in
 * {@link #addPathToName(int,java.lang.String)} for more information.
 * <p>
 * Note that the {@code names} parameter can contain duplicate
 * names (same name and name type), but they may be removed from the
 * {@code Collection} of names returned by the
 * {@link #getPathToNames getPathToNames} method.
 * <p>
 * Note that a deep copy is performed on the {@code Collection} to
 * protect against subsequent modifications.
 *
 * @param names a {@code Collection} with one entry per name
 *              (or {@code null})
 * @throws java.io.IOException if a parsing error occurs
 * @see #getPathToNames
 * @apiSince 1
 */

public void setPathToNames(java.util.Collection<java.util.List<?>> names) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Adds a name to the pathToNames criterion. The {@code X509Certificate}
 * must not include name constraints that would prohibit building a
 * path to the specified name.
 * <p>
 * This method allows the caller to add a name to the set of names which
 * the {@code X509Certificates}'s name constraints must permit.
 * The specified name is added to any previous value for the
 * pathToNames criterion.  If the name is a duplicate, it may be ignored.
 * <p>
 * The name is provided in string format. RFC 822, DNS, and URI names
 * use the well-established string formats for those types (subject to
 * the restrictions included in RFC 3280). IPv4 address names are
 * supplied using dotted quad notation. OID address names are represented
 * as a series of nonnegative integers separated by periods. And
 * directory names (distinguished names) are supplied in RFC 2253 format.
 * No standard string format is defined for otherNames, X.400 names,
 * EDI party names, IPv6 address names, or any other type of names. They
 * should be specified using the
 * {@link #addPathToName(int type,byte [] name)
 * addPathToName(int type, byte [] name)} method.
 * <p>
 * <strong>Note:</strong> for distinguished names, use
 * {@linkplain #addPathToName(int,byte[])} instead.
 * This method should not be relied on as it can fail to match some
 * certificates because of a loss of encoding information in the RFC 2253
 * String form of some distinguished names.
 *
 * @param type the name type (0-8, as specified in
 *             RFC 3280, section 4.2.1.7)
 * @param name the name in string form
 * @throws java.io.IOException if a parsing error occurs
 * @apiSince 1
 */

public void addPathToName(int type, java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Adds a name to the pathToNames criterion. The {@code X509Certificate}
 * must not include name constraints that would prohibit building a
 * path to the specified name.
 * <p>
 * This method allows the caller to add a name to the set of names which
 * the {@code X509Certificates}'s name constraints must permit.
 * The specified name is added to any previous value for the
 * pathToNames criterion. If the name is a duplicate, it may be ignored.
 * <p>
 * The name is provided as a byte array. This byte array should contain
 * the DER encoded name, as it would appear in the GeneralName structure
 * defined in RFC 3280 and X.509. The ASN.1 definition of this structure
 * appears in the documentation for
 * {@link #addSubjectAlternativeName(int type,byte [] name)
 * addSubjectAlternativeName(int type, byte [] name)}.
 * <p>
 * Note that the byte array supplied here is cloned to protect against
 * subsequent modifications.
 *
 * @param type the name type (0-8, as specified in
 *             RFC 3280, section 4.2.1.7)
 * @param name a byte array containing the name in ASN.1 DER encoded form
 * @throws java.io.IOException if a parsing error occurs
 * @apiSince 1
 */

public void addPathToName(int type, byte[] name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the certificateEquals criterion. The specified
 * {@code X509Certificate} must be equal to the
 * {@code X509Certificate} passed to the {@code match} method.
 * If {@code null}, this check is not applied.
 *
 * @return the {@code X509Certificate} to match (or {@code null})
 * @see #setCertificate
 * @apiSince 1
 */

public java.security.cert.X509Certificate getCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the serialNumber criterion. The specified serial number
 * must match the certificate serial number in the
 * {@code X509Certificate}. If {@code null}, any certificate
 * serial number will do.
 *
 * @return the certificate serial number to match
 *                (or {@code null})
 * @see #setSerialNumber
 * @apiSince 1
 */

public java.math.BigInteger getSerialNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the issuer criterion as an {@code X500Principal}. This
 * distinguished name must match the issuer distinguished name in the
 * {@code X509Certificate}. If {@code null}, the issuer criterion
 * is disabled and any issuer distinguished name will do.
 *
 * @return the required issuer distinguished name as X500Principal
 *         (or {@code null})
 * @since 1.5
 * @apiSince 1
 */

public javax.security.auth.x500.X500Principal getIssuer() { throw new RuntimeException("Stub!"); }

/**
 * <strong>Denigrated</strong>, use {@linkplain #getIssuer()} or
 * {@linkplain #getIssuerAsBytes()} instead. This method should not be
 * relied on as it can fail to match some certificates because of a loss of
 * encoding information in the RFC 2253 String form of some distinguished
 * names.
 * <p>
 * Returns the issuer criterion as a {@code String}. This
 * distinguished name must match the issuer distinguished name in the
 * {@code X509Certificate}. If {@code null}, the issuer criterion
 * is disabled and any issuer distinguished name will do.
 * <p>
 * If the value returned is not {@code null}, it is a
 * distinguished name, in RFC 2253 format.
 *
 * @return the required issuer distinguished name in RFC 2253 format
 *         (or {@code null})
 * @apiSince 1
 */

public java.lang.String getIssuerAsString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the issuer criterion as a byte array. This distinguished name
 * must match the issuer distinguished name in the
 * {@code X509Certificate}. If {@code null}, the issuer criterion
 * is disabled and any issuer distinguished name will do.
 * <p>
 * If the value returned is not {@code null}, it is a byte
 * array containing a single DER encoded distinguished name, as defined in
 * X.501. The ASN.1 notation for this structure is supplied in the
 * documentation for
 * {@link #setIssuer(byte [] issuerDN) setIssuer(byte [] issuerDN)}.
 * <p>
 * Note that the byte array returned is cloned to protect against
 * subsequent modifications.
 *
 * @return a byte array containing the required issuer distinguished name
 *         in ASN.1 DER format (or {@code null})
 * @throws java.io.IOException if an encoding error occurs
 * @apiSince 1
 */

public byte[] getIssuerAsBytes() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the subject criterion as an {@code X500Principal}. This
 * distinguished name must match the subject distinguished name in the
 * {@code X509Certificate}. If {@code null}, the subject criterion
 * is disabled and any subject distinguished name will do.
 *
 * @return the required subject distinguished name as X500Principal
 *         (or {@code null})
 * @since 1.5
 * @apiSince 1
 */

public javax.security.auth.x500.X500Principal getSubject() { throw new RuntimeException("Stub!"); }

/**
 * <strong>Denigrated</strong>, use {@linkplain #getSubject()} or
 * {@linkplain #getSubjectAsBytes()} instead. This method should not be
 * relied on as it can fail to match some certificates because of a loss of
 * encoding information in the RFC 2253 String form of some distinguished
 * names.
 * <p>
 * Returns the subject criterion as a {@code String}. This
 * distinguished name must match the subject distinguished name in the
 * {@code X509Certificate}. If {@code null}, the subject criterion
 * is disabled and any subject distinguished name will do.
 * <p>
 * If the value returned is not {@code null}, it is a
 * distinguished name, in RFC 2253 format.
 *
 * @return the required subject distinguished name in RFC 2253 format
 *         (or {@code null})
 * @apiSince 1
 */

public java.lang.String getSubjectAsString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the subject criterion as a byte array. This distinguished name
 * must match the subject distinguished name in the
 * {@code X509Certificate}. If {@code null}, the subject criterion
 * is disabled and any subject distinguished name will do.
 * <p>
 * If the value returned is not {@code null}, it is a byte
 * array containing a single DER encoded distinguished name, as defined in
 * X.501. The ASN.1 notation for this structure is supplied in the
 * documentation for
 * {@link #setSubject(byte [] subjectDN) setSubject(byte [] subjectDN)}.
 * <p>
 * Note that the byte array returned is cloned to protect against
 * subsequent modifications.
 *
 * @return a byte array containing the required subject distinguished name
 *         in ASN.1 DER format (or {@code null})
 * @throws java.io.IOException if an encoding error occurs
 * @apiSince 1
 */

public byte[] getSubjectAsBytes() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the subjectKeyIdentifier criterion. The
 * {@code X509Certificate} must contain a SubjectKeyIdentifier
 * extension with the specified value. If {@code null}, no
 * subjectKeyIdentifier check will be done.
 * <p>
 * Note that the byte array returned is cloned to protect against
 * subsequent modifications.
 *
 * @return the key identifier (or {@code null})
 * @see #setSubjectKeyIdentifier
 * @apiSince 1
 */

public byte[] getSubjectKeyIdentifier() { throw new RuntimeException("Stub!"); }

/**
 * Returns the authorityKeyIdentifier criterion. The
 * {@code X509Certificate} must contain a AuthorityKeyIdentifier
 * extension with the specified value. If {@code null}, no
 * authorityKeyIdentifier check will be done.
 * <p>
 * Note that the byte array returned is cloned to protect against
 * subsequent modifications.
 *
 * @return the key identifier (or {@code null})
 * @see #setAuthorityKeyIdentifier
 * @apiSince 1
 */

public byte[] getAuthorityKeyIdentifier() { throw new RuntimeException("Stub!"); }

/**
 * Returns the certificateValid criterion. The specified date must fall
 * within the certificate validity period for the
 * {@code X509Certificate}. If {@code null}, no certificateValid
 * check will be done.
 * <p>
 * Note that the {@code Date} returned is cloned to protect against
 * subsequent modifications.
 *
 * @return the {@code Date} to check (or {@code null})
 * @see #setCertificateValid
 * @apiSince 1
 */

public java.util.Date getCertificateValid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the privateKeyValid criterion. The specified date must fall
 * within the private key validity period for the
 * {@code X509Certificate}. If {@code null}, no privateKeyValid
 * check will be done.
 * <p>
 * Note that the {@code Date} returned is cloned to protect against
 * subsequent modifications.
 *
 * @return the {@code Date} to check (or {@code null})
 * @see #setPrivateKeyValid
 * @apiSince 1
 */

public java.util.Date getPrivateKeyValid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the subjectPublicKeyAlgID criterion. The
 * {@code X509Certificate} must contain a subject public key
 * with the specified algorithm. If {@code null}, no
 * subjectPublicKeyAlgID check will be done.
 *
 * @return the object identifier (OID) of the signature algorithm to check
 *         for (or {@code null}). An OID is represented by a set of
 *         nonnegative integers separated by periods.
 * @see #setSubjectPublicKeyAlgID
 * @apiSince 1
 */

public java.lang.String getSubjectPublicKeyAlgID() { throw new RuntimeException("Stub!"); }

/**
 * Returns the subjectPublicKey criterion. The
 * {@code X509Certificate} must contain the specified subject
 * public key. If {@code null}, no subjectPublicKey check will be done.
 *
 * @return the subject public key to check for (or {@code null})
 * @see #setSubjectPublicKey
 * @apiSince 1
 */

public java.security.PublicKey getSubjectPublicKey() { throw new RuntimeException("Stub!"); }

/**
 * Returns the keyUsage criterion. The {@code X509Certificate}
 * must allow the specified keyUsage values. If null, no keyUsage
 * check will be done.
 * <p>
 * Note that the boolean array returned is cloned to protect against
 * subsequent modifications.
 *
 * @return a boolean array in the same format as the boolean
 *                 array returned by
 * {@link java.security.cert.X509Certificate#getKeyUsage() X509Certificate#getKeyUsage()}.
 *                 Or {@code null}.
 * @see #setKeyUsage
 * @apiSince 1
 */

public boolean[] getKeyUsage() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extendedKeyUsage criterion. The {@code X509Certificate}
 * must allow the specified key purposes in its extended key usage
 * extension. If the {@code keyPurposeSet} returned is empty or
 * {@code null}, no extendedKeyUsage check will be done. Note that an
 * {@code X509Certificate} that has no extendedKeyUsage extension
 * implicitly allows all key purposes.
 *
 * @return an immutable {@code Set} of key purpose OIDs in string
 * format (or {@code null})
 * @see #setExtendedKeyUsage
 * @apiSince 1
 */

public java.util.Set<java.lang.String> getExtendedKeyUsage() { throw new RuntimeException("Stub!"); }

/**
 * Indicates if the {@code X509Certificate} must contain all
 * or at least one of the subjectAlternativeNames
 * specified in the {@link #setSubjectAlternativeNames
 * setSubjectAlternativeNames} or {@link #addSubjectAlternativeName
 * addSubjectAlternativeName} methods. If {@code true},
 * the {@code X509Certificate} must contain all of the
 * specified subject alternative names. If {@code false}, the
 * {@code X509Certificate} must contain at least one of the
 * specified subject alternative names.
 *
 * @return {@code true} if the flag is enabled;
 * {@code false} if the flag is disabled. The flag is
 * {@code true} by default.
 * @see #setMatchAllSubjectAltNames
 * @apiSince 1
 */

public boolean getMatchAllSubjectAltNames() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the subjectAlternativeNames criterion.
 * The {@code X509Certificate} must contain all or at least one
 * of the specified subjectAlternativeNames, depending on the value
 * of the matchAllNames flag (see {@link #getMatchAllSubjectAltNames
 * getMatchAllSubjectAltNames}). If the value returned is
 * {@code null}, no subjectAlternativeNames check will be performed.
 * <p>
 * If the value returned is not {@code null}, it is a
 * {@code Collection} with
 * one entry for each name to be included in the subject alternative name
 * criterion. Each entry is a {@code List} whose first entry is an
 * {@code Integer} (the name type, 0-8) and whose second
 * entry is a {@code String} or a byte array (the name, in
 * string or ASN.1 DER encoded form, respectively).
 * There can be multiple names of the same type.  Note that the
 * {@code Collection} returned may contain duplicate names (same name
 * and name type).
 * <p>
 * Each subject alternative name in the {@code Collection}
 * may be specified either as a {@code String} or as an ASN.1 encoded
 * byte array. For more details about the formats used, see
 * {@link #addSubjectAlternativeName(int type,java.lang.String)
 * addSubjectAlternativeName(int type, String name)} and
 * {@link #addSubjectAlternativeName(int type,byte [] name)
 * addSubjectAlternativeName(int type, byte [] name)}.
 * <p>
 * Note that a deep copy is performed on the {@code Collection} to
 * protect against subsequent modifications.
 *
 * @return a {@code Collection} of names (or {@code null})
 * @see #setSubjectAlternativeNames
 * @apiSince 1
 */

public java.util.Collection<java.util.List<?>> getSubjectAlternativeNames() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name constraints criterion. The {@code X509Certificate}
 * must have subject and subject alternative names that
 * meet the specified name constraints.
 * <p>
 * The name constraints are returned as a byte array. This byte array
 * contains the DER encoded form of the name constraints, as they
 * would appear in the NameConstraints structure defined in RFC 3280
 * and X.509. The ASN.1 notation for this structure is supplied in the
 * documentation for
 * {@link #setNameConstraints(byte [] bytes) setNameConstraints(byte [] bytes)}.
 * <p>
 * Note that the byte array returned is cloned to protect against
 * subsequent modifications.
 *
 * @return a byte array containing the ASN.1 DER encoding of
 *         a NameConstraints extension used for checking name constraints.
 *         {@code null} if no name constraints check will be performed.
 * @see #setNameConstraints
 * @apiSince 1
 */

public byte[] getNameConstraints() { throw new RuntimeException("Stub!"); }

/**
 * Returns the basic constraints constraint. If the value is greater than
 * or equal to zero, the {@code X509Certificates} must include a
 * basicConstraints extension with a pathLen of at least this value.
 * If the value is -2, only end-entity certificates are accepted. If
 * the value is -1, no basicConstraints check is done.
 *
 * @return the value for the basic constraints constraint
 * @see #setBasicConstraints
 * @apiSince 1
 */

public int getBasicConstraints() { throw new RuntimeException("Stub!"); }

/**
 * Returns the policy criterion. The {@code X509Certificate} must
 * include at least one of the specified policies in its certificate policies
 * extension. If the {@code Set} returned is empty, then the
 * {@code X509Certificate} must include at least some specified policy
 * in its certificate policies extension. If the {@code Set} returned is
 * {@code null}, no policy check will be performed.
 *
 * @return an immutable {@code Set} of certificate policy OIDs in
 *         string format (or {@code null})
 * @see #setPolicy
 * @apiSince 1
 */

public java.util.Set<java.lang.String> getPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the pathToNames criterion. The
 * {@code X509Certificate} must not include name constraints that would
 * prohibit building a path to the specified names. If the value
 * returned is {@code null}, no pathToNames check will be performed.
 * <p>
 * If the value returned is not {@code null}, it is a
 * {@code Collection} with one
 * entry for each name to be included in the pathToNames
 * criterion. Each entry is a {@code List} whose first entry is an
 * {@code Integer} (the name type, 0-8) and whose second
 * entry is a {@code String} or a byte array (the name, in
 * string or ASN.1 DER encoded form, respectively).
 * There can be multiple names of the same type. Note that the
 * {@code Collection} returned may contain duplicate names (same
 * name and name type).
 * <p>
 * Each name in the {@code Collection}
 * may be specified either as a {@code String} or as an ASN.1 encoded
 * byte array. For more details about the formats used, see
 * {@link #addPathToName(int type,java.lang.String)
 * addPathToName(int type, String name)} and
 * {@link #addPathToName(int type,byte [] name)
 * addPathToName(int type, byte [] name)}.
 * <p>
 * Note that a deep copy is performed on the {@code Collection} to
 * protect against subsequent modifications.
 *
 * @return a {@code Collection} of names (or {@code null})
 * @see #setPathToNames
 * @apiSince 1
 */

public java.util.Collection<java.util.List<?>> getPathToNames() { throw new RuntimeException("Stub!"); }

/**
 * Return a printable representation of the {@code CertSelector}.
 *
 * @return a {@code String} describing the contents of the
 *         {@code CertSelector}
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Decides whether a {@code Certificate} should be selected.
 *
 * @param cert the {@code Certificate} to be checked
 * @return {@code true} if the {@code Certificate} should be
 *         selected, {@code false} otherwise
 * @apiSince 1
 */

public boolean match(java.security.cert.Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this object.
 *
 * @return the copy
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }
}

