/*
 * Copyright (C) 2014 The Android Open Source Project
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



package java.sql;


/**
 * <P>The basic service for managing a set of JDBC drivers.<br>
 * <B>NOTE:</B> The {@code DataSource} interface, new in the
 * JDBC 2.0 API, provides another way to connect to a data source.
 * The use of a <code>DataSource</code> object is the preferred means of
 * connecting to a data source.
 *
 * <P>As part of its initialization, the <code>DriverManager</code> class will
 * attempt to load the driver classes referenced in the "jdbc.drivers"
 * system property. This allows a user to customize the JDBC Drivers
 * used by their applications. For example in your
 * ~/.hotjava/properties file you might specify:
 * <pre>
 * <CODE>jdbc.drivers=foo.bah.Driver:wombat.sql.Driver:bad.taste.ourDriver</CODE>
 * </pre>
 *<P> The <code>DriverManager</code> methods <code>getConnection</code> and
 * <code>getDrivers</code> have been enhanced to support the Java Standard Edition
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html#Service%20Provider">Service Provider</a> mechanism. JDBC 4.0 Drivers must
 * include the file <code>META-INF/services/java.sql.Driver</code>. This file contains the name of the JDBC drivers
 * implementation of <code>java.sql.Driver</code>.  For example, to load the <code>my.sql.Driver</code> class,
 * the <code>META-INF/services/java.sql.Driver</code> file would contain the entry:
 * <pre>
 * <code>my.sql.Driver</code>
 * </pre>
 *
 * <P>Applications no longer need to explictly load JDBC drivers using <code>Class.forName()</code>. Existing programs
 * which currently load JDBC drivers using <code>Class.forName()</code> will continue to work without
 * modification.
 *
 * <P>When the method <code>getConnection</code> is called,
 * the <code>DriverManager</code> will attempt to
 * locate a suitable driver from amongst those loaded at
 * initialization and those loaded explicitly using the same classloader
 * as the current applet or application.
 *
 * <P>
 * Starting with the Java 2 SDK, Standard Edition, version 1.3, a
 * logging stream can be set only if the proper
 * permission has been granted.  Normally this will be done with
 * the tool PolicyTool, which can be used to grant <code>permission
 * java.sql.SQLPermission "setLog"</code>.
 * @see java.sql.Driver
 * @see java.sql.Connection
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DriverManager {

private DriverManager() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the log writer.
 *
 * The <code>getLogWriter</code> and <code>setLogWriter</code>
 * methods should be used instead
 * of the <code>get/setlogStream</code> methods, which are deprecated.
 * @return a <code>java.io.PrintWriter</code> object
 * @see #setLogWriter
 * @since 1.2
 * @apiSince 1
 */

public static java.io.PrintWriter getLogWriter() { throw new RuntimeException("Stub!"); }

/**
 * Sets the logging/tracing <code>PrintWriter</code> object
 * that is used by the <code>DriverManager</code> and all drivers.
 * <P>
 * There is a minor versioning problem created by the introduction
 * of the method <code>setLogWriter</code>.  The
 * method <code>setLogWriter</code> cannot create a <code>PrintStream</code> object
 * that will be returned by <code>getLogStream</code>---the Java platform does
 * not provide a backward conversion.  As a result, a new application
 * that uses <code>setLogWriter</code> and also uses a JDBC 1.0 driver that uses
 * <code>getLogStream</code> will likely not see debugging information written
 * by that driver.
 *<P>
 * Starting with the Java 2 SDK, Standard Edition, version 1.3 release, this method checks
 * to see that there is an <code>SQLPermission</code> object before setting
 * the logging stream.  If a <code>SecurityManager</code> exists and its
 * <code>checkPermission</code> method denies setting the log writer, this
 * method throws a <code>java.lang.SecurityException</code>.
 *
 * @param out the new logging/tracing <code>PrintStream</code> object;
 *      <code>null</code> to disable logging and tracing
 * @throws java.lang.SecurityException
 *    if a security manager exists and its
 *    <code>checkPermission</code> method denies
 *    setting the log writer
 *
 * @see SecurityManager#checkPermission
 * @see #getLogWriter
 * @since 1.2
 * @apiSince 1
 */

public static void setLogWriter(java.io.PrintWriter out) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to establish a connection to the given database URL.
 * The <code>DriverManager</code> attempts to select an appropriate driver from
 * the set of registered JDBC drivers.
 *
 * @param url a database url of the form
 * <code> jdbc:<em>subprotocol</em>:<em>subname</em></code>
 * @param info a list of arbitrary string tag/value pairs as
 * connection arguments; normally at least a "user" and
 * "password" property should be included
 * @return a Connection to the URL
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public static java.sql.Connection getConnection(java.lang.String url, java.util.Properties info) throws java.sql.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Attempts to establish a connection to the given database URL.
 * The <code>DriverManager</code> attempts to select an appropriate driver from
 * the set of registered JDBC drivers.
 *
 * @param url a database url of the form
 * <code>jdbc:<em>subprotocol</em>:<em>subname</em></code>
 * @param user the database user on whose behalf the connection is being
 *   made
 * @param password the user's password
 * @return a connection to the URL
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public static java.sql.Connection getConnection(java.lang.String url, java.lang.String user, java.lang.String password) throws java.sql.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Attempts to establish a connection to the given database URL.
 * The <code>DriverManager</code> attempts to select an appropriate driver from
 * the set of registered JDBC drivers.
 *
 * @param url a database url of the form
 *  <code> jdbc:<em>subprotocol</em>:<em>subname</em></code>
 * @return a connection to the URL
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public static java.sql.Connection getConnection(java.lang.String url) throws java.sql.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Attempts to locate a driver that understands the given URL.
 * The <code>DriverManager</code> attempts to select an appropriate driver from
 * the set of registered JDBC drivers.
 *
 * @param url a database URL of the form
 *     <code>jdbc:<em>subprotocol</em>:<em>subname</em></code>
 * @return a <code>Driver</code> object representing a driver
 * that can connect to the given URL
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public static java.sql.Driver getDriver(java.lang.String url) throws java.sql.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Registers the given driver with the <code>DriverManager</code>.
 * A newly-loaded driver class should call
 * the method <code>registerDriver</code> to make itself
 * known to the <code>DriverManager</code>.
 *
 * @param driver the new JDBC Driver that is to be registered with the
 *               <code>DriverManager</code>
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public static synchronized void registerDriver(java.sql.Driver driver) throws java.sql.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Drops a driver from the <code>DriverManager</code>'s list.
 *  Applets can only deregister drivers from their own classloaders.
 *
 * @param driver the JDBC Driver to drop
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public static synchronized void deregisterDriver(java.sql.Driver driver) throws java.sql.SQLException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an Enumeration with all of the currently loaded JDBC drivers
 * to which the current caller has access.
 *
 * <P><B>Note:</B> The classname of a driver can be found using
 * <CODE>d.getClass().getName()</CODE>
 *
 * @return the list of JDBC Drivers loaded by the caller's class loader
 * @apiSince 1
 */

public static java.util.Enumeration<java.sql.Driver> getDrivers() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum time in seconds that a driver will wait
 * while attempting to connect to a database.
 *
 * @param seconds the login time limit in seconds; zero means there is no limit
 * @see #getLoginTimeout
 * @apiSince 1
 */

public static void setLoginTimeout(int seconds) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum time in seconds that a driver can wait
 * when attempting to log in to a database.
 *
 * @return the driver login time limit in seconds
 * @see #setLoginTimeout
 * @apiSince 1
 */

public static int getLoginTimeout() { throw new RuntimeException("Stub!"); }

/**
 * Sets the logging/tracing PrintStream that is used
 * by the <code>DriverManager</code>
 * and all drivers.
 *<P>
 * In the Java 2 SDK, Standard Edition, version 1.3 release, this method checks
 * to see that there is an <code>SQLPermission</code> object before setting
 * the logging stream.  If a <code>SecurityManager</code> exists and its
 * <code>checkPermission</code> method denies setting the log writer, this
 * method throws a <code>java.lang.SecurityException</code>.
 *
 * @param out the new logging/tracing PrintStream; to disable, set to <code>null</code>
 * @deprecated Use {@code setLogWriter} instead.
 * @throws java.lang.SecurityException if a security manager exists and its
 *    <code>checkPermission</code> method denies setting the log stream
 *
 * @see SecurityManager#checkPermission
 * @see #getLogStream
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void setLogStream(java.io.PrintStream out) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the logging/tracing PrintStream that is used by the <code>DriverManager</code>
 * and all drivers.
 *
 * @return the logging/tracing PrintStream; if disabled, is <code>null</code>
 * @deprecated Use {@code getLogWriter} instead.
 * @see #setLogStream
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static java.io.PrintStream getLogStream() { throw new RuntimeException("Stub!"); }

/**
 * Prints a message to the current JDBC log stream.
 *
 * @param message a log or tracing message
 * @apiSince 1
 */

public static void println(java.lang.String message) { throw new RuntimeException("Stub!"); }
}

