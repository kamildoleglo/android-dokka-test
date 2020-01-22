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

// $Id: SAXParserFactory.java 884950 2009-11-27 18:46:18Z mrglavas $



package javax.xml.parsers;

import org.xml.sax.SAXException;
import javax.xml.validation.Schema;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXNotRecognizedException;

/**
 * Defines a factory API that enables applications to configure and
 * obtain a SAX based parser to parse XML documents.
 *
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 884950 $, $Date: 2009-11-27 10:46:18 -0800 (Fri, 27 Nov 2009) $
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SAXParserFactory {

/**
 * <p>Protected constructor to force use of {@link #newInstance()}.</p>
 * @apiSince 1
 */

protected SAXParserFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns Android's implementation of {@code SAXParserFactory}. Unlike
 * other Java implementations, this method does not consult system
 * properties, property files, or the services API.
 *
 * @return a new SAXParserFactory.
 *
 * @exception javax.xml.parsers.FactoryConfigurationError never. Included for API
 *     compatibility with other Java implementations.
 * @apiSince 1
 */

public static javax.xml.parsers.SAXParserFactory newInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns an instance of the named implementation of {@code SAXParserFactory}.
 *
 * @throws javax.xml.parsers.FactoryConfigurationError if {@code factoryClassName} is not available or cannot be
 *     instantiated.
 * @since 1.6
 * @apiSince 9
 */

public static javax.xml.parsers.SAXParserFactory newInstance(java.lang.String factoryClassName, java.lang.ClassLoader classLoader) { throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new instance of a SAXParser using the currently
 * configured factory parameters.</p>
 *
 * @return A new instance of a SAXParser.
 *
 * @exception javax.xml.parsers.ParserConfigurationException if a parser cannot
 *   be created which satisfies the requested configuration.
 * @exception org.xml.sax.SAXException for SAX errors.
 * @apiSince 1
 */

public abstract javax.xml.parsers.SAXParser newSAXParser() throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException;

/**
 * Specifies that the parser produced by this code will
 * provide support for XML namespaces. By default the value of this is set
 * to <code>false</code>.
 *
 * @param awareness true if the parser produced by this code will
 *                  provide support for XML namespaces; false otherwise.
 * @apiSince 1
 */

public void setNamespaceAware(boolean awareness) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the parser produced by this code will
 * validate documents as they are parsed. By default the value of this is
 * set to <code>false</code>.
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
 * @param validating true if the parser produced by this code will
 *                   validate documents as they are parsed; false otherwise.
 * @apiSince 1
 */

public void setValidating(boolean validating) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which are namespace aware.
 *
 * @return true if the factory is configured to produce
 *         parsers which are namespace aware; false otherwise.
 * @apiSince 1
 */

public boolean isNamespaceAware() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which validate the XML content during parse.
 *
 * @return true if the factory is configured to produce parsers which validate
 *         the XML content during parse; false otherwise.
 * @apiSince 1
 */

public boolean isValidating() { throw new RuntimeException("Stub!"); }

/**
 *
 * <p>Sets the particular feature in the underlying implementation of
 * org.xml.sax.XMLReader.
 * A list of the core features and properties can be found at
 * <a href="http://www.saxproject.org/">http://www.saxproject.org/</a></p>
 *
 * <p>All implementations are required to support the {@link javax.xml.XMLConstants#FEATURE_SECURE_PROCESSING} feature.
 * When the feature is</p>
 * <ul>
 *   <li>
 *     <code>true</code>: the implementation will limit XML processing to conform to implementation limits.
 *     Examples include entity expansion limits and XML Schema constructs that would consume large amounts of resources.
 *     If XML processing is limited for security reasons, it will be reported via a call to the registered
 *     {@link org.xml.sax.ErrorHandler#fatalError(SAXParseException exception)}.
 *     See {@link javax.xml.parsers.SAXParser SAXParser} <code>parse</code> methods for handler specification.
 *   </li>
 *   <li>
 *     When the feature is <code>false</code>, the implementation will processing XML according to the XML specifications without
 *     regard to possible implementation limits.
 *   </li>
 * </ul>
 *
 * @param name The name of the feature to be set.
 * @param value The value of the feature to be set.
 *
 * @exception javax.xml.parsers.ParserConfigurationException if a parser cannot
 *     be created which satisfies the requested configuration.
 * @exception org.xml.sax.SAXNotRecognizedException When the underlying XMLReader does
 *            not recognize the property name.
 * @exception org.xml.sax.SAXNotSupportedException When the underlying XMLReader
 *            recognizes the property name but doesn't support the
 *            property.
 * @throws java.lang.NullPointerException If the <code>name</code> parameter is null.
 *
 * @see org.xml.sax.XMLReader#setFeature
 @apiSince 1
 */

public abstract void setFeature(java.lang.String name, boolean value) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException;

/**
 *
 * <p>Returns the particular property requested for in the underlying
 * implementation of org.xml.sax.XMLReader.</p>
 *
 * @param name The name of the property to be retrieved.
 *
 * @return Value of the requested property.
 *
 * @exception javax.xml.parsers.ParserConfigurationException if a parser cannot be created which satisfies the requested configuration.
 * @exception org.xml.sax.SAXNotRecognizedException When the underlying XMLReader does not recognize the property name.
 * @exception org.xml.sax.SAXNotSupportedException When the underlying XMLReader recognizes the property name but doesn't support the property.
 *
 * @see org.xml.sax.XMLReader#getProperty
 @apiSince 1
 */

public abstract boolean getFeature(java.lang.String name) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException;

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
 *      if the method was not invoked since a {@link javax.xml.parsers.SAXParserFactory SAXParserFactory}
 *      is created.
 *
 * @since 1.5
 * @apiSince 8
 */

public javax.xml.validation.Schema getSchema() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the {@link javax.xml.validation.Schema Schema} to be used by parsers created
 * from this factory.</p>
 *
 * <p>When a {@link javax.xml.validation.Schema Schema} is non-null, a parser will use a validator
 * created from it to validate documents before it passes information
 * down to the application.</p>
 *
 * <p>When warnings/errors/fatal errors are found by the validator, the parser must
 * handle them as if those errors were found by the parser itself.
 * In other words, if the user-specified {@link org.xml.sax.ErrorHandler}
 * is set, it must receive those errors, and if not, they must be
 * treated according to the implementation specific
 * default error handling rules.
 *
 * <p>A validator may modify the SAX event stream (for example by
 * adding default values that were missing in documents), and a parser
 * is responsible to make sure that the application will receive
 * those modified event stream.</p>
 *
 * <p>Initially, <code>null</code> is set as the {@link javax.xml.validation.Schema Schema}.</p>
 *
 * <p>This processing will take effect even if
 * the {@link #isValidating()} method returns <code>false</code>.
 *
 * <p>It is an error to use
 * the <code>http://java.sun.com/xml/jaxp/properties/schemaSource</code>
 * property and/or the <code>http://java.sun.com/xml/jaxp/properties/schemaLanguage</code>
 * property in conjunction with a non-null {@link javax.xml.validation.Schema Schema} object.
 * Such configuration will cause a {@link org.xml.sax.SAXException SAXException}
 * exception when those properties are set on a {@link javax.xml.parsers.SAXParser SAXParser}.</p>
 *
 * <h4>Note for implementors</h4>
 * <p>
 * A parser must be able to work with any {@link javax.xml.validation.Schema Schema}
 * implementation. However, parsers and schemas are allowed
 * to use implementation-specific custom mechanisms
 * as long as they yield the result described in the specification.
 * </p>
 *
 * @param schema <code>Schema</code> to use, <code>null</code> to remove a schema.
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

