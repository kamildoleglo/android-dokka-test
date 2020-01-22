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

import java.io.IOException;
import java.util.Map;
import java.io.OutputStream;
import java.io.InputStream;

/**
 * The Manifest class is used to maintain Manifest entry names and their
 * associated Attributes. There are main Manifest Attributes as well as
 * per-entry Attributes. For information on the Manifest format, please
 * see the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jar.html">
 * Manifest format specification</a>.
 *
 * @author  David Connelly
 * @see     java.util.jar.Attributes
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Manifest implements java.lang.Cloneable {

/**
 * Constructs a new, empty Manifest.
 * @apiSince 1
 */

public Manifest() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new Manifest from the specified input stream.
 *
 * @param is the input stream containing manifest data
 * @throws java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public Manifest(java.io.InputStream is) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new Manifest that is a copy of the specified Manifest.
 *
 * @param man the Manifest to copy
 * @apiSince 1
 */

public Manifest(java.util.jar.Manifest man) { throw new RuntimeException("Stub!"); }

/**
 * Returns the main Attributes for the Manifest.
 * @return the main Attributes for the Manifest
 * @apiSince 1
 */

public java.util.jar.Attributes getMainAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Map of the entries contained in this Manifest. Each entry
 * is represented by a String name (key) and associated Attributes (value).
 * The Map permits the {@code null} key, but no entry with a null key is
 * created by {@link #read}, nor is such an entry written by using {@link
 * #write}.
 *
 * @return a Map of the entries contained in this Manifest
 * @apiSince 1
 */

public java.util.Map<java.lang.String,java.util.jar.Attributes> getEntries() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Attributes for the specified entry name.
 * This method is defined as:
 * <pre>
 *      return (Attributes)getEntries().get(name)
 * </pre>
 * Though {@code null} is a valid {@code name}, when
 * {@code getAttributes(null)} is invoked on a {@code Manifest}
 * obtained from a jar file, {@code null} will be returned.  While jar
 * files themselves do not allow {@code null}-named attributes, it is
 * possible to invoke {@link #getEntries} on a {@code Manifest}, and
 * on that result, invoke {@code put} with a null key and an
 * arbitrary value.  Subsequent invocations of
 * {@code getAttributes(null)} will return the just-{@code put}
 * value.
 * <p>
 * Note that this method does not return the manifest's main attributes;
 * see {@link #getMainAttributes}.
 *
 * @param name entry name
 * @return the Attributes for the specified entry name
 * @apiSince 1
 */

public java.util.jar.Attributes getAttributes(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Clears the main Attributes as well as the entries in this Manifest.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Writes the Manifest to the specified OutputStream.
 * Attributes.Name.MANIFEST_VERSION must be set in
 * MainAttributes prior to invoking this method.
 *
 * @param out the output stream
 * @exception java.io.IOException if an I/O error has occurred
 * @see #getMainAttributes
 * @apiSince 1
 */

public void write(java.io.OutputStream out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads the Manifest from the specified InputStream. The entry
 * names and attributes read will be merged in with the current
 * manifest entries.
 *
 * @param is the input stream
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void read(java.io.InputStream is) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified Object is also a Manifest and has
 * the same main Attributes and entries.
 *
 * @param o the object to be compared
 * @return true if the specified Object is also a Manifest and has
 * the same main Attributes and entries
 * @apiSince 1
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code for this Manifest.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this Manifest.  The shallow copy is
 * implemented as follows:
 * <pre>
 *     public Object clone() { return new Manifest(this); }
 * </pre>
 * @return a shallow copy of this Manifest
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }
}

