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
 * An instance of this class is passed as a parameter in various {@link android.webkit.WebChromeClient WebChromeClient} action
 * notifications. The object is used as a handle onto the underlying JavaScript-originated request,
 * and provides a means for the client to indicate whether this action should proceed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JsResult {

JsResult() { throw new RuntimeException("Stub!"); }

/**
 * Handle the result if the user cancelled the dialog.
 * @apiSince 1
 */

public final void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Handle a confirmation response from the user.
 * @apiSince 1
 */

public final void confirm() { throw new RuntimeException("Stub!"); }
}

