/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.content;

import java.util.Map;
import android.os.Handler;

/**
 * Caches the contents of a cursor into a Map of String->ContentValues and optionally
 * keeps the cache fresh by registering for updates on the content backing the cursor. The column of
 * the database that is to be used as the key of the map is user-configurable, and the
 * ContentValues contains all columns other than the one that is designated the key.
 * <p>
 * The cursor data is accessed by row key and column name via getValue().
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ContentQueryMap extends java.util.Observable {

/**
 * Creates a ContentQueryMap that caches the content backing the cursor
 *
 * @param cursor the cursor whose contents should be cached
 * @param columnNameOfKey the column that is to be used as the key of the values map
 * @param keepUpdated true if the cursor's ContentProvider should be monitored for changes and
 * the map updated when changes do occur
 * @param handlerForUpdateNotifications the Handler that should be used to receive
 *  notifications of changes (if requested). Normally you pass null here, but if
 *  you know that the thread that is creating this isn't a thread that can receive
 *  messages then you can create your own handler and use that here.
 * @apiSince 1
 */

public ContentQueryMap(android.database.Cursor cursor, java.lang.String columnNameOfKey, boolean keepUpdated, android.os.Handler handlerForUpdateNotifications) { throw new RuntimeException("Stub!"); }

/**
 * Change whether or not the ContentQueryMap will register with the cursor's ContentProvider
 * for change notifications. If you use a ContentQueryMap in an activity you should call this
 * with false in onPause(), which means you need to call it with true in onResume()
 * if want it to be kept updated.
 * @param keepUpdated if true the ContentQueryMap should be registered with the cursor's
 * ContentProvider, false otherwise
 * @apiSince 1
 */

public void setKeepUpdated(boolean keepUpdated) { throw new RuntimeException("Stub!"); }

/**
 * Access the ContentValues for the row specified by rowName
 * @param rowName which row to read
 * @return the ContentValues for the row, or null if the row wasn't present in the cursor
 * @apiSince 1
 */

public synchronized android.content.ContentValues getValues(java.lang.String rowName) { throw new RuntimeException("Stub!"); }

/**
 * Requeries the cursor and reads the contents into the cache
 * @apiSince 1
 */

public void requery() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized java.util.Map<java.lang.String,android.content.ContentValues> getRows() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

