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

import java.io.OutputStream;

/**
 * An OutputStream that does Base64 encoding on the data written to
 * it, writing the resulting data to another OutputStream.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Base64OutputStream extends java.io.FilterOutputStream {

/**
 * Performs Base64 encoding on the data written to the stream,
 * writing the encoded data to another OutputStream.
 *
 * @param out the OutputStream to write the encoded data to
 * @param flags bit flags for controlling the encoder; see the
 *        constants in {@link android.util.Base64 Base64}
 * @apiSince 8
 */

public Base64OutputStream(java.io.OutputStream out, int flags) { super(null); throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void write(int b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void write(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

