/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.util.jar;

import java.util.Map;
import java.util.Set;
import java.util.Collection;

/**
 * The Attributes class maps Manifest attribute names to associated string
 * values. Valid attribute names are case-insensitive, are restricted to
 * the ASCII characters in the set [0-9a-zA-Z_-], and cannot exceed 70
 * characters in length. Attribute values can contain any characters and
 * will be UTF8-encoded when written to the output stream.  See the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html">JAR File Specification</a>
 * for more information about valid attribute names and values.
 *
 * @author  David Connelly
 * @see     java.util.jar.Manifest
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Attributes implements java.util.Map<java.lang.Object,java.lang.Object>, java.lang.Cloneable {

/**
 * Constructs a new, empty Attributes object with default size.
 * @apiSince 1
 */

public Attributes() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty Attributes object with the specified
 * initial size.
 *
 * @param size the initial number of attributes
 * @apiSince 1
 */

public Attributes(int size) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new Attributes object with the same attribute name-value
 * mappings as in the specified Attributes.
 *
 * @param attr the specified Attributes
 * @apiSince 1
 */

public Attributes(java.util.jar.Attributes attr) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified attribute name, or null if the
 * attribute name was not found.
 *
 * @param name the attribute name
 * @return the value of the specified attribute name, or null if
 *         not found.
 * @apiSince 1
 */

public java.lang.Object get(java.lang.Object name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified attribute name, specified as
 * a string, or null if the attribute was not found. The attribute
 * name is case-insensitive.
 * <p>
 * This method is defined as:
 * <pre>
 *      return (String)get(new Attributes.Name((String)name));
 * </pre>
 *
 * @param name the attribute name as a string
 * @return the String value of the specified attribute name, or null if
 *         not found.
 * @throws java.lang.IllegalArgumentException if the attribute name is invalid
 * @apiSince 1
 */

public java.lang.String getValue(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified Attributes.Name, or null if the
 * attribute was not found.
 * <p>
 * This method is defined as:
 * <pre>
 *     return (String)get(name);
 * </pre>
 *
 * @param name the Attributes.Name object
 * @return the String value of the specified Attribute.Name, or null if
 *         not found.
 * @apiSince 1
 */

public java.lang.String getValue(java.util.jar.Attributes.Name name) { throw new RuntimeException("Stub!"); }

/**
 * Associates the specified value with the specified attribute name
 * (key) in this Map. If the Map previously contained a mapping for
 * the attribute name, the old value is replaced.
 *
 * @param name the attribute name
 * @param value the attribute value
 * @return the previous value of the attribute, or null if none
 * @exception java.lang.ClassCastException if the name is not a Attributes.Name
 *            or the value is not a String
 * @apiSince 1
 */

public java.lang.Object put(java.lang.Object name, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Associates the specified value with the specified attribute name,
 * specified as a String. The attributes name is case-insensitive.
 * If the Map previously contained a mapping for the attribute name,
 * the old value is replaced.
 * <p>
 * This method is defined as:
 * <pre>
 *      return (String)put(new Attributes.Name(name), value);
 * </pre>
 *
 * @param name the attribute name as a string
 * @param value the attribute value
 * @return the previous value of the attribute, or null if none
 * @exception java.lang.IllegalArgumentException if the attribute name is invalid
 * @apiSince 1
 */

public java.lang.String putValue(java.lang.String name, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Removes the attribute with the specified name (key) from this Map.
 * Returns the previous attribute value, or null if none.
 *
 * @param name attribute name
 * @return the previous value of the attribute, or null if none
 * @apiSince 1
 */

public java.lang.Object remove(java.lang.Object name) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this Map maps one or more attribute names (keys)
 * to the specified value.
 *
 * @param value the attribute value
 * @return true if this Map maps one or more attribute names to
 *         the specified value
 * @apiSince 1
 */

public boolean containsValue(java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this Map contains the specified attribute name (key).
 *
 * @param name the attribute name
 * @return true if this Map contains the specified attribute name
 * @apiSince 1
 */

public boolean containsKey(java.lang.Object name) { throw new RuntimeException("Stub!"); }

/**
 * Copies all of the attribute name-value mappings from the specified
 * Attributes to this Map. Duplicate mappings will be replaced.
 *
 * @param attr the Attributes to be stored in this map
 * @exception java.lang.ClassCastException if attr is not an Attributes
 * @apiSince 1
 */

public void putAll(java.util.Map<?,?> attr) { throw new RuntimeException("Stub!"); }

/**
 * Removes all attributes from this Map.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of attributes in this Map.
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this Map contains no attributes.
 * @apiSince 1
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Set view of the attribute names (keys) contained in this Map.
 * @apiSince 1
 */

public java.util.Set<java.lang.Object> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Collection view of the attribute values contained in this Map.
 * @apiSince 1
 */

public java.util.Collection<java.lang.Object> values() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Collection view of the attribute name-value mappings
 * contained in this Map.
 * @apiSince 1
 */

public java.util.Set<java.util.Map.Entry<java.lang.Object,java.lang.Object>> entrySet() { throw new RuntimeException("Stub!"); }

/**
 * Compares the specified Attributes object with this Map for equality.
 * Returns true if the given object is also an instance of Attributes
 * and the two Attributes objects represent the same mappings.
 *
 * @param o the Object to be compared
 * @return true if the specified Object is equal to this Map
 * @apiSince 1
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this Map.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the Attributes, implemented as follows:
 * <pre>
 *     public Object clone() { return new Attributes(this); }
 * </pre>
 * Since the attribute names and values are themselves immutable,
 * the Attributes returned can be safely modified without affecting
 * the original.
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * The attribute name-value mappings.
 * @apiSince 1
 */

protected java.util.Map<java.lang.Object,java.lang.Object> map;
/**
 * The Attributes.Name class represents an attribute name stored in
 * this Map. Valid attribute names are case-insensitive, are restricted
 * to the ASCII characters in the set [0-9a-zA-Z_-], and cannot exceed
 * 70 characters in length. Attribute values can contain any characters
 * and will be UTF8-encoded when written to the output stream.  See the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html">JAR File Specification</a>
 * for more information about valid attribute names and values.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Name {

/**
 * Constructs a new attribute name using the given string name.
 *
 * @param name the attribute string name
 * @exception java.lang.IllegalArgumentException if the attribute name was
 *            invalid
 * @exception java.lang.NullPointerException if the attribute name was null
 * @apiSince 1
 */

public Name(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Compares this attribute name to another for equality.
 * @param o the object to compare
 * @return true if this attribute name is equal to the
 *         specified attribute object
 * @apiSince 1
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Computes the hash value for this attribute name.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the attribute name as a String.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * <code>Name</code> object for <code>Class-Path</code>
 * manifest attribute. Bundled extensions can use this attribute
 * to find other JAR files containing needed classes.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html#classpath">
 *      JAR file specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name CLASS_PATH;
static { CLASS_PATH = null; }

/**
 * <code>Name</code> object for <code>Content-Type</code>
 * manifest attribute.
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name CONTENT_TYPE;
static { CONTENT_TYPE = null; }

/**
 * <code>Name</code> object for <code>Extension-Name</code> manifest attribute
 * used for declaring dependencies on installed extensions.
 * @deprecated Extension mechanism will be removed in a future release.
 *             Use class path instead.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/extensions/spec.html#dependency">
 *      Installed extension dependency</a>
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final java.util.jar.Attributes.Name EXTENSION_INSTALLATION;
static { EXTENSION_INSTALLATION = null; }

/**
 * <code>Name</code> object for <code>Extension-List</code> manifest attribute
 * used for declaring dependencies on installed extensions.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/extensions/spec.html#dependency">
 *      Installed extension dependency</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name EXTENSION_LIST;
static { EXTENSION_LIST = null; }

/**
 * <code>Name</code> object for <code>Extension-Name</code> manifest attribute
 * used for declaring dependencies on installed extensions.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/extensions/spec.html#dependency">
 *      Installed extension dependency</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name EXTENSION_NAME;
static { EXTENSION_NAME = null; }

/**
 * <code>Name</code> object for <code>Implementation-Title</code>
 * manifest attribute used for package versioning.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/versioning/spec/versioning2.html#wp90779">
 *      Java Product Versioning Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name IMPLEMENTATION_TITLE;
static { IMPLEMENTATION_TITLE = null; }

/**
 * <code>Name</code> object for <code>Implementation-URL</code>
 * manifest attribute used for package versioning.
 * @deprecated Extension mechanism will be removed in a future release.
 *             Use class path instead.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/extensions/versioning.html#applet">
 *      Optional Package Versioning</a>
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final java.util.jar.Attributes.Name IMPLEMENTATION_URL;
static { IMPLEMENTATION_URL = null; }

/**
 * <code>Name</code> object for <code>Implementation-Vendor</code>
 * manifest attribute used for package versioning.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/versioning/spec/versioning2.html#wp90779">
 *      Java Product Versioning Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name IMPLEMENTATION_VENDOR;
static { IMPLEMENTATION_VENDOR = null; }

/**
 * <code>Name</code> object for <code>Implementation-Vendor-Id</code>
 * manifest attribute used for package versioning.
 * @deprecated Extension mechanism will be removed in a future release.
 *             Use class path instead.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/extensions/versioning.html#applet">
 *      Optional Package Versioning</a>
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public static final java.util.jar.Attributes.Name IMPLEMENTATION_VENDOR_ID;
static { IMPLEMENTATION_VENDOR_ID = null; }

/**
 * <code>Name</code> object for <code>Implementation-Version</code>
 * manifest attribute used for package versioning.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/versioning/spec/versioning2.html#wp90779">
 *      Java Product Versioning Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name IMPLEMENTATION_VERSION;
static { IMPLEMENTATION_VERSION = null; }

/**
 * <code>Name</code> object for <code>Main-Class</code> manifest
 * attribute used for launching applications packaged in JAR files.
 * The <code>Main-Class</code> attribute is used in conjunction
 * with the <code>-jar</code> command-line option of the
 * <tt>java</tt> application launcher.
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name MAIN_CLASS;
static { MAIN_CLASS = null; }

/**
 * <code>Name</code> object for <code>Manifest-Version</code>
 * manifest attribute. This attribute indicates the version number
 * of the manifest standard to which a JAR file's manifest conforms.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html#JAR_Manifest">
 *      Manifest and Signature Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name MANIFEST_VERSION;
static { MANIFEST_VERSION = null; }

/**
 * <code>Name</code> object for <code>Sealed</code> manifest attribute
 * used for sealing.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html#sealing">
 *      Package Sealing</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name SEALED;
static { SEALED = null; }

/**
 * <code>Name</code> object for <code>Signature-Version</code>
 * manifest attribute used when signing JAR files.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html#JAR_Manifest">
 *      Manifest and Signature Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name SIGNATURE_VERSION;
static { SIGNATURE_VERSION = null; }

/**
 * <code>Name</code> object for <code>Specification-Title</code>
 * manifest attribute used for package versioning.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/versioning/spec/versioning2.html#wp90779">
 *      Java Product Versioning Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name SPECIFICATION_TITLE;
static { SPECIFICATION_TITLE = null; }

/**
 * <code>Name</code> object for <code>Specification-Vendor</code>
 * manifest attribute used for package versioning.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/versioning/spec/versioning2.html#wp90779">
 *      Java Product Versioning Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name SPECIFICATION_VENDOR;
static { SPECIFICATION_VENDOR = null; }

/**
 * <code>Name</code> object for <code>Specification-Version</code>
 * manifest attribute used for package versioning.
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/versioning/spec/versioning2.html#wp90779">
 *      Java Product Versioning Specification</a>
 * @apiSince 1
 */

public static final java.util.jar.Attributes.Name SPECIFICATION_VERSION;
static { SPECIFICATION_VERSION = null; }
}

}

