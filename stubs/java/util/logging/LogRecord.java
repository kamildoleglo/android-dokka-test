/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;
import java.io.*;

/**
 * LogRecord objects are used to pass logging requests between
 * the logging framework and individual log Handlers.
 * <p>
 * When a LogRecord is passed into the logging framework it
 * logically belongs to the framework and should no longer be
 * used or updated by the client application.
 * <p>
 * Note that if the client application has not specified an
 * explicit source method name and source class name, then the
 * LogRecord class will infer them automatically when they are
 * first accessed (due to a call on getSourceMethodName or
 * getSourceClassName) by analyzing the call stack.  Therefore,
 * if a logging Handler wants to pass off a LogRecord to another
 * thread, or to transmit it over RMI, and if it wishes to subsequently
 * obtain method name or class name information it should call
 * one of getSourceClassName or getSourceMethodName to force
 * the values to be filled in.
 * <p>
 * <b> Serialization notes:</b>
 * <ul>
 * <li>The LogRecord class is serializable.
 *
 * <li> Because objects in the parameters array may not be serializable,
 * during serialization all objects in the parameters array are
 * written as the corresponding Strings (using Object.toString).
 *
 * <li> The ResourceBundle is not transmitted as part of the serialized
 * form, but the resource bundle name is, and the recipient object's
 * readObject method will attempt to locate a suitable resource bundle.
 *
 * </ul>
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LogRecord implements java.io.Serializable {

/**
 * Construct a LogRecord with the given level and message values.
 * <p>
 * The sequence property will be initialized with a new unique value.
 * These sequence values are allocated in increasing order within a VM.
 * <p>
 * The millis property will be initialized to the current time.
 * <p>
 * The thread ID property will be initialized with a unique ID for
 * the current thread.
 * <p>
 * All other properties will be initialized to "null".
 *
 * @param level  a logging level value
 * @param msg  the raw non-localized logging message (may be null)
 * @apiSince 1
 */

public LogRecord(java.util.logging.Level level, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Get the source Logger's name.
 *
 * @return source logger name (may be null)
 * @apiSince 1
 */

public java.lang.String getLoggerName() { throw new RuntimeException("Stub!"); }

/**
 * Set the source Logger's name.
 *
 * @param name   the source logger name (may be null)
 * @apiSince 1
 */

public void setLoggerName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Get the localization resource bundle
 * <p>
 * This is the ResourceBundle that should be used to localize
 * the message string before formatting it.  The result may
 * be null if the message is not localizable, or if no suitable
 * ResourceBundle is available.
 * @return the localization resource bundle
 * @apiSince 1
 */

public java.util.ResourceBundle getResourceBundle() { throw new RuntimeException("Stub!"); }

/**
 * Set the localization resource bundle.
 *
 * @param bundle  localization bundle (may be null)
 * @apiSince 1
 */

public void setResourceBundle(java.util.ResourceBundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Get the localization resource bundle name
 * <p>
 * This is the name for the ResourceBundle that should be
 * used to localize the message string before formatting it.
 * The result may be null if the message is not localizable.
 * @return the localization resource bundle name
 * @apiSince 1
 */

public java.lang.String getResourceBundleName() { throw new RuntimeException("Stub!"); }

/**
 * Set the localization resource bundle name.
 *
 * @param name  localization bundle name (may be null)
 * @apiSince 1
 */

public void setResourceBundleName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Get the logging message level, for example Level.SEVERE.
 * @return the logging message level
 * @apiSince 1
 */

public java.util.logging.Level getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Set the logging message level, for example Level.SEVERE.
 * @param level the logging message level
 * @apiSince 1
 */

public void setLevel(java.util.logging.Level level) { throw new RuntimeException("Stub!"); }

/**
 * Get the sequence number.
 * <p>
 * Sequence numbers are normally assigned in the LogRecord
 * constructor, which assigns unique sequence numbers to
 * each new LogRecord in increasing order.
 * @return the sequence number
 * @apiSince 1
 */

public long getSequenceNumber() { throw new RuntimeException("Stub!"); }

/**
 * Set the sequence number.
 * <p>
 * Sequence numbers are normally assigned in the LogRecord constructor,
 * so it should not normally be necessary to use this method.
 * @param seq the sequence number
 * @apiSince 1
 */

public void setSequenceNumber(long seq) { throw new RuntimeException("Stub!"); }

/**
 * Get the  name of the class that (allegedly) issued the logging request.
 * <p>
 * Note that this sourceClassName is not verified and may be spoofed.
 * This information may either have been provided as part of the
 * logging call, or it may have been inferred automatically by the
 * logging framework.  In the latter case, the information may only
 * be approximate and may in fact describe an earlier call on the
 * stack frame.
 * <p>
 * May be null if no information could be obtained.
 *
 * @return the source class name
 * @apiSince 1
 */

public java.lang.String getSourceClassName() { throw new RuntimeException("Stub!"); }

/**
 * Set the name of the class that (allegedly) issued the logging request.
 *
 * @param sourceClassName the source class name (may be null)
 * @apiSince 1
 */

public void setSourceClassName(java.lang.String sourceClassName) { throw new RuntimeException("Stub!"); }

/**
 * Get the  name of the method that (allegedly) issued the logging request.
 * <p>
 * Note that this sourceMethodName is not verified and may be spoofed.
 * This information may either have been provided as part of the
 * logging call, or it may have been inferred automatically by the
 * logging framework.  In the latter case, the information may only
 * be approximate and may in fact describe an earlier call on the
 * stack frame.
 * <p>
 * May be null if no information could be obtained.
 *
 * @return the source method name
 * @apiSince 1
 */

public java.lang.String getSourceMethodName() { throw new RuntimeException("Stub!"); }

/**
 * Set the name of the method that (allegedly) issued the logging request.
 *
 * @param sourceMethodName the source method name (may be null)
 * @apiSince 1
 */

public void setSourceMethodName(java.lang.String sourceMethodName) { throw new RuntimeException("Stub!"); }

/**
 * Get the "raw" log message, before localization or formatting.
 * <p>
 * May be null, which is equivalent to the empty string "".
 * <p>
 * This message may be either the final text or a localization key.
 * <p>
 * During formatting, if the source logger has a localization
 * ResourceBundle and if that ResourceBundle has an entry for
 * this message string, then the message string is replaced
 * with the localized value.
 *
 * @return the raw message string
 * @apiSince 1
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Set the "raw" log message, before localization or formatting.
 *
 * @param message the raw message string (may be null)
 * @apiSince 1
 */

public void setMessage(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Get the parameters to the log message.
 *
 * @return the log message parameters.  May be null if
 *                  there are no parameters.
 * @apiSince 1
 */

public java.lang.Object[] getParameters() { throw new RuntimeException("Stub!"); }

/**
 * Set the parameters to the log message.
 *
 * @param parameters the log message parameters. (may be null)
 * @apiSince 1
 */

public void setParameters(java.lang.Object[] parameters) { throw new RuntimeException("Stub!"); }

/**
 * Get an identifier for the thread where the message originated.
 * <p>
 * This is a thread identifier within the Java VM and may or
 * may not map to any operating system ID.
 *
 * @return thread ID
 * @apiSince 1
 */

public int getThreadID() { throw new RuntimeException("Stub!"); }

/**
 * Set an identifier for the thread where the message originated.
 * @param threadID  the thread ID
 * @apiSince 1
 */

public void setThreadID(int threadID) { throw new RuntimeException("Stub!"); }

/**
 * Get event time in milliseconds since 1970.
 *
 * @return event time in millis since 1970
 * @apiSince 1
 */

public long getMillis() { throw new RuntimeException("Stub!"); }

/**
 * Set event time.
 *
 * @param millis event time in millis since 1970
 * @apiSince 1
 */

public void setMillis(long millis) { throw new RuntimeException("Stub!"); }

/**
 * Get any throwable associated with the log record.
 * <p>
 * If the event involved an exception, this will be the
 * exception object. Otherwise null.
 *
 * @return a throwable
 * @apiSince 1
 */

public java.lang.Throwable getThrown() { throw new RuntimeException("Stub!"); }

/**
 * Set a throwable associated with the log event.
 *
 * @param thrown  a throwable (may be null)
 * @apiSince 1
 */

public void setThrown(java.lang.Throwable thrown) { throw new RuntimeException("Stub!"); }
}

