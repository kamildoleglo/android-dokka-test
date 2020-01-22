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


package android.util;


/**
 * <p>Various utilities for debugging and logging.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DebugUtils {

DebugUtils() { throw new RuntimeException("Stub!"); }

/**
 * <p>Filters objects against the <code>ANDROID_OBJECT_FILTER</code>
 * environment variable. This environment variable can filter objects
 * based on their class name and attribute values.</p>
 *
 * <p>Here is the syntax for <code>ANDROID_OBJECT_FILTER</code>:</p>
 *
 * <p><code>ClassName@attribute1=value1@attribute2=value2...</code></p>
 *
 * <p>Examples:</p>
 * <ul>
 * <li>Select TextView instances: <code>TextView</code></li>
 * <li>Select TextView instances of text "Loading" and bottom offset of 22:
 * <code>TextView@text=Loading.*@bottom=22</code></li>
 * </ul>
 *
 * <p>The class name and the values are regular expressions.</p>
 *
 * <p>This class is useful for debugging and logging purpose:</p>
 * <pre>
 * if (DEBUG) {
 *   if (DebugUtils.isObjectSelected(childView) && LOGV_ENABLED) {
 *     Log.v(TAG, "Object " + childView + " logged!");
 *   }
 * }
 * </pre>
 *
 * <p><strong>NOTE</strong>: This method is very expensive as it relies
 * heavily on regular expressions and reflection. Calls to this method
 * should always be stripped out of the release binaries and avoided
 * as much as possible in debug mode.</p>
 *
 * @param object any object to match against the ANDROID_OBJECT_FILTER
 *        environement variable
 * @return true if object is selected by the ANDROID_OBJECT_FILTER
 *         environment variable, false otherwise
 * @apiSince 1
 */

public static boolean isObjectSelected(java.lang.Object object) { throw new RuntimeException("Stub!"); }
}

