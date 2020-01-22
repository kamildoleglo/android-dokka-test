/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// $Id: TransformerException.java 569994 2007-08-27 04:28:57Z mrglavas $



package javax.xml.transform;


/**
 * This class specifies an exceptional condition that occurred
 * during the transformation process.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransformerException extends java.lang.Exception {

/**
 * Create a new TransformerException.
 *
 * @param message The error or warning message.
 * @apiSince 8
 */

public TransformerException(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Create a new TransformerException wrapping an existing exception.
 *
 * @param e The exception to be wrapped.
 * @apiSince 8
 */

public TransformerException(java.lang.Throwable e) { throw new RuntimeException("Stub!"); }

/**
 * Wrap an existing exception in a TransformerException.
 *
 * <p>This is used for throwing processor exceptions before
 * the processing has started.</p>
 *
 * @param message The error or warning message, or null to
 *                use the message from the embedded exception.
 * @param e Any exception
 * @apiSince 8
 */

public TransformerException(java.lang.String message, java.lang.Throwable e) { throw new RuntimeException("Stub!"); }

/**
 * Create a new TransformerException from a message and a Locator.
 *
 * <p>This constructor is especially useful when an application is
 * creating its own exception from within a DocumentHandler
 * callback.</p>
 *
 * @param message The error or warning message.
 * @param locator The locator object for the error or warning.
 * @apiSince 8
 */

public TransformerException(java.lang.String message, javax.xml.transform.SourceLocator locator) { throw new RuntimeException("Stub!"); }

/**
 * Wrap an existing exception in a TransformerException.
 *
 * @param message The error or warning message, or null to
 *                use the message from the embedded exception.
 * @param locator The locator object for the error or warning.
 * @param e Any exception
 * @apiSince 8
 */

public TransformerException(java.lang.String message, javax.xml.transform.SourceLocator locator, java.lang.Throwable e) { throw new RuntimeException("Stub!"); }

/**
 * Method getLocator retrieves an instance of a SourceLocator
 * object that specifies where an error occurred.
 *
 * @return A SourceLocator object, or null if none was specified.
 * @apiSince 8
 */

public javax.xml.transform.SourceLocator getLocator() { throw new RuntimeException("Stub!"); }

/**
 * Method setLocator sets an instance of a SourceLocator
 * object that specifies where an error occurred.
 *
 * @param location A SourceLocator object, or null to clear the location.
 * @apiSince 8
 */

public void setLocator(javax.xml.transform.SourceLocator location) { throw new RuntimeException("Stub!"); }

/**
 * This method retrieves an exception that this exception wraps.
 *
 * @return An Throwable object, or null.
 * @see #getCause
 * @apiSince 8
 */

public java.lang.Throwable getException() { throw new RuntimeException("Stub!"); }

/**
 * Returns the cause of this throwable or <code>null</code> if the
 * cause is nonexistent or unknown.  (The cause is the throwable that
 * caused this throwable to get thrown.)
 * @apiSince 8
 */

public java.lang.Throwable getCause() { throw new RuntimeException("Stub!"); }

/**
 * Initializes the <i>cause</i> of this throwable to the specified value.
 * (The cause is the throwable that caused this throwable to get thrown.)
 *
 * <p>This method can be called at most once.  It is generally called from
 * within the constructor, or immediately after creating the
 * throwable.  If this throwable was created
 * with {@link #TransformerException(java.lang.Throwable)} or
 * {@link #TransformerException(java.lang.String,java.lang.Throwable)}, this method cannot be called
 * even once.
 *
 * @param  cause the cause (which is saved for later retrieval by the
 *         {@link #getCause()} method).  (A <tt>null</tt> value is
 *         permitted, and indicates that the cause is nonexistent or
 *         unknown.)
 * @return  a reference to this <code>Throwable</code> instance.
 * @throws java.lang.IllegalArgumentException if <code>cause</code> is this
 *         throwable.  (A throwable cannot
 *         be its own cause.)
 * @throws java.lang.IllegalStateException if this throwable was
 *         created with {@link #TransformerException(java.lang.Throwable)} or
 *         {@link #TransformerException(java.lang.String,java.lang.Throwable)}, or this method has already
 *         been called on this throwable.
 * @apiSince 8
 */

public synchronized java.lang.Throwable initCause(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Get the error message with location information
 * appended.
 *
 * @return A <code>String</code> representing the error message with
 *         location information appended.
 * @apiSince 8
 */

public java.lang.String getMessageAndLocation() { throw new RuntimeException("Stub!"); }

/**
 * Get the location information as a string.
 *
 * @return A string with location info, or null
 * if there is no location information.
 * @apiSince 8
 */

public java.lang.String getLocationAsString() { throw new RuntimeException("Stub!"); }

/**
 * Print the the trace of methods from where the error
 * originated.  This will trace all nested exception
 * objects, as well as this object.
 * @apiSince 8
 */

public void printStackTrace() { throw new RuntimeException("Stub!"); }

/**
 * Print the the trace of methods from where the error
 * originated.  This will trace all nested exception
 * objects, as well as this object.
 * @param s The stream where the dump will be sent to.
 * @apiSince 8
 */

public void printStackTrace(java.io.PrintStream s) { throw new RuntimeException("Stub!"); }

/**
 * Print the the trace of methods from where the error
 * originated.  This will trace all nested exception
 * objects, as well as this object.
 * @param s The writer where the dump will be sent to.
 * @apiSince 8
 */

public void printStackTrace(java.io.PrintWriter s) { throw new RuntimeException("Stub!"); }
}

