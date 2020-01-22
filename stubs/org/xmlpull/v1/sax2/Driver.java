/* -*-             c-basic-offset: 4; indent-tabs-mode: nil; -*-  //------100-columns-wide------>|*/
// for license please see accompanying LICENSE.txt file (available also at http://www.xmlpull.org/)



package org.xmlpull.v1.sax2;

import org.xmlpull.v1.XmlPullParser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;

/**
 * SAX2 Driver that pulls events from XmlPullParser
 * and converts them into SAX2 callbacks.
 *
 * @author <a href="http://www.extreme.indiana.edu/~aslom/">Aleksander Slominski</a>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Driver implements org.xml.sax.Locator, org.xml.sax.XMLReader, org.xml.sax.Attributes {

/**
 @apiSince 1
 */

public Driver() throws org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public Driver(org.xmlpull.v1.XmlPullParser pp) throws org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLength() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getURI(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getLocalName(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getQName(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getType(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getValue(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIndex(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getIndex(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getType(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getType(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getValue(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getValue(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getPublicId() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getSystemId() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineNumber() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnNumber() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getFeature(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setFeature(java.lang.String name, boolean value) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.Object getProperty(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setProperty(java.lang.String name, java.lang.Object value) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setEntityResolver(org.xml.sax.EntityResolver resolver) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public org.xml.sax.EntityResolver getEntityResolver() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setDTDHandler(org.xml.sax.DTDHandler handler) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public org.xml.sax.DTDHandler getDTDHandler() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setContentHandler(org.xml.sax.ContentHandler handler) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public org.xml.sax.ContentHandler getContentHandler() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setErrorHandler(org.xml.sax.ErrorHandler handler) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public org.xml.sax.ErrorHandler getErrorHandler() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void parse(org.xml.sax.InputSource source) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void parse(java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void parseSubTree(org.xmlpull.v1.XmlPullParser pp) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Calls {@link org.xml.sax.ContentHandler#startElement(java.lang.String,java.lang.String,java.lang.String,org.xml.sax.Attributes) ContentHandler#startElement(String, String, String, Attributes)}
 * on the <code>ContentHandler</code> with <code>this</code> driver object as the
 * {@link org.xml.sax.Attributes Attributes} implementation. In default implementation
 * {@link org.xml.sax.Attributes Attributes} object is valid only during this method call and may not
 * be stored. Sub-classes can overwrite this method to cache attributes.
 * @apiSince 1
 */

protected void startElement(java.lang.String namespace, java.lang.String localName, java.lang.String qName) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected static final java.lang.String APACHE_DYNAMIC_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/dynamic";

/** @apiSince 1 */

protected static final java.lang.String APACHE_SCHEMA_VALIDATION_FEATURE = "http://apache.org/xml/features/validation/schema";

/** @apiSince 1 */

protected static final java.lang.String DECLARATION_HANDLER_PROPERTY = "http://xml.org/sax/properties/declaration-handler";

/** @apiSince 1 */

protected static final java.lang.String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";

/** @apiSince 1 */

protected static final java.lang.String NAMESPACES_FEATURE = "http://xml.org/sax/features/namespaces";

/** @apiSince 1 */

protected static final java.lang.String NAMESPACE_PREFIXES_FEATURE = "http://xml.org/sax/features/namespace-prefixes";

/** @apiSince 1 */

protected static final java.lang.String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";

/** @apiSince 1 */

protected org.xml.sax.ContentHandler contentHandler;

/** @apiSince 1 */

protected org.xml.sax.ErrorHandler errorHandler;

/** @apiSince 1 */

protected org.xmlpull.v1.XmlPullParser pp;

/** @apiSince 1 */

protected java.lang.String systemId;
}

