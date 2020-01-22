/*
 * Copyright (C) 2007 The Android Open Source Project
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
 * Public class for handling JavaScript prompt requests. The WebChromeClient will receive a
 * {@link android.webkit.WebChromeClient#onJsPrompt(android.webkit.WebView,java.lang.String,java.lang.String,java.lang.String,android.webkit.JsPromptResult) WebChromeClient#onJsPrompt(WebView, String, String, String, JsPromptResult)} call with a
 * JsPromptResult instance as a parameter. This parameter is used to return the result of this user
 * dialog prompt back to the WebView instance. The client can call cancel() to cancel the dialog or
 * confirm() with the user's input to confirm the dialog.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JsPromptResult extends android.webkit.JsResult {

JsPromptResult() { throw new RuntimeException("Stub!"); }

/**
 * Handle a confirmation response from the user.
 * @apiSince 1
 */

public void confirm(java.lang.String result) { throw new RuntimeException("Stub!"); }
}

