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


package android.net;


/**
 * A class for representing UNIX credentials passed via ancillary data
 * on UNIX domain sockets. See "man 7 unix" on a desktop linux distro.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Credentials {

/** @apiSince 1 */

public Credentials(int pid, int uid, int gid) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getPid() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getUid() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getGid() { throw new RuntimeException("Stub!"); }
}

