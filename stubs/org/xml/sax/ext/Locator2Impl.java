// Locator2Impl.java - extended LocatorImpl
// http://www.saxproject.org
// Public Domain: no warranty.
// $Id: Locator2Impl.java,v 1.3 2004/04/26 17:34:35 dmegginson Exp $



package org.xml.sax.ext;

import org.xml.sax.Locator;

/**
 * SAX2 extension helper for holding additional Entity information,
 * implementing the {@link org.xml.sax.ext.Locator2 Locator2} interface.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * </blockquote>
 *
 * <p> This is not part of core-only SAX2 distributions.</p>
 *
 * @since SAX 2.0.2
 * @author David Brownell
 * @version TBS
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Locator2Impl extends org.xml.sax.helpers.LocatorImpl implements org.xml.sax.ext.Locator2 {

/**
 * Construct a new, empty Locator2Impl object.
 * This will not normally be useful, since the main purpose
 * of this class is to make a snapshot of an existing Locator.
 * @apiSince 1
 */

public Locator2Impl() { throw new RuntimeException("Stub!"); }

/**
 * Copy an existing Locator or Locator2 object.
 * If the object implements Locator2, values of the
 * <em>encoding</em> and <em>version</em>strings are copied,
 * otherwise they set to <em>null</em>.
 *
 * @param locator The existing Locator object.
 * @apiSince 1
 */

public Locator2Impl(org.xml.sax.Locator locator) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value of the version property.
 *
 * @return the current value of the version property.
 *
 * @see #setXMLVersion
 * @apiSince 1
 */

public java.lang.String getXMLVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value of the encoding property.
 *
 * @return the current value of the encoding property.
 *
 * @see #setEncoding
 * @apiSince 1
 */

public java.lang.String getEncoding() { throw new RuntimeException("Stub!"); }

/**
 * Assigns the current value of the version property.
 *
 * @param version the new "version" value
 * @see #getXMLVersion
 * @apiSince 1
 */

public void setXMLVersion(java.lang.String version) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the current value of the encoding property.
 *
 * @param encoding the new "encoding" value
 * @see #getEncoding
 * @apiSince 1
 */

public void setEncoding(java.lang.String encoding) { throw new RuntimeException("Stub!"); }
}

