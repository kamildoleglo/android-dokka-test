/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/ConnectTimeoutException.java $
 * $Revision: 617645 $
 * $Date: 2008-02-01 13:05:31 -0800 (Fri, 01 Feb 2008) $
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


package org.apache.http.conn;


/**
 * A timeout while connecting to an HTTP server or waiting for an
 * available connection from an HttpConnectionManager.
 *
 * @author <a href="mailto:laura@lwerner.org">Laura Werner</a>
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
public class ConnectTimeoutException extends java.io.InterruptedIOException {

/**
 * Creates a ConnectTimeoutException with a <tt>null</tt> detail message.
 * @apiSince 1
 */

@Deprecated
public ConnectTimeoutException() { throw new RuntimeException("Stub!"); }

/**
 * Creates a ConnectTimeoutException with the specified detail message.
 *
 * @param message The exception detail message
 * @apiSince 1
 */

@Deprecated
public ConnectTimeoutException(java.lang.String message) { throw new RuntimeException("Stub!"); }
}

