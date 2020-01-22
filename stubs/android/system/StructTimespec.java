/*
 * Copyright (C) 2017 The Android Open Source Project
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



package android.system;


/**
 * Corresponds to C's {@code struct timespec} from {@code <time.h>}.
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StructTimespec implements java.lang.Comparable<android.system.StructTimespec> {

/** @apiSince 27 */

public StructTimespec(long tv_sec, long tv_nsec) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public int compareTo(android.system.StructTimespec other) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Nanoseconds (values are [0, 999999999]).
 * @apiSince 27
 */

public final long tv_nsec;
{ tv_nsec = 0; }

/**
 * Seconds part of time of last data modification.
 * @apiSince 27
 */

public final long tv_sec;
{ tv_sec = 0; }
}

