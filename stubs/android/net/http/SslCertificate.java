/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.net.http;

import java.security.cert.X509Certificate;

/**
 * SSL certificate info (certificate details) class
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SslCertificate {

/**
 * Creates a new SSL certificate object
 * @param issuedTo The entity this certificate is issued to
 * @param issuedBy The entity that issued this certificate
 * @param validNotBefore The not-before date from the certificate
 *     validity period in ISO 8601 format
 * @param validNotAfter The not-after date from the certificate
 *     validity period in ISO 8601 format
 * @deprecated Use {@link #SslCertificate(java.security.cert.X509Certificate)}
 * @apiSince 1
 */

@Deprecated
public SslCertificate(java.lang.String issuedTo, java.lang.String issuedBy, java.lang.String validNotBefore, java.lang.String validNotAfter) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new SSL certificate object
 * @param issuedTo The entity this certificate is issued to
 * @param issuedBy The entity that issued this certificate
 * @param validNotBefore The not-before date from the certificate validity period
 * @param validNotAfter The not-after date from the certificate validity period
 * @deprecated Use {@link #SslCertificate(java.security.cert.X509Certificate)}
 * @apiSince 8
 */

@Deprecated
public SslCertificate(java.lang.String issuedTo, java.lang.String issuedBy, java.util.Date validNotBefore, java.util.Date validNotAfter) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new SSL certificate object from an X509 certificate
 * @param certificate X509 certificate
 * @apiSince 1
 */

public SslCertificate(java.security.cert.X509Certificate certificate) { throw new RuntimeException("Stub!"); }

/**
 * Saves the certificate state to a bundle
 * @param certificate The SSL certificate to store
 * @return A bundle with the certificate stored in it or null if fails
 * @apiSince 1
 */

public static android.os.Bundle saveState(android.net.http.SslCertificate certificate) { throw new RuntimeException("Stub!"); }

/**
 * Restores the certificate stored in the bundle
 * @param bundle The bundle with the certificate state stored in it
 * @return The SSL certificate stored in the bundle or null if fails
 * @apiSince 1
 */

public static android.net.http.SslCertificate restoreState(android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * @return Not-before date from the certificate validity period or
 * "" if none has been set
 * @apiSince 8
 */

public java.util.Date getValidNotBeforeDate() { throw new RuntimeException("Stub!"); }

/**
 * @return Not-before date from the certificate validity period in
 * ISO 8601 format or "" if none has been set
 *
 * @deprecated Use {@link #getValidNotBeforeDate()}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public java.lang.String getValidNotBefore() { throw new RuntimeException("Stub!"); }

/**
 * @return Not-after date from the certificate validity period or
 * "" if none has been set
 * @apiSince 8
 */

public java.util.Date getValidNotAfterDate() { throw new RuntimeException("Stub!"); }

/**
 * @return Not-after date from the certificate validity period in
 * ISO 8601 format or "" if none has been set
 *
 * @deprecated Use {@link #getValidNotAfterDate()}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public java.lang.String getValidNotAfter() { throw new RuntimeException("Stub!"); }

/**
 * @return Issued-to distinguished name or null if none has been set
 * @apiSince 1
 */

public android.net.http.SslCertificate.DName getIssuedTo() { throw new RuntimeException("Stub!"); }

/**
 * @return Issued-by distinguished name or null if none has been set
 * @apiSince 1
 */

public android.net.http.SslCertificate.DName getIssuedBy() { throw new RuntimeException("Stub!"); }

/**
 * @return The {@code X509Certificate} used to create this {@code SslCertificate} or
 * {@code null} if no certificate was provided.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.security.cert.X509Certificate getX509Certificate() { throw new RuntimeException("Stub!"); }

/**
 * @return A string representation of this certificate for debugging
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * A distinguished name helper class: a 3-tuple of:
 * <ul>
 *   <li>the most specific common name (CN)</li>
 *   <li>the most specific organization (O)</li>
 *   <li>the most specific organizational unit (OU)</li>
 * <ul>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DName {

/**
 * Creates a new {@code DName} from a string. The attributes
 * are assumed to come in most significant to least
 * significant order which is true of human readable values
 * returned by methods such as {@code X500Principal.getName()}.
 * Be aware that the underlying sources of distinguished names
 * such as instances of {@code X509Certificate} are encoded in
 * least significant to most significant order, so make sure
 * the value passed here has the expected ordering of
 * attributes.
 */

public DName(java.lang.String dName) { throw new RuntimeException("Stub!"); }

/**
 * @return The distinguished name (normally includes CN, O, and OU names)
 * @apiSince 1
 */

public java.lang.String getDName() { throw new RuntimeException("Stub!"); }

/**
 * @return The most specific Common-name (CN) component of this name
 * @apiSince 1
 */

public java.lang.String getCName() { throw new RuntimeException("Stub!"); }

/**
 * @return The most specific Organization (O) component of this name
 * @apiSince 1
 */

public java.lang.String getOName() { throw new RuntimeException("Stub!"); }

/**
 * @return The most specific Organizational Unit (OU) component of this name
 * @apiSince 1
 */

public java.lang.String getUName() { throw new RuntimeException("Stub!"); }
}

}

