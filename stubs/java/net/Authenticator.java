/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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


/**
 * The class Authenticator represents an object that knows how to obtain
 * authentication for a network connection.  Usually, it will do this
 * by prompting the user for information.
 * <p>
 * Applications use this class by overriding {@link
 * #getPasswordAuthentication()} in a sub-class. This method will
 * typically use the various getXXX() accessor methods to get information
 * about the entity requesting authentication. It must then acquire a
 * username and password either by interacting with the user or through
 * some other non-interactive means. The credentials are then returned
 * as a {@link java.net.PasswordAuthentication PasswordAuthentication} return value.
 * <p>
 * An instance of this concrete sub-class is then registered
 * with the system by calling {@link #setDefault(java.net.Authenticator)}.
 * When authentication is required, the system will invoke one of the
 * requestPasswordAuthentication() methods which in turn will call the
 * getPasswordAuthentication() method of the registered object.
 * <p>
 * All methods that request authentication have a default implementation
 * that fails.
 *
 * @see java.net.Authenticator#setDefault(java.net.Authenticator)
 * @see java.net.Authenticator#getPasswordAuthentication()
 *
 * @author  Bill Foote
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Authenticator {

/** @apiSince 1 */

public Authenticator() { throw new RuntimeException("Stub!"); }

/**
 * Sets the authenticator that will be used by the networking code
 * when a proxy or an HTTP server asks for authentication.
 * <p>
 * First, if there is a security manager, its {@code checkPermission}
 * method is called with a
 * {@code NetPermission("setDefaultAuthenticator")} permission.
 * This may result in a java.lang.SecurityException.
 *
 * @param   a       The authenticator to be set. If a is {@code null} then
 *                  any previously set authenticator is removed.
 *
 * @throws java.lang.SecurityException
 *        if a security manager exists and its
 *        {@code checkPermission} method doesn't allow
 *        setting the default authenticator.
 *
 * @see SecurityManager#checkPermission
 * @see java.net.NetPermission
 * @apiSince 1
 */

public static synchronized void setDefault(java.net.Authenticator a) { throw new RuntimeException("Stub!"); }

/**
 * Ask the authenticator that has been registered with the system
 * for a password.
 * <p>
 * First, if there is a security manager, its {@code checkPermission}
 * method is called with a
 * {@code NetPermission("requestPasswordAuthentication")} permission.
 * This may result in a java.lang.SecurityException.
 *
 * @param addr The InetAddress of the site requesting authorization,
 *             or null if not known.
 * @param port the port for the requested connection
 * @param protocol The protocol that's requesting the connection
 *          ({@link java.net.Authenticator#getRequestingProtocol()})
 * @param prompt A prompt string for the user
 * @param scheme The authentication scheme
 *
 * @return The username/password, or null if one can't be gotten.
 *
 * @throws java.lang.SecurityException
 *        if a security manager exists and its
 *        {@code checkPermission} method doesn't allow
 *        the password authentication request.
 *
 * @see SecurityManager#checkPermission
 * @see java.net.NetPermission
 * @apiSince 1
 */

public static java.net.PasswordAuthentication requestPasswordAuthentication(java.net.InetAddress addr, int port, java.lang.String protocol, java.lang.String prompt, java.lang.String scheme) { throw new RuntimeException("Stub!"); }

/**
 * Ask the authenticator that has been registered with the system
 * for a password. This is the preferred method for requesting a password
 * because the hostname can be provided in cases where the InetAddress
 * is not available.
 * <p>
 * First, if there is a security manager, its {@code checkPermission}
 * method is called with a
 * {@code NetPermission("requestPasswordAuthentication")} permission.
 * This may result in a java.lang.SecurityException.
 *
 * @param host The hostname of the site requesting authentication.
 * @param addr The InetAddress of the site requesting authentication,
 *             or null if not known.
 * @param port the port for the requested connection.
 * @param protocol The protocol that's requesting the connection
 *          ({@link java.net.Authenticator#getRequestingProtocol()})
 * @param prompt A prompt string for the user which identifies the authentication realm.
 * @param scheme The authentication scheme
 *
 * @return The username/password, or null if one can't be gotten.
 *
 * @throws java.lang.SecurityException
 *        if a security manager exists and its
 *        {@code checkPermission} method doesn't allow
 *        the password authentication request.
 *
 * @see SecurityManager#checkPermission
 * @see java.net.NetPermission
 * @since 1.4
 * @apiSince 1
 */

public static java.net.PasswordAuthentication requestPasswordAuthentication(java.lang.String host, java.net.InetAddress addr, int port, java.lang.String protocol, java.lang.String prompt, java.lang.String scheme) { throw new RuntimeException("Stub!"); }

/**
 * Ask the authenticator that has been registered with the system
 * for a password.
 * <p>
 * First, if there is a security manager, its {@code checkPermission}
 * method is called with a
 * {@code NetPermission("requestPasswordAuthentication")} permission.
 * This may result in a java.lang.SecurityException.
 *
 * @param host The hostname of the site requesting authentication.
 * @param addr The InetAddress of the site requesting authorization,
 *             or null if not known.
 * @param port the port for the requested connection
 * @param protocol The protocol that's requesting the connection
 *          ({@link java.net.Authenticator#getRequestingProtocol()})
 * @param prompt A prompt string for the user
 * @param scheme The authentication scheme
 * @param url The requesting URL that caused the authentication
 * @param reqType The type (server or proxy) of the entity requesting
 *              authentication.
 *
 * @return The username/password, or null if one can't be gotten.
 *
 * @throws java.lang.SecurityException
 *        if a security manager exists and its
 *        {@code checkPermission} method doesn't allow
 *        the password authentication request.
 *
 * @see SecurityManager#checkPermission
 * @see java.net.NetPermission
 *
 * @since 1.5
 * @apiSince 1
 */

public static java.net.PasswordAuthentication requestPasswordAuthentication(java.lang.String host, java.net.InetAddress addr, int port, java.lang.String protocol, java.lang.String prompt, java.lang.String scheme, java.net.URL url, java.net.Authenticator.RequestorType reqType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code hostname} of the
 * site or proxy requesting authentication, or {@code null}
 * if not available.
 *
 * @return the hostname of the connection requiring authentication, or null
 *          if it's not available.
 * @since 1.4
 * @apiSince 1
 */

protected final java.lang.String getRequestingHost() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code InetAddress} of the
 * site requesting authorization, or {@code null}
 * if not available.
 *
 * @return the InetAddress of the site requesting authorization, or null
 *          if it's not available.
 * @apiSince 1
 */

protected final java.net.InetAddress getRequestingSite() { throw new RuntimeException("Stub!"); }

/**
 * Gets the port number for the requested connection.
 * @return an {@code int} indicating the
 * port for the requested connection.
 * @apiSince 1
 */

protected final int getRequestingPort() { throw new RuntimeException("Stub!"); }

/**
 * Give the protocol that's requesting the connection.  Often this
 * will be based on a URL, but in a future JDK it could be, for
 * example, "SOCKS" for a password-protected SOCKS5 firewall.
 *
 * @return the protocol, optionally followed by "/version", where
 *          version is a version number.
 *
 * @see java.net.URL#getProtocol()
 * @apiSince 1
 */

protected final java.lang.String getRequestingProtocol() { throw new RuntimeException("Stub!"); }

/**
 * Gets the prompt string given by the requestor.
 *
 * @return the prompt string given by the requestor (realm for
 *          http requests)
 * @apiSince 1
 */

protected final java.lang.String getRequestingPrompt() { throw new RuntimeException("Stub!"); }

/**
 * Gets the scheme of the requestor (the HTTP scheme
 * for an HTTP firewall, for example).
 *
 * @return the scheme of the requestor
 *
 * @apiSince 1
 */

protected final java.lang.String getRequestingScheme() { throw new RuntimeException("Stub!"); }

/**
 * Called when password authorization is needed.  Subclasses should
 * override the default implementation, which returns null.
 * @return The PasswordAuthentication collected from the
 *          user, or null if none is provided.
 * @apiSince 1
 */

protected java.net.PasswordAuthentication getPasswordAuthentication() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URL that resulted in this
 * request for authentication.
 *
 * @since 1.5
 *
 * @return the requesting URL
 *
 * @apiSince 1
 */

protected java.net.URL getRequestingURL() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the requestor is a Proxy or a Server.
 *
 * @since 1.5
 *
 * @return the authentication type of the requestor
 *
 * @apiSince 1
 */

protected java.net.Authenticator.RequestorType getRequestorType() { throw new RuntimeException("Stub!"); }
/**
 * The type of the entity requesting authentication.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum RequestorType {
/**
 * Entity requesting authentication is a HTTP proxy server.
 * @apiSince 1
 */

PROXY,
/**
 * Entity requesting authentication is a HTTP origin server.
 * @apiSince 1
 */

SERVER;
}

}

