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


package android.provider;

import android.content.Intent;

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Browser {

public Browser() { throw new RuntimeException("Stub!"); }

/**
 * Sends the given string using an Intent with {@link android.content.Intent#ACTION_SEND Intent#ACTION_SEND} and a mime type
 * of text/plain. The string is put into {@link android.content.Intent#EXTRA_TEXT Intent#EXTRA_TEXT}.
 *
 * @param context the context used to start the activity
 * @param string the string to send
 * @apiSince 1
 */

public static final void sendString(android.content.Context context, java.lang.String string) { throw new RuntimeException("Stub!"); }

/**
 * The name of the extra data when starting the Browser from another
 * application.
 * <p>
 * The value is a unique identification string that will be used to
 * identify the calling application. The Browser will attempt to reuse the
 * same window each time the application launches the Browser with the same
 * identifier.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_APPLICATION_ID = "com.android.browser.application_id";

/**
 * Boolean extra passed along with an Intent to a browser, specifying that
 * a new tab be created.  Overrides EXTRA_APPLICATION_ID; if both are set,
 * a new tab will be used, rather than using the same one.
 * @apiSince 12
 */

public static final java.lang.String EXTRA_CREATE_NEW_TAB = "create_new_tab";

/**
 * The name of the extra data in the VIEW intent. The data are key/value
 * pairs in the format of Bundle. They will be sent in the HTTP request
 * headers for the provided url. The keys can't be the standard HTTP headers
 * as they are set by the WebView. The url's schema must be http(s).
 * <p>
 * @apiSince 8
 */

public static final java.lang.String EXTRA_HEADERS = "com.android.browser.headers";

/**
 * The name of extra data when starting Browser with ACTION_VIEW or
 * ACTION_SEARCH intent.
 * <p>
 * The value should be an integer between 0 and 1000. If not set or set to
 * 0, the Browser will use default. If set to 100, the Browser will start
 * with 100%.
 * @apiSince 1
 */

public static final java.lang.String INITIAL_ZOOM_LEVEL = "browser.initialZoomLevel";
}

