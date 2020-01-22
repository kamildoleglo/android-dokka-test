/*
 * Copyright (C) 2006 The Android Open Source Project
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


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class URLUtil {

public URLUtil() { throw new RuntimeException("Stub!"); }

/**
 * Cleans up (if possible) user-entered web addresses
 * @apiSince 1
 */

public static java.lang.String guessUrl(java.lang.String inUrl) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static java.lang.String composeSearchUrl(java.lang.String inQuery, java.lang.String template, java.lang.String queryPlaceHolder) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static byte[] decode(byte[] url) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is an asset file.
 * @apiSince 1
 */

public static boolean isAssetUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is a proxy url to allow cookieless network
 * requests from a file url.
 * @deprecated Cookieless proxy is no longer supported.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static boolean isCookielessProxyUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is a local file.
 * @apiSince 1
 */

public static boolean isFileUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is an about: url.
 * @apiSince 1
 */

public static boolean isAboutUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is a data: url.
 * @apiSince 1
 */

public static boolean isDataUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is a javascript: url.
 * @apiSince 1
 */

public static boolean isJavaScriptUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is an http: url.
 * @apiSince 1
 */

public static boolean isHttpUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is an https: url.
 * @apiSince 1
 */

public static boolean isHttpsUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is a network url.
 * @apiSince 1
 */

public static boolean isNetworkUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is a content: url.
 * @apiSince 1
 */

public static boolean isContentUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the url is valid.
 * @apiSince 1
 */

public static boolean isValidUrl(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Strips the url of the anchor.
 * @apiSince 1
 */

public static java.lang.String stripAnchor(java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Guesses canonical filename that a download would have, using
 * the URL and contentDisposition. File extension, if not defined,
 * is added based on the mimetype
 * @param url Url to the content
 * @param contentDisposition Content-Disposition HTTP header or {@code null}
 * This value may be {@code null}.
 * @param mimeType Mime-type of the content or {@code null}
 *
 * This value may be {@code null}.
 * @return suggested filename
 * @apiSince 1
 */

public static java.lang.String guessFileName(java.lang.String url, @androidx.annotation.Nullable java.lang.String contentDisposition, @androidx.annotation.Nullable java.lang.String mimeType) { throw new RuntimeException("Stub!"); }
}

