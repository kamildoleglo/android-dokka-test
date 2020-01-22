// XMLFilterImpl.java - base SAX2 filter implementation.
// http://www.saxproject.org
// Written by David Megginson
// NO WARRANTY!  This class is in the Public Domain.
// $Id: XMLFilterImpl.java,v 1.9 2004/04/26 17:34:35 dmegginson Exp $



package org.xml.sax.helpers;

import org.xml.sax.ErrorHandler;
import org.xml.sax.XMLFilter;
import org.xml.sax.EntityResolver;
import org.xml.sax.DTDHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXNotRecognizedException;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

/**
 * Base class for deriving an XML filter.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class is designed to sit between an {@link org.xml.sax.XMLReader
 * XMLReader} and the client application's event handlers.  By default, it
 * does nothing but pass requests up to the reader and events
 * on to the handlers unmodified, but subclasses can override
 * specific methods to modify the event stream or the configuration
 * requests as they pass through.</p>
 *
 * @since SAX 2.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @see org.xml.sax.XMLFilter
 * @see org.xml.sax.XMLReader
 * @see org.xml.sax.EntityResolver
 * @see org.xml.sax.DTDHandler
 * @see org.xml.sax.ContentHandler
 * @see org.xml.sax.ErrorHandler
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class XMLFilterImpl implements org.xml.sax.XMLFilter, org.xml.sax.EntityResolver, org.xml.sax.DTDHandler, org.xml.sax.ContentHandler, org.xml.sax.ErrorHandler {

/**
 * Construct an empty XML filter, with no parent.
 *
 * <p>This filter will have no parent: you must assign a parent
 * before you start a parse or do any configuration with
 * setFeature or setProperty, unless you use this as a pure event
 * consumer rather than as an {@link org.xml.sax.XMLReader XMLReader}.</p>
 *
 * @see org.xml.sax.XMLReader#setFeature
 * @see org.xml.sax.XMLReader#setProperty
 * @see #setParent
 * @apiSince 1
 */

public XMLFilterImpl() { throw new RuntimeException("Stub!"); }

/**
 * Construct an XML filter with the specified parent.
 *
 * @param parent the XML reader from which this filter receives its events.
 *
 * @see #setParent
 * @see #getParent
 * @apiSince 1
 */

public XMLFilterImpl(org.xml.sax.XMLReader parent) { throw new RuntimeException("Stub!"); }

/**
 * Set the parent reader.
 *
 * <p>This is the {@link org.xml.sax.XMLReader XMLReader} from which
 * this filter will obtain its events and to which it will pass its
 * configuration requests.  The parent may itself be another filter.</p>
 *
 * <p>If there is no parent reader set, any attempt to parse
 * or to set or get a feature or property will fail.</p>
 *
 * @param parent The parent XML reader.
 * @see #getParent
 * @apiSince 1
 */

public void setParent(org.xml.sax.XMLReader parent) { throw new RuntimeException("Stub!"); }

/**
 * Get the parent reader.
 *
 * @return The parent XML reader, or null if none is set.
 * @see #setParent
 * @apiSince 1
 */

public org.xml.sax.XMLReader getParent() { throw new RuntimeException("Stub!"); }

/**
 * Set the value of a feature.
 *
 * <p>This will always fail if the parent is null.</p>
 *
 * @param name The feature name.
 * @param value The requested feature value.
 * @exception org.xml.sax.SAXNotRecognizedException If the feature
 *            value can't be assigned or retrieved from the parent.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            parent recognizes the feature name but
 *            cannot set the requested value.
 * @apiSince 1
 */

public void setFeature(java.lang.String name, boolean value) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Look up the value of a feature.
 *
 * <p>This will always fail if the parent is null.</p>
 *
 * @param name The feature name.
 * @return The current value of the feature.
 * @exception org.xml.sax.SAXNotRecognizedException If the feature
 *            value can't be assigned or retrieved from the parent.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            parent recognizes the feature name but
 *            cannot determine its value at this time.
 * @apiSince 1
 */

public boolean getFeature(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Set the value of a property.
 *
 * <p>This will always fail if the parent is null.</p>
 *
 * @param name The property name.
 * @param value The requested property value.
 * @exception org.xml.sax.SAXNotRecognizedException If the property
 *            value can't be assigned or retrieved from the parent.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            parent recognizes the property name but
 *            cannot set the requested value.
 * @apiSince 1
 */

public void setProperty(java.lang.String name, java.lang.Object value) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Look up the value of a property.
 *
 * @param name The property name.
 * @return The current value of the property.
 * @exception org.xml.sax.SAXNotRecognizedException If the property
 *            value can't be assigned or retrieved from the parent.
 * @exception org.xml.sax.SAXNotSupportedException When the
 *            parent recognizes the property name but
 *            cannot determine its value at this time.
 * @apiSince 1
 */

public java.lang.Object getProperty(java.lang.String name) throws org.xml.sax.SAXNotRecognizedException, org.xml.sax.SAXNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Set the entity resolver.
 *
 * @param resolver The new entity resolver.
 * @apiSince 1
 */

public void setEntityResolver(org.xml.sax.EntityResolver resolver) { throw new RuntimeException("Stub!"); }

/**
 * Get the current entity resolver.
 *
 * @return The current entity resolver, or null if none was set.
 * @apiSince 1
 */

public org.xml.sax.EntityResolver getEntityResolver() { throw new RuntimeException("Stub!"); }

/**
 * Set the DTD event handler.
 *
 * @param handler the new DTD handler
 * @apiSince 1
 */

public void setDTDHandler(org.xml.sax.DTDHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Get the current DTD event handler.
 *
 * @return The current DTD handler, or null if none was set.
 * @apiSince 1
 */

public org.xml.sax.DTDHandler getDTDHandler() { throw new RuntimeException("Stub!"); }

/**
 * Set the content event handler.
 *
 * @param handler the new content handler
 * @apiSince 1
 */

public void setContentHandler(org.xml.sax.ContentHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Get the content event handler.
 *
 * @return The current content handler, or null if none was set.
 * @apiSince 1
 */

public org.xml.sax.ContentHandler getContentHandler() { throw new RuntimeException("Stub!"); }

/**
 * Set the error event handler.
 *
 * @param handler the new error handler
 * @apiSince 1
 */

public void setErrorHandler(org.xml.sax.ErrorHandler handler) { throw new RuntimeException("Stub!"); }

/**
 * Get the current error event handler.
 *
 * @return The current error handler, or null if none was set.
 * @apiSince 1
 */

public org.xml.sax.ErrorHandler getErrorHandler() { throw new RuntimeException("Stub!"); }

/**
 * Parse a document.
 *
 * @param input The input source for the document entity.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @exception java.io.IOException An IO exception from the parser,
 *            possibly from a byte stream or character stream
 *            supplied by the application.
 * @apiSince 1
 */

public void parse(org.xml.sax.InputSource input) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Parse a document.
 *
 * @param systemId The system identifier as a fully-qualified URI.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @exception java.io.IOException An IO exception from the parser,
 *            possibly from a byte stream or character stream
 *            supplied by the application.
 * @apiSince 1
 */

public void parse(java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter an external entity resolution.
 *
 * @param publicId The entity's public identifier, or null.
 * @param systemId The entity's system identifier.
 * @return A new InputSource or null for the default.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @exception java.io.IOException The client may throw an
 *            I/O-related exception while obtaining the
 *            new InputSource.
 * @apiSince 1
 */

public org.xml.sax.InputSource resolveEntity(java.lang.String publicId, java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a notation declaration event.
 *
 * @param name The notation name.
 * @param publicId The notation's public identifier, or null.
 * @param systemId The notation's system identifier, or null.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void notationDecl(java.lang.String name, java.lang.String publicId, java.lang.String systemId) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter an unparsed entity declaration event.
 *
 * @param name The entity name.
 * @param publicId The entity's public identifier, or null.
 * @param systemId The entity's system identifier, or null.
 * @param notationName The name of the associated notation.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void unparsedEntityDecl(java.lang.String name, java.lang.String publicId, java.lang.String systemId, java.lang.String notationName) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a new document locator event.
 *
 * @param locator The document locator.
 * @apiSince 1
 */

public void setDocumentLocator(org.xml.sax.Locator locator) { throw new RuntimeException("Stub!"); }

/**
 * Filter a start document event.
 *
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void startDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter an end document event.
 *
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void endDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a start Namespace prefix mapping event.
 *
 * @param prefix The Namespace prefix.
 * @param uri The Namespace URI.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void startPrefixMapping(java.lang.String prefix, java.lang.String uri) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter an end Namespace prefix mapping event.
 *
 * @param prefix The Namespace prefix.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void endPrefixMapping(java.lang.String prefix) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a start element event.
 *
 * @param uri The element's Namespace URI, or the empty string.
 * @param localName The element's local name, or the empty string.
 * @param qName The element's qualified (prefixed) name, or the empty
 *        string.
 * @param atts The element's attributes.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void startElement(java.lang.String uri, java.lang.String localName, java.lang.String qName, org.xml.sax.Attributes atts) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter an end element event.
 *
 * @param uri The element's Namespace URI, or the empty string.
 * @param localName The element's local name, or the empty string.
 * @param qName The element's qualified (prefixed) name, or the empty
 *        string.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void endElement(java.lang.String uri, java.lang.String localName, java.lang.String qName) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a character data event.
 *
 * @param ch An array of characters.
 * @param start The starting position in the array.
 * @param length The number of characters to use from the array.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter an ignorable whitespace event.
 *
 * @param ch An array of characters.
 * @param start The starting position in the array.
 * @param length The number of characters to use from the array.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void ignorableWhitespace(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a processing instruction event.
 *
 * @param target The processing instruction target.
 * @param data The text following the target.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void processingInstruction(java.lang.String target, java.lang.String data) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a skipped entity event.
 *
 * @param name The name of the skipped entity.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void skippedEntity(java.lang.String name) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a warning event.
 *
 * @param e The warning as an exception.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void warning(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter an error event.
 *
 * @param e The error as an exception.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void error(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Filter a fatal error event.
 *
 * @param e The error as an exception.
 * @exception org.xml.sax.SAXException The client may throw
 *            an exception during processing.
 * @apiSince 1
 */

public void fatalError(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }
}

