// AttributesImpl.java - default implementation of Attributes.
// http://www.saxproject.org
// Written by David Megginson
// NO WARRANTY!  This class is in the public domain.
// $Id: AttributesImpl.java,v 1.9 2002/01/30 20:52:24 dbrownell Exp $



package org.xml.sax.helpers;

import org.xml.sax.Attributes;

/**
 * Default implementation of the Attributes interface.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class provides a default implementation of the SAX2
 * {@link org.xml.sax.Attributes Attributes} interface, with the
 * addition of manipulators so that the list can be modified or
 * reused.</p>
 *
 * <p>There are two typical uses of this class:</p>
 *
 * <ol>
 * <li>to take a persistent snapshot of an Attributes object
 *  in a {@link org.xml.sax.ContentHandler#startElement startElement} event; or</li>
 * <li>to construct or modify an Attributes object in a SAX2 driver or filter.</li>
 * </ol>
 *
 * <p>This class replaces the now-deprecated SAX1 {@link
 * org.xml.sax.helpers.AttributeListImpl AttributeListImpl}
 * class; in addition to supporting the updated Attributes
 * interface rather than the deprecated {@link org.xml.sax.AttributeList
 * AttributeList} interface, it also includes a much more efficient
 * implementation using a single array rather than a set of Vectors.</p>
 *
 * @since SAX 2.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AttributesImpl implements org.xml.sax.Attributes {

/**
 * Construct a new, empty AttributesImpl object.
 * @apiSince 1
 */

public AttributesImpl() { throw new RuntimeException("Stub!"); }

/**
 * Copy an existing Attributes object.
 *
 * <p>This constructor is especially useful inside a
 * {@link org.xml.sax.ContentHandler#startElement startElement} event.</p>
 *
 * @param atts The existing Attributes object.
 * @apiSince 1
 */

public AttributesImpl(org.xml.sax.Attributes atts) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of attributes in the list.
 *
 * @return The number of attributes in the list.
 * @see org.xml.sax.Attributes#getLength
 * @apiSince 1
 */

public int getLength() { throw new RuntimeException("Stub!"); }

/**
 * Return an attribute's Namespace URI.
 *
 * @param index The attribute's index (zero-based).
 * @return The Namespace URI, the empty string if none is
 *         available, or null if the index is out of range.
 * @see org.xml.sax.Attributes#getURI
 * @apiSince 1
 */

public java.lang.String getURI(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return an attribute's local name.
 *
 * @param index The attribute's index (zero-based).
 * @return The attribute's local name, the empty string if
 *         none is available, or null if the index if out of range.
 * @see org.xml.sax.Attributes#getLocalName
 * @apiSince 1
 */

public java.lang.String getLocalName(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return an attribute's qualified (prefixed) name.
 *
 * @param index The attribute's index (zero-based).
 * @return The attribute's qualified name, the empty string if
 *         none is available, or null if the index is out of bounds.
 * @see org.xml.sax.Attributes#getQName
 * @apiSince 1
 */

public java.lang.String getQName(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return an attribute's type by index.
 *
 * @param index The attribute's index (zero-based).
 * @return The attribute's type, "CDATA" if the type is unknown, or null
 *         if the index is out of bounds.
 * @see org.xml.sax.Attributes#getType(int)
 * @apiSince 1
 */

public java.lang.String getType(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return an attribute's value by index.
 *
 * @param index The attribute's index (zero-based).
 * @return The attribute's value or null if the index is out of bounds.
 * @see org.xml.sax.Attributes#getValue(int)
 * @apiSince 1
 */

public java.lang.String getValue(int index) { throw new RuntimeException("Stub!"); }

/**
 * Look up an attribute's index by Namespace name.
 *
 * <p>In many cases, it will be more efficient to look up the name once and
 * use the index query methods rather than using the name query methods
 * repeatedly.</p>
 *
 * @param uri The attribute's Namespace URI, or the empty
 *        string if none is available.
 * @param localName The attribute's local name.
 * @return The attribute's index, or -1 if none matches.
 * @see org.xml.sax.Attributes#getIndex(java.lang.String,java.lang.String)
 * @apiSince 1
 */

public int getIndex(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Look up an attribute's index by qualified (prefixed) name.
 *
 * @param qName The qualified name.
 * @return The attribute's index, or -1 if none matches.
 * @see org.xml.sax.Attributes#getIndex(java.lang.String)
 * @apiSince 1
 */

public int getIndex(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/**
 * Look up an attribute's type by Namespace-qualified name.
 *
 * @param uri The Namespace URI, or the empty string for a name
 *        with no explicit Namespace URI.
 * @param localName The local name.
 * @return The attribute's type, or null if there is no
 *         matching attribute.
 * @see org.xml.sax.Attributes#getType(java.lang.String,java.lang.String)
 * @apiSince 1
 */

public java.lang.String getType(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Look up an attribute's type by qualified (prefixed) name.
 *
 * @param qName The qualified name.
 * @return The attribute's type, or null if there is no
 *         matching attribute.
 * @see org.xml.sax.Attributes#getType(java.lang.String)
 * @apiSince 1
 */

public java.lang.String getType(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/**
 * Look up an attribute's value by Namespace-qualified name.
 *
 * @param uri The Namespace URI, or the empty string for a name
 *        with no explicit Namespace URI.
 * @param localName The local name.
 * @return The attribute's value, or null if there is no
 *         matching attribute.
 * @see org.xml.sax.Attributes#getValue(java.lang.String,java.lang.String)
 * @apiSince 1
 */

public java.lang.String getValue(java.lang.String uri, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Look up an attribute's value by qualified (prefixed) name.
 *
 * @param qName The qualified name.
 * @return The attribute's value, or null if there is no
 *         matching attribute.
 * @see org.xml.sax.Attributes#getValue(java.lang.String)
 * @apiSince 1
 */

public java.lang.String getValue(java.lang.String qName) { throw new RuntimeException("Stub!"); }

/**
 * Clear the attribute list for reuse.
 *
 * <p>Note that little memory is freed by this call:
 * the current array is kept so it can be
 * reused.</p>
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Copy an entire Attributes object.
 *
 * <p>It may be more efficient to reuse an existing object
 * rather than constantly allocating new ones.</p>
 *
 * @param atts The attributes to copy.
 * @apiSince 1
 */

public void setAttributes(org.xml.sax.Attributes atts) { throw new RuntimeException("Stub!"); }

/**
 * Add an attribute to the end of the list.
 *
 * <p>For the sake of speed, this method does no checking
 * to see if the attribute is already in the list: that is
 * the responsibility of the application.</p>
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
 * @apiSince 1
 */

public void addAttribute(java.lang.String uri, java.lang.String localName, java.lang.String qName, java.lang.String type, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Set an attribute in the list.
 *
 * <p>For the sake of speed, this method does no checking
 * for name conflicts or well-formedness: such checks are the
 * responsibility of the application.</p>
 *
 * @param index The index of the attribute (zero-based).
 * @param uri The Namespace URI, or the empty string if
 *        none is available or Namespace processing is not
 *        being performed.
 * @param localName The local name, or the empty string if
 *        Namespace processing is not being performed.
 * @param qName The qualified name, or the empty string
 *        if qualified names are not available.
 * @param type The attribute type as a string.
 * @param value The attribute value.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not point to an attribute
 *            in the list.
 * @apiSince 1
 */

public void setAttribute(int index, java.lang.String uri, java.lang.String localName, java.lang.String qName, java.lang.String type, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Remove an attribute from the list.
 *
 * @param index The index of the attribute (zero-based).
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not point to an attribute
 *            in the list.
 * @apiSince 1
 */

public void removeAttribute(int index) { throw new RuntimeException("Stub!"); }

/**
 * Set the Namespace URI of a specific attribute.
 *
 * @param index The index of the attribute (zero-based).
 * @param uri The attribute's Namespace URI, or the empty
 *        string for none.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not point to an attribute
 *            in the list.
 * @apiSince 1
 */

public void setURI(int index, java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Set the local name of a specific attribute.
 *
 * @param index The index of the attribute (zero-based).
 * @param localName The attribute's local name, or the empty
 *        string for none.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not point to an attribute
 *            in the list.
 * @apiSince 1
 */

public void setLocalName(int index, java.lang.String localName) { throw new RuntimeException("Stub!"); }

/**
 * Set the qualified name of a specific attribute.
 *
 * @param index The index of the attribute (zero-based).
 * @param qName The attribute's qualified name, or the empty
 *        string for none.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not point to an attribute
 *            in the list.
 * @apiSince 1
 */

public void setQName(int index, java.lang.String qName) { throw new RuntimeException("Stub!"); }

/**
 * Set the type of a specific attribute.
 *
 * @param index The index of the attribute (zero-based).
 * @param type The attribute's type.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not point to an attribute
 *            in the list.
 * @apiSince 1
 */

public void setType(int index, java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Set the value of a specific attribute.
 *
 * @param index The index of the attribute (zero-based).
 * @param value The attribute's value.
 * @exception java.lang.ArrayIndexOutOfBoundsException When the
 *            supplied index does not point to an attribute
 *            in the list.
 * @apiSince 1
 */

public void setValue(int index, java.lang.String value) { throw new RuntimeException("Stub!"); }
}

