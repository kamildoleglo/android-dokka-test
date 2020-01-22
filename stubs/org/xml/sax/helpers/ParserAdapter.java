// ParserAdapter.java - adapt a SAX1 Parser to a SAX2 XMLReader.
// http://www.saxproject.org
// Written by David Megginson
// NO WARRANTY!  This class is in the public domain.
// $Id: ParserAdapter.java,v 1.16 2004/04/26 17:34:35 dmegginson Exp $



package org.xml.sax.helpers;

import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.InputSource;
import java.io.IOException;
import org.xml.sax.DocumentHandler;

/**
 * Adapt a SAX1 Parser as a SAX2 XMLReader.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class wraps a SAX1 {@link org.xml.sax.Parser Parser}
 * and makes it act as a SAX2 {@link org.xml.sax.XMLReader XMLReader},
 * with feature, property, and Namespace support.  Note
 * that it is not possible to report {@link org.xml.sax.ContentHandler#skippedEntity
 * skippedEntity} events, since SAX1 does not make that information available.</p>
 *
 * <p>This adapter does not test for duplicate Namespace-qualified
 * attribute names.</p>
 *
 * @since SAX 2.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @see org.xml.sax.helpers.XMLReaderAdapter
 * @see org.xml.sax.XMLReader
 * @see org.xml.sax.Parser
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ParserAdapter implements org.xml.sax.XMLReader, org.xml.sax.DocumentHandler {

/**
 * Construct a new parser adapter.
 *
 * <p>Use the "org.xml.sax.parser" property to locate the
 * embedded SAX1 driver.</p>
 *
 * @exception org.xml.sax.SAXException If the embedded driver
 *            cannot be instantiated or if the
 *            org.xml.sax.parser property is not specified.
 * @apiSince 1
 */

public ParserAdapter() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Construct a new parser adapter.
 *
 * <p>Note that the embedded parser cannot be changed once the
 * adapter is created; to embed a different parser, allocate
 * a new ParserAdapter.</p>
 *
 * @param parser The SAX1 parser to embed.
 * @exception java.lang.NullPointerException If the parser parameter
 *            is null.
 * @apiSince 1
 */

public ParserAdapter(org.xml.sax.Parser parser) { throw new RuntimeException("Stub!"); }

/**
 * Set a feature flag for the parser.
 *
 * <p>The only features recognized are namespaces and
 * namespace-prefixes.</p>
 *
 * @param name The feature name, as a complete URI.
 * @param value The requested feature value.
 * @exception org.xml.sax.SAXNotRecognizedException If the feature
 *            can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException If the feature
 *            can't be assigned that value.
 * @see org.xml.sax.XMLReader#setFeature
 * @apiSince 1
 */

public void setFeature(java.lang.String name, boolean value) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Check a parser feature flag.
 *
 * <p>The only features recognized are namespaces and
 * namespace-prefixes.</p>
 *
 * @param name The feature name, as a complete URI.
 * @return The current feature value.
 * @exception org.xml.sax.SAXNotRecognizedException If the feature
 *            value can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException If the
 *            feature is not currently readable.
 * @see org.xml.sax.XMLReader#setFeature
 * @apiSince 1
 */

public boolean getFeature(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Set a parser property.
 *
 * <p>No properties are currently recognized.</p>
 *
 * @param name The property name.
 * @param value The property value.
 * @exception org.xml.sax.SAXNotRecognizedException If the property
 *            value can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException If the property
 *            can't be assigned that value.
 * @see org.xml.sax.XMLReader#setProperty
 * @apiSince 1
 */

public void setProperty(java.lang.String name, java.lang.Object value) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Get a parser property.
 *
 * <p>No properties are currently recognized.</p>
 *
 * @param name The property name.
 * @return The property value.
 * @exception org.xml.sax.SAXNotRecognizedException If the property
 *            value can't be assigned or retrieved.
 * @exception org.xml.sax.SAXNotSupportedException If the property
 *            value is not currently readable.
 * @see org.xml.sax.XMLReader#getProperty
 * @apiSince 1
 */

public java.lang.Object getProperty(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Set the entity resolver.
 *
 * @param resolver The new entity resolver.
 * @see org.xml.sax.XMLReader#setEntityResolver
 * @apiSince 1
 */

public void setEntityResolver(org.xml.sax.EntityResolver resolver) { throw new RuntimeException("Stub!"); }

/**
 * Return the current entity resolver.
 *
 * @return The current entity resolver, or null if none was supplied.
 * @see org.xml.sax.XMLReader#getEntityResolver
 * @apiSince 1
 */

public org.xml.sax.EntityResolver getEntityResolver() { throw new RuntimeException("Stub!"); }

/**
 * Set the DTD handler.
 *
 * @param handler the new DTD handler
 * @see org.xml.sax.XMLReader#setEntityResolver
 * @apiSince 1
 */

public void setDTDHandler(org.xml.sax.DTDHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Return the current DTD handler.
 *
 * @return the current DTD handler, or null if none was supplied
 * @see org.xml.sax.XMLReader#getEntityResolver
 * @apiSince 1
 */

public org.xml.sax.DTDHandler getDTDHandler() { throw new RuntimeException("Stub!"); }

/**
 * Set the content handler.
 *
 * @param handler the new content handler
 * @see org.xml.sax.XMLReader#setEntityResolver
 * @apiSince 1
 */

public void setContentHandler(org.xml.sax.ContentHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Return the current content handler.
 *
 * @return The current content handler, or null if none was supplied.
 * @see org.xml.sax.XMLReader#getEntityResolver
 * @apiSince 1
 */

public org.xml.sax.ContentHandler getContentHandler() { throw new RuntimeException("Stub!"); }

/**
 * Set the error handler.
 *
 * @param handler The new error handler.
 * @see org.xml.sax.XMLReader#setEntityResolver
 * @apiSince 1
 */

public void setErrorHandler(org.xml.sax.ErrorHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Return the current error handler.
 *
 * @return The current error handler, or null if none was supplied.
 * @see org.xml.sax.XMLReader#getEntityResolver
 * @apiSince 1
 */

public org.xml.sax.ErrorHandler getErrorHandler() { throw new RuntimeException("Stub!"); }

/**
 * Parse an XML document.
 *
 * @param systemId The absolute URL of the document.
 * @exception java.io.IOException If there is a problem reading
 *            the raw content of the document.
 * @exception org.xml.sax.SAXException If there is a problem
 *            processing the document.
 * @see #parse(org.xml.sax.InputSource)
 * @see org.xml.sax.Parser#parse(java.lang.String)
 * @apiSince 1
 */

public void parse(java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parse an XML document.
 *
 * @param input An input source for the document.
 * @exception java.io.IOException If there is a problem reading
 *            the raw content of the document.
 * @exception org.xml.sax.SAXException If there is a problem
 *            processing the document.
 * @see #parse(java.lang.String)
 * @see org.xml.sax.Parser#parse(org.xml.sax.InputSource)
 * @apiSince 1
 */

public void parse(org.xml.sax.InputSource input) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 document locator event.
 *
 * @param locator A document locator.
 * @see org.xml.sax.ContentHandler#setDocumentLocator
 * @apiSince 1
 */

public void setDocumentLocator(org.xml.sax.Locator locator) { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 start document event.
 *
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.DocumentHandler#startDocument
 * @apiSince 1
 */

public void startDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 end document event.
 *
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.DocumentHandler#endDocument
 * @apiSince 1
 */

public void endDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 startElement event.
 *
 * <p>If necessary, perform Namespace processing.</p>
 *
 * @param qName The qualified (prefixed) name.
 * @param qAtts The XML attribute list (with qnames).
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @apiSince 1
 */

public void startElement(java.lang.String qName, org.xml.sax.AttributeList qAtts) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 end element event.
 *
 * @param qName The qualified (prefixed) name.
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.DocumentHandler#endElement
 * @apiSince 1
 */

public void endElement(java.lang.String qName) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 characters event.
 *
 * @param ch An array of characters.
 * @param start The starting position in the array.
 * @param length The number of characters to use.
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.DocumentHandler#characters
 * @apiSince 1
 */

public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 ignorable whitespace event.
 *
 * @param ch An array of characters.
 * @param start The starting position in the array.
 * @param length The number of characters to use.
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.DocumentHandler#ignorableWhitespace
 * @apiSince 1
 */

public void ignorableWhitespace(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapter implementation method; do not call.
 * Adapt a SAX1 processing instruction event.
 *
 * @param target The processing instruction target.
 * @param data The remainder of the processing instruction
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.DocumentHandler#processingInstruction
 * @apiSince 1
 */

public void processingInstruction(java.lang.String target, java.lang.String data) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }
}

