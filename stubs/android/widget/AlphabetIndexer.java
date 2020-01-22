/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.widget;

import android.database.Cursor;

/**
 * A helper class for adapters that implement the SectionIndexer interface.
 * If the items in the adapter are sorted by simple alphabet-based sorting, then
 * this class provides a way to do fast indexing of large lists using binary search.
 * It caches the indices that have been determined through the binary search and also
 * invalidates the cache if changes occur in the cursor.
 * <p/>
 * Your adapter is responsible for updating the cursor by calling {@link #setCursor} if the
 * cursor changes. {@link #getPositionForSection} method does the binary search for the starting
 * index of a given section (alphabet).
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AlphabetIndexer extends android.database.DataSetObserver implements android.widget.SectionIndexer {

/**
 * Constructs the indexer.
 * @param cursor the cursor containing the data set
 * @param sortedColumnIndex the column number in the cursor that is sorted
 *        alphabetically
 * @param alphabet string containing the alphabet, with space as the first character.
 *        For example, use the string " ABCDEFGHIJKLMNOPQRSTUVWXYZ" for English indexing.
 *        The characters must be uppercase and be sorted in ascii/unicode order. Basically
 *        characters in the alphabet will show up as preview letters.
 * @apiSince 3
 */

public AlphabetIndexer(android.database.Cursor cursor, int sortedColumnIndex, java.lang.CharSequence alphabet) { throw new RuntimeException("Stub!"); }

/**
 * Returns the section array constructed from the alphabet provided in the constructor.
 * @return the section array
 * @apiSince 3
 */

public java.lang.Object[] getSections() { throw new RuntimeException("Stub!"); }

/**
 * Sets a new cursor as the data set and resets the cache of indices.
 * @param cursor the new cursor to use as the data set
 * @apiSince 3
 */

public void setCursor(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation compares the first character of word with letter.
 * @apiSince 3
 */

protected int compare(java.lang.String word, java.lang.String letter) { throw new RuntimeException("Stub!"); }

/**
 * Performs a binary search or cache lookup to find the first row that
 * matches a given section's starting letter.
 * @param sectionIndex the section to search for
 * @return the row index of the first occurrence, or the nearest next letter.
 * For instance, if searching for "T" and no "T" is found, then the first
 * row starting with "U" or any higher letter is returned. If there is no
 * data following "T" at all, then the list size is returned.
 * @apiSince 3
 */

public int getPositionForSection(int sectionIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the section index for a given position in the list by querying the item
 * and comparing it with all items in the section array.
 * @apiSince 3
 */

public int getSectionForPosition(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void onChanged() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void onInvalidated() { throw new RuntimeException("Stub!"); }

/**
 * The string of characters that make up the indexing sections.
 * @apiSince 3
 */

protected java.lang.CharSequence mAlphabet;

/**
 * The index of the cursor column that this list is sorted on.
 * @apiSince 3
 */

protected int mColumnIndex;

/**
 * Cursor that is used by the adapter of the list view.
 * @apiSince 3
 */

protected android.database.Cursor mDataCursor;
}

