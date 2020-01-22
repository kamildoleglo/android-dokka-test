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

import android.accounts.AccountManager;
import android.content.Context;

/**
 * A mock {@link android.accounts.AccountManager} class.
 *
 * <p>Provided for use by {@code android.test.IsolatedContext}.
 *
 * @deprecated Use a mocking framework like <a href="https://github.com/mockito/mockito">Mockito</a>.
 * New tests should be written using the
 * <a href="{@docRoot}
 * tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince R
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class MockAccountManager {

private MockAccountManager() { throw new RuntimeException("Stub!"); }

/**
 * Create a new mock {@link android.accounts.AccountManager AccountManager} instance.
 *
 * @param context the {@link android.content.Context Context} to which the returned object belongs.
 * @return the new instance.
 * @apiSince R
 * @deprecatedSince R
 */

@Deprecated
public static android.accounts.AccountManager newMockAccountManager(android.content.Context context) { throw new RuntimeException("Stub!"); }
}

