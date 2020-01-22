/*
 * Copyright (C) 2018 The Android Open Source Project
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

package android.app.admin;

import java.time.MonthDay;

/**
 * A class that represents one freeze period which repeats <em>annually</em>. A freeze period has
 * two {@link java.time#MonthDay} values that define the start and end dates of the period, both
 * inclusive. If the end date is earlier than the start date, the period is considered wrapped
 * around the year-end. As far as freeze period is concerned, leap year is disregarded and February
 * 29th should be treated as if it were February 28th: so a freeze starting or ending on February
 * 28th is identical to a freeze starting or ending on February 29th. When calulating the length of
 * a freeze or the distance bewteen two freee periods, February 29th is also ignored.
 *
 * @see android.app.admin.SystemUpdatePolicy#setFreezePeriods
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FreezePeriod {

/**
 * Creates a freeze period by its start and end dates. If the end date is earlier than the start
 * date, the freeze period is considered wrapping year-end.
 * @apiSince 28
 */

public FreezePeriod(java.time.MonthDay start, java.time.MonthDay end) { throw new RuntimeException("Stub!"); }

/**
 * Returns the start date (inclusive) of this freeze period.
 * @apiSince 28
 */

public java.time.MonthDay getStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end date (inclusive) of this freeze period.
 * @apiSince 28
 */

public java.time.MonthDay getEnd() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

