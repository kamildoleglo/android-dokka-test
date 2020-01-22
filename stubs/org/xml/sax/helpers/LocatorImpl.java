// SAX default implementation for Locator.
// http://www.saxproject.org
// No warranty; no copyright -- use this as you will.
// $Id: LocatorImpl.java,v 1.6 2002/01/30 20:52:27 dbrownell Exp $



package org.xml.sax.helpers;

import org.xml.sax.Locator;

/**
 * Provide an optional convenience implementation of Locator.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class is available mainly for application writers, who
 * can use it to make a persistent snapshot of a locator at any
 * point during a document parse:</p>
 *
 * <pre>
 * Locator locator;
 * Locator startloc;
 *
 * public void setLocator (Locator locator)
 * {
 *         // note the locator
 *   this.locator = locator;
 * }
 *
 * public void startDocument ()
 * {
 *         // save the location of the start of the document
 *         // for future use.
 *   Locator startloc = new LocatorImpl(locator);
 * }
 *</pre>
 *
 * <p>Normally, parser writers will not use this class, since it
 * is more efficient to provide location information only when
 * requested, rather than constantly updating a Locator object.</p>
 *
 * @since SAX 1.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @see org.xml.sax.Locator Locator
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocatorImpl implements org.xml.sax.Locator {

/**
 * Zero-argument constructor.
 *
 * <p>This will not normally be useful, since the main purpose
 * of this class is to make a snapshot of an existing Locator.</p>
 * @apiSince 1
 */

public LocatorImpl() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor.
 *
 * <p>Create a persistent copy of the current state of a locator.
 * When the original locator changes, this copy will still keep
 * the original values (and it can be used outside the scope of
 * DocumentHandler methods).</p>
 *
 * @param locator The locator to copy.
 * @apiSince 1
 */

public LocatorImpl(org.xml.sax.Locator locator) { throw new RuntimeException("Stub!"); }

/**
 * Return the saved public identifier.
 *
 * @return The public identifier as a string, or null if none
 *         is available.
 * @see org.xml.sax.Locator#getPublicId
 * @see #setPublicId
 * @apiSince 1
 */

public java.lang.String getPublicId() { throw new RuntimeException("Stub!"); }

/**
 * Return the saved system identifier.
 *
 * @return The system identifier as a string, or null if none
 *         is available.
 * @see org.xml.sax.Locator#getSystemId
 * @see #setSystemId
 * @apiSince 1
 */

public java.lang.String getSystemId() { throw new RuntimeException("Stub!"); }

/**
 * Return the saved line number (1-based).
 *
 * @return The line number as an integer, or -1 if none is available.
 * @see org.xml.sax.Locator#getLineNumber
 * @see #setLineNumber
 * @apiSince 1
 */

public int getLineNumber() { throw new RuntimeException("Stub!"); }

/**
 * Return the saved column number (1-based).
 *
 * @return The column number as an integer, or -1 if none is available.
 * @see org.xml.sax.Locator#getColumnNumber
 * @see #setColumnNumber
 * @apiSince 1
 */

public int getColumnNumber() { throw new RuntimeException("Stub!"); }

/**
 * Set the public identifier for this locator.
 *
 * @param publicId The new public identifier, or null
 *        if none is available.
 * @see #getPublicId
 * @apiSince 1
 */

public void setPublicId(java.lang.String publicId) { throw new RuntimeException("Stub!"); }

/**
 * Set the system identifier for this locator.
 *
 * @param systemId The new system identifier, or null
 *        if none is available.
 * @see #getSystemId
 * @apiSince 1
 */

public void setSystemId(java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * Set the line number for this locator (1-based).
 *
 * @param lineNumber The line number, or -1 if none is available.
 * @see #getLineNumber
 * @apiSince 1
 */

public void setLineNumber(int lineNumber) { throw new RuntimeException("Stub!"); }

/**
 * Set the column number for this locator (1-based).
 *
 * @param columnNumber The column number, or -1 if none is available.
 * @see #getColumnNumber
 * @apiSince 1
 */

public void setColumnNumber(int columnNumber) { throw new RuntimeException("Stub!"); }
}

