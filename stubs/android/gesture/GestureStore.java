/*
 * Copyright (C) 2008-2009 The Android Open Source Project
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


package android.gesture;


/**
 * GestureLibrary maintains gesture examples and makes predictions on a new
 * gesture
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GestureStore {

/** @apiSince 4 */

public GestureStore() { throw new RuntimeException("Stub!"); }

/**
 * Specify how the gesture library will handle orientation.
 * Use ORIENTATION_INVARIANT or ORIENTATION_SENSITIVE
 *
 * @param style
 * @apiSince 4
 */

public void setOrientationStyle(int style) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int getOrientationStyle() { throw new RuntimeException("Stub!"); }

/**
 * @param type SEQUENCE_INVARIANT or SEQUENCE_SENSITIVE
 * @apiSince 4
 */

public void setSequenceType(int type) { throw new RuntimeException("Stub!"); }

/**
 * @return SEQUENCE_INVARIANT or SEQUENCE_SENSITIVE
 * @apiSince 4
 */

public int getSequenceType() { throw new RuntimeException("Stub!"); }

/**
 * Get all the gesture entry names in the library
 *
 * @return a set of strings
 * @apiSince 4
 */

public java.util.Set<java.lang.String> getGestureEntries() { throw new RuntimeException("Stub!"); }

/**
 * Recognize a gesture
 *
 * @param gesture the query
 * @return a list of predictions of possible entries for a given gesture
 * @apiSince 4
 */

public java.util.ArrayList<android.gesture.Prediction> recognize(android.gesture.Gesture gesture) { throw new RuntimeException("Stub!"); }

/**
 * Add a gesture for the entry
 *
 * @param entryName entry name
 * @param gesture
 * @apiSince 4
 */

public void addGesture(java.lang.String entryName, android.gesture.Gesture gesture) { throw new RuntimeException("Stub!"); }

/**
 * Remove a gesture from the library. If there are no more gestures for the
 * given entry, the gesture entry will be removed.
 *
 * @param entryName entry name
 * @param gesture
 * @apiSince 4
 */

public void removeGesture(java.lang.String entryName, android.gesture.Gesture gesture) { throw new RuntimeException("Stub!"); }

/**
 * Remove a entry of gestures
 *
 * @param entryName the entry name
 * @apiSince 4
 */

public void removeEntry(java.lang.String entryName) { throw new RuntimeException("Stub!"); }

/**
 * Get all the gestures of an entry
 *
 * @param entryName
 * @return the list of gestures that is under this name
 * @apiSince 4
 */

public java.util.ArrayList<android.gesture.Gesture> getGestures(java.lang.String entryName) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean hasChanged() { throw new RuntimeException("Stub!"); }

/**
 * Save the gesture library
 * @apiSince 4
 */

public void save(java.io.OutputStream stream) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void save(java.io.OutputStream stream, boolean closeStream) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Load the gesture library
 * @apiSince 4
 */

public void load(java.io.InputStream stream) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void load(java.io.InputStream stream, boolean closeStream) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public static final int ORIENTATION_INVARIANT = 1; // 0x1

/** @apiSince 4 */

public static final int ORIENTATION_SENSITIVE = 2; // 0x2

/** @apiSince 4 */

public static final int SEQUENCE_INVARIANT = 1; // 0x1

/** @apiSince 4 */

public static final int SEQUENCE_SENSITIVE = 2; // 0x2
}

