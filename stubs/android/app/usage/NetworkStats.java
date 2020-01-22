/**
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package android.app.usage;


/**
 * Class providing enumeration over buckets of network usage statistics. {@link android.app.usage.NetworkStats NetworkStats} objects
 * are returned as results to various queries in {@link android.app.usage.NetworkStatsManager NetworkStatsManager}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NetworkStats implements java.lang.AutoCloseable {

NetworkStats() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Fills the recycled bucket with data of the next bin in the enumeration.
 * @param bucketOut Bucket to be filled with data.
 * @return true if successfully filled the bucket, false otherwise.
 * @apiSince 23
 */

public boolean getNextBucket(android.app.usage.NetworkStats.Bucket bucketOut) { throw new RuntimeException("Stub!"); }

/**
 * Check if it is possible to ask for a next bucket in the enumeration.
 * @return true if there is at least one more bucket.
 * @apiSince 23
 */

public boolean hasNextBucket() { throw new RuntimeException("Stub!"); }

/**
 * Closes the enumeration. Call this method before this object gets out of scope.
 * @apiSince 23
 */

public void close() { throw new RuntimeException("Stub!"); }
/**
 * Buckets are the smallest elements of a query result. As some dimensions of a result may be
 * aggregated (e.g. time or state) some values may be equal across all buckets.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Bucket {

/** @apiSince 23 */

public Bucket() { throw new RuntimeException("Stub!"); }

/**
 * Key of the bucket. Usually an app uid or one of the following special values:<p />
 * <ul>
 * <li>{@link #UID_REMOVED}</li>
 * <li>{@link #UID_TETHERING}</li>
 * <li>{@link android.os.Process#SYSTEM_UID}</li>
 * </ul>
 * @return Bucket key.
 * @apiSince 23
 */

public int getUid() { throw new RuntimeException("Stub!"); }

/**
 * Tag of the bucket.<p />
 * @return Bucket tag.
 * @apiSince 24
 */

public int getTag() { throw new RuntimeException("Stub!"); }

/**
 * Usage state. One of the following values:<p/>
 * <ul>
 * <li>{@link #STATE_ALL}</li>
 * <li>{@link #STATE_DEFAULT}</li>
 * <li>{@link #STATE_FOREGROUND}</li>
 * </ul>
 * @return Usage state.
 
 * Value is {@link android.app.usage.NetworkStats.Bucket#STATE_ALL}, {@link android.app.usage.NetworkStats.Bucket#STATE_DEFAULT}, or {@link android.app.usage.NetworkStats.Bucket#STATE_FOREGROUND}
 * @apiSince 23
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Metered state. One of the following values:<p/>
 * <ul>
 * <li>{@link #METERED_ALL}</li>
 * <li>{@link #METERED_NO}</li>
 * <li>{@link #METERED_YES}</li>
 * </ul>
 * <p>A network is classified as metered when the user is sensitive to heavy data usage on
 * that connection. Apps may warn before using these networks for large downloads. The
 * metered state can be set by the user within data usage network restrictions.
 
 * @return Value is {@link android.app.usage.NetworkStats.Bucket#METERED_ALL}, {@link android.app.usage.NetworkStats.Bucket#METERED_NO}, or {@link android.app.usage.NetworkStats.Bucket#METERED_YES}
 * @apiSince 26
 */

public int getMetered() { throw new RuntimeException("Stub!"); }

/**
 * Roaming state. One of the following values:<p/>
 * <ul>
 * <li>{@link #ROAMING_ALL}</li>
 * <li>{@link #ROAMING_NO}</li>
 * <li>{@link #ROAMING_YES}</li>
 * </ul>
 
 * @return Value is {@link android.app.usage.NetworkStats.Bucket#ROAMING_ALL}, {@link android.app.usage.NetworkStats.Bucket#ROAMING_NO}, or {@link android.app.usage.NetworkStats.Bucket#ROAMING_YES}
 * @apiSince 24
 */

public int getRoaming() { throw new RuntimeException("Stub!"); }

/**
 * Default network status. One of the following values:<p/>
 * <ul>
 * <li>{@link #DEFAULT_NETWORK_ALL}</li>
 * <li>{@link #DEFAULT_NETWORK_NO}</li>
 * <li>{@link #DEFAULT_NETWORK_YES}</li>
 * </ul>
 
 * @return Value is {@link android.app.usage.NetworkStats.Bucket#DEFAULT_NETWORK_ALL}, {@link android.app.usage.NetworkStats.Bucket#DEFAULT_NETWORK_NO}, or {@link android.app.usage.NetworkStats.Bucket#DEFAULT_NETWORK_YES}
 * @apiSince 28
 */

public int getDefaultNetworkStatus() { throw new RuntimeException("Stub!"); }

/**
 * Start timestamp of the bucket's time interval. Defined in terms of "Unix time", see
 * {@link java.lang.System#currentTimeMillis}.
 * @return Start of interval.
 * @apiSince 23
 */

public long getStartTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * End timestamp of the bucket's time interval. Defined in terms of "Unix time", see
 * {@link java.lang.System#currentTimeMillis}.
 * @return End of interval.
 * @apiSince 23
 */

public long getEndTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Number of bytes received during the bucket's time interval. Statistics are measured at
 * the network layer, so they include both TCP and UDP usage.
 * @return Number of bytes.
 * @apiSince 23
 */

public long getRxBytes() { throw new RuntimeException("Stub!"); }

/**
 * Number of bytes transmitted during the bucket's time interval. Statistics are measured at
 * the network layer, so they include both TCP and UDP usage.
 * @return Number of bytes.
 * @apiSince 23
 */

public long getTxBytes() { throw new RuntimeException("Stub!"); }

/**
 * Number of packets received during the bucket's time interval. Statistics are measured at
 * the network layer, so they include both TCP and UDP usage.
 * @return Number of packets.
 * @apiSince 23
 */

public long getRxPackets() { throw new RuntimeException("Stub!"); }

/**
 * Number of packets transmitted during the bucket's time interval. Statistics are measured
 * at the network layer, so they include both TCP and UDP usage.
 * @return Number of packets.
 * @apiSince 23
 */

public long getTxPackets() { throw new RuntimeException("Stub!"); }

/**
 * Combined usage for this network regardless of default network status.
 * @apiSince 28
 */

public static final int DEFAULT_NETWORK_ALL = -1; // 0xffffffff

/**
 * Usage that occurs while this network is not a default network.
 *
 * <p>This implies that the app responsible for this usage requested that it occur on a
 * specific network different from the one(s) the system would have selected for it.
 * @apiSince 28
 */

public static final int DEFAULT_NETWORK_NO = 1; // 0x1

/**
 * Usage that occurs while this network is a default network.
 *
 * <p>This implies that the app either did not select a specific network for this usage,
 * or it selected a network that the system could have selected for app traffic.
 * @apiSince 28
 */

public static final int DEFAULT_NETWORK_YES = 2; // 0x2

/**
 * Combined usage across all metered states. Covers metered and unmetered usage.
 * @apiSince 26
 */

public static final int METERED_ALL = -1; // 0xffffffff

/**
 * Usage that occurs on an unmetered network.
 * @apiSince 26
 */

public static final int METERED_NO = 1; // 0x1

/**
 * Usage that occurs on a metered network.
 *
 * <p>A network is classified as metered when the user is sensitive to heavy data usage on
 * that connection.
 * @apiSince 26
 */

public static final int METERED_YES = 2; // 0x2

/**
 * Combined usage across all roaming states. Covers both roaming and non-roaming usage.
 * @apiSince 24
 */

public static final int ROAMING_ALL = -1; // 0xffffffff

/**
 * Usage that occurs on a home, non-roaming network.
 *
 * <p>Any cellular usage in this bucket was incurred while the device was connected to a
 * tower owned or operated by the user's wireless carrier, or a tower that the user's
 * wireless carrier has indicated should be treated as a home network regardless.
 *
 * <p>This is also the default value for network types that do not support roaming.
 * @apiSince 24
 */

public static final int ROAMING_NO = 1; // 0x1

/**
 * Usage that occurs on a roaming network.
 *
 * <p>Any cellular usage in this bucket as incurred while the device was roaming on another
 * carrier's network, for which additional charges may apply.
 * @apiSince 24
 */

public static final int ROAMING_YES = 2; // 0x2

/**
 * Combined usage across all states.
 * @apiSince 23
 */

public static final int STATE_ALL = -1; // 0xffffffff

/**
 * Usage not accounted for in any other state.
 * @apiSince 23
 */

public static final int STATE_DEFAULT = 1; // 0x1

/**
 * Foreground usage.
 * @apiSince 23
 */

public static final int STATE_FOREGROUND = 2; // 0x2

/**
 * Special TAG value for total data across all tags
 * @apiSince 24
 */

public static final int TAG_NONE = 0; // 0x0

/**
 * Special UID value for aggregate/unspecified.
 * @apiSince 23
 */

public static final int UID_ALL = -1; // 0xffffffff

/**
 * Special UID value for removed apps.
 * @apiSince 23
 */

public static final int UID_REMOVED = -4; // 0xfffffffc

/**
 * Special UID value for data usage by tethering.
 * @apiSince 23
 */

public static final int UID_TETHERING = -5; // 0xfffffffb
}

}

