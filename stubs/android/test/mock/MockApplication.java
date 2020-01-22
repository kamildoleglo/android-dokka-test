/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.app.Application;

/**
 * A mock {@link android.app.Application} class.  All methods are non-functional and throw
 * {@link java.lang.UnsupportedOperationException}.  Override it as necessary to provide the
 * operations that you need.
 *
 * @deprecated Use a mocking framework like <a href="https://github.com/mockito/mockito">Mockito</a>.
 * New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class MockApplication extends android.app.Application {

/** @apiSince 1 */

@Deprecated
public MockApplication() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void onTerminate() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }
}

