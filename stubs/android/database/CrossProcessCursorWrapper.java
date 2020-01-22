/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * limitations under the License
 */


package android.database;

import android.database.CrossProcessCursor;
import android.database.Cursor;

/**
 * Cursor wrapper that implements {@link android.database.CrossProcessCursor CrossProcessCursor}.
 * <p>
 * If the wrapped cursor implements {@link android.database.CrossProcessCursor CrossProcessCursor}, then the wrapper
 * delegates {@link #fillWindow}, {@link #getWindow()} and {@link #onMove} to it.
 * Otherwise, the wrapper provides default implementations of these methods that
 * traverse the contents of the cursor similar to {@link android.database.AbstractCursor#fillWindow AbstractCursor#fillWindow}.
 * </p><p>
 * This wrapper can be used to adapt an ordinary {@link android.database.Cursor Cursor} into a
 * {@link android.database.CrossProcessCursor CrossProcessCursor}.
 * </p>
 * @apiSince 15
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CrossProcessCursorWrapper extends android.database.CursorWrapper implements android.database.CrossProcessCursor {

/**
 * Creates a cross process cursor wrapper.
 * @param cursor The underlying cursor to wrap.
 * @apiSince 15
 */

public CrossProcessCursorWrapper(android.database.Cursor cursor) { super(null); throw new RuntimeException("Stub!"); }

/** @apiSince 15 */

public void fillWindow(int position, android.database.CursorWindow window) { throw new RuntimeException("Stub!"); }

/** @apiSince 15 */

public android.database.CursorWindow getWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 15 */

public boolean onMove(int oldPosition, int newPosition) { throw new RuntimeException("Stub!"); }
}

