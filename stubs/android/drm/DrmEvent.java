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

import java.util.HashMap;

/**
 * A base class that is used to send asynchronous event information from the DRM framework.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrmEvent {

/**
 * Creates a <code>DrmEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of information.
 * @param message Message description.
 * @param attributes Attributes for extensible information.
 * @apiSince 12
 */

protected DrmEvent(int uniqueId, int type, java.lang.String message, java.util.HashMap<java.lang.String,java.lang.Object> attributes) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DrmEvent</code> object with the specified parameters.
 *
 * @param uniqueId Unique session identifier.
 * @param type Type of information.
 * @param message Message description.
 * @apiSince 11
 */

protected DrmEvent(int uniqueId, int type, java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the unique session identifier associated with this object.
 *
 * @return The unique session identifier.
 * @apiSince 11
 */

public int getUniqueId() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the type of information that is associated with this object.
 *
 * @return The type of information.
 * @apiSince 11
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the message description associated with this object.
 *
 * @return The message description.
 * @apiSince 11
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the attribute associated with the specified key.
 *
 * @return One of the attributes or null if no mapping for
 * the key is found.
 * @apiSince 12
 */

public java.lang.Object getAttribute(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * The key that is used in the <code>attributes</code> HashMap to pass the
 * {@link android.drm.DrmInfo DrmInfo} object.
 * @apiSince 12
 */

public static final java.lang.String DRM_INFO_OBJECT = "drm_info_object";

/**
 * The key that is used in the <code>attributes</code> HashMap to pass the return status.
 * @apiSince 11
 */

public static final java.lang.String DRM_INFO_STATUS_OBJECT = "drm_info_status_object";

/**
 * All of the rights information associated with all DRM schemes have been successfully removed.
 * @apiSince 11
 */

public static final int TYPE_ALL_RIGHTS_REMOVED = 1001; // 0x3e9

/**
 * The given DRM information has been successfully processed.
 * @apiSince 11
 */

public static final int TYPE_DRM_INFO_PROCESSED = 1002; // 0x3ea
}

