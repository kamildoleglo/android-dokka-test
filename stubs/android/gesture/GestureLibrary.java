/*
 * Copyright (C) 2009 The Android Open Source Project
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


/** @apiSince 4 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class GestureLibrary {

/** @apiSince 4 */

protected GestureLibrary() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public abstract boolean save();

/** @apiSince 4 */

public abstract boolean load();

/** @apiSince 4 */

public boolean isReadOnly() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setOrientationStyle(int style) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int getOrientationStyle() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void setSequenceType(int type) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int getSequenceType() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.util.Set<java.lang.String> getGestureEntries() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.util.ArrayList<android.gesture.Prediction> recognize(android.gesture.Gesture gesture) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void addGesture(java.lang.String entryName, android.gesture.Gesture gesture) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeGesture(java.lang.String entryName, android.gesture.Gesture gesture) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void removeEntry(java.lang.String entryName) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.util.ArrayList<android.gesture.Gesture> getGestures(java.lang.String entryName) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

protected final android.gesture.GestureStore mStore;
{ mStore = null; }
}

