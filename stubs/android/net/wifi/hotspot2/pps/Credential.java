/**
 * Copyright (c) 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.net.wifi.hotspot2.pps;

import java.util.Set;

/**
 * Class representing Credential subtree in the PerProviderSubscription (PPS)
 * Management Object (MO) tree.
 * For more info, refer to Hotspot 2.0 PPS MO defined in section 9.1 of the Hotspot 2.0
 * Release 2 Technical Specification.
 *
 * In addition to the fields in the Credential subtree, this will also maintain necessary
 * information for the private key and certificates associated with this credential.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Credential implements android.os.Parcelable {

/**
 * Constructor for creating Credential with default values.
 * @apiSince 26
 */

public Credential() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor.
 *
 * @param source The source to copy from
 * @apiSince 26
 */

public Credential(android.net.wifi.hotspot2.pps.Credential source) { throw new RuntimeException("Stub!"); }

/**
 * Set the realm associated with this credential.
 *
 * @param realm The realm to set to
 * @apiSince 26
 */

public void setRealm(java.lang.String realm) { throw new RuntimeException("Stub!"); }

/**
 * Get the realm associated with this credential.
 *
 * @return the realm associated with this credential
 * @apiSince 26
 */

public java.lang.String getRealm() { throw new RuntimeException("Stub!"); }

/**
 * Set the user credential information.
 *
 * @param userCredential The user credential to set to
 * @apiSince 26
 */

public void setUserCredential(android.net.wifi.hotspot2.pps.Credential.UserCredential userCredential) { throw new RuntimeException("Stub!"); }

/**
 * Get the user credential information.
 *
 * @return user credential information
 * @apiSince 26
 */

public android.net.wifi.hotspot2.pps.Credential.UserCredential getUserCredential() { throw new RuntimeException("Stub!"); }

/**
 * Set the certificate credential information.
 *
 * @param certCredential The certificate credential to set to
 * @apiSince 26
 */

public void setCertCredential(android.net.wifi.hotspot2.pps.Credential.CertificateCredential certCredential) { throw new RuntimeException("Stub!"); }

/**
 * Get the certificate credential information.
 *
 * @return certificate credential information
 * @apiSince 26
 */

public android.net.wifi.hotspot2.pps.Credential.CertificateCredential getCertCredential() { throw new RuntimeException("Stub!"); }

/**
 * Set the SIM credential information.
 *
 * @param simCredential The SIM credential to set to
 * @apiSince 26
 */

public void setSimCredential(android.net.wifi.hotspot2.pps.Credential.SimCredential simCredential) { throw new RuntimeException("Stub!"); }

/**
 * Get the SIM credential information.
 *
 * @return SIM credential information
 * @apiSince 26
 */

public android.net.wifi.hotspot2.pps.Credential.SimCredential getSimCredential() { throw new RuntimeException("Stub!"); }

/**
 * Set the CA (Certification Authority) certificate associated with this credential.
 *
 * @param caCertificate The CA certificate to set to
 * @apiSince 26
 */

public void setCaCertificate(java.security.cert.X509Certificate caCertificate) { throw new RuntimeException("Stub!"); }

/**
 * Get the CA (Certification Authority) certificate associated with this credential.
 *
 * @return CA certificate associated with this credential, {@code null} if certificate is not
 * set or certificate is more than one.
 * @apiSince 26
 */

public java.security.cert.X509Certificate getCaCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Set the client certificate chain associated with this credential.
 *
 * @param certificateChain The client certificate chain to set to
 * @apiSince 26
 */

public void setClientCertificateChain(java.security.cert.X509Certificate[] certificateChain) { throw new RuntimeException("Stub!"); }

/**
 * Get the client certificate chain associated with this credential.
 *
 * @return client certificate chain associated with this credential
 * @apiSince 26
 */

public java.security.cert.X509Certificate[] getClientCertificateChain() { throw new RuntimeException("Stub!"); }

/**
 * Set the client private key associated with this credential.
 *
 * @param clientPrivateKey the client private key to set to
 * @apiSince 26
 */

public void setClientPrivateKey(java.security.PrivateKey clientPrivateKey) { throw new RuntimeException("Stub!"); }

/**
 * Get the client private key associated with this credential.
 *
 * @return client private key associated with this credential.
 * @apiSince 26
 */

public java.security.PrivateKey getClientPrivateKey() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object thatObject) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.hotspot2.pps.Credential> CREATOR;
static { CREATOR = null; }
/**
 * Certificate based credential.  This is used for EAP-TLS.
 * Contains fields under PerProviderSubscription/Credential/DigitalCertificate subtree.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CertificateCredential implements android.os.Parcelable {

/**
 * Constructor for creating CertificateCredential with default values.
 * @apiSince 26
 */

public CertificateCredential() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor.
 *
 * @param source The source to copy from
 * @apiSince 26
 */

public CertificateCredential(android.net.wifi.hotspot2.pps.Credential.CertificateCredential source) { throw new RuntimeException("Stub!"); }

/**
 * Set the certificate type associated with this certificate credential.
 *
 * @param certType The certificate type to set to
 * @apiSince 26
 */

public void setCertType(java.lang.String certType) { throw new RuntimeException("Stub!"); }

/**
 * Get the certificate type associated with this certificate credential.
 *
 * @return certificate type
 * @apiSince 26
 */

public java.lang.String getCertType() { throw new RuntimeException("Stub!"); }

/**
 * Set the certificate SHA-256 fingerprint associated with this certificate credential.
 *
 * @param certSha256Fingerprint The certificate fingerprint to set to
 * @apiSince 26
 */

public void setCertSha256Fingerprint(byte[] certSha256Fingerprint) { throw new RuntimeException("Stub!"); }

/**
 * Get the certificate SHA-256 fingerprint associated with this certificate credential.
 *
 * @return certificate SHA-256 fingerprint
 * @apiSince 26
 */

public byte[] getCertSha256Fingerprint() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object thatObject) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.hotspot2.pps.Credential.CertificateCredential> CREATOR;
static { CREATOR = null; }
}

/**
 * SIM (Subscriber Identify Module) based credential.
 * Contains fields under PerProviderSubscription/Credential/SIM subtree.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SimCredential implements android.os.Parcelable {

/**
 * Constructor for creating SimCredential with default values.
 * @apiSince 26
 */

public SimCredential() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor
 *
 * @param source The source to copy from
 * @apiSince 26
 */

public SimCredential(android.net.wifi.hotspot2.pps.Credential.SimCredential source) { throw new RuntimeException("Stub!"); }

/**
 * Set the IMSI (International Mobile Subscriber Identity) associated with this SIM
 * credential.
 *
 * @param imsi The IMSI to set to
 * @apiSince 26
 */

public void setImsi(java.lang.String imsi) { throw new RuntimeException("Stub!"); }

/**
 * Get the IMSI (International Mobile Subscriber Identity) associated with this SIM
 * credential.
 *
 * @return IMSI associated with this SIM credential
 * @apiSince 26
 */

public java.lang.String getImsi() { throw new RuntimeException("Stub!"); }

/**
 * Set the EAP (Extensible Authentication Protocol) method type associated with this
 * SIM credential.
 *
 * @param eapType The EAP method type to set to
 * @apiSince 26
 */

public void setEapType(int eapType) { throw new RuntimeException("Stub!"); }

/**
 * Get the EAP (Extensible Authentication Protocol) method type associated with this
 * SIM credential.
 *
 * @return EAP method type associated with this SIM credential
 * @apiSince 26
 */

public int getEapType() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object thatObject) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.hotspot2.pps.Credential.SimCredential> CREATOR;
static { CREATOR = null; }
}

/**
 * Username-password based credential.
 * Contains the fields under PerProviderSubscription/Credential/UsernamePassword subtree.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class UserCredential implements android.os.Parcelable {

/**
 * Constructor for creating UserCredential with default values.
 * @apiSince 26
 */

public UserCredential() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor.
 *
 * @param source The source to copy from
 * @apiSince 26
 */

public UserCredential(android.net.wifi.hotspot2.pps.Credential.UserCredential source) { throw new RuntimeException("Stub!"); }

/**
 * Set the username associated with this user credential.
 *
 * @param username The username to set to
 * @apiSince 26
 */

public void setUsername(java.lang.String username) { throw new RuntimeException("Stub!"); }

/**
 * Get the username associated with this user credential.
 *
 * @return the username associated with this user credential
 * @apiSince 26
 */

public java.lang.String getUsername() { throw new RuntimeException("Stub!"); }

/**
 * Set the Base64-encoded password associated with this user credential.
 *
 * @param password The password to set to
 * @apiSince 26
 */

public void setPassword(java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Get the Base64-encoded password associated with this user credential.
 *
 * @return the Base64-encoded password associated with this user credential
 * @apiSince 26
 */

public java.lang.String getPassword() { throw new RuntimeException("Stub!"); }

/**
 * Set the EAP (Extensible Authentication Protocol) method type associated with this
 * user credential.
 * Refer to
 * <a href="http://www.iana.org/assignments/eap-numbers/eap-numbers.xml#eap-numbers-4">
 * EAP Numbers</a> for valid values.
 *
 * @param eapType The EAP method type associated with this user credential
 * @apiSince 26
 */

public void setEapType(int eapType) { throw new RuntimeException("Stub!"); }

/**
 * Get the EAP (Extensible Authentication Protocol) method type associated with this
 * user credential.
 *
 * @return EAP method type
 * @apiSince 26
 */

public int getEapType() { throw new RuntimeException("Stub!"); }

/**
 * Set the inner non-EAP method associated with this user credential.
 *
 * @param nonEapInnerMethod The non-EAP inner method to set to
 * @apiSince 26
 */

public void setNonEapInnerMethod(java.lang.String nonEapInnerMethod) { throw new RuntimeException("Stub!"); }

/**
 * Get the inner non-EAP method associated with this user credential.
 *
 * @return Non-EAP inner method associated with this user credential
 * @apiSince 26
 */

public java.lang.String getNonEapInnerMethod() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object thatObject) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.hotspot2.pps.Credential.UserCredential> CREATOR;
static { CREATOR = null; }
}

}

