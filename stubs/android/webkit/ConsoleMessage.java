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


/**
 * Public class representing a JavaScript console message from WebCore. This could be a issued
 * by a call to one of the <code>console</code> logging functions (e.g.
 * <code>console.log('...')</code>) or a JavaScript error on the  page. To receive notifications
 * of these messages, override the
 * {@link android.webkit.WebChromeClient#onConsoleMessage(android.webkit.ConsoleMessage) WebChromeClient#onConsoleMessage(ConsoleMessage)} function.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConsoleMessage {

/** @apiSince 8 */

public ConsoleMessage(java.lang.String message, java.lang.String sourceId, int lineNumber, android.webkit.ConsoleMessage.MessageLevel msgLevel) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public android.webkit.ConsoleMessage.MessageLevel messageLevel() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public java.lang.String message() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public java.lang.String sourceId() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int lineNumber() { throw new RuntimeException("Stub!"); }
/** @apiSince 8 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum MessageLevel {
/** @apiSince 8 */

TIP,
/** @apiSince 8 */

LOG,
/** @apiSince 8 */

WARNING,
/** @apiSince 8 */

ERROR,
/** @apiSince 8 */

DEBUG;
}

}

