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

import java.util.List;
import java.io.IOException;
import java.io.Writer;

/**
 * Writes a JSON (<a href="http://www.ietf.org/rfc/rfc4627.txt">RFC 4627</a>)
 * encoded value to a stream, one token at a time. The stream includes both
 * literal values (strings, numbers, booleans and nulls) as well as the begin
 * and end delimiters of objects and arrays.
 *
 * <h3>Encoding JSON</h3>
 * To encode your data as JSON, create a new {@code JsonWriter}. Each JSON
 * document must contain one top-level array or object. Call methods on the
 * writer as you walk the structure's contents, nesting arrays and objects as
 * necessary:
 * <ul>
 *   <li>To write <strong>arrays</strong>, first call {@link #beginArray()}.
 *       Write each of the array's elements with the appropriate {@link #value}
 *       methods or by nesting other arrays and objects. Finally close the array
 *       using {@link #endArray()}.
 *   <li>To write <strong>objects</strong>, first call {@link #beginObject()}.
 *       Write each of the object's properties by alternating calls to
 *       {@link #name} with the property's value. Write property values with the
 *       appropriate {@link #value} method or by nesting other objects or arrays.
 *       Finally close the object using {@link #endObject()}.
 * </ul>
 *
 * <h3>Example</h3>
 * Suppose we'd like to encode a stream of messages such as the following: <pre> {@code
 * [
 *   {
 *     "id": 912345678901,
 *     "text": "How do I write JSON on Android?",
 *     "geo": null,
 *     "user": {
 *       "name": "android_newb",
 *       "followers_count": 41
 *      }
 *   },
 *   {
 *     "id": 912345678902,
 *     "text": "@android_newb just use android.util.JsonWriter!",
 *     "geo": [50.454722, -104.606667],
 *     "user": {
 *       "name": "jesse",
 *       "followers_count": 2
 *     }
 *   }
 * ]}</pre>
 * This code encodes the above structure: <pre>   {@code
 *   public void writeJsonStream(OutputStream out, List<Message> messages) throws IOException {
 *     JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
 *     writer.setIndent("  ");
 *     writeMessagesArray(writer, messages);
 *     writer.close();
 *   }
 *
 *   public void writeMessagesArray(JsonWriter writer, List<Message> messages) throws IOException {
 *     writer.beginArray();
 *     for (Message message : messages) {
 *       writeMessage(writer, message);
 *     }
 *     writer.endArray();
 *   }
 *
 *   public void writeMessage(JsonWriter writer, Message message) throws IOException {
 *     writer.beginObject();
 *     writer.name("id").value(message.getId());
 *     writer.name("text").value(message.getText());
 *     if (message.getGeo() != null) {
 *       writer.name("geo");
 *       writeDoublesArray(writer, message.getGeo());
 *     } else {
 *       writer.name("geo").nullValue();
 *     }
 *     writer.name("user");
 *     writeUser(writer, message.getUser());
 *     writer.endObject();
 *   }
 *
 *   public void writeUser(JsonWriter writer, User user) throws IOException {
 *     writer.beginObject();
 *     writer.name("name").value(user.getName());
 *     writer.name("followers_count").value(user.getFollowersCount());
 *     writer.endObject();
 *   }
 *
 *   public void writeDoublesArray(JsonWriter writer, List<Double> doubles) throws IOException {
 *     writer.beginArray();
 *     for (Double value : doubles) {
 *       writer.value(value);
 *     }
 *     writer.endArray();
 *   }}</pre>
 *
 * <p>Each {@code JsonWriter} may be used to write a single JSON stream.
 * Instances of this class are not thread safe. Calls that would result in a
 * malformed JSON string will fail with an {@link java.lang.IllegalStateException IllegalStateException}.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class JsonWriter implements java.io.Closeable {

/**
 * Creates a new instance that writes a JSON-encoded stream to {@code out}.
 * For best performance, ensure {@link java.io.Writer Writer} is buffered; wrapping in
 * {@link java.io.BufferedWriter BufferedWriter} if necessary.
 * @apiSince 11
 */

public JsonWriter(java.io.Writer out) { throw new RuntimeException("Stub!"); }

/**
 * Sets the indentation string to be repeated for each level of indentation
 * in the encoded document. If {@code indent.isEmpty()} the encoded document
 * will be compact. Otherwise the encoded document will be more
 * human-readable.
 *
 * @param indent a string containing only whitespace.
 * @apiSince 11
 */

public void setIndent(java.lang.String indent) { throw new RuntimeException("Stub!"); }

/**
 * Configure this writer to relax its syntax rules. By default, this writer
 * only emits well-formed JSON as specified by <a
 * href="http://www.ietf.org/rfc/rfc4627.txt">RFC 4627</a>. Setting the writer
 * to lenient permits the following:
 * <ul>
 *   <li>Top-level values of any type. With strict writing, the top-level
 *       value must be an object or an array.
 *   <li>Numbers may be {@link java.lang.Double#isNaN() Double#isNaN()} or {@link java.lang.Double#isInfinite() Double#isInfinite()}.
 * </ul>
 * @apiSince 11
 */

public void setLenient(boolean lenient) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this writer has relaxed syntax rules.
 * @apiSince 11
 */

public boolean isLenient() { throw new RuntimeException("Stub!"); }

/**
 * Begins encoding a new array. Each call to this method must be paired with
 * a call to {@link #endArray}.
 *
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter beginArray() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Ends encoding the current array.
 *
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter endArray() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Begins encoding a new object. Each call to this method must be paired
 * with a call to {@link #endObject}.
 *
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter beginObject() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Ends encoding the current object.
 *
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter endObject() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Encodes the property name.
 *
 * @param name the name of the forthcoming value. May not be null.
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter name(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value}.
 *
 * @param value the literal string value, or null to encode a null literal.
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter value(java.lang.String value) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code null}.
 *
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter nullValue() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value}.
 *
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter value(boolean value) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value}.
 *
 * @param value a finite value. May not be {@link java.lang.Double#isNaN() Double#isNaN()} or
 *     {@link java.lang.Double#isInfinite() Double#isInfinite()} unless this writer is lenient.
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter value(double value) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value}.
 *
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter value(long value) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code value}.
 *
 * @param value a finite value. May not be {@link java.lang.Double#isNaN() Double#isNaN()} or
 *     {@link java.lang.Double#isInfinite() Double#isInfinite()} unless this writer is lenient.
 * @return this writer.
 * @apiSince 11
 */

public android.util.JsonWriter value(java.lang.Number value) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Ensures all buffered data is written to the underlying {@link java.io.Writer Writer}
 * and flushes that writer.
 * @apiSince 11
 */

public void flush() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Flushes and closes this writer and the underlying {@link java.io.Writer Writer}.
 *
 * @throws java.io.IOException if the JSON document is incomplete.
 * @apiSince 11
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

