// XMLReaderAdapter.java - adapt an SAX2 XMLReader to a SAX1 Parser
// http://www.saxproject.org
// Written by David Megginson
// NO WARRANTY!  This class is in the public domain.
// $Id: XMLReaderAdapter.java,v 1.9 2004/04/26 17:34:35 dmegginson Exp $



package org.xml.sax.helpers;

import org.xml.sax.XMLReader;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import java.io.IOException;
import org.xml.sax.ContentHandler;

/**
 * Adapt a SAX2 XMLReader as a SAX1 Parser.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class wraps a SAX2 {@link org.xml.sax.XMLReader XMLReader}
 * and makes it act as a SAX1 {@link org.xml.sax.Parser Parser}.  The XMLReader
 * must support a true value for the
 * http://xml.org/sax/features/namespace-prefixes property or parsing will fail
 * with a {@link org.xml.sax.SAXException SAXException}; if the XMLReader
 * supports a false value for the http://xml.org/sax/features/namespaces
 * property, that will also be used to improve efficiency.</p>
 *
 * @since SAX 2.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @see org.xml.sax.Parser
 * @see org.xml.sax.XMLReader
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class XMLReaderAdapter implements org.xml.sax.Parser, org.xml.sax.ContentHandler {

/**
 * Create a new adapter.
 *
 * <p>Use the "org.xml.sax.driver" property to locate the SAX2
 * driver to embed.</p>
 *
 * @exception org.xml.sax.SAXException If the embedded driver
 *            cannot be instantiated or if the
 *            org.xml.sax.driver property is not specified.
 * @apiSince 1
 */

public XMLReaderAdapter() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Create a new adapter.
 *
 * <p>Create a new adapter, wrapped around a SAX2 XMLReader.
 * The adapter will make the XMLReader act like a SAX1
 * Parser.</p>
 *
 * @param xmlReader The SAX2 XMLReader to wrap.
 * @exception java.lang.NullPointerException If the argument is null.
 * @apiSince 1
 */

public XMLReaderAdapter(org.xml.sax.XMLReader xmlReader) { throw new RuntimeException("Stub!"); }

/**
 * Set the locale for error reporting.
 *
 * <p>This is not supported in SAX2, and will always throw
 * an exception.</p>
 *
 * @param locale the locale for error reporting.
 * @see org.xml.sax.Parser#setLocale
 * @exception org.xml.sax.SAXException Thrown unless overridden.
 * @apiSince 1
 */

public void setLocale(java.util.Locale locale) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Register the entity resolver.
 *
 * @param resolver The new resolver.
 * @see org.xml.sax.Parser#setEntityResolver
 * @apiSince 1
 */

public void setEntityResolver(org.xml.sax.EntityResolver resolver) { throw new RuntimeException("Stub!"); }

/**
 * Register the DTD event handler.
 *
 * @param handler The new DTD event handler.
 * @see org.xml.sax.Parser#setDTDHandler
 * @apiSince 1
 */

public void setDTDHandler(org.xml.sax.DTDHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Register the SAX1 document event handler.
 *
 * <p>Note that the SAX1 document handler has no Namespace
 * support.</p>
 *
 * @param handler The new SAX1 document event handler.
 * @see org.xml.sax.Parser#setDocumentHandler
 * @apiSince 1
 */

public void setDocumentHandler(org.xml.sax.DocumentHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Register the error event handler.
 *
 * @param handler The new error event handler.
 * @see org.xml.sax.Parser#setErrorHandler
 * @apiSince 1
 */

public void setErrorHandler(org.xml.sax.ErrorHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Parse the document.
 *
 * <p>This method will throw an exception if the embedded
 * XMLReader does not support the
 * http://xml.org/sax/features/namespace-prefixes property.</p>
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
 * Parse the document.
 *
 * <p>This method will throw an exception if the embedded
 * XMLReader does not support the
 * http://xml.org/sax/features/namespace-prefixes property.</p>
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
 * Set a document locator.
 *
 * @param locator The document locator.
 * @see org.xml.sax.ContentHandler#setDocumentLocator
 * @apiSince 1
 */

public void setDocumentLocator(org.xml.sax.Locator locator) { throw new RuntimeException("Stub!"); }

/**
 * Start document event.
 *
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.ContentHandler#startDocument
 * @apiSince 1
 */

public void startDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * End document event.
 *
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.ContentHandler#endDocument
 * @apiSince 1
 */

public void endDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 start prefix mapping event.
 *
 * @param prefix The prefix being mapped.
 * @param uri The Namespace URI being mapped to.
 * @see org.xml.sax.ContentHandler#startPrefixMapping
 * @apiSince 1
 */

public void startPrefixMapping(java.lang.String prefix, java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 end prefix mapping event.
 *
 * @param prefix The prefix being mapped.
 * @see org.xml.sax.ContentHandler#endPrefixMapping
 * @apiSince 1
 */

public void endPrefixMapping(java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 start element event.
 *
 * @param uri The Namespace URI.
 * @param localName The Namespace local name.
 * @param qName The qualified (prefixed) name.
 * @param atts The SAX2 attributes.
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.ContentHandler#endDocument
 * @apiSince 1
 */

public void startElement(java.lang.String uri, java.lang.String localName, java.lang.String qName, org.xml.sax.Attributes atts) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 end element event.
 *
 * @param uri The Namespace URI.
 * @param localName The Namespace local name.
 * @param qName The qualified (prefixed) name.
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.ContentHandler#endElement
 * @apiSince 1
 */

public void endElement(java.lang.String uri, java.lang.String localName, java.lang.String qName) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 characters event.
 *
 * @param ch An array of characters.
 * @param start The starting position in the array.
 * @param length The number of characters to use.
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.ContentHandler#characters
 * @apiSince 1
 */

public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 ignorable whitespace event.
 *
 * @param ch An array of characters.
 * @param start The starting position in the array.
 * @param length The number of characters to use.
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.ContentHandler#ignorableWhitespace
 * @apiSince 1
 */

public void ignorableWhitespace(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 processing instruction event.
 *
 * @param target The processing instruction target.
 * @param data The remainder of the processing instruction
 * @exception org.xml.sax.SAXException The client may raise a
 *            processing exception.
 * @see org.xml.sax.ContentHandler#processingInstruction
 * @apiSince 1
 */

public void processingInstruction(java.lang.String target, java.lang.String data) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Adapt a SAX2 skipped entity event.
 *
 * @param name The name of the skipped entity.
 * @see org.xml.sax.ContentHandler#skippedEntity
 * @exception org.xml.sax.SAXException Throwable by subclasses.
 * @apiSince 1
 */

public void skippedEntity(java.lang.String name) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }
}

