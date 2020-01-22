// Attributes2Impl.java - extended AttributesImpl
// http://www.saxproject.org
// Public Domain: no warranty.
// $Id: Attributes2Impl.java,v 1.5 2004/03/08 13:01:01 dmegginson Exp $



package org.xml.sax.ext;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

/**
 * SAX2 extension helper for additional Attributes information,
 * implementing the {@link org.xml.sax.ext.Attributes2 Attributes2} interface.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * </blockquote>
 *
 * <p>This is not part of core-only SAX2 distributions.</p>
 *
 * <p>The <em>specified</em> flag for each attribute will always
 * be true, unless it has been set to false in the copy constructor
 * or using {@link #setSpecified}.
 * Similarly, the <em>declared</em> flag for each attribute will
 * always be false, except for defaulted attributes (<em>specified</em>
 * is false), non-CDATA attributes, or when it is set to true using
 * {@link #setDeclared}.
 * If you change an attribute's type by hand, you may need to modify
 * its <em>declared</em> flag to match.
 * </p>
 *
 * @since SAX 2.0 (extensions 1.1 alpha)
 * @author David Brownell
 * @version TBS
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Attributes2Impl extends org.xml.sax.helpers.AttributesImpl implements org.xml.sax.ext.Attributes2 {

/**
 * Construct a new, empty Attributes2Impl object.
 * @apiSince 1
 */

public Attributes2Impl() { throw new RuntimeException("Stub!"); }

/**
 * Copy an existing Attributes or Attributes2 object.
 * If the object implements Attributes2, values of the
 * <em>specified</em> and <em>declared</em> flags for each
 * attribute are copied.
 * Otherwise the flag values are defaulted to assume no DTD was used,
 * unless there is evidence to the contrary (such as attributes with
 * type other than CDATA, which must have been <em>declared</em>).
 *
 * <p>This constructor is especially useful inside a
 * {@link org.xml.sax.ContentHandler#startElement startElement} event.</p>
 *
 * @param atts The existing Attributes object.
 * @apiSince 1
 */

public Attributes2Impl(org.xml.sax.Attributes atts) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isDeclared(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isDeclared(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isDeclared(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value of an attribute's "specified" flag.
 *
 * @param index The attribute index (zero-based).
 * @return current flag value
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not identify an attribute.
 * @apiSince 1
 */

public boolean isSpecified(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value of an attribute's "specified" flag.
 *
 * @param uri The Namespace URI, or the empty string if
 *        the name has no Namespace URI.
 * @param localName The attribute's local name.
 * @return current flag value
 * @exception java.lang.IllegalArgumentException When the
 *            supplied names do not identify an attribute.
 * @apiSince 1
 */

public boolean isSpecified(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value of an attribute's "specified" flag.
 *
 * @param qName The XML qualified (prefixed) name.
 * @return current flag value
 * @exception java.lang.IllegalArgumentException When the
 *            supplied name does not identify an attribute.
 * @apiSince 1
 */

public boolean isSpecified(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/**
 * Copy an entire Attributes object.  The "specified" flags are
 * assigned as true, and "declared" flags as false (except when
 * an attribute's type is not CDATA),
 * unless the object is an Attributes2 object.
 * In that case those flag values are all copied.
 *
 * @param atts The attributes to copy.
 *
 * @see org.xml.sax.helpers.AttributesImpl#setAttributes
 * @apiSince 1
 */

public void setAttributes(org.xml.sax.Attributes atts) { throw new RuntimeException("Stub!"); }

/**
 * Add an attribute to the end of the list, setting its
 * "specified" flag to true.  To set that flag's value
 * to false, use {@link #setSpecified}.
 *
 * <p>Unless the attribute <em>type</em> is CDATA, this attribute
 * is marked as being declared in the DTD.  To set that flag's value
 * to true for CDATA attributes, use {@link #setDeclared}.
 *
 * @param uri The Namespace URI, or the empty string if
 *        none is available or Namespace processing is not
 *        being performed.
 * @param localName The local name, or the empty string if
 *        Namespace processing is not being performed.
 * @param qName The qualified (prefixed) name, or the empty string
 *        if qualified names are not available.
 * @param type The attribute type as a string.
 * @param value The attribute value.
 *
 * @see org.xml.sax.helpers.AttributesImpl#addAttribute
 * @apiSince 1
 */

public void addAttribute(java.lang.String uri, java.lang.String localName, java.lang.String qName, java.lang.String type, java.lang.String value) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeAttribute(int index) { throw new RuntimeException("Stub!"); }

/**
 * Assign a value to the "declared" flag of a specific attribute.
 * This is normally needed only for attributes of type CDATA,
 * including attributes whose type is changed to or from CDATA.
 *
 * @param index The index of the attribute (zero-based).
 * @param value The desired flag value.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not identify an attribute.
 * @see #setType
 * @apiSince 1
 */

public void setDeclared(int index, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Assign a value to the "specified" flag of a specific attribute.
 * This is the only way this flag can be cleared, except clearing
 * by initialization with the copy constructor.
 *
 * @param index The index of the attribute (zero-based).
 * @param value The desired flag value.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not identify an attribute.
 * @apiSince 1
 */

public void setSpecified(int index, boolean value) { throw new RuntimeException("Stub!"); }
}

