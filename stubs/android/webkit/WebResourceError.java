/*
 * Copyright (C) 2015 The Android Open Source Project
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
 * Encapsulates information about errors occured during loading of web resources. See
 * {@link android.webkit.WebViewClient#onReceivedError(android.webkit.WebView,android.webkit.WebResourceRequest,android.webkit.WebResourceError) WebViewClient#onReceivedError(WebView, WebResourceRequest, WebResourceError)}
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class WebResourceError {

WebResourceError() { throw new RuntimeException("Stub!"); }

/**
 * Gets the error code of the error. The code corresponds to one
 * of the ERROR_* constants in {@link android.webkit.WebViewClient WebViewClient}.
 *
 * @return The error code of the error
 * @apiSince 23
 */

public abstract int getErrorCode();

/**
 * Gets the string describing the error. Descriptions are localized,
 * and thus can be used for communicating the problem to the user.
 *
 * @return The description of the error
 * @apiSince 23
 */

public abstract java.lang.CharSequence getDescription();
}

