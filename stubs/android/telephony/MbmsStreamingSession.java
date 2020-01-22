/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.telephony;

import android.content.Context;
import android.telephony.mbms.MbmsStreamingSessionCallback;
import java.util.concurrent.Executor;
import android.telephony.mbms.StreamingService;
import java.util.List;
import android.telephony.mbms.StreamingServiceCallback;
import android.telephony.mbms.MbmsErrors;

/**
 * This class provides functionality for streaming media over MBMS.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MbmsStreamingSession implements java.lang.AutoCloseable {

private MbmsStreamingSession() { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.telephony.MbmsStreamingSession MbmsStreamingSession} using the given subscription ID.
 *
 * Note that this call will bind a remote service. You may not call this method on your app's
 * main thread.
 *
 * You may only have one instance of {@link android.telephony.MbmsStreamingSession MbmsStreamingSession} per UID. If you call this
 * method while there is an active instance of {@link android.telephony.MbmsStreamingSession MbmsStreamingSession} in your process
 * (in other words, one that has not had {@link #close()} called on it), this method will
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. If you call this method in a different process
 * running under the same UID, an error will be indicated via
 * {@link android.telephony.mbms.MbmsStreamingSessionCallback#onError(int,java.lang.String) MbmsStreamingSessionCallback#onError(int, String)}.
 *
 * Note that initialization may fail asynchronously. If you wish to try again after you
 * receive such an asynchronous error, you must call {@link #close()} on the instance of
 * {@link android.telephony.MbmsStreamingSession MbmsStreamingSession} that you received before calling this method again.
 *
 * @param context The {@link android.content.Context Context} to use.
 * This value must never be {@code null}.
 * @param executor The executor on which you wish to execute callbacks.
 * This value must never be {@code null}.
 * @param subscriptionId The subscription ID to use.
 * @param callback A callback object on which you wish to receive results of asynchronous
 *                 operations.
 * This value must never be {@code null}.
 * @return An instance of {@link android.telephony.MbmsStreamingSession MbmsStreamingSession}, or null if an error occurred.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public static android.telephony.MbmsStreamingSession create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.concurrent.Executor executor, int subscriptionId, @androidx.annotation.NonNull android.telephony.mbms.MbmsStreamingSessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.telephony.MbmsStreamingSession MbmsStreamingSession} using the system default data subscription ID.
 * See {@link #create(android.content.Context,java.util.concurrent.Executor,int,android.telephony.mbms.MbmsStreamingSessionCallback)}.
 
 * @param context This value must never be {@code null}.
 
 * @param executor This value must never be {@code null}.
 
 * @param callback This value must never be {@code null}.
 * @apiSince 28
 */

public static android.telephony.MbmsStreamingSession create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.mbms.MbmsStreamingSessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Terminates this instance. Also terminates
 * any streaming services spawned from this instance as if
 * {@link android.telephony.mbms.StreamingService#close() StreamingService#close()} had been called on them. After this method returns,
 * no further callbacks originating from the middleware will be enqueued on the provided
 * instance of {@link android.telephony.mbms.MbmsStreamingSessionCallback MbmsStreamingSessionCallback}, but callbacks that have already been
 * enqueued will still be delivered.
 *
 * It is safe to call {@link #create(android.content.Context,java.util.concurrent.Executor,int,android.telephony.mbms.MbmsStreamingSessionCallback)} to
 * obtain another instance of {@link android.telephony.MbmsStreamingSession MbmsStreamingSession} immediately after this method
 * returns.
 *
 * May throw an {@link java.lang.IllegalStateException IllegalStateException}
 * @apiSince 28
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * An inspection API to retrieve the list of streaming media currently be advertised.
 * The results are returned asynchronously via
 * {@link android.telephony.mbms.MbmsStreamingSessionCallback#onStreamingServicesUpdated(java.util.List) MbmsStreamingSessionCallback#onStreamingServicesUpdated(List)} on the callback
 * provided upon creation.
 *
 * Multiple calls replace the list of service classes of interest.
 *
 * May throw an {@link java.lang.IllegalArgumentException IllegalArgumentException} or an {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * @param serviceClassList A list of streaming service classes that the app would like updates
 *                         on. The exact names of these classes should be negotiated with the
 *                         wireless carrier separately.
 * @apiSince 28
 */

public void requestUpdateStreamingServices(java.util.List<java.lang.String> serviceClassList) { throw new RuntimeException("Stub!"); }

/**
 * Starts streaming a requested service, reporting status to the indicated callback.
 * Returns an object used to control that stream. The stream may not be ready for consumption
 * immediately upon return from this method -- wait until the streaming state has been
 * reported via
 * {@link android.telephony.mbms.StreamingServiceCallback#onStreamStateUpdated(int, int)}
 *
 * May throw an {@link java.lang.IllegalArgumentException IllegalArgumentException} or an {@link java.lang.IllegalStateException IllegalStateException}
 *
 * Asynchronous errors through the callback include any of the errors in
 * {@link android.telephony.mbms.MbmsErrors.GeneralErrors MbmsErrors.GeneralErrors} or
 * {@link android.telephony.mbms.MbmsErrors.StreamingErrors MbmsErrors.StreamingErrors}.
 *
 * @param serviceInfo The information about the service to stream.
 * @param executor The executor on which you wish to execute callbacks for this stream.
 * This value must never be {@code null}.
 * @param callback A callback that'll be called when something about the stream changes.
 * @return An instance of {@link android.telephony.mbms.StreamingService StreamingService} through which the stream can be controlled.
 *         May be {@code null} if an error occurred.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.telephony.mbms.StreamingService startStreaming(android.telephony.mbms.StreamingServiceInfo serviceInfo, @androidx.annotation.NonNull java.util.concurrent.Executor executor, android.telephony.mbms.StreamingServiceCallback callback) { throw new RuntimeException("Stub!"); }
}

