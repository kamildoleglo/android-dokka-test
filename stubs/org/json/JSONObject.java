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

import java.util.Iterator;
import java.util.Collection;
import java.util.Map;

/**
 * A modifiable set of name/value mappings. Names are unique, non-null strings.
 * Values may be any mix of {@link org.json.JSONObject JSONObject}, {@link org.json.JSONArray JSONArray}, Strings, Booleans, Integers, Longs, Doubles or {@link #NULL}.
 * Values may not be {@code null}, {@link java.lang.Double#isNaN() Double#isNaN()}, {@link java.lang.Double#isInfinite() Double#isInfinite()}, or of any type not listed here.
 *
 * <p>This class can coerce values to another type when requested.
 * <ul>
 *   <li>When the requested type is a boolean, strings will be coerced using a
 *       case-insensitive comparison to "true" and "false".
 *   <li>When the requested type is a double, other {@link java.lang.Number Number} types will
 *       be coerced using {@link java.lang.Number#doubleValue() Number#doubleValue()}. Strings
 *       that can be coerced using {@link java.lang.Double#valueOf(java.lang.String) Double#valueOf(String)} will be.
 *   <li>When the requested type is an int, other {@link java.lang.Number Number} types will
 *       be coerced using {@link java.lang.Number#intValue() Number#intValue()}. Strings
 *       that can be coerced using {@link java.lang.Double#valueOf(java.lang.String) Double#valueOf(String)} will be,
 *       and then cast to int.
 *   <li><a name="lossy">When the requested type is a long, other {@link java.lang.Number Number} types will
 *       be coerced using {@link java.lang.Number#longValue() Number#longValue()}. Strings
 *       that can be coerced using {@link java.lang.Double#valueOf(java.lang.String) Double#valueOf(String)} will be,
 *       and then cast to long. This two-step conversion is lossy for very
 *       large values. For example, the string "9223372036854775806" yields the
 *       long 9223372036854775807.</a>
 *   <li>When the requested type is a String, other non-null values will be
 *       coerced using {@link java.lang.String#valueOf(java.lang.Object) String#valueOf(Object)}. Although null cannot be
 *       coerced, the sentinel value {@link org.json.JSONObject#NULL JSONObject#NULL} is coerced to the
 *       string "null".
 * </ul>
 *
 * <p>This class can look up both mandatory and optional values:
 * <ul>
 *   <li>Use <code>get<i>Type</i>()</code> to retrieve a mandatory value. This
 *       fails with a {@code JSONException} if the requested name has no value
 *       or if the value cannot be coerced to the requested type.
 *   <li>Use <code>opt<i>Type</i>()</code> to retrieve an optional value. This
 *       returns a system- or user-supplied default if the requested name has no
 *       value or if the value cannot be coerced to the requested type.
 * </ul>
 *
 * <p><strong>Warning:</strong> this class represents null in two incompatible
 * ways: the standard Java {@code null} reference, and the sentinel value {@link org.json.JSONObject#NULL JSONObject#NULL}. In particular, calling {@code put(name, null)} removes the
 * named entry from the object but {@code put(name, JSONObject.NULL)} stores an
 * entry whose value is {@code JSONObject.NULL}.
 *
 * <p>Instances of this class are not thread safe. Although this class is
 * nonfinal, it was not designed for inheritance and should not be subclassed.
 * In particular, self-use by overrideable methods is not specified. See
 * <i>Effective Java</i> Item 17, "Design and Document or inheritance or else
 * prohibit it" for further information.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JSONObject {

/**
 * Creates a {@code JSONObject} with no name/value mappings.
 * @apiSince 1
 */

public JSONObject() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} by copying all name/value mappings from
 * the given map.
 *
 * @param copyFrom a map whose keys are of type {@link java.lang.String String} and whose
 *     values are of supported types.
 * @throws java.lang.NullPointerException if any of the map's keys are null.
 * @apiSince 1
 */

public JSONObject(@androidx.annotation.NonNull java.util.Map copyFrom) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} with name/value mappings from the next
 * object in the tokener.
 *
 * @param readFrom a tokener whose nextValue() method will yield a
 *     {@code JSONObject}.
 * @throws org.json.JSONException if the parse fails or doesn't yield a
 *     {@code JSONObject}.
 * @apiSince 1
 */

public JSONObject(@androidx.annotation.NonNull org.json.JSONTokener readFrom) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} with name/value mappings from the JSON
 * string.
 *
 * @param json a JSON-encoded string containing an object.
 * @throws org.json.JSONException if the parse fails or doesn't yield a {@code
 *     JSONObject}.
 * @apiSince 1
 */

public JSONObject(@androidx.annotation.NonNull java.lang.String json) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} by copying mappings for the listed names
 * from the given object. Names that aren't present in {@code copyFrom} will
 * be skipped.
 * @apiSince 1
 */

public JSONObject(@androidx.annotation.NonNull org.json.JSONObject copyFrom, @androidx.annotation.NonNull java.lang.String[] names) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of name/value mappings in this object.
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @return this object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject put(@androidx.annotation.NonNull java.lang.String name, boolean value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @param value a finite value. May not be {@link java.lang.Double#isNaN() Double#isNaN()} or
 *     {@link java.lang.Double#isInfinite() Double#isInfinite()}.
 * @return this object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject put(@androidx.annotation.NonNull java.lang.String name, double value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @return this object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject put(@androidx.annotation.NonNull java.lang.String name, int value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @return this object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject put(@androidx.annotation.NonNull java.lang.String name, long value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name. If the value is {@code null}, any existing
 * mapping for {@code name} is removed.
 *
 * @param value a {@link org.json.JSONObject JSONObject}, {@link org.json.JSONArray JSONArray}, String, Boolean,
 *     Integer, Long, Double, {@link #NULL}, or {@code null}. May not be
 *     {@link java.lang.Double#isNaN() Double#isNaN()} or {@link java.lang.Double#isInfinite() Double#isInfinite()}.
 * @return this object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject put(@androidx.annotation.NonNull java.lang.String name, @androidx.annotation.Nullable java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@code put(name, value)} when both parameters are non-null;
 * does nothing otherwise.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject putOpt(@androidx.annotation.Nullable java.lang.String name, @androidx.annotation.Nullable java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Appends {@code value} to the array already mapped to {@code name}. If
 * this object has no mapping for {@code name}, this inserts a new mapping.
 * If the mapping exists but its value is not an array, the existing
 * and new values are inserted in order into a new array which is itself
 * mapped to {@code name}. In aggregate, this allows values to be added to a
 * mapping one at a time.
 *
 * <p> Note that {@code append(String, Object)} provides better semantics.
 * In particular, the mapping for {@code name} will <b>always</b> be a
 * {@link org.json.JSONArray JSONArray}. Using {@code accumulate} will result in either a
 * {@link org.json.JSONArray JSONArray} or a mapping whose type is the type of {@code value}
 * depending on the number of calls to it.
 *
 * @param value a {@link org.json.JSONObject JSONObject}, {@link org.json.JSONArray JSONArray}, String, Boolean,
 *     Integer, Long, Double, {@link #NULL} or null. May not be {@link java.lang.Double#isNaN() Double#isNaN()} or {@link java.lang.Double#isInfinite() Double#isInfinite()}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject accumulate(@androidx.annotation.NonNull java.lang.String name, @androidx.annotation.Nullable java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Removes the named mapping if it exists; does nothing otherwise.
 *
 * @return the value previously mapped by {@code name}, or null if there was
 *     no such mapping.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.Object remove(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object has no mapping for {@code name} or if it has
 * a mapping whose value is {@link #NULL}.
 * @apiSince 1
 */

public boolean isNull(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object has a mapping for {@code name}. The mapping
 * may be {@link #NULL}.
 * @apiSince 1
 */

public boolean has(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name}, or throws if no such mapping exists.
 *
 * @throws org.json.JSONException if no such mapping exists.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object get(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name}, or null if no such mapping
 * exists.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.Object opt(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a boolean or
 * can be coerced to a boolean, or throws otherwise.
 *
 * @throws org.json.JSONException if the mapping doesn't exist or cannot be coerced
 *     to a boolean.
 * @apiSince 1
 */

public boolean getBoolean(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a boolean or
 * can be coerced to a boolean, or false otherwise.
 * @apiSince 1
 */

public boolean optBoolean(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a boolean or
 * can be coerced to a boolean, or {@code fallback} otherwise.
 * @apiSince 1
 */

public boolean optBoolean(@androidx.annotation.Nullable java.lang.String name, boolean fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a double or
 * can be coerced to a double, or throws otherwise.
 *
 * @throws org.json.JSONException if the mapping doesn't exist or cannot be coerced
 *     to a double.
 * @apiSince 1
 */

public double getDouble(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a double or
 * can be coerced to a double, or {@code NaN} otherwise.
 * @apiSince 1
 */

public double optDouble(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a double or
 * can be coerced to a double, or {@code fallback} otherwise.
 * @apiSince 1
 */

public double optDouble(@androidx.annotation.Nullable java.lang.String name, double fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is an int or
 * can be coerced to an int, or throws otherwise.
 *
 * @throws org.json.JSONException if the mapping doesn't exist or cannot be coerced
 *     to an int.
 * @apiSince 1
 */

public int getInt(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is an int or
 * can be coerced to an int, or 0 otherwise.
 * @apiSince 1
 */

public int optInt(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is an int or
 * can be coerced to an int, or {@code fallback} otherwise.
 * @apiSince 1
 */

public int optInt(@androidx.annotation.Nullable java.lang.String name, int fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a long or
 * can be coerced to a long, or throws otherwise.
 * Note that JSON represents numbers as doubles,
 * so this is <a href="#lossy">lossy</a>; use strings to transfer numbers via JSON.
 *
 * @throws org.json.JSONException if the mapping doesn't exist or cannot be coerced
 *     to a long.
 * @apiSince 1
 */

public long getLong(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a long or
 * can be coerced to a long, or 0 otherwise. Note that JSON represents numbers as doubles,
 * so this is <a href="#lossy">lossy</a>; use strings to transfer numbers via JSON.
 * @apiSince 1
 */

public long optLong(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a long or
 * can be coerced to a long, or {@code fallback} otherwise. Note that JSON represents
 * numbers as doubles, so this is <a href="#lossy">lossy</a>; use strings to transfer
 * numbers via JSON.
 * @apiSince 1
 */

public long optLong(@androidx.annotation.Nullable java.lang.String name, long fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists, coercing it if
 * necessary, or throws if no such mapping exists.
 *
 * @throws org.json.JSONException if no such mapping exists.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getString(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists, coercing it if
 * necessary, or the empty string if no such mapping exists.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String optString(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists, coercing it if
 * necessary, or {@code fallback} if no such mapping exists.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String optString(@androidx.annotation.Nullable java.lang.String name, @androidx.annotation.NonNull java.lang.String fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONArray}, or throws otherwise.
 *
 * @throws org.json.JSONException if the mapping doesn't exist or is not a {@code
 *     JSONArray}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONArray getJSONArray(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONArray}, or null otherwise.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public org.json.JSONArray optJSONArray(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONObject}, or throws otherwise.
 *
 * @throws org.json.JSONException if the mapping doesn't exist or is not a {@code
 *     JSONObject}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public org.json.JSONObject getJSONObject(@androidx.annotation.NonNull java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONObject}, or null otherwise.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public org.json.JSONObject optJSONObject(@androidx.annotation.Nullable java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array with the values corresponding to {@code names}. The
 * array contains null for names that aren't mapped. This method returns
 * null if {@code names} is either null or empty.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public org.json.JSONArray toJSONArray(@androidx.annotation.Nullable org.json.JSONArray names) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator of the {@code String} names in this object. The
 * returned iterator supports {@link java.util.Iterator#remove() Iterator#remove()}, which will
 * remove the corresponding mapping from this object. If this object is
 * modified after the iterator is returned, the iterator's behavior is
 * undefined. The order of the keys is undefined.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Iterator<java.lang.String> keys() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing the string names in this object. This method
 * returns null if this object contains no mappings.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public org.json.JSONArray names() { throw new RuntimeException("Stub!"); }

/**
 * Encodes this object as a compact JSON string, such as:
 * <pre>{"query":"Pizza","locations":[94043,90210]}</pre>
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Encodes this object as a human readable JSON string for debugging, such
 * as:
 * <pre>
 * {
 *     "query": "Pizza",
 *     "locations": [
 *         94043,
 *         90210
 *     ]
 * }</pre>
 *
 * @param indentSpaces the number of spaces to indent for each level of
 *     nesting.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString(int indentSpaces) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes the number as a JSON string.
 *
 * @param number a finite value. May not be {@link java.lang.Double#isNaN() Double#isNaN()} or
 *     {@link java.lang.Double#isInfinite() Double#isInfinite()}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String numberToString(@androidx.annotation.NonNull java.lang.Number number) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code data} as a JSON string. This applies quotes and any
 * necessary character escaping.
 *
 * @param data the string to encode. Null will be interpreted as an empty
 *     string.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String quote(@androidx.annotation.Nullable java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Wraps the given object if necessary.
 *
 * <p>If the object is null or , returns {@link #NULL}.
 * If the object is a {@code JSONArray} or {@code JSONObject}, no wrapping is necessary.
 * If the object is {@code NULL}, no wrapping is necessary.
 * If the object is an array or {@code Collection}, returns an equivalent {@code JSONArray}.
 * If the object is a {@code Map}, returns an equivalent {@code JSONObject}.
 * If the object is a primitive wrapper type or {@code String}, returns the object.
 * Otherwise if the object is from a {@code java} package, returns the result of {@code toString}.
 * If wrapping fails, returns null.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public static java.lang.Object wrap(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * A sentinel value used to explicitly define a name with no value. Unlike
 * {@code null}, names with this value:
 * <ul>
 *   <li>show up in the {@link #names} array
 *   <li>show up in the {@link #keys} iterator
 *   <li>return {@code true} for {@link #has(java.lang.String)}
 *   <li>do not throw on {@link #get(java.lang.String)}
 *   <li>are included in the encoded JSON string.
 * </ul>
 *
 * <p>This value violates the general contract of {@link java.lang.Object#equals Object#equals} by
 * returning true when compared to {@code null}. Its {@link #toString}
 * method returns "null".
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.lang.Object NULL;
static { NULL = null; }
}

