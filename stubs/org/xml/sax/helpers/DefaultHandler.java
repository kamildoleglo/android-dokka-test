// DefaultHandler.java - default implementation of the core handlers.
// http://www.saxproject.org
// Written by David Megginson
// NO WARRANTY!  This class is in the public domain.
// $Id: DefaultHandler.java,v 1.9 2004/04/26 17:34:35 dmegginson Exp $



package org.xml.sax.helpers;

import org.xml.sax.ErrorHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.DTDHandler;
import org.xml.sax.ContentHandler;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.Locator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;

/**
 * Default base class for SAX2 event handlers.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class is available as a convenience base class for SAX2
 * applications: it provides default implementations for all of the
 * callbacks in the four core SAX2 handler classes:</p>
 *
 * <ul>
 * <li>{@link org.xml.sax.EntityResolver EntityResolver}</li>
 * <li>{@link org.xml.sax.DTDHandler DTDHandler}</li>
 * <li>{@link org.xml.sax.ContentHandler ContentHandler}</li>
 * <li>{@link org.xml.sax.ErrorHandler ErrorHandler}</li>
 * </ul>
 *
 * <p>Application writers can extend this class when they need to
 * implement only part of an interface; parser writers can
 * instantiate this class to provide default handlers when the
 * application has not supplied its own.</p>
 *
 * <p>This class replaces the deprecated SAX1
 * {@link org.xml.sax.HandlerBase HandlerBase} class.</p>
 *
 * @since SAX 2.0
 * @author David Megginson,
 * @version 2.0.1 (sax2r2)
 * @see org.xml.sax.EntityResolver
 * @see org.xml.sax.DTDHandler
 * @see org.xml.sax.ContentHandler
 * @see org.xml.sax.ErrorHandler
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DefaultHandler implements org.xml.sax.EntityResolver, org.xml.sax.DTDHandler, org.xml.sax.ContentHandler, org.xml.sax.ErrorHandler {

/** @apiSince 1 */

public DefaultHandler() { throw new RuntimeException("Stub!"); }

/**
 * Resolve an external entity.
 *
 * <p>Always return null, so that the parser will use the system
 * identifier provided in the XML document.  This method implements
 * the SAX default behaviour: application writers can override it
 * in a subclass to do special translations such as catalog lookups
 * or URI redirection.</p>
 *
 * @param publicId The public identifier, or null if none is
 *                 available.
 * @param systemId The system identifier provided in the XML
 *                 document.
 * @return The new input source, or null to require the
 *         default behaviour.
 * @exception java.io.IOException If there is an error setting
 *            up the new input source.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.EntityResolver#resolveEntity
 * @apiSince 1
 */

public org.xml.sax.InputSource resolveEntity(java.lang.String publicId, java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of a notation declaration.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass if they wish to keep track of the notations
 * declared in a document.</p>
 *
 * @param name The notation name.
 * @param publicId The notation public identifier, or null if not
 *                 available.
 * @param systemId The notation system identifier.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.DTDHandler#notationDecl
 * @apiSince 1
 */

public void notationDecl(java.lang.String name, java.lang.String publicId, java.lang.String systemId) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of an unparsed entity declaration.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to keep track of the unparsed entities
 * declared in a document.</p>
 *
 * @param name The entity name.
 * @param publicId The entity public identifier, or null if not
 *                 available.
 * @param systemId The entity system identifier.
 * @param notationName The name of the associated notation.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.DTDHandler#unparsedEntityDecl
 * @apiSince 1
 */

public void unparsedEntityDecl(java.lang.String name, java.lang.String publicId, java.lang.String systemId, java.lang.String notationName) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive a Locator object for document events.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass if they wish to store the locator for use
 * with other document events.</p>
 *
 * @param locator A locator for all SAX document events.
 * @see org.xml.sax.ContentHandler#setDocumentLocator
 * @see org.xml.sax.Locator
 * @apiSince 1
 */

public void setDocumentLocator(org.xml.sax.Locator locator) { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the beginning of the document.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the beginning
 * of a document (such as allocating the root node of a tree or
 * creating an output file).</p>
 *
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#startDocument
 * @apiSince 1
 */

public void startDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the end of the document.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the end
 * of a document (such as finalising a tree or closing an output
 * file).</p>
 *
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#endDocument
 * @apiSince 1
 */

public void endDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the start of a Namespace mapping.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the start of
 * each Namespace prefix scope (such as storing the prefix mapping).</p>
 *
 * @param prefix The Namespace prefix being declared.
 * @param uri The Namespace URI mapped to the prefix.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#startPrefixMapping
 * @apiSince 1
 */

public void startPrefixMapping(java.lang.String prefix, java.lang.String uri) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the end of a Namespace mapping.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the end of
 * each prefix mapping.</p>
 *
 * @param prefix The Namespace prefix being declared.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#endPrefixMapping
 * @apiSince 1
 */

public void endPrefixMapping(java.lang.String prefix) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the start of an element.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the start of
 * each element (such as allocating a new tree node or writing
 * output to a file).</p>
 *
 * @param uri The Namespace URI, or the empty string if the
 *        element has no Namespace URI or if Namespace
 *        processing is not being performed.
 * @param localName The local name (without prefix), or the
 *        empty string if Namespace processing is not being
 *        performed.
 * @param qName The qualified name (with prefix), or the
 *        empty string if qualified names are not available.
 * @param attributes The attributes attached to the element.  If
 *        there are no attributes, it shall be an empty
 *        Attributes object.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#startElement
 * @apiSince 1
 */

public void startElement(java.lang.String uri, java.lang.String localName, java.lang.String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the end of an element.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the end of
 * each element (such as finalising a tree node or writing
 * output to a file).</p>
 *
 * @param uri The Namespace URI, or the empty string if the
 *        element has no Namespace URI or if Namespace
 *        processing is not being performed.
 * @param localName The local name (without prefix), or the
 *        empty string if Namespace processing is not being
 *        performed.
 * @param qName The qualified name (with prefix), or the
 *        empty string if qualified names are not available.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#endElement
 * @apiSince 1
 */

public void endElement(java.lang.String uri, java.lang.String localName, java.lang.String qName) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of character data inside an element.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method to take specific actions for each chunk of character data
 * (such as adding the data to a node or buffer, or printing it to
 * a file).</p>
 *
 * @param ch The characters.
 * @param start The start position in the character array.
 * @param length The number of characters to use from the
 *               character array.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#characters
 * @apiSince 1
 */

public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of ignorable whitespace in element content.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method to take specific actions for each chunk of ignorable
 * whitespace (such as adding data to a node or buffer, or printing
 * it to a file).</p>
 *
 * @param ch The whitespace characters.
 * @param start The start position in the character array.
 * @param length The number of characters to use from the
 *               character array.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#ignorableWhitespace
 * @apiSince 1
 */

public void ignorableWhitespace(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of a processing instruction.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions for each
 * processing instruction, such as setting status variables or
 * invoking other methods.</p>
 *
 * @param target The processing instruction target.
 * @param data The processing instruction data, or null if
 *             none is supplied.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#processingInstruction
 * @apiSince 1
 */

public void processingInstruction(java.lang.String target, java.lang.String data) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of a skipped entity.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions for each
 * processing instruction, such as setting status variables or
 * invoking other methods.</p>
 *
 * @param name The name of the skipped entity.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ContentHandler#processingInstruction
 * @apiSince 1
 */

public void skippedEntity(java.lang.String name) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of a parser warning.
 *
 * <p>The default implementation does nothing.  Application writers
 * may override this method in a subclass to take specific actions
 * for each warning, such as inserting the message in a log file or
 * printing it to the console.</p>
 *
 * @param e The warning information encoded as an exception.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ErrorHandler#warning
 * @see org.xml.sax.SAXParseException
 * @apiSince 1
 */

public void warning(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of a recoverable parser error.
 *
 * <p>The default implementation does nothing.  Application writers
 * may override this method in a subclass to take specific actions
 * for each error, such as inserting the message in a log file or
 * printing it to the console.</p>
 *
 * @param e The warning information encoded as an exception.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ErrorHandler#warning
 * @see org.xml.sax.SAXParseException
 * @apiSince 1
 */

public void error(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Report a fatal XML parsing error.
 *
 * <p>The default implementation throws a SAXParseException.
 * Application writers may override this method in a subclass if
 * they need to take specific actions for each fatal error (such as
 * collecting all of the errors into a single report): in any case,
 * the application must stop all regular processing when this
 * method is invoked, since the document is no longer reliable, and
 * the parser may no longer report parsing events.</p>
 *
 * @param e The error information encoded as an exception.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.ErrorHandler#fatalError
 * @see org.xml.sax.SAXParseException
 * @apiSince 1
 */

public void fatalError(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }
}

