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

import java.util.Calendar;

/**
 * Sorts dates into the following groups:
 *   Today
 *   Yesterday
 *   seven days ago
 *   one month ago
 *   older than a month ago
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DateSorter {

/**
 * @param context Application context
 * @apiSince 1
 */

public DateSorter(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * @param time time since the Epoch in milliseconds, such as that
 * returned by Calendar.getTimeInMillis()
 * @return an index from 0 to (DAY_COUNT - 1) that identifies which
 * date bin this date belongs to
 * @apiSince 1
 */

public int getIndex(long time) { throw new RuntimeException("Stub!"); }

/**
 * @param index date bin index as returned by getIndex()
 * @return string label suitable for display to user
 * @apiSince 1
 */

public java.lang.String getLabel(int index) { throw new RuntimeException("Stub!"); }

/**
 * @param index date bin index as returned by getIndex()
 * @return date boundary at given index
 * @apiSince 1
 */

public long getBoundary(int index) { throw new RuntimeException("Stub!"); }

/**
 * must be >= 3
 * @apiSince 1
 */

public static final int DAY_COUNT = 5; // 0x5
}

