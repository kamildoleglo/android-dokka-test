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


package android.telephony.mbms;

import android.telephony.MbmsGroupCallSession;

/**
 * Class used to represent a single MBMS group call. After a call has been started with
 * {@link android.telephony.MbmsGroupCallSession#startGroupCall MbmsGroupCallSession#startGroupCall},
 * this class is used to hold information about the call and control it.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GroupCall implements java.lang.AutoCloseable {

GroupCall() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the TMGI (Temporary Mobile Group Identity) corresponding to this call.
 * @apiSince 29
 */

public long getTmgi() { throw new RuntimeException("Stub!"); }

/**
 * Send an update to the middleware when the SAI (Service Area Identifier) list and frequency
 * information of the group call has * changed. Callers must obtain this information from the
 * wireless carrier independently.
 * @param saiList New list of SAIs that the call is available on.
 * This value must never be {@code null}.
 * @param frequencyList New list of frequencies that the call is available on.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void updateGroupCall(@androidx.annotation.NonNull java.util.List<java.lang.Integer> saiList, @androidx.annotation.NonNull java.util.List<java.lang.Integer> frequencyList) { throw new RuntimeException("Stub!"); }

/**
 * Stop this group call. Further operations on this object will fail with an
 * {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * May throw an {@link java.lang.IllegalStateException IllegalStateException}
 * @apiSince 29
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * State changed due to a call to {@link #close()} or
 * {@link android.telephony.MbmsGroupCallSession#startGroupCall MbmsGroupCallSession#startGroupCall}
 * @apiSince 29
 */

public static final int REASON_BY_USER_REQUEST = 1; // 0x1

/**
 * State changed due to a frequency conflict with another requested call.
 * @apiSince 29
 */

public static final int REASON_FREQUENCY_CONFLICT = 3; // 0x3

/**
 * State changed due to the device leaving the area where this call is being broadcast.
 * @apiSince 29
 */

public static final int REASON_LEFT_MBMS_BROADCAST_AREA = 6; // 0x6

/**
 * Indicates that the middleware does not have a reason to provide for the state change.
 * @apiSince 29
 */

public static final int REASON_NONE = 0; // 0x0

/**
 * State changed due to the device leaving the home carrier's LTE network.
 * @apiSince 29
 */

public static final int REASON_NOT_CONNECTED_TO_HOMECARRIER_LTE = 5; // 0x5

/**
 * State changed due to the middleware running out of memory
 * @apiSince 29
 */

public static final int REASON_OUT_OF_MEMORY = 4; // 0x4

/**
 * Indicates that the group call is stalled.
 *
 * This may be due to a network issue or the device being temporarily out of range.
 * @apiSince 29
 */

public static final int STATE_STALLED = 3; // 0x3

/**
 * Indicates that the group call is started.
 *
 * Data can be transmitted and received in this state.
 * @apiSince 29
 */

public static final int STATE_STARTED = 2; // 0x2

/**
 * Indicates that the group call is in a stopped state
 *
 * This can be reported after network action or after calling {@link #close}.
 * @apiSince 29
 */

public static final int STATE_STOPPED = 1; // 0x1
}

