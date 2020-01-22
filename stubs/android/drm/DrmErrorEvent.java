/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.drm;


/**
 * An entity class that is passed to the
 * {@link android.drm.DrmManagerClient.OnErrorListener#onError DrmManagerClient.OnErrorListener#onError} callback.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmErrorEvent extends android.drm.DrmEvent {

/**
 * Creates a <code>DrmErrorEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of the event. Must be any of the event types defined above.
 * @param message Message description. It can be null.
 * @apiSince 11
 */

public DrmErrorEvent(int uniqueId, int type, java.lang.String message) { super(0, 0, (java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmErrorEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of the event. Must be any of the event types defined above.
 * @param message Message description.
 * @param attributes Attributes for extensible information. Could be any
 * information provided by the plug-in. It can be null.
 * @apiSince 12
 */

public DrmErrorEvent(int uniqueId, int type, java.lang.String message, java.util.HashMap<java.lang.String,java.lang.Object> attributes) { super(0, 0, (java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Failed to acquire {@link android.drm.DrmInfo DrmInfo}. This error event is sent when an
 * {@link android.drm.DrmManagerClient#acquireDrmInfo DrmManagerClient#acquireDrmInfo} call fails.
 * @apiSince 12
 */

public static final int TYPE_ACQUIRE_DRM_INFO_FAILED = 2008; // 0x7d8

/**
 * Response from the server cannot be handled by the DRM plug-in (agent).
 * @apiSince 11
 */

public static final int TYPE_NOT_SUPPORTED = 2003; // 0x7d3

/**
 * An Internet connection is not available and no attempt can be made to renew rights.
 * @apiSince 11
 */

public static final int TYPE_NO_INTERNET_CONNECTION = 2005; // 0x7d5

/**
 * Memory allocation failed during renewal. Can in the future perhaps be used to trigger
 * garbage collector.
 * @apiSince 11
 */

public static final int TYPE_OUT_OF_MEMORY = 2004; // 0x7d4

/**
 * Failed to process {@link android.drm.DrmInfo DrmInfo}. This error event is sent when a
 * {@link android.drm.DrmManagerClient#processDrmInfo DrmManagerClient#processDrmInfo} call fails.
 * @apiSince 11
 */

public static final int TYPE_PROCESS_DRM_INFO_FAILED = 2006; // 0x7d6

/**
 * Failed to remove all the rights objects associated with all DRM schemes.
 * @apiSince 11
 */

public static final int TYPE_REMOVE_ALL_RIGHTS_FAILED = 2007; // 0x7d7

/**
 * Something went wrong installing the rights.
 * @apiSince 11
 */

public static final int TYPE_RIGHTS_NOT_INSTALLED = 2001; // 0x7d1

/**
 * The server rejected the renewal of rights.
 * @apiSince 11
 */

public static final int TYPE_RIGHTS_RENEWAL_NOT_ALLOWED = 2002; // 0x7d2
}

