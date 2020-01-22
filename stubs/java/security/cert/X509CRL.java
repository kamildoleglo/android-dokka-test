/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.NoSuchProviderException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.Principal;
import javax.security.auth.x500.X500Principal;
import java.util.Set;

/**
 * <p>
 * Abstract class for an X.509 Certificate Revocation List (CRL).
 * A CRL is a time-stamped list identifying revoked certificates.
 * It is signed by a Certificate Authority (CA) and made freely
 * available in a public repository.
 *
 * <p>Each revoked certificate is
 * identified in a CRL by its certificate serial number. When a
 * certificate-using system uses a certificate (e.g., for verifying a
 * remote user's digital signature), that system not only checks the
 * certificate signature and validity but also acquires a suitably-
 * recent CRL and checks that the certificate serial number is not on
 * that CRL.  The meaning of "suitably-recent" may vary with local
 * policy, but it usually means the most recently-issued CRL.  A CA
 * issues a new CRL on a regular periodic basis (e.g., hourly, daily, or
 * weekly).  Entries are added to CRLs as revocations occur, and an
 * entry may be removed when the certificate expiration date is reached.
 * <p>
 * The X.509 v2 CRL format is described below in ASN.1:
 * <pre>
 * CertificateList  ::=  SEQUENCE  {
 *     tbsCertList          TBSCertList,
 *     signatureAlgorithm   AlgorithmIdentifier,
 *     signature            BIT STRING  }
 * </pre>
 * <p>
 * More information can be found in
 * <a href="http://www.ietf.org/rfc/rfc3280.txt">RFC 3280: Internet X.509
 * Public Key Infrastructure Certificate and CRL Profile</a>.
 * <p>
 * The ASN.1 definition of {@code tbsCertList} is:
 * <pre>
 * TBSCertList  ::=  SEQUENCE  {
 *     version                 Version OPTIONAL,
 *                             -- if present, must be v2
 *     signature               AlgorithmIdentifier,
 *     issuer                  Name,
 *     thisUpdate              ChoiceOfTime,
 *     nextUpdate              ChoiceOfTime OPTIONAL,
 *     revokedCertificates     SEQUENCE OF SEQUENCE  {
 *         userCertificate         CertificateSerialNumber,
 *         revocationDate          ChoiceOfTime,
 *         crlEntryExtensions      Extensions OPTIONAL
 *                                 -- if present, must be v2
 *         }  OPTIONAL,
 *     crlExtensions           [0]  EXPLICIT Extensions OPTIONAL
 *                                  -- if present, must be v2
 *     }
 * </pre>
 * <p>
 * CRLs are instantiated using a certificate factory. The following is an
 * example of how to instantiate an X.509 CRL:
 * <pre>{@code
 * try (InputStream inStream = new FileInputStream("fileName-of-crl")) {
 *     CertificateFactory cf = CertificateFactory.getInstance("X.509");
 *     X509CRL crl = (X509CRL)cf.generateCRL(inStream);
 * }
 * }</pre>
 *
 * @author Hemma Prafullchandra
 *
 *
 * @see java.security.cert.CRL
 * @see java.security.cert.CertificateFactory
 * @see java.security.cert.X509Extension
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class X509CRL extends java.security.cert.CRL implements java.security.cert.X509Extension {

/**
 * Constructor for X.509 CRLs.
 * @apiSince 1
 */

protected X509CRL() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Compares this CRL for equality with the given
 * object. If the {@code other} object is an
 * {@code instanceof} {@code X509CRL}, then
 * its encoded form is retrieved and compared with the
 * encoded form of this CRL.
 *
 * @param other the object to test for equality with this CRL.
 *
 * @return true iff the encoded forms of the two CRLs
 * match, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode value for this CRL from its
 * encoded form.
 *
 * @return the hashcode value.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ASN.1 DER-encoded form of this CRL.
 *
 * @return the encoded form of this certificate
 * @exception java.security.cert.CRLException if an encoding error occurs.
 * @apiSince 1
 */

public abstract byte[] getEncoded() throws java.security.cert.CRLException;

/**
 * Verifies that this CRL was signed using the
 * private key that corresponds to the given public key.
 *
 * @param key the PublicKey used to carry out the verification.
 *
 * @exception java.security.NoSuchAlgorithmException on unsupported signature
 * algorithms.
 * @exception java.security.InvalidKeyException on incorrect key.
 * @exception java.security.NoSuchProviderException if there's no default provider.
 * @exception java.security.SignatureException on signature errors.
 * @exception java.security.cert.CRLException on encoding errors.
 * @apiSince 1
 */

public abstract void verify(java.security.PublicKey key) throws java.security.cert.CRLException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.SignatureException;

/**
 * Verifies that this CRL was signed using the
 * private key that corresponds to the given public key.
 * This method uses the signature verification engine
 * supplied by the given provider.
 *
 * @param key the PublicKey used to carry out the verification.
 * @param sigProvider the name of the signature provider.
 *
 * @exception java.security.NoSuchAlgorithmException on unsupported signature
 * algorithms.
 * @exception java.security.InvalidKeyException on incorrect key.
 * @exception java.security.NoSuchProviderException on incorrect provider.
 * @exception java.security.SignatureException on signature errors.
 * @exception java.security.cert.CRLException on encoding errors.
 * @apiSince 1
 */

public abstract void verify(java.security.PublicKey key, java.lang.String sigProvider) throws java.security.cert.CRLException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.SignatureException;

/**
 * Verifies that this CRL was signed using the
 * private key that corresponds to the given public key.
 * This method uses the signature verification engine
 * supplied by the given provider. Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * This method was added to version 1.8 of the Java Platform Standard
 * Edition. In order to maintain backwards compatibility with existing
 * service providers, this method is not {@code abstract}
 * and it provides a default implementation.
 *
 * @param key the PublicKey used to carry out the verification.
 * @param sigProvider the signature provider.
 *
 * @exception java.security.NoSuchAlgorithmException on unsupported signature
 * algorithms.
 * @exception java.security.InvalidKeyException on incorrect key.
 * @exception java.security.SignatureException on signature errors.
 * @exception java.security.cert.CRLException on encoding errors.
 * @since 1.8
 * @apiSince 26
 */

public void verify(java.security.PublicKey key, java.security.Provider sigProvider) throws java.security.cert.CRLException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code version} (version number) value from the CRL.
 * The ASN.1 definition for this is:
 * <pre>
 * version    Version OPTIONAL,
 *             -- if present, must be v2
 *
 * Version  ::=  INTEGER  {  v1(0), v2(1), v3(2)  }
 *             -- v3 does not apply to CRLs but appears for consistency
 *             -- with definition of Version for certs
 * </pre>
 *
 * @return the version number, i.e. 1 or 2.
 * @apiSince 1
 */

public abstract int getVersion();

/**
 * <strong>Denigrated</strong>, replaced by {@linkplain
 * #getIssuerX500Principal()}. This method returns the {@code issuer}
 * as an implementation specific Principal object, which should not be
 * relied upon by portable code.
 *
 * <p>
 * Gets the {@code issuer} (issuer distinguished name) value from
 * the CRL. The issuer name identifies the entity that signed (and
 * issued) the CRL.
 *
 * <p>The issuer name field contains an
 * X.500 distinguished name (DN).
 * The ASN.1 definition for this is:
 * <pre>
 * issuer    Name
 *
 * Name ::= CHOICE { RDNSequence }
 * RDNSequence ::= SEQUENCE OF RelativeDistinguishedName
 * RelativeDistinguishedName ::=
 *     SET OF AttributeValueAssertion
 *
 * AttributeValueAssertion ::= SEQUENCE {
 *                               AttributeType,
 *                               AttributeValue }
 * AttributeType ::= OBJECT IDENTIFIER
 * AttributeValue ::= ANY
 * </pre>
 * The {@code Name} describes a hierarchical name composed of
 * attributes,
 * such as country name, and corresponding values, such as US.
 * The type of the {@code AttributeValue} component is determined by
 * the {@code AttributeType}; in general it will be a
 * {@code directoryString}. A {@code directoryString} is usually
 * one of {@code PrintableString},
 * {@code TeletexString} or {@code UniversalString}.
 *
 * @return a Principal whose name is the issuer distinguished name.
 * @apiSince 1
 */

public abstract java.security.Principal getIssuerDN();

/**
 * Returns the issuer (issuer distinguished name) value from the
 * CRL as an {@code X500Principal}.
 * <p>
 * It is recommended that subclasses override this method.
 *
 * @return an {@code X500Principal} representing the issuer
 *          distinguished name
 * @since 1.4
 * @apiSince 1
 */

public javax.security.auth.x500.X500Principal getIssuerX500Principal() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code thisUpdate} date from the CRL.
 * The ASN.1 definition for this is:
 * <pre>
 * thisUpdate   ChoiceOfTime
 * ChoiceOfTime ::= CHOICE {
 *     utcTime        UTCTime,
 *     generalTime    GeneralizedTime }
 * </pre>
 *
 * @return the {@code thisUpdate} date from the CRL.
 * @apiSince 1
 */

public abstract java.util.Date getThisUpdate();

/**
 * Gets the {@code nextUpdate} date from the CRL.
 *
 * @return the {@code nextUpdate} date from the CRL, or null if
 * not present.
 * @apiSince 1
 */

public abstract java.util.Date getNextUpdate();

/**
 * Gets the CRL entry, if any, with the given certificate serialNumber.
 *
 * @param serialNumber the serial number of the certificate for which a CRL entry
 * is to be looked up
 * @return the entry with the given serial number, or null if no such entry
 * exists in this CRL.
 * @see java.security.cert.X509CRLEntry
 * @apiSince 1
 */

public abstract java.security.cert.X509CRLEntry getRevokedCertificate(java.math.BigInteger serialNumber);

/**
 * Get the CRL entry, if any, for the given certificate.
 *
 * <p>This method can be used to lookup CRL entries in indirect CRLs,
 * that means CRLs that contain entries from issuers other than the CRL
 * issuer. The default implementation will only return entries for
 * certificates issued by the CRL issuer. Subclasses that wish to
 * support indirect CRLs should override this method.
 *
 * @param certificate the certificate for which a CRL entry is to be looked
 *   up
 * @return the entry for the given certificate, or null if no such entry
 *   exists in this CRL.
 * @exception java.lang.NullPointerException if certificate is null
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.cert.X509CRLEntry getRevokedCertificate(java.security.cert.X509Certificate certificate) { throw new RuntimeException("Stub!"); }

/**
 * Gets all the entries from this CRL.
 * This returns a Set of X509CRLEntry objects.
 *
 * @return all the entries or null if there are none present.
 * @see java.security.cert.X509CRLEntry
 * @apiSince 1
 */

public abstract java.util.Set<? extends java.security.cert.X509CRLEntry> getRevokedCertificates();

/**
 * Gets the DER-encoded CRL information, the
 * {@code tbsCertList} from this CRL.
 * This can be used to verify the signature independently.
 *
 * @return the DER-encoded CRL information.
 * @exception java.security.cert.CRLException if an encoding error occurs.
 * @apiSince 1
 */

public abstract byte[] getTBSCertList() throws java.security.cert.CRLException;

/**
 * Gets the {@code signature} value (the raw signature bits) from
 * the CRL.
 * The ASN.1 definition for this is:
 * <pre>
 * signature     BIT STRING
 * </pre>
 *
 * @return the signature.
 * @apiSince 1
 */

public abstract byte[] getSignature();

/**
 * Gets the signature algorithm name for the CRL
 * signature algorithm. An example is the string "SHA256withRSA".
 * The ASN.1 definition for this is:
 * <pre>
 * signatureAlgorithm   AlgorithmIdentifier
 *
 * AlgorithmIdentifier  ::=  SEQUENCE  {
 *     algorithm               OBJECT IDENTIFIER,
 *     parameters              ANY DEFINED BY algorithm OPTIONAL  }
 *                             -- contains a value of the type
 *                             -- registered for use with the
 *                             -- algorithm object identifier value
 * </pre>
 *
 * <p>The algorithm name is determined from the {@code algorithm}
 * OID string.
 *
 * @return the signature algorithm name.
 * @apiSince 1
 */

public abstract java.lang.String getSigAlgName();

/**
 * Gets the signature algorithm OID string from the CRL.
 * An OID is represented by a set of nonnegative whole numbers separated
 * by periods.
 * For example, the string "1.2.840.10040.4.3" identifies the SHA-1
 * with DSA signature algorithm defined in
 * <a href="http://www.ietf.org/rfc/rfc3279.txt">RFC 3279: Algorithms and
 * Identifiers for the Internet X.509 Public Key Infrastructure Certificate
 * and CRL Profile</a>.
 *
 * <p>See {@link #getSigAlgName() getSigAlgName} for
 * relevant ASN.1 definitions.
 *
 * @return the signature algorithm OID string.
 * @apiSince 1
 */

public abstract java.lang.String getSigAlgOID();

/**
 * Gets the DER-encoded signature algorithm parameters from this
 * CRL's signature algorithm. In most cases, the signature
 * algorithm parameters are null; the parameters are usually
 * supplied with the public key.
 * If access to individual parameter values is needed then use
 * {@link java.security.AlgorithmParameters AlgorithmParameters}
 * and instantiate with the name returned by
 * {@link #getSigAlgName() getSigAlgName}.
 *
 * <p>See {@link #getSigAlgName() getSigAlgName} for
 * relevant ASN.1 definitions.
 *
 * @return the DER-encoded signature algorithm parameters, or
 *         null if no parameters are present.
 * @apiSince 1
 */

public abstract byte[] getSigAlgParams();
}

