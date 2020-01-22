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

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Reader;

/**
 * Reads a JSON (<a href="http://www.ietf.org/rfc/rfc4627.txt">RFC 4627</a>)
 * encoded value as a stream of tokens. This stream includes both literal
 * values (strings, numbers, booleans, and nulls) as well as the begin and
 * end delimiters of objects and arrays. The tokens are traversed in
 * depth-first order, the same order that they appear in the JSON document.
 * Within JSON objects, name/value pairs are represented by a single token.
 *
 * <h3>Parsing JSON</h3>
 * To create a recursive descent parser for your own JSON streams, first create
 * an entry point method that creates a {@code JsonReader}.
 *
 * <p>Next, create handler methods for each structure in your JSON text. You'll
 * need a method for each object type and for each array type.
 * <ul>
 *   <li>Within <strong>array handling</strong> methods, first call {@link
 *       #beginArray} to consume the array's opening bracket. Then create a
 *       while loop that accumulates values, terminating when {@link #hasNext}
 *       is false. Finally, read the array's closing bracket by calling {@link
 *       #endArray}.
 *   <li>Within <strong>object handling</strong> methods, first call {@link
 *       #beginObject} to consume the object's opening brace. Then create a
 *       while loop that assigns values to local variables based on their name.
 *       This loop should terminate when {@link #hasNext} is false. Finally,
 *       read the object's closing brace by calling {@link #endObject}.
 * </ul>
 * <p>When a nested object or array is encountered, delegate to the
 * corresponding handler method.
 *
 * <p>When an unknown name is encountered, strict parsers should fail with an
 * exception. Lenient parsers should call {@link #skipValue()} to recursively
 * skip the value's nested tokens, which may otherwise conflict.
 *
 * <p>If a value may be null, you should first check using {@link #peek()}.
 * Null literals can be consumed using either {@link #nextNull()} or {@link
 * #skipValue()}.
 *
 * <h3>Example</h3>
 * Suppose we'd like to parse a stream of messages such as the following: <pre> {@code
 * [
 *   {
 *     "id": 912345678901,
 *     "text": "How do I read JSON on Android?",
 *     "geo": null,
 *     "user": {
 *       "name": "android_newb",
 *       "followers_count": 41
 *      }
 *   },
 *   {
 *     "id": 912345678902,
 *     "text": "@android_newb just use android.util.JsonReader!",
 *     "geo": [50.454722, -104.606667],
 *     "user": {
 *       "name": "jesse",
 *       "followers_count": 2
 *     }
 *   }
 * ]}</pre>
 * This code implements the parser for the above structure: <pre>   {@code
 *
 *   public List<Message> readJsonStream(InputStream in) throws IOException {
 *     JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
 *     try {
 *       return readMessagesArray(reader);
 *     } finally {
 *       reader.close();
 *     }
 *   }
 *
 *   public List<Message> readMessagesArray(JsonReader reader) throws IOException {
 *     List<Message> messages = new ArrayList<Message>();
 *
 *     reader.beginArray();
 *     while (reader.hasNext()) {
 *       messages.add(readMessage(reader));
 *     }
 *     reader.endArray();
 *     return messages;
 *   }
 *
 *   public Message readMessage(JsonReader reader) throws IOException {
 *     long id = -1;
 *     String text = null;
 *     User user = null;
 *     List<Double> geo = null;
 *
 *     reader.beginObject();
 *     while (reader.hasNext()) {
 *       String name = reader.nextName();
 *       if (name.equals("id")) {
 *         id = reader.nextLong();
 *       } else if (name.equals("text")) {
 *         text = reader.nextString();
 *       } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
 *         geo = readDoublesArray(reader);
 *       } else if (name.equals("user")) {
 *         user = readUser(reader);
 *       } else {
 *         reader.skipValue();
 *       }
 *     }
 *     reader.endObject();
 *     return new Message(id, text, user, geo);
 *   }
 *
 *   public List<Double> readDoublesArray(JsonReader reader) throws IOException {
 *     List<Double> doubles = new ArrayList<Double>();
 *
 *     reader.beginArray();
 *     while (reader.hasNext()) {
 *       doubles.add(reader.nextDouble());
 *     }
 *     reader.endArray();
 *     return doubles;
 *   }
 *
 *   public User readUser(JsonReader reader) throws IOException {
 *     String username = null;
 *     int followersCount = -1;
 *
 *     reader.beginObject();
 *     while (reader.hasNext()) {
 *       String name = reader.nextName();
 *       if (name.equals("name")) {
 *         username = reader.nextString();
 *       } else if (name.equals("followers_count")) {
 *         followersCount = reader.nextInt();
 *       } else {
 *         reader.skipValue();
 *       }
 *     }
 *     reader.endObject();
 *     return new User(username, followersCount);
 *   }}</pre>
 *
 * <h3>Number Handling</h3>
 * This reader permits numeric values to be read as strings and string values to
 * be read as numbers. For example, both elements of the JSON array {@code
 * [1, "1"]} may be read using either {@link #nextInt} or {@link #nextString}.
 * This behavior is intended to prevent lossy numeric conversions: double is
 * JavaScript's only numeric type and very large values like {@code
 * 9007199254740993} cannot be represented exactly on that platform. To minimize
 * precision loss, extremely large values should be written and read as strings
 * in JSON.
 *
 * <p>Each {@code JsonReader} may be used to read a single JSON stream. Instances
 * of this class are not thread safe.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class JsonReader implements java.io.Closeable {

/**
 * Creates a new instance that reads a JSON-encoded stream from {@code in}.
 * @apiSince 11
 */

public JsonReader(java.io.Reader in) { throw new RuntimeException("Stub!"); }

/**
 * Configure this parser to be  be liberal in what it accepts. By default,
 * this parser is strict and only accepts JSON as specified by <a
 * href="http://www.ietf.org/rfc/rfc4627.txt">RFC 4627</a>. Setting the
 * parser to lenient causes it to ignore the following syntax errors:
 *
 * <ul>
 *   <li>End of line comments starting with {@code //} or {@code #} and
 *       ending with a newline character.
 *   <li>C-style comments starting with {@code /*} and ending with
 *       {@code *}{@code /}. Such comments may not be nested.
 *   <li>Names that are unquoted or {@code 'single quoted'}.
 *   <li>Strings that are unquoted or {@code 'single quoted'}.
 *   <li>Array elements separated by {@code ;} instead of {@code ,}.
 *   <li>Unnecessary array separators. These are interpreted as if null
 *       was the omitted value.
 *   <li>Names and values separated by {@code =} or {@code =>} instead of
 *       {@code :}.
 *   <li>Name/value pairs separated by {@code ;} instead of {@code ,}.
 * </ul>
 * @apiSince 11
 */

public void setLenient(boolean lenient) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this parser is liberal in what it accepts.
 * @apiSince 11
 */

public boolean isLenient() { throw new RuntimeException("Stub!"); }

/**
 * Consumes the next token from the JSON stream and asserts that it is the
 * beginning of a new array.
 * @apiSince 11
 */

public void beginArray() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Consumes the next token from the JSON stream and asserts that it is the
 * end of the current array.
 * @apiSince 11
 */

public void endArray() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Consumes the next token from the JSON stream and asserts that it is the
 * beginning of a new object.
 * @apiSince 11
 */

public void beginObject() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Consumes the next token from the JSON stream and asserts that it is the
 * end of the current object.
 * @apiSince 11
 */

public void endObject() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current array or object has another element.
 * @apiSince 11
 */

public boolean hasNext() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of the next token without consuming it.
 * @apiSince 11
 */

public android.util.JsonToken peek() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the next token, a {@link android.util.JsonToken#NAME JsonToken#NAME}, and
 * consumes it.
 *
 * @throws java.io.IOException if the next token in the stream is not a property
 *     name.
 * @apiSince 11
 */

public java.lang.String nextName() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.util.JsonToken#STRING JsonToken#STRING} value of the next token,
 * consuming it. If the next token is a number, this method will return its
 * string form.
 *
 * @throws java.lang.IllegalStateException if the next token is not a string or if
 *     this reader is closed.
 * @apiSince 11
 */

public java.lang.String nextString() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.util.JsonToken#BOOLEAN JsonToken#BOOLEAN} value of the next token,
 * consuming it.
 *
 * @throws java.lang.IllegalStateException if the next token is not a boolean or if
 *     this reader is closed.
 * @apiSince 11
 */

public boolean nextBoolean() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Consumes the next token from the JSON stream and asserts that it is a
 * literal null.
 *
 * @throws java.lang.IllegalStateException if the next token is not null or if this
 *     reader is closed.
 * @apiSince 11
 */

public void nextNull() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.util.JsonToken#NUMBER JsonToken#NUMBER} value of the next token,
 * consuming it. If the next token is a string, this method will attempt to
 * parse it as a double using {@link java.lang.Double#parseDouble(java.lang.String) Double#parseDouble(String)}.
 *
 * @throws java.lang.IllegalStateException if the next token is not a literal value.
 * @apiSince 11
 */

public double nextDouble() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.util.JsonToken#NUMBER JsonToken#NUMBER} value of the next token,
 * consuming it. If the next token is a string, this method will attempt to
 * parse it as a long. If the next token's numeric value cannot be exactly
 * represented by a Java {@code long}, this method throws.
 *
 * @throws java.lang.IllegalStateException if the next token is not a literal value.
 * @throws java.lang.NumberFormatException if the next literal value cannot be parsed
 *     as a number, or exactly represented as a long.
 * @apiSince 11
 */

public long nextLong() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.util.JsonToken#NUMBER JsonToken#NUMBER} value of the next token,
 * consuming it. If the next token is a string, this method will attempt to
 * parse it as an int. If the next token's numeric value cannot be exactly
 * represented by a Java {@code int}, this method throws.
 *
 * @throws java.lang.IllegalStateException if the next token is not a literal value.
 * @throws java.lang.NumberFormatException if the next literal value cannot be parsed
 *     as a number, or exactly represented as an int.
 * @apiSince 11
 */

public int nextInt() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this JSON reader and the underlying {@link java.io.Reader Reader}.
 * @apiSince 11
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips the next value recursively. If it is an object or array, all nested
 * elements are skipped. This method is intended for use when the JSON token
 * stream contains unrecognized or unhandled values.
 * @apiSince 11
 */

public void skipValue() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

