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


package android.telephony.mbms;

import android.telephony.MbmsStreamingSession;
import android.net.Uri;

/**
 * Class used to represent a single MBMS stream. After a stream has been started with
 * {@link android.telephony.MbmsStreamingSession#startStreaming(android.telephony.mbms.StreamingServiceInfo,java.util.concurrent.Executor,android.telephony.mbms.StreamingServiceCallback) MbmsStreamingSession#startStreaming(StreamingServiceInfo, java.util.concurrent.Executor,
 * StreamingServiceCallback)},
 * this class is used to hold information about the stream and control it.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StreamingService implements java.lang.AutoCloseable {

StreamingService() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the Uri used to play this stream.
 *
 * May throw an {@link java.lang.IllegalArgumentException IllegalArgumentException} or an {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * @return The {@link android.net.Uri Uri} to pass to the streaming client, or {@code null} if an error
 *         occurred.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.net.Uri getPlaybackUri() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link android.telephony.mbms.StreamingServiceInfo StreamingServiceInfo} corresponding to this stream.
 * @apiSince 28
 */

public android.telephony.mbms.StreamingServiceInfo getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Stop streaming this service. Further operations on this object will fail with an
 * {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * May throw an {@link java.lang.IllegalArgumentException IllegalArgumentException} or an {@link java.lang.IllegalStateException IllegalStateException}
 * @apiSince 28
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * The method of transmission currently used for a stream,
 * reported via {@link android.telephony.mbms.StreamingServiceCallback#onStreamMethodUpdated StreamingServiceCallback#onStreamMethodUpdated}
 * @apiSince 28
 */

public static final int BROADCAST_METHOD = 1; // 0x1

/**
 * State changed due to a call to {@link #close()} or
 * {@link android.telephony.MbmsStreamingSession#startStreaming(android.telephony.mbms.StreamingServiceInfo,java.util.concurrent.Executor,android.telephony.mbms.StreamingServiceCallback) MbmsStreamingSession#startStreaming(StreamingServiceInfo,
 * java.util.concurrent.Executor, StreamingServiceCallback)}
 * @apiSince 28
 */

public static final int REASON_BY_USER_REQUEST = 1; // 0x1

/**
 * State changed due to the streaming session ending at the carrier.
 * @apiSince 28
 */

public static final int REASON_END_OF_SESSION = 2; // 0x2

/**
 * State changed due to a frequency conflict with another requested stream.
 * @apiSince 28
 */

public static final int REASON_FREQUENCY_CONFLICT = 3; // 0x3

/**
 * State changed due to the device leaving the where this stream is being broadcast.
 * @apiSince 28
 */

public static final int REASON_LEFT_MBMS_BROADCAST_AREA = 6; // 0x6

/**
 * Indicates that the middleware does not have a reason to provide for the state change.
 * @apiSince 28
 */

public static final int REASON_NONE = 0; // 0x0

/**
 * State changed due to the device leaving the home carrier's LTE network.
 * @apiSince 28
 */

public static final int REASON_NOT_CONNECTED_TO_HOMECARRIER_LTE = 5; // 0x5

/**
 * State changed due to the middleware running out of memory
 * @apiSince 28
 */

public static final int REASON_OUT_OF_MEMORY = 4; // 0x4

/** @apiSince 28 */

public static final int STATE_STALLED = 3; // 0x3

/** @apiSince 28 */

public static final int STATE_STARTED = 2; // 0x2

/** @apiSince 28 */

public static final int STATE_STOPPED = 1; // 0x1

/** @apiSince 28 */

public static final int UNICAST_METHOD = 2; // 0x2
}

