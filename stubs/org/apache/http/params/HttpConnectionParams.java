/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/params/HttpConnectionParams.java $
 * $Revision: 576089 $
 * $Date: 2007-09-16 05:39:56 -0700 (Sun, 16 Sep 2007) $
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


package org.apache.http.params;


/**
 * An adaptor for accessing connection parameters in {@link org.apache.http.params.HttpParams HttpParams}.
 * <br/>
 * Note that the <i>implements</i> relation to {@link org.apache.http.params.CoreConnectionPNames CoreConnectionPNames}
 * is for compatibility with existing application code only. References to
 * the parameter names should use the interface, not this class.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 576089 $
 *
 * @since 4.0
 *
 * @deprecated Please use {@link java.net.URL#openConnection} instead.
 *     Please visit <a href="http://android-developers.blogspot.com/2011/09/androids-http-clients.html">this webpage</a>
 *     for further details.
 * @apiSince 1
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class HttpConnectionParams implements org.apache.http.params.CoreConnectionPNames {

private HttpConnectionParams() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default socket timeout (<tt>SO_TIMEOUT</tt>) in milliseconds which is the
 * timeout for waiting for data. A timeout value of zero is interpreted as an infinite
 * timeout. This value is used when no socket timeout is set in the
 * method parameters.
 *
 * @return timeout in milliseconds
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static int getSoTimeout(org.apache.http.params.HttpParams params) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default socket timeout (<tt>SO_TIMEOUT</tt>) in milliseconds which is the
 * timeout for waiting for data. A timeout value of zero is interpreted as an infinite
 * timeout. This value is used when no socket timeout is set in the
 * method parameters.
 *
 * @param timeout Timeout in milliseconds
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static void setSoTimeout(org.apache.http.params.HttpParams params, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Tests if Nagle's algorithm is to be used.
 *
 * @return <tt>true</tt> if the Nagle's algorithm is to NOT be used
 *   (that is enable TCP_NODELAY), <tt>false</tt> otherwise.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static boolean getTcpNoDelay(org.apache.http.params.HttpParams params) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether Nagle's algorithm is to be used. The Nagle's algorithm
 * tries to conserve bandwidth by minimizing the number of segments that are
 * sent. When applications wish to decrease network latency and increase
 * performance, they can disable Nagle's algorithm (that is enable TCP_NODELAY).
 * Data will be sent earlier, at the cost of an increase in bandwidth consumption.
 *
 * @param value <tt>true</tt> if the Nagle's algorithm is to NOT be used
 *   (that is enable TCP_NODELAY), <tt>false</tt> otherwise.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static void setTcpNoDelay(org.apache.http.params.HttpParams params, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static int getSocketBufferSize(org.apache.http.params.HttpParams params) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static void setSocketBufferSize(org.apache.http.params.HttpParams params, int size) { throw new RuntimeException("Stub!"); }

/**
 * Returns linger-on-close timeout. Value <tt>0</tt> implies that the option is
 * disabled. Value <tt>-1</tt> implies that the JRE default is used.
 *
 * @return the linger-on-close timeout
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static int getLinger(org.apache.http.params.HttpParams params) { throw new RuntimeException("Stub!"); }

/**
 * Returns linger-on-close timeout. This option disables/enables immediate return
 * from a close() of a TCP Socket. Enabling this option with a non-zero Integer
 * timeout means that a close() will block pending the transmission and
 * acknowledgement of all data written to the peer, at which point the socket is
 * closed gracefully. Value <tt>0</tt> implies that the option is
 * disabled. Value <tt>-1</tt> implies that the JRE default is used.
 *
 * @param value the linger-on-close timeout
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static void setLinger(org.apache.http.params.HttpParams params, int value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the timeout until a connection is etablished. A value of zero
 * means the timeout is not used. The default value is zero.
 *
 * @return timeout in milliseconds.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static int getConnectionTimeout(org.apache.http.params.HttpParams params) { throw new RuntimeException("Stub!"); }

/**
 * Sets the timeout until a connection is etablished. A value of zero
 * means the timeout is not used. The default value is zero.
 *
 * @param timeout Timeout in milliseconds.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static void setConnectionTimeout(org.apache.http.params.HttpParams params, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether stale connection check is to be used. Disabling
 * stale connection check may result in slight performance improvement
 * at the risk of getting an I/O error when executing a request over a
 * connection that has been closed at the server side.
 *
 * @return <tt>true</tt> if stale connection check is to be used,
 *   <tt>false</tt> otherwise.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static boolean isStaleCheckingEnabled(org.apache.http.params.HttpParams params) { throw new RuntimeException("Stub!"); }

/**
 * Defines whether stale connection check is to be used. Disabling
 * stale connection check may result in slight performance improvement
 * at the risk of getting an I/O error when executing a request over a
 * connection that has been closed at the server side.
 *
 * @param value <tt>true</tt> if stale connection check is to be used,
 *   <tt>false</tt> otherwise.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static void setStaleCheckingEnabled(org.apache.http.params.HttpParams params, boolean value) { throw new RuntimeException("Stub!"); }
}

