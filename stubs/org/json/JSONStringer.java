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



package org.json;

import java.util.Arrays;

/**
 * Implements {@link org.json.JSONObject#toString JSONObject#toString} and {@link org.json.JSONArray#toString JSONArray#toString}. Most
 * application developers should use those methods directly and disregard this
 * API. For example:<pre>
 * JSONObject object = ...
 * String json = object.toString();</pre>
 *
 * <p>Stringers only encode well-formed JSON strings. In particular:
 * <ul>
 *   <li>The stringer must have exactly one top-level array or object.
 *   <li>Lexical scopes must be balanced: every call to {@link #array} must
 *       have a matching call to {@link #endArray} and every call to {@link
 *       #object} must have a matching call to {@link #endObject}.
 *   <li>Arrays may not contain keys (property names).
 *   <li>Objects must alternate keys (property names) and values.
 *   <li>Values are inserted with either literal {@link #value(java.lang.Object) value}
 *       calls, or by nesting arrays or objects.
 * </ul>
 * Calls that would result in a malformed JSON string will fail with a
 * {@link org.json.JSONException JSONException}.
 *
 * <p>This class provides no facility for pretty-printing (ie. indenting)
 * output. To encode indented output, use {@link org.json.JSONObject#toString(int) JSONObject#toString(int)} or
 * {@link org.json.JSONArray#toString(int) JSONArray#toString(int)}.
 *
 * <p>Some implementations of the API support at most 20 levels of nesting.
 * Attempts to create more than 20 levels of nesting may fail with a {@link org.json.JSONException JSONException}.
 *
 * <p>Each stringer may be used to encode a single top level value. Instances of
 * this class are not thread safe. Although this class is nonfinal, it was not
 * designed for inheritance and should not be subclassed. In particular,
 * self-use by overrideable methods is not specified. See <i>Effective Java</i>
 * Item 17, "Design and Document or inheritance or else prohibit it" for further
 * information.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JSONStringer {

/** @apiSince 1 */

public JSONStringer() { throw new RuntimeException("Stub!"); }

/**
 * Begins encoding a new array. Each call to this method must be paired with
 * a call to {@link #endArray}.
 *
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer array() throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Ends encoding the current array.
 *
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer endArray() throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Begins encoding a new object. Each call to this method must be paired
 * with a call to {@link #endObject}.
 *
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer object() throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Ends encoding the current object.
 *
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer endObject() throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value}.
 *
 * @param value a {@link org.json.JSONObject JSONObject}, {@link org.json.JSONArray JSONArray}, String, Boolean,
 *     Integer, Long, Double or null. May not be {@link java.lang.Double#isNaN() Double#isNaN()}
 *     or {@link java.lang.Double#isInfinite() Double#isInfinite()}.
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer value(java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value} to this stringer.
 *
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer value(boolean value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value} to this stringer.
 *
 * @param value a finite value. May not be {@link java.lang.Double#isNaN() Double#isNaN()} or
 *     {@link java.lang.Double#isInfinite() Double#isInfinite()}.
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer value(double value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value} to this stringer.
 *
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer value(long value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes the key (property name) to this stringer.
 *
 * @param name the name of the forthcoming value. May not be null.
 * @return this stringer.
 * @apiSince 1
 */

public org.json.JSONStringer key(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the encoded JSON string.
 *
 * <p>If invoked with unterminated arrays or unclosed objects, this method's
 * return value is undefined.
 *
 * <p><strong>Warning:</strong> although it contradicts the general contract
 * of {@link java.lang.Object#toString Object#toString}, this method returns null if the stringer
 * contains no data.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

