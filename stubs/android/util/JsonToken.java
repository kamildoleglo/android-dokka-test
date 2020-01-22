/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.util;


/**
 * A structure, name or value type in a JSON-encoded string.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum JsonToken {
/**
 * The opening of a JSON array. Written using {@link android.util.JsonWriter#beginObject JsonWriter#beginObject}
 * and read using {@link android.util.JsonReader#beginObject JsonReader#beginObject}.
 * @apiSince 11
 */

BEGIN_ARRAY,
/**
 * The closing of a JSON array. Written using {@link android.util.JsonWriter#endArray JsonWriter#endArray}
 * and read using {@link android.util.JsonReader#endArray JsonReader#endArray}.
 * @apiSince 11
 */

END_ARRAY,
/**
 * The opening of a JSON object. Written using {@link android.util.JsonWriter#beginObject JsonWriter#beginObject}
 * and read using {@link android.util.JsonReader#beginObject JsonReader#beginObject}.
 * @apiSince 11
 */

BEGIN_OBJECT,
/**
 * The closing of a JSON object. Written using {@link android.util.JsonWriter#endObject JsonWriter#endObject}
 * and read using {@link android.util.JsonReader#endObject JsonReader#endObject}.
 * @apiSince 11
 */

END_OBJECT,
/**
 * A JSON property name. Within objects, tokens alternate between names and
 * their values. Written using {@link android.util.JsonWriter#name JsonWriter#name} and read using {@link android.util.JsonReader#nextName JsonReader#nextName}
 * @apiSince 11
 */

NAME,
/**
 * A JSON string.
 * @apiSince 11
 */

STRING,
/**
 * A JSON number represented in this API by a Java {@code double}, {@code
 * long}, or {@code int}.
 * @apiSince 11
 */

NUMBER,
/**
 * A JSON {@code true} or {@code false}.
 * @apiSince 11
 */

BOOLEAN,
/**
 * A JSON {@code null}.
 * @apiSince 11
 */

NULL,
/**
 * The end of the JSON stream. This sentinel value is returned by {@link android.util.JsonReader#peek() JsonReader#peek()} to signal that the JSON-encoded value has no more
 * tokens.
 * @apiSince 11
 */

END_DOCUMENT;
}

