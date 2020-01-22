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

// $Id: TransformerConfigurationException.java 569994 2007-08-27 04:28:57Z mrglavas $



package javax.xml.transform;


/**
 * Indicates a serious configuration error.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransformerConfigurationException extends javax.xml.transform.TransformerException {

/**
 * Create a new <code>TransformerConfigurationException</code> with no
 * detail message.
 * @apiSince 8
 */

public TransformerConfigurationException() { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new <code>TransformerConfigurationException</code> with
 * the <code>String </code> specified as an error message.
 *
 * @param msg The error message for the exception.
 * @apiSince 8
 */

public TransformerConfigurationException(java.lang.String msg) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new <code>TransformerConfigurationException</code> with a
 * given <code>Exception</code> base cause of the error.
 *
 * @param e The exception to be encapsulated in a
 * TransformerConfigurationException.
 * @apiSince 8
 */

public TransformerConfigurationException(java.lang.Throwable e) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new <code>TransformerConfigurationException</code> with the
 * given <code>Exception</code> base cause and detail message.
 *
 * @param e The exception to be encapsulated in a
 *      TransformerConfigurationException
 * @param msg The detail message.
 * @apiSince 8
 */

public TransformerConfigurationException(java.lang.String msg, java.lang.Throwable e) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new TransformerConfigurationException from a message and a Locator.
 *
 * <p>This constructor is especially useful when an application is
 * creating its own exception from within a DocumentHandler
 * callback.</p>
 *
 * @param message The error or warning message.
 * @param locator The locator object for the error or warning.
 * @apiSince 8
 */

public TransformerConfigurationException(java.lang.String message, javax.xml.transform.SourceLocator locator) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Wrap an existing exception in a TransformerConfigurationException.
 *
 * @param message The error or warning message, or null to
 *                use the message from the embedded exception.
 * @param locator The locator object for the error or warning.
 * @param e Any exception.
 * @apiSince 8
 */

public TransformerConfigurationException(java.lang.String message, javax.xml.transform.SourceLocator locator, java.lang.Throwable e) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }
}

