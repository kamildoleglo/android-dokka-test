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


package android.net;

import java.io.File;
import java.io.IOException;

/**
 * File-based cache of established SSL sessions.  When re-establishing a
 * connection to the same server, using an SSL session cache can save some time,
 * power, and bandwidth by skipping directly to an encrypted stream.
 * This is a persistent cache which can span executions of the application.
 *
 * @see android.net.SSLCertificateSocketFactory
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SSLSessionCache {

/**
 * Create a session cache using the specified directory.
 * Individual session entries will be files within the directory.
 * Multiple instances for the same directory share data internally.
 *
 * @param dir to store session files in (created if necessary)
 * @throws java.io.IOException if the cache can't be opened
 * @apiSince 8
 */

public SSLSessionCache(java.io.File dir) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a session cache at the default location for this app.
 * Multiple instances share data internally.
 *
 * @param context for the application
 * @apiSince 8
 */

public SSLSessionCache(android.content.Context context) { throw new RuntimeException("Stub!"); }
}

