/*
 * Copyright (C) 2014 The Android Open Source Project
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


/**
 * Encompasses parameters to the {@link android.webkit.WebViewClient#shouldInterceptRequest WebViewClient#shouldInterceptRequest} method.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface WebResourceRequest {

/**
 * Gets the URL for which the resource request was made.
 *
 * @return the URL for which the resource request was made.
 * @apiSince 21
 */

public android.net.Uri getUrl();

/**
 * Gets whether the request was made for the main frame.
 *
 * @return whether the request was made for the main frame. Will be {@code false} for iframes,
 *         for example.
 * @apiSince 21
 */

public boolean isForMainFrame();

/**
 * Gets whether the request was a result of a server-side redirect.
 *
 * @return whether the request was a result of a server-side redirect.
 * @apiSince 24
 */

public boolean isRedirect();

/**
 * Gets whether a gesture (such as a click) was associated with the request.
 * For security reasons in certain situations this method may return {@code false} even though
 * the sequence of events which caused the request to be created was initiated by a user
 * gesture.
 *
 * @return whether a gesture was associated with the request.
 * @apiSince 21
 */

public boolean hasGesture();

/**
 * Gets the method associated with the request, for example "GET".
 *
 * @return the method associated with the request.
 * @apiSince 21
 */

public java.lang.String getMethod();

/**
 * Gets the headers associated with the request. These are represented as a mapping of header
 * name to header value.
 *
 * @return the headers associated with the request.
 * @apiSince 21
 */

public java.util.Map<java.lang.String,java.lang.String> getRequestHeaders();
}

