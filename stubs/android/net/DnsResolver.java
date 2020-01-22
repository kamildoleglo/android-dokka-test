/*
 * Copyright (C) 2019 The Android Open Source Project
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

import java.util.concurrent.Executor;
import android.system.ErrnoException;

/**
 * Dns resolver class for asynchronous dns querying
 *
 * Note that if a client sends a query with more than 1 record in the question section but
 * the remote dns server does not support this, it may not respond at all, leading to a timeout.
 *
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DnsResolver {

private DnsResolver() { throw new RuntimeException("Stub!"); }

/**
 * Get instance for DnsResolver
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.net.DnsResolver getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Send a raw DNS query.
 * The answer will be provided asynchronously through the provided {@link android.net.DnsResolver.Callback Callback}.
 *
 * @param network {@link android.net.Network Network} specifying which network to query on.
 *         {@code null} for query on default network.
 * This value may be {@code null}.
 * @param query blob message to query
 * This value must never be {@code null}.
 * @param flags flags as a combination of the FLAGS_* constants
 * Value is {@link android.net.DnsResolver#FLAG_EMPTY}, {@link android.net.DnsResolver#FLAG_NO_RETRY}, {@link android.net.DnsResolver#FLAG_NO_CACHE_STORE}, or {@link android.net.DnsResolver#FLAG_NO_CACHE_LOOKUP}
 * @param executor The {@link java.util.concurrent.Executor Executor} that the callback should be executed on.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param cancellationSignal used by the caller to signal if the query should be
 *    cancelled. May be {@code null}.
 * This value may be {@code null}.
 * @param callback a {@link android.net.DnsResolver.Callback Callback} which will be called to notify the caller
 *    of the result of dns query.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void rawQuery(@androidx.annotation.Nullable android.net.Network network, @androidx.annotation.NonNull byte[] query, int flags, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.net.DnsResolver.Callback<? super byte[]> callback) { throw new RuntimeException("Stub!"); }

/**
 * Send a DNS query with the specified name, class and query type.
 * The answer will be provided asynchronously through the provided {@link android.net.DnsResolver.Callback Callback}.
 *
 * @param network {@link android.net.Network Network} specifying which network to query on.
 *         {@code null} for query on default network.
 * This value may be {@code null}.
 * @param domain domain name to query
 * This value must never be {@code null}.
 * @param nsClass dns class as one of the CLASS_* constants
 * Value is {@link android.net.DnsResolver#CLASS_IN}
 * @param nsType dns resource record (RR) type as one of the TYPE_* constants
 * Value is {@link android.net.DnsResolver#TYPE_A}, or {@link android.net.DnsResolver#TYPE_AAAA}
 * @param flags flags as a combination of the FLAGS_* constants
 * Value is {@link android.net.DnsResolver#FLAG_EMPTY}, {@link android.net.DnsResolver#FLAG_NO_RETRY}, {@link android.net.DnsResolver#FLAG_NO_CACHE_STORE}, or {@link android.net.DnsResolver#FLAG_NO_CACHE_LOOKUP}
 * @param executor The {@link java.util.concurrent.Executor Executor} that the callback should be executed on.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param cancellationSignal used by the caller to signal if the query should be
 *    cancelled. May be {@code null}.
 * This value may be {@code null}.
 * @param callback a {@link android.net.DnsResolver.Callback Callback} which will be called to notify the caller
 *    of the result of dns query.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void rawQuery(@androidx.annotation.Nullable android.net.Network network, @androidx.annotation.NonNull java.lang.String domain, int nsClass, int nsType, int flags, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.net.DnsResolver.Callback<? super byte[]> callback) { throw new RuntimeException("Stub!"); }

/**
 * Send a DNS query with the specified name on a network with both IPv4 and IPv6,
 * get back a set of InetAddresses with rfc6724 sorting style asynchronously.
 *
 * This method will examine the connection ability on given network, and query IPv4
 * and IPv6 if connection is available.
 *
 * If at least one query succeeded with valid answer, rcode will be 0
 *
 * The answer will be provided asynchronously through the provided {@link android.net.DnsResolver.Callback Callback}.
 *
 * @param network {@link android.net.Network Network} specifying which network to query on.
 *         {@code null} for query on default network.
 * This value may be {@code null}.
 * @param domain domain name to query
 * This value must never be {@code null}.
 * @param flags flags as a combination of the FLAGS_* constants
 * Value is {@link android.net.DnsResolver#FLAG_EMPTY}, {@link android.net.DnsResolver#FLAG_NO_RETRY}, {@link android.net.DnsResolver#FLAG_NO_CACHE_STORE}, or {@link android.net.DnsResolver#FLAG_NO_CACHE_LOOKUP}
 * @param executor The {@link java.util.concurrent.Executor Executor} that the callback should be executed on.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param cancellationSignal used by the caller to signal if the query should be
 *    cancelled. May be {@code null}.
 * This value may be {@code null}.
 * @param callback a {@link android.net.DnsResolver.Callback Callback} which will be called to notify the
 *    caller of the result of dns query.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void query(@androidx.annotation.Nullable android.net.Network network, @androidx.annotation.NonNull java.lang.String domain, int flags, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.net.DnsResolver.Callback<? super java.util.List<java.net.InetAddress>> callback) { throw new RuntimeException("Stub!"); }

/**
 * Send a DNS query with the specified name and query type, get back a set of
 * InetAddresses with rfc6724 sorting style asynchronously.
 *
 * The answer will be provided asynchronously through the provided {@link android.net.DnsResolver.Callback Callback}.
 *
 * @param network {@link android.net.Network Network} specifying which network to query on.
 *         {@code null} for query on default network.
 * This value may be {@code null}.
 * @param domain domain name to query
 * This value must never be {@code null}.
 * @param nsType dns resource record (RR) type as one of the TYPE_* constants
 * Value is {@link android.net.DnsResolver#TYPE_A}, or {@link android.net.DnsResolver#TYPE_AAAA}
 * @param flags flags as a combination of the FLAGS_* constants
 * Value is {@link android.net.DnsResolver#FLAG_EMPTY}, {@link android.net.DnsResolver#FLAG_NO_RETRY}, {@link android.net.DnsResolver#FLAG_NO_CACHE_STORE}, or {@link android.net.DnsResolver#FLAG_NO_CACHE_LOOKUP}
 * @param executor The {@link java.util.concurrent.Executor Executor} that the callback should be executed on.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param cancellationSignal used by the caller to signal if the query should be
 *    cancelled. May be {@code null}.
 * This value may be {@code null}.
 * @param callback a {@link android.net.DnsResolver.Callback Callback} which will be called to notify the caller
 *    of the result of dns query.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void query(@androidx.annotation.Nullable android.net.Network network, @androidx.annotation.NonNull java.lang.String domain, int nsType, int flags, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.net.DnsResolver.Callback<? super java.util.List<java.net.InetAddress>> callback) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public static final int CLASS_IN = 1; // 0x1

/**
 * Indicates that there was an error parsing the response the query.
 * The cause of this error is available via getCause() and is a ParseException.
 * @apiSince 29
 */

public static final int ERROR_PARSE = 0; // 0x0

/**
 * Indicates that there was an error sending the query.
 * The cause of this error is available via getCause() and is an ErrnoException.
 * @apiSince 29
 */

public static final int ERROR_SYSTEM = 1; // 0x1

/** @apiSince 29 */

public static final int FLAG_EMPTY = 0; // 0x0

/** @apiSince 29 */

public static final int FLAG_NO_CACHE_LOOKUP = 4; // 0x4

/** @apiSince 29 */

public static final int FLAG_NO_CACHE_STORE = 2; // 0x2

/** @apiSince 29 */

public static final int FLAG_NO_RETRY = 1; // 0x1

/** @apiSince 29 */

public static final int TYPE_A = 1; // 0x1

/** @apiSince 29 */

public static final int TYPE_AAAA = 28; // 0x1c
/**
 * Base interface for answer callbacks
 *
 * @param <T> The type of the answer
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback<T> {

/**
 * Success response to
 * {@link android.net.DnsResolver#query query()} or
 * {@link android.net.DnsResolver#rawQuery rawQuery()}.
 *
 * Invoked when the answer to a query was successfully parsed.
 *
 * @param answer <T> answer to the query.
 * This value must never be {@code null}.
 * @param rcode The response code in the DNS response.
 *
 * {@see android.net.DnsResolver#query query()}
 * @apiSince 29
 */

public void onAnswer(@androidx.annotation.NonNull T answer, int rcode);

/**
 * Error response to
 * {@link android.net.DnsResolver#query query()} or
 * {@link android.net.DnsResolver#rawQuery rawQuery()}.
 *
 * Invoked when there is no valid answer to
 * {@link android.net.DnsResolver#query query()}
 * {@link android.net.DnsResolver#rawQuery rawQuery()}.
 *
 * @param error a {@link android.net.DnsResolver.DnsException DnsException} object with additional
 *    detail regarding the failure
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onError(@androidx.annotation.NonNull android.net.DnsResolver.DnsException error);
}

/**
 * Class to represent DNS error
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DnsException extends java.lang.Exception {

DnsException() { throw new RuntimeException("Stub!"); }

/**
 * DNS error code as one of the ERROR_* constants
 
 * <br>
 * Value is {@link android.net.DnsResolver#ERROR_PARSE}, or {@link android.net.DnsResolver#ERROR_SYSTEM}
 * @apiSince 29
 */

public final int code;
{ code = 0; }
}

}

