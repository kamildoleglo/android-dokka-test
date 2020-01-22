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


package android.util;

import java.io.InputStream;

/**
 * An InputStream that does Base64 decoding on the data read through
 * it.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Base64InputStream extends java.io.FilterInputStream {

/**
 * An InputStream that performs Base64 decoding on the data read
 * from the wrapped stream.
 *
 * @param in the InputStream to read the source data from
 * @param flags bit flags for controlling the decoder; see the
 *        constants in {@link android.util.Base64 Base64}
 * @apiSince 8
 */

public Base64InputStream(java.io.InputStream in, int flags) { super(null); throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void mark(int readlimit) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void reset() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int available() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

