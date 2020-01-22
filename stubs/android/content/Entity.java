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


package android.content;

import android.net.Uri;

/**
 * A representation of a item using ContentValues. It contains one top level ContentValue
 * plus a collection of Uri, ContentValues tuples as subvalues. One example of its use
 * is in Contacts, where the top level ContentValue contains the columns from the RawContacts
 * table and the subvalues contain a ContentValues object for each row from the Data table that
 * corresponds to that RawContact. The uri refers to the Data table uri for each row.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Entity {

/** @apiSince 8 */

public Entity(android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public android.content.ContentValues getEntityValues() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public java.util.ArrayList<android.content.Entity.NamedContentValues> getSubValues() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void addSubValue(android.net.Uri uri, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/** @apiSince 8 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class NamedContentValues {

/** @apiSince 8 */

public NamedContentValues(android.net.Uri uri, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public final android.net.Uri uri;
{ uri = null; }

/** @apiSince 8 */

public final android.content.ContentValues values;
{ values = null; }
}

}

