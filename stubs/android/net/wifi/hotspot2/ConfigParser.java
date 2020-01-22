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


package android.net.wifi.hotspot2;

import java.security.cert.Certificate;

/**
 * Utility class for building PasspointConfiguration from an installation file.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ConfigParser {

ConfigParser() { throw new RuntimeException("Stub!"); }

/**
 * Parse the Hotspot 2.0 Release 1 configuration data into a {@link android.net.wifi.hotspot2.PasspointConfiguration PasspointConfiguration}
 * object.  The configuration data is a base64 encoded MIME multipart data.  Below is
 * the format of the decoded message:
 *
 * Content-Type: multipart/mixed; boundary={boundary}
 * Content-Transfer-Encoding: base64
 * [Skip uninterested headers]
 *
 * --{boundary}
 * Content-Type: application/x-passpoint-profile
 * Content-Transfer-Encoding: base64
 *
 * [base64 encoded Passpoint profile data]
 * --{boundary}
 * Content-Type: application/x-x509-ca-cert
 * Content-Transfer-Encoding: base64
 *
 * [base64 encoded X509 CA certificate data]
 * --{boundary}
 * Content-Type: application/x-pkcs12
 * Content-Transfer-Encoding: base64
 *
 * [base64 encoded PKCS#12 ASN.1 structure containing client certificate chain]
 * --{boundary}
 *
 * @param mimeType MIME type of the encoded data.
 * @param data A base64 encoded MIME multipart message containing the Passpoint profile
 *             (required), CA (Certificate Authority) certificate (optional), and client
 *             certificate chain (optional).
 * @return {@link android.net.wifi.hotspot2.PasspointConfiguration PasspointConfiguration}
 * @apiSince 26
 */

public static android.net.wifi.hotspot2.PasspointConfiguration parsePasspointConfig(java.lang.String mimeType, byte[] data) { throw new RuntimeException("Stub!"); }
}

