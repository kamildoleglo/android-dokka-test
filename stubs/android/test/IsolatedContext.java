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


package android.test;


/**
 * A mock context which prevents its users from talking to the rest of the device while
 * stubbing enough methods to satify code that tries to talk to other packages.
 *
 * @deprecated New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class IsolatedContext extends android.content.ContextWrapper {

/** @apiSince 1 */

@Deprecated
public IsolatedContext(android.content.ContentResolver resolver, android.content.Context targetContext) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the list of intents that were broadcast since the last call to this method.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.util.List<android.content.Intent> getAndClearBroadcastIntents() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public android.content.ContentResolver getContentResolver() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public boolean bindService(android.content.Intent service, android.content.ServiceConnection conn, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 29
 * @deprecatedSince 24
 */

@Deprecated
public boolean bindService(android.content.Intent service, int flags, java.util.concurrent.Executor executor, android.content.ServiceConnection conn) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 29
 * @deprecatedSince 24
 */

@Deprecated
public boolean bindIsolatedService(android.content.Intent service, int flags, java.lang.String instanceName, java.util.concurrent.Executor executor, android.content.ServiceConnection conn) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public android.content.Intent registerReceiver(android.content.BroadcastReceiver receiver, android.content.IntentFilter filter) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void unregisterReceiver(android.content.BroadcastReceiver receiver) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void sendBroadcast(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void sendOrderedBroadcast(android.content.Intent intent, java.lang.String receiverPermission) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public int checkUriPermission(android.net.Uri uri, java.lang.String readPermission, java.lang.String writePermission, int pid, int uid, int modeFlags) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public int checkUriPermission(android.net.Uri uri, int pid, int uid, int modeFlags) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.Object getSystemService(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.io.File getFilesDir() { throw new RuntimeException("Stub!"); }
}

