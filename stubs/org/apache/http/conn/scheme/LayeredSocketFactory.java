/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/scheme/LayeredSocketFactory.java $
 * $Revision: 645850 $
 * $Date: 2008-04-08 04:08:52 -0700 (Tue, 08 Apr 2008) $
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


package org.apache.http.conn.scheme;

import java.net.UnknownHostException;
import java.io.IOException;
import java.net.Socket;

/**
 * A {@link org.apache.http.conn.scheme.SocketFactory SocketFactory} for layered sockets (SSL/TLS).
 * See there for things to consider when implementing a socket factory.
 *
 * @author Michael Becke
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
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
public interface LayeredSocketFactory extends org.apache.http.conn.scheme.SocketFactory {

/**
 * Returns a socket connected to the given host that is layered over an
 * existing socket.  Used primarily for creating secure sockets through
 * proxies.
 *
 * @param socket the existing socket
 * @param host the host name/IP
 * @param port the port on the host
 * @param autoClose a flag for closing the underling socket when the created
 * socket is closed
 *
 * @return Socket a new socket
 *
 * @throws java.io.IOException if an I/O error occurs while creating the socket
 * @throws java.net.UnknownHostException if the IP address of the host cannot be
 * determined
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public java.net.Socket createSocket(java.net.Socket socket, java.lang.String host, int port, boolean autoClose) throws java.io.IOException, java.net.UnknownHostException;
}

