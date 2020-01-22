/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * Information returned by {@link android.system.Os#uname Os#uname}.
 * Corresponds to C's {@code struct utsname} from {@code <sys/utsname.h>}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StructUtsname {

/**
 * Constructs an instance with the given field values.
 * @apiSince 21
 */

public StructUtsname(java.lang.String sysname, java.lang.String nodename, java.lang.String release, java.lang.String version, java.lang.String machine) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The machine architecture, such as "armv7l" or "x86_64".
 * @apiSince 21
 */

public final java.lang.String machine;
{ machine = null; }

/**
 * The machine's unqualified name on some implementation-defined network.
 * @apiSince 21
 */

public final java.lang.String nodename;
{ nodename = null; }

/**
 * The OS release, such as "2.6.35-27-generic".
 * @apiSince 21
 */

public final java.lang.String release;
{ release = null; }

/**
 * The OS name, such as "Linux".
 * @apiSince 21
 */

public final java.lang.String sysname;
{ sysname = null; }

/**
 * The OS version, such as "#48-Ubuntu SMP Tue Feb 22 20:25:29 UTC 2011".
 * @apiSince 21
 */

public final java.lang.String version;
{ version = null; }
}

