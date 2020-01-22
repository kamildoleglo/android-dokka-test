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

// $Id: DocumentBuilderFactory.java 884950 2009-11-27 18:46:18Z mrglavas $



package javax.xml.parsers;

import javax.xml.validation.Schema;

/**
 * Defines a factory API that enables applications to obtain a
 * parser that produces DOM object trees from XML documents.
 *
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 884950 $, $Date: 2009-11-27 10:46:18 -0800 (Fri, 27 Nov 2009) $
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DocumentBuilderFactory {

/** @apiSince 1 */

protected DocumentBuilderFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns Android's implementation of {@code DocumentBuilderFactory}.
 * Unlike other Java implementations, this method does not consult system
 * properties, property files, or the services API.
 *
 * @return a new DocumentBuilderFactory.
 * @apiSince 1
 */

public static javax.xml.parsers.DocumentBuilderFactory newInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns an instance of the named implementation of {@code DocumentBuilderFactory}.
 *
 * @throws javax.xml.parsers.FactoryConfigurationError if {@code factoryClassName} is not available or cannot be
 *     instantiated.
 * @since 1.6
 * @apiSince 9
 */

public static javax.xml.parsers.DocumentBuilderFactory newInstance(java.lang.String factoryClassName, java.lang.ClassLoader classLoader) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance of a {@link javax.xml.parsers.DocumentBuilder}
 * using the currently configured parameters.
 *
 * @exception javax.xml.parsers.ParserConfigurationException if a DocumentBuilder
 * cannot be created which satisfies the configuration requested.
 * @return A new instance of a DocumentBuilder.
 * @apiSince 1
 */

public abstract javax.xml.parsers.DocumentBuilder newDocumentBuilder() throws javax.xml.parsers.ParserConfigurationException;

/**
 * Specifies that the parser produced by this code will
 * provide support for XML namespaces. By default the value of this is set
 * to <code>false</code>
 *
 * @param awareness true if the parser produced will provide support
 *                  for XML namespaces; false otherwise.
 * @apiSince 1
 */

public void setNamespaceAware(boolean awareness) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the parser produced by this code will
 * validate documents as they are parsed. By default the value of this
 * is set to <code>false</code>.
 *
 * <p>
 * Note that "the validation" here means
 * <a href="http://www.w3.org/TR/REC-xml#proc-types">a validating
 * parser</a> as defined in the XML recommendation.
 * In other words, it essentially just controls the DTD validation.
 * (except the legacy two properties defined in JAXP 1.2.
 * See <a href="#validationCompatibility">here</a> for more details.)
 * </p>
 *
 * <p>
 * To use modern schema languages such as W3C XML Schema or
 * RELAX NG instead of DTD, you can configure your parser to be
 * a non-validating parser by leaving the {@link #setValidating(boolean)}
 * method <tt>false</tt>, then use the {@link #setSchema(javax.xml.validation.Schema)}
 * method to associate a schema to a parser.
 * </p>
 *
 * @param validating true if the parser produced will validate documents
 *                   as they are parsed; false otherwise.
 * @apiSince 1
 */

public void setValidating(boolean validating) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the parsers created by this  factory must eliminate
 * whitespace in element content (sometimes known loosely as
 * 'ignorable whitespace') when parsing XML documents (see XML Rec
 * 2.10). Note that only whitespace which is directly contained within
 * element content that has an element only content model (see XML
 * Rec 3.2.1) will be eliminated. Due to reliance on the content model
 * this setting requires the parser to be in validating mode. By default
 * the value of this is set to <code>false</code>.
 *
 * @param whitespace true if the parser created must eliminate whitespace
 *                   in the element content when parsing XML documents;
 *                   false otherwise.
 * @apiSince 1
 */

public void setIgnoringElementContentWhitespace(boolean whitespace) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the parser produced by this code will
 * expand entity reference nodes. By default the value of this is set to
 * <code>true</code>
 *
 * @param expandEntityRef true if the parser produced will expand entity
 *                        reference nodes; false otherwise.
 * @apiSince 1
 */

public void setExpandEntityReferences(boolean expandEntityRef) { throw new RuntimeException("Stub!"); }

/**
 * <p>Specifies that the parser produced by this code will
 * ignore comments. By default the value of this is set to <code>false
 * </code>.</p>
 *
 * @param ignoreComments <code>boolean</code> value to ignore comments during processing
 * @apiSince 1
 */

public void setIgnoringComments(boolean ignoreComments) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the parser produced by this code will
 * convert CDATA nodes to Text nodes and append it to the
 * adjacent (if any) text node. By default the value of this is set to
 * <code>false</code>
 *
 * @param coalescing  true if the parser produced will convert CDATA nodes
 *                    to Text nodes and append it to the adjacent (if any)
 *                    text node; false otherwise.
 * @apiSince 1
 */

public void setCoalescing(boolean coalescing) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which are namespace aware.
 *
 * @return  true if the factory is configured to produce parsers which
 *          are namespace aware; false otherwise.
 * @apiSince 1
 */

public boolean isNamespaceAware() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which validate the XML content during parse.
 *
 * @return  true if the factory is configured to produce parsers
 *          which validate the XML content during parse; false otherwise.
 * @apiSince 1
 */

public boolean isValidating() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which ignore ignorable whitespace in element content.
 *
 * @return  true if the factory is configured to produce parsers
 *          which ignore ignorable whitespace in element content;
 *          false otherwise.
 * @apiSince 1
 */

public boolean isIgnoringElementContentWhitespace() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which expand entity reference nodes.
 *
 * @return  true if the factory is configured to produce parsers
 *          which expand entity reference nodes; false otherwise.
 * @apiSince 1
 */

public boolean isExpandEntityReferences() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which ignores comments.
 *
 * @return  true if the factory is configured to produce parsers
 *          which ignores comments; false otherwise.
 * @apiSince 1
 */

public boolean isIgnoringComments() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which converts CDATA nodes to Text nodes and appends it to
 * the adjacent (if any) Text node.
 *
 * @return  true if the factory is configured to produce parsers
 *          which converts CDATA nodes to Text nodes and appends it to
 *          the adjacent (if any) Text node; false otherwise.
 * @apiSince 1
 */

public boolean isCoalescing() { throw new RuntimeException("Stub!"); }

/**
 * Allows the user to set specific attributes on the underlying
 * implementation.
 * @param name The name of the attribute.
 * @param value The value of the attribute.
 * @exception java.lang.IllegalArgumentException thrown if the underlying
 * implementation doesn't recognize the attribute.
 * @apiSince 1
 */

public abstract void setAttribute(java.lang.String name, java.lang.Object value) throws java.lang.IllegalArgumentException;

/**
 * Allows the user to retrieve specific attributes on the underlying
 * implementation.
 * @param name The name of the attribute.
 * @return value The value of the attribute.
 * @exception java.lang.IllegalArgumentException thrown if the underlying
 * implementation doesn't recognize the attribute.
 * @apiSince 1
 */

public abstract java.lang.Object getAttribute(java.lang.String name) throws java.lang.IllegalArgumentException;

/**
 * <p>Set a feature for this <code>DocumentBuilderFactory</code> and <code>DocumentBuilder</code>s created by this factory.</p>
 *
 * <p>
 * Feature names are fully qualified {@link java.net.URI}s.
 * Implementations may define their own features.
 * An {@link javax.xml.parsers.ParserConfigurationException ParserConfigurationException} is thrown if this <code>DocumentBuilderFactory</code> or the
 * <code>DocumentBuilder</code>s it creates cannot support the feature.
 * It is possible for an <code>DocumentBuilderFactory</code> to expose a feature value but be unable to change its state.
 * </p>
 *
 * <p>
 * All implementations are required to support the {@link javax.xml.XMLConstants#FEATURE_SECURE_PROCESSING} feature.
 * When the feature is:</p>
 * <ul>
 *   <li>
 *     <code>true</code>: the implementation will limit XML processing to conform to implementation limits.
 *     Examples include entity expansion limits and XML Schema constructs that would consume large amounts of resources.
 *     If XML processing is limited for security reasons, it will be reported via a call to the registered
 *    {@link org.xml.sax.ErrorHandler#fatalError(SAXParseException exception)}.
 *     See {@link javax.xml.parsers.DocumentBuilder#setErrorHandler(org.xml.sax.ErrorHandler errorHandler) DocumentBuilder#setErrorHandler(org.xml.sax.ErrorHandler errorHandler)}.
 *   </li>
 *   <li>
 *     <code>false</code>: the implementation will processing XML according to the XML specifications without
 *     regard to possible implementation limits.
 *   </li>
 * </ul>
 *
 * @param name Feature name.
 * @param value Is feature state <code>true</code> or <code>false</code>.
 *
 * @throws javax.xml.parsers.ParserConfigurationException if this <code>DocumentBuilderFactory</code> or the <code>DocumentBuilder</code>s
 *   it creates cannot support this feature.
 * @throws java.lang.NullPointerException If the <code>name</code> parameter is null.
 * @apiSince 1
 */

public abstract void setFeature(java.lang.String name, boolean value) throws javax.xml.parsers.ParserConfigurationException;

/**
 * <p>Get the state of the named feature.</p>
 *
 * <p>
 * Feature names are fully qualified {@link java.net.URI}s.
 * Implementations may define their own features.
 * An {@link javax.xml.parsers.ParserConfigurationException ParserConfigurationException} is thrown if this <code>DocumentBuilderFactory</code> or the
 * <code>DocumentBuilder</code>s it creates cannot support the feature.
 * It is possible for an <code>DocumentBuilderFactory</code> to expose a feature value but be unable to change its state.
 * </p>
 *
 * @param name Feature name.
 *
 * @return State of the named feature.
 *
 * @throws javax.xml.parsers.ParserConfigurationException if this <code>DocumentBuilderFactory</code>
 *   or the <code>DocumentBuilder</code>s it creates cannot support this feature.
 * @apiSince 1
 */

public abstract boolean getFeature(java.lang.String name) throws javax.xml.parsers.ParserConfigurationException;

/**
 * Gets the {@link javax.xml.validation.Schema Schema} object specified through
 * the {@link #setSchema(javax.xml.validation.Schema)} method.
 *
 *
 * @throws java.lang.UnsupportedOperationException
 *      For backward compatibility, when implementations for
 *      earlier versions of JAXP is used, this exception will be
 *      thrown.
 *
 * @return
 *      the {@link javax.xml.validation.Schema Schema} object that was last set through
 *      the {@link #setSchema(javax.xml.validation.Schema)} method, or null
 *      if the method was not invoked since a {@link javax.xml.parsers.DocumentBuilderFactory DocumentBuilderFactory}
 *      is created.
 *
 * @since 1.5
 * @apiSince 8
 */

public javax.xml.validation.Schema getSchema() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the {@link javax.xml.validation.Schema Schema} to be used by parsers created
 * from this factory.
 *
 * <p>
 * When a {@link javax.xml.validation.Schema Schema} is non-null, a parser will use a validator
 * created from it to validate documents before it passes information
 * down to the application.
 *
 * <p>When errors are found by the validator, the parser is responsible
 * to report them to the user-specified {@link org.xml.sax.ErrorHandler}
 * (or if the error handler is not set, ignore them or throw them), just
 * like any other errors found by the parser itself.
 * In other words, if the user-specified {@link org.xml.sax.ErrorHandler}
 * is set, it must receive those errors, and if not, they must be
 * treated according to the implementation specific
 * default error handling rules.
 *
 * <p>
 * A validator may modify the outcome of a parse (for example by
 * adding default values that were missing in documents), and a parser
 * is responsible to make sure that the application will receive
 * modified DOM trees.
 *
 * <p>
 * Initially, null is set as the {@link javax.xml.validation.Schema Schema}.
 *
 * <p>
 * This processing will take effect even if
 * the {@link #isValidating()} method returns <tt>false</tt>.
 *
 * <p>It is an error to use
 * the <code>http://java.sun.com/xml/jaxp/properties/schemaSource</code>
 * property and/or the <code>http://java.sun.com/xml/jaxp/properties/schemaLanguage</code>
 * property in conjunction with a {@link javax.xml.validation.Schema Schema} object.
 * Such configuration will cause a {@link javax.xml.parsers.ParserConfigurationException ParserConfigurationException}
 * exception when the {@link #newDocumentBuilder()} is invoked.</p>
 *
 *
 * <h4>Note for implementors</h4>
 * <p>
 * A parser must be able to work with any {@link javax.xml.validation.Schema Schema}
 * implementation. However, parsers and schemas are allowed
 * to use implementation-specific custom mechanisms
 * as long as they yield the result described in the specification.
 *
 * @param schema <code>Schema</code> to use or <code>null</code> to remove a schema.
 *
 * @throws java.lang.UnsupportedOperationException
 *      For backward compatibility, when implementations for
 *      earlier versions of JAXP is used, this exception will be
 *      thrown.
 *
 * @since 1.5
 * @apiSince 8
 */

public void setSchema(javax.xml.validation.Schema schema) { throw new RuntimeException("Stub!"); }

/**
 * <p>Set state of XInclude processing.</p>
 *
 * <p>If XInclude markup is found in the document instance, should it be
 * processed as specified in <a href="http://www.w3.org/TR/xinclude/">
 * XML Inclusions (XInclude) Version 1.0</a>.</p>
 *
 * <p>XInclude processing defaults to <code>false</code>.</p>
 *
 * @param state Set XInclude processing to <code>true</code> or
 *   <code>false</code>
 *
 * @throws java.lang.UnsupportedOperationException
 *      For backward compatibility, when implementations for
 *      earlier versions of JAXP is used, this exception will be
 *      thrown.
 *
 * @since 1.5
 * @apiSince 1
 */

public void setXIncludeAware(boolean state) { throw new RuntimeException("Stub!"); }

/**
 * <p>Get state of XInclude processing.</p>
 *
 * @return current state of XInclude processing
 *
 * @throws java.lang.UnsupportedOperationException
 *      For backward compatibility, when implementations for
 *      earlier versions of JAXP is used, this exception will be
 *      thrown.
 *
 * @since 1.5
 * @apiSince 1
 */

public boolean isXIncludeAware() { throw new RuntimeException("Stub!"); }
}

