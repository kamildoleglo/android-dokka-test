/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.net;

import java.io.InputStream;
import java.io.IOException;

/**
 * A URLConnection with support for HTTP-specific features. See
 * <A HREF="http://www.w3.org/pub/WWW/Protocols/"> the spec </A> for
 * details.
 * <p>
 *
 * <p>Uses of this class follow a pattern:
 * <ol>
 *   <li>Obtain a new {@code HttpURLConnection} by calling {@link java.net.URL#openConnection() URL#openConnection()} and casting the result to
 *       {@code HttpURLConnection}.
 *   <li>Prepare the request. The primary property of a request is its URI.
 *       Request headers may also include metadata such as credentials, preferred
 *       content types, and session cookies.
 *   <li>Optionally upload a request body. Instances must be configured with
 *       {@link #setDoOutput(boolean) setDoOutput(true)} if they include a
 *       request body. Transmit data by writing to the stream returned by {@link
 *       #getOutputStream()}.
 *   <li>Read the response. Response headers typically include metadata such as
 *       the response body's content type and length, modified dates and session
 *       cookies. The response body may be read from the stream returned by {@link
 *       #getInputStream()}. If the response has no body, that method returns an
 *       empty stream.
 *   <li>Disconnect. Once the response body has been read, the {@code
 *       HttpURLConnection} should be closed by calling {@link #disconnect()}.
 *       Disconnecting releases the resources held by a connection so they may
 *       be closed or reused.
 * </ol>
 *
 * <p>For example, to retrieve the webpage at {@code http://www.android.com/}:
 * <pre>   {@code
 *   URL url = new URL("http://www.android.com/");
 *   HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
 *   try {
 *     InputStream in = new BufferedInputStream(urlConnection.getInputStream());
 *     readStream(in);
 *   } finally {
 *     urlConnection.disconnect();
 *   }
 * }</pre>
 *
 * <h3>Secure Communication with HTTPS</h3>
 * Calling {@link java.net.URL#openConnection() URL#openConnection()} on a URL with the "https"
 * scheme will return an {@code HttpsURLConnection}, which allows for
 * overriding the default {@link javax.net.ssl.HostnameVerifier
 * HostnameVerifier} and {@link javax.net.ssl.SSLSocketFactory
 * SSLSocketFactory}. An application-supplied {@code SSLSocketFactory}
 * created from an {@link javax.net.ssl.SSLContext SSLContext} can
 * provide a custom {@link javax.net.ssl.X509TrustManager
 * X509TrustManager} for verifying certificate chains and a custom
 * {@link javax.net.ssl.X509KeyManager X509KeyManager} for supplying
 * client certificates. See {@link javax.net.ssl.HttpsURLConnection
 * HttpsURLConnection} for more details.
 *
 * <h3>Response Handling</h3>
 * {@code HttpURLConnection} will follow up to five HTTP redirects. It will
 * follow redirects from one origin server to another. This implementation
 * doesn't follow redirects from HTTPS to HTTP or vice versa.
 *
 * <p>If the HTTP response indicates that an error occurred, {@link
 * #getInputStream()} will throw an {@link java.io.IOException IOException}. Use {@link
 * #getErrorStream()} to read the error response. The headers can be read in
 * the normal way using {@link #getHeaderFields()},
 *
 * <h3>Posting Content</h3>
 * To upload data to a web server, configure the connection for output using
 * {@link #setDoOutput(boolean) setDoOutput(true)}.
 *
 * <p>For best performance, you should call either {@link
 * #setFixedLengthStreamingMode(int)} when the body length is known in advance,
 * or {@link #setChunkedStreamingMode(int)} when it is not. Otherwise {@code
 * HttpURLConnection} will be forced to buffer the complete request body in
 * memory before it is transmitted, wasting (and possibly exhausting) heap and
 * increasing latency.
 *
 * <p>For example, to perform an upload: <pre>   {@code
 *   HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
 *   try {
 *     urlConnection.setDoOutput(true);
 *     urlConnection.setChunkedStreamingMode(0);
 *
 *     OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
 *     writeStream(out);
 *
 *     InputStream in = new BufferedInputStream(urlConnection.getInputStream());
 *     readStream(in);
 *   } finally {
 *     urlConnection.disconnect();
 *   }
 * }</pre>
 *
 * <h3>Performance</h3>
 * The input and output streams returned by this class are <strong>not
 * buffered</strong>. Most callers should wrap the returned streams with {@link
 * java.io.BufferedInputStream BufferedInputStream} or {@link
 * java.io.BufferedOutputStream BufferedOutputStream}. Callers that do only bulk
 * reads or writes may omit buffering.
 *
 * <p>When transferring large amounts of data to or from a server, use streams
 * to limit how much data is in memory at once. Unless you need the entire
 * body to be in memory at once, process it as a stream (rather than storing
 * the complete body as a single byte array or string).
 *
 * <p>To reduce latency, this class may reuse the same underlying {@code Socket}
 * for multiple request/response pairs. As a result, HTTP connections may be
 * held open longer than necessary. Calls to {@link #disconnect()} may return
 * the socket to a pool of connected sockets.
 *
 * <p>By default, this implementation of {@code HttpURLConnection} requests that
 * servers use gzip compression and it automatically decompresses the data for
 * callers of {@link #getInputStream()}. The Content-Encoding and Content-Length
 * response headers are cleared in this case. Gzip compression can be disabled by
 * setting the acceptable encodings in the request header: <pre>   {@code
 *   urlConnection.setRequestProperty("Accept-Encoding", "identity");
 * }</pre>
 *
 * <p>Setting the Accept-Encoding request header explicitly disables automatic
 * decompression and leaves the response headers intact; callers must handle
 * decompression as needed, according to the Content-Encoding header of the
 * response.
 *
 * <p>{@link #getContentLength()} returns the number of bytes transmitted and
 * cannot be used to predict how many bytes can be read from
 * {@link #getInputStream()} for compressed streams. Instead, read that stream
 * until it is exhausted, i.e. when {@link java.io.InputStream#read InputStream#read} returns -1.
 *
 * <h3>Handling Network Sign-On</h3>
 * Some Wi-Fi networks block Internet access until the user clicks through a
 * sign-on page. Such sign-on pages are typically presented by using HTTP
 * redirects. You can use {@link #getURL()} to test if your connection has been
 * unexpectedly redirected. This check is not valid until <strong>after</strong>
 * the response headers have been received, which you can trigger by calling
 * {@link #getHeaderFields()} or {@link #getInputStream()}. For example, to
 * check that a response was not redirected to an unexpected host:
 * <pre>   {@code
 *   HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
 *   try {
 *     InputStream in = new BufferedInputStream(urlConnection.getInputStream());
 *     if (!url.getHost().equals(urlConnection.getURL().getHost())) {
 *       // we were redirected! Kick the user out to the browser to sign on?
 *     }
 *     ...
 *   } finally {
 *     urlConnection.disconnect();
 *   }
 * }</pre>
 *
 * <h3>HTTP Authentication</h3>
 * {@code HttpURLConnection} supports <a
 * href="http://www.ietf.org/rfc/rfc2617">HTTP basic authentication</a>. Use
 * {@link java.net.Authenticator Authenticator} to set the VM-wide authentication handler:
 * <pre>   {@code
 *   Authenticator.setDefault(new Authenticator() {
 *     protected PasswordAuthentication getPasswordAuthentication() {
 *       return new PasswordAuthentication(username, password.toCharArray());
 *     }
 *   });
 * }</pre>
 * Unless paired with HTTPS, this is <strong>not</strong> a secure mechanism for
 * user authentication. In particular, the username, password, request and
 * response are all transmitted over the network without encryption.
 *
 * <h3>Sessions with Cookies</h3>
 * To establish and maintain a potentially long-lived session between client
 * and server, {@code HttpURLConnection} includes an extensible cookie manager.
 * Enable VM-wide cookie management using {@link java.net.CookieHandler CookieHandler} and {@link java.net.CookieManager CookieManager}: <pre>   {@code
 *   CookieManager cookieManager = new CookieManager();
 *   CookieHandler.setDefault(cookieManager);
 * }</pre>
 * By default, {@code CookieManager} accepts cookies from the <a
 * href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec1.html">origin
 * server</a> only. Two other policies are included: {@link java.net.CookiePolicy#ACCEPT_ALL CookiePolicy#ACCEPT_ALL} and {@link java.net.CookiePolicy#ACCEPT_NONE CookiePolicy#ACCEPT_NONE}. Implement
 * {@link java.net.CookiePolicy CookiePolicy} to define a custom policy.
 *
 * <p>The default {@code CookieManager} keeps all accepted cookies in memory. It
 * will forget these cookies when the VM exits. Implement {@link java.net.CookieStore CookieStore} to
 * define a custom cookie store.
 *
 * <p>In addition to the cookies set by HTTP responses, you may set cookies
 * programmatically. To be included in HTTP request headers, cookies must have
 * the domain and path properties set.
 *
 * <p>By default, new instances of {@code HttpCookie} work only with servers
 * that support <a href="http://www.ietf.org/rfc/rfc2965.txt">RFC 2965</a>
 * cookies. Many web servers support only the older specification, <a
 * href="http://www.ietf.org/rfc/rfc2109.txt">RFC 2109</a>. For compatibility
 * with the most web servers, set the cookie version to 0.
 *
 * <p>For example, to receive {@code www.twitter.com} in French: <pre>   {@code
 *   HttpCookie cookie = new HttpCookie("lang", "fr");
 *   cookie.setDomain("twitter.com");
 *   cookie.setPath("/");
 *   cookie.setVersion(0);
 *   cookieManager.getCookieStore().add(new URI("http://twitter.com/"), cookie);
 * }</pre>
 *
 * <h3>HTTP Methods</h3>
 * <p>{@code HttpURLConnection} uses the {@code GET} method by default. It will
 * use {@code POST} if {@link #setDoOutput setDoOutput(true)} has been called.
 * Other HTTP methods ({@code OPTIONS}, {@code HEAD}, {@code PUT}, {@code
 * DELETE} and {@code TRACE}) can be used with {@link #setRequestMethod}.
 *
 * <h3>Proxies</h3>
 * By default, this class will connect directly to the <a
 * href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec1.html">origin
 * server</a>. It can also connect via an {@link java.net.Proxy.Type#HTTP Proxy.Type#HTTP} or {@link java.net.Proxy.Type#SOCKS Proxy.Type#SOCKS} proxy. To use a proxy, use {@link java.net.URL#openConnection(java.net.Proxy) URL#openConnection(Proxy)} when creating the
 * connection.
 *
 * <h3>IPv6 Support</h3>
 * <p>This class includes transparent support for IPv6. For hosts with both IPv4
 * and IPv6 addresses, it will attempt to connect to each of a host's addresses
 * until a connection is established.
 *
 * <h3>Response Caching</h3>
 * Android 4.0 (Ice Cream Sandwich, API level 15) includes a response cache. See
 * {@code android.net.http.HttpResponseCache} for instructions on enabling HTTP
 * caching in your application.
 *
 * <h3>Avoiding Bugs In Earlier Releases</h3>
 * Prior to Android 2.2 (Froyo), this class had some frustrating bugs. In
 * particular, calling {@code close()} on a readable {@code InputStream} could
 * <a href="http://code.google.com/p/android/issues/detail?id=2939">poison the
 * connection pool</a>. Work around this by disabling connection pooling:
 * <pre>   {@code
 * private void disableConnectionReuseIfNecessary() {
 *   // Work around pre-Froyo bugs in HTTP connection reuse.
 *   if (Integer.parseInt(Build.VERSION.SDK) < Build.VERSION_CODES.FROYO) {
 *     System.setProperty("http.keepAlive", "false");
 *   }
 * }}</pre>
 *
 * <p>Each instance of {@code HttpURLConnection} may be used for one
 * request/response pair. Instances of this class are not thread safe.
 *
 * @see     java.net.HttpURLConnection#disconnect()
 * @since JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class HttpURLConnection extends java.net.URLConnection {

/**
 * Constructor for the HttpURLConnection.
 * @param u the URL
 * @apiSince 1
 */

protected HttpURLConnection(java.net.URL u) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the key for the {@code n}<sup>th</sup> header field.
 * Some implementations may treat the {@code 0}<sup>th</sup>
 * header field as special, i.e. as the status line returned by the HTTP
 * server. In this case, {@link #getHeaderField(int) getHeaderField(0)} returns the status
 * line, but {@code getHeaderFieldKey(0)} returns null.
 *
 * @param   n   an index, where {@code n >=0}.
 * @return  the key for the {@code n}<sup>th</sup> header field,
 *          or {@code null} if the key does not exist.
 * @apiSince 1
 */

public java.lang.String getHeaderFieldKey(int n) { throw new RuntimeException("Stub!"); }

/**
 * This method is used to enable streaming of a HTTP request body
 * without internal buffering, when the content length is known in
 * advance.
 * <p>
 * An exception will be thrown if the application
 * attempts to write more data than the indicated
 * content-length, or if the application closes the OutputStream
 * before writing the indicated amount.
 * <p>
 * When output streaming is enabled, authentication
 * and redirection cannot be handled automatically.
 * A HttpRetryException will be thrown when reading
 * the response if authentication or redirection are required.
 * This exception can be queried for the details of the error.
 * <p>
 * This method must be called before the URLConnection is connected.
 * <p>
 * <B>NOTE:</B> {@link #setFixedLengthStreamingMode(long)} is recommended
 * instead of this method as it allows larger content lengths to be set.
 *
 * @param   contentLength The number of bytes which will be written
 *          to the OutputStream.
 *
 * @throws  java.lang.IllegalStateException if URLConnection is already connected
 *          or if a different streaming mode is already enabled.
 *
 * @throws  java.lang.IllegalArgumentException if a content length less than
 *          zero is specified.
 *
 * @see     #setChunkedStreamingMode(int)
 * @since 1.5
 * @apiSince 1
 */

public void setFixedLengthStreamingMode(int contentLength) { throw new RuntimeException("Stub!"); }

/**
 * This method is used to enable streaming of a HTTP request body
 * without internal buffering, when the content length is known in
 * advance.
 *
 * <P> An exception will be thrown if the application attempts to write
 * more data than the indicated content-length, or if the application
 * closes the OutputStream before writing the indicated amount.
 *
 * <P> When output streaming is enabled, authentication and redirection
 * cannot be handled automatically. A {@linkplain java.net.HttpRetryException HttpRetryException} will
 * be thrown when reading the response if authentication or redirection
 * are required. This exception can be queried for the details of the
 * error.
 *
 * <P> This method must be called before the URLConnection is connected.
 *
 * <P> The content length set by invoking this method takes precedence
 * over any value set by {@link #setFixedLengthStreamingMode(int)}.
 *
 * @param  contentLength
 *         The number of bytes which will be written to the OutputStream.
 *
 * @throws  java.lang.IllegalStateException
 *          if URLConnection is already connected or if a different
 *          streaming mode is already enabled.
 *
 * @throws  java.lang.IllegalArgumentException
 *          if a content length less than zero is specified.
 *
 * @since 1.7
 * @apiSince 19
 */

public void setFixedLengthStreamingMode(long contentLength) { throw new RuntimeException("Stub!"); }

/**
 * This method is used to enable streaming of a HTTP request body
 * without internal buffering, when the content length is <b>not</b>
 * known in advance. In this mode, chunked transfer encoding
 * is used to send the request body. Note, not all HTTP servers
 * support this mode.
 * <p>
 * When output streaming is enabled, authentication
 * and redirection cannot be handled automatically.
 * A HttpRetryException will be thrown when reading
 * the response if authentication or redirection are required.
 * This exception can be queried for the details of the error.
 * <p>
 * This method must be called before the URLConnection is connected.
 *
 * @param   chunklen The number of bytes to write in each chunk.
 *          If chunklen is less than or equal to zero, a default
 *          value will be used.
 *
 * @throws  java.lang.IllegalStateException if URLConnection is already connected
 *          or if a different streaming mode is already enabled.
 *
 * @see     #setFixedLengthStreamingMode(int)
 * @since 1.5
 * @apiSince 1
 */

public void setChunkedStreamingMode(int chunklen) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value for the {@code n}<sup>th</sup> header field.
 * Some implementations may treat the {@code 0}<sup>th</sup>
 * header field as special, i.e. as the status line returned by the HTTP
 * server.
 * <p>
 * This method can be used in conjunction with the
 * {@link #getHeaderFieldKey getHeaderFieldKey} method to iterate through all
 * the headers in the message.
 *
 * @param   n   an index, where {@code n>=0}.
 * @return  the value of the {@code n}<sup>th</sup> header field,
 *          or {@code null} if the value does not exist.
 * @see     java.net.HttpURLConnection#getHeaderFieldKey(int)
 * @apiSince 1
 */

public java.lang.String getHeaderField(int n) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether HTTP redirects  (requests with response code 3xx) should
 * be automatically followed by this class.  True by default.  Applets
 * cannot change this variable.
 * <p>
 * If there is a security manager, this method first calls
 * the security manager's {@code checkSetFactory} method
 * to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @param set a {@code boolean} indicating whether or not
 * to follow HTTP redirects.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkSetFactory} method doesn't
 *             allow the operation.
 * @see        java.lang.SecurityManager#checkSetFactory
 * @see #getFollowRedirects()
 * @apiSince 1
 */

public static void setFollowRedirects(boolean set) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code boolean} indicating
 * whether or not HTTP redirects (3xx) should
 * be automatically followed.
 *
 * @return {@code true} if HTTP redirects should
 * be automatically followed, {@code false} if not.
 * @see #setFollowRedirects(boolean)
 * @apiSince 1
 */

public static boolean getFollowRedirects() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether HTTP redirects (requests with response code 3xx) should
 * be automatically followed by this {@code HttpURLConnection}
 * instance.
 * <p>
 * The default value comes from followRedirects, which defaults to
 * true.
 *
 * @param followRedirects a {@code boolean} indicating
 * whether or not to follow HTTP redirects.
 *
 * @see    java.net.HttpURLConnection#instanceFollowRedirects
 * @see #getInstanceFollowRedirects
 * @since 1.3
 * @apiSince 1
 */

public void setInstanceFollowRedirects(boolean followRedirects) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code HttpURLConnection}'s
 * {@code instanceFollowRedirects} field.
 *
 * @return  the value of this {@code HttpURLConnection}'s
 *          {@code instanceFollowRedirects} field.
 * @see     java.net.HttpURLConnection#instanceFollowRedirects
 * @see #setInstanceFollowRedirects(boolean)
 * @since 1.3
 * @apiSince 1
 */

public boolean getInstanceFollowRedirects() { throw new RuntimeException("Stub!"); }

/**
 * Set the method for the URL request, one of:
 * <UL>
 *  <LI>GET
 *  <LI>POST
 *  <LI>HEAD
 *  <LI>OPTIONS
 *  <LI>PUT
 *  <LI>DELETE
 *  <LI>TRACE
 * </UL> are legal, subject to protocol restrictions.  The default
 * method is GET.
 *
 * @param method the HTTP method
 * @exception java.net.ProtocolException if the method cannot be reset or if
 *              the requested method isn't valid for HTTP.
 * @exception java.lang.SecurityException if a security manager is set and the
 *              method is "TRACE", but the "allowHttpTrace"
 *              NetPermission is not granted.
 * @see #getRequestMethod()
 * @apiSince 1
 */

public void setRequestMethod(java.lang.String method) throws java.net.ProtocolException { throw new RuntimeException("Stub!"); }

/**
 * Get the request method.
 * @return the HTTP request method
 * @see #setRequestMethod(java.lang.String)
 * @apiSince 1
 */

public java.lang.String getRequestMethod() { throw new RuntimeException("Stub!"); }

/**
 * Gets the status code from an HTTP response message.
 * For example, in the case of the following status lines:
 * <PRE>
 * HTTP/1.0 200 OK
 * HTTP/1.0 401 Unauthorized
 * </PRE>
 * It will return 200 and 401 respectively.
 * Returns -1 if no code can be discerned
 * from the response (i.e., the response is not valid HTTP).
 * @throws java.io.IOException if an error occurred connecting to the server.
 * @return the HTTP Status-Code, or -1
 * @apiSince 1
 */

public int getResponseCode() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Gets the HTTP response message, if any, returned along with the
 * response code from a server.  From responses like:
 * <PRE>
 * HTTP/1.0 200 OK
 * HTTP/1.0 404 Not Found
 * </PRE>
 * Extracts the Strings "OK" and "Not Found" respectively.
 * Returns null if none could be discerned from the responses
 * (the result was not valid HTTP).
 * @throws java.io.IOException if an error occurred connecting to the server.
 * @return the HTTP response message, or {@code null}
 * @apiSince 1
 */

public java.lang.String getResponseMessage() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getHeaderFieldDate(java.lang.String name, long Default) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that other requests to the server
 * are unlikely in the near future. Calling disconnect()
 * should not imply that this HttpURLConnection
 * instance can be reused for other requests.
 * @apiSince 1
 */

public abstract void disconnect();

/**
 * Indicates if the connection is going through a proxy.
 * @return a boolean indicating if the connection is
 * using a proxy.
 * @apiSince 1
 */

public abstract boolean usingProxy();

/**
 * Returns a {@link java.net.SocketPermission SocketPermission} object representing the
 * permission necessary to connect to the destination host and port.
 *
 * @exception java.io.IOException if an error occurs while computing
 *            the permission.
 *
 * @return a {@code SocketPermission} object representing the
 *         permission necessary to connect to the destination
 *         host and port.
 * @apiSince 1
 */

public java.security.Permission getPermission() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the error stream if the connection failed
 * but the server sent useful data nonetheless. The
 * typical example is when an HTTP server responds
 * with a 404, which will cause a FileNotFoundException
 * to be thrown in connect, but the server sent an HTML
 * help page with suggestions as to what to do.
 *
 * <p>This method will not cause a connection to be initiated.  If
 * the connection was not connected, or if the server did not have
 * an error while connecting or if the server had an error but
 * no error data was sent, this method will return null. This is
 * the default.
 *
 * @return an error stream if any, null if there have been no
 * errors, the connection is not connected or the server sent no
 * useful data.
 * @apiSince 1
 */

public java.io.InputStream getErrorStream() { throw new RuntimeException("Stub!"); }

/**
 * HTTP Status-Code 202: Accepted.
 * @apiSince 1
 */

public static final int HTTP_ACCEPTED = 202; // 0xca

/**
 * HTTP Status-Code 502: Bad Gateway.
 * @apiSince 1
 */

public static final int HTTP_BAD_GATEWAY = 502; // 0x1f6

/**
 * HTTP Status-Code 405: Method Not Allowed.
 * @apiSince 1
 */

public static final int HTTP_BAD_METHOD = 405; // 0x195

/**
 * HTTP Status-Code 400: Bad Request.
 * @apiSince 1
 */

public static final int HTTP_BAD_REQUEST = 400; // 0x190

/**
 * HTTP Status-Code 408: Request Time-Out.
 * @apiSince 1
 */

public static final int HTTP_CLIENT_TIMEOUT = 408; // 0x198

/**
 * HTTP Status-Code 409: Conflict.
 * @apiSince 1
 */

public static final int HTTP_CONFLICT = 409; // 0x199

/**
 * HTTP Status-Code 201: Created.
 * @apiSince 1
 */

public static final int HTTP_CREATED = 201; // 0xc9

/**
 * HTTP Status-Code 413: Request Entity Too Large.
 * @apiSince 1
 */

public static final int HTTP_ENTITY_TOO_LARGE = 413; // 0x19d

/**
 * HTTP Status-Code 403: Forbidden.
 * @apiSince 1
 */

public static final int HTTP_FORBIDDEN = 403; // 0x193

/**
 * HTTP Status-Code 504: Gateway Timeout.
 * @apiSince 1
 */

public static final int HTTP_GATEWAY_TIMEOUT = 504; // 0x1f8

/**
 * HTTP Status-Code 410: Gone.
 * @apiSince 1
 */

public static final int HTTP_GONE = 410; // 0x19a

/**
 * HTTP Status-Code 500: Internal Server Error.
 * @apiSince 1
 */

public static final int HTTP_INTERNAL_ERROR = 500; // 0x1f4

/**
 * HTTP Status-Code 411: Length Required.
 * @apiSince 1
 */

public static final int HTTP_LENGTH_REQUIRED = 411; // 0x19b

/**
 * HTTP Status-Code 301: Moved Permanently.
 * @apiSince 1
 */

public static final int HTTP_MOVED_PERM = 301; // 0x12d

/**
 * HTTP Status-Code 302: Temporary Redirect.
 * @apiSince 1
 */

public static final int HTTP_MOVED_TEMP = 302; // 0x12e

/**
 * HTTP Status-Code 300: Multiple Choices.
 * @apiSince 1
 */

public static final int HTTP_MULT_CHOICE = 300; // 0x12c

/**
 * HTTP Status-Code 406: Not Acceptable.
 * @apiSince 1
 */

public static final int HTTP_NOT_ACCEPTABLE = 406; // 0x196

/**
 * HTTP Status-Code 203: Non-Authoritative Information.
 * @apiSince 1
 */

public static final int HTTP_NOT_AUTHORITATIVE = 203; // 0xcb

/**
 * HTTP Status-Code 404: Not Found.
 * @apiSince 1
 */

public static final int HTTP_NOT_FOUND = 404; // 0x194

/**
 * HTTP Status-Code 501: Not Implemented.
 * @apiSince 1
 */

public static final int HTTP_NOT_IMPLEMENTED = 501; // 0x1f5

/**
 * HTTP Status-Code 304: Not Modified.
 * @apiSince 1
 */

public static final int HTTP_NOT_MODIFIED = 304; // 0x130

/**
 * HTTP Status-Code 204: No Content.
 * @apiSince 1
 */

public static final int HTTP_NO_CONTENT = 204; // 0xcc

/**
 * HTTP Status-Code 200: OK.
 * @apiSince 1
 */

public static final int HTTP_OK = 200; // 0xc8

/**
 * HTTP Status-Code 206: Partial Content.
 * @apiSince 1
 */

public static final int HTTP_PARTIAL = 206; // 0xce

/**
 * HTTP Status-Code 402: Payment Required.
 * @apiSince 1
 */

public static final int HTTP_PAYMENT_REQUIRED = 402; // 0x192

/**
 * HTTP Status-Code 412: Precondition Failed.
 * @apiSince 1
 */

public static final int HTTP_PRECON_FAILED = 412; // 0x19c

/**
 * HTTP Status-Code 407: Proxy Authentication Required.
 * @apiSince 1
 */

public static final int HTTP_PROXY_AUTH = 407; // 0x197

/**
 * HTTP Status-Code 414: Request-URI Too Large.
 * @apiSince 1
 */

public static final int HTTP_REQ_TOO_LONG = 414; // 0x19e

/**
 * HTTP Status-Code 205: Reset Content.
 * @apiSince 1
 */

public static final int HTTP_RESET = 205; // 0xcd

/**
 * HTTP Status-Code 303: See Other.
 * @apiSince 1
 */

public static final int HTTP_SEE_OTHER = 303; // 0x12f

/**
 * HTTP Status-Code 500: Internal Server Error.
 * @deprecated   it is misplaced and shouldn't have existed.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int HTTP_SERVER_ERROR = 500; // 0x1f4

/**
 * HTTP Status-Code 401: Unauthorized.
 * @apiSince 1
 */

public static final int HTTP_UNAUTHORIZED = 401; // 0x191

/**
 * HTTP Status-Code 503: Service Unavailable.
 * @apiSince 1
 */

public static final int HTTP_UNAVAILABLE = 503; // 0x1f7

/**
 * HTTP Status-Code 415: Unsupported Media Type.
 * @apiSince 1
 */

public static final int HTTP_UNSUPPORTED_TYPE = 415; // 0x19f

/**
 * HTTP Status-Code 305: Use Proxy.
 * @apiSince 1
 */

public static final int HTTP_USE_PROXY = 305; // 0x131

/**
 * HTTP Status-Code 505: HTTP Version Not Supported.
 * @apiSince 1
 */

public static final int HTTP_VERSION = 505; // 0x1f9

/**
 * The chunk-length when using chunked encoding streaming mode for output.
 * A value of {@code -1} means chunked encoding is disabled for output.
 * @since 1.5
 * @apiSince 1
 */

protected int chunkLength = -1; // 0xffffffff

/**
 * The fixed content-length when using fixed-length streaming mode.
 * A value of {@code -1} means fixed-length streaming mode is disabled
 * for output.
 *
 * <P> <B>NOTE:</B> {@link #fixedContentLengthLong} is recommended instead
 * of this field, as it allows larger content lengths to be set.
 *
 * @since 1.5
 * @apiSince 1
 */

protected int fixedContentLength = -1; // 0xffffffff

/**
 * The fixed content-length when using fixed-length streaming mode.
 * A value of {@code -1} means fixed-length streaming mode is disabled
 * for output.
 *
 * @since 1.7
 * @apiSince 19
 */

protected long fixedContentLengthLong = -1; // 0xffffffff

/**
 * If {@code true}, the protocol will automatically follow redirects.
 * If {@code false}, the protocol will not automatically follow
 * redirects.
 * <p>
 * This field is set by the {@code setInstanceFollowRedirects}
 * method. Its value is returned by the {@code getInstanceFollowRedirects}
 * method.
 * <p>
 * Its default value is based on the value of the static followRedirects
 * at HttpURLConnection construction time.
 *
 * @see     java.net.HttpURLConnection#setInstanceFollowRedirects(boolean)
 * @see     java.net.HttpURLConnection#getInstanceFollowRedirects()
 * @see     java.net.HttpURLConnection#setFollowRedirects(boolean)
 * @apiSince 1
 */

protected boolean instanceFollowRedirects;

/**
 * The HTTP method (GET,POST,PUT,etc.).
 * @apiSince 1
 */

protected java.lang.String method = "GET";

/**
 * An {@code int} representing the three digit HTTP Status-Code.
 * <ul>
 * <li> 1xx: Informational
 * <li> 2xx: Success
 * <li> 3xx: Redirection
 * <li> 4xx: Client Error
 * <li> 5xx: Server Error
 * </ul>
 * @apiSince 1
 */

protected int responseCode = -1; // 0xffffffff

/**
 * The HTTP response message.
 * @apiSince 1
 */

protected java.lang.String responseMessage;
}

