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

package android.test.mock;

import android.app.Service;

/**
 * A mock {@link android.app.Service} class.
 *
 * <p>Provided for use by {@code android.test.ServiceTestCase}.
 *
 * @deprecated Use a mocking framework like <a href="https://github.com/mockito/mockito">Mockito</a>.
 * New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince R
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class MockService {

private MockService() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince R
 * @deprecatedSince R
 */

@Deprecated
public static <T extends android.app.Service> void attachForTesting(android.app.Service service, android.content.Context context, java.lang.String serviceClassName, android.app.Application application) { throw new RuntimeException("Stub!"); }
}

