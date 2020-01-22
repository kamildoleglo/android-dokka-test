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


package android.webkit;

import java.io.StringBufferInputStream;
import java.io.InputStream;

/**
 * Encapsulates a resource response. Applications can return an instance of this
 * class from {@link android.webkit.WebViewClient#shouldInterceptRequest WebViewClient#shouldInterceptRequest} to provide a custom
 * response when the WebView requests a particular resource.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WebResourceResponse {

/**
 * Constructs a resource response with the given MIME type, character encoding,
 * and input stream. Callers must implement {@link java.io.InputStream#read(byte[]) InputStream#read(byte[])} for
 * the input stream. {@link java.io.InputStream#close() InputStream#close()} will be called after the WebView
 * has finished with the response.
 *
 * <p class="note"><b>Note:</b> The MIME type and character encoding must
 * be specified as separate parameters (for example {@code "text/html"} and
 * {@code "utf-8"}), not a single value like the {@code "text/html; charset=utf-8"}
 * format used in the HTTP Content-Type header. Do not use the value of a HTTP
 * Content-Encoding header for {@code encoding}, as that header does not specify a
 * character encoding. Content without a defined character encoding (for example
 * image resources) should pass {@code null} for {@code encoding}.
 *
 * @param mimeType the resource response's MIME type, for example {@code "text/html"}.
 * @param encoding the resource response's character encoding, for example {@code "utf-8"}.
 * @param data the input stream that provides the resource response's data. Must not be a
 *             StringBufferInputStream.
 * @apiSince 11
 */

public WebResourceResponse(java.lang.String mimeType, java.lang.String encoding, java.io.InputStream data) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a resource response with the given parameters. Callers must implement
 * {@link java.io.InputStream#read(byte[]) InputStream#read(byte[])} for the input stream. {@link java.io.InputStream#close() InputStream#close()} will be
 * called after the WebView has finished with the response.
 *
 *
 * <p class="note"><b>Note:</b> See {@link #WebResourceResponse(java.lang.String,java.lang.String,java.io.InputStream)}
 * for details on what should be specified for {@code mimeType} and {@code encoding}.
 *
 * @param mimeType the resource response's MIME type, for example {@code "text/html"}.
 * @param encoding the resource response's character encoding, for example {@code "utf-8"}.
 * @param statusCode the status code needs to be in the ranges [100, 299], [400, 599].
 *                   Causing a redirect by specifying a 3xx code is not supported.
 * @param reasonPhrase the phrase describing the status code, for example "OK". Must be
 *                     non-empty.
 * This value must never be {@code null}.
 * @param responseHeaders the resource response's headers represented as a mapping of header
 *                        name -> header value.
 * @param data the input stream that provides the resource response's data. Must not be a
 *             StringBufferInputStream.
 * @apiSince 21
 */

public WebResourceResponse(java.lang.String mimeType, java.lang.String encoding, int statusCode, @androidx.annotation.NonNull java.lang.String reasonPhrase, java.util.Map<java.lang.String,java.lang.String> responseHeaders, java.io.InputStream data) { throw new RuntimeException("Stub!"); }

/**
 * Sets the resource response's MIME type, for example &quot;text/html&quot;.
 *
 * @param mimeType The resource response's MIME type
 * @apiSince 11
 */

public void setMimeType(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource response's MIME type.
 *
 * @return The resource response's MIME type
 * @apiSince 11
 */

public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the resource response's encoding, for example &quot;UTF-8&quot;. This is used
 * to decode the data from the input stream.
 *
 * @param encoding The resource response's encoding
 * @apiSince 11
 */

public void setEncoding(java.lang.String encoding) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource response's encoding.
 *
 * @return The resource response's encoding
 * @apiSince 11
 */

public java.lang.String getEncoding() { throw new RuntimeException("Stub!"); }

/**
 * Sets the resource response's status code and reason phrase.
 *
 * @param statusCode the status code needs to be in the ranges [100, 299], [400, 599].
 *                   Causing a redirect by specifying a 3xx code is not supported.
 * @param reasonPhrase the phrase describing the status code, for example "OK". Must be
 *                     non-empty.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void setStatusCodeAndReasonPhrase(int statusCode, @androidx.annotation.NonNull java.lang.String reasonPhrase) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource response's status code.
 *
 * @return The resource response's status code.
 * @apiSince 21
 */

public int getStatusCode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the description of the resource response's status code.
 *
 * @return The description of the resource response's status code.
 * @apiSince 21
 */

public java.lang.String getReasonPhrase() { throw new RuntimeException("Stub!"); }

/**
 * Sets the headers for the resource response.
 *
 * @param headers Mapping of header name -> header value.
 * @apiSince 21
 */

public void setResponseHeaders(java.util.Map<java.lang.String,java.lang.String> headers) { throw new RuntimeException("Stub!"); }

/**
 * Gets the headers for the resource response.
 *
 * @return The headers for the resource response.
 * @apiSince 21
 */

public java.util.Map<java.lang.String,java.lang.String> getResponseHeaders() { throw new RuntimeException("Stub!"); }

/**
 * Sets the input stream that provides the resource response's data. Callers
 * must implement {@link java.io.InputStream#read(byte[]) InputStream#read(byte[])}. {@link java.io.InputStream#close() InputStream#close()}
 * will be called after the WebView has finished with the response.
 *
 * @param data the input stream that provides the resource response's data. Must not be a
 *             StringBufferInputStream.
 * @apiSince 11
 */

public void setData(java.io.InputStream data) { throw new RuntimeException("Stub!"); }

/**
 * Gets the input stream that provides the resource response's data.
 *
 * @return The input stream that provides the resource response's data
 * @apiSince 11
 */

public java.io.InputStream getData() { throw new RuntimeException("Stub!"); }
}

