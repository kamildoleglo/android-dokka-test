/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;

/**
 * An AttributedString holds text and related attribute information. It
 * may be used as the actual data storage in some cases where a text
 * reader wants to access attributed text through the AttributedCharacterIterator
 * interface.
 *
 * <p>
 * An attribute is a key/value pair, identified by the key.  No two
 * attributes on a given character can have the same key.
 *
 * <p>The values for an attribute are immutable, or must not be mutated
 * by clients or storage.  They are always passed by reference, and not
 * cloned.
 *
 * @see java.text.AttributedCharacterIterator
 * @see java.text.Annotation
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AttributedString {

/**
 * Constructs an AttributedString instance with the given text.
 * @param text The text for this attributed string.
 * @exception java.lang.NullPointerException if <code>text</code> is null.
 * @apiSince 1
 */

public AttributedString(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an AttributedString instance with the given text and attributes.
 * @param text The text for this attributed string.
 * @param attributes The attributes that apply to the entire string.
 * @exception java.lang.NullPointerException if <code>text</code> or
 *            <code>attributes</code> is null.
 * @exception java.lang.IllegalArgumentException if the text has length 0
 * and the attributes parameter is not an empty Map (attributes
 * cannot be applied to a 0-length range).
 * @apiSince 1
 */

public AttributedString(java.lang.String text, java.util.Map<? extends java.text.AttributedCharacterIterator.Attribute,?> attributes) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an AttributedString instance with the given attributed
 * text represented by AttributedCharacterIterator.
 * @param text The text for this attributed string.
 * @exception java.lang.NullPointerException if <code>text</code> is null.
 * @apiSince 1
 */

public AttributedString(java.text.AttributedCharacterIterator text) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an AttributedString instance with the subrange of
 * the given attributed text represented by
 * AttributedCharacterIterator. If the given range produces an
 * empty text, all attributes will be discarded.  Note that any
 * attributes wrapped by an Annotation object are discarded for a
 * subrange of the original attribute range.
 *
 * @param text The text for this attributed string.
 * @param beginIndex Index of the first character of the range.
 * @param endIndex Index of the character following the last character
 * of the range.
 * @exception java.lang.NullPointerException if <code>text</code> is null.
 * @exception java.lang.IllegalArgumentException if the subrange given by
 * beginIndex and endIndex is out of the text range.
 * @see java.text.Annotation
 * @apiSince 1
 */

public AttributedString(java.text.AttributedCharacterIterator text, int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an AttributedString instance with the subrange of
 * the given attributed text represented by
 * AttributedCharacterIterator.  Only attributes that match the
 * given attributes will be incorporated into the instance. If the
 * given range produces an empty text, all attributes will be
 * discarded. Note that any attributes wrapped by an Annotation
 * object are discarded for a subrange of the original attribute
 * range.
 *
 * @param text The text for this attributed string.
 * @param beginIndex Index of the first character of the range.
 * @param endIndex Index of the character following the last character
 * of the range.
 * @param attributes Specifies attributes to be extracted
 * from the text. If null is specified, all available attributes will
 * be used.
 * @exception java.lang.NullPointerException if <code>text</code> is null.
 * @exception java.lang.IllegalArgumentException if the subrange given by
 * beginIndex and endIndex is out of the text range.
 * @see java.text.Annotation
 * @apiSince 1
 */

public AttributedString(java.text.AttributedCharacterIterator text, int beginIndex, int endIndex, java.text.AttributedCharacterIterator.Attribute[] attributes) { throw new RuntimeException("Stub!"); }

/**
 * Adds an attribute to the entire string.
 * @param attribute the attribute key
 * @param value the value of the attribute; may be null
 * @exception java.lang.NullPointerException if <code>attribute</code> is null.
 * @exception java.lang.IllegalArgumentException if the AttributedString has length 0
 * (attributes cannot be applied to a 0-length range).
 * @apiSince 1
 */

public void addAttribute(java.text.AttributedCharacterIterator.Attribute attribute, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Adds an attribute to a subrange of the string.
 * @param attribute the attribute key
 * @param value The value of the attribute. May be null.
 * @param beginIndex Index of the first character of the range.
 * @param endIndex Index of the character following the last character of the range.
 * @exception java.lang.NullPointerException if <code>attribute</code> is null.
 * @exception java.lang.IllegalArgumentException if beginIndex is less then 0, endIndex is
 * greater than the length of the string, or beginIndex and endIndex together don't
 * define a non-empty subrange of the string.
 * @apiSince 1
 */

public void addAttribute(java.text.AttributedCharacterIterator.Attribute attribute, java.lang.Object value, int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Adds a set of attributes to a subrange of the string.
 * @param attributes The attributes to be added to the string.
 * @param beginIndex Index of the first character of the range.
 * @param endIndex Index of the character following the last
 * character of the range.
 * @exception java.lang.NullPointerException if <code>attributes</code> is null.
 * @exception java.lang.IllegalArgumentException if beginIndex is less then
 * 0, endIndex is greater than the length of the string, or
 * beginIndex and endIndex together don't define a non-empty
 * subrange of the string and the attributes parameter is not an
 * empty Map.
 * @apiSince 1
 */

public void addAttributes(java.util.Map<? extends java.text.AttributedCharacterIterator.Attribute,?> attributes, int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Creates an AttributedCharacterIterator instance that provides access to the entire contents of
 * this string.
 *
 * @return An iterator providing access to the text and its attributes.
 * @apiSince 1
 */

public java.text.AttributedCharacterIterator getIterator() { throw new RuntimeException("Stub!"); }

/**
 * Creates an AttributedCharacterIterator instance that provides access to
 * selected contents of this string.
 * Information about attributes not listed in attributes that the
 * implementor may have need not be made accessible through the iterator.
 * If the list is null, all available attribute information should be made
 * accessible.
 *
 * @param attributes a list of attributes that the client is interested in
 * @return an iterator providing access to the entire text and its selected attributes
 * @apiSince 1
 */

public java.text.AttributedCharacterIterator getIterator(java.text.AttributedCharacterIterator.Attribute[] attributes) { throw new RuntimeException("Stub!"); }

/**
 * Creates an AttributedCharacterIterator instance that provides access to
 * selected contents of this string.
 * Information about attributes not listed in attributes that the
 * implementor may have need not be made accessible through the iterator.
 * If the list is null, all available attribute information should be made
 * accessible.
 *
 * @param attributes a list of attributes that the client is interested in
 * @param beginIndex the index of the first character
 * @param endIndex the index of the character following the last character
 * @return an iterator providing access to the text and its attributes
 * @exception java.lang.IllegalArgumentException if beginIndex is less then 0,
 * endIndex is greater than the length of the string, or beginIndex is
 * greater than endIndex.
 * @apiSince 1
 */

public java.text.AttributedCharacterIterator getIterator(java.text.AttributedCharacterIterator.Attribute[] attributes, int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }
}

