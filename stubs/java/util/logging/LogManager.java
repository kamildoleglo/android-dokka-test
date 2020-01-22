/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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




package java.util.logging;

import java.io.*;
import java.util.*;
import java.security.*;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;

/**
 * There is a single global LogManager object that is used to
 * maintain a set of shared state about Loggers and log services.
 * <p>
 * This LogManager object:
 * <ul>
 * <li> Manages a hierarchical namespace of Logger objects.  All
 *      named Loggers are stored in this namespace.
 * <li> Manages a set of logging control properties.  These are
 *      simple key-value pairs that can be used by Handlers and
 *      other logging objects to configure themselves.
 * </ul>
 * <p>
 * The global LogManager object can be retrieved using LogManager.getLogManager().
 * The LogManager object is created during class initialization and
 * cannot subsequently be changed.
 * <p>
 * At startup the LogManager class is located using the
 * java.util.logging.manager system property.
 * <p>
 * The LogManager defines two optional system properties that allow control over
 * the initial configuration:
 * <ul>
 * <li>"java.util.logging.config.class"
 * <li>"java.util.logging.config.file"
 * </ul>
 * These two properties may be specified on the command line to the "java"
 * command, or as system property definitions passed to JNI_CreateJavaVM.
 * <p>
 * If the "java.util.logging.config.class" property is set, then the
 * property value is treated as a class name.  The given class will be
 * loaded, an object will be instantiated, and that object's constructor
 * is responsible for reading in the initial configuration.  (That object
 * may use other system properties to control its configuration.)  The
 * alternate configuration class can use <tt>readConfiguration(InputStream)</tt>
 * to define properties in the LogManager.
 * <p>
 * If "java.util.logging.config.class" property is <b>not</b> set,
 * then the "java.util.logging.config.file" system property can be used
 * to specify a properties file (in java.util.Properties format). The
 * initial logging configuration will be read from this file.
 * <p>
 * If neither of these properties is defined then the LogManager uses its
 * default configuration. The default configuration is typically loaded from the
 * properties file "{@code lib/logging.properties}" in the Java installation
 * directory.
 * <p>
 * The properties for loggers and Handlers will have names starting
 * with the dot-separated name for the handler or logger.
 * <p>
 * The global logging properties may include:
 * <ul>
 * <li>A property "handlers".  This defines a whitespace or comma separated
 * list of class names for handler classes to load and register as
 * handlers on the root Logger (the Logger named "").  Each class
 * name must be for a Handler class which has a default constructor.
 * Note that these Handlers may be created lazily, when they are
 * first used.
 *
 * <li>A property "&lt;logger&gt;.handlers". This defines a whitespace or
 * comma separated list of class names for handlers classes to
 * load and register as handlers to the specified logger. Each class
 * name must be for a Handler class which has a default constructor.
 * Note that these Handlers may be created lazily, when they are
 * first used.
 *
 * <li>A property "&lt;logger&gt;.useParentHandlers". This defines a boolean
 * value. By default every logger calls its parent in addition to
 * handling the logging message itself, this often result in messages
 * being handled by the root logger as well. When setting this property
 * to false a Handler needs to be configured for this logger otherwise
 * no logging messages are delivered.
 *
 * <li>A property "config".  This property is intended to allow
 * arbitrary configuration code to be run.  The property defines a
 * whitespace or comma separated list of class names.  A new instance will be
 * created for each named class.  The default constructor of each class
 * may execute arbitrary code to update the logging configuration, such as
 * setting logger levels, adding handlers, adding filters, etc.
 * </ul>
 * <p>
 * Note that all classes loaded during LogManager configuration are
 * first searched on the system class path before any user class path.
 * That includes the LogManager class, any config classes, and any
 * handler classes.
 * <p>
 * Loggers are organized into a naming hierarchy based on their
 * dot separated names.  Thus "a.b.c" is a child of "a.b", but
 * "a.b1" and a.b2" are peers.
 * <p>
 * All properties whose names end with ".level" are assumed to define
 * log levels for Loggers.  Thus "foo.level" defines a log level for
 * the logger called "foo" and (recursively) for any of its children
 * in the naming hierarchy.  Log Levels are applied in the order they
 * are defined in the properties file.  Thus level settings for child
 * nodes in the tree should come after settings for their parents.
 * The property name ".level" can be used to set the level for the
 * root of the tree.
 * <p>
 * All methods on the LogManager object are multi-thread safe.
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LogManager {

/**
 * Protected constructor.  This is protected so that container applications
 * (such as J2EE containers) can subclass the object.  It is non-public as
 * it is intended that there only be one LogManager object, whose value is
 * retrieved by calling LogManager.getLogManager.
 * @apiSince 1
 */

protected LogManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the global LogManager object.
 * @return the global LogManager object
 * @apiSince 1
 */

public static java.util.logging.LogManager getLogManager() { throw new RuntimeException("Stub!"); }

/**
 * Adds an event listener to be invoked when the logging
 * properties are re-read. Adding multiple instances of
 * the same event Listener results in multiple entries
 * in the property event listener table.
 *
 * <p><b>WARNING:</b> This method is omitted from this class in all subset
 * Profiles of Java SE that do not include the {@code java.beans} package.
 * </p>
 *
 * @param l  event listener
 * @exception  java.lang.SecurityException  if a security manager exists and if
 *             the caller does not have LoggingPermission("control").
 * @exception java.lang.NullPointerException if the PropertyChangeListener is null.
 * @deprecated The dependency on {@code PropertyChangeListener} creates a
 *             significant impediment to future modularization of the Java
 *             platform. This method will be removed in a future release.
 *             The global {@code LogManager} can detect changes to the
 *             logging configuration by overridding the {@link
 *             #readConfiguration readConfiguration} method.
 * @apiSince 3
 * @deprecatedSince 26
 */

@Deprecated
public void addPropertyChangeListener(java.beans.PropertyChangeListener l) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Removes an event listener for property change events.
 * If the same listener instance has been added to the listener table
 * through multiple invocations of <CODE>addPropertyChangeListener</CODE>,
 * then an equivalent number of
 * <CODE>removePropertyChangeListener</CODE> invocations are required to remove
 * all instances of that listener from the listener table.
 * <P>
 * Returns silently if the given listener is not found.
 *
 * <p><b>WARNING:</b> This method is omitted from this class in all subset
 * Profiles of Java SE that do not include the {@code java.beans} package.
 * </p>
 *
 * @param l  event listener (can be null)
 * @exception  java.lang.SecurityException  if a security manager exists and if
 *             the caller does not have LoggingPermission("control").
 * @deprecated The dependency on {@code PropertyChangeListener} creates a
 *             significant impediment to future modularization of the Java
 *             platform. This method will be removed in a future release.
 *             The global {@code LogManager} can detect changes to the
 *             logging configuration by overridding the {@link
 *             #readConfiguration readConfiguration} method.
 * @apiSince 3
 * @deprecatedSince 26
 */

@Deprecated
public void removePropertyChangeListener(java.beans.PropertyChangeListener l) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Add a named logger.  This does nothing and returns false if a logger
 * with the same name is already registered.
 * <p>
 * The Logger factory methods call this method to register each
 * newly created Logger.
 * <p>
 * The application should retain its own reference to the Logger
 * object to avoid it being garbage collected.  The LogManager
 * may only retain a weak reference.
 *
 * @param   logger the new logger.
 * @return  true if the argument logger was registered successfully,
 *          false if a logger of that name already exists.
 * @exception java.lang.NullPointerException if the logger name is null.
 * @apiSince 1
 */

public boolean addLogger(java.util.logging.Logger logger) { throw new RuntimeException("Stub!"); }

/**
 * Method to find a named logger.
 * <p>
 * Note that since untrusted code may create loggers with
 * arbitrary names this method should not be relied on to
 * find Loggers for security sensitive logging.
 * It is also important to note that the Logger associated with the
 * String {@code name} may be garbage collected at any time if there
 * is no strong reference to the Logger. The caller of this method
 * must check the return value for null in order to properly handle
 * the case where the Logger has been garbage collected.
 * <p>
 * @param name name of the logger
 * @return  matching logger or null if none is found
 * @apiSince 1
 */

public java.util.logging.Logger getLogger(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Get an enumeration of known logger names.
 * <p>
 * Note:  Loggers may be added dynamically as new classes are loaded.
 * This method only reports on the loggers that are currently registered.
 * It is also important to note that this method only returns the name
 * of a Logger, not a strong reference to the Logger itself.
 * The returned String does nothing to prevent the Logger from being
 * garbage collected. In particular, if the returned name is passed
 * to {@code LogManager.getLogger()}, then the caller must check the
 * return value from {@code LogManager.getLogger()} for null to properly
 * handle the case where the Logger has been garbage collected in the
 * time since its name was returned by this method.
 * <p>
 * @return  enumeration of logger name strings
 * @apiSince 1
 */

public java.util.Enumeration<java.lang.String> getLoggerNames() { throw new RuntimeException("Stub!"); }

/**
 * Reinitialize the logging properties and reread the logging configuration.
 * <p>
 * The same rules are used for locating the configuration properties
 * as are used at startup.  So normally the logging properties will
 * be re-read from the same file that was used at startup.
 * <P>
 * Any log level definitions in the new configuration file will be
 * applied using Logger.setLevel(), if the target Logger exists.
 * <p>
 * A PropertyChangeEvent will be fired after the properties are read.
 *
 * @exception  java.lang.SecurityException  if a security manager exists and if
 *             the caller does not have LoggingPermission("control").
 * @exception  java.io.IOException if there are IO problems reading the configuration.
 * @apiSince 1
 */

public void readConfiguration() throws java.io.IOException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Reset the logging configuration.
 * <p>
 * For all named loggers, the reset operation removes and closes
 * all Handlers and (except for the root logger) sets the level
 * to null.  The root logger's level is set to Level.INFO.
 *
 * @exception  java.lang.SecurityException  if a security manager exists and if
 *             the caller does not have LoggingPermission("control").
 * @apiSince 1
 */

public void reset() throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Reinitialize the logging properties and reread the logging configuration
 * from the given stream, which should be in java.util.Properties format.
 * A PropertyChangeEvent will be fired after the properties are read.
 * <p>
 * Any log level definitions in the new configuration file will be
 * applied using Logger.setLevel(), if the target Logger exists.
 *
 * @param ins       stream to read properties from
 * @exception  java.lang.SecurityException  if a security manager exists and if
 *             the caller does not have LoggingPermission("control").
 * @exception  java.io.IOException if there are problems reading from the stream.
 * @apiSince 1
 */

public void readConfiguration(java.io.InputStream ins) throws java.io.IOException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Get the value of a logging property.
 * The method returns null if the property is not found.
 * @param name      property name
 * @return          property value
 * @apiSince 1
 */

public java.lang.String getProperty(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Check that the current context is trusted to modify the logging
 * configuration.  This requires LoggingPermission("control").
 * <p>
 * If the check fails we throw a SecurityException, otherwise
 * we return normally.
 *
 * @exception  java.lang.SecurityException  if a security manager exists and if
 *             the caller does not have LoggingPermission("control").
 * @apiSince 1
 */

public void checkAccess() throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>LoggingMXBean</tt> for managing loggers.
 *
 * @return a {@link java.util.logging.LoggingMXBean LoggingMXBean} object.
 *
 * @since 1.5
 * @apiSince 3
 */

public static synchronized java.util.logging.LoggingMXBean getLoggingMXBean() { throw new RuntimeException("Stub!"); }

/**
 * String representation of the {@code ObjectName} for the management interface
 * for the logging facility.
 *
 * @see java.util.logging.LoggingMXBean
 *
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
}

