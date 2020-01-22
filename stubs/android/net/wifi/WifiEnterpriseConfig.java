/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.net.wifi;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/**
 * Enterprise configuration details for Wi-Fi. Stores details about the EAP method
 * and any associated credentials.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiEnterpriseConfig implements android.os.Parcelable {

/** @apiSince 18 */

public WifiEnterpriseConfig() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor.
 * This copies over all the fields verbatim (does not ignore masked password fields).
 *
 * @param source Source WifiEnterpriseConfig object.
 * @apiSince 18
 */

public WifiEnterpriseConfig(android.net.wifi.WifiEnterpriseConfig source) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set the EAP authentication method.
 * @param  eapMethod is one {@link android.net.wifi.WifiEnterpriseConfig.Eap#PEAP Eap#PEAP}, {@link android.net.wifi.WifiEnterpriseConfig.Eap#TLS Eap#TLS}, {@link android.net.wifi.WifiEnterpriseConfig.Eap#TTLS Eap#TTLS} or
 *                   {@link android.net.wifi.WifiEnterpriseConfig.Eap#PWD Eap#PWD}
 * @throws java.lang.IllegalArgumentException on an invalid eap method
 * @apiSince 18
 */

public void setEapMethod(int eapMethod) { throw new RuntimeException("Stub!"); }

/**
 * Get the eap method.
 * @return eap method configured
 * @apiSince 18
 */

public int getEapMethod() { throw new RuntimeException("Stub!"); }

/**
 * Set Phase 2 authentication method. Sets the inner authentication method to be used in
 * phase 2 after setting up a secure channel
 * @param phase2Method is the inner authentication method and can be one of {@link android.net.wifi.WifiEnterpriseConfig.Phase2#NONE Phase2#NONE},
 *                     {@link android.net.wifi.WifiEnterpriseConfig.Phase2#PAP Phase2#PAP}, {@link android.net.wifi.WifiEnterpriseConfig.Phase2#MSCHAP Phase2#MSCHAP}, {@link android.net.wifi.WifiEnterpriseConfig.Phase2#MSCHAPV2 Phase2#MSCHAPV2},
 *                     {@link android.net.wifi.WifiEnterpriseConfig.Phase2#GTC Phase2#GTC}
 * @throws java.lang.IllegalArgumentException on an invalid phase2 method
 *
 * @apiSince 18
 */

public void setPhase2Method(int phase2Method) { throw new RuntimeException("Stub!"); }

/**
 * Get the phase 2 authentication method.
 * @return a phase 2 method defined at {@link android.net.wifi.WifiEnterpriseConfig.Phase2 Phase2}
 *     * @apiSince 18
 */

public int getPhase2Method() { throw new RuntimeException("Stub!"); }

/**
 * Set the identity
 * @param identity
 * @apiSince 18
 */

public void setIdentity(java.lang.String identity) { throw new RuntimeException("Stub!"); }

/**
 * Get the identity
 * @return the identity
 * @apiSince 18
 */

public java.lang.String getIdentity() { throw new RuntimeException("Stub!"); }

/**
 * Set anonymous identity. This is used as the unencrypted identity with
 * certain EAP types
 * @param anonymousIdentity the anonymous identity
 * @apiSince 18
 */

public void setAnonymousIdentity(java.lang.String anonymousIdentity) { throw new RuntimeException("Stub!"); }

/**
 * Get the anonymous identity
 * @return anonymous identity
 * @apiSince 18
 */

public java.lang.String getAnonymousIdentity() { throw new RuntimeException("Stub!"); }

/**
 * Set the password.
 * @param password the password
 * @apiSince 18
 */

public void setPassword(java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Get the password.
 *
 * Returns locally set password value. For networks fetched from
 * framework, returns "*".
 * @apiSince 18
 */

public java.lang.String getPassword() { throw new RuntimeException("Stub!"); }

/**
 * Specify a X.509 certificate that identifies the server.
 *
 * <p>A default name is automatically assigned to the certificate and used
 * with this configuration. The framework takes care of installing the
 * certificate when the config is saved and removing the certificate when
 * the config is removed.
 *
 * @param cert X.509 CA certificate
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if not a CA certificate
 * @apiSince 18
 */

public void setCaCertificate(@androidx.annotation.Nullable java.security.cert.X509Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Get CA certificate. If multiple CA certificates are configured previously,
 * return the first one.
 * @return X.509 CA certificate
 
 * This value may be {@code null}.
 * @apiSince 18
 */

@androidx.annotation.Nullable
public java.security.cert.X509Certificate getCaCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Specify a list of X.509 certificates that identifies the server. The validation
 * passes if the CA of server certificate matches one of the given certificates.
 
 * <p>Default names are automatically assigned to the certificates and used
 * with this configuration. The framework takes care of installing the
 * certificates when the config is saved and removing the certificates when
 * the config is removed.
 *
 * @param certs X.509 CA certificates
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if any of the provided certificates is
 *     not a CA certificate
 * @apiSince 24
 */

public void setCaCertificates(@androidx.annotation.Nullable java.security.cert.X509Certificate[] certs) { throw new RuntimeException("Stub!"); }

/**
 * Get CA certificates.
 
 * @return This value may be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.security.cert.X509Certificate[] getCaCertificates() { throw new RuntimeException("Stub!"); }

/**
 * Specify a private key and client certificate for client authorization.
 *
 * <p>A default name is automatically assigned to the key entry and used
 * with this configuration.  The framework takes care of installing the
 * key entry when the config is saved and removing the key entry when
 * the config is removed.
 
 * @param privateKey a PrivateKey instance for the end certificate.
 * @param clientCertificate an X509Certificate representing the end certificate.
 * @throws java.lang.IllegalArgumentException for an invalid key or certificate.
 * @apiSince 18
 */

public void setClientKeyEntry(java.security.PrivateKey privateKey, java.security.cert.X509Certificate clientCertificate) { throw new RuntimeException("Stub!"); }

/**
 * Specify a private key and client certificate chain for client authorization.
 *
 * <p>A default name is automatically assigned to the key entry and used
 * with this configuration.  The framework takes care of installing the
 * key entry when the config is saved and removing the key entry when
 * the config is removed.
 *
 * @param privateKey a PrivateKey instance for the end certificate.
 * @param clientCertificateChain an array of X509Certificate instances which starts with
 *         end certificate and continues with additional CA certificates necessary to
 *         link the end certificate with some root certificate known by the authenticator.
 * @throws java.lang.IllegalArgumentException for an invalid key or certificate.
 * @apiSince 26
 */

public void setClientKeyEntryWithCertificateChain(java.security.PrivateKey privateKey, java.security.cert.X509Certificate[] clientCertificateChain) { throw new RuntimeException("Stub!"); }

/**
 * Get client certificate
 *
 * @return X.509 client certificate
 * @apiSince 18
 */

public java.security.cert.X509Certificate getClientCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Get the complete client certificate chain in the same order as it was last supplied.
 *
 * <p>If the chain was last supplied by a call to
 * {@link #setClientKeyEntry(java.security.PrivateKey,java.security.cert.X509Certificate)}
 * with a non-null * certificate instance, a single-element array containing the certificate
 * will be * returned. If {@link #setClientKeyEntryWithCertificateChain(java.security.PrivateKey,java.security.cert.X509Certificate[])} was last called with a
 * non-empty array, this array will be returned in the same order as it was supplied.
 * Otherwise, {@code null} will be returned.
 *
 * @return X.509 client certificates
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.security.cert.X509Certificate[] getClientCertificateChain() { throw new RuntimeException("Stub!"); }

/**
 * Set subject match (deprecated). This is the substring to be matched against the subject of
 * the authentication server certificate.
 * @param subjectMatch substring to be matched
 * @deprecated in favor of altSubjectMatch
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
public void setSubjectMatch(java.lang.String subjectMatch) { throw new RuntimeException("Stub!"); }

/**
 * Get subject match (deprecated)
 * @return the subject match string
 * @deprecated in favor of altSubjectMatch
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
public java.lang.String getSubjectMatch() { throw new RuntimeException("Stub!"); }

/**
 * Set alternate subject match. This is the substring to be matched against the
 * alternate subject of the authentication server certificate.
 * @param altSubjectMatch substring to be matched, for example
 *                     DNS:server.example.com;EMAIL:server@example.com
 * @apiSince 23
 */

public void setAltSubjectMatch(java.lang.String altSubjectMatch) { throw new RuntimeException("Stub!"); }

/**
 * Get alternate subject match
 * @return the alternate subject match string
 * @apiSince 23
 */

public java.lang.String getAltSubjectMatch() { throw new RuntimeException("Stub!"); }

/**
 * Set the domain_suffix_match directive on wpa_supplicant. This is the parameter to use
 * for Hotspot 2.0 defined matching of AAA server certs per WFA HS2.0 spec, section 7.3.3.2,
 * second paragraph.
 *
 * <p>From wpa_supplicant documentation:
 * <p>Constraint for server domain name. If set, this FQDN is used as a suffix match requirement
 * for the AAAserver certificate in SubjectAltName dNSName element(s). If a matching dNSName is
 * found, this constraint is met.
 * <p>Suffix match here means that the host/domain name is compared one label at a time starting
 * from the top-level domain and all the labels in domain_suffix_match shall be included in the
 * certificate. The certificate may include additional sub-level labels in addition to the
 * required labels.
 * <p>More than one match string can be provided by using semicolons to separate the strings
 * (e.g., example.org;example.com). When multiple strings are specified, a match with any one of
 * the values is considered a sufficient match for the certificate, i.e., the conditions are
 * ORed ogether.
 * <p>For example, domain_suffix_match=example.com would match test.example.com but would not
 * match test-example.com.
 * @param domain The domain value
 * @apiSince 23
 */

public void setDomainSuffixMatch(java.lang.String domain) { throw new RuntimeException("Stub!"); }

/**
 * Get the domain_suffix_match value. See setDomSuffixMatch.
 * @return The domain value.
 * @apiSince 23
 */

public java.lang.String getDomainSuffixMatch() { throw new RuntimeException("Stub!"); }

/**
 * Set realm for Passpoint credential; realm identifies a set of networks where your
 * Passpoint credential can be used
 * @param realm the realm
 * @apiSince 23
 */

public void setRealm(java.lang.String realm) { throw new RuntimeException("Stub!"); }

/**
 * Get realm for Passpoint credential; see {@link #setRealm(java.lang.String)} for more information
 * @return the realm
 * @apiSince 23
 */

public java.lang.String getRealm() { throw new RuntimeException("Stub!"); }

/**
 * Set plmn (Public Land Mobile Network) of the provider of Passpoint credential
 * @param plmn the plmn value derived from mcc (mobile country code) & mnc (mobile network code)
 * @apiSince 23
 */

public void setPlmn(java.lang.String plmn) { throw new RuntimeException("Stub!"); }

/**
 * Get plmn (Public Land Mobile Network) for Passpoint credential; see {@link #setPlmn
 * (java.lang.String)} for more information
 * @return the plmn
 * @apiSince 23
 */

public java.lang.String getPlmn() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.WifiEnterpriseConfig> CREATOR;
static { CREATOR = null; }
/**
 * The Extensible Authentication Protocol method used
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Eap {

private Eap() { throw new RuntimeException("Stub!"); }

/**
 * EAP-Authentication and Key Agreement [RFC-4187]
 * @apiSince 21
 */

public static final int AKA = 5; // 0x5

/**
 * EAP-Authentication and Key Agreement Prime [RFC-5448]
 * @apiSince 23
 */

public static final int AKA_PRIME = 6; // 0x6

/**
 * No EAP method used. Represents an empty config
 * @apiSince 18
 */

public static final int NONE = -1; // 0xffffffff

/**
 * Protected EAP
 * @apiSince 18
 */

public static final int PEAP = 0; // 0x0

/**
 * EAP-Password
 * @apiSince 18
 */

public static final int PWD = 3; // 0x3

/**
 * EAP-Subscriber Identity Module [RFC-4186]
 * @apiSince 21
 */

public static final int SIM = 4; // 0x4

/**
 * EAP-Transport Layer Security
 * @apiSince 18
 */

public static final int TLS = 1; // 0x1

/**
 * EAP-Tunneled Transport Layer Security
 * @apiSince 18
 */

public static final int TTLS = 2; // 0x2

/**
 * Hotspot 2.0 r2 OSEN
 * @apiSince 24
 */

public static final int UNAUTH_TLS = 7; // 0x7
}

/**
 * The inner authentication method used
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Phase2 {

private Phase2() { throw new RuntimeException("Stub!"); }

/**
 * EAP-Authentication and Key Agreement [RFC-4187]
 * @apiSince 26
 */

public static final int AKA = 6; // 0x6

/**
 * EAP-Authentication and Key Agreement Prime [RFC-5448]
 * @apiSince 26
 */

public static final int AKA_PRIME = 7; // 0x7

/**
 * Generic Token Card
 * @apiSince 18
 */

public static final int GTC = 4; // 0x4

/**
 * Microsoft Challenge Handshake Authentication Protocol
 * @apiSince 18
 */

public static final int MSCHAP = 2; // 0x2

/**
 * Microsoft Challenge Handshake Authentication Protocol v2
 * @apiSince 18
 */

public static final int MSCHAPV2 = 3; // 0x3

/** @apiSince 18 */

public static final int NONE = 0; // 0x0

/**
 * Password Authentication Protocol
 * @apiSince 18
 */

public static final int PAP = 1; // 0x1

/**
 * EAP-Subscriber Identity Module [RFC-4186]
 * @apiSince 26
 */

public static final int SIM = 5; // 0x5
}

}

