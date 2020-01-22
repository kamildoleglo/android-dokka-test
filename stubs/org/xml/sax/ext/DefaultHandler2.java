// DefaultHandler2.java - extended DefaultHandler
// http://www.saxproject.org
// Public Domain: no warranty.
// $Id: DefaultHandler2.java,v 1.3 2002/01/12 19:04:19 dbrownell Exp $



package org.xml.sax.ext;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;
import java.io.IOException;
import org.xml.sax.SAXException;

/**
 * This class extends the SAX2 base handler class to support the
 * SAX2 {@link org.xml.sax.ext.LexicalHandler LexicalHandler}, {@link org.xml.sax.ext.DeclHandler DeclHandler}, and
 * {@link org.xml.sax.ext.EntityResolver2 EntityResolver2} extensions.  Except for overriding the
 * original SAX1 {@link org.xml.sax.helpers.DefaultHandler#resolveEntity DefaultHandler#resolveEntity}
 * method the added handler methods just return.  Subclassers may
 * override everything on a method-by-method basis.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * </blockquote>
 *
 * <p> <em>Note:</em> this class might yet learn that the
 * <em>ContentHandler.setDocumentLocator()</em> call might be passed a
 * {@link org.xml.sax.ext.Locator2 Locator2} object, and that the
 * <em>ContentHandler.startElement()</em> call might be passed a
 * {@link org.xml.sax.ext.Attributes2 Attributes2} object.
 *
 * @since SAX 2.0 (extensions 1.1 alpha)
 * @author David Brownell
 * @version TBS
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DefaultHandler2 extends org.xml.sax.helpers.DefaultHandler implements org.xml.sax.ext.LexicalHandler, org.xml.sax.ext.DeclHandler, org.xml.sax.ext.EntityResolver2 {

/**
 * Constructs a handler which ignores all parsing events.
 * @apiSince 1
 */

public DefaultHandler2() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void startCDATA() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void endCDATA() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void startDTD(java.lang.String name, java.lang.String publicId, java.lang.String systemId) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void endDTD() throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void startEntity(java.lang.String name) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void endEntity(java.lang.String name) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void comment(char[] ch, int start, int length) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void attributeDecl(java.lang.String eName, java.lang.String aName, java.lang.String type, java.lang.String mode, java.lang.String value) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void elementDecl(java.lang.String name, java.lang.String model) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void externalEntityDecl(java.lang.String name, java.lang.String publicId, java.lang.String systemId) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void internalEntityDecl(java.lang.String name, java.lang.String value) throws org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Tells the parser that if no external subset has been declared
 * in the document text, none should be used.
 *
 * @param name Identifies the document root element.  This name comes
 *    from a DOCTYPE declaration (where available) or from the actual
 *    root element. The parameter is ignored.
 * @param baseURI The document's base URI, serving as an additional
 *    hint for selecting the external subset.  This is always an absolute
 *    URI, unless it is null because the XMLReader was given an InputSource
 *    without one. The parameter is ignored.
 *
 * @return null (always).
 *
 * @exception org.xml.sax.SAXException Any SAX exception, possibly wrapping
 *    another exception.
 * @exception java.io.IOException Probably indicating a failure to create
 *    a new InputStream or Reader, or an illegal URL.
 * @apiSince 1
 */

public org.xml.sax.InputSource getExternalSubset(java.lang.String name, java.lang.String baseURI) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Tells the parser to resolve the systemId against the baseURI
 * and read the entity text from that resulting absolute URI.
 * Note that because the older
 * {@link org.xml.sax.helpers.DefaultHandler#resolveEntity DefaultHandler#resolveEntity},
 * method is overridden to call this one, this method may sometimes
 * be invoked with null <em>name</em> and <em>baseURI</em>, and
 * with the <em>systemId</em> already absolutized.
 *
 * @param name Identifies the external entity being resolved.
 *    Either "[dtd]" for the external subset, or a name starting
 *    with "%" to indicate a parameter entity, or else the name of
 *    a general entity.  This is never null when invoked by a SAX2
 *    parser.
 * @param publicId The public identifier of the external entity being
 *    referenced (normalized as required by the XML specification), or
 *    null if none was supplied.
 * @param baseURI The URI with respect to which relative systemIDs
 *    are interpreted.  This is always an absolute URI, unless it is
 *    null (likely because the XMLReader was given an InputSource without
 *  one).  This URI is defined by the XML specification to be the one
 *    associated with the "&lt;" starting the relevant declaration.
 * @param systemId The system identifier of the external entity
 *    being referenced; either a relative or absolute URI.
 *  This is never null when invoked by a SAX2 parser; only declared
 *    entities, and any external subset, are resolved by such parsers.
 *
 * @return An InputSource object describing the new input source.
 *
 * @exception org.xml.sax.SAXException Any SAX exception, possibly wrapping
 *    another exception.
 * @exception java.io.IOException Probably indicating a failure to create
 *    a new InputStream or Reader, or an illegal URL.
 * @apiSince 1
 */

public org.xml.sax.InputSource resolveEntity(java.lang.String name, java.lang.String publicId, java.lang.String baseURI, java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }

/**
 * Invokes
 * {@link org.xml.sax.ext.EntityResolver2#resolveEntity EntityResolver2#resolveEntity}
 * with null entity name and base URI.
 * You only need to override that method to use this class.
 *
 * @param publicId The public identifier of the external entity being
 *    referenced (normalized as required by the XML specification), or
 *    null if none was supplied.
 * @param systemId The system identifier of the external entity
 *    being referenced; either a relative or absolute URI.
 *  This is never null when invoked by a SAX2 parser; only declared
 *    entities, and any external subset, are resolved by such parsers.
 *
 * @return An InputSource object describing the new input source.
 *
 * @exception org.xml.sax.SAXException Any SAX exception, possibly wrapping
 *    another exception.
 * @exception java.io.IOException Probably indicating a failure to create
 *    a new InputStream or Reader, or an illegal URL.
 * @apiSince 1
 */

public org.xml.sax.InputSource resolveEntity(java.lang.String publicId, java.lang.String systemId) throws java.io.IOException, org.xml.sax.SAXException { throw new RuntimeException("Stub!"); }
}

