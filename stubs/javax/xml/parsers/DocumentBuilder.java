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

// $Id: DocumentBuilder.java 584483 2007-10-14 02:54:48Z mrglavas $



package javax.xml.parsers;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.EntityResolver;
import java.io.InputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import java.io.File;
import org.xml.sax.InputSource;
import org.w3c.dom.DOMImplementation;
import javax.xml.validation.Schema;

/**
 * Defines the API to obtain DOM Document instances from an XML
 * document. Using this class, an application programmer can obtain a
 * {@link org.w3c.dom.Document Document} from XML.<p>
 *
 * An instance of this class can be obtained from the
 * {@link javax.xml.parsers.DocumentBuilderFactory#newDocumentBuilder() DocumentBuilderFactory#newDocumentBuilder()} method. Once
 * an instance of this class is obtained, XML can be parsed from a
 * variety of input sources. These input sources are InputStreams,
 * Files, URLs, and SAX InputSources.<p>
 *
 * Note that this class reuses several classes from the SAX API. This
 * does not require that the implementor of the underlying DOM
 * implementation use a SAX parser to parse XML document into a
 * <code>Document</code>. It merely requires that the implementation
 * communicate with the application using these existing APIs.
 *
 * @author <a href="mailto:Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 584483 $, $Date: 2007-10-13 19:54:48 -0700 (Sat, 13 Oct 2007) $
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DocumentBuilder {

/**
 * Protected constructor
 * @apiSince 1
 */

protected DocumentBuilder() { throw new RuntimeException("Stub!"); }

/**
 * <p>Reset this <code>DocumentBuilder</code> to its original configuration.</p>
 *
 * <p><code>DocumentBuilder</code> is reset to the same state as when it was created with
 * {@link javax.xml.parsers.DocumentBuilderFactory#newDocumentBuilder() DocumentBuilderFactory#newDocumentBuilder()}.
 * <code>reset()</code> is designed to allow the reuse of existing <code>DocumentBuilder</code>s
 * thus saving resources associated with the creation of new <code>DocumentBuilder</code>s.</p>
 *
 * <p>The reset <code>DocumentBuilder</code> is not guaranteed to have the same {@link org.xml.sax.EntityResolver EntityResolver} or {@link org.xml.sax.ErrorHandler ErrorHandler}
 * <code>Object</code>s, e.g. {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object obj)}.  It is guaranteed to have a functionally equal
 * <code>EntityResolver</code> and <code>ErrorHandler</code>.</p>
 *
 * @since 1.5
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Parse the content of the given <code>InputStream</code> as an XML
 * document and return a new DOM {@link org.w3c.dom.Document Document} object.
 * An <code>IllegalArgumentException</code> is thrown if the
 * <code>InputStream</code> is null.
 *
 * @param is InputStream containing the content to be parsed.
 * @return <code>Document</code> result of parsing the
 *  <code>InputStream</code>
 * @exception java.io.IOException If any IO errors occur.
 * @exception org.xml.sax.SAXException If any parse errors occur.
 * @see org.xml.sax.DocumentHandler
 * @apiSince 1
 */

public org.w3c.dom.Document parse(java.io.InputStream is) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parse the content of the given <code>InputStream</code> as an
 * XML document and return a new DOM {@link org.w3c.dom.Document Document} object.
 * An <code>IllegalArgumentException</code> is thrown if the
 * <code>InputStream</code> is null.
 *
 * @param is InputStream containing the content to be parsed.
 * @param systemId Provide a base for resolving relative URIs.
 * @return A new DOM Document object.
 * @exception java.io.IOException If any IO errors occur.
 * @exception org.xml.sax.SAXException If any parse errors occur.
 * @see org.xml.sax.DocumentHandler
 * @apiSince 1
 */

public org.w3c.dom.Document parse(java.io.InputStream is, java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parse the content of the given URI as an XML document
 * and return a new DOM {@link org.w3c.dom.Document Document} object.
 * An <code>IllegalArgumentException</code> is thrown if the
 * URI is <code>null</code> null.
 *
 * @param uri The location of the content to be parsed.
 * @return A new DOM Document object.
 * @exception java.io.IOException If any IO errors occur.
 * @exception org.xml.sax.SAXException If any parse errors occur.
 * @see org.xml.sax.DocumentHandler
 * @apiSince 1
 */

public org.w3c.dom.Document parse(java.lang.String uri) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parse the content of the given file as an XML document
 * and return a new DOM {@link org.w3c.dom.Document Document} object.
 * An <code>IllegalArgumentException</code> is thrown if the
 * <code>File</code> is <code>null</code> null.
 *
 * @param f The file containing the XML to parse.
 * @exception java.io.IOException If any IO errors occur.
 * @exception org.xml.sax.SAXException If any parse errors occur.
 * @see org.xml.sax.DocumentHandler
 * @return A new DOM Document object.
 * @apiSince 1
 */

public org.w3c.dom.Document parse(java.io.File f) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parse the content of the given input source as an XML document
 * and return a new DOM {@link org.w3c.dom.Document Document} object.
 * An <code>IllegalArgumentException</code> is thrown if the
 * <code>InputSource</code> is <code>null</code> null.
 *
 * @param is InputSource containing the content to be parsed.
 * @exception java.io.IOException If any IO errors occur.
 * @exception org.xml.sax.SAXException If any parse errors occur.
 * @see org.xml.sax.DocumentHandler
 * @return A new DOM Document object.
 * @apiSince 1
 */

public abstract org.w3c.dom.Document parse(org.xml.sax.InputSource is) throws java.io.IOException, org.xml.sax.SAXException;

/**
 * Indicates whether or not this parser is configured to
 * understand namespaces.
 *
 * @return true if this parser is configured to understand
 *         namespaces; false otherwise.
 * @apiSince 1
 */

public abstract boolean isNamespaceAware();

/**
 * Indicates whether or not this parser is configured to
 * validate XML documents.
 *
 * @return true if this parser is configured to validate
 *         XML documents; false otherwise.
 * @apiSince 1
 */

public abstract boolean isValidating();

/**
 * Specify the {@link org.xml.sax.EntityResolver EntityResolver} to be used to resolve
 * entities present in the XML document to be parsed. Setting
 * this to <code>null</code> will result in the underlying
 * implementation using it's own default implementation and
 * behavior.
 *
 * @param er The <code>EntityResolver</code> to be used to resolve entities
 *           present in the XML document to be parsed.
 * @apiSince 1
 */

public abstract void setEntityResolver(org.xml.sax.EntityResolver er);

/**
 * Specify the {@link org.xml.sax.ErrorHandler ErrorHandler} to be used by the parser.
 * Setting this to <code>null</code> will result in the underlying
 * implementation using it's own default implementation and
 * behavior.
 *
 * @param eh The <code>ErrorHandler</code> to be used by the parser.
 * @apiSince 1
 */

public abstract void setErrorHandler(org.xml.sax.ErrorHandler eh);

/**
 * Obtain a new instance of a DOM {@link org.w3c.dom.Document Document} object
 * to build a DOM tree with.
 *
 * @return A new instance of a DOM Document object.
 * @apiSince 1
 */

public abstract org.w3c.dom.Document newDocument();

/**
 * Obtain an instance of a {@link org.w3c.dom.DOMImplementation DOMImplementation} object.
 *
 * @return A new instance of a <code>DOMImplementation</code>.
 * @apiSince 1
 */

public abstract org.w3c.dom.DOMImplementation getDOMImplementation();

/** <p>Get a reference to the the {@link javax.xml.validation.Schema Schema} being used by
 * the XML processor.</p>
 *
 * <p>If no schema is being used, <code>null</code> is returned.</p>
 *
 * @return {@link javax.xml.validation.Schema Schema} being used or <code>null</code>
 *  if none in use
 *
 * @throws java.lang.UnsupportedOperationException
 *      For backward compatibility, when implementations for
 *      earlier versions of JAXP is used, this exception will be
 *      thrown.
 *
 * @since 1.5
 * @apiSince 8
 */

public javax.xml.validation.Schema getSchema() { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the XInclude processing mode for this parser.</p>
 *
 * @return
 *      the return value of
 *      the {@link javax.xml.parsers.DocumentBuilderFactory#isXIncludeAware() DocumentBuilderFactory#isXIncludeAware()}
 *      when this parser was created from factory.
 *
 * @throws java.lang.UnsupportedOperationException
 *      For backward compatibility, when implementations for
 *      earlier versions of JAXP is used, this exception will be
 *      thrown.
 *
 * @since 1.5
 *
 * @see javax.xml.parsers.DocumentBuilderFactory#setXIncludeAware(boolean)
 * @apiSince 1
 */

public boolean isXIncludeAware() { throw new RuntimeException("Stub!"); }
}

