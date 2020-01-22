/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/scheme/SocketFactory.java $
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

import java.io.IOException;
import org.apache.http.params.HttpParams;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/**
 * A factory for creating and connecting sockets.
 * The factory encapsulates the logic for establishing a socket connection.
 * <br/>
 * Both {@link java.lang.Object#equals(java.lang.Object) Object.equals()}
 * and {@link java.lang.Object#hashCode() Object.hashCode()}
 * must be overridden for the correct operation of some connection managers.
 *
 * @author <a href="mailto:rolandw at apache.org">Roland Weber</a>
 * @author Michael Becke
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 *
 * @deprecated Please use {@link java.net.URL#openConnection} instead.
 *     Please visit <a href="http://android-developers.blogspot.com/2011/09/androids-http-clients.html">this webpage</a>
 *     for further details.
 * @apiSince 1
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public interface SocketFactory {

/**
 * Creates a new, unconnected socket.
 * The socket should subsequently be passed to
 * {@link #connectSocket connectSocket}.
 *
 * @return  a new socket
 *
 * @throws java.io.IOException if an I/O error occurs while creating the socket
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public java.net.Socket createSocket() throws java.io.IOException;

/**
 * Connects a socket to the given host.
 *
 * @param sock      the socket to connect, as obtained from
 *                  {@link #createSocket createSocket}.
 *                  <code>null</code> indicates that a new socket
 *                  should be created and connected.
 * @param host      the host to connect to
 * @param port      the port to connect to on the host
 * @param localAddress the local address to bind the socket to, or
 *                  <code>null</code> for any
 * @param localPort the port on the local machine,
 *                  0 or a negative number for any
 * @param params    additional {@link org.apache.http.params.HttpParams HttpParams} for connecting
 *
 * @return  the connected socket. The returned object may be different
 *          from the <code>sock</code> argument if this factory supports
 *          a layered protocol.
 *
 * @throws java.io.IOException if an I/O error occurs
 * @throws java.net.UnknownHostException if the IP address of the target host
 *          can not be determined
 * @throws org.apache.http.conn.ConnectTimeoutException if the socket cannot be connected
 *          within the time limit defined in the <code>params</code>
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public java.net.Socket connectSocket(java.net.Socket sock, java.lang.String host, int port, java.net.InetAddress localAddress, int localPort, org.apache.http.params.HttpParams params) throws org.apache.http.conn.ConnectTimeoutException, java.io.IOException, java.net.UnknownHostException;

/**
 * Checks whether a socket provides a secure connection.
 * The socket must be {@link #connectSocket connected}
 * by this factory.
 * The factory will <i>not</i> perform I/O operations
 * in this method.
 * <br/>
 * As a rule of thumb, plain sockets are not secure and
 * TLS/SSL sockets are secure. However, there may be
 * application specific deviations. For example, a plain
 * socket to a host in the same intranet ("trusted zone")
 * could be considered secure. On the other hand, a
 * TLS/SSL socket could be considered insecure based on
 * the cypher suite chosen for the connection.
 *
 * @param sock      the connected socket to check
 *
 * @return  <code>true</code> if the connection of the socket
 *          should be considered secure, or
 *          <code>false</code> if it should not
 *
 * @throws java.lang.IllegalArgumentException
 *  if the argument is invalid, for example because it is
 *  not a connected socket or was created by a different
 *  socket factory.
 *  Note that socket factories are <i>not</i> required to
 *  check these conditions, they may simply return a default
 *  value when called with an invalid socket argument.
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public boolean isSecure(java.net.Socket sock) throws java.lang.IllegalArgumentException;
}
