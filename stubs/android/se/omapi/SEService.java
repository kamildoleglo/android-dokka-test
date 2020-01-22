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
/*
 * Copyright (c) 2015-2017, The Linux Foundation. All rights reserved.
 */
/*
 * Contributed by: Giesecke & Devrient GmbH.
 */


package android.se.omapi;

import java.util.concurrent.Executor;

/**
 * The SEService realises the communication to available Secure Elements on the
 * device. This is the entry point of this API. It is used to connect to the
 * infrastructure and get access to a list of Secure Element Readers.
 *
 * @see <a href="http://simalliance.org">SIMalliance Open Mobile API  v3.0</a>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SEService {

/**
 * Establishes a new connection that can be used to connect to all the
 * Secure Elements available in the system. The connection process can be
 * quite long, so it happens in an asynchronous way. It is usable only if
 * the specified listener is called or if isConnected() returns
 * <code>true</code>. <br>
 * The call-back object passed as a parameter will have its
 * onConnected() method called when the connection actually happen.
 *
 * @param context
 *            the context of the calling application. Cannot be
 *            <code>null</code>.
 * This value must never be {@code null}.
 * @param listener
 *            a OnConnectedListener object.
 * This value must never be {@code null}.
 * @param executor
 *            an Executor which will be used when invoking the callback.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public SEService(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.se.omapi.SEService.OnConnectedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not the service is connected.
 *
 * @return <code>true</code> if the service is connected.
 * @apiSince 28
 */

public boolean isConnected() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of available Secure Element readers.
 * There must be no duplicated objects in the returned list.
 * All available readers shall be listed even if no card is inserted.
 *
 * @return An array of Readers. If there are no readers the returned array
 * is of length 0.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.se.omapi.Reader[] getReaders() { throw new RuntimeException("Stub!"); }

/**
 * Releases all Secure Elements resources allocated by this SEService
 * (including any binding to an underlying service).
 * As a result isConnected() will return false after shutdown() was called.
 * After this method call, the SEService object is not connected.
 * This method should be called when connection to the Secure Element is not needed
 * or in the termination method of the calling application
 * (or part of this application) which is bound to this SEService.
 * @apiSince 28
 */

public void shutdown() { throw new RuntimeException("Stub!"); }

/**
 * Returns the version of the OpenMobile API specification this
 * implementation is based on.
 *
 * @return String containing the OpenMobile API version (e.g. "3.0").
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getVersion() { throw new RuntimeException("Stub!"); }
/**
 * Interface to send call-backs to the application when the service is connected.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnConnectedListener {

/**
 * Called by the framework when the service is connected.
 * @apiSince 28
 */

public void onConnected();
}

}

