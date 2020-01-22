// SAX default handler base class.
// http://www.saxproject.org
// No warranty; no copyright -- use this as you will.
// $Id: HandlerBase.java,v 1.7 2004/04/26 17:34:34 dmegginson Exp $



package org.xml.sax;


/**
 * Default base class for handlers.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class implements the default behaviour for four SAX1
 * interfaces: EntityResolver, DTDHandler, DocumentHandler,
 * and ErrorHandler.  It is now obsolete, but is included in SAX2 to
 * support legacy SAX1 applications.  SAX2 applications should use
 * the {@link org.xml.sax.helpers.DefaultHandler DefaultHandler}
 * class instead.</p>
 *
 * <p>Application writers can extend this class when they need to
 * implement only part of an interface; parser writers can
 * instantiate this class to provide default handlers when the
 * application has not supplied its own.</p>
 *
 * <p>Note that the use of this class is optional.</p>
 *
 * @deprecated This class works with the deprecated
 *             {@link org.xml.sax.DocumentHandler DocumentHandler}
 *             interface.  It has been replaced by the SAX2
 *             {@link org.xml.sax.helpers.DefaultHandler DefaultHandler}
 *             class.
 * @since SAX 1.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @see org.xml.sax.EntityResolver
 * @see org.xml.sax.DTDHandler
 * @see org.xml.sax.DocumentHandler
 * @see org.xml.sax.ErrorHandler
 * @apiSince 1
 * @deprecatedSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class HandlerBase implements org.xml.sax.EntityResolver, org.xml.sax.DTDHandler, org.xml.sax.DocumentHandler, org.xml.sax.ErrorHandler {

/** @apiSince 1 */

@Deprecated
public HandlerBase() { throw new RuntimeException("Stub!"); }

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
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.EntityResolver#resolveEntity
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public org.xml.sax.InputSource resolveEntity(java.lang.String publicId, java.lang.String systemId) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

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
 * @see org.xml.sax.DTDHandler#notationDecl
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public void notationDecl(java.lang.String name, java.lang.String publicId, java.lang.String systemId) { throw new RuntimeException("Stub!"); }

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
 * @see org.xml.sax.DTDHandler#unparsedEntityDecl
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public void unparsedEntityDecl(java.lang.String name, java.lang.String publicId, java.lang.String systemId, java.lang.String notationName) { throw new RuntimeException("Stub!"); }

/**
 * Receive a Locator object for document events.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass if they wish to store the locator for use
 * with other document events.</p>
 *
 * @param locator A locator for all SAX document events.
 * @see org.xml.sax.DocumentHandler#setDocumentLocator
 * @see org.xml.sax.Locator
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
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
 * @see org.xml.sax.DocumentHandler#startDocument
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public void startDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the end of the document.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the beginning
 * of a document (such as finalising a tree or closing an output
 * file).</p>
 *
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.DocumentHandler#endDocument
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public void endDocument() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the start of an element.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the start of
 * each element (such as allocating a new tree node or writing
 * output to a file).</p>
 *
 * @param name The element type name.
 * @param attributes The specified or defaulted attributes.
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.DocumentHandler#startElement
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public void startElement(java.lang.String name, org.xml.sax.AttributeList attributes) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Receive notification of the end of an element.
 *
 * <p>By default, do nothing.  Application writers may override this
 * method in a subclass to take specific actions at the end of
 * each element (such as finalising a tree node or writing
 * output to a file).</p>
 *
 * @param name the element name
 * @exception org.xml.sax.SAXException Any SAX exception, possibly
 *            wrapping another exception.
 * @see org.xml.sax.DocumentHandler#endElement
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public void endElement(java.lang.String name) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

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
 * @see org.xml.sax.DocumentHandler#characters
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
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
 * @see org.xml.sax.DocumentHandler#ignorableWhitespace
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
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
 * @see org.xml.sax.DocumentHandler#processingInstruction
 * @apiSince 1
 * @deprecatedSince 9
 */

@Deprecated
public void processingInstruction(java.lang.String target, java.lang.String data) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

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
 * @deprecatedSince 9
 */

@Deprecated
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
 * @deprecatedSince 9
 */

@Deprecated
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
 * @deprecatedSince 9
 */

@Deprecated
public void fatalError(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }
}

