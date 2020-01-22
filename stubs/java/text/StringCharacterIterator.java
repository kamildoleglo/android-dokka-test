/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

/*
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1998 - All Rights Reserved
 *
 * The original version of this source code and documentation
 * is copyrighted and owned by Taligent, Inc., a wholly-owned
 * subsidiary of IBM. These materials are provided under terms
 * of a License Agreement between Taligent and Sun. This technology
 * is protected by multiple US and International patents.
 *
 * This notice and attribution to Taligent may not be removed.
 * Taligent is a registered trademark of Taligent, Inc.
 *
 */



package java.text;


/**
 * <code>StringCharacterIterator</code> implements the
 * <code>CharacterIterator</code> protocol for a <code>String</code>.
 * The <code>StringCharacterIterator</code> class iterates over the
 * entire <code>String</code>.
 *
 * @see java.text.CharacterIterator
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StringCharacterIterator implements java.text.CharacterIterator {

/**
 * Constructs an iterator with an initial index of 0.
 *
 * @param text the {@code String} to be iterated over
 * @apiSince 1
 */

public StringCharacterIterator(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an iterator with the specified initial index.
 *
 * @param  text   The String to be iterated over
 * @param  pos    Initial iterator position
 * @apiSince 1
 */

public StringCharacterIterator(java.lang.String text, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an iterator over the given range of the given string, with the
 * index set at the specified position.
 *
 * @param  text   The String to be iterated over
 * @param  begin  Index of the first character
 * @param  end    Index of the character following the last character
 * @param  pos    Initial iterator position
 * @apiSince 1
 */

public StringCharacterIterator(java.lang.String text, int begin, int end, int pos) { throw new RuntimeException("Stub!"); }

/**
 * Reset this iterator to point to a new string.  This package-visible
 * method is used by other java.text classes that want to avoid allocating
 * new StringCharacterIterator objects every time their setText method
 * is called.
 *
 * @param  text   The String to be iterated over
 * @since 1.2
 * @apiSince 1
 */

public void setText(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.first() for String.
 * @see java.text.CharacterIterator#first
 * @apiSince 1
 */

public char first() { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.last() for String.
 * @see java.text.CharacterIterator#last
 * @apiSince 1
 */

public char last() { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.setIndex() for String.
 * @see java.text.CharacterIterator#setIndex
 * @apiSince 1
 */

public char setIndex(int p) { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.current() for String.
 * @see java.text.CharacterIterator#current
 * @apiSince 1
 */

public char current() { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.next() for String.
 * @see java.text.CharacterIterator#next
 * @apiSince 1
 */

public char next() { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.previous() for String.
 * @see java.text.CharacterIterator#previous
 * @apiSince 1
 */

public char previous() { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.getBeginIndex() for String.
 * @see java.text.CharacterIterator#getBeginIndex
 * @apiSince 1
 */

public int getBeginIndex() { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.getEndIndex() for String.
 * @see java.text.CharacterIterator#getEndIndex
 * @apiSince 1
 */

public int getEndIndex() { throw new RuntimeException("Stub!"); }

/**
 * Implements CharacterIterator.getIndex() for String.
 * @see java.text.CharacterIterator#getIndex
 * @apiSince 1
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Compares the equality of two StringCharacterIterator objects.
 * @param obj the StringCharacterIterator object to be compared with.
 * @return true if the given obj is the same as this
 * StringCharacterIterator object; false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Computes a hashcode for this iterator.
 * @return A hash code
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Creates a copy of this iterator.
 * @return A copy of this
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }
}

