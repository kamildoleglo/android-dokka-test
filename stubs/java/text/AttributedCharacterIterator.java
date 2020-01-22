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



package java.text;

import java.io.InvalidObjectException;

/**
 * An {@code AttributedCharacterIterator} allows iteration through both text and
 * related attribute information.
 *
 * <p>
 * An attribute is a key/value pair, identified by the key.  No two
 * attributes on a given character can have the same key.
 *
 * <p>The values for an attribute are immutable, or must not be mutated
 * by clients or storage.  They are always passed by reference, and not
 * cloned.
 *
 * <p>A <em>run with respect to an attribute</em> is a maximum text range for
 * which:
 * <ul>
 * <li>the attribute is undefined or {@code null} for the entire range, or
 * <li>the attribute value is defined and has the same non-{@code null} value for the
 *     entire range.
 * </ul>
 *
 * <p>A <em>run with respect to a set of attributes</em> is a maximum text range for
 * which this condition is met for each member attribute.
 *
 * <p>When getting a run with no explicit attributes specified (i.e.,
 * calling {@link #getRunStart()} and {@link #getRunLimit()}), any
 * contiguous text segments having the same attributes (the same set
 * of attribute/value pairs) are treated as separate runs if the
 * attributes have been given to those text segments separately.
 *
 * <p>The returned indexes are limited to the range of the iterator.
 *
 * <p>The returned attribute information is limited to runs that contain
 * the current character.
 *
 * <p>
 * Attribute keys are instances of {@link java.text.AttributedCharacterIterator.Attribute AttributedCharacterIterator.Attribute} and its
 * subclasses, such as {@link java.awt.font.TextAttribute}.
 *
 * @see java.text.AttributedCharacterIterator.Attribute
 * @see java.awt.font.TextAttribute
 * @see java.text.AttributedString
 * @see java.text.Annotation
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface AttributedCharacterIterator extends java.text.CharacterIterator {

/**
 * Returns the index of the first character of the run
 * with respect to all attributes containing the current character.
 *
 * <p>Any contiguous text segments having the same attributes (the
 * same set of attribute/value pairs) are treated as separate runs
 * if the attributes have been given to those text segments separately.
 *
 * @return the index of the first character of the run
 * @apiSince 1
 */

public int getRunStart();

/**
 * Returns the index of the first character of the run
 * with respect to the given {@code attribute} containing the current character.
 *
 * @param attribute the desired attribute.
 * @return the index of the first character of the run
 * @apiSince 1
 */

public int getRunStart(java.text.AttributedCharacterIterator.Attribute attribute);

/**
 * Returns the index of the first character of the run
 * with respect to the given {@code attributes} containing the current character.
 *
 * @param attributes a set of the desired attributes.
 * @return the index of the first character of the run
 * @apiSince 1
 */

public int getRunStart(java.util.Set<? extends java.text.AttributedCharacterIterator.Attribute> attributes);

/**
 * Returns the index of the first character following the run
 * with respect to all attributes containing the current character.
 *
 * <p>Any contiguous text segments having the same attributes (the
 * same set of attribute/value pairs) are treated as separate runs
 * if the attributes have been given to those text segments separately.
 *
 * @return the index of the first character following the run
 * @apiSince 1
 */

public int getRunLimit();

/**
 * Returns the index of the first character following the run
 * with respect to the given {@code attribute} containing the current character.
 *
 * @param attribute the desired attribute
 * @return the index of the first character following the run
 * @apiSince 1
 */

public int getRunLimit(java.text.AttributedCharacterIterator.Attribute attribute);

/**
 * Returns the index of the first character following the run
 * with respect to the given {@code attributes} containing the current character.
 *
 * @param attributes a set of the desired attributes
 * @return the index of the first character following the run
 * @apiSince 1
 */

public int getRunLimit(java.util.Set<? extends java.text.AttributedCharacterIterator.Attribute> attributes);

/**
 * Returns a map with the attributes defined on the current
 * character.
 *
 * @return a map with the attributes defined on the current character
 * @apiSince 1
 */

public java.util.Map<java.text.AttributedCharacterIterator.Attribute,java.lang.Object> getAttributes();

/**
 * Returns the value of the named {@code attribute} for the current character.
 * Returns {@code null} if the {@code attribute} is not defined.
 *
 * @param attribute the desired attribute
 * @return the value of the named {@code attribute} or {@code null}
 * @apiSince 1
 */

public java.lang.Object getAttribute(java.text.AttributedCharacterIterator.Attribute attribute);

/**
 * Returns the keys of all attributes defined on the
 * iterator's text range. The set is empty if no
 * attributes are defined.
 *
 * @return the keys of all attributes
 * @apiSince 1
 */

public java.util.Set<java.text.AttributedCharacterIterator.Attribute> getAllAttributeKeys();
/**
 * Defines attribute keys that are used to identify text attributes. These
 * keys are used in {@code AttributedCharacterIterator} and {@code AttributedString}.
 * @see java.text.AttributedCharacterIterator
 * @see java.text.AttributedString
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Attribute implements java.io.Serializable {

/**
 * Constructs an {@code Attribute} with the given name.
 *
 * @param name the name of {@code Attribute}
 * @apiSince 1
 */

protected Attribute(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Compares two objects for equality. This version only returns true
 * for {@code x.equals(y)} if {@code x} and {@code y} refer
 * to the same object, and guarantees this for all subclasses.
 * @apiSince 1
 */

public final boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for the object. This version is identical to
 * the one in {@code Object}, but is also final.
 * @apiSince 1
 */

public final int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the object. This version returns the
 * concatenation of class name, {@code "("}, a name identifying the attribute
 * and {@code ")"}.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the attribute.
 *
 * @return the name of {@code Attribute}
 * @apiSince 1
 */

protected java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Resolves instances being deserialized to the predefined constants.
 *
 * @return the resolved {@code Attribute} object
 * @throws java.io.InvalidObjectException if the object to resolve is not
 *                                an instance of {@code Attribute}
 * @apiSince 1
 */

protected java.lang.Object readResolve() throws java.io.InvalidObjectException { throw new RuntimeException("Stub!"); }

/**
 * Attribute key for input method segments. Input methods often break
 * up text into segments, which usually correspond to words.
 * <p>Values are instances of {@link java.text.Annotation Annotation} holding a {@code null} reference.
 * @see java.text.Annotation
 * @apiSince 1
 */

public static final java.text.AttributedCharacterIterator.Attribute INPUT_METHOD_SEGMENT;
static { INPUT_METHOD_SEGMENT = null; }

/**
 * Attribute key for the language of some text.
 * <p> Values are instances of {@link java.util.Locale Locale}.
 * @see java.util.Locale
 * @apiSince 1
 */

public static final java.text.AttributedCharacterIterator.Attribute LANGUAGE;
static { LANGUAGE = null; }

/**
 * Attribute key for the reading of some text. In languages where the written form
 * and the pronunciation of a word are only loosely related (such as Japanese),
 * it is often necessary to store the reading (pronunciation) along with the
 * written form.
 * <p>Values are instances of {@link java.text.Annotation Annotation} holding instances of {@link java.lang.String String}.
 *
 * @see java.text.Annotation
 * @see java.lang.String
 * @apiSince 1
 */

public static final java.text.AttributedCharacterIterator.Attribute READING;
static { READING = null; }
}

}

