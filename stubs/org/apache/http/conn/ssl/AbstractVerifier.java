/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/ssl/AbstractVerifier.java $
 * $Revision: 653041 $
 * $Date: 2008-05-03 03:39:28 -0700 (Sat, 03 May 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


package org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;

/**
 * Abstract base class for all standard {@link org.apache.http.conn.ssl.X509HostnameVerifier X509HostnameVerifier}
 * implementations.
 *
 * @author Julius Davies
 *
 * @deprecated Please use {@link java.net.URL#openConnection} instead.
 *     Please visit <a href="http://android-developers.blogspot.com/2011/09/androids-http-clients.html">this webpage</a>
 *     for further details.
 * @apiSince 1
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class AbstractVerifier implements org.apache.http.conn.ssl.X509HostnameVerifier {

/** @apiSince 1 */

@Deprecated
public AbstractVerifier() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public final void verify(java.lang.String host, javax.net.ssl.SSLSocket ssl) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public final boolean verify(java.lang.String host, javax.net.ssl.SSLSession session) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public final void verify(java.lang.String host, java.security.cert.X509Certificate cert) throws javax.net.ssl.SSLException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public final void verify(java.lang.String host, java.lang.String[] cns, java.lang.String[] subjectAlts, boolean strictWithSubDomains) throws javax.net.ssl.SSLException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static boolean acceptableCountryWildcard(java.lang.String cn) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static java.lang.String[] getCNs(java.security.cert.X509Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Extracts the array of SubjectAlt DNS names from an X509Certificate.
 * Returns null if there aren't any.
 * <p/>
 * Note:  Java doesn't appear able to extract international characters
 * from the SubjectAlts.  It can only extract international characters
 * from the CN field.
 * <p/>
 * (Or maybe the version of OpenSSL I'm using to test isn't storing the
 * international characters correctly in the SubjectAlts?).
 *
 * @param cert X509Certificate
 * @return Array of SubjectALT DNS names stored in the certificate.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static java.lang.String[] getDNSSubjectAlts(java.security.cert.X509Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Counts the number of dots "." in a string.
 * @param s  string to count dots from
 * @return  number of dots
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static int countDots(java.lang.String s) { throw new RuntimeException("Stub!"); }
}

