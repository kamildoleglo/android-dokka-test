/*
 * Copyright (C) 2018 The Android Open Source Project
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
import android.telephony.mbms.MbmsGroupCallSessionCallback;
import java.util.concurrent.Executor;
import android.telephony.mbms.GroupCall;
import android.telephony.mbms.MbmsErrors;

/**
 * This class provides functionality for accessing group call functionality over MBMS.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MbmsGroupCallSession implements java.lang.AutoCloseable {

private MbmsGroupCallSession() { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.telephony.MbmsGroupCallSession MbmsGroupCallSession} using the given subscription ID.
 *
 * You may only have one instance of {@link android.telephony.MbmsGroupCallSession MbmsGroupCallSession} per UID. If you call this
 * method while there is an active instance of {@link android.telephony.MbmsGroupCallSession MbmsGroupCallSession} in your process
 * (in other words, one that has not had {@link #close()} called on it), this method will
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. If you call this method in a different process
 * running under the same UID, an error will be indicated via
 * {@link android.telephony.mbms.MbmsGroupCallSessionCallback#onError(int,java.lang.String) MbmsGroupCallSessionCallback#onError(int, String)}.
 *
 * Note that initialization may fail asynchronously. If you wish to try again after you
 * receive such an asynchronous error, you must call {@link #close()} on the instance of
 * {@link android.telephony.MbmsGroupCallSession MbmsGroupCallSession} that you received before calling this method again.
 *
 * @param context The {@link android.content.Context Context} to use.
 * This value must never be {@code null}.
 * @param subscriptionId The subscription ID to use.
 * @param executor The executor on which you wish to execute callbacks.
 * This value must never be {@code null}.
 * @param callback A callback object on which you wish to receive results of asynchronous
 *                 operations.
 * This value must never be {@code null}.
 * @return An instance of {@link android.telephony.MbmsGroupCallSession MbmsGroupCallSession}, or null if an error occurred.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public static android.telephony.MbmsGroupCallSession create(@androidx.annotation.NonNull android.content.Context context, int subscriptionId, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.mbms.MbmsGroupCallSessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.telephony.MbmsGroupCallSession MbmsGroupCallSession} using the system default data subscription ID.
 * See {@link #create(android.content.Context,int,java.util.concurrent.Executor,android.telephony.mbms.MbmsGroupCallSessionCallback)}.
 
 * @param context This value must never be {@code null}.
 * @param executor This value must never be {@code null}.
 * @param callback This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public static android.telephony.MbmsGroupCallSession create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.mbms.MbmsGroupCallSessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Terminates this instance. Also terminates
 * any group calls spawned from this instance as if
 * {@link android.telephony.mbms.GroupCall#close() GroupCall#close()} had been called on them. After this method returns,
 * no further callbacks originating from the middleware will be enqueued on the provided
 * instance of {@link android.telephony.mbms.MbmsGroupCallSessionCallback MbmsGroupCallSessionCallback}, but callbacks that have already been
 * enqueued will still be delivered.
 *
 * It is safe to call {@link #create(android.content.Context,int,java.util.concurrent.Executor,android.telephony.mbms.MbmsGroupCallSessionCallback)} to
 * obtain another instance of {@link android.telephony.MbmsGroupCallSession MbmsGroupCallSession} immediately after this method
 * returns.
 *
 * May throw an {@link java.lang.IllegalStateException IllegalStateException}
 * @apiSince 29
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Starts the requested group call, reporting status to the indicated callback.
 * Returns an object used to control that call.
 *
 * May throw an {@link java.lang.IllegalArgumentException IllegalArgumentException} or an {@link java.lang.IllegalStateException IllegalStateException}
 *
 * Asynchronous errors through the callback include any of the errors in
 * {@link android.telephony.mbms.MbmsErrors.GeneralErrors MbmsErrors.GeneralErrors}.
 *
 * @param tmgi The TMGI, an identifier for the group call you want to join.
 * @param saiList A list of SAIs for the group call that should be negotiated separately with
 *                the carrier.
 * This value must never be {@code null}.
 * @param frequencyList A lost of frequencies for the group call that should be negotiated
 *                separately with the carrier.
 * This value must never be {@code null}.
 * @param executor The executor on which you wish to execute callbacks for this stream.
 * This value must never be {@code null}.
 * @param callback The callback that you want to receive information about the call on.
 * This value must never be {@code null}.
 * @return An instance of {@link android.telephony.mbms.GroupCall GroupCall} through which the call can be controlled.
 *         May be {@code null} if an error occurred.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.telephony.mbms.GroupCall startGroupCall(long tmgi, @androidx.annotation.NonNull java.util.List<java.lang.Integer> saiList, @androidx.annotation.NonNull java.util.List<java.lang.Integer> frequencyList, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.mbms.GroupCallCallback callback) { throw new RuntimeException("Stub!"); }
}

