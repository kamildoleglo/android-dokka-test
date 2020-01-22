/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.app.usage.NetworkStatsManager;
import android.app.DownloadManager;
import java.net.Socket;
import java.net.DatagramSocket;
import java.io.FileDescriptor;
import android.os.Build;

/**
 * Class that provides network traffic statistics. These statistics include
 * bytes transmitted and received and network packets transmitted and received,
 * over all interfaces, over the mobile interface, and on a per-UID basis.
 * <p>
 * These statistics may not be available on all platforms. If the statistics are
 * not supported by this device, {@link #UNSUPPORTED} will be returned.
 * <p>
 * Note that the statistics returned by this class reset and start from zero
 * after every reboot. To access more robust historical network statistics data,
 * use {@link android.app.usage.NetworkStatsManager NetworkStatsManager} instead.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TrafficStats {

public TrafficStats() { throw new RuntimeException("Stub!"); }

/**
 * Set active tag to use when accounting {@link java.net.Socket Socket} traffic originating
 * from the current thread. Only one active tag per thread is supported.
 * <p>
 * Changes only take effect during subsequent calls to
 * {@link #tagSocket(java.net.Socket)}.
 * <p>
 * Tags between {@code 0xFFFFFF00} and {@code 0xFFFFFFFF} are reserved and
 * used internally by system services like {@link android.app.DownloadManager DownloadManager} when
 * performing traffic on behalf of an application.
 *
 * @see #clearThreadStatsTag()
 * @apiSince 14
 */

public static void setThreadStatsTag(int tag) { throw new RuntimeException("Stub!"); }

/**
 * Set active tag to use when accounting {@link java.net.Socket Socket} traffic originating
 * from the current thread. Only one active tag per thread is supported.
 * <p>
 * Changes only take effect during subsequent calls to
 * {@link #tagSocket(java.net.Socket)}.
 * <p>
 * Tags between {@code 0xFFFFFF00} and {@code 0xFFFFFFFF} are reserved and
 * used internally by system services like {@link android.app.DownloadManager DownloadManager} when
 * performing traffic on behalf of an application.
 *
 * @return the current tag for the calling thread, which can be used to
 *         restore any existing values after a nested operation is finished
 * @apiSince 26
 */

public static int getAndSetThreadStatsTag(int tag) { throw new RuntimeException("Stub!"); }

/**
 * Get the active tag used when accounting {@link java.net.Socket Socket} traffic originating
 * from the current thread. Only one active tag per thread is supported.
 * {@link #tagSocket(java.net.Socket)}.
 *
 * @see #setThreadStatsTag(int)
 * @apiSince 14
 */

public static int getThreadStatsTag() { throw new RuntimeException("Stub!"); }

/**
 * Clear any active tag set to account {@link java.net.Socket Socket} traffic originating
 * from the current thread.
 *
 * @see #setThreadStatsTag(int)
 * @apiSince 14
 */

public static void clearThreadStatsTag() { throw new RuntimeException("Stub!"); }

/**
 * Set specific UID to use when accounting {@link java.net.Socket Socket} traffic
 * originating from the current thread. Designed for use when performing an
 * operation on behalf of another application, or when another application
 * is performing operations on your behalf.
 * <p>
 * Any app can <em>accept</em> blame for traffic performed on a socket
 * originally created by another app by calling this method with the
 * {@link android.system.Os#getuid()} value. However, only apps holding the
 * {@code android.Manifest.permission#UPDATE_DEVICE_STATS} permission may
 * <em>assign</em> blame to another UIDs.
 * <p>
 * Changes only take effect during subsequent calls to
 * {@link #tagSocket(java.net.Socket)}.
 * @apiSince 28
 */

public static void setThreadStatsUid(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Get the active UID used when accounting {@link java.net.Socket Socket} traffic originating
 * from the current thread. Only one active tag per thread is supported.
 * {@link #tagSocket(java.net.Socket)}.
 *
 * @see #setThreadStatsUid(int)
 * @apiSince 28
 */

public static int getThreadStatsUid() { throw new RuntimeException("Stub!"); }

/**
 * Clear any active UID set to account {@link java.net.Socket Socket} traffic originating
 * from the current thread.
 *
 * @see #setThreadStatsUid(int)
 * @apiSince 28
 */

public static void clearThreadStatsUid() { throw new RuntimeException("Stub!"); }

/**
 * Tag the given {@link java.net.Socket Socket} with any statistics parameters active for
 * the current thread. Subsequent calls always replace any existing
 * parameters. When finished, call {@link #untagSocket(java.net.Socket)} to remove
 * statistics parameters.
 *
 * @see #setThreadStatsTag(int)
 * @apiSince 14
 */

public static void tagSocket(java.net.Socket socket) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Remove any statistics parameters from the given {@link java.net.Socket Socket}.
 * <p>
 * In Android 8.1 (API level 27) and lower, a socket is automatically
 * untagged when it's sent to another process using binder IPC with a
 * {@code ParcelFileDescriptor} container. In Android 9.0 (API level 28)
 * and higher, the socket tag is kept when the socket is sent to another
 * process using binder IPC. You can mimic the previous behavior by
 * calling {@code untagSocket()} before sending the socket to another
 * process.
 * @apiSince 14
 */

public static void untagSocket(java.net.Socket socket) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Tag the given {@link java.net.DatagramSocket DatagramSocket} with any statistics parameters
 * active for the current thread. Subsequent calls always replace any
 * existing parameters. When finished, call
 * {@link #untagDatagramSocket(java.net.DatagramSocket)} to remove statistics
 * parameters.
 *
 * @see #setThreadStatsTag(int)
 * @apiSince 24
 */

public static void tagDatagramSocket(java.net.DatagramSocket socket) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Remove any statistics parameters from the given {@link java.net.DatagramSocket DatagramSocket}.
 * @apiSince 24
 */

public static void untagDatagramSocket(java.net.DatagramSocket socket) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Tag the given {@link java.io.FileDescriptor FileDescriptor} socket with any statistics
 * parameters active for the current thread. Subsequent calls always replace
 * any existing parameters. When finished, call
 * {@link #untagFileDescriptor(java.io.FileDescriptor)} to remove statistics
 * parameters.
 *
 * @see #setThreadStatsTag(int)
 * @apiSince 28
 */

public static void tagFileDescriptor(java.io.FileDescriptor fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Remove any statistics parameters from the given {@link java.io.FileDescriptor FileDescriptor}
 * socket.
 * @apiSince 28
 */

public static void untagFileDescriptor(java.io.FileDescriptor fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Increment count of network operations performed under the accounting tag
 * currently active on the calling thread. This can be used to derive
 * bytes-per-operation.
 *
 * @param operationCount Number of operations to increment count by.
 * @apiSince 14
 */

public static void incrementOperationCount(int operationCount) { throw new RuntimeException("Stub!"); }

/**
 * Increment count of network operations performed under the given
 * accounting tag. This can be used to derive bytes-per-operation.
 *
 * @param tag Accounting tag used in {@link #setThreadStatsTag(int)}.
 * @param operationCount Number of operations to increment count by.
 * @apiSince 14
 */

public static void incrementOperationCount(int tag, int operationCount) { throw new RuntimeException("Stub!"); }

/**
 * Return number of packets transmitted across mobile networks since device
 * boot. Counts packets across all mobile network interfaces, and always
 * increases monotonically since device boot. Statistics are measured at the
 * network layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getMobileTxPackets() { throw new RuntimeException("Stub!"); }

/**
 * Return number of packets received across mobile networks since device
 * boot. Counts packets across all mobile network interfaces, and always
 * increases monotonically since device boot. Statistics are measured at the
 * network layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getMobileRxPackets() { throw new RuntimeException("Stub!"); }

/**
 * Return number of bytes transmitted across mobile networks since device
 * boot. Counts packets across all mobile network interfaces, and always
 * increases monotonically since device boot. Statistics are measured at the
 * network layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getMobileTxBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return number of bytes received across mobile networks since device boot.
 * Counts packets across all mobile network interfaces, and always increases
 * monotonically since device boot. Statistics are measured at the network
 * layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getMobileRxBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of packets transmitted on the specified interface since
 * device boot. Statistics are measured at the network layer, so both TCP and
 * UDP usage are included.
 *
 * @param iface The name of the interface.
 * This value must never be {@code null}.
 * @return The number of transmitted packets.
 * @apiSince R
 */

public static long getTxPackets(@androidx.annotation.NonNull java.lang.String iface) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of packets received on the specified interface since
 * device boot. Statistics are measured at the network layer, so both TCP
 * and UDP usage are included.
 *
 * @param iface The name of the interface.
 * This value must never be {@code null}.
 * @return The number of received packets.
 * @apiSince R
 */

public static long getRxPackets(@androidx.annotation.NonNull java.lang.String iface) { throw new RuntimeException("Stub!"); }

/**
 * Return number of packets transmitted since device boot. Counts packets
 * across all network interfaces, and always increases monotonically since
 * device boot. Statistics are measured at the network layer, so they
 * include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getTotalTxPackets() { throw new RuntimeException("Stub!"); }

/**
 * Return number of packets received since device boot. Counts packets
 * across all network interfaces, and always increases monotonically since
 * device boot. Statistics are measured at the network layer, so they
 * include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getTotalRxPackets() { throw new RuntimeException("Stub!"); }

/**
 * Return number of bytes transmitted since device boot. Counts packets
 * across all network interfaces, and always increases monotonically since
 * device boot. Statistics are measured at the network layer, so they
 * include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getTotalTxBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return number of bytes received since device boot. Counts packets across
 * all network interfaces, and always increases monotonically since device
 * boot. Statistics are measured at the network layer, so they include both
 * TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * @apiSince 8
 */

public static long getTotalRxBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return number of bytes transmitted by the given UID since device boot.
 * Counts packets across all network interfaces, and always increases
 * monotonically since device boot. Statistics are measured at the network
 * layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may
 * return {@link #UNSUPPORTED} on devices where statistics aren't available.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#N} this will only
 * report traffic statistics for the calling UID. It will return
 * {@link #UNSUPPORTED} for all other UIDs for privacy reasons. To access
 * historical network statistics belonging to other UIDs, use
 * {@link android.app.usage.NetworkStatsManager NetworkStatsManager}.
 *
 * @see android.os.Process#myUid()
 * @see android.content.pm.ApplicationInfo#uid
 * @apiSince 8
 */

public static long getUidTxBytes(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Return number of bytes received by the given UID since device boot.
 * Counts packets across all network interfaces, and always increases
 * monotonically since device boot. Statistics are measured at the network
 * layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may return
 * {@link #UNSUPPORTED} on devices where statistics aren't available.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#N} this will only
 * report traffic statistics for the calling UID. It will return
 * {@link #UNSUPPORTED} for all other UIDs for privacy reasons. To access
 * historical network statistics belonging to other UIDs, use
 * {@link android.app.usage.NetworkStatsManager NetworkStatsManager}.
 *
 * @see android.os.Process#myUid()
 * @see android.content.pm.ApplicationInfo#uid
 * @apiSince 8
 */

public static long getUidRxBytes(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Return number of packets transmitted by the given UID since device boot.
 * Counts packets across all network interfaces, and always increases
 * monotonically since device boot. Statistics are measured at the network
 * layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may return
 * {@link #UNSUPPORTED} on devices where statistics aren't available.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#N} this will only
 * report traffic statistics for the calling UID. It will return
 * {@link #UNSUPPORTED} for all other UIDs for privacy reasons. To access
 * historical network statistics belonging to other UIDs, use
 * {@link android.app.usage.NetworkStatsManager NetworkStatsManager}.
 *
 * @see android.os.Process#myUid()
 * @see android.content.pm.ApplicationInfo#uid
 * @apiSince 12
 */

public static long getUidTxPackets(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Return number of packets received by the given UID since device boot.
 * Counts packets across all network interfaces, and always increases
 * monotonically since device boot. Statistics are measured at the network
 * layer, so they include both TCP and UDP usage.
 * <p>
 * Before {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}, this may return
 * {@link #UNSUPPORTED} on devices where statistics aren't available.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#N} this will only
 * report traffic statistics for the calling UID. It will return
 * {@link #UNSUPPORTED} for all other UIDs for privacy reasons. To access
 * historical network statistics belonging to other UIDs, use
 * {@link android.app.usage.NetworkStatsManager NetworkStatsManager}.
 *
 * @see android.os.Process#myUid()
 * @see android.content.pm.ApplicationInfo#uid
 * @apiSince 12
 */

public static long getUidRxPackets(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidTxBytes(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidTcpTxBytes(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidRxBytes(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidTcpRxBytes(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidTxBytes(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidUdpTxBytes(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidRxBytes(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidUdpRxBytes(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidTxPackets(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidTcpTxSegments(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidRxPackets(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidTcpRxSegments(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidTxPackets(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidUdpTxPackets(int uid) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Starting in {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 *             transport layer statistics are no longer available, and will
 *             always return {@link #UNSUPPORTED}.
 * @see #getUidRxPackets(int)
 * @apiSince 12
 * @deprecatedSince 18
 */

@Deprecated
public static long getUidUdpRxPackets(int uid) { throw new RuntimeException("Stub!"); }

/**
 * The return value to indicate that the device does not support the statistic.
 * @apiSince 8
 */

public static final int UNSUPPORTED = -1; // 0xffffffff
}

