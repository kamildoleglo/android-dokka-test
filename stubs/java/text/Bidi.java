/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * (C) Copyright IBM Corp. 1999-2003 - All Rights Reserved
 *
 * The original version of this source code and documentation is
 * copyrighted and owned by IBM. These materials are provided
 * under terms of a License Agreement between IBM and Sun.
 * This technology is protected by multiple US and International
 * patents. This notice and attribution to IBM may not be removed.
 */



package java.text;


/**
 * This class implements the Unicode Bidirectional Algorithm.
 * <p>
 * A Bidi object provides information on the bidirectional reordering of the text
 * used to create it.  This is required, for example, to properly display Arabic
 * or Hebrew text.  These languages are inherently mixed directional, as they order
 * numbers from left-to-right while ordering most other text from right-to-left.
 * <p>
 * Once created, a Bidi object can be queried to see if the text it represents is
 * all left-to-right or all right-to-left.  Such objects are very lightweight and
 * this text is relatively easy to process.
 * <p>
 * If there are multiple runs of text, information about the runs can be accessed
 * by indexing to get the start, limit, and level of a run.  The level represents
 * both the direction and the 'nesting level' of a directional run.  Odd levels
 * are right-to-left, while even levels are left-to-right.  So for example level
 * 0 represents left-to-right text, while level 1 represents right-to-left text, and
 * level 2 represents left-to-right text embedded in a right-to-left run.
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Bidi {

/**
 * Create Bidi from the given paragraph of text and base direction.
 * @param paragraph a paragraph of text
 * @param flags a collection of flags that control the algorithm.  The
 * algorithm understands the flags DIRECTION_LEFT_TO_RIGHT, DIRECTION_RIGHT_TO_LEFT,
 * DIRECTION_DEFAULT_LEFT_TO_RIGHT, and DIRECTION_DEFAULT_RIGHT_TO_LEFT.
 * Other values are reserved.
 * @apiSince 1
 */

public Bidi(java.lang.String paragraph, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create Bidi from the given paragraph of text.
 * <p>
 * The RUN_DIRECTION attribute in the text, if present, determines the base
 * direction (left-to-right or right-to-left).  If not present, the base
 * direction is computes using the Unicode Bidirectional Algorithm, defaulting to left-to-right
 * if there are no strong directional characters in the text.  This attribute, if
 * present, must be applied to all the text in the paragraph.
 * <p>
 * The BIDI_EMBEDDING attribute in the text, if present, represents embedding level
 * information.  Negative values from -1 to -62 indicate overrides at the absolute value
 * of the level.  Positive values from 1 to 62 indicate embeddings.  Where values are
 * zero or not defined, the base embedding level as determined by the base direction
 * is assumed.
 * <p>
 * The NUMERIC_SHAPING attribute in the text, if present, converts European digits to
 * other decimal digits before running the bidi algorithm.  This attribute, if present,
 * must be applied to all the text in the paragraph.
 *
 * @param paragraph a paragraph of text with optional character and paragraph attribute information
 *
 * @see java.awt.font.TextAttribute#BIDI_EMBEDDING
 * @see java.awt.font.TextAttribute#NUMERIC_SHAPING
 * @see java.awt.font.TextAttribute#RUN_DIRECTION
 * @apiSince 1
 */

public Bidi(java.text.AttributedCharacterIterator paragraph) { throw new RuntimeException("Stub!"); }

/**
 * Create Bidi from the given text, embedding, and direction information.
 * The embeddings array may be null.  If present, the values represent embedding level
 * information.  Negative values from -1 to -61 indicate overrides at the absolute value
 * of the level.  Positive values from 1 to 61 indicate embeddings.  Where values are
 * zero, the base embedding level as determined by the base direction is assumed.
 * @param text an array containing the paragraph of text to process.
 * @param textStart the index into the text array of the start of the paragraph.
 * @param embeddings an array containing embedding values for each character in the paragraph.
 * This can be null, in which case it is assumed that there is no external embedding information.
 * @param embStart the index into the embedding array of the start of the paragraph.
 * @param paragraphLength the length of the paragraph in the text and embeddings arrays.
 * @param flags a collection of flags that control the algorithm.  The
 * algorithm understands the flags DIRECTION_LEFT_TO_RIGHT, DIRECTION_RIGHT_TO_LEFT,
 * DIRECTION_DEFAULT_LEFT_TO_RIGHT, and DIRECTION_DEFAULT_RIGHT_TO_LEFT.
 * Other values are reserved.
 * @apiSince 1
 */

public Bidi(char[] text, int textStart, byte[] embeddings, int embStart, int paragraphLength, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a Bidi object representing the bidi information on a line of text within
 * the paragraph represented by the current Bidi.  This call is not required if the
 * entire paragraph fits on one line.
 *
 * @param lineStart the offset from the start of the paragraph to the start of the line.
 * @param lineLimit the offset from the start of the paragraph to the limit of the line.
 * @return a {@code Bidi} object
 * @apiSince 1
 */

public java.text.Bidi createLineBidi(int lineStart, int lineLimit) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the line is not left-to-right or right-to-left.  This means it either has mixed runs of left-to-right
 * and right-to-left text, or the base direction differs from the direction of the only run of text.
 *
 * @return true if the line is not left-to-right or right-to-left.
 * @apiSince 1
 */

public boolean isMixed() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the line is all left-to-right text and the base direction is left-to-right.
 *
 * @return true if the line is all left-to-right text and the base direction is left-to-right
 * @apiSince 1
 */

public boolean isLeftToRight() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the line is all right-to-left text, and the base direction is right-to-left.
 * @return true if the line is all right-to-left text, and the base direction is right-to-left
 * @apiSince 1
 */

public boolean isRightToLeft() { throw new RuntimeException("Stub!"); }

/**
 * Return the length of text in the line.
 * @return the length of text in the line
 * @apiSince 1
 */

public int getLength() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the base direction is left-to-right.
 * @return true if the base direction is left-to-right
 * @apiSince 1
 */

public boolean baseIsLeftToRight() { throw new RuntimeException("Stub!"); }

/**
 * Return the base level (0 if left-to-right, 1 if right-to-left).
 * @return the base level
 * @apiSince 1
 */

public int getBaseLevel() { throw new RuntimeException("Stub!"); }

/**
 * Return the resolved level of the character at offset.  If offset is
 * {@literal <} 0 or &ge; the length of the line, return the base direction
 * level.
 *
 * @param offset the index of the character for which to return the level
 * @return the resolved level of the character at offset
 * @apiSince 1
 */

public int getLevelAt(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of level runs.
 * @return the number of level runs
 * @apiSince 1
 */

public int getRunCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the level of the nth logical run in this line.
 * @param run the index of the run, between 0 and <code>getRunCount()</code>
 * @return the level of the run
 * @apiSince 1
 */

public int getRunLevel(int run) { throw new RuntimeException("Stub!"); }

/**
 * Return the index of the character at the start of the nth logical run in this line, as
 * an offset from the start of the line.
 * @param run the index of the run, between 0 and <code>getRunCount()</code>
 * @return the start of the run
 * @apiSince 1
 */

public int getRunStart(int run) { throw new RuntimeException("Stub!"); }

/**
 * Return the index of the character past the end of the nth logical run in this line, as
 * an offset from the start of the line.  For example, this will return the length
 * of the line for the last run on the line.
 * @param run the index of the run, between 0 and <code>getRunCount()</code>
 * @return limit the limit of the run
 * @apiSince 1
 */

public int getRunLimit(int run) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the specified text requires bidi analysis.  If this returns false,
 * the text will display left-to-right.  Clients can then avoid constructing a Bidi object.
 * Text in the Arabic Presentation Forms area of Unicode is presumed to already be shaped
 * and ordered for display, and so will not cause this function to return true.
 *
 * @param text the text containing the characters to test
 * @param start the start of the range of characters to test
 * @param limit the limit of the range of characters to test
 * @return true if the range of characters requires bidi analysis
 * @apiSince 1
 */

public static boolean requiresBidi(char[] text, int start, int limit) { throw new RuntimeException("Stub!"); }

/**
 * Reorder the objects in the array into visual order based on their levels.
 * This is a utility function to use when you have a collection of objects
 * representing runs of text in logical order, each run containing text
 * at a single level.  The elements at <code>index</code> from
 * <code>objectStart</code> up to <code>objectStart + count</code>
 * in the objects array will be reordered into visual order assuming
 * each run of text has the level indicated by the corresponding element
 * in the levels array (at <code>index - objectStart + levelStart</code>).
 *
 * @param levels an array representing the bidi level of each object
 * @param levelStart the start position in the levels array
 * @param objects the array of objects to be reordered into visual order
 * @param objectStart the start position in the objects array
 * @param count the number of objects to reorder
 * @apiSince 1
 */

public static void reorderVisually(byte[] levels, int levelStart, java.lang.Object[] objects, int objectStart, int count) { throw new RuntimeException("Stub!"); }

/**
 * Display the bidi internal state, used in debugging.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Constant indicating that the base direction depends on the first strong
 * directional character in the text according to the Unicode
 * Bidirectional Algorithm.  If no strong directional character is present,
 * the base direction is left-to-right.
 * @apiSince 1
 */

public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = -2; // 0xfffffffe

/**
 * Constant indicating that the base direction depends on the first strong
 * directional character in the text according to the Unicode
 * Bidirectional Algorithm.  If no strong directional character is present,
 * the base direction is right-to-left.
 * @apiSince 1
 */

public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = -1; // 0xffffffff

/**
 * Constant indicating base direction is left-to-right.
 * @apiSince 1
 */

public static final int DIRECTION_LEFT_TO_RIGHT = 0; // 0x0

/**
 * Constant indicating base direction is right-to-left.
 * @apiSince 1
 */

public static final int DIRECTION_RIGHT_TO_LEFT = 1; // 0x1
}

