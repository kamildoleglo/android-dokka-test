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
 * limitations under the License
 */


package android.test;

import android.content.Loader;

/**
 * A convenience class for testing {@link android.content.Loader Loader}s. This test case
 * provides a simple way to synchronously get the result from a Loader making
 * it easy to assert that the Loader returns the expected result.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LoaderTestCase extends android.test.AndroidTestCase {

public LoaderTestCase() { throw new RuntimeException("Stub!"); }

/**
 * Runs a Loader synchronously and returns the result of the load. The loader will
 * be started, stopped, and destroyed by this method so it cannot be reused.
 *
 * @param loader The loader to run synchronously
 * @return The result from the loader
 * @apiSince 11
 */

public <T> T getLoaderResultSynchronously(android.content.Loader<T> loader) { throw new RuntimeException("Stub!"); }
}

