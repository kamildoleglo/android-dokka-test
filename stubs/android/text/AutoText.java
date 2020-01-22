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


package android.text;

import java.util.Locale;
import android.content.res.Resources;
import android.view.View;

/**
 * This class accesses a dictionary of corrections to frequent misspellings.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AutoText {

private AutoText() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a possible spelling correction for the specified range
 * of text.  Returns null if no correction can be found.
 * The View is used to get the current Locale and Resources.
 * @apiSince 1
 */

public static java.lang.String get(java.lang.CharSequence src, int start, int end, android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the auto text dictionary. The return value can be zero if there is
 * no auto correction data available for the current locale.
 * @param view used to retrieve the current Locale and Resources.
 * @return the number of entries in the auto text dictionary
 * @apiSince 3
 */

public static int getSize(android.view.View view) { throw new RuntimeException("Stub!"); }
}

